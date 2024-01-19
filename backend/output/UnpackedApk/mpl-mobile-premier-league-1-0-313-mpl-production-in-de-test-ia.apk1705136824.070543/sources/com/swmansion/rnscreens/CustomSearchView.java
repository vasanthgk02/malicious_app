package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnCloseListener;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/swmansion/rnscreens/CustomSearchView;", "Landroidx/appcompat/widget/SearchView;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "backPressOverrider", "Lcom/swmansion/rnscreens/FragmentBackPressOverrider;", "mCustomOnCloseListener", "Landroidx/appcompat/widget/SearchView$OnCloseListener;", "mCustomOnSearchClickedListener", "Landroid/view/View$OnClickListener;", "mOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "value", "", "overrideBackAction", "getOverrideBackAction", "()Z", "setOverrideBackAction", "(Z)V", "focus", "", "onAttachedToWindow", "onDetachedFromWindow", "setOnCloseListener", "listener", "setOnSearchClickListener", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomSearchView.kt */
public final class CustomSearchView extends SearchView {
    public final FragmentBackPressOverrider backPressOverrider;
    public OnCloseListener mCustomOnCloseListener;
    public OnClickListener mCustomOnSearchClickedListener;
    public OnBackPressedCallback mOnBackPressedCallback;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomSearchView(Context context, Fragment fragment) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(fragment, "fragment");
        super(context);
        CustomSearchView$mOnBackPressedCallback$1 customSearchView$mOnBackPressedCallback$1 = new CustomSearchView$mOnBackPressedCallback$1(this);
        this.mOnBackPressedCallback = customSearchView$mOnBackPressedCallback$1;
        this.backPressOverrider = new FragmentBackPressOverrider(fragment, customSearchView$mOnBackPressedCallback$1);
        super.setOnSearchClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CustomSearchView.m98_init_$lambda0(CustomSearchView.this, view);
            }
        });
        super.setOnCloseListener(new OnCloseListener() {
            public final boolean onClose() {
                return CustomSearchView.m99_init_$lambda1(CustomSearchView.this);
            }
        });
        setMaxWidth(Integer.MAX_VALUE);
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m98_init_$lambda0(CustomSearchView customSearchView, View view) {
        Intrinsics.checkNotNullParameter(customSearchView, "this$0");
        OnClickListener onClickListener = customSearchView.mCustomOnSearchClickedListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        customSearchView.backPressOverrider.maybeAddBackCallback();
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final boolean m99_init_$lambda1(CustomSearchView customSearchView) {
        Intrinsics.checkNotNullParameter(customSearchView, "this$0");
        OnCloseListener onCloseListener = customSearchView.mCustomOnCloseListener;
        boolean onClose = onCloseListener == null ? false : onCloseListener.onClose();
        FragmentBackPressOverrider fragmentBackPressOverrider = customSearchView.backPressOverrider;
        if (fragmentBackPressOverrider.mIsBackCallbackAdded) {
            fragmentBackPressOverrider.mOnBackPressedCallback.remove();
            fragmentBackPressOverrider.mIsBackCallbackAdded = false;
        }
        return onClose;
    }

    public final boolean getOverrideBackAction() {
        return this.backPressOverrider.overrideBackAction;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mIconified) {
            this.backPressOverrider.maybeAddBackCallback();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FragmentBackPressOverrider fragmentBackPressOverrider = this.backPressOverrider;
        if (fragmentBackPressOverrider.mIsBackCallbackAdded) {
            fragmentBackPressOverrider.mOnBackPressedCallback.remove();
            fragmentBackPressOverrider.mIsBackCallbackAdded = false;
        }
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mCustomOnCloseListener = onCloseListener;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.mCustomOnSearchClickedListener = onClickListener;
    }

    public final void setOverrideBackAction(boolean z) {
        this.backPressOverrider.overrideBackAction = z;
    }
}
