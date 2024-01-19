package org.apache.pdfbox.multipdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.util.awt.AffineTransform;

public class Overlay {
    public PDDocument allPagesOverlay = null;
    public String allPagesOverlayFilename = null;
    public PDDocument defaultOverlay = null;
    public String defaultOverlayFilename = null;
    public LayoutPage defaultOverlayPage;
    public PDDocument evenPageOverlay = null;
    public String evenPageOverlayFilename = null;
    public LayoutPage evenPageOverlayPage;
    public PDDocument firstPageOverlay = null;
    public String firstPageOverlayFilename = null;
    public LayoutPage firstPageOverlayPage;
    public String inputFileName = null;
    public PDDocument inputPDFDocument = null;
    public PDDocument lastPageOverlay = null;
    public String lastPageOverlayFilename = null;
    public LayoutPage lastPageOverlayPage;
    public int numberOfOverlayPages = 0;
    public PDDocument oddPageOverlay = null;
    public String oddPageOverlayFilename = null;
    public LayoutPage oddPageOverlayPage;
    public String outputFilename = null;
    public Position position = Position.BACKGROUND;
    public final Map<Integer, PDDocument> specificPageOverlay = new HashMap();
    public Map<Integer, LayoutPage> specificPageOverlayPage = new HashMap();
    public boolean useAllOverlayPages = false;

    /* renamed from: org.apache.pdfbox.multipdf.Overlay$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$pdfbox$multipdf$Overlay$Position;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                org.apache.pdfbox.multipdf.Overlay$Position[] r0 = org.apache.pdfbox.multipdf.Overlay.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$pdfbox$multipdf$Overlay$Position = r0
                r1 = 1
                org.apache.pdfbox.multipdf.Overlay$Position r2 = org.apache.pdfbox.multipdf.Overlay.Position.FOREGROUND     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$org$apache$pdfbox$multipdf$Overlay$Position     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.apache.pdfbox.multipdf.Overlay$Position r2 = org.apache.pdfbox.multipdf.Overlay.Position.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.multipdf.Overlay.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class LayoutPage {
        public final COSStream overlayContentStream;
        public final PDRectangle overlayMediaBox;
        public final COSDictionary overlayResources;

        public /* synthetic */ LayoutPage(PDRectangle pDRectangle, COSStream cOSStream, COSDictionary cOSDictionary, AnonymousClass1 r4) {
            this(pDRectangle, cOSStream, cOSDictionary);
        }

        public LayoutPage(PDRectangle pDRectangle, COSStream cOSStream, COSDictionary cOSDictionary) {
            this.overlayMediaBox = pDRectangle;
            this.overlayContentStream = cOSStream;
            this.overlayResources = cOSDictionary;
        }
    }

    public enum Position {
        FOREGROUND,
        BACKGROUND
    }

    private void addOriginalContent(COSBase cOSBase, COSArray cOSArray) throws IOException {
        if (cOSBase instanceof COSStream) {
            cOSArray.add(cOSBase);
        } else if (cOSBase instanceof COSArray) {
            cOSArray.addAll((COSArray) cOSBase);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown content type:");
            outline73.append(cOSBase.getClass().getName());
            throw new IOException(outline73.toString());
        }
    }

    private COSStream createContentStream(COSBase cOSBase) throws IOException {
        List<COSStream> createContentStreamList = createContentStreamList(cOSBase);
        COSStream cOSStream = new COSStream();
        OutputStream createUnfilteredStream = cOSStream.createUnfilteredStream();
        for (COSStream unfilteredStream : createContentStreamList) {
            InputStream unfilteredStream2 = unfilteredStream.getUnfilteredStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = unfilteredStream2.read(bArr);
                if (read <= 0) {
                    break;
                }
                createUnfilteredStream.write(bArr, 0, read);
            }
            createUnfilteredStream.flush();
        }
        createUnfilteredStream.close();
        cOSStream.setFilters(COSName.FLATE_DECODE);
        return cOSStream;
    }

    private List<COSStream> createContentStreamList(COSBase cOSBase) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cOSBase instanceof COSStream) {
            arrayList.add((COSStream) cOSBase);
        } else if (cOSBase instanceof COSArray) {
            Iterator<COSBase> it = ((COSArray) cOSBase).iterator();
            while (it.hasNext()) {
                arrayList.addAll(createContentStreamList(it.next()));
            }
        } else if (cOSBase instanceof COSObject) {
            arrayList.addAll(createContentStreamList(((COSObject) cOSBase).getObject()));
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Contents are unknown type:");
            outline73.append(cOSBase.getClass().getName());
            throw new IOException(outline73.toString());
        }
        return arrayList;
    }

    private COSStream createOverlayStream(PDPage pDPage, LayoutPage layoutPage, COSName cOSName) throws IOException {
        PDRectangle mediaBox = pDPage.getMediaBox();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("q\nq 1 0 0 1 ");
        outline73.append(float2String((mediaBox.getWidth() - layoutPage.overlayMediaBox.getWidth()) / 2.0f));
        outline73.append(CMap.SPACE);
        outline73.append(float2String((mediaBox.getHeight() - layoutPage.overlayMediaBox.getHeight()) / 2.0f));
        outline73.append(" cm /");
        outline73.append(cOSName.getName());
        outline73.append(" Do Q\nQ\n");
        return createStream(outline73.toString());
    }

    private COSName createOverlayXObject(PDPage pDPage, LayoutPage layoutPage, COSStream cOSStream) {
        PDFormXObject pDFormXObject = new PDFormXObject(new PDStream(cOSStream));
        pDFormXObject.setResources(new PDResources(layoutPage.overlayResources));
        pDFormXObject.setFormType(1);
        pDFormXObject.setBBox(layoutPage.overlayMediaBox.createRetranslatedRectangle());
        pDFormXObject.setMatrix(new AffineTransform());
        return pDPage.getResources().add(pDFormXObject, "OL");
    }

    private COSStream createStream(String str) throws IOException {
        COSStream cOSStream = new COSStream();
        OutputStream createUnfilteredStream = cOSStream.createUnfilteredStream();
        createUnfilteredStream.write(str.getBytes("ISO-8859-1"));
        createUnfilteredStream.close();
        cOSStream.setFilters(COSName.FLATE_DECODE);
        return cOSStream;
    }

    private String float2String(float f2) {
        String plainString = new BigDecimal(String.valueOf(f2)).toPlainString();
        if (plainString.indexOf(46) > -1 && !plainString.endsWith(".0")) {
            while (plainString.endsWith("0") && !plainString.endsWith(".0")) {
                plainString = plainString.substring(0, plainString.length() - 1);
            }
        }
        return plainString;
    }

    private LayoutPage getLayoutPage(PDDocument pDDocument) throws IOException {
        PDPage page = pDDocument.getPage(0);
        COSBase dictionaryObject = page.getCOSObject().getDictionaryObject(COSName.CONTENTS);
        PDResources resources = page.getResources();
        if (resources == null) {
            resources = new PDResources();
        }
        return new LayoutPage(page.getMediaBox(), createContentStream(dictionaryObject), resources.getCOSObject(), null);
    }

    private Map<Integer, LayoutPage> getLayoutPages(PDDocument pDDocument) throws IOException {
        int numberOfPages = pDDocument.getNumberOfPages();
        HashMap hashMap = new HashMap(numberOfPages);
        for (int i = 0; i < numberOfPages; i++) {
            PDPage page = pDDocument.getPage(i);
            COSBase dictionaryObject = page.getCOSObject().getDictionaryObject(COSName.CONTENTS);
            PDResources resources = page.getResources();
            if (resources == null) {
                resources = new PDResources();
            }
            hashMap.put(Integer.valueOf(i), new LayoutPage(page.getMediaBox(), createContentStream(dictionaryObject), resources.getCOSObject(), null));
        }
        return hashMap;
    }

    private PDDocument loadPDF(String str) throws IOException {
        return PDDocument.load(new File(str));
    }

    private void loadPDFs() throws IOException {
        String str = this.inputFileName;
        if (str != null) {
            this.inputPDFDocument = loadPDF(str);
        }
        String str2 = this.defaultOverlayFilename;
        if (str2 != null) {
            this.defaultOverlay = loadPDF(str2);
        }
        PDDocument pDDocument = this.defaultOverlay;
        if (pDDocument != null) {
            this.defaultOverlayPage = getLayoutPage(pDDocument);
        }
        String str3 = this.firstPageOverlayFilename;
        if (str3 != null) {
            this.firstPageOverlay = loadPDF(str3);
        }
        PDDocument pDDocument2 = this.firstPageOverlay;
        if (pDDocument2 != null) {
            this.firstPageOverlayPage = getLayoutPage(pDDocument2);
        }
        String str4 = this.lastPageOverlayFilename;
        if (str4 != null) {
            this.lastPageOverlay = loadPDF(str4);
        }
        PDDocument pDDocument3 = this.lastPageOverlay;
        if (pDDocument3 != null) {
            this.lastPageOverlayPage = getLayoutPage(pDDocument3);
        }
        String str5 = this.oddPageOverlayFilename;
        if (str5 != null) {
            this.oddPageOverlay = loadPDF(str5);
        }
        PDDocument pDDocument4 = this.oddPageOverlay;
        if (pDDocument4 != null) {
            this.oddPageOverlayPage = getLayoutPage(pDDocument4);
        }
        String str6 = this.evenPageOverlayFilename;
        if (str6 != null) {
            this.evenPageOverlay = loadPDF(str6);
        }
        PDDocument pDDocument5 = this.evenPageOverlay;
        if (pDDocument5 != null) {
            this.evenPageOverlayPage = getLayoutPage(pDDocument5);
        }
        String str7 = this.allPagesOverlayFilename;
        if (str7 != null) {
            this.allPagesOverlay = loadPDF(str7);
        }
        PDDocument pDDocument6 = this.allPagesOverlay;
        if (pDDocument6 != null) {
            Map<Integer, LayoutPage> layoutPages = getLayoutPages(pDDocument6);
            this.specificPageOverlayPage = layoutPages;
            this.useAllOverlayPages = true;
            this.numberOfOverlayPages = layoutPages.size();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r6 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r6 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r5 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void overlayPage(org.apache.pdfbox.cos.COSArray r3, org.apache.pdfbox.pdmodel.PDPage r4, int r5, int r6) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.useAllOverlayPages
            if (r0 != 0) goto L_0x001d
            java.util.Map<java.lang.Integer, org.apache.pdfbox.multipdf.Overlay$LayoutPage> r0 = r2.specificPageOverlayPage
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x001d
            java.util.Map<java.lang.Integer, org.apache.pdfbox.multipdf.Overlay$LayoutPage> r6 = r2.specificPageOverlayPage
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r5 = r6.get(r5)
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r5 = (org.apache.pdfbox.multipdf.Overlay.LayoutPage) r5
            goto L_0x0059
        L_0x001d:
            r0 = 1
            if (r5 != r0) goto L_0x0026
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r1 = r2.firstPageOverlayPage
            if (r1 == 0) goto L_0x0026
        L_0x0024:
            r5 = r1
            goto L_0x0059
        L_0x0026:
            if (r5 != r6) goto L_0x002e
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r6 = r2.lastPageOverlayPage
            if (r6 == 0) goto L_0x002e
        L_0x002c:
            r5 = r6
            goto L_0x0059
        L_0x002e:
            int r6 = r5 % 2
            if (r6 != r0) goto L_0x0037
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r1 = r2.oddPageOverlayPage
            if (r1 == 0) goto L_0x0037
            goto L_0x0024
        L_0x0037:
            if (r6 != 0) goto L_0x003e
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r6 = r2.evenPageOverlayPage
            if (r6 == 0) goto L_0x003e
            goto L_0x002c
        L_0x003e:
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r6 = r2.defaultOverlayPage
            if (r6 == 0) goto L_0x0043
            goto L_0x002c
        L_0x0043:
            boolean r6 = r2.useAllOverlayPages
            if (r6 == 0) goto L_0x0058
            int r5 = r5 - r0
            int r6 = r2.numberOfOverlayPages
            int r5 = r5 % r6
            java.util.Map<java.lang.Integer, org.apache.pdfbox.multipdf.Overlay$LayoutPage> r6 = r2.specificPageOverlayPage
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r5 = r6.get(r5)
            org.apache.pdfbox.multipdf.Overlay$LayoutPage r5 = (org.apache.pdfbox.multipdf.Overlay.LayoutPage) r5
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            if (r5 == 0) goto L_0x0078
            org.apache.pdfbox.pdmodel.PDResources r6 = r4.getResources()
            if (r6 != 0) goto L_0x0069
            org.apache.pdfbox.pdmodel.PDResources r6 = new org.apache.pdfbox.pdmodel.PDResources
            r6.<init>()
            r4.setResources(r6)
        L_0x0069:
            org.apache.pdfbox.cos.COSStream r6 = r5.overlayContentStream
            org.apache.pdfbox.cos.COSName r6 = r2.createOverlayXObject(r4, r5, r6)
            org.apache.pdfbox.cos.COSStream r4 = r2.createOverlayStream(r4, r5, r6)
            r3.add(r4)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.multipdf.Overlay.overlayPage(org.apache.pdfbox.cos.COSArray, org.apache.pdfbox.pdmodel.PDPage, int, int):void");
    }

    private void processPages(PDDocument pDDocument) throws IOException {
        Iterator<PDPage> it = pDDocument.getPages().iterator();
        int i = 0;
        while (it.hasNext()) {
            PDPage next = it.next();
            COSDictionary cOSObject = next.getCOSObject();
            COSBase dictionaryObject = cOSObject.getDictionaryObject(COSName.CONTENTS);
            COSArray cOSArray = new COSArray();
            int ordinal = this.position.ordinal();
            if (ordinal == 0) {
                cOSArray.add((COSBase) createStream("q\n"));
                addOriginalContent(dictionaryObject, cOSArray);
                cOSArray.add((COSBase) createStream("Q\n"));
                overlayPage(cOSArray, next, i + 1, pDDocument.getNumberOfPages());
            } else if (ordinal == 1) {
                overlayPage(cOSArray, next, i + 1, pDDocument.getNumberOfPages());
                addOriginalContent(dictionaryObject, cOSArray);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown type of position:");
                outline73.append(this.position);
                throw new IOException(outline73.toString());
            }
            cOSObject.setItem(COSName.CONTENTS, (COSBase) cOSArray);
            i++;
        }
    }

    public String getDefaultOverlayFile() {
        return this.defaultOverlayFilename;
    }

    public String getInputFile() {
        return this.inputFileName;
    }

    public String getOutputFile() {
        return this.outputFilename;
    }

    /* JADX INFO: finally extract failed */
    public void overlay(Map<Integer, String> map) throws IOException {
        try {
            loadPDFs();
            for (Entry next : map.entrySet()) {
                PDDocument loadPDF = loadPDF((String) next.getValue());
                this.specificPageOverlay.put(next.getKey(), loadPDF);
                this.specificPageOverlayPage.put(next.getKey(), getLayoutPage(loadPDF));
            }
            processPages(this.inputPDFDocument);
            this.inputPDFDocument.save(this.outputFilename);
            PDDocument pDDocument = this.inputPDFDocument;
            if (pDDocument != null) {
                pDDocument.close();
            }
            PDDocument pDDocument2 = this.defaultOverlay;
            if (pDDocument2 != null) {
                pDDocument2.close();
            }
            PDDocument pDDocument3 = this.firstPageOverlay;
            if (pDDocument3 != null) {
                pDDocument3.close();
            }
            PDDocument pDDocument4 = this.lastPageOverlay;
            if (pDDocument4 != null) {
                pDDocument4.close();
            }
            PDDocument pDDocument5 = this.allPagesOverlay;
            if (pDDocument5 != null) {
                pDDocument5.close();
            }
            PDDocument pDDocument6 = this.oddPageOverlay;
            if (pDDocument6 != null) {
                pDDocument6.close();
            }
            PDDocument pDDocument7 = this.evenPageOverlay;
            if (pDDocument7 != null) {
                pDDocument7.close();
            }
            for (Entry<Integer, PDDocument> value : this.specificPageOverlay.entrySet()) {
                ((PDDocument) value.getValue()).close();
            }
            this.specificPageOverlay.clear();
            this.specificPageOverlayPage.clear();
        } catch (Throwable th) {
            PDDocument pDDocument8 = this.inputPDFDocument;
            if (pDDocument8 != null) {
                pDDocument8.close();
            }
            PDDocument pDDocument9 = this.defaultOverlay;
            if (pDDocument9 != null) {
                pDDocument9.close();
            }
            PDDocument pDDocument10 = this.firstPageOverlay;
            if (pDDocument10 != null) {
                pDDocument10.close();
            }
            PDDocument pDDocument11 = this.lastPageOverlay;
            if (pDDocument11 != null) {
                pDDocument11.close();
            }
            PDDocument pDDocument12 = this.allPagesOverlay;
            if (pDDocument12 != null) {
                pDDocument12.close();
            }
            PDDocument pDDocument13 = this.oddPageOverlay;
            if (pDDocument13 != null) {
                pDDocument13.close();
            }
            PDDocument pDDocument14 = this.evenPageOverlay;
            if (pDDocument14 != null) {
                pDDocument14.close();
            }
            for (Entry<Integer, PDDocument> value2 : this.specificPageOverlay.entrySet()) {
                ((PDDocument) value2.getValue()).close();
            }
            this.specificPageOverlay.clear();
            this.specificPageOverlayPage.clear();
            throw th;
        }
    }

    public void setAllPagesOverlayFile(String str) {
        this.allPagesOverlayFilename = str;
    }

    public void setAllPagesOverlayPDF(PDDocument pDDocument) {
        this.allPagesOverlay = pDDocument;
    }

    public void setDefaultOverlayFile(String str) {
        this.defaultOverlayFilename = str;
    }

    public void setDefaultOverlayPDF(PDDocument pDDocument) {
        this.defaultOverlay = pDDocument;
    }

    public void setEvenPageOverlayFile(String str) {
        this.evenPageOverlayFilename = str;
    }

    public void setEvenPageOverlayPDF(PDDocument pDDocument) {
        this.evenPageOverlay = pDDocument;
    }

    public void setFirstPageOverlayFile(String str) {
        this.firstPageOverlayFilename = str;
    }

    public void setFirstPageOverlayPDF(PDDocument pDDocument) {
        this.firstPageOverlay = pDDocument;
    }

    public void setInputFile(String str) {
        this.inputFileName = str;
    }

    public void setInputPDF(PDDocument pDDocument) {
        this.inputPDFDocument = pDDocument;
    }

    public void setLastPageOverlayFile(String str) {
        this.lastPageOverlayFilename = str;
    }

    public void setLastPageOverlayPDF(PDDocument pDDocument) {
        this.lastPageOverlay = pDDocument;
    }

    public void setOddPageOverlayFile(String str) {
        this.oddPageOverlayFilename = str;
    }

    public void setOddPageOverlayPDF(PDDocument pDDocument) {
        this.oddPageOverlay = pDDocument;
    }

    public void setOutputFile(String str) {
        this.outputFilename = str;
    }

    public void setOverlayPosition(Position position2) {
        this.position = position2;
    }
}
