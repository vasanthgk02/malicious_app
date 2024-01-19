package com.idology.cameralibrary;

import androidx.appcompat.app.AlertDialog;
import com.idology.utilities.ActivitySpinner;

public class Constants {
    public static Constants ourInstance = new Constants();
    public ActivationKey activationKey = ActivationKey.DEFAULT;
    public int alertCount = 3;
    public String alertText = "";
    public String backString = "";
    public AlertDialog blinkDialog;
    public CardCombination combination;
    public int defaultAlertCount = 3;
    public String defaultAlertText = "Please give the app permission to use the camera";
    public boolean defaultBackImageFlash = false;
    public String defaultExitText = "Unable to proceed without camera";
    public CameraSdkSettings$DocumentType documentType = CameraSdkSettings$DocumentType.Any;
    public String exitText = "";
    public String frontString = "";
    public boolean livelinessEnabled = false;
    public String selectedSide = "";
    public String selfieString = "";
    public ActivitySpinner spinner = null;
    public boolean standardImageSize = false;
    public boolean useSelfie = false;

    public enum CardCombination {
        licenseFront,
        licenseBack,
        licenseSelfie,
        passportFront,
        passportSelfie
    }
}
