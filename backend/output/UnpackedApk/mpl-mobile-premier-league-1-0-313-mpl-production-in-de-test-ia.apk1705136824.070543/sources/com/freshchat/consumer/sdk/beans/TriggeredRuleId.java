package com.freshchat.consumer.sdk.beans;

public class TriggeredRuleId {
    public String flowId;
    public String flowVersionId;
    public long serviceAccountId;
    public long timeDiffInMillis;

    public String getFlowId() {
        return this.flowId;
    }

    public String getFlowVersionId() {
        return this.flowVersionId;
    }

    public long getServiceAccountId() {
        return this.serviceAccountId;
    }

    public long getTimeDiffInMillis() {
        return this.timeDiffInMillis;
    }

    public void setFlowId(String str) {
        this.flowId = str;
    }

    public void setFlowVersionId(String str) {
        this.flowVersionId = str;
    }

    public void setServiceAccountId(long j) {
        this.serviceAccountId = j;
    }

    public void setTimeDiffInMillis(long j) {
        this.timeDiffInMillis = j;
    }
}
