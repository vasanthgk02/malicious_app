package io.hansel.core.criteria;

import io.hansel.core.criteria.node.HSLCriteriaNode;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HSLCriteriaAttributes implements Serializable {
    public final Set<String> allRuleFields = new HashSet();
    public Set<String> attributes = new HashSet();
    public Set<String> events = new HashSet();
    public HashMap<String, Set<String>> fields = new HashMap<>();
    public HSLCriteriaNode hslCriteriaNode;

    public void addRuleField(String str) {
        this.allRuleFields.add(str);
    }

    public void addSubSegmentField(String str, String str2, boolean z) {
        Set set = this.fields.get(str);
        if (set == null) {
            set = new HashSet();
        }
        set.add(str2);
        this.fields.put(str, set);
        (z ? this.events : this.attributes).add(str2);
    }

    public Set<String> getAllRuleFields() {
        return this.allRuleFields;
    }

    public Set<String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashSet();
        }
        return this.attributes;
    }

    public Set<String> getEvents() {
        if (this.events == null) {
            this.events = new HashSet();
        }
        return this.events;
    }

    public HSLCriteriaNode getHslCriteriaNode() {
        return this.hslCriteriaNode;
    }

    public HashMap<String, Set<String>> getSubSegmentFields() {
        return this.fields;
    }

    public void setHslCriteriaNode(HSLCriteriaNode hSLCriteriaNode) {
        this.hslCriteriaNode = hSLCriteriaNode;
    }
}
