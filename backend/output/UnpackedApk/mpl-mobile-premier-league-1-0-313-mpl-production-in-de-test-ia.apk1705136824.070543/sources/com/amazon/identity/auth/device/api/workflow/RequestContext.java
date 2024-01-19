package com.amazon.identity.auth.device.api.workflow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.interactive.InteractiveAPI;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class RequestContext {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3292a = "com.amazon.identity.auth.device.api.workflow.RequestContext";

    /* renamed from: a  reason: collision with other field name */
    public final Intent f113a;

    /* renamed from: a  reason: collision with other field name */
    public final CustomTabsIntent f114a;

    /* renamed from: a  reason: collision with other field name */
    public final bp f115a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Set<InteractiveListener<?, ?, ?>>> f116a;

    /* renamed from: a  reason: collision with other field name */
    public final UUID f117a;

    public RequestContext(bp bpVar, Intent intent, CustomTabsIntent customTabsIntent) {
        if (bpVar != null) {
            this.f115a = bpVar;
            this.f113a = intent;
            this.f114a = customTabsIntent;
            this.f117a = UUID.randomUUID();
            this.f116a = new HashMap();
            return;
        }
        throw new IllegalArgumentException("requestSource must be non-null");
    }

    public static RequestContext a(bp bpVar, Intent intent, CustomTabsIntent customTabsIntent) {
        String str;
        String str2;
        StringBuilder sb;
        Object a2 = bpVar.a();
        RequestContext requestContext = bl.a().f75a.get(a2);
        if (requestContext == null) {
            requestContext = new RequestContext(bpVar, intent, customTabsIntent);
            bl.a().f75a.put(a2, requestContext);
            str2 = f3292a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Created RequestContext ");
            outline73.append(requestContext.f117a);
            str = outline73.toString();
            sb = new StringBuilder();
        } else {
            str2 = f3292a;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Reusing RequestContext ");
            outline732.append(requestContext.f117a);
            str = outline732.toString();
            sb = new StringBuilder();
        }
        sb.append("requestSource=");
        sb.append(bpVar.a());
        cp.a(str2, str, sb.toString());
        return requestContext;
    }

    /* access modifiers changed from: private */
    public <T> Set<T> a(String str, Class<T> cls) throws i {
        Set<InteractiveListener> set;
        if (str != null) {
            synchronized (this.f116a) {
                set = this.f116a.get(str);
            }
            if (set == null || set.isEmpty()) {
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("No listeners were registered with type \"", str, "\" for RequestContext ");
                outline80.append(this.f117a);
                outline80.append(". Listener types present: ");
                outline80.append(this.f116a.keySet());
                throw new i(outline80.toString());
            } else if (cls == null) {
                return null;
            } else {
                HashSet hashSet = new HashSet(set.size());
                for (InteractiveListener cast : set) {
                    try {
                        hashSet.add(cls.cast(cast));
                    } catch (ClassCastException e2) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to retrieve listener of class type \"");
                        outline73.append(cls.toString());
                        outline73.append("\" for request type \"");
                        outline73.append(str);
                        outline73.append("\"");
                        throw new i(outline73.toString(), e2);
                    }
                }
                return hashSet;
            }
        } else {
            throw new IllegalArgumentException("requestType must be non-null");
        }
    }

    public static RequestContext create(Activity activity) {
        return a((bp) new bq(activity), (Intent) null, (CustomTabsIntent) null);
    }

    public static RequestContext create(Activity activity, Intent intent, CustomTabsIntent customTabsIntent) {
        return a((bp) new bq(activity), intent, customTabsIntent);
    }

    @SuppressLint({"NewApi"})
    public static RequestContext create(Fragment fragment) {
        return a((bp) new bs(fragment), (Intent) null, (CustomTabsIntent) null);
    }

    @SuppressLint({"NewApi"})
    public static RequestContext create(Fragment fragment, Intent intent, CustomTabsIntent customTabsIntent) {
        return a((bp) new bs(fragment), intent, customTabsIntent);
    }

    public static RequestContext create(androidx.fragment.app.Fragment fragment) {
        return a((bp) new bt(fragment), (Intent) null, (CustomTabsIntent) null);
    }

    public static RequestContext create(androidx.fragment.app.Fragment fragment, Intent intent, CustomTabsIntent customTabsIntent) {
        return a((bp) new bt(fragment), intent, customTabsIntent);
    }

    public static RequestContext create(FragmentActivity fragmentActivity) {
        return a((bp) new br(fragmentActivity), (Intent) null, (CustomTabsIntent) null);
    }

    public static RequestContext create(FragmentActivity fragmentActivity, Intent intent, CustomTabsIntent customTabsIntent) {
        return a((bp) new br(fragmentActivity), intent, customTabsIntent);
    }

    public void assertListenerPresent(InteractiveAPI interactiveAPI) throws i {
        if (interactiveAPI != null) {
            a(interactiveAPI.getRequestType(), null);
            return;
        }
        throw new IllegalArgumentException("api must be non-null");
    }

    public <T extends InteractiveListener<S, U, V>, S, U, V> InteractiveListener<S, U, V> getAggregateListener(InteractiveRequest<T, S, U, V> interactiveRequest) throws i {
        return new bj(interactiveRequest.getRequestType(), getListeners(interactiveRequest, interactiveRequest.getListenerClass()));
    }

    public Context getContext() {
        return this.f115a.a();
    }

    public CustomTabsIntent getCustomTabsIntent() {
        return this.f114a;
    }

    public Intent getInvokingIntent() {
        return this.f113a;
    }

    public <T> Set<T> getListeners(InteractiveAPI interactiveAPI, Class<T> cls) {
        if (interactiveAPI == null) {
            throw new IllegalArgumentException("api must be non-null");
        } else if (cls != null) {
            return a(interactiveAPI.getRequestType(), cls);
        } else {
            throw new IllegalArgumentException("listenerClass must be non-null");
        }
    }

    public void onResume() {
        String str = f3292a;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
        outline73.append(this.f117a);
        outline73.append(": onResume");
        cp.a(str, outline73.toString());
        bm a2 = this.f115a.a();
        if (a2 != null) {
            a2.a(this);
            return;
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("RequestContext ");
        outline732.append(this.f117a);
        outline732.append(": could not retrieve interactive state to process pending responses");
        outline732.toString();
    }

    public void onStartRequest(InteractiveRequestRecord interactiveRequestRecord) {
        if (interactiveRequestRecord != null) {
            String str = f3292a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
            outline73.append(this.f117a);
            outline73.append(": onStartRequest for request ID ");
            outline73.append(interactiveRequestRecord.getRequestId());
            cp.a(str, outline73.toString());
            this.f115a.a(interactiveRequestRecord);
            return;
        }
        throw new IllegalArgumentException("request must be non-null");
    }

    public void processResponse(final InteractiveRequestRecord interactiveRequestRecord, final Uri uri) {
        if (interactiveRequestRecord == null) {
            throw new IllegalArgumentException("request must be non-null");
        } else if (uri != null) {
            String str = f3292a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
            outline73.append(this.f117a);
            outline73.append(": processing response");
            String sb = outline73.toString();
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("uri=");
            outline732.append(uri.toString());
            cp.a(str, sb, outline732.toString());
            final Context a2 = this.f115a.a();
            ca.f81a.execute(new Runnable() {
                public void run() {
                    try {
                        if (!e.a(a2).a(uri, a2, RequestContext.this)) {
                            Uri uri = uri;
                            String queryParameter = uri.getQueryParameter("state");
                            if (queryParameter != null) {
                                HashMap hashMap = new HashMap();
                                for (String split : TextUtils.split(queryParameter, "&")) {
                                    String[] split2 = TextUtils.split(split, InflateView.SETTER_EQUALS);
                                    if (split2 != null && split2.length == 2) {
                                        hashMap.put(split2[0], split2[1]);
                                    }
                                }
                                for (bo onRequestCompletion : RequestContext.this.a((String) hashMap.get("InteractiveRequestType"), bo.class)) {
                                    onRequestCompletion.onRequestCompletion(a2, interactiveRequestRecord, uri);
                                }
                                return;
                            }
                            throw new AuthError(String.format("Response does not have a state parameter: %s", new Object[]{uri.toString()}), ERROR_TYPE.ERROR_SERVER_REPSONSE);
                        }
                    } catch (Exception e2) {
                        String a2 = RequestContext.f3292a;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
                        outline73.append(RequestContext.this.f117a);
                        outline73.append(": Unable to handle activity result");
                        cp.a(a2, outline73.toString(), (Throwable) e2);
                    }
                }
            });
        } else {
            throw new IllegalArgumentException("uri must be non-null");
        }
    }

    public void registerListener(InteractiveListener<?, ?, ?> interactiveListener) {
        if (interactiveListener != null) {
            String requestType = interactiveListener.getRequestType();
            String str = f3292a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
            outline73.append(this.f117a);
            outline73.append(": registerListener for of request type ");
            outline73.append(requestType);
            String sb = outline73.toString();
            cp.a(str, sb, "listener=" + interactiveListener);
            synchronized (this.f116a) {
                Set set = this.f116a.get(requestType);
                if (set == null) {
                    set = new HashSet();
                    this.f116a.put(requestType, set);
                }
                set.add(interactiveListener);
            }
            return;
        }
        throw new IllegalArgumentException("listener must be non-null");
    }

    public boolean unregisterListener(InteractiveListener<?, ?, ?> interactiveListener) {
        if (interactiveListener != null) {
            String requestType = interactiveListener.getRequestType();
            String str = f3292a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestContext ");
            outline73.append(this.f117a);
            outline73.append(": unregisterListener for listener of request type ");
            outline73.append(requestType);
            String sb = outline73.toString();
            cp.a(str, sb, "listener=" + interactiveListener);
            synchronized (this.f116a) {
                Set set = this.f116a.get(requestType);
                if (set == null) {
                    return false;
                }
                boolean remove = set.remove(interactiveListener);
                return remove;
            }
        }
        throw new IllegalArgumentException("listener must be non-null");
    }
}
