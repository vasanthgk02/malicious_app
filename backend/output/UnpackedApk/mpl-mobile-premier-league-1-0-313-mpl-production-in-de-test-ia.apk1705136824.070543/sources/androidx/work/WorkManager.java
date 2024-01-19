package androidx.work;

import android.annotation.SuppressLint;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {
    public final WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        List singletonList = Collections.singletonList(oneTimeWorkRequest);
        WorkManagerImpl workManagerImpl = (WorkManagerImpl) this;
        if (!singletonList.isEmpty()) {
            return new WorkContinuationImpl(workManagerImpl, str, existingWorkPolicy, singletonList);
        }
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    public final Operation enqueue(WorkRequest workRequest) {
        List singletonList = Collections.singletonList(workRequest);
        WorkManagerImpl workManagerImpl = (WorkManagerImpl) this;
        if (!singletonList.isEmpty()) {
            WorkContinuationImpl workContinuationImpl = new WorkContinuationImpl(workManagerImpl, null, ExistingWorkPolicy.KEEP, singletonList, null);
            return workContinuationImpl.enqueue();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public abstract Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);
}
