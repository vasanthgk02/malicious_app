package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jdom.filter.AbstractFilter;

public final class ContentList extends AbstractList implements Serializable {
    public static final long serialVersionUID = 1;
    public Content[] elementData;
    public Parent parent;
    public int size;

    public class FilterList extends AbstractList implements Serializable {
        public int count = 0;
        public int expected = -1;
        public AbstractFilter filter;

        public FilterList(AbstractFilter abstractFilter) {
            this.filter = abstractFilter;
        }

        public void add(int i, Object obj) {
            if (this.filter.matches(obj)) {
                ContentList.this.add(getAdjustedIndex(i), obj);
                this.expected++;
                this.count++;
                return;
            }
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Filter won't allow the ");
            outline71.append(obj.getClass().getName());
            outline71.append(" '");
            outline71.append(obj);
            outline71.append("' to be added to the list");
            throw new IllegalAddException(outline71.toString());
        }

        public Object get(int i) {
            return ContentList.this.get(getAdjustedIndex(i));
        }

        public final int getAdjustedIndex(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ContentList contentList = ContentList.this;
                int i4 = contentList.size;
                if (i2 >= i4) {
                    return i == i3 ? i4 : i4 + 1;
                }
                if (this.filter.matches(contentList.elementData[i2])) {
                    if (i == i3) {
                        return i2;
                    }
                    i3++;
                }
                i2++;
            }
        }

        public Iterator iterator() {
            return new FilterListIterator(this.filter, 0);
        }

        public ListIterator listIterator() {
            return new FilterListIterator(this.filter, 0);
        }

        public Object remove(int i) {
            int adjustedIndex = getAdjustedIndex(i);
            Object obj = ContentList.this.get(adjustedIndex);
            if (this.filter.matches(obj)) {
                Object remove = ContentList.this.remove(adjustedIndex);
                this.expected++;
                this.count--;
                return remove;
            }
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Filter won't allow the ");
            outline71.append(obj.getClass().getName());
            outline71.append(" '");
            outline71.append(obj);
            outline71.append("' (index ");
            outline71.append(i);
            outline71.append(") to be removed");
            throw new IllegalAddException(outline71.toString());
        }

        public Object set(int i, Object obj) {
            if (this.filter.matches(obj)) {
                int adjustedIndex = getAdjustedIndex(i);
                Object obj2 = ContentList.this.get(adjustedIndex);
                if (this.filter.matches(obj2)) {
                    Object obj3 = ContentList.this.set(adjustedIndex, obj);
                    this.expected += 2;
                    return obj3;
                }
                StringBuffer outline71 = GeneratedOutlineSupport.outline71("Filter won't allow the ");
                outline71.append(obj2.getClass().getName());
                outline71.append(" '");
                outline71.append(obj2);
                outline71.append("' (index ");
                outline71.append(i);
                outline71.append(") to be removed");
                throw new IllegalAddException(outline71.toString());
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Filter won't allow index ");
            stringBuffer.append(i);
            stringBuffer.append(" to be set to ");
            stringBuffer.append(obj.getClass().getName());
            throw new IllegalAddException(stringBuffer.toString());
        }

        public int size() {
            if (this.expected == ContentList.access$000(ContentList.this)) {
                return this.count;
            }
            int i = 0;
            this.count = 0;
            while (true) {
                ContentList contentList = ContentList.this;
                if (i < contentList.size) {
                    if (this.filter.matches(contentList.elementData[i])) {
                        this.count++;
                    }
                    i++;
                } else {
                    this.expected = ContentList.access$000(contentList);
                    return this.count;
                }
            }
        }

        public ListIterator listIterator(int i) {
            return new FilterListIterator(this.filter, i);
        }
    }

    public class FilterListIterator implements ListIterator {
        public boolean canremove = false;
        public boolean canset = false;
        public int cursor = -1;
        public int expected = -1;
        public AbstractFilter filter;
        public boolean forward = false;
        public int fsize = 0;
        public int index = -1;
        public int tmpcursor = -1;

        public FilterListIterator(AbstractFilter abstractFilter, int i) {
            int i2;
            int i3 = 0;
            this.filter = abstractFilter;
            this.expected = ContentList.access$000(ContentList.this);
            this.forward = false;
            if (i >= 0) {
                this.fsize = 0;
                while (true) {
                    i2 = ContentList.this.size;
                    if (i3 >= i2) {
                        break;
                    }
                    if (abstractFilter.matches(ContentList.this.get(i3))) {
                        int i4 = this.fsize;
                        if (i == i4) {
                            this.cursor = i3;
                            this.index = i4;
                        }
                        this.fsize++;
                    }
                    i3++;
                }
                int i5 = this.fsize;
                if (i > i5) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Index: ");
                    stringBuffer.append(i);
                    stringBuffer.append(" Size: ");
                    stringBuffer.append(this.fsize);
                    throw new IndexOutOfBoundsException(stringBuffer.toString());
                } else if (this.cursor == -1) {
                    this.cursor = i2;
                    this.index = i5;
                }
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Index: ");
                stringBuffer2.append(i);
                throw new IndexOutOfBoundsException(stringBuffer2.toString());
            }
        }

        public void add(Object obj) {
            nextIndex();
            ContentList.this.add(this.tmpcursor, obj);
            this.forward = true;
            this.expected = ContentList.access$000(ContentList.this);
            this.canset = false;
            this.canremove = false;
            this.index = nextIndex();
            this.cursor = this.tmpcursor;
            this.fsize++;
        }

        public final void checkConcurrentModification() {
            if (this.expected != ContentList.access$000(ContentList.this)) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            return nextIndex() < this.fsize;
        }

        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        public Object next() {
            if (hasNext()) {
                this.index = nextIndex();
                int i = this.tmpcursor;
                this.cursor = i;
                this.forward = true;
                this.canremove = true;
                this.canset = true;
                return ContentList.this.get(i);
            }
            throw new NoSuchElementException("next() is beyond the end of the Iterator");
        }

        public int nextIndex() {
            ContentList contentList;
            checkConcurrentModification();
            if (this.forward) {
                int i = this.cursor;
                do {
                    i++;
                    contentList = ContentList.this;
                    int i2 = contentList.size;
                    if (i >= i2) {
                        this.tmpcursor = i2;
                        return this.index + 1;
                    }
                } while (!this.filter.matches(contentList.get(i)));
                this.tmpcursor = i;
                return this.index + 1;
            }
            this.tmpcursor = this.cursor;
            return this.index;
        }

        public Object previous() {
            if (hasPrevious()) {
                this.index = previousIndex();
                int i = this.tmpcursor;
                this.cursor = i;
                this.forward = false;
                this.canremove = true;
                this.canset = true;
                return ContentList.this.get(i);
            }
            throw new NoSuchElementException("previous() is before the start of the Iterator");
        }

        public int previousIndex() {
            checkConcurrentModification();
            if (!this.forward) {
                for (int i = this.cursor - 1; i >= 0; i--) {
                    if (this.filter.matches(ContentList.this.get(i))) {
                        this.tmpcursor = i;
                        return this.index - 1;
                    }
                }
                this.tmpcursor = -1;
                return this.index - 1;
            }
            this.tmpcursor = this.cursor;
            return this.index;
        }

        public void remove() {
            if (this.canremove) {
                nextIndex();
                ContentList.this.remove(this.cursor);
                this.cursor = this.tmpcursor - 1;
                this.expected = ContentList.access$000(ContentList.this);
                this.forward = false;
                this.canremove = false;
                this.canset = false;
                this.fsize--;
                return;
            }
            throw new IllegalStateException("Can not remove an element unless either next() or previous() has been called since the last remove()");
        }

        public void set(Object obj) {
            if (this.canset) {
                checkConcurrentModification();
                if (this.filter.matches(obj)) {
                    ContentList.this.set(this.cursor, obj);
                    this.expected = ContentList.access$000(ContentList.this);
                    return;
                }
                StringBuffer outline71 = GeneratedOutlineSupport.outline71("Filter won't allow index ");
                outline71.append(this.index);
                outline71.append(" to be set to ");
                outline71.append(obj.getClass().getName());
                throw new IllegalAddException(outline71.toString());
            }
            throw new IllegalStateException("Can not set an element unless either next() or previous() has been called since the last remove() or set()");
        }
    }

    public ContentList(Parent parent2) {
        this.parent = parent2;
    }

    public static int access$000(ContentList contentList) {
        return contentList.modCount;
    }

    public void add(int i, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                obj = new Text(obj.toString());
            }
            if (obj instanceof Content) {
                add(i, (Content) obj);
                return;
            }
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Class ");
            outline71.append(obj.getClass().getName());
            outline71.append(" is of unrecognized type and cannot be added");
            throw new IllegalAddException(outline71.toString());
        }
        throw new IllegalAddException("Cannot add null object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[LOOP:1: B:21:0x0037->B:22:0x0039, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean addAll(int r5, java.util.Collection<java.lang.Object> r6) {
        /*
            r4 = this;
            if (r5 < 0) goto L_0x0041
            int r0 = r4.size
            if (r5 > r0) goto L_0x0041
            r0 = 0
            if (r6 == 0) goto L_0x0040
            int r1 = r6.size()
            if (r1 != 0) goto L_0x0010
            goto L_0x0040
        L_0x0010:
            int r1 = r4.size
            int r2 = r6.size()
            int r2 = r2 + r1
            r4.ensureCapacity(r2)
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RuntimeException -> 0x0035 }
            r1 = 0
        L_0x001f:
            boolean r2 = r6.hasNext()     // Catch:{ RuntimeException -> 0x0033 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r6.next()     // Catch:{ RuntimeException -> 0x0033 }
            int r3 = r5 + r1
            r4.add(r3, r2)     // Catch:{ RuntimeException -> 0x0033 }
            int r1 = r1 + 1
            goto L_0x001f
        L_0x0031:
            r5 = 1
            return r5
        L_0x0033:
            r6 = move-exception
            goto L_0x0037
        L_0x0035:
            r6 = move-exception
            r1 = 0
        L_0x0037:
            if (r0 >= r1) goto L_0x003f
            r4.remove(r5)
            int r0 = r0 + 1
            goto L_0x0037
        L_0x003f:
            throw r6
        L_0x0040:
            return r0
        L_0x0041:
            java.lang.IndexOutOfBoundsException r6 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Index: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = " Size: "
            r0.append(r5)
            int r5 = r4.size
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.ContentList.addAll(int, java.util.Collection):boolean");
    }

    public void clear() {
        if (this.elementData != null) {
            for (int i = 0; i < this.size; i++) {
                this.elementData[i].parent = null;
            }
            this.elementData = null;
            this.size = 0;
        }
        this.modCount++;
    }

    public void ensureCapacity(int i) {
        Content[] contentArr = this.elementData;
        if (contentArr == null) {
            this.elementData = new Content[Math.max(i, 5)];
            return;
        }
        int length = contentArr.length;
        if (i > length) {
            int outline8 = GeneratedOutlineSupport.outline8(length, 3, 2, 1);
            if (outline8 >= i) {
                i = outline8;
            }
            Content[] contentArr2 = new Content[i];
            this.elementData = contentArr2;
            System.arraycopy(contentArr, 0, contentArr2, 0, this.size);
        }
    }

    public Object get(int i) {
        if (i >= 0 && i < this.size) {
            return this.elementData[i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Index: ");
        stringBuffer.append(i);
        stringBuffer.append(" Size: ");
        stringBuffer.append(this.size);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public int indexOfDocType() {
        if (this.elementData != null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i] instanceof DocType) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int indexOfFirstElement() {
        if (this.elementData != null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i] instanceof Element) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Object remove(int i) {
        if (i >= 0) {
            int i2 = this.size;
            if (i < i2) {
                Content[] contentArr = this.elementData;
                Content content = contentArr[i];
                content.parent = null;
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(contentArr, i + 1, contentArr, i, i3);
                }
                Content[] contentArr2 = this.elementData;
                int i4 = this.size - 1;
                this.size = i4;
                contentArr2[i4] = null;
                this.modCount++;
                return content;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Index: ");
        stringBuffer.append(i);
        stringBuffer.append(" Size: ");
        stringBuffer.append(this.size);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public Object set(int i, Object obj) {
        if (i < 0 || i >= this.size) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index: ");
            stringBuffer.append(i);
            stringBuffer.append(" Size: ");
            stringBuffer.append(this.size);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        if ((obj instanceof Element) && (this.parent instanceof Document)) {
            int indexOfFirstElement = indexOfFirstElement();
            if (indexOfFirstElement >= 0 && indexOfFirstElement != i) {
                throw new IllegalAddException("Cannot add a second root element, only one is allowed");
            }
        }
        if ((obj instanceof DocType) && (this.parent instanceof Document)) {
            int indexOfDocType = indexOfDocType();
            if (indexOfDocType >= 0 && indexOfDocType != i) {
                throw new IllegalAddException("Cannot add a second doctype, only one is allowed");
            }
        }
        Object remove = remove(i);
        try {
            add(i, obj);
            return remove;
        } catch (RuntimeException e2) {
            add(i, remove);
            throw e2;
        }
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return super.toString();
    }

    public void add(int i, Content content) {
        boolean z;
        if (this.parent instanceof Document) {
            if (content instanceof Element) {
                if (indexOfFirstElement() >= 0) {
                    throw new IllegalAddException("Cannot add a second root element, only one is allowed");
                } else if (indexOfDocType() > i) {
                    throw new IllegalAddException("A root element cannot be added before the DocType");
                }
            }
            if (content instanceof DocType) {
                if (indexOfDocType() < 0) {
                    int indexOfFirstElement = indexOfFirstElement();
                    if (indexOfFirstElement != -1 && indexOfFirstElement < i) {
                        throw new IllegalAddException("A DocType cannot be added after the root element");
                    }
                } else {
                    throw new IllegalAddException("Cannot add a second doctype, only one is allowed");
                }
            }
            if (content instanceof CDATA) {
                throw new IllegalAddException("A CDATA is not allowed at the document root");
            } else if (content instanceof Text) {
                throw new IllegalAddException("A Text is not allowed at the document root");
            } else if (content instanceof EntityRef) {
                throw new IllegalAddException("An EntityRef is not allowed at the document root");
            }
        } else if (content instanceof DocType) {
            throw new IllegalAddException("A DocType is not allowed except at the document level");
        }
        Parent parent2 = content.parent;
        if (parent2 == null) {
            Parent parent3 = this.parent;
            if (content != parent3) {
                if ((parent3 instanceof Element) && (content instanceof Element)) {
                    Element element = (Element) content;
                    Parent parent4 = ((Element) parent3).parent;
                    while (true) {
                        if (!(parent4 instanceof Element)) {
                            z = false;
                            break;
                        } else if (parent4 == element) {
                            z = true;
                            break;
                        } else {
                            parent4 = parent4.getParent();
                        }
                    }
                    if (z) {
                        throw new IllegalAddException("The Element cannot be added as a descendent of itself");
                    }
                }
                if (i >= 0) {
                    int i2 = this.size;
                    if (i <= i2) {
                        content.parent = this.parent;
                        ensureCapacity(i2 + 1);
                        int i3 = this.size;
                        if (i == i3) {
                            Content[] contentArr = this.elementData;
                            this.size = i3 + 1;
                            contentArr[i3] = content;
                        } else {
                            Content[] contentArr2 = this.elementData;
                            System.arraycopy(contentArr2, i, contentArr2, i + 1, i3 - i);
                            this.elementData[i] = content;
                            this.size++;
                        }
                        this.modCount++;
                        return;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Index: ");
                stringBuffer.append(i);
                stringBuffer.append(" Size: ");
                stringBuffer.append(this.size);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            }
            throw new IllegalAddException("The Element cannot be added to itself");
        } else if (parent2 instanceof Document) {
            throw new IllegalAddException((Element) content, "The Content already has an existing parent document");
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("The Content already has an existing parent \"");
            outline71.append(((Element) parent2).getQualifiedName());
            outline71.append("\"");
            throw new IllegalAddException(outline71.toString());
        }
    }

    public boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }
}
