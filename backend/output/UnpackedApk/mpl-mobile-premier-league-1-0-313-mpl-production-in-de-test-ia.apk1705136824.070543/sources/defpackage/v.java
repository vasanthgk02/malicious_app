package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException: Cannot invoke "java.util.List.forEach(java.util.function.Consumer)" because "blocks" is null
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:573)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:217)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:150)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:57)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:50)
    */
/* renamed from: v  reason: default package */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static bh f3341a = new bh();

    static {
    }

    public static Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(ch$b.PROFILE.f89a, bundle);
        return bundle2;
    }

    public static Bundle a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        cp.a((String) "v", (String) "Profile Information", bundle.toString());
        return bundle;
    }

    public static JSONObject a(Context context, String str, Bundle bundle, ag agVar) throws IOException, AuthError {
        cp.a((String) "v", (String) "Fetching remote profile information");
        bh.a(context);
        bf bfVar = (bf) new be(bundle, str, context, agVar).a();
        bfVar.a();
        return bfVar.f2786a;
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        cp.a((String) "v", (String) "Updating local profile information");
        ap a2 = ap.a(context);
        a2.a();
        a2.a(new aj(str, jSONObject.toString()));
    }

    public static String[] a(Context context, ag agVar) {
        aq a2 = aq.a(context);
        String str = agVar.f2705b;
        if (a2 != null) {
            int i = 0;
            ArrayList arrayList = (ArrayList) a2.a(new String[]{aq.f61a[a.APP_FAMILY_ID.f52a]}, new String[]{str});
            String[] strArr = new String[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                strArr[i] = ((ak) it.next()).f50b;
                i++;
            }
            return strArr;
        }
        throw null;
    }
}
