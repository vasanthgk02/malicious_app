package de.hdodenhof.circleimageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CircleImageView extends ImageView {
    public static final Config BITMAP_CONFIG = Config.ARGB_8888;
    public static final ScaleType SCALE_TYPE = ScaleType.CENTER_CROP;
    public Bitmap mBitmap;
    public int mBitmapHeight;
    public final Paint mBitmapPaint;
    public BitmapShader mBitmapShader;
    public int mBitmapWidth;
    public int mBorderColor;
    public boolean mBorderOverlay;
    public final Paint mBorderPaint;
    public float mBorderRadius;
    public final RectF mBorderRect;
    public int mBorderWidth;
    public int mCircleBackgroundColor;
    public final Paint mCircleBackgroundPaint;
    public ColorFilter mColorFilter;
    public boolean mDisableCircularTransformation;
    public float mDrawableRadius;
    public final RectF mDrawableRect;
    public boolean mReady;
    public boolean mSetupPending;
    public final Matrix mShaderMatrix;

    public class OutlineProvider extends ViewOutlineProvider {
        public OutlineProvider(AnonymousClass1 r2) {
        }

        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.mDisableCircularTransformation) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.mBorderRect.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCircleBackgroundColor() {
        return this.mCircleBackgroundColor;
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public final void initializeBitmap() {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (this.mDisableCircularTransformation) {
            this.mBitmap = null;
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    try {
                        if (drawable instanceof ColorDrawable) {
                            bitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
                        } else {
                            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
                        }
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                        bitmap2 = bitmap;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.mBitmap = bitmap2;
        }
        setup();
    }

    public void onDraw(Canvas canvas) {
        if (this.mDisableCircularTransformation) {
            super.onDraw(canvas);
        } else if (this.mBitmap != null) {
            if (this.mCircleBackgroundColor != 0) {
                canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mCircleBackgroundPaint);
            }
            canvas.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
            if (this.mBorderWidth > 0) {
                canvas.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mDisableCircularTransformation) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z2 = false;
        if (!this.mBorderRect.isEmpty()) {
            if (Math.pow((double) (y - this.mBorderRect.centerY()), 2.0d) + Math.pow((double) (x - this.mBorderRect.centerX()), 2.0d) > Math.pow((double) this.mBorderRadius, 2.0d)) {
                z = false;
                if (z && super.onTouchEvent(motionEvent)) {
                    z2 = true;
                }
                return z2;
            }
        }
        z = true;
        z2 = true;
        return z2;
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i != this.mBorderColor) {
            this.mBorderColor = i;
            this.mBorderPaint.setColor(i);
            invalidate();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.mBorderOverlay) {
            this.mBorderOverlay = z;
            setup();
        }
    }

    public void setBorderWidth(int i) {
        if (i != this.mBorderWidth) {
            this.mBorderWidth = i;
            setup();
        }
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.mCircleBackgroundColor) {
            this.mCircleBackgroundColor = i;
            this.mCircleBackgroundPaint.setColor(i);
            invalidate();
        }
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mColorFilter) {
            this.mColorFilter = colorFilter;
            Paint paint = this.mBitmapPaint;
            if (paint != null) {
                paint.setColorFilter(colorFilter);
            }
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.mDisableCircularTransformation != z) {
            this.mDisableCircularTransformation = z;
            initializeBitmap();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        initializeBitmap();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public final void setup() {
        float f2;
        float f3;
        if (!this.mReady) {
            this.mSetupPending = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.mBitmap == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.mBitmap;
            TileMode tileMode = TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setDither(true);
            this.mBitmapPaint.setFilterBitmap(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
            this.mCircleBackgroundPaint.setStyle(Style.FILL);
            this.mCircleBackgroundPaint.setAntiAlias(true);
            this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            RectF rectF = this.mBorderRect;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int min = Math.min(width, height);
            float paddingLeft = (((float) (width - min)) / 2.0f) + ((float) getPaddingLeft());
            float paddingTop = (((float) (height - min)) / 2.0f) + ((float) getPaddingTop());
            float f4 = (float) min;
            rectF.set(new RectF(paddingLeft, paddingTop, paddingLeft + f4, f4 + paddingTop));
            this.mBorderRadius = Math.min((this.mBorderRect.height() - ((float) this.mBorderWidth)) / 2.0f, (this.mBorderRect.width() - ((float) this.mBorderWidth)) / 2.0f);
            this.mDrawableRect.set(this.mBorderRect);
            if (!this.mBorderOverlay) {
                int i = this.mBorderWidth;
                if (i > 0) {
                    float f5 = ((float) i) - 1.0f;
                    this.mDrawableRect.inset(f5, f5);
                }
            }
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            Paint paint = this.mBitmapPaint;
            if (paint != null) {
                paint.setColorFilter(this.mColorFilter);
            }
            this.mShaderMatrix.set(null);
            float f6 = 0.0f;
            if (this.mDrawableRect.height() * ((float) this.mBitmapWidth) > this.mDrawableRect.width() * ((float) this.mBitmapHeight)) {
                f3 = this.mDrawableRect.height() / ((float) this.mBitmapHeight);
                f6 = (this.mDrawableRect.width() - (((float) this.mBitmapWidth) * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                f3 = this.mDrawableRect.width() / ((float) this.mBitmapWidth);
                f2 = (this.mDrawableRect.height() - (((float) this.mBitmapHeight) * f3)) * 0.5f;
            }
            this.mShaderMatrix.setScale(f3, f3);
            Matrix matrix = this.mShaderMatrix;
            RectF rectF2 = this.mDrawableRect;
            matrix.postTranslate(((float) ((int) (f6 + 0.5f))) + rectF2.left, ((float) ((int) (f2 + 0.5f))) + rectF2.top);
            this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
            invalidate();
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleImageView, i, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleImageView_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_border_color, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R$styleable.CircleImageView_civ_border_overlay, false);
        this.mCircleBackgroundColor = obtainStyledAttributes.getColor(R$styleable.CircleImageView_civ_circle_background_color, 0);
        obtainStyledAttributes.recycle();
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        setOutlineProvider(new OutlineProvider(null));
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }
}
