package com.mpl.payment.gopay.models;

import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/gopay/models/GopayTransacrionReactPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/gopay/models/GopayTransacrionReactPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "savedPaymentDetailAdapter", "Lcom/mpl/payment/gopay/models/SavedPaymentDetail;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GopayTransacrionReactPayloadJsonAdapter.kt */
public final class GopayTransacrionReactPayloadJsonAdapter extends JsonAdapter<GopayTransacrionReactPayload> {
    public final Options options;
    public final JsonAdapter<SavedPaymentDetail> savedPaymentDetailAdapter;
    public final JsonAdapter<String> stringAdapter;

    public GopayTransacrionReactPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("amount", "savedPaymentDetails", PaymentConstants.MERCHANT_ID_CAMEL, "callBackUrl", "merchantServerUrl", "currency", RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a… \"currency\", \"mobNumber\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "amount");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"amount\")");
        this.stringAdapter = adapter;
        JsonAdapter<SavedPaymentDetail> adapter2 = moshi.adapter(SavedPaymentDetail.class, EmptySet.INSTANCE, "savedPaymentDetails");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(SavedPayme…), \"savedPaymentDetails\")");
        this.savedPaymentDetailAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(GopayTransacrionReactPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(GopayTransacrionReactPayload)";
    }

    public GopayTransacrionReactPayload fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        SavedPaymentDetail savedPaymentDetail = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (true) {
            String str7 = str6;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        String str8 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str8 != null) {
                            str = str8;
                            break;
                        } else {
                            JsonDataException unexpectedNull = Util.unexpectedNull("amount", "amount", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"amo…        \"amount\", reader)");
                            throw unexpectedNull;
                        }
                    case 1:
                        SavedPaymentDetail savedPaymentDetail2 = (SavedPaymentDetail) this.savedPaymentDetailAdapter.fromJson(jsonReader2);
                        if (savedPaymentDetail2 != null) {
                            savedPaymentDetail = savedPaymentDetail2;
                            break;
                        } else {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("savedPaymentDetails", "savedPaymentDetails", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"sav…dPaymentDetails\", reader)");
                            throw unexpectedNull2;
                        }
                    case 2:
                        String str9 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str9 != null) {
                            str2 = str9;
                            break;
                        } else {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"mer…    \"merchantId\", reader)");
                            throw unexpectedNull3;
                        }
                    case 3:
                        String str10 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str10 != null) {
                            str3 = str10;
                            break;
                        } else {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("callBackUrl", "callBackUrl", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"cal…\", \"callBackUrl\", reader)");
                            throw unexpectedNull4;
                        }
                    case 4:
                        String str11 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str11 != null) {
                            str4 = str11;
                            break;
                        } else {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("merchantServerUrl", "merchantServerUrl", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"mer…rchantServerUrl\", reader)");
                            throw unexpectedNull5;
                        }
                    case 5:
                        String str12 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str12 != null) {
                            str5 = str12;
                            break;
                        } else {
                            JsonDataException unexpectedNull6 = Util.unexpectedNull("currency", "currency", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "Util.unexpectedNull(\"cur…      \"currency\", reader)");
                            throw unexpectedNull6;
                        }
                    case 6:
                        String str13 = (String) this.stringAdapter.fromJson(jsonReader2);
                        if (str13 != null) {
                            str6 = str13;
                            continue;
                        } else {
                            JsonDataException unexpectedNull7 = Util.unexpectedNull(RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "Util.unexpectedNull(\"mob…     \"mobNumber\", reader)");
                            throw unexpectedNull7;
                        }
                }
                str6 = str7;
            } else {
                jsonReader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("amount", "amount", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"amount\", \"amount\", reader)");
                    throw missingProperty;
                } else if (savedPaymentDetail == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("savedPaymentDetails", "savedPaymentDetails", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"sa…dPaymentDetails\", reader)");
                    throw missingProperty2;
                } else if (str2 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"me…d\", \"merchantId\", reader)");
                    throw missingProperty3;
                } else if (str3 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("callBackUrl", "callBackUrl", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"ca…Url\",\n            reader)");
                    throw missingProperty4;
                } else if (str4 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("merchantServerUrl", "merchantServerUrl", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"me…rchantServerUrl\", reader)");
                    throw missingProperty5;
                } else if (str5 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("currency", "currency", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "Util.missingProperty(\"cu…ncy\", \"currency\", reader)");
                    throw missingProperty6;
                } else if (str7 != null) {
                    GopayTransacrionReactPayload gopayTransacrionReactPayload = new GopayTransacrionReactPayload(str, savedPaymentDetail, str2, str3, str4, str5, str7);
                    return gopayTransacrionReactPayload;
                } else {
                    JsonDataException missingProperty7 = Util.missingProperty(RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "Util.missingProperty(\"mo…er\", \"mobNumber\", reader)");
                    throw missingProperty7;
                }
            }
        }
    }

    public void toJson(JsonWriter jsonWriter, GopayTransacrionReactPayload gopayTransacrionReactPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (gopayTransacrionReactPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("amount");
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getAmount());
            jsonWriter.name("savedPaymentDetails");
            this.savedPaymentDetailAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getSavedPaymentDetails());
            jsonWriter.name(PaymentConstants.MERCHANT_ID_CAMEL);
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getMerchantId());
            jsonWriter.name("callBackUrl");
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getCallBackUrl());
            jsonWriter.name("merchantServerUrl");
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getMerchantServerUrl());
            jsonWriter.name("currency");
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getCurrency());
            jsonWriter.name(RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT);
            this.stringAdapter.toJson(jsonWriter, gopayTransacrionReactPayload.getMobNumber());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
