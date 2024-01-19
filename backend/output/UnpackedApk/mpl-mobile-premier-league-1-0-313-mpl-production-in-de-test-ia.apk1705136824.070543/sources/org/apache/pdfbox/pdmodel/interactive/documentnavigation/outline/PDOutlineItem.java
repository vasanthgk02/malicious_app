package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionFactory;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.apache.pdfbox.util.awt.AWTColor;

public final class PDOutlineItem extends PDOutlineNode {
    public static final int BOLD_FLAG = 2;
    public static final int ITALIC_FLAG = 1;

    public PDOutlineItem() {
    }

    public PDPage findDestinationPage(PDDocument pDDocument) throws IOException {
        PDPageDestination pDPageDestination;
        PDDestination destination = getDestination();
        if (destination == null) {
            PDAction action = getAction();
            if (!(action instanceof PDActionGoTo)) {
                return null;
            }
            destination = ((PDActionGoTo) action).getDestination();
        }
        if (destination instanceof PDNamedDestination) {
            PDNamedDestination pDNamedDestination = (PDNamedDestination) destination;
            PDDocumentNameDictionary names = pDDocument.getDocumentCatalog().getNames();
            if (names != null) {
                PDDestinationNameTreeNode dests = names.getDests();
                if (dests != null) {
                    pDPageDestination = (PDPageDestination) dests.getValue(pDNamedDestination.getNamedDestination());
                }
            }
            return null;
        } else if (destination instanceof PDPageDestination) {
            pDPageDestination = (PDPageDestination) destination;
        } else if (destination == null) {
            return null;
        } else {
            throw new IOException("Error: Unknown destination type " + destination);
        }
        PDPage page = pDPageDestination.getPage();
        if (page == null) {
            int pageNumber = pDPageDestination.getPageNumber();
            if (pageNumber != -1) {
                page = pDDocument.getPage(pageNumber - 1);
            }
        }
        return page;
    }

    public PDAction getAction() {
        return PDActionFactory.createAction((COSDictionary) getCOSDictionary().getDictionaryObject(COSName.A));
    }

    public PDDestination getDestination() throws IOException {
        return PDDestination.create(getCOSDictionary().getDictionaryObject(COSName.DEST));
    }

    public PDOutlineItem getNextSibling() {
        return getOutlineItem(COSName.NEXT);
    }

    public PDOutlineItem getPreviousSibling() {
        return getOutlineItem(COSName.PREV);
    }

    public PDStructureElement getStructureElement() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.SE);
        if (cOSDictionary != null) {
            return new PDStructureElement(cOSDictionary);
        }
        return null;
    }

    public PDColor getTextColor() {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(COSName.C);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.growToSize(3, new COSFloat(0.0f));
            getCOSDictionary().setItem(COSName.C, (COSBase) cOSArray);
        }
        return new PDColor(cOSArray, (PDColorSpace) PDDeviceRGB.INSTANCE);
    }

    public String getTitle() {
        return getCOSDictionary().getString(COSName.TITLE);
    }

    public void insertSiblingAfter(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        PDOutlineNode parent = getParent();
        pDOutlineItem.setParent(parent);
        PDOutlineItem nextSibling = getNextSibling();
        setNextSibling(pDOutlineItem);
        pDOutlineItem.setPreviousSibling(this);
        if (nextSibling != null) {
            pDOutlineItem.setNextSibling(nextSibling);
            nextSibling.setPreviousSibling(pDOutlineItem);
        } else if (parent != null) {
            getParent().setLastChild(pDOutlineItem);
        }
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public void insertSiblingBefore(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        PDOutlineNode parent = getParent();
        pDOutlineItem.setParent(parent);
        PDOutlineItem previousSibling = getPreviousSibling();
        setPreviousSibling(pDOutlineItem);
        pDOutlineItem.setNextSibling(this);
        if (previousSibling != null) {
            previousSibling.setNextSibling(pDOutlineItem);
            pDOutlineItem.setPreviousSibling(previousSibling);
        } else if (parent != null) {
            getParent().setFirstChild(pDOutlineItem);
        }
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public boolean isBold() {
        return getCOSDictionary().getFlag(COSName.F, 2);
    }

    public boolean isItalic() {
        return getCOSDictionary().getFlag(COSName.F, 1);
    }

    public void setAction(PDAction pDAction) {
        getCOSDictionary().setItem(COSName.A, (COSObjectable) pDAction);
    }

    public void setBold(boolean z) {
        getCOSDictionary().setFlag(COSName.F, 2, z);
    }

    public void setDestination(PDDestination pDDestination) {
        getCOSDictionary().setItem(COSName.DEST, (COSObjectable) pDDestination);
    }

    public void setItalic(boolean z) {
        getCOSDictionary().setFlag(COSName.F, 1, z);
    }

    public void setNextSibling(PDOutlineNode pDOutlineNode) {
        getCOSDictionary().setItem(COSName.NEXT, (COSObjectable) pDOutlineNode);
    }

    public void setPreviousSibling(PDOutlineNode pDOutlineNode) {
        getCOSDictionary().setItem(COSName.PREV, (COSObjectable) pDOutlineNode);
    }

    public void setStructuredElement(PDStructureElement pDStructureElement) {
        getCOSDictionary().setItem(COSName.SE, (COSObjectable) pDStructureElement);
    }

    public void setTextColor(PDColor pDColor) {
        getCOSDictionary().setItem(COSName.C, (COSBase) pDColor.toCOSArray());
    }

    public void setTitle(String str) {
        getCOSDictionary().setString(COSName.TITLE, str);
    }

    public PDOutlineItem(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public void setDestination(PDPage pDPage) {
        PDPageXYZDestination pDPageXYZDestination;
        if (pDPage != null) {
            pDPageXYZDestination = new PDPageXYZDestination();
            pDPageXYZDestination.setPage(pDPage);
        } else {
            pDPageXYZDestination = null;
        }
        setDestination((PDDestination) pDPageXYZDestination);
    }

    public void setTextColor(AWTColor aWTColor) {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) new COSFloat(((float) aWTColor.getRed()) / 255.0f));
        cOSArray.add((COSBase) new COSFloat(((float) aWTColor.getGreen()) / 255.0f));
        cOSArray.add((COSBase) new COSFloat(((float) aWTColor.getBlue()) / 255.0f));
        getCOSDictionary().setItem(COSName.C, (COSBase) cOSArray);
    }
}
