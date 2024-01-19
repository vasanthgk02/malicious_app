package org.apache.pdfbox.pdmodel;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import okhttp3.internal.http2.Http2Connection;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTreeNode;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;

public class PDDocument implements Closeable {
    public boolean allSecurityToBeRemoved;
    public final COSDocument document;
    public PDDocumentCatalog documentCatalog;
    public Long documentId;
    public PDDocumentInformation documentInformation;
    public final Set<PDFont> fontsToSubset;
    public File incrementalFile;
    public final BaseParser parser;
    public SignatureInterface signInterface;

    public PDDocument() {
        this.fontsToSubset = new HashSet();
        this.document = new COSDocument();
        this.parser = null;
        COSDictionary cOSDictionary = new COSDictionary();
        this.document.setTrailer(cOSDictionary);
        COSDictionary cOSDictionary2 = new COSDictionary();
        cOSDictionary.setItem(COSName.ROOT, (COSBase) cOSDictionary2);
        cOSDictionary2.setItem(COSName.TYPE, (COSBase) COSName.CATALOG);
        cOSDictionary2.setItem(COSName.VERSION, (COSBase) COSName.getPDFName(COSParser.PDF_DEFAULT_VERSION));
        COSDictionary cOSDictionary3 = new COSDictionary();
        cOSDictionary2.setItem(COSName.PAGES, (COSBase) cOSDictionary3);
        cOSDictionary3.setItem(COSName.TYPE, (COSBase) COSName.PAGES);
        cOSDictionary3.setItem(COSName.KIDS, (COSBase) new COSArray());
        cOSDictionary3.setItem(COSName.COUNT, (COSBase) COSInteger.ZERO);
    }

    public static PDDocument load(File file) throws IOException {
        return load(file, (String) "", false);
    }

    public void addPage(PDPage pDPage) {
        getPages().add(pDPage);
    }

    public void addSignature(PDSignature pDSignature, SignatureInterface signatureInterface) throws IOException {
        addSignature(pDSignature, signatureInterface, new SignatureOptions());
    }

    public void addSignatureField(List<PDSignatureField> list, SignatureInterface signatureInterface, SignatureOptions signatureOptions) throws IOException {
        PDDocumentCatalog documentCatalog2 = getDocumentCatalog();
        documentCatalog2.getCOSObject().setNeedToBeUpdated(true);
        PDAcroForm acroForm = documentCatalog2.getAcroForm();
        if (acroForm == null) {
            acroForm = new PDAcroForm(this);
            documentCatalog2.setAcroForm(acroForm);
        }
        COSDictionary dictionary = acroForm.getDictionary();
        dictionary.setDirect(true);
        dictionary.setNeedToBeUpdated(true);
        if (!acroForm.isSignaturesExist()) {
            acroForm.setSignaturesExist(true);
        }
        List<PDFieldTreeNode> fields = acroForm.getFields();
        for (PDSignatureField next : list) {
            next.getDictionary().setNeedToBeUpdated(true);
            boolean z = false;
            Iterator<PDFieldTreeNode> it = fields.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PDFieldTreeNode next2 = it.next();
                if ((next2 instanceof PDSignatureField) && next2.getCOSObject().equals(next.getCOSObject())) {
                    next.getDictionary().setNeedToBeUpdated(true);
                    z = true;
                    break;
                }
            }
            if (!z) {
                fields.add(next);
            }
            if (next.getSignature() != null) {
                next.getDictionary().setNeedToBeUpdated(true);
                addSignature(next.getSignature(), signatureInterface, signatureOptions);
            }
        }
    }

    public void close() throws IOException {
        if (!this.document.isClosed()) {
            this.document.close();
            BaseParser baseParser = this.parser;
            if (baseParser != null) {
                baseParser.close();
            }
        }
    }

    public COSDocument getDocument() {
        return this.document;
    }

    public PDDocumentCatalog getDocumentCatalog() {
        if (this.documentCatalog == null) {
            COSBase dictionaryObject = this.document.getTrailer().getDictionaryObject(COSName.ROOT);
            if (dictionaryObject instanceof COSDictionary) {
                this.documentCatalog = new PDDocumentCatalog(this, (COSDictionary) dictionaryObject);
            } else {
                this.documentCatalog = new PDDocumentCatalog(this);
            }
        }
        return this.documentCatalog;
    }

    public Long getDocumentId() {
        return this.documentId;
    }

    public PDDocumentInformation getDocumentInformation() {
        if (this.documentInformation == null) {
            COSDictionary trailer = this.document.getTrailer();
            COSDictionary cOSDictionary = (COSDictionary) trailer.getDictionaryObject(COSName.INFO);
            if (cOSDictionary == null) {
                cOSDictionary = new COSDictionary();
                trailer.setItem(COSName.INFO, (COSBase) cOSDictionary);
            }
            this.documentInformation = new PDDocumentInformation(cOSDictionary);
        }
        return this.documentInformation;
    }

    public Set<PDFont> getFontsToSubset() {
        return this.fontsToSubset;
    }

    public PDSignature getLastSignatureDictionary() throws IOException {
        List<PDSignature> signatureDictionaries = getSignatureDictionaries();
        int size = signatureDictionaries.size();
        if (size > 0) {
            return signatureDictionaries.get(size - 1);
        }
        return null;
    }

    public int getNumberOfPages() {
        return getDocumentCatalog().getPages().getCount();
    }

    public PDPage getPage(int i) {
        return getDocumentCatalog().getPages().get(i);
    }

    public PDPageTree getPages() {
        return getDocumentCatalog().getPages();
    }

    public List<PDSignature> getSignatureDictionaries() throws IOException {
        List<COSDictionary> signatureDictionaries = this.document.getSignatureDictionaries();
        LinkedList linkedList = new LinkedList();
        for (COSDictionary pDSignature : signatureDictionaries) {
            linkedList.add(new PDSignature(pDSignature));
        }
        return linkedList;
    }

    public List<PDSignatureField> getSignatureFields() throws IOException {
        LinkedList linkedList = new LinkedList();
        PDAcroForm acroForm = getDocumentCatalog().getAcroForm();
        if (acroForm != null) {
            for (COSDictionary pDSignatureField : this.document.getSignatureFields(false)) {
                linkedList.add(new PDSignatureField(acroForm, pDSignatureField, null));
            }
        }
        return linkedList;
    }

    public float getVersion() {
        float version = getDocument().getVersion();
        if (version < 1.4f) {
            return version;
        }
        String version2 = getDocumentCatalog().getVersion();
        float f2 = -1.0f;
        if (version2 != null) {
            try {
                f2 = Float.parseFloat(version2);
            } catch (NumberFormatException unused) {
            }
        }
        return Math.max(f2, version);
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v4, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.pdfbox.pdmodel.PDPage importPage(org.apache.pdfbox.pdmodel.PDPage r6) throws java.io.IOException {
        /*
            r5 = this;
            org.apache.pdfbox.pdmodel.PDPage r0 = new org.apache.pdfbox.pdmodel.PDPage
            org.apache.pdfbox.cos.COSDictionary r1 = new org.apache.pdfbox.cos.COSDictionary
            org.apache.pdfbox.cos.COSDictionary r2 = r6.getCOSObject()
            r1.<init>(r2)
            r0.<init>(r1)
            r1 = 0
            org.apache.pdfbox.pdmodel.common.PDStream r6 = r6.getStream()     // Catch:{ all -> 0x004b }
            if (r6 == 0) goto L_0x003a
            org.apache.pdfbox.pdmodel.common.PDStream r2 = new org.apache.pdfbox.pdmodel.common.PDStream     // Catch:{ all -> 0x004b }
            org.apache.pdfbox.cos.COSDocument r3 = r5.document     // Catch:{ all -> 0x004b }
            org.apache.pdfbox.cos.COSStream r3 = r3.createCOSStream()     // Catch:{ all -> 0x004b }
            r2.<init>(r3)     // Catch:{ all -> 0x004b }
            r2.addCompression()     // Catch:{ all -> 0x004b }
            r0.setContents(r2)     // Catch:{ all -> 0x004b }
            java.io.InputStream r6 = r6.createInputStream()     // Catch:{ all -> 0x004b }
            java.io.OutputStream r1 = r2.createOutputStream()     // Catch:{ all -> 0x0035 }
            org.apache.pdfbox.io.IOUtils.copy(r6, r1)     // Catch:{ all -> 0x0035 }
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x003b
        L_0x0035:
            r0 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x004d
        L_0x003a:
            r6 = r1
        L_0x003b:
            r5.addPage(r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            if (r6 == 0) goto L_0x0048
            r6.close()
        L_0x0048:
            return r0
        L_0x0049:
            r0 = move-exception
            goto L_0x004d
        L_0x004b:
            r0 = move-exception
            r6 = r1
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()
        L_0x0052:
            if (r6 == 0) goto L_0x0057
            r6.close()
        L_0x0057:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.PDDocument.importPage(org.apache.pdfbox.pdmodel.PDPage):org.apache.pdfbox.pdmodel.PDPage");
    }

    public boolean isAllSecurityToBeRemoved() {
        return this.allSecurityToBeRemoved;
    }

    public boolean isEncrypted() {
        return this.document.isEncrypted();
    }

    public void removePage(PDPage pDPage) {
        getPages().remove(pDPage);
    }

    public void save(String str) throws IOException {
        save(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveIncremental(java.io.OutputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            org.apache.pdfbox.io.RandomAccessBufferedFileInputStream r0 = new org.apache.pdfbox.io.RandomAccessBufferedFileInputStream
            java.io.File r1 = r3.incrementalFile
            r0.<init>(r1)
            r1 = 0
            org.apache.pdfbox.pdfwriter.COSWriter r2 = new org.apache.pdfbox.pdfwriter.COSWriter     // Catch:{ all -> 0x001c }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x001c }
            org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface r4 = r3.signInterface     // Catch:{ all -> 0x0019 }
            r2.write(r3, r4)     // Catch:{ all -> 0x0019 }
            r2.close()     // Catch:{ all -> 0x0019 }
            r2.close()
            return
        L_0x0019:
            r4 = move-exception
            r1 = r2
            goto L_0x001d
        L_0x001c:
            r4 = move-exception
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()
        L_0x0022:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.PDDocument.saveIncremental(java.io.OutputStream):void");
    }

    public void setAllSecurityToBeRemoved(boolean z) {
        this.allSecurityToBeRemoved = z;
    }

    public void setDocumentId(Long l) {
        this.documentId = l;
    }

    public void setDocumentInformation(PDDocumentInformation pDDocumentInformation) {
        this.documentInformation = pDDocumentInformation;
        this.document.getTrailer().setItem(COSName.INFO, (COSBase) pDDocumentInformation.getDictionary());
    }

    public void setVersion(float f2) {
        float version = getVersion();
        if (f2 != version && f2 >= version) {
            if (getDocument().getVersion() >= 1.4f) {
                getDocumentCatalog().setVersion(Float.toString(f2));
            } else {
                getDocument().setVersion(f2);
            }
        }
    }

    public static PDDocument load(File file, boolean z) throws IOException {
        return load(file, (String) "", (InputStream) null, (String) null, z);
    }

    public void addSignature(PDSignature pDSignature, SignatureInterface signatureInterface, SignatureOptions signatureOptions) throws IOException {
        boolean z;
        PDSignature pDSignature2 = pDSignature;
        int preferedSignatureSize = signatureOptions.getPreferedSignatureSize();
        if (preferedSignatureSize > 0) {
            pDSignature2.setContents(new byte[preferedSignatureSize]);
        } else {
            pDSignature2.setContents(new byte[9472]);
        }
        pDSignature2.setByteRange(new int[]{0, Http2Connection.DEGRADED_PONG_TIMEOUT_NS, Http2Connection.DEGRADED_PONG_TIMEOUT_NS, Http2Connection.DEGRADED_PONG_TIMEOUT_NS});
        this.signInterface = signatureInterface;
        PDDocumentCatalog documentCatalog2 = getDocumentCatalog();
        int count = documentCatalog2.getPages().getCount();
        if (count != 0) {
            PDPage pDPage = documentCatalog2.getPages().get(Math.min(Math.max(signatureOptions.getPage(), 0), count - 1));
            PDAcroForm acroForm = documentCatalog2.getAcroForm();
            documentCatalog2.getCOSObject().setNeedToBeUpdated(true);
            if (acroForm == null) {
                acroForm = new PDAcroForm(this);
                documentCatalog2.setAcroForm(acroForm);
            } else {
                acroForm.getDictionary().setNeedToBeUpdated(true);
            }
            List<PDAnnotation> annotations = pDPage.getAnnotations();
            List<PDFieldTreeNode> fields = acroForm.getFields();
            if (fields == null) {
                fields = new ArrayList<>();
                acroForm.setFields(fields);
            }
            PDSignatureField pDSignatureField = null;
            for (PDFieldTreeNode pDFieldTreeNode : fields) {
                if (pDFieldTreeNode instanceof PDSignatureField) {
                    PDSignatureField pDSignatureField2 = (PDSignatureField) pDFieldTreeNode;
                    PDSignature signature = pDSignatureField2.getSignature();
                    if (signature != null && signature.getDictionary().equals(pDSignature.getDictionary())) {
                        pDSignatureField = pDSignatureField2;
                    }
                }
            }
            if (pDSignatureField == null) {
                pDSignatureField = new PDSignatureField(acroForm);
                pDSignatureField.setSignature(pDSignature2);
                pDSignatureField.getWidget().setPage(pDPage);
            }
            List<PDFieldTreeNode> fields2 = acroForm.getFields();
            acroForm.getDictionary().setDirect(true);
            acroForm.setSignaturesExist(true);
            acroForm.setAppendOnly(true);
            Iterator<PDFieldTreeNode> it = fields2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                PDFieldTreeNode next = it.next();
                if ((next instanceof PDSignatureField) && ((PDSignatureField) next).getCOSObject().equals(pDSignatureField.getCOSObject())) {
                    pDSignatureField.getDictionary().setNeedToBeUpdated(true);
                    z = true;
                    break;
                }
            }
            if (!z) {
                fields2.add(pDSignatureField);
            }
            COSDocument visualSignature = signatureOptions.getVisualSignature();
            if (visualSignature == null) {
                pDSignatureField.getWidget().setRectangle(new PDRectangle());
                acroForm.setDefaultResources(null);
                PDAppearanceDictionary pDAppearanceDictionary = new PDAppearanceDictionary();
                COSStream createCOSStream = getDocument().createCOSStream();
                createCOSStream.createUnfilteredStream();
                PDAppearanceStream pDAppearanceStream = new PDAppearanceStream(createCOSStream);
                COSDictionary cOSDictionary = (COSDictionary) pDAppearanceStream.getCOSObject();
                cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.FORM);
                cOSDictionary.setItem(COSName.BBOX, (COSObjectable) new PDRectangle());
                pDAppearanceDictionary.setNormalAppearance(pDAppearanceStream);
                pDAppearanceDictionary.getCOSObject().setDirect(true);
                pDSignatureField.getWidget().setAppearance(pDAppearanceDictionary);
            } else {
                List<COSObject> objects = visualSignature.getObjects();
                COSDictionary dictionary = acroForm.getDictionary();
                boolean z2 = true;
                boolean z3 = true;
                for (COSObject next2 : objects) {
                    if (!z2 && !z3) {
                        break;
                    }
                    COSBase object = next2.getObject();
                    if (object instanceof COSDictionary) {
                        COSDictionary cOSDictionary2 = (COSDictionary) object;
                        COSBase item = cOSDictionary2.getItem(COSName.FT);
                        COSBase item2 = cOSDictionary2.getItem(COSName.TYPE);
                        COSBase item3 = cOSDictionary2.getItem(COSName.AP);
                        if (z2 && COSName.ANNOT.equals(item2)) {
                            pDSignatureField.getWidget().setRectangle(new PDRectangle((COSArray) cOSDictionary2.getItem(COSName.RECT)));
                            z2 = false;
                        }
                        if (z3 && COSName.SIG.equals(item) && item3 != null) {
                            PDAppearanceDictionary pDAppearanceDictionary2 = new PDAppearanceDictionary((COSDictionary) cOSDictionary2.getDictionaryObject(COSName.AP));
                            pDAppearanceDictionary2.getCOSObject().setDirect(true);
                            pDSignatureField.getWidget().setAppearance(pDAppearanceDictionary2);
                            COSDictionary cOSDictionary3 = (COSDictionary) cOSDictionary2.getItem(COSName.DR);
                            if (cOSDictionary3 != null) {
                                cOSDictionary3.setDirect(true);
                                cOSDictionary3.setNeedToBeUpdated(true);
                                dictionary.setItem(COSName.DR, (COSBase) cOSDictionary3);
                            }
                            z3 = false;
                        }
                    }
                }
                if (z2 || z3) {
                    throw new IllegalArgumentException("Template is missing required objects");
                }
            }
            if (!(annotations instanceof COSArrayList) || !(fields2 instanceof COSArrayList) || !((COSArrayList) annotations).toList().equals(((COSArrayList) fields2).toList()) || !z) {
                annotations.add(pDSignatureField.getWidget());
            }
            pDPage.getCOSObject().setNeedToBeUpdated(true);
            return;
        }
        throw new IllegalStateException("Cannot sign an empty document");
    }

    public void removePage(int i) {
        getPages().remove(i);
    }

    public void save(File file) throws IOException {
        save((OutputStream) new FileOutputStream(file));
    }

    public static PDDocument load(File file, String str) throws IOException {
        return load(file, str, (InputStream) null, (String) null, false);
    }

    public void save(OutputStream outputStream) throws IOException {
        if (!this.document.isClosed()) {
            for (PDFont subset : this.fontsToSubset) {
                subset.subset();
            }
            this.fontsToSubset.clear();
            COSWriter cOSWriter = new COSWriter(outputStream);
            try {
                cOSWriter.write(this);
                cOSWriter.close();
            } finally {
                cOSWriter.close();
            }
        } else {
            throw new IOException("Cannot save a document which has been closed");
        }
    }

    public static PDDocument load(File file, String str, boolean z) throws IOException {
        return load(file, str, (InputStream) null, (String) null, z);
    }

    public static PDDocument load(File file, String str, InputStream inputStream, String str2) throws IOException {
        return load(file, str, inputStream, str2, false);
    }

    public static PDDocument load(File file, String str, InputStream inputStream, String str2, boolean z) throws IOException {
        PDFParser pDFParser = new PDFParser(file, str, inputStream, str2, z);
        pDFParser.parse();
        PDDocument pDDocument = pDFParser.getPDDocument();
        pDDocument.incrementalFile = file;
        return pDDocument;
    }

    public static PDDocument load(InputStream inputStream) throws IOException {
        return load(inputStream, (String) "", (InputStream) null, (String) null, false);
    }

    public static PDDocument load(InputStream inputStream, boolean z) throws IOException {
        return load(inputStream, (String) "", (InputStream) null, (String) null, z);
    }

    public static PDDocument load(InputStream inputStream, String str) throws IOException {
        return load(inputStream, str, false);
    }

    public static PDDocument load(InputStream inputStream, String str, boolean z) throws IOException {
        return load(inputStream, str, (InputStream) null, (String) null, false);
    }

    public static PDDocument load(InputStream inputStream, String str, InputStream inputStream2, String str2) throws IOException {
        return load(inputStream, str, inputStream2, str2, false);
    }

    public static PDDocument load(InputStream inputStream, String str, InputStream inputStream2, String str2, boolean z) throws IOException {
        PDFParser pDFParser = new PDFParser(inputStream, str, inputStream2, str2, z);
        pDFParser.parse();
        return pDFParser.getPDDocument();
    }

    public PDDocument(COSDocument cOSDocument) {
        this(cOSDocument, null);
    }

    public PDDocument(COSDocument cOSDocument, BaseParser baseParser) {
        this(cOSDocument, baseParser, null);
    }

    public PDDocument(COSDocument cOSDocument, BaseParser baseParser, Void voidR) {
        this.fontsToSubset = new HashSet();
        this.document = cOSDocument;
        this.parser = baseParser;
    }
}
