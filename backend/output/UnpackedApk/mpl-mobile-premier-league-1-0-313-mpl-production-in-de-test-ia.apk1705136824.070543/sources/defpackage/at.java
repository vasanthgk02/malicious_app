package defpackage;

import android.content.Context;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import defpackage.bd;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: at  reason: default package */
public abstract class at<T extends bd> extends av<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f2755a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2756b;

    public at(Context context, ag agVar) throws AuthError {
        super(context, agVar);
        if (agVar != null) {
            this.f2755a = agVar.f2705b;
            this.f2756b = agVar.f2708e;
            return;
        }
        throw new AuthError("Appinfo can not be null to make an OAuthTokenRequest", ERROR_TYPE.ERROR_UNKNOWN);
    }

    public String a() {
        return "/auth/o2/token";
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<Header> m245a() {
        return new ArrayList();
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public abstract List<BasicNameValuePair> m246b();

    public List<BasicNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("grant_type", b()));
        arrayList.add(new BasicNameValuePair(PaymentConstants.CLIENT_ID, this.f2756b));
        List b2 = b();
        if (b2 != null) {
            arrayList.addAll(b2);
        }
        return arrayList;
    }
}
