package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.widget.MenuPopupWindow;

public final class StandardMenuPopup extends MenuPopup implements OnDismissListener, OnItemClickListener, MenuPresenter, OnKeyListener {
    public static final int ITEM_LAYOUT = R$layout.abc_popup_menu_item_layout;
    public final MenuAdapter mAdapter;
    public View mAnchorView;
    public final OnAttachStateChangeListener mAttachStateChangeListener = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(standardMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public int mContentWidth;
    public final Context mContext;
    public int mDropDownGravity = 0;
    public final OnGlobalLayoutListener mGlobalLayoutListener = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing()) {
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                if (!standardMenuPopup.mPopup.mModal) {
                    View view = standardMenuPopup.mShownAnchorView;
                    if (view == null || !view.isShown()) {
                        StandardMenuPopup.this.dismiss();
                    } else {
                        StandardMenuPopup.this.mPopup.show();
                    }
                }
            }
        }
    };
    public boolean mHasContentWidth;
    public final MenuBuilder mMenu;
    public OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final MenuPopupWindow mPopup;
    public final int mPopupMaxWidth;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public Callback mPresenterCallback;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public ViewTreeObserver mTreeObserver;
    public boolean mWasDismissed;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = z;
        this.mAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.mOverflowOnly, ITEM_LAYOUT);
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuBuilder.addMenuPresenter(this, context);
    }

    public void addMenu(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.mPopup.mDropDownList;
    }

    public boolean isShowing() {
        return !this.mWasDismissed && this.mPopup.isShowing();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close(true);
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            androidx.appcompat.view.menu.MenuPopupHelper r0 = new androidx.appcompat.view.menu.MenuPopupHelper
            android.content.Context r3 = r9.mContext
            android.view.View r5 = r9.mShownAnchorView
            boolean r6 = r9.mOverflowOnly
            int r7 = r9.mPopupStyleAttr
            int r8 = r9.mPopupStyleRes
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            androidx.appcompat.view.menu.MenuPresenter$Callback r2 = r9.mPresenterCallback
            r0.setPresenterCallback(r2)
            boolean r2 = androidx.appcompat.view.menu.MenuPopup.shouldPreserveIconSpacing(r10)
            r0.mForceShowIcon = r2
            androidx.appcompat.view.menu.MenuPopup r3 = r0.mPopup
            if (r3 == 0) goto L_0x002a
            r3.setForceShowIcon(r2)
        L_0x002a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.mOnDismissListener
            r0.mOnDismissListener = r2
            r2 = 0
            r9.mOnDismissListener = r2
            androidx.appcompat.view.menu.MenuBuilder r2 = r9.mMenu
            r2.close(r1)
            androidx.appcompat.widget.MenuPopupWindow r2 = r9.mPopup
            int r3 = r2.mDropDownHorizontalOffset
            boolean r4 = r2.mDropDownVerticalOffsetSet
            if (r4 != 0) goto L_0x0040
            r2 = 0
            goto L_0x0042
        L_0x0040:
            int r2 = r2.mDropDownVerticalOffset
        L_0x0042:
            int r4 = r9.mDropDownGravity
            android.view.View r5 = r9.mAnchorView
            int r5 = androidx.core.view.ViewCompat.getLayoutDirection(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x005a
            android.view.View r4 = r9.mAnchorView
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L_0x005a:
            boolean r4 = r0.isShowing()
            r5 = 1
            if (r4 == 0) goto L_0x0062
            goto L_0x006b
        L_0x0062:
            android.view.View r4 = r0.mAnchorView
            if (r4 != 0) goto L_0x0068
            r0 = 0
            goto L_0x006c
        L_0x0068:
            r0.showPopup(r3, r2, r5, r5)
        L_0x006b:
            r0 = 1
        L_0x006c:
            if (r0 == 0) goto L_0x0076
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r9.mPresenterCallback
            if (r0 == 0) goto L_0x0075
            r0.onOpenSubMenu(r10)
        L_0x0075:
            return r5
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.StandardMenuPopup.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean z) {
        this.mAdapter.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setHorizontalOffset(int i) {
        this.mPopup.mDropDownHorizontalOffset = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    public void setVerticalOffset(int i) {
        MenuPopupWindow menuPopupWindow = this.mPopup;
        menuPopupWindow.mDropDownVerticalOffset = i;
        menuPopupWindow.mDropDownVerticalOffsetSet = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show() {
        /*
            r7 = this;
            boolean r0 = r7.isShowing()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000b
        L_0x0008:
            r1 = 1
            goto L_0x00c6
        L_0x000b:
            boolean r0 = r7.mWasDismissed
            if (r0 != 0) goto L_0x00c6
            android.view.View r0 = r7.mAnchorView
            if (r0 != 0) goto L_0x0015
            goto L_0x00c6
        L_0x0015:
            r7.mShownAnchorView = r0
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            android.widget.PopupWindow r0 = r0.mPopup
            r0.setOnDismissListener(r7)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            r0.mItemClickListener = r7
            r0.setModal(r2)
            android.view.View r0 = r7.mShownAnchorView
            android.view.ViewTreeObserver r3 = r7.mTreeObserver
            if (r3 != 0) goto L_0x002d
            r3 = 1
            goto L_0x002e
        L_0x002d:
            r3 = 0
        L_0x002e:
            android.view.ViewTreeObserver r4 = r0.getViewTreeObserver()
            r7.mTreeObserver = r4
            if (r3 == 0) goto L_0x003b
            android.view.ViewTreeObserver$OnGlobalLayoutListener r3 = r7.mGlobalLayoutListener
            r4.addOnGlobalLayoutListener(r3)
        L_0x003b:
            android.view.View$OnAttachStateChangeListener r3 = r7.mAttachStateChangeListener
            r0.addOnAttachStateChangeListener(r3)
            androidx.appcompat.widget.MenuPopupWindow r3 = r7.mPopup
            r3.mDropDownAnchorView = r0
            int r0 = r7.mDropDownGravity
            r3.mDropDownGravity = r0
            boolean r0 = r7.mHasContentWidth
            r3 = 0
            if (r0 != 0) goto L_0x005b
            androidx.appcompat.view.menu.MenuAdapter r0 = r7.mAdapter
            android.content.Context r4 = r7.mContext
            int r5 = r7.mPopupMaxWidth
            int r0 = androidx.appcompat.view.menu.MenuPopup.measureIndividualMenuWidth(r0, r3, r4, r5)
            r7.mContentWidth = r0
            r7.mHasContentWidth = r2
        L_0x005b:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            int r4 = r7.mContentWidth
            r0.setContentWidth(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            r4 = 2
            android.widget.PopupWindow r0 = r0.mPopup
            r0.setInputMethodMode(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            android.graphics.Rect r4 = r7.mEpicenterBounds
            if (r0 == 0) goto L_0x00c5
            if (r4 == 0) goto L_0x0078
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>(r4)
            goto L_0x0079
        L_0x0078:
            r5 = r3
        L_0x0079:
            r0.mEpicenterBounds = r5
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            r0.show()
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            androidx.appcompat.widget.DropDownListView r0 = r0.mDropDownList
            r0.setOnKeyListener(r7)
            boolean r4 = r7.mShowTitle
            if (r4 == 0) goto L_0x00b7
            androidx.appcompat.view.menu.MenuBuilder r4 = r7.mMenu
            java.lang.CharSequence r4 = r4.mHeaderTitle
            if (r4 == 0) goto L_0x00b7
            android.content.Context r4 = r7.mContext
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r5 = androidx.appcompat.R$layout.abc_popup_menu_header_item_layout
            android.view.View r4 = r4.inflate(r5, r0, r1)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00b1
            androidx.appcompat.view.menu.MenuBuilder r6 = r7.mMenu
            java.lang.CharSequence r6 = r6.mHeaderTitle
            r5.setText(r6)
        L_0x00b1:
            r4.setEnabled(r1)
            r0.addHeaderView(r4, r3, r1)
        L_0x00b7:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            androidx.appcompat.view.menu.MenuAdapter r1 = r7.mAdapter
            r0.setAdapter(r1)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.mPopup
            r0.show()
            goto L_0x0008
        L_0x00c5:
            throw r3
        L_0x00c6:
            if (r1 == 0) goto L_0x00c9
            return
        L_0x00c9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "StandardMenuPopup cannot be used without an anchor"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.StandardMenuPopup.show():void");
    }

    public void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
