package defpackage;

/* renamed from: ce  reason: default package */
public enum ce {
    MD5("MD5"),
    SHA_256("SHA-256");
    

    /* renamed from: a  reason: collision with other field name */
    public String f83a;

    /* access modifiers changed from: public */
    ce(String str) {
        this.f83a = str;
    }

    public String a() {
        return this.f83a;
    }
}
