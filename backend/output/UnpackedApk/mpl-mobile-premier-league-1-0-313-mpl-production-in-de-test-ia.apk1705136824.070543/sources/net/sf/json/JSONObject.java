package net.sf.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import net.sf.ezmorph.object.IdentityObjectMorpher;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONTokener;
import net.sf.json.util.JSONUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class JSONObject extends AbstractJSON implements JSON, Map, Comparable {
    public static final Log log = LogFactory.getLog(JSONObject.class);
    public boolean nullObject;
    public Map properties = new ListOrderedMap();

    public static JSONObject _fromDynaBean(DynaBean dynaBean, JsonConfig jsonConfig) {
        boolean z;
        Object obj;
        if (!AbstractJSON.addInstance(dynaBean)) {
            try {
                return jsonConfig.cycleDetectionStrategy.handleRepeatedReferenceAsObject(dynaBean);
            } catch (JSONException e2) {
                AbstractJSON.removeInstance(dynaBean);
                if (jsonConfig != null) {
                    throw e2;
                }
                throw null;
            } catch (RuntimeException e3) {
                AbstractJSON.removeInstance(dynaBean);
                JSONException jSONException = new JSONException((Throwable) e3);
                if (jsonConfig != null) {
                    throw jSONException;
                }
                throw null;
            }
        } else if (jsonConfig != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                DynaProperty[] dynaProperties = dynaBean.getDynaClass().getDynaProperties();
                Collection mergedExcludes = jsonConfig.getMergedExcludes();
                for (DynaProperty dynaProperty : dynaProperties) {
                    String name = dynaProperty.getName();
                    if (!((HashSet) mergedExcludes).contains(name)) {
                        Class type = dynaProperty.getType();
                        Object obj2 = dynaBean.get(dynaProperty.getName());
                        JsonValueProcessor findJsonValueProcessor = jsonConfig.findJsonValueProcessor(type, name);
                        if (findJsonValueProcessor != null) {
                            Object processObjectValue = findJsonValueProcessor.processObjectValue(name, obj2, jsonConfig);
                            if (TypeUtilsKt.isValidJsonValue(processObjectValue)) {
                                obj = processObjectValue;
                                z = true;
                            } else {
                                throw new JSONException("Value is not a valid JSON value. " + processObjectValue);
                            }
                        } else {
                            obj = obj2;
                            z = false;
                        }
                        setValue(jSONObject, name, obj, type, jsonConfig, z);
                    }
                }
                AbstractJSON.removeInstance(dynaBean);
                return jSONObject;
            } catch (JSONException e4) {
                AbstractJSON.removeInstance(dynaBean);
                throw e4;
            } catch (RuntimeException e5) {
                AbstractJSON.removeInstance(dynaBean);
                throw new JSONException((Throwable) e5);
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0185 A[Catch:{ JSONException -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0184 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e A[SYNTHETIC, Splitter:B:42:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011a A[Catch:{ JSONException -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0138 A[ADDED_TO_REGION, Catch:{ JSONException -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.sf.json.JSONObject _fromJSONTokener(net.sf.json.util.JSONTokener r18, net.sf.json.JsonConfig r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "\""
            r3 = 0
            java.lang.String r4 = "null.*"
            java.lang.String r5 = r0.mySource     // Catch:{ JSONException -> 0x003e }
            int r6 = r0.myIndex     // Catch:{ JSONException -> 0x003e }
            java.lang.String r5 = r5.substring(r6)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r6 = net.sf.json.regexp.RegexpUtils.javaVersion     // Catch:{ JSONException -> 0x003e }
            java.lang.String r7 = "1.3"
            int r6 = r6.indexOf(r7)     // Catch:{ JSONException -> 0x003e }
            r7 = -1
            r8 = 0
            r9 = 1
            if (r6 == r7) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            if (r6 == 0) goto L_0x0029
            net.sf.json.regexp.Perl5RegexpMatcher r6 = new net.sf.json.regexp.Perl5RegexpMatcher     // Catch:{ JSONException -> 0x003e }
            r6.<init>(r4, r8)     // Catch:{ JSONException -> 0x003e }
            goto L_0x002e
        L_0x0029:
            net.sf.json.regexp.JdkRegexpMatcher r6 = new net.sf.json.regexp.JdkRegexpMatcher     // Catch:{ JSONException -> 0x003e }
            r6.<init>(r4, r8)     // Catch:{ JSONException -> 0x003e }
        L_0x002e:
            boolean r4 = r6.matches(r5)     // Catch:{ JSONException -> 0x003e }
            if (r4 == 0) goto L_0x0042
            if (r1 == 0) goto L_0x0041
            net.sf.json.JSONObject r0 = new net.sf.json.JSONObject     // Catch:{ JSONException -> 0x003e }
            r0.<init>()     // Catch:{ JSONException -> 0x003e }
            r0.nullObject = r9     // Catch:{ JSONException -> 0x003e }
            return r0
        L_0x003e:
            r0 = move-exception
            goto L_0x01a1
        L_0x0041:
            throw r3     // Catch:{ JSONException -> 0x003e }
        L_0x0042:
            char r4 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 != r5) goto L_0x019a
            if (r1 == 0) goto L_0x0198
            java.util.Collection r4 = r19.getMergedExcludes()     // Catch:{ JSONException -> 0x003e }
            net.sf.json.JSONObject r6 = new net.sf.json.JSONObject     // Catch:{ JSONException -> 0x003e }
            r6.<init>()     // Catch:{ JSONException -> 0x003e }
        L_0x0055:
            char r7 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            if (r7 == 0) goto L_0x0191
            r10 = 125(0x7d, float:1.75E-43)
            if (r7 == r10) goto L_0x0190
            r18.back()     // Catch:{ JSONException -> 0x003e }
            java.lang.Object r7 = r18.nextValue(r19)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x003e }
            char r11 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            r12 = 61
            if (r11 != r12) goto L_0x007e
            char r11 = r18.next()     // Catch:{ JSONException -> 0x003e }
            r12 = 62
            if (r11 == r12) goto L_0x0082
            r18.back()     // Catch:{ JSONException -> 0x003e }
            goto L_0x0082
        L_0x007e:
            r12 = 58
            if (r11 != r12) goto L_0x0189
        L_0x0082:
            char r11 = r18.peek()     // Catch:{ JSONException -> 0x003e }
            r12 = 34
            if (r11 == r12) goto L_0x0091
            r12 = 39
            if (r11 != r12) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r11 = 0
            goto L_0x0092
        L_0x0091:
            r11 = 1
        L_0x0092:
            java.lang.Object r12 = r18.nextValue(r19)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r13 = "Expected a ',' or '}'"
            r14 = 59
            r15 = 44
            if (r11 != 0) goto L_0x0111
            boolean r16 = net.sf.json.util.JSONUtils.isFunctionHeader(r12)     // Catch:{ JSONException -> 0x003e }
            if (r16 != 0) goto L_0x00a5
            goto L_0x0111
        L_0x00a5:
            r11 = r12
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x003e }
            java.lang.String r11 = net.sf.json.util.JSONUtils.getFunctionParams(r11)     // Catch:{ JSONException -> 0x003e }
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ JSONException -> 0x003e }
            r8.<init>()     // Catch:{ JSONException -> 0x003e }
            r17 = 0
        L_0x00b3:
            char r3 = r18.next()     // Catch:{ JSONException -> 0x003e }
            if (r3 != 0) goto L_0x00ba
            goto L_0x00c7
        L_0x00ba:
            if (r3 != r5) goto L_0x00be
            int r17 = r17 + 1
        L_0x00be:
            if (r3 != r10) goto L_0x00c2
            int r17 = r17 + -1
        L_0x00c2:
            r8.append(r3)     // Catch:{ JSONException -> 0x003e }
            if (r17 != 0) goto L_0x00b3
        L_0x00c7:
            if (r17 != 0) goto L_0x00fb
            java.lang.String r3 = r8.toString()     // Catch:{ JSONException -> 0x003e }
            int r8 = r3.length()     // Catch:{ JSONException -> 0x003e }
            int r8 = r8 - r9
            java.lang.String r3 = r3.substring(r9, r8)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = r3.trim()     // Catch:{ JSONException -> 0x003e }
            net.sf.json.JSONFunction r8 = new net.sf.json.JSONFunction     // Catch:{ JSONException -> 0x003e }
            if (r11 == 0) goto L_0x00e5
            java.lang.String r12 = ","
            java.lang.String[] r11 = org.apache.commons.lang.StringUtils.split(r11, r12)     // Catch:{ JSONException -> 0x003e }
            goto L_0x00e6
        L_0x00e5:
            r11 = 0
        L_0x00e6:
            r8.<init>(r11, r3)     // Catch:{ JSONException -> 0x003e }
            java.util.Map r3 = r6.properties     // Catch:{ JSONException -> 0x003e }
            boolean r3 = r3.containsKey(r7)     // Catch:{ JSONException -> 0x003e }
            if (r3 == 0) goto L_0x00f6
            r6.accumulate(r7, r8, r1)     // Catch:{ JSONException -> 0x003e }
            goto L_0x016e
        L_0x00f6:
            r6.element(r7, r8, r1)     // Catch:{ JSONException -> 0x003e }
            goto L_0x016e
        L_0x00fb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x003e }
            r2.<init>()     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "Unbalanced '{' or '}' on prop: "
            r2.append(r3)     // Catch:{ JSONException -> 0x003e }
            r2.append(r12)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x003e }
            net.sf.json.JSONException r0 = r0.syntaxError(r2)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x0111:
            r3 = r4
            java.util.HashSet r3 = (java.util.HashSet) r3
            boolean r3 = r3.contains(r7)     // Catch:{ JSONException -> 0x003e }
            if (r3 == 0) goto L_0x0138
            char r3 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            if (r3 == r15) goto L_0x012a
            if (r3 == r14) goto L_0x012a
            if (r3 != r10) goto L_0x0125
            return r6
        L_0x0125:
            net.sf.json.JSONException r0 = r0.syntaxError(r13)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x012a:
            char r3 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            if (r3 != r10) goto L_0x0131
            return r6
        L_0x0131:
            r18.back()     // Catch:{ JSONException -> 0x003e }
        L_0x0134:
            r3 = 0
            r8 = 0
            goto L_0x0055
        L_0x0138:
            if (r11 == 0) goto L_0x015f
            boolean r3 = r12 instanceof java.lang.String     // Catch:{ JSONException -> 0x003e }
            if (r3 == 0) goto L_0x015f
            r3 = r12
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x003e }
            boolean r3 = net.sf.json.util.JSONUtils.mayBeJSON(r3)     // Catch:{ JSONException -> 0x003e }
            if (r3 != 0) goto L_0x014d
            boolean r3 = net.sf.json.util.JSONUtils.isFunction(r12)     // Catch:{ JSONException -> 0x003e }
            if (r3 == 0) goto L_0x015f
        L_0x014d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x003e }
            r3.<init>()     // Catch:{ JSONException -> 0x003e }
            r3.append(r2)     // Catch:{ JSONException -> 0x003e }
            r3.append(r12)     // Catch:{ JSONException -> 0x003e }
            r3.append(r2)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r12 = r3.toString()     // Catch:{ JSONException -> 0x003e }
        L_0x015f:
            java.util.Map r3 = r6.properties     // Catch:{ JSONException -> 0x003e }
            boolean r3 = r3.containsKey(r7)     // Catch:{ JSONException -> 0x003e }
            if (r3 == 0) goto L_0x016b
            r6.accumulate(r7, r12, r1)     // Catch:{ JSONException -> 0x003e }
            goto L_0x016e
        L_0x016b:
            r6.element(r7, r12, r1)     // Catch:{ JSONException -> 0x003e }
        L_0x016e:
            char r3 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            if (r3 == r15) goto L_0x017e
            if (r3 == r14) goto L_0x017e
            if (r3 != r10) goto L_0x0179
            return r6
        L_0x0179:
            net.sf.json.JSONException r0 = r0.syntaxError(r13)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x017e:
            char r3 = r18.nextClean()     // Catch:{ JSONException -> 0x003e }
            if (r3 != r10) goto L_0x0185
            return r6
        L_0x0185:
            r18.back()     // Catch:{ JSONException -> 0x003e }
            goto L_0x0134
        L_0x0189:
            java.lang.String r2 = "Expected a ':' after a key"
            net.sf.json.JSONException r0 = r0.syntaxError(r2)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x0190:
            return r6
        L_0x0191:
            java.lang.String r2 = "A JSONObject text must end with '}'"
            net.sf.json.JSONException r0 = r0.syntaxError(r2)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x0198:
            r2 = r3
            throw r2     // Catch:{ JSONException -> 0x003e }
        L_0x019a:
            java.lang.String r2 = "A JSONObject text must begin with '{'"
            net.sf.json.JSONException r0 = r0.syntaxError(r2)     // Catch:{ JSONException -> 0x003e }
            throw r0     // Catch:{ JSONException -> 0x003e }
        L_0x01a1:
            if (r1 == 0) goto L_0x01a4
            throw r0
        L_0x01a4:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.JSONObject._fromJSONTokener(net.sf.json.util.JSONTokener, net.sf.json.JsonConfig):net.sf.json.JSONObject");
    }

    /* JADX INFO: used method not loaded: net.sf.json.JSONException.<init>(java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0159, code lost:
        if (r0.ignorePublicFields != false) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015b, code lost:
        r8 = r11.getFields();
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0161, code lost:
        if (r9 >= r8.length) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0163, code lost:
        r2 = r8[r9];
        r3 = r2.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x016d, code lost:
        if (r13.contains(r3) == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016f, code lost:
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0171, code lost:
        r5 = r2.getType();
        r2 = r2.get(r1);
        r4 = r0.findJsonValueProcessor(r11, r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017d, code lost:
        if (r4 == null) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017f, code lost:
        r2 = r4.processObjectValue(r3, r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0187, code lost:
        if (kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isValidJsonValue(r2) == false) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0189, code lost:
        r4 = r2;
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a0, code lost:
        throw new net.sf.json.JSONException(r6 + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a1, code lost:
        r4 = r2;
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a3, code lost:
        if (r12 == null) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a5, code lost:
        r3 = r12.processPropertyName(r11, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01aa, code lost:
        r10 = r6;
        setValue(r14, r3, r4, r5, r20, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b1, code lost:
        r9 = r9 + 1;
        r6 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.sf.json.JSONObject defaultBeanProcessing(java.lang.Object r19, net.sf.json.JsonConfig r20) {
        /*
            r1 = r19
            r0 = r20
            java.lang.String r8 = " has no read method. SKIPPED"
            java.lang.String r9 = "' of "
            java.lang.String r10 = "Property '"
            java.lang.Class r11 = r19.getClass()
            java.util.Map r2 = r0.jsonPropertyNameProcessorMap
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x003b
            net.sf.json.processors.PropertyNameProcessorMatcher r2 = r0.jsonPropertyNameProcessorMatcher
            java.util.Map r4 = r0.jsonPropertyNameProcessorMap
            java.util.Set r4 = r4.keySet()
            net.sf.json.processors.PropertyNameProcessorMatcher$DefaultPropertyNameProcessorMatcher r2 = (net.sf.json.processors.PropertyNameProcessorMatcher.DefaultPropertyNameProcessorMatcher) r2
            if (r2 == 0) goto L_0x003a
            if (r11 == 0) goto L_0x002f
            if (r4 == 0) goto L_0x002f
            boolean r2 = r4.contains(r11)
            if (r2 == 0) goto L_0x002f
            r2 = r11
            goto L_0x0030
        L_0x002f:
            r2 = r3
        L_0x0030:
            java.util.Map r4 = r0.jsonPropertyNameProcessorMap
            java.lang.Object r2 = r4.get(r2)
            net.sf.json.processors.PropertyNameProcessor r2 = (net.sf.json.processors.PropertyNameProcessor) r2
            r12 = r2
            goto L_0x003c
        L_0x003a:
            throw r3
        L_0x003b:
            r12 = r3
        L_0x003c:
            if (r11 != 0) goto L_0x0043
            java.util.Collection r2 = r20.getMergedExcludes()
            goto L_0x0090
        L_0x0043:
            java.util.Collection r2 = r20.getMergedExcludes()
            java.util.Map r4 = r0.exclusionMap
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0090
            net.sf.json.util.PropertyExclusionClassMatcher r4 = r0.propertyExclusionClassMatcher
            java.util.Map r5 = r0.exclusionMap
            java.util.Set r5 = r5.keySet()
            net.sf.json.util.PropertyExclusionClassMatcher$DefaultPropertyExclusionClassMatcher r4 = (net.sf.json.util.PropertyExclusionClassMatcher.DefaultPropertyExclusionClassMatcher) r4
            if (r4 == 0) goto L_0x008f
            if (r5 == 0) goto L_0x0064
            boolean r4 = r5.contains(r11)
            if (r4 == 0) goto L_0x0064
            r3 = r11
        L_0x0064:
            java.util.Map r4 = r0.exclusionMap
            java.lang.Object r3 = r4.get(r3)
            java.util.Set r3 = (java.util.Set) r3
            if (r3 == 0) goto L_0x0090
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0090
            java.util.Iterator r3 = r3.iterator()
        L_0x0078:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0090
            java.lang.Object r4 = r3.next()
            r5 = r2
            java.util.HashSet r5 = (java.util.HashSet) r5
            boolean r6 = r5.contains(r4)
            if (r6 != 0) goto L_0x0078
            r5.add(r4)
            goto L_0x0078
        L_0x008f:
            throw r3
        L_0x0090:
            r13 = r2
            net.sf.json.JSONObject r14 = new net.sf.json.JSONObject
            r14.<init>()
            java.beans.PropertyDescriptor[] r15 = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(r19)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r16 = 0
            r7 = 0
        L_0x009d:
            int r2 = r15.length     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r6 = "Value is not a valid JSON value. "
            r17 = 1
            if (r7 >= r2) goto L_0x0157
            r2 = r15[r7]     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r2 = r2.getName()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            boolean r3 = r13.contains(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            if (r3 == 0) goto L_0x00b1
            goto L_0x00d0
        L_0x00b1:
            r3 = r15[r7]     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.Class r5 = r3.getPropertyType()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3 = r15[r7]     // Catch:{ Exception -> 0x0134 }
            r3.getReadMethod()     // Catch:{ Exception -> 0x0134 }
            r3 = r15[r7]     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.reflect.Method r3 = r3.getReadMethod()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            if (r3 == 0) goto L_0x0114
            r3 = r15[r7]     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.reflect.Method r3 = r3.getReadMethod()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            boolean r3 = isTransient(r3, r0)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            if (r3 == 0) goto L_0x00d4
        L_0x00d0:
            r18 = r7
            goto L_0x0153
        L_0x00d4:
            java.lang.Object r3 = org.apache.commons.beanutils.PropertyUtils.getProperty(r1, r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            net.sf.json.processors.JsonValueProcessor r4 = r0.findJsonValueProcessor(r11, r5, r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            if (r4 == 0) goto L_0x00ff
            java.lang.Object r3 = r4.processObjectValue(r2, r3, r0)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            boolean r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isValidJsonValue(r3)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            if (r4 == 0) goto L_0x00ea
            r4 = r3
            goto L_0x0102
        L_0x00ea:
            net.sf.json.JSONException r0 = new net.sf.json.JSONException     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r2.<init>()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r2.append(r6)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r2.append(r3)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            throw r0     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
        L_0x00ff:
            r4 = r3
            r17 = 0
        L_0x0102:
            if (r12 == 0) goto L_0x0108
            java.lang.String r2 = r12.processPropertyName(r11, r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
        L_0x0108:
            r3 = r2
            r2 = r14
            r6 = r20
            r18 = r7
            r7 = r17
            setValue(r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            goto L_0x0153
        L_0x0114:
            r18 = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.<init>()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r10)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r9)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r11)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r8)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            org.apache.commons.logging.Log r3 = log     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.info(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            goto L_0x0153
        L_0x0134:
            r18 = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.<init>()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r10)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r9)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r11)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.append(r8)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            org.apache.commons.logging.Log r3 = log     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            r3.info(r2)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
        L_0x0153:
            int r7 = r18 + 1
            goto L_0x009d
        L_0x0157:
            boolean r2 = r0.ignorePublicFields     // Catch:{ Exception -> 0x01b5 }
            if (r2 != 0) goto L_0x01bd
            java.lang.reflect.Field[] r8 = r11.getFields()     // Catch:{ Exception -> 0x01b5 }
            r9 = 0
        L_0x0160:
            int r2 = r8.length     // Catch:{ Exception -> 0x01b5 }
            if (r9 >= r2) goto L_0x01bd
            r2 = r8[r9]     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r3 = r2.getName()     // Catch:{ Exception -> 0x01b5 }
            boolean r4 = r13.contains(r3)     // Catch:{ Exception -> 0x01b5 }
            if (r4 == 0) goto L_0x0171
            r10 = r6
            goto L_0x01b1
        L_0x0171:
            java.lang.Class r5 = r2.getType()     // Catch:{ Exception -> 0x01b5 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x01b5 }
            net.sf.json.processors.JsonValueProcessor r4 = r0.findJsonValueProcessor(r11, r5, r3)     // Catch:{ Exception -> 0x01b5 }
            if (r4 == 0) goto L_0x01a1
            java.lang.Object r2 = r4.processObjectValue(r3, r2, r0)     // Catch:{ Exception -> 0x01b5 }
            boolean r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isValidJsonValue(r2)     // Catch:{ Exception -> 0x01b5 }
            if (r4 == 0) goto L_0x018c
            r4 = r2
            r7 = 1
            goto L_0x01a3
        L_0x018c:
            net.sf.json.JSONException r0 = new net.sf.json.JSONException     // Catch:{ Exception -> 0x01b5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b5 }
            r3.<init>()     // Catch:{ Exception -> 0x01b5 }
            r3.append(r6)     // Catch:{ Exception -> 0x01b5 }
            r3.append(r2)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x01b5 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x01b5 }
            throw r0     // Catch:{ Exception -> 0x01b5 }
        L_0x01a1:
            r4 = r2
            r7 = 0
        L_0x01a3:
            if (r12 == 0) goto L_0x01aa
            java.lang.String r2 = r12.processPropertyName(r11, r3)     // Catch:{ Exception -> 0x01b5 }
            r3 = r2
        L_0x01aa:
            r2 = r14
            r10 = r6
            r6 = r20
            setValue(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01b5 }
        L_0x01b1:
            int r9 = r9 + 1
            r6 = r10
            goto L_0x0160
        L_0x01b5:
            r0 = move-exception
            org.apache.commons.logging.Log r2 = log     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
            java.lang.String r3 = "Couldn't read public fields."
            r2.trace(r3, r0)     // Catch:{ JSONException -> 0x01c8, Exception -> 0x01be }
        L_0x01bd:
            return r14
        L_0x01be:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r19)
            net.sf.json.JSONException r1 = new net.sf.json.JSONException
            r1.<init>(r0)
            throw r1
        L_0x01c8:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r19)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.JSONObject.defaultBeanProcessing(java.lang.Object, net.sf.json.JsonConfig):net.sf.json.JSONObject");
    }

    public static JSONObject fromObject(Object obj) {
        return fromObject(obj, new JsonConfig());
    }

    public static boolean isTransient(AnnotatedElement annotatedElement, JsonConfig jsonConfig) {
        for (String cls : Collections.unmodifiableList(jsonConfig.ignoreFieldAnnotations)) {
            try {
                if (annotatedElement.getAnnotation(Class.forName(cls)) != null) {
                    return true;
                }
            } catch (Exception e2) {
                Log log2 = log;
                log2.info("Error while inspecting " + annotatedElement + " for transient status.", e2);
            }
        }
        return false;
    }

    public static void setValue(JSONObject jSONObject, String str, Object obj, Class cls, JsonConfig jsonConfig, boolean z) {
        boolean z2;
        Class<String> cls2 = String.class;
        if (obj == null) {
            obj = jsonConfig.findDefaultValueProcessor(cls).getDefaultValue(cls);
            if (!TypeUtilsKt.isValidJsonValue(obj)) {
                throw new JSONException(GeneratedOutlineSupport.outline48("Value is not a valid JSON value. ", obj));
            }
        }
        if (jSONObject.properties.containsKey(str)) {
            if (cls2.isAssignableFrom(cls)) {
                Object opt = jSONObject.opt(str);
                if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    String str2 = (String) obj;
                    if (jSONArray == null) {
                        throw null;
                    } else if (str2 != null) {
                        jSONArray.elements.add(str2);
                    }
                } else {
                    Map map = jSONObject.properties;
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.addValue(opt, new JsonConfig());
                    String str3 = (String) obj;
                    if (str3 != null) {
                        jSONArray2.elements.add(str3);
                    }
                    map.put(str, jSONArray2);
                }
            } else {
                jSONObject._accumulate(str, obj, jsonConfig);
            }
            z2 = true;
        } else {
            if (z || cls2.isAssignableFrom(cls)) {
                jSONObject.properties.put(str, obj);
            } else {
                jSONObject._setInternal(str, jSONObject.processValue(str, obj, jsonConfig));
            }
            z2 = false;
        }
        Object opt2 = jSONObject.opt(str);
        if (z2) {
            JSONArray jSONArray3 = (JSONArray) opt2;
            jSONArray3.get(jSONArray3.size() - 1);
        }
    }

    public final JSONObject _accumulate(String str, Object obj, JsonConfig jsonConfig) {
        if (!this.nullObject) {
            verifyIsNull();
            if (!this.properties.containsKey(str)) {
                _setInternal(str, processValue(str, obj, jsonConfig));
            } else {
                Object opt = opt(str);
                if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    jSONArray.elements.add(jSONArray.processValue(obj, jsonConfig));
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.addValue(opt, new JsonConfig());
                    jSONArray2.elements.add(jSONArray2.processValue(obj, jsonConfig));
                    _setInternal(str, processValue(str, jSONArray2, jsonConfig));
                }
            }
            return this;
        }
        throw new JSONException((String) "Can't accumulate on null object");
    }

    public Object _processValue(Object obj, JsonConfig jsonConfig) {
        if (obj instanceof JSONTokener) {
            return _fromJSONTokener((JSONTokener) obj, jsonConfig);
        }
        if (obj == null || !Enum.class.isAssignableFrom(obj.getClass())) {
            return super._processValue(obj, jsonConfig);
        }
        return ((Enum) obj).name();
    }

    public final JSONObject _setInternal(String str, Object obj) {
        verifyIsNull();
        if (str != null) {
            if (JSONUtils.isString(obj) && JSONUtils.mayBeJSON(String.valueOf(obj))) {
                this.properties.put(str, obj);
            } else if (!(CycleDetectionStrategy.IGNORE_PROPERTY_OBJ == obj || CycleDetectionStrategy.IGNORE_PROPERTY_ARR == obj)) {
                this.properties.put(str, obj);
            }
            return this;
        }
        throw new JSONException((String) "Null key.");
    }

    public JSONObject accumulate(String str, Object obj, JsonConfig jsonConfig) {
        _accumulate(str, obj, jsonConfig);
        return this;
    }

    public void clear() {
        this.properties.clear();
    }

    public int compareTo(Object obj) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            int size = size();
            int size2 = jSONObject.size();
            if (size < size2) {
                return -1;
            }
            if (size > size2) {
                return 1;
            }
            if (equals(jSONObject)) {
                return 0;
            }
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        return this.properties.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        JsonConfig jsonConfig = new JsonConfig();
        if (obj != null) {
            try {
                JsonValueProcessor findJsonValueProcessor = jsonConfig.findJsonValueProcessor(obj.getClass());
                if (findJsonValueProcessor != null) {
                    obj = findJsonValueProcessor.processObjectValue(null, obj, jsonConfig);
                    if (!TypeUtilsKt.isValidJsonValue(obj)) {
                        throw new JSONException("Value is not a valid JSON value. " + obj);
                    }
                }
            } catch (JSONException unused) {
                return false;
            }
        }
        return this.properties.containsValue(_processValue(obj, jsonConfig));
    }

    public JSONObject element(String str, Object obj, JsonConfig jsonConfig) {
        verifyIsNull();
        if (str != null) {
            if (obj != null) {
                _setInternal(str, processValue(str, obj, jsonConfig));
            } else {
                verifyIsNull();
                this.properties.remove(str);
            }
            return this;
        }
        throw new JSONException((String) "Null key.");
    }

    public Set entrySet() {
        return Collections.unmodifiableSet(this.properties.entrySet());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JSONObject)) {
            return false;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (this.nullObject) {
            return jSONObject.nullObject;
        }
        if (jSONObject.nullObject || jSONObject.size() != size()) {
            return false;
        }
        for (String str : this.properties.keySet()) {
            if (!jSONObject.properties.containsKey(str)) {
                return false;
            }
            Object obj2 = this.properties.get(str);
            Object obj3 = jSONObject.properties.get(str);
            if (JSONNull.instance.equals(obj2)) {
                if (!JSONNull.instance.equals(obj3)) {
                    return false;
                }
            } else if (JSONNull.instance.equals(obj3)) {
                return false;
            } else {
                boolean z = obj2 instanceof String;
                if (!z || !(obj3 instanceof JSONFunction)) {
                    boolean z2 = obj2 instanceof JSONFunction;
                    if (!z2 || !(obj3 instanceof String)) {
                        if (!(obj2 instanceof JSONObject) || !(obj3 instanceof JSONObject)) {
                            if (!(obj2 instanceof JSONArray) || !(obj3 instanceof JSONArray)) {
                                if (!z2 || !(obj3 instanceof JSONFunction)) {
                                    if (z) {
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
            }
        }
        return true;
    }

    public Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        verifyIsNull();
        return this.properties.get((String) obj);
    }

    public int hashCode() {
        if (this.nullObject) {
            return 3392959;
        }
        int i = 19;
        for (Entry entry : this.properties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            i += JSONUtils.hashCode(value) + key.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.properties.isEmpty();
    }

    public Set keySet() {
        return Collections.unmodifiableSet(this.properties.keySet());
    }

    public Object opt(String str) {
        verifyIsNull();
        if (str == null) {
            return null;
        }
        return this.properties.get(str);
    }

    public final Object processValue(String str, Object obj, JsonConfig jsonConfig) {
        if (obj != null) {
            JsonValueProcessor findJsonValueProcessor = jsonConfig.findJsonValueProcessor(obj.getClass(), str);
            if (findJsonValueProcessor != null) {
                obj = findJsonValueProcessor.processObjectValue(null, obj, jsonConfig);
                if (!TypeUtilsKt.isValidJsonValue(obj)) {
                    throw new JSONException(GeneratedOutlineSupport.outline48("Value is not a valid JSON value. ", obj));
                }
            }
        }
        return _processValue(obj, jsonConfig);
    }

    public Object put(Object obj, Object obj2) {
        if (obj != null) {
            Object obj3 = this.properties.get(obj);
            element(String.valueOf(obj), obj2, new JsonConfig());
            return obj3;
        }
        throw new IllegalArgumentException("key is null.");
    }

    public void putAll(Map map) {
        JsonConfig jsonConfig = new JsonConfig();
        if (map instanceof JSONObject) {
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                this.properties.put((String) entry.getKey(), value);
            }
            return;
        }
        for (Entry entry2 : map.entrySet()) {
            element(String.valueOf(entry2.getKey()), entry2.getValue(), jsonConfig);
        }
    }

    public Object remove(Object obj) {
        return this.properties.remove(obj);
    }

    public int size() {
        return this.properties.size();
    }

    public String toString() {
        if (this.nullObject) {
            return "null";
        }
        try {
            verifyIsNull();
            StringBuffer stringBuffer = new StringBuffer("{");
            for (Object next : keySet()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(JSONUtils.quote(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(JSONUtils.valueToString(this.properties.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public Collection values() {
        return Collections.unmodifiableCollection(this.properties.values());
    }

    public final void verifyIsNull() {
        if (this.nullObject) {
            throw new JSONException((String) "null object");
        }
    }

    /* JADX WARNING: type inference failed for: r1v16, types: [java.lang.Class, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.sf.json.JSONObject fromObject(java.lang.Object r14, net.sf.json.JsonConfig r15) {
        /*
            r0 = 1
            if (r14 == 0) goto L_0x02f4
            boolean r1 = net.sf.json.util.JSONUtils.isNull(r14)
            if (r1 == 0) goto L_0x000b
            goto L_0x02f4
        L_0x000b:
            boolean r1 = r14 instanceof java.lang.Enum
            if (r1 != 0) goto L_0x02ec
            boolean r1 = r14 instanceof java.lang.annotation.Annotation
            if (r1 != 0) goto L_0x02e4
            java.lang.Class r1 = r14.getClass()
            boolean r1 = r1.isAnnotation()
            if (r1 != 0) goto L_0x02e4
            boolean r1 = r14 instanceof net.sf.json.JSONObject
            java.lang.String r2 = "JSON keys must be strings."
            java.lang.String r3 = "JSON keys must not be null nor the 'null' string."
            java.lang.String r4 = "JSON keys cannot be null."
            java.lang.String r5 = "null"
            r6 = 0
            if (r1 == 0) goto L_0x00e9
            net.sf.json.JSONObject r14 = (net.sf.json.JSONObject) r14
            boolean r1 = r14.nullObject
            if (r1 == 0) goto L_0x003c
            if (r15 == 0) goto L_0x003b
            net.sf.json.JSONObject r14 = new net.sf.json.JSONObject
            r14.<init>()
            r14.nullObject = r0
            goto L_0x00e7
        L_0x003b:
            throw r6
        L_0x003c:
            boolean r0 = net.sf.json.AbstractJSON.addInstance(r14)
            if (r0 != 0) goto L_0x005f
            net.sf.json.util.CycleDetectionStrategy r0 = r15.cycleDetectionStrategy     // Catch:{ JSONException -> 0x0057, RuntimeException -> 0x004a }
            net.sf.json.JSONObject r14 = r0.handleRepeatedReferenceAsObject(r14)     // Catch:{ JSONException -> 0x0057, RuntimeException -> 0x004a }
            goto L_0x00e7
        L_0x004a:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r0)
            if (r15 == 0) goto L_0x0056
            throw r14
        L_0x0056:
            throw r6
        L_0x0057:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            if (r15 == 0) goto L_0x005e
            throw r0
        L_0x005e:
            throw r6
        L_0x005f:
            if (r15 == 0) goto L_0x00e8
            r14.verifyIsNull()
            net.sf.json.JSONArray r0 = new net.sf.json.JSONArray
            r0.<init>()
            r14.verifyIsNull()
            java.util.Set r1 = r14.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0074:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0082
            java.lang.Object r6 = r1.next()
            r0.addValue(r6, r15)
            goto L_0x0074
        L_0x0082:
            java.util.Collection r1 = r15.getMergedExcludes()
            net.sf.json.JSONObject r6 = new net.sf.json.JSONObject
            r6.<init>()
            net.sf.json.JSONArray$JSONArrayListIterator r7 = new net.sf.json.JSONArray$JSONArrayListIterator
            r7.<init>()
        L_0x0090:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00e3
            java.lang.Object r0 = r7.next()
            if (r0 == 0) goto L_0x00dd
            boolean r8 = r0 instanceof java.lang.String
            if (r8 != 0) goto L_0x00ab
            boolean r8 = r15.allowNonStringKeys
            if (r8 == 0) goto L_0x00a5
            goto L_0x00ab
        L_0x00a5:
            java.lang.ClassCastException r14 = new java.lang.ClassCastException
            r14.<init>(r2)
            throw r14
        L_0x00ab:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r8 = r5.equals(r0)
            if (r8 != 0) goto L_0x00d7
            r8 = r1
            java.util.HashSet r8 = (java.util.HashSet) r8
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x00bf
            goto L_0x0090
        L_0x00bf:
            java.lang.Object r8 = r14.opt(r0)
            java.util.Map r9 = r6.properties
            boolean r9 = r9.containsKey(r0)
            if (r9 == 0) goto L_0x00cf
            r6._accumulate(r0, r8, r15)
            goto L_0x0090
        L_0x00cf:
            java.lang.Object r8 = r6.processValue(r0, r8, r15)
            r6._setInternal(r0, r8)
            goto L_0x0090
        L_0x00d7:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r3)
            throw r14
        L_0x00dd:
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r4)
            throw r14
        L_0x00e3:
            net.sf.json.AbstractJSON.removeInstance(r14)
            r14 = r6
        L_0x00e7:
            return r14
        L_0x00e8:
            throw r6
        L_0x00e9:
            boolean r1 = r14 instanceof org.apache.commons.beanutils.DynaBean
            if (r1 == 0) goto L_0x00f4
            org.apache.commons.beanutils.DynaBean r14 = (org.apache.commons.beanutils.DynaBean) r14
            net.sf.json.JSONObject r14 = _fromDynaBean(r14, r15)
            return r14
        L_0x00f4:
            boolean r1 = r14 instanceof net.sf.json.util.JSONTokener
            if (r1 == 0) goto L_0x00ff
            net.sf.json.util.JSONTokener r14 = (net.sf.json.util.JSONTokener) r14
            net.sf.json.JSONObject r14 = _fromJSONTokener(r14, r15)
            return r14
        L_0x00ff:
            boolean r1 = r14 instanceof net.sf.json.JSONString
            if (r1 == 0) goto L_0x0113
            net.sf.json.JSONString r14 = (net.sf.json.JSONString) r14
            net.sf.json.util.JSONTokener r0 = new net.sf.json.util.JSONTokener
            java.lang.String r14 = r14.toJSONString()
            r0.<init>(r14)
            net.sf.json.JSONObject r14 = _fromJSONTokener(r0, r15)
            return r14
        L_0x0113:
            boolean r1 = r14 instanceof java.util.Map
            if (r1 == 0) goto L_0x0206
            java.util.Map r14 = (java.util.Map) r14
            boolean r1 = net.sf.json.AbstractJSON.addInstance(r14)
            if (r1 != 0) goto L_0x013c
            net.sf.json.util.CycleDetectionStrategy r0 = r15.cycleDetectionStrategy     // Catch:{ JSONException -> 0x0134, RuntimeException -> 0x0127 }
            net.sf.json.JSONObject r14 = r0.handleRepeatedReferenceAsObject(r14)     // Catch:{ JSONException -> 0x0134, RuntimeException -> 0x0127 }
            goto L_0x01f5
        L_0x0127:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r0)
            if (r15 == 0) goto L_0x0133
            throw r14
        L_0x0133:
            throw r6
        L_0x0134:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            if (r15 == 0) goto L_0x013b
            throw r0
        L_0x013b:
            throw r6
        L_0x013c:
            if (r15 == 0) goto L_0x0205
            java.util.Collection r1 = r15.getMergedExcludes()
            net.sf.json.JSONObject r12 = new net.sf.json.JSONObject
            r12.<init>()
            java.util.Set r6 = r14.entrySet()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.util.Iterator r13 = r6.iterator()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
        L_0x014f:
            boolean r6 = r13.hasNext()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r6 == 0) goto L_0x01f1
            java.lang.Object r6 = r13.next()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r7 == 0) goto L_0x01eb
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 != 0) goto L_0x0170
            boolean r8 = r15.allowNonStringKeys     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 == 0) goto L_0x016a
            goto L_0x0170
        L_0x016a:
            java.lang.ClassCastException r15 = new java.lang.ClassCastException     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r15.<init>(r2)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            throw r15     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
        L_0x0170:
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            boolean r8 = r5.equals(r7)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 != 0) goto L_0x01e5
            r8 = r1
            java.util.HashSet r8 = (java.util.HashSet) r8
            boolean r8 = r8.contains(r7)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 == 0) goto L_0x0184
            goto L_0x014f
        L_0x0184:
            java.lang.Object r6 = r6.getValue()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r6 == 0) goto L_0x01c5
            java.lang.Class r8 = r6.getClass()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            net.sf.json.processors.JsonValueProcessor r8 = r15.findJsonValueProcessor(r8, r7)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 == 0) goto L_0x01b8
            java.lang.Object r6 = r8.processObjectValue(r7, r6, r15)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            boolean r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isValidJsonValue(r6)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r8 == 0) goto L_0x01a1
            r8 = r6
            r11 = 1
            goto L_0x01bb
        L_0x01a1:
            net.sf.json.JSONException r15 = new net.sf.json.JSONException     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r0.<init>()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.lang.String r1 = "Value is not a valid JSON value. "
            r0.append(r1)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r0.append(r6)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r15.<init>(r0)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            throw r15     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
        L_0x01b8:
            r8 = 0
            r8 = r6
            r11 = 0
        L_0x01bb:
            java.lang.Class r9 = r8.getClass()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r6 = r12
            r10 = r15
            setValue(r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            goto L_0x014f
        L_0x01c5:
            java.util.Map r6 = r12.properties     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            boolean r6 = r6.containsKey(r7)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            if (r6 == 0) goto L_0x01d9
            net.sf.json.JSONNull r6 = net.sf.json.JSONNull.instance     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            net.sf.json.JsonConfig r8 = new net.sf.json.JsonConfig     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r8.<init>()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r12._accumulate(r7, r6, r8)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            goto L_0x014f
        L_0x01d9:
            net.sf.json.JSONNull r6 = net.sf.json.JSONNull.instance     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            net.sf.json.JsonConfig r8 = new net.sf.json.JsonConfig     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r8.<init>()     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r12.element(r7, r6, r8)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            goto L_0x014f
        L_0x01e5:
            java.lang.NullPointerException r15 = new java.lang.NullPointerException     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r15.<init>(r3)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            throw r15     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
        L_0x01eb:
            net.sf.json.JSONException r15 = new net.sf.json.JSONException     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            r15.<init>(r4)     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
            throw r15     // Catch:{ JSONException -> 0x0200, RuntimeException -> 0x01f6 }
        L_0x01f1:
            net.sf.json.AbstractJSON.removeInstance(r14)
            r14 = r12
        L_0x01f5:
            return r14
        L_0x01f6:
            r15 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r15)
            throw r14
        L_0x0200:
            r15 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            throw r15
        L_0x0205:
            throw r6
        L_0x0206:
            boolean r1 = r14 instanceof java.lang.String
            if (r1 == 0) goto L_0x0227
            java.lang.String r14 = (java.lang.String) r14
            boolean r1 = r5.equals(r14)
            if (r1 == 0) goto L_0x021d
            if (r15 == 0) goto L_0x021c
            net.sf.json.JSONObject r14 = new net.sf.json.JSONObject
            r14.<init>()
            r14.nullObject = r0
            goto L_0x0226
        L_0x021c:
            throw r6
        L_0x021d:
            net.sf.json.util.JSONTokener r0 = new net.sf.json.util.JSONTokener
            r0.<init>(r14)
            net.sf.json.JSONObject r14 = _fromJSONTokener(r0, r15)
        L_0x0226:
            return r14
        L_0x0227:
            boolean r1 = net.sf.json.util.JSONUtils.isNumber(r14)
            if (r1 != 0) goto L_0x02de
            boolean r1 = net.sf.json.util.JSONUtils.isBoolean(r14)
            if (r1 != 0) goto L_0x02de
            boolean r1 = net.sf.json.util.JSONUtils.isString(r14)
            if (r1 == 0) goto L_0x023b
            goto L_0x02de
        L_0x023b:
            boolean r1 = net.sf.json.util.JSONUtils.isArray(r14)
            if (r1 != 0) goto L_0x02d6
            boolean r1 = net.sf.json.AbstractJSON.addInstance(r14)
            if (r1 != 0) goto L_0x0264
            net.sf.json.util.CycleDetectionStrategy r0 = r15.cycleDetectionStrategy     // Catch:{ JSONException -> 0x025c, RuntimeException -> 0x024f }
            net.sf.json.JSONObject r14 = r0.handleRepeatedReferenceAsObject(r14)     // Catch:{ JSONException -> 0x025c, RuntimeException -> 0x024f }
            goto L_0x02d4
        L_0x024f:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r0)
            if (r15 == 0) goto L_0x025b
            throw r14
        L_0x025b:
            throw r6
        L_0x025c:
            r0 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            if (r15 == 0) goto L_0x0263
            throw r0
        L_0x0263:
            throw r6
        L_0x0264:
            if (r15 == 0) goto L_0x02d5
            java.lang.Class r1 = r14.getClass()
            java.util.Map r2 = r15.beanProcessorMap
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0294
            net.sf.json.processors.JsonBeanProcessorMatcher r2 = r15.jsonBeanProcessorMatcher
            java.util.Map r3 = r15.beanProcessorMap
            java.util.Set r3 = r3.keySet()
            net.sf.json.processors.JsonBeanProcessorMatcher$DefaultJsonBeanProcessorMatcher r2 = (net.sf.json.processors.JsonBeanProcessorMatcher.DefaultJsonBeanProcessorMatcher) r2
            if (r2 == 0) goto L_0x0293
            if (r1 == 0) goto L_0x0289
            if (r3 == 0) goto L_0x0289
            boolean r2 = r3.contains(r1)
            if (r2 == 0) goto L_0x0289
            r6 = r1
        L_0x0289:
            java.util.Map r1 = r15.beanProcessorMap
            java.lang.Object r1 = r1.get(r6)
            r6 = r1
            net.sf.json.processors.JsonBeanProcessor r6 = (net.sf.json.processors.JsonBeanProcessor) r6
            goto L_0x0294
        L_0x0293:
            throw r6
        L_0x0294:
            if (r6 == 0) goto L_0x02cc
            net.sf.json.JSONObject r1 = r6.processBean(r14, r15)     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            if (r1 != 0) goto L_0x02b8
            java.lang.Class r1 = r14.getClass()     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            net.sf.json.processors.DefaultValueProcessor r15 = r15.findDefaultValueProcessor(r1)     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            java.lang.Class r1 = r14.getClass()     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            java.lang.Object r15 = r15.getDefaultValue(r1)     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            net.sf.json.JSONObject r15 = (net.sf.json.JSONObject) r15     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            if (r15 != 0) goto L_0x02b9
            net.sf.json.JSONObject r15 = new net.sf.json.JSONObject     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            r15.<init>()     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            r15.nullObject = r0     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            goto L_0x02b9
        L_0x02b8:
            r15 = r1
        L_0x02b9:
            net.sf.json.AbstractJSON.removeInstance(r14)     // Catch:{ JSONException -> 0x02c7, RuntimeException -> 0x02bd }
            goto L_0x02d3
        L_0x02bd:
            r15 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            r14.<init>(r15)
            throw r14
        L_0x02c7:
            r15 = move-exception
            net.sf.json.AbstractJSON.removeInstance(r14)
            throw r15
        L_0x02cc:
            net.sf.json.JSONObject r15 = defaultBeanProcessing(r14, r15)
            net.sf.json.AbstractJSON.removeInstance(r14)
        L_0x02d3:
            r14 = r15
        L_0x02d4:
            return r14
        L_0x02d5:
            throw r6
        L_0x02d6:
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            java.lang.String r15 = "'object' is an array. Use JSONArray instead"
            r14.<init>(r15)
            throw r14
        L_0x02de:
            net.sf.json.JSONObject r14 = new net.sf.json.JSONObject
            r14.<init>()
            return r14
        L_0x02e4:
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            java.lang.String r15 = "'object' is an Annotation."
            r14.<init>(r15)
            throw r14
        L_0x02ec:
            net.sf.json.JSONException r14 = new net.sf.json.JSONException
            java.lang.String r15 = "'object' is an Enum. Use JSONArray instead"
            r14.<init>(r15)
            throw r14
        L_0x02f4:
            net.sf.json.JSONObject r14 = new net.sf.json.JSONObject
            r14.<init>()
            r14.nullObject = r0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.JSONObject.fromObject(java.lang.Object, net.sf.json.JsonConfig):net.sf.json.JSONObject");
    }
}
