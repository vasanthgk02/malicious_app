package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.Message;

public class cj {

    public interface a {
        void p(Message message);

        void q(Message message);
    }

    public static View a(Context context, ViewGroup viewGroup, Message message, a aVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.freshchat_calendar_invite_options, viewGroup, false);
        a(inflate, message, aVar);
        return inflate;
    }

    public static void a(View view, Message message, a aVar) {
        ((Button) view.findViewById(R.id.freshchat_calendar_find_slot_button)).setOnClickListener(new ck(aVar, message));
        ((TextView) view.findViewById(R.id.freshchat_calendar_not_interested_textview)).setOnClickListener(new cl(aVar, message));
    }
}
