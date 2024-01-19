package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class MutableClassDescriptor extends ClassDescriptorBase {
    public final boolean isInner;
    public final ClassKind kind;
    public Modality modality;
    public final StorageManager storageManager;
    public final Collection<KotlinType> supertypes;
    public TypeConstructor typeConstructor;
    public List<TypeParameterDescriptor> typeParameters;
    public DescriptorVisibility visibility;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
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
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
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
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
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
    public MutableClassDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r8, boolean r9, boolean r10, kotlin.reflect.jvm.internal.impl.name.Name r11, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r12, kotlin.reflect.jvm.internal.impl.storage.StorageManager r13) {
        /*
            r6 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0028
            if (r11 == 0) goto L_0x0023
            if (r13 == 0) goto L_0x001e
            r0 = r6
            r1 = r13
            r2 = r7
            r3 = r11
            r4 = r12
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.supertypes = r7
            r6.storageManager = r13
            r6.kind = r8
            r6.isInner = r9
            return
        L_0x001e:
            r7 = 4
            $$$reportNull$$$0(r7)
            throw r0
        L_0x0023:
            r7 = 2
            $$$reportNull$$$0(r7)
            throw r0
        L_0x0028:
            r7 = 1
            $$$reportNull$$$0(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind, boolean, boolean, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public void createTypeConstructor() {
        this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeParameters, this.supertypes, this.storageManager);
        Set<ClassConstructorDescriptor> emptySet = Collections.emptySet();
        if (emptySet != null) {
            for (ClassConstructorDescriptor classConstructorDescriptor : emptySet) {
                ((ClassConstructorDescriptorImpl) classConstructorDescriptor).setReturnType(getDefaultType());
            }
            return;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public Annotations getAnnotations() {
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            if (annotations != null) {
                return annotations;
            }
            $$$reportNull$$$0(5);
            throw null;
        }
        throw null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public Collection getConstructors() {
        Set emptySet = Collections.emptySet();
        if (emptySet != null) {
            return emptySet;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public ClassKind getKind() {
        ClassKind classKind = this.kind;
        if (classKind != null) {
            return classKind;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 != null) {
            return modality2;
        }
        $$$reportNull$$$0(7);
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
        $$$reportNull$$$0(11);
        throw null;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return Empty.INSTANCE;
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        $$$reportNull$$$0(10);
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
        return this.isInner;
    }

    public boolean isValue() {
        return false;
    }

    public void setTypeParameterDescriptors(List<TypeParameterDescriptor> list) {
        if (this.typeParameters == null) {
            this.typeParameters = new ArrayList(list);
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type parameters are already set for ");
        outline73.append(getName());
        throw new IllegalStateException(outline73.toString());
    }

    public String toString() {
        return DeclarationDescriptorImpl.toString(this);
    }
}
