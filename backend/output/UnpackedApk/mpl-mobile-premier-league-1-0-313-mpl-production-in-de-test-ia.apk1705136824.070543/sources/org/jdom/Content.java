package org.jdom;

import java.io.Serializable;

public abstract class Content implements Cloneable, Serializable {
    public Parent parent = null;

    public Object clone() {
        try {
            Content content = (Content) super.clone();
            content.parent = null;
            return content;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public Parent getParent() {
        return this.parent;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
