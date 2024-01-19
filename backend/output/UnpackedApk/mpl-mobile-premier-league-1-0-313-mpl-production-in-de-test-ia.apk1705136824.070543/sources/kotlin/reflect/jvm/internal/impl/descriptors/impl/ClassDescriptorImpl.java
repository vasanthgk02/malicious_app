package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class ClassDescriptorImpl extends ClassDescriptorBase {
    public Set<ClassConstructorDescriptor> constructors;
    public final ClassKind kind;
    public final Modality modality;
    public ClassConstructorDescriptor primaryConstructor;
    public final TypeConstructor typeConstructor;
    public MemberScope unsubstitutedMemberScope;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7, kotlin.reflect.jvm.internal.impl.name.Name r8, kotlin.reflect.jvm.internal.impl.descriptors.Modality r9, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r10, java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r11, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r12, boolean r13, kotlin.reflect.jvm.internal.impl.storage.StorageManager r14) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x003f
            if (r8 == 0) goto L_0x003a
            if (r9 == 0) goto L_0x0035
            if (r10 == 0) goto L_0x0030
            if (r11 == 0) goto L_0x002b
            if (r14 == 0) goto L_0x0026
            r0 = r6
            r1 = r14
            r2 = r7
            r3 = r8
            r4 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r6.modality = r9
            r6.kind = r10
            kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl r7 = new kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl
            java.util.List r8 = java.util.Collections.emptyList()
            r7.<init>(r6, r8, r11, r14)
            r6.typeConstructor = r7
            return
        L_0x0026:
            r7 = 6
            $$$reportNull$$$0(r7)
            throw r0
        L_0x002b:
            r7 = 4
            $$$reportNull$$$0(r7)
            throw r0
        L_0x0030:
            r7 = 3
            $$$reportNull$$$0(r7)
            throw r0
        L_0x0035:
            r7 = 2
            $$$reportNull$$$0(r7)
            throw r0
        L_0x003a:
            r7 = 1
            $$$reportNull$$$0(r7)
            throw r0
        L_0x003f:
            r7 = 0
            $$$reportNull$$$0(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind, java.util.Collection, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean, kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public Annotations getAnnotations() {
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            if (annotations != null) {
                return annotations;
            }
            $$$reportNull$$$0(9);
            throw null;
        }
        throw null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> set = this.constructors;
        if (set != null) {
            return set;
        }
        $$$reportNull$$$0(11);
        throw null;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public ClassKind getKind() {
        ClassKind classKind = this.kind;
        if (classKind != null) {
            return classKind;
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 != null) {
            return modality2;
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public MemberScope getStaticScope() {
        return Empty.INSTANCE;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 != null) {
            return typeConstructor2;
        }
        $$$reportNull$$$0(10);
        throw null;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            MemberScope memberScope = this.unsubstitutedMemberScope;
            if (memberScope != null) {
                return memberScope;
            }
            $$$reportNull$$$0(13);
            throw null;
        }
        $$$reportNull$$$0(12);
        throw null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        $$$reportNull$$$0(17);
        throw null;
    }

    public final void initialize(MemberScope memberScope, Set<ClassConstructorDescriptor> set, ClassConstructorDescriptor classConstructorDescriptor) {
        if (set != null) {
            this.unsubstitutedMemberScope = memberScope;
            this.constructors = set;
            this.primaryConstructor = classConstructorDescriptor;
            return;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("class ");
        outline73.append(getName());
        return outline73.toString();
    }
}
