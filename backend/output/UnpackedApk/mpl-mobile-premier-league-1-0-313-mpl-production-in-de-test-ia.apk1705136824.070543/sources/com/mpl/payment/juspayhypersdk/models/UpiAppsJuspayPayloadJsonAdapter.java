package com.mpl.payment.juspayhypersdk.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/models/UpiAppsJuspayPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/models/UpiAppsJuspayPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfUpiAppModelAdapter", "", "Lcom/mpl/payment/juspayhypersdk/models/UpiAppModel;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpiAppsJuspayPayloadJsonAdapter.kt */
public final class UpiAppsJuspayPayloadJsonAdapter extends JsonAdapter<UpiAppsJuspayPayload> {
    public final JsonAdapter<List<UpiAppModel>> listOfUpiAppModelAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public UpiAppsJuspayPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("action", "availableApps");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"action\", \"availableApps\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "action");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"action\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<UpiAppModel>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, UpiAppModel.class), EmptySet.INSTANCE, "availableApps");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…tySet(), \"availableApps\")");
        this.listOfUpiAppModelAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(UpiAppsJuspayPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(UpiAppsJuspayPayload)";
    }

    public UpiAppsJuspayPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("action", "action", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"act…        \"action\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName != 1) {
                continue;
            } else {
                list = (List) this.listOfUpiAppModelAdapter.fromJson(jsonReader);
                if (list == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("availableApps", "availableApps", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"ava… \"availableApps\", reader)");
                    throw unexpectedNull2;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("action", "action", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"action\", \"action\", reader)");
            throw missingProperty;
        } else if (list != null) {
            return new UpiAppsJuspayPayload(str, list);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("availableApps", "availableApps", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"av… \"availableApps\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, UpiAppsJuspayPayload upiAppsJuspayPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (upiAppsJuspayPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("action");
            this.stringAdapter.toJson(jsonWriter, upiAppsJuspayPayload.getAction());
            jsonWriter.name("availableApps");
            this.listOfUpiAppModelAdapter.toJson(jsonWriter, upiAppsJuspayPayload.getAvailableApps());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
