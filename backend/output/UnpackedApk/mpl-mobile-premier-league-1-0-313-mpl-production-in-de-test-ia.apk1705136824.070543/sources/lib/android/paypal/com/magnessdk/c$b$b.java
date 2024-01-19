package lib.android.paypal.com.magnessdk;

public enum c$b$b {
    CMID_EXCEPTION_MESSAGE("PayPal-Client-Metadata-Id exceeds the maximum length allowed. This is your own unique identifier for the payload. If you do not pass in this value, a new PayPal-Client-Metadata-Id is generated per method call. ***Maximum length: 32 characters***"),
    APPGUID_EXCEPTION_MESSAGE("Application’s Globally Unique Identifier (AppGUID) exceeds maximum length allowed, This is a string that identifies the merchant application that sets up Magnes on the mobile device. If the merchant app does not pass an AppGuid, Magnes creates one to identify the app. An AppGuid is an application identifier per-installation; that is, if a new instance of the app is installed on the mobile device, or the app is reinstalled, it will have a new AppGuid. ***Maximum length: 36 characters***");
    

    /* renamed from: c  reason: collision with root package name */
    public final String f5973c;

    /* access modifiers changed from: public */
    c$b$b(String str) {
        this.f5973c = str;
    }

    public String toString() {
        return this.f5973c;
    }
}
