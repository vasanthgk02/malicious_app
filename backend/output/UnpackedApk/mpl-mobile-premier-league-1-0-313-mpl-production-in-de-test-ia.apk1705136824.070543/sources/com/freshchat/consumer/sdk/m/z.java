package com.freshchat.consumer.sdk.m;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.widget.FrameLayout;
import com.freshchat.consumer.sdk.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class z implements OnShowListener {
    public final /* synthetic */ BottomSheetDialog ln;
    public final /* synthetic */ y pw;

    public z(y yVar, BottomSheetDialog bottomSheetDialog) {
        this.pw = yVar;
        this.ln = bottomSheetDialog;
    }

    public void onShow(DialogInterface dialogInterface) {
        this.pw.pq = (FrameLayout) this.ln.findViewById(R.id.design_bottom_sheet);
        if (this.pw.pq != null) {
            View findViewById = this.ln.findViewById(R.id.freshchat_calendar_bottomsheet_title_layout);
            if (findViewById != null) {
                this.pw.pt = findViewById.getHeight();
            }
            BottomSheetBehavior from = BottomSheetBehavior.from(this.pw.pq);
            from.skipCollapsed = true;
            from.setPeekHeight(0);
            from.setState(3);
        }
    }
}
