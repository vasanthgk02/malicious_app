package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.TextAppearanceConfig;

public class ShapeAppearanceModel {
    public static final CornerSize PILL = new RelativeCornerSize(0.5f);
    public EdgeTreatment bottomEdge;
    public CornerTreatment bottomLeftCorner;
    public CornerSize bottomLeftCornerSize;
    public CornerTreatment bottomRightCorner;
    public CornerSize bottomRightCornerSize;
    public EdgeTreatment leftEdge;
    public EdgeTreatment rightEdge;
    public EdgeTreatment topEdge;
    public CornerTreatment topLeftCorner;
    public CornerSize topLeftCornerSize;
    public CornerTreatment topRightCorner;
    public CornerSize topRightCornerSize;

    public static final class Builder {
        public EdgeTreatment bottomEdge = new EdgeTreatment();
        public CornerTreatment bottomLeftCorner = new RoundedCornerTreatment();
        public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerTreatment bottomRightCorner = new RoundedCornerTreatment();
        public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        public EdgeTreatment leftEdge = new EdgeTreatment();
        public EdgeTreatment rightEdge = new EdgeTreatment();
        public EdgeTreatment topEdge = new EdgeTreatment();
        public CornerTreatment topLeftCorner = new RoundedCornerTreatment();
        public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerTreatment topRightCorner = new RoundedCornerTreatment();
        public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);

        public Builder() {
        }

        public static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        public Builder setAllCornerSizes(float f2) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f2);
            this.topRightCornerSize = new AbsoluteCornerSize(f2);
            this.bottomRightCornerSize = new AbsoluteCornerSize(f2);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f2);
            return this;
        }

        public Builder setBottomLeftCornerSize(float f2) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f2);
            return this;
        }

        public Builder setBottomRightCornerSize(float f2) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(f2);
            return this;
        }

        public Builder setTopLeftCornerSize(float f2) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f2);
            return this;
        }

        public Builder setTopRightCornerSize(float f2) {
            this.topRightCornerSize = new AbsoluteCornerSize(f2);
            return this;
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }
    }

    public ShapeAppearanceModel(Builder builder, AnonymousClass1 r2) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        return builder(context, attributeSet, i, i2, new AbsoluteCornerSize((float) 0));
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cornerSize;
        }
        int i2 = peekValue.type;
        if (i2 == 5) {
            return new AbsoluteCornerSize((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    public boolean isRoundRect(RectF rectF) {
        Class<EdgeTreatment> cls = EdgeTreatment.class;
        boolean z = this.leftEdge.getClass().equals(cls) && this.rightEdge.getClass().equals(cls) && this.topEdge.getClass().equals(cls) && this.bottomEdge.getClass().equals(cls);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        boolean z2 = this.topRightCornerSize.getCornerSize(rectF) == cornerSize && this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize && this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize;
        boolean z3 = (this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    public ShapeAppearanceModel withCornerSize(float f2) {
        Builder builder = new Builder(this);
        builder.setAllCornerSizes(f2);
        return builder.build();
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    public static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        if (i2 != 0) {
            Context contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            CornerSize cornerSize6 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2);
            Builder builder = new Builder();
            CornerTreatment createCornerTreatment = TextAppearanceConfig.createCornerTreatment(i4);
            builder.topLeftCorner = createCornerTreatment;
            float compatCornerTreatmentSize = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                builder.setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            builder.topLeftCornerSize = cornerSize3;
            CornerTreatment createCornerTreatment2 = TextAppearanceConfig.createCornerTreatment(i5);
            builder.topRightCorner = createCornerTreatment2;
            float compatCornerTreatmentSize2 = Builder.compatCornerTreatmentSize(createCornerTreatment2);
            if (compatCornerTreatmentSize2 != -1.0f) {
                builder.setTopRightCornerSize(compatCornerTreatmentSize2);
            }
            builder.topRightCornerSize = cornerSize4;
            CornerTreatment createCornerTreatment3 = TextAppearanceConfig.createCornerTreatment(i6);
            builder.bottomRightCorner = createCornerTreatment3;
            float compatCornerTreatmentSize3 = Builder.compatCornerTreatmentSize(createCornerTreatment3);
            if (compatCornerTreatmentSize3 != -1.0f) {
                builder.setBottomRightCornerSize(compatCornerTreatmentSize3);
            }
            builder.bottomRightCornerSize = cornerSize5;
            CornerTreatment createCornerTreatment4 = TextAppearanceConfig.createCornerTreatment(i7);
            builder.bottomLeftCorner = createCornerTreatment4;
            float compatCornerTreatmentSize4 = Builder.compatCornerTreatmentSize(createCornerTreatment4);
            if (compatCornerTreatmentSize4 != -1.0f) {
                builder.setBottomLeftCornerSize(compatCornerTreatmentSize4);
            }
            builder.bottomLeftCornerSize = cornerSize6;
            return builder;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = new RoundedCornerTreatment();
        this.topRightCorner = new RoundedCornerTreatment();
        this.bottomRightCorner = new RoundedCornerTreatment();
        this.bottomLeftCorner = new RoundedCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = new EdgeTreatment();
        this.rightEdge = new EdgeTreatment();
        this.bottomEdge = new EdgeTreatment();
        this.leftEdge = new EdgeTreatment();
    }
}
