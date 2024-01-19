package defpackage;

import android.content.Context;
import com.amazon.identity.auth.device.AuthError;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: az  reason: default package */
public class az extends at<ba> {

    /* renamed from: b  reason: collision with root package name */
    public final String f2764b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2765c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2766d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2767e;

    public az(String str, String str2, String str3, String str4, ag agVar, Context context) throws AuthError {
        super(context, agVar);
        this.f2764b = str;
        this.f2765c = str3;
        this.f2766d = str4;
        this.f2767e = str2;
    }

    public bd a(HttpResponse httpResponse) {
        return new ba(httpResponse, this.f2755a, this.f2766d);
    }

    public String b() {
        return "authorization_code";
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<BasicNameValuePair> m254b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("code", this.f2764b));
        arrayList.add(new BasicNameValuePair("redirect_uri", this.f2765c));
        arrayList.add(new BasicNameValuePair("code_verifier", this.f2767e));
        return arrayList;
    }

    public void c() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Executing OAuth Code for Token Exchange. redirectUri=");
        outline73.append(this.f2765c);
        outline73.append(" appId=");
        outline73.append(this.f2755a);
        String sb = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("code=");
        outline732.append(this.f2764b);
        cp.a((String) "az", sb, outline732.toString());
    }
}
