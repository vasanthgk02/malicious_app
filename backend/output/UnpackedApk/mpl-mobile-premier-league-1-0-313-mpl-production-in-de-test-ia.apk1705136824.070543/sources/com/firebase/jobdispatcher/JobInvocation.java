package com.firebase.jobdispatcher;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.json.JSONObject;

public final class JobInvocation implements JobParameters {
    public final int[] constraints;
    public final Bundle extras;
    public final int lifetime;
    public final boolean recurring;
    public final boolean replaceCurrent;
    public final RetryStrategy retryStrategy;
    public final String service;
    public final String tag;
    public final JobTrigger trigger;
    public final TriggerReason triggerReason;

    public static final class Builder {
        public int[] constraints;
        public final Bundle extras = new Bundle();
        public int lifetime;
        public boolean recurring;
        public boolean replaceCurrent;
        public RetryStrategy retryStrategy;
        public String service;
        public String tag;
        public JobTrigger trigger;
        public TriggerReason triggerReason;

        public JobInvocation build() {
            if (this.tag != null && this.service != null && this.trigger != null) {
                return new JobInvocation(this, null);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }
    }

    public JobInvocation(Builder builder, AnonymousClass1 r2) {
        this.tag = builder.tag;
        this.service = builder.service;
        this.trigger = builder.trigger;
        this.retryStrategy = builder.retryStrategy;
        this.recurring = builder.recurring;
        this.lifetime = builder.lifetime;
        this.constraints = builder.constraints;
        this.extras = builder.extras;
        this.replaceCurrent = builder.replaceCurrent;
        this.triggerReason = builder.triggerReason;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || !JobInvocation.class.equals(obj.getClass())) {
            return false;
        }
        JobInvocation jobInvocation = (JobInvocation) obj;
        if (!this.tag.equals(jobInvocation.tag) || !this.service.equals(jobInvocation.service)) {
            z = false;
        }
        return z;
    }

    public int[] getConstraints() {
        return this.constraints;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public int getLifetime() {
        return this.lifetime;
    }

    public RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public String getService() {
        return this.service;
    }

    public String getTag() {
        return this.tag;
    }

    public JobTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        return this.service.hashCode() + (this.tag.hashCode() * 31);
    }

    public boolean isRecurring() {
        return this.recurring;
    }

    public boolean shouldReplaceCurrent() {
        return this.replaceCurrent;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JobInvocation{tag='");
        outline73.append(JSONObject.quote(this.tag));
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(", service='");
        GeneratedOutlineSupport.outline99(outline73, this.service, ExtendedMessageFormat.QUOTE, ", trigger=");
        outline73.append(this.trigger);
        outline73.append(", recurring=");
        outline73.append(this.recurring);
        outline73.append(", lifetime=");
        outline73.append(this.lifetime);
        outline73.append(", constraints=");
        outline73.append(Arrays.toString(this.constraints));
        outline73.append(", extras=");
        outline73.append(this.extras);
        outline73.append(", retryStrategy=");
        outline73.append(this.retryStrategy);
        outline73.append(", replaceCurrent=");
        outline73.append(this.replaceCurrent);
        outline73.append(", triggerReason=");
        outline73.append(this.triggerReason);
        outline73.append('}');
        return outline73.toString();
    }
}
