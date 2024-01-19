package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import java.text.NumberFormat;
import java.util.Locale;

public class ConcatNode extends Node {
    public static final NumberFormat sFormatter;
    public final int[] mInputIDs;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.ENGLISH);
        sFormatter = instance;
        instance.setMinimumFractionDigits(0);
        sFormatter.setGroupingUsed(false);
    }

    public ConcatNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = TextAppearanceConfig.processIntArray(readableMap.getArray("input"));
    }

    public Object evaluate() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int[] iArr = this.mInputIDs;
            if (i >= iArr.length) {
                return sb.toString();
            }
            Object value = this.mNodesManager.findNodeById(iArr[i], Node.class).value();
            if (value instanceof Double) {
                value = sFormatter.format((Double) value);
            }
            sb.append(value);
            i++;
        }
    }
}
