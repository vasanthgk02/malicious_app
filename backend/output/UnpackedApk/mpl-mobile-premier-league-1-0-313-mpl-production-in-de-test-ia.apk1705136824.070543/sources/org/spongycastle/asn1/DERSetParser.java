package org.spongycastle.asn1;

import java.io.IOException;

public class DERSetParser implements ASN1Encodable, InMemoryRepresentable {
    public ASN1StreamParser _parser;

    public DERSetParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return new DERSet(this._parser.readVector(), false);
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return new DERSet(this._parser.readVector(), false);
        } catch (IOException e2) {
            throw new ASN1ParsingException(e2.getMessage(), e2);
        }
    }
}
