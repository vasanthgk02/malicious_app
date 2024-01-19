package org.apache.pdfbox.pdfparser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.PushBackInputStream;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;

public class FDFParser extends COSParser {
    public static final InputStream EMPTY_INPUT_STREAM = new ByteArrayInputStream(new byte[0]);
    public final RandomAccessBufferedFileInputStream raStream;
    public File tempPDFFile;

    public FDFParser(String str) throws IOException {
        this(new File(str));
    }

    private void deleteTempFile() {
        File file = this.tempPDFFile;
        if (file != null) {
            try {
                if (!file.delete()) {
                    this.tempPDFFile.getName();
                }
            } catch (SecurityException unused) {
                this.tempPDFFile.getName();
            }
        }
    }

    private void init() throws IOException {
        String property = System.getProperty(COSParser.SYSPROP_EOFLOOKUPRANGE);
        if (property != null) {
            try {
                setEOFLookupRange(Integer.parseInt(property));
            } catch (NumberFormatException unused) {
            }
        }
        this.document = new COSDocument(false);
        this.pdfSource = new PushBackInputStream(this.raStream, 4096);
    }

    private void initialParse() throws IOException {
        COSDictionary cOSDictionary;
        long startxrefOffset = getStartxrefOffset();
        if (startxrefOffset > 0) {
            cOSDictionary = parseXref(startxrefOffset);
        } else {
            cOSDictionary = rebuildTrailer();
        }
        for (COSBase next : cOSDictionary.getValues()) {
            if (next instanceof COSObject) {
                parseObjectDynamically((COSObject) next, false);
            }
        }
        COSObject cOSObject = (COSObject) cOSDictionary.getItem(COSName.ROOT);
        if (cOSObject != null) {
            COSBase parseObjectDynamically = parseObjectDynamically(cOSObject, false);
            if (parseObjectDynamically instanceof COSDictionary) {
                parseDictObjects((COSDictionary) parseObjectDynamically, null);
            }
            this.initialParseDone = true;
            return;
        }
        throw new IOException("Missing root object specification in trailer.");
    }

    public FDFDocument getFDFDocument() throws IOException {
        return new FDFDocument(getDocument());
    }

    public void parse() throws IOException {
        try {
            if (parseFDFHeader()) {
                initialParse();
                IOUtils.closeQuietly(this.pdfSource);
                deleteTempFile();
                return;
            }
            throw new IOException("Error: Header doesn't contain versioninfo");
        } catch (Throwable th) {
            IOUtils.closeQuietly(this.pdfSource);
            deleteTempFile();
            COSDocument cOSDocument = this.document;
            if (cOSDocument != null) {
                try {
                    cOSDocument.close();
                    this.document = null;
                } catch (IOException unused) {
                }
            }
            throw th;
        }
    }

    public FDFParser(File file) throws IOException {
        super(EMPTY_INPUT_STREAM);
        this.fileLen = file.length();
        this.raStream = new RandomAccessBufferedFileInputStream(file);
        init();
    }

    public FDFParser(InputStream inputStream) throws IOException {
        super(EMPTY_INPUT_STREAM);
        File createTmpFile = createTmpFile(inputStream);
        this.tempPDFFile = createTmpFile;
        this.fileLen = createTmpFile.length();
        this.raStream = new RandomAccessBufferedFileInputStream(this.tempPDFFile);
        init();
    }
}
