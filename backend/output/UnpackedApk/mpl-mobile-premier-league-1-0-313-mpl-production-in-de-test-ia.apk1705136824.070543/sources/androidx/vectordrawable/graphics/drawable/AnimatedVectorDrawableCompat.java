package androidx.vectordrawable.graphics.drawable;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {
    public AnimatedVectorDrawableCompatState mAnimatedVectorState;
    public ArgbEvaluator mArgbEvaluator;
    public final Callback mCallback;
    public Context mContext;

    public static class AnimatedVectorDrawableCompatState extends ConstantState {
        public AnimatorSet mAnimatorSet;
        public ArrayList<Animator> mAnimators;
        public int mChangingConfigurations;
        public ArrayMap<Animator, String> mTargetNameMap;
        public VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.mChangingConfigurations = animatedVectorDrawableCompatState.mChangingConfigurations;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.mVectorDrawable;
                if (vectorDrawableCompat != null) {
                    ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.mVectorDrawable = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = this.mVectorDrawable;
                    vectorDrawableCompat2.mutate();
                    this.mVectorDrawable = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.mVectorDrawable.setBounds(animatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                    this.mVectorDrawable.mAllowCaching = false;
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.mAnimators;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.mTargetNameMap = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = animatedVectorDrawableCompatState.mAnimators.get(i);
                        Animator clone = animator.clone();
                        String str = (String) animatedVectorDrawableCompatState.mTargetNameMap.getOrDefault(animator, null);
                        clone.setTarget(this.mVectorDrawable.mVectorState.mVPathRenderer.mVGTargetsMap.getOrDefault(str, null));
                        this.mAnimators.add(clone);
                        this.mTargetNameMap.put(clone, str);
                    }
                    if (this.mAnimatorSet == null) {
                        this.mAnimatorSet = new AnimatorSet();
                    }
                    this.mAnimatorSet.playTogether(this.mAnimators);
                }
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public static class AnimatedVectorDrawableDelegateState extends ConstantState {
        public final ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable();
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable(resources);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
            Drawable newDrawable = this.mDelegateState.newDrawable(resources, theme);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }
    }

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    public void applyTheme(Theme theme) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.mDelegateDrawable == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ee, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f6, code lost:
        r7 = "Can't load animation resource ID #0x";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013c, code lost:
        r19.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee A[ExcHandler: all (th java.lang.Throwable), Splitter:B:33:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            r3 = r25
            android.graphics.drawable.Drawable r4 = r1.mDelegateDrawable
            if (r4 == 0) goto L_0x0012
            r5 = r23
            r4.inflate(r0, r5, r2, r3)
            return
        L_0x0012:
            r5 = r23
            int r4 = r23.getEventType()
            int r6 = r23.getDepth()
            r7 = 1
            int r6 = r6 + r7
        L_0x001e:
            if (r4 == r7) goto L_0x0155
            int r8 = r23.getDepth()
            if (r8 >= r6) goto L_0x0029
            r8 = 3
            if (r4 == r8) goto L_0x0155
        L_0x0029:
            r8 = 2
            if (r4 != r8) goto L_0x014e
            java.lang.String r4 = r23.getName()
            java.lang.String r8 = "animated-vector"
            boolean r8 = r8.equals(r4)
            r9 = 0
            r10 = 0
            if (r8 == 0) goto L_0x0063
            int[] r4 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE
            android.content.res.TypedArray r4 = a.a.a.a.d.b.obtainAttributes(r0, r3, r2, r4)
            int r8 = r4.getResourceId(r10, r10)
            if (r8 == 0) goto L_0x005e
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r8 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(r0, r8, r3)
            r8.mAllowCaching = r10
            android.graphics.drawable.Drawable$Callback r10 = r1.mCallback
            r8.setCallback(r10)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r10 = r1.mAnimatedVectorState
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r10 = r10.mVectorDrawable
            if (r10 == 0) goto L_0x005a
            r10.setCallback(r9)
        L_0x005a:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r9 = r1.mAnimatedVectorState
            r9.mVectorDrawable = r8
        L_0x005e:
            r4.recycle()
            goto L_0x014e
        L_0x0063:
            java.lang.String r8 = "target"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x014e
            int[] r4 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET
            android.content.res.TypedArray r4 = r0.obtainAttributes(r2, r4)
            java.lang.String r8 = r4.getString(r10)
            int r10 = r4.getResourceId(r7, r10)
            if (r10 == 0) goto L_0x014b
            android.content.Context r11 = r1.mContext
            if (r11 == 0) goto L_0x0140
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 24
            if (r12 < r13) goto L_0x008a
            android.animation.Animator r10 = android.animation.AnimatorInflater.loadAnimator(r11, r10)
            goto L_0x00b4
        L_0x008a:
            android.content.res.Resources r12 = r11.getResources()
            android.content.res.Resources$Theme r13 = r11.getTheme()
            java.lang.String r15 = "Can't load animation resource ID #0x"
            android.content.res.XmlResourceParser r19 = r12.getAnimation(r10)     // Catch:{ XmlPullParserException -> 0x011a, IOException -> 0x00fc }
            android.util.AttributeSet r16 = android.util.Xml.asAttributeSet(r19)     // Catch:{ XmlPullParserException -> 0x00f5, IOException -> 0x00f0, all -> 0x00ee }
            r17 = 0
            r18 = 0
            r20 = 1065353216(0x3f800000, float:1.0)
            r14 = r19
            r7 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r20
            android.animation.Animator r10 = androidx.core.widget.CompoundButtonCompat.createAnimatorFromXml(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ XmlPullParserException -> 0x00ec, IOException -> 0x00ea, all -> 0x00ee }
            r19.close()
        L_0x00b4:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r7 = r1.mAnimatedVectorState
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r7 = r7.mVectorDrawable
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r7 = r7.mVectorState
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r7 = r7.mVPathRenderer
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r7 = r7.mVGTargetsMap
            java.lang.Object r7 = r7.getOrDefault(r8, r9)
            r10.setTarget(r7)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r7 = r1.mAnimatedVectorState
            java.util.ArrayList<android.animation.Animator> r9 = r7.mAnimators
            if (r9 != 0) goto L_0x00db
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r7.mAnimators = r9
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r7 = r1.mAnimatedVectorState
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            r7.mTargetNameMap = r9
        L_0x00db:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r7 = r1.mAnimatedVectorState
            java.util.ArrayList<android.animation.Animator> r7 = r7.mAnimators
            r7.add(r10)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r7 = r1.mAnimatedVectorState
            androidx.collection.ArrayMap<android.animation.Animator, java.lang.String> r7 = r7.mTargetNameMap
            r7.put(r10, r8)
            goto L_0x014b
        L_0x00ea:
            r0 = move-exception
            goto L_0x00f2
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f7
        L_0x00ee:
            r0 = move-exception
            goto L_0x013a
        L_0x00f0:
            r0 = move-exception
            r7 = r15
        L_0x00f2:
            r9 = r19
            goto L_0x00fe
        L_0x00f5:
            r0 = move-exception
            r7 = r15
        L_0x00f7:
            r9 = r19
            goto L_0x011c
        L_0x00fa:
            r0 = move-exception
            goto L_0x0138
        L_0x00fc:
            r0 = move-exception
            r7 = r15
        L_0x00fe:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r3.<init>()     // Catch:{ all -> 0x00fa }
            r3.append(r7)     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = java.lang.Integer.toHexString(r10)     // Catch:{ all -> 0x00fa }
            r3.append(r4)     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fa }
            r2.<init>(r3)     // Catch:{ all -> 0x00fa }
            r2.initCause(r0)     // Catch:{ all -> 0x00fa }
            throw r2     // Catch:{ all -> 0x00fa }
        L_0x011a:
            r0 = move-exception
            r7 = r15
        L_0x011c:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r3.<init>()     // Catch:{ all -> 0x00fa }
            r3.append(r7)     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = java.lang.Integer.toHexString(r10)     // Catch:{ all -> 0x00fa }
            r3.append(r4)     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fa }
            r2.<init>(r3)     // Catch:{ all -> 0x00fa }
            r2.initCause(r0)     // Catch:{ all -> 0x00fa }
            throw r2     // Catch:{ all -> 0x00fa }
        L_0x0138:
            r19 = r9
        L_0x013a:
            if (r19 == 0) goto L_0x013f
            r19.close()
        L_0x013f:
            throw r0
        L_0x0140:
            r4.recycle()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Context can't be null when inflating animators"
            r0.<init>(r2)
            throw r0
        L_0x014b:
            r4.recycle()
        L_0x014e:
            int r4 = r23.next()
            r7 = 1
            goto L_0x001e
        L_0x0155:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState r0 = r1.mAnimatedVectorState
            android.animation.AnimatorSet r2 = r0.mAnimatorSet
            if (r2 != 0) goto L_0x0162
            android.animation.AnimatorSet r2 = new android.animation.AnimatorSet
            r2.<init>()
            r0.mAnimatorSet = r2
        L_0x0162:
            android.animation.AnimatorSet r2 = r0.mAnimatorSet
            java.util.ArrayList<android.animation.Animator> r0 = r0.mAnimators
            r2.playTogether(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
        Drawable drawable2 = vectorDrawableCompat.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            vectorDrawableCompat.mVectorState.mAutoMirrored = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.mVectorDrawable;
        Drawable drawable2 = vectorDrawableCompat.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        } else {
            vectorDrawableCompat.mColorFilter = colorFilter;
            vectorDrawableCompat.invalidateSelf();
        }
    }

    public void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTint(drawable, i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTintList(drawable, colorStateList);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTintMode(drawable, mode);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            this.mAnimatedVectorState.mAnimatorSet.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.mAnimatedVectorState.mAnimatorSet.end();
        }
    }

    public AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.mArgbEvaluator = null;
        this.mCallback = new Callback() {
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(null, this.mCallback, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
