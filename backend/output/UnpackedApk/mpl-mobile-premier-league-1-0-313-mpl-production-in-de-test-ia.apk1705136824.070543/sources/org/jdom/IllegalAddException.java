package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;

public class IllegalAddException extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalAddException(Element element, Attribute attribute, String str) {
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("The attribute \"");
        // outline71.append(attribute.getQualifiedName());
        // outline71.append("\" could not be added to the element \"");
        // outline71.append(element.getQualifiedName());
        // outline71.append("\": ");
        // outline71.append(str);
        super(outline71.toString());
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalAddException(Element element, String str) {
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("The element \"");
        // outline71.append(element.getQualifiedName());
        // outline71.append("\" could not be added as the root of the document: ");
        // outline71.append(str);
        super(outline71.toString());
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalAddException(Element element, Namespace namespace, String str) {
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("The namespace xmlns");
        // String str2 = namespace.prefix;
        // String str3 = InflateView.SETTER_EQUALS;
        // if (str2 != null && !str2.equals("")) {
            // StringBuffer outline712 = GeneratedOutlineSupport.outline71(":");
            // outline712.append(namespace.prefix);
            // outline712.append(str3);
            // str3 = outline712.toString();
        // }
        // outline71.append(str3);
        // outline71.append("\"");
        // outline71.append(namespace.uri);
        // outline71.append("\" could not be added as a namespace to \"");
        // outline71.append(element.getQualifiedName());
        // outline71.append("\": ");
        // outline71.append(str);
        super(outline71.toString());
    }

    public IllegalAddException(String str) {
        super(str);
    }
}
