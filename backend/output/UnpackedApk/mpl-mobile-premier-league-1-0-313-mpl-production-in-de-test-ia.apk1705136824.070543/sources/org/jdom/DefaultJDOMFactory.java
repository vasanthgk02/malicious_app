package org.jdom;

public class DefaultJDOMFactory {
    public void addContent(Parent parent, Content content) {
        if (parent instanceof Document) {
            ((Document) parent).content.add(content);
        } else {
            ((Element) parent).content.add(content);
        }
    }
}
