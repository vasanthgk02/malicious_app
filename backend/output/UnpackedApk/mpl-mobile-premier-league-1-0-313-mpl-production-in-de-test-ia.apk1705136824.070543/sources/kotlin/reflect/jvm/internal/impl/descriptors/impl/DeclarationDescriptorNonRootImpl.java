package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;

public abstract class DeclarationDescriptorNonRootImpl extends DeclarationDescriptorImpl implements DeclarationDescriptorNonRoot {
    public final DeclarationDescriptor containingDeclaration;
    public final SourceElement source;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (!(i == 4 || i == 5 || i == 6)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5 || i == 6) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeclarationDescriptorNonRootImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3, kotlin.reflect.jvm.internal.impl.name.Name r4, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r5) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0020
            if (r3 == 0) goto L_0x001b
            if (r4 == 0) goto L_0x0016
            if (r5 == 0) goto L_0x0011
            r1.<init>(r3, r4)
            r1.containingDeclaration = r2
            r1.source = r5
            return
        L_0x0011:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0016:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x001b:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0020:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public DeclarationDescriptorWithSource getOriginal() {
        return this;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement != null) {
            return sourceElement;
        }
        $$$reportNull$$$0(6);
        throw null;
    }
}
