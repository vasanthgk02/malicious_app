package net.minidev.json.reader;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONStreamAware;
import net.minidev.json.JSONStreamAwareEx;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;
import org.apache.commons.lang.StringEscapeUtils;

public class JsonWriter {
    public static final JsonWriterI<Enum<?>> EnumWriter = new JsonWriterI<Enum<?>>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            jSONStyle.writeString(appendable, ((Enum) obj).name());
        }
    };
    public static final JsonWriterI<Iterable<? extends Object>> JSONIterableWriter = new JsonWriterI<Iterable<? extends Object>>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
    public static final JsonWriterI<JSONAwareEx> JSONJSONAwareExWriter = new JsonWriterI<JSONAwareEx>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(((JSONAwareEx) obj).toJSONString(jSONStyle));
        }
    };
    public static final JsonWriterI<JSONAware> JSONJSONAwareWriter = new JsonWriterI<JSONAware>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(((JSONAware) obj).toJSONString());
        }
    };
    public static final JsonWriterI<Map<String, ? extends Object>> JSONMapWriter = new JsonWriterI<Map<String, ? extends Object>>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
                        JsonWriter.writeJSONKV(entry.getKey().toString(), value, appendable, jSONStyle);
                    }
                }
                appendable.append('}');
                return;
            }
            throw null;
        }
    };
    public static final JsonWriterI<JSONStreamAwareEx> JSONStreamAwareExWriter = new JsonWriterI<JSONStreamAwareEx>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            ((JSONStreamAwareEx) obj).writeJSONString(appendable, jSONStyle);
        }
    };
    public static final JsonWriterI<JSONStreamAwareEx> JSONStreamAwareWriter = new JsonWriterI<JSONStreamAwareEx>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            ((JSONStreamAwareEx) obj).writeJSONString(appendable);
        }
    };
    public static final JsonWriterI<Object> arrayWriter = new ArrayWriter();
    public static final JsonWriterI<Object> beansWriterASM = new BeansWriterASM();
    public static final JsonWriterI<Object> toStringWriter = new JsonWriterI<Object>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(obj.toString());
        }
    };
    public ConcurrentHashMap<Class<?>, JsonWriterI<?>> data = new ConcurrentHashMap<>();
    public LinkedList<WriterByInterface> writerInterfaces = new LinkedList<>();

    public static class WriterByInterface {
        public Class<?> _interface;
        public JsonWriterI<?> _writer;

        public WriterByInterface(Class<?> cls, JsonWriterI<?> jsonWriterI) {
            this._interface = cls;
            this._writer = jsonWriterI;
        }
    }

    public JsonWriter() {
        registerWriter(new JsonWriterI<String>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.writeString(appendable, (String) obj);
            }
        }, String.class);
        registerWriter(new JsonWriterI<Double>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                Double d2 = (Double) obj;
                if (d2.isInfinite()) {
                    appendable.append("null");
                } else {
                    appendable.append(d2.toString());
                }
            }
        }, Double.class);
        registerWriter(new JsonWriterI<Date>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                appendable.append(StringEscapeUtils.CSV_QUOTE);
                JSONValue.escape(((Date) obj).toString(), appendable, jSONStyle);
                appendable.append(StringEscapeUtils.CSV_QUOTE);
            }
        }, Date.class);
        registerWriter(new JsonWriterI<Float>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                Float f2 = (Float) obj;
                if (f2.isInfinite()) {
                    appendable.append("null");
                } else {
                    appendable.append(f2.toString());
                }
            }
        }, Float.class);
        registerWriter(toStringWriter, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        registerWriter(toStringWriter, Boolean.class);
        registerWriter(new JsonWriterI<int[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        registerWriter(new JsonWriterI<short[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        registerWriter(new JsonWriterI<long[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        registerWriter(new JsonWriterI<float[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        registerWriter(new JsonWriterI<double[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        registerWriter(new JsonWriterI<boolean[]>(this) {
            public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
        this.writerInterfaces.addLast(new WriterByInterface(JSONStreamAwareEx.class, JSONStreamAwareExWriter));
        this.writerInterfaces.addLast(new WriterByInterface(JSONStreamAware.class, JSONStreamAwareWriter));
        this.writerInterfaces.addLast(new WriterByInterface(JSONAwareEx.class, JSONJSONAwareExWriter));
        this.writerInterfaces.addLast(new WriterByInterface(JSONAware.class, JSONJSONAwareWriter));
        this.writerInterfaces.addLast(new WriterByInterface(Map.class, JSONMapWriter));
        this.writerInterfaces.addLast(new WriterByInterface(Iterable.class, JSONIterableWriter));
        this.writerInterfaces.addLast(new WriterByInterface(Enum.class, EnumWriter));
        this.writerInterfaces.addLast(new WriterByInterface(Number.class, toStringWriter));
    }

    public static void writeJSONKV(String str, Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (str == null) {
            appendable.append("null");
        } else if (!jSONStyle.mpKey.mustBeProtect(str)) {
            appendable.append(str);
        } else {
            appendable.append(StringEscapeUtils.CSV_QUOTE);
            JSONValue.escape(str, appendable, jSONStyle);
            appendable.append(StringEscapeUtils.CSV_QUOTE);
        }
        appendable.append(':');
        if (obj instanceof String) {
            jSONStyle.writeString(appendable, (String) obj);
        } else {
            JSONValue.writeJSONString(obj, appendable, jSONStyle);
        }
    }

    public <T> void registerWriter(JsonWriterI<T> jsonWriterI, Class<?>... clsArr) {
        for (Class<?> put : clsArr) {
            this.data.put(put, jsonWriterI);
        }
    }
}
