package defpackage;

import android.content.Context;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* renamed from: s  reason: default package */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f3330a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Region> f3331b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public Region f142a = Region.NA;

    /* renamed from: a  reason: collision with other field name */
    public String f143a;

    /* renamed from: a  reason: collision with other field name */
    public y f144a;

    /* renamed from: a  reason: collision with other field name */
    public z f145a = z.PROD;

    /* renamed from: a  reason: collision with other field name */
    public boolean f146a = false;

    static {
        a(y.AUTHORIZATION, z.DEVO, false, Region.NA, "https://na-account.integ.amazon.com");
        a(y.AUTHORIZATION, z.DEVO, false, Region.EU, "https://eu-account.integ.amazon.com");
        a(y.AUTHORIZATION, z.DEVO, false, Region.FE, "https://apac-account.integ.amazon.com");
        a(y.AUTHORIZATION, z.PRE_PROD, false, Region.NA, "https://na.account.amazon.com");
        a(y.AUTHORIZATION, z.PRE_PROD, false, Region.EU, "https://eu.account.amazon.com");
        a(y.AUTHORIZATION, z.PRE_PROD, false, Region.FE, "https://apac.account.amazon.com");
        a(y.AUTHORIZATION, z.PROD, false, Region.NA, "https://na.account.amazon.com");
        a(y.AUTHORIZATION, z.PROD, false, Region.EU, "https://eu.account.amazon.com");
        a(y.AUTHORIZATION, z.PROD, false, Region.FE, "https://apac.account.amazon.com");
        a(y.PANDA, z.DEVO, true, Region.NA, "https://api-sandbox.integ.amazon.com");
        a(y.PANDA, z.DEVO, true, Region.EU, "https://api-sandbox.integ.amazon.co.uk");
        a(y.PANDA, z.DEVO, true, Region.FE, "https://api-sandbox-jp.integ.amazon.com");
        a(y.PANDA, z.DEVO, false, Region.NA, "https://api.integ.amazon.com");
        a(y.PANDA, z.DEVO, false, Region.EU, "https://api.integ.amazon.co.uk");
        a(y.PANDA, z.DEVO, false, Region.FE, "https://api.integ.amazon.co.jp");
        a(y.PANDA, z.PRE_PROD, true, Region.NA, "https://api.sandbox.amazon.com");
        a(y.PANDA, z.PRE_PROD, true, Region.EU, "https://api.sandbox.amazon.co.uk");
        a(y.PANDA, z.PRE_PROD, true, Region.FE, "https://api-sandbox.amazon.co.jp");
        a(y.PANDA, z.PRE_PROD, false, Region.NA, "https://api-preprod.amazon.com");
        a(y.PANDA, z.PRE_PROD, false, Region.EU, "https://api-preprod.amazon.co.uk");
        a(y.PANDA, z.PRE_PROD, false, Region.FE, "https://api-preprod.amazon.co.jp");
        a(y.PANDA, z.PROD, true, Region.NA, "https://api.sandbox.amazon.com");
        a(y.PANDA, z.PROD, true, Region.EU, "https://api.sandbox.amazon.co.uk");
        a(y.PANDA, z.PROD, true, Region.FE, "https://api-sandbox.amazon.co.jp");
        a(y.PANDA, z.PROD, false, Region.NA, "https://api.amazon.com");
        a(y.PANDA, z.PROD, false, Region.EU, "https://api.amazon.co.uk");
        a(y.PANDA, z.PROD, false, Region.FE, "https://api.amazon.co.jp");
    }

    public s(Context context, ag agVar) {
        this.f142a = TweetUtils.a(context);
        this.f145a = cd.a();
        if (agVar != null) {
            this.f143a = agVar.g;
        }
    }

    public static String a(y yVar, z zVar, boolean z, Region region) {
        return String.format("%s.%s.%s.%s", new Object[]{yVar.toString(), zVar.toString(), Boolean.valueOf(z), region.toString()});
    }

    public static void a(y yVar, z zVar, boolean z, Region region, String str) {
        f3330a.put(a(yVar, zVar, z, region), str);
        if (Region.AUTO != region && y.PANDA == yVar) {
            f3331b.put(str, region);
        }
    }

    public Region a() {
        Region region = Region.NA;
        try {
            if (this.f143a == null) {
                return region;
            }
            Map<String, Region> map = f3331b;
            String str = this.f143a;
            return map.get("https://" + new URL(str).getHost());
        } catch (MalformedURLException unused) {
            return region;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m306a() throws MalformedURLException {
        if (Region.AUTO == this.f142a) {
            this.f142a = a();
        }
        return f3330a.get(a(this.f144a, this.f145a, this.f146a, this.f142a));
    }
}
