package androidx.transition;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    public static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") {
        public Object get(Object obj) {
            PathAnimatorMatrix pathAnimatorMatrix = (PathAnimatorMatrix) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            PathAnimatorMatrix pathAnimatorMatrix = (PathAnimatorMatrix) obj;
            float[] fArr = (float[]) obj2;
            System.arraycopy(fArr, 0, pathAnimatorMatrix.mValues, 0, fArr.length);
            pathAnimatorMatrix.setAnimationMatrix();
        }
    };
    public static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    public static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") {
        public Object get(Object obj) {
            PathAnimatorMatrix pathAnimatorMatrix = (PathAnimatorMatrix) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            PathAnimatorMatrix pathAnimatorMatrix = (PathAnimatorMatrix) obj;
            PointF pointF = (PointF) obj2;
            if (pathAnimatorMatrix != null) {
                pathAnimatorMatrix.mTranslationX = pointF.x;
                pathAnimatorMatrix.mTranslationY = pointF.y;
                pathAnimatorMatrix.setAnimationMatrix();
                return;
            }
            throw null;
        }
    };
    public static final String[] sTransitionProperties = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public boolean mReparent = true;
    public Matrix mTempMatrix = new Matrix();
    public boolean mUseOverlay = true;

    public static class GhostListener extends TransitionListenerAdapter {
        public GhostView mGhostView;
        public View mView;

        public GhostListener(View view, GhostView ghostView) {
            this.mView = view;
            this.mGhostView = ghostView;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTransitionEnd(androidx.transition.Transition r8) {
            /*
                r7 = this;
                r8.removeListener(r7)
                android.view.View r8 = r7.mView
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                r2 = 0
                if (r0 != r1) goto L_0x004c
                boolean r0 = androidx.transition.GhostViewPlatform.sRemoveGhostMethodFetched
                r1 = 0
                r3 = 1
                if (r0 != 0) goto L_0x0035
                boolean r0 = androidx.transition.GhostViewPlatform.sGhostViewClassFetched     // Catch:{ NoSuchMethodException -> 0x0033 }
                if (r0 != 0) goto L_0x0020
                java.lang.String r0 = "android.view.GhostView"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x001e }
                androidx.transition.GhostViewPlatform.sGhostViewClass = r0     // Catch:{ ClassNotFoundException -> 0x001e }
            L_0x001e:
                androidx.transition.GhostViewPlatform.sGhostViewClassFetched = r3     // Catch:{ NoSuchMethodException -> 0x0033 }
            L_0x0020:
                java.lang.Class<?> r0 = androidx.transition.GhostViewPlatform.sGhostViewClass     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.String r4 = "removeGhost"
                java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.Class<android.view.View> r6 = android.view.View.class
                r5[r1] = r6     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x0033 }
                androidx.transition.GhostViewPlatform.sRemoveGhostMethod = r0     // Catch:{ NoSuchMethodException -> 0x0033 }
                r0.setAccessible(r3)     // Catch:{ NoSuchMethodException -> 0x0033 }
            L_0x0033:
                androidx.transition.GhostViewPlatform.sRemoveGhostMethodFetched = r3
            L_0x0035:
                java.lang.reflect.Method r0 = androidx.transition.GhostViewPlatform.sRemoveGhostMethod
                if (r0 == 0) goto L_0x004f
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x004f, InvocationTargetException -> 0x0041 }
                r3[r1] = r8     // Catch:{ IllegalAccessException -> 0x004f, InvocationTargetException -> 0x0041 }
                r0.invoke(r2, r3)     // Catch:{ IllegalAccessException -> 0x004f, InvocationTargetException -> 0x0041 }
                goto L_0x004f
            L_0x0041:
                r8 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.Throwable r8 = r8.getCause()
                r0.<init>(r8)
                throw r0
            L_0x004c:
                androidx.transition.GhostViewPort.removeGhost(r8)
            L_0x004f:
                android.view.View r8 = r7.mView
                int r0 = androidx.transition.R$id.transition_transform
                r8.setTag(r0, r2)
                android.view.View r8 = r7.mView
                int r0 = androidx.transition.R$id.parent_matrix
                r8.setTag(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.GhostListener.onTransitionEnd(androidx.transition.Transition):void");
        }

        public void onTransitionPause(Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        public void onTransitionResume(Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    public static class PathAnimatorMatrix {
        public final Matrix mMatrix = new Matrix();
        public float mTranslationX;
        public float mTranslationY;
        public final float[] mValues;
        public final View mView;

        public PathAnimatorMatrix(View view, float[] fArr) {
            this.mView = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.mValues = fArr2;
            this.mTranslationX = fArr2[2];
            this.mTranslationY = fArr2[5];
            setAnimationMatrix();
        }

        public final void setAnimationMatrix() {
            float[] fArr = this.mValues;
            fArr[2] = this.mTranslationX;
            fArr[5] = this.mTranslationY;
            this.mMatrix.setValues(fArr);
            ViewUtils.IMPL.setAnimationMatrix(this.mView, this.mMatrix);
        }
    }

    public static class Transforms {
        public final float mRotationX;
        public final float mRotationY;
        public final float mRotationZ;
        public final float mScaleX;
        public final float mScaleY;
        public final float mTranslationX;
        public final float mTranslationY;
        public final float mTranslationZ;

        public Transforms(View view) {
            this.mTranslationX = view.getTranslationX();
            this.mTranslationY = view.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.mRotationX = view.getRotationX();
            this.mRotationY = view.getRotationY();
            this.mRotationZ = view.getRotation();
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            if (transforms.mTranslationX == this.mTranslationX && transforms.mTranslationY == this.mTranslationY && transforms.mTranslationZ == this.mTranslationZ && transforms.mScaleX == this.mScaleX && transforms.mScaleY == this.mScaleY && transforms.mRotationX == this.mRotationX && transforms.mRotationY == this.mRotationY && transforms.mRotationZ == this.mRotationZ) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            float f2 = this.mTranslationX;
            int i = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.mTranslationY;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.mTranslationZ;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.mScaleX;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.mScaleY;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.mRotationX;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.mRotationY;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.mRotationZ;
            if (f9 != 0.0f) {
                i = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i;
        }

        public void restore(View view) {
            ChangeTransform.setTransforms(view, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    public ChangeTransform() {
    }

    public static void setIdentityTransforms(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        ViewCompat.setTranslationZ(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }

    public static void setTransforms(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ViewCompat.setTranslationZ(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            transitionValues.values.put("android:changeTransform:parent", view.getParent());
            transitionValues.values.put("android:changeTransform:transforms", new Transforms(view));
            Matrix matrix = view.getMatrix();
            transitionValues.values.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.mReparent) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                ViewUtils.IMPL.transformMatrixToGlobal(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.values.put("android:changeTransform:parentMatrix", matrix2);
                transitionValues.values.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
                transitionValues.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [androidx.transition.Transition] */
    /* JADX WARNING: type inference failed for: r2v13, types: [androidx.transition.TransitionSet] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v44 */
    /* JADX WARNING: type inference failed for: r2v45 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r1 == r2.view) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r13 == r1) goto L_0x0050;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x021a  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r23, androidx.transition.TransitionValues r24, androidx.transition.TransitionValues r25) {
        /*
            r22 = this;
            r8 = r22
            r0 = r23
            r9 = r24
            r10 = r25
            if (r9 == 0) goto L_0x0222
            if (r10 == 0) goto L_0x0222
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.String r12 = "android:changeTransform:parent"
            boolean r1 = r1.containsKey(r12)
            if (r1 == 0) goto L_0x0222
            java.util.Map<java.lang.String, java.lang.Object> r1 = r10.values
            boolean r1 = r1.containsKey(r12)
            if (r1 != 0) goto L_0x0020
            goto L_0x0222
        L_0x0020:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.Object r1 = r1.get(r12)
            r13 = r1
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            java.util.Map<java.lang.String, java.lang.Object> r1 = r10.values
            java.lang.Object r1 = r1.get(r12)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            boolean r2 = r8.mReparent
            r14 = 1
            if (r2 == 0) goto L_0x0058
            boolean r2 = r8.isValidTarget(r13)
            if (r2 == 0) goto L_0x004e
            boolean r2 = r8.isValidTarget(r1)
            if (r2 != 0) goto L_0x0043
            goto L_0x004e
        L_0x0043:
            androidx.transition.TransitionValues r2 = r8.getMatchedTransitionValues(r13, r14)
            if (r2 == 0) goto L_0x0052
            android.view.View r2 = r2.view
            if (r1 != r2) goto L_0x0052
            goto L_0x0050
        L_0x004e:
            if (r13 != r1) goto L_0x0052
        L_0x0050:
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            if (r1 != 0) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.String r2 = "android:changeTransform:intermediateMatrix"
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.lang.String r2 = "android:changeTransform:matrix"
            if (r1 == 0) goto L_0x006d
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.values
            r3.put(r2, r1)
        L_0x006d:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.String r3 = "android:changeTransform:intermediateParentMatrix"
            java.lang.Object r1 = r1.get(r3)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.lang.String r7 = "android:changeTransform:parentMatrix"
            if (r1 == 0) goto L_0x0080
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.values
            r3.put(r7, r1)
        L_0x0080:
            if (r16 == 0) goto L_0x00bb
            java.util.Map<java.lang.String, java.lang.Object> r1 = r10.values
            java.lang.Object r1 = r1.get(r7)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            android.view.View r3 = r10.view
            int r4 = androidx.transition.R$id.parent_matrix
            r3.setTag(r4, r1)
            android.graphics.Matrix r3 = r8.mTempMatrix
            r3.reset()
            r1.invert(r3)
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            if (r1 != 0) goto L_0x00ad
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r4 = r9.values
            r4.put(r2, r1)
        L_0x00ad:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r9.values
            java.lang.Object r4 = r4.get(r7)
            android.graphics.Matrix r4 = (android.graphics.Matrix) r4
            r1.postConcat(r4)
            r1.postConcat(r3)
        L_0x00bb:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.values
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Matrix r1 = (android.graphics.Matrix) r1
            java.util.Map<java.lang.String, java.lang.Object> r3 = r10.values
            java.lang.Object r2 = r3.get(r2)
            android.graphics.Matrix r2 = (android.graphics.Matrix) r2
            if (r1 != 0) goto L_0x00cf
            android.graphics.Matrix r1 = androidx.transition.MatrixUtils.IDENTITY_MATRIX
        L_0x00cf:
            if (r2 != 0) goto L_0x00d3
            android.graphics.Matrix r2 = androidx.transition.MatrixUtils.IDENTITY_MATRIX
        L_0x00d3:
            r4 = r2
            boolean r2 = r1.equals(r4)
            r6 = 2
            if (r2 == 0) goto L_0x00e3
            r17 = r13
            r20 = 2
            r13 = r7
            r7 = 0
            goto L_0x015b
        L_0x00e3:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r10.values
            java.lang.String r3 = "android:changeTransform:transforms"
            java.lang.Object r2 = r2.get(r3)
            r17 = r2
            androidx.transition.ChangeTransform$Transforms r17 = (androidx.transition.ChangeTransform.Transforms) r17
            android.view.View r5 = r10.view
            setIdentityTransforms(r5)
            r2 = 9
            float[] r3 = new float[r2]
            r1.getValues(r3)
            float[] r1 = new float[r2]
            r4.getValues(r1)
            androidx.transition.ChangeTransform$PathAnimatorMatrix r11 = new androidx.transition.ChangeTransform$PathAnimatorMatrix
            r11.<init>(r5, r3)
            android.util.Property<androidx.transition.ChangeTransform$PathAnimatorMatrix, float[]> r14 = NON_TRANSLATIONS_PROPERTY
            androidx.transition.FloatArrayEvaluator r15 = new androidx.transition.FloatArrayEvaluator
            float[] r2 = new float[r2]
            r15.<init>(r2)
            float[][] r2 = new float[r6][]
            r19 = 0
            r2[r19] = r3
            r18 = 1
            r2[r18] = r1
            android.animation.PropertyValuesHolder r2 = android.animation.PropertyValuesHolder.ofObject(r14, r15, r2)
            androidx.transition.PathMotion r14 = r8.mPathMotion
            r15 = r3[r6]
            r20 = 5
            r3 = r3[r20]
            r21 = r7
            r7 = r1[r6]
            r1 = r1[r20]
            android.graphics.Path r1 = r14.getPath(r15, r3, r7, r1)
            android.util.Property<androidx.transition.ChangeTransform$PathAnimatorMatrix, android.graphics.PointF> r3 = TRANSLATIONS_PROPERTY
            r7 = 0
            android.animation.PropertyValuesHolder r1 = android.animation.PropertyValuesHolder.ofObject(r3, r7, r1)
            android.animation.PropertyValuesHolder[] r3 = new android.animation.PropertyValuesHolder[r6]
            r7 = 0
            r3[r7] = r2
            r2 = 1
            r3[r2] = r1
            android.animation.ObjectAnimator r14 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r11, r3)
            androidx.transition.ChangeTransform$3 r15 = new androidx.transition.ChangeTransform$3
            r1 = r15
            r2 = r22
            r3 = r16
            r20 = 2
            r6 = r17
            r17 = r13
            r13 = r21
            r7 = r11
            r1.<init>(r3, r4, r5, r6, r7)
            r14.addListener(r15)
            r14.addPauseListener(r15)
            r7 = r14
        L_0x015b:
            if (r16 == 0) goto L_0x0216
            if (r7 == 0) goto L_0x0216
            boolean r1 = r8.mUseOverlay
            if (r1 == 0) goto L_0x0216
            android.view.View r1 = r10.view
            java.util.Map<java.lang.String, java.lang.Object> r2 = r10.values
            java.lang.Object r2 = r2.get(r13)
            android.graphics.Matrix r2 = (android.graphics.Matrix) r2
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>(r2)
            androidx.transition.ViewUtilsBase r2 = androidx.transition.ViewUtils.IMPL
            r2.transformMatrixToLocal(r0, r3)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r2 != r4) goto L_0x01db
            boolean r2 = androidx.transition.GhostViewPlatform.sAddGhostMethodFetched
            r4 = 3
            if (r2 != 0) goto L_0x01b2
            boolean r2 = androidx.transition.GhostViewPlatform.sGhostViewClassFetched     // Catch:{ NoSuchMethodException -> 0x01ae }
            if (r2 != 0) goto L_0x0191
            java.lang.String r2 = "android.view.GhostView"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x018e }
            androidx.transition.GhostViewPlatform.sGhostViewClass = r2     // Catch:{ ClassNotFoundException -> 0x018e }
        L_0x018e:
            r2 = 1
            androidx.transition.GhostViewPlatform.sGhostViewClassFetched = r2     // Catch:{ NoSuchMethodException -> 0x01af }
        L_0x0191:
            java.lang.Class<?> r2 = androidx.transition.GhostViewPlatform.sGhostViewClass     // Catch:{ NoSuchMethodException -> 0x01ae }
            java.lang.String r5 = "addGhost"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x01ae }
            java.lang.Class<android.view.View> r11 = android.view.View.class
            r13 = 0
            r6[r13] = r11     // Catch:{ NoSuchMethodException -> 0x01ae }
            java.lang.Class<android.view.ViewGroup> r11 = android.view.ViewGroup.class
            r13 = 1
            r6[r13] = r11     // Catch:{ NoSuchMethodException -> 0x01ae }
            java.lang.Class<android.graphics.Matrix> r11 = android.graphics.Matrix.class
            r6[r20] = r11     // Catch:{ NoSuchMethodException -> 0x01ae }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x01ae }
            androidx.transition.GhostViewPlatform.sAddGhostMethod = r2     // Catch:{ NoSuchMethodException -> 0x01ae }
            r2.setAccessible(r13)     // Catch:{ NoSuchMethodException -> 0x01ae }
        L_0x01ae:
            r2 = 1
        L_0x01af:
            androidx.transition.GhostViewPlatform.sAddGhostMethodFetched = r2
            goto L_0x01b3
        L_0x01b2:
            r2 = 1
        L_0x01b3:
            java.lang.reflect.Method r5 = androidx.transition.GhostViewPlatform.sAddGhostMethod
            if (r5 == 0) goto L_0x01d9
            androidx.transition.GhostViewPlatform r6 = new androidx.transition.GhostViewPlatform     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r11 = 0
            r4[r11] = r1     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r4[r2] = r0     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r4[r20] = r3     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r0 = 0
            java.lang.Object r2 = r5.invoke(r0, r4)     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            android.view.View r2 = (android.view.View) r2     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r6.<init>(r2)     // Catch:{ IllegalAccessException -> 0x01d9, InvocationTargetException -> 0x01ce }
            r11 = r6
            goto L_0x01df
        L_0x01ce:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Throwable r0 = r0.getCause()
            r1.<init>(r0)
            throw r1
        L_0x01d9:
            r11 = 0
            goto L_0x01df
        L_0x01db:
            androidx.transition.GhostViewPort r11 = androidx.transition.GhostViewPort.addGhost(r1, r0, r3)
        L_0x01df:
            if (r11 != 0) goto L_0x01e2
            goto L_0x0221
        L_0x01e2:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.values
            java.lang.Object r0 = r0.get(r12)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r2 = r9.view
            r11.reserveEndViewTransition(r0, r2)
            r0 = r8
        L_0x01f0:
            androidx.transition.TransitionSet r2 = r0.mParent
            if (r2 == 0) goto L_0x01f6
            r0 = r2
            goto L_0x01f0
        L_0x01f6:
            androidx.transition.ChangeTransform$GhostListener r2 = new androidx.transition.ChangeTransform$GhostListener
            r2.<init>(r1, r11)
            r0.addListener(r2)
            boolean r0 = SUPPORTS_VIEW_REMOVAL_SUPPRESSION
            if (r0 == 0) goto L_0x0221
            android.view.View r0 = r9.view
            android.view.View r2 = r10.view
            if (r0 == r2) goto L_0x020e
            r2 = 0
            androidx.transition.ViewUtilsBase r3 = androidx.transition.ViewUtils.IMPL
            r3.setTransitionAlpha(r0, r2)
        L_0x020e:
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.transition.ViewUtilsBase r2 = androidx.transition.ViewUtils.IMPL
            r2.setTransitionAlpha(r1, r0)
            goto L_0x0221
        L_0x0216:
            boolean r0 = SUPPORTS_VIEW_REMOVAL_SUPPRESSION
            if (r0 != 0) goto L_0x0221
            android.view.View r0 = r9.view
            r1 = r17
            r1.endViewTransition(r0)
        L_0x0221:
            return r7
        L_0x0222:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_TRANSFORM);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mUseOverlay = b.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = b.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
