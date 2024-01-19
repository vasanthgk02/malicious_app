package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.os.Handler;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.config.UserAuthConfig;
import com.freshchat.consumer.sdk.exception.JwtException;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class o {
    public static Handler lh;
    public static a li;

    public static class a implements Runnable {
        public final WeakReference<Context> lk;

        public a(Context context) {
            this.lk = new WeakReference<>(context.getApplicationContext());
        }

        public /* synthetic */ a(Context context, bb bbVar) {
            this(context);
        }

        public void run() {
            if (this.lk.get() != null) {
                com.freshchat.consumer.sdk.b.a.ba((Context) this.lk.get());
            }
            o.go();
        }
    }

    public static boolean P(Context context, String str) {
        String bj = e.i(context).bj();
        return as.a(bj) && as.p(bj, bd(str));
    }

    public static com.freshchat.consumer.sdk.j.c.a a(JwtTokenStatus jwtTokenStatus, JwtTokenStatus jwtTokenStatus2) {
        if (jwtTokenStatus == null) {
            throw new IllegalArgumentException("oldIdTokenState cannot be null in JwtUtils.getUiActionForTokenStatus()");
        } else if (jwtTokenStatus2 == null) {
            throw new IllegalArgumentException("newIdTokenState cannot be null in JwtUtils.getUiActionForTokenStatus()");
        } else if (jwtTokenStatus2 == JwtTokenStatus.TOKEN_VALID || jwtTokenStatus2 == JwtTokenStatus.TOKEN_INVALID || jwtTokenStatus2 == JwtTokenStatus.TOKEN_NOT_SET) {
            return b(jwtTokenStatus2);
        } else {
            if (jwtTokenStatus2 == JwtTokenStatus.TOKEN_EXPIRED) {
                return jwtTokenStatus == JwtTokenStatus.TOKEN_VALID ? com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT : com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            if (jwtTokenStatus2 == JwtTokenStatus.TOKEN_NOT_PROCESSED) {
                return jwtTokenStatus == JwtTokenStatus.TOKEN_EXPIRED ? com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT : com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot determine UiAction for ");
            outline73.append(jwtTokenStatus2.name());
            outline73.append(" in JwtUtils.getUiActionForTransition()");
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public static void a(Context context, JwtTokenStatus jwtTokenStatus) {
        a(context, jwtTokenStatus, null);
    }

    public static void a(Context context, JwtTokenStatus jwtTokenStatus, String str) {
        e i = e.i(context);
        if (jwtTokenStatus == JwtTokenStatus.TOKEN_EXPIRED || jwtTokenStatus == JwtTokenStatus.TOKEN_INVALID) {
            i.gi();
        } else if (as.a(str)) {
            i.c(str);
        }
        i.a(jwtTokenStatus);
        if (jwtTokenStatus == JwtTokenStatus.TOKEN_VALID) {
            go();
        }
        bg.bM(context);
        com.freshchat.consumer.sdk.b.a.ax(context);
    }

    public static com.freshchat.consumer.sdk.j.c.a b(JwtTokenStatus jwtTokenStatus) {
        if (jwtTokenStatus != null) {
            int i = bb.lj[jwtTokenStatus.ordinal()];
            if (i == 1) {
                return com.freshchat.consumer.sdk.j.c.a.SHOW_CONTENT;
            }
            if (i == 2 || i == 3 || i == 4) {
                return com.freshchat.consumer.sdk.j.c.a.SHOW_PROGRESS;
            }
            if (i == 5) {
                return com.freshchat.consumer.sdk.j.c.a.EXIT_WITH_MESSAGE;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("UI Action for jwtTokenStatus - ");
            outline73.append(jwtTokenStatus.name());
            outline73.append(" is not defined");
            throw new IllegalArgumentException(outline73.toString());
        }
        throw new IllegalArgumentException("jwtTokenStatus cannot be null in JwtUtils.getUiActionForTokenStatus()");
    }

    public static void b(Context context, JwtTokenStatus jwtTokenStatus) {
        if (jwtTokenStatus != null) {
            if (jwtTokenStatus == JwtTokenStatus.TOKEN_NOT_SET || jwtTokenStatus == JwtTokenStatus.TOKEN_EXPIRED) {
                bC(context);
            }
        }
    }

    public static void bA(Context context) {
        a(context, JwtTokenStatus.TOKEN_INVALID);
    }

    public static boolean bB(Context context) {
        if (!ap.aZ(context)) {
            return false;
        }
        UserAuthConfig userAuthConfig = ap.bD(context).getUserAuthConfig();
        return userAuthConfig != null && userAuthConfig.isJwtAuthEnabled() && userAuthConfig.isStrictModeEnabled();
    }

    public static void bC(Context context) {
        if (lh == null) {
            lh = new Handler();
            li = new a(context, null);
            lh.postDelayed(li, ap.bD(context).getUserAuthConfig().getAuthTimeOutInterval());
        }
    }

    public static boolean ba(String str) {
        return s(str, "reference_id");
    }

    public static String bb(String str) {
        return t(str, "reference_id");
    }

    public static boolean bc(String str) {
        return s(str, "freshchat_uuid");
    }

    public static String bd(String str) {
        return t(str, "freshchat_uuid");
    }

    public static Long be(String str) {
        String t = t(str, "exp");
        try {
            if (as.a(t)) {
                return Long.valueOf(Long.parseLong(t));
            }
            return null;
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    public static JSONObject bf(String str) {
        try {
            if (as.a(str)) {
                String[] split = str.split(Pattern.quote("."));
                if (split.length != 3) {
                    return null;
                }
                return new JSONObject(new String(Base64.decode(split[1], 11)));
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return null;
    }

    public static boolean bg(String str) {
        boolean z = false;
        if (as.isEmpty(str)) {
            return false;
        }
        Long be = be(str);
        if (be != null) {
            if (be.longValue() < n.fP() / 1000) {
                z = true;
            }
        }
        return z;
    }

    public static void by(Context context) {
        if (bz(context) == JwtTokenStatus.TOKEN_NOT_PROCESSED && al.aS(context)) {
            x(context, e.i(context).gh());
        }
    }

    public static JwtTokenStatus bz(Context context) {
        e i = e.i(context);
        JwtTokenStatus fromInt = JwtTokenStatus.fromInt(i.gj());
        if ((fromInt != JwtTokenStatus.TOKEN_NOT_PROCESSED && fromInt != JwtTokenStatus.TOKEN_VALID) || !bg(i.gh())) {
            return fromInt;
        }
        a(context, JwtTokenStatus.TOKEN_EXPIRED);
        return JwtTokenStatus.TOKEN_EXPIRED;
    }

    public static void f(Context context, String str, String str2) throws JwtException {
        if (P(context, str)) {
            String bj = e.i(context).bj();
            String bd = bd(str);
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("Got a JWT Id Token with a different freshchat_uuid in ", str2, ". Expected uuid:", bj, ", instead got uuid: ");
            outline82.append(bd);
            throw new JwtException(outline82.toString());
        }
    }

    public static void go() {
        Handler handler = lh;
        if (handler != null) {
            a aVar = li;
            if (aVar != null) {
                handler.removeCallbacks(aVar);
            }
        }
        lh = null;
        li = null;
    }

    public static void r(String str, String str2) {
        if (as.isEmpty(str)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str2, " requires a valid jwt id token object"));
        }
    }

    public static boolean s(String str, String str2) {
        try {
            JSONObject bf = bf(str);
            if (bf != null && bf.has(str2)) {
                return as.a(bf.getString(str2));
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return false;
    }

    public static String t(String str, String str2) {
        try {
            JSONObject bf = bf(str);
            if (bf != null && bf.has(str2)) {
                String string = bf.getString(str2);
                if (as.a(string)) {
                    return string;
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return null;
    }

    public static boolean u(String str, String str2) {
        return as.p(as.a(str) ? bd(str) : null, bd(str2));
    }

    public static void v(Context context, String str) throws MethodNotAllowedException {
        if (bB(context)) {
            throw new MethodNotAllowedException(GeneratedOutlineSupport.outline50(str, " is not allowed because strict mode of identifying users with JWT is enabled for this account"));
        }
    }

    public static void w(Context context, String str) throws MethodNotAllowedException {
        if (!bB(context)) {
            throw new MethodNotAllowedException(GeneratedOutlineSupport.outline50(str, " is not allowed because identifying users with JWT is not yet enabled for this account!"));
        }
    }

    public static void x(Context context, String str) {
        if (e.i(context).bl()) {
            b.a(context, new User().setJwtIdToken(str));
        } else {
            b.t(context, str);
        }
    }
}
