package com.mpl.payment.phonepe.models;

import com.mpl.androidapp.utils.Constant;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/phonepe/models/PhonePeExtraInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePeExtraInfoJsonAdapter.kt */
public final class PhonePeExtraInfoJsonAdapter extends JsonAdapter<PhonePeExtraInfo> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public PhonePeExtraInfoJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("userAuthToken", Constant.HEADER_ANDROID_DEVICE_ID, "phonePeVersion");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"u…,\n      \"phonePeVersion\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "userAuthToken");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…),\n      \"userAuthToken\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(PhonePeExtraInfo)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(PhonePeExtraInfo)";
    }

    public PhonePeExtraInfo fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("userAuthToken", "userAuthToken", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"use… \"userAuthToken\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(Constant.HEADER_ANDROID_DEVICE_ID, Constant.HEADER_ANDROID_DEVICE_ID, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"dev…      \"deviceId\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName != 2) {
                continue;
            } else {
                str3 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("phonePeVersion", "phonePeVersion", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"pho…\"phonePeVersion\", reader)");
                    throw unexpectedNull3;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("userAuthToken", "userAuthToken", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"us… \"userAuthToken\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(Constant.HEADER_ANDROID_DEVICE_ID, Constant.HEADER_ANDROID_DEVICE_ID, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"de…eId\", \"deviceId\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new PhonePeExtraInfo(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("phonePeVersion", "phonePeVersion", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"ph…\"phonePeVersion\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, PhonePeExtraInfo phonePeExtraInfo) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (phonePeExtraInfo != null) {
            jsonWriter.beginObject();
            jsonWriter.name("userAuthToken");
            this.stringAdapter.toJson(jsonWriter, phonePeExtraInfo.getUserAuthToken());
            jsonWriter.name(Constant.HEADER_ANDROID_DEVICE_ID);
            this.stringAdapter.toJson(jsonWriter, phonePeExtraInfo.getDeviceId());
            jsonWriter.name("phonePeVersion");
            this.stringAdapter.toJson(jsonWriter, phonePeExtraInfo.getPhonePeVersion());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
