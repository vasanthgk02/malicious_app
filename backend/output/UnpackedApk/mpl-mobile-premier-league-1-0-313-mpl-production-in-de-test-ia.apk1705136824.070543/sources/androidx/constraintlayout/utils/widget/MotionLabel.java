package androidx.constraintlayout.utils.widget;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R$styleable;

public class MotionLabel extends View implements FloatLayout {
    public boolean mAutoSize = false;
    public int mAutoSizeTextType = 0;
    public float mBackgroundPanX = Float.NaN;
    public float mBackgroundPanY = Float.NaN;
    public float mBaseTextSize = Float.NaN;
    public float mDeltaLeft;
    public float mFloatHeight;
    public float mFloatWidth;
    public String mFontFamily;
    public int mGravity = 8388659;
    public Layout mLayout;
    public boolean mNotBuilt = true;
    public Matrix mOutlinePositionMatrix;
    public int mPaddingBottom = 1;
    public int mPaddingLeft = 1;
    public int mPaddingRight = 1;
    public int mPaddingTop = 1;
    public TextPaint mPaint = new TextPaint();
    public Path mPath = new Path();
    public RectF mRect;
    public float mRotate = Float.NaN;
    public float mRound = Float.NaN;
    public float mRoundPercent = 0.0f;
    public int mStyleIndex;
    public Paint mTempPaint;
    public Rect mTempRect;
    public String mText = "Hello World";
    public Drawable mTextBackground;
    public Bitmap mTextBackgroundBitmap;
    public Rect mTextBounds = new Rect();
    public int mTextFillColor = 65535;
    public int mTextOutlineColor = 65535;
    public float mTextOutlineThickness = 0.0f;
    public float mTextPanX = 0.0f;
    public float mTextPanY = 0.0f;
    public BitmapShader mTextShader;
    public Matrix mTextShaderMatrix;
    public float mTextSize = 48.0f;
    public int mTextureEffect = 0;
    public float mTextureHeight = Float.NaN;
    public float mTextureWidth = Float.NaN;
    public int mTypefaceIndex;
    public boolean mUseOutline = false;
    public ViewOutlineProvider mViewOutlineProvider;
    public float mZoom = Float.NaN;
    public Paint paintCache = new Paint();
    public float paintTextSize;

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        TextPaint textPaint = this.mPaint;
        String str = this.mText;
        return ((this.mTextPanX + 1.0f) * ((((Float.isNaN(this.mFloatWidth) ? (float) getMeasuredWidth() : this.mFloatWidth) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - (textPaint.measureText(str, 0, str.length()) * f2))) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.mFloatHeight) ? (float) getMeasuredHeight() : this.mFloatHeight) - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        return (((1.0f - this.mTextPanY) * (measuredHeight - ((f3 - f4) * f2))) / 2.0f) - (f2 * f4);
    }

    public void buildShape(float f2) {
        if (this.mUseOutline || f2 != 1.0f) {
            this.mPath.reset();
            String str = this.mText;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.mTextBounds);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (f2 != 1.0f) {
                b.getLoc();
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.mPath.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.mNotBuilt = false;
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    public final void init(Context context, AttributeSet attributeSet) {
        Typeface typeface;
        Typeface typeface2;
        setUpTheme(context);
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.mTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f2;
                    setRoundPercent(f2);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            if (intrinsicWidth <= 0) {
                intrinsicWidth = getWidth();
                if (intrinsicWidth == 0) {
                    intrinsicWidth = Float.isNaN(this.mTextureWidth) ? 128 : (int) this.mTextureWidth;
                }
            }
            if (intrinsicHeight <= 0) {
                intrinsicHeight = getHeight();
                if (intrinsicHeight == 0) {
                    intrinsicHeight = Float.isNaN(this.mTextureHeight) ? 128 : (int) this.mTextureHeight;
                }
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                Bitmap bitmap = this.mTextBackgroundBitmap;
                System.nanoTime();
                int width = bitmap.getWidth() / 2;
                int height = bitmap.getHeight() / 2;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                for (int i2 = 0; i2 < 4 && width >= 32 && height >= 32; i2++) {
                    width /= 2;
                    height /= 2;
                    createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
                }
                this.mTextBackgroundBitmap = createScaledBitmap;
            }
            Bitmap bitmap2 = this.mTextBackgroundBitmap;
            TileMode tileMode = TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap2, tileMode, tileMode);
        }
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        String str = this.mFontFamily;
        int i3 = this.mTypefaceIndex;
        int i4 = this.mStyleIndex;
        if (str != null) {
            typeface = Typeface.create(str, i4);
            if (typeface != null) {
                setTypeface(typeface);
                this.mPaint.setColor(this.mTextFillColor);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                this.mPaint.setStyle(Style.FILL_AND_STROKE);
                this.mPaint.setFlags(128);
                setTextSize(this.mTextSize);
                this.mPaint.setAntiAlias(true);
            }
        } else {
            typeface = null;
        }
        if (i3 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i3 == 2) {
            typeface = Typeface.SERIF;
        } else if (i3 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f3 = 0.0f;
        if (i4 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i4);
            } else {
                typeface2 = Typeface.create(typeface, i4);
            }
            setTypeface(typeface2);
            int i5 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i4;
            TextPaint textPaint = this.mPaint;
            if ((i5 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.mPaint;
            if ((i5 & 2) != 0) {
                f3 = -0.25f;
            }
            textPaint2.setTextSkewX(f3);
        } else {
            this.mPaint.setFakeBoldText(false);
            this.mPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
        }
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    public void layout(int i, int i2, int i3, int i4) {
        float f2;
        super.layout(i, i2, i3, i4);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        if (isNaN) {
            f2 = 1.0f;
        } else {
            f2 = this.mTextSize / this.mBaseTextSize;
        }
        this.mFloatWidth = (float) (i3 - i);
        this.mFloatHeight = (float) (i4 - i2);
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            int height = (int) (((float) this.mTempRect.height()) * 1.3f);
            float f3 = (this.mFloatWidth - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f4 = (this.mFloatHeight - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            if (isNaN) {
                float f5 = (float) width;
                float f6 = (float) height;
                if (f5 * f4 > f6 * f3) {
                    this.mPaint.setTextSize((this.paintTextSize * f3) / f5);
                } else {
                    this.mPaint.setTextSize((this.paintTextSize * f4) / f6);
                }
            } else {
                float f7 = (float) width;
                float f8 = (float) height;
                f2 = f7 * f4 > f8 * f3 ? f3 / f7 : f4 / f8;
            }
        }
        if (this.mUseOutline || !isNaN) {
            float f9 = (float) i;
            float f10 = (float) i2;
            float f11 = (float) i3;
            float f12 = (float) i4;
            if (this.mTextShaderMatrix != null) {
                this.mFloatWidth = f11 - f9;
                this.mFloatHeight = f12 - f10;
                updateShaderMatrix();
            }
            buildShape(f2);
        }
    }

    public void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize;
        super.onDraw(canvas);
        if (this.mUseOutline || f2 != 1.0f) {
            if (this.mNotBuilt) {
                buildShape(f2);
            }
            if (this.mOutlinePositionMatrix == null) {
                this.mOutlinePositionMatrix = new Matrix();
            }
            if (this.mUseOutline) {
                this.paintCache.set(this.mPaint);
                this.mOutlinePositionMatrix.reset();
                float horizontalOffset = ((float) this.mPaddingLeft) + getHorizontalOffset();
                float verticalOffset = ((float) this.mPaddingTop) + getVerticalOffset();
                this.mOutlinePositionMatrix.postTranslate(horizontalOffset, verticalOffset);
                this.mOutlinePositionMatrix.preScale(f2, f2);
                this.mPath.transform(this.mOutlinePositionMatrix);
                if (this.mTextShader != null) {
                    this.mPaint.setFilterBitmap(true);
                    this.mPaint.setShader(this.mTextShader);
                } else {
                    this.mPaint.setColor(this.mTextFillColor);
                }
                this.mPaint.setStyle(Style.FILL);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.mTextShader != null) {
                    this.mPaint.setShader(null);
                }
                this.mPaint.setColor(this.mTextOutlineColor);
                this.mPaint.setStyle(Style.STROKE);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                this.mOutlinePositionMatrix.reset();
                this.mOutlinePositionMatrix.postTranslate(-horizontalOffset, -verticalOffset);
                this.mPath.transform(this.mOutlinePositionMatrix);
                this.mPaint.set(this.paintCache);
            } else {
                float horizontalOffset2 = ((float) this.mPaddingLeft) + getHorizontalOffset();
                float verticalOffset2 = ((float) this.mPaddingTop) + getVerticalOffset();
                this.mOutlinePositionMatrix.reset();
                this.mOutlinePositionMatrix.preTranslate(horizontalOffset2, verticalOffset2);
                this.mPath.transform(this.mOutlinePositionMatrix);
                this.mPaint.setColor(this.mTextFillColor);
                this.mPaint.setStyle(Style.FILL_AND_STROKE);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                this.mOutlinePositionMatrix.reset();
                this.mOutlinePositionMatrix.preTranslate(-horizontalOffset2, -verticalOffset2);
                this.mPath.transform(this.mOutlinePositionMatrix);
            }
            return;
        }
        canvas.drawText(this.mText, this.mDeltaLeft + ((float) this.mPaddingLeft) + getHorizontalOffset(), ((float) this.mPaddingTop) + getVerticalOffset(), this.mPaint);
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.mPaint;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (((float) this.mTextBounds.width()) + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.mPaint.getFontMetricsInt(null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        } else if (this.mAutoSizeTextType != 0) {
            this.mAutoSize = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i) {
        if ((i & 8388615) == 0) {
            i |= 8388611;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        int i2 = i & 8388615;
        int i3 = this.mGravity & 8388615;
        if (i != this.mGravity) {
            invalidate();
        }
        this.mGravity = i;
        int i4 = i & 112;
        if (i4 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i4 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i5 = this.mGravity & 8388615;
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 8388611) {
                    if (i5 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.mRound = f2;
            float f3 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.mRound != f2;
        this.mRound = f2;
        if (f2 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
                    }
                };
                this.mViewOutlineProvider = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f4 = this.mRound;
            path.addRoundRect(rectF, f4, f4, Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z = this.mRoundPercent != f2;
        this.mRoundPercent = f2;
        if (f2 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.mRoundPercent) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.mBaseTextSize = f2;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.mBackgroundPanX = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.mBackgroundPanY = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.mRotate = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.mZoom = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.mTextFillColor = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.mTextOutlineColor = i;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.mTextOutlineThickness = f2;
        this.mUseOutline = true;
        if (Float.isNaN(f2)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.mTextPanX = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.mTextPanY = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.mTextSize = f2;
        b.getLoc();
        float f3 = this.mBaseTextSize;
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(f3)) {
            f2 = this.mBaseTextSize;
        }
        textPaint.setTextSize(f2);
        buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.mTextureHeight = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.mTextureWidth = f2;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.mPaint.getTypeface() != typeface) {
            this.mPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public final void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i = typedValue.data;
        this.mTextFillColor = i;
        textPaint.setColor(i);
    }

    public final void updateShaderMatrix() {
        float f2 = 0.0f;
        float f3 = Float.isNaN(this.mBackgroundPanX) ? 0.0f : this.mBackgroundPanX;
        float f4 = Float.isNaN(this.mBackgroundPanY) ? 0.0f : this.mBackgroundPanY;
        float f5 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        if (!Float.isNaN(this.mRotate)) {
            f2 = this.mRotate;
        }
        this.mTextShaderMatrix.reset();
        float width = (float) this.mTextBackgroundBitmap.getWidth();
        float height = (float) this.mTextBackgroundBitmap.getHeight();
        float f6 = Float.isNaN(this.mTextureWidth) ? this.mFloatWidth : this.mTextureWidth;
        float f7 = Float.isNaN(this.mTextureHeight) ? this.mFloatHeight : this.mTextureHeight;
        float f8 = f5 * (width * f7 < height * f6 ? f6 / width : f7 / height);
        this.mTextShaderMatrix.postScale(f8, f8);
        float f9 = width * f8;
        float f10 = f6 - f9;
        float f11 = f8 * height;
        float f12 = f7 - f11;
        if (!Float.isNaN(this.mTextureHeight)) {
            f12 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f10 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f3 * f10) + f6) - f9) * 0.5f, (((f4 * f12) + f7) - f11) * 0.5f);
        this.mTextShaderMatrix.postRotate(f2, f6 / 2.0f, f7 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    public void layout(float f2, float f3, float f4, float f5) {
        int i = (int) (f2 + 0.5f);
        this.mDeltaLeft = f2 - ((float) i);
        int i2 = (int) (f4 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f5 + 0.5f);
        int i5 = (int) (0.5f + f3);
        int i6 = i4 - i5;
        float f6 = f4 - f2;
        this.mFloatWidth = f6;
        float f7 = f5 - f3;
        this.mFloatHeight = f7;
        if (this.mTextShaderMatrix != null) {
            this.mFloatWidth = f6;
            this.mFloatHeight = f7;
            updateShaderMatrix();
        }
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            this.mFloatWidth = f6;
            this.mFloatHeight = f7;
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            float height = ((float) this.mTempRect.height()) * 1.3f;
            float f8 = (f6 - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f9 = (f7 - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            float f10 = (float) width;
            if (f10 * f9 > height * f8) {
                this.mPaint.setTextSize((this.paintTextSize * f8) / f10);
            } else {
                this.mPaint.setTextSize((this.paintTextSize * f9) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
