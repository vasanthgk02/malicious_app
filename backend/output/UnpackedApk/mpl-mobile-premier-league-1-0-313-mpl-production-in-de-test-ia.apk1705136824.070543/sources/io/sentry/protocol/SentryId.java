package io.sentry.protocol;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

public final class SentryId {
    public static final SentryId EMPTY_ID = new SentryId(new UUID(0, 0));
    public final UUID uuid;

    public SentryId() {
        this((UUID) null);
    }

    private UUID fromStringSentryId(String str) {
        if (str.length() == 32) {
            str = new StringBuilder(str).insert(8, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(13, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(18, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(23, Constants.ACCEPT_TIME_SEPARATOR_SERVER).toString();
        }
        if (str.length() == 36) {
            return UUID.fromString(str);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: ", str));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryId.class != obj.getClass()) {
            return false;
        }
        if (this.uuid.compareTo(((SentryId) obj).uuid) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    public String toString() {
        return this.uuid.toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public SentryId(UUID uuid2) {
        this.uuid = uuid2 == null ? UUID.randomUUID() : uuid2;
    }

    public SentryId(String str) {
        this.uuid = fromStringSentryId(str);
    }
}
