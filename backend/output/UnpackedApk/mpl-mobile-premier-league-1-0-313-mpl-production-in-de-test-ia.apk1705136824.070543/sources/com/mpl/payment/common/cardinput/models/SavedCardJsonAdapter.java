package com.mpl.payment.common.cardinput.models;

import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/common/cardinput/models/SavedCardJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/common/cardinput/models/SavedCard;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableAdditionalDetailsAdapter", "Lcom/mpl/payment/common/cardinput/models/AdditionalDetails;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedCardJsonAdapter.kt */
public final class SavedCardJsonAdapter extends JsonAdapter<SavedCard> {
    public final JsonAdapter<AdditionalDetails> nullableAdditionalDetailsAdapter;
    public final Options options;

    public SavedCardJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"additionalDetails\")");
        this.options = of;
        JsonAdapter<AdditionalDetails> adapter = moshi.adapter(AdditionalDetails.class, EmptySet.INSTANCE, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Additional…t(), \"additionalDetails\")");
        this.nullableAdditionalDetailsAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(SavedCard)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(SavedCard)";
    }

    public SavedCard fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        AdditionalDetails additionalDetails = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                additionalDetails = (AdditionalDetails) this.nullableAdditionalDetailsAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new SavedCard(additionalDetails);
    }

    public void toJson(JsonWriter jsonWriter, SavedCard savedCard) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (savedCard != null) {
            jsonWriter.beginObject();
            jsonWriter.name(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
            this.nullableAdditionalDetailsAdapter.toJson(jsonWriter, savedCard.getAdditionalDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
