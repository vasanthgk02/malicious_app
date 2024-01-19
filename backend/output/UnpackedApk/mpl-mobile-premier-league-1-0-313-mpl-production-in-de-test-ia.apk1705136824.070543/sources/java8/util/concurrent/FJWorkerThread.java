package java8.util.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java8.util.concurrent.FJPool.WorkQueue;

public class FJWorkerThread extends Thread {
    public final FJPool pool;
    public final WorkQueue workQueue;

    public static final class InnocuousForkJoinWorkerThread extends FJWorkerThread {
        public static final AccessControlContext INNOCUOUS_ACC = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, null)});
        public static final ThreadGroup innocuousThreadGroup = ((ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() {
            public Object run() {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                while (true) {
                    ThreadGroup parent = threadGroup.getParent();
                    if (parent == null) {
                        return new ThreadGroup(threadGroup, "InnocuousFJWorkerThreadGroup");
                    }
                    threadGroup = parent;
                }
            }
        }));

        public InnocuousForkJoinWorkerThread(FJPool fJPool) {
            super(fJPool, ClassLoader.getSystemClassLoader(), innocuousThreadGroup, INNOCUOUS_ACC);
        }

        public void afterTopLevelExec() {
            TLR.eraseThreadLocals(this);
        }

        public void setContextClassLoader(ClassLoader classLoader) {
            if (classLoader != null && ClassLoader.getSystemClassLoader() != classLoader) {
                throw new SecurityException("setContextClassLoader");
            }
        }

        public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        }
    }

    public FJWorkerThread(FJPool fJPool, ClassLoader classLoader) {
        super("aFJWorkerThread");
        TLR.setContextClassLoader(this, classLoader);
        this.pool = fJPool;
        this.workQueue = fJPool.registerWorker(this);
    }

    public void afterTopLevelExec() {
    }

    public void run() {
        WorkQueue workQueue2 = this.workQueue;
        if (workQueue2.array == null) {
            try {
                this.pool.runWorker(workQueue2);
                this.pool.deregisterWorker(this, null);
            } catch (Throwable th) {
                this.pool.deregisterWorker(this, th);
            }
        }
    }

    public FJWorkerThread(FJPool fJPool, ClassLoader classLoader, ThreadGroup threadGroup, AccessControlContext accessControlContext) {
        super(threadGroup, "aFJWorkerThread");
        super.setContextClassLoader(classLoader);
        TLR.setInheritedAccessControlContext(this, accessControlContext);
        TLR.eraseThreadLocals(this);
        this.pool = fJPool;
        this.workQueue = fJPool.registerWorker(this);
    }
}
