package com.amazon.identity.auth.device.interactive;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.api.CancellableListener;

public interface InteractiveListener<T, U, V> extends bo, CancellableListener<T, U, V>, InteractiveAPI {
    void onCancel(U u);

    void onError(V v);

    /* synthetic */ void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, co coVar);

    /* synthetic */ void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri);

    /* synthetic */ void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc);

    void onSuccess(T t);
}
