package io.hansel.segments;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import io.hansel.core.criteria.datatype.DataType;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.segments.s.d;
import io.hansel.segments.s.d.a;
import io.hansel.userjourney.models.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f5247c;

    /* renamed from: a  reason: collision with root package name */
    public Context f5248a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, b> f5249b = new HashMap<>();

    public e(Context context) {
        this.f5248a = context;
    }

    private CoreJSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.size() == 0) {
            return new CoreJSONObject();
        }
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            a a2 = d.a(this.f5248a).a(str, hashMap.get(str));
            try {
                if (a2.a() != DataType.other) {
                    coreJSONObject.put(a2.b(), (Object) a2.c());
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return coreJSONObject;
    }

    public static e a(Context context) {
        if (f5247c == null) {
            f5247c = new e(context);
        }
        return f5247c;
    }

    private void a(long j, String str, String str2, String str3) {
        if (f.c(this.f5248a, str)) {
            d.a(this.f5248a).a(j, str, str2, str3);
        }
    }

    private void a(Set<String> set) {
        ArrayList<String> b2 = f.b(this.f5248a);
        HashSet hashSet = new HashSet();
        if (!b2.isEmpty()) {
            int size = b2.size();
            for (int i = 0; i < size; i++) {
                String str = b2.get(i);
                if (!set.contains(str)) {
                    hashSet.add(str);
                }
            }
        }
        f.a(this.f5248a, set);
        d.a(this.f5248a).a((Set<String>) hashSet);
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode) {
        return d.a(this.f5248a).a(GeneratedOutlineSupport.outline50(str, str2), str3, j, j2, conditionNode);
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, String str3, long j, long j2, ConditionNode conditionNode, long j3, Set<Integer> set, CoreJSONArray coreJSONArray) {
        return d.a(this.f5248a).a(GeneratedOutlineSupport.outline50(str, str2), str3, j, j2, conditionNode, j3, set, coreJSONArray);
    }

    public b a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        b bVar = new b(str, str2, System.currentTimeMillis(), "", str3, a(hashMap));
        HashMap<String, b> hashMap2 = this.f5249b;
        hashMap2.put(str + str2, bVar);
        return bVar;
    }

    public void a() {
        d.a(this.f5248a).a(f.a(this.f5248a));
    }

    public void a(CoreJSONObject coreJSONObject) {
        if (coreJSONObject != null) {
            try {
                CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("c");
                if (optJSONObject != null) {
                    f.a(this.f5248a, optJSONObject.getInt("c_d"));
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
            try {
                HashSet hashSet = new HashSet();
                CoreJSONObject optJSONObject2 = coreJSONObject.optJSONObject("e");
                if (optJSONObject2.keySet().size() > 0) {
                    ArrayList arrayList = new ArrayList(optJSONObject2.keySet());
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        String str = (String) arrayList.get(i);
                        CoreJSONArray optJSONArray = optJSONObject2.optJSONArray(str);
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            hashSet.add(((CoreJSONObject) optJSONArray.get(i2)).optString(HyperVergeKycCapture.EN) + str);
                        }
                    }
                    a((Set<String>) hashSet);
                    return;
                }
                d.a(this.f5248a).a();
            } catch (CoreJSONException e3) {
                HSLLogger.printStackTrace(e3);
            }
        }
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(this.f5249b.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f5249b.get(arrayList.get(i));
            if (bVar != null) {
                CoreJSONObject b2 = bVar.b();
                String coreJSONObject = b2 == null ? "" : b2.toString();
                long e2 = bVar.e();
                a(e2, bVar.a() + bVar.g(), bVar.f(), coreJSONObject);
                hashSet.add(bVar.a() + bVar.g());
            }
        }
        this.f5249b = new HashMap<>();
        return hashSet;
    }
}
