package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class WorkRequest {
    public UUID mId;
    public Set<String> mTags;
    public WorkSpec mWorkSpec;

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        public boolean mBackoffCriteriaSet = false;
        public UUID mId = UUID.randomUUID();
        public Set<String> mTags = new HashSet();
        public WorkSpec mWorkSpec;

        public Builder(Class<? extends ListenableWorker> cls) {
            this.mWorkSpec = new WorkSpec(this.mId.toString(), cls.getName());
            this.mTags.add(cls.getName());
            getThis();
        }

        public final B addTag(String str) {
            this.mTags.add(str);
            return (androidx.work.OneTimeWorkRequest.Builder) this;
        }

        public final W build() {
            W buildInternal = buildInternal();
            this.mId = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec;
            workSpec.id = this.mId.toString();
            return buildInternal;
        }

        public abstract W buildInternal();

        public abstract B getThis();
    }

    public WorkRequest(UUID uuid, WorkSpec workSpec, Set<String> set) {
        this.mId = uuid;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    public String getStringId() {
        return this.mId.toString();
    }
}
