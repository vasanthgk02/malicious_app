package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.cmap.CMapParser;

public class Attribute implements Serializable, Cloneable {
    public String name;
    public transient Namespace namespace;
    public Element parent;
    public String value;

    public Attribute() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.namespace.prefix);
        objectOutputStream.writeObject(this.namespace.uri);
    }

    public Object clone() {
        Attribute attribute;
        try {
            attribute = (Attribute) super.clone();
        } catch (CloneNotSupportedException unused) {
            attribute = null;
        }
        attribute.parent = null;
        return attribute;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public String getQualifiedName() {
        String str = this.namespace.prefix;
        if (str == null || "".equals(str)) {
            return this.name;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(':');
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[Attribute: ");
        outline71.append(getQualifiedName());
        outline71.append("=\"");
        outline71.append(this.value);
        outline71.append("\"");
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public Attribute(String str, String str2, int i, Namespace namespace2) {
        String checkXMLName = TypeUtilsKt.checkXMLName(str);
        if (checkXMLName == null) {
            if (str.indexOf(":") != -1) {
                checkXMLName = "Attribute names cannot contain colons";
            } else {
                checkXMLName = str.equals("xmlns") ? "An Attribute name may not be \"xmlns\"; use the Namespace class to manage namespaces" : null;
            }
        }
        if (checkXMLName == null) {
            this.name = str;
            String checkCharacterData = TypeUtilsKt.checkCharacterData(str2);
            if (checkCharacterData == null) {
                this.value = str2;
                if (i < 0 || i > 10) {
                    throw new IllegalDataException(String.valueOf(i), "attribute", "Illegal attribute type");
                }
                namespace2 = namespace2 == null ? Namespace.NO_NAMESPACE : namespace2;
                if (namespace2 == Namespace.NO_NAMESPACE || !"".equals(namespace2.prefix)) {
                    this.namespace = namespace2;
                    return;
                }
                throw new IllegalNameException("", "attribute namespace", "An attribute namespace without a prefix can only be the NO_NAMESPACE namespace");
            }
            throw new IllegalDataException(str2, "attribute", checkCharacterData);
        }
        throw new IllegalNameException(str, "attribute", checkXMLName);
    }
}
