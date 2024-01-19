package com.netcore.android.event;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/event/SMTEventType;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTEventConstants.kt */
public final class SMTEventType {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_TYPE_CUSTOM = "custom";
    public static final String EVENT_TYPE_SYSTEM = "system";
    public static final String EVENT_TYPE_SYSTEM_APP_INBOX = "system_app_inbox";
    public static final String EVENT_TYPE_SYSTEM_APP_LIFECYCLE = "system_app_lifecycle";
    public static final String EVENT_TYPE_SYSTEM_IN_APP = "system_in_app";
    public static final String EVENT_TYPE_SYSTEM_PN = "system_push_notification";

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/netcore/android/event/SMTEventType$Companion;", "", "", "EVENT_TYPE_CUSTOM", "Ljava/lang/String;", "EVENT_TYPE_SYSTEM", "EVENT_TYPE_SYSTEM_APP_INBOX", "EVENT_TYPE_SYSTEM_APP_LIFECYCLE", "EVENT_TYPE_SYSTEM_IN_APP", "EVENT_TYPE_SYSTEM_PN", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTEventConstants.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
