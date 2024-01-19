package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetailJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableIntAdapter", "", "nullableLongAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class ItemDetailJsonAdapter extends JsonAdapter<ItemDetail> {
    public final JsonAdapter<Integer> nullableIntAdapter;
    public final JsonAdapter<Long> nullableLongAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public ItemDetailJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("id", "name", ECommerceParamNames.PRICE, ECommerceParamNames.QUANTITY, "category");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"i…ntity\",\n      \"category\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "id");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…,\n      emptySet(), \"id\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Long> adapter2 = moshi.adapter(Long.class, EmptySet.INSTANCE, ECommerceParamNames.PRICE);
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Long::clas…     emptySet(), \"price\")");
        this.nullableLongAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.class, EmptySet.INSTANCE, ECommerceParamNames.QUANTITY);
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Int::class…  emptySet(), \"quantity\")");
        this.nullableIntAdapter = adapter3;
    }

    public ItemDetail fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        Long l = null;
        Integer num = null;
        String str3 = null;
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
                l = (Long) this.nullableLongAdapter.fromJson(jsonReader);
            } else if (selectName == 3) {
                num = (Integer) this.nullableIntAdapter.fromJson(jsonReader);
            } else if (selectName == 4) {
                str3 = (String) this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        ItemDetail itemDetail = new ItemDetail(str, str2, l, num, str3);
        return itemDetail;
    }

    public void toJson(JsonWriter jsonWriter, ItemDetail itemDetail) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (itemDetail != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, itemDetail.getId());
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, itemDetail.getName());
            jsonWriter.name(ECommerceParamNames.PRICE);
            this.nullableLongAdapter.toJson(jsonWriter, itemDetail.getPrice());
            jsonWriter.name(ECommerceParamNames.QUANTITY);
            this.nullableIntAdapter.toJson(jsonWriter, itemDetail.getQuantity());
            jsonWriter.name("category");
            this.nullableStringAdapter.toJson(jsonWriter, itemDetail.getCategory());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(ItemDetail)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(ItemDetail)";
    }
}
