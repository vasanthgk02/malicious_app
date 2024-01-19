package org.apache.pdfbox.pdmodel;

import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.COSStreamArray;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.action.PDPageAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDTransition;
import org.apache.pdfbox.util.Matrix;

public class PDPage implements COSObjectable, PDContentStream {
    public PDRectangle mediaBox;
    public final COSDictionary page;
    public PDResources pageResources;

    public PDPage() {
        this(PDRectangle.LETTER);
    }

    private PDRectangle clipToMediaBox(PDRectangle pDRectangle) {
        PDRectangle mediaBox2 = getMediaBox();
        PDRectangle pDRectangle2 = new PDRectangle();
        pDRectangle2.setLowerLeftX(Math.max(mediaBox2.getLowerLeftX(), pDRectangle.getLowerLeftX()));
        pDRectangle2.setLowerLeftY(Math.max(mediaBox2.getLowerLeftY(), pDRectangle.getLowerLeftY()));
        pDRectangle2.setUpperRightX(Math.min(mediaBox2.getUpperRightX(), pDRectangle.getUpperRightX()));
        pDRectangle2.setUpperRightY(Math.min(mediaBox2.getUpperRightY(), pDRectangle.getUpperRightY()));
        return pDRectangle2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PDPage) && ((PDPage) obj).getCOSObject() == getCOSObject();
    }

    public PDPageAdditionalActions getActions() {
        COSDictionary cOSDictionary = (COSDictionary) this.page.getDictionaryObject(COSName.AA);
        if (cOSDictionary == null) {
            cOSDictionary = new COSDictionary();
            this.page.setItem(COSName.AA, (COSBase) cOSDictionary);
        }
        return new PDPageAdditionalActions(cOSDictionary);
    }

    public List<PDAnnotation> getAnnotations() throws IOException {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.ANNOTS);
        if (cOSArray == null) {
            COSArray cOSArray2 = new COSArray();
            this.page.setItem(COSName.ANNOTS, (COSBase) cOSArray2);
            return new COSArrayList(new ArrayList(), cOSArray2);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            COSBase object = cOSArray.getObject(i);
            if (object != null) {
                arrayList.add(PDAnnotation.createAnnotation(object));
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDRectangle getArtBox() {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.ART_BOX);
        if (cOSArray != null) {
            return clipToMediaBox(new PDRectangle(cOSArray));
        }
        return getCropBox();
    }

    public PDRectangle getBBox() {
        return getCropBox();
    }

    public PDRectangle getBleedBox() {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.BLEED_BOX);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return clipToMediaBox(new PDRectangle(cOSArray));
    }

    public COSStream getContentStream() {
        COSBase dictionaryObject = this.page.getDictionaryObject(COSName.CONTENTS);
        if (dictionaryObject instanceof COSStream) {
            return (COSStream) dictionaryObject;
        }
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            if (cOSArray.size() > 0) {
                return new COSStreamArray(cOSArray);
            }
        }
        return null;
    }

    public PDRectangle getCropBox() {
        COSArray cOSArray = (COSArray) PDPageTree.getInheritableAttribute(this.page, COSName.CROP_BOX);
        if (cOSArray != null) {
            return clipToMediaBox(new PDRectangle(cOSArray));
        }
        return getMediaBox();
    }

    public Matrix getMatrix() {
        return new Matrix();
    }

    public PDRectangle getMediaBox() {
        if (this.mediaBox == null) {
            COSArray cOSArray = (COSArray) PDPageTree.getInheritableAttribute(this.page, COSName.MEDIA_BOX);
            if (cOSArray != null) {
                this.mediaBox = new PDRectangle(cOSArray);
            }
        }
        if (this.mediaBox == null) {
            this.mediaBox = PDRectangle.LETTER;
        }
        return this.mediaBox;
    }

    public PDMetadata getMetadata() {
        COSStream cOSStream = (COSStream) this.page.getDictionaryObject(COSName.METADATA);
        if (cOSStream != null) {
            return new PDMetadata(cOSStream);
        }
        return null;
    }

    public PDResources getResources() {
        if (this.pageResources == null) {
            COSDictionary cOSDictionary = (COSDictionary) PDPageTree.getInheritableAttribute(this.page, COSName.RESOURCES);
            if (cOSDictionary != null) {
                this.pageResources = new PDResources(cOSDictionary);
            }
        }
        return this.pageResources;
    }

    public int getRotation() {
        COSBase inheritableAttribute = PDPageTree.getInheritableAttribute(this.page, COSName.ROTATE);
        if (inheritableAttribute instanceof COSNumber) {
            int intValue = ((COSNumber) inheritableAttribute).intValue();
            if (intValue % 90 == 0) {
                return ((intValue % JpegTranscoderUtils.FULL_ROUND) + JpegTranscoderUtils.FULL_ROUND) % JpegTranscoderUtils.FULL_ROUND;
            }
        }
        return 0;
    }

    public PDStream getStream() throws IOException {
        return PDStream.createFromCOS(this.page.getDictionaryObject(COSName.CONTENTS));
    }

    public int getStructParents() {
        return this.page.getInt(COSName.STRUCT_PARENTS, 0);
    }

    public List<PDThreadBead> getThreadBeads() {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.B);
        if (cOSArray == null) {
            cOSArray = new COSArray();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            COSDictionary cOSDictionary = (COSDictionary) cOSArray.getObject(i);
            PDThreadBead pDThreadBead = null;
            if (cOSDictionary != null) {
                pDThreadBead = new PDThreadBead(cOSDictionary);
            }
            arrayList.add(pDThreadBead);
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDTransition getTransition() {
        COSDictionary cOSDictionary = (COSDictionary) this.page.getDictionaryObject(COSName.TRANS);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDTransition(cOSDictionary);
    }

    public PDRectangle getTrimBox() {
        COSArray cOSArray = (COSArray) this.page.getDictionaryObject(COSName.TRIM_BOX);
        if (cOSArray != null) {
            return clipToMediaBox(new PDRectangle(cOSArray));
        }
        return getCropBox();
    }

    public int hashCode() {
        return this.page.hashCode();
    }

    public void setActions(PDPageAdditionalActions pDPageAdditionalActions) {
        this.page.setItem(COSName.AA, (COSObjectable) pDPageAdditionalActions);
    }

    public void setAnnotations(List<PDAnnotation> list) {
        this.page.setItem(COSName.ANNOTS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setArtBox(PDRectangle pDRectangle) {
        if (pDRectangle == null) {
            this.page.removeItem(COSName.ART_BOX);
        } else {
            this.page.setItem(COSName.ART_BOX, (COSObjectable) pDRectangle);
        }
    }

    public void setBleedBox(PDRectangle pDRectangle) {
        if (pDRectangle == null) {
            this.page.removeItem(COSName.BLEED_BOX);
        } else {
            this.page.setItem(COSName.BLEED_BOX, (COSObjectable) pDRectangle);
        }
    }

    public void setContents(PDStream pDStream) {
        this.page.setItem(COSName.CONTENTS, (COSObjectable) pDStream);
    }

    public void setCropBox(PDRectangle pDRectangle) {
        if (pDRectangle == null) {
            this.page.removeItem(COSName.CROP_BOX);
        } else {
            this.page.setItem(COSName.CROP_BOX, (COSBase) pDRectangle.getCOSArray());
        }
    }

    public void setMediaBox(PDRectangle pDRectangle) {
        this.mediaBox = pDRectangle;
        if (pDRectangle == null) {
            this.page.removeItem(COSName.MEDIA_BOX);
        } else {
            this.page.setItem(COSName.MEDIA_BOX, (COSBase) pDRectangle.getCOSArray());
        }
    }

    public void setMetadata(PDMetadata pDMetadata) {
        this.page.setItem(COSName.METADATA, (COSObjectable) pDMetadata);
    }

    public void setResources(PDResources pDResources) {
        this.pageResources = pDResources;
        if (pDResources != null) {
            this.page.setItem(COSName.RESOURCES, (COSObjectable) pDResources);
        } else {
            this.page.removeItem(COSName.RESOURCES);
        }
    }

    public void setRotation(int i) {
        this.page.setInt(COSName.ROTATE, i);
    }

    public void setStructParents(int i) {
        this.page.setInt(COSName.STRUCT_PARENTS, i);
    }

    public void setThreadBeads(List<PDThreadBead> list) {
        this.page.setItem(COSName.B, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setTransition(PDTransition pDTransition) {
        this.page.setItem(COSName.TRANS, (COSObjectable) pDTransition);
    }

    public void setTrimBox(PDRectangle pDRectangle) {
        if (pDRectangle == null) {
            this.page.removeItem(COSName.TRIM_BOX);
        } else {
            this.page.setItem(COSName.TRIM_BOX, (COSObjectable) pDRectangle);
        }
    }

    public PDPage(PDRectangle pDRectangle) {
        COSDictionary cOSDictionary = new COSDictionary();
        this.page = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.PAGE);
        this.page.setItem(COSName.MEDIA_BOX, (COSObjectable) pDRectangle);
    }

    public COSDictionary getCOSObject() {
        return this.page;
    }

    public void setTransition(PDTransition pDTransition, float f2) {
        this.page.setItem(COSName.TRANS, (COSObjectable) pDTransition);
        this.page.setItem(COSName.DUR, (COSBase) new COSFloat(f2));
    }

    public PDPage(COSDictionary cOSDictionary) {
        this.page = cOSDictionary;
    }
}
