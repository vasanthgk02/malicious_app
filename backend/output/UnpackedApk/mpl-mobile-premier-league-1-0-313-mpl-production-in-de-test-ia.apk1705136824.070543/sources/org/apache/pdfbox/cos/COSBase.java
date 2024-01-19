package org.apache.pdfbox.cos;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public abstract class COSBase implements COSObjectable {
    public boolean direct;

    public abstract Object accept(ICOSVisitor iCOSVisitor) throws IOException;

    public COSBase getCOSObject() {
        return this;
    }

    public boolean isDirect() {
        return this.direct;
    }

    public void setDirect(boolean z) {
        this.direct = z;
    }
}
