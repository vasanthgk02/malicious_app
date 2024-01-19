package com.cardinalcommerce.dependencies.internal.minidev.json.b;

public class h extends e {
    public String x;

    public h(int i) {
        super(i);
    }

    public void b(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.x.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.x.charAt(i3))) {
                this.j = this.x.substring(i, i2);
            } else {
                i2 = i3;
            }
        }
        this.j = this.x.substring(i, i2);
    }

    public void d() {
        int i = this.k + 1;
        this.k = i;
        this.f1924a = i >= this.w ? 26 : this.x.charAt(i);
    }

    public void f() {
        int i = this.k + 1;
        this.k = i;
        this.f1924a = i >= this.w ? 26 : this.x.charAt(i);
    }
}
