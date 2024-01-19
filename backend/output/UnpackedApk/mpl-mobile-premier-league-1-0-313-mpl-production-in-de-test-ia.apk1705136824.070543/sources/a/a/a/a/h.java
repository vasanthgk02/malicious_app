package a.a.a.a;

import a.a.a.a.d.b;
import com.mpl.MLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public class h extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f2422a;

    public h(j jVar) {
        this.f2422a = jVar;
    }

    public void run() {
        j jVar = this.f2422a;
        if (jVar != null) {
            try {
                b.a((String) "DatabaseManagement", "readEventFromTable: " + System.currentTimeMillis());
                if (jVar.f2425b != null && jVar.f2424a != null) {
                    ArrayList arrayList = (ArrayList) jVar.f2425b.a().a(jVar.f2424a.getEventCount());
                    if (!arrayList.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            l lVar = (l) it.next();
                            String.valueOf(lVar.f2430a);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ts", Long.parseLong(lVar.f2433d));
                            jSONObject.put("evtName", lVar.f2431b);
                            jSONObject.put("evtData", new JSONObject(lVar.f2432c));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("signature", jVar.f2429f.a());
                        jSONObject2.put("events", jSONArray);
                        b.a((String) "DatabaseManagement", "readEventFromTable: " + jSONObject2);
                        long j = ((l) arrayList.get(arrayList.size() - 1)).f2430a;
                        jVar.f2427d = j;
                        jVar.f2428e = j - ((long) jVar.f2424a.getEventCount());
                        jVar.a(jSONObject2);
                    }
                }
            } catch (Exception e2) {
                if (b.f6a) {
                    MLog.e("DatabaseManagement", "readEventFromTable: ", e2);
                }
            }
        } else {
            throw null;
        }
    }
}
