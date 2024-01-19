package com.rudderstack.android.sdk.core;

import java.util.concurrent.TimeUnit;

public class Constants {
    public static final int CONFIG_REFRESH_INTERVAL = 2;
    public static final String CONTROL_PLANE_URL = "https://api.rudderlabs.com";
    public static final String DATA_PLANE_URL = "https://hosted.rudderlabs.com";
    public static final int DB_COUNT_THRESHOLD = 10000;
    public static final int FLUSH_QUEUE_SIZE = 30;
    public static final boolean PERIODIC_FLUSH_ENABLED = false;
    public static final boolean RECORD_SCREEN_VIEWS = false;
    public static final long REPEAT_INTERVAL = 1;
    public static final TimeUnit REPEAT_INTERVAL_TIME_UNIT = TimeUnit.HOURS;
    public static final String RUDDER_LIBRARY_VERSION = "1.1.1";
    public static final int SLEEP_TIMEOUT = 10;
    public static final boolean TRACK_LIFECYCLE_EVENTS = true;
}
