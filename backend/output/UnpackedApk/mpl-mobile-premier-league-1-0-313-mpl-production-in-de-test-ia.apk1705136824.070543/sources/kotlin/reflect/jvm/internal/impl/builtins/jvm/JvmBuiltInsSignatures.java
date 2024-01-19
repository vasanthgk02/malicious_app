package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;

/* compiled from: JvmBuiltInsSignatures.kt */
public final class JvmBuiltInsSignatures {
    public static final Set<String> DROP_LIST_METHOD_SIGNATURES = ArraysKt___ArraysJvmKt.plus(SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    public static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES;
    public static final Set<String> HIDDEN_METHOD_SIGNATURES;
    public static final JvmBuiltInsSignatures INSTANCE = new JvmBuiltInsSignatures();
    public static final Set<String> MUTABLE_METHOD_SIGNATURES;
    public static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES;
    public static final Set<String> VISIBLE_METHOD_SIGNATURES;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (INSTANCE != null) {
            List<JvmPrimitiveType> listOf = TweetUtils.listOf((T[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType jvmPrimitiveType : listOf) {
                String asString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "it.wrapperFqName.shortName().asString()");
                TweetUtils.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
            }
            HIDDEN_METHOD_SIGNATURES = ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus((Set<? extends T>) linkedHashSet, (Iterable<? extends T>) signatureBuildingComponents.inJavaUtil(PDListAttributeObject.OWNER_LIST, "sort(Ljava/util/Comparator;)V")), (Iterable<? extends T>) signatureBuildingComponents.inJavaLang(HanselEventConstant.DATA_TYPE_STRING, "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable<? extends T>) signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable<? extends T>) signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable<? extends T>) signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (Iterable<? extends T>) signatureBuildingComponents.inJavaLang("CharSequence", "isEmpty()Z"));
            SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
            VISIBLE_METHOD_SIGNATURES = ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(signatureBuildingComponents2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable<? extends T>) signatureBuildingComponents2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable<? extends T>) signatureBuildingComponents2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable<? extends T>) signatureBuildingComponents2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable<? extends T>) signatureBuildingComponents2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable<? extends T>) signatureBuildingComponents2.inJavaUtil(PDListAttributeObject.OWNER_LIST, "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable<? extends T>) signatureBuildingComponents2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
            SignatureBuildingComponents signatureBuildingComponents3 = SignatureBuildingComponents.INSTANCE;
            MUTABLE_METHOD_SIGNATURES = ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(signatureBuildingComponents3.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable<? extends T>) signatureBuildingComponents3.inJavaUtil(PDListAttributeObject.OWNER_LIST, "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable<? extends T>) signatureBuildingComponents3.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
            SignatureBuildingComponents signatureBuildingComponents4 = SignatureBuildingComponents.INSTANCE;
            if (INSTANCE != null) {
                List<JvmPrimitiveType> listOf2 = TweetUtils.listOf((T[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                for (JvmPrimitiveType wrapperFqName : listOf2) {
                    String asString2 = wrapperFqName.getWrapperFqName().shortName().asString();
                    Intrinsics.checkNotNullExpressionValue(asString2, "it.wrapperFqName.shortName().asString()");
                    String[] constructors = signatureBuildingComponents4.constructors("Ljava/lang/String;");
                    String[] strArr = new String[constructors.length];
                    System.arraycopy(constructors, 0, strArr, 0, constructors.length);
                    TweetUtils.addAll(linkedHashSet2, signatureBuildingComponents4.inJavaLang(asString2, strArr));
                }
                String[] constructors2 = signatureBuildingComponents4.constructors("D");
                String[] strArr2 = new String[constructors2.length];
                System.arraycopy(constructors2, 0, strArr2, 0, constructors2.length);
                Set<T> plus = ArraysKt___ArraysJvmKt.plus((Set<? extends T>) linkedHashSet2, (Iterable<? extends T>) signatureBuildingComponents4.inJavaLang("Float", strArr2));
                String[] constructors3 = signatureBuildingComponents4.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
                String[] strArr3 = new String[constructors3.length];
                System.arraycopy(constructors3, 0, strArr3, 0, constructors3.length);
                HIDDEN_CONSTRUCTOR_SIGNATURES = ArraysKt___ArraysJvmKt.plus(plus, (Iterable<? extends T>) signatureBuildingComponents4.inJavaLang(HanselEventConstant.DATA_TYPE_STRING, strArr3));
                SignatureBuildingComponents signatureBuildingComponents5 = SignatureBuildingComponents.INSTANCE;
                String[] constructors4 = signatureBuildingComponents5.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
                String[] strArr4 = new String[constructors4.length];
                System.arraycopy(constructors4, 0, strArr4, 0, constructors4.length);
                VISIBLE_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents5.inJavaLang("Throwable", strArr4);
                return;
            }
            throw null;
        }
        throw null;
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        if (Intrinsics.areEqual(fqNameUnsafe, FqNames.array)) {
            return true;
        }
        StandardNames standardNames = StandardNames.INSTANCE;
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(fqNameUnsafe) != null) {
            return true;
        }
        return false;
    }
}
