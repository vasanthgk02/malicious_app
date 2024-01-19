package co.hyperverge.hvcamera.d;

import android.content.Context;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import co.hyperverge.hvcamera.HVMagicView.SensorCallback;
import co.hyperverge.hvcamera.magicfilter.camera.CameraEngine;
import java.util.ArrayList;

public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public boolean f2900b = false;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f2901c;

    /* renamed from: d  reason: collision with root package name */
    public SensorCallback f2902d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<Float>> f2903e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Long> f2904f;
    public ArrayList<Float> g;
    public int h;
    public long i = 1000;
    public float j = 0.325f;
    public Handler k = new Handler();
    public Runnable l = new C0049a();
    public Runnable m = new b();
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public Long r;
    public Long s;

    /* renamed from: co.hyperverge.hvcamera.d.a$a  reason: collision with other inner class name */
    public class C0049a implements Runnable {
        public C0049a() {
        }

        public void run() {
            a.this.q = true;
            if (CameraEngine.f2908a) {
                co.hyperverge.hvcamera.magicfilter.camera.b.a((Object) null);
            } else {
                co.hyperverge.hvcamera.magicfilter.camera.a.a((AutoFocusCallback) null);
            }
            a aVar = a.this;
            aVar.f2900b = false;
            SensorCallback sensorCallback = aVar.f2902d;
            if (sensorCallback != null) {
                sensorCallback.onSensorCallback();
            }
            a aVar2 = a.this;
            aVar2.q = false;
            aVar2.k.removeMessages(0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a.this.q = false;
        }
    }

    static {
        Class<a> cls = a.class;
    }

    public a(Context context, int i2) {
        super(context);
        SensorManager sensorManager = this.f2907a;
        if (sensorManager != null) {
            this.f2901c = sensorManager.getDefaultSensor(1);
        } else {
            this.o = false;
        }
        if (this.f2901c != null) {
            this.o = true;
        }
        if (i2 > 15) {
            this.h = 15;
        } else {
            this.h = i2;
        }
        this.f2903e = new ArrayList<>(3);
        this.g = new ArrayList<>(3);
        for (int i3 = 0; i3 < 3; i3++) {
            this.f2903e.add(i3, new ArrayList(this.h));
            for (int i4 = 0; i4 < this.h; i4++) {
                this.f2903e.get(i3).add(i4, Float.valueOf(0.0f));
            }
            this.g.add(i3, Float.valueOf(0.0f));
        }
        this.f2904f = new ArrayList<>();
    }

    public void a() {
        if (this.o && !this.n) {
            this.f2907a.registerListener(this, this.f2901c, 3);
            this.n = true;
        }
    }

    public void b() {
        if (this.n && this.o) {
            this.f2907a.unregisterListener(this, this.f2901c);
            this.n = false;
            this.p = false;
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (!this.p) {
            this.r = Long.valueOf(sensorEvent.timestamp);
            this.s = Long.valueOf(System.currentTimeMillis());
            this.p = true;
        }
        Long valueOf = Long.valueOf(this.s.longValue() + ((long) Math.round((float) ((sensorEvent.timestamp - this.r.longValue()) / 1000000))));
        if (type == 1) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                ArrayList<Float> arrayList = this.g;
                arrayList.set(i2, Float.valueOf(((sensorEvent.values[i2] - ((Float) this.f2903e.get(i2).get(0)).floatValue()) / ((float) this.h)) + arrayList.get(i2).floatValue()));
            }
            float[] fArr = sensorEvent.values;
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.f2903e.get(i3).add(Float.valueOf(fArr[i3]));
                if (this.f2903e.get(i3).size() > this.h) {
                    this.f2903e.get(i3).remove(0);
                }
            }
            this.f2904f.add(valueOf);
            if (this.f2904f.size() > this.h) {
                this.f2904f.remove(0);
            }
            if (this.f2904f.size() == this.h && valueOf.longValue() - this.s.longValue() >= this.i && this.f2900b) {
                System.currentTimeMillis();
                int i4 = this.h / 2;
                int i5 = i4 - 1;
                if (this.f2904f.get(i4).longValue() - this.f2904f.get(i5).longValue() < 500) {
                    for (int i6 = 0; i6 < this.f2903e.size(); i6++) {
                        Float valueOf2 = Float.valueOf(((Float) this.f2903e.get(i6).get(i4)).floatValue() - this.g.get(i6).floatValue());
                        Float valueOf3 = Float.valueOf(((Float) this.f2903e.get(i6).get(i5)).floatValue() - this.g.get(i6).floatValue());
                        if (Math.abs(valueOf2.floatValue()) > Math.max(this.j, this.g.get(i6).floatValue() / 4.0f) || Math.abs(valueOf3.floatValue()) > Math.max(this.j, this.g.get(i6).floatValue() / 4.0f)) {
                            if (valueOf3.floatValue() * valueOf2.floatValue() < 0.0f) {
                                if (!this.q) {
                                    if (this.k.hasMessages(0)) {
                                        this.k.removeCallbacks(this.l);
                                        this.k.removeMessages(0);
                                    }
                                    this.k.postDelayed(this.l, 300);
                                    this.k.sendEmptyMessage(0);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
