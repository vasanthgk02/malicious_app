package com.midtrans.sdk.gopaycheckout.core.account;

import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetailsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayPartnerDetailsJsonAdapter extends JsonAdapter<GoPayPartnerDetails> {
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public GoPayPartnerDetailsJsonAdapter(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("phone_number", "country_code", "redirect_url");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"p…e\",\n      \"redirect_url\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER);
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…mptySet(), \"phoneNumber\")");
        this.nullableStringAdapter = adapter;
    }

    public GoPayPartnerDetails fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
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
                z = true;
            }
        }
        jsonReader.endObject();
        GoPayPartnerDetails goPayPartnerDetails = new GoPayPartnerDetails(str, str2);
        if (!z) {
            str3 = goPayPartnerDetails.getRedirectUrl();
        }
        goPayPartnerDetails.setRedirectUrl(str3);
        return goPayPartnerDetails;
    }

    public void toJson(JsonWriter jsonWriter, GoPayPartnerDetails goPayPartnerDetails) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (goPayPartnerDetails != null) {
            jsonWriter.beginObject();
            jsonWriter.name("phone_number");
            this.nullableStringAdapter.toJson(jsonWriter, goPayPartnerDetails.getPhoneNumber());
            jsonWriter.name("country_code");
            this.nullableStringAdapter.toJson(jsonWriter, goPayPartnerDetails.getCountryCode());
            jsonWriter.name("redirect_url");
            this.nullableStringAdapter.toJson(jsonWriter, goPayPartnerDetails.getRedirectUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(GoPayPartnerDetails)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(GoPayPartnerDetails)";
    }
}
