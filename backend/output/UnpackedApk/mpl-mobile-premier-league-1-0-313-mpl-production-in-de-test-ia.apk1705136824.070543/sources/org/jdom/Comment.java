package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.StringWriter;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;
import org.jdom.output.XMLOutputter;

public class Comment extends Content {
    public String text;

    public Comment() {
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[Comment: ");
        new XMLOutputter();
        StringWriter stringWriter = new StringWriter();
        try {
            stringWriter.write("<!--");
            stringWriter.write(this.text);
            stringWriter.write("-->");
            stringWriter.flush();
        } catch (IOException unused) {
        }
        outline71.append(stringWriter.toString());
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public Comment(String str) {
        String checkCharacterData = TypeUtilsKt.checkCharacterData(str);
        if (checkCharacterData == null) {
            if (str.indexOf("--") != -1) {
                checkCharacterData = "Comments cannot contain double hyphens (--)";
            } else {
                checkCharacterData = str.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? "Comment data cannot end with a hyphen." : null;
            }
        }
        if (checkCharacterData == null) {
            this.text = str;
            return;
        }
        throw new IllegalDataException(str, "comment", checkCharacterData);
    }
}
