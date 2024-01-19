package sfs2x.client.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.net.MalformedURLException;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.SFSEvent;

public class ConfigLoader {
    public EventDispatcher dispatcher = new EventDispatcher(this);
    public Document xmldoc;

    private void onConfigLoadFailure(String str) {
        this.dispatcher.dispatchEvent(new SFSEvent(SFSEvent.CONFIG_LOAD_FAILURE, GeneratedOutlineSupport.outline87("message", str)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        if (r12.getChild(sfs2x.client.requests.game.CreateSFSGameRequest.KEY_INVITATION_PARAMS).getText().equals("") != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void tryParse() {
        /*
            r15 = this;
            java.lang.String r0 = "blueBoxPollingRate"
            java.lang.String r1 = "httpsPort"
            java.lang.String r2 = "httpPort"
            java.lang.String r3 = "useBlueBox"
            java.lang.String r4 = "debug"
            java.lang.String r5 = "zone"
            java.lang.String r6 = "udpPort"
            java.lang.String r7 = "udpIp"
            java.lang.String r8 = "port"
            java.lang.String r9 = "ip"
            java.lang.Class<sfs2x.client.util.ConfigLoader> r10 = sfs2x.client.util.ConfigLoader.class
            org.slf4j.Logger r10 = org.slf4j.LoggerFactory.getLogger(r10)
            sfs2x.client.util.ConfigData r11 = new sfs2x.client.util.ConfigData
            r11.<init>()
            org.jdom.Document r12 = r15.xmldoc     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r12 = r12.getRootElement()     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r13 = r12.getChild(r9)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r14 = ""
            if (r13 == 0) goto L_0x003f
            org.jdom.Element r13 = r12.getChild(r9)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r13 = r13.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x0044
        L_0x003f:
            java.lang.String r13 = "Required config node missing: ip"
            r10.error(r13)     // Catch:{ Exception -> 0x01cc }
        L_0x0044:
            org.jdom.Element r13 = r12.getChild(r8)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x0058
            org.jdom.Element r13 = r12.getChild(r8)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r13 = r13.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x005d
        L_0x0058:
            java.lang.String r13 = "Required config node missing: port"
            r10.error(r13)     // Catch:{ Exception -> 0x01cc }
        L_0x005d:
            org.jdom.Element r13 = r12.getChild(r7)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x0071
            org.jdom.Element r13 = r12.getChild(r7)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r13 = r13.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x0076
        L_0x0071:
            java.lang.String r13 = "Required config node missing: udpIp"
            r10.error(r13)     // Catch:{ Exception -> 0x01cc }
        L_0x0076:
            org.jdom.Element r13 = r12.getChild(r6)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x008a
            org.jdom.Element r13 = r12.getChild(r6)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r13 = r13.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x008f
        L_0x008a:
            java.lang.String r13 = "Required config node missing: udpPort"
            r10.error(r13)     // Catch:{ Exception -> 0x01cc }
        L_0x008f:
            org.jdom.Element r13 = r12.getChild(r5)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x00a3
            org.jdom.Element r13 = r12.getChild(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r13 = r13.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r13 == 0) goto L_0x00a8
        L_0x00a3:
            java.lang.String r13 = "Required config node missing: zone"
            r10.error(r13)     // Catch:{ Exception -> 0x01cc }
        L_0x00a8:
            org.jdom.Element r9 = r12.getChild(r9)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r9 = r9.getText()     // Catch:{ Exception -> 0x01cc }
            r11.setHost(r9)     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r8 = r12.getChild(r8)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r8 = r8.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01cc }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x01cc }
            r11.setPort(r8)     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r7 = r12.getChild(r7)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = r7.getText()     // Catch:{ Exception -> 0x01cc }
            r11.setUdpHost(r7)     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r6 = r12.getChild(r6)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = r6.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x01cc }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x01cc }
            r11.setUdpPort(r6)     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r5 = r12.getChild(r5)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r5.getText()     // Catch:{ Exception -> 0x01cc }
            r11.setZone(r5)     // Catch:{ Exception -> 0x01cc }
            org.jdom.Element r5 = r12.getChild(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r6 = "true"
            if (r5 == 0) goto L_0x0119
            org.jdom.Element r5 = r12.getChild(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = r5.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r5 = r5.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r5 != 0) goto L_0x0119
            org.jdom.Element r4 = r12.getChild(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r4.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x01cc }
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x01cc }
            r11.setDebug(r4)     // Catch:{ Exception -> 0x01cc }
        L_0x0119:
            org.jdom.Element r4 = r12.getChild(r3)     // Catch:{ Exception -> 0x01cc }
            if (r4 == 0) goto L_0x0140
            org.jdom.Element r4 = r12.getChild(r3)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r4.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r4 = r4.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r4 != 0) goto L_0x0140
            org.jdom.Element r3 = r12.getChild(r3)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = r3.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x01cc }
            r11.setUseBBox(r3)     // Catch:{ Exception -> 0x01cc }
        L_0x0140:
            org.jdom.Element r3 = r12.getChild(r2)     // Catch:{ Exception -> 0x01cc }
            if (r3 == 0) goto L_0x0167
            org.jdom.Element r3 = r12.getChild(r2)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = r3.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r3 != 0) goto L_0x0167
            org.jdom.Element r2 = r12.getChild(r2)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r2 = r2.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01cc }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x01cc }
            r11.setHttpPort(r2)     // Catch:{ Exception -> 0x01cc }
        L_0x0167:
            org.jdom.Element r2 = r12.getChild(r1)     // Catch:{ Exception -> 0x01cc }
            if (r2 == 0) goto L_0x018e
            org.jdom.Element r2 = r12.getChild(r1)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r2 = r2.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r2 = r2.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r2 != 0) goto L_0x018e
            org.jdom.Element r1 = r12.getChild(r1)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r1 = r1.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01cc }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01cc }
            r11.setHttpsPort(r1)     // Catch:{ Exception -> 0x01cc }
        L_0x018e:
            org.jdom.Element r1 = r12.getChild(r0)     // Catch:{ Exception -> 0x01cc }
            if (r1 == 0) goto L_0x01b5
            org.jdom.Element r1 = r12.getChild(r0)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r1 = r1.getText()     // Catch:{ Exception -> 0x01cc }
            boolean r1 = r1.equals(r14)     // Catch:{ Exception -> 0x01cc }
            if (r1 != 0) goto L_0x01b5
            org.jdom.Element r0 = r12.getChild(r0)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = r0.getText()     // Catch:{ Exception -> 0x01cc }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01cc }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01cc }
            r11.setBboxPollingRate(r0)     // Catch:{ Exception -> 0x01cc }
        L_0x01b5:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "cfg"
            r0.put(r1, r11)
            sfs2x.client.core.SFSEvent r1 = new sfs2x.client.core.SFSEvent
            java.lang.String r2 = "configLoadSuccess"
            r1.<init>(r2, r0)
            sfs2x.client.core.EventDispatcher r0 = r15.dispatcher
            r0.dispatchEvent(r1)
            return
        L_0x01cc:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error parsing config file: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r2 = " "
            r1.append(r2)
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r15.onConfigLoadFailure(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.ConfigLoader.tryParse():void");
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public void loadConfig(String str) {
        try {
            this.xmldoc = new SAXBuilder(false).build(SAXBuilder.fileToURL(new File(str)));
            tryParse();
        } catch (MalformedURLException e2) {
            throw new JDOMException("Error in building", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            onConfigLoadFailure(GeneratedOutlineSupport.outline39(e3, new StringBuilder("Error loading config file: ")));
        }
    }
}
