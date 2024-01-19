package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.ci;
import com.freshchat.consumer.sdk.k.l;
import com.freshchat.consumer.sdk.k.l.a;

public class CalendarEventCardView extends CardView {
    public TextView oZ;
    public l pK;
    public View pL;
    public TextView pM;

    public CalendarEventCardView(Context context) {
        super(context);
        cg(context);
    }

    public CalendarEventCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cg(context);
    }

    public CalendarEventCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cg(context);
    }

    private void cg(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.freshchat_calendar_event_card_view, this, false);
        this.pL = inflate;
        addView(inflate);
        this.pM = (TextView) this.pL.findViewById(R.id.freshchat_calendar_event_card_confirmation);
        this.oZ = (TextView) this.pL.findViewById(R.id.freshchat_calendar_event_card_duration);
    }

    private void hW() {
        new ci().a(this.pL, this.pK, R.dimen.freshchat_calendar_event_card_avatar_size);
        a hZ = this.pK.hZ();
        this.pM.setCompoundDrawablesWithIntrinsicBounds(aq.j(getContext(), a(hZ)), 0, 0, 0);
        this.pM.setText(b(hZ));
        this.oZ.setText(this.pK.ia());
    }

    public int a(a aVar) {
        int i = d.pN[aVar.ordinal()];
        return i != 1 ? i != 2 ? R.attr.freshchatCalendarEventPendingIcon : R.attr.freshchatCalendarEventScheduledIcon : R.attr.freshchatCalendarEventFailedIcon;
    }

    public int b(a aVar) {
        int i = d.pN[aVar.ordinal()];
        return i != 1 ? i != 2 ? R.string.freshchat_calendar_meeting_state_pending : R.string.freshchat_calendar_meeting_state_scheduled : R.string.freshchat_calendar_meeting_state_failed;
    }

    public void setCalendarTimeSlotMessageViewModel(l lVar) {
        this.pK = lVar;
        hW();
    }
}
