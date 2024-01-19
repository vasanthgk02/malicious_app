package com.xiaomi.push;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import com.razorpay.AnalyticsConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ch.a;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bh;
import com.xiaomi.push.service.k;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class cr {

    /* renamed from: a  reason: collision with root package name */
    public static XmlPullParser f4585a;

    public static cg a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = cq.a().a((String) ChannelPipelineCoverage.ALL, (String) "xm:chat");
        if (a2 == null || !(a2 instanceof k)) {
            return null;
        }
        return ((k) a2).b(xmlPullParser);
    }

    public static ch a(XmlPullParser xmlPullParser, bt btVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        a a2 = a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        ch chVar = null;
        cn cnVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    cnVar = a(xmlPullParser);
                } else {
                    chVar = new ch();
                    chVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (chVar == null) {
            if (a.f4542a == a2 || a.f4543b == a2) {
                cs csVar = new cs();
                csVar.k(attributeValue);
                csVar.m(attributeValue3);
                csVar.n(attributeValue2);
                csVar.a(a.f4545d);
                csVar.l(attributeValue4);
                csVar.a(new cn(cn.a.f4581e));
                btVar.a((cj) csVar);
                b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            chVar = new ct();
        }
        chVar.k(attributeValue);
        chVar.m(attributeValue2);
        chVar.l(attributeValue4);
        chVar.n(attributeValue3);
        chVar.a(a2);
        chVar.a(cnVar);
        chVar.a((Map<String, String>) hashMap);
        return chVar;
    }

    public static cj a(XmlPullParser xmlPullParser) {
        String str;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser2.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser2.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser2.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser2.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser2.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser2.getAttributeValue("", "type");
            az.b a2 = az.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = az.a().a(attributeValue, attributeValue3);
            }
            if (a2 != null) {
                cj cjVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new cd((String) "error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                ci ciVar = new ci();
                                ciVar.l(attributeValue);
                                ciVar.b(true);
                                ciVar.n(attributeValue3);
                                ciVar.m(attributeValue4);
                                ciVar.k(attributeValue2);
                                ciVar.f(attributeValue5);
                                cg cgVar = new cg("s", null, null, null);
                                cgVar.a(text);
                                ciVar.a(cgVar);
                                return ciVar;
                            }
                            a(bh.a(bh.a(a2.h, attributeValue2), text));
                            f4585a.next();
                            cjVar = a(f4585a);
                        } else {
                            throw new cd((String) "error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (cjVar != null) {
                    return cjVar;
                }
                throw new cd((String) "error while receiving a encrypted message with wrong format");
            }
            throw new cd((String) "the channel id is wrong while receiving a encrypted message");
        }
        ci ciVar2 = new ci();
        String attributeValue6 = xmlPullParser2.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        ciVar2.k(attributeValue6);
        ciVar2.m(xmlPullParser2.getAttributeValue("", "to"));
        ciVar2.n(xmlPullParser2.getAttributeValue("", "from"));
        ciVar2.l(xmlPullParser2.getAttributeValue("", "chid"));
        ciVar2.a(xmlPullParser2.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser2.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser2.getAttributeValue("", Values.SEQ);
            if (!TextUtils.isEmpty(attributeValue7)) {
                ciVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser2.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                ciVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser2.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                ciVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser2.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                ciVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        ciVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase(BaseParser.TRUE));
        ciVar2.f(xmlPullParser2.getAttributeValue("", "type"));
        String b2 = b(xmlPullParser);
        if (b2 == null || "".equals(b2.trim())) {
            cj.q();
        } else {
            ciVar2.j(b2);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    String b3 = b(xmlPullParser);
                    ciVar2.g(a(xmlPullParser));
                } else if (name.equals(SMTNotificationConstants.NOTIF_BODY_KEY)) {
                    String attributeValue11 = xmlPullParser2.getAttributeValue("", "encode");
                    String a3 = a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        ciVar2.a(a3, attributeValue11);
                    } else {
                        ciVar2.h(a3);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    ciVar2.a(a(xmlPullParser));
                } else {
                    ciVar2.a(a(name, namespace, xmlPullParser2));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        ciVar2.i(str2);
        return ciVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static cl m584a(XmlPullParser xmlPullParser) {
        cl.b bVar = cl.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = cl.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        cl clVar = new cl(bVar);
        clVar.m(xmlPullParser.getAttributeValue("", "to"));
        clVar.n(xmlPullParser.getAttributeValue("", "from"));
        clVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        clVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    clVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        clVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        clVar.a(0);
                    }
                } else if (name.equals(AnalyticsConstants.SHOW)) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        clVar.a(cl.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    clVar.a(a(xmlPullParser));
                } else {
                    clVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return clVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static cm m585a(XmlPullParser xmlPullParser) {
        cm cmVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                cmVar = new cm(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return cmVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static cn m586a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        cn cnVar = new cn(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
        return cnVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m587a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(xmlPullParser.getText());
            str = outline73.toString();
        }
    }

    public static void a(byte[] bArr) {
        if (f4585a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f4585a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f4585a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
