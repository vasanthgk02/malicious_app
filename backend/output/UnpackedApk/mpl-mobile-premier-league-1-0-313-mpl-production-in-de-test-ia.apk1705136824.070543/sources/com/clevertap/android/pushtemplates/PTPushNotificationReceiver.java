package com.clevertap.android.pushtemplates;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationReceiver;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.mpl.androidapp.MPLApplicationLifeCycleCallback;
import java.util.concurrent.Callable;

public class PTPushNotificationReceiver extends CTPushNotificationReceiver {
    public void onReceive(final Context context, final Intent intent) {
        if (intent.getStringExtra("wzrk_dl") == null) {
            intent.removeExtra("wzrk_dl");
        }
        super.onReceive(context, intent);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            CleverTapAPI fromAccountId = CleverTapAPI.fromAccountId(context, extras.getString(MPLApplicationLifeCycleCallback.WZRK_ACCT_ID_KEY));
            if (fromAccountId != null) {
                try {
                    Task postAsyncSafelyTask = CTExecutorFactory.executors(fromAccountId.coreState.config).postAsyncSafelyTask();
                    postAsyncSafelyTask.executor.execute(new Runnable("PTPushNotificationReceiver#cleanUpFiles", new Callable<Void>(this) {
                        public Object call() throws Exception {
                            try {
                                k.deleteImageFromStorage(context, intent);
                                k.deleteSilentNotificationChannel(context);
                            } catch (Throwable th) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't clean up images and/or couldn't delete silent notification channel: ");
                                outline73.append(th.getLocalizedMessage());
                                k.verbose(outline73.toString());
                            }
                            return null;
                        }
                    }) {
                        public final /* synthetic */ Callable val$callable;
                        public final /* synthetic */ String val$logTag;

                        {
                            this.val$logTag = r2;
                            this.val$callable = r3;
                        }

                        public void run() {
                            try {
                                Logger logger = Task.this.config.getLogger();
                                logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                                TResult call = this.val$callable.call();
                                Logger logger2 = Task.this.config.getLogger();
                                logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                                Task task = Task.this;
                                if (task != null) {
                                    STATE state = STATE.SUCCESS;
                                    task.result = call;
                                    for (SuccessExecutable<TResult> execute : task.successExecutables) {
                                        execute.execute(task.result);
                                    }
                                    return;
                                }
                                throw null;
                            } catch (Exception e2) {
                                Task task2 = Task.this;
                                if (task2 != null) {
                                    STATE state2 = STATE.FAILED;
                                    for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                                        execute2.execute(e2);
                                    }
                                    Logger logger3 = Task.this.config.getLogger();
                                    logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                                    e2.printStackTrace();
                                    return;
                                }
                                throw null;
                            }
                        }
                    });
                } catch (Exception e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't clean up images and/or couldn't delete silent notification channel: ");
                    outline73.append(e2.getLocalizedMessage());
                    k.verbose(outline73.toString());
                }
            } else {
                k.verbose("clevertap instance is null, not running PTPushNotificationReceiver#cleanUpFiles");
            }
        }
    }
}
