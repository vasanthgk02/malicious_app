package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.squareup.picasso.Utils;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.ISpan;
import io.sentry.ITransaction;
import io.sentry.Integration;
import io.sentry.Scope;
import io.sentry.Scope.IWithTransaction;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import org.jetbrains.annotations.VisibleForTesting;

public final class ActivityLifecycleIntegration implements Integration, Closeable, ActivityLifecycleCallbacks {
    public static final String APP_START_COLD = "app.start.cold";
    public static final String APP_START_WARM = "app.start.warm";
    public static final String UI_LOAD_OP = "ui.load";
    public final WeakHashMap<Activity, ITransaction> activitiesWithOngoingTransactions = new WeakHashMap<>();
    public ISpan appStartSpan;
    public final Application application;
    public boolean firstActivityCreated = false;
    public boolean firstActivityResumed = false;
    public IHub hub;
    public boolean isAllActivityCallbacksAvailable;
    public SentryAndroidOptions options;
    public boolean performanceEnabled = false;

    public ActivityLifecycleIntegration(Application application2, IBuildInfoProvider iBuildInfoProvider) {
        this.application = (Application) Objects.requireNonNull(application2, "Application is required");
        Objects.requireNonNull(iBuildInfoProvider, "BuildInfoProvider is required");
        if (iBuildInfoProvider.getSdkInfoVersion() >= 29) {
            this.isAllActivityCallbacksAvailable = true;
        }
    }

    private void addBreadcrumb(Activity activity, String str) {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null && this.hub != null && sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setData("screen", getActivityName(activity));
            breadcrumb.setCategory("ui.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    private void finishTransaction(ITransaction iTransaction) {
        if (iTransaction != null) {
            SpanStatus status = iTransaction.getStatus();
            if (status == null) {
                status = SpanStatus.OK;
            }
            iTransaction.finish(status);
        }
    }

    private String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private String getAppStartDesc() {
        return AppStartState.getInstance().isColdStart() ? "Cold Start" : "Warm Start";
    }

    private String getAppStartOp() {
        return AppStartState.getInstance().isColdStart() ? APP_START_COLD : APP_START_WARM;
    }

    private boolean isPerformanceEnabled(SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    private boolean isRunningTransaction(Activity activity) {
        return this.activitiesWithOngoingTransactions.containsKey(activity);
    }

    private void setColdStart(Bundle bundle) {
        if (!this.firstActivityCreated && this.performanceEnabled) {
            AppStartState.getInstance().setColdStart(bundle == null);
        }
    }

    private void startTracing(Activity activity) {
        ITransaction iTransaction;
        if (this.performanceEnabled && !isRunningTransaction(activity) && this.hub != null) {
            stopPreviousTransactions();
            String activityName = getActivityName(activity);
            Date appStartTime = AppStartState.getInstance().getAppStartTime();
            if (this.firstActivityCreated || appStartTime == null) {
                iTransaction = this.hub.startTransaction(activityName, (String) UI_LOAD_OP, (Date) null, true);
            } else {
                iTransaction = this.hub.startTransaction(activityName, (String) UI_LOAD_OP, appStartTime, true);
                this.appStartSpan = iTransaction.startChild(getAppStartOp(), getAppStartDesc(), appStartTime);
            }
            this.hub.configureScope(new ScopeCallback(iTransaction) {
                public final /* synthetic */ ITransaction f$1;

                {
                    this.f$1 = r2;
                }

                public final void run(Scope scope) {
                    ActivityLifecycleIntegration.this.lambda$startTracing$0$ActivityLifecycleIntegration(this.f$1, scope);
                }
            });
            this.activitiesWithOngoingTransactions.put(activity, iTransaction);
        }
    }

    private void stopPreviousTransactions() {
        for (Entry<Activity, ITransaction> value : this.activitiesWithOngoingTransactions.entrySet()) {
            finishTransaction((ITransaction) value.getValue());
        }
    }

    private void stopTracing(Activity activity, boolean z) {
        if (this.performanceEnabled && z) {
            finishTransaction(this.activitiesWithOngoingTransactions.get(activity));
        }
    }

    @VisibleForTesting
    /* renamed from: applyScope */
    public void lambda$startTracing$0$ActivityLifecycleIntegration(Scope scope, ITransaction iTransaction) {
        scope.withTransaction(new IWithTransaction(scope, iTransaction) {
            public final /* synthetic */ Scope f$1;
            public final /* synthetic */ ITransaction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(ITransaction iTransaction) {
                ActivityLifecycleIntegration.this.lambda$applyScope$1$ActivityLifecycleIntegration(this.f$1, this.f$2, iTransaction);
            }
        });
    }

    public void close() throws IOException {
        this.application.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "ActivityLifecycleIntegration removed.", new Object[0]);
        }
    }

    public WeakHashMap<Activity, ITransaction> getActivitiesWithOngoingTransactions() {
        return this.activitiesWithOngoingTransactions;
    }

    public /* synthetic */ void lambda$applyScope$1$ActivityLifecycleIntegration(Scope scope, ITransaction iTransaction, ITransaction iTransaction2) {
        if (iTransaction2 == null) {
            scope.setTransaction(iTransaction);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction.getName());
        }
    }

    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.isAllActivityCallbacksAvailable) {
            setColdStart(bundle);
        }
        addBreadcrumb(activity, Utils.VERB_CREATED);
        if (!this.isAllActivityCallbacksAvailable) {
            startTracing(activity);
        }
        this.firstActivityCreated = true;
    }

    public synchronized void onActivityDestroyed(Activity activity) {
        addBreadcrumb(activity, "destroyed");
        stopTracing(activity, true);
        if (this.performanceEnabled) {
            this.activitiesWithOngoingTransactions.remove(activity);
        }
    }

    public synchronized void onActivityPaused(Activity activity) {
        addBreadcrumb(activity, "paused");
    }

    public synchronized void onActivityPostResumed(Activity activity) {
        if (this.isAllActivityCallbacksAvailable && this.options != null) {
            stopTracing(activity, this.options.isEnableActivityLifecycleTracingAutoFinish());
        }
    }

    public synchronized void onActivityPreCreated(Activity activity, Bundle bundle) {
        if (this.isAllActivityCallbacksAvailable) {
            setColdStart(bundle);
            startTracing(activity);
        }
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (!this.firstActivityResumed && this.performanceEnabled) {
            AppStartState.getInstance().setAppStartEnd();
            if (this.appStartSpan != null) {
                this.appStartSpan.finish();
            }
            this.firstActivityResumed = true;
        }
        addBreadcrumb(activity, Utils.VERB_RESUMED);
        if (!this.isAllActivityCallbacksAvailable && this.options != null) {
            stopTracing(activity, this.options.isEnableActivityLifecycleTracingAutoFinish());
        }
    }

    public synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        addBreadcrumb(activity, "saveInstanceState");
    }

    public synchronized void onActivityStarted(Activity activity) {
        addBreadcrumb(activity, "started");
    }

    public synchronized void onActivityStopped(Activity activity) {
        addBreadcrumb(activity, "stopped");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "ActivityLifecycleIntegration enabled: %s", Boolean.valueOf(this.options.isEnableActivityLifecycleBreadcrumbs()));
        this.performanceEnabled = isPerformanceEnabled(this.options);
        if (this.options.isEnableActivityLifecycleBreadcrumbs() || this.performanceEnabled) {
            this.application.registerActivityLifecycleCallbacks(this);
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "ActivityLifecycleIntegration installed.", new Object[0]);
        }
    }
}
