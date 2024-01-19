package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.a.l.a;
import com.freshchat.consumer.sdk.a.l.b;
import com.freshchat.consumer.sdk.a.l.c;
import com.freshchat.consumer.sdk.beans.CalendarDay.PartOfDay;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import java.util.ArrayList;
import java.util.List;

public class m extends a {
    public b qk;

    public m(Context context) {
        super(context);
    }

    public void a(b bVar) {
        this.qk = bVar;
    }

    public String ib() {
        b bVar = this.qk;
        if (bVar != null && (bVar instanceof a)) {
            a aVar = (a) bVar;
            if (as.a(aVar.hw())) {
                return n.I(getContext(), aVar.hw());
            }
        }
        return "";
    }

    public String ic() {
        b bVar = this.qk;
        if (bVar != null && (bVar instanceof c)) {
            PartOfDay hy = ((c) bVar).hy();
            if (hy != null) {
                return getContext().getString(hy.getStringResId());
            }
        }
        return "";
    }

    public List<TimeSlot> id() {
        ArrayList arrayList = new ArrayList();
        b bVar = this.qk;
        if (bVar != null && (bVar instanceof c)) {
            List<TimeSlot> hz = ((c) bVar).hz();
            if (k.a(hz)) {
                arrayList.addAll(hz);
            }
        }
        return arrayList;
    }
}
