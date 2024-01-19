package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.transition.TransitionManager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;

public class NavigationBarPresenter implements MenuPresenter {
    public int id;
    public MenuBuilder menu;
    public NavigationBarMenuView menuView;
    public boolean updateSuspended = false;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public ParcelableSparseArray badgeSavedStates;
        public int selectedItemId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
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
        this.menu = menuBuilder;
        this.menuView.menu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            NavigationBarMenuView navigationBarMenuView = this.menuView;
            SavedState savedState = (SavedState) parcelable;
            int i = savedState.selectedItemId;
            int size = navigationBarMenuView.menu.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item = navigationBarMenuView.menu.getItem(i2);
                if (i == item.getItemId()) {
                    navigationBarMenuView.selectedItemId = i;
                    navigationBarMenuView.selectedItemPosition = i2;
                    item.setChecked(true);
                    break;
                }
                i2++;
            }
            Context context = this.menuView.getContext();
            ParcelableSparseArray parcelableSparseArray = savedState.badgeSavedStates;
            SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
            int i3 = 0;
            while (i3 < parcelableSparseArray.size()) {
                int keyAt = parcelableSparseArray.keyAt(i3);
                com.google.android.material.badge.BadgeDrawable.SavedState savedState2 = (com.google.android.material.badge.BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i3);
                if (savedState2 != null) {
                    BadgeDrawable badgeDrawable = new BadgeDrawable(context);
                    badgeDrawable.setMaxCharacterCount(savedState2.maxCharacterCount);
                    int i4 = savedState2.number;
                    if (i4 != -1) {
                        badgeDrawable.setNumber(i4);
                    }
                    badgeDrawable.setBackgroundColor(savedState2.backgroundColor);
                    badgeDrawable.setBadgeTextColor(savedState2.badgeTextColor);
                    badgeDrawable.setBadgeGravity(savedState2.badgeGravity);
                    badgeDrawable.savedState.horizontalOffset = savedState2.horizontalOffset;
                    badgeDrawable.updateCenterAndBounds();
                    badgeDrawable.savedState.verticalOffset = savedState2.verticalOffset;
                    badgeDrawable.updateCenterAndBounds();
                    badgeDrawable.savedState.additionalHorizontalOffset = savedState2.additionalHorizontalOffset;
                    badgeDrawable.updateCenterAndBounds();
                    badgeDrawable.savedState.additionalVerticalOffset = savedState2.additionalVerticalOffset;
                    badgeDrawable.updateCenterAndBounds();
                    boolean z = savedState2.isVisible;
                    badgeDrawable.setVisible(z, false);
                    badgeDrawable.savedState.isVisible = z;
                    sparseArray.put(keyAt, badgeDrawable);
                    i3++;
                } else {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
            }
            this.menuView.setBadgeDrawables(sparseArray);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        SparseArray<BadgeDrawable> badgeDrawables = this.menuView.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        int i = 0;
        while (i < badgeDrawables.size()) {
            int keyAt = badgeDrawables.keyAt(i);
            BadgeDrawable valueAt = badgeDrawables.valueAt(i);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.savedState);
                i++;
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        savedState.badgeSavedStates = parcelableSparseArray;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(Callback callback) {
    }

    public void updateMenuView(boolean z) {
        if (!this.updateSuspended) {
            if (z) {
                this.menuView.buildMenuView();
            } else {
                NavigationBarMenuView navigationBarMenuView = this.menuView;
                MenuBuilder menuBuilder = navigationBarMenuView.menu;
                if (!(menuBuilder == null || navigationBarMenuView.buttons == null)) {
                    int size = menuBuilder.size();
                    if (size != navigationBarMenuView.buttons.length) {
                        navigationBarMenuView.buildMenuView();
                    } else {
                        int i = navigationBarMenuView.selectedItemId;
                        for (int i2 = 0; i2 < size; i2++) {
                            MenuItem item = navigationBarMenuView.menu.getItem(i2);
                            if (item.isChecked()) {
                                navigationBarMenuView.selectedItemId = item.getItemId();
                                navigationBarMenuView.selectedItemPosition = i2;
                            }
                        }
                        if (i != navigationBarMenuView.selectedItemId) {
                            TransitionManager.beginDelayedTransition(navigationBarMenuView, navigationBarMenuView.set);
                        }
                        boolean isShifting = navigationBarMenuView.isShifting(navigationBarMenuView.labelVisibilityMode, navigationBarMenuView.menu.getVisibleItems().size());
                        for (int i3 = 0; i3 < size; i3++) {
                            navigationBarMenuView.presenter.updateSuspended = true;
                            navigationBarMenuView.buttons[i3].setLabelVisibilityMode(navigationBarMenuView.labelVisibilityMode);
                            navigationBarMenuView.buttons[i3].setShifting(isShifting);
                            navigationBarMenuView.buttons[i3].initialize((MenuItemImpl) navigationBarMenuView.menu.getItem(i3), 0);
                            navigationBarMenuView.presenter.updateSuspended = false;
                        }
                    }
                }
            }
        }
    }
}
