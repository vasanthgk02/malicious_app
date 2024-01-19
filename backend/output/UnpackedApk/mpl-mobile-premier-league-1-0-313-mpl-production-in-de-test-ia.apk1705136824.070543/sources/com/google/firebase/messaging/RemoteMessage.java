package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.Map;

@Class
@Reserved
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    @Field
    public Bundle bundle;
    public Map<String, String> data;
    public Notification notification;

    public static class Notification {
        public final String body;
        public final Uri link;
        public final String title;

        public Notification(NotificationParams notificationParams, AnonymousClass1 r3) {
            this.title = notificationParams.getString("gcm.n.title");
            notificationParams.getLocalizationResourceForKey("gcm.n.title");
            getLocalizationArgs(notificationParams, "gcm.n.title");
            this.body = notificationParams.getString("gcm.n.body");
            notificationParams.getLocalizationResourceForKey("gcm.n.body");
            getLocalizationArgs(notificationParams, "gcm.n.body");
            notificationParams.getString("gcm.n.icon");
            if (TextUtils.isEmpty(notificationParams.getString("gcm.n.sound2"))) {
                notificationParams.getString("gcm.n.sound");
            }
            notificationParams.getString("gcm.n.tag");
            notificationParams.getString("gcm.n.color");
            notificationParams.getString("gcm.n.click_action");
            notificationParams.getString("gcm.n.android_channel_id");
            this.link = notificationParams.getLink();
            notificationParams.getString("gcm.n.image");
            notificationParams.getString("gcm.n.ticker");
            notificationParams.getInteger("gcm.n.notification_priority");
            notificationParams.getInteger("gcm.n.visibility");
            notificationParams.getInteger("gcm.n.notification_count");
            notificationParams.getBoolean("gcm.n.sticky");
            notificationParams.getBoolean("gcm.n.local_only");
            notificationParams.getBoolean("gcm.n.default_sound");
            notificationParams.getBoolean("gcm.n.default_vibrate_timings");
            notificationParams.getBoolean("gcm.n.default_light_settings");
            notificationParams.getLong("gcm.n.event_time");
            notificationParams.getLightSettings();
            notificationParams.getVibrateTimings();
        }

        public static String[] getLocalizationArgs(NotificationParams notificationParams, String str) {
            Object[] localizationArgsForKey = notificationParams.getLocalizationArgsForKey(str);
            if (localizationArgsForKey == null) {
                return null;
            }
            String[] strArr = new String[localizationArgsForKey.length];
            for (int i = 0; i < localizationArgsForKey.length; i++) {
                strArr[i] = String.valueOf(localizationArgsForKey[i]);
            }
            return strArr;
        }

        public String getBody() {
            return this.body;
        }

        public String getTitle() {
            return this.title;
        }
    }

    @Constructor
    public RemoteMessage(@Param(id = 2) Bundle bundle2) {
        this.bundle = bundle2;
    }

    public Map<String, String> getData() {
        if (this.data == null) {
            Bundle bundle2 = this.bundle;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle2.keySet()) {
                Object obj = bundle2.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals(PushMessageHelper.MESSAGE_TYPE) && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.data = arrayMap;
        }
        return this.data;
    }

    public Notification getNotification() {
        if (this.notification == null && NotificationParams.isNotification(this.bundle)) {
            this.notification = new Notification(new NotificationParams(this.bundle), null);
        }
        return this.notification;
    }

    public int getPriority() {
        String string = this.bundle.getString("google.delivered_priority");
        int i = 2;
        if (string == null) {
            if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.bundle.getString("google.priority");
        }
        if ("high".equals(string)) {
            i = 1;
        } else if (!ConfigZkFeatures.CONFIG_TYPE_NORMAL.equals(string)) {
            i = 0;
        }
        return i;
    }

    public long getSentTime() {
        Object obj = this.bundle.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                "Invalid sent time: " + obj;
            }
        }
        return 0;
    }

    public int getTtl() {
        Object obj = this.bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                "Invalid TTL: " + obj;
            }
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.bundle, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
