package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: methodSignatureMapping.kt */
public abstract class JvmType {
    public static final Primitive BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
    public static final Primitive BYTE = new Primitive(JvmPrimitiveType.BYTE);
    public static final Primitive CHAR = new Primitive(JvmPrimitiveType.CHAR);
    public static final JvmType Companion = null;
    public static final Primitive DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);
    public static final Primitive FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
    public static final Primitive INT = new Primitive(JvmPrimitiveType.INT);
    public static final Primitive LONG = new Primitive(JvmPrimitiveType.LONG);
    public static final Primitive SHORT = new Primitive(JvmPrimitiveType.SHORT);

    /* compiled from: methodSignatureMapping.kt */
    public static final class Array extends JvmType {
        public final JvmType elementType;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Array(JvmType jvmType) {
            // Intrinsics.checkNotNullParameter(jvmType, "elementType");
            super(null);
            this.elementType = jvmType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Object extends JvmType {
        public final String internalName;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Object(String str) {
            // Intrinsics.checkNotNullParameter(str, "internalName");
            super(null);
            this.internalName = str;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends JvmType {
        public final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType2) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType2;
        }
    }

    public JvmType() {
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    public JvmType(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
