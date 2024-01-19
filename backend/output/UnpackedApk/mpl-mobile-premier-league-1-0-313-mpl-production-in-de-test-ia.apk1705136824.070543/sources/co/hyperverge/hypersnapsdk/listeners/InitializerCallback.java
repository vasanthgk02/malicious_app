package co.hyperverge.hypersnapsdk.listeners;

import co.hyperverge.hypersnapsdk.objects.HVError;

public interface InitializerCallback {
    void onError(HVError hVError);

    void onSuccess();
}
