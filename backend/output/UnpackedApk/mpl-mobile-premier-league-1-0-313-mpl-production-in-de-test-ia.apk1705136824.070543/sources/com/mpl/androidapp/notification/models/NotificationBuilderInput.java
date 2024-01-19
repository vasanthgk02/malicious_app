package com.mpl.androidapp.notification.models;

import android.content.Intent;
import android.graphics.Bitmap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00067"}, d2 = {"Lcom/mpl/androidapp/notification/models/NotificationBuilderInput;", "", "title", "", "message", "notificationLargeIcon", "Landroid/graphics/Bitmap;", "notificationSmallIcon", "", "notificationColor", "pendingIntentRequestCode", "intent", "Landroid/content/Intent;", "priority", "setAutoCancel", "", "isSoundEnabled", "isVibrationEnabled", "setDefaults", "channelId", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;IIILandroid/content/Intent;IZZZILjava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getIntent", "()Landroid/content/Intent;", "()Z", "getMessage", "getNotificationColor", "()I", "getNotificationLargeIcon", "()Landroid/graphics/Bitmap;", "getNotificationSmallIcon", "getPendingIntentRequestCode", "getPriority", "getSetAutoCancel", "getSetDefaults", "getTitle", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationBuilderInput.kt */
public final class NotificationBuilderInput {
    public final String channelId;
    public final Intent intent;
    public final boolean isSoundEnabled;
    public final boolean isVibrationEnabled;
    public final String message;
    public final int notificationColor;
    public final Bitmap notificationLargeIcon;
    public final int notificationSmallIcon;
    public final int pendingIntentRequestCode;
    public final int priority;
    public final boolean setAutoCancel;
    public final int setDefaults;
    public final String title;

    public NotificationBuilderInput(String str, String str2, Bitmap bitmap, int i, int i2, int i3, Intent intent2, int i4, boolean z, boolean z2, boolean z3, int i5, String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(bitmap, "notificationLargeIcon");
        Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
        Intrinsics.checkNotNullParameter(str3, "channelId");
        this.title = str;
        this.message = str2;
        this.notificationLargeIcon = bitmap;
        this.notificationSmallIcon = i;
        this.notificationColor = i2;
        this.pendingIntentRequestCode = i3;
        this.intent = intent2;
        this.priority = i4;
        this.setAutoCancel = z;
        this.isSoundEnabled = z2;
        this.isVibrationEnabled = z3;
        this.setDefaults = i5;
        this.channelId = str3;
    }

    public static /* synthetic */ NotificationBuilderInput copy$default(NotificationBuilderInput notificationBuilderInput, String str, String str2, Bitmap bitmap, int i, int i2, int i3, Intent intent2, int i4, boolean z, boolean z2, boolean z3, int i5, String str3, int i6, Object obj) {
        NotificationBuilderInput notificationBuilderInput2 = notificationBuilderInput;
        int i7 = i6;
        return notificationBuilderInput.copy((i7 & 1) != 0 ? notificationBuilderInput2.title : str, (i7 & 2) != 0 ? notificationBuilderInput2.message : str2, (i7 & 4) != 0 ? notificationBuilderInput2.notificationLargeIcon : bitmap, (i7 & 8) != 0 ? notificationBuilderInput2.notificationSmallIcon : i, (i7 & 16) != 0 ? notificationBuilderInput2.notificationColor : i2, (i7 & 32) != 0 ? notificationBuilderInput2.pendingIntentRequestCode : i3, (i7 & 64) != 0 ? notificationBuilderInput2.intent : intent2, (i7 & 128) != 0 ? notificationBuilderInput2.priority : i4, (i7 & 256) != 0 ? notificationBuilderInput2.setAutoCancel : z, (i7 & 512) != 0 ? notificationBuilderInput2.isSoundEnabled : z2, (i7 & 1024) != 0 ? notificationBuilderInput2.isVibrationEnabled : z3, (i7 & 2048) != 0 ? notificationBuilderInput2.setDefaults : i5, (i7 & 4096) != 0 ? notificationBuilderInput2.channelId : str3);
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.isSoundEnabled;
    }

    public final boolean component11() {
        return this.isVibrationEnabled;
    }

    public final int component12() {
        return this.setDefaults;
    }

    public final String component13() {
        return this.channelId;
    }

    public final String component2() {
        return this.message;
    }

    public final Bitmap component3() {
        return this.notificationLargeIcon;
    }

    public final int component4() {
        return this.notificationSmallIcon;
    }

    public final int component5() {
        return this.notificationColor;
    }

    public final int component6() {
        return this.pendingIntentRequestCode;
    }

    public final Intent component7() {
        return this.intent;
    }

    public final int component8() {
        return this.priority;
    }

    public final boolean component9() {
        return this.setAutoCancel;
    }

    public final NotificationBuilderInput copy(String str, String str2, Bitmap bitmap, int i, int i2, int i3, Intent intent2, int i4, boolean z, boolean z2, boolean z3, int i5, String str3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "title");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "message");
        Bitmap bitmap2 = bitmap;
        Intrinsics.checkNotNullParameter(bitmap2, "notificationLargeIcon");
        Intent intent3 = intent2;
        Intrinsics.checkNotNullParameter(intent3, AnalyticsConstants.INTENT);
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "channelId");
        NotificationBuilderInput notificationBuilderInput = new NotificationBuilderInput(str4, str5, bitmap2, i, i2, i3, intent3, i4, z, z2, z3, i5, str6);
        return notificationBuilderInput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationBuilderInput)) {
            return false;
        }
        NotificationBuilderInput notificationBuilderInput = (NotificationBuilderInput) obj;
        return Intrinsics.areEqual(this.title, notificationBuilderInput.title) && Intrinsics.areEqual(this.message, notificationBuilderInput.message) && Intrinsics.areEqual(this.notificationLargeIcon, notificationBuilderInput.notificationLargeIcon) && this.notificationSmallIcon == notificationBuilderInput.notificationSmallIcon && this.notificationColor == notificationBuilderInput.notificationColor && this.pendingIntentRequestCode == notificationBuilderInput.pendingIntentRequestCode && Intrinsics.areEqual(this.intent, notificationBuilderInput.intent) && this.priority == notificationBuilderInput.priority && this.setAutoCancel == notificationBuilderInput.setAutoCancel && this.isSoundEnabled == notificationBuilderInput.isSoundEnabled && this.isVibrationEnabled == notificationBuilderInput.isVibrationEnabled && this.setDefaults == notificationBuilderInput.setDefaults && Intrinsics.areEqual(this.channelId, notificationBuilderInput.channelId);
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getNotificationColor() {
        return this.notificationColor;
    }

    public final Bitmap getNotificationLargeIcon() {
        return this.notificationLargeIcon;
    }

    public final int getNotificationSmallIcon() {
        return this.notificationSmallIcon;
    }

    public final int getPendingIntentRequestCode() {
        return this.pendingIntentRequestCode;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getSetAutoCancel() {
        return this.setAutoCancel;
    }

    public final int getSetDefaults() {
        return this.setDefaults;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.message, this.title.hashCode() * 31, 31);
        int hashCode = (((this.intent.hashCode() + ((((((((this.notificationLargeIcon.hashCode() + outline11) * 31) + this.notificationSmallIcon) * 31) + this.notificationColor) * 31) + this.pendingIntentRequestCode) * 31)) * 31) + this.priority) * 31;
        boolean z = this.setAutoCancel;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSoundEnabled;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isVibrationEnabled;
        if (!z3) {
            i = z3;
        }
        return this.channelId.hashCode() + ((((i3 + i) * 31) + this.setDefaults) * 31);
    }

    public final boolean isSoundEnabled() {
        return this.isSoundEnabled;
    }

    public final boolean isVibrationEnabled() {
        return this.isVibrationEnabled;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationBuilderInput(title=");
        outline73.append(this.title);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", notificationLargeIcon=");
        outline73.append(this.notificationLargeIcon);
        outline73.append(", notificationSmallIcon=");
        outline73.append(this.notificationSmallIcon);
        outline73.append(", notificationColor=");
        outline73.append(this.notificationColor);
        outline73.append(", pendingIntentRequestCode=");
        outline73.append(this.pendingIntentRequestCode);
        outline73.append(", intent=");
        outline73.append(this.intent);
        outline73.append(", priority=");
        outline73.append(this.priority);
        outline73.append(", setAutoCancel=");
        outline73.append(this.setAutoCancel);
        outline73.append(", isSoundEnabled=");
        outline73.append(this.isSoundEnabled);
        outline73.append(", isVibrationEnabled=");
        outline73.append(this.isVibrationEnabled);
        outline73.append(", setDefaults=");
        outline73.append(this.setDefaults);
        outline73.append(", channelId=");
        return GeneratedOutlineSupport.outline59(outline73, this.channelId, ')');
    }
}
