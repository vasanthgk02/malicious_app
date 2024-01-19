package org.jdom;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;

public class Text extends Content {
    public String value;

    public Text() {
    }

    public Object clone() {
        Text text = (Text) super.clone();
        text.value = this.value;
        return text;
    }

    public Text setText(String str) {
        if (str == null) {
            this.value = "";
            return this;
        }
        String checkCharacterData = TypeUtilsKt.checkCharacterData(str);
        if (checkCharacterData == null) {
            this.value = str;
            return this;
        }
        throw new IllegalDataException(str, "character content", checkCharacterData);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("[Text: ");
        stringBuffer.append(this.value);
        stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer.toString();
    }

    public Text(String str) {
        setText(str);
    }
}
