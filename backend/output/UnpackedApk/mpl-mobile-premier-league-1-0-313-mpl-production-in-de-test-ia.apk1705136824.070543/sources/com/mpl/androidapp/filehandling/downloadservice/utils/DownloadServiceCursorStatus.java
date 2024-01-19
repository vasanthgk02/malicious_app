package com.mpl.androidapp.filehandling.downloadservice.utils;

import android.database.Cursor;
import com.google.gson.Gson;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceCursorStatus;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "getGson", "()Lcom/google/gson/Gson;", "checkCondition", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadManagerStatus;", "status", "", "reason", "checkDownloadStatus", "cursor", "Landroid/database/Cursor;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadServiceCursorStatus.kt */
public class DownloadServiceCursorStatus {
    public static final Companion Companion = new Companion(null);
    public static final String ERROR_CANNOT_RESUME = "ERROR_CANNOT_RESUME";
    public static final String ERROR_CAUSE_DOWNLOAD_MANAGER = "ERROR_CAUSE_DOWNLOAD_MANAGER -- ";
    public static final String ERROR_DEVICE_NOT_FOUND = "ERROR_DEVICE_NOT_FOUND";
    public static final String ERROR_FILE_ALREADY_EXISTS = "ERROR_FILE_ALREADY_EXISTS";
    public static final String ERROR_FILE_ERROR = "ERROR_FILE_ERROR";
    public static final String ERROR_HTTP_DATA_ERROR = "ERROR_HTTP_DATA_ERROR";
    public static final String ERROR_INSUFFICIENT_SPACE = "ERROR_INSUFFICIENT_SPACE";
    public static final String ERROR_TOO_MANY_REDIRECTS = "ERROR_TOO_MANY_REDIRECTS";
    public static final String ERROR_UNHANDLED_HTTP_CODE = "ERROR_UNHANDLED_HTTP_CODE";
    public static final String ERROR_UNKNOWN = "ERROR_UNKNOWN";
    public static final String FORBIDDEN_ERROR = "FORBIDDEN_ERROR";
    public static final String PAUSED_QUEUED_FOR_WIFI = "PAUSED_QUEUED_FOR_WIFI";
    public static final String PAUSED_UNKNOWN = "PAUSED_UNKNOWN";
    public static final String PAUSED_WAITING_FOR_NETWORK = "PAUSED_WAITING_FOR_NETWORK";
    public static final String PAUSED_WAITING_TO_RETRY = "PAUSED_WAITING_TO_RETRY";
    public static final int STATUS_CODE_403 = 403;
    public static final String STATUS_PENDING = "STATUS_PENDING";
    public static final String STATUS_RUNNING = "STATUS_RUNNING";
    public static final String STATUS_SUCCESSFUL = "STATUS_SUCCESSFUL";
    public static final String TAG = "DownloadingFileFromServer";
    public static final String WITH_ERROR_CODE_STR = " with error code -> ";
    public static final String WITH_PAUSED_CODE_STR = " with paused code -> ";
    public final Gson gson;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceCursorStatus$Companion;", "", "()V", "ERROR_CANNOT_RESUME", "", "ERROR_CAUSE_DOWNLOAD_MANAGER", "ERROR_DEVICE_NOT_FOUND", "ERROR_FILE_ALREADY_EXISTS", "ERROR_FILE_ERROR", "ERROR_HTTP_DATA_ERROR", "ERROR_INSUFFICIENT_SPACE", "ERROR_TOO_MANY_REDIRECTS", "ERROR_UNHANDLED_HTTP_CODE", "ERROR_UNKNOWN", "FORBIDDEN_ERROR", "PAUSED_QUEUED_FOR_WIFI", "PAUSED_UNKNOWN", "PAUSED_WAITING_FOR_NETWORK", "PAUSED_WAITING_TO_RETRY", "STATUS_CODE_403", "", "STATUS_PENDING", "STATUS_RUNNING", "STATUS_SUCCESSFUL", "TAG", "WITH_ERROR_CODE_STR", "WITH_PAUSED_CODE_STR", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadServiceCursorStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DownloadServiceCursorStatus(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    private final DownloadManagerStatus checkCondition(int i, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str6;
        String str7;
        int i3 = i;
        int i4 = i2;
        if (i3 == 1) {
            str3 = "STATUS_PENDING";
            str5 = "";
            str4 = str5;
            str2 = str4;
            str = str2;
            z5 = false;
            z4 = false;
            z3 = true;
        } else if (i3 != 2) {
            if (i3 == 4) {
                if (i4 == 1) {
                    str6 = Intrinsics.stringPlus("PAUSED_WAITING_TO_RETRY with paused code -> ", Integer.valueOf(i2));
                } else if (i4 == 2) {
                    str6 = Intrinsics.stringPlus("PAUSED_WAITING_FOR_NETWORK with paused code -> ", Integer.valueOf(i2));
                } else if (i4 == 3) {
                    str6 = Intrinsics.stringPlus("PAUSED_QUEUED_FOR_WIFI with paused code -> ", Integer.valueOf(i2));
                } else if (i4 != 4) {
                    str6 = "";
                } else {
                    str6 = Intrinsics.stringPlus("PAUSED_UNKNOWN with paused code -> ", Integer.valueOf(i2));
                }
                str4 = str6;
                str5 = "";
                str3 = str5;
                str2 = str3;
                str = str2;
                z5 = false;
                z4 = true;
            } else if (i3 != 8) {
                if (i3 != 16) {
                    str5 = "";
                    str4 = str5;
                    str3 = str4;
                    str2 = str3;
                    str = str2;
                    z5 = false;
                } else {
                    if (i4 != 403) {
                        switch (i4) {
                            case 1000:
                                str7 = Intrinsics.stringPlus("ERROR_UNKNOWN with error code -> ", Integer.valueOf(i2));
                                break;
                            case 1001:
                                str7 = Intrinsics.stringPlus("ERROR_FILE_ERROR with error code -> ", Integer.valueOf(i2));
                                break;
                            case 1002:
                                str7 = Intrinsics.stringPlus("ERROR_UNHANDLED_HTTP_CODE with error code -> ", Integer.valueOf(i2));
                                break;
                            default:
                                switch (i4) {
                                    case 1004:
                                        str7 = Intrinsics.stringPlus("ERROR_HTTP_DATA_ERROR with error code -> ", Integer.valueOf(i2));
                                        break;
                                    case WebSocketProtocol.CLOSE_NO_STATUS_CODE /*1005*/:
                                        str7 = Intrinsics.stringPlus("ERROR_TOO_MANY_REDIRECTS with error code -> ", Integer.valueOf(i2));
                                        break;
                                    case 1006:
                                        str7 = Intrinsics.stringPlus("ERROR_INSUFFICIENT_SPACE with error code -> ", Integer.valueOf(i2));
                                        break;
                                    case Constant.REQUEST_CODE_FOR_SHORT_CUT /*1007*/:
                                        str7 = Intrinsics.stringPlus("ERROR_DEVICE_NOT_FOUND with error code -> ", Integer.valueOf(i2));
                                        break;
                                    case Constant.REQUEST_CODE_FOR_POKER_LAUNCH /*1008*/:
                                        str7 = Intrinsics.stringPlus("ERROR_CANNOT_RESUME with error code -> ", Integer.valueOf(i2));
                                        break;
                                    case 1009:
                                        str7 = Intrinsics.stringPlus("ERROR_FILE_ALREADY_EXISTS with error code -> ", Integer.valueOf(i2));
                                        break;
                                    default:
                                        str7 = Intrinsics.stringPlus("ERROR_CAUSE_DOWNLOAD_MANAGER --  with error code -> ", Integer.valueOf(i2));
                                        break;
                                }
                        }
                    } else {
                        str7 = Intrinsics.stringPlus("FORBIDDEN_ERROR with error code -> ", Integer.valueOf(i2));
                    }
                    str5 = str7;
                    str4 = "";
                    str3 = str4;
                    str2 = str3;
                    str = str2;
                    z5 = true;
                }
                z4 = false;
            } else {
                str = "STATUS_SUCCESSFUL";
                str5 = "";
                str4 = str5;
                str3 = str4;
                str2 = str3;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = true;
                DownloadManagerStatus downloadManagerStatus = new DownloadManagerStatus(z5, z4, z3, z2, z, str5, str4, str3, str2, str);
                MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
                MLogger.d("DownloadingFileFromServer", this.gson.toJson((Object) downloadManagerStatus));
                MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
                return downloadManagerStatus;
            }
            z3 = false;
        } else {
            str2 = "STATUS_RUNNING";
            str5 = "";
            str4 = str5;
            str3 = str4;
            str = str3;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = true;
            z = false;
            DownloadManagerStatus downloadManagerStatus2 = new DownloadManagerStatus(z5, z4, z3, z2, z, str5, str4, str3, str2, str);
            MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
            MLogger.d("DownloadingFileFromServer", this.gson.toJson((Object) downloadManagerStatus2));
            MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
            return downloadManagerStatus2;
        }
        z2 = false;
        z = false;
        DownloadManagerStatus downloadManagerStatus22 = new DownloadManagerStatus(z5, z4, z3, z2, z, str5, str4, str3, str2, str);
        MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
        MLogger.d("DownloadingFileFromServer", this.gson.toJson((Object) downloadManagerStatus22));
        MLogger.d("DownloadingFileFromServer", "<---------------------------------------------------------------->");
        return downloadManagerStatus22;
    }

    public final DownloadManagerStatus checkDownloadStatus(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        return checkCondition(cursor.getInt(cursor.getColumnIndex("status")), cursor.getInt(cursor.getColumnIndex("reason")));
    }

    public final Gson getGson() {
        return this.gson;
    }
}
