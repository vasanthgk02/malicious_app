package com.freshchat.consumer.sdk.b;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;

public class f {
    public static ActionBar j(Context context) {
        try {
            Class.forName("androidx.appcompat.widget.Toolbar");
            View findViewById = ((Activity) context).findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) findViewById;
                View inflate = LayoutInflater.from(context).inflate(R.layout.freshchat_toolbar, null);
                if (inflate != null) {
                    if (inflate.findViewById(R.id.freshchat_material_toolbar) instanceof Toolbar) {
                        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.freshchat_material_toolbar);
                        LayoutParams layoutParams = new LayoutParams(-1, -2, 49);
                        layoutParams.setMargins(0, 0, 0, 0);
                        inflate.setLayoutParams(layoutParams);
                        frameLayout.addView(inflate);
                        View childAt = frameLayout.getChildAt(0);
                        if (childAt != null) {
                            int paddingLeft = childAt.getPaddingLeft();
                            int paddingRight = childAt.getPaddingRight();
                            int paddingTop = childAt.getPaddingTop();
                            Context context2 = context;
                            i.a(context2, childAt, paddingLeft, paddingTop + af.b(context, (float) 56), paddingRight, childAt.getPaddingBottom());
                        }
                        if (toolbar != null) {
                            ((AppCompatActivity) context).setSupportActionBar(toolbar);
                        }
                    }
                }
                ai.e("FRESHCHAT_WARNING", "Toolbar Missing ! Did you uncomment the toolbar widget in layout/freshchat_toolbar.xml and remove the dummy view ?");
                return null;
            }
            return ((AppCompatActivity) context).getSupportActionBar();
        } catch (ClassNotFoundException e2) {
            ai.e("FRESHCHAT_WARNING", "Failed to setup Toolbar based ActionBar", e2);
            return null;
        }
    }
}
