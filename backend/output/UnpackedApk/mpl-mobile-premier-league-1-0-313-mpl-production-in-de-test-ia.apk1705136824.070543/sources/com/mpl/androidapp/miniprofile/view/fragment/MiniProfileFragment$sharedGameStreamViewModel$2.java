package com.mpl.androidapp.miniprofile.view.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileFragment.kt */
public final class MiniProfileFragment$sharedGameStreamViewModel$2 extends Lambda implements Function0<ViewModelStoreOwner> {
    public final /* synthetic */ MiniProfileFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MiniProfileFragment$sharedGameStreamViewModel$2(MiniProfileFragment miniProfileFragment) {
        // this.this$0 = miniProfileFragment;
        super(0);
    }

    public final ViewModelStoreOwner invoke() {
        Fragment requireParentFragment = this.this$0.requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment()");
        return requireParentFragment;
    }
}
