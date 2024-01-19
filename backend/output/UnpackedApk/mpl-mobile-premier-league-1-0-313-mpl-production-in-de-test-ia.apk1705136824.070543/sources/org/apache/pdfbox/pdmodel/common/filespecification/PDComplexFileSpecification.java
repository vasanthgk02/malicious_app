package org.apache.pdfbox.pdmodel.common.filespecification;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDComplexFileSpecification extends PDFileSpecification {
    public COSDictionary efDictionary;
    public COSDictionary fs;

    public PDComplexFileSpecification() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.fs = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FILESPEC);
    }

    private COSDictionary getEFDictionary() {
        if (this.efDictionary == null) {
            COSDictionary cOSDictionary = this.fs;
            if (cOSDictionary != null) {
                this.efDictionary = (COSDictionary) cOSDictionary.getDictionaryObject(COSName.EF);
            }
        }
        return this.efDictionary;
    }

    private COSBase getObjectFromEFDictionary(COSName cOSName) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary != null) {
            return eFDictionary.getDictionaryObject(cOSName);
        }
        return null;
    }

    public COSDictionary getCOSDictionary() {
        return this.fs;
    }

    public COSBase getCOSObject() {
        return this.fs;
    }

    public PDEmbeddedFile getEmbeddedFile() {
        COSStream cOSStream = (COSStream) getObjectFromEFDictionary(COSName.F);
        if (cOSStream != null) {
            return new PDEmbeddedFile(cOSStream);
        }
        return null;
    }

    public PDEmbeddedFile getEmbeddedFileDos() {
        COSStream cOSStream = (COSStream) getObjectFromEFDictionary(COSName.DOS);
        if (cOSStream != null) {
            return new PDEmbeddedFile(cOSStream);
        }
        return null;
    }

    public PDEmbeddedFile getEmbeddedFileMac() {
        COSStream cOSStream = (COSStream) getObjectFromEFDictionary(COSName.MAC);
        if (cOSStream != null) {
            return new PDEmbeddedFile(cOSStream);
        }
        return null;
    }

    public PDEmbeddedFile getEmbeddedFileUnicode() {
        COSStream cOSStream = (COSStream) getObjectFromEFDictionary(COSName.UF);
        if (cOSStream != null) {
            return new PDEmbeddedFile(cOSStream);
        }
        return null;
    }

    public PDEmbeddedFile getEmbeddedFileUnix() {
        COSStream cOSStream = (COSStream) getObjectFromEFDictionary(COSName.UNIX);
        if (cOSStream != null) {
            return new PDEmbeddedFile(cOSStream);
        }
        return null;
    }

    public String getFile() {
        return this.fs.getString(COSName.F);
    }

    public String getFileDescription() {
        return this.fs.getString(COSName.DESC);
    }

    public String getFileDos() {
        return this.fs.getString(COSName.DOS);
    }

    public String getFileMac() {
        return this.fs.getString(COSName.MAC);
    }

    public String getFileUnicode() {
        return this.fs.getString(COSName.UF);
    }

    public String getFileUnix() {
        return this.fs.getString(COSName.UNIX);
    }

    public String getFilename() {
        String fileUnicode = getFileUnicode();
        if (fileUnicode == null) {
            fileUnicode = getFileDos();
        }
        if (fileUnicode == null) {
            fileUnicode = getFileMac();
        }
        if (fileUnicode == null) {
            fileUnicode = getFileUnix();
        }
        return fileUnicode == null ? getFile() : fileUnicode;
    }

    public boolean isVolatile() {
        return this.fs.getBoolean(COSName.V, false);
    }

    public void setEmbeddedFile(PDEmbeddedFile pDEmbeddedFile) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary == null && pDEmbeddedFile != null) {
            eFDictionary = new COSDictionary();
            this.fs.setItem(COSName.EF, (COSBase) eFDictionary);
        }
        if (eFDictionary != null) {
            eFDictionary.setItem(COSName.F, (COSObjectable) pDEmbeddedFile);
        }
    }

    public void setEmbeddedFileDos(PDEmbeddedFile pDEmbeddedFile) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary == null && pDEmbeddedFile != null) {
            eFDictionary = new COSDictionary();
            this.fs.setItem(COSName.EF, (COSBase) eFDictionary);
        }
        if (eFDictionary != null) {
            eFDictionary.setItem(COSName.DOS, (COSObjectable) pDEmbeddedFile);
        }
    }

    public void setEmbeddedFileMac(PDEmbeddedFile pDEmbeddedFile) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary == null && pDEmbeddedFile != null) {
            eFDictionary = new COSDictionary();
            this.fs.setItem(COSName.EF, (COSBase) eFDictionary);
        }
        if (eFDictionary != null) {
            eFDictionary.setItem(COSName.MAC, (COSObjectable) pDEmbeddedFile);
        }
    }

    public void setEmbeddedFileUnicode(PDEmbeddedFile pDEmbeddedFile) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary == null && pDEmbeddedFile != null) {
            eFDictionary = new COSDictionary();
            this.fs.setItem(COSName.EF, (COSBase) eFDictionary);
        }
        if (eFDictionary != null) {
            eFDictionary.setItem(COSName.UF, (COSObjectable) pDEmbeddedFile);
        }
    }

    public void setEmbeddedFileUnix(PDEmbeddedFile pDEmbeddedFile) {
        COSDictionary eFDictionary = getEFDictionary();
        if (eFDictionary == null && pDEmbeddedFile != null) {
            eFDictionary = new COSDictionary();
            this.fs.setItem(COSName.EF, (COSBase) eFDictionary);
        }
        if (eFDictionary != null) {
            eFDictionary.setItem(COSName.UNIX, (COSObjectable) pDEmbeddedFile);
        }
    }

    public void setFile(String str) {
        this.fs.setString(COSName.F, str);
    }

    public void setFileDescription(String str) {
        this.fs.setString(COSName.DESC, str);
    }

    public void setFileDos(String str) {
        this.fs.setString(COSName.DOS, str);
    }

    public void setFileMac(String str) {
        this.fs.setString(COSName.MAC, str);
    }

    public void setFileUnicode(String str) {
        this.fs.setString(COSName.UF, str);
    }

    public void setFileUnix(String str) {
        this.fs.setString(COSName.UNIX, str);
    }

    public void setVolatile(boolean z) {
        this.fs.setBoolean(COSName.V, z);
    }

    public PDComplexFileSpecification(COSDictionary cOSDictionary) {
        if (cOSDictionary == null) {
            COSDictionary cOSDictionary2 = new COSDictionary();
            this.fs = cOSDictionary2;
            cOSDictionary2.setItem(COSName.TYPE, (COSBase) COSName.FILESPEC);
            return;
        }
        this.fs = cOSDictionary;
    }
}
