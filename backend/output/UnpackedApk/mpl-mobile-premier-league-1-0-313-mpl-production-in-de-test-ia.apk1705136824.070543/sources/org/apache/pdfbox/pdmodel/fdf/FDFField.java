package org.apache.pdfbox.pdmodel.fdf;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDTextStream;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FDFField implements COSObjectable {
    public COSDictionary field;

    public FDFField() {
        this.field = new COSDictionary();
    }

    private String escapeXML(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                sb.append("&quot;");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt == '\'') {
                sb.append("&apos;");
            } else if (charAt > '~') {
                sb.append("&#" + charAt + ";");
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public PDAction getAction() {
        return PDActionFactory.createAction((COSDictionary) this.field.getDictionaryObject(COSName.A));
    }

    public PDAdditionalActions getAdditionalActions() {
        COSDictionary cOSDictionary = (COSDictionary) this.field.getDictionaryObject(COSName.AA);
        if (cOSDictionary != null) {
            return new PDAdditionalActions(cOSDictionary);
        }
        return null;
    }

    public PDAppearanceDictionary getAppearanceDictionary() {
        COSDictionary cOSDictionary = (COSDictionary) this.field.getDictionaryObject(COSName.AP);
        if (cOSDictionary != null) {
            return new PDAppearanceDictionary(cOSDictionary);
        }
        return null;
    }

    public FDFNamedPageReference getAppearanceStreamReference() {
        COSDictionary cOSDictionary = (COSDictionary) this.field.getDictionaryObject(COSName.AP_REF);
        if (cOSDictionary != null) {
            return new FDFNamedPageReference(cOSDictionary);
        }
        return null;
    }

    public COSDictionary getCOSDictionary() {
        return this.field;
    }

    public COSBase getCOSObject() {
        return this.field;
    }

    public Integer getClearFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject(COSName.CLR_FF);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public Integer getClearWidgetFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject(COSName.CLR_F);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public Integer getFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject(COSName.FF);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public FDFIconFit getIconFit() {
        COSDictionary cOSDictionary = (COSDictionary) this.field.getDictionaryObject((String) "IF");
        if (cOSDictionary != null) {
            return new FDFIconFit(cOSDictionary);
        }
        return null;
    }

    public List<FDFField> getKids() {
        COSArray cOSArray = (COSArray) this.field.getDictionaryObject(COSName.KIDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new FDFField((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public List<Object> getOptions() {
        COSArray cOSArray = (COSArray) this.field.getDictionaryObject(COSName.OPT);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            COSBase object = cOSArray.getObject(i);
            if (object instanceof COSString) {
                arrayList.add(((COSString) object).getString());
            } else {
                arrayList.add(new FDFOptionElement((COSArray) object));
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getPartialFieldName() {
        return this.field.getString(COSName.T);
    }

    public PDTextStream getRichText() {
        return PDTextStream.createTextStream(this.field.getDictionaryObject(COSName.RV));
    }

    public Integer getSetFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject(COSName.SET_FF);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public Integer getSetWidgetFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject(COSName.SET_F);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public Object getValue() throws IOException {
        COSBase dictionaryObject = this.field.getDictionaryObject(COSName.V);
        if (dictionaryObject instanceof COSName) {
            return ((COSName) dictionaryObject).getName();
        }
        if (dictionaryObject instanceof COSArray) {
            return COSArrayList.convertCOSStringCOSArrayToList((COSArray) dictionaryObject);
        }
        if ((dictionaryObject instanceof COSString) || (dictionaryObject instanceof COSStream)) {
            return PDTextStream.createTextStream(dictionaryObject);
        }
        if (dictionaryObject == null) {
            return null;
        }
        throw new IOException("Error:Unknown type for field import" + dictionaryObject);
    }

    public Integer getWidgetFieldFlags() {
        COSNumber cOSNumber = (COSNumber) this.field.getDictionaryObject((String) PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);
        if (cOSNumber != null) {
            return Integer.valueOf(cOSNumber.intValue());
        }
        return null;
    }

    public void setAction(PDAction pDAction) {
        this.field.setItem(COSName.A, (COSObjectable) pDAction);
    }

    public void setAdditionalActions(PDAdditionalActions pDAdditionalActions) {
        this.field.setItem(COSName.AA, (COSObjectable) pDAdditionalActions);
    }

    public void setAppearanceDictionary(PDAppearanceDictionary pDAppearanceDictionary) {
        this.field.setItem(COSName.AP, (COSObjectable) pDAppearanceDictionary);
    }

    public void setAppearanceStreamReference(FDFNamedPageReference fDFNamedPageReference) {
        this.field.setItem(COSName.AP_REF, (COSObjectable) fDFNamedPageReference);
    }

    public void setClearFieldFlags(Integer num) {
        this.field.setItem(COSName.CLR_FF, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void setClearWidgetFieldFlags(Integer num) {
        this.field.setItem(COSName.CLR_F, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void setFieldFlags(Integer num) {
        this.field.setItem(COSName.FF, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void setIconFit(FDFIconFit fDFIconFit) {
        this.field.setItem(COSName.IF, (COSObjectable) fDFIconFit);
    }

    public void setKids(List<FDFField> list) {
        this.field.setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setOptions(List list) {
        this.field.setItem(COSName.OPT, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setPartialFieldName(String str) {
        this.field.setString(COSName.T, str);
    }

    public void setRichText(PDTextStream pDTextStream) {
        this.field.setItem(COSName.RV, (COSObjectable) pDTextStream);
    }

    public void setSetFieldFlags(Integer num) {
        this.field.setItem(COSName.SET_FF, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void setSetWidgetFieldFlags(Integer num) {
        this.field.setItem(COSName.SET_F, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void setValue(Object obj) throws IOException {
        COSBase cOSBase;
        if (obj instanceof List) {
            cOSBase = COSArrayList.convertStringListToCOSStringCOSArray((List) obj);
        } else if (obj instanceof String) {
            cOSBase = COSName.getPDFName((String) obj);
        } else if (obj instanceof COSObjectable) {
            cOSBase = ((COSObjectable) obj).getCOSObject();
        } else if (obj == null) {
            cOSBase = null;
        } else {
            throw new IOException(GeneratedOutlineSupport.outline48("Error:Unknown type for field import", obj));
        }
        this.field.setItem(COSName.V, cOSBase);
    }

    public void setWidgetFieldFlags(Integer num) {
        this.field.setItem(COSName.F, (COSBase) num != null ? COSInteger.get((long) num.intValue()) : null);
    }

    public void writeXML(Writer writer) throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<field name=\"");
        outline73.append(getPartialFieldName());
        outline73.append("\">\n");
        writer.write(outline73.toString());
        Object value = getValue();
        if (value != null) {
            if (value instanceof String) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("<value>");
                outline732.append(escapeXML((String) value));
                outline732.append("</value>\n");
                writer.write(outline732.toString());
            } else if (value instanceof PDTextStream) {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("<value>");
                outline733.append(escapeXML(((PDTextStream) value).getAsString()));
                outline733.append("</value>\n");
                writer.write(outline733.toString());
            }
        }
        PDTextStream richText = getRichText();
        if (richText != null) {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("<value-richtext>");
            outline734.append(escapeXML(richText.getAsString()));
            outline734.append("</value-richtext>\n");
            writer.write(outline734.toString());
        }
        List<FDFField> kids = getKids();
        if (kids != null) {
            for (FDFField writeXML : kids) {
                writeXML.writeXML(writer);
            }
        }
        writer.write("</field>\n");
    }

    public FDFField(COSDictionary cOSDictionary) {
        this.field = cOSDictionary;
    }

    public void setClearFieldFlags(int i) {
        this.field.setInt(COSName.CLR_FF, i);
    }

    public void setClearWidgetFieldFlags(int i) {
        this.field.setInt(COSName.CLR_F, i);
    }

    public void setFieldFlags(int i) {
        this.field.setInt(COSName.FF, i);
    }

    public void setSetFieldFlags(int i) {
        this.field.setInt(COSName.SET_FF, i);
    }

    public void setSetWidgetFieldFlags(int i) {
        this.field.setInt(COSName.SET_F, i);
    }

    public void setWidgetFieldFlags(int i) {
        this.field.setInt(COSName.F, i);
    }

    public FDFField(Element element) throws IOException {
        this();
        setPartialFieldName(element.getAttribute("name"));
        NodeList childNodes = element.getChildNodes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(HSLCriteriaBuilder.VALUE)) {
                    setValue(XMLUtil.getNodeValue(element2));
                } else if (element2.getTagName().equals("value-richtext")) {
                    setRichText(new PDTextStream(XMLUtil.getNodeValue(element2)));
                } else if (element2.getTagName().equals(HSLCriteriaBuilder.FIELD)) {
                    arrayList.add(new FDFField(element2));
                }
            }
        }
        if (arrayList.size() > 0) {
            setKids(arrayList);
        }
    }
}
