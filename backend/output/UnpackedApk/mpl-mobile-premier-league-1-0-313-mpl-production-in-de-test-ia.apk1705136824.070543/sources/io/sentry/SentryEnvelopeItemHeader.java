package io.sentry;

import io.sentry.util.Objects;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryEnvelopeItemHeader {
    public final String attachmentType;
    public final String contentType;
    public final String fileName;
    public final Callable<Integer> getLength;
    public final int length;
    public final SentryItemType type;

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, int i, String str, String str2, String str3) {
        this.type = (SentryItemType) Objects.requireNonNull(sentryItemType, "type is required");
        this.contentType = str;
        this.length = i;
        this.fileName = str2;
        this.getLength = null;
        this.attachmentType = str3;
    }

    public String getAttachmentType() {
        return this.attachmentType;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLength() {
        Callable<Integer> callable = this.getLength;
        if (callable == null) {
            return this.length;
        }
        try {
            return callable.call().intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public SentryItemType getType() {
        return this.type;
    }

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable<Integer> callable, String str, String str2, String str3) {
        this.type = (SentryItemType) Objects.requireNonNull(sentryItemType, "type is required");
        this.contentType = str;
        this.length = -1;
        this.fileName = str2;
        this.getLength = callable;
        this.attachmentType = str3;
    }

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable<Integer> callable, String str, String str2) {
        this(sentryItemType, callable, str, str2, (String) null);
    }
}
