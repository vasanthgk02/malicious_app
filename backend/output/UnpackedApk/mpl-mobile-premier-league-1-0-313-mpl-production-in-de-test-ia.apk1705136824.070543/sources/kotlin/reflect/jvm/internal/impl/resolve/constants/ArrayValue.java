package kotlin.reflect.jvm.internal.impl.resolve.constants;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
public final class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    public final Function1<ModuleDescriptor, KotlinType> computeType;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ArrayValue(List<? extends ConstantValue<?>> list, Function1<? super ModuleDescriptor, ? extends KotlinType> function1) {
        // Intrinsics.checkNotNullParameter(list, HSLCriteriaBuilder.VALUE);
        // Intrinsics.checkNotNullParameter(function1, "computeType");
        super(list);
        this.computeType = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if ((kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uByteArrayFqName.toUnsafe()) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uShortArrayFqName.toUnsafe()) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uIntArrayFqName.toUnsafe()) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uLongArrayFqName.toUnsafe())) != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "module"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r3.computeType
            java.lang.Object r4 = r0.invoke(r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r4)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0060
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getDeclarationDescriptor()
            if (r0 == 0) goto L_0x0027
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.getPrimitiveArrayType(r0)
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 != 0) goto L_0x0060
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uByteArrayFqName
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = r0.toUnsafe()
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, r0)
            if (r0 != 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uShortArrayFqName
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = r0.toUnsafe()
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, r0)
            if (r0 != 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uIntArrayFqName
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = r0.toUnsafe()
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, r0)
            if (r0 != 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uLongArrayFqName
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = r0.toUnsafe()
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r4, r0)
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r0 = 0
            goto L_0x005e
        L_0x005d:
            r0 = 1
        L_0x005e:
            if (r0 == 0) goto L_0x0061
        L_0x0060:
            r1 = 1
        L_0x0061:
            boolean r0 = kotlin._Assertions.ENABLED
            if (r0 == 0) goto L_0x0089
            if (r1 == 0) goto L_0x0068
            goto L_0x0089
        L_0x0068:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Type should be an array, but was "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = ": "
            r0.append(r4)
            T r4 = r3.value
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r4)
            throw r0
        L_0x0089:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue.getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }
}
