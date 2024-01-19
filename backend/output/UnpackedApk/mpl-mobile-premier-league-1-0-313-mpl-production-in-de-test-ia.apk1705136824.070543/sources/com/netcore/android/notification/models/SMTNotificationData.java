package com.netcore.android.notification.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0013\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R(\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R(\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R(\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R$\u0010-\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b.\u0010\nR(\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b0\u0010\u000fR$\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u0002048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b@\u0010\r\u001a\u0004\bA\u0010\u000fR(\u0010B\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bB\u0010\r\u001a\u0004\bC\u0010\u000fR(\u0010D\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bD\u0010\r\u001a\u0004\bE\u0010\u000fR$\u0010F\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bF\u0010\r\u001a\u0004\bG\u0010\u000fR$\u0010H\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010\r\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bK\u0010!\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010$R(\u0010N\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bN\u0010\r\u001a\u0004\bO\u0010\u000fR(\u0010P\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bP\u0010\r\u001a\u0004\bQ\u0010\u000fR\"\u0010R\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bR\u0010!\u001a\u0004\bS\u0010\n\"\u0004\bT\u0010$R\"\u0010U\u001a\u0002048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bU\u0010;\u001a\u0004\bV\u0010=\"\u0004\bW\u0010?R\"\u0010X\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bX\u0010!\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010$Rd\u0010^\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\\\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\\\u0018\u0001`]2&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\\\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\\\u0018\u0001`]8\u0006@BX\u000e¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR$\u0010b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bb\u0010\r\u001a\u0004\bc\u0010\u000fRd\u0010d\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`]2&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`]8\u0006@BX\u000e¢\u0006\f\n\u0004\bd\u0010_\u001a\u0004\be\u0010aR\"\u0010f\u001a\u0002048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bf\u0010;\u001a\u0004\bg\u0010=\"\u0004\bh\u0010?RL\u0010l\u001a\u0016\u0012\u0004\u0012\u00020j\u0018\u00010ij\n\u0012\u0004\u0012\u00020j\u0018\u0001`k2\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020j\u0018\u00010ij\n\u0012\u0004\u0012\u00020j\u0018\u0001`k8\u0006@BX\u000e¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR6\u0010p\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010ij\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`k8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bp\u0010m\u001a\u0004\bq\u0010o\"\u0004\br\u0010sR$\u0010t\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010\r\u001a\u0004\bu\u0010\u000f\"\u0004\bv\u0010\u0011R$\u0010w\u001a\u0002042\u0006\u0010\u0018\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\bw\u0010;\u001a\u0004\bx\u0010=R$\u0010y\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\by\u0010\r\u001a\u0004\bz\u0010\u000f\"\u0004\b{\u0010\u0011R$\u0010|\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b|\u0010\r\u001a\u0004\b}\u0010\u000f\"\u0004\b~\u0010\u0011R&\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\b\u0010\r\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011R&\u0010\u0001\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010!\u001a\u0005\b\u0001\u0010\n\"\u0005\b\u0001\u0010$RS\u0010\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0018\u00010ij\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u0001`k2\u001c\u0010\u0018\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0018\u00010ij\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u0001`k8\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010m\u001a\u0005\b\u0001\u0010oR'\u0010\u0001\u001a\u0002042\u0006\u0010\u0018\u001a\u0002048\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010=¨\u0006\u0001"}, d2 = {"Lcom/netcore/android/notification/models/SMTNotificationData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "mScheduledPNTimeStamp", "Ljava/lang/String;", "getMScheduledPNTimeStamp", "()Ljava/lang/String;", "setMScheduledPNTimeStamp", "(Ljava/lang/String;)V", "mScheduledPNStatus", "getMScheduledPNStatus", "setMScheduledPNStatus", "action", "getAction", "setAction", "<set-?>", "mSoundFile", "getMSoundFile", "mCollapse", "getMCollapse", "setMCollapse", "mChannelId", "getMChannelId", "mIsSnoozedNotification", "I", "getMIsSnoozedNotification", "setMIsSnoozedNotification", "(I)V", "mNotificationType", "getMNotificationType", "setMNotificationType", "mDeepLinkPath", "getMDeepLinkPath", "mTtl", "getMTtl", "setMTtl", "mSource", "getMSource", "mTitleHtml", "getMTitleHtml", "mScheduledDate", "getMScheduledDate", "setMScheduledDate", "", "isPlaying", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setPlaying", "(Ljava/lang/Boolean;)V", "mIsForInbox", "Z", "getMIsForInbox", "()Z", "setMIsForInbox", "(Z)V", "mMediaUrl", "getMMediaUrl", "mMessage", "getMMessage", "mMessageHtml", "getMMessageHtml", "mTrid", "getMTrid", "mPublishedTimeStamp", "getMPublishedTimeStamp", "setMPublishedTimeStamp", "notificationId", "getNotificationId", "setNotificationId", "mSubtitleHtml", "getMSubtitleHtml", "mSubtitle", "getMSubtitle", "mDownloadStatus", "getMDownloadStatus", "setMDownloadStatus", "mIsDownloadInProgress", "getMIsDownloadInProgress", "setMIsDownloadInProgress", "mIsScheduledPN", "getMIsScheduledPN", "setMIsScheduledPN", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mCustomPayload", "Ljava/util/HashMap;", "getMCustomPayload", "()Ljava/util/HashMap;", "mPNMeta", "getMPNMeta", "mSmtAttributePayload", "getMSmtAttributePayload", "mStickyEnabled", "getMStickyEnabled", "setMStickyEnabled", "Ljava/util/ArrayList;", "Lcom/netcore/android/notification/models/SMTActionButtonData;", "Lkotlin/collections/ArrayList;", "mActionButtonList", "Ljava/util/ArrayList;", "getMActionButtonList", "()Ljava/util/ArrayList;", "mRemoveSchedulePn", "getMRemoveSchedulePn", "setMRemoveSchedulePn", "(Ljava/util/ArrayList;)V", "mMediaLocalPath", "getMMediaLocalPath", "setMMediaLocalPath", "mSound", "getMSound", "mStatus", "getMStatus", "setMStatus", "mTitle", "getMTitle", "setMTitle", "mPayload", "getMPayload", "setMPayload", "mSourceType", "getMSourceType", "setMSourceType", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "mCarouselList", "getMCarouselList", "isFromSmartech", "Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "builder", "<init>", "(Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;)V", "(Landroid/os/Parcel;)V", "CREATOR", "NotificationBuilder", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNotificationData.kt */
public final class SMTNotificationData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    public String action;
    public boolean isFromSmartech;
    public Boolean isPlaying;
    public ArrayList<SMTActionButtonData> mActionButtonList;
    public ArrayList<SMTCarouselItemData> mCarouselList;
    public String mChannelId;
    public String mCollapse;
    public HashMap<String, Object> mCustomPayload;
    public String mDeepLinkPath;
    public int mDownloadStatus;
    public boolean mIsDownloadInProgress;
    public boolean mIsForInbox;
    public int mIsScheduledPN;
    public int mIsSnoozedNotification;
    public String mMediaLocalPath;
    public String mMediaUrl;
    public String mMessage;
    public String mMessageHtml;
    public String mNotificationType;
    public String mPNMeta;
    public String mPayload;
    public String mPublishedTimeStamp;
    public ArrayList<String> mRemoveSchedulePn;
    public String mScheduledDate;
    public String mScheduledPNStatus;
    public String mScheduledPNTimeStamp;
    public HashMap<String, String> mSmtAttributePayload;
    public boolean mSound;
    public String mSoundFile;
    public int mSource;
    public int mSourceType;
    public String mStatus;
    public boolean mStickyEnabled;
    public String mSubtitle;
    public String mSubtitleHtml;
    public String mTitle;
    public String mTitleHtml;
    public String mTrid;
    public String mTtl;
    public int notificationId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/notification/models/SMTNotificationData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/netcore/android/notification/models/SMTNotificationData;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/netcore/android/notification/models/SMTNotificationData;", "", "size", "", "newArray", "(I)[Lcom/netcore/android/notification/models/SMTNotificationData;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTNotificationData.kt */
    public static final class CREATOR implements Creator<SMTNotificationData> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public SMTNotificationData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SMTNotificationData(parcel);
        }

        public SMTNotificationData[] newArray(int i) {
            return new SMTNotificationData[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bj\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0012\u001a\u00020\u00002&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0010¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0015\u001a\u00020\u00002&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0010¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0005J%\u0010(\u001a\u00020\u00002\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&¢\u0006\u0004\b(\u0010)J%\u0010,\u001a\u00020\u00002\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020*0$j\b\u0012\u0004\u0012\u00020*`&¢\u0006\u0004\b,\u0010)J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010\u0005J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b/\u0010\u0005J\r\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000203¢\u0006\u0004\b8\u00106J\u0015\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0002¢\u0006\u0004\b:\u0010\u0005J\u0015\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0002¢\u0006\u0004\b<\u0010\u0005J\u0015\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u000b¢\u0006\u0004\b>\u0010\u000eJ\u0015\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u000b¢\u0006\u0004\b@\u0010\u000eJ\u0015\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0002¢\u0006\u0004\bB\u0010\u0005J\u0015\u0010D\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0002¢\u0006\u0004\bD\u0010\u0005J\u0015\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0002¢\u0006\u0004\bF\u0010\u0005J\u0015\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bH\u0010\u0005J\u0015\u0010J\u001a\u00020\u00002\u0006\u0010I\u001a\u000203¢\u0006\u0004\bJ\u00106J\u0015\u0010K\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\bK\u0010\u0005J\u0015\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u000b¢\u0006\u0004\bM\u0010\u000eR$\u0010O\u001a\u0002032\u0006\u0010N\u001a\u0002038\u0006@BX\u000e¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bO\u0010QR(\u0010R\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR(\u0010V\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bV\u0010S\u001a\u0004\bW\u0010UR$\u0010X\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R$\u0010\\\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00028\u0006@BX.¢\u0006\f\n\u0004\b\\\u0010S\u001a\u0004\b]\u0010UR$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b^\u0010S\u001a\u0004\b_\u0010U\"\u0004\b`\u0010aR$\u0010b\u001a\u0002032\u0006\u0010N\u001a\u0002038\u0006@BX\u000e¢\u0006\f\n\u0004\bb\u0010P\u001a\u0004\bc\u0010QR$\u0010d\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bd\u0010Y\u001a\u0004\be\u0010[Rd\u0010f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00102&\u0010N\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00108\u0006@BX\u000e¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR(\u0010j\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bj\u0010S\u001a\u0004\bk\u0010UR(\u0010l\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bl\u0010S\u001a\u0004\bm\u0010UR(\u0010n\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bn\u0010S\u001a\u0004\bo\u0010UR(\u0010p\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bp\u0010S\u001a\u0004\bq\u0010URL\u0010r\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010$j\n\u0012\u0004\u0012\u00020*\u0018\u0001`&2\u001a\u0010N\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010$j\n\u0012\u0004\u0012\u00020*\u0018\u0001`&8\u0006@BX\u000e¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR$\u0010v\u001a\u0002032\u0006\u0010N\u001a\u0002038\u0006@BX\u000e¢\u0006\f\n\u0004\bv\u0010P\u001a\u0004\bw\u0010QR$\u0010x\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00028\u0006@BX.¢\u0006\f\n\u0004\bx\u0010S\u001a\u0004\by\u0010UR(\u0010z\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\bz\u0010S\u001a\u0004\b{\u0010URL\u0010|\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&2\u001a\u0010N\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8\u0006@BX\u000e¢\u0006\f\n\u0004\b|\u0010s\u001a\u0004\b}\u0010uR(\u0010~\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b~\u0010S\u001a\u0004\b\u0010UR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR'\u0010\u0001\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00028\u0006@BX.¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR'\u0010\u0001\u001a\u0002032\u0006\u0010N\u001a\u0002038\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010P\u001a\u0005\b\u0001\u0010QR'\u0010\u0001\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010Y\u001a\u0005\b\u0001\u0010[R+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010U\"\u0005\b\u0001\u0010aR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010UR+\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010S\u001a\u0005\b\u0001\u0010URg\u0010\u0001\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00102&\u0010N\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00108\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010g\u001a\u0005\b\u0001\u0010iR'\u0010\u0001\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010Y\u001a\u0005\b\u0001\u0010[¨\u0006\u0001"}, d2 = {"Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "", "", "status", "setStatus", "(Ljava/lang/String;)Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "timestamp", "setPublishedDate", "setScheduledDate", "ttl", "setTtl", "", "source", "setSource", "(I)Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "payload", "setCustomPayload", "(Ljava/util/HashMap;)Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "attribute", "setSmtAttributePayload", "path", "setDeepLinkPath", "title", "setTitle", "message", "setMessage", "subtitle", "setSubtitle", "trId", "setTrId", "type", "setNotificationType", "pnMeta", "setPNMeta", "Ljava/util/ArrayList;", "Lcom/netcore/android/notification/models/SMTCarouselItemData;", "Lkotlin/collections/ArrayList;", "carousel", "setCarouselList", "(Ljava/util/ArrayList;)Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "Lcom/netcore/android/notification/models/SMTActionButtonData;", "actionButtonList", "setActionButtonList", "url", "setMediaUrl", "setMediaLocalPath", "Lcom/netcore/android/notification/models/SMTNotificationData;", "build", "()Lcom/netcore/android/notification/models/SMTNotificationData;", "", "isSmartech", "setIsFromSmartech", "(Z)Lcom/netcore/android/notification/models/SMTNotificationData$NotificationBuilder;", "sound", "setSound", "soundFile", "setSoundFile", "channelId", "setChannelId", "sourceType", "setSourceType", "isScheduledPN", "setIsScheduledPn", "collapse", "setCollapse", "titleHtml", "setTitleHtml", "messageHtml", "setMessageHtml", "subtitleHtml", "setSubtitleHtml", "enabled", "setStickyEnabled", "setNotificationPayload", "isSnoozedNotification", "setIsSnoozedNotification", "<set-?>", "isFromSmartech", "Z", "()Z", "mMessage", "Ljava/lang/String;", "getMMessage", "()Ljava/lang/String;", "mPublishedTimeStamp", "getMPublishedTimeStamp", "mSourceType", "I", "getMSourceType", "()I", "mNotificationType", "getMNotificationType", "mCollapse", "getMCollapse", "setMCollapse", "(Ljava/lang/String;)V", "mStickyEnabled", "getMStickyEnabled", "mSource", "getMSource", "customPayload", "Ljava/util/HashMap;", "getCustomPayload", "()Ljava/util/HashMap;", "mSoundFile", "getMSoundFile", "mMessageHtml", "getMMessageHtml", "mDeepLinkPath", "getMDeepLinkPath", "mNotifStatus", "getMNotifStatus", "mSMTActionButtonList", "Ljava/util/ArrayList;", "getMSMTActionButtonList", "()Ljava/util/ArrayList;", "mIsHtml", "getMIsHtml", "mPNMeta", "getMPNMeta", "mSubtitle", "getMSubtitle", "mSMTCarouselList", "getMSMTCarouselList", "mScheduledDate", "getMScheduledDate", "mTtl", "getMTtl", "mChannelId", "getMChannelId", "mTrid", "getMTrid", "mTitle", "getMTitle", "mMediaUrl", "getMMediaUrl", "mSound", "getMSound", "mIsSnoozedNotification", "getMIsSnoozedNotification", "mTitleHtml", "getMTitleHtml", "mPayload", "getMPayload", "setMPayload", "mSubtitleHtml", "getMSubtitleHtml", "mMediaLocalPath", "getMMediaLocalPath", "smtAttributePayload", "getSmtAttributePayload", "mIsScheduledPN", "getMIsScheduledPN", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTNotificationData.kt */
    public static final class NotificationBuilder {
        public HashMap<String, Object> customPayload;
        public boolean isFromSmartech;
        public String mChannelId;
        public String mCollapse;
        public String mDeepLinkPath;
        public boolean mIsHtml;
        public int mIsScheduledPN;
        public int mIsSnoozedNotification;
        public String mMediaLocalPath;
        public String mMediaUrl;
        public String mMessage;
        public String mMessageHtml;
        public String mNotifStatus;
        public String mNotificationType;
        public String mPNMeta;
        public String mPayload;
        public String mPublishedTimeStamp;
        public ArrayList<SMTActionButtonData> mSMTActionButtonList;
        public ArrayList<SMTCarouselItemData> mSMTCarouselList;
        public String mScheduledDate;
        public boolean mSound = true;
        public String mSoundFile;
        public int mSource = 1;
        public int mSourceType;
        public boolean mStickyEnabled;
        public String mSubtitle;
        public String mSubtitleHtml;
        public String mTitle;
        public String mTitleHtml;
        public String mTrid;
        public String mTtl;
        public HashMap<String, String> smtAttributePayload;

        public final SMTNotificationData build() {
            return new SMTNotificationData(this);
        }

        public final HashMap<String, Object> getCustomPayload() {
            return this.customPayload;
        }

        public final String getMChannelId() {
            return this.mChannelId;
        }

        public final String getMCollapse() {
            return this.mCollapse;
        }

        public final String getMDeepLinkPath() {
            return this.mDeepLinkPath;
        }

        public final boolean getMIsHtml() {
            return this.mIsHtml;
        }

        public final int getMIsScheduledPN() {
            return this.mIsScheduledPN;
        }

        public final int getMIsSnoozedNotification() {
            return this.mIsSnoozedNotification;
        }

        public final String getMMediaLocalPath() {
            return this.mMediaLocalPath;
        }

        public final String getMMediaUrl() {
            return this.mMediaUrl;
        }

        public final String getMMessage() {
            return this.mMessage;
        }

        public final String getMMessageHtml() {
            return this.mMessageHtml;
        }

        public final String getMNotifStatus() {
            return this.mNotifStatus;
        }

        public final String getMNotificationType() {
            String str = this.mNotificationType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mNotificationType");
            throw null;
        }

        public final String getMPNMeta() {
            String str = this.mPNMeta;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPNMeta");
            throw null;
        }

        public final String getMPayload() {
            return this.mPayload;
        }

        public final String getMPublishedTimeStamp() {
            return this.mPublishedTimeStamp;
        }

        public final ArrayList<SMTActionButtonData> getMSMTActionButtonList() {
            return this.mSMTActionButtonList;
        }

        public final ArrayList<SMTCarouselItemData> getMSMTCarouselList() {
            return this.mSMTCarouselList;
        }

        public final String getMScheduledDate() {
            return this.mScheduledDate;
        }

        public final boolean getMSound() {
            return this.mSound;
        }

        public final String getMSoundFile() {
            return this.mSoundFile;
        }

        public final int getMSource() {
            return this.mSource;
        }

        public final int getMSourceType() {
            return this.mSourceType;
        }

        public final boolean getMStickyEnabled() {
            return this.mStickyEnabled;
        }

        public final String getMSubtitle() {
            return this.mSubtitle;
        }

        public final String getMSubtitleHtml() {
            return this.mSubtitleHtml;
        }

        public final String getMTitle() {
            return this.mTitle;
        }

        public final String getMTitleHtml() {
            return this.mTitleHtml;
        }

        public final String getMTrid() {
            String str = this.mTrid;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTrid");
            throw null;
        }

        public final String getMTtl() {
            return this.mTtl;
        }

        public final HashMap<String, String> getSmtAttributePayload() {
            return this.smtAttributePayload;
        }

        public final boolean isFromSmartech() {
            return this.isFromSmartech;
        }

        public final NotificationBuilder setActionButtonList(ArrayList<SMTActionButtonData> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "actionButtonList");
            this.mSMTActionButtonList = arrayList;
            return this;
        }

        public final NotificationBuilder setCarouselList(ArrayList<SMTCarouselItemData> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, SMTNotificationConstants.NOTIF_CAROUSEL_KEY);
            this.mSMTCarouselList = arrayList;
            return this;
        }

        public final NotificationBuilder setChannelId(String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.mChannelId = str;
            return this;
        }

        public final NotificationBuilder setCollapse(String str) {
            Intrinsics.checkNotNullParameter(str, "collapse");
            this.mCollapse = str;
            return this;
        }

        public final NotificationBuilder setCustomPayload(HashMap<String, Object> hashMap) {
            this.customPayload = hashMap;
            return this;
        }

        public final NotificationBuilder setDeepLinkPath(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            this.mDeepLinkPath = str;
            return this;
        }

        public final NotificationBuilder setIsFromSmartech(boolean z) {
            this.isFromSmartech = z;
            return this;
        }

        public final NotificationBuilder setIsScheduledPn(int i) {
            this.mIsScheduledPN = i;
            return this;
        }

        public final NotificationBuilder setIsSnoozedNotification(int i) {
            this.mIsSnoozedNotification = i;
            return this;
        }

        public final void setMCollapse(String str) {
            this.mCollapse = str;
        }

        public final void setMPayload(String str) {
            this.mPayload = str;
        }

        public final NotificationBuilder setMediaLocalPath(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            this.mMediaLocalPath = str;
            return this;
        }

        public final NotificationBuilder setMediaUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.mMediaUrl = str;
            return this;
        }

        public final NotificationBuilder setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.mMessage = str;
            return this;
        }

        public final NotificationBuilder setMessageHtml(String str) {
            Intrinsics.checkNotNullParameter(str, "messageHtml");
            this.mMessageHtml = str;
            return this;
        }

        public final NotificationBuilder setNotificationPayload(String str) {
            Intrinsics.checkNotNullParameter(str, "payload");
            this.mPayload = str;
            return this;
        }

        public final NotificationBuilder setNotificationType(String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            this.mNotificationType = str;
            return this;
        }

        public final NotificationBuilder setPNMeta(String str) {
            Intrinsics.checkNotNullParameter(str, "pnMeta");
            this.mPNMeta = str;
            return this;
        }

        public final NotificationBuilder setPublishedDate(String str) {
            Intrinsics.checkNotNullParameter(str, "timestamp");
            this.mPublishedTimeStamp = str;
            return this;
        }

        public final NotificationBuilder setScheduledDate(String str) {
            Intrinsics.checkNotNullParameter(str, "timestamp");
            this.mScheduledDate = str;
            return this;
        }

        public final NotificationBuilder setSmtAttributePayload(HashMap<String, String> hashMap) {
            this.smtAttributePayload = hashMap;
            return this;
        }

        public final NotificationBuilder setSound(boolean z) {
            this.mSound = z;
            return this;
        }

        public final NotificationBuilder setSoundFile(String str) {
            Intrinsics.checkNotNullParameter(str, SMTNotificationConstants.NOTIF_SOUND_FILE_KEY);
            this.mSoundFile = str;
            return this;
        }

        public final NotificationBuilder setSource(int i) {
            this.mSource = i;
            return this;
        }

        public final NotificationBuilder setSourceType(int i) {
            this.mSourceType = i;
            return this;
        }

        public final NotificationBuilder setStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "status");
            this.mNotifStatus = str;
            return this;
        }

        public final NotificationBuilder setStickyEnabled(boolean z) {
            this.mStickyEnabled = z;
            return this;
        }

        public final NotificationBuilder setSubtitle(String str) {
            Intrinsics.checkNotNullParameter(str, SMTNotificationConstants.NOTIF_SUBTITLE_KEY);
            this.mSubtitle = str;
            return this;
        }

        public final NotificationBuilder setSubtitleHtml(String str) {
            Intrinsics.checkNotNullParameter(str, "subtitleHtml");
            this.mSubtitleHtml = str;
            return this;
        }

        public final NotificationBuilder setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.mTitle = str;
            return this;
        }

        public final NotificationBuilder setTitleHtml(String str) {
            Intrinsics.checkNotNullParameter(str, "titleHtml");
            this.mTitleHtml = str;
            return this;
        }

        public final NotificationBuilder setTrId(String str) {
            Intrinsics.checkNotNullParameter(str, "trId");
            this.mTrid = str;
            return this;
        }

        public final NotificationBuilder setTtl(String str) {
            Intrinsics.checkNotNullParameter(str, "ttl");
            this.mTtl = str;
            return this;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SMTNotificationData(com.netcore.android.notification.models.SMTNotificationData.NotificationBuilder r4) {
        /*
            r3 = this;
            java.lang.String r0 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            r0 = 1
            r3.mSource = r0
            r3.mSound = r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r3.isPlaying = r1
            int r1 = r4.getMSource()
            r3.mSource = r1
            boolean r1 = r4.isFromSmartech()
            r3.isFromSmartech = r1
            java.lang.String r1 = r4.getMNotificationType()
            r3.mNotificationType = r1
            java.lang.String r1 = r4.getMTrid()
            r3.mTrid = r1
            java.lang.String r1 = r4.getMTitleHtml()
            r2 = 0
            if (r1 == 0) goto L_0x0039
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r1 = 0
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = r4.getMTitleHtml()
            goto L_0x0045
        L_0x0041:
            java.lang.String r1 = r4.getMTitle()
        L_0x0045:
            r3.mTitle = r1
            java.lang.String r1 = r4.getMMessageHtml()
            if (r1 == 0) goto L_0x0056
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r1 = 0
            goto L_0x0057
        L_0x0056:
            r1 = 1
        L_0x0057:
            if (r1 != 0) goto L_0x005e
            java.lang.String r1 = r4.getMMessageHtml()
            goto L_0x0062
        L_0x005e:
            java.lang.String r1 = r4.getMMessage()
        L_0x0062:
            r3.mMessage = r1
            java.lang.String r1 = r4.getMSubtitleHtml()
            if (r1 == 0) goto L_0x0072
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r0 = 0
        L_0x0072:
            if (r0 != 0) goto L_0x0079
            java.lang.String r0 = r4.getMSubtitleHtml()
            goto L_0x007d
        L_0x0079:
            java.lang.String r0 = r4.getMSubtitle()
        L_0x007d:
            r3.mSubtitle = r0
            java.lang.String r0 = r4.getMMediaUrl()
            r3.mMediaUrl = r0
            java.lang.String r0 = r4.getMDeepLinkPath()
            r3.mDeepLinkPath = r0
            java.lang.String r0 = r4.getMPNMeta()
            r3.mPNMeta = r0
            java.util.ArrayList r0 = r4.getMSMTActionButtonList()
            r3.mActionButtonList = r0
            java.util.ArrayList r0 = r4.getMSMTCarouselList()
            r3.mCarouselList = r0
            java.util.HashMap r0 = r4.getCustomPayload()
            r3.mCustomPayload = r0
            java.util.HashMap r0 = r4.getSmtAttributePayload()
            r3.mSmtAttributePayload = r0
            java.lang.String r0 = r4.getMNotifStatus()
            r3.mStatus = r0
            java.lang.String r0 = r4.getMPublishedTimeStamp()
            r3.mPublishedTimeStamp = r0
            java.lang.String r0 = r4.getMScheduledDate()
            r3.mScheduledDate = r0
            java.lang.String r0 = r4.getMMediaLocalPath()
            r3.mMediaLocalPath = r0
            boolean r0 = r4.getMSound()
            r3.mSound = r0
            java.lang.String r0 = r4.getMSoundFile()
            r3.mSoundFile = r0
            java.lang.String r0 = r4.getMChannelId()
            r3.mChannelId = r0
            java.lang.String r0 = r4.getMTitleHtml()
            r3.mTitleHtml = r0
            java.lang.String r0 = r4.getMMessageHtml()
            r3.mMessageHtml = r0
            java.lang.String r0 = r4.getMSubtitleHtml()
            r3.mSubtitleHtml = r0
            boolean r0 = r4.getMStickyEnabled()
            r3.mStickyEnabled = r0
            java.lang.String r0 = r4.getMTtl()
            r3.mTtl = r0
            int r0 = r4.getMSourceType()
            r3.mSourceType = r0
            int r0 = r4.getMIsScheduledPN()
            r3.mIsScheduledPN = r0
            int r0 = r4.getMIsSnoozedNotification()
            r3.mIsSnoozedNotification = r0
            java.lang.String r0 = r4.getMPayload()
            r3.mPayload = r0
            java.lang.String r4 = r4.getMCollapse()
            r3.mCollapse = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.notification.models.SMTNotificationData.<init>(com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder):void");
    }

    public int describeContents() {
        return 0;
    }

    public final String getAction() {
        return this.action;
    }

    public final ArrayList<SMTActionButtonData> getMActionButtonList() {
        return this.mActionButtonList;
    }

    public final ArrayList<SMTCarouselItemData> getMCarouselList() {
        return this.mCarouselList;
    }

    public final String getMChannelId() {
        return this.mChannelId;
    }

    public final String getMCollapse() {
        return this.mCollapse;
    }

    public final HashMap<String, Object> getMCustomPayload() {
        return this.mCustomPayload;
    }

    public final String getMDeepLinkPath() {
        return this.mDeepLinkPath;
    }

    public final int getMDownloadStatus() {
        return this.mDownloadStatus;
    }

    public final boolean getMIsDownloadInProgress() {
        return this.mIsDownloadInProgress;
    }

    public final boolean getMIsForInbox() {
        return this.mIsForInbox;
    }

    public final int getMIsScheduledPN() {
        return this.mIsScheduledPN;
    }

    public final int getMIsSnoozedNotification() {
        return this.mIsSnoozedNotification;
    }

    public final String getMMediaLocalPath() {
        return this.mMediaLocalPath;
    }

    public final String getMMediaUrl() {
        return this.mMediaUrl;
    }

    public final String getMMessage() {
        return this.mMessage;
    }

    public final String getMMessageHtml() {
        return this.mMessageHtml;
    }

    public final String getMNotificationType() {
        return this.mNotificationType;
    }

    public final String getMPNMeta() {
        return this.mPNMeta;
    }

    public final String getMPayload() {
        return this.mPayload;
    }

    public final String getMPublishedTimeStamp() {
        return this.mPublishedTimeStamp;
    }

    public final ArrayList<String> getMRemoveSchedulePn() {
        return this.mRemoveSchedulePn;
    }

    public final String getMScheduledDate() {
        return this.mScheduledDate;
    }

    public final String getMScheduledPNStatus() {
        return this.mScheduledPNStatus;
    }

    public final String getMScheduledPNTimeStamp() {
        return this.mScheduledPNTimeStamp;
    }

    public final HashMap<String, String> getMSmtAttributePayload() {
        return this.mSmtAttributePayload;
    }

    public final boolean getMSound() {
        return this.mSound;
    }

    public final String getMSoundFile() {
        return this.mSoundFile;
    }

    public final int getMSource() {
        return this.mSource;
    }

    public final int getMSourceType() {
        return this.mSourceType;
    }

    public final String getMStatus() {
        return this.mStatus;
    }

    public final boolean getMStickyEnabled() {
        return this.mStickyEnabled;
    }

    public final String getMSubtitle() {
        return this.mSubtitle;
    }

    public final String getMSubtitleHtml() {
        return this.mSubtitleHtml;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final String getMTitleHtml() {
        return this.mTitleHtml;
    }

    public final String getMTrid() {
        return this.mTrid;
    }

    public final String getMTtl() {
        return this.mTtl;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final boolean isFromSmartech() {
        return this.isFromSmartech;
    }

    public final Boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final void setMCollapse(String str) {
        this.mCollapse = str;
    }

    public final void setMDownloadStatus(int i) {
        this.mDownloadStatus = i;
    }

    public final void setMIsDownloadInProgress(boolean z) {
        this.mIsDownloadInProgress = z;
    }

    public final void setMIsForInbox(boolean z) {
        this.mIsForInbox = z;
    }

    public final void setMIsScheduledPN(int i) {
        this.mIsScheduledPN = i;
    }

    public final void setMIsSnoozedNotification(int i) {
        this.mIsSnoozedNotification = i;
    }

    public final void setMMediaLocalPath(String str) {
        this.mMediaLocalPath = str;
    }

    public final void setMNotificationType(String str) {
        this.mNotificationType = str;
    }

    public final void setMPayload(String str) {
        this.mPayload = str;
    }

    public final void setMPublishedTimeStamp(String str) {
        this.mPublishedTimeStamp = str;
    }

    public final void setMRemoveSchedulePn(ArrayList<String> arrayList) {
        this.mRemoveSchedulePn = arrayList;
    }

    public final void setMScheduledDate(String str) {
        this.mScheduledDate = str;
    }

    public final void setMScheduledPNStatus(String str) {
        this.mScheduledPNStatus = str;
    }

    public final void setMScheduledPNTimeStamp(String str) {
        this.mScheduledPNTimeStamp = str;
    }

    public final void setMSourceType(int i) {
        this.mSourceType = i;
    }

    public final void setMStatus(String str) {
        this.mStatus = str;
    }

    public final void setMStickyEnabled(boolean z) {
        this.mStickyEnabled = z;
    }

    public final void setMTitle(String str) {
        this.mTitle = str;
    }

    public final void setMTtl(String str) {
        this.mTtl = str;
    }

    public final void setNotificationId(int i) {
        this.notificationId = i;
    }

    public final void setPlaying(Boolean bool) {
        this.isPlaying = bool;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.mSource);
        parcel.writeValue(Boolean.valueOf(this.isFromSmartech));
        parcel.writeString(this.mNotificationType);
        parcel.writeString(this.mTrid);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mMessage);
        parcel.writeString(this.mSubtitle);
        parcel.writeString(this.mMediaUrl);
        parcel.writeString(this.mDeepLinkPath);
        parcel.writeString(this.mPNMeta);
        parcel.writeTypedList(this.mActionButtonList);
        parcel.writeTypedList(this.mCarouselList);
        parcel.writeSerializable(this.mCustomPayload);
        parcel.writeSerializable(this.mSmtAttributePayload);
        parcel.writeString(this.mStatus);
        parcel.writeString(this.mPublishedTimeStamp);
        parcel.writeString(this.mScheduledDate);
        parcel.writeString(this.mMediaLocalPath);
        parcel.writeValue(Boolean.valueOf(this.mSound));
        parcel.writeString(this.mSoundFile);
        parcel.writeString(this.mChannelId);
        parcel.writeString(this.mTitleHtml);
        parcel.writeString(this.mMessageHtml);
        parcel.writeString(this.mSubtitleHtml);
        parcel.writeValue(Boolean.valueOf(this.mStickyEnabled));
        parcel.writeString(this.action);
        parcel.writeValue(this.isPlaying);
        parcel.writeValue(Integer.valueOf(this.notificationId));
        parcel.writeValue(Integer.valueOf(this.mDownloadStatus));
        parcel.writeValue(Boolean.valueOf(this.mIsDownloadInProgress));
        parcel.writeString(this.mPayload);
        parcel.writeString(this.mTtl);
        parcel.writeInt(this.mSourceType);
        parcel.writeInt(this.mIsScheduledPN);
        parcel.writeInt(this.mIsSnoozedNotification);
        parcel.writeString(this.mCollapse);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SMTNotificationData(android.os.Parcel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = new com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder
            r0.<init>()
            int r1 = r8.readInt()
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSource(r1)
            java.lang.Class r1 = java.lang.Boolean.TYPE
            java.lang.ClassLoader r2 = r1.getClassLoader()
            java.lang.Object r2 = r8.readValue(r2)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Boolean"
            if (r2 == 0) goto L_0x01f1
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setIsFromSmartech(r2)
            java.lang.String r2 = r8.readString()
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r2 = r4
        L_0x0034:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setNotificationType(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r4
        L_0x0040:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setTrId(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r2 = r4
        L_0x004c:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setTitle(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r2 = r4
        L_0x0058:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setMessage(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r2 = r4
        L_0x0064:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSubtitle(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r4
        L_0x0070:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setMediaUrl(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r2 = r4
        L_0x007c:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setDeepLinkPath(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r2 = r4
        L_0x0088:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setPNMeta(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.netcore.android.notification.models.SMTActionButtonData$CREATOR r5 = com.netcore.android.notification.models.SMTActionButtonData.CREATOR
            r8.readTypedList(r2, r5)
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setActionButtonList(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.netcore.android.notification.models.SMTCarouselItemData$CREATOR r5 = com.netcore.android.notification.models.SMTCarouselItemData.CREATOR
            r8.readTypedList(r2, r5)
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setCarouselList(r2)
            java.io.Serializable r2 = r8.readSerializable()
            boolean r5 = r2 instanceof java.util.HashMap
            r6 = 0
            if (r5 != 0) goto L_0x00b2
            r2 = r6
        L_0x00b2:
            java.util.HashMap r2 = (java.util.HashMap) r2
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setCustomPayload(r2)
            java.io.Serializable r2 = r8.readSerializable()
            boolean r5 = r2 instanceof java.util.HashMap
            if (r5 != 0) goto L_0x00c1
            r2 = r6
        L_0x00c1:
            java.util.HashMap r2 = (java.util.HashMap) r2
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSmtAttributePayload(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r2 = r4
        L_0x00cf:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setStatus(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r2 = r4
        L_0x00db:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setPublishedDate(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r2 = r4
        L_0x00e7:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setScheduledDate(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r2 = r4
        L_0x00f3:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setMediaLocalPath(r2)
            java.lang.ClassLoader r2 = r1.getClassLoader()
            java.lang.Object r2 = r8.readValue(r2)
            if (r2 == 0) goto L_0x01eb
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSound(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r2 = r4
        L_0x0113:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSoundFile(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r2 = r4
        L_0x011f:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setChannelId(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            r2 = r4
        L_0x012b:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setTitleHtml(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r2 = r4
        L_0x0137:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setMessageHtml(r2)
            java.lang.String r2 = r8.readString()
            if (r2 == 0) goto L_0x0142
            r4 = r2
        L_0x0142:
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setSubtitleHtml(r4)
            java.lang.ClassLoader r2 = r1.getClassLoader()
            java.lang.Object r2 = r8.readValue(r2)
            if (r2 == 0) goto L_0x01e5
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            com.netcore.android.notification.models.SMTNotificationData$NotificationBuilder r0 = r0.setStickyEnabled(r2)
            r7.<init>(r0)
            java.lang.String r0 = r8.readString()
            r7.action = r0
            java.lang.ClassLoader r0 = r1.getClassLoader()
            java.lang.Object r0 = r8.readValue(r0)
            boolean r2 = r0 instanceof java.lang.Boolean
            if (r2 != 0) goto L_0x0170
            r0 = r6
        L_0x0170:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.isPlaying = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r2 = r0.getClassLoader()
            java.lang.Object r2 = r8.readValue(r2)
            boolean r4 = r2 instanceof java.lang.Integer
            if (r4 != 0) goto L_0x0183
            r2 = r6
        L_0x0183:
            java.lang.Integer r2 = (java.lang.Integer) r2
            r4 = 0
            if (r2 == 0) goto L_0x018d
            int r2 = r2.intValue()
            goto L_0x018e
        L_0x018d:
            r2 = 0
        L_0x018e:
            r7.notificationId = r2
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r8.readValue(r0)
            boolean r2 = r0 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x019d
            goto L_0x019e
        L_0x019d:
            r6 = r0
        L_0x019e:
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x01a6
            int r4 = r6.intValue()
        L_0x01a6:
            r7.mDownloadStatus = r4
            java.lang.ClassLoader r0 = r1.getClassLoader()
            java.lang.Object r0 = r8.readValue(r0)
            if (r0 == 0) goto L_0x01df
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r7.mIsDownloadInProgress = r0
            java.lang.String r0 = r8.readString()
            r7.mPayload = r0
            java.lang.String r0 = r8.readString()
            r7.mTtl = r0
            int r0 = r8.readInt()
            r7.mSourceType = r0
            int r0 = r8.readInt()
            r7.mIsScheduledPN = r0
            int r0 = r8.readInt()
            r7.mIsSnoozedNotification = r0
            java.lang.String r8 = r8.readString()
            r7.mCollapse = r8
            return
        L_0x01df:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        L_0x01e5:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        L_0x01eb:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        L_0x01f1:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.notification.models.SMTNotificationData.<init>(android.os.Parcel):void");
    }
}
