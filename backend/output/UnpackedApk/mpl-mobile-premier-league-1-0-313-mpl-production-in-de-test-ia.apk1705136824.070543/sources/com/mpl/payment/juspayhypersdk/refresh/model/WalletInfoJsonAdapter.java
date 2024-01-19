package com.mpl.payment.juspayhypersdk.refresh.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/WalletInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/refresh/model/WalletInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: WalletInfoJsonAdapter.kt */
public final class WalletInfoJsonAdapter extends JsonAdapter<WalletInfo> {
    public final JsonAdapter<Boolean> booleanAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public WalletInfoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("token", "linked", "id", "currentBalance");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"t…,\n      \"currentBalance\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "token");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"token\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, EmptySet.INSTANCE, "linked");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…ptySet(),\n      \"linked\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(WalletInfo)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(WalletInfo)";
    }

    public WalletInfo fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Boolean bool = null;
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("token", "token", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"tok…ken\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                Boolean bool2 = (Boolean) this.booleanAdapter.fromJson(jsonReader);
                if (bool2 != null) {
                    bool = Boolean.valueOf(bool2.booleanValue());
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("linked", "linked", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"lin…        \"linked\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName != 3) {
                continue;
            } else {
                str3 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("currentBalance", "currentBalance", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"cur…\"currentBalance\", reader)");
                    throw unexpectedNull4;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("token", "token", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"token\", \"token\", reader)");
            throw missingProperty;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (str2 == null) {
                JsonDataException missingProperty2 = Util.missingProperty("id", "id", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"id\", \"id\", reader)");
                throw missingProperty2;
            } else if (str3 != null) {
                return new WalletInfo(str, booleanValue, str2, str3);
            } else {
                JsonDataException missingProperty3 = Util.missingProperty("currentBalance", "currentBalance", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"cu…\"currentBalance\", reader)");
                throw missingProperty3;
            }
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("linked", "linked", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"linked\", \"linked\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, WalletInfo walletInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (walletInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("token");
            this.stringAdapter.toJson(jsonWriter, walletInfo.getToken());
            jsonWriter.name("linked");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(walletInfo.getLinked()));
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, walletInfo.getId());
            jsonWriter.name("currentBalance");
            this.stringAdapter.toJson(jsonWriter, walletInfo.getCurrentBalance());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
