package org.apache.pdfbox.pdmodel.font.encoding;

import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class DictionaryEncoding extends Encoding {
    public final Encoding baseEncoding;
    public final Map<Integer, String> differences = new HashMap();
    public final COSDictionary encoding;

    public DictionaryEncoding(COSName cOSName, COSArray cOSArray) {
        COSDictionary cOSDictionary = new COSDictionary();
        this.encoding = cOSDictionary;
        cOSDictionary.setItem(COSName.NAME, (COSBase) COSName.ENCODING);
        this.encoding.setItem(COSName.DIFFERENCES, (COSBase) cOSArray);
        if (cOSName != COSName.STANDARD_ENCODING) {
            this.encoding.setItem(COSName.BASE_ENCODING, (COSBase) cOSName);
            this.baseEncoding = Encoding.getInstance(cOSName);
        } else {
            this.baseEncoding = Encoding.getInstance(cOSName);
        }
        if (this.baseEncoding == null) {
            throw new IllegalArgumentException("Invalid encoding: " + cOSName);
        }
    }

    public Encoding getBaseEncoding() {
        return this.baseEncoding;
    }

    public COSBase getCOSObject() {
        return this.encoding;
    }

    public Map<Integer, String> getDifferences() {
        return this.differences;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r6 = org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DictionaryEncoding(org.apache.pdfbox.cos.COSDictionary r4, boolean r5, org.apache.pdfbox.pdmodel.font.encoding.Encoding r6) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.differences = r0
            r3.encoding = r4
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.BASE_ENCODING
            boolean r4 = r4.containsKey(r0)
            if (r4 == 0) goto L_0x0021
            org.apache.pdfbox.cos.COSDictionary r4 = r3.encoding
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.BASE_ENCODING
            org.apache.pdfbox.cos.COSName r4 = r4.getCOSName(r0)
            org.apache.pdfbox.pdmodel.font.encoding.Encoding r4 = org.apache.pdfbox.pdmodel.font.encoding.Encoding.getInstance(r4)
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            if (r4 != 0) goto L_0x002f
            if (r5 == 0) goto L_0x0029
            org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding r6 = org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding.INSTANCE
            goto L_0x0030
        L_0x0029:
            if (r6 == 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding r6 = org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding.INSTANCE
            goto L_0x0030
        L_0x002f:
            r6 = r4
        L_0x0030:
            r3.baseEncoding = r6
            java.util.Map<java.lang.Integer, java.lang.String> r4 = r3.codeToName
            java.util.Map<java.lang.Integer, java.lang.String> r5 = r6.codeToName
            r4.putAll(r5)
            java.util.Set<java.lang.String> r4 = r3.names
            org.apache.pdfbox.pdmodel.font.encoding.Encoding r5 = r3.baseEncoding
            java.util.Set<java.lang.String> r5 = r5.names
            r4.addAll(r5)
            org.apache.pdfbox.cos.COSDictionary r4 = r3.encoding
            org.apache.pdfbox.cos.COSName r5 = org.apache.pdfbox.cos.COSName.DIFFERENCES
            org.apache.pdfbox.cos.COSBase r4 = r4.getDictionaryObject(r5)
            org.apache.pdfbox.cos.COSArray r4 = (org.apache.pdfbox.cos.COSArray) r4
            r5 = -1
            r6 = 0
        L_0x004e:
            if (r4 == 0) goto L_0x0084
            int r0 = r4.size()
            if (r6 >= r0) goto L_0x0084
            org.apache.pdfbox.cos.COSBase r0 = r4.getObject(r6)
            boolean r1 = r0 instanceof org.apache.pdfbox.cos.COSNumber
            if (r1 == 0) goto L_0x0065
            org.apache.pdfbox.cos.COSNumber r0 = (org.apache.pdfbox.cos.COSNumber) r0
            int r5 = r0.intValue()
            goto L_0x0081
        L_0x0065:
            boolean r1 = r0 instanceof org.apache.pdfbox.cos.COSName
            if (r1 == 0) goto L_0x0081
            org.apache.pdfbox.cos.COSName r0 = (org.apache.pdfbox.cos.COSName) r0
            java.lang.String r1 = r0.getName()
            r3.add(r5, r1)
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r3.differences
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            java.lang.String r0 = r0.getName()
            r1.put(r2, r0)
            int r5 = r5 + 1
        L_0x0081:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.encoding.DictionaryEncoding.<init>(org.apache.pdfbox.cos.COSDictionary, boolean, org.apache.pdfbox.pdmodel.font.encoding.Encoding):void");
    }
}
