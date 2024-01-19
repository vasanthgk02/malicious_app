package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.criteria.c;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.module.EventData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConditionNode extends HSLCriteriaNode {
    public c mOperator;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5147a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                io.hansel.core.criteria.c[] r0 = io.hansel.core.criteria.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5147a = r0
                r1 = 1
                io.hansel.core.criteria.c r2 = io.hansel.core.criteria.c.and     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f5147a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.core.criteria.c r2 = io.hansel.core.criteria.c.or     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.node.ConditionNode.a.<clinit>():void");
        }
    }

    public ConditionNode(c cVar, ArrayList<HSLCriteriaNode> arrayList) {
        super(arrayList);
        this.mOperator = cVar;
    }

    private boolean evaluateAND(CoreJSONObject coreJSONObject) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluate(coreJSONObject);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private boolean evaluateAND(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluate(hashMap, pair, eventData);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private boolean evaluateANDFromMap(Map<String, Object> map) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluateFromMap(map);
            if (!z) {
                break;
            }
        }
        return z;
    }

    private boolean evaluateOR(CoreJSONObject coreJSONObject) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluate(coreJSONObject);
            if (z) {
                break;
            }
        }
        return z;
    }

    private boolean evaluateOR(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluate(hashMap, pair, eventData);
            if (z) {
                break;
            }
        }
        return z;
    }

    private boolean evaluateORFromMap(Map<String, Object> map) {
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        int size = arrayList.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            z = arrayList.get(i).evaluateFromMap(map);
            if (z) {
                break;
            }
        }
        return z;
    }

    public boolean evaluate(CoreJSONObject coreJSONObject) {
        int i = a.f5147a[this.mOperator.ordinal()];
        if (i == 1) {
            return evaluateAND(coreJSONObject);
        }
        if (i != 2) {
            return false;
        }
        return evaluateOR(coreJSONObject);
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        int i = a.f5147a[this.mOperator.ordinal()];
        if (i == 1) {
            return evaluateAND(hashMap, pair, eventData);
        }
        if (i != 2) {
            return false;
        }
        return evaluateOR(hashMap, pair, eventData);
    }

    public boolean evaluateFromMap(Map<String, Object> map) {
        int i = a.f5147a[this.mOperator.ordinal()];
        if (i == 1) {
            return evaluateANDFromMap(map);
        }
        if (i != 2) {
            return false;
        }
        return evaluateORFromMap(map);
    }
}
