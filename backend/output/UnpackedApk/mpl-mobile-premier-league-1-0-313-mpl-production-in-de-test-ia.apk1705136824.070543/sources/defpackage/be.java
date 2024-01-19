package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: be  reason: default package */
public class be extends au<bf> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2784a;

    /* renamed from: b  reason: collision with root package name */
    public String f2785b;

    public be(Bundle bundle, String str, Context context, ag agVar) {
        super(context, agVar);
        this.f2785b = str;
        if (bundle != null) {
            this.f2784a = bundle.getBoolean(ch$b.SANDBOX.f89a, false);
        }
    }

    public bd a(HttpResponse httpResponse) {
        return new bf(httpResponse);
    }

    public String a() {
        return "/user/profile";
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<Header> m258a() {
        ArrayList arrayList = new ArrayList();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
        outline73.append(this.f2785b);
        arrayList.add(new BasicHeader("Authorization", outline73.toString()));
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m259a() {
        return this.f2784a;
    }

    public List<BasicNameValuePair> c() {
        return new ArrayList();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m260c() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("accessToken=");
        outline73.append(this.f2785b);
        cp.a((String) "be", (String) "Executing profile request", outline73.toString());
    }
}
