package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.zag;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbb implements Runnable {
    public static final Logger zba = new Logger("RevokeAccessOperation", new String[0]);
    public final String zbb;
    public final StatusPendingResult zbc = new StatusPendingResult(null);

    public zbb(String str) {
        Preconditions.checkNotEmpty(str);
        this.zbb = str;
    }

    public static PendingResult zba(String str) {
        if (str == null) {
            Status status = new Status(4, null);
            Preconditions.checkNotNull(status, "Result must not be null");
            Preconditions.checkArgument(!status.isSuccess(), "Status code must not be SUCCESS");
            zag zag = new zag(null, status);
            zag.setResult(status);
            return zag;
        }
        zbb zbb2 = new zbb(str);
        new Thread(zbb2).start();
        return zbb2.zbc;
    }

    public final void run() {
        String str;
        String str2;
        String str3;
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf = String.valueOf(this.zbb);
            if (valueOf.length() != 0) {
                str3 = "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf);
            } else {
                str3 = new String("https://accounts.google.com/o/oauth2/revoke?token=");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                zba.format("Unable to revoke access!", new Object[0]);
            }
            Logger logger = zba;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            Logger logger2 = zba;
            String valueOf2 = String.valueOf(e2.toString());
            if (valueOf2.length() != 0) {
                str = "IOException when revoking access: ".concat(valueOf2);
            } else {
                str = new String("IOException when revoking access: ");
            }
            logger2.format(str, new Object[0]);
        } catch (Exception e3) {
            Logger logger3 = zba;
            String valueOf3 = String.valueOf(e3.toString());
            if (valueOf3.length() != 0) {
                str2 = "Exception when revoking access: ".concat(valueOf3);
            } else {
                str2 = new String("Exception when revoking access: ");
            }
            logger3.format(str2, new Object[0]);
        }
        this.zbc.setResult(status);
    }
}
