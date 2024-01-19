package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class at {

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public int f4419a = 0;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f269a = Collections.emptyList();

        /* renamed from: a  reason: collision with other field name */
        public boolean f270a;

        /* renamed from: b  reason: collision with root package name */
        public int f4420b = 0;

        /* renamed from: b  reason: collision with other field name */
        public boolean f271b;

        /* renamed from: c  reason: collision with root package name */
        public int f4421c = -1;

        /* renamed from: c  reason: collision with other field name */
        public boolean f272c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4422d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4423e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4424f = false;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        public int a() {
            if (this.f4421c < 0) {
                b();
            }
            return this.f4421c;
        }

        public a a(int i) {
            this.f270a = true;
            this.f4419a = i;
            return this;
        }

        public a a(b bVar) {
            while (true) {
                int a2 = bVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.c());
                } else if (a2 == 16) {
                    a(bVar.a());
                } else if (a2 == 24) {
                    b(bVar.b());
                } else if (a2 == 32) {
                    b(bVar.a());
                } else if (a2 == 42) {
                    a(bVar.a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            if (str != null) {
                if (this.f269a.isEmpty()) {
                    this.f269a = new ArrayList();
                }
                this.f269a.add(str);
                return this;
            }
            throw null;
        }

        public a a(boolean z) {
            this.f271b = true;
            this.f272c = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public List<String> m415a() {
            return this.f269a;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.b(1, c());
            }
            if (c()) {
                cVar.a(2, b());
            }
            if (d()) {
                cVar.a(3, d());
            }
            if (f()) {
                cVar.a(4, e());
            }
            for (String a2 : a()) {
                cVar.a(5, a2);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m416a() {
            return this.f270a;
        }

        public int b() {
            int i = 0;
            int b2 = a() ? c.b(1, c()) + 0 : 0;
            if (c()) {
                b2 += c.a(2, b());
            }
            if (d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, e());
            }
            for (String a2 : a()) {
                i += c.a(a2);
            }
            int size = (a().size() * 1) + b2 + i;
            this.f4421c = size;
            return size;
        }

        public a b(int i) {
            this.f4422d = true;
            this.f4420b = i;
            return this;
        }

        public a b(boolean z) {
            this.f4423e = true;
            this.f4424f = z;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m417b() {
            return this.f272c;
        }

        public int c() {
            return this.f4419a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m418c() {
            return this.f271b;
        }

        public int d() {
            return this.f4420b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m419d() {
            return this.f4422d;
        }

        public boolean e() {
            return this.f4424f;
        }

        public boolean f() {
            return this.f4423e;
        }
    }
}
