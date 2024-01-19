package org.jdom;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;

public final class Namespace {
    public static final Namespace NO_NAMESPACE = new Namespace("", "");
    public static final Namespace XML_NAMESPACE = new Namespace("xml", "http://www.w3.org/XML/1998/namespace");
    public static HashMap namespaces;
    public String prefix;
    public String uri;

    static {
        HashMap hashMap = new HashMap(16);
        namespaces = hashMap;
        hashMap.put(new NamespaceKey(NO_NAMESPACE), NO_NAMESPACE);
        namespaces.put(new NamespaceKey(XML_NAMESPACE), XML_NAMESPACE);
    }

    public Namespace(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jdom.Namespace getNamespace(java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x001d
            java.lang.String r1 = r11.trim()
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            if (r12 == 0) goto L_0x001b
            java.lang.String r1 = r12.trim()
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x002c
        L_0x001b:
            r12 = r0
            goto L_0x002c
        L_0x001d:
            if (r12 == 0) goto L_0x0120
            java.lang.String r11 = r12.trim()
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x002b
            goto L_0x0120
        L_0x002b:
            r11 = r0
        L_0x002c:
            org.jdom.NamespaceKey r1 = new org.jdom.NamespaceKey
            r1.<init>(r11, r12)
            java.util.HashMap r2 = namespaces
            java.lang.Object r2 = r2.get(r1)
            org.jdom.Namespace r2 = (org.jdom.Namespace) r2
            if (r2 == 0) goto L_0x003c
            return r2
        L_0x003c:
            boolean r2 = r11.equals(r0)
            java.lang.String r3 = "xml"
            r4 = 45
            r5 = 36
            r6 = 0
            r7 = 0
            if (r2 == 0) goto L_0x004c
            goto L_0x00ae
        L_0x004c:
            char r2 = r11.charAt(r7)
            boolean r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isXMLDigit(r2)
            if (r8 == 0) goto L_0x0059
            java.lang.String r2 = "Namespace prefixes cannot begin with a number"
            goto L_0x00af
        L_0x0059:
            if (r2 != r5) goto L_0x005e
            java.lang.String r2 = "Namespace prefixes cannot begin with a dollar sign ($)"
            goto L_0x00af
        L_0x005e:
            if (r2 != r4) goto L_0x0063
            java.lang.String r2 = "Namespace prefixes cannot begin with a hyphen (-)"
            goto L_0x00af
        L_0x0063:
            r8 = 46
            if (r2 != r8) goto L_0x006a
            java.lang.String r2 = "Namespace prefixes cannot begin with a period (.)"
            goto L_0x00af
        L_0x006a:
            java.lang.String r2 = r11.toLowerCase()
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x0077
            java.lang.String r2 = "Namespace prefixes cannot begin with \"xml\" in any combination of case"
            goto L_0x00af
        L_0x0077:
            int r2 = r11.length()
            r8 = 0
        L_0x007c:
            if (r8 >= r2) goto L_0x00a2
            char r9 = r11.charAt(r8)
            boolean r10 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isXMLNameCharacter(r9)
            if (r10 != 0) goto L_0x009f
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r8 = "Namespace prefixes cannot contain the character \""
            r2.append(r8)
            r2.append(r9)
            java.lang.String r8 = "\""
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            goto L_0x00af
        L_0x009f:
            int r8 = r8 + 1
            goto L_0x007c
        L_0x00a2:
            java.lang.String r2 = ":"
            int r2 = r11.indexOf(r2)
            r8 = -1
            if (r2 == r8) goto L_0x00ae
            java.lang.String r2 = "Namespace prefixes cannot contain colons"
            goto L_0x00af
        L_0x00ae:
            r2 = r6
        L_0x00af:
            java.lang.String r8 = "Namespace prefix"
            if (r2 != 0) goto L_0x011a
            boolean r2 = r12.equals(r0)
            if (r2 == 0) goto L_0x00ba
            goto L_0x00d0
        L_0x00ba:
            char r2 = r12.charAt(r7)
            boolean r7 = java.lang.Character.isDigit(r2)
            if (r7 == 0) goto L_0x00c7
            java.lang.String r6 = "Namespace URIs cannot begin with a number"
            goto L_0x00d0
        L_0x00c7:
            if (r2 != r5) goto L_0x00cc
            java.lang.String r6 = "Namespace URIs cannot begin with a dollar sign ($)"
            goto L_0x00d0
        L_0x00cc:
            if (r2 != r4) goto L_0x00d0
            java.lang.String r6 = "Namespace URIs cannot begin with a hyphen (-)"
        L_0x00d0:
            java.lang.String r2 = "Namespace URI"
            if (r6 != 0) goto L_0x0114
            boolean r4 = r11.equals(r0)
            if (r4 != 0) goto L_0x00eb
            boolean r4 = r12.equals(r0)
            if (r4 != 0) goto L_0x00e1
            goto L_0x00eb
        L_0x00e1:
            org.jdom.IllegalNameException r11 = new org.jdom.IllegalNameException
            java.lang.String r12 = "namespace"
            java.lang.String r1 = "Namespace URIs must be non-null and non-empty Strings"
            r11.<init>(r0, r12, r1)
            throw r11
        L_0x00eb:
            boolean r0 = r11.equals(r3)
            if (r0 != 0) goto L_0x010c
            java.lang.String r0 = "http://www.w3.org/XML/1998/namespace"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0104
            org.jdom.Namespace r0 = new org.jdom.Namespace
            r0.<init>(r11, r12)
            java.util.HashMap r11 = namespaces
            r11.put(r1, r0)
            return r0
        L_0x0104:
            org.jdom.IllegalNameException r11 = new org.jdom.IllegalNameException
            java.lang.String r0 = "The http://www.w3.org/XML/1998/namespace must be bound to the xml prefix."
            r11.<init>(r12, r2, r0)
            throw r11
        L_0x010c:
            org.jdom.IllegalNameException r12 = new org.jdom.IllegalNameException
            java.lang.String r0 = "The xml prefix can only be bound to http://www.w3.org/XML/1998/namespace"
            r12.<init>(r11, r8, r0)
            throw r12
        L_0x0114:
            org.jdom.IllegalNameException r11 = new org.jdom.IllegalNameException
            r11.<init>(r12, r2, r6)
            throw r11
        L_0x011a:
            org.jdom.IllegalNameException r12 = new org.jdom.IllegalNameException
            r12.<init>(r11, r8, r2)
            throw r12
        L_0x0120:
            org.jdom.Namespace r11 = NO_NAMESPACE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.Namespace.getNamespace(java.lang.String, java.lang.String):org.jdom.Namespace");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Namespace) {
            return this.uri.equals(((Namespace) obj).uri);
        }
        return false;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("[Namespace: prefix \"");
        outline71.append(this.prefix);
        outline71.append("\" is mapped to URI \"");
        outline71.append(this.uri);
        outline71.append("\"]");
        return outline71.toString();
    }
}
