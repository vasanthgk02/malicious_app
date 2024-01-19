package net.sf.json;

import com.facebook.react.bridge.PromiseImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.json.processors.DefaultDefaultValueProcessor;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.DefaultValueProcessorMatcher;
import net.sf.json.processors.DefaultValueProcessorMatcher.DefaultDefaultValueProcessorMatcher;
import net.sf.json.processors.JsonBeanProcessorMatcher;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.processors.JsonValueProcessorMatcher;
import net.sf.json.processors.PropertyNameProcessorMatcher;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JavaIdentifierTransformer;
import net.sf.json.util.NewBeanInstanceStrategy;
import net.sf.json.util.PropertyExclusionClassMatcher;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang.StringUtils;

public class JsonConfig {
    public static final Class DEFAULT_COLLECTION_TYPE;
    public static final CycleDetectionStrategy DEFAULT_CYCLE_DETECTION_STRATEGY = CycleDetectionStrategy.STRICT;
    public static final DefaultValueProcessorMatcher DEFAULT_DEFAULT_VALUE_PROCESSOR_MATCHER = DefaultValueProcessorMatcher.DEFAULT;
    public static final String[] DEFAULT_EXCLUDES = {PromiseImpl.STACK_FRAME_KEY_CLASS, "declaringClass", "metaClass"};
    public static final JavaIdentifierTransformer DEFAULT_JAVA_IDENTIFIER_TRANSFORMER = JavaIdentifierTransformer.NOOP;
    public static final JsonBeanProcessorMatcher DEFAULT_JSON_BEAN_PROCESSOR_MATCHER = JsonBeanProcessorMatcher.DEFAULT;
    public static final JsonValueProcessorMatcher DEFAULT_JSON_VALUE_PROCESSOR_MATCHER = JsonValueProcessorMatcher.DEFAULT;
    public static final NewBeanInstanceStrategy DEFAULT_NEW_BEAN_INSTANCE_STRATEGY = NewBeanInstanceStrategy.DEFAULT;
    public static final PropertyExclusionClassMatcher DEFAULT_PROPERTY_EXCLUSION_CLASS_MATCHER = PropertyExclusionClassMatcher.DEFAULT;
    public static final PropertyNameProcessorMatcher DEFAULT_PROPERTY_NAME_PROCESSOR_MATCHER = PropertyNameProcessorMatcher.DEFAULT;
    public static final DefaultValueProcessor DEFAULT_VALUE_PROCESSOR = new DefaultDefaultValueProcessor();
    public static final String[] EMPTY_EXCLUDES = new String[0];
    public static /* synthetic */ Class class$java$util$List;
    public boolean allowNonStringKeys;
    public MultiKeyMap beanKeyMap = new MultiKeyMap();
    public Map beanProcessorMap = new HashMap();
    public MultiKeyMap beanTypeMap = new MultiKeyMap();
    public CycleDetectionStrategy cycleDetectionStrategy = DEFAULT_CYCLE_DETECTION_STRATEGY;
    public Map defaultValueMap = new HashMap();
    public DefaultValueProcessorMatcher defaultValueProcessorMatcher = DEFAULT_DEFAULT_VALUE_PROCESSOR_MATCHER;
    public List eventListeners = new ArrayList();
    public String[] excludes = EMPTY_EXCLUDES;
    public Map exclusionMap = new HashMap();
    public List ignoreFieldAnnotations;
    public boolean ignorePublicFields = true;
    public JsonBeanProcessorMatcher jsonBeanProcessorMatcher;
    public Map jsonPropertyNameProcessorMap;
    public PropertyNameProcessorMatcher jsonPropertyNameProcessorMatcher;
    public JsonValueProcessorMatcher jsonValueProcessorMatcher;
    public Map keyMap;
    public PropertyExclusionClassMatcher propertyExclusionClassMatcher;
    public Map typeMap;

    static {
        Class<?> cls = class$java$util$List;
        if (cls == null) {
            try {
                cls = Class.forName("java.util.List");
                class$java$util$List = cls;
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
        DEFAULT_COLLECTION_TYPE = cls;
    }

    public JsonConfig() {
        new HashMap();
        this.jsonBeanProcessorMatcher = DEFAULT_JSON_BEAN_PROCESSOR_MATCHER;
        this.jsonPropertyNameProcessorMap = new HashMap();
        this.jsonPropertyNameProcessorMatcher = DEFAULT_PROPERTY_NAME_PROCESSOR_MATCHER;
        this.jsonValueProcessorMatcher = DEFAULT_JSON_VALUE_PROCESSOR_MATCHER;
        this.keyMap = new HashMap();
        this.propertyExclusionClassMatcher = DEFAULT_PROPERTY_EXCLUSION_CLASS_MATCHER;
        this.typeMap = new HashMap();
        this.ignoreFieldAnnotations = new ArrayList();
        this.allowNonStringKeys = false;
    }

    public DefaultValueProcessor findDefaultValueProcessor(Class cls) {
        if (!this.defaultValueMap.isEmpty()) {
            DefaultValueProcessorMatcher defaultValueProcessorMatcher2 = this.defaultValueProcessorMatcher;
            Set keySet = this.defaultValueMap.keySet();
            if (((DefaultDefaultValueProcessorMatcher) defaultValueProcessorMatcher2) != null) {
                if (cls == null || keySet == null || !keySet.contains(cls)) {
                    cls = null;
                }
                DefaultValueProcessor defaultValueProcessor = (DefaultValueProcessor) this.defaultValueMap.get(cls);
                if (defaultValueProcessor != null) {
                    return defaultValueProcessor;
                }
            } else {
                throw null;
            }
        }
        return DEFAULT_VALUE_PROCESSOR;
    }

    public JsonValueProcessor findJsonValueProcessor(Class cls) {
        if (this.typeMap.isEmpty()) {
            return null;
        }
        return (JsonValueProcessor) this.typeMap.get(this.jsonValueProcessorMatcher.getMatch(cls, this.typeMap.keySet()));
    }

    public Collection getMergedExcludes() {
        HashSet hashSet = new HashSet();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.excludes;
            if (i2 >= strArr.length) {
                break;
            }
            String str = strArr[i2];
            if (!StringUtils.isBlank(strArr[i2])) {
                hashSet.add(str.trim());
            }
            i2++;
        }
        while (true) {
            String[] strArr2 = DEFAULT_EXCLUDES;
            if (i >= strArr2.length) {
                return hashSet;
            }
            if (!hashSet.contains(strArr2[i])) {
                hashSet.add(DEFAULT_EXCLUDES[i]);
            }
            i++;
        }
    }

    public JsonValueProcessor findJsonValueProcessor(Class cls, Class cls2, String str) {
        JsonValueProcessor jsonValueProcessor = (JsonValueProcessor) this.beanKeyMap.get(cls, str);
        if (jsonValueProcessor != null) {
            return jsonValueProcessor;
        }
        JsonValueProcessor jsonValueProcessor2 = (JsonValueProcessor) this.beanTypeMap.get(cls, cls2);
        if (jsonValueProcessor2 != null) {
            return jsonValueProcessor2;
        }
        JsonValueProcessor jsonValueProcessor3 = (JsonValueProcessor) this.keyMap.get(str);
        if (jsonValueProcessor3 != null) {
            return jsonValueProcessor3;
        }
        JsonValueProcessor jsonValueProcessor4 = (JsonValueProcessor) this.typeMap.get(this.jsonValueProcessorMatcher.getMatch(cls2, this.typeMap.keySet()));
        if (jsonValueProcessor4 != null) {
            return jsonValueProcessor4;
        }
        return null;
    }

    public JsonValueProcessor findJsonValueProcessor(Class cls, String str) {
        JsonValueProcessor jsonValueProcessor = (JsonValueProcessor) this.keyMap.get(str);
        if (jsonValueProcessor != null) {
            return jsonValueProcessor;
        }
        JsonValueProcessor jsonValueProcessor2 = (JsonValueProcessor) this.typeMap.get(this.jsonValueProcessorMatcher.getMatch(cls, this.typeMap.keySet()));
        if (jsonValueProcessor2 != null) {
            return jsonValueProcessor2;
        }
        return null;
    }
}
