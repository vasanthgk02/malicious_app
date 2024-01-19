package com.mpl.payment.paytm;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class ServerResponse implements Serializable {
    public Payload payload;
    public Status status;

    public static class Payload {
        public Fields fields;

        public static class Fields {
            public String AUTH_MODE;
            public String BANK_CODE;
            public String CALLBACK_URL;
            public String CARD_TYPE;
            public String CHANNEL_ID;
            public String CHECKSUMHASH;
            public String CUST_ID;
            public String EMAIL;
            public String INDUSTRY_TYPE_ID;
            public boolean IS_PRODUCTION;
            public String MID;
            public String MOBILE_NO;
            public String ORDER_ID;
            public String PAYMENT_MODE_ONLY;
            public String PAYMENT_TYPE_ID;
            public String PROMO_CAMP_ID;
            public String THEME;
            public String TXN_AMOUNT;
            public String WEBSITE;

            public String getAuthMode() {
                return this.AUTH_MODE;
            }

            public String getBankCode() {
                return this.BANK_CODE;
            }

            public String getCallbackUrl() {
                return this.CALLBACK_URL;
            }

            public String getCardType() {
                return this.CARD_TYPE;
            }

            public String getChannelId() {
                return this.CHANNEL_ID;
            }

            public String getCheckSumHash() {
                return this.CHECKSUMHASH;
            }

            public String getCustomerId() {
                return this.CUST_ID;
            }

            public String getEmail() {
                return this.EMAIL;
            }

            public String getIndustryTypeId() {
                return this.INDUSTRY_TYPE_ID;
            }

            public String getMid() {
                return this.MID;
            }

            public String getMobileNumber() {
                return this.MOBILE_NO;
            }

            public String getOrderId() {
                return this.ORDER_ID;
            }

            public String getPaymentModeOnly() {
                return this.PAYMENT_MODE_ONLY;
            }

            public String getPaymentTypeId() {
                return this.PAYMENT_TYPE_ID;
            }

            public String getPromoCampId() {
                return this.PROMO_CAMP_ID;
            }

            public String getTheme() {
                return this.THEME;
            }

            public String getTxnAmount() {
                return this.TXN_AMOUNT;
            }

            public String getWebsite() {
                return this.WEBSITE;
            }

            public boolean isProduction() {
                return this.IS_PRODUCTION;
            }

            public void setAuthMode(String str) {
                this.AUTH_MODE = str;
            }

            public void setBank_code(String str) {
                this.BANK_CODE = str;
            }

            public void setCallback_url(String str) {
                this.CALLBACK_URL = str;
            }

            public void setCard_type(String str) {
                this.CARD_TYPE = str;
            }

            public void setChannel_id(String str) {
                this.CHANNEL_ID = str;
            }

            public void setChecksumhash(String str) {
                this.CHECKSUMHASH = str;
            }

            public void setCust_id(String str) {
                this.CUST_ID = str;
            }

            public void setEmail(String str) {
                this.EMAIL = str;
            }

            public void setIS_PRODUCTION(boolean z) {
                this.IS_PRODUCTION = z;
            }

            public void setIndustry_type_id(String str) {
                this.INDUSTRY_TYPE_ID = str;
            }

            public void setMid(String str) {
                this.MID = str;
            }

            public void setMobile_no(String str) {
                this.MOBILE_NO = str;
            }

            public void setOrder_id(String str) {
                this.ORDER_ID = str;
            }

            public void setPaymentModeOnly(String str) {
                this.PAYMENT_MODE_ONLY = str;
            }

            public void setPayment_type_id(String str) {
                this.PAYMENT_TYPE_ID = str;
            }

            public void setPromo_camp_id(String str) {
                this.PROMO_CAMP_ID = str;
            }

            public void setTheme(String str) {
                this.THEME = str;
            }

            public void setTxn_amount(String str) {
                this.TXN_AMOUNT = str;
            }

            public void setWebsite(String str) {
                this.WEBSITE = str;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Fields{CUST_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.CUST_ID, ExtendedMessageFormat.QUOTE, ", MOBILE_NO='");
                GeneratedOutlineSupport.outline99(outline73, this.MOBILE_NO, ExtendedMessageFormat.QUOTE, ", CHANNEL_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.CHANNEL_ID, ExtendedMessageFormat.QUOTE, ", ORDER_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.ORDER_ID, ExtendedMessageFormat.QUOTE, ", TXN_AMOUNT='");
                GeneratedOutlineSupport.outline99(outline73, this.TXN_AMOUNT, ExtendedMessageFormat.QUOTE, ", CALLBACK_URL='");
                GeneratedOutlineSupport.outline99(outline73, this.CALLBACK_URL, ExtendedMessageFormat.QUOTE, ", MID='");
                GeneratedOutlineSupport.outline99(outline73, this.MID, ExtendedMessageFormat.QUOTE, ", INDUSTRY_TYPE_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.INDUSTRY_TYPE_ID, ExtendedMessageFormat.QUOTE, ", CHECKSUMHASH='");
                GeneratedOutlineSupport.outline99(outline73, this.CHECKSUMHASH, ExtendedMessageFormat.QUOTE, ", WEBSITE='");
                GeneratedOutlineSupport.outline99(outline73, this.WEBSITE, ExtendedMessageFormat.QUOTE, ", EMAIL='");
                GeneratedOutlineSupport.outline99(outline73, this.EMAIL, ExtendedMessageFormat.QUOTE, ", PAYMENT_MODE_ONLY='");
                GeneratedOutlineSupport.outline99(outline73, this.PAYMENT_MODE_ONLY, ExtendedMessageFormat.QUOTE, ", AUTH_MODE='");
                GeneratedOutlineSupport.outline99(outline73, this.AUTH_MODE, ExtendedMessageFormat.QUOTE, ", PAYMENT_TYPE_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.PAYMENT_TYPE_ID, ExtendedMessageFormat.QUOTE, ", CARD_TYPE='");
                GeneratedOutlineSupport.outline99(outline73, this.CARD_TYPE, ExtendedMessageFormat.QUOTE, ", BANK_CODE='");
                GeneratedOutlineSupport.outline99(outline73, this.BANK_CODE, ExtendedMessageFormat.QUOTE, ", PROMO_CAMP_ID='");
                GeneratedOutlineSupport.outline99(outline73, this.PROMO_CAMP_ID, ExtendedMessageFormat.QUOTE, ", THEME='");
                return GeneratedOutlineSupport.outline60(outline73, this.THEME, ExtendedMessageFormat.QUOTE, '}');
            }
        }

        public Fields getFields() {
            return this.fields;
        }

        public void setFields(Fields fields2) {
            this.fields = fields2;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Payload{fields=");
            outline73.append(this.fields);
            outline73.append('}');
            return outline73.toString();
        }
    }

    public static class Status {
        public int code;
        public String message;

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    public Payload getPayload() {
        return this.payload;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ServerResponse{status=");
        outline73.append(this.status);
        outline73.append(", payload=");
        outline73.append(this.payload);
        outline73.append('}');
        return outline73.toString();
    }
}
