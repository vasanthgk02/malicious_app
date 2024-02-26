package com.cauly.android.ad;

import android.content.Context;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;
import android.util.Xml.Encoding;
import com.inmobi.androidsdk.impl.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class AdConfig {
    final String AGE;
    final String ALT_CPC_AD;
    final String ALT_CPM_AD;
    final String CHECK_NET_ONLOAD_MODULE;
    final String Child;
    final String GENDER;
    final String GPS_INFO;
    final String LANG;
    final String LOAD_3D_MODULE;
    final String MANUFACTURER;
    final String MODEL;
    final String NETWORK;
    final String REFRESH_PERIOD;
    final String REPORT_ACK;
    final String REQUEST_SEQ;
    final String REUSE_SEQ;
    final String Root;
    final String SSL;
    final String UNIQUE_APPD_ID;
    ClientConnectionManager clientConnectionManager;
    private URLConnection conn;
    HttpContext context;
    private final URL feedUrl;
    protected String feedUrlString;
    HttpParams params;
    protected String tmpUrlString;

    AdConfig(Context ctx, String code, String model, String scode, String version) {
        this.feedUrlString = Constants.QA_SERVER_URL;
        this.tmpUrlString = Constants.QA_SERVER_URL;
        this.Root = "config";
        this.Child = "impress_param";
        this.SSL = "ssl";
        this.REPORT_ACK = "report_ack";
        this.ALT_CPC_AD = "alt_cpc_ad";
        this.ALT_CPM_AD = "alt_cpm_ad";
        this.REFRESH_PERIOD = "refresh_period";
        this.UNIQUE_APPD_ID = "unique_app_id";
        this.GENDER = "gender";
        this.AGE = "age";
        this.MODEL = "model";
        this.LANG = "lang";
        this.REUSE_SEQ = "reuse_seq";
        this.REQUEST_SEQ = "request_seq";
        this.GPS_INFO = "gps_info";
        this.MANUFACTURER = "manufacturer";
        this.NETWORK = "network";
        this.CHECK_NET_ONLOAD_MODULE = "check_net_onload_module";
        this.LOAD_3D_MODULE = "load_3d_module";
        this.feedUrlString = "http://";
        this.feedUrlString = String.valueOf(this.feedUrlString) + "xconf.cauly.co.kr" + ":" + "5220" + "/" + "caulyXconf" + "?";
        this.tmpUrlString = Constants.QA_SERVER_URL;
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "sdk_type=" + "composite";
        if (!AdCommon.nullChk(code).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "code=" + code;
        }
        if (!AdCommon.nullChk(model).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "model=" + model;
        }
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "sdk_version=" + "1.4.9";
        if (!AdCommon.nullChk(version).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "version=" + version;
        }
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "platform=" + "Android";
        if (!AdCommon.nullChk(scode).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "scode=" + scode;
        }
        try {
            this.feedUrl = new URL(String.valueOf(this.feedUrlString) + this.tmpUrlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getInputStream() {
        try {
            this.conn = this.feedUrl.openConnection();
            this.conn.setConnectTimeout(3000);
            this.conn.setReadTimeout(3000);
            return this.conn.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public List<Message_Config> parse() {
        final Message_Config currentMessage = new Message_Config();
        RootElement root = new RootElement("config");
        final List<Message_Config> messages = new ArrayList<>();
        root.setEndElementListener(new EndElementListener() {
            public void end() {
                messages.add(currentMessage.copy());
            }
        });
        root.getChild("ssl").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_SSL(body);
            }
        });
        root.getChild("report_ack").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_REPORT_ACK(body);
            }
        });
        root.getChild("impress_param").getChild("gender").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_GENDER(body);
            }
        });
        root.getChild("impress_param").getChild("age").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_AGE(body);
            }
        });
        root.getChild("impress_param").getChild("model").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_MODEL(body);
            }
        });
        root.getChild("impress_param").getChild("lang").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_LANG(body);
            }
        });
        root.getChild("impress_param").getChild("reuse_seq").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_REUSE_SEQ(body);
            }
        });
        root.getChild("impress_param").getChild("request_seq").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_REQUEST_SEQ(body);
            }
        });
        root.getChild("impress_param").getChild("gps_info").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_GPS_INFO(body);
            }
        });
        root.getChild("impress_param").getChild("manufacturer").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_MANUFACTURER(body);
            }
        });
        root.getChild("impress_param").getChild("network").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_NETWORK(body);
            }
        });
        root.getChild("alt_cpc_ad").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_ALT_CPC_AD(body);
            }
        });
        root.getChild("alt_cpm_ad").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_ALT_CPM_AD(body);
            }
        });
        root.getChild("refresh_period").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_REFRESH_PERIOD(body);
            }
        });
        root.getChild("unique_app_id").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_UNIQUE_APPD_ID(body);
            }
        });
        try {
            Xml.parse(getInputStream(), Encoding.UTF_8, root.getContentHandler());
            return messages;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
