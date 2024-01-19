package androidx.core.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

public class MenuItemCompat$1 implements OnActionExpandListener {
    public final /* synthetic */ MenuItemCompat$OnActionExpandListener val$listener;

    public MenuItemCompat$1(MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        this.val$listener = menuItemCompat$OnActionExpandListener;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionCollapse(menuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionExpand(menuItem);
    }
}
