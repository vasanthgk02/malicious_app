package com.cauly.android.ad;

import android.content.Context;
import com.inmobi.androidsdk.impl.Constants;
import java.io.IOException;
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

public class AdClickHandler {
    private final int RESULT_ERROR = -1;
    private ClientConnectionManager clientConnectionManager;
    private HttpContext context;
    private String feedUrlString = Constants.QA_SERVER_URL;
    private HttpParams params;

    /* access modifiers changed from: 0000 */
    public void sendClickData(Context ctx, AdCommon adCommon, AdData adData, String param) {
        if (!adCommon.getAppCode().equals("0")) {
            if (adData.getSsl().equalsIgnoreCase("Y")) {
                this.feedUrlString = "https://";
                this.feedUrlString = String.valueOf(this.feedUrlString) + "click.cauly.co.kr" + ":" + "15100" + "/" + "caulyClick" + "?";
            } else {
                this.feedUrlString = "http://";
                this.feedUrlString = String.valueOf(this.feedUrlString) + "click.cauly.co.kr" + ":" + "15000" + "/" + "caulyClick" + "?";
            }
            this.feedUrlString = String.valueOf(this.feedUrlString) + "code=" + adCommon.getAppCode();
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "id=" + adData.getId();
            if (!AdCommon.nullChk(adCommon.getScode()).equals(Constants.QA_SERVER_URL)) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "scode=" + adCommon.getScode();
            }
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "platform=" + "Android";
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "sdk_version=" + "1.4.9";
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "pay_type=" + adData.getPayType();
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "lang=" + adCommon.getLang();
            if (!AdCommon.nullChk(adCommon.getVersion()).equals(Constants.QA_SERVER_URL)) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "version=" + adCommon.getVersion();
            }
            if (!AdCommon.nullChk(adCommon.getProvider()).equals(Constants.QA_SERVER_URL)) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "provider=" + adCommon.getProvider();
            }
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "manufacturer=" + adCommon.getManufacturer();
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "model=" + adCommon.getModel();
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "iserial=" + adData.getIserial();
            if (adData.getUniqCode().equalsIgnoreCase("Y")) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "unique_app_id=" + ctx.getPackageName();
            }
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "sdk_type=" + "composite";
            if (adData.getPayType().equals("cpc")) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "strict_level=" + adData.getStrictLevel();
            }
            if (!AdCommon.nullChk(param).equals(Constants.QA_SERVER_URL)) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + param;
            }
            this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "retry=" + adData.getRetry();
            if (adData.getRetry().equals("Y")) {
                this.feedUrlString = String.valueOf(this.feedUrlString) + "&" + "retry_reason=" + adData.getRetryReason();
            }
            connect(this.feedUrlString, adData.getSsl());
        }
    }

    private int connect(String clickurl, String ssl) {
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
                credentialsProvider.setCredentials(new AuthScope("click.cauly.co.kr", -1), null);
            } else {
                credentialsProvider.setCredentials(new AuthScope("click.cauly.co.kr", -1), null);
            }
            this.clientConnectionManager = new ThreadSafeClientConnManager(this.params, schemeRegistry);
            this.context = new BasicHttpContext();
            this.context.setAttribute("http.auth.credentials-provider", credentialsProvider);
            HttpClient httpClient = new DefaultHttpClient(this.clientConnectionManager, this.params);
            HttpGet httpRequest = new HttpGet(clickurl);
            try {
                new BufferedHttpEntity(httpClient.execute(httpRequest, this.context).getEntity()).getContent().close();
                HttpGet httpGet = httpRequest;
            } catch (IOException e) {
                e = e;
                HttpGet httpGet2 = httpRequest;
                e.printStackTrace();
                return -1;
            }
        } catch (IOException e2) {
            e = e2;
        }
        return -1;
    }
}
