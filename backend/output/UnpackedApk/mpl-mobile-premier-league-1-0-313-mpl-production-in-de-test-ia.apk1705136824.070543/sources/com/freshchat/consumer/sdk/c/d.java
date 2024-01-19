package com.freshchat.consumer.sdk.c;

import android.content.Context;
import android.database.Cursor;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.j.q;
import java.util.List;
import java.util.Map;

public class d extends b {
    public final Context context;

    public d(Context context2) {
        super(context2);
        this.context = context2;
    }

    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void bW() {
        try {
            cs().beginTransaction();
            c cVar = new c(this.context);
            List<Channel> gn = cVar.gn();
            super.v(false);
            cVar.a(gn, (List<Tag>) null);
            cs().setTransactionSuccessful();
        } catch (Exception e2) {
            q.a(e2);
        } catch (Throwable th) {
            cs().endTransaction();
            throw th;
        }
        cs().endTransaction();
        a.g(this.context);
    }

    public void cx() {
        super.ct();
    }

    public void iR() {
        try {
            super.iQ();
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
