package org.apache.pdfbox.pdmodel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDPageTree implements COSObjectable, Iterable<PDPage> {
    public final COSDictionary root;

    public final class PageIterator implements Iterator<PDPage> {
        public final Queue<COSDictionary> queue;

        private void enqueueKids(COSDictionary cOSDictionary) {
            if (PDPageTree.this.isPageTreeNode(cOSDictionary)) {
                for (COSDictionary enqueueKids : PDPageTree.this.getKids(cOSDictionary)) {
                    enqueueKids(enqueueKids);
                }
                return;
            }
            this.queue.add(cOSDictionary);
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public PageIterator(COSDictionary cOSDictionary) {
            this.queue = new ArrayDeque();
            enqueueKids(cOSDictionary);
        }

        public PDPage next() {
            COSDictionary poll = this.queue.poll();
            if (poll.getCOSName(COSName.TYPE) == COSName.PAGE) {
                return new PDPage(poll);
            }
            throw new IllegalStateException("Expected Page but got " + poll);
        }
    }

    public PDPageTree() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.root = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.PAGES);
        this.root.setItem(COSName.KIDS, (COSBase) new COSArray());
        this.root.setItem(COSName.COUNT, (COSBase) COSInteger.ZERO);
    }

    public static COSBase getInheritableAttribute(COSDictionary cOSDictionary, COSName cOSName) {
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(cOSName);
        if (dictionaryObject != null) {
            return dictionaryObject;
        }
        COSDictionary cOSDictionary2 = (COSDictionary) cOSDictionary.getDictionaryObject(COSName.PARENT, COSName.P);
        if (cOSDictionary2 != null) {
            return getInheritableAttribute(cOSDictionary2, cOSName);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public List<COSDictionary> getKids(COSDictionary cOSDictionary) {
        ArrayList arrayList = new ArrayList();
        COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(COSName.KIDS);
        if (cOSArray == null) {
            return arrayList;
        }
        int size = cOSArray.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((COSDictionary) cOSArray.getObject(i));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean isPageTreeNode(COSDictionary cOSDictionary) {
        return cOSDictionary.getCOSName(COSName.TYPE) == COSName.PAGES || cOSDictionary.containsKey(COSName.KIDS);
    }

    public void add(PDPage pDPage) {
        COSDictionary cOSObject = pDPage.getCOSObject();
        cOSObject.setItem(COSName.PARENT, (COSBase) this.root);
        ((COSArray) this.root.getDictionaryObject(COSName.KIDS)).add((COSBase) cOSObject);
        do {
            cOSObject = (COSDictionary) cOSObject.getDictionaryObject(COSName.PARENT, COSName.P);
            if (cOSObject != null) {
                COSName cOSName = COSName.COUNT;
                cOSObject.setInt(cOSName, cOSObject.getInt(cOSName) + 1);
                continue;
            }
        } while (cOSObject != null);
    }

    public PDPage get(int i) {
        COSDictionary cOSDictionary = get(i + 1, this.root, 0);
        if (cOSDictionary.getCOSName(COSName.TYPE) == COSName.PAGE) {
            return new PDPage(cOSDictionary);
        }
        throw new IllegalStateException("Expected Page but got " + cOSDictionary);
    }

    public int getCount() {
        return this.root.getInt(COSName.COUNT, 0);
    }

    public int indexOf(PDPage pDPage) {
        COSDictionary cOSObject = pDPage.getCOSObject();
        int i = 0;
        do {
            if (isPageTreeNode(cOSObject)) {
                Iterator<COSDictionary> it = getKids(cOSObject).iterator();
                while (it.hasNext() && it.next() != cOSObject) {
                    i++;
                }
            } else {
                i++;
            }
            cOSObject = (COSDictionary) cOSObject.getDictionaryObject(COSName.PARENT, COSName.P);
        } while (cOSObject != null);
        return i - 1;
    }

    public Iterator<PDPage> iterator() {
        return new PageIterator(this.root);
    }

    public void remove(int i) {
        remove(get(i + 1, this.root, 0));
    }

    public COSDictionary getCOSObject() {
        return this.root;
    }

    public void remove(PDPage pDPage) {
        remove(pDPage.getCOSObject());
    }

    private void remove(COSDictionary cOSDictionary) {
        if (((COSArray) ((COSDictionary) cOSDictionary.getDictionaryObject(COSName.PARENT, COSName.P)).getDictionaryObject(COSName.KIDS)).removeObject(cOSDictionary)) {
            do {
                cOSDictionary = (COSDictionary) cOSDictionary.getDictionaryObject(COSName.PARENT, COSName.P);
                if (cOSDictionary != null) {
                    COSName cOSName = COSName.COUNT;
                    cOSDictionary.setInt(cOSName, cOSDictionary.getInt(cOSName) - 1);
                    continue;
                }
            } while (cOSDictionary != null);
        }
    }

    private COSDictionary get(int i, COSDictionary cOSDictionary, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Index out of bounds: ", i));
        } else if (isPageTreeNode(cOSDictionary)) {
            if (i <= cOSDictionary.getInt(COSName.COUNT, 0) + i2) {
                for (COSDictionary next : getKids(cOSDictionary)) {
                    if (isPageTreeNode(next)) {
                        int i3 = next.getInt(COSName.COUNT, 0) + i2;
                        if (i <= i3) {
                            return get(i, next, i2);
                        }
                        i2 = i3;
                    } else {
                        i2++;
                        if (i == i2) {
                            return get(i, next, i2);
                        }
                    }
                }
                throw new IllegalStateException();
            }
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Index out of bounds: ", i));
        } else if (i2 == i) {
            return cOSDictionary;
        } else {
            throw new IllegalStateException();
        }
    }

    public PDPageTree(COSDictionary cOSDictionary) {
        if (cOSDictionary != null) {
            this.root = cOSDictionary;
            return;
        }
        throw new IllegalArgumentException("root cannot be null");
    }
}
