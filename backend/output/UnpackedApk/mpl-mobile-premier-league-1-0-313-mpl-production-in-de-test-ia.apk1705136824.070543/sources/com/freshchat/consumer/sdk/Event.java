package com.freshchat.consumer.sdk;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import java.util.HashMap;
import java.util.Map;

public class Event {
    public EventName eventName;
    public Map<Property, Object> properties;

    public enum EventName {
        FCEventFAQCategoryListOpen("FCEventFAQCategoryListOpen"),
        FCEventFAQListOpen("FCEventFAQListOpen"),
        FCEventFAQOpen("FCEventFAQOpen"),
        FCEventBotFAQOpen("FCEventBotFAQOpen"),
        FCEventBotFAQVote("FCEventBotFAQVote"),
        FCEventFAQSearch("FCEventFAQSearch"),
        FCEventFAQVote("FCEventFAQVote"),
        FCEventChannelListOpen("FCEventChannelListOpen"),
        FCEventMessageSent("FCEventMessageSent"),
        FCEventConversationOpen("FCEventConversationOpen"),
        FCEventCsatOpen("FCEventCsatOpen"),
        FCEventCsatSubmit("FCEventCsatSubmit"),
        FCEventCsatExpiry("FCEventCsatExpiry"),
        FCEventLinkTap("FCEventLinkTap"),
        FCEventScreenView("FCEventScreenView"),
        FCEventMessageReceive("FCEventMessageReceive"),
        FCEventNotificationReceive("FCEventNotificationReceive"),
        FCEventIdTokenStatusChange("FCEventIdTokenStatusChange"),
        FCEventDropDownShow("FCEventDropDownShow"),
        FCEventDropDownOptionSelect("FCEventDropDownOptionSelect"),
        FCEventCarouselShow("FCEventCarouselShow"),
        FCEventCarouselOptionSelect("FCEventCarouselOptionSelect"),
        FCEventCarouselOptionView("FCEventCarouselOptionView"),
        FCEventCalendarFindTimeSlotClick("FCEventCalendarFindTimeSlotClick"),
        FCEventCalendarInviteCancel("FCEventCalendarInviteCancel"),
        FCEventCalendarNoTimeSlotFound("FCEventCalendarNoTimeSlotFound"),
        FCEventCalendarBookingSuccess("FCEventCalendarBookingSuccess"),
        FCEventCalendarBookingRetry("FCEventCalendarBookingRetry"),
        FCEventCalendarBookingFailure("FCEventCalendarBookingFailure"),
        FCEventShowOriginalClick("FCEventShowOriginalClick"),
        FCEventHideOriginalClick("FCEventHideOriginalClick"),
        FCEventQuickActionSelect("FCEventQuickActionSelect");
        
        public static Map<String, EventName> eventNameMap;
        public String name;

        /* access modifiers changed from: public */
        static {
            int i;
            eventNameMap = new HashMap();
            try {
                for (EventName eventName : values()) {
                    eventNameMap.put(eventName.name, eventName);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }

        /* access modifiers changed from: public */
        EventName(String str) {
            this.name = str;
        }

        public static EventName get(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("event_name")) {
                return null;
            }
            return eventNameMap.get(bundle.getString("event_name"));
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public enum Property {
        FCPropertyInputTags("FCPropertyInputTags"),
        FCPropertyFAQCategoryID("FCPropertyFAQCategoryID"),
        FCPropertyFAQCategoryName("FCPropertyFAQCategoryName"),
        FCPropertyFAQID("FCPropertyFAQID"),
        FCPropertyFAQTitle("FCPropertyFAQTitle"),
        FCPropertySearchKey("FCPropertySearchKey"),
        FCPropertySearchFAQCount("FCPropertySearchFAQCount"),
        FCPropertyIsRelevant("FCPropertyIsRelevant"),
        FCPropertyIsHelpful("FCPropertyIsHelpful"),
        FCPropertyChannelID("FCPropertyChannelID"),
        FCPropertyConversationID("FCPropertyConversationID"),
        FCPropertyChannelName("FCPropertyChannelName"),
        FCPropertyResolutionStatus("FCPropertyResolutionStatus"),
        FCPropertyRating("FCPropertyRating"),
        FCPropertyComment("FCPropertyComment"),
        FCPropertyURL("FCPropertyURL"),
        FCPropertyOption("FCPropertyOption"),
        FCPropertyInviteId("FCPropertyInviteId"),
        FCPropertyBotFAQTitle("FCPropertyBotFAQTitle"),
        FCPropertyBotFAQReferenceId("FCPropertyBotFAQReferenceId"),
        FCPropertyBotFAQPlaceholderReferenceId("FCPropertyBotFAQPlaceholderReferenceId"),
        FCPropertyBotFAQFeedback("FCPropertyBotFAQFeedback"),
        FCPropertyQuickActionType("FCPropertyQuickActionType"),
        FCPropertyQuickActionLabel("FCPropertyQuickActionLabel");
        
        public static Map<String, Property> eventPropertyMap;
        public String name;

        /* access modifiers changed from: public */
        static {
            int i;
            eventPropertyMap = new HashMap();
            try {
                for (Property property : values()) {
                    eventPropertyMap.put(property.name, property);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }

        /* access modifiers changed from: public */
        Property(String str) {
            this.name = str;
        }

        public static Property get(String str) {
            if (as.isEmpty(str)) {
                return null;
            }
            return eventPropertyMap.get(str);
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public EventName getEventName() {
        return this.eventName;
    }

    public Map<Property, Object> getProperties() {
        return this.properties;
    }

    public void setEventName(EventName eventName2) {
        this.eventName = eventName2;
    }

    public void setProperties(Map<Property, Object> map) {
        this.properties = map;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Event{eventName=");
        outline73.append(this.eventName);
        outline73.append(", properties=");
        outline73.append(this.properties);
        outline73.append('}');
        return outline73.toString();
    }
}
