package com.mpl.payment.gopay.models;

import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayTransactionReactPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/gopay/models/GoPayTransactionReactPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayTransactionReactPayloadJsonAdapter.kt */
public final class GoPayTransactionReactPayloadJsonAdapter extends JsonAdapter<GoPayTransactionReactPayload> {
    public final Options options;
    public final JsonAdapter<String> stringAdapter;

    public GoPayTransactionReactPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("amount", PaymentConstants.MERCHANT_ID_CAMEL, "accountId", "callBackUrl", "merchantServerUrl", "paymentOptionToken", RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, "currency");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…umber\",\n      \"currency\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, EmptySet.INSTANCE, "amount");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(),\n      \"amount\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(GoPayTransactionReactPayload)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(GoPayTransactionReactPayload)";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fa, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fc, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fe, code lost:
        r9 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mpl.payment.gopay.models.GoPayTransactionReactPayload fromJson(com.squareup.moshi.JsonReader r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r20.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x0015:
            boolean r2 = r20.hasNext()
            java.lang.String r3 = "currency"
            java.lang.String r12 = "phoneNumber"
            java.lang.String r13 = "paymentOptionToken"
            java.lang.String r14 = "merchantServerUrl"
            java.lang.String r15 = "callBackUrl"
            r16 = r11
            java.lang.String r11 = "accountId"
            r17 = r10
            java.lang.String r10 = "merchantId"
            r18 = r9
            java.lang.String r9 = "amount"
            if (r2 == 0) goto L_0x0102
            com.squareup.moshi.JsonReader$Options r2 = r0.options
            int r2 = r1.selectName(r2)
            switch(r2) {
                case -1: goto L_0x00f4;
                case 0: goto L_0x00de;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00b2;
                case 3: goto L_0x009c;
                case 4: goto L_0x0086;
                case 5: goto L_0x006c;
                case 6: goto L_0x0053;
                case 7: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x00fa
        L_0x003c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0049
            r11 = r2
            goto L_0x00fc
        L_0x0049:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r3, r3, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"cur…      \"currency\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0053:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0062
            r10 = r2
            r11 = r16
            goto L_0x00fe
        L_0x0062:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r12, r12, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"pho…\", \"phoneNumber\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x006c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x007c
            r9 = r2
            r11 = r16
            r10 = r17
            goto L_0x0015
        L_0x007c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r13, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"pay…mentOptionToken\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0086:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0092
            r8 = r2
            goto L_0x00fa
        L_0x0092:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"mer…rchantServerUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x009c:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00a8
            r7 = r2
            goto L_0x00fa
        L_0x00a8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"cal…\", \"callBackUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00b2:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00be
            r6 = r2
            goto L_0x00fa
        L_0x00be:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r11, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"acc…     \"accountId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00c8:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00d4
            r5 = r2
            goto L_0x00fa
        L_0x00d4:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r10, r10, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"mer…    \"merchantId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00de:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00ea
            r4 = r2
            goto L_0x00fa
        L_0x00ea:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "Util.unexpectedNull(\"amo…        \"amount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x00f4:
            r20.skipName()
            r20.skipValue()
        L_0x00fa:
            r11 = r16
        L_0x00fc:
            r10 = r17
        L_0x00fe:
            r9 = r18
            goto L_0x0015
        L_0x0102:
            r20.endObject()
            com.mpl.payment.gopay.models.GoPayTransactionReactPayload r2 = new com.mpl.payment.gopay.models.GoPayTransactionReactPayload
            if (r4 == 0) goto L_0x0168
            if (r5 == 0) goto L_0x015e
            if (r6 == 0) goto L_0x0154
            if (r7 == 0) goto L_0x014a
            if (r8 == 0) goto L_0x0140
            if (r18 == 0) goto L_0x0136
            if (r17 == 0) goto L_0x012c
            if (r16 == 0) goto L_0x0122
            r3 = r2
            r9 = r18
            r10 = r17
            r11 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x0122:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r3, r3, r1)
            java.lang.String r2 = "Util.missingProperty(\"cu…ncy\", \"currency\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x012c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r12, r12, r1)
            java.lang.String r2 = "Util.missingProperty(\"ph…ber\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0136:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r13, r1)
            java.lang.String r2 = "Util.missingProperty(\"pa…mentOptionToken\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0140:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "Util.missingProperty(\"me…rchantServerUrl\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x014a:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "Util.missingProperty(\"ca…Url\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r11, r1)
            java.lang.String r2 = "Util.missingProperty(\"ac…Id\", \"accountId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x015e:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r10, r10, r1)
            java.lang.String r2 = "Util.missingProperty(\"me…d\", \"merchantId\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        L_0x0168:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "Util.missingProperty(\"amount\", \"amount\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.gopay.models.GoPayTransactionReactPayloadJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.mpl.payment.gopay.models.GoPayTransactionReactPayload");
    }

    public void toJson(JsonWriter jsonWriter, GoPayTransactionReactPayload goPayTransactionReactPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (goPayTransactionReactPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("amount");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getAmount());
            jsonWriter.name(PaymentConstants.MERCHANT_ID_CAMEL);
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getMerchantId());
            jsonWriter.name("accountId");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getAccountId());
            jsonWriter.name("callBackUrl");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getCallBackUrl());
            jsonWriter.name("merchantServerUrl");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getMerchantServerUrl());
            jsonWriter.name("paymentOptionToken");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getPaymentOptionToken());
            jsonWriter.name(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER);
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getPhoneNumber());
            jsonWriter.name("currency");
            this.stringAdapter.toJson(jsonWriter, goPayTransactionReactPayload.getCurrency());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
