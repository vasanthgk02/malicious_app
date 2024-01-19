package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle.Event;

public class ReportFragment extends Fragment {
    public ActivityInitializationListener mProcessListener;

    public interface ActivityInitializationListener {
    }

    public static class LifecycleCallbacks implements ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ReportFragment.dispatch(activity, Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            ReportFragment.dispatch(activity, Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            ReportFragment.dispatch(activity, Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            ReportFragment.dispatch(activity, Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            ReportFragment.dispatch(activity, Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            ReportFragment.dispatch(activity, Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void dispatch(Activity activity, Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            LifecycleRegistry lifecycle = ((LifecycleRegistryOwner) activity).getLifecycle();
            lifecycle.enforceMainThreadIfNeeded("handleLifecycleEvent");
            lifecycle.moveToState(event.getTargetState());
            return;
        }
        if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle2 = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle2 instanceof LifecycleRegistry) {
                LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle2;
                lifecycleRegistry.enforceMainThreadIfNeeded("handleLifecycleEvent");
                lifecycleRegistry.moveToState(event.getTargetState());
            }
        }
    }

    public static ReportFragment get(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void injectIfNeededIn(Activity activity) {
        if (VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatch(Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        dispatch(Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    public void onPause() {
        super.onPause();
        dispatch(Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        ActivityInitializationListener activityInitializationListener = this.mProcessListener;
        if (activityInitializationListener != null) {
            ProcessLifecycleOwner.this.activityResumed();
        }
        dispatch(Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        ActivityInitializationListener activityInitializationListener = this.mProcessListener;
        if (activityInitializationListener != null) {
            ProcessLifecycleOwner.this.activityStarted();
        }
        dispatch(Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        dispatch(Event.ON_STOP);
    }

    public final void dispatch(Event event) {
        if (VERSION.SDK_INT < 29) {
            dispatch(getActivity(), event);
        }
    }
}
