package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.FreshchatConfig;

public class l implements j {
    public String appId;
    public String appKey;
    public boolean cameraCaptureEnabled = true;
    public String domain;
    public boolean gs = false;
    public boolean gt = true;
    public boolean responseExpectationEnabled = true;
    public boolean teamMemberInfoVisible = true;
    public boolean userEventsTrackingEnabled = true;

    public l(FreshchatConfig freshchatConfig) {
        o(freshchatConfig.getAppId());
        p(freshchatConfig.getAppKey());
        setDomain(freshchatConfig.getDomain());
        w(freshchatConfig.isResponseExpectationEnabled());
        d(freshchatConfig.isTeamMemberInfoVisible());
        e(freshchatConfig.isCameraCaptureEnabled());
        g(freshchatConfig.isGallerySelectionEnabled());
        setUserEventsTrackingEnabled(freshchatConfig.isUserEventsTrackingEnabled());
    }

    public void d(boolean z) {
        this.teamMemberInfoVisible = z;
    }

    public boolean dI() {
        return this.gs;
    }

    public void e(boolean z) {
        this.cameraCaptureEnabled = z;
    }

    public void g(boolean z) {
        this.gt = z;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getDomain() {
        return this.domain;
    }

    public boolean isCameraCaptureEnabled() {
        return this.cameraCaptureEnabled;
    }

    public boolean isGallerySelectionEnabled() {
        return this.gt;
    }

    public boolean isResponseExpectationEnabled() {
        return this.responseExpectationEnabled;
    }

    public boolean isTeamMemberInfoVisible() {
        return this.teamMemberInfoVisible;
    }

    public boolean isUserEventsTrackingEnabled() {
        return this.userEventsTrackingEnabled;
    }

    public void o(String str) {
        this.appId = str;
    }

    public void p(String str) {
        this.appKey = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setUserEventsTrackingEnabled(boolean z) {
        this.userEventsTrackingEnabled = z;
    }

    public void w(boolean z) {
        this.responseExpectationEnabled = z;
    }
}
