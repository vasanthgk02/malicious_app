package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    public Boolean hasStableParameterNames;
    public Boolean hasSynthesizedParameterNames;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 11 || i == 18) ? 2 : 3)];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 11 || i == 18) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaClassConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2, kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4, boolean r5, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r6, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0020
            if (r4 == 0) goto L_0x001b
            if (r6 == 0) goto L_0x0016
            if (r7 == 0) goto L_0x0011
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1.hasStableParameterNames = r0
            r1.hasSynthesizedParameterNames = r0
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor classDescriptor, Annotations annotations, boolean z, SourceElement sourceElement) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (sourceElement != null) {
            JavaClassConstructorDescriptor javaClassConstructorDescriptor = new JavaClassConstructorDescriptor(classDescriptor, null, annotations, z, Kind.DECLARATION, sourceElement);
            return javaClassConstructorDescriptor;
        } else {
            $$$reportNull$$$0(6);
            throw null;
        }
    }

    public JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Pair pair) {
        KotlinType kotlinType3 = kotlinType;
        Pair pair2 = pair;
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (kotlinType2 != null) {
            JavaClassConstructorDescriptor createSubstitutedCopy = createSubstitutedCopy((DeclarationDescriptor) getContainingDeclaration(), (FunctionDescriptor) null, getKind(), (Name) null, getAnnotations(), getSource());
            if (kotlinType3 != null) {
                if (Annotations.Companion != null) {
                    receiverParameterDescriptor = TweetUtils.createExtensionReceiverParameterForCallable(createSubstitutedCopy, kotlinType, Companion.EMPTY);
                } else {
                    throw null;
                }
            }
            List list2 = list;
            createSubstitutedCopy.initialize(receiverParameterDescriptor, this.dispatchReceiverParameter, getTypeParameters(), TweetUtils.copyValueParameters(list, getValueParameters(), createSubstitutedCopy), kotlinType2, getModality(), getVisibility());
            if (pair2 != null) {
                createSubstitutedCopy.putInUserDataMap((UserDataKey) pair2.first, pair2.second);
            }
            return createSubstitutedCopy;
        }
        $$$reportNull$$$0(17);
        throw null;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames.booleanValue();
    }

    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames.booleanValue();
    }

    public void setHasStableParameterNames(boolean z) {
        this.hasStableParameterNames = Boolean.valueOf(z);
    }

    public void setHasSynthesizedParameterNames(boolean z) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(z);
    }

    public JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
            throw null;
        } else if (kind == null) {
            $$$reportNull$$$0(8);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (sourceElement == null) {
            $$$reportNull$$$0(10);
            throw null;
        } else if (kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            JavaClassConstructorDescriptor javaClassConstructorDescriptor = (JavaClassConstructorDescriptor) functionDescriptor;
            if (classDescriptor == null) {
                $$$reportNull$$$0(12);
                throw null;
            } else if (kind == null) {
                $$$reportNull$$$0(13);
                throw null;
            } else if (sourceElement == null) {
                $$$reportNull$$$0(14);
                throw null;
            } else if (annotations != null) {
                JavaClassConstructorDescriptor javaClassConstructorDescriptor2 = new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations, this.isPrimary, kind, sourceElement);
                javaClassConstructorDescriptor2.setHasStableParameterNames(hasStableParameterNames());
                javaClassConstructorDescriptor2.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
                return javaClassConstructorDescriptor2;
            } else {
                $$$reportNull$$$0(15);
                throw null;
            }
        } else {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + declarationDescriptor + "\n" + "kind: " + kind);
        }
    }
}
