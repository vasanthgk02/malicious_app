package com.mpl.androidapp.miniprofile.extensions;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"hideKeyboard", "", "Landroid/view/View;", "hideSoftKeyboard", "Landroid/app/Activity;", "Landroidx/fragment/app/Fragment;", "showKeyboard", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardExt.kt */
public final class KeyboardExtKt {
    public static final void hideKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final void hideSoftKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity.getCurrentFocus() != null) {
            Object systemService = activity.getSystemService("input_method");
            if (systemService != null) {
                View currentFocus = activity.getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus);
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public static final void showKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        if (systemService != null) {
            view.requestFocus();
            ((InputMethodManager) systemService).showSoftInput(view, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final void hideSoftKeyboard(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            hideSoftKeyboard((Activity) activity);
        }
    }
}
