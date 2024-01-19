package com.freshchat.consumer.sdk.e;

import android.content.Context;
import com.freshchat.consumer.sdk.b.a.a;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.exception.AppDeletedException;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.exception.UserDeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.l;

public class f {
    public static void ar(String str) throws UserDeletedException, AppDeletedException {
        if (as.a(str)) {
            a aVar = new a(str);
            if (!aVar.cn()) {
                return;
            }
            if (aVar.db()) {
                throw new UserDeletedException();
            } else if (aVar.fJ()) {
                throw new AppDeletedException();
            }
        }
    }

    public static void bV(Context context) {
        d.b(context, new l(y.aG(context)));
    }

    public static void o(Context context, String str) throws DeletedException {
        try {
            ar(str);
        } catch (UserDeletedException unused) {
            aa.a(context, false, true);
            com.freshchat.consumer.sdk.b.a.W(context);
            throw new DeletedException();
        } catch (AppDeletedException unused2) {
            e i = e.i(context);
            l lVar = new l(y.aG(context));
            aa.aK(context);
            y.a(context, lVar);
            i.setAccountActive(false);
            i.bA();
            com.freshchat.consumer.sdk.b.a.W(context);
            throw new DeletedException();
        }
    }
}
