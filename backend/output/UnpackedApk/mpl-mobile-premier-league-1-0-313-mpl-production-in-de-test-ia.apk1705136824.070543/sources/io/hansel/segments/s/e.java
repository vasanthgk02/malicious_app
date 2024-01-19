package io.hansel.segments.s;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f5303a = new ArrayList();

    public void a() {
        this.f5303a.add(" AND ");
    }

    public void a(String str) {
        List<String> list = this.f5303a;
        list.add(0, "SELECT * FROM " + str);
    }

    public void a(String str, long j, long j2) {
        List<String> list = this.f5303a;
        list.add(str + " BETWEEN " + j + " AND " + j2);
    }

    public void a(String str, String str2, String str3) {
        this.f5303a.add(GeneratedOutlineSupport.outline54(str, str3, "'", str2, "'"));
    }

    public void a(boolean z, String str) {
        List<String> list;
        StringBuilder sb;
        if (z) {
            list = this.f5303a;
            sb = new StringBuilder();
            sb.append(" ORDER BY ");
            sb.append(str);
            str = " DESC";
        } else {
            list = this.f5303a;
            sb = new StringBuilder();
            sb.append(" ORDER BY ");
        }
        sb.append(str);
        list.add(sb.toString());
    }

    public void b() {
        this.f5303a.add(")");
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        int size = this.f5303a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f5303a.get(i));
        }
        HSLLogger.d("Query:        " + sb);
        return sb.toString();
    }

    public void d() {
        this.f5303a.add("(");
    }

    public void e() {
        this.f5303a.add(" OR ");
    }

    public void f() {
        this.f5303a.add(" WHERE ");
    }
}
