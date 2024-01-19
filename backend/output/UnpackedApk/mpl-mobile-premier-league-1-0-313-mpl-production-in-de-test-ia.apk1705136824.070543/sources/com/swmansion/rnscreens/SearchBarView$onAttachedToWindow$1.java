package com.swmansion.rnscreens;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newSearchView", "Lcom/swmansion/rnscreens/CustomSearchView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBarView.kt */
public final class SearchBarView$onAttachedToWindow$1 extends Lambda implements Function1<CustomSearchView, Unit> {
    public final /* synthetic */ SearchBarView this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SearchBarView$onAttachedToWindow$1(SearchBarView searchBarView) {
        // this.this$0 = searchBarView;
        super(1);
    }

    public Object invoke(Object obj) {
        CustomSearchView customSearchView = (CustomSearchView) obj;
        Intrinsics.checkNotNullParameter(customSearchView, "newSearchView");
        SearchBarView searchBarView = this.this$0;
        if (searchBarView.mSearchViewFormatter == null) {
            searchBarView.mSearchViewFormatter = new SearchViewFormatter(customSearchView);
        }
        this.this$0.setSearchViewProps();
        if (this.this$0.getAutoFocus()) {
            ScreenStackFragment access$getScreenStackFragment = this.this$0.getScreenStackFragment();
            if (access$getScreenStackFragment != null) {
                CustomSearchView customSearchView2 = access$getScreenStackFragment.searchView;
                if (customSearchView2 != null) {
                    customSearchView2.setIconified(false);
                    customSearchView2.requestFocusFromTouch();
                }
            }
        }
        return Unit.INSTANCE;
    }
}
