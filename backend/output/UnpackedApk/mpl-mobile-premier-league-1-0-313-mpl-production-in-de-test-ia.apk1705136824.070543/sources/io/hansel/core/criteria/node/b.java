package io.hansel.core.criteria.node;

import android.util.Pair;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import io.hansel.core.base.a;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.module.EventData;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class b extends f {

    /* renamed from: b  reason: collision with root package name */
    public boolean f5149b;

    /* renamed from: c  reason: collision with root package name */
    public String f5150c;

    /* renamed from: d  reason: collision with root package name */
    public String f5151d;

    /* renamed from: e  reason: collision with root package name */
    public int f5152e;

    /* renamed from: f  reason: collision with root package name */
    public String f5153f;
    public long g;
    public long h;
    public String i;
    public Set<Integer> j;
    public CoreJSONArray k;
    public boolean l = false;

    public b(ArrayList<HSLCriteriaNode> arrayList, boolean z, String str, String str2, String str3, int i2, String str4, long j2, long j3) {
        super(arrayList, str);
        this.f5149b = z;
        this.f5150c = str2;
        this.f5151d = str3;
        this.f5152e = i2;
        this.f5153f = str4;
        this.g = j2;
        this.h = j3;
    }

    public b(ArrayList<HSLCriteriaNode> arrayList, boolean z, String str, String str2, String str3, int i2, String str4, long j2, long j3, String str5, CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2) {
        super(arrayList, str);
        this.f5149b = z;
        this.f5150c = str2;
        this.f5151d = str3;
        this.f5152e = i2;
        this.f5153f = str4;
        this.g = j2;
        this.h = j3;
        this.i = str5;
        this.j = HSLUtils.createSetFromIntegerArray(coreJSONArray);
        this.k = coreJSONArray2;
    }

    public static long a(long j2, int i2, String str) {
        long j3;
        long j4;
        if ("min".equals(str)) {
            j4 = (long) i2;
            j3 = 60000;
        } else {
            j3 = 3600000;
            if (!TimePickerDialogModule.ARG_HOUR.equals(str)) {
                j3 = 86400000;
                if (!"day".equals(str)) {
                    return -1;
                }
            }
            j4 = (long) i2;
        }
        return j2 - (j4 * j3);
    }

    private boolean a(EventData eventData) {
        try {
            Object obj = eventData.getValuesMap().get(a());
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean a(boolean z) {
        return this.f5149b != z;
    }

    private boolean b(EventData eventData) {
        if (eventData.getEvent() == EventsConstants.GET_DATA_JOURNS) {
            return true;
        }
        if (eventData.getEvent() != EventsConstants.INSERT_IPA) {
            return false;
        }
        return (this.f5151d + this.f5150c).equals(eventData.getData());
    }

    private boolean c(EventData eventData) {
        long j2;
        long j3;
        HashMap hashMap;
        Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> pair;
        EventData eventData2 = eventData;
        eventData2.addSubSegmentTs(a(), -1);
        ArrayList<HSLCriteriaNode> arrayList = getmCriteriaNodes();
        long timeOffset = HSLUtils.getTimeOffset(this.i);
        ConditionNode conditionNode = (arrayList.get(0) == null || arrayList.get(0).getmCriteriaNodes() == null || arrayList.get(0).getmCriteriaNodes().size() <= 0) ? null : (ConditionNode) arrayList.get(0);
        long j4 = this.g;
        long j5 = this.h;
        if (j4 == -1) {
            long ts = eventData.getTs();
            j2 = ts;
            j3 = a(ts, this.f5152e, this.f5153f);
        } else {
            j3 = j4 - timeOffset;
            j2 = j5 - timeOffset;
        }
        if (this.l) {
            hashMap = null;
            pair = a.a().a(this.f5151d, this.f5150c, HSLFiltersInternal.getInstance().getUniqueId(), j3, j2, conditionNode, timeOffset, this.j, this.k);
        } else {
            hashMap = null;
            pair = a.a().a(this.f5151d, this.f5150c, HSLFiltersInternal.getInstance().getUniqueId(), j3, j2, conditionNode);
        }
        if (pair == null) {
            return false;
        }
        eventData2.addSubSegmentTs(a(), ((Long) ((Pair) pair.second).second).longValue());
        Pair pair2 = new Pair(pair.first, ((Pair) pair.second).first);
        if (arrayList.size() > 1 && arrayList.get(1) != null && arrayList.get(1).getmCriteriaNodes() != null && arrayList.get(1).getmCriteriaNodes().size() > 0) {
            return a(((ConditionNode) arrayList.get(1)).evaluate(hashMap, pair2, eventData2));
        }
        return a(((Integer) ((Pair) pair.second).first).intValue() > 0);
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        if (!b(eventData)) {
            return a(eventData);
        }
        boolean z = false;
        if (eventData.getSubSegIds() == null || !eventData.getSubSegIds().contains(a()) || eventData.getValuesMap() == null || !eventData.getValuesMap().containsKey(a())) {
            z = c(eventData);
            eventData.addSubSegmentValue(a(), z);
        } else {
            Object obj = eventData.getValuesMap().get(a());
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
        }
        return z;
    }
}
