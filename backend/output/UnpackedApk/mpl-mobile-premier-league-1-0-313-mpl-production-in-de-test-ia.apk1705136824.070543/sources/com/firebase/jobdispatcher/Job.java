package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class Job implements JobParameters {
    public final int[] constraints;
    public final Bundle extras;
    public final int lifetime;
    public final boolean recurring;
    public final boolean replaceCurrent;
    public final RetryStrategy retryStrategy;
    public final String service;
    public final String tag;
    public final JobTrigger trigger;

    public static final class Builder implements JobParameters {
        public int[] constraints;
        public Bundle extras;
        public int lifetime = 1;
        public boolean recurring = false;
        public boolean replaceCurrent = false;
        public RetryStrategy retryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
        public String serviceClassName;
        public String tag;
        public JobTrigger trigger = Trigger.NOW;
        public final ValidationEnforcer validator;

        public Builder(ValidationEnforcer validationEnforcer, JobParameters jobParameters) {
            this.validator = validationEnforcer;
            this.tag = jobParameters.getTag();
            this.serviceClassName = jobParameters.getService();
            this.trigger = jobParameters.getTrigger();
            this.recurring = jobParameters.isRecurring();
            this.lifetime = jobParameters.getLifetime();
            this.constraints = jobParameters.getConstraints();
            this.extras = jobParameters.getExtras();
            this.retryStrategy = jobParameters.getRetryStrategy();
        }

        public int[] getConstraints() {
            int[] iArr = this.constraints;
            return iArr == null ? new int[0] : iArr;
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
            return this.serviceClassName;
        }

        public String getTag() {
            return this.tag;
        }

        public JobTrigger getTrigger() {
            return this.trigger;
        }

        public boolean isRecurring() {
            return this.recurring;
        }

        public boolean shouldReplaceCurrent() {
            return this.replaceCurrent;
        }
    }

    public Job(Builder builder, AnonymousClass1 r3) {
        Bundle bundle;
        this.service = builder.serviceClassName;
        if (builder.extras == null) {
            bundle = null;
        } else {
            bundle = new Bundle(builder.extras);
        }
        this.extras = bundle;
        this.tag = builder.tag;
        this.trigger = builder.trigger;
        this.retryStrategy = builder.retryStrategy;
        this.lifetime = builder.lifetime;
        this.recurring = builder.recurring;
        this.constraints = builder.constraints == null ? new int[0] : builder.constraints;
        this.replaceCurrent = builder.replaceCurrent;
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

    public boolean isRecurring() {
        return this.recurring;
    }

    public boolean shouldReplaceCurrent() {
        return this.replaceCurrent;
    }
}
