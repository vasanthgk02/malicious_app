package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode.Type;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType;
import com.android.tools.r8.GeneratedOutlineSupport;

public class HorizontalWidgetRun extends WidgetRun {
    public static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = Type.LEFT;
        this.end.type = Type.RIGHT;
        this.orientation = 0;
    }

    public void apply() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getWidth());
        }
        if (!this.dimension.resolved) {
            DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                if (horizontalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT) {
                    ConstraintWidget constraintWidget2 = this.widget.mParent;
                    if (constraintWidget2 != null && (constraintWidget2.getHorizontalDimensionBehaviour() == DimensionBehaviour.FIXED || constraintWidget2.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_PARENT)) {
                        int width = (constraintWidget2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                        addTarget(this.start, constraintWidget2.horizontalRun.start, this.widget.mLeft.getMargin());
                        addTarget(this.end, constraintWidget2.horizontalRun.end, -this.widget.mRight.getMargin());
                        this.dimension.resolve(width);
                        return;
                    }
                }
                if (this.dimensionBehavior == DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == DimensionBehaviour.MATCH_PARENT) {
            ConstraintWidget constraintWidget3 = this.widget.mParent;
            if (constraintWidget3 != null && (constraintWidget3.getHorizontalDimensionBehaviour() == DimensionBehaviour.FIXED || constraintWidget3.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_PARENT)) {
                addTarget(this.start, constraintWidget3.horizontalRun.start, this.widget.mLeft.getMargin());
                addTarget(this.end, constraintWidget3.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
        }
        if (this.dimension.resolved) {
            ConstraintWidget constraintWidget4 = this.widget;
            if (constraintWidget4.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget4.mListAnchors;
                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                    ConstraintWidget constraintWidget5 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
                    if (constraintAnchorArr2[0].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr2[0]);
                        if (target != null) {
                            DependencyNode dependencyNode = this.start;
                            int margin = this.widget.mListAnchors[0].getMargin();
                            dependencyNode.targets.add(target);
                            dependencyNode.margin = margin;
                            target.dependencies.add(dependencyNode);
                            addTarget(this.end, this.start, this.dimension.value);
                        }
                    } else if (constraintAnchorArr2[1].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr2[1]);
                        if (target2 != null) {
                            DependencyNode dependencyNode2 = this.end;
                            dependencyNode2.targets.add(target2);
                            dependencyNode2.margin = -this.widget.mListAnchors[1].getMargin();
                            target2.dependencies.add(dependencyNode2);
                            addTarget(this.start, this.end, -this.dimension.value);
                        }
                    } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.mParent != null && constraintWidget5.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        ConstraintWidget constraintWidget6 = this.widget;
                        addTarget(this.start, constraintWidget6.mParent.horizontalRun.start, constraintWidget6.getX());
                        addTarget(this.end, this.start, this.dimension.value);
                    }
                }
                if (constraintWidget4.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                } else {
                    DependencyNode target3 = getTarget(this.widget.mListAnchors[0]);
                    if (target3 != null) {
                        DependencyNode dependencyNode3 = this.start;
                        int margin2 = this.widget.mListAnchors[0].getMargin();
                        dependencyNode3.targets.add(target3);
                        dependencyNode3.margin = margin2;
                        target3.dependencies.add(dependencyNode3);
                    }
                    DependencyNode target4 = getTarget(this.widget.mListAnchors[1]);
                    if (target4 != null) {
                        DependencyNode dependencyNode4 = this.end;
                        dependencyNode4.targets.add(target4);
                        dependencyNode4.margin = -this.widget.mListAnchors[1].getMargin();
                        target4.dependencies.add(dependencyNode4);
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }
            }
        }
        if (this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget7 = this.widget;
            int i = constraintWidget7.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget constraintWidget8 = constraintWidget7.mParent;
                if (constraintWidget8 != null) {
                    DimensionDependency dimensionDependency = constraintWidget8.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency);
                    dimensionDependency.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency2 = this.dimension;
                    dimensionDependency2.delegateToWidgetRun = true;
                    dimensionDependency2.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3) {
                if (constraintWidget7.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget7.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    this.dimension.updateDelegate = this;
                    if (constraintWidget7.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        this.dimension.targets.add(verticalWidgetRun2.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                    }
                } else {
                    DimensionDependency dimensionDependency3 = constraintWidget7.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency4 = this.dimension;
                    dimensionDependency4.delegateToWidgetRun = true;
                    dimensionDependency4.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    this.end.targets.add(this.dimension);
                }
            }
        }
        ConstraintWidget constraintWidget9 = this.widget;
        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget9.mListAnchors;
        if (constraintAnchorArr3[0].mTarget == null || constraintAnchorArr3[1].mTarget == null) {
            ConstraintWidget constraintWidget10 = this.widget;
            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget10.mListAnchors;
            if (constraintAnchorArr4[0].mTarget != null) {
                DependencyNode target5 = getTarget(constraintAnchorArr4[0]);
                if (target5 != null) {
                    DependencyNode dependencyNode5 = this.start;
                    int margin3 = this.widget.mListAnchors[0].getMargin();
                    dependencyNode5.targets.add(target5);
                    dependencyNode5.margin = margin3;
                    target5.dependencies.add(dependencyNode5);
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (constraintAnchorArr4[1].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr4[1]);
                if (target6 != null) {
                    DependencyNode dependencyNode6 = this.end;
                    dependencyNode6.targets.add(target6);
                    dependencyNode6.margin = -this.widget.mListAnchors[1].getMargin();
                    target6.dependencies.add(dependencyNode6);
                    addTarget(this.start, this.end, -1, this.dimension);
                }
            } else if (!(constraintWidget10 instanceof Helper)) {
                ConstraintWidget constraintWidget11 = constraintWidget10.mParent;
                if (constraintWidget11 != null) {
                    addTarget(this.start, constraintWidget11.horizontalRun.start, constraintWidget10.getX());
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            }
        }
        if (constraintWidget9.isInHorizontalChain()) {
            this.start.margin = this.widget.mListAnchors[0].getMargin();
            this.end.margin = -this.widget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.widget.mListAnchors[1]);
            if (target7 != null) {
                target7.dependencies.add(this);
                if (target7.resolved) {
                    update(this);
                }
            }
            if (target8 != null) {
                target8.dependencies.add(this);
                if (target8.resolved) {
                    update(this);
                }
            }
            this.mRunType = RunType.CENTER;
        }
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mX = dependencyNode.value;
        }
    }

    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public final void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f2) + 0.5f);
            int i9 = (int) ((((float) i6) / f2) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f2) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f2) + 0.5f);
        }
    }

    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HorizontalRun ");
        outline73.append(this.widget.mDebugName);
        return outline73.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x029a, code lost:
        if (r14 != 1) goto L_0x02fc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            r16 = this;
            r8 = r16
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r0 = r8.mRunType
            int r0 = r0.ordinal()
            r9 = 1
            r10 = 0
            r1 = 2
            r2 = 3
            if (r0 == r9) goto L_0x001d
            if (r0 == r1) goto L_0x001d
            if (r0 == r2) goto L_0x0013
            goto L_0x001d
        L_0x0013:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mRight
            r8.updateRunCenter(r1, r0, r10)
            return
        L_0x001d:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            boolean r3 = r0.resolved
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r3 != 0) goto L_0x02fc
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r8.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x02fc
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r8.widget
            int r4 = r3.mMatchConstraintDefaultWidth
            if (r4 == r1) goto L_0x02e4
            if (r4 == r2) goto L_0x0035
            goto L_0x02fc
        L_0x0035:
            int r0 = r3.mMatchConstraintDefaultHeight
            r1 = -1
            if (r0 == 0) goto L_0x0070
            if (r0 != r2) goto L_0x003d
            goto L_0x0070
        L_0x003d:
            int r0 = r3.mDimensionRatioSide
            if (r0 == r1) goto L_0x005c
            if (r0 == 0) goto L_0x0051
            if (r0 == r9) goto L_0x0047
            r0 = 0
            goto L_0x0069
        L_0x0047:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r3.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int r0 = r0.value
            float r0 = (float) r0
            float r1 = r3.mDimensionRatio
            goto L_0x0065
        L_0x0051:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r3.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int r0 = r0.value
            float r0 = (float) r0
            float r1 = r3.mDimensionRatio
            float r0 = r0 / r1
            goto L_0x0067
        L_0x005c:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r3.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int r0 = r0.value
            float r0 = (float) r0
            float r1 = r3.mDimensionRatio
        L_0x0065:
            float r0 = r0 * r1
        L_0x0067:
            float r0 = r0 + r11
            int r0 = (int) r0
        L_0x0069:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.dimension
            r1.resolve(r0)
            goto L_0x02fc
        L_0x0070:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r2.start
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r2.end
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x0080
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r8.widget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x008b
            r2 = 1
            goto L_0x008c
        L_0x008b:
            r2 = 0
        L_0x008c:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r8.widget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0096
            r3 = 1
            goto L_0x0097
        L_0x0096:
            r3 = 0
        L_0x0097:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.widget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x00a1
            r4 = 1
            goto L_0x00a2
        L_0x00a1:
            r4 = 0
        L_0x00a2:
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r8.widget
            int r14 = r5.mDimensionRatioSide
            if (r0 == 0) goto L_0x01e5
            if (r2 == 0) goto L_0x01e5
            if (r3 == 0) goto L_0x01e5
            if (r4 == 0) goto L_0x01e5
            float r15 = r5.mDimensionRatio
            boolean r0 = r12.resolved
            if (r0 == 0) goto L_0x0113
            boolean r0 = r13.resolved
            if (r0 == 0) goto L_0x0113
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x0112
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 != 0) goto L_0x00c5
            goto L_0x0112
        L_0x00c5:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.margin
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.margin
            int r3 = r0 - r1
            int r0 = r12.value
            int r1 = r12.margin
            int r4 = r0 + r1
            int r0 = r13.value
            int r1 = r13.margin
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
        L_0x0112:
            return
        L_0x0113:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.resolved
            if (r1 == 0) goto L_0x0170
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x0170
            boolean r2 = r12.readyToSolve
            if (r2 == 0) goto L_0x016f
            boolean r2 = r13.readyToSolve
            if (r2 != 0) goto L_0x0128
            goto L_0x016f
        L_0x0128:
            int r2 = r0.value
            int r0 = r0.margin
            int r2 = r2 + r0
            int r0 = r1.value
            int r1 = r1.margin
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.margin
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.margin
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x0170
        L_0x016f:
            return
        L_0x0170:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x01e4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r1 = r1.readyToSolve
            if (r1 == 0) goto L_0x01e4
            boolean r1 = r12.readyToSolve
            if (r1 == 0) goto L_0x01e4
            boolean r1 = r13.readyToSolve
            if (r1 != 0) goto L_0x0185
            goto L_0x01e4
        L_0x0185:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.margin
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            int r1 = r1.margin
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r12.margin
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            int r1 = r13.margin
            int r5 = r0 - r1
            int[] r1 = tempDimensions
            r0 = r16
            r6 = r15
            r7 = r14
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            int[] r1 = tempDimensions
            r1 = r1[r10]
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            int[] r1 = tempDimensions
            r1 = r1[r9]
            r0.resolve(r1)
            goto L_0x02fc
        L_0x01e4:
            return
        L_0x01e5:
            if (r0 == 0) goto L_0x026b
            if (r3 == 0) goto L_0x026b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r2 = r0.readyToSolve
            if (r2 == 0) goto L_0x026a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            boolean r2 = r2.readyToSolve
            if (r2 != 0) goto L_0x01f6
            goto L_0x026a
        L_0x01f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r8.widget
            float r2 = r2.mDimensionRatio
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.start
            int r3 = r3.margin
            int r0 = r0 + r3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r3.targets
            java.lang.Object r3 = r3.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r3
            int r3 = r3.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.end
            int r4 = r4.margin
            int r3 = r3 - r4
            if (r14 == r1) goto L_0x0246
            if (r14 == 0) goto L_0x0246
            if (r14 == r9) goto L_0x0222
            goto L_0x02fc
        L_0x0222:
            int r3 = r3 - r0
            int r0 = r8.getLimitedDimension(r3, r10)
            float r1 = (float) r0
            float r1 = r1 / r2
            float r1 = r1 + r11
            int r1 = (int) r1
            int r3 = r8.getLimitedDimension(r1, r9)
            if (r1 == r3) goto L_0x0236
            float r0 = (float) r3
            float r0 = r0 * r2
            float r0 = r0 + r11
            int r0 = (int) r0
        L_0x0236:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.dimension
            r1.resolve(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            r0.resolve(r3)
            goto L_0x02fc
        L_0x0246:
            int r3 = r3 - r0
            int r0 = r8.getLimitedDimension(r3, r10)
            float r1 = (float) r0
            float r1 = r1 * r2
            float r1 = r1 + r11
            int r1 = (int) r1
            int r3 = r8.getLimitedDimension(r1, r9)
            if (r1 == r3) goto L_0x025a
            float r0 = (float) r3
            float r0 = r0 / r2
            float r0 = r0 + r11
            int r0 = (int) r0
        L_0x025a:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.dimension
            r1.resolve(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            r0.resolve(r3)
            goto L_0x02fc
        L_0x026a:
            return
        L_0x026b:
            if (r2 == 0) goto L_0x02fc
            if (r4 == 0) goto L_0x02fc
            boolean r0 = r12.readyToSolve
            if (r0 == 0) goto L_0x02e3
            boolean r0 = r13.readyToSolve
            if (r0 != 0) goto L_0x0278
            goto L_0x02e3
        L_0x0278:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            float r0 = r0.mDimensionRatio
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r12.targets
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r3 = r12.margin
            int r2 = r2 + r3
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r13.targets
            java.lang.Object r3 = r3.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r3
            int r3 = r3.value
            int r4 = r13.margin
            int r3 = r3 - r4
            if (r14 == r1) goto L_0x02c0
            if (r14 == 0) goto L_0x029d
            if (r14 == r9) goto L_0x02c0
            goto L_0x02fc
        L_0x029d:
            int r3 = r3 - r2
            int r1 = r8.getLimitedDimension(r3, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r10)
            if (r2 == r3) goto L_0x02b1
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02b1:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            r0.resolve(r1)
            goto L_0x02fc
        L_0x02c0:
            int r3 = r3 - r2
            int r1 = r8.getLimitedDimension(r3, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.getLimitedDimension(r2, r10)
            if (r2 == r3) goto L_0x02d4
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02d4:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            r0.resolve(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.dimension
            r0.resolve(r1)
            goto L_0x02fc
        L_0x02e3:
            return
        L_0x02e4:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r3.mParent
            if (r1 == 0) goto L_0x02fc
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r1.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.dimension
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x02fc
            float r2 = r3.mMatchConstraintPercentWidth
            int r1 = r1.value
            float r1 = (float) r1
            float r1 = r1 * r2
            float r1 = r1 + r11
            int r1 = (int) r1
            r0.resolve(r1)
        L_0x02fc:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            boolean r1 = r0.readyToSolve
            if (r1 == 0) goto L_0x041b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            boolean r2 = r1.readyToSolve
            if (r2 != 0) goto L_0x030a
            goto L_0x041b
        L_0x030a:
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x0319
            boolean r0 = r1.resolved
            if (r0 == 0) goto L_0x0319
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x0319
            return
        L_0x0319:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x0363
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0363
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.widget
            int r1 = r0.mMatchConstraintDefaultWidth
            if (r1 != 0) goto L_0x0363
            boolean r0 = r0.isInHorizontalChain()
            if (r0 != 0) goto L_0x0363
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.targets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r3 = r2.margin
            int r0 = r0 + r3
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.end
            int r3 = r3.margin
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.resolve(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            r0.resolve(r3)
            return
        L_0x0363:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03c7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03c7
            int r0 = r8.matchConstraintsType
            if (r0 != r9) goto L_0x03c7
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03c7
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03c7
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.targets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.start
            int r2 = r2.margin
            int r0 = r0 + r2
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.end
            int r2 = r2.margin
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            int r0 = r0.wrapValue
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.widget
            int r2 = r1.mMatchConstraintMaxWidth
            int r1 = r1.mMatchConstraintMinWidth
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03c2
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03c2:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.dimension
            r1.resolve(r0)
        L_0x03c7:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x03ce
            return
        L_0x03ce:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.targets
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.targets
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.start
            int r3 = r3.margin
            int r3 = r3 + r2
            int r4 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r8.end
            int r5 = r5.margin
            int r5 = r5 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r8.widget
            float r6 = r6.mHorizontalBiasPercent
            if (r0 != r1) goto L_0x03f9
            r6 = 1056964608(0x3f000000, float:0.5)
            goto L_0x03fb
        L_0x03f9:
            r2 = r3
            r4 = r5
        L_0x03fb:
            int r4 = r4 - r2
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.dimension
            int r0 = r0.value
            int r4 = r4 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r4
            float r2 = r2 * r6
            float r2 = r2 + r1
            int r1 = (int) r2
            r0.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.start
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r8.dimension
            int r2 = r2.value
            int r1 = r1 + r2
            r0.resolve(r1)
        L_0x041b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
