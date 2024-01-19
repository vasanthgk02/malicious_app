package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.collection.ArraySet;
import androidx.collection.MapCollections.ArrayIterator;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {
    public static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = new ArraySet<>(0);
    public static final Object sActivityDelegatesLock = new Object();

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, null, appCompatCallback, activity);
    }

    public static void removeDelegateFromActives(AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            Iterator it = sActivityDelegates.iterator();
            while (true) {
                ArrayIterator arrayIterator = (ArrayIterator) it;
                if (arrayIterator.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) ((WeakReference) arrayIterator.next()).get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        arrayIterator.remove();
                    }
                }
            }
        }
    }

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(Callback callback);

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }
}
