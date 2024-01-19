package org.apache.pdfbox.pdfparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;

public class XrefTrailerResolver {
    public final Map<Long, XrefTrailerObj> bytePosToXrefMap = new HashMap();
    public XrefTrailerObj curXrefTrailerObj = null;
    public XrefTrailerObj resolvedXrefTrailer = null;

    public enum XRefType {
        TABLE,
        STREAM
    }

    public class XrefTrailerObj {
        public COSDictionary trailer;
        public final Map<COSObjectKey, Long> xrefTable;
        public XRefType xrefType;

        public XrefTrailerObj() {
            this.trailer = null;
            this.xrefTable = new HashMap();
            this.xrefType = XRefType.TABLE;
        }
    }

    public Set<Long> getContainedObjectNumbers(int i) {
        if (this.resolvedXrefTrailer == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        long j = (long) (-i);
        for (Entry entry : this.resolvedXrefTrailer.xrefTable.entrySet()) {
            if (((Long) entry.getValue()).longValue() == j) {
                hashSet.add(Long.valueOf(((COSObjectKey) entry.getKey()).getNumber()));
            }
        }
        return hashSet;
    }

    public COSDictionary getCurrentTrailer() {
        return this.curXrefTrailerObj.trailer;
    }

    public final COSDictionary getFirstTrailer() {
        if (this.bytePosToXrefMap.isEmpty()) {
            return null;
        }
        return this.bytePosToXrefMap.get(new TreeSet(this.bytePosToXrefMap.keySet()).first()).trailer;
    }

    public final COSDictionary getLastTrailer() {
        if (this.bytePosToXrefMap.isEmpty()) {
            return null;
        }
        return this.bytePosToXrefMap.get(new TreeSet(this.bytePosToXrefMap.keySet()).last()).trailer;
    }

    public COSDictionary getTrailer() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.trailer;
    }

    public Map<COSObjectKey, Long> getXrefTable() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.xrefTable;
    }

    public XRefType getXrefType() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.xrefType;
    }

    public void nextXrefObj(long j, XRefType xRefType) {
        Map<Long, XrefTrailerObj> map = this.bytePosToXrefMap;
        Long valueOf = Long.valueOf(j);
        XrefTrailerObj xrefTrailerObj = new XrefTrailerObj();
        this.curXrefTrailerObj = xrefTrailerObj;
        map.put(valueOf, xrefTrailerObj);
        this.curXrefTrailerObj.xrefType = xRefType;
    }

    public void setStartxref(long j) {
        if (this.resolvedXrefTrailer == null) {
            XrefTrailerObj xrefTrailerObj = new XrefTrailerObj();
            this.resolvedXrefTrailer = xrefTrailerObj;
            xrefTrailerObj.trailer = new COSDictionary();
            XrefTrailerObj xrefTrailerObj2 = this.bytePosToXrefMap.get(Long.valueOf(j));
            ArrayList arrayList = new ArrayList();
            if (xrefTrailerObj2 == null) {
                arrayList.addAll(this.bytePosToXrefMap.keySet());
                Collections.sort(arrayList);
            } else {
                this.resolvedXrefTrailer.xrefType = xrefTrailerObj2.xrefType;
                arrayList.add(Long.valueOf(j));
                do {
                    COSDictionary cOSDictionary = xrefTrailerObj2.trailer;
                    if (cOSDictionary == null) {
                        break;
                    }
                    long j2 = cOSDictionary.getLong(COSName.PREV, -1);
                    if (j2 == -1) {
                        break;
                    }
                    xrefTrailerObj2 = this.bytePosToXrefMap.get(Long.valueOf(j2));
                    if (xrefTrailerObj2 == null) {
                        break;
                    }
                    arrayList.add(Long.valueOf(j2));
                } while (arrayList.size() < this.bytePosToXrefMap.size());
                Collections.reverse(arrayList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                XrefTrailerObj xrefTrailerObj3 = this.bytePosToXrefMap.get((Long) it.next());
                COSDictionary cOSDictionary2 = xrefTrailerObj3.trailer;
                if (cOSDictionary2 != null) {
                    this.resolvedXrefTrailer.trailer.addAll(cOSDictionary2);
                }
                this.resolvedXrefTrailer.xrefTable.putAll(xrefTrailerObj3.xrefTable);
            }
        }
    }

    public void setTrailer(COSDictionary cOSDictionary) {
        XrefTrailerObj xrefTrailerObj = this.curXrefTrailerObj;
        if (xrefTrailerObj != null) {
            xrefTrailerObj.trailer = cOSDictionary;
        }
    }

    public void setXRef(COSObjectKey cOSObjectKey, long j) {
        XrefTrailerObj xrefTrailerObj = this.curXrefTrailerObj;
        if (xrefTrailerObj == null) {
            cOSObjectKey.getNumber();
        } else {
            xrefTrailerObj.xrefTable.put(cOSObjectKey, Long.valueOf(j));
        }
    }
}
