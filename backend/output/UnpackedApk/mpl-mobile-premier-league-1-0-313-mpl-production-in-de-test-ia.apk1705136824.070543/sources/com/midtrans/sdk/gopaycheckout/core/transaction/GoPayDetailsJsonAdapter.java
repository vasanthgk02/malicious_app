package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetailsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayDetailsJsonAdapter extends JsonAdapter<GoPayDetails> {
    public volatile Constructor<GoPayDetails> constructorRef;
    public final JsonAdapter<Boolean> nullableBooleanAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public GoPayDetailsJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("account_id", "payment_option_token", "callback_url", "enable_callback");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"a…_url\", \"enable_callback\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "accountId");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl… emptySet(), \"accountId\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, EmptySet.INSTANCE, "enableCallback");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Boolean::c…ySet(), \"enableCallback\")");
        this.nullableBooleanAdapter = adapter2;
    }

    public GoPayDetails fromJson(JsonReader jsonReader) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        Boolean bool = null;
        int i = -1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                str2 = (String) this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str3 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                i &= (int) 4294967291L;
            } else if (selectName == 3) {
                bool = (Boolean) this.nullableBooleanAdapter.fromJson(jsonReader);
                z = true;
            }
        }
        jsonReader.endObject();
        Constructor<GoPayDetails> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = GoPayDetails.class.getDeclaredConstructor(new Class[]{cls, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "GoPayDetails::class.java…his.constructorRef = it }");
        }
        GoPayDetails newInstance = constructor.newInstance(new Object[]{str, str2, str3, Integer.valueOf(i), null});
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        GoPayDetails goPayDetails = newInstance;
        if (!z) {
            bool = goPayDetails.getEnableCallback();
        }
        goPayDetails.setEnableCallback(bool);
        return goPayDetails;
    }

    public void toJson(JsonWriter jsonWriter, GoPayDetails goPayDetails) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (goPayDetails != null) {
            jsonWriter.beginObject();
            jsonWriter.name("account_id");
            this.nullableStringAdapter.toJson(jsonWriter, goPayDetails.getAccountId());
            jsonWriter.name("payment_option_token");
            this.nullableStringAdapter.toJson(jsonWriter, goPayDetails.getPaymentOptionToken());
            jsonWriter.name("callback_url");
            this.nullableStringAdapter.toJson(jsonWriter, goPayDetails.getCallbackUrl());
            jsonWriter.name("enable_callback");
            this.nullableBooleanAdapter.toJson(jsonWriter, goPayDetails.getEnableCallback());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(GoPayDetails)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(GoPayDetails)";
    }
}
