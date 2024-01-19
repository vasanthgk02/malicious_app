package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.k.p;

public class ci {
    private void a(ImageView imageView, String str) {
        if (as.a(str)) {
            FreshchatImageLoaderRequest dM = new a(str).a(imageView.getWidth(), imageView.getHeight()).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                eK.load(dM, imageView);
            }
        }
    }

    public void a(View view, p pVar, int i) {
        Context context = view.getContext();
        ImageView imageView = (ImageView) view.findViewById(R.id.freshchat_calendar_agent_avatar);
        View findViewById = view.findViewById(R.id.freshchat_calendar_avatars_container);
        imageView.bringToFront();
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = ((context.getResources().getDimensionPixelSize(i) * 90) / 100) * 2;
        findViewById.setLayoutParams(layoutParams);
        ((TextView) view.findViewById(R.id.freshchat_calendar_timeslot_view)).setText(pVar.ii());
        ((TextView) view.findViewById(R.id.freshchat_calendar_day_label)).setText(pVar.ij());
        if (pVar.ik()) {
            a(imageView, pVar.hL());
            return;
        }
        int a2 = aq.a(context, R.attr.freshchatTeamMemberAvatarIcon, false);
        if (a2 > 0) {
            imageView.setImageResource(a2);
        }
    }
}
