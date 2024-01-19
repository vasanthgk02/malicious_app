package com.netcore.android.notification.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.netcore.android.notification.SMTNotificationConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002&%B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\nR$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\nR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R$\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\n¨\u0006'"}, d2 = {"Lcom/netcore/android/notification/models/SMTActionButtonData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<set-?>", "snoozeInterval", "I", "getSnoozeInterval", "actionType", "getActionType", "", "actionName", "Ljava/lang/String;", "getActionName", "()Ljava/lang/String;", "actionDeeplink", "getActionDeeplink", "copyTxt", "getCopyTxt", "replyResponse", "getReplyResponse", "setReplyResponse", "(Ljava/lang/String;)V", "openApp", "getOpenApp", "Lcom/netcore/android/notification/models/SMTActionButtonData$ActionButtonBuilder;", "builder", "<init>", "(Lcom/netcore/android/notification/models/SMTActionButtonData$ActionButtonBuilder;)V", "(Landroid/os/Parcel;)V", "CREATOR", "ActionButtonBuilder", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTActionButtonData.kt */
public final class SMTActionButtonData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    public String actionDeeplink;
    public String actionName;
    public int actionType;
    public String copyTxt;
    public int openApp;
    public String replyResponse;
    public int snoozeInterval;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0013\u0010\u001aR$\u0010\f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b \u0010\u001fR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b!\u0010\u001fR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\"\u0010\u0019R$\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b#\u0010\u0019¨\u0006&"}, d2 = {"Lcom/netcore/android/notification/models/SMTActionButtonData$ActionButtonBuilder;", "", "", "actionName", "setActionName", "(Ljava/lang/String;)Lcom/netcore/android/notification/models/SMTActionButtonData$ActionButtonBuilder;", "actionDeeplink", "setActionDeeplink", "", "actionType", "setActionType", "(I)Lcom/netcore/android/notification/models/SMTActionButtonData$ActionButtonBuilder;", "copyTxt", "setCopyText", "openApp", "setOpenApp", "snoozeInterval", "setSnoozeInterval", "replyResponse", "setReplyResponse", "Lcom/netcore/android/notification/models/SMTActionButtonData;", "build", "()Lcom/netcore/android/notification/models/SMTActionButtonData;", "Ljava/lang/String;", "getReplyResponse", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "<set-?>", "getCopyTxt", "I", "getSnoozeInterval", "()I", "getActionType", "getOpenApp", "getActionName", "getActionDeeplink", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTActionButtonData.kt */
    public static final class ActionButtonBuilder {
        public String actionDeeplink = "";
        public String actionName = "";
        public int actionType = -1;
        public String copyTxt = "";
        public int openApp;
        public String replyResponse = "";
        public int snoozeInterval;

        public final SMTActionButtonData build() {
            return new SMTActionButtonData(this);
        }

        public final String getActionDeeplink() {
            return this.actionDeeplink;
        }

        public final String getActionName() {
            return this.actionName;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final String getCopyTxt() {
            return this.copyTxt;
        }

        public final int getOpenApp() {
            return this.openApp;
        }

        public final String getReplyResponse() {
            return this.replyResponse;
        }

        public final int getSnoozeInterval() {
            return this.snoozeInterval;
        }

        public final ActionButtonBuilder setActionDeeplink(String str) {
            Intrinsics.checkNotNullParameter(str, SMTNotificationConstants.NOTIF_ACTION_DEEPLINK_KEY);
            this.actionDeeplink = str;
            return this;
        }

        public final ActionButtonBuilder setActionName(String str) {
            Intrinsics.checkNotNullParameter(str, SMTNotificationConstants.NOTIF_ACTION_NAME_KEY);
            this.actionName = str;
            return this;
        }

        public final ActionButtonBuilder setActionType(int i) {
            this.actionType = i;
            return this;
        }

        public final ActionButtonBuilder setCopyText(String str) {
            Intrinsics.checkNotNullParameter(str, "copyTxt");
            this.copyTxt = str;
            return this;
        }

        public final ActionButtonBuilder setOpenApp(int i) {
            this.openApp = i;
            return this;
        }

        /* renamed from: setReplyResponse  reason: collision with other method in class */
        public final void m31setReplyResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.replyResponse = str;
        }

        public final ActionButtonBuilder setSnoozeInterval(int i) {
            this.snoozeInterval = i;
            return this;
        }

        public final ActionButtonBuilder setReplyResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "replyResponse");
            this.replyResponse = str;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/notification/models/SMTActionButtonData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/netcore/android/notification/models/SMTActionButtonData;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/netcore/android/notification/models/SMTActionButtonData;", "", "size", "", "newArray", "(I)[Lcom/netcore/android/notification/models/SMTActionButtonData;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTActionButtonData.kt */
    public static final class CREATOR implements Creator<SMTActionButtonData> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public SMTActionButtonData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SMTActionButtonData(parcel);
        }

        public SMTActionButtonData[] newArray(int i) {
            return new SMTActionButtonData[i];
        }
    }

    public SMTActionButtonData(ActionButtonBuilder actionButtonBuilder) {
        Intrinsics.checkNotNullParameter(actionButtonBuilder, "builder");
        this.actionName = "";
        this.actionDeeplink = "";
        this.actionType = -1;
        this.copyTxt = "";
        this.replyResponse = "";
        this.actionName = actionButtonBuilder.getActionName();
        this.actionDeeplink = actionButtonBuilder.getActionDeeplink();
        this.actionType = actionButtonBuilder.getActionType();
        this.copyTxt = actionButtonBuilder.getCopyTxt();
        this.openApp = actionButtonBuilder.getOpenApp();
        this.snoozeInterval = actionButtonBuilder.getSnoozeInterval();
        this.replyResponse = actionButtonBuilder.getReplyResponse();
    }

    public int describeContents() {
        return 0;
    }

    public final String getActionDeeplink() {
        return this.actionDeeplink;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getCopyTxt() {
        return this.copyTxt;
    }

    public final int getOpenApp() {
        return this.openApp;
    }

    public final String getReplyResponse() {
        return this.replyResponse;
    }

    public final int getSnoozeInterval() {
        return this.snoozeInterval;
    }

    public final void setReplyResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyResponse = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.actionName);
        parcel.writeString(this.actionDeeplink);
        parcel.writeInt(this.actionType);
        parcel.writeString(this.copyTxt);
        parcel.writeInt(this.openApp);
        parcel.writeInt(this.snoozeInterval);
        parcel.writeString(this.replyResponse);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SMTActionButtonData(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        // String str = "";
        // ActionButtonBuilder snoozeInterval2 = new ActionButtonBuilder().setActionName(parcel.readString() == null ? str : parcel.readString()).setActionDeeplink(parcel.readString() == null ? str : parcel.readString()).setActionType(parcel.readInt()).setCopyText(parcel.readString() == null ? str : parcel.readString()).setOpenApp(parcel.readInt()).setSnoozeInterval(parcel.readInt());
        // String readString = parcel.readString();
        this(snoozeInterval2.setReplyResponse(readString != null ? readString : str));
    }
}
