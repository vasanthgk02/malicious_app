package com.facebook.react.views.text;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.apache.fontbox.cmap.CMapParser;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    public String mText = null;

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getViewClass());
        sb.append(" [text: ");
        return GeneratedOutlineSupport.outline62(sb, this.mText, CMapParser.MARK_END_OF_ARRAY);
    }
}
