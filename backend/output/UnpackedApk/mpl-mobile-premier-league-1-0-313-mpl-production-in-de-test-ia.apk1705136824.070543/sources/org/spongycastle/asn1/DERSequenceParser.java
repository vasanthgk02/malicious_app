package org.spongycastle.asn1;

import java.io.IOException;

public class DERSequenceParser implements ASN1Encodable, InMemoryRepresentable {
    public ASN1StreamParser _parser;

    public DERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return new DERSequence(this._parser.readVector());
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return new DERSequence(this._parser.readVector());
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }
}
