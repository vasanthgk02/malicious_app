package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.HashMap;
import java.util.Map;

public class DelayedWorkTracker {
    public static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    public final GreedyScheduler mGreedyScheduler;
    public final DefaultRunnableScheduler mRunnableScheduler;
    public final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, DefaultRunnableScheduler defaultRunnableScheduler) {
        this.mGreedyScheduler = greedyScheduler;
        this.mRunnableScheduler = defaultRunnableScheduler;
    }
}
