package org.jdom;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;

public class EntityRef extends Content {
    public String name;

    public EntityRef(String str, String str2, String str3) {
        String checkXMLName = TypeUtilsKt.checkXMLName(str);
        if (checkXMLName == null) {
            this.name = str;
            String checkPublicID = TypeUtilsKt.checkPublicID(str2);
            if (checkPublicID == null) {
                String checkSystemLiteral = TypeUtilsKt.checkSystemLiteral(str3);
                if (checkSystemLiteral != null) {
                    throw new IllegalDataException(str3, "EntityRef", checkSystemLiteral);
                }
                return;
            }
            throw new IllegalDataException(str2, "EntityRef", checkPublicID);
        }
        throw new IllegalNameException(str, "EntityRef", checkXMLName);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[EntityRef: ");
        stringBuffer.append("&");
        stringBuffer.append(this.name);
        stringBuffer.append(";");
        stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer.toString();
    }
}
