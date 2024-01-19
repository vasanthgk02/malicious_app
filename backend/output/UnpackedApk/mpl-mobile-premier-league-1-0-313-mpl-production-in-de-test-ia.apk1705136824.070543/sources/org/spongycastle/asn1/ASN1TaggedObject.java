package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1Encodable, InMemoryRepresentable {
    public boolean empty = false;
    public boolean explicit = true;
    public ASN1Encodable obj = null;
    public int tagNo;

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        this.explicit = z;
        this.tagNo = i;
        if (z) {
            this.obj = aSN1Encodable;
            return;
        }
        boolean z2 = aSN1Encodable.toASN1Primitive() instanceof ASN1Set;
        this.obj = aSN1Encodable;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.tagNo != aSN1TaggedObject.tagNo || this.empty != aSN1TaggedObject.empty || this.explicit != aSN1TaggedObject.explicit) {
            return false;
        }
        ASN1Encodable aSN1Encodable = this.obj;
        if (aSN1Encodable == null) {
            if (aSN1TaggedObject.obj != null) {
                return false;
            }
        } else if (!aSN1Encodable.toASN1Primitive().equals(aSN1TaggedObject.obj.toASN1Primitive())) {
            return false;
        }
        return true;
    }

    public ASN1Primitive getLoadedObject() {
        return this;
    }

    public int hashCode() {
        int i = this.tagNo;
        ASN1Encodable aSN1Encodable = this.obj;
        return aSN1Encodable != null ? i ^ aSN1Encodable.hashCode() : i;
    }

    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.tagNo);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        outline73.append(this.obj);
        return outline73.toString();
    }
}
