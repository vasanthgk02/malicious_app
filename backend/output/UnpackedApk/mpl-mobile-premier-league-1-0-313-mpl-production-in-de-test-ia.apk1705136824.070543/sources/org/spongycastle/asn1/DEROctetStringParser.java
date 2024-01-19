package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    public DefiniteLengthInputStream stream;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.stream = definiteLengthInputStream;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return new DEROctetString(this.stream.toByteArray());
    }

    public InputStream getOctetStream() {
        return this.stream;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return new DEROctetString(this.stream.toByteArray());
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("IOException converting stream to byte array: ");
            outline73.append(e2.getMessage());
            throw new ASN1ParsingException(outline73.toString(), e2);
        }
    }
}
