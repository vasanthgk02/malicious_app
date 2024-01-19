package defpackage;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;

/* renamed from: o  reason: default package */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public final ae f3323a;

    /* renamed from: a  reason: collision with other field name */
    public final ag f139a;

    /* renamed from: a  reason: collision with other field name */
    public final Bundle f140a;

    /* renamed from: a  reason: collision with other field name */
    public final String[] f141a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3324b;

    public o(AuthorizeRequest authorizeRequest, String str, String[] strArr, Bundle bundle, ag agVar, ae aeVar) {
        super(authorizeRequest);
        this.f3324b = str;
        this.f141a = strArr;
        this.f140a = bundle;
        this.f139a = agVar;
        this.f3323a = aeVar;
        if (authorizeRequest != null) {
            bundle.putString("InteractiveRequestType", authorizeRequest.getRequestType());
        }
    }
}
