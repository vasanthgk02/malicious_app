package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest.GrantType;
import com.amazon.identity.auth.device.shared.APIListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class AuthorizationManager {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f3268a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final String f99a = "com.amazon.identity.auth.device.api.authorization.AuthorizationManager";

    public static void authorize(final AuthorizeRequest authorizeRequest) {
        final Context context = authorizeRequest.getContext();
        String str = f99a;
        cp.c(str, context.getPackageName() + " calling authorize");
        List<Scope> scopes = authorizeRequest.getScopes();
        int size = scopes.size();
        String[] strArr = new String[size];
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < size; i++) {
            Scope scope = scopes.get(i);
            String name = scope.getName();
            strArr[i] = name;
            if (scope.getScopeData() != null) {
                try {
                    jSONObject.put(name, scope.getScopeData());
                } catch (JSONException e2) {
                    cp.a(f99a, GeneratedOutlineSupport.outline52("Unable to serialize scope data for scope \"", name, "\""), scope.getScopeData().toString(), e2);
                }
            }
        }
        Bundle bundle = new Bundle();
        if (jSONObject.length() > 0) {
            bundle.putString(ch$b.SCOPE_DATA.f89a, jSONObject.toString());
        }
        if (authorizeRequest.getGrantType() == GrantType.AUTHORIZATION_CODE) {
            bundle.putBoolean(ch$b.GET_AUTH_CODE.f89a, true);
        }
        if (authorizeRequest.getCodeChallenge() != null) {
            bundle.putString(ch$b.CODE_CHALLENGE.f89a, authorizeRequest.getCodeChallenge());
        }
        if (authorizeRequest.getCodeChallengeMethod() != null) {
            bundle.putString(ch$b.CODE_CHALLENGE_METHOD.f89a, authorizeRequest.getCodeChallengeMethod());
        }
        bundle.putBoolean(ch$a.RETURN_ACCESS_TOKEN.f87a, true);
        t a2 = t.a(context);
        AnonymousClass2 r5 = new ae() {
            /* renamed from: a */
            public void onCancel(Bundle bundle) {
                authorizeRequest.onCancel(new AuthCancellation(bundle));
            }

            public void onError(AuthError authError) {
                authorizeRequest.onError(authError);
            }

            public void onSuccess(Bundle bundle) {
                Context context = context;
                AuthorizeRequest authorizeRequest = authorizeRequest;
                AuthorizeListener.a(context, bundle, authorizeRequest, authorizeRequest.shouldReturnUserData());
            }
        };
        if (a2 == null) {
            throw null;
        } else if (size != 0) {
            cp.c("t", context.getPackageName() + " calling authorize: scopes=" + Arrays.toString(strArr));
            Executor executor = ca.f81a;
            defpackage.t.AnonymousClass1 r0 = new Runnable(context, r5, bundle, authorizeRequest, strArr) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ae f3334a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ Context f150a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ Bundle f151a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ AuthorizeRequest f152a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ String[] f154a;

                {
                    this.f150a = r2;
                    this.f3334a = r3;
                    this.f151a = r4;
                    this.f152a = r5;
                    this.f154a = r6;
                }

                public void run() {
                    if (!t.this.a(this.f150a)) {
                        this.f3334a.onError(new AuthError("APIKey is invalid", ERROR_TYPE.ERROR_ACCESS_DENIED));
                        return;
                    }
                    Bundle bundle = this.f151a == null ? new Bundle() : new Bundle(this.f151a);
                    if (!bundle.containsKey(ch$b.SANDBOX.f89a)) {
                        bundle.putBoolean(ch$b.SANDBOX.f89a, AuthorizationManager.isSandboxMode(this.f150a));
                    }
                    try {
                        new aa().a(this.f152a, this.f150a, this.f150a.getPackageName(), t.this.f3333b, t.this.a(this.f150a), this.f154a, true, t.f3332a, this.f3334a, bundle);
                    } catch (AuthError e2) {
                        this.f3334a.onError(e2);
                    }
                }
            };
            executor.execute(r0);
        } else {
            throw new IllegalArgumentException("scopes must not be null or empty!");
        }
    }

    public static Region getRegion(Context context) {
        t a2 = t.a(context);
        if (a2 != null) {
            Region a3 = TweetUtils.a(context);
            return Region.AUTO == a3 ? new s(context, a2.f149a).a() : a3;
        }
        throw null;
    }

    public static void getToken(Context context, Scope[] scopeArr, final Listener<AuthorizeResult, AuthError> listener) {
        String str = f99a;
        cp.c(str, context.getPackageName() + " calling getToken");
        int length = scopeArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].getName();
        }
        t a2 = t.a(context);
        AnonymousClass3 r2 = new APIListener() {
            public void onError(AuthError authError) {
                listener.onError(authError);
            }

            public void onSuccess(Bundle bundle) {
                listener.onSuccess(new AuthorizeResult(bundle));
            }
        };
        if (a2 == null) {
            throw null;
        } else if (length != 0) {
            cp.c("t", context.getPackageName() + " calling getToken: scopes=" + Arrays.toString(strArr));
            ca.f81a.execute(new Runnable(context, new bx(r2), strArr) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3335a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ bx f155a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ String[] f157a;

                {
                    this.f3335a = r2;
                    this.f155a = r3;
                    this.f157a = r4;
                }

                public void run() {
                    try {
                        if (!t.this.a(this.f3335a)) {
                            bx bxVar = this.f155a;
                            AuthError authError = new AuthError("APIKey is invalid", ERROR_TYPE.ERROR_ACCESS_DENIED);
                            bxVar.f78a = authError;
                            bxVar.f79a.countDown();
                            bxVar.f76a.onError(authError);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(ch$b.SANDBOX.f89a, AuthorizationManager.isSandboxMode(this.f3335a));
                        ad.a(this.f3335a, this.f3335a.getPackageName(), t.this.f3333b, this.f157a, new APIListener() {
                            public void onError(AuthError authError) {
                                bx bxVar = AnonymousClass2.this.f155a;
                                bxVar.f78a = authError;
                                bxVar.f79a.countDown();
                                bxVar.f76a.onError(authError);
                            }

                            public void onSuccess(Bundle bundle) {
                                AnonymousClass2.this.f155a.onSuccess(bundle);
                            }
                        }, new j(), bundle);
                    } catch (AuthError e2) {
                        bx bxVar2 = this.f155a;
                        bxVar2.f78a = e2;
                        bxVar2.f79a.countDown();
                        bxVar2.f76a.onError(e2);
                    }
                }
            });
        } else {
            throw new IllegalArgumentException("scopes must not be null or empty!");
        }
    }

    public static boolean isSandboxMode(Context context) {
        if (f3268a == null) {
            f3268a = Boolean.valueOf(context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getBoolean("com.amazon.lwa.sandboxMode", false));
        }
        return f3268a.booleanValue();
    }

    public static void setRegion(Context context, Region region) {
        if (t.a(context) == null) {
            throw null;
        } else if (cd.a() != region) {
            context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putString("com.amazon.lwa.regionMode", region.toString()).commit();
            synchronized (cd.class) {
                cd.f2813a = region;
                cp.c("cd", "App Region overwritten : " + cd.f2813a.toString());
            }
        }
    }

    public static void setSandboxMode(Context context, boolean z) {
        boolean isSandboxMode = isSandboxMode(context);
        String str = f99a;
        cp.c(str, "Changing sandbox mode from " + isSandboxMode + " to " + z);
        if (isSandboxMode != z) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            signOut(context, new Listener<Void, AuthError>() {
                /* renamed from: a */
                public void onError(AuthError authError) {
                    countDownLatch.countDown();
                }

                /* renamed from: a */
                public void onSuccess(Void voidR) {
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                TweetUtils.b(context, z);
                throw th;
            }
            TweetUtils.b(context, z);
        }
        f3268a = Boolean.valueOf(z);
    }

    public static void signOut(Context context, final Listener<Void, AuthError> listener) {
        String str = f99a;
        cp.c(str, context.getPackageName() + " calling signOut");
        t a2 = t.a(context);
        AnonymousClass4 r1 = new APIListener() {
            public void onError(AuthError authError) {
                listener.onError(authError);
            }

            public void onSuccess(Bundle bundle) {
                listener.onSuccess(null);
            }
        };
        if (a2 != null) {
            bx bxVar = new bx(r1);
            cp.c("t", context.getPackageName() + " calling clearAuthorizationState");
            ca.f81a.execute(new Runnable(context, bxVar) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3339a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ bx f161a;

                {
                    this.f3339a = r2;
                    this.f161a = r3;
                }

                public void run() {
                    if (!t.this.a(this.f3339a)) {
                        bx bxVar = this.f161a;
                        AuthError authError = new AuthError("APIKey is invalid", ERROR_TYPE.ERROR_ACCESS_DENIED);
                        bxVar.f78a = authError;
                        bxVar.f79a.countDown();
                        bxVar.f76a.onError(authError);
                        return;
                    }
                    t tVar = t.this;
                    Context context = this.f3339a;
                    AuthError e2 = null;
                    if (tVar != null) {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(ch$b.SANDBOX.f89a, AuthorizationManager.isSandboxMode(context));
                            ad.a(context, tVar.f149a, bundle);
                            e = null;
                        } catch (AuthError e3) {
                            e = e3;
                        }
                        t tVar2 = t.this;
                        Context context2 = this.f3339a;
                        if (tVar2 != null) {
                            try {
                                ao.b(context2);
                            } catch (AuthError e4) {
                                e2 = e4;
                            }
                            ao.a(this.f3339a);
                            if (e == null && e2 == null) {
                                this.f161a.onSuccess(new Bundle());
                            } else if (e != null) {
                                bx bxVar2 = this.f161a;
                                bxVar2.f78a = e;
                                bxVar2.f79a.countDown();
                                bxVar2.f76a.onError(e);
                            } else if (e2 != null) {
                                bx bxVar3 = this.f161a;
                                bxVar3.f78a = e2;
                                bxVar3.f79a.countDown();
                                bxVar3.f76a.onError(e2);
                            }
                            return;
                        }
                        throw null;
                    }
                    throw null;
                }
            });
            return;
        }
        throw null;
    }
}
