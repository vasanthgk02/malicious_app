package kotlin.reflect.jvm.internal.impl.load.java;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;

/* compiled from: SpecialGenericSignatures.kt */
public class SpecialGenericSignatures {
    public static final Companion Companion = new Companion(null);
    public static final List<NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    public static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    public static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    public static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    public static final Map<NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    public static final Map<Name, List<Name>> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    public static final Map<NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    public static final List<Name> ORIGINAL_SHORT_NAMES;
    public static final NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    public static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    public static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* compiled from: SpecialGenericSignatures.kt */
    public static final class Companion {

        /* compiled from: SpecialGenericSignatures.kt */
        public static final class NameAndSignature {
            public final Name name;
            public final String signature;

            public NameAndSignature(Name name2, String str) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(str, "signature");
                this.name = name2;
                this.signature = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.signature, nameAndSignature.signature);
            }

            public int hashCode() {
                return this.signature.hashCode() + (this.name.hashCode() * 31);
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("NameAndSignature(name=");
                outline73.append(this.name);
                outline73.append(", signature=");
                return GeneratedOutlineSupport.outline59(outline73, this.signature, ')');
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        public final boolean isObjectReplacedWithTypeParameter;
        public final String valueParametersSignature;

        /* access modifiers changed from: public */
        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public enum TypeSafeBarrierDescription {
        NULL(null),
        INDEX(Integer.valueOf(-1)),
        FALSE(Boolean.FALSE);
        
        public final Object defaultValue;

        /* compiled from: SpecialGenericSignatures.kt */
        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null, null);
            }
        }

        /* access modifiers changed from: public */
        TypeSafeBarrierDescription(Object obj) {
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> of = TweetUtils.setOf((T[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            Intrinsics.checkNotNullParameter("java/util/Collection", "internalName");
            Intrinsics.checkNotNullParameter(str + '(' + "Ljava/util/Collection;" + ')' + r11, "jvmDescriptor");
            arrayList.add(new NameAndSignature(identifier, "java/util/Collection" + '.' + r3));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((NameAndSignature) it.next()).signature);
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList2;
        List<NameAndSignature> list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
        for (NameAndSignature nameAndSignature : list) {
            arrayList3.add(nameAndSignature.name.asString());
        }
        Intrinsics.checkNotNullParameter("Collection", "name");
        String stringPlus = Intrinsics.stringPlus("java/util/", "Collection");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
        Name identifier2 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus, "internalName");
        Intrinsics.checkNotNullParameter("contains" + '(' + "Ljava/lang/Object;" + ')' + r13, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Collection", "name");
        String stringPlus2 = Intrinsics.stringPlus("java/util/", "Collection");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
        Name identifier3 = Name.identifier("remove");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus2, "internalName");
        Intrinsics.checkNotNullParameter("remove" + '(' + "Ljava/lang/Object;" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus3 = Intrinsics.stringPlus("java/util/", "Map");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
        Name identifier4 = Name.identifier("containsKey");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus3, "internalName");
        Intrinsics.checkNotNullParameter("containsKey" + '(' + "Ljava/lang/Object;" + ')' + r12, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus4 = Intrinsics.stringPlus("java/util/", "Map");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
        Name identifier5 = Name.identifier("containsValue");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus4, "internalName");
        Intrinsics.checkNotNullParameter("containsValue" + '(' + "Ljava/lang/Object;" + ')' + r9, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus5 = Intrinsics.stringPlus("java/util/", "Map");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BOOLEAN.getDesc(), "BOOLEAN.desc");
        Name identifier6 = Name.identifier("remove");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus5, "internalName");
        Intrinsics.checkNotNullParameter("remove" + '(' + "Ljava/lang/Object;Ljava/lang/Object;" + ')' + r9, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus6 = Intrinsics.stringPlus("java/util/", "Map");
        Name identifier7 = Name.identifier("getOrDefault");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus6, "internalName");
        Intrinsics.checkNotNullParameter("getOrDefault" + '(' + "Ljava/lang/Object;Ljava/lang/Object;" + ')' + "Ljava/lang/Object;", "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus7 = Intrinsics.stringPlus("java/util/", "Map");
        Name identifier8 = Name.identifier(Constant.GET);
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus7, "internalName");
        Intrinsics.checkNotNullParameter(Constant.GET + '(' + "Ljava/lang/Object;" + ')' + "Ljava/lang/Object;", "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Map", "name");
        String stringPlus8 = Intrinsics.stringPlus("java/util/", "Map");
        Name identifier9 = Name.identifier("remove");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus8, "internalName");
        Intrinsics.checkNotNullParameter("remove" + '(' + "Ljava/lang/Object;" + ')' + "Ljava/lang/Object;", "jvmDescriptor");
        Intrinsics.checkNotNullParameter(PDListAttributeObject.OWNER_LIST, "name");
        String stringPlus9 = Intrinsics.stringPlus("java/util/", PDListAttributeObject.OWNER_LIST);
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.INT.getDesc(), "INT.desc");
        Name identifier10 = Name.identifier("indexOf");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(name)");
        String str2 = Constant.GET;
        Intrinsics.checkNotNullParameter(stringPlus9, "internalName");
        Intrinsics.checkNotNullParameter("indexOf" + '(' + "Ljava/lang/Object;" + ')' + r13, "jvmDescriptor");
        Intrinsics.checkNotNullParameter(PDListAttributeObject.OWNER_LIST, "name");
        String stringPlus10 = Intrinsics.stringPlus("java/util/", PDListAttributeObject.OWNER_LIST);
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.INT.getDesc(), "INT.desc");
        Name identifier11 = Name.identifier("lastIndexOf");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus10, "internalName");
        Intrinsics.checkNotNullParameter("lastIndexOf" + '(' + "Ljava/lang/Object;" + ')' + r5, "jvmDescriptor");
        Map<NameAndSignature, TypeSafeBarrierDescription> mapOf = ArraysKt___ArraysJvmKt.mapOf(new Pair(new NameAndSignature(identifier2, stringPlus + '.' + r8), TypeSafeBarrierDescription.FALSE), new Pair(new NameAndSignature(identifier3, stringPlus2 + '.' + r2), TypeSafeBarrierDescription.FALSE), new Pair(new NameAndSignature(identifier4, stringPlus3 + '.' + r9), TypeSafeBarrierDescription.FALSE), new Pair(new NameAndSignature(identifier5, stringPlus4 + '.' + r1), TypeSafeBarrierDescription.FALSE), new Pair(new NameAndSignature(identifier6, stringPlus5 + '.' + r1), TypeSafeBarrierDescription.FALSE), new Pair(new NameAndSignature(identifier7, stringPlus6 + '.' + r4), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), new Pair(new NameAndSignature(identifier8, stringPlus7 + '.' + r4), TypeSafeBarrierDescription.NULL), new Pair(new NameAndSignature(identifier9, stringPlus8 + '.' + r13), TypeSafeBarrierDescription.NULL), new Pair(new NameAndSignature(identifier10, stringPlus9 + '.' + r2), TypeSafeBarrierDescription.INDEX), new Pair(new NameAndSignature(identifier11, stringPlus10 + '.' + r5), TypeSafeBarrierDescription.INDEX));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(TweetUtils.mapCapacity(mapOf.size()));
        for (Entry entry : mapOf.entrySet()) {
            linkedHashMap.put(((NameAndSignature) entry.getKey()).signature, entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        Set<T> plus = ArraysKt___ArraysJvmKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable<? extends T>) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList arrayList4 = new ArrayList(TweetUtils.collectionSizeOrDefault(plus, 10));
        HashSet hashSet = (HashSet) plus;
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((NameAndSignature) it2.next()).name);
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = ArraysKt___ArraysJvmKt.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(TweetUtils.collectionSizeOrDefault(plus, 10));
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((NameAndSignature) it3.next()).signature);
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = ArraysKt___ArraysJvmKt.toSet(arrayList5);
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.INT.getDesc(), "INT.desc");
        Name identifier12 = Name.identifier("removeAt");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(name)");
        Intrinsics.checkNotNullParameter("java/util/List", "internalName");
        Intrinsics.checkNotNullParameter("removeAt" + '(' + r0 + ')' + "Ljava/lang/Object;", "jvmDescriptor");
        REMOVE_AT_NAME_AND_SIGNATURE = new NameAndSignature(identifier12, "java/util/List" + '.' + r0);
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus11 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.BYTE.getDesc(), "BYTE.desc");
        Name identifier13 = Name.identifier("toByte");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus11, "internalName");
        Intrinsics.checkNotNullParameter("toByte" + '(' + "" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus12 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.SHORT.getDesc(), "SHORT.desc");
        Name identifier14 = Name.identifier("toShort");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus12, "internalName");
        Intrinsics.checkNotNullParameter("toShort" + '(' + "" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus13 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.INT.getDesc(), "INT.desc");
        Name identifier15 = Name.identifier("toInt");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus13, "internalName");
        Intrinsics.checkNotNullParameter("toInt" + '(' + "" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus14 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.LONG.getDesc(), "LONG.desc");
        Name identifier16 = Name.identifier("toLong");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus14, "internalName");
        Intrinsics.checkNotNullParameter("toLong" + '(' + "" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus15 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.FLOAT.getDesc(), "FLOAT.desc");
        Name identifier17 = Name.identifier("toFloat");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus15, "internalName");
        Intrinsics.checkNotNullParameter("toFloat" + '(' + "" + ')' + r5, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("Number", "name");
        String stringPlus16 = Intrinsics.stringPlus("java/lang/", "Number");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.DOUBLE.getDesc(), "DOUBLE.desc");
        Name identifier18 = Name.identifier("toDouble");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus16, "internalName");
        Intrinsics.checkNotNullParameter("toDouble" + '(' + "" + ')' + r4, "jvmDescriptor");
        Intrinsics.checkNotNullParameter("CharSequence", "name");
        String stringPlus17 = Intrinsics.stringPlus("java/lang/", "CharSequence");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.INT.getDesc(), "INT.desc");
        Intrinsics.checkNotNullExpressionValue(JvmPrimitiveType.CHAR.getDesc(), "CHAR.desc");
        Name identifier19 = Name.identifier(str2);
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(name)");
        Intrinsics.checkNotNullParameter(stringPlus17, "internalName");
        Intrinsics.checkNotNullParameter(str2 + '(' + r2 + ')' + r3, "jvmDescriptor");
        Map<NameAndSignature, Name> mapOf2 = ArraysKt___ArraysJvmKt.mapOf(new Pair(new NameAndSignature(identifier13, stringPlus11 + '.' + r5), Name.identifier("byteValue")), new Pair(new NameAndSignature(identifier14, stringPlus12 + '.' + r5), Name.identifier("shortValue")), new Pair(new NameAndSignature(identifier15, stringPlus13 + '.' + r5), Name.identifier("intValue")), new Pair(new NameAndSignature(identifier16, stringPlus14 + '.' + r5), Name.identifier("longValue")), new Pair(new NameAndSignature(identifier17, stringPlus15 + '.' + r5), Name.identifier("floatValue")), new Pair(new NameAndSignature(identifier18, stringPlus16 + '.' + r4), Name.identifier("doubleValue")), new Pair(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove")), new Pair(new NameAndSignature(identifier19, stringPlus17 + '.' + r2), Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(TweetUtils.mapCapacity(mapOf2.size()));
        for (Entry entry2 : mapOf2.entrySet()) {
            linkedHashMap2.put(((NameAndSignature) entry2.getKey()).signature, entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Set<NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList arrayList6 = new ArrayList(TweetUtils.collectionSizeOrDefault(keySet, 10));
        for (NameAndSignature nameAndSignature2 : keySet) {
            arrayList6.add(nameAndSignature2.name);
        }
        ORIGINAL_SHORT_NAMES = arrayList6;
        Set<Entry<NameAndSignature, Name>> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList arrayList7 = new ArrayList(TweetUtils.collectionSizeOrDefault(entrySet, 10));
        for (Entry entry3 : entrySet) {
            arrayList7.add(new Pair(((NameAndSignature) entry3.getKey()).name, entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator it4 = arrayList7.iterator();
        while (it4.hasNext()) {
            Pair pair = (Pair) it4.next();
            Name name = (Name) pair.second;
            Object obj = linkedHashMap3.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(name, obj);
            }
            ((List) obj).add((Name) pair.first);
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
