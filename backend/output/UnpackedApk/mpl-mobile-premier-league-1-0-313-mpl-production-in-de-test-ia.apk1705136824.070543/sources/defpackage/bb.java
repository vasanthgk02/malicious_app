package defpackage;

import android.content.Context;
import com.amazon.identity.auth.device.AuthError;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: bb  reason: default package */
public class bb extends at<bc> {

    /* renamed from: a  reason: collision with root package name */
    public final cc f2780a;

    public bb(Context context, cc ccVar, ag agVar) throws AuthError {
        super(context, agVar);
        this.f2780a = ccVar;
    }

    public bd a(HttpResponse httpResponse) {
        return new bc(httpResponse, this.f2755a, null);
    }

    public String b() {
        return "refresh_token";
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<BasicNameValuePair> m255b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("refresh_token", this.f2780a.f2717b));
        return arrayList;
    }

    public void c() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Executing OAuth access token exchange. appId=");
        outline73.append(this.f2755a);
        String sb = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("refreshAtzToken=");
        outline732.append(this.f2780a.f2717b);
        cp.a((String) "bb", sb, outline732.toString());
    }
}
