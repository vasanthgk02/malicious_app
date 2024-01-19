package com.mpl.payment.juspayhypersdk.amazon.linking.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonCreateWalletResponsePayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonCreateWalletResponsePayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AmazonCreateWalletResponsePayloadJsonAdapter.kt */
public final class AmazonCreateWalletResponsePayloadJsonAdapter extends JsonAdapter<AmazonCreateWalletResponsePayload> {
    public final JsonAdapter<Boolean> booleanAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public AmazonCreateWalletResponsePayloadJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("action", "wallet", "token", "linked", "id", "currentBalance");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…, \"id\", \"currentBalance\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(cls, EmptySet.INSTANCE, "action");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"action\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, EmptySet.INSTANCE, "wallet");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…    emptySet(), \"wallet\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, EmptySet.INSTANCE, "linked");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…ptySet(),\n      \"linked\")");
        this.booleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AmazonCreateWalletResponsePayload");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public AmazonCreateWalletResponsePayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    String str6 = (String) this.stringAdapter.fromJson(jsonReader);
                    if (str6 != null) {
                        str = str6;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("action", "action", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"act…        \"action\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str2 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    Boolean bool2 = (Boolean) this.booleanAdapter.fromJson(jsonReader);
                    if (bool2 != null) {
                        bool = Boolean.valueOf(bool2.booleanValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("linked", "linked", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"lin…        \"linked\", reader)");
                        throw unexpectedNull2;
                    }
                case 4:
                    str4 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str5 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("action", "action", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"action\", \"action\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            AmazonCreateWalletResponsePayload amazonCreateWalletResponsePayload = new AmazonCreateWalletResponsePayload(str, str2, str3, bool.booleanValue(), str4, str5);
            return amazonCreateWalletResponsePayload;
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("linked", "linked", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"linked\", \"linked\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, AmazonCreateWalletResponsePayload amazonCreateWalletResponsePayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (amazonCreateWalletResponsePayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("action");
            this.stringAdapter.toJson(jsonWriter, amazonCreateWalletResponsePayload.getAction());
            jsonWriter.name("wallet");
            this.nullableStringAdapter.toJson(jsonWriter, amazonCreateWalletResponsePayload.getWallet());
            jsonWriter.name("token");
            this.nullableStringAdapter.toJson(jsonWriter, amazonCreateWalletResponsePayload.getToken());
            jsonWriter.name("linked");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(amazonCreateWalletResponsePayload.getLinked()));
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, amazonCreateWalletResponsePayload.getId());
            jsonWriter.name("currentBalance");
            this.nullableStringAdapter.toJson(jsonWriter, amazonCreateWalletResponsePayload.getCurrentBalance());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
