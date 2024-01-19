package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd;
import com.xiaomi.push.de;
import com.xiaomi.push.dg;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.k;
import java.util.ArrayList;
import java.util.List;

public class au {
    public static int a(at atVar, dc dcVar) {
        int i = 1;
        if (av.f4874a[dcVar.ordinal()] != 1) {
            i = 0;
        }
        return atVar.a(dcVar, i);
    }

    public static List<Pair<Integer, Object>> a(List<dg> list, boolean z) {
        if (k.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (dg next : list) {
            int a2 = next.a();
            dd a3 = dd.a(next.b());
            if (a3 != null) {
                if (!z || !next.f464a) {
                    int i = av.f4875b[a3.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a2), Boolean.valueOf(next.g())) : new Pair(Integer.valueOf(a2), next.a()) : new Pair(Integer.valueOf(a2), Long.valueOf(next.a())) : new Pair(Integer.valueOf(a2), Integer.valueOf(next.c())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a2), null));
                }
            }
        }
        return arrayList;
    }

    public static void a(at atVar, dr drVar) {
        atVar.a(a(drVar.a(), true));
        atVar.b();
    }

    public static void a(at atVar, ds dsVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (de next : dsVar.a()) {
            arrayList.add(new Pair(next.a(), Integer.valueOf(next.a())));
            List<Pair<Integer, Object>> a2 = a(next.f456a, false);
            if (!k.a(a2)) {
                arrayList2.addAll(a2);
            }
        }
        atVar.a((List<Pair<dc, Integer>>) arrayList, (List<Pair<Integer, Object>>) arrayList2);
        atVar.b();
    }
}
