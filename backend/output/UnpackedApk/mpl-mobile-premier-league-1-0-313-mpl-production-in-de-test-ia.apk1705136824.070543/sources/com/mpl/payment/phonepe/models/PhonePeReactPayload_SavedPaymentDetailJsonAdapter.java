package com.mpl.payment.phonepe.models;

import com.mpl.payment.phonepe.models.PhonePeReactPayload.AdditionalDetails;
import com.mpl.payment.phonepe.models.PhonePeReactPayload.SavedPaymentDetail;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeReactPayload_SavedPaymentDetailJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "additionalDetailsAdapter", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$AdditionalDetails;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeReactPayload_SavedPaymentDetailJsonAdapter.kt */
public final class PhonePeReactPayload_SavedPaymentDetailJsonAdapter extends JsonAdapter<SavedPaymentDetail> {
    public final JsonAdapter<AdditionalDetails> additionalDetailsAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public PhonePeReactPayload_SavedPaymentDetailJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("plugin", RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"p…in\", \"additionalDetails\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "plugin");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"plugin\")");
        this.stringAdapter = adapter;
        JsonAdapter<AdditionalDetails> adapter2 = moshi.adapter(AdditionalDetails.class, EmptySet.INSTANCE, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(PhonePeRea…     \"additionalDetails\")");
        this.additionalDetailsAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        sb.append("GeneratedJsonAdapter(");
        sb.append("PhonePeReactPayload.SavedPaymentDetail");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public SavedPaymentDetail fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        AdditionalDetails additionalDetails = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("plugin", "plugin", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"plu…        \"plugin\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName != 1) {
                continue;
            } else {
                additionalDetails = (AdditionalDetails) this.additionalDetailsAdapter.fromJson(jsonReader);
                if (additionalDetails == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"add…ditionalDetails\", reader)");
                    throw unexpectedNull2;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("plugin", "plugin", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"plugin\", \"plugin\", reader)");
            throw missingProperty;
        } else if (additionalDetails != null) {
            return new SavedPaymentDetail(str, additionalDetails);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, RoutingConstants.MI_REACT_ADDITIONAL_DETAILS, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"ad…ditionalDetails\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, SavedPaymentDetail savedPaymentDetail) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (savedPaymentDetail != null) {
            jsonWriter.beginObject();
            jsonWriter.name("plugin");
            this.stringAdapter.toJson(jsonWriter, savedPaymentDetail.getPlugin());
            jsonWriter.name(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
            this.additionalDetailsAdapter.toJson(jsonWriter, savedPaymentDetail.getAdditionalDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
