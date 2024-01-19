package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.fontbox.cmap.CMapParser;
import org.jdom.output.XMLOutputter;

public class ProcessingInstruction extends Content {
    public Map mapData;
    public String rawData;
    public String target;

    public ProcessingInstruction() {
    }

    public Object clone() {
        ProcessingInstruction processingInstruction = (ProcessingInstruction) super.clone();
        if (this.mapData != null) {
            processingInstruction.mapData = parseData(this.rawData);
        }
        return processingInstruction;
    }

    public final Map parseData(String str) {
        String str2;
        int[] iArr;
        HashMap hashMap = new HashMap();
        String trim = str.trim();
        while (true) {
            String str3 = "";
            if (trim.trim().equals(str3)) {
                return hashMap;
            }
            char charAt = trim.charAt(0);
            int i = 1;
            int i2 = 0;
            while (true) {
                if (i >= trim.length()) {
                    str2 = str3;
                    break;
                }
                char charAt2 = trim.charAt(i);
                if (charAt2 == '=') {
                    str3 = trim.substring(i2, i).trim();
                    String substring = trim.substring(i + 1);
                    int i3 = 0;
                    boolean z = false;
                    char c2 = StringEscapeUtils.CSV_QUOTE;
                    int i4 = 0;
                    while (true) {
                        if (i3 >= substring.length()) {
                            iArr = null;
                            break;
                        }
                        char charAt3 = substring.charAt(i3);
                        if (charAt3 == '\"' || charAt3 == '\'') {
                            if (!z) {
                                i4 = i3 + 1;
                                c2 = charAt3;
                                z = true;
                            } else if (c2 == charAt3) {
                                iArr = new int[]{i4, i3};
                                break;
                            }
                        }
                        i3++;
                    }
                    if (iArr == null) {
                        return new HashMap();
                    }
                    str2 = trim.substring(iArr[0] + i + 1, iArr[1] + i + 1);
                    i += iArr[1] + 1;
                } else {
                    if (Character.isWhitespace(charAt) && !Character.isWhitespace(charAt2)) {
                        i2 = i;
                    }
                    i++;
                    charAt = charAt2;
                }
            }
            trim = trim.substring(i);
            if (str3.length() > 0 && str2 != null) {
                hashMap.put(str3, str2);
            }
        }
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[ProcessingInstruction: ");
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

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r3 = "Processing instructions cannot contain the string \"?>\"";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProcessingInstruction(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.checkXMLName(r3)
            if (r0 == 0) goto L_0x000a
            goto L_0x0023
        L_0x000a:
            java.lang.String r0 = ":"
            int r0 = r3.indexOf(r0)
            r1 = -1
            if (r0 == r1) goto L_0x0016
            java.lang.String r0 = "Processing instruction targets cannot contain colons"
            goto L_0x0023
        L_0x0016:
            java.lang.String r0 = "xml"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = "Processing instructions cannot have a target of \"xml\" in any combination of case. (Note that the \"<?xml ... ?>\" declaration at the beginning of a document is not a processing instruction and should not be added as one; it is written automatically during output, e.g. by XMLOutputter.)"
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            if (r0 != 0) goto L_0x0048
            r2.target = r3
            java.lang.String r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.checkCharacterData(r4)
            if (r3 != 0) goto L_0x0037
            java.lang.String r0 = "?>"
            int r0 = r4.indexOf(r0)
            if (r0 < 0) goto L_0x0037
            java.lang.String r3 = "Processing instructions cannot contain the string \"?>\""
        L_0x0037:
            if (r3 != 0) goto L_0x0042
            r2.rawData = r4
            java.util.Map r3 = r2.parseData(r4)
            r2.mapData = r3
            return
        L_0x0042:
            org.jdom.IllegalDataException r0 = new org.jdom.IllegalDataException
            r0.<init>(r4, r3)
            throw r0
        L_0x0048:
            org.jdom.IllegalTargetException r4 = new org.jdom.IllegalTargetException
            r4.<init>(r3, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.ProcessingInstruction.<init>(java.lang.String, java.lang.String):void");
    }
}
