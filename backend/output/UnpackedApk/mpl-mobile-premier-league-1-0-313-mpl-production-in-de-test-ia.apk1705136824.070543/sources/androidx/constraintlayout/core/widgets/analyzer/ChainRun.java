package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    public int chainStyle;
    public ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        Object obj;
        int i2;
        Object obj2;
        super(constraintWidget);
        this.orientation = i;
        ConstraintWidget constraintWidget3 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(i);
        while (true) {
            ConstraintWidget constraintWidget4 = previousChainMember;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            }
            previousChainMember = constraintWidget3.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget2;
        ArrayList<WidgetRun> arrayList = this.widgets;
        int i3 = this.orientation;
        if (i3 == 0) {
            obj = constraintWidget2.horizontalRun;
        } else {
            obj = i3 == 1 ? constraintWidget2.verticalRun : null;
        }
        arrayList.add(obj);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            ArrayList<WidgetRun> arrayList2 = this.widgets;
            int i4 = this.orientation;
            if (i4 == 0) {
                obj2 = nextChainMember.horizontalRun;
            } else {
                obj2 = i4 == 1 ? nextChainMember.verticalRun : null;
            }
            arrayList2.add(obj2);
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i5 = this.orientation;
            if (i5 == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i5 == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.mParent).mIsRtl) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList3 = this.widgets;
            this.widget = arrayList3.get(arrayList3.size() - 1).widget;
        }
        if (this.orientation == 0) {
            i2 = this.widget.mHorizontalChainStyle;
        } else {
            i2 = this.widget.mVerticalChainStyle;
        }
        this.chainStyle = i2;
    }

    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    DependencyNode dependencyNode = this.start;
                    dependencyNode.targets.add(target);
                    dependencyNode.margin = margin;
                    target.dependencies.add(dependencyNode);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    DependencyNode dependencyNode2 = this.end;
                    dependencyNode2.targets.add(target2);
                    dependencyNode2.margin = -margin2;
                    target2.dependencies.add(dependencyNode2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    DependencyNode dependencyNode3 = this.start;
                    dependencyNode3.targets.add(target3);
                    dependencyNode3.margin = margin3;
                    target3.dependencies.add(dependencyNode3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    DependencyNode dependencyNode4 = this.end;
                    dependencyNode4.targets.add(target4);
                    dependencyNode4.margin = -margin4;
                    target4.dependencies.add(dependencyNode4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            ConstraintWidget constraintWidget = this.widgets.get(i).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public final ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = this.widgets.get(size).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = ((long) widgetRun.end.margin) + widgetRun.getWrapDimension() + j + ((long) widgetRun.start.margin);
        }
        return j;
    }

    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c3, code lost:
        if (r3.dimension.resolved != false) goto L_0x00c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r24) {
        /*
            r23 = this;
            r0 = r23
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x03f0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0010
            goto L_0x03f0
        L_0x0010:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.widget
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.mParent
            boolean r2 = r1 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x001d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            boolean r1 = r1.mIsRtl
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r0.end
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r0.start
            int r4 = r4.value
            int r2 = r2 - r4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r0.widgets
            int r4 = r4.size()
            r5 = 0
        L_0x002e:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x0044
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r8 = r0.widgets
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.widget
            int r8 = r8.mVisibility
            if (r8 != r7) goto L_0x0045
            int r5 = r5 + 1
            goto L_0x002e
        L_0x0044:
            r5 = -1
        L_0x0045:
            int r8 = r4 + -1
            r9 = r8
        L_0x0048:
            if (r9 < 0) goto L_0x005c
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.widget
            int r10 = r10.mVisibility
            if (r10 != r7) goto L_0x005b
            int r9 = r9 + -1
            goto L_0x0048
        L_0x005b:
            r6 = r9
        L_0x005c:
            r9 = 0
        L_0x005d:
            r11 = 2
            r12 = 1
            if (r9 >= r11) goto L_0x00fa
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0068:
            if (r13 >= r4) goto L_0x00ec
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r0.widgets
            java.lang.Object r3 = r3.get(r13)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.widget
            int r11 = r11.mVisibility
            if (r11 != r7) goto L_0x007a
            goto L_0x00e5
        L_0x007a:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0085
            if (r13 < r5) goto L_0x0085
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r3.start
            int r11 = r11.margin
            int r14 = r14 + r11
        L_0x0085:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r3.dimension
            int r11 = r11.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r3.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 == r10) goto L_0x0091
            r7 = 1
            goto L_0x0092
        L_0x0091:
            r7 = 0
        L_0x0092:
            if (r7 == 0) goto L_0x00b2
            int r10 = r0.orientation
            if (r10 != 0) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r3.widget
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r10 = r10.horizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r10.dimension
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x00a3
            return
        L_0x00a3:
            int r10 = r0.orientation
            if (r10 != r12) goto L_0x00c6
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r3.widget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r10 = r10.verticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r10.dimension
            boolean r10 = r10.resolved
            if (r10 != 0) goto L_0x00c6
            return
        L_0x00b2:
            int r10 = r3.matchConstraintsType
            if (r10 != r12) goto L_0x00bf
            if (r9 != 0) goto L_0x00bf
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r3.dimension
            int r11 = r7.wrapValue
            int r15 = r15 + 1
            goto L_0x00c5
        L_0x00bf:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r3.dimension
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x00c6
        L_0x00c5:
            r7 = 1
        L_0x00c6:
            if (r7 != 0) goto L_0x00da
            int r15 = r15 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.widget
            float[] r7 = r7.mWeight
            int r10 = r0.orientation
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00db
            float r17 = r17 + r7
            goto L_0x00db
        L_0x00da:
            int r14 = r14 + r11
        L_0x00db:
            if (r13 >= r8) goto L_0x00e5
            if (r13 >= r6) goto L_0x00e5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.end
            int r3 = r3.margin
            int r3 = -r3
            int r14 = r14 + r3
        L_0x00e5:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x0068
        L_0x00ec:
            if (r14 < r2) goto L_0x00f7
            if (r15 != 0) goto L_0x00f1
            goto L_0x00f7
        L_0x00f1:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x005d
        L_0x00f7:
            r3 = r16
            goto L_0x00ff
        L_0x00fa:
            r3 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x00ff:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.start
            int r7 = r7.value
            if (r1 == 0) goto L_0x0109
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.end
            int r7 = r7.value
        L_0x0109:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r2) goto L_0x0120
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x0119
            int r11 = r14 - r2
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 + r10
            goto L_0x0120
        L_0x0119:
            int r11 = r14 - r2
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 - r10
        L_0x0120:
            if (r15 <= 0) goto L_0x0203
            int r10 = r2 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r13 = 0
            r16 = 0
        L_0x012d:
            if (r13 >= r4) goto L_0x01ba
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r12 = r0.widgets
            java.lang.Object r12 = r12.get(r13)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r12 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r12
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r12.widget
            r18 = r11
            int r11 = r9.mVisibility
            r19 = r14
            r14 = 8
            if (r11 != r14) goto L_0x0145
            goto L_0x01a7
        L_0x0145:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r12.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r14) goto L_0x01a7
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r12.dimension
            boolean r11 = r11.resolved
            if (r11 != 0) goto L_0x01a7
            r11 = 0
            int r14 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x0165
            float[] r9 = r9.mWeight
            int r14 = r0.orientation
            r9 = r9[r14]
            float r9 = r9 * r10
            float r9 = r9 / r17
            r14 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r14
            int r9 = (int) r9
            goto L_0x0167
        L_0x0165:
            r9 = r18
        L_0x0167:
            int r14 = r0.orientation
            if (r14 != 0) goto L_0x0174
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r12.widget
            int r11 = r14.mMatchConstraintMaxWidth
            int r14 = r14.mMatchConstraintMinWidth
            r20 = r10
            goto L_0x0181
        L_0x0174:
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r12.widget
            int r14 = r11.mMatchConstraintMaxHeight
            int r11 = r11.mMatchConstraintMinHeight
            r20 = r10
            r22 = r14
            r14 = r11
            r11 = r22
        L_0x0181:
            int r10 = r12.matchConstraintsType
            r21 = r7
            r7 = 1
            if (r10 != r7) goto L_0x0191
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r12.dimension
            int r7 = r7.wrapValue
            int r7 = java.lang.Math.min(r9, r7)
            goto L_0x0192
        L_0x0191:
            r7 = r9
        L_0x0192:
            int r7 = java.lang.Math.max(r14, r7)
            if (r11 <= 0) goto L_0x019c
            int r7 = java.lang.Math.min(r11, r7)
        L_0x019c:
            if (r7 == r9) goto L_0x01a1
            int r16 = r16 + 1
            r9 = r7
        L_0x01a1:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r12.dimension
            r7.resolve(r9)
            goto L_0x01ab
        L_0x01a7:
            r21 = r7
            r20 = r10
        L_0x01ab:
            int r13 = r13 + 1
            r11 = r18
            r14 = r19
            r10 = r20
            r7 = r21
            r9 = 1056964608(0x3f000000, float:0.5)
            r12 = 1
            goto L_0x012d
        L_0x01ba:
            r21 = r7
            r19 = r14
            if (r16 <= 0) goto L_0x01f4
            int r15 = r15 - r16
            r7 = 0
            r9 = 0
        L_0x01c4:
            if (r7 >= r4) goto L_0x01f2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r10 = r10.get(r7)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r10.widget
            int r11 = r11.mVisibility
            r12 = 8
            if (r11 != r12) goto L_0x01d7
            goto L_0x01ef
        L_0x01d7:
            if (r7 <= 0) goto L_0x01e0
            if (r7 < r5) goto L_0x01e0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r10.start
            int r11 = r11.margin
            int r9 = r9 + r11
        L_0x01e0:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r10.dimension
            int r11 = r11.value
            int r9 = r9 + r11
            if (r7 >= r8) goto L_0x01ef
            if (r7 >= r6) goto L_0x01ef
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.end
            int r10 = r10.margin
            int r10 = -r10
            int r9 = r9 + r10
        L_0x01ef:
            int r7 = r7 + 1
            goto L_0x01c4
        L_0x01f2:
            r14 = r9
            goto L_0x01f6
        L_0x01f4:
            r14 = r19
        L_0x01f6:
            int r7 = r0.chainStyle
            r9 = 2
            if (r7 != r9) goto L_0x0201
            if (r16 != 0) goto L_0x0201
            r7 = 0
            r0.chainStyle = r7
            goto L_0x0209
        L_0x0201:
            r7 = 0
            goto L_0x0209
        L_0x0203:
            r21 = r7
            r19 = r14
            r7 = 0
            r9 = 2
        L_0x0209:
            if (r14 <= r2) goto L_0x020d
            r0.chainStyle = r9
        L_0x020d:
            if (r3 <= 0) goto L_0x0215
            if (r15 != 0) goto L_0x0215
            if (r5 != r6) goto L_0x0215
            r0.chainStyle = r9
        L_0x0215:
            int r9 = r0.chainStyle
            r10 = 1
            if (r9 != r10) goto L_0x02b4
            if (r3 <= r10) goto L_0x0220
            int r2 = r2 - r14
            int r3 = r3 - r10
            int r2 = r2 / r3
            goto L_0x0227
        L_0x0220:
            if (r3 != r10) goto L_0x0226
            int r2 = r2 - r14
            r3 = 2
            int r2 = r2 / r3
            goto L_0x0227
        L_0x0226:
            r2 = 0
        L_0x0227:
            if (r15 <= 0) goto L_0x022a
            r2 = 0
        L_0x022a:
            r7 = r21
            r3 = 0
        L_0x022d:
            if (r3 >= r4) goto L_0x03f0
            if (r1 == 0) goto L_0x0236
            int r9 = r3 + 1
            int r9 = r4 - r9
            goto L_0x0237
        L_0x0236:
            r9 = r3
        L_0x0237:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r9.widget
            int r10 = r10.mVisibility
            r11 = 8
            if (r10 != r11) goto L_0x0252
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            r9.resolve(r7)
            goto L_0x02b0
        L_0x0252:
            if (r3 <= 0) goto L_0x0259
            if (r1 == 0) goto L_0x0258
            int r7 = r7 - r2
            goto L_0x0259
        L_0x0258:
            int r7 = r7 + r2
        L_0x0259:
            if (r3 <= 0) goto L_0x026a
            if (r3 < r5) goto L_0x026a
            if (r1 == 0) goto L_0x0265
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            int r10 = r10.margin
            int r7 = r7 - r10
            goto L_0x026a
        L_0x0265:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            int r10 = r10.margin
            int r7 = r7 + r10
        L_0x026a:
            if (r1 == 0) goto L_0x0272
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.end
            r10.resolve(r7)
            goto L_0x0277
        L_0x0272:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
        L_0x0277:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r9.dimension
            int r11 = r10.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r9.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r13) goto L_0x0288
            int r12 = r9.matchConstraintsType
            r13 = 1
            if (r12 != r13) goto L_0x0288
            int r11 = r10.wrapValue
        L_0x0288:
            if (r1 == 0) goto L_0x028c
            int r7 = r7 - r11
            goto L_0x028d
        L_0x028c:
            int r7 = r7 + r11
        L_0x028d:
            if (r1 == 0) goto L_0x0295
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
            goto L_0x029a
        L_0x0295:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.end
            r10.resolve(r7)
        L_0x029a:
            r10 = 1
            r9.resolved = r10
            if (r3 >= r8) goto L_0x02b0
            if (r3 >= r6) goto L_0x02b0
            if (r1 == 0) goto L_0x02aa
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            int r9 = r9.margin
            int r9 = -r9
            int r7 = r7 - r9
            goto L_0x02b0
        L_0x02aa:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            int r9 = r9.margin
            int r9 = -r9
            int r7 = r7 + r9
        L_0x02b0:
            int r3 = r3 + 1
            goto L_0x022d
        L_0x02b4:
            if (r9 != 0) goto L_0x0346
            int r2 = r2 - r14
            r9 = 1
            int r3 = r3 + r9
            int r2 = r2 / r3
            if (r15 <= 0) goto L_0x02bd
            r2 = 0
        L_0x02bd:
            r7 = r21
            r3 = 0
        L_0x02c0:
            if (r3 >= r4) goto L_0x03f0
            if (r1 == 0) goto L_0x02c9
            int r9 = r3 + 1
            int r9 = r4 - r9
            goto L_0x02ca
        L_0x02c9:
            r9 = r3
        L_0x02ca:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r9.widget
            int r10 = r10.mVisibility
            r11 = 8
            if (r10 != r11) goto L_0x02e5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            r9.resolve(r7)
            goto L_0x0342
        L_0x02e5:
            if (r1 == 0) goto L_0x02e9
            int r7 = r7 - r2
            goto L_0x02ea
        L_0x02e9:
            int r7 = r7 + r2
        L_0x02ea:
            if (r3 <= 0) goto L_0x02fb
            if (r3 < r5) goto L_0x02fb
            if (r1 == 0) goto L_0x02f6
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            int r10 = r10.margin
            int r7 = r7 - r10
            goto L_0x02fb
        L_0x02f6:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            int r10 = r10.margin
            int r7 = r7 + r10
        L_0x02fb:
            if (r1 == 0) goto L_0x0303
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.end
            r10.resolve(r7)
            goto L_0x0308
        L_0x0303:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
        L_0x0308:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r10 = r9.dimension
            int r11 = r10.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r9.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r13) goto L_0x031d
            int r12 = r9.matchConstraintsType
            r13 = 1
            if (r12 != r13) goto L_0x031d
            int r10 = r10.wrapValue
            int r11 = java.lang.Math.min(r11, r10)
        L_0x031d:
            if (r1 == 0) goto L_0x0321
            int r7 = r7 - r11
            goto L_0x0322
        L_0x0321:
            int r7 = r7 + r11
        L_0x0322:
            if (r1 == 0) goto L_0x032a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.start
            r10.resolve(r7)
            goto L_0x032f
        L_0x032a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r9.end
            r10.resolve(r7)
        L_0x032f:
            if (r3 >= r8) goto L_0x0342
            if (r3 >= r6) goto L_0x0342
            if (r1 == 0) goto L_0x033c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            int r9 = r9.margin
            int r9 = -r9
            int r7 = r7 - r9
            goto L_0x0342
        L_0x033c:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.end
            int r9 = r9.margin
            int r9 = -r9
            int r7 = r7 + r9
        L_0x0342:
            int r3 = r3 + 1
            goto L_0x02c0
        L_0x0346:
            r3 = 2
            if (r9 != r3) goto L_0x03f0
            int r3 = r0.orientation
            if (r3 != 0) goto L_0x0352
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.widget
            float r3 = r3.mHorizontalBiasPercent
            goto L_0x0356
        L_0x0352:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.widget
            float r3 = r3.mVerticalBiasPercent
        L_0x0356:
            if (r1 == 0) goto L_0x035c
            r9 = 1065353216(0x3f800000, float:1.0)
            float r3 = r9 - r3
        L_0x035c:
            int r2 = r2 - r14
            float r2 = (float) r2
            float r2 = r2 * r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            int r2 = (int) r2
            if (r2 < 0) goto L_0x0368
            if (r15 <= 0) goto L_0x0369
        L_0x0368:
            r2 = 0
        L_0x0369:
            if (r1 == 0) goto L_0x036e
            int r2 = r21 - r2
            goto L_0x0370
        L_0x036e:
            int r2 = r21 + r2
        L_0x0370:
            r3 = 0
        L_0x0371:
            if (r3 >= r4) goto L_0x03f0
            if (r1 == 0) goto L_0x037a
            int r7 = r3 + 1
            int r7 = r4 - r7
            goto L_0x037b
        L_0x037a:
            r7 = r3
        L_0x037b:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r7 = r9.get(r7)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.widget
            int r9 = r9.mVisibility
            r10 = 8
            if (r9 != r10) goto L_0x0397
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            r7.resolve(r2)
            r13 = 1
            goto L_0x03ed
        L_0x0397:
            if (r3 <= 0) goto L_0x03a8
            if (r3 < r5) goto L_0x03a8
            if (r1 == 0) goto L_0x03a3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.margin
            int r2 = r2 - r9
            goto L_0x03a8
        L_0x03a3:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.margin
            int r2 = r2 + r9
        L_0x03a8:
            if (r1 == 0) goto L_0x03b0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r2)
            goto L_0x03b5
        L_0x03b0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r2)
        L_0x03b5:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r7.dimension
            int r11 = r9.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r7.dimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r13) goto L_0x03c7
            int r12 = r7.matchConstraintsType
            r13 = 1
            if (r12 != r13) goto L_0x03c8
            int r11 = r9.wrapValue
            goto L_0x03c8
        L_0x03c7:
            r13 = 1
        L_0x03c8:
            if (r1 == 0) goto L_0x03cc
            int r2 = r2 - r11
            goto L_0x03cd
        L_0x03cc:
            int r2 = r2 + r11
        L_0x03cd:
            if (r1 == 0) goto L_0x03d5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r2)
            goto L_0x03da
        L_0x03d5:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r2)
        L_0x03da:
            if (r3 >= r8) goto L_0x03ed
            if (r3 >= r6) goto L_0x03ed
            if (r1 == 0) goto L_0x03e7
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.margin
            int r7 = -r7
            int r2 = r2 - r7
            goto L_0x03ed
        L_0x03e7:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.margin
            int r7 = -r7
            int r2 = r2 + r7
        L_0x03ed:
            int r3 = r3 + 1
            goto L_0x0371
        L_0x03f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
