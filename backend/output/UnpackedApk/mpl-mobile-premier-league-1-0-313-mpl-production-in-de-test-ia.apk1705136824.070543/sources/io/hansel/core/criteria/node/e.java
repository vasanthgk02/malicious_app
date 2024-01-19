package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.module.EventData;
import java.util.ArrayList;
import java.util.HashMap;

public class e extends HSLCriteriaNode {
    public e(ArrayList<HSLCriteriaNode> arrayList) {
        super(arrayList);
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        return true;
    }
}
