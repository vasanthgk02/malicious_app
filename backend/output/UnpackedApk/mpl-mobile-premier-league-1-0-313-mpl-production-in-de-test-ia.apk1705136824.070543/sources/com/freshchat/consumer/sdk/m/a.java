package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.q;

public abstract class a extends Fragment {

    /* renamed from: com.freshchat.consumer.sdk.m.a$a  reason: collision with other inner class name */
    public enum C0029a {
        CALENDAR_EMAIL_ENTRY_FRAGMENT(j.class),
        CALENDAR_LIMITED_TIMESLOTS_VIEW_FRAGMENT(n.class),
        CALENDAR_ALL_TIMESLOTS_VIEW_FRAGMENT(d.class),
        CALENDAR_TIMESLOT_CONFIRMATION_FRAGMENT(t.class);
        
        public final Class oR;

        /* access modifiers changed from: public */
        C0029a(Class cls) {
            this.oR = cls;
        }

        public Class hE() {
            return this.oR;
        }
    }

    public void a(C0029a aVar) {
        a(aVar, null);
    }

    public void a(C0029a aVar, Bundle bundle) {
        f hB = hB();
        if (hB != null) {
            hB.a(aVar, bundle);
        } else {
            q.a(new Exception("Fragment load failed. Parent CalendarBottomSheetDialogFragment is null "));
        }
    }

    public abstract void cc(Context context);

    public CalendarMessageMeta getCalendarMessageMeta() {
        f hB = hB();
        if (hB != null) {
            return hB.getCalendarMessageMeta();
        }
        return null;
    }

    public f hB() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof f) {
            return (f) parentFragment;
        }
        return null;
    }

    public String hC() {
        f hB = hB();
        if (hB != null) {
            return hB.hL();
        }
        return null;
    }

    public int hD() {
        f hB = hB();
        return hB != null ? hB.getOrientation() : getResources().getConfiguration().orientation;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        cc(context);
    }
}
