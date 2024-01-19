package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnDismissListener {
    public static final int ITEM_LAYOUT = R$layout.abc_cascading_menu_item_layout;
    public View mAnchorView;
    public final OnAttachStateChangeListener mAttachStateChangeListener = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public final Context mContext;
    public int mDropDownGravity;
    public boolean mForceShowIcon;
    public final OnGlobalLayoutListener mGlobalLayoutListener = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !CascadingMenuPopup.this.mShowingMenus.get(0).window.mModal) {
                View view = CascadingMenuPopup.this.mShownAnchorView;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.mShowingMenus) {
                    cascadingMenuInfo.window.show();
                }
            }
        }
    };
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener() {
        public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.mShowingMenus.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.mShowingMenus.get(i).menu) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < CascadingMenuPopup.this.mShowingMenus.size()) {
                    cascadingMenuInfo = CascadingMenuPopup.this.mShowingMenus.get(i2);
                }
                CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new Runnable() {
                    public void run() {
                        CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.mShouldCloseImmediately = true;
                            cascadingMenuInfo.menu.close(false);
                            CascadingMenuPopup.this.mShouldCloseImmediately = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    };
    public final int mMenuMaxWidth;
    public OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final List<MenuBuilder> mPendingMenus = new ArrayList();
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public Callback mPresenterCallback;
    public int mRawDropDownGravity;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public final List<CascadingMenuInfo> mShowingMenus = new ArrayList();
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        int i3 = 0;
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mOverflowOnly = z;
        this.mForceShowIcon = false;
        this.mLastPosition = ViewCompat.getLayoutDirection(view) != 1 ? 1 : i3;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    public void dismiss() {
        int size = this.mShowingMenus.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        if (this.mShowingMenus.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) GeneratedOutlineSupport.outline29(this.mShowingMenus, -1)).window.mDropDownList;
    }

    public boolean isShowing() {
        return this.mShowingMenus.size() > 0 && this.mShowingMenus.get(0).window.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int size = this.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == this.mShowingMenus.get(i).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            int i2 = i + 1;
            if (i2 < this.mShowingMenus.size()) {
                this.mShowingMenus.get(i2).menu.close(false);
            }
            CascadingMenuInfo remove = this.mShowingMenus.remove(i);
            remove.menu.removeMenuPresenter(this);
            if (this.mShouldCloseImmediately) {
                MenuPopupWindow menuPopupWindow = remove.window;
                if (menuPopupWindow != null) {
                    if (VERSION.SDK_INT >= 23) {
                        menuPopupWindow.mPopup.setExitTransition(null);
                    }
                    remove.window.mPopup.setAnimationStyle(0);
                } else {
                    throw null;
                }
            }
            remove.window.dismiss();
            int size2 = this.mShowingMenus.size();
            if (size2 > 0) {
                this.mLastPosition = this.mShowingMenus.get(size2 - 1).position;
            } else {
                this.mLastPosition = ViewCompat.getLayoutDirection(this.mAnchorView) == 1 ? 0 : 1;
            }
            if (size2 == 0) {
                dismiss();
                Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.mTreeObserver;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                    }
                    this.mTreeObserver = null;
                }
                this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mOnDismissListener.onDismiss();
            } else if (z) {
                this.mShowingMenus.get(0).menu.close(false);
            }
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.mShowingMenus.get(i);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            }
            i++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo next : this.mShowingMenus) {
            if (subMenuBuilder == next.menu) {
                next.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        subMenuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(subMenuBuilder);
        } else {
            this.mPendingMenus.add(subMenuBuilder);
        }
        Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(view));
        }
    }

    public void setCallback(Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    public void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    public void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    public void show() {
        if (!isShowing()) {
            for (MenuBuilder showMenu : this.mPendingMenus) {
                showMenu(showMenu);
            }
            this.mPendingMenus.clear();
            View view = this.mAnchorView;
            this.mShownAnchorView = view;
            if (view != null) {
                boolean z = this.mTreeObserver == null;
                ViewTreeObserver viewTreeObserver = this.mShownAnchorView.getViewTreeObserver();
                this.mTreeObserver = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
                this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0132, code lost:
        if (((r7.getWidth() + r8[0]) + r2) > r9.right) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0138, code lost:
        if ((r8[0] - r2) < 0) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showMenu(androidx.appcompat.view.menu.MenuBuilder r15) {
        /*
            r14 = this;
            android.content.Context r0 = r14.mContext
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            androidx.appcompat.view.menu.MenuAdapter r1 = new androidx.appcompat.view.menu.MenuAdapter
            boolean r2 = r14.mOverflowOnly
            int r3 = ITEM_LAYOUT
            r1.<init>(r15, r0, r2, r3)
            boolean r2 = r14.isShowing()
            r3 = 1
            if (r2 != 0) goto L_0x001d
            boolean r2 = r14.mForceShowIcon
            if (r2 == 0) goto L_0x001d
            r1.mForceShowIcon = r3
            goto L_0x0029
        L_0x001d:
            boolean r2 = r14.isShowing()
            if (r2 == 0) goto L_0x0029
            boolean r2 = androidx.appcompat.view.menu.MenuPopup.shouldPreserveIconSpacing(r15)
            r1.mForceShowIcon = r2
        L_0x0029:
            android.content.Context r2 = r14.mContext
            int r4 = r14.mMenuMaxWidth
            r5 = 0
            int r2 = androidx.appcompat.view.menu.MenuPopup.measureIndividualMenuWidth(r1, r5, r2, r4)
            androidx.appcompat.widget.MenuPopupWindow r4 = new androidx.appcompat.widget.MenuPopupWindow
            android.content.Context r6 = r14.mContext
            int r7 = r14.mPopupStyleAttr
            int r8 = r14.mPopupStyleRes
            r4.<init>(r6, r5, r7, r8)
            androidx.appcompat.widget.MenuItemHoverListener r6 = r14.mMenuItemHoverListener
            r4.mHoverListener = r6
            r4.mItemClickListener = r14
            android.widget.PopupWindow r6 = r4.mPopup
            r6.setOnDismissListener(r14)
            android.view.View r6 = r14.mAnchorView
            r4.mDropDownAnchorView = r6
            int r6 = r14.mDropDownGravity
            r4.mDropDownGravity = r6
            r4.setModal(r3)
            android.widget.PopupWindow r6 = r4.mPopup
            r7 = 2
            r6.setInputMethodMode(r7)
            r4.setAdapter(r1)
            r4.setContentWidth(r2)
            int r1 = r14.mDropDownGravity
            r4.mDropDownGravity = r1
            java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo> r1 = r14.mShowingMenus
            int r1 = r1.size()
            r6 = 0
            if (r1 <= 0) goto L_0x00db
            java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo> r1 = r14.mShowingMenus
            java.lang.Object r1 = com.android.tools.r8.GeneratedOutlineSupport.outline30(r1, r3)
            androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo r1 = (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo) r1
            androidx.appcompat.view.menu.MenuBuilder r7 = r1.menu
            int r8 = r7.size()
            r9 = 0
        L_0x007b:
            if (r9 >= r8) goto L_0x0091
            android.view.MenuItem r10 = r7.getItem(r9)
            boolean r11 = r10.hasSubMenu()
            if (r11 == 0) goto L_0x008e
            android.view.SubMenu r11 = r10.getSubMenu()
            if (r15 != r11) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            int r9 = r9 + 1
            goto L_0x007b
        L_0x0091:
            r10 = r5
        L_0x0092:
            if (r10 != 0) goto L_0x0095
            goto L_0x00dd
        L_0x0095:
            androidx.appcompat.widget.MenuPopupWindow r5 = r1.window
            androidx.appcompat.widget.DropDownListView r5 = r5.mDropDownList
            android.widget.ListAdapter r7 = r5.getAdapter()
            boolean r8 = r7 instanceof android.widget.HeaderViewListAdapter
            if (r8 == 0) goto L_0x00ae
            android.widget.HeaderViewListAdapter r7 = (android.widget.HeaderViewListAdapter) r7
            int r8 = r7.getHeadersCount()
            android.widget.ListAdapter r7 = r7.getWrappedAdapter()
            androidx.appcompat.view.menu.MenuAdapter r7 = (androidx.appcompat.view.menu.MenuAdapter) r7
            goto L_0x00b1
        L_0x00ae:
            androidx.appcompat.view.menu.MenuAdapter r7 = (androidx.appcompat.view.menu.MenuAdapter) r7
            r8 = 0
        L_0x00b1:
            int r9 = r7.getCount()
            r11 = 0
        L_0x00b6:
            r12 = -1
            if (r11 >= r9) goto L_0x00c3
            androidx.appcompat.view.menu.MenuItemImpl r13 = r7.getItem(r11)
            if (r10 != r13) goto L_0x00c0
            goto L_0x00c4
        L_0x00c0:
            int r11 = r11 + 1
            goto L_0x00b6
        L_0x00c3:
            r11 = -1
        L_0x00c4:
            if (r11 != r12) goto L_0x00c7
            goto L_0x00dc
        L_0x00c7:
            int r11 = r11 + r8
            int r7 = r5.getFirstVisiblePosition()
            int r11 = r11 - r7
            if (r11 < 0) goto L_0x00dc
            int r7 = r5.getChildCount()
            if (r11 < r7) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            android.view.View r5 = r5.getChildAt(r11)
            goto L_0x00dd
        L_0x00db:
            r1 = 0
        L_0x00dc:
            r5 = 0
        L_0x00dd:
            if (r5 == 0) goto L_0x01a2
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 28
            if (r7 > r8) goto L_0x00f7
            java.lang.reflect.Method r7 = androidx.appcompat.widget.MenuPopupWindow.sSetTouchModalMethod
            if (r7 == 0) goto L_0x00fc
            android.widget.PopupWindow r8 = r4.mPopup     // Catch:{ Exception -> 0x00f5 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00f5 }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x00f5 }
            r9[r6] = r10     // Catch:{ Exception -> 0x00f5 }
            r7.invoke(r8, r9)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00fc
        L_0x00f5:
            goto L_0x00fc
        L_0x00f7:
            android.widget.PopupWindow r7 = r4.mPopup
            r7.setTouchModal(r6)
        L_0x00fc:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 23
            if (r7 < r8) goto L_0x0108
            android.widget.PopupWindow r7 = r4.mPopup
            r8 = 0
            r7.setEnterTransition(r8)
        L_0x0108:
            java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo> r7 = r14.mShowingMenus
            java.lang.Object r7 = com.android.tools.r8.GeneratedOutlineSupport.outline30(r7, r3)
            androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo r7 = (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo) r7
            androidx.appcompat.widget.MenuPopupWindow r7 = r7.window
            androidx.appcompat.widget.DropDownListView r7 = r7.mDropDownList
            r8 = 2
            int[] r8 = new int[r8]
            r7.getLocationOnScreen(r8)
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            android.view.View r10 = r14.mShownAnchorView
            r10.getWindowVisibleDisplayFrame(r9)
            int r10 = r14.mLastPosition
            if (r10 != r3) goto L_0x0135
            r8 = r8[r6]
            int r7 = r7.getWidth()
            int r7 = r7 + r8
            int r7 = r7 + r2
            int r8 = r9.right
            if (r7 <= r8) goto L_0x013a
            goto L_0x013c
        L_0x0135:
            r7 = r8[r6]
            int r7 = r7 - r2
            if (r7 >= 0) goto L_0x013c
        L_0x013a:
            r7 = 1
            goto L_0x013d
        L_0x013c:
            r7 = 0
        L_0x013d:
            if (r7 != r3) goto L_0x0141
            r8 = 1
            goto L_0x0142
        L_0x0141:
            r8 = 0
        L_0x0142:
            r14.mLastPosition = r7
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            r10 = 5
            if (r7 < r9) goto L_0x0150
            r4.mDropDownAnchorView = r5
            r7 = 0
            r9 = 0
            goto L_0x0182
        L_0x0150:
            r7 = 2
            int[] r9 = new int[r7]
            android.view.View r11 = r14.mAnchorView
            r11.getLocationOnScreen(r9)
            int[] r7 = new int[r7]
            r5.getLocationOnScreen(r7)
            int r11 = r14.mDropDownGravity
            r11 = r11 & 7
            if (r11 != r10) goto L_0x0177
            r11 = r9[r6]
            android.view.View r12 = r14.mAnchorView
            int r12 = r12.getWidth()
            int r12 = r12 + r11
            r9[r6] = r12
            r11 = r7[r6]
            int r12 = r5.getWidth()
            int r12 = r12 + r11
            r7[r6] = r12
        L_0x0177:
            r11 = r7[r6]
            r12 = r9[r6]
            int r11 = r11 - r12
            r7 = r7[r3]
            r9 = r9[r3]
            int r7 = r7 - r9
            r9 = r11
        L_0x0182:
            int r11 = r14.mDropDownGravity
            r11 = r11 & r10
            if (r11 != r10) goto L_0x018f
            if (r8 == 0) goto L_0x018a
            goto L_0x0195
        L_0x018a:
            int r2 = r5.getWidth()
            goto L_0x0197
        L_0x018f:
            if (r8 == 0) goto L_0x0197
            int r2 = r5.getWidth()
        L_0x0195:
            int r9 = r9 + r2
            goto L_0x0198
        L_0x0197:
            int r9 = r9 - r2
        L_0x0198:
            r4.mDropDownHorizontalOffset = r9
            r4.mOverlapAnchorSet = r3
            r4.mOverlapAnchor = r3
            r4.setVerticalOffset(r7)
            goto L_0x01c0
        L_0x01a2:
            boolean r2 = r14.mHasXOffset
            if (r2 == 0) goto L_0x01aa
            int r2 = r14.mXOffset
            r4.mDropDownHorizontalOffset = r2
        L_0x01aa:
            boolean r2 = r14.mHasYOffset
            if (r2 == 0) goto L_0x01b3
            int r2 = r14.mYOffset
            r4.setVerticalOffset(r2)
        L_0x01b3:
            android.graphics.Rect r2 = r14.mEpicenterBounds
            if (r2 == 0) goto L_0x01bd
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r2)
            goto L_0x01be
        L_0x01bd:
            r3 = 0
        L_0x01be:
            r4.mEpicenterBounds = r3
        L_0x01c0:
            androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo r2 = new androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo
            int r3 = r14.mLastPosition
            r2.<init>(r4, r15, r3)
            java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo> r3 = r14.mShowingMenus
            r3.add(r2)
            r4.show()
            androidx.appcompat.widget.DropDownListView r2 = r4.mDropDownList
            r2.setOnKeyListener(r14)
            if (r1 != 0) goto L_0x01fe
            boolean r1 = r14.mShowTitle
            if (r1 == 0) goto L_0x01fe
            java.lang.CharSequence r1 = r15.mHeaderTitle
            if (r1 == 0) goto L_0x01fe
            int r1 = androidx.appcompat.R$layout.abc_popup_menu_header_item_layout
            android.view.View r0 = r0.inflate(r1, r2, r6)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r1 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.setEnabled(r6)
            java.lang.CharSequence r15 = r15.mHeaderTitle
            r1.setText(r15)
            r15 = 0
            r2.addHeaderView(r0, r15, r6)
            r4.show()
        L_0x01fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.showMenu(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    public void updateMenuView(boolean z) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            ListAdapter adapter = cascadingMenuInfo.window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
