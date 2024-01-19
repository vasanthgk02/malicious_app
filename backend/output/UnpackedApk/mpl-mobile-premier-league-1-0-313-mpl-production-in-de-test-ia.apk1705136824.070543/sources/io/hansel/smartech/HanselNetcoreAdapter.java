package io.hansel.smartech;

import android.app.Application;
import android.content.Context;
import com.netcore.android.smartechbase.communication.HanselInterface;
import com.netcore.android.smartechbase.communication.SmartechInterface;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.hanselsdk.Hansel;
import io.hansel.segments.n;
import io.hansel.segments.r;
import io.hansel.ujmtracker.HanselTracker;
import io.hansel.ujmtracker.d;
import io.hansel.ujmtracker.h;
import io.hansel.userjourney.HSLJourneyModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HanselNetcoreAdapter implements HanselInterface {
    public static String LIST_PREFIX = "l_";
    public static String SEGMENT_PREFIX = "s_";
    public Context context;

    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmartechInterface f5308a;

        public a(HanselNetcoreAdapter hanselNetcoreAdapter, SmartechInterface smartechInterface) {
            this.f5308a = smartechInterface;
        }

        public void a(String str, String str2, HashMap<String, Object> hashMap) {
            if (!str2.equals("smt")) {
                hashMap.put("hsl_ven", str2);
                h.a(hashMap);
                this.f5308a.trackEventFromHansel(str, hashMap);
            }
        }
    }

    public class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SmartechInterface f5309a;

        public b(HanselNetcoreAdapter hanselNetcoreAdapter, SmartechInterface smartechInterface) {
            this.f5309a = smartechInterface;
        }

        public void fireServerSegmentDataRequest(HSLSDKIdentifiers hSLSDKIdentifiers) {
            this.f5309a.fetchListAndSegment();
        }
    }

    public void clearUserIdentity() {
        Hansel.getUser().clear();
    }

    public void init(Application application, SmartechInterface smartechInterface, String str) {
        init(application, smartechInterface, null, null, str);
    }

    public void init(Application application, SmartechInterface smartechInterface, String str, String str2, String str3) {
        this.context = application.getApplicationContext();
        io.hansel.core.b.e().a(application, str, str2, str3);
        HanselTracker.setEventHandler(new a(this, smartechInterface));
        HSLJourneyModule.setServerSegmentRequestHandler(new b(this, smartechInterface));
    }

    public HashMap<String, Object> logEvent(String str, String str2, HashMap<String, Object> hashMap) {
        return HanselTracker.logEvent(str, str2, hashMap);
    }

    public void login(String str) {
        Hansel.getUser().setUserId(str);
    }

    public void setListAndSegmentsForUser(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(LIST_PREFIX + list.get(i));
            }
        }
        if (list2 != null) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(SEGMENT_PREFIX + list2.get(i2));
            }
        }
        n.a(this.context).b((List<String>) arrayList);
    }

    public void setUserAttributes(Map<String, ?> map) {
        Hansel.getUser().putAttributes(map);
    }
}
