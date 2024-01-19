package androidx.constraintlayout.core.widgets.analyzer;

import a.a.a.a.d.b;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.ct.C.SegmentationChapterSelectionFromChapterList;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;

public class WidgetGroup {
    public static int count;
    public int id = -1;
    public int moveTo = -1;
    public int orientation = 0;
    public ArrayList<MeasureResult> results = null;
    public ArrayList<ConstraintWidget> widgets = new ArrayList<>();

    public class MeasureResult {
        public MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            new WeakReference(constraintWidget);
            linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            linearSystem.getObjectVariableValue(constraintWidget.mTop);
            linearSystem.getObjectVariableValue(constraintWidget.mRight);
            linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
        }
    }

    public WidgetGroup(int i) {
        int i2 = count;
        count = i2 + 1;
        this.id = i2;
        this.orientation = i;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.widgets.contains(constraintWidget)) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.widgets.size();
        if (this.moveTo != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.moveTo == widgetGroup.id) {
                    moveTo(this.orientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        if (this.widgets.size() == 0) {
            return 0;
        }
        ArrayList<ConstraintWidget> arrayList = this.widgets;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).mParent;
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).addToSolver(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            b.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            b.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.results = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.results.add(new MeasureResult(this, arrayList.get(i5), linearSystem, i));
        }
        if (i == 0) {
            i2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            i3 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            i2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            i3 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return i3 - i2;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i == 0) {
                next.horizontalGroup = widgetGroup.id;
            } else {
                next.verticalGroup = widgetGroup.id;
            }
        }
        this.moveTo = widgetGroup.id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.orientation;
        sb.append(i == 0 ? SegmentationChapterSelectionFromChapterList.HORIZONTAL : i == 1 ? SegmentationChapterSelectionFromChapterList.VERTICAL : i == 2 ? PDTableAttributeObject.SCOPE_BOTH : Constants.DOWNLOAD_STATUS_UNKNOWN);
        sb.append(" [");
        String outline57 = GeneratedOutlineSupport.outline57(sb, this.id, "] <");
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(outline57, CMap.SPACE);
            outline78.append(it.next().mDebugName);
            outline57 = outline78.toString();
        }
        return GeneratedOutlineSupport.outline50(outline57, " >");
    }
}
