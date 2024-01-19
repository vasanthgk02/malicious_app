package com.swmansion.rnscreens;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0015\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\u0015\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\n \f*\u0004\u0018\u00010\u00160\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0004¨\u0006+"}, d2 = {"Lcom/swmansion/rnscreens/SearchViewFormatter;", "", "searchView", "Landroidx/appcompat/widget/SearchView;", "(Landroidx/appcompat/widget/SearchView;)V", "mDefaultTextColor", "", "Ljava/lang/Integer;", "mDefaultTintBackground", "Landroid/graphics/drawable/Drawable;", "searchCloseIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getSearchCloseIcon", "()Landroid/widget/ImageView;", "searchEditText", "Landroid/widget/EditText;", "getSearchEditText", "()Landroid/widget/EditText;", "searchIcon", "getSearchIcon", "searchTextPlate", "Landroid/view/View;", "getSearchTextPlate", "()Landroid/view/View;", "getSearchView", "()Landroidx/appcompat/widget/SearchView;", "setSearchView", "setHeaderIconColor", "", "headerIconColor", "(Ljava/lang/Integer;)V", "setHintTextColor", "hintTextColor", "setPlaceholder", "placeholder", "", "shouldShowHintSearchIcon", "", "setTextColor", "textColor", "setTintColor", "tintColor", "react-native-screens_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchViewFormatter.kt */
public final class SearchViewFormatter {
    public Integer mDefaultTextColor;
    public Drawable mDefaultTintBackground;
    public SearchView searchView;

    public SearchViewFormatter(SearchView searchView2) {
        Intrinsics.checkNotNullParameter(searchView2, "searchView");
        this.searchView = searchView2;
    }

    public final EditText getSearchEditText() {
        View findViewById = this.searchView.findViewById(R$id.search_src_text);
        if (findViewById instanceof EditText) {
            return (EditText) findViewById;
        }
        return null;
    }

    public final View getSearchTextPlate() {
        return this.searchView.findViewById(R$id.search_plate);
    }
}
