package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.k;

public class f extends d {
    public static final String TAG = "com.freshchat.consumer.sdk.service.a.f";

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    public void ds() {
        a dt = dt();
        try {
            g gVar = new g(getContext());
            final String dr = dt.dr();
            Message X = gVar.X(dr);
            if (X != null) {
                b.a(getContext(), X, (a) new a() {
                    public void a(k kVar) {
                        if (kVar != null) {
                            try {
                                if (kVar.isSuccess()) {
                                    if (ai.ck()) {
                                        ai.d(f.TAG, "******************");
                                        String str = f.TAG;
                                        ai.d(str, "Upload message success on backlog " + dr + ". Removing entry");
                                        ai.d(f.TAG, "******************");
                                    }
                                    aa.l(f.this.getContext(), dr);
                                    return;
                                }
                            } catch (Exception e2) {
                                q.a(e2);
                                return;
                            }
                        }
                        if (ai.ck()) {
                            ai.d(f.TAG, "XXXXXXXXXXXXXXXXXX");
                            String str2 = f.TAG;
                            ai.d(str2, "Could not upload message on backlog " + dr + ". Keeping the entry");
                            ai.d(f.TAG, "XXXXXXXXXXXXXXXXXX");
                        }
                    }
                });
            }
        } catch (Exception e2) {
            String str = TAG;
            ai.e(str, "Create message failed for backlog " + dt);
            q.a(e2);
        }
    }
}
