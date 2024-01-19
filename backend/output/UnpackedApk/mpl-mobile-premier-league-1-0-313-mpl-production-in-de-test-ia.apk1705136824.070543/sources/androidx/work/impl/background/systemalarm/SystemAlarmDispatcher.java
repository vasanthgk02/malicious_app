package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemAlarmDispatcher implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    public final CommandHandler mCommandHandler = new CommandHandler(this.mContext);
    public CommandsCompletedListener mCompletedListener;
    public final Context mContext;
    public Intent mCurrentIntent;
    public final List<Intent> mIntents;
    public final Handler mMainHandler;
    public final Processor mProcessor;
    public final TaskExecutor mTaskExecutor;
    public final WorkManagerImpl mWorkManager;
    public final WorkTimer mWorkTimer = new WorkTimer();

    public static class AddRunnable implements Runnable {
        public final SystemAlarmDispatcher mDispatcher;
        public final Intent mIntent;
        public final int mStartId;

        public AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i) {
            this.mDispatcher = systemAlarmDispatcher;
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    public interface CommandsCompletedListener {
    }

    public static class DequeueAndCheckForCompletion implements Runnable {
        public final SystemAlarmDispatcher mDispatcher;

        public DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.mDispatcher = systemAlarmDispatcher;
        }

        public void run() {
            boolean z;
            boolean z2;
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            if (systemAlarmDispatcher != null) {
                Logger.get().debug(SystemAlarmDispatcher.TAG, "Checking if commands are complete.", new Throwable[0]);
                systemAlarmDispatcher.assertMainThread();
                synchronized (systemAlarmDispatcher.mIntents) {
                    if (systemAlarmDispatcher.mCurrentIntent != null) {
                        Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Removing command %s", new Object[]{systemAlarmDispatcher.mCurrentIntent}), new Throwable[0]);
                        if (systemAlarmDispatcher.mIntents.remove(0).equals(systemAlarmDispatcher.mCurrentIntent)) {
                            systemAlarmDispatcher.mCurrentIntent = null;
                        } else {
                            throw new IllegalStateException("Dequeue-d command is not the first.");
                        }
                    }
                    SerialExecutor serialExecutor = ((WorkManagerTaskExecutor) systemAlarmDispatcher.mTaskExecutor).mBackgroundExecutor;
                    CommandHandler commandHandler = systemAlarmDispatcher.mCommandHandler;
                    synchronized (commandHandler.mLock) {
                        z = !commandHandler.mPendingDelayMet.isEmpty();
                    }
                    if (!z) {
                        if (systemAlarmDispatcher.mIntents.isEmpty()) {
                            synchronized (serialExecutor.mLock) {
                                z2 = !serialExecutor.mTasks.isEmpty();
                            }
                            if (!z2) {
                                Logger.get().debug(SystemAlarmDispatcher.TAG, "No more commands & intents.", new Throwable[0]);
                                if (systemAlarmDispatcher.mCompletedListener != null) {
                                    SystemAlarmService systemAlarmService = (SystemAlarmService) systemAlarmDispatcher.mCompletedListener;
                                    systemAlarmService.mIsShutdown = true;
                                    Logger.get().debug(SystemAlarmService.TAG, "All commands completed in dispatcher", new Throwable[0]);
                                    WakeLocks.checkWakeLocks();
                                    systemAlarmService.stopSelf();
                                }
                            }
                        }
                    }
                    if (!systemAlarmDispatcher.mIntents.isEmpty()) {
                        systemAlarmDispatcher.processCommand();
                    }
                }
                return;
            }
            throw null;
        }
    }

    public SystemAlarmDispatcher(Context context) {
        this.mContext = context.getApplicationContext();
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        this.mWorkManager = instance;
        Processor processor = instance.mProcessor;
        this.mProcessor = processor;
        this.mTaskExecutor = instance.mWorkTaskExecutor;
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public boolean add(Intent intent, int i) {
        boolean z;
        boolean z2 = false;
        Logger.get().debug(TAG, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(TAG, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            assertMainThread();
            synchronized (this.mIntents) {
                Iterator<Intent> it = this.mIntents.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(it.next().getAction())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                return false;
            }
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.mIntents) {
            if (!this.mIntents.isEmpty()) {
                z2 = true;
            }
            this.mIntents.add(intent);
            if (!z2) {
                processCommand();
            }
        }
        return true;
    }

    public final void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        WorkTimer workTimer = this.mWorkTimer;
        if (!workTimer.mExecutorService.isShutdown()) {
            workTimer.mExecutorService.shutdownNow();
        }
        this.mCompletedListener = null;
    }

    public void onExecuted(String str, boolean z) {
        this.mMainHandler.post(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, str, z), 0));
    }

    public final void processCommand() {
        assertMainThread();
        WakeLock newWakeLock = WakeLocks.newWakeLock(this.mContext, "ProcessCommand");
        try {
            newWakeLock.acquire();
            TaskExecutor taskExecutor = this.mWorkManager.mWorkTaskExecutor;
            ((WorkManagerTaskExecutor) taskExecutor).mBackgroundExecutor.execute(new Runnable() {
                public void run() {
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.mIntents) {
                        SystemAlarmDispatcher.this.mCurrentIntent = SystemAlarmDispatcher.this.mIntents.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.mCurrentIntent;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
                        Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Processing command %s, %s", new Object[]{SystemAlarmDispatcher.this.mCurrentIntent, Integer.valueOf(intExtra)}), new Throwable[0]);
                        WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.mContext, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.acquire();
                            SystemAlarmDispatcher.this.mCommandHandler.onHandleIntent(SystemAlarmDispatcher.this.mCurrentIntent, intExtra, SystemAlarmDispatcher.this);
                            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.release();
                            SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher2.mMainHandler.post(new DequeueAndCheckForCompletion(systemAlarmDispatcher2));
                            throw th;
                        }
                        systemAlarmDispatcher.mMainHandler.post(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            newWakeLock.release();
        }
    }
}
