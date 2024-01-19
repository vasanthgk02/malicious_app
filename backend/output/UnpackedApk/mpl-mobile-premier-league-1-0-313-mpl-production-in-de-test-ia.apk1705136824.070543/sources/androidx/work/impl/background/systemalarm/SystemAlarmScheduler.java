package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

public class SystemAlarmScheduler implements Scheduler {
    public static final String TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    public final Context mContext;

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void cancel(String str) {
        this.mContext.startService(CommandHandler.createStopWorkIntent(this.mContext, str));
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public void schedule(WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            Logger.get().debug(TAG, String.format("Scheduling work with workSpecId %s", new Object[]{workSpec.id}), new Throwable[0]);
            this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, workSpec.id));
        }
    }
}
