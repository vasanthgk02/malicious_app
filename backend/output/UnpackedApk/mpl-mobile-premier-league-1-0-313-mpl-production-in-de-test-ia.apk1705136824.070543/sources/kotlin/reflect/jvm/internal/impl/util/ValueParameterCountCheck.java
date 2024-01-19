package kotlin.reflect.jvm.internal.impl.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: modifierChecks.kt */
public abstract class ValueParameterCountCheck implements Check {
    public final String description;

    /* compiled from: modifierChecks.kt */
    public static final class AtLeast extends ValueParameterCountCheck {
        public final int n;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public AtLeast(int i) {
            // StringBuilder outline74 = GeneratedOutlineSupport.outline74("must have at least ", i, " value parameter");
            // outline74.append(i > 1 ? "s" : "");
            super(outline74.toString(), null);
            this.n = i;
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.n;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class Equals extends ValueParameterCountCheck {
        public final int n;

        public Equals(int i) {
            super(GeneratedOutlineSupport.outline42("must have exactly ", i, " value parameters"), null);
            this.n = i;
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.n;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        public NoValueParameters() {
            super("must have no value parameters", null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        public SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }
    }

    public ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return TypeUtilsKt.invoke(this, functionDescriptor);
    }
}
