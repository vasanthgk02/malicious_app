package org.apache.pdfbox.pdmodel.interactive.annotation;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;

public class PDAnnotationFileAttachment extends PDAnnotationMarkup {
    public static final String ATTACHMENT_NAME_GRAPH = "Graph";
    public static final String ATTACHMENT_NAME_PAPERCLIP = "Paperclip";
    public static final String ATTACHMENT_NAME_PUSH_PIN = "PushPin";
    public static final String ATTACHMENT_NAME_TAG = "Tag";
    public static final String SUB_TYPE = "FileAttachment";

    public PDAnnotationFileAttachment() {
        getDictionary().setItem(COSName.SUBTYPE, (COSBase) COSName.getPDFName("FileAttachment"));
    }

    public String getAttachmentName() {
        return getDictionary().getNameAsString((String) "Name", (String) ATTACHMENT_NAME_PUSH_PIN);
    }

    public PDFileSpecification getFile() throws IOException {
        return PDFileSpecification.createFS(getDictionary().getDictionaryObject((String) "FS"));
    }

    public void setAttachementName(String str) {
        getDictionary().setName((String) "Name", str);
    }

    public void setFile(PDFileSpecification pDFileSpecification) {
        getDictionary().setItem((String) "FS", (COSObjectable) pDFileSpecification);
    }

    public PDAnnotationFileAttachment(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
