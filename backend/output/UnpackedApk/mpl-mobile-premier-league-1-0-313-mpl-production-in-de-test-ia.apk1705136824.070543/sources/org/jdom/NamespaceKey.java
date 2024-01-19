package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class NamespaceKey {
    public int hash;
    public String prefix;
    public String uri;

    public NamespaceKey(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
        this.hash = str.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NamespaceKey)) {
            return false;
        }
        NamespaceKey namespaceKey = (NamespaceKey) obj;
        if (!this.prefix.equals(namespaceKey.prefix) || !this.uri.equals(namespaceKey.uri)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.hash;
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[NamespaceKey: prefix \"");
        outline71.append(this.prefix);
        outline71.append("\" is mapped to URI \"");
        outline71.append(this.uri);
        outline71.append("\"]");
        return outline71.toString();
    }

    public NamespaceKey(Namespace namespace) {
        String str = namespace.prefix;
        String str2 = namespace.uri;
        this.prefix = str;
        this.uri = str2;
        this.hash = str.hashCode();
    }
}
