package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: modifierChecks.kt */
public abstract class MemberKindCheck implements Check {
    public final String description;

    /* compiled from: modifierChecks.kt */
    public static final class Member extends MemberKindCheck {
        public static final Member INSTANCE = new Member();

        public Member() {
            super("must be a member function", null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getDispatchReceiverParameter() != null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class MemberOrExtension extends MemberKindCheck {
        public static final MemberOrExtension INSTANCE = new MemberOrExtension();

        public MemberOrExtension() {
            super("must be a member or an extension function", null);
        }

        public boolean check(FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.getDispatchReceiverParameter() == null && functionDescriptor.getExtensionReceiverParameter() == null) ? false : true;
        }
    }

    public MemberKindCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return TypeUtilsKt.invoke(this, functionDescriptor);
    }
}
