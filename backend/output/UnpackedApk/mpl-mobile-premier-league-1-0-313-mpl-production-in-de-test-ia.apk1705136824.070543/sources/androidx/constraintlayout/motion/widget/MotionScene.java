package androidx.constraintlayout.motion.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker;
import androidx.constraintlayout.motion.widget.MotionLayout.TransitionState;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Layout;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import androidx.constraintlayout.widget.ConstraintSet.PropertySet;
import androidx.constraintlayout.widget.ConstraintSet.Transform;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    public boolean DEBUG_DESKTOP = false;
    public ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    public HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    public Transition mCurrentTransition = null;
    public int mDefaultDuration = 400;
    public Transition mDefaultTransition = null;
    public SparseIntArray mDeriveMap = new SparseIntArray();
    public boolean mDisableAutoTransition = false;
    public boolean mIgnoreTouch = false;
    public MotionEvent mLastTouchDown;
    public float mLastTouchX;
    public float mLastTouchY;
    public int mLayoutDuringTransition = 0;
    public final MotionLayout mMotionLayout;
    public boolean mMotionOutsideRegion = false;
    public boolean mRtl;
    public StateSet mStateSet = null;
    public ArrayList<Transition> mTransitionList = new ArrayList<>();
    public MotionTracker mVelocityTracker;
    public final ViewTransitionController mViewTransitionController;

    public static class Transition {
        public int mAutoTransition = 0;
        public int mConstraintSetEnd = -1;
        public int mConstraintSetStart = -1;
        public int mDefaultInterpolator = 0;
        public int mDefaultInterpolatorID = -1;
        public String mDefaultInterpolatorString = null;
        public boolean mDisable = false;
        public int mDuration = 400;
        public int mId = -1;
        public boolean mIsAbstract = false;
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        public int mLayoutDuringTransition = 0;
        public final MotionScene mMotionScene;
        public ArrayList<TransitionOnClick> mOnClicks = new ArrayList<>();
        public int mPathMotionArc = -1;
        public float mStagger = 0.0f;
        public TouchResponse mTouchResponse = null;
        public int mTransitionFlags = 0;

        public static class TransitionOnClick implements OnClickListener {
            public int mMode = 17;
            public int mTargetId = -1;
            public final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R$styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARNING: type inference failed for: r6v1, types: [android.view.View] */
            /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
            /* JADX WARNING: type inference failed for: r6v3 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void addOnClickListeners(androidx.constraintlayout.motion.widget.MotionLayout r6, int r7, androidx.constraintlayout.motion.widget.MotionScene.Transition r8) {
                /*
                    r5 = this;
                    int r0 = r5.mTargetId
                    r1 = -1
                    if (r0 != r1) goto L_0x0006
                    goto L_0x000a
                L_0x0006:
                    android.view.View r6 = r6.findViewById(r0)
                L_0x000a:
                    if (r6 != 0) goto L_0x000d
                    return
                L_0x000d:
                    int r0 = r8.mConstraintSetStart
                    int r8 = r8.mConstraintSetEnd
                    if (r0 != r1) goto L_0x0017
                    r6.setOnClickListener(r5)
                    return
                L_0x0017:
                    int r1 = r5.mMode
                    r2 = 1
                    r1 = r1 & r2
                    r3 = 0
                    if (r1 == 0) goto L_0x0022
                    if (r7 != r0) goto L_0x0022
                    r1 = 1
                    goto L_0x0023
                L_0x0022:
                    r1 = 0
                L_0x0023:
                    int r4 = r5.mMode
                    r4 = r4 & 256(0x100, float:3.59E-43)
                    if (r4 == 0) goto L_0x002d
                    if (r7 != r0) goto L_0x002d
                    r4 = 1
                    goto L_0x002e
                L_0x002d:
                    r4 = 0
                L_0x002e:
                    r1 = r1 | r4
                    int r4 = r5.mMode
                    r4 = r4 & r2
                    if (r4 == 0) goto L_0x0038
                    if (r7 != r0) goto L_0x0038
                    r0 = 1
                    goto L_0x0039
                L_0x0038:
                    r0 = 0
                L_0x0039:
                    r0 = r0 | r1
                    int r1 = r5.mMode
                    r1 = r1 & 16
                    if (r1 == 0) goto L_0x0044
                    if (r7 != r8) goto L_0x0044
                    r1 = 1
                    goto L_0x0045
                L_0x0044:
                    r1 = 0
                L_0x0045:
                    r0 = r0 | r1
                    int r1 = r5.mMode
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x004f
                    if (r7 != r8) goto L_0x004f
                    goto L_0x0050
                L_0x004f:
                    r2 = 0
                L_0x0050:
                    r7 = r0 | r2
                    if (r7 == 0) goto L_0x0057
                    r6.setOnClickListener(r5)
                L_0x0057:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick.addOnClickListeners(androidx.constraintlayout.motion.widget.MotionLayout, int, androidx.constraintlayout.motion.widget.MotionScene$Transition):void");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
                if (r1.mCurrentState != r9) goto L_0x0098;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0096, code lost:
                if (r2 != r9) goto L_0x0099;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r9) {
                /*
                    r8 = this;
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.mMotionLayout
                    boolean r2 = r1.mInteractionEnabled
                    if (r2 != 0) goto L_0x000b
                    return
                L_0x000b:
                    int r9 = r9.mConstraintSetStart
                    r2 = -1
                    if (r9 != r2) goto L_0x0036
                    int r9 = r1.getCurrentState()
                    if (r9 != r2) goto L_0x001e
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.mTransition
                    int r9 = r9.mConstraintSetEnd
                    r1.transitionToState(r9)
                    return
                L_0x001e:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r8.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r3 = r2.mMotionScene
                    r0.<init>(r3, r2)
                    r0.mConstraintSetStart = r9
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.mTransition
                    int r9 = r9.mConstraintSetEnd
                    r0.mConstraintSetEnd = r9
                    r1.setTransition(r0)
                    r1.transitionToEnd()
                    return
                L_0x0036:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r0.mCurrentTransition
                    int r0 = r8.mMode
                    r3 = r0 & 1
                    r4 = 0
                    r5 = 1
                    if (r3 != 0) goto L_0x0047
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x0045
                    goto L_0x0047
                L_0x0045:
                    r0 = 0
                    goto L_0x0048
                L_0x0047:
                    r0 = 1
                L_0x0048:
                    int r3 = r8.mMode
                    r6 = r3 & 16
                    if (r6 != 0) goto L_0x0055
                    r3 = r3 & 4096(0x1000, float:5.74E-42)
                    if (r3 == 0) goto L_0x0053
                    goto L_0x0055
                L_0x0053:
                    r3 = 0
                    goto L_0x0056
                L_0x0055:
                    r3 = 1
                L_0x0056:
                    if (r0 == 0) goto L_0x005c
                    if (r3 == 0) goto L_0x005c
                    r6 = 1
                    goto L_0x005d
                L_0x005c:
                    r6 = 0
                L_0x005d:
                    if (r6 == 0) goto L_0x0082
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r8.mTransition
                    androidx.constraintlayout.motion.widget.MotionScene r7 = r6.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r7.mCurrentTransition
                    if (r7 == r6) goto L_0x006a
                    r1.setTransition(r6)
                L_0x006a:
                    int r6 = r1.getCurrentState()
                    int r7 = r1.getEndState()
                    if (r6 == r7) goto L_0x0081
                    float r6 = r1.getProgress()
                    r7 = 1056964608(0x3f000000, float:0.5)
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 <= 0) goto L_0x007f
                    goto L_0x0081
                L_0x007f:
                    r3 = 0
                    goto L_0x0082
                L_0x0081:
                    r0 = 0
                L_0x0082:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r8.mTransition
                    if (r6 != r9) goto L_0x0087
                    goto L_0x0098
                L_0x0087:
                    int r9 = r6.mConstraintSetEnd
                    int r6 = r6.mConstraintSetStart
                    if (r6 != r2) goto L_0x0092
                    int r2 = r1.mCurrentState
                    if (r2 == r9) goto L_0x0099
                    goto L_0x0098
                L_0x0092:
                    int r2 = r1.mCurrentState
                    if (r2 == r6) goto L_0x0098
                    if (r2 != r9) goto L_0x0099
                L_0x0098:
                    r4 = 1
                L_0x0099:
                    if (r4 == 0) goto L_0x00e0
                    if (r0 == 0) goto L_0x00ab
                    int r9 = r8.mMode
                    r9 = r9 & r5
                    if (r9 == 0) goto L_0x00ab
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.mTransition
                    r1.setTransition(r9)
                    r1.transitionToEnd()
                    goto L_0x00e0
                L_0x00ab:
                    r9 = 0
                    if (r3 == 0) goto L_0x00bd
                    int r2 = r8.mMode
                    r2 = r2 & 16
                    if (r2 == 0) goto L_0x00bd
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r8.mTransition
                    r1.setTransition(r0)
                    r1.animateTo(r9)
                    goto L_0x00e0
                L_0x00bd:
                    if (r0 == 0) goto L_0x00d0
                    int r0 = r8.mMode
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.mTransition
                    r1.setTransition(r9)
                    r9 = 1065353216(0x3f800000, float:1.0)
                    r1.setProgress(r9)
                    goto L_0x00e0
                L_0x00d0:
                    if (r3 == 0) goto L_0x00e0
                    int r0 = r8.mMode
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r8.mTransition
                    r1.setTransition(r0)
                    r1.setProgress(r9)
                L_0x00e0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick.onClick(android.view.View):void");
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i = this.mTargetId;
                if (i != -1) {
                    View findViewById = motionLayout.findViewById(i);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(null);
                    }
                }
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Transition);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = obtainStyledAttributes.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = obtainStyledAttributes.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i2 = obtainStyledAttributes.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i2 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i3 = obtainStyledAttributes.getInt(index, this.mDuration);
                    this.mDuration = i3;
                    if (i3 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.mStagger = obtainStyledAttributes.getFloat(index, this.mStagger);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.mAutoTransition = obtainStyledAttributes.getInteger(index, this.mAutoTransition);
                } else if (index == R$styleable.Transition_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.mDisable = obtainStyledAttributes.getBoolean(index, this.mDisable);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MotionScene(android.content.Context r11, androidx.constraintlayout.motion.widget.MotionLayout r12, int r13) {
        /*
            r10 = this;
            r10.<init>()
            r0 = 0
            r10.mStateSet = r0
            r10.mCurrentTransition = r0
            r1 = 0
            r10.mDisableAutoTransition = r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r10.mTransitionList = r2
            r10.mDefaultTransition = r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r10.mAbstractTransitionList = r2
            android.util.SparseArray r2 = new android.util.SparseArray
            r2.<init>()
            r10.mConstraintSetMap = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r10.mConstraintSetIdMap = r2
            android.util.SparseIntArray r2 = new android.util.SparseIntArray
            r2.<init>()
            r10.mDeriveMap = r2
            r10.DEBUG_DESKTOP = r1
            r2 = 400(0x190, float:5.6E-43)
            r10.mDefaultDuration = r2
            r10.mLayoutDuringTransition = r1
            r10.mIgnoreTouch = r1
            r10.mMotionOutsideRegion = r1
            r10.mMotionLayout = r12
            androidx.constraintlayout.motion.widget.ViewTransitionController r2 = new androidx.constraintlayout.motion.widget.ViewTransitionController
            r2.<init>(r12)
            r10.mViewTransitionController = r2
            android.content.res.Resources r12 = r11.getResources()
            android.content.res.XmlResourceParser r12 = r12.getXml(r13)
            int r2 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r3 = r0
        L_0x0052:
            r4 = 1
            if (r2 == r4) goto L_0x019f
            if (r2 == 0) goto L_0x018d
            r5 = 2
            if (r2 == r5) goto L_0x005c
            goto L_0x0190
        L_0x005c:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            boolean r6 = r10.DEBUG_DESKTOP     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r6 == 0) goto L_0x007a
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r7.<init>()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            java.lang.String r8 = "parsing = "
            r7.append(r8)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r7.append(r2)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            java.lang.String r7 = r7.toString()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r6.println(r7)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x007a:
            int r6 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r7 = 4
            r8 = 5
            r9 = -1
            switch(r6) {
                case -1349929691: goto L_0x00e1;
                case -1239391468: goto L_0x00d6;
                case -687739768: goto L_0x00cc;
                case 61998586: goto L_0x00c1;
                case 269306229: goto L_0x00b7;
                case 312750793: goto L_0x00ad;
                case 327855227: goto L_0x00a4;
                case 793277014: goto L_0x009a;
                case 1382829617: goto L_0x0090;
                case 1942574248: goto L_0x0086;
                default: goto L_0x0084;
            }     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x0084:
            goto L_0x00eb
        L_0x0086:
            java.lang.String r5 = "include"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 6
            goto L_0x00ec
        L_0x0090:
            java.lang.String r5 = "StateSet"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 4
            goto L_0x00ec
        L_0x009a:
            java.lang.String r5 = "MotionScene"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 0
            goto L_0x00ec
        L_0x00a4:
            java.lang.String r6 = "OnSwipe"
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00ad:
            java.lang.String r5 = "OnClick"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 3
            goto L_0x00ec
        L_0x00b7:
            java.lang.String r5 = "Transition"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 1
            goto L_0x00ec
        L_0x00c1:
            java.lang.String r5 = "ViewTransition"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 9
            goto L_0x00ec
        L_0x00cc:
            java.lang.String r5 = "Include"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 7
            goto L_0x00ec
        L_0x00d6:
            java.lang.String r5 = "KeyFrameSet"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 8
            goto L_0x00ec
        L_0x00e1:
            java.lang.String r5 = "ConstraintSet"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x00eb
            r5 = 5
            goto L_0x00ec
        L_0x00eb:
            r5 = -1
        L_0x00ec:
            switch(r5) {
                case 0: goto L_0x0189;
                case 1: goto L_0x0154;
                case 2: goto L_0x013c;
                case 3: goto L_0x012f;
                case 4: goto L_0x0127;
                case 5: goto L_0x0122;
                case 6: goto L_0x011d;
                case 7: goto L_0x011d;
                case 8: goto L_0x010f;
                case 9: goto L_0x00f1;
                default: goto L_0x00ef;
            }     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x00ef:
            goto L_0x0190
        L_0x00f1:
            androidx.constraintlayout.motion.widget.ViewTransition r2 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r5 = r10.mViewTransitionController     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.ViewTransition> r6 = r5.viewTransitions     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r6.add(r2)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r5.mRelatedViews = r0     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            int r6 = r2.mOnStateTransition     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r6 != r7) goto L_0x0108
            r5.listenForSharedVariable(r2, r4)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x0108:
            if (r6 != r8) goto L_0x0190
            r5.listenForSharedVariable(r2, r1)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x010f:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r3 == 0) goto L_0x0190
            java.util.ArrayList<androidx.constraintlayout.motion.widget.KeyFrames> r4 = r3.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r4.add(r2)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x011d:
            r10.parseInclude(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x0122:
            r10.parseConstraintSet(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x0127:
            androidx.constraintlayout.widget.StateSet r2 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r10.mStateSet = r2     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x012f:
            if (r3 == 0) goto L_0x0190
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick> r2 = r3.mOnClicks     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick r4 = new androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r4.<init>(r11, r3, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.add(r4)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x013c:
            if (r3 != 0) goto L_0x0148
            android.content.res.Resources r2 = r11.getResources()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.getResourceEntryName(r13)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r12.getLineNumber()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x0148:
            if (r3 == 0) goto L_0x0190
            androidx.constraintlayout.motion.widget.TouchResponse r2 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r10.mMotionLayout     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.<init>(r11, r4, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r3.mTouchResponse = r2     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x0154:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r2 = r10.mTransitionList     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r3.<init>(r10, r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.add(r3)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r10.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 != 0) goto L_0x0173
            boolean r2 = r3.mIsAbstract     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 != 0) goto L_0x0173
            r10.mCurrentTransition = r3     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            androidx.constraintlayout.motion.widget.TouchResponse r2 = r3.mTouchResponse     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x0173
            androidx.constraintlayout.motion.widget.TouchResponse r2 = r3.mTouchResponse     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            boolean r4 = r10.mRtl     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.setRTL(r4)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x0173:
            boolean r2 = r3.mIsAbstract     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 == 0) goto L_0x0190
            int r2 = r3.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            if (r2 != r9) goto L_0x017e
            r10.mDefaultTransition = r3     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0183
        L_0x017e:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r2 = r10.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.add(r3)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x0183:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r2 = r10.mTransitionList     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            r2.remove(r3)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x0189:
            r10.parseMotionSceneTags(r11, r12)     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0190
        L_0x018d:
            r12.getName()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
        L_0x0190:
            int r2 = r12.next()     // Catch:{ XmlPullParserException -> 0x019b, IOException -> 0x0196 }
            goto L_0x0052
        L_0x0196:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x019f
        L_0x019b:
            r11 = move-exception
            r11.printStackTrace()
        L_0x019f:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r11 = r10.mConstraintSetMap
            int r12 = androidx.constraintlayout.widget.R$id.motion_base
            androidx.constraintlayout.widget.ConstraintSet r13 = new androidx.constraintlayout.widget.ConstraintSet
            r13.<init>()
            r11.put(r12, r13)
            java.util.HashMap<java.lang.String, java.lang.Integer> r11 = r10.mConstraintSetIdMap
            int r12 = androidx.constraintlayout.widget.R$id.motion_base
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "motion_base"
            r11.put(r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.<init>(android.content.Context, androidx.constraintlayout.motion.widget.MotionLayout, int):void");
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        if ((this.mVelocityTracker != null) || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0) {
                Transition transition = this.mCurrentTransition;
                if (transition == next) {
                    if ((transition.mTransitionFlags & 2) != 0) {
                        continue;
                    }
                }
                if (i == next.mConstraintSetStart) {
                    int i2 = next.mAutoTransition;
                    if (i2 == 4 || i2 == 2) {
                        motionLayout.setState(TransitionState.FINISHED);
                        motionLayout.setTransition(next);
                        if (next.mAutoTransition == 4) {
                            motionLayout.transitionToEnd();
                            motionLayout.setState(TransitionState.SETUP);
                            motionLayout.setState(TransitionState.MOVING);
                        } else {
                            motionLayout.setProgress(1.0f);
                            motionLayout.evaluate(true);
                            motionLayout.setState(TransitionState.SETUP);
                            motionLayout.setState(TransitionState.MOVING);
                            motionLayout.setState(TransitionState.FINISHED);
                            motionLayout.onNewStateAttachHandlers();
                        }
                        return true;
                    }
                }
                if (i == next.mConstraintSetEnd) {
                    int i3 = next.mAutoTransition;
                    if (i3 == 3 || i3 == 1) {
                        motionLayout.setState(TransitionState.FINISHED);
                        motionLayout.setTransition(next);
                        if (next.mAutoTransition == 3) {
                            motionLayout.animateTo(0.0f);
                            motionLayout.setState(TransitionState.SETUP);
                            motionLayout.setState(TransitionState.MOVING);
                        } else {
                            motionLayout.setProgress(0.0f);
                            motionLayout.evaluate(true);
                            motionLayout.setState(TransitionState.SETUP);
                            motionLayout.setState(TransitionState.MOVING);
                            motionLayout.setState(TransitionState.FINISHED);
                            motionLayout.onNewStateAttachHandlers();
                        }
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public ConstraintSet getConstraintSet(int i) {
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            printStream.println("id " + i);
            PrintStream printStream2 = System.out;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("size ");
            outline73.append(this.mConstraintSetMap.size());
            printStream2.println(outline73.toString());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null) {
            int stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1);
            if (stateGetConstraintID != -1) {
                i = stateGetConstraintID;
            }
        }
        if (this.mConstraintSetMap.get(i) != null) {
            return this.mConstraintSetMap.get(i);
        }
        b.getName(this.mMotionLayout.getContext(), i);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public final int getId(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream = System.out;
                printStream.println("id getMap res = " + i);
            }
        } else {
            i = -1;
        }
        return (i != -1 || str.length() <= 1) ? i : Integer.parseInt(str.substring(1));
    }

    public Interpolator getInterpolator() {
        Transition transition = this.mCurrentTransition;
        int i = transition.mDefaultInterpolator;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (i == -1) {
            final Easing interpolator = Easing.getInterpolator(transition.mDefaultInterpolatorString);
            return new Interpolator(this) {
                public float getInterpolation(float f2) {
                    return (float) interpolator.get((double) f2);
                }
            };
        } else if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i == 1) {
                return new AccelerateInterpolator();
            }
            if (i == 2) {
                return new DecelerateInterpolator();
            }
            if (i == 4) {
                return new BounceInterpolator();
            }
            if (i == 5) {
                return new OvershootInterpolator();
            }
            if (i != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator<KeyFrames> it = transition2.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    it.next().addFrames(motionController);
                }
            }
            return;
        }
        Iterator<KeyFrames> it2 = transition.mKeyFramesList.iterator();
        while (it2.hasNext()) {
            it2.next().addFrames(motionController);
        }
    }

    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            TouchResponse touchResponse = transition.mTouchResponse;
            if (touchResponse != null) {
                return touchResponse.mMaxAcceleration;
            }
        }
        return 0.0f;
    }

    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int parseConstraintSet(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.mForceId = r1
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x0010:
            if (r4 >= r2) goto L_0x00a1
            java.lang.String r7 = r15.getAttributeName(r4)
            java.lang.String r8 = r15.getAttributeValue(r4)
            boolean r9 = r13.DEBUG_DESKTOP
            if (r9 == 0) goto L_0x0034
            java.io.PrintStream r9 = java.lang.System.out
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "id string = "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            r9.println(r10)
        L_0x0034:
            int r9 = r7.hashCode()
            r10 = -1496482599(0xffffffffa6cd7cd9, float:-1.4258573E-15)
            r11 = 2
            r12 = 1
            if (r9 == r10) goto L_0x005d
            r10 = -1153153640(0xffffffffbb444598, float:-0.0029948708)
            if (r9 == r10) goto L_0x0053
            r10 = 3355(0xd1b, float:4.701E-42)
            if (r9 == r10) goto L_0x0049
            goto L_0x0067
        L_0x0049:
            java.lang.String r9 = "id"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0067
            r7 = 0
            goto L_0x0068
        L_0x0053:
            java.lang.String r9 = "constraintRotate"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0067
            r7 = 2
            goto L_0x0068
        L_0x005d:
            java.lang.String r9 = "deriveConstraintsFrom"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0067
            r7 = 1
            goto L_0x0068
        L_0x0067:
            r7 = -1
        L_0x0068:
            if (r7 == 0) goto L_0x007b
            if (r7 == r12) goto L_0x0076
            if (r7 == r11) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            int r7 = java.lang.Integer.parseInt(r8)
            r0.mRotate = r7
            goto L_0x009d
        L_0x0076:
            int r6 = r13.getId(r14, r8)
            goto L_0x009d
        L_0x007b:
            int r5 = r13.getId(r14, r8)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.mConstraintSetIdMap
            r9 = 47
            int r9 = r8.indexOf(r9)
            if (r9 >= 0) goto L_0x008a
            goto L_0x0090
        L_0x008a:
            int r9 = r9 + 1
            java.lang.String r8 = r8.substring(r9)
        L_0x0090:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = a.a.a.a.d.b.getName(r14, r5)
            r0.mIdString = r7
        L_0x009d:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x00a1:
            if (r5 == r3) goto L_0x00b6
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.mMotionLayout
            int r1 = r1.mDebugPath
            r0.load(r14, r15)
            if (r6 == r3) goto L_0x00b1
            android.util.SparseIntArray r14 = r13.mDeriveMap
            r14.put(r5, r6)
        L_0x00b1:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.mConstraintSetMap
            r14.put(r5, r0)
        L_0x00b6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    public final void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i2 = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i2;
                if (i2 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void readConstraintChain(int i, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
        constraintSet.derivedState = constraintSet.mIdString;
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(i2, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 == null) {
                b.getName(this.mMotionLayout.getContext(), i2);
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            for (Integer next : constraintSet2.mConstraints.keySet()) {
                int intValue = next.intValue();
                Constraint constraint = constraintSet2.mConstraints.get(next);
                if (!constraintSet.mConstraints.containsKey(Integer.valueOf(intValue))) {
                    constraintSet.mConstraints.put(Integer.valueOf(intValue), new Constraint());
                }
                Constraint constraint2 = constraintSet.mConstraints.get(Integer.valueOf(intValue));
                if (constraint2 != null) {
                    Layout layout = constraint2.layout;
                    if (!layout.mApply) {
                        layout.copyFrom(constraint.layout);
                    }
                    PropertySet propertySet = constraint2.propertySet;
                    if (!propertySet.mApply) {
                        propertySet.copyFrom(constraint.propertySet);
                    }
                    Transform transform = constraint2.transform;
                    if (!transform.mApply) {
                        transform.copyFrom(constraint.transform);
                    }
                    Motion motion = constraint2.motion;
                    if (!motion.mApply) {
                        motion.copyFrom(constraint.motion);
                    }
                    for (String next2 : constraint.mCustomConstraints.keySet()) {
                        if (!constraint2.mCustomConstraints.containsKey(next2)) {
                            constraint2.mCustomConstraints.put(next2, constraint.mCustomConstraints.get(next2));
                        }
                    }
                }
            }
        } else {
            constraintSet.derivedState = GeneratedOutlineSupport.outline62(new StringBuilder(), constraintSet.derivedState, "  layout");
            int childCount = motionLayout.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = motionLayout.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (!constraintSet.mForceId || id != -1) {
                    if (!constraintSet.mConstraints.containsKey(Integer.valueOf(id))) {
                        constraintSet.mConstraints.put(Integer.valueOf(id), new Constraint());
                    }
                    Constraint constraint3 = constraintSet.mConstraints.get(Integer.valueOf(id));
                    if (constraint3 != null) {
                        if (!constraint3.layout.mApply) {
                            constraint3.fillFrom(id, layoutParams);
                            if (childAt instanceof ConstraintHelper) {
                                constraint3.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                                if (childAt instanceof Barrier) {
                                    Barrier barrier = (Barrier) childAt;
                                    constraint3.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                                    constraint3.layout.mBarrierDirection = barrier.getType();
                                    constraint3.layout.mBarrierMargin = barrier.getMargin();
                                }
                            }
                            constraint3.layout.mApply = true;
                        }
                        PropertySet propertySet2 = constraint3.propertySet;
                        if (!propertySet2.mApply) {
                            propertySet2.visibility = childAt.getVisibility();
                            constraint3.propertySet.alpha = childAt.getAlpha();
                            constraint3.propertySet.mApply = true;
                        }
                        Transform transform2 = constraint3.transform;
                        if (!transform2.mApply) {
                            transform2.mApply = true;
                            transform2.rotation = childAt.getRotation();
                            constraint3.transform.rotationX = childAt.getRotationX();
                            constraint3.transform.rotationY = childAt.getRotationY();
                            constraint3.transform.scaleX = childAt.getScaleX();
                            constraint3.transform.scaleY = childAt.getScaleY();
                            float pivotX = childAt.getPivotX();
                            float pivotY = childAt.getPivotY();
                            if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                                Transform transform3 = constraint3.transform;
                                transform3.transformPivotX = pivotX;
                                transform3.transformPivotY = pivotY;
                            }
                            constraint3.transform.translationX = childAt.getTranslationX();
                            constraint3.transform.translationY = childAt.getTranslationY();
                            constraint3.transform.translationZ = childAt.getTranslationZ();
                            Transform transform4 = constraint3.transform;
                            if (transform4.applyElevation) {
                                transform4.elevation = childAt.getElevation();
                            }
                        }
                    }
                    i3++;
                } else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }
        }
        for (Constraint next3 : constraintSet.mConstraints.values()) {
            if (next3.mDelta != null) {
                if (next3.mTargetString != null) {
                    for (Integer intValue2 : constraintSet.mConstraints.keySet()) {
                        Constraint constraint4 = constraintSet.getConstraint(intValue2.intValue());
                        String str = constraint4.layout.mConstraintTag;
                        if (str != null && next3.mTargetString.matches(str)) {
                            next3.mDelta.applyDelta(constraint4);
                            constraint4.mCustomConstraints.putAll((HashMap) next3.mCustomConstraints.clone());
                        }
                    }
                } else {
                    next3.mDelta.applyDelta(constraintSet.getConstraint(next3.mViewId));
                }
            }
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        boolean z;
        int i = 0;
        while (i < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            int i2 = this.mDeriveMap.get(keyAt);
            int size = this.mDeriveMap.size();
            while (true) {
                if (i2 <= 0) {
                    z = false;
                    break;
                } else if (i2 == keyAt) {
                    break;
                } else {
                    int i3 = size - 1;
                    if (size < 0) {
                        break;
                    }
                    i2 = this.mDeriveMap.get(i2);
                    size = i3;
                }
            }
            z = true;
            if (!z) {
                readConstraintChain(keyAt, motionLayout);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransition(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.mStateSet
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.stateGetConstraintID(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.mStateSet
            int r2 = r2.stateGetConstraintID(r8, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r7
        L_0x0017:
            r2 = r8
        L_0x0018:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.mCurrentTransition
            if (r3 == 0) goto L_0x0025
            int r4 = r3.mConstraintSetEnd
            if (r4 != r8) goto L_0x0025
            int r3 = r3.mConstraintSetStart
            if (r3 != r7) goto L_0x0025
            return
        L_0x0025:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x002b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0053
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r2) goto L_0x003f
            int r5 = r4.mConstraintSetStart
            if (r5 == r0) goto L_0x0047
        L_0x003f:
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x002b
            int r5 = r4.mConstraintSetStart
            if (r5 != r7) goto L_0x002b
        L_0x0047:
            r6.mCurrentTransition = r4
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r4.mTouchResponse
            if (r7 == 0) goto L_0x0052
            boolean r8 = r6.mRtl
            r7.setRTL(r8)
        L_0x0052:
            return
        L_0x0053:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mAbstractTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x005b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x005b
            r7 = r4
            goto L_0x005b
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            r8.mConstraintSetStart = r0
            r8.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x007d
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.mTransitionList
            r7.add(r8)
        L_0x007d:
            r6.mCurrentTransition = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        do {
            boolean z = true;
            if (!it.hasNext()) {
                Transition transition = this.mCurrentTransition;
                if (transition == null || transition.mTouchResponse == null) {
                    z = false;
                }
                return z;
            }
        } while (it.next().mTouchResponse == null);
        return true;
    }

    public final int parseInclude(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return -1;
    }
}
