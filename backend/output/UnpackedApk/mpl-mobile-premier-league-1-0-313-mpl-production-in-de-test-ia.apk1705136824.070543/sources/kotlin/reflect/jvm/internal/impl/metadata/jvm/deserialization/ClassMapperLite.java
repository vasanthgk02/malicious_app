package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.imagepicker.IdologyKycIdCapture;
import com.mpl.androidapp.miniprofile.ct.C.ReminderSet;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    public static final String f5946kotlin = ArraysKt___ArraysJvmKt.joinToString$default(TweetUtils.listOf((T[]) new Character[]{Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n')}), "", null, null, 0, null, null, 62);
    public static final Map<String, String> map;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = TweetUtils.listOf((T[]) new String[]{HanselEventConstant.DATA_TYPE_BOOLEAN, "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, "Long", "J", "Double", "D"});
        int progressionLastElement = TweetUtils.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                int i4 = i2 + 1;
                linkedHashMap.put(f5946kotlin + '/' + ((String) listOf.get(i2)), listOf.get(i4));
                StringBuilder sb = new StringBuilder();
                sb.append(f5946kotlin);
                sb.append('/');
                linkedHashMap.put(GeneratedOutlineSupport.outline62(sb, (String) listOf.get(i2), "Array"), Intrinsics.stringPlus("[", listOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(Intrinsics.stringPlus(f5946kotlin, "/Unit"), DefaultSFSDataSerializer.FIELD_VALUE_KEY);
        m967map$lambda0$add(linkedHashMap, IdologyKycIdCapture.DOC_TYPE_ANY, "java/lang/Object");
        m967map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m967map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str : TweetUtils.listOf((T[]) new String[]{HanselEventConstant.DATA_TYPE_STRING, "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            m967map$lambda0$add(linkedHashMap, str, Intrinsics.stringPlus("java/lang/", str));
        }
        for (String str2 : TweetUtils.listOf((T[]) new String[]{"Iterator", "Collection", PDListAttributeObject.OWNER_LIST, ReminderSet.STATE_SET, "Map", "ListIterator"})) {
            m967map$lambda0$add(linkedHashMap, Intrinsics.stringPlus("collections/", str2), Intrinsics.stringPlus("java/util/", str2));
            m967map$lambda0$add(linkedHashMap, Intrinsics.stringPlus("collections/Mutable", str2), Intrinsics.stringPlus("java/util/", str2));
        }
        m967map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m967map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m967map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m967map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String stringPlus = Intrinsics.stringPlus("Function", Integer.valueOf(i));
            m967map$lambda0$add(linkedHashMap, stringPlus, f5946kotlin + "/jvm/functions/Function" + i);
            m967map$lambda0$add(linkedHashMap, Intrinsics.stringPlus("reflect/KFunction", Integer.valueOf(i)), Intrinsics.stringPlus(f5946kotlin, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        for (String str3 : TweetUtils.listOf((T[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", HanselEventConstant.DATA_TYPE_STRING, "Enum"})) {
            String stringPlus2 = Intrinsics.stringPlus(str3, ".Companion");
            m967map$lambda0$add(linkedHashMap, stringPlus2, f5946kotlin + "/jvm/internal/" + str3 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    /* renamed from: map$lambda-0$add  reason: not valid java name */
    public static final void m967map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f5946kotlin + '/' + str, 'L' + str2 + DefaultObjectDumpFormatter.TOKEN_DIVIDER);
    }

    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('L');
        outline72.append(CharsKt__CharKt.replace$default(str, '.', '$', false, 4));
        outline72.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
        return outline72.toString();
    }
}
