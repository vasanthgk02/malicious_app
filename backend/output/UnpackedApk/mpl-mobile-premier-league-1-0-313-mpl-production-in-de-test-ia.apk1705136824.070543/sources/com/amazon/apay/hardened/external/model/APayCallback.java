package com.amazon.apay.hardened.external.model;

public interface APayCallback {
    void onError(APayError aPayError);

    void onSuccess();
}
