package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDDocumentNameDictionary implements COSObjectable {
    public PDDocumentCatalog catalog;
    public COSDictionary nameDictionary;

    public PDDocumentNameDictionary(PDDocumentCatalog pDDocumentCatalog) {
        COSBase dictionaryObject = pDDocumentCatalog.getCOSObject().getDictionaryObject(COSName.NAMES);
        if (dictionaryObject != null) {
            this.nameDictionary = (COSDictionary) dictionaryObject;
        } else {
            this.nameDictionary = new COSDictionary();
            pDDocumentCatalog.getCOSObject().setItem(COSName.NAMES, (COSBase) this.nameDictionary);
        }
        this.catalog = pDDocumentCatalog;
    }

    public COSDictionary getCOSDictionary() {
        return this.nameDictionary;
    }

    public COSBase getCOSObject() {
        return this.nameDictionary;
    }

    public PDDestinationNameTreeNode getDests() {
        COSDictionary cOSDictionary = (COSDictionary) this.nameDictionary.getDictionaryObject(COSName.DESTS);
        if (cOSDictionary == null) {
            cOSDictionary = (COSDictionary) this.catalog.getCOSObject().getDictionaryObject(COSName.DESTS);
        }
        if (cOSDictionary != null) {
            return new PDDestinationNameTreeNode(cOSDictionary);
        }
        return null;
    }

    public PDEmbeddedFilesNameTreeNode getEmbeddedFiles() {
        COSDictionary cOSDictionary = (COSDictionary) this.nameDictionary.getDictionaryObject(COSName.EMBEDDED_FILES);
        if (cOSDictionary != null) {
            return new PDEmbeddedFilesNameTreeNode(cOSDictionary);
        }
        return null;
    }

    public PDJavascriptNameTreeNode getJavaScript() {
        COSDictionary cOSDictionary = (COSDictionary) this.nameDictionary.getDictionaryObject(COSName.JAVA_SCRIPT);
        if (cOSDictionary != null) {
            return new PDJavascriptNameTreeNode(cOSDictionary);
        }
        return null;
    }

    public void setDests(PDDestinationNameTreeNode pDDestinationNameTreeNode) {
        this.nameDictionary.setItem(COSName.DESTS, (COSObjectable) pDDestinationNameTreeNode);
        this.catalog.getCOSObject().setItem(COSName.DESTS, (COSObjectable) null);
    }

    public void setEmbeddedFiles(PDEmbeddedFilesNameTreeNode pDEmbeddedFilesNameTreeNode) {
        this.nameDictionary.setItem(COSName.EMBEDDED_FILES, (COSObjectable) pDEmbeddedFilesNameTreeNode);
    }

    public void setJavascript(PDJavascriptNameTreeNode pDJavascriptNameTreeNode) {
        this.nameDictionary.setItem(COSName.JAVA_SCRIPT, (COSObjectable) pDJavascriptNameTreeNode);
    }

    public PDDocumentNameDictionary(PDDocumentCatalog pDDocumentCatalog, COSDictionary cOSDictionary) {
        this.catalog = pDDocumentCatalog;
        this.nameDictionary = cOSDictionary;
    }
}
