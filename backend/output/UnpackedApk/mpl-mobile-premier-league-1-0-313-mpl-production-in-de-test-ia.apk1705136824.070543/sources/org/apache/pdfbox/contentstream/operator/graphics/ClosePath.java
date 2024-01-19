package org.apache.pdfbox.contentstream.operator.graphics;

import com.userexperior.e.h;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

public final class ClosePath extends GraphicsOperatorProcessor {
    public String getName() {
        return h.f3998a;
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.closePath();
    }
}
