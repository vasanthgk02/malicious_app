package io.hansel.userjourney.r;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.segments.n;
import io.hansel.userjourney.models.a;
import java.util.ArrayList;
import java.util.List;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public List<a> f5730c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Context f5731d;

    public b(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        super(str, str2, coreJSONObject, context);
        this.f5731d = context;
        try {
            a(coreJSONObject.optString("idx"));
            CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("segs");
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f5730c.add(new a(str, str2, optJSONArray.getJSONObject(i), context));
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            HSLLogger.e("Exception: Unable to create decision node for json " + coreJSONObject);
        }
    }

    private Pair<Integer, String> b(String str) {
        List<a> list = this.f5730c;
        if (str != null) {
            int size = list == null ? 0 : list.size();
            for (int i = 0; i < size; i++) {
                ArrayList<c> a2 = this.f5730c.get(i).a();
                int size2 = a2 == null ? 0 : a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (str.startsWith(a2.get(i2).b())) {
                        return new Pair<>(Integer.valueOf(i), str);
                    }
                }
            }
        } else {
            int size3 = list == null ? 0 : list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                if (n.a(this.f5731d).c(this.f5730c.get(i3).b())) {
                    return new Pair<>(Integer.valueOf(i3), str);
                }
            }
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("No segment satisfied for decision node with segment List ");
        outline73.append(this.f5730c);
        HSLLogger.w(outline73.toString(), LogGroup.CS);
        throw new IllegalStateException("Bad Segments; cannot bisect into path");
    }

    public Pair<String, ArrayList<c>> b(String str, String str2) {
        Throwable th;
        String str3;
        try {
            HSLLogger.d("Invoked getStatements method in DecisionNode for journey " + str + "with leaf node id " + str2 + " and current node id " + b());
            Pair<Integer, String> b2 = b(str2);
            str3 = (String) b2.second;
            try {
                return new Pair<>(str3, this.f5730c.get(((Integer) b2.first).intValue()).a());
            } catch (Throwable th2) {
                th = th2;
                HSLLogger.printStackTrace(th);
                HSLLogger.e("Error: Unable to get statements for Decision Node with id " + b() + " and journey id " + str + "with leaf node id " + str3);
                return null;
            }
        } catch (Throwable th3) {
            str3 = str2;
            th = th3;
            HSLLogger.printStackTrace(th);
            HSLLogger.e("Error: Unable to get statements for Decision Node with id " + b() + " and journey id " + str + "with leaf node id " + str3);
            return null;
        }
    }

    public List<a> c() {
        return this.f5730c;
    }
}
