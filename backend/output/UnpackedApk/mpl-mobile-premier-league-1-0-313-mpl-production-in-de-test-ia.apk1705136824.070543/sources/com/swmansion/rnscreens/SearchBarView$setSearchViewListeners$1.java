package com.swmansion.rnscreens;

import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/swmansion/rnscreens/SearchBarView$setSearchViewListeners$1", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", "query", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBarView.kt */
public final class SearchBarView$setSearchViewListeners$1 implements OnQueryTextListener {
    public final /* synthetic */ SearchBarView this$0;

    public SearchBarView$setSearchViewListeners$1(SearchBarView searchBarView) {
        this.this$0 = searchBarView;
    }

    public boolean onQueryTextChange(String str) {
        SearchBarView.access$handleTextChange(this.this$0, str);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        SearchBarView.access$handleTextSubmit(this.this$0, str);
        return true;
    }
}
