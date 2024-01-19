package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;

public class PDMMType1Font extends PDType1Font {
    public PDMMType1Font(COSDictionary cOSDictionary) throws IOException {
        super(cOSDictionary);
    }
}
