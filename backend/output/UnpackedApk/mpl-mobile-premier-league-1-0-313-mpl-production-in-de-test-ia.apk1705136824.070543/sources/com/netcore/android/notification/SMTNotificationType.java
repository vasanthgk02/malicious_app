package com.netcore.android.notification;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/netcore/android/notification/SMTNotificationType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SIMPLE", "BIG_IMAGE", "CAROUSEL", "CAROUSEL_LANDSCAPE", "CAROUSEL_PORTRAIT", "AUDIO", "VIDEO", "GIF", "INTERACTIVE", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNotificationType.kt */
public enum SMTNotificationType {
    SIMPLE("simple"),
    BIG_IMAGE(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY),
    CAROUSEL(SMTNotificationConstants.NOTIF_CAROUSEL_KEY),
    CAROUSEL_LANDSCAPE("carousellandscape"),
    CAROUSEL_PORTRAIT("carouselportrait"),
    AUDIO("audio"),
    VIDEO("video"),
    GIF("gif"),
    INTERACTIVE("interactive");
    
    public final String type;

    /* access modifiers changed from: public */
    SMTNotificationType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
