package com.mpl.androidapp.notification.states;

import android.app.Notification;
import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "", "()V", "BuildLaunchIntent", "BuildNotification", "ErrorState", "InitialState", "IsAppIsInBackground", "NotificationChannel", "NotificationEventPublished", "NotificationPriority", "NotificationPublished", "NotificationTimerSuccessful", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$InitialState;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationTimerSuccessful;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationEventPublished;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationPublished;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$IsAppIsInBackground;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationPriority;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationChannel;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$BuildLaunchIntent;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$BuildNotification;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates$ErrorState;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MPLNotificationStates.kt */
public abstract class MPLNotificationStates {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$BuildLaunchIntent;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class BuildLaunchIntent extends MPLNotificationStates {
        public final Intent intent;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public BuildLaunchIntent(Intent intent2) {
            // Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            super(null);
            this.intent = intent2;
        }

        public static /* synthetic */ BuildLaunchIntent copy$default(BuildLaunchIntent buildLaunchIntent, Intent intent2, int i, Object obj) {
            if ((i & 1) != 0) {
                intent2 = buildLaunchIntent.intent;
            }
            return buildLaunchIntent.copy(intent2);
        }

        public final Intent component1() {
            return this.intent;
        }

        public final BuildLaunchIntent copy(Intent intent2) {
            Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            return new BuildLaunchIntent(intent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BuildLaunchIntent) && Intrinsics.areEqual(this.intent, ((BuildLaunchIntent) obj).intent);
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public int hashCode() {
            return this.intent.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("BuildLaunchIntent(intent=");
            outline73.append(this.intent);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$BuildNotification;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "notification", "Landroid/app/Notification;", "(Landroid/app/Notification;)V", "getNotification", "()Landroid/app/Notification;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class BuildNotification extends MPLNotificationStates {
        public final Notification notification;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public BuildNotification(Notification notification2) {
            // Intrinsics.checkNotNullParameter(notification2, "notification");
            super(null);
            this.notification = notification2;
        }

        public static /* synthetic */ BuildNotification copy$default(BuildNotification buildNotification, Notification notification2, int i, Object obj) {
            if ((i & 1) != 0) {
                notification2 = buildNotification.notification;
            }
            return buildNotification.copy(notification2);
        }

        public final Notification component1() {
            return this.notification;
        }

        public final BuildNotification copy(Notification notification2) {
            Intrinsics.checkNotNullParameter(notification2, "notification");
            return new BuildNotification(notification2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BuildNotification) && Intrinsics.areEqual(this.notification, ((BuildNotification) obj).notification);
        }

        public final Notification getNotification() {
            return this.notification;
        }

        public int hashCode() {
            return this.notification.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("BuildNotification(notification=");
            outline73.append(this.notification);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$ErrorState;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class ErrorState extends MPLNotificationStates {
        public final String errorMessage;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ErrorState(String str) {
            // Intrinsics.checkNotNullParameter(str, "errorMessage");
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ ErrorState copy$default(ErrorState errorState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorState.errorMessage;
            }
            return errorState.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ErrorState copy(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new ErrorState(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorState) && Intrinsics.areEqual(this.errorMessage, ((ErrorState) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ErrorState(errorMessage="), this.errorMessage, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$InitialState;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class InitialState extends MPLNotificationStates {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$IsAppIsInBackground;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "isInBackground", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class IsAppIsInBackground extends MPLNotificationStates {
        public final boolean isInBackground;

        public IsAppIsInBackground(boolean z) {
            super(null);
            this.isInBackground = z;
        }

        public static /* synthetic */ IsAppIsInBackground copy$default(IsAppIsInBackground isAppIsInBackground, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = isAppIsInBackground.isInBackground;
            }
            return isAppIsInBackground.copy(z);
        }

        public final boolean component1() {
            return this.isInBackground;
        }

        public final IsAppIsInBackground copy(boolean z) {
            return new IsAppIsInBackground(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IsAppIsInBackground) && this.isInBackground == ((IsAppIsInBackground) obj).isInBackground;
        }

        public int hashCode() {
            boolean z = this.isInBackground;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isInBackground() {
            return this.isInBackground;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("IsAppIsInBackground(isInBackground="), this.isInBackground, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationChannel;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class NotificationChannel extends MPLNotificationStates {
        public final String channelId;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public NotificationChannel(String str) {
            // Intrinsics.checkNotNullParameter(str, "channelId");
            super(null);
            this.channelId = str;
        }

        public static /* synthetic */ NotificationChannel copy$default(NotificationChannel notificationChannel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notificationChannel.channelId;
            }
            return notificationChannel.copy(str);
        }

        public final String component1() {
            return this.channelId;
        }

        public final NotificationChannel copy(String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new NotificationChannel(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationChannel) && Intrinsics.areEqual(this.channelId, ((NotificationChannel) obj).channelId);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            return this.channelId.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("NotificationChannel(channelId="), this.channelId, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationEventPublished;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class NotificationEventPublished extends MPLNotificationStates {
        public static final NotificationEventPublished INSTANCE = new NotificationEventPublished();

        public NotificationEventPublished() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationPriority;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "priority", "", "(I)V", "getPriority", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class NotificationPriority extends MPLNotificationStates {
        public final int priority;

        public NotificationPriority(int i) {
            super(null);
            this.priority = i;
        }

        public static /* synthetic */ NotificationPriority copy$default(NotificationPriority notificationPriority, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = notificationPriority.priority;
            }
            return notificationPriority.copy(i);
        }

        public final int component1() {
            return this.priority;
        }

        public final NotificationPriority copy(int i) {
            return new NotificationPriority(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationPriority) && this.priority == ((NotificationPriority) obj).priority;
        }

        public final int getPriority() {
            return this.priority;
        }

        public int hashCode() {
            return this.priority;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline56(GeneratedOutlineSupport.outline73("NotificationPriority(priority="), this.priority, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationPublished;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "notificationId", "", "(I)V", "getNotificationId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class NotificationPublished extends MPLNotificationStates {
        public final int notificationId;

        public NotificationPublished(int i) {
            super(null);
            this.notificationId = i;
        }

        public static /* synthetic */ NotificationPublished copy$default(NotificationPublished notificationPublished, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = notificationPublished.notificationId;
            }
            return notificationPublished.copy(i);
        }

        public final int component1() {
            return this.notificationId;
        }

        public final NotificationPublished copy(int i) {
            return new NotificationPublished(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationPublished) && this.notificationId == ((NotificationPublished) obj).notificationId;
        }

        public final int getNotificationId() {
            return this.notificationId;
        }

        public int hashCode() {
            return this.notificationId;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline56(GeneratedOutlineSupport.outline73("NotificationPublished(notificationId="), this.notificationId, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/notification/states/MPLNotificationStates$NotificationTimerSuccessful;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLNotificationStates.kt */
    public static final class NotificationTimerSuccessful extends MPLNotificationStates {
        public static final NotificationTimerSuccessful INSTANCE = new NotificationTimerSuccessful();

        public NotificationTimerSuccessful() {
            super(null);
        }
    }

    public MPLNotificationStates() {
    }

    public /* synthetic */ MPLNotificationStates(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
