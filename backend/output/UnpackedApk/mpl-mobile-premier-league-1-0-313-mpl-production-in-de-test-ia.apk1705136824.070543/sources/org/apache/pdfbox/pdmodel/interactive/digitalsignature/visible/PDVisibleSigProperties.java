package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import java.io.IOException;
import java.io.InputStream;

public class PDVisibleSigProperties {
    public int page;
    public PDVisibleSignDesigner pdVisibleSignature;
    public int preferredSize;
    public String signatureReason;
    public String signerLocation;
    public String signerName;
    public InputStream visibleSignature;
    public boolean visualSignEnabled;

    public void buildSignature() throws IOException {
        new PDFTemplateCreator(new PDVisibleSigBuilder());
    }

    public int getPage() {
        return this.page;
    }

    public PDVisibleSignDesigner getPdVisibleSignature() {
        return this.pdVisibleSignature;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }

    public String getSignatureReason() {
        return this.signatureReason;
    }

    public String getSignerLocation() {
        return this.signerLocation;
    }

    public String getSignerName() {
        return this.signerName;
    }

    public InputStream getVisibleSignature() {
        return this.visibleSignature;
    }

    public boolean isVisualSignEnabled() {
        return this.visualSignEnabled;
    }

    public PDVisibleSigProperties page(int i) {
        this.page = i;
        return this;
    }

    public PDVisibleSigProperties preferredSize(int i) {
        this.preferredSize = i;
        return this;
    }

    public PDVisibleSigProperties setPdVisibleSignature(PDVisibleSignDesigner pDVisibleSignDesigner) {
        this.pdVisibleSignature = pDVisibleSignDesigner;
        return this;
    }

    public void setVisibleSignature(InputStream inputStream) {
        this.visibleSignature = inputStream;
    }

    public PDVisibleSigProperties signatureReason(String str) {
        this.signatureReason = str;
        return this;
    }

    public PDVisibleSigProperties signerLocation(String str) {
        this.signerLocation = str;
        return this;
    }

    public PDVisibleSigProperties signerName(String str) {
        this.signerName = str;
        return this;
    }

    public PDVisibleSigProperties visualSignEnabled(boolean z) {
        this.visualSignEnabled = z;
        return this;
    }
}
