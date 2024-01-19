package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarDay.PartOfDay;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarTimeSlot;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class ch {
    public static Map<String, CalendarDay> a(TimeZone timeZone, AgentAvailabilityResponse agentAvailabilityResponse) {
        TreeMap treeMap = new TreeMap();
        List<CalendarTimeSlot> calendarTimeSlots = agentAvailabilityResponse.getCalendarTimeSlots();
        if (k.a(calendarTimeSlots)) {
            for (CalendarTimeSlot a2 : calendarTimeSlots) {
                a(a2, timeZone, agentAvailabilityResponse.getMeetingLength(), treeMap);
            }
        }
        return treeMap;
    }

    public static void a(CalendarTimeSlot calendarTimeSlot, TimeZone timeZone, int i, Map<String, CalendarDay> map) {
        Calendar a2 = co.a(timeZone, calendarTimeSlot.getFrom());
        a(a2);
        Calendar a3 = co.a(timeZone, calendarTimeSlot.getTo());
        long j = ((long) i) * 1000;
        while (true) {
            long timeInMillis = a2.getTimeInMillis() + j;
            if (timeInMillis <= a3.getTimeInMillis()) {
                a(map, a2, timeInMillis);
                co.a(a2, i);
            } else {
                return;
            }
        }
    }

    public static void a(Calendar calendar) {
        if (calendar != null) {
            long timeInMillis = calendar.getTimeInMillis();
            long j = timeInMillis % 900000;
            if (j > 0) {
                calendar.setTimeInMillis((900000 - j) + timeInMillis);
            }
        }
    }

    public static void a(Map<String, CalendarDay> map, Calendar calendar, long j) {
        String c2 = n.c(calendar);
        if (c2 != null) {
            int i = calendar.get(11);
            TimeSlot timeSlot = new TimeSlot(calendar.getTimeInMillis(), j);
            CalendarDay calendarDay = map.get(c2);
            if (calendarDay == null) {
                calendarDay = new CalendarDay(c2);
            }
            PartOfDay partOfDay = PartOfDay.getPartOfDay(i);
            if (partOfDay != null) {
                List list = calendarDay.getTimeSlotsMap().get(partOfDay);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(timeSlot);
                calendarDay.getTimeSlotsMap().put(partOfDay, list);
            }
            map.put(c2, calendarDay);
        }
    }
}
