package org.apache.pdfbox.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.filter.ccitt.CCITTFaxG31DDecodeInputStream;
import org.apache.pdfbox.filter.ccitt.FillOrderChangeInputStream;
import org.apache.pdfbox.filter.ccitt.TIFFFaxDecoder;
import org.apache.pdfbox.io.IOUtils;
import sfs2x.client.entities.invitation.InvitationReply;

public final class CCITTFaxFilter extends Filter {
    public static void invertBitmap(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((~bArr[i]) & InvitationReply.EXPIRED);
        }
    }

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        int i2;
        byte[] bArr;
        COSDictionary cOSDictionary2 = cOSDictionary;
        DecodeResult decodeResult = new DecodeResult(new COSDictionary());
        decodeResult.getParameters().addAll(cOSDictionary2);
        COSDictionary decodeParams = Filter.getDecodeParams(cOSDictionary, i);
        int i3 = decodeParams.getInt(COSName.COLUMNS, 1728);
        int i4 = decodeParams.getInt(COSName.ROWS, 0);
        int i5 = cOSDictionary2.getInt(COSName.HEIGHT, COSName.H, 0);
        if (i4 <= 0 || i5 <= 0) {
            i2 = Math.max(i4, i5);
        } else {
            i2 = Math.min(i4, i5);
        }
        int i6 = i2;
        int i7 = decodeParams.getInt(COSName.K, 0);
        boolean z = decodeParams.getBoolean(COSName.ENCODED_BYTE_ALIGN, false);
        int i8 = ((i3 + 7) / 8) * i6;
        TIFFFaxDecoder tIFFFaxDecoder = new TIFFFaxDecoder(1, i3, i6);
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        byte[] bArr2 = null;
        if (i7 == 0) {
            FillOrderChangeInputStream fillOrderChangeInputStream = new FillOrderChangeInputStream(new CCITTFaxG31DDecodeInputStream(new ByteArrayInputStream(byteArray), i3, z));
            bArr2 = IOUtils.toByteArray(fillOrderChangeInputStream);
            fillOrderChangeInputStream.close();
        } else {
            if (i7 > 0) {
                bArr = new byte[i8];
                tIFFFaxDecoder.decode2D(bArr, byteArray, 0, i6, 0);
            } else if (i7 < 0) {
                bArr = new byte[i8];
                tIFFFaxDecoder.decodeT6(bArr, byteArray, 0, i6, 0, z);
            }
            bArr2 = bArr;
        }
        if (!decodeParams.getBoolean(COSName.BLACK_IS_1, false)) {
            invertBitmap(bArr2);
        }
        if (!cOSDictionary2.containsKey(COSName.COLORSPACE)) {
            decodeResult.getParameters().setName(COSName.COLORSPACE, COSName.DEVICEGRAY.getName());
        }
        outputStream.write(bArr2);
        return new DecodeResult(cOSDictionary2);
    }

    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
    }
}
