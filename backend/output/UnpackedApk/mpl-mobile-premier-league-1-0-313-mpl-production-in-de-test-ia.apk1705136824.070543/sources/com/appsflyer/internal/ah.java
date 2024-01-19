package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

public final class ah {
    public static e AFInAppEventParameterName = null;
    public static long valueOf = 500;

    public interface e {
        void valueOf(Activity activity);

        void valueOf(Context context);
    }

    public static void AFKeystoreWrapper(Context context, e eVar, final Executor executor) {
        AFInAppEventParameterName = eVar;
        AnonymousClass4 r1 = new ActivityLifecycleCallbacks() {
            public boolean AFInAppEventParameterName = true;
            public boolean valueOf;

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                executor.execute(new Runnable() {
                    public final void run() {
                        f.valueOf();
                        Intent intent = activity.getIntent();
                        if (f.AFKeystoreWrapper(intent) != null && intent != f.valueOf) {
                            f.valueOf = intent;
                        }
                    }
                });
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivityPaused(final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        AnonymousClass4.this.AFInAppEventParameterName = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    AnonymousClass4 r0 = AnonymousClass4.this;
                                    if (r0.valueOf && r0.AFInAppEventParameterName) {
                                        r0.valueOf = false;
                                        try {
                                            ah.AFInAppEventParameterName.valueOf(applicationContext);
                                        } catch (Exception e2) {
                                            AFLogger.valueOf("Listener threw exception! ", e2);
                                        }
                                    }
                                }
                            }, ah.valueOf);
                        } catch (Throwable th) {
                            AFLogger.valueOf("Background task failed with a throwable: ", th);
                        }
                    }
                });
            }

            public final void onActivityResumed(final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        if (!AnonymousClass4.this.valueOf) {
                            try {
                                ah.AFInAppEventParameterName.valueOf(activity);
                            } catch (Exception e2) {
                                AFLogger.AFInAppEventParameterName((String) "Listener thrown an exception: ", (Throwable) e2);
                            }
                        }
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        r0.AFInAppEventParameterName = false;
                        r0.valueOf = true;
                    }
                });
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }
        };
        if (context instanceof Activity) {
            r1.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r1);
    }
}
