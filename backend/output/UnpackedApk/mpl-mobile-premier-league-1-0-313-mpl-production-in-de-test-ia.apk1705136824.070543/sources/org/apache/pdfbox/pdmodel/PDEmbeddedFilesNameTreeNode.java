package org.apache.pdfbox.pdmodel;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;

public class PDEmbeddedFilesNameTreeNode extends PDNameTreeNode {
    public PDEmbeddedFilesNameTreeNode() {
        super(PDComplexFileSpecification.class);
    }

    public COSObjectable convertCOSToPD(COSBase cOSBase) throws IOException {
        return new PDComplexFileSpecification((COSDictionary) cOSBase);
    }

    public PDNameTreeNode createChildNode(COSDictionary cOSDictionary) {
        return new PDEmbeddedFilesNameTreeNode(cOSDictionary);
    }

    public PDEmbeddedFilesNameTreeNode(COSDictionary cOSDictionary) {
        super(cOSDictionary, PDComplexFileSpecification.class);
    }
}
