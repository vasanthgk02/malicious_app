package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;
import com.android.tools.r8.GeneratedOutlineSupport;

@Name("dialog")
public final class DialogFragmentNavigator extends Navigator<Destination> {
    public final Context mContext;
    public int mDialogCount = 0;
    public final FragmentManager mFragmentManager;
    public LifecycleEventObserver mObserver = new LifecycleEventObserver(this) {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            if (event == Event.ON_STOP) {
                DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
                if (!dialogFragment.requireDialog().isShowing()) {
                    NavHostFragment.findNavController(dialogFragment).popBackStack();
                }
            }
        }
    };

    public static class Destination extends NavDestination implements FloatingWindow {
        public String mClassName;

        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                this.mClassName = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
    }

    public NavDestination createDestination() {
        return new Destination(this);
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
        Destination destination = (Destination) navDestination;
        if (this.mFragmentManager.isStateSaved()) {
            return null;
        }
        String str = destination.mClassName;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.mContext.getPackageName() + str;
            }
            Fragment instantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), str);
            if (!DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dialog destination ");
                String str2 = destination.mClassName;
                if (str2 != null) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline62(outline73, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            DialogFragment dialogFragment = (DialogFragment) instantiate;
            dialogFragment.setArguments(bundle);
            dialogFragment.getLifecycle().addObserver(this.mObserver);
            FragmentManager fragmentManager = this.mFragmentManager;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("androidx-nav-fragment:navigator:dialog:");
            int i = this.mDialogCount;
            this.mDialogCount = i + 1;
            outline732.append(i);
            dialogFragment.show(fragmentManager, outline732.toString());
            return destination;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    public void onRestoreState(Bundle bundle) {
        int i = 0;
        this.mDialogCount = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        while (i < this.mDialogCount) {
            FragmentManager fragmentManager = this.mFragmentManager;
            DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("androidx-nav-fragment:navigator:dialog:" + i);
            if (dialogFragment != null) {
                dialogFragment.getLifecycle().addObserver(this.mObserver);
                i++;
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline42("DialogFragment ", i, " doesn't exist in the FragmentManager"));
            }
        }
    }

    public Bundle onSaveState() {
        if (this.mDialogCount == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.mDialogCount);
        return bundle;
    }

    public boolean popBackStack() {
        if (this.mDialogCount == 0 || this.mFragmentManager.isStateSaved()) {
            return false;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("androidx-nav-fragment:navigator:dialog:");
        int i = this.mDialogCount - 1;
        this.mDialogCount = i;
        outline73.append(i);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(outline73.toString());
        if (findFragmentByTag != null) {
            findFragmentByTag.getLifecycle().removeObserver(this.mObserver);
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        return true;
    }
}
