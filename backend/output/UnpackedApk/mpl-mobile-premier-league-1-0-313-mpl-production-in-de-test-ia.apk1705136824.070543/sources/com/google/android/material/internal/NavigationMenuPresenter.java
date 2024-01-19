package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {
    public NavigationMenuAdapter adapter;
    public Callback callback;
    public boolean hasCustomItemIconSize;
    public LinearLayout headerLayout;
    public ColorStateList iconTintList;
    public int id;
    public boolean isBehindStatusBar = true;
    public Drawable itemBackground;
    public int itemHorizontalPadding;
    public int itemIconPadding;
    public int itemIconSize;
    public int itemMaxLines;
    public LayoutInflater layoutInflater;
    public MenuBuilder menu;
    public NavigationMenuView menuView;
    public final OnClickListener onClickListener = new OnClickListener() {
        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z = false;
            } else {
                NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };
    public int overScrollMode = -1;
    public int paddingSeparator;
    public int paddingTopDefault;
    public int textAppearance;
    public boolean textAppearanceSet;
    public ColorStateList textColor;

    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    public class NavigationMenuAdapter extends Adapter<ViewHolder> {
        public MenuItemImpl checkedItem;
        public final ArrayList<NavigationMenuItem> items = new ArrayList<>();
        public boolean updateSuspended;

        public NavigationMenuAdapter() {
            prepareMenuItems();
        }

        public int getItemCount() {
            return this.items.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            NavigationMenuItem navigationMenuItem = this.items.get(i);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).menuItem.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder2.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                if (navigationMenuPresenter.textAppearanceSet) {
                    navigationMenuItemView.setTextAppearance(navigationMenuPresenter.textAppearance);
                }
                ColorStateList colorStateList = NavigationMenuPresenter.this.textColor;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = NavigationMenuPresenter.this.itemBackground;
                ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
                navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
                navigationMenuItemView.initialize(navigationMenuTextItem.menuItem, 0);
            } else if (itemViewType == 1) {
                ((TextView) viewHolder2.itemView).setText(((NavigationMenuTextItem) this.items.get(i)).menuItem.mTitle);
            } else if (itemViewType == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i);
                viewHolder2.itemView.setPadding(0, navigationMenuSeparatorItem.paddingTop, 0, navigationMenuSeparatorItem.paddingBottom);
            }
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder;
            if (i == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                viewHolder = new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            } else if (i == 1) {
                viewHolder = new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else if (i == 2) {
                viewHolder = new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else if (i != 3) {
                return null;
            } else {
                return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
            }
            return viewHolder;
        }

        public void onViewRecycled(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            if (viewHolder2 instanceof NormalViewHolder) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder2.itemView;
                FrameLayout frameLayout = navigationMenuItemView.actionArea;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                navigationMenuItemView.textView.setCompoundDrawables(null, null, null, null);
            }
        }

        public final void prepareMenuItems() {
            if (!this.updateSuspended) {
                this.updateSuspended = true;
                this.items.clear();
                this.items.add(new NavigationMenuHeaderItem());
                int i = -1;
                int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
                boolean z = false;
                int i2 = 0;
                boolean z2 = false;
                int i3 = 0;
                while (i2 < size) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i2);
                    if (menuItemImpl.isChecked()) {
                        setCheckedItem(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(z);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenuBuilder subMenuBuilder = menuItemImpl.mSubMenu;
                        if (subMenuBuilder.hasVisibleItems()) {
                            if (i2 != 0) {
                                this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, z ? 1 : 0));
                            }
                            this.items.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = subMenuBuilder.size();
                            int i4 = 0;
                            boolean z3 = false;
                            while (i4 < size2) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenuBuilder.getItem(i4);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(z);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        setCheckedItem(menuItemImpl);
                                    }
                                    this.items.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                                i4++;
                                z = false;
                            }
                            if (z3) {
                                int size3 = this.items.size();
                                for (int size4 = this.items.size(); size4 < size3; size4++) {
                                    ((NavigationMenuTextItem) this.items.get(size4)).needsEmptyIcon = true;
                                }
                            }
                        }
                    } else {
                        int i5 = menuItemImpl.mGroup;
                        if (i5 != i) {
                            i3 = this.items.size();
                            z2 = menuItemImpl.getIcon() != null;
                            if (i2 != 0) {
                                i3++;
                                ArrayList<NavigationMenuItem> arrayList = this.items;
                                int i6 = NavigationMenuPresenter.this.paddingSeparator;
                                arrayList.add(new NavigationMenuSeparatorItem(i6, i6));
                            }
                        } else if (!z2 && menuItemImpl.getIcon() != null) {
                            int size5 = this.items.size();
                            for (int i7 = i3; i7 < size5; i7++) {
                                ((NavigationMenuTextItem) this.items.get(i7)).needsEmptyIcon = true;
                            }
                            z2 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.needsEmptyIcon = z2;
                        this.items.add(navigationMenuTextItem);
                        i = i5;
                    }
                    i2++;
                    z = false;
                }
                this.updateSuspended = false;
            }
        }

        public void setCheckedItem(MenuItemImpl menuItemImpl) {
            if (this.checkedItem != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.checkedItem;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.checkedItem = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }
    }

    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
    }

    public interface NavigationMenuItem {
    }

    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        public final int paddingBottom;
        public final int paddingTop;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.paddingTop = i;
            this.paddingBottom = i2;
        }
    }

    public static class NavigationMenuTextItem implements NavigationMenuItem {
        public final MenuItemImpl menuItem;
        public boolean needsEmptyIcon;

        public NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.menuItem = menuItemImpl;
        }
    }

    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        public NavigationMenuViewAccessibilityDelegate(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NavigationMenuAdapter navigationMenuAdapter = NavigationMenuPresenter.this.adapter;
            int i = NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.adapter.getItemCount(); i2++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            accessibilityNodeInfoCompat.setCollectionInfo(new CollectionInfoCompat(CollectionInfo.obtain(i, 0, false)));
        }
    }

    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public static abstract class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.id;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onCloseMenu(menuBuilder, z);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                NavigationMenuAdapter navigationMenuAdapter = this.adapter;
                if (navigationMenuAdapter != null) {
                    int i = bundle2.getInt("android:menu:checked", 0);
                    if (i != 0) {
                        navigationMenuAdapter.updateSuspended = true;
                        int size = navigationMenuAdapter.items.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            NavigationMenuItem navigationMenuItem = navigationMenuAdapter.items.get(i2);
                            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                                MenuItemImpl menuItemImpl = ((NavigationMenuTextItem) navigationMenuItem).menuItem;
                                if (menuItemImpl != null && menuItemImpl.mId == i) {
                                    navigationMenuAdapter.setCheckedItem(menuItemImpl);
                                    break;
                                }
                            }
                            i2++;
                        }
                        navigationMenuAdapter.updateSuspended = false;
                        navigationMenuAdapter.prepareMenuItems();
                    }
                    SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                    if (sparseParcelableArray2 != null) {
                        int size2 = navigationMenuAdapter.items.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            NavigationMenuItem navigationMenuItem2 = navigationMenuAdapter.items.get(i3);
                            if (navigationMenuItem2 instanceof NavigationMenuTextItem) {
                                MenuItemImpl menuItemImpl2 = ((NavigationMenuTextItem) navigationMenuItem2).menuItem;
                                if (menuItemImpl2 != null) {
                                    View actionView = menuItemImpl2.getActionView();
                                    if (actionView != null) {
                                        ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(menuItemImpl2.mId);
                                        if (parcelableSparseArray != null) {
                                            actionView.restoreHierarchyState(parcelableSparseArray);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray sparseArray = new SparseArray();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            if (navigationMenuAdapter != null) {
                Bundle bundle2 = new Bundle();
                MenuItemImpl menuItemImpl = navigationMenuAdapter.checkedItem;
                if (menuItemImpl != null) {
                    bundle2.putInt("android:menu:checked", menuItemImpl.mId);
                }
                SparseArray sparseArray2 = new SparseArray();
                int size = navigationMenuAdapter.items.size();
                for (int i = 0; i < size; i++) {
                    NavigationMenuItem navigationMenuItem = navigationMenuAdapter.items.get(i);
                    if (navigationMenuItem instanceof NavigationMenuTextItem) {
                        MenuItemImpl menuItemImpl2 = ((NavigationMenuTextItem) navigationMenuItem).menuItem;
                        View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                        if (actionView != null) {
                            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                            actionView.saveHierarchyState(parcelableSparseArray);
                            sparseArray2.put(menuItemImpl2.mId, parcelableSparseArray);
                        }
                    }
                }
                bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
                bundle.putBundle("android:menu:adapter", bundle2);
            } else {
                throw null;
            }
        }
        if (this.headerLayout != null) {
            SparseArray sparseArray3 = new SparseArray();
            this.headerLayout.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void setItemHorizontalPadding(int i) {
        this.itemHorizontalPadding = i;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i) {
        this.itemIconPadding = i;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.updateSuspended = z;
        }
    }

    public void updateMenuView(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.prepareMenuItems();
            navigationMenuAdapter.notifyDataSetChanged();
        }
    }

    public final void updateTopPadding() {
        int i = (this.headerLayout.getChildCount() != 0 || !this.isBehindStatusBar) ? 0 : this.paddingTopDefault;
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
    }
}
