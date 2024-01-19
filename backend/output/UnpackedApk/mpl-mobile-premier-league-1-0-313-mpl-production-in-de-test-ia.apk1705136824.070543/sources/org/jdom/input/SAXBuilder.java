package org.jdom.input;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.jdom.DefaultJDOMFactory;
import org.jdom.JDOMException;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

public class SAXBuilder {
    public static /* synthetic */ Class class$java$util$Map;
    public boolean expand = true;
    public DefaultJDOMFactory factory = new DefaultJDOMFactory();
    public HashMap features = new HashMap(5);
    public boolean ignoringBoundaryWhite = false;
    public boolean ignoringWhite = false;
    public HashMap properties = new HashMap(5);
    public boolean reuseParser = true;
    public DTDHandler saxDTDHandler = null;
    public String saxDriverClass;
    public EntityResolver saxEntityResolver = null;
    public ErrorHandler saxErrorHandler = null;
    public XMLReader saxParser = null;
    public XMLFilter saxXMLFilter = null;
    public boolean validate;

    public SAXBuilder(boolean z) {
        this.validate = z;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static URL fileToURL(File file) throws MalformedURLException {
        StringBuffer stringBuffer = new StringBuffer();
        String absolutePath = file.getAbsolutePath();
        char c2 = File.separatorChar;
        if (c2 != '/') {
            absolutePath = absolutePath.replace(c2, '/');
        }
        if (!absolutePath.startsWith("/")) {
            stringBuffer.append('/');
        }
        int length = absolutePath.length();
        for (int i = 0; i < length; i++) {
            char charAt = absolutePath.charAt(i);
            if (charAt == ' ') {
                stringBuffer.append("%20");
            } else if (charAt == '#') {
                stringBuffer.append("%23");
            } else if (charAt == '%') {
                stringBuffer.append("%25");
            } else if (charAt == '&') {
                stringBuffer.append("%26");
            } else if (charAt == ';') {
                stringBuffer.append("%3B");
            } else if (charAt == '<') {
                stringBuffer.append("%3C");
            } else if (charAt == '=') {
                stringBuffer.append("%3D");
            } else if (charAt == '>') {
                stringBuffer.append("%3E");
            } else if (charAt == '?') {
                stringBuffer.append("%3F");
            } else if (charAt == '~') {
                stringBuffer.append("%7E");
            } else {
                stringBuffer.append(charAt);
            }
        }
        if (!absolutePath.endsWith("/") && file.isDirectory()) {
            stringBuffer.append('/');
        }
        return new URL("file", "", stringBuffer.toString());
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f A[Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088 A[SYNTHETIC, Splitter:B:38:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a9 A[Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jdom.Document build(java.net.URL r7) throws org.jdom.JDOMException, java.io.IOException {
        /*
            r6 = this;
            java.lang.String r7 = r7.toExternalForm()
            org.xml.sax.InputSource r0 = new org.xml.sax.InputSource
            r0.<init>(r7)
            r7 = 1
            r1 = 0
            org.jdom.input.SAXHandler r2 = new org.jdom.input.SAXHandler     // Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }
            org.jdom.DefaultJDOMFactory r3 = r6.factory     // Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }
            r2.<init>(r3)     // Catch:{ SAXParseException -> 0x006f, SAXException -> 0x0051 }
            r6.configureContentHandler(r2)     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            org.xml.sax.XMLReader r3 = r6.saxParser     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            if (r3 != 0) goto L_0x0041
            org.xml.sax.XMLReader r3 = r6.createParser()     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            org.xml.sax.XMLFilter r4 = r6.saxXMLFilter     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            if (r4 == 0) goto L_0x0037
            org.xml.sax.XMLFilter r4 = r6.saxXMLFilter     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
        L_0x0023:
            org.xml.sax.XMLReader r5 = r4.getParent()     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            boolean r5 = r5 instanceof org.xml.sax.XMLFilter     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            if (r5 == 0) goto L_0x0032
            org.xml.sax.XMLReader r4 = r4.getParent()     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            org.xml.sax.XMLFilter r4 = (org.xml.sax.XMLFilter) r4     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            goto L_0x0023
        L_0x0032:
            r4.setParent(r3)     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            org.xml.sax.XMLFilter r3 = r6.saxXMLFilter     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
        L_0x0037:
            r6.configureParser(r3, r2)     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            boolean r4 = r6.reuseParser     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            if (r4 != r7) goto L_0x0044
            r6.saxParser = r3     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            goto L_0x0044
        L_0x0041:
            r6.configureParser(r3, r2)     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
        L_0x0044:
            r3.parse(r0)     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            org.jdom.Document r7 = r2.document     // Catch:{ SAXParseException -> 0x004d, SAXException -> 0x004a }
            return r7
        L_0x004a:
            r7 = move-exception
            r1 = r2
            goto L_0x0052
        L_0x004d:
            r0 = move-exception
            goto L_0x0071
        L_0x004f:
            r7 = move-exception
            goto L_0x00c2
        L_0x0051:
            r7 = move-exception
        L_0x0052:
            org.jdom.input.JDOMParseException r0 = new org.jdom.input.JDOMParseException     // Catch:{ all -> 0x004f }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x004f }
            r2.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "Error in building: "
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x004f }
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004f }
            org.jdom.Document r1 = r1.document     // Catch:{ all -> 0x004f }
            r0.<init>(r2, r7, r1)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x006f:
            r0 = move-exception
            r2 = r1
        L_0x0071:
            org.jdom.Document r2 = r2.document     // Catch:{ all -> 0x004f }
            org.jdom.ContentList r3 = r2.content     // Catch:{ all -> 0x004f }
            int r3 = r3.indexOfFirstElement()     // Catch:{ all -> 0x004f }
            if (r3 >= 0) goto L_0x007c
            r7 = 0
        L_0x007c:
            if (r7 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r1 = r2
        L_0x0080:
            java.lang.String r7 = r0.getSystemId()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Error on line "
            if (r7 == 0) goto L_0x00a9
            org.jdom.input.JDOMParseException r3 = new org.jdom.input.JDOMParseException     // Catch:{ all -> 0x004f }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x004f }
            r4.<init>()     // Catch:{ all -> 0x004f }
            r4.append(r2)     // Catch:{ all -> 0x004f }
            int r2 = r0.getLineNumber()     // Catch:{ all -> 0x004f }
            r4.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = " of document "
            r4.append(r2)     // Catch:{ all -> 0x004f }
            r4.append(r7)     // Catch:{ all -> 0x004f }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x004f }
            r3.<init>(r7, r0, r1)     // Catch:{ all -> 0x004f }
            throw r3     // Catch:{ all -> 0x004f }
        L_0x00a9:
            org.jdom.input.JDOMParseException r7 = new org.jdom.input.JDOMParseException     // Catch:{ all -> 0x004f }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ all -> 0x004f }
            r3.<init>()     // Catch:{ all -> 0x004f }
            r3.append(r2)     // Catch:{ all -> 0x004f }
            int r2 = r0.getLineNumber()     // Catch:{ all -> 0x004f }
            r3.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x004f }
            r7.<init>(r2, r0, r1)     // Catch:{ all -> 0x004f }
            throw r7     // Catch:{ all -> 0x004f }
        L_0x00c2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.input.SAXBuilder.build(java.net.URL):org.jdom.Document");
    }

    public void configureContentHandler(SAXHandler sAXHandler) {
        sAXHandler.expand = this.expand;
        sAXHandler.ignoringWhite = this.ignoringWhite;
        sAXHandler.ignoringBoundaryWhite = this.ignoringBoundaryWhite;
    }

    public void configureParser(XMLReader xMLReader, SAXHandler sAXHandler) throws JDOMException {
        xMLReader.setContentHandler(sAXHandler);
        EntityResolver entityResolver = this.saxEntityResolver;
        if (entityResolver != null) {
            xMLReader.setEntityResolver(entityResolver);
        }
        DTDHandler dTDHandler = this.saxDTDHandler;
        if (dTDHandler != null) {
            xMLReader.setDTDHandler(dTDHandler);
        } else {
            xMLReader.setDTDHandler(sAXHandler);
        }
        ErrorHandler errorHandler = this.saxErrorHandler;
        if (errorHandler != null) {
            xMLReader.setErrorHandler(errorHandler);
        } else {
            xMLReader.setErrorHandler(new BuilderErrorHandler());
        }
        boolean z = false;
        try {
            xMLReader.setProperty("http://xml.org/sax/handlers/LexicalHandler", sAXHandler);
            z = true;
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
        }
        if (!z) {
            try {
                xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            } catch (SAXNotRecognizedException | SAXNotSupportedException unused2) {
            }
        }
        if (!this.expand) {
            try {
                xMLReader.setProperty("http://xml.org/sax/properties/declaration-handler", sAXHandler);
            } catch (SAXNotRecognizedException | SAXNotSupportedException unused3) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[ExcHandler: JDOMException (r0v6 'e' org.jdom.JDOMException A[CUSTOM_DECLARE]), Splitter:B:8:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.xml.sax.XMLReader createParser() throws org.jdom.JDOMException {
        /*
            r9 = this;
            java.lang.String r0 = r9.saxDriverClass
            r1 = 1
            if (r0 == 0) goto L_0x0023
            org.xml.sax.XMLReader r0 = org.xml.sax.helpers.XMLReaderFactory.createXMLReader(r0)     // Catch:{ SAXException -> 0x000d }
            r9.setFeaturesAndProperties(r0, r1)     // Catch:{ SAXException -> 0x000d }
            goto L_0x0078
        L_0x000d:
            r0 = move-exception
            org.jdom.JDOMException r1 = new org.jdom.JDOMException
            java.lang.String r2 = "Could not load "
            java.lang.StringBuffer r2 = com.android.tools.r8.GeneratedOutlineSupport.outline71(r2)
            java.lang.String r3 = r9.saxDriverClass
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0023:
            r0 = 0
            java.lang.String r2 = "org.jdom.input.JAXPParserFactory"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.String r3 = "createParser"
            r4 = 3
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r7 = 0
            r5[r7] = r6     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Class r6 = class$java$util$Map     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.String r8 = "java.util.Map"
            if (r6 != 0) goto L_0x0041
            java.lang.Class r6 = class$(r8)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            class$java$util$Map = r6     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            goto L_0x0043
        L_0x0041:
            java.lang.Class r6 = class$java$util$Map     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
        L_0x0043:
            r5[r1] = r6     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Class r6 = class$java$util$Map     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            if (r6 != 0) goto L_0x0050
            java.lang.Class r6 = class$(r8)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            class$java$util$Map = r6     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            goto L_0x0052
        L_0x0050:
            java.lang.Class r6 = class$java$util$Map     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
        L_0x0052:
            r8 = 2
            r5[r8] = r6     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Boolean r4 = new java.lang.Boolean     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            boolean r5 = r9.validate     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r4.<init>(r5)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r3[r7] = r4     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.util.HashMap r4 = r9.features     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r3[r1] = r4     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.util.HashMap r4 = r9.properties     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r3[r8] = r4     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            org.xml.sax.XMLReader r2 = (org.xml.sax.XMLReader) r2     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0077 }
            r9.setFeaturesAndProperties(r2, r7)     // Catch:{ JDOMException -> 0x0098, Exception | NoClassDefFoundError -> 0x0075 }
        L_0x0075:
            r0 = r2
            goto L_0x0078
        L_0x0077:
        L_0x0078:
            if (r0 != 0) goto L_0x0097
            java.lang.String r0 = "org.apache.xerces.parsers.SAXParser"
            org.xml.sax.XMLReader r0 = org.xml.sax.helpers.XMLReaderFactory.createXMLReader(r0)     // Catch:{ SAXException -> 0x008e }
            java.lang.Class r2 = r0.getClass()     // Catch:{ SAXException -> 0x008e }
            java.lang.String r2 = r2.getName()     // Catch:{ SAXException -> 0x008e }
            r9.saxDriverClass = r2     // Catch:{ SAXException -> 0x008e }
            r9.setFeaturesAndProperties(r0, r1)     // Catch:{ SAXException -> 0x008e }
            goto L_0x0097
        L_0x008e:
            r0 = move-exception
            org.jdom.JDOMException r1 = new org.jdom.JDOMException
            java.lang.String r2 = "Could not load default SAX parser: org.apache.xerces.parsers.SAXParser"
            r1.<init>(r2, r0)
            throw r1
        L_0x0097:
            return r0
        L_0x0098:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.input.SAXBuilder.createParser():org.xml.sax.XMLReader");
    }

    public final void internalSetFeature(XMLReader xMLReader, String str, boolean z, String str2) throws JDOMException {
        try {
            xMLReader.setFeature(str, z);
        } catch (SAXNotSupportedException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(" feature not supported for SAX driver ");
            stringBuffer.append(xMLReader.getClass().getName());
            throw new JDOMException(stringBuffer.toString());
        } catch (SAXNotRecognizedException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str2);
            stringBuffer2.append(" feature not recognized for SAX driver ");
            stringBuffer2.append(xMLReader.getClass().getName());
            throw new JDOMException(stringBuffer2.toString());
        }
    }

    public final void setFeaturesAndProperties(XMLReader xMLReader, boolean z) throws JDOMException {
        for (String str : this.features.keySet()) {
            internalSetFeature(xMLReader, str, ((Boolean) this.features.get(str)).booleanValue(), str);
        }
        for (String str2 : this.properties.keySet()) {
            try {
                xMLReader.setProperty(str2, this.properties.get(str2));
            } catch (SAXNotSupportedException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2);
                stringBuffer.append(" property not supported for SAX driver ");
                stringBuffer.append(xMLReader.getClass().getName());
                throw new JDOMException(stringBuffer.toString());
            } catch (SAXNotRecognizedException unused2) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str2);
                stringBuffer2.append(" property not recognized for SAX driver ");
                stringBuffer2.append(xMLReader.getClass().getName());
                throw new JDOMException(stringBuffer2.toString());
            }
        }
        if (z) {
            try {
                internalSetFeature(xMLReader, "http://xml.org/sax/features/validation", this.validate, "Validation");
            } catch (JDOMException e2) {
                if (this.validate) {
                    throw e2;
                }
            }
            internalSetFeature(xMLReader, "http://xml.org/sax/features/namespaces", true, "Namespaces");
            internalSetFeature(xMLReader, "http://xml.org/sax/features/namespace-prefixes", true, "Namespace prefixes");
        }
        try {
            if (xMLReader.getFeature("http://xml.org/sax/features/external-general-entities") != this.expand) {
                xMLReader.setFeature("http://xml.org/sax/features/external-general-entities", this.expand);
            }
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused3) {
        }
    }
}
