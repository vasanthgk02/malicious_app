package co.hyperverge.hvcamera.d;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public abstract class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final SensorManager f2907a;

    public b(Context context) {
        this.f2907a = (SensorManager) context.getSystemService("sensor");
    }
}
