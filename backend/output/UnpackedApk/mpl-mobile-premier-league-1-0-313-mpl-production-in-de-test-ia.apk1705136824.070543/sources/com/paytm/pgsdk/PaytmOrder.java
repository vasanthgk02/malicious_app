package com.paytm.pgsdk;

import com.mpl.payment.paytm.PaytmRequestConstants;
import java.util.HashMap;

public class PaytmOrder {
    public HashMap<String, String> requestParamMap;

    public PaytmOrder(HashMap<String, String> hashMap) throws IllegalArgumentException {
        if (hashMap == null || hashMap.size() <= 0) {
            throw new IllegalArgumentException("Invalid request params");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_CALLBACK_URL)) {
            throw new IllegalArgumentException("CALLBACK_URL not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_CHECKSUM)) {
            throw new IllegalArgumentException("CHECKSUMHASH not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_CUST_ID)) {
            throw new IllegalArgumentException("CUST_ID not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_INDUSTRY_TYPE_ID)) {
            throw new IllegalArgumentException("INDUSTRY_TYPE_ID not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_MID)) {
            throw new IllegalArgumentException("MID not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_ORDER_ID)) {
            throw new IllegalArgumentException("ORDER_ID not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_WEBSITE)) {
            throw new IllegalArgumentException("WEBSITE not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_CALLBACK_URL)) {
            throw new IllegalArgumentException("CALLBACK_URL not present");
        } else if (!hashMap.containsKey(PaytmRequestConstants.PARAMS_CHANNEL_ID)) {
            throw new IllegalArgumentException("CHANNEL_ID not present");
        } else if (hashMap.containsKey(PaytmRequestConstants.PARAMS_TXN_AMOUNT)) {
            this.requestParamMap = hashMap;
        } else {
            throw new IllegalArgumentException("TXN_AMOUNT not present");
        }
    }
}
