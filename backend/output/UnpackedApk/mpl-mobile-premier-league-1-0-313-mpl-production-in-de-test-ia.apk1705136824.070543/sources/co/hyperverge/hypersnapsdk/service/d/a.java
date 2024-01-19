package co.hyperverge.hypersnapsdk.service.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.b.g.e;
import co.hyperverge.hypersnapsdk.f.i;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.netcore.android.SMTEventParamKeys;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

/* compiled from: HVSensorBiometrics */
public class a {
    public final SensorEventListener A;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3203b;

    /* renamed from: c  reason: collision with root package name */
    public final co.hyperverge.hypersnapsdk.b.a f3204c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3205d;

    /* renamed from: e  reason: collision with root package name */
    public String f3206e;

    /* renamed from: f  reason: collision with root package name */
    public JsonObject f3207f;
    public JsonObject g;
    public JsonObject h;
    public JsonObject i;
    public JsonObject j;
    public JsonObject k;
    public File l;
    public File m;
    public File n;
    public File o;
    public File p;
    public File q;
    public File r;
    public final SensorManager s;
    public Sensor t;
    public Sensor u;
    public Sensor v;
    public Sensor w;
    public Sensor x;
    public boolean z;

    /* renamed from: co.hyperverge.hypersnapsdk.service.d.a$a  reason: collision with other inner class name */
    /* compiled from: HVSensorBiometrics */
    public class C0060a implements SensorEventListener {
        public C0060a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            float[] fArr = sensorEvent.values;
            JsonArray jsonArray = new JsonArray(fArr.length);
            for (float valueOf : fArr) {
                jsonArray.add((Number) Float.valueOf(valueOf));
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (type == 1) {
                a.this.g.add(String.valueOf(currentTimeMillis), jsonArray);
            } else if (type == 2) {
                a.this.h.add(String.valueOf(currentTimeMillis), jsonArray);
            } else if (type == 3) {
                a.this.k.add(String.valueOf(currentTimeMillis), jsonArray);
            } else if (type == 4) {
                a.this.i.add(String.valueOf(currentTimeMillis), jsonArray);
            } else if (type == 6) {
                a.this.j.add(String.valueOf(currentTimeMillis), jsonArray);
            }
        }
    }

    public a(Context context) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("https://armxjib6ub.execute-api.ap-southeast-1.amazonaws.com/prod/");
        if (HyperSnapSDK.getInstance() != null) {
            outline73.append(HyperSnapSDK.f2946b.getAppId());
            outline73.append("/sensorData/");
            this.f3205d = outline73.toString();
            this.f3206e = "";
            this.f3207f = new JsonObject();
            this.g = new JsonObject();
            this.h = new JsonObject();
            this.i = new JsonObject();
            this.j = new JsonObject();
            this.k = new JsonObject();
            this.z = false;
            this.A = new C0060a();
            this.f3203b = context;
            this.f3204c = co.hyperverge.hypersnapsdk.b.a.a();
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.s = sensorManager;
            this.t = sensorManager.getDefaultSensor(1);
            this.u = this.s.getDefaultSensor(2);
            this.v = this.s.getDefaultSensor(4);
            this.w = this.s.getDefaultSensor(6);
            this.x = this.s.getDefaultSensor(3);
            File file = new File(this.f3203b.getFilesDir(), "hv/sensorData");
            if (!file.exists()) {
                file.mkdirs();
            }
            this.l = a(file, (String) "sensor_data_events.json");
            this.m = a(file, (String) "accelerometerSensorData.json");
            this.n = a(file, (String) "geomagneticSensorData.json");
            this.o = a(file, (String) "gyroscopeSensorData.json");
            this.p = a(file, (String) "pressureSensorData.json");
            this.q = a(file, (String) "orientationSensorData.json");
            return;
        }
        throw null;
    }

    public final void J() {
        this.f3207f = new JsonObject();
        this.g = new JsonObject();
        this.h = new JsonObject();
        this.i = new JsonObject();
        this.j = new JsonObject();
        this.k = new JsonObject();
        File file = new File(this.f3203b.getFilesDir(), "hv/sensorData");
        a(file, this.l.getName());
        a(file, this.m.getName());
        a(file, this.n.getName());
        a(file, this.o.getName());
        a(file, this.p.getName());
        a(file, this.q.getName());
        this.f3206e = "";
    }

    public final void K() {
        Sensor sensor = this.t;
        if (sensor != null) {
            this.s.registerListener(this.A, sensor, 10000);
        }
        Sensor sensor2 = this.u;
        if (sensor2 != null) {
            this.s.registerListener(this.A, sensor2, 10000);
        }
        Sensor sensor3 = this.v;
        if (sensor3 != null) {
            this.s.registerListener(this.A, sensor3, 10000);
        }
        Sensor sensor4 = this.w;
        if (sensor4 != null) {
            this.s.registerListener(this.A, sensor4, 10000);
        }
        Sensor sensor5 = this.x;
        if (sensor5 != null) {
            this.s.registerListener(this.A, sensor5, 10000);
        }
        this.z = true;
    }

    public void M() {
        if (this.z) {
            if ((this.l == null || this.m == null || this.n == null || this.o == null || this.p == null || this.q == null) ? false : true) {
                SensorManager sensorManager = this.s;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this.A);
                    this.z = false;
                }
                a(this.f3207f, this.l);
                a(this.g, this.m);
                a(this.h, this.n);
                a(this.i, this.o);
                a(this.j, this.p);
                a(this.k, this.q);
            }
            if (this.r != null) {
                i.a(this.f3203b, Arrays.asList(new String[]{this.l.getAbsolutePath(), this.m.getAbsolutePath(), this.n.getAbsolutePath(), this.o.getAbsolutePath(), this.p.getAbsolutePath(), this.q.getAbsolutePath()}), this.r);
                co.hyperverge.hypersnapsdk.b.a aVar = this.f3204c;
                String str = this.f3206e;
                File file = this.r;
                e eVar = (e) aVar.f3017b;
                if (eVar != null) {
                    Part createFormData = Part.createFormData("sensorDataZipFile", file.getName(), RequestBody.create(MediaType.parse("application/zip"), file));
                    HashMap hashMap = new HashMap();
                    if (HyperSnapSDK.getInstance() != null) {
                        if (HyperSnapSDK.f2946b.getAccessToken() != null) {
                            if (HyperSnapSDK.getInstance() == null) {
                                throw null;
                            } else if (!HyperSnapSDK.f2946b.getAccessToken().isEmpty()) {
                                if (HyperSnapSDK.getInstance() != null) {
                                    hashMap.put("Authorization", HyperSnapSDK.f2946b.getAccessToken());
                                    co.hyperverge.hypersnapsdk.b.g.a.b().a(str, (Map<String, String>) hashMap, createFormData).enqueue(new e.i(eVar));
                                } else {
                                    throw null;
                                }
                            }
                        }
                        if (HyperSnapSDK.getInstance() != null) {
                            hashMap.put(SMTEventParamKeys.SMT_APP_ID, HyperSnapSDK.f2946b.getAppId());
                            if (HyperSnapSDK.getInstance() != null) {
                                hashMap.put("appKey", HyperSnapSDK.f2946b.getAppKey());
                                co.hyperverge.hypersnapsdk.b.g.a.b().a(str, (Map<String, String>) hashMap, createFormData).enqueue(new e.i(eVar));
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            J();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File a(java.io.File r3, java.lang.String r4) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3, r4)
            java.lang.String r3 = "zip"
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x000e
            goto L_0x002c
        L_0x000e:
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r4 = ""
            r3.print(r4)     // Catch:{ all -> 0x001c }
            r3.close()     // Catch:{ Exception -> 0x0028 }
            goto L_0x002c
        L_0x001c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001e }
        L_0x001e:
            r1 = move-exception
            r3.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ Exception -> 0x0028 }
        L_0x0027:
            throw r1     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            r3 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r3)
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.service.d.a.a(java.io.File, java.lang.String):java.io.File");
    }

    public void b(String str) {
        J();
        File file = new File(this.f3203b.getFilesDir(), "hv/sensorData");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.r = a(file, str);
        this.f3206e = this.f3205d.concat(str);
        K();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar == null) {
            throw null;
        } else if (this.z != aVar.z) {
            return false;
        } else {
            Context context = this.f3203b;
            Context context2 = aVar.f3203b;
            if (context != null ? !context.equals(context2) : context2 != null) {
                return false;
            }
            co.hyperverge.hypersnapsdk.b.a aVar2 = this.f3204c;
            co.hyperverge.hypersnapsdk.b.a aVar3 = aVar.f3204c;
            if (aVar2 != null ? !aVar2.equals(aVar3) : aVar3 != null) {
                return false;
            }
            String str = this.f3205d;
            String str2 = aVar.f3205d;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            String str3 = this.f3206e;
            String str4 = aVar.f3206e;
            if (str3 != null ? !str3.equals(str4) : str4 != null) {
                return false;
            }
            JsonObject jsonObject = this.f3207f;
            JsonObject jsonObject2 = aVar.f3207f;
            if (jsonObject != null ? !jsonObject.equals(jsonObject2) : jsonObject2 != null) {
                return false;
            }
            JsonObject jsonObject3 = this.g;
            JsonObject jsonObject4 = aVar.g;
            if (jsonObject3 != null ? !jsonObject3.equals(jsonObject4) : jsonObject4 != null) {
                return false;
            }
            JsonObject jsonObject5 = this.h;
            JsonObject jsonObject6 = aVar.h;
            if (jsonObject5 != null ? !jsonObject5.equals(jsonObject6) : jsonObject6 != null) {
                return false;
            }
            JsonObject jsonObject7 = this.i;
            JsonObject jsonObject8 = aVar.i;
            if (jsonObject7 != null ? !jsonObject7.equals(jsonObject8) : jsonObject8 != null) {
                return false;
            }
            JsonObject jsonObject9 = this.j;
            JsonObject jsonObject10 = aVar.j;
            if (jsonObject9 != null ? !jsonObject9.equals(jsonObject10) : jsonObject10 != null) {
                return false;
            }
            JsonObject jsonObject11 = this.k;
            JsonObject jsonObject12 = aVar.k;
            if (jsonObject11 != null ? !jsonObject11.equals(jsonObject12) : jsonObject12 != null) {
                return false;
            }
            File file = this.l;
            File file2 = aVar.l;
            if (file != null ? !file.equals(file2) : file2 != null) {
                return false;
            }
            File file3 = this.m;
            File file4 = aVar.m;
            if (file3 != null ? !file3.equals(file4) : file4 != null) {
                return false;
            }
            File file5 = this.n;
            File file6 = aVar.n;
            if (file5 != null ? !file5.equals(file6) : file6 != null) {
                return false;
            }
            File file7 = this.o;
            File file8 = aVar.o;
            if (file7 != null ? !file7.equals(file8) : file8 != null) {
                return false;
            }
            File file9 = this.p;
            File file10 = aVar.p;
            if (file9 != null ? !file9.equals(file10) : file10 != null) {
                return false;
            }
            File file11 = this.q;
            File file12 = aVar.q;
            if (file11 != null ? !file11.equals(file12) : file12 != null) {
                return false;
            }
            File file13 = this.r;
            File file14 = aVar.r;
            if (file13 != null ? !file13.equals(file14) : file14 != null) {
                return false;
            }
            SensorManager sensorManager = this.s;
            SensorManager sensorManager2 = aVar.s;
            if (sensorManager != null ? !sensorManager.equals(sensorManager2) : sensorManager2 != null) {
                return false;
            }
            Sensor sensor = this.t;
            Sensor sensor2 = aVar.t;
            if (sensor != null ? !sensor.equals(sensor2) : sensor2 != null) {
                return false;
            }
            Sensor sensor3 = this.u;
            Sensor sensor4 = aVar.u;
            if (sensor3 != null ? !sensor3.equals(sensor4) : sensor4 != null) {
                return false;
            }
            Sensor sensor5 = this.v;
            Sensor sensor6 = aVar.v;
            if (sensor5 != null ? !sensor5.equals(sensor6) : sensor6 != null) {
                return false;
            }
            Sensor sensor7 = this.w;
            Sensor sensor8 = aVar.w;
            if (sensor7 != null ? !sensor7.equals(sensor8) : sensor8 != null) {
                return false;
            }
            Sensor sensor9 = this.x;
            Sensor sensor10 = aVar.x;
            if (sensor9 != null ? !sensor9.equals(sensor10) : sensor10 != null) {
                return false;
            }
            SensorEventListener sensorEventListener = this.A;
            SensorEventListener sensorEventListener2 = aVar.A;
            return sensorEventListener != null ? sensorEventListener.equals(sensorEventListener2) : sensorEventListener2 == null;
        }
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25 = 593481 + (this.z ? 79 : 97);
        Context context = this.f3203b;
        int i26 = i25 * 59;
        int i27 = 43;
        if (context == null) {
            i2 = 43;
        } else {
            i2 = context.hashCode();
        }
        int i28 = i26 + i2;
        co.hyperverge.hypersnapsdk.b.a aVar = this.f3204c;
        int i29 = i28 * 59;
        if (aVar == null) {
            i3 = 43;
        } else {
            i3 = aVar.hashCode();
        }
        int i30 = i29 + i3;
        String str = this.f3205d;
        int i31 = i30 * 59;
        if (str == null) {
            i4 = 43;
        } else {
            i4 = str.hashCode();
        }
        int i32 = i31 + i4;
        String str2 = this.f3206e;
        int i33 = i32 * 59;
        if (str2 == null) {
            i5 = 43;
        } else {
            i5 = str2.hashCode();
        }
        int i34 = i33 + i5;
        JsonObject jsonObject = this.f3207f;
        int i35 = i34 * 59;
        if (jsonObject == null) {
            i6 = 43;
        } else {
            i6 = jsonObject.hashCode();
        }
        int i36 = i35 + i6;
        JsonObject jsonObject2 = this.g;
        int i37 = i36 * 59;
        if (jsonObject2 == null) {
            i7 = 43;
        } else {
            i7 = jsonObject2.hashCode();
        }
        int i38 = i37 + i7;
        JsonObject jsonObject3 = this.h;
        int i39 = i38 * 59;
        if (jsonObject3 == null) {
            i8 = 43;
        } else {
            i8 = jsonObject3.hashCode();
        }
        int i40 = i39 + i8;
        JsonObject jsonObject4 = this.i;
        int i41 = i40 * 59;
        if (jsonObject4 == null) {
            i9 = 43;
        } else {
            i9 = jsonObject4.hashCode();
        }
        int i42 = i41 + i9;
        JsonObject jsonObject5 = this.j;
        int i43 = i42 * 59;
        if (jsonObject5 == null) {
            i10 = 43;
        } else {
            i10 = jsonObject5.hashCode();
        }
        int i44 = i43 + i10;
        JsonObject jsonObject6 = this.k;
        int i45 = i44 * 59;
        if (jsonObject6 == null) {
            i11 = 43;
        } else {
            i11 = jsonObject6.hashCode();
        }
        int i46 = i45 + i11;
        File file = this.l;
        int i47 = i46 * 59;
        if (file == null) {
            i12 = 43;
        } else {
            i12 = file.hashCode();
        }
        int i48 = i47 + i12;
        File file2 = this.m;
        int i49 = i48 * 59;
        if (file2 == null) {
            i13 = 43;
        } else {
            i13 = file2.hashCode();
        }
        int i50 = i49 + i13;
        File file3 = this.n;
        int i51 = i50 * 59;
        if (file3 == null) {
            i14 = 43;
        } else {
            i14 = file3.hashCode();
        }
        int i52 = i51 + i14;
        File file4 = this.o;
        int i53 = i52 * 59;
        if (file4 == null) {
            i15 = 43;
        } else {
            i15 = file4.hashCode();
        }
        int i54 = i53 + i15;
        File file5 = this.p;
        int i55 = i54 * 59;
        if (file5 == null) {
            i16 = 43;
        } else {
            i16 = file5.hashCode();
        }
        int i56 = i55 + i16;
        File file6 = this.q;
        int i57 = i56 * 59;
        if (file6 == null) {
            i17 = 43;
        } else {
            i17 = file6.hashCode();
        }
        int i58 = i57 + i17;
        File file7 = this.r;
        int i59 = i58 * 59;
        if (file7 == null) {
            i18 = 43;
        } else {
            i18 = file7.hashCode();
        }
        int i60 = i59 + i18;
        SensorManager sensorManager = this.s;
        int i61 = i60 * 59;
        if (sensorManager == null) {
            i19 = 43;
        } else {
            i19 = sensorManager.hashCode();
        }
        int i62 = i61 + i19;
        Sensor sensor = this.t;
        int i63 = i62 * 59;
        if (sensor == null) {
            i20 = 43;
        } else {
            i20 = sensor.hashCode();
        }
        int i64 = i63 + i20;
        Sensor sensor2 = this.u;
        int i65 = i64 * 59;
        if (sensor2 == null) {
            i21 = 43;
        } else {
            i21 = sensor2.hashCode();
        }
        int i66 = i65 + i21;
        Sensor sensor3 = this.v;
        int i67 = i66 * 59;
        if (sensor3 == null) {
            i22 = 43;
        } else {
            i22 = sensor3.hashCode();
        }
        int i68 = i67 + i22;
        Sensor sensor4 = this.w;
        int i69 = i68 * 59;
        if (sensor4 == null) {
            i23 = 43;
        } else {
            i23 = sensor4.hashCode();
        }
        int i70 = i69 + i23;
        Sensor sensor5 = this.x;
        int i71 = i70 * 59;
        if (sensor5 == null) {
            i24 = 43;
        } else {
            i24 = sensor5.hashCode();
        }
        int i72 = i71 + i24;
        SensorEventListener sensorEventListener = this.A;
        int i73 = i72 * 59;
        if (sensorEventListener != null) {
            i27 = sensorEventListener.hashCode();
        }
        return i73 + i27;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HVSensorBiometrics(mContext=");
        outline73.append(this.f3203b);
        outline73.append(", dataRepository=");
        outline73.append(this.f3204c);
        outline73.append(", postSensorDataEndpointBluePrint=");
        outline73.append(this.f3205d);
        outline73.append(", postSensorDataEndpoint=");
        outline73.append(this.f3206e);
        outline73.append(", sensorDataEventsJsonObject=");
        outline73.append(this.f3207f);
        outline73.append(", accelerometerSensorDataJsonObject=");
        outline73.append(this.g);
        outline73.append(", geomagneticSensorDataJsonObject=");
        outline73.append(this.h);
        outline73.append(", gyroscopeSensorDataJsonObject=");
        outline73.append(this.i);
        outline73.append(", pressureSensorDataJsonObject=");
        outline73.append(this.j);
        outline73.append(", orientationSensorDataJsonObject=");
        outline73.append(this.k);
        outline73.append(", sensorDataEventsFile=");
        outline73.append(this.l);
        outline73.append(", accelerometerSensorDataFile=");
        outline73.append(this.m);
        outline73.append(", geomagneticSensorDataFile=");
        outline73.append(this.n);
        outline73.append(", gyroscopeSensorDataFile=");
        outline73.append(this.o);
        outline73.append(", pressureSensorDataFile=");
        outline73.append(this.p);
        outline73.append(", orientationSensorDataFile=");
        outline73.append(this.q);
        outline73.append(", sensorDataZipFile=");
        outline73.append(this.r);
        outline73.append(", mSensorManager=");
        outline73.append(this.s);
        outline73.append(", mSensorAccelerometer=");
        outline73.append(this.t);
        outline73.append(", mSensorGeoMagnetic=");
        outline73.append(this.u);
        outline73.append(", mSensorGyroscope=");
        outline73.append(this.v);
        outline73.append(", mSensorPressure=");
        outline73.append(this.w);
        outline73.append(", mSensorOrientation=");
        outline73.append(this.x);
        outline73.append(", samplingPeriodMicroseconds=");
        outline73.append(10000);
        outline73.append(", isHvSensorBiometricsRunning=");
        outline73.append(this.z);
        outline73.append(", mSensorEventListener=");
        outline73.append(this.A);
        outline73.append(")");
        return outline73.toString();
    }

    public void a(long j2, String str) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(str);
        this.f3207f.add(String.valueOf(j2), jsonArray);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0036, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.gson.JsonObject r3, java.io.File r4) {
        /*
            r2 = this;
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ Exception -> 0x0037 }
            r1 = 1
            r0.<init>(r4, r1)     // Catch:{ Exception -> 0x0037 }
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ all -> 0x002b }
            r4.<init>(r0)     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x001f }
            r4.append(r3)     // Catch:{ all -> 0x001f }
            r4.newLine()     // Catch:{ all -> 0x001f }
            r4.flush()     // Catch:{ all -> 0x001f }
            r4.close()     // Catch:{ all -> 0x002b }
            r0.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x001f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            r4.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            r3.addSuppressed(r4)     // Catch:{ all -> 0x002b }
        L_0x002a:
            throw r1     // Catch:{ all -> 0x002b }
        L_0x002b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002d }
        L_0x002d:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ Exception -> 0x0037 }
        L_0x0036:
            throw r4     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            r3 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r3)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.service.d.a.a(com.google.gson.JsonObject, java.io.File):void");
    }
}
