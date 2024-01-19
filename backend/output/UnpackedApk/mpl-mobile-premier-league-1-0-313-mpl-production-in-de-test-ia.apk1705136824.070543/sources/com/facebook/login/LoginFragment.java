package com.facebook.login;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessToken.Companion;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.common.R$id;
import com.facebook.common.R$layout;
import com.facebook.login.LoginClient.OnCompletedListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020\u001bH\u0014J\b\u00106\u001a\u00020\u001bH\u0014J\b\u00107\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8UX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "callingPackage", "", "<set-?>", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "layoutResId", "", "getLayoutResId", "()I", "Lcom/facebook/login/LoginClient;", "loginClient", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "progressBar", "Landroid/view/View;", "request", "Lcom/facebook/login/LoginClient$Request;", "createLoginClient", "getLoginMethodHandlerCallback", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "hideSpinner", "initializeCallingPackage", "Landroid/app/Activity;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onLoginClientCompleted", "outcome", "Lcom/facebook/login/LoginClient$Result;", "onPause", "onResume", "onSaveInstanceState", "outState", "onSpinnerHidden", "onSpinnerShown", "showSpinner", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginFragment.kt */
public class LoginFragment extends Fragment {
    public String callingPackage;
    public ActivityResultLauncher<Intent> launcher;
    public LoginClient loginClient;
    public View progressBar;
    public Request request;

    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m69onCreate$lambda0(LoginFragment loginFragment, Result result) {
        Intrinsics.checkNotNullParameter(loginFragment, "this$0");
        Intrinsics.checkNotNullParameter(result, "outcome");
        loginFragment.request = null;
        int i = result.code == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        FragmentActivity activity = loginFragment.getActivity();
        if (loginFragment.isAdded() && activity != null) {
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m70onCreate$lambda1(Function1 function1, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(activityResult);
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getLoginClient().onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        LoginClient loginClient2;
        super.onCreate(bundle);
        if (bundle == null) {
            loginClient2 = null;
        } else {
            loginClient2 = (LoginClient) bundle.getParcelable("loginClient");
        }
        if (loginClient2 == null) {
            loginClient2 = new LoginClient((Fragment) this);
        } else if (loginClient2.fragment == null) {
            loginClient2.fragment = this;
        } else {
            throw new FacebookException((String) "Can't set fragment once it is already set.");
        }
        this.loginClient = loginClient2;
        getLoginClient().onCompletedListener = new OnCompletedListener() {
            public final void onCompleted(Result result) {
                LoginFragment.m69onCreate$lambda0(LoginFragment.this, result);
            }
        };
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                this.callingPackage = callingActivity.getPackageName();
            }
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request");
                if (bundleExtra != null) {
                    this.request = (Request) bundleExtra.getParcelable("request");
                }
            }
            ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() {
                public final void onActivityResult(Object obj) {
                    LoginFragment.m70onCreate$lambda1(Function1.this, (ActivityResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
            this.launcher = registerForActivityResult;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.com_facebook_login_fragment, viewGroup, false);
        View findViewById = inflate.findViewById(R$id.com_facebook_login_fragment_progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = findViewById;
        getLoginClient().backgroundProcessingListener = new LoginFragment$onCreateView$1(this);
        return inflate;
    }

    public void onDestroy() {
        LoginMethodHandler currentHandler = getLoginClient().getCurrentHandler();
        if (currentHandler != null) {
            currentHandler.cancel();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(R$id.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return;
        }
        LoginClient loginClient2 = getLoginClient();
        Request request2 = this.request;
        if (!(loginClient2.pendingRequest != null && loginClient2.currentHandler >= 0) && request2 != null) {
            if (loginClient2.pendingRequest == null) {
                Companion companion = AccessToken.Companion;
                if (!Companion.isCurrentAccessTokenActive() || loginClient2.checkInternetPermission()) {
                    loginClient2.pendingRequest = request2;
                    Intrinsics.checkNotNullParameter(request2, "request");
                    ArrayList arrayList = new ArrayList();
                    LoginBehavior loginBehavior = request2.loginBehavior;
                    if (!request2.isInstagramLogin()) {
                        if (loginBehavior.allowsGetTokenAuth()) {
                            arrayList.add(new GetTokenLoginMethodHandler(loginClient2));
                        }
                        if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsKatanaAuth()) {
                            arrayList.add(new KatanaProxyLoginMethodHandler(loginClient2));
                        }
                    } else if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsInstagramAppAuth()) {
                        arrayList.add(new InstagramAppLoginMethodHandler(loginClient2));
                    }
                    if (loginBehavior.allowsCustomTabAuth()) {
                        arrayList.add(new CustomTabLoginMethodHandler(loginClient2));
                    }
                    if (loginBehavior.allowsWebViewAuth()) {
                        arrayList.add(new WebViewLoginMethodHandler(loginClient2));
                    }
                    if (!request2.isInstagramLogin() && loginBehavior.allowsDeviceAuth()) {
                        arrayList.add(new DeviceAuthMethodHandler(loginClient2));
                    }
                    Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
                    if (array != null) {
                        loginClient2.handlersToTry = (LoginMethodHandler[]) array;
                        loginClient2.tryNextHandler();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else {
                throw new FacebookException((String) "Attempted to authorize while a request is pending.");
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", getLoginClient());
    }
}
