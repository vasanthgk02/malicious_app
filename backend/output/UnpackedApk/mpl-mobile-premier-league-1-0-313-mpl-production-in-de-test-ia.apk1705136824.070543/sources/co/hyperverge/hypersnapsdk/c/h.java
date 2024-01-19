package co.hyperverge.hypersnapsdk.c;

import android.annotation.SuppressLint;
import android.os.Build;
import co.hyperverge.hypersnapsdk.b.f.a;
import co.hyperverge.hypersnapsdk.b.f.a.b;
import co.hyperverge.hypersnapsdk.f.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;

/* compiled from: HVFeatureConfigHelper */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ boolean f3103b = (!h.class.desiredAssertionStatus());

    @SuppressLint({"LogNotTimber"})
    public static Map<String, Boolean> a(List<a> list, List<a> list2) {
        "extractFeatureMap() called with: sdkFeatureConfigs = [" + list + "], vsFeatureConfigs = [" + list2 + CMapParser.MARK_END_OF_ARRAY;
        HashMap hashMap = new HashMap();
        a(hashMap, list);
        a(hashMap, list2);
        "extractFeatureMap: featureToggleMap: " + hashMap;
        return hashMap;
    }

    public static Map<String, Boolean> a() {
        return a(Collections.singletonList(new a("camera2", false, Arrays.asList(new b[]{new b("huawei", true, new ArrayList()), new b("comio", true, Collections.singletonList("comio x1")), new b("lg", true, new ArrayList()), new b("google", true, Collections.singletonList("nexus")), new b("samsung", true, Arrays.asList(new String[]{"sm-a315f", "sm-505f"}))}))), (List<a>) new ArrayList<a>());
    }

    public static void a(HashMap<String, Boolean> hashMap, List<a> list) {
        Boolean valueOf;
        for (a next : list) {
            if (f3103b || next != null) {
                String str = next.f3029a;
                Iterator<b> it = next.f3031c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        valueOf = Boolean.valueOf(next.f3030b);
                        break;
                    }
                    b next2 = it.next();
                    if ((next2.f3032a.equalsIgnoreCase(Build.BRAND) || next2.f3032a.equalsIgnoreCase(Build.MANUFACTURER)) && (next2.f3034c.isEmpty() || i.a(next2.f3034c, Build.MODEL.toLowerCase()))) {
                        valueOf = Boolean.valueOf(next2.f3033b);
                        continue;
                    } else {
                        valueOf = null;
                        continue;
                    }
                    if (valueOf != null) {
                        break;
                    }
                }
                hashMap.put(str, valueOf);
            } else {
                throw new AssertionError();
            }
        }
    }
}
