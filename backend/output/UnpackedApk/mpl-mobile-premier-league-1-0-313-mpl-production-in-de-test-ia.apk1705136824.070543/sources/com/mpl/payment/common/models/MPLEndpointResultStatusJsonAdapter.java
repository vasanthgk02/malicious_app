package com.mpl.payment.common.models;

import com.mpl.payment.cardverification.models.Status;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/common/models/MPLEndpointResultStatusJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/common/models/MPLEndpointResultStatus;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "statusAdapter", "Lcom/mpl/payment/cardverification/models/Status;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLEndpointResultStatusJsonAdapter.kt */
public final class MPLEndpointResultStatusJsonAdapter extends JsonAdapter<MPLEndpointResultStatus> {
    public final Options options;
    public final JsonAdapter<Status> statusAdapter;

    public MPLEndpointResultStatusJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("status");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"status\")");
        this.options = of;
        JsonAdapter<Status> adapter = moshi.adapter(Status.class, EmptySet.INSTANCE, "status");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Status::cl…ptySet(),\n      \"status\")");
        this.statusAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(MPLEndpointResultStatus)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(MPLEndpointResultStatus)";
    }

    public MPLEndpointResultStatus fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Status status = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                status = (Status) this.statusAdapter.fromJson(jsonReader);
                if (status == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("status", "status", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"sta…        \"status\", reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (status != null) {
            return new MPLEndpointResultStatus(status);
        }
        JsonDataException missingProperty = Util.missingProperty("status", "status", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"status\", \"status\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, MPLEndpointResultStatus mPLEndpointResultStatus) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (mPLEndpointResultStatus != null) {
            jsonWriter.beginObject();
            jsonWriter.name("status");
            this.statusAdapter.toJson(jsonWriter, mPLEndpointResultStatus.getStatus());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}