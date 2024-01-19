package dagger.hilt.android.internal.managers;

import androidx.fragment.app.Fragment;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.internal.GeneratedComponentManager;

public class FragmentComponentManager implements GeneratedComponentManager<Object> {
    public volatile Object component;
    public final Object componentLock = new Object();
    public final Fragment fragment;

    public interface FragmentComponentBuilderEntryPoint {
        FragmentComponentBuilder fragmentComponentBuilder();
    }

    public FragmentComponentManager(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public final Object createComponent() {
        if (this.fragment.getHost() != null) {
            TweetUtils.checkState(this.fragment.getHost() instanceof GeneratedComponentManager, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.fragment.getHost().getClass());
            return ((FragmentComponentBuilderEntryPoint) TweetUtils.get(this.fragment.getHost(), FragmentComponentBuilderEntryPoint.class)).fragmentComponentBuilder().fragment(this.fragment).build();
        }
        throw new NullPointerException("Hilt Fragments must be attached before creating the component.");
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
