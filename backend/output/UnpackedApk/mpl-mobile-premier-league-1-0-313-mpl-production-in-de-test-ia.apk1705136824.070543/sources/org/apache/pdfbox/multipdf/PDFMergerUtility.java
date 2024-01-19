package org.apache.pdfbox.multipdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTreeNode;

public class PDFMergerUtility {
    public static final String STRUCTURETYPE_DOCUMENT = "Document";
    public String destinationFileName;
    public OutputStream destinationStream;
    public boolean ignoreAcroFormErrors = false;
    public int nextFieldNum = 1;
    public final List<InputStream> sources = new ArrayList();

    private boolean isDynamicXfa(PDAcroForm pDAcroForm) {
        return pDAcroForm != null && pDAcroForm.xfaIsDynamic();
    }

    private void mergeAcroForm(PDFCloneUtility pDFCloneUtility, PDAcroForm pDAcroForm, PDAcroForm pDAcroForm2) throws IOException {
        List fields = pDAcroForm.getFields();
        List<PDFieldTreeNode> fields2 = pDAcroForm2.getFields();
        if (fields2 != null) {
            if (fields == null) {
                fields = new COSArrayList();
                pDAcroForm.setFields(fields);
            }
            for (PDFieldTreeNode dictionary : fields2) {
                PDFieldTreeNode createField = PDFieldTreeNode.createField(pDAcroForm, (COSDictionary) pDFCloneUtility.cloneForNewDocument(dictionary.getDictionary()), null);
                if (pDAcroForm.getField(createField.getFullyQualifiedName()) != null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("dummyFieldName");
                    int i = this.nextFieldNum;
                    this.nextFieldNum = i + 1;
                    outline73.append(i);
                    createField.setPartialName(outline73.toString());
                }
                fields.add(createField);
            }
        }
    }

    private void updatePageReferences(COSDictionary cOSDictionary, Map<COSDictionary, COSDictionary> map) {
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.PG);
        if ((dictionaryObject instanceof COSDictionary) && map.containsKey(dictionaryObject)) {
            cOSDictionary.setItem(COSName.PG, (COSBase) map.get(dictionaryObject));
        }
        COSBase dictionaryObject2 = cOSDictionary.getDictionaryObject(COSName.OBJ);
        if ((dictionaryObject2 instanceof COSDictionary) && map.containsKey(dictionaryObject)) {
            cOSDictionary.setItem(COSName.OBJ, (COSBase) map.get(dictionaryObject2));
        }
        COSBase dictionaryObject3 = cOSDictionary.getDictionaryObject(COSName.K);
        if (dictionaryObject3 instanceof COSArray) {
            updatePageReferences((COSArray) dictionaryObject3, map);
        } else if (dictionaryObject3 instanceof COSDictionary) {
            updatePageReferences((COSDictionary) dictionaryObject3, map);
        }
    }

    private void updateParentEntry(COSArray cOSArray, COSDictionary cOSDictionary) {
        for (int i = 0; i < cOSArray.size(); i++) {
            COSBase object = cOSArray.getObject(i);
            if (object instanceof COSDictionary) {
                COSDictionary cOSDictionary2 = (COSDictionary) object;
                if (cOSDictionary2.getDictionaryObject(COSName.P) != null) {
                    cOSDictionary2.setItem(COSName.P, (COSBase) cOSDictionary);
                }
            }
        }
    }

    private void updateStructParentEntries(PDPage pDPage, int i) throws IOException {
        pDPage.setStructParents(pDPage.getStructParents() + i);
        List<PDAnnotation> annotations = pDPage.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (PDAnnotation next : annotations) {
            next.setStructParent(next.getStructParent() + i);
            arrayList.add(next);
        }
        pDPage.setAnnotations(arrayList);
    }

    public void addSource(String str) throws FileNotFoundException {
        this.sources.add(new FileInputStream(new File(str)));
    }

    public void addSources(List<InputStream> list) {
        this.sources.addAll(list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appendDocument(org.apache.pdfbox.pdmodel.PDDocument r22, org.apache.pdfbox.pdmodel.PDDocument r23) throws java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            boolean r0 = r22.isEncrypted()
            if (r0 != 0) goto L_0x0353
            boolean r0 = r23.isEncrypted()
            if (r0 != 0) goto L_0x034b
            org.apache.pdfbox.pdmodel.PDDocumentCatalog r3 = r22.getDocumentCatalog()
            org.apache.pdfbox.pdmodel.PDDocumentCatalog r4 = r23.getDocumentCatalog()
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm r0 = r4.getAcroForm()
            boolean r0 = r1.isDynamicXfa(r0)
            if (r0 != 0) goto L_0x0343
            org.apache.pdfbox.pdmodel.PDDocumentInformation r0 = r22.getDocumentInformation()
            org.apache.pdfbox.pdmodel.PDDocumentInformation r5 = r23.getDocumentInformation()
            org.apache.pdfbox.cos.COSDictionary r0 = r0.getDictionary()
            org.apache.pdfbox.cos.COSDictionary r5 = r5.getDictionary()
            r0.mergeInto(r5)
            float r0 = r22.getVersion()
            float r5 = r23.getVersion()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            r2.setVersion(r5)
        L_0x0044:
            org.apache.pdfbox.pdmodel.common.PDDestinationOrAction r0 = r3.getOpenAction()
            if (r0 != 0) goto L_0x0051
            org.apache.pdfbox.pdmodel.common.PDDestinationOrAction r0 = r4.getOpenAction()
            r3.setOpenAction(r0)
        L_0x0051:
            org.apache.pdfbox.multipdf.PDFCloneUtility r5 = new org.apache.pdfbox.multipdf.PDFCloneUtility
            r5.<init>(r2)
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm r0 = r3.getAcroForm()     // Catch:{ IOException -> 0x007a }
            org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm r6 = r4.getAcroForm()     // Catch:{ IOException -> 0x007a }
            if (r0 != 0) goto L_0x0074
            if (r6 == 0) goto L_0x0074
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()     // Catch:{ IOException -> 0x007a }
            org.apache.pdfbox.cos.COSName r7 = org.apache.pdfbox.cos.COSName.ACRO_FORM     // Catch:{ IOException -> 0x007a }
            org.apache.pdfbox.cos.COSDictionary r6 = r6.getDictionary()     // Catch:{ IOException -> 0x007a }
            org.apache.pdfbox.cos.COSBase r6 = r5.cloneForNewDocument(r6)     // Catch:{ IOException -> 0x007a }
            r0.setItem(r7, r6)     // Catch:{ IOException -> 0x007a }
            goto L_0x007f
        L_0x0074:
            if (r6 == 0) goto L_0x007f
            r1.mergeAcroForm(r5, r0, r6)     // Catch:{ IOException -> 0x007a }
            goto L_0x007f
        L_0x007a:
            r0 = move-exception
            boolean r6 = r1.ignoreAcroFormErrors
            if (r6 == 0) goto L_0x033d
        L_0x007f:
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.THREADS
            org.apache.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r6)
            org.apache.pdfbox.cos.COSArray r0 = (org.apache.pdfbox.cos.COSArray) r0
            org.apache.pdfbox.cos.COSDictionary r6 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r7 = org.apache.pdfbox.cos.COSName.THREADS
            org.apache.pdfbox.cos.COSBase r6 = r6.getDictionaryObject(r7)
            org.apache.pdfbox.cos.COSBase r6 = r5.cloneForNewDocument(r6)
            org.apache.pdfbox.cos.COSArray r6 = (org.apache.pdfbox.cos.COSArray) r6
            if (r0 != 0) goto L_0x00a7
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r7 = org.apache.pdfbox.cos.COSName.THREADS
            r0.setItem(r7, r6)
            goto L_0x00aa
        L_0x00a7:
            r0.addAll(r6)
        L_0x00aa:
            org.apache.pdfbox.pdmodel.PDDocumentNameDictionary r0 = r3.getNames()
            org.apache.pdfbox.pdmodel.PDDocumentNameDictionary r6 = r4.getNames()
            if (r6 == 0) goto L_0x00c7
            if (r0 != 0) goto L_0x00c4
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r7 = org.apache.pdfbox.cos.COSName.NAMES
            org.apache.pdfbox.cos.COSBase r6 = r5.cloneForNewDocument(r6)
            r0.setItem(r7, r6)
            goto L_0x00c7
        L_0x00c4:
            r5.cloneMerge(r6, r0)
        L_0x00c7:
            org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline r0 = r3.getDocumentOutline()
            org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline r6 = r4.getDocumentOutline()
            if (r6 == 0) goto L_0x00f6
            if (r0 != 0) goto L_0x00e2
            org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline r0 = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline
            org.apache.pdfbox.cos.COSBase r6 = r5.cloneForNewDocument(r6)
            org.apache.pdfbox.cos.COSDictionary r6 = (org.apache.pdfbox.cos.COSDictionary) r6
            r0.<init>(r6)
            r3.setDocumentOutline(r0)
            goto L_0x00f6
        L_0x00e2:
            org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem r6 = r6.getFirstChild()
            if (r6 == 0) goto L_0x00f6
            org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem r7 = new org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem
            org.apache.pdfbox.cos.COSBase r6 = r5.cloneForNewDocument(r6)
            org.apache.pdfbox.cos.COSDictionary r6 = (org.apache.pdfbox.cos.COSDictionary) r6
            r7.<init>(r6)
            r0.addLast(r7)
        L_0x00f6:
            org.apache.pdfbox.pdmodel.PageMode r0 = r3.getPageMode()
            org.apache.pdfbox.pdmodel.PageMode r6 = r4.getPageMode()
            if (r0 != 0) goto L_0x0103
            r3.setPageMode(r6)
        L_0x0103:
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.PAGE_LABELS
            org.apache.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r6)
            org.apache.pdfbox.cos.COSDictionary r0 = (org.apache.pdfbox.cos.COSDictionary) r0
            org.apache.pdfbox.cos.COSDictionary r6 = r4.getCOSObject()
            org.apache.pdfbox.cos.COSName r7 = org.apache.pdfbox.cos.COSName.PAGE_LABELS
            org.apache.pdfbox.cos.COSBase r6 = r6.getDictionaryObject(r7)
            org.apache.pdfbox.cos.COSDictionary r6 = (org.apache.pdfbox.cos.COSDictionary) r6
            r7 = 0
            if (r6 == 0) goto L_0x017b
            int r8 = r22.getNumberOfPages()
            if (r0 != 0) goto L_0x013d
            org.apache.pdfbox.cos.COSDictionary r0 = new org.apache.pdfbox.cos.COSDictionary
            r0.<init>()
            org.apache.pdfbox.cos.COSArray r9 = new org.apache.pdfbox.cos.COSArray
            r9.<init>()
            org.apache.pdfbox.cos.COSName r10 = org.apache.pdfbox.cos.COSName.NUMS
            r0.setItem(r10, r9)
            org.apache.pdfbox.cos.COSDictionary r10 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r11 = org.apache.pdfbox.cos.COSName.PAGE_LABELS
            r10.setItem(r11, r0)
            goto L_0x0146
        L_0x013d:
            org.apache.pdfbox.cos.COSName r9 = org.apache.pdfbox.cos.COSName.NUMS
            org.apache.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r9)
            r9 = r0
            org.apache.pdfbox.cos.COSArray r9 = (org.apache.pdfbox.cos.COSArray) r9
        L_0x0146:
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.NUMS
            org.apache.pdfbox.cos.COSBase r0 = r6.getDictionaryObject(r0)
            org.apache.pdfbox.cos.COSArray r0 = (org.apache.pdfbox.cos.COSArray) r0
            if (r0 == 0) goto L_0x017b
            r6 = 0
        L_0x0151:
            int r10 = r0.size()
            if (r6 >= r10) goto L_0x017b
            org.apache.pdfbox.cos.COSBase r10 = r0.getObject(r6)
            org.apache.pdfbox.cos.COSNumber r10 = (org.apache.pdfbox.cos.COSNumber) r10
            int r10 = r10.intValue()
            long r10 = (long) r10
            long r12 = (long) r8
            long r10 = r10 + r12
            org.apache.pdfbox.cos.COSInteger r10 = org.apache.pdfbox.cos.COSInteger.get(r10)
            r9.add(r10)
            int r10 = r6 + 1
            org.apache.pdfbox.cos.COSBase r10 = r0.getObject(r10)
            org.apache.pdfbox.cos.COSBase r10 = r5.cloneForNewDocument(r10)
            r9.add(r10)
            int r6 = r6 + 2
            goto L_0x0151
        L_0x017b:
            org.apache.pdfbox.cos.COSDictionary r0 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.METADATA
            org.apache.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r6)
            org.apache.pdfbox.cos.COSStream r0 = (org.apache.pdfbox.cos.COSStream) r0
            org.apache.pdfbox.cos.COSDictionary r6 = r4.getCOSObject()
            org.apache.pdfbox.cos.COSName r8 = org.apache.pdfbox.cos.COSName.METADATA
            org.apache.pdfbox.cos.COSBase r6 = r6.getDictionaryObject(r8)
            org.apache.pdfbox.cos.COSStream r6 = (org.apache.pdfbox.cos.COSStream) r6
            if (r0 != 0) goto L_0x01b3
            if (r6 == 0) goto L_0x01b3
            org.apache.pdfbox.pdmodel.common.PDStream r0 = new org.apache.pdfbox.pdmodel.common.PDStream
            java.io.InputStream r8 = r6.getUnfilteredStream()
            r0.<init>(r2, r8, r7)
            org.apache.pdfbox.cos.COSStream r8 = r0.getStream()
            r8.mergeInto(r6)
            r0.addCompression()
            org.apache.pdfbox.cos.COSDictionary r6 = r3.getCOSObject()
            org.apache.pdfbox.cos.COSName r8 = org.apache.pdfbox.cos.COSName.METADATA
            r6.setItem(r8, r0)
        L_0x01b3:
            r0 = -1
            org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo r6 = r3.getMarkInfo()
            org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot r8 = r3.getStructureTreeRoot()
            r4.getMarkInfo()
            org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot r9 = r4.getStructureTreeRoot()
            r10 = 0
            if (r8 == 0) goto L_0x0221
            org.apache.pdfbox.pdmodel.common.PDNumberTreeNode r0 = r8.getParentTree()
            int r12 = r8.getParentTreeNextKey()
            if (r0 == 0) goto L_0x0208
            org.apache.pdfbox.cos.COSDictionary r0 = r0.getCOSDictionary()
            org.apache.pdfbox.cos.COSName r13 = org.apache.pdfbox.cos.COSName.NUMS
            org.apache.pdfbox.cos.COSBase r13 = r0.getDictionaryObject(r13)
            org.apache.pdfbox.cos.COSArray r13 = (org.apache.pdfbox.cos.COSArray) r13
            if (r13 == 0) goto L_0x0200
            if (r12 >= 0) goto L_0x01e6
            int r12 = r13.size()
            int r12 = r12 / 2
        L_0x01e6:
            if (r12 <= 0) goto L_0x0200
            if (r9 == 0) goto L_0x0200
            org.apache.pdfbox.pdmodel.common.PDNumberTreeNode r14 = r9.getParentTree()
            if (r14 == 0) goto L_0x0200
            org.apache.pdfbox.cos.COSDictionary r14 = r14.getCOSDictionary()
            org.apache.pdfbox.cos.COSName r15 = org.apache.pdfbox.cos.COSName.NUMS
            org.apache.pdfbox.cos.COSBase r14 = r14.getDictionaryObject(r15)
            org.apache.pdfbox.cos.COSArray r14 = (org.apache.pdfbox.cos.COSArray) r14
            if (r14 == 0) goto L_0x0201
            r15 = 1
            goto L_0x0202
        L_0x0200:
            r14 = r10
        L_0x0201:
            r15 = 0
        L_0x0202:
            r20 = r12
            r12 = r0
            r0 = r20
            goto L_0x020d
        L_0x0208:
            r13 = r10
            r14 = r13
            r0 = r12
            r15 = 0
            r12 = r14
        L_0x020d:
            if (r6 == 0) goto L_0x021a
            boolean r16 = r6.isMarked()
            if (r16 == 0) goto L_0x021a
            if (r15 != 0) goto L_0x021a
            r6.setMarked(r7)
        L_0x021a:
            if (r15 != 0) goto L_0x021f
            r3.setStructureTreeRoot(r10)
        L_0x021f:
            r10 = r14
            goto L_0x0224
        L_0x0221:
            r12 = r10
            r13 = r12
            r15 = 0
        L_0x0224:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            org.apache.pdfbox.pdmodel.PDPageTree r4 = r4.getPages()
            java.util.Iterator r4 = r4.iterator()
        L_0x0231:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x02c0
            java.lang.Object r6 = r4.next()
            org.apache.pdfbox.pdmodel.PDPage r6 = (org.apache.pdfbox.pdmodel.PDPage) r6
            org.apache.pdfbox.pdmodel.PDPage r14 = new org.apache.pdfbox.pdmodel.PDPage
            org.apache.pdfbox.cos.COSDictionary r7 = r6.getCOSObject()
            org.apache.pdfbox.cos.COSBase r7 = r5.cloneForNewDocument(r7)
            org.apache.pdfbox.cos.COSDictionary r7 = (org.apache.pdfbox.cos.COSDictionary) r7
            r14.<init>(r7)
            org.apache.pdfbox.pdmodel.common.PDRectangle r7 = r6.getCropBox()
            r14.setCropBox(r7)
            org.apache.pdfbox.pdmodel.common.PDRectangle r7 = r6.getMediaBox()
            r14.setMediaBox(r7)
            int r7 = r6.getRotation()
            r14.setRotation(r7)
            org.apache.pdfbox.pdmodel.PDResources r7 = new org.apache.pdfbox.pdmodel.PDResources
            org.apache.pdfbox.pdmodel.PDResources r11 = r6.getResources()
            org.apache.pdfbox.cos.COSBase r11 = r5.cloneForNewDocument(r11)
            org.apache.pdfbox.cos.COSDictionary r11 = (org.apache.pdfbox.cos.COSDictionary) r11
            r7.<init>(r11)
            r14.setResources(r7)
            if (r15 == 0) goto L_0x02b2
            r1.updateStructParentEntries(r14, r0)
            org.apache.pdfbox.cos.COSDictionary r7 = r6.getCOSObject()
            org.apache.pdfbox.cos.COSDictionary r11 = r14.getCOSObject()
            r3.put(r7, r11)
            java.util.List r6 = r6.getAnnotations()
            java.util.List r7 = r14.getAnnotations()
            r17 = r4
            r11 = 0
        L_0x028e:
            int r4 = r6.size()
            if (r11 >= r4) goto L_0x02b4
            java.lang.Object r4 = r6.get(r11)
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation r4 = (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation) r4
            org.apache.pdfbox.cos.COSDictionary r4 = r4.getDictionary()
            java.lang.Object r18 = r7.get(r11)
            org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation r18 = (org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation) r18
            r19 = r5
            org.apache.pdfbox.cos.COSDictionary r5 = r18.getDictionary()
            r3.put(r4, r5)
            int r11 = r11 + 1
            r5 = r19
            goto L_0x028e
        L_0x02b2:
            r17 = r4
        L_0x02b4:
            r19 = r5
            r2.addPage(r14)
            r4 = r17
            r5 = r19
            r7 = 0
            goto L_0x0231
        L_0x02c0:
            if (r15 == 0) goto L_0x033c
            r1.updatePageReferences(r10, r3)
            r7 = 0
        L_0x02c6:
            int r2 = r10.size()
            int r2 = r2 / 2
            if (r7 >= r2) goto L_0x02e6
            int r2 = r0 + r7
            long r2 = (long) r2
            org.apache.pdfbox.cos.COSInteger r2 = org.apache.pdfbox.cos.COSInteger.get(r2)
            r13.add(r2)
            int r2 = r7 * 2
            r3 = 1
            int r2 = r2 + r3
            org.apache.pdfbox.cos.COSBase r2 = r10.getObject(r2)
            r13.add(r2)
            int r7 = r7 + 1
            goto L_0x02c6
        L_0x02e6:
            int r2 = r10.size()
            int r2 = r2 / 2
            int r2 = r2 + r0
            org.apache.pdfbox.cos.COSName r0 = org.apache.pdfbox.cos.COSName.NUMS
            r12.setItem(r0, r13)
            org.apache.pdfbox.pdmodel.common.PDNumberTreeNode r0 = new org.apache.pdfbox.pdmodel.common.PDNumberTreeNode
            java.lang.Class<org.apache.pdfbox.cos.COSBase> r3 = org.apache.pdfbox.cos.COSBase.class
            r0.<init>(r12, r3)
            r8.setParentTree(r0)
            r8.setParentTreeNextKey(r2)
            org.apache.pdfbox.cos.COSDictionary r0 = new org.apache.pdfbox.cos.COSDictionary
            r0.<init>()
            org.apache.pdfbox.cos.COSArray r2 = new org.apache.pdfbox.cos.COSArray
            r2.<init>()
            org.apache.pdfbox.cos.COSArray r3 = r8.getKArray()
            org.apache.pdfbox.cos.COSArray r4 = r9.getKArray()
            if (r3 == 0) goto L_0x0323
            if (r4 == 0) goto L_0x0323
            r1.updateParentEntry(r3, r0)
            r2.addAll(r3)
            if (r15 == 0) goto L_0x0320
            r1.updateParentEntry(r4, r0)
        L_0x0320:
            r2.addAll(r4)
        L_0x0323:
            org.apache.pdfbox.cos.COSName r3 = org.apache.pdfbox.cos.COSName.K
            r0.setItem(r3, r2)
            org.apache.pdfbox.cos.COSName r2 = org.apache.pdfbox.cos.COSName.P
            r0.setItem(r2, r8)
            org.apache.pdfbox.cos.COSName r2 = org.apache.pdfbox.cos.COSName.S
            org.apache.pdfbox.cos.COSString r3 = new org.apache.pdfbox.cos.COSString
            java.lang.String r4 = "Document"
            r3.<init>(r4)
            r0.setItem(r2, r3)
            r8.setK(r0)
        L_0x033c:
            return
        L_0x033d:
            java.io.IOException r2 = new java.io.IOException
            r2.<init>(r0)
            throw r2
        L_0x0343:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Error: can't merge source document containing dynamic XFA form content."
            r0.<init>(r2)
            throw r0
        L_0x034b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Error: source PDF is encrypted, can't append encrypted PDF documents."
            r0.<init>(r2)
            throw r0
        L_0x0353:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Error: destination PDF is encrypted, can't append encrypted PDF documents."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.multipdf.PDFMergerUtility.appendDocument(org.apache.pdfbox.pdmodel.PDDocument, org.apache.pdfbox.pdmodel.PDDocument):void");
    }

    public String getDestinationFileName() {
        return this.destinationFileName;
    }

    public OutputStream getDestinationStream() {
        return this.destinationStream;
    }

    public boolean isIgnoreAcroFormErrors() {
        return this.ignoreAcroFormErrors;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c A[LOOP:2: B:25:0x0066->B:27:0x006c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeDocuments() throws java.io.IOException {
        /*
            r4 = this;
            java.util.List<java.io.InputStream> r0 = r4.sources
            if (r0 == 0) goto L_0x0077
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0077
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.List<java.io.InputStream> r2 = r4.sources     // Catch:{ all -> 0x005a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005a }
            org.apache.pdfbox.pdmodel.PDDocument r3 = new org.apache.pdfbox.pdmodel.PDDocument     // Catch:{ all -> 0x005a }
            r3.<init>()     // Catch:{ all -> 0x005a }
        L_0x001b:
            boolean r1 = r2.hasNext()     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r2.next()     // Catch:{ all -> 0x0058 }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0058 }
            org.apache.pdfbox.pdmodel.PDDocument r1 = org.apache.pdfbox.pdmodel.PDDocument.load(r1)     // Catch:{ all -> 0x0058 }
            r0.add(r1)     // Catch:{ all -> 0x0058 }
            r4.appendDocument(r3, r1)     // Catch:{ all -> 0x0058 }
            goto L_0x001b
        L_0x0032:
            java.io.OutputStream r1 = r4.destinationStream     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x003c
            java.lang.String r1 = r4.destinationFileName     // Catch:{ all -> 0x0058 }
            r3.save(r1)     // Catch:{ all -> 0x0058 }
            goto L_0x0041
        L_0x003c:
            java.io.OutputStream r1 = r4.destinationStream     // Catch:{ all -> 0x0058 }
            r3.save(r1)     // Catch:{ all -> 0x0058 }
        L_0x0041:
            r3.close()
            java.util.Iterator r0 = r0.iterator()
        L_0x0048:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0077
            java.lang.Object r1 = r0.next()
            org.apache.pdfbox.pdmodel.PDDocument r1 = (org.apache.pdfbox.pdmodel.PDDocument) r1
            r1.close()
            goto L_0x0048
        L_0x0058:
            r1 = move-exception
            goto L_0x005d
        L_0x005a:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L_0x005d:
            if (r3 == 0) goto L_0x0062
            r3.close()
        L_0x0062:
            java.util.Iterator r0 = r0.iterator()
        L_0x0066:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0076
            java.lang.Object r2 = r0.next()
            org.apache.pdfbox.pdmodel.PDDocument r2 = (org.apache.pdfbox.pdmodel.PDDocument) r2
            r2.close()
            goto L_0x0066
        L_0x0076:
            throw r1
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.multipdf.PDFMergerUtility.mergeDocuments():void");
    }

    public void setDestinationFileName(String str) {
        this.destinationFileName = str;
    }

    public void setDestinationStream(OutputStream outputStream) {
        this.destinationStream = outputStream;
    }

    public void setIgnoreAcroFormErrors(boolean z) {
        this.ignoreAcroFormErrors = z;
    }

    public void addSource(File file) throws FileNotFoundException {
        this.sources.add(new FileInputStream(file));
    }

    public void addSource(InputStream inputStream) {
        this.sources.add(inputStream);
    }

    private void updatePageReferences(COSArray cOSArray, Map<COSDictionary, COSDictionary> map) {
        for (int i = 0; i < cOSArray.size(); i++) {
            COSBase object = cOSArray.getObject(i);
            if (object instanceof COSArray) {
                updatePageReferences((COSArray) object, map);
            } else if (object instanceof COSDictionary) {
                updatePageReferences((COSDictionary) object, map);
            }
        }
    }
}
