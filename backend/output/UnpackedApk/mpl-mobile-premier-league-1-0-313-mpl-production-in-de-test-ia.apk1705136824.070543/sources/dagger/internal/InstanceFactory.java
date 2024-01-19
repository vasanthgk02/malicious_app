package dagger.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;

public final class InstanceFactory<T> implements Factory<T> {
    public final T instance;

    public InstanceFactory(T t) {
        this.instance = t;
    }

    public static <T> Factory<T> create(T t) {
        TweetUtils.checkNotNull1(t, "instance cannot be null");
        return new InstanceFactory(t);
    }

    public T get() {
        return this.instance;
    }
}
