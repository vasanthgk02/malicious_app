package com.midtrans.sdk.gopaycheckout.core;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/BaseResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/BaseResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableListOfStringAdapter", "", "", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class BaseResponseJsonAdapter extends JsonAdapter<BaseResponse> {
    public volatile Constructor<BaseResponse> constructorRef;
    public final JsonAdapter<List<String>> nullableListOfStringAdapter;
    public final JsonAdapter<String> nullableStringAdapter;
    public final Options options;

    public BaseResponseJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("status_code", "status_message", "id", "validation_messages", "channel_response_code", "channel_response_message");
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"s…hannel_response_message\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(cls, EmptySet.INSTANCE, "statusCode");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(String::cl…emptySet(), \"statusCode\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<List<String>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, cls), EmptySet.INSTANCE, "validationMessages");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(Types.newP…    \"validationMessages\")");
        this.nullableListOfStringAdapter = adapter2;
    }

    public BaseResponse fromJson(JsonReader jsonReader) {
        long j;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(jsonReader2, "reader");
        jsonReader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list = null;
        String str4 = null;
        String str5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    str = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    j = 4294967294L;
                    break;
                case 1:
                    str2 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    j = 4294967293L;
                    break;
                case 2:
                    str3 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    j = 4294967291L;
                    break;
                case 3:
                    list = (List) this.nullableListOfStringAdapter.fromJson(jsonReader2);
                    j = 4294967287L;
                    break;
                case 4:
                    str4 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    j = 4294967279L;
                    break;
                case 5:
                    str5 = (String) this.nullableStringAdapter.fromJson(jsonReader2);
                    j = 4294967263L;
                    break;
            }
            i &= (int) j;
        }
        jsonReader.endObject();
        Constructor<BaseResponse> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = BaseResponse.class.getDeclaredConstructor(new Class[]{cls, cls, cls, List.class, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "BaseResponse::class.java…tructorRef =\n        it }");
        }
        BaseResponse newInstance = constructor.newInstance(new Object[]{str, str2, str3, list, str4, str5, Integer.valueOf(i), null});
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, BaseResponse baseResponse) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (baseResponse != null) {
            jsonWriter.beginObject();
            jsonWriter.name("status_code");
            this.nullableStringAdapter.toJson(jsonWriter, baseResponse.getStatusCode());
            jsonWriter.name("status_message");
            this.nullableStringAdapter.toJson(jsonWriter, baseResponse.getStatusMessage());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, baseResponse.getId());
            jsonWriter.name("validation_messages");
            this.nullableListOfStringAdapter.toJson(jsonWriter, baseResponse.getValidationMessages());
            jsonWriter.name("channel_response_code");
            this.nullableStringAdapter.toJson(jsonWriter, baseResponse.getChannelResponseCode());
            jsonWriter.name("channel_response_message");
            this.nullableStringAdapter.toJson(jsonWriter, baseResponse.getChannelResponseMessage());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(BaseResponse)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(BaseResponse)";
    }
}
