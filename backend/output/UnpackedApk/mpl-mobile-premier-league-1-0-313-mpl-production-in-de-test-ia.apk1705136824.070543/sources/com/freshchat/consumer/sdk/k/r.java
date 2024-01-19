package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.a.l.a;
import com.freshchat.consumer.sdk.a.l.b;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarDay.PartOfDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.l.c;
import com.freshchat.consumer.sdk.service.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class r extends a {
    public CalendarMessageMeta calendarMessageMeta;
    public final c rt = new c();
    public AgentAvailabilityResponse ru;
    public List<b> rv;

    public r(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void b(com.freshchat.consumer.sdk.service.c<List<b>> cVar) {
        cVar.b(new com.freshchat.consumer.sdk.service.b(Status.SUCCESS, this.rv));
    }

    /* access modifiers changed from: private */
    public void c(com.freshchat.consumer.sdk.service.c<List<b>> cVar) {
        cVar.b(new com.freshchat.consumer.sdk.service.b(Status.ERROR, null));
    }

    /* access modifiers changed from: private */
    public List<b> jq() {
        ArrayList arrayList = new ArrayList();
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return arrayList;
        }
        Map<String, CalendarDay> processedCalendarDataMap = agentAvailabilityResponse.getProcessedCalendarDataMap();
        if (k.c(processedCalendarDataMap)) {
            return arrayList;
        }
        CalendarDay next = processedCalendarDataMap.values().iterator().next();
        arrayList.add(new a(next.getDay()));
        int i = 0;
        for (Entry next2 : next.getTimeSlotsMap().entrySet()) {
            if (i >= 8) {
                break;
            }
            List list = (List) next2.getValue();
            int b2 = k.b((Collection<?>) list);
            if (b2 > 0) {
                Collections.sort(list);
                if (b2 + i > 8) {
                    list = list.subList(0, 8 - i);
                }
                i += list.size();
            }
            arrayList.add(new l.c((PartOfDay) next2.getKey(), list));
        }
        return arrayList;
    }

    public void a(com.freshchat.consumer.sdk.service.c<List<b>> cVar) {
        if (this.rv != null) {
            b(cVar);
        }
        CalendarMessageMeta calendarMessageMeta2 = this.calendarMessageMeta;
        if (calendarMessageMeta2 == null) {
            c(cVar);
            return;
        }
        this.rt.a(getContext(), calendarMessageMeta2.getCalendarAgentAlias(), (c.a) new s(this, cVar));
    }

    public int getCalendarType() {
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return 0;
        }
        return agentAvailabilityResponse.getCalendarType();
    }

    public String ia() {
        try {
            if (this.ru == null || this.ru.getMeetingLength() <= 0) {
                return "";
            }
            return getContext().getString(R.string.freshchat_calendar_duration).replace(getContext().getString(R.string.freshchat_calendar_duration_place_holder), String.valueOf(((long) this.ru.getMeetingLength()) / 60));
        } catch (Exception e2) {
            q.a(e2);
            return "";
        }
    }

    public ArrayList<b> jp() {
        ArrayList<b> arrayList = new ArrayList<>();
        AgentAvailabilityResponse agentAvailabilityResponse = this.ru;
        if (agentAvailabilityResponse == null) {
            return arrayList;
        }
        Map<String, CalendarDay> processedCalendarDataMap = agentAvailabilityResponse.getProcessedCalendarDataMap();
        if (k.d(processedCalendarDataMap)) {
            for (CalendarDay next : processedCalendarDataMap.values()) {
                arrayList.add(new a(next.getDay()));
                for (Entry next2 : next.getTimeSlotsMap().entrySet()) {
                    Collections.sort((List) next2.getValue());
                    arrayList.add(new l.c((PartOfDay) next2.getKey(), (List) next2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public void jr() {
        CalendarMessageMeta calendarMessageMeta2 = this.calendarMessageMeta;
        String calendarInviteId = calendarMessageMeta2 != null ? calendarMessageMeta2.getCalendarInviteId() : null;
        if (as.a(calendarInviteId)) {
            bg.L(getContext(), calendarInviteId);
        }
    }

    public void setCalendarMessageMeta(CalendarMessageMeta calendarMessageMeta2) {
        this.calendarMessageMeta = calendarMessageMeta2;
    }
}
