package org.apache.pdfbox.multipdf;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;

public class Splitter {
    public PDDocument currentDestinationDocument;
    public int currentPageNumber = 0;
    public List<PDDocument> destinationDocuments;
    public int endPage = Integer.MAX_VALUE;
    public PDDocument sourceDocument;
    public int splitLength = 1;
    public int startPage = LinearLayoutManager.INVALID_OFFSET;

    private void createNewDocumentIfNecessary() throws IOException {
        if (splitAtPage(this.currentPageNumber) || this.currentDestinationDocument == null) {
            PDDocument createNewDocument = createNewDocument();
            this.currentDestinationDocument = createNewDocument;
            this.destinationDocuments.add(createNewDocument);
        }
    }

    private void processAnnotations(PDPage pDPage) throws IOException {
        for (PDAnnotation next : pDPage.getAnnotations()) {
            if (next instanceof PDAnnotationLink) {
                PDAnnotationLink pDAnnotationLink = (PDAnnotationLink) next;
                PDDestination destination = pDAnnotationLink.getDestination();
                if (destination == null && pDAnnotationLink.getAction() != null) {
                    PDAction action = pDAnnotationLink.getAction();
                    if (action instanceof PDActionGoTo) {
                        destination = ((PDActionGoTo) action).getDestination();
                    }
                }
                if (destination instanceof PDPageDestination) {
                    ((PDPageDestination) destination).setPage(null);
                }
            } else {
                next.setPage(null);
            }
        }
    }

    private void processPages() throws IOException {
        for (int i = 0; i < this.sourceDocument.getNumberOfPages(); i++) {
            PDPage page = this.sourceDocument.getPage(i);
            int i2 = this.currentPageNumber;
            if (i2 + 1 < this.startPage || i2 + 1 > this.endPage) {
                int i3 = this.currentPageNumber;
                if (i3 <= this.endPage) {
                    this.currentPageNumber = i3 + 1;
                } else {
                    return;
                }
            } else {
                processPage(page);
                this.currentPageNumber++;
            }
        }
    }

    public PDDocument createNewDocument() throws IOException {
        PDDocument pDDocument = new PDDocument();
        pDDocument.getDocument().setVersion(getSourceDocument().getVersion());
        pDDocument.setDocumentInformation(getSourceDocument().getDocumentInformation());
        pDDocument.getDocumentCatalog().setViewerPreferences(getSourceDocument().getDocumentCatalog().getViewerPreferences());
        return pDDocument;
    }

    public final PDDocument getDestinationDocument() {
        return this.currentDestinationDocument;
    }

    public final PDDocument getSourceDocument() {
        return this.sourceDocument;
    }

    public void processPage(PDPage pDPage) throws IOException {
        createNewDocumentIfNecessary();
        PDPage importPage = getDestinationDocument().importPage(pDPage);
        importPage.setCropBox(pDPage.getCropBox());
        importPage.setMediaBox(pDPage.getMediaBox());
        importPage.setResources(pDPage.getResources());
        importPage.setRotation(pDPage.getRotation());
        processAnnotations(importPage);
    }

    public void setEndPage(int i) {
        if (i > 0) {
            this.endPage = i;
            return;
        }
        throw new RuntimeException("Error split must be at least one page.");
    }

    public void setSplitAtPage(int i) {
        if (i > 0) {
            this.splitLength = i;
            return;
        }
        throw new RuntimeException("Error split must be at least one page.");
    }

    public void setStartPage(int i) {
        if (i > 0) {
            this.startPage = i;
            return;
        }
        throw new RuntimeException("Error split must be at least one page.");
    }

    public List<PDDocument> split(PDDocument pDDocument) throws IOException {
        this.destinationDocuments = new ArrayList();
        this.sourceDocument = pDDocument;
        processPages();
        return this.destinationDocuments;
    }

    public boolean splitAtPage(int i) {
        return i % this.splitLength == 0;
    }
}
