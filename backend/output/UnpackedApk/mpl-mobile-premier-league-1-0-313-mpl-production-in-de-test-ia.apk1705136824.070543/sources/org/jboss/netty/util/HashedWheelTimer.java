package org.jboss.netty.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConcurrentIdentityHashMap;
import org.jboss.netty.util.internal.ReusableIterator;
import org.jboss.netty.util.internal.SharedResourceMisuseDetector;

public class HashedWheelTimer implements Timer {
    public static final AtomicInteger id = new AtomicInteger();
    public static final InternalLogger logger;
    public static final SharedResourceMisuseDetector misuseDetector;
    public final ReusableIterator<HashedWheelTimeout>[] iterators;
    public final ReadWriteLock lock;
    public final int mask;
    public final long roundDuration;
    public final AtomicBoolean shutdown;
    public final long tickDuration;
    public final Set<HashedWheelTimeout>[] wheel;
    public volatile int wheelCursor;
    public final Worker worker;
    public final Thread workerThread;

    public final class HashedWheelTimeout implements Timeout {
        public volatile boolean cancelled;
        public final long deadline;
        public volatile long remainingRounds;
        public final int stopIndex;
        public final TimerTask task;

        public HashedWheelTimeout(TimerTask timerTask, long j, int i, long j2) {
            this.task = timerTask;
            this.deadline = j;
            this.stopIndex = i;
            this.remainingRounds = j2;
        }

        public void cancel() {
            if (!isExpired()) {
                this.cancelled = true;
                HashedWheelTimer.this.wheel[this.stopIndex].remove(this);
            }
        }

        public void expire() {
            if (!this.cancelled) {
                try {
                    this.task.run(this);
                } catch (Throwable th) {
                    InternalLogger internalLogger = HashedWheelTimer.logger;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("An exception was thrown by ");
                    outline73.append(TimerTask.class.getSimpleName());
                    outline73.append(".");
                    internalLogger.warn(outline73.toString(), th);
                }
            }
        }

        public TimerTask getTask() {
            return this.task;
        }

        public Timer getTimer() {
            return HashedWheelTimer.this;
        }

        public boolean isCancelled() {
            return this.cancelled;
        }

        public boolean isExpired() {
            return this.cancelled || System.currentTimeMillis() > this.deadline;
        }

        public String toString() {
            long currentTimeMillis = this.deadline - System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(192);
            sb.append(HashedWheelTimeout.class.getSimpleName());
            sb.append('(');
            sb.append("deadline: ");
            int i = (currentTimeMillis > 0 ? 1 : (currentTimeMillis == 0 ? 0 : -1));
            if (i > 0) {
                sb.append(currentTimeMillis);
                sb.append(" ms later, ");
            } else if (i < 0) {
                sb.append(-currentTimeMillis);
                sb.append(" ms ago, ");
            } else {
                sb.append("now, ");
            }
            if (isCancelled()) {
                sb.append(", cancelled");
            }
            sb.append(')');
            return sb.toString();
        }
    }

    public final class Worker implements Runnable {
        public long startTime;
        public long tick;

        public Worker() {
        }

        private void fetchExpiredTimeouts(List<HashedWheelTimeout> list) {
            HashedWheelTimer.this.lock.writeLock().lock();
            try {
                int i = HashedWheelTimer.this.wheelCursor;
                HashedWheelTimer.this.wheelCursor = (i + 1) & HashedWheelTimer.this.mask;
                fetchExpiredTimeouts(list, HashedWheelTimer.this.iterators[i]);
            } finally {
                HashedWheelTimer.this.lock.writeLock().unlock();
            }
        }

        private void notifyExpiredTimeouts(List<HashedWheelTimeout> list) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).expire();
            }
            list.clear();
        }

        private void waitForNextTick() {
            while (true) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = HashedWheelTimer.this.tickDuration;
                long j2 = this.tick;
                long j3 = (j * j2) - (currentTimeMillis - this.startTime);
                if (j3 <= 0) {
                    if (j * j2 > Long.MAX_VALUE - j) {
                        this.startTime = System.currentTimeMillis();
                        this.tick = 1;
                    } else {
                        this.tick = j2 + 1;
                    }
                    return;
                }
                try {
                    Thread.sleep(j3);
                } catch (InterruptedException unused) {
                    if (HashedWheelTimer.this.shutdown.get()) {
                        return;
                    }
                }
            }
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            this.startTime = System.currentTimeMillis();
            this.tick = 1;
            while (!HashedWheelTimer.this.shutdown.get()) {
                waitForNextTick();
                fetchExpiredTimeouts(arrayList);
                notifyExpiredTimeouts(arrayList);
            }
        }

        private void fetchExpiredTimeouts(List<HashedWheelTimeout> list, ReusableIterator<HashedWheelTimeout> reusableIterator) {
            long currentTimeMillis = System.currentTimeMillis() + HashedWheelTimer.this.tickDuration;
            reusableIterator.rewind();
            while (reusableIterator.hasNext()) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) reusableIterator.next();
                if (hashedWheelTimeout.remainingRounds > 0) {
                    hashedWheelTimeout.remainingRounds--;
                } else if (hashedWheelTimeout.deadline < currentTimeMillis) {
                    reusableIterator.remove();
                    list.add(hashedWheelTimeout);
                }
            }
        }
    }

    static {
        Class<HashedWheelTimer> cls = HashedWheelTimer.class;
        logger = InternalLoggerFactory.getInstance(cls);
        misuseDetector = new SharedResourceMisuseDetector(cls);
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    public static ReusableIterator<HashedWheelTimeout>[] createIterators(Set<HashedWheelTimeout>[] setArr) {
        ReusableIterator<HashedWheelTimeout>[] reusableIteratorArr = new ReusableIterator[setArr.length];
        for (int i = 0; i < setArr.length; i++) {
            reusableIteratorArr[i] = (ReusableIterator) setArr[i].iterator();
        }
        return reusableIteratorArr;
    }

    public static Set<HashedWheelTimeout>[] createWheel(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("ticksPerWheel must be greater than 0: ", i));
        } else if (i <= 1073741824) {
            int normalizeTicksPerWheel = normalizeTicksPerWheel(i);
            Set<HashedWheelTimeout>[] setArr = new Set[normalizeTicksPerWheel];
            for (int i2 = 0; i2 < normalizeTicksPerWheel; i2++) {
                setArr[i2] = new MapBackedSet(new ConcurrentIdentityHashMap(16, 0.95f, 4));
            }
            return setArr;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("ticksPerWheel may not be greater than 2^30: ", i));
        }
    }

    public static int normalizeTicksPerWheel(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2;
    }

    public Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit) {
        TimeUnit timeUnit2 = timeUnit;
        long currentTimeMillis = System.currentTimeMillis();
        if (timerTask == null) {
            throw new NullPointerException("task");
        } else if (timeUnit2 != null) {
            long millis = timeUnit2.toMillis(j);
            long j2 = this.tickDuration;
            if (millis < j2) {
                millis = j2;
            }
            if (!this.workerThread.isAlive()) {
                start();
            }
            long j3 = this.tickDuration;
            int i = 1;
            long j4 = ((millis % this.roundDuration) / j3) + ((long) (millis % j3 != 0 ? 1 : 0));
            long j5 = currentTimeMillis + millis;
            long j6 = this.roundDuration;
            long j7 = millis / j6;
            if (millis % j6 != 0) {
                i = 0;
            }
            long j8 = j7 - ((long) i);
            this.lock.readLock().lock();
            try {
                HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(timerTask, j5, (int) ((((long) this.wheelCursor) + j4) & ((long) this.mask)), j8);
                this.wheel[hashedWheelTimeout.stopIndex].add(hashedWheelTimeout);
                return hashedWheelTimeout;
            } finally {
                this.lock.readLock().unlock();
            }
        } else {
            throw new NullPointerException("unit");
        }
    }

    public synchronized void start() {
        if (this.shutdown.get()) {
            throw new IllegalStateException("cannot be started once stopped");
        } else if (!this.workerThread.isAlive()) {
            this.workerThread.start();
        }
    }

    public synchronized Set<Timeout> stop() {
        if (!this.shutdown.compareAndSet(false, true)) {
            return Collections.emptySet();
        }
        boolean z = false;
        while (this.workerThread.isAlive()) {
            this.workerThread.interrupt();
            try {
                this.workerThread.join(100);
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        misuseDetector.decrease();
        HashSet hashSet = new HashSet();
        for (Set<HashedWheelTimeout> set : this.wheel) {
            hashSet.addAll(set);
            set.clear();
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j, timeUnit);
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit, int i) {
        this(Executors.defaultThreadFactory(), j, timeUnit, i);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
        this(threadFactory, j, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i) {
        this.worker = new Worker();
        this.shutdown = new AtomicBoolean();
        this.lock = new ReentrantReadWriteLock();
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        } else if (timeUnit == null) {
            throw new NullPointerException("unit");
        } else if (j <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("tickDuration must be greater than 0: ", j));
        } else if (i > 0) {
            Set<HashedWheelTimeout>[] createWheel = createWheel(i);
            this.wheel = createWheel;
            this.iterators = createIterators(createWheel);
            this.mask = this.wheel.length - 1;
            long millis = timeUnit.toMillis(j);
            this.tickDuration = millis;
            if (millis != Long.MAX_VALUE) {
                Set<HashedWheelTimeout>[] setArr = this.wheel;
                if (millis < Long.MAX_VALUE / ((long) setArr.length)) {
                    this.roundDuration = millis * ((long) setArr.length);
                    Worker worker2 = this.worker;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hashed wheel timer #");
                    outline73.append(id.incrementAndGet());
                    this.workerThread = threadFactory.newThread(new ThreadRenamingRunnable(worker2, outline73.toString()));
                    misuseDetector.increase();
                    return;
                }
            }
            throw new IllegalArgumentException("tickDuration is too long: " + millis + ' ' + timeUnit);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("ticksPerWheel must be greater than 0: ", i));
        }
    }
}
