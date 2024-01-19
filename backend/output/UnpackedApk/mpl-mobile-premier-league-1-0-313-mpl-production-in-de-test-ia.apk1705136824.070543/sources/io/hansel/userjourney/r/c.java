package io.hansel.userjourney.r;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;
import java.util.List;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public String f5732a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f5733b;

    public c() {
    }

    public c(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        try {
            CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("e_s");
            this.f5733b = new ArrayList<>();
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f5733b.add(new a(str, str2, optJSONArray.getJSONObject(i), context));
            }
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static c a(List<c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (c) GeneratedOutlineSupport.outline29(list, -1);
    }

    public ArrayList<a> a() {
        return this.f5733b;
    }

    public ArrayList<c> a(String str, String str2) {
        Exception e2;
        String str3;
        try {
            HSLLogger.e("Invoked getBranch method for journey " + str + "with leaf node id " + str2 + " and current node id " + b());
            Pair<String, ArrayList<c>> b2 = b(str, str2);
            str3 = (String) b2.first;
            try {
                ArrayList arrayList = (ArrayList) b2.second;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                ArrayList<c> arrayList2 = new ArrayList<>(arrayList);
                c a2 = a((List<c>) arrayList);
                if (a2 == null) {
                    return new ArrayList<>();
                }
                if (str3 != null) {
                    String b3 = a2.b();
                    if (str3.startsWith(b3)) {
                        str3 = str3.replaceFirst(b3, "");
                    }
                }
                arrayList2.addAll(a2.a(str, str3));
                return arrayList2;
            } catch (Exception e3) {
                e2 = e3;
                HSLLogger.printStackTrace(e2);
                HSLLogger.e("Error: Unable to get Branch for journey " + str + "with leaf node id " + str3);
                return null;
            }
        } catch (Exception e4) {
            str3 = str2;
            e2 = e4;
            HSLLogger.printStackTrace(e2);
            HSLLogger.e("Error: Unable to get Branch for journey " + str + "with leaf node id " + str3);
            return null;
        }
    }

    public void a(String str) {
        this.f5732a = str;
    }

    public abstract Pair<String, ArrayList<c>> b(String str, String str2);

    public String b() {
        return this.f5732a;
    }
}
