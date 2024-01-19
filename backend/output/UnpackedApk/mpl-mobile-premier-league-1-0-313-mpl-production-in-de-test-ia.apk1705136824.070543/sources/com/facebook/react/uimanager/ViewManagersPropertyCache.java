package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.paynimo.android.payment.UPIFragment;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class ViewManagersPropertyCache {
    public static final Map<Class, Map<String, PropSetter>> CLASS_PROPS_CACHE = new HashMap();
    public static final Map<String, PropSetter> EMPTY_PROPS_MAP = new HashMap();

    public static class ArrayPropSetter extends PropSetter {
        public ArrayPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Array", method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return (ReadableArray) obj;
        }
    }

    public static class BooleanPropSetter extends PropSetter {
        public final boolean mDefaultValue;

        public BooleanPropSetter(ReactProp reactProp, Method method, boolean z) {
            super(reactProp, "boolean", method, null);
            this.mDefaultValue = z;
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return obj == null ? this.mDefaultValue : ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    public static class BoxedBooleanPropSetter extends PropSetter {
        public BoxedBooleanPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "boolean", method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            if (obj == null) {
                return null;
            }
            return ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    public static class BoxedIntPropSetter extends PropSetter {
        public BoxedIntPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, UPIFragment.CONFIG_TYPE_NUMBER, method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Double) {
                return Integer.valueOf(((Double) obj).intValue());
            }
            return (Integer) obj;
        }

        public BoxedIntPropSetter(ReactPropGroup reactPropGroup, Method method, int i) {
            super(reactPropGroup, UPIFragment.CONFIG_TYPE_NUMBER, method, i, null);
        }
    }

    public static class ColorPropSetter extends PropSetter {
        public final int mDefaultValue;

        public ColorPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, BaseViewManager.STATE_MIXED, method, null);
            this.mDefaultValue = 0;
        }

        public Object getValueOrDefault(Object obj, Context context) {
            if (obj == null) {
                return Integer.valueOf(this.mDefaultValue);
            }
            return ColorPropConverter.getColor(obj, context);
        }

        public ColorPropSetter(ReactProp reactProp, Method method, int i) {
            super(reactProp, BaseViewManager.STATE_MIXED, method, null);
            this.mDefaultValue = i;
        }
    }

    public static class DoublePropSetter extends PropSetter {
        public final double mDefaultValue;

        public DoublePropSetter(ReactProp reactProp, Method method, double d2) {
            super(reactProp, UPIFragment.CONFIG_TYPE_NUMBER, method, null);
            this.mDefaultValue = d2;
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return Double.valueOf(obj == null ? this.mDefaultValue : ((Double) obj).doubleValue());
        }

        public DoublePropSetter(ReactPropGroup reactPropGroup, Method method, int i, double d2) {
            super(reactPropGroup, UPIFragment.CONFIG_TYPE_NUMBER, method, i, null);
            this.mDefaultValue = d2;
        }
    }

    public static class DynamicPropSetter extends PropSetter {
        public DynamicPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, BaseViewManager.STATE_MIXED, method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            if (obj instanceof Dynamic) {
                return obj;
            }
            return new DynamicFromObject(obj);
        }

        public DynamicPropSetter(ReactPropGroup reactPropGroup, Method method, int i) {
            super(reactPropGroup, BaseViewManager.STATE_MIXED, method, i, null);
        }
    }

    public static class FloatPropSetter extends PropSetter {
        public final float mDefaultValue;

        public FloatPropSetter(ReactProp reactProp, Method method, float f2) {
            super(reactProp, UPIFragment.CONFIG_TYPE_NUMBER, method, null);
            this.mDefaultValue = f2;
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return Float.valueOf(obj == null ? this.mDefaultValue : Float.valueOf(((Double) obj).floatValue()).floatValue());
        }

        public FloatPropSetter(ReactPropGroup reactPropGroup, Method method, int i, float f2) {
            super(reactPropGroup, UPIFragment.CONFIG_TYPE_NUMBER, method, i, null);
            this.mDefaultValue = f2;
        }
    }

    public static class IntPropSetter extends PropSetter {
        public final int mDefaultValue;

        public IntPropSetter(ReactProp reactProp, Method method, int i) {
            super(reactProp, UPIFragment.CONFIG_TYPE_NUMBER, method, null);
            this.mDefaultValue = i;
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return Integer.valueOf(obj == null ? this.mDefaultValue : Integer.valueOf(((Double) obj).intValue()).intValue());
        }

        public IntPropSetter(ReactPropGroup reactPropGroup, Method method, int i, int i2) {
            super(reactPropGroup, UPIFragment.CONFIG_TYPE_NUMBER, method, i, null);
            this.mDefaultValue = i2;
        }
    }

    public static class MapPropSetter extends PropSetter {
        public MapPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Map", method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return (ReadableMap) obj;
        }
    }

    public static abstract class PropSetter {
        public static final Object[] SHADOW_ARGS = new Object[1];
        public static final Object[] SHADOW_GROUP_ARGS = new Object[2];
        public static final Object[] VIEW_MGR_ARGS = new Object[2];
        public static final Object[] VIEW_MGR_GROUP_ARGS = new Object[3];
        public final Integer mIndex;
        public final String mPropName;
        public final String mPropType;
        public final Method mSetter;

        public PropSetter(ReactProp reactProp, String str, Method method, AnonymousClass1 r5) {
            this.mPropName = reactProp.name();
            this.mPropType = !"__default_type__".equals(reactProp.customType()) ? reactProp.customType() : str;
            this.mSetter = method;
            this.mIndex = null;
        }

        public abstract Object getValueOrDefault(Object obj, Context context);

        public PropSetter(ReactPropGroup reactPropGroup, String str, Method method, int i, AnonymousClass1 r6) {
            this.mPropName = reactPropGroup.names()[i];
            this.mPropType = !"__default_type__".equals(reactPropGroup.customType()) ? reactPropGroup.customType() : str;
            this.mSetter = method;
            this.mIndex = Integer.valueOf(i);
        }
    }

    public static class StringPropSetter extends PropSetter {
        public StringPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, HanselEventConstant.DATA_TYPE_STRING, method, null);
        }

        public Object getValueOrDefault(Object obj, Context context) {
            return (String) obj;
        }
    }

    public static PropSetter createPropSetter(ReactProp reactProp, Method method, Class<?> cls) {
        if (cls == Dynamic.class) {
            return new DynamicPropSetter(reactProp, method);
        }
        if (cls == Boolean.TYPE) {
            return new BooleanPropSetter(reactProp, method, reactProp.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            if (PDLayoutAttributeObject.COLOR.equals(reactProp.customType())) {
                return new ColorPropSetter(reactProp, method, reactProp.defaultInt());
            }
            return new IntPropSetter(reactProp, method, reactProp.defaultInt());
        } else if (cls == Float.TYPE) {
            return new FloatPropSetter(reactProp, method, reactProp.defaultFloat());
        } else {
            if (cls == Double.TYPE) {
                return new DoublePropSetter(reactProp, method, reactProp.defaultDouble());
            }
            if (cls == String.class) {
                return new StringPropSetter(reactProp, method);
            }
            if (cls == Boolean.class) {
                return new BoxedBooleanPropSetter(reactProp, method);
            }
            if (cls == Integer.class) {
                if (PDLayoutAttributeObject.COLOR.equals(reactProp.customType())) {
                    return new ColorPropSetter(reactProp, method);
                }
                return new BoxedIntPropSetter(reactProp, method);
            } else if (cls == ReadableArray.class) {
                return new ArrayPropSetter(reactProp, method);
            } else {
                if (cls == ReadableMap.class) {
                    return new MapPropSetter(reactProp, method);
                }
                throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + MqttTopic.MULTI_LEVEL_WILDCARD + method.getName());
            }
        }
    }

    public static void createPropSetters(ReactPropGroup reactPropGroup, Method method, Class<?> cls, Map<String, PropSetter> map) {
        String[] names = reactPropGroup.names();
        int i = 0;
        if (cls == Dynamic.class) {
            while (i < names.length) {
                map.put(names[i], new DynamicPropSetter(reactPropGroup, method, i));
                i++;
            }
        } else if (cls == Integer.TYPE) {
            while (i < names.length) {
                map.put(names[i], new IntPropSetter(reactPropGroup, method, i, reactPropGroup.defaultInt()));
                i++;
            }
        } else if (cls == Float.TYPE) {
            while (i < names.length) {
                map.put(names[i], new FloatPropSetter(reactPropGroup, method, i, reactPropGroup.defaultFloat()));
                i++;
            }
        } else if (cls == Double.TYPE) {
            while (i < names.length) {
                String str = names[i];
                DoublePropSetter doublePropSetter = new DoublePropSetter(reactPropGroup, method, i, reactPropGroup.defaultDouble());
                map.put(str, doublePropSetter);
                i++;
            }
        } else if (cls == Integer.class) {
            while (i < names.length) {
                map.put(names[i], new BoxedIntPropSetter(reactPropGroup, method, i));
                i++;
            }
        } else {
            throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + MqttTopic.MULTI_LEVEL_WILDCARD + method.getName());
        }
    }

    public static Map<String, PropSetter> getNativePropSettersForShadowNodeClass(Class<? extends ReactShadowNode> cls) {
        for (Class<ReactShadowNode> cls2 : cls.getInterfaces()) {
            if (cls2 == ReactShadowNode.class) {
                return EMPTY_PROPS_MAP;
            }
        }
        Map<String, PropSetter> map = CLASS_PROPS_CACHE.get(cls);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap(getNativePropSettersForShadowNodeClass(cls.getSuperclass()));
        for (Method method : cls.getDeclaredMethods()) {
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    hashMap.put(reactProp.name(), createPropSetter(reactProp, method, parameterTypes[0]));
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Wrong number of args for prop setter: ");
                    outline73.append(cls.getName());
                    outline73.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline73.append(method.getName());
                    throw new RuntimeException(outline73.toString());
                }
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                Class[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 2) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Wrong number of args for group prop setter: ");
                    outline732.append(cls.getName());
                    outline732.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline732.append(method.getName());
                    throw new RuntimeException(outline732.toString());
                } else if (parameterTypes2[0] == Integer.TYPE) {
                    createPropSetters(reactPropGroup, method, parameterTypes2[1], hashMap);
                } else {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Second argument should be property index: ");
                    outline733.append(cls.getName());
                    outline733.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline733.append(method.getName());
                    throw new RuntimeException(outline733.toString());
                }
            }
        }
        CLASS_PROPS_CACHE.put(cls, hashMap);
        return hashMap;
    }

    public static Map<String, PropSetter> getNativePropSettersForViewManagerClass(Class<? extends ViewManager> cls) {
        if (cls == ViewManager.class) {
            return EMPTY_PROPS_MAP;
        }
        Map<String, PropSetter> map = CLASS_PROPS_CACHE.get(cls);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap(getNativePropSettersForViewManagerClass(cls.getSuperclass()));
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Wrong number of args for prop setter: ");
                    outline73.append(cls.getName());
                    outline73.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline73.append(method.getName());
                    throw new RuntimeException(outline73.toString());
                } else if (View.class.isAssignableFrom(parameterTypes[0])) {
                    hashMap.put(reactProp.name(), createPropSetter(reactProp, method, parameterTypes[1]));
                } else {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("First param should be a view subclass to be updated: ");
                    outline732.append(cls.getName());
                    outline732.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline732.append(method.getName());
                    throw new RuntimeException(outline732.toString());
                }
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                Class[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 3) {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Wrong number of args for group prop setter: ");
                    outline733.append(cls.getName());
                    outline733.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline733.append(method.getName());
                    throw new RuntimeException(outline733.toString());
                } else if (!View.class.isAssignableFrom(parameterTypes2[0])) {
                    StringBuilder outline734 = GeneratedOutlineSupport.outline73("First param should be a view subclass to be updated: ");
                    outline734.append(cls.getName());
                    outline734.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline734.append(method.getName());
                    throw new RuntimeException(outline734.toString());
                } else if (parameterTypes2[1] == Integer.TYPE) {
                    createPropSetters(reactPropGroup, method, parameterTypes2[2], hashMap);
                } else {
                    StringBuilder outline735 = GeneratedOutlineSupport.outline73("Second argument should be property index: ");
                    outline735.append(cls.getName());
                    outline735.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    outline735.append(method.getName());
                    throw new RuntimeException(outline735.toString());
                }
            }
        }
        CLASS_PROPS_CACHE.put(cls, hashMap);
        return hashMap;
    }
}
