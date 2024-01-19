package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class NativeViewHierarchyOptimizer {
    public final ShadowNodeRegistry mShadowNodeRegistry;
    public final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
    public final UIViewOperationQueue mUIViewOperationQueue;

    public static class NodeIndexPair {
        public final int index;
        public final ReactShadowNode node;

        public NodeIndexPair(ReactShadowNode reactShadowNode, int i) {
            this.node = reactShadowNode;
            this.index = i;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.mUIViewOperationQueue = uIViewOperationQueue;
        this.mShadowNodeRegistry = shadowNodeRegistry;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0181, code lost:
        if (r3.getInt("borderLeftColor") == 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0190, code lost:
        if (r3.getInt("backgroundColor") != 0) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01a5, code lost:
        if (r3.getDouble("borderWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01b6, code lost:
        if (r3.getDouble("opacity") != 1.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if ("box-none".equals(r3) == false) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fc, code lost:
        if ("visible".equals(r3.getString("overflow")) == false) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010c, code lost:
        if (r3.getDouble("borderBottomWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x011c, code lost:
        if (r3.getDouble("borderRightWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x012c, code lost:
        if (r3.getDouble("borderTopWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
        if (r3.getDouble("borderLeftWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014c, code lost:
        if (r3.getDouble("borderWidth") != 0.0d) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015a, code lost:
        if (r3.getInt("borderBottomColor") == 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0167, code lost:
        if (r3.getInt("borderTopColor") == 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0174, code lost:
        if (r3.getInt("borderRightColor") == 0) goto L_0x01b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01bf A[LOOP:0: B:12:0x002a->B:122:0x01bf, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isLayoutOnlyAndCollapsable(com.facebook.react.uimanager.ReactStylesDiffMap r18) {
        /*
            r0 = r18
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.facebook.react.bridge.ReadableMap r2 = r0.mBackingMap
            java.lang.String r3 = "collapsable"
            boolean r2 = r2.hasKey(r3)
            r4 = 0
            if (r2 == 0) goto L_0x0024
            com.facebook.react.bridge.ReadableMap r2 = r0.mBackingMap
            boolean r2 = r2.isNull(r3)
            if (r2 == 0) goto L_0x001b
            r2 = 1
            goto L_0x0021
        L_0x001b:
            com.facebook.react.bridge.ReadableMap r2 = r0.mBackingMap
            boolean r2 = r2.getBoolean(r3)
        L_0x0021:
            if (r2 != 0) goto L_0x0024
            return r4
        L_0x0024:
            com.facebook.react.bridge.ReadableMap r2 = r0.mBackingMap
            com.facebook.react.bridge.ReadableMapKeySetIterator r2 = r2.keySetIterator()
        L_0x002a:
            boolean r3 = r2.hasNextKey()
            if (r3 == 0) goto L_0x01c3
            com.facebook.react.bridge.ReadableMap r3 = r0.mBackingMap
            java.lang.String r5 = r2.nextKey()
            java.util.HashSet<java.lang.String> r6 = com.facebook.react.uimanager.ViewProps.LAYOUT_ONLY_PROPS
            boolean r6 = r6.contains(r5)
            if (r6 == 0) goto L_0x0040
            goto L_0x01b8
        L_0x0040:
            java.lang.String r6 = "pointerEvents"
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r3.getString(r5)
            java.lang.String r5 = "auto"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x01b8
            java.lang.String r5 = "box-none"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x01ba
            goto L_0x01b8
        L_0x005e:
            int r6 = r5.hashCode()
            java.lang.String r7 = "overflow"
            java.lang.String r8 = "borderLeftWidth"
            java.lang.String r9 = "borderLeftColor"
            java.lang.String r10 = "opacity"
            java.lang.String r11 = "borderBottomWidth"
            java.lang.String r12 = "borderBottomColor"
            java.lang.String r13 = "borderTopWidth"
            java.lang.String r14 = "borderTopColor"
            java.lang.String r15 = "borderRightWidth"
            java.lang.String r1 = "borderRightColor"
            java.lang.String r4 = "borderWidth"
            switch(r6) {
                case -1989576717: goto L_0x00dc;
                case -1971292586: goto L_0x00d3;
                case -1470826662: goto L_0x00cb;
                case -1452542531: goto L_0x00c2;
                case -1308858324: goto L_0x00ba;
                case -1290574193: goto L_0x00b1;
                case -1267206133: goto L_0x00a9;
                case -242276144: goto L_0x00a1;
                case -223992013: goto L_0x0099;
                case 529642498: goto L_0x0090;
                case 741115130: goto L_0x0088;
                case 1349188574: goto L_0x007d;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x00e4
        L_0x007d:
            java.lang.String r6 = "borderRadius"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00e4
            r5 = 1
            goto L_0x00e5
        L_0x0088:
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x00e4
            r5 = 6
            goto L_0x00e5
        L_0x0090:
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x00e4
            r5 = 11
            goto L_0x00e5
        L_0x0099:
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x00e4
            r5 = 7
            goto L_0x00e5
        L_0x00a1:
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x00e4
            r5 = 2
            goto L_0x00e5
        L_0x00a9:
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x00e4
            r5 = 0
            goto L_0x00e5
        L_0x00b1:
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x00e4
            r5 = 10
            goto L_0x00e5
        L_0x00ba:
            boolean r5 = r5.equals(r12)
            if (r5 == 0) goto L_0x00e4
            r5 = 5
            goto L_0x00e5
        L_0x00c2:
            boolean r5 = r5.equals(r13)
            if (r5 == 0) goto L_0x00e4
            r5 = 8
            goto L_0x00e5
        L_0x00cb:
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x00e4
            r5 = 4
            goto L_0x00e5
        L_0x00d3:
            boolean r5 = r5.equals(r15)
            if (r5 == 0) goto L_0x00e4
            r5 = 9
            goto L_0x00e5
        L_0x00dc:
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00e4
            r5 = 3
            goto L_0x00e5
        L_0x00e4:
            r5 = -1
        L_0x00e5:
            r16 = 0
            switch(r5) {
                case 0: goto L_0x01a8;
                case 1: goto L_0x0184;
                case 2: goto L_0x0177;
                case 3: goto L_0x016a;
                case 4: goto L_0x015d;
                case 5: goto L_0x0150;
                case 6: goto L_0x0140;
                case 7: goto L_0x0130;
                case 8: goto L_0x0120;
                case 9: goto L_0x0110;
                case 10: goto L_0x0100;
                case 11: goto L_0x00ec;
                default: goto L_0x00ea;
            }
        L_0x00ea:
            goto L_0x01ba
        L_0x00ec:
            boolean r1 = r3.isNull(r7)
            if (r1 != 0) goto L_0x01b8
            java.lang.String r1 = r3.getString(r7)
            java.lang.String r3 = "visible"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0100:
            boolean r1 = r3.isNull(r11)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r11)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0110:
            boolean r1 = r3.isNull(r15)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r15)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0120:
            boolean r1 = r3.isNull(r13)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r13)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0130:
            boolean r1 = r3.isNull(r8)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r8)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0140:
            boolean r1 = r3.isNull(r4)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r4)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0150:
            boolean r1 = r3.isNull(r12)
            if (r1 != 0) goto L_0x01ba
            int r1 = r3.getInt(r12)
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x015d:
            boolean r1 = r3.isNull(r14)
            if (r1 != 0) goto L_0x01ba
            int r1 = r3.getInt(r14)
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x016a:
            boolean r4 = r3.isNull(r1)
            if (r4 != 0) goto L_0x01ba
            int r1 = r3.getInt(r1)
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0177:
            boolean r1 = r3.isNull(r9)
            if (r1 != 0) goto L_0x01ba
            int r1 = r3.getInt(r9)
            if (r1 != 0) goto L_0x01ba
            goto L_0x01b8
        L_0x0184:
            java.lang.String r1 = "backgroundColor"
            boolean r5 = r3.hasKey(r1)
            if (r5 == 0) goto L_0x0193
            int r1 = r3.getInt(r1)
            if (r1 == 0) goto L_0x0193
            goto L_0x01ba
        L_0x0193:
            boolean r1 = r3.hasKey(r4)
            if (r1 == 0) goto L_0x01b8
            boolean r1 = r3.isNull(r4)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r4)
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x01b8
            goto L_0x01ba
        L_0x01a8:
            boolean r1 = r3.isNull(r10)
            if (r1 != 0) goto L_0x01b8
            double r3 = r3.getDouble(r10)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
        L_0x01b8:
            r1 = 1
            goto L_0x01bb
        L_0x01ba:
            r1 = 0
        L_0x01bb:
            if (r1 != 0) goto L_0x01bf
            r1 = 0
            return r1
        L_0x01bf:
            r1 = 1
            r4 = 0
            goto L_0x002a
        L_0x01c3:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.NativeViewHierarchyOptimizer.isLayoutOnlyAndCollapsable(com.facebook.react.uimanager.ReactStylesDiffMap):boolean");
    }

    public final void addGrandchildren(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        ImageOriginUtils.assertCondition(reactShadowNode2.getNativeKind() != NativeKind.PARENT);
        for (int i2 = 0; i2 < reactShadowNode2.getChildCount(); i2++) {
            ReactShadowNode childAt = reactShadowNode2.getChildAt(i2);
            ImageOriginUtils.assertCondition(childAt.getNativeParent() == null);
            int nativeChildCount = reactShadowNode.getNativeChildCount();
            if (childAt.getNativeKind() == NativeKind.NONE) {
                addGrandchildren(reactShadowNode, childAt, i);
            } else {
                addNativeChild(reactShadowNode, childAt, i);
            }
            i += reactShadowNode.getNativeChildCount() - nativeChildCount;
        }
    }

    public final void addNativeChild(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        reactShadowNode.addNativeChildAt(reactShadowNode2, i);
        this.mUIViewOperationQueue.enqueueManageChildren(reactShadowNode.getReactTag(), null, new ViewAtIndex[]{new ViewAtIndex(reactShadowNode2.getReactTag(), i)}, null);
        if (reactShadowNode2.getNativeKind() != NativeKind.PARENT) {
            addGrandchildren(reactShadowNode, reactShadowNode2, i + 1);
        }
    }

    public final void addNodeToNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        NodeIndexPair nodeIndexPair;
        int nativeOffsetForChild = reactShadowNode.getNativeOffsetForChild(reactShadowNode.getChildAt(i));
        if (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            while (true) {
                if (reactShadowNode.getNativeKind() == NativeKind.PARENT) {
                    nodeIndexPair = new NodeIndexPair(reactShadowNode, nativeOffsetForChild);
                    break;
                }
                ReactShadowNode parent = reactShadowNode.getParent();
                if (parent == null) {
                    nodeIndexPair = null;
                    break;
                } else {
                    nativeOffsetForChild = nativeOffsetForChild + (reactShadowNode.getNativeKind() == NativeKind.LEAF ? 1 : 0) + parent.getNativeOffsetForChild(reactShadowNode);
                    reactShadowNode = parent;
                }
            }
            if (nodeIndexPair != null) {
                ReactShadowNode reactShadowNode3 = nodeIndexPair.node;
                nativeOffsetForChild = nodeIndexPair.index;
                reactShadowNode = reactShadowNode3;
            } else {
                return;
            }
        }
        if (reactShadowNode2.getNativeKind() != NativeKind.NONE) {
            addNativeChild(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        } else {
            addGrandchildren(reactShadowNode, reactShadowNode2, nativeOffsetForChild);
        }
    }

    public final void applyLayoutBase(ReactShadowNode reactShadowNode) {
        int reactTag = reactShadowNode.getReactTag();
        if (!this.mTagsWithLayoutVisited.get(reactTag)) {
            this.mTagsWithLayoutVisited.put(reactTag, true);
            ReactShadowNode parent = reactShadowNode.getParent();
            int screenX = reactShadowNode.getScreenX();
            int screenY = reactShadowNode.getScreenY();
            while (parent != null && parent.getNativeKind() != NativeKind.PARENT) {
                if (!parent.isVirtual()) {
                    int round = Math.round(parent.getLayoutX()) + screenX;
                    screenY = Math.round(parent.getLayoutY()) + screenY;
                    screenX = round;
                }
                parent = parent.getParent();
            }
            applyLayoutRecursive(reactShadowNode, screenX, screenY);
        }
    }

    public final void applyLayoutRecursive(ReactShadowNode reactShadowNode, int i, int i2) {
        if (reactShadowNode.getNativeKind() == NativeKind.NONE || reactShadowNode.getNativeParent() == null) {
            for (int i3 = 0; i3 < reactShadowNode.getChildCount(); i3++) {
                ReactShadowNode childAt = reactShadowNode.getChildAt(i3);
                int reactTag = childAt.getReactTag();
                if (!this.mTagsWithLayoutVisited.get(reactTag)) {
                    this.mTagsWithLayoutVisited.put(reactTag, true);
                    applyLayoutRecursive(childAt, childAt.getScreenX() + i, childAt.getScreenY() + i2);
                }
            }
            return;
        }
        this.mUIViewOperationQueue.enqueueUpdateLayout(reactShadowNode.getLayoutParent().getReactTag(), reactShadowNode.getReactTag(), i, i2, reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight());
    }

    public void handleManageChildren(ReactShadowNode reactShadowNode, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        boolean z;
        for (int i : iArr) {
            int i2 = 0;
            while (true) {
                if (i2 >= iArr2.length) {
                    z = false;
                    break;
                } else if (iArr2[i2] == i) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            removeNodeFromParent(this.mShadowNodeRegistry.getNode(i), z);
        }
        for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(viewAtIndex.mTag), viewAtIndex.mIndex);
        }
    }

    public final void removeNodeFromParent(ReactShadowNode reactShadowNode, boolean z) {
        if (reactShadowNode.getNativeKind() != NativeKind.PARENT) {
            for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
                removeNodeFromParent(reactShadowNode.getChildAt(childCount), z);
            }
        }
        ReactShadowNode nativeParent = reactShadowNode.getNativeParent();
        if (nativeParent != null) {
            int indexOfNativeChild = nativeParent.indexOfNativeChild(reactShadowNode);
            nativeParent.removeNativeChildAt(indexOfNativeChild);
            this.mUIViewOperationQueue.enqueueManageChildren(nativeParent.getReactTag(), new int[]{indexOfNativeChild}, null, z ? new int[]{reactShadowNode.getReactTag()} : null);
        }
    }

    public final void transitionLayoutOnlyViewToNativeView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        ReactShadowNode parent = reactShadowNode.getParent();
        if (parent == null) {
            reactShadowNode.setIsLayoutOnly(false);
            return;
        }
        int indexOf = parent.indexOf(reactShadowNode);
        parent.removeChildAt(indexOf);
        removeNodeFromParent(reactShadowNode, false);
        reactShadowNode.setIsLayoutOnly(false);
        this.mUIViewOperationQueue.enqueueCreateView(reactShadowNode.getThemedContext(), reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        parent.addChildAt(reactShadowNode, indexOf);
        addNodeToNode(parent, reactShadowNode, indexOf);
        for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
            addNodeToNode(reactShadowNode, reactShadowNode.getChildAt(i), i);
        }
        ImageOriginUtils.assertCondition(this.mTagsWithLayoutVisited.size() == 0);
        applyLayoutBase(reactShadowNode);
        for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
            applyLayoutBase(reactShadowNode.getChildAt(i2));
        }
        this.mTagsWithLayoutVisited.clear();
    }
}
