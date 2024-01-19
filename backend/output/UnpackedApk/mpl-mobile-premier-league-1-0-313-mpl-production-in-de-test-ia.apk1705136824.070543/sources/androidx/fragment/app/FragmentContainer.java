package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class FragmentContainer {
    @Deprecated
    public Fragment instantiate(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract View onFindViewById(int i);

    public abstract boolean onHasView();
}
