package com.mpl.payment.phonepe.models;

import com.mpl.payment.braintree.BraintreeConstants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/phonepe/models/CompleteDepositPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/phonepe/models/CompleteDepositPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "phonePeExtraInfoAdapter", "Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteDepositPayloadJsonAdapter.kt */
public final class CompleteDepositPayloadJsonAdapter extends JsonAdapter<CompleteDepositPayload> {
    public volatile Constructor<CompleteDepositPayload> constructorRef;
    public final Options options;
    public final JsonAdapter<PhonePeExtraInfo> phonePeExtraInfoAdapter;
    public final JsonAdapter<String> stringAdapter;

    public CompleteDepositPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(BraintreeConstants.NS_MPL_ORDER_ID, "plugin", "ticketType", "nonce", BraintreeConstants.NS_EXTRAINFO);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"p…e\", \"nonce\", \"extraInfo\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, BraintreeConstants.NS_MPL_ORDER_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"paymentId\")");
        this.stringAdapter = adapter;
        JsonAdapter<PhonePeExtraInfo> adapter2 = moshi.adapter(PhonePeExtraInfo.class, EmptySet.INSTANCE, BraintreeConstants.NS_EXTRAINFO);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(PhonePeExt… emptySet(), \"extraInfo\")");
        this.phonePeExtraInfoAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(CompleteDepositPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(CompleteDepositPayload)";
    }

    public CompleteDepositPayload fromJson(JsonReader jsonReader) {
        String str;
        long j;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        PhonePeExtraInfo phonePeExtraInfo = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName != 0) {
                if (selectName == 1) {
                    str3 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str3 != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("plugin", "plugin", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"plu…n\",\n              reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 2) {
                    str4 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str4 != null) {
                        j = 4294967291L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("ticketType", "ticketType", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"tic…    \"ticketType\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName == 3) {
                    str5 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str5 != null) {
                        j = 4294967287L;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("nonce", "nonce", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"non…e\",\n              reader)");
                        throw unexpectedNull3;
                    }
                } else if (selectName != 4) {
                    continue;
                } else {
                    phonePeExtraInfo = (PhonePeExtraInfo) this.phonePeExtraInfoAdapter.fromJson(jsonReader2);
                    if (phonePeExtraInfo == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(BraintreeConstants.NS_EXTRAINFO, BraintreeConstants.NS_EXTRAINFO, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"ext…fo\", \"extraInfo\", reader)");
                        throw unexpectedNull4;
                    }
                }
                i &= (int) j;
            } else {
                str2 = (String) this.stringAdapter.fromJson(jsonReader2);
                if (str2 == null) {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull(BraintreeConstants.NS_MPL_ORDER_ID, BraintreeConstants.NS_MPL_ORDER_ID, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"pay…     \"paymentId\", reader)");
                    throw unexpectedNull5;
                }
            }
        }
        jsonReader.endObject();
        if (i != ((int) 4294967281L)) {
            Constructor<CompleteDepositPayload> constructor = this.constructorRef;
            if (constructor != null) {
                str = "Util.missingProperty(\"pa…Id\", \"paymentId\", reader)";
            } else {
                str = "Util.missingProperty(\"pa…Id\", \"paymentId\", reader)";
                constructor = CompleteDepositPayload.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, PhonePeExtraInfo.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "CompleteDepositPayload::…his.constructorRef = it }");
            }
            Object[] objArr = new Object[7];
            if (str2 != null) {
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = str5;
                if (phonePeExtraInfo != null) {
                    objArr[4] = phonePeExtraInfo;
                    objArr[5] = Integer.valueOf(i);
                    objArr[6] = null;
                    CompleteDepositPayload newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty(BraintreeConstants.NS_EXTRAINFO, BraintreeConstants.NS_EXTRAINFO, jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ex…fo\", \"extraInfo\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty(BraintreeConstants.NS_MPL_ORDER_ID, BraintreeConstants.NS_MPL_ORDER_ID, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, str);
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(BraintreeConstants.NS_MPL_ORDER_ID, BraintreeConstants.NS_MPL_ORDER_ID, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"pa…Id\", \"paymentId\", reader)");
            throw missingProperty3;
        } else if (str3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (phonePeExtraInfo != null) {
            CompleteDepositPayload completeDepositPayload = new CompleteDepositPayload(str2, str3, str4, str5, phonePeExtraInfo);
            return completeDepositPayload;
        } else {
            JsonDataException missingProperty4 = Util.missingProperty(BraintreeConstants.NS_EXTRAINFO, BraintreeConstants.NS_EXTRAINFO, jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"ex…fo\", \"extraInfo\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, CompleteDepositPayload completeDepositPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (completeDepositPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name(BraintreeConstants.NS_MPL_ORDER_ID);
            this.stringAdapter.toJson(jsonWriter, completeDepositPayload.getPaymentId());
            jsonWriter.name("plugin");
            this.stringAdapter.toJson(jsonWriter, completeDepositPayload.getPlugin());
            jsonWriter.name("ticketType");
            this.stringAdapter.toJson(jsonWriter, completeDepositPayload.getTicketType());
            jsonWriter.name("nonce");
            this.stringAdapter.toJson(jsonWriter, completeDepositPayload.getNonce());
            jsonWriter.name(BraintreeConstants.NS_EXTRAINFO);
            this.phonePeExtraInfoAdapter.toJson(jsonWriter, completeDepositPayload.getExtraInfo());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
