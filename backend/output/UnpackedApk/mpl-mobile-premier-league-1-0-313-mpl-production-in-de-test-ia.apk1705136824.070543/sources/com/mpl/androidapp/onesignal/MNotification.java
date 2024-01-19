package com.mpl.androidapp.onesignal;

import android.text.TextUtils;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.Iterator;
import org.json.JSONObject;

public class MNotification {
    public JSONObject additionalData;
    public String bigPicture;
    public String body;
    public String campaignId;
    public String collapseId;
    public String deepLink;
    public String eventProps;
    public long expiryTime;
    public String feature;
    public String fromProjectNumber;
    public String groupKey;
    public String groupMessage;
    public String largeIcon;
    public String launchURL;
    public String ledColor;
    public int lockScreenVisibility;
    public int minVersion;
    public String notifCategory;
    public String notifSubCategory;
    public String notificationID;
    public String notificationName;
    public String notificationType;
    public int priority;
    public String rawPayload;
    public long receiveTime;
    public boolean receivedBeforeTTL;
    public long sentTime;
    public boolean shouldSendEvent;
    public String smallIcon;
    public String smallIconAccentColor;
    public String sound;
    public String templateId;
    public String templateName;
    public long timeToDelivery;
    public String title;
    public long ttl;

    public JSONObject getAdditionalData() {
        return this.additionalData;
    }

    public String getBigPicture() {
        return this.bigPicture;
    }

    public String getBody() {
        return this.body;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCollapseId() {
        return this.collapseId;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getEventProps() {
        return this.eventProps;
    }

    public long getExpiryTime() {
        return this.expiryTime;
    }

    public String getFeature() {
        return this.feature;
    }

    public String getFromProjectNumber() {
        return this.fromProjectNumber;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public String getGroupMessage() {
        return this.groupMessage;
    }

    public String getLargeIcon() {
        return this.largeIcon;
    }

    public String getLaunchURL() {
        return this.launchURL;
    }

    public String getLedColor() {
        return this.ledColor;
    }

    public int getLockScreenVisibility() {
        return this.lockScreenVisibility;
    }

    public int getMinVersion() {
        return this.minVersion;
    }

    public String getNotifCategory() {
        return this.notifCategory;
    }

    public String getNotifSubCategory() {
        return this.notifSubCategory;
    }

    public String getNotificationID() {
        return this.notificationID;
    }

    public String getNotificationName() {
        return this.notificationName;
    }

    public String getNotificationType() {
        return this.notificationType;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRawPayload() {
        return this.rawPayload;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public String getSmallIconAccentColor() {
        return this.smallIconAccentColor;
    }

    public String getSound() {
        return this.sound;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public long getTimeToDelivery() {
        return this.timeToDelivery;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTtl() {
        return this.ttl;
    }

    public boolean isReceivedBeforeTTL() {
        return this.receivedBeforeTTL;
    }

    public boolean isShouldSendEvent() {
        return this.shouldSendEvent;
    }

    public void setAdditionalData(JSONObject jSONObject) {
        this.additionalData = jSONObject;
    }

    public void setBigPicture(String str) {
        this.bigPicture = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setCollapseId(String str) {
        this.collapseId = str;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public void setEventProps(String str) {
        this.eventProps = str;
    }

    public void setExpiryTime(long j) {
        this.expiryTime = j;
    }

    public void setFeature(String str) {
        this.feature = str;
    }

    public void setFromProjectNumber(String str) {
        this.fromProjectNumber = str;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setGroupMessage(String str) {
        this.groupMessage = str;
    }

    public void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public void setLaunchURL(String str) {
        this.launchURL = str;
    }

    public void setLedColor(String str) {
        this.ledColor = str;
    }

    public void setLockScreenVisibility(int i) {
        this.lockScreenVisibility = i;
    }

    public void setMinVersion(int i) {
        this.minVersion = i;
    }

    public void setNotifCategory(String str) {
        this.notifCategory = str;
    }

    public void setNotifSubCategory(String str) {
        this.notifSubCategory = str;
    }

    public void setNotificationID(String str) {
        this.notificationID = str;
    }

    public void setNotificationName(String str) {
        this.notificationName = str;
    }

    public void setNotificationType(String str) {
        this.notificationType = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setRawPayload(String str) {
        this.rawPayload = str;
    }

    public void setReceiveTime(long j) {
        this.receiveTime = j;
    }

    public void setReceivedBeforeTTL(boolean z) {
        this.receivedBeforeTTL = z;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setShouldSendEvent(boolean z) {
        this.shouldSendEvent = z;
    }

    public void setSmallIcon(String str) {
        this.smallIcon = str;
    }

    public void setSmallIconAccentColor(String str) {
        this.smallIconAccentColor = str;
    }

    public void setSound(String str) {
        this.sound = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public void setTimeToDelivery(long j) {
        this.timeToDelivery = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTtl(long j) {
        this.ttl = j;
    }

    public JSONObject toJSonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationID", getNotificationID());
            jSONObject.put("templateName", getTemplateName());
            jSONObject.put("templateId", getTemplateId());
            jSONObject.put("additionalData", getAdditionalData());
            jSONObject.put("smallIcon", getSmallIcon());
            jSONObject.put("bigPicture", getBigPicture());
            jSONObject.put("smallIconAccentColor", getSmallIconAccentColor());
            jSONObject.put("launchURL", getLaunchURL());
            jSONObject.put(SMTNotificationConstants.NOTIF_SOUND_KEY, getSound());
            jSONObject.put("ledColor", getLedColor());
            jSONObject.put("lockScreenVisibility", getLockScreenVisibility());
            jSONObject.put("groupKey", getGroupKey());
            jSONObject.put("groupMessage", getGroupMessage());
            jSONObject.put("fromProjectNumber", getFromProjectNumber());
            jSONObject.put("collapseId", getCollapseId());
            jSONObject.put("priority", getPriority());
            jSONObject.put("rawPayload", getRawPayload());
            jSONObject.put("shouldSendEvent", isShouldSendEvent());
            jSONObject.put(OneSingnalConstant.PARAM_MIN_VERSION, getMinVersion());
            jSONObject.put("TTL", getTtl());
            jSONObject.put("Image Link", getLargeIcon());
            jSONObject.put("Campaign ID", getCampaignId());
            jSONObject.put("Feature", getFeature());
            jSONObject.put("Title", getTitle());
            jSONObject.put("Message", getBody());
            jSONObject.put("Deeplink", getDeepLink());
            jSONObject.put(OneSingnalConstant.PARAM_EXPIRY_TIME, getExpiryTime());
            jSONObject.put("Sent Timestamp", getSentTime());
            jSONObject.put("Received Timestamp", getReceiveTime());
            jSONObject.put("Received Before TTL", isReceivedBeforeTTL());
            jSONObject.put("Time To Delivery", getTimeToDelivery());
            jSONObject.put(EventsConstants.PROP_NOTIFICATION_TYPE, getNotificationType());
            jSONObject.put("Notification name", getNotificationName());
            if (!TextUtils.isEmpty(getNotifCategory())) {
                jSONObject.put("NotifCategory", getNotifCategory());
            }
            if (!TextUtils.isEmpty(getNotifSubCategory())) {
                jSONObject.put("NotifSubcategory", getNotifSubCategory());
            }
            if (!TextUtils.isEmpty(getEventProps())) {
                JSONObject jSONObject2 = new JSONObject(getEventProps());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject2.opt(next);
                    if (!jSONObject.has(next)) {
                        jSONObject.put(next, opt);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
