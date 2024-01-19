package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;

public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    public NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    public final boolean isVar;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VariableDescriptorWithInitializerImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r8, kotlin.reflect.jvm.internal.impl.name.Name r9, kotlin.reflect.jvm.internal.impl.types.KotlinType r10, boolean r11, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r12) {
        /*
            r6 = this;
            r10 = 0
            if (r7 == 0) goto L_0x0024
            if (r8 == 0) goto L_0x001f
            if (r9 == 0) goto L_0x001a
            if (r12 == 0) goto L_0x0015
            r4 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.isVar = r11
            return
        L_0x0015:
            r7 = 3
            $$$reportNull$$$0(r7)
            throw r10
        L_0x001a:
            r7 = 2
            $$$reportNull$$$0(r7)
            throw r10
        L_0x001f:
            r7 = 1
            $$$reportNull$$$0(r7)
            throw r10
        L_0x0024:
            r7 = 0
            $$$reportNull$$$0(r7)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public ConstantValue<?> getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> nullableLazyValue = this.compileTimeInitializer;
        if (nullableLazyValue != null) {
            return (ConstantValue) nullableLazyValue.invoke();
        }
        return null;
    }

    public boolean isVar() {
        return this.isVar;
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> nullableLazyValue) {
        if (nullableLazyValue != null) {
            this.compileTimeInitializer = nullableLazyValue;
        } else {
            $$$reportNull$$$0(4);
            throw null;
        }
    }
}
