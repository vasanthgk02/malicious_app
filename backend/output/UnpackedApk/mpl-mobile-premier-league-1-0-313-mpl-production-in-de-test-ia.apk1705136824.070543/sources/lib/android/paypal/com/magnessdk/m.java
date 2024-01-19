package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.util.Iterator;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.network.base.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends c implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    public Sensor f6108b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f6109c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f6110d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f6111e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f6112f;
    public JSONArray g;
    public int h;
    public long i = 0;

    public m(Context context, Handler handler, int i2) {
        this.f6112f = handler;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f6109c = sensorManager;
        this.h = i2;
        this.f6108b = sensorManager.getDefaultSensor(i2);
    }

    public void a() {
        this.f6110d = new JSONObject();
        this.g = new JSONArray();
        this.f6111e = new JSONArray();
        d();
    }

    public JSONObject a_() {
        if (this.f6108b == null) {
            return new JSONObject();
        }
        this.f6109c.unregisterListener(this);
        try {
            this.f6110d.put(c$a.SENSOR_PAYLOAD.toString(), this.g);
            this.f6111e.put(this.f6110d);
        } catch (JSONException e2) {
            a.a(m.class, 3, (Throwable) e2);
        }
        return this.f6110d;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.i > 25 && this.g.length() < 150) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(String.valueOf((double) sensorEvent.values[0]));
            jSONArray.put(String.valueOf((double) sensorEvent.values[1]));
            jSONArray.put(String.valueOf((double) sensorEvent.values[2]));
            jSONArray.put(currentTimeMillis);
            this.g.put(jSONArray);
            this.i = currentTimeMillis;
        }
    }

    public void run() {
        Handler handler = this.f6112f;
        if (handler != null) {
            SensorManager sensorManager = this.f6109c;
            try {
                if (this.f6108b != null) {
                    sensorManager.registerListener(this, this.f6108b, 50000, handler);
                    JSONObject a2 = f.a(this.f6108b);
                    JSONObject jSONObject = this.f6110d;
                    Iterator<String> keys = a2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!jSONObject.has(next)) {
                            try {
                                jSONObject.put(next, a2.opt(next));
                            } catch (JSONException e2) {
                                a.a(f.class, 3, (Throwable) e2);
                            }
                        }
                    }
                    this.f6110d = jSONObject;
                    if (this.h == 1) {
                        jSONObject.put(c$a.SENSOR_TYPE.toString(), c$l.AC.toString());
                    }
                    if (this.h == 4) {
                        this.f6110d.put(c$a.SENSOR_TYPE.toString(), c$l.GY.toString());
                    }
                    if (this.h == 2) {
                        this.f6110d.put(c$a.SENSOR_TYPE.toString(), c$l.MG.toString());
                    }
                }
            } catch (JSONException e3) {
                a.a(m.class, 3, (Throwable) e3);
            }
        }
    }
}
