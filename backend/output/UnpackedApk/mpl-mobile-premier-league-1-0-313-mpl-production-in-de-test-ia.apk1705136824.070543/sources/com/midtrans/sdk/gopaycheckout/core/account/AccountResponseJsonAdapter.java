package com.midtrans.sdk.gopaycheckout.core.account;

import androidx.core.app.NotificationCompat.WearableExtender;
import com.midtrans.sdk.gopaycheckout.core.PendingAction;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableAccountMetadataAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;", "nullableListOfPendingActionAdapter", "", "Lcom/midtrans/sdk/gopaycheckout/core/PendingAction;", "nullableListOfStringAdapter", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AccountResponseJsonAdapter extends JsonAdapter<AccountResponse> {
    public final JsonAdapter<AccountMetadata> nullableAccountMetadataAdapter;
    public final JsonAdapter<List<PendingAction>> nullableListOfPendingActionAdapter;
    public final JsonAdapter<List<String>> nullableListOfStringAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public AccountResponseJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("status_code", "status_message", "id", "validation_messages", "channel_response_code", "channel_response_message", "payment_type", "account_id", "account_status", WearableExtender.KEY_ACTIONS, LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"s…\", \"actions\", \"metadata\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(cls, EmptySet.INSTANCE, "statusCode");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…emptySet(), \"statusCode\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, cls), EmptySet.INSTANCE, "validationMessages");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Types.newP…    \"validationMessages\")");
        this.nullableListOfStringAdapter = adapter2;
        JsonAdapter<List<PendingAction>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, PendingAction.class), EmptySet.INSTANCE, WearableExtender.KEY_ACTIONS);
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Types.newP…   emptySet(), \"actions\")");
        this.nullableListOfPendingActionAdapter = adapter3;
        JsonAdapter<AccountMetadata> adapter4 = moshi.adapter(AccountMetadata.class, EmptySet.INSTANCE, LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(adapter4, "moshi.adapter(AccountMet…, emptySet(), \"metadata\")");
        this.nullableAccountMetadataAdapter = adapter4;
    }

    public AccountResponse fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
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
        List list2 = null;
        AccountMetadata accountMetadata = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    list = (List) this.nullableListOfStringAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    str4 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    str5 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 6:
                    str6 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 7:
                    str7 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 8:
                    str8 = (String) this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 9:
                    list2 = (List) this.nullableListOfPendingActionAdapter.fromJson(jsonReader);
                    break;
                case 10:
                    accountMetadata = (AccountMetadata) this.nullableAccountMetadataAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        AccountResponse accountResponse = new AccountResponse(str, str2, str3, list, str4, str5, str6, str7, str8, list2, accountMetadata);
        return accountResponse;
    }

    public void toJson(JsonWriter jsonWriter, AccountResponse accountResponse) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (accountResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("status_code");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getStatusCode());
            jsonWriter.name("status_message");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getStatusMessage());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getId());
            jsonWriter.name("validation_messages");
            this.nullableListOfStringAdapter.toJson(jsonWriter, accountResponse.getValidationMessages());
            jsonWriter.name("channel_response_code");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getChannelResponseCode());
            jsonWriter.name("channel_response_message");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getChannelResponseMessage());
            jsonWriter.name("payment_type");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getPaymentType());
            jsonWriter.name("account_id");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getAccountId());
            jsonWriter.name("account_status");
            this.nullableStringAdapter.toJson(jsonWriter, accountResponse.getAccountStatus());
            jsonWriter.name(WearableExtender.KEY_ACTIONS);
            this.nullableListOfPendingActionAdapter.toJson(jsonWriter, accountResponse.getActions());
            jsonWriter.name(LiveVideoBroadcaster.METADATA);
            this.nullableAccountMetadataAdapter.toJson(jsonWriter, accountResponse.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(AccountResponse)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(AccountResponse)";
    }
}
