package org.apache.pdfbox.contentstream.operator.graphics;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

public final class EndPath extends GraphicsOperatorProcessor {
    public String getName() {
        return "n";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.endPath();
    }
}
