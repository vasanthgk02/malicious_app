package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BEROctetString extends ASN1OctetString {
    public ASN1OctetString[] octs;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // int i = 0;
        while (i != aSN1OctetStringArr.length) {
            try {
                // byteArrayOutputStream.write(aSN1OctetStringArr[i].string);
                // i++;
            } catch (ClassCastException unused) {
                // throw new IllegalArgumentException(aSN1OctetStringArr[i].getClass().getName() + " found in input should only contain DEROctetString");
            } catch (IOException e2) {
                // StringBuilder outline73 = GeneratedOutlineSupport.outline73("exception converting octets ");
                // outline73.append(e2.toString());
                // throw new IllegalArgumentException(outline73.toString());
            }
        }
        super(byteArrayOutputStream.toByteArray());
        this.octs = aSN1OctetStringArr;
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(36);
        aSN1OutputStream.write(128);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    public int encodedLength() throws IOException {
        Enumeration objects = getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            i += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().encodedLength();
        }
        return i + 2 + 2;
    }

    public Enumeration getObjects() {
        if (this.octs != null) {
            return new Enumeration() {
                public int counter = 0;

                public boolean hasMoreElements() {
                    return this.counter < BEROctetString.this.octs.length;
                }

                public Object nextElement() {
                    ASN1OctetString[] aSN1OctetStringArr = BEROctetString.this.octs;
                    int i = this.counter;
                    this.counter = i + 1;
                    return aSN1OctetStringArr[i];
                }
            };
        }
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.string;
            if (i >= bArr.length) {
                return vector.elements();
            }
            int i2 = i + 1000;
            int length = (i2 > bArr.length ? bArr.length : i2) - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(this.string, i, bArr2, 0, length);
            vector.addElement(new DEROctetString(bArr2));
            i = i2;
        }
    }

    public byte[] getOctets() {
        return this.string;
    }

    public boolean isConstructed() {
        return true;
    }

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }
}
