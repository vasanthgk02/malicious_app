package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.GameConstant;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: ah  reason: default package */
public abstract class ah extends af {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2716a = {"Id", GameConstant.GAME_APP_ID, "Token", "CreationTime", "ExpirationTime", "MiscData", "type", "directedId"};

    /* renamed from: a  reason: collision with other field name */
    public a f35a;

    /* renamed from: a  reason: collision with other field name */
    public String f36a;

    /* renamed from: a  reason: collision with other field name */
    public Date f37a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f38a;

    /* renamed from: b  reason: collision with root package name */
    public String f2717b;

    /* renamed from: b  reason: collision with other field name */
    public Date f39b;

    /* renamed from: d  reason: collision with root package name */
    public String f2718d;

    /* renamed from: ah$a */
    public enum a {
        ACCESS("com.amazon.identity.token.accessToken"),
        REFRESH("com.amazon.identity.token.refreshToken");
        

        /* renamed from: a  reason: collision with other field name */
        public final String f41a;

        /* access modifiers changed from: public */
        a(String str) {
            this.f41a = str;
        }

        public String toString() {
            return this.f41a;
        }
    }

    /* renamed from: ah$b */
    public enum b {
        ID(0),
        APP_FAMILY_ID(1),
        TOKEN(2),
        CREATION_TIME(3),
        EXPIRATION_TIME(4),
        MISC_DATA(5),
        TYPE(6),
        DIRECTED_ID(7);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f43a;

        /* access modifiers changed from: public */
        b(int i) {
            this.f43a = i;
        }
    }

    public ah() {
    }

    public ah(String str, String str2, String str3, Date date, Date date2, byte[] bArr, a aVar) {
        this.f36a = str;
        this.f2717b = str3;
        this.f37a = ao.a(date);
        this.f39b = ao.a(date2);
        this.f38a = bArr;
        this.f35a = aVar;
        this.f2718d = str2;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat a2 = ao.a();
        contentValues.put(f2716a[b.APP_FAMILY_ID.f43a], this.f36a);
        contentValues.put(f2716a[b.TOKEN.f43a], this.f2717b);
        contentValues.put(f2716a[b.CREATION_TIME.f43a], a2.format(this.f37a));
        contentValues.put(f2716a[b.EXPIRATION_TIME.f43a], a2.format(this.f39b));
        contentValues.put(f2716a[b.MISC_DATA.f43a], this.f38a);
        contentValues.put(f2716a[b.TYPE.f43a], Integer.valueOf(this.f35a.ordinal()));
        contentValues.put(f2716a[b.DIRECTED_ID.f43a], this.f2718d);
        return contentValues;
    }

    public String c() {
        return this.f35a.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null && (obj instanceof ah)) {
            try {
                ah ahVar = (ah) obj;
                if (TextUtils.equals(this.f36a, ahVar.f36a) && TextUtils.equals(this.f2717b, ahVar.f2717b) && a(this.f37a, ahVar.f37a) && a(this.f39b, ahVar.f39b) && TextUtils.equals(c(), ahVar.c()) && TextUtils.equals(this.f2718d, ahVar.f2718d)) {
                    z = true;
                }
                return z;
            } catch (NullPointerException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                outline73.append(e2.toString());
                cp.b("ah", outline73.toString());
            }
        }
        return false;
    }

    public String toString() {
        return this.f2717b;
    }
}
