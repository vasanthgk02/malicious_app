package com.userexperior.e.b;

import com.userexperior.e.a;
import com.userexperior.e.m;
import com.userexperior.e.o;
import com.userexperior.e.r;
import com.userexperior.e.s;
import com.userexperior.e.t;
import com.userexperior.e.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

public class l extends o<String> {

    /* renamed from: a  reason: collision with root package name */
    public final String f3964a = "--";

    /* renamed from: b  reason: collision with root package name */
    public final String f3965b = "\r\n";

    /* renamed from: c  reason: collision with root package name */
    public final String f3966c = ("===" + System.currentTimeMillis() + "===");

    /* renamed from: d  reason: collision with root package name */
    public t<String> f3967d;

    /* renamed from: e  reason: collision with root package name */
    public s f3968e;
    public Map<String, String> q;

    public l(String str, t<String> tVar, s sVar) {
        super(str, sVar);
        this.f3967d = tVar;
        this.f3968e = sVar;
    }

    private void a(DataOutputStream dataOutputStream, Map<String, m> map) throws IOException {
        for (Entry next : map.entrySet()) {
            m mVar = (m) next.getValue();
            dataOutputStream.writeBytes("--" + this.f3966c + "\r\n");
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"; filename=\"" + mVar.f3969a + "\"\r\n");
            String str = mVar.f3971c;
            if (str != null && !str.trim().isEmpty()) {
                dataOutputStream.writeBytes("Content-Type: " + mVar.f3971c + "\r\n");
            }
            dataOutputStream.writeBytes("\r\n");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mVar.f3970b);
            int min = Math.min(byteArrayInputStream.available(), 1048576);
            byte[] bArr = new byte[min];
            while (byteArrayInputStream.read(bArr, 0, min) > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(byteArrayInputStream.available(), 1048576);
            }
            dataOutputStream.writeBytes("\r\n");
        }
    }

    private void a(DataOutputStream dataOutputStream, Map<String, String> map, String str) throws IOException {
        try {
            for (Entry next : map.entrySet()) {
                dataOutputStream.writeBytes("--" + this.f3966c + "\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes(((String) next.getValue()) + "\r\n");
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: ".concat(String.valueOf(str)), e2);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    public final r<String> a(m mVar) {
        String str;
        try {
            str = new String(mVar.f4008b, f.a(mVar.f4009c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(mVar.f4008b);
        }
        return r.a(str, f.a(mVar));
    }

    public Map<String, m> a() throws a {
        return null;
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f3967d.a((String) obj);
    }

    public final void b(y yVar) {
        this.f3968e.a(yVar);
    }

    public final Map<String, String> d() throws a {
        Map<String, String> map = this.q;
        return map != null ? map : super.d();
    }

    public final String f() {
        return "multipart/form-data;boundary=" + this.f3966c;
    }

    public final byte[] g() throws a {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            Map<String, String> b2 = b();
            if (b2 != null && b2.size() > 0) {
                a(dataOutputStream, b2, "UTF-8");
            }
            Map<String, m> a2 = a();
            if (a2 != null && a2.size() > 0) {
                a(dataOutputStream, a2);
            }
            dataOutputStream.writeBytes("--" + this.f3966c + "--\r\n");
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
