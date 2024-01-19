package androidx.work;

import android.annotation.SuppressLint;

public interface Operation {
    @SuppressLint({"SyntheticAccessor"})
    public static final IN_PROGRESS IN_PROGRESS = new IN_PROGRESS(null);
    @SuppressLint({"SyntheticAccessor"})
    public static final SUCCESS SUCCESS = new SUCCESS(null);

    public static abstract class State {

        public static final class FAILURE extends State {
            public final Throwable mThrowable;

            public FAILURE(Throwable th) {
                this.mThrowable = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.mThrowable.getMessage()});
            }
        }

        public static final class IN_PROGRESS extends State {
            public IN_PROGRESS(AnonymousClass1 r1) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class SUCCESS extends State {
            public SUCCESS() {
            }

            public String toString() {
                return "SUCCESS";
            }

            public SUCCESS(AnonymousClass1 r1) {
            }
        }
    }
}
