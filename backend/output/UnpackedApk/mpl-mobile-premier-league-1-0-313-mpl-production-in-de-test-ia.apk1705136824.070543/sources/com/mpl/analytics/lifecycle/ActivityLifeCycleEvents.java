package com.mpl.analytics.lifecycle;

import android.app.Activity;

public interface ActivityLifeCycleEvents {
    void activityPaused(Activity activity);

    void activityResumed(Activity activity);
}
