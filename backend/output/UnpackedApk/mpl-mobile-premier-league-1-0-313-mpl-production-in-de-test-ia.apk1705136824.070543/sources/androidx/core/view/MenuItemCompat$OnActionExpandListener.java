package androidx.core.view;

import android.view.MenuItem;

@Deprecated
public interface MenuItemCompat$OnActionExpandListener {
    boolean onMenuItemActionCollapse(MenuItem menuItem);

    boolean onMenuItemActionExpand(MenuItem menuItem);
}
