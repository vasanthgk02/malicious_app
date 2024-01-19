package com.mpl.payment.juspayhypersdk.models;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/models/UpiAppModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/juspayhypersdk/models/UpiAppModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpiAppModelJsonAdapter.kt */
public final class UpiAppModelJsonAdapter extends JsonAdapter<UpiAppModel> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public UpiAppModelJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("packageName", "appName");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"packageName\", \"appName\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "packageName");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…t(),\n      \"packageName\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(UpiAppModel)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(UpiAppModel)";
    }

    public UpiAppModel fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("packageName", "packageName", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"pac…\", \"packageName\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName != 1) {
                continue;
            } else {
                str2 = (String) this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("appName", "appName", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"app…       \"appName\", reader)");
                    throw unexpectedNull2;
                }
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("packageName", "packageName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"pa…ame\",\n            reader)");
            throw missingProperty;
        } else if (str2 != null) {
            return new UpiAppModel(str, str2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("appName", "appName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"appName\", \"appName\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, UpiAppModel upiAppModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (upiAppModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name("packageName");
            this.stringAdapter.toJson(jsonWriter, upiAppModel.getPackageName());
            jsonWriter.name("appName");
            this.stringAdapter.toJson(jsonWriter, upiAppModel.getAppName());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
