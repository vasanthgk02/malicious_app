package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSBase;

public interface DualCOSObjectable {
    COSBase getFirstCOSObject();

    COSBase getSecondCOSObject();
}
