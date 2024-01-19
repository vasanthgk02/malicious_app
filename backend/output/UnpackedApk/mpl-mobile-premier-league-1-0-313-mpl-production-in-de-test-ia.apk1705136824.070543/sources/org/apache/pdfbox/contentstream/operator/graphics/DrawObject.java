package org.apache.pdfbox.contentstream.operator.graphics;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.MissingResourceException;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public final class DrawObject extends GraphicsOperatorProcessor {
    public String getName() {
        return "Do";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        COSName cOSName = (COSName) list.get(0);
        PDXObject xObject = this.context.getResources().getXObject(cOSName);
        if (xObject == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Missing XObject: ");
            outline73.append(cOSName.getName());
            throw new MissingResourceException(outline73.toString());
        } else if (xObject instanceof PDImageXObject) {
            this.context.drawImage((PDImageXObject) xObject);
        } else if (xObject instanceof PDFormXObject) {
            PDFormXObject pDFormXObject = (PDFormXObject) xObject;
            if (pDFormXObject.getGroup() == null || !COSName.TRANSPARENCY.equals(pDFormXObject.getGroup().getSubType())) {
                getContext().showForm(pDFormXObject);
            } else {
                getContext().showTransparencyGroup(pDFormXObject);
            }
        }
    }
}
