package org.jdom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;
import org.jdom.ContentList.FilterList;
import org.jdom.ContentList.FilterListIterator;
import org.jdom.filter.ElementFilter;

public class Element extends Content implements Parent {
    public transient List additionalNamespaces;
    public AttributeList attributes = new AttributeList(this);
    public ContentList content = new ContentList(this);
    public String name;
    public transient Namespace namespace;

    public Element() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        int read = objectInputStream.read();
        if (read != 0) {
            this.additionalNamespaces = new ArrayList(read);
            for (int i = 0; i < read; i++) {
                this.additionalNamespaces.add(Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject()));
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.namespace.prefix);
        objectOutputStream.writeObject(this.namespace.uri);
        List list = this.additionalNamespaces;
        if (list == null) {
            objectOutputStream.write(0);
            return;
        }
        int size = list.size();
        objectOutputStream.write(size);
        for (int i = 0; i < size; i++) {
            Namespace namespace2 = (Namespace) this.additionalNamespaces.get(i);
            objectOutputStream.writeObject(namespace2.prefix);
            objectOutputStream.writeObject(namespace2.uri);
        }
    }

    public Object clone() {
        Element element = (Element) super.clone();
        element.content = new ContentList(element);
        element.attributes = new AttributeList(element);
        int i = 0;
        if (this.attributes != null) {
            int i2 = 0;
            while (true) {
                AttributeList attributeList = this.attributes;
                if (i2 >= attributeList.size) {
                    break;
                }
                element.attributes.add(((Attribute) attributeList.get(i2)).clone());
                i2++;
            }
        }
        if (this.additionalNamespaces != null) {
            element.additionalNamespaces = new ArrayList(this.additionalNamespaces);
        }
        if (this.content != null) {
            while (true) {
                ContentList contentList = this.content;
                if (i >= contentList.size) {
                    break;
                }
                element.content.add(((Content) contentList.get(i)).clone());
                i++;
            }
        }
        return element;
    }

    public Element getChild(String str) {
        Namespace namespace2 = Namespace.NO_NAMESPACE;
        ContentList contentList = this.content;
        ElementFilter elementFilter = new ElementFilter(str, namespace2);
        if (contentList != null) {
            FilterListIterator filterListIterator = (FilterListIterator) new FilterList(elementFilter).iterator();
            if (filterListIterator.hasNext()) {
                return (Element) filterListIterator.next();
            }
            return null;
        }
        throw null;
    }

    public String getQualifiedName() {
        if ("".equals(this.namespace.prefix)) {
            return this.name;
        }
        StringBuffer stringBuffer = new StringBuffer(this.namespace.prefix);
        stringBuffer.append(':');
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }

    public String getText() {
        ContentList contentList = this.content;
        int i = contentList.size;
        if (i == 0) {
            return "";
        }
        int i2 = 0;
        if (i == 1) {
            Object obj = contentList.get(0);
            if (obj instanceof Text) {
                return ((Text) obj).value;
            }
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (true) {
            ContentList contentList2 = this.content;
            if (i2 >= contentList2.size) {
                break;
            }
            Object obj2 = contentList2.get(i2);
            if (obj2 instanceof Text) {
                stringBuffer.append(((Text) obj2).value);
                z = true;
            }
            i2++;
        }
        if (!z) {
            return "";
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("[Element: <");
        stringBuffer.append(getQualifiedName());
        String str = this.namespace.uri;
        if (!"".equals(str)) {
            stringBuffer.append(" [Namespace: ");
            stringBuffer.append(str);
            stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
        }
        stringBuffer.append("/>]");
        return stringBuffer.toString();
    }

    public Element(String str, Namespace namespace2) {
        String checkXMLName = TypeUtilsKt.checkXMLName(str);
        checkXMLName = checkXMLName == null ? str.indexOf(":") != -1 ? "Element names cannot contain colons" : null : checkXMLName;
        if (checkXMLName == null) {
            this.name = str;
            this.namespace = namespace2 == null ? Namespace.NO_NAMESPACE : namespace2;
            return;
        }
        throw new IllegalNameException(str, "element", checkXMLName);
    }
}
