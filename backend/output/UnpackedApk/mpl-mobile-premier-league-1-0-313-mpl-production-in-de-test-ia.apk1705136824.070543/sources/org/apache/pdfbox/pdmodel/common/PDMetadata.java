package org.apache.pdfbox.pdmodel.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDMetadata extends PDStream {
    public PDMetadata(PDDocument pDDocument) {
        super(pDDocument);
        getStream().setName(COSName.TYPE, (String) "Metadata");
        getStream().setName(COSName.SUBTYPE, (String) "XML");
    }

    public InputStream exportXMPMetadata() throws IOException {
        return createInputStream();
    }

    public void importXMPMetadata(byte[] bArr) throws IOException {
        OutputStream createOutputStream = createOutputStream();
        createOutputStream.write(bArr);
        createOutputStream.close();
    }

    public PDMetadata(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        super(pDDocument, inputStream, z);
        getStream().setName(COSName.TYPE, (String) "Metadata");
        getStream().setName(COSName.SUBTYPE, (String) "XML");
    }

    public PDMetadata(COSStream cOSStream) {
        super(cOSStream);
    }
}
