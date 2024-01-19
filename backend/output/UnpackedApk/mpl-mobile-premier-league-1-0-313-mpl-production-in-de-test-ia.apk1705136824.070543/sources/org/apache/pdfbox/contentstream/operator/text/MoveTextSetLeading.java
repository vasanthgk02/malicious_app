package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class MoveTextSetLeading extends OperatorProcessor {
    public String getName() {
        return StandardStructureTypes.TD;
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new COSFloat(((COSNumber) list.get(1)).floatValue() * -1.0f));
        this.context.processOperator((String) "TL", (List<COSBase>) arrayList);
        this.context.processOperator((String) "Td", list);
    }
}
