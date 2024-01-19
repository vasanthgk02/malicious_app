package io.hansel.ujmtracker.m;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<f> f5386a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, f> f5387b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f5388c = null;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == -2) {
                    removeMessages(-2);
                    g.this.a(true);
                } else if (i == 0 || i == 1) {
                    removeMessages(0);
                    g.this.a(false);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        NetworkInfo a2 = b.a(a.c().a());
        int i = 0;
        if (a2 != null && a2.isConnectedOrConnecting()) {
            while (i < this.f5386a.size()) {
                if (!this.f5386a.get(i).a(z) || z) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public Handler a() {
        if (this.f5388c == null) {
            HandlerThread handlerThread = new HandlerThread("Notification handler");
            handlerThread.start();
            this.f5388c = new a(handlerThread.getLooper());
        }
        return this.f5388c;
    }

    public f a(String str) {
        return this.f5387b.get(str);
    }

    public boolean a(f fVar, String str) {
        int i = 0;
        if (a(str) != null) {
            return false;
        }
        this.f5387b.put(str, fVar);
        if (this.f5386a.size() > 0) {
            int d2 = fVar.a().d();
            int size = this.f5386a.size() - 1;
            int i2 = size;
            while (true) {
                if (i >= size) {
                    size = i2;
                    break;
                }
                i2 = (i + size) / 2;
                if (d2 <= this.f5386a.get(i2).a().d()) {
                    size = i2;
                } else if (i != i2) {
                    i = i2;
                } else if (d2 > this.f5386a.get(size).a().d()) {
                    size++;
                }
            }
            this.f5386a.add(size, fVar);
        } else {
            this.f5386a.add(fVar);
        }
        return true;
    }
}
