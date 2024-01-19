package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: modifierChecks.kt */
public abstract class CheckResult {
    public final boolean isSuccess;

    /* compiled from: modifierChecks.kt */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        public IllegalFunctionName() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class IllegalSignature extends CheckResult {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public IllegalSignature(String str) {
            // Intrinsics.checkNotNullParameter(str, "error");
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        public SuccessCheck() {
            super(true, null);
        }
    }

    public CheckResult(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this.isSuccess = z;
    }
}
