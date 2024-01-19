package com.crimzoncode.tqcontests;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.crimzoncode.tqcontests.util.CountdownTimerListener;
import com.crimzoncode.tqcontests.util.TQConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u0004\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J)\u0010\u0011\u001a\u00020\u0004\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u0001H\n2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0013J;\u0010\u0014\u001a\u00020\u0004\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u0001H\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u001f\u001a\u00020\u0017¨\u0006 "}, d2 = {"Lcom/crimzoncode/tqcontests/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "hideLoaderIcon", "", "hideSystemUI", "onWindowFocusChanged", "hasFocus", "", "removeFragment", "T", "Landroidx/fragment/app/Fragment;", "fragmentTag", "", "rotateView", "view", "Landroid/view/View;", "setDialogFragment", "dialog", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "setFragment", "fragment", "objectId", "", "showAnim", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;IZ)V", "showCountDown", "listener", "Lcom/crimzoncode/tqcontests/util/CountdownTimerListener;", "showLoaderIcon", "requestMessage", "rootLayoutId", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity extends AppCompatActivity {
    public HashMap _$_findViewCache;

    private final void rotateView(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(700);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        view.startAnimation(rotateAnimation);
    }

    public static /* synthetic */ void setFragment$default(BaseActivity baseActivity, Fragment fragment, String str, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                z = true;
            }
            baseActivity.setFragment(fragment, str, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFragment");
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void hideLoaderIcon() {
        getWindow().clearFlags(16);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.request_progressbar_layout);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void hideSystemUI() {
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "decorView");
        decorView.setSystemUiVisibility(5638);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        hideSystemUI();
    }

    public final <T extends Fragment> void removeFragment(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "fm.beginTransaction()");
        if (str != null) {
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public final <T extends Fragment> void setDialogFragment(T t, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "fm.beginTransaction()");
        if (t != null) {
            beginTransaction.add((Fragment) t, str);
        }
        if (!isFinishing()) {
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final <T extends Fragment> void setFragment(T t, String str, int i, boolean z) {
        if (findViewById(i) instanceof FrameLayout) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                ((FrameLayout) findViewById).removeAllViews();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "fm.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(17432578, 17432579);
        }
        if (t != null) {
            beginTransaction.replace(i, (Fragment) t, str);
        }
        if (!isFinishing()) {
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final void showCountDown(CountdownTimerListener countdownTimerListener) {
        Intrinsics.checkParameterIsNotNull(countdownTimerListener, "listener");
        getWindow().setFlags(16, 16);
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(R.id.layout_root);
        View inflate = getLayoutInflater().inflate(R.layout.widget_countdown, viewGroup, false);
        if (viewGroup.indexOfChild(inflate) == -1) {
            viewGroup.addView(inflate);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.countdown_layout);
        int color = ResourcesCompat.getColor(getResources(), R.color.material_red, null);
        int color2 = ResourcesCompat.getColor(getResources(), R.color.material_yellow, null);
        int color3 = ResourcesCompat.getColor(getResources(), R.color.material_green, null);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(color2), Integer.valueOf(color3)});
        Intrinsics.checkExpressionValueIsNotNull(ofObject, "colorAnimation");
        ofObject.setDuration(TQConstants.COUNTDOWN_DURATION);
        ofObject.addUpdateListener(new BaseActivity$showCountDown$1(viewGroup2));
        BaseActivity$showCountDown$countDownTimer$1 baseActivity$showCountDown$countDownTimer$1 = new BaseActivity$showCountDown$countDownTimer$1(this, (TextView) inflate.findViewById(R.id.countdown_text), AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom), viewGroup, viewGroup2, countdownTimerListener, 3700, 1000);
        baseActivity$showCountDown$countDownTimer$1.start();
        ofObject.start();
    }

    public final void showLoaderIcon(String str, int i) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(i);
        View inflate = getLayoutInflater().inflate(R.layout.widget_progressbar, viewGroup, false);
        if (viewGroup.indexOfChild(inflate) == -1) {
            viewGroup.addView(inflate);
        }
        ImageView imageView = (ImageView) findViewById(R.id.request_progressbar);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "progressBarImageView");
        rotateView(imageView);
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) findViewById(R.id.request_text);
            Intrinsics.checkExpressionValueIsNotNull(textView, "requestMessageTextView");
            textView.setText(str);
            textView.setVisibility(0);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.request_progressbar_layout);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }
}
