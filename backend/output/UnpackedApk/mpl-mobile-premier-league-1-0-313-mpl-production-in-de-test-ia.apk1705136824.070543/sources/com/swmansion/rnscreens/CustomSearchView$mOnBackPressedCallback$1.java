package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/CustomSearchView$mOnBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomSearchView.kt */
public final class CustomSearchView$mOnBackPressedCallback$1 extends OnBackPressedCallback {
    public final /* synthetic */ CustomSearchView this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomSearchView$mOnBackPressedCallback$1(CustomSearchView customSearchView) {
        // this.this$0 = customSearchView;
        super(true);
    }

    public void handleOnBackPressed() {
        this.this$0.setIconified(true);
    }
}
