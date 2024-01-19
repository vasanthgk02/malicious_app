package com.mpl.androidapp.notification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/notification/models/NotificationLaunchIntentInput;", "", "gameId", "", "tournamentId", "notificationId", "featureName", "", "(IIILjava/lang/String;)V", "getFeatureName", "()Ljava/lang/String;", "getGameId", "()I", "getNotificationId", "getTournamentId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationLaunchIntentInput.kt */
public final class NotificationLaunchIntentInput {
    public final String featureName;
    public final int gameId;
    public final int notificationId;
    public final int tournamentId;

    public NotificationLaunchIntentInput(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "featureName");
        this.gameId = i;
        this.tournamentId = i2;
        this.notificationId = i3;
        this.featureName = str;
    }

    public static /* synthetic */ NotificationLaunchIntentInput copy$default(NotificationLaunchIntentInput notificationLaunchIntentInput, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = notificationLaunchIntentInput.gameId;
        }
        if ((i4 & 2) != 0) {
            i2 = notificationLaunchIntentInput.tournamentId;
        }
        if ((i4 & 4) != 0) {
            i3 = notificationLaunchIntentInput.notificationId;
        }
        if ((i4 & 8) != 0) {
            str = notificationLaunchIntentInput.featureName;
        }
        return notificationLaunchIntentInput.copy(i, i2, i3, str);
    }

    public final int component1() {
        return this.gameId;
    }

    public final int component2() {
        return this.tournamentId;
    }

    public final int component3() {
        return this.notificationId;
    }

    public final String component4() {
        return this.featureName;
    }

    public final NotificationLaunchIntentInput copy(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "featureName");
        return new NotificationLaunchIntentInput(i, i2, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationLaunchIntentInput)) {
            return false;
        }
        NotificationLaunchIntentInput notificationLaunchIntentInput = (NotificationLaunchIntentInput) obj;
        return this.gameId == notificationLaunchIntentInput.gameId && this.tournamentId == notificationLaunchIntentInput.tournamentId && this.notificationId == notificationLaunchIntentInput.notificationId && Intrinsics.areEqual(this.featureName, notificationLaunchIntentInput.featureName);
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final int getTournamentId() {
        return this.tournamentId;
    }

    public int hashCode() {
        return this.featureName.hashCode() + (((((this.gameId * 31) + this.tournamentId) * 31) + this.notificationId) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationLaunchIntentInput(gameId=");
        outline73.append(this.gameId);
        outline73.append(", tournamentId=");
        outline73.append(this.tournamentId);
        outline73.append(", notificationId=");
        outline73.append(this.notificationId);
        outline73.append(", featureName=");
        return GeneratedOutlineSupport.outline59(outline73, this.featureName, ')');
    }
}
