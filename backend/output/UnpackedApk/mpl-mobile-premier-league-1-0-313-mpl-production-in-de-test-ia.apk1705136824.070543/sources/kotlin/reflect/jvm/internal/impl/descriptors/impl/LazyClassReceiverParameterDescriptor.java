package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    public final ClassDescriptor descriptor;
    public final ImplicitClassReceiver receiverValue;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i == 1 || i == 2)) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyClassReceiverParameterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r1 == 0) goto L_0x0016
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            r2.<init>(r1)
            r2.descriptor = r3
            kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver r1 = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver
            r1.<init>(r3, r0)
            r2.receiverValue = r1
            return
        L_0x0016:
            throw r0
        L_0x0017:
            r3 = 0
            $$$reportNull$$$0(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyClassReceiverParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):void");
    }

    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.descriptor;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.receiverValue;
        if (implicitClassReceiver != null) {
            return implicitClassReceiver;
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("class ");
        outline73.append(this.descriptor.getName());
        outline73.append("::this");
        return outline73.toString();
    }
}
