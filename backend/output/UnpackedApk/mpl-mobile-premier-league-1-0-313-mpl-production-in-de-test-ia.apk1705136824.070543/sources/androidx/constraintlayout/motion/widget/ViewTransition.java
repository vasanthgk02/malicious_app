package androidx.constraintlayout.motion.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene.Transition;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ViewTransition {
    public int mClearsTag = -1;
    public Constraint mConstraintDelta;
    public Context mContext;
    public int mDefaultInterpolator = 0;
    public int mDefaultInterpolatorID = -1;
    public String mDefaultInterpolatorString = null;
    public boolean mDisabled = false;
    public int mDuration = -1;
    public int mId;
    public int mIfTagNotSet = -1;
    public int mIfTagSet = -1;
    public KeyFrames mKeyFrames;
    public int mOnStateTransition = -1;
    public int mPathMotionArc = 0;
    public int mSetsTag = -1;
    public int mSharedValueID = -1;
    public int mSharedValueTarget = -1;
    public int mTargetId;
    public String mTargetString;
    public int mUpDuration = -1;
    public int mViewTransitionMode;

    public static class Animate {
        public boolean hold_at_100 = false;
        public KeyCache mCache = new KeyCache();
        public final int mClearsTag;
        public float mDpositionDt;
        public Interpolator mInterpolator;
        public long mLastRender;
        public MotionController mMC;
        public float mPosition;
        public final int mSetsTag;
        public long mStart;
        public Rect mTempRec = new Rect();
        public int mUpDuration;
        public ViewTransitionController mVtController;
        public boolean reverse = false;

        public Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.mVtController = viewTransitionController;
            this.mMC = motionController;
            this.mUpDuration = i2;
            long nanoTime = System.nanoTime();
            this.mStart = nanoTime;
            this.mLastRender = nanoTime;
            ViewTransitionController viewTransitionController2 = this.mVtController;
            if (viewTransitionController2.animations == null) {
                viewTransitionController2.animations = new ArrayList<>();
            }
            viewTransitionController2.animations.add(this);
            this.mInterpolator = interpolator;
            this.mSetsTag = i4;
            this.mClearsTag = i5;
            if (i3 == 3) {
                this.hold_at_100 = true;
            }
            this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
            mutate();
        }

        public void mutate() {
            if (this.reverse) {
                long nanoTime = System.nanoTime();
                this.mLastRender = nanoTime;
                float f2 = this.mPosition - (((float) (((double) (nanoTime - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt);
                this.mPosition = f2;
                if (f2 < 0.0f) {
                    this.mPosition = 0.0f;
                }
                Interpolator interpolator = this.mInterpolator;
                float interpolation = interpolator == null ? this.mPosition : interpolator.getInterpolation(this.mPosition);
                MotionController motionController = this.mMC;
                boolean interpolate = motionController.interpolate(motionController.mView, interpolation, nanoTime, this.mCache);
                if (this.mPosition <= 0.0f) {
                    int i = this.mSetsTag;
                    if (i != -1) {
                        this.mMC.mView.setTag(i, Long.valueOf(System.nanoTime()));
                    }
                    int i2 = this.mClearsTag;
                    if (i2 != -1) {
                        this.mMC.mView.setTag(i2, null);
                    }
                    this.mVtController.removeList.add(this);
                }
                if (this.mPosition > 0.0f || interpolate) {
                    this.mVtController.mMotionLayout.invalidate();
                    return;
                }
                return;
            }
            long nanoTime2 = System.nanoTime();
            this.mLastRender = nanoTime2;
            float f3 = (((float) (((double) (nanoTime2 - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt) + this.mPosition;
            this.mPosition = f3;
            if (f3 >= 1.0f) {
                this.mPosition = 1.0f;
            }
            Interpolator interpolator2 = this.mInterpolator;
            float interpolation2 = interpolator2 == null ? this.mPosition : interpolator2.getInterpolation(this.mPosition);
            MotionController motionController2 = this.mMC;
            boolean interpolate2 = motionController2.interpolate(motionController2.mView, interpolation2, nanoTime2, this.mCache);
            if (this.mPosition >= 1.0f) {
                int i3 = this.mSetsTag;
                if (i3 != -1) {
                    this.mMC.mView.setTag(i3, Long.valueOf(System.nanoTime()));
                }
                int i4 = this.mClearsTag;
                if (i4 != -1) {
                    this.mMC.mView.setTag(i4, null);
                }
                if (!this.hold_at_100) {
                    this.mVtController.removeList.add(this);
                }
            }
            if (this.mPosition < 1.0f || interpolate2) {
                this.mVtController.mMotionLayout.invalidate();
            }
        }

        public void reverse(boolean z) {
            this.reverse = z;
            if (z) {
                int i = this.mUpDuration;
                if (i != -1) {
                    this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
                }
            }
            this.mVtController.mMotionLayout.invalidate();
            this.mLastRender = System.nanoTime();
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewTransition(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.mOnStateTransition = r0
            r1 = 0
            r9.mDisabled = r1
            r9.mPathMotionArc = r1
            r9.mDuration = r0
            r9.mUpDuration = r0
            r9.mDefaultInterpolator = r1
            r2 = 0
            r9.mDefaultInterpolatorString = r2
            r9.mDefaultInterpolatorID = r0
            r9.mSetsTag = r0
            r9.mClearsTag = r0
            r9.mIfTagSet = r0
            r9.mIfTagNotSet = r0
            r9.mSharedValueTarget = r0
            r9.mSharedValueID = r0
            r9.mContext = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x0028:
            r3 = 1
            if (r2 == r3) goto L_0x00b8
            java.lang.String r4 = "ViewTransition"
            r5 = 2
            r6 = 3
            if (r2 == r5) goto L_0x0040
            if (r2 == r6) goto L_0x0035
            goto L_0x00a9
        L_0x0035:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x00a9
            return
        L_0x0040:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x0073;
                case -1239391468: goto L_0x0069;
                case 61998586: goto L_0x0061;
                case 366511058: goto L_0x0057;
                case 1791837707: goto L_0x004d;
                default: goto L_0x004c;
            }     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x004c:
            goto L_0x007d
        L_0x004d:
            java.lang.String r4 = "CustomAttribute"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = 3
            goto L_0x007e
        L_0x0057:
            java.lang.String r4 = "CustomMethod"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = 4
            goto L_0x007e
        L_0x0061:
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = 0
            goto L_0x007e
        L_0x0069:
            java.lang.String r4 = "KeyFrameSet"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = 1
            goto L_0x007e
        L_0x0073:
            java.lang.String r4 = "ConstraintOverride"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = 2
            goto L_0x007e
        L_0x007d:
            r2 = -1
        L_0x007e:
            if (r2 == 0) goto L_0x00a6
            if (r2 == r3) goto L_0x009e
            if (r2 == r5) goto L_0x0097
            if (r2 == r6) goto L_0x008f
            if (r2 == r8) goto L_0x008f
            a.a.a.a.d.b.getLoc()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x008f:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.mConstraintDelta     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x0097:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.buildDelta(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r9.mConstraintDelta = r2     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x009e:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r9.mKeyFrames = r2     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x00a6:
            r9.parseViewTransitionTags(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x00a9:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x0028
        L_0x00af:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00b8
        L_0x00b4:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void applyTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, View... viewArr) {
        Interpolator interpolator;
        Interpolator interpolator2;
        MotionLayout motionLayout2 = motionLayout;
        int i2 = i;
        ConstraintSet constraintSet2 = constraintSet;
        View[] viewArr2 = viewArr;
        if (!this.mDisabled) {
            int i3 = this.mViewTransitionMode;
            if (i3 == 2) {
                View view = viewArr2[0];
                MotionController motionController = new MotionController(view);
                MotionPaths motionPaths = motionController.mStartMotionPath;
                motionPaths.time = 0.0f;
                motionPaths.position = 0.0f;
                motionController.mNoMovement = true;
                motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                motionController.mEndMotionPath.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                motionController.mStartPoint.setState(view);
                motionController.mEndPoint.setState(view);
                this.mKeyFrames.addAllFrames(motionController);
                motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), System.nanoTime());
                int i4 = this.mDuration;
                int i5 = this.mUpDuration;
                int i6 = this.mOnStateTransition;
                Context context = motionLayout.getContext();
                int i7 = this.mDefaultInterpolator;
                if (i7 == -2) {
                    interpolator2 = AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
                } else if (i7 == -1) {
                    final Easing interpolator3 = Easing.getInterpolator(this.mDefaultInterpolatorString);
                    interpolator = new Interpolator(this) {
                        public float getInterpolation(float f2) {
                            return (float) interpolator3.get((double) f2);
                        }
                    };
                    new Animate(viewTransitionController, motionController, i4, i5, i6, interpolator, this.mSetsTag, this.mClearsTag);
                    return;
                } else if (i7 == 0) {
                    interpolator2 = new AccelerateDecelerateInterpolator();
                } else if (i7 == 1) {
                    interpolator2 = new AccelerateInterpolator();
                } else if (i7 == 2) {
                    interpolator2 = new DecelerateInterpolator();
                } else if (i7 == 4) {
                    interpolator2 = new BounceInterpolator();
                } else if (i7 == 5) {
                    interpolator2 = new OvershootInterpolator();
                } else if (i7 != 6) {
                    interpolator2 = null;
                } else {
                    interpolator2 = new AnticipateInterpolator();
                }
                interpolator = interpolator2;
                new Animate(viewTransitionController, motionController, i4, i5, i6, interpolator, this.mSetsTag, this.mClearsTag);
                return;
            }
            if (i3 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i8 : constraintSetIds) {
                    if (i8 != i2) {
                        ConstraintSet constraintSet3 = motionLayout2.getConstraintSet(i8);
                        for (View id : viewArr2) {
                            Constraint constraint = constraintSet3.getConstraint(id.getId());
                            Constraint constraint2 = this.mConstraintDelta;
                            if (constraint2 != null) {
                                Delta delta = constraint2.mDelta;
                                if (delta != null) {
                                    delta.applyDelta(constraint);
                                }
                                constraint.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet4 = new ConstraintSet();
            constraintSet4.mConstraints.clear();
            for (Integer next : constraintSet2.mConstraints.keySet()) {
                Constraint constraint3 = constraintSet2.mConstraints.get(next);
                if (constraint3 != null) {
                    constraintSet4.mConstraints.put(next, constraint3.clone());
                }
            }
            for (View id2 : viewArr2) {
                Constraint constraint4 = constraintSet4.getConstraint(id2.getId());
                Constraint constraint5 = this.mConstraintDelta;
                if (constraint5 != null) {
                    Delta delta2 = constraint5.mDelta;
                    if (delta2 != null) {
                        delta2.applyDelta(constraint4);
                    }
                    constraint4.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                }
            }
            motionLayout2.updateState(i2, constraintSet4);
            motionLayout2.updateState(R$id.view_transition, constraintSet2);
            motionLayout2.setState(R$id.view_transition, -1, -1);
            Transition transition = new Transition(-1, motionLayout2.mScene, R$id.view_transition, i2);
            for (View view2 : viewArr2) {
                int i9 = this.mDuration;
                if (i9 != -1) {
                    transition.mDuration = Math.max(i9, 8);
                }
                transition.mPathMotionArc = this.mPathMotionArc;
                int i10 = this.mDefaultInterpolator;
                String str = this.mDefaultInterpolatorString;
                int i11 = this.mDefaultInterpolatorID;
                transition.mDefaultInterpolator = i10;
                transition.mDefaultInterpolatorString = str;
                transition.mDefaultInterpolatorID = i11;
                int id3 = view2.getId();
                KeyFrames keyFrames = this.mKeyFrames;
                if (keyFrames != null) {
                    KeyFrames keyFrames2 = new KeyFrames();
                    Iterator it = keyFrames.mFramesMap.get(Integer.valueOf(-1)).iterator();
                    while (it.hasNext()) {
                        Key clone = ((Key) it.next()).clone();
                        clone.mTargetId = id3;
                        keyFrames2.addKey(clone);
                    }
                    transition.mKeyFramesList.add(keyFrames2);
                }
            }
            motionLayout2.setTransition(transition);
            $$Lambda$ViewTransition$IYm62aQ7INsUg3MT1WkIA7Uxiu0 r2 = new Runnable(viewArr2) {
                public final /* synthetic */ View[] f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ViewTransition.this.lambda$applyTransition$0$ViewTransition(this.f$1);
                }
            };
            motionLayout2.animateTo(1.0f);
            motionLayout2.mOnComplete = r2;
        }
    }

    public boolean checkTags(View view) {
        int i = this.mIfTagSet;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.mIfTagNotSet;
        boolean z2 = i2 == -1 || view.getTag(i2) == null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public /* synthetic */ void lambda$applyTransition$0$ViewTransition(View[] viewArr) {
        if (this.mSetsTag != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.mClearsTag != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.mClearsTag, null);
            }
        }
    }

    public boolean matchesView(View view) {
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !checkTags(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        if (this.mTargetString != null && (view.getLayoutParams() instanceof LayoutParams)) {
            String str = ((LayoutParams) view.getLayoutParams()).constraintTag;
            if (str == null || !str.matches(this.mTargetString)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.ViewTransition_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    this.mTargetId = resourceId;
                    if (resourceId == -1) {
                        this.mTargetString = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = obtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = obtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.mDisabled = obtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.mDuration = obtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.mUpDuration = obtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.mViewTransitionMode = obtainStyledAttributes.getInt(index, this.mViewTransitionMode);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i2 = obtainStyledAttributes.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId2;
                    if (resourceId2 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (i2 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.mSetsTag = obtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.mClearsTag = obtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = obtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = obtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = obtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = obtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ViewTransition(");
        outline73.append(b.getName(this.mContext, this.mId));
        outline73.append(")");
        return outline73.toString();
    }
}
