package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class bn {

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f4502a;

    public bn() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f4502a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public cj a(byte[] bArr, bt btVar) {
        this.f4502a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f4502a.next();
        int eventType = this.f4502a.getEventType();
        String name = this.f4502a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return cr.a(this.f4502a);
            }
            if (name.equals("iq")) {
                return cr.a(this.f4502a, btVar);
            }
            if (name.equals("presence")) {
                return cr.a(this.f4502a);
            }
            if (!this.f4502a.getName().equals(BaseParser.STREAM_STRING)) {
                if (this.f4502a.getName().equals("error")) {
                    throw new cd(cr.a(this.f4502a));
                } else if (this.f4502a.getName().equals("warning")) {
                    this.f4502a.next();
                    boolean equals = this.f4502a.getName().equals("multi-login");
                } else {
                    this.f4502a.getName().equals("bind");
                }
            }
        }
        return null;
    }
}
