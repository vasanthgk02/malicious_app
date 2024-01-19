package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.m.a.C0029a;

public class f extends y {
    public CalendarMessageMeta calendarMessageMeta;
    public String oY;
    public TextView oZ;
    public a pa;

    public interface a {
        void b(CalendarMessageMeta calendarMessageMeta);

        void b(CalendarMessageMeta calendarMessageMeta, TimeSlot timeSlot, int i);
    }

    public static f a(int i, CalendarMessageMeta calendarMessageMeta2, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putInt("Orientation", i);
        bundle.putParcelable("MessageMeta", calendarMessageMeta2);
        bundle.putString("AgentProfilePicUrl", str);
        fVar.setArguments(bundle);
        return fVar;
    }

    private void g(View view) {
        this.oZ = (TextView) view.findViewById(R.id.freshchat_calendar_dialog_duration_textview);
        ((ImageView) view.findViewById(R.id.freshchat_calendar_cancel_invite_imageview)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    public void hN() {
        if (getActivity() != null) {
            Builder m = i.m(getActivity());
            m.P.mMessage = getString(R.string.freshchat_calendar_cancel_booking_prompt_message);
            m.setPositiveButton(R.string.freshchat_calendar_cancel_booking_prompt_cancel, (OnClickListener) new h(this));
            m.setNegativeButton(R.string.freshchat_calendar_cancel_booking_prompt_continue, (OnClickListener) new i(this));
            AlertDialog create = m.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    private boolean hO() {
        return getChildFragmentManager().findFragmentByTag("Calendar") instanceof a;
    }

    public void a(TimeSlot timeSlot, int i) {
        a aVar = this.pa;
        if (aVar != null) {
            aVar.b(this.calendarMessageMeta, timeSlot, i);
        }
        dismiss();
    }

    public void a(C0029a aVar, Bundle bundle) {
        try {
            a aVar2 = (a) aVar.hE().newInstance();
            if (bundle != null) {
                aVar2.setArguments(bundle);
            }
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (hO()) {
                beginTransaction.setCustomAnimations(R.anim.freshchat_slide_in_right, R.anim.freshchat_slide_out_left);
                beginTransaction.replace(R.id.freshchat_calendar_child_fragment_container, (Fragment) aVar2, (String) "Calendar");
                beginTransaction.addToBackStack(null);
            } else {
                beginTransaction.add(R.id.freshchat_calendar_child_fragment_container, (Fragment) aVar2, (String) "Calendar");
            }
            beginTransaction.commit();
        } catch (Exception | IllegalAccessException | InstantiationException e2) {
            q.a(e2);
        }
    }

    public void bo(String str) {
        if (as.a(str)) {
            this.oZ.setText(str);
            this.oZ.setVisibility(0);
        }
    }

    public CalendarMessageMeta getCalendarMessageMeta() {
        return this.calendarMessageMeta;
    }

    public void hK() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                if (arguments.containsKey("Orientation")) {
                    setOrientation(arguments.getInt("Orientation"));
                }
                this.calendarMessageMeta = (CalendarMessageMeta) arguments.getParcelable("MessageMeta");
                this.oY = arguments.getString("AgentProfilePicUrl");
            } catch (Exception e2) {
                q.a(e2);
                dismiss();
            }
        }
    }

    public String hL() {
        return this.oY;
    }

    public void hM() {
        a aVar = this.pa;
        if (aVar != null) {
            aVar.b(this.calendarMessageMeta);
        }
        dismiss();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity instanceof a) {
            this.pa = (a) activity;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hK();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_fragment_calendar_bottomsheet_dialog, viewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
        this.pa = null;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (getActivity() != null) {
            i.a(getContext(), getActivity().getCurrentFocus());
        }
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(view);
        if (!hO()) {
            a(C0029a.CALENDAR_EMAIL_ENTRY_FRAGMENT, (Bundle) null);
        }
    }
}
