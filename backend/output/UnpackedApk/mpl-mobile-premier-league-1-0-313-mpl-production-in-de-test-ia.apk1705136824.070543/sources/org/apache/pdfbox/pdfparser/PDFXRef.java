package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.cos.COSObject;

public interface PDFXRef {
    COSObject getObject(int i);
}
