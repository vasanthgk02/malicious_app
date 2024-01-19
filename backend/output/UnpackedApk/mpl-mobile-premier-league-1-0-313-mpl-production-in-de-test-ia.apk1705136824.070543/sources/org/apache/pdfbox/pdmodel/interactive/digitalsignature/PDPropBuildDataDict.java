package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDPropBuildDataDict implements COSObjectable {
    public COSDictionary dictionary;

    public PDPropBuildDataDict() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }

    public COSBase getCOSObject() {
        return getDictionary();
    }

    public String getDate() {
        return this.dictionary.getString(COSName.DATE);
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public long getMinimumRevision() {
        return this.dictionary.getLong(COSName.V);
    }

    public String getName() {
        return this.dictionary.getString(COSName.NAME);
    }

    public boolean getNonEFontNoWarn() {
        return this.dictionary.getBoolean(COSName.NON_EFONT_NO_WARN, true);
    }

    public String getOS() {
        return this.dictionary.getString(COSName.OS);
    }

    public boolean getPreRelease() {
        return this.dictionary.getBoolean(COSName.PRE_RELEASE, false);
    }

    public long getRevision() {
        return this.dictionary.getLong(COSName.R);
    }

    public boolean getTrustedMode() {
        return this.dictionary.getBoolean(COSName.TRUSTED_MODE, false);
    }

    public void setDate(String str) {
        this.dictionary.setString(COSName.DATE, str);
    }

    public void setMinimumRevision(long j) {
        this.dictionary.setLong(COSName.V, j);
    }

    public void setName(String str) {
        this.dictionary.setName(COSName.NAME, str);
    }

    public void setOS(String str) {
        this.dictionary.setString(COSName.OS, str);
    }

    public void setPreRelease(boolean z) {
        this.dictionary.setBoolean(COSName.PRE_RELEASE, z);
    }

    public void setRevision(long j) {
        this.dictionary.setLong(COSName.R, j);
    }

    public void setTrustedMode(boolean z) {
        this.dictionary.setBoolean(COSName.TRUSTED_MODE, z);
    }

    public PDPropBuildDataDict(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }
}
