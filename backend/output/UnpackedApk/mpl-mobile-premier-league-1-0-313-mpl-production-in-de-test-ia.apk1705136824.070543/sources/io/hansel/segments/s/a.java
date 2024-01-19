package io.hansel.segments.s;

import android.database.Cursor;
import android.util.Pair;
import io.hansel.core.criteria.node.ConditionNode;
import java.util.HashMap;

public abstract class a {
    public abstract Pair<HashMap<String, HashMap<Object, Integer>>, Long> a(ConditionNode conditionNode, Cursor cursor, HashMap<String, HashMap<Object, Integer>> hashMap);
}
