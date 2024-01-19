package org.objectweb.asm;

public final class Item {

    /* renamed from: a  reason: collision with root package name */
    public int f6226a;

    /* renamed from: b  reason: collision with root package name */
    public int f6227b;

    /* renamed from: c  reason: collision with root package name */
    public int f6228c;

    /* renamed from: d  reason: collision with root package name */
    public long f6229d;
    public String g;
    public String h;
    public String i;
    public int j;
    public Item k;

    public Item() {
    }

    public Item(int i2) {
        this.f6226a = i2;
    }

    public Item(int i2, Item item) {
        this.f6226a = i2;
        this.f6227b = item.f6227b;
        this.f6228c = item.f6228c;
        this.f6229d = item.f6229d;
        this.g = item.g;
        this.h = item.h;
        this.i = item.i;
        this.j = item.j;
    }

    public void a(int i2, String str, String str2, String str3) {
        int hashCode;
        int i3;
        this.f6227b = i2;
        this.g = str;
        this.h = str2;
        this.i = str3;
        if (i2 != 1) {
            if (i2 == 12) {
                i3 = ((str2.hashCode() * str.hashCode()) + i2) & Integer.MAX_VALUE;
                this.j = i3;
            } else if (!(i2 == 16 || i2 == 30)) {
                if (i2 == 7) {
                    this.f6228c = 0;
                } else if (i2 != 8) {
                    hashCode = str3.hashCode() * str2.hashCode() * str.hashCode();
                    i3 = (hashCode + i2) & Integer.MAX_VALUE;
                    this.j = i3;
                }
            }
        }
        hashCode = str.hashCode();
        i3 = (hashCode + i2) & Integer.MAX_VALUE;
        this.j = i3;
    }
}
