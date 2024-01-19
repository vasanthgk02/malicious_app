package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.AddRunnable;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommandHandler implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("CommandHandler");
    public final Context mContext;
    public final Object mLock = new Object();
    public final Map<String, ExecutionListener> mPendingDelayMet = new HashMap();

    public CommandHandler(Context context) {
        this.mContext = context;
    }

    public static Intent createConstraintsChangedIntent(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent createDelayMetIntent(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createExecutionCompletedIntent(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    public static Intent createRescheduleIntent(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static Intent createScheduleWorkIntent(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent createStopWorkIntent(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public void onExecuted(String str, boolean z) {
        synchronized (this.mLock) {
            ExecutionListener remove = this.mPendingDelayMet.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z);
            }
        }
    }

    public void onHandleIntent(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        boolean z;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            Logger.get().debug(TAG, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(this.mContext, i, systemAlarmDispatcher);
            List<WorkSpec> scheduledWork = ((WorkSpecDao_Impl) constraintsCommandHandler.mDispatcher.mWorkManager.mWorkDatabase.workSpecDao()).getScheduledWork();
            ConstraintProxy.updateAll(constraintsCommandHandler.mContext, scheduledWork);
            constraintsCommandHandler.mWorkConstraintsTracker.replace(scheduledWork);
            ArrayList arrayList = (ArrayList) scheduledWork;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WorkSpec workSpec = (WorkSpec) it.next();
                String str = workSpec.id;
                if (currentTimeMillis >= workSpec.calculateNextRunTime() && (!workSpec.hasConstraints() || constraintsCommandHandler.mWorkConstraintsTracker.areAllConstraintsMet(str))) {
                    arrayList2.add(workSpec);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str2 = ((WorkSpec) it2.next()).id;
                Intent createDelayMetIntent = createDelayMetIntent(constraintsCommandHandler.mContext, str2);
                Logger.get().debug(ConstraintsCommandHandler.TAG, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
                SystemAlarmDispatcher systemAlarmDispatcher2 = constraintsCommandHandler.mDispatcher;
                systemAlarmDispatcher2.mMainHandler.post(new AddRunnable(systemAlarmDispatcher2, createDelayMetIntent, constraintsCommandHandler.mStartId));
            }
            constraintsCommandHandler.mWorkConstraintsTracker.reset();
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
            systemAlarmDispatcher.mWorkManager.rescheduleEligibleWork();
        } else {
            Bundle extras = intent.getExtras();
            String[] strArr = {"KEY_WORKSPEC_ID"};
            if (extras != null && !extras.isEmpty()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 1) {
                        z = true;
                        break;
                    } else if (extras.get(strArr[i2]) == null) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = false;
            if (!z) {
                Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
            } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
                String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                Logger.get().debug(TAG, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
                WorkDatabase workDatabase = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    WorkSpec workSpec2 = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(string);
                    if (workSpec2 == null) {
                        Logger logger = Logger.get();
                        String str3 = TAG;
                        logger.warning(str3, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                    } else if (workSpec2.state.isFinished()) {
                        Logger logger2 = Logger.get();
                        String str4 = TAG;
                        logger2.warning(str4, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                    } else {
                        long calculateNextRunTime = workSpec2.calculateNextRunTime();
                        if (!workSpec2.hasConstraints()) {
                            Logger.get().debug(TAG, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                            Alarms.setAlarm(this.mContext, systemAlarmDispatcher.mWorkManager, string, calculateNextRunTime);
                        } else {
                            Logger.get().debug(TAG, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                            Alarms.setAlarm(this.mContext, systemAlarmDispatcher.mWorkManager, string, calculateNextRunTime);
                            systemAlarmDispatcher.mMainHandler.post(new AddRunnable(systemAlarmDispatcher, createConstraintsChangedIntent(this.mContext), i));
                        }
                        workDatabase.setTransactionSuccessful();
                    }
                } finally {
                    workDatabase.endTransaction();
                }
            } else if ("ACTION_DELAY_MET".equals(action)) {
                Bundle extras2 = intent.getExtras();
                synchronized (this.mLock) {
                    String string2 = extras2.getString("KEY_WORKSPEC_ID");
                    Logger.get().debug(TAG, String.format("Handing delay met for %s", new Object[]{string2}), new Throwable[0]);
                    if (!this.mPendingDelayMet.containsKey(string2)) {
                        DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i, string2, systemAlarmDispatcher);
                        this.mPendingDelayMet.put(string2, delayMetCommandHandler);
                        delayMetCommandHandler.handleProcessWork();
                    } else {
                        Logger.get().debug(TAG, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string2}), new Throwable[0]);
                    }
                }
            } else if ("ACTION_STOP_WORK".equals(action)) {
                String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                Logger.get().debug(TAG, String.format("Handing stopWork work for %s", new Object[]{string3}), new Throwable[0]);
                systemAlarmDispatcher.mWorkManager.stopWork(string3);
                Alarms.cancelAlarm(this.mContext, systemAlarmDispatcher.mWorkManager, string3);
                systemAlarmDispatcher.onExecuted(string3, false);
            } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
                Bundle extras3 = intent.getExtras();
                String string4 = extras3.getString("KEY_WORKSPEC_ID");
                boolean z2 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
                onExecuted(string4, z2);
            } else {
                Logger.get().warning(TAG, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
            }
        }
    }
}
