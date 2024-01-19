package in.juspay.hypersdk.mystique;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.DuiCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationHolder {
    public static final String NAME = "name";
    public final WeakHashMap<View, HashMap<String, InlineAnimation>> animatorHashMap = new WeakHashMap<>();
    public final WeakHashMap<View, CallbackHolder> callbackHashMap = new WeakHashMap<>();
    public final float density;
    public final DuiCallback duiCallback;

    public class CallbackHolder {
        public static final String ON_ANIMATION_END = "onAnimationEnd";
        public static final String ON_ANIMATION_START = "onAnimationStart";
        public static final String ON_ANIMATION_UPDATE = "onAnimationUpdate";
        public String onEnd;
        public String onStart;
        public String onUpdate;

        public CallbackHolder() {
        }

        public String getOnEnd() {
            return this.onEnd;
        }

        public String getOnStart() {
            return this.onStart;
        }

        public String getOnUpdate() {
            return this.onUpdate;
        }

        public void updateCallbacks(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.onEnd = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_END, this.onEnd);
                this.onStart = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_START, this.onStart);
                this.onUpdate = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_UPDATE, this.onUpdate);
            }
        }
    }

    public class InlineAnimation {
        public static final String DELAY = "delay";
        public static final String DURATION = "duration";
        public static final String FROM_ALPHA = "fromAlpha";
        public static final String FROM_ROTATION = "fromRotation";
        public static final String FROM_ROTATION_X = "fromRotationX";
        public static final String FROM_ROTATION_Y = "fromRotationY";
        public static final String FROM_SCALE_X = "fromScaleX";
        public static final String FROM_SCALE_Y = "fromScaleY";
        public static final String FROM_X = "fromX";
        public static final String FROM_Y = "fromY";
        public static final String INTERPOLATOR = "interpolator";
        public static final String REPEAT_COUNT = "repeatCount";
        public static final String REPEAT_MODE = "repeatMode";
        public static final String TAG = "tag";
        public static final String TO_ALPHA = "toAlpha";
        public static final String TO_ROTATION = "toRotation";
        public static final String TO_ROTATION_X = "toRotationX";
        public static final String TO_ROTATION_Y = "toRotationY";
        public static final String TO_SCALE_X = "toScaleX";
        public static final String TO_SCALE_Y = "toScaleY";
        public static final String TO_X = "toX";
        public static final String TO_Y = "toY";
        public ObjectAnimator animator;
        public ArrayList<PropertyValuesHolder> holders = new ArrayList<>();
        public JSONObject newProperties;
        public JSONObject properties;
        public WeakReference<View> viewRef;

        public InlineAnimation(JSONObject jSONObject, View view) {
            this.viewRef = new WeakReference<>(view);
            this.properties = jSONObject;
        }

        private void createAnimator() {
            if (this.viewRef.get() != null) {
                View view = (View) this.viewRef.get();
                this.holders = new ArrayList<>();
                ObjectAnimator objectAnimator = new ObjectAnimator();
                this.animator = objectAnimator;
                objectAnimator.setTarget(view);
                this.animator.setInterpolator(getInterpolator());
                this.animator.setDuration((long) ((int) AnimationHolder.this.getFloat(this.properties, DURATION, 0.0f, 1.0f)));
                this.animator.setStartDelay((long) ((int) AnimationHolder.this.getFloat(this.properties, DELAY, 0.0f, 1.0f)));
                this.animator.setRepeatCount((int) AnimationHolder.this.getFloat(this.properties, REPEAT_COUNT, 0.0f, 1.0f));
                if (this.properties.has(REPEAT_MODE)) {
                    this.animator.setRepeatMode("reverse".equals(AnimationHolder.this.getString(this.properties, REPEAT_MODE, null)) ? 2 : 1);
                }
                createPropertyHolder(View.ALPHA, view.getAlpha(), FROM_ALPHA, TO_ALPHA);
                createPropertyHolder(View.ROTATION, view.getRotation(), FROM_ROTATION, TO_ROTATION);
                createPropertyHolder(View.ROTATION_X, view.getRotationX(), FROM_ROTATION_X, TO_ROTATION_X);
                createPropertyHolder(View.ROTATION_Y, view.getRotationY(), FROM_ROTATION_Y, TO_ROTATION_Y);
                createPropertyHolder(View.SCALE_X, view.getScaleX(), FROM_SCALE_X, TO_SCALE_X);
                createPropertyHolder(View.SCALE_Y, view.getScaleY(), FROM_SCALE_Y, TO_SCALE_Y);
                createPropertyHolder(View.TRANSLATION_X, view.getTranslationX(), FROM_X, TO_X);
                createPropertyHolder(View.TRANSLATION_Y, view.getTranslationY(), FROM_Y, TO_Y);
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.holders.size()];
                for (int i = 0; i < this.holders.size(); i++) {
                    propertyValuesHolderArr[i] = this.holders.get(i);
                }
                this.animator.setValues(propertyValuesHolderArr);
            }
        }

        private void createPropertyHolder(Property<View, Float> property, float f2, String... strArr) {
            if (AnimationHolder.this.hasOneKeyAtleast(this.properties, strArr)) {
                float access$600 = (property == View.TRANSLATION_Y || property == View.TRANSLATION_X) ? AnimationHolder.this.density : 1.0f;
                float[] fArr = new float[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    fArr[i] = AnimationHolder.this.getFloat(this.properties, strArr[i], f2, access$600);
                }
                this.holders.add(PropertyValuesHolder.ofFloat(property, fArr));
            }
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.view.animation.Interpolator getInterpolator() {
            /*
                r8 = this;
                in.juspay.hypersdk.mystique.AnimationHolder r0 = in.juspay.hypersdk.mystique.AnimationHolder.this
                org.json.JSONObject r1 = r8.properties
                java.lang.String r2 = "interpolator"
                java.lang.String r3 = "linear"
                java.lang.String r0 = r0.getString(r1, r2, r3)
                int r1 = r0.hashCode()
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                switch(r1) {
                    case -1965056864: goto L_0x0036;
                    case -1383205240: goto L_0x002c;
                    case -1310315117: goto L_0x0022;
                    case 1360213211: goto L_0x0018;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0040
            L_0x0018:
                java.lang.String r1 = "easeinout"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0040
                r1 = 3
                goto L_0x0041
            L_0x0022:
                java.lang.String r1 = "easein"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0040
                r1 = 1
                goto L_0x0041
            L_0x002c:
                java.lang.String r1 = "bounce"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0040
                r1 = 0
                goto L_0x0041
            L_0x0036:
                java.lang.String r1 = "easeout"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0040
                r1 = 2
                goto L_0x0041
            L_0x0040:
                r1 = -1
            L_0x0041:
                if (r1 == 0) goto L_0x0090
                if (r1 == r5) goto L_0x008a
                if (r1 == r4) goto L_0x0084
                if (r1 == r3) goto L_0x007e
                java.lang.String r1 = ","
                boolean r6 = r0.contains(r1)
                if (r6 == 0) goto L_0x0078
                java.lang.String[] r0 = r0.split(r1)
                r1 = 4
                float[] r1 = new float[r1]
                r1 = {0, 0, 0, 0} // fill-array
                r6 = 0
            L_0x005c:
                int r7 = r0.length
                if (r6 >= r7) goto L_0x006a
                r7 = r0[r6]
                float r7 = java.lang.Float.parseFloat(r7)
                r1[r6] = r7
                int r6 = r6 + 1
                goto L_0x005c
            L_0x006a:
                android.view.animation.PathInterpolator r0 = new android.view.animation.PathInterpolator
                r2 = r1[r2]
                r5 = r1[r5]
                r4 = r1[r4]
                r1 = r1[r3]
                r0.<init>(r2, r5, r4, r1)
                return r0
            L_0x0078:
                android.view.animation.LinearInterpolator r0 = new android.view.animation.LinearInterpolator
                r0.<init>()
                return r0
            L_0x007e:
                android.view.animation.AccelerateDecelerateInterpolator r0 = new android.view.animation.AccelerateDecelerateInterpolator
                r0.<init>()
                return r0
            L_0x0084:
                android.view.animation.DecelerateInterpolator r0 = new android.view.animation.DecelerateInterpolator
                r0.<init>()
                return r0
            L_0x008a:
                android.view.animation.AccelerateInterpolator r0 = new android.view.animation.AccelerateInterpolator
                r0.<init>()
                return r0
            L_0x0090:
                android.view.animation.BounceInterpolator r0 = new android.view.animation.BounceInterpolator
                r0.<init>()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation.getInterpolator():android.view.animation.Interpolator");
        }

        private boolean isSame(JSONObject jSONObject) {
            ArrayList access$100 = AnimationHolder.this.getJSONKeys(this.properties);
            Iterator it = AnimationHolder.this.getJSONKeys(jSONObject).iterator();
            while (true) {
                boolean z = false;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    if (!access$100.contains(str) || !AnimationHolder.this.getString(this.properties, str, "").equals(AnimationHolder.this.getString(jSONObject, str, null))) {
                        return false;
                    }
                    access$100.remove(str);
                } else {
                    if (access$100.size() == 0) {
                        z = true;
                    }
                    return z;
                }
            }
        }

        private void resetAnimation() {
            resetProperty(View.ALPHA, 1.0f, FROM_ALPHA, TO_ALPHA);
            resetProperty(View.ROTATION, 0.0f, FROM_ROTATION, TO_ROTATION);
            resetProperty(View.ROTATION_X, 0.0f, FROM_ROTATION_X, TO_ROTATION_X);
            resetProperty(View.ROTATION_Y, 0.0f, FROM_ROTATION_Y, TO_ROTATION_Y);
            resetProperty(View.SCALE_X, 1.0f, FROM_SCALE_X, TO_SCALE_X);
            resetProperty(View.SCALE_Y, 1.0f, FROM_SCALE_Y, TO_SCALE_Y);
            resetProperty(View.TRANSLATION_X, 0.0f, FROM_X, TO_X);
            resetProperty(View.TRANSLATION_Y, 0.0f, FROM_Y, TO_Y);
        }

        private void resetProperty(Property<View, Float> property, float f2, String... strArr) {
            if (AnimationHolder.this.hasOneKeyAtleast(this.properties, strArr)) {
                JSONObject jSONObject = this.newProperties;
                if (jSONObject == null || !AnimationHolder.this.hasOneKeyAtleast(jSONObject, strArr)) {
                    property.set(this.viewRef.get(), Float.valueOf(f2));
                }
            }
        }

        private void setEventListeners() {
            if (AnimationHolder.this.duiCallback != null) {
                final CallbackHolder callbackHolder = (CallbackHolder) AnimationHolder.this.callbackHashMap.get(this.viewRef.get());
                if (!(callbackHolder.getOnEnd() == null && callbackHolder.getOnStart() == null)) {
                    this.animator.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (callbackHolder.getOnEnd() != null) {
                                DuiCallback access$200 = AnimationHolder.this.duiCallback;
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                                outline73.append(callbackHolder.getOnEnd());
                                outline73.append("','");
                                outline73.append(InlineAnimation.this.getTag());
                                outline73.append("');");
                                access$200.addJsToWebView(outline73.toString());
                            }
                            animator.removeListener(this);
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                            if (callbackHolder.getOnStart() != null) {
                                DuiCallback access$200 = AnimationHolder.this.duiCallback;
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                                outline73.append(callbackHolder.getOnStart());
                                outline73.append("','");
                                outline73.append(InlineAnimation.this.getTag());
                                outline73.append("');");
                                access$200.addJsToWebView(outline73.toString());
                            }
                        }
                    });
                }
            }
        }

        public String getName() {
            return AnimationHolder.this.getString(this.properties, "name", "");
        }

        public String getTag() {
            return AnimationHolder.this.getString(this.properties, TAG, "untagged");
        }

        public void remove() {
            stop();
            resetAnimation();
        }

        public void start() {
            createAnimator();
            setEventListeners();
            this.animator.start();
        }

        public void stop() {
            if (this.animator.isRunning()) {
                this.animator.cancel();
            }
        }

        public void update(JSONObject jSONObject, Boolean bool) {
            if (bool.booleanValue() || !isSame(jSONObject)) {
                stop();
                this.newProperties = jSONObject;
                resetAnimation();
                this.newProperties = null;
                this.properties = jSONObject;
                start();
            }
        }
    }

    public AnimationHolder(DuiCallback duiCallback2, float f2) {
        this.density = f2;
        this.duiCallback = duiCallback2;
    }

    private void assertView(Object obj) {
        if (!(obj instanceof View)) {
            throw new Error("Instance object is not a view");
        }
    }

    /* access modifiers changed from: private */
    public float getFloat(JSONObject jSONObject, String str, float f2, float f3) {
        try {
            return (float) (((double) f3) * jSONObject.getDouble(str));
        } catch (JSONException unused) {
            return f2;
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<String> getJSONKeys(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        ArrayList<String> arrayList = new ArrayList<>();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    private JSONObject getJSONObject(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    /* access modifiers changed from: private */
    public boolean hasOneKeyAtleast(JSONObject jSONObject, String... strArr) {
        for (String has : strArr) {
            if (jSONObject.has(has)) {
                return true;
            }
        }
        return false;
    }

    private void setupAnimation(View view, JSONArray jSONArray, Boolean bool) {
        HashMap hashMap = this.animatorHashMap.get(view);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.animatorHashMap.put(view, hashMap);
        }
        HashMap hashMap2 = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = getJSONObject(jSONArray, i);
            if (jSONObject != null) {
                String string = getString(jSONObject, "name", "");
                if (hashMap.containsKey(string)) {
                    ((InlineAnimation) hashMap.get(string)).update(jSONObject, bool);
                } else {
                    InlineAnimation inlineAnimation = new InlineAnimation(jSONObject, view);
                    inlineAnimation.start();
                    hashMap.put(string, inlineAnimation);
                }
                hashMap2.put(string, Boolean.TRUE);
            }
        }
        Iterator it = new ArrayList(hashMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashMap2.containsKey(str)) {
                ((InlineAnimation) hashMap.get(str)).remove();
                hashMap.remove(str);
            }
        }
    }

    private Boolean toResetAnimation(JSONObject jSONObject) {
        if (!jSONObject.has("resetAnimation")) {
            return Boolean.FALSE;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean("resetAnimation"));
        } catch (JSONException unused) {
            return Boolean.FALSE;
        }
    }

    private void updateViewCallbacks(View view, JSONObject jSONObject) {
        CallbackHolder callbackHolder = this.callbackHashMap.get(view);
        if (callbackHolder == null) {
            callbackHolder = new CallbackHolder();
        }
        callbackHolder.updateCallbacks(jSONObject);
        this.callbackHashMap.put(view, callbackHolder);
    }

    public void applyAnimation(Object obj, JSONArray jSONArray, JSONObject jSONObject) {
        if (obj instanceof View) {
            assertView(obj);
            View view = (View) obj;
            updateViewCallbacks(view, jSONObject);
            setupAnimation(view, jSONArray, toResetAnimation(jSONObject));
        }
    }
}
