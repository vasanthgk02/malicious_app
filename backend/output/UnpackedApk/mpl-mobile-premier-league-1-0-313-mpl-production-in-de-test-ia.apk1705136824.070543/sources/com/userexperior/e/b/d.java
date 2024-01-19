package com.userexperior.e.b;

import com.userexperior.e.c;
import com.userexperior.e.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public long f3953a;

    /* renamed from: b  reason: collision with root package name */
    public String f3954b;

    /* renamed from: c  reason: collision with root package name */
    public String f3955c;

    /* renamed from: d  reason: collision with root package name */
    public long f3956d;

    /* renamed from: e  reason: collision with root package name */
    public long f3957e;

    /* renamed from: f  reason: collision with root package name */
    public long f3958f;
    public long g;
    public Map<String, String> h;

    public d() {
    }

    public d(String str, c cVar) {
        this.f3954b = str;
        this.f3953a = (long) cVar.f3973a.length;
        this.f3955c = cVar.f3974b;
        this.f3956d = cVar.f3975c;
        this.f3957e = cVar.f3976d;
        this.f3958f = cVar.f3977e;
        this.g = cVar.f3978f;
        this.h = cVar.g;
    }

    public static d a(InputStream inputStream) throws IOException {
        d dVar = new d();
        if (c.a(inputStream) == 538247942) {
            dVar.f3954b = c.c(inputStream);
            String c2 = c.c(inputStream);
            dVar.f3955c = c2;
            if (c2.equals("")) {
                dVar.f3955c = null;
            }
            dVar.f3956d = c.b(inputStream);
            dVar.f3957e = c.b(inputStream);
            dVar.f3958f = c.b(inputStream);
            dVar.g = c.b(inputStream);
            dVar.h = c.d(inputStream);
            return dVar;
        }
        throw new IOException();
    }

    public final boolean a(OutputStream outputStream) {
        try {
            c.a(outputStream, 538247942);
            c.a(outputStream, this.f3954b);
            c.a(outputStream, this.f3955c == null ? "" : this.f3955c);
            c.a(outputStream, this.f3956d);
            c.a(outputStream, this.f3957e);
            c.a(outputStream, this.f3958f);
            c.a(outputStream, this.g);
            Map<String, String> map = this.h;
            if (map != null) {
                c.a(outputStream, map.size());
                for (Entry next : map.entrySet()) {
                    c.a(outputStream, (String) next.getKey());
                    c.a(outputStream, (String) next.getValue());
                }
            } else {
                c.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e2) {
            z.b("%s", e2.toString());
            return false;
        }
    }
}
