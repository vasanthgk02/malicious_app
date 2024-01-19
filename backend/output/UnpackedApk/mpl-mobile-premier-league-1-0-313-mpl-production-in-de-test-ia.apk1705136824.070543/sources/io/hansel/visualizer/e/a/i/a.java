package io.hansel.visualizer.e.a.i;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.visualizer.e.a.h.d;
import io.hansel.visualizer.e.a.j.f;

public class a implements b {
    public String a() {
        return "";
    }

    public void a(f fVar) {
    }

    public boolean a(String str) {
        return true;
    }

    public String b() {
        return "";
    }

    public void b(f fVar) {
    }

    public boolean b(String str) {
        return true;
    }

    public b c() {
        return new a();
    }

    public void c(f fVar) {
        if (fVar.d() || fVar.b() || fVar.e()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("bad rsv RSV1: ");
            outline73.append(fVar.d());
            outline73.append(" RSV2: ");
            outline73.append(fVar.b());
            outline73.append(" RSV3: ");
            outline73.append(fVar.e());
            throw new d(outline73.toString());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (a.class != obj.getClass()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return a.class.hashCode();
    }

    public void reset() {
    }

    public String toString() {
        return a.class.getSimpleName();
    }
}
