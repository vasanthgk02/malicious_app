package com.paynimo.android.payment.model;

import com.paynimo.android.payment.model.request.Item;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.ResponsePayload;
import java.io.Serializable;
import java.util.List;

public class Checkout implements Serializable {
    public static final long serialVersionUID = 1;
    public RequestPayload merchantRequestPayload;
    public String merchantResponse;
    public ResponsePayload merchantResponsePayload;

    public Checkout(RequestPayload requestPayload) {
        this.merchantResponse = null;
        this.merchantRequestPayload = requestPayload;
    }

    public void addCartItem(Item item) {
        this.merchantRequestPayload.getCart().addItem(item);
    }

    public RequestPayload getMerchantRequestPayload() {
        return this.merchantRequestPayload;
    }

    public String getMerchantResponse() {
        return this.merchantResponse;
    }

    public ResponsePayload getMerchantResponsePayload() {
        return this.merchantResponsePayload;
    }

    public void setCartDescription(String str) {
        this.merchantRequestPayload.getCart().setDescription(str);
    }

    public void setCartIdentifier(String str) {
        this.merchantRequestPayload.getCart().setIdentifier(str);
    }

    public void setCartItemList(List<Item> list) {
        this.merchantRequestPayload.getCart().setItem(list);
    }

    public void setCartReference(String str) {
        this.merchantRequestPayload.getCart().setReference(str);
    }

    public void setConsumerAadharNo(String str) {
        this.merchantRequestPayload.getConsumer().setAadharNo(str);
    }

    public void setConsumerAccountHolderName(String str) {
        this.merchantRequestPayload.getConsumer().setAccountHolderName(str);
    }

    public void setConsumerAccountNo(String str) {
        this.merchantRequestPayload.getConsumer().setAccountNo(str);
    }

    public void setConsumerAccountType(String str) {
        this.merchantRequestPayload.getConsumer().setAccountType(str);
    }

    public void setConsumerEmailID(String str) {
        this.merchantRequestPayload.getConsumer().setEmailID(str);
    }

    public void setConsumerIdentifier(String str) {
        this.merchantRequestPayload.getConsumer().setIdentifier(str);
    }

    public void setConsumerMobileNumber(String str) {
        this.merchantRequestPayload.getConsumer().setMobileNumber(str);
    }

    public void setConsumerPan(String str) {
        this.merchantRequestPayload.getConsumer().setPan(str);
    }

    public void setConsumerPhoneNumber(String str) {
        this.merchantRequestPayload.getConsumer().setPhoneNumber(str);
    }

    public void setConsumerVPA(String str) {
        this.merchantRequestPayload.getConsumer().setVpa(str);
    }

    public void setMerchantDescription(String str) {
        this.merchantRequestPayload.getMerchant().setDescription(str);
    }

    public void setMerchantIdentifier(String str) {
        this.merchantRequestPayload.getMerchant().setIdentifier(str);
    }

    public void setMerchantResponse(String str) {
        this.merchantResponse = str;
    }

    public void setMerchantResponseEndpointURL(String str) {
        this.merchantRequestPayload.getMerchant().setResponseEndpointURL(str);
    }

    public void setMerchantResponsePayload(ResponsePayload responsePayload) {
        this.merchantResponsePayload = responsePayload;
    }

    public void setMerchantRespopnseType(String str) {
        this.merchantRequestPayload.getMerchant().setResponseType(str);
    }

    public void setMerchantWebhookEndpointURL(String str) {
        this.merchantRequestPayload.getMerchant().setWebhookEndpointURL(str);
    }

    public void setMerchantWebhookType(String str) {
        this.merchantRequestPayload.getMerchant().setWebhookType(str);
    }

    public void setPaymentInstructionAction(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setAction(str);
    }

    public void setPaymentInstructionAmount(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setAmount(str);
    }

    public void setPaymentInstructionDebitDay(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setDebitDay(str);
    }

    public void setPaymentInstructionDebitFlag(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setDebitFlag(str);
    }

    public void setPaymentInstructionDescription(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setDescription(str);
    }

    public void setPaymentInstructionEndDateTime(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setEndDateTime(str);
    }

    public void setPaymentInstructionFrequency(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setFrequency(str);
    }

    public void setPaymentInstructionIdentifier(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setIdentifier(str);
    }

    public void setPaymentInstructionLimit(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setLimit(str);
    }

    public void setPaymentInstructionOccurrence(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setOccurrence(str);
    }

    public void setPaymentInstructionReference(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setReference(str);
    }

    public void setPaymentInstructionStartDateTime(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setStartDateTime(str);
    }

    public void setPaymentInstructionType(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setType(str);
    }

    public void setPaymentInstructionValidity(String str) {
        this.merchantRequestPayload.getPayment().getInstruction().setValidity(str);
    }

    public void setPaymentInstrumentAcquirer(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setAcquirer(str);
    }

    public void setPaymentInstrumentAction(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setAction(str);
    }

    public void setPaymentInstrumentAddressCity(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setCity(str);
    }

    public void setPaymentInstrumentAddressCountry(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setCountry(str);
    }

    public void setPaymentInstrumentAddressCounty(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setCounty(str);
    }

    public void setPaymentInstrumentAddressState(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setState(str);
    }

    public void setPaymentInstrumentAddressStreet(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setStreet(str);
    }

    public void setPaymentInstrumentAddressZipCode(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().getAddress().setZipCode(str);
    }

    public void setPaymentInstrumentAlias(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setAlias(str);
    }

    public void setPaymentInstrumentAuthenticationSubType(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getAuthentication().setSubType(str);
    }

    public void setPaymentInstrumentAuthenticationToken(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getAuthentication().setToken(str);
    }

    public void setPaymentInstrumentAuthenticationType(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getAuthentication().setType(str);
    }

    public void setPaymentInstrumentBIC(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setbIC(str);
    }

    public void setPaymentInstrumentExpiryDateTime(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getExpiry().setDateTime(str);
    }

    public void setPaymentInstrumentExpiryMonth(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getExpiry().setMonth(str);
    }

    public void setPaymentInstrumentExpiryYear(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getExpiry().setYear(str);
    }

    public void setPaymentInstrumentHolderName(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getHolder().setName(str);
    }

    public void setPaymentInstrumentIBAN(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setiBAN(str);
    }

    public void setPaymentInstrumentIFSC(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setiFSC(str);
    }

    public void setPaymentInstrumentIdentifier(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setIdentifier(str);
    }

    public void setPaymentInstrumentIssuanceDateTime(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getIssuance().setDateTime(str);
    }

    public void setPaymentInstrumentIssuanceMonth(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getIssuance().setMonth(str);
    }

    public void setPaymentInstrumentIssuanceYear(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().getIssuance().setYear(str);
    }

    public void setPaymentInstrumentIssuer(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setIssuer(str);
    }

    public void setPaymentInstrumentMICR(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setmICR(str);
    }

    public void setPaymentInstrumentProcessor(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setProcessor(str);
    }

    public void setPaymentInstrumentProvider(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setProvider(str);
    }

    public void setPaymentInstrumentSubType(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setSubType(str);
    }

    public void setPaymentInstrumentToken(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setToken(str);
    }

    public void setPaymentInstrumentType(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setType(str);
    }

    public void setPaymentInstrumentVerificationCode(String str) {
        this.merchantRequestPayload.getPayment().getInstrument().setVerificationCode(str);
    }

    public void setPaymentMethodToken(String str) {
        this.merchantRequestPayload.getPayment().getMethod().setToken(str);
    }

    public void setPaymentMethodType(String str) {
        this.merchantRequestPayload.getPayment().getMethod().setType(str);
    }

    public void setTransactionAmount(String str) {
        this.merchantRequestPayload.getTransaction().setAmount(str);
    }

    public void setTransactionCurrency(String str) {
        this.merchantRequestPayload.getTransaction().setCurrency(str);
    }

    public void setTransactionDateTime(String str) {
        this.merchantRequestPayload.getTransaction().setDateTime(str);
    }

    public void setTransactionDescription(String str) {
        this.merchantRequestPayload.getTransaction().setDescription(str);
    }

    public void setTransactionDeviceIdentifier(String str) {
        this.merchantRequestPayload.getTransaction().setDeviceIdentifier(str);
    }

    public void setTransactionForced3DSCall(String str) {
        this.merchantRequestPayload.getTransaction().setForced3DSCall(str);
    }

    public void setTransactionIdentifier(String str) {
        this.merchantRequestPayload.getTransaction().setIdentifier(str);
    }

    public void setTransactionIsRegistration(String str) {
        this.merchantRequestPayload.getTransaction().setIsRegistration(str);
    }

    public void setTransactionMerchantInitiated(String str) {
        this.merchantRequestPayload.getTransaction().setMerchantInitiated(str);
    }

    public void setTransactionReference(String str) {
        this.merchantRequestPayload.getTransaction().setReference(str);
    }

    public void setTransactionRequestType(String str) {
        this.merchantRequestPayload.getTransaction().setRequestType(str);
    }

    public void setTransactionSecurityToken(String str) {
        this.merchantRequestPayload.getTransaction().setSecurityToken(str);
    }

    public void setTransactionSmsSending(String str) {
        this.merchantRequestPayload.getTransaction().setSmsSending(str);
    }

    public void setTransactionSubType(String str) {
        this.merchantRequestPayload.getTransaction().setSubType(str);
    }

    public void setTransactionToken(String str) {
        this.merchantRequestPayload.getTransaction().setToken(str);
    }

    public void setTransactionType(String str) {
        this.merchantRequestPayload.getTransaction().setType(str);
    }

    public void addCartItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Item item = new Item(str, str2, str3, str4, str5, str6, str7, str8);
        this.merchantRequestPayload.getCart().addItem(item);
    }

    public Checkout() {
        this.merchantResponse = null;
        this.merchantRequestPayload = new RequestPayload();
    }
}
