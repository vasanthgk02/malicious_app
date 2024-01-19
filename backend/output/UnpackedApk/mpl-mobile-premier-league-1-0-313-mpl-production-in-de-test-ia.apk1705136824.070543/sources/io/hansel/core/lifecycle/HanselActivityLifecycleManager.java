package io.hansel.core.lifecycle;

import io.hansel.core.logger.HSLLogger;

public class HanselActivityLifecycleManager {
    public static HanselActivityLifecycleManager sharedInstance;
    public boolean midTransition = true;

    public static HanselActivityLifecycleManager getInstance() {
        if (sharedInstance == null) {
            synchronized (HanselActivityLifecycleManager.class) {
                try {
                    if (sharedInstance == null) {
                        sharedInstance = new HanselActivityLifecycleManager();
                    }
                }
            }
        }
        return sharedInstance;
    }

    public synchronized boolean isMidTransition() {
        HSLLogger.d("HanselActivityLifecycleManager: isMidTransition method is invoked and value is " + this.midTransition);
        return this.midTransition;
    }

    public synchronized void onPause() {
        HSLLogger.d("HanselActivityLifecycleManager: onPause method is invoked.");
        this.midTransition = true;
    }

    public synchronized void onResume() {
        HSLLogger.d("HanselActivityLifecycleManager: onResume method is invoked.");
        this.midTransition = false;
    }
}
