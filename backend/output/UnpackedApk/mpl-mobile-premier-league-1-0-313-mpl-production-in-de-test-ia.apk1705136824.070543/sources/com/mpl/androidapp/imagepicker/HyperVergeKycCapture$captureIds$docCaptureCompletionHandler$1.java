package com.mpl.androidapp.imagepicker;

import co.hyperverge.hypersnapsdk.listeners.DocCaptureCompletionHandler;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import com.mpl.androidapp.utils.FileUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "hvError", "Lco/hyperverge/hypersnapsdk/objects/HVError;", "kotlin.jvm.PlatformType", "hvResponse", "Lco/hyperverge/hypersnapsdk/objects/HVResponse;", "onResult"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HyperVergeKycCapture.kt */
public final class HyperVergeKycCapture$captureIds$docCaptureCompletionHandler$1 implements DocCaptureCompletionHandler {
    public final /* synthetic */ IdCaptureListener $idCaptureListener;
    public final /* synthetic */ HyperVergeKycCapture this$0;

    public HyperVergeKycCapture$captureIds$docCaptureCompletionHandler$1(HyperVergeKycCapture hyperVergeKycCapture, IdCaptureListener idCaptureListener) {
        this.this$0 = hyperVergeKycCapture;
        this.$idCaptureListener = idCaptureListener;
    }

    public final void onResult(HVError hVError, HVResponse hVResponse) {
        if (hVError != null) {
            try {
                HyperVergeKycCapture hyperVergeKycCapture = this.this$0;
                IdCaptureListener idCaptureListener = this.$idCaptureListener;
                hyperVergeKycCapture.sendFailStatus(idCaptureListener, hVError.getErrorCode() + ' ' + hVError.getErrorMessage(), hVError.getErrorCode());
            } catch (Exception unused) {
                IdCaptureListener idCaptureListener2 = this.$idCaptureListener;
                if (idCaptureListener2 != null) {
                    idCaptureListener2.onError("Exception Happened");
                }
            }
        } else {
            HyperVergeKycCapture hyperVergeKycCapture2 = this.this$0;
            IdCaptureListener idCaptureListener3 = this.$idCaptureListener;
            String imageURI = hVResponse.getImageURI();
            Intrinsics.checkNotNullExpressionValue(imageURI, "hvResponse.imageURI");
            Double fileSizeInBytesOrNull = FileUtils.getFileSizeInBytesOrNull(hVResponse.getImageURI());
            hyperVergeKycCapture2.sendSuccessStatus(idCaptureListener3, imageURI, fileSizeInBytesOrNull == null ? null : String.valueOf(fileSizeInBytesOrNull));
        }
    }
}
