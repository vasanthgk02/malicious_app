package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import java.util.Iterator;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;

public abstract class PDOutlineNode extends PDDictionaryWrapper {
    public PDOutlineNode() {
    }

    private void append(PDOutlineItem pDOutlineItem) {
        pDOutlineItem.setParent(this);
        if (!hasChildren()) {
            setFirstChild(pDOutlineItem);
        } else {
            PDOutlineItem lastChild = getLastChild();
            lastChild.setNextSibling(pDOutlineItem);
            pDOutlineItem.setPreviousSibling(lastChild);
        }
        setLastChild(pDOutlineItem);
    }

    private void prepend(PDOutlineItem pDOutlineItem) {
        pDOutlineItem.setParent(this);
        if (!hasChildren()) {
            setLastChild(pDOutlineItem);
        } else {
            PDOutlineItem firstChild = getFirstChild();
            pDOutlineItem.setNextSibling(firstChild);
            firstChild.setPreviousSibling(pDOutlineItem);
        }
        setFirstChild(pDOutlineItem);
    }

    private void switchNodeCount() {
        int i = -getOpenCount();
        setOpenCount(i);
        updateParentOpenCount(i);
    }

    public void addFirst(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        prepend(pDOutlineItem);
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public void addLast(PDOutlineItem pDOutlineItem) {
        requireSingleNode(pDOutlineItem);
        append(pDOutlineItem);
        updateParentOpenCountForAddedChild(pDOutlineItem);
    }

    public Iterable<PDOutlineItem> children() {
        return new Iterable<PDOutlineItem>() {
            public Iterator<PDOutlineItem> iterator() {
                return new PDOutlineItemIterator(PDOutlineNode.this.getFirstChild());
            }
        };
    }

    public void closeNode() {
        if (isNodeOpen()) {
            switchNodeCount();
        }
    }

    public PDOutlineItem getFirstChild() {
        return getOutlineItem(COSName.FIRST);
    }

    public PDOutlineItem getLastChild() {
        return getOutlineItem(COSName.LAST);
    }

    public int getOpenCount() {
        return getCOSDictionary().getInt(COSName.COUNT, 0);
    }

    public PDOutlineItem getOutlineItem(COSName cOSName) {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(cOSName);
        if (cOSDictionary != null) {
            return new PDOutlineItem(cOSDictionary);
        }
        return null;
    }

    public PDOutlineNode getParent() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.PARENT);
        if (cOSDictionary == null) {
            return null;
        }
        if (COSName.OUTLINES.equals(cOSDictionary.getCOSName(COSName.TYPE))) {
            return new PDDocumentOutline(cOSDictionary);
        }
        return new PDOutlineItem(cOSDictionary);
    }

    public boolean hasChildren() {
        return getFirstChild() != null;
    }

    public boolean isNodeOpen() {
        return getOpenCount() > 0;
    }

    public void openNode() {
        if (!isNodeOpen()) {
            switchNodeCount();
        }
    }

    public void requireSingleNode(PDOutlineItem pDOutlineItem) {
        if (pDOutlineItem.getNextSibling() != null || pDOutlineItem.getPreviousSibling() != null) {
            throw new IllegalArgumentException("A single node with no siblings is required");
        }
    }

    public void setFirstChild(PDOutlineNode pDOutlineNode) {
        getCOSDictionary().setItem(COSName.FIRST, (COSObjectable) pDOutlineNode);
    }

    public void setLastChild(PDOutlineNode pDOutlineNode) {
        getCOSDictionary().setItem(COSName.LAST, (COSObjectable) pDOutlineNode);
    }

    public void setOpenCount(int i) {
        getCOSDictionary().setInt(COSName.COUNT, i);
    }

    public void setParent(PDOutlineNode pDOutlineNode) {
        getCOSDictionary().setItem(COSName.PARENT, (COSObjectable) pDOutlineNode);
    }

    public void updateParentOpenCount(int i) {
        PDOutlineNode parent = getParent();
        if (parent == null) {
            return;
        }
        if (parent.isNodeOpen()) {
            parent.setOpenCount(parent.getOpenCount() + i);
            parent.updateParentOpenCount(i);
            return;
        }
        parent.setOpenCount(parent.getOpenCount() - i);
    }

    public void updateParentOpenCountForAddedChild(PDOutlineItem pDOutlineItem) {
        int i = 1;
        if (pDOutlineItem.isNodeOpen()) {
            i = 1 + pDOutlineItem.getOpenCount();
        }
        pDOutlineItem.updateParentOpenCount(i);
    }

    public PDOutlineNode(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
