package com.midtrans.sdk.gopaycheckout.core.account;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableListOfPaymentOptionAdapter", "", "Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOption;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AccountMetadataJsonAdapter extends JsonAdapter<AccountMetadata> {
    public final JsonAdapter<List<PaymentOption>> nullableListOfPaymentOptionAdapter;
    public final Options options;

    public AccountMetadataJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("payment_options");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"payment_options\")");
        this.options = of;
        JsonAdapter<List<PaymentOption>> adapter = moshi.adapter(Types.newParameterizedType(List.class, PaymentOption.class), EmptySet.INSTANCE, "paymentOptions");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(Types.newP…ySet(), \"paymentOptions\")");
        this.nullableListOfPaymentOptionAdapter = adapter;
    }

    public AccountMetadata fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = (List) this.nullableListOfPaymentOptionAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new AccountMetadata(list);
    }

    public void toJson(JsonWriter jsonWriter, AccountMetadata accountMetadata) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (accountMetadata != null) {
            jsonWriter.beginObject();
            jsonWriter.name("payment_options");
            this.nullableListOfPaymentOptionAdapter.toJson(jsonWriter, accountMetadata.getPaymentOptions());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(AccountMetadata)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(AccountMetadata)";
    }
}
