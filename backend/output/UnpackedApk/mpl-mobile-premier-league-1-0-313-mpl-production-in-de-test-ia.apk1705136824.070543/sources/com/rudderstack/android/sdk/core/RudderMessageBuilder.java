package com.rudderstack.android.sdk.core;

import java.util.Map;

public class RudderMessageBuilder {
    public String eventName = null;
    public String groupId = null;
    public RudderTraits groupTraits = null;
    public RudderOption option;
    public String previousId = null;
    public RudderProperty property;
    public String userId = null;
    public RudderUserProperty userProperty;

    public RudderMessage build() {
        RudderMessage rudderMessage = new RudderMessage();
        String str = this.userId;
        if (str != null) {
            rudderMessage.setUserId(str);
        }
        String str2 = this.eventName;
        if (str2 != null) {
            rudderMessage.setEventName(str2);
        }
        RudderProperty rudderProperty = this.property;
        if (rudderProperty != null) {
            rudderMessage.setProperty(rudderProperty);
        }
        RudderUserProperty rudderUserProperty = this.userProperty;
        if (rudderUserProperty != null) {
            rudderMessage.setUserProperty(rudderUserProperty);
        }
        String str3 = this.previousId;
        if (str3 != null) {
            rudderMessage.setPreviousId(str3);
        }
        String str4 = this.groupId;
        if (str4 != null) {
            rudderMessage.setGroupId(str4);
        }
        RudderTraits rudderTraits = this.groupTraits;
        if (rudderTraits != null) {
            rudderMessage.setGroupTraits(rudderTraits);
        }
        RudderOption rudderOption = this.option;
        if (rudderOption != null) {
            rudderMessage.setRudderOption(rudderOption);
        }
        return rudderMessage;
    }

    public RudderMessageBuilder setEventName(String str) {
        this.eventName = str;
        return this;
    }

    public RudderMessageBuilder setGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public RudderMessageBuilder setGroupTraits(RudderTraits rudderTraits) {
        this.groupTraits = rudderTraits;
        return this;
    }

    public RudderMessageBuilder setPreviousId(String str) {
        this.previousId = str;
        return this;
    }

    public RudderMessageBuilder setProperty(RudderProperty rudderProperty) {
        this.property = rudderProperty;
        return this;
    }

    public RudderMessageBuilder setRudderOption(RudderOption rudderOption) {
        this.option = rudderOption;
        return this;
    }

    public RudderMessageBuilder setUserId(String str) {
        this.userId = str;
        return this;
    }

    public RudderMessageBuilder setUserProperty(RudderUserProperty rudderUserProperty) {
        this.userProperty = rudderUserProperty;
        return this;
    }

    public RudderMessageBuilder setProperty(RudderPropertyBuilder rudderPropertyBuilder) {
        this.property = rudderPropertyBuilder.build();
        return this;
    }

    public RudderMessageBuilder setUserProperty(Map<String, Object> map) {
        RudderUserProperty rudderUserProperty = new RudderUserProperty();
        this.userProperty = rudderUserProperty;
        rudderUserProperty.putValue(map);
        return this;
    }

    public RudderMessageBuilder setProperty(Map<String, Object> map) {
        if (this.property == null) {
            this.property = new RudderProperty();
        }
        this.property.putValue(map);
        return this;
    }
}
