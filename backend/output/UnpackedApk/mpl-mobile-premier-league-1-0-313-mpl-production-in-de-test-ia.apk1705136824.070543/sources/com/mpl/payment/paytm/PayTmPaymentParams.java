package com.mpl.payment.paytm;

import java.util.HashMap;

public final class PayTmPaymentParams {
    public final String auth_mode;
    public final String bank_code;
    public final String callback_url;
    public final String card_type;
    public final String channel_id;
    public final String checksum;
    public final String cust_id;
    public final String email;
    public final String industry_type_id;
    public HashMap<String, String> mPayTmParams;
    public final String mid;
    public final String mobile_no;
    public final String order_id;
    public final String payment_mode_only;
    public final String payment_type_id;
    public final String promo_camp_id;
    public final String theme;
    public final String txn_amount;
    public final String website;

    public static class Builder {
        public String auth_mode;
        public String bank_code;
        public String callback_url;
        public String card_type;
        public String channel_id;
        public String checksum;
        public String cust_id;
        public String email;
        public String industry_type_id;
        public String mid;
        public String mobile_no;
        public String order_id;
        public String payment_mode_only;
        public String payment_type_id;
        public String promo_camp_id;
        public String theme;
        public String txn_amount;
        public String website;

        public PayTmPaymentParams build() {
            return new PayTmPaymentParams(this);
        }

        public Builder mid(String str) {
            this.mid = str;
            return this;
        }

        public Builder setAuthMode(String str) {
            this.auth_mode = str;
            return this;
        }

        public Builder setBankCode(String str) {
            this.bank_code = str;
            return this;
        }

        public Builder setCallbackUrl(String str) {
            this.callback_url = str;
            return this;
        }

        public Builder setCardType(String str) {
            this.card_type = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.channel_id = str;
            return this;
        }

        public Builder setChecksum(String str) {
            this.checksum = str;
            return this;
        }

        public Builder setCustId(String str) {
            this.cust_id = str;
            return this;
        }

        public Builder setEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder setIndustryTypeId(String str) {
            this.industry_type_id = str;
            return this;
        }

        public Builder setMobileNo(String str) {
            this.mobile_no = str;
            return this;
        }

        public Builder setOrderId(String str) {
            this.order_id = str;
            return this;
        }

        public Builder setPaymentModeOnly(String str) {
            this.payment_mode_only = str;
            return this;
        }

        public Builder setPaymentTypeId(String str) {
            this.payment_type_id = str;
            return this;
        }

        public Builder setPromoCampId(String str) {
            this.promo_camp_id = str;
            return this;
        }

        public Builder setTheme(String str) {
            this.theme = str;
            return this;
        }

        public Builder setTxnAmount(String str) {
            this.txn_amount = str;
            return this;
        }

        public Builder setWebsite(String str) {
            this.website = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private String getAuthMode() {
        return this.auth_mode;
    }

    private String getBankCode() {
        return this.bank_code;
    }

    private String getCallbackUrl() {
        return this.callback_url;
    }

    private String getCardType() {
        return this.card_type;
    }

    private String getChannelId() {
        return this.channel_id;
    }

    private String getChecksum() {
        return this.checksum;
    }

    private String getCustId() {
        return this.cust_id;
    }

    private String getIndustryTypeId() {
        return this.industry_type_id;
    }

    private String getMid() {
        return this.mid;
    }

    private String getMobileNo() {
        return this.mobile_no;
    }

    private String getOrderId() {
        return this.order_id;
    }

    private String getPaymentModeOnly() {
        return this.payment_mode_only;
    }

    private String getPaymentTypeId() {
        return this.payment_type_id;
    }

    private String getPromoCampId() {
        return this.promo_camp_id;
    }

    private String getTxnAmount() {
        return this.txn_amount;
    }

    private String getWebsite() {
        return this.website;
    }

    public String getEmail() {
        return this.email;
    }

    public HashMap<String, String> getParams() {
        if (this.mPayTmParams != null) {
            if (getMid() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_MID, this.mid);
            }
            if (getOrderId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_ORDER_ID, this.order_id);
            }
            if (getCustId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_CUST_ID, this.cust_id);
            }
            if (getTxnAmount() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_TXN_AMOUNT, this.txn_amount);
            }
            if (getChannelId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_CHANNEL_ID, this.channel_id);
            }
            if (getIndustryTypeId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_INDUSTRY_TYPE_ID, this.industry_type_id);
            }
            if (getWebsite() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_WEBSITE, this.website);
            }
            if (getChecksum() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_CHECKSUM, this.checksum);
            }
            if (getCallbackUrl() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_CALLBACK_URL, this.callback_url);
            }
            if (getMobileNo() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_MOBILE_NO, this.mobile_no);
            }
            if (getEmail() != null) {
                this.mPayTmParams.put("EMAIL", this.email);
            }
            if (getPaymentModeOnly() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_PAYMENT_MODE_ONLY, this.payment_mode_only);
            }
            if (getAuthMode() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_AUTH_MODE, this.auth_mode);
            }
            if (getPaymentTypeId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_PAYMENT_TYPE_ID, this.payment_type_id);
            }
            if (getCardType() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_CARD_TYPE, this.card_type);
            }
            if (getBankCode() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_BANK_CODE, this.bank_code);
            }
            if (getPromoCampId() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_PROMO_CAMP_ID, this.promo_camp_id);
            }
            if (getTheme() != null) {
                this.mPayTmParams.put(PaytmRequestConstants.PARAMS_THEME, this.theme);
            }
            return this.mPayTmParams;
        }
        throw new RuntimeException("First initialize values");
    }

    public String getTheme() {
        return this.theme;
    }

    public PayTmPaymentParams(Builder builder) {
        this.mid = builder.mid;
        this.order_id = builder.order_id;
        this.cust_id = builder.cust_id;
        this.txn_amount = builder.txn_amount;
        this.channel_id = builder.channel_id;
        this.industry_type_id = builder.industry_type_id;
        this.website = builder.website;
        this.checksum = builder.checksum;
        this.mobile_no = builder.mobile_no;
        this.callback_url = builder.callback_url;
        this.email = builder.email;
        this.payment_mode_only = builder.payment_mode_only;
        this.auth_mode = builder.auth_mode;
        this.payment_type_id = builder.payment_type_id;
        this.card_type = builder.card_type;
        this.bank_code = builder.bank_code;
        this.promo_camp_id = builder.promo_camp_id;
        this.theme = builder.theme;
        this.mPayTmParams = new HashMap<>();
    }
}
