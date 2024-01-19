package io.hansel.userjourney.prompts;

import com.android.tools.r8.GeneratedOutlineSupport;

public class j implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public String f5554a;

    /* renamed from: b  reason: collision with root package name */
    public long f5555b;

    /* renamed from: c  reason: collision with root package name */
    public String f5556c;

    public j(String str, long j, String str2) {
        this.f5554a = str;
        this.f5555b = j;
        this.f5556c = str2;
    }

    public String a() {
        return this.f5556c;
    }

    public String b() {
        return this.f5554a;
    }

    public int compareTo(Object obj) {
        j jVar = (j) obj;
        int i = (jVar.f5555b > this.f5555b ? 1 : (jVar.f5555b == this.f5555b ? 0 : -1));
        return i == 0 ? jVar.f5554a.compareTo(this.f5554a) : i < 0 ? -1 : 1;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{");
        outline73.append(this.f5554a);
        outline73.append(",");
        outline73.append(this.f5555b);
        outline73.append(",");
        return GeneratedOutlineSupport.outline62(outline73, this.f5556c, "}");
    }
}
