package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS.ActionProviderWrapper;
import androidx.appcompat.widget.ActionMenuPresenter;

public abstract class ActionProvider {
    public final Context mContext;
    public SubUiVisibilityListener mSubUiVisibilityListener;
    public VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
    }

    public interface VisibilityListener {
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public boolean isVisible() {
        return true;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return ((ActionProviderWrapper) this).mInner.onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.mVisibilityListener != null) {
            getClass().getSimpleName();
        }
        this.mVisibilityListener = visibilityListener;
    }

    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            ((ActionMenuPresenter) subUiVisibilityListener).onSubUiVisibilityChanged(z);
        }
    }
}
