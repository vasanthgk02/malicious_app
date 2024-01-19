package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.module.EventData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class HSLCriteriaNode implements Serializable {
    public ArrayList<HSLCriteriaNode> mCriteriaNodes;

    public HSLCriteriaNode(ArrayList<HSLCriteriaNode> arrayList) {
        this.mCriteriaNodes = arrayList;
    }

    public boolean evaluate(CoreJSONObject coreJSONObject) {
        return false;
    }

    public abstract boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData);

    public boolean evaluateFromMap(Map<String, Object> map) {
        return false;
    }

    public ArrayList<HSLCriteriaNode> getmCriteriaNodes() {
        return this.mCriteriaNodes;
    }
}
