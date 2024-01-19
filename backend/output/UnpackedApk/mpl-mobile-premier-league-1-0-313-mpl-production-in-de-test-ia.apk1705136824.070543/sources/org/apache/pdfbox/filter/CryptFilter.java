package org.apache.pdfbox.filter;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public final class CryptFilter extends Filter {
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        COSName cOSName = (COSName) cOSDictionary.getDictionaryObject(COSName.NAME);
        if (cOSName == null || cOSName.equals(COSName.IDENTITY)) {
            new IdentityFilter().decode(inputStream, outputStream, cOSDictionary, i);
            return new DecodeResult(cOSDictionary);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported crypt filter ");
        outline73.append(cOSName.getName());
        throw new IOException(outline73.toString());
    }

    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        COSName cOSName = (COSName) cOSDictionary.getDictionaryObject(COSName.NAME);
        if (cOSName == null || cOSName.equals(COSName.IDENTITY)) {
            new IdentityFilter().encode(inputStream, outputStream, cOSDictionary);
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported crypt filter ");
        outline73.append(cOSName.getName());
        throw new IOException(outline73.toString());
    }
}
