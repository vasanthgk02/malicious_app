package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import org.xmlpull.v1.XmlPullParser;

public class TouchResponse {
    public static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public float[] mAnchorDpDt = new float[2];
    public int mAutoCompleteMode = 0;
    public float mDragScale = 1.0f;
    public boolean mDragStarted = false;
    public float mDragThreshold = 10.0f;
    public int mFlags = 0;
    public boolean mIsRotateMode = false;
    public float mLastTouchX;
    public float mLastTouchY;
    public int mLimitBoundsTo = -1;
    public float mMaxAcceleration = 1.2f;
    public float mMaxVelocity = 4.0f;
    public final MotionLayout mMotionLayout;
    public boolean mMoveWhenScrollAtTop = true;
    public int mOnTouchUp = 0;
    public float mRotateCenterX = 0.5f;
    public float mRotateCenterY = 0.5f;
    public int mRotationCenterId = -1;
    public int mSpringBoundary = 0;
    public float mSpringDamping = 10.0f;
    public float mSpringMass = 1.0f;
    public float mSpringStiffness = Float.NaN;
    public float mSpringStopThreshold = Float.NaN;
    public int[] mTempLoc = new int[2];
    public int mTouchAnchorId = -1;
    public int mTouchAnchorSide = 0;
    public float mTouchAnchorX = 0.5f;
    public float mTouchAnchorY = 0.5f;
    public float mTouchDirectionX = 0.0f;
    public float mTouchDirectionY = 1.0f;
    public int mTouchRegionId = -1;
    public int mTouchSide = 0;

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = obtainStyledAttributes.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i2 = obtainStyledAttributes.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i2;
                float[][] fArr = TOUCH_SIDES;
                this.mTouchAnchorX = fArr[i2][0];
                this.mTouchAnchorY = fArr[i2][1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i3 = obtainStyledAttributes.getInt(index, this.mTouchSide);
                this.mTouchSide = i3;
                float[][] fArr2 = TOUCH_DIRECTION;
                if (i3 < fArr2.length) {
                    this.mTouchDirectionX = fArr2[i3][0];
                    this.mTouchDirectionY = fArr2[i3][1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.mIsRotateMode = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = obtainStyledAttributes.getFloat(index, this.mMaxVelocity);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = obtainStyledAttributes.getFloat(index, this.mMaxAcceleration);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = obtainStyledAttributes.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.mDragScale = obtainStyledAttributes.getFloat(index, this.mDragScale);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = obtainStyledAttributes.getFloat(index, this.mDragThreshold);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = obtainStyledAttributes.getResourceId(index, this.mTouchRegionId);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = obtainStyledAttributes.getInt(index, this.mOnTouchUp);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = obtainStyledAttributes.getResourceId(index, this.mRotationCenterId);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.mSpringDamping = obtainStyledAttributes.getFloat(index, this.mSpringDamping);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.mSpringMass = obtainStyledAttributes.getFloat(index, this.mSpringMass);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.mSpringStiffness = obtainStyledAttributes.getFloat(index, this.mSpringStiffness);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.mSpringStopThreshold = obtainStyledAttributes.getFloat(index, this.mSpringStopThreshold);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.mSpringBoundary = obtainStyledAttributes.getInt(index, this.mSpringBoundary);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.mAutoCompleteMode = obtainStyledAttributes.getInt(index, this.mAutoCompleteMode);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        int i = this.mLimitBoundsTo;
        if (i == -1) {
            return null;
        }
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        int i = this.mTouchRegionId;
        if (i == -1) {
            return null;
        }
        View findViewById = viewGroup.findViewById(i);
        if (findViewById == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i][0];
        this.mTouchAnchorY = fArr5[i][1];
        int i2 = this.mTouchSide;
        float[][] fArr6 = TOUCH_DIRECTION;
        if (i2 < fArr6.length) {
            this.mTouchDirectionX = fArr6[i2][0];
            this.mTouchDirectionY = fArr6[i2][1];
        }
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX)) {
            return "rotation";
        }
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
