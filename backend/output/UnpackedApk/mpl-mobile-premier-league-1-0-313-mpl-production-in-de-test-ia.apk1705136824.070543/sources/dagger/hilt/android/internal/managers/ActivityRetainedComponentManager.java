package dagger.hilt.android.internal.managers;

import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ActivityRetainedLifecycle.OnClearedListener;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;
import java.util.HashSet;
import java.util.Set;

public final class ActivityRetainedComponentManager implements GeneratedComponentManager<ActivityRetainedComponent> {
    public volatile ActivityRetainedComponent component;
    public final Object componentLock = new Object();
    public final ViewModelProvider viewModelProvider;

    public interface ActivityRetainedComponentBuilderEntryPoint {
        ActivityRetainedComponentBuilder retainedComponentBuilder();
    }

    public static final class ActivityRetainedComponentViewModel extends ViewModel {
        public final ActivityRetainedComponent component;

        public ActivityRetainedComponentViewModel(ActivityRetainedComponent activityRetainedComponent) {
            this.component = activityRetainedComponent;
        }

        public void onCleared() {
            super.onCleared();
            Lifecycle lifecycle = (Lifecycle) ((ActivityRetainedLifecycleEntryPoint) TweetUtils.get(this.component, ActivityRetainedLifecycleEntryPoint.class)).getActivityRetainedLifecycle();
            if (lifecycle != null) {
                if (TweetUtils.mainThread == null) {
                    TweetUtils.mainThread = Looper.getMainLooper().getThread();
                }
                if (Thread.currentThread() == TweetUtils.mainThread) {
                    for (OnClearedListener onCleared : lifecycle.listeners) {
                        onCleared.onCleared();
                    }
                    return;
                }
                throw new IllegalStateException("Must be called on the Main thread.");
            }
            throw null;
        }
    }

    public interface ActivityRetainedLifecycleEntryPoint {
        ActivityRetainedLifecycle getActivityRetainedLifecycle();
    }

    public static final class Lifecycle implements ActivityRetainedLifecycle {
        public final Set<OnClearedListener> listeners = new HashSet();
    }

    public ActivityRetainedComponentManager(final ComponentActivity componentActivity) {
        this.viewModelProvider = new ViewModelProvider(componentActivity.getViewModelStore(), new Factory(this) {
            public <T extends ViewModel> T create(Class<T> cls) {
                return new ActivityRetainedComponentViewModel(((ActivityRetainedComponentBuilderEntryPoint) TweetUtils.fromApplication(componentActivity, ActivityRetainedComponentBuilderEntryPoint.class)).retainedComponentBuilder().build());
            }
        });
    }

    public Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                if (this.component == null) {
                    this.component = ((ActivityRetainedComponentViewModel) this.viewModelProvider.get(ActivityRetainedComponentViewModel.class)).component;
                }
            }
        }
        return this.component;
    }
}
