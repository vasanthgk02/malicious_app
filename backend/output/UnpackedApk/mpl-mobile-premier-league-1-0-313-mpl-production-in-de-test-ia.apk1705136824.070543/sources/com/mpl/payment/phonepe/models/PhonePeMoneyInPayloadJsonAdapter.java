package com.mpl.payment.phonepe.models;

import com.netcore.android.notification.SMTNotificationConstants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeMoneyInPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/phonepe/models/PhonePeMoneyInPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeMoneyInPayloadJsonAdapter.kt */
public final class PhonePeMoneyInPayloadJsonAdapter extends JsonAdapter<PhonePeMoneyInPayload> {
    public volatile Constructor<PhonePeMoneyInPayload> constructorRef;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public PhonePeMoneyInPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("orderId", SMTNotificationConstants.NOTIF_DEEPLINK_KEY, "responseType");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"o…k\",\n      \"responseType\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "orderId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…tySet(),\n      \"orderId\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(PhonePeMoneyInPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(PhonePeMoneyInPayload)";
    }

    public PhonePeMoneyInPayload fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("orderId", "orderId", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"ord…       \"orderId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader2);
                if (str2 != null) {
                    i &= (int) 4294967293L;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(SMTNotificationConstants.NOTIF_DEEPLINK_KEY, SMTNotificationConstants.NOTIF_DEEPLINK_KEY, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"dee…      \"deeplink\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName != 2) {
                continue;
            } else {
                str3 = (String) this.stringAdapter.fromJson(jsonReader2);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("responseType", "responseType", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"res…, \"responseType\", reader)");
                    throw unexpectedNull3;
                }
            }
        }
        jsonReader.endObject();
        if (i != ((int) 4294967293L)) {
            Constructor<PhonePeMoneyInPayload> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = PhonePeMoneyInPayload.class.getDeclaredConstructor(new Class[]{cls, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "PhonePeMoneyInPayload::c…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = str2;
                if (str3 != null) {
                    objArr[2] = str3;
                    objArr[3] = Integer.valueOf(i);
                    objArr[4] = null;
                    PhonePeMoneyInPayload newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("responseType", "responseType", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"re…, \"responseType\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("orderId", "orderId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"orderId\", \"orderId\", reader)");
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("orderId", "orderId", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"orderId\", \"orderId\", reader)");
            throw missingProperty3;
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str3 != null) {
            return new PhonePeMoneyInPayload(str, str2, str3);
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("responseType", "responseType", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"re…e\",\n              reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, PhonePeMoneyInPayload phonePeMoneyInPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (phonePeMoneyInPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("orderId");
            this.stringAdapter.toJson(jsonWriter, phonePeMoneyInPayload.getOrderId());
            jsonWriter.name(SMTNotificationConstants.NOTIF_DEEPLINK_KEY);
            this.stringAdapter.toJson(jsonWriter, phonePeMoneyInPayload.getDeeplink());
            jsonWriter.name("responseType");
            this.stringAdapter.toJson(jsonWriter, phonePeMoneyInPayload.getResponseType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
