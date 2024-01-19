package org.apache.pdfbox.cos;

import java.util.Calendar;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

/* compiled from: UnmodifibleCOSDictionary */
public final class UnmodifiableCOSDictionary extends COSDictionary {
    public UnmodifiableCOSDictionary(COSDictionary cOSDictionary) {
        this.items = cOSDictionary.items;
    }

    public void addAll(COSDictionary cOSDictionary) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void mergeInto(COSDictionary cOSDictionary) {
        throw new UnsupportedOperationException();
    }

    public void removeItem(COSName cOSName) {
        throw new UnsupportedOperationException();
    }

    public void setBoolean(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setDate(String str, Calendar calendar) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedDate(String str, String str2, Calendar calendar) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedInt(String str, String str2, int i) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedString(String str, String str2, String str3) {
        throw new UnsupportedOperationException();
    }

    public void setFloat(String str, float f2) {
        throw new UnsupportedOperationException();
    }

    public void setInt(String str, int i) {
        throw new UnsupportedOperationException();
    }

    public void setItem(COSName cOSName, COSBase cOSBase) {
        throw new UnsupportedOperationException();
    }

    public void setLong(String str, long j) {
        throw new UnsupportedOperationException();
    }

    public void setName(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public void setString(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public void setBoolean(COSName cOSName, boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setDate(COSName cOSName, Calendar calendar) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedDate(String str, COSName cOSName, Calendar calendar) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedInt(String str, COSName cOSName, int i) {
        throw new UnsupportedOperationException();
    }

    public void setEmbeddedString(String str, COSName cOSName, String str2) {
        throw new UnsupportedOperationException();
    }

    public void setFloat(COSName cOSName, float f2) {
        throw new UnsupportedOperationException();
    }

    public void setInt(COSName cOSName, int i) {
        throw new UnsupportedOperationException();
    }

    public void setItem(COSName cOSName, COSObjectable cOSObjectable) {
        throw new UnsupportedOperationException();
    }

    public void setLong(COSName cOSName, long j) {
        throw new UnsupportedOperationException();
    }

    public void setName(COSName cOSName, String str) {
        throw new UnsupportedOperationException();
    }

    public void setString(COSName cOSName, String str) {
        throw new UnsupportedOperationException();
    }

    public void setItem(String str, COSObjectable cOSObjectable) {
        throw new UnsupportedOperationException();
    }

    public void setItem(String str, COSBase cOSBase) {
        throw new UnsupportedOperationException();
    }
}
