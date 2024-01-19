package io.hansel.core.base;

import android.util.Pair;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f5094c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<HSLEventsSource> f5095a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f5096b;

    public static a a() {
        if (f5094c == null) {
            f5094c = new a();
        }
        return f5094c;
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode) {
        if (this.f5096b) {
            int size = this.f5095a.size();
            for (int i = 0; i < size; i++) {
                HSLEventsSource hSLEventsSource = this.f5095a.get(i);
                if (hSLEventsSource != null) {
                    return hSLEventsSource.getEvents(str, str2, str3, j, j2, conditionNode);
                }
            }
        }
        return null;
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode, long j3, Set<Integer> set, CoreJSONArray coreJSONArray) {
        if (this.f5096b) {
            int size = this.f5095a.size();
            for (int i = 0; i < size; i++) {
                HSLEventsSource hSLEventsSource = this.f5095a.get(i);
                if (hSLEventsSource != null) {
                    return hSLEventsSource.getEvents(str, str2, str3, j, j2, conditionNode, j3, set, coreJSONArray);
                }
            }
        }
        return null;
    }

    public void a(HSLEventsSource hSLEventsSource) {
        this.f5095a.add(hSLEventsSource);
    }

    public void b() {
        this.f5096b = true;
    }
}
