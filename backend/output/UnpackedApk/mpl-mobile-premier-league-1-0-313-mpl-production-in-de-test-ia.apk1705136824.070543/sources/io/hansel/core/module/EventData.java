package io.hansel.core.module;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventData {
    public String data;
    public EventsConstants event;
    public Set<String> subSegIds;
    public long ts;
    public HashMap<String, Long> tssNew;
    public Map<String, ?> valuesMap;
    public HashMap<String, Boolean> valuesNew;

    public EventData(EventsConstants eventsConstants, String str, long j) {
        this.event = eventsConstants;
        this.data = str;
        this.ts = j;
    }

    public void addSubSegmentTs(String str, long j) {
        if (this.tssNew == null) {
            this.tssNew = new HashMap<>();
        }
        this.tssNew.put(str, Long.valueOf(j));
    }

    public void addSubSegmentValue(String str, boolean z) {
        if (this.valuesNew == null) {
            this.valuesNew = new HashMap<>();
        }
        this.valuesNew.put(str, Boolean.valueOf(z));
    }

    public String getData() {
        return this.data;
    }

    public EventsConstants getEvent() {
        return this.event;
    }

    public Set<String> getSubSegIds() {
        return this.subSegIds;
    }

    public HashMap<String, Long> getSubSegmentTs() {
        return this.tssNew;
    }

    public HashMap<String, Boolean> getSubSegmentValue() {
        return this.valuesNew;
    }

    public long getTs() {
        return this.ts;
    }

    public Map<String, ?> getValuesMap() {
        return this.valuesMap;
    }

    public void setSubSegIds(Set<String> set) {
        this.subSegIds = set;
    }

    public void setValuesMap(Map<String, ?> map) {
        this.valuesMap = map;
    }
}
