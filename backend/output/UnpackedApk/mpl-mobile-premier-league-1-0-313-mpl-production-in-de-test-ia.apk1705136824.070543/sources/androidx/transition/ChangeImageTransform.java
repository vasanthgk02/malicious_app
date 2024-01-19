package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.TransitionUtils.MatrixEvaluator;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    public static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        public Object get(Object obj) {
            ImageView imageView = (ImageView) obj;
            return null;
        }

        public void set(Object obj, Object obj2) {
            ImageView imageView = (ImageView) obj;
            Matrix matrix = (Matrix) obj2;
            if (VERSION.SDK_INT >= 29) {
                imageView.animateTransform(matrix);
            } else if (matrix == null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                    imageView.invalidate();
                }
            } else if (ImageViewUtils.sTryHiddenAnimateTransform) {
                try {
                    imageView.animateTransform(matrix);
                } catch (NoSuchMethodError unused) {
                    ImageViewUtils.sTryHiddenAnimateTransform = false;
                }
            }
        }
    };
    public static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() {
        public Object evaluate(float f2, Object obj, Object obj2) {
            Matrix matrix = (Matrix) obj;
            Matrix matrix2 = (Matrix) obj2;
            return null;
        }
    };
    public static final String[] sTransitionProperties = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.AnonymousClass3.<clinit>():void");
        }
    }

    public ChangeImageTransform() {
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = transitionValues.values;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                Drawable drawable = imageView.getDrawable();
                if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                    matrix = new Matrix(imageView.getImageMatrix());
                } else {
                    int i = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
                    if (i == 1) {
                        Drawable drawable2 = imageView.getDrawable();
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable2.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable2.getIntrinsicHeight()));
                        matrix = matrix2;
                    } else if (i != 2) {
                        matrix = new Matrix(imageView.getImageMatrix());
                    } else {
                        Drawable drawable3 = imageView.getDrawable();
                        int intrinsicWidth = drawable3.getIntrinsicWidth();
                        float width = (float) imageView.getWidth();
                        float f2 = (float) intrinsicWidth;
                        int intrinsicHeight = drawable3.getIntrinsicHeight();
                        float height = (float) imageView.getHeight();
                        float f3 = (float) intrinsicHeight;
                        float max = Math.max(width / f2, height / f3);
                        int round = Math.round((width - (f2 * max)) / 2.0f);
                        int round2 = Math.round((height - (f3 * max)) / 2.0f);
                        Matrix matrix3 = new Matrix();
                        matrix3.postScale(max, max);
                        matrix3.postTranslate((float) round, (float) round2);
                        matrix = matrix3;
                    }
                }
                map.put("android:changeImageTransform:matrix", matrix);
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (!(transitionValues == null || transitionValues2 == null)) {
            Rect rect = (Rect) transitionValues.values.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("android:changeImageTransform:bounds");
            if (!(rect == null || rect2 == null)) {
                Matrix matrix = (Matrix) transitionValues.values.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) transitionValues2.values.get("android:changeImageTransform:matrix");
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) transitionValues2.view;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    Property<ImageView, Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
                    TypeEvaluator<Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
                    Matrix matrix3 = MatrixUtils.IDENTITY_MATRIX;
                    objectAnimator = ObjectAnimator.ofObject(imageView, property, typeEvaluator, new Matrix[]{matrix3, matrix3});
                } else {
                    if (matrix == null) {
                        matrix = MatrixUtils.IDENTITY_MATRIX;
                    }
                    if (matrix2 == null) {
                        matrix2 = MatrixUtils.IDENTITY_MATRIX;
                    }
                    ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix);
                    objectAnimator = ObjectAnimator.ofObject(imageView, ANIMATED_TRANSFORM_PROPERTY, new MatrixEvaluator(), new Matrix[]{matrix, matrix2});
                }
            }
        }
        return objectAnimator;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
