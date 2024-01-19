package kotlin.reflect.jvm.internal.impl.builtins;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.imagepicker.IdologyKycIdCapture;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.apache.commons.net.ftp.FTPReply;

public abstract class KotlinBuiltIns {
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    public final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    public ModuleDescriptorImpl builtInsModule;
    public final NotNullLazyValue<Primitives> primitives;
    public final StorageManager storageManager;

    public static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        public Primitives(Map map, Map map2, Map map3, AnonymousClass1 r4) {
            this.primitiveTypeToArrayKotlinType = map;
            this.kotlinArrayTypeToPrimitiveKotlinType = map3;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case 144:
            case 145:
            case 147:
            case 155:
            case 156:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 134:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 146:
            case 148:
            case 149:
            case FTPReply.FILE_STATUS_OK /*150*/:
            case 151:
            case 152:
            case 153:
            case 154:
            case 159:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case 125:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case 129:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 132:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 133:
            case 134:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 135:
                objArr[2] = "isNothing";
                break;
            case 136:
                objArr[2] = "isNullableNothing";
                break;
            case 137:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 138:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 139:
                objArr[2] = "isNullableAny";
                break;
            case 140:
                objArr[2] = "isDefaultBound";
                break;
            case 141:
                objArr[2] = "isUnit";
                break;
            case 142:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 143:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 144:
                objArr[2] = "isMemberOfAny";
                break;
            case 145:
            case 146:
                objArr[2] = "isEnum";
                break;
            case 147:
            case 148:
                objArr[2] = "isComparable";
                break;
            case 149:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case FTPReply.FILE_STATUS_OK /*150*/:
                objArr[2] = "isListOrNullableList";
                break;
            case 151:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 152:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 153:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case 159:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public KotlinBuiltIns(StorageManager storageManager2) {
        this.storageManager = storageManager2;
        storageManager2.createLazyValue(new Function0<Collection<PackageViewDescriptor>>() {
            public Object invoke() {
                return Arrays.asList(new PackageViewDescriptor[]{KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME)});
            }
        });
        this.primitives = storageManager2.createLazyValue(new Function0<Primitives>() {
            public Object invoke() {
                EnumMap enumMap = new EnumMap(PrimitiveType.class);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (PrimitiveType primitiveType : PrimitiveType.values()) {
                    SimpleType access$100 = KotlinBuiltIns.access$100(KotlinBuiltIns.this, primitiveType.getTypeName().asString());
                    SimpleType access$1002 = KotlinBuiltIns.access$100(KotlinBuiltIns.this, primitiveType.getArrayTypeName().asString());
                    enumMap.put(primitiveType, access$1002);
                    hashMap.put(access$100, access$1002);
                    hashMap2.put(access$1002, access$100);
                }
                return new Primitives(enumMap, hashMap, hashMap2, null);
            }
        });
        this.builtInClassesByName = storageManager2.createMemoizedFunction(new Function1<Name, ClassDescriptor>() {
            public Object invoke(Object obj) {
                Name name = (Name) obj;
                MemberScope memberScope = KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
                if (memberScope != null) {
                    ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, NoLookupLocation.FROM_BUILTINS);
                    if (contributedClassifier == null) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Built-in class ");
                        outline73.append(StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name));
                        outline73.append(" is not found");
                        throw new AssertionError(outline73.toString());
                    } else if (contributedClassifier instanceof ClassDescriptor) {
                        return (ClassDescriptor) contributedClassifier;
                    } else {
                        throw new AssertionError("Must be a class descriptor " + name + ", but was " + contributedClassifier);
                    }
                } else {
                    KotlinBuiltIns.$$$reportNull$$$0(10);
                    throw null;
                }
            }
        });
    }

    public static SimpleType access$100(KotlinBuiltIns kotlinBuiltIns, String str) {
        if (kotlinBuiltIns == null) {
            throw null;
        } else if (str != null) {
            SimpleType defaultType = kotlinBuiltIns.getBuiltInClassByName(str).getDefaultType();
            if (defaultType != null) {
                return defaultType;
            }
            $$$reportNull$$$0(46);
            throw null;
        } else {
            $$$reportNull$$$0(45);
            throw null;
        }
    }

    public static boolean classFqNameEquals(ClassifierDescriptor classifierDescriptor, FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(102);
            throw null;
        } else if (fqNameUnsafe != null) {
            return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(DescriptorUtils.getFqName(classifierDescriptor));
        } else {
            $$$reportNull$$$0(103);
            throw null;
        }
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor declarationDescriptor) {
        if (FqNames.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(75);
            throw null;
        } else if (FqNames.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        } else {
            return null;
        }
    }

    public static boolean isAny(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return classFqNameEquals(classDescriptor, FqNames.any);
        }
        $$$reportNull$$$0(107);
        throw null;
    }

    public static boolean isAnyOrNullableAny(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isConstructedFromGivenClass(kotlinType, FqNames.any);
        }
        $$$reportNull$$$0(138);
        throw null;
    }

    public static boolean isArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isConstructedFromGivenClass(kotlinType, FqNames.array);
        }
        $$$reportNull$$$0(87);
        throw null;
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor classDescriptor) {
        return classFqNameEquals(classDescriptor, FqNames.array) || getPrimitiveArrayType(classDescriptor) != null;
    }

    public static boolean isBoolean(KotlinType kotlinType) {
        return isConstructedFromGivenClassAndNotNullable(kotlinType, FqNames._boolean);
    }

    public static boolean isBuiltIn(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return DescriptorUtils.getParentOfType(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public static boolean isConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(96);
            throw null;
        } else if (fqNameUnsafe != null) {
            return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
        } else {
            $$$reportNull$$$0(97);
            throw null;
        }
    }

    public static boolean isConstructedFromGivenClassAndNotNullable(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(133);
            throw null;
        } else if (fqNameUnsafe != null) {
            return isConstructedFromGivenClass(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
        } else {
            $$$reportNull$$$0(134);
            throw null;
        }
    }

    public static boolean isDeprecated(DeclarationDescriptor declarationDescriptor) {
        boolean z = true;
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(FqNames.deprecated)) {
            return true;
        }
        if (!(declarationDescriptor instanceof PropertyDescriptor)) {
            return false;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
        boolean isVar = propertyDescriptor.isVar();
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        if (getter == null || !isDeprecated(getter) || (isVar && (setter == null || !isDeprecated(setter)))) {
            z = false;
        }
        return z;
    }

    public static boolean isKClass(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return classFqNameEquals(classDescriptor, FqNames.kClass);
        }
        $$$reportNull$$$0(155);
        throw null;
    }

    public static boolean isNotNullConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(104);
            throw null;
        } else if (fqNameUnsafe != null) {
            return !kotlinType.isMarkedNullable() && isConstructedFromGivenClass(kotlinType, fqNameUnsafe);
        } else {
            $$$reportNull$$$0(105);
            throw null;
        }
    }

    public static boolean isNothing(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(135);
            throw null;
        } else if (kotlinType != null) {
            return isConstructedFromGivenClass(kotlinType, FqNames.nothing) && !TypeUtils.isNullableType(kotlinType);
        } else {
            $$$reportNull$$$0(137);
            throw null;
        }
    }

    public static boolean isNullableAny(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
        }
        $$$reportNull$$$0(139);
        throw null;
    }

    public static boolean isPrimitiveClass(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return getPrimitiveType(classDescriptor) != null;
        }
        $$$reportNull$$$0(95);
        throw null;
    }

    public static boolean isPrimitiveType(KotlinType kotlinType) {
        if (kotlinType.isMarkedNullable()) {
            return false;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if ((declarationDescriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) declarationDescriptor)) {
            return true;
        }
        return false;
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return classFqNameEquals(classDescriptor, FqNames.any) || classFqNameEquals(classDescriptor, FqNames.nothing);
        }
        $$$reportNull$$$0(106);
        throw null;
    }

    public static boolean isString(KotlinType kotlinType) {
        return isNotNullConstructedFromGivenClass(kotlinType, FqNames.string);
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor typeConstructor, FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(100);
            throw null;
        } else if (fqNameUnsafe != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && classFqNameEquals(declarationDescriptor, fqNameUnsafe);
        } else {
            $$$reportNull$$$0(101);
            throw null;
        }
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor declarationDescriptor) {
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isUnit(KotlinType kotlinType) {
        return isNotNullConstructedFromGivenClass(kotlinType, FqNames.unit);
    }

    public void createBuiltInsModule(boolean z) {
        Name name = BUILTINS_MODULE_NAME;
        StorageManager storageManager2 = this.storageManager;
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(this, "builtIns");
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(name, storageManager2, this, null, null, 48);
        this.builtInsModule = moduleDescriptorImpl;
        if (BuiltInsLoader.Companion != null) {
            moduleDescriptorImpl.initialize(((BuiltInsLoader) Companion.Instance$delegate.getValue()).createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), z));
            ModuleDescriptorImpl moduleDescriptorImpl2 = this.builtInsModule;
            moduleDescriptorImpl2.setDependencies(moduleDescriptorImpl2);
            return;
        }
        throw null;
    }

    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return None.INSTANCE;
    }

    public SimpleType getAnyType() {
        SimpleType defaultType = getBuiltInClassByName(IdologyKycIdCapture.DOC_TYPE_ANY).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        $$$reportNull$$$0(49);
        throw null;
    }

    public KotlinType getArrayElementType(KotlinType kotlinType) {
        SimpleType simpleType = null;
        if (kotlinType == null) {
            $$$reportNull$$$0(66);
            throw null;
        } else if (!isArray(kotlinType)) {
            KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
            KotlinType kotlinType2 = ((Primitives) this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(makeNotNullable);
            if (kotlinType2 != null) {
                return kotlinType2;
            }
            ModuleDescriptor containingModuleOrNull = DescriptorUtils.getContainingModuleOrNull(makeNotNullable);
            if (containingModuleOrNull != null) {
                ClassifierDescriptor declarationDescriptor = makeNotNullable.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor != null) {
                    UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
                    Name name = declarationDescriptor.getName();
                    Intrinsics.checkNotNullParameter(name, "name");
                    if (UnsignedTypes.arrayClassesShortNames.contains(name)) {
                        ClassId classId = DescriptorUtilsKt.getClassId(declarationDescriptor);
                        if (classId != null) {
                            UnsignedTypes unsignedTypes2 = UnsignedTypes.INSTANCE;
                            Intrinsics.checkNotNullParameter(classId, "arrayClassId");
                            ClassId classId2 = UnsignedTypes.arrayClassIdToUnsignedClassId.get(classId);
                            if (classId2 != null) {
                                ClassDescriptor findClassAcrossModuleDependencies = TweetUtils.findClassAcrossModuleDependencies(containingModuleOrNull, classId2);
                                if (findClassAcrossModuleDependencies != null) {
                                    simpleType = findClassAcrossModuleDependencies.getDefaultType();
                                }
                            }
                        }
                    }
                }
                if (simpleType != null) {
                    return simpleType;
                }
            }
            throw new IllegalStateException("not array: " + kotlinType);
        } else if (kotlinType.getArguments().size() == 1) {
            KotlinType type = kotlinType.getArguments().get(0).getType();
            if (type != null) {
                return type;
            }
            $$$reportNull$$$0(67);
            throw null;
        } else {
            throw new IllegalStateException();
        }
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType, Annotations annotations) {
        if (variance == null) {
            $$$reportNull$$$0(77);
            throw null;
        } else if (kotlinType == null) {
            $$$reportNull$$$0(78);
            throw null;
        } else if (annotations != null) {
            SimpleType simpleNotNullType = KotlinTypeFactory.simpleNotNullType(annotations, getBuiltInClassByName("Array"), Collections.singletonList(new TypeProjectionImpl(variance, kotlinType)));
            if (simpleNotNullType != null) {
                return simpleNotNullType;
            }
            $$$reportNull$$$0(80);
            throw null;
        } else {
            $$$reportNull$$$0(79);
            throw null;
        }
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName fqName) {
        if (fqName != null) {
            ClassDescriptor resolveClassByFqName = TweetUtils.resolveClassByFqName(this.builtInsModule, fqName, NoLookupLocation.FROM_BUILTINS);
            if (resolveClassByFqName != null) {
                return resolveClassByFqName;
            }
            $$$reportNull$$$0(12);
            throw null;
        }
        $$$reportNull$$$0(11);
        throw null;
    }

    public final ClassDescriptor getBuiltInClassByName(String str) {
        if (str != null) {
            ClassDescriptor classDescriptor = (ClassDescriptor) this.builtInClassesByName.invoke(Name.identifier(str));
            if (classDescriptor != null) {
                return classDescriptor;
            }
            $$$reportNull$$$0(14);
            throw null;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, this.builtInsModule));
        if (singletonList != null) {
            return singletonList;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public SimpleType getDefaultBound() {
        SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType != null) {
            return nullableAnyType;
        }
        $$$reportNull$$$0(51);
        throw null;
    }

    public SimpleType getIntType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        $$$reportNull$$$0(57);
        throw null;
    }

    public SimpleType getNothingType() {
        SimpleType defaultType = getBuiltInClassByName("Nothing").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        $$$reportNull$$$0(47);
        throw null;
    }

    public SimpleType getNullableAnyType() {
        SimpleType makeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified != null) {
            return makeNullableAsSpecified;
        }
        $$$reportNull$$$0(50);
        throw null;
    }

    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return NoPlatformDependent.INSTANCE;
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        if (primitiveType != null) {
            SimpleType simpleType = ((Primitives) this.primitives.invoke()).primitiveTypeToArrayKotlinType.get(primitiveType);
            if (simpleType != null) {
                return simpleType;
            }
            $$$reportNull$$$0(73);
            throw null;
        }
        $$$reportNull$$$0(72);
        throw null;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(52);
            throw null;
        } else if (primitiveType != null) {
            SimpleType defaultType = getBuiltInClassByName(primitiveType.getTypeName().asString()).getDefaultType();
            if (defaultType != null) {
                return defaultType;
            }
            $$$reportNull$$$0(53);
            throw null;
        } else {
            $$$reportNull$$$0(15);
            throw null;
        }
    }

    public SimpleType getStringType() {
        SimpleType defaultType = getBuiltInClassByName(HanselEventConstant.DATA_TYPE_STRING).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        $$$reportNull$$$0(64);
        throw null;
    }

    public ClassDescriptor getSuspendFunction(int i) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(Intrinsics.stringPlus(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i)))));
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        $$$reportNull$$$0(17);
        throw null;
    }

    public SimpleType getUnitType() {
        SimpleType defaultType = getBuiltInClassByName("Unit").getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        $$$reportNull$$$0(63);
        throw null;
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(81);
            throw null;
        } else if (kotlinType == null) {
            $$$reportNull$$$0(82);
            throw null;
        } else if (Annotations.Companion != null) {
            SimpleType arrayType = getArrayType(variance, kotlinType, Annotations.Companion.EMPTY);
            if (arrayType != null) {
                return arrayType;
            }
            $$$reportNull$$$0(83);
            throw null;
        } else {
            throw null;
        }
    }
}
