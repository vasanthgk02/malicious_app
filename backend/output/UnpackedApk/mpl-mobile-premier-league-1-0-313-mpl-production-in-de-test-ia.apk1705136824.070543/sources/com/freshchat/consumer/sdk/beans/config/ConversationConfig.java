package com.freshchat.consumer.sdk.beans.config;

import java.util.Set;

public class ConversationConfig {
    public double activeConvFetchBackoffRatio;
    public long activeConvWindow;
    public boolean launchDeeplinkFromNotification;
    public Set<Integer> reopenedMsgTypes;
    public Set<Integer> resolvedMsgTypes;

    public enum AgentAvatarType {
        NONE,
        APP_ICON,
        REAL_AGENT_AVATAR
    }

    public double getActiveConvFetchBackoffRatio() {
        return this.activeConvFetchBackoffRatio;
    }

    public long getActiveConvWindow() {
        return this.activeConvWindow;
    }

    public Set<Integer> getReopenedMsgtypes() {
        return this.reopenedMsgTypes;
    }

    public Set<Integer> getResolvedMsgTypes() {
        return this.resolvedMsgTypes;
    }

    public void setActiveConvFetchBackoffRatio(double d2) {
        this.activeConvFetchBackoffRatio = d2;
    }

    public void setActiveConvWindow(long j) {
        this.activeConvWindow = j;
    }

    public void setLaunchDeeplinkFromNotification(boolean z) {
        this.launchDeeplinkFromNotification = z;
    }

    public void setReopenedMsgtypes(Set<Integer> set) {
        this.reopenedMsgTypes = set;
    }

    public void setResolvedMsgTypes(Set<Integer> set) {
        this.resolvedMsgTypes = set;
    }

    public boolean shouldLaunchDeeplinkFromNotification() {
        return this.launchDeeplinkFromNotification;
    }
}
