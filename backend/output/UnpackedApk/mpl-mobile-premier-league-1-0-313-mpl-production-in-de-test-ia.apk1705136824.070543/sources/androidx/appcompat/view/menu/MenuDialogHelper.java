package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuPresenter.MenuAdapter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;

public class MenuDialogHelper implements OnKeyListener, OnClickListener, OnDismissListener, Callback {
    public AlertDialog mDialog;
    public MenuBuilder mMenu;
    public ListMenuPresenter mPresenter;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.mMenu.performItemAction(((MenuAdapter) this.mPresenter.getAdapter()).getItem(i), 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.mMenu) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        ListMenuPresenter listMenuPresenter = this.mPresenter;
        MenuBuilder menuBuilder = this.mMenu;
        Callback callback = listMenuPresenter.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.mDialog.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.mDialog.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.mMenu.close(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.mMenu.performShortcut(i, keyEvent, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return false;
    }
}
