package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.apache.fontbox.cmap.CMap;

public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "variance";
        } else if (i == 4) {
            objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
        } else if (i != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbstractLazyTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager r12, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r13, kotlin.reflect.jvm.internal.impl.name.Name r14, kotlin.reflect.jvm.internal.impl.types.Variance r15, boolean r16, int r17, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r19) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0037
            if (r13 == 0) goto L_0x0032
            if (r14 == 0) goto L_0x002d
            if (r15 == 0) goto L_0x0028
            if (r19 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r1 == 0) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        L_0x0022:
            throw r0
        L_0x0023:
            r1 = 5
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0028:
            r1 = 3
            $$$reportNull$$$0(r1)
            throw r0
        L_0x002d:
            r1 = 2
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0032:
            r1 = 1
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0037:
            r1 = 0
            $$$reportNull$$$0(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.Variance, boolean, int, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker):void");
    }

    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = this.reified ? "reified " : str;
        if (getVariance() != Variance.INVARIANT) {
            str = getVariance() + CMap.SPACE;
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
