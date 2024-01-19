package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.PushMessageHandler.a;
import java.util.HashMap;
import java.util.Map;

public class MiPushMessage implements a {
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DESC = "description";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_MESSAGE_ID = "messageId";
    public static final String KEY_MESSAGE_TYPE = "messageType";
    public static final String KEY_NOTIFIED = "isNotified";
    public static final String KEY_NOTIFY_ID = "notifyId";
    public static final String KEY_NOTIFY_TYPE = "notifyType";
    public static final String KEY_PASS_THROUGH = "passThrough";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TOPIC = "topic";
    public static final String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    public static final long serialVersionUID = 1;
    public String alias;
    public boolean arrived = false;
    public String category;
    public String content;
    public String description;
    public HashMap<String, String> extra = new HashMap<>();
    public boolean isNotified;
    public String messageId;
    public int messageType;
    public int notifyId;
    public int notifyType;
    public int passThrough;
    public String title;
    public String topic;
    public String userAccount;

    public static MiPushMessage fromBundle(Bundle bundle) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.messageId = bundle.getString("messageId");
        miPushMessage.messageType = bundle.getInt(KEY_MESSAGE_TYPE);
        miPushMessage.passThrough = bundle.getInt(KEY_PASS_THROUGH);
        miPushMessage.alias = bundle.getString("alias");
        miPushMessage.userAccount = bundle.getString(KEY_USER_ACCOUNT);
        miPushMessage.topic = bundle.getString(KEY_TOPIC);
        miPushMessage.content = bundle.getString("content");
        miPushMessage.description = bundle.getString("description");
        miPushMessage.title = bundle.getString("title");
        miPushMessage.isNotified = bundle.getBoolean(KEY_NOTIFIED);
        miPushMessage.notifyId = bundle.getInt(KEY_NOTIFY_ID);
        miPushMessage.notifyType = bundle.getInt(KEY_NOTIFY_TYPE);
        miPushMessage.category = bundle.getString("category");
        miPushMessage.extra = (HashMap) bundle.getSerializable(KEY_EXTRA);
        return miPushMessage;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setArrivedMessage(boolean z) {
        this.arrived = z;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtra(Map<String, String> map) {
        this.extra.clear();
        if (map != null) {
            this.extra.putAll(map);
        }
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setNotified(boolean z) {
        this.isNotified = z;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public void setNotifyType(int i) {
        this.notifyType = i;
    }

    public void setPassThrough(int i) {
        this.passThrough = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("messageId", this.messageId);
        bundle.putInt(KEY_PASS_THROUGH, this.passThrough);
        bundle.putInt(KEY_MESSAGE_TYPE, this.messageType);
        if (!TextUtils.isEmpty(this.alias)) {
            bundle.putString("alias", this.alias);
        }
        if (!TextUtils.isEmpty(this.userAccount)) {
            bundle.putString(KEY_USER_ACCOUNT, this.userAccount);
        }
        if (!TextUtils.isEmpty(this.topic)) {
            bundle.putString(KEY_TOPIC, this.topic);
        }
        bundle.putString("content", this.content);
        if (!TextUtils.isEmpty(this.description)) {
            bundle.putString("description", this.description);
        }
        if (!TextUtils.isEmpty(this.title)) {
            bundle.putString("title", this.title);
        }
        bundle.putBoolean(KEY_NOTIFIED, this.isNotified);
        bundle.putInt(KEY_NOTIFY_ID, this.notifyId);
        bundle.putInt(KEY_NOTIFY_TYPE, this.notifyType);
        if (!TextUtils.isEmpty(this.category)) {
            bundle.putString("category", this.category);
        }
        HashMap<String, String> hashMap = this.extra;
        if (hashMap != null) {
            bundle.putSerializable(KEY_EXTRA, hashMap);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("messageId={");
        outline73.append(this.messageId);
        outline73.append("},passThrough={");
        outline73.append(this.passThrough);
        outline73.append("},alias={");
        outline73.append(this.alias);
        outline73.append("},topic={");
        outline73.append(this.topic);
        outline73.append("},userAccount={");
        outline73.append(this.userAccount);
        outline73.append("},content={");
        outline73.append(this.content);
        outline73.append("},description={");
        outline73.append(this.description);
        outline73.append("},title={");
        outline73.append(this.title);
        outline73.append("},isNotified={");
        outline73.append(this.isNotified);
        outline73.append("},notifyId={");
        outline73.append(this.notifyId);
        outline73.append("},notifyType={");
        outline73.append(this.notifyType);
        outline73.append("}, category={");
        outline73.append(this.category);
        outline73.append("}, extra={");
        outline73.append(this.extra);
        outline73.append("}");
        return outline73.toString();
    }
}
