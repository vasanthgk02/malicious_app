package com.mpl.payment.gopay.models;

import com.mpl.payment.routing.RoutingConstants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mpl/payment/gopay/models/SavedPaymentDetailJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/gopay/models/SavedPaymentDetail;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "additionalDetailsAdapter", "Lcom/mpl/payment/gopay/models/AdditionalDetails;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedPaymentDetailJsonAdapter.kt */
public final class SavedPaymentDetailJsonAdapter extends JsonAdapter<SavedPaymentDetail> {
    public final JsonAdapter<AdditionalDetails> additionalDetailsAdapter;
    public final Options options;

    public SavedPaymentDetailJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"additionalDetails\")");
        this.options = of;
        JsonAdapter<AdditionalDetails> adapter = moshi.adapter(AdditionalDetails.class, EmptySet.INSTANCE, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Additional…t(), \"additionalDetails\")");
        this.additionalDetailsAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(SavedPaymentDetail)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(SavedPaymentDetail)";
    }

    public SavedPaymentDetail fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        AdditionalDetails additionalDetails = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                continue;
            } else {
                additionalDetails = (AdditionalDetails) this.additionalDetailsAdapter.fromJson(jsonReader);
                if (additionalDetails == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"add…ditionalDetails\", reader)");
                    throw unexpectedNull;
                }
            }
        }
        jsonReader.endObject();
        if (additionalDetails != null) {
            return new SavedPaymentDetail(additionalDetails);
        }
        JsonDataException missingProperty = Util.missingProperty(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ad…ditionalDetails\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, SavedPaymentDetail savedPaymentDetail) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (savedPaymentDetail != null) {
            jsonWriter.beginObject();
            jsonWriter.name(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
            this.additionalDetailsAdapter.toJson(jsonWriter, savedPaymentDetail.getAdditionalDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}