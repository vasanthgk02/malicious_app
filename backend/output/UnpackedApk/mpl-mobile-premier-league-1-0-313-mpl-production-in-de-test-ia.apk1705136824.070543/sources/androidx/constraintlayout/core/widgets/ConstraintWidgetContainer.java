package androidx.constraintlayout.core.widgets;

import a.a.a.a.d.b;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.net.ftp.FTPReply;

public class ConstraintWidgetContainer extends WidgetContainer {
    public WeakReference<ConstraintAnchor> horizontalWrapMax = null;
    public WeakReference<ConstraintAnchor> horizontalWrapMin = null;
    public BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mHeightMeasuredTooSmall = false;
    public ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    public int mHorizontalChainsSize = 0;
    public boolean mIsRtl = false;
    public Measure mMeasure = new Measure();
    public Measurer mMeasurer = null;
    public int mOptimizationLevel = FTPReply.PATHNAME_CREATED;
    public int mPaddingLeft;
    public int mPaddingTop;
    public LinearSystem mSystem = new LinearSystem();
    public ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public int mVerticalChainsSize = 0;
    public boolean mWidthMeasuredTooSmall = false;
    public int pass;
    public WeakReference<ConstraintAnchor> verticalWrapMax = null;
    public WeakReference<ConstraintAnchor> verticalWrapMin = null;
    public HashSet<ConstraintWidget> widgetsToAdd = new HashSet<>();

    public static boolean measure(int i, ConstraintWidget constraintWidget, Measurer measurer, Measure measure, int i2) {
        int i3;
        int i4;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.mVisibility == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i2;
        boolean z = measure.horizontalBehavior == DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = measure.verticalBehavior == DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z3) {
            measure.horizontalBehavior = DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                measure.horizontalBehavior = DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z4) {
            measure.verticalBehavior = DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                measure.verticalBehavior = DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = DimensionBehaviour.FIXED;
            } else if (!z2) {
                if (measure.verticalBehavior == DimensionBehaviour.FIXED) {
                    i4 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = DimensionBehaviour.WRAP_CONTENT;
                    ((ConstraintLayout.Measurer) measurer).measure(constraintWidget, measure);
                    i4 = measure.measuredHeight;
                }
                measure.horizontalBehavior = DimensionBehaviour.FIXED;
                measure.horizontalDimension = (int) (constraintWidget.mDimensionRatio * ((float) i4));
            }
        }
        if (z4) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = DimensionBehaviour.FIXED;
            } else if (!z) {
                if (measure.horizontalBehavior == DimensionBehaviour.FIXED) {
                    i3 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = DimensionBehaviour.WRAP_CONTENT;
                    ((ConstraintLayout.Measurer) measurer).measure(constraintWidget, measure);
                    i3 = measure.measuredWidth;
                }
                measure.verticalBehavior = DimensionBehaviour.FIXED;
                if (constraintWidget.mDimensionRatioSide == -1) {
                    measure.verticalDimension = (int) (((float) i3) / constraintWidget.mDimensionRatio);
                } else {
                    measure.verticalDimension = (int) (constraintWidget.mDimensionRatio * ((float) i3));
                }
            }
        }
        ((ConstraintLayout.Measurer) measurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.hasBaseline = measure.measuredHasBaseline;
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = 0;
        return measure.measuredNeedsSolverPass;
    }

    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, this.mIsRtl);
            this.mHorizontalChainsSize++;
        } else if (i == 1) {
            int i3 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr2 = this.mVerticalChainsArray;
            if (i3 >= chainHeadArr2.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr2, chainHeadArr2.length * 2);
            }
            this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, this.mIsRtl);
            this.mVerticalChainsSize++;
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            boolean[] zArr = constraintWidget.mIsInBarrier;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int i3 = 0; i3 < barrier.mWidgetsCount; i3++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i3];
                        if (barrier.mAllowsGoneWidget || constraintWidget3.allowedInBarrier()) {
                            int i4 = barrier.mBarrierType;
                            if (i4 == 0 || i4 == 1) {
                                constraintWidget3.mIsInBarrier[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                constraintWidget3.mIsInBarrier[1] = true;
                            }
                        }
                    }
                }
            }
        }
        this.widgetsToAdd.clear();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget4 = this.mChildren.get(i5);
            if (constraintWidget4.addFirst()) {
                if (constraintWidget4 instanceof VirtualLayout) {
                    this.widgetsToAdd.add(constraintWidget4);
                } else {
                    constraintWidget4.addToSolver(linearSystem, optimizeFor);
                }
            }
        }
        while (this.widgetsToAdd.size() > 0) {
            int size2 = this.widgetsToAdd.size();
            Iterator<ConstraintWidget> it = this.widgetsToAdd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                HashSet<ConstraintWidget> hashSet = this.widgetsToAdd;
                int i6 = 0;
                while (true) {
                    if (i6 >= virtualLayout.mWidgetsCount) {
                        z = false;
                        continue;
                        break;
                    } else if (hashSet.contains(virtualLayout.mWidgets[i6])) {
                        z = true;
                        continue;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z) {
                    virtualLayout.addToSolver(linearSystem, optimizeFor);
                    this.widgetsToAdd.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.widgetsToAdd.size()) {
                Iterator<ConstraintWidget> it2 = this.widgetsToAdd.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(linearSystem, optimizeFor);
                }
                this.widgetsToAdd.clear();
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet hashSet2 = new HashSet();
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget5 = this.mChildren.get(i7);
                if (!constraintWidget5.addFirst()) {
                    hashSet2.add(constraintWidget5);
                }
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet2, getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) it3.next();
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget6);
                constraintWidget6.addToSolver(linearSystem, optimizeFor);
            }
        } else {
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget7 = this.mChildren.get(i8);
                if (constraintWidget7 instanceof ConstraintWidgetContainer) {
                    DimensionBehaviour[] dimensionBehaviourArr = constraintWidget7.mListDimensionBehaviors;
                    DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget7.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget7.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                    }
                    constraintWidget7.addToSolver(linearSystem, optimizeFor);
                    if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget7.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget7.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.checkMatchParent(this, linearSystem, constraintWidget7);
                    if (!constraintWidget7.addFirst()) {
                        constraintWidget7.addToSolver(linearSystem, optimizeFor);
                    }
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            b.applyChainConstraints(this, linearSystem, null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            b.applyChainConstraints(this, linearSystem, null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.horizontalWrapMax.get()).getFinalValue()) {
            this.horizontalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.horizontalWrapMin.get()).getFinalValue()) {
            this.horizontalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.verticalWrapMax.get()).getFinalValue()) {
            this.verticalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > ((ConstraintAnchor) this.verticalWrapMin.get()).getFinalValue()) {
            this.verticalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0148 A[EDGE_INSN: B:77:0x0148->B:62:0x0148 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean directMeasureWithOrientation(boolean r11, int r12) {
        /*
            r10 = this;
            androidx.constraintlayout.core.widgets.analyzer.DependencyGraph r0 = r10.mDependencyGraph
            r1 = 1
            r11 = r11 & r1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r0.container
            r3 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.getDimensionBehaviour(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r0.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r4.getDimensionBehaviour(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r0.container
            int r5 = r5.getX()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r0.container
            int r6 = r6.getY()
            if (r11 == 0) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 == r7) goto L_0x0025
            if (r4 != r7) goto L_0x008b
        L_0x0025:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r7 = r0.mRuns
            java.util.Iterator r7 = r7.iterator()
        L_0x002b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0042
            java.lang.Object r8 = r7.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r8
            int r9 = r8.orientation
            if (r9 != r12) goto L_0x002b
            boolean r8 = r8.supportsWrapComputation()
            if (r8 != 0) goto L_0x002b
            r11 = 0
        L_0x0042:
            if (r12 != 0) goto L_0x0068
            if (r11 == 0) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r11) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r11.setHorizontalDimensionBehaviour(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            int r7 = r0.computeWrap(r11, r3)
            r11.setWidth(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r7 = r11.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r7.dimension
            int r11 = r11.getWidth()
            r7.resolve(r11)
            goto L_0x008b
        L_0x0068:
            if (r11 == 0) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r11) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r11.setVerticalDimensionBehaviour(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            int r7 = r0.computeWrap(r11, r1)
            r11.setHeight(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r11.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r7.dimension
            int r11 = r11.getHeight()
            r7.resolve(r11)
        L_0x008b:
            if (r12 != 0) goto L_0x00b8
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r11.mListDimensionBehaviors
            r6 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r6 == r7) goto L_0x009d
            r11 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r11 != r6) goto L_0x00c9
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            int r11 = r11.getWidth()
            int r11 = r11 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r6.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r6.end
            r6.resolve(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r6.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.dimension
            int r11 = r11 - r5
            r6.resolve(r11)
            goto L_0x00e5
        L_0x00b8:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r11.mListDimensionBehaviors
            r5 = r11[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r7) goto L_0x00cb
            r11 = r11[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r11 != r5) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r11 = 0
            goto L_0x00e6
        L_0x00cb:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            int r11 = r11.getHeight()
            int r11 = r11 + r6
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = r5.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.end
            r5.resolve(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r0.container
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = r5.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.dimension
            int r11 = r11 - r6
            r5.resolve(r11)
        L_0x00e5:
            r11 = 1
        L_0x00e6:
            r0.measureWidgets()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r5 = r0.mRuns
            java.util.Iterator r5 = r5.iterator()
        L_0x00ef:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x010f
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r6
            int r7 = r6.orientation
            if (r7 == r12) goto L_0x0100
            goto L_0x00ef
        L_0x0100:
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.widget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = r0.container
            if (r7 != r8) goto L_0x010b
            boolean r7 = r6.resolved
            if (r7 != 0) goto L_0x010b
            goto L_0x00ef
        L_0x010b:
            r6.applyToWidget()
            goto L_0x00ef
        L_0x010f:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r5 = r0.mRuns
            java.util.Iterator r5 = r5.iterator()
        L_0x0115:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0148
            java.lang.Object r6 = r5.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r6
            int r7 = r6.orientation
            if (r7 == r12) goto L_0x0126
            goto L_0x0115
        L_0x0126:
            if (r11 != 0) goto L_0x012f
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.widget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = r0.container
            if (r7 != r8) goto L_0x012f
            goto L_0x0115
        L_0x012f:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r6.start
            boolean r7 = r7.resolved
            if (r7 != 0) goto L_0x0136
            goto L_0x0147
        L_0x0136:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r6.end
            boolean r7 = r7.resolved
            if (r7 != 0) goto L_0x013d
            goto L_0x0147
        L_0x013d:
            boolean r7 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r7 != 0) goto L_0x0115
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.dimension
            boolean r6 = r6.resolved
            if (r6 != 0) goto L_0x0115
        L_0x0147:
            r1 = 0
        L_0x0148:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            r11.setHorizontalDimensionBehaviour(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r0.container
            r11.setVerticalDimensionBehaviour(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.directMeasureWithOrientation(boolean, int):boolean");
    }

    public void invalidateGraph() {
        this.mDependencyGraph.mNeedBuildGraph = true;
    }

    /* JADX WARNING: type inference failed for: r12v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v37 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v3, types: [boolean]
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 902
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0603  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x065e  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0675  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0692  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0795  */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x07dc  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0809 A[LOOP:32: B:466:0x0807->B:467:0x0809, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0878  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0895  */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x08a3  */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x08a6  */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x08ea  */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x08ec  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x08f7  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r1.mX = r2
            r1.mY = r2
            r1.mWidthMeasuredTooSmall = r2
            r1.mHeightMeasuredTooSmall = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.mChildren
            int r3 = r0.size()
            int r0 = r24.getWidth()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r24.getHeight()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            int r8 = r1.pass
            if (r8 != 0) goto L_0x024a
            int r8 = r1.mOptimizationLevel
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r8, r6)
            if (r8 == 0) goto L_0x024a
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r1.mMeasurer
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r24.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r24.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.analyzer.Direct.hcount = r2
            androidx.constraintlayout.core.widgets.analyzer.Direct.vcount = r2
            r24.resetFinalResolution()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r12 = r1.mChildren
            int r13 = r12.size()
            r14 = 0
        L_0x004c:
            if (r14 >= r13) goto L_0x005a
            java.lang.Object r15 = r12.get(r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r15
            r15.resetFinalResolution()
            int r14 = r14 + 1
            goto L_0x004c
        L_0x005a:
            boolean r14 = r1.mIsRtl
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r10 != r15) goto L_0x0068
            int r10 = r24.getWidth()
            r1.setFinalHorizontal(r2, r10)
            goto L_0x0070
        L_0x0068:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r1.mLeft
            r10.mFinalValue = r2
            r10.mHasFinalValue = r6
            r1.mX = r2
        L_0x0070:
            r10 = 0
            r15 = 0
            r16 = 0
        L_0x0074:
            r17 = 1056964608(0x3f000000, float:0.5)
            if (r10 >= r13) goto L_0x00d1
            java.lang.Object r18 = r12.get(r10)
            r2 = r18
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            boolean r9 = r2 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r9 == 0) goto L_0x00bf
            androidx.constraintlayout.core.widgets.Guideline r2 = (androidx.constraintlayout.core.widgets.Guideline) r2
            int r9 = r2.mOrientation
            if (r9 != r6) goto L_0x00cd
            int r9 = r2.mRelativeBegin
            r15 = -1
            if (r9 == r15) goto L_0x0093
            r2.setFinalValue(r9)
            goto L_0x00bd
        L_0x0093:
            int r9 = r2.mRelativeEnd
            if (r9 == r15) goto L_0x00a8
            boolean r9 = r24.isResolvedHorizontally()
            if (r9 == 0) goto L_0x00a8
            int r9 = r24.getWidth()
            int r15 = r2.mRelativeEnd
            int r9 = r9 - r15
            r2.setFinalValue(r9)
            goto L_0x00bd
        L_0x00a8:
            boolean r9 = r24.isResolvedHorizontally()
            if (r9 == 0) goto L_0x00bd
            float r9 = r2.mRelativePercent
            int r15 = r24.getWidth()
            float r15 = (float) r15
            float r9 = r9 * r15
            float r9 = r9 + r17
            int r9 = (int) r9
            r2.setFinalValue(r9)
        L_0x00bd:
            r15 = 1
            goto L_0x00cd
        L_0x00bf:
            boolean r9 = r2 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r9 == 0) goto L_0x00cd
            androidx.constraintlayout.core.widgets.Barrier r2 = (androidx.constraintlayout.core.widgets.Barrier) r2
            int r2 = r2.getOrientation()
            if (r2 != 0) goto L_0x00cd
            r16 = 1
        L_0x00cd:
            int r10 = r10 + 1
            r2 = 0
            goto L_0x0074
        L_0x00d1:
            if (r15 == 0) goto L_0x00ef
            r2 = 0
        L_0x00d4:
            if (r2 >= r13) goto L_0x00ef
            java.lang.Object r9 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 == 0) goto L_0x00eb
            androidx.constraintlayout.core.widgets.Guideline r9 = (androidx.constraintlayout.core.widgets.Guideline) r9
            int r10 = r9.mOrientation
            if (r10 != r6) goto L_0x00eb
            r10 = 0
            androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(r10, r9, r8, r14)
            goto L_0x00ec
        L_0x00eb:
            r10 = 0
        L_0x00ec:
            int r2 = r2 + 1
            goto L_0x00d4
        L_0x00ef:
            r10 = 0
            androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(r10, r1, r8, r14)
            if (r16 == 0) goto L_0x0116
            r2 = 0
        L_0x00f6:
            if (r2 >= r13) goto L_0x0116
            java.lang.Object r9 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 == 0) goto L_0x0113
            androidx.constraintlayout.core.widgets.Barrier r9 = (androidx.constraintlayout.core.widgets.Barrier) r9
            int r10 = r9.getOrientation()
            if (r10 != 0) goto L_0x0113
            boolean r10 = r9.allSolved()
            if (r10 == 0) goto L_0x0113
            androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(r6, r9, r8, r14)
        L_0x0113:
            int r2 = r2 + 1
            goto L_0x00f6
        L_0x0116:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r11 != r2) goto L_0x0123
            int r2 = r24.getHeight()
            r9 = 0
            r1.setFinalVertical(r9, r2)
            goto L_0x012c
        L_0x0123:
            r9 = 0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.mTop
            r2.mFinalValue = r9
            r2.mHasFinalValue = r6
            r1.mY = r9
        L_0x012c:
            r2 = 0
            r9 = 0
            r10 = 0
        L_0x012f:
            if (r2 >= r13) goto L_0x0186
            java.lang.Object r11 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r11
            boolean r15 = r11 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r15 == 0) goto L_0x0176
            androidx.constraintlayout.core.widgets.Guideline r11 = (androidx.constraintlayout.core.widgets.Guideline) r11
            int r15 = r11.mOrientation
            if (r15 != 0) goto L_0x0183
            int r9 = r11.mRelativeBegin
            r15 = -1
            if (r9 == r15) goto L_0x014a
            r11.setFinalValue(r9)
            goto L_0x0174
        L_0x014a:
            int r9 = r11.mRelativeEnd
            if (r9 == r15) goto L_0x015f
            boolean r9 = r24.isResolvedVertically()
            if (r9 == 0) goto L_0x015f
            int r9 = r24.getHeight()
            int r15 = r11.mRelativeEnd
            int r9 = r9 - r15
            r11.setFinalValue(r9)
            goto L_0x0174
        L_0x015f:
            boolean r9 = r24.isResolvedVertically()
            if (r9 == 0) goto L_0x0174
            float r9 = r11.mRelativePercent
            int r15 = r24.getHeight()
            float r15 = (float) r15
            float r9 = r9 * r15
            float r9 = r9 + r17
            int r9 = (int) r9
            r11.setFinalValue(r9)
        L_0x0174:
            r9 = 1
            goto L_0x0183
        L_0x0176:
            boolean r15 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r15 == 0) goto L_0x0183
            androidx.constraintlayout.core.widgets.Barrier r11 = (androidx.constraintlayout.core.widgets.Barrier) r11
            int r11 = r11.getOrientation()
            if (r11 != r6) goto L_0x0183
            r10 = 1
        L_0x0183:
            int r2 = r2 + 1
            goto L_0x012f
        L_0x0186:
            if (r9 == 0) goto L_0x01a1
            r2 = 0
        L_0x0189:
            if (r2 >= r13) goto L_0x01a1
            java.lang.Object r9 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r11 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r11 == 0) goto L_0x019e
            androidx.constraintlayout.core.widgets.Guideline r9 = (androidx.constraintlayout.core.widgets.Guideline) r9
            int r11 = r9.mOrientation
            if (r11 != 0) goto L_0x019e
            androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(r6, r9, r8)
        L_0x019e:
            int r2 = r2 + 1
            goto L_0x0189
        L_0x01a1:
            r2 = 0
            androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(r2, r1, r8)
            if (r10 == 0) goto L_0x01c8
            r2 = 0
        L_0x01a8:
            if (r2 >= r13) goto L_0x01c8
            java.lang.Object r9 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 == 0) goto L_0x01c5
            androidx.constraintlayout.core.widgets.Barrier r9 = (androidx.constraintlayout.core.widgets.Barrier) r9
            int r10 = r9.getOrientation()
            if (r10 != r6) goto L_0x01c5
            boolean r10 = r9.allSolved()
            if (r10 == 0) goto L_0x01c5
            androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(r6, r9, r8)
        L_0x01c5:
            int r2 = r2 + 1
            goto L_0x01a8
        L_0x01c8:
            r2 = 0
        L_0x01c9:
            if (r2 >= r13) goto L_0x01ff
            java.lang.Object r9 = r12.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.isMeasureRequested()
            if (r10 == 0) goto L_0x01fc
            r10 = 0
            boolean r11 = androidx.constraintlayout.core.widgets.analyzer.Direct.canMeasure(r10, r9)
            if (r11 == 0) goto L_0x01fc
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r11 = androidx.constraintlayout.core.widgets.analyzer.Direct.measure
            measure(r10, r9, r8, r11, r10)
            boolean r11 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r11 == 0) goto L_0x01f6
            r11 = r9
            androidx.constraintlayout.core.widgets.Guideline r11 = (androidx.constraintlayout.core.widgets.Guideline) r11
            int r11 = r11.mOrientation
            if (r11 != 0) goto L_0x01f2
            androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(r10, r9, r8)
            goto L_0x01fc
        L_0x01f2:
            androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(r10, r9, r8, r14)
            goto L_0x01fc
        L_0x01f6:
            androidx.constraintlayout.core.widgets.analyzer.Direct.horizontalSolvingPass(r10, r9, r8, r14)
            androidx.constraintlayout.core.widgets.analyzer.Direct.verticalSolvingPass(r10, r9, r8)
        L_0x01fc:
            int r2 = r2 + 1
            goto L_0x01c9
        L_0x01ff:
            r2 = 0
        L_0x0200:
            if (r2 >= r3) goto L_0x024a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r8 = r1.mChildren
            java.lang.Object r8 = r8.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r8
            boolean r9 = r8.isMeasureRequested()
            if (r9 == 0) goto L_0x0247
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r9 != 0) goto L_0x0247
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r9 != 0) goto L_0x0247
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r9 != 0) goto L_0x0247
            boolean r9 = r8.mInVirtualLayout
            if (r9 != 0) goto L_0x0247
            r9 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r8.getDimensionBehaviour(r9)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r8.getDimensionBehaviour(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r11) goto L_0x0239
            int r10 = r8.mMatchConstraintDefaultWidth
            if (r10 == r6) goto L_0x0239
            if (r9 != r11) goto L_0x0239
            int r9 = r8.mMatchConstraintDefaultHeight
            if (r9 == r6) goto L_0x0239
            r9 = 1
            goto L_0x023a
        L_0x0239:
            r9 = 0
        L_0x023a:
            if (r9 != 0) goto L_0x0247
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r9 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r9.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r10 = r1.mMeasurer
            r11 = 0
            measure(r11, r8, r10, r9, r11)
        L_0x0247:
            int r2 = r2 + 1
            goto L_0x0200
        L_0x024a:
            r2 = 2
            if (r3 <= r2) goto L_0x0629
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0253
            if (r7 != r9) goto L_0x0629
        L_0x0253:
            int r9 = r1.mOptimizationLevel
            r10 = 1024(0x400, float:1.435E-42)
            boolean r9 = androidx.constraintlayout.core.widgets.Optimizer.enabled(r9, r10)
            if (r9 == 0) goto L_0x0629
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r9 = r1.mMeasurer
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r10 = r1.mChildren
            int r11 = r10.size()
            r12 = 0
        L_0x0266:
            if (r12 >= r11) goto L_0x0299
            java.lang.Object r13 = r10.get(r12)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r24.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r24.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r13.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r13.getVerticalDimensionBehaviour()
            boolean r2 = a.a.a.a.d.b.validInGroup(r14, r15, r2, r8)
            if (r2 != 0) goto L_0x0285
            goto L_0x0289
        L_0x0285:
            boolean r2 = r13 instanceof androidx.constraintlayout.core.widgets.Flow
            if (r2 == 0) goto L_0x0295
        L_0x0289:
            r22 = r0
            r20 = r3
            r19 = r4
            r23 = r5
            r21 = r7
            goto L_0x05d9
        L_0x0295:
            int r12 = r12 + 1
            r2 = 2
            goto L_0x0266
        L_0x0299:
            r2 = 0
            r6 = 0
            r8 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02a0:
            if (r6 >= r11) goto L_0x0386
            java.lang.Object r19 = r10.get(r6)
            r20 = r3
            r3 = r19
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            r19 = r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r24.getHorizontalDimensionBehaviour()
            r21 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r24.getVerticalDimensionBehaviour()
            r22 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r3.getHorizontalDimensionBehaviour()
            r23 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = r3.getVerticalDimensionBehaviour()
            boolean r0 = a.a.a.a.d.b.validInGroup(r4, r7, r0, r5)
            if (r0 != 0) goto L_0x02d0
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r0 = r1.mMeasure
            r4 = 0
            measure(r4, r3, r9, r0, r4)
        L_0x02d0:
            boolean r0 = r3 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r0 == 0) goto L_0x02f5
            r4 = r3
            androidx.constraintlayout.core.widgets.Guideline r4 = (androidx.constraintlayout.core.widgets.Guideline) r4
            int r5 = r4.mOrientation
            if (r5 != 0) goto L_0x02e6
            if (r12 != 0) goto L_0x02e3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r12 = r5
        L_0x02e3:
            r12.add(r4)
        L_0x02e6:
            int r5 = r4.mOrientation
            r7 = 1
            if (r5 != r7) goto L_0x02f5
            if (r2 != 0) goto L_0x02f2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x02f2:
            r2.add(r4)
        L_0x02f5:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.HelperWidget
            if (r4 == 0) goto L_0x033a
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r4 == 0) goto L_0x0323
            r4 = r3
            androidx.constraintlayout.core.widgets.Barrier r4 = (androidx.constraintlayout.core.widgets.Barrier) r4
            int r5 = r4.getOrientation()
            if (r5 != 0) goto L_0x0311
            if (r8 != 0) goto L_0x030e
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r8 = r5
        L_0x030e:
            r8.add(r4)
        L_0x0311:
            int r5 = r4.getOrientation()
            r7 = 1
            if (r5 != r7) goto L_0x033a
            if (r13 != 0) goto L_0x031f
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x031f:
            r13.add(r4)
            goto L_0x033a
        L_0x0323:
            r4 = r3
            androidx.constraintlayout.core.widgets.HelperWidget r4 = (androidx.constraintlayout.core.widgets.HelperWidget) r4
            if (r8 != 0) goto L_0x032d
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x032d:
            r8.add(r4)
            if (r13 != 0) goto L_0x0337
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x0337:
            r13.add(r4)
        L_0x033a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0356
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0356
            if (r0 != 0) goto L_0x0356
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r4 != 0) goto L_0x0356
            if (r14 != 0) goto L_0x0353
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0353:
            r14.add(r3)
        L_0x0356:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0378
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0378
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.mBaseline
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x0378
            if (r0 != 0) goto L_0x0378
            boolean r0 = r3 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r0 != 0) goto L_0x0378
            if (r15 != 0) goto L_0x0375
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
        L_0x0375:
            r15.add(r3)
        L_0x0378:
            int r6 = r6 + 1
            r4 = r19
            r3 = r20
            r7 = r21
            r0 = r22
            r5 = r23
            goto L_0x02a0
        L_0x0386:
            r22 = r0
            r20 = r3
            r19 = r4
            r23 = r5
            r21 = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r2 == 0) goto L_0x03ad
            java.util.Iterator r2 = r2.iterator()
        L_0x039b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03ad
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.Guideline r3 = (androidx.constraintlayout.core.widgets.Guideline) r3
            r4 = 0
            r5 = 0
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x039b
        L_0x03ad:
            r4 = 0
            r5 = 0
            if (r8 == 0) goto L_0x03ce
            java.util.Iterator r2 = r8.iterator()
        L_0x03b5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03ce
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            r3.addDependents(r0, r5, r6)
            r6.cleanup(r0)
            r4 = 0
            r5 = 0
            goto L_0x03b5
        L_0x03ce:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x03f0
            java.util.Iterator r2 = r2.iterator()
        L_0x03dc:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03f0
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 0
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x03dc
        L_0x03f0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x0412
            java.util.Iterator r2 = r2.iterator()
        L_0x03fe:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0412
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 0
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x03fe
        L_0x0412:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x0434
            java.util.Iterator r2 = r2.iterator()
        L_0x0420:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0434
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 0
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x0420
        L_0x0434:
            r4 = 0
            r5 = 0
            if (r14 == 0) goto L_0x044c
            java.util.Iterator r2 = r14.iterator()
        L_0x043c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x044c
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x043c
        L_0x044c:
            if (r12 == 0) goto L_0x0463
            java.util.Iterator r2 = r12.iterator()
        L_0x0452:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0463
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.Guideline r3 = (androidx.constraintlayout.core.widgets.Guideline) r3
            r5 = 1
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x0452
        L_0x0463:
            r5 = 1
            if (r13 == 0) goto L_0x0483
            java.util.Iterator r2 = r13.iterator()
        L_0x046a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0483
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            r3.addDependents(r0, r5, r6)
            r6.cleanup(r0)
            r4 = 0
            r5 = 1
            goto L_0x046a
        L_0x0483:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x04a5
            java.util.Iterator r2 = r2.iterator()
        L_0x0491:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04a5
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 1
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x0491
        L_0x04a5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x04c7
            java.util.Iterator r2 = r2.iterator()
        L_0x04b3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c7
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 1
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x04b3
        L_0x04c7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x04e9
            java.util.Iterator r2 = r2.iterator()
        L_0x04d5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04e9
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 1
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x04d5
        L_0x04e9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.getAnchor(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.mDependents
            if (r2 == 0) goto L_0x050b
            java.util.Iterator r2 = r2.iterator()
        L_0x04f7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x050b
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            r4 = 0
            r5 = 1
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x04f7
        L_0x050b:
            r4 = 0
            r5 = 1
            if (r15 == 0) goto L_0x0523
            java.util.Iterator r2 = r15.iterator()
        L_0x0513:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0523
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            a.a.a.a.d.b.findDependents(r3, r5, r0, r4)
            goto L_0x0513
        L_0x0523:
            r2 = 0
        L_0x0524:
            if (r2 >= r11) goto L_0x055c
            java.lang.Object r3 = r10.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r3.mListDimensionBehaviors
            r5 = 0
            r6 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r5) goto L_0x053c
            r6 = 1
            r4 = r4[r6]
            if (r4 != r5) goto L_0x053c
            r4 = 1
            goto L_0x053d
        L_0x053c:
            r4 = 0
        L_0x053d:
            if (r4 == 0) goto L_0x0559
            int r4 = r3.horizontalGroup
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r4 = a.a.a.a.d.b.findGroup(r0, r4)
            int r3 = r3.verticalGroup
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r3 = a.a.a.a.d.b.findGroup(r0, r3)
            if (r4 == 0) goto L_0x0559
            if (r3 == 0) goto L_0x0559
            r5 = 0
            r4.moveTo(r5, r3)
            r5 = 2
            r3.orientation = r5
            r0.remove(r4)
        L_0x0559:
            int r2 = r2 + 1
            goto L_0x0524
        L_0x055c:
            int r2 = r0.size()
            r3 = 1
            if (r2 > r3) goto L_0x0565
            goto L_0x05d9
        L_0x0565:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r24.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x059c
            java.util.Iterator r2 = r0.iterator()
            r3 = 0
            r4 = 0
        L_0x0573:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0591
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r5
            int r6 = r5.orientation
            r7 = 1
            if (r6 != r7) goto L_0x0585
            goto L_0x0573
        L_0x0585:
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem
            r7 = 0
            int r6 = r5.measureWrap(r6, r7)
            if (r6 <= r4) goto L_0x0573
            r3 = r5
            r4 = r6
            goto L_0x0573
        L_0x0591:
            if (r3 == 0) goto L_0x059c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.setHorizontalDimensionBehaviour(r2)
            r1.setWidth(r4)
            goto L_0x059d
        L_0x059c:
            r3 = 0
        L_0x059d:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r24.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r4) goto L_0x05d3
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r4 = 0
        L_0x05ab:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x05c8
            java.lang.Object r5 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r5
            int r6 = r5.orientation
            if (r6 != 0) goto L_0x05bc
            goto L_0x05ab
        L_0x05bc:
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem
            r7 = 1
            int r6 = r5.measureWrap(r6, r7)
            if (r6 <= r4) goto L_0x05ab
            r2 = r5
            r4 = r6
            goto L_0x05ab
        L_0x05c8:
            if (r2 == 0) goto L_0x05d3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1.setVerticalDimensionBehaviour(r0)
            r1.setHeight(r4)
            goto L_0x05d4
        L_0x05d3:
            r2 = 0
        L_0x05d4:
            if (r3 != 0) goto L_0x05db
            if (r2 == 0) goto L_0x05d9
            goto L_0x05db
        L_0x05d9:
            r0 = 0
            goto L_0x05dc
        L_0x05db:
            r0 = 1
        L_0x05dc:
            if (r0 == 0) goto L_0x0620
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r2 = r23
            if (r2 != r0) goto L_0x05fa
            int r0 = r24.getWidth()
            r3 = r22
            if (r3 >= r0) goto L_0x05f5
            if (r3 <= 0) goto L_0x05f5
            r1.setWidth(r3)
            r4 = 1
            r1.mWidthMeasuredTooSmall = r4
            goto L_0x05fc
        L_0x05f5:
            int r0 = r24.getWidth()
            goto L_0x05fd
        L_0x05fa:
            r3 = r22
        L_0x05fc:
            r0 = r3
        L_0x05fd:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r4 = r21
            if (r4 != r3) goto L_0x0619
            int r3 = r24.getHeight()
            r5 = r19
            if (r5 >= r3) goto L_0x0614
            if (r5 <= 0) goto L_0x0614
            r1.setHeight(r5)
            r3 = 1
            r1.mHeightMeasuredTooSmall = r3
            goto L_0x061b
        L_0x0614:
            int r3 = r24.getHeight()
            goto L_0x061c
        L_0x0619:
            r5 = r19
        L_0x061b:
            r3 = r5
        L_0x061c:
            r5 = r3
            r3 = r0
            r0 = 1
            goto L_0x0630
        L_0x0620:
            r5 = r19
            r4 = r21
            r3 = r22
            r2 = r23
            goto L_0x062f
        L_0x0629:
            r20 = r3
            r2 = r5
            r3 = r0
            r5 = r4
            r4 = r7
        L_0x062f:
            r0 = 0
        L_0x0630:
            r6 = 64
            boolean r7 = r1.optimizeFor(r6)
            if (r7 != 0) goto L_0x0643
            r7 = 128(0x80, float:1.8E-43)
            boolean r7 = r1.optimizeFor(r7)
            if (r7 == 0) goto L_0x0641
            goto L_0x0643
        L_0x0641:
            r7 = 0
            goto L_0x0644
        L_0x0643:
            r7 = 1
        L_0x0644:
            androidx.constraintlayout.core.LinearSystem r8 = r1.mSystem
            r9 = 0
            r8.graphOptimizer = r9
            r8.newgraphOptimizer = r9
            int r9 = r1.mOptimizationLevel
            if (r9 == 0) goto L_0x0654
            if (r7 == 0) goto L_0x0654
            r7 = 1
            r8.newgraphOptimizer = r7
        L_0x0654:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r7 = r1.mChildren
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r24.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 == r9) goto L_0x066a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r24.getVerticalDimensionBehaviour()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r9) goto L_0x0667
            goto L_0x066a
        L_0x0667:
            r8 = 0
            r10 = 0
            goto L_0x066c
        L_0x066a:
            r8 = 0
            r10 = 1
        L_0x066c:
            r1.mHorizontalChainsSize = r8
            r1.mVerticalChainsSize = r8
            r9 = r20
            r8 = 0
        L_0x0673:
            if (r8 >= r9) goto L_0x0689
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.mChildren
            java.lang.Object r11 = r11.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r11
            boolean r12 = r11 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r12 == 0) goto L_0x0686
            androidx.constraintlayout.core.widgets.WidgetContainer r11 = (androidx.constraintlayout.core.widgets.WidgetContainer) r11
            r11.layout()
        L_0x0686:
            int r8 = r8 + 1
            goto L_0x0673
        L_0x0689:
            boolean r8 = r1.optimizeFor(r6)
            r11 = r0
            r0 = 0
            r12 = 1
        L_0x0690:
            if (r12 == 0) goto L_0x08f3
            r13 = 1
            int r14 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0778 }
            r0.reset()     // Catch:{ Exception -> 0x0778 }
            r13 = 0
            r1.mHorizontalChainsSize = r13     // Catch:{ Exception -> 0x0778 }
            r1.mVerticalChainsSize = r13     // Catch:{ Exception -> 0x0778 }
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0778 }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x0778 }
            r0 = 0
        L_0x06a5:
            if (r0 >= r9) goto L_0x06b7
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r13 = r1.mChildren     // Catch:{ Exception -> 0x0778 }
            java.lang.Object r13 = r13.get(r0)     // Catch:{ Exception -> 0x0778 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13     // Catch:{ Exception -> 0x0778 }
            androidx.constraintlayout.core.LinearSystem r15 = r1.mSystem     // Catch:{ Exception -> 0x0778 }
            r13.createObjectVariables(r15)     // Catch:{ Exception -> 0x0778 }
            int r0 = r0 + 1
            goto L_0x06a5
        L_0x06b7:
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0778 }
            r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x0778 }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMin     // Catch:{ Exception -> 0x076a }
            r12 = 5
            if (r0 == 0) goto L_0x06e8
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMin     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x06e8
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMin     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r1.mTop     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r13 = r13.createObjectVariable(r15)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r15 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r0 = r15.createObjectVariable(r0)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r15 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            r6 = 0
            r15.addGreaterThan(r0, r13, r6, r12)     // Catch:{ Exception -> 0x076a }
            r6 = 0
            r1.verticalWrapMin = r6     // Catch:{ Exception -> 0x0775 }
        L_0x06e8:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMax     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x0713
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMax     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x0713
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.verticalWrapMax     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r1.mBottom     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r13)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r0 = r13.createObjectVariable(r0)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            r15 = 0
            r13.addGreaterThan(r6, r0, r15, r12)     // Catch:{ Exception -> 0x076a }
            r6 = 0
            r1.verticalWrapMax = r6     // Catch:{ Exception -> 0x0775 }
        L_0x0713:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMin     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x073e
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMin     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x073e
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMin     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r1.mLeft     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r13)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r0 = r13.createObjectVariable(r0)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            r15 = 0
            r13.addGreaterThan(r0, r6, r15, r12)     // Catch:{ Exception -> 0x076a }
            r6 = 0
            r1.horizontalWrapMin = r6     // Catch:{ Exception -> 0x0775 }
        L_0x073e:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMax     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x076d
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMax     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            if (r0 == 0) goto L_0x076d
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.horizontalWrapMax     // Catch:{ Exception -> 0x076a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r6 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r1.mRight     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r6 = r6.createObjectVariable(r13)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.SolverVariable r0 = r13.createObjectVariable(r0)     // Catch:{ Exception -> 0x076a }
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem     // Catch:{ Exception -> 0x076a }
            r15 = 0
            r13.addGreaterThan(r6, r0, r15, r12)     // Catch:{ Exception -> 0x076a }
            r6 = 0
            r1.horizontalWrapMax = r6     // Catch:{ Exception -> 0x0775 }
            goto L_0x076e
        L_0x076a:
            r0 = move-exception
            r6 = 0
            goto L_0x0776
        L_0x076d:
            r6 = 0
        L_0x076e:
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0775 }
            r0.minimize()     // Catch:{ Exception -> 0x0775 }
            r12 = 1
            goto L_0x0793
        L_0x0775:
            r0 = move-exception
        L_0x0776:
            r12 = 1
            goto L_0x077a
        L_0x0778:
            r0 = move-exception
            r6 = 0
        L_0x077a:
            r0.printStackTrace()
            java.io.PrintStream r13 = java.lang.System.out
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "EXCEPTION : "
            r15.append(r6)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r13.println(r0)
        L_0x0793:
            if (r12 == 0) goto L_0x07dc
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.flags
            r12 = 2
            r13 = 0
            r6[r12] = r13
            r6 = 64
            boolean r12 = r1.optimizeFor(r6)
            r1.updateFromSolver(r0, r12)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r13 = r1.mChildren
            int r13 = r13.size()
            r15 = 0
            r19 = 0
        L_0x07af:
            if (r15 >= r13) goto L_0x07da
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.mChildren
            java.lang.Object r6 = r6.get(r15)
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6
            r6.updateFromSolver(r0, r12)
            r21 = r0
            int r0 = r6.mWidthOverride
            r22 = r12
            r12 = -1
            if (r0 != r12) goto L_0x07cc
            int r0 = r6.mHeightOverride
            if (r0 == r12) goto L_0x07ca
            goto L_0x07cc
        L_0x07ca:
            r0 = 0
            goto L_0x07cd
        L_0x07cc:
            r0 = 1
        L_0x07cd:
            if (r0 == 0) goto L_0x07d1
            r19 = 1
        L_0x07d1:
            int r15 = r15 + 1
            r0 = r21
            r12 = r22
            r6 = 64
            goto L_0x07af
        L_0x07da:
            r12 = -1
            goto L_0x07f7
        L_0x07dc:
            r12 = -1
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            r1.updateFromSolver(r0, r8)
            r0 = 0
        L_0x07e3:
            if (r0 >= r9) goto L_0x07f5
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.mChildren
            java.lang.Object r6 = r6.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6
            androidx.constraintlayout.core.LinearSystem r13 = r1.mSystem
            r6.updateFromSolver(r13, r8)
            int r0 = r0 + 1
            goto L_0x07e3
        L_0x07f5:
            r19 = 0
        L_0x07f7:
            r0 = 8
            if (r10 == 0) goto L_0x0868
            if (r14 >= r0) goto L_0x0868
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.flags
            r13 = 2
            boolean r6 = r6[r13]
            if (r6 == 0) goto L_0x0868
            r6 = 0
            r12 = 0
            r15 = 0
        L_0x0807:
            if (r6 >= r9) goto L_0x082e
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r13 = r1.mChildren
            java.lang.Object r13 = r13.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            int r0 = r13.mX
            int r22 = r13.getWidth()
            int r0 = r22 + r0
            int r15 = java.lang.Math.max(r15, r0)
            int r0 = r13.mY
            int r13 = r13.getHeight()
            int r13 = r13 + r0
            int r12 = java.lang.Math.max(r12, r13)
            int r6 = r6 + 1
            r0 = 8
            r13 = 2
            goto L_0x0807
        L_0x082e:
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r15)
            int r6 = r1.mMinHeight
            int r6 = java.lang.Math.max(r6, r12)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r12) goto L_0x0851
            int r12 = r24.getWidth()
            if (r12 >= r0) goto L_0x0851
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r12 = 0
            r0[r12] = r11
            r11 = 1
            r19 = 1
        L_0x0851:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r0) goto L_0x0868
            int r0 = r24.getHeight()
            if (r0 >= r6) goto L_0x0868
            r1.setHeight(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r11 = 1
            r0[r11] = r6
            r11 = 1
            r19 = 1
        L_0x0868:
            int r0 = r1.mMinWidth
            int r6 = r24.getWidth()
            int r0 = java.lang.Math.max(r0, r6)
            int r6 = r24.getWidth()
            if (r0 <= r6) goto L_0x0885
            r1.setWidth(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r11 = 0
            r0[r11] = r6
            r11 = 1
            r19 = 1
        L_0x0885:
            int r0 = r1.mMinHeight
            int r6 = r24.getHeight()
            int r0 = java.lang.Math.max(r0, r6)
            int r6 = r24.getHeight()
            if (r0 <= r6) goto L_0x08a3
            r1.setHeight(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12 = 1
            r0[r12] = r6
            r11 = 1
            r19 = 1
            goto L_0x08a4
        L_0x08a3:
            r12 = 1
        L_0x08a4:
            if (r11 != 0) goto L_0x08e6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r6 = 0
            r0 = r0[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x08c5
            if (r3 <= 0) goto L_0x08c5
            int r0 = r24.getWidth()
            if (r0 <= r3) goto L_0x08c5
            r1.mWidthMeasuredTooSmall = r12
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r11
            r1.setWidth(r3)
            r11 = 1
            r19 = 1
        L_0x08c5:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r0 = r0[r12]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r6) goto L_0x08e6
            if (r5 <= 0) goto L_0x08e6
            int r0 = r24.getHeight()
            if (r0 <= r5) goto L_0x08e6
            r1.mHeightMeasuredTooSmall = r12
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r12] = r6
            r1.setHeight(r5)
            r0 = 8
            r11 = 1
            r19 = 1
            goto L_0x08e8
        L_0x08e6:
            r0 = 8
        L_0x08e8:
            if (r14 <= r0) goto L_0x08ec
            r12 = 0
            goto L_0x08ee
        L_0x08ec:
            r12 = r19
        L_0x08ee:
            r0 = r14
            r6 = 64
            goto L_0x0690
        L_0x08f3:
            r1.mChildren = r7
            if (r11 == 0) goto L_0x08ff
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r3 = 0
            r0[r3] = r2
            r2 = 1
            r0[r2] = r4
        L_0x08ff:
            androidx.constraintlayout.core.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.core.Cache r0 = r0.mCache
            r1.resetSolverVariables(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.layout():void");
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        super.reset();
    }

    public void setMeasurer(Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.mMeasurer = measurer;
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromRuns(z, z2);
        }
    }
}
