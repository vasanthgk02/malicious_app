package org.jdom.filter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jdom.Element;
import org.jdom.Namespace;

public class ElementFilter extends AbstractFilter {
    public String name;
    public transient Namespace namespace;

    public ElementFilter() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Object readObject2 = objectInputStream.readObject();
        if (readObject != null) {
            this.namespace = Namespace.getNamespace((String) readObject, (String) readObject2);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Namespace namespace2 = this.namespace;
        if (namespace2 != null) {
            objectOutputStream.writeObject(namespace2.prefix);
            objectOutputStream.writeObject(this.namespace.uri);
            return;
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementFilter)) {
            return false;
        }
        ElementFilter elementFilter = (ElementFilter) obj;
        String str = this.name;
        if (str == null ? elementFilter.name != null : !str.equals(elementFilter.name)) {
            return false;
        }
        Namespace namespace2 = this.namespace;
        Namespace namespace3 = elementFilter.namespace;
        return namespace2 == null ? namespace3 == null : namespace2.equals(namespace3);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 29;
        Namespace namespace2 = this.namespace;
        if (namespace2 != null) {
            i = namespace2.hashCode();
        }
        return hashCode + i;
    }

    public boolean matches(Object obj) {
        if (obj instanceof Element) {
            Element element = (Element) obj;
            String str = this.name;
            if (str == null || str.equals(element.name)) {
                Namespace namespace2 = this.namespace;
                if (namespace2 == null || namespace2.equals(element.namespace)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ElementFilter(String str, Namespace namespace2) {
        this.name = str;
        this.namespace = namespace2;
    }
}
