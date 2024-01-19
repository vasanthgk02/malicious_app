package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import java.util.Iterator;

public class PDOutlineItemIterator implements Iterator<PDOutlineItem> {
    public PDOutlineItem currentItem;
    public final PDOutlineItem startingItem;

    public PDOutlineItemIterator(PDOutlineItem pDOutlineItem) {
        this.startingItem = pDOutlineItem;
    }

    public boolean hasNext() {
        if (this.startingItem != null) {
            PDOutlineItem pDOutlineItem = this.currentItem;
            if (pDOutlineItem == null || (pDOutlineItem.getNextSibling() != null && !this.startingItem.equals(this.currentItem.getNextSibling()))) {
                return true;
            }
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public PDOutlineItem next() {
        PDOutlineItem pDOutlineItem = this.currentItem;
        if (pDOutlineItem == null) {
            this.currentItem = this.startingItem;
        } else {
            this.currentItem = pDOutlineItem.getNextSibling();
        }
        return this.currentItem;
    }
}
