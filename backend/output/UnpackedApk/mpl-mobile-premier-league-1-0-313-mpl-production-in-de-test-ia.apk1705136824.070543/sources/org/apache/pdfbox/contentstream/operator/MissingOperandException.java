package org.apache.pdfbox.contentstream.operator;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;

public final class MissingOperandException extends IOException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MissingOperandException(Operator operator, List<COSBase> list) {
        // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Operator ");
        // outline73.append(operator.getName());
        // outline73.append(" has too few operands: ");
        // outline73.append(list);
        super(outline73.toString());
    }
}
