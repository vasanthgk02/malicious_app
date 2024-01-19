package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import androidx.core.R$id;

public class ViewCompat$Api21Impl$1 implements OnApplyWindowInsetsListener {
    public WindowInsetsCompat mLastInsets = null;
    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    public final /* synthetic */ View val$v;

    public ViewCompat$Api21Impl$1(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.val$v = view;
        this.val$listener = onApplyWindowInsetsListener;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        if (VERSION.SDK_INT < 30) {
            View view2 = this.val$v;
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = (OnApplyWindowInsetsListener) view2.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
            if (windowInsetsCompat.equals(this.mLastInsets)) {
                return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.mLastInsets = windowInsetsCompat;
        WindowInsetsCompat onApplyWindowInsets = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
        if (VERSION.SDK_INT >= 30) {
            return onApplyWindowInsets.toWindowInsets();
        }
        ViewCompat.requestApplyInsets(view);
        return onApplyWindowInsets.toWindowInsets();
    }
}
