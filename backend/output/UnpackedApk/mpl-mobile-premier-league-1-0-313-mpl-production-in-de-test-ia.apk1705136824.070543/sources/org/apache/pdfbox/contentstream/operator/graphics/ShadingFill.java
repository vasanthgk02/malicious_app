package org.apache.pdfbox.contentstream.operator.graphics;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public final class ShadingFill extends GraphicsOperatorProcessor {
    public String getName() {
        return "sh";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.shadingFill((COSName) list.get(0));
    }
}
