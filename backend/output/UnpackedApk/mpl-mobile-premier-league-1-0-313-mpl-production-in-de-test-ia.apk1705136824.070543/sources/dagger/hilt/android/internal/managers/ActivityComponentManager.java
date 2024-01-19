package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;

public class ActivityComponentManager implements GeneratedComponentManager<Object> {
    public final Activity activity;
    public final GeneratedComponentManager<ActivityRetainedComponent> activityRetainedComponentManager;
    public volatile Object component;
    public final Object componentLock = new Object();

    public interface ActivityComponentBuilderEntryPoint {
        ActivityComponentBuilder activityComponentBuilder();
    }

    public ActivityComponentManager(Activity activity2) {
        this.activity = activity2;
        this.activityRetainedComponentManager = new ActivityRetainedComponentManager((ComponentActivity) activity2);
    }

    public Object createComponent() {
        if (this.activity.getApplication() instanceof GeneratedComponentManager) {
            return ((ActivityComponentBuilderEntryPoint) TweetUtils.get(this.activityRetainedComponentManager, ActivityComponentBuilderEntryPoint.class)).activityComponentBuilder().activity(this.activity).build();
        }
        if (Application.class.equals(this.activity.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
        outline73.append(this.activity.getApplication().getClass());
        throw new IllegalStateException(outline73.toString());
    }

    public Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                if (this.component == null) {
                    this.component = createComponent();
                }
            }
        }
        return this.component;
    }
}
