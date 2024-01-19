package com.midtrans.sdk.gopaycheckout.core.account;

import com.facebook.react.modules.appstate.AppStateModule;
import com.mpl.androidapp.utils.Constant;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOptionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOption;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableAmountAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/account/Amount;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class PaymentOptionJsonAdapter extends JsonAdapter<PaymentOption> {
    public final JsonAdapter<Amount> nullableAmountAdapter;
    public final JsonAdapter<Boolean> nullableBooleanAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public PaymentOptionJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("name", AppStateModule.APP_STATE_ACTIVE, "token", Constant.USER_BALANCE);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"n…\"token\",\n      \"balance\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "name");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.class, EmptySet.INSTANCE, AppStateModule.APP_STATE_ACTIVE);
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Boolean::c…pe, emptySet(), \"active\")");
        this.nullableBooleanAdapter = adapter2;
        JsonAdapter<Amount> adapter3 = moshi.adapter(Amount.class, EmptySet.INSTANCE, Constant.USER_BALANCE);
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Amount::cl…   emptySet(), \"balance\")");
        this.nullableAmountAdapter = adapter3;
    }

    public PaymentOption fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Boolean bool = null;
        String str2 = null;
        Amount amount = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                bool = (Boolean) this.nullableBooleanAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str2 = (String) this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                amount = (Amount) this.nullableAmountAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PaymentOption(str, bool, str2, amount);
    }

    public void toJson(JsonWriter jsonWriter, PaymentOption paymentOption) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (paymentOption != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, paymentOption.getName());
            jsonWriter.name(AppStateModule.APP_STATE_ACTIVE);
            this.nullableBooleanAdapter.toJson(jsonWriter, paymentOption.getActive());
            jsonWriter.name("token");
            this.nullableStringAdapter.toJson(jsonWriter, paymentOption.getToken());
            jsonWriter.name(Constant.USER_BALANCE);
            this.nullableAmountAdapter.toJson(jsonWriter, paymentOption.getBalance());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(PaymentOption)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(PaymentOption)";
    }
}
