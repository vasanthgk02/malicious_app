package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    public ConstraintWidgetContainer container;
    public ConstraintWidgetContainer mContainer;
    public ArrayList<RunGroup> mGroups;
    public Measure mMeasure;
    public Measurer mMeasurer;
    public boolean mNeedBuildGraph = true;
    public boolean mNeedRedoMeasures = true;
    public ArrayList<WidgetRun> mRuns = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new Measure();
        this.mGroups = new ArrayList<>();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    public final void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun != constraintWidgetContainer.horizontalRun && widgetRun != constraintWidgetContainer.verticalRun) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i2);
                    arrayList.add(runGroup);
                }
                widgetRun.runGroup = runGroup;
                runGroup.runs.add(widgetRun);
                for (Dependency next : widgetRun.start.dependencies) {
                    if (next instanceof DependencyNode) {
                        applyGroup((DependencyNode) next, i, 0, dependencyNode2, arrayList, runGroup);
                    }
                }
                for (Dependency next2 : widgetRun.end.dependencies) {
                    if (next2 instanceof DependencyNode) {
                        applyGroup((DependencyNode) next2, i, 1, dependencyNode2, arrayList, runGroup);
                    }
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency next3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                        if (next3 instanceof DependencyNode) {
                            applyGroup((DependencyNode) next3, i, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
                for (DependencyNode applyGroup : widgetRun.start.targets) {
                    applyGroup(applyGroup, i, 0, dependencyNode2, arrayList, runGroup);
                }
                for (DependencyNode applyGroup2 : widgetRun.end.targets) {
                    applyGroup(applyGroup2, i, 1, dependencyNode2, arrayList, runGroup);
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode applyGroup3 : ((VerticalWidgetRun) widgetRun).baseline.targets) {
                        applyGroup(applyGroup3, i, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    public final boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        int i2;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
            if (next.mVisibility == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.mDimensionRatio > 0.0f) {
                    if (dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else {
                        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
                            if (next.mMatchConstraintDefaultWidth == 0) {
                                next.mMatchConstraintDefaultWidth = 3;
                            }
                            if (next.mMatchConstraintDefaultHeight == 0) {
                                next.mMatchConstraintDefaultHeight = 3;
                            }
                        }
                    }
                }
                if (dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                }
                DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour;
                if (dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                }
                DimensionBehaviour dimensionBehaviour5 = dimensionBehaviour2;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour4;
                horizontalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour5;
                verticalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                if ((dimensionBehaviour4 == DimensionBehaviour.MATCH_PARENT || dimensionBehaviour4 == DimensionBehaviour.FIXED || dimensionBehaviour4 == DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour5 == DimensionBehaviour.MATCH_PARENT || dimensionBehaviour5 == DimensionBehaviour.FIXED || dimensionBehaviour5 == DimensionBehaviour.WRAP_CONTENT)) {
                    int width = next.getWidth();
                    if (dimensionBehaviour4 == DimensionBehaviour.MATCH_PARENT) {
                        i = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour4 = DimensionBehaviour.FIXED;
                    } else {
                        i = width;
                    }
                    int height = next.getHeight();
                    if (dimensionBehaviour5 == DimensionBehaviour.MATCH_PARENT) {
                        i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour5 = DimensionBehaviour.FIXED;
                    } else {
                        i2 = height;
                    }
                    measure(next, dimensionBehaviour4, i, dimensionBehaviour5, i2);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour4 == DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour5 == DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == DimensionBehaviour.FIXED)) {
                        int i3 = next.mMatchConstraintDefaultWidth;
                        if (i3 == 3) {
                            DimensionBehaviour dimensionBehaviour6 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour5 == dimensionBehaviour6) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            int height2 = next.getHeight();
                            DimensionBehaviour dimensionBehaviour7 = DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour7, (int) ((((float) height2) * next.mDimensionRatio) + 0.5f), dimensionBehaviour7, height2);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            measure(next, DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else if (i3 == 2) {
                            DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr2[0] == DimensionBehaviour.FIXED || dimensionBehaviourArr2[0] == DimensionBehaviour.MATCH_PARENT) {
                                int height3 = next.getHeight();
                                ConstraintWidget constraintWidget = next;
                                measure(constraintWidget, DimensionBehaviour.FIXED, (int) ((next.mMatchConstraintPercentWidth * ((float) constraintWidgetContainer.getWidth())) + 0.5f), dimensionBehaviour5, height3);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour5 == DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == DimensionBehaviour.FIXED)) {
                        int i4 = next.mMatchConstraintDefaultHeight;
                        if (i4 == 3) {
                            DimensionBehaviour dimensionBehaviour8 = DimensionBehaviour.WRAP_CONTENT;
                            if (dimensionBehaviour4 == dimensionBehaviour8) {
                                measure(next, dimensionBehaviour8, 0, dimensionBehaviour8, 0);
                            }
                            int width2 = next.getWidth();
                            float f2 = next.mDimensionRatio;
                            if (next.mDimensionRatioSide == -1) {
                                f2 = 1.0f / f2;
                            }
                            DimensionBehaviour dimensionBehaviour9 = DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour9, width2, dimensionBehaviour9, (int) ((((float) width2) * f2) + 0.5f));
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i4 == 1) {
                            measure(next, dimensionBehaviour4, 0, DimensionBehaviour.WRAP_CONTENT, 0);
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i4 == 2) {
                            DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr3[1] == DimensionBehaviour.FIXED || dimensionBehaviourArr3[1] == DimensionBehaviour.MATCH_PARENT) {
                                float f3 = next.mMatchConstraintPercentHeight;
                                ConstraintWidget constraintWidget2 = next;
                                measure(constraintWidget2, dimensionBehaviour4, next.getWidth(), DimensionBehaviour.FIXED, (int) ((f3 * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(next, DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour5, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    DimensionBehaviour dimensionBehaviour10 = DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour10 && dimensionBehaviour5 == dimensionBehaviour10) {
                        int i5 = next.mMatchConstraintDefaultWidth;
                        if (i5 != 1) {
                            int i6 = next.mMatchConstraintDefaultHeight;
                            if (i6 != 1) {
                                if (i6 == 2 && i5 == 2) {
                                    DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                                    DimensionBehaviour dimensionBehaviour11 = dimensionBehaviourArr4[0];
                                    DimensionBehaviour dimensionBehaviour12 = DimensionBehaviour.FIXED;
                                    if (dimensionBehaviour11 == dimensionBehaviour12 && dimensionBehaviourArr4[1] == dimensionBehaviour12) {
                                        float f4 = next.mMatchConstraintPercentWidth;
                                        float f5 = next.mMatchConstraintPercentHeight;
                                        int width3 = (int) ((f4 * ((float) constraintWidgetContainer.getWidth())) + 0.5f);
                                        int height4 = (int) ((f5 * ((float) constraintWidgetContainer.getHeight())) + 0.5f);
                                        DimensionBehaviour dimensionBehaviour13 = DimensionBehaviour.FIXED;
                                        measure(next, dimensionBehaviour13, width3, dimensionBehaviour13, height4);
                                        next.horizontalRun.dimension.resolve(next.getWidth());
                                        next.verticalRun.dimension.resolve(next.getHeight());
                                        next.measured = true;
                                    }
                                }
                            }
                        }
                        DimensionBehaviour dimensionBehaviour14 = DimensionBehaviour.WRAP_CONTENT;
                        measure(next, dimensionBehaviour14, 0, dimensionBehaviour14, 0);
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    }
                }
            }
        }
        return false;
    }

    public void buildGraph() {
        ArrayList<WidgetRun> arrayList = this.mRuns;
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public final int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        float f2;
        DependencyGraph dependencyGraph = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i2 = i;
        int size = dependencyGraph.mGroups.size();
        long j = 0;
        long j2 = 0;
        int i3 = 0;
        while (i3 < size) {
            RunGroup runGroup = dependencyGraph.mGroups.get(i3);
            WidgetRun widgetRun = runGroup.firstRun;
            if (widgetRun instanceof ChainRun) {
                if (((ChainRun) widgetRun).orientation != i2) {
                    continue;
                    j = Math.max(j, j2);
                    i3++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (i2 == 0) {
                if (!(widgetRun instanceof HorizontalWidgetRun)) {
                    continue;
                    j = Math.max(j, j2);
                    i3++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (!(widgetRun instanceof VerticalWidgetRun)) {
                continue;
                j = Math.max(j, j2);
                i3++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            }
            DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).start;
            DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).end;
            boolean contains = runGroup.firstRun.start.targets.contains(dependencyNode);
            boolean contains2 = runGroup.firstRun.end.targets.contains(dependencyNode2);
            long wrapDimension = runGroup.firstRun.getWrapDimension();
            if (!contains || !contains2) {
                if (contains) {
                    DependencyNode dependencyNode3 = runGroup.firstRun.start;
                    j2 = Math.max(runGroup.traverseStart(dependencyNode3, (long) dependencyNode3.margin), ((long) runGroup.firstRun.start.margin) + wrapDimension);
                } else if (contains2) {
                    DependencyNode dependencyNode4 = runGroup.firstRun.end;
                    j2 = Math.max(-runGroup.traverseEnd(dependencyNode4, (long) dependencyNode4.margin), ((long) (-runGroup.firstRun.end.margin)) + wrapDimension);
                } else {
                    WidgetRun widgetRun2 = runGroup.firstRun;
                    j2 = (widgetRun2.getWrapDimension() + ((long) widgetRun2.start.margin)) - ((long) runGroup.firstRun.end.margin);
                }
                j = Math.max(j, j2);
                i3++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            } else {
                long traverseStart = runGroup.traverseStart(runGroup.firstRun.start, j2);
                long traverseEnd = runGroup.traverseEnd(runGroup.firstRun.end, j2);
                long j3 = traverseStart - wrapDimension;
                int i4 = runGroup.firstRun.end.margin;
                if (j3 >= ((long) (-i4))) {
                    j3 += (long) i4;
                }
                long j4 = (long) runGroup.firstRun.start.margin;
                long j5 = ((-traverseEnd) - wrapDimension) - j4;
                if (j5 >= j4) {
                    j5 -= j4;
                }
                ConstraintWidget constraintWidget = runGroup.firstRun.widget;
                if (constraintWidget != null) {
                    if (i2 == 0) {
                        f2 = constraintWidget.mHorizontalBiasPercent;
                    } else {
                        f2 = i2 == 1 ? constraintWidget.mVerticalBiasPercent : -1.0f;
                    }
                    float f3 = (float) (f2 > 0.0f ? (long) ((((float) j3) / (1.0f - f2)) + (((float) j5) / f2)) : 0);
                    long outline3 = ((long) ((f3 * f2) + 0.5f)) + wrapDimension + ((long) GeneratedOutlineSupport.outline3(1.0f, f2, f3, 0.5f));
                    WidgetRun widgetRun3 = runGroup.firstRun;
                    j2 = (((long) widgetRun3.start.margin) + outline3) - ((long) widgetRun3.end.margin);
                    j = Math.max(j, j2);
                    i3++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                } else {
                    throw null;
                }
            }
        }
        return (int) j;
    }

    public final void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency next : widgetRun.start.dependencies) {
            if (next instanceof DependencyNode) {
                applyGroup((DependencyNode) next, i, 0, widgetRun.end, arrayList, null);
            } else if (next instanceof WidgetRun) {
                applyGroup(((WidgetRun) next).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency next2 : widgetRun.end.dependencies) {
            if (next2 instanceof DependencyNode) {
                applyGroup((DependencyNode) next2, i, 1, widgetRun.start, arrayList, null);
            } else if (next2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) next2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency next3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (next3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) next3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void measure(ConstraintWidget constraintWidget, DimensionBehaviour dimensionBehaviour, int i, DimensionBehaviour dimensionBehaviour2, int i2) {
        Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        ((ConstraintLayout.Measurer) this.mMeasurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        Measure measure2 = this.mMeasure;
        constraintWidget.hasBaseline = measure2.measuredHasBaseline;
        constraintWidget.setBaselineDistance(measure2.measuredBaseline);
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                boolean z2 = dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency = next.horizontalRun.dimension;
                boolean z3 = dimensionDependency.resolved;
                DimensionDependency dimensionDependency2 = next.verticalRun.dimension;
                boolean z4 = dimensionDependency2.resolved;
                if (z3 && z4) {
                    DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour3, dimensionDependency.value, dimensionBehaviour3, dimensionDependency2.value);
                    next.measured = true;
                } else if (z3 && z) {
                    measure(next, DimensionBehaviour.FIXED, next.horizontalRun.dimension.value, DimensionBehaviour.WRAP_CONTENT, next.verticalRun.dimension.value);
                    if (dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z2) {
                    measure(next, DimensionBehaviour.WRAP_CONTENT, next.horizontalRun.dimension.value, DimensionBehaviour.FIXED, next.verticalRun.dimension.value);
                    if (dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured) {
                    DimensionDependency dimensionDependency3 = next.verticalRun.baselineDimension;
                    if (dimensionDependency3 != null) {
                        dimensionDependency3.resolve(next.mBaselineDistance);
                    }
                }
            }
        }
    }
}
