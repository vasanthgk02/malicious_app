package com.mpl.payment.cardverification.models;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/cardverification/models/ChargeCardPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/cardverification/models/ChargeCardPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "paymentMethodInfoAdapter", "Lcom/mpl/payment/cardverification/models/PaymentMethodInfo;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChargeCardPayloadJsonAdapter.kt */
public final class ChargeCardPayloadJsonAdapter extends JsonAdapter<ChargeCardPayload> {
    public volatile Constructor<ChargeCardPayload> constructorRef;
    public final Options options;
    public final JsonAdapter<PaymentMethodInfo> paymentMethodInfoAdapter;
    public final JsonAdapter<String> stringAdapter;

    public ChargeCardPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("paymentMethod", "paymentMethodInfo", "paymentType", "linkStage");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"p…aymentType\", \"linkStage\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "paymentMethod");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…),\n      \"paymentMethod\")");
        this.stringAdapter = adapter;
        JsonAdapter<PaymentMethodInfo> adapter2 = moshi.adapter(PaymentMethodInfo.class, EmptySet.INSTANCE, "paymentMethodInfo");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(PaymentMet…t(), \"paymentMethodInfo\")");
        this.paymentMethodInfoAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(ChargeCardPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(ChargeCardPayload)";
    }

    public ChargeCardPayload fromJson(JsonReader jsonReader) {
        long j;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        PaymentMethodInfo paymentMethodInfo = null;
        String str2 = null;
        String str3 = null;
        int i = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    str = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("paymentMethod", "paymentMethod", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"pay… \"paymentMethod\", reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    paymentMethodInfo = (PaymentMethodInfo) this.paymentMethodInfoAdapter.fromJson(jsonReader2);
                    if (paymentMethodInfo == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("paymentMethodInfo", "paymentMethodInfo", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"pay…ymentMethodInfo\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName == 2) {
                    str2 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        j = 4294967291L;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("paymentType", "paymentType", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"pay…   \"paymentType\", reader)");
                        throw unexpectedNull3;
                    }
                } else if (selectName != 3) {
                    continue;
                } else {
                    str3 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        j = 4294967287L;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("linkStage", "linkStage", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"lin…     \"linkStage\", reader)");
                        throw unexpectedNull4;
                    }
                }
                i &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (i != ((int) 4294967282L)) {
            Constructor<ChargeCardPayload> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = ChargeCardPayload.class.getDeclaredConstructor(new Class[]{cls, PaymentMethodInfo.class, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "ChargeCardPayload::class…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            objArr[0] = str;
            if (paymentMethodInfo != null) {
                objArr[1] = paymentMethodInfo;
                objArr[2] = str2;
                objArr[3] = str3;
                objArr[4] = Integer.valueOf(i);
                objArr[5] = null;
                ChargeCardPayload newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("paymentMethodInfo", "paymentMethodInfo", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"pa…o\",\n              reader)");
            throw missingProperty;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (paymentMethodInfo == null) {
            JsonDataException missingProperty2 = Util.missingProperty("paymentMethodInfo", "paymentMethodInfo", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"pa…ymentMethodInfo\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str3 != null) {
            return new ChargeCardPayload(str, paymentMethodInfo, str2, str3);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public void toJson(JsonWriter jsonWriter, ChargeCardPayload chargeCardPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (chargeCardPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("paymentMethod");
            this.stringAdapter.toJson(jsonWriter, chargeCardPayload.getPaymentMethod());
            jsonWriter.name("paymentMethodInfo");
            this.paymentMethodInfoAdapter.toJson(jsonWriter, chargeCardPayload.getPaymentMethodInfo());
            jsonWriter.name("paymentType");
            this.stringAdapter.toJson(jsonWriter, chargeCardPayload.getPaymentType());
            jsonWriter.name("linkStage");
            this.stringAdapter.toJson(jsonWriter, chargeCardPayload.getLinkStage());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
