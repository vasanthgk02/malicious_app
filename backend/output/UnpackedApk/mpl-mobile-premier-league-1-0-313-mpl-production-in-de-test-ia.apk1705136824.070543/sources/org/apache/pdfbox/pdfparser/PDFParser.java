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
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFParser extends COSParser {
    public static final InputStream EMPTY_INPUT_STREAM = new ByteArrayInputStream(new byte[0]);
    public String keyAlias;
    public InputStream keyStoreInputStream;
    public String password;
    public final RandomAccessBufferedFileInputStream raStream;
    public File tempPDFFile;

    public PDFParser(String str) throws IOException {
        this(new File(str), (String) null, false);
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

    private void init(boolean z) throws IOException {
        String property = System.getProperty(COSParser.SYSPROP_EOFLOOKUPRANGE);
        if (property != null) {
            try {
                setEOFLookupRange(Integer.parseInt(property));
            } catch (NumberFormatException unused) {
            }
        }
        this.document = new COSDocument(z);
        this.pdfSource = new PushBackInputStream(this.raStream, 4096);
    }

    private void parseDictionaryRecursive(COSObject cOSObject) throws IOException {
        parseObjectDynamically(cOSObject, true);
        for (COSBase next : ((COSDictionary) cOSObject.getObject()).getValues()) {
            if (next instanceof COSObject) {
                COSObject cOSObject2 = (COSObject) next;
                if (cOSObject2.getObject() == null) {
                    parseDictionaryRecursive(cOSObject2);
                }
            }
        }
    }

    public PDDocument getPDDocument() throws IOException {
        return new PDDocument(getDocument(), this, null);
    }

    public void initialParse() throws IOException {
        COSDictionary cOSDictionary;
        long startxrefOffset = getStartxrefOffset();
        if (startxrefOffset > -1) {
            cOSDictionary = parseXref(startxrefOffset);
        } else {
            cOSDictionary = isLenient() ? rebuildTrailer() : null;
        }
        for (COSBase next : cOSDictionary.getValues()) {
            if (next instanceof COSObject) {
                parseObjectDynamically((COSObject) next, false);
            }
        }
        COSObject cOSObject = (COSObject) cOSDictionary.getItem(COSName.ROOT);
        if (cOSObject != null) {
            parseObjectDynamically(cOSObject, false);
            COSObject catalog = this.document.getCatalog();
            if (catalog != null && (catalog.getObject() instanceof COSDictionary)) {
                parseDictObjects((COSDictionary) catalog.getObject(), null);
                this.document.setDecrypted();
            }
            this.initialParseDone = true;
            return;
        }
        throw new IOException("Missing root object specification in trailer.");
    }

    public void parse() throws IOException {
        try {
            if (!parsePDFHeader()) {
                if (!parseFDFHeader()) {
                    throw new IOException("Error: Header doesn't contain versioninfo");
                }
            }
            if (!this.initialParseDone) {
                initialParse();
            }
            IOUtils.closeQuietly(this.pdfSource);
            IOUtils.closeQuietly(this.keyStoreInputStream);
            deleteTempFile();
        } catch (Throwable th) {
            IOUtils.closeQuietly(this.pdfSource);
            IOUtils.closeQuietly(this.keyStoreInputStream);
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

    public PDFParser(String str, boolean z) throws IOException {
        this(new File(str), (String) null, z);
    }

    public PDFParser(File file) throws IOException {
        this(file, (String) "", false);
    }

    public PDFParser(File file, boolean z) throws IOException {
        this(file, (String) "", z);
    }

    public PDFParser(File file, String str) throws IOException {
        this(file, str, false);
    }

    public PDFParser(File file, String str, boolean z) throws IOException {
        this(file, str, (InputStream) null, (String) null, z);
    }

    public PDFParser(File file, String str, InputStream inputStream, String str2) throws IOException {
        this(file, str, inputStream, str2, false);
    }

    public PDFParser(File file, String str, InputStream inputStream, String str2, boolean z) throws IOException {
        super(EMPTY_INPUT_STREAM);
        this.password = "";
        this.keyStoreInputStream = null;
        this.keyAlias = null;
        this.fileLen = file.length();
        this.raStream = new RandomAccessBufferedFileInputStream(file);
        this.password = str;
        this.keyStoreInputStream = inputStream;
        this.keyAlias = str2;
        init(z);
    }

    public PDFParser(InputStream inputStream) throws IOException {
        this(inputStream, (String) "", false);
    }

    public PDFParser(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, (String) "", z);
    }

    public PDFParser(InputStream inputStream, String str) throws IOException {
        this(inputStream, str, false);
    }

    public PDFParser(InputStream inputStream, String str, boolean z) throws IOException {
        this(inputStream, str, (InputStream) null, (String) null, z);
    }

    public PDFParser(InputStream inputStream, String str, InputStream inputStream2, String str2) throws IOException {
        this(inputStream, str, inputStream2, str2, false);
    }

    public PDFParser(InputStream inputStream, String str, InputStream inputStream2, String str2, boolean z) throws IOException {
        super(EMPTY_INPUT_STREAM);
        this.password = "";
        this.keyStoreInputStream = null;
        this.keyAlias = null;
        File createTmpFile = createTmpFile(inputStream);
        this.tempPDFFile = createTmpFile;
        this.fileLen = createTmpFile.length();
        this.raStream = new RandomAccessBufferedFileInputStream(this.tempPDFFile);
        this.password = str;
        this.keyStoreInputStream = inputStream2;
        this.keyAlias = str2;
        init(z);
    }
}
