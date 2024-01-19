package co.hyperverge.hypersnapsdk.listeners;

import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import java.io.Serializable;

public interface FaceCaptureCompletionHandler extends Serializable {
    void onResult(HVError hVError, HVResponse hVResponse);
}