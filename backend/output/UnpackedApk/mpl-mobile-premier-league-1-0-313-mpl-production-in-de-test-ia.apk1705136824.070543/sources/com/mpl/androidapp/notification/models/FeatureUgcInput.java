package com.mpl.androidapp.notification.models;

import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\bO\b\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n¢\u0006\u0002\u0010\u0019J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\nHÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\nHÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003JÇ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\nHÆ\u0001J\u0013\u0010W\u001a\u00020\n2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u0006HÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010$\"\u0004\b'\u0010&R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010$\"\u0004\b(\u0010&R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010$\"\u0004\b)\u0010&R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010$\"\u0004\b*\u0010&R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001d¨\u0006["}, d2 = {"Lcom/mpl/androidapp/notification/models/FeatureUgcInput;", "", "title", "", "message", "gameId", "", "tournamentId", "featureName", "sendEvent", "", "timerDuration", "", "isAppBackgroundConditionChecked", "isUserPlayingGame", "notificationLargeIcon", "notificationSmallIcon", "notificationColor", "deviceOsVersion", "pendingIntentRequestCode", "setAutoCancel", "isTimerPresentForNotification", "setDefaults", "isSoundEnabled", "isVibrationEnabled", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZJZZIIIIIZZIZZ)V", "getDeviceOsVersion", "()I", "setDeviceOsVersion", "(I)V", "getFeatureName", "()Ljava/lang/String;", "setFeatureName", "(Ljava/lang/String;)V", "getGameId", "setGameId", "()Z", "setAppBackgroundConditionChecked", "(Z)V", "setSoundEnabled", "setTimerPresentForNotification", "setUserPlayingGame", "setVibrationEnabled", "getMessage", "setMessage", "getNotificationColor", "setNotificationColor", "getNotificationLargeIcon", "setNotificationLargeIcon", "getNotificationSmallIcon", "setNotificationSmallIcon", "getPendingIntentRequestCode", "setPendingIntentRequestCode", "getSendEvent", "setSendEvent", "getSetAutoCancel", "setSetAutoCancel", "getSetDefaults", "setSetDefaults", "getTimerDuration", "()J", "setTimerDuration", "(J)V", "getTitle", "setTitle", "getTournamentId", "setTournamentId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeatureUgcInput.kt */
public final class FeatureUgcInput {
    public int deviceOsVersion;
    public String featureName;
    public int gameId;
    public boolean isAppBackgroundConditionChecked;
    public boolean isSoundEnabled;
    public boolean isTimerPresentForNotification;
    public boolean isUserPlayingGame;
    public boolean isVibrationEnabled;
    public String message;
    public int notificationColor;
    public int notificationLargeIcon;
    public int notificationSmallIcon;
    public int pendingIntentRequestCode;
    public boolean sendEvent;
    public boolean setAutoCancel;
    public int setDefaults;
    public long timerDuration;
    public String title;
    public int tournamentId;

    public FeatureUgcInput(String str, String str2, int i, int i2, String str3, boolean z, long j, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, boolean z4, boolean z5, int i8, boolean z6, boolean z7) {
        String str4 = str;
        GeneratedOutlineSupport.outline97(str4, "title", str2, "message", str3, "featureName");
        this.title = str4;
        this.message = str2;
        this.gameId = i;
        this.tournamentId = i2;
        this.featureName = str3;
        this.sendEvent = z;
        this.timerDuration = j;
        this.isAppBackgroundConditionChecked = z2;
        this.isUserPlayingGame = z3;
        this.notificationLargeIcon = i3;
        this.notificationSmallIcon = i4;
        this.notificationColor = i5;
        this.deviceOsVersion = i6;
        this.pendingIntentRequestCode = i7;
        this.setAutoCancel = z4;
        this.isTimerPresentForNotification = z5;
        this.setDefaults = i8;
        this.isSoundEnabled = z6;
        this.isVibrationEnabled = z7;
    }

    public static /* synthetic */ FeatureUgcInput copy$default(FeatureUgcInput featureUgcInput, String str, String str2, int i, int i2, String str3, boolean z, long j, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, boolean z4, boolean z5, int i8, boolean z6, boolean z7, int i9, Object obj) {
        FeatureUgcInput featureUgcInput2 = featureUgcInput;
        int i10 = i9;
        return featureUgcInput.copy((i10 & 1) != 0 ? featureUgcInput2.title : str, (i10 & 2) != 0 ? featureUgcInput2.message : str2, (i10 & 4) != 0 ? featureUgcInput2.gameId : i, (i10 & 8) != 0 ? featureUgcInput2.tournamentId : i2, (i10 & 16) != 0 ? featureUgcInput2.featureName : str3, (i10 & 32) != 0 ? featureUgcInput2.sendEvent : z, (i10 & 64) != 0 ? featureUgcInput2.timerDuration : j, (i10 & 128) != 0 ? featureUgcInput2.isAppBackgroundConditionChecked : z2, (i10 & 256) != 0 ? featureUgcInput2.isUserPlayingGame : z3, (i10 & 512) != 0 ? featureUgcInput2.notificationLargeIcon : i3, (i10 & 1024) != 0 ? featureUgcInput2.notificationSmallIcon : i4, (i10 & 2048) != 0 ? featureUgcInput2.notificationColor : i5, (i10 & 4096) != 0 ? featureUgcInput2.deviceOsVersion : i6, (i10 & 8192) != 0 ? featureUgcInput2.pendingIntentRequestCode : i7, (i10 & 16384) != 0 ? featureUgcInput2.setAutoCancel : z4, (i10 & 32768) != 0 ? featureUgcInput2.isTimerPresentForNotification : z5, (i10 & 65536) != 0 ? featureUgcInput2.setDefaults : i8, (i10 & 131072) != 0 ? featureUgcInput2.isSoundEnabled : z6, (i10 & 262144) != 0 ? featureUgcInput2.isVibrationEnabled : z7);
    }

    public final String component1() {
        return this.title;
    }

    public final int component10() {
        return this.notificationLargeIcon;
    }

    public final int component11() {
        return this.notificationSmallIcon;
    }

    public final int component12() {
        return this.notificationColor;
    }

    public final int component13() {
        return this.deviceOsVersion;
    }

    public final int component14() {
        return this.pendingIntentRequestCode;
    }

    public final boolean component15() {
        return this.setAutoCancel;
    }

    public final boolean component16() {
        return this.isTimerPresentForNotification;
    }

    public final int component17() {
        return this.setDefaults;
    }

    public final boolean component18() {
        return this.isSoundEnabled;
    }

    public final boolean component19() {
        return this.isVibrationEnabled;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.gameId;
    }

    public final int component4() {
        return this.tournamentId;
    }

    public final String component5() {
        return this.featureName;
    }

    public final boolean component6() {
        return this.sendEvent;
    }

    public final long component7() {
        return this.timerDuration;
    }

    public final boolean component8() {
        return this.isAppBackgroundConditionChecked;
    }

    public final boolean component9() {
        return this.isUserPlayingGame;
    }

    public final FeatureUgcInput copy(String str, String str2, int i, int i2, String str3, boolean z, long j, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, boolean z4, boolean z5, int i8, boolean z6, boolean z7) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "featureName");
        FeatureUgcInput featureUgcInput = new FeatureUgcInput(str4, str2, i, i2, str3, z, j, z2, z3, i3, i4, i5, i6, i7, z4, z5, i8, z6, z7);
        return featureUgcInput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureUgcInput)) {
            return false;
        }
        FeatureUgcInput featureUgcInput = (FeatureUgcInput) obj;
        return Intrinsics.areEqual(this.title, featureUgcInput.title) && Intrinsics.areEqual(this.message, featureUgcInput.message) && this.gameId == featureUgcInput.gameId && this.tournamentId == featureUgcInput.tournamentId && Intrinsics.areEqual(this.featureName, featureUgcInput.featureName) && this.sendEvent == featureUgcInput.sendEvent && this.timerDuration == featureUgcInput.timerDuration && this.isAppBackgroundConditionChecked == featureUgcInput.isAppBackgroundConditionChecked && this.isUserPlayingGame == featureUgcInput.isUserPlayingGame && this.notificationLargeIcon == featureUgcInput.notificationLargeIcon && this.notificationSmallIcon == featureUgcInput.notificationSmallIcon && this.notificationColor == featureUgcInput.notificationColor && this.deviceOsVersion == featureUgcInput.deviceOsVersion && this.pendingIntentRequestCode == featureUgcInput.pendingIntentRequestCode && this.setAutoCancel == featureUgcInput.setAutoCancel && this.isTimerPresentForNotification == featureUgcInput.isTimerPresentForNotification && this.setDefaults == featureUgcInput.setDefaults && this.isSoundEnabled == featureUgcInput.isSoundEnabled && this.isVibrationEnabled == featureUgcInput.isVibrationEnabled;
    }

    public final int getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getNotificationColor() {
        return this.notificationColor;
    }

    public final int getNotificationLargeIcon() {
        return this.notificationLargeIcon;
    }

    public final int getNotificationSmallIcon() {
        return this.notificationSmallIcon;
    }

    public final int getPendingIntentRequestCode() {
        return this.pendingIntentRequestCode;
    }

    public final boolean getSendEvent() {
        return this.sendEvent;
    }

    public final boolean getSetAutoCancel() {
        return this.setAutoCancel;
    }

    public final int getSetDefaults() {
        return this.setDefaults;
    }

    public final long getTimerDuration() {
        return this.timerDuration;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTournamentId() {
        return this.tournamentId;
    }

    public int hashCode() {
        String str = this.message;
        int outline11 = GeneratedOutlineSupport.outline11(this.featureName, (((GeneratedOutlineSupport.outline11(str, this.title.hashCode() * 31, 31) + this.gameId) * 31) + this.tournamentId) * 31, 31);
        boolean z = this.sendEvent;
        int i = 1;
        if (z) {
            z = true;
        }
        int hashCode = (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.timerDuration) + ((outline11 + (z ? 1 : 0)) * 31)) * 31;
        boolean z2 = this.isAppBackgroundConditionChecked;
        if (z2) {
            z2 = true;
        }
        int i2 = (hashCode + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isUserPlayingGame;
        if (z3) {
            z3 = true;
        }
        int i3 = (((((((((((i2 + (z3 ? 1 : 0)) * 31) + this.notificationLargeIcon) * 31) + this.notificationSmallIcon) * 31) + this.notificationColor) * 31) + this.deviceOsVersion) * 31) + this.pendingIntentRequestCode) * 31;
        boolean z4 = this.setAutoCancel;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isTimerPresentForNotification;
        if (z5) {
            z5 = true;
        }
        int i5 = (((i4 + (z5 ? 1 : 0)) * 31) + this.setDefaults) * 31;
        boolean z6 = this.isSoundEnabled;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isVibrationEnabled;
        if (!z7) {
            i = z7;
        }
        return i6 + i;
    }

    public final boolean isAppBackgroundConditionChecked() {
        return this.isAppBackgroundConditionChecked;
    }

    public final boolean isSoundEnabled() {
        return this.isSoundEnabled;
    }

    public final boolean isTimerPresentForNotification() {
        return this.isTimerPresentForNotification;
    }

    public final boolean isUserPlayingGame() {
        return this.isUserPlayingGame;
    }

    public final boolean isVibrationEnabled() {
        return this.isVibrationEnabled;
    }

    public final void setAppBackgroundConditionChecked(boolean z) {
        this.isAppBackgroundConditionChecked = z;
    }

    public final void setDeviceOsVersion(int i) {
        this.deviceOsVersion = i;
    }

    public final void setFeatureName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.featureName = str;
    }

    public final void setGameId(int i) {
        this.gameId = i;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setNotificationColor(int i) {
        this.notificationColor = i;
    }

    public final void setNotificationLargeIcon(int i) {
        this.notificationLargeIcon = i;
    }

    public final void setNotificationSmallIcon(int i) {
        this.notificationSmallIcon = i;
    }

    public final void setPendingIntentRequestCode(int i) {
        this.pendingIntentRequestCode = i;
    }

    public final void setSendEvent(boolean z) {
        this.sendEvent = z;
    }

    public final void setSetAutoCancel(boolean z) {
        this.setAutoCancel = z;
    }

    public final void setSetDefaults(int i) {
        this.setDefaults = i;
    }

    public final void setSoundEnabled(boolean z) {
        this.isSoundEnabled = z;
    }

    public final void setTimerDuration(long j) {
        this.timerDuration = j;
    }

    public final void setTimerPresentForNotification(boolean z) {
        this.isTimerPresentForNotification = z;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTournamentId(int i) {
        this.tournamentId = i;
    }

    public final void setUserPlayingGame(boolean z) {
        this.isUserPlayingGame = z;
    }

    public final void setVibrationEnabled(boolean z) {
        this.isVibrationEnabled = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FeatureUgcInput(title=");
        outline73.append(this.title);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", gameId=");
        outline73.append(this.gameId);
        outline73.append(", tournamentId=");
        outline73.append(this.tournamentId);
        outline73.append(", featureName=");
        outline73.append(this.featureName);
        outline73.append(", sendEvent=");
        outline73.append(this.sendEvent);
        outline73.append(", timerDuration=");
        outline73.append(this.timerDuration);
        outline73.append(", isAppBackgroundConditionChecked=");
        outline73.append(this.isAppBackgroundConditionChecked);
        outline73.append(", isUserPlayingGame=");
        outline73.append(this.isUserPlayingGame);
        outline73.append(", notificationLargeIcon=");
        outline73.append(this.notificationLargeIcon);
        outline73.append(", notificationSmallIcon=");
        outline73.append(this.notificationSmallIcon);
        outline73.append(", notificationColor=");
        outline73.append(this.notificationColor);
        outline73.append(", deviceOsVersion=");
        outline73.append(this.deviceOsVersion);
        outline73.append(", pendingIntentRequestCode=");
        outline73.append(this.pendingIntentRequestCode);
        outline73.append(", setAutoCancel=");
        outline73.append(this.setAutoCancel);
        outline73.append(", isTimerPresentForNotification=");
        outline73.append(this.isTimerPresentForNotification);
        outline73.append(", setDefaults=");
        outline73.append(this.setDefaults);
        outline73.append(", isSoundEnabled=");
        outline73.append(this.isSoundEnabled);
        outline73.append(", isVibrationEnabled=");
        return GeneratedOutlineSupport.outline65(outline73, this.isVibrationEnabled, ')');
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public /* synthetic */ FeatureUgcInput(String str, String str2, int i, int i2, String str3, boolean z, long j, boolean z2, boolean z3, int i3, int i4, int i5, int i6, int i7, boolean z4, boolean z5, int i8, boolean z6, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        // int i10 = i9;
        this((i10 & 1) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str, (i10 & 2) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str2, (i10 & 4) != 0 ? 0 : i, (i10 & 8) != 0 ? 0 : i2, (i10 & 16) != 0 ? StringExtKt.getEMPTY(StringCompanionObject.INSTANCE) : str3, (i10 & 32) != 0 ? false : z, (i10 & 64) != 0 ? 0 : j, (i10 & 128) != 0 ? false : z2, (i10 & 256) != 0 ? false : z3, i3, i4, i5, (i10 & 4096) != 0 ? VERSION.SDK_INT : i6, i7, (i10 & 16384) != 0 ? true : z4, (32768 & i10) != 0 ? false : z5, (65536 & i10) != 0 ? 1 : i8, (131072 & i10) != 0 ? false : z6, (i10 & 262144) != 0 ? false : z7);
    }
}
