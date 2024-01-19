package com.mpl.payment.juspayhypersdk.refresh.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import in.juspay.services.HyperServices;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/SingleWalletRefreshRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/refresh/model/SingleWalletRefreshRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "payloadAdapter", "Lcom/mpl/payment/juspayhypersdk/refresh/model/Payload;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SingleWalletRefreshRequestJsonAdapter.kt */
public final class SingleWalletRefreshRequestJsonAdapter extends JsonAdapter<SingleWalletRefreshRequest> {
    public volatile Constructor<SingleWalletRefreshRequest> constructorRef;
    public final Options options;
    public final JsonAdapter<Payload> payloadAdapter;
    public final JsonAdapter<String> stringAdapter;

    public SingleWalletRefreshRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of(HyperServices.REQUEST_ID, "service", "payload");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"r…d\", \"service\", \"payload\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, HyperServices.REQUEST_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…Set(),\n      \"requestId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Payload> adapter2 = moshi.adapter(Payload.class, EmptySet.INSTANCE, "payload");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Payload::c…tySet(),\n      \"payload\")");
        this.payloadAdapter = adapter2;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(SingleWalletRefreshRequest)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(SingleWalletRefreshRequest)";
    }

    public SingleWalletRefreshRequest fromJson(JsonReader jsonReader) {
        long j;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        Payload payload = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    str = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull(HyperServices.REQUEST_ID, HyperServices.REQUEST_ID, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"req…     \"requestId\", reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    str2 = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("service", "service", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"ser…       \"service\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName != 2) {
                    continue;
                } else {
                    payload = (Payload) this.payloadAdapter.fromJson(jsonReader2);
                    if (payload == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("payload", "payload", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"pay…       \"payload\", reader)");
                        throw unexpectedNull3;
                    }
                }
                i &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (i != ((int) 4294967292L)) {
            Constructor<SingleWalletRefreshRequest> constructor = this.constructorRef;
            if (constructor == null) {
                constructor = SingleWalletRefreshRequest.class.getDeclaredConstructor(new Class[]{cls, cls, Payload.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "SingleWalletRefreshReque…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            if (payload != null) {
                objArr[2] = payload;
                objArr[3] = Integer.valueOf(i);
                objArr[4] = null;
                SingleWalletRefreshRequest newInstance = constructor.newInstance(objArr);
                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException missingProperty = Util.missingProperty("payload", "payload", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"payload\", \"payload\", reader)");
            throw missingProperty;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (payload != null) {
            return new SingleWalletRefreshRequest(str, str2, payload);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("payload", "payload", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"payload\", \"payload\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, SingleWalletRefreshRequest singleWalletRefreshRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (singleWalletRefreshRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(HyperServices.REQUEST_ID);
            this.stringAdapter.toJson(jsonWriter, singleWalletRefreshRequest.getRequestId());
            jsonWriter.name("service");
            this.stringAdapter.toJson(jsonWriter, singleWalletRefreshRequest.getService());
            jsonWriter.name("payload");
            this.payloadAdapter.toJson(jsonWriter, singleWalletRefreshRequest.getPayload());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
