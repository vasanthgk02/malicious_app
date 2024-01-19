package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public abstract class AbstractClassDescriptor extends ModuleAwareClassDescriptor {
    public final NotNullLazyValue<SimpleType> defaultType;
    public final Name name;
    public final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;
    public final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        int i2 = i;
        String str = (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15 || i2 == 16 || i2 == 18 || i2 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15 || i2 == 16 || i2 == 18 || i2 == 19) ? 2 : 3)];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i2 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15) {
            objArr[1] = "getMemberScope";
        } else if (i2 == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i2 == 18) {
            objArr[1] = "substitute";
        } else if (i2 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 11 || i2 == 13 || i2 == 15 || i2 == 16 || i2 == 18 || i2 == 19) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public AbstractClassDescriptor(StorageManager storageManager, Name name2) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (name2 != null) {
            this.name = name2;
            this.defaultType = storageManager.createLazyValue(new Function0<SimpleType>() {
                public Object invoke() {
                    AbstractClassDescriptor abstractClassDescriptor = AbstractClassDescriptor.this;
                    return TypeUtils.makeUnsubstitutedType((ClassifierDescriptor) abstractClassDescriptor, abstractClassDescriptor.getUnsubstitutedMemberScope(), (Function1<KotlinTypeRefiner, SimpleType>) new Function1<KotlinTypeRefiner, SimpleType>() {
                        public Object invoke(Object obj) {
                            ((KotlinTypeRefiner) obj).refineDescriptor(AbstractClassDescriptor.this);
                            return (SimpleType) AbstractClassDescriptor.this.defaultType.invoke();
                        }
                    });
                }
            });
            this.unsubstitutedInnerClassesScope = storageManager.createLazyValue(new Function0<MemberScope>() {
                public Object invoke() {
                    return new InnerClassesScopeWrapper(AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
                }
            });
            this.thisAsReceiverParameter = storageManager.createLazyValue(new Function0<ReceiverParameterDescriptor>() {
                public Object invoke() {
                    return new LazyClassReceiverParameterDescriptor(AbstractClassDescriptor.this);
                }
            });
        } else {
            $$$reportNull$$$0(1);
            throw null;
        }
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d2);
    }

    public SimpleType getDefaultType() {
        SimpleType simpleType = (SimpleType) this.defaultType.invoke();
        if (simpleType != null) {
            return simpleType;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(10);
            throw null;
        } else if (typeSubstitution.isEmpty()) {
            MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(kotlinTypeRefiner);
            if (unsubstitutedMemberScope != null) {
                return unsubstitutedMemberScope;
            }
            $$$reportNull$$$0(11);
            throw null;
        } else {
            return new SubstitutingScope(getUnsubstitutedMemberScope(kotlinTypeRefiner), TypeSubstitutor.create(typeSubstitution));
        }
    }

    public Name getName() {
        Name name2 = this.name;
        if (name2 != null) {
            return name2;
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public ClassDescriptor getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public ClassifierDescriptor m895getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public DeclarationDescriptor m896getOriginal() {
        return this;
    }

    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) this.thisAsReceiverParameter.invoke();
        if (receiverParameterDescriptor != null) {
            return receiverParameterDescriptor;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = (MemberScope) this.unsubstitutedInnerClassesScope.invoke();
        if (memberScope != null) {
            return memberScope;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(17);
            throw null;
        } else if (typeSubstitutor.isEmpty()) {
            return this;
        } else {
            return new LazySubstitutingClassDescriptor(this, typeSubstitutor);
        }
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope != null) {
            return memberScope;
        }
        $$$reportNull$$$0(15);
        throw null;
    }
}
