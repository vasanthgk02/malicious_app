package io.hansel.core.base;

import android.content.Context;
import android.util.Pair;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONArray;
import java.util.HashMap;
import java.util.Set;

public abstract class HSLEventsSource {
    public Context context;

    public HSLEventsSource(Context context2) {
        this.context = context2;
    }

    public abstract Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> getEvents(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode);

    public abstract Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> getEvents(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode, long j3, Set<Integer> set, CoreJSONArray coreJSONArray);
}
