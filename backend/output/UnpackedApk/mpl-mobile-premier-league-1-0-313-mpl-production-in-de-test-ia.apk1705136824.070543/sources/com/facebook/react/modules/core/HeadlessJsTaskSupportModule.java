package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public static final String NAME = "HeadlessJsTaskSupport";

    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    public void notifyTaskFinished(double d2) {
        int i = (int) d2;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (instance.isTaskRunning(i)) {
            instance.finishTask(i);
            return;
        }
        FLog.w(HeadlessJsTaskSupportModule.class, (String) "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i));
    }

    public void notifyTaskRetry(double d2, Promise promise) {
        int i = (int) d2;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        boolean z = false;
        if (instance.isTaskRunning(i)) {
            synchronized (instance) {
                HeadlessJsTaskConfig headlessJsTaskConfig = instance.mActiveTaskConfigs.get(Integer.valueOf(i));
                boolean z2 = headlessJsTaskConfig != null;
                ImageOriginUtils.assertCondition(z2, "Tried to retrieve non-existent task config with id " + i + ".");
                HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy = headlessJsTaskConfig.mRetryPolicy;
                if (headlessJsTaskRetryPolicy.canRetry()) {
                    Runnable runnable = instance.mTaskTimeouts.get(i);
                    if (runnable != null) {
                        instance.mHandler.removeCallbacks(runnable);
                        instance.mTaskTimeouts.remove(i);
                    }
                    HeadlessJsTaskConfig headlessJsTaskConfig2 = new HeadlessJsTaskConfig(headlessJsTaskConfig.mTaskKey, headlessJsTaskConfig.mData, headlessJsTaskConfig.mTimeout, headlessJsTaskConfig.mAllowedInForeground, headlessJsTaskRetryPolicy.update());
                    UiThreadUtil.runOnUiThread(new Runnable(headlessJsTaskConfig2, i) {
                        public final /* synthetic */ HeadlessJsTaskConfig val$taskConfig;
                        public final /* synthetic */ int val$taskId;

                        {
                            this.val$taskConfig = r2;
                            this.val$taskId = r3;
                        }

                        public void run() {
                            HeadlessJsTaskContext.this.startTask(this.val$taskConfig, this.val$taskId);
                        }
                    }, (long) headlessJsTaskRetryPolicy.getDelay());
                    z = true;
                }
            }
            promise.resolve(Boolean.valueOf(z));
            return;
        }
        FLog.w(HeadlessJsTaskSupportModule.class, (String) "Tried to retry non-active task with id %d. Did it time out?", Integer.valueOf(i));
        promise.resolve(Boolean.FALSE);
    }
}
