package org.apache.pdfbox.pdmodel.graphics.optionalcontent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDOptionalContentProperties implements COSObjectable {
    public COSDictionary dict;

    public enum BaseState {
        ON(COSName.ON),
        OFF(COSName.OFF),
        UNCHANGED(COSName.UNCHANGED);
        
        public COSName name;

        /* access modifiers changed from: public */
        BaseState(COSName cOSName) {
            this.name = cOSName;
        }

        public COSName getName() {
            return this.name;
        }

        public static BaseState valueOf(COSName cOSName) {
            if (cOSName == null) {
                return ON;
            }
            return valueOf(cOSName.getName().toUpperCase());
        }
    }

    public PDOptionalContentProperties() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dict = cOSDictionary;
        cOSDictionary.setItem(COSName.OCGS, (COSBase) new COSArray());
        this.dict.setItem(COSName.D, (COSBase) new COSDictionary());
    }

    private COSDictionary getD() {
        COSDictionary cOSDictionary = (COSDictionary) this.dict.getDictionaryObject(COSName.D);
        if (cOSDictionary != null) {
            return cOSDictionary;
        }
        COSDictionary cOSDictionary2 = new COSDictionary();
        this.dict.setItem(COSName.D, (COSBase) cOSDictionary2);
        return cOSDictionary2;
    }

    private COSArray getOCGs() {
        COSArray cOSArray = (COSArray) this.dict.getItem(COSName.OCGS);
        if (cOSArray != null) {
            return cOSArray;
        }
        COSArray cOSArray2 = new COSArray();
        this.dict.setItem(COSName.OCGS, (COSBase) cOSArray2);
        return cOSArray2;
    }

    private COSDictionary toDictionary(COSBase cOSBase) {
        if (cOSBase instanceof COSObject) {
            return (COSDictionary) ((COSObject) cOSBase).getObject();
        }
        return (COSDictionary) cOSBase;
    }

    public void addGroup(PDOptionalContentGroup pDOptionalContentGroup) {
        getOCGs().add((COSBase) pDOptionalContentGroup.getCOSObject());
        COSArray cOSArray = (COSArray) getD().getDictionaryObject(COSName.ORDER);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            getD().setItem(COSName.ORDER, (COSBase) cOSArray);
        }
        cOSArray.add((COSObjectable) pDOptionalContentGroup);
    }

    public BaseState getBaseState() {
        return BaseState.valueOf((COSName) getD().getItem(COSName.BASE_STATE));
    }

    public COSBase getCOSObject() {
        return this.dict;
    }

    public PDOptionalContentGroup getGroup(String str) {
        Iterator<COSBase> it = getOCGs().iterator();
        while (it.hasNext()) {
            COSDictionary dictionary = toDictionary(it.next());
            if (dictionary.getString(COSName.NAME).equals(str)) {
                return new PDOptionalContentGroup(dictionary);
            }
        }
        return null;
    }

    public String[] getGroupNames() {
        COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.OCGS);
        int size = cOSArray.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = toDictionary(cOSArray.get(i)).getString(COSName.NAME);
        }
        return strArr;
    }

    public Collection<PDOptionalContentGroup> getOptionalContentGroups() {
        ArrayList arrayList = new ArrayList();
        Iterator<COSBase> it = getOCGs().iterator();
        while (it.hasNext()) {
            arrayList.add(new PDOptionalContentGroup((COSDictionary) ((COSObject) it.next()).getObject()));
        }
        return arrayList;
    }

    public boolean hasGroup(String str) {
        for (String equals : getGroupNames()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupEnabled(String str) {
        COSDictionary d2 = getD();
        COSArray cOSArray = (COSArray) d2.getDictionaryObject(COSName.ON);
        if (cOSArray != null) {
            Iterator<COSBase> it = cOSArray.iterator();
            while (it.hasNext()) {
                if (toDictionary(it.next()).getString(COSName.NAME).equals(str)) {
                    return true;
                }
            }
        }
        COSArray cOSArray2 = (COSArray) d2.getDictionaryObject(COSName.OFF);
        if (cOSArray2 != null) {
            Iterator<COSBase> it2 = cOSArray2.iterator();
            while (it2.hasNext()) {
                if (toDictionary(it2.next()).getString(COSName.NAME).equals(str)) {
                    return false;
                }
            }
        }
        return !getBaseState().equals(BaseState.OFF);
    }

    public void setBaseState(BaseState baseState) {
        getD().setItem(COSName.BASE_STATE, (COSBase) baseState.getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setGroupEnabled(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            org.apache.pdfbox.cos.COSDictionary r0 = r7.getD()
            org.apache.pdfbox.cos.COSName r1 = org.apache.pdfbox.cos.COSName.ON
            org.apache.pdfbox.cos.COSBase r1 = r0.getDictionaryObject(r1)
            org.apache.pdfbox.cos.COSArray r1 = (org.apache.pdfbox.cos.COSArray) r1
            if (r1 != 0) goto L_0x0018
            org.apache.pdfbox.cos.COSArray r1 = new org.apache.pdfbox.cos.COSArray
            r1.<init>()
            org.apache.pdfbox.cos.COSName r2 = org.apache.pdfbox.cos.COSName.ON
            r0.setItem(r2, r1)
        L_0x0018:
            org.apache.pdfbox.cos.COSName r2 = org.apache.pdfbox.cos.COSName.OFF
            org.apache.pdfbox.cos.COSBase r2 = r0.getDictionaryObject(r2)
            org.apache.pdfbox.cos.COSArray r2 = (org.apache.pdfbox.cos.COSArray) r2
            if (r2 != 0) goto L_0x002c
            org.apache.pdfbox.cos.COSArray r2 = new org.apache.pdfbox.cos.COSArray
            r2.<init>()
            org.apache.pdfbox.cos.COSName r3 = org.apache.pdfbox.cos.COSName.OFF
            r0.setItem(r3, r2)
        L_0x002c:
            r0 = 0
            r3 = 1
            if (r9 == 0) goto L_0x0057
            java.util.Iterator r4 = r2.iterator()
        L_0x0034:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r4.next()
            org.apache.pdfbox.cos.COSBase r5 = (org.apache.pdfbox.cos.COSBase) r5
            org.apache.pdfbox.cos.COSDictionary r5 = r7.toDictionary(r5)
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.NAME
            java.lang.String r6 = r5.getString(r6)
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0034
            r2.remove(r5)
            r1.add(r5)
            goto L_0x007d
        L_0x0057:
            java.util.Iterator r4 = r1.iterator()
        L_0x005b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r4.next()
            org.apache.pdfbox.cos.COSBase r5 = (org.apache.pdfbox.cos.COSBase) r5
            org.apache.pdfbox.cos.COSDictionary r5 = r7.toDictionary(r5)
            org.apache.pdfbox.cos.COSName r6 = org.apache.pdfbox.cos.COSName.NAME
            java.lang.String r6 = r5.getString(r6)
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x005b
            r1.remove(r5)
            r2.add(r5)
        L_0x007d:
            r0 = 1
        L_0x007e:
            if (r0 != 0) goto L_0x0095
            org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup r8 = r7.getGroup(r8)
            if (r9 == 0) goto L_0x008e
            org.apache.pdfbox.cos.COSDictionary r8 = r8.getCOSObject()
            r1.add(r8)
            goto L_0x0095
        L_0x008e:
            org.apache.pdfbox.cos.COSDictionary r8 = r8.getCOSObject()
            r2.add(r8)
        L_0x0095:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties.setGroupEnabled(java.lang.String, boolean):boolean");
    }

    public PDOptionalContentProperties(COSDictionary cOSDictionary) {
        this.dict = cOSDictionary;
    }
}
