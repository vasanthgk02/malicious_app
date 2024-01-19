package java8.util.concurrent;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.Thread.State;
import java.lang.Thread.UncaughtExceptionHandler;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java8.util.concurrent.CompletableFuture.Signaller;
import java8.util.concurrent.FJTask.AdaptedCallable;
import java8.util.concurrent.FJTask.AdaptedRunnable;
import java8.util.concurrent.FJTask.AdaptedRunnableAction;
import java8.util.concurrent.FJTask.RunnableExecuteAction;
import java8.util.concurrent.FJWorkerThread.InnocuousForkJoinWorkerThread;
import org.jboss.netty.util.internal.ThreadLocalRandom;
import sun.misc.Unsafe;

public final class FJPool extends AbstractExecutorService {
    public static final int ABASE;
    public static final int ASHIFT;
    public static final int COMMON_MAX_SPARES;
    public static final int COMMON_PARALLELISM;
    public static final long CTL;
    public static final long MODE;
    public static final Unsafe U;
    public static final FJPool common;
    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory = new DefaultForkJoinWorkerThreadFactory();
    public static final RuntimePermission modifyThreadPermission = new RuntimePermission("modifyThread");
    public final int bounds;
    public volatile long ctl;
    public final ForkJoinWorkerThreadFactory factory;
    public int indexSeed;
    public final long keepAlive;
    public volatile int mode;
    public final Predicate<? super FJPool> saturate;
    public volatile long stealCount;
    public final UncaughtExceptionHandler ueh;
    public WorkQueue[] workQueues;
    public final String workerNamePrefix;

    public static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        public static final AccessControlContext ACC = FJPool.contextWithPermissions(new RuntimePermission("getClassLoader"));

        public final FJWorkerThread newThread(final FJPool fJPool) {
            return (FJWorkerThread) AccessController.doPrivileged(new PrivilegedAction<FJWorkerThread>(this) {
                public Object run() {
                    return new FJWorkerThread(fJPool, ClassLoader.getSystemClassLoader());
                }
            }, ACC);
        }
    }

    public interface ForkJoinWorkerThreadFactory {
        FJWorkerThread newThread(FJPool fJPool);
    }

    public static final class InnocuousForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        public static final AccessControlContext ACC = FJPool.contextWithPermissions(FJPool.modifyThreadPermission, new RuntimePermission("enableContextClassLoaderOverride"), new RuntimePermission("modifyThreadGroup"), new RuntimePermission("getClassLoader"), new RuntimePermission("setContextClassLoader"));

        public final FJWorkerThread newThread(final FJPool fJPool) {
            return (FJWorkerThread) AccessController.doPrivileged(new PrivilegedAction<FJWorkerThread>(this) {
                public Object run() {
                    return new InnocuousForkJoinWorkerThread(fJPool);
                }
            }, ACC);
        }
    }

    public interface ManagedBlocker {
    }

    public static final class MemBar {
        public static final long OFF;
        public static final Unsafe U;
        public static final Blank x = new Blank();

        static {
            Unsafe unsafe = UnsafeAcc.unsafe;
            U = unsafe;
            try {
                OFF = unsafe.objectFieldOffset(Blank.class.getDeclaredField("v"));
            } catch (Exception e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }

        public static void fullFence() {
            U.putIntVolatile(x, OFF, 0);
        }

        public static void storeFence() {
            U.putOrderedInt(x, OFF, 0);
        }
    }

    public static final class WorkQueue {
        public static final int ABASE;
        public static final int ASHIFT;
        public static final long PHASE;
        public static final Unsafe U;
        public FJTask<?>[] array;
        public volatile int base = 4096;
        public int id;
        public int nsteals;
        public final FJWorkerThread owner;
        public volatile int phase;
        public final FJPool pool;
        public volatile int source;
        public int stackPred;
        public int top = 4096;

        static {
            Unsafe unsafe = UnsafeAcc.unsafe;
            U = unsafe;
            try {
                PHASE = unsafe.objectFieldOffset(WorkQueue.class.getDeclaredField("phase"));
                ABASE = U.arrayBaseOffset(FJTask[].class);
                int arrayIndexScale = U.arrayIndexScale(FJTask[].class);
                if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                    ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                    return;
                }
                throw new ExceptionInInitializerError("array index scale not a power of two");
            } catch (Exception e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }

        public WorkQueue(FJPool fJPool, FJWorkerThread fJWorkerThread) {
            this.pool = fJPool;
            this.owner = fJWorkerThread;
        }

        public final FJTask<?>[] growArray() {
            FJTask<?>[] fJTaskArr = this.array;
            int length = fJTaskArr != null ? fJTaskArr.length : 0;
            int i = length > 0 ? length << 1 : 8192;
            if (i < 8192 || i > 67108864) {
                throw new RejectedExecutionException("Queue capacity exceeded");
            }
            FJTask<?>[] fJTaskArr2 = new FJTask[i];
            this.array = fJTaskArr2;
            if (fJTaskArr != null) {
                int i2 = length - 1;
                if (i2 > 0) {
                    int i3 = this.top;
                    int i4 = this.base;
                    if (i3 - i4 > 0) {
                        int i5 = i - 1;
                        int i6 = i4;
                        do {
                            long j = ((long) ABASE) + (((long) (i6 & i2)) << ASHIFT);
                            FJTask<?> fJTask = (FJTask) U.getObjectVolatile(fJTaskArr, j);
                            if (fJTask != null && U.compareAndSwapObject(fJTaskArr, j, fJTask, null)) {
                                fJTaskArr2[i6 & i5] = fJTask;
                            }
                            i6++;
                        } while (i6 != i3);
                        MemBar.storeFence();
                    }
                }
            }
            return fJTaskArr2;
        }

        public final void localPollAndExec(int i) {
            int i2;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.base;
                    int i5 = this.top;
                    FJTask<?>[] fJTaskArr = this.array;
                    if (fJTaskArr != null) {
                        i2 = i4 - i5;
                        if (i2 < 0) {
                            int length = fJTaskArr.length;
                            if (length > 0) {
                                int i6 = i4 + 1;
                                FJTask fJTask = (FJTask) FJPool.getAndSetObject(fJTaskArr, (((long) (i4 & (length - 1))) << ASHIFT) + ((long) ABASE), null);
                                if (fJTask != null) {
                                    this.base = i6;
                                    fJTask.doExec();
                                    if (i != 0) {
                                        i3++;
                                        if (i3 == i) {
                                            return;
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (i2 != -1);
        }

        public final void localPopAndExec(int i) {
            while (true) {
                int i2 = this.base;
                int i3 = this.top;
                FJTask<?>[] fJTaskArr = this.array;
                if (fJTaskArr != null && i2 != i3) {
                    if (fJTaskArr.length > 0) {
                        int i4 = i3 - 1;
                        FJTask fJTask = (FJTask) FJPool.getAndSetObject(fJTaskArr, (((long) ((r0 - 1) & i4)) << ASHIFT) + ((long) ABASE), null);
                        if (fJTask != null) {
                            this.top = i4;
                            MemBar.storeFence();
                            fJTask.doExec();
                            if (i != 0) {
                                i--;
                                if (i == 0) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final FJTask<?> poll() {
            while (true) {
                int i = this.base;
                int i2 = this.top;
                FJTask<?>[] fJTaskArr = this.array;
                if (fJTaskArr == null) {
                    break;
                }
                int i3 = i - i2;
                if (i3 >= 0) {
                    break;
                }
                int length = fJTaskArr.length;
                if (length <= 0) {
                    break;
                }
                long j = (((long) ((length - 1) & i)) << ASHIFT) + ((long) ABASE);
                FJTask<?> fJTask = (FJTask) U.getObjectVolatile(fJTaskArr, j);
                int i4 = i + 1;
                if (i == this.base) {
                    if (fJTask != null) {
                        if (U.compareAndSwapObject(fJTaskArr, j, fJTask, null)) {
                            this.base = i4;
                            return fJTask;
                        }
                    } else if (i3 == -1) {
                        break;
                    }
                }
            }
            return null;
        }

        public final void push(FJTask<?> fJTask) {
            int i = this.top;
            FJTask<?>[] fJTaskArr = this.array;
            if (fJTaskArr != null) {
                int length = fJTaskArr.length;
                if (length > 0) {
                    long j = (((long) ((length - 1) & i)) << ASHIFT) + ((long) ABASE);
                    FJPool fJPool = this.pool;
                    this.top = i + 1;
                    U.putOrderedObject(fJTaskArr, j, fJTask);
                    int i2 = this.base - i;
                    if (i2 == 0 && fJPool != null) {
                        MemBar.fullFence();
                        fJPool.signalWork();
                    } else if (i2 + length == 1) {
                        growArray();
                    }
                }
            }
        }

        public final boolean tryLockSharedQueue() {
            return U.compareAndSwapInt(this, PHASE, 0, 1);
        }

        public final void tryRemoveAndExec(FJTask<?> fJTask) {
            int i = this.base;
            int i2 = this.top;
            if (i - i2 < 0) {
                FJTask<?>[] fJTaskArr = this.array;
                if (fJTaskArr != null) {
                    int length = fJTaskArr.length;
                    if (length > 0) {
                        int i3 = length - 1;
                        int i4 = i2 - 1;
                        int i5 = i4;
                        while (true) {
                            long j = (long) (((i5 & i3) << ASHIFT) + ABASE);
                            FJTask<?> fJTask2 = (FJTask) U.getObject(fJTaskArr, j);
                            if (fJTask2 != null) {
                                if (fJTask2 != fJTask) {
                                    i5--;
                                } else if (U.compareAndSwapObject(fJTaskArr, j, fJTask2, null)) {
                                    this.top = i4;
                                    while (i5 != i4) {
                                        int i6 = i5 + 1;
                                        long j2 = (long) (((i6 & i3) << ASHIFT) + ABASE);
                                        U.putObjectVolatile(fJTaskArr, j2, null);
                                        U.putOrderedObject(fJTaskArr, (long) (((i5 & i3) << ASHIFT) + ABASE), (FJTask) U.getObject(fJTaskArr, j2));
                                        i5 = i6;
                                    }
                                    MemBar.storeFence();
                                    fJTask2.doExec();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public final boolean trySharedUnpush(FJTask<?> fJTask) {
            boolean z = true;
            int i = this.top - 1;
            FJTask<?>[] fJTaskArr = this.array;
            if (fJTaskArr == null) {
                return false;
            }
            int length = fJTaskArr.length;
            if (length <= 0) {
                return false;
            }
            long j = (((long) ((length - 1) & i)) << ASHIFT) + ((long) ABASE);
            if (((FJTask) U.getObject(fJTaskArr, j)) != fJTask) {
                return false;
            }
            if (!U.compareAndSwapInt(this, PHASE, 0, 1)) {
                return false;
            }
            if (this.top == i + 1 && this.array == fJTaskArr && U.compareAndSwapObject(fJTaskArr, j, fJTask, null)) {
                this.top = i;
            } else {
                z = false;
            }
            U.putOrderedInt(this, PHASE, 0);
            return z;
        }

        public final boolean tryUnpush(FJTask<?> fJTask) {
            int i = this.base;
            int i2 = this.top;
            FJTask<?>[] fJTaskArr = this.array;
            if (!(fJTaskArr == null || i == i2)) {
                int length = fJTaskArr.length;
                if (length > 0) {
                    int i3 = i2 - 1;
                    if (U.compareAndSwapObject(fJTaskArr, (((long) ((length - 1) & i3)) << ASHIFT) + ((long) ABASE), fJTask, null)) {
                        this.top = i3;
                        MemBar.storeFence();
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static {
        Unsafe unsafe = UnsafeAcc.unsafe;
        U = unsafe;
        try {
            CTL = unsafe.objectFieldOffset(FJPool.class.getDeclaredField("ctl"));
            MODE = U.objectFieldOffset(FJPool.class.getDeclaredField("mode"));
            ABASE = U.arrayBaseOffset(FJTask[].class);
            int arrayIndexScale = U.arrayIndexScale(FJTask[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                Class<LockSupport> cls = LockSupport.class;
                int i = 256;
                try {
                    String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
                    if (property != null) {
                        i = Integer.parseInt(property);
                    }
                } catch (Exception unused) {
                }
                COMMON_MAX_SPARES = i;
                FJPool fJPool = (FJPool) AccessController.doPrivileged(new PrivilegedAction<FJPool>() {
                    public Object run() {
                        return new FJPool();
                    }
                });
                common = fJPool;
                COMMON_PARALLELISM = Math.max(fJPool.mode & 65535, 1);
                return;
            }
            throw new ExceptionInInitializerError("array index scale not a power of two");
        } catch (Exception e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FJPool() {
        /*
            r11 = this;
            r11.<init>()
            r0 = 0
            r1 = -1
            java.lang.String r2 = "java.util.concurrent.ForkJoinPool.common.parallelism"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0011
            int r1 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0022 }
        L_0x0011:
            java.lang.String r2 = "java.util.concurrent.ForkJoinPool.common.threadFactory"
            java.lang.Object r2 = newInstanceFromSystemProperty(r2)     // Catch:{ Exception -> 0x0022 }
            java8.util.concurrent.FJPool$ForkJoinWorkerThreadFactory r2 = (java8.util.concurrent.FJPool.ForkJoinWorkerThreadFactory) r2     // Catch:{ Exception -> 0x0022 }
            java.lang.String r3 = "java.util.concurrent.ForkJoinPool.common.exceptionHandler"
            java.lang.Object r3 = newInstanceFromSystemProperty(r3)     // Catch:{ Exception -> 0x0023 }
            java.lang.Thread$UncaughtExceptionHandler r3 = (java.lang.Thread.UncaughtExceptionHandler) r3     // Catch:{ Exception -> 0x0023 }
            goto L_0x0024
        L_0x0022:
            r2 = r0
        L_0x0023:
            r3 = r0
        L_0x0024:
            if (r2 != 0) goto L_0x0034
            java.lang.SecurityManager r2 = java.lang.System.getSecurityManager()
            if (r2 != 0) goto L_0x002f
            java8.util.concurrent.FJPool$ForkJoinWorkerThreadFactory r2 = defaultForkJoinWorkerThreadFactory
            goto L_0x0034
        L_0x002f:
            java8.util.concurrent.FJPool$InnocuousForkJoinWorkerThreadFactory r2 = new java8.util.concurrent.FJPool$InnocuousForkJoinWorkerThreadFactory
            r2.<init>()
        L_0x0034:
            r4 = 1
            if (r1 >= 0) goto L_0x0043
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()
            int r1 = r1.availableProcessors()
            int r1 = r1 - r4
            if (r1 > 0) goto L_0x0043
            r1 = 1
        L_0x0043:
            r5 = 32767(0x7fff, float:4.5916E-41)
            if (r1 <= r5) goto L_0x0049
            r1 = 32767(0x7fff, float:4.5916E-41)
        L_0x0049:
            int r5 = -r1
            long r5 = (long) r5
            r7 = 32
            long r7 = r5 << r7
            r9 = 281470681743360(0xffff00000000, double:1.39064994160909E-309)
            long r7 = r7 & r9
            r9 = 48
            long r5 = r5 << r9
            r9 = -281474976710656(0xffff000000000000, double:NaN)
            long r5 = r5 & r9
            long r5 = r5 | r7
            int r7 = 1 - r1
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            int r8 = COMMON_MAX_SPARES
            int r8 = r8 << 16
            r7 = r7 | r8
            if (r1 <= r4) goto L_0x006c
            int r8 = r1 + -1
            goto L_0x006d
        L_0x006c:
            r8 = 1
        L_0x006d:
            int r9 = r8 >>> 1
            r8 = r8 | r9
            int r9 = r8 >>> 2
            r8 = r8 | r9
            int r9 = r8 >>> 4
            r8 = r8 | r9
            int r9 = r8 >>> 8
            r8 = r8 | r9
            int r9 = r8 >>> 16
            r8 = r8 | r9
            int r8 = r8 + r4
            int r4 = r8 << 1
            java.lang.String r8 = "FJPool.commonPool-worker-"
            r11.workerNamePrefix = r8
            java8.util.concurrent.FJPool$WorkQueue[] r4 = new java8.util.concurrent.FJPool.WorkQueue[r4]
            r11.workQueues = r4
            r11.factory = r2
            r11.ueh = r3
            r11.saturate = r0
            r2 = 60000(0xea60, double:2.9644E-319)
            r11.keepAlive = r2
            r11.bounds = r7
            r11.mode = r1
            r11.ctl = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.<init>():void");
    }

    public static AccessControlContext contextWithPermissions(Permission... permissionArr) {
        Permissions permissions = new Permissions();
        for (Permission add : permissionArr) {
            permissions.add(add);
        }
        return new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, permissions)});
    }

    public static long getAndAddLong(Object obj, long j, long j2) {
        long longVolatile;
        do {
            longVolatile = U.getLongVolatile(obj, j);
        } while (!U.compareAndSwapLong(obj, j, longVolatile, longVolatile + j2));
        return longVolatile;
    }

    public static Object getAndSetObject(Object obj, long j, Object obj2) {
        Object objectVolatile;
        do {
            objectVolatile = U.getObjectVolatile(obj, j);
        } while (!U.compareAndSwapObject(obj, j, objectVolatile, null));
        return objectVolatile;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:33:0x002f, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void helpAsyncBlocker(java.util.concurrent.Executor r11, java8.util.concurrent.FJPool.ManagedBlocker r12) {
        /*
            boolean r0 = r11 instanceof java8.util.concurrent.FJPool
            if (r0 == 0) goto L_0x007c
            java8.util.concurrent.FJPool r11 = (java8.util.concurrent.FJPool) r11
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof java8.util.concurrent.FJWorkerThread
            r2 = -1
            if (r1 == 0) goto L_0x0018
            java8.util.concurrent.FJWorkerThread r0 = (java8.util.concurrent.FJWorkerThread) r0
            java8.util.concurrent.FJPool r1 = r0.pool
            if (r1 != r11) goto L_0x0018
            java8.util.concurrent.FJPool$WorkQueue r11 = r0.workQueue
            goto L_0x002d
        L_0x0018:
            int r0 = java8.util.concurrent.TLR.getProbe()
            if (r0 == 0) goto L_0x002c
            java8.util.concurrent.FJPool$WorkQueue[] r11 = r11.workQueues
            if (r11 == 0) goto L_0x002c
            int r1 = r11.length
            if (r1 <= 0) goto L_0x002c
            int r1 = r1 + r2
            r0 = r0 & r1
            r0 = r0 & 126(0x7e, float:1.77E-43)
            r11 = r11[r0]
            goto L_0x002d
        L_0x002c:
            r11 = 0
        L_0x002d:
            if (r11 == 0) goto L_0x007c
        L_0x002f:
            int r0 = r11.base
            int r1 = r11.top
            java8.util.concurrent.FJTask<?>[] r4 = r11.array
            if (r4 == 0) goto L_0x007c
            int r1 = r0 - r1
            if (r1 >= 0) goto L_0x007c
            int r3 = r4.length
            if (r3 <= 0) goto L_0x007c
            int r3 = r3 + -1
            r3 = r3 & r0
            long r5 = (long) r3
            int r3 = ASHIFT
            long r5 = r5 << r3
            int r3 = ABASE
            long r7 = (long) r3
            long r5 = r5 + r7
            sun.misc.Unsafe r3 = U
            java.lang.Object r3 = r3.getObjectVolatile(r4, r5)
            r9 = r3
            java8.util.concurrent.FJTask r9 = (java8.util.concurrent.FJTask) r9
            r3 = r12
            java8.util.concurrent.CompletableFuture$Signaller r3 = (java8.util.concurrent.CompletableFuture.Signaller) r3
            boolean r3 = r3.isReleasable()
            if (r3 == 0) goto L_0x005c
            goto L_0x007c
        L_0x005c:
            int r10 = r0 + 1
            int r3 = r11.base
            if (r0 != r3) goto L_0x002f
            if (r9 != 0) goto L_0x0067
            if (r1 != r2) goto L_0x002f
            goto L_0x007c
        L_0x0067:
            boolean r0 = r9 instanceof java8.util.concurrent.CompletableFuture.AsynchronousCompletionTask
            if (r0 != 0) goto L_0x006c
            goto L_0x007c
        L_0x006c:
            sun.misc.Unsafe r3 = U
            r8 = 0
            r7 = r9
            boolean r0 = r3.compareAndSwapObject(r4, r5, r7, r8)
            if (r0 == 0) goto L_0x002f
            r11.base = r10
            r9.doExec()
            goto L_0x002f
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.helpAsyncBlocker(java.util.concurrent.Executor, java8.util.concurrent.FJPool$ManagedBlocker):void");
    }

    public static void managedBlock(ManagedBlocker managedBlocker) throws InterruptedException {
        Signaller signaller;
        int tryCompensate;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) currentThread;
            FJPool fJPool = fJWorkerThread.pool;
            if (fJPool != null) {
                WorkQueue workQueue = fJWorkerThread.workQueue;
                if (workQueue != null) {
                    do {
                        signaller = (Signaller) managedBlocker;
                        if (!signaller.isReleasable()) {
                            tryCompensate = fJPool.tryCompensate(workQueue);
                        } else {
                            return;
                        }
                    } while (tryCompensate == 0);
                    long j = 281474976710656L;
                    try {
                        if (!signaller.isReleasable()) {
                            signaller.block();
                        }
                        return;
                    } finally {
                        long j2 = CTL;
                        if (tryCompensate <= 0) {
                            j = 0;
                        }
                        getAndAddLong(fJPool, j2, j);
                    }
                }
            }
        }
        Signaller signaller2 = (Signaller) managedBlocker;
        if (!signaller2.isReleasable()) {
            signaller2.block();
        }
    }

    public static Object newInstanceFromSystemProperty(String str) throws Exception {
        String property = System.getProperty(str);
        if (property == null) {
            return null;
        }
        return ClassLoader.getSystemClassLoader().loadClass(property).getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    public static <R> R rethrow(Throwable th) {
        throw th;
    }

    public final int awaitJoin(WorkQueue workQueue, FJTask<?> fJTask, long j) {
        long j2;
        WorkQueue workQueue2 = workQueue;
        FJTask<?> fJTask2 = fJTask;
        if (workQueue2 == null) {
            return 0;
        }
        workQueue.tryRemoveAndExec(fJTask);
        int i = workQueue2.source;
        int i2 = workQueue2.id;
        int i3 = fJTask2.status;
        while (i3 >= 0) {
            boolean z = true;
            int nextSecondarySeed = TLR.nextSecondarySeed() | 1;
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                int length = workQueueArr.length;
                int i4 = length - 1;
                int i5 = -length;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = (nextSecondarySeed + i5) & i4;
                    if (i6 >= 0 && i6 < length) {
                        WorkQueue workQueue3 = workQueueArr[i6];
                        if (workQueue3 != null && workQueue3.source == i2) {
                            int i7 = workQueue3.base;
                            if (i7 - workQueue3.top < 0) {
                                FJTask<?>[] fJTaskArr = workQueue3.array;
                                if (fJTaskArr != null) {
                                    if (fJTaskArr.length > 0) {
                                        int i8 = workQueue3.id;
                                        long j3 = (((long) ((r15 - 1) & i7)) << ASHIFT) + ((long) ABASE);
                                        FJTask fJTask3 = (FJTask) U.getObjectVolatile(fJTaskArr, j3);
                                        if (fJTask3 != null) {
                                            int i9 = i7 + 1;
                                            if (i7 == workQueue3.base && i2 == workQueue3.source && U.compareAndSwapObject(fJTaskArr, j3, fJTask3, null)) {
                                                workQueue3.base = i9;
                                                workQueue2.source = i8;
                                                fJTask3.doExec();
                                                workQueue2.source = i;
                                            }
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    i5 += 2;
                }
            }
            z = false;
            i3 = fJTask2.status;
            if (i3 < 0) {
                break;
            } else if (!z) {
                long j4 = 0;
                if (j == 0) {
                    j2 = 0;
                } else {
                    long nanoTime = j - System.nanoTime();
                    if (nanoTime <= 0) {
                        break;
                    }
                    j2 = TimeUnit.NANOSECONDS.toMillis(nanoTime);
                    if (j2 <= 0) {
                        j2 = 1;
                    }
                }
                int tryCompensate = tryCompensate(workQueue);
                if (tryCompensate != 0) {
                    fJTask2.internalWait(j2);
                    long j5 = CTL;
                    if (tryCompensate > 0) {
                        j4 = 281474976710656L;
                    }
                    getAndAddLong(this, j5, j4);
                }
                i3 = fJTask2.status;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        r11 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean awaitTermination(long r11, java.util.concurrent.TimeUnit r13) throws java.lang.InterruptedException {
        /*
            r10 = this;
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x00c4
            java8.util.concurrent.FJPool r0 = common
            r1 = 1
            r2 = 0
            if (r10 != r0) goto L_0x0084
            long r3 = r13.toNanos(r11)
            java.lang.Thread r11 = java.lang.Thread.currentThread()
            boolean r12 = r11 instanceof java8.util.concurrent.FJWorkerThread
            if (r12 == 0) goto L_0x0024
            java8.util.concurrent.FJWorkerThread r11 = (java8.util.concurrent.FJWorkerThread) r11
            java8.util.concurrent.FJPool r12 = r11.pool
            if (r12 != r10) goto L_0x0024
            java8.util.concurrent.FJPool$WorkQueue r11 = r11.workQueue
            r10.helpQuiescePool(r11)
            goto L_0x007f
        L_0x0024:
            long r5 = java.lang.System.nanoTime()
        L_0x0028:
            java8.util.concurrent.FJTask r11 = r10.pollScan(r2)
            if (r11 == 0) goto L_0x0032
            r11.doExec()
            goto L_0x0028
        L_0x0032:
            long r11 = r10.ctl
            int r13 = r10.mode
            r0 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r13
            r7 = 32
            long r7 = r11 >>> r7
            int r8 = (int) r7
            short r7 = (short) r8
            int r7 = r7 + r0
            r8 = 48
            long r8 = r11 >> r8
            int r9 = (int) r8
            int r0 = r0 + r9
            r8 = -2146959360(0xffffffff80080000, float:-7.34684E-40)
            r13 = r13 & r8
            if (r13 == 0) goto L_0x004d
            goto L_0x0072
        L_0x004d:
            if (r0 <= 0) goto L_0x0050
            goto L_0x0063
        L_0x0050:
            java8.util.concurrent.FJPool$WorkQueue[] r13 = r10.workQueues
            if (r13 == 0) goto L_0x006a
            r0 = 1
        L_0x0055:
            int r8 = r13.length
            if (r0 >= r8) goto L_0x006a
            r8 = r13[r0]
            if (r8 == 0) goto L_0x0067
            int r8 = r8.source
            r9 = 1073741824(0x40000000, float:2.0)
            r8 = r8 & r9
            if (r8 != 0) goto L_0x0065
        L_0x0063:
            r11 = 0
            goto L_0x0073
        L_0x0065:
            int r7 = r7 + -1
        L_0x0067:
            int r0 = r0 + 2
            goto L_0x0055
        L_0x006a:
            if (r7 != 0) goto L_0x0032
            long r7 = r10.ctl
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0032
        L_0x0072:
            r11 = 1
        L_0x0073:
            if (r11 == 0) goto L_0x0076
            goto L_0x007f
        L_0x0076:
            long r11 = java.lang.System.nanoTime()
            long r11 = r11 - r5
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0080
        L_0x007f:
            return r2
        L_0x0080:
            java.lang.Thread.yield()
            goto L_0x0028
        L_0x0084:
            long r11 = r13.toNanos(r11)
            boolean r13 = r10.isTerminated()
            if (r13 == 0) goto L_0x008f
            return r1
        L_0x008f:
            r3 = 0
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 > 0) goto L_0x0096
            return r2
        L_0x0096:
            long r5 = java.lang.System.nanoTime()
            long r5 = r5 + r11
            monitor-enter(r10)
        L_0x009c:
            boolean r13 = r10.isTerminated()     // Catch:{ all -> 0x00c1 }
            if (r13 == 0) goto L_0x00a4
            monitor-exit(r10)     // Catch:{ all -> 0x00c1 }
            return r1
        L_0x00a4:
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 > 0) goto L_0x00aa
            monitor-exit(r10)     // Catch:{ all -> 0x00c1 }
            return r2
        L_0x00aa:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00c1 }
            long r11 = r13.toMillis(r11)     // Catch:{ all -> 0x00c1 }
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r11 = 1
        L_0x00b7:
            r10.wait(r11)     // Catch:{ all -> 0x00c1 }
            long r11 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00c1 }
            long r11 = r5 - r11
            goto L_0x009c
        L_0x00c1:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00c1 }
            throw r11
        L_0x00c4:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.awaitTermination(long, java.util.concurrent.TimeUnit):boolean");
    }

    public final boolean createWorker() {
        FJWorkerThread fJWorkerThread;
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
        Throwable th = null;
        if (forkJoinWorkerThreadFactory != null) {
            try {
                fJWorkerThread = forkJoinWorkerThreadFactory.newThread(this);
                if (fJWorkerThread != null) {
                    try {
                        fJWorkerThread.start();
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fJWorkerThread = null;
            }
        } else {
            fJWorkerThread = null;
        }
        deregisterWorker(fJWorkerThread, th);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[LOOP:0: B:26:0x0040->B:27:0x0065, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069 A[LOOP:1: B:29:0x0069->B:31:0x006f, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void deregisterWorker(java8.util.concurrent.FJWorkerThread r19, java.lang.Throwable r20) {
        /*
            r18 = this;
            r9 = r18
            r0 = r19
            r10 = 0
            r11 = 0
            r12 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r0 == 0) goto L_0x003a
            java8.util.concurrent.FJPool$WorkQueue r0 = r0.workQueue
            if (r0 == 0) goto L_0x003b
            java.lang.String r1 = r9.workerNamePrefix
            int r2 = r0.nsteals
            long r2 = (long) r2
            long r2 = r2 & r12
            int r4 = r0.id
            r5 = 65535(0xffff, float:9.1834E-41)
            r4 = r4 & r5
            if (r1 == 0) goto L_0x0037
            monitor-enter(r1)
            java8.util.concurrent.FJPool$WorkQueue[] r5 = r9.workQueues     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x002d
            int r6 = r5.length     // Catch:{ all -> 0x0034 }
            if (r6 <= r4) goto L_0x002d
            r6 = r5[r4]     // Catch:{ all -> 0x0034 }
            if (r6 != r0) goto L_0x002d
            r5[r4] = r10     // Catch:{ all -> 0x0034 }
        L_0x002d:
            long r4 = r9.stealCount     // Catch:{ all -> 0x0034 }
            long r4 = r4 + r2
            r9.stealCount = r4     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            throw r0
        L_0x0037:
            int r1 = r0.phase
            goto L_0x003c
        L_0x003a:
            r0 = r10
        L_0x003b:
            r1 = 0
        L_0x003c:
            r2 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L_0x0067
        L_0x0040:
            sun.misc.Unsafe r1 = U
            long r3 = CTL
            long r5 = r9.ctl
            r7 = -281474976710656(0xffff000000000000, double:NaN)
            r14 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r14 = r5 - r14
            long r7 = r7 & r14
            r14 = 281470681743360(0xffff00000000, double:1.39064994160909E-309)
            r16 = 4294967296(0x100000000, double:2.121995791E-314)
            long r16 = r5 - r16
            long r14 = r16 & r14
            long r7 = r7 | r14
            long r14 = r5 & r12
            long r7 = r7 | r14
            r2 = r18
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 == 0) goto L_0x0040
        L_0x0067:
            if (r0 == 0) goto L_0x0073
        L_0x0069:
            java8.util.concurrent.FJTask r1 = r0.poll()
            if (r1 == 0) goto L_0x0073
            java8.util.concurrent.FJTask.cancelIgnoringExceptions(r1)
            goto L_0x0069
        L_0x0073:
            boolean r1 = r9.tryTerminate(r11, r11)
            if (r1 != 0) goto L_0x0082
            if (r0 == 0) goto L_0x0082
            java8.util.concurrent.FJTask<?>[] r0 = r0.array
            if (r0 == 0) goto L_0x0082
            r18.signalWork()
        L_0x0082:
            if (r20 != 0) goto L_0x009a
            java.util.concurrent.locks.ReentrantLock r1 = java8.util.concurrent.FJTask.exceptionTableLock
            boolean r0 = r1.tryLock()
            if (r0 == 0) goto L_0x0099
            java8.util.concurrent.FJTask.expungeStaleExceptions()     // Catch:{ all -> 0x0093 }
            r1.unlock()
            goto L_0x0099
        L_0x0093:
            r0 = move-exception
            r2 = r0
            r1.unlock()
            throw r2
        L_0x0099:
            return
        L_0x009a:
            java8.util.concurrent.FJTask.rethrow(r20)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.deregisterWorker(java8.util.concurrent.FJWorkerThread, java.lang.Throwable):void");
    }

    public void execute(Runnable runnable) {
        FJTask fJTask;
        if (runnable != null) {
            if (runnable instanceof FJTask) {
                fJTask = (FJTask) runnable;
            } else {
                fJTask = new RunnableExecuteAction(runnable);
            }
            externalSubmit(fJTask);
            return;
        }
        throw null;
    }

    public final <T> FJTask<T> externalSubmit(FJTask<T> fJTask) {
        boolean z;
        boolean z2;
        boolean z3;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FJWorkerThread) {
            FJWorkerThread fJWorkerThread = (FJWorkerThread) currentThread;
            if (fJWorkerThread.pool == this) {
                WorkQueue workQueue = fJWorkerThread.workQueue;
                if (workQueue != null) {
                    workQueue.push(fJTask);
                    return fJTask;
                }
            }
        }
        int probe = TLR.getProbe();
        if (probe == 0) {
            int addAndGet = TLR.probeGenerator.addAndGet(-1640531527);
            if (addAndGet == 0) {
                addAndGet = 1;
            }
            TLR.localSeeds.get().threadProbe = addAndGet;
            probe = TLR.getProbe();
        }
        while (true) {
            int i = this.mode;
            WorkQueue[] workQueueArr = this.workQueues;
            if ((i & 262144) != 0 || workQueueArr == null) {
                break;
            }
            if (workQueueArr.length <= 0) {
                break;
            }
            WorkQueue workQueue2 = workQueueArr[(r2 - 1) & probe & 126];
            if (workQueue2 == null) {
                String str = this.workerNamePrefix;
                int i2 = (probe | 1073741824) & -65538;
                WorkQueue workQueue3 = new WorkQueue(this, null);
                workQueue3.id = i2;
                workQueue3.source = 1073741824;
                workQueue3.phase = 1;
                if (str != null) {
                    synchronized (str) {
                        WorkQueue[] workQueueArr2 = this.workQueues;
                        if (workQueueArr2 != null) {
                            if (workQueueArr2.length > 0) {
                                int i3 = i2 & (r7 - 1) & 126;
                                if (workQueueArr2[i3] == null) {
                                    workQueueArr2[i3] = workQueue3;
                                    z2 = true;
                                    z = true;
                                }
                            }
                        }
                        z2 = false;
                        z = false;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                workQueue2 = workQueue3;
            } else if (workQueue2.tryLockSharedQueue()) {
                int i4 = workQueue2.base;
                int i5 = workQueue2.top;
                FJTask<?>[] fJTaskArr = workQueue2.array;
                if (fJTaskArr != null) {
                    int length = fJTaskArr.length;
                    if (length > 0) {
                        int i6 = length - 1;
                        int i7 = i4 - i5;
                        if (i6 + i7 > 0) {
                            fJTaskArr[i6 & i5] = fJTask;
                            workQueue2.top = i5 + 1;
                            workQueue2.phase = 0;
                            if (i7 < 0 && workQueue2.base - i5 < -1) {
                                break;
                            }
                            z3 = false;
                            z2 = true;
                        }
                    }
                }
                z3 = true;
                z2 = true;
            } else {
                z2 = false;
                z = false;
            }
            if (z2) {
                if (z) {
                    try {
                        workQueue2.growArray();
                        int i8 = workQueue2.top;
                        FJTask<?>[] fJTaskArr2 = workQueue2.array;
                        if (fJTaskArr2 != null) {
                            int length2 = fJTaskArr2.length;
                            if (length2 > 0) {
                                fJTaskArr2[(length2 - 1) & i8] = fJTask;
                                workQueue2.top = i8 + 1;
                            }
                        }
                    } finally {
                        workQueue2.phase = 0;
                    }
                }
                signalWork();
            } else {
                int i9 = probe ^ (probe << 13);
                int i10 = i9 ^ (i9 >>> 17);
                probe = i10 ^ (i10 << 5);
                TLR.localSeeds.get().threadProbe = probe;
            }
        }
        throw new RejectedExecutionException();
    }

    public final void helpQuiescePool(WorkQueue workQueue) {
        boolean z;
        boolean z2;
        int i;
        char c2;
        WorkQueue workQueue2 = workQueue;
        int i2 = workQueue2.source;
        int i3 = workQueue2.id & 65536;
        char c3 = 65535;
        int i4 = i2;
        char c4 = 65535;
        while (true) {
            if (i3 != 0) {
                workQueue2.localPollAndExec(0);
            } else {
                workQueue2.localPopAndExec(0);
            }
            if (c4 == c3 && workQueue2.phase >= 0) {
                c4 = 1;
            }
            int nextSecondarySeed = TLR.nextSecondarySeed();
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                int length = workQueueArr.length;
                int i5 = length - 1;
                int i6 = length;
                z = true;
                while (true) {
                    if (i6 <= 0) {
                        z2 = true;
                        break;
                    }
                    int i7 = (nextSecondarySeed - i6) & i5;
                    if (i7 >= 0 && i7 < length) {
                        WorkQueue workQueue3 = workQueueArr[i7];
                        if (workQueue3 != null) {
                            int i8 = workQueue3.base;
                            if (i8 - workQueue3.top < 0) {
                                FJTask<?>[] fJTaskArr = workQueue3.array;
                                if (fJTaskArr != null) {
                                    if (fJTaskArr.length > 0) {
                                        if (c4 == 0) {
                                            getAndAddLong(this, CTL, 281474976710656L);
                                            c4 = 1;
                                        }
                                        long j = (((long) ((r13 - 1) & i8)) << ASHIFT) + ((long) ABASE);
                                        FJTask fJTask = (FJTask) U.getObjectVolatile(fJTaskArr, j);
                                        if (fJTask != null) {
                                            int i9 = i8 + 1;
                                            if (i8 == workQueue3.base && U.compareAndSwapObject(fJTaskArr, j, fJTask, null)) {
                                                workQueue3.base = i9;
                                                workQueue2.source = workQueue3.id;
                                                fJTask.doExec();
                                                workQueue2.source = i2;
                                                i4 = i2;
                                            }
                                        }
                                        z2 = false;
                                        z = false;
                                    }
                                }
                            }
                            if ((workQueue3.source & 1073741824) == 0) {
                                z = false;
                            }
                        } else {
                            continue;
                        }
                    }
                    i6--;
                }
            } else {
                z2 = true;
                z = true;
            }
            if (z) {
                break;
            }
            if (z2) {
                if (i4 != 1073741824) {
                    workQueue2.source = 1073741824;
                    c2 = 1;
                    i = 1073741824;
                } else {
                    i = i4;
                    c2 = 1;
                }
                if (c4 == c2) {
                    getAndAddLong(this, CTL, -281474976710656L);
                    i4 = i;
                    c4 = 0;
                } else {
                    i4 = i;
                }
            }
            c3 = 65535;
        }
        if (c4 == 0) {
            getAndAddLong(this, CTL, 281474976710656L);
        }
        workQueue2.source = i2;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            for (Callable adaptedCallable : collection) {
                AdaptedCallable adaptedCallable2 = new AdaptedCallable(adaptedCallable);
                arrayList.add(adaptedCallable2);
                externalSubmit(adaptedCallable2);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((FJTask) arrayList.get(i)).doJoin();
            }
            return arrayList;
        } catch (Throwable th) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Future) arrayList.get(i2)).cancel(false);
            }
            throw th;
        }
    }

    public boolean isShutdown() {
        return (this.mode & 262144) != 0;
    }

    public boolean isTerminated() {
        return (this.mode & 524288) != 0;
    }

    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new AdaptedRunnable(runnable, t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r14 = (((long) ((r11 - 1) & r10)) << ASHIFT) + ((long) ABASE);
        r1 = (java8.util.concurrent.FJTask) U.getObjectVolatile(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r1 == null) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r2 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r10 != r9.base) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (U.compareAndSwapObject(r13, r14, r1, null) == false) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        r9.base = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0002, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java8.util.concurrent.FJTask<?> pollScan(boolean r19) {
        /*
            r18 = this;
            r0 = r18
        L_0x0002:
            int r1 = r0.mode
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 != 0) goto L_0x0073
            java8.util.concurrent.FJPool$WorkQueue[] r1 = r0.workQueues
            if (r1 == 0) goto L_0x0073
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0073
            int r2 = r2 + -1
            int r3 = java8.util.concurrent.TLR.nextSecondarySeed()
            int r4 = r3 >>> 16
            if (r19 == 0) goto L_0x0022
            r3 = r3 & -2
            r3 = r3 & r2
            r4 = r4 & -2
            r4 = r4 | 2
            goto L_0x0025
        L_0x0022:
            r3 = r3 & r2
            r4 = r4 | 1
        L_0x0025:
            r5 = 0
            r6 = r3
            r7 = 0
            r8 = 0
        L_0x0029:
            r9 = r1[r6]
            if (r9 == 0) goto L_0x0069
            int r10 = r9.base
            int r7 = r7 + r10
            int r11 = r9.top
            int r11 = r10 - r11
            if (r11 >= 0) goto L_0x0069
            java8.util.concurrent.FJTask<?>[] r13 = r9.array
            if (r13 == 0) goto L_0x0069
            int r11 = r13.length
            if (r11 <= 0) goto L_0x0069
            int r11 = r11 + -1
            r1 = r11 & r10
            long r1 = (long) r1
            int r3 = ASHIFT
            long r1 = r1 << r3
            int r3 = ABASE
            long r3 = (long) r3
            long r14 = r1 + r3
            sun.misc.Unsafe r1 = U
            java.lang.Object r1 = r1.getObjectVolatile(r13, r14)
            java8.util.concurrent.FJTask r1 = (java8.util.concurrent.FJTask) r1
            if (r1 == 0) goto L_0x0002
            int r2 = r10 + 1
            int r3 = r9.base
            if (r10 != r3) goto L_0x0002
            sun.misc.Unsafe r12 = U
            r17 = 0
            r16 = r1
            boolean r3 = r12.compareAndSwapObject(r13, r14, r16, r17)
            if (r3 == 0) goto L_0x0002
            r9.base = r2
            return r1
        L_0x0069:
            int r6 = r6 + r4
            r6 = r6 & r2
            if (r6 != r3) goto L_0x0029
            if (r8 != r7) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r8 = r7
            r7 = 0
            goto L_0x0029
        L_0x0073:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.pollScan(boolean):java8.util.concurrent.FJTask");
    }

    public final WorkQueue registerWorker(FJWorkerThread fJWorkerThread) {
        int i;
        fJWorkerThread.setDaemon(true);
        UncaughtExceptionHandler uncaughtExceptionHandler = this.ueh;
        if (uncaughtExceptionHandler != null) {
            fJWorkerThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        WorkQueue workQueue = new WorkQueue(this, fJWorkerThread);
        int i2 = this.mode & 65536;
        String str = this.workerNamePrefix;
        if (str != null) {
            synchronized (str) {
                WorkQueue[] workQueueArr = this.workQueues;
                int i3 = this.indexSeed - 1640531527;
                this.indexSeed = i3;
                i = 0;
                if (workQueueArr != null) {
                    int length = workQueueArr.length;
                    if (length > 1) {
                        int i4 = length - 1;
                        int i5 = i3 & i4;
                        int i6 = ((i3 << 1) | 1) & i4;
                        int i7 = length >>> 1;
                        while (true) {
                            WorkQueue workQueue2 = workQueueArr[i6];
                            if (workQueue2 == null) {
                                break;
                            } else if (workQueue2.phase == 1073741824) {
                                break;
                            } else {
                                i7--;
                                if (i7 == 0) {
                                    i6 = length | 1;
                                    break;
                                }
                                i6 = (i6 + 2) & i4;
                            }
                        }
                        int i8 = i2 | i6 | (i3 & 1073610752);
                        workQueue.id = i8;
                        workQueue.phase = i8;
                        if (i6 < length) {
                            workQueueArr[i6] = workQueue;
                        } else {
                            int i9 = length << 1;
                            WorkQueue[] workQueueArr2 = new WorkQueue[i9];
                            workQueueArr2[i6] = workQueue;
                            int i10 = i9 - 1;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                WorkQueue workQueue3 = workQueueArr[i];
                                if (workQueue3 != null) {
                                    workQueueArr2[workQueue3.id & i10 & 126] = workQueue3;
                                }
                                int i11 = i + 1;
                                if (i11 >= length) {
                                    break;
                                }
                                workQueueArr2[i11] = workQueueArr[i11];
                                i = i11 + 1;
                            }
                            this.workQueues = workQueueArr2;
                        }
                        i = i5;
                    }
                }
            }
            fJWorkerThread.setName(str.concat(Integer.toString(i)));
        }
        return workQueue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bd, code lost:
        r10 = r9.phase;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        if (r10 < 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cb, code lost:
        r15 = (r10 + 65536) | androidx.recyclerview.widget.LinearLayoutManager.INVALID_OFFSET;
        r9.phase = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        r4 = r8.ctl;
        r9.stackPred = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        if (U.compareAndSwapLong(r23, CTL, r4, ((r4 - 281474976710656L) & -4294967296L) | (((long) r15) & 4294967295L)) == false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        r15 = r9.stackPred;
        r9.source = -1073741824;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f8, code lost:
        if (r9.phase < 0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fa, code lost:
        r9.source = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0101, code lost:
        r0 = r8.mode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0103, code lost:
        if (r0 >= 0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0106, code lost:
        r4 = r8.ctl;
        r1 = (65535 & r0) + ((int) (r4 >> 48));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0112, code lost:
        if (r1 > 0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
        if ((r0 & 262144) == 0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011e, code lost:
        if (tryTerminate(false, false) == false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0120, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0122, code lost:
        r17 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0128, code lost:
        if ((r17 & 1) != 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        java.lang.Thread.interrupted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0130, code lost:
        if (r1 > 0) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0132, code lost:
        if (r15 == 0) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0135, code lost:
        if (r10 != ((int) r4)) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0137, code lost:
        r2 = java.lang.System.currentTimeMillis() + r8.keepAlive;
        java.util.concurrent.locks.LockSupport.parkUntil(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0145, code lost:
        if (r8.ctl != r4) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0150, code lost:
        if ((r2 - java.lang.System.currentTimeMillis()) > 20) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x016c, code lost:
        if (U.compareAndSwapLong(r23, CTL, r4, ((r4 - 4294967296L) & -4294967296L) | (((long) r15) & 4294967295L)) == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016e, code lost:
        r9.phase = 1073741824;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0172, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0173, code lost:
        java.util.concurrent.locks.LockSupport.park(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0178, code lost:
        r6 = r17;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void runWorker(java8.util.concurrent.FJPool.WorkQueue r24) {
        /*
            r23 = this;
            r8 = r23
            r9 = r24
            r24.growArray()
            int r0 = r9.id
            int r1 = java8.util.concurrent.TLR.nextSecondarySeed()
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0011
            r0 = 1
        L_0x0011:
            r1 = 0
        L_0x0012:
            java8.util.concurrent.FJPool$WorkQueue[] r2 = r8.workQueues
            if (r2 == 0) goto L_0x017c
            int r3 = r2.length
            int r4 = r3 + -1
            r12 = r0
            r0 = r3
            r5 = 0
        L_0x001c:
            if (r0 <= 0) goto L_0x00ad
            r7 = r12 & r4
            if (r7 < 0) goto L_0x00a2
            if (r7 >= r3) goto L_0x00a2
            r7 = r2[r7]
            if (r7 == 0) goto L_0x00a2
            int r13 = r7.base
            int r14 = r7.top
            int r14 = r13 - r14
            if (r14 >= 0) goto L_0x00a2
            java8.util.concurrent.FJTask<?>[] r14 = r7.array
            if (r14 == 0) goto L_0x00a2
            int r15 = r14.length
            if (r15 <= 0) goto L_0x00a2
            int r5 = r7.id
            int r15 = r15 + -1
            r15 = r15 & r13
            r21 = r12
            long r11 = (long) r15
            int r15 = ASHIFT
            long r11 = r11 << r15
            int r15 = ABASE
            r22 = r7
            long r6 = (long) r15
            long r6 = r6 + r11
            sun.misc.Unsafe r11 = U
            java.lang.Object r11 = r11.getObjectVolatile(r14, r6)
            java8.util.concurrent.FJTask r11 = (java8.util.concurrent.FJTask) r11
            if (r11 == 0) goto L_0x009e
            int r12 = r13 + 1
            r15 = r22
            int r10 = r15.base
            if (r13 != r10) goto L_0x009e
            sun.misc.Unsafe r10 = U
            r20 = 0
            r13 = r15
            r15 = r10
            r16 = r14
            r17 = r6
            r19 = r11
            boolean r6 = r15.compareAndSwapObject(r16, r17, r19, r20)
            if (r6 == 0) goto L_0x009e
            r13.base = r12
            int r6 = r13.top
            int r12 = r12 - r6
            if (r12 >= 0) goto L_0x0078
            if (r5 == r1) goto L_0x0078
            r23.signalWork()
        L_0x0078:
            r9.source = r5
            r11.doExec()
            int r1 = r9.id
            r6 = 65536(0x10000, float:9.1835E-41)
            r1 = r1 & r6
            r6 = 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x008a
            r9.localPollAndExec(r6)
            goto L_0x008d
        L_0x008a:
            r9.localPopAndExec(r6)
        L_0x008d:
            java8.util.concurrent.FJWorkerThread r1 = r9.owner
            int r6 = r9.nsteals
            r7 = 1
            int r6 = r6 + r7
            r9.nsteals = r6
            r6 = 0
            r9.source = r6
            if (r1 == 0) goto L_0x009d
            r1.afterTopLevelExec()
        L_0x009d:
            r1 = r5
        L_0x009e:
            r12 = r21
            r5 = 1
            goto L_0x00a9
        L_0x00a2:
            r21 = r12
            if (r5 == 0) goto L_0x00a7
            goto L_0x00af
        L_0x00a7:
            int r12 = r21 + 1
        L_0x00a9:
            int r0 = r0 + -1
            goto L_0x001c
        L_0x00ad:
            r21 = r12
        L_0x00af:
            if (r5 == 0) goto L_0x00bd
            int r0 = r21 << 13
            r0 = r21 ^ r0
            int r2 = r0 >>> 17
            r0 = r0 ^ r2
            int r2 = r0 << 5
            r0 = r0 ^ r2
            goto L_0x0012
        L_0x00bd:
            int r10 = r9.phase
            r11 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r13 = -4294967296(0xffffffff00000000, double:NaN)
            if (r10 < 0) goto L_0x00ef
            r0 = 65536(0x10000, float:9.1835E-41)
            int r10 = r10 + r0
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = r10 | r0
            r9.phase = r15
        L_0x00d4:
            long r4 = r8.ctl
            int r0 = (int) r4
            r9.stackPred = r0
            r0 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r0 = r4 - r0
            long r0 = r0 & r13
            long r2 = (long) r15
            long r2 = r2 & r11
            long r6 = r0 | r2
            sun.misc.Unsafe r0 = U
            long r2 = CTL
            r1 = r23
            boolean r0 = r0.compareAndSwapLong(r1, r2, r4, r6)
            if (r0 == 0) goto L_0x00d4
            goto L_0x00fd
        L_0x00ef:
            int r15 = r9.stackPred
            r0 = -1073741824(0xffffffffc0000000, float:-2.0)
            r9.source = r0
            r6 = 0
        L_0x00f6:
            int r0 = r9.phase
            if (r0 < 0) goto L_0x0101
            r0 = 0
            r9.source = r0
        L_0x00fd:
            r0 = r21
            goto L_0x0011
        L_0x0101:
            int r0 = r8.mode
            if (r0 >= 0) goto L_0x0106
            return
        L_0x0106:
            r1 = 65535(0xffff, float:9.1834E-41)
            r1 = r1 & r0
            long r4 = r8.ctl
            r2 = 48
            long r2 = r4 >> r2
            int r3 = (int) r2
            int r1 = r1 + r3
            if (r1 > 0) goto L_0x0121
            r2 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0121
            r7 = 0
            boolean r0 = r8.tryTerminate(r7, r7)
            if (r0 == 0) goto L_0x0122
            return
        L_0x0121:
            r7 = 0
        L_0x0122:
            r16 = 1
            int r17 = r6 + 1
            r0 = r17 & 1
            if (r0 != 0) goto L_0x0130
            java.lang.Thread.interrupted()
        L_0x012d:
            r20 = 0
            goto L_0x0178
        L_0x0130:
            if (r1 > 0) goto L_0x0173
            if (r15 == 0) goto L_0x0173
            int r0 = (int) r4
            if (r10 != r0) goto L_0x0173
            long r0 = r8.keepAlive
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 + r0
            java.util.concurrent.locks.LockSupport.parkUntil(r8, r2)
            long r0 = r8.ctl
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x012d
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r0 = 20
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 > 0) goto L_0x012d
            r0 = 4294967296(0x100000000, double:2.121995791E-314)
            long r0 = r4 - r0
            long r0 = r0 & r13
            long r2 = (long) r15
            long r2 = r2 & r11
            long r18 = r0 | r2
            sun.misc.Unsafe r0 = U
            long r2 = CTL
            r1 = r23
            r20 = 0
            r6 = r18
            boolean r0 = r0.compareAndSwapLong(r1, r2, r4, r6)
            if (r0 == 0) goto L_0x0178
            r0 = 1073741824(0x40000000, float:2.0)
            r9.phase = r0
            return
        L_0x0173:
            r20 = 0
            java.util.concurrent.locks.LockSupport.park(r23)
        L_0x0178:
            r6 = r17
            goto L_0x00f6
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.runWorker(java8.util.concurrent.FJPool$WorkQueue):void");
    }

    public void shutdown() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
        tryTerminate(false, true);
    }

    public List<Runnable> shutdownNow() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
        tryTerminate(true, true);
        return Collections.emptyList();
    }

    public final void signalWork() {
        while (true) {
            long j = this.ctl;
            if (j < 0) {
                int i = (int) j;
                if (i != 0) {
                    WorkQueue[] workQueueArr = this.workQueues;
                    if (workQueueArr != null) {
                        int i2 = 65535 & i;
                        if (workQueueArr.length > i2) {
                            WorkQueue workQueue = workQueueArr[i2];
                            if (workQueue != null) {
                                int i3 = i & Integer.MAX_VALUE;
                                int i4 = workQueue.phase;
                                long j2 = (((long) workQueue.stackPred) & 4294967295L) | (-4294967296L & (281474976710656L + j));
                                FJWorkerThread fJWorkerThread = workQueue.owner;
                                if (i == i4) {
                                    if (U.compareAndSwapLong(this, CTL, j, j2)) {
                                        workQueue.phase = i3;
                                        if (workQueue.source < 0) {
                                            LockSupport.unpark(fJWorkerThread);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if ((140737488355328L & j) != 0) {
                    tryAddWorker(j);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public Future submit(Callable callable) {
        AdaptedCallable adaptedCallable = new AdaptedCallable(callable);
        externalSubmit(adaptedCallable);
        return adaptedCallable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x004d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r15 = this;
            long r0 = r15.stealCount
            java8.util.concurrent.FJPool$WorkQueue[] r2 = r15.workQueues
            r3 = 0
            r5 = 0
            if (r2 == 0) goto L_0x0050
            r6 = 0
            r7 = 0
            r6 = r3
            r8 = 0
            r9 = 0
        L_0x000e:
            int r10 = r2.length
            if (r8 >= r10) goto L_0x0052
            r10 = r2[r8]
            if (r10 == 0) goto L_0x004d
            int r11 = r10.base
            int r12 = r10.top
            int r11 = r11 - r12
            if (r11 < 0) goto L_0x001e
            r11 = 0
            goto L_0x001f
        L_0x001e:
            int r11 = -r11
        L_0x001f:
            r12 = r8 & 1
            if (r12 != 0) goto L_0x0026
            long r10 = (long) r11
            long r6 = r6 + r10
            goto L_0x004d
        L_0x0026:
            long r11 = (long) r11
            long r3 = r3 + r11
            int r11 = r10.nsteals
            long r11 = (long) r11
            r13 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r11 = r11 & r13
            long r0 = r0 + r11
            java8.util.concurrent.FJWorkerThread r10 = r10.owner
            if (r10 == 0) goto L_0x0048
            java.lang.Thread$State r10 = r10.getState()
            java.lang.Thread$State r11 = java.lang.Thread.State.BLOCKED
            if (r10 == r11) goto L_0x0048
            java.lang.Thread$State r11 = java.lang.Thread.State.WAITING
            if (r10 == r11) goto L_0x0048
            java.lang.Thread$State r11 = java.lang.Thread.State.TIMED_WAITING
            if (r10 == r11) goto L_0x0048
            r10 = 1
            goto L_0x0049
        L_0x0048:
            r10 = 0
        L_0x0049:
            if (r10 == 0) goto L_0x004d
            int r9 = r9 + 1
        L_0x004d:
            int r8 = r8 + 1
            goto L_0x000e
        L_0x0050:
            r9 = 0
            r6 = r3
        L_0x0052:
            int r2 = r15.mode
            r8 = 65535(0xffff, float:9.1834E-41)
            r8 = r8 & r2
            long r10 = r15.ctl
            r12 = 32
            long r12 = r10 >>> r12
            int r13 = (int) r12
            short r12 = (short) r13
            int r12 = r12 + r8
            r13 = 48
            long r10 = r10 >> r13
            int r11 = (int) r10
            int r11 = r11 + r8
            if (r11 >= 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r5 = r11
        L_0x006a:
            r10 = 524288(0x80000, float:7.34684E-40)
            r10 = r10 & r2
            if (r10 == 0) goto L_0x0072
            java.lang.String r2 = "Terminated"
            goto L_0x0084
        L_0x0072:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = r10 & r2
            if (r10 == 0) goto L_0x007a
            java.lang.String r2 = "Terminating"
            goto L_0x0084
        L_0x007a:
            r10 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r10
            if (r2 == 0) goto L_0x0082
            java.lang.String r2 = "Shutting down"
            goto L_0x0084
        L_0x0082:
            java.lang.String r2 = "Running"
        L_0x0084:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = super.toString()
            java.lang.String r13 = "["
            java.lang.String r14 = ", parallelism = "
            com.android.tools.r8.GeneratedOutlineSupport.outline103(r10, r11, r13, r2, r14)
            r10.append(r8)
            java.lang.String r2 = ", size = "
            r10.append(r2)
            r10.append(r12)
            java.lang.String r2 = ", active = "
            r10.append(r2)
            r10.append(r5)
            java.lang.String r2 = ", running = "
            r10.append(r2)
            r10.append(r9)
            java.lang.String r2 = ", steals = "
            r10.append(r2)
            r10.append(r0)
            java.lang.String r0 = ", tasks = "
            r10.append(r0)
            r10.append(r3)
            java.lang.String r0 = ", submissions = "
            r10.append(r0)
            java.lang.String r0 = "]"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline58(r10, r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.FJPool.toString():java.lang.String");
    }

    public final void tryAddWorker(long j) {
        long j2 = j;
        do {
            long j3 = (-281474976710656L & (281474976710656L + j2)) | (281470681743360L & (4294967296L + j2));
            if (this.ctl == j2) {
                if (U.compareAndSwapLong(this, CTL, j2, j3)) {
                    createWorker();
                    return;
                }
            }
            j2 = this.ctl;
            if ((140737488355328L & j2) == 0) {
                return;
            }
        } while (((int) j2) == 0);
    }

    public final int tryCompensate(WorkQueue workQueue) {
        boolean z;
        long j = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        short s = (short) ((int) (j >>> 32));
        int i = 1;
        if (s >= 0) {
            if (workQueueArr != null) {
                int length = workQueueArr.length;
                if (length > 0) {
                    int i2 = (int) j;
                    if (i2 != 0) {
                        WorkQueue workQueue2 = workQueueArr[i2 & (length - 1)];
                        int i3 = workQueue.phase;
                        long j2 = -4294967296L & (i3 < 0 ? 281474976710656L + j : j);
                        int i4 = i2 & Integer.MAX_VALUE;
                        if (workQueue2 != null) {
                            int i5 = workQueue2.phase;
                            FJWorkerThread fJWorkerThread = workQueue2.owner;
                            long j3 = (((long) workQueue2.stackPred) & 4294967295L) | j2;
                            if (i5 == i2) {
                                if (U.compareAndSwapLong(this, CTL, j, j3)) {
                                    workQueue2.phase = i4;
                                    if (workQueue2.source < 0) {
                                        LockSupport.unpark(fJWorkerThread);
                                    }
                                    if (i3 < 0) {
                                        i = -1;
                                    }
                                    return i;
                                }
                            }
                        }
                        return 0;
                    } else if (((int) (j >> 48)) - ((short) (this.bounds & 65535)) > 0) {
                        return U.compareAndSwapLong(this, CTL, j, (-281474976710656L & (j - 281474976710656L)) | (ThreadLocalRandom.mask & j)) ? 1 : 0;
                    } else {
                        short s2 = this.mode & 65535;
                        int i6 = s2 + s;
                        int i7 = i6;
                        int i8 = 1;
                        int i9 = 0;
                        while (true) {
                            if (i8 >= length) {
                                z = false;
                                break;
                            }
                            WorkQueue workQueue3 = workQueueArr[i8];
                            if (workQueue3 != null) {
                                if (workQueue3.source == 0) {
                                    z = true;
                                    break;
                                }
                                i7--;
                                FJWorkerThread fJWorkerThread2 = workQueue3.owner;
                                if (fJWorkerThread2 != null) {
                                    State state = fJWorkerThread2.getState();
                                    if (state == State.BLOCKED || state == State.WAITING) {
                                        i9++;
                                    }
                                }
                            }
                            i8 += 2;
                        }
                        if (!z && i7 == 0 && this.ctl == j) {
                            if (i6 >= 32767 || s >= (this.bounds >>> 16)) {
                                Predicate<? super FJPool> predicate = this.saturate;
                                if (predicate != null && predicate.test(this)) {
                                    return -1;
                                }
                                if (i9 < s2) {
                                    Thread.yield();
                                    return 0;
                                }
                                throw new RejectedExecutionException("Thread limit exceeded replacing blocked worker");
                            }
                        }
                    }
                }
            }
            return 0;
        }
        if (!U.compareAndSwapLong(this, CTL, j, ((4294967296L + j) & 281470681743360L) | (-281470681743361L & j)) || !createWorker()) {
            i = 0;
        }
        return i;
    }

    public final boolean tryExternalUnpush(FJTask<?> fJTask) {
        int probe = TLR.getProbe();
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int length = workQueueArr.length;
            if (length > 0) {
                WorkQueue workQueue = workQueueArr[probe & (length - 1) & 126];
                if (workQueue != null && workQueue.trySharedUnpush(fJTask)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean tryTerminate(boolean z, boolean z2) {
        int i;
        int i2;
        while (true) {
            int i3 = this.mode;
            if ((i3 & 262144) != 0) {
                while (true) {
                    int i4 = this.mode;
                    int i5 = 65535;
                    int i6 = 1;
                    if ((i4 & LinearLayoutManager.INVALID_OFFSET) == 0) {
                        if (!z) {
                            long j = 0;
                            while (true) {
                                long j2 = this.ctl;
                                WorkQueue[] workQueueArr = this.workQueues;
                                char c2 = '0';
                                if ((i4 & i5) + ((int) (j2 >> 48)) <= 0) {
                                    if (workQueueArr != null) {
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= workQueueArr.length) {
                                                break;
                                            }
                                            WorkQueue workQueue = workQueueArr[i7];
                                            if (workQueue != null) {
                                                int i8 = workQueue.source;
                                                int i9 = workQueue.phase;
                                                int i10 = workQueue.id;
                                                int i11 = workQueue.base;
                                                if (i11 != workQueue.top || ((i10 & 1) == i6 && (i8 >= 0 || i9 >= 0))) {
                                                    i6 = 1;
                                                } else {
                                                    j2 = (((long) i8) << c2) + (((long) i9) << 32) + (((long) i11) << 16) + ((long) i10) + j2;
                                                }
                                            }
                                            i7++;
                                            c2 = '0';
                                            i6 = 1;
                                        }
                                        i6 = 1;
                                    }
                                    i6 = 0;
                                }
                                i4 = this.mode;
                                if ((i4 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                                    break;
                                } else if (i6 != 0) {
                                    return false;
                                } else {
                                    if (this.workQueues == workQueueArr) {
                                        if (j == j2) {
                                            break;
                                        }
                                        j = j2;
                                    }
                                    i5 = 65535;
                                    i6 = 1;
                                }
                            }
                        }
                        int i12 = i4;
                        if ((i12 & LinearLayoutManager.INVALID_OFFSET) == 0) {
                            U.compareAndSwapInt(this, MODE, i12, i12 | LinearLayoutManager.INVALID_OFFSET);
                        }
                    } else {
                        while (true) {
                            if ((this.mode & 524288) != 0) {
                                break;
                            }
                            long j3 = 0;
                            while (true) {
                                long j4 = this.ctl;
                                WorkQueue[] workQueueArr2 = this.workQueues;
                                if (workQueueArr2 != null) {
                                    for (WorkQueue workQueue2 : workQueueArr2) {
                                        if (workQueue2 != null) {
                                            FJWorkerThread fJWorkerThread = workQueue2.owner;
                                            while (true) {
                                                FJTask<?> poll = workQueue2.poll();
                                                if (poll == null) {
                                                    break;
                                                }
                                                FJTask.cancelIgnoringExceptions(poll);
                                            }
                                            if (fJWorkerThread != null) {
                                                try {
                                                    fJWorkerThread.interrupt();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            j4 += (((long) workQueue2.phase) << 32) + ((long) workQueue2.base);
                                        }
                                    }
                                }
                                i = this.mode;
                                i2 = i & 524288;
                                if (i2 != 0) {
                                    break;
                                } else if (this.workQueues == workQueueArr2) {
                                    if (j3 == j4) {
                                        break;
                                    }
                                    j3 = j4;
                                }
                            }
                            if (i2 != 0 || (i & 65535) + ((short) ((int) (this.ctl >>> 32))) > 0) {
                                break;
                            }
                            if (U.compareAndSwapInt(this, MODE, i, i | 524288)) {
                                synchronized (this) {
                                    notifyAll();
                                }
                                break;
                            }
                        }
                        return true;
                    }
                }
            } else if (!z2 || this == common) {
                return false;
            } else {
                U.compareAndSwapInt(this, MODE, i3, i3 | 262144);
            }
        }
        return false;
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new AdaptedCallable(callable);
    }

    public Future submit(Runnable runnable, Object obj) {
        AdaptedRunnable adaptedRunnable = new AdaptedRunnable(runnable, obj);
        externalSubmit(adaptedRunnable);
        return adaptedRunnable;
    }

    public Future submit(Runnable runnable) {
        if (runnable != null) {
            FJTask adaptedRunnableAction = runnable instanceof FJTask ? (FJTask) runnable : new AdaptedRunnableAction(runnable);
            externalSubmit(adaptedRunnableAction);
            return adaptedRunnableAction;
        }
        throw null;
    }
}
