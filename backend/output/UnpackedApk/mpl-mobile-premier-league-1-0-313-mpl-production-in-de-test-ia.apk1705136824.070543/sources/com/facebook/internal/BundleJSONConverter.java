package com.facebook.internal;

import android.os.Bundle;
import com.mpl.androidapp.utils.Constant;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "()V", "SETTERS", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "convertToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "bundle", "Setter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BundleJSONConverter.kt */
public final class BundleJSONConverter {
    public static final BundleJSONConverter INSTANCE = null;
    public static final Map<Class<?>, Setter> SETTERS;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BundleJSONConverter.kt */
    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        });
        SETTERS.put(Integer.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                bundle.putInt(str, ((Integer) obj).intValue());
            }
        });
        SETTERS.put(Long.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                bundle.putLong(str, ((Long) obj).longValue());
            }
        });
        SETTERS.put(Double.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }
        });
        SETTERS.put(String.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                bundle.putString(str, (String) obj);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                throw new IllegalArgumentException("Unexpected type from JSON");
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                int length = jSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i2 = i + 1;
                        Object obj2 = jSONArray.get(i);
                        if (obj2 instanceof String) {
                            arrayList.add(obj2);
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        } else {
                            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected type in an array: ", obj2.getClass()));
                        }
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }
        });
    }

    public static final Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        Intrinsics.checkNotNullExpressionValue(obj, HSLCriteriaBuilder.VALUE);
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return bundle;
    }
}
