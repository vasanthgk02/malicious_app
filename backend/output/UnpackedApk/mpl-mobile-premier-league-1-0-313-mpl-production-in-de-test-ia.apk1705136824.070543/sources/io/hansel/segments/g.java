package io.hansel.segments;

import android.content.Context;
import android.util.Pair;
import io.hansel.core.base.HSLEventsSource;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONArray;
import java.util.HashMap;
import java.util.Set;

public class g extends HSLEventsSource {
    public g(Context context) {
        super(context);
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> getEvents(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode) {
        return e.a(this.context).a(str, str2, str3, j, j2, conditionNode);
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> getEvents(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode, long j3, Set<Integer> set, CoreJSONArray coreJSONArray) {
        return e.a(this.context).a(str, str2, str3, j, j2, conditionNode, j3, set, coreJSONArray);
    }
}
