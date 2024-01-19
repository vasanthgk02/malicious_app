package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class Document implements Parent {
    public ContentList content;

    public Document() {
        this.content = new ContentList(this);
    }

    public Object clone() {
        Document document;
        try {
            document = (Document) super.clone();
        } catch (CloneNotSupportedException unused) {
            document = null;
        }
        document.content = new ContentList(document);
        int i = 0;
        while (true) {
            ContentList contentList = this.content;
            if (i >= contentList.size) {
                return document;
            }
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                document.content.add((Element) ((Element) obj).clone());
            } else if (obj instanceof Comment) {
                document.content.add((Comment) ((Comment) obj).clone());
            } else if (obj instanceof ProcessingInstruction) {
                document.content.add((ProcessingInstruction) ((ProcessingInstruction) obj).clone());
            } else if (obj instanceof DocType) {
                document.content.add((DocType) ((DocType) obj).clone());
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public DocType getDocType() {
        int indexOfDocType = this.content.indexOfDocType();
        if (indexOfDocType < 0) {
            return null;
        }
        return (DocType) this.content.get(indexOfDocType);
    }

    public Parent getParent() {
        return null;
    }

    public Element getRootElement() {
        int indexOfFirstElement = this.content.indexOfFirstElement();
        if (indexOfFirstElement >= 0) {
            return (Element) this.content.get(indexOfFirstElement);
        }
        throw new IllegalStateException("Root element not set");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[Document: ");
        DocType docType = getDocType();
        if (docType != null) {
            outline71.append(docType.toString());
            outline71.append(", ");
        } else {
            outline71.append(" No DOCTYPE declaration, ");
        }
        Element rootElement = getRootElement();
        if (rootElement != null) {
            outline71.append("Root is ");
            outline71.append(rootElement.toString());
        } else {
            outline71.append(" No root element");
        }
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public Document(Element element) {
        ContentList contentList = new ContentList(this);
        this.content = contentList;
        if (element != null) {
            int indexOfFirstElement = contentList.indexOfFirstElement();
            if (indexOfFirstElement < 0) {
                this.content.add(element);
            } else {
                this.content.set(indexOfFirstElement, element);
            }
        }
    }
}
