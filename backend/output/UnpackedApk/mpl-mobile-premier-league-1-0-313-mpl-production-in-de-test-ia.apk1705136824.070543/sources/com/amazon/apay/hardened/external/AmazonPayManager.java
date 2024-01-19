package com.amazon.apay.hardened.external;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.widget.CompoundButtonCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.impl.WorkManagerImpl;
import b.c;
import com.amazon.apay.hardened.activity.APayBrowserActivity;
import com.amazon.apay.hardened.external.model.APayCallback;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayError.ErrorType;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.amazon.apay.hardened.worker.RecordPublishWorker;
import com.amazon.apay.hardened.worker.StorePackageVersionWorker;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import timber.log.Timber;
import timber.log.Timber.Tree;

public final class AmazonPayManager {
    public static CustomTabsIntent customTabsIntent;

    public static class a implements Listener<Void, AuthError> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ APayCallback f3242a;

        public a(APayCallback aPayCallback) {
            this.f3242a = aPayCallback;
        }

        public void onError(Object obj) {
            AuthError authError = (AuthError) obj;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SignOutError|");
            outline73.append(authError.getType());
            CompoundButtonCompat.a(outline73.toString());
            this.f3242a.onError(new APayError(ErrorType.AUTH_ERROR, "SIGN_OUT_FAILED", authError.getMessage()));
        }

        public void onSuccess(Object obj) {
            Void voidR = (Void) obj;
            CompoundButtonCompat.a("SignOutSuccess");
            this.f3242a.onSuccess();
        }
    }

    public static class b extends Tree {
        public /* synthetic */ b(a aVar) {
        }

        public void log(int i, String str, String str2, Throwable th) {
            if (i > 3 && !b.b.f2773b.contains(str) && th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                Builder builder = new Builder(RecordPublishWorker.class);
                HashMap hashMap = new HashMap();
                hashMap.put("STACK_TRACE", stringWriter.toString());
                Data data = new Data((Map<String, ?>) hashMap);
                Data.toByteArrayInternal(data);
                builder.mWorkSpec.input = data;
                CompoundButtonCompat.f958c.enqueue((OneTimeWorkRequest) builder.build());
            }
        }
    }

    public static void a(APayRequestContext aPayRequestContext, Intent intent) {
        intent.putExtra("COMPLETION_INTENT", aPayRequestContext.getCompletionIntent());
        intent.putExtra("CANCEL_INTENT", aPayRequestContext.getCancelIntent());
        aPayRequestContext.getContext().startActivity(intent);
    }

    public static void authorize(APayRequestContext aPayRequestContext, String str) {
        a(aPayRequestContext, c.AUTHORIZE);
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = String.valueOf(aPayRequestContext.getCustomTabsIntent() != null);
        if (aPayRequestContext.getCancelIntent() != null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        Timber.TREE_OF_SOULS.i("authorize called. Custom tab intent supplied: %s , cancel Intent supplied = %s", objArr);
        TweetUtils.a(aPayRequestContext.getCompletionIntent(), (String) "Completion Intent");
        TweetUtils.a(str, (String) "Code Challenge");
        Intent intent = new Intent(aPayRequestContext.getContext(), APayBrowserActivity.class);
        intent.putExtra("codeChallenge", str);
        intent.putExtra("operation", c.AUTHORIZE);
        a(aPayRequestContext, intent);
    }

    public static void charge(APayRequestContext aPayRequestContext, String str) {
        a(aPayRequestContext, c.CHARGE);
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = str;
        if (customTabsIntent != null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        Timber.TREE_OF_SOULS.i("charge called with payUrl %s. Custom tab intent supplied: %s", objArr);
        TweetUtils.a(str);
        TweetUtils.a(aPayRequestContext.getCompletionIntent(), (String) "CompletionIntent");
        Intent intent = new Intent(aPayRequestContext.getContext(), APayBrowserActivity.class);
        intent.putExtra("PAY_URL", str);
        intent.putExtra("operation", c.CHARGE);
        a(aPayRequestContext, intent);
    }

    public static Intent getAuthorizationIntent(APayRequestContext aPayRequestContext, String str) {
        a(aPayRequestContext, c.GET_AUTHORIZATION_INTENT);
        boolean z = true;
        Object[] objArr = new Object[1];
        if (customTabsIntent == null) {
            z = false;
        }
        objArr[0] = String.valueOf(z);
        Timber.TREE_OF_SOULS.i("getAuthorizationIntent called. Custom tab intent supplied: %s", objArr);
        TweetUtils.a(str, (String) "Code Challenge");
        Intent intent = new Intent(aPayRequestContext.getContext(), APayBrowserActivity.class);
        intent.putExtra("codeChallenge", str);
        intent.putExtra("operation", c.GET_AUTHORIZATION_INTENT);
        return intent;
    }

    public static Intent getChargeIntent(APayRequestContext aPayRequestContext, String str) {
        a(aPayRequestContext, c.GET_CHARGE_INTENT);
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = str;
        if (customTabsIntent != null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        Timber.TREE_OF_SOULS.i("getChargeIntent called with payUrl %s. Custom tab intent supplied: %s", objArr);
        TweetUtils.a(str);
        Intent intent = new Intent(aPayRequestContext.getContext(), APayBrowserActivity.class);
        intent.putExtra("PAY_URL", str);
        intent.putExtra("operation", c.GET_CHARGE_INTENT);
        return intent;
    }

    public static void signOut(APayRequestContext aPayRequestContext, APayCallback aPayCallback) {
        a(aPayRequestContext, c.SIGN_OUT);
        Timber.TREE_OF_SOULS.i("AmazonPayManager:signOut invoked", new Object[0]);
        TweetUtils.a(aPayCallback, (String) "APayCallback");
        AuthorizationManager.signOut(aPayRequestContext.getContext(), new a(aPayCallback));
    }

    public static void a(APayRequestContext aPayRequestContext, c cVar) {
        Timber.plant(new b(null));
        Timber.TREE_OF_SOULS.d("AmazonPayManager:init invoked: %s", cVar);
        Context context = aPayRequestContext.getContext();
        TweetUtils.a(context, (String) "Context");
        if (context instanceof Activity) {
            customTabsIntent = aPayRequestContext.getCustomTabsIntent();
            Context context2 = aPayRequestContext.getContext();
            CompoundButtonCompat.f958c = WorkManagerImpl.getInstance(context2);
            CompoundButtonCompat.f957b = new c.c(context2.getSharedPreferences("APAY_RECORDS", 0));
            CompoundButtonCompat.f958c.enqueue((OneTimeWorkRequest) new Builder(StorePackageVersionWorker.class).build());
            CompoundButtonCompat.f957b.a("events", new JSONArray().toString());
            CompoundButtonCompat.f957b.a("operation", cVar.name());
            CompoundButtonCompat.f957b.a("operationId", aPayRequestContext.getId());
            CompoundButtonCompat.f957b.a(PaymentConstants.CLIENT_ID_CAMEL, aPayRequestContext.getClientId());
            return;
        }
        throw new IllegalArgumentException("Do not pass ApplicationContext. Pass activity context instead.");
    }
}
