package org.apache.pdfbox.pdmodel.fdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.rudderstack.android.sdk.core.MessageType;
import java.io.IOException;
import java.util.Calendar;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.action.PDWindowsLaunchParams;
import org.apache.pdfbox.util.DateConverter;
import org.w3c.dom.Element;

public abstract class FDFAnnotation implements COSObjectable {
    public COSDictionary annot;

    public FDFAnnotation() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.annot = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.ANNOT);
    }

    public static FDFAnnotation create(COSDictionary cOSDictionary) throws IOException {
        if (cOSDictionary == null) {
            return null;
        }
        if ("Text".equals(cOSDictionary.getNameAsString(COSName.SUBTYPE))) {
            return new FDFAnnotationText(cOSDictionary);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown annotation type '");
        outline73.append(cOSDictionary.getNameAsString(COSName.SUBTYPE));
        outline73.append("'");
        throw new IOException(outline73.toString());
    }

    public COSDictionary getCOSDictionary() {
        return this.annot;
    }

    public COSBase getCOSObject() {
        return this.annot;
    }

    public Calendar getCreationDate() throws IOException {
        return this.annot.getDate(COSName.CREATION_DATE);
    }

    public String getDate() {
        return this.annot.getString(COSName.DATE);
    }

    public String getName() {
        return this.annot.getString(COSName.NM);
    }

    public float getOpacity() {
        return this.annot.getFloat(COSName.CA, 1.0f);
    }

    public Integer getPage() {
        COSNumber cOSNumber = (COSNumber) this.annot.getDictionaryObject(COSName.PAGE);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public PDRectangle getRectangle() {
        COSArray cOSArray = (COSArray) this.annot.getDictionaryObject(COSName.RECT);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public String getSubject() {
        return this.annot.getString(COSName.SUBJ);
    }

    public String getTitle() {
        return this.annot.getString(COSName.T);
    }

    public boolean isHidden() {
        return this.annot.getFlag(COSName.F, 2);
    }

    public boolean isInvisible() {
        return this.annot.getFlag(COSName.F, 1);
    }

    public boolean isLocked() {
        return this.annot.getFlag(COSName.F, 128);
    }

    public boolean isNoRotate() {
        return this.annot.getFlag(COSName.F, 16);
    }

    public boolean isNoView() {
        return this.annot.getFlag(COSName.F, 32);
    }

    public boolean isNoZoom() {
        return this.annot.getFlag(COSName.F, 8);
    }

    public boolean isPrinted() {
        return this.annot.getFlag(COSName.F, 4);
    }

    public boolean isReadOnly() {
        return this.annot.getFlag(COSName.F, 64);
    }

    public boolean isToggleNoView() {
        return this.annot.getFlag(COSName.F, 256);
    }

    public void setCreationDate(Calendar calendar) {
        this.annot.setDate(COSName.CREATION_DATE, calendar);
    }

    public void setDate(String str) {
        this.annot.setString(COSName.DATE, str);
    }

    public void setHidden(boolean z) {
        this.annot.setFlag(COSName.F, 2, z);
    }

    public void setInvisible(boolean z) {
        this.annot.setFlag(COSName.F, 1, z);
    }

    public void setLocked(boolean z) {
        this.annot.setFlag(COSName.F, 128, z);
    }

    public void setName(String str) {
        this.annot.setString(COSName.NM, str);
    }

    public void setNoRotate(boolean z) {
        this.annot.setFlag(COSName.F, 16, z);
    }

    public void setNoView(boolean z) {
        this.annot.setFlag(COSName.F, 32, z);
    }

    public void setNoZoom(boolean z) {
        this.annot.setFlag(COSName.F, 8, z);
    }

    public void setOpacity(float f2) {
        this.annot.setFloat(COSName.CA, f2);
    }

    public void setPage(int i) {
        this.annot.setInt((String) "Page", i);
    }

    public void setPrinted(boolean z) {
        this.annot.setFlag(COSName.F, 4, z);
    }

    public void setReadOnly(boolean z) {
        this.annot.setFlag(COSName.F, 64, z);
    }

    public void setRectangle(PDRectangle pDRectangle) {
        this.annot.setItem(COSName.RECT, (COSObjectable) pDRectangle);
    }

    public void setSubject(String str) {
        this.annot.setString(COSName.SUBJ, str);
    }

    public void setTitle(String str) {
        this.annot.setString(COSName.T, str);
    }

    public void setToggleNoView(boolean z) {
        this.annot.setFlag(COSName.F, 256, z);
    }

    public FDFAnnotation(COSDictionary cOSDictionary) {
        this.annot = cOSDictionary;
    }

    public FDFAnnotation(Element element) throws IOException {
        this();
        String attribute = element.getAttribute(MessageType.PAGE);
        if (attribute != null) {
            setPage(Integer.parseInt(attribute));
        }
        String attribute2 = element.getAttribute("color");
        if (attribute2 != null && attribute2.length() == 7 && attribute2.charAt(0) == '#') {
            Integer.parseInt(attribute2.substring(1, 7), 16);
        }
        setDate(element.getAttribute(DatePickerDialogModule.ARG_DATE));
        String attribute3 = element.getAttribute("flags");
        if (attribute3 != null) {
            for (String str : attribute3.split(",")) {
                if (str.equals("invisible")) {
                    setInvisible(true);
                } else if (str.equals("hidden")) {
                    setHidden(true);
                } else if (str.equals(PDWindowsLaunchParams.OPERATION_PRINT)) {
                    setPrinted(true);
                } else if (str.equals("nozoom")) {
                    setNoZoom(true);
                } else if (str.equals("norotate")) {
                    setNoRotate(true);
                } else if (str.equals("noview")) {
                    setNoView(true);
                } else if (str.equals("readonly")) {
                    setReadOnly(true);
                } else if (str.equals("locked")) {
                    setLocked(true);
                } else if (str.equals("togglenoview")) {
                    setToggleNoView(true);
                }
            }
        }
        setName(element.getAttribute("name"));
        String attribute4 = element.getAttribute("rect");
        if (attribute4 != null) {
            String[] split = attribute4.split(",");
            float[] fArr = new float[split.length];
            for (int i = 0; i < split.length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            COSArray cOSArray = new COSArray();
            cOSArray.setFloatArray(fArr);
            setRectangle(new PDRectangle(cOSArray));
        }
        setName(element.getAttribute("title"));
        setCreationDate(DateConverter.toCalendar(element.getAttribute("creationdate")));
        String attribute5 = element.getAttribute("opacity");
        if (attribute5 != null) {
            setOpacity(Float.parseFloat(attribute5));
        }
        setSubject(element.getAttribute("subject"));
    }
}
