package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkContinuationImpl extends WorkContinuation {
    public static final String TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    public final List<String> mAllIds;
    public boolean mEnqueued;
    public final ExistingWorkPolicy mExistingWorkPolicy;
    public final List<String> mIds;
    public final String mName;
    public Operation mOperation;
    public final List<WorkContinuationImpl> mParents;
    public final List<? extends WorkRequest> mWork;
    public final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list) {
        this(workManagerImpl, str, existingWorkPolicy, list, null);
    }

    public static boolean hasCycles(WorkContinuationImpl workContinuationImpl, Set<String> set) {
        set.addAll(workContinuationImpl.mIds);
        Set<String> prerequisitesFor = prerequisitesFor(workContinuationImpl);
        for (String contains : set) {
            if (((HashSet) prerequisitesFor).contains(contains)) {
                return true;
            }
        }
        List<WorkContinuationImpl> list = workContinuationImpl.mParents;
        if (list != null && !list.isEmpty()) {
            for (WorkContinuationImpl hasCycles : list) {
                if (hasCycles(hasCycles, set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.mIds);
        return false;
    }

    public static Set<String> prerequisitesFor(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> list = workContinuationImpl.mParents;
        if (list != null && !list.isEmpty()) {
            for (WorkContinuationImpl workContinuationImpl2 : list) {
                hashSet.addAll(workContinuationImpl2.mIds);
            }
        }
        return hashSet;
    }

    public Operation enqueue() {
        if (!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            ((WorkManagerTaskExecutor) this.mWorkManagerImpl.mWorkTaskExecutor).mBackgroundExecutor.execute(enqueueRunnable);
            this.mOperation = enqueueRunnable.mOperation;
        } else {
            Logger.get().warning(TAG, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.mIds)}), new Throwable[0]);
        }
        return this.mOperation;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = str;
        this.mExistingWorkPolicy = existingWorkPolicy;
        this.mWork = list;
        this.mParents = null;
        this.mIds = new ArrayList(this.mWork.size());
        this.mAllIds = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String stringId = ((WorkRequest) list.get(i)).getStringId();
            this.mIds.add(stringId);
            this.mAllIds.add(stringId);
        }
    }
}
