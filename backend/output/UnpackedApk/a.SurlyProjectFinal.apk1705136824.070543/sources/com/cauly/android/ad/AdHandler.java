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
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class AdHandler {
    protected final String AD_SHAPE = "ad_shape";
    protected final String AD_TYPE = "ad_type";
    protected final String CODE = "code";
    protected final String COLOR = "color";
    protected final String CYCLE = "cycle";
    protected final String DESCRIPTION = "description";
    protected final String HANDLER = "adnetwork";
    protected final String HANDLER_APP_CODE = "adnetwork_app_code";
    protected final String HANDLER_URL = "adnetwork_url";
    protected final String ID = "id";
    protected final String IMG = "img";
    protected final String ISERIAL = "iserial";
    protected final String LINK = "link";
    protected final String MARKET = "market";
    protected final String PAY_TYPE = "pay_type";
    protected final String RETCODE = "retcode";
    protected final String RETMSG = "retmsg";
    protected final String Root = "response";
    protected final String SEND_INFORM = "send_inform";
    protected final String SHAPE_INFO = "shape_info";
    protected final String STRICT_LEVEL = "strict_level";
    protected final String TITLE = "title";
    protected ClientConnectionManager clientConnectionManager;
    protected HttpContext context;
    protected String feedUrlString = Constants.QA_SERVER_URL;
    protected HttpParams params;
    protected String tmpUrlString = Constants.QA_SERVER_URL;

    protected AdHandler(Context ctx, String addr, String port, String page, String code, String gender, String age, String gps, String scode, String version, String adtype, int c_time, int r_time, String lang, String provider, String manufacturer, String model, String network, AdData adData, String isVisible) {
        if (adData.getSsl().equalsIgnoreCase("Y")) {
            this.feedUrlString = "https://";
            this.feedUrlString = String.valueOf(this.feedUrlString) + "ad.cauly.co.kr" + ":" + "11100" + "/" + "caulyImpress";
        } else {
            this.feedUrlString = "http://";
            this.feedUrlString = String.valueOf(this.feedUrlString) + "ad.cauly.co.kr" + ":" + "11000" + "/" + "caulyImpress";
        }
        this.tmpUrlString = Constants.QA_SERVER_URL;
        if (adData.getGender().equalsIgnoreCase("Y") && !AdCommon.nullChk(gender).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "gender=" + gender;
        }
        if (adData.getAge().equalsIgnoreCase("Y") && !AdCommon.nullChk(age).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "age=" + age;
        }
        if (!AdCommon.nullChk(code).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "code=" + code;
        }
        if (adData.getGpsInfo().equalsIgnoreCase("Y") && !AdCommon.nullChk(gps).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "gps=" + gps;
        }
        if (!AdCommon.nullChk(scode).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "scode=" + scode;
        }
        if (!AdCommon.nullChk(version).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "version=" + version;
        }
        if (!AdCommon.nullChk(adtype).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "pay_type=" + adtype;
        }
        if (!"1.4.9".equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "sdk_version=" + "1.4.9";
        }
        if (!"Android".equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "platform=" + "Android";
        }
        if (adData.getLang().equalsIgnoreCase("Y") && !AdCommon.nullChk(lang).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "lang=" + lang;
        }
        if (adData.getManufacturer().equalsIgnoreCase("Y") && !AdCommon.nullChk(manufacturer).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "manufacturer=" + manufacturer;
        }
        if (adData.getModel().equalsIgnoreCase("Y") && !AdCommon.nullChk(model).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "model=" + model;
        }
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "retry=" + adData.getRetry();
        if (adData.getRetry().equals("Y")) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "retry_reason=" + adData.getRetryReason();
        }
        if (adData.getNetwork().equalsIgnoreCase("Y") && !AdCommon.nullChk(network).equals(Constants.QA_SERVER_URL)) {
            if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
                this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
            }
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "network=" + network;
        }
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "sdk_type=" + "composite";
        if (!this.tmpUrlString.equals(Constants.QA_SERVER_URL)) {
            this.tmpUrlString = String.valueOf(this.tmpUrlString) + "&";
        }
        this.tmpUrlString = String.valueOf(this.tmpUrlString) + "visible=" + isVisible;
        this.feedUrlString = String.valueOf(this.feedUrlString) + "?" + this.tmpUrlString;
    }

    /* access modifiers changed from: protected */
    public InputStream getInputStream(String ssl) {
        try {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", new EasySSLSocketFactory(), 443));
            this.params = new BasicHttpParams();
            this.params.setParameter("http.conn-manager.max-total", Integer.valueOf(1));
            this.params.setParameter("http.conn-manager.max-per-route", new ConnPerRouteBean(1));
            this.params.setParameter("http.protocol.expect-continue", Boolean.valueOf(false));
            HttpProtocolParams.setVersion(this.params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(this.params, "utf8");
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            if (ssl.equalsIgnoreCase("Y")) {
                credentialsProvider.setCredentials(new AuthScope("ad.cauly.co.kr", -1), null);
            } else {
                credentialsProvider.setCredentials(new AuthScope("ad.cauly.co.kr", -1), null);
            }
            this.clientConnectionManager = new ThreadSafeClientConnManager(this.params, schemeRegistry);
            this.context = new BasicHttpContext();
            this.context.setAttribute("http.auth.credentials-provider", credentialsProvider);
            HttpClient httpClient = new DefaultHttpClient(this.clientConnectionManager, this.params);
            HttpGet httpRequest = new HttpGet(this.feedUrlString);
            try {
                return new BufferedHttpEntity(httpClient.execute(httpRequest, this.context).getEntity()).getContent();
            } catch (IOException e) {
                e = e;
                HttpGet httpGet = httpRequest;
            }
        } catch (IOException e2) {
            e = e2;
        }
        throw new RuntimeException(e);
    }

    /* access modifiers changed from: protected */
    public List<Message_Ads> parse(String ssl) {
        final Message_Ads currentMessage = new Message_Ads();
        RootElement root = new RootElement("response");
        final List<Message_Ads> messages = new ArrayList<>();
        root.setEndElementListener(new EndElementListener() {
            public void end() {
                messages.add(currentMessage.copy());
            }
        });
        root.getChild("adnetwork_url").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_HANDLER_URL(body);
            }
        });
        root.getChild("adnetwork").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_HANDLER(body);
            }
        });
        root.getChild("adnetwork_app_code").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_HANDLER_APP_CODE(body);
            }
        });
        root.getChild("pay_type").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_PAY_TYPE(body);
            }
        });
        root.getChild("ad_type").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_AD_TYPE(body);
            }
        });
        root.getChild("ad_shape").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_AD_SHAPE(body);
            }
        });
        root.getChild("shape_info").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_SHAPE_INFO(body);
            }
        });
        root.getChild("link").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_LINK(body);
            }
        });
        root.getChild("code").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_CODE(body);
            }
        });
        root.getChild("id").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_ID(body);
            }
        });
        root.getChild("title").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_TITLE(body);
            }
        });
        root.getChild("description").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_DESCRIPTION(body);
            }
        });
        root.getChild("img").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_IMG(body);
            }
        });
        root.getChild("market").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_MARKET(body);
            }
        });
        root.getChild("color").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_COLOR(body);
            }
        });
        root.getChild("iserial").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_ISERIAL(body);
            }
        });
        root.getChild("retcode").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_RETCODE(body);
            }
        });
        root.getChild("retmsg").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_RETMSG(body);
            }
        });
        root.getChild("strict_level").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_STRICT_LEVEL(body);
            }
        });
        root.getChild("send_inform").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_SEND_INFORM(body);
            }
        });
        root.getChild("cycle").setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                currentMessage.setC_CYCLE(body);
            }
        });
        try {
            Xml.parse(getInputStream(ssl), Encoding.UTF_8, root.getContentHandler());
            return messages;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
