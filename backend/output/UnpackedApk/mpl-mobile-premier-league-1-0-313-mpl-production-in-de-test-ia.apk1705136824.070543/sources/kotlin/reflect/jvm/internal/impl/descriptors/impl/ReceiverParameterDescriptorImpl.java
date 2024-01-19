package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    public final DeclarationDescriptor containingDeclaration;
    public final ReceiverValue value;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 4) ? 2 : 3)];
        if (i == 1) {
            objArr[0] = HSLCriteriaBuilder.VALUE;
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i == 3 || i == 4)) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReceiverParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0012
            if (r4 == 0) goto L_0x000d
            r1.<init>(r4)
            r1.containingDeclaration = r2
            r1.value = r3
            return
        L_0x000d:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0012:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):void");
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.value;
        if (receiverValue != null) {
            return receiverValue;
        }
        $$$reportNull$$$0(3);
        throw null;
    }
}
