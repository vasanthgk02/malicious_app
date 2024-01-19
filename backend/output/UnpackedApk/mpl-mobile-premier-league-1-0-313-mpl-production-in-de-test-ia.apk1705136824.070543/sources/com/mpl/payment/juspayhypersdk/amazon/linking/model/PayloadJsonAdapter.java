package com.mpl.payment.juspayhypersdk.amazon.linking.model;

import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/PayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/Payload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PayloadJsonAdapter.kt */
public final class PayloadJsonAdapter extends JsonAdapter<Payload> {
    public final JsonAdapter<Boolean> booleanAdapter;
    public volatile Constructor<Payload> constructorRef;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public PayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("action", "walletName", RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, "sdkWalletIdentifier", "showLoader");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…dentifier\", \"showLoader\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "action");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"action\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, EmptySet.INSTANCE, "showLoader");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…et(),\n      \"showLoader\")");
        this.booleanAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(Payload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(Payload)";
    }

    public Payload fromJson(JsonReader jsonReader) {
        long j;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Boolean bool = Boolean.FALSE;
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    str = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("action", "action", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"act…n\",\n              reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    str2 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("walletName", "walletName", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"wal…    \"walletName\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName == 2) {
                    str3 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"cli…clientAuthToken\", reader)");
                        throw unexpectedNull3;
                    }
                } else if (selectName == 3) {
                    str4 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("sdkWalletIdentifier", "sdkWalletIdentifier", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"sdk…alletIdentifier\", reader)");
                        throw unexpectedNull4;
                    }
                } else if (selectName != 4) {
                    continue;
                } else {
                    Boolean bool2 = (Boolean) this.booleanAdapter.fromJson(jsonReader2);
                    if (bool2 != null) {
                        bool = Boolean.valueOf(bool2.booleanValue());
                        j = 4294967279L;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("showLoader", "showLoader", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"sho…    \"showLoader\", reader)");
                        throw unexpectedNull5;
                    }
                }
                i &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (i != ((int) 4294967276L)) {
            Constructor<Payload> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = Payload.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, Boolean.TYPE, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "Payload::class.java.getD…his.constructorRef = it }");
            }
            Object[] objArr = new Object[7];
            objArr[0] = str;
            objArr[1] = str2;
            if (str3 != null) {
                objArr[2] = str3;
                if (str4 != null) {
                    objArr[3] = str4;
                    objArr[4] = bool;
                    objArr[5] = Integer.valueOf(i);
                    objArr[6] = null;
                    Payload newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("sdkWalletIdentifier", "sdkWalletIdentifier", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"sd…alletIdentifier\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"cl…n\",\n              reader)");
            throw missingProperty2;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"cl…clientAuthToken\", reader)");
            throw missingProperty3;
        } else if (str4 != null) {
            Payload payload = new Payload(str, str2, str3, str4, bool.booleanValue());
            return payload;
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("sdkWalletIdentifier", "sdkWalletIdentifier", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"sd…alletIdentifier\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, Payload payload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (payload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("action");
            this.stringAdapter.toJson(jsonWriter, payload.getAction());
            jsonWriter.name("walletName");
            this.stringAdapter.toJson(jsonWriter, payload.getWalletName());
            jsonWriter.name(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
            this.stringAdapter.toJson(jsonWriter, payload.getClientAuthToken());
            jsonWriter.name("sdkWalletIdentifier");
            this.stringAdapter.toJson(jsonWriter, payload.getSdkWalletIdentifier());
            jsonWriter.name("showLoader");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(payload.getShowLoader()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
