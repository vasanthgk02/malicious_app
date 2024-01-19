package kotlin.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0002J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeReference.kt */
public final class TypeReference implements KType {
    public final List<KTypeProjection> arguments;
    public final KClassifier classifier;
    public final int flags;
    public final KType platformTypeUpperBound = null;

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        Intrinsics.checkNotNullParameter(kClassifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(kClassifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.classifier = kClassifier;
        this.arguments = list;
        this.flags = z ? 1 : 0;
    }

    public final String asString(boolean z) {
        String str;
        String str2;
        KClassifier kClassifier = this.classifier;
        Class cls = null;
        KClass kClass = kClassifier instanceof KClass ? (KClass) kClassifier : null;
        if (kClass != null) {
            cls = TweetUtils.getJavaClass(kClass);
        }
        if (cls == null) {
            str = this.classifier.toString();
        } else if ((this.flags & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            if (Intrinsics.areEqual(cls, boolean[].class)) {
                str = "kotlin.BooleanArray";
            } else if (Intrinsics.areEqual(cls, char[].class)) {
                str = "kotlin.CharArray";
            } else if (Intrinsics.areEqual(cls, byte[].class)) {
                str = "kotlin.ByteArray";
            } else if (Intrinsics.areEqual(cls, short[].class)) {
                str = "kotlin.ShortArray";
            } else if (Intrinsics.areEqual(cls, int[].class)) {
                str = "kotlin.IntArray";
            } else if (Intrinsics.areEqual(cls, float[].class)) {
                str = "kotlin.FloatArray";
            } else if (Intrinsics.areEqual(cls, long[].class)) {
                str = "kotlin.LongArray";
            } else {
                str = Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
            }
        } else if (!z || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            KClassifier kClassifier2 = this.classifier;
            Intrinsics.checkNotNull(kClassifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            str = TweetUtils.getJavaObjectType((KClass) kClassifier2).getName();
        }
        String str3 = "";
        if (this.arguments.isEmpty()) {
            str2 = str3;
        } else {
            str2 = ArraysKt___ArraysJvmKt.joinToString$default(this.arguments, ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24);
        }
        if (isMarkedNullable()) {
            str3 = ColorPropConverter.PREFIX_ATTR;
        }
        String outline52 = GeneratedOutlineSupport.outline52(str, str2, str3);
        KType kType = this.platformTypeUpperBound;
        if (!(kType instanceof TypeReference)) {
            return outline52;
        }
        String asString = ((TypeReference) kType).asString(true);
        if (Intrinsics.areEqual(asString, outline52)) {
            return outline52;
        }
        if (Intrinsics.areEqual(asString, outline52 + '?')) {
            return outline52 + '!';
        }
        return '(' + outline52 + ".." + asString + ')';
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.areEqual(this.classifier, typeReference.classifier) && Intrinsics.areEqual(this.arguments, typeReference.arguments) && Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    public List<Annotation> getAnnotations() {
        return EmptyList.INSTANCE;
    }

    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    public KClassifier getClassifier() {
        return this.classifier;
    }

    public int hashCode() {
        int hashCode = this.arguments.hashCode();
        return Integer.valueOf(this.flags).hashCode() + ((hashCode + (this.classifier.hashCode() * 31)) * 31);
    }

    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }
}
