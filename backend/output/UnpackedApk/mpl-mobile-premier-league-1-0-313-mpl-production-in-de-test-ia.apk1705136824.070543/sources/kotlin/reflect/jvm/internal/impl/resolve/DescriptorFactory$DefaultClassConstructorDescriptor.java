package kotlin.reflect.jvm.internal.impl.resolve;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;

public class DescriptorFactory$DefaultClassConstructorDescriptor extends ClassConstructorDescriptorImpl {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "containingClass";
        } else {
            objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DescriptorFactory$DefaultClassConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0027
            if (r10 == 0) goto L_0x0022
            r3 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r1 == 0) goto L_0x0021
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            r5 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r6 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r1 = r8
            r2 = r9
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.util.List r10 = java.util.Collections.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getDefaultConstructorVisibility(r9, r11)
            r8.initialize(r10, r9)
            return
        L_0x0021:
            throw r0
        L_0x0022:
            r9 = 1
            $$$reportNull$$$0(r9)
            throw r0
        L_0x0027:
            r9 = 0
            $$$reportNull$$$0(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory$DefaultClassConstructorDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean):void");
    }
}
