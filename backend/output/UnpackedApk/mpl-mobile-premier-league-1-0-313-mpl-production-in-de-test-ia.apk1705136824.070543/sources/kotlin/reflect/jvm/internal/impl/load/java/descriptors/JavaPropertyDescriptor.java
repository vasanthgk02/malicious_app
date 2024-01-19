package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    public final boolean isStaticFinal;
    public final Pair<UserDataKey<?>, ?> singleUserData;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 21 ? 3 : 2)];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw (i != 21 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r18, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r19, kotlin.reflect.jvm.internal.impl.descriptors.Modality r20, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r21, boolean r22, kotlin.reflect.jvm.internal.impl.name.Name r23, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r24, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r25, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r26, boolean r27, kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> r28) {
        /*
            r17 = this;
            r15 = r17
            r0 = 0
            if (r18 == 0) goto L_0x0060
            if (r19 == 0) goto L_0x005a
            if (r20 == 0) goto L_0x0054
            if (r21 == 0) goto L_0x004e
            if (r23 == 0) goto L_0x0048
            if (r24 == 0) goto L_0x0042
            if (r26 == 0) goto L_0x003c
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r0 = r17
            r1 = r18
            r2 = r25
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r26
            r9 = r24
            r15 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r17
            r0 = r27
            r1.isStaticFinal = r0
            r0 = r28
            r1.singleUserData = r0
            return
        L_0x003c:
            r1 = r15
            r2 = 6
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0042:
            r1 = r15
            r2 = 5
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0048:
            r1 = r15
            r2 = 4
            $$$reportNull$$$0(r2)
            throw r0
        L_0x004e:
            r1 = r15
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0054:
            r1 = r15
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x005a:
            r1 = r15
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0060:
            r1 = r15
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, boolean, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean, kotlin.Pair):void");
    }

    public static JavaPropertyDescriptor create(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality, DescriptorVisibility descriptorVisibility, boolean z, Name name, SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
            throw null;
        } else if (modality == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (name == null) {
            $$$reportNull$$$0(11);
            throw null;
        } else if (sourceElement != null) {
            JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(declarationDescriptor, annotations, modality, descriptorVisibility, z, name, sourceElement, null, Kind.DECLARATION, z2, null);
            return javaPropertyDescriptor;
        } else {
            $$$reportNull$$$0(12);
            throw null;
        }
    }

    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, PropertyDescriptor propertyDescriptor, Kind kind, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (modality == null) {
            $$$reportNull$$$0(14);
            throw null;
        } else if (descriptorVisibility == null) {
            $$$reportNull$$$0(15);
            throw null;
        } else if (kind == null) {
            $$$reportNull$$$0(16);
            throw null;
        } else if (name == null) {
            $$$reportNull$$$0(17);
            throw null;
        } else if (sourceElement != null) {
            JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(declarationDescriptor, getAnnotations(), modality, descriptorVisibility, this.isVar, name, sourceElement, propertyDescriptor, kind, this.isStaticFinal, this.singleUserData);
            return javaPropertyDescriptor;
        } else {
            $$$reportNull$$$0(18);
            throw null;
        }
    }

    public JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List<ValueParameterData> list, KotlinType kotlinType2, Pair<UserDataKey<?>, ?> pair) {
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType kotlinType3 = kotlinType;
        KotlinType kotlinType4 = kotlinType2;
        if (kotlinType4 != null) {
            PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
            JavaPropertyDescriptor javaPropertyDescriptor = r5;
            JavaPropertyDescriptor javaPropertyDescriptor2 = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), this.isVar, getName(), getSource(), original, getKind(), this.isStaticFinal, pair);
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = this.getter;
            if (propertyGetterDescriptorImpl2 != null) {
                propertyGetterDescriptorImpl = r5;
                PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3 = new PropertyGetterDescriptorImpl(javaPropertyDescriptor, propertyGetterDescriptorImpl2.getAnnotations(), propertyGetterDescriptorImpl2.getModality(), propertyGetterDescriptorImpl2.getVisibility(), propertyGetterDescriptorImpl2.isDefault, propertyGetterDescriptorImpl2.isExternal, propertyGetterDescriptorImpl2.isInline, getKind(), original == null ? null : original.getGetter(), propertyGetterDescriptorImpl2.getSource());
                propertyGetterDescriptorImpl.initialSignatureDescriptor = propertyGetterDescriptorImpl2.initialSignatureDescriptor;
                propertyGetterDescriptorImpl.returnType = kotlinType4;
            } else {
                propertyGetterDescriptorImpl = null;
            }
            PropertySetterDescriptor propertySetterDescriptor = this.setter;
            if (propertySetterDescriptor != null) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = r5;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl3 = new PropertySetterDescriptorImpl(javaPropertyDescriptor, propertySetterDescriptor.getAnnotations(), propertySetterDescriptor.getModality(), propertySetterDescriptor.getVisibility(), propertySetterDescriptor.isDefault(), propertySetterDescriptor.isExternal(), propertySetterDescriptor.isInline(), getKind(), original == null ? null : original.getSetter(), propertySetterDescriptor.getSource());
                propertySetterDescriptorImpl2.initialSignatureDescriptor = propertySetterDescriptorImpl2.initialSignatureDescriptor;
                propertySetterDescriptorImpl2.initialize(propertySetterDescriptor.getValueParameters().get(0));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                propertySetterDescriptorImpl = null;
            }
            JavaPropertyDescriptor javaPropertyDescriptor3 = javaPropertyDescriptor;
            javaPropertyDescriptor3.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, this.backingField, this.delegateField);
            javaPropertyDescriptor3.setterProjectedOut = this.setterProjectedOut;
            NullableLazyValue<ConstantValue<?>> nullableLazyValue = this.compileTimeInitializer;
            if (nullableLazyValue != null) {
                javaPropertyDescriptor3.setCompileTimeInitializer(nullableLazyValue);
            }
            javaPropertyDescriptor3.setOverriddenDescriptors(getOverriddenDescriptors());
            KotlinType kotlinType5 = kotlinType;
            if (kotlinType5 == null) {
                receiverParameterDescriptor = null;
            } else if (Annotations.Companion != null) {
                receiverParameterDescriptor = TweetUtils.createExtensionReceiverParameterForCallable(this, kotlinType5, Companion.EMPTY);
            } else {
                throw null;
            }
            javaPropertyDescriptor3.setType(kotlinType2, getTypeParameters(), this.dispatchReceiverParameter, receiverParameterDescriptor);
            return javaPropertyDescriptor3;
        }
        $$$reportNull$$$0(20);
        throw null;
    }

    public <V> V getUserData(UserDataKey<V> userDataKey) {
        Pair<UserDataKey<?>, ?> pair = this.singleUserData;
        if (pair == null || !((UserDataKey) pair.first).equals(userDataKey)) {
            return null;
        }
        return this.singleUserData.second;
    }

    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r1 == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.hasEnhancedNullability(r0) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r0) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r0) != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r0) != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r0) == false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isConst() {
        /*
            r4 = this;
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r4.getType()
            boolean r1 = r4.isStaticFinal
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0042
            java.lang.String r1 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            boolean r1 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r0)
            if (r1 != 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes r1 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.INSTANCE
            boolean r1 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r0)
            if (r1 == 0) goto L_0x0029
        L_0x0023:
            boolean r1 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r0)
            if (r1 == 0) goto L_0x0032
        L_0x0029:
            boolean r1 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r0)
            if (r1 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r1 = 0
            goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            if (r1 == 0) goto L_0x0042
            boolean r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.hasEnhancedNullability(r0)
            if (r1 == 0) goto L_0x0043
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r0)
            if (r0 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.isConst():boolean");
    }
}
