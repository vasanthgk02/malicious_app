package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

public final class DescriptorResolverUtils$1 extends NonReportingOverrideStrategy {
    public final /* synthetic */ ErrorReporter val$errorReporter;
    public final /* synthetic */ boolean val$isStaticContext;
    public final /* synthetic */ Set val$result;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i == 2) {
            objArr[0] = "fromCurrent";
        } else if (i == 3) {
            objArr[0] = "member";
        } else if (i != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "setOverriddenDescriptors";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public DescriptorResolverUtils$1(ErrorReporter errorReporter, Set set, boolean z) {
        this.val$errorReporter = errorReporter;
        this.val$result = set;
        this.val$isStaticContext = z;
    }

    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor != null) {
            OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, new Function1<CallableMemberDescriptor, Unit>() {
                public Object invoke(Object obj) {
                    CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                    if (callableMemberDescriptor != null) {
                        DescriptorResolverUtils$1.this.val$errorReporter.reportCannotInferVisibility(callableMemberDescriptor);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"}));
                }
            });
            this.val$result.add(callableMemberDescriptor);
            return;
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
    }

    public void setOverriddenDescriptors(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(3);
            throw null;
        } else if (!this.val$isStaticContext || callableMemberDescriptor.getKind() == Kind.FAKE_OVERRIDE) {
            super.setOverriddenDescriptors(callableMemberDescriptor, collection);
        }
    }
}
