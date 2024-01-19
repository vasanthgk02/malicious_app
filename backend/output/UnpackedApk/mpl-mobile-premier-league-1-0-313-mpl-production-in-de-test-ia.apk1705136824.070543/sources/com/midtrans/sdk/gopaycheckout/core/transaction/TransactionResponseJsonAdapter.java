package com.midtrans.sdk.gopaycheckout.core.transaction;

import androidx.core.app.NotificationCompat.WearableExtender;
import com.midtrans.sdk.gopaycheckout.core.PendingAction;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableListOfPendingActionAdapter", "", "Lcom/midtrans/sdk/gopaycheckout/core/PendingAction;", "nullableListOfStringAdapter", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionResponseJsonAdapter extends JsonAdapter<TransactionResponse> {
    public final JsonAdapter<List<PendingAction>> nullableListOfPendingActionAdapter;
    public final JsonAdapter<List<String>> nullableListOfStringAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public TransactionResponseJsonAdapter(Moshi moshi) {
        Moshi moshi2 = moshi;
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi2, "moshi");
        Options of = Options.of("status_code", "status_message", "id", "validation_messages", "channel_response_code", "channel_response_message", "order_id", PaymentConstants.TRANSACTION_ID, "gross_amount", "currency", "payment_type", "transaction_time", "transaction_status", "fraud_status", WearableExtender.KEY_ACTIONS);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"s…fraud_status\", \"actions\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi2.adapter(cls, EmptySet.INSTANCE, "statusCode");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…emptySet(), \"statusCode\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi2.adapter(Types.newParameterizedType(List.class, cls), EmptySet.INSTANCE, "validationMessages");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Types.newP…    \"validationMessages\")");
        this.nullableListOfStringAdapter = adapter2;
        JsonAdapter<List<PendingAction>> adapter3 = moshi2.adapter(Types.newParameterizedType(List.class, PendingAction.class), EmptySet.INSTANCE, WearableExtender.KEY_ACTIONS);
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.nullableListOfPendingActionAdapter = adapter3;
    }

    public TransactionResponse fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkParameterIsNotNull(jsonReader2, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        List list = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        List list2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 1:
                    str2 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 2:
                    str3 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 3:
                    list = (List) this.nullableListOfStringAdapter.fromJson(jsonReader2);
                    break;
                case 4:
                    str4 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 5:
                    str5 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 6:
                    str6 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 7:
                    str7 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 8:
                    str8 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 9:
                    str9 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 10:
                    str10 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 11:
                    str11 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 12:
                    str12 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 13:
                    str13 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    break;
                case 14:
                    list2 = (List) this.nullableListOfPendingActionAdapter.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.endObject();
        TransactionResponse transactionResponse = new TransactionResponse(str, str2, str3, list, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, list2);
        return transactionResponse;
    }

    public void toJson(JsonWriter jsonWriter, TransactionResponse transactionResponse) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (transactionResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("status_code");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getStatusCode());
            jsonWriter.name("status_message");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getStatusMessage());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getId());
            jsonWriter.name("validation_messages");
            this.nullableListOfStringAdapter.toJson(jsonWriter, transactionResponse.getValidationMessages());
            jsonWriter.name("channel_response_code");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getChannelResponseCode());
            jsonWriter.name("channel_response_message");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getChannelResponseMessage());
            jsonWriter.name("order_id");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getOrderId());
            jsonWriter.name(PaymentConstants.TRANSACTION_ID);
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getTransactionId());
            jsonWriter.name("gross_amount");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getGrossAmount());
            jsonWriter.name("currency");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getCurrency());
            jsonWriter.name("payment_type");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getPaymentType());
            jsonWriter.name("transaction_time");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getTransactionTime());
            jsonWriter.name("transaction_status");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getTransactionStatus());
            jsonWriter.name("fraud_status");
            this.nullableStringAdapter.toJson(jsonWriter, transactionResponse.getFraudStatus());
            jsonWriter.name(WearableExtender.KEY_ACTIONS);
            this.nullableListOfPendingActionAdapter.toJson(jsonWriter, transactionResponse.getActions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(TransactionResponse)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(TransactionResponse)";
    }
}
