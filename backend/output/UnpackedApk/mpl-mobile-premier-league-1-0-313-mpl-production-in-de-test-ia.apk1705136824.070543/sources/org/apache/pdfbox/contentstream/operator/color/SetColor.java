package org.apache.pdfbox.contentstream.operator.color;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceColorSpace;

public abstract class SetColor extends OperatorProcessor {
    public abstract PDColor getColor();

    public abstract PDColorSpace getColorSpace();

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PDColorSpace colorSpace = getColorSpace();
        if (!(colorSpace instanceof PDDeviceColorSpace) || list.size() >= colorSpace.getNumberOfComponents()) {
            COSArray cOSArray = new COSArray();
            cOSArray.addAll((Collection<COSBase>) list);
            setColor(new PDColor(cOSArray, colorSpace));
            return;
        }
        throw new MissingOperandException(operator, list);
    }

    public abstract void setColor(PDColor pDColor);
}
