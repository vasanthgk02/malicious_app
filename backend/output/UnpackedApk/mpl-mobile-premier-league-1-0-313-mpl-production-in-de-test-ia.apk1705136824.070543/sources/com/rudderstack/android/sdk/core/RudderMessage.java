package com.rudderstack.android.sdk.core;

import com.google.gson.annotations.SerializedName;
import com.rudderstack.android.sdk.core.util.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class RudderMessage {
    @SerializedName("action")
    public String action;
    @SerializedName("anonymousId")
    public String anonymousId = RudderContext.getAnonymousId();
    @SerializedName("channel")
    public String channel = "mobile";
    @SerializedName("context")
    public RudderContext context = RudderElementCache.getCachedContext();
    public transient Map<String, Object> customContexts;
    @SerializedName("destinationProps")
    public Map<String, Map> destinationProps = null;
    @SerializedName("event")
    public String event;
    @SerializedName("groupId")
    public String groupId;
    @SerializedName("integrations")
    public Map<String, Object> integrations = new HashMap();
    @SerializedName("messageId")
    public String messageId = String.format(Locale.US, "%d-%s", new Object[]{Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString()});
    @SerializedName("previousId")
    public String previousId;
    @SerializedName("properties")
    public Map<String, Object> properties;
    public transient RudderOption rudderOption;
    @SerializedName("originalTimestamp")
    public String timestamp = Utils.getTimeStamp();
    @SerializedName("traits")
    public RudderTraits traits;
    @SerializedName("type")
    public String type;
    @SerializedName("userId")
    public String userId;
    @SerializedName("userProperties")
    public Map<String, Object> userProperties;

    public RudderMessage() {
        Map<String, Object> traits2 = this.context.getTraits();
        if (traits2 != null && traits2.containsKey("id")) {
            this.userId = String.valueOf(traits2.get("id"));
        }
    }

    public void addIntegrationProps(String str, boolean z, Map map) {
        this.integrations.put(str, Boolean.valueOf(z));
        if (z) {
            if (this.destinationProps == null) {
                this.destinationProps = new HashMap();
            }
            this.destinationProps.put(str, map);
        }
    }

    public String getAction() {
        return this.action;
    }

    public String getAnonymousId() {
        return this.anonymousId;
    }

    public RudderContext getContext() {
        return this.context;
    }

    public String getEventName() {
        return this.event;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public Map<String, Object> getIntegrations() {
        return this.integrations;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public RudderOption getRudderOption() {
        return this.rudderOption;
    }

    public Map<String, Object> getTraits() {
        return this.context.getTraits();
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public Map<String, Object> getUserProperties() {
        return this.userProperties;
    }

    public void setCustomContexts(Map<String, Object> map) {
        if (map != null) {
            this.customContexts = map;
            this.context.setCustomContexts(map);
        }
    }

    public void setEventName(String str) {
        this.event = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupTraits(RudderTraits rudderTraits) {
        this.traits = rudderTraits;
    }

    public void setIntegrations(Map<String, Object> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                this.integrations.put(next, map.get(next));
            }
        }
    }

    public void setPreviousId(String str) {
        this.previousId = str;
    }

    public void setProperty(RudderProperty rudderProperty) {
        if (rudderProperty != null) {
            this.properties = rudderProperty.getMap();
        }
    }

    public void setRudderOption(RudderOption rudderOption2) {
        this.rudderOption = rudderOption2;
        if (rudderOption2 != null) {
            setIntegrations(rudderOption2.getIntegrations());
            setCustomContexts(rudderOption2.getCustomContexts());
        }
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserProperty(RudderUserProperty rudderUserProperty) {
        this.userProperties = rudderUserProperty.getMap();
    }

    public void updateContext() {
        RudderContext cachedContext = RudderElementCache.getCachedContext();
        this.context = cachedContext;
        Map<String, Object> map = this.customContexts;
        if (map != null) {
            cachedContext.setCustomContexts(map);
        }
    }

    public void updateExternalIds(RudderOption rudderOption2) {
        if (rudderOption2 != null) {
            List<Map<String, Object>> externalIds = rudderOption2.getExternalIds();
            if (externalIds != null && !externalIds.isEmpty()) {
                RudderElementCache.updateExternalIds(externalIds);
                updateContext();
            }
        }
    }

    public void updateTraits(RudderTraits rudderTraits) {
        RudderElementCache.updateTraits(rudderTraits);
        updateContext();
    }

    public void updateTraits(Map<String, Object> map) {
        RudderElementCache.updateTraits(map);
        updateContext();
    }
}
