package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.criteria.datatype.DataType;
import io.hansel.core.module.EventData;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends d {

    /* renamed from: f  reason: collision with root package name */
    public io.hansel.core.criteria.a f5148f;

    public a(String str, DataType dataType, io.hansel.core.criteria.a aVar, Object obj, ArrayList<HSLCriteriaNode> arrayList, io.hansel.core.criteria.a aVar2) {
        super(str, dataType, aVar, obj, arrayList, (String) null);
        this.f5148f = aVar2;
    }

    public a(String str, DataType dataType, io.hansel.core.criteria.a aVar, ArrayList<Object> arrayList, ArrayList<HSLCriteriaNode> arrayList2, io.hansel.core.criteria.a aVar2) {
        super(str, dataType, aVar, arrayList, arrayList2, (String) null);
        this.f5148f = aVar2;
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        return a(this.f5148f, pair);
    }
}
