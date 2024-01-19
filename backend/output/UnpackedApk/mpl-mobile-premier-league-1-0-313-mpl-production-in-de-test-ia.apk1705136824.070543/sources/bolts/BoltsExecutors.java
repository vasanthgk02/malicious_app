package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class BoltsExecutors {
    public static final BoltsExecutors INSTANCE = new BoltsExecutors();
    public final ExecutorService background;
    public final Executor immediate;

    public static class ImmediateExecutor implements Executor {
        public ThreadLocal<Integer> executionDepth = new ThreadLocal<>();

        public ImmediateExecutor(AnonymousClass1 r1) {
        }

        public final int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            if (intValue <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                BoltsExecutors.INSTANCE.background.execute(runnable);
            }
            decrementDepth();
        }
    }

    public BoltsExecutors() {
        boolean z;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            z = false;
        } else {
            z = property.toLowerCase(Locale.US).contains("android");
        }
        this.background = !z ? Executors.newCachedThreadPool() : AndroidExecutors.newCachedThreadPool();
        Executors.newSingleThreadScheduledExecutor();
        this.immediate = new ImmediateExecutor(null);
    }
}
