package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.cz;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;

public class bt {
    public static ef a(Context context, dq dqVar) {
        if (dqVar.b()) {
            return null;
        }
        byte[] a2 = dqVar.a();
        ef a3 = a(dqVar.a(), dqVar.f584b);
        if (a3 != null) {
            ee.a(a3, a2);
        }
        return a3;
    }

    public static ef a(cz czVar, boolean z) {
        switch (bu.f4926a[czVar.ordinal()]) {
            case 1:
                return new dv();
            case 2:
                return new eb();
            case 3:
                return new dz();
            case 4:
                return new ed();
            case 5:
                return new dx();
            case 6:
                return new dl();
            case 7:
                return new dp();
            case 8:
                return new dw();
            case 9:
                if (z) {
                    return new dt();
                }
                dm dmVar = new dm();
                dmVar.a(true);
                return dmVar;
            case 10:
                return new dp();
            default:
                return null;
        }
    }
}
