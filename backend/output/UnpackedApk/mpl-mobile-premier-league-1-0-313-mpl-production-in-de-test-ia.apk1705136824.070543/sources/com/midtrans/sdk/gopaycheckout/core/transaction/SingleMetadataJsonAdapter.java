package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016R\"\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/SingleMetadataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/SingleMetadata;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableMapOfStringStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class SingleMetadataJsonAdapter extends JsonAdapter<SingleMetadata> {
    public final JsonAdapter<Map<String, String>> nullableMapOfStringStringAdapter;
    public final Options options;

    public SingleMetadataJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of(LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"metadata\")");
        this.options = of;
        JsonAdapter<Map<String, String>> adapter = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), EmptySet.INSTANCE, LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringStringAdapter = adapter;
    }

    public SingleMetadata fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        Map map = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                map = (Map) this.nullableMapOfStringStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new SingleMetadata(map);
    }

    public void toJson(JsonWriter jsonWriter, SingleMetadata singleMetadata) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (singleMetadata != null) {
            jsonWriter.beginObject();
            jsonWriter.name(LiveVideoBroadcaster.METADATA);
            this.nullableMapOfStringStringAdapter.toJson(jsonWriter, singleMetadata.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(SingleMetadata)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(SingleMetadata)";
    }
}
