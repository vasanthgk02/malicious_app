package com.facebook.react.uimanager;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.NoopBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UIManagerModuleConstantsHelper {
    public static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> constants = ImageOriginUtils.getConstants();
        Map bubblingEventTypeConstants = ImageOriginUtils.getBubblingEventTypeConstants();
        Map directEventTypeConstants = ImageOriginUtils.getDirectEventTypeConstants();
        if (map != null) {
            map.putAll(bubblingEventTypeConstants);
        }
        if (map2 != null) {
            map2.putAll(directEventTypeConstants);
        }
        for (ViewManager next : list) {
            String name = next.getName();
            NoopBuilder noopBuilder = (NoopBuilder) SystraceMessage.NOOP_BUILDER;
            try {
                Map<String, Object> createConstantsForViewManager = createConstantsForViewManager(next, null, null, map, map2);
                if (!((HashMap) createConstantsForViewManager).isEmpty()) {
                    ((HashMap) constants).put(name, createConstantsForViewManager);
                }
            }
        }
        HashMap hashMap = (HashMap) constants;
        hashMap.put("genericBubblingEventTypes", bubblingEventTypeConstants);
        hashMap.put("genericDirectEventTypes", directEventTypeConstants);
        return constants;
    }

    public static Map<String, Object> createConstantsForViewManager(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        HashMap hashMap = new HashMap();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            recursiveMerge(map3, exportedCustomBubblingEventTypeConstants);
            recursiveMerge(exportedCustomBubblingEventTypeConstants, null);
            hashMap.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants != null) {
            recursiveMerge(map4, exportedCustomDirectEventTypeConstants);
            recursiveMerge(exportedCustomDirectEventTypeConstants, null);
            hashMap.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            hashMap.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            hashMap.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            hashMap.put("NativeProps", nativeProps);
        }
        return hashMap;
    }

    public static void recursiveMerge(Map map, Map map2) {
        if (map != null && map2 != null && !map2.isEmpty()) {
            for (Object next : map2.keySet()) {
                Object obj = map2.get(next);
                Object obj2 = map.get(next);
                if (obj2 == null || !(obj instanceof Map) || !(obj2 instanceof Map)) {
                    map.put(next, obj);
                } else {
                    recursiveMerge((Map) obj2, (Map) obj);
                }
            }
        }
    }
}
