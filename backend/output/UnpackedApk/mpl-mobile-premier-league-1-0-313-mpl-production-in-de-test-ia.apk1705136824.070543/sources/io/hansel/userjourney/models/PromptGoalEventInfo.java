package io.hansel.userjourney.models;

import java.io.Serializable;
import java.util.Set;

public class PromptGoalEventInfo implements Serializable {
    public final long attributionDurationMillis;
    public final Set<PromptGoalEventCriteriaInfo> promptGoalEventCriteriaInfoSet;

    public PromptGoalEventInfo(long j, Set<PromptGoalEventCriteriaInfo> set) {
        this.attributionDurationMillis = j;
        this.promptGoalEventCriteriaInfoSet = set;
    }

    public long getAttributionDurationMillis() {
        return this.attributionDurationMillis;
    }

    public Set<PromptGoalEventCriteriaInfo> getPromptEventCriteriaInfoSet() {
        return this.promptGoalEventCriteriaInfoSet;
    }
}
