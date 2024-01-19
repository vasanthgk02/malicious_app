package com.mpl.payment.cardverification.models;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/cardverification/models/CardVerificationReactPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/cardverification/models/CardVerificationReactPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardVerificationReactPayloadJsonAdapter.kt */
public final class CardVerificationReactPayloadJsonAdapter extends JsonAdapter<CardVerificationReactPayload> {
    public final JsonAdapter<Boolean> booleanAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public CardVerificationReactPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("amount", "paymentMode", "paymentMethodType", RoutingConstants.MI_REACT_IS_3DS_ON, "isCardVerificationOn");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…, \"isCardVerificationOn\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "amount");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"amount\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, EmptySet.INSTANCE, RoutingConstants.MI_REACT_IS_3DS_ON);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…tySet(),\n      \"is3DSOn\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(CardVerificationReactPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(CardVerificationReactPayload)";
    }

    public CardVerificationReactPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        Boolean bool2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("amount", "amount", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"amo…        \"amount\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("paymentMode", "paymentMode", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"pay…\", \"paymentMode\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("paymentMethodType", "paymentMethodType", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"pay…ymentMethodType\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                Boolean bool3 = (Boolean) this.booleanAdapter.fromJson(jsonReader);
                if (bool3 != null) {
                    bool = Boolean.valueOf(bool3.booleanValue());
                } else {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull(RoutingConstants.MI_REACT_IS_3DS_ON, RoutingConstants.MI_REACT_IS_3DS_ON, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"is3…       \"is3DSOn\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName != 4) {
                continue;
            } else {
                Boolean bool4 = (Boolean) this.booleanAdapter.fromJson(jsonReader);
                if (bool4 != null) {
                    bool2 = Boolean.valueOf(bool4.booleanValue());
                } else {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull("isCardVerificationOn", "isCardVerificationOn", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"isC…dVerificationOn\", reader)");
                    throw unexpectedNull5;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("amount", "amount", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"amount\", \"amount\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("paymentMode", "paymentMode", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"pa…ode\",\n            reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("paymentMethodType", "paymentMethodType", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"pa…ymentMethodType\", reader)");
            throw missingProperty3;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (bool2 != null) {
                CardVerificationReactPayload cardVerificationReactPayload = new CardVerificationReactPayload(str, str2, str3, booleanValue, bool2.booleanValue());
                return cardVerificationReactPayload;
            }
            JsonDataException missingProperty4 = Util.missingProperty("isCardVerificationOn", "isCardVerificationOn", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"is…dVerificationOn\", reader)");
            throw missingProperty4;
        } else {
            JsonDataException missingProperty5 = Util.missingProperty(RoutingConstants.MI_REACT_IS_3DS_ON, RoutingConstants.MI_REACT_IS_3DS_ON, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"is3DSOn\", \"is3DSOn\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, CardVerificationReactPayload cardVerificationReactPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (cardVerificationReactPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("amount");
            this.stringAdapter.toJson(jsonWriter, cardVerificationReactPayload.getAmount());
            jsonWriter.name("paymentMode");
            this.stringAdapter.toJson(jsonWriter, cardVerificationReactPayload.getPaymentMode());
            jsonWriter.name("paymentMethodType");
            this.stringAdapter.toJson(jsonWriter, cardVerificationReactPayload.getPaymentMethodType());
            jsonWriter.name(RoutingConstants.MI_REACT_IS_3DS_ON);
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(cardVerificationReactPayload.is3DSOn()));
            jsonWriter.name("isCardVerificationOn");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(cardVerificationReactPayload.isCardVerificationOn()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
