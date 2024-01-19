package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;

public abstract class WidgetRun implements Dependency {
    public DimensionDependency dimension = new DimensionDependency(this);
    public DimensionBehaviour dimensionBehavior;
    public DependencyNode end = new DependencyNode(this);
    public RunType mRunType = RunType.NONE;
    public int matchConstraintsType;
    public int orientation = 0;
    public boolean resolved = false;
    public RunGroup runGroup;
    public DependencyNode start = new DependencyNode(this);
    public ConstraintWidget widget;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        int i3;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i4 = constraintWidget.mMatchConstraintMaxWidth;
            i3 = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i4 > 0) {
                i3 = Math.min(i4, i);
            }
            if (i3 == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i5 = constraintWidget2.mMatchConstraintMaxHeight;
            int max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i5 > 0) {
                max = Math.min(i5, i);
            }
            if (i3 == i) {
                return i;
            }
        }
        return i3;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        DependencyNode dependencyNode = null;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int ordinal = constraintAnchor2.mType.ordinal();
        if (ordinal == 1) {
            dependencyNode = constraintWidget.horizontalRun.start;
        } else if (ordinal == 2) {
            dependencyNode = constraintWidget.verticalRun.start;
        } else if (ordinal == 3) {
            dependencyNode = constraintWidget.horizontalRun.end;
        } else if (ordinal == 4) {
            dependencyNode = constraintWidget.verticalRun.end;
        } else if (ordinal == 5) {
            dependencyNode = constraintWidget.verticalRun.baseline;
        }
        return dependencyNode;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return (long) dimensionDependency.value;
        }
        return 0;
    }

    public abstract boolean supportsWrapComputation();

    public void update(Dependency dependency) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r4.matchConstraintsType == 3) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateRunCenter(androidx.constraintlayout.core.widgets.ConstraintAnchor r11, androidx.constraintlayout.core.widgets.ConstraintAnchor r12, int r13) {
        /*
            r10 = this;
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.getTarget(r11)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.getTarget(r12)
            boolean r2 = r0.resolved
            if (r2 == 0) goto L_0x010d
            boolean r2 = r1.resolved
            if (r2 != 0) goto L_0x0012
            goto L_0x010d
        L_0x0012:
            int r2 = r0.value
            int r11 = r11.getMargin()
            int r11 = r11 + r2
            int r2 = r1.value
            int r12 = r12.getMargin()
            int r2 = r2 - r12
            int r12 = r2 - r11
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r10.dimension
            boolean r4 = r3.resolved
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r4 != 0) goto L_0x00c6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r10.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x00c6
            int r4 = r10.matchConstraintsType
            if (r4 == 0) goto L_0x00bf
            r7 = 1
            if (r4 == r7) goto L_0x00af
            r3 = 2
            if (r4 == r3) goto L_0x0080
            r3 = 3
            if (r4 == r3) goto L_0x003f
            goto L_0x00c6
        L_0x003f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r10.widget
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r8 = r4.horizontalRun
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r8.dimensionBehavior
            if (r9 != r6) goto L_0x0057
            int r8 = r8.matchConstraintsType
            if (r8 != r3) goto L_0x0057
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.verticalRun
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r4.dimensionBehavior
            if (r8 != r6) goto L_0x0057
            int r4 = r4.matchConstraintsType
            if (r4 != r3) goto L_0x0057
            goto L_0x00c6
        L_0x0057:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.widget
            if (r13 != 0) goto L_0x005e
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r3.verticalRun
            goto L_0x0060
        L_0x005e:
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r3.horizontalRun
        L_0x0060:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.dimension
            boolean r4 = r3.resolved
            if (r4 == 0) goto L_0x00c6
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r10.widget
            float r4 = r4.mDimensionRatio
            if (r13 != r7) goto L_0x0073
            int r3 = r3.value
            float r3 = (float) r3
            float r3 = r3 / r4
            float r3 = r3 + r5
            int r3 = (int) r3
            goto L_0x007a
        L_0x0073:
            int r3 = r3.value
            float r3 = (float) r3
            float r4 = r4 * r3
            float r4 = r4 + r5
            int r3 = (int) r4
        L_0x007a:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r10.dimension
            r4.resolve(r3)
            goto L_0x00c6
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.widget
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mParent
            if (r3 == 0) goto L_0x00c6
            if (r13 != 0) goto L_0x008b
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r3.horizontalRun
            goto L_0x008d
        L_0x008b:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r3.verticalRun
        L_0x008d:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r3.dimension
            boolean r4 = r4.resolved
            if (r4 == 0) goto L_0x00c6
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r10.widget
            if (r13 != 0) goto L_0x009a
            float r4 = r4.mMatchConstraintPercentWidth
            goto L_0x009c
        L_0x009a:
            float r4 = r4.mMatchConstraintPercentHeight
        L_0x009c:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.dimension
            int r3 = r3.value
            float r3 = (float) r3
            float r3 = r3 * r4
            float r3 = r3 + r5
            int r3 = (int) r3
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r10.dimension
            int r3 = r10.getLimitedDimension(r3, r13)
            r4.resolve(r3)
            goto L_0x00c6
        L_0x00af:
            int r3 = r3.wrapValue
            int r3 = r10.getLimitedDimension(r3, r13)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r10.dimension
            int r3 = java.lang.Math.min(r3, r12)
            r4.resolve(r3)
            goto L_0x00c6
        L_0x00bf:
            int r4 = r10.getLimitedDimension(r12, r13)
            r3.resolve(r4)
        L_0x00c6:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r10.dimension
            boolean r4 = r3.resolved
            if (r4 != 0) goto L_0x00cd
            return
        L_0x00cd:
            int r3 = r3.value
            if (r3 != r12) goto L_0x00dc
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r10.start
            r12.resolve(r11)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r10.end
            r11.resolve(r2)
            return
        L_0x00dc:
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r10.widget
            if (r13 != 0) goto L_0x00e3
            float r12 = r12.mHorizontalBiasPercent
            goto L_0x00e5
        L_0x00e3:
            float r12 = r12.mVerticalBiasPercent
        L_0x00e5:
            if (r0 != r1) goto L_0x00ed
            int r11 = r0.value
            int r2 = r1.value
            r12 = 1056964608(0x3f000000, float:0.5)
        L_0x00ed:
            int r2 = r2 - r11
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r13 = r10.dimension
            int r13 = r13.value
            int r2 = r2 - r13
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r10.start
            float r11 = (float) r11
            float r11 = r11 + r5
            float r0 = (float) r2
            float r0 = r0 * r12
            float r0 = r0 + r11
            int r11 = (int) r0
            r13.resolve(r11)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r10.end
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r10.start
            int r12 = r12.value
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r13 = r10.dimension
            int r13 = r13.value
            int r12 = r12 + r13
            r11.resolve(r12)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.updateRunCenter(androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int):void");
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        DependencyNode dependencyNode = null;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int ordinal = constraintAnchor.mTarget.mType.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            dependencyNode = widgetRun.start;
        } else if (ordinal == 3 || ordinal == 4) {
            dependencyNode = widgetRun.end;
        }
        return dependencyNode;
    }
}
