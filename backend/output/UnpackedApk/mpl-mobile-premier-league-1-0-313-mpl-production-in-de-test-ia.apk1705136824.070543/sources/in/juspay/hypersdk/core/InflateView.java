package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.PopupMenu;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.mystique.AnimationHolder;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import in.juspay.hypersdk.mystique.ListAdapter.CacheHolder;
import in.juspay.hypersdk.mystique.ListAdapter.ViewHolder;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class InflateView {
    public static final String ARG_TYPE_SPLIT = "_";
    public static final Pattern COMMAND_SPLIT;
    public static final String FUNCTION_ARG_SPLIT = ",";
    public static final Pattern FUNCTION_ARG_SPLIT_ESCAPE;
    public static final String FUNCTION_ARG_START = ":";
    public static final String KEYWORD_SPLIT = "->";
    public static final String LOG_TAG = "in.juspay.hypersdk.core.InflateView";
    public static final Map<Class<?>, Class<?>> PRIMITIVE_TYPES = new Hashtable();
    public static final String SETTER_EQUALS = "=";
    public AnimationHolder animationHolder;
    public String currView = "";
    public String currViewId = "-1";
    public final DuiCallback duiCallback;
    public DynamicUI dynamicUI;
    public String fileOrigin = "";
    public final HashMap<Cmd, Method> functionCache = new HashMap<>();
    public String lastCommand = "";
    public PopupMenu popUpMenu;
    public HashMap<String, Object> state = new HashMap<>();
    public float swipeEndX;
    public float swipeEndY;
    public float swipeStartX;
    public float swipeStartY;
    public boolean useAppContext = false;

    public static class Cmd {
        public Class<?>[] args;
        public Class<?> clazz;
        public String functionName;

        public Cmd(Class<?> cls, String str, Class<?>[] clsArr) {
            this.clazz = cls;
            this.functionName = str;
            this.args = clsArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Cmd.class != obj.getClass()) {
                return false;
            }
            Cmd cmd = (Cmd) obj;
            if (this.clazz.equals(cmd.clazz) && this.functionName.equals(cmd.functionName)) {
                return Arrays.equals(this.args, cmd.args);
            }
            return false;
        }

        public int hashCode() {
            int outline11 = GeneratedOutlineSupport.outline11(this.functionName, this.clazz.hashCode() * 31, 31);
            Class<?>[] clsArr = this.args;
            return outline11 + (clsArr != null ? Arrays.hashCode(clsArr) : 0);
        }
    }

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(?<!\\\\)");
        outline73.append(Pattern.quote(","));
        FUNCTION_ARG_SPLIT_ESCAPE = Pattern.compile(outline73.toString());
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("(?<!\\\\)");
        outline732.append(Pattern.quote(";"));
        COMMAND_SPLIT = Pattern.compile(outline732.toString());
        PRIMITIVE_TYPES.put(Boolean.class, Boolean.TYPE);
        PRIMITIVE_TYPES.put(Character.class, Character.TYPE);
        PRIMITIVE_TYPES.put(Byte.class, Byte.TYPE);
        PRIMITIVE_TYPES.put(Short.class, Short.TYPE);
        PRIMITIVE_TYPES.put(Integer.class, Integer.TYPE);
        PRIMITIVE_TYPES.put(Long.class, Long.TYPE);
        PRIMITIVE_TYPES.put(Float.class, Float.TYPE);
        PRIMITIVE_TYPES.put(Double.class, Double.TYPE);
        PRIMITIVE_TYPES.put(Void.class, Void.TYPE);
    }

    public InflateView(final DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
        this.duiCallback = new DuiCallback() {
            public void addJsToWebView(String str) {
                dynamicUI2.addJsToWebView(str);
            }

            public InflateView getInflateView() {
                return dynamicUI2.getInflateView();
            }

            public DuiLogger getLogger() {
                return dynamicUI2.getLogger();
            }
        };
        this.state.put("duiObj", dynamicUI2);
        this.animationHolder = new AnimationHolder(this.duiCallback, dynamicUI2.getAppContext().getResources().getDisplayMetrics().density);
    }

    private Object findAndSetField(Object obj, String str, String str2, boolean z) {
        Field field;
        try {
            field = obj.getClass().getField(str);
        } catch (NoSuchFieldException unused) {
            Field field2 = null;
            for (Field field3 : obj.getClass().getFields()) {
                if (field3.getName().equals(str)) {
                    field2 = field3;
                }
            }
            field = field2;
        }
        if (field != null) {
            field.set(obj, getValue(str2, z));
        } else {
            this.dynamicUI.getLogger().d(LOG_TAG, "Couldn't set field for " + str);
        }
        return obj;
    }

    private Method findMethodInClass(Class<?> cls, String str) {
        String str2;
        String str3;
        Method method;
        Class[] clsArr = null;
        if (cls == null) {
            return null;
        }
        if (indexOf(str, ":", 0) != -1) {
            String[] substr = substr(str, ":");
            str3 = substr[0];
            str2 = substr[1];
        } else {
            str3 = str;
            str2 = null;
        }
        if (str2 != null) {
            clsArr = parseTypeArguments(str2);
        }
        Cmd cmd = new Cmd(cls, str3, clsArr);
        if (this.functionCache.containsKey(cmd)) {
            return this.functionCache.get(cmd);
        }
        try {
            method = tryExactMatch(cls, str3, clsArr);
        } catch (NoSuchMethodException unused) {
            method = (clsArr == null || clsArr.length != 1) ? tryMultiAgrumentDeepMatch(cls, str3, clsArr) : trySingleArgumentDeepMatch(cls, str3, clsArr[0]);
        }
        this.functionCache.put(cmd, method);
        return method;
    }

    private ObjectAnimator getAnimator(Object obj, PropertyValuesHolder[] propertyValuesHolderArr, JSONObject jSONObject) {
        float f2 = 0.0f;
        float f3 = jSONObject.has(InlineAnimation.DURATION) ? (float) jSONObject.getDouble(InlineAnimation.DURATION) : 0.0f;
        if (jSONObject.has(InlineAnimation.DELAY)) {
            f2 = (float) jSONObject.getDouble(InlineAnimation.DELAY);
        }
        boolean z = false;
        int i = jSONObject.has(InlineAnimation.REPEAT_COUNT) ? jSONObject.getInt(InlineAnimation.REPEAT_COUNT) : 0;
        if (jSONObject.has("startImmediate") && jSONObject.getBoolean("startImmediate")) {
            z = true;
        }
        String string = jSONObject.has("easing") ? jSONObject.getString("easing") : "linear";
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration((long) f3);
        ofPropertyValuesHolder.setStartDelay((long) f2);
        ofPropertyValuesHolder.setRepeatCount(i);
        ofPropertyValuesHolder.setInterpolator(getEasing(string));
        if (z) {
            ofPropertyValuesHolder.start();
        }
        return ofPropertyValuesHolder;
    }

    private int getArgsLength(String str) {
        return FUNCTION_ARG_SPLIT_ESCAPE.split(str).length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        if (r4.equals("i") != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f8, code lost:
        return java.lang.Float.TYPE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010a, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Any> Any getClassType(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "WARNING"
            if (r10 == 0) goto L_0x0140
            java.lang.String r2 = "_"
            java.lang.String[] r2 = r9.substr(r10, r2)
            r3 = 0
            r4 = r2[r3]
            int r5 = r4.hashCode()
            r6 = 1
            switch(r5) {
                case -891988091: goto L_0x0099;
                case 98: goto L_0x008f;
                case 102: goto L_0x0085;
                case 105: goto L_0x007c;
                case 108: goto L_0x0072;
                case 115: goto L_0x0067;
                case 3184: goto L_0x005d;
                case 3212: goto L_0x0053;
                case 3677: goto L_0x0048;
                case 98855: goto L_0x003d;
                case 99674: goto L_0x0031;
                case 102230: goto L_0x0025;
                case 3392903: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x00a4
        L_0x0019:
            java.lang.String r3 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 12
            goto L_0x00a5
        L_0x0025:
            java.lang.String r3 = "get"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 8
            goto L_0x00a5
        L_0x0031:
            java.lang.String r3 = "dpf"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 9
            goto L_0x00a5
        L_0x003d:
            java.lang.String r3 = "ctx"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 10
            goto L_0x00a5
        L_0x0048:
            java.lang.String r3 = "sp"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 6
            goto L_0x00a5
        L_0x0053:
            java.lang.String r3 = "dp"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 1
            goto L_0x00a5
        L_0x005d:
            java.lang.String r3 = "cs"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 3
            goto L_0x00a5
        L_0x0067:
            java.lang.String r3 = "s"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 11
            goto L_0x00a5
        L_0x0072:
            java.lang.String r3 = "l"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 7
            goto L_0x00a5
        L_0x007c:
            java.lang.String r5 = "i"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00a4
            goto L_0x00a5
        L_0x0085:
            java.lang.String r3 = "f"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 5
            goto L_0x00a5
        L_0x008f:
            java.lang.String r3 = "b"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 2
            goto L_0x00a5
        L_0x0099:
            java.lang.String r3 = "strget"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a4
            r3 = 4
            goto L_0x00a5
        L_0x00a4:
            r3 = -1
        L_0x00a5:
            java.lang.String r5 = " "
            switch(r3) {
                case 0: goto L_0x0108;
                case 1: goto L_0x0108;
                case 2: goto L_0x0105;
                case 3: goto L_0x0102;
                case 4: goto L_0x0102;
                case 5: goto L_0x00ff;
                case 6: goto L_0x00fc;
                case 7: goto L_0x00f9;
                case 8: goto L_0x00b5;
                case 9: goto L_0x00f6;
                case 10: goto L_0x00b2;
                case 11: goto L_0x00b1;
                case 12: goto L_0x00af;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            java.lang.Class r10 = r9.getClassName(r4)     // Catch:{ ClassNotFoundException -> 0x010b }
            goto L_0x010a
        L_0x00af:
            r10 = 0
            return r10
        L_0x00b1:
            return r0
        L_0x00b2:
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            return r10
        L_0x00b5:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r9.state
            r2 = r2[r6]
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x00c4
            java.lang.Class r10 = r0.getClass()
            return r10
        L_0x00c4:
            in.juspay.hypersdk.core.DynamicUI r0 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()
            java.lang.String r2 = " isNull : fn__getClassType - "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r10, r5)
            java.lang.String r4 = r9.getErrorDetails()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.e(r1, r3)
            in.juspay.hypersdk.core.DynamicUI r0 = r9.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r0 = r0.getErrorCallback()
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r10, r5)
            java.lang.String r2 = r9.getErrorDetails()
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r0.onError(r1, r10)
        L_0x00f6:
            java.lang.Class r10 = java.lang.Float.TYPE
            return r10
        L_0x00f9:
            java.lang.Class r10 = java.lang.Long.TYPE
            return r10
        L_0x00fc:
            java.lang.Class<java.lang.Float> r10 = java.lang.Float.class
            return r10
        L_0x00ff:
            java.lang.Class r10 = java.lang.Float.TYPE
            return r10
        L_0x0102:
            java.lang.Class<java.lang.CharSequence> r10 = java.lang.CharSequence.class
            return r10
        L_0x0105:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            return r10
        L_0x0108:
            java.lang.Class r10 = java.lang.Integer.TYPE
        L_0x010a:
            return r10
        L_0x010b:
            in.juspay.hypersdk.core.DynamicUI r2 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r2 = r2.getLogger()
            java.lang.String r3 = " no class with name "
            java.lang.String r6 = " : fn__getClassType - "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline82(r3, r4, r6, r10, r5)
            java.lang.String r8 = r9.getErrorDetails()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r2.e(r1, r7)
            in.juspay.hypersdk.core.DynamicUI r2 = r9.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r2 = r2.getErrorCallback()
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline82(r3, r4, r6, r10, r5)
            java.lang.String r3 = r9.getErrorDetails()
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            r2.onError(r1, r10)
            goto L_0x0172
        L_0x0140:
            in.juspay.hypersdk.core.DynamicUI r10 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r10 = r10.getLogger()
            java.lang.String r2 = " isNull : fn__getClassType -  toConvert "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r4 = r9.getErrorDetails()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r10.e(r1, r3)
            in.juspay.hypersdk.core.DynamicUI r10 = r9.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r10 = r10.getErrorCallback()
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r9.getErrorDetails()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r10.onError(r1, r2)
        L_0x0172:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getClassType(java.lang.String):java.lang.Object");
    }

    private Context getContext() {
        return this.useAppContext ? this.dynamicUI.getAppContext() : this.dynamicUI.getActivity();
    }

    private TimeInterpolator getCustomEasing(String str, final float[] fArr) {
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1392296225) {
            if (hashCode == -895679987 && str.equals("spring")) {
                c2 = 1;
            }
        } else if (str.equals("bezier")) {
            c2 = 0;
        }
        return c2 != 0 ? c2 != 1 ? new LinearInterpolator() : new TimeInterpolator() {
            public float getInterpolation(float f2) {
                double pow = Math.pow(2.0d, (double) (-10.0f * f2));
                float[] fArr = fArr;
                return ((float) (Math.sin((6.283185307179586d / ((double) fArr[0])) * ((double) (f2 - (fArr[0] / 4.0f)))) * pow)) + 1.0f;
            }
        } : new PathInterpolator(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.animation.TimeInterpolator getEasing(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "["
            int r1 = r8.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            switch(r1) {
                case -1965120668: goto L_0x0037;
                case -1383205240: goto L_0x002d;
                case -1102672091: goto L_0x0023;
                case -789192465: goto L_0x0019;
                case -361990811: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0041
        L_0x000f:
            java.lang.String r1 = "ease-in-out"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = 2
            goto L_0x0042
        L_0x0019:
            java.lang.String r1 = "ease-out"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = 1
            goto L_0x0042
        L_0x0023:
            java.lang.String r1 = "linear"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = 4
            goto L_0x0042
        L_0x002d:
            java.lang.String r1 = "bounce"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = 3
            goto L_0x0042
        L_0x0037:
            java.lang.String r1 = "ease-in"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = 0
            goto L_0x0042
        L_0x0041:
            r1 = -1
        L_0x0042:
            if (r1 == 0) goto L_0x00a0
            if (r1 == r6) goto L_0x009a
            if (r1 == r4) goto L_0x0094
            if (r1 == r3) goto L_0x008e
            if (r1 == r2) goto L_0x0088
            boolean r1 = r8.contains(r0)     // Catch:{ JSONException -> 0x007e }
            if (r1 == 0) goto L_0x0082
            int r1 = r8.indexOf(r0)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r1 = r8.substring(r5, r1)     // Catch:{ JSONException -> 0x007e }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007e }
            int r0 = r8.indexOf(r0)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r8 = r8.substring(r0)     // Catch:{ JSONException -> 0x007e }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x007e }
            int r8 = r2.length()     // Catch:{ JSONException -> 0x007e }
            float[] r0 = new float[r8]     // Catch:{ JSONException -> 0x007e }
        L_0x006d:
            if (r5 >= r8) goto L_0x0079
            double r3 = r2.getDouble(r5)     // Catch:{ JSONException -> 0x007e }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x007e }
            r0[r5] = r3     // Catch:{ JSONException -> 0x007e }
            int r5 = r5 + 1
            goto L_0x006d
        L_0x0079:
            android.animation.TimeInterpolator r8 = r7.getCustomEasing(r1, r0)     // Catch:{ JSONException -> 0x007e }
            return r8
        L_0x007e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0082:
            android.view.animation.LinearInterpolator r8 = new android.view.animation.LinearInterpolator
            r8.<init>()
            return r8
        L_0x0088:
            android.view.animation.LinearInterpolator r8 = new android.view.animation.LinearInterpolator
            r8.<init>()
            return r8
        L_0x008e:
            android.view.animation.BounceInterpolator r8 = new android.view.animation.BounceInterpolator
            r8.<init>()
            return r8
        L_0x0094:
            android.view.animation.AccelerateDecelerateInterpolator r8 = new android.view.animation.AccelerateDecelerateInterpolator
            r8.<init>()
            return r8
        L_0x009a:
            android.view.animation.DecelerateInterpolator r8 = new android.view.animation.DecelerateInterpolator
            r8.<init>()
            return r8
        L_0x00a0:
            android.view.animation.AccelerateInterpolator r8 = new android.view.animation.AccelerateInterpolator
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getEasing(java.lang.String):android.animation.TimeInterpolator");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e4, code lost:
        if (r3.equals("i") != false) goto L_0x0108;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Any> Any getValue(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x01c4
            in.juspay.hypersdk.core.DynamicUI r1 = r8.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = "getValue!"
            r1.d(r2, r9)
            java.lang.String r1 = "_"
            java.lang.String[] r9 = r8.substr(r9, r1)
            r2 = 0
            r3 = r9[r2]
            r4 = 1
            r9 = r9[r4]
            r4 = 92
            int r5 = r9.indexOf(r4)
            r6 = -1
            if (r5 == r6) goto L_0x0031
            java.lang.String r5 = ";"
            boolean r7 = r9.contains(r5)
            if (r7 == 0) goto L_0x0031
            java.lang.String r7 = "\\\\;"
            java.lang.String r9 = r9.replace(r7, r5)
        L_0x0031:
            int r5 = r9.indexOf(r4)
            if (r5 == r6) goto L_0x0043
            boolean r5 = r9.contains(r1)
            if (r5 == 0) goto L_0x0043
            java.lang.String r5 = "\\\\_"
            java.lang.String r9 = r9.replace(r5, r1)
        L_0x0043:
            int r1 = r9.indexOf(r4)
            if (r1 == r6) goto L_0x0057
            java.lang.String r1 = ":"
            boolean r5 = r9.contains(r1)
            if (r5 == 0) goto L_0x0057
            java.lang.String r5 = "\\\\:"
            java.lang.String r9 = r9.replace(r5, r1)
        L_0x0057:
            int r1 = r9.indexOf(r4)
            if (r1 == r6) goto L_0x006b
            java.lang.String r1 = ","
            boolean r5 = r9.contains(r1)
            if (r5 == 0) goto L_0x006b
            java.lang.String r5 = "\\\\,"
            java.lang.String r9 = r9.replace(r5, r1)
        L_0x006b:
            int r1 = r9.indexOf(r4)
            if (r1 == r6) goto L_0x007f
            java.lang.String r1 = "="
            boolean r4 = r9.contains(r1)
            if (r4 == 0) goto L_0x007f
            java.lang.String r4 = "\\\\="
            java.lang.String r9 = r9.replace(r4, r1)
        L_0x007f:
            int r1 = r3.hashCode()
            switch(r1) {
                case -891988091: goto L_0x00fb;
                case 98: goto L_0x00f1;
                case 102: goto L_0x00e7;
                case 105: goto L_0x00de;
                case 108: goto L_0x00d4;
                case 115: goto L_0x00ca;
                case 3212: goto L_0x00c0;
                case 3677: goto L_0x00b5;
                case 98855: goto L_0x00aa;
                case 99674: goto L_0x00a0;
                case 102230: goto L_0x0094;
                case 3392903: goto L_0x0088;
                default: goto L_0x0086;
            }
        L_0x0086:
            goto L_0x0107
        L_0x0088:
            java.lang.String r1 = "null"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 10
            goto L_0x0108
        L_0x0094:
            java.lang.String r1 = "get"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 8
            goto L_0x0108
        L_0x00a0:
            java.lang.String r1 = "dpf"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 6
            goto L_0x0108
        L_0x00aa:
            java.lang.String r1 = "ctx"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 9
            goto L_0x0108
        L_0x00b5:
            java.lang.String r1 = "sp"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 4
            goto L_0x0108
        L_0x00c0:
            java.lang.String r1 = "dp"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 5
            goto L_0x0108
        L_0x00ca:
            java.lang.String r1 = "s"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 3
            goto L_0x0108
        L_0x00d4:
            java.lang.String r1 = "l"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 7
            goto L_0x0108
        L_0x00de:
            java.lang.String r1 = "i"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            goto L_0x0108
        L_0x00e7:
            java.lang.String r1 = "f"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 2
            goto L_0x0108
        L_0x00f1:
            java.lang.String r1 = "b"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 1
            goto L_0x0108
        L_0x00fb:
            java.lang.String r1 = "strget"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0107
            r2 = 11
            goto L_0x0108
        L_0x0107:
            r2 = -1
        L_0x0108:
            java.lang.String r1 = "Missing Activity"
            switch(r2) {
                case 0: goto L_0x01bb;
                case 1: goto L_0x01b2;
                case 2: goto L_0x01a9;
                case 3: goto L_0x01a8;
                case 4: goto L_0x0179;
                case 5: goto L_0x016c;
                case 6: goto L_0x015f;
                case 7: goto L_0x0156;
                case 8: goto L_0x014f;
                case 9: goto L_0x0129;
                case 10: goto L_0x0128;
                case 11: goto L_0x0110;
                default: goto L_0x010d;
            }
        L_0x010d:
            r0 = r9
            goto L_0x01f8
        L_0x0110:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r8.state
            java.lang.Object r9 = r0.get(r9)
            r10.append(r9)
            java.lang.String r9 = ""
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            return r9
        L_0x0128:
            return r0
        L_0x0129:
            if (r10 == 0) goto L_0x0132
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            android.content.Context r9 = r9.getAppContext()
            return r9
        L_0x0132:
            android.content.Context r9 = r8.getContext()
            if (r9 == 0) goto L_0x013d
            android.content.Context r9 = r8.getContext()
            return r9
        L_0x013d:
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r9 = r9.getLogger()
            java.lang.String r10 = "getValue ctx, it is not  activity, it is applicationContext"
            r9.e(r1, r10)
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            android.content.Context r9 = r9.getAppContext()
            return r9
        L_0x014f:
            java.util.HashMap<java.lang.String, java.lang.Object> r10 = r8.state
            java.lang.Object r9 = r10.get(r9)
            return r9
        L_0x0156:
            long r9 = java.lang.Long.parseLong(r9)
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            return r9
        L_0x015f:
            float r9 = java.lang.Float.parseFloat(r9)
            float r9 = r8.dpToPx(r9)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            return r9
        L_0x016c:
            int r9 = java.lang.Integer.parseInt(r9)
            int r9 = r8.dpToPx(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0179:
            in.juspay.hypersdk.core.DynamicUI r10 = r8.dynamicUI
            android.content.Context r10 = r10.getAppContext()
            if (r10 == 0) goto L_0x019c
            float r9 = java.lang.Float.parseFloat(r9)
            in.juspay.hypersdk.core.DynamicUI r10 = r8.dynamicUI
            android.content.Context r10 = r10.getAppContext()
            android.content.res.Resources r10 = r10.getResources()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            float r10 = r10.scaledDensity
            float r9 = r9 * r10
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            return r9
        L_0x019c:
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r9 = r9.getLogger()
            java.lang.String r10 = "getValue sp, it is not  activity, it is applicationContext"
            r9.e(r1, r10)
            return r0
        L_0x01a8:
            return r9
        L_0x01a9:
            float r9 = java.lang.Float.parseFloat(r9)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            return r9
        L_0x01b2:
            boolean r9 = java.lang.Boolean.parseBoolean(r9)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        L_0x01bb:
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x01c4:
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r9 = r9.getLogger()
            java.lang.String r10 = " isNull : fn__getValue - value "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            java.lang.String r2 = r8.getErrorDetails()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "WARNING"
            r9.e(r2, r1)
            in.juspay.hypersdk.core.DynamicUI r9 = r8.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r9 = r9.getErrorCallback()
            java.lang.StringBuilder r10 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            java.lang.String r1 = r8.getErrorDetails()
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            r9.onError(r2, r10)
        L_0x01f8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getValue(java.lang.String, boolean):java.lang.Object");
    }

    private int indexOf(String str, String str2, int i) {
        int indexOf = str.substring(i).indexOf(str2);
        if (!(indexOf == -1 || indexOf == 0 || indexOf >= str.length())) {
            int i2 = indexOf + i;
            if (str.charAt(i2 - 1) == '\\') {
                return indexOf(str, str2, str2.length() + i2);
            }
        }
        return indexOf == -1 ? indexOf : indexOf + i;
    }

    public static boolean isWrappedPrimitiveType(Class<?> cls) {
        return PRIMITIVE_TYPES.containsKey(cls);
    }

    private boolean matchTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!(clsArr2[i] == null || clsArr[i] == null || ((clsArr[i].equals(Object.class) && !clsArr2[i].isPrimitive()) || clsArr[i].equals(clsArr2[i])))) {
                if (clsArr[i].isPrimitive() && !clsArr2[i].isArray()) {
                    try {
                        if (!((Class) clsArr2[i].getField("TYPE").get(null)).equals(clsArr[i])) {
                            return false;
                        }
                    } catch (NoSuchFieldException unused) {
                        return false;
                    } catch (Exception unused2) {
                        return true;
                    }
                } else if (clsArr[i].equals(ClassLoader.class)) {
                    if (clsArr2[i].getName().equals("dalvik.system.PathClassLoader")) {
                        return true;
                    }
                } else if (!clsArr[i].equals(clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void normalTextChange(JSONObject jSONObject, Object obj) {
        Method method = obj.getClass().getMethod("addTextChangedListener", new Class[]{TextWatcher.class});
        final String string = jSONObject.getString("onChange");
        method.invoke(obj, new Object[]{new TextWatcher() {
            public String previousText;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.previousText = charSequence.toString();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!this.previousText.equals(charSequence.toString())) {
                    DynamicUI access$000 = InflateView.this.dynamicUI;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                    outline73.append(string);
                    outline73.append("', '");
                    outline73.append(charSequence);
                    outline73.append("');");
                    access$000.addJsToWebView(outline73.toString());
                }
            }
        }});
    }

    private Object[] parseArguments(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("_");
        if (indexOf(str, ",", 0) == -1 || split.length == 2) {
            arrayList.add(getValue(str, z));
        } else {
            for (String value : FUNCTION_ARG_SPLIT_ESCAPE.split(str)) {
                arrayList.add(getValue(value, z));
            }
        }
        return arrayList.toArray();
    }

    private Class<?>[] parseTypeArguments(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("_");
        if (!(indexOf(str, ",", 0) == -1 || split.length == 2)) {
            String[] split2 = FUNCTION_ARG_SPLIT_ESCAPE.split(str);
            if (split2.length > 1) {
                Class<?>[] clsArr = new Class[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    clsArr[i] = (Class) getClassType(split2[i]);
                }
                return clsArr;
            }
        }
        return new Class[]{(Class) getClassType(str)};
    }

    private Object runCommand(Object obj, Object obj2, String str, boolean z) {
        return runCommand(obj, obj2, str, z, new CacheHolder());
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object runCommand(java.lang.Object r17, java.lang.Object r18, java.lang.String r19, boolean r20, in.juspay.hypersdk.mystique.ListAdapter.CacheHolder r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r0.lastCommand = r3
            java.lang.String r6 = "->"
            r7 = 0
            int r8 = r0.indexOf(r3, r6, r7)
            r9 = -1
            java.lang.String r10 = ":"
            if (r8 == r9) goto L_0x0485
            java.lang.String[] r8 = r0.substr(r3, r6)
            r8 = r8[r7]
            java.lang.String r11 = "_"
            int r12 = r0.indexOf(r8, r11, r7)
            java.lang.String r13 = "get"
            r14 = 3
            if (r12 == r9) goto L_0x003f
            java.lang.String r12 = r8.substring(r7, r14)
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x003f
            java.lang.String[] r8 = r0.substr(r8, r11)
            r12 = 1
            r14 = r8[r12]
            r8 = r8[r7]
            goto L_0x0041
        L_0x003f:
            r12 = 1
            r14 = 0
        L_0x0041:
            int r15 = r0.indexOf(r3, r10, r7)
            java.lang.String[] r3 = r0.substr(r3, r6)
            if (r15 == r9) goto L_0x0056
            r3 = r3[r12]
            java.lang.String[] r6 = r0.substr(r3, r10)
            r7 = r6[r7]
            r6 = r6[r12]
            goto L_0x005a
        L_0x0056:
            r3 = r3[r12]
            r6 = 0
            r7 = r3
        L_0x005a:
            r5.setKey(r8)
            int r9 = r8.hashCode()
            r12 = 2
            switch(r9) {
                case -995424086: goto L_0x008d;
                case 98855: goto L_0x0083;
                case 102230: goto L_0x007b;
                case 3237035: goto L_0x0071;
                case 3559070: goto L_0x0066;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x0097
        L_0x0066:
            java.lang.String r9 = "this"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0097
            r9 = 1
            goto L_0x0098
        L_0x0071:
            java.lang.String r9 = "infl"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0097
            r9 = 0
            goto L_0x0098
        L_0x007b:
            boolean r9 = r8.equals(r13)
            if (r9 == 0) goto L_0x0097
            r9 = 4
            goto L_0x0098
        L_0x0083:
            java.lang.String r9 = "ctx"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0097
            r9 = 3
            goto L_0x0098
        L_0x008d:
            java.lang.String r9 = "parent"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0097
            r9 = 2
            goto L_0x0098
        L_0x0097:
            r9 = -1
        L_0x0098:
            java.lang.String r13 = " "
            java.lang.String r15 = "WARNING"
            if (r9 == 0) goto L_0x03f8
            r2 = 1
            if (r9 == r2) goto L_0x0384
            if (r9 == r12) goto L_0x0312
            r1 = 3
            if (r9 == r1) goto L_0x0259
            r1 = 4
            if (r9 == r1) goto L_0x0180
            java.lang.String r1 = "var_"
            r9 = 0
            int r1 = r0.indexOf(r7, r1, r9)
            r9 = -1
            if (r1 == r9) goto L_0x00d5
            java.lang.String[] r1 = r0.substr(r7, r11)
            r1 = r1[r2]
            java.lang.Class r5 = r0.getClassName(r7)
            java.lang.reflect.Field r1 = r5.getDeclaredField(r1)
            r1.setAccessible(r2)
            java.lang.String[] r3 = r0.substr(r3, r10)
            r2 = r3[r2]
            java.lang.Object r2 = r0.getValue(r2, r4)
            r3 = 0
            r1.set(r3, r2)
            goto L_0x0482
        L_0x00d5:
            java.lang.String r1 = "new"
            boolean r2 = r3.equals(r1)
            if (r2 != 0) goto L_0x0124
            java.lang.String[] r2 = r0.substr(r3, r10)
            r7 = 0
            r2 = r2[r7]
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x00eb
            goto L_0x0124
        L_0x00eb:
            java.lang.Class r1 = r0.getClassName(r8)
            java.lang.reflect.Method r1 = r0.findMethodInClass(r1, r3)
            if (r1 == 0) goto L_0x0482
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "forName"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x010d
            java.lang.Object r1 = r0.getValue(r6, r4)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Class r1 = r0.getClassName(r1)
            goto L_0x04e5
        L_0x010d:
            if (r6 == 0) goto L_0x011a
            java.lang.Object[] r2 = r0.parseArguments(r6, r4)
            r3 = 0
            java.lang.Object r1 = r1.invoke(r3, r2)
            goto L_0x04e5
        L_0x011a:
            r2 = 0
            r3 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r1 = r1.invoke(r3, r2)
            goto L_0x04e5
        L_0x0124:
            if (r6 == 0) goto L_0x0170
            java.lang.String r2 = "in.juspay.hypersdk.mystique.DuiInvocationHandler"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0133
            r0.parseArguments(r6, r4)
            goto L_0x0482
        L_0x0133:
            java.lang.Class[] r2 = r0.parseTypeArguments(r6)
            java.lang.Class r3 = r0.getClassName(r8)
            java.lang.reflect.Constructor[] r3 = r3.getConstructors()
            int r7 = r3.length
            r8 = 0
        L_0x0141:
            if (r8 >= r7) goto L_0x0482
            r9 = r3[r8]
            java.lang.Class[] r10 = r9.getParameterTypes()
            int r10 = r10.length
            int r11 = r0.getArgsLength(r6)
            if (r10 != r11) goto L_0x016d
            java.lang.Class[] r10 = r9.getParameterTypes()
            boolean r10 = r0.matchTypes(r10, r2)
            if (r10 == 0) goto L_0x016d
            java.lang.Object[] r2 = r0.parseArguments(r6, r4)
            r5.setParams(r2)
            r5.setKey(r1)
            r5.setConstructor(r9)
            java.lang.Object r1 = r9.newInstance(r2)
            goto L_0x04e5
        L_0x016d:
            int r8 = r8 + 1
            goto L_0x0141
        L_0x0170:
            r5.setKey(r1)
            java.lang.Class r1 = java.lang.Class.forName(r8)
            r5.setClassName(r1)
            java.lang.Object r1 = r1.newInstance()
            goto L_0x04e5
        L_0x0180:
            if (r14 == 0) goto L_0x0482
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.state
            java.lang.Object r1 = r1.get(r14)
            r5.setInvokeOn(r1)
            r2 = 0
            int r2 = r0.indexOf(r7, r11, r2)
            r8 = -1
            if (r2 != r8) goto L_0x020e
            if (r1 == 0) goto L_0x020e
            java.lang.Class r2 = r1.getClass()
            java.lang.reflect.Method r2 = r0.findMethodInClass(r2, r3)
            r5.setMethod(r2)
            if (r6 == 0) goto L_0x01da
            if (r2 == 0) goto L_0x01b1
            java.lang.Object[] r3 = r0.parseArguments(r6, r4)
            r5.setParams(r3)
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x01b1:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = " isNull : fn__runCommand - get classMethodDetails "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r13)
            java.lang.String r4 = r16.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = " isNull : fn__runCommand - get classMethodDetails "
            goto L_0x046b
        L_0x01da:
            if (r2 == 0) goto L_0x01e5
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x01e5:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = " isNull : fn__runCommand - get classMethodDetails : "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r13)
            java.lang.String r4 = r16.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = " isNull : fn__runCommand - get classMethodDetails : "
            goto L_0x046b
        L_0x020e:
            if (r1 == 0) goto L_0x0231
            java.lang.String[] r1 = r0.substr(r7, r11)
            r2 = 1
            r1 = r1[r2]
            java.lang.String[] r3 = r0.substr(r3, r10)
            r2 = r3[r2]
            android.util.Pair r3 = new android.util.Pair
            r3.<init>(r1, r2)
            r5.setFieldArgs(r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r0.state
            java.lang.Object r3 = r3.get(r14)
            java.lang.Object r1 = r0.findAndSetField(r3, r1, r2, r4)
            goto L_0x04e5
        L_0x0231:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = " isNull : fn__runCommand - get_"
            java.lang.String r3 = " is null "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r14, r3)
            java.lang.String r5 = r16.getErrorDetails()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.e(r15, r4)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r14, r3)
            goto L_0x0474
        L_0x0259:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            android.app.Activity r1 = r1.getActivity()
            if (r1 != 0) goto L_0x0267
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            android.content.Context r1 = r1.getAppContext()
        L_0x0267:
            java.lang.String r2 = " isNull : fn__runCommand - ctx classMethodDetails  "
            if (r1 == 0) goto L_0x02df
            java.lang.Class r7 = r1.getClass()
            java.lang.reflect.Method r7 = r0.findMethodInClass(r7, r3)
            r5.setMethod(r7)
            if (r6 == 0) goto L_0x02b0
            if (r7 == 0) goto L_0x0287
            java.lang.Object[] r2 = r0.parseArguments(r6, r4)
            r5.setParams(r2)
            java.lang.Object r1 = r7.invoke(r1, r2)
            goto L_0x04e5
        L_0x0287:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = " isNull : fn__runCommand - ctx  classMethodDetails "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r13)
            java.lang.String r4 = r16.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = " isNull : fn__runCommand - ctx  classMethodDetails "
            goto L_0x046b
        L_0x02b0:
            if (r7 == 0) goto L_0x02bb
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r1 = r7.invoke(r1, r2)
            goto L_0x04e5
        L_0x02bb:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.e(r15, r4)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x030f
        L_0x02df:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r4 = "Missing Activity"
            java.lang.String r5 = "ctx, it is not  activity, it is applicationContext"
            r1.e(r4, r5)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.e(r15, r4)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x030f:
            r5 = r2
            r2 = r4
            goto L_0x034d
        L_0x0312:
            java.lang.Class r2 = r17.getClass()
            java.lang.reflect.Method r2 = r0.findMethodInClass(r2, r3)
            java.lang.String r5 = " isNull : fn__runCommand - parent  classMethodDetails "
            if (r6 == 0) goto L_0x0352
            if (r2 == 0) goto L_0x032a
            java.lang.Object[] r3 = r0.parseArguments(r6, r4)
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x032a:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r5, r3, r13)
            java.lang.String r4 = r16.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x034d:
            r2.append(r5)
            goto L_0x046e
        L_0x0352:
            if (r2 == 0) goto L_0x035d
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x035d:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r5, r3, r13)
            java.lang.String r4 = r16.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = " isNull : fn__runCommand - parent classMethodDetails  "
            goto L_0x046b
        L_0x0384:
            java.lang.Class r2 = r17.getClass()
            java.lang.reflect.Method r2 = r0.findMethodInClass(r2, r3)
            r5.setMethod(r2)
            if (r6 == 0) goto L_0x03c7
            if (r2 == 0) goto L_0x03a0
            java.lang.Object[] r3 = r0.parseArguments(r6, r4)
            r5.setParams(r3)
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x03a0:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r4 = " isNull : fn__runCommand - classMethodDetails  "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r4, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x046b
        L_0x03c7:
            if (r2 == 0) goto L_0x03d2
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object r1 = r2.invoke(r1, r3)
            goto L_0x04e5
        L_0x03d2:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r4 = " isNull : fn__runCommand - this  classMethodDetails "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r4, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x046b
        L_0x03f8:
            r5.setInvokeOn(r0)
            java.lang.Class<in.juspay.hypersdk.core.InflateView> r1 = in.juspay.hypersdk.core.InflateView.class
            java.lang.reflect.Method r1 = r0.findMethodInClass(r1, r3)
            r5.setMethod(r1)
            if (r6 == 0) goto L_0x043b
            if (r1 == 0) goto L_0x0415
            java.lang.Object[] r2 = r0.parseArguments(r6, r4)
            r5.setParams(r2)
            java.lang.Object r1 = r1.invoke(r0, r2)
            goto L_0x04e5
        L_0x0415:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r4 = " isNull : fn__runCommand - infl  classMethodDetails "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r4, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x046b
        L_0x043b:
            if (r1 == 0) goto L_0x0446
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r1 = r1.invoke(r0, r2)
            goto L_0x04e5
        L_0x0446:
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r4 = " isNull : fn__runCommand - infl classMethodDetails  "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r4, r3, r13)
            java.lang.String r5 = r16.getErrorDetails()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.e(r15, r2)
            in.juspay.hypersdk.core.DynamicUI r1 = r0.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x046b:
            r2.append(r4)
        L_0x046e:
            r2.append(r3)
            r2.append(r13)
        L_0x0474:
            java.lang.String r3 = r16.getErrorDetails()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.onError(r15, r2)
        L_0x0482:
            r1 = r18
            goto L_0x04e5
        L_0x0485:
            r2 = 0
            r5 = r18
            if (r5 != 0) goto L_0x04b8
            int r5 = r0.indexOf(r3, r10, r2)
            r6 = -1
            if (r5 == r6) goto L_0x04a9
            java.lang.String[] r2 = r0.substr(r3, r10)
            r5 = 1
            r2 = r2[r5]
            java.lang.Class r5 = r17.getClass()
            java.lang.reflect.Method r3 = r0.findMethodInClass(r5, r3)
            java.lang.Object[] r2 = r0.parseArguments(r2, r4)
            java.lang.Object r1 = r3.invoke(r1, r2)
            goto L_0x04e5
        L_0x04a9:
            java.lang.Class r4 = r17.getClass()
            java.lang.reflect.Method r3 = r0.findMethodInClass(r4, r3)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r1 = r3.invoke(r1, r2)
            goto L_0x04e5
        L_0x04b8:
            int r1 = r0.indexOf(r3, r10, r2)
            r6 = -1
            if (r1 == r6) goto L_0x04d7
            java.lang.String[] r1 = r0.substr(r3, r10)
            r2 = 1
            r1 = r1[r2]
            java.lang.Class r2 = r18.getClass()
            java.lang.reflect.Method r2 = r0.findMethodInClass(r2, r3)
            java.lang.Object[] r1 = r0.parseArguments(r1, r4)
            java.lang.Object r1 = r2.invoke(r5, r1)
            goto L_0x04e5
        L_0x04d7:
            java.lang.Class r1 = r18.getClass()
            java.lang.reflect.Method r1 = r0.findMethodInClass(r1, r3)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r1 = r1.invoke(r5, r2)
        L_0x04e5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.runCommand(java.lang.Object, java.lang.Object, java.lang.String, boolean, in.juspay.hypersdk.mystique.ListAdapter$CacheHolder):java.lang.Object");
    }

    private void separatorTextChange(final JSONObject jSONObject, Object obj) {
        Method method = obj.getClass().getMethod("addTextChangedListener", new Class[]{TextWatcher.class});
        final EditText editText = (EditText) obj;
        final String string = jSONObject.getString("onChange");
        method.invoke(obj, new Object[]{new TextWatcher() {
            public static final int TOTAL_DIGITS = 21;
            public static final int TOTAL_SYMBOLS = 26;
            public final char DIVIDER = jSONObject.getString("separator").charAt(0);
            public final int DIVIDER_MODULO;
            public final int DIVIDER_POSITION;
            public boolean executeTextChange = true;
            public String previousText;

            {
                int i = jSONObject.getInt("separatorRepeat");
                this.DIVIDER_POSITION = i;
                this.DIVIDER_MODULO = i + 1;
            }

            private String buildCorrectString(char[] cArr) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cArr.length; i++) {
                    if (cArr[i] != 0) {
                        sb.append(cArr[i]);
                        if (i > 0 && i < cArr.length - 1 && (i + 1) % this.DIVIDER_POSITION == 0) {
                            sb.append(this.DIVIDER);
                        }
                    }
                }
                return sb.toString();
            }

            private char[] getDigitArray(Editable editable) {
                char[] cArr = new char[21];
                int i = 0;
                for (int i2 = 0; i2 < editable.length() && i < 21; i2++) {
                    char charAt = editable.charAt(i2);
                    if (Character.isDigit(charAt)) {
                        cArr[i] = charAt;
                        i++;
                    }
                }
                return cArr;
            }

            private boolean isInputCorrect(Editable editable) {
                boolean z = editable.length() <= 26;
                int i = 0;
                while (i < editable.length()) {
                    z &= (i <= 0 || (i + 1) % this.DIVIDER_MODULO != 0) ? Character.isDigit(editable.charAt(i)) : this.DIVIDER == editable.charAt(i);
                    i++;
                }
                return z;
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0 && editText.isFocused() && !this.previousText.equals(editable.toString()) && this.executeTextChange) {
                    boolean z = this.previousText.length() > editable.length();
                    InputFilter[] filters = editable.getFilters();
                    editable.setFilters(new InputFilter[0]);
                    int selectionStart = editText.getSelectionStart();
                    this.executeTextChange = false;
                    int i = selectionStart + 1;
                    if (i % this.DIVIDER_MODULO == 0 && z) {
                        editable.delete(selectionStart - 1, selectionStart);
                    }
                    if (!isInputCorrect(editable)) {
                        editable.replace(0, editable.length(), buildCorrectString(getDigitArray(editable)));
                        if (editable.length() > 0 && this.DIVIDER == editable.charAt(editable.length() - 1) && z) {
                            editable.delete(editable.length() - 1, editable.length());
                        }
                    }
                    if (selectionStart != 0 && selectionStart % this.DIVIDER_MODULO == 0 && editable.length() > selectionStart && !z) {
                        editText.setSelection(i);
                    }
                    this.executeTextChange = true;
                    editable.setFilters(filters);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.previousText = charSequence.toString();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!this.previousText.equals(charSequence.toString()) && this.executeTextChange) {
                    DynamicUI access$000 = InflateView.this.dynamicUI;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                    outline73.append(string);
                    outline73.append("', '");
                    outline73.append(charSequence);
                    outline73.append("');");
                    access$000.addJsToWebView(outline73.toString());
                }
            }
        }});
    }

    private String[] substr(String str, String str2) {
        int indexOf = indexOf(str, str2, 0);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(str2.length() + indexOf)};
    }

    private Method tryExactMatch(Class<?> cls, String str, Class<?>[] clsArr) {
        return cls.getMethod(str, clsArr);
    }

    private Method tryMultiAgrumentDeepMatch(Class<?> cls, String str, Class<?>[] clsArr) {
        if ("undefined".equals(str)) {
            return null;
        }
        DuiLogger logger = this.dynamicUI.getLogger();
        String str2 = LOG_TAG;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("tryMultiAgrumentDeepMatch reached. Beware slow function.. ");
        outline73.append(cls.toString());
        outline73.append(" : ");
        outline73.append(str);
        outline73.append(" : ");
        outline73.append(clsArr.length);
        logger.d(str2, outline73.toString());
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == clsArr.length && matchTypes(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r10v0, types: [java.lang.Class<?>, java.lang.Class, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method trySingleArgumentDeepMatch(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class r10) {
        /*
            r7 = this;
            boolean r0 = isWrappedPrimitiveType(r10)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.util.Map<java.lang.Class<?>, java.lang.Class<?>> r3 = PRIMITIVE_TYPES     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ NoSuchMethodException -> 0x0019 }
            r0[r2] = r3     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r0)     // Catch:{ NoSuchMethodException -> 0x0019 }
            return r8
        L_0x0019:
            java.lang.Class[] r0 = r10.getInterfaces()
            int r3 = r0.length
            r4 = 0
        L_0x001f:
            if (r4 >= r3) goto L_0x002f
            r5 = r0[r4]
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002c }
            r6[r2] = r5     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r6)     // Catch:{ NoSuchMethodException -> 0x002c }
            return r8
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x002f:
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0038 }
            r0[r2] = r10     // Catch:{ NoSuchMethodException -> 0x0038 }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r0)     // Catch:{ NoSuchMethodException -> 0x0038 }
            return r8
        L_0x0038:
            java.lang.Class r10 = r10.getSuperclass()
            if (r10 != 0) goto L_0x0019
            in.juspay.hypersdk.core.DynamicUI r8 = r7.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r8 = r8.getLogger()
            java.lang.String r9 = LOG_TAG
            java.lang.String r10 = "Never reach here"
            r8.e(r9, r10)
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.trySingleArgumentDeepMatch(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public Boolean containsInState(String str) {
        return Boolean.valueOf(this.state.containsKey(str));
    }

    public void convertAndStoreArray(ArrayList<?> arrayList, Class<?> cls, String str, boolean z) {
        int size = arrayList.size();
        if (z) {
            cls = PRIMITIVE_TYPES.get(cls);
        }
        Object newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        this.state.put(str, newInstance);
    }

    @TargetApi(14)
    public void dismissPopUp() {
        if (this.dynamicUI.getActivity() != null) {
            this.dynamicUI.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    InflateView.this.popUpMenu.dismiss();
                }
            });
        } else {
            this.dynamicUI.getLogger().e("Missing Activity", "dismissPopUp, it is not  activity, it is applicationContext");
        }
    }

    public float dpToPx(float f2) {
        if (f2 > 0.0f) {
            return (float) Math.round(f2 * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0.0f;
    }

    public int dpToPx(int i) {
        if (i > 0) {
            return Math.round(((float) i) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    public Pair<String, ObjectAnimator> findAnimationById(String str) {
        String outline50 = GeneratedOutlineSupport.outline50("M_anim_", str);
        if (this.state.containsKey(outline50)) {
            return (Pair) this.state.get(outline50);
        }
        return null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> getClassName(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1409106502: goto L_0x0029;
                case -833865840: goto L_0x001f;
                case -631823565: goto L_0x0015;
                case -407376626: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "in.juspay.mystique.AccordionLayout"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "in.juspay.mystique.SwypeScroll"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "in.juspay.mystique.SwypeLayout"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "in.juspay.mystique.BottomSheetLayout"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x004a
            if (r0 == r3) goto L_0x0047
            if (r0 == r2) goto L_0x0044
            if (r0 == r1) goto L_0x0041
            java.lang.Class r5 = java.lang.Class.forName(r5)
            return r5
        L_0x0041:
            java.lang.Class<in.juspay.hypersdk.mystique.BottomSheetLayout> r5 = in.juspay.hypersdk.mystique.BottomSheetLayout.class
            return r5
        L_0x0044:
            java.lang.Class<in.juspay.hypersdk.mystique.AccordionLayout> r5 = in.juspay.hypersdk.mystique.AccordionLayout.class
            return r5
        L_0x0047:
            java.lang.Class<in.juspay.hypersdk.mystique.SwypeScroll> r5 = in.juspay.hypersdk.mystique.SwypeScroll.class
            return r5
        L_0x004a:
            java.lang.Class<in.juspay.hypersdk.mystique.SwypeLayout> r5 = in.juspay.hypersdk.mystique.SwypeLayout.class
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getClassName(java.lang.String):java.lang.Class");
    }

    public String getErrorDetails() {
        return this.currViewId + " - " + this.currView + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.fileOrigin + " - " + this.lastCommand;
    }

    public <T> T getStateValFromKey(String str) {
        return this.state.get(str);
    }

    public boolean getUseAppContext() {
        return this.useAppContext;
    }

    public void handleAnimation(Object obj, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = new JSONArray(jSONObject.getString("props"));
            String str = "";
            String string = jSONObject.has("id") ? jSONObject.getString("id") : str;
            if (jSONObject.has("onEnd")) {
                str = jSONObject.getString("onEnd");
            }
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[jSONArray2.length()];
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                propertyValuesHolderArr[i2] = PropertyValuesHolder.ofFloat(jSONObject2.getString("prop"), new float[]{(float) jSONObject2.getDouble("from"), (float) jSONObject2.getDouble("to")});
            }
            final ObjectAnimator animator = getAnimator(obj, propertyValuesHolderArr, jSONObject);
            Pair pair = new Pair(Integer.valueOf(((View) obj).getId()), animator);
            HashMap<String, Object> hashMap = this.state;
            hashMap.put("M_anim_" + string, pair);
            if (jSONObject.has("onEnd")) {
                final String outline50 = GeneratedOutlineSupport.outline50("M_anim_", str);
                animator.addListener(new AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (InflateView.this.state.containsKey(outline50)) {
                            ObjectAnimator objectAnimator = (ObjectAnimator) ((Pair) InflateView.this.state.get(outline50)).second;
                            if (objectAnimator != null && objectAnimator != animator) {
                                objectAnimator.start();
                            }
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public Object parseAndRunPipe(Object obj, String str, boolean z) {
        return parseAndRunPipe(obj, str, z, new ViewHolder(), false);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parseAndRunPipe(java.lang.Object r17, java.lang.String r18, boolean r19, in.juspay.hypersdk.mystique.ListAdapter.ViewHolder r20, boolean r21) {
        /*
            r16 = this;
            r6 = r16
            java.util.ArrayList r7 = r20.getProps()
            r8 = -1
            r0 = 0
            r9 = 1
            r10 = 0
            if (r21 == 0) goto L_0x00f8
            java.util.Iterator r1 = r7.iterator()
            r2 = r0
        L_0x0011:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00f7
            java.lang.Object r3 = r1.next()
            in.juspay.hypersdk.mystique.ListAdapter$CacheHolder r3 = (in.juspay.hypersdk.mystique.ListAdapter.CacheHolder) r3
            java.lang.Object r4 = r3.getInvokeOn()
            java.lang.String r5 = r3.getKey()
            int r7 = r5.hashCode()
            r11 = 3
            r12 = 2
            switch(r7) {
                case 102230: goto L_0x004e;
                case 108960: goto L_0x0044;
                case 3237035: goto L_0x003a;
                case 3559070: goto L_0x002f;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0058
        L_0x002f:
            java.lang.String r7 = "this"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0058
            r5 = 1
            goto L_0x0059
        L_0x003a:
            java.lang.String r7 = "infl"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0058
            r5 = 2
            goto L_0x0059
        L_0x0044:
            java.lang.String r7 = "new"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0058
            r5 = 3
            goto L_0x0059
        L_0x004e:
            java.lang.String r7 = "get"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0058
            r5 = 0
            goto L_0x0059
        L_0x0058:
            r5 = -1
        L_0x0059:
            if (r5 == 0) goto L_0x0069
            if (r5 == r9) goto L_0x0066
            if (r5 == r12) goto L_0x0064
            if (r5 == r11) goto L_0x0062
            goto L_0x0083
        L_0x0062:
            r4 = r0
            goto L_0x0083
        L_0x0064:
            r4 = r6
            goto L_0x0083
        L_0x0066:
            r4 = r17
            goto L_0x0083
        L_0x0069:
            java.util.HashMap r5 = r20.getState()
            java.lang.String r7 = r3.getStoreKey()
            java.lang.Object r5 = r5.get(r7)
            if (r5 == 0) goto L_0x0083
            java.util.HashMap r4 = r20.getState()
            java.lang.String r5 = r3.getStoreKey()
            java.lang.Object r4 = r4.get(r5)
        L_0x0083:
            java.lang.Object[] r5 = r3.getParams()
            java.lang.reflect.Method r7 = r3.getMethod()
            if (r7 == 0) goto L_0x00a3
            if (r4 == 0) goto L_0x00a3
            java.lang.reflect.Method r2 = r3.getMethod()
            if (r5 == 0) goto L_0x009a
            java.lang.Object r2 = r2.invoke(r4, r5)
            goto L_0x00a0
        L_0x009a:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            java.lang.Object r2 = r2.invoke(r4, r5)
        L_0x00a0:
            r11 = r19
            goto L_0x00e2
        L_0x00a3:
            java.lang.reflect.Field r7 = r3.getField()
            if (r7 == 0) goto L_0x00c1
            if (r4 == 0) goto L_0x00c1
            android.util.Pair r5 = r3.getFieldArgs()
            java.lang.Object r5 = r5.first
            java.lang.String r5 = (java.lang.String) r5
            android.util.Pair r7 = r3.getFieldArgs()
            java.lang.Object r7 = r7.second
            java.lang.String r7 = (java.lang.String) r7
            r11 = r19
            r6.findAndSetField(r4, r5, r7, r11)
            goto L_0x00e2
        L_0x00c1:
            r11 = r19
            java.lang.reflect.Constructor r4 = r3.getConstructor()
            if (r4 == 0) goto L_0x00d4
            if (r5 == 0) goto L_0x00e2
            java.lang.reflect.Constructor r2 = r3.getConstructor()
            java.lang.Object r2 = r2.newInstance(r5)
            goto L_0x00e2
        L_0x00d4:
            java.lang.Class r4 = r3.getClassName()
            if (r4 == 0) goto L_0x00e2
            java.lang.Class r2 = r3.getClassName()
            java.lang.Object r2 = r2.newInstance()
        L_0x00e2:
            java.lang.String r4 = r3.getStoreKey()
            if (r4 == 0) goto L_0x00f3
            java.lang.String r3 = r3.getStoreKey()
            r4 = r20
            r4.putState(r3, r2)
            goto L_0x0011
        L_0x00f3:
            r4 = r20
            goto L_0x0011
        L_0x00f7:
            return r17
        L_0x00f8:
            r11 = r19
            java.util.regex.Pattern r1 = COMMAND_SPLIT
            r2 = r18
            java.lang.String[] r12 = r1.split(r2)
            int r13 = r12.length
            r14 = r0
            r15 = 0
        L_0x0105:
            if (r15 >= r13) goto L_0x017b
            r3 = r12[r15]
            java.lang.String r0 = ""
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0177
            in.juspay.hypersdk.mystique.ListAdapter$CacheHolder r5 = new in.juspay.hypersdk.mystique.ListAdapter$CacheHolder
            r5.<init>()
            r7.add(r5)
            java.lang.String r0 = "="
            int r1 = r6.indexOf(r3, r0, r10)
            if (r1 == r8) goto L_0x016c
            java.lang.String[] r0 = r6.substr(r3, r0)
            r1 = r0[r10]
            java.lang.String r2 = "_"
            java.lang.String[] r1 = r6.substr(r1, r2)
            r4 = r1[r9]
            r3 = r0[r9]
            r0 = r16
            r1 = r17
            r2 = r14
            r8 = r4
            r4 = r19
            r18 = r5
            java.lang.Object r0 = r0.runCommand(r1, r2, r3, r4, r5)
            r5.setStoreKey(r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r6.state
            r1.put(r8, r0)
            in.juspay.hypersdk.core.DynamicUI r1 = r6.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r1 = r1.getLogger()
            java.lang.String r2 = LOG_TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "setting "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = " to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.d(r2, r0)
            goto L_0x0177
        L_0x016c:
            r0 = r16
            r1 = r17
            r2 = r14
            r4 = r19
            java.lang.Object r14 = r0.runCommand(r1, r2, r3, r4, r5)
        L_0x0177:
            int r15 = r15 + 1
            r8 = -1
            goto L_0x0105
        L_0x017b:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.parseAndRunPipe(java.lang.Object, java.lang.String, boolean, in.juspay.hypersdk.mystique.ListAdapter$ViewHolder, boolean):java.lang.Object");
    }

    public void parseKeys(String str, JSONObject jSONObject, Object obj, boolean z) {
        parseKeys(str, jSONObject, obj, z, new ViewHolder(), false);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseKeys(java.lang.String r28, org.json.JSONObject r29, java.lang.Object r30, boolean r31, in.juspay.hypersdk.mystique.ListAdapter.ViewHolder r32, boolean r33) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            java.lang.String r11 = "popupMenu"
            java.lang.String r12 = "onSwipe"
            java.lang.String r13 = "onDateChange"
            java.lang.String r14 = "onTouch"
            java.lang.String r15 = "onFocus"
            java.lang.String r6 = "onItemClick"
            java.lang.String r5 = "onRefresh"
            java.lang.String r4 = "onScrollStateChange"
            java.lang.String r0 = "onScroll"
            java.lang.String r3 = "onClick"
            java.lang.String r1 = "source"
            java.lang.String r2 = "onLongPress"
            r16 = r3
            java.lang.String r3 = "onKeyUp"
            r17 = r4
            java.lang.String r4 = "pattern"
            r18 = r5
            java.lang.String r5 = "listItem"
            r19 = r6
            java.lang.String r6 = "inlineAnimation"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x0046
            in.juspay.hypersdk.mystique.AnimationHolder r0 = r7.animationHolder     // Catch:{ Exception -> 0x05fc }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r9.getString(r8)     // Catch:{ Exception -> 0x05fc }
            r1.<init>(r2)     // Catch:{ Exception -> 0x05fc }
            r0.applyAnimation(r10, r1, r9)     // Catch:{ Exception -> 0x05fc }
            return
        L_0x0046:
            boolean r6 = r5.equals(r8)     // Catch:{ Exception -> 0x05fc }
            r20 = r11
            java.lang.String r11 = "Missing Activity"
            r21 = r12
            java.lang.String r12 = "listData"
            if (r6 == 0) goto L_0x00b7
            boolean r6 = r9.has(r12)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x00b7
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ Exception -> 0x05fc }
            if (r0 != 0) goto L_0x006e
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = "listData, it is not  activity, it is applicationContext"
            r0.e(r11, r1)     // Catch:{ Exception -> 0x05fc }
            return
        L_0x006e:
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x00b6
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x05fc }
            r1 = 0
            r0.setDivider(r1)     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.AndroidInterface r1 = r1.getAndroidInterface()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.Renderer r15 = r1.getRenderer()     // Catch:{ Exception -> 0x05fc }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r9.getString(r5)     // Catch:{ Exception -> 0x05fc }
            r1.<init>(r2)     // Catch:{ Exception -> 0x05fc }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = r9.getString(r12)     // Catch:{ Exception -> 0x05fc }
            r2.<init>(r3)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "itemView"
            org.json.JSONObject r16 = r1.getJSONObject(r3)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "holderViews"
            org.json.JSONArray r17 = r1.getJSONArray(r3)     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.mystique.ListAdapter r1 = new in.juspay.hypersdk.mystique.ListAdapter     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r3 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            android.app.Activity r14 = r3.getActivity()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DuiCallback r3 = r7.duiCallback     // Catch:{ Exception -> 0x05fc }
            r13 = r1
            r18 = r2
            r19 = r3
            r13.<init>(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x05fc }
            r0.setAdapter(r1)     // Catch:{ Exception -> 0x05fc }
        L_0x00b6:
            return
        L_0x00b7:
            boolean r5 = r12.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r5 == 0) goto L_0x00e2
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x00e1
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x05fc }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r9.getString(r12)     // Catch:{ Exception -> 0x05fc }
            r1.<init>(r2)     // Catch:{ Exception -> 0x05fc }
            android.widget.ListAdapter r2 = r0.getAdapter()     // Catch:{ Exception -> 0x05fc }
            boolean r2 = r2 instanceof in.juspay.hypersdk.mystique.ListAdapter     // Catch:{ Exception -> 0x05fc }
            if (r2 == 0) goto L_0x00e1
            android.widget.ListAdapter r0 = r0.getAdapter()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.mystique.ListAdapter r0 = (in.juspay.hypersdk.mystique.ListAdapter) r0     // Catch:{ Exception -> 0x05fc }
            r0.updateRowData(r1)     // Catch:{ Exception -> 0x05fc }
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x05fc }
        L_0x00e1:
            return
        L_0x00e2:
            in.juspay.hypersdk.core.DynamicUI r5 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.mystique.PropHandler r5 = r5.getHandler()     // Catch:{ Exception -> 0x05fc }
            if (r5 == 0) goto L_0x00f7
            in.juspay.hypersdk.core.DynamicUI r5 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.mystique.PropHandler r5 = r5.getHandler()     // Catch:{ Exception -> 0x05fc }
            boolean r5 = r5.handleProp(r8, r9, r10)     // Catch:{ Exception -> 0x05fc }
            if (r5 == 0) goto L_0x00f7
            return
        L_0x00f7:
            boolean r5 = r8.equals(r4)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r12 = ","
            r6 = 1
            if (r5 == 0) goto L_0x014c
            java.lang.Class r5 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            r22 = r11
            java.lang.String r11 = "setFilters"
            r23 = r13
            java.lang.Class[] r13 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.text.InputFilter[]> r24 = android.text.InputFilter[].class
            r25 = 0
            r13[r25] = r24     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r5 = r5.getMethod(r11, r13)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x05fc }
            java.lang.String[] r4 = r4.split(r12)     // Catch:{ Exception -> 0x05fc }
            r11 = 0
            r11 = r4[r11]     // Catch:{ Exception -> 0x05fc }
            int r13 = r4.length     // Catch:{ Exception -> 0x05fc }
            if (r13 != r6) goto L_0x0127
            r4 = 10000(0x2710, float:1.4013E-41)
            goto L_0x0131
        L_0x0127:
            r4 = r4[r6]     // Catch:{ Exception -> 0x05fc }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x05fc }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x05fc }
        L_0x0131:
            in.juspay.hypersdk.core.InflateView$2 r6 = new in.juspay.hypersdk.core.InflateView$2     // Catch:{ Exception -> 0x05fc }
            r6.<init>(r11)     // Catch:{ Exception -> 0x05fc }
            r11 = 2
            android.text.InputFilter[] r11 = new android.text.InputFilter[r11]     // Catch:{ Exception -> 0x05fc }
            r13 = 0
            r11[r13] = r6     // Catch:{ Exception -> 0x05fc }
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter     // Catch:{ Exception -> 0x05fc }
            r6.<init>(r4)     // Catch:{ Exception -> 0x05fc }
            r4 = 1
            r11[r4] = r6     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x05fc }
            r4[r13] = r11     // Catch:{ Exception -> 0x05fc }
            r5.invoke(r10, r4)     // Catch:{ Exception -> 0x05fc }
            goto L_0x0150
        L_0x014c:
            r22 = r11
            r23 = r13
        L_0x0150:
            boolean r4 = r8.equals(r3)     // Catch:{ Exception -> 0x05fc }
            if (r4 == 0) goto L_0x0179
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r4 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r5 = "setOnKeyListener"
            r6 = 1
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnKeyListener> r13 = android.view.View.OnKeyListener.class
            r24 = 0
            r11[r24] = r13     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r11)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$3 r6 = new in.juspay.hypersdk.core.InflateView$3     // Catch:{ Exception -> 0x05fc }
            r6.<init>(r3)     // Catch:{ Exception -> 0x05fc }
            r5[r24] = r6     // Catch:{ Exception -> 0x05fc }
            r4.invoke(r10, r5)     // Catch:{ Exception -> 0x05fc }
        L_0x0179:
            boolean r3 = r8.equals(r2)     // Catch:{ Exception -> 0x05fc }
            if (r3 == 0) goto L_0x01a1
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r3 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r4 = "setOnLongClickListener"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnLongClickListener> r11 = android.view.View.OnLongClickListener.class
            r13 = 0
            r6[r13] = r11     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r6)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$4 r5 = new in.juspay.hypersdk.core.InflateView$4     // Catch:{ Exception -> 0x05fc }
            r5.<init>(r2)     // Catch:{ Exception -> 0x05fc }
            r4[r13] = r5     // Catch:{ Exception -> 0x05fc }
            r3.invoke(r10, r4)     // Catch:{ Exception -> 0x05fc }
        L_0x01a1:
            boolean r2 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r2 == 0) goto L_0x0203
            boolean r2 = r10 instanceof android.view.TextureView     // Catch:{ Exception -> 0x05fc }
            if (r2 == 0) goto L_0x0203
            r11 = r10
            android.view.TextureView r11 = (android.view.TextureView) r11     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r2 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            android.content.Context r4 = r2.getAppContext()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            android.content.res.Resources r3 = r4.getResources()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r5 = "raw"
            int r1 = r3.getIdentifier(r1, r5, r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r3.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r5 = "android.resource://"
            r3.append(r5)     // Catch:{ Exception -> 0x05fc }
            r3.append(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "/raw/"
            r3.append(r2)     // Catch:{ Exception -> 0x05fc }
            r3.append(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x05fc }
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x05fc }
            android.media.MediaPlayer r3 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x05fc }
            r3.<init>()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$5 r13 = new in.juspay.hypersdk.core.InflateView$5     // Catch:{ Exception -> 0x05fc }
            r1 = r13
            r2 = r27
            r6 = r16
            r16 = r12
            r12 = r17
            r17 = r14
            r14 = r18
            r18 = r15
            r15 = r6
            r6 = r29
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x05fc }
            r11.setSurfaceTextureListener(r13)     // Catch:{ Exception -> 0x05fc }
            goto L_0x0211
        L_0x0203:
            r26 = r16
            r16 = r12
            r12 = r17
            r17 = r14
            r14 = r18
            r18 = r15
            r15 = r26
        L_0x0211:
            boolean r1 = r8.equals(r15)     // Catch:{ Exception -> 0x05fc }
            if (r1 == 0) goto L_0x0239
            java.lang.String r1 = r9.getString(r15)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r2 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "setOnClickListener"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnClickListener> r6 = android.view.View.OnClickListener.class
            r11 = 0
            r5[r11] = r6     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$6 r4 = new in.juspay.hypersdk.core.InflateView$6     // Catch:{ Exception -> 0x05fc }
            r4.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r3[r11] = r4     // Catch:{ Exception -> 0x05fc }
            r2.invoke(r10, r3)     // Catch:{ Exception -> 0x05fc }
        L_0x0239:
            boolean r1 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r1 == 0) goto L_0x028a
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x0273 }
            boolean r1 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x0273 }
            if (r1 == 0) goto L_0x028a
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x0273 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x0273 }
            boolean r1 = r1 instanceof in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x0273 }
            if (r1 == 0) goto L_0x025c
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x0273 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x0273 }
            in.juspay.hypersdk.mystique.OnScroll r1 = (in.juspay.hypersdk.mystique.OnScroll) r1     // Catch:{ Exception -> 0x0273 }
            goto L_0x0263
        L_0x025c:
            in.juspay.hypersdk.mystique.OnScroll r1 = new in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x0273 }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x0273 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0273 }
        L_0x0263:
            r1.setScrollCallback(r0)     // Catch:{ Exception -> 0x0273 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x0273 }
            r0.setOnScrollListener(r1)     // Catch:{ Exception -> 0x0273 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x0273 }
            r0.setTag(r1)     // Catch:{ Exception -> 0x0273 }
            goto L_0x028a
        L_0x0273:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r2.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "Exception occured in onScroll:"
            r2.append(r3)     // Catch:{ Exception -> 0x05fc }
            r2.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x05fc }
            r1.println(r0)     // Catch:{ Exception -> 0x05fc }
        L_0x028a:
            boolean r0 = r8.equals(r12)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x02db
            java.lang.String r0 = r9.getString(r12)     // Catch:{ Exception -> 0x02c4 }
            boolean r1 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x02c4 }
            if (r1 == 0) goto L_0x02db
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x02c4 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x02c4 }
            boolean r1 = r1 instanceof in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x02c4 }
            if (r1 == 0) goto L_0x02ad
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x02c4 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x02c4 }
            in.juspay.hypersdk.mystique.OnScroll r1 = (in.juspay.hypersdk.mystique.OnScroll) r1     // Catch:{ Exception -> 0x02c4 }
            goto L_0x02b4
        L_0x02ad:
            in.juspay.hypersdk.mystique.OnScroll r1 = new in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x02c4 }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x02c4 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x02c4 }
        L_0x02b4:
            r1.setScrollChangeCallback(r0)     // Catch:{ Exception -> 0x02c4 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x02c4 }
            r0.setOnScrollListener(r1)     // Catch:{ Exception -> 0x02c4 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x02c4 }
            r0.setTag(r1)     // Catch:{ Exception -> 0x02c4 }
            goto L_0x02db
        L_0x02c4:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r2.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "Exception occured in onScrollStateChange :"
            r2.append(r3)     // Catch:{ Exception -> 0x05fc }
            r2.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x05fc }
            r1.println(r0)     // Catch:{ Exception -> 0x05fc }
        L_0x02db:
            boolean r0 = r8.equals(r14)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x031b
            java.lang.String r0 = r9.getString(r14)     // Catch:{ Exception -> 0x0304 }
            java.lang.Class r1 = r30.getClass()     // Catch:{ Exception -> 0x0304 }
            java.lang.String r2 = "setOnRefreshListener"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0304 }
            java.lang.Class<androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener> r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0304 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x0304 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0304 }
            in.juspay.hypersdk.core.InflateView$7 r3 = new in.juspay.hypersdk.core.InflateView$7     // Catch:{ Exception -> 0x0304 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0304 }
            r2[r6] = r3     // Catch:{ Exception -> 0x0304 }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x0304 }
            goto L_0x031b
        L_0x0304:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r2.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "Exception occured  :"
            r2.append(r3)     // Catch:{ Exception -> 0x05fc }
            r2.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x05fc }
            r1.println(r0)     // Catch:{ Exception -> 0x05fc }
        L_0x031b:
            r1 = r19
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0337
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x05fc }
            if (r0 != 0) goto L_0x0328
            return
        L_0x0328:
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$8 r2 = new in.juspay.hypersdk.core.InflateView$8     // Catch:{ Exception -> 0x05fc }
            r2.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r0.setOnItemClickListener(r2)     // Catch:{ Exception -> 0x05fc }
        L_0x0337:
            java.lang.String r0 = "onChange"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x034e
            java.lang.String r0 = "separator"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x034b
            r7.separatorTextChange(r9, r10)     // Catch:{ Exception -> 0x05fc }
            goto L_0x034e
        L_0x034b:
            r7.normalTextChange(r9, r10)     // Catch:{ Exception -> 0x05fc }
        L_0x034e:
            r1 = r18
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x037a
            java.lang.Class r0 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "setOnFocusChangeListener"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnFocusChangeListener> r4 = android.view.View.OnFocusChangeListener.class
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$9 r3 = new in.juspay.hypersdk.core.InflateView$9     // Catch:{ Exception -> 0x05fc }
            r3.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r1 = 0
            r2[r1] = r3     // Catch:{ Exception -> 0x05fc }
            r0.invoke(r10, r2)     // Catch:{ Exception -> 0x05fc }
        L_0x037a:
            r1 = r17
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "setOnTouchListener"
            if (r0 == 0) goto L_0x03a4
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r1 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnTouchListener> r5 = android.view.View.OnTouchListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$10 r4 = new in.juspay.hypersdk.core.InflateView$10     // Catch:{ Exception -> 0x05fc }
            r4.<init>(r0)     // Catch:{ Exception -> 0x05fc }
            r3[r6] = r4     // Catch:{ Exception -> 0x05fc }
            r1.invoke(r10, r3)     // Catch:{ Exception -> 0x05fc }
        L_0x03a4:
            r1 = r23
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x03ce
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r1 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r3 = "setOnDateChangeListener"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.widget.CalendarView$OnDateChangeListener> r6 = android.widget.CalendarView.OnDateChangeListener.class
            r11 = 0
            r5[r11] = r6     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r1 = r1.getMethod(r3, r5)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$11 r4 = new in.juspay.hypersdk.core.InflateView$11     // Catch:{ Exception -> 0x05fc }
            r4.<init>(r0)     // Catch:{ Exception -> 0x05fc }
            r3[r11] = r4     // Catch:{ Exception -> 0x05fc }
            r1.invoke(r10, r3)     // Catch:{ Exception -> 0x05fc }
        L_0x03ce:
            r1 = r21
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x03f6
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r1 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.view.View$OnTouchListener> r5 = android.view.View.OnTouchListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$12 r3 = new in.juspay.hypersdk.core.InflateView$12     // Catch:{ Exception -> 0x05fc }
            r3.<init>(r0)     // Catch:{ Exception -> 0x05fc }
            r2[r6] = r3     // Catch:{ Exception -> 0x05fc }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x05fc }
        L_0x03f6:
            r1 = r20
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0485
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ Exception -> 0x05fc }
            if (r0 != 0) goto L_0x0414
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = "popupMenu, it is not  activity, it is applicationContext"
            r2 = r22
            r0.e(r2, r1)     // Catch:{ Exception -> 0x05fc }
            return
        L_0x0414:
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            java.util.regex.Pattern r1 = FUNCTION_ARG_SPLIT_ESCAPE     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x05fc }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = "onMenuItemClick"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            android.widget.PopupMenu r2 = new android.widget.PopupMenu     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r3 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            android.app.Activity r3 = r3.getActivity()     // Catch:{ Exception -> 0x05fc }
            r4 = r10
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x05fc }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x05fc }
            r7.popUpMenu = r2     // Catch:{ Exception -> 0x05fc }
            r2 = 0
        L_0x0439:
            int r3 = r0.length     // Catch:{ Exception -> 0x05fc }
            if (r2 >= r3) goto L_0x046e
            r3 = r0[r2]     // Catch:{ Exception -> 0x05fc }
            java.lang.String r4 = "\\"
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x05fc }
            if (r3 == 0) goto L_0x045b
            r3 = r0[r2]     // Catch:{ Exception -> 0x05fc }
            r4 = r16
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x05fc }
            if (r3 == 0) goto L_0x045d
            r3 = r0[r2]     // Catch:{ Exception -> 0x05fc }
            java.lang.String r5 = "\\\\,"
            java.lang.String r3 = r3.replace(r5, r4)     // Catch:{ Exception -> 0x05fc }
            r0[r2] = r3     // Catch:{ Exception -> 0x05fc }
            goto L_0x045d
        L_0x045b:
            r4 = r16
        L_0x045d:
            android.widget.PopupMenu r3 = r7.popUpMenu     // Catch:{ Exception -> 0x05fc }
            android.view.Menu r3 = r3.getMenu()     // Catch:{ Exception -> 0x05fc }
            r5 = r0[r2]     // Catch:{ Exception -> 0x05fc }
            r6 = 0
            r3.add(r6, r2, r6, r5)     // Catch:{ Exception -> 0x05fc }
            int r2 = r2 + 1
            r16 = r4
            goto L_0x0439
        L_0x046e:
            android.widget.PopupMenu r0 = r7.popUpMenu     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$13 r2 = new in.juspay.hypersdk.core.InflateView$13     // Catch:{ Exception -> 0x05fc }
            r2.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r0.setOnMenuItemClickListener(r2)     // Catch:{ Exception -> 0x05fc }
            android.widget.PopupMenu r0 = r7.popUpMenu     // Catch:{ Exception -> 0x05fc }
            r1 = r10
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$14 r2 = new in.juspay.hypersdk.core.InflateView$14     // Catch:{ Exception -> 0x05fc }
            r2.<init>(r0)     // Catch:{ Exception -> 0x05fc }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x05fc }
        L_0x0485:
            java.lang.String r0 = "onSeekBarChanged"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04b1
            java.lang.String r0 = "onSeekBarChanged"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.Class r1 = r30.getClass()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "setOnSeekBarChangeListener"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x05fc }
            java.lang.Class<android.widget.SeekBar$OnSeekBarChangeListener> r5 = android.widget.SeekBar.OnSeekBarChangeListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x05fc }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x05fc }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.InflateView$15 r3 = new in.juspay.hypersdk.core.InflateView$15     // Catch:{ Exception -> 0x05fc }
            r3.<init>(r0)     // Catch:{ Exception -> 0x05fc }
            r2[r6] = r3     // Catch:{ Exception -> 0x05fc }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x05fc }
        L_0x04b1:
            java.lang.String r0 = "runInUI"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04cc
            java.lang.String r3 = r9.getString(r8)     // Catch:{ Exception -> 0x05fc }
            r1 = r27
            r2 = r30
            r4 = r31
            r5 = r32
            r6 = r33
            java.lang.Object r0 = r1.parseAndRunPipe(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x05fc }
            r10 = r0
        L_0x04cc:
            java.lang.String r0 = "onStateChanged"
            boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04e4
            boolean r0 = r10 instanceof in.juspay.hypersdk.mystique.BottomSheetLayout     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04e4
            r0 = r10
            in.juspay.hypersdk.mystique.BottomSheetLayout r0 = (in.juspay.hypersdk.mystique.BottomSheetLayout) r0     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DuiCallback r1 = r7.duiCallback     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r9.getString(r8)     // Catch:{ Exception -> 0x05fc }
            r0.setStateChangeCallback(r1, r2)     // Catch:{ Exception -> 0x05fc }
        L_0x04e4:
            java.lang.String r0 = "onSlide"
            boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04fc
            boolean r0 = r10 instanceof in.juspay.hypersdk.mystique.BottomSheetLayout     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x04fc
            r0 = r10
            in.juspay.hypersdk.mystique.BottomSheetLayout r0 = (in.juspay.hypersdk.mystique.BottomSheetLayout) r0     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DuiCallback r1 = r7.duiCallback     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = r9.getString(r8)     // Catch:{ Exception -> 0x05fc }
            r0.setSlideCallback(r1, r2)     // Catch:{ Exception -> 0x05fc }
        L_0x04fc:
            java.lang.String r0 = "animation"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0512
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = "animation"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            r0.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r7.handleAnimation(r10, r0)     // Catch:{ Exception -> 0x05fc }
        L_0x0512:
            java.lang.String r0 = "afterRender"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0549
            java.lang.String r0 = "id"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r1.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "javascript:window.callUICallback('"
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "afterRender"
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x05fc }
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "', '"
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            r1.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = "');"
            r1.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            r1.addJsToWebView(r0)     // Catch:{ Exception -> 0x05fc }
        L_0x0549:
            java.lang.String r0 = "feedback"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0580
            java.lang.String r0 = "id"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fc }
            r1.<init>()     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "javascript:window.callUICallback('"
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "feedback"
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x05fc }
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r2 = "', '"
            r1.append(r2)     // Catch:{ Exception -> 0x05fc }
            r1.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = "', 'feedback');"
            r1.append(r0)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI     // Catch:{ Exception -> 0x05fc }
            r1.addJsToWebView(r0)     // Catch:{ Exception -> 0x05fc }
        L_0x0580:
            java.lang.String r0 = "secureEdit"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0619
            boolean r0 = r10 instanceof android.widget.EditText     // Catch:{ Exception -> 0x05fc }
            if (r0 == 0) goto L_0x0619
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x05fc }
            java.lang.String r1 = "secureEdit"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x05fc }
            r0.<init>(r1)     // Catch:{ Exception -> 0x05fc }
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x059c:
            int r6 = r0.length()     // Catch:{ Exception -> 0x05fc }
            if (r1 >= r6) goto L_0x05f1
            java.lang.Object r6 = r0.get(r1)     // Catch:{ Exception -> 0x05fc }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x05fc }
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x05fc }
            switch(r8) {
                case 98882: goto L_0x05d0;
                case 3059573: goto L_0x05c6;
                case 106438291: goto L_0x05bc;
                case 109400031: goto L_0x05b2;
                default: goto L_0x05b1;
            }     // Catch:{ Exception -> 0x05fc }
        L_0x05b1:
            goto L_0x05da
        L_0x05b2:
            java.lang.String r8 = "share"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x05da
            r6 = 3
            goto L_0x05db
        L_0x05bc:
            java.lang.String r8 = "paste"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x05da
            r6 = 1
            goto L_0x05db
        L_0x05c6:
            java.lang.String r8 = "copy"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x05da
            r6 = 0
            goto L_0x05db
        L_0x05d0:
            java.lang.String r8 = "cut"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x05fc }
            if (r6 == 0) goto L_0x05da
            r6 = 2
            goto L_0x05db
        L_0x05da:
            r6 = -1
        L_0x05db:
            r8 = 1
            r9 = 2
            if (r6 == 0) goto L_0x05ed
            if (r6 == r8) goto L_0x05eb
            if (r6 == r9) goto L_0x05e9
            r8 = 3
            if (r6 == r8) goto L_0x05e7
            goto L_0x05ee
        L_0x05e7:
            r4 = 1
            goto L_0x05ee
        L_0x05e9:
            r3 = 1
            goto L_0x05ee
        L_0x05eb:
            r5 = 1
            goto L_0x05ee
        L_0x05ed:
            r2 = 1
        L_0x05ee:
            int r1 = r1 + 1
            goto L_0x059c
        L_0x05f1:
            android.widget.EditText r10 = (android.widget.EditText) r10     // Catch:{ Exception -> 0x05fc }
            in.juspay.hypersdk.mystique.SecureActionCallback r0 = new in.juspay.hypersdk.mystique.SecureActionCallback     // Catch:{ Exception -> 0x05fc }
            r0.<init>(r2, r3, r4, r5)     // Catch:{ Exception -> 0x05fc }
            r10.setCustomSelectionActionModeCallback(r0)     // Catch:{ Exception -> 0x05fc }
            goto L_0x0619
        L_0x05fc:
            r0 = move-exception
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI
            in.juspay.hypersdk.mystique.ErrorCallback r1 = r1.getErrorCallback()
            java.lang.String r2 = " excep: fn__parseKeys  - "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r27.getErrorDetails()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "WARNING"
            r1.onException(r3, r2, r0)
        L_0x0619:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.parseKeys(java.lang.String, org.json.JSONObject, java.lang.Object, boolean, in.juspay.hypersdk.mystique.ListAdapter$ViewHolder, boolean):void");
    }

    public void putInState(String str, Object obj) {
        this.state.put(str, obj);
    }

    public void resetState() {
        this.state = new HashMap<>();
    }

    public void setCurrView(String str) {
        this.currView = str;
    }

    public void setCurrViewId(String str) {
        this.currViewId = str;
    }

    public void setFileOrigin(String str) {
        this.fileOrigin = str;
    }

    public void setUseAppContext(boolean z) {
        this.useAppContext = z;
    }
}
