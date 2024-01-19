package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class NavigationBarMenu extends MenuBuilder {
    public final int maxItemCount;
    public final Class<?> viewClass;

    public NavigationBarMenu(Context context, Class<?> cls, int i) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
    }

    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i, i2, i3, charSequence);
            ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("Maximum number of items supported by ", simpleName, " is ");
        outline80.append(this.maxItemCount);
        outline80.append(". Limit can be checked with ");
        outline80.append(simpleName);
        outline80.append("#getMaxItemCount()");
        throw new IllegalArgumentException(outline80.toString());
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }
}
