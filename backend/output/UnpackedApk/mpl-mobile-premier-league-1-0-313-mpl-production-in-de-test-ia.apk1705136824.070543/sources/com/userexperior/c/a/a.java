package com.userexperior.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.a.a.a.c;
import com.userexperior.interfaces.recording.g;
import com.userexperior.models.recording.enums.b;
import com.userexperior.models.recording.enums.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }
    };
    public static final String n = a.class.getSimpleName();
    @c(a = "eventType")

    /* renamed from: a  reason: collision with root package name */
    public com.userexperior.models.recording.enums.a f3795a;
    @c(a = "type")

    /* renamed from: b  reason: collision with root package name */
    public h f3796b;
    @c(a = "customTag")

    /* renamed from: c  reason: collision with root package name */
    public String f3797c;
    @c(a = "name")

    /* renamed from: d  reason: collision with root package name */
    public String f3798d;
    @c(a = "props")

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f3799e;
    @c(a = "time")

    /* renamed from: f  reason: collision with root package name */
    public long f3800f;
    @c(a = "objectName")
    public String g;
    @c(a = "nonResponsive")
    public boolean h;
    @c(a = "screen")
    public String i;
    @c(a = "inputType")
    public b j;
    @c(a = "coordinateList")
    public List<c> k;
    @c(a = "exceptionClassName")
    public String l;
    @c(a = "exceptionTag")
    public String m;

    public a(Parcel parcel) {
        this.f3795a = (com.userexperior.models.recording.enums.a) parcel.readSerializable();
        this.f3796b = (h) parcel.readSerializable();
        this.f3797c = parcel.readString();
        this.l = parcel.readString();
        this.f3800f = parcel.readLong();
        this.i = parcel.readString();
        this.j = (b) parcel.readSerializable();
        this.k = parcel.createTypedArrayList(c.CREATOR);
        this.f3799e = (HashMap) parcel.readParcelable(HashMap.class.getClassLoader());
    }

    public a(com.userexperior.models.recording.enums.a aVar, h hVar, InputEvent inputEvent, String str, long j2, g gVar) {
        a(aVar, hVar, null, null, null, null, null, inputEvent, null, str, j2, gVar);
    }

    public a(com.userexperior.models.recording.enums.a aVar, h hVar, MotionEvent motionEvent, MotionEvent motionEvent2, String str, long j2) {
        a(aVar, hVar, null, null, null, null, null, motionEvent, motionEvent2, str, j2, null);
    }

    public a(com.userexperior.models.recording.enums.a aVar, h hVar, String str, String str2, long j2) {
        a(aVar, hVar, null, null, str, null, null, null, null, str2, j2, null);
    }

    public a(com.userexperior.models.recording.enums.a aVar, h hVar, String str, String str2, String str3, long j2) {
        a(aVar, hVar, null, null, null, str, str2, null, null, str3, j2, null);
    }

    public a(com.userexperior.models.recording.enums.a aVar, h hVar, String str, HashMap<String, Object> hashMap, String str2, long j2) {
        a(aVar, hVar, str, hashMap, null, null, null, null, null, str2, j2, null);
    }

    private void a(com.userexperior.models.recording.enums.a aVar, h hVar, String str, HashMap<String, Object> hashMap, String str2, String str3, String str4, InputEvent inputEvent, InputEvent inputEvent2, String str5, long j2, g gVar) {
        StringBuilder sb;
        Level level;
        String str6;
        List list;
        int i2;
        List list2;
        com.userexperior.models.recording.enums.a aVar2 = aVar;
        h hVar2 = hVar;
        String str7 = str;
        HashMap<String, Object> hashMap2 = hashMap;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        InputEvent inputEvent3 = inputEvent;
        InputEvent inputEvent4 = inputEvent2;
        String str11 = str5;
        long j3 = j2;
        try {
            this.f3795a = aVar2;
            this.f3796b = hVar2;
            if (str8 != null) {
                this.f3797c = str8;
            }
            if (str7 != null) {
                this.f3798d = str7;
            } else {
                this.f3798d = str8;
            }
            if (hashMap2 != null) {
                this.f3799e = hashMap2;
            }
            if (str9 != null) {
                this.l = str9;
            }
            if (str10 != null) {
                this.m = str10;
            }
            this.f3800f = j3;
            this.i = str11;
            if (gVar != null) {
                this.g = gVar.a();
                this.h = gVar.b();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str11);
            sb2.append(CMap.SPACE);
            sb2.append(hVar2);
            sb2.append(CMap.SPACE);
            sb2.append(((float) j3) / 1000.0f);
            double d2 = 0.0d;
            if (inputEvent3 != null) {
                b[] values = b.values();
                if (inputEvent3 instanceof MotionEvent) {
                    i2 = ((MotionEvent) inputEvent3).getToolType(0);
                } else {
                    b bVar = b.TOOL_TYPE_FINGER;
                    i2 = 1;
                }
                this.j = values[i2];
                this.k = new ArrayList();
                c cVar = new c(inputEvent3 instanceof MotionEvent ? (double) ((MotionEvent) inputEvent3).getX() : 0.0d, inputEvent3 instanceof MotionEvent ? (double) ((MotionEvent) inputEvent3).getY() : 0.0d, j2);
                if (this.k != null) {
                    list2 = this.k;
                } else {
                    list2 = new ArrayList();
                    this.k = list2;
                }
                list2.add(cVar);
            }
            if (inputEvent4 != null) {
                double x = inputEvent4 instanceof MotionEvent ? (double) ((MotionEvent) inputEvent4).getX() : 0.0d;
                if (inputEvent4 instanceof MotionEvent) {
                    d2 = (double) ((MotionEvent) inputEvent4).getY();
                }
                c cVar2 = new c(x, d2, j2);
                if (this.k != null) {
                    list = this.k;
                } else {
                    list = new ArrayList();
                    this.k = list;
                }
                list.add(cVar2);
            }
            if (aVar2 == com.userexperior.models.recording.enums.a.SYSTEM) {
                this.j = b.SYSTEM_EVENT_OS;
            }
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("Ev: ");
            str6 = e2.getMessage();
            sb.append(str6);
            com.userexperior.utilities.b.a(level, sb.toString());
        } catch (Error e3) {
            level = Level.INFO;
            sb = new StringBuilder("Ev: ");
            str6 = e3.getMessage();
            sb.append(str6);
            com.userexperior.utilities.b.a(level, sb.toString());
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Event[eventType:");
        sb.append(this.f3795a.toString());
        sb.append(";type:");
        sb.append(this.f3796b.toString());
        sb.append(";customTag:");
        sb.append(this.f3797c);
        sb.append(";time:");
        sb.append(this.f3800f);
        sb.append(";activityName:");
        return GeneratedOutlineSupport.outline62(sb, this.i, CMapParser.MARK_END_OF_ARRAY);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.f3795a);
        parcel.writeSerializable(this.f3796b);
        parcel.writeString(this.f3797c);
        parcel.writeLong(this.f3800f);
        parcel.writeString(this.i);
        parcel.writeSerializable(this.j);
        parcel.writeTypedList(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeParcelable((Parcelable) this.f3799e, i2);
    }
}
