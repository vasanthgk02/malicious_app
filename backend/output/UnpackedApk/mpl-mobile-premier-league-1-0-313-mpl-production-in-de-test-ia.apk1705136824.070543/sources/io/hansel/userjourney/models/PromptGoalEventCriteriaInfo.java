package io.hansel.userjourney.models;

import androidx.core.app.NotificationCompatJellybean;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONObject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PromptGoalEventCriteriaInfo implements Serializable {
    public HSLCriteriaAttributes criteriaAttributes;
    public CoreJSONObject typeJSON;

    public PromptGoalEventCriteriaInfo(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        this.criteriaAttributes = HSLCriteriaBuilder.build("", coreJSONObject, null, new HSLCriteriaAttributes(), true, null);
        this.typeJSON = coreJSONObject2;
    }

    private Set<String> getAggPropertiesToKeep() {
        HashSet hashSet = new HashSet();
        CoreJSONObject coreJSONObject = this.typeJSON;
        if (coreJSONObject != null) {
            String optString = coreJSONObject.optString(NotificationCompatJellybean.KEY_LABEL);
            if (optString != null && optString.equals("sum")) {
                String optString2 = this.typeJSON.optString("property");
                if (optString2 != null) {
                    hashSet.add(optString2);
                }
            }
        }
        return hashSet;
    }

    public HSLCriteriaAttributes getCriteriaAttributes() {
        return this.criteriaAttributes;
    }

    public Set<String> getPropertiesToKeep() {
        HashSet hashSet = new HashSet();
        HSLCriteriaAttributes hSLCriteriaAttributes = this.criteriaAttributes;
        if (hSLCriteriaAttributes != null) {
            hashSet.addAll(hSLCriteriaAttributes.getAllRuleFields());
        }
        hashSet.addAll(getAggPropertiesToKeep());
        return hashSet;
    }
}
