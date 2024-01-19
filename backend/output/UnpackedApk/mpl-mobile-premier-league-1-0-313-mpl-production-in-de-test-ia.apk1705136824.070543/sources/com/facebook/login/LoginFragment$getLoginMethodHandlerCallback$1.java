package com.facebook.login;

import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.mpl.androidapp.login.LoginReactModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Landroidx/activity/result/ActivityResult;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginFragment.kt */
public final class LoginFragment$getLoginMethodHandlerCallback$1 extends Lambda implements Function1<ActivityResult, Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ LoginFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LoginFragment$getLoginMethodHandlerCallback$1(LoginFragment loginFragment, FragmentActivity fragmentActivity) {
        // this.this$0 = loginFragment;
        // this.$activity = fragmentActivity;
        super(1);
    }

    public Object invoke(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        Intrinsics.checkNotNullParameter(activityResult, LoginReactModule.RESULT);
        if (activityResult.mResultCode == -1) {
            this.this$0.getLoginClient().onActivityResult(RequestCodeOffset.Login.toRequestCode(), activityResult.mResultCode, activityResult.mData);
        } else {
            this.$activity.finish();
        }
        return Unit.INSTANCE;
    }
}
