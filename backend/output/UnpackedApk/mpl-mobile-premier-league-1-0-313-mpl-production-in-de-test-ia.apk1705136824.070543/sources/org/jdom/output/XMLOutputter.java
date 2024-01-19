package org.jdom.output;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.Writer;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.jdom.DocType;
import org.jdom.ProcessingInstruction;

public class XMLOutputter implements Cloneable {
    public Format currentFormat;
    public Format userFormat;

    static {
        new Format();
    }

    public XMLOutputter() {
        Format format = new Format();
        this.userFormat = format;
        this.currentFormat = format;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public void output(DocType docType, Writer writer) throws IOException {
        boolean z;
        String str = docType.publicID;
        String str2 = docType.systemID;
        String str3 = docType.internalSubset;
        writer.write("<!DOCTYPE ");
        writer.write(docType.elementName);
        if (str != null) {
            writer.write(" PUBLIC \"");
            writer.write(str);
            writer.write("\"");
            z = true;
        } else {
            z = false;
        }
        if (str2 != null) {
            if (!z) {
                writer.write(" SYSTEM");
            }
            writer.write(" \"");
            writer.write(str2);
            writer.write("\"");
        }
        if (str3 != null && !str3.equals("")) {
            writer.write(" [");
            writer.write(this.currentFormat.lineSeparator);
            writer.write(docType.internalSubset);
            writer.write(CMapParser.MARK_END_OF_ARRAY);
        }
        writer.write(">");
        writer.flush();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.userFormat.lineSeparator.length(); i++) {
            char charAt = this.userFormat.lineSeparator.charAt(i);
            if (charAt == 9) {
                stringBuffer.append("\\t");
            } else if (charAt == 10) {
                stringBuffer.append("\\n");
            } else if (charAt != 13) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(charAt);
                stringBuffer2.append(CMapParser.MARK_END_OF_ARRAY);
                stringBuffer.append(stringBuffer2.toString());
            } else {
                stringBuffer.append("\\r");
            }
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("XMLOutputter[omitDeclaration = ");
        outline71.append(this.userFormat.omitDeclaration);
        outline71.append(", ");
        outline71.append("encoding = ");
        outline71.append(this.userFormat.encoding);
        outline71.append(", ");
        outline71.append("omitEncoding = ");
        outline71.append(this.userFormat.omitEncoding);
        outline71.append(", ");
        outline71.append("indent = '");
        outline71.append(this.userFormat.indent);
        outline71.append("'");
        outline71.append(", ");
        outline71.append("expandEmptyElements = ");
        outline71.append(this.userFormat.expandEmptyElements);
        outline71.append(", ");
        outline71.append("lineSeparator = '");
        outline71.append(stringBuffer.toString());
        outline71.append("', ");
        outline71.append("textMode = ");
        outline71.append(this.userFormat.mode);
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public void output(ProcessingInstruction processingInstruction, Writer writer) throws IOException {
        Format format = this.currentFormat;
        boolean z = format.ignoreTrAXEscapingPIs;
        format.ignoreTrAXEscapingPIs = true;
        String str = processingInstruction.target;
        String str2 = processingInstruction.rawData;
        if (!"".equals(str2)) {
            writer.write("<?");
            writer.write(str);
            writer.write(CMap.SPACE);
            writer.write(str2);
            writer.write("?>");
        } else {
            writer.write("<?");
            writer.write(str);
            writer.write("?>");
        }
        this.currentFormat.ignoreTrAXEscapingPIs = z;
        writer.flush();
    }
}
