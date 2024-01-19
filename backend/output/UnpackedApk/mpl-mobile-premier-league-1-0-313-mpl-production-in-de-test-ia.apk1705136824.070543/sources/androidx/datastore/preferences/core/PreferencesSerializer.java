package androidx.datastore.preferences.core;

import androidx.core.widget.CompoundButtonCompat;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import androidx.datastore.preferences.PreferencesProto$PreferenceMap;
import androidx.datastore.preferences.PreferencesProto$PreferenceMap.Builder;
import androidx.datastore.preferences.PreferencesProto$StringSet;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.PreferencesProto$Value.ValueCase;
import androidx.datastore.preferences.core.Preferences.Key;
import androidx.datastore.preferences.core.Preferences.Pair;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.CodedOutputStream.OutputStreamEncoder;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Internal.ProtobufList;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.LazyStringList;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0019\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/datastore/preferences/core/PreferencesSerializer;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/preferences/core/Preferences;", "()V", "defaultValue", "getDefaultValue", "()Landroidx/datastore/preferences/core/Preferences;", "fileExtension", "", "getFileExtension", "()Ljava/lang/String;", "addProtoEntryToPreferences", "", "name", "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "mutablePreferences", "Landroidx/datastore/preferences/core/MutablePreferences;", "getValueProto", "", "readFrom", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "t", "output", "Ljava/io/OutputStream;", "(Landroidx/datastore/preferences/core/Preferences;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PreferencesSerializer.kt */
public final class PreferencesSerializer implements Serializer<Preferences> {
    public static final PreferencesSerializer INSTANCE = new PreferencesSerializer();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PreferencesSerializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValueCase.values().length];
            ValueCase valueCase = ValueCase.BOOLEAN;
            iArr[0] = 1;
            ValueCase valueCase2 = ValueCase.FLOAT;
            iArr[1] = 2;
            ValueCase valueCase3 = ValueCase.DOUBLE;
            iArr[6] = 3;
            ValueCase valueCase4 = ValueCase.INTEGER;
            iArr[2] = 4;
            ValueCase valueCase5 = ValueCase.LONG;
            iArr[3] = 5;
            ValueCase valueCase6 = ValueCase.STRING;
            iArr[4] = 6;
            ValueCase valueCase7 = ValueCase.STRING_SET;
            iArr[5] = 7;
            ValueCase valueCase8 = ValueCase.VALUE_NOT_SET;
            iArr[7] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Object getDefaultValue() {
        return new MutablePreferences(null, true, 1);
    }

    public Object readFrom(InputStream inputStream, Continuation<? super Preferences> continuation) throws IOException, CorruptionException {
        int i;
        PreferencesProto$StringSet preferencesProto$StringSet;
        Intrinsics.checkNotNullParameter(inputStream, "input");
        try {
            PreferencesProto$PreferenceMap parseFrom = PreferencesProto$PreferenceMap.parseFrom(inputStream);
            Intrinsics.checkNotNullExpressionValue(parseFrom, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
            Pair[] pairArr = new Pair[0];
            Intrinsics.checkNotNullParameter(pairArr, "pairs");
            MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1);
            Pair[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, 0);
            Intrinsics.checkNotNullParameter(pairArr2, "pairs");
            mutablePreferences.checkNotFrozen$datastore_preferences_core();
            int length = pairArr2.length;
            int i2 = 0;
            while (i2 < length) {
                if (pairArr2[i2] != null) {
                    mutablePreferences.setUnchecked$datastore_preferences_core(null, null);
                    i2++;
                } else {
                    throw null;
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(parseFrom.preferences_);
            Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "preferencesProto.preferencesMap");
            for (Entry entry : unmodifiableMap.entrySet()) {
                String str = (String) entry.getKey();
                PreferencesProto$Value preferencesProto$Value = (PreferencesProto$Value) entry.getValue();
                Intrinsics.checkNotNullExpressionValue(str, "name");
                Intrinsics.checkNotNullExpressionValue(preferencesProto$Value, HSLCriteriaBuilder.VALUE);
                ValueCase forNumber = ValueCase.forNumber(preferencesProto$Value.valueCase_);
                if (forNumber == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[forNumber.ordinal()];
                }
                switch (i) {
                    case -1:
                        throw new CorruptionException("Value case is null.", null, 2);
                    case 1:
                        Intrinsics.checkNotNullParameter(str, "name");
                        mutablePreferences.set(new Key(str), Boolean.valueOf(preferencesProto$Value.valueCase_ == 1 ? ((Boolean) preferencesProto$Value.value_).booleanValue() : false));
                        break;
                    case 2:
                        Intrinsics.checkNotNullParameter(str, "name");
                        mutablePreferences.set(new Key(str), Float.valueOf(preferencesProto$Value.valueCase_ == 2 ? ((Float) preferencesProto$Value.value_).floatValue() : 0.0f));
                        break;
                    case 3:
                        Intrinsics.checkNotNullParameter(str, "name");
                        mutablePreferences.set(new Key(str), Double.valueOf(preferencesProto$Value.valueCase_ == 7 ? ((Double) preferencesProto$Value.value_).doubleValue() : 0.0d));
                        break;
                    case 4:
                        Intrinsics.checkNotNullParameter(str, "name");
                        mutablePreferences.set(new Key(str), Integer.valueOf(preferencesProto$Value.valueCase_ == 3 ? ((Integer) preferencesProto$Value.value_).intValue() : 0));
                        break;
                    case 5:
                        Intrinsics.checkNotNullParameter(str, "name");
                        mutablePreferences.set(new Key(str), Long.valueOf(preferencesProto$Value.valueCase_ == 4 ? ((Long) preferencesProto$Value.value_).longValue() : 0));
                        break;
                    case 6:
                        Key<String> stringKey = CompoundButtonCompat.stringKey(str);
                        String str2 = preferencesProto$Value.valueCase_ == 5 ? (String) preferencesProto$Value.value_ : "";
                        Intrinsics.checkNotNullExpressionValue(str2, "value.string");
                        mutablePreferences.set(stringKey, str2);
                        break;
                    case 7:
                        Intrinsics.checkNotNullParameter(str, "name");
                        Key key = new Key(str);
                        if (preferencesProto$Value.valueCase_ == 6) {
                            preferencesProto$StringSet = (PreferencesProto$StringSet) preferencesProto$Value.value_;
                        } else {
                            preferencesProto$StringSet = PreferencesProto$StringSet.DEFAULT_INSTANCE;
                        }
                        ProtobufList<String> protobufList = preferencesProto$StringSet.strings_;
                        Intrinsics.checkNotNullExpressionValue(protobufList, "value.stringSet.stringsList");
                        mutablePreferences.set(key, ArraysKt___ArraysJvmKt.toSet(protobufList));
                        break;
                    case 8:
                        throw new CorruptionException("Value not set.", null, 2);
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            return new MutablePreferences(ArraysKt___ArraysJvmKt.toMutableMap(mutablePreferences.asMap()), true);
        } catch (InvalidProtocolBufferException e2) {
            throw new CorruptionException("Unable to parse preferences proto.", e2);
        }
    }

    public Object writeTo(Object obj, OutputStream outputStream, Continuation continuation) {
        PreferencesProto$Value preferencesProto$Value;
        Map<Key<?>, Object> asMap = ((Preferences) obj).asMap();
        Builder builder = (Builder) PreferencesProto$PreferenceMap.DEFAULT_INSTANCE.createBuilder();
        for (Entry next : asMap.entrySet()) {
            Object value = next.getValue();
            String str = ((Key) next.getKey()).name;
            if (value instanceof Boolean) {
                PreferencesProto$Value.Builder newBuilder = PreferencesProto$Value.newBuilder();
                boolean booleanValue = ((Boolean) value).booleanValue();
                newBuilder.copyOnWrite();
                PreferencesProto$Value preferencesProto$Value2 = (PreferencesProto$Value) newBuilder.instance;
                preferencesProto$Value2.valueCase_ = 1;
                preferencesProto$Value2.value_ = Boolean.valueOf(booleanValue);
                GeneratedMessageLite build = newBuilder.build();
                Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setBoolean(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build;
            } else if (value instanceof Float) {
                PreferencesProto$Value.Builder newBuilder2 = PreferencesProto$Value.newBuilder();
                float floatValue = ((Number) value).floatValue();
                newBuilder2.copyOnWrite();
                PreferencesProto$Value preferencesProto$Value3 = (PreferencesProto$Value) newBuilder2.instance;
                preferencesProto$Value3.valueCase_ = 2;
                preferencesProto$Value3.value_ = Float.valueOf(floatValue);
                GeneratedMessageLite build2 = newBuilder2.build();
                Intrinsics.checkNotNullExpressionValue(build2, "newBuilder().setFloat(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build2;
            } else if (value instanceof Double) {
                PreferencesProto$Value.Builder newBuilder3 = PreferencesProto$Value.newBuilder();
                double doubleValue = ((Number) value).doubleValue();
                newBuilder3.copyOnWrite();
                PreferencesProto$Value preferencesProto$Value4 = (PreferencesProto$Value) newBuilder3.instance;
                preferencesProto$Value4.valueCase_ = 7;
                preferencesProto$Value4.value_ = Double.valueOf(doubleValue);
                GeneratedMessageLite build3 = newBuilder3.build();
                Intrinsics.checkNotNullExpressionValue(build3, "newBuilder().setDouble(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build3;
            } else if (value instanceof Integer) {
                PreferencesProto$Value.Builder newBuilder4 = PreferencesProto$Value.newBuilder();
                int intValue = ((Number) value).intValue();
                newBuilder4.copyOnWrite();
                PreferencesProto$Value preferencesProto$Value5 = (PreferencesProto$Value) newBuilder4.instance;
                preferencesProto$Value5.valueCase_ = 3;
                preferencesProto$Value5.value_ = Integer.valueOf(intValue);
                GeneratedMessageLite build4 = newBuilder4.build();
                Intrinsics.checkNotNullExpressionValue(build4, "newBuilder().setInteger(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build4;
            } else if (value instanceof Long) {
                PreferencesProto$Value.Builder newBuilder5 = PreferencesProto$Value.newBuilder();
                long longValue = ((Number) value).longValue();
                newBuilder5.copyOnWrite();
                PreferencesProto$Value preferencesProto$Value6 = (PreferencesProto$Value) newBuilder5.instance;
                preferencesProto$Value6.valueCase_ = 4;
                preferencesProto$Value6.value_ = Long.valueOf(longValue);
                GeneratedMessageLite build5 = newBuilder5.build();
                Intrinsics.checkNotNullExpressionValue(build5, "newBuilder().setLong(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build5;
            } else if (value instanceof String) {
                PreferencesProto$Value.Builder newBuilder6 = PreferencesProto$Value.newBuilder();
                newBuilder6.copyOnWrite();
                PreferencesProto$Value.access$1300((PreferencesProto$Value) newBuilder6.instance, (String) value);
                GeneratedMessageLite build6 = newBuilder6.build();
                Intrinsics.checkNotNullExpressionValue(build6, "newBuilder().setString(value).build()");
                preferencesProto$Value = (PreferencesProto$Value) build6;
            } else if (value instanceof Set) {
                PreferencesProto$Value.Builder newBuilder7 = PreferencesProto$Value.newBuilder();
                PreferencesProto$StringSet.Builder builder2 = (PreferencesProto$StringSet.Builder) PreferencesProto$StringSet.DEFAULT_INSTANCE.createBuilder();
                Set set = (Set) value;
                builder2.copyOnWrite();
                PreferencesProto$StringSet preferencesProto$StringSet = (PreferencesProto$StringSet) builder2.instance;
                if (!preferencesProto$StringSet.strings_.isModifiable()) {
                    ProtobufList<String> protobufList = preferencesProto$StringSet.strings_;
                    int size = protobufList.size();
                    preferencesProto$StringSet.strings_ = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                }
                ProtobufList<String> protobufList2 = preferencesProto$StringSet.strings_;
                Internal.checkNotNull(set);
                if (set instanceof LazyStringList) {
                    List<?> underlyingElements = ((LazyStringList) set).getUnderlyingElements();
                    LazyStringList lazyStringList = (LazyStringList) protobufList2;
                    int size2 = protobufList2.size();
                    for (Object next2 : underlyingElements) {
                        if (next2 == null) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Element at index ");
                            outline73.append(lazyStringList.size() - size2);
                            outline73.append(" is null.");
                            String sb = outline73.toString();
                            int size3 = lazyStringList.size();
                            while (true) {
                                size3--;
                                if (size3 >= size2) {
                                    lazyStringList.remove(size3);
                                } else {
                                    throw new NullPointerException(sb);
                                }
                            }
                        } else if (next2 instanceof ByteString) {
                            lazyStringList.add((ByteString) next2);
                        } else {
                            lazyStringList.add((String) next2);
                        }
                    }
                } else if (set instanceof PrimitiveNonBoxingCollection) {
                    protobufList2.addAll(set);
                } else {
                    if (protobufList2 instanceof ArrayList) {
                        ((ArrayList) protobufList2).ensureCapacity(set.size() + protobufList2.size());
                    }
                    int size4 = protobufList2.size();
                    for (Object next3 : set) {
                        if (next3 == null) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Element at index ");
                            outline732.append(protobufList2.size() - size4);
                            outline732.append(" is null.");
                            String sb2 = outline732.toString();
                            int size5 = protobufList2.size();
                            while (true) {
                                size5--;
                                if (size5 >= size4) {
                                    protobufList2.remove(size5);
                                } else {
                                    throw new NullPointerException(sb2);
                                }
                            }
                        } else {
                            protobufList2.add(next3);
                        }
                    }
                }
                newBuilder7.copyOnWrite();
                PreferencesProto$Value.access$1700((PreferencesProto$Value) newBuilder7.instance, builder2);
                GeneratedMessageLite build7 = newBuilder7.build();
                Intrinsics.checkNotNullExpressionValue(build7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
                preferencesProto$Value = (PreferencesProto$Value) build7;
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("PreferencesSerializer does not support type: ", value.getClass().getName()));
            }
            if (str != null) {
                builder.copyOnWrite();
                PreferencesProto$PreferenceMap preferencesProto$PreferenceMap = (PreferencesProto$PreferenceMap) builder.instance;
                MapFieldLite<String, PreferencesProto$Value> mapFieldLite = preferencesProto$PreferenceMap.preferences_;
                if (!mapFieldLite.isMutable) {
                    preferencesProto$PreferenceMap.preferences_ = mapFieldLite.mutableCopy();
                }
                preferencesProto$PreferenceMap.preferences_.put(str, preferencesProto$Value);
            } else {
                throw null;
            }
        }
        PreferencesProto$PreferenceMap preferencesProto$PreferenceMap2 = (PreferencesProto$PreferenceMap) builder.build();
        OutputStreamEncoder outputStreamEncoder = new OutputStreamEncoder(outputStream, CodedOutputStream.computePreferredBufferSize(preferencesProto$PreferenceMap2.getSerializedSize()));
        preferencesProto$PreferenceMap2.writeTo(outputStreamEncoder);
        if (outputStreamEncoder.position > 0) {
            outputStreamEncoder.doFlush();
        }
        return Unit.INSTANCE;
    }
}
