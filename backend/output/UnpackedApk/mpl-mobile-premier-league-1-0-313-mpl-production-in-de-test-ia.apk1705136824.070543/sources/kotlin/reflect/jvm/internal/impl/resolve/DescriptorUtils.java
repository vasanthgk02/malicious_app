package kotlin.reflect.jvm.internal.impl.resolve;

import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.androidapp.login.LoginReactModule;
import com.netcore.android.notification.SMTNotificationConstants;
import com.netcore.android.utility.f;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

public class DescriptorUtils {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case 56:
            case 57:
            case 59:
            case 77:
            case 90:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = AnonymousClass27.SECOND;
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER;
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case 52:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 53:
                objArr[0] = "innerClassName";
                break;
            case 54:
                objArr[0] = "location";
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case 66:
                objArr[0] = f.f1288a;
                break;
            case 68:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = LoginReactModule.RESULT;
                break;
            case 70:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case 75:
            case 76:
                objArr[0] = "annotated";
                break;
            case 80:
            case 82:
            case 85:
            case 87:
                objArr[0] = "scope";
                break;
            case 83:
            case 86:
            case 88:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case 41:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 78:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case 84:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 52:
            case 53:
            case 54:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case 56:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 66:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 68:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case 75:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 76:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case 82:
            case 83:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 87:
            case 88:
                objArr[2] = "getPropertyByName";
                break;
            case 90:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    static {
        new FqName((String) "kotlin.jvm.JvmName");
    }

    public static <D extends CallableDescriptor> void collectAllOverriddenDescriptors(D d2, Set<D> set) {
        if (d2 == null) {
            $$$reportNull$$$0(68);
            throw null;
        } else if (!set.contains(d2)) {
            for (CallableDescriptor original : d2.getOriginal().getOverriddenDescriptors()) {
                CallableDescriptor original2 = original.getOriginal();
                collectAllOverriddenDescriptors(original2, set);
                set.add(original2);
            }
        }
    }

    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(D d2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        collectAllOverriddenDescriptors(d2.getOriginal(), linkedHashSet);
        return linkedHashSet;
    }

    public static ClassDescriptor getClassDescriptorForType(KotlinType kotlinType) {
        if (kotlinType != null) {
            TypeConstructor constructor = kotlinType.getConstructor();
            if (constructor != null) {
                ClassDescriptor classDescriptor = (ClassDescriptor) constructor.getDeclarationDescriptor();
                if (classDescriptor != null) {
                    return classDescriptor;
                }
                $$$reportNull$$$0(45);
                throw null;
            }
            $$$reportNull$$$0(44);
            throw null;
        }
        $$$reportNull$$$0(43);
        throw null;
    }

    public static ModuleDescriptor getContainingModule(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            ModuleDescriptor containingModuleOrNull = getContainingModuleOrNull(declarationDescriptor);
            if (containingModuleOrNull != null) {
                return containingModuleOrNull;
            }
            $$$reportNull$$$0(20);
            throw null;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public static ModuleDescriptor getContainingModuleOrNull(KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return null;
            }
            return getContainingModuleOrNull((DeclarationDescriptor) declarationDescriptor);
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public static SourceFile getContainingSourceFile(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PropertySetterDescriptor) {
                declarationDescriptor = ((PropertySetterDescriptor) declarationDescriptor).getCorrespondingProperty();
            }
            if (!(declarationDescriptor instanceof DeclarationDescriptorWithSource)) {
                return SourceFile.NO_SOURCE_FILE;
            }
            SourceFile containingFile = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile();
            if (containingFile != null) {
                return containingFile;
            }
            $$$reportNull$$$0(78);
            throw null;
        }
        $$$reportNull$$$0(77);
        throw null;
    }

    public static DescriptorVisibility getDefaultConstructorVisibility(ClassDescriptor classDescriptor, boolean z) {
        ClassKind kind = classDescriptor.getKind();
        if (kind == ClassKind.ENUM_CLASS || kind.isSingleton()) {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PRIVATE;
            if (descriptorVisibility != null) {
                return descriptorVisibility;
            }
            $$$reportNull$$$0(47);
            throw null;
        } else if (isSealedClass(classDescriptor)) {
            if (z) {
                DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.INTERNAL;
                if (descriptorVisibility2 != null) {
                    return descriptorVisibility2;
                }
                $$$reportNull$$$0(48);
                throw null;
            }
            DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE;
            if (descriptorVisibility3 != null) {
                return descriptorVisibility3;
            }
            $$$reportNull$$$0(49);
            throw null;
        } else if (isAnonymousObject(classDescriptor)) {
            DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.DEFAULT_VISIBILITY;
            if (descriptorVisibility4 != null) {
                return descriptorVisibility4;
            }
            $$$reportNull$$$0(50);
            throw null;
        } else {
            DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PUBLIC;
            if (descriptorVisibility5 != null) {
                return descriptorVisibility5;
            }
            $$$reportNull$$$0(51);
            throw null;
        }
    }

    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (declarationDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) declarationDescriptor).getThisAsReceiverParameter();
        } else {
            return null;
        }
    }

    public static FqNameUnsafe getFqName(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            FqName fqNameSafeIfPossible = getFqNameSafeIfPossible(declarationDescriptor);
            return fqNameSafeIfPossible != null ? fqNameSafeIfPossible.toUnsafe() : getFqNameUnsafe(declarationDescriptor);
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public static FqName getFqNameSafeIfPossible(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if ((declarationDescriptor instanceof ModuleDescriptor) || ErrorUtils.isError(declarationDescriptor)) {
            return FqName.ROOT;
        } else {
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).getFqName();
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
            }
            return null;
        }
    }

    public static FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        return getFqName(declarationDescriptor.getContainingDeclaration()).child(declarationDescriptor.getName());
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor declarationDescriptor, Class<D> cls) {
        return getParentOfType(declarationDescriptor, cls, true);
    }

    public static ClassDescriptor getSuperClassDescriptor(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            for (KotlinType classDescriptorForType : classDescriptor.getTypeConstructor().getSupertypes()) {
                ClassDescriptor classDescriptorForType2 = getClassDescriptorForType(classDescriptorForType);
                if (classDescriptorForType2.getKind() != ClassKind.INTERFACE) {
                    return classDescriptorForType2;
                }
            }
            return null;
        }
        $$$reportNull$$$0(42);
        throw null;
    }

    public static boolean isAnnotationClass(DeclarationDescriptor declarationDescriptor) {
        return isKindOf(declarationDescriptor, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return isKindOf(declarationDescriptor, ClassKind.CLASS) && declarationDescriptor.getName().equals(SpecialNames.NO_NAME_PROVIDED);
        }
        $$$reportNull$$$0(32);
        throw null;
    }

    public static boolean isClassOrEnumClass(DeclarationDescriptor declarationDescriptor) {
        return isKindOf(declarationDescriptor, ClassKind.CLASS) || isEnumClass(declarationDescriptor);
    }

    public static boolean isCompanionObject(DeclarationDescriptor declarationDescriptor) {
        return isKindOf(declarationDescriptor, ClassKind.OBJECT) && ((ClassDescriptor) declarationDescriptor).isCompanionObject();
    }

    public static boolean isDirectSubclass(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(24);
            throw null;
        } else if (classDescriptor2 != null) {
            for (KotlinType isSameClass : classDescriptor.getTypeConstructor().getSupertypes()) {
                if (isSameClass(isSameClass, classDescriptor2.getOriginal())) {
                    return true;
                }
            }
            return false;
        } else {
            $$$reportNull$$$0(25);
            throw null;
        }
    }

    public static boolean isEnumClass(DeclarationDescriptor declarationDescriptor) {
        return isKindOf(declarationDescriptor, ClassKind.ENUM_CLASS);
    }

    public static boolean isEnumEntry(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return isKindOf(declarationDescriptor, ClassKind.ENUM_ENTRY);
        }
        $$$reportNull$$$0(34);
        throw null;
    }

    public static boolean isKindOf(DeclarationDescriptor declarationDescriptor, ClassKind classKind) {
        if (classKind != null) {
            return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).getKind() == classKind;
        }
        $$$reportNull$$$0(35);
        throw null;
    }

    public static boolean isLocal(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            while (true) {
                boolean z = false;
                if (declarationDescriptor == null) {
                    return false;
                }
                if (isAnonymousObject(declarationDescriptor)) {
                    break;
                }
                if ((declarationDescriptor instanceof DeclarationDescriptorWithVisibility) && ((DeclarationDescriptorWithVisibility) declarationDescriptor).getVisibility() == DescriptorVisibilities.LOCAL) {
                    z = true;
                }
                if (z) {
                    break;
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return true;
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public static boolean isSameClass(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
            throw null;
        } else if (declarationDescriptor != null) {
            ClassifierDescriptor declarationDescriptor2 = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor2 != null) {
                DeclarationDescriptor original = declarationDescriptor2.getOriginal();
                if ((original instanceof ClassifierDescriptor) && (declarationDescriptor instanceof ClassifierDescriptor) && ((ClassifierDescriptor) declarationDescriptor).getTypeConstructor().equals(((ClassifierDescriptor) original).getTypeConstructor())) {
                    return true;
                }
            }
            return false;
        } else {
            $$$reportNull$$$0(29);
            throw null;
        }
    }

    public static boolean isSealedClass(DeclarationDescriptor declarationDescriptor) {
        return (isKindOf(declarationDescriptor, ClassKind.CLASS) || isKindOf(declarationDescriptor, ClassKind.INTERFACE)) && ((ClassDescriptor) declarationDescriptor).getModality() == Modality.SEALED;
    }

    public static boolean isSubclass(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return isSubtypeOfClass(classDescriptor.getDefaultType(), classDescriptor2.getOriginal());
    }

    public static boolean isSubtypeOfClass(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
            throw null;
        } else if (declarationDescriptor == null) {
            $$$reportNull$$$0(31);
            throw null;
        } else if (isSameClass(kotlinType, declarationDescriptor)) {
            return true;
        } else {
            for (KotlinType isSubtypeOfClass : kotlinType.getConstructor().getSupertypes()) {
                if (isSubtypeOfClass(isSubtypeOfClass, declarationDescriptor)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isTopLevelDeclaration(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor != null && (declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r5) != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean shouldRecordInitializerForProperty(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor r4, kotlin.reflect.jvm.internal.impl.types.KotlinType r5) {
        /*
            if (r5 == 0) goto L_0x0056
            boolean r0 = r4.isVar()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0055
            boolean r0 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r5)
            if (r0 == 0) goto L_0x0011
            goto L_0x0055
        L_0x0011:
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.acceptsNullable(r5)
            if (r0 == 0) goto L_0x0018
            return r2
        L_0x0018:
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(r4)
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r5)
            if (r0 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r0 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r4.getStringType()
            boolean r0 = r0.equalTypes(r3, r5)
            if (r0 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r0 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            java.lang.String r3 = "Number"
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r4.getBuiltInClassByName(r3)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getDefaultType()
            boolean r0 = r0.equalTypes(r3, r5)
            if (r0 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r0 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getAnyType()
            boolean r4 = r0.equalTypes(r4, r5)
            if (r4 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes r4 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.INSTANCE
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(r5)
            if (r4 == 0) goto L_0x0055
        L_0x0054:
            r1 = 1
        L_0x0055:
            return r1
        L_0x0056:
            r4 = 62
            $$$reportNull$$$0(r4)
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.shouldRecordInitializerForProperty(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType):boolean");
    }

    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(D d2) {
        if (d2 != null) {
            while (d2.getKind() == Kind.FAKE_OVERRIDE) {
                Collection overriddenDescriptors = d2.getOverriddenDescriptors();
                if (!overriddenDescriptors.isEmpty()) {
                    d2 = (CallableMemberDescriptor) overriddenDescriptors.iterator().next();
                } else {
                    throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d2);
                }
            }
            return d2;
        }
        $$$reportNull$$$0(57);
        throw null;
    }

    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(D d2) {
        if (d2 == null) {
            $$$reportNull$$$0(59);
            throw null;
        } else if (d2 instanceof CallableMemberDescriptor) {
            return unwrapFakeOverride((CallableMemberDescriptor) d2);
        } else {
            if (d2 != null) {
                return d2;
            }
            $$$reportNull$$$0(60);
            throw null;
        }
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(D d2, Class<D> cls, boolean z) {
        if (cls == null) {
            $$$reportNull$$$0(17);
            throw null;
        } else if (d2 == null) {
            return null;
        } else {
            if (z) {
                d2 = d2.getContainingDeclaration();
            }
            while (d2 != null) {
                if (cls.isInstance(d2)) {
                    return d2;
                }
                d2 = d2.getContainingDeclaration();
            }
            return null;
        }
    }

    public static ModuleDescriptor getContainingModuleOrNull(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            while (declarationDescriptor != null) {
                if (declarationDescriptor instanceof ModuleDescriptor) {
                    return (ModuleDescriptor) declarationDescriptor;
                }
                if (declarationDescriptor instanceof PackageViewDescriptor) {
                    return ((PackageViewDescriptor) declarationDescriptor).getModule();
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return null;
        }
        $$$reportNull$$$0(21);
        throw null;
    }
}
