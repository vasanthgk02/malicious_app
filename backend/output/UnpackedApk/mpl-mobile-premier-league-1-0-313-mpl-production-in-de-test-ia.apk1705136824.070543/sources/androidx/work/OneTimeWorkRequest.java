package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.model.WorkSpec;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends androidx.work.WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        public WorkRequest buildInternal() {
            if (!this.mBackoffCriteriaSet || VERSION.SDK_INT < 23 || !this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                WorkSpec workSpec = this.mWorkSpec;
                if (!workSpec.runInForeground || VERSION.SDK_INT < 23 || !workSpec.constraints.mRequiresDeviceIdle) {
                    return new OneTimeWorkRequest(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        public androidx.work.WorkRequest.Builder getThis() {
            return this;
        }
    }

    public OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
