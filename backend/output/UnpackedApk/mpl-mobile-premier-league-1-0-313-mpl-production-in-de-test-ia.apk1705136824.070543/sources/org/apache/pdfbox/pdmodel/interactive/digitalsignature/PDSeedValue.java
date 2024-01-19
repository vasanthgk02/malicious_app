package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDSeedValue implements COSObjectable {
    public static final int FLAG_ADD_REV_INFO = 32;
    public static final int FLAG_DIGEST_METHOD = 64;
    public static final int FLAG_FILTER = 1;
    public static final int FLAG_LEGAL_ATTESTATION = 16;
    public static final int FLAG_REASON = 8;
    public static final int FLAG_SUBFILTER = 2;
    public static final int FLAG_V = 4;
    public COSDictionary dictionary;

    public PDSeedValue() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.SV);
        this.dictionary.setDirect(true);
    }

    public COSBase getCOSObject() {
        return getDictionary();
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public List<String> getDigestMethod() {
        COSArray cOSArray = (COSArray) this.dictionary.getDictionaryObject(COSName.DIGEST_METHOD);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            String name = cOSArray.getName(i);
            if (name != null) {
                arrayList.add(name);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getFilter() {
        return this.dictionary.getNameAsString(COSName.FILTER);
    }

    public List<String> getLegalAttestation() {
        COSArray cOSArray = (COSArray) this.dictionary.getDictionaryObject(COSName.LEGAL_ATTESTATION);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            String string = cOSArray.getString(i);
            if (string != null) {
                arrayList.add(string);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDSeedValueMDP getMDP() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.MDP);
        if (cOSDictionary != null) {
            return new PDSeedValueMDP(cOSDictionary);
        }
        return null;
    }

    public List<String> getReasons() {
        COSArray cOSArray = (COSArray) this.dictionary.getDictionaryObject(COSName.REASONS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            String string = cOSArray.getString(i);
            if (string != null) {
                arrayList.add(string);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public List<String> getSubFilter() {
        COSArray cOSArray = (COSArray) this.dictionary.getDictionaryObject(COSName.SUB_FILTER);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            String name = cOSArray.getName(i);
            if (name != null) {
                arrayList.add(name);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDSeedValueTimeStamp getTimeStamp() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.TIME_STAMP);
        if (cOSDictionary != null) {
            return new PDSeedValueTimeStamp(cOSDictionary);
        }
        return null;
    }

    public float getV() {
        return this.dictionary.getFloat(COSName.V);
    }

    public boolean isAddRevInfoRequired() {
        return getDictionary().getFlag(COSName.FF, 32);
    }

    public boolean isDigestMethodRequired() {
        return getDictionary().getFlag(COSName.FF, 64);
    }

    public boolean isFilterRequired() {
        return getDictionary().getFlag(COSName.FF, 1);
    }

    public boolean isLegalAttestationRequired() {
        return getDictionary().getFlag(COSName.FF, 16);
    }

    public boolean isReasonRequired() {
        return getDictionary().getFlag(COSName.FF, 8);
    }

    public boolean isSubFilterRequired() {
        return getDictionary().getFlag(COSName.FF, 2);
    }

    public boolean isVRequired() {
        return getDictionary().getFlag(COSName.FF, 4);
    }

    public void setAddRevInfoRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 32, z);
    }

    public void setDigestMethod(List<COSName> list) {
        for (COSName next : list) {
            if (!next.equals(COSName.DIGEST_SHA1) && !next.equals(COSName.DIGEST_SHA256) && !next.equals(COSName.DIGEST_SHA384) && !next.equals(COSName.DIGEST_SHA512) && !next.equals(COSName.DIGEST_RIPEMD160)) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Specified digest ");
                outline73.append(next.getName());
                outline73.append(" isn't allowed.");
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        this.dictionary.setItem(COSName.DIGEST_METHOD, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDigestMethodRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 64, z);
    }

    public void setFilter(COSName cOSName) {
        this.dictionary.setItem(COSName.FILTER, (COSBase) cOSName);
    }

    public void setFilterRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 1, z);
    }

    public void setLegalAttestation(List<String> list) {
        this.dictionary.setItem(COSName.LEGAL_ATTESTATION, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setLegalAttestationRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 16, z);
    }

    public void setMPD(PDSeedValueMDP pDSeedValueMDP) {
        if (pDSeedValueMDP != null) {
            this.dictionary.setItem(COSName.MDP, pDSeedValueMDP.getCOSObject());
        }
    }

    public void setReasonRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 8, z);
    }

    public void setReasonsd(List<String> list) {
        this.dictionary.setItem(COSName.REASONS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setSubFilter(List<COSName> list) {
        this.dictionary.setItem(COSName.SUB_FILTER, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setSubFilterRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 2, z);
    }

    public void setTimeStamp(PDSeedValueTimeStamp pDSeedValueTimeStamp) {
        if (pDSeedValueTimeStamp != null) {
            this.dictionary.setItem(COSName.TIME_STAMP, pDSeedValueTimeStamp.getCOSObject());
        }
    }

    public void setV(float f2) {
        this.dictionary.setFloat(COSName.V, f2);
    }

    public void setVRequired(boolean z) {
        getDictionary().setFlag(COSName.FF, 4, z);
    }

    public PDSeedValue(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }
}
