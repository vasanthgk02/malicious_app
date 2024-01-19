package org.jdom;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;

public class CDATA extends Text {
    public CDATA(String str) {
        setText(str);
    }

    public Text setText(String str) {
        if (str == null || "".equals(str)) {
            this.value = "";
            return this;
        }
        String checkCharacterData = TypeUtilsKt.checkCharacterData(str);
        if (checkCharacterData == null) {
            checkCharacterData = str.indexOf("]]>") != -1 ? "CDATA cannot internally contain a CDATA ending delimiter (]]>)" : null;
        }
        if (checkCharacterData == null) {
            this.value = str;
            return this;
        }
        throw new IllegalDataException(str, "CDATA section", checkCharacterData);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("[CDATA: ");
        stringBuffer.append(this.value);
        stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer.toString();
    }
}
