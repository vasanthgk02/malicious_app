package com.inbrain.sdk;

import com.inbrain.sdk.model.Reward;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {

    public interface a {
        void a(Throwable th);

        void a(List<Reward> list);
    }

    public final void a(boolean z, String str, final a aVar, String str2, String str3) {
        new c(new b(this) {
            public final void a(Exception exc) {
                aVar.a((Throwable) exc);
            }

            public final void a(String str) {
                a aVar = aVar;
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Reward reward = new Reward(jSONObject.getLong("transactionId"), (float) jSONObject.getDouble("amount"), jSONObject.getString("currency"), jSONObject.getInt("transactionType"));
                        arrayList.add(reward);
                    }
                    aVar.a((List<Reward>) arrayList);
                } catch (JSONException e2) {
                    aVar.a((Throwable) e2);
                }
            }
        }).execute(new String[]{String.format("%s%s/%s/%s", new Object[]{z ? "https://inbrain-api-qa.azurewebsites.net/api/v1/external-surveys/" : "https://api.surveyb.in/api/v1/external-surveys/", "rewards", str2, str3}), str});
    }
}
