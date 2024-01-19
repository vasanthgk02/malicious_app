package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.PDTextStream;

public final class PDTextField extends PDVariableText {
    public static final int FLAG_COMB = 16777216;
    public static final int FLAG_DO_NOT_SCROLL = 8388608;
    public static final int FLAG_DO_NOT_SPELL_CHECK = 4194304;
    public static final int FLAG_FILE_SELECT = 1048576;
    public static final int FLAG_MULTILINE = 4096;
    public static final int FLAG_PASSWORD = 8192;
    public static final int FLAG_RICH_TEXT = 33554432;

    public PDTextField(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getDictionary().setItem(COSName.FT, (COSBase) COSName.TX);
    }

    public boolean doNotScroll() {
        return getDictionary().getFlag(COSName.FF, FLAG_DO_NOT_SCROLL);
    }

    public boolean doNotSpellCheck() {
        return getDictionary().getFlag(COSName.FF, 4194304);
    }

    public int getMaxLen() {
        return getDictionary().getInt(COSName.MAX_LEN);
    }

    public PDTextStream getValueAsStream() throws IOException {
        return getAsTextStream(getInheritableAttribute(COSName.V));
    }

    public boolean isComb() {
        return getDictionary().getFlag(COSName.FF, 16777216);
    }

    public boolean isFileSelect() {
        return getDictionary().getFlag(COSName.FF, 1048576);
    }

    public boolean isMultiline() {
        return getDictionary().getFlag(COSName.FF, 4096);
    }

    public boolean isPassword() {
        return getDictionary().getFlag(COSName.FF, 8192);
    }

    public boolean isRichText() {
        return getDictionary().getFlag(COSName.FF, 33554432);
    }

    public void setComb(boolean z) {
        getDictionary().setFlag(COSName.FF, 16777216, z);
    }

    public void setDefaultValue(String str) {
        if (str != null) {
            setInheritableAttribute(COSName.DV, new COSString(str));
            return;
        }
        removeInheritableAttribute(COSName.DV);
    }

    public void setDoNotScroll(boolean z) {
        getDictionary().setFlag(COSName.FF, FLAG_DO_NOT_SCROLL, z);
    }

    public void setDoNotSpellCheck(boolean z) {
        getDictionary().setFlag(COSName.FF, 4194304, z);
    }

    public void setFileSelect(boolean z) {
        getDictionary().setFlag(COSName.FF, 1048576, z);
    }

    public void setMaxLen(int i) {
        getDictionary().setInt(COSName.MAX_LEN, i);
    }

    public void setMultiline(boolean z) {
        getDictionary().setFlag(COSName.FF, 4096, z);
    }

    public void setPassword(boolean z) {
        getDictionary().setFlag(COSName.FF, 8192, z);
    }

    public void setRichText(boolean z) {
        getDictionary().setFlag(COSName.FF, 33554432, z);
    }

    public void setValue(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            removeInheritableAttribute(COSName.DV);
        } else {
            setInheritableAttribute(COSName.V, new COSString(str));
        }
        updateFieldAppearances();
    }

    public String getDefaultValue() {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.DV);
        return inheritableAttribute instanceof COSString ? ((COSString) inheritableAttribute).getString() : "";
    }

    public String getValue() throws IOException {
        PDTextStream asTextStream = getAsTextStream(getInheritableAttribute(COSName.V));
        return asTextStream != null ? asTextStream.getAsString() : "";
    }

    public PDTextField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }

    public void setValue(PDTextStream pDTextStream) throws IOException {
        if (pDTextStream != null) {
            setInheritableAttribute(COSName.V, pDTextStream.getCOSObject());
        } else {
            removeInheritableAttribute(COSName.V);
        }
        updateFieldAppearances();
    }
}
