package androidx.constraintlayout.widget;

import a.a.a.a.d.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static SparseIntArray mapToConstant = new SparseIntArray();
    public static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    public HashMap<Integer, Constraint> mConstraints = new HashMap<>();
    public boolean mForceId = true;
    public String mIdString;
    public int mRotate = 0;
    public HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();

    public static class Constraint {
        public final Layout layout = new Layout();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();
        public Delta mDelta;
        public String mTargetString;
        public int mViewId;
        public final Motion motion = new Motion();
        public final PropertySet propertySet = new PropertySet();
        public final Transform transform = new Transform();

        public static class Delta {
            public int mCountBoolean = 0;
            public int mCountFloat = 0;
            public int mCountInt = 0;
            public int mCountString = 0;
            public int[] mTypeBoolean = new int[4];
            public int[] mTypeFloat = new int[10];
            public int[] mTypeInt = new int[10];
            public int[] mTypeString = new int[5];
            public boolean[] mValueBoolean = new boolean[4];
            public float[] mValueFloat = new float[10];
            public int[] mValueInt = new int[10];
            public String[] mValueString = new String[5];

            public void add(int i, int i2) {
                int i3 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i3 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i4 = this.mCountInt;
                iArr3[i4] = i;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i4 + 1;
                iArr4[i4] = i2;
            }

            public void applyDelta(Constraint constraint) {
                for (int i = 0; i < this.mCountInt; i++) {
                    ConstraintSet.access$300(constraint, this.mTypeInt[i], this.mValueInt[i]);
                }
                for (int i2 = 0; i2 < this.mCountFloat; i2++) {
                    ConstraintSet.access$400(constraint, this.mTypeFloat[i2], this.mValueFloat[i2]);
                }
                for (int i3 = 0; i3 < this.mCountString; i3++) {
                    ConstraintSet.access$500(constraint, this.mTypeString[i3], this.mValueString[i3]);
                }
                for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
                    ConstraintSet.access$600(constraint, this.mTypeBoolean[i4], this.mValueBoolean[i4]);
                }
            }

            public void add(int i, float f2) {
                int i2 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i2 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i3 = this.mCountFloat;
                iArr2[i3] = i;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i3 + 1;
                fArr2[i3] = f2;
            }

            public void add(int i, String str) {
                int i2 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i2 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i3 = this.mCountString;
                iArr2[i3] = i;
                String[] strArr2 = this.mValueString;
                this.mCountString = i3 + 1;
                strArr2[i3] = str;
            }

            public void add(int i, boolean z) {
                int i2 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i2 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i3 = this.mCountBoolean;
                iArr2[i3] = i;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i3 + 1;
                zArr2[i3] = z;
            }
        }

        public void applyTo(LayoutParams layoutParams) {
            Layout layout2 = this.layout;
            layoutParams.leftToLeft = layout2.leftToLeft;
            layoutParams.leftToRight = layout2.leftToRight;
            layoutParams.rightToLeft = layout2.rightToLeft;
            layoutParams.rightToRight = layout2.rightToRight;
            layoutParams.topToTop = layout2.topToTop;
            layoutParams.topToBottom = layout2.topToBottom;
            layoutParams.bottomToTop = layout2.bottomToTop;
            layoutParams.bottomToBottom = layout2.bottomToBottom;
            layoutParams.baselineToBaseline = layout2.baselineToBaseline;
            layoutParams.baselineToTop = layout2.baselineToTop;
            layoutParams.baselineToBottom = layout2.baselineToBottom;
            layoutParams.startToEnd = layout2.startToEnd;
            layoutParams.startToStart = layout2.startToStart;
            layoutParams.endToStart = layout2.endToStart;
            layoutParams.endToEnd = layout2.endToEnd;
            layoutParams.leftMargin = layout2.leftMargin;
            layoutParams.rightMargin = layout2.rightMargin;
            layoutParams.topMargin = layout2.topMargin;
            layoutParams.bottomMargin = layout2.bottomMargin;
            layoutParams.goneStartMargin = layout2.goneStartMargin;
            layoutParams.goneEndMargin = layout2.goneEndMargin;
            layoutParams.goneTopMargin = layout2.goneTopMargin;
            layoutParams.goneBottomMargin = layout2.goneBottomMargin;
            layoutParams.horizontalBias = layout2.horizontalBias;
            layoutParams.verticalBias = layout2.verticalBias;
            layoutParams.circleConstraint = layout2.circleConstraint;
            layoutParams.circleRadius = layout2.circleRadius;
            layoutParams.circleAngle = layout2.circleAngle;
            layoutParams.dimensionRatio = layout2.dimensionRatio;
            layoutParams.editorAbsoluteX = layout2.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout2.editorAbsoluteY;
            layoutParams.verticalWeight = layout2.verticalWeight;
            layoutParams.horizontalWeight = layout2.horizontalWeight;
            layoutParams.verticalChainStyle = layout2.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout2.horizontalChainStyle;
            layoutParams.constrainedWidth = layout2.constrainedWidth;
            layoutParams.constrainedHeight = layout2.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout2.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout2.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout2.widthMax;
            layoutParams.matchConstraintMaxHeight = layout2.heightMax;
            layoutParams.matchConstraintMinWidth = layout2.widthMin;
            layoutParams.matchConstraintMinHeight = layout2.heightMin;
            layoutParams.matchConstraintPercentWidth = layout2.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout2.heightPercent;
            layoutParams.orientation = layout2.orientation;
            layoutParams.guidePercent = layout2.guidePercent;
            layoutParams.guideBegin = layout2.guideBegin;
            layoutParams.guideEnd = layout2.guideEnd;
            layoutParams.width = layout2.mWidth;
            layoutParams.height = layout2.mHeight;
            String str = layout2.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            Layout layout3 = this.layout;
            layoutParams.wrapBehaviorInParent = layout3.mWrapBehavior;
            layoutParams.setMarginStart(layout3.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        public final void fillFrom(int i, LayoutParams layoutParams) {
            this.mViewId = i;
            Layout layout2 = this.layout;
            layout2.leftToLeft = layoutParams.leftToLeft;
            layout2.leftToRight = layoutParams.leftToRight;
            layout2.rightToLeft = layoutParams.rightToLeft;
            layout2.rightToRight = layoutParams.rightToRight;
            layout2.topToTop = layoutParams.topToTop;
            layout2.topToBottom = layoutParams.topToBottom;
            layout2.bottomToTop = layoutParams.bottomToTop;
            layout2.bottomToBottom = layoutParams.bottomToBottom;
            layout2.baselineToBaseline = layoutParams.baselineToBaseline;
            layout2.baselineToTop = layoutParams.baselineToTop;
            layout2.baselineToBottom = layoutParams.baselineToBottom;
            layout2.startToEnd = layoutParams.startToEnd;
            layout2.startToStart = layoutParams.startToStart;
            layout2.endToStart = layoutParams.endToStart;
            layout2.endToEnd = layoutParams.endToEnd;
            layout2.horizontalBias = layoutParams.horizontalBias;
            layout2.verticalBias = layoutParams.verticalBias;
            layout2.dimensionRatio = layoutParams.dimensionRatio;
            layout2.circleConstraint = layoutParams.circleConstraint;
            layout2.circleRadius = layoutParams.circleRadius;
            layout2.circleAngle = layoutParams.circleAngle;
            layout2.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout2.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout2.orientation = layoutParams.orientation;
            layout2.guidePercent = layoutParams.guidePercent;
            layout2.guideBegin = layoutParams.guideBegin;
            layout2.guideEnd = layoutParams.guideEnd;
            layout2.mWidth = layoutParams.width;
            layout2.mHeight = layoutParams.height;
            layout2.leftMargin = layoutParams.leftMargin;
            layout2.rightMargin = layoutParams.rightMargin;
            layout2.topMargin = layoutParams.topMargin;
            layout2.bottomMargin = layoutParams.bottomMargin;
            layout2.baselineMargin = layoutParams.baselineMargin;
            layout2.verticalWeight = layoutParams.verticalWeight;
            layout2.horizontalWeight = layoutParams.horizontalWeight;
            layout2.verticalChainStyle = layoutParams.verticalChainStyle;
            layout2.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout2.constrainedWidth = layoutParams.constrainedWidth;
            layout2.constrainedHeight = layoutParams.constrainedHeight;
            layout2.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout2.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout2.widthMax = layoutParams.matchConstraintMaxWidth;
            layout2.heightMax = layoutParams.matchConstraintMaxHeight;
            layout2.widthMin = layoutParams.matchConstraintMinWidth;
            layout2.heightMin = layoutParams.matchConstraintMinHeight;
            layout2.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout2.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout2.mConstraintTag = layoutParams.constraintTag;
            layout2.goneTopMargin = layoutParams.goneTopMargin;
            layout2.goneBottomMargin = layoutParams.goneBottomMargin;
            layout2.goneLeftMargin = layoutParams.goneLeftMargin;
            layout2.goneRightMargin = layoutParams.goneRightMargin;
            layout2.goneStartMargin = layoutParams.goneStartMargin;
            layout2.goneEndMargin = layoutParams.goneEndMargin;
            layout2.goneBaselineMargin = layoutParams.goneBaselineMargin;
            layout2.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            layout2.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        public final void fillFromConstraints(int i, Constraints.LayoutParams layoutParams) {
            fillFrom(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform2 = this.transform;
            transform2.rotation = layoutParams.rotation;
            transform2.rotationX = layoutParams.rotationX;
            transform2.rotationY = layoutParams.rotationY;
            transform2.scaleX = layoutParams.scaleX;
            transform2.scaleY = layoutParams.scaleY;
            transform2.transformPivotX = layoutParams.transformPivotX;
            transform2.transformPivotY = layoutParams.transformPivotY;
            transform2.translationX = layoutParams.translationX;
            transform2.translationY = layoutParams.translationY;
            transform2.translationZ = layoutParams.translationZ;
            transform2.elevation = layoutParams.elevation;
            transform2.applyElevation = layoutParams.applyElevation;
        }

        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }
    }

    public static class Layout {
        public static SparseIntArray mapToConstant;
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomMargin = 0;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endMargin = 0;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBaselineMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneBottomMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneEndMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneLeftMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneRightMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneStartMargin = LinearLayoutManager.INVALID_OFFSET;
        public int goneTopMargin = LinearLayoutManager.INVALID_OFFSET;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int heightDefault = 0;
        public int heightMax = -1;
        public int heightMin = -1;
        public float heightPercent = 1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftMargin = 0;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public boolean mApply = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType = -1;
        public boolean mIsGuideline = false;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior = 0;
        public int orientation = -1;
        public int rightMargin = 0;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startMargin = 0;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topMargin = 0;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int widthDefault = 0;
        public int widthMax = -1;
        public int widthMin = -1;
        public float widthPercent = 1.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R$styleable.Layout_android_orientation, 26);
            mapToConstant.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R$styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(R$styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(R$styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(R$styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(R$styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(R$styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R$styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R$styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R$styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R$styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R$styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R$styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R$styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R$styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R$styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R$styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R$styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R$styleable.Layout_layout_wrapBehaviorInParent, 97);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R$styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R$styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R$styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R$styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr == null || layout.mReferenceIdString != null) {
                this.mReferenceIds = null;
            } else {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = mapToConstant.get(index);
                if (i2 == 80) {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i2 == 81) {
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                } else if (i2 != 97) {
                    switch (i2) {
                        case 1:
                            this.baselineToBaseline = ConstraintSet.access$100(obtainStyledAttributes, index, this.baselineToBaseline);
                            break;
                        case 2:
                            this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            break;
                        case 3:
                            this.bottomToBottom = ConstraintSet.access$100(obtainStyledAttributes, index, this.bottomToBottom);
                            break;
                        case 4:
                            this.bottomToTop = ConstraintSet.access$100(obtainStyledAttributes, index, this.bottomToTop);
                            break;
                        case 5:
                            this.dimensionRatio = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            break;
                        case 7:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            break;
                        case 8:
                            this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            break;
                        case 9:
                            this.endToEnd = ConstraintSet.access$100(obtainStyledAttributes, index, this.endToEnd);
                            break;
                        case 10:
                            this.endToStart = ConstraintSet.access$100(obtainStyledAttributes, index, this.endToStart);
                            break;
                        case 11:
                            this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            break;
                        case 12:
                            this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            break;
                        case 13:
                            this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            break;
                        case 14:
                            this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            break;
                        case 15:
                            this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            break;
                        case 16:
                            this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            break;
                        case 17:
                            this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            break;
                        case 18:
                            this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            break;
                        case 19:
                            this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                            break;
                        case 20:
                            this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                            break;
                        case 21:
                            this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            break;
                        case 22:
                            this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            break;
                        case 23:
                            this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            break;
                        case 24:
                            this.leftToLeft = ConstraintSet.access$100(obtainStyledAttributes, index, this.leftToLeft);
                            break;
                        case 25:
                            this.leftToRight = ConstraintSet.access$100(obtainStyledAttributes, index, this.leftToRight);
                            break;
                        case 26:
                            this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                            break;
                        case 27:
                            this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            break;
                        case 28:
                            this.rightToLeft = ConstraintSet.access$100(obtainStyledAttributes, index, this.rightToLeft);
                            break;
                        case 29:
                            this.rightToRight = ConstraintSet.access$100(obtainStyledAttributes, index, this.rightToRight);
                            break;
                        case 30:
                            this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            break;
                        case 31:
                            this.startToEnd = ConstraintSet.access$100(obtainStyledAttributes, index, this.startToEnd);
                            break;
                        case 32:
                            this.startToStart = ConstraintSet.access$100(obtainStyledAttributes, index, this.startToStart);
                            break;
                        case 33:
                            this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            break;
                        case 34:
                            this.topToBottom = ConstraintSet.access$100(obtainStyledAttributes, index, this.topToBottom);
                            break;
                        case 35:
                            this.topToTop = ConstraintSet.access$100(obtainStyledAttributes, index, this.topToTop);
                            break;
                        case 36:
                            this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                            break;
                        case 37:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            break;
                        case 38:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            break;
                        case 39:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            break;
                        case 40:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            break;
                        case 41:
                            ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                            break;
                        case 42:
                            ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                            break;
                        default:
                            switch (i2) {
                                case 54:
                                    this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                    break;
                                case 55:
                                    this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                    break;
                                case 56:
                                    this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    break;
                                case 57:
                                    this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    break;
                                case 58:
                                    this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    break;
                                case 59:
                                    this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    break;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.circleConstraint = ConstraintSet.access$100(obtainStyledAttributes, index, this.circleConstraint);
                                            break;
                                        case 62:
                                            this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            break;
                                        case 63:
                                            this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                            break;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    break;
                                                case 72:
                                                    this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    break;
                                                case 73:
                                                    this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    break;
                                                case 74:
                                                    this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    break;
                                                case 76:
                                                    Integer.toHexString(index);
                                                    mapToConstant.get(index);
                                                    break;
                                                case 77:
                                                    this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 91:
                                                            this.baselineToTop = ConstraintSet.access$100(obtainStyledAttributes, index, this.baselineToTop);
                                                            break;
                                                        case 92:
                                                            this.baselineToBottom = ConstraintSet.access$100(obtainStyledAttributes, index, this.baselineToBottom);
                                                            break;
                                                        case 93:
                                                            this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                                            break;
                                                        case 94:
                                                            this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                                            break;
                                                        default:
                                                            Integer.toHexString(index);
                                                            mapToConstant.get(index);
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        public static SparseIntArray mapToConstant;
        public int mAnimateCircleAngleTo = 0;
        public int mAnimateRelativeTo = -1;
        public boolean mApply = false;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public int mPolarRelativeTo = -1;
        public int mQuantizeInterpolatorID = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mTransitionEasing = null;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R$styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R$styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R$styleable.Motion_drawPath, 4);
            mapToConstant.append(R$styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R$styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R$styleable.Motion_motionStagger, 7);
            mapToConstant.append(R$styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R$styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.access$100(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 != 1) {
                            if (i2 != 3) {
                                this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.mQuantizeInterpolatorString = string;
                                if (string.indexOf("/") <= 0) {
                                    this.mQuantizeInterpolatorType = -1;
                                    break;
                                } else {
                                    this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    this.mQuantizeInterpolatorType = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public boolean mApply = false;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 0;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = i2;
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[i2];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        public static SparseIntArray mapToConstant;
        public boolean applyElevation = false;
        public float elevation = 0.0f;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public int transformPivotTarget = -1;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            mapToConstant.append(R$styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R$styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R$styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R$styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R$styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R$styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R$styleable.Transform_android_translationX, 8);
            mapToConstant.append(R$styleable.Transform_android_translationY, 9);
            mapToConstant.append(R$styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R$styleable.Transform_android_elevation, 11);
            mapToConstant.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.access$100(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R$styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R$styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R$styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R$styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R$styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R$styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R$styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R$styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R$styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R$styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R$styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R$styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R$styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R$styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R$styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R$styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R$styleable.Constraint_drawPath, 66);
        mapToConstant.append(R$styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R$styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R$styleable.Constraint_android_id, 38);
        mapToConstant.append(R$styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R$styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R$styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R$styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R$styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R$styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R$styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R$styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int access$100(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public static void access$300(Constraint constraint, int i, int i2) {
        if (i == 6) {
            constraint.layout.editorAbsoluteX = i2;
        } else if (i == 7) {
            constraint.layout.editorAbsoluteY = i2;
        } else if (i == 8) {
            constraint.layout.endMargin = i2;
        } else if (i == 27) {
            constraint.layout.orientation = i2;
        } else if (i == 28) {
            constraint.layout.rightMargin = i2;
        } else if (i == 41) {
            constraint.layout.horizontalChainStyle = i2;
        } else if (i == 42) {
            constraint.layout.verticalChainStyle = i2;
        } else if (i == 61) {
            constraint.layout.circleConstraint = i2;
        } else if (i == 62) {
            constraint.layout.circleRadius = i2;
        } else if (i == 72) {
            constraint.layout.mBarrierDirection = i2;
        } else if (i == 73) {
            constraint.layout.mBarrierMargin = i2;
        } else if (i == 88) {
            constraint.motion.mQuantizeInterpolatorType = i2;
        } else if (i == 89) {
            constraint.motion.mQuantizeInterpolatorID = i2;
        } else if (i == 2) {
            constraint.layout.bottomMargin = i2;
        } else if (i == 31) {
            constraint.layout.startMargin = i2;
        } else if (i == 34) {
            constraint.layout.topMargin = i2;
        } else if (i == 38) {
            constraint.mViewId = i2;
        } else if (i == 64) {
            constraint.motion.mAnimateRelativeTo = i2;
        } else if (i == 66) {
            constraint.motion.mDrawPath = i2;
        } else if (i == 76) {
            constraint.motion.mPathMotionArc = i2;
        } else if (i == 78) {
            constraint.propertySet.mVisibilityMode = i2;
        } else if (i == 97) {
            constraint.layout.mWrapBehavior = i2;
        } else if (i == 93) {
            constraint.layout.baselineMargin = i2;
        } else if (i != 94) {
            switch (i) {
                case 11:
                    constraint.layout.goneBottomMargin = i2;
                    return;
                case 12:
                    constraint.layout.goneEndMargin = i2;
                    return;
                case 13:
                    constraint.layout.goneLeftMargin = i2;
                    return;
                case 14:
                    constraint.layout.goneRightMargin = i2;
                    return;
                case 15:
                    constraint.layout.goneStartMargin = i2;
                    return;
                case 16:
                    constraint.layout.goneTopMargin = i2;
                    return;
                case 17:
                    constraint.layout.guideBegin = i2;
                    return;
                case 18:
                    constraint.layout.guideEnd = i2;
                    return;
                default:
                    switch (i) {
                        case 21:
                            constraint.layout.mHeight = i2;
                            return;
                        case 22:
                            constraint.propertySet.visibility = i2;
                            return;
                        case 23:
                            constraint.layout.mWidth = i2;
                            return;
                        case 24:
                            constraint.layout.leftMargin = i2;
                            return;
                        default:
                            switch (i) {
                                case 54:
                                    constraint.layout.widthDefault = i2;
                                    return;
                                case 55:
                                    constraint.layout.heightDefault = i2;
                                    return;
                                case 56:
                                    constraint.layout.widthMax = i2;
                                    return;
                                case 57:
                                    constraint.layout.heightMax = i2;
                                    return;
                                case 58:
                                    constraint.layout.widthMin = i2;
                                    return;
                                case 59:
                                    constraint.layout.heightMin = i2;
                                    return;
                                default:
                                    switch (i) {
                                        case 82:
                                            constraint.motion.mAnimateCircleAngleTo = i2;
                                            return;
                                        case 83:
                                            constraint.transform.transformPivotTarget = i2;
                                            return;
                                        case 84:
                                            constraint.motion.mQuantizeMotionSteps = i2;
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        } else {
            constraint.layout.goneBaselineMargin = i2;
        }
    }

    public static void access$400(Constraint constraint, int i, float f2) {
        if (i == 19) {
            constraint.layout.guidePercent = f2;
        } else if (i == 20) {
            constraint.layout.horizontalBias = f2;
        } else if (i == 37) {
            constraint.layout.verticalBias = f2;
        } else if (i == 60) {
            constraint.transform.rotation = f2;
        } else if (i == 63) {
            constraint.layout.circleAngle = f2;
        } else if (i == 79) {
            constraint.motion.mMotionStagger = f2;
        } else if (i == 85) {
            constraint.motion.mQuantizeMotionPhase = f2;
        } else if (i == 39) {
            constraint.layout.horizontalWeight = f2;
        } else if (i != 40) {
            switch (i) {
                case 43:
                    constraint.propertySet.alpha = f2;
                    return;
                case 44:
                    Transform transform = constraint.transform;
                    transform.elevation = f2;
                    transform.applyElevation = true;
                    return;
                case 45:
                    constraint.transform.rotationX = f2;
                    return;
                case 46:
                    constraint.transform.rotationY = f2;
                    return;
                case 47:
                    constraint.transform.scaleX = f2;
                    return;
                case 48:
                    constraint.transform.scaleY = f2;
                    return;
                case 49:
                    constraint.transform.transformPivotX = f2;
                    return;
                case 50:
                    constraint.transform.transformPivotY = f2;
                    return;
                case 51:
                    constraint.transform.translationX = f2;
                    return;
                case 52:
                    constraint.transform.translationY = f2;
                    return;
                case 53:
                    constraint.transform.translationZ = f2;
                    return;
                default:
                    switch (i) {
                        case 67:
                            constraint.motion.mPathRotate = f2;
                            return;
                        case 68:
                            constraint.propertySet.mProgress = f2;
                            return;
                        case 69:
                            constraint.layout.widthPercent = f2;
                            return;
                        case 70:
                            constraint.layout.heightPercent = f2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            constraint.layout.verticalWeight = f2;
        }
    }

    public static void access$500(Constraint constraint, int i, String str) {
        if (i == 5) {
            constraint.layout.dimensionRatio = str;
        } else if (i == 65) {
            constraint.motion.mTransitionEasing = str;
        } else if (i == 74) {
            Layout layout = constraint.layout;
            layout.mReferenceIdString = str;
            layout.mReferenceIds = null;
        } else if (i == 77) {
            constraint.layout.mConstraintTag = str;
        } else if (i == 90) {
            constraint.motion.mQuantizeInterpolatorString = str;
        }
    }

    public static void access$600(Constraint constraint, int i, boolean z) {
        if (i == 44) {
            constraint.transform.applyElevation = z;
        } else if (i == 75) {
            constraint.layout.mBarrierAllowsGoneWidgets = z;
        } else if (i == 80) {
            constraint.layout.constrainedWidth = z;
        } else if (i == 81) {
            constraint.layout.constrainedHeight = z;
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R$styleable.ConstraintOverride);
        populateOverride(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseDimensionConstraints(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r9.peekValue(r10)
            int r0 = r0.type
            r1 = 3
            r2 = 21
            r3 = 23
            r4 = 1
            r5 = -1
            r6 = 5
            r7 = 0
            if (r0 == r1) goto L_0x006b
            r1 = -2
            if (r0 == r6) goto L_0x0027
            int r9 = r9.getInt(r10, r7)
            r10 = -4
            if (r9 == r10) goto L_0x002d
            r10 = -3
            if (r9 == r10) goto L_0x0025
            if (r9 == r1) goto L_0x002b
            if (r9 == r5) goto L_0x002b
        L_0x0025:
            r1 = 0
            goto L_0x002c
        L_0x0027:
            int r9 = r9.getDimensionPixelSize(r10, r7)
        L_0x002b:
            r1 = r9
        L_0x002c:
            r4 = 0
        L_0x002d:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r9 == 0) goto L_0x003f
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            if (r11 != 0) goto L_0x003a
            r8.width = r1
            r8.constrainedWidth = r4
            goto L_0x006a
        L_0x003a:
            r8.height = r1
            r8.constrainedHeight = r4
            goto L_0x006a
        L_0x003f:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r9 == 0) goto L_0x0051
            androidx.constraintlayout.widget.ConstraintSet$Layout r8 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r8
            if (r11 != 0) goto L_0x004c
            r8.mWidth = r1
            r8.constrainedWidth = r4
            goto L_0x006a
        L_0x004c:
            r8.mHeight = r1
            r8.constrainedHeight = r4
            goto L_0x006a
        L_0x0051:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r9 == 0) goto L_0x006a
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r8 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r8
            if (r11 != 0) goto L_0x0062
            r8.add(r3, r1)
            r9 = 80
            r8.add(r9, r4)
            goto L_0x006a
        L_0x0062:
            r8.add(r2, r1)
            r9 = 81
            r8.add(r9, r4)
        L_0x006a:
            return
        L_0x006b:
            java.lang.String r9 = r9.getString(r10)
            if (r9 != 0) goto L_0x0073
            goto L_0x0173
        L_0x0073:
            r10 = 61
            int r10 = r9.indexOf(r10)
            int r0 = r9.length()
            if (r10 <= 0) goto L_0x0173
            int r0 = r0 + r5
            if (r10 >= r0) goto L_0x0173
            java.lang.String r0 = r9.substring(r7, r10)
            int r10 = r10 + r4
            java.lang.String r9 = r9.substring(r10)
            int r10 = r9.length()
            if (r10 <= 0) goto L_0x0173
            java.lang.String r10 = r0.trim()
            java.lang.String r9 = r9.trim()
            java.lang.String r0 = "ratio"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x00c8
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r10 == 0) goto L_0x00b3
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            if (r11 != 0) goto L_0x00ac
            r8.width = r7
            goto L_0x00ae
        L_0x00ac:
            r8.height = r7
        L_0x00ae:
            parseDimensionRatioString(r8, r9)
            goto L_0x0173
        L_0x00b3:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r10 == 0) goto L_0x00bd
            androidx.constraintlayout.widget.ConstraintSet$Layout r8 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r8
            r8.dimensionRatio = r9
            goto L_0x0173
        L_0x00bd:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r10 == 0) goto L_0x0173
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r8 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r8
            r8.add(r6, r9)
            goto L_0x0173
        L_0x00c8:
            java.lang.String r0 = "weight"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x0116
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0173 }
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams     // Catch:{ NumberFormatException -> 0x0173 }
            if (r10 == 0) goto L_0x00e8
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x00e2
            r8.width = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.horizontalWeight = r9     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x00e2:
            r8.height = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.verticalWeight = r9     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x00e8:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout     // Catch:{ NumberFormatException -> 0x0173 }
            if (r10 == 0) goto L_0x00fc
            androidx.constraintlayout.widget.ConstraintSet$Layout r8 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x00f6
            r8.mWidth = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.horizontalWeight = r9     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x00f6:
            r8.mHeight = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.verticalWeight = r9     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x00fc:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta     // Catch:{ NumberFormatException -> 0x0173 }
            if (r10 == 0) goto L_0x0173
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r8 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x010d
            r8.add(r3, r7)     // Catch:{ NumberFormatException -> 0x0173 }
            r10 = 39
            r8.add(r10, r9)     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x010d:
            r8.add(r2, r7)     // Catch:{ NumberFormatException -> 0x0173 }
            r10 = 40
            r8.add(r10, r9)     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x0116:
            java.lang.String r0 = "parent"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0173
            r10 = 1065353216(0x3f800000, float:1.0)
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0173 }
            float r9 = java.lang.Math.min(r10, r9)     // Catch:{ NumberFormatException -> 0x0173 }
            r10 = 0
            float r9 = java.lang.Math.max(r10, r9)     // Catch:{ NumberFormatException -> 0x0173 }
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams     // Catch:{ NumberFormatException -> 0x0173 }
            r0 = 2
            if (r10 == 0) goto L_0x0144
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x013d
            r8.width = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.matchConstraintPercentWidth = r9     // Catch:{ NumberFormatException -> 0x0173 }
            r8.matchConstraintDefaultWidth = r0     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x013d:
            r8.height = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.matchConstraintPercentHeight = r9     // Catch:{ NumberFormatException -> 0x0173 }
            r8.matchConstraintDefaultHeight = r0     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x0144:
            boolean r10 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout     // Catch:{ NumberFormatException -> 0x0173 }
            if (r10 == 0) goto L_0x015a
            androidx.constraintlayout.widget.ConstraintSet$Layout r8 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x0153
            r8.mWidth = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.widthPercent = r9     // Catch:{ NumberFormatException -> 0x0173 }
            r8.widthDefault = r0     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x0153:
            r8.mHeight = r7     // Catch:{ NumberFormatException -> 0x0173 }
            r8.heightPercent = r9     // Catch:{ NumberFormatException -> 0x0173 }
            r8.heightDefault = r0     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x015a:
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta     // Catch:{ NumberFormatException -> 0x0173 }
            if (r9 == 0) goto L_0x0173
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r8 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r8     // Catch:{ NumberFormatException -> 0x0173 }
            if (r11 != 0) goto L_0x016b
            r8.add(r3, r7)     // Catch:{ NumberFormatException -> 0x0173 }
            r9 = 54
            r8.add(r9, r0)     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0173
        L_0x016b:
            r8.add(r2, r7)     // Catch:{ NumberFormatException -> 0x0173 }
            r9 = 55
            r8.add(r9, r0)     // Catch:{ NumberFormatException -> 0x0173 }
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.parseDimensionConstraints(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void parseDimensionRatioString(LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i = 0;
            int i2 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i = substring.equalsIgnoreCase(StandardStructureTypes.H) ? 1 : -1;
                }
                i2 = i;
                i = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i);
                if (substring2.length() > 0) {
                    Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i2 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.dimensionRatio = str;
    }

    public static void populateOverride(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Delta delta = new Delta();
        constraint.mDelta = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 5:
                    delta.add(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.add(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    delta.add(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                    break;
                case 11:
                    delta.add(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.add(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    delta.add(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                    break;
                case 34:
                    delta.add(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.mViewId);
                    constraint.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    delta.add(44, true);
                    delta.add(44, typedArray.getDimension(index, constraint.transform.elevation));
                    break;
                case 45:
                    delta.add(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.add(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    delta.add(53, typedArray.getDimension(index, constraint.transform.translationZ));
                    break;
                case 54:
                    delta.add(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    delta.add(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    delta.add(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    delta.add(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    delta.add(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    delta.add(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    delta.add(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    int resourceId2 = typedArray.getResourceId(index, constraint.motion.mAnimateRelativeTo);
                    if (resourceId2 == -1) {
                        resourceId2 = typedArray.getInt(index, -1);
                    }
                    delta.add(64, resourceId2);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        delta.add(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        delta.add(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    delta.add(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    delta.add(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    delta.add(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.add(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    break;
                case 72:
                    delta.add(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.add(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.add(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.add(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.add(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.add(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.add(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    delta.add(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    delta.add(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    delta.add(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    int resourceId3 = typedArray.getResourceId(index, constraint.transform.transformPivotTarget);
                    if (resourceId3 == -1) {
                        resourceId3 = typedArray.getInt(index, -1);
                    }
                    delta.add(83, resourceId3);
                    break;
                case 84:
                    delta.add(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.add(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 != 1) {
                        if (i2 != 3) {
                            Motion motion = constraint.motion;
                            motion.mQuantizeInterpolatorType = typedArray.getInteger(index, motion.mQuantizeInterpolatorID);
                            delta.add(88, constraint.motion.mQuantizeInterpolatorType);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            delta.add(90, constraint.motion.mQuantizeInterpolatorString);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                delta.add(88, -1);
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                delta.add(88, -2);
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion2 = constraint.motion;
                        if (motion2.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            motion2.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        }
                    }
                case 87:
                    Integer.toHexString(index);
                    mapToConstant.get(index);
                    break;
                case 93:
                    delta.add(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    delta.add(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    parseDimensionConstraints(delta, typedArray, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.add(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (!MotionLayout.IS_IN_EDIT_MODE) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                            break;
                        } else {
                            constraint.mTargetString = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId4 = typedArray.getResourceId(index, constraint.mViewId);
                        constraint.mViewId = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            constraint.mTargetString = typedArray.getString(index);
                            break;
                        }
                    }
                default:
                    Integer.toHexString(index);
                    mapToConstant.get(index);
                    break;
            }
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                b.getName(childAt);
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                b.getName(childAt);
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.mConstraints.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (childAt instanceof Barrier) {
                        constraint.layout.mHelperType = 1;
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(constraint.layout.mBarrierDirection);
                        barrier.setMargin(constraint.layout.mBarrierMargin);
                        barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                        Layout layout = constraint.layout;
                        int[] iArr = layout.mReferenceIds;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = layout.mReferenceIdString;
                            if (str != null) {
                                layout.mReferenceIds = convertReferenceString(barrier, str);
                                barrier.setReferencedIds(constraint.layout.mReferenceIds);
                            }
                        }
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.validate();
                    constraint.applyTo(layoutParams);
                    if (z) {
                        ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                    }
                    childAt.setLayoutParams(layoutParams);
                    PropertySet propertySet = constraint.propertySet;
                    if (propertySet.mVisibilityMode == 0) {
                        childAt.setVisibility(propertySet.visibility);
                    }
                    childAt.setAlpha(constraint.propertySet.alpha);
                    childAt.setRotation(constraint.transform.rotation);
                    childAt.setRotationX(constraint.transform.rotationX);
                    childAt.setRotationY(constraint.transform.rotationY);
                    childAt.setScaleX(constraint.transform.scaleX);
                    childAt.setScaleY(constraint.transform.scaleY);
                    Transform transform = constraint.transform;
                    if (transform.transformPivotTarget != -1) {
                        View findViewById = ((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget);
                        if (findViewById != null) {
                            float bottom = ((float) (findViewById.getBottom() + findViewById.getTop())) / 2.0f;
                            float right = ((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f;
                            if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                childAt.setPivotX(right - ((float) childAt.getLeft()));
                                childAt.setPivotY(bottom - ((float) childAt.getTop()));
                            }
                        }
                    } else {
                        if (!Float.isNaN(transform.transformPivotX)) {
                            childAt.setPivotX(constraint.transform.transformPivotX);
                        }
                        if (!Float.isNaN(constraint.transform.transformPivotY)) {
                            childAt.setPivotY(constraint.transform.transformPivotY);
                        }
                    }
                    childAt.setTranslationX(constraint.transform.translationX);
                    childAt.setTranslationY(constraint.transform.translationY);
                    childAt.setTranslationZ(constraint.transform.translationZ);
                    Transform transform2 = constraint.transform;
                    if (transform2.applyElevation) {
                        childAt.setElevation(transform2.elevation);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        constraintSet.mConstraints.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!constraintSet.mForceId || id != -1) {
                if (!constraintSet.mConstraints.containsKey(Integer.valueOf(id))) {
                    constraintSet.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = constraintSet.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    HashMap<String, ConstraintAttribute> hashMap = constraintSet.mSavedAttributes;
                    HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
                    Class<?> cls = childAt.getClass();
                    for (String next : hashMap.keySet()) {
                        ConstraintAttribute constraintAttribute = hashMap.get(next);
                        try {
                            if (next.equals(PDLayoutAttributeObject.BACKGROUND_COLOR)) {
                                hashMap2.put(next, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } else {
                                try {
                                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + next, new Class[0]).invoke(childAt, new Object[0])));
                                } catch (NoSuchMethodException e2) {
                                    e = e2;
                                } catch (IllegalAccessException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                } catch (InvocationTargetException e4) {
                                    e = e4;
                                    e.printStackTrace();
                                }
                            }
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            e.printStackTrace();
                        } catch (IllegalAccessException e6) {
                            e = e6;
                            e.printStackTrace();
                        } catch (InvocationTargetException e7) {
                            e = e7;
                            e.printStackTrace();
                        }
                    }
                    constraint.mCustomConstraints = hashMap2;
                    constraint.fillFrom(id, layoutParams);
                    constraint.propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform2 = constraint.transform;
                    if (transform2.applyElevation) {
                        transform2.elevation = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                        constraint.layout.mReferenceIds = barrier.getReferencedIds();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                i++;
                constraintSet = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final int[] convertReferenceString(View view, String str) {
        int i;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim);
                if (designInformation != null && (designInformation instanceof Integer)) {
                    i = ((Integer) designInformation).intValue();
                }
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        if (z) {
            populateOverride(context, constraint, obtainStyledAttributes);
        } else {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (!(index == R$styleable.Constraint_android_id || R$styleable.Constraint_android_layout_marginStart == index || R$styleable.Constraint_android_layout_marginEnd == index)) {
                    constraint.motion.mApply = true;
                    constraint.layout.mApply = true;
                    constraint.propertySet.mApply = true;
                    constraint.transform.mApply = true;
                }
                switch (mapToConstant.get(index)) {
                    case 1:
                        Layout layout = constraint.layout;
                        int resourceId = obtainStyledAttributes.getResourceId(index, layout.baselineToBaseline);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout.baselineToBaseline = resourceId;
                        break;
                    case 2:
                        Layout layout2 = constraint.layout;
                        layout2.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout2.bottomMargin);
                        break;
                    case 3:
                        Layout layout3 = constraint.layout;
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, layout3.bottomToBottom);
                        if (resourceId2 == -1) {
                            resourceId2 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout3.bottomToBottom = resourceId2;
                        break;
                    case 4:
                        Layout layout4 = constraint.layout;
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, layout4.bottomToTop);
                        if (resourceId3 == -1) {
                            resourceId3 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout4.bottomToTop = resourceId3;
                        break;
                    case 5:
                        constraint.layout.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        Layout layout5 = constraint.layout;
                        layout5.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                        break;
                    case 7:
                        Layout layout6 = constraint.layout;
                        layout6.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                        break;
                    case 8:
                        Layout layout7 = constraint.layout;
                        layout7.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout7.endMargin);
                        break;
                    case 9:
                        Layout layout8 = constraint.layout;
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, layout8.endToEnd);
                        if (resourceId4 == -1) {
                            resourceId4 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout8.endToEnd = resourceId4;
                        break;
                    case 10:
                        Layout layout9 = constraint.layout;
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, layout9.endToStart);
                        if (resourceId5 == -1) {
                            resourceId5 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout9.endToStart = resourceId5;
                        break;
                    case 11:
                        Layout layout10 = constraint.layout;
                        layout10.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout10.goneBottomMargin);
                        break;
                    case 12:
                        Layout layout11 = constraint.layout;
                        layout11.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout11.goneEndMargin);
                        break;
                    case 13:
                        Layout layout12 = constraint.layout;
                        layout12.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout12.goneLeftMargin);
                        break;
                    case 14:
                        Layout layout13 = constraint.layout;
                        layout13.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout13.goneRightMargin);
                        break;
                    case 15:
                        Layout layout14 = constraint.layout;
                        layout14.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout14.goneStartMargin);
                        break;
                    case 16:
                        Layout layout15 = constraint.layout;
                        layout15.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout15.goneTopMargin);
                        break;
                    case 17:
                        Layout layout16 = constraint.layout;
                        layout16.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, layout16.guideBegin);
                        break;
                    case 18:
                        Layout layout17 = constraint.layout;
                        layout17.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, layout17.guideEnd);
                        break;
                    case 19:
                        Layout layout18 = constraint.layout;
                        layout18.guidePercent = obtainStyledAttributes.getFloat(index, layout18.guidePercent);
                        break;
                    case 20:
                        Layout layout19 = constraint.layout;
                        layout19.horizontalBias = obtainStyledAttributes.getFloat(index, layout19.horizontalBias);
                        break;
                    case 21:
                        Layout layout20 = constraint.layout;
                        layout20.mHeight = obtainStyledAttributes.getLayoutDimension(index, layout20.mHeight);
                        break;
                    case 22:
                        PropertySet propertySet = constraint.propertySet;
                        propertySet.visibility = obtainStyledAttributes.getInt(index, propertySet.visibility);
                        PropertySet propertySet2 = constraint.propertySet;
                        propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                        break;
                    case 23:
                        Layout layout21 = constraint.layout;
                        layout21.mWidth = obtainStyledAttributes.getLayoutDimension(index, layout21.mWidth);
                        break;
                    case 24:
                        Layout layout22 = constraint.layout;
                        layout22.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout22.leftMargin);
                        break;
                    case 25:
                        Layout layout23 = constraint.layout;
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, layout23.leftToLeft);
                        if (resourceId6 == -1) {
                            resourceId6 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout23.leftToLeft = resourceId6;
                        break;
                    case 26:
                        Layout layout24 = constraint.layout;
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, layout24.leftToRight);
                        if (resourceId7 == -1) {
                            resourceId7 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout24.leftToRight = resourceId7;
                        break;
                    case 27:
                        Layout layout25 = constraint.layout;
                        layout25.orientation = obtainStyledAttributes.getInt(index, layout25.orientation);
                        break;
                    case 28:
                        Layout layout26 = constraint.layout;
                        layout26.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout26.rightMargin);
                        break;
                    case 29:
                        Layout layout27 = constraint.layout;
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, layout27.rightToLeft);
                        if (resourceId8 == -1) {
                            resourceId8 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout27.rightToLeft = resourceId8;
                        break;
                    case 30:
                        Layout layout28 = constraint.layout;
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, layout28.rightToRight);
                        if (resourceId9 == -1) {
                            resourceId9 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout28.rightToRight = resourceId9;
                        break;
                    case 31:
                        Layout layout29 = constraint.layout;
                        layout29.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout29.startMargin);
                        break;
                    case 32:
                        Layout layout30 = constraint.layout;
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, layout30.startToEnd);
                        if (resourceId10 == -1) {
                            resourceId10 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout30.startToEnd = resourceId10;
                        break;
                    case 33:
                        Layout layout31 = constraint.layout;
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, layout31.startToStart);
                        if (resourceId11 == -1) {
                            resourceId11 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout31.startToStart = resourceId11;
                        break;
                    case 34:
                        Layout layout32 = constraint.layout;
                        layout32.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout32.topMargin);
                        break;
                    case 35:
                        Layout layout33 = constraint.layout;
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, layout33.topToBottom);
                        if (resourceId12 == -1) {
                            resourceId12 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout33.topToBottom = resourceId12;
                        break;
                    case 36:
                        Layout layout34 = constraint.layout;
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, layout34.topToTop);
                        if (resourceId13 == -1) {
                            resourceId13 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout34.topToTop = resourceId13;
                        break;
                    case 37:
                        Layout layout35 = constraint.layout;
                        layout35.verticalBias = obtainStyledAttributes.getFloat(index, layout35.verticalBias);
                        break;
                    case 38:
                        constraint.mViewId = obtainStyledAttributes.getResourceId(index, constraint.mViewId);
                        break;
                    case 39:
                        Layout layout36 = constraint.layout;
                        layout36.horizontalWeight = obtainStyledAttributes.getFloat(index, layout36.horizontalWeight);
                        break;
                    case 40:
                        Layout layout37 = constraint.layout;
                        layout37.verticalWeight = obtainStyledAttributes.getFloat(index, layout37.verticalWeight);
                        break;
                    case 41:
                        Layout layout38 = constraint.layout;
                        layout38.horizontalChainStyle = obtainStyledAttributes.getInt(index, layout38.horizontalChainStyle);
                        break;
                    case 42:
                        Layout layout39 = constraint.layout;
                        layout39.verticalChainStyle = obtainStyledAttributes.getInt(index, layout39.verticalChainStyle);
                        break;
                    case 43:
                        PropertySet propertySet3 = constraint.propertySet;
                        propertySet3.alpha = obtainStyledAttributes.getFloat(index, propertySet3.alpha);
                        break;
                    case 44:
                        Transform transform = constraint.transform;
                        transform.applyElevation = true;
                        transform.elevation = obtainStyledAttributes.getDimension(index, transform.elevation);
                        break;
                    case 45:
                        Transform transform2 = constraint.transform;
                        transform2.rotationX = obtainStyledAttributes.getFloat(index, transform2.rotationX);
                        break;
                    case 46:
                        Transform transform3 = constraint.transform;
                        transform3.rotationY = obtainStyledAttributes.getFloat(index, transform3.rotationY);
                        break;
                    case 47:
                        Transform transform4 = constraint.transform;
                        transform4.scaleX = obtainStyledAttributes.getFloat(index, transform4.scaleX);
                        break;
                    case 48:
                        Transform transform5 = constraint.transform;
                        transform5.scaleY = obtainStyledAttributes.getFloat(index, transform5.scaleY);
                        break;
                    case 49:
                        Transform transform6 = constraint.transform;
                        transform6.transformPivotX = obtainStyledAttributes.getDimension(index, transform6.transformPivotX);
                        break;
                    case 50:
                        Transform transform7 = constraint.transform;
                        transform7.transformPivotY = obtainStyledAttributes.getDimension(index, transform7.transformPivotY);
                        break;
                    case 51:
                        Transform transform8 = constraint.transform;
                        transform8.translationX = obtainStyledAttributes.getDimension(index, transform8.translationX);
                        break;
                    case 52:
                        Transform transform9 = constraint.transform;
                        transform9.translationY = obtainStyledAttributes.getDimension(index, transform9.translationY);
                        break;
                    case 53:
                        Transform transform10 = constraint.transform;
                        transform10.translationZ = obtainStyledAttributes.getDimension(index, transform10.translationZ);
                        break;
                    case 54:
                        Layout layout40 = constraint.layout;
                        layout40.widthDefault = obtainStyledAttributes.getInt(index, layout40.widthDefault);
                        break;
                    case 55:
                        Layout layout41 = constraint.layout;
                        layout41.heightDefault = obtainStyledAttributes.getInt(index, layout41.heightDefault);
                        break;
                    case 56:
                        Layout layout42 = constraint.layout;
                        layout42.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, layout42.widthMax);
                        break;
                    case 57:
                        Layout layout43 = constraint.layout;
                        layout43.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, layout43.heightMax);
                        break;
                    case 58:
                        Layout layout44 = constraint.layout;
                        layout44.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, layout44.widthMin);
                        break;
                    case 59:
                        Layout layout45 = constraint.layout;
                        layout45.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, layout45.heightMin);
                        break;
                    case 60:
                        Transform transform11 = constraint.transform;
                        transform11.rotation = obtainStyledAttributes.getFloat(index, transform11.rotation);
                        break;
                    case 61:
                        Layout layout46 = constraint.layout;
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, layout46.circleConstraint);
                        if (resourceId14 == -1) {
                            resourceId14 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout46.circleConstraint = resourceId14;
                        break;
                    case 62:
                        Layout layout47 = constraint.layout;
                        layout47.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, layout47.circleRadius);
                        break;
                    case 63:
                        Layout layout48 = constraint.layout;
                        layout48.circleAngle = obtainStyledAttributes.getFloat(index, layout48.circleAngle);
                        break;
                    case 64:
                        Motion motion = constraint.motion;
                        int resourceId15 = obtainStyledAttributes.getResourceId(index, motion.mAnimateRelativeTo);
                        if (resourceId15 == -1) {
                            resourceId15 = obtainStyledAttributes.getInt(index, -1);
                        }
                        motion.mAnimateRelativeTo = resourceId15;
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            constraint.motion.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            constraint.motion.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 66:
                        constraint.motion.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 67:
                        Motion motion2 = constraint.motion;
                        motion2.mPathRotate = obtainStyledAttributes.getFloat(index, motion2.mPathRotate);
                        break;
                    case 68:
                        PropertySet propertySet4 = constraint.propertySet;
                        propertySet4.mProgress = obtainStyledAttributes.getFloat(index, propertySet4.mProgress);
                        break;
                    case 69:
                        constraint.layout.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 70:
                        constraint.layout.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 71:
                        break;
                    case 72:
                        Layout layout49 = constraint.layout;
                        layout49.mBarrierDirection = obtainStyledAttributes.getInt(index, layout49.mBarrierDirection);
                        break;
                    case 73:
                        Layout layout50 = constraint.layout;
                        layout50.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout50.mBarrierMargin);
                        break;
                    case 74:
                        constraint.layout.mReferenceIdString = obtainStyledAttributes.getString(index);
                        break;
                    case 75:
                        Layout layout51 = constraint.layout;
                        layout51.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                        break;
                    case 76:
                        Motion motion3 = constraint.motion;
                        motion3.mPathMotionArc = obtainStyledAttributes.getInt(index, motion3.mPathMotionArc);
                        break;
                    case 77:
                        constraint.layout.mConstraintTag = obtainStyledAttributes.getString(index);
                        break;
                    case 78:
                        PropertySet propertySet5 = constraint.propertySet;
                        propertySet5.mVisibilityMode = obtainStyledAttributes.getInt(index, propertySet5.mVisibilityMode);
                        break;
                    case 79:
                        Motion motion4 = constraint.motion;
                        motion4.mMotionStagger = obtainStyledAttributes.getFloat(index, motion4.mMotionStagger);
                        break;
                    case 80:
                        Layout layout52 = constraint.layout;
                        layout52.constrainedWidth = obtainStyledAttributes.getBoolean(index, layout52.constrainedWidth);
                        break;
                    case 81:
                        Layout layout53 = constraint.layout;
                        layout53.constrainedHeight = obtainStyledAttributes.getBoolean(index, layout53.constrainedHeight);
                        break;
                    case 82:
                        Motion motion5 = constraint.motion;
                        motion5.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, motion5.mAnimateCircleAngleTo);
                        break;
                    case 83:
                        Transform transform12 = constraint.transform;
                        int resourceId16 = obtainStyledAttributes.getResourceId(index, transform12.transformPivotTarget);
                        if (resourceId16 == -1) {
                            resourceId16 = obtainStyledAttributes.getInt(index, -1);
                        }
                        transform12.transformPivotTarget = resourceId16;
                        break;
                    case 84:
                        Motion motion6 = constraint.motion;
                        motion6.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, motion6.mQuantizeMotionSteps);
                        break;
                    case 85:
                        Motion motion7 = constraint.motion;
                        motion7.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, motion7.mQuantizeMotionPhase);
                        break;
                    case 86:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 != 1) {
                            if (i2 != 3) {
                                Motion motion8 = constraint.motion;
                                motion8.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, motion8.mQuantizeInterpolatorID);
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorString = obtainStyledAttributes.getString(index);
                                if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                    constraint.motion.mQuantizeInterpolatorType = -1;
                                    break;
                                } else {
                                    constraint.motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    constraint.motion.mQuantizeInterpolatorType = -2;
                                    break;
                                }
                            }
                        } else {
                            constraint.motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                            Motion motion9 = constraint.motion;
                            if (motion9.mQuantizeInterpolatorID == -1) {
                                break;
                            } else {
                                motion9.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                    case 87:
                        Integer.toHexString(index);
                        mapToConstant.get(index);
                        break;
                    case 91:
                        Layout layout54 = constraint.layout;
                        int resourceId17 = obtainStyledAttributes.getResourceId(index, layout54.baselineToTop);
                        if (resourceId17 == -1) {
                            resourceId17 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout54.baselineToTop = resourceId17;
                        break;
                    case 92:
                        Layout layout55 = constraint.layout;
                        int resourceId18 = obtainStyledAttributes.getResourceId(index, layout55.baselineToBottom);
                        if (resourceId18 == -1) {
                            resourceId18 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout55.baselineToBottom = resourceId18;
                        break;
                    case 93:
                        Layout layout56 = constraint.layout;
                        layout56.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout56.baselineMargin);
                        break;
                    case 94:
                        Layout layout57 = constraint.layout;
                        layout57.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                        break;
                    case 95:
                        parseDimensionConstraints(constraint.layout, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        parseDimensionConstraints(constraint.layout, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        Layout layout58 = constraint.layout;
                        layout58.mWrapBehavior = obtainStyledAttributes.getInt(index, layout58.mWrapBehavior);
                        break;
                    default:
                        Integer.toHexString(index);
                        mapToConstant.get(index);
                        break;
                }
            }
            Layout layout59 = constraint.layout;
            if (layout59.mReferenceIdString != null) {
                layout59.mReferenceIds = null;
            }
        }
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public final Constraint get(int i) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i));
    }

    public Constraint getConstraint(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            return this.mConstraints.get(Integer.valueOf(i));
        }
        return null;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01cd, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01dc
            if (r0 == 0) goto L_0x01ca
            r4 = -1
            r5 = 0
            r6 = 2
            r7 = 3
            if (r0 == r6) goto L_0x0067
            if (r0 == r7) goto L_0x0015
            goto L_0x01cd
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x004e
            r4 = 0
            goto L_0x004e
        L_0x0031:
            java.lang.String r5 = "constraintoverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x004e
            r4 = 2
            goto L_0x004e
        L_0x003b:
            java.lang.String r5 = "constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x004e
            r4 = 1
            goto L_0x004e
        L_0x0045:
            java.lang.String r5 = "guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x004e
            r4 = 3
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r7) goto L_0x0058
            goto L_0x01cd
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r0 = r9.mConstraints     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r3 = r2.mViewId     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r2 = r1
            goto L_0x01cd
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r6 = "Constraint"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 0
            goto L_0x00d9
        L_0x007e:
            java.lang.String r6 = "CustomAttribute"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 3
            goto L_0x00d9
        L_0x0093:
            java.lang.String r6 = "CustomMethod"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r7 = "Guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 2
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r6 = "Transform"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r6 = "PropertySet"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r6 = "ConstraintOverride"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 1
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r6 = "Motion"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r6 = "Layout"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01c0;
                case 1: goto L_0x01b7;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cd
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01cd
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.ConstraintSet$Motion r0 = r2.motion     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r0.fillFromAttributeList(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01cd
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.layout     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r0.fillFromAttributeList(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01cd
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.ConstraintSet$Transform r0 = r2.transform     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r0.fillFromAttributeList(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01cd
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r0 = r2.propertySet     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r0.fillFromAttributeList(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01cd
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.layout     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r2.mHelperType = r3     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01c8
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.layout     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r2.mIsGuideline = r3     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r0.layout     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            r2.mApply = r3     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01c8
        L_0x01b7:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x01c8
        L_0x01c0:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r0 = r9.fillFromAttributeList(r10, r0, r5)     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x01c8:
            r2 = r0
            goto L_0x01cd
        L_0x01ca:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
        L_0x01cd:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d8, IOException -> 0x01d3 }
            goto L_0x0006
        L_0x01d3:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01dc
        L_0x01d8:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
