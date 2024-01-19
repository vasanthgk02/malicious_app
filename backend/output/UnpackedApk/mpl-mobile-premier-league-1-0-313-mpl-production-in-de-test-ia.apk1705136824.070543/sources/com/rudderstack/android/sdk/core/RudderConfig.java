package com.rudderstack.android.sdk.core;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.rudderstack.android.sdk.core.RudderIntegration.Factory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RudderConfig {
    public int configRefreshInterval;
    public String controlPlaneUrl;
    public List<Factory> customFactories;
    public String dataPlaneUrl;
    public int dbCountThreshold;
    public List<Factory> factories;
    public int flushQueueSize;
    public boolean isPeriodicFlushEnabled;
    public int logLevel;
    public boolean recordScreenViews;
    public long repeatInterval;
    public TimeUnit repeatIntervalTimeUnit;
    public int sleepTimeOut;
    public boolean trackLifecycleEvents;

    public static class Builder {
        public int configRefreshInterval = 2;
        public String controlPlaneUrl = Constants.CONTROL_PLANE_URL;
        public List<Factory> customFactories = new ArrayList();
        public String dataPlaneUrl = Constants.DATA_PLANE_URL;
        public int dbThresholdCount = 10000;
        public List<Factory> factories = new ArrayList();
        public int flushQueueSize = 30;
        public boolean isDebug = false;
        public boolean isPeriodicFlushEnabled = false;
        public int logLevel = 0;
        public boolean recordScreenViews = false;
        public long repeatInterval = 1;
        public TimeUnit repeatIntervalTimeUnit = Constants.REPEAT_INTERVAL_TIME_UNIT;
        public int sleepTimeout = 10;
        public boolean trackLifecycleEvents = true;

        public RudderConfig build() {
            RudderConfig rudderConfig = new RudderConfig(this.dataPlaneUrl, this.flushQueueSize, this.dbThresholdCount, this.sleepTimeout, this.isDebug ? 4 : this.logLevel, this.configRefreshInterval, this.isPeriodicFlushEnabled, this.repeatInterval, this.repeatIntervalTimeUnit, this.trackLifecycleEvents, this.recordScreenViews, this.controlPlaneUrl, this.factories, this.customFactories);
            return rudderConfig;
        }

        public Builder withConfigPlaneUrl(String str) {
            this.controlPlaneUrl = str;
            return this;
        }

        public Builder withConfigRefreshInterval(int i) {
            this.configRefreshInterval = i;
            return this;
        }

        public Builder withControlPlaneUrl(String str) {
            this.controlPlaneUrl = str;
            return this;
        }

        public Builder withCustomFactories(List<Factory> list) {
            this.customFactories.addAll(list);
            return this;
        }

        public Builder withCustomFactory(Factory factory) {
            this.customFactories.add(factory);
            return this;
        }

        public Builder withDataPlaneUrl(String str) {
            if (TextUtils.isEmpty(str)) {
                RudderLogger.logError((String) "endPointUri can not be null or empty. Set to default");
                return this;
            } else if (!URLUtil.isValidUrl(str)) {
                RudderLogger.logError((String) "Malformed endPointUri. Set to default");
                return this;
            } else {
                this.dataPlaneUrl = str;
                return this;
            }
        }

        public Builder withDbThresholdCount(int i) {
            this.dbThresholdCount = i;
            return this;
        }

        @Deprecated
        public Builder withDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder withEndPointUri(String str) {
            if (TextUtils.isEmpty(str)) {
                RudderLogger.logError((String) "endPointUri can not be null or empty. Set to default");
                return this;
            } else if (!URLUtil.isValidUrl(str)) {
                RudderLogger.logError((String) "Malformed endPointUri. Set to default");
                return this;
            } else {
                this.dataPlaneUrl = str;
                return this;
            }
        }

        public Builder withFactories(List<Factory> list) {
            this.factories.addAll(list);
            return this;
        }

        public Builder withFactory(Factory factory) {
            this.factories.add(factory);
            return this;
        }

        public Builder withFlushPeriodically(long j, TimeUnit timeUnit) {
            this.isPeriodicFlushEnabled = true;
            if (timeUnit != TimeUnit.MINUTES || j >= 15) {
                this.repeatInterval = j;
                this.repeatIntervalTimeUnit = timeUnit;
                return this;
            }
            RudderLogger.logError((String) "RudderConfig: Builder: withFlushPeriodically: the repeat Interval for Flushing Periodically should be atleast 15 minutes, falling back to default of 1 hour");
            return this;
        }

        public Builder withFlushQueueSize(int i) {
            if (i < 1 || i > 100) {
                RudderLogger.logError((String) "flushQueueSize is out of range. Min: 1, Max: 100. Set to default");
                return this;
            }
            this.flushQueueSize = i;
            return this;
        }

        public Builder withLogLevel(int i) {
            this.logLevel = i;
            return this;
        }

        public Builder withRecordScreenViews(boolean z) {
            this.recordScreenViews = z;
            return this;
        }

        public Builder withSleepCount(int i) {
            this.sleepTimeout = i;
            return this;
        }

        public Builder withTrackLifecycleEvents(boolean z) {
            this.trackLifecycleEvents = z;
            return this;
        }

        public Builder withCustomFactories(Factory... factoryArr) {
            Collections.addAll(this.customFactories, factoryArr);
            return this;
        }

        public Builder withFactories(Factory... factoryArr) {
            Collections.addAll(this.factories, factoryArr);
            return this;
        }
    }

    public String getConfigPlaneUrl() {
        return this.controlPlaneUrl;
    }

    public int getConfigRefreshInterval() {
        return this.configRefreshInterval;
    }

    public String getControlPlaneUrl() {
        return this.controlPlaneUrl;
    }

    public List<Factory> getCustomFactories() {
        return this.customFactories;
    }

    public String getDataPlaneUrl() {
        return this.dataPlaneUrl;
    }

    public int getDbCountThreshold() {
        return this.dbCountThreshold;
    }

    public String getEndPointUri() {
        return this.dataPlaneUrl;
    }

    public List<Factory> getFactories() {
        return this.factories;
    }

    public int getFlushQueueSize() {
        return this.flushQueueSize;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public long getRepeatInterval() {
        return this.repeatInterval;
    }

    public TimeUnit getRepeatIntervalTimeUnit() {
        return this.repeatIntervalTimeUnit;
    }

    public int getSleepTimeOut() {
        return this.sleepTimeOut;
    }

    public boolean isPeriodicFlushEnabled() {
        return this.isPeriodicFlushEnabled;
    }

    public boolean isRecordScreenViews() {
        return this.recordScreenViews;
    }

    public boolean isTrackLifecycleEvents() {
        return this.trackLifecycleEvents;
    }

    public void setConfigRefreshInterval(int i) {
        this.configRefreshInterval = i;
    }

    public void setControlPlaneUrl(String str) {
        this.controlPlaneUrl = str;
    }

    public void setDataPlaneUrl(String str) {
        this.dataPlaneUrl = str;
    }

    public void setDbCountThreshold(int i) {
        this.dbCountThreshold = i;
    }

    public void setFactories(List<Factory> list) {
        this.factories = list;
    }

    public void setFlushQueueSize(int i) {
        this.flushQueueSize = i;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void setRecordScreenViews(boolean z) {
        this.recordScreenViews = z;
    }

    public void setSleepTimeOut(int i) {
        this.sleepTimeOut = i;
    }

    public void setTrackLifecycleEvents(boolean z) {
        this.trackLifecycleEvents = z;
    }

    public String toString() {
        return String.format(Locale.US, "RudderConfig: endPointUrl:%s | flushQueueSize: %d | dbCountThreshold: %d | sleepTimeOut: %d | logLevel: %d", new Object[]{this.dataPlaneUrl, Integer.valueOf(this.flushQueueSize), Integer.valueOf(this.dbCountThreshold), Integer.valueOf(this.sleepTimeOut), Integer.valueOf(this.logLevel)});
    }

    public RudderConfig() {
        this(Constants.DATA_PLANE_URL, 30, 10000, 10, 1, 2, false, 1, Constants.REPEAT_INTERVAL_TIME_UNIT, true, false, Constants.CONTROL_PLANE_URL, null, null);
    }

    public RudderConfig(String str, int i, int i2, int i3, int i4, int i5, boolean z, long j, TimeUnit timeUnit, boolean z2, boolean z3, String str2, List<Factory> list, List<Factory> list2) {
        String str3 = str;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i5;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        String str4 = str2;
        List<Factory> list3 = list;
        List<Factory> list4 = list2;
        RudderLogger.init(i4);
        if (TextUtils.isEmpty(str)) {
            RudderLogger.logError((String) "endPointUri can not be null or empty. Set to default.");
            this.dataPlaneUrl = Constants.DATA_PLANE_URL;
        } else if (!URLUtil.isValidUrl(str)) {
            RudderLogger.logError((String) "Malformed endPointUri. Set to default");
            this.dataPlaneUrl = Constants.DATA_PLANE_URL;
        } else {
            this.dataPlaneUrl = !str3.endsWith("/") ? GeneratedOutlineSupport.outline50(str3, "/") : str3;
        }
        if (i6 < 1 || i6 > 100) {
            RudderLogger.logError((String) "flushQueueSize is out of range. Min: 1, Max: 100. Set to default");
            this.flushQueueSize = 30;
        } else {
            this.flushQueueSize = i6;
        }
        this.logLevel = i4;
        if (i7 < 0) {
            RudderLogger.logError((String) "invalid dbCountThreshold. Set to default");
            this.dbCountThreshold = 10000;
        } else {
            this.dbCountThreshold = i7;
        }
        if (i9 > 24) {
            this.configRefreshInterval = 24;
        } else if (i9 < 1) {
            this.configRefreshInterval = 1;
        } else {
            this.configRefreshInterval = i9;
        }
        if (i8 < 1) {
            this.sleepTimeOut = 10;
            return;
        }
        this.sleepTimeOut = i8;
        this.isPeriodicFlushEnabled = z;
        if (timeUnit2 != TimeUnit.MINUTES || j2 >= 15) {
            this.repeatInterval = j2;
            this.repeatIntervalTimeUnit = timeUnit2;
        } else {
            RudderLogger.logError((String) "RudderConfig: the repeat Interval for Flushing Periodically should be atleast 15 minutes, falling back to default of 1 hour");
            this.repeatInterval = 1;
            this.repeatIntervalTimeUnit = Constants.REPEAT_INTERVAL_TIME_UNIT;
        }
        this.trackLifecycleEvents = z2;
        this.recordScreenViews = z3;
        if (list3 != null && !list.isEmpty()) {
            this.factories = list3;
        }
        if (list4 != null && !list2.isEmpty()) {
            this.customFactories = list4;
        }
        if (TextUtils.isEmpty(str2)) {
            RudderLogger.logError((String) "configPlaneUrl can not be null or empty. Set to default.");
            this.controlPlaneUrl = Constants.CONTROL_PLANE_URL;
        } else if (!URLUtil.isValidUrl(str2)) {
            RudderLogger.logError((String) "Malformed configPlaneUrl. Set to default");
            this.controlPlaneUrl = Constants.CONTROL_PLANE_URL;
        } else {
            this.controlPlaneUrl = !str4.endsWith("/") ? GeneratedOutlineSupport.outline50(str4, "/") : str4;
        }
    }
}
