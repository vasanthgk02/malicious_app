package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryEnvelopeHeader {
    public final SentryId eventId;
    public final SdkVersion sdkVersion;

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion2) {
        this.eventId = sentryId;
        this.sdkVersion = sdkVersion2;
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public SentryEnvelopeHeader(SentryId sentryId) {
        this(sentryId, null);
    }

    public SentryEnvelopeHeader() {
        this(new SentryId());
    }
}
