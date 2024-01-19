package com.freshchat.consumer.sdk.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.h;

public class b implements OnTouchListener {
    public static final String TAG = b.class.getName();
    public h ax;
    public boolean eJ;
    public Context eK;
    public long startTime;

    public b(Context context, h hVar) {
        this.eK = context;
        this.ax = hVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eJ) {
                return true;
            }
            this.ax.startRecording();
            this.startTime = System.currentTimeMillis();
        } else if (motionEvent.getAction() == 1) {
            if (this.eJ) {
                this.eJ = false;
            } else {
                boolean z = System.currentTimeMillis() - this.startTime < 750;
                this.eJ = z;
                if (z) {
                    Toast.makeText(this.eK, "Hold to record, release to send, swipe away to cancel", 1).show();
                    this.ax.eh();
                    return true;
                }
                this.eJ = false;
                view.playSoundEffect(0);
                if (i.a(view, motionEvent)) {
                    this.ax.ei();
                }
            }
            this.ax.eh();
        }
        return true;
    }
}
