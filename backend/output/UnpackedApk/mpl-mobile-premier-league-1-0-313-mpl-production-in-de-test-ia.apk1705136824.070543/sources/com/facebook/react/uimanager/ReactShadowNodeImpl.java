package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConfigJNIBase;
import com.facebook.yoga.YogaConfigJNIFinalizer;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeJNIBase;
import com.facebook.yoga.YogaNodeJNIFinalizer;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    public static final YogaConfigJNIBase sYogaConfig = ImageOriginUtils.YOGA_CONFIG;
    public ArrayList<ReactShadowNodeImpl> mChildren;
    public final Spacing mDefaultPadding = new Spacing(0.0f);
    public Integer mHeightMeasureSpec;
    public boolean mIsLayoutOnly;
    public ReactShadowNodeImpl mLayoutParent;
    public ArrayList<ReactShadowNodeImpl> mNativeChildren;
    public ReactShadowNodeImpl mNativeParent;
    public boolean mNodeUpdated = true;
    public final float[] mPadding = new float[9];
    public final boolean[] mPaddingIsPercent = new boolean[9];
    public ReactShadowNodeImpl mParent;
    public int mReactTag;
    public int mRootTag;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mScreenX;
    public int mScreenY;
    public boolean mShouldNotifyOnLayout;
    public ThemedReactContext mThemedContext;
    public int mTotalNativeChildren = 0;
    public String mViewClassName;
    public Integer mWidthMeasureSpec;
    public YogaNode mYogaNode;

    static {
        if (ImageOriginUtils.YOGA_CONFIG == null) {
            YogaConfigJNIFinalizer yogaConfigJNIFinalizer = new YogaConfigJNIFinalizer();
            ImageOriginUtils.YOGA_CONFIG = yogaConfigJNIFinalizer;
            YogaNative.jni_YGConfigSetPointScaleFactorJNI(yogaConfigJNIFinalizer.mNativePointer, 0.0f);
            YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(ImageOriginUtils.YOGA_CONFIG.mNativePointer, true);
        }
    }

    public ReactShadowNodeImpl() {
        if (!isVirtual()) {
            YogaNode yogaNode = (YogaNode) YogaNodePool.get().acquire();
            yogaNode = yogaNode == null ? new YogaNodeJNIFinalizer(sYogaConfig) : yogaNode;
            this.mYogaNode = yogaNode;
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            Arrays.fill(this.mPadding, Float.NaN);
            return;
        }
        this.mYogaNode = null;
    }

    public void addNativeChildAt(ReactShadowNode reactShadowNode, int i) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        boolean z = false;
        ImageOriginUtils.assertCondition(getNativeKind() == NativeKind.PARENT);
        if (reactShadowNodeImpl.getNativeKind() != NativeKind.NONE) {
            z = true;
        }
        ImageOriginUtils.assertCondition(z);
        if (this.mNativeChildren == null) {
            this.mNativeChildren = new ArrayList<>(4);
        }
        this.mNativeChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mNativeParent = this;
    }

    public void calculateLayout() {
        calculateLayout(Float.NaN, Float.NaN);
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (isVirtualAnchor()) {
            return null;
        }
        return this.mChildren;
    }

    public void dirty() {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeMarkDirtyJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            return;
        }
        ReactShadowNodeImpl reactShadowNodeImpl = this.mParent;
        if (reactShadowNodeImpl != null) {
            reactShadowNodeImpl.dirty();
        }
    }

    public boolean dispatchUpdates(float f2, float f3, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer2 = nativeViewHierarchyOptimizer;
        if (this.mNodeUpdated) {
            onCollectExtraUpdates(uIViewOperationQueue);
        } else {
            UIViewOperationQueue uIViewOperationQueue2 = uIViewOperationQueue;
        }
        if (!hasNewLayout()) {
            return false;
        }
        float layoutX = getLayoutX();
        float layoutY = getLayoutY();
        float f4 = f2 + layoutX;
        int round = Math.round(f4);
        float f5 = f3 + layoutY;
        int round2 = Math.round(f5);
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        boolean z = true;
        float f6 = 0.0f;
        int round3 = Math.round(f4 + (fArr != null ? fArr[1] : 0.0f));
        float[] fArr2 = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr2 != null) {
            f6 = fArr2[2];
        }
        int round4 = Math.round(f5 + f6);
        int round5 = Math.round(layoutX);
        int round6 = Math.round(layoutY);
        int i = round3 - round;
        int i2 = round4 - round2;
        if (round5 == this.mScreenX && round6 == this.mScreenY && i == this.mScreenWidth && i2 == this.mScreenHeight) {
            z = false;
        }
        this.mScreenX = round5;
        this.mScreenY = round6;
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        if (z) {
            if (nativeViewHierarchyOptimizer2 != null) {
                nativeViewHierarchyOptimizer2.applyLayoutBase(this);
            } else {
                uIViewOperationQueue.enqueueUpdateLayout(this.mParent.mReactTag, this.mReactTag, round5, round6, i, i2);
            }
        }
        return z;
    }

    public void dispose() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            yogaNodeJNIBase.mMeasureFunction = null;
            yogaNodeJNIBase.mBaselineFunction = null;
            yogaNodeJNIBase.arr = null;
            yogaNodeJNIBase.mHasNewLayout = true;
            yogaNodeJNIBase.mLayoutDirection = 0;
            YogaNative.jni_YGNodeResetJNI(yogaNodeJNIBase.mNativePointer);
            YogaNodePool.get().release(this.mYogaNode);
        }
    }

    public final int getChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public Integer getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public final float getLayoutHeight() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    public ReactShadowNode getLayoutParent() {
        ReactShadowNodeImpl reactShadowNodeImpl = this.mLayoutParent;
        return reactShadowNodeImpl != null ? reactShadowNodeImpl : this.mNativeParent;
    }

    public final float getLayoutWidth() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    public final float getLayoutX() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    public final float getLayoutY() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    public final int getNativeChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public NativeKind getNativeKind() {
        if (isVirtual() || this.mIsLayoutOnly) {
            return NativeKind.NONE;
        }
        return hoistNativeChildren() ? NativeKind.LEAF : NativeKind.PARENT;
    }

    public int getNativeOffsetForChild(ReactShadowNode reactShadowNode) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            ReactShadowNodeImpl childAt = getChildAt(i);
            if (reactShadowNodeImpl == childAt) {
                z = true;
                break;
            }
            i2 += childAt.getTotalNativeNodeContributionToParent();
            i++;
        }
        if (z) {
            return i2;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Child ");
        outline73.append(reactShadowNodeImpl.mReactTag);
        outline73.append(" was not a child of ");
        outline73.append(this.mReactTag);
        throw new RuntimeException(outline73.toString());
    }

    public ReactShadowNode getNativeParent() {
        return this.mNativeParent;
    }

    public final float getPadding(int i) {
        YogaNode yogaNode = this.mYogaNode;
        YogaEdge fromInt = YogaEdge.fromInt(i);
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        float[] fArr = yogaNodeJNIBase.arr;
        if (fArr != null) {
            int i2 = 0;
            if ((((int) fArr[0]) & 2) == 2) {
                if ((((int) fArr[0]) & 1) != 1) {
                    i2 = 4;
                }
                int i3 = 10 - i2;
                int ordinal = fromInt.ordinal();
                if (ordinal == 0) {
                    return yogaNodeJNIBase.arr[i3];
                }
                if (ordinal == 1) {
                    return yogaNodeJNIBase.arr[i3 + 1];
                }
                if (ordinal == 2) {
                    return yogaNodeJNIBase.arr[i3 + 2];
                }
                if (ordinal == 3) {
                    return yogaNodeJNIBase.arr[i3 + 3];
                }
                if (ordinal == 4) {
                    return yogaNodeJNIBase.getLayoutDirection() == YogaDirection.RTL ? yogaNodeJNIBase.arr[i3 + 2] : yogaNodeJNIBase.arr[i3];
                }
                if (ordinal == 5) {
                    return yogaNodeJNIBase.getLayoutDirection() == YogaDirection.RTL ? yogaNodeJNIBase.arr[i3] : yogaNodeJNIBase.arr[i3 + 2];
                }
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
            }
        }
        return 0.0f;
    }

    public ReactShadowNode getParent() {
        return this.mParent;
    }

    public final int getReactTag() {
        return this.mReactTag;
    }

    public final int getRootTag() {
        ImageOriginUtils.assertCondition(this.mRootTag != 0);
        return this.mRootTag;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScreenX() {
        return this.mScreenX;
    }

    public int getScreenY() {
        return this.mScreenY;
    }

    public final YogaValue getStyleHeight() {
        long jni_YGNodeStyleGetHeightJNI = YogaNative.jni_YGNodeStyleGetHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
        return new YogaValue(Float.intBitsToFloat((int) jni_YGNodeStyleGetHeightJNI), (int) (jni_YGNodeStyleGetHeightJNI >> 32));
    }

    public final YogaValue getStyleWidth() {
        long jni_YGNodeStyleGetWidthJNI = YogaNative.jni_YGNodeStyleGetWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
        return new YogaValue(Float.intBitsToFloat((int) jni_YGNodeStyleGetWidthJNI), (int) (jni_YGNodeStyleGetWidthJNI >> 32));
    }

    public final ThemedReactContext getThemedContext() {
        ThemedReactContext themedReactContext = this.mThemedContext;
        ImageOriginUtils.assertNotNull(themedReactContext);
        return themedReactContext;
    }

    public final int getTotalNativeNodeContributionToParent() {
        NativeKind nativeKind = getNativeKind();
        if (nativeKind == NativeKind.NONE) {
            return this.mTotalNativeChildren;
        }
        if (nativeKind == NativeKind.LEAF) {
            return 1 + this.mTotalNativeChildren;
        }
        return 1;
    }

    public final String getViewClass() {
        String str = this.mViewClassName;
        ImageOriginUtils.assertNotNull(str);
        return str;
    }

    public Integer getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public final boolean hasNewLayout() {
        boolean z;
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            float[] fArr = yogaNodeJNIBase.arr;
            if (fArr != null) {
                z = (((int) fArr[0]) & 16) == 16;
            } else {
                z = yogaNodeJNIBase.mHasNewLayout;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasUpdates() {
        if (!this.mNodeUpdated && !hasNewLayout()) {
            YogaNode yogaNode = this.mYogaNode;
            if (!(yogaNode != null && YogaNative.jni_YGNodeIsDirtyJNI(((YogaNodeJNIBase) yogaNode).mNativePointer))) {
                return false;
            }
        }
        return true;
    }

    public boolean hoistNativeChildren() {
        return false;
    }

    public int indexOf(ReactShadowNode reactShadowNode) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(reactShadowNodeImpl);
    }

    public int indexOfNativeChild(ReactShadowNode reactShadowNode) {
        ImageOriginUtils.assertNotNull(this.mNativeChildren);
        return this.mNativeChildren.indexOf((ReactShadowNodeImpl) reactShadowNode);
    }

    public boolean isDescendantOf(ReactShadowNode reactShadowNode) {
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        for (ReactShadowNodeImpl reactShadowNodeImpl2 = this.mParent; reactShadowNodeImpl2 != null; reactShadowNodeImpl2 = reactShadowNodeImpl2.mParent) {
            if (reactShadowNodeImpl2 == reactShadowNodeImpl) {
                return true;
            }
        }
        return false;
    }

    public final boolean isLayoutOnly() {
        return this.mIsLayoutOnly;
    }

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public boolean isYogaLeafNode() {
        return ((YogaNodeJNIBase) this.mYogaNode).mMeasureFunction != null;
    }

    public final void markUpdateSeen() {
        this.mNodeUpdated = false;
        if (hasNewLayout()) {
            YogaNode yogaNode = this.mYogaNode;
            if (yogaNode != null) {
                YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
                float[] fArr = yogaNodeJNIBase.arr;
                if (fArr != null) {
                    fArr[0] = (float) (((int) fArr[0]) & -17);
                }
                yogaNodeJNIBase.mHasNewLayout = false;
            }
        }
    }

    public void markUpdated() {
        if (!this.mNodeUpdated) {
            this.mNodeUpdated = true;
            ReactShadowNodeImpl reactShadowNodeImpl = this.mParent;
            if (reactShadowNodeImpl != null) {
                reactShadowNodeImpl.markUpdated();
            }
        }
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
    }

    public final void removeAllNativeChildren() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mNativeChildren.get(size).mNativeParent = null;
            }
            this.mNativeChildren.clear();
        }
    }

    public void removeAndDisposeAllChildren() {
        if (getChildCount() != 0) {
            int i = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (this.mYogaNode != null && !isYogaLeafNode()) {
                    this.mYogaNode.removeChildAt(childCount);
                }
                ReactShadowNodeImpl childAt = getChildAt(childCount);
                childAt.mParent = null;
                i += childAt.getTotalNativeNodeContributionToParent();
                childAt.dispose();
            }
            ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
            ImageOriginUtils.assertNotNull(arrayList);
            arrayList.clear();
            markUpdated();
            this.mTotalNativeChildren -= i;
            updateNativeChildrenCountInParent(-i);
        }
    }

    public ReactShadowNode removeChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            ReactShadowNodeImpl remove = arrayList.remove(i);
            remove.mParent = null;
            if (this.mYogaNode != null && !isYogaLeafNode()) {
                this.mYogaNode.removeChildAt(i);
            }
            markUpdated();
            int totalNativeNodeContributionToParent = remove.getTotalNativeNodeContributionToParent();
            this.mTotalNativeChildren -= totalNativeNodeContributionToParent;
            updateNativeChildrenCountInParent(-totalNativeNodeContributionToParent);
            return remove;
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline42("Index ", i, " out of bounds: node has no children"));
    }

    public ReactShadowNode removeNativeChildAt(int i) {
        ImageOriginUtils.assertNotNull(this.mNativeChildren);
        ReactShadowNodeImpl remove = this.mNativeChildren.remove(i);
        remove.mNativeParent = null;
        return remove;
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.intValue());
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.intValue());
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaAlign.intValue());
    }

    public void setDefaultPadding(int i, float f2) {
        this.mDefaultPadding.set(i, f2);
        updatePadding();
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaDisplay.intValue());
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaFlexDirection.intValue());
    }

    public void setFlexWrap(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaWrap.intValue());
    }

    public final void setIsLayoutOnly(boolean z) {
        boolean z2 = true;
        ImageOriginUtils.assertCondition(this.mParent == null, "Must remove from no opt parent first");
        ImageOriginUtils.assertCondition(this.mNativeParent == null, "Must remove from native parent first");
        if (getNativeChildCount() != 0) {
            z2 = false;
        }
        ImageOriginUtils.assertCondition(z2, "Must remove all native children first");
        this.mIsLayoutOnly = z;
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaJustify.intValue());
    }

    public void setLayoutParent(ReactShadowNode reactShadowNode) {
        this.mLayoutParent = (ReactShadowNodeImpl) reactShadowNode;
    }

    public void setLocalData(Object obj) {
    }

    public void setMargin(int i, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(i).intValue(), f2);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
        yogaNodeJNIBase.mMeasureFunction = yogaMeasureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(yogaNodeJNIBase.mNativePointer, yogaMeasureFunction != null);
    }

    public void setMeasureSpecs(int i, int i2) {
        this.mWidthMeasureSpec = Integer.valueOf(i);
        this.mHeightMeasureSpec = Integer.valueOf(i2);
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaOverflow.intValue());
    }

    public void setPadding(int i, float f2) {
        this.mPadding[i] = f2;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, yogaPositionType.intValue());
    }

    public void setReactTag(int i) {
        this.mReactTag = i;
    }

    public final void setRootTag(int i) {
        this.mRootTag = i;
    }

    public void setStyleHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
    }

    public void setStyleWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f2);
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
    }

    public final void setViewClassName(String str) {
        this.mViewClassName = str;
    }

    public final boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnLayout;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.mViewClassName);
        outline73.append(CMap.SPACE);
        return GeneratedOutlineSupport.outline57(outline73, this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }

    public final void updateNativeChildrenCountInParent(int i) {
        if (getNativeKind() != NativeKind.PARENT) {
            ReactShadowNodeImpl reactShadowNodeImpl = this.mParent;
            while (reactShadowNodeImpl != null) {
                reactShadowNodeImpl.mTotalNativeChildren += i;
                if (reactShadowNodeImpl.getNativeKind() != NativeKind.PARENT) {
                    reactShadowNodeImpl = reactShadowNodeImpl.mParent;
                } else {
                    return;
                }
            }
        }
    }

    public final void updatePadding() {
        for (int i = 0; i <= 8; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 5) {
                if (ImageOriginUtils.isUndefined(this.mPadding[i]) && ImageOriginUtils.isUndefined(this.mPadding[6]) && ImageOriginUtils.isUndefined(this.mPadding[8])) {
                    this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.mSpacing[i]);
                }
            } else if (i == 1 || i == 3) {
                if (ImageOriginUtils.isUndefined(this.mPadding[i]) && ImageOriginUtils.isUndefined(this.mPadding[7]) && ImageOriginUtils.isUndefined(this.mPadding[8])) {
                    this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.mSpacing[i]);
                }
            } else if (ImageOriginUtils.isUndefined(this.mPadding[i])) {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.mSpacing[i]);
            }
            if (this.mPaddingIsPercent[i]) {
                YogaNode yogaNode = this.mYogaNode;
                YogaEdge fromInt = YogaEdge.fromInt(i);
                YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(((YogaNodeJNIBase) yogaNode).mNativePointer, fromInt.intValue(), this.mPadding[i]);
            } else {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
            }
        }
    }

    public final void updateProperties(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, reactStylesDiffMap);
    }

    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList<>(4);
        }
        this.mChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
        if (this.mYogaNode != null && !isYogaLeafNode()) {
            YogaNode yogaNode = reactShadowNodeImpl.mYogaNode;
            if (yogaNode != null) {
                YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
                if (yogaNodeJNIBase != null) {
                    YogaNodeJNIBase yogaNodeJNIBase2 = (YogaNodeJNIBase) yogaNode;
                    if (yogaNodeJNIBase2.mOwner == null) {
                        if (yogaNodeJNIBase.mChildren == null) {
                            yogaNodeJNIBase.mChildren = new ArrayList(4);
                        }
                        yogaNodeJNIBase.mChildren.add(i, yogaNodeJNIBase2);
                        yogaNodeJNIBase2.mOwner = yogaNodeJNIBase;
                        YogaNative.jni_YGNodeInsertChildJNI(yogaNodeJNIBase.mNativePointer, yogaNodeJNIBase2.mNativePointer, i);
                    } else {
                        throw new IllegalStateException("Child already has a parent, it must be removed first.");
                    }
                } else {
                    throw null;
                }
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '");
                outline73.append(reactShadowNodeImpl.toString());
                outline73.append("' to a '");
                outline73.append(toString());
                outline73.append("')");
                throw new RuntimeException(outline73.toString());
            }
        }
        markUpdated();
        int totalNativeNodeContributionToParent = reactShadowNodeImpl.getTotalNativeNodeContributionToParent();
        this.mTotalNativeChildren += totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(totalNativeNodeContributionToParent);
    }

    public void calculateLayout(float f2, float f3) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
        if (yogaNodeJNIBase != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(yogaNodeJNIBase);
            for (int i = 0; i < arrayList.size(); i++) {
                List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).mChildren;
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
            YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
            long[] jArr = new long[yogaNodeJNIBaseArr.length];
            for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
                jArr[i2] = yogaNodeJNIBaseArr[i2].mNativePointer;
            }
            YogaNative.jni_YGNodeCalculateLayoutJNI(yogaNodeJNIBase.mNativePointer, f2, f3, jArr, yogaNodeJNIBaseArr);
            return;
        }
        throw null;
    }

    public final ReactShadowNodeImpl getChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline42("Index ", i, " out of bounds: node has no children"));
    }
}
