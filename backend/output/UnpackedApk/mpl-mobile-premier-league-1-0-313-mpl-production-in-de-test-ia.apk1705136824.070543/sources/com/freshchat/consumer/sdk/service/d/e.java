package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.b.a.a;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.e.c;
import com.freshchat.consumer.sdk.e.d;
import com.freshchat.consumer.sdk.e.f;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static void a(com.freshchat.consumer.sdk.b.e eVar, List<Article> list) {
        if (eVar != null) {
            try {
                if (!k.isEmpty(list)) {
                    String bt = eVar.bt();
                    if (!as.isEmpty(bt)) {
                        long parseLong = Long.parseLong(bt);
                        ArrayList arrayList = new ArrayList();
                        for (Article next : list) {
                            if (Long.parseLong(next.getUpdatedAt()) > parseLong) {
                                arrayList.add(next.getId());
                            }
                        }
                        if (!k.isEmpty(arrayList)) {
                            JSONObject iK = eVar.iK();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                if (eVar.iK().has(str)) {
                                    iK.remove(str);
                                }
                            }
                            eVar.a(iK);
                        }
                    }
                }
            } catch (Exception e2) {
                ai.e("FRESHCHAT_WARNING", e2.toString());
            }
        }
    }

    public static Map<String, String> c(com.freshchat.consumer.sdk.b.e eVar) {
        String bt = eVar.bt();
        HashMap hashMap = new HashMap();
        if (as.a(bt)) {
            hashMap.put("If-Modified-Since", bt);
        }
        return hashMap;
    }

    public static boolean c(Context context, a aVar) {
        boolean z;
        String valueOf;
        JSONArray jSONArray;
        int i;
        JSONArray jSONArray2;
        int i2;
        if (aVar.isValid() && aVar.cn()) {
            JSONObject cm = aVar.cm();
            if (cm != null) {
                try {
                    JSONArray jSONArray3 = cm.getJSONArray("categories");
                    int length = jSONArray3.length();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject = jSONArray3.getJSONObject(i3);
                        if (c(jSONObject)) {
                            Category category = Category.getCategory(jSONObject);
                            arrayList.add(category);
                            JSONArray optJSONArray = jSONObject.optJSONArray("articles");
                            if (optJSONArray != null) {
                                int length2 = optJSONArray.length();
                                int i4 = 0;
                                while (i4 < length2) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                                    if (c(jSONObject2)) {
                                        jSONArray2 = jSONArray3;
                                        Article article = Article.getArticle(jSONObject2);
                                        arrayList2.add(article);
                                        i2 = length;
                                        List<Tag> a2 = f.a(article.getId(), jSONObject2.optJSONArray("tags"), TaggedType.ARTICLE);
                                        if (a2 != null) {
                                            arrayList3.addAll(a2);
                                        }
                                    } else {
                                        jSONArray2 = jSONArray3;
                                        i2 = length;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                    length = i2;
                                }
                            }
                            jSONArray = jSONArray3;
                            i = length;
                            List<Tag> a3 = f.a(category.getId(), jSONObject.optJSONArray("tags"), TaggedType.CATEGORY);
                            if (a3 != null) {
                                arrayList3.addAll(a3);
                            }
                        } else {
                            jSONArray = jSONArray3;
                            i = length;
                        }
                        i3++;
                        jSONArray3 = jSONArray;
                        length = i;
                    }
                    com.freshchat.consumer.sdk.b.e w = w(context);
                    a(w, arrayList2);
                    w.bO();
                    i iVar = new i(context);
                    iVar.a(arrayList, arrayList2, arrayList3);
                    try {
                        iVar.cM();
                        w.bs();
                        if (cm.has("contentLocale")) {
                            JSONObject jSONObject3 = cm.getJSONObject("contentLocale");
                            if (jSONObject3 != null) {
                                w.z(jSONObject3.toString());
                            }
                        }
                        if (cm.has("lastModifiedAt")) {
                            valueOf = cm.getString("lastModifiedAt");
                        } else {
                            if (k.a(arrayList)) {
                                long j = 0;
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    j = Math.max(j, ((Category) it.next()).getUpdatedAt());
                                }
                                valueOf = String.valueOf(j);
                            }
                            w.A(ah.bc(context));
                            return true;
                        }
                        w.y(valueOf);
                        w.A(ah.bc(context));
                        return true;
                    } catch (JSONException e2) {
                        e = e2;
                        z = true;
                        ai.e("FRESHCHAT", "Exception occured", e);
                        return z;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    z = false;
                    ai.e("FRESHCHAT", "Exception occured", e);
                    return z;
                }
            }
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        try {
            if (!jSONObject.getBoolean(RNGestureHandlerModule.KEY_ENABLED)) {
                return false;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("platforms");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (jSONArray.getString(i).equalsIgnoreCase("android")) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e2) {
            q.a(e2);
        }
    }

    public static com.freshchat.consumer.sdk.b.e w(Context context) {
        return com.freshchat.consumer.sdk.b.e.i(context);
    }

    public static boolean x(Context context) {
        com.freshchat.consumer.sdk.b.e i = com.freshchat.consumer.sdk.b.e.i(context);
        try {
            aa.fF();
            d a2 = new c(context).a(com.freshchat.consumer.sdk.j.a.z(context), c(i));
            int statusCode = a2.getStatusCode();
            if (a2.getStatusCode() == 410) {
                f.o(context, c.a(a2));
                return false;
            } else if (statusCode == 200) {
                return c(context, new a(a2.getInputStream()));
            } else {
                if (statusCode != 304) {
                    return false;
                }
                i.bs();
                return false;
            }
        } catch (DeletedException | Exception e2) {
            q.a(e2);
            return false;
        }
    }
}
