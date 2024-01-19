package com.xiaomi.push.service;

import com.xiaomi.push.cg;
import com.xiaomi.push.cp;
import com.xiaomi.push.cq;
import com.xiaomi.push.cu;
import java.util.ArrayList;
import java.util.List;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.xmlpull.v1.XmlPullParser;

public class k implements cp {
    public static cg a(XmlPullParser xmlPullParser) {
        List list;
        String str;
        String[] strArr;
        String[] strArr2;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = cu.b(xmlPullParser.getAttributeValue(i));
            }
            strArr2 = strArr3;
            str = null;
            list = null;
            strArr = strArr4;
        } else {
            strArr2 = null;
            strArr = null;
            str = null;
            list = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                cg cgVar = new cg(name, namespace, strArr2, strArr, str, list);
                return cgVar;
            } else if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (list == null) {
                    list = new ArrayList();
                }
                cg a2 = a(xmlPullParser);
                if (a2 != null) {
                    list.add(a2);
                }
            }
        }
    }

    public void a() {
        cq.a().a(ChannelPipelineCoverage.ALL, "xm:chat", this);
    }

    public cg b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }
}
