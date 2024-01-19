package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.WidgetContainer;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.net.ftp.FTPReply;

public class ConstraintLayout extends ViewGroup {
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    public static final boolean MEASURE = false;
    public static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    public static final String TAG = "ConstraintLayout";
    public static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.1";
    public static SharedValues sSharedValues;
    public SparseArray<View> mChildrenByIds = new SparseArray<>();
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    public ConstraintLayoutStates mConstraintLayoutSpec = null;
    public ConstraintSet mConstraintSet = null;
    public int mConstraintSetId = -1;
    public ConstraintsChangedListener mConstraintsChangedListener;
    public HashMap<String, Integer> mDesignIds = new HashMap<>();
    public boolean mDirtyHierarchy = true;
    public int mLastMeasureHeight = -1;
    public int mLastMeasureHeightMode = 0;
    public int mLastMeasureHeightSize = -1;
    public int mLastMeasureWidth = -1;
    public int mLastMeasureWidthMode = 0;
    public int mLastMeasureWidthSize = -1;
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    public int mMaxHeight = Integer.MAX_VALUE;
    public int mMaxWidth = Integer.MAX_VALUE;
    public Measurer mMeasurer = new Measurer(this);
    public Metrics mMetrics;
    public int mMinHeight = 0;
    public int mMinWidth = 0;
    public int mOnMeasureHeightMeasureSpec = 0;
    public int mOnMeasureWidthMeasureSpec = 0;
    public int mOptimizationLevel = FTPReply.PATHNAME_CREATED;
    public SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public static class LayoutParams extends MarginLayoutParams {
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String constraintTag = null;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
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
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        public boolean isGuideline = false;
        public boolean isHelper = false;
        public boolean isInPlaceholder = false;
        public boolean isVirtualGroup = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        public boolean needsBaseline = false;
        public int orientation = -1;
        public int resolveGoneLeftMargin = LinearLayoutManager.INVALID_OFFSET;
        public int resolveGoneRightMargin = LinearLayoutManager.INVALID_OFFSET;
        public int resolvedGuideBegin;
        public int resolvedGuideEnd;
        public float resolvedGuidePercent;
        public float resolvedHorizontalBias = 0.5f;
        public int resolvedLeftToLeft = -1;
        public int resolvedLeftToRight = -1;
        public int resolvedRightToLeft = -1;
        public int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        public ConstraintWidget widget = new ConstraintWidget();
        public int wrapBehaviorInParent = 0;

        public static class Table {
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                map.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                map.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = Table.map.get(index);
                switch (i2) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f2;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.circleAngle = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        this.matchConstraintDefaultWidth = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.matchConstraintDefaultHeight = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinWidth = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinHeight = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i2) {
                            case 44:
                                ConstraintSet.parseDimensionRatioString(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                                this.baselineToTop = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                                this.baselineToBottom = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                break;
                            case 55:
                                this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                break;
                            default:
                                switch (i2) {
                                    case 64:
                                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                int r7 = r6.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r7) goto L_0x0011
                r7 = 1
                goto L_0x0012
            L_0x0011:
                r7 = 0
            L_0x0012:
                r4 = -1
                r6.resolvedRightToLeft = r4
                r6.resolvedRightToRight = r4
                r6.resolvedLeftToLeft = r4
                r6.resolvedLeftToRight = r4
                r6.resolveGoneLeftMargin = r4
                r6.resolveGoneRightMargin = r4
                int r5 = r6.goneLeftMargin
                r6.resolveGoneLeftMargin = r5
                int r5 = r6.goneRightMargin
                r6.resolveGoneRightMargin = r5
                float r5 = r6.horizontalBias
                r6.resolvedHorizontalBias = r5
                int r5 = r6.guideBegin
                r6.resolvedGuideBegin = r5
                int r5 = r6.guideEnd
                r6.resolvedGuideEnd = r5
                float r5 = r6.guidePercent
                r6.resolvedGuidePercent = r5
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r7 == 0) goto L_0x009c
                int r7 = r6.startToEnd
                if (r7 == r4) goto L_0x0043
                r6.resolvedRightToLeft = r7
            L_0x0041:
                r2 = 1
                goto L_0x004a
            L_0x0043:
                int r7 = r6.startToStart
                if (r7 == r4) goto L_0x004a
                r6.resolvedRightToRight = r7
                goto L_0x0041
            L_0x004a:
                int r7 = r6.endToStart
                if (r7 == r4) goto L_0x0051
                r6.resolvedLeftToRight = r7
                r2 = 1
            L_0x0051:
                int r7 = r6.endToEnd
                if (r7 == r4) goto L_0x0058
                r6.resolvedLeftToLeft = r7
                r2 = 1
            L_0x0058:
                int r7 = r6.goneStartMargin
                if (r7 == r5) goto L_0x005e
                r6.resolveGoneRightMargin = r7
            L_0x005e:
                int r7 = r6.goneEndMargin
                if (r7 == r5) goto L_0x0064
                r6.resolveGoneLeftMargin = r7
            L_0x0064:
                r7 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x006e
                float r2 = r6.horizontalBias
                float r2 = r7 - r2
                r6.resolvedHorizontalBias = r2
            L_0x006e:
                boolean r2 = r6.isGuideline
                if (r2 == 0) goto L_0x00c0
                int r2 = r6.orientation
                if (r2 != r3) goto L_0x00c0
                float r2 = r6.guidePercent
                r3 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0086
                float r7 = r7 - r2
                r6.resolvedGuidePercent = r7
                r6.resolvedGuideBegin = r4
                r6.resolvedGuideEnd = r4
                goto L_0x00c0
            L_0x0086:
                int r7 = r6.guideBegin
                if (r7 == r4) goto L_0x0091
                r6.resolvedGuideEnd = r7
                r6.resolvedGuideBegin = r4
                r6.resolvedGuidePercent = r3
                goto L_0x00c0
            L_0x0091:
                int r7 = r6.guideEnd
                if (r7 == r4) goto L_0x00c0
                r6.resolvedGuideBegin = r7
                r6.resolvedGuideEnd = r4
                r6.resolvedGuidePercent = r3
                goto L_0x00c0
            L_0x009c:
                int r7 = r6.startToEnd
                if (r7 == r4) goto L_0x00a2
                r6.resolvedLeftToRight = r7
            L_0x00a2:
                int r7 = r6.startToStart
                if (r7 == r4) goto L_0x00a8
                r6.resolvedLeftToLeft = r7
            L_0x00a8:
                int r7 = r6.endToStart
                if (r7 == r4) goto L_0x00ae
                r6.resolvedRightToLeft = r7
            L_0x00ae:
                int r7 = r6.endToEnd
                if (r7 == r4) goto L_0x00b4
                r6.resolvedRightToRight = r7
            L_0x00b4:
                int r7 = r6.goneStartMargin
                if (r7 == r5) goto L_0x00ba
                r6.resolveGoneLeftMargin = r7
            L_0x00ba:
                int r7 = r6.goneEndMargin
                if (r7 == r5) goto L_0x00c0
                r6.resolveGoneRightMargin = r7
            L_0x00c0:
                int r7 = r6.endToStart
                if (r7 != r4) goto L_0x010a
                int r7 = r6.endToEnd
                if (r7 != r4) goto L_0x010a
                int r7 = r6.startToStart
                if (r7 != r4) goto L_0x010a
                int r7 = r6.startToEnd
                if (r7 != r4) goto L_0x010a
                int r7 = r6.rightToLeft
                if (r7 == r4) goto L_0x00df
                r6.resolvedRightToLeft = r7
                int r7 = r6.rightMargin
                if (r7 > 0) goto L_0x00ed
                if (r1 <= 0) goto L_0x00ed
                r6.rightMargin = r1
                goto L_0x00ed
            L_0x00df:
                int r7 = r6.rightToRight
                if (r7 == r4) goto L_0x00ed
                r6.resolvedRightToRight = r7
                int r7 = r6.rightMargin
                if (r7 > 0) goto L_0x00ed
                if (r1 <= 0) goto L_0x00ed
                r6.rightMargin = r1
            L_0x00ed:
                int r7 = r6.leftToLeft
                if (r7 == r4) goto L_0x00fc
                r6.resolvedLeftToLeft = r7
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x010a
                if (r0 <= 0) goto L_0x010a
                r6.leftMargin = r0
                goto L_0x010a
            L_0x00fc:
                int r7 = r6.leftToRight
                if (r7 == r4) goto L_0x010a
                r6.resolvedLeftToRight = r7
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x010a
                if (r0 <= 0) goto L_0x010a
                r6.leftMargin = r0
            L_0x010a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            int i = this.width;
            if (i == 0 || i == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            int i2 = this.height;
            if (i2 == 0 || i2 == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class Measurer implements androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer {
        public ConstraintLayout layout;
        public int layoutHeightSpec;
        public int layoutWidthSpec;
        public int paddingBottom;
        public int paddingHeight;
        public int paddingTop;
        public int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        public final boolean isSimilarSpec(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = MeasureSpec.getMode(i);
            MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (mode2 == 1073741824 && ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size)) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:117:0x01a5  */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x01ba  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01c1  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x01c3  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x01f5 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x01f6  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void measure(androidx.constraintlayout.core.widgets.ConstraintWidget r18, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r1.mVisibility
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001b
                boolean r3 = r1.inPlaceholder
                if (r3 != 0) goto L_0x001b
                r2.measuredWidth = r5
                r2.measuredHeight = r5
                r2.measuredBaseline = r5
                return
            L_0x001b:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mParent
                if (r3 != 0) goto L_0x0020
                return
            L_0x0020:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.horizontalBehavior
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.verticalBehavior
                int r6 = r2.horizontalDimension
                int r7 = r2.verticalDimension
                int r8 = r0.paddingTop
                int r9 = r0.paddingBottom
                int r8 = r8 + r9
                int r9 = r0.paddingWidth
                java.lang.Object r10 = r1.mCompanionWidget
                android.view.View r10 = (android.view.View) r10
                int r11 = r3.ordinal()
                r12 = 3
                r13 = 2
                r14 = -1
                r15 = 1
                if (r11 == 0) goto L_0x00b1
                if (r11 == r15) goto L_0x00a7
                if (r11 == r13) goto L_0x005d
                if (r11 == r12) goto L_0x0045
                goto L_0x00b7
            L_0x0045:
                int r6 = r0.layoutWidthSpec
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r1.mLeft
                if (r11 == 0) goto L_0x004f
                int r11 = r11.mMargin
                int r11 = r11 + r5
                goto L_0x0050
            L_0x004f:
                r11 = 0
            L_0x0050:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r1.mRight
                if (r5 == 0) goto L_0x0057
                int r5 = r5.mMargin
                int r11 = r11 + r5
            L_0x0057:
                int r9 = r9 + r11
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r14)
                goto L_0x00b7
            L_0x005d:
                int r5 = r0.layoutWidthSpec
                r6 = -2
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r9, r6)
                int r6 = r1.mMatchConstraintDefaultWidth
                if (r6 != r15) goto L_0x006a
                r6 = 1
                goto L_0x006b
            L_0x006a:
                r6 = 0
            L_0x006b:
                int r9 = r2.measureStrategy
                if (r9 == r15) goto L_0x0075
                if (r9 != r13) goto L_0x0072
                goto L_0x0075
            L_0x0072:
                r11 = 1073741824(0x40000000, float:2.0)
                goto L_0x00b7
            L_0x0075:
                int r9 = r10.getMeasuredHeight()
                int r11 = r18.getHeight()
                if (r9 != r11) goto L_0x0081
                r9 = 1
                goto L_0x0082
            L_0x0081:
                r9 = 0
            L_0x0082:
                int r11 = r2.measureStrategy
                if (r11 == r13) goto L_0x0099
                if (r6 == 0) goto L_0x0099
                if (r6 == 0) goto L_0x008c
                if (r9 != 0) goto L_0x0099
            L_0x008c:
                boolean r6 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r6 != 0) goto L_0x0099
                boolean r6 = r18.isResolvedHorizontally()
                if (r6 == 0) goto L_0x0097
                goto L_0x0099
            L_0x0097:
                r6 = 0
                goto L_0x009a
            L_0x0099:
                r6 = 1
            L_0x009a:
                if (r6 == 0) goto L_0x0072
                int r5 = r18.getWidth()
                r11 = 1073741824(0x40000000, float:2.0)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
                goto L_0x00b7
            L_0x00a7:
                r11 = 1073741824(0x40000000, float:2.0)
                int r5 = r0.layoutWidthSpec
                r6 = -2
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r9, r6)
                goto L_0x00b7
            L_0x00b1:
                r11 = 1073741824(0x40000000, float:2.0)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r11)
            L_0x00b7:
                int r6 = r4.ordinal()
                if (r6 == 0) goto L_0x0137
                if (r6 == r15) goto L_0x012d
                if (r6 == r13) goto L_0x00e3
                if (r6 == r12) goto L_0x00c6
                r9 = 0
                goto L_0x013e
            L_0x00c6:
                int r6 = r0.layoutHeightSpec
                androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r1.mLeft
                if (r7 == 0) goto L_0x00d3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r1.mTop
                int r7 = r7.mMargin
                r9 = 0
                int r7 = r7 + r9
                goto L_0x00d4
            L_0x00d3:
                r7 = 0
            L_0x00d4:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r1.mRight
                if (r9 == 0) goto L_0x00dd
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r1.mBottom
                int r9 = r9.mMargin
                int r7 = r7 + r9
            L_0x00dd:
                int r8 = r8 + r7
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r8, r14)
                goto L_0x013d
            L_0x00e3:
                int r6 = r0.layoutHeightSpec
                r7 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r8, r7)
                int r7 = r1.mMatchConstraintDefaultHeight
                if (r7 != r15) goto L_0x00f0
                r7 = 1
                goto L_0x00f1
            L_0x00f0:
                r7 = 0
            L_0x00f1:
                int r8 = r2.measureStrategy
                if (r8 == r15) goto L_0x00fb
                if (r8 != r13) goto L_0x00f8
                goto L_0x00fb
            L_0x00f8:
                r9 = 1073741824(0x40000000, float:2.0)
                goto L_0x013d
            L_0x00fb:
                int r8 = r10.getMeasuredWidth()
                int r9 = r18.getWidth()
                if (r8 != r9) goto L_0x0107
                r8 = 1
                goto L_0x0108
            L_0x0107:
                r8 = 0
            L_0x0108:
                int r9 = r2.measureStrategy
                if (r9 == r13) goto L_0x011f
                if (r7 == 0) goto L_0x011f
                if (r7 == 0) goto L_0x0112
                if (r8 != 0) goto L_0x011f
            L_0x0112:
                boolean r7 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r7 != 0) goto L_0x011f
                boolean r7 = r18.isResolvedVertically()
                if (r7 == 0) goto L_0x011d
                goto L_0x011f
            L_0x011d:
                r7 = 0
                goto L_0x0120
            L_0x011f:
                r7 = 1
            L_0x0120:
                if (r7 == 0) goto L_0x00f8
                int r6 = r18.getHeight()
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
                goto L_0x013d
            L_0x012d:
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = r0.layoutHeightSpec
                r7 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r8, r7)
                goto L_0x013d
            L_0x0137:
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            L_0x013d:
                r9 = r6
            L_0x013e:
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r1.mParent
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r6
                if (r6 == 0) goto L_0x01b6
                androidx.constraintlayout.widget.ConstraintLayout r7 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r7 = r7.mOptimizationLevel
                r8 = 256(0x100, float:3.59E-43)
                boolean r7 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r7, r8)
                if (r7 == 0) goto L_0x01b6
                int r7 = r10.getMeasuredWidth()
                int r8 = r18.getWidth()
                if (r7 != r8) goto L_0x01b6
                int r7 = r10.getMeasuredWidth()
                int r8 = r6.getWidth()
                if (r7 >= r8) goto L_0x01b6
                int r7 = r10.getMeasuredHeight()
                int r8 = r18.getHeight()
                if (r7 != r8) goto L_0x01b6
                int r7 = r10.getMeasuredHeight()
                int r6 = r6.getHeight()
                if (r7 >= r6) goto L_0x01b6
                int r6 = r10.getBaseline()
                int r7 = r1.mBaselineDistance
                if (r6 != r7) goto L_0x01b6
                boolean r6 = r18.isMeasureRequested()
                if (r6 != 0) goto L_0x01b6
                int r6 = r1.mLastHorizontalMeasureSpec
                int r7 = r18.getWidth()
                boolean r6 = r0.isSimilarSpec(r6, r5, r7)
                if (r6 == 0) goto L_0x01a2
                int r6 = r1.mLastVerticalMeasureSpec
                int r7 = r18.getHeight()
                boolean r6 = r0.isSimilarSpec(r6, r9, r7)
                if (r6 == 0) goto L_0x01a2
                r6 = 1
                goto L_0x01a3
            L_0x01a2:
                r6 = 0
            L_0x01a3:
                if (r6 == 0) goto L_0x01b6
                int r3 = r18.getWidth()
                r2.measuredWidth = r3
                int r3 = r18.getHeight()
                r2.measuredHeight = r3
                int r1 = r1.mBaselineDistance
                r2.measuredBaseline = r1
                return
            L_0x01b6:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r6) goto L_0x01bc
                r6 = 1
                goto L_0x01bd
            L_0x01bc:
                r6 = 0
            L_0x01bd:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r4 != r7) goto L_0x01c3
                r7 = 1
                goto L_0x01c4
            L_0x01c3:
                r7 = 0
            L_0x01c4:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r4 == r8) goto L_0x01cf
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r4 != r8) goto L_0x01cd
                goto L_0x01cf
            L_0x01cd:
                r4 = 0
                goto L_0x01d0
            L_0x01cf:
                r4 = 1
            L_0x01d0:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r3 == r8) goto L_0x01db
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r8) goto L_0x01d9
                goto L_0x01db
            L_0x01d9:
                r3 = 0
                goto L_0x01dc
            L_0x01db:
                r3 = 1
            L_0x01dc:
                r8 = 0
                if (r6 == 0) goto L_0x01e7
                float r11 = r1.mDimensionRatio
                int r11 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r11 <= 0) goto L_0x01e7
                r11 = 1
                goto L_0x01e8
            L_0x01e7:
                r11 = 0
            L_0x01e8:
                if (r7 == 0) goto L_0x01f2
                float r12 = r1.mDimensionRatio
                int r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r8 <= 0) goto L_0x01f2
                r8 = 1
                goto L_0x01f3
            L_0x01f2:
                r8 = 0
            L_0x01f3:
                if (r10 != 0) goto L_0x01f6
                return
            L_0x01f6:
                android.view.ViewGroup$LayoutParams r12 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r12 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r12
                int r14 = r2.measureStrategy
                if (r14 == r15) goto L_0x0216
                if (r14 == r13) goto L_0x0216
                if (r6 == 0) goto L_0x0216
                int r6 = r1.mMatchConstraintDefaultWidth
                if (r6 != 0) goto L_0x0216
                if (r7 == 0) goto L_0x0216
                int r6 = r1.mMatchConstraintDefaultHeight
                if (r6 == 0) goto L_0x020f
                goto L_0x0216
            L_0x020f:
                r0 = -1
                r9 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                goto L_0x02c2
            L_0x0216:
                boolean r6 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r6 == 0) goto L_0x0228
                boolean r6 = r1 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
                if (r6 == 0) goto L_0x0228
                r6 = r1
                androidx.constraintlayout.core.widgets.VirtualLayout r6 = (androidx.constraintlayout.core.widgets.VirtualLayout) r6
                r7 = r10
                androidx.constraintlayout.widget.VirtualLayout r7 = (androidx.constraintlayout.widget.VirtualLayout) r7
                r7.onMeasure(r6, r5, r9)
                goto L_0x022b
            L_0x0228:
                r10.measure(r5, r9)
            L_0x022b:
                r1.mLastHorizontalMeasureSpec = r5
                r1.mLastVerticalMeasureSpec = r9
                r6 = 0
                r1.mMeasureRequested = r6
                int r6 = r10.getMeasuredWidth()
                int r7 = r10.getMeasuredHeight()
                int r13 = r10.getBaseline()
                int r14 = r1.mMatchConstraintMinWidth
                if (r14 <= 0) goto L_0x0247
                int r14 = java.lang.Math.max(r14, r6)
                goto L_0x0248
            L_0x0247:
                r14 = r6
            L_0x0248:
                int r15 = r1.mMatchConstraintMaxWidth
                if (r15 <= 0) goto L_0x0250
                int r14 = java.lang.Math.min(r15, r14)
            L_0x0250:
                int r15 = r1.mMatchConstraintMinHeight
                if (r15 <= 0) goto L_0x025b
                int r15 = java.lang.Math.max(r15, r7)
                r16 = r5
                goto L_0x025e
            L_0x025b:
                r16 = r5
                r15 = r7
            L_0x025e:
                int r5 = r1.mMatchConstraintMaxHeight
                if (r5 <= 0) goto L_0x0266
                int r15 = java.lang.Math.min(r5, r15)
            L_0x0266:
                androidx.constraintlayout.widget.ConstraintLayout r5 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r5 = r5.mOptimizationLevel
                r0 = 1
                boolean r5 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r5, r0)
                if (r5 != 0) goto L_0x028d
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r11 == 0) goto L_0x0282
                if (r4 == 0) goto L_0x0282
                float r3 = r1.mDimensionRatio
                float r4 = (float) r15
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r0 = (int) r4
                r14 = r0
                goto L_0x028d
            L_0x0282:
                if (r8 == 0) goto L_0x028d
                if (r3 == 0) goto L_0x028d
                float r3 = r1.mDimensionRatio
                float r4 = (float) r14
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r0 = (int) r4
                r15 = r0
            L_0x028d:
                if (r6 != r14) goto L_0x0295
                if (r7 == r15) goto L_0x0292
                goto L_0x0295
            L_0x0292:
                r0 = -1
                r9 = 0
                goto L_0x02c2
            L_0x0295:
                if (r6 == r14) goto L_0x029e
                r0 = 1073741824(0x40000000, float:2.0)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r0)
                goto L_0x02a2
            L_0x029e:
                r0 = 1073741824(0x40000000, float:2.0)
                r5 = r16
            L_0x02a2:
                if (r7 == r15) goto L_0x02a8
                int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r0)
            L_0x02a8:
                r10.measure(r5, r9)
                r1.mLastHorizontalMeasureSpec = r5
                r1.mLastVerticalMeasureSpec = r9
                r9 = 0
                r1.mMeasureRequested = r9
                int r0 = r10.getMeasuredWidth()
                int r3 = r10.getMeasuredHeight()
                int r4 = r10.getBaseline()
                r14 = r0
                r15 = r3
                r13 = r4
                r0 = -1
            L_0x02c2:
                if (r13 == r0) goto L_0x02c6
                r0 = 1
                goto L_0x02c7
            L_0x02c6:
                r0 = 0
            L_0x02c7:
                int r3 = r2.horizontalDimension
                if (r14 != r3) goto L_0x02d2
                int r3 = r2.verticalDimension
                if (r15 == r3) goto L_0x02d0
                goto L_0x02d2
            L_0x02d0:
                r5 = 0
                goto L_0x02d3
            L_0x02d2:
                r5 = 1
            L_0x02d3:
                r2.measuredNeedsSolverPass = r5
                boolean r3 = r12.needsBaseline
                if (r3 == 0) goto L_0x02da
                r0 = 1
            L_0x02da:
                if (r0 == 0) goto L_0x02e6
                r3 = -1
                if (r13 == r3) goto L_0x02e6
                int r1 = r1.mBaselineDistance
                if (r1 == r13) goto L_0x02e6
                r1 = 1
                r2.measuredNeedsSolverPass = r1
            L_0x02e6:
                r2.measuredWidth = r14
                r2.measuredHeight = r15
                r2.measuredHasBaseline = r0
                r2.measuredBaseline = r13
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.measure(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int i) {
        ConstraintWidget constraintWidget;
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null) {
            view = findViewById(i);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            constraintWidget = null;
        } else {
            constraintWidget = ((LayoutParams) view.getLayoutParams()).widget;
        }
        return constraintWidget;
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mCompanionWidget = this;
        constraintWidgetContainer.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).mDebugName = resourceName;
                } catch (NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.mChildren.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintHelper constraintHelper = this.mConstraintHelpers.get(i4);
                if (constraintHelper.isInEditMode()) {
                    constraintHelper.setIds(constraintHelper.mReferenceIds);
                }
                Helper helper = constraintHelper.mHelperWidget;
                if (helper != null) {
                    helper.removeAllIds();
                    for (int i5 = 0; i5 < constraintHelper.mCount; i5++) {
                        int i6 = constraintHelper.mIds[i5];
                        View viewById = getViewById(i6);
                        if (viewById == null) {
                            String str = constraintHelper.mMap.get(Integer.valueOf(i6));
                            int findId = constraintHelper.findId(this, str);
                            if (findId != 0) {
                                constraintHelper.mIds[i5] = findId;
                                constraintHelper.mMap.put(Integer.valueOf(findId), str);
                                viewById = getViewById(findId);
                            }
                        }
                        if (viewById != null) {
                            constraintHelper.mHelperWidget.add(getViewWidget(viewById));
                        }
                    }
                    constraintHelper.mHelperWidget.updateConstraints(this.mLayoutWidget);
                }
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            if (childAt3 instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) childAt3;
                if (placeholder.mContentId == -1 && !placeholder.isInEditMode()) {
                    placeholder.setVisibility(placeholder.mEmptyVisibility);
                }
                View findViewById = findViewById(placeholder.mContentId);
                placeholder.mContent = findViewById;
                if (findViewById != null) {
                    ((LayoutParams) findViewById.getLayoutParams()).isInPlaceholder = true;
                    placeholder.mContent.setVisibility(0);
                    placeholder.setVisibility(0);
                }
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt5 = getChildAt(i9);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                constraintWidgetContainer.mChildren.add(viewWidget2);
                ConstraintWidget constraintWidget = viewWidget2.mParent;
                if (constraintWidget != null) {
                    ((WidgetContainer) constraintWidget).mChildren.remove(viewWidget2);
                    viewWidget2.reset();
                }
                viewWidget2.mParent = constraintWidgetContainer;
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i, Type type) {
        View view = this.mChildrenByIds.get(i);
        ConstraintWidget constraintWidget2 = sparseArray.get(i);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.needsBaseline = true;
            if (type == Type.BASELINE) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.needsBaseline = true;
                layoutParams2.widget.hasBaseline = true;
            }
            constraintWidget.getAnchor(Type.BASELINE).connect(constraintWidget2.getAnchor(type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
            constraintWidget.hasBaseline = true;
            constraintWidget.getAnchor(Type.TOP).reset();
            constraintWidget.getAnchor(Type.BOTTOM).reset();
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:153:0x02d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyConstraintsFromLayoutParams(boolean r18, android.view.View r19, androidx.constraintlayout.core.widgets.ConstraintWidget r20, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r21, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r22) {
        /*
            r17 = this;
            r0 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r21.validate()
            int r1 = r19.getVisibility()
            r6.mVisibility = r1
            boolean r1 = r7.isInPlaceholder
            r9 = 1
            if (r1 == 0) goto L_0x001c
            r6.inPlaceholder = r9
            r1 = 8
            r6.mVisibility = r1
        L_0x001c:
            r6.mCompanionWidget = r0
            boolean r1 = r0 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r1 == 0) goto L_0x002e
            androidx.constraintlayout.widget.ConstraintHelper r0 = (androidx.constraintlayout.widget.ConstraintHelper) r0
            r10 = r17
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r10.mLayoutWidget
            boolean r1 = r1.mIsRtl
            r0.resolveRtl(r6, r1)
            goto L_0x0030
        L_0x002e:
            r10 = r17
        L_0x0030:
            boolean r0 = r7.isGuideline
            r11 = -1
            if (r0 == 0) goto L_0x0066
            r0 = r6
            androidx.constraintlayout.core.widgets.Guideline r0 = (androidx.constraintlayout.core.widgets.Guideline) r0
            int r1 = r7.resolvedGuideBegin
            int r2 = r7.resolvedGuideEnd
            float r3 = r7.resolvedGuidePercent
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x004e
            if (r5 <= 0) goto L_0x0344
            r0.mRelativePercent = r3
            r0.mRelativeBegin = r11
            r0.mRelativeEnd = r11
            goto L_0x0344
        L_0x004e:
            if (r1 == r11) goto L_0x005a
            if (r1 <= r11) goto L_0x0344
            r0.mRelativePercent = r4
            r0.mRelativeBegin = r1
            r0.mRelativeEnd = r11
            goto L_0x0344
        L_0x005a:
            if (r2 == r11) goto L_0x0344
            if (r2 <= r11) goto L_0x0344
            r0.mRelativePercent = r4
            r0.mRelativeBegin = r11
            r0.mRelativeEnd = r2
            goto L_0x0344
        L_0x0066:
            int r0 = r7.resolvedLeftToLeft
            int r1 = r7.resolvedLeftToRight
            int r12 = r7.resolvedRightToLeft
            int r13 = r7.resolvedRightToRight
            int r5 = r7.resolveGoneLeftMargin
            int r14 = r7.resolveGoneRightMargin
            float r15 = r7.resolvedHorizontalBias
            int r2 = r7.circleConstraint
            r4 = 0
            if (r2 == r11) goto L_0x0099
            java.lang.Object r0 = r8.get(r2)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0095
            float r8 = r7.circleAngle
            int r5 = r7.circleRadius
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            r12 = 0
            r0 = r20
            r1 = r3
            r13 = 0
            r4 = r5
            r5 = r12
            r0.immediateConnect(r1, r2, r3, r4, r5)
            r6.mCircleConstraintAngle = r8
            goto L_0x0096
        L_0x0095:
            r13 = 0
        L_0x0096:
            r9 = 0
            goto L_0x01a6
        L_0x0099:
            if (r0 == r11) goto L_0x00b6
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00b4
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r1 = r7.leftMargin
            r0 = r20
            r16 = r1
            r1 = r3
            r9 = 0
            r4 = r16
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x00cd
        L_0x00b4:
            r9 = 0
            goto L_0x00cd
        L_0x00b6:
            r9 = 0
            if (r1 == r11) goto L_0x00cd
            java.lang.Object r0 = r8.get(r1)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00cd
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r7.leftMargin
            r0 = r20
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x00cd:
            if (r12 == r11) goto L_0x00e5
            java.lang.Object r0 = r8.get(r12)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00fb
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r7.rightMargin
            r0 = r20
            r5 = r14
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x00fb
        L_0x00e5:
            if (r13 == r11) goto L_0x00fb
            java.lang.Object r0 = r8.get(r13)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00fb
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r7.rightMargin
            r0 = r20
            r1 = r3
            r5 = r14
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x00fb:
            int r0 = r7.topToTop
            if (r0 == r11) goto L_0x0115
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x012f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r7.topMargin
            int r5 = r7.goneTopMargin
            r0 = r20
            r1 = r3
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x012f
        L_0x0115:
            int r0 = r7.topToBottom
            if (r0 == r11) goto L_0x012f
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x012f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r7.topMargin
            int r5 = r7.goneTopMargin
            r0 = r20
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x012f:
            int r0 = r7.bottomToTop
            if (r0 == r11) goto L_0x014a
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0163
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r7.bottomMargin
            int r5 = r7.goneBottomMargin
            r0 = r20
            r0.immediateConnect(r1, r2, r3, r4, r5)
            goto L_0x0163
        L_0x014a:
            int r0 = r7.bottomToBottom
            if (r0 == r11) goto L_0x0163
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0163
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r7.bottomMargin
            int r5 = r7.goneBottomMargin
            r0 = r20
            r1 = r3
            r0.immediateConnect(r1, r2, r3, r4, r5)
        L_0x0163:
            int r4 = r7.baselineToBaseline
            if (r4 == r11) goto L_0x0175
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            r0 = r17
            r1 = r20
            r2 = r21
            r3 = r22
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            goto L_0x0198
        L_0x0175:
            int r4 = r7.baselineToTop
            if (r4 == r11) goto L_0x0187
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            r0 = r17
            r1 = r20
            r2 = r21
            r3 = r22
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            goto L_0x0198
        L_0x0187:
            int r4 = r7.baselineToBottom
            if (r4 == r11) goto L_0x0198
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            r0 = r17
            r1 = r20
            r2 = r21
            r3 = r22
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
        L_0x0198:
            int r0 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x019e
            r6.mHorizontalBiasPercent = r15
        L_0x019e:
            float r0 = r7.verticalBias
            int r1 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x01a6
            r6.mVerticalBiasPercent = r0
        L_0x01a6:
            if (r18 == 0) goto L_0x01b8
            int r0 = r7.editorAbsoluteX
            if (r0 != r11) goto L_0x01b0
            int r0 = r7.editorAbsoluteY
            if (r0 == r11) goto L_0x01b8
        L_0x01b0:
            int r0 = r7.editorAbsoluteX
            int r1 = r7.editorAbsoluteY
            r6.mX = r0
            r6.mY = r1
        L_0x01b8:
            boolean r0 = r7.horizontalDimensionFixed
            r1 = -2
            r2 = 0
            if (r0 != 0) goto L_0x01ef
            int r0 = r7.width
            if (r0 != r11) goto L_0x01e6
            boolean r0 = r7.constrainedWidth
            if (r0 == 0) goto L_0x01cc
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.setHorizontalDimensionBehaviour(r0)
            goto L_0x01d1
        L_0x01cc:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r6.setHorizontalDimensionBehaviour(r0)
        L_0x01d1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.getAnchor(r0)
            int r3 = r7.leftMargin
            r0.mMargin = r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.getAnchor(r0)
            int r3 = r7.rightMargin
            r0.mMargin = r3
            goto L_0x0202
        L_0x01e6:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.setHorizontalDimensionBehaviour(r0)
            r6.setWidth(r2)
            goto L_0x0202
        L_0x01ef:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6.setHorizontalDimensionBehaviour(r0)
            int r0 = r7.width
            r6.setWidth(r0)
            int r0 = r7.width
            if (r0 != r1) goto L_0x0202
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6.setHorizontalDimensionBehaviour(r0)
        L_0x0202:
            boolean r0 = r7.verticalDimensionFixed
            if (r0 != 0) goto L_0x0237
            int r0 = r7.height
            if (r0 != r11) goto L_0x022e
            boolean r0 = r7.constrainedHeight
            if (r0 == 0) goto L_0x0214
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.setVerticalDimensionBehaviour(r0)
            goto L_0x0219
        L_0x0214:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r6.setVerticalDimensionBehaviour(r0)
        L_0x0219:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.getAnchor(r0)
            int r1 = r7.topMargin
            r0.mMargin = r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.getAnchor(r0)
            int r1 = r7.bottomMargin
            r0.mMargin = r1
            goto L_0x024a
        L_0x022e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.setVerticalDimensionBehaviour(r0)
            r6.setHeight(r2)
            goto L_0x024a
        L_0x0237:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6.setVerticalDimensionBehaviour(r0)
            int r0 = r7.height
            r6.setHeight(r0)
            int r0 = r7.height
            if (r0 != r1) goto L_0x024a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6.setVerticalDimensionBehaviour(r0)
        L_0x024a:
            java.lang.String r0 = r7.dimensionRatio
            if (r0 == 0) goto L_0x02dd
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0256
            goto L_0x02dd
        L_0x0256:
            int r1 = r0.length()
            r3 = 44
            int r3 = r0.indexOf(r3)
            if (r3 <= 0) goto L_0x0283
            int r4 = r1 + -1
            if (r3 >= r4) goto L_0x0283
            java.lang.String r4 = r0.substring(r2, r3)
            java.lang.String r5 = "W"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0275
            r4 = 1
            r11 = 0
            goto L_0x0281
        L_0x0275:
            java.lang.String r5 = "H"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x0280
            r4 = 1
            r11 = 1
            goto L_0x0281
        L_0x0280:
            r4 = 1
        L_0x0281:
            int r3 = r3 + r4
            goto L_0x0285
        L_0x0283:
            r4 = 1
            r3 = 0
        L_0x0285:
            r5 = 58
            int r5 = r0.indexOf(r5)
            if (r5 < 0) goto L_0x02c4
            int r1 = r1 - r4
            if (r5 >= r1) goto L_0x02c4
            java.lang.String r1 = r0.substring(r3, r5)
            int r5 = r5 + r4
            java.lang.String r0 = r0.substring(r5)
            int r3 = r1.length()
            if (r3 <= 0) goto L_0x02d3
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x02d3
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x02d3 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x02d3 }
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02d3
            int r3 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02d3
            r3 = 1
            if (r11 != r3) goto L_0x02be
            float r0 = r0 / r1
            float r4 = java.lang.Math.abs(r0)     // Catch:{ NumberFormatException -> 0x02d3 }
            goto L_0x02d4
        L_0x02be:
            float r1 = r1 / r0
            float r4 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x02d3 }
            goto L_0x02d4
        L_0x02c4:
            java.lang.String r0 = r0.substring(r3)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x02d3
            float r4 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x02d3 }
            goto L_0x02d4
        L_0x02d3:
            r4 = 0
        L_0x02d4:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x02df
            r6.mDimensionRatio = r4
            r6.mDimensionRatioSide = r11
            goto L_0x02df
        L_0x02dd:
            r6.mDimensionRatio = r9
        L_0x02df:
            float r0 = r7.horizontalWeight
            float[] r1 = r6.mWeight
            r1[r2] = r0
            float r0 = r7.verticalWeight
            r3 = 1
            r1[r3] = r0
            int r0 = r7.horizontalChainStyle
            r6.mHorizontalChainStyle = r0
            int r0 = r7.verticalChainStyle
            r6.mVerticalChainStyle = r0
            int r0 = r7.wrapBehaviorInParent
            if (r0 < 0) goto L_0x02fb
            r1 = 3
            if (r0 > r1) goto L_0x02fb
            r6.mWrapBehaviorInParent = r0
        L_0x02fb:
            int r0 = r7.matchConstraintDefaultWidth
            int r1 = r7.matchConstraintMinWidth
            int r3 = r7.matchConstraintMaxWidth
            float r4 = r7.matchConstraintPercentWidth
            r6.mMatchConstraintDefaultWidth = r0
            r6.mMatchConstraintMinWidth = r1
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r3 != r0) goto L_0x030d
            r3 = 0
        L_0x030d:
            r6.mMatchConstraintMaxWidth = r3
            r6.mMatchConstraintPercentWidth = r4
            r1 = 2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0322
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0322
            int r4 = r6.mMatchConstraintDefaultWidth
            if (r4 != 0) goto L_0x0322
            r6.mMatchConstraintDefaultWidth = r1
        L_0x0322:
            int r4 = r7.matchConstraintDefaultHeight
            int r5 = r7.matchConstraintMinHeight
            int r8 = r7.matchConstraintMaxHeight
            float r7 = r7.matchConstraintPercentHeight
            r6.mMatchConstraintDefaultHeight = r4
            r6.mMatchConstraintMinHeight = r5
            if (r8 != r0) goto L_0x0331
            goto L_0x0332
        L_0x0331:
            r2 = r8
        L_0x0332:
            r6.mMatchConstraintMaxHeight = r2
            r6.mMatchConstraintPercentHeight = r7
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0344
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0344
            int r0 = r6.mMatchConstraintDefaultHeight
            if (r0 != 0) goto L_0x0344
            r6.mMatchConstraintDefaultHeight = r1
        L_0x0344:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    this.mConstraintHelpers.get(i).updatePreDraw(this);
                }
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int parseInt3 = Integer.parseInt(split[2]);
                            int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                            int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            float f2 = (float) i3;
                            float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                            Canvas canvas2 = canvas;
                            float f4 = (float) i4;
                            float f5 = f2;
                            float f6 = f2;
                            float f7 = f4;
                            Paint paint2 = paint;
                            float f8 = f3;
                            Paint paint3 = paint2;
                            canvas2.drawLine(f5, f7, f8, f4, paint3);
                            float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                            float f9 = f3;
                            float f10 = parseInt4;
                            canvas2.drawLine(f9, f7, f8, f10, paint3);
                            float f11 = parseInt4;
                            float f12 = f6;
                            canvas2.drawLine(f9, f11, f12, f10, paint3);
                            float f13 = f6;
                            canvas2.drawLine(f13, f11, f12, f4, paint3);
                            Paint paint4 = paint2;
                            paint4.setColor(-16711936);
                            Paint paint5 = paint4;
                            float f14 = f3;
                            Paint paint6 = paint5;
                            canvas2.drawLine(f13, f4, f14, parseInt4, paint6);
                            canvas2.drawLine(f13, parseInt4, f14, f4, paint6);
                        }
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        if (this.mLayoutWidget.mSystem != null) {
            LinearSystem.sMetrics = metrics;
            return;
        }
        throw null;
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.mDesignIds.get(str);
            }
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.mOptimizationLevel;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).widget;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).widget;
            }
        }
        return null;
    }

    public boolean isRtl() {
        if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
            } catch (NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x;
                int height = constraintWidget.getHeight() + y;
                childAt.layout(x, y, width, height);
                if (childAt instanceof Placeholder) {
                    View content = ((Placeholder) childAt).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(x, y, width, height);
                    }
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.mOnMeasureWidthMeasureSpec == i) {
            int i3 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                } else if (getChildAt(i4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        boolean z = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.mIsRtl = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                constraintWidgetContainer.mBasicMeasureSolver.updateHierarchy(constraintWidgetContainer);
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        int width = this.mLayoutWidget.getWidth();
        int height = this.mLayoutWidget.getHeight();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, width, height, constraintWidgetContainer2.mWidthMeasuredTooSmall, constraintWidgetContainer2.mHeightMeasuredTooSmall);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.mChildren.remove(viewWidget);
        viewWidget.reset();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i3 + measurer.paddingWidth, i, 0);
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(i4 + i5, i2, 0) & 16777215);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x064d  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0652  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r21, int r22, int r23, int r24) {
        /*
            r20 = this;
            r6 = r21
            r7 = r22
            int r8 = android.view.View.MeasureSpec.getMode(r23)
            int r0 = android.view.View.MeasureSpec.getSize(r23)
            int r9 = android.view.View.MeasureSpec.getMode(r24)
            int r1 = android.view.View.MeasureSpec.getSize(r24)
            int r2 = r20.getPaddingTop()
            r10 = 0
            int r11 = java.lang.Math.max(r10, r2)
            int r2 = r20.getPaddingBottom()
            int r2 = java.lang.Math.max(r10, r2)
            int r3 = r11 + r2
            int r4 = r20.getPaddingWidth()
            r12 = r20
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r5 = r12.mMeasurer
            r5.paddingTop = r11
            r5.paddingBottom = r2
            r5.paddingWidth = r4
            r5.paddingHeight = r3
            r2 = r23
            r5.layoutWidthSpec = r2
            r2 = r24
            r5.layoutHeightSpec = r2
            int r2 = r20.getPaddingStart()
            int r2 = java.lang.Math.max(r10, r2)
            int r5 = r20.getPaddingEnd()
            int r5 = java.lang.Math.max(r10, r5)
            if (r2 > 0) goto L_0x005d
            if (r5 <= 0) goto L_0x0054
            goto L_0x005d
        L_0x0054:
            int r2 = r20.getPaddingLeft()
            int r2 = java.lang.Math.max(r10, r2)
            goto L_0x0065
        L_0x005d:
            boolean r13 = r20.isRtl()
            if (r13 == 0) goto L_0x0065
            r13 = r5
            goto L_0x0066
        L_0x0065:
            r13 = r2
        L_0x0066:
            int r14 = r0 - r4
            int r15 = r1 - r3
            r0 = r20
            r1 = r21
            r2 = r8
            r3 = r14
            r4 = r9
            r5 = r15
            r0.setSelfDimensionBehaviour(r1, r2, r3, r4, r5)
            r6.mPaddingLeft = r13
            r6.mPaddingTop = r11
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure r0 = r6.mBasicMeasureSolver
            if (r0 == 0) goto L_0x0652
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r1 = r6.mMeasurer
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r6.mChildren
            int r2 = r2.size()
            int r3 = r21.getWidth()
            int r4 = r21.getHeight()
            r5 = 128(0x80, float:1.8E-43)
            boolean r5 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r7, r5)
            r11 = 64
            if (r5 != 0) goto L_0x00a0
            boolean r7 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r7, r11)
            if (r7 == 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r7 = 0
            goto L_0x00a1
        L_0x00a0:
            r7 = 1
        L_0x00a1:
            r16 = 0
            if (r7 == 0) goto L_0x0103
            r11 = 0
        L_0x00a6:
            if (r11 >= r2) goto L_0x0103
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r13 = r6.mChildren
            java.lang.Object r13 = r13.get(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r13.getHorizontalDimensionBehaviour()
            r22 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r7) goto L_0x00bc
            r7 = 1
            goto L_0x00bd
        L_0x00bc:
            r7 = 0
        L_0x00bd:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r13.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x00c7
            r10 = 1
            goto L_0x00c8
        L_0x00c7:
            r10 = 0
        L_0x00c8:
            if (r7 == 0) goto L_0x00d4
            if (r10 == 0) goto L_0x00d4
            float r7 = r13.mDimensionRatio
            int r7 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d4
            r7 = 1
            goto L_0x00d5
        L_0x00d4:
            r7 = 0
        L_0x00d5:
            boolean r10 = r13.isInHorizontalChain()
            if (r10 == 0) goto L_0x00de
            if (r7 == 0) goto L_0x00de
            goto L_0x0101
        L_0x00de:
            boolean r10 = r13.isInVerticalChain()
            if (r10 == 0) goto L_0x00e7
            if (r7 == 0) goto L_0x00e7
            goto L_0x0101
        L_0x00e7:
            boolean r7 = r13 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r7 == 0) goto L_0x00ec
            goto L_0x0101
        L_0x00ec:
            boolean r7 = r13.isInHorizontalChain()
            if (r7 != 0) goto L_0x0101
            boolean r7 = r13.isInVerticalChain()
            if (r7 == 0) goto L_0x00f9
            goto L_0x0101
        L_0x00f9:
            int r11 = r11 + 1
            r12 = r20
            r7 = r22
            r10 = 0
            goto L_0x00a6
        L_0x0101:
            r7 = 0
            goto L_0x0107
        L_0x0103:
            r22 = r7
            r7 = r22
        L_0x0107:
            r10 = 1073741824(0x40000000, float:2.0)
            if (r8 != r10) goto L_0x010d
            if (r9 == r10) goto L_0x010f
        L_0x010d:
            if (r5 == 0) goto L_0x0111
        L_0x010f:
            r11 = 1
            goto L_0x0112
        L_0x0111:
            r11 = 0
        L_0x0112:
            r7 = r7 & r11
            if (r7 == 0) goto L_0x03bf
            int[] r12 = r6.mMaxDimension
            r13 = 0
            r12 = r12[r13]
            int r12 = java.lang.Math.min(r12, r14)
            int[] r13 = r6.mMaxDimension
            r14 = 1
            r13 = r13[r14]
            int r13 = java.lang.Math.min(r13, r15)
            if (r8 != r10) goto L_0x0135
            int r14 = r21.getWidth()
            if (r14 == r12) goto L_0x0135
            r6.setWidth(r12)
            r21.invalidateGraph()
        L_0x0135:
            if (r9 != r10) goto L_0x0143
            int r12 = r21.getHeight()
            if (r12 == r13) goto L_0x0143
            r6.setHeight(r13)
            r21.invalidateGraph()
        L_0x0143:
            if (r8 != r10) goto L_0x0318
            if (r9 != r10) goto L_0x0318
            androidx.constraintlayout.core.widgets.analyzer.DependencyGraph r12 = r6.mDependencyGraph
            r13 = 1
            r5 = r5 & r13
            boolean r13 = r12.mNeedBuildGraph
            if (r13 != 0) goto L_0x0156
            boolean r13 = r12.mNeedRedoMeasures
            if (r13 == 0) goto L_0x0154
            goto L_0x0156
        L_0x0154:
            r15 = 0
            goto L_0x0193
        L_0x0156:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13 = r12.container
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r13 = r13.mChildren
            java.util.Iterator r13 = r13.iterator()
        L_0x015e:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x017b
            java.lang.Object r14 = r13.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            r14.ensureWidgetRuns()
            r15 = 0
            r14.measured = r15
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r11 = r14.horizontalRun
            r11.reset()
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r11 = r14.verticalRun
            r11.reset()
            goto L_0x015e
        L_0x017b:
            r15 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r12.container
            r11.ensureWidgetRuns()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r12.container
            r11.measured = r15
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r11 = r11.horizontalRun
            r11.reset()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r11 = r11.verticalRun
            r11.reset()
            r12.mNeedRedoMeasures = r15
        L_0x0193:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r12.mContainer
            r12.basicMeasureWidgets(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r12.container
            r11.mX = r15
            r11.mY = r15
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r11.getDimensionBehaviour(r15)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13 = r12.container
            r14 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r13.getDimensionBehaviour(r14)
            boolean r14 = r12.mNeedBuildGraph
            if (r14 == 0) goto L_0x01b0
            r12.buildGraph()
        L_0x01b0:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r14 = r12.container
            int r14 = r14.getX()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r15 = r12.container
            int r15 = r15.getY()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r10 = r10.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.start
            r10.resolve(r14)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r10 = r10.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.start
            r10.resolve(r15)
            r12.measureWidgets()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 == r10) goto L_0x01dd
            if (r13 != r10) goto L_0x01d8
            goto L_0x01dd
        L_0x01d8:
            r19 = r1
            r18 = r7
            goto L_0x0249
        L_0x01dd:
            if (r5 == 0) goto L_0x01f8
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r12.mRuns
            java.util.Iterator r10 = r10.iterator()
        L_0x01e5:
            boolean r18 = r10.hasNext()
            if (r18 == 0) goto L_0x01f8
            java.lang.Object r18 = r10.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r18 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r18
            boolean r18 = r18.supportsWrapComputation()
            if (r18 != 0) goto L_0x01e5
            r5 = 0
        L_0x01f8:
            if (r5 == 0) goto L_0x0221
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r10) goto L_0x0221
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r12.container
            r18 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.setHorizontalDimensionBehaviour(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r12.container
            r19 = r1
            r10 = 0
            int r1 = r12.computeWrap(r7, r10)
            r7.setWidth(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r7 = r1.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r7.dimension
            int r1 = r1.getWidth()
            r7.resolve(r1)
            goto L_0x0225
        L_0x0221:
            r19 = r1
            r18 = r7
        L_0x0225:
            if (r5 == 0) goto L_0x0249
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r13 != r1) goto L_0x0249
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.setVerticalDimensionBehaviour(r5)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            r5 = 1
            int r7 = r12.computeWrap(r1, r5)
            r1.setHeight(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = r1.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.dimension
            int r1 = r1.getHeight()
            r5.resolve(r1)
        L_0x0249:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r5 = 0
            r7 = r1[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r10) goto L_0x025d
            r1 = r1[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r1 != r5) goto L_0x025b
            goto L_0x025d
        L_0x025b:
            r1 = 0
            goto L_0x02a9
        L_0x025d:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            int r1 = r1.getWidth()
            int r1 = r1 + r14
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.end
            r5.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.dimension
            int r1 = r1 - r14
            r5.resolve(r1)
            r12.measureWidgets()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r5 = 1
            r7 = r1[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r10) goto L_0x028b
            r1 = r1[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r1 != r5) goto L_0x02a5
        L_0x028b:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r12.container
            int r1 = r1.getHeight()
            int r1 = r1 + r15
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = r5.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.end
            r5.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = r5.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.dimension
            int r1 = r1 - r15
            r5.resolve(r1)
        L_0x02a5:
            r12.measureWidgets()
            r1 = 1
        L_0x02a9:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r5 = r12.mRuns
            java.util.Iterator r5 = r5.iterator()
        L_0x02af:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x02ca
            java.lang.Object r7 = r5.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r7.widget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r14 = r12.container
            if (r10 != r14) goto L_0x02c6
            boolean r10 = r7.resolved
            if (r10 != 0) goto L_0x02c6
            goto L_0x02af
        L_0x02c6:
            r7.applyToWidget()
            goto L_0x02af
        L_0x02ca:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r5 = r12.mRuns
            java.util.Iterator r5 = r5.iterator()
        L_0x02d0:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0307
            java.lang.Object r7 = r5.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            if (r1 != 0) goto L_0x02e5
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r7.widget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r14 = r12.container
            if (r10 != r14) goto L_0x02e5
            goto L_0x02d0
        L_0x02e5:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r7.start
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x02ec
            goto L_0x0305
        L_0x02ec:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r7.end
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x02f7
            boolean r10 = r7 instanceof androidx.constraintlayout.core.widgets.analyzer.GuidelineReference
            if (r10 != 0) goto L_0x02f7
            goto L_0x0305
        L_0x02f7:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r7.dimension
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x02d0
            boolean r10 = r7 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r10 != 0) goto L_0x02d0
            boolean r7 = r7 instanceof androidx.constraintlayout.core.widgets.analyzer.GuidelineReference
            if (r7 != 0) goto L_0x02d0
        L_0x0305:
            r1 = 0
            goto L_0x0308
        L_0x0307:
            r1 = 1
        L_0x0308:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            r5.setHorizontalDimensionBehaviour(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r12.container
            r5.setVerticalDimensionBehaviour(r13)
            r5 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            r11 = 2
            goto L_0x03af
        L_0x0318:
            r19 = r1
            r18 = r7
            androidx.constraintlayout.core.widgets.analyzer.DependencyGraph r1 = r6.mDependencyGraph
            boolean r7 = r1.mNeedBuildGraph
            if (r7 == 0) goto L_0x0379
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.container
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r7 = r7.mChildren
            java.util.Iterator r7 = r7.iterator()
        L_0x032a:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0353
            java.lang.Object r10 = r7.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r10
            r10.ensureWidgetRuns()
            r11 = 0
            r10.measured = r11
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r12 = r10.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r13 = r12.dimension
            r13.resolved = r11
            r12.resolved = r11
            r12.reset()
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r10 = r10.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r12 = r10.dimension
            r12.resolved = r11
            r10.resolved = r11
            r10.reset()
            goto L_0x032a
        L_0x0353:
            r11 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.container
            r7.ensureWidgetRuns()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.container
            r7.measured = r11
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r7 = r7.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r7.dimension
            r10.resolved = r11
            r7.resolved = r11
            r7.reset()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r7.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r7.dimension
            r10.resolved = r11
            r7.resolved = r11
            r7.reset()
            r1.buildGraph()
            goto L_0x037a
        L_0x0379:
            r11 = 0
        L_0x037a:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.mContainer
            r1.basicMeasureWidgets(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r1.container
            r7.mX = r11
            r7.mY = r11
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r7 = r7.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.start
            r7.resolve(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r1.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.start
            r1.resolve(r11)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r8 != r1) goto L_0x03a1
            boolean r7 = r6.directMeasureWithOrientation(r5, r11)
            r10 = 1
            r7 = r7 & r10
            r11 = 1
            goto L_0x03a4
        L_0x03a1:
            r10 = 1
            r7 = 1
            r11 = 0
        L_0x03a4:
            if (r9 != r1) goto L_0x03ae
            boolean r5 = r6.directMeasureWithOrientation(r5, r10)
            r5 = r5 & r7
            int r11 = r11 + 1
            goto L_0x03af
        L_0x03ae:
            r5 = r7
        L_0x03af:
            if (r5 == 0) goto L_0x03c5
            if (r8 != r1) goto L_0x03b5
            r7 = 1
            goto L_0x03b6
        L_0x03b5:
            r7 = 0
        L_0x03b6:
            if (r9 != r1) goto L_0x03ba
            r1 = 1
            goto L_0x03bb
        L_0x03ba:
            r1 = 0
        L_0x03bb:
            r6.updateFromRuns(r7, r1)
            goto L_0x03c5
        L_0x03bf:
            r19 = r1
            r18 = r7
            r5 = 0
            r11 = 0
        L_0x03c5:
            if (r5 == 0) goto L_0x03ca
            r1 = 2
            if (r11 == r1) goto L_0x0651
        L_0x03ca:
            int r1 = r6.mOptimizationLevel
            if (r2 <= 0) goto L_0x04af
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r6.mChildren
            int r5 = r5.size()
            r7 = 64
            boolean r7 = r6.optimizeFor(r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r6.mMeasurer
            r13 = 0
        L_0x03dd:
            if (r13 >= r5) goto L_0x0471
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r6.mChildren
            java.lang.Object r9 = r9.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 == 0) goto L_0x03ed
            goto L_0x046d
        L_0x03ed:
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 == 0) goto L_0x03f3
            goto L_0x046d
        L_0x03f3:
            boolean r10 = r9.mInVirtualLayout
            if (r10 == 0) goto L_0x03f9
            goto L_0x046d
        L_0x03f9:
            if (r7 == 0) goto L_0x0410
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r10 = r9.horizontalRun
            if (r10 == 0) goto L_0x0410
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r11 = r9.verticalRun
            if (r11 == 0) goto L_0x0410
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r10.dimension
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x0410
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r11.dimension
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x0410
            goto L_0x046d
        L_0x0410:
            r10 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.getDimensionBehaviour(r10)
            r10 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r9.getDimensionBehaviour(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r14) goto L_0x042a
            int r15 = r9.mMatchConstraintDefaultWidth
            if (r15 == r10) goto L_0x042a
            if (r12 != r14) goto L_0x042a
            int r14 = r9.mMatchConstraintDefaultHeight
            if (r14 == r10) goto L_0x042a
            r14 = 1
            goto L_0x042b
        L_0x042a:
            r14 = 0
        L_0x042b:
            if (r14 != 0) goto L_0x0466
            boolean r15 = r6.optimizeFor(r10)
            if (r15 == 0) goto L_0x0466
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x0466
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r10) goto L_0x0448
            int r15 = r9.mMatchConstraintDefaultWidth
            if (r15 != 0) goto L_0x0448
            if (r12 == r10) goto L_0x0448
            boolean r10 = r9.isInHorizontalChain()
            if (r10 != 0) goto L_0x0448
            r14 = 1
        L_0x0448:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r10) goto L_0x0459
            int r15 = r9.mMatchConstraintDefaultHeight
            if (r15 != 0) goto L_0x0459
            if (r11 == r10) goto L_0x0459
            boolean r10 = r9.isInHorizontalChain()
            if (r10 != 0) goto L_0x0459
            r14 = 1
        L_0x0459:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 == r10) goto L_0x045f
            if (r12 != r10) goto L_0x0466
        L_0x045f:
            float r10 = r9.mDimensionRatio
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x0466
            r14 = 1
        L_0x0466:
            if (r14 == 0) goto L_0x0469
            goto L_0x046d
        L_0x0469:
            r10 = 0
            r0.measure(r8, r9, r10)
        L_0x046d:
            int r13 = r13 + 1
            goto L_0x03dd
        L_0x0471:
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r8 = (androidx.constraintlayout.widget.ConstraintLayout.Measurer) r8
            androidx.constraintlayout.widget.ConstraintLayout r5 = r8.layout
            int r5 = r5.getChildCount()
            r13 = 0
        L_0x047a:
            if (r13 >= r5) goto L_0x048e
            androidx.constraintlayout.widget.ConstraintLayout r7 = r8.layout
            android.view.View r7 = r7.getChildAt(r13)
            boolean r9 = r7 instanceof androidx.constraintlayout.widget.Placeholder
            if (r9 == 0) goto L_0x048b
            androidx.constraintlayout.widget.Placeholder r7 = (androidx.constraintlayout.widget.Placeholder) r7
            r7.updatePostMeasure()
        L_0x048b:
            int r13 = r13 + 1
            goto L_0x047a
        L_0x048e:
            androidx.constraintlayout.widget.ConstraintLayout r5 = r8.layout
            java.util.ArrayList r5 = r5.mConstraintHelpers
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x04af
            r13 = 0
        L_0x049b:
            if (r13 >= r5) goto L_0x04af
            androidx.constraintlayout.widget.ConstraintLayout r7 = r8.layout
            java.util.ArrayList r7 = r7.mConstraintHelpers
            java.lang.Object r7 = r7.get(r13)
            androidx.constraintlayout.widget.ConstraintHelper r7 = (androidx.constraintlayout.widget.ConstraintHelper) r7
            r7.updatePostMeasure()
            int r13 = r13 + 1
            goto L_0x049b
        L_0x04af:
            r0.updateHierarchy(r6)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r0.mVariableDimensionsWidgets
            int r5 = r5.size()
            r13 = 0
            if (r2 <= 0) goto L_0x04be
            r0.solveLinearSystem(r6, r13, r3, r4)
        L_0x04be:
            if (r5 <= 0) goto L_0x064d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r7) goto L_0x04ca
            r2 = 1
            goto L_0x04cb
        L_0x04ca:
            r2 = 0
        L_0x04cb:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r21.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r8) goto L_0x04d5
            r7 = 1
            goto L_0x04d6
        L_0x04d5:
            r7 = 0
        L_0x04d6:
            int r8 = r21.getWidth()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9 = r0.constraintWidgetContainer
            int r9 = r9.mMinWidth
            int r8 = java.lang.Math.max(r8, r9)
            int r9 = r21.getHeight()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r0.constraintWidgetContainer
            int r10 = r10.mMinHeight
            int r9 = java.lang.Math.max(r9, r10)
            r10 = 0
            r11 = 0
        L_0x04f0:
            if (r10 >= r5) goto L_0x0575
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r12 = r0.mVariableDimensionsWidgets
            java.lang.Object r12 = r12.get(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r12
            boolean r14 = r12 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r14 != 0) goto L_0x0503
            r16 = r1
            r13 = r19
            goto L_0x056c
        L_0x0503:
            int r14 = r12.getWidth()
            int r15 = r12.getHeight()
            r16 = r1
            r13 = r19
            r1 = 1
            boolean r17 = r0.measure(r13, r12, r1)
            r1 = r11 | r17
            int r11 = r12.getWidth()
            r23 = r1
            int r1 = r12.getHeight()
            if (r11 == r14) goto L_0x0542
            r12.setWidth(r11)
            if (r2 == 0) goto L_0x0540
            int r11 = r12.getRight()
            if (r11 <= r8) goto L_0x0540
            int r11 = r12.getRight()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.getAnchor(r14)
            int r14 = r14.getMargin()
            int r14 = r14 + r11
            int r8 = java.lang.Math.max(r8, r14)
        L_0x0540:
            r14 = 1
            goto L_0x0544
        L_0x0542:
            r14 = r23
        L_0x0544:
            if (r1 == r15) goto L_0x0566
            r12.setHeight(r1)
            if (r7 == 0) goto L_0x0565
            int r1 = r12.getBottom()
            if (r1 <= r9) goto L_0x0565
            int r1 = r12.getBottom()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.getAnchor(r11)
            int r11 = r11.getMargin()
            int r11 = r11 + r1
            int r1 = java.lang.Math.max(r9, r11)
            r9 = r1
        L_0x0565:
            r14 = 1
        L_0x0566:
            androidx.constraintlayout.core.widgets.VirtualLayout r12 = (androidx.constraintlayout.core.widgets.VirtualLayout) r12
            boolean r1 = r12.mNeedsCallFromSolver
            r1 = r1 | r14
            r11 = r1
        L_0x056c:
            int r10 = r10 + 1
            r19 = r13
            r1 = r16
            r13 = 0
            goto L_0x04f0
        L_0x0575:
            r16 = r1
            r13 = r19
            r1 = 0
            r10 = 2
        L_0x057b:
            if (r1 >= r10) goto L_0x064a
            r14 = r11
            r11 = 0
        L_0x057f:
            if (r11 >= r5) goto L_0x0633
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r12 = r0.mVariableDimensionsWidgets
            java.lang.Object r12 = r12.get(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r12
            boolean r15 = r12 instanceof androidx.constraintlayout.core.widgets.Helper
            if (r15 == 0) goto L_0x0591
            boolean r15 = r12 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r15 == 0) goto L_0x05b4
        L_0x0591:
            boolean r15 = r12 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r15 == 0) goto L_0x0596
            goto L_0x05b4
        L_0x0596:
            int r15 = r12.mVisibility
            r10 = 8
            if (r15 != r10) goto L_0x059d
            goto L_0x05b4
        L_0x059d:
            if (r18 == 0) goto L_0x05b0
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r10 = r12.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r10.dimension
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x05b0
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r10 = r12.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r10.dimension
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x05b0
            goto L_0x05b4
        L_0x05b0:
            boolean r10 = r12 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 == 0) goto L_0x05bb
        L_0x05b4:
            r17 = r3
            r23 = r5
            r19 = r13
            goto L_0x0628
        L_0x05bb:
            int r10 = r12.getWidth()
            int r15 = r12.getHeight()
            r23 = r5
            int r5 = r12.mBaselineDistance
            r17 = r3
            r3 = 1
            if (r1 != r3) goto L_0x05cd
            r3 = 2
        L_0x05cd:
            boolean r3 = r0.measure(r13, r12, r3)
            r14 = r14 | r3
            int r3 = r12.getWidth()
            r19 = r13
            int r13 = r12.getHeight()
            if (r3 == r10) goto L_0x05fd
            r12.setWidth(r3)
            if (r2 == 0) goto L_0x05fc
            int r3 = r12.getRight()
            if (r3 <= r8) goto L_0x05fc
            int r3 = r12.getRight()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r12.getAnchor(r10)
            int r10 = r10.getMargin()
            int r10 = r10 + r3
            int r8 = java.lang.Math.max(r8, r10)
        L_0x05fc:
            r14 = 1
        L_0x05fd:
            if (r13 == r15) goto L_0x061f
            r12.setHeight(r13)
            if (r7 == 0) goto L_0x061e
            int r3 = r12.getBottom()
            if (r3 <= r9) goto L_0x061e
            int r3 = r12.getBottom()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r12.getAnchor(r10)
            int r10 = r10.getMargin()
            int r10 = r10 + r3
            int r3 = java.lang.Math.max(r9, r10)
            r9 = r3
        L_0x061e:
            r14 = 1
        L_0x061f:
            boolean r3 = r12.hasBaseline
            if (r3 == 0) goto L_0x0628
            int r3 = r12.mBaselineDistance
            if (r5 == r3) goto L_0x0628
            r14 = 1
        L_0x0628:
            int r11 = r11 + 1
            r5 = r23
            r3 = r17
            r13 = r19
            r10 = 2
            goto L_0x057f
        L_0x0633:
            r17 = r3
            r23 = r5
            r19 = r13
            if (r14 == 0) goto L_0x064a
            int r1 = r1 + 1
            r3 = r17
            r0.solveLinearSystem(r6, r1, r3, r4)
            r5 = r23
            r13 = r19
            r10 = 2
            r11 = 0
            goto L_0x057b
        L_0x064a:
            r0 = r16
            goto L_0x064e
        L_0x064d:
            r0 = r1
        L_0x064e:
            r6.setOptimizationLevel(r0)
        L_0x0651:
            return
        L_0x0652:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int):void");
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mOptimizationLevel = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(512);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4) {
        DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int i6 = measurer.paddingWidth;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i != Integer.MIN_VALUE) {
            if (i == 0) {
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i2 = Math.max(0, this.mMinWidth);
                }
            } else if (i != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i2 = Math.min(this.mMaxWidth - i6, i2);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i2 = 0;
        } else {
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.mMinWidth);
            }
        }
        if (i3 != Integer.MIN_VALUE) {
            if (i3 == 0) {
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i4 = Math.max(0, this.mMinHeight);
                }
            } else if (i3 == 1073741824) {
                i4 = Math.min(this.mMaxHeight - i5, i4);
            }
            i4 = 0;
        } else {
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i2 == constraintWidgetContainer.getWidth() && i4 == constraintWidgetContainer.getHeight())) {
            constraintWidgetContainer.mDependencyGraph.mNeedRedoMeasures = true;
        }
        constraintWidgetContainer.mX = 0;
        constraintWidgetContainer.mY = 0;
        int[] iArr = constraintWidgetContainer.mMaxDimension;
        iArr[0] = this.mMaxWidth - i6;
        iArr[1] = this.mMaxHeight - i5;
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i4);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i6);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i5);
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, (float) i2, (float) i3);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }
}
