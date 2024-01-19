package in.juspay.hypersdk.mystique;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

public class SecureActionCallback implements Callback {
    public boolean disableCopy = false;
    public boolean disableCut = false;
    public boolean disablePaste = false;
    public boolean disableShare = false;

    public SecureActionCallback(boolean z, boolean z2, boolean z3, boolean z4) {
        this.disableCopy = z;
        this.disableCut = z2;
        this.disableShare = z3;
        this.disablePaste = z4;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return true;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.disableCopy) {
            menu.removeItem(16908321);
        }
        if (this.disableCut) {
            menu.removeItem(16908320);
        }
        if (this.disableShare) {
            menu.removeItem(16908341);
        }
        if (this.disablePaste) {
            menu.removeItem(16908322);
        }
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (this.disableCopy) {
            menu.removeItem(16908321);
        }
        if (this.disableCut) {
            menu.removeItem(16908320);
        }
        if (this.disableShare) {
            menu.removeItem(16908341);
        }
        if (this.disablePaste) {
            menu.removeItem(16908322);
        }
        return true;
    }
}
