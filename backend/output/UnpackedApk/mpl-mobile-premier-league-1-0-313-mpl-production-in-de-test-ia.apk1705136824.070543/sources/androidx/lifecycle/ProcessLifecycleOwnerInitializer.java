package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleDispatcher.DispatcherActivityCallback;

public class ProcessLifecycleOwnerInitializer extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (!LifecycleDispatcher.sInitialized.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
        Context context2 = getContext();
        ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.sInstance;
        if (processLifecycleOwner != null) {
            processLifecycleOwner.mHandler = new Handler();
            processLifecycleOwner.mRegistry.handleLifecycleEvent(Event.ON_CREATE);
            ((Application) context2.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (VERSION.SDK_INT < 29) {
                        ReportFragment.get(activity).mProcessListener = ProcessLifecycleOwner.this.mInitializationListener;
                    }
                }

                public void onActivityPaused(Activity activity) {
                    ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
                    int i = processLifecycleOwner.mResumedCounter - 1;
                    processLifecycleOwner.mResumedCounter = i;
                    if (i == 0) {
                        processLifecycleOwner.mHandler.postDelayed(processLifecycleOwner.mDelayedPauseRunnable, 700);
                    }
                }

                public void onActivityPreCreated(Activity activity, Bundle bundle) {
                    activity.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
                        public void onActivityPostResumed(Activity activity) {
                            ProcessLifecycleOwner.this.activityResumed();
                        }

                        public void onActivityPostStarted(Activity activity) {
                            ProcessLifecycleOwner.this.activityStarted();
                        }
                    });
                }

                public void onActivityStopped(Activity activity) {
                    ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
                    int i = processLifecycleOwner.mStartedCounter - 1;
                    processLifecycleOwner.mStartedCounter = i;
                    if (i == 0 && processLifecycleOwner.mPauseSent) {
                        processLifecycleOwner.mRegistry.handleLifecycleEvent(Event.ON_STOP);
                        processLifecycleOwner.mStopSent = true;
                    }
                }
            });
            return true;
        }
        throw null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
