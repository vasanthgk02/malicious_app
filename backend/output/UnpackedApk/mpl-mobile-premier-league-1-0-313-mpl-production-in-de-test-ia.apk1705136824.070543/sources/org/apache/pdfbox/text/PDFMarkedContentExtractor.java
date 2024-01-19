package org.apache.pdfbox.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.apache.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequence;
import org.apache.pdfbox.contentstream.operator.markedcontent.BeginMarkedContentSequenceWithProperties;
import org.apache.pdfbox.contentstream.operator.markedcontent.EndMarkedContentSequence;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;

public class PDFMarkedContentExtractor extends PDFTextStreamEngine {
    public Map<String, List<TextPosition>> characterListMapping;
    public Stack<PDMarkedContent> currentMarkedContents;
    public List<PDMarkedContent> markedContents;
    public boolean suppressDuplicateOverlappingText;

    public PDFMarkedContentExtractor() throws IOException {
        this(null);
    }

    private boolean within(float f2, float f3, float f4) {
        return f3 > f2 - f4 && f3 < f2 + f4;
    }

    public void beginMarkedContentSequence(COSName cOSName, COSDictionary cOSDictionary) {
        PDMarkedContent create = PDMarkedContent.create(cOSName, cOSDictionary);
        if (this.currentMarkedContents.isEmpty()) {
            this.markedContents.add(create);
        } else {
            PDMarkedContent peek = this.currentMarkedContents.peek();
            if (peek != null) {
                peek.addMarkedContent(create);
            }
        }
        this.currentMarkedContents.push(create);
    }

    public void endMarkedContentSequence() {
        if (!this.currentMarkedContents.isEmpty()) {
            this.currentMarkedContents.pop();
        }
    }

    public List<PDMarkedContent> getMarkedContents() {
        return this.markedContents;
    }

    public /* bridge */ /* synthetic */ void processPage(PDPage pDPage) throws IOException {
        super.processPage(pDPage);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processTextPosition(org.apache.pdfbox.text.TextPosition r11) {
        /*
            r10 = this;
            boolean r0 = r10.suppressDuplicateOverlappingText
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = r11.getUnicode()
            float r3 = r11.getX()
            float r4 = r11.getY()
            java.util.Map<java.lang.String, java.util.List<org.apache.pdfbox.text.TextPosition>> r5 = r10.characterListMapping
            java.lang.Object r5 = r5.get(r0)
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0026
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Map<java.lang.String, java.util.List<org.apache.pdfbox.text.TextPosition>> r6 = r10.characterListMapping
            r6.put(r0, r5)
        L_0x0026:
            float r6 = r11.getWidth()
            int r0 = r0.length()
            float r0 = (float) r0
            float r6 = r6 / r0
            r0 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 / r0
            java.util.Iterator r0 = r5.iterator()
        L_0x0037:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x005f
            java.lang.Object r7 = r0.next()
            org.apache.pdfbox.text.TextPosition r7 = (org.apache.pdfbox.text.TextPosition) r7
            java.lang.String r8 = r7.getUnicode()
            float r9 = r7.getX()
            float r7 = r7.getY()
            if (r8 == 0) goto L_0x0037
            boolean r8 = r10.within(r9, r3, r6)
            if (r8 == 0) goto L_0x0037
            boolean r7 = r10.within(r7, r4, r6)
            if (r7 == 0) goto L_0x0037
            r0 = 1
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            if (r0 != 0) goto L_0x0066
            r5.add(r11)
        L_0x0065:
            r1 = 1
        L_0x0066:
            if (r1 == 0) goto L_0x00c3
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0077
            r0.add(r11)
            goto L_0x00b0
        L_0x0077:
            int r1 = r0.size()
            int r1 = r1 - r2
            java.lang.Object r1 = r0.get(r1)
            org.apache.pdfbox.text.TextPosition r1 = (org.apache.pdfbox.text.TextPosition) r1
            boolean r3 = r11.isDiacritic()
            if (r3 == 0) goto L_0x0092
            boolean r3 = r1.contains(r11)
            if (r3 == 0) goto L_0x0092
            r1.mergeDiacritic(r11)
            goto L_0x00b0
        L_0x0092:
            boolean r3 = r1.isDiacritic()
            if (r3 == 0) goto L_0x00ad
            boolean r3 = r11.contains(r1)
            if (r3 == 0) goto L_0x00ad
            r11.mergeDiacritic(r1)
            int r1 = r0.size()
            int r1 = r1 - r2
            r0.remove(r1)
            r0.add(r11)
            goto L_0x00b0
        L_0x00ad:
            r0.add(r11)
        L_0x00b0:
            java.util.Stack<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> r0 = r10.currentMarkedContents
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00c3
            java.util.Stack<org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent> r0 = r10.currentMarkedContents
            java.lang.Object r0 = r0.peek()
            org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent r0 = (org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent) r0
            r0.addText(r11)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.text.PDFMarkedContentExtractor.processTextPosition(org.apache.pdfbox.text.TextPosition):void");
    }

    public void xobject(PDXObject pDXObject) {
        if (!this.currentMarkedContents.isEmpty()) {
            this.currentMarkedContents.peek().addXObject(pDXObject);
        }
    }

    public PDFMarkedContentExtractor(String str) throws IOException {
        this.suppressDuplicateOverlappingText = true;
        this.markedContents = new ArrayList();
        this.currentMarkedContents = new Stack<>();
        this.characterListMapping = new HashMap();
        addOperator(new BeginMarkedContentSequenceWithProperties());
        addOperator(new BeginMarkedContentSequence());
        addOperator(new EndMarkedContentSequence());
    }
}
