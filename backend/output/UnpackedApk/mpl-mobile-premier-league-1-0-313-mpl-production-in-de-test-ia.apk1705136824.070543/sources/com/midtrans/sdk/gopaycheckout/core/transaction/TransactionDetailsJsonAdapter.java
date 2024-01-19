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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetailsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableLongAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionDetailsJsonAdapter extends JsonAdapter<TransactionDetails> {
    public volatile Constructor<TransactionDetails> constructorRef;
    public final JsonAdapter<Long> nullableLongAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public TransactionDetailsJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("order_id", "gross_amount", "currency");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"o…mount\",\n      \"currency\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "orderId");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…   emptySet(), \"orderId\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Long> adapter2 = moshi.adapter(Long.class, EmptySet.INSTANCE, "amount");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Long::clas…    emptySet(), \"amount\")");
        this.nullableLongAdapter = adapter2;
    }

    public TransactionDetails fromJson(JsonReader jsonReader) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        Long l = null;
        String str2 = null;
        int i = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                l = (Long) this.nullableLongAdapter.fromJson(jsonReader);
            } else if (selectName == 2) {
                str2 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                i &= (int) 4294967291L;
            }
        }
        jsonReader.endObject();
        Constructor<TransactionDetails> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = TransactionDetails.class.getDeclaredConstructor(new Class[]{cls, Long.class, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "TransactionDetails::clas…his.constructorRef = it }");
        }
        TransactionDetails newInstance = constructor.newInstance(new Object[]{str, l, str2, Integer.valueOf(i), null});
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, TransactionDetails transactionDetails) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (transactionDetails != null) {
            jsonWriter.beginObject();
            jsonWriter.name("order_id");
            this.nullableStringAdapter.toJson(jsonWriter, transactionDetails.getOrderId());
            jsonWriter.name("gross_amount");
            this.nullableLongAdapter.toJson(jsonWriter, transactionDetails.getAmount());
            jsonWriter.name("currency");
            this.nullableStringAdapter.toJson(jsonWriter, transactionDetails.getCurrency());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(TransactionDetails)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(TransactionDetails)";
    }
}
