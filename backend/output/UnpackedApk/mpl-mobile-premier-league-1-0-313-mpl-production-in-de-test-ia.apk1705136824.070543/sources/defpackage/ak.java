package defpackage;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.GameConstant;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;

/* renamed from: ak  reason: default package */
public class ak extends af implements Parcelable {
    public static final Creator<ak> CREATOR = new Creator<ak>() {
        public Object createFromParcel(Parcel parcel) {
            return new ak(parcel);
        }

        public Object[] newArray(int i) {
            return new ak[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f2734a = ak.class.getName();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f48a = {"rowid", PDTableAttributeObject.SCOPE, GameConstant.GAME_APP_ID, "DirectedId", "AtzAccessTokenId", "AtzRefreshTokenId"};

    /* renamed from: a  reason: collision with other field name */
    public long f49a;

    /* renamed from: b  reason: collision with root package name */
    public long f2735b;

    /* renamed from: b  reason: collision with other field name */
    public String f50b;

    /* renamed from: c  reason: collision with root package name */
    public String f2736c;

    /* renamed from: d  reason: collision with root package name */
    public String f2737d;

    /* renamed from: ak$a */
    public enum a {
        ROW_ID(0),
        SCOPE(1),
        APP_FAMILY_ID(2),
        DIRECTED_ID(3),
        AUTHORIZATION_ACCESS_TOKEN_ID(4),
        AUTHORIZATION_REFRESH_TOKEN_ID(5);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f52a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f52a = i;
        }
    }

    /* renamed from: ak$b */
    public enum b {
        UNKNOWN(-2),
        REJECTED(-1),
        GRANTED_LOCALLY(0);
        

        /* renamed from: a  reason: collision with other field name */
        public final long f54a;

        /* access modifiers changed from: public */
        b(long j) {
            this.f54a = j;
        }
    }

    public ak() {
        long j = b.REJECTED.f54a;
        this.f49a = j;
        this.f2735b = j;
    }

    public ak(long j, String str, String str2, String str3, long j2, long j3) {
        long j4 = b.REJECTED.f54a;
        this.f49a = j4;
        this.f2735b = j4;
        this.f50b = str;
        this.f2736c = str2;
        this.f2737d = str3;
        this.f49a = j2;
        this.f2735b = j3;
        this.f2703a = j;
    }

    public ak(String str, String str2, String str3) {
        long j = b.REJECTED.f54a;
        this.f49a = j;
        this.f2735b = j;
        this.f50b = str;
        this.f2736c = str2;
        this.f2737d = str3;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f48a[a.SCOPE.f52a], this.f50b);
        contentValues.put(f48a[a.APP_FAMILY_ID.f52a], this.f2736c);
        contentValues.put(f48a[a.DIRECTED_ID.f52a], this.f2737d);
        contentValues.put(f48a[a.AUTHORIZATION_ACCESS_TOKEN_ID.f52a], Long.valueOf(this.f49a));
        contentValues.put(f48a[a.AUTHORIZATION_REFRESH_TOKEN_ID.f52a], Long.valueOf(this.f2735b));
        return contentValues;
    }

    public Object clone() throws CloneNotSupportedException {
        ak akVar = new ak(this.f2703a, this.f50b, this.f2736c, this.f2737d, this.f49a, this.f2735b);
        return akVar;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ak) {
            try {
                ak akVar = (ak) obj;
                if (this.f50b.equals(akVar.f50b) && this.f2736c.equals(akVar.f2736c) && this.f2737d.equals(akVar.f2737d) && this.f49a == akVar.f49a && this.f2735b == akVar.f2735b) {
                    z = true;
                }
                return z;
            } catch (NullPointerException e2) {
                String str = f2734a;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.toString());
                cp.b(str, outline73.toString());
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ rowid=");
        outline73.append(this.f2703a);
        outline73.append(", scope=");
        outline73.append(this.f50b);
        outline73.append(", appFamilyId=");
        outline73.append(this.f2736c);
        outline73.append(", directedId=<obscured>, atzAccessTokenId=");
        outline73.append(this.f49a);
        outline73.append(", atzRefreshTokenId=");
        return GeneratedOutlineSupport.outline58(outline73, this.f2735b, " }");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2703a);
        parcel.writeString(this.f50b);
        parcel.writeString(this.f2736c);
        parcel.writeString(this.f2737d);
        parcel.writeLong(this.f49a);
        parcel.writeLong(this.f2735b);
    }

    public ak(Parcel parcel) {
        long j = b.REJECTED.f54a;
        this.f49a = j;
        this.f2735b = j;
        this.f2703a = parcel.readLong();
        this.f50b = parcel.readString();
        this.f2736c = parcel.readString();
        this.f2737d = parcel.readString();
        this.f49a = parcel.readLong();
        this.f2735b = parcel.readLong();
    }
}
