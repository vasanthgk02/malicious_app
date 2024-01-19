package org.apache.pdfbox.pdmodel.graphics.color;

import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;

public final class PDOutputIntent implements COSObjectable {
    public COSDictionary dictionary;

    public PDOutputIntent(PDDocument pDDocument, InputStream inputStream) throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.OUTPUT_INTENT);
        this.dictionary.setItem(COSName.S, (COSBase) COSName.GTS_PDFA1);
        this.dictionary.setItem(COSName.DEST_OUTPUT_PROFILE, (COSObjectable) configureOutputProfile(pDDocument, inputStream));
    }

    private PDStream configureOutputProfile(PDDocument pDDocument, InputStream inputStream) throws IOException {
        PDStream pDStream = new PDStream(pDDocument, inputStream, false);
        pDStream.getStream().setFilters(COSName.FLATE_DECODE);
        pDStream.getStream().setInt(COSName.LENGTH, pDStream.getByteArray().length);
        pDStream.getStream().setInt(COSName.N, 3);
        pDStream.addCompression();
        return pDStream;
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public COSStream getDestOutputIntent() {
        return (COSStream) this.dictionary.getItem(COSName.DEST_OUTPUT_PROFILE);
    }

    public String getInfo() {
        return this.dictionary.getString(COSName.INFO);
    }

    public String getOutputCondition() {
        return this.dictionary.getString(COSName.OUTPUT_CONDITION);
    }

    public String getOutputConditionIdentifier() {
        return this.dictionary.getString(COSName.OUTPUT_CONDITION_IDENTIFIER);
    }

    public String getRegistryName() {
        return this.dictionary.getString(COSName.REGISTRY_NAME);
    }

    public void setInfo(String str) {
        this.dictionary.setString(COSName.INFO, str);
    }

    public void setOutputCondition(String str) {
        this.dictionary.setString(COSName.OUTPUT_CONDITION, str);
    }

    public void setOutputConditionIdentifier(String str) {
        this.dictionary.setString(COSName.OUTPUT_CONDITION_IDENTIFIER, str);
    }

    public void setRegistryName(String str) {
        this.dictionary.setString(COSName.REGISTRY_NAME, str);
    }

    public PDOutputIntent(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
