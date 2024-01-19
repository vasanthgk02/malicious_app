package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.facebook.react.modules.network.NetworkingModule;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptySet;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.text.CharsKt__CharKt;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion = new Companion(null);
    public static final List<String> PREDEFINED_STRINGS;

    /* renamed from: kotlin  reason: collision with root package name */
    public static final String f5947kotlin;
    public final Set<Integer> localNameIndices;
    public final List<Record> records;
    public final String[] strings;
    public final StringTableTypes types;

    /* compiled from: JvmNameResolver.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> getPREDEFINED_STRINGS() {
            return JvmNameResolver.PREDEFINED_STRINGS;
        }
    }

    static {
        String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default(TweetUtils.listOf((T[]) new Character[]{Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n')}), "", null, null, 0, null, null, 62);
        f5947kotlin = joinToString$default;
        int i = 16;
        PREDEFINED_STRINGS = TweetUtils.listOf((T[]) new String[]{Intrinsics.stringPlus(joinToString$default, "/Any"), Intrinsics.stringPlus(f5947kotlin, "/Nothing"), Intrinsics.stringPlus(f5947kotlin, "/Unit"), Intrinsics.stringPlus(f5947kotlin, "/Throwable"), Intrinsics.stringPlus(f5947kotlin, "/Number"), Intrinsics.stringPlus(f5947kotlin, "/Byte"), Intrinsics.stringPlus(f5947kotlin, "/Double"), Intrinsics.stringPlus(f5947kotlin, "/Float"), Intrinsics.stringPlus(f5947kotlin, "/Int"), Intrinsics.stringPlus(f5947kotlin, "/Long"), Intrinsics.stringPlus(f5947kotlin, "/Short"), Intrinsics.stringPlus(f5947kotlin, "/Boolean"), Intrinsics.stringPlus(f5947kotlin, "/Char"), Intrinsics.stringPlus(f5947kotlin, "/CharSequence"), Intrinsics.stringPlus(f5947kotlin, "/String"), Intrinsics.stringPlus(f5947kotlin, "/Comparable"), Intrinsics.stringPlus(f5947kotlin, "/Enum"), Intrinsics.stringPlus(f5947kotlin, "/Array"), Intrinsics.stringPlus(f5947kotlin, "/ByteArray"), Intrinsics.stringPlus(f5947kotlin, "/DoubleArray"), Intrinsics.stringPlus(f5947kotlin, "/FloatArray"), Intrinsics.stringPlus(f5947kotlin, "/IntArray"), Intrinsics.stringPlus(f5947kotlin, "/LongArray"), Intrinsics.stringPlus(f5947kotlin, "/ShortArray"), Intrinsics.stringPlus(f5947kotlin, "/BooleanArray"), Intrinsics.stringPlus(f5947kotlin, "/CharArray"), Intrinsics.stringPlus(f5947kotlin, "/Cloneable"), Intrinsics.stringPlus(f5947kotlin, "/Annotation"), Intrinsics.stringPlus(f5947kotlin, "/collections/Iterable"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableIterable"), Intrinsics.stringPlus(f5947kotlin, "/collections/Collection"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableCollection"), Intrinsics.stringPlus(f5947kotlin, "/collections/List"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableList"), Intrinsics.stringPlus(f5947kotlin, "/collections/Set"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableSet"), Intrinsics.stringPlus(f5947kotlin, "/collections/Map"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableMap"), Intrinsics.stringPlus(f5947kotlin, "/collections/Map.Entry"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableMap.MutableEntry"), Intrinsics.stringPlus(f5947kotlin, "/collections/Iterator"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableIterator"), Intrinsics.stringPlus(f5947kotlin, "/collections/ListIterator"), Intrinsics.stringPlus(f5947kotlin, "/collections/MutableListIterator")});
        Iterable<IndexedValue<T>> withIndex = ArraysKt___ArraysJvmKt.withIndex(Companion.getPREDEFINED_STRINGS());
        int mapCapacity = TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(withIndex, 10));
        if (mapCapacity >= 16) {
            i = mapCapacity;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(i);
        Iterator it = ((IndexingIterable) withIndex).iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it;
            if (indexingIterator.hasNext()) {
                IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                linkedHashMap.put((String) indexedValue.value, Integer.valueOf(indexedValue.index));
            } else {
                return;
            }
        }
    }

    public JvmNameResolver(StringTableTypes stringTableTypes, String[] strArr) {
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(stringTableTypes, "types");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        this.types = stringTableTypes;
        this.strings = strArr;
        List<Integer> list = stringTableTypes.localName_;
        if (list.isEmpty()) {
            set = EmptySet.INSTANCE;
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "");
            set = ArraysKt___ArraysJvmKt.toSet(list);
        }
        this.localNameIndices = set;
        ArrayList arrayList = new ArrayList();
        List<Record> list2 = this.types.record_;
        arrayList.ensureCapacity(list2.size());
        for (Record next : list2) {
            int i = next.range_;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(next);
            }
        }
        arrayList.trimToSize();
        this.records = arrayList;
    }

    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    public String getString(int i) {
        String str;
        Record record = this.records.get(i);
        if ((record.bitField0_ & 4) == 4) {
            Object obj = record.string_;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    record.string_ = stringUtf8;
                }
                str = stringUtf8;
            }
        } else {
            if ((record.bitField0_ & 2) == 2) {
                int size = PREDEFINED_STRINGS.size() - 1;
                int i2 = record.predefinedIndex_;
                if (i2 >= 0 && i2 <= size) {
                    str = PREDEFINED_STRINGS.get(record.predefinedIndex_);
                }
            }
            str = this.strings[i];
        }
        if (record.substringIndex_.size() >= 2) {
            List<Integer> list = record.substringIndex_;
            Intrinsics.checkNotNullExpressionValue(list, "substringIndexList");
            Integer num = list.get(0);
            Integer num2 = list.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, AnalyticsConstants.END);
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        if (record.replaceChar_.size() >= 2) {
            List<Integer> list2 = record.replaceChar_;
            Intrinsics.checkNotNullExpressionValue(list2, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            str = CharsKt__CharKt.replace$default(str, (char) list2.get(0).intValue(), (char) list2.get(1).intValue(), false, 4);
        }
        Operation operation = record.operation_;
        if (operation == null) {
            operation = Operation.NONE;
        }
        int ordinal = operation.ordinal();
        if (ordinal == 1) {
            Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            str = CharsKt__CharKt.replace$default(str, '$', '.', false, 4);
        } else if (ordinal == 2) {
            if (str.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
                str = str.substring(1, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            str = CharsKt__CharKt.replace$default(str, '$', '.', false, 4);
        }
        Intrinsics.checkNotNullExpressionValue(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        return str;
    }

    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }
}
