package com.xiaomi.push;

public final class au {

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4425a = 0;

        /* renamed from: a  reason: collision with other field name */
        public long f273a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f274a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f275a;

        /* renamed from: b  reason: collision with root package name */
        public int f4426b = 1;

        /* renamed from: b  reason: collision with other field name */
        public String f276b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f277b;

        /* renamed from: c  reason: collision with root package name */
        public int f4427c = 0;

        /* renamed from: c  reason: collision with other field name */
        public String f278c = "";

        /* renamed from: c  reason: collision with other field name */
        public boolean f279c;

        /* renamed from: d  reason: collision with root package name */
        public int f4428d = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f280d = "";

        /* renamed from: d  reason: collision with other field name */
        public boolean f281d;

        /* renamed from: e  reason: collision with root package name */
        public int f4429e = -1;

        /* renamed from: e  reason: collision with other field name */
        public String f282e = "";

        /* renamed from: e  reason: collision with other field name */
        public boolean f283e;

        /* renamed from: f  reason: collision with root package name */
        public String f4430f = "";

        /* renamed from: f  reason: collision with other field name */
        public boolean f284f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;

        public int a() {
            if (this.f4429e < 0) {
                b();
            }
            return this.f4429e;
        }

        /* renamed from: a  reason: collision with other method in class */
        public long m420a() {
            return this.f273a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public a m421a() {
            this.f284f = false;
            this.f280d = "";
            return this;
        }

        public a a(int i2) {
            this.f275a = true;
            this.f4425a = i2;
            return this;
        }

        public a a(long j2) {
            this.f277b = true;
            this.f273a = j2;
            return this;
        }

        public a a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.b());
                        break;
                    case 16:
                        a(bVar.a());
                        break;
                    case 26:
                        a(bVar.a());
                        break;
                    case 34:
                        b(bVar.a());
                        break;
                    case 42:
                        c(bVar.a());
                        break;
                    case 50:
                        d(bVar.a());
                        break;
                    case 58:
                        e(bVar.a());
                        break;
                    case 64:
                        b(bVar.b());
                        break;
                    case 72:
                        c(bVar.b());
                        break;
                    case 80:
                        d(bVar.b());
                        break;
                    case 90:
                        f(bVar.a());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f279c = true;
            this.f274a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m422a() {
            return this.f274a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, c());
            }
            if (b()) {
                cVar.a(2, a());
            }
            if (c()) {
                cVar.a(3, a());
            }
            if (d()) {
                cVar.a(4, b());
            }
            if (e()) {
                cVar.a(5, c());
            }
            if (f()) {
                cVar.a(6, d());
            }
            if (g()) {
                cVar.a(7, e());
            }
            if (h()) {
                cVar.a(8, d());
            }
            if (i()) {
                cVar.a(9, e());
            }
            if (j()) {
                cVar.a(10, f());
            }
            if (k()) {
                cVar.a(11, f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m423a() {
            return this.f275a;
        }

        public int b() {
            int i2 = 0;
            if (a()) {
                i2 = 0 + c.a(1, c());
            }
            if (b()) {
                i2 += c.a(2, a());
            }
            if (c()) {
                i2 += c.a(3, a());
            }
            if (d()) {
                i2 += c.a(4, b());
            }
            if (e()) {
                i2 += c.a(5, c());
            }
            if (f()) {
                i2 += c.a(6, d());
            }
            if (g()) {
                i2 += c.a(7, e());
            }
            if (h()) {
                i2 += c.a(8, d());
            }
            if (i()) {
                i2 += c.a(9, e());
            }
            if (j()) {
                i2 += c.a(10, f());
            }
            if (k()) {
                i2 += c.a(11, f());
            }
            this.f4429e = i2;
            return i2;
        }

        public a b(int i2) {
            this.h = true;
            this.f4426b = i2;
            return this;
        }

        public a b(String str) {
            this.f281d = true;
            this.f276b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m424b() {
            return this.f276b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m425b() {
            return this.f277b;
        }

        public int c() {
            return this.f4425a;
        }

        public a c(int i2) {
            this.i = true;
            this.f4427c = i2;
            return this;
        }

        public a c(String str) {
            this.f283e = true;
            this.f278c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m426c() {
            return this.f278c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m427c() {
            return this.f279c;
        }

        public int d() {
            return this.f4426b;
        }

        public a d(int i2) {
            this.j = true;
            this.f4428d = i2;
            return this;
        }

        public a d(String str) {
            this.f284f = true;
            this.f280d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m428d() {
            return this.f280d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m429d() {
            return this.f281d;
        }

        public int e() {
            return this.f4427c;
        }

        public a e(String str) {
            this.g = true;
            this.f282e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m430e() {
            return this.f282e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m431e() {
            return this.f283e;
        }

        public int f() {
            return this.f4428d;
        }

        public a f(String str) {
            this.k = true;
            this.f4430f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m432f() {
            return this.f4430f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m433f() {
            return this.f284f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }
    }

    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4431a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f285a;

        /* renamed from: b  reason: collision with root package name */
        public int f4432b = 0;

        /* renamed from: b  reason: collision with other field name */
        public boolean f286b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f4433c = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f287c;

        /* renamed from: d  reason: collision with root package name */
        public int f4434d = -1;

        /* renamed from: d  reason: collision with other field name */
        public boolean f288d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4435e;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        public int a() {
            if (this.f4434d < 0) {
                b();
            }
            return this.f4434d;
        }

        public b a(int i) {
            this.f287c = true;
            this.f4431a = i;
            return this;
        }

        public b a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.a());
                } else if (a2 == 24) {
                    a(bVar.b());
                } else if (a2 == 32) {
                    b(bVar.b());
                } else if (a2 == 40) {
                    c(bVar.b());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f285a = true;
            this.f286b = z;
            return this;
        }

        public void a(c cVar) {
            if (b()) {
                cVar.a(1, a());
            }
            if (c()) {
                cVar.a(3, c());
            }
            if (d()) {
                cVar.a(4, d());
            }
            if (e()) {
                cVar.a(5, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m434a() {
            return this.f286b;
        }

        public int b() {
            int i = 0;
            if (b()) {
                i = 0 + c.a(1, a());
            }
            if (c()) {
                i += c.a(3, c());
            }
            if (d()) {
                i += c.a(4, d());
            }
            if (e()) {
                i += c.a(5, e());
            }
            this.f4434d = i;
            return i;
        }

        public b b(int i) {
            this.f288d = true;
            this.f4432b = i;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m435b() {
            return this.f285a;
        }

        public int c() {
            return this.f4431a;
        }

        public b c(int i) {
            this.f4435e = true;
            this.f4433c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m436c() {
            return this.f287c;
        }

        public int d() {
            return this.f4432b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m437d() {
            return this.f288d;
        }

        public int e() {
            return this.f4433c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m438e() {
            return this.f4435e;
        }
    }

    public static final class c extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4436a = -1;

        /* renamed from: a  reason: collision with other field name */
        public String f289a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f290a;

        /* renamed from: b  reason: collision with root package name */
        public String f4437b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f291b;

        /* renamed from: c  reason: collision with root package name */
        public String f4438c = "";

        /* renamed from: c  reason: collision with other field name */
        public boolean f292c;

        /* renamed from: d  reason: collision with root package name */
        public String f4439d = "";

        /* renamed from: d  reason: collision with other field name */
        public boolean f293d;

        /* renamed from: e  reason: collision with root package name */
        public String f4440e = "";

        /* renamed from: e  reason: collision with other field name */
        public boolean f294e;

        /* renamed from: f  reason: collision with root package name */
        public String f4441f = "";

        /* renamed from: f  reason: collision with other field name */
        public boolean f295f;

        public int a() {
            if (this.f4436a < 0) {
                b();
            }
            return this.f4436a;
        }

        public c a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.a());
                } else if (a2 == 18) {
                    b(bVar.a());
                } else if (a2 == 26) {
                    c(bVar.a());
                } else if (a2 == 34) {
                    d(bVar.a());
                } else if (a2 == 42) {
                    e(bVar.a());
                } else if (a2 == 50) {
                    f(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f290a = true;
            this.f289a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m439a() {
            return this.f289a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, a());
            }
            if (b()) {
                cVar.a(2, b());
            }
            if (c()) {
                cVar.a(3, c());
            }
            if (d()) {
                cVar.a(4, d());
            }
            if (e()) {
                cVar.a(5, e());
            }
            if (f()) {
                cVar.a(6, f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m440a() {
            return this.f290a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, a());
            }
            if (b()) {
                i += c.a(2, b());
            }
            if (c()) {
                i += c.a(3, c());
            }
            if (d()) {
                i += c.a(4, d());
            }
            if (e()) {
                i += c.a(5, e());
            }
            if (f()) {
                i += c.a(6, f());
            }
            this.f4436a = i;
            return i;
        }

        public c b(String str) {
            this.f291b = true;
            this.f4437b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m441b() {
            return this.f4437b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m442b() {
            return this.f291b;
        }

        public c c(String str) {
            this.f292c = true;
            this.f4438c = str;
            return this;
        }

        public String c() {
            return this.f4438c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m443c() {
            return this.f292c;
        }

        public c d(String str) {
            this.f293d = true;
            this.f4439d = str;
            return this;
        }

        public String d() {
            return this.f4439d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m444d() {
            return this.f293d;
        }

        public c e(String str) {
            this.f294e = true;
            this.f4440e = str;
            return this;
        }

        public String e() {
            return this.f4440e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m445e() {
            return this.f294e;
        }

        public c f(String str) {
            this.f295f = true;
            this.f4441f = str;
            return this;
        }

        public String f() {
            return this.f4441f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m446f() {
            return this.f295f;
        }
    }

    public static final class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4442a = -1;

        /* renamed from: a  reason: collision with other field name */
        public String f296a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f297a;

        /* renamed from: b  reason: collision with root package name */
        public String f4443b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f298b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f4444c = "";

        /* renamed from: c  reason: collision with other field name */
        public boolean f299c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4445d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4446e;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        public int a() {
            if (this.f4442a < 0) {
                b();
            }
            return this.f4442a;
        }

        public d a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.a());
                } else if (a2 == 18) {
                    a(bVar.a());
                } else if (a2 == 26) {
                    b(bVar.a());
                } else if (a2 == 34) {
                    c(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f299c = true;
            this.f296a = str;
            return this;
        }

        public d a(boolean z) {
            this.f297a = true;
            this.f298b = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m447a() {
            return this.f296a;
        }

        public void a(c cVar) {
            if (b()) {
                cVar.a(1, a());
            }
            if (c()) {
                cVar.a(2, a());
            }
            if (d()) {
                cVar.a(3, b());
            }
            if (e()) {
                cVar.a(4, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m448a() {
            return this.f298b;
        }

        public int b() {
            int i = 0;
            if (b()) {
                i = 0 + c.a(1, a());
            }
            if (c()) {
                i += c.a(2, a());
            }
            if (d()) {
                i += c.a(3, b());
            }
            if (e()) {
                i += c.a(4, c());
            }
            this.f4442a = i;
            return i;
        }

        public d b(String str) {
            this.f4445d = true;
            this.f4443b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m449b() {
            return this.f4443b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m450b() {
            return this.f297a;
        }

        public d c(String str) {
            this.f4446e = true;
            this.f4444c = str;
            return this;
        }

        public String c() {
            return this.f4444c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m451c() {
            return this.f299c;
        }

        public boolean d() {
            return this.f4445d;
        }

        public boolean e() {
            return this.f4446e;
        }
    }

    public static final class e extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4447a = 0;

        /* renamed from: a  reason: collision with other field name */
        public b f300a = null;

        /* renamed from: a  reason: collision with other field name */
        public String f301a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f302a;

        /* renamed from: b  reason: collision with root package name */
        public int f4448b = 0;

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public int f4449c = 0;

        /* renamed from: c  reason: collision with other field name */
        public String f305c = "";

        /* renamed from: c  reason: collision with other field name */
        public boolean f306c;

        /* renamed from: d  reason: collision with root package name */
        public int f4450d = -1;

        /* renamed from: d  reason: collision with other field name */
        public String f307d = "";

        /* renamed from: d  reason: collision with other field name */
        public boolean f308d;

        /* renamed from: e  reason: collision with root package name */
        public String f4451e = "";

        /* renamed from: e  reason: collision with other field name */
        public boolean f309e;

        /* renamed from: f  reason: collision with root package name */
        public String f4452f = "";

        /* renamed from: f  reason: collision with other field name */
        public boolean f310f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;

        public int a() {
            if (this.f4450d < 0) {
                b();
            }
            return this.f4450d;
        }

        /* renamed from: a  reason: collision with other method in class */
        public b m452a() {
            return this.f300a;
        }

        public e a(int i2) {
            this.f302a = true;
            this.f4447a = i2;
            return this;
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.i = true;
                this.f300a = bVar;
                return this;
            }
            throw null;
        }

        public e a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.a());
                        break;
                    case 26:
                        b(bVar.a());
                        break;
                    case 34:
                        c(bVar.a());
                        break;
                    case 40:
                        b(bVar.b());
                        break;
                    case 50:
                        d(bVar.a());
                        break;
                    case 58:
                        e(bVar.a());
                        break;
                    case 66:
                        f(bVar.a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a((e) bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.b());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(String str) {
            this.f304b = true;
            this.f301a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m453a() {
            return this.f301a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.b(1, c());
            }
            if (b()) {
                cVar.a(2, a());
            }
            if (c()) {
                cVar.a(3, b());
            }
            if (d()) {
                cVar.a(4, c());
            }
            if (e()) {
                cVar.a(5, d());
            }
            if (f()) {
                cVar.a(6, d());
            }
            if (g()) {
                cVar.a(7, e());
            }
            if (h()) {
                cVar.a(8, f());
            }
            if (i()) {
                cVar.a(9, (e) a());
            }
            if (j()) {
                cVar.a(10, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m454a() {
            return this.f302a;
        }

        public int b() {
            int i2 = 0;
            if (a()) {
                i2 = 0 + c.b(1, c());
            }
            if (b()) {
                i2 += c.a(2, a());
            }
            if (c()) {
                i2 += c.a(3, b());
            }
            if (d()) {
                i2 += c.a(4, c());
            }
            if (e()) {
                i2 += c.a(5, d());
            }
            if (f()) {
                i2 += c.a(6, d());
            }
            if (g()) {
                i2 += c.a(7, e());
            }
            if (h()) {
                i2 += c.a(8, f());
            }
            if (i()) {
                i2 += c.a(9, (e) a());
            }
            if (j()) {
                i2 += c.a(10, e());
            }
            this.f4450d = i2;
            return i2;
        }

        public e b(int i2) {
            this.f309e = true;
            this.f4448b = i2;
            return this;
        }

        public e b(String str) {
            this.f306c = true;
            this.f303b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m455b() {
            return this.f303b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m456b() {
            return this.f304b;
        }

        public int c() {
            return this.f4447a;
        }

        public e c(int i2) {
            this.j = true;
            this.f4449c = i2;
            return this;
        }

        public e c(String str) {
            this.f308d = true;
            this.f305c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m457c() {
            return this.f305c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m458c() {
            return this.f306c;
        }

        public int d() {
            return this.f4448b;
        }

        public e d(String str) {
            this.f310f = true;
            this.f307d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m459d() {
            return this.f307d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m460d() {
            return this.f308d;
        }

        public int e() {
            return this.f4449c;
        }

        public e e(String str) {
            this.g = true;
            this.f4451e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m461e() {
            return this.f4451e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m462e() {
            return this.f309e;
        }

        public e f(String str) {
            this.h = true;
            this.f4452f = str;
            return this;
        }

        public String f() {
            return this.f4452f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m463f() {
            return this.f310f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    public static final class f extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4453a = -1;

        /* renamed from: a  reason: collision with other field name */
        public b f311a = null;

        /* renamed from: a  reason: collision with other field name */
        public String f312a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f313a;

        /* renamed from: b  reason: collision with root package name */
        public String f4454b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f314b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4455c;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        public int a() {
            if (this.f4453a < 0) {
                b();
            }
            return this.f4453a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public b m464a() {
            return this.f311a;
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f4455c = true;
                this.f311a = bVar;
                return this;
            }
            throw null;
        }

        public f a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.a());
                } else if (a2 == 18) {
                    b(bVar.a());
                } else if (a2 == 26) {
                    b bVar2 = new b();
                    bVar.a((e) bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public f a(String str) {
            this.f313a = true;
            this.f312a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m465a() {
            return this.f312a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, a());
            }
            if (b()) {
                cVar.a(2, b());
            }
            if (c()) {
                cVar.a(3, (e) a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m466a() {
            return this.f313a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, a());
            }
            if (b()) {
                i += c.a(2, b());
            }
            if (c()) {
                i += c.a(3, (e) a());
            }
            this.f4453a = i;
            return i;
        }

        public f b(String str) {
            this.f314b = true;
            this.f4454b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m467b() {
            return this.f4454b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m468b() {
            return this.f314b;
        }

        public boolean c() {
            return this.f4455c;
        }
    }

    public static final class g extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4456a = -1;

        /* renamed from: a  reason: collision with other field name */
        public String f315a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f316a;

        /* renamed from: b  reason: collision with root package name */
        public String f4457b = "";

        /* renamed from: b  reason: collision with other field name */
        public boolean f317b;

        /* renamed from: c  reason: collision with root package name */
        public String f4458c = "";

        /* renamed from: c  reason: collision with other field name */
        public boolean f318c;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        public int a() {
            if (this.f4456a < 0) {
                b();
            }
            return this.f4456a;
        }

        public g a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.a());
                } else if (a2 == 18) {
                    b(bVar.a());
                } else if (a2 == 26) {
                    c(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f316a = true;
            this.f315a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m469a() {
            return this.f315a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, a());
            }
            if (b()) {
                cVar.a(2, b());
            }
            if (c()) {
                cVar.a(3, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m470a() {
            return this.f316a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, a());
            }
            if (b()) {
                i += c.a(2, b());
            }
            if (c()) {
                i += c.a(3, c());
            }
            this.f4456a = i;
            return i;
        }

        public g b(String str) {
            this.f317b = true;
            this.f4457b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m471b() {
            return this.f4457b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m472b() {
            return this.f317b;
        }

        public g c(String str) {
            this.f318c = true;
            this.f4458c = str;
            return this;
        }

        public String c() {
            return this.f4458c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m473c() {
            return this.f318c;
        }
    }

    public static final class h extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4459a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f319a = "";

        /* renamed from: a  reason: collision with other field name */
        public boolean f320a;

        /* renamed from: b  reason: collision with root package name */
        public int f4460b = -1;

        /* renamed from: b  reason: collision with other field name */
        public boolean f321b;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        public int a() {
            if (this.f4460b < 0) {
                b();
            }
            return this.f4460b;
        }

        public h a(int i) {
            this.f320a = true;
            this.f4459a = i;
            return this;
        }

        public h a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.b());
                } else if (a2 == 18) {
                    a(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f321b = true;
            this.f319a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m474a() {
            return this.f319a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, c());
            }
            if (b()) {
                cVar.a(2, a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m475a() {
            return this.f320a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, c());
            }
            if (b()) {
                i += c.a(2, a());
            }
            this.f4460b = i;
            return i;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m476b() {
            return this.f321b;
        }

        public int c() {
            return this.f4459a;
        }
    }

    public static final class i extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4461a = -1;

        /* renamed from: a  reason: collision with other field name */
        public a f322a = a.f4391a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f323a;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        public int a() {
            if (this.f4461a < 0) {
                b();
            }
            return this.f4461a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public a m477a() {
            return this.f322a;
        }

        public i a(a aVar) {
            this.f323a = true;
            this.f322a = aVar;
            return this;
        }

        public i a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m478a() {
            return this.f323a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, a());
            }
            this.f4461a = i;
            return i;
        }
    }

    public static final class j extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4462a = -1;

        /* renamed from: a  reason: collision with other field name */
        public a f324a = a.f4391a;

        /* renamed from: a  reason: collision with other field name */
        public b f325a = null;

        /* renamed from: a  reason: collision with other field name */
        public boolean f326a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4463b;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        public int a() {
            if (this.f4462a < 0) {
                b();
            }
            return this.f4462a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public a m479a() {
            return this.f324a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public b m480a() {
            return this.f325a;
        }

        public j a(a aVar) {
            this.f326a = true;
            this.f324a = aVar;
            return this;
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f4463b = true;
                this.f325a = bVar;
                return this;
            }
            throw null;
        }

        public j a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.a());
                } else if (a2 == 18) {
                    b bVar2 = new b();
                    bVar.a((e) bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public void a(c cVar) {
            if (a()) {
                cVar.a(1, a());
            }
            if (b()) {
                cVar.a(2, (e) a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m481a() {
            return this.f326a;
        }

        public int b() {
            int i = 0;
            if (a()) {
                i = 0 + c.a(1, a());
            }
            if (b()) {
                i += c.a(2, (e) a());
            }
            this.f4462a = i;
            return i;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m482b() {
            return this.f4463b;
        }
    }
}
