package org.apache.pdfbox.contentstream.operator.graphics;

import com.userexperior.e.h;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

public class CloseAndStrokePath extends GraphicsOperatorProcessor {
    public String getName() {
        return "s";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.processOperator((String) h.f3998a, list);
        this.context.processOperator((String) "S", list);
    }
}
