package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.device.workflow.WorkflowActivity;
import com.amazon.identity.auth.internal.BrowsingExperienceManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* renamed from: e  reason: default package */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f3315a;

    /* renamed from: a  reason: collision with other field name */
    public final BrowsingExperienceManager f127a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, a> f128a = Collections.synchronizedMap(new LinkedHashMap(10));

    public e(BrowsingExperienceManager browsingExperienceManager) {
        this.f127a = browsingExperienceManager;
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f3315a == null) {
                    f3315a = new e(BrowsingExperienceManager.getInstance(context));
                }
                eVar = f3315a;
            }
        }
        return eVar;
    }

    public static String a(Uri uri) throws AuthError {
        String queryParameter = uri.getQueryParameter("state");
        if (queryParameter != null) {
            HashMap hashMap = new HashMap();
            for (String split : TextUtils.split(queryParameter, "&")) {
                String[] split2 = TextUtils.split(split, InflateView.SETTER_EQUALS);
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            String str = (String) hashMap.get("clientRequestId");
            if (str != null) {
                return str;
            }
            throw new AuthError(String.format("Response does not have a requestId: %s", new Object[]{uri.toString()}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        throw new AuthError(String.format("Response does not have a state parameter: %s", new Object[]{uri.toString()}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
    }

    public void a(a aVar, Context context) throws AuthError {
        String url;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Executing request ");
        outline73.append(aVar.f5a);
        cp.a((String) "e", outline73.toString());
        if (aVar.f2378a < 1) {
            aVar.f2378a++;
            while (this.f128a.size() >= 10) {
                synchronized (this.f128a) {
                    String next = this.f128a.keySet().iterator().next();
                    this.f128a.remove(next);
                    f.a().a(next);
                }
            }
            this.f128a.put(aVar.f5a, aVar);
            b bVar = c.f2808a;
            if (bVar.f2768a == null) {
                bVar.f2768a = Boolean.valueOf(!GeneratedOutlineSupport.outline106(context, new Intent(context, m.class), 65536));
            }
            boolean booleanValue = bVar.f2768a.booleanValue();
            b bVar2 = c.f2808a;
            if (bVar2.f2769b == null) {
                bVar2.f2769b = Boolean.valueOf(true ^ GeneratedOutlineSupport.outline106(context, new Intent(context, WorkflowActivity.class), 65536));
            }
            boolean booleanValue2 = bVar2.f2769b.booleanValue();
            if (booleanValue && booleanValue2) {
                throw new RuntimeException("Both AuthorizationActivity and WorkflowActivity are declared in your AndroidManifest.xml. This will cause your users to have to pick from the Android activity chooser when they are redirected back from the browser, and the SDK may not behave as expected. Please remove the deprecated AuthorizationActivity from the manifest.");
            } else if (booleanValue || booleanValue2) {
                InteractiveRequest<?, ?, ?, ?> interactiveRequest = aVar.f4a;
                if (interactiveRequest != null) {
                    interactiveRequest.getRequestContext().onStartRequest(new InteractiveRequestRecord(aVar.f5a, aVar.f4a.getRequestExtras()));
                }
                BrowsingExperienceManager browsingExperienceManager = this.f127a;
                RequestContext requestContext = aVar.f4a.getRequestContext();
                o oVar = (o) aVar;
                String packageName = context.getPackageName();
                String str = oVar.f3324b;
                String[] strArr = oVar.f141a;
                String str2 = oVar.f5a;
                Bundle bundle = oVar.f140a;
                try {
                    s sVar = new s(context, oVar.f139a);
                    sVar.f144a = y.AUTHORIZATION;
                    if (bundle.containsKey(ch$a.REGION.f87a)) {
                        sVar.f142a = TypeUtilsKt.a(bundle.getString(ch$a.REGION.f87a));
                    }
                    String a2 = n.a(context, packageName, str, strArr, str2, true, false, bundle);
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.a());
                    sb.append("/ap/oa");
                    sb.append(a2);
                    sb.append("&language=" + Locale.getDefault().toString());
                    sb.append(n.a(bundle));
                    cp.a((String) "n", (String) "Generating OAUTH2 URL", "url=" + url);
                    browsingExperienceManager.openUrl(requestContext, url);
                } catch (MalformedURLException e2) {
                    throw new AuthError("MalformedURLException", e2, ERROR_TYPE.ERROR_BAD_PARAM);
                }
            } else {
                throw new RuntimeException("WorkflowActivity is not declared in your app's AndroidManifest.xml Enable manifest merging or refer to the integration guide to manually add WorkflowActivity to your manifest.");
            }
        } else {
            throw new AuthError(String.format("Reached maximum attempts for the request: %s", new Object[]{aVar.f5a}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m305a(Uri uri) throws AuthError {
        String queryParameter = uri.getQueryParameter("state");
        if (queryParameter != null) {
            HashMap hashMap = new HashMap();
            for (String split : TextUtils.split(queryParameter, "&")) {
                String[] split2 = TextUtils.split(split, InflateView.SETTER_EQUALS);
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            if (((String) hashMap.get("InteractiveRequestType")) != null) {
                return true;
            }
            return false;
        }
        throw new AuthError(String.format("Response does not have a state parameter: %s", new Object[]{uri.toString()}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
    }

    public boolean a(Uri uri, Context context, RequestContext requestContext) throws AuthError {
        String a2 = a(uri);
        String outline50 = GeneratedOutlineSupport.outline50("Handling response for request ", a2);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("uri=");
        outline73.append(uri.toString());
        cp.a((String) "e", outline50, outline73.toString());
        a remove = this.f128a.remove(a2);
        boolean z = false;
        if (remove == null) {
            return false;
        }
        if (requestContext != null) {
            remove.f4a.setRequestContext(requestContext);
        }
        o oVar = (o) remove;
        if (oVar.f4a != null) {
            z = true;
        }
        q.a(context, uri, oVar.f141a, z, oVar.f3323a);
        return true;
    }
}
