package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessToken.Companion;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.login.LoginTargetApp;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\b\u000bJ\u001c\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/FacebookDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "innerDialog", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "setInnerDialog", "(Landroid/app/Dialog;)V", "initDialog", "", "initDialog$facebook_common_release", "onCompleteWebDialog", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "onCompleteWebFallbackDialog", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateDialog", "onDestroyView", "onResume", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookDialogFragment.kt */
public final class FacebookDialogFragment extends DialogFragment {
    public Dialog innerDialog;

    /* renamed from: initDialog$lambda-0  reason: not valid java name */
    public static final void m191initDialog$lambda0(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookDialogFragment, "this$0");
        facebookDialogFragment.onCompleteWebDialog(bundle, facebookException);
    }

    /* renamed from: initDialog$lambda-1  reason: not valid java name */
    public static final void m192initDialog$lambda1(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookDialogFragment, "this$0");
        FragmentActivity activity = facebookDialogFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "fragmentActivity.intent");
            activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException));
            activity.finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog != null) {
                ((WebDialog) dialog).resize();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        WebDialog webDialog;
        String str;
        String str2;
        Bundle bundle2;
        super.onCreate(bundle);
        if (this.innerDialog == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Intent intent = activity.getIntent();
                NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(intent, AnalyticsConstants.INTENT);
                Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
                if (methodArgumentsFromIntent == null) {
                    z = false;
                } else {
                    z = methodArgumentsFromIntent.getBoolean("is_fallback", false);
                }
                String str3 = null;
                if (!z) {
                    if (methodArgumentsFromIntent == null) {
                        str2 = null;
                    } else {
                        str2 = methodArgumentsFromIntent.getString("action");
                    }
                    if (methodArgumentsFromIntent == null) {
                        bundle2 = null;
                    } else {
                        bundle2 = methodArgumentsFromIntent.getBundle(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
                    }
                    if (Utility.isNullOrEmpty(str2)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        boolean z2 = FacebookSdk.isDebugEnabledField;
                        activity.finish();
                        return;
                    } else if (str2 != null) {
                        Intrinsics.checkNotNullParameter(activity, "context");
                        Intrinsics.checkNotNullParameter(str2, "action");
                        Companion companion = AccessToken.Companion;
                        AccessToken currentAccessToken = Companion.getCurrentAccessToken();
                        Companion companion2 = AccessToken.Companion;
                        if (!Companion.isCurrentAccessTokenActive()) {
                            str3 = Utility.getMetadataApplicationId(activity);
                        }
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        Bundle bundle3 = bundle2;
                        $$Lambda$3BbV3rJ4THTu8bLGxrqhyLdAgU r6 = new OnCompleteListener() {
                            public final void onComplete(Bundle bundle, FacebookException facebookException) {
                                FacebookDialogFragment.m191initDialog$lambda0(FacebookDialogFragment.this, bundle, facebookException);
                            }
                        };
                        if (currentAccessToken != null) {
                            bundle3.putString("app_id", currentAccessToken.applicationId);
                            bundle3.putString("access_token", currentAccessToken.token);
                        } else {
                            bundle3.putString("app_id", str3);
                        }
                        WebDialog.Companion companion3 = WebDialog.Companion;
                        Intrinsics.checkNotNullParameter(activity, "context");
                        WebDialog.initDefaultTheme(activity);
                        webDialog = new WebDialog(activity, str2, bundle3, 0, LoginTargetApp.FACEBOOK, r6, null);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    if (methodArgumentsFromIntent == null) {
                        str = null;
                    } else {
                        str = methodArgumentsFromIntent.getString("url");
                    }
                    if (Utility.isNullOrEmpty(str)) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        boolean z3 = FacebookSdk.isDebugEnabledField;
                        activity.finish();
                        return;
                    }
                    FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                    String outline70 = GeneratedOutlineSupport.outline70(new Object[]{FacebookSdk.getApplicationId()}, 1, "fb%s://bridge/", "java.lang.String.format(format, *args)");
                    FacebookWebFallbackDialog facebookWebFallbackDialog = FacebookWebFallbackDialog.Companion;
                    if (str != null) {
                        Intrinsics.checkNotNullParameter(activity, "context");
                        Intrinsics.checkNotNullParameter(str, "url");
                        Intrinsics.checkNotNullParameter(outline70, "expectedRedirectUrl");
                        WebDialog.Companion companion4 = WebDialog.Companion;
                        WebDialog.initDefaultTheme(activity);
                        webDialog = new FacebookWebFallbackDialog(activity, str, outline70, null);
                        webDialog.onCompleteListener = new OnCompleteListener() {
                            public final void onComplete(Bundle bundle, FacebookException facebookException) {
                                FacebookDialogFragment.m192initDialog$lambda1(FacebookDialogFragment.this, bundle, facebookException);
                            }
                        };
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                this.innerDialog = webDialog;
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.innerDialog;
        if (dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            return onCreateDialog;
        } else if (dialog != null) {
            return dialog;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (!(dialog instanceof WebDialog)) {
            return;
        }
        if (dialog != null) {
            ((WebDialog) dialog).resize();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
    }
}
