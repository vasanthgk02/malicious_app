package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {
    public static float DEFAULT_ANGLE;
    public static int DEFAULT_RADIUS;
    public float[] mAngles;
    public ConstraintLayout mContainer;
    public int mCountAngle;
    public int mCountRadius;
    public int[] mRadius;
    public String mReferenceAngles;
    public Float mReferenceDefaultAngle;
    public Integer mReferenceDefaultRadius;
    public String mReferenceRadius;
    public int mViewCenter;

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i = 0;
            this.mCountAngle = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    addAngle(str.substring(i).trim());
                    return;
                } else {
                    addAngle(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i = 0;
            this.mCountRadius = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    addRadius(str.substring(i).trim());
                    return;
                } else {
                    addRadius(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    public final void addAngle(String str) {
        if (str != null && str.length() != 0 && this.myContext != null) {
            float[] fArr = this.mAngles;
            if (fArr != null) {
                if (this.mCountAngle + 1 > fArr.length) {
                    this.mAngles = Arrays.copyOf(fArr, fArr.length + 1);
                }
                this.mAngles[this.mCountAngle] = (float) Integer.parseInt(str);
                this.mCountAngle++;
            }
        }
    }

    public final void addRadius(String str) {
        if (str != null && str.length() != 0 && this.myContext != null) {
            int[] iArr = this.mRadius;
            if (iArr != null) {
                if (this.mCountRadius + 1 > iArr.length) {
                    this.mRadius = Arrays.copyOf(iArr, iArr.length + 1);
                }
                this.mRadius[this.mCountRadius] = (int) (((float) Integer.parseInt(str)) * this.myContext.getResources().getDisplayMetrics().density);
                this.mCountRadius++;
            }
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.mViewCenter = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceAngles = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceRadius = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, DEFAULT_ANGLE));
                    this.mReferenceDefaultAngle = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, DEFAULT_RADIUS));
                    this.mReferenceDefaultRadius = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceAngles;
        if (str != null) {
            this.mAngles = new float[1];
            setAngles(str);
        }
        String str2 = this.mReferenceRadius;
        if (str2 != null) {
            this.mRadius = new int[1];
            setRadius(str2);
        }
        Float f2 = this.mReferenceDefaultAngle;
        if (f2 != null) {
            setDefaultAngle(f2.floatValue());
        }
        Integer num = this.mReferenceDefaultRadius;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        this.mContainer = (ConstraintLayout) getParent();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = this.mContainer.getViewById(this.mIds[i]);
            if (viewById != null) {
                int i2 = DEFAULT_RADIUS;
                float f3 = DEFAULT_ANGLE;
                int[] iArr = this.mRadius;
                if (iArr == null || i >= iArr.length) {
                    Integer num2 = this.mReferenceDefaultRadius;
                    if (num2 == null || num2.intValue() == -1) {
                        String str3 = this.mMap.get(Integer.valueOf(viewById.getId()));
                    } else {
                        this.mCountRadius++;
                        if (this.mRadius == null) {
                            this.mRadius = new int[1];
                        }
                        int[] radius = getRadius();
                        this.mRadius = radius;
                        radius[this.mCountRadius - 1] = i2;
                    }
                } else {
                    i2 = iArr[i];
                }
                float[] fArr = this.mAngles;
                if (fArr == null || i >= fArr.length) {
                    Float f4 = this.mReferenceDefaultAngle;
                    if (f4 == null || f4.floatValue() == -1.0f) {
                        String str4 = this.mMap.get(Integer.valueOf(viewById.getId()));
                    } else {
                        this.mCountAngle++;
                        if (this.mAngles == null) {
                            this.mAngles = new float[1];
                        }
                        float[] angles = getAngles();
                        this.mAngles = angles;
                        angles[this.mCountAngle - 1] = f3;
                    }
                } else {
                    f3 = fArr[i];
                }
                LayoutParams layoutParams = (LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f3;
                layoutParams.circleConstraint = this.mViewCenter;
                layoutParams.circleRadius = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        applyLayoutFeatures();
    }

    public void setDefaultAngle(float f2) {
        DEFAULT_ANGLE = f2;
    }

    public void setDefaultRadius(int i) {
        DEFAULT_RADIUS = i;
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
