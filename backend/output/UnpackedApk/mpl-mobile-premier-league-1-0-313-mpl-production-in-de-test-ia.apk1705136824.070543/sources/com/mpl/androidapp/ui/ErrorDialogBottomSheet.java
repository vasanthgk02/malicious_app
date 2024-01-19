package com.mpl.androidapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.LayoutErrorDialogBottomSheetBinding;
import com.mpl.androidapp.utils.Constant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "mBinding", "Lcom/mpl/androidapp/databinding/LayoutErrorDialogBottomSheetBinding;", "mListener", "Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet$ActionItemClickListener;", "getTheme", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "ActionItemClickListener", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorDialogBottomSheet.kt */
public final class ErrorDialogBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public LayoutErrorDialogBottomSheetBinding mBinding;
    public ActionItemClickListener mListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet$ActionItemClickListener;", "", "onCancelClick", "", "onError", "onRetryClick", "errorDialogBottomSheet", "Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorDialogBottomSheet.kt */
    public interface ActionItemClickListener {
        void onCancelClick();

        void onError();

        void onRetryClick(ErrorDialogBottomSheet errorDialogBottomSheet);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet$Companion;", "", "()V", "newInstance", "Lcom/mpl/androidapp/ui/ErrorDialogBottomSheet;", "bundle", "Landroid/os/Bundle;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorDialogBottomSheet.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorDialogBottomSheet newInstance(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
            ErrorDialogBottomSheet errorDialogBottomSheet = new ErrorDialogBottomSheet();
            errorDialogBottomSheet.setArguments(bundle);
            return errorDialogBottomSheet;
        }
    }

    public static final ErrorDialogBottomSheet newInstance(Bundle bundle) {
        return Companion.newInstance(bundle);
    }

    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m20onViewCreated$lambda0(ErrorDialogBottomSheet errorDialogBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(errorDialogBottomSheet, "this$0");
        ActionItemClickListener actionItemClickListener = errorDialogBottomSheet.mListener;
        if (actionItemClickListener != null) {
            actionItemClickListener.onCancelClick();
        }
    }

    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m21onViewCreated$lambda1(ErrorDialogBottomSheet errorDialogBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(errorDialogBottomSheet, "this$0");
        ActionItemClickListener actionItemClickListener = errorDialogBottomSheet.mListener;
        if (actionItemClickListener != null) {
            actionItemClickListener.onRetryClick(errorDialogBottomSheet);
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

    public int getTheme() {
        return R.style.AppBottomSheetDialogThemeWhite;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof ActionItemClickListener) {
            this.mListener = (ActionItemClickListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement ActionItemClickListener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.layout_error_dialog_bottom_sheet, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            inf…          false\n        )");
        LayoutErrorDialogBottomSheetBinding layoutErrorDialogBottomSheetBinding = (LayoutErrorDialogBottomSheetBinding) inflate;
        this.mBinding = layoutErrorDialogBottomSheetBinding;
        if (layoutErrorDialogBottomSheetBinding != null) {
            View root = layoutErrorDialogBottomSheetBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
            return root;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        throw null;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setCancelable(false);
        LayoutErrorDialogBottomSheetBinding layoutErrorDialogBottomSheetBinding = this.mBinding;
        if (layoutErrorDialogBottomSheetBinding != null) {
            layoutErrorDialogBottomSheetBinding.cancel.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ErrorDialogBottomSheet.m20onViewCreated$lambda0(ErrorDialogBottomSheet.this, view);
                }
            });
            LayoutErrorDialogBottomSheetBinding layoutErrorDialogBottomSheetBinding2 = this.mBinding;
            if (layoutErrorDialogBottomSheetBinding2 != null) {
                layoutErrorDialogBottomSheetBinding2.retry.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        ErrorDialogBottomSheet.m21onViewCreated$lambda1(ErrorDialogBottomSheet.this, view);
                    }
                });
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            throw null;
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        try {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception unused) {
        }
    }
}
