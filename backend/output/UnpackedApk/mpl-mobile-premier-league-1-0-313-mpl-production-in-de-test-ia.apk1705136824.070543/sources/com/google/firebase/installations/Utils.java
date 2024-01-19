package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class Utils {
    public static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);
    public static Utils singleton;
    public final SystemClock clock;

    public Utils(SystemClock systemClock) {
        this.clock = systemClock;
    }

    public static Utils getInstance() {
        if (SystemClock.singleton == null) {
            SystemClock.singleton = new SystemClock();
        }
        SystemClock systemClock = SystemClock.singleton;
        if (singleton == null) {
            singleton = new Utils(systemClock);
        }
        return singleton;
    }

    public static boolean isValidAppIdFormat(String str) {
        return str.contains(":");
    }

    public long currentTimeInMillis() {
        if (this.clock != null) {
            return System.currentTimeMillis();
        }
        throw null;
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis());
    }

    public boolean isAuthTokenExpired(PersistedInstallationEntry persistedInstallationEntry) {
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        if (!TextUtils.isEmpty(autoValue_PersistedInstallationEntry.authToken) && autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs + autoValue_PersistedInstallationEntry.expiresInSecs >= currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS) {
            return false;
        }
        return true;
    }
}
