package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfwriter.COSFilterInputStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDSignature implements COSObjectable {
    public static final COSName FILTER_ADOBE_PPKLITE = COSName.ADOBE_PPKLITE;
    public static final COSName FILTER_CICI_SIGNIT = COSName.CICI_SIGNIT;
    public static final COSName FILTER_ENTRUST_PPKEF = COSName.ENTRUST_PPKEF;
    public static final COSName FILTER_VERISIGN_PPKVS = COSName.VERISIGN_PPKVS;
    public static final COSName SUBFILTER_ADBE_PKCS7_DETACHED = COSName.ADBE_PKCS7_DETACHED;
    public static final COSName SUBFILTER_ADBE_PKCS7_SHA1 = COSName.ADBE_PKCS7_SHA1;
    public static final COSName SUBFILTER_ADBE_X509_RSA_SHA1 = COSName.ADBE_X509_RSA_SHA1;
    public static final COSName SUBFILTER_ETSI_CADES_DETACHED = COSName.getPDFName("ETSI.CAdES.detached");
    public final COSDictionary dictionary;

    public PDSignature() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.SIG);
    }

    public int[] getByteRange() {
        COSArray cOSArray = (COSArray) this.dictionary.getDictionaryObject(COSName.BYTERANGE);
        int size = cOSArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = cOSArray.getInt(i);
        }
        return iArr;
    }

    public COSBase getCOSObject() {
        return getDictionary();
    }

    public String getContactInfo() {
        return this.dictionary.getString(COSName.CONTACT_INFO);
    }

    public byte[] getContents(InputStream inputStream) throws IOException {
        int[] byteRange = getByteRange();
        int i = byteRange[0] + byteRange[1] + 1;
        return getContents(new COSFilterInputStream(inputStream, new int[]{i, byteRange[2] - i}));
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public String getFilter() {
        return this.dictionary.getNameAsString(COSName.FILTER);
    }

    public String getLocation() {
        return this.dictionary.getString(COSName.LOCATION);
    }

    public String getName() {
        return this.dictionary.getString(COSName.NAME);
    }

    public PDPropBuild getPropBuild() {
        COSDictionary cOSDictionary = (COSDictionary) this.dictionary.getDictionaryObject(COSName.PROP_BUILD);
        if (cOSDictionary != null) {
            return new PDPropBuild(cOSDictionary);
        }
        return null;
    }

    public String getReason() {
        return this.dictionary.getString(COSName.REASON);
    }

    public Calendar getSignDate() {
        return this.dictionary.getDate(COSName.M);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getSignedContent(java.io.InputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            org.apache.pdfbox.pdfwriter.COSFilterInputStream r1 = new org.apache.pdfbox.pdfwriter.COSFilterInputStream     // Catch:{ all -> 0x0015 }
            int[] r2 = r3.getByteRange()     // Catch:{ all -> 0x0015 }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x0015 }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0012 }
            r1.close()
            return r4
        L_0x0012:
            r4 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r4 = move-exception
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature.getSignedContent(java.io.InputStream):byte[]");
    }

    public String getSubFilter() {
        return this.dictionary.getNameAsString(COSName.SUB_FILTER);
    }

    public void setByteRange(int[] iArr) {
        if (iArr.length == 4) {
            COSArray cOSArray = new COSArray();
            for (int i : iArr) {
                cOSArray.add((COSBase) COSInteger.get((long) i));
            }
            this.dictionary.setItem(COSName.BYTERANGE, (COSBase) cOSArray);
        }
    }

    public void setContactInfo(String str) {
        this.dictionary.setString(COSName.CONTACT_INFO, str);
    }

    public void setContents(byte[] bArr) {
        COSString cOSString = new COSString(bArr);
        cOSString.setForceHexForm(true);
        this.dictionary.setItem(COSName.CONTENTS, (COSBase) cOSString);
    }

    public void setFilter(COSName cOSName) {
        this.dictionary.setItem(COSName.FILTER, (COSBase) cOSName);
    }

    public void setLocation(String str) {
        this.dictionary.setString(COSName.LOCATION, str);
    }

    public void setName(String str) {
        this.dictionary.setString(COSName.NAME, str);
    }

    public void setPropBuild(PDPropBuild pDPropBuild) {
        this.dictionary.setItem(COSName.PROP_BUILD, (COSObjectable) pDPropBuild);
    }

    public void setReason(String str) {
        this.dictionary.setString(COSName.REASON, str);
    }

    public void setSignDate(Calendar calendar) {
        this.dictionary.setDate(COSName.M, calendar);
    }

    public void setSubFilter(COSName cOSName) {
        this.dictionary.setItem(COSName.SUB_FILTER, (COSBase) cOSName);
    }

    public void setType(COSName cOSName) {
        this.dictionary.setItem(COSName.TYPE, (COSBase) cOSName);
    }

    public PDSignature(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }

    public byte[] getContents(byte[] bArr) throws IOException {
        int[] byteRange = getByteRange();
        int i = byteRange[0] + byteRange[1] + 1;
        return getContents(new COSFilterInputStream(bArr, new int[]{i, byteRange[2] - i}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getSignedContent(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            org.apache.pdfbox.pdfwriter.COSFilterInputStream r1 = new org.apache.pdfbox.pdfwriter.COSFilterInputStream     // Catch:{ all -> 0x0015 }
            int[] r2 = r3.getByteRange()     // Catch:{ all -> 0x0015 }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x0015 }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0012 }
            r1.close()
            return r4
        L_0x0012:
            r4 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r4 = move-exception
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature.getSignedContent(byte[]):byte[]");
    }

    private byte[] getContents(COSFilterInputStream cOSFilterInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = cOSFilterInputStream.read(bArr);
            if (read == -1) {
                cOSFilterInputStream.close();
                return COSString.parseHex(byteArrayOutputStream.toString()).getBytes();
            } else if (bArr[0] == 60 || bArr[0] == 40) {
                byteArrayOutputStream.write(bArr, 1, read);
            } else {
                int i = read - 1;
                if (bArr[i] == 62 || bArr[i] == 41) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        }
    }
}
