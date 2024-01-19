package org.apache.pdfbox.pdmodel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Collections;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public final class PDResources implements COSObjectable {
    public final COSDictionary resources;

    public PDResources() {
        this.resources = new COSDictionary();
    }

    private COSName createKey(COSName cOSName, String str) {
        String sb;
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return COSName.getPDFName(str + 1);
        }
        do {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(cOSDictionary.keySet().size() + 1);
            sb = outline73.toString();
        } while (cOSDictionary.containsKey(sb));
        return COSName.getPDFName(sb);
    }

    private COSBase get(COSName cOSName, COSName cOSName2) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return cOSDictionary.getDictionaryObject(cOSName2);
    }

    private Iterable<COSName> getNames(COSName cOSName) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            return Collections.emptySet();
        }
        return cOSDictionary.keySet();
    }

    private void put(COSName cOSName, COSName cOSName2, COSObjectable cOSObjectable) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary == null) {
            cOSDictionary = new COSDictionary();
            this.resources.setItem(cOSName, (COSBase) cOSDictionary);
        }
        cOSDictionary.setItem(cOSName2, cOSObjectable);
    }

    public COSName add(PDFont pDFont) throws IOException {
        return add(COSName.FONT, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION, pDFont);
    }

    public PDColorSpace getColorSpace(COSName cOSName) throws IOException {
        COSBase cOSBase = get(COSName.COLORSPACE, cOSName);
        if (cOSBase != null) {
            return PDColorSpace.create(cOSBase, this);
        }
        return PDColorSpace.create(cOSName, this);
    }

    public Iterable<COSName> getColorSpaceNames() {
        return getNames(COSName.COLORSPACE);
    }

    public PDExtendedGraphicsState getExtGState(COSName cOSName) throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) get(COSName.EXT_G_STATE, cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDExtendedGraphicsState(cOSDictionary);
    }

    public Iterable<COSName> getExtGStateNames() {
        return getNames(COSName.EXT_G_STATE);
    }

    public PDFont getFont(COSName cOSName) throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) get(COSName.FONT, cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return PDFontFactory.createFont(cOSDictionary);
    }

    public Iterable<COSName> getFontNames() {
        return getNames(COSName.FONT);
    }

    public PDAbstractPattern getPattern(COSName cOSName) throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) get(COSName.PATTERN, cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return PDAbstractPattern.create(cOSDictionary);
    }

    public Iterable<COSName> getPatternNames() {
        return getNames(COSName.PATTERN);
    }

    public PDPropertyList getProperties(COSName cOSName) throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) get(COSName.PROPERTIES, cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return PDPropertyList.create(cOSDictionary);
    }

    public Iterable<COSName> getPropertiesNames() {
        return getNames(COSName.PROPERTIES);
    }

    public PDShading getShading(COSName cOSName) throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) get(COSName.SHADING, cOSName);
        if (cOSDictionary == null) {
            return null;
        }
        return PDShading.create(cOSDictionary);
    }

    public Iterable<COSName> getShadingNames() {
        return getNames(COSName.SHADING);
    }

    public PDXObject getXObject(COSName cOSName) throws IOException {
        COSBase cOSBase = get(COSName.XOBJECT, cOSName);
        if (cOSBase == null) {
            return null;
        }
        if (!(cOSBase instanceof COSObject)) {
            return PDXObject.createXObject(cOSBase, cOSName.getName(), this);
        }
        COSObject cOSObject = (COSObject) cOSBase;
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(cOSName.getName(), MqttTopic.MULTI_LEVEL_WILDCARD);
        outline78.append(cOSObject.getObjectNumber());
        return PDXObject.createXObject(cOSObject.getObject(), outline78.toString(), this);
    }

    public Iterable<COSName> getXObjectNames() {
        return getNames(COSName.XOBJECT);
    }

    public boolean hasColorSpace(COSName cOSName) {
        return get(COSName.COLORSPACE, cOSName) != null;
    }

    public COSName add(PDColorSpace pDColorSpace) {
        return add(COSName.COLORSPACE, "cs", pDColorSpace);
    }

    public COSDictionary getCOSObject() {
        return this.resources;
    }

    public PDResources(COSDictionary cOSDictionary) {
        if (cOSDictionary != null) {
            this.resources = cOSDictionary;
            return;
        }
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    public COSName add(PDExtendedGraphicsState pDExtendedGraphicsState) {
        return add(COSName.EXT_G_STATE, "gs", pDExtendedGraphicsState);
    }

    public COSName add(PDShading pDShading) {
        return add(COSName.SHADING, "sh", pDShading);
    }

    public COSName add(PDAbstractPattern pDAbstractPattern) {
        return add(COSName.PATTERN, "p", pDAbstractPattern);
    }

    public void put(COSName cOSName, PDFont pDFont) throws IOException {
        put(COSName.FONT, cOSName, pDFont);
    }

    public COSName add(PDPropertyList pDPropertyList) {
        if (pDPropertyList instanceof PDOptionalContentGroup) {
            return add(COSName.PROPERTIES, "oc", pDPropertyList);
        }
        return add(COSName.PROPERTIES, "Prop", pDPropertyList);
    }

    public void put(COSName cOSName, PDColorSpace pDColorSpace) throws IOException {
        put(COSName.COLORSPACE, cOSName, pDColorSpace);
    }

    public void put(COSName cOSName, PDExtendedGraphicsState pDExtendedGraphicsState) throws IOException {
        put(COSName.EXT_G_STATE, cOSName, pDExtendedGraphicsState);
    }

    public void put(COSName cOSName, PDShading pDShading) throws IOException {
        put(COSName.SHADING, cOSName, pDShading);
    }

    public COSName add(PDImageXObject pDImageXObject) {
        return add(COSName.XOBJECT, "Im", pDImageXObject);
    }

    public void put(COSName cOSName, PDAbstractPattern pDAbstractPattern) throws IOException {
        put(COSName.PATTERN, cOSName, pDAbstractPattern);
    }

    public COSName add(PDFormXObject pDFormXObject) {
        return add(COSName.XOBJECT, StandardStructureTypes.FORM, pDFormXObject);
    }

    public void put(COSName cOSName, PDPropertyList pDPropertyList) throws IOException {
        put(COSName.PROPERTIES, cOSName, pDPropertyList);
    }

    public COSName add(PDXObject pDXObject, String str) {
        return add(COSName.XOBJECT, str, pDXObject);
    }

    public void put(COSName cOSName, PDXObject pDXObject) throws IOException {
        put(COSName.XOBJECT, cOSName, pDXObject);
    }

    private COSName add(COSName cOSName, String str, COSObjectable cOSObjectable) {
        COSDictionary cOSDictionary = (COSDictionary) this.resources.getDictionaryObject(cOSName);
        if (cOSDictionary != null && cOSDictionary.containsValue(cOSObjectable.getCOSObject())) {
            return cOSDictionary.getKeyForValue(cOSObjectable.getCOSObject());
        }
        COSName createKey = createKey(cOSName, str);
        put(cOSName, createKey, cOSObjectable);
        return createKey;
    }
}
