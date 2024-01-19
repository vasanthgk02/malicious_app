package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;

public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    public final DeclarationDescriptor containingDeclaration;
    public final boolean isExternal;
    public final SourceElement source;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5) ? 2 : 3)];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (!(i == 4 || i == 5)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassDescriptorBase(kotlin.reflect.jvm.internal.impl.storage.StorageManager r2, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3, kotlin.reflect.jvm.internal.impl.name.Name r4, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r5, boolean r6) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0022
            if (r3 == 0) goto L_0x001d
            if (r4 == 0) goto L_0x0018
            if (r5 == 0) goto L_0x0013
            r1.<init>(r2, r4)
            r1.containingDeclaration = r3
            r1.source = r5
            r1.isExternal = r6
            return
        L_0x0013:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0018:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x001d:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0022:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean):void");
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement != null) {
            return sourceElement;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public boolean isExternal() {
        return this.isExternal;
    }
}
