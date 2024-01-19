package com.netcore.android.event;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/netcore/android/event/SMTNotificationSourceType;", "", "<init>", "()V", "Companion", "Source", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTEventConstants.kt */
public final class SMTNotificationSourceType {
    public static final Companion Companion = new Companion(null);
    public static final int NOTIFICATION_SOURCE_PAMP = 3;
    public static final int NOTIFICATION_SOURCE_PN = 1;
    public static final int NOTIFICATION_SOURCE_XIAOMI = 10;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/netcore/android/event/SMTNotificationSourceType$Companion;", "", "", "NOTIFICATION_SOURCE_PAMP", "I", "NOTIFICATION_SOURCE_PN", "NOTIFICATION_SOURCE_XIAOMI", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTEventConstants.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/netcore/android/event/SMTNotificationSourceType$Source;", "", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: SMTEventConstants.kt */
    public @interface Source {
    }
}
