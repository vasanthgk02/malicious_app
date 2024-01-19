package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.c.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class d {
    public static String C(Context context) {
        String bj = e.i(context).bj();
        return as.isEmpty(bj) ? UUID.randomUUID().toString() : bj;
    }

    public static void a(Context context, FreshchatUser freshchatUser) {
        if (freshchatUser != null) {
            User user = new User();
            String firstName = freshchatUser.getFirstName();
            if (av.aN(firstName)) {
                user.setFirstName(firstName);
            } else if (as.a(firstName)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_NAME_ERROR.toString());
            }
            String lastName = freshchatUser.getLastName();
            if (av.aN(lastName)) {
                user.setLastName(lastName);
            } else if (as.a(lastName)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_NAME_ERROR.toString());
            }
            String email = freshchatUser.getEmail();
            if (av.aK(email)) {
                user.setEmail(email);
            } else if (as.a(email)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_EMAIL_ERROR.toString());
            }
            String externalId = freshchatUser.getExternalId();
            if (av.aN(externalId)) {
                user.setExternalId(externalId);
            } else if (as.a(externalId)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_EXTERNAL_ID_ERROR.toString());
            }
            String restoreId = freshchatUser.getRestoreId();
            if (av.aN(restoreId)) {
                user.setRestoreId(restoreId);
            } else if (as.a(restoreId)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_RESTORE_ID_ERROR.toString());
            }
            String phoneCountryCode = freshchatUser.getPhoneCountryCode();
            if (av.aL(phoneCountryCode)) {
                user.setPhoneCountry(phoneCountryCode);
            } else if (as.a(phoneCountryCode)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_COUNTRY_CODE_ERROR.toString());
            }
            String phone = freshchatUser.getPhone();
            if (av.aM(phone)) {
                user.setPhone(phone);
            } else if (as.a(phone)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_PHONE_NUMBER_ERROR.toString());
            }
            b(context, user);
        }
    }

    public static void a(Context context, Map<String, String> map) {
        if (k.d(map)) {
            Map<String, String> e2 = e(map);
            if (k.d(e2)) {
                b(context, new User().setMeta(e2));
            }
        }
    }

    public static void a(e eVar, User user) {
        if (eVar != null && user != null) {
            if (as.a(user.getFirstName())) {
                eVar.q(user.getFirstName());
            }
            if (as.a(user.getLastName())) {
                eVar.r(user.getLastName());
            }
            if (as.a(user.getEmail())) {
                eVar.s(user.getEmail());
            }
            if (as.a(user.getPhone())) {
                eVar.I(user.getPhone());
            }
            if (as.a(user.getPhoneCountry())) {
                eVar.H(user.getPhoneCountry());
            }
            if (as.a(user.getExternalId())) {
                eVar.u(user.getExternalId());
            }
            if (as.a(user.getRestoreId())) {
                eVar.E(user.getRestoreId());
            }
            if (as.a(user.getLocale())) {
                eVar.J(user.getLocale());
            }
            if (as.a(user.getJwtIdToken())) {
                eVar.c(user.getJwtIdToken());
            }
        }
    }

    public static boolean aw(Context context) {
        e i = e.i(context);
        if (!i.bl()) {
            return true;
        }
        String bj = i.bj();
        if (as.isEmpty(bj)) {
            return true;
        }
        List<String> jN = new g(context).jN();
        if (k.b((Collection<?>) jN) == 1) {
            return as.p(bj, jN.get(0));
        }
        return true;
    }

    public static int b(String str, String str2, String str3, String str4) {
        if (as.isEmpty(str3) || (as.o(str, str3) && as.a(str2) && as.isEmpty(str4))) {
            return 100;
        }
        if (as.o(str, str3) && as.o(str2, str4)) {
            return 200;
        }
        if (as.isEmpty(str4)) {
            return (!as.a(str) || !as.a(str2)) ? 500 : 400;
        }
        return 300;
    }

    public static FreshchatUser b(Context context, FreshchatUser freshchatUser) {
        e i = e.i(context);
        freshchatUser.setFirstName(i.bg());
        freshchatUser.setLastName(i.bh());
        freshchatUser.setEmail(i.bi());
        freshchatUser.setPhone(i.bX(), i.bY());
        return freshchatUser;
    }

    public static void b(Context context, User user) {
        try {
            e i = e.i(context);
            ai.d("FRESHCHAT", "Updating user information => " + i.bj());
            a(i, user);
            b.a(context, user);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static User bF(Context context) {
        User user = new User();
        e i = e.i(context);
        if (as.a(i.gh())) {
            user.setJwtIdToken(i.gh());
            return user;
        }
        user.setFirstName(i.bg());
        user.setLastName(i.bh());
        user.setEmail(i.bi());
        user.setPhone(i.bY());
        user.setPhoneCountry(i.bX());
        user.setExternalId(i.bk());
        user.setRestoreId(i.bI());
        user.setLocale(i.bZ());
        return user;
    }

    public static void bG(Context context) {
        aa.a(context, true, false);
    }

    public static Map<String, String> e(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (String next : map.keySet()) {
            boolean z = true;
            boolean z2 = false;
            if (!av.aO(next)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_KEY_LENGTH_ERROR.toString().replace("{{user_property_key_placeholder}}", next).replace("{{user_property_charecter_limit_placeholder}}", String.valueOf(32)));
                z = false;
            }
            String str = map.get(next);
            if (!av.aN(str)) {
                ai.e("FRESHCHAT_WARNING", c.USER_PROPERTY_VALUE_ERROR.toString().replace("{{user_property_key_placeholder}}", next).replace("{{user_property_charecter_limit_placeholder}}", String.valueOf(256)));
            } else {
                z2 = z;
            }
            if (z2) {
                hashMap.put(next, str);
            }
        }
        return hashMap;
    }

    public static int v(String str, String str2) {
        if (as.isEmpty(str2)) {
            return 200;
        }
        String bb = o.bb(str);
        String bb2 = o.bb(str2);
        return as.o(bb, bb2) ? as.p(str, str2) ? 500 : 200 : as.isEmpty(bb2) ? 400 : 300;
    }
}
