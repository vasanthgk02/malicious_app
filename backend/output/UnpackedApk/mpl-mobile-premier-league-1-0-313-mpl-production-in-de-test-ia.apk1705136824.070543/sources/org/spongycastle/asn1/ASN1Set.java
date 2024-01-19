package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays$Iterator;

public abstract class ASN1Set extends ASN1Primitive implements Object<ASN1Encodable> {
    public boolean isSorted;
    public Vector set;

    public ASN1Set() {
        this.set = new Vector();
        this.isSorted = false;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        if (size() != aSN1Set.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable next = getNext(objects);
            ASN1Encodable next2 = getNext(objects2);
            ASN1Primitive aSN1Primitive2 = next.toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = next2.toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    public final ASN1Encodable getNext(Enumeration enumeration) {
        ASN1Encodable aSN1Encodable = (ASN1Encodable) enumeration.nextElement();
        return aSN1Encodable == null ? DERNull.INSTANCE : aSN1Encodable;
    }

    public Enumeration getObjects() {
        return this.set.elements();
    }

    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ getNext(objects).hashCode();
        }
        return size;
    }

    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = (ASN1Encodable) this.set.elementAt(i);
        }
        return new Arrays$Iterator(aSN1EncodableArr);
    }

    public int size() {
        return this.set.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if ((r7[r12] & 255) < (r9[r12] & 255)) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r11 == r7.length) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r11 == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r4 = r15.set.elementAt(r8);
        r6 = r15.set;
        r6.setElementAt(r6.elementAt(r10), r8);
        r15.set.setElementAt(r4, r10);
        r4 = r8;
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r8 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sort() {
        /*
            r15 = this;
            java.lang.String r0 = "cannot encode object added to SET"
            java.lang.String r1 = "DER"
            boolean r2 = r15.isSorted
            if (r2 != 0) goto L_0x0094
            r2 = 1
            r15.isSorted = r2
            java.util.Vector r3 = r15.set
            int r3 = r3.size()
            if (r3 <= r2) goto L_0x0094
            java.util.Vector r3 = r15.set
            int r3 = r3.size()
            int r3 = r3 - r2
            r4 = 1
        L_0x001b:
            if (r4 == 0) goto L_0x0094
            java.util.Vector r4 = r15.set
            r5 = 0
            java.lang.Object r4 = r4.elementAt(r5)
            org.spongycastle.asn1.ASN1Encodable r4 = (org.spongycastle.asn1.ASN1Encodable) r4
            org.spongycastle.asn1.ASN1Primitive r4 = r4.toASN1Primitive()     // Catch:{ IOException -> 0x008e }
            byte[] r4 = r4.getEncoded(r1)     // Catch:{ IOException -> 0x008e }
            r7 = r4
            r4 = 0
            r6 = 0
            r8 = 0
        L_0x0032:
            if (r8 == r3) goto L_0x008b
            java.util.Vector r9 = r15.set
            int r10 = r8 + 1
            java.lang.Object r9 = r9.elementAt(r10)
            org.spongycastle.asn1.ASN1Encodable r9 = (org.spongycastle.asn1.ASN1Encodable) r9
            org.spongycastle.asn1.ASN1Primitive r9 = r9.toASN1Primitive()     // Catch:{ IOException -> 0x0085 }
            byte[] r9 = r9.getEncoded(r1)     // Catch:{ IOException -> 0x0085 }
            int r11 = r7.length
            int r12 = r9.length
            int r11 = java.lang.Math.min(r11, r12)
            r12 = 0
        L_0x004d:
            if (r12 == r11) goto L_0x0063
            byte r13 = r7[r12]
            byte r14 = r9[r12]
            if (r13 == r14) goto L_0x0060
            byte r11 = r7[r12]
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r12 = r9[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            if (r11 >= r12) goto L_0x0068
            goto L_0x0066
        L_0x0060:
            int r12 = r12 + 1
            goto L_0x004d
        L_0x0063:
            int r12 = r7.length
            if (r11 != r12) goto L_0x0068
        L_0x0066:
            r11 = 1
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            if (r11 == 0) goto L_0x006d
            r7 = r9
            goto L_0x0083
        L_0x006d:
            java.util.Vector r4 = r15.set
            java.lang.Object r4 = r4.elementAt(r8)
            java.util.Vector r6 = r15.set
            java.lang.Object r9 = r6.elementAt(r10)
            r6.setElementAt(r9, r8)
            java.util.Vector r6 = r15.set
            r6.setElementAt(r4, r10)
            r4 = r8
            r6 = 1
        L_0x0083:
            r8 = r10
            goto L_0x0032
        L_0x0085:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x008b:
            r3 = r4
            r4 = r6
            goto L_0x001b
        L_0x008e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1Set.sort():void");
    }

    public ASN1Primitive toDERObject() {
        if (this.isSorted) {
            DERSet dERSet = new DERSet();
            dERSet.set = this.set;
            return dERSet;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.set.size(); i++) {
            vector.addElement(this.set.elementAt(i));
        }
        DERSet dERSet2 = new DERSet();
        dERSet2.set = vector;
        dERSet2.sort();
        return dERSet2;
    }

    public ASN1Primitive toDLObject() {
        DLSet dLSet = new DLSet();
        dLSet.set = this.set;
        return dLSet;
    }

    public String toString() {
        return this.set.toString();
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        this.set = new Vector();
        this.isSorted = false;
        for (int i = 0; i != aSN1EncodableVector.size(); i++) {
            this.set.addElement(aSN1EncodableVector.get(i));
        }
        if (z) {
            sort();
        }
    }
}
