package defpackage;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: ax  reason: default package */
public class ax extends as<ay> {

    /* renamed from: b  reason: collision with root package name */
    public String f2762b;

    public ax(Context context, ag agVar, String str) {
        super(context, agVar);
        this.f2762b = str;
    }

    public bd a(HttpResponse httpResponse) {
        return new ay(httpResponse);
    }

    public String a() {
        return "/auth/relyingPartyLogout";
    }

    public List<BasicNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("token_type", "bearer"));
        arrayList.add(new BasicNameValuePair("token", this.f2762b));
        return arrayList;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m253c() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("accessToken=");
        outline73.append(this.f2762b);
        cp.a((String) "ax", (String) "Executing logout request", outline73.toString());
    }
}
