package androidx.work.impl;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schedulers {
    public static final String TAG = Logger.tagWithPrefix("Schedulers");

    public static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkManagerImpl workManagerImpl) {
        Scheduler scheduler;
        if (VERSION.SDK_INT >= 23) {
            SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workManagerImpl);
            PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
            Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return systemJobScheduler;
        }
        try {
            scheduler = (Scheduler) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            Logger.get().debug(TAG, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to create GCM Scheduler", th);
            scheduler = null;
        }
        if (scheduler != null) {
            return scheduler;
        }
        SystemAlarmScheduler systemAlarmScheduler = new SystemAlarmScheduler(context);
        PackageManagerHelper.setComponentEnabled(context, SystemAlarmService.class, true);
        Logger.get().debug(TAG, "Created SystemAlarmScheduler", new Throwable[0]);
        return systemAlarmScheduler;
    }

    /* JADX INFO: finally extract failed */
    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> list) {
        int i;
        if (list != null && list.size() != 0) {
            WorkSpecDao workSpecDao = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            try {
                if (VERSION.SDK_INT == 23) {
                    i = configuration.mMaxSchedulerLimit / 2;
                } else {
                    i = configuration.mMaxSchedulerLimit;
                }
                WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
                List<WorkSpec> eligibleWorkForScheduling = workSpecDao_Impl.getEligibleWorkForScheduling(i);
                List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao_Impl.getAllEligibleWorkSpecsForScheduling(200);
                ArrayList arrayList = (ArrayList) eligibleWorkForScheduling;
                if (arrayList.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        workSpecDao_Impl.markWorkSpecScheduled(((WorkSpec) it.next()).id, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (arrayList.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) arrayList.toArray(new WorkSpec[arrayList.size()]);
                    for (Scheduler next : list) {
                        if (next.hasLimitedSchedulingSlots()) {
                            next.schedule(workSpecArr);
                        }
                    }
                }
                ArrayList arrayList2 = (ArrayList) allEligibleWorkSpecsForScheduling;
                if (arrayList2.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) arrayList2.toArray(new WorkSpec[arrayList2.size()]);
                    for (Scheduler next2 : list) {
                        if (!next2.hasLimitedSchedulingSlots()) {
                            next2.schedule(workSpecArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
