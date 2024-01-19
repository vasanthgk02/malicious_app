package com.cardinalcommerce.dependencies.internal.minidev.json.c;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAwareEx;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONStreamAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONStreamAwareEx;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringEscapeUtils;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final f<JSONStreamAwareEx> f1928a = new f<JSONStreamAwareEx>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            ((JSONStreamAwareEx) obj).writeJSONString(appendable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final f<JSONStreamAwareEx> f1929b = new f<JSONStreamAwareEx>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            ((JSONStreamAwareEx) obj).writeJSONString(appendable, jSONStyle);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final f<JSONAwareEx> f1930c = new f<JSONAwareEx>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            appendable.append(((JSONAwareEx) obj).toJSONString(jSONStyle));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final f<JSONAware> f1931d = new f<JSONAware>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            appendable.append(((JSONAware) obj).toJSONString());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final f<Iterable<? extends Object>> f1932e = new f<Iterable<? extends Object>>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            Iterable iterable = (Iterable) obj;
            if (jSONStyle != null) {
                appendable.append('[');
                boolean z = true;
                for (Object next : iterable) {
                    if (z) {
                        z = false;
                    } else {
                        appendable.append(',');
                    }
                    if (next == null) {
                        appendable.append("null");
                    } else {
                        JSONValue.writeJSONString(next, appendable, jSONStyle);
                    }
                }
                appendable.append(']');
                return;
            }
            throw null;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final f<Enum<?>> f1933f = new f<Enum<?>>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            jSONStyle.writeString(appendable, ((Enum) obj).name());
        }
    };
    public static final f<Map<String, ? extends Object>> g = new f<Map<String, ? extends Object>>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            Map map = (Map) obj;
            if (jSONStyle != null) {
                appendable.append('{');
                boolean z = true;
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null || !jSONStyle._ignore_null) {
                        if (z) {
                            z = false;
                        } else {
                            appendable.append(',');
                        }
                        e.a(entry.getKey().toString(), value, appendable, jSONStyle);
                    }
                }
                appendable.append('}');
                return;
            }
            throw null;
        }
    };
    public static final f<Object> h = new c();
    public static final f<Object> j = new a();
    public static final f<Object> k = new f<Object>() {
        public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
            appendable.append(obj.toString());
        }
    };
    public ConcurrentHashMap<Class<?>, f<?>> l = new ConcurrentHashMap<>();
    public LinkedList<a> m = new LinkedList<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f1934a;

        /* renamed from: b  reason: collision with root package name */
        public f<?> f1935b;

        public a(Class<?> cls, f<?> fVar) {
            this.f1934a = cls;
            this.f1935b = fVar;
        }
    }

    public e() {
        a(new f<String>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                jSONStyle.writeString(appendable, (String) obj);
            }
        }, String.class);
        a(new f<Double>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                Double d2 = (Double) obj;
                appendable.append(d2.isInfinite() ? "null" : d2.toString());
            }
        }, Double.class);
        a(new f<Date>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                appendable.append(StringEscapeUtils.CSV_QUOTE);
                JSONValue.escape(((Date) obj).toString(), appendable, jSONStyle);
                appendable.append(StringEscapeUtils.CSV_QUOTE);
            }
        }, Date.class);
        a(new f<Float>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                Float f2 = (Float) obj;
                appendable.append(f2.isInfinite() ? "null" : f2.toString());
            }
        }, Float.class);
        a(k, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        a(k, Boolean.class);
        a(new f<int[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                int[] iArr = (int[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (int i : iArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Integer.toString(i));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, int[].class);
        a(new f<short[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                short[] sArr = (short[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (short s : sArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Short.toString(s));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, short[].class);
        a(new f<long[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                long[] jArr = (long[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (long j : jArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Long.toString(j));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, long[].class);
        a(new f<float[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                float[] fArr = (float[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (float f2 : fArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Float.toString(f2));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, float[].class);
        a(new f<double[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                double[] dArr = (double[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (double d2 : dArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Double.toString(d2));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, double[].class);
        a(new f<boolean[]>(this) {
            public void a(Object obj, Appendable appendable, JSONStyle jSONStyle) {
                boolean[] zArr = (boolean[]) obj;
                if (jSONStyle != null) {
                    appendable.append('[');
                    boolean z = false;
                    for (boolean z2 : zArr) {
                        if (z) {
                            appendable.append(',');
                        } else {
                            z = true;
                        }
                        appendable.append(Boolean.toString(z2));
                    }
                    appendable.append(']');
                    return;
                }
                throw null;
            }
        }, boolean[].class);
        this.m.addLast(new a(JSONStreamAwareEx.class, f1929b));
        this.m.addLast(new a(JSONStreamAware.class, f1928a));
        this.m.addLast(new a(JSONAwareEx.class, f1930c));
        this.m.addLast(new a(JSONAware.class, f1931d));
        this.m.addLast(new a(Map.class, g));
        this.m.addLast(new a(Iterable.class, f1932e));
        this.m.addLast(new a(Enum.class, f1933f));
        this.m.addLast(new a(Number.class, k));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r1, java.lang.Object r2, java.lang.Appendable r3, com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle r4) {
        /*
            if (r1 != 0) goto L_0x0005
            java.lang.String r1 = "null"
            goto L_0x000d
        L_0x0005:
            com.cardinalcommerce.dependencies.internal.minidev.json.JStylerObj$MustProtect r0 = r4.mpKey
            boolean r0 = r0.mustBeProtect(r1)
            if (r0 != 0) goto L_0x0011
        L_0x000d:
            r3.append(r1)
            goto L_0x001c
        L_0x0011:
            r0 = 34
            r3.append(r0)
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue.escape(r1, r3, r4)
            r3.append(r0)
        L_0x001c:
            r1 = 58
            r3.append(r1)
            boolean r1 = r2 instanceof java.lang.String
            if (r1 == 0) goto L_0x002b
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r3, r2)
            goto L_0x002e
        L_0x002b:
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue.writeJSONString(r2, r3, r4)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.c.e.a(java.lang.String, java.lang.Object, java.lang.Appendable, com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle):void");
    }

    public <T> void a(f<T> fVar, Class<?>... clsArr) {
        for (Class<?> put : clsArr) {
            this.l.put(put, fVar);
        }
    }
}
