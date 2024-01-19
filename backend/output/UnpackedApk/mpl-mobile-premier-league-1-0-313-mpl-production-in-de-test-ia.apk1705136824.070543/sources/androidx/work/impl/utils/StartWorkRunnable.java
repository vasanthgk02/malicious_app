package androidx.work.impl.utils;

import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.WorkManagerImpl;

public class StartWorkRunnable implements Runnable {
    public RuntimeExtras mRuntimeExtras;
    public WorkManagerImpl mWorkManagerImpl;
    public String mWorkSpecId;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, RuntimeExtras runtimeExtras) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = str;
        this.mRuntimeExtras = runtimeExtras;
    }

    public void run() {
        this.mWorkManagerImpl.mProcessor.startWork(this.mWorkSpecId, this.mRuntimeExtras);
    }
}
