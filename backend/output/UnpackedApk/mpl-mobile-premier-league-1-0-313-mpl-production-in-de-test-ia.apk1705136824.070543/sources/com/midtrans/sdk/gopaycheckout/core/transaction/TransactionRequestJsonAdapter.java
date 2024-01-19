package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableCustomerDetailsAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;", "nullableGoPayDetailsAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "nullableListOfItemDetailAdapter", "", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "nullableMapOfStringStringAdapter", "", "", "nullableTransactionDetailsAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionRequestJsonAdapter extends JsonAdapter<TransactionRequest> {
    public volatile Constructor<TransactionRequest> constructorRef;
    public final JsonAdapter<CustomerDetails> nullableCustomerDetailsAdapter;
    public final JsonAdapter<GoPayDetails> nullableGoPayDetailsAdapter;
    public final JsonAdapter<List<ItemDetail>> nullableListOfItemDetailAdapter;
    public final JsonAdapter<Map<String, String>> nullableMapOfStringStringAdapter;
    public final JsonAdapter<TransactionDetails> nullableTransactionDetailsAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public TransactionRequestJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("payment_type", "gopay", "transaction_details", "customer_details", "item_details", LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"p…tem_details\", \"metadata\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(cls, EmptySet.INSTANCE, "paymentType");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…t(),\n      \"paymentType\")");
        this.stringAdapter = adapter;
        JsonAdapter<GoPayDetails> adapter2 = moshi.adapter(GoPayDetails.class, EmptySet.INSTANCE, "gopay");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(GoPayDetai…ava, emptySet(), \"gopay\")");
        this.nullableGoPayDetailsAdapter = adapter2;
        JsonAdapter<TransactionDetails> adapter3 = moshi.adapter(TransactionDetails.class, EmptySet.INSTANCE, "transactionDetails");
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Transactio…(), \"transactionDetails\")");
        this.nullableTransactionDetailsAdapter = adapter3;
        JsonAdapter<CustomerDetails> adapter4 = moshi.adapter(CustomerDetails.class, EmptySet.INSTANCE, "customerDetails");
        Intrinsics.checkExpressionValueIsNotNull(adapter4, "moshi.adapter(CustomerDe…Set(), \"customerDetails\")");
        this.nullableCustomerDetailsAdapter = adapter4;
        JsonAdapter<List<ItemDetail>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, ItemDetail.class), EmptySet.INSTANCE, "itemDetails");
        Intrinsics.checkExpressionValueIsNotNull(adapter5, "moshi.adapter(Types.newP…mptySet(), \"itemDetails\")");
        this.nullableListOfItemDetailAdapter = adapter5;
        JsonAdapter<Map<String, String>> adapter6 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), EmptySet.INSTANCE, LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(adapter6, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringStringAdapter = adapter6;
    }

    public TransactionRequest fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkParameterIsNotNull(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        GoPayDetails goPayDetails = null;
        TransactionDetails transactionDetails = null;
        CustomerDetails customerDetails = null;
        List list = null;
        Map map = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = (String) this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        i &= (int) 4294967294L;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("paymentType", "payment_type", jsonReader2);
                        Intrinsics.checkExpressionValueIsNotNull(unexpectedNull, "Util.unexpectedNull(\"pay…  \"payment_type\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    goPayDetails = (GoPayDetails) this.nullableGoPayDetailsAdapter.fromJson(jsonReader2);
                    break;
                case 2:
                    transactionDetails = (TransactionDetails) this.nullableTransactionDetailsAdapter.fromJson(jsonReader2);
                    break;
                case 3:
                    customerDetails = (CustomerDetails) this.nullableCustomerDetailsAdapter.fromJson(jsonReader2);
                    break;
                case 4:
                    list = (List) this.nullableListOfItemDetailAdapter.fromJson(jsonReader2);
                    break;
                case 5:
                    map = (Map) this.nullableMapOfStringStringAdapter.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.endObject();
        Constructor<TransactionRequest> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = TransactionRequest.class.getDeclaredConstructor(new Class[]{String.class, GoPayDetails.class, TransactionDetails.class, CustomerDetails.class, List.class, Map.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "TransactionRequest::clas…his.constructorRef = it }");
        }
        TransactionRequest newInstance = constructor.newInstance(new Object[]{str, goPayDetails, transactionDetails, customerDetails, list, map, Integer.valueOf(i), null});
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, TransactionRequest transactionRequest) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (transactionRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name("payment_type");
            this.stringAdapter.toJson(jsonWriter, transactionRequest.getPaymentType());
            jsonWriter.name("gopay");
            this.nullableGoPayDetailsAdapter.toJson(jsonWriter, transactionRequest.getGopay());
            jsonWriter.name("transaction_details");
            this.nullableTransactionDetailsAdapter.toJson(jsonWriter, transactionRequest.getTransactionDetails());
            jsonWriter.name("customer_details");
            this.nullableCustomerDetailsAdapter.toJson(jsonWriter, transactionRequest.getCustomerDetails());
            jsonWriter.name("item_details");
            this.nullableListOfItemDetailAdapter.toJson(jsonWriter, transactionRequest.getItemDetails());
            jsonWriter.name(LiveVideoBroadcaster.METADATA);
            this.nullableMapOfStringStringAdapter.toJson(jsonWriter, transactionRequest.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(TransactionRequest)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(TransactionRequest)";
    }
}
