package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper {
    public View mAnchorView;
    public final Context mContext;
    public int mDropDownGravity = 8388611;
    public boolean mForceShowIcon;
    public final OnDismissListener mInternalOnDismissListener = new OnDismissListener() {
        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    };
    public final MenuBuilder mMenu;
    public OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public MenuPopup mPopup;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [androidx.appcompat.view.menu.MenuPopup, androidx.appcompat.view.menu.MenuPresenter] */
    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.appcompat.view.menu.StandardMenuPopup] */
    /* JADX WARNING: type inference failed for: r1v12, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.StandardMenuPopup] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v1, types: [androidx.appcompat.view.menu.StandardMenuPopup]
      assigns: [androidx.appcompat.view.menu.StandardMenuPopup, androidx.appcompat.view.menu.CascadingMenuPopup]
      uses: [androidx.appcompat.view.menu.StandardMenuPopup, androidx.appcompat.view.menu.MenuPopup, androidx.appcompat.view.menu.MenuPresenter, androidx.appcompat.view.menu.CascadingMenuPopup]
      mth insns count: 49
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.menu.MenuPopup getPopup() {
        /*
            r14 = this;
            androidx.appcompat.view.menu.MenuPopup r0 = r14.mPopup
            if (r0 != 0) goto L_0x0078
            android.content.Context r0 = r14.mContext
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            r0.getRealSize(r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.mContext
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0046
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r2 = r14.mContext
            android.view.View r3 = r14.mAnchorView
            int r4 = r14.mPopupStyleAttr
            int r5 = r14.mPopupStyleRes
            boolean r6 = r14.mOverflowOnly
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0058
        L_0x0046:
            androidx.appcompat.view.menu.StandardMenuPopup r0 = new androidx.appcompat.view.menu.StandardMenuPopup
            android.content.Context r8 = r14.mContext
            androidx.appcompat.view.menu.MenuBuilder r9 = r14.mMenu
            android.view.View r10 = r14.mAnchorView
            int r11 = r14.mPopupStyleAttr
            int r12 = r14.mPopupStyleRes
            boolean r13 = r14.mOverflowOnly
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0058:
            androidx.appcompat.view.menu.MenuBuilder r1 = r14.mMenu
            r0.addMenu(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.mInternalOnDismissListener
            r0.setOnDismissListener(r1)
            android.view.View r1 = r14.mAnchorView
            r0.setAnchorView(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r14.mPresenterCallback
            r0.setCallback(r1)
            boolean r1 = r14.mForceShowIcon
            r0.setForceShowIcon(r1)
            int r1 = r14.mDropDownGravity
            r0.setGravity(r1)
            r14.mPopup = r0
        L_0x0078:
            androidx.appcompat.view.menu.MenuPopup r0 = r14.mPopup
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.getPopup():androidx.appcompat.view.menu.MenuPopup");
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setPresenterCallback(Callback callback) {
        this.mPresenterCallback = callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public final void showPopup(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.mEpicenterBounds = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        popup.show();
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }
}
