package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialProperties {
    public static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    public static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    public static final Set<FqName> SPECIAL_FQ_NAMES;
    public static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        Map<FqName, Name> mapOf = ArraysKt___ArraysJvmKt.mapOf(new Pair(TweetUtils.access$childSafe(FqNames._enum, "name"), Name.identifier("name")), new Pair(TweetUtils.access$childSafe(FqNames._enum, "ordinal"), Name.identifier("ordinal")), new Pair(TweetUtils.access$child(FqNames.collection, Response.SIZE), Name.identifier(Response.SIZE)), new Pair(TweetUtils.access$child(FqNames.map, Response.SIZE), Name.identifier(Response.SIZE)), new Pair(TweetUtils.access$childSafe(FqNames.charSequence, "length"), Name.identifier("length")), new Pair(TweetUtils.access$child(FqNames.map, UserMetadata.KEYDATA_FILENAME), Name.identifier("keySet")), new Pair(TweetUtils.access$child(FqNames.map, "values"), Name.identifier("values")), new Pair(TweetUtils.access$child(FqNames.map, "entries"), Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList<>(TweetUtils.collectionSizeOrDefault(entrySet, 10));
        for (Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.second;
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.first);
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(keySet, 10));
        for (FqName shortName : keySet) {
            arrayList2.add(shortName.shortName());
        }
        SPECIAL_SHORT_NAMES = ArraysKt___ArraysJvmKt.toSet(arrayList2);
    }
}
