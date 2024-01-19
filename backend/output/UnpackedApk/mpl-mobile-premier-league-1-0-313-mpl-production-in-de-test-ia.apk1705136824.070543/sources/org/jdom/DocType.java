package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;
import org.jdom.output.XMLOutputter;

public class DocType extends Content {
    public String elementName;
    public String internalSubset;
    public String publicID;
    public String systemID;

    public DocType() {
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[DocType: ");
        XMLOutputter xMLOutputter = new XMLOutputter();
        StringWriter stringWriter = new StringWriter();
        try {
            xMLOutputter.output(this, (Writer) stringWriter);
        } catch (IOException unused) {
        }
        outline71.append(stringWriter.toString());
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public DocType(String str, String str2, String str3) {
        String checkXMLName = TypeUtilsKt.checkXMLName(str);
        if (checkXMLName == null) {
            this.elementName = str;
            String checkPublicID = TypeUtilsKt.checkPublicID(str2);
            if (checkPublicID == null) {
                this.publicID = str2;
                String checkSystemLiteral = TypeUtilsKt.checkSystemLiteral(str3);
                if (checkSystemLiteral == null) {
                    this.systemID = str3;
                    return;
                }
                throw new IllegalDataException(str3, "DocType", checkSystemLiteral);
            }
            throw new IllegalDataException(str2, "DocType", checkPublicID);
        }
        throw new IllegalNameException(str, "DocType", checkXMLName);
    }
}
