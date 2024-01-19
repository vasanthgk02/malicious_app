package org.jdom.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.commons.lang.StringEscapeUtils;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.DefaultJDOMFactory;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.IllegalAddException;
import org.jdom.Namespace;
import org.jdom.Parent;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.DTDHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler implements LexicalHandler, DeclHandler, DTDHandler {
    public static final Map attrNameToTypeMap;
    public boolean atRoot;
    public Element currentElement;
    public List declaredNamespaces;
    public Document document;
    public int entityDepth = 0;
    public boolean expand = true;
    public Map externalEntities;
    public DefaultJDOMFactory factory;
    public boolean ignoringBoundaryWhite = false;
    public boolean ignoringWhite = false;
    public boolean inCDATA = false;
    public boolean inDTD = false;
    public boolean inInternalSubset = false;
    public StringBuffer internalSubset = new StringBuffer();
    public Locator locator;
    public boolean previousCDATA = false;
    public boolean suppress = false;
    public TextBuffer textBuffer = new TextBuffer();

    static {
        HashMap hashMap = new HashMap(13);
        attrNameToTypeMap = hashMap;
        hashMap.put("CDATA", new Integer(1));
        attrNameToTypeMap.put("ID", new Integer(2));
        attrNameToTypeMap.put("IDREF", new Integer(3));
        attrNameToTypeMap.put("IDREFS", new Integer(4));
        attrNameToTypeMap.put("ENTITY", new Integer(5));
        attrNameToTypeMap.put("ENTITIES", new Integer(6));
        attrNameToTypeMap.put("NMTOKEN", new Integer(7));
        attrNameToTypeMap.put("NMTOKENS", new Integer(8));
        attrNameToTypeMap.put("NOTATION", new Integer(9));
        attrNameToTypeMap.put("ENUMERATION", new Integer(10));
    }

    public SAXHandler(DefaultJDOMFactory defaultJDOMFactory) {
        if (defaultJDOMFactory != null) {
            this.factory = defaultJDOMFactory;
        } else {
            this.factory = new DefaultJDOMFactory();
        }
        this.atRoot = true;
        this.declaredNamespaces = new ArrayList();
        this.externalEntities = new HashMap();
        if (this.factory != null) {
            this.document = new Document(null);
            return;
        }
        throw null;
    }

    public final void appendExternalId(String str, String str2) {
        if (str != null) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append(" PUBLIC \"");
            stringBuffer.append(str);
            stringBuffer.append(StringEscapeUtils.CSV_QUOTE);
        }
        if (str2 != null) {
            if (str == null) {
                this.internalSubset.append(" SYSTEM ");
            } else {
                this.internalSubset.append(' ');
            }
            StringBuffer stringBuffer2 = this.internalSubset;
            stringBuffer2.append(StringEscapeUtils.CSV_QUOTE);
            stringBuffer2.append(str2);
            stringBuffer2.append(StringEscapeUtils.CSV_QUOTE);
        }
    }

    public void attributeDecl(String str, String str2, String str3, String str4, String str5) throws SAXException {
        if (this.inInternalSubset) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!ATTLIST ");
            stringBuffer.append(str);
            stringBuffer.append(' ');
            stringBuffer.append(str2);
            stringBuffer.append(' ');
            stringBuffer.append(str3);
            stringBuffer.append(' ');
            if (str4 != null) {
                this.internalSubset.append(str4);
            } else {
                StringBuffer stringBuffer2 = this.internalSubset;
                stringBuffer2.append(StringEscapeUtils.CSV_QUOTE);
                stringBuffer2.append(str5);
                stringBuffer2.append(StringEscapeUtils.CSV_QUOTE);
            }
            if (str4 != null && str4.equals("#FIXED")) {
                StringBuffer stringBuffer3 = this.internalSubset;
                stringBuffer3.append(" \"");
                stringBuffer3.append(str5);
                stringBuffer3.append(StringEscapeUtils.CSV_QUOTE);
            }
            this.internalSubset.append(">\n");
        }
    }

    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.suppress && i2 != 0) {
            if (this.previousCDATA != this.inCDATA) {
                flushCharacters();
            }
            TextBuffer textBuffer2 = this.textBuffer;
            if (textBuffer2.prefixString == null) {
                textBuffer2.prefixString = new String(cArr, i, i2);
                return;
            }
            int i3 = textBuffer2.arraySize + i2;
            char[] cArr2 = textBuffer2.array;
            int length = cArr2.length;
            if (i3 > length) {
                int i4 = length;
                while (i3 > i4) {
                    i4 += length / 2;
                }
                char[] cArr3 = new char[i4];
                textBuffer2.array = cArr3;
                System.arraycopy(cArr2, 0, cArr3, 0, textBuffer2.arraySize);
            }
            System.arraycopy(cArr, i, textBuffer2.array, textBuffer2.arraySize, i2);
            textBuffer2.arraySize += i2;
        }
    }

    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.suppress) {
            flushCharacters();
            String str = new String(cArr, i, i2);
            if (!this.inDTD || !this.inInternalSubset || this.expand) {
                if (!this.inDTD && !str.equals("")) {
                    if (this.atRoot) {
                        DefaultJDOMFactory defaultJDOMFactory = this.factory;
                        Document document2 = this.document;
                        if (defaultJDOMFactory != null) {
                            defaultJDOMFactory.addContent(document2, new Comment(str));
                        } else {
                            throw null;
                        }
                    } else {
                        DefaultJDOMFactory defaultJDOMFactory2 = this.factory;
                        Element currentElement2 = getCurrentElement();
                        if (this.factory != null) {
                            defaultJDOMFactory2.addContent(currentElement2, new Comment(str));
                        } else {
                            throw null;
                        }
                    }
                }
                return;
            }
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!--");
            stringBuffer.append(str);
            stringBuffer.append("-->\n");
        }
    }

    public void elementDecl(String str, String str2) throws SAXException {
        if (this.inInternalSubset) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!ELEMENT ");
            stringBuffer.append(str);
            stringBuffer.append(' ');
            stringBuffer.append(str2);
            stringBuffer.append(">\n");
        }
    }

    public void endCDATA() throws SAXException {
        if (!this.suppress) {
            this.previousCDATA = true;
            this.inCDATA = false;
        }
    }

    public void endDTD() throws SAXException {
        this.document.getDocType().internalSubset = this.internalSubset.toString();
        this.inDTD = false;
        this.inInternalSubset = false;
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        if (!this.suppress) {
            flushCharacters();
            if (!this.atRoot) {
                Parent parent = this.currentElement.parent;
                if (parent instanceof Document) {
                    this.atRoot = true;
                } else {
                    this.currentElement = (Element) parent;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Ill-formed XML document (missing opening tag for ");
            stringBuffer.append(str2);
            stringBuffer.append(")");
            throw new SAXException(stringBuffer.toString());
        }
    }

    public void endEntity(String str) throws SAXException {
        int i = this.entityDepth - 1;
        this.entityDepth = i;
        if (i == 0) {
            this.suppress = false;
        }
        if (str.equals("[dtd]")) {
            this.inInternalSubset = true;
        }
    }

    public void externalEntityDecl(String str, String str2, String str3) throws SAXException {
        this.externalEntities.put(str, new String[]{str2, str3});
        if (this.inInternalSubset) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!ENTITY ");
            stringBuffer.append(str);
            appendExternalId(str2, str3);
            this.internalSubset.append(">\n");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushCharacters() throws org.xml.sax.SAXException {
        /*
            r5 = this;
            boolean r0 = r5.ignoringBoundaryWhite
            r1 = 0
            if (r0 == 0) goto L_0x004c
            org.jdom.input.TextBuffer r0 = r5.textBuffer
            java.lang.String r2 = r0.prefixString
            if (r2 == 0) goto L_0x003f
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0012
            goto L_0x003f
        L_0x0012:
            java.lang.String r2 = r0.prefixString
            int r2 = r2.length()
            r3 = 0
        L_0x0019:
            if (r3 >= r2) goto L_0x002c
            java.lang.String r4 = r0.prefixString
            char r4 = r4.charAt(r3)
            boolean r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isXMLWhitespace(r4)
            if (r4 != 0) goto L_0x0029
        L_0x0027:
            r0 = 0
            goto L_0x0040
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x002c:
            r2 = 0
        L_0x002d:
            int r3 = r0.arraySize
            if (r2 >= r3) goto L_0x003f
            char[] r3 = r0.array
            char r3 = r3[r2]
            boolean r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isXMLWhitespace(r3)
            if (r3 != 0) goto L_0x003c
            goto L_0x0027
        L_0x003c:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x003f:
            r0 = 1
        L_0x0040:
            if (r0 != 0) goto L_0x0055
            org.jdom.input.TextBuffer r0 = r5.textBuffer
            java.lang.String r0 = r0.toString()
            r5.flushCharacters(r0)
            goto L_0x0055
        L_0x004c:
            org.jdom.input.TextBuffer r0 = r5.textBuffer
            java.lang.String r0 = r0.toString()
            r5.flushCharacters(r0)
        L_0x0055:
            org.jdom.input.TextBuffer r0 = r5.textBuffer
            r0.arraySize = r1
            r1 = 0
            r0.prefixString = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.input.SAXHandler.flushCharacters():void");
    }

    public Element getCurrentElement() throws SAXException {
        Element element = this.currentElement;
        if (element != null) {
            return element;
        }
        throw new SAXException("Ill-formed XML document (multiple root elements detected)");
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        if (!this.ignoringWhite) {
            characters(cArr, i, i2);
        }
    }

    public void internalEntityDecl(String str, String str2) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ENTITY ");
            if (str.startsWith("%")) {
                StringBuffer stringBuffer = this.internalSubset;
                stringBuffer.append("% ");
                stringBuffer.append(str.substring(1));
            } else {
                this.internalSubset.append(str);
            }
            StringBuffer stringBuffer2 = this.internalSubset;
            stringBuffer2.append(" \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\">\n");
        }
    }

    public void notationDecl(String str, String str2, String str3) throws SAXException {
        if (this.inInternalSubset) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!NOTATION ");
            stringBuffer.append(str);
            appendExternalId(str2, str3);
            this.internalSubset.append(">\n");
        }
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        if (!this.suppress) {
            flushCharacters();
            if (this.atRoot) {
                DefaultJDOMFactory defaultJDOMFactory = this.factory;
                Document document2 = this.document;
                if (defaultJDOMFactory != null) {
                    defaultJDOMFactory.addContent(document2, new ProcessingInstruction(str, str2));
                } else {
                    throw null;
                }
            } else {
                DefaultJDOMFactory defaultJDOMFactory2 = this.factory;
                Element currentElement2 = getCurrentElement();
                if (this.factory != null) {
                    defaultJDOMFactory2.addContent(currentElement2, new ProcessingInstruction(str, str2));
                } else {
                    throw null;
                }
            }
        }
    }

    public void setDocumentLocator(Locator locator2) {
        this.locator = locator2;
    }

    public void skippedEntity(String str) throws SAXException {
        if (!str.startsWith("%")) {
            flushCharacters();
            DefaultJDOMFactory defaultJDOMFactory = this.factory;
            Element currentElement2 = getCurrentElement();
            if (this.factory != null) {
                defaultJDOMFactory.addContent(currentElement2, new EntityRef(str, null, null));
                return;
            }
            throw null;
        }
    }

    public void startCDATA() throws SAXException {
        if (!this.suppress) {
            this.inCDATA = true;
        }
    }

    public void startDTD(String str, String str2, String str3) throws SAXException {
        flushCharacters();
        DefaultJDOMFactory defaultJDOMFactory = this.factory;
        Document document2 = this.document;
        if (defaultJDOMFactory != null) {
            defaultJDOMFactory.addContent(document2, new DocType(str, str2, str3));
            this.inDTD = true;
            this.inInternalSubset = true;
            return;
        }
        throw null;
    }

    public void startDocument() {
        Locator locator2 = this.locator;
        if (locator2 != null) {
            Document document2 = this.document;
            locator2.getSystemId();
            if (document2 == null) {
                throw null;
            }
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        Element element;
        int i;
        Attribute attribute;
        String str4;
        if (!this.suppress) {
            if (str != null && !str.equals("")) {
                if (!str3.equals(str2)) {
                    str4 = str3.substring(0, str3.indexOf(":"));
                } else {
                    str4 = "";
                }
                Namespace namespace = Namespace.getNamespace(str4, str);
                if (this.factory != null) {
                    element = new Element(str2, namespace);
                } else {
                    throw null;
                }
            } else if (this.factory != null) {
                element = new Element(str2, null);
            } else {
                throw null;
            }
            if (this.declaredNamespaces.size() > 0) {
                for (Namespace namespace2 : this.declaredNamespaces) {
                    if (namespace2 != element.namespace) {
                        String checkNamespaceCollision = TypeUtilsKt.checkNamespaceCollision(namespace2, element);
                        if (checkNamespaceCollision == null) {
                            if (element.additionalNamespaces == null) {
                                element.additionalNamespaces = new ArrayList(5);
                            }
                            element.additionalNamespaces.add(namespace2);
                        } else {
                            throw new IllegalAddException(element, namespace2, checkNamespaceCollision);
                        }
                    }
                }
                this.declaredNamespaces.clear();
            }
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                String localName = attributes.getLocalName(i2);
                String qName = attributes.getQName(i2);
                String type = attributes.getType(i2);
                Integer num = (Integer) attrNameToTypeMap.get(type);
                if (num == null) {
                    i = (type == null || type.length() <= 0 || type.charAt(0) != '(') ? 0 : 10;
                } else {
                    i = num.intValue();
                }
                if (!qName.startsWith("xmlns:") && !qName.equals("xmlns")) {
                    if ("".equals(localName) && qName.indexOf(":") == -1) {
                        DefaultJDOMFactory defaultJDOMFactory = this.factory;
                        String value = attributes.getValue(i2);
                        if (defaultJDOMFactory != null) {
                            attribute = new Attribute(qName, value, i, Namespace.NO_NAMESPACE);
                        } else {
                            throw null;
                        }
                    } else if (!qName.equals(localName)) {
                        Namespace namespace3 = Namespace.getNamespace(qName.substring(0, qName.indexOf(":")), attributes.getURI(i2));
                        DefaultJDOMFactory defaultJDOMFactory2 = this.factory;
                        String value2 = attributes.getValue(i2);
                        if (defaultJDOMFactory2 != null) {
                            attribute = new Attribute(localName, value2, i, namespace3);
                        } else {
                            throw null;
                        }
                    } else {
                        DefaultJDOMFactory defaultJDOMFactory3 = this.factory;
                        String value3 = attributes.getValue(i2);
                        if (defaultJDOMFactory3 != null) {
                            attribute = new Attribute(localName, value3, i, Namespace.NO_NAMESPACE);
                        } else {
                            throw null;
                        }
                    }
                    if (this.factory != null) {
                        element.attributes.add(attribute);
                    } else {
                        throw null;
                    }
                }
            }
            flushCharacters();
            if (this.atRoot) {
                Document document2 = this.document;
                int indexOfFirstElement = document2.content.indexOfFirstElement();
                if (indexOfFirstElement < 0) {
                    document2.content.add(element);
                } else {
                    document2.content.set(indexOfFirstElement, element);
                }
                this.atRoot = false;
            } else {
                this.factory.addContent(getCurrentElement(), element);
            }
            this.currentElement = element;
        }
    }

    public void startEntity(String str) throws SAXException {
        String str2;
        String str3;
        int i = this.entityDepth + 1;
        this.entityDepth = i;
        if (!this.expand && i <= 1) {
            if (str.equals("[dtd]")) {
                this.inInternalSubset = false;
            } else if (!this.inDTD && !str.equals("amp") && !str.equals("lt") && !str.equals("gt") && !str.equals("apos") && !str.equals("quot") && !this.expand) {
                String[] strArr = (String[]) this.externalEntities.get(str);
                if (strArr != null) {
                    str2 = strArr[0];
                    str3 = strArr[1];
                } else {
                    str3 = null;
                    str2 = null;
                }
                if (!this.atRoot) {
                    flushCharacters();
                    if (this.factory != null) {
                        this.factory.addContent(getCurrentElement(), new EntityRef(str, str2, str3));
                    } else {
                        throw null;
                    }
                }
                this.suppress = true;
            }
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
        if (!this.suppress) {
            this.declaredNamespaces.add(Namespace.getNamespace(str, str2));
        }
    }

    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        if (this.inInternalSubset) {
            StringBuffer stringBuffer = this.internalSubset;
            stringBuffer.append("  <!ENTITY ");
            stringBuffer.append(str);
            appendExternalId(str2, str3);
            StringBuffer stringBuffer2 = this.internalSubset;
            stringBuffer2.append(" NDATA ");
            stringBuffer2.append(str4);
            this.internalSubset.append(">\n");
        }
    }

    public void flushCharacters(String str) throws SAXException {
        if (str.length() == 0) {
            this.previousCDATA = this.inCDATA;
            return;
        }
        if (this.previousCDATA) {
            DefaultJDOMFactory defaultJDOMFactory = this.factory;
            Element currentElement2 = getCurrentElement();
            if (this.factory != null) {
                defaultJDOMFactory.addContent(currentElement2, new CDATA(str));
            } else {
                throw null;
            }
        } else {
            DefaultJDOMFactory defaultJDOMFactory2 = this.factory;
            Element currentElement3 = getCurrentElement();
            if (this.factory != null) {
                defaultJDOMFactory2.addContent(currentElement3, new Text(str));
            } else {
                throw null;
            }
        }
        this.previousCDATA = this.inCDATA;
    }
}
