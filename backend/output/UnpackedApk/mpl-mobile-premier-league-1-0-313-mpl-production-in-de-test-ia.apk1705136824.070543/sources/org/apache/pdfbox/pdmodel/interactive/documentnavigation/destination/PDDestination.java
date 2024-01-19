package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;

public abstract class PDDestination implements PDDestinationOrAction {
    public static PDDestination create(COSBase cOSBase) throws IOException {
        PDNamedDestination pDNamedDestination;
        if (cOSBase == null) {
            return null;
        }
        if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            if (cOSArray.size() > 1 && (cOSArray.getObject(1) instanceof COSName)) {
                COSName cOSName = (COSName) cOSArray.getObject(1);
                String name = cOSName.getName();
                if (name.equals(PDPageFitDestination.TYPE) || name.equals(PDPageFitDestination.TYPE_BOUNDED)) {
                    return new PDPageFitDestination(cOSArray);
                }
                if (name.equals(PDPageFitHeightDestination.TYPE) || name.equals(PDPageFitHeightDestination.TYPE_BOUNDED)) {
                    return new PDPageFitHeightDestination(cOSArray);
                }
                if (name.equals(PDPageFitRectangleDestination.TYPE)) {
                    return new PDPageFitRectangleDestination(cOSArray);
                }
                if (name.equals(PDPageFitWidthDestination.TYPE) || name.equals(PDPageFitWidthDestination.TYPE_BOUNDED)) {
                    return new PDPageFitWidthDestination(cOSArray);
                }
                if (name.equals(PDPageXYZDestination.TYPE)) {
                    return new PDPageXYZDestination(cOSArray);
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown destination type: ");
                outline73.append(cOSName.getName());
                throw new IOException(outline73.toString());
            }
        }
        if (cOSBase instanceof COSString) {
            pDNamedDestination = new PDNamedDestination((COSString) cOSBase);
        } else if (cOSBase instanceof COSName) {
            pDNamedDestination = new PDNamedDestination((COSName) cOSBase);
        } else {
            throw new IOException("Error: can't convert to Destination " + cOSBase);
        }
        return pDNamedDestination;
    }
}
