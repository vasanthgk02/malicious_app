package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: bh  reason: default package */
public class bh {
    public static void a(Context context) throws IOException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            throw new IOException("Network is unavailable");
        }
    }

    public ah[] a(cc ccVar, String[] strArr, Context context, ag agVar) throws IOException, AuthError {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("getAuthorizationTokens : appId=");
        outline73.append(agVar.f2705b);
        outline73.append(", scopes=");
        outline73.append(Arrays.toString(strArr));
        cp.c("bh", outline73.toString());
        a(context);
        try {
            bc bcVar = (bc) new bb(context, ccVar, agVar).a();
            bcVar.a();
            return new ah[]{bcVar.f2781a, bcVar.f68a};
        } catch (AuthError e2) {
            if (ERROR_TYPE.ERROR_INVALID_GRANT.equals(e2.getType())) {
                ao.a(context);
            }
            throw e2;
        }
    }
}
