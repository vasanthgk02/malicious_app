package com.mpl.androidapp.webview.view.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.DlgDownloaderDisabledBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/webview/view/dialogs/DownloadMngServiceChkDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/mpl/androidapp/databinding/DlgDownloaderDisabledBinding;", "callback", "Lcom/mpl/androidapp/webview/view/dialogs/DownloadMngServiceChkDialog$Callback;", "expandedStateForUi", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "setCallback", "setOnClickListener", "setViewText", "Callback", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadMngServiceChkDialog.kt */
public final class DownloadMngServiceChkDialog extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG_DOWNLOAD_SERVICE_DIALOG = "DOWNLOAD_SERVICE_DIALOG";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public DlgDownloaderDisabledBinding binding;
    public Callback callback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/webview/view/dialogs/DownloadMngServiceChkDialog$Callback;", "", "cancelActionClicked", "", "initiateSettings", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadMngServiceChkDialog.kt */
    public interface Callback {
        void cancelActionClicked();

        void initiateSettings();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/webview/view/dialogs/DownloadMngServiceChkDialog$Companion;", "", "()V", "TAG_DOWNLOAD_SERVICE_DIALOG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadMngServiceChkDialog.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void expandedStateForUi() {
        DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding = this.binding;
        if (dlgDownloaderDisabledBinding != null) {
            ViewParent parent = dlgDownloaderDisabledBinding.getRoot().getParent();
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
        DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding = this.binding;
        if (dlgDownloaderDisabledBinding != null) {
            dlgDownloaderDisabledBinding.closeActionId.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    DownloadMngServiceChkDialog.m25setOnClickListener$lambda2(DownloadMngServiceChkDialog.this, view);
                }
            });
            DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding2 = this.binding;
            if (dlgDownloaderDisabledBinding2 != null) {
                dlgDownloaderDisabledBinding2.contentsContainerId.retry.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        DownloadMngServiceChkDialog.m26setOnClickListener$lambda3(DownloadMngServiceChkDialog.this, view);
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

    /* renamed from: setOnClickListener$lambda-2  reason: not valid java name */
    public static final void m25setOnClickListener$lambda2(DownloadMngServiceChkDialog downloadMngServiceChkDialog, View view) {
        Intrinsics.checkNotNullParameter(downloadMngServiceChkDialog, "this$0");
        Callback callback2 = downloadMngServiceChkDialog.callback;
        if (callback2 != null) {
            callback2.cancelActionClicked();
        }
        downloadMngServiceChkDialog.dismiss();
    }

    /* renamed from: setOnClickListener$lambda-3  reason: not valid java name */
    public static final void m26setOnClickListener$lambda3(DownloadMngServiceChkDialog downloadMngServiceChkDialog, View view) {
        Intrinsics.checkNotNullParameter(downloadMngServiceChkDialog, "this$0");
        Callback callback2 = downloadMngServiceChkDialog.callback;
        if (callback2 != null) {
            callback2.initiateSettings();
        }
        downloadMngServiceChkDialog.dismiss();
    }

    private final void setViewText() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding = this.binding;
            if (dlgDownloaderDisabledBinding != null) {
                dlgDownloaderDisabledBinding.contentsContainerId.header.setText(activity.getText(R.string.game_download_failed));
                DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding2 = this.binding;
                if (dlgDownloaderDisabledBinding2 != null) {
                    dlgDownloaderDisabledBinding2.contentsContainerId.description.setText(activity.getText(R.string.game_download_failed_message));
                    DlgDownloaderDisabledBinding dlgDownloaderDisabledBinding3 = this.binding;
                    if (dlgDownloaderDisabledBinding3 != null) {
                        dlgDownloaderDisabledBinding3.contentsContainerId.retry.setText(activity.getText(R.string.open_settings));
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
        }
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.VideoTracksTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DlgDownloaderDisabledBinding inflate = DlgDownloaderDisabledBinding.inflate(layoutInflater, viewGroup, false);
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
        setViewText();
        setOnClickListener();
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }
}
