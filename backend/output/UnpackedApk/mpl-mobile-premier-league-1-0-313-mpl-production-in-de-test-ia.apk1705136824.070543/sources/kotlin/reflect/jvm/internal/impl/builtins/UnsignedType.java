package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(r1),
    USHORT(r1),
    UINT(r1),
    ULONG(r1);
    
    public final ClassId arrayClassId;
    public final ClassId classId;
    public final Name typeName;

    /* access modifiers changed from: public */
    UnsignedType(ClassId classId2) {
        this.classId = classId2;
        Name shortClassName = classId2.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new ClassId(this.classId.getPackageFqName(), Name.identifier(Intrinsics.stringPlus(this.typeName.asString(), "Array")));
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
