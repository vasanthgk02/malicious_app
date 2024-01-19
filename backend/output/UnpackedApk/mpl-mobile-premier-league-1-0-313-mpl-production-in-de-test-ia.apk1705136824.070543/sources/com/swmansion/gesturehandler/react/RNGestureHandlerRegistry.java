package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0005J\u001c\u0010\u0015\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0005J\u0012\u0010\u0019\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0007J\u001c\u0010\u001a\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00052\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\t0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "()V", "attachedTo", "Landroid/util/SparseArray;", "", "handlers", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlersForView", "Ljava/util/ArrayList;", "attachHandlerToView", "", "handlerTag", "viewTag", "actionType", "detachHandler", "", "handler", "dropAllHandlers", "dropHandler", "getHandler", "getHandlersForView", "view", "Landroid/view/View;", "getHandlersForViewWithTag", "registerHandler", "registerHandlerForViewWithTag", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RNGestureHandlerRegistry.kt */
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    public final SparseArray<Integer> attachedTo = new SparseArray<>();
    public final SparseArray<GestureHandler<?>> handlers = new SparseArray<>();
    public final SparseArray<ArrayList<GestureHandler<?>>> handlersForView = new SparseArray<>();

    /* renamed from: detachHandler$lambda-4  reason: not valid java name */
    public static final void m58detachHandler$lambda4(GestureHandler gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "$handler");
        gestureHandler.cancel();
    }

    public final synchronized boolean attachHandlerToView(int i, int i2, int i3) {
        boolean z;
        try {
            GestureHandler gestureHandler = this.handlers.get(i);
            if (gestureHandler == null) {
                z = false;
            } else {
                Intrinsics.checkNotNullExpressionValue(gestureHandler, "handler");
                detachHandler(gestureHandler);
                gestureHandler.actionType = i3;
                registerHandlerForViewWithTag(i2, gestureHandler);
                z = true;
            }
        }
        return z;
    }

    public final synchronized void detachHandler(GestureHandler<?> gestureHandler) {
        Integer num = this.attachedTo.get(gestureHandler.tag);
        if (num != null) {
            this.attachedTo.remove(gestureHandler.tag);
            ArrayList arrayList = this.handlersForView.get(num.intValue());
            if (arrayList != null) {
                synchronized (arrayList) {
                    arrayList.remove(gestureHandler);
                }
                if (arrayList.size() == 0) {
                    this.handlersForView.remove(num.intValue());
                }
            }
        }
        if (gestureHandler.view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public final void run() {
                    RNGestureHandlerRegistry.m58detachHandler$lambda4(GestureHandler.this);
                }
            });
        }
    }

    public final synchronized void dropHandler(int i) {
        GestureHandler gestureHandler = this.handlers.get(i);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            this.handlers.remove(i);
        }
    }

    public synchronized ArrayList<GestureHandler<?>> getHandlersForView(View view) {
        ArrayList<GestureHandler<?>> arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        synchronized (this) {
            arrayList = this.handlersForView.get(id);
        }
        return arrayList;
    }

    public final synchronized void registerHandler(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        this.handlers.put(gestureHandler.tag, gestureHandler);
    }

    public final synchronized void registerHandlerForViewWithTag(int i, GestureHandler<?> gestureHandler) {
        if (this.attachedTo.get(gestureHandler.tag) == null) {
            this.attachedTo.put(gestureHandler.tag, Integer.valueOf(i));
            ArrayList<GestureHandler<?>> arrayList = this.handlersForView.get(i);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(gestureHandler);
                this.handlersForView.put(i, arrayList2);
            } else {
                synchronized (arrayList) {
                    arrayList.add(gestureHandler);
                }
            }
        } else {
            throw new IllegalStateException(("Handler " + gestureHandler + " already attached").toString());
        }
    }
}
