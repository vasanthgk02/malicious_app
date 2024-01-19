package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERExternal extends ASN1Primitive {
    public ASN1Primitive dataValueDescriptor;
    public ASN1ObjectIdentifier directReference;
    public int encoding;
    public ASN1Primitive externalContent;
    public ASN1Integer indirectReference;

    public DERExternal(ASN1EncodableVector aSN1EncodableVector) {
        int i = 0;
        ASN1Primitive objFromVector = getObjFromVector(aSN1EncodableVector, 0);
        if (objFromVector instanceof ASN1ObjectIdentifier) {
            this.directReference = (ASN1ObjectIdentifier) objFromVector;
            objFromVector = getObjFromVector(aSN1EncodableVector, 1);
            i = 1;
        }
        if (objFromVector instanceof ASN1Integer) {
            this.indirectReference = (ASN1Integer) objFromVector;
            i++;
            objFromVector = getObjFromVector(aSN1EncodableVector, i);
        }
        if (!(objFromVector instanceof ASN1TaggedObject)) {
            this.dataValueDescriptor = objFromVector;
            i++;
            objFromVector = getObjFromVector(aSN1EncodableVector, i);
        }
        if (aSN1EncodableVector.size() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (objFromVector instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objFromVector;
            int i2 = aSN1TaggedObject.tagNo;
            if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("invalid encoding value: ", i2));
            }
            this.encoding = i2;
            ASN1Encodable aSN1Encodable = aSN1TaggedObject.obj;
            this.externalContent = aSN1Encodable != null ? aSN1Encodable.toASN1Primitive() : null;
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERExternal)) {
            return false;
        }
        if (this == aSN1Primitive) {
            return true;
        }
        DERExternal dERExternal = (DERExternal) aSN1Primitive;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = dERExternal.directReference;
            if (aSN1ObjectIdentifier2 == null || !aSN1ObjectIdentifier2.equals(aSN1ObjectIdentifier)) {
                return false;
            }
        }
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            ASN1Integer aSN1Integer2 = dERExternal.indirectReference;
            if (aSN1Integer2 == null || !aSN1Integer2.equals(aSN1Integer)) {
                return false;
            }
        }
        ASN1Primitive aSN1Primitive2 = this.dataValueDescriptor;
        if (aSN1Primitive2 != null) {
            ASN1Primitive aSN1Primitive3 = dERExternal.dataValueDescriptor;
            if (aSN1Primitive3 == null || !aSN1Primitive3.equals(aSN1Primitive2)) {
                return false;
            }
        }
        return this.externalContent.equals(dERExternal.externalContent);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            byteArrayOutputStream.write(aSN1ObjectIdentifier.getEncoded("DER"));
        }
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            byteArrayOutputStream.write(aSN1Integer.getEncoded("DER"));
        }
        ASN1Primitive aSN1Primitive = this.dataValueDescriptor;
        if (aSN1Primitive != null) {
            byteArrayOutputStream.write(aSN1Primitive.getEncoded("DER"));
        }
        byteArrayOutputStream.write(new DERTaggedObject(true, this.encoding, this.externalContent).getEncoded("DER"));
        aSN1OutputStream.writeEncoded(32, 8, byteArrayOutputStream.toByteArray());
    }

    public int encodedLength() throws IOException {
        return getEncoded().length;
    }

    public final ASN1Primitive getObjFromVector(ASN1EncodableVector aSN1EncodableVector, int i) {
        if (aSN1EncodableVector.size() > i) {
            return ((ASN1Encodable) aSN1EncodableVector.v.elementAt(i)).toASN1Primitive();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    public int hashCode() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        int hashCode = aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier.hashCode() : 0;
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            hashCode ^= aSN1Integer.hashCode();
        }
        ASN1Primitive aSN1Primitive = this.dataValueDescriptor;
        if (aSN1Primitive != null) {
            hashCode ^= aSN1Primitive.hashCode();
        }
        return hashCode ^ this.externalContent.hashCode();
    }

    public boolean isConstructed() {
        return true;
    }
}
