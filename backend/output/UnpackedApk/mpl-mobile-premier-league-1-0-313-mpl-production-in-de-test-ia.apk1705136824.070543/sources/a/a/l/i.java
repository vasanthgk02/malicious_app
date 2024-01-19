package a.a.l;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f2678a;

    /* renamed from: b  reason: collision with root package name */
    public String f2679b;

    /* renamed from: c  reason: collision with root package name */
    public String f2680c;

    /* renamed from: d  reason: collision with root package name */
    public int f2681d;

    /* renamed from: e  reason: collision with root package name */
    public int f2682e;

    /* renamed from: f  reason: collision with root package name */
    public int f2683f;
    public int g;
    public int i;
    public String k;
    public int l;
    public double m;
    public double n;
    public double o;
    public boolean p;

    public void a(double d2) {
        this.n = d2;
    }

    public void a(int i2) {
        this.f2681d = i2;
    }

    public void b(double d2) {
        this.o = d2;
    }

    public void b(int i2) {
        this.f2682e = i2;
    }

    public void b(String str) {
        this.f2680c = str;
    }

    public void c(double d2) {
        this.m = d2;
    }

    public void c(int i2) {
        this.i = i2;
    }

    public void d(int i2) {
        this.g = i2;
    }

    public void e(int i2) {
        this.l = i2;
    }

    public void f(int i2) {
        this.f2683f = i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TableEntity{gameId='");
        GeneratedOutlineSupport.outline99(outline73, this.f2678a, ExtendedMessageFormat.QUOTE, ", selfUserId='");
        GeneratedOutlineSupport.outline99(outline73, this.f2679b, ExtendedMessageFormat.QUOTE, ", roomName='");
        GeneratedOutlineSupport.outline99(outline73, this.f2680c, ExtendedMessageFormat.QUOTE, ", fee=");
        outline73.append(this.f2681d);
        outline73.append(", maxPlayers=");
        outline73.append(this.f2682e);
        outline73.append(", winners=");
        outline73.append(this.f2683f);
        outline73.append(", rounds=");
        outline73.append(this.g);
        outline73.append(", allowedBonus=");
        outline73.append(0.0f);
        outline73.append(", prize=");
        outline73.append(this.i);
        outline73.append(", tableName='");
        outline73.append(null);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", speed='");
        GeneratedOutlineSupport.outline99(outline73, this.k, ExtendedMessageFormat.QUOTE, ", turnTime=");
        outline73.append(this.l);
        outline73.append(", rake=");
        outline73.append(this.m);
        outline73.append(", prize1=");
        outline73.append(this.n);
        outline73.append(", prize2=");
        outline73.append(this.o);
        outline73.append(", emojiEnabled=");
        return GeneratedOutlineSupport.outline65(outline73, this.p, '}');
    }
}
