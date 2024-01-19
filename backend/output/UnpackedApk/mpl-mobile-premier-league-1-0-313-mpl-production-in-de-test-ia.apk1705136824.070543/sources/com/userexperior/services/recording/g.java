package com.userexperior.services.recording;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4234a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final f f4235b;

    public g(f fVar) {
        this.f4235b = fVar;
    }

    public void handleMessage(Message message) {
        if (message.what == 234119) {
            f fVar = this.f4235b;
            if (fVar != null) {
                int i = message.arg1;
                Handler handler = fVar.f4140c;
                if (handler != null) {
                    handler.post(new Runnable(i) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f4197a;

                        {
                            this.f4197a = r2;
                        }

                        public final void run() {
                            synchronized (this) {
                                if (f.this.B < this.f4197a) {
                                    f.this.B = this.f4197a;
                                    f.this.o = (long) (this.f4197a * 200);
                                    f.this.p = SystemClock.uptimeMillis();
                                }
                            }
                        }
                    });
                }
            }
        }
        super.handleMessage(message);
    }
}
