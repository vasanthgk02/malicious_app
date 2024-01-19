package com.mpl.payment.gopay.models;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayLinkingPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/gopay/models/GoPayLinkingPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayLinkingPayloadJsonAdapter.kt */
public final class GoPayLinkingPayloadJsonAdapter extends JsonAdapter<GoPayLinkingPayload> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public GoPayLinkingPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(PaymentConstants.MERCHANT_ID_CAMEL, "callBackUrl", "merchantServerUrl", "phoneNoToLink", "countryCode");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"m…NoToLink\", \"countryCode\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"merchantId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(GoPayLinkingPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(GoPayLinkingPayload)";
    }

    public GoPayLinkingPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                String str6 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str6 != null) {
                    str = str6;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"mer…    \"merchantId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                String str7 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str7 != null) {
                    str2 = str7;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("callBackUrl", "callBackUrl", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"cal…\", \"callBackUrl\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                String str8 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str8 != null) {
                    str3 = str8;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("merchantServerUrl", "merchantServerUrl", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"mer…rchantServerUrl\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                String str9 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str9 != null) {
                    str4 = str9;
                } else {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("phoneNoToLink", "phoneNoToLink", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"pho… \"phoneNoToLink\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName != 4) {
                continue;
            } else {
                String str10 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str10 != null) {
                    str5 = str10;
                } else {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull("countryCode", "countryCode", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"cou…\", \"countryCode\", reader)");
                    throw unexpectedNull5;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"me…d\", \"merchantId\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("callBackUrl", "callBackUrl", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"ca…Url\",\n            reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("merchantServerUrl", "merchantServerUrl", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"me…rchantServerUrl\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("phoneNoToLink", "phoneNoToLink", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"ph… \"phoneNoToLink\", reader)");
            throw missingProperty4;
        } else if (str5 != null) {
            GoPayLinkingPayload goPayLinkingPayload = new GoPayLinkingPayload(str, str2, str3, str4, str5);
            return goPayLinkingPayload;
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("countryCode", "countryCode", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"co…ode\",\n            reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, GoPayLinkingPayload goPayLinkingPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (goPayLinkingPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PaymentConstants.MERCHANT_ID_CAMEL);
            this.stringAdapter.toJson(jsonWriter, goPayLinkingPayload.getMerchantId());
            jsonWriter.name("callBackUrl");
            this.stringAdapter.toJson(jsonWriter, goPayLinkingPayload.getCallBackUrl());
            jsonWriter.name("merchantServerUrl");
            this.stringAdapter.toJson(jsonWriter, goPayLinkingPayload.getMerchantServerUrl());
            jsonWriter.name("phoneNoToLink");
            this.stringAdapter.toJson(jsonWriter, goPayLinkingPayload.getPhoneNoToLink());
            jsonWriter.name("countryCode");
            this.stringAdapter.toJson(jsonWriter, goPayLinkingPayload.getCountryCode());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
