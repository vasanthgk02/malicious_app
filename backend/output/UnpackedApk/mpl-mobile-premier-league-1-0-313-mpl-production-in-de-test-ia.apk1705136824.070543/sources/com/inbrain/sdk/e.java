package com.inbrain.sdk;

import java.util.Set;
import org.json.JSONArray;

public final class e {

    public interface a {
        void a();

        void a(Throwable th);
    }

    public final void a(boolean z, String str, Set<Long> set, final a aVar, String str2, String str3) {
        if (set != null && !set.isEmpty()) {
            String format = String.format("%s%s/%s/%s", new Object[]{z ? "https://inbrain-api-qa.azurewebsites.net/api/v1/external-surveys/" : "https://api.surveyb.in/api/v1/external-surveys/", "confirm-transactions", str2, str3});
            JSONArray jSONArray = new JSONArray();
            for (Long put : set) {
                jSONArray.put(put);
            }
            new d(new b(this) {
                public final void a(Exception exc) {
                    aVar.a(exc);
                }

                public final void a(String str) {
                    aVar.a();
                }
            }).execute(new String[]{format, str, jSONArray.toString()});
        }
    }
}
