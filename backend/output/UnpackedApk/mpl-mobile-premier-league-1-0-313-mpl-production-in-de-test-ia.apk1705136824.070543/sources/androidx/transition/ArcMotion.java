package androidx.transition;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    public static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    public float mMaximumTangent = DEFAULT_MAX_TANGENT;
    public float mMinimumHorizontalTangent = 0.0f;
    public float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    public static float toTangent(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f11 = f4 - f2;
        float f12 = f5 - f3;
        float f13 = (f12 * f12) + (f11 * f11);
        float f14 = (f2 + f4) / 2.0f;
        float f15 = (f3 + f5) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z = f3 > f5;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z) {
                f8 = abs + f5;
                f7 = f4;
            } else {
                f8 = abs + f3;
                f7 = f2;
            }
            f6 = this.mMinimumVerticalTangent;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z) {
                f10 = f3;
                f9 = f17 + f2;
            } else {
                f9 = f4 - f17;
                f10 = f5;
            }
            f6 = this.mMinimumHorizontalTangent;
        }
        float f18 = f16 * f6 * f6;
        float f19 = f14 - f7;
        float f20 = f15 - f8;
        float f21 = (f20 * f20) + (f19 * f19);
        float f22 = this.mMaximumTangent;
        float f23 = f16 * f22 * f22;
        if (f21 >= f18) {
            f18 = f21 > f23 ? f23 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f18 / f21));
            f7 = GeneratedOutlineSupport.outline3(f7, f14, sqrt, f14);
            f8 = GeneratedOutlineSupport.outline3(f8, f15, sqrt, f15);
        }
        path.cubicTo((f2 + f7) / 2.0f, (f3 + f8) / 2.0f, (f7 + f4) / 2.0f, (f8 + f5) / 2.0f, f4, f5);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mMinimumVerticalTangent = toTangent(b.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        this.mMinimumHorizontalTangent = toTangent(b.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        this.mMaximumTangent = toTangent(b.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
