package in.juspay.hypersdk.data;

import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
public interface JuspayResponseHandler extends Runnable {
    void onError(String str);

    void onResponse(Bundle bundle);

    void onResponse(String str);
}
