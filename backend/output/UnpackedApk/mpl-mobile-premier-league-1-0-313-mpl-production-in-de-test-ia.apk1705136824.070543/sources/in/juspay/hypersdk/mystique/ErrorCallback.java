package in.juspay.hypersdk.mystique;

public interface ErrorCallback {
    void onError(String str, String str2);

    void onException(String str, String str2, Throwable th);
}
