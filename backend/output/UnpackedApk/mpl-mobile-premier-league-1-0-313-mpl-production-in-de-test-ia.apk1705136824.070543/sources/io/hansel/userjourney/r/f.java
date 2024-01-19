package io.hansel.userjourney.r;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.userjourney.g;
import java.util.ArrayList;

public class f extends c {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f5742c;

    public f(String str, String str2, CoreJSONObject coreJSONObject, Context context) {
        this.f5742c = g.a(str, str2, coreJSONObject.optJSONArray("s"), context);
    }

    public Pair<String, ArrayList<c>> b(String str, String str2) {
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("Invoked getStatements method in LeafNode for journey ", str, "with leaf node id ", str2, " and current node id ");
        outline82.append(b());
        HSLLogger.d(outline82.toString());
        return new Pair<>(str2, this.f5742c);
    }
}
