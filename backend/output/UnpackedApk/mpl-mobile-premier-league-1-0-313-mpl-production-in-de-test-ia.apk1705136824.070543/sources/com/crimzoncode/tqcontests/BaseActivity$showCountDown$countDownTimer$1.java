package com.crimzoncode.tqcontests;

import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import com.crimzoncode.tqcontests.util.CountdownTimerListener;
import com.mpl.androidapp.miniprofile.ct.C.ReminderSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/crimzoncode/tqcontests/BaseActivity$showCountDown$countDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseActivity.kt */
public final class BaseActivity$showCountDown$countDownTimer$1 extends CountDownTimer {
    public final /* synthetic */ ViewGroup $countdownLayout;
    public final /* synthetic */ TextView $countdownText;
    public final /* synthetic */ CountdownTimerListener $listener;
    public final /* synthetic */ ViewGroup $parentViewGroup;
    public final /* synthetic */ Animation $slideInAnim;
    public final /* synthetic */ BaseActivity this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BaseActivity$showCountDown$countDownTimer$1(BaseActivity baseActivity, TextView textView, Animation animation, ViewGroup viewGroup, ViewGroup viewGroup2, CountdownTimerListener countdownTimerListener, long j, long j2) {
        // this.this$0 = baseActivity;
        // this.$countdownText = textView;
        // this.$slideInAnim = animation;
        // this.$parentViewGroup = viewGroup;
        // this.$countdownLayout = viewGroup2;
        // this.$listener = countdownTimerListener;
        super(j, j2);
    }

    public void onFinish() {
        this.this$0.getWindow().clearFlags(16);
        this.$parentViewGroup.removeView(this.$countdownLayout);
        this.$listener.onCountdownFinish();
    }

    public void onTick(long j) {
        int i = (int) (j / ((long) 1000));
        if (i != 0) {
            this.$countdownText.startAnimation(this.$slideInAnim);
            String str = i != 1 ? i != 2 ? i != 3 ? "" : "Get" : ReminderSet.STATE_SET : "Go";
            TextView textView = this.$countdownText;
            Intrinsics.checkExpressionValueIsNotNull(textView, "countdownText");
            textView.setText(str);
        }
    }
}
