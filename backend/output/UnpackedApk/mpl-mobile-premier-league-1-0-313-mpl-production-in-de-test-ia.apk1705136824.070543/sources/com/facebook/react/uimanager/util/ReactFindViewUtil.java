package com.facebook.react.uimanager.util;

import android.view.View;
import com.facebook.react.R$id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReactFindViewUtil {
    public static final Map<OnMultipleViewsFoundListener, Set<String>> mOnMultipleViewsFoundListener = new HashMap();
    public static final List<OnViewFoundListener> mOnViewFoundListeners = new ArrayList();

    public interface OnMultipleViewsFoundListener {
        void onViewFound(View view, String str);
    }

    public interface OnViewFoundListener {
        String getNativeId();

        void onViewFound(View view);
    }

    public static void notifyViewRendered(View view) {
        Object tag = view.getTag(R$id.view_tag_native_id);
        String str = tag instanceof String ? (String) tag : null;
        if (str != null) {
            Iterator<OnViewFoundListener> it = mOnViewFoundListeners.iterator();
            while (it.hasNext()) {
                OnViewFoundListener next = it.next();
                if (str.equals(next.getNativeId())) {
                    next.onViewFound(view);
                    it.remove();
                }
            }
            for (Entry next2 : mOnMultipleViewsFoundListener.entrySet()) {
                Set set = (Set) next2.getValue();
                if (set != null && set.contains(str)) {
                    ((OnMultipleViewsFoundListener) next2.getKey()).onViewFound(view, str);
                }
            }
        }
    }
}
