package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Comparator;
import org.apache.fontbox.cmap.CMapParser;

public class ViewAtIndex {
    public static Comparator<ViewAtIndex> COMPARATOR = new Comparator<ViewAtIndex>() {
        public int compare(Object obj, Object obj2) {
            return ((ViewAtIndex) obj).mIndex - ((ViewAtIndex) obj2).mIndex;
        }
    };
    public final int mIndex;
    public final int mTag;

    public ViewAtIndex(int i, int i2) {
        this.mTag = i;
        this.mIndex = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != ViewAtIndex.class) {
            return false;
        }
        ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
        if (this.mIndex == viewAtIndex.mIndex && this.mTag == viewAtIndex.mTag) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.mTag);
        outline73.append(", ");
        return GeneratedOutlineSupport.outline57(outline73, this.mIndex, CMapParser.MARK_END_OF_ARRAY);
    }
}
