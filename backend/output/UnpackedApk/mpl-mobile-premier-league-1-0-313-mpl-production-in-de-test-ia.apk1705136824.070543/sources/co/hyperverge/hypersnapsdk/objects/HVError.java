package co.hyperverge.hypersnapsdk.objects;

import java.io.Serializable;

public class HVError implements Serializable {
    public static final int ACTIVE_SESSION_ERROR = 16;
    public static final int BLURRY_FACE_DETECTION_ERROR = 23;
    public static final int FACE_DETECTION_ERROR = 22;
    public static final int GPS_ACCESS_DENIED = 33;
    public static final int HARDWARE_ERROR = 5;
    public static final int INITIALIZATION_ERROR = 11;
    public static final int INPUT_ERROR = 6;
    public static final int INSTRUCTION_ERROR = 31;
    public static final int INTERNAL_SDK_ERROR = 2;
    public static final int INTERNAL_SERVER_ERROR = 14;
    public static final int LOCATION_PERMISSION_NOT_AVAILABLE_ERROR = 8;
    public static final int NETWORK_ERROR = 12;
    public static final int OPERATION_CANCELLED_BY_USER_ERROR = 3;
    public static final int PERMISSIONS_NOT_GRANTED_ERROR = 4;
    public static final int QR_PARSER_ERROR = 7;
    public static final int QR_SCANNER_ERROR = 32;
    public static final int SIGNATURE_FAILED_ERROR = 18;
    public static final int SSL_CONNECT_ERROR = 15;
    public static final int TRANSACTION_ID_EMPTY = 17;
    public int errorCode;
    public String errorMessage;

    public HVError() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public HVError(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }
}
