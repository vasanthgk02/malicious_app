package co.hyperverge.hypersnapsdk.listeners;

import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;

public interface APICompletionCallback {
    void onResult(HVError hVError, HVResponse hVResponse);
}
