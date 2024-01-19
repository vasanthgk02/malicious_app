package org.apache.pdfbox.pdmodel.interactive.form;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSeedValue;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;

public class PDSignatureField extends PDField {
    public PDSignatureField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }

    private String generatePartialName() {
        List<PDFieldTreeNode> fields = getAcroForm().getFields();
        HashSet hashSet = new HashSet();
        for (PDFieldTreeNode next : fields) {
            if (next instanceof PDSignatureField) {
                hashSet.add(next.getPartialName());
            }
        }
        int i = 1;
        while (true) {
            if (!hashSet.contains("Signature" + i)) {
                return GeneratedOutlineSupport.outline41("Signature", i);
            }
            i++;
        }
    }

    public Object getDefaultValue() {
        return null;
    }

    public PDSeedValue getSeedValue() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject(COSName.SV);
        if (cOSDictionary != null) {
            return new PDSeedValue(cOSDictionary);
        }
        return null;
    }

    public PDSignature getSignature() {
        return getValue();
    }

    public void setDefaultValue(String str) {
        throw new IllegalArgumentException("Signature fields don't support the \"DV\" entry.");
    }

    public void setSeedValue(PDSeedValue pDSeedValue) {
        if (pDSeedValue != null) {
            getDictionary().setItem(COSName.SV, pDSeedValue.getCOSObject());
        }
    }

    public void setSignature(PDSignature pDSignature) {
        setValue(pDSignature);
    }

    public void setValue(PDSignature pDSignature) {
        if (pDSignature == null) {
            getDictionary().removeItem(COSName.V);
        } else {
            getDictionary().setItem(COSName.V, (COSObjectable) pDSignature);
        }
    }

    public String toString() {
        return "PDSignatureField";
    }

    public PDSignatureField(PDAcroForm pDAcroForm) throws IOException {
        super(pDAcroForm);
        getDictionary().setItem(COSName.FT, (COSBase) COSName.SIG);
        getWidget().setLocked(true);
        getWidget().setPrinted(true);
        setPartialName(generatePartialName());
    }

    public PDSignature getValue() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject(COSName.V);
        if (dictionaryObject == null) {
            return null;
        }
        return new PDSignature((COSDictionary) dictionaryObject);
    }

    public void setValue(String str) {
        throw new IllegalArgumentException("Signature fields don't support a string for the value entry.");
    }
}
