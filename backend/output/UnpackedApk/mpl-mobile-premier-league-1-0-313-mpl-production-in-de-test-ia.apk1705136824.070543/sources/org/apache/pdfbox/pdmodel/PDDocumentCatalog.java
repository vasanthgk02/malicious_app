package org.apache.pdfbox.pdmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDDocumentCatalogAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDURIDictionary;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThread;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;

public class PDDocumentCatalog implements COSObjectable {
    public PDAcroForm cachedAcroForm;
    public final PDDocument document;
    public final COSDictionary root;

    public PDDocumentCatalog(PDDocument pDDocument) {
        this.document = pDDocument;
        COSDictionary cOSDictionary = new COSDictionary();
        this.root = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.CATALOG);
        this.document.getDocument().getTrailer().setItem(COSName.ROOT, (COSBase) this.root);
    }

    public void addOutputIntent(PDOutputIntent pDOutputIntent) {
        COSArray cOSArray = (COSArray) this.root.getDictionaryObject(COSName.OUTPUT_INTENTS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            this.root.setItem(COSName.OUTPUT_INTENTS, (COSBase) cOSArray);
        }
        cOSArray.add(pDOutputIntent.getCOSObject());
    }

    public PDAcroForm getAcroForm() {
        PDAcroForm pDAcroForm;
        if (this.cachedAcroForm == null) {
            COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.ACRO_FORM);
            if (cOSDictionary == null) {
                pDAcroForm = null;
            } else {
                pDAcroForm = new PDAcroForm(this.document, cOSDictionary);
            }
            this.cachedAcroForm = pDAcroForm;
        }
        return this.cachedAcroForm;
    }

    public PDDocumentCatalogAdditionalActions getActions() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.AA);
        if (cOSDictionary == null) {
            cOSDictionary = new COSDictionary();
            this.root.setItem(COSName.AA, (COSBase) cOSDictionary);
        }
        return new PDDocumentCatalogAdditionalActions(cOSDictionary);
    }

    public PDDocumentOutline getDocumentOutline() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.OUTLINES);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDDocumentOutline(cOSDictionary);
    }

    public String getLanguage() {
        return this.root.getString(COSName.LANG);
    }

    public PDMarkInfo getMarkInfo() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.MARK_INFO);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDMarkInfo(cOSDictionary);
    }

    public PDMetadata getMetadata() {
        COSBase dictionaryObject = this.root.getDictionaryObject(COSName.METADATA);
        if (dictionaryObject instanceof COSStream) {
            return new PDMetadata((COSStream) dictionaryObject);
        }
        return null;
    }

    public PDDocumentNameDictionary getNames() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.NAMES);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDDocumentNameDictionary(this, cOSDictionary);
    }

    public PDOptionalContentProperties getOCProperties() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.OCPROPERTIES);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDOptionalContentProperties(cOSDictionary);
    }

    public PDDestinationOrAction getOpenAction() throws IOException {
        COSBase dictionaryObject = this.root.getDictionaryObject(COSName.OPEN_ACTION);
        if (dictionaryObject == null) {
            return null;
        }
        if (dictionaryObject instanceof COSDictionary) {
            return PDActionFactory.createAction((COSDictionary) dictionaryObject);
        }
        if (dictionaryObject instanceof COSArray) {
            return PDDestination.create(dictionaryObject);
        }
        throw new IOException("Unknown OpenAction " + dictionaryObject);
    }

    public List<PDOutputIntent> getOutputIntents() {
        ArrayList arrayList = new ArrayList();
        COSArray cOSArray = (COSArray) this.root.getDictionaryObject(COSName.OUTPUT_INTENTS);
        if (cOSArray != null) {
            Iterator<COSBase> it = cOSArray.iterator();
            while (it.hasNext()) {
                arrayList.add(new PDOutputIntent((COSDictionary) it.next()));
            }
        }
        return arrayList;
    }

    public PDPageLabels getPageLabels() throws IOException {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.PAGE_LABELS);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDPageLabels(this.document, cOSDictionary);
    }

    public PageLayout getPageLayout() {
        String nameAsString = this.root.getNameAsString(COSName.PAGE_LAYOUT);
        if (nameAsString != null) {
            return PageLayout.fromString(nameAsString);
        }
        return PageLayout.SINGLE_PAGE;
    }

    public PageMode getPageMode() {
        String nameAsString = this.root.getNameAsString(COSName.PAGE_MODE);
        if (nameAsString != null) {
            return PageMode.fromString(nameAsString);
        }
        return PageMode.USE_NONE;
    }

    public PDPageTree getPages() {
        return new PDPageTree((COSDictionary) this.root.getDictionaryObject(COSName.PAGES));
    }

    public PDStructureTreeRoot getStructureTreeRoot() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.STRUCT_TREE_ROOT);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDStructureTreeRoot(cOSDictionary);
    }

    public List<PDThread> getThreads() {
        COSArray cOSArray = (COSArray) this.root.getDictionaryObject(COSName.THREADS);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            this.root.setItem(COSName.THREADS, (COSBase) cOSArray);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cOSArray.size(); i++) {
            arrayList.add(new PDThread((COSDictionary) cOSArray.getObject(i)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public PDURIDictionary getURI() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.URI);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDURIDictionary(cOSDictionary);
    }

    public String getVersion() {
        return this.root.getNameAsString(COSName.VERSION);
    }

    public PDViewerPreferences getViewerPreferences() {
        COSDictionary cOSDictionary = (COSDictionary) this.root.getDictionaryObject(COSName.VIEWER_PREFERENCES);
        if (cOSDictionary == null) {
            return null;
        }
        return new PDViewerPreferences(cOSDictionary);
    }

    public void setAcroForm(PDAcroForm pDAcroForm) {
        this.root.setItem(COSName.ACRO_FORM, (COSObjectable) pDAcroForm);
        this.cachedAcroForm = null;
    }

    public void setActions(PDDocumentCatalogAdditionalActions pDDocumentCatalogAdditionalActions) {
        this.root.setItem(COSName.AA, (COSObjectable) pDDocumentCatalogAdditionalActions);
    }

    public void setDocumentOutline(PDDocumentOutline pDDocumentOutline) {
        this.root.setItem(COSName.OUTLINES, (COSObjectable) pDDocumentOutline);
    }

    public void setLanguage(String str) {
        this.root.setString(COSName.LANG, str);
    }

    public void setMarkInfo(PDMarkInfo pDMarkInfo) {
        this.root.setItem(COSName.MARK_INFO, (COSObjectable) pDMarkInfo);
    }

    public void setMetadata(PDMetadata pDMetadata) {
        this.root.setItem(COSName.METADATA, (COSObjectable) pDMetadata);
    }

    public void setNames(PDDocumentNameDictionary pDDocumentNameDictionary) {
        this.root.setItem(COSName.NAMES, (COSObjectable) pDDocumentNameDictionary);
    }

    public void setOCProperties(PDOptionalContentProperties pDOptionalContentProperties) {
        this.root.setItem(COSName.OCPROPERTIES, (COSObjectable) pDOptionalContentProperties);
        if (pDOptionalContentProperties != null && ((double) this.document.getVersion()) < 1.5d) {
            this.document.setVersion(1.5f);
        }
    }

    public void setOpenAction(PDDestinationOrAction pDDestinationOrAction) {
        this.root.setItem(COSName.OPEN_ACTION, (COSObjectable) pDDestinationOrAction);
    }

    public void setOutputIntents(List<PDOutputIntent> list) {
        COSArray cOSArray = new COSArray();
        for (PDOutputIntent cOSObject : list) {
            cOSArray.add(cOSObject.getCOSObject());
        }
        this.root.setItem(COSName.OUTPUT_INTENTS, (COSBase) cOSArray);
    }

    public void setPageLabels(PDPageLabels pDPageLabels) {
        this.root.setItem(COSName.PAGE_LABELS, (COSObjectable) pDPageLabels);
    }

    public void setPageLayout(PageLayout pageLayout) {
        this.root.setName(COSName.PAGE_LAYOUT, pageLayout.stringValue());
    }

    public void setPageMode(PageMode pageMode) {
        this.root.setName(COSName.PAGE_MODE, pageMode.stringValue());
    }

    public void setStructureTreeRoot(PDStructureTreeRoot pDStructureTreeRoot) {
        this.root.setItem(COSName.STRUCT_TREE_ROOT, (COSObjectable) pDStructureTreeRoot);
    }

    public void setThreads(List list) {
        this.root.setItem(COSName.THREADS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setURI(PDURIDictionary pDURIDictionary) {
        this.root.setItem(COSName.URI, (COSObjectable) pDURIDictionary);
    }

    public void setVersion(String str) {
        this.root.setName(COSName.VERSION, str);
    }

    public void setViewerPreferences(PDViewerPreferences pDViewerPreferences) {
        this.root.setItem(COSName.VIEWER_PREFERENCES, (COSObjectable) pDViewerPreferences);
    }

    public COSDictionary getCOSObject() {
        return this.root;
    }

    public PDDocumentCatalog(PDDocument pDDocument, COSDictionary cOSDictionary) {
        this.document = pDDocument;
        this.root = cOSDictionary;
    }
}
