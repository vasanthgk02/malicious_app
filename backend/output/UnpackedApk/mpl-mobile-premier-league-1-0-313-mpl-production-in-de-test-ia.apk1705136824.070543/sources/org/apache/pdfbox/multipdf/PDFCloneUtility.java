package org.apache.pdfbox.multipdf;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.COSStreamArray;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class PDFCloneUtility {
    public final Map<Object, COSBase> clonedVersion = new HashMap();
    public final PDDocument destination;

    public PDFCloneUtility(PDDocument pDDocument) {
        this.destination = pDDocument;
    }

    public COSBase cloneForNewDocument(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }
        COSBase cOSBase = this.clonedVersion.get(obj);
        if (cOSBase == 0) {
            if (obj instanceof List) {
                COSArray cOSArray = new COSArray();
                for (Object cloneForNewDocument : (List) obj) {
                    cOSArray.add(cloneForNewDocument(cloneForNewDocument));
                }
                cOSBase = cOSArray;
            } else if ((obj instanceof COSObjectable) && !(obj instanceof COSBase)) {
                COSBase cloneForNewDocument2 = cloneForNewDocument(((COSObjectable) obj).getCOSObject());
                this.clonedVersion.put(obj, cloneForNewDocument2);
                cOSBase = cloneForNewDocument2;
            } else if (obj instanceof COSObject) {
                COSBase cloneForNewDocument3 = cloneForNewDocument(((COSObject) obj).getObject());
                this.clonedVersion.put(obj, cloneForNewDocument3);
                cOSBase = cloneForNewDocument3;
            } else {
                int i = 0;
                if (obj instanceof COSArray) {
                    COSArray cOSArray2 = new COSArray();
                    COSArray cOSArray3 = (COSArray) obj;
                    while (i < cOSArray3.size()) {
                        cOSArray2.add(cloneForNewDocument(cOSArray3.get(i)));
                        i++;
                    }
                    this.clonedVersion.put(obj, cOSArray2);
                    cOSBase = cOSArray2;
                } else if (obj instanceof COSStreamArray) {
                    COSStreamArray cOSStreamArray = (COSStreamArray) obj;
                    if (cOSStreamArray.size() <= 0) {
                        COSArray cOSArray4 = new COSArray();
                        while (i < cOSStreamArray.getStreamCount()) {
                            cOSArray4.add(cloneForNewDocument(cOSStreamArray.get(i)));
                            i++;
                        }
                        COSBase cOSStreamArray2 = new COSStreamArray(cOSArray4);
                        this.clonedVersion.put(obj, cOSStreamArray2);
                        cOSBase = cOSStreamArray2;
                    } else {
                        throw new IllegalStateException("Cannot close stream array with items next to the streams.");
                    }
                } else if (obj instanceof COSStream) {
                    COSStream cOSStream = (COSStream) obj;
                    PDStream pDStream = new PDStream(this.destination, cOSStream.getFilteredStream(), true);
                    this.clonedVersion.put(obj, pDStream.getStream());
                    for (Entry next : cOSStream.entrySet()) {
                        pDStream.getStream().setItem((COSName) next.getKey(), cloneForNewDocument(next.getValue()));
                    }
                    cOSBase = pDStream.getStream();
                } else if (obj instanceof COSDictionary) {
                    COSDictionary cOSDictionary = new COSDictionary();
                    this.clonedVersion.put(obj, cOSDictionary);
                    for (Entry next2 : ((COSDictionary) obj).entrySet()) {
                        cOSDictionary.setItem((COSName) next2.getKey(), cloneForNewDocument(next2.getValue()));
                    }
                    cOSBase = cOSDictionary;
                } else {
                    cOSBase = (COSBase) obj;
                }
            }
        }
        this.clonedVersion.put(obj, cOSBase);
        return cOSBase;
    }

    public void cloneMerge(COSObjectable cOSObjectable, COSObjectable cOSObjectable2) throws IOException {
        if (cOSObjectable != null) {
            Object obj = this.clonedVersion.get(cOSObjectable);
            if (obj == null) {
                if (cOSObjectable instanceof List) {
                    COSArray cOSArray = new COSArray();
                    for (Object cloneForNewDocument : (List) cOSObjectable) {
                        cOSArray.add(cloneForNewDocument(cloneForNewDocument));
                    }
                    ((List) cOSObjectable2).add(cOSArray);
                } else if (!(cOSObjectable instanceof COSBase)) {
                    cloneMerge(cOSObjectable.getCOSObject(), cOSObjectable2.getCOSObject());
                    this.clonedVersion.put(cOSObjectable, obj);
                } else if (cOSObjectable instanceof COSObject) {
                    if (cOSObjectable2 instanceof COSObject) {
                        cloneMerge(((COSObject) cOSObjectable).getObject(), ((COSObject) cOSObjectable2).getObject());
                    } else if (cOSObjectable2 instanceof COSDictionary) {
                        cloneMerge(((COSObject) cOSObjectable).getObject(), cOSObjectable2);
                    }
                    this.clonedVersion.put(cOSObjectable, obj);
                } else if (cOSObjectable instanceof COSArray) {
                    COSArray cOSArray2 = (COSArray) cOSObjectable;
                    for (int i = 0; i < cOSArray2.size(); i++) {
                        ((COSArray) cOSObjectable2).add(cloneForNewDocument(cOSArray2.get(i)));
                    }
                    this.clonedVersion.put(cOSObjectable, obj);
                } else if (cOSObjectable instanceof COSStream) {
                    COSStream cOSStream = (COSStream) cOSObjectable;
                    PDStream pDStream = new PDStream(this.destination, cOSStream.getFilteredStream(), true);
                    this.clonedVersion.put(cOSObjectable, pDStream.getStream());
                    for (Entry next : cOSStream.entrySet()) {
                        pDStream.getStream().setItem((COSName) next.getKey(), cloneForNewDocument(next.getValue()));
                    }
                    obj = pDStream.getStream();
                } else if (cOSObjectable instanceof COSDictionary) {
                    this.clonedVersion.put(cOSObjectable, obj);
                    for (Entry next2 : ((COSDictionary) cOSObjectable).entrySet()) {
                        COSName cOSName = (COSName) next2.getKey();
                        COSBase cOSBase = (COSBase) next2.getValue();
                        COSDictionary cOSDictionary = (COSDictionary) cOSObjectable2;
                        if (cOSDictionary.getItem(cOSName) != null) {
                            cloneMerge(cOSBase, cOSDictionary.getItem(cOSName));
                        } else {
                            cOSDictionary.setItem(cOSName, cloneForNewDocument(cOSBase));
                        }
                    }
                } else {
                    obj = (COSBase) cOSObjectable;
                }
                this.clonedVersion.put(cOSObjectable, obj);
            }
        }
    }

    public PDDocument getDestination() {
        return this.destination;
    }
}
