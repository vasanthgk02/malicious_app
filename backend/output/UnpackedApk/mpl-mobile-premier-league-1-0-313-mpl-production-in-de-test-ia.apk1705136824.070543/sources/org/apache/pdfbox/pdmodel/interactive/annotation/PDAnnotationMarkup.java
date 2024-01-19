package org.apache.pdfbox.pdmodel.interactive.annotation;

import java.io.IOException;
import java.util.Calendar;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDTextStream;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class PDAnnotationMarkup extends PDAnnotation {
    public static final String RT_GROUP = "Group";
    public static final String RT_REPLY = "R";
    public static final String SUB_TYPE_CARET = "Caret";
    public static final String SUB_TYPE_FREETEXT = "FreeText";
    public static final String SUB_TYPE_INK = "Ink";
    public static final String SUB_TYPE_POLYGON = "Polygon";
    public static final String SUB_TYPE_POLYLINE = "PolyLine";
    public static final String SUB_TYPE_SOUND = "Sound";

    public PDAnnotationMarkup() {
    }

    public float getConstantOpacity() {
        return getDictionary().getFloat((String) "CA", 1.0f);
    }

    public Calendar getCreationDate() throws IOException {
        return getDictionary().getDate((String) "CreationDate");
    }

    public PDExternalDataDictionary getExternalData() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject((String) "ExData");
        if (dictionaryObject instanceof COSDictionary) {
            return new PDExternalDataDictionary((COSDictionary) dictionaryObject);
        }
        return null;
    }

    public PDAnnotation getInReplyTo() throws IOException {
        return PDAnnotation.createAnnotation(getDictionary().getDictionaryObject((String) "IRT"));
    }

    public String getIntent() {
        return getDictionary().getNameAsString((String) "IT");
    }

    public PDAnnotationPopup getPopup() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject((String) PDAnnotationPopup.SUB_TYPE);
        if (cOSDictionary != null) {
            return new PDAnnotationPopup(cOSDictionary);
        }
        return null;
    }

    public String getReplyType() {
        return getDictionary().getNameAsString((String) StandardStructureTypes.RT, (String) "R");
    }

    public PDTextStream getRichContents() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject((String) "RC");
        if (dictionaryObject != null) {
            return PDTextStream.createTextStream(dictionaryObject);
        }
        return null;
    }

    public String getSubject() {
        return getDictionary().getString((String) "Subj");
    }

    public String getTitlePopup() {
        return getDictionary().getString((String) "T");
    }

    public void setConstantOpacity(float f2) {
        getDictionary().setFloat((String) "CA", f2);
    }

    public void setCreationDate(Calendar calendar) {
        getDictionary().setDate((String) "CreationDate", calendar);
    }

    public void setExternalData(PDExternalDataDictionary pDExternalDataDictionary) {
        getDictionary().setItem((String) "ExData", (COSObjectable) pDExternalDataDictionary);
    }

    public void setInReplyTo(PDAnnotation pDAnnotation) {
        getDictionary().setItem((String) "IRT", (COSObjectable) pDAnnotation);
    }

    public void setIntent(String str) {
        getDictionary().setName((String) "IT", str);
    }

    public void setPopup(PDAnnotationPopup pDAnnotationPopup) {
        getDictionary().setItem((String) PDAnnotationPopup.SUB_TYPE, (COSObjectable) pDAnnotationPopup);
    }

    public void setReplyType(String str) {
        getDictionary().setName((String) StandardStructureTypes.RT, str);
    }

    public void setRichContents(PDTextStream pDTextStream) {
        getDictionary().setItem((String) "RC", (COSObjectable) pDTextStream);
    }

    public void setSubject(String str) {
        getDictionary().setString((String) "Subj", str);
    }

    public void setTitlePopup(String str) {
        getDictionary().setString((String) "T", str);
    }

    public PDAnnotationMarkup(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
