package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationFrameCallback {
    public static final ViewProperty ALPHA = new ViewProperty("alpha") {
        public float getValue(Object obj) {
            return ((View) obj).getAlpha();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setAlpha(f2);
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty("rotation") {
        public float getValue(Object obj) {
            return ((View) obj).getRotation();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setRotation(f2);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") {
        public float getValue(Object obj) {
            return ((View) obj).getRotationX();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setRotationX(f2);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") {
        public float getValue(Object obj) {
            return ((View) obj).getRotationY();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setRotationY(f2);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") {
        public float getValue(Object obj) {
            return ((View) obj).getScaleX();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setScaleX(f2);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") {
        public float getValue(Object obj) {
            return ((View) obj).getScaleY();
        }

        public void setValue(Object obj, float f2) {
            ((View) obj).setScaleY(f2);
        }
    };
    public final ArrayList<OnAnimationEndListener> mEndListeners = new ArrayList<>();
    public long mLastFrameTime = 0;
    public float mMaxValue = Float.MAX_VALUE;
    public float mMinValue = -3.4028235E38f;
    public float mMinVisibleChange;
    public final FloatPropertyCompat mProperty;
    public boolean mRunning = false;
    public boolean mStartValueIsSet = false;
    public final Object mTarget;
    public final ArrayList<OnAnimationUpdateListener> mUpdateListeners = new ArrayList<>();
    public float mValue = Float.MAX_VALUE;
    public float mVelocity = 0.0f;

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1  reason: invalid class name */
    public static class AnonymousClass1 extends ViewProperty {
    }

    public static class MassState {
        public float mValue;
        public float mVelocity;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f2, float f3);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f2, float f3);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public ViewProperty(String str, AnonymousClass1 r2) {
            super(str);
        }
    }

    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = 0.00390625f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }

    public static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    public boolean doAnimationFrame(long j) {
        long j2 = j;
        long j3 = this.mLastFrameTime;
        if (j3 == 0) {
            this.mLastFrameTime = j2;
            setPropertyValue(this.mValue);
            return false;
        }
        long j4 = j2 - j3;
        this.mLastFrameTime = j2;
        SpringAnimation springAnimation = (SpringAnimation) this;
        boolean z = true;
        if (springAnimation.mEndRequested) {
            float f2 = springAnimation.mPendingPosition;
            if (f2 != Float.MAX_VALUE) {
                springAnimation.mSpring.mFinalPosition = (double) f2;
                springAnimation.mPendingPosition = Float.MAX_VALUE;
            }
            springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
            springAnimation.mVelocity = 0.0f;
            springAnimation.mEndRequested = false;
        } else {
            if (springAnimation.mPendingPosition != Float.MAX_VALUE) {
                SpringForce springForce = springAnimation.mSpring;
                double d2 = springForce.mFinalPosition;
                long j5 = j4 / 2;
                MassState updateValues = springForce.updateValues((double) springAnimation.mValue, (double) springAnimation.mVelocity, j5);
                SpringForce springForce2 = springAnimation.mSpring;
                springForce2.mFinalPosition = (double) springAnimation.mPendingPosition;
                springAnimation.mPendingPosition = Float.MAX_VALUE;
                MassState updateValues2 = springForce2.updateValues((double) updateValues.mValue, (double) updateValues.mVelocity, j5);
                springAnimation.mValue = updateValues2.mValue;
                springAnimation.mVelocity = updateValues2.mVelocity;
            } else {
                MassState updateValues3 = springAnimation.mSpring.updateValues((double) springAnimation.mValue, (double) springAnimation.mVelocity, j4);
                springAnimation.mValue = updateValues3.mValue;
                springAnimation.mVelocity = updateValues3.mVelocity;
            }
            float max = Math.max(springAnimation.mValue, springAnimation.mMinValue);
            springAnimation.mValue = max;
            float min = Math.min(max, springAnimation.mMaxValue);
            springAnimation.mValue = min;
            float f3 = springAnimation.mVelocity;
            SpringForce springForce3 = springAnimation.mSpring;
            if (springForce3 != null) {
                if (((double) Math.abs(f3)) < springForce3.mVelocityThreshold && ((double) Math.abs(min - ((float) springForce3.mFinalPosition))) < springForce3.mValueThreshold) {
                    springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                    springAnimation.mVelocity = 0.0f;
                } else {
                    z = false;
                }
            } else {
                throw null;
            }
        }
        float min2 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min2;
        float max2 = Math.max(min2, this.mMinValue);
        this.mValue = max2;
        setPropertyValue(max2);
        if (z) {
            endAnimationInternal(false);
        }
        return z;
    }

    public final void endAnimationInternal(boolean z) {
        this.mRunning = false;
        AnimationHandler instance = AnimationHandler.getInstance();
        instance.mDelayedCallbackStartTime.remove(this);
        int indexOf = instance.mAnimationCallbacks.indexOf(this);
        if (indexOf >= 0) {
            instance.mAnimationCallbacks.set(indexOf, null);
            instance.mListDirty = true;
        }
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    public void setPropertyValue(float f2) {
        this.mProperty.setValue(this.mTarget, f2);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }
}
