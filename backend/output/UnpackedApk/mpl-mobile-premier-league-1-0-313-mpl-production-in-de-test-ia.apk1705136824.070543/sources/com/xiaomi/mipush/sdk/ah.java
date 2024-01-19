package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

public class ah extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ag f4348a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ah(ag agVar, Looper looper) {
        // this.f4348a = agVar;
        super(looper);
    }

    public void dispatchMessage(Message message) {
        ag agVar;
        am amVar;
        HashMap a2;
        ag agVar2;
        am amVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (x.class) {
                if (x.a(ag.a(this.f4348a)).a(str)) {
                    if (x.a(ag.a(this.f4348a)).a(str) < 10) {
                        am amVar3 = am.DISABLE_PUSH;
                        if (i != 0 || !"syncing".equals(x.a(ag.a(this.f4348a)).a(am.DISABLE_PUSH))) {
                            am amVar4 = am.ENABLE_PUSH;
                            if (1 != i || !"syncing".equals(x.a(ag.a(this.f4348a)).a(am.ENABLE_PUSH))) {
                                am amVar5 = am.UPLOAD_HUAWEI_TOKEN;
                                if (2 != i || !"syncing".equals(x.a(ag.a(this.f4348a)).a(am.UPLOAD_HUAWEI_TOKEN))) {
                                    am amVar6 = am.UPLOAD_FCM_TOKEN;
                                    if (3 != i || !"syncing".equals(x.a(ag.a(this.f4348a)).a(am.UPLOAD_FCM_TOKEN))) {
                                        am amVar7 = am.UPLOAD_COS_TOKEN;
                                        if (4 != i || !"syncing".equals(x.a(ag.a(this.f4348a)).a(am.UPLOAD_COS_TOKEN))) {
                                            am amVar8 = am.UPLOAD_FTOS_TOKEN;
                                            if (5 == i && "syncing".equals(x.a(ag.a(this.f4348a)).a(am.UPLOAD_FTOS_TOKEN))) {
                                                agVar = this.f4348a;
                                                amVar = am.UPLOAD_FTOS_TOKEN;
                                                a2 = g.a(ag.a(this.f4348a), c.ASSEMBLE_PUSH_FTOS);
                                            }
                                            x.a(ag.a(this.f4348a)).b(str);
                                        } else {
                                            agVar = this.f4348a;
                                            amVar = am.UPLOAD_COS_TOKEN;
                                            a2 = g.a(ag.a(this.f4348a), c.ASSEMBLE_PUSH_COS);
                                        }
                                    } else {
                                        agVar = this.f4348a;
                                        amVar = am.UPLOAD_FCM_TOKEN;
                                        a2 = g.a(ag.a(this.f4348a), c.ASSEMBLE_PUSH_FCM);
                                    }
                                } else {
                                    agVar = this.f4348a;
                                    amVar = am.UPLOAD_HUAWEI_TOKEN;
                                    a2 = g.a(ag.a(this.f4348a), c.ASSEMBLE_PUSH_HUAWEI);
                                }
                                agVar.a(str, amVar, false, a2);
                                x.a(ag.a(this.f4348a)).b(str);
                            } else {
                                agVar2 = this.f4348a;
                                amVar2 = am.ENABLE_PUSH;
                            }
                        } else {
                            agVar2 = this.f4348a;
                            amVar2 = am.DISABLE_PUSH;
                        }
                        agVar2.a(str, amVar2, true, (HashMap<String, String>) null);
                        x.a(ag.a(this.f4348a)).b(str);
                    } else {
                        x.a(ag.a(this.f4348a)).c(str);
                    }
                }
            }
        }
    }
}
