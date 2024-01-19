package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class bg {

    public static class a {
        public EventName eventName;
        public Map<Property, Object> properties;

        public a(EventName eventName2) {
            this.properties = new HashMap();
            this.eventName = eventName2;
        }

        public /* synthetic */ a(EventName eventName2, bh bhVar) {
            this(eventName2);
        }

        /* access modifiers changed from: private */
        public a a(Property property, Object obj) {
            if (property == null) {
                ai.e("FRESHCHAT_WARNING", "property can not be null for Event::Builder::addProperty()");
                return this;
            }
            if (obj == null || ((obj instanceof String) && as.isEmpty(obj.toString()))) {
                ai.e("FRESHCHAT_WARNING", "value can not be null/empty for Event::Builder::addProperty()");
                return this;
            }
            this.properties.put(property, obj);
            return this;
        }

        /* access modifiers changed from: private */
        public Event gz() {
            Event event = new Event();
            event.setEventName(this.eventName);
            event.setProperties(this.properties);
            return event;
        }
    }

    public interface b {
        Event gy();
    }

    public static Category A(Context context, String str) {
        if (y.cp(context)) {
            return null;
        }
        return new i(context).Y(str);
    }

    public static void J(Context context, String str) {
        a(context, EventName.FCEventCalendarFindTimeSlotClick, str);
    }

    public static void K(Context context, String str) {
        a(context, EventName.FCEventCalendarInviteCancel, str);
    }

    public static void L(Context context, String str) {
        a(context, EventName.FCEventCalendarNoTimeSlotFound, str);
    }

    public static void M(Context context, String str) {
        a(context, EventName.FCEventCalendarBookingSuccess, str);
    }

    public static void N(Context context, String str) {
        a(context, EventName.FCEventCalendarBookingRetry, str);
    }

    public static void O(Context context, String str) {
        a(context, EventName.FCEventCalendarBookingFailure, str);
    }

    public static Bundle a(Event event) {
        Bundle bundle = new Bundle();
        bundle.putString("event_name", event.getEventName().getName());
        for (Entry next : event.getProperties().entrySet()) {
            try {
                if (next.getValue() instanceof String) {
                    bundle.putString(((Property) next.getKey()).getName(), next.getValue().toString());
                } else if (next.getValue() instanceof Long) {
                    bundle.putLong(((Property) next.getKey()).getName(), ((Long) next.getValue()).longValue());
                } else if (next.getValue() instanceof Integer) {
                    bundle.putInt(((Property) next.getKey()).getName(), ((Integer) next.getValue()).intValue());
                } else if (next.getValue() instanceof Boolean) {
                    bundle.putBoolean(((Property) next.getKey()).getName(), ((Boolean) next.getValue()).booleanValue());
                } else {
                    ai.e("FRESHCHAT", "Error bundling Value of Property " + ((Property) next.getKey()).getName());
                }
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error bundling Value of Property ");
                outline73.append(((Property) next.getKey()).getName());
                outline73.append("\n");
                outline73.append(e2.toString());
                ai.e("FRESHCHAT", outline73.toString());
            }
        }
        return bundle;
    }

    public static a a(EventName eventName) {
        return new a(eventName, null);
    }

    public static void a(Context context, long j, boolean z, int i, String str) {
        bw bwVar = new bw(context, j, z, i, str);
        a(context, (b) bwVar);
    }

    public static void a(Context context, long j, String[] strArr) {
        a(context, (b) new bu(context, j, strArr));
    }

    public static void a(Context context, Uri uri) {
        a(context, (b) new bj(uri));
    }

    public static void a(Context context, EventName eventName) {
        a(context, (b) new da(eventName));
    }

    public static void a(Context context, EventName eventName, String str) {
        a(context, (b) new cz(eventName, str));
    }

    public static void a(Context context, CarouselCardDefaultFragment carouselCardDefaultFragment) {
        a(context, (b) new ce(carouselCardDefaultFragment));
    }

    public static void a(Context context, QuickReplyButtonFragment quickReplyButtonFragment) {
        a(context, (b) new bo(quickReplyButtonFragment));
    }

    public static void a(Context context, b bVar) {
        be.eC().gx().execute(new dc(context, bVar));
    }

    public static void a(Context context, String str, int i, boolean z) {
        a(context, (b) new bs(str, i, z));
    }

    public static void a(Context context, String str, String str2, String str3) {
        a(context, (b) new bl(str, str2, str3));
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        bh bhVar = new bh(str2, str4, z, context, str, str3);
        a(context, (b) bhVar);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String[] strArr) {
        bk bkVar = new bk(str4, str2, context, str, str3, strArr);
        a(context, (b) bkVar);
    }

    public static void a(Context context, String str, String str2, String[] strArr) {
        a(context, (b) new bq(str2, context, str, strArr));
    }

    public static void b(Context context, CarouselCardDefaultFragment carouselCardDefaultFragment) {
        a(context, (b) new cr(carouselCardDefaultFragment));
    }

    public static void bK(Context context) {
        a(context, EventName.FCEventMessageReceive);
    }

    public static void bL(Context context) {
        a(context, EventName.FCEventScreenView);
    }

    public static void bM(Context context) {
        a(context, EventName.FCEventIdTokenStatusChange);
    }

    public static void bY(Context context) {
        a(context, EventName.FCEventDropDownShow);
    }

    public static void bZ(Context context) {
        a(context, EventName.FCEventCarouselShow);
    }

    public static Conversation c(Context context, long j) {
        return new e(context).f(j);
    }

    public static void c(Context context, long j, long j2) {
        bv bvVar = new bv(j2, context, j);
        a(context, (b) bvVar);
    }

    public static void c(Context context, String[] strArr) {
        a(context, (b) new br(strArr));
    }

    public static void d(Context context, long j, long j2) {
        bi biVar = new bi(j2, context, j);
        a(context, (b) biVar);
    }

    public static void d(Context context, String[] strArr) {
        a(context, (b) new bt(strArr));
    }

    public static Event e(Bundle bundle) throws IllegalArgumentException {
        EventName eventName = EventName.get(bundle);
        if (eventName == null) {
            ai.e("FRESHCHAT_WARNING", "event_name missing in Event::fromBundle()");
            return null;
        }
        Bundle bundle2 = (Bundle) bundle.clone();
        bundle2.remove("event_name");
        HashMap hashMap = new HashMap();
        for (String str : bundle2.keySet()) {
            Property property = Property.get(str);
            if (property == null) {
                ai.e("FRESHCHAT", "Could not find eventName property - " + str);
            } else {
                hashMap.put(property, bundle2.get(str));
            }
        }
        Event event = new Event();
        event.setEventName(eventName);
        event.setProperties(hashMap);
        return event;
    }

    public static void f(Context context, boolean z) {
        a(context, (b) new cu(z));
    }

    public static Channel j(Context context, long j) {
        return new c(context).e(j);
    }

    public static void k(Context context, long j) {
        a(context, (b) new bx(context, j));
    }

    public static void l(Context context, long j) {
        a(context, (b) new bn(context, j));
    }

    public static void l(Context context, String str, String str2) {
        a(context, (b) new bp(str, str2));
    }

    public static void y(Context context, String str) {
        a(context, (b) new bm(str));
    }

    public static Article z(Context context, String str) {
        if (y.cp(context)) {
            return null;
        }
        return new i(context).ab(str);
    }
}
