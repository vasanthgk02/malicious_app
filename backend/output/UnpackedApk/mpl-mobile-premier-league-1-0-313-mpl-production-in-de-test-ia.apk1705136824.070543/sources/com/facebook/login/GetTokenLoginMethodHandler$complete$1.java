package com.facebook.login;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/facebook/login/GetTokenLoginMethodHandler$complete$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GetTokenLoginMethodHandler.kt */
public final class GetTokenLoginMethodHandler$complete$1 implements GraphMeRequestWithCacheCallback {
    public final /* synthetic */ Request $request;
    public final /* synthetic */ Bundle $result;
    public final /* synthetic */ GetTokenLoginMethodHandler this$0;

    public GetTokenLoginMethodHandler$complete$1(Bundle bundle, GetTokenLoginMethodHandler getTokenLoginMethodHandler, Request request) {
        this.$result = bundle;
        this.this$0 = getTokenLoginMethodHandler;
        this.$request = request;
    }

    public void onFailure(FacebookException facebookException) {
        String str;
        LoginClient loginClient = this.this$0.getLoginClient();
        Request request = this.this$0.getLoginClient().pendingRequest;
        if (facebookException == null) {
            str = null;
        } else {
            str = facebookException.getMessage();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("Caught exception");
        if (str != null) {
            arrayList.add(str);
        }
        Result result = new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
        loginClient.complete(result);
    }

    public void onSuccess(JSONObject jSONObject) {
        try {
            this.$result.putString("com.facebook.platform.extra.USER_ID", jSONObject == null ? null : jSONObject.getString("id"));
            this.this$0.onComplete(this.$request, this.$result);
        } catch (JSONException e2) {
            LoginClient loginClient = this.this$0.getLoginClient();
            Request request = this.this$0.getLoginClient().pendingRequest;
            String message = e2.getMessage();
            ArrayList arrayList = new ArrayList();
            arrayList.add("Caught exception");
            if (message != null) {
                arrayList.add(message);
            }
            Result result = new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
            loginClient.complete(result);
        }
    }
}
