package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;

public class ConstraintWidget {
    public boolean OPTIMIZE_WRAP = false;
    public boolean OPTIMIZE_WRAP_ON_RESOLVED = true;
    public boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun = null;
    public boolean horizontalSolvingPass;
    public boolean inPlaceholder;
    public boolean[] isTerminalWidget = {true, true};
    public ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public ConstraintAnchor mBottom;
    public boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    public ConstraintAnchor mCenterX;
    public ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    public Object mCompanionWidget;
    public int mContainerItemSkip;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mDistToBottom;
    public int mDistToLeft;
    public int mDistToRight;
    public int mDistToTop;
    public int mHeight;
    public int mHeightOverride = -1;
    public float mHorizontalBiasPercent;
    public boolean mHorizontalChainFixedPosition;
    public int mHorizontalChainStyle;
    public ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public boolean mHorizontalWrapVisited;
    public boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    public boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public int mLastHorizontalMeasureSpec;
    public int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    public boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    public int[] mMaxDimension;
    public boolean mMeasureRequested = true;
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public int mOffsetX;
    public int mOffsetY;
    public ConstraintWidget mParent;
    public int mRelX;
    public int mRelY;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    public boolean mTopHasCentered;
    public String mType;
    public float mVerticalBiasPercent;
    public boolean mVerticalChainFixedPosition;
    public int mVerticalChainStyle;
    public ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public boolean mVerticalWrapVisited;
    public int mVisibility;
    public float[] mWeight;
    public int mWidth;
    public int mWidthOverride = -1;
    public int mWrapBehaviorInParent;
    public int mX;
    public int mY;
    public boolean measured = false;
    public boolean resolvedHorizontal;
    public boolean resolvedVertical;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun = null;
    public boolean verticalSolvingPass;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        new HashMap();
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, Type.LEFT);
        this.mTop = new ConstraintAnchor(this, Type.TOP);
        this.mRight = new ConstraintAnchor(this, Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.mAnchors = arrayList;
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        arrayList.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (hashSet.contains(this)) {
                Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> hashSet2 = this.mLeft.mDependents;
            if (hashSet2 != null) {
                Iterator<ConstraintAnchor> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet3 = this.mRight.mDependents;
            if (hashSet3 != null) {
                Iterator<ConstraintAnchor> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
        } else {
            HashSet<ConstraintAnchor> hashSet4 = this.mTop.mDependents;
            if (hashSet4 != null) {
                Iterator<ConstraintAnchor> it3 = hashSet4.iterator();
                while (it3.hasNext()) {
                    it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet5 = this.mBottom.mDependents;
            if (hashSet5 != null) {
                Iterator<ConstraintAnchor> it4 = hashSet5.iterator();
                while (it4.hasNext()) {
                    it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet6 = this.mBaseline.mDependents;
            if (hashSet6 != null) {
                Iterator<ConstraintAnchor> it5 = hashSet6.iterator();
                while (it5.hasNext()) {
                    it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:247:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x054a  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0643  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x066e  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0678  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r51, boolean r52) {
        /*
            r50 = this;
            r15 = r50
            r14 = r51
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mLeft
            androidx.constraintlayout.core.SolverVariable r13 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mRight
            androidx.constraintlayout.core.SolverVariable r12 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mTop
            androidx.constraintlayout.core.SolverVariable r11 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBottom
            androidx.constraintlayout.core.SolverVariable r10 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.SolverVariable r9 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.mParent
            if (r2 == 0) goto L_0x0045
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0045
            r2 = 1
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            int r3 = r15.mWrapBehaviorInParent
            if (r3 == r7) goto L_0x0056
            if (r3 == r8) goto L_0x0053
            if (r3 == r1) goto L_0x005b
            r29 = r0
            r28 = r2
            goto L_0x005f
        L_0x0053:
            r28 = r2
            goto L_0x005d
        L_0x0056:
            r29 = r0
            r28 = 0
            goto L_0x005f
        L_0x005b:
            r28 = 0
        L_0x005d:
            r29 = 0
        L_0x005f:
            int r0 = r15.mVisibility
            r5 = 8
            if (r0 != r5) goto L_0x008f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r15.mAnchors
            int r0 = r0.size()
            r2 = 0
        L_0x006c:
            if (r2 >= r0) goto L_0x0081
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r15.mAnchors
            java.lang.Object r3 = r3.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            boolean r3 = r3.hasDependents()
            if (r3 == 0) goto L_0x007e
            r0 = 1
            goto L_0x0082
        L_0x007e:
            int r2 = r2 + 1
            goto L_0x006c
        L_0x0081:
            r0 = 0
        L_0x0082:
            if (r0 != 0) goto L_0x008f
            boolean[] r0 = r15.mIsInBarrier
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x008f
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x008f
            return
        L_0x008f:
            boolean r0 = r15.resolvedHorizontal
            r4 = 5
            if (r0 != 0) goto L_0x0098
            boolean r0 = r15.resolvedVertical
            if (r0 == 0) goto L_0x0117
        L_0x0098:
            boolean r0 = r15.resolvedHorizontal
            if (r0 == 0) goto L_0x00c9
            int r0 = r15.mX
            r14.addEquality(r13, r0)
            int r0 = r15.mX
            int r2 = r15.mWidth
            int r0 = r0 + r2
            r14.addEquality(r12, r0)
            if (r29 == 0) goto L_0x00c9
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x00c9
            boolean r2 = r15.OPTIMIZE_WRAP_ON_RESOLVED
            if (r2 == 0) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mLeft
            r0.addHorizontalWrapMinVariable(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mRight
            r0.addHorizontalWrapMaxVariable(r2)
            goto L_0x00c9
        L_0x00c0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r12, r6, r4)
        L_0x00c9:
            boolean r0 = r15.resolvedVertical
            if (r0 == 0) goto L_0x010a
            int r0 = r15.mY
            r14.addEquality(r11, r0)
            int r0 = r15.mY
            int r2 = r15.mHeight
            int r0 = r0 + r2
            r14.addEquality(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            boolean r0 = r0.hasDependents()
            if (r0 == 0) goto L_0x00ea
            int r0 = r15.mY
            int r2 = r15.mBaselineDistance
            int r0 = r0 + r2
            r14.addEquality(r9, r0)
        L_0x00ea:
            if (r28 == 0) goto L_0x010a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x010a
            boolean r2 = r15.OPTIMIZE_WRAP_ON_RESOLVED
            if (r2 == 0) goto L_0x0101
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mTop
            r0.addVerticalWrapMinVariable(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.mBottom
            r0.addVerticalWrapMaxVariable(r2)
            goto L_0x010a
        L_0x0101:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r10, r6, r4)
        L_0x010a:
            boolean r0 = r15.resolvedHorizontal
            if (r0 == 0) goto L_0x0117
            boolean r0 = r15.resolvedVertical
            if (r0 == 0) goto L_0x0117
            r15.resolvedHorizontal = r6
            r15.resolvedVertical = r6
            return
        L_0x0117:
            if (r52 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            if (r0 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r15.verticalRun
            if (r2 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r0.start
            boolean r4 = r3.resolved
            if (r4 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r2.start
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r2.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x019d
            int r0 = r3.value
            r14.addEquality(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r14.addEquality(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r14.addEquality(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r14.addEquality(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r14.addEquality(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0198
            if (r29 == 0) goto L_0x017f
            boolean[] r0 = r15.isTerminalWidget
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x017f
            boolean r0 = r50.isInHorizontalChain()
            if (r0 != 0) goto L_0x017f
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r12, r6, r5)
        L_0x017f:
            if (r28 == 0) goto L_0x0198
            boolean[] r0 = r15.isTerminalWidget
            boolean r0 = r0[r7]
            if (r0 == 0) goto L_0x0198
            boolean r0 = r50.isInVerticalChain()
            if (r0 != 0) goto L_0x0198
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r14.addGreaterThan(r0, r10, r6, r5)
        L_0x0198:
            r15.resolvedHorizontal = r6
            r15.resolvedVertical = r6
            return
        L_0x019d:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x020e
            boolean r0 = r15.isChainHead(r6)
            if (r0 == 0) goto L_0x01b0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            r0.addChain(r15, r6)
            r0 = 1
            goto L_0x01b4
        L_0x01b0:
            boolean r0 = r50.isInHorizontalChain()
        L_0x01b4:
            boolean r2 = r15.isChainHead(r7)
            if (r2 == 0) goto L_0x01c3
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            r2.addChain(r15, r7)
            r2 = 1
            goto L_0x01c7
        L_0x01c3:
            boolean r2 = r50.isInVerticalChain()
        L_0x01c7:
            if (r0 != 0) goto L_0x01e6
            if (r29 == 0) goto L_0x01e6
            int r3 = r15.mVisibility
            if (r3 == r5) goto L_0x01e6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x01e6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x01e6
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mRight
            androidx.constraintlayout.core.SolverVariable r3 = r14.createObjectVariable(r3)
            r14.addGreaterThan(r3, r12, r6, r7)
        L_0x01e6:
            if (r2 != 0) goto L_0x0209
            if (r28 == 0) goto L_0x0209
            int r3 = r15.mVisibility
            if (r3 == r5) goto L_0x0209
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0209
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0209
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBaseline
            if (r3 != 0) goto L_0x0209
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mBottom
            androidx.constraintlayout.core.SolverVariable r3 = r14.createObjectVariable(r3)
            r14.addGreaterThan(r3, r10, r6, r7)
        L_0x0209:
            r31 = r0
            r30 = r2
            goto L_0x0212
        L_0x020e:
            r30 = 0
            r31 = 0
        L_0x0212:
            int r0 = r15.mWidth
            int r2 = r15.mMinWidth
            if (r0 >= r2) goto L_0x0219
            r0 = r2
        L_0x0219:
            int r2 = r15.mHeight
            int r3 = r15.mMinHeight
            if (r2 >= r3) goto L_0x0220
            r2 = r3
        L_0x0220:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r3 = r3[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x022a
            r3 = 1
            goto L_0x022b
        L_0x022a:
            r3 = 0
        L_0x022b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r15.mListDimensionBehaviors
            r4 = r4[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 == r8) goto L_0x0235
            r4 = 1
            goto L_0x0236
        L_0x0235:
            r4 = 0
        L_0x0236:
            int r8 = r15.mDimensionRatioSide
            r15.mResolvedDimensionRatioSide = r8
            float r8 = r15.mDimensionRatio
            r15.mResolvedDimensionRatio = r8
            int r1 = r15.mMatchConstraintDefaultWidth
            int r7 = r15.mMatchConstraintDefaultHeight
            r20 = 0
            r21 = 4
            int r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r8 <= 0) goto L_0x039f
            int r8 = r15.mVisibility
            if (r8 == r5) goto L_0x039f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r15.mListDimensionBehaviors
            r20 = 0
            r8 = r8[r20]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r5) goto L_0x025b
            if (r1 != 0) goto L_0x025b
            r1 = 3
        L_0x025b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r8 = 1
            r5 = r5[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r8) goto L_0x0267
            if (r7 != 0) goto L_0x0267
            r7 = 3
        L_0x0267:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r8 = 0
            r6 = r5[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r24 = 1065353216(0x3f800000, float:1.0)
            if (r6 != r8) goto L_0x033f
            r6 = 1
            r5 = r5[r6]
            if (r5 != r8) goto L_0x033f
            r5 = 3
            if (r1 != r5) goto L_0x033f
            if (r7 != r5) goto L_0x033f
            int r5 = r15.mResolvedDimensionRatioSide
            r6 = -1
            if (r5 != r6) goto L_0x029a
            if (r3 == 0) goto L_0x0289
            if (r4 != 0) goto L_0x0289
            r5 = 0
            r15.mResolvedDimensionRatioSide = r5
            goto L_0x029a
        L_0x0289:
            if (r3 != 0) goto L_0x029a
            if (r4 == 0) goto L_0x029a
            r3 = 1
            r15.mResolvedDimensionRatioSide = r3
            int r3 = r15.mDimensionRatioSide
            if (r3 != r6) goto L_0x029a
            float r3 = r15.mResolvedDimensionRatio
            float r3 = r24 / r3
            r15.mResolvedDimensionRatio = r3
        L_0x029a:
            int r3 = r15.mResolvedDimensionRatioSide
            if (r3 != 0) goto L_0x02b2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mTop
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02ae
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            boolean r3 = r3.isConnected()
            if (r3 != 0) goto L_0x02b2
        L_0x02ae:
            r3 = 1
            r15.mResolvedDimensionRatioSide = r3
            goto L_0x02ca
        L_0x02b2:
            r3 = 1
            int r4 = r15.mResolvedDimensionRatioSide
            if (r4 != r3) goto L_0x02ca
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mLeft
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02c7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mRight
            boolean r3 = r3.isConnected()
            if (r3 != 0) goto L_0x02ca
        L_0x02c7:
            r3 = 0
            r15.mResolvedDimensionRatioSide = r3
        L_0x02ca:
            int r3 = r15.mResolvedDimensionRatioSide
            r4 = -1
            if (r3 != r4) goto L_0x031c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mTop
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02ef
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02ef
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mLeft
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x02ef
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mRight
            boolean r3 = r3.isConnected()
            if (r3 != 0) goto L_0x031c
        L_0x02ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mTop
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x0303
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x0303
            r3 = 0
            r15.mResolvedDimensionRatioSide = r3
            goto L_0x031c
        L_0x0303:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mLeft
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x031c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mRight
            boolean r3 = r3.isConnected()
            if (r3 == 0) goto L_0x031c
            float r3 = r15.mResolvedDimensionRatio
            float r3 = r24 / r3
            r15.mResolvedDimensionRatio = r3
            r3 = 1
            r15.mResolvedDimensionRatioSide = r3
        L_0x031c:
            int r3 = r15.mResolvedDimensionRatioSide
            r4 = -1
            if (r3 != r4) goto L_0x0396
            int r3 = r15.mMatchConstraintMinWidth
            if (r3 <= 0) goto L_0x032d
            int r3 = r15.mMatchConstraintMinHeight
            if (r3 != 0) goto L_0x032d
            r3 = 0
            r15.mResolvedDimensionRatioSide = r3
            goto L_0x0396
        L_0x032d:
            int r3 = r15.mMatchConstraintMinWidth
            if (r3 != 0) goto L_0x0396
            int r3 = r15.mMatchConstraintMinHeight
            if (r3 <= 0) goto L_0x0396
            float r3 = r15.mResolvedDimensionRatio
            float r3 = r24 / r3
            r15.mResolvedDimensionRatio = r3
            r3 = 1
            r15.mResolvedDimensionRatioSide = r3
            goto L_0x0396
        L_0x033f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r4 = 0
            r5 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0363
            r5 = 3
            if (r1 != r5) goto L_0x0363
            r15.mResolvedDimensionRatioSide = r4
            float r0 = r15.mResolvedDimensionRatio
            int r4 = r15.mHeight
            float r4 = (float) r4
            float r0 = r0 * r4
            int r0 = (int) r0
            r4 = 1
            r3 = r3[r4]
            if (r3 == r6) goto L_0x0396
            r32 = r2
            r34 = r7
            r33 = 0
            r35 = 4
            goto L_0x03a7
        L_0x0363:
            r4 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0396
            r3 = 3
            if (r7 != r3) goto L_0x0396
            r15.mResolvedDimensionRatioSide = r4
            int r2 = r15.mDimensionRatioSide
            r3 = -1
            if (r2 != r3) goto L_0x037c
            float r2 = r15.mResolvedDimensionRatio
            float r2 = r24 / r2
            r15.mResolvedDimensionRatio = r2
        L_0x037c:
            float r2 = r15.mResolvedDimensionRatio
            int r3 = r15.mWidth
            float r3 = (float) r3
            float r2 = r2 * r3
            int r2 = (int) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r4 = 0
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x0396
            r35 = r1
            r32 = r2
            r33 = 0
            r34 = 4
            goto L_0x03a7
        L_0x0396:
            r35 = r1
            r32 = r2
            r34 = r7
            r33 = 1
            goto L_0x03a7
        L_0x039f:
            r35 = r1
            r32 = r2
            r34 = r7
            r33 = 0
        L_0x03a7:
            int[] r1 = r15.mResolvedMatchConstraintDefault
            r2 = 0
            r1[r2] = r35
            r2 = 1
            r1[r2] = r34
            if (r33 == 0) goto L_0x03bb
            int r1 = r15.mResolvedDimensionRatioSide
            r2 = -1
            if (r1 == 0) goto L_0x03b8
            if (r1 != r2) goto L_0x03bc
        L_0x03b8:
            r18 = 1
            goto L_0x03be
        L_0x03bb:
            r2 = -1
        L_0x03bc:
            r18 = 0
        L_0x03be:
            if (r33 == 0) goto L_0x03ca
            int r1 = r15.mResolvedDimensionRatioSide
            r3 = 1
            if (r1 == r3) goto L_0x03c7
            if (r1 != r2) goto L_0x03ca
        L_0x03c7:
            r36 = 1
            goto L_0x03cc
        L_0x03ca:
            r36 = 0
        L_0x03cc:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x03dc
            boolean r1 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r1 == 0) goto L_0x03dc
            r21 = 1
            goto L_0x03de
        L_0x03dc:
            r21 = 0
        L_0x03de:
            if (r21 == 0) goto L_0x03e3
            r23 = 0
            goto L_0x03e5
        L_0x03e3:
            r23 = r0
        L_0x03e5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mCenter
            boolean r0 = r0.isConnected()
            r1 = 1
            r37 = r0 ^ 1
            boolean[] r0 = r15.mIsInBarrier
            r2 = 0
            boolean r27 = r0[r2]
            boolean r38 = r0[r1]
            int r0 = r15.mHorizontalResolution
            r39 = 0
            r8 = 2
            if (r0 == r8) goto L_0x04da
            boolean r0 = r15.resolvedHorizontal
            if (r0 != 0) goto L_0x04da
            if (r52 == 0) goto L_0x0445
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            if (r0 == 0) goto L_0x0445
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x0445
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x0413
            goto L_0x0445
        L_0x0413:
            if (r52 == 0) goto L_0x04da
            int r0 = r1.value
            r14.addEquality(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r14.addEquality(r12, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x04da
            if (r29 == 0) goto L_0x04da
            boolean[] r0 = r15.isTerminalWidget
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x04da
            boolean r0 = r50.isInHorizontalChain()
            if (r0 != 0) goto L_0x04da
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r5 = 8
            r14.addGreaterThan(r0, r12, r1, r5)
            goto L_0x04da
        L_0x0445:
            r5 = 8
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0453
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r7 = r0
            goto L_0x0455
        L_0x0453:
            r7 = r39
        L_0x0455:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0461
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mLeft
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r6 = r0
            goto L_0x0463
        L_0x0461:
            r6 = r39
        L_0x0463:
            boolean[] r0 = r15.isTerminalWidget
            r17 = 0
            boolean r20 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r22 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mRight
            int r1 = r15.mX
            int r2 = r15.mMinWidth
            int[] r5 = r15.mMaxDimension
            r42 = r5[r17]
            float r5 = r15.mHorizontalBiasPercent
            r19 = 1
            r0 = r0[r19]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r8) goto L_0x0486
            r44 = 1
            goto L_0x0488
        L_0x0486:
            r44 = 0
        L_0x0488:
            int r0 = r15.mMatchConstraintMinWidth
            r24 = r0
            int r0 = r15.mMatchConstraintMaxWidth
            r25 = r0
            float r0 = r15.mMatchConstraintPercentWidth
            r26 = r0
            r0 = r50
            r45 = r1
            r1 = r51
            r40 = r2
            r2 = 1
            r46 = r3
            r3 = r29
            r16 = r4
            r8 = 5
            r4 = r28
            r41 = r5
            r5 = r20
            r8 = r22
            r47 = r9
            r9 = r21
            r48 = r10
            r10 = r16
            r49 = r11
            r11 = r46
            r43 = r12
            r12 = r45
            r45 = r13
            r13 = r23
            r14 = r40
            r15 = r42
            r16 = r41
            r17 = r18
            r18 = r44
            r19 = r31
            r20 = r30
            r21 = r27
            r22 = r35
            r23 = r34
            r27 = r37
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x04e4
        L_0x04da:
            r47 = r9
            r48 = r10
            r49 = r11
            r43 = r12
            r45 = r13
        L_0x04e4:
            if (r52 == 0) goto L_0x054a
            r15 = r50
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            if (r0 == 0) goto L_0x053d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x053d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x053d
            int r0 = r1.value
            r14 = r51
            r13 = r49
            r14.addEquality(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r12 = r48
            r14.addEquality(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r1 = r47
            r14.addEquality(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0537
            if (r30 != 0) goto L_0x0537
            if (r28 == 0) goto L_0x0537
            boolean[] r2 = r15.isTerminalWidget
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0533
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r2 = 8
            r10 = 0
            r14.addGreaterThan(r0, r12, r10, r2)
            goto L_0x053b
        L_0x0533:
            r2 = 8
            r10 = 0
            goto L_0x053b
        L_0x0537:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x053b:
            r7 = 0
            goto L_0x0559
        L_0x053d:
            r14 = r51
            r1 = r47
            r12 = r48
            r13 = r49
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x0558
        L_0x054a:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r50
            r14 = r51
            r1 = r47
            r12 = r48
            r13 = r49
        L_0x0558:
            r7 = 1
        L_0x0559:
            int r0 = r15.mVerticalResolution
            r3 = 2
            if (r0 != r3) goto L_0x0560
            r6 = 0
            goto L_0x0561
        L_0x0560:
            r6 = r7
        L_0x0561:
            if (r6 == 0) goto L_0x063d
            boolean r0 = r15.resolvedVertical
            if (r0 != 0) goto L_0x063d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r0 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0575
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0575
            r9 = 1
            goto L_0x0576
        L_0x0575:
            r9 = 0
        L_0x0576:
            if (r9 == 0) goto L_0x057a
            r32 = 0
        L_0x057a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0586
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r7 = r0
            goto L_0x0588
        L_0x0586:
            r7 = r39
        L_0x0588:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x0594
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTop
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r6 = r0
            goto L_0x0596
        L_0x0594:
            r6 = r39
        L_0x0596:
            int r0 = r15.mBaselineDistance
            if (r0 > 0) goto L_0x059e
            int r0 = r15.mVisibility
            if (r0 != r2) goto L_0x05da
        L_0x059e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x05c9
            int r0 = r15.mBaselineDistance
            r14.addEquality(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBaseline
            int r3 = r3.getMargin()
            r14.addEquality(r1, r0, r3, r2)
            if (r28 == 0) goto L_0x05c6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.mBottom
            androidx.constraintlayout.core.SolverVariable r0 = r14.createObjectVariable(r0)
            r1 = 5
            r14.addGreaterThan(r7, r0, r10, r1)
        L_0x05c6:
            r27 = 0
            goto L_0x05dc
        L_0x05c9:
            int r3 = r15.mVisibility
            if (r3 != r2) goto L_0x05d5
            int r0 = r0.getMargin()
            r14.addEquality(r1, r13, r0, r2)
            goto L_0x05da
        L_0x05d5:
            int r0 = r15.mBaselineDistance
            r14.addEquality(r1, r13, r0, r2)
        L_0x05da:
            r27 = r37
        L_0x05dc:
            boolean[] r0 = r15.isTerminalWidget
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.mBottom
            int r1 = r15.mY
            int r2 = r15.mMinHeight
            int[] r10 = r15.mMaxDimension
            r16 = r10[r11]
            float r10 = r15.mVerticalBiasPercent
            r17 = 0
            r0 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r11) goto L_0x05fd
            r18 = 1
            goto L_0x05ff
        L_0x05fd:
            r18 = 0
        L_0x05ff:
            int r0 = r15.mMatchConstraintMinHeight
            r24 = r0
            int r0 = r15.mMatchConstraintMaxHeight
            r25 = r0
            float r0 = r15.mMatchConstraintPercentHeight
            r26 = r0
            r0 = r50
            r19 = r1
            r1 = r51
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r28
            r21 = r4
            r4 = r29
            r17 = r10
            r10 = r21
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r32
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r36
            r19 = r30
            r20 = r31
            r21 = r38
            r22 = r34
            r23 = r35
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0641
        L_0x063d:
            r28 = r12
            r29 = r13
        L_0x0641:
            if (r33 == 0) goto L_0x066e
            r6 = 8
            r7 = r50
            int r0 = r7.mResolvedDimensionRatioSide
            r1 = 1
            if (r0 != r1) goto L_0x065c
            float r5 = r7.mResolvedDimensionRatio
            r0 = r51
            r1 = r28
            r2 = r29
            r3 = r43
            r4 = r45
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0670
        L_0x065c:
            float r5 = r7.mResolvedDimensionRatio
            r6 = 8
            r0 = r51
            r1 = r43
            r2 = r45
            r3 = r28
            r4 = r29
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0670
        L_0x066e:
            r7 = r50
        L_0x0670:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0710
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.mOwner
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            r4 = r51
            androidx.constraintlayout.core.SolverVariable r9 = r4.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            androidx.constraintlayout.core.SolverVariable r11 = r4.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            androidx.constraintlayout.core.SolverVariable r3 = r4.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r7.getAnchor(r5)
            androidx.constraintlayout.core.SolverVariable r12 = r4.createObjectVariable(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.getAnchor(r5)
            androidx.constraintlayout.core.SolverVariable r5 = r4.createObjectVariable(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.getAnchor(r6)
            androidx.constraintlayout.core.SolverVariable r13 = r4.createObjectVariable(r6)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.getAnchor(r6)
            androidx.constraintlayout.core.SolverVariable r6 = r4.createObjectVariable(r6)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.getAnchor(r8)
            androidx.constraintlayout.core.SolverVariable r14 = r4.createObjectVariable(r0)
            androidx.constraintlayout.core.ArrayRow r0 = r51.createRow()
            double r7 = (double) r1
            double r15 = java.lang.Math.sin(r7)
            double r1 = (double) r2
            r52 = r5
            r17 = r6
            double r5 = r15 * r1
            float r15 = (float) r5
            r10 = r0
            r10.createRowWithAngle(r11, r12, r13, r14, r15)
            r4.addConstraint(r0)
            androidx.constraintlayout.core.ArrayRow r0 = r51.createRow()
            double r5 = java.lang.Math.cos(r7)
            double r5 = r5 * r1
            float r13 = (float) r5
            r8 = r0
            r10 = r3
            r11 = r52
            r12 = r17
            r8.createRowWithAngle(r9, r10, r11, r12, r13)
            r4.addConstraint(r0)
        L_0x0710:
            r1 = 0
            r0 = r50
            r0.resolvedHorizontal = r1
            r0.resolvedVertical = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0427, code lost:
        if ((r3 instanceof androidx.constraintlayout.core.widgets.Barrier) != false) goto L_0x042c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0555  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyConstraints(androidx.constraintlayout.core.LinearSystem r37, boolean r38, boolean r39, boolean r40, boolean r41, androidx.constraintlayout.core.SolverVariable r42, androidx.constraintlayout.core.SolverVariable r43, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r44, boolean r45, androidx.constraintlayout.core.widgets.ConstraintAnchor r46, androidx.constraintlayout.core.widgets.ConstraintAnchor r47, int r48, int r49, int r50, int r51, float r52, boolean r53, boolean r54, boolean r55, boolean r56, boolean r57, int r58, int r59, int r60, int r61, float r62, boolean r63) {
        /*
            r36 = this;
            r0 = r36
            r10 = r37
            r11 = r42
            r12 = r43
            r13 = r46
            r14 = r47
            r15 = r50
            r1 = r51
            r2 = r59
            r3 = r60
            r4 = r61
            androidx.constraintlayout.core.SolverVariable r9 = r10.createObjectVariable(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.createObjectVariable(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r13.mTarget
            androidx.constraintlayout.core.SolverVariable r7 = r10.createObjectVariable(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r14.mTarget
            androidx.constraintlayout.core.SolverVariable r6 = r10.createObjectVariable(r5)
            boolean r16 = r46.isConnected()
            boolean r17 = r47.isConnected()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.mCenter
            boolean r18 = r5.isConnected()
            if (r17 == 0) goto L_0x003d
            int r5 = r16 + 1
            goto L_0x003f
        L_0x003d:
            r5 = r16
        L_0x003f:
            if (r18 == 0) goto L_0x0043
            int r5 = r5 + 1
        L_0x0043:
            if (r53 == 0) goto L_0x0049
            r20 = r6
            r12 = 3
            goto L_0x004d
        L_0x0049:
            r12 = r58
            r20 = r6
        L_0x004d:
            int r6 = r44.ordinal()
            r2 = 1
            if (r6 == 0) goto L_0x005f
            if (r6 == r2) goto L_0x005f
            r2 = 2
            if (r6 == r2) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            r2 = 4
            if (r12 == r2) goto L_0x0060
            r6 = 1
            goto L_0x0061
        L_0x005f:
            r2 = 4
        L_0x0060:
            r6 = 0
        L_0x0061:
            int r2 = r0.mWidthOverride
            r14 = -1
            if (r2 == r14) goto L_0x006d
            if (r38 == 0) goto L_0x006d
            r0.mWidthOverride = r14
            r49 = r2
            r6 = 0
        L_0x006d:
            int r2 = r0.mHeightOverride
            if (r2 == r14) goto L_0x0077
            if (r38 != 0) goto L_0x0077
            r0.mHeightOverride = r14
            r6 = 0
            goto L_0x0079
        L_0x0077:
            r2 = r49
        L_0x0079:
            int r14 = r0.mVisibility
            r49 = r2
            r2 = 8
            if (r14 != r2) goto L_0x0084
            r6 = 0
            r14 = 0
            goto L_0x0087
        L_0x0084:
            r14 = r6
            r6 = r49
        L_0x0087:
            if (r63 == 0) goto L_0x00a3
            if (r16 != 0) goto L_0x0095
            if (r17 != 0) goto L_0x0095
            if (r18 != 0) goto L_0x0095
            r2 = r48
            r10.addEquality(r9, r2)
            goto L_0x00a3
        L_0x0095:
            if (r16 == 0) goto L_0x00a3
            if (r17 != 0) goto L_0x00a3
            int r2 = r46.getMargin()
            r11 = 8
            r10.addEquality(r9, r7, r2, r11)
            goto L_0x00a5
        L_0x00a3:
            r11 = 8
        L_0x00a5:
            if (r14 != 0) goto L_0x00c6
            if (r45 == 0) goto L_0x00be
            r2 = 3
            r11 = 0
            r10.addEquality(r8, r9, r11, r2)
            r2 = 8
            if (r15 <= 0) goto L_0x00b5
            r10.addGreaterThan(r8, r9, r15, r2)
        L_0x00b5:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L_0x00c3
            r10.addLowerThan(r8, r9, r1, r2)
            goto L_0x00c3
        L_0x00be:
            r2 = 8
            r10.addEquality(r8, r9, r6, r2)
        L_0x00c3:
            r2 = r3
            goto L_0x013c
        L_0x00c6:
            r1 = 2
            if (r5 == r1) goto L_0x00ea
            if (r53 != 0) goto L_0x00ea
            r1 = 1
            if (r12 == r1) goto L_0x00d0
            if (r12 != 0) goto L_0x00ea
        L_0x00d0:
            int r1 = java.lang.Math.max(r3, r6)
            if (r4 <= 0) goto L_0x00da
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00da:
            r2 = 8
            r10.addEquality(r8, r9, r1, r2)
            r24 = r3
            r2 = r5
            r15 = r7
            r11 = r8
            r14 = r20
            r25 = 0
            goto L_0x0145
        L_0x00ea:
            r1 = -2
            if (r3 != r1) goto L_0x00ef
            r2 = r6
            goto L_0x00f0
        L_0x00ef:
            r2 = r3
        L_0x00f0:
            if (r4 != r1) goto L_0x00f4
            r1 = r6
            goto L_0x00f5
        L_0x00f4:
            r1 = r4
        L_0x00f5:
            if (r6 <= 0) goto L_0x00fb
            r3 = 1
            if (r12 == r3) goto L_0x00fb
            r6 = 0
        L_0x00fb:
            if (r2 <= 0) goto L_0x0106
            r3 = 8
            r10.addGreaterThan(r8, r9, r2, r3)
            int r6 = java.lang.Math.max(r6, r2)
        L_0x0106:
            if (r1 <= 0) goto L_0x011f
            if (r39 == 0) goto L_0x010f
            r3 = 1
            if (r12 != r3) goto L_0x010f
            r3 = 0
            goto L_0x0110
        L_0x010f:
            r3 = 1
        L_0x0110:
            if (r3 == 0) goto L_0x0118
            r3 = 8
            r10.addLowerThan(r8, r9, r1, r3)
            goto L_0x011a
        L_0x0118:
            r3 = 8
        L_0x011a:
            int r6 = java.lang.Math.min(r6, r1)
            goto L_0x0121
        L_0x011f:
            r3 = 8
        L_0x0121:
            r4 = 1
            if (r12 != r4) goto L_0x0149
            if (r39 == 0) goto L_0x012a
            r10.addEquality(r8, r9, r6, r3)
            goto L_0x013b
        L_0x012a:
            if (r55 == 0) goto L_0x0134
            r4 = 5
            r10.addEquality(r8, r9, r6, r4)
            r10.addLowerThan(r8, r9, r6, r3)
            goto L_0x013b
        L_0x0134:
            r4 = 5
            r10.addEquality(r8, r9, r6, r4)
            r10.addLowerThan(r8, r9, r6, r3)
        L_0x013b:
            r4 = r1
        L_0x013c:
            r24 = r2
            r2 = r5
            r15 = r7
            r11 = r8
            r25 = r14
            r14 = r20
        L_0x0145:
            r20 = r41
            goto L_0x01c4
        L_0x0149:
            r3 = 2
            if (r12 != r3) goto L_0x01b1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r13.mType
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x0170
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r4) goto L_0x0157
            goto L_0x0170
        L_0x0157:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.core.SolverVariable r4 = r10.createObjectVariable(r4)
            goto L_0x0188
        L_0x0170:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.core.SolverVariable r4 = r10.createObjectVariable(r4)
        L_0x0188:
            r11 = r3
            r6 = r4
            androidx.constraintlayout.core.ArrayRow r4 = r37.createRow()
            r3 = r4
            r45 = r1
            r1 = r4
            r4 = r8
            r51 = r2
            r2 = r5
            r5 = r9
            r24 = r14
            r14 = r20
            r15 = r7
            r7 = r11
            r11 = r8
            r8 = r62
            r3.createRowDimensionRatio(r4, r5, r6, r7, r8)
            r10.addConstraint(r1)
            if (r39 == 0) goto L_0x01aa
            r24 = 0
        L_0x01aa:
            r20 = r41
            r4 = r45
            r25 = r24
            goto L_0x01c2
        L_0x01b1:
            r45 = r1
            r51 = r2
            r2 = r5
            r15 = r7
            r11 = r8
            r24 = r14
            r14 = r20
            r4 = r45
            r25 = r24
            r20 = 1
        L_0x01c2:
            r24 = r51
        L_0x01c4:
            if (r63 == 0) goto L_0x0513
            if (r55 == 0) goto L_0x01ca
            goto L_0x0513
        L_0x01ca:
            if (r16 != 0) goto L_0x01d2
            if (r17 != 0) goto L_0x01d2
            if (r18 != 0) goto L_0x01d2
            goto L_0x04df
        L_0x01d2:
            if (r16 == 0) goto L_0x01e9
            if (r17 != 0) goto L_0x01e9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mOwner
            if (r39 == 0) goto L_0x01e3
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x01e3
            r2 = 8
            goto L_0x01e4
        L_0x01e3:
            r2 = 5
        L_0x01e4:
            r18 = r39
            r3 = 0
            goto L_0x04e5
        L_0x01e9:
            if (r16 != 0) goto L_0x021d
            if (r17 == 0) goto L_0x021d
            int r1 = r47.getMargin()
            int r1 = -r1
            r2 = 8
            r10.addEquality(r11, r14, r1, r2)
            if (r39 == 0) goto L_0x04df
            boolean r1 = r0.OPTIMIZE_WRAP
            if (r1 == 0) goto L_0x0213
            boolean r1 = r9.isFinalValue
            if (r1 == 0) goto L_0x0213
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.mParent
            if (r1 == 0) goto L_0x0213
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            if (r38 == 0) goto L_0x020e
            r1.addHorizontalWrapMinVariable(r13)
            goto L_0x04df
        L_0x020e:
            r1.addVerticalWrapMinVariable(r13)
            goto L_0x04df
        L_0x0213:
            r8 = r42
            r1 = 5
            r2 = 0
            r10.addGreaterThan(r9, r8, r2, r1)
        L_0x021a:
            r3 = 0
            goto L_0x04e2
        L_0x021d:
            r8 = r42
            r2 = 0
            if (r16 == 0) goto L_0x04df
            if (r17 == 0) goto L_0x04df
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r1.mOwner
            r6 = r47
            r1 = -1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r3.mOwner
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.mParent
            r16 = 6
            if (r25 == 0) goto L_0x034a
            if (r12 != 0) goto L_0x028a
            if (r4 != 0) goto L_0x0262
            if (r24 != 0) goto L_0x0262
            boolean r1 = r15.isFinalValue
            if (r1 == 0) goto L_0x0255
            boolean r1 = r14.isFinalValue
            if (r1 == 0) goto L_0x0255
            int r1 = r46.getMargin()
            r4 = 8
            r10.addEquality(r9, r15, r1, r4)
            int r1 = r47.getMargin()
            int r1 = -r1
            r10.addEquality(r11, r14, r1, r4)
            return
        L_0x0255:
            r4 = 8
            r1 = 8
            r17 = 8
            r18 = 0
            r21 = 1
            r23 = 0
            goto L_0x026d
        L_0x0262:
            r4 = 8
            r1 = 5
            r17 = 5
            r18 = 1
            r21 = 0
            r23 = 1
        L_0x026d:
            boolean r2 = r7 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 != 0) goto L_0x0275
            boolean r2 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r2 == 0) goto L_0x0277
        L_0x0275:
            r17 = 4
        L_0x0277:
            r4 = r43
            r26 = r17
            r19 = r18
            r22 = r23
            r2 = 1
            r13 = 3
            r17 = 8
            r18 = 6
            r23 = r1
            r1 = 5
            goto L_0x03a2
        L_0x028a:
            r2 = 2
            r17 = 8
            if (r12 != r2) goto L_0x02a3
            boolean r1 = r7 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x029c
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x0298
            goto L_0x029c
        L_0x0298:
            r1 = 0
            r2 = 1
            goto L_0x02fa
        L_0x029c:
            r4 = r43
            r1 = 5
            r2 = 1
        L_0x02a0:
            r13 = 3
            goto L_0x0392
        L_0x02a3:
            r2 = 1
            if (r12 != r2) goto L_0x02aa
            r1 = 6
            r2 = 0
            r4 = 4
            goto L_0x02bd
        L_0x02aa:
            r2 = 3
            if (r12 != r2) goto L_0x0340
            int r2 = r0.mResolvedDimensionRatioSide
            if (r2 != r1) goto L_0x02d0
            if (r56 == 0) goto L_0x02b9
            if (r39 == 0) goto L_0x02b7
            r1 = 5
            goto L_0x02bb
        L_0x02b7:
            r1 = 4
            goto L_0x02bb
        L_0x02b9:
            r1 = 8
        L_0x02bb:
            r2 = 1
            r4 = 5
        L_0x02bd:
            r18 = r1
            r21 = r2
            r26 = r4
            r1 = 5
            r2 = 1
            r13 = 3
            r19 = 1
            r22 = 1
            r23 = 8
        L_0x02cc:
            r4 = r43
            goto L_0x03a2
        L_0x02d0:
            if (r53 == 0) goto L_0x02f6
            r1 = r59
            r2 = 2
            if (r1 == r2) goto L_0x02dd
            r2 = 1
            if (r1 != r2) goto L_0x02db
            goto L_0x02de
        L_0x02db:
            r1 = 0
            goto L_0x02df
        L_0x02dd:
            r2 = 1
        L_0x02de:
            r1 = 1
        L_0x02df:
            if (r1 != 0) goto L_0x02e5
            r1 = 8
            r4 = 5
            goto L_0x02e7
        L_0x02e5:
            r1 = 5
            r4 = 4
        L_0x02e7:
            r23 = r1
            r26 = r4
            r1 = 5
            r13 = 3
            r18 = 6
            r19 = 1
            r21 = 1
            r22 = 1
            goto L_0x02cc
        L_0x02f6:
            r2 = 1
            if (r4 <= 0) goto L_0x0308
            r1 = 1
        L_0x02fa:
            r4 = r43
            r21 = r1
            r1 = 5
            r13 = 3
            r18 = 1
            r19 = 1
            r22 = 5
            goto L_0x039a
        L_0x0308:
            if (r4 != 0) goto L_0x0335
            if (r24 != 0) goto L_0x0335
            if (r56 != 0) goto L_0x031c
            r4 = r43
            r1 = 5
            r13 = 3
            r18 = 1
            r19 = 1
            r21 = 1
            r22 = 8
            goto L_0x039a
        L_0x031c:
            if (r7 == r3) goto L_0x0322
            if (r5 == r3) goto L_0x0322
            r1 = 4
            goto L_0x0323
        L_0x0322:
            r1 = 5
        L_0x0323:
            r4 = r43
            r23 = r1
            r1 = 5
            r13 = 3
            r18 = 6
            r19 = 1
            r21 = 1
            r22 = 1
            r26 = 4
            goto L_0x03a2
        L_0x0335:
            r4 = r43
            r1 = 5
            r13 = 3
            r18 = 1
            r19 = 1
            r21 = 1
            goto L_0x0398
        L_0x0340:
            r2 = 1
            r4 = r43
            r1 = 5
            r13 = 3
            r18 = 0
            r19 = 0
            goto L_0x0396
        L_0x034a:
            r2 = 1
            r17 = 8
            boolean r1 = r15.isFinalValue
            if (r1 == 0) goto L_0x038d
            boolean r1 = r14.isFinalValue
            if (r1 == 0) goto L_0x038d
            int r1 = r46.getMargin()
            int r2 = r47.getMargin()
            r3 = 8
            r53 = r37
            r54 = r9
            r55 = r15
            r56 = r1
            r57 = r52
            r58 = r14
            r59 = r11
            r60 = r2
            r61 = r3
            r53.addCentering(r54, r55, r56, r57, r58, r59, r60, r61)
            if (r39 == 0) goto L_0x038c
            if (r20 == 0) goto L_0x038c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x0383
            int r2 = r47.getMargin()
            r4 = r43
            goto L_0x0386
        L_0x0383:
            r4 = r43
            r2 = 0
        L_0x0386:
            if (r14 == r4) goto L_0x038c
            r1 = 5
            r10.addGreaterThan(r4, r11, r2, r1)
        L_0x038c:
            return
        L_0x038d:
            r4 = r43
            r1 = 5
            goto L_0x02a0
        L_0x0392:
            r18 = 1
            r19 = 1
        L_0x0396:
            r21 = 0
        L_0x0398:
            r22 = 4
        L_0x039a:
            r26 = r22
            r23 = 5
            r22 = r18
            r18 = 6
        L_0x03a2:
            if (r19 == 0) goto L_0x03ad
            if (r15 != r14) goto L_0x03ad
            if (r7 == r3) goto L_0x03ad
            r19 = 0
            r27 = 0
            goto L_0x03b1
        L_0x03ad:
            r27 = r19
            r19 = 1
        L_0x03b1:
            if (r22 == 0) goto L_0x03f8
            if (r25 != 0) goto L_0x03c6
            if (r54 != 0) goto L_0x03c6
            if (r56 != 0) goto L_0x03c6
            if (r15 != r8) goto L_0x03c6
            if (r14 != r4) goto L_0x03c6
            r18 = 0
            r19 = 8
            r22 = 0
            r23 = 8
            goto L_0x03cc
        L_0x03c6:
            r22 = r19
            r19 = r18
            r18 = r39
        L_0x03cc:
            int r28 = r46.getMargin()
            int r29 = r47.getMargin()
            r30 = 5
            r1 = r37
            r13 = 8
            r17 = 4
            r31 = 1
            r2 = r9
            r32 = r3
            r3 = r15
            r4 = r28
            r33 = r5
            r5 = r52
            r6 = r14
            r34 = r7
            r7 = r11
            r8 = r29
            r35 = r9
            r9 = r19
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r22
            goto L_0x040a
        L_0x03f8:
            r32 = r3
            r33 = r5
            r34 = r7
            r35 = r9
            r13 = 8
            r17 = 4
            r31 = 1
            r18 = r39
            r2 = r19
        L_0x040a:
            int r1 = r0.mVisibility
            if (r1 != r13) goto L_0x0415
            boolean r1 = r47.hasDependents()
            if (r1 != 0) goto L_0x0415
            return
        L_0x0415:
            if (r27 == 0) goto L_0x0448
            if (r18 == 0) goto L_0x042e
            if (r15 == r14) goto L_0x042e
            if (r25 != 0) goto L_0x042e
            r1 = r34
            boolean r3 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x042a
            r3 = r33
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r4 == 0) goto L_0x0432
            goto L_0x042c
        L_0x042a:
            r3 = r33
        L_0x042c:
            r4 = 6
            goto L_0x0434
        L_0x042e:
            r3 = r33
            r1 = r34
        L_0x0432:
            r4 = r23
        L_0x0434:
            int r5 = r46.getMargin()
            r6 = r35
            r10.addGreaterThan(r6, r15, r5, r4)
            int r5 = r47.getMargin()
            int r5 = -r5
            r10.addLowerThan(r11, r14, r5, r4)
            r23 = r4
            goto L_0x044e
        L_0x0448:
            r3 = r33
            r1 = r34
            r6 = r35
        L_0x044e:
            if (r18 == 0) goto L_0x0462
            if (r57 == 0) goto L_0x0462
            boolean r4 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r4 != 0) goto L_0x0462
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r4 != 0) goto L_0x0462
            r4 = r32
            if (r3 == r4) goto L_0x0464
            r2 = 1
            r5 = 6
            r7 = 6
            goto L_0x0468
        L_0x0462:
            r4 = r32
        L_0x0464:
            r5 = r23
            r7 = r26
        L_0x0468:
            if (r2 == 0) goto L_0x04b1
            if (r21 == 0) goto L_0x0492
            if (r56 == 0) goto L_0x0470
            if (r40 == 0) goto L_0x0492
        L_0x0470:
            if (r1 == r4) goto L_0x0477
            if (r3 != r4) goto L_0x0475
            goto L_0x0477
        L_0x0475:
            r2 = r7
            goto L_0x0478
        L_0x0477:
            r2 = 6
        L_0x0478:
            boolean r8 = r1 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r8 != 0) goto L_0x0480
            boolean r8 = r3 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r8 == 0) goto L_0x0481
        L_0x0480:
            r2 = 5
        L_0x0481:
            boolean r8 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 != 0) goto L_0x0489
            boolean r8 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 == 0) goto L_0x048a
        L_0x0489:
            r2 = 5
        L_0x048a:
            if (r56 == 0) goto L_0x048d
            r2 = 5
        L_0x048d:
            int r2 = java.lang.Math.max(r2, r7)
            goto L_0x0493
        L_0x0492:
            r2 = r7
        L_0x0493:
            if (r18 == 0) goto L_0x04a2
            int r2 = java.lang.Math.min(r5, r2)
            if (r53 == 0) goto L_0x04a2
            if (r56 != 0) goto L_0x04a2
            if (r1 == r4) goto L_0x04a1
            if (r3 != r4) goto L_0x04a2
        L_0x04a1:
            r2 = 4
        L_0x04a2:
            int r1 = r46.getMargin()
            r10.addEquality(r6, r15, r1, r2)
            int r1 = r47.getMargin()
            int r1 = -r1
            r10.addEquality(r11, r14, r1, r2)
        L_0x04b1:
            if (r18 == 0) goto L_0x04c3
            r1 = r42
            if (r1 != r15) goto L_0x04bc
            int r2 = r46.getMargin()
            goto L_0x04bd
        L_0x04bc:
            r2 = 0
        L_0x04bd:
            if (r15 == r1) goto L_0x04c3
            r3 = 5
            r10.addGreaterThan(r6, r1, r2, r3)
        L_0x04c3:
            if (r18 == 0) goto L_0x04dc
            if (r25 == 0) goto L_0x04dc
            if (r50 != 0) goto L_0x04dc
            if (r24 != 0) goto L_0x04dc
            if (r25 == 0) goto L_0x04d6
            r1 = 3
            if (r12 != r1) goto L_0x04d6
            r3 = 0
            r10.addGreaterThan(r11, r6, r3, r13)
            r1 = 5
            goto L_0x04e4
        L_0x04d6:
            r3 = 0
            r1 = 5
            r10.addGreaterThan(r11, r6, r3, r1)
            goto L_0x04e4
        L_0x04dc:
            r1 = 5
            r3 = 0
            goto L_0x04e4
        L_0x04df:
            r1 = 5
            goto L_0x021a
        L_0x04e2:
            r18 = r39
        L_0x04e4:
            r2 = 5
        L_0x04e5:
            if (r18 == 0) goto L_0x0512
            if (r20 == 0) goto L_0x0512
            r1 = r47
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04f3
            int r3 = r47.getMargin()
        L_0x04f3:
            r4 = r43
            if (r14 == r4) goto L_0x0512
            boolean r5 = r0.OPTIMIZE_WRAP
            if (r5 == 0) goto L_0x050f
            boolean r5 = r11.isFinalValue
            if (r5 == 0) goto L_0x050f
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.mParent
            if (r5 == 0) goto L_0x050f
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r5
            if (r38 == 0) goto L_0x050b
            r5.addHorizontalWrapMaxVariable(r1)
            goto L_0x050e
        L_0x050b:
            r5.addVerticalWrapMaxVariable(r1)
        L_0x050e:
            return
        L_0x050f:
            r10.addGreaterThan(r4, r11, r3, r2)
        L_0x0512:
            return
        L_0x0513:
            r1 = r42
            r4 = r43
            r6 = r9
            r3 = 0
            r5 = 2
            r13 = 8
            r31 = 1
            if (r2 >= r5) goto L_0x0558
            if (r39 == 0) goto L_0x0558
            if (r20 == 0) goto L_0x0558
            r10.addGreaterThan(r6, r1, r3, r13)
            if (r38 != 0) goto L_0x0532
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x0530
            goto L_0x0532
        L_0x0530:
            r2 = 0
            goto L_0x0533
        L_0x0532:
            r2 = 1
        L_0x0533:
            if (r38 != 0) goto L_0x0553
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0553
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mOwner
            float r2 = r1.mDimensionRatio
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0552
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r2 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r5) goto L_0x0552
            r1 = r1[r31]
            if (r1 != r5) goto L_0x0552
            r2 = 1
            goto L_0x0553
        L_0x0552:
            r2 = 0
        L_0x0553:
            if (r2 == 0) goto L_0x0558
            r10.addGreaterThan(r4, r11, r3, r13)
        L_0x0558:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.mOwner == this) {
            connect(constraintAnchor.mType, constraintAnchor2.mOwner, constraintAnchor2.mType, i);
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                throw new AssertionError(type.name());
        }
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public ConstraintWidget getNextChainMember(int i) {
        if (i == 0) {
            ConstraintAnchor constraintAnchor = this.mRight;
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
        } else if (i == 1) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
        }
        return null;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        if (i == 0) {
            ConstraintAnchor constraintAnchor = this.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
        } else if (i == 1) {
            ConstraintAnchor constraintAnchor3 = this.mTop;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
        }
        return null;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasDanglingDimension(int i) {
        boolean z = true;
        if (i == 0) {
            if ((this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) >= 2) {
                z = false;
            }
            return z;
        }
        if ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0) + (this.mBaseline.mTarget != null ? 1 : 0) >= 2) {
            z = false;
        }
        return z;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        boolean z = true;
        if (i == 0) {
            ConstraintAnchor constraintAnchor = this.mLeft.mTarget;
            if (constraintAnchor != null && constraintAnchor.mHasFinalValue) {
                ConstraintAnchor constraintAnchor2 = this.mRight.mTarget;
                if (constraintAnchor2 != null && constraintAnchor2.mHasFinalValue) {
                    if ((constraintAnchor2.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) < i2) {
                        z = false;
                    }
                    return z;
                }
            }
        } else {
            ConstraintAnchor constraintAnchor3 = this.mTop.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.mHasFinalValue) {
                ConstraintAnchor constraintAnchor4 = this.mBottom.mTarget;
                if (constraintAnchor4 != null && constraintAnchor4.mHasFinalValue) {
                    if ((constraintAnchor4.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) < i2) {
                        z = false;
                    }
                    return z;
                }
            }
        }
        return false;
    }

    public void immediateConnect(Type type, ConstraintWidget constraintWidget, Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public final boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (!(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i2].mTarget.mTarget == constraintAnchorArr[i2])) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return false;
            }
        }
        return true;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return false;
            }
        }
        return true;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.mHasFinalValue && this.mRight.mHasFinalValue);
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.mHasFinalValue && this.mBottom.mHasFinalValue);
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAnchors() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer) || ((ConstraintWidgetContainer) constraintWidget) != null) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
            return;
        }
        throw null;
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = this.mAnchors.get(i);
            constraintAnchor.mHasFinalValue = false;
            constraintAnchor.mFinalValue = 0;
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable();
        this.mTop.resetSolverVariable();
        this.mRight.resetSolverVariable();
        this.mBottom.resetSolverVariable();
        this.mBaseline.resetSolverVariable();
        this.mCenter.resetSolverVariable();
        this.mCenterX.resetSolverVariable();
        this.mCenterY.resetSolverVariable();
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setFinalHorizontal(int i, int i2) {
        if (!this.resolvedHorizontal) {
            ConstraintAnchor constraintAnchor = this.mLeft;
            constraintAnchor.mFinalValue = i;
            constraintAnchor.mHasFinalValue = true;
            ConstraintAnchor constraintAnchor2 = this.mRight;
            constraintAnchor2.mFinalValue = i2;
            constraintAnchor2.mHasFinalValue = true;
            this.mX = i;
            this.mWidth = i2 - i;
            this.resolvedHorizontal = true;
        }
    }

    public void setFinalVertical(int i, int i2) {
        if (!this.resolvedVertical) {
            ConstraintAnchor constraintAnchor = this.mTop;
            constraintAnchor.mFinalValue = i;
            constraintAnchor.mHasFinalValue = true;
            ConstraintAnchor constraintAnchor2 = this.mBottom;
            constraintAnchor2.mFinalValue = i2;
            constraintAnchor2.mHasFinalValue = true;
            this.mY = i;
            this.mHeight = i2 - i;
            if (this.hasBaseline) {
                this.mBaseline.setFinalValue(i + this.mBaselineDistance);
            }
            this.resolvedVertical = true;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(this.mType != null ? GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("type: "), this.mType, CMap.SPACE) : str);
        if (this.mDebugName != null) {
            str = GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("id: "), this.mDebugName, CMap.SPACE);
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return GeneratedOutlineSupport.outline57(sb, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z, boolean z2) {
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        boolean z3 = z & horizontalWidgetRun.resolved;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        boolean z4 = z2 & verticalWidgetRun.resolved;
        int i = horizontalWidgetRun.start.value;
        int i2 = verticalWidgetRun.start.value;
        int i3 = horizontalWidgetRun.end.value;
        int i4 = verticalWidgetRun.end.value;
        int i5 = i4 - i2;
        if (i3 - i < 0 || i5 < 0 || i == Integer.MIN_VALUE || i == Integer.MAX_VALUE || i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i = 0;
            i2 = 0;
        }
        int i6 = i3 - i;
        int i7 = i4 - i2;
        if (z3) {
            this.mX = i;
        }
        if (z4) {
            this.mY = i2;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (z3) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
                int i8 = this.mWidth;
                if (i6 < i8) {
                    i6 = i8;
                }
            }
            this.mWidth = i6;
            int i9 = this.mMinWidth;
            if (i6 < i9) {
                this.mWidth = i9;
            }
        }
        if (z4) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
                int i10 = this.mHeight;
                if (i7 < i10) {
                    i7 = i10;
                }
            }
            this.mHeight = i7;
            int i11 = this.mMinHeight;
            if (i7 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z) {
            HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
            if (horizontalWidgetRun != null) {
                DependencyNode dependencyNode = horizontalWidgetRun.start;
                if (dependencyNode.resolved) {
                    DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                    if (dependencyNode2.resolved) {
                        objectVariableValue = dependencyNode.value;
                        objectVariableValue3 = dependencyNode2.value;
                    }
                }
            }
        }
        if (z) {
            VerticalWidgetRun verticalWidgetRun = this.verticalRun;
            if (verticalWidgetRun != null) {
                DependencyNode dependencyNode3 = verticalWidgetRun.start;
                if (dependencyNode3.resolved) {
                    DependencyNode dependencyNode4 = verticalWidgetRun.end;
                    if (dependencyNode4.resolved) {
                        objectVariableValue2 = dependencyNode3.value;
                        objectVariableValue4 = dependencyNode4.value;
                    }
                }
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        int i2 = objectVariableValue3 - objectVariableValue;
        int i3 = objectVariableValue4 - objectVariableValue2;
        this.mX = objectVariableValue;
        this.mY = objectVariableValue2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
            int i4 = this.mWidth;
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            int i5 = this.mHeight;
            if (i3 < i5) {
                i3 = i5;
            }
        }
        this.mWidth = i2;
        this.mHeight = i3;
        int i6 = this.mMinHeight;
        if (i3 < i6) {
            this.mHeight = i6;
        }
        int i7 = this.mWidth;
        int i8 = this.mMinWidth;
        if (i7 < i8) {
            this.mWidth = i8;
        }
        int i9 = this.mMatchConstraintMaxWidth;
        if (i9 > 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i9);
        }
        int i10 = this.mMatchConstraintMaxHeight;
        if (i10 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i10);
        }
        int i11 = this.mWidth;
        if (i2 != i11) {
            this.mWidthOverride = i11;
        }
        int i12 = this.mHeight;
        if (i3 != i12) {
            this.mHeightOverride = i12;
        }
    }

    public void connect(Type type, ConstraintWidget constraintWidget, Type type2, int i) {
        boolean z;
        Type type3 = Type.CENTER;
        if (type == type3) {
            if (type2 == type3) {
                ConstraintAnchor anchor = getAnchor(Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    Type type4 = Type.LEFT;
                    connect(type4, constraintWidget, type4, 0);
                    Type type5 = Type.RIGHT;
                    connect(type5, constraintWidget, type5, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    Type type6 = Type.TOP;
                    connect(type6, constraintWidget, type6, 0);
                    Type type7 = Type.BOTTOM;
                    connect(type7, constraintWidget, type7, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(Type.CENTER).connect(constraintWidget.getAnchor(Type.CENTER), 0);
                } else if (z) {
                    getAnchor(Type.CENTER_X).connect(constraintWidget.getAnchor(Type.CENTER_X), 0);
                } else if (z2) {
                    getAnchor(Type.CENTER_Y).connect(constraintWidget.getAnchor(Type.CENTER_Y), 0);
                }
            } else if (type2 == Type.LEFT || type2 == Type.RIGHT) {
                connect(Type.LEFT, constraintWidget, type2, 0);
                connect(Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type2 == Type.TOP || type2 == Type.BOTTOM) {
                connect(Type.TOP, constraintWidget, type2, 0);
                connect(Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            }
        } else if (type == Type.CENTER_X && (type2 == Type.LEFT || type2 == Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(Type.CENTER_X).connect(anchor6, 0);
        } else if (type == Type.CENTER_Y && (type2 == Type.TOP || type2 == Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(Type.TOP).connect(anchor8, 0);
            getAnchor(Type.BOTTOM).connect(anchor8, 0);
            getAnchor(Type.CENTER_Y).connect(anchor8, 0);
        } else {
            Type type8 = Type.CENTER_X;
            if (type == type8 && type2 == type8) {
                getAnchor(Type.LEFT).connect(constraintWidget.getAnchor(Type.LEFT), 0);
                getAnchor(Type.RIGHT).connect(constraintWidget.getAnchor(Type.RIGHT), 0);
                getAnchor(Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            Type type9 = Type.CENTER_Y;
            if (type == type9 && type2 == type9) {
                getAnchor(Type.TOP).connect(constraintWidget.getAnchor(Type.TOP), 0);
                getAnchor(Type.BOTTOM).connect(constraintWidget.getAnchor(Type.BOTTOM), 0);
                getAnchor(Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else if (type == Type.TOP || type == Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(Type.CENTER);
                    if (anchor14.mTarget != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == Type.LEFT || type == Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(Type.CENTER);
                    if (anchor16.mTarget != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i);
            }
        }
    }
}
