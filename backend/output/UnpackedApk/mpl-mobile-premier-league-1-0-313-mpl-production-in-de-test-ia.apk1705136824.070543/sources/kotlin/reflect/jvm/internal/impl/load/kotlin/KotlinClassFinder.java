package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* compiled from: KotlinClassFinder.kt */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: KotlinClassFinder.kt */
    public static abstract class Result {

        /* compiled from: KotlinClassFinder.kt */
        public static final class ClassFileContent extends Result {
        }

        /* compiled from: KotlinClassFinder.kt */
        public static final class KotlinClass extends Result {
            public final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass2, byte[] bArr, int i) {
                // Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass2, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass2;
            }
        }

        public Result(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = this instanceof KotlinClass ? (KotlinClass) this : null;
            if (kotlinClass == null) {
                return null;
            }
            return kotlinClass.kotlinJvmBinaryClass;
        }
    }

    Result findKotlinClassOrContent(JavaClass javaClass);

    Result findKotlinClassOrContent(ClassId classId);
}
