package org.apache.pdfbox.contentstream.operator.color;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public class SetNonStrokingDeviceRGBColor extends SetNonStrokingColor {
    public String getName() {
        return "rg";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getGraphicsState().setNonStrokingColorSpace(this.context.getResources().getColorSpace(COSName.DEVICERGB));
        super.process(operator, list);
    }
}