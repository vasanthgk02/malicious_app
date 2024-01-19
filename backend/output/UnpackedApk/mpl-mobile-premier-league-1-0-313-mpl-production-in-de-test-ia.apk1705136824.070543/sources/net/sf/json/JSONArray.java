package net.sf.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import net.sf.ezmorph.object.IdentityObjectMorpher;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONTokener;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;

public final class JSONArray extends AbstractJSON implements JSON, List, Comparable {
    public List elements = new ArrayList();

    public class JSONArrayListIterator implements ListIterator {
        public int currentIndex = 0;
        public int lastIndex = -1;

        public JSONArrayListIterator() {
        }

        public void add(Object obj) {
            try {
                JSONArray jSONArray = JSONArray.this;
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                jSONArray.add(i, obj);
                this.lastIndex = -1;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            return this.currentIndex != JSONArray.this.size();
        }

        public boolean hasPrevious() {
            return this.currentIndex != 0;
        }

        public Object next() {
            try {
                Object obj = JSONArray.this.get(this.currentIndex);
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                this.lastIndex = i;
                return obj;
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException();
            }
        }

        public int nextIndex() {
            return this.currentIndex;
        }

        public Object previous() {
            try {
                int i = this.currentIndex - 1;
                Object obj = JSONArray.this.get(i);
                this.currentIndex = i;
                this.lastIndex = i;
                return obj;
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException();
            }
        }

        public int previousIndex() {
            return this.currentIndex - 1;
        }

        public void remove() {
            int i = this.lastIndex;
            if (i != -1) {
                try {
                    JSONArray.this.remove(i);
                    if (this.lastIndex < this.currentIndex) {
                        this.currentIndex--;
                    }
                    this.lastIndex = -1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }

        public void set(Object obj) {
            int i = this.lastIndex;
            if (i != -1) {
                try {
                    JSONArray.this.set(i, obj);
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }

        public JSONArrayListIterator(int i) {
            this.currentIndex = i;
        }
    }

    public static JSONArray _fromJSONTokener(JSONTokener jSONTokener, JsonConfig jsonConfig) {
        int i;
        JSONArray jSONArray = new JSONArray();
        try {
            if (jSONTokener.nextClean() != '[') {
                throw jSONTokener.syntaxError("A JSONArray text must start with '['");
            } else if (jsonConfig == null) {
                throw null;
            } else if (jSONTokener.nextClean() == ']') {
                return jSONArray;
            } else {
                jSONTokener.back();
                int i2 = 0;
                while (true) {
                    if (jSONTokener.nextClean() == ',') {
                        jSONTokener.back();
                        jSONArray.elements.add(JSONNull.instance);
                        i = i2 + 1;
                        jSONArray.get(i2);
                    } else {
                        jSONTokener.back();
                        Object nextValue = jSONTokener.nextValue(jsonConfig);
                        if (!JSONUtils.isFunctionHeader(nextValue)) {
                            if (!(nextValue instanceof String) || !JSONUtils.mayBeJSON((String) nextValue)) {
                                jSONArray.addValue(nextValue, jsonConfig);
                            } else {
                                jSONArray.addValue("\"" + nextValue + "\"", jsonConfig);
                            }
                            i = i2 + 1;
                            jSONArray.get(i2);
                        } else {
                            String functionParams = JSONUtils.getFunctionParams((String) nextValue);
                            StringBuffer stringBuffer = new StringBuffer();
                            int i3 = 0;
                            while (true) {
                                char next = jSONTokener.next();
                                if (next != 0) {
                                    if (next == '{') {
                                        i3++;
                                    }
                                    if (next == '}') {
                                        i3--;
                                    }
                                    stringBuffer.append(next);
                                    if (i3 == 0) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (i3 == 0) {
                                String stringBuffer2 = stringBuffer.toString();
                                jSONArray.addValue(new JSONFunction(functionParams != null ? StringUtils.split(functionParams, (String) ",") : null, stringBuffer2.substring(1, stringBuffer2.length() - 1).trim()), jsonConfig);
                                i = i2 + 1;
                                jSONArray.get(i2);
                            } else {
                                throw jSONTokener.syntaxError("Unbalanced '{' or '}' on prop: " + nextValue);
                            }
                        }
                    }
                    i2 = i;
                    char nextClean = jSONTokener.nextClean();
                    if (nextClean == ',' || nextClean == ';') {
                        if (jSONTokener.nextClean() == ']') {
                            return jSONArray;
                        }
                        jSONTokener.back();
                    } else if (nextClean == ']') {
                        return jSONArray;
                    } else {
                        throw jSONTokener.syntaxError("Expected a ',' or ']'");
                    }
                }
            }
        } catch (JSONException e2) {
            if (jsonConfig != null) {
                throw e2;
            }
            throw null;
        }
    }

    public static JSONArray fromObject(Object obj) {
        return fromObject(obj, new JsonConfig());
    }

    public void add(int i, Object obj) {
        this.elements.add(i, processValue(obj, new JsonConfig()));
    }

    public boolean addAll(Collection<Object> collection) {
        JsonConfig jsonConfig = new JsonConfig();
        if (collection == null || collection.size() == 0) {
            return false;
        }
        for (Object addValue : collection) {
            addValue(addValue, jsonConfig);
        }
        return true;
    }

    public final JSONArray addValue(Object obj, JsonConfig jsonConfig) {
        this.elements.add(processValue(obj, jsonConfig));
        return this;
    }

    public void clear() {
        this.elements.clear();
    }

    public int compareTo(Object obj) {
        if (obj != null && (obj instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) obj;
            int size = size();
            int size2 = jSONArray.size();
            if (size < size2) {
                return -1;
            }
            if (size > size2) {
                return 1;
            }
            if (equals(jSONArray)) {
                return 0;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return this.elements.contains(processValue(obj, new JsonConfig()));
    }

    public boolean containsAll(Collection collection) {
        return this.elements.containsAll(fromObject(collection, new JsonConfig()));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JSONArray)) {
            return false;
        }
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.size() != size()) {
            return false;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            Object obj2 = get(i);
            Object obj3 = jSONArray.get(i);
            if (JSONNull.instance.equals(obj2)) {
                if (!JSONNull.instance.equals(obj3)) {
                    return false;
                }
            } else if (JSONNull.instance.equals(obj3)) {
                return false;
            } else {
                boolean z = obj2 instanceof JSONArray;
                if (!z || !(obj3 instanceof JSONArray)) {
                    boolean z2 = obj2 instanceof String;
                    if (!z2 || !(obj3 instanceof JSONFunction)) {
                        boolean z3 = obj2 instanceof JSONFunction;
                        if (!z3 || !(obj3 instanceof String)) {
                            if (!(obj2 instanceof JSONObject) || !(obj3 instanceof JSONObject)) {
                                if (!z || !(obj3 instanceof JSONArray)) {
                                    if (!z3 || !(obj3 instanceof JSONFunction)) {
                                        if (z2) {
                                            if (!obj2.equals(String.valueOf(obj3))) {
                                                return false;
                                            }
                                        } else if (!(obj3 instanceof String)) {
                                            IdentityObjectMorpher morpherFor = JSONUtils.morpherRegistry.getMorpherFor(obj2.getClass());
                                            IdentityObjectMorpher morpherFor2 = JSONUtils.morpherRegistry.getMorpherFor(obj3.getClass());
                                            if (morpherFor == null || morpherFor == IdentityObjectMorpher.getInstance()) {
                                                if (morpherFor2 == null || morpherFor2 == IdentityObjectMorpher.getInstance()) {
                                                    if (!obj2.equals(obj3)) {
                                                        return false;
                                                    }
                                                } else if (!JSONUtils.morpherRegistry.morph(obj2.getClass(), obj2).equals(obj3)) {
                                                    return false;
                                                }
                                            } else if (!obj2.equals(JSONUtils.morpherRegistry.morph(obj2.getClass(), obj3))) {
                                                return false;
                                            }
                                        } else if (!obj3.equals(String.valueOf(obj2))) {
                                            return false;
                                        }
                                    } else if (!obj2.equals(obj3)) {
                                        return false;
                                    }
                                } else if (!obj2.equals(obj3)) {
                                    return false;
                                }
                            } else if (!obj2.equals(obj3)) {
                                return false;
                            }
                        } else if (!obj3.equals(String.valueOf(obj2))) {
                            return false;
                        }
                    } else if (!obj2.equals(String.valueOf(obj3))) {
                        return false;
                    }
                } else {
                    if (!((JSONArray) obj3).equals((JSONArray) obj2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Object get(int i) {
        return this.elements.get(i);
    }

    public int hashCode() {
        int i = 29;
        for (Object hashCode : this.elements) {
            i += JSONUtils.hashCode(hashCode);
        }
        return i;
    }

    public int indexOf(Object obj) {
        return this.elements.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Iterator iterator() {
        return new JSONArrayListIterator();
    }

    public int lastIndexOf(Object obj) {
        return this.elements.lastIndexOf(obj);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public final Object processValue(Object obj, JsonConfig jsonConfig) {
        if (obj != null) {
            JsonValueProcessor findJsonValueProcessor = jsonConfig.findJsonValueProcessor(obj.getClass());
            if (findJsonValueProcessor != null) {
                obj = findJsonValueProcessor.processArrayValue(obj, jsonConfig);
                if (!TypeUtilsKt.isValidJsonValue(obj)) {
                    throw new JSONException(GeneratedOutlineSupport.outline48("Value is not a valid JSON value. ", obj));
                }
            }
        }
        if (obj instanceof JSONTokener) {
            return _fromJSONTokener((JSONTokener) obj, jsonConfig);
        }
        if (obj != null && Enum.class.isAssignableFrom(obj.getClass())) {
            return ((Enum) obj).name();
        }
        if (!(obj instanceof Annotation) && (obj == null || !obj.getClass().isAnnotation())) {
            return super._processValue(obj, jsonConfig);
        }
        throw new JSONException((String) "Unsupported type");
    }

    public Object remove(int i) {
        return this.elements.remove(i);
    }

    public boolean removeAll(Collection collection) {
        return this.elements.removeAll(fromObject(collection, new JsonConfig()));
    }

    public boolean retainAll(Collection collection) {
        return this.elements.retainAll(fromObject(collection, new JsonConfig()));
    }

    public Object set(int i, Object obj) {
        JsonConfig jsonConfig = new JsonConfig();
        Object obj2 = this.elements.get(i);
        JSONUtils.testValidity(obj);
        if (i >= 0) {
            if (i < size()) {
                this.elements.set(i, processValue(obj, jsonConfig));
            } else {
                while (i != size()) {
                    this.elements.add(JSONNull.instance);
                }
                addValue(obj, jsonConfig);
            }
            return obj2;
        }
        throw new JSONException(GeneratedOutlineSupport.outline42("JSONArray[", i, "] not found."));
    }

    public int size() {
        return this.elements.size();
    }

    public List subList(int i, int i2) {
        return this.elements.subList(i, i2);
    }

    public Object[] toArray() {
        return this.elements.toArray();
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            int size = size();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(JSONUtils.valueToString(this.elements.get(i)));
            }
            sb.append(stringBuffer.toString());
            sb.append(']');
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray fromObject(Object obj, JsonConfig jsonConfig) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        JSONArray jSONArray7;
        JSONArray jSONArray8;
        JSONArray jSONArray9;
        JSONArray jSONArray10;
        JSONArray jSONArray11;
        JSONArray jSONArray12;
        if (obj instanceof JSONString) {
            return _fromJSONTokener(new JSONTokener(((JSONString) obj).toJSONString()), jsonConfig);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray13 = (JSONArray) obj;
            if (!AbstractJSON.addInstance(jSONArray13)) {
                try {
                    jSONArray12 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(jSONArray13);
                } catch (JSONException e2) {
                    AbstractJSON.removeInstance(jSONArray13);
                    if (jsonConfig != null) {
                        throw e2;
                    }
                    throw null;
                } catch (RuntimeException e3) {
                    AbstractJSON.removeInstance(jSONArray13);
                    JSONException jSONException = new JSONException((Throwable) e3);
                    if (jsonConfig != null) {
                        throw jSONException;
                    }
                    throw null;
                }
            } else if (jsonConfig != null) {
                JSONArray jSONArray14 = new JSONArray();
                if (jSONArray13 != null) {
                    JSONArrayListIterator jSONArrayListIterator = new JSONArrayListIterator();
                    while (jSONArrayListIterator.hasNext()) {
                        jSONArray14.addValue(jSONArrayListIterator.next(), jsonConfig);
                    }
                    AbstractJSON.removeInstance(jSONArray13);
                    jSONArray12 = jSONArray14;
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
            return jSONArray12;
        }
        int i = 0;
        if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            if (!AbstractJSON.addInstance(collection)) {
                try {
                    jSONArray11 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(collection);
                } catch (JSONException e4) {
                    AbstractJSON.removeInstance(collection);
                    if (jsonConfig != null) {
                        throw e4;
                    }
                    throw null;
                } catch (RuntimeException e5) {
                    AbstractJSON.removeInstance(collection);
                    JSONException jSONException2 = new JSONException((Throwable) e5);
                    if (jsonConfig != null) {
                        throw jSONException2;
                    }
                    throw null;
                }
            } else if (jsonConfig != null) {
                JSONArray jSONArray15 = new JSONArray();
                try {
                    for (Object addValue : collection) {
                        jSONArray15.addValue(addValue, jsonConfig);
                        int i2 = i + 1;
                        jSONArray15.get(i);
                        i = i2;
                    }
                    AbstractJSON.removeInstance(collection);
                    jSONArray11 = jSONArray15;
                } catch (JSONException e6) {
                    AbstractJSON.removeInstance(collection);
                    throw e6;
                } catch (RuntimeException e7) {
                    AbstractJSON.removeInstance(collection);
                    throw new JSONException((Throwable) e7);
                }
            } else {
                throw null;
            }
            return jSONArray11;
        } else if (obj instanceof JSONTokener) {
            return _fromJSONTokener((JSONTokener) obj, jsonConfig);
        } else {
            if (obj instanceof String) {
                return _fromJSONTokener(new JSONTokener((String) obj), jsonConfig);
            }
            if (obj != null && obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (!componentType.isPrimitive()) {
                    Object[] objArr = (Object[]) obj;
                    if (!AbstractJSON.addInstance(objArr)) {
                        try {
                            jSONArray10 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(objArr);
                        } catch (JSONException e8) {
                            AbstractJSON.removeInstance(objArr);
                            if (jsonConfig != null) {
                                throw e8;
                            }
                            throw null;
                        } catch (RuntimeException e9) {
                            AbstractJSON.removeInstance(objArr);
                            JSONException jSONException3 = new JSONException((Throwable) e9);
                            if (jsonConfig != null) {
                                throw jSONException3;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray16 = new JSONArray();
                        while (i < objArr.length) {
                            try {
                                jSONArray16.addValue(objArr[i], jsonConfig);
                                jSONArray16.get(i);
                                i++;
                            } catch (JSONException e10) {
                                AbstractJSON.removeInstance(objArr);
                                throw e10;
                            } catch (RuntimeException e11) {
                                AbstractJSON.removeInstance(objArr);
                                throw new JSONException((Throwable) e11);
                            }
                        }
                        AbstractJSON.removeInstance(objArr);
                        jSONArray10 = jSONArray16;
                    } else {
                        throw null;
                    }
                    return jSONArray10;
                } else if (componentType == Boolean.TYPE) {
                    boolean[] zArr = (boolean[]) obj;
                    if (!AbstractJSON.addInstance(zArr)) {
                        try {
                            jSONArray9 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(zArr);
                        } catch (JSONException e12) {
                            AbstractJSON.removeInstance(zArr);
                            if (jsonConfig != null) {
                                throw e12;
                            }
                            throw null;
                        } catch (RuntimeException e13) {
                            AbstractJSON.removeInstance(zArr);
                            JSONException jSONException4 = new JSONException((Throwable) e13);
                            if (jsonConfig != null) {
                                throw jSONException4;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray17 = new JSONArray();
                        while (i < zArr.length) {
                            jSONArray17.addValue(zArr[i] ? Boolean.TRUE : Boolean.FALSE, jsonConfig);
                            i++;
                        }
                        AbstractJSON.removeInstance(zArr);
                        jSONArray9 = jSONArray17;
                    } else {
                        throw null;
                    }
                    return jSONArray9;
                } else if (componentType == Byte.TYPE) {
                    byte[] bArr = (byte[]) obj;
                    if (!AbstractJSON.addInstance(bArr)) {
                        try {
                            jSONArray8 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(bArr);
                        } catch (JSONException e14) {
                            AbstractJSON.removeInstance(bArr);
                            if (jsonConfig != null) {
                                throw e14;
                            }
                            throw null;
                        } catch (RuntimeException e15) {
                            AbstractJSON.removeInstance(bArr);
                            JSONException jSONException5 = new JSONException((Throwable) e15);
                            if (jsonConfig != null) {
                                throw jSONException5;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray18 = new JSONArray();
                        while (i < bArr.length) {
                            jSONArray18.addValue(JSONUtils.transformNumber(new Byte(bArr[i])), jsonConfig);
                            i++;
                        }
                        AbstractJSON.removeInstance(bArr);
                        jSONArray8 = jSONArray18;
                    } else {
                        throw null;
                    }
                    return jSONArray8;
                } else if (componentType == Short.TYPE) {
                    short[] sArr = (short[]) obj;
                    if (!AbstractJSON.addInstance(sArr)) {
                        try {
                            jSONArray7 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(sArr);
                        } catch (JSONException e16) {
                            AbstractJSON.removeInstance(sArr);
                            if (jsonConfig != null) {
                                throw e16;
                            }
                            throw null;
                        } catch (RuntimeException e17) {
                            AbstractJSON.removeInstance(sArr);
                            JSONException jSONException6 = new JSONException((Throwable) e17);
                            if (jsonConfig != null) {
                                throw jSONException6;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray19 = new JSONArray();
                        while (i < sArr.length) {
                            jSONArray19.addValue(JSONUtils.transformNumber(new Short(sArr[i])), jsonConfig);
                            i++;
                        }
                        AbstractJSON.removeInstance(sArr);
                        jSONArray7 = jSONArray19;
                    } else {
                        throw null;
                    }
                    return jSONArray7;
                } else if (componentType == Integer.TYPE) {
                    int[] iArr = (int[]) obj;
                    if (!AbstractJSON.addInstance(iArr)) {
                        try {
                            jSONArray6 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(iArr);
                        } catch (JSONException e18) {
                            AbstractJSON.removeInstance(iArr);
                            if (jsonConfig != null) {
                                throw e18;
                            }
                            throw null;
                        } catch (RuntimeException e19) {
                            AbstractJSON.removeInstance(iArr);
                            JSONException jSONException7 = new JSONException((Throwable) e19);
                            if (jsonConfig != null) {
                                throw jSONException7;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray20 = new JSONArray();
                        while (i < iArr.length) {
                            jSONArray20.elements.add(jSONArray20.processValue(new Integer(iArr[i]), jsonConfig));
                            i++;
                        }
                        AbstractJSON.removeInstance(iArr);
                        jSONArray6 = jSONArray20;
                    } else {
                        throw null;
                    }
                    return jSONArray6;
                } else if (componentType == Long.TYPE) {
                    long[] jArr = (long[]) obj;
                    if (!AbstractJSON.addInstance(jArr)) {
                        try {
                            jSONArray5 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(jArr);
                        } catch (JSONException e20) {
                            AbstractJSON.removeInstance(jArr);
                            if (jsonConfig != null) {
                                throw e20;
                            }
                            throw null;
                        } catch (RuntimeException e21) {
                            AbstractJSON.removeInstance(jArr);
                            JSONException jSONException8 = new JSONException((Throwable) e21);
                            if (jsonConfig != null) {
                                throw jSONException8;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray21 = new JSONArray();
                        while (i < jArr.length) {
                            jSONArray21.addValue(JSONUtils.transformNumber(new Long(jArr[i])), jsonConfig);
                            i++;
                        }
                        AbstractJSON.removeInstance(jArr);
                        jSONArray5 = jSONArray21;
                    } else {
                        throw null;
                    }
                    return jSONArray5;
                } else if (componentType == Float.TYPE) {
                    float[] fArr = (float[]) obj;
                    if (!AbstractJSON.addInstance(fArr)) {
                        try {
                            jSONArray4 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(fArr);
                        } catch (JSONException e22) {
                            AbstractJSON.removeInstance(fArr);
                            if (jsonConfig != null) {
                                throw e22;
                            }
                            throw null;
                        } catch (RuntimeException e23) {
                            AbstractJSON.removeInstance(fArr);
                            JSONException jSONException9 = new JSONException((Throwable) e23);
                            if (jsonConfig != null) {
                                throw jSONException9;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray22 = new JSONArray();
                        while (i < fArr.length) {
                            try {
                                Float f2 = new Float(fArr[i]);
                                JSONUtils.testValidity(f2);
                                jSONArray22.elements.add(jSONArray22.processValue(f2, jsonConfig));
                                i++;
                            } catch (JSONException e24) {
                                AbstractJSON.removeInstance(fArr);
                                throw e24;
                            }
                        }
                        AbstractJSON.removeInstance(fArr);
                        jSONArray4 = jSONArray22;
                    } else {
                        throw null;
                    }
                    return jSONArray4;
                } else if (componentType == Double.TYPE) {
                    double[] dArr = (double[]) obj;
                    if (!AbstractJSON.addInstance(dArr)) {
                        try {
                            jSONArray3 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(dArr);
                        } catch (JSONException e25) {
                            AbstractJSON.removeInstance(dArr);
                            if (jsonConfig != null) {
                                throw e25;
                            }
                            throw null;
                        } catch (RuntimeException e26) {
                            AbstractJSON.removeInstance(dArr);
                            JSONException jSONException10 = new JSONException((Throwable) e26);
                            if (jsonConfig != null) {
                                throw jSONException10;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray23 = new JSONArray();
                        while (i < dArr.length) {
                            try {
                                Double d2 = new Double(dArr[i]);
                                JSONUtils.testValidity(d2);
                                jSONArray23.elements.add(jSONArray23.processValue(d2, jsonConfig));
                                i++;
                            } catch (JSONException e27) {
                                AbstractJSON.removeInstance(dArr);
                                throw e27;
                            }
                        }
                        AbstractJSON.removeInstance(dArr);
                        jSONArray3 = jSONArray23;
                    } else {
                        throw null;
                    }
                    return jSONArray3;
                } else if (componentType == Character.TYPE) {
                    char[] cArr = (char[]) obj;
                    if (!AbstractJSON.addInstance(cArr)) {
                        try {
                            jSONArray2 = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(cArr);
                        } catch (JSONException e28) {
                            AbstractJSON.removeInstance(cArr);
                            if (jsonConfig != null) {
                                throw e28;
                            }
                            throw null;
                        } catch (RuntimeException e29) {
                            AbstractJSON.removeInstance(cArr);
                            JSONException jSONException11 = new JSONException((Throwable) e29);
                            if (jsonConfig != null) {
                                throw jSONException11;
                            }
                            throw null;
                        }
                    } else if (jsonConfig != null) {
                        JSONArray jSONArray24 = new JSONArray();
                        while (i < cArr.length) {
                            jSONArray24.elements.add(jSONArray24.processValue(new Character(cArr[i]), jsonConfig));
                            i++;
                        }
                        AbstractJSON.removeInstance(cArr);
                        jSONArray2 = jSONArray24;
                    } else {
                        throw null;
                    }
                    return jSONArray2;
                } else {
                    throw new JSONException((String) "Unsupported type");
                }
            } else if (JSONUtils.isBoolean(obj) || JSONUtils.isFunction(obj) || JSONUtils.isNumber(obj) || JSONUtils.isNull(obj) || JSONUtils.isString(obj) || (obj instanceof JSON)) {
                if (jsonConfig != null) {
                    JSONArray jSONArray25 = new JSONArray();
                    jSONArray25.addValue(obj, jsonConfig);
                    jSONArray25.get(0);
                    return jSONArray25;
                }
                throw null;
            } else if (obj instanceof Enum) {
                Enum enumR = (Enum) obj;
                if (!AbstractJSON.addInstance(enumR)) {
                    try {
                        jSONArray = jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsArray(enumR);
                    } catch (JSONException e30) {
                        AbstractJSON.removeInstance(enumR);
                        if (jsonConfig != null) {
                            throw e30;
                        }
                        throw null;
                    } catch (RuntimeException e31) {
                        AbstractJSON.removeInstance(enumR);
                        JSONException jSONException12 = new JSONException((Throwable) e31);
                        if (jsonConfig != null) {
                            throw jSONException12;
                        }
                        throw null;
                    }
                } else if (jsonConfig != null) {
                    JSONArray jSONArray26 = new JSONArray();
                    if (enumR != null) {
                        jSONArray26.elements.add(jSONArray26.processValue(enumR, jsonConfig));
                        jSONArray26.get(0);
                        AbstractJSON.removeInstance(enumR);
                        jSONArray = jSONArray26;
                    } else {
                        JSONException jSONException13 = new JSONException((String) "enum value is null");
                        AbstractJSON.removeInstance(enumR);
                        throw jSONException13;
                    }
                } else {
                    throw null;
                }
                return jSONArray;
            } else if ((obj instanceof Annotation) || (obj != null && obj.getClass().isAnnotation())) {
                throw new JSONException((String) "Unsupported type");
            } else {
                if (!((!JSONUtils.isNumber(obj) && !JSONUtils.isString(obj) && !JSONUtils.isBoolean(obj) && !JSONUtils.isArray(obj) && !JSONUtils.isFunction(obj)) || JSONUtils.isNull(obj))) {
                    throw new JSONException((String) "Unsupported type");
                } else if (jsonConfig != null) {
                    JSONArray jSONArray27 = new JSONArray();
                    jSONArray27.elements.add(JSONObject.fromObject(obj, jsonConfig));
                    jSONArray27.get(0);
                    return jSONArray27;
                } else {
                    throw null;
                }
            }
        }
    }

    public ListIterator listIterator(int i) {
        if (i >= 0 && i <= size()) {
            return new JSONArrayListIterator(i);
        }
        throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Index: ", i));
    }

    public boolean remove(Object obj) {
        return this.elements.remove(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.elements.toArray(objArr);
    }

    public boolean add(Object obj) {
        addValue(obj, new JsonConfig());
        return true;
    }

    public boolean addAll(int i, Collection<Object> collection) {
        JsonConfig jsonConfig = new JsonConfig();
        int i2 = 0;
        if (collection == null || collection.size() == 0) {
            return false;
        }
        for (Object processValue : collection) {
            this.elements.add(i2 + i, processValue(processValue, jsonConfig));
            i2++;
        }
        return true;
    }
}
