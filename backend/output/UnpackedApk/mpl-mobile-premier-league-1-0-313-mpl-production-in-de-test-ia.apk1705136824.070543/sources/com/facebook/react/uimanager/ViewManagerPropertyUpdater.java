package com.facebook.react.uimanager;

import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ViewManagerPropertyUpdater {
    public static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new HashMap();
    public static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

    public static class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {
        public final Map<String, PropSetter> mPropSetters;

        public FallbackShadowNodeSetter(Class cls, AnonymousClass1 r2) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(cls);
        }

        public void getProperties(Map<String, String> map) {
            for (PropSetter next : this.mPropSetters.values()) {
                map.put(next.mPropName, next.mPropType);
            }
        }

        public void setProperty(ReactShadowNode reactShadowNode, String str, Object obj) {
            PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                try {
                    if (propSetter.mIndex == null) {
                        PropSetter.SHADOW_ARGS[0] = propSetter.getValueOrDefault(obj, reactShadowNode.getThemedContext());
                        propSetter.mSetter.invoke(reactShadowNode, PropSetter.SHADOW_ARGS);
                        Arrays.fill(PropSetter.SHADOW_ARGS, null);
                        return;
                    }
                    PropSetter.SHADOW_GROUP_ARGS[0] = propSetter.mIndex;
                    PropSetter.SHADOW_GROUP_ARGS[1] = propSetter.getValueOrDefault(obj, reactShadowNode.getThemedContext());
                    propSetter.mSetter.invoke(reactShadowNode, PropSetter.SHADOW_GROUP_ARGS);
                    Arrays.fill(PropSetter.SHADOW_GROUP_ARGS, null);
                } catch (Throwable th) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while updating prop ");
                    outline73.append(propSetter.mPropName);
                    FLog.e(ViewManager.class, outline73.toString(), th);
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Error while updating property '");
                    outline732.append(propSetter.mPropName);
                    outline732.append("' in shadow node of type: ");
                    outline732.append(reactShadowNode.getViewClass());
                    throw new JSApplicationIllegalArgumentException(outline732.toString(), th);
                }
            }
        }
    }

    public static class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {
        public final Map<String, PropSetter> mPropSetters;

        public FallbackViewManagerSetter(Class cls, AnonymousClass1 r2) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(cls);
        }

        public void getProperties(Map<String, String> map) {
            for (PropSetter next : this.mPropSetters.values()) {
                map.put(next.mPropName, next.mPropType);
            }
        }

        public void setProperty(T t, V v, String str, Object obj) {
            PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                try {
                    if (propSetter.mIndex == null) {
                        PropSetter.VIEW_MGR_ARGS[0] = v;
                        PropSetter.VIEW_MGR_ARGS[1] = propSetter.getValueOrDefault(obj, v.getContext());
                        propSetter.mSetter.invoke(t, PropSetter.VIEW_MGR_ARGS);
                        Arrays.fill(PropSetter.VIEW_MGR_ARGS, null);
                        return;
                    }
                    PropSetter.VIEW_MGR_GROUP_ARGS[0] = v;
                    PropSetter.VIEW_MGR_GROUP_ARGS[1] = propSetter.mIndex;
                    PropSetter.VIEW_MGR_GROUP_ARGS[2] = propSetter.getValueOrDefault(obj, v.getContext());
                    propSetter.mSetter.invoke(t, PropSetter.VIEW_MGR_GROUP_ARGS);
                    Arrays.fill(PropSetter.VIEW_MGR_GROUP_ARGS, null);
                } catch (Throwable th) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while updating prop ");
                    outline73.append(propSetter.mPropName);
                    FLog.e(ViewManager.class, outline73.toString(), th);
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Error while updating property '");
                    outline732.append(propSetter.mPropName);
                    outline732.append("' of a view managed by: ");
                    outline732.append(t.getName());
                    throw new JSApplicationIllegalArgumentException(outline732.toString(), th);
                }
            }
        }
    }

    public interface Settable {
        void getProperties(Map<String, String> map);
    }

    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void setProperty(T t, String str, Object obj);
    }

    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void setProperty(T t, V v, String str, Object obj);
    }

    public static void clear() {
        ViewManagersPropertyCache.CLASS_PROPS_CACHE.clear();
        ViewManagersPropertyCache.EMPTY_PROPS_MAP.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    public static <T> T findGeneratedSetter(Class<?> cls) {
        String name = cls.getName();
        try {
            return Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.w((String) "ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException | InstantiationException e2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline50("Unable to instantiate methods getter for ", name), e2);
        }
    }

    public static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> findManagerSetter(Class<? extends ViewManager> cls) {
        ViewManagerSetter<T, V> viewManagerSetter = VIEW_MANAGER_SETTER_MAP.get(cls);
        if (viewManagerSetter == null) {
            viewManagerSetter = (ViewManagerSetter) findGeneratedSetter(cls);
            if (viewManagerSetter == null) {
                viewManagerSetter = new FallbackViewManagerSetter<>(cls, null);
            }
            VIEW_MANAGER_SETTER_MAP.put(cls, viewManagerSetter);
        }
        return viewManagerSetter;
    }

    public static <T extends ReactShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ReactShadowNode> cls) {
        ShadowNodeSetter<T> shadowNodeSetter = SHADOW_NODE_SETTER_MAP.get(cls);
        if (shadowNodeSetter == null) {
            shadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (shadowNodeSetter == null) {
                shadowNodeSetter = new FallbackShadowNodeSetter<>(cls, null);
            }
            SHADOW_NODE_SETTER_MAP.put(cls, shadowNodeSetter);
        }
        return shadowNodeSetter;
    }

    public static Map<String, String> getNativeProps(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        HashMap hashMap = new HashMap();
        findManagerSetter(cls).getProperties(hashMap);
        findNodeSetter(cls2).getProperties(hashMap);
        return hashMap;
    }

    public static <T extends ViewManager, V extends View> void updateProps(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerSetter<?, V> findManagerSetter = findManagerSetter(t.getClass());
        Iterator<Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Entry next = entryIterator.next();
            findManagerSetter.setProperty(t, v, (String) next.getKey(), next.getValue());
        }
    }

    public static <T extends ReactShadowNode> void updateProps(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ShadowNodeSetter<?> findNodeSetter = findNodeSetter(t.getClass());
        Iterator<Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Entry next = entryIterator.next();
            findNodeSetter.setProperty(t, (String) next.getKey(), next.getValue());
        }
    }
}
