package com.freshchat.consumer.sdk.d;

import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class b<T> extends a<T> {
    public final String nh = "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL";
    public final HashMap<String, List<a>> ni = new HashMap<>();
    public final HashMap<Class, a> nj = new HashMap<>();

    public class a {
        public final Class clz;
        public final String fieldName;
        public final String label;
        public final String nk;
        public TypeAdapter<?> nl;

        public a(String str, String str2, String str3, Class cls) {
            this.nk = str;
            this.fieldName = str3;
            this.label = str2;
            this.clz = cls;
        }

        /* access modifiers changed from: private */
        public void setDelegate(TypeAdapter<?> typeAdapter) {
            this.nl = typeAdapter;
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.d.b$b  reason: collision with other inner class name */
    public class C0025b {
        public final String fieldName;
        public final String nk;
        public final Map<String, Class> nn = new HashMap();

        public C0025b(String str, String str2) {
            this.nk = str;
            this.fieldName = str2;
        }

        public C0025b a(String str, Class cls) {
            if (str == null || cls == null) {
                throw new IllegalArgumentException("label or clz cannot be null while adding secondaryType");
            }
            this.nn.put(str, cls);
            return this;
        }

        public void gY() {
            if (!k.c(this.nn)) {
                List list = (List) b.this.ni.get(this.nk);
                if (list == null) {
                    list = new ArrayList();
                }
                for (Entry next : this.nn.entrySet()) {
                    Class cls = (Class) next.getValue();
                    a aVar = new a(this.nk, (String) next.getKey(), this.fieldName, cls);
                    list.add(aVar);
                    b.this.nj.put(cls, aVar);
                }
                b.this.ni.put(this.nk, list);
                return;
            }
            throw new IllegalArgumentException("secondaryTypes list cannot be empty while registering");
        }
    }

    public b(Class cls, String str) {
        super(cls, str);
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        return new b<>(cls, str);
    }

    private boolean a(String str, JsonElement jsonElement) {
        if (as.isEmpty(str)) {
            return false;
        }
        if (this.eu.containsKey(str)) {
            return true;
        }
        List<a> list = this.ni.get(str);
        if (k.isEmpty(list)) {
            return false;
        }
        String str2 = null;
        for (a aVar : list) {
            if (as.isEmpty(str2)) {
                str2 = super.a(jsonElement, aVar.clz, aVar.fieldName);
            }
            if (as.isEmpty(str2)) {
                return false;
            }
            if (aVar.label.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public <R> JsonObject a(String str, TypeAdapter<R> typeAdapter, R r) {
        JsonObject a2 = super.a(str, typeAdapter, r);
        if (as.p(str, "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL")) {
            return a2;
        }
        try {
            return (JsonObject) new JsonParser().parse(a2.getAsJsonPrimitive("rawJsonOfUnsupportedType").getAsString());
        } catch (Exception e2) {
            q.a(e2);
            return a2;
        }
    }

    public TypeAdapter<?> a(Class<?> cls, Map<Class<?>, TypeAdapter<?>> map) {
        a aVar = this.nj.get(cls);
        return aVar != null ? aVar.nl : super.a(cls, map);
    }

    public TypeAdapter<?> a(String str, Map<String, TypeAdapter<?>> map, JsonElement jsonElement, Class<?> cls) {
        try {
            if (this.ni.containsKey(str)) {
                List<a> list = this.ni.get(str);
                if (list != null) {
                    for (a aVar : list) {
                        if (super.a(jsonElement, cls, aVar.fieldName).equals(aVar.label)) {
                            return aVar.nl;
                        }
                    }
                }
            }
            TypeAdapter<?> a2 = super.a(str, map, jsonElement, cls);
            if (a2 != null) {
                return a2;
            }
        } catch (Exception e2) {
            ai.e("FRESHCHAT", e2.toString());
        }
        return super.a("RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL", map, jsonElement, cls);
    }

    public String a(JsonElement jsonElement, Class<?> cls, String str) {
        String a2 = super.a(jsonElement, cls, str);
        if (a(a2, jsonElement)) {
            return a2;
        }
        ai.w("FRESHCHAT_WARNING", "cannot deserialize " + cls + " subtype named " + a2 + "; did you forget to register a subtype?");
        jsonElement.getAsJsonObject().addProperty((String) "rawJsonOfUnsupportedType", jsonElement.getAsJsonObject().toString());
        return "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL";
    }

    public a<T> b(Class<? extends T> cls) {
        return b(cls, "RuntimeTypeAdapterFactory.UNKNOWN_TYPE_LABEL");
    }

    public String c(Class<?> cls) {
        a aVar = this.nj.get(cls);
        return aVar != null ? aVar.nk : super.c(cls);
    }

    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        for (Entry<String, List<a>> value : this.ni.entrySet()) {
            for (a aVar : (List) value.getValue()) {
                aVar.setDelegate(gson.getDelegateAdapter(this, TypeToken.get(aVar.clz)));
            }
        }
        return super.create(gson, typeToken);
    }

    public C0025b w(String str, String str2) {
        return new C0025b<>(str, str2);
    }
}
