package org.apache.pdfbox.pdmodel.fdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdfparser.FDFParser;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FDFDocument implements Closeable {
    public COSDocument document;

    public FDFDocument() throws IOException {
        COSDocument cOSDocument = new COSDocument();
        this.document = cOSDocument;
        cOSDocument.setVersion(1.2f);
        this.document.setTrailer(new COSDictionary());
        setCatalog(new FDFCatalog());
    }

    public static FDFDocument load(String str) throws IOException {
        FDFParser fDFParser = new FDFParser(str);
        fDFParser.parse();
        return fDFParser.getFDFDocument();
    }

    public static FDFDocument loadXFDF(String str) throws IOException {
        return loadXFDF((InputStream) new BufferedInputStream(new FileInputStream(str)));
    }

    public void close() throws IOException {
        this.document.close();
    }

    public FDFCatalog getCatalog() {
        COSDictionary cOSDictionary = (COSDictionary) this.document.getTrailer().getDictionaryObject(COSName.ROOT);
        if (cOSDictionary != null) {
            return new FDFCatalog(cOSDictionary);
        }
        FDFCatalog fDFCatalog = new FDFCatalog();
        setCatalog(fDFCatalog);
        return fDFCatalog;
    }

    public COSDocument getDocument() {
        return this.document;
    }

    public void save(File file) throws IOException {
        save((OutputStream) new FileOutputStream(file));
    }

    public void saveXFDF(File file) throws IOException {
        saveXFDF((Writer) new BufferedWriter(new FileWriter(file)));
    }

    public void setCatalog(FDFCatalog fDFCatalog) {
        this.document.getTrailer().setItem(COSName.ROOT, (COSObjectable) fDFCatalog);
    }

    public void writeXML(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.write("<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n");
        getCatalog().writeXML(writer);
        writer.write("</xfdf>\n");
    }

    public static FDFDocument loadXFDF(File file) throws IOException {
        return loadXFDF((InputStream) new BufferedInputStream(new FileInputStream(file)));
    }

    public void save(String str) throws IOException {
        save((OutputStream) new FileOutputStream(str));
    }

    public void saveXFDF(String str) throws IOException {
        saveXFDF((Writer) new BufferedWriter(new FileWriter(str)));
    }

    public static FDFDocument loadXFDF(InputStream inputStream) throws IOException {
        return new FDFDocument(XMLUtil.parse(inputStream));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save(java.io.OutputStream r3) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            org.apache.pdfbox.pdfwriter.COSWriter r1 = new org.apache.pdfbox.pdfwriter.COSWriter     // Catch:{ all -> 0x0013 }
            r1.<init>(r3)     // Catch:{ all -> 0x0013 }
            r1.write(r2)     // Catch:{ all -> 0x0010 }
            r1.close()     // Catch:{ all -> 0x0010 }
            r1.close()
            return
        L_0x0010:
            r3 = move-exception
            r0 = r1
            goto L_0x0014
        L_0x0013:
            r3 = move-exception
        L_0x0014:
            if (r0 == 0) goto L_0x0019
            r0.close()
        L_0x0019:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.fdf.FDFDocument.save(java.io.OutputStream):void");
    }

    public void saveXFDF(Writer writer) throws IOException {
        try {
            writeXML(writer);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static FDFDocument load(File file) throws IOException {
        FDFParser fDFParser = new FDFParser(file);
        fDFParser.parse();
        return fDFParser.getFDFDocument();
    }

    public FDFDocument(COSDocument cOSDocument) {
        this.document = cOSDocument;
    }

    public static FDFDocument load(InputStream inputStream) throws IOException {
        FDFParser fDFParser = new FDFParser(inputStream);
        fDFParser.parse();
        return fDFParser.getFDFDocument();
    }

    public FDFDocument(Document document2) throws IOException {
        this();
        Element documentElement = document2.getDocumentElement();
        if (documentElement.getNodeName().equals("xfdf")) {
            setCatalog(new FDFCatalog(documentElement));
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while importing xfdf document, root should be 'xfdf' and not '");
        outline73.append(documentElement.getNodeName());
        outline73.append("'");
        throw new IOException(outline73.toString());
    }
}
