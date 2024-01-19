package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState;
import androidx.appcompat.graphics.drawable.StateListDrawable.StateListState;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

@SuppressLint({"RestrictedAPI"})
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
    public boolean mMutated;
    public AnimatedStateListState mState;
    public Transition mTransition;
    public int mTransitionFromIndex;
    public int mTransitionToIndex;

    public static class AnimatableTransition extends Transition {
        public final Animatable mA;

        public AnimatableTransition(Animatable animatable) {
            super(null);
            this.mA = animatable;
        }

        public void start() {
            this.mA.start();
        }

        public void stop() {
            this.mA.stop();
        }
    }

    public static class AnimatedStateListState extends StateListState {
        public SparseArrayCompat<Integer> mStateIds;
        public LongSparseArray<Long> mTransitions;

        public AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
                return;
            }
            this.mTransitions = new LongSparseArray<>(10);
            this.mStateIds = new SparseArrayCompat<>();
        }

        public static long generateTransitionKey(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        public int addTransition(int i, int i2, Drawable drawable, boolean z) {
            int addChild = super.addChild(drawable);
            long generateTransitionKey = generateTransitionKey(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) addChild;
            this.mTransitions.append(generateTransitionKey, Long.valueOf(j2 | j));
            if (z) {
                this.mTransitions.append(generateTransitionKey(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return addChild;
        }

        public int getKeyframeIdAt(int i) {
            if (i < 0) {
                return 0;
            }
            return ((Integer) this.mStateIds.get(i, Integer.valueOf(0))).intValue();
        }

        public int indexOfKeyframe(int[] iArr) {
            int indexOfStateSet = super.indexOfStateSet(iArr);
            if (indexOfStateSet >= 0) {
                return indexOfStateSet;
            }
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        public final AnimatedVectorDrawableCompat mAvd;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super(null);
            this.mAvd = animatedVectorDrawableCompat;
        }

        public void start() {
            this.mAvd.start();
        }

        public void stop() {
            this.mAvd.stop();
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        public final ObjectAnimator mAnim;
        public final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) frameInterpolator.mTotalDuration);
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z2;
            this.mAnim = ofInt;
        }

        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public void reverse() {
            this.mAnim.reverse();
        }

        public void start() {
            this.mAnim.start();
        }

        public void stop() {
            this.mAnim.cancel();
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        public int[] mFrameTimes;
        public int mFrames;
        public int mTotalDuration;

        public FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.mFrames = numberOfFrames;
            int[] iArr = this.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.mFrameTimes = new int[numberOfFrames];
            }
            int[] iArr2 = this.mFrameTimes;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.mTotalDuration = i;
        }

        public float getInterpolation(float f2) {
            int i = (int) ((f2 * ((float) this.mTotalDuration)) + 0.5f);
            int i2 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.mTotalDuration) : 0.0f);
        }
    }

    public static abstract class Transition {
        public Transition(AnonymousClass1 r1) {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    static {
        Class<AnimatedStateListDrawableCompat> cls = AnimatedStateListDrawableCompat.class;
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r12v7, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r12v15 */
    /* JADX WARNING: type inference failed for: r12v16 */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d3, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat createFromXmlInner(android.content.Context r17, android.content.res.Resources r18, org.xmlpull.v1.XmlPullParser r19, android.util.AttributeSet r20, android.content.res.Resources.Theme r21) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            java.lang.String r5 = r19.getName()
            java.lang.String r6 = "animated-selector"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x01ef
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r5 = new androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat
            r6 = 0
            r5.<init>(r6, r6)
            int[] r7 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat
            android.content.res.TypedArray r7 = a.a.a.a.d.b.obtainAttributes(r1, r4, r3, r7)
            int r8 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_visible
            r9 = 1
            boolean r8 = r7.getBoolean(r8, r9)
            r5.setVisible(r8, r9)
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r8 = r5.mState
            int r10 = r8.mChangingConfigurations
            int r11 = r7.getChangingConfigurations()
            r10 = r10 | r11
            r8.mChangingConfigurations = r10
            int r10 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_variablePadding
            boolean r11 = r8.mVariablePadding
            boolean r10 = r7.getBoolean(r10, r11)
            r8.mVariablePadding = r10
            int r10 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_constantSize
            boolean r11 = r8.mConstantSize
            boolean r10 = r7.getBoolean(r10, r11)
            r8.mConstantSize = r10
            int r10 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration
            int r11 = r8.mEnterFadeDuration
            int r10 = r7.getInt(r10, r11)
            r8.mEnterFadeDuration = r10
            int r10 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration
            int r11 = r8.mExitFadeDuration
            int r10 = r7.getInt(r10, r11)
            r8.mExitFadeDuration = r10
            int r10 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableCompat_android_dither
            boolean r8 = r8.mDither
            boolean r8 = r7.getBoolean(r10, r8)
            r5.setDither(r8)
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r8 = r5.mDrawableContainerState
            r8.updateDensity(r1)
            r7.recycle()
            int r7 = r19.getDepth()
            int r7 = r7 + r9
        L_0x0077:
            int r8 = r19.next()
            if (r8 == r9) goto L_0x01e7
            int r10 = r19.getDepth()
            if (r10 >= r7) goto L_0x0086
            r11 = 3
            if (r8 == r11) goto L_0x01e7
        L_0x0086:
            r11 = 2
            if (r8 == r11) goto L_0x008a
            goto L_0x0077
        L_0x008a:
            if (r10 <= r7) goto L_0x008d
            goto L_0x0077
        L_0x008d:
            java.lang.String r8 = r19.getName()
            java.lang.String r9 = "item"
            boolean r8 = r8.equals(r9)
            r10 = -1
            r11 = 0
            if (r8 == 0) goto L_0x0142
            int[] r8 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableItem
            android.content.res.TypedArray r8 = a.a.a.a.d.b.obtainAttributes(r1, r4, r3, r8)
            int r12 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableItem_android_id
            int r12 = r8.getResourceId(r12, r11)
            int r13 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableItem_android_drawable
            int r10 = r8.getResourceId(r13, r10)
            if (r10 <= 0) goto L_0x00b7
            androidx.appcompat.widget.ResourceManagerInternal r6 = androidx.appcompat.widget.ResourceManagerInternal.get()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r0, r10)
        L_0x00b7:
            r8.recycle()
            int r8 = r20.getAttributeCount()
            int[] r10 = new int[r8]
            r13 = 0
            r14 = 0
        L_0x00c2:
            if (r14 >= r8) goto L_0x00e4
            int r15 = r3.getAttributeNameResource(r14)
            if (r15 == 0) goto L_0x00e1
            r9 = 16842960(0x10100d0, float:2.369414E-38)
            if (r15 == r9) goto L_0x00e1
            r9 = 16843161(0x1010199, float:2.3694704E-38)
            if (r15 == r9) goto L_0x00e1
            int r9 = r13 + 1
            boolean r16 = r3.getAttributeBooleanValue(r14, r11)
            if (r16 == 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            int r15 = -r15
        L_0x00de:
            r10[r13] = r15
            r13 = r9
        L_0x00e1:
            int r14 = r14 + 1
            goto L_0x00c2
        L_0x00e4:
            int[] r8 = android.util.StateSet.trimStateSet(r10, r13)
            java.lang.String r9 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r6 != 0) goto L_0x011c
        L_0x00ec:
            int r6 = r19.next()
            r10 = 4
            if (r6 != r10) goto L_0x00f4
            goto L_0x00ec
        L_0x00f4:
            r10 = 2
            if (r6 != r10) goto L_0x010d
            java.lang.String r6 = r19.getName()
            java.lang.String r10 = "vector"
            boolean r6 = r6.equals(r10)
            if (r6 == 0) goto L_0x0108
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.createFromXmlInner(r18, r19, r20, r21)
            goto L_0x011c
        L_0x0108:
            android.graphics.drawable.Drawable r6 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20, r21)
            goto L_0x011c
        L_0x010d:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, r1, r9)
            r0.<init>(r1)
            throw r0
        L_0x011c:
            if (r6 == 0) goto L_0x0133
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r9 = r5.mState
            int r6 = r9.addChild(r6)
            int[][] r10 = r9.mStateSets
            r10[r6] = r8
            androidx.collection.SparseArrayCompat<java.lang.Integer> r8 = r9.mStateIds
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r8.put(r6, r9)
            goto L_0x01e3
        L_0x0133:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, r1, r9)
            r0.<init>(r1)
            throw r0
        L_0x0142:
            java.lang.String r6 = r19.getName()
            java.lang.String r8 = "transition"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x01e3
            int[] r6 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableTransition
            android.content.res.TypedArray r6 = a.a.a.a.d.b.obtainAttributes(r1, r4, r3, r6)
            int r8 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableTransition_android_fromId
            int r8 = r6.getResourceId(r8, r10)
            int r9 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableTransition_android_toId
            int r9 = r6.getResourceId(r9, r10)
            int r12 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableTransition_android_drawable
            int r12 = r6.getResourceId(r12, r10)
            if (r12 <= 0) goto L_0x0171
            androidx.appcompat.widget.ResourceManagerInternal r13 = androidx.appcompat.widget.ResourceManagerInternal.get()
            android.graphics.drawable.Drawable r12 = r13.getDrawable(r0, r12)
            goto L_0x0172
        L_0x0171:
            r12 = 0
        L_0x0172:
            int r13 = androidx.appcompat.resources.R$styleable.AnimatedStateListDrawableTransition_android_reversible
            boolean r11 = r6.getBoolean(r13, r11)
            r6.recycle()
            java.lang.String r6 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r12 != 0) goto L_0x01b5
        L_0x017f:
            int r12 = r19.next()
            r13 = 4
            if (r12 != r13) goto L_0x0187
            goto L_0x017f
        L_0x0187:
            r13 = 2
            if (r12 != r13) goto L_0x01a6
            java.lang.String r12 = r19.getName()
            java.lang.String r13 = "animated-vector"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x01a0
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r12 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
            r13 = 0
            r12.<init>(r0, r13, r13)
            r12.inflate(r1, r2, r3, r4)
            goto L_0x01b6
        L_0x01a0:
            r13 = 0
            android.graphics.drawable.Drawable r12 = android.graphics.drawable.Drawable.createFromXmlInner(r18, r19, r20, r21)
            goto L_0x01b6
        L_0x01a6:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, r1, r6)
            r0.<init>(r1)
            throw r0
        L_0x01b5:
            r13 = 0
        L_0x01b6:
            if (r12 == 0) goto L_0x01d4
            if (r8 == r10) goto L_0x01c3
            if (r9 == r10) goto L_0x01c3
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r6 = r5.mState
            r6.addTransition(r8, r9, r12, r11)
            r6 = r13
            goto L_0x01e4
        L_0x01c3:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, r1, r3)
            r0.<init>(r1)
            throw r0
        L_0x01d4:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline69(r2, r1, r6)
            r0.<init>(r1)
            throw r0
        L_0x01e3:
            r6 = 0
        L_0x01e4:
            r9 = 1
            goto L_0x0077
        L_0x01e7:
            int[] r0 = r5.getState()
            r5.onStateChange(r0)
            return r5
        L_0x01ef:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r19.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid animated-selector tag "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.createFromXmlInner(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    public DrawableContainerState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition != null) {
            transition.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    public Drawable mutate() {
        if (!this.mMutated) {
            super.mutate();
            if (this == this) {
                this.mState.mutate();
                this.mMutated = true;
            }
        }
        return this;
    }

    public boolean onStateChange(int[] iArr) {
        boolean z;
        Transition transition;
        int[] iArr2 = iArr;
        int indexOfKeyframe = this.mState.indexOfKeyframe(iArr2);
        int i = this.mCurIndex;
        boolean z2 = false;
        if (indexOfKeyframe != i) {
            Transition transition2 = this.mTransition;
            if (transition2 != null) {
                if (indexOfKeyframe != this.mTransitionToIndex) {
                    if (indexOfKeyframe != this.mTransitionFromIndex || !transition2.canReverse()) {
                        i = this.mTransitionToIndex;
                        transition2.stop();
                    } else {
                        transition2.reverse();
                        this.mTransitionToIndex = this.mTransitionFromIndex;
                        this.mTransitionFromIndex = indexOfKeyframe;
                    }
                }
                z = true;
                if (z || selectDrawable(indexOfKeyframe)) {
                    z2 = true;
                }
            }
            this.mTransition = null;
            this.mTransitionFromIndex = -1;
            this.mTransitionToIndex = -1;
            AnimatedStateListState animatedStateListState = this.mState;
            int keyframeIdAt = animatedStateListState.getKeyframeIdAt(i);
            int keyframeIdAt2 = animatedStateListState.getKeyframeIdAt(indexOfKeyframe);
            if (!(keyframeIdAt2 == 0 || keyframeIdAt == 0)) {
                int longValue = (int) ((Long) animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), Long.valueOf(-1))).longValue();
                if (longValue >= 0) {
                    boolean z3 = (((Long) animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), Long.valueOf(-1))).longValue() & 8589934592L) != 0;
                    selectDrawable(longValue);
                    Drawable drawable = this.mCurrDrawable;
                    if (drawable instanceof AnimationDrawable) {
                        transition = new AnimationDrawableTransition((AnimationDrawable) drawable, (((Long) animatedStateListState.mTransitions.get(AnimatedStateListState.generateTransitionKey(keyframeIdAt, keyframeIdAt2), Long.valueOf(-1))).longValue() & 4294967296L) != 0, z3);
                    } else if (drawable instanceof AnimatedVectorDrawableCompat) {
                        transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) drawable);
                    } else if (drawable instanceof Animatable) {
                        transition = new AnimatableTransition((Animatable) drawable);
                    }
                    transition.start();
                    this.mTransition = transition;
                    this.mTransitionFromIndex = i;
                    this.mTransitionToIndex = indexOfKeyframe;
                    z = true;
                    z2 = true;
                }
            }
            z = false;
            z2 = true;
        }
        Drawable drawable2 = this.mCurrDrawable;
        return drawable2 != null ? z2 | drawable2.setState(iArr2) : z2;
    }

    public void setConstantState(DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.mState = (AnimatedStateListState) drawableContainerState;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.mTransition != null && (visible || z2)) {
            if (z) {
                this.mTransition.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        AnimatedStateListState animatedStateListState2 = new AnimatedStateListState(animatedStateListState, this, resources);
        super.setConstantState(animatedStateListState2);
        this.mState = animatedStateListState2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: cloneConstantState  reason: collision with other method in class */
    public StateListState m0cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }
}
