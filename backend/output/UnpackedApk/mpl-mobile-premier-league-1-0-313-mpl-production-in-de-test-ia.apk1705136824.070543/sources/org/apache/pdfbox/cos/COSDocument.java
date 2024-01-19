package org.apache.pdfbox.cos;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.pdfparser.PDFObjectStreamParser;

public class COSDocument extends COSBase implements Closeable {
    public boolean closed;
    public boolean isDecrypted;
    public boolean isXRefStream;
    public final Map<COSObjectKey, COSObject> objectPool;
    public final File scratchDirectory;
    public long startXref;
    public COSDictionary trailer;
    public final boolean useScratchFile;
    public float version;
    public boolean warnMissingClose;
    public final Map<COSObjectKey, Long> xrefTable;

    public COSDocument(boolean z) {
        this(null, z);
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromDocument(this);
    }

    public void addXRefTable(Map<COSObjectKey, Long> map) {
        this.xrefTable.putAll(map);
    }

    public void close() throws IOException {
        if (!this.closed) {
            List<COSObject> objects = getObjects();
            if (objects != null) {
                for (COSObject object : objects) {
                    COSBase object2 = object.getObject();
                    if (object2 instanceof COSStream) {
                        ((COSStream) object2).close();
                    }
                }
            }
            this.closed = true;
        }
    }

    public COSStream createCOSStream() {
        return new COSStream(this.useScratchFile, this.scratchDirectory);
    }

    public void dereferenceObjectStreams() throws IOException {
        for (COSObject next : getObjectsByType(COSName.OBJ_STM)) {
            PDFObjectStreamParser pDFObjectStreamParser = new PDFObjectStreamParser((COSStream) next.getObject(), this);
            try {
                pDFObjectStreamParser.parse();
                for (COSObject next2 : pDFObjectStreamParser.getObjects()) {
                    COSObjectKey cOSObjectKey = new COSObjectKey(next2);
                    if (this.objectPool.get(cOSObjectKey) == null || this.objectPool.get(cOSObjectKey).getObject() == null || (this.xrefTable.containsKey(cOSObjectKey) && this.xrefTable.get(cOSObjectKey).longValue() == (-next.getObjectNumber()))) {
                        getObjectFromPool(cOSObjectKey).setObject(next2.getObject());
                    }
                }
            } finally {
                pDFObjectStreamParser.close();
            }
        }
    }

    public void finalize() throws IOException {
        if (!this.closed) {
            boolean z = this.warnMissingClose;
            close();
        }
    }

    public COSObject getCatalog() throws IOException {
        COSObject objectByType = getObjectByType(COSName.CATALOG);
        if (objectByType != null) {
            return objectByType;
        }
        throw new IOException("Catalog cannot be found");
    }

    public COSArray getDocumentID() {
        return (COSArray) getTrailer().getDictionaryObject(COSName.ID);
    }

    public COSDictionary getEncryptionDictionary() {
        return (COSDictionary) this.trailer.getDictionaryObject(COSName.ENCRYPT);
    }

    public COSObject getObjectByType(COSName cOSName) throws IOException {
        for (COSObject next : this.objectPool.values()) {
            COSBase object = next.getObject();
            if (object instanceof COSDictionary) {
                try {
                    COSBase item = ((COSDictionary) object).getItem(COSName.TYPE);
                    if (item instanceof COSName) {
                        if (((COSName) item).equals(cOSName)) {
                            return next;
                        }
                    } else if (item != null) {
                        "Expected a /Name object after /Type, got '" + item + "' instead";
                    }
                } catch (ClassCastException e2) {
                    e2.getMessage();
                }
            }
        }
        return null;
    }

    public COSObject getObjectFromPool(COSObjectKey cOSObjectKey) throws IOException {
        COSObject cOSObject = cOSObjectKey != null ? this.objectPool.get(cOSObjectKey) : null;
        if (cOSObject == null) {
            cOSObject = new COSObject(null);
            if (cOSObjectKey != null) {
                cOSObject.setObjectNumber(cOSObjectKey.getNumber());
                cOSObject.setGenerationNumber(cOSObjectKey.getGeneration());
                this.objectPool.put(cOSObjectKey, cOSObject);
            }
        }
        return cOSObject;
    }

    public List<COSObject> getObjects() {
        return new ArrayList(this.objectPool.values());
    }

    public List<COSObject> getObjectsByType(String str) throws IOException {
        return getObjectsByType(COSName.getPDFName(str));
    }

    public List<COSDictionary> getSignatureDictionaries() throws IOException {
        List<COSDictionary> signatureFields = getSignatureFields(false);
        LinkedList linkedList = new LinkedList();
        for (COSDictionary dictionaryObject : signatureFields) {
            COSBase dictionaryObject2 = dictionaryObject.getDictionaryObject(COSName.V);
            if (dictionaryObject2 != null) {
                linkedList.add((COSDictionary) dictionaryObject2);
            }
        }
        return linkedList;
    }

    public List<COSDictionary> getSignatureFields(boolean z) throws IOException {
        COSObject catalog = getCatalog();
        if (catalog != null) {
            COSDictionary cOSDictionary = (COSDictionary) catalog.getDictionaryObject(COSName.ACRO_FORM);
            if (cOSDictionary != null) {
                COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(COSName.FIELDS);
                if (cOSArray != null) {
                    HashMap hashMap = new HashMap();
                    Iterator<COSBase> it = cOSArray.iterator();
                    while (it.hasNext()) {
                        COSObject cOSObject = (COSObject) it.next();
                        if (COSName.SIG.equals(cOSObject.getItem(COSName.FT)) && (cOSObject.getDictionaryObject(COSName.V) == null || !z)) {
                            hashMap.put(new COSObjectKey(cOSObject), (COSDictionary) cOSObject.getObject());
                        }
                    }
                    return new LinkedList(hashMap.values());
                }
            }
        }
        return Collections.emptyList();
    }

    public long getStartXref() {
        return this.startXref;
    }

    public COSDictionary getTrailer() {
        return this.trailer;
    }

    public float getVersion() {
        return this.version;
    }

    public Map<COSObjectKey, Long> getXrefTable() {
        return this.xrefTable;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isDecrypted() {
        return this.isDecrypted;
    }

    public boolean isEncrypted() {
        COSDictionary cOSDictionary = this.trailer;
        if (cOSDictionary == null || cOSDictionary.getDictionaryObject(COSName.ENCRYPT) == null) {
            return false;
        }
        return true;
    }

    public boolean isXRefStream() {
        return this.isXRefStream;
    }

    public void print() {
        for (COSObject println : this.objectPool.values()) {
            System.out.println(println);
        }
    }

    public COSObject removeObject(COSObjectKey cOSObjectKey) {
        return this.objectPool.remove(cOSObjectKey);
    }

    public void setDecrypted() {
        this.isDecrypted = true;
    }

    public void setDocumentID(COSArray cOSArray) {
        getTrailer().setItem(COSName.ID, (COSBase) cOSArray);
    }

    public void setEncryptionDictionary(COSDictionary cOSDictionary) {
        this.trailer.setItem(COSName.ENCRYPT, (COSBase) cOSDictionary);
    }

    public void setIsXRefStream(boolean z) {
        this.isXRefStream = z;
    }

    public void setStartXref(long j) {
        this.startXref = j;
    }

    public void setTrailer(COSDictionary cOSDictionary) {
        this.trailer = cOSDictionary;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public void setWarnMissingClose(boolean z) {
        this.warnMissingClose = z;
    }

    public COSDocument(File file, boolean z) {
        this.version = 1.4f;
        this.objectPool = new HashMap();
        this.xrefTable = new HashMap();
        this.warnMissingClose = true;
        this.isDecrypted = false;
        this.closed = false;
        this.scratchDirectory = file;
        this.useScratchFile = z;
    }

    public COSStream createCOSStream(COSDictionary cOSDictionary) {
        return new COSStream(cOSDictionary, this.useScratchFile, this.scratchDirectory);
    }

    public List<COSObject> getObjectsByType(COSName cOSName) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (COSObject next : this.objectPool.values()) {
            COSBase object = next.getObject();
            if (object instanceof COSDictionary) {
                try {
                    COSBase item = ((COSDictionary) object).getItem(COSName.TYPE);
                    if (item instanceof COSName) {
                        if (((COSName) item).equals(cOSName)) {
                            arrayList.add(next);
                        }
                    } else if (item != null) {
                        "Expected a /Name object after /Type, got '" + item + "' instead";
                    }
                } catch (ClassCastException e2) {
                    e2.getMessage();
                }
            }
        }
        return arrayList;
    }

    public COSDocument() {
        this(false);
    }
}
