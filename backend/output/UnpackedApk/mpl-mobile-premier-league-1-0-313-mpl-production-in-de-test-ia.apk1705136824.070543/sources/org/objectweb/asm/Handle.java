package org.objectweb.asm;

public final class Handle {

    /* renamed from: a  reason: collision with root package name */
    public final int f6216a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6217b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6218c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6219d;

    public Handle(int i, String str, String str2, String str3) {
        this.f6216a = i;
        this.f6217b = str;
        this.f6218c = str2;
        this.f6219d = str3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        if (this.f6216a != handle.f6216a || !this.f6217b.equals(handle.f6217b) || !this.f6218c.equals(handle.f6218c) || !this.f6219d.equals(handle.f6219d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.f6219d.hashCode() * this.f6218c.hashCode() * this.f6217b.hashCode()) + this.f6216a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f6217b);
        stringBuffer.append('.');
        stringBuffer.append(this.f6218c);
        stringBuffer.append(this.f6219d);
        stringBuffer.append(" (");
        stringBuffer.append(this.f6216a);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
