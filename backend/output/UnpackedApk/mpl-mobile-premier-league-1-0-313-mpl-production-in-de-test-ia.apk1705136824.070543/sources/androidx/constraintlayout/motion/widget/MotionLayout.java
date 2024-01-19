package androidx.constraintlayout.motion.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.WidgetContainer;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene.Transition;
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick;
import androidx.constraintlayout.motion.widget.ViewTransition.Animate;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import androidx.constraintlayout.widget.StateSet.State;
import androidx.constraintlayout.widget.StateSet.Variant;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean IS_IN_EDIT_MODE;
    public float lastPos;
    public float lastY;
    public long mAnimationStartTime = 0;
    public int mBeginState = -1;
    public RectF mBoundsCheck = new RectF();
    public int mCurrentState = -1;
    public int mDebugPath = 0;
    public DecelerateInterpolator mDecelerateLogic = new DecelerateInterpolator();
    public ArrayList<MotionHelper> mDecoratorsHelpers = null;
    public boolean mDelayedApply = false;
    public DesignTool mDesignTool;
    public DevModeDraw mDevModeDraw;
    public int mEndState = -1;
    public int mEndWrapHeight;
    public int mEndWrapWidth;
    public HashMap<View, MotionController> mFrameArrayList = new HashMap<>();
    public int mFrames = 0;
    public int mHeightMeasureMode;
    public boolean mInLayout = false;
    public boolean mInRotation = false;
    public boolean mInTransition = false;
    public boolean mInteractionEnabled = true;
    public Interpolator mInterpolator;
    public Matrix mInverseMatrix = null;
    public boolean mKeepAnimating = false;
    public KeyCache mKeyCache = new KeyCache();
    public long mLastDrawTime = -1;
    public float mLastFps = 0.0f;
    public int mLastHeightMeasureSpec = 0;
    public int mLastLayoutHeight;
    public int mLastLayoutWidth;
    public float mLastVelocity = 0.0f;
    public int mLastWidthMeasureSpec = 0;
    public float mListenerPosition = 0.0f;
    public int mListenerState = 0;
    public boolean mMeasureDuringTransition = false;
    public Model mModel = new Model();
    public boolean mNeedsFireTransitionCompleted = false;
    public Runnable mOnComplete = null;
    public ArrayList<MotionHelper> mOnHideHelpers = null;
    public ArrayList<MotionHelper> mOnShowHelpers = null;
    public float mPostInterpolationPosition;
    public HashMap<View, ViewState> mPreRotate = new HashMap<>();
    public int mPreRotateHeight;
    public int mPreRotateWidth;
    public Interpolator mProgressInterpolator = null;
    public View mRegionView = null;
    public int mRotatMode = 0;
    public MotionScene mScene;
    public int[] mScheduledTransitionTo = null;
    public int mScheduledTransitions = 0;
    public float mScrollTargetDT;
    public float mScrollTargetDX;
    public float mScrollTargetDY;
    public long mScrollTargetTime;
    public int mStartWrapHeight;
    public int mStartWrapWidth;
    public StateCache mStateCache;
    public StopLogic mStopLogic = new StopLogic();
    public Rect mTempRect = new Rect();
    public boolean mTemporalInterpolator = false;
    public ArrayList<Integer> mTransitionCompleted = new ArrayList<>();
    public float mTransitionDuration = 1.0f;
    public float mTransitionGoalPosition = 0.0f;
    public boolean mTransitionInstantly;
    public float mTransitionLastPosition = 0.0f;
    public long mTransitionLastTime;
    public TransitionListener mTransitionListener;
    public CopyOnWriteArrayList<TransitionListener> mTransitionListeners = null;
    public float mTransitionPosition = 0.0f;
    public TransitionState mTransitionState = TransitionState.UNDEFINED;
    public boolean mUndergoingMotion = false;
    public int mWidthMeasureMode;

    public class DecelerateInterpolator extends MotionInterpolator {
        public float currentP = 0.0f;
        public float initalV = 0.0f;
        public float maxA;

        public DecelerateInterpolator() {
        }

        public float getInterpolation(float f2) {
            float f3 = this.initalV;
            if (f3 > 0.0f) {
                float f4 = this.maxA;
                if (f3 / f4 < f2) {
                    f2 = f3 / f4;
                }
                MotionLayout motionLayout = MotionLayout.this;
                float f5 = this.initalV;
                float f6 = this.maxA;
                motionLayout.mLastVelocity = f5 - (f6 * f2);
                return ((f5 * f2) - (((f6 * f2) * f2) / 2.0f)) + this.currentP;
            }
            float f7 = this.maxA;
            if ((-f3) / f7 < f2) {
                f2 = (-f3) / f7;
            }
            MotionLayout motionLayout2 = MotionLayout.this;
            float f8 = this.initalV;
            float f9 = this.maxA;
            motionLayout2.mLastVelocity = (f9 * f2) + f8;
            return (((f9 * f2) * f2) / 2.0f) + (f8 * f2) + this.currentP;
        }

        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    public class DevModeDraw {
        public Rect mBounds = new Rect();
        public DashPathEffect mDashPathEffect;
        public Paint mFillPaint;
        public int mKeyFrameCount;
        public float[] mKeyFramePoints;
        public Paint mPaint;
        public Paint mPaintGraph;
        public Paint mPaintKeyframes;
        public Path mPath;
        public int[] mPathMode;
        public float[] mPoints;
        public boolean mPresentationMode = false;
        public float[] mRectangle;
        public int mShadowTranslate = 1;
        public Paint mTextPaint;

        public DevModeDraw() {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Style.STROKE);
            Paint paint2 = new Paint();
            this.mPaintKeyframes = paint2;
            paint2.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Style.STROKE);
            Paint paint3 = new Paint();
            this.mPaintGraph = paint3;
            paint3.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Style.STROKE);
            Paint paint4 = new Paint();
            this.mTextPaint = paint4;
            paint4.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint5 = new Paint();
            this.mFillPaint = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
            int i3;
            int i4;
            int i5;
            float f2;
            float f3;
            Canvas canvas2 = canvas;
            int i6 = i;
            MotionController motionController2 = motionController;
            if (i6 == 4) {
                boolean z = false;
                boolean z2 = false;
                for (int i7 = 0; i7 < this.mKeyFrameCount; i7++) {
                    if (this.mPathMode[i7] == 1) {
                        z = true;
                    }
                    if (this.mPathMode[i7] == 0) {
                        z2 = true;
                    }
                }
                if (z) {
                    drawPathRelative(canvas);
                }
                if (z2) {
                    drawPathCartesian(canvas);
                }
            }
            if (i6 == 2) {
                drawPathRelative(canvas);
            }
            if (i6 == 3) {
                drawPathCartesian(canvas);
            }
            canvas2.drawLines(this.mPoints, this.mPaint);
            View view = motionController2.mView;
            if (view != null) {
                i4 = view.getWidth();
                i3 = motionController2.mView.getHeight();
            } else {
                i4 = 0;
                i3 = 0;
            }
            int i8 = 1;
            while (i8 < i2 - 1) {
                if (i6 == 4 && this.mPathMode[i8 - 1] == 0) {
                    i5 = i8;
                } else {
                    float[] fArr = this.mKeyFramePoints;
                    int i9 = i8 * 2;
                    float f4 = fArr[i9];
                    float f5 = fArr[i9 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f4, f5 + 10.0f);
                    this.mPath.lineTo(f4 + 10.0f, f5);
                    this.mPath.lineTo(f4, f5 - 10.0f);
                    this.mPath.lineTo(f4 - 10.0f, f5);
                    this.mPath.close();
                    int i10 = i8 - 1;
                    MotionPaths motionPaths = motionController2.mMotionPaths.get(i10);
                    if (i6 == 4) {
                        int[] iArr = this.mPathMode;
                        if (iArr[i10] == 1) {
                            drawPathRelativeTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 0) {
                            drawPathCartesianTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 2) {
                            f2 = f5;
                            f3 = f4;
                            i5 = i8;
                            drawPathScreenTicks(canvas, f4 - 0.0f, f5 - 0.0f, i4, i3);
                            canvas2.drawPath(this.mPath, this.mFillPaint);
                        }
                        f2 = f5;
                        f3 = f4;
                        i5 = i8;
                        canvas2.drawPath(this.mPath, this.mFillPaint);
                    } else {
                        f2 = f5;
                        f3 = f4;
                        i5 = i8;
                    }
                    if (i6 == 2) {
                        drawPathRelativeTicks(canvas2, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == 3) {
                        drawPathCartesianTicks(canvas2, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == 6) {
                        drawPathScreenTicks(canvas, f3 - 0.0f, f2 - 0.0f, i4, i3);
                    }
                    canvas2.drawPath(this.mPath, this.mFillPaint);
                }
                i8 = i5 + 1;
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        public final void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.mPaintGraph);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.mPaintGraph);
        }

        public final void drawPathCartesianTicks(Canvas canvas, float f2, float f3) {
            Canvas canvas2 = canvas;
            float[] fArr = this.mPoints;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
            outline73.append(((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            String sb = outline73.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas2.drawText(sb, ((min2 / 2.0f) - ((float) (this.mBounds.width() / 2))) + min, f3 - 20.0f, this.mTextPaint);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.mPaintGraph);
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("");
            outline732.append(((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d))) / 100.0f);
            String sb2 = outline732.toString();
            getTextBounds(sb2, this.mTextPaint);
            canvas2.drawText(sb2, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.mPaintGraph);
        }

        public final void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        public final void drawPathRelativeTicks(Canvas canvas, float f2, float f3) {
            float f4 = f2;
            float f5 = f3;
            float[] fArr = this.mPoints;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f6 - f8), (double) (f7 - f9));
            float f10 = f8 - f6;
            float f11 = f9 - f7;
            float f12 = (((f5 - f7) * f11) + ((f4 - f6) * f10)) / (hypot * hypot);
            float f13 = f6 + (f10 * f12);
            float f14 = f7 + (f12 * f11);
            Path path = new Path();
            path.moveTo(f2, f5);
            path.lineTo(f13, f14);
            float hypot2 = (float) Math.hypot((double) (f13 - f4), (double) (f14 - f5));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
            outline73.append(((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            String sb = outline73.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas.drawTextOnPath(sb, path, (hypot2 / 2.0f) - ((float) (this.mBounds.width() / 2)), -20.0f, this.mTextPaint);
            canvas.drawLine(f4, f5, f13, f14, this.mPaintGraph);
        }

        public final void drawPathScreenTicks(Canvas canvas, float f2, float f3, int i, int i2) {
            Canvas canvas2 = canvas;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
            outline73.append(((float) ((int) (((double) (((f2 - ((float) (i / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i)))) + 0.5d))) / 100.0f);
            String sb = outline73.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas2.drawText(sb, ((f2 / 2.0f) - ((float) (this.mBounds.width() / 2))) + 0.0f, f3 - 20.0f, this.mTextPaint);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.mPaintGraph);
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("");
            outline732.append(((float) ((int) (((double) (((f3 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i2)))) + 0.5d))) / 100.0f);
            String sb2 = outline732.toString();
            getTextBounds(sb2, this.mTextPaint);
            canvas2.drawText(sb2, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    public class Model {
        public ConstraintSet mEnd = null;
        public int mEndId;
        public ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        public ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        public ConstraintSet mStart = null;
        public int mStartId;

        public Model() {
        }

        public void build() {
            int i;
            ConstraintSet constraintSet;
            float f2;
            Rect rect;
            Interpolator interpolator;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MotionLayout.this.getChildAt(i2);
                MotionController motionController = new MotionController(childAt);
                int id = childAt.getId();
                iArr[i2] = id;
                sparseArray.put(id, motionController);
                MotionLayout.this.mFrameArrayList.put(childAt, motionController);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = MotionLayout.this.getChildAt(i3);
                MotionController motionController2 = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController2 != null) {
                    if (this.mStart != null) {
                        ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            Rect access$2000 = MotionLayout.access$2000(MotionLayout.this, widget);
                            ConstraintSet constraintSet2 = this.mStart;
                            int width = MotionLayout.this.getWidth();
                            int height = MotionLayout.this.getHeight();
                            int i4 = constraintSet2.mRotate;
                            if (i4 != 0) {
                                i = i4;
                                constraintSet = constraintSet2;
                                rect = access$2000;
                                f2 = 0.0f;
                                motionController2.rotate(access$2000, motionController2.mTempRect, i, width, height);
                            } else {
                                i = i4;
                                constraintSet = constraintSet2;
                                rect = access$2000;
                                f2 = 0.0f;
                            }
                            MotionPaths motionPaths = motionController2.mStartMotionPath;
                            motionPaths.time = f2;
                            motionPaths.position = f2;
                            motionController2.readView(motionPaths);
                            motionController2.mStartMotionPath.setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
                            Constraint constraint = constraintSet.get(motionController2.mId);
                            motionController2.mStartMotionPath.applyParameters(constraint);
                            motionController2.mMotionStagger = constraint.motion.mMotionStagger;
                            motionController2.mStartPoint.setState(rect, constraintSet, i, motionController2.mId);
                            motionController2.mTransformPivotTarget = constraint.transform.transformPivotTarget;
                            Motion motion = constraint.motion;
                            motionController2.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
                            motionController2.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
                            Context context = motionController2.mView.getContext();
                            Motion motion2 = constraint.motion;
                            int i5 = motion2.mQuantizeInterpolatorType;
                            String str = motion2.mQuantizeInterpolatorString;
                            int i6 = motion2.mQuantizeInterpolatorID;
                            if (i5 == -2) {
                                interpolator = AnimationUtils.loadInterpolator(context, i6);
                            } else if (i5 == -1) {
                                interpolator = new Interpolator() {
                                    public float getInterpolation(float f2) {
                                        return (float) Easing.this.get((double) f2);
                                    }
                                };
                            } else if (i5 == 0) {
                                interpolator = new AccelerateDecelerateInterpolator();
                            } else if (i5 == 1) {
                                interpolator = new AccelerateInterpolator();
                            } else if (i5 == 2) {
                                interpolator = new android.view.animation.DecelerateInterpolator();
                            } else if (i5 == 4) {
                                interpolator = new BounceInterpolator();
                            } else if (i5 != 5) {
                                interpolator = null;
                            } else {
                                interpolator = new OvershootInterpolator();
                            }
                            motionController2.mQuantizeMotionInterpolator = interpolator;
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            b.getLocation();
                            b.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    } else {
                        MotionLayout motionLayout = MotionLayout.this;
                        if (motionLayout.mInRotation) {
                            ViewState viewState = motionLayout.mPreRotate.get(childAt2);
                            MotionLayout motionLayout2 = MotionLayout.this;
                            int i7 = motionLayout2.mRotatMode;
                            int i8 = motionLayout2.mPreRotateWidth;
                            int i9 = motionLayout2.mPreRotateHeight;
                            MotionPaths motionPaths2 = motionController2.mStartMotionPath;
                            motionPaths2.time = 0.0f;
                            motionPaths2.position = 0.0f;
                            Rect rect2 = new Rect();
                            if (i7 == 1) {
                                int i10 = viewState.left + viewState.right;
                                int i11 = ((viewState.top + viewState.bottom) + 0) / 2;
                                rect2.left = i11;
                                int i12 = i8 - ((i10 + 0) / 2);
                                rect2.top = i12;
                                rect2.right = i11 + 0;
                                rect2.bottom = i12 + 0;
                            } else if (i7 == 2) {
                                int i13 = viewState.left + viewState.right;
                                int i14 = i9 - (((viewState.top + viewState.bottom) + 0) / 2);
                                rect2.left = i14;
                                int i15 = (i13 + 0) / 2;
                                rect2.top = i15;
                                rect2.right = i14 + 0;
                                rect2.bottom = i15 + 0;
                            }
                            motionController2.mStartMotionPath.setBounds((float) rect2.left, (float) rect2.top, (float) rect2.width(), (float) rect2.height());
                            MotionConstrainedPoint motionConstrainedPoint = motionController2.mStartPoint;
                            float f3 = viewState.rotation;
                            if (motionConstrainedPoint != null) {
                                rect2.width();
                                rect2.height();
                                motionConstrainedPoint.applyParameters(childAt2);
                                motionConstrainedPoint.mPivotX = Float.NaN;
                                motionConstrainedPoint.mPivotY = Float.NaN;
                                if (i7 == 1) {
                                    motionConstrainedPoint.rotation = f3 - 90.0f;
                                } else if (i7 == 2) {
                                    motionConstrainedPoint.rotation = f3 + 90.0f;
                                }
                            } else {
                                throw null;
                            }
                        }
                    }
                    if (this.mEnd != null) {
                        ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            Rect access$20002 = MotionLayout.access$2000(MotionLayout.this, widget2);
                            ConstraintSet constraintSet3 = this.mEnd;
                            int width2 = MotionLayout.this.getWidth();
                            int height2 = MotionLayout.this.getHeight();
                            int i16 = constraintSet3.mRotate;
                            if (i16 != 0) {
                                motionController2.rotate(access$20002, motionController2.mTempRect, i16, width2, height2);
                                access$20002 = motionController2.mTempRect;
                            }
                            MotionPaths motionPaths3 = motionController2.mEndMotionPath;
                            motionPaths3.time = 1.0f;
                            motionPaths3.position = 1.0f;
                            motionController2.readView(motionPaths3);
                            motionController2.mEndMotionPath.setBounds((float) access$20002.left, (float) access$20002.top, (float) access$20002.width(), (float) access$20002.height());
                            motionController2.mEndMotionPath.applyParameters(constraintSet3.get(motionController2.mId));
                            motionController2.mEndPoint.setState(access$20002, constraintSet3, i16, motionController2.mId);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            b.getLocation();
                            b.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    }
                }
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                MotionController motionController3 = (MotionController) sparseArray.get(iArr[i17]);
                int i18 = motionController3.mStartMotionPath.mAnimateRelativeTo;
                if (i18 != -1) {
                    MotionController motionController4 = (MotionController) sparseArray.get(i18);
                    motionController3.mStartMotionPath.setupRelative(motionController4, motionController4.mStartMotionPath);
                    motionController3.mEndMotionPath.setupRelative(motionController4, motionController4.mEndMotionPath);
                }
            }
        }

        public final void computeStartEndSize(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutEnd;
                ConstraintSet constraintSet = this.mEnd;
                int i3 = (constraintSet == null || constraintSet.mRotate == 0) ? i : i2;
                ConstraintSet constraintSet2 = this.mEnd;
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, i3, (constraintSet2 == null || constraintSet2.mRotate == 0) ? i2 : i);
                ConstraintSet constraintSet3 = this.mStart;
                if (constraintSet3 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    int i4 = constraintSet3.mRotate == 0 ? i : i2;
                    if (this.mStart.mRotate == 0) {
                        i = i2;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet4 = this.mStart;
            if (constraintSet4 != null) {
                MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, constraintSet4.mRotate == 0 ? i : i2, this.mStart.mRotate == 0 ? i2 : i);
            }
            MotionLayout motionLayout4 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutEnd;
            ConstraintSet constraintSet5 = this.mEnd;
            int i5 = (constraintSet5 == null || constraintSet5.mRotate == 0) ? i : i2;
            ConstraintSet constraintSet6 = this.mEnd;
            if (constraintSet6 == null || constraintSet6.mRotate == 0) {
                i = i2;
            }
            motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i5, i);
        }

        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.mChildren.clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof Barrier) {
                    constraintWidget = new Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Placeholder) {
                    constraintWidget = new Placeholder();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.mChildren.add(constraintWidget);
                ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                if (constraintWidget2 != null) {
                    ((WidgetContainer) constraintWidget2).mChildren.remove(constraintWidget);
                    constraintWidget.reset();
                }
                constraintWidget.mParent = constraintWidgetContainer2;
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                ((ConstraintWidget) hashMap.get(next2)).copy(next2, hashMap);
            }
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.mCompanionWidget == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = arrayList.get(i);
                if (constraintWidget.mCompanionWidget == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void initFrom(ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.this.mLayoutWidget.mMeasurer);
            this.mLayoutEnd.setMeasurer(MotionLayout.this.mLayoutWidget.mMeasurer);
            this.mLayoutStart.mChildren.clear();
            this.mLayoutEnd.mChildren.clear();
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutStart);
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutEnd);
            if (((double) MotionLayout.this.mTransitionLastPosition) > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.mIsRtl = MotionLayout.this.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutStart;
            constraintWidgetContainer.mBasicMeasureSolver.updateHierarchy(constraintWidgetContainer);
            this.mLayoutEnd.mIsRtl = MotionLayout.this.isRtl();
            ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutEnd;
            constraintWidgetContainer2.mBasicMeasureSolver.updateHierarchy(constraintWidgetContainer2);
            LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.mLayoutStart.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                }
                if (layoutParams.height == -2) {
                    this.mLayoutStart.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                }
            }
        }

        public void reEvaluateState() {
            int i;
            int i2;
            MotionLayout motionLayout = MotionLayout.this;
            int i3 = motionLayout.mLastWidthMeasureSpec;
            int i4 = motionLayout.mLastHeightMeasureSpec;
            int mode = MeasureSpec.getMode(i3);
            int mode2 = MeasureSpec.getMode(i4);
            MotionLayout motionLayout2 = MotionLayout.this;
            motionLayout2.mWidthMeasureMode = mode;
            motionLayout2.mHeightMeasureMode = mode2;
            motionLayout2.getOptimizationLevel();
            computeStartEndSize(i3, i4);
            int i5 = 0;
            boolean z = true;
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                computeStartEndSize(i3, i4);
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mMeasureDuringTransition = (motionLayout3.mStartWrapWidth == motionLayout3.mEndWrapWidth && motionLayout3.mStartWrapHeight == motionLayout3.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout4 = MotionLayout.this;
            int i6 = motionLayout4.mStartWrapWidth;
            int i7 = motionLayout4.mStartWrapHeight;
            int i8 = motionLayout4.mWidthMeasureMode;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                MotionLayout motionLayout5 = MotionLayout.this;
                int i9 = motionLayout5.mStartWrapWidth;
                i = (int) ((motionLayout5.mPostInterpolationPosition * ((float) (motionLayout5.mEndWrapWidth - i9))) + ((float) i9));
            } else {
                i = i6;
            }
            int i10 = MotionLayout.this.mHeightMeasureMode;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                MotionLayout motionLayout6 = MotionLayout.this;
                int i11 = motionLayout6.mStartWrapHeight;
                i2 = (int) ((motionLayout6.mPostInterpolationPosition * ((float) (motionLayout6.mEndWrapHeight - i11))) + ((float) i11));
            } else {
                i2 = i7;
            }
            MotionLayout.this.resolveMeasuredDimension(i3, i4, i, i2, this.mLayoutStart.mWidthMeasuredTooSmall || this.mLayoutEnd.mWidthMeasuredTooSmall, this.mLayoutStart.mHeightMeasuredTooSmall || this.mLayoutEnd.mHeightMeasuredTooSmall);
            MotionLayout motionLayout7 = MotionLayout.this;
            int childCount = motionLayout7.getChildCount();
            motionLayout7.mModel.build();
            motionLayout7.mInTransition = true;
            SparseArray sparseArray = new SparseArray();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = motionLayout7.getChildAt(i12);
                sparseArray.put(childAt.getId(), motionLayout7.mFrameArrayList.get(childAt));
            }
            int width = motionLayout7.getWidth();
            int height = motionLayout7.getHeight();
            Transition transition = motionLayout7.mScene.mCurrentTransition;
            int i13 = transition != null ? transition.mPathMotionArc : -1;
            if (i13 != -1) {
                for (int i14 = 0; i14 < childCount; i14++) {
                    MotionController motionController = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i14));
                    if (motionController != null) {
                        motionController.mPathMotionArc = i13;
                    }
                }
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = new int[motionLayout7.mFrameArrayList.size()];
            int i15 = 0;
            for (int i16 = 0; i16 < childCount; i16++) {
                MotionController motionController2 = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i16));
                int i17 = motionController2.mStartMotionPath.mAnimateRelativeTo;
                if (i17 != -1) {
                    sparseBooleanArray.put(i17, true);
                    iArr[i15] = motionController2.mStartMotionPath.mAnimateRelativeTo;
                    i15++;
                }
            }
            if (motionLayout7.mDecoratorsHelpers != null) {
                for (int i18 = 0; i18 < i15; i18++) {
                    MotionController motionController3 = motionLayout7.mFrameArrayList.get(motionLayout7.findViewById(iArr[i18]));
                    if (motionController3 != null) {
                        motionLayout7.mScene.getKeyFrames(motionController3);
                    }
                }
                Iterator<MotionHelper> it = motionLayout7.mDecoratorsHelpers.iterator();
                while (it.hasNext()) {
                    it.next().onPreSetup(motionLayout7, motionLayout7.mFrameArrayList);
                }
                for (int i19 = 0; i19 < i15; i19++) {
                    MotionController motionController4 = motionLayout7.mFrameArrayList.get(motionLayout7.findViewById(iArr[i19]));
                    if (motionController4 != null) {
                        motionController4.setup(width, height, motionLayout7.getNanoTime());
                    }
                }
            } else {
                for (int i20 = 0; i20 < i15; i20++) {
                    MotionController motionController5 = motionLayout7.mFrameArrayList.get(motionLayout7.findViewById(iArr[i20]));
                    if (motionController5 != null) {
                        motionLayout7.mScene.getKeyFrames(motionController5);
                        motionController5.setup(width, height, motionLayout7.getNanoTime());
                    }
                }
            }
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt2 = motionLayout7.getChildAt(i21);
                MotionController motionController6 = motionLayout7.mFrameArrayList.get(childAt2);
                if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                    motionLayout7.mScene.getKeyFrames(motionController6);
                    motionController6.setup(width, height, motionLayout7.getNanoTime());
                }
            }
            Transition transition2 = motionLayout7.mScene.mCurrentTransition;
            float f2 = transition2 != null ? transition2.mStagger : 0.0f;
            if (f2 != 0.0f) {
                boolean z2 = ((double) f2) < 0.0d;
                float abs = Math.abs(f2);
                float f3 = -3.4028235E38f;
                float f4 = Float.MAX_VALUE;
                int i22 = 0;
                float f5 = Float.MAX_VALUE;
                float f6 = -3.4028235E38f;
                while (true) {
                    if (i22 >= childCount) {
                        z = false;
                        break;
                    }
                    MotionController motionController7 = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i22));
                    if (!Float.isNaN(motionController7.mMotionStagger)) {
                        break;
                    }
                    MotionPaths motionPaths = motionController7.mEndMotionPath;
                    float f7 = motionPaths.x;
                    float f8 = motionPaths.y;
                    float f9 = z2 ? f8 - f7 : f8 + f7;
                    f5 = Math.min(f5, f9);
                    f6 = Math.max(f6, f9);
                    i22++;
                }
                if (z) {
                    for (int i23 = 0; i23 < childCount; i23++) {
                        MotionController motionController8 = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i23));
                        if (!Float.isNaN(motionController8.mMotionStagger)) {
                            f4 = Math.min(f4, motionController8.mMotionStagger);
                            f3 = Math.max(f3, motionController8.mMotionStagger);
                        }
                    }
                    while (i5 < childCount) {
                        MotionController motionController9 = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i5));
                        if (!Float.isNaN(motionController9.mMotionStagger)) {
                            motionController9.mStaggerScale = 1.0f / (1.0f - abs);
                            if (z2) {
                                motionController9.mStaggerOffset = abs - (((f3 - motionController9.mMotionStagger) / (f3 - f4)) * abs);
                            } else {
                                motionController9.mStaggerOffset = abs - (((motionController9.mMotionStagger - f4) * abs) / (f3 - f4));
                            }
                        }
                        i5++;
                    }
                    return;
                }
                while (i5 < childCount) {
                    MotionController motionController10 = motionLayout7.mFrameArrayList.get(motionLayout7.getChildAt(i5));
                    MotionPaths motionPaths2 = motionController10.mEndMotionPath;
                    float f10 = motionPaths2.x;
                    float f11 = motionPaths2.y;
                    float f12 = z2 ? f11 - f10 : f11 + f10;
                    motionController10.mStaggerScale = 1.0f / (1.0f - abs);
                    motionController10.mStaggerOffset = abs - (((f12 - f5) * abs) / (f6 - f5));
                    i5++;
                }
            }
        }

        public final void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.mRotate == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.mLayoutEnd, motionLayout.getOptimizationLevel(), MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.mCompanionWidget).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.mChildren.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.mCompanionWidget;
                int id = view.getId();
                if (constraintSet.mConstraints.containsKey(Integer.valueOf(id))) {
                    Constraint constraint = constraintSet.mConstraints.get(Integer.valueOf(id));
                    if (constraint != null) {
                        constraint.applyTo(layoutParams);
                    }
                }
                next2.setWidth(constraintSet.get(view.getId()).layout.mWidth);
                next2.setHeight(constraintSet.get(view.getId()).layout.mHeight);
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) view;
                    int id2 = constraintHelper.getId();
                    if (constraintSet.mConstraints.containsKey(Integer.valueOf(id2))) {
                        Constraint constraint2 = constraintSet.mConstraints.get(Integer.valueOf(id2));
                        if (constraint2 != null && (next2 instanceof HelperWidget)) {
                            constraintHelper.loadParameters(constraint2, (HelperWidget) next2, layoutParams, sparseArray);
                        }
                    }
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.get(view.getId()).propertySet.mVisibilityMode == 1) {
                    next2.mVisibility = view.getVisibility();
                } else {
                    next2.mVisibility = constraintSet.get(view.getId()).propertySet.visibility;
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.mChildren.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.mCompanionWidget).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }
    }

    public interface MotionTracker {
    }

    public static class MyTracker implements MotionTracker {
        public static MyTracker me = new MyTracker();
        public VelocityTracker tracker;

        public void computeCurrentVelocity(int i) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        public float getXVelocity() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float getYVelocity() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    public class StateCache {
        public int endState = -1;
        public float mProgress = Float.NaN;
        public float mVelocity = Float.NaN;
        public int startState = -1;

        public StateCache() {
        }

        public void apply() {
            if (!(this.startState == -1 && this.endState == -1)) {
                int i = this.startState;
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.endState);
                } else {
                    int i2 = this.endState;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.mVelocity)) {
                MotionLayout motionLayout = MotionLayout.this;
                float f2 = this.mProgress;
                float f3 = this.mVelocity;
                if (!motionLayout.isAttachedToWindow()) {
                    if (motionLayout.mStateCache == null) {
                        motionLayout.mStateCache = new StateCache();
                    }
                    StateCache stateCache = motionLayout.mStateCache;
                    stateCache.mProgress = f2;
                    stateCache.mVelocity = f3;
                } else {
                    motionLayout.setProgress(f2);
                    motionLayout.setState(TransitionState.MOVING);
                    motionLayout.mLastVelocity = f3;
                    motionLayout.animateTo(1.0f);
                }
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.startState = -1;
                this.endState = -1;
            } else if (!Float.isNaN(this.mProgress)) {
                MotionLayout.this.setProgress(this.mProgress);
            }
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f2);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f2);
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public static Rect access$2000(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        motionLayout.mTempRect.top = constraintWidget.getY();
        motionLayout.mTempRect.left = constraintWidget.getX();
        Rect rect = motionLayout.mTempRect;
        int width = constraintWidget.getWidth();
        Rect rect2 = motionLayout.mTempRect;
        rect.right = width + rect2.left;
        int height = constraintWidget.getHeight();
        Rect rect3 = motionLayout.mTempRect;
        rect2.bottom = height + rect3.top;
        return rect3;
    }

    public void animateTo(float f2) {
        if (this.mScene != null) {
            float f3 = this.mTransitionLastPosition;
            float f4 = this.mTransitionPosition;
            if (f3 != f4 && this.mTransitionInstantly) {
                this.mTransitionLastPosition = f4;
            }
            float f5 = this.mTransitionLastPosition;
            if (f5 != f2) {
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = f2;
                this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                setProgress(this.mTransitionGoalPosition);
                this.mInterpolator = null;
                this.mProgressInterpolator = this.mScene.getInterpolator();
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                this.mInTransition = true;
                this.mTransitionPosition = f5;
                this.mTransitionLastPosition = f5;
                invalidate();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0559  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r2 = r0.mDecoratorsHelpers
            if (r2 == 0) goto L_0x001c
            java.util.Iterator r2 = r2.iterator()
        L_0x000c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x001c
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.MotionHelper r3 = (androidx.constraintlayout.motion.widget.MotionHelper) r3
            r3.onPreDraw()
            goto L_0x000c
        L_0x001c:
            r2 = 0
            r0.evaluate(r2)
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            r4 = 0
            if (r3 == 0) goto L_0x0058
            androidx.constraintlayout.motion.widget.ViewTransitionController r3 = r3.mViewTransitionController
            if (r3 == 0) goto L_0x0058
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition$Animate> r5 = r3.animations
            if (r5 != 0) goto L_0x002e
            goto L_0x0058
        L_0x002e:
            java.util.Iterator r5 = r5.iterator()
        L_0x0032:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0042
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.motion.widget.ViewTransition$Animate r6 = (androidx.constraintlayout.motion.widget.ViewTransition.Animate) r6
            r6.mutate()
            goto L_0x0032
        L_0x0042:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition$Animate> r5 = r3.animations
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition$Animate> r6 = r3.removeList
            r5.removeAll(r6)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition$Animate> r5 = r3.removeList
            r5.clear()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition$Animate> r5 = r3.animations
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0058
            r3.animations = r4
        L_0x0058:
            super.dispatchDraw(r30)
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            if (r3 != 0) goto L_0x0060
            return
        L_0x0060:
            int r3 = r0.mDebugPath
            r5 = 1
            r3 = r3 & r5
            r6 = 1093664768(0x41300000, float:11.0)
            r7 = 1092616192(0x41200000, float:10.0)
            if (r3 != r5) goto L_0x0126
            boolean r3 = r29.isInEditMode()
            if (r3 != 0) goto L_0x0126
            int r3 = r0.mFrames
            int r3 = r3 + r5
            r0.mFrames = r3
            long r8 = r29.getNanoTime()
            long r10 = r0.mLastDrawTime
            r12 = -1
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x00a2
            long r10 = r8 - r10
            r12 = 200000000(0xbebc200, double:9.8813129E-316)
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a4
            int r3 = r0.mFrames
            float r3 = (float) r3
            float r10 = (float) r10
            r11 = 814313567(0x3089705f, float:1.0E-9)
            float r10 = r10 * r11
            float r3 = r3 / r10
            r10 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r10
            int r3 = (int) r3
            float r3 = (float) r3
            float r3 = r3 / r10
            r0.mLastFps = r3
            r0.mFrames = r2
            r0.mLastDrawTime = r8
            goto L_0x00a4
        L_0x00a2:
            r0.mLastDrawTime = r8
        L_0x00a4:
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r8 = 1109917696(0x42280000, float:42.0)
            r3.setTextSize(r8)
            float r8 = r29.getProgress()
            r9 = 1148846080(0x447a0000, float:1000.0)
            float r8 = r8 * r9
            int r8 = (int) r8
            float r8 = (float) r8
            float r8 = r8 / r7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            float r10 = r0.mLastFps
            r9.append(r10)
            java.lang.String r10 = " fps "
            r9.append(r10)
            int r10 = r0.mBeginState
            java.lang.String r10 = a.a.a.a.d.b.getState(r0, r10)
            r9.append(r10)
            java.lang.String r10 = " -> "
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r9 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r9)
            int r10 = r0.mEndState
            java.lang.String r10 = a.a.a.a.d.b.getState(r0, r10)
            r9.append(r10)
            java.lang.String r10 = " (progress: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = " ) state="
            r9.append(r8)
            int r8 = r0.mCurrentState
            r10 = -1
            if (r8 != r10) goto L_0x00fc
            java.lang.String r8 = "undefined"
            goto L_0x0100
        L_0x00fc:
            java.lang.String r8 = a.a.a.a.d.b.getState(r0, r8)
        L_0x0100:
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setColor(r9)
            int r9 = r29.getHeight()
            int r9 = r9 + -29
            float r9 = (float) r9
            r1.drawText(r8, r6, r9, r3)
            r9 = -7864184(0xffffffffff880088, float:NaN)
            r3.setColor(r9)
            int r9 = r29.getHeight()
            int r9 = r9 + -30
            float r9 = (float) r9
            r1.drawText(r8, r7, r9, r3)
        L_0x0126:
            int r3 = r0.mDebugPath
            if (r3 <= r5) goto L_0x0553
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r3 = r0.mDevModeDraw
            if (r3 != 0) goto L_0x0135
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r3 = new androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw
            r3.<init>()
            r0.mDevModeDraw = r3
        L_0x0135:
            androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw r3 = r0.mDevModeDraw
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r5 = r0.mFrameArrayList
            androidx.constraintlayout.motion.widget.MotionScene r8 = r0.mScene
            int r8 = r8.getDuration()
            int r9 = r0.mDebugPath
            if (r3 == 0) goto L_0x0552
            if (r5 == 0) goto L_0x0553
            int r4 = r5.size()
            if (r4 != 0) goto L_0x014d
            goto L_0x0555
        L_0x014d:
            r30.save()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = androidx.constraintlayout.motion.widget.MotionLayout.this
            boolean r4 = r4.isInEditMode()
            r10 = 2
            if (r4 != 0) goto L_0x01a5
            r4 = r9 & 1
            if (r4 != r10) goto L_0x01a5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
            android.content.Context r10 = r10.getContext()
            android.content.res.Resources r10 = r10.getResources()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = androidx.constraintlayout.motion.widget.MotionLayout.this
            int r11 = r11.mEndState
            java.lang.String r10 = r10.getResourceName(r11)
            r4.append(r10)
            java.lang.String r10 = ":"
            r4.append(r10)
            androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
            float r10 = r10.getProgress()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
            int r10 = r10.getHeight()
            int r10 = r10 + -30
            float r10 = (float) r10
            android.graphics.Paint r11 = r3.mTextPaint
            r1.drawText(r4, r7, r10, r11)
            androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
            int r7 = r7.getHeight()
            int r7 = r7 + -29
            float r7 = (float) r7
            android.graphics.Paint r10 = r3.mPaint
            r1.drawText(r4, r6, r7, r10)
        L_0x01a5:
            java.util.Collection r4 = r5.values()
            java.util.Iterator r4 = r4.iterator()
            r6 = r1
            r5 = r3
        L_0x01af:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x054d
            java.lang.Object r7 = r4.next()
            androidx.constraintlayout.motion.widget.MotionController r7 = (androidx.constraintlayout.motion.widget.MotionController) r7
            androidx.constraintlayout.motion.widget.MotionPaths r10 = r7.mStartMotionPath
            int r10 = r10.mDrawPath
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r11 = r7.mMotionPaths
            java.util.Iterator r11 = r11.iterator()
        L_0x01c5:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01d8
            java.lang.Object r12 = r11.next()
            androidx.constraintlayout.motion.widget.MotionPaths r12 = (androidx.constraintlayout.motion.widget.MotionPaths) r12
            int r12 = r12.mDrawPath
            int r10 = java.lang.Math.max(r10, r12)
            goto L_0x01c5
        L_0x01d8:
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r7.mEndMotionPath
            int r11 = r11.mDrawPath
            int r10 = java.lang.Math.max(r10, r11)
            if (r9 <= 0) goto L_0x01e5
            if (r10 != 0) goto L_0x01e5
            r10 = 1
        L_0x01e5:
            if (r10 != 0) goto L_0x01e8
            goto L_0x01af
        L_0x01e8:
            float[] r15 = r5.mKeyFramePoints
            int[] r11 = r5.mPathMode
            if (r15 == 0) goto L_0x025d
            androidx.constraintlayout.core.motion.utils.CurveFit[] r12 = r7.mSpline
            r12 = r12[r2]
            double[] r14 = r12.getTimePoints()
            if (r11 == 0) goto L_0x021a
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r12 = r7.mMotionPaths
            java.util.Iterator r12 = r12.iterator()
            r13 = 0
        L_0x01ff:
            boolean r16 = r12.hasNext()
            if (r16 == 0) goto L_0x021a
            java.lang.Object r16 = r12.next()
            r17 = r2
            r2 = r16
            androidx.constraintlayout.motion.widget.MotionPaths r2 = (androidx.constraintlayout.motion.widget.MotionPaths) r2
            int r16 = r13 + 1
            int r2 = r2.mMode
            r11[r13] = r2
            r13 = r16
            r2 = r17
            goto L_0x01ff
        L_0x021a:
            r17 = r2
            r2 = 0
            r11 = 0
            r18 = 0
        L_0x0220:
            int r11 = r14.length
            if (r2 >= r11) goto L_0x0254
            androidx.constraintlayout.core.motion.utils.CurveFit[] r11 = r7.mSpline
            r11 = r11[r17]
            r12 = r14[r2]
            r19 = r4
            double[] r4 = r7.mInterpolateData
            r11.getPos(r12, r4)
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r7.mStartMotionPath
            r12 = r14[r2]
            int[] r4 = r7.mInterpolateVariables
            r20 = r9
            double[] r9 = r7.mInterpolateData
            r21 = r14
            r14 = r4
            r4 = r15
            r15 = r9
            r16 = r4
            r17 = r18
            r11.getCenter(r12, r14, r15, r16, r17)
            int r18 = r18 + 2
            int r2 = r2 + 1
            r17 = 0
            r15 = r4
            r4 = r19
            r9 = r20
            r14 = r21
            goto L_0x0220
        L_0x0254:
            r19 = r4
            r20 = r9
            int r18 = r18 / 2
            r2 = r18
            goto L_0x0264
        L_0x025d:
            r19 = r4
            r20 = r9
            r18 = 0
            r2 = 0
        L_0x0264:
            r5.mKeyFrameCount = r2
            r2 = 1
            if (r10 < r2) goto L_0x053c
            int r2 = r8 / 16
            float[] r4 = r5.mPoints
            if (r4 == 0) goto L_0x0274
            int r4 = r4.length
            int r9 = r2 * 2
            if (r4 == r9) goto L_0x0281
        L_0x0274:
            int r4 = r2 * 2
            float[] r4 = new float[r4]
            r5.mPoints = r4
            android.graphics.Path r4 = new android.graphics.Path
            r4.<init>()
            r5.mPath = r4
        L_0x0281:
            int r4 = r5.mShadowTranslate
            float r4 = (float) r4
            r6.translate(r4, r4)
            android.graphics.Paint r4 = r5.mPaint
            r9 = 1996488704(0x77000000, float:2.5961484E33)
            r4.setColor(r9)
            android.graphics.Paint r4 = r5.mFillPaint
            r4.setColor(r9)
            android.graphics.Paint r4 = r5.mPaintKeyframes
            r4.setColor(r9)
            android.graphics.Paint r4 = r5.mPaintGraph
            r4.setColor(r9)
            float[] r4 = r5.mPoints
            int r9 = r2 + -1
            float r9 = (float) r9
            r11 = 1065353216(0x3f800000, float:1.0)
            float r9 = r11 / r9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r7.mAttributesMap
            java.lang.String r12 = "translationX"
            if (r11 != 0) goto L_0x02ae
            r11 = 0
            goto L_0x02b4
        L_0x02ae:
            java.lang.Object r11 = r11.get(r12)
            androidx.constraintlayout.core.motion.utils.SplineSet r11 = (androidx.constraintlayout.core.motion.utils.SplineSet) r11
        L_0x02b4:
            r15 = r11
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r7.mAttributesMap
            java.lang.String r13 = "translationY"
            if (r11 != 0) goto L_0x02bd
            r11 = 0
            goto L_0x02c3
        L_0x02bd:
            java.lang.Object r11 = r11.get(r13)
            androidx.constraintlayout.core.motion.utils.SplineSet r11 = (androidx.constraintlayout.core.motion.utils.SplineSet) r11
        L_0x02c3:
            r14 = r11
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r11 = r7.mCycleMap
            if (r11 != 0) goto L_0x02ca
            r11 = 0
            goto L_0x02d0
        L_0x02ca:
            java.lang.Object r11 = r11.get(r12)
            androidx.constraintlayout.motion.utils.ViewOscillator r11 = (androidx.constraintlayout.motion.utils.ViewOscillator) r11
        L_0x02d0:
            r12 = r11
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r11 = r7.mCycleMap
            if (r11 != 0) goto L_0x02d7
            r11 = 0
            goto L_0x02dd
        L_0x02d7:
            java.lang.Object r11 = r11.get(r13)
            androidx.constraintlayout.motion.utils.ViewOscillator r11 = (androidx.constraintlayout.motion.utils.ViewOscillator) r11
        L_0x02dd:
            r13 = r11
            r11 = 0
        L_0x02df:
            r16 = 2143289344(0x7fc00000, float:NaN)
            if (r11 >= r2) goto L_0x03fa
            r18 = r2
            float r2 = (float) r11
            float r2 = r2 * r9
            r21 = r8
            float r8 = r7.mStaggerScale
            r17 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x0316
            float r8 = r7.mStaggerOffset
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x02f9
            r2 = 0
        L_0x02f9:
            float r8 = r7.mStaggerOffset
            int r17 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r17 <= 0) goto L_0x0316
            r17 = r12
            r22 = r13
            double r12 = (double) r2
            r23 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r25 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r25 >= 0) goto L_0x031a
            float r2 = r2 - r8
            float r8 = r7.mStaggerScale
            float r2 = r2 * r8
            r8 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r2, r8)
            goto L_0x031a
        L_0x0316:
            r17 = r12
            r22 = r13
        L_0x031a:
            double r12 = (double) r2
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r7.mStartMotionPath
            androidx.constraintlayout.core.motion.utils.Easing r8 = r8.mKeyFrameEasing
            r23 = r8
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r8 = r7.mMotionPaths
            java.util.Iterator r8 = r8.iterator()
            r24 = 0
            r25 = r9
            r9 = r23
        L_0x032d:
            boolean r23 = r8.hasNext()
            if (r23 == 0) goto L_0x035c
            java.lang.Object r23 = r8.next()
            r26 = r8
            r8 = r23
            androidx.constraintlayout.motion.widget.MotionPaths r8 = (androidx.constraintlayout.motion.widget.MotionPaths) r8
            r27 = r12
            androidx.constraintlayout.core.motion.utils.Easing r12 = r8.mKeyFrameEasing
            if (r12 == 0) goto L_0x0357
            float r13 = r8.time
            int r23 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r23 >= 0) goto L_0x034d
            r9 = r12
            r24 = r13
            goto L_0x0357
        L_0x034d:
            boolean r12 = java.lang.Float.isNaN(r16)
            if (r12 == 0) goto L_0x0357
            float r8 = r8.time
            r16 = r8
        L_0x0357:
            r8 = r26
            r12 = r27
            goto L_0x032d
        L_0x035c:
            r27 = r12
            if (r9 == 0) goto L_0x037b
            boolean r8 = java.lang.Float.isNaN(r16)
            if (r8 == 0) goto L_0x0368
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x0368:
            float r8 = r2 - r24
            float r16 = r16 - r24
            float r8 = r8 / r16
            double r12 = (double) r8
            double r8 = r9.get(r12)
            float r8 = (float) r8
            float r8 = r8 * r16
            float r8 = r8 + r24
            double r8 = (double) r8
            r12 = r8
            goto L_0x037d
        L_0x037b:
            r12 = r27
        L_0x037d:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = r7.mSpline
            r9 = 0
            r8 = r8[r9]
            double[] r9 = r7.mInterpolateData
            r8.getPos(r12, r9)
            androidx.constraintlayout.core.motion.utils.CurveFit r8 = r7.mArcSpline
            if (r8 == 0) goto L_0x0396
            double[] r9 = r7.mInterpolateData
            r23 = r14
            int r14 = r9.length
            if (r14 <= 0) goto L_0x0398
            r8.getPos(r12, r9)
            goto L_0x0398
        L_0x0396:
            r23 = r14
        L_0x0398:
            androidx.constraintlayout.motion.widget.MotionPaths r8 = r7.mStartMotionPath
            int[] r14 = r7.mInterpolateVariables
            double[] r9 = r7.mInterpolateData
            int r24 = r11 * 2
            r26 = r11
            r11 = r8
            r8 = r17
            r0 = r22
            r1 = r23
            r22 = r3
            r3 = r15
            r15 = r9
            r16 = r4
            r17 = r24
            r11.getCenter(r12, r14, r15, r16, r17)
            if (r8 == 0) goto L_0x03c0
            r9 = r4[r24]
            float r11 = r8.get(r2)
            float r11 = r11 + r9
            r4[r24] = r11
            goto L_0x03cb
        L_0x03c0:
            if (r3 == 0) goto L_0x03cb
            r9 = r4[r24]
            float r11 = r3.get(r2)
            float r11 = r11 + r9
            r4[r24] = r11
        L_0x03cb:
            if (r0 == 0) goto L_0x03d9
            int r24 = r24 + 1
            r9 = r4[r24]
            float r2 = r0.get(r2)
            float r2 = r2 + r9
            r4[r24] = r2
            goto L_0x03e6
        L_0x03d9:
            if (r1 == 0) goto L_0x03e6
            int r24 = r24 + 1
            r9 = r4[r24]
            float r2 = r1.get(r2)
            float r2 = r2 + r9
            r4[r24] = r2
        L_0x03e6:
            int r11 = r26 + 1
            r13 = r0
            r14 = r1
            r15 = r3
            r12 = r8
            r2 = r18
            r8 = r21
            r3 = r22
            r9 = r25
            r0 = r29
            r1 = r30
            goto L_0x02df
        L_0x03fa:
            r22 = r3
            r21 = r8
            int r0 = r5.mKeyFrameCount
            r5.drawAll(r6, r10, r0, r7)
            android.graphics.Paint r0 = r5.mPaint
            r1 = -21965(0xffffffffffffaa33, float:NaN)
            r0.setColor(r1)
            android.graphics.Paint r0 = r5.mPaintKeyframes
            r1 = -2067046(0xffffffffffe0759a, float:NaN)
            r0.setColor(r1)
            android.graphics.Paint r0 = r5.mFillPaint
            r0.setColor(r1)
            android.graphics.Paint r0 = r5.mPaintGraph
            r1 = -13391360(0xffffffffff33aa00, float:-2.388145E38)
            r0.setColor(r1)
            int r0 = r5.mShadowTranslate
            int r0 = -r0
            float r0 = (float) r0
            r6.translate(r0, r0)
            int r0 = r5.mKeyFrameCount
            r5.drawAll(r6, r10, r0, r7)
            r0 = 5
            if (r10 != r0) goto L_0x0537
            android.graphics.Path r0 = r5.mPath
            r0.reset()
            r0 = 0
        L_0x0434:
            r1 = 50
            if (r0 > r1) goto L_0x050b
            float r3 = (float) r0
            float r1 = (float) r1
            float r3 = r3 / r1
            float[] r1 = r5.mRectangle
            r4 = 0
            float r3 = r7.getAdjustedPosition(r3, r4)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r4 = r7.mSpline
            r5 = 0
            r4 = r4[r5]
            double r5 = (double) r3
            double[] r3 = r7.mInterpolateData
            r4.getPos(r5, r3)
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r7.mStartMotionPath
            int[] r4 = r7.mInterpolateVariables
            double[] r5 = r7.mInterpolateData
            float r6 = r3.x
            float r8 = r3.y
            float r9 = r3.width
            float r10 = r3.height
            r11 = 0
        L_0x045c:
            int r12 = r4.length
            r13 = 4
            r14 = 3
            if (r11 >= r12) goto L_0x047d
            r15 = r3
            r2 = r5[r11]
            float r2 = (float) r2
            r3 = r4[r11]
            r12 = 1
            if (r3 == r12) goto L_0x0478
            r12 = 2
            if (r3 == r12) goto L_0x0476
            if (r3 == r14) goto L_0x0474
            if (r3 == r13) goto L_0x0472
            goto L_0x0479
        L_0x0472:
            r10 = r2
            goto L_0x0479
        L_0x0474:
            r9 = r2
            goto L_0x0479
        L_0x0476:
            r8 = r2
            goto L_0x0479
        L_0x0478:
            r6 = r2
        L_0x0479:
            int r11 = r11 + 1
            r3 = r15
            goto L_0x045c
        L_0x047d:
            r2 = r3
            androidx.constraintlayout.motion.widget.MotionController r2 = r2.mRelativeToController
            if (r2 == 0) goto L_0x04a4
            r2 = 0
            double r2 = (double) r2
            double r4 = (double) r6
            double r11 = (double) r8
            double r13 = java.lang.Math.sin(r11)
            double r13 = r13 * r4
            double r13 = r13 + r2
            r6 = 1073741824(0x40000000, float:2.0)
            float r8 = r9 / r6
            r15 = r7
            double r6 = (double) r8
            double r13 = r13 - r6
            float r6 = (float) r13
            double r7 = java.lang.Math.cos(r11)
            double r7 = r7 * r4
            double r2 = r2 - r7
            r4 = 1073741824(0x40000000, float:2.0)
            float r4 = r10 / r4
            double r4 = (double) r4
            double r2 = r2 - r4
            float r8 = (float) r2
            goto L_0x04a5
        L_0x04a4:
            r15 = r7
        L_0x04a5:
            float r9 = r9 + r6
            float r10 = r10 + r8
            java.lang.Float.isNaN(r16)
            java.lang.Float.isNaN(r16)
            r2 = 0
            float r6 = r6 + r2
            float r8 = r8 + r2
            float r9 = r9 + r2
            float r10 = r10 + r2
            r2 = 0
            r1[r2] = r6
            r2 = 1
            r1[r2] = r8
            r2 = 2
            r1[r2] = r9
            r2 = 3
            r1[r2] = r8
            r2 = 4
            r1[r2] = r9
            r2 = 5
            r1[r2] = r10
            r2 = 6
            r1[r2] = r6
            r3 = 7
            r1[r3] = r10
            r1 = r22
            android.graphics.Path r4 = r1.mPath
            float[] r5 = r1.mRectangle
            r6 = 0
            r6 = r5[r6]
            r7 = 1
            r5 = r5[r7]
            r4.moveTo(r6, r5)
            android.graphics.Path r4 = r1.mPath
            float[] r5 = r1.mRectangle
            r6 = 2
            r6 = r5[r6]
            r7 = 3
            r5 = r5[r7]
            r4.lineTo(r6, r5)
            android.graphics.Path r4 = r1.mPath
            float[] r5 = r1.mRectangle
            r6 = 4
            r6 = r5[r6]
            r7 = 5
            r5 = r5[r7]
            r4.lineTo(r6, r5)
            android.graphics.Path r4 = r1.mPath
            float[] r5 = r1.mRectangle
            r2 = r5[r2]
            r3 = r5[r3]
            r4.lineTo(r2, r3)
            android.graphics.Path r2 = r1.mPath
            r2.close()
            int r0 = r0 + 1
            r5 = r1
            r22 = r5
            r7 = r15
            goto L_0x0434
        L_0x050b:
            r1 = r22
            android.graphics.Paint r0 = r5.mPaint
            r2 = 1140850688(0x44000000, float:512.0)
            r0.setColor(r2)
            r0 = r30
            r2 = 1073741824(0x40000000, float:2.0)
            r0.translate(r2, r2)
            android.graphics.Path r2 = r5.mPath
            android.graphics.Paint r3 = r5.mPaint
            r0.drawPath(r2, r3)
            r2 = -1073741824(0xffffffffc0000000, float:-2.0)
            r0.translate(r2, r2)
            android.graphics.Paint r2 = r5.mPaint
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r2.setColor(r3)
            android.graphics.Path r2 = r5.mPath
            android.graphics.Paint r3 = r5.mPaint
            r0.drawPath(r2, r3)
            r6 = r0
            goto L_0x0540
        L_0x0537:
            r0 = r30
            r1 = r22
            goto L_0x0540
        L_0x053c:
            r0 = r1
            r1 = r3
            r21 = r8
        L_0x0540:
            r2 = 0
            r3 = r1
            r4 = r19
            r9 = r20
            r8 = r21
            r1 = r0
            r0 = r29
            goto L_0x01af
        L_0x054d:
            r0 = r1
            r30.restore()
            goto L_0x0553
        L_0x0552:
            throw r4
        L_0x0553:
            r0 = r29
        L_0x0555:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r0.mDecoratorsHelpers
            if (r1 == 0) goto L_0x056d
            java.util.Iterator r1 = r1.iterator()
        L_0x055d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x056d
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.motion.widget.MotionHelper r2 = (androidx.constraintlayout.motion.widget.MotionHelper) r2
            r2.onPostDraw()
            goto L_0x055d
        L_0x056d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    public void endTrigger(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i));
            if (motionController != null && "button".equals(b.getName(motionController.mView)) && motionController.mKeyTriggers != null) {
                int i2 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.mKeyTriggers;
                    if (i2 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i2].conditionallyFire(z ? -100.0f : 100.0f, motionController.mView);
                    i2++;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0124 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluate(boolean r24) {
        /*
            r23 = this;
            r0 = r23
            long r1 = r0.mTransitionLastTime
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0010
            long r1 = r23.getNanoTime()
            r0.mTransitionLastTime = r1
        L_0x0010:
            float r1 = r0.mTransitionLastPosition
            r2 = -1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0020
            r0.mCurrentState = r2
        L_0x0020:
            boolean r1 = r0.mKeepAnimating
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L_0x0034
            boolean r1 = r0.mInTransition
            if (r1 == 0) goto L_0x024c
            if (r24 != 0) goto L_0x0034
            float r1 = r0.mTransitionGoalPosition
            float r7 = r0.mTransitionLastPosition
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x024c
        L_0x0034:
            float r1 = r0.mTransitionGoalPosition
            float r7 = r0.mTransitionLastPosition
            float r1 = r1 - r7
            float r1 = java.lang.Math.signum(r1)
            long r7 = r23.getNanoTime()
            android.view.animation.Interpolator r9 = r0.mInterpolator
            boolean r9 = r9 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r10 = 814313567(0x3089705f, float:1.0E-9)
            if (r9 != 0) goto L_0x0057
            long r11 = r0.mTransitionLastTime
            long r11 = r7 - r11
            float r9 = (float) r11
            float r9 = r9 * r1
            float r9 = r9 * r10
            float r11 = r0.mTransitionDuration
            float r9 = r9 / r11
            goto L_0x0058
        L_0x0057:
            r9 = 0
        L_0x0058:
            float r11 = r0.mTransitionLastPosition
            float r11 = r11 + r9
            boolean r12 = r0.mTransitionInstantly
            if (r12 == 0) goto L_0x0061
            float r11 = r0.mTransitionGoalPosition
        L_0x0061:
            int r12 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x006b
            float r13 = r0.mTransitionGoalPosition
            int r13 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0075
        L_0x006b:
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 > 0) goto L_0x007b
            float r13 = r0.mTransitionGoalPosition
            int r13 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x007b
        L_0x0075:
            float r11 = r0.mTransitionGoalPosition
            r0.mInTransition = r6
            r13 = 1
            goto L_0x007c
        L_0x007b:
            r13 = 0
        L_0x007c:
            r0.mTransitionLastPosition = r11
            r0.mTransitionPosition = r11
            r0.mTransitionLastTime = r7
            r14 = 2
            android.view.animation.Interpolator r15 = r0.mInterpolator
            r16 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r15 == 0) goto L_0x0110
            if (r13 != 0) goto L_0x0110
            boolean r13 = r0.mTemporalInterpolator
            if (r13 == 0) goto L_0x00f0
            long r2 = r0.mAnimationStartTime
            long r2 = r7 - r2
            float r2 = (float) r2
            float r2 = r2 * r10
            float r2 = r15.getInterpolation(r2)
            android.view.animation.Interpolator r3 = r0.mInterpolator
            androidx.constraintlayout.motion.utils.StopLogic r9 = r0.mStopLogic
            if (r3 != r9) goto L_0x00ad
            androidx.constraintlayout.core.motion.utils.StopEngine r3 = r9.mEngine
            boolean r3 = r3.isStopped()
            if (r3 == 0) goto L_0x00ab
            r3 = 2
            goto L_0x00ae
        L_0x00ab:
            r3 = 1
            goto L_0x00ae
        L_0x00ad:
            r3 = 0
        L_0x00ae:
            r0.mTransitionLastPosition = r2
            r0.mTransitionLastTime = r7
            android.view.animation.Interpolator r7 = r0.mInterpolator
            boolean r8 = r7 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r8 == 0) goto L_0x00ee
            androidx.constraintlayout.motion.widget.MotionInterpolator r7 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r7
            float r7 = r7.getVelocity()
            r0.mLastVelocity = r7
            float r8 = java.lang.Math.abs(r7)
            float r9 = r0.mTransitionDuration
            float r8 = r8 * r9
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 > 0) goto L_0x00d0
            if (r3 != r14) goto L_0x00d0
            r0.mInTransition = r6
        L_0x00d0:
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e0
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00e0
            r0.mTransitionLastPosition = r8
            r0.mInTransition = r6
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x00e0:
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ee
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x00ee
            r0.mTransitionLastPosition = r4
            r0.mInTransition = r6
            r11 = 0
            goto L_0x0113
        L_0x00ee:
            r11 = r2
            goto L_0x0113
        L_0x00f0:
            float r2 = r15.getInterpolation(r11)
            android.view.animation.Interpolator r3 = r0.mInterpolator
            boolean r7 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r7 == 0) goto L_0x0103
            androidx.constraintlayout.motion.widget.MotionInterpolator r3 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r3
            float r3 = r3.getVelocity()
            r0.mLastVelocity = r3
            goto L_0x010e
        L_0x0103:
            float r11 = r11 + r9
            float r3 = r3.getInterpolation(r11)
            float r3 = r3 - r2
            float r3 = r3 * r1
            float r3 = r3 / r9
            r0.mLastVelocity = r3
        L_0x010e:
            r11 = r2
            goto L_0x0112
        L_0x0110:
            r0.mLastVelocity = r9
        L_0x0112:
            r3 = 0
        L_0x0113:
            float r2 = r0.mLastVelocity
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 <= 0) goto L_0x0122
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r2)
        L_0x0122:
            if (r3 == r5) goto L_0x014b
            if (r12 <= 0) goto L_0x012c
            float r2 = r0.mTransitionGoalPosition
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0136
        L_0x012c:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x013a
            float r2 = r0.mTransitionGoalPosition
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x013a
        L_0x0136:
            float r11 = r0.mTransitionGoalPosition
            r0.mInTransition = r6
        L_0x013a:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0144
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x014b
        L_0x0144:
            r0.mInTransition = r6
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
        L_0x014b:
            int r2 = r23.getChildCount()
            r0.mKeepAnimating = r6
            long r7 = r23.getNanoTime()
            r0.mPostInterpolationPosition = r11
            android.view.animation.Interpolator r3 = r0.mProgressInterpolator
            if (r3 != 0) goto L_0x015d
            r3 = r11
            goto L_0x0161
        L_0x015d:
            float r3 = r3.getInterpolation(r11)
        L_0x0161:
            android.view.animation.Interpolator r9 = r0.mProgressInterpolator
            if (r9 == 0) goto L_0x0179
            float r10 = r0.mTransitionDuration
            float r10 = r1 / r10
            float r10 = r10 + r11
            float r9 = r9.getInterpolation(r10)
            r0.mLastVelocity = r9
            android.view.animation.Interpolator r10 = r0.mProgressInterpolator
            float r10 = r10.getInterpolation(r11)
            float r9 = r9 - r10
            r0.mLastVelocity = r9
        L_0x0179:
            r9 = 0
        L_0x017a:
            if (r9 >= r2) goto L_0x01a2
            android.view.View r10 = r0.getChildAt(r9)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r14 = r0.mFrameArrayList
            java.lang.Object r14 = r14.get(r10)
            r17 = r14
            androidx.constraintlayout.motion.widget.MotionController r17 = (androidx.constraintlayout.motion.widget.MotionController) r17
            if (r17 == 0) goto L_0x019f
            boolean r14 = r0.mKeepAnimating
            androidx.constraintlayout.core.motion.utils.KeyCache r15 = r0.mKeyCache
            r18 = r10
            r19 = r3
            r20 = r7
            r22 = r15
            boolean r10 = r17.interpolate(r18, r19, r20, r22)
            r10 = r10 | r14
            r0.mKeepAnimating = r10
        L_0x019f:
            int r9 = r9 + 1
            goto L_0x017a
        L_0x01a2:
            if (r12 <= 0) goto L_0x01aa
            float r2 = r0.mTransitionGoalPosition
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x01b4
        L_0x01aa:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01b6
            float r2 = r0.mTransitionGoalPosition
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01b6
        L_0x01b4:
            r2 = 1
            goto L_0x01b7
        L_0x01b6:
            r2 = 0
        L_0x01b7:
            boolean r3 = r0.mKeepAnimating
            if (r3 != 0) goto L_0x01c6
            boolean r3 = r0.mInTransition
            if (r3 != 0) goto L_0x01c6
            if (r2 == 0) goto L_0x01c6
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x01c6:
            boolean r3 = r0.mMeasureDuringTransition
            if (r3 == 0) goto L_0x01cd
            r23.requestLayout()
        L_0x01cd:
            boolean r3 = r0.mKeepAnimating
            r2 = r2 ^ r5
            r2 = r2 | r3
            r0.mKeepAnimating = r2
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01f1
            int r2 = r0.mBeginState
            r3 = -1
            if (r2 == r3) goto L_0x01f1
            int r3 = r0.mCurrentState
            if (r3 == r2) goto L_0x01f1
            r0.mCurrentState = r2
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r2 = r3.getConstraintSet(r2)
            r2.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r6 = 1
        L_0x01f1:
            double r2 = (double) r11
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x020f
            int r2 = r0.mCurrentState
            int r3 = r0.mEndState
            if (r2 == r3) goto L_0x020f
            r0.mCurrentState = r3
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r2 = r2.getConstraintSet(r3)
            r2.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r6 = 1
        L_0x020f:
            boolean r2 = r0.mKeepAnimating
            if (r2 != 0) goto L_0x022e
            boolean r2 = r0.mInTransition
            if (r2 == 0) goto L_0x0218
            goto L_0x022e
        L_0x0218:
            if (r12 <= 0) goto L_0x0220
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0228
        L_0x0220:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0231
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0231
        L_0x0228:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            goto L_0x0231
        L_0x022e:
            r23.invalidate()
        L_0x0231:
            boolean r2 = r0.mKeepAnimating
            if (r2 != 0) goto L_0x024c
            boolean r2 = r0.mInTransition
            if (r2 != 0) goto L_0x024c
            if (r12 <= 0) goto L_0x0241
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0249
        L_0x0241:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x024c
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x024c
        L_0x0249:
            r23.onNewStateAttachHandlers()
        L_0x024c:
            float r1 = r0.mTransitionLastPosition
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0262
            int r1 = r0.mCurrentState
            int r2 = r0.mEndState
            if (r1 == r2) goto L_0x025b
            goto L_0x025c
        L_0x025b:
            r5 = r6
        L_0x025c:
            int r1 = r0.mEndState
            r0.mCurrentState = r1
        L_0x0260:
            r6 = r5
            goto L_0x0273
        L_0x0262:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0273
            int r1 = r0.mCurrentState
            int r2 = r0.mBeginState
            if (r1 == r2) goto L_0x026d
            goto L_0x026e
        L_0x026d:
            r5 = r6
        L_0x026e:
            int r1 = r0.mBeginState
            r0.mCurrentState = r1
            goto L_0x0260
        L_0x0273:
            boolean r1 = r0.mNeedsFireTransitionCompleted
            r1 = r1 | r6
            r0.mNeedsFireTransitionCompleted = r1
            if (r6 == 0) goto L_0x0281
            boolean r1 = r0.mInLayout
            if (r1 != 0) goto L_0x0281
            r23.requestLayout()
        L_0x0281:
            float r1 = r0.mTransitionLastPosition
            r0.mTransitionPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    public final void fireTransitionChange() {
        if (this.mTransitionListener == null) {
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
        }
        if (this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
            }
            this.mListenerState = -1;
            float f2 = this.mTransitionPosition;
            this.mListenerPosition = f2;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f2);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.mTransitionListeners;
            if (copyOnWriteArrayList3 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0.isEmpty() == false) goto L_0x000f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fireTransitionCompleted() {
        /*
            r4 = this;
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener r0 = r4.mTransitionListener
            r1 = 1
            if (r0 != 0) goto L_0x000f
            java.util.concurrent.CopyOnWriteArrayList<androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener> r0 = r4.mTransitionListeners
            if (r0 == 0) goto L_0x0042
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0042
        L_0x000f:
            int r0 = r4.mListenerState
            r2 = -1
            if (r0 != r2) goto L_0x0042
            int r0 = r4.mCurrentState
            r4.mListenerState = r0
            java.util.ArrayList<java.lang.Integer> r0 = r4.mTransitionCompleted
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0032
            java.util.ArrayList<java.lang.Integer> r0 = r4.mTransitionCompleted
            int r3 = r0.size()
            int r3 = r3 - r1
            java.lang.Object r0 = r0.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0033
        L_0x0032:
            r0 = -1
        L_0x0033:
            int r3 = r4.mCurrentState
            if (r0 == r3) goto L_0x0042
            if (r3 == r2) goto L_0x0042
            java.util.ArrayList<java.lang.Integer> r0 = r4.mTransitionCompleted
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r0.add(r2)
        L_0x0042:
            r4.processTransitionCompleted()
            java.lang.Runnable r0 = r4.mOnComplete
            if (r0 == 0) goto L_0x004c
            r0.run()
        L_0x004c:
            int[] r0 = r4.mScheduledTransitionTo
            if (r0 == 0) goto L_0x0066
            int r2 = r4.mScheduledTransitions
            if (r2 <= 0) goto L_0x0066
            r2 = 0
            r0 = r0[r2]
            r4.transitionToState(r0)
            int[] r0 = r4.mScheduledTransitionTo
            int r3 = r0.length
            int r3 = r3 - r1
            java.lang.System.arraycopy(r0, r1, r0, r2, r3)
            int r0 = r4.mScheduledTransitions
            int r0 = r0 - r1
            r4.mScheduledTransitions = r0
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.fireTransitionCompleted():void");
    }

    public void getAnchorDpDt(int i, float f2, float f3, float f4, float[] fArr) {
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f2, f3, f4, fArr);
            float y = viewById.getY();
            int i2 = ((f2 - this.lastPos) > 0.0f ? 1 : ((f2 - this.lastPos) == 0.0f ? 0 : -1));
            this.lastPos = f2;
            this.lastY = y;
        } else if (viewById == null) {
            "" + i;
        } else {
            viewById.getContext().getResources().getResourceName(i);
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        int size = motionScene.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = motionScene.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.mTransitionList;
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public Transition getTransition(int i) {
        Iterator<Transition> it = this.mScene.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i) {
                return next;
            }
        }
        return null;
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        StateCache stateCache = this.mStateCache;
        MotionLayout motionLayout = MotionLayout.this;
        stateCache.endState = motionLayout.mEndState;
        stateCache.startState = motionLayout.mBeginState;
        stateCache.mVelocity = motionLayout.getVelocity();
        stateCache.mProgress = MotionLayout.this.getProgress();
        StateCache stateCache2 = this.mStateCache;
        if (stateCache2 != null) {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", stateCache2.mProgress);
            bundle.putFloat("motion.velocity", stateCache2.mVelocity);
            bundle.putInt("motion.StartState", stateCache2.startState);
            bundle.putInt("motion.EndState", stateCache2.endState);
            return bundle;
        }
        throw null;
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handlesTouchEvent(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.handlesTouchEvent(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x00ab
            android.graphics.RectF r2 = r7.mBoundsCheck
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.mBoundsCheck
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x00ab
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            android.graphics.Matrix r2 = r10.getMatrix()
            boolean r3 = r2.isIdentity()
            if (r3 == 0) goto L_0x0085
            r11.offsetLocation(r8, r9)
            boolean r10 = r10.onTouchEvent(r11)
            float r8 = -r8
            float r9 = -r9
            r11.offsetLocation(r8, r9)
            goto L_0x00a8
        L_0x0085:
            android.view.MotionEvent r11 = android.view.MotionEvent.obtain(r11)
            r11.offsetLocation(r8, r9)
            android.graphics.Matrix r8 = r7.mInverseMatrix
            if (r8 != 0) goto L_0x0097
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            r7.mInverseMatrix = r8
        L_0x0097:
            android.graphics.Matrix r8 = r7.mInverseMatrix
            r2.invert(r8)
            android.graphics.Matrix r8 = r7.mInverseMatrix
            r11.transform(r8)
            boolean r10 = r10.onTouchEvent(r11)
            r11.recycle()
        L_0x00a8:
            if (r10 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r1 = r0
        L_0x00ac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.handlesTouchEvent(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    public final void init(AttributeSet attributeSet) {
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            MotionScene motionScene = this.mScene;
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null) {
                int startId = motionScene2.getStartId();
                MotionScene motionScene3 = this.mScene;
                ConstraintSet constraintSet = motionScene3.getConstraintSet(motionScene3.getStartId());
                b.getName(getContext(), startId);
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    int id = childAt.getId();
                    if (id == -1) {
                        childAt.getClass().getName();
                    }
                    if (constraintSet.getConstraint(id) == null) {
                        b.getName(childAt);
                    }
                }
                Integer[] numArr = (Integer[]) constraintSet.mConstraints.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = numArr[i3].intValue();
                }
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    b.getName(getContext(), i5);
                    findViewById(iArr[i4]);
                    int i6 = constraintSet.get(i5).layout.mHeight;
                    int i7 = constraintSet.get(i5).layout.mWidth;
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator<Transition> it = this.mScene.mTransitionList.iterator();
                while (it.hasNext()) {
                    Transition next = it.next();
                    Transition transition = this.mScene.mCurrentTransition;
                    int i8 = next.mConstraintSetStart;
                    int i9 = next.mConstraintSetEnd;
                    b.getName(getContext(), i8);
                    b.getName(getContext(), i9);
                    sparseIntArray.get(i8);
                    sparseIntArray2.get(i9);
                    sparseIntArray.put(i8, i9);
                    sparseIntArray2.put(i9, i8);
                    this.mScene.getConstraintSet(i8);
                    this.mScene.getConstraintSet(i9);
                }
            }
        }
        if (this.mCurrentState == -1) {
            MotionScene motionScene4 = this.mScene;
            if (motionScene4 != null) {
                this.mCurrentState = motionScene4.getStartId();
                this.mBeginState = this.mScene.getStartId();
                this.mEndState = this.mScene.getEndId();
            }
        }
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i);
                this.mScene = motionScene;
                if (this.mCurrentState == -1) {
                    this.mCurrentState = motionScene.getStartId();
                    this.mBeginState = this.mScene.getStartId();
                    this.mEndState = this.mScene.getEndId();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    if (display != null) {
                        display.getRotation();
                    }
                    if (this.mScene != null) {
                        ConstraintSet constraintSet = this.mScene.getConstraintSet(this.mCurrentState);
                        this.mScene.readFallback(this);
                        if (this.mDecoratorsHelpers != null) {
                            Iterator<MotionHelper> it = this.mDecoratorsHelpers.iterator();
                            while (it.hasNext()) {
                                it.next().onFinishedMotionScene();
                            }
                        }
                        if (constraintSet != null) {
                            constraintSet.applyToInternal(this, true);
                            setConstraintSet(null);
                            requestLayout();
                        }
                        this.mBeginState = this.mCurrentState;
                    }
                    onNewStateAttachHandlers();
                    if (this.mStateCache != null) {
                        if (this.mDelayedApply) {
                            post(new Runnable() {
                                public void run() {
                                    MotionLayout.this.mStateCache.apply();
                                }
                            });
                        } else {
                            this.mStateCache.apply();
                        }
                    } else if (this.mScene != null && this.mScene.mCurrentTransition != null && this.mScene.mCurrentTransition.mAutoTransition == 4) {
                        transitionToEnd();
                        setState(TransitionState.SETUP);
                        setState(TransitionState.MOVING);
                    }
                } else {
                    this.mScene = null;
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        } else {
            this.mScene = null;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            int i = this.mCurrentState;
            if (i != -1) {
                ConstraintSet constraintSet = motionScene.getConstraintSet(i);
                this.mScene.readFallback(this);
                ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                if (arrayList != null) {
                    Iterator<MotionHelper> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onFinishedMotionScene();
                    }
                }
                if (constraintSet != null) {
                    constraintSet.applyToInternal(this, true);
                    setConstraintSet(null);
                    requestLayout();
                }
                this.mBeginState = this.mCurrentState;
            }
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache == null) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null) {
                Transition transition = motionScene2.mCurrentTransition;
                if (transition != null && transition.mAutoTransition == 4) {
                    transitionToEnd();
                    setState(TransitionState.SETUP);
                    setState(TransitionState.MOVING);
                }
            }
        } else if (this.mDelayedApply) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.mStateCache.apply();
                }
            });
        } else {
            stateCache.apply();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewTransition viewTransition;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                int currentState = viewTransitionController.mMotionLayout.getCurrentState();
                if (currentState != -1) {
                    if (viewTransitionController.mRelatedViews == null) {
                        viewTransitionController.mRelatedViews = new HashSet<>();
                        Iterator<ViewTransition> it = viewTransitionController.viewTransitions.iterator();
                        while (it.hasNext()) {
                            ViewTransition next = it.next();
                            int childCount = viewTransitionController.mMotionLayout.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = viewTransitionController.mMotionLayout.getChildAt(i);
                                if (next.matchesView(childAt)) {
                                    childAt.getId();
                                    viewTransitionController.mRelatedViews.add(childAt);
                                }
                            }
                        }
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    Rect rect = new Rect();
                    int action = motionEvent.getAction();
                    ArrayList<Animate> arrayList = viewTransitionController.animations;
                    int i2 = 2;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        Iterator<Animate> it2 = viewTransitionController.animations.iterator();
                        while (it2.hasNext()) {
                            Animate next2 = it2.next();
                            if (next2 == null) {
                                throw null;
                            } else if (action != 1) {
                                if (action == 2) {
                                    next2.mMC.mView.getHitRect(next2.mTempRec);
                                    if (!next2.mTempRec.contains((int) x, (int) y) && !next2.reverse) {
                                        next2.reverse(true);
                                    }
                                }
                            } else if (!next2.reverse) {
                                next2.reverse(true);
                            }
                        }
                    }
                    if (action == 0 || action == 1) {
                        ConstraintSet constraintSet = viewTransitionController.mMotionLayout.getConstraintSet(currentState);
                        Iterator<ViewTransition> it3 = viewTransitionController.viewTransitions.iterator();
                        while (it3.hasNext()) {
                            ViewTransition next3 = it3.next();
                            int i3 = next3.mOnStateTransition;
                            if (i3 != 1 ? !(i3 != i2 ? !(i3 == 3 && action == 0) : action != 1) : action == 0) {
                                Iterator<View> it4 = viewTransitionController.mRelatedViews.iterator();
                                while (it4.hasNext()) {
                                    View next4 = it4.next();
                                    if (next3.matchesView(next4)) {
                                        next4.getHitRect(rect);
                                        if (rect.contains((int) x, (int) y)) {
                                            viewTransition = next3;
                                            next3.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, next4);
                                        } else {
                                            viewTransition = next3;
                                        }
                                        next3 = viewTransition;
                                        i2 = 2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && (!transition.mDisable)) {
                TouchResponse touchResponse = transition.mTouchResponse;
                if (touchResponse != null) {
                    if (motionEvent.getAction() == 0) {
                        RectF touchRegion = touchResponse.getTouchRegion(this, new RectF());
                        if (touchRegion != null && !touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                            return false;
                        }
                    }
                    int i4 = touchResponse.mTouchRegionId;
                    if (i4 != -1) {
                        View view = this.mRegionView;
                        if (view == null || view.getId() != i4) {
                            this.mRegionView = findViewById(i4);
                        }
                        View view2 = this.mRegionView;
                        if (view2 != null) {
                            this.mBoundsCheck.set((float) view2.getLeft(), (float) this.mRegionView.getTop(), (float) this.mRegionView.getRight(), (float) this.mRegionView.getBottom());
                            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent((float) this.mRegionView.getLeft(), (float) this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                                return onTouchEvent(motionEvent);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (!(this.mLastLayoutWidth == i5 && this.mLastLayoutHeight == i6)) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i5;
            this.mLastLayoutHeight = i6;
            this.mInLayout = false;
        } finally {
            this.mInLayout = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (((r3 == r5.mStartId && r4 == r5.mEndId) ? false : true) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r13.mScene
            if (r0 != 0) goto L_0x0008
            super.onMeasure(r14, r15)
            return
        L_0x0008:
            int r0 = r13.mLastWidthMeasureSpec
            r1 = 0
            r2 = 1
            if (r0 != r14) goto L_0x0015
            int r0 = r13.mLastHeightMeasureSpec
            if (r0 == r15) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            boolean r3 = r13.mNeedsFireTransitionCompleted
            if (r3 == 0) goto L_0x0023
            r13.mNeedsFireTransitionCompleted = r1
            r13.onNewStateAttachHandlers()
            r13.processTransitionCompleted()
            r0 = 1
        L_0x0023:
            boolean r3 = r13.mDirtyHierarchy
            if (r3 == 0) goto L_0x0028
            r0 = 1
        L_0x0028:
            r13.mLastWidthMeasureSpec = r14
            r13.mLastHeightMeasureSpec = r15
            androidx.constraintlayout.motion.widget.MotionScene r3 = r13.mScene
            int r3 = r3.getStartId()
            androidx.constraintlayout.motion.widget.MotionScene r4 = r13.mScene
            int r4 = r4.getEndId()
            if (r0 != 0) goto L_0x004a
            androidx.constraintlayout.motion.widget.MotionLayout$Model r5 = r13.mModel
            int r6 = r5.mStartId
            if (r3 != r6) goto L_0x0047
            int r5 = r5.mEndId
            if (r4 == r5) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r5 = 0
            goto L_0x0048
        L_0x0047:
            r5 = 1
        L_0x0048:
            if (r5 == 0) goto L_0x0070
        L_0x004a:
            int r5 = r13.mBeginState
            r6 = -1
            if (r5 == r6) goto L_0x0070
            super.onMeasure(r14, r15)
            androidx.constraintlayout.motion.widget.MotionLayout$Model r14 = r13.mModel
            androidx.constraintlayout.motion.widget.MotionScene r15 = r13.mScene
            androidx.constraintlayout.widget.ConstraintSet r15 = r15.getConstraintSet(r3)
            androidx.constraintlayout.motion.widget.MotionScene r0 = r13.mScene
            androidx.constraintlayout.widget.ConstraintSet r0 = r0.getConstraintSet(r4)
            r14.initFrom(r15, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$Model r14 = r13.mModel
            r14.reEvaluateState()
            androidx.constraintlayout.motion.widget.MotionLayout$Model r14 = r13.mModel
            r14.mStartId = r3
            r14.mEndId = r4
            r14 = 0
            goto L_0x0076
        L_0x0070:
            if (r0 == 0) goto L_0x0075
            super.onMeasure(r14, r15)
        L_0x0075:
            r14 = 1
        L_0x0076:
            boolean r15 = r13.mMeasureDuringTransition
            if (r15 != 0) goto L_0x007c
            if (r14 == 0) goto L_0x00cd
        L_0x007c:
            int r14 = r13.getPaddingTop()
            int r15 = r13.getPaddingBottom()
            int r15 = r15 + r14
            int r14 = r13.getPaddingLeft()
            int r0 = r13.getPaddingRight()
            int r0 = r0 + r14
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r14 = r13.mLayoutWidget
            int r14 = r14.getWidth()
            int r14 = r14 + r0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r13.mLayoutWidget
            int r0 = r0.getHeight()
            int r0 = r0 + r15
            int r15 = r13.mWidthMeasureMode
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 == r3) goto L_0x00a4
            if (r15 != 0) goto L_0x00b4
        L_0x00a4:
            int r14 = r13.mStartWrapWidth
            float r15 = (float) r14
            float r4 = r13.mPostInterpolationPosition
            int r5 = r13.mEndWrapWidth
            int r5 = r5 - r14
            float r14 = (float) r5
            float r4 = r4 * r14
            float r4 = r4 + r15
            int r14 = (int) r4
            r13.requestLayout()
        L_0x00b4:
            int r15 = r13.mHeightMeasureMode
            if (r15 == r3) goto L_0x00ba
            if (r15 != 0) goto L_0x00ca
        L_0x00ba:
            int r15 = r13.mStartWrapHeight
            float r0 = (float) r15
            float r3 = r13.mPostInterpolationPosition
            int r4 = r13.mEndWrapHeight
            int r4 = r4 - r15
            float r15 = (float) r4
            float r3 = r3 * r15
            float r3 = r3 + r0
            int r0 = (int) r3
            r13.requestLayout()
        L_0x00ca:
            r13.setMeasuredDimension(r14, r0)
        L_0x00cd:
            float r14 = r13.mTransitionGoalPosition
            float r15 = r13.mTransitionLastPosition
            float r14 = r14 - r15
            float r14 = java.lang.Math.signum(r14)
            long r3 = r13.getNanoTime()
            android.view.animation.Interpolator r15 = r13.mInterpolator
            boolean r15 = r15 instanceof androidx.constraintlayout.motion.utils.StopLogic
            r0 = 814313567(0x3089705f, float:1.0E-9)
            r5 = 0
            if (r15 != 0) goto L_0x00f1
            long r6 = r13.mTransitionLastTime
            long r6 = r3 - r6
            float r15 = (float) r6
            float r15 = r15 * r14
            float r15 = r15 * r0
            float r6 = r13.mTransitionDuration
            float r15 = r15 / r6
            goto L_0x00f2
        L_0x00f1:
            r15 = 0
        L_0x00f2:
            float r6 = r13.mTransitionLastPosition
            float r6 = r6 + r15
            boolean r15 = r13.mTransitionInstantly
            if (r15 == 0) goto L_0x00fb
            float r6 = r13.mTransitionGoalPosition
        L_0x00fb:
            int r15 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r15 <= 0) goto L_0x0105
            float r7 = r13.mTransitionGoalPosition
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x010f
        L_0x0105:
            int r7 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0112
            float r7 = r13.mTransitionGoalPosition
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0112
        L_0x010f:
            float r6 = r13.mTransitionGoalPosition
            goto L_0x0113
        L_0x0112:
            r2 = 0
        L_0x0113:
            android.view.animation.Interpolator r7 = r13.mInterpolator
            if (r7 == 0) goto L_0x012c
            if (r2 != 0) goto L_0x012c
            boolean r2 = r13.mTemporalInterpolator
            if (r2 == 0) goto L_0x0128
            long r8 = r13.mAnimationStartTime
            long r3 = r3 - r8
            float r2 = (float) r3
            float r2 = r2 * r0
            float r6 = r7.getInterpolation(r2)
            goto L_0x012c
        L_0x0128:
            float r6 = r7.getInterpolation(r6)
        L_0x012c:
            if (r15 <= 0) goto L_0x0134
            float r15 = r13.mTransitionGoalPosition
            int r15 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r15 >= 0) goto L_0x013e
        L_0x0134:
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x0140
            float r14 = r13.mTransitionGoalPosition
            int r14 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0140
        L_0x013e:
            float r6 = r13.mTransitionGoalPosition
        L_0x0140:
            r13.mPostInterpolationPosition = r6
            int r14 = r13.getChildCount()
            long r2 = r13.getNanoTime()
            android.view.animation.Interpolator r15 = r13.mProgressInterpolator
            if (r15 != 0) goto L_0x014f
            goto L_0x0153
        L_0x014f:
            float r6 = r15.getInterpolation(r6)
        L_0x0153:
            if (r1 >= r14) goto L_0x016e
            android.view.View r8 = r13.getChildAt(r1)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r15 = r13.mFrameArrayList
            java.lang.Object r15 = r15.get(r8)
            r7 = r15
            androidx.constraintlayout.motion.widget.MotionController r7 = (androidx.constraintlayout.motion.widget.MotionController) r7
            if (r7 == 0) goto L_0x016b
            androidx.constraintlayout.core.motion.utils.KeyCache r12 = r13.mKeyCache
            r9 = r6
            r10 = r2
            r7.interpolate(r8, r9, r10, r12)
        L_0x016b:
            int r1 = r1 + 1
            goto L_0x0153
        L_0x016e:
            boolean r14 = r13.mMeasureDuringTransition
            if (r14 == 0) goto L_0x0175
            r13.requestLayout()
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v3, types: [boolean]
      assigns: []
      uses: [boolean, ?[int, short, byte, char]]
      mth insns count: 186
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0068  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNestedPreScroll(android.view.View r20, int r21, int r22, int[] r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            androidx.constraintlayout.motion.widget.MotionScene r4 = r0.mScene
            if (r4 != 0) goto L_0x000d
            return
        L_0x000d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r4.mCurrentTransition
            if (r5 == 0) goto L_0x0196
            boolean r6 = r5.mDisable
            r7 = 1
            r6 = r6 ^ r7
            if (r6 != 0) goto L_0x0019
            goto L_0x0196
        L_0x0019:
            r8 = -1
            if (r6 == 0) goto L_0x002b
            androidx.constraintlayout.motion.widget.TouchResponse r6 = r5.mTouchResponse
            if (r6 == 0) goto L_0x002b
            int r6 = r6.mTouchRegionId
            if (r6 == r8) goto L_0x002b
            int r9 = r20.getId()
            if (r9 == r6) goto L_0x002b
            return
        L_0x002b:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r4.mCurrentTransition
            r9 = 0
            if (r6 == 0) goto L_0x0037
            androidx.constraintlayout.motion.widget.TouchResponse r6 = r6.mTouchResponse
            if (r6 == 0) goto L_0x0037
            boolean r6 = r6.mMoveWhenScrollAtTop
            goto L_0x0038
        L_0x0037:
            r6 = 0
        L_0x0038:
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0059
            androidx.constraintlayout.motion.widget.TouchResponse r6 = r5.mTouchResponse
            if (r6 == 0) goto L_0x0048
            int r6 = r6.mFlags
            r6 = r6 & 4
            if (r6 == 0) goto L_0x0048
            r8 = r3
        L_0x0048:
            float r6 = r0.mTransitionPosition
            int r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r12 == 0) goto L_0x0052
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x0059
        L_0x0052:
            boolean r6 = r1.canScrollVertically(r8)
            if (r6 == 0) goto L_0x0059
            return
        L_0x0059:
            androidx.constraintlayout.motion.widget.TouchResponse r5 = r5.mTouchResponse
            if (r5 == 0) goto L_0x00db
            int r5 = r5.mFlags
            r5 = r5 & r7
            if (r5 == 0) goto L_0x00db
            float r5 = (float) r2
            float r6 = (float) r3
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r4.mCurrentTransition
            if (r8 == 0) goto L_0x00b8
            androidx.constraintlayout.motion.widget.TouchResponse r8 = r8.mTouchResponse
            if (r8 == 0) goto L_0x00b8
            androidx.constraintlayout.motion.widget.MotionLayout r12 = r8.mMotionLayout
            float r15 = r12.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r8.mMotionLayout
            int r14 = r8.mTouchAnchorId
            float r12 = r8.mTouchAnchorX
            float r11 = r8.mTouchAnchorY
            float[] r7 = r8.mAnchorDpDt
            r16 = r12
            r17 = r11
            r18 = r7
            r13.getAnchorDpDt(r14, r15, r16, r17, r18)
            float r7 = r8.mTouchDirectionX
            r11 = 869711765(0x33d6bf95, float:1.0E-7)
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x00a2
            float[] r6 = r8.mAnchorDpDt
            r7 = r6[r9]
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x0098
            r6[r9] = r11
        L_0x0098:
            float r6 = r8.mTouchDirectionX
            float r5 = r5 * r6
            float[] r6 = r8.mAnchorDpDt
            r6 = r6[r9]
            float r5 = r5 / r6
            goto L_0x00b9
        L_0x00a2:
            float[] r5 = r8.mAnchorDpDt
            r7 = 1
            r12 = r5[r7]
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x00ad
            r5[r7] = r11
        L_0x00ad:
            float r5 = r8.mTouchDirectionY
            float r6 = r6 * r5
            float[] r5 = r8.mAnchorDpDt
            r5 = r5[r7]
            float r5 = r6 / r5
            goto L_0x00b9
        L_0x00b8:
            r5 = 0
        L_0x00b9:
            float r6 = r0.mTransitionLastPosition
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x00c3
            int r6 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r6 < 0) goto L_0x00cf
        L_0x00c3:
            float r6 = r0.mTransitionLastPosition
            r7 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x00db
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x00db
        L_0x00cf:
            r1.setNestedScrollingEnabled(r9)
            androidx.constraintlayout.motion.widget.MotionLayout$3 r2 = new androidx.constraintlayout.motion.widget.MotionLayout$3
            r2.<init>(r1)
            r1.post(r2)
            return
        L_0x00db:
            float r1 = r0.mTransitionPosition
            long r5 = r19.getNanoTime()
            float r7 = (float) r2
            r0.mScrollTargetDX = r7
            float r8 = (float) r3
            r0.mScrollTargetDY = r8
            long r11 = r0.mScrollTargetTime
            long r11 = r5 - r11
            double r11 = (double) r11
            r13 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            double r11 = r11 * r13
            float r11 = (float) r11
            r0.mScrollTargetDT = r11
            r0.mScrollTargetTime = r5
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = r4.mCurrentTransition
            if (r4 == 0) goto L_0x017c
            androidx.constraintlayout.motion.widget.TouchResponse r4 = r4.mTouchResponse
            if (r4 == 0) goto L_0x017c
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r4.mMotionLayout
            float r5 = r5.getProgress()
            boolean r6 = r4.mDragStarted
            if (r6 != 0) goto L_0x0112
            r6 = 1
            r4.mDragStarted = r6
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r4.mMotionLayout
            r6.setProgress(r5)
        L_0x0112:
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r4.mMotionLayout
            int r12 = r4.mTouchAnchorId
            float r14 = r4.mTouchAnchorX
            float r15 = r4.mTouchAnchorY
            float[] r6 = r4.mAnchorDpDt
            r13 = r5
            r16 = r6
            r11.getAnchorDpDt(r12, r13, r14, r15, r16)
            float r6 = r4.mTouchDirectionX
            float[] r11 = r4.mAnchorDpDt
            r12 = r11[r9]
            float r6 = r6 * r12
            float r12 = r4.mTouchDirectionY
            r13 = 1
            r11 = r11[r13]
            float r12 = r12 * r11
            float r12 = r12 + r6
            float r6 = java.lang.Math.abs(r12)
            double r11 = (double) r6
            r14 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r6 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x0149
            float[] r6 = r4.mAnchorDpDt
            r11 = 1008981770(0x3c23d70a, float:0.01)
            r6[r9] = r11
            r6[r13] = r11
        L_0x0149:
            float r6 = r4.mTouchDirectionX
            int r11 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r11 == 0) goto L_0x0157
            float r7 = r7 * r6
            float[] r6 = r4.mAnchorDpDt
            r6 = r6[r9]
            float r7 = r7 / r6
            goto L_0x0162
        L_0x0157:
            float r6 = r4.mTouchDirectionY
            float r8 = r8 * r6
            float[] r6 = r4.mAnchorDpDt
            r7 = 1
            r6 = r6[r7]
            float r7 = r8 / r6
        L_0x0162:
            float r5 = r5 + r7
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r5, r6)
            float r5 = java.lang.Math.max(r5, r10)
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r4.mMotionLayout
            float r6 = r6.getProgress()
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x017c
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r4.mMotionLayout
            r4.setProgress(r5)
        L_0x017c:
            float r4 = r0.mTransitionPosition
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0188
            r23[r9] = r2
            r1 = 1
            r23[r1] = r3
            goto L_0x0189
        L_0x0188:
            r1 = 1
        L_0x0189:
            r0.evaluate(r9)
            r2 = r23[r9]
            if (r2 != 0) goto L_0x0194
            r2 = r23[r1]
            if (r2 == 0) goto L_0x0196
        L_0x0194:
            r0.mUndergoingMotion = r1
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onNestedPreScroll(android.view.View, int, int, int[], int):void");
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (!(!this.mUndergoingMotion && i == 0 && i2 == 0)) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.mUndergoingMotion = false;
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    public void onNewStateAttachHandlers() {
        View view;
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            if (motionScene.autoTransition(this, this.mCurrentState)) {
                requestLayout();
                return;
            }
            int i = this.mCurrentState;
            if (i != -1) {
                MotionScene motionScene2 = this.mScene;
                Iterator<Transition> it = motionScene2.mTransitionList.iterator();
                while (it.hasNext()) {
                    Transition next = it.next();
                    if (next.mOnClicks.size() > 0) {
                        Iterator<TransitionOnClick> it2 = next.mOnClicks.iterator();
                        while (it2.hasNext()) {
                            it2.next().removeOnClickListeners(this);
                        }
                    }
                }
                Iterator<Transition> it3 = motionScene2.mAbstractTransitionList.iterator();
                while (it3.hasNext()) {
                    Transition next2 = it3.next();
                    if (next2.mOnClicks.size() > 0) {
                        Iterator<TransitionOnClick> it4 = next2.mOnClicks.iterator();
                        while (it4.hasNext()) {
                            it4.next().removeOnClickListeners(this);
                        }
                    }
                }
                Iterator<Transition> it5 = motionScene2.mTransitionList.iterator();
                while (it5.hasNext()) {
                    Transition next3 = it5.next();
                    if (next3.mOnClicks.size() > 0) {
                        Iterator<TransitionOnClick> it6 = next3.mOnClicks.iterator();
                        while (it6.hasNext()) {
                            it6.next().addOnClickListeners(this, i, next3);
                        }
                    }
                }
                Iterator<Transition> it7 = motionScene2.mAbstractTransitionList.iterator();
                while (it7.hasNext()) {
                    Transition next4 = it7.next();
                    if (next4.mOnClicks.size() > 0) {
                        Iterator<TransitionOnClick> it8 = next4.mOnClicks.iterator();
                        while (it8.hasNext()) {
                            it8.next().addOnClickListeners(this, i, next4);
                        }
                    }
                }
            }
            if (this.mScene.supportTouch()) {
                Transition transition = this.mScene.mCurrentTransition;
                if (transition != null) {
                    TouchResponse touchResponse = transition.mTouchResponse;
                    if (touchResponse != null) {
                        int i2 = touchResponse.mTouchAnchorId;
                        if (i2 != -1) {
                            view = touchResponse.mMotionLayout.findViewById(i2);
                            if (view == null) {
                                b.getName(touchResponse.mMotionLayout.getContext(), touchResponse.mTouchAnchorId);
                            }
                        } else {
                            view = null;
                        }
                        if (view instanceof NestedScrollView) {
                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                            nestedScrollView.setOnTouchListener(new OnTouchListener(touchResponse) {
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    return false;
                                }
                            });
                            nestedScrollView.setOnScrollChangeListener(new OnScrollChangeListener(touchResponse) {
                                public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            boolean isRtl = isRtl();
            motionScene.mRtl = isRtl;
            Transition transition = motionScene.mCurrentTransition;
            if (transition != null) {
                TouchResponse touchResponse = transition.mTouchResponse;
                if (touchResponse != null) {
                    touchResponse.setRTL(isRtl);
                }
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            Transition transition = motionScene.mCurrentTransition;
            if (transition != null) {
                TouchResponse touchResponse = transition.mTouchResponse;
                if (touchResponse != null && (touchResponse.mFlags & 2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onStopNestedScroll(View view, int i) {
        float f2;
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f3 = this.mScrollTargetDT;
            float f4 = 0.0f;
            if (f3 != 0.0f) {
                float f5 = this.mScrollTargetDX / f3;
                float f6 = this.mScrollTargetDY / f3;
                Transition transition = motionScene.mCurrentTransition;
                if (transition != null) {
                    TouchResponse touchResponse = transition.mTouchResponse;
                    if (touchResponse != null) {
                        boolean z = false;
                        touchResponse.mDragStarted = false;
                        float progress = touchResponse.mMotionLayout.getProgress();
                        touchResponse.mMotionLayout.getAnchorDpDt(touchResponse.mTouchAnchorId, progress, touchResponse.mTouchAnchorX, touchResponse.mTouchAnchorY, touchResponse.mAnchorDpDt);
                        float f7 = touchResponse.mTouchDirectionX;
                        float[] fArr = touchResponse.mAnchorDpDt;
                        float f8 = fArr[0];
                        float f9 = touchResponse.mTouchDirectionY;
                        float f10 = fArr[1];
                        if (f7 != 0.0f) {
                            f2 = (f5 * f7) / fArr[0];
                        } else {
                            f2 = (f6 * f9) / fArr[1];
                        }
                        if (!Float.isNaN(f2)) {
                            progress += f2 / 3.0f;
                        }
                        if (progress != 0.0f) {
                            boolean z2 = progress != 1.0f;
                            if (touchResponse.mOnTouchUp != 3) {
                                z = true;
                            }
                            if (z && z2) {
                                MotionLayout motionLayout = touchResponse.mMotionLayout;
                                int i2 = touchResponse.mOnTouchUp;
                                if (((double) progress) >= 0.5d) {
                                    f4 = 1.0f;
                                }
                                motionLayout.touchAnimateTo(i2, f4, f2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        if (r14 != -1) goto L_0x0094;
     */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0529  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            if (r2 == 0) goto L_0x081a
            boolean r3 = r0.mInteractionEnabled
            if (r3 == 0) goto L_0x081a
            boolean r2 = r2.supportTouch()
            if (r2 == 0) goto L_0x081a
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r2.mCurrentTransition
            r3 = 1
            if (r2 == 0) goto L_0x0023
            boolean r2 = r2.mDisable
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x0023
            boolean r1 = super.onTouchEvent(r30)
            return r1
        L_0x0023:
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            int r4 = r29.getCurrentState()
            r5 = 0
            if (r2 == 0) goto L_0x0818
            android.graphics.RectF r6 = new android.graphics.RectF
            r6.<init>()
            androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker r7 = r2.mVelocityTracker
            if (r7 != 0) goto L_0x0047
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r2.mMotionLayout
            if (r7 == 0) goto L_0x0046
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r7 = androidx.constraintlayout.motion.widget.MotionLayout.MyTracker.me
            android.view.VelocityTracker r8 = android.view.VelocityTracker.obtain()
            r7.tracker = r8
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r7 = androidx.constraintlayout.motion.widget.MotionLayout.MyTracker.me
            r2.mVelocityTracker = r7
            goto L_0x0047
        L_0x0046:
            throw r5
        L_0x0047:
            androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker r7 = r2.mVelocityTracker
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r7 = (androidx.constraintlayout.motion.widget.MotionLayout.MyTracker) r7
            android.view.VelocityTracker r7 = r7.tracker
            if (r7 == 0) goto L_0x0052
            r7.addMovement(r1)
        L_0x0052:
            r7 = 2
            r8 = -1
            if (r4 == r8) goto L_0x022d
            int r11 = r30.getAction()
            if (r11 == 0) goto L_0x01c1
            if (r11 == r7) goto L_0x0060
            goto L_0x022d
        L_0x0060:
            boolean r11 = r2.mIgnoreTouch
            if (r11 == 0) goto L_0x0066
            goto L_0x022d
        L_0x0066:
            float r11 = r30.getRawY()
            float r12 = r2.mLastTouchY
            float r11 = r11 - r12
            float r12 = r30.getRawX()
            float r13 = r2.mLastTouchX
            float r12 = r12 - r13
            double r13 = (double) r12
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x0080
            double r13 = (double) r11
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0816
        L_0x0080:
            android.view.MotionEvent r13 = r2.mLastTouchDown
            if (r13 != 0) goto L_0x0086
            goto L_0x0816
        L_0x0086:
            if (r4 == r8) goto L_0x0187
            androidx.constraintlayout.widget.StateSet r14 = r2.mStateSet
            if (r14 == 0) goto L_0x0093
            int r14 = r14.stateGetConstraintID(r4, r8, r8)
            if (r14 == r8) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r14 = r4
        L_0x0094:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r9 = r2.mTransitionList
            java.util.Iterator r9 = r9.iterator()
        L_0x009f:
            boolean r17 = r9.hasNext()
            if (r17 == 0) goto L_0x00bb
            java.lang.Object r17 = r9.next()
            r8 = r17
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r8
            int r7 = r8.mConstraintSetStart
            if (r7 == r14) goto L_0x00b5
            int r7 = r8.mConstraintSetEnd
            if (r7 != r14) goto L_0x00b8
        L_0x00b5:
            r15.add(r8)
        L_0x00b8:
            r7 = 2
            r8 = -1
            goto L_0x009f
        L_0x00bb:
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>()
            java.util.Iterator r8 = r15.iterator()
            r14 = r5
            r9 = 0
        L_0x00c6:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0189
            java.lang.Object r15 = r8.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r15 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r15
            boolean r3 = r15.mDisable
            if (r3 == 0) goto L_0x00d8
            goto L_0x0171
        L_0x00d8:
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r15.mTouchResponse
            if (r3 == 0) goto L_0x0171
            boolean r5 = r2.mRtl
            r3.setRTL(r5)
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r15.mTouchResponse
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r2.mMotionLayout
            android.graphics.RectF r3 = r3.getTouchRegion(r5, r7)
            if (r3 == 0) goto L_0x00fb
            float r5 = r13.getX()
            float r10 = r13.getY()
            boolean r3 = r3.contains(r5, r10)
            if (r3 != 0) goto L_0x00fb
            goto L_0x0171
        L_0x00fb:
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r15.mTouchResponse
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r2.mMotionLayout
            android.graphics.RectF r3 = r3.getLimitBoundsTo(r5, r7)
            if (r3 == 0) goto L_0x0114
            float r5 = r13.getX()
            float r10 = r13.getY()
            boolean r3 = r3.contains(r5, r10)
            if (r3 != 0) goto L_0x0114
            goto L_0x0171
        L_0x0114:
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r15.mTouchResponse
            float r5 = r3.mTouchDirectionX
            float r5 = r5 * r12
            float r10 = r3.mTouchDirectionY
            float r10 = r10 * r11
            float r10 = r10 + r5
            boolean r3 = r3.mIsRotateMode
            if (r3 == 0) goto L_0x0155
            float r3 = r13.getX()
            androidx.constraintlayout.motion.widget.TouchResponse r5 = r15.mTouchResponse
            float r5 = r5.mRotateCenterX
            float r3 = r3 - r5
            float r5 = r13.getY()
            androidx.constraintlayout.motion.widget.TouchResponse r10 = r15.mTouchResponse
            float r10 = r10.mRotateCenterY
            float r5 = r5 - r10
            float r10 = r12 + r3
            r18 = r7
            float r7 = r11 + r5
            r19 = r8
            double r7 = (double) r7
            r20 = r11
            double r10 = (double) r10
            double r7 = java.lang.Math.atan2(r7, r10)
            double r10 = (double) r3
            r3 = r12
            r21 = r13
            double r12 = (double) r5
            double r10 = java.lang.Math.atan2(r10, r12)
            double r7 = r7 - r10
            float r5 = (float) r7
            r7 = 1092616192(0x41200000, float:10.0)
            float r10 = r5 * r7
            goto L_0x015e
        L_0x0155:
            r18 = r7
            r19 = r8
            r20 = r11
            r3 = r12
            r21 = r13
        L_0x015e:
            int r5 = r15.mConstraintSetEnd
            if (r5 != r4) goto L_0x0165
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0168
        L_0x0165:
            r5 = 1066192077(0x3f8ccccd, float:1.1)
        L_0x0168:
            float r5 = r5 * r10
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x017a
            r9 = r5
            r14 = r15
            goto L_0x017a
        L_0x0171:
            r18 = r7
            r19 = r8
            r20 = r11
            r3 = r12
            r21 = r13
        L_0x017a:
            r12 = r3
            r7 = r18
            r8 = r19
            r11 = r20
            r13 = r21
            r3 = 1
            r5 = 0
            goto L_0x00c6
        L_0x0187:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r14 = r2.mCurrentTransition
        L_0x0189:
            if (r14 == 0) goto L_0x022d
            r0.setTransition(r14)
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r2.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r2.mMotionLayout
            android.graphics.RectF r3 = r3.getTouchRegion(r4, r6)
            if (r3 == 0) goto L_0x01ae
            android.view.MotionEvent r4 = r2.mLastTouchDown
            float r4 = r4.getX()
            android.view.MotionEvent r5 = r2.mLastTouchDown
            float r5 = r5.getY()
            boolean r3 = r3.contains(r4, r5)
            if (r3 != 0) goto L_0x01ae
            r3 = 1
            goto L_0x01af
        L_0x01ae:
            r3 = 0
        L_0x01af:
            r2.mMotionOutsideRegion = r3
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r2.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            float r4 = r2.mLastTouchX
            float r5 = r2.mLastTouchY
            r3.mLastTouchX = r4
            r3.mLastTouchY = r5
            r4 = 0
            r3.mDragStarted = r4
            goto L_0x022d
        L_0x01c1:
            r4 = 0
            float r3 = r30.getRawX()
            r2.mLastTouchX = r3
            float r3 = r30.getRawY()
            r2.mLastTouchY = r3
            r2.mLastTouchDown = r1
            r2.mIgnoreTouch = r4
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r2.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.mTouchResponse
            if (r1 == 0) goto L_0x0816
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r2.mMotionLayout
            android.graphics.RectF r1 = r1.getLimitBoundsTo(r3, r6)
            if (r1 == 0) goto L_0x01fa
            android.view.MotionEvent r3 = r2.mLastTouchDown
            float r3 = r3.getX()
            android.view.MotionEvent r4 = r2.mLastTouchDown
            float r4 = r4.getY()
            boolean r1 = r1.contains(r3, r4)
            if (r1 != 0) goto L_0x01fa
            r1 = 0
            r2.mLastTouchDown = r1
            r1 = 1
            r2.mIgnoreTouch = r1
            goto L_0x0816
        L_0x01fa:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r2.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.mTouchResponse
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r2.mMotionLayout
            android.graphics.RectF r1 = r1.getTouchRegion(r3, r6)
            if (r1 == 0) goto L_0x021c
            android.view.MotionEvent r3 = r2.mLastTouchDown
            float r3 = r3.getX()
            android.view.MotionEvent r4 = r2.mLastTouchDown
            float r4 = r4.getY()
            boolean r1 = r1.contains(r3, r4)
            if (r1 != 0) goto L_0x021c
            r1 = 1
            r2.mMotionOutsideRegion = r1
            goto L_0x021f
        L_0x021c:
            r1 = 0
            r2.mMotionOutsideRegion = r1
        L_0x021f:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r2.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.mTouchResponse
            float r3 = r2.mLastTouchX
            float r2 = r2.mLastTouchY
            r1.mLastTouchX = r3
            r1.mLastTouchY = r2
            goto L_0x0816
        L_0x022d:
            boolean r3 = r2.mIgnoreTouch
            if (r3 == 0) goto L_0x0233
            goto L_0x0816
        L_0x0233:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r2.mCurrentTransition
            if (r3 == 0) goto L_0x07e7
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            if (r3 == 0) goto L_0x07e7
            boolean r4 = r2.mMotionOutsideRegion
            if (r4 != 0) goto L_0x07e7
            androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker r4 = r2.mVelocityTracker
            boolean r5 = r3.mIsRotateMode
            if (r5 == 0) goto L_0x05b8
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r4 = (androidx.constraintlayout.motion.widget.MotionLayout.MyTracker) r4
            android.view.VelocityTracker r5 = r4.tracker
            if (r5 == 0) goto L_0x024e
            r5.addMovement(r1)
        L_0x024e:
            int r5 = r30.getAction()
            if (r5 == 0) goto L_0x05a7
            r18 = 1135869952(0x43b40000, float:360.0)
            r19 = 1073741824(0x40000000, float:2.0)
            r11 = 1
            if (r5 == r11) goto L_0x0417
            r11 = 2
            if (r5 == r11) goto L_0x0260
            goto L_0x07e7
        L_0x0260:
            r30.getRawY()
            r30.getRawX()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r5 = r5 / r19
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            int r8 = r8.getHeight()
            float r8 = (float) r8
            float r8 = r8 / r19
            int r9 = r3.mRotationCenterId
            r10 = -1
            if (r9 == r10) goto L_0x02b6
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            android.view.View r5 = r5.findViewById(r9)
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            int[] r9 = r3.mTempLoc
            r8.getLocationOnScreen(r9)
            int[] r8 = r3.mTempLoc
            r9 = 0
            r8 = r8[r9]
            float r8 = (float) r8
            int r9 = r5.getLeft()
            int r10 = r5.getRight()
            int r10 = r10 + r9
            float r9 = (float) r10
            float r9 = r9 / r19
            float r8 = r8 + r9
            int[] r9 = r3.mTempLoc
            r10 = 1
            r9 = r9[r10]
            float r9 = (float) r9
            int r10 = r5.getTop()
            int r5 = r5.getBottom()
            int r5 = r5 + r10
            float r5 = (float) r5
            float r5 = r5 / r19
            float r5 = r5 + r9
            r28 = r8
            r8 = r5
            r5 = r28
            goto L_0x0303
        L_0x02b6:
            int r9 = r3.mTouchAnchorId
            r10 = -1
            if (r9 == r10) goto L_0x0303
            androidx.constraintlayout.motion.widget.MotionLayout r10 = r3.mMotionLayout
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r11 = r10.mFrameArrayList
            android.view.View r9 = r10.findViewById(r9)
            java.lang.Object r9 = r11.get(r9)
            androidx.constraintlayout.motion.widget.MotionController r9 = (androidx.constraintlayout.motion.widget.MotionController) r9
            androidx.constraintlayout.motion.widget.MotionLayout r10 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionPaths r9 = r9.mStartMotionPath
            int r9 = r9.mAnimateRelativeTo
            android.view.View r9 = r10.findViewById(r9)
            if (r9 != 0) goto L_0x02d6
            goto L_0x0303
        L_0x02d6:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            int[] r8 = r3.mTempLoc
            r5.getLocationOnScreen(r8)
            int[] r5 = r3.mTempLoc
            r8 = 0
            r5 = r5[r8]
            float r5 = (float) r5
            int r8 = r9.getLeft()
            int r10 = r9.getRight()
            int r10 = r10 + r8
            float r8 = (float) r10
            float r8 = r8 / r19
            float r5 = r5 + r8
            int[] r8 = r3.mTempLoc
            r10 = 1
            r8 = r8[r10]
            float r8 = (float) r8
            int r10 = r9.getTop()
            int r9 = r9.getBottom()
            int r9 = r9 + r10
            float r9 = (float) r9
            float r9 = r9 / r19
            float r8 = r8 + r9
        L_0x0303:
            float r9 = r30.getRawX()
            float r9 = r9 - r5
            float r10 = r30.getRawY()
            float r10 = r10 - r8
            float r11 = r30.getRawY()
            float r11 = r11 - r8
            double r11 = (double) r11
            float r13 = r30.getRawX()
            float r13 = r13 - r5
            double r14 = (double) r13
            double r11 = java.lang.Math.atan2(r11, r14)
            float r13 = r3.mLastTouchY
            float r13 = r13 - r8
            double r13 = (double) r13
            float r8 = r3.mLastTouchX
            float r8 = r8 - r5
            double r6 = (double) r8
            double r5 = java.lang.Math.atan2(r13, r6)
            double r5 = r11 - r5
            r7 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r5 = r5 * r7
            r7 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r5 = r5 / r7
            float r5 = (float) r5
            r6 = 1134886912(0x43a50000, float:330.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0342
            float r5 = r5 - r18
            goto L_0x034a
        L_0x0342:
            r6 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x034a
            float r5 = r5 + r18
        L_0x034a:
            float r6 = java.lang.Math.abs(r5)
            double r6 = (double) r6
            r13 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x035c
            boolean r6 = r3.mDragStarted
            if (r6 == 0) goto L_0x07e7
        L_0x035c:
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r3.mMotionLayout
            float r6 = r6.getProgress()
            boolean r7 = r3.mDragStarted
            if (r7 != 0) goto L_0x036e
            r7 = 1
            r3.mDragStarted = r7
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            r7.setProgress(r6)
        L_0x036e:
            int r7 = r3.mTouchAnchorId
            r8 = -1
            if (r7 == r8) goto L_0x0398
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            float r13 = r3.mTouchAnchorX
            float r14 = r3.mTouchAnchorY
            float[] r15 = r3.mAnchorDpDt
            r22 = r8
            r23 = r7
            r24 = r6
            r25 = r13
            r26 = r14
            r27 = r15
            r22.getAnchorDpDt(r23, r24, r25, r26, r27)
            float[] r7 = r3.mAnchorDpDt
            r8 = 1
            r13 = r7[r8]
            double r13 = (double) r13
            double r13 = java.lang.Math.toDegrees(r13)
            float r13 = (float) r13
            r7[r8] = r13
            goto L_0x039d
        L_0x0398:
            r8 = 1
            float[] r7 = r3.mAnchorDpDt
            r7[r8] = r18
        L_0x039d:
            float r7 = r3.mDragScale
            float r5 = r5 * r7
            float[] r7 = r3.mAnchorDpDt
            r7 = r7[r8]
            float r5 = r5 / r7
            float r5 = r5 + r6
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r5, r6)
            r7 = 0
            float r5 = java.lang.Math.max(r5, r7)
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            float r8 = r8.getProgress()
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x0404
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x03c4
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x03ce
        L_0x03c4:
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r3.mMotionLayout
            if (r7 != 0) goto L_0x03ca
            r7 = 1
            goto L_0x03cb
        L_0x03ca:
            r7 = 0
        L_0x03cb:
            r6.endTrigger(r7)
        L_0x03ce:
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r3.mMotionLayout
            r6.setProgress(r5)
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.computeCurrentVelocity(r5)
            float r5 = r4.getXVelocity()
            float r4 = r4.getYVelocity()
            double r6 = (double) r4
            double r4 = (double) r5
            double r13 = java.lang.Math.hypot(r6, r4)
            double r4 = java.lang.Math.atan2(r6, r4)
            double r4 = r4 - r11
            double r4 = java.lang.Math.sin(r4)
            double r4 = r4 * r13
            double r6 = (double) r9
            double r8 = (double) r10
            double r6 = java.lang.Math.hypot(r6, r8)
            double r4 = r4 / r6
            float r4 = (float) r4
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            double r6 = (double) r4
            double r6 = java.lang.Math.toDegrees(r6)
            float r4 = (float) r6
            r5.mLastVelocity = r4
            goto L_0x0409
        L_0x0404:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r3.mMotionLayout
            r5 = 0
            r4.mLastVelocity = r5
        L_0x0409:
            float r4 = r30.getRawX()
            r3.mLastTouchX = r4
            float r4 = r30.getRawY()
            r3.mLastTouchY = r4
            goto L_0x07e7
        L_0x0417:
            r5 = 0
            r3.mDragStarted = r5
            r5 = 16
            r4.computeCurrentVelocity(r5)
            float r5 = r4.getXVelocity()
            float r4 = r4.getYVelocity()
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r3.mMotionLayout
            float r6 = r6.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            int r7 = r7.getWidth()
            float r7 = (float) r7
            float r7 = r7 / r19
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r3.mMotionLayout
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r19
            int r14 = r3.mRotationCenterId
            r15 = -1
            if (r14 == r15) goto L_0x0473
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            android.view.View r7 = r7.findViewById(r14)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r3.mMotionLayout
            int[] r14 = r3.mTempLoc
            r11.getLocationOnScreen(r14)
            int[] r11 = r3.mTempLoc
            r14 = 0
            r11 = r11[r14]
            float r11 = (float) r11
            int r14 = r7.getLeft()
            int r15 = r7.getRight()
            int r15 = r15 + r14
            float r14 = (float) r15
            float r14 = r14 / r19
            float r14 = r14 + r11
            int[] r11 = r3.mTempLoc
            r15 = 1
            r11 = r11[r15]
            float r11 = (float) r11
            int r15 = r7.getTop()
            int r7 = r7.getBottom()
            goto L_0x04b8
        L_0x0473:
            int r14 = r3.mTouchAnchorId
            r15 = -1
            if (r14 == r15) goto L_0x04be
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r11 = r7.mFrameArrayList
            android.view.View r7 = r7.findViewById(r14)
            java.lang.Object r7 = r11.get(r7)
            androidx.constraintlayout.motion.widget.MotionController r7 = (androidx.constraintlayout.motion.widget.MotionController) r7
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r7.mStartMotionPath
            int r7 = r7.mAnimateRelativeTo
            android.view.View r7 = r11.findViewById(r7)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r3.mMotionLayout
            int[] r14 = r3.mTempLoc
            r11.getLocationOnScreen(r14)
            int[] r11 = r3.mTempLoc
            r14 = 0
            r11 = r11[r14]
            float r11 = (float) r11
            int r14 = r7.getLeft()
            int r15 = r7.getRight()
            int r15 = r15 + r14
            float r14 = (float) r15
            float r14 = r14 / r19
            float r14 = r14 + r11
            int[] r11 = r3.mTempLoc
            r15 = 1
            r11 = r11[r15]
            float r11 = (float) r11
            int r15 = r7.getTop()
            int r7 = r7.getBottom()
        L_0x04b8:
            int r7 = r7 + r15
            float r7 = (float) r7
            float r7 = r7 / r19
            float r11 = r11 + r7
            r7 = r14
        L_0x04be:
            float r14 = r30.getRawX()
            float r14 = r14 - r7
            float r7 = r30.getRawY()
            float r7 = r7 - r11
            double r8 = (double) r7
            double r10 = (double) r14
            double r8 = java.lang.Math.atan2(r8, r10)
            double r8 = java.lang.Math.toDegrees(r8)
            int r10 = r3.mTouchAnchorId
            r11 = -1
            if (r10 == r11) goto L_0x04fc
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r3.mMotionLayout
            float r15 = r3.mTouchAnchorX
            float r12 = r3.mTouchAnchorY
            float[] r13 = r3.mAnchorDpDt
            r22 = r11
            r23 = r10
            r24 = r6
            r25 = r15
            r26 = r12
            r27 = r13
            r22.getAnchorDpDt(r23, r24, r25, r26, r27)
            float[] r10 = r3.mAnchorDpDt
            r11 = 1
            r12 = r10[r11]
            double r12 = (double) r12
            double r12 = java.lang.Math.toDegrees(r12)
            float r12 = (float) r12
            r10[r11] = r12
            goto L_0x0501
        L_0x04fc:
            r11 = 1
            float[] r10 = r3.mAnchorDpDt
            r10[r11] = r18
        L_0x0501:
            float r4 = r4 + r7
            double r10 = (double) r4
            float r5 = r5 + r14
            double r4 = (double) r5
            double r4 = java.lang.Math.atan2(r10, r4)
            double r4 = java.lang.Math.toDegrees(r4)
            double r4 = r4 - r8
            float r4 = (float) r4
            r5 = 1115291648(0x427a0000, float:62.5)
            float r4 = r4 * r5
            boolean r5 = java.lang.Float.isNaN(r4)
            if (r5 != 0) goto L_0x0529
            r5 = 1077936128(0x40400000, float:3.0)
            float r13 = r4 * r5
            float r5 = r3.mDragScale
            float r13 = r13 * r5
            float[] r5 = r3.mAnchorDpDt
            r7 = 1
            r5 = r5[r7]
            float r13 = r13 / r5
            float r13 = r13 + r6
            goto L_0x052a
        L_0x0529:
            r13 = r6
        L_0x052a:
            r5 = 0
            int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0593
            r5 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0593
            int r5 = r3.mOnTouchUp
            r7 = 3
            if (r5 == r7) goto L_0x0593
            float r5 = r3.mDragScale
            float r4 = r4 * r5
            float[] r5 = r3.mAnchorDpDt
            r7 = 1
            r5 = r5[r7]
            float r4 = r4 / r5
            double r7 = (double) r13
            r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x054d
            r5 = 0
            goto L_0x054f
        L_0x054d:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x054f:
            int r7 = r3.mOnTouchUp
            r8 = 6
            if (r7 != r8) goto L_0x0561
            float r5 = r6 + r4
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x055f
            float r4 = java.lang.Math.abs(r4)
        L_0x055f:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x0561:
            int r7 = r3.mOnTouchUp
            r8 = 7
            if (r7 != r8) goto L_0x0574
            float r5 = r6 + r4
            r7 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0573
            float r4 = java.lang.Math.abs(r4)
            float r4 = -r4
        L_0x0573:
            r5 = 0
        L_0x0574:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            int r8 = r3.mOnTouchUp
            r9 = 1077936128(0x40400000, float:3.0)
            float r4 = r4 * r9
            r7.touchAnimateTo(r8, r5, r4)
            r4 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x058a
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x07e7
        L_0x058a:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r3.setState(r4)
            goto L_0x07e7
        L_0x0593:
            r4 = 0
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 >= 0) goto L_0x059e
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 > 0) goto L_0x07e7
        L_0x059e:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r3.setState(r4)
            goto L_0x07e7
        L_0x05a7:
            float r4 = r30.getRawX()
            r3.mLastTouchX = r4
            float r4 = r30.getRawY()
            r3.mLastTouchY = r4
            r4 = 0
            r3.mDragStarted = r4
            goto L_0x07e7
        L_0x05b8:
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r4 = (androidx.constraintlayout.motion.widget.MotionLayout.MyTracker) r4
            android.view.VelocityTracker r5 = r4.tracker
            if (r5 == 0) goto L_0x05c1
            r5.addMovement(r1)
        L_0x05c1:
            int r5 = r30.getAction()
            if (r5 == 0) goto L_0x07d8
            r6 = 1
            if (r5 == r6) goto L_0x06fc
            r6 = 2
            if (r5 == r6) goto L_0x05cf
            goto L_0x07e7
        L_0x05cf:
            float r5 = r30.getRawY()
            float r6 = r3.mLastTouchY
            float r5 = r5 - r6
            float r6 = r30.getRawX()
            float r7 = r3.mLastTouchX
            float r6 = r6 - r7
            float r7 = r3.mTouchDirectionX
            float r7 = r7 * r6
            float r8 = r3.mTouchDirectionY
            float r8 = r8 * r5
            float r8 = r8 + r7
            float r7 = java.lang.Math.abs(r8)
            float r8 = r3.mDragThreshold
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 > 0) goto L_0x05f4
            boolean r7 = r3.mDragStarted
            if (r7 == 0) goto L_0x07e7
        L_0x05f4:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            float r7 = r7.getProgress()
            boolean r8 = r3.mDragStarted
            if (r8 != 0) goto L_0x0606
            r8 = 1
            r3.mDragStarted = r8
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            r8.setProgress(r7)
        L_0x0606:
            int r9 = r3.mTouchAnchorId
            r8 = -1
            if (r9 == r8) goto L_0x061a
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            float r11 = r3.mTouchAnchorX
            float r12 = r3.mTouchAnchorY
            float[] r13 = r3.mAnchorDpDt
            r10 = r7
            r8.getAnchorDpDt(r9, r10, r11, r12, r13)
            r10 = 0
            r11 = 1
            goto L_0x063b
        L_0x061a:
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            int r8 = r8.getWidth()
            androidx.constraintlayout.motion.widget.MotionLayout r9 = r3.mMotionLayout
            int r9 = r9.getHeight()
            int r8 = java.lang.Math.min(r8, r9)
            float r8 = (float) r8
            float[] r9 = r3.mAnchorDpDt
            float r10 = r3.mTouchDirectionY
            float r10 = r10 * r8
            r11 = 1
            r9[r11] = r10
            float r10 = r3.mTouchDirectionX
            float r8 = r8 * r10
            r10 = 0
            r9[r10] = r8
        L_0x063b:
            float r8 = r3.mTouchDirectionX
            float[] r9 = r3.mAnchorDpDt
            r12 = r9[r10]
            float r8 = r8 * r12
            float r10 = r3.mTouchDirectionY
            r9 = r9[r11]
            float r10 = r10 * r9
            float r10 = r10 + r8
            float r8 = r3.mDragScale
            float r10 = r10 * r8
            float r8 = java.lang.Math.abs(r10)
            double r8 = (double) r8
            r10 = 1008981770(0x3c23d70a, float:0.01)
            r11 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0668
            float[] r8 = r3.mAnchorDpDt
            r9 = 0
            r8[r9] = r10
            r11 = 1
            r8[r11] = r10
            goto L_0x066a
        L_0x0668:
            r9 = 0
            r11 = 1
        L_0x066a:
            float r8 = r3.mTouchDirectionX
            r12 = 0
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0677
            float[] r5 = r3.mAnchorDpDt
            r5 = r5[r9]
            float r6 = r6 / r5
            goto L_0x067d
        L_0x0677:
            float[] r6 = r3.mAnchorDpDt
            r6 = r6[r11]
            float r6 = r5 / r6
        L_0x067d:
            float r7 = r7 + r6
            r5 = 1065353216(0x3f800000, float:1.0)
            float r6 = java.lang.Math.min(r7, r5)
            r5 = 0
            float r6 = java.lang.Math.max(r6, r5)
            int r5 = r3.mOnTouchUp
            r7 = 6
            if (r5 != r7) goto L_0x0692
            float r6 = java.lang.Math.max(r6, r10)
        L_0x0692:
            int r5 = r3.mOnTouchUp
            r7 = 7
            if (r5 != r7) goto L_0x069e
            r5 = 1065185444(0x3f7d70a4, float:0.99)
            float r6 = java.lang.Math.min(r6, r5)
        L_0x069e:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            float r5 = r5.getProgress()
            int r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x06e9
            r7 = 0
            int r8 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x06b3
            r7 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x06bd
        L_0x06b3:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            if (r8 != 0) goto L_0x06b9
            r7 = 1
            goto L_0x06ba
        L_0x06b9:
            r7 = 0
        L_0x06ba:
            r5.endTrigger(r7)
        L_0x06bd:
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r3.mMotionLayout
            r5.setProgress(r6)
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.computeCurrentVelocity(r5)
            float r5 = r4.getXVelocity()
            float r4 = r4.getYVelocity()
            float r6 = r3.mTouchDirectionX
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x06dd
            float[] r4 = r3.mAnchorDpDt
            r6 = 0
            r4 = r4[r6]
            float r5 = r5 / r4
            goto L_0x06e4
        L_0x06dd:
            float[] r5 = r3.mAnchorDpDt
            r6 = 1
            r5 = r5[r6]
            float r5 = r4 / r5
        L_0x06e4:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r3.mMotionLayout
            r4.mLastVelocity = r5
            goto L_0x06ee
        L_0x06e9:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r3.mMotionLayout
            r5 = 0
            r4.mLastVelocity = r5
        L_0x06ee:
            float r4 = r30.getRawX()
            r3.mLastTouchX = r4
            float r4 = r30.getRawY()
            r3.mLastTouchY = r4
            goto L_0x07e7
        L_0x06fc:
            r5 = 0
            r3.mDragStarted = r5
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.computeCurrentVelocity(r5)
            float r5 = r4.getXVelocity()
            float r4 = r4.getYVelocity()
            androidx.constraintlayout.motion.widget.MotionLayout r6 = r3.mMotionLayout
            float r6 = r6.getProgress()
            int r8 = r3.mTouchAnchorId
            r7 = -1
            if (r8 == r7) goto L_0x0726
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            float r10 = r3.mTouchAnchorX
            float r11 = r3.mTouchAnchorY
            float[] r12 = r3.mAnchorDpDt
            r9 = r6
            r7.getAnchorDpDt(r8, r9, r10, r11, r12)
            r9 = 0
            r10 = 1
            goto L_0x0747
        L_0x0726:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            int r7 = r7.getWidth()
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r3.mMotionLayout
            int r8 = r8.getHeight()
            int r7 = java.lang.Math.min(r7, r8)
            float r7 = (float) r7
            float[] r8 = r3.mAnchorDpDt
            float r9 = r3.mTouchDirectionY
            float r9 = r9 * r7
            r10 = 1
            r8[r10] = r9
            float r9 = r3.mTouchDirectionX
            float r7 = r7 * r9
            r9 = 0
            r8[r9] = r7
        L_0x0747:
            float r7 = r3.mTouchDirectionX
            float[] r8 = r3.mAnchorDpDt
            r11 = r8[r9]
            r11 = r8[r10]
            r12 = 0
            int r7 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r7 == 0) goto L_0x0758
            r4 = r8[r9]
            float r5 = r5 / r4
            goto L_0x075c
        L_0x0758:
            r5 = r8[r10]
            float r5 = r4 / r5
        L_0x075c:
            boolean r4 = java.lang.Float.isNaN(r5)
            if (r4 != 0) goto L_0x0768
            r4 = 1077936128(0x40400000, float:3.0)
            float r4 = r5 / r4
            float r4 = r4 + r6
            goto L_0x0769
        L_0x0768:
            r4 = r6
        L_0x0769:
            r7 = 0
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x07c5
            r7 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x07c5
            int r7 = r3.mOnTouchUp
            r8 = 3
            if (r7 == r8) goto L_0x07c5
            double r7 = (double) r4
            r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0782
            r4 = 0
            goto L_0x0784
        L_0x0782:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x0784:
            int r7 = r3.mOnTouchUp
            r8 = 6
            if (r7 != r8) goto L_0x0797
            float r4 = r6 + r5
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0795
            float r4 = java.lang.Math.abs(r5)
            r5 = r4
        L_0x0795:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x0797:
            int r7 = r3.mOnTouchUp
            r8 = 7
            if (r7 != r8) goto L_0x07ab
            float r4 = r6 + r5
            r7 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x07aa
            float r4 = java.lang.Math.abs(r5)
            float r4 = -r4
            r5 = r4
        L_0x07aa:
            r4 = 0
        L_0x07ab:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r3.mMotionLayout
            int r8 = r3.mOnTouchUp
            r7.touchAnimateTo(r8, r4, r5)
            r4 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x07bd
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x07e7
        L_0x07bd:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r3.setState(r4)
            goto L_0x07e7
        L_0x07c5:
            r5 = 0
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x07d0
            r5 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x07e7
        L_0x07d0:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r3.mMotionLayout
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r3.setState(r4)
            goto L_0x07e7
        L_0x07d8:
            float r4 = r30.getRawX()
            r3.mLastTouchX = r4
            float r4 = r30.getRawY()
            r3.mLastTouchY = r4
            r4 = 0
            r3.mDragStarted = r4
        L_0x07e7:
            float r3 = r30.getRawX()
            r2.mLastTouchX = r3
            float r3 = r30.getRawY()
            r2.mLastTouchY = r3
            int r1 = r30.getAction()
            r3 = 1
            if (r1 != r3) goto L_0x0816
            androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker r1 = r2.mVelocityTracker
            if (r1 == 0) goto L_0x0816
            androidx.constraintlayout.motion.widget.MotionLayout$MyTracker r1 = (androidx.constraintlayout.motion.widget.MotionLayout.MyTracker) r1
            android.view.VelocityTracker r3 = r1.tracker
            if (r3 == 0) goto L_0x080b
            r3.recycle()
            r3 = 0
            r1.tracker = r3
            goto L_0x080c
        L_0x080b:
            r3 = 0
        L_0x080c:
            r2.mVelocityTracker = r3
            int r1 = r0.mCurrentState
            r3 = -1
            if (r1 == r3) goto L_0x0816
            r2.autoTransition(r0, r1)
        L_0x0816:
            r1 = 1
            return r1
        L_0x0818:
            r1 = r5
            throw r1
        L_0x081a:
            boolean r1 = super.onTouchEvent(r30)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.mUseOnShow) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.mUseOnHide) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    public final void processTransitionCompleted() {
        if (this.mTransitionListener == null) {
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
        }
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public void requestLayout() {
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1) {
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                Transition transition = motionScene.mCurrentTransition;
                if (transition != null && transition.mLayoutDuringTransition == 0) {
                    return;
                }
            }
        }
        super.requestLayout();
    }

    public void setDebugMode(int i) {
        this.mDebugPath = i;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.mDelayedApply = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.mInteractionEnabled = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnHideHelpers.get(i).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnShowHelpers.get(i).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.mProgress = f2;
            return;
        }
        if (i <= 0) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene != null) {
            this.mTransitionInstantly = true;
            this.mTransitionGoalPosition = f2;
            this.mTransitionPosition = f2;
            this.mTransitionLastTime = -1;
            this.mAnimationStartTime = -1;
            this.mInterpolator = null;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        boolean isRtl = isRtl();
        motionScene.mRtl = isRtl;
        Transition transition = motionScene.mCurrentTransition;
        if (transition != null) {
            TouchResponse touchResponse = transition.mTouchResponse;
            if (touchResponse != null) {
                touchResponse.setRTL(isRtl);
            }
        }
        rebuildScene();
    }

    public void setStartState(int i) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            StateCache stateCache = this.mStateCache;
            stateCache.startState = i;
            stateCache.endState = i;
            return;
        }
        this.mCurrentState = i;
    }

    public void setState(TransitionState transitionState) {
        if (transitionState != TransitionState.FINISHED || this.mCurrentState != -1) {
            TransitionState transitionState2 = this.mTransitionState;
            this.mTransitionState = transitionState;
            TransitionState transitionState3 = TransitionState.MOVING;
            if (transitionState2 == transitionState3 && transitionState == transitionState3) {
                fireTransitionChange();
            }
            int ordinal = transitionState2.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (transitionState == TransitionState.MOVING) {
                    fireTransitionChange();
                }
                if (transitionState == TransitionState.FINISHED) {
                    fireTransitionCompleted();
                }
            } else if (ordinal == 2 && transitionState == TransitionState.FINISHED) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            StateCache stateCache = this.mStateCache;
            stateCache.startState = i;
            stateCache.endState = i2;
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i;
            this.mEndState = i2;
            motionScene.setTransition(i, i2);
            this.mModel.initFrom(this.mScene.getConstraintSet(i), this.mScene.getConstraintSet(i2));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            animateTo(0.0f);
        }
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            Transition transition = motionScene.mCurrentTransition;
            if (transition != null) {
                transition.mDuration = Math.max(i, 8);
            } else {
                motionScene.mDefaultDuration = i;
            }
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            stateCache.mProgress = bundle.getFloat("motion.progress");
            stateCache.mVelocity = bundle.getFloat("motion.velocity");
            stateCache.startState = bundle.getInt("motion.StartState");
            stateCache.endState = bundle.getInt("motion.EndState");
            if (isAttachedToWindow()) {
                this.mStateCache.apply();
                return;
            }
            return;
        }
        throw null;
    }

    public String toString() {
        Context context = getContext();
        return b.getName(context, this.mBeginState) + InflateView.KEYWORD_SPLIT + b.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r1 != 7) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        if ((((r4 * r6) - (((r3 * r6) * r6) / 2.0f)) + r1) > 1.0f) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        if ((((((r3 * r6) * r6) / 2.0f) + (r4 * r6)) + r1) < 0.0f) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void touchAnimateTo(int r15, float r16, float r17) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r8 = r16
            r4 = r17
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            float r2 = r0.mTransitionLastPosition
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0012
            return
        L_0x0012:
            r2 = 1
            r0.mTemporalInterpolator = r2
            long r5 = r14.getNanoTime()
            r0.mAnimationStartTime = r5
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            int r3 = r3.getDuration()
            float r3 = (float) r3
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r3 = r3 / r5
            r0.mTransitionDuration = r3
            r0.mTransitionGoalPosition = r8
            r0.mInTransition = r2
            r3 = 7
            r5 = 6
            r6 = 2
            r7 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r10 = 0
            if (r1 == 0) goto L_0x00d1
            if (r1 == r2) goto L_0x00d1
            if (r1 == r6) goto L_0x00d1
            r11 = 4
            if (r1 == r11) goto L_0x00bb
            r11 = 5
            if (r1 == r11) goto L_0x0044
            if (r1 == r5) goto L_0x00d1
            if (r1 == r3) goto L_0x00d1
            goto L_0x0187
        L_0x0044:
            float r1 = r0.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            float r3 = r3.getMaxAcceleration()
            r5 = 1073741824(0x40000000, float:2.0)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x0062
            float r6 = r4 / r3
            float r11 = r4 * r6
            float r3 = r3 * r6
            float r3 = r3 * r6
            float r3 = r3 / r5
            float r11 = r11 - r3
            float r11 = r11 + r1
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0072
            goto L_0x0073
        L_0x0062:
            float r6 = -r4
            float r6 = r6 / r3
            float r7 = r4 * r6
            float r3 = r3 * r6
            float r3 = r3 * r6
            float r3 = r3 / r5
            float r3 = r3 + r7
            float r3 = r3 + r1
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            if (r2 == 0) goto L_0x008b
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r1 = r0.mDecelerateLogic
            float r2 = r0.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            float r3 = r3.getMaxAcceleration()
            r1.initalV = r4
            r1.currentP = r2
            r1.maxA = r3
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r1 = r0.mDecelerateLogic
            r0.mInterpolator = r1
            goto L_0x0187
        L_0x008b:
            androidx.constraintlayout.motion.utils.StopLogic r1 = r0.mStopLogic
            float r2 = r0.mTransitionLastPosition
            float r5 = r0.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            float r6 = r3.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r3.mCurrentTransition
            if (r3 == 0) goto L_0x00a5
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            if (r3 == 0) goto L_0x00a5
            float r3 = r3.mMaxVelocity
            r7 = r3
            goto L_0x00a6
        L_0x00a5:
            r7 = 0
        L_0x00a6:
            r3 = r16
            r4 = r17
            r1.config(r2, r3, r4, r5, r6, r7)
            r0.mLastVelocity = r10
            int r1 = r0.mCurrentState
            r0.mTransitionGoalPosition = r8
            r0.mCurrentState = r1
            androidx.constraintlayout.motion.utils.StopLogic r1 = r0.mStopLogic
            r0.mInterpolator = r1
            goto L_0x0187
        L_0x00bb:
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r1 = r0.mDecelerateLogic
            float r2 = r0.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            float r3 = r3.getMaxAcceleration()
            r1.initalV = r4
            r1.currentP = r2
            r1.maxA = r3
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r1 = r0.mDecelerateLogic
            r0.mInterpolator = r1
            goto L_0x0187
        L_0x00d1:
            if (r1 == r2) goto L_0x00dd
            if (r1 != r3) goto L_0x00d6
            goto L_0x00dd
        L_0x00d6:
            if (r1 == r6) goto L_0x00da
            if (r1 != r5) goto L_0x00de
        L_0x00da:
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00de
        L_0x00dd:
            r8 = 0
        L_0x00de:
            androidx.constraintlayout.motion.widget.MotionScene r1 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r1.mCurrentTransition
            if (r1 == 0) goto L_0x00eb
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.mTouchResponse
            if (r1 == 0) goto L_0x00eb
            int r1 = r1.mAutoCompleteMode
            goto L_0x00ec
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            if (r1 != 0) goto L_0x0111
            androidx.constraintlayout.motion.utils.StopLogic r1 = r0.mStopLogic
            float r2 = r0.mTransitionLastPosition
            float r5 = r0.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            float r6 = r3.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r3.mCurrentTransition
            if (r3 == 0) goto L_0x0108
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            if (r3 == 0) goto L_0x0108
            float r3 = r3.mMaxVelocity
            r7 = r3
            goto L_0x0109
        L_0x0108:
            r7 = 0
        L_0x0109:
            r3 = r8
            r4 = r17
            r1.config(r2, r3, r4, r5, r6, r7)
            goto L_0x017d
        L_0x0111:
            androidx.constraintlayout.motion.utils.StopLogic r1 = r0.mStopLogic
            float r2 = r0.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r3.mCurrentTransition
            if (r3 == 0) goto L_0x0122
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse
            if (r3 == 0) goto L_0x0122
            float r3 = r3.mSpringMass
            goto L_0x0123
        L_0x0122:
            r3 = 0
        L_0x0123:
            androidx.constraintlayout.motion.widget.MotionScene r4 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = r4.mCurrentTransition
            if (r4 == 0) goto L_0x0130
            androidx.constraintlayout.motion.widget.TouchResponse r4 = r4.mTouchResponse
            if (r4 == 0) goto L_0x0130
            float r4 = r4.mSpringStiffness
            goto L_0x0131
        L_0x0130:
            r4 = 0
        L_0x0131:
            androidx.constraintlayout.motion.widget.MotionScene r5 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r5.mCurrentTransition
            if (r5 == 0) goto L_0x013e
            androidx.constraintlayout.motion.widget.TouchResponse r5 = r5.mTouchResponse
            if (r5 == 0) goto L_0x013e
            float r5 = r5.mSpringDamping
            goto L_0x013f
        L_0x013e:
            r5 = 0
        L_0x013f:
            androidx.constraintlayout.motion.widget.MotionScene r6 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r6.mCurrentTransition
            if (r6 == 0) goto L_0x014c
            androidx.constraintlayout.motion.widget.TouchResponse r6 = r6.mTouchResponse
            if (r6 == 0) goto L_0x014c
            float r6 = r6.mSpringStopThreshold
            goto L_0x014d
        L_0x014c:
            r6 = 0
        L_0x014d:
            androidx.constraintlayout.motion.widget.MotionScene r7 = r0.mScene
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.mCurrentTransition
            if (r7 == 0) goto L_0x015a
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r7.mTouchResponse
            if (r7 == 0) goto L_0x015a
            int r7 = r7.mSpringBoundary
            goto L_0x015b
        L_0x015a:
            r7 = 0
        L_0x015b:
            androidx.constraintlayout.core.motion.utils.SpringStopEngine r11 = r1.mSpringStopEngine
            if (r11 != 0) goto L_0x0166
            androidx.constraintlayout.core.motion.utils.SpringStopEngine r11 = new androidx.constraintlayout.core.motion.utils.SpringStopEngine
            r11.<init>()
            r1.mSpringStopEngine = r11
        L_0x0166:
            androidx.constraintlayout.core.motion.utils.SpringStopEngine r11 = r1.mSpringStopEngine
            r1.mEngine = r11
            double r12 = (double) r8
            r11.mTargetPos = r12
            double r12 = (double) r5
            r11.mDamping = r12
            r11.mPos = r2
            double r1 = (double) r4
            r11.mStiffness = r1
            r11.mMass = r3
            r11.mStopThreshold = r6
            r11.mBoundaryMode = r7
            r11.mLastTime = r10
        L_0x017d:
            int r1 = r0.mCurrentState
            r0.mTransitionGoalPosition = r8
            r0.mCurrentState = r1
            androidx.constraintlayout.motion.utils.StopLogic r1 = r0.mStopLogic
            r0.mInterpolator = r1
        L_0x0187:
            r0.mTransitionInstantly = r9
            long r1 = r14.getNanoTime()
            r0.mAnimationStartTime = r1
            r14.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToState(int i) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.endState = i;
            return;
        }
        transitionToState(i, -1, -1, -1);
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.mConstraintSetMap.put(i, constraintSet);
        }
        this.mModel.initFrom(this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        if (this.mCurrentState == i) {
            constraintSet.applyToInternal(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void viewTransition(int i, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<ViewTransition> it = viewTransitionController.viewTransitions.iterator();
                while (it.hasNext()) {
                    ViewTransition next = it.next();
                    if (next.mId == i) {
                        for (View view : viewArr) {
                            if (next.checkTags(view)) {
                                arrayList.add(view);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                            int currentState = viewTransitionController.mMotionLayout.getCurrentState();
                            if (next.mViewTransitionMode == 2) {
                                next.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, null, viewArr2);
                            } else if (currentState == -1) {
                                viewTransitionController.mMotionLayout.toString();
                            } else {
                                ConstraintSet constraintSet = viewTransitionController.mMotionLayout.getConstraintSet(currentState);
                                if (constraintSet != null) {
                                    next.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, viewArr2);
                                }
                            }
                            arrayList.clear();
                        }
                    }
                }
                return;
            }
            throw null;
        }
    }

    public void transitionToState(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.endState = i;
            return;
        }
        transitionToState(i, -1, -1, i2);
    }

    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, (float) i2, (float) i3);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i).applyToInternal(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void transitionToState(int i, int i2, int i3, int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            StateSet stateSet = motionScene.mStateSet;
            if (stateSet != null) {
                int i5 = this.mCurrentState;
                float f2 = (float) i2;
                float f3 = (float) i3;
                State state = stateSet.mStateList.get(i);
                if (state == null) {
                    i5 = i;
                } else if (f2 != -1.0f && f3 != -1.0f) {
                    Iterator<Variant> it = state.mVariants.iterator();
                    Variant variant = null;
                    while (true) {
                        if (it.hasNext()) {
                            Variant next = it.next();
                            if (next.match(f2, f3)) {
                                if (i5 == next.mConstraintID) {
                                    break;
                                }
                                variant = next;
                            }
                        } else {
                            i5 = variant != null ? variant.mConstraintID : state.mConstraintID;
                        }
                    }
                } else if (state.mConstraintID != i5) {
                    Iterator<Variant> it2 = state.mVariants.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (i5 == it2.next().mConstraintID) {
                                break;
                            }
                        } else {
                            i5 = state.mConstraintID;
                            break;
                        }
                    }
                }
                if (i5 != -1) {
                    i = i5;
                }
            }
        }
        int i6 = this.mCurrentState;
        if (i6 != i) {
            if (this.mBeginState == i) {
                animateTo(0.0f);
                if (i4 > 0) {
                    this.mTransitionDuration = ((float) i4) / 1000.0f;
                }
            } else if (this.mEndState == i) {
                animateTo(1.0f);
                if (i4 > 0) {
                    this.mTransitionDuration = ((float) i4) / 1000.0f;
                }
            } else {
                this.mEndState = i;
                if (i6 != -1) {
                    setTransition(i6, i);
                    animateTo(1.0f);
                    this.mTransitionLastPosition = 0.0f;
                    transitionToEnd();
                    if (i4 > 0) {
                        this.mTransitionDuration = ((float) i4) / 1000.0f;
                    }
                    return;
                }
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = 1.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.mInterpolator = null;
                if (i4 == -1) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                }
                this.mBeginState = -1;
                this.mScene.setTransition(-1, this.mEndState);
                SparseArray sparseArray = new SparseArray();
                if (i4 == 0) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                } else if (i4 > 0) {
                    this.mTransitionDuration = ((float) i4) / 1000.0f;
                }
                int childCount = getChildCount();
                this.mFrameArrayList.clear();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    this.mFrameArrayList.put(childAt, new MotionController(childAt));
                    sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
                }
                this.mInTransition = true;
                this.mModel.initFrom(null, this.mScene.getConstraintSet(i));
                rebuildScene();
                this.mModel.build();
                int childCount2 = getChildCount();
                for (int i8 = 0; i8 < childCount2; i8++) {
                    View childAt2 = getChildAt(i8);
                    MotionController motionController = this.mFrameArrayList.get(childAt2);
                    if (motionController != null) {
                        MotionPaths motionPaths = motionController.mStartMotionPath;
                        motionPaths.time = 0.0f;
                        motionPaths.position = 0.0f;
                        motionPaths.setBounds(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                        motionController.mStartPoint.setState(childAt2);
                    }
                }
                int width = getWidth();
                int height = getHeight();
                if (this.mDecoratorsHelpers != null) {
                    for (int i9 = 0; i9 < childCount; i9++) {
                        MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i9));
                        if (motionController2 != null) {
                            this.mScene.getKeyFrames(motionController2);
                        }
                    }
                    Iterator<MotionHelper> it3 = this.mDecoratorsHelpers.iterator();
                    while (it3.hasNext()) {
                        it3.next().onPreSetup(this, this.mFrameArrayList);
                    }
                    for (int i10 = 0; i10 < childCount; i10++) {
                        MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i10));
                        if (motionController3 != null) {
                            motionController3.setup(width, height, getNanoTime());
                        }
                    }
                } else {
                    for (int i11 = 0; i11 < childCount; i11++) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i11));
                        if (motionController4 != null) {
                            this.mScene.getKeyFrames(motionController4);
                            motionController4.setup(width, height, getNanoTime());
                        }
                    }
                }
                Transition transition = this.mScene.mCurrentTransition;
                float f4 = transition != null ? transition.mStagger : 0.0f;
                if (f4 != 0.0f) {
                    float f5 = Float.MAX_VALUE;
                    float f6 = -3.4028235E38f;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionPaths motionPaths2 = this.mFrameArrayList.get(getChildAt(i12)).mEndMotionPath;
                        float f7 = motionPaths2.y + motionPaths2.x;
                        f5 = Math.min(f5, f7);
                        f6 = Math.max(f6, f7);
                    }
                    for (int i13 = 0; i13 < childCount; i13++) {
                        MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i13));
                        MotionPaths motionPaths3 = motionController5.mEndMotionPath;
                        float f8 = motionPaths3.x;
                        float f9 = motionPaths3.y;
                        motionController5.mStaggerScale = 1.0f / (1.0f - f4);
                        motionController5.mStaggerOffset = f4 - ((((f8 + f9) - f5) * f4) / (f6 - f5));
                    }
                }
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mInTransition = true;
                invalidate();
            }
        }
    }

    public void setTransition(int i) {
        if (this.mScene != null) {
            Transition transition = getTransition(i);
            this.mBeginState = transition.mConstraintSetStart;
            this.mEndState = transition.mConstraintSetEnd;
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                StateCache stateCache = this.mStateCache;
                stateCache.startState = this.mBeginState;
                stateCache.endState = this.mEndState;
                return;
            }
            float f2 = Float.NaN;
            int i2 = this.mCurrentState;
            if (i2 == this.mBeginState) {
                f2 = 0.0f;
            } else if (i2 == this.mEndState) {
                f2 = 1.0f;
            }
            MotionScene motionScene = this.mScene;
            motionScene.mCurrentTransition = transition;
            TouchResponse touchResponse = transition.mTouchResponse;
            if (touchResponse != null) {
                touchResponse.setRTL(motionScene.mRtl);
            }
            this.mModel.initFrom(this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (this.mTransitionLastPosition != f2) {
                if (f2 == 0.0f) {
                    endTrigger(true);
                    this.mScene.getConstraintSet(this.mBeginState).applyToInternal(this, true);
                    setConstraintSet(null);
                    requestLayout();
                } else if (f2 == 1.0f) {
                    endTrigger(false);
                    this.mScene.getConstraintSet(this.mEndState).applyToInternal(this, true);
                    setConstraintSet(null);
                    requestLayout();
                }
            }
            this.mTransitionLastPosition = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                b.getLocation();
                animateTo(0.0f);
            } else {
                setProgress(f2);
            }
        }
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public void setTransition(Transition transition) {
        long j;
        MotionScene motionScene = this.mScene;
        motionScene.mCurrentTransition = transition;
        if (transition != null) {
            TouchResponse touchResponse = transition.mTouchResponse;
            if (touchResponse != null) {
                touchResponse.setRTL(motionScene.mRtl);
            }
        }
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        boolean z = true;
        if ((transition.mTransitionFlags & 1) == 0) {
            z = false;
        }
        if (z) {
            j = -1;
        } else {
            j = getNanoTime();
        }
        this.mTransitionLastTime = j;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId != this.mBeginState || endId != this.mEndState) {
            this.mBeginState = startId;
            this.mEndState = endId;
            this.mScene.setTransition(startId, endId);
            this.mModel.initFrom(this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            Model model = this.mModel;
            int i = this.mBeginState;
            int i2 = this.mEndState;
            model.mStartId = i;
            model.mEndId = i2;
            model.reEvaluateState();
            rebuildScene();
        }
    }
}
