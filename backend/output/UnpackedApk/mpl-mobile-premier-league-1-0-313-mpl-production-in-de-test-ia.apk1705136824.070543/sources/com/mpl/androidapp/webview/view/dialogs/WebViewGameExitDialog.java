package com.mpl.androidapp.webview.view.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.databinding.DlgWebviewGameExitWindowBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameExitDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/mpl/androidapp/databinding/DlgWebviewGameExitWindowBinding;", "callback", "Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameExitDialog$Callback;", "expandedStateForUi", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setCallback", "setOnClickListener", "Callback", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGameExitDialog.kt */
public final class WebViewGameExitDialog extends BottomSheetDialogFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public DlgWebviewGameExitWindowBinding binding;
    public Callback callback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/mpl/androidapp/webview/view/dialogs/WebViewGameExitDialog$Callback;", "", "closeGame", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameExitDialog.kt */
    public interface Callback {
        void closeGame();
    }

    private final void expandedStateForUi() {
        DlgWebviewGameExitWindowBinding dlgWebviewGameExitWindowBinding = this.binding;
        if (dlgWebviewGameExitWindowBinding != null) {
            ViewParent parent = dlgWebviewGameExitWindowBinding.getRoot().getParent();
            if (parent != null) {
                BottomSheetBehavior.from((View) parent).setState(3);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final void setOnClickListener() {
        DlgWebviewGameExitWindowBinding dlgWebviewGameExitWindowBinding = this.binding;
        if (dlgWebviewGameExitWindowBinding != null) {
            dlgWebviewGameExitWindowBinding.cancel.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WebViewGameExitDialog.m28setOnClickListener$lambda1(WebViewGameExitDialog.this, view);
                }
            });
            DlgWebviewGameExitWindowBinding dlgWebviewGameExitWindowBinding2 = this.binding;
            if (dlgWebviewGameExitWindowBinding2 != null) {
                dlgWebviewGameExitWindowBinding2.retry.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        WebViewGameExitDialog.m29setOnClickListener$lambda2(WebViewGameExitDialog.this, view);
                    }
                });
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }

    /* renamed from: setOnClickListener$lambda-1  reason: not valid java name */
    public static final void m28setOnClickListener$lambda1(WebViewGameExitDialog webViewGameExitDialog, View view) {
        Intrinsics.checkNotNullParameter(webViewGameExitDialog, "this$0");
        webViewGameExitDialog.dismiss();
    }

    /* renamed from: setOnClickListener$lambda-2  reason: not valid java name */
    public static final void m29setOnClickListener$lambda2(WebViewGameExitDialog webViewGameExitDialog, View view) {
        Intrinsics.checkNotNullParameter(webViewGameExitDialog, "this$0");
        Callback callback2 = webViewGameExitDialog.callback;
        if (callback2 != null) {
            callback2.closeGame();
        }
        webViewGameExitDialog.dismiss();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 != null) {
            View findViewById = view2.findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
        }
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DlgWebviewGameExitWindowBinding inflate = DlgWebviewGameExitWindowBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate != null) {
            return inflate.getRoot();
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
        expandedStateForUi();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
        }
        setOnClickListener();
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }
}
