package androidx.constraintlayout.motion.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class KeyTrigger extends Key {
    public RectF mCollisionRect = new RectF();
    public String mCross = null;
    public int mCurveFit = -1;
    public boolean mFireCrossReset = true;
    public float mFireLastPos;
    public boolean mFireNegativeReset = true;
    public boolean mFirePositiveReset = true;
    public float mFireThreshold = Float.NaN;
    public HashMap<String, Method> mMethodHashMap = new HashMap<>();
    public String mNegativeCross = null;
    public String mPositiveCross = null;
    public boolean mPostLayout = false;
    public RectF mTargetRect = new RectF();
    public int mTriggerCollisionId = -1;
    public View mTriggerCollisionView = null;
    public int mTriggerID = -1;
    public int mTriggerReceiver = -1;
    public float mTriggerSlack = 0.1f;
    public int mViewTransitionOnCross = -1;
    public int mViewTransitionOnNegativeCross = -1;
    public int mViewTransitionOnPositiveCross = -1;

    public static class Loader {
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R$styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R$styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R$styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R$styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTrigger.mNegativeCross = typedArray.getString(index);
                        break;
                    case 2:
                        keyTrigger.mPositiveCross = typedArray.getString(index);
                        break;
                    case 4:
                        keyTrigger.mCross = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        break;
                    case 6:
                        keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        break;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        keyTrigger.mFireThreshold = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        break;
                    case 10:
                        keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        break;
                    case 11:
                        keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                    case 12:
                        keyTrigger.mViewTransitionOnCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnCross);
                        break;
                    case 13:
                        keyTrigger.mViewTransitionOnNegativeCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnNegativeCross);
                        break;
                    case 14:
                        keyTrigger.mViewTransitionOnPositiveCross = typedArray.getResourceId(index, keyTrigger.mViewTransitionOnPositiveCross);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r12, android.view.View r13) {
        /*
            r11 = this;
            int r0 = r11.mTriggerCollisionId
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0061
            android.view.View r0 = r11.mTriggerCollisionView
            if (r0 != 0) goto L_0x0019
            android.view.ViewParent r0 = r13.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r4 = r11.mTriggerCollisionId
            android.view.View r0 = r0.findViewById(r4)
            r11.mTriggerCollisionView = r0
        L_0x0019:
            android.graphics.RectF r0 = r11.mCollisionRect
            android.view.View r4 = r11.mTriggerCollisionView
            boolean r5 = r11.mPostLayout
            r11.setUpRect(r0, r4, r5)
            android.graphics.RectF r0 = r11.mTargetRect
            boolean r4 = r11.mPostLayout
            r11.setUpRect(r0, r13, r4)
            android.graphics.RectF r0 = r11.mCollisionRect
            android.graphics.RectF r4 = r11.mTargetRect
            boolean r0 = r0.intersect(r4)
            if (r0 == 0) goto L_0x004b
            boolean r0 = r11.mFireCrossReset
            if (r0 == 0) goto L_0x003b
            r11.mFireCrossReset = r2
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            boolean r4 = r11.mFirePositiveReset
            if (r4 == 0) goto L_0x0044
            r11.mFirePositiveReset = r2
            r4 = 1
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            r11.mFireNegativeReset = r3
            r5 = r4
            r4 = 0
            goto L_0x00e2
        L_0x004b:
            boolean r0 = r11.mFireCrossReset
            if (r0 != 0) goto L_0x0053
            r11.mFireCrossReset = r3
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            boolean r4 = r11.mFireNegativeReset
            if (r4 == 0) goto L_0x005c
            r11.mFireNegativeReset = r2
            r4 = 1
            goto L_0x005d
        L_0x005c:
            r4 = 0
        L_0x005d:
            r11.mFirePositiveReset = r3
            goto L_0x00e1
        L_0x0061:
            boolean r0 = r11.mFireCrossReset
            r4 = 0
            if (r0 == 0) goto L_0x0077
            float r0 = r11.mFireThreshold
            float r5 = r12 - r0
            float r6 = r11.mFireLastPos
            float r6 = r6 - r0
            float r6 = r6 * r5
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0087
            r11.mFireCrossReset = r2
            r0 = 1
            goto L_0x0088
        L_0x0077:
            float r0 = r11.mFireThreshold
            float r0 = r12 - r0
            float r0 = java.lang.Math.abs(r0)
            float r5 = r11.mTriggerSlack
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r11.mFireCrossReset = r3
        L_0x0087:
            r0 = 0
        L_0x0088:
            boolean r5 = r11.mFireNegativeReset
            if (r5 == 0) goto L_0x00a1
            float r5 = r11.mFireThreshold
            float r6 = r12 - r5
            float r7 = r11.mFireLastPos
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00b1
            int r5 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00b1
            r11.mFireNegativeReset = r2
            r5 = 1
            goto L_0x00b2
        L_0x00a1:
            float r5 = r11.mFireThreshold
            float r5 = r12 - r5
            float r5 = java.lang.Math.abs(r5)
            float r6 = r11.mTriggerSlack
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b1
            r11.mFireNegativeReset = r3
        L_0x00b1:
            r5 = 0
        L_0x00b2:
            boolean r6 = r11.mFirePositiveReset
            if (r6 == 0) goto L_0x00d0
            float r6 = r11.mFireThreshold
            float r7 = r12 - r6
            float r8 = r11.mFireLastPos
            float r8 = r8 - r6
            float r8 = r8 * r7
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00cb
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00cb
            r11.mFirePositiveReset = r2
            r4 = 1
            goto L_0x00cc
        L_0x00cb:
            r4 = 0
        L_0x00cc:
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00e2
        L_0x00d0:
            float r4 = r11.mFireThreshold
            float r4 = r12 - r4
            float r4 = java.lang.Math.abs(r4)
            float r6 = r11.mTriggerSlack
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e0
            r11.mFirePositiveReset = r3
        L_0x00e0:
            r4 = r5
        L_0x00e1:
            r5 = 0
        L_0x00e2:
            r11.mFireLastPos = r12
            if (r4 != 0) goto L_0x00ea
            if (r0 != 0) goto L_0x00ea
            if (r5 == 0) goto L_0x0111
        L_0x00ea:
            android.view.ViewParent r6 = r13.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r6 = (androidx.constraintlayout.motion.widget.MotionLayout) r6
            int r7 = r11.mTriggerID
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener r8 = r6.mTransitionListener
            if (r8 == 0) goto L_0x00f9
            r8.onTransitionTrigger(r6, r7, r5, r12)
        L_0x00f9:
            java.util.concurrent.CopyOnWriteArrayList<androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener> r8 = r6.mTransitionListeners
            if (r8 == 0) goto L_0x0111
            java.util.Iterator r8 = r8.iterator()
        L_0x0101:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0111
            java.lang.Object r9 = r8.next()
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener r9 = (androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener) r9
            r9.onTransitionTrigger(r6, r7, r5, r12)
            goto L_0x0101
        L_0x0111:
            int r12 = r11.mTriggerReceiver
            if (r12 != r1) goto L_0x0117
            r12 = r13
            goto L_0x0123
        L_0x0117:
            android.view.ViewParent r12 = r13.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r12 = (androidx.constraintlayout.motion.widget.MotionLayout) r12
            int r6 = r11.mTriggerReceiver
            android.view.View r12 = r12.findViewById(r6)
        L_0x0123:
            if (r4 == 0) goto L_0x013f
            java.lang.String r4 = r11.mNegativeCross
            if (r4 == 0) goto L_0x012c
            r11.fire(r4, r12)
        L_0x012c:
            int r4 = r11.mViewTransitionOnNegativeCross
            if (r4 == r1) goto L_0x013f
            android.view.ViewParent r4 = r13.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = (androidx.constraintlayout.motion.widget.MotionLayout) r4
            int r6 = r11.mViewTransitionOnNegativeCross
            android.view.View[] r7 = new android.view.View[r3]
            r7[r2] = r12
            r4.viewTransition(r6, r7)
        L_0x013f:
            if (r5 == 0) goto L_0x015b
            java.lang.String r4 = r11.mPositiveCross
            if (r4 == 0) goto L_0x0148
            r11.fire(r4, r12)
        L_0x0148:
            int r4 = r11.mViewTransitionOnPositiveCross
            if (r4 == r1) goto L_0x015b
            android.view.ViewParent r4 = r13.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = (androidx.constraintlayout.motion.widget.MotionLayout) r4
            int r5 = r11.mViewTransitionOnPositiveCross
            android.view.View[] r6 = new android.view.View[r3]
            r6[r2] = r12
            r4.viewTransition(r5, r6)
        L_0x015b:
            if (r0 == 0) goto L_0x0177
            java.lang.String r0 = r11.mCross
            if (r0 == 0) goto L_0x0164
            r11.fire(r0, r12)
        L_0x0164:
            int r0 = r11.mViewTransitionOnCross
            if (r0 == r1) goto L_0x0177
            android.view.ViewParent r13 = r13.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r13 = (androidx.constraintlayout.motion.widget.MotionLayout) r13
            int r0 = r11.mViewTransitionOnCross
            android.view.View[] r1 = new android.view.View[r3]
            r1[r2] = r12
            r13.viewTransition(r0, r1)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    public final void fire(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(".")) {
                boolean z = str.length() == 1;
                if (!z) {
                    str = str.substring(1).toLowerCase(Locale.ROOT);
                }
                for (String next : this.mCustomConstraints.keySet()) {
                    String lowerCase = next.toLowerCase(Locale.ROOT);
                    if (z || lowerCase.matches(str)) {
                        ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next);
                        if (constraintAttribute != null) {
                            Class<?> cls = view.getClass();
                            String str2 = constraintAttribute.mName;
                            if (!constraintAttribute.mMethod) {
                                str2 = GeneratedOutlineSupport.outline50("set", str2);
                            }
                            try {
                                switch (constraintAttribute.mType.ordinal()) {
                                    case 0:
                                    case 7:
                                        cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.mIntegerValue)});
                                        break;
                                    case 1:
                                        cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.mFloatValue)});
                                        break;
                                    case 2:
                                        cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.mColorValue)});
                                        break;
                                    case 3:
                                        Method method2 = cls.getMethod(str2, new Class[]{Drawable.class});
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(constraintAttribute.mColorValue);
                                        method2.invoke(view, new Object[]{colorDrawable});
                                        break;
                                    case 4:
                                        cls.getMethod(str2, new Class[]{CharSequence.class}).invoke(view, new Object[]{constraintAttribute.mStringValue});
                                        break;
                                    case 5:
                                        cls.getMethod(str2, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(constraintAttribute.mBooleanValue)});
                                        break;
                                    case 6:
                                        cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.mFloatValue)});
                                        break;
                                }
                            } catch (NoSuchMethodException e2) {
                                e2.getMessage();
                                cls.getName();
                            } catch (IllegalAccessException e3) {
                                cls.getName();
                                e3.printStackTrace();
                            } catch (InvocationTargetException e4) {
                                cls.getName();
                                e4.printStackTrace();
                            }
                        }
                    }
                }
                return;
            }
            if (this.mMethodHashMap.containsKey(str)) {
                method = this.mMethodHashMap.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.mMethodHashMap.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.mMethodHashMap.put(str, null);
                    view.getClass().getSimpleName();
                    b.getName(view);
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                view.getClass().getSimpleName();
                b.getName(view);
            }
        }
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger));
    }

    public final void setUpRect(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public Key clone() {
        KeyTrigger keyTrigger = new KeyTrigger();
        super.copy(this);
        keyTrigger.mCurveFit = this.mCurveFit;
        keyTrigger.mCross = this.mCross;
        keyTrigger.mTriggerReceiver = this.mTriggerReceiver;
        keyTrigger.mNegativeCross = this.mNegativeCross;
        keyTrigger.mPositiveCross = this.mPositiveCross;
        keyTrigger.mTriggerID = this.mTriggerID;
        keyTrigger.mTriggerCollisionId = this.mTriggerCollisionId;
        keyTrigger.mTriggerCollisionView = this.mTriggerCollisionView;
        keyTrigger.mTriggerSlack = this.mTriggerSlack;
        keyTrigger.mFireCrossReset = this.mFireCrossReset;
        keyTrigger.mFireNegativeReset = this.mFireNegativeReset;
        keyTrigger.mFirePositiveReset = this.mFirePositiveReset;
        keyTrigger.mFireThreshold = this.mFireThreshold;
        keyTrigger.mFireLastPos = this.mFireLastPos;
        keyTrigger.mPostLayout = this.mPostLayout;
        keyTrigger.mCollisionRect = this.mCollisionRect;
        keyTrigger.mTargetRect = this.mTargetRect;
        keyTrigger.mMethodHashMap = this.mMethodHashMap;
        return keyTrigger;
    }
}
