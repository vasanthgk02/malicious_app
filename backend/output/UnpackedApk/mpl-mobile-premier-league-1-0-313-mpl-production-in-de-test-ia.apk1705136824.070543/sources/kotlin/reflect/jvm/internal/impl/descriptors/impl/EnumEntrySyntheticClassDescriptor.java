package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    public final Annotations annotations;
    public final NotNullLazyValue<Set<Name>> enumMemberNames;
    public final MemberScope scope;
    public final TypeConstructor typeConstructor;

    public class EnumEntryScope extends MemberScopeImpl {
        public final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        public final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> functions;
        public final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> properties;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            }
            str = "@NotNull method %s.%s must not return null";
            if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
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
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = "name";
                    break;
                case 2:
                case 6:
                    objArr[0] = "location";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i != 12) {
                switch (i) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        th = new IllegalArgumentException(format);
                        break;
                }
            }
            th = new IllegalStateException(format);
            throw th;
        }

        public EnumEntryScope(StorageManager storageManager) {
            this.functions = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(EnumEntrySyntheticClassDescriptor.this) {
                public Object invoke(Object obj) {
                    Name name = (Name) obj;
                    EnumEntryScope enumEntryScope = EnumEntryScope.this;
                    if (enumEntryScope == null) {
                        throw null;
                    } else if (name != null) {
                        return enumEntryScope.resolveFakeOverrides(name, enumEntryScope.getSupertypeScope().getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                    } else {
                        EnumEntryScope.$$$reportNull$$$0(8);
                        throw null;
                    }
                }
            });
            this.properties = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends PropertyDescriptor>>(EnumEntrySyntheticClassDescriptor.this) {
                public Object invoke(Object obj) {
                    Name name = (Name) obj;
                    EnumEntryScope enumEntryScope = EnumEntryScope.this;
                    if (enumEntryScope == null) {
                        throw null;
                    } else if (name != null) {
                        return enumEntryScope.resolveFakeOverrides(name, enumEntryScope.getSupertypeScope().getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                    } else {
                        EnumEntryScope.$$$reportNull$$$0(4);
                        throw null;
                    }
                }
            });
            this.allDescriptors = storageManager.createLazyValue(new Function0<Collection<DeclarationDescriptor>>(EnumEntrySyntheticClassDescriptor.this) {
                public Object invoke() {
                    EnumEntryScope enumEntryScope = EnumEntryScope.this;
                    if (enumEntryScope != null) {
                        HashSet hashSet = new HashSet();
                        for (Name name : (Set) EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke()) {
                            hashSet.addAll(enumEntryScope.getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                            hashSet.addAll(enumEntryScope.getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                        }
                        return hashSet;
                    }
                    throw null;
                }
            });
        }

        public Set<Name> getClassifierNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            $$$reportNull$$$0(18);
            throw null;
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(13);
                throw null;
            } else if (function1 != null) {
                Collection<DeclarationDescriptor> collection = (Collection) this.allDescriptors.invoke();
                if (collection != null) {
                    return collection;
                }
                $$$reportNull$$$0(15);
                throw null;
            } else {
                $$$reportNull$$$0(14);
                throw null;
            }
        }

        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
                throw null;
            } else if (lookupLocation != null) {
                Collection<? extends SimpleFunctionDescriptor> collection = (Collection) this.functions.invoke(name);
                if (collection != null) {
                    return collection;
                }
                $$$reportNull$$$0(7);
                throw null;
            } else {
                $$$reportNull$$$0(6);
                throw null;
            }
        }

        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else if (lookupLocation != null) {
                Collection<? extends PropertyDescriptor> collection = (Collection) this.properties.invoke(name);
                if (collection != null) {
                    return collection;
                }
                $$$reportNull$$$0(3);
                throw null;
            } else {
                $$$reportNull$$$0(2);
                throw null;
            }
        }

        public Set<Name> getFunctionNames() {
            Set<Name> set = (Set) EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke();
            if (set != null) {
                return set;
            }
            $$$reportNull$$$0(17);
            throw null;
        }

        public final MemberScope getSupertypeScope() {
            MemberScope memberScope = EnumEntrySyntheticClassDescriptor.this.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope != null) {
                return memberScope;
            }
            $$$reportNull$$$0(9);
            throw null;
        }

        public Set<Name> getVariableNames() {
            Set<Name> set = (Set) EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke();
            if (set != null) {
                return set;
            }
            $$$reportNull$$$0(19);
            throw null;
        }

        public final <D extends CallableMemberDescriptor> Collection<? extends D> resolveFakeOverrides(Name name, Collection<? extends D> collection) {
            if (name == null) {
                $$$reportNull$$$0(10);
                throw null;
            } else if (collection != null) {
                final LinkedHashSet linkedHashSet = new LinkedHashSet();
                OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), EnumEntrySyntheticClassDescriptor.this, new NonReportingOverrideStrategy(this) {
                    public static /* synthetic */ void $$$reportNull$$$0(int i) {
                        Object[] objArr = new Object[3];
                        if (i == 1) {
                            objArr[0] = "fromSuper";
                        } else if (i != 2) {
                            objArr[0] = "fakeOverride";
                        } else {
                            objArr[0] = "fromCurrent";
                        }
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                        if (i == 1 || i == 2) {
                            objArr[2] = "conflict";
                        } else {
                            objArr[2] = "addFakeOverride";
                        }
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                    }

                    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                        if (callableMemberDescriptor != null) {
                            OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                            linkedHashSet.add(callableMemberDescriptor);
                            return;
                        }
                        $$$reportNull$$$0(0);
                        throw null;
                    }

                    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                    }
                });
                return linkedHashSet;
            } else {
                $$$reportNull$$$0(11);
                throw null;
            }
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
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
    public EnumEntrySyntheticClassDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager r8, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9, kotlin.reflect.jvm.internal.impl.types.KotlinType r10, kotlin.reflect.jvm.internal.impl.name.Name r11, kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>> r12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r14) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x004f
            if (r10 == 0) goto L_0x0049
            if (r11 == 0) goto L_0x0043
            if (r12 == 0) goto L_0x003d
            if (r13 == 0) goto L_0x0037
            if (r14 == 0) goto L_0x0031
            r6 = 0
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r11
            r5 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r7.annotations = r13
            kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl r9 = new kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.Set r10 = java.util.Collections.singleton(r10)
            r9.<init>(r7, r11, r10, r8)
            r7.typeConstructor = r9
            kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor$EnumEntryScope r9 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor$EnumEntryScope
            r9.<init>(r8)
            r7.scope = r9
            r7.enumMemberNames = r12
            return
        L_0x0031:
            r8 = 12
            $$$reportNull$$$0(r8)
            throw r0
        L_0x0037:
            r8 = 11
            $$$reportNull$$$0(r8)
            throw r0
        L_0x003d:
            r8 = 10
            $$$reportNull$$$0(r8)
            throw r0
        L_0x0043:
            r8 = 9
            $$$reportNull$$$0(r8)
            throw r0
        L_0x0049:
            r8 = 8
            $$$reportNull$$$0(r8)
            throw r0
        L_0x004f:
            r8 = 6
            $$$reportNull$$$0(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations2, SourceElement sourceElement) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (classDescriptor == null) {
            $$$reportNull$$$0(1);
            throw null;
        } else if (notNullLazyValue == null) {
            $$$reportNull$$$0(3);
            throw null;
        } else if (sourceElement != null) {
            EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor = new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, notNullLazyValue, annotations2, sourceElement);
            return enumEntrySyntheticClassDescriptor;
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public Annotations getAnnotations() {
        Annotations annotations2 = this.annotations;
        if (annotations2 != null) {
            return annotations2;
        }
        $$$reportNull$$$0(21);
        throw null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        $$$reportNull$$$0(22);
        throw null;
    }

    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind != null) {
            return classKind;
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality != null) {
            return modality;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        $$$reportNull$$$0(23);
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
        $$$reportNull$$$0(17);
        throw null;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            MemberScope memberScope = this.scope;
            if (memberScope != null) {
                return memberScope;
            }
            $$$reportNull$$$0(14);
            throw null;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        $$$reportNull$$$0(20);
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
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("enum entry ");
        outline73.append(getName());
        return outline73.toString();
    }
}
