package org.apache.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.filter.DecodeResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;

public final class PDImageXObject extends PDXObject implements PDImage {
    public Bitmap cachedImage;
    public PDColorSpace colorSpace;
    public PDResources resources;

    public PDImageXObject(PDDocument pDDocument) throws IOException {
        this(new PDStream(pDDocument), null);
    }

    public static PDImageXObject createThumbnail(COSStream cOSStream) throws IOException {
        return new PDImageXObject(new PDStream(cOSStream), null);
    }

    public static PDStream repair(PDStream pDStream, DecodeResult decodeResult) {
        pDStream.getStream().addAll(decodeResult.getParameters());
        return pDStream;
    }

    public int getBitsPerComponent() {
        if (isStencil()) {
            return 1;
        }
        getCOSStream().getInt(COSName.BITS_PER_COMPONENT, COSName.BPC);
        return getCOSStream().getInt(COSName.BITS_PER_COMPONENT, COSName.BPC);
    }

    public COSArray getColorKeyMask() {
        COSBase dictionaryObject = getCOSStream().getDictionaryObject(COSName.MASK);
        if (dictionaryObject instanceof COSArray) {
            return (COSArray) dictionaryObject;
        }
        return null;
    }

    public PDColorSpace getColorSpace() throws IOException {
        if (this.colorSpace == null) {
            COSBase dictionaryObject = getCOSStream().getDictionaryObject(COSName.COLORSPACE, COSName.CS);
            if (dictionaryObject != null) {
                this.colorSpace = PDColorSpace.create(dictionaryObject, this.resources);
            } else if (isStencil()) {
                return PDDeviceGray.INSTANCE;
            } else {
                throw new IOException("could not determine color space");
            }
        }
        return this.colorSpace;
    }

    public COSArray getDecode() {
        COSBase dictionaryObject = getCOSStream().getDictionaryObject(COSName.DECODE);
        if (dictionaryObject instanceof COSArray) {
            return (COSArray) dictionaryObject;
        }
        return null;
    }

    public int getHeight() {
        return getCOSStream().getInt(COSName.HEIGHT);
    }

    public Bitmap getImage() throws IOException {
        Bitmap bitmap = this.cachedImage;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap rGBImage = SampledImageReader.getRGBImage(this, getColorKeyMask());
        if (getSoftMask() == null) {
            getMask();
        }
        this.cachedImage = rGBImage;
        return rGBImage;
    }

    public boolean getInterpolate() {
        return getCOSStream().getBoolean(COSName.INTERPOLATE, false);
    }

    public PDImageXObject getMask() throws IOException {
        if (getCOSStream().getDictionaryObject(COSName.MASK) instanceof COSArray) {
            return null;
        }
        COSStream cOSStream = (COSStream) getCOSStream().getDictionaryObject(COSName.MASK);
        if (cOSStream != null) {
            return new PDImageXObject(new PDStream(cOSStream), null);
        }
        return null;
    }

    public PDMetadata getMetadata() {
        COSStream cOSStream = (COSStream) getCOSStream().getDictionaryObject(COSName.METADATA);
        if (cOSStream != null) {
            return new PDMetadata(cOSStream);
        }
        return null;
    }

    public Bitmap getOpaqueImage() throws IOException {
        return SampledImageReader.getRGBImage(this, null);
    }

    public PDImageXObject getSoftMask() throws IOException {
        COSStream cOSStream = (COSStream) getCOSStream().getDictionaryObject(COSName.SMASK);
        if (cOSStream != null) {
            return new PDImageXObject(new PDStream(cOSStream), null);
        }
        return null;
    }

    public PDStream getStream() throws IOException {
        return getPDStream();
    }

    public int getStructParent() {
        return getCOSStream().getInt(COSName.STRUCT_PARENT, 0);
    }

    public String getSuffix() {
        List<COSName> filters = getPDStream().getFilters();
        if (filters == null) {
            return "png";
        }
        if (filters.contains(COSName.DCT_DECODE)) {
            return "jpg";
        }
        if (filters.contains(COSName.JPX_DECODE)) {
            return "jpx";
        }
        if (filters.contains(COSName.CCITTFAX_DECODE)) {
            return "tiff";
        }
        if (filters.contains(COSName.FLATE_DECODE) || filters.contains(COSName.LZW_DECODE) || filters.contains(COSName.RUN_LENGTH_DECODE)) {
            return "png";
        }
        "getSuffix() returns null, filters: " + filters;
        return null;
    }

    public int getWidth() {
        return getCOSStream().getInt(COSName.WIDTH);
    }

    public boolean isStencil() {
        return getCOSStream().getBoolean(COSName.IMAGE_MASK, false);
    }

    public void setBitsPerComponent(int i) {
        getCOSStream().setInt(COSName.BITS_PER_COMPONENT, i);
    }

    public void setColorSpace(PDColorSpace pDColorSpace) {
        getCOSStream().setItem(COSName.COLORSPACE, pDColorSpace != null ? pDColorSpace.getCOSObject() : null);
        getCOSStream().setItem(COSName.COLORSPACE, (COSBase) COSName.DEVICERGB);
    }

    public void setDecode(COSArray cOSArray) {
        getCOSStream().setItem(COSName.DECODE, (COSBase) cOSArray);
    }

    public void setHeight(int i) {
        getCOSStream().setInt(COSName.HEIGHT, i);
    }

    public void setInterpolate(boolean z) {
        getCOSStream().setBoolean(COSName.INTERPOLATE, z);
    }

    public void setMetadata(PDMetadata pDMetadata) {
        getCOSStream().setItem(COSName.METADATA, (COSObjectable) pDMetadata);
    }

    public void setStencil(boolean z) {
        getCOSStream().setBoolean(COSName.IMAGE_MASK, z);
    }

    public void setStructParent(int i) {
        getCOSStream().setInt(COSName.STRUCT_PARENT, i);
    }

    public void setWidth(int i) {
        getCOSStream().setInt(COSName.WIDTH, i);
    }

    public PDImageXObject(PDDocument pDDocument, InputStream inputStream, COSBase cOSBase, int i, int i2, int i3, PDColorSpace pDColorSpace) throws IOException {
        super(new PDStream(pDDocument, inputStream, true), COSName.IMAGE);
        getCOSStream().setItem(COSName.FILTER, cOSBase);
        this.resources = null;
        this.colorSpace = null;
        setBitsPerComponent(i3);
        setWidth(i);
        setHeight(i2);
        setColorSpace(pDColorSpace);
    }

    public PDImageXObject(PDStream pDStream, PDResources pDResources) throws IOException {
        this(pDStream, pDResources, pDStream.getStream().getDecodeResult());
    }

    public PDImageXObject(PDStream pDStream, PDResources pDResources, DecodeResult decodeResult) {
        super(repair(pDStream, decodeResult), COSName.IMAGE);
        this.resources = pDResources;
    }
}
