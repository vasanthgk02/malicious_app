package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    public static final Name NAME = Name.special("<init>");
    public final boolean isPrimary;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        if (!(i == 19 || i == 25)) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i == 19 || i == 25)) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    i2 = 3;
                    break;
            }
        }
        i2 = 2;
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 19) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 25) {
            switch (i) {
                case 15:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 16:
                    objArr[1] = "getConstructedClass";
                    break;
                case 17:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i == 19 || i == 25)) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
        }
        th = new IllegalStateException(format);
        throw th;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassConstructorDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11, boolean r12, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r13, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r14) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0026
            if (r11 == 0) goto L_0x0021
            if (r13 == 0) goto L_0x001c
            if (r14 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.name.Name r5 = NAME
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.isPrimary = r12
            return
        L_0x0017:
            r9 = 3
            $$$reportNull$$$0(r9)
            throw r0
        L_0x001c:
            r9 = 2
            $$$reportNull$$$0(r9)
            throw r0
        L_0x0021:
            r9 = 1
            $$$reportNull$$$0(r9)
            throw r0
        L_0x0026:
            r9 = 0
            $$$reportNull$$$0(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, d2);
    }

    public CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, descriptorVisibility, kind, z);
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        $$$reportNull$$$0(25);
        throw null;
    }

    public ClassDescriptor getConstructedClass() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (descriptorVisibility != null) {
            initialize(list, descriptorVisibility, getContainingDeclaration().getDeclaredTypeParameters());
            return this;
        } else {
            $$$reportNull$$$0(14);
            throw null;
        }
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(20);
            throw null;
        }
    }

    /* renamed from: copy  reason: collision with other method in class */
    public FunctionDescriptor m903copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, descriptorVisibility, kind, z);
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        $$$reportNull$$$0(25);
        throw null;
    }

    public ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(21);
            throw null;
        } else if (kind == null) {
            $$$reportNull$$$0(22);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(23);
            throw null;
        } else if (sourceElement == null) {
            $$$reportNull$$$0(24);
            throw null;
        } else if (kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED) {
            ClassConstructorDescriptorImpl classConstructorDescriptorImpl = new ClassConstructorDescriptorImpl((ClassDescriptor) declarationDescriptor, this, annotations, this.isPrimary, Kind.DECLARATION, sourceElement);
            return classConstructorDescriptorImpl;
        } else {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + declarationDescriptor + "\n" + "kind: " + kind);
        }
    }

    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor != null) {
            return classDescriptor;
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, DescriptorVisibility descriptorVisibility, List<TypeParameterDescriptor> list2) {
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (list == null) {
            $$$reportNull$$$0(10);
            throw null;
        } else if (descriptorVisibility == null) {
            $$$reportNull$$$0(11);
            throw null;
        } else if (list2 != null) {
            ClassDescriptor containingDeclaration = getContainingDeclaration();
            if (containingDeclaration.isInner()) {
                DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    receiverParameterDescriptor = ((ClassDescriptor) containingDeclaration2).getThisAsReceiverParameter();
                }
            }
            super.initialize(null, receiverParameterDescriptor, list2, list, null, Modality.FINAL, descriptorVisibility);
            return this;
        } else {
            $$$reportNull$$$0(12);
            throw null;
        }
    }

    public ClassConstructorDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor != null) {
            return (ClassConstructorDescriptor) super.substitute(typeSubstitutor);
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor != null) {
            return classConstructorDescriptor;
        }
        $$$reportNull$$$0(17);
        throw null;
    }
}
