package org.apache.pdfbox.contentstream.operator.color;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public class SetStrokingDeviceGrayColor extends SetStrokingColor {
    public String getName() {
        return "G";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getGraphicsState().setStrokingColorSpace(this.context.getResources().getColorSpace(COSName.DEVICEGRAY));
        super.process(operator, list);
    }
}
