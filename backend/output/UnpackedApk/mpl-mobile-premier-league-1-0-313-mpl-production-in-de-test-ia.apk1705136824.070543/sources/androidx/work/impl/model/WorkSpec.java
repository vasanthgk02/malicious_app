package androidx.work.impl.model;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class WorkSpec {
    public static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public long flexDuration;
    public String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long minimumRetentionDuration;
    public Data output;
    public long periodStartTime;
    public int runAttemptCount;
    public boolean runInForeground;
    public long scheduleRequestedAt;
    public WorkInfo$State state = WorkInfo$State.ENQUEUED;
    public String workerClassName;

    public static class IdAndState {
        public String id;
        public WorkInfo$State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.id.equals(idAndState.id);
        }

        public int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }
    }

    public WorkSpec(String str, String str2) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.id = str;
        this.workerClassName = str2;
    }

    public long calculateNextRunTime() {
        long j;
        long j2;
        long j3;
        boolean z = false;
        if (this.state == WorkInfo$State.ENQUEUED && this.runAttemptCount > 0) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                z = true;
            }
            if (z) {
                j3 = this.backoffDelayDuration * ((long) this.runAttemptCount);
            } else {
                j3 = (long) Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            j = this.periodStartTime;
            j2 = Math.min(18000000, j3);
        } else {
            long j4 = 0;
            if (isPeriodic()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j5 = this.periodStartTime;
                if (j5 == 0) {
                    j5 = this.initialDelay + currentTimeMillis;
                }
                if (this.flexDuration != this.intervalDuration) {
                    z = true;
                }
                if (z) {
                    if (this.periodStartTime == 0) {
                        j4 = this.flexDuration * -1;
                    }
                    return j5 + this.intervalDuration + j4;
                }
                if (this.periodStartTime != 0) {
                    j4 = this.intervalDuration;
                }
                return j5 + j4;
            }
            j2 = this.periodStartTime;
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            j = this.initialDelay;
        }
        return j2 + j;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.runInForeground != workSpec.runInForeground || !this.id.equals(workSpec.id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName != null : !str.equals(workSpec.inputMergerClassName)) {
            return false;
        }
        if (!this.input.equals(workSpec.input) || !this.output.equals(workSpec.output) || !this.constraints.equals(workSpec.constraints)) {
            return false;
        }
        if (this.backoffPolicy != workSpec.backoffPolicy) {
            z = false;
        }
        return z;
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.workerClassName, (this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31);
        String str = this.inputMergerClassName;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = this.input.hashCode();
        int hashCode3 = this.output.hashCode();
        long j = this.initialDelay;
        long j2 = this.intervalDuration;
        long j3 = this.flexDuration;
        int hashCode4 = this.constraints.hashCode();
        int hashCode5 = this.backoffPolicy.hashCode();
        long j4 = this.backoffDelayDuration;
        long j5 = this.periodStartTime;
        long j6 = this.minimumRetentionDuration;
        long j7 = this.scheduleRequestedAt;
        return ((((((((((hashCode5 + ((((hashCode4 + ((((((((hashCode3 + ((hashCode2 + ((outline11 + hashCode) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.runInForeground ? 1 : 0);
    }

    public boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("{WorkSpec: "), this.id, "}");
    }

    public WorkSpec(WorkSpec workSpec) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.id = workSpec.id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
        this.runInForeground = workSpec.runInForeground;
    }
}
