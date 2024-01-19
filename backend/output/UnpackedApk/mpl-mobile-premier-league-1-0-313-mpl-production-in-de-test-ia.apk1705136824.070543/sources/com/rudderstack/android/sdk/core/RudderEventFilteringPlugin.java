package com.rudderstack.android.sdk.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RudderEventFilteringPlugin {
    public static final String BLACKLISTED_EVENTS = "blacklistedEvents";
    public static final String DISABLE = "disable";
    public static final String EVENT_FILTERING_OPTION = "eventFilteringOption";
    public static final String EVENT_NAME = "eventName";
    public static final String WHITELISTED_EVENTS = "whitelistedEvents";
    public Map<String, List<String>> blacklistEvents = new HashMap();
    public Map<String, String> eventFilteringOption = new HashMap();
    public Map<String, List<String>> whitelistEvents = new HashMap();

    public RudderEventFilteringPlugin(List<RudderServerDestination> list) {
        if (!list.isEmpty()) {
            for (RudderServerDestination next : list) {
                Map map = (Map) next.destinationConfig;
                String str = next.destinationDefinition.displayName;
                String str2 = map.containsKey(EVENT_FILTERING_OPTION) ? (String) map.get(EVENT_FILTERING_OPTION) : DISABLE;
                if (!str2.equals(DISABLE) && !this.eventFilteringOption.containsKey(str)) {
                    this.eventFilteringOption.put(str, str2);
                    if (str2.equals(WHITELISTED_EVENTS) && map.containsKey(WHITELISTED_EVENTS)) {
                        setEvent(str, (List) map.get(WHITELISTED_EVENTS), this.whitelistEvents);
                    } else if (str2.equals(BLACKLISTED_EVENTS) && map.containsKey(BLACKLISTED_EVENTS)) {
                        setEvent(str, (List) map.get(BLACKLISTED_EVENTS), this.blacklistEvents);
                    }
                }
            }
        }
    }

    private void handleLogMessage(boolean z, String str, String str2) {
        if (!z) {
            if (getEventFilterType(str).equals(WHITELISTED_EVENTS)) {
                RudderLogger.logInfo("Since " + str2 + " event is not Whitelisted it is being dropped.");
                return;
            }
            RudderLogger.logInfo("Since " + str2 + " event is Blacklisted it is being dropped.");
        }
    }

    private void setEvent(String str, List<Map<String, String>> list, Map<String, List<String>> map) {
        map.put(str, new ArrayList());
        for (Map<String, String> map2 : list) {
            String trim = String.valueOf(map2.get("eventName")).trim();
            if (!TextUtils.isEmpty(trim)) {
                map.get(str).add(trim);
            }
        }
    }

    public List<String> getBlacklistEvents(String str) {
        return this.blacklistEvents.get(str);
    }

    public String getEventFilterType(String str) {
        return this.eventFilteringOption.get(str);
    }

    public List<String> getWhitelistEvents(String str) {
        return this.whitelistEvents.get(str);
    }

    public boolean isEventAllowed(String str, RudderMessage rudderMessage) {
        boolean z = true;
        if (rudderMessage != null && !TextUtils.isEmpty(rudderMessage.getType()) && rudderMessage.getType().equals(MessageType.TRACK) && !TextUtils.isEmpty(rudderMessage.getEventName()) && isEventFilterEnabled(str)) {
            if (getEventFilterType(str).equals(WHITELISTED_EVENTS)) {
                z = getWhitelistEvents(str).contains(rudderMessage.getEventName().trim());
            } else {
                z = true ^ getBlacklistEvents(str).contains(rudderMessage.getEventName().trim());
            }
            handleLogMessage(z, str, rudderMessage.getEventName().trim());
        }
        return z;
    }

    public boolean isEventFilterEnabled(String str) {
        return this.eventFilteringOption.containsKey(str);
    }
}
