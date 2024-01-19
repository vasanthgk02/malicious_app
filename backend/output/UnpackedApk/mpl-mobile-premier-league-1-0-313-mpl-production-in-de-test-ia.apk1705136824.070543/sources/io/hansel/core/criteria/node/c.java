package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.module.EventData;
import java.util.ArrayList;
import java.util.HashMap;

public class c extends f {
    public c(ArrayList<HSLCriteriaNode> arrayList, String str) {
        super(arrayList, str);
    }

    private boolean a(HashMap<String, Object> hashMap, EventData eventData) {
        eventData.addSubSegmentTs(a(), -2);
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        return getmCriteriaNodes().get(0).evaluate(hashMap, null, eventData);
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        if (eventData.getSubSegIds() == null || !eventData.getSubSegIds().contains(a()) || eventData.getValuesMap() == null || !eventData.getValuesMap().containsKey(a())) {
            boolean a2 = a(hashMap, eventData);
            eventData.addSubSegmentValue(a(), a2);
            return a2;
        }
        Object obj = eventData.getValuesMap().get(a());
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
