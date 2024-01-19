package com.freshchat.consumer.sdk;

import com.freshchat.consumer.sdk.j.as;

public final class FreshchatConfig {
    public final String appId;
    public final String appKey;
    public boolean cameraCaptureEnabled = true;
    public String domain;
    public boolean gallerySelectionEnabled = true;
    public boolean responseExpectationEnabled = true;
    public boolean teamMemberInfoVisible = true;
    public boolean userEventsTrackingEnabled = true;

    public FreshchatConfig(String str, String str2) {
        this.appId = str.trim();
        this.appKey = str2.trim();
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
        return this.gallerySelectionEnabled;
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

    public FreshchatConfig setCameraCaptureEnabled(boolean z) {
        this.cameraCaptureEnabled = z;
        return this;
    }

    public void setDomain(String str) {
        if (as.a(str)) {
            this.domain = str.toLowerCase();
        }
    }

    public FreshchatConfig setGallerySelectionEnabled(boolean z) {
        this.gallerySelectionEnabled = z;
        return this;
    }

    public FreshchatConfig setResponseExpectationEnabled(boolean z) {
        this.responseExpectationEnabled = z;
        return this;
    }

    public FreshchatConfig setTeamMemberInfoVisible(boolean z) {
        this.teamMemberInfoVisible = z;
        return this;
    }

    public void setUserEventsTrackingEnabled(boolean z) {
        this.userEventsTrackingEnabled = z;
    }
}
