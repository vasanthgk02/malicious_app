package com.mpl.payment.phonepe.models;

import com.mpl.payment.phonepe.models.PhonePeReactPayload.SavedPaymentDetail;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeReactPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "savedPaymentDetailAdapter", "Lcom/mpl/payment/phonepe/models/PhonePeReactPayload$SavedPaymentDetail;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeReactPayloadJsonAdapter.kt */
public final class PhonePeReactPayloadJsonAdapter extends JsonAdapter<PhonePeReactPayload> {
    public final JsonAdapter<Integer> intAdapter;
    public final Options options;
    public final JsonAdapter<SavedPaymentDetail> savedPaymentDetailAdapter;
    public final JsonAdapter<String> stringAdapter;

    public PhonePeReactPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("complete_deposit_url", "phonePeDirectRequestCode", "savedPaymentDetails");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"c…\", \"savedPaymentDetails\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "completeDepositUrl");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…    \"completeDepositUrl\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, EmptySet.INSTANCE, "phonePeDirectRequestCode");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…honePeDirectRequestCode\")");
        this.intAdapter = adapter2;
        JsonAdapter<SavedPaymentDetail> adapter3 = moshi.adapter(SavedPaymentDetail.class, EmptySet.INSTANCE, "savedPaymentDetails");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(PhonePeRea…   \"savedPaymentDetails\")");
        this.savedPaymentDetailAdapter = adapter3;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(PhonePeReactPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(PhonePeReactPayload)";
    }

    public PhonePeReactPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Integer num = null;
        SavedPaymentDetail savedPaymentDetail = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("completeDepositUrl", "complete_deposit_url", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"com…ete_deposit_url\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                Integer num2 = (Integer) this.intAdapter.fromJson(jsonReader);
                if (num2 != null) {
                    num = Integer.valueOf(num2.intValue());
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("phonePeDirectRequestCode", "phonePeDirectRequestCode", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"pho…ode\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName != 2) {
                continue;
            } else {
                savedPaymentDetail = (SavedPaymentDetail) this.savedPaymentDetailAdapter.fromJson(jsonReader);
                if (savedPaymentDetail == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("savedPaymentDetails", "savedPaymentDetails", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"sav…dPaymentDetails\", reader)");
                    throw unexpectedNull3;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("completeDepositUrl", "complete_deposit_url", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"co…ete_deposit_url\", reader)");
            throw missingProperty;
        } else if (num != null) {
            int intValue = num.intValue();
            if (savedPaymentDetail != null) {
                return new PhonePeReactPayload(str, intValue, savedPaymentDetail);
            }
            JsonDataException missingProperty2 = Util.missingProperty("savedPaymentDetails", "savedPaymentDetails", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"sa…dPaymentDetails\", reader)");
            throw missingProperty2;
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("phonePeDirectRequestCode", "phonePeDirectRequestCode", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"ph…ode\",\n            reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, PhonePeReactPayload phonePeReactPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (phonePeReactPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("complete_deposit_url");
            this.stringAdapter.toJson(jsonWriter, phonePeReactPayload.getCompleteDepositUrl());
            jsonWriter.name("phonePeDirectRequestCode");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(phonePeReactPayload.getPhonePeDirectRequestCode()));
            jsonWriter.name("savedPaymentDetails");
            this.savedPaymentDetailAdapter.toJson(jsonWriter, phonePeReactPayload.getSavedPaymentDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
