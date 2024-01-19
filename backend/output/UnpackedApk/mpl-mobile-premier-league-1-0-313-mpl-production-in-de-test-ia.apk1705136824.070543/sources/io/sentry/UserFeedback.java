package io.sentry;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.protocol.SentryId;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public final class UserFeedback {
    public String comments;
    public String email;
    public final SentryId eventId;
    public String name;

    public UserFeedback(SentryId sentryId) {
        this(sentryId, null, null, null);
    }

    public String getComments() {
        return this.comments;
    }

    public String getEmail() {
        return this.email;
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public String getName() {
        return this.name;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UserFeedback{eventId=");
        outline73.append(this.eventId);
        outline73.append(", name='");
        GeneratedOutlineSupport.outline99(outline73, this.name, ExtendedMessageFormat.QUOTE, ", email='");
        GeneratedOutlineSupport.outline99(outline73, this.email, ExtendedMessageFormat.QUOTE, ", comments='");
        return GeneratedOutlineSupport.outline60(outline73, this.comments, ExtendedMessageFormat.QUOTE, '}');
    }

    public UserFeedback(SentryId sentryId, String str, String str2, String str3) {
        this.eventId = sentryId;
        this.name = str;
        this.email = str2;
        this.comments = str3;
    }
}
