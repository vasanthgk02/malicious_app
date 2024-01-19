package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {
    public List<TypeParameterDescriptor> declaredTypeParameters;
    public TypeSubstitutor newSubstitutor;
    public final ModuleAwareClassDescriptor original;
    public final TypeSubstitutor originalSubstitutor;
    public TypeConstructor typeConstructor;
    public List<TypeParameterDescriptor> typeConstructorParameters;

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e2 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void $$$reportNull$$$0(int r15) {
        /*
            r0 = 22
            r1 = 13
            r2 = 10
            r3 = 8
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 2
            if (r15 == r7) goto L_0x001f
            if (r15 == r6) goto L_0x001f
            if (r15 == r5) goto L_0x001f
            if (r15 == r4) goto L_0x001f
            if (r15 == r3) goto L_0x001f
            if (r15 == r2) goto L_0x001f
            if (r15 == r1) goto L_0x001f
            if (r15 == r0) goto L_0x001f
            java.lang.String r8 = "@NotNull method %s.%s must not return null"
            goto L_0x0021
        L_0x001f:
            java.lang.String r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
        L_0x0021:
            if (r15 == r7) goto L_0x0033
            if (r15 == r6) goto L_0x0033
            if (r15 == r5) goto L_0x0033
            if (r15 == r4) goto L_0x0033
            if (r15 == r3) goto L_0x0033
            if (r15 == r2) goto L_0x0033
            if (r15 == r1) goto L_0x0033
            if (r15 == r0) goto L_0x0033
            r9 = 2
            goto L_0x0034
        L_0x0033:
            r9 = 3
        L_0x0034:
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor"
            r11 = 0
            if (r15 == r7) goto L_0x005d
            if (r15 == r6) goto L_0x0058
            if (r15 == r5) goto L_0x0052
            if (r15 == r4) goto L_0x0058
            if (r15 == r3) goto L_0x005d
            if (r15 == r2) goto L_0x0052
            if (r15 == r1) goto L_0x0058
            if (r15 == r0) goto L_0x004c
            r9[r11] = r10
            goto L_0x0062
        L_0x004c:
            java.lang.String r12 = "substitutor"
            r9[r11] = r12
            goto L_0x0062
        L_0x0052:
            java.lang.String r12 = "typeSubstitution"
            r9[r11] = r12
            goto L_0x0062
        L_0x0058:
            java.lang.String r12 = "kotlinTypeRefiner"
            r9[r11] = r12
            goto L_0x0062
        L_0x005d:
            java.lang.String r12 = "typeArguments"
            r9[r11] = r12
        L_0x0062:
            java.lang.String r11 = "substitute"
            java.lang.String r12 = "getUnsubstitutedMemberScope"
            java.lang.String r13 = "getMemberScope"
            r14 = 1
            switch(r15) {
                case 2: goto L_0x00c1;
                case 3: goto L_0x00c1;
                case 4: goto L_0x00be;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00c1;
                case 7: goto L_0x00be;
                case 8: goto L_0x00c1;
                case 9: goto L_0x00be;
                case 10: goto L_0x00c1;
                case 11: goto L_0x00be;
                case 12: goto L_0x00bb;
                case 13: goto L_0x00c1;
                case 14: goto L_0x00bb;
                case 15: goto L_0x00b6;
                case 16: goto L_0x00b1;
                case 17: goto L_0x00ac;
                case 18: goto L_0x00a7;
                case 19: goto L_0x00a2;
                case 20: goto L_0x009d;
                case 21: goto L_0x0098;
                case 22: goto L_0x00c1;
                case 23: goto L_0x0095;
                case 24: goto L_0x0090;
                case 25: goto L_0x008b;
                case 26: goto L_0x0086;
                case 27: goto L_0x0081;
                case 28: goto L_0x007c;
                case 29: goto L_0x0077;
                case 30: goto L_0x0072;
                default: goto L_0x006d;
            }
        L_0x006d:
            java.lang.String r10 = "getTypeConstructor"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0072:
            java.lang.String r10 = "getSealedSubclasses"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0077:
            java.lang.String r10 = "getDeclaredTypeParameters"
            r9[r14] = r10
            goto L_0x00c3
        L_0x007c:
            java.lang.String r10 = "getSource"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0081:
            java.lang.String r10 = "getUnsubstitutedInnerClassesScope"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0086:
            java.lang.String r10 = "getVisibility"
            r9[r14] = r10
            goto L_0x00c3
        L_0x008b:
            java.lang.String r10 = "getModality"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0090:
            java.lang.String r10 = "getKind"
            r9[r14] = r10
            goto L_0x00c3
        L_0x0095:
            r9[r14] = r11
            goto L_0x00c3
        L_0x0098:
            java.lang.String r10 = "getContainingDeclaration"
            r9[r14] = r10
            goto L_0x00c3
        L_0x009d:
            java.lang.String r10 = "getOriginal"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00a2:
            java.lang.String r10 = "getName"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00a7:
            java.lang.String r10 = "getAnnotations"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00ac:
            java.lang.String r10 = "getConstructors"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00b1:
            java.lang.String r10 = "getDefaultType"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00b6:
            java.lang.String r10 = "getStaticScope"
            r9[r14] = r10
            goto L_0x00c3
        L_0x00bb:
            r9[r14] = r12
            goto L_0x00c3
        L_0x00be:
            r9[r14] = r13
            goto L_0x00c3
        L_0x00c1:
            r9[r14] = r10
        L_0x00c3:
            if (r15 == r7) goto L_0x00da
            if (r15 == r6) goto L_0x00da
            if (r15 == r5) goto L_0x00da
            if (r15 == r4) goto L_0x00da
            if (r15 == r3) goto L_0x00da
            if (r15 == r2) goto L_0x00da
            if (r15 == r1) goto L_0x00d7
            if (r15 == r0) goto L_0x00d4
            goto L_0x00dc
        L_0x00d4:
            r9[r7] = r11
            goto L_0x00dc
        L_0x00d7:
            r9[r7] = r12
            goto L_0x00dc
        L_0x00da:
            r9[r7] = r13
        L_0x00dc:
            java.lang.String r8 = java.lang.String.format(r8, r9)
            if (r15 == r7) goto L_0x00f6
            if (r15 == r6) goto L_0x00f6
            if (r15 == r5) goto L_0x00f6
            if (r15 == r4) goto L_0x00f6
            if (r15 == r3) goto L_0x00f6
            if (r15 == r2) goto L_0x00f6
            if (r15 == r1) goto L_0x00f6
            if (r15 == r0) goto L_0x00f6
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>(r8)
            goto L_0x00fb
        L_0x00f6:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
        L_0x00fb:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.$$$reportNull$$$0(int):void");
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor typeSubstitutor) {
        this.original = moduleAwareClassDescriptor;
        this.originalSubstitutor = typeSubstitutor;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d2);
    }

    public Annotations getAnnotations() {
        Annotations annotations = this.original.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.original.getCompanionObjectDescriptor();
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.original.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor next : constructors) {
            arrayList.add(((ClassConstructorDescriptor) next.newCopyBuilder().setOriginal(next.getOriginal()).setModality(next.getModality()).setVisibility(next.getVisibility()).setKind(next.getKind()).setCopyOverrides(false).build()).substitute(getSubstitutor()));
        }
        return arrayList;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.original.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        $$$reportNull$$$0(21);
        throw null;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        getSubstitutor();
        List<TypeParameterDescriptor> list = this.declaredTypeParameters;
        if (list != null) {
            return list;
        }
        $$$reportNull$$$0(29);
        throw null;
    }

    public SimpleType getDefaultType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
    }

    public ClassKind getKind() {
        ClassKind kind = this.original.getKind();
        if (kind != null) {
            return kind;
        }
        $$$reportNull$$$0(24);
        throw null;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (kotlinTypeRefiner != null) {
            MemberScope memberScope = this.original.getMemberScope(typeSubstitution, kotlinTypeRefiner);
            if (!this.originalSubstitutor.isEmpty()) {
                return new SubstitutingScope(memberScope, getSubstitutor());
            }
            if (memberScope != null) {
                return memberScope;
            }
            $$$reportNull$$$0(7);
            throw null;
        } else {
            $$$reportNull$$$0(6);
            throw null;
        }
    }

    public Modality getModality() {
        Modality modality = this.original.getModality();
        if (modality != null) {
            return modality;
        }
        $$$reportNull$$$0(25);
        throw null;
    }

    public Name getName() {
        Name name = this.original.getName();
        if (name != null) {
            return name;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.original.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        $$$reportNull$$$0(30);
        throw null;
    }

    public SourceElement getSource() {
        return SourceElement.NO_SOURCE;
    }

    public MemberScope getStaticScope() {
        MemberScope staticScope = this.original.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public final TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor == null) {
            if (this.originalSubstitutor.isEmpty()) {
                this.newSubstitutor = this.originalSubstitutor;
            } else {
                List<TypeParameterDescriptor> parameters = this.original.getTypeConstructor().getParameters();
                this.typeConstructorParameters = new ArrayList(parameters.size());
                this.newSubstitutor = TweetUtils.substituteTypeParameters(parameters, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
                this.declaredTypeParameters = ArraysKt___ArraysJvmKt.filter(this.typeConstructorParameters, new Function1<TypeParameterDescriptor, Boolean>(this) {
                    public Object invoke(Object obj) {
                        return Boolean.valueOf(!((TypeParameterDescriptor) obj).isCapturedFromOuterDeclaration());
                    }
                });
            }
        }
        return this.newSubstitutor;
    }

    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.original.getTypeConstructor();
        if (!this.originalSubstitutor.isEmpty()) {
            if (this.typeConstructor == null) {
                TypeSubstitutor substitutor = getSubstitutor();
                Collection<KotlinType> supertypes = typeConstructor2.getSupertypes();
                ArrayList arrayList = new ArrayList(supertypes.size());
                for (KotlinType substitute : supertypes) {
                    arrayList.add(substitutor.substitute(substitute, Variance.INVARIANT));
                }
                this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, arrayList, LockBasedStorageManager.NO_LOCKS);
            }
            TypeConstructor typeConstructor3 = this.typeConstructor;
            if (typeConstructor3 != null) {
                return typeConstructor3;
            }
            $$$reportNull$$$0(1);
            throw null;
        } else if (typeConstructor2 != null) {
            return typeConstructor2;
        } else {
            $$$reportNull$$$0(0);
            throw null;
        }
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.original.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        $$$reportNull$$$0(27);
        throw null;
    }

    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        $$$reportNull$$$0(12);
        throw null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.original.getUnsubstitutedPrimaryConstructor();
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility visibility = this.original.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        $$$reportNull$$$0(26);
        throw null;
    }

    public boolean isActual() {
        return this.original.isActual();
    }

    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    public boolean isData() {
        return this.original.isData();
    }

    public boolean isExpect() {
        return this.original.isExpect();
    }

    public boolean isExternal() {
        return this.original.isExternal();
    }

    public boolean isFun() {
        return this.original.isFun();
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isInner() {
        return this.original.isInner();
    }

    public boolean isValue() {
        return this.original.isValue();
    }

    public DeclarationDescriptorNonRoot substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
            throw null;
        } else if (typeSubstitutor.isEmpty()) {
            return this;
        } else {
            return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(typeSubstitutor.getSubstitution(), getSubstitutor().getSubstitution()));
        }
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            MemberScope unsubstitutedMemberScope = this.original.getUnsubstitutedMemberScope(kotlinTypeRefiner);
            if (!this.originalSubstitutor.isEmpty()) {
                return new SubstitutingScope(unsubstitutedMemberScope, getSubstitutor());
            }
            if (unsubstitutedMemberScope != null) {
                return unsubstitutedMemberScope;
            }
            $$$reportNull$$$0(14);
            throw null;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public ClassDescriptor getOriginal() {
        ClassDescriptor original2 = this.original.getOriginal();
        if (original2 != null) {
            return original2;
        }
        $$$reportNull$$$0(20);
        throw null;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope != null) {
            return memberScope;
        }
        $$$reportNull$$$0(11);
        throw null;
    }
}
