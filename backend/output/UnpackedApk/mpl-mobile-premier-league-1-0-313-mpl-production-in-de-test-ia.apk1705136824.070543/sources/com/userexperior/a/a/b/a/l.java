package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.o;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.u;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

public final class l<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final o<T> f3605a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, m> f3606b;

    public l(o<T> oVar, Map<String, m> map) {
        this.f3605a = oVar;
        this.f3606b = map;
    }

    public final T a(a aVar) throws IOException {
        StringBuilder sb;
        Level level;
        String str;
        T t = null;
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            t = this.f3605a.a();
            aVar.c();
            while (aVar.e()) {
                m mVar = this.f3606b.get(aVar.h());
                if (mVar != null) {
                    if (mVar.j) {
                        mVar.a(aVar, (Object) t);
                    }
                }
                aVar.o();
            }
        } catch (IllegalStateException e2) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a - ");
            str = e2.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            aVar.d();
            return t;
        } catch (IllegalAccessException e3) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a - ");
            str = e3.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            aVar.d();
            return t;
        } catch (Exception e4) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a - ");
            str = e4.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            aVar.d();
            return t;
        } catch (Error e5) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a - ");
            str = e5.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            aVar.d();
            return t;
        }
        aVar.d();
        return t;
    }

    public final void a(c cVar, T t) throws IOException {
        String str;
        StringBuilder sb;
        Level level;
        if (t == null) {
            cVar.e();
            return;
        }
        try {
            cVar.c();
            for (m next : this.f3606b.values()) {
                if (next.a(t)) {
                    cVar.a(next.h);
                    next.a(cVar, (Object) t);
                }
            }
        } catch (IllegalAccessException e2) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a:w - ");
            str = e2.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            cVar.d();
        } catch (Exception e3) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a:w - ");
            str = e3.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            cVar.d();
        } catch (Error e4) {
            level = Level.INFO;
            sb = new StringBuilder("rtaf:a:w - ");
            str = e4.getMessage();
            sb.append(str);
            com.userexperior.utilities.b.a(level, sb.toString());
            cVar.d();
        }
        cVar.d();
    }
}
