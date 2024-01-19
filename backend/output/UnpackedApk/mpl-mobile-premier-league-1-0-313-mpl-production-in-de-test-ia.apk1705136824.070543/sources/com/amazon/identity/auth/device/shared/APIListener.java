package com.amazon.identity.auth.device.shared;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;

public interface APIListener extends Listener<Bundle, AuthError> {
    void onError(AuthError authError);

    void onSuccess(Bundle bundle);
}
