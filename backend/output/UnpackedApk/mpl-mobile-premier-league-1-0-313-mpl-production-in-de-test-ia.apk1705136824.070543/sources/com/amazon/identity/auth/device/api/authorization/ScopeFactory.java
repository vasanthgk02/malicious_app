package com.amazon.identity.auth.device.api.authorization;

import org.json.JSONObject;

public final class ScopeFactory {

    public static final class a implements Scope {

        /* renamed from: a  reason: collision with root package name */
        public final String f3285a;

        /* renamed from: a  reason: collision with other field name */
        public final JSONObject f109a;

        public a(String str) {
            this(str, null);
        }

        public a(String str, JSONObject jSONObject) {
            if (str != null) {
                this.f3285a = str;
                this.f109a = jSONObject;
                return;
            }
            throw new IllegalArgumentException("Scope must have a name");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f3285a;
            if (str == null) {
                if (aVar.f3285a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f3285a)) {
                return false;
            }
            JSONObject jSONObject = this.f109a;
            JSONObject jSONObject2 = aVar.f109a;
            if (jSONObject == null) {
                if (jSONObject2 != null) {
                    return false;
                }
            } else if (!jSONObject.equals(jSONObject2)) {
                return false;
            }
            return true;
        }

        public String getName() {
            return this.f3285a;
        }

        public JSONObject getScopeData() {
            return this.f109a;
        }

        public int hashCode() {
            String str = this.f3285a;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            JSONObject jSONObject = this.f109a;
            if (jSONObject != null) {
                i = jSONObject.hashCode();
            }
            return hashCode + i;
        }
    }

    public static Scope scopeNamed(String str) {
        return new a(str);
    }

    public static Scope scopeNamed(String str, JSONObject jSONObject) {
        return new a(str, jSONObject);
    }
}
