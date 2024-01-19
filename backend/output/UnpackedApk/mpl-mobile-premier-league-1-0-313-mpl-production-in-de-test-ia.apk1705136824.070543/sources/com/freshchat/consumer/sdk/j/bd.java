package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.UnsupportedFragmentConfig;

public class bd {
    public static void a(Context context, UnsupportedFragmentConfig unsupportedFragmentConfig) {
        if (context != null) {
            try {
                e.i(context).bh(new ab().toJson(unsupportedFragmentConfig));
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static UnsupportedFragmentConfig bI(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String gm = e.i(context).gm();
            if (as.a(gm)) {
                return (UnsupportedFragmentConfig) new ab().fromJson(gm, UnsupportedFragmentConfig.class);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return null;
    }
}
