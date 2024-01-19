package com.midtrans.sdk.gopaycheckout.core.account;

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
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/LinkAccountRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/midtrans/sdk/gopaycheckout/core/account/LinkAccountRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableGoPayPartnerDetailsAdapter", "Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "nullableMapOfStringStringAdapter", "", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class LinkAccountRequestJsonAdapter extends JsonAdapter<LinkAccountRequest> {
    public volatile Constructor<LinkAccountRequest> constructorRef;
    public final JsonAdapter<GoPayPartnerDetails> nullableGoPayPartnerDetailsAdapter;
    public final JsonAdapter<Map<String, String>> nullableMapOfStringStringAdapter;
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public LinkAccountRequestJsonAdapter(Moshi moshi) {
        Class<String> cls = String.class;
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Options of = Options.of("gopay_partner", "payment_type", LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(of, "JsonReader.Options.of(\"g…_type\",\n      \"metadata\")");
        this.options = of;
        JsonAdapter<GoPayPartnerDetails> adapter = moshi.adapter(GoPayPartnerDetails.class, EmptySet.INSTANCE, "gopayPartner");
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(GoPayPartn…ptySet(), \"gopayPartner\")");
        this.nullableGoPayPartnerDetailsAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(cls, EmptySet.INSTANCE, "paymentType");
        Intrinsics.checkExpressionValueIsNotNull(adapter2, "moshi.adapter(String::cl…t(),\n      \"paymentType\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Map<String, String>> adapter3 = moshi.adapter(Types.newParameterizedType(Map.class, cls, cls), EmptySet.INSTANCE, LiveVideoBroadcaster.METADATA);
        Intrinsics.checkExpressionValueIsNotNull(adapter3, "moshi.adapter(Types.newP…, emptySet(), \"metadata\")");
        this.nullableMapOfStringStringAdapter = adapter3;
    }

    public LinkAccountRequest fromJson(JsonReader jsonReader) {
        Intrinsics.checkParameterIsNotNull(jsonReader, "reader");
        jsonReader.beginObject();
        GoPayPartnerDetails goPayPartnerDetails = null;
        String str = null;
        Map map = null;
        int i = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                goPayPartnerDetails = (GoPayPartnerDetails) this.nullableGoPayPartnerDetailsAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                str = (String) this.stringAdapter.fromJson(jsonReader);
                if (str != null) {
                    i &= (int) 4294967293L;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("paymentType", "payment_type", jsonReader);
                    Intrinsics.checkExpressionValueIsNotNull(unexpectedNull, "Util.unexpectedNull(\"pay…  \"payment_type\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 2) {
                map = (Map) this.nullableMapOfStringStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        Constructor<LinkAccountRequest> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = LinkAccountRequest.class.getDeclaredConstructor(new Class[]{GoPayPartnerDetails.class, String.class, Map.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "LinkAccountRequest::clas…his.constructorRef = it }");
        }
        LinkAccountRequest newInstance = constructor.newInstance(new Object[]{goPayPartnerDetails, str, map, Integer.valueOf(i), null});
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, LinkAccountRequest linkAccountRequest) {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "writer");
        if (linkAccountRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name("gopay_partner");
            this.nullableGoPayPartnerDetailsAdapter.toJson(jsonWriter, linkAccountRequest.getGopayPartner());
            jsonWriter.name("payment_type");
            this.stringAdapter.toJson(jsonWriter, linkAccountRequest.getPaymentType());
            jsonWriter.name(LiveVideoBroadcaster.METADATA);
            this.nullableMapOfStringStringAdapter.toJson(jsonWriter, linkAccountRequest.getMetadata());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        Intrinsics.checkExpressionValueIsNotNull("GeneratedJsonAdapter(LinkAccountRequest)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(LinkAccountRequest)";
    }
}
