package androidx.ads.identifier;

public class AdvertisingIdNotAvailableException extends Exception {
    public AdvertisingIdNotAvailableException(String str) {
        super(str);
    }

    public AdvertisingIdNotAvailableException(String str, Throwable th) {
        super(str, th);
    }
}
