package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class AttributeList extends AbstractList implements List, Serializable {
    public Attribute[] elementData;
    public Element parent;
    public int size;

    public AttributeList(Element element) {
        this.parent = element;
    }

    public boolean add(Object obj) {
        if (obj instanceof Attribute) {
            Attribute attribute = (Attribute) obj;
            int indexOfDuplicate = indexOfDuplicate(attribute);
            if (indexOfDuplicate < 0) {
                add(this.size, attribute);
            } else {
                set(indexOfDuplicate, attribute);
            }
            return true;
        } else if (obj == null) {
            throw new IllegalAddException("Cannot add null attribute");
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Class ");
            outline71.append(obj.getClass().getName());
            outline71.append(" is not an attribute");
            throw new IllegalAddException(outline71.toString());
        }
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
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.AttributeList.addAll(int, java.util.Collection):boolean");
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

    public final void ensureCapacity(int i) {
        Attribute[] attributeArr = this.elementData;
        if (attributeArr == null) {
            this.elementData = new Attribute[Math.max(i, 5)];
            return;
        }
        int length = attributeArr.length;
        if (i > length) {
            int outline8 = GeneratedOutlineSupport.outline8(length, 3, 2, 1);
            if (outline8 >= i) {
                i = outline8;
            }
            Attribute[] attributeArr2 = new Attribute[i];
            this.elementData = attributeArr2;
            System.arraycopy(attributeArr, 0, attributeArr2, 0, this.size);
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

    public final int indexOfDuplicate(Attribute attribute) {
        String str = attribute.name;
        String str2 = attribute.namespace.uri;
        if (this.elementData != null) {
            for (int i = 0; i < this.size; i++) {
                Attribute attribute2 = this.elementData[i];
                String str3 = attribute2.namespace.uri;
                String str4 = attribute2.name;
                if (str3.equals(str2) && str4.equals(str)) {
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
                Attribute[] attributeArr = this.elementData;
                Attribute attribute = attributeArr[i];
                attribute.parent = null;
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(attributeArr, i + 1, attributeArr, i, i3);
                }
                Attribute[] attributeArr2 = this.elementData;
                int i4 = this.size - 1;
                this.size = i4;
                attributeArr2[i4] = null;
                this.modCount++;
                return attribute;
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
        if (obj instanceof Attribute) {
            Attribute attribute = (Attribute) obj;
            int indexOfDuplicate = indexOfDuplicate(attribute);
            if (indexOfDuplicate < 0 || indexOfDuplicate == i) {
                return set(i, attribute);
            }
            throw new IllegalAddException("Cannot set duplicate attribute");
        } else if (obj == null) {
            throw new IllegalAddException("Cannot add null attribute");
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Class ");
            outline71.append(obj.getClass().getName());
            outline71.append(" is not an attribute");
            throw new IllegalAddException(outline71.toString());
        }
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return super.toString();
    }

    public Object set(int i, Attribute attribute) {
        if (i < 0 || i >= this.size) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index: ");
            stringBuffer.append(i);
            stringBuffer.append(" Size: ");
            stringBuffer.append(this.size);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (attribute.parent == null) {
            String checkNamespaceCollision = TypeUtilsKt.checkNamespaceCollision(attribute, this.parent);
            if (checkNamespaceCollision == null) {
                Attribute[] attributeArr = this.elementData;
                Attribute attribute2 = attributeArr[i];
                attribute2.parent = null;
                attributeArr[i] = attribute;
                attribute.parent = this.parent;
                return attribute2;
            }
            throw new IllegalAddException(this.parent, attribute, checkNamespaceCollision);
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("The attribute already has an existing parent \"");
            outline71.append(attribute.parent.getQualifiedName());
            outline71.append("\"");
            throw new IllegalAddException(outline71.toString());
        }
    }

    public void add(int i, Object obj) {
        if (obj instanceof Attribute) {
            Attribute attribute = (Attribute) obj;
            if (indexOfDuplicate(attribute) < 0) {
                add(i, attribute);
                this.modCount++;
                return;
            }
            throw new IllegalAddException("Cannot add duplicate attribute");
        } else if (obj == null) {
            throw new IllegalAddException("Cannot add null attribute");
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Class ");
            outline71.append(obj.getClass().getName());
            outline71.append(" is not an attribute");
            throw new IllegalAddException(outline71.toString());
        }
    }

    public boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }

    public void add(int i, Attribute attribute) {
        if (attribute.parent == null) {
            String checkNamespaceCollision = TypeUtilsKt.checkNamespaceCollision(attribute, this.parent);
            if (checkNamespaceCollision == null) {
                if (i >= 0) {
                    int i2 = this.size;
                    if (i <= i2) {
                        attribute.parent = this.parent;
                        ensureCapacity(i2 + 1);
                        int i3 = this.size;
                        if (i == i3) {
                            Attribute[] attributeArr = this.elementData;
                            this.size = i3 + 1;
                            attributeArr[i3] = attribute;
                        } else {
                            Attribute[] attributeArr2 = this.elementData;
                            System.arraycopy(attributeArr2, i, attributeArr2, i + 1, i3 - i);
                            this.elementData[i] = attribute;
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
            throw new IllegalAddException(this.parent, attribute, checkNamespaceCollision);
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("The attribute already has an existing parent \"");
        outline71.append(attribute.parent.getQualifiedName());
        outline71.append("\"");
        throw new IllegalAddException(outline71.toString());
    }
}
