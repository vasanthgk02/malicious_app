package io.hansel.userjourney.r;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayList;

public class d extends c {

    /* renamed from: c  reason: collision with root package name */
    public String f5734c;

    public d(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        super(str, str2, coreJSONObject, context);
        a(coreJSONObject.optString("idx"));
        this.f5734c = coreJSONObject.optString("lidx");
    }

    public Pair<String, ArrayList<c>> b(String str, String str2) {
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("Invoked getStatements method in LeafNode for journey ", str, "with leaf node id ", str2, " and current node id ");
        outline82.append(b());
        HSLLogger.d(outline82.toString());
        return new Pair<>(str2, new ArrayList());
    }

    public String c() {
        return this.f5734c;
    }
}
