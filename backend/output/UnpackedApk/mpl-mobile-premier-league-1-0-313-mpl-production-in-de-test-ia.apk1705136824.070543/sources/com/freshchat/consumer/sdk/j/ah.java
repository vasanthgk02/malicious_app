package com.freshchat.consumer.sdk.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.freshchat.consumer.sdk.b.e;
import java.util.Locale;

public class ah {
    public static boolean aO(Context context) {
        String bv = e.i(context).bv();
        return as.isEmpty(bv) || as.p(bv, bc(context));
    }

    public static boolean aP(Context context) {
        String bE = e.i(context).bE();
        return as.isEmpty(bE) || as.p(bE, bc(context));
    }

    public static boolean aQ(Context context) {
        String bZ = e.i(context).bZ();
        String bc = bc(context);
        if (as.isEmpty(bZ) || as.isEmpty(bc)) {
            return true;
        }
        return as.p(bZ, bc);
    }

    public static String b(Locale locale) {
        return locale == null ? "" : aw.eZ() ? locale.toLanguageTag() : j.a(locale);
    }

    public static void bN(Context context) {
        if (context != null) {
            e.i(context).bN();
            n.ef();
            b.u(context);
        }
    }

    public static Context bU(Context context) {
        Locale bb = bb(context);
        Resources resources = context.getResources();
        Configuration configuration = (resources == null || resources.getConfiguration() == null) ? new Configuration() : resources.getConfiguration();
        Locale.setDefault(configuration.locale);
        configuration.setLocale(bb);
        return context.createConfigurationContext(configuration);
    }

    public static Locale bb(Context context) {
        Locale locale;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                locale = applicationContext.getResources().getConfiguration().locale;
            } catch (Exception e2) {
                q.a(e2);
            } catch (Throwable th) {
                Locale.getDefault();
                throw th;
            }
        } else {
            locale = null;
        }
        if (locale != null) {
            return locale;
        }
        return Locale.getDefault();
    }

    public static String bc(Context context) {
        return b(bb(context));
    }

    @TargetApi(17)
    public static int getTextDirection() {
        return 1;
    }
}
