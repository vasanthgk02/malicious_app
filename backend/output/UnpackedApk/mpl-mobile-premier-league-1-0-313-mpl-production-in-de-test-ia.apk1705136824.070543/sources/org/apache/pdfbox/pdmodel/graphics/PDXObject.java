package org.apache.pdfbox.pdmodel.graphics;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDXObject implements COSObjectable {
    public PDStream stream;

    public PDXObject(PDStream pDStream, COSName cOSName) {
        this.stream = pDStream;
        pDStream.getStream().setName(COSName.TYPE, COSName.XOBJECT.getName());
        pDStream.getStream().setName(COSName.SUBTYPE, cOSName.getName());
    }

    public static PDXObject createXObject(COSBase cOSBase, String str, PDResources pDResources) throws IOException {
        if (cOSBase == null) {
            return null;
        }
        if (cOSBase instanceof COSStream) {
            COSStream cOSStream = (COSStream) cOSBase;
            String nameAsString = cOSStream.getNameAsString(COSName.SUBTYPE);
            if (COSName.IMAGE.getName().equals(nameAsString)) {
                return new PDImageXObject(new PDStream(cOSStream), pDResources);
            }
            if (COSName.FORM.getName().equals(nameAsString)) {
                return new PDFormXObject(new PDStream(cOSStream), str);
            }
            if (COSName.PS.getName().equals(nameAsString)) {
                return new PDPostScriptXObject(new PDStream(cOSStream));
            }
            throw new IOException(GeneratedOutlineSupport.outline50("Invalid XObject Subtype: ", nameAsString));
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected object type: ");
        outline73.append(cOSBase.getClass().getName());
        throw new IOException(outline73.toString());
    }

    public final COSBase getCOSObject() {
        return this.stream.getCOSObject();
    }

    public final COSStream getCOSStream() {
        return this.stream.getStream();
    }

    public final PDStream getPDStream() {
        return this.stream;
    }

    public PDXObject(PDDocument pDDocument, COSName cOSName) {
        PDStream pDStream = new PDStream(pDDocument);
        this.stream = pDStream;
        pDStream.getStream().setName(COSName.TYPE, COSName.XOBJECT.getName());
        this.stream.getStream().setName(COSName.SUBTYPE, cOSName.getName());
    }
}
