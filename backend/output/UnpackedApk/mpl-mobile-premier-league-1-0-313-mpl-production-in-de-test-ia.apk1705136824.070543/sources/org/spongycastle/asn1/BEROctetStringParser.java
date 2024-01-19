package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class BEROctetStringParser implements ASN1OctetStringParser {
    public ASN1StreamParser _parser;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return new BEROctetString(Streams.readAll(getOctetStream()));
    }

    public InputStream getOctetStream() {
        return new ConstructedOctetStream(this._parser);
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("IOException converting stream to byte array: ");
            outline73.append(e2.getMessage());
            throw new ASN1ParsingException(outline73.toString(), e2);
        }
    }
}
