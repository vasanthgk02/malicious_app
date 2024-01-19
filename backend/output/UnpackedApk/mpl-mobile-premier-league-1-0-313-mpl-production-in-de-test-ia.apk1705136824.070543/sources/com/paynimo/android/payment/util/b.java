package com.paynimo.android.payment.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.model.request.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.fontbox.cmap.CMap;

public class b {
    public static void callEventLogging(String str, String str2, String str3, long j, String str4, Checkout checkout, String str5, String str6, String str7, String str8, d dVar, Context context) {
        Context context2 = context;
        n nVar = new n();
        nVar.setTimestamp(new SimpleDateFormat(GeneratedOutlineSupport.outline32(context2, context.getResources(), "paynimo_timestamp_simple_format", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getResources())).format(new Date()));
        nVar.setSession("");
        nVar.setAppId(checkout.getMerchantRequestPayload().getMerchant().getIdentifier());
        nVar.setRequestToken("");
        String str9 = str;
        nVar.setJourney(str);
        String str10 = str2;
        nVar.setEventAction(str2);
        String str11 = str3;
        nVar.setEventCategory(str3);
        nVar.setMerchantTxnId(checkout.getMerchantRequestPayload().getTransaction().getIdentifier());
        nVar.setReferenceId(checkout.getMerchantRequestPayload().getTransaction().getReference());
        nVar.setConsumerId(checkout.getMerchantRequestPayload().getConsumer().getIdentifier());
        nVar.setMerchantId(checkout.getMerchantRequestPayload().getMerchant().getIdentifier());
        nVar.setDeviceId(checkout.getMerchantRequestPayload().getTransaction().getDeviceIdentifier());
        nVar.setUserAgent(Build.MANUFACTURER + CMap.SPACE + Build.MODEL + CMap.SPACE + VERSION.CODENAME);
        long j2 = j;
        nVar.setResponseTime(j);
        String str12 = str4;
        nVar.setEventStatus(str4);
        String str13 = str5;
        nVar.setPaymentOption(str5);
        nVar.setBankName(str6);
        nVar.setBankCode(checkout.getMerchantRequestPayload().getPayment().getMethod().getToken());
        nVar.setCardVendor(str7);
        nVar.setCardType(str8);
        nVar.setTxnAmount(checkout.getMerchantRequestPayload().getTransaction().getAmount());
        nVar.setTxnCurrency(checkout.getMerchantRequestPayload().getTransaction().getCurrency());
        dVar.callEventLoggingRequest(nVar, context2);
    }
}
