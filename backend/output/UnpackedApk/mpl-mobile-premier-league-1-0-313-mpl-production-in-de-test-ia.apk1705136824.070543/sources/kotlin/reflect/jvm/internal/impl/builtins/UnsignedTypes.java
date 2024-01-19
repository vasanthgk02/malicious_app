package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: UnsignedType.kt */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    public static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId = new HashMap<>();
    public static final Set<Name> arrayClassesShortNames;
    public static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall = ArraysKt___ArraysJvmKt.hashMapOf(new Pair(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), new Pair(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), new Pair(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), new Pair(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf")));
    public static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId = new HashMap<>();
    public static final Set<Name> unsignedTypeNames;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i = 0;
        for (UnsignedType typeName : values) {
            arrayList.add(typeName.getTypeName());
        }
        unsignedTypeNames = ArraysKt___ArraysJvmKt.toSet(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType typeName2 : values2) {
            arrayList2.add(typeName2.getTypeName());
        }
        ArraysKt___ArraysJvmKt.toSet(arrayList2);
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType arrayClassId : values3) {
            linkedHashSet.add(arrayClassId.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i < length) {
            UnsignedType unsignedType = values4[i];
            i++;
            arrayClassIdToUnsignedClassId.put(unsignedType.getArrayClassId(), unsignedType.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType.getClassId(), unsignedType.getArrayClassId());
        }
    }

    public static final boolean isUnsignedType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        boolean z = false;
        if (TypeUtils.noExpectedType(kotlinType)) {
            return false;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if ((containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(declarationDescriptor.getName())) {
            z = true;
        }
        return z;
    }
}
