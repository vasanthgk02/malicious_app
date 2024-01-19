package com.mpl.payment.juspayhypersdk.refresh.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletMplPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletMplPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JuspaySingleWalletMplPayloadJsonAdapter.kt */
public final class JuspaySingleWalletMplPayloadJsonAdapter extends JsonAdapter<JuspaySingleWalletMplPayload> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public JuspaySingleWalletMplPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.CLIENT_ID_CAMEL, PaymentConstants.ENV);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"m…Id\",\n      \"environment\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"merchantId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(JuspaySingleWalletMplPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(JuspaySingleWalletMplPayload)";
    }

    public JuspaySingleWalletMplPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
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
                    JsonDataException unexpectedNull = Util.unexpectedNull(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"mer…    \"merchantId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(PaymentConstants.CLIENT_ID_CAMEL, PaymentConstants.CLIENT_ID_CAMEL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"cli…      \"clientId\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName != 2) {
                continue;
            } else {
                str3 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(PaymentConstants.ENV, PaymentConstants.ENV, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"env…\", \"environment\", reader)");
                    throw unexpectedNull3;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(PaymentConstants.MERCHANT_ID_CAMEL, PaymentConstants.MERCHANT_ID_CAMEL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"me…d\", \"merchantId\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(PaymentConstants.CLIENT_ID_CAMEL, PaymentConstants.CLIENT_ID_CAMEL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"cl…tId\", \"clientId\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new JuspaySingleWalletMplPayload(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty(PaymentConstants.ENV, PaymentConstants.ENV, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"en…ent\",\n            reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, JuspaySingleWalletMplPayload juspaySingleWalletMplPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (juspaySingleWalletMplPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name(PaymentConstants.MERCHANT_ID_CAMEL);
            this.stringAdapter.toJson(jsonWriter, juspaySingleWalletMplPayload.getMerchantId());
            jsonWriter.name(PaymentConstants.CLIENT_ID_CAMEL);
            this.stringAdapter.toJson(jsonWriter, juspaySingleWalletMplPayload.getClientId());
            jsonWriter.name(PaymentConstants.ENV);
            this.stringAdapter.toJson(jsonWriter, juspaySingleWalletMplPayload.getEnvironment());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
