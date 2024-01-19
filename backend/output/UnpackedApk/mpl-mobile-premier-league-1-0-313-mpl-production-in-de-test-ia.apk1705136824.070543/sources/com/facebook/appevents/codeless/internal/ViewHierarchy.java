package com.facebook.appevents.codeless.internal;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u001e\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0010\u0010.\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001a\u0010/\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u001dH\u0007J \u00101\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0007J\u0018\u00105\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "()V", "CLASS_RCTROOTVIEW", "", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "ICON_MAX_EDGE_LENGTH", "", "METHOD_FIND_TOUCHTARGET_VIEW", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "TAG", "kotlin.jvm.PlatformType", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "findRCTRootView", "view", "getChildrenOfView", "", "getClassTypeBitmask", "getDictionaryOfView", "Lorg/json/JSONObject;", "getDimensionOfView", "getExistingClass", "Ljava/lang/Class;", "className", "getExistingOnClickListener", "Landroid/view/View$OnClickListener;", "getExistingOnTouchListener", "Landroid/view/View$OnTouchListener;", "getHintOfView", "getParentOfView", "Landroid/view/ViewGroup;", "getTextOfView", "getTouchReactView", "location", "", "RCTRootView", "getViewLocationOnScreen", "initTouchTargetHelperMethods", "", "isAdapterViewItem", "", "isRCTButton", "isRCTRootView", "setOnClickListener", "newListener", "updateAppearanceOfView", "json", "displayDensity", "", "updateBasicInfoOfView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewHierarchy.kt */
public final class ViewHierarchy {
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    public static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    public static Method methodFindTouchTargetView;

    public static final List<View> getChildrenOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                int i = 0;
                if (childCount > 0) {
                    while (true) {
                        int i2 = i + 1;
                        arrayList.add(((ViewGroup) view).getChildAt(i));
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (r5.isInstance(r3) != false) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[Catch:{ all -> 0x0052, all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005f A[Catch:{ all -> 0x0052, all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007e A[Catch:{ all -> 0x0052, all -> 0x00b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getClassTypeBitmask(android.view.View r7) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)     // Catch:{ all -> 0x00b0 }
            boolean r1 = r7 instanceof android.widget.ImageView     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0015
            r1 = 2
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            boolean r3 = r7.isClickable()     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x001e
            r1 = r1 | 32
        L_0x001e:
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x00b0 }
            r4 = 1
            if (r3 == 0) goto L_0x0026
            goto L_0x0056
        L_0x0026:
            android.view.ViewParent r3 = r7.getParent()     // Catch:{ all -> 0x0052 }
            boolean r5 = r3 instanceof android.widget.AdapterView     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x002f
            goto L_0x0050
        L_0x002f:
            com.facebook.appevents.codeless.internal.ViewHierarchy r5 = INSTANCE     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "android.support.v4.view.NestedScrollingChild"
            java.lang.Class r5 = r5.getExistingClass(r6)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0040
            boolean r5 = r5.isInstance(r3)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0040
            goto L_0x0050
        L_0x0040:
            com.facebook.appevents.codeless.internal.ViewHierarchy r5 = INSTANCE     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "androidx.core.view.NestedScrollingChild"
            java.lang.Class r5 = r5.getExistingClass(r6)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0056
            boolean r3 = r5.isInstance(r3)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0056
        L_0x0050:
            r3 = 1
            goto L_0x0057
        L_0x0052:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0)     // Catch:{ all -> 0x00b0 }
        L_0x0056:
            r3 = 0
        L_0x0057:
            if (r3 == 0) goto L_0x005b
            r1 = r1 | 512(0x200, float:7.17E-43)
        L_0x005b:
            boolean r3 = r7 instanceof android.widget.TextView     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x007e
            r1 = r1 | 1024(0x400, float:1.435E-42)
            r1 = r1 | r4
            boolean r3 = r7 instanceof android.widget.Button     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0077
            r1 = r1 | 4
            boolean r3 = r7 instanceof android.widget.Switch     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x006f
            r1 = r1 | 8192(0x2000, float:1.148E-41)
            goto L_0x0077
        L_0x006f:
            boolean r3 = r7 instanceof android.widget.CheckBox     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0077
            r3 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 | r3
        L_0x0077:
            boolean r7 = r7 instanceof android.widget.EditText     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x00af
            r1 = r1 | 2048(0x800, float:2.87E-42)
            goto L_0x00af
        L_0x007e:
            boolean r3 = r7 instanceof android.widget.Spinner     // Catch:{ all -> 0x00b0 }
            if (r3 != 0) goto L_0x00ad
            boolean r3 = r7 instanceof android.widget.DatePicker     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0087
            goto L_0x00ad
        L_0x0087:
            boolean r3 = r7 instanceof android.widget.RatingBar     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x008f
            r7 = 65536(0x10000, float:9.1835E-41)
            r1 = r1 | r7
            goto L_0x00af
        L_0x008f:
            boolean r3 = r7 instanceof android.widget.RadioGroup     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0096
            r1 = r1 | 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x0096:
            boolean r3 = r7 instanceof android.view.ViewGroup     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x00af
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = INSTANCE     // Catch:{ all -> 0x00b0 }
            java.lang.ref.WeakReference<android.view.View> r4 = RCTRootViewReference     // Catch:{ all -> 0x00b0 }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x00b0 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ all -> 0x00b0 }
            boolean r7 = r3.isRCTButton(r7, r4)     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x00af
            r1 = r1 | 64
            goto L_0x00af
        L_0x00ad:
            r1 = r1 | 4096(0x1000, float:5.74E-42)
        L_0x00af:
            return r1
        L_0x00b0:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getClassTypeBitmask(android.view.View):int");
    }

    public static final JSONObject getDictionaryOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(view.getClass().getName(), "com.facebook.react.ReactRootView")) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                int i = 0;
                int size = childrenOfView.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                jSONObject.put("childviews", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final OnClickListener getExistingOnClickListener(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        OnClickListener onClickListener = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 != null) {
                    onClickListener = (OnClickListener) obj2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
                }
            }
            return onClickListener;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final OnTouchListener getExistingOnTouchListener(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        OnTouchListener onTouchListener = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 != null) {
                    onTouchListener = (OnTouchListener) obj2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
                }
            }
            return onTouchListener;
        } catch (NoSuchFieldException e2) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
        } catch (ClassNotFoundException e3) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e3);
        } catch (IllegalAccessException e4) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e4);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r3 == null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getHintOfView(android.view.View r3) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = r3 instanceof android.widget.EditText     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0015
            android.widget.EditText r3 = (android.widget.EditText) r3     // Catch:{ all -> 0x002d }
            java.lang.CharSequence r3 = r3.getHint()     // Catch:{ all -> 0x002d }
            goto L_0x0021
        L_0x0015:
            boolean r1 = r3 instanceof android.widget.TextView     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0020
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x002d }
            java.lang.CharSequence r3 = r3.getHint()     // Catch:{ all -> 0x002d }
            goto L_0x0021
        L_0x0020:
            r3 = r2
        L_0x0021:
            if (r3 != 0) goto L_0x0024
            goto L_0x002a
        L_0x0024:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002c
        L_0x002a:
            java.lang.String r3 = ""
        L_0x002c:
            return r3
        L_0x002d:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(android.view.View):java.lang.String");
    }

    public static final ViewGroup getParentOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        ViewGroup viewGroup = null;
        if (CrashShieldHandler.isObjectCrashing(cls) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            return viewGroup;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getTextOfView(View view) {
        Object obj;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                obj = ((TextView) view).getText();
                if (view instanceof Switch) {
                    obj = ((Switch) view).isChecked() ? "1" : "0";
                }
            } else {
                if (!(view instanceof Spinner)) {
                    int i = 0;
                    if (view instanceof DatePicker) {
                        obj = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(((DatePicker) view).getYear()), Integer.valueOf(((DatePicker) view).getMonth()), Integer.valueOf(((DatePicker) view).getDayOfMonth())}, 3));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof TimePicker) {
                        Integer currentHour = ((TimePicker) view).getCurrentHour();
                        Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                        int intValue = currentHour.intValue();
                        Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                        Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                        obj = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(currentMinute.intValue())}, 2));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof RadioGroup) {
                        int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                        int childCount = ((RadioGroup) view).getChildCount();
                        if (childCount > 0) {
                            while (true) {
                                int i2 = i + 1;
                                View childAt = ((RadioGroup) view).getChildAt(i);
                                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                    obj = ((RadioButton) childAt).getText();
                                    break;
                                } else if (i2 >= childCount) {
                                    break;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                    } else if (view instanceof RatingBar) {
                        obj = String.valueOf(((RatingBar) view).getRating());
                    }
                } else if (((Spinner) view).getCount() > 0) {
                    Object selectedItem = ((Spinner) view).getSelectedItem();
                    if (selectedItem != null) {
                        obj = selectedItem.toString();
                    }
                }
                obj = null;
            }
            String str = "";
            if (obj != null) {
                String obj2 = obj.toString();
                if (obj2 != null) {
                    str = obj2;
                }
            }
            return str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put("classname", view.getClass().getCanonicalName());
                jSONObject.put("classtypebitmask", getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", "");
                    jSONObject.put("is_user_input", true);
                }
                jSONObject.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    jSONObject.put(InlineAnimation.TAG, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put("dimension", INSTANCE.getDimensionOfView(view));
            } catch (JSONException e2) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, view.getTop());
                jSONObject.put(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
                jSONObject.put("scrollx", view.getScrollX());
                jSONObject.put("scrolly", view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException unused) {
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Class<?> getExistingClass(String str) {
        Class<?> cls = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
        return cls;
    }

    public final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            if (!(methodFindTouchTargetView == null || view == null)) {
                Method method = methodFindTouchTargetView;
                if (method != null) {
                    Object invoke = method.invoke(null, new Object[]{fArr, view});
                    if (invoke != null) {
                        View view2 = (View) invoke;
                        if (view2.getId() > 0) {
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                return (View) parent;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        } catch (IllegalAccessException e2) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
        } catch (InvocationTargetException e3) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
        return null;
    }

    public final void initTouchTargetHelperMethods() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (methodFindTouchTargetView == null) {
                    Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", new Class[]{float[].class, ViewGroup.class});
                    methodFindTouchTargetView = declaredMethod;
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } catch (ClassNotFoundException e2) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
            } catch (NoSuchMethodException e3) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final boolean isRCTButton(View view, View view2) {
        boolean z = false;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(view.getClass().getName(), "com.facebook.react.views.view.ReactViewGroup")) {
                float[] fArr = null;
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    fArr = new float[]{(float) iArr[0], (float) iArr[1]};
                }
                View touchReactView = getTouchReactView(fArr, view2);
                if (touchReactView != null && touchReactView.getId() == view.getId()) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
        return z;
    }
}
