package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton.OnCheckedChangeListener;
import com.google.android.material.button.MaterialButton.OnPressedChangeListener;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    public static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public static final String LOG_TAG = MaterialButtonToggleGroup.class.getSimpleName();
    public int checkedId;
    public final CheckedStateTracker checkedStateTracker;
    public Integer[] childOrder;
    public final Comparator<MaterialButton> childOrderComparator;
    public final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    public final List<CornerData> originalCornerData;
    public final PressedStateTracker pressedStateTracker;
    public boolean selectionRequired;
    public boolean singleSelection;
    public boolean skipCheckedStateTracker;

    public class CheckedStateTracker implements OnCheckedChangeListener {
        public CheckedStateTracker(AnonymousClass1 r2) {
        }

        public void onCheckedChanged(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (!materialButtonToggleGroup.skipCheckedStateTracker) {
                if (materialButtonToggleGroup.singleSelection) {
                    materialButtonToggleGroup.checkedId = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.dispatchOnButtonChecked(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    public static class CornerData {
        public static final CornerSize noCorner = new AbsoluteCornerSize(0.0f);
        public CornerSize bottomLeft;
        public CornerSize bottomRight;
        public CornerSize topLeft;
        public CornerSize topRight;

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    public class PressedStateTracker implements OnPressedChangeListener {
        public PressedStateTracker(AnonymousClass1 r2) {
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    public static int access$200(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        if (materialButtonToggleGroup == null) {
            throw null;
        } else if (!(view instanceof MaterialButton)) {
            return -1;
        } else {
            int i = 0;
            for (int i2 = 0; i2 < materialButtonToggleGroup.getChildCount(); i2++) {
                if (materialButtonToggleGroup.getChildAt(i2) == view) {
                    return i;
                }
                if ((materialButtonToggleGroup.getChildAt(i2) instanceof MaterialButton) && materialButtonToggleGroup.isChildVisible(i2)) {
                    i++;
                }
            }
            return -1;
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        this.checkedId = i;
        dispatchOnButtonChecked(i, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.onCheckedChangeListeners.add(this.checkedStateTracker);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                updateCheckedStates(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.originalCornerData.add(new CornerData(shapeAppearanceModel.topLeftCornerSize, shapeAppearanceModel.bottomLeftCornerSize, shapeAppearanceModel.topRightCornerSize, shapeAppearanceModel.bottomRightCornerSize));
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.access$200(MaterialButtonToggleGroup.this, view), 1, false, ((MaterialButton) view).isChecked()));
                }
            });
        }
    }

    public final void adjustChildMarginsAndUpdateLayout() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
                MaterialButton childButton = getChildButton(i);
                int min = Math.min(childButton.getStrokeWidth(), getChildButton(i - 1).getStrokeWidth());
                LayoutParams layoutParams2 = childButton.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                }
                if (getOrientation() == 0) {
                    layoutParams.setMarginEnd(0);
                    layoutParams.setMarginStart(-min);
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = -min;
                    layoutParams.setMarginStart(0);
                }
                childButton.setLayoutParams(layoutParams);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                } else {
                    layoutParams3.setMarginEnd(0);
                    layoutParams3.setMarginStart(0);
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                }
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void dispatchOnButtonChecked(int i, boolean z) {
        Iterator it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            ((OnButtonCheckedListener) it.next()).onButtonChecked(this, i, z);
        }
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.isChecked()) {
                arrayList.add(Integer.valueOf(childButton.getId()));
            }
        }
        return arrayList;
    }

    public final MaterialButton getChildButton(int i) {
        return (MaterialButton) getChildAt(i);
    }

    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    public final boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            MaterialButton materialButton = (MaterialButton) findViewById(i);
            if (materialButton != null) {
                materialButton.setChecked(true);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((CollectionInfo) CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, this.singleSelection ? 1 : 2).mInfo);
    }

    public void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.onCheckedChangeListeners.remove(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalCornerData.remove(indexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public final void setCheckedStateForView(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.skipCheckedStateTracker = false;
        }
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            this.skipCheckedStateTracker = true;
            for (int i = 0; i < getChildCount(); i++) {
                MaterialButton childButton = getChildButton(i);
                childButton.setChecked(false);
                dispatchOnButtonChecked(childButton.getId(), false);
            }
            this.skipCheckedStateTracker = false;
            setCheckedId(-1);
        }
    }

    public final boolean updateCheckedStates(int i, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.selectionRequired || !checkedButtonIds.isEmpty()) {
            if (z && this.singleSelection) {
                checkedButtonIds.remove(Integer.valueOf(i));
                for (Integer intValue : checkedButtonIds) {
                    int intValue2 = intValue.intValue();
                    setCheckedStateForView(intValue2, false);
                    dispatchOnButtonChecked(intValue2, false);
                }
            }
            return true;
        }
        setCheckedStateForView(i, true);
        this.checkedId = i;
        return false;
    }

    public void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.getVisibility() != 8) {
                ShapeAppearanceModel shapeAppearanceModel = childButton.getShapeAppearanceModel();
                CornerData cornerData = null;
                if (shapeAppearanceModel != null) {
                    Builder builder = new Builder(shapeAppearanceModel);
                    CornerData cornerData2 = this.originalCornerData.get(i);
                    if (firstVisibleChildIndex == lastVisibleChildIndex) {
                        cornerData = cornerData2;
                    } else {
                        boolean z = getOrientation() == 0;
                        if (i == firstVisibleChildIndex) {
                            if (!z) {
                                CornerSize cornerSize = cornerData2.topLeft;
                                CornerSize cornerSize2 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize, cornerSize2, cornerData2.topRight, cornerSize2);
                            } else if (ImageOriginUtils.isLayoutRtl(this)) {
                                CornerSize cornerSize3 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize3, cornerSize3, cornerData2.topRight, cornerData2.bottomRight);
                            } else {
                                CornerSize cornerSize4 = cornerData2.topLeft;
                                CornerSize cornerSize5 = cornerData2.bottomLeft;
                                CornerSize cornerSize6 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize4, cornerSize5, cornerSize6, cornerSize6);
                            }
                        } else if (i == lastVisibleChildIndex) {
                            if (!z) {
                                CornerSize cornerSize7 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize7, cornerData2.bottomLeft, cornerSize7, cornerData2.bottomRight);
                            } else if (ImageOriginUtils.isLayoutRtl(this)) {
                                CornerSize cornerSize8 = cornerData2.topLeft;
                                CornerSize cornerSize9 = cornerData2.bottomLeft;
                                CornerSize cornerSize10 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize8, cornerSize9, cornerSize10, cornerSize10);
                            } else {
                                CornerSize cornerSize11 = CornerData.noCorner;
                                cornerData = new CornerData(cornerSize11, cornerSize11, cornerData2.topRight, cornerData2.bottomRight);
                            }
                        }
                    }
                    if (cornerData == null) {
                        builder.setAllCornerSizes(0.0f);
                    } else {
                        builder.topLeftCornerSize = cornerData.topLeft;
                        builder.bottomLeftCornerSize = cornerData.bottomLeft;
                        builder.topRightCornerSize = cornerData.topRight;
                        builder.bottomRightCornerSize = cornerData.bottomRight;
                    }
                    childButton.setShapeAppearanceModel(builder.build());
                } else {
                    throw null;
                }
            }
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.originalCornerData = new ArrayList();
        this.checkedStateTracker = new CheckedStateTracker(null);
        this.pressedStateTracker = new PressedStateTracker(null);
        this.onButtonCheckedListeners = new LinkedHashSet<>();
        this.childOrderComparator = new Comparator<MaterialButton>() {
            public int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
            }
        };
        this.skipCheckedStateTracker = false;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i, DEF_STYLE_RES, new int[0]);
        setSingleSelection(obtainStyledAttributes.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = obtainStyledAttributes.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = obtainStyledAttributes.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        obtainStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
