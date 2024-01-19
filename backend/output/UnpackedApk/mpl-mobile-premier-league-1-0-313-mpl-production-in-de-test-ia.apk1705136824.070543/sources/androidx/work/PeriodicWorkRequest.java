package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.model.WorkSpec;
import java.util.concurrent.TimeUnit;

public final class PeriodicWorkRequest extends WorkRequest {

    public static final class Builder extends androidx.work.WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit) {
            super(cls);
            WorkSpec workSpec = this.mWorkSpec;
            long millis = timeUnit.toMillis(j);
            if (workSpec != null) {
                long j2 = 900000;
                Long valueOf = Long.valueOf(900000);
                if (millis < 900000) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{valueOf}), new Throwable[0]);
                    millis = 900000;
                }
                if (millis < 900000) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{valueOf}), new Throwable[0]);
                } else {
                    j2 = millis;
                }
                if (millis < 300000) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{Long.valueOf(300000)}), new Throwable[0]);
                    millis = 300000;
                }
                if (millis > j2) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j2)}), new Throwable[0]);
                    millis = j2;
                }
                workSpec.intervalDuration = j2;
                workSpec.flexDuration = millis;
                return;
            }
            throw null;
        }

        public WorkRequest buildInternal() {
            if (!this.mBackoffCriteriaSet || VERSION.SDK_INT < 23 || !this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                WorkSpec workSpec = this.mWorkSpec;
                if (!workSpec.runInForeground || VERSION.SDK_INT < 23 || !workSpec.constraints.mRequiresDeviceIdle) {
                    return new PeriodicWorkRequest(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        public androidx.work.WorkRequest.Builder getThis() {
            return this;
        }
    }

    public PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
