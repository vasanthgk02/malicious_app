package com.cauly.android.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.IMAdView;
import com.inmobi.androidsdk.IMAdView.AnimationType;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class AdView extends RelativeLayout {
    /* access modifiers changed from: private */
    public static String SAVE_PATH = null;
    private static String SDCARD_PATH = null;
    /* access modifiers changed from: private */
    public static AdCommon adCommon = null;
    private static AdConfig adConfig = null;
    /* access modifiers changed from: private */
    public static AdData adData = null;
    /* access modifiers changed from: private */
    public static AdHandler adHandler = null;
    /* access modifiers changed from: private */
    public static AdLayout adLayout = null;
    private static String code = null;
    /* access modifiers changed from: private */
    public static double lat = 0.0d;
    private static final String line_page_ad = "text, banner, rich";
    /* access modifiers changed from: private */
    public static double lng;
    private static Timer reloadTimer = null;
    /* access modifiers changed from: private */
    public static String scode;
    private static Handler threadHandler = null;
    /* access modifiers changed from: private */
    public static String time_stamp;
    private File CONFIG_DIR;
    private File CONFIG_FILE;
    /* access modifiers changed from: private */
    public boolean ConnectedFail;
    /* access modifiers changed from: private */
    public File FILE_DIR;
    /* access modifiers changed from: private */
    public File NOMEDIA_FILE;
    private File SCODE_FILE;
    /* access modifiers changed from: private */
    public boolean XconfFail;
    /* access modifiers changed from: private */
    public Bitmap adImage;
    /* access modifiers changed from: private */
    public AdListener adListener;
    /* access modifiers changed from: private */
    public String adtype;
    /* access modifiers changed from: private */
    public String age;
    /* access modifiers changed from: private */
    public String allowcall;
    /* access modifiers changed from: private */
    public String appcode;
    private Bitmap background_default;
    private BitmapDrawable background_drawable;
    /* access modifiers changed from: private */
    public Display display;
    /* access modifiers changed from: private */
    public boolean dynamicReloadInterval;
    private String effect;
    /* access modifiers changed from: private */
    public String error_code;
    /* access modifiers changed from: private */
    public String error_msg;
    /* access modifiers changed from: private */
    public String gender;
    /* access modifiers changed from: private */
    public String gps;
    /* access modifiers changed from: private */
    public IMAdView imAdView;
    /* access modifiers changed from: private */
    public boolean isFirst;
    /* access modifiers changed from: private */
    public boolean isLoading;
    private boolean isReload;
    /* access modifiers changed from: private */
    public String isVisible;
    /* access modifiers changed from: private */
    public String lang;
    /* access modifiers changed from: private */
    public String lat_lng;
    /* access modifiers changed from: private */
    public int layout_height;
    private LocationManager lm;
    private LocationListener locationListener;
    /* access modifiers changed from: private */
    public IMAdRequest mAdRequest;
    /* access modifiers changed from: private */
    public IMAdListener mIMAdListener;
    /* access modifiers changed from: private */
    public String manufacturer;
    /* access modifiers changed from: private */
    public List<Message_Ads> messages;
    private boolean min_refresh;
    /* access modifiers changed from: private */
    public String model;
    private List<Message_Config> msg_config;
    /* access modifiers changed from: private */
    public String network;
    /* access modifiers changed from: private */
    public String provider;
    /* access modifiers changed from: private */
    public int reloadInterval;
    /* access modifiers changed from: private */
    public String retry;
    /* access modifiers changed from: private */
    public String retry_reason;
    private Rotate3dAnimation rotation;
    /* access modifiers changed from: private */
    public int total_layout_width;
    /* access modifiers changed from: private */
    public String version;

    class CaulyAsyncTask extends WeakAsyncTask<Void, Void, Void, AdView> {
        public CaulyAsyncTask(AdView target) {
            super(target);
            AdView.this.isLoading = true;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x021c, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x021d, code lost:
            com.cauly.android.ad.AdView.access$10(r32.this$0, false);
            com.cauly.android.ad.AdView.access$11(r32.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x022c, code lost:
            throw r2;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x021c A[ExcHandler: all (r2v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(com.cauly.android.ad.AdView r33, java.lang.Void... r34) {
            /*
                r32 = this;
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                int r3 = com.cauly.android.ad.AdInfo.priority
                r2.setPriority(r3)
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r3 = 0
                r2.ConnectedFail = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r2 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = r3.adtype     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r4 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r4 = r4.appcode     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r5 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r5 = r5.gender     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r6 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r6 = r6.age     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r7 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r7 = r7.lat_lng     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r8 = com.cauly.android.ad.AdView.scode     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r9 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r9 = r9.version     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r10 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r10 = r10.lang     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r11 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r11 = r11.provider     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r12 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r12 = r12.manufacturer     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r13 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r13 = r13.model     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r14 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r14 = r14.allowcall     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r15 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r15 = r15.network     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.initCommon(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                boolean r2 = r2.isFirst     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                if (r2 == 0) goto L_0x01cc
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.CheckConifgInfo()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
            L_0x008d:
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r2 = r2.adtype     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "cpc"
                boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                if (r2 == 0) goto L_0x00d5
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                boolean r2 = r2.dynamicReloadInterval     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                if (r2 == 0) goto L_0x00d5
                com.cauly.android.ad.AdData r2 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r2 = r2.getRefreshPeriod()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = ""
                boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                if (r2 == 0) goto L_0x00c0
                com.cauly.android.ad.AdData r2 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "30"
                r2.setRefreshPeriod(r3)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
            L_0x00c0:
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = r3.getRefreshPeriod()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                int r3 = r3 * 1000
                r2.reloadInterval = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
            L_0x00d5:
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.isVisibilityCheck()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.setRetryData()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdHandler r2 = new com.cauly.android.ad.AdHandler     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r4 = "ad.cauly.co.kr"
                java.lang.String r5 = "11000"
                java.lang.String r6 = "caulyImpress"
                com.cauly.android.ad.AdCommon r7 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r7 = r7.getAppCode()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r8 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r8 = r8.getGender()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r9 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r9 = r9.getAge()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r10 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r10 = r10.getGpsInfo()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r11 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r11 = r11.getScode()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r12 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r12 = r12.getVersion()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r13 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r13 = r13.getAdType()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r14 = 10000(0x2710, float:1.4013E-41)
                r15 = 10000(0x2710, float:1.4013E-41)
                com.cauly.android.ad.AdCommon r16 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r16 = r16.getLang()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r17 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r17 = r17.getProvider()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r18 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r18 = r18.getManufacturer()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r19 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r19 = r19.getModel()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdCommon r20 = com.cauly.android.ad.AdView.adCommon     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r20 = r20.getNetwork()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdData r21 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r0 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r22 = r0
                java.lang.String r22 = r22.isVisible     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdView.adHandler = r2     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.Retrytheinitialization()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r4 = 10
                long r2 = r2 * r4
                java.lang.String r2 = java.lang.Long.toString(r2)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdView.time_stamp = r2     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                com.cauly.android.ad.AdHandler r3 = com.cauly.android.ad.AdView.adHandler     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                com.cauly.android.ad.AdData r4 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                java.lang.String r4 = r4.getSsl()     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                java.util.List r3 = r3.parse(r4)     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                r2.messages = r3     // Catch:{ Exception -> 0x01ed, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.util.List r2 = r2.messages     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                int r29 = r2.size()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r29 <= 0) goto L_0x01bb
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.util.List r2 = r2.messages     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x01b5:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 != 0) goto L_0x022d
            L_0x01bb:
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this
                r3 = 0
                r2.isFirst = r3
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this
                r2.startReloadTimer()
            L_0x01ca:
                r2 = 0
                return r2
            L_0x01cc:
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.getNetworkState()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.getGpsInfo()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                goto L_0x008d
            L_0x01dc:
                r2 = move-exception
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this
                r3 = 0
                r2.isFirst = r3
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this
                r2.startReloadTimer()
                goto L_0x01ca
            L_0x01ed:
                r25 = move-exception
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r3 = 1
                r2.ConnectedFail = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r2 = "Cauly Ads"
                java.lang.String r3 = "Connection to the server failed"
                android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "500"
                r2.error_code = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "Server error"
                r2.error_msg = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdData r2 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.init()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.<init>()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                throw r2     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
            L_0x021c:
                r2 = move-exception
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this
                r4 = 0
                r3.isFirst = r4
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this
                r3.startReloadTimer()
                throw r2
            L_0x022d:
                java.lang.Object r30 = r2.next()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.Message_Ads r30 = (com.cauly.android.ad.Message_Ads) r30     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_HANDLER()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setHandler(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_HANDLER_URL()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setHandlerUrl(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_HANDLER_APP_CODE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setHandlerAppCode(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_PAY_TYPE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setPayType(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_AD_TYPE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setAdType(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_AD_SHAPE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setAdShape(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_SHAPE_INFO()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setShapeInfo(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_LINK()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setLink(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_CODE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setCode(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_ID()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setId(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_TITLE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setTitle(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_DESCRIPTION()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setDescription(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_IMG()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setImg(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_MARKET()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setMarket(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_COLOR()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.BackgroundImage(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setColor(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_ISERIAL()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setIserial(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_RETCODE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setRetCode(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_RETMSG()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setRetMsg(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_STRICT_LEVEL()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setStrictLevel(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_SEND_INFORM()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setSendInForm(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r30.getC_CYCLE()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdCommon.nullChk(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.setCycle(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getStrictLevel()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x038b
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "1"
                r3.setStrictLevel(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x038b:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getSendInForm()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x03a4
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "Y"
                r3.setSendInForm(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x03a4:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getCycle()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x03bd
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "4"
                r3.setCycle(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x03bd:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getRetCode()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 != 0) goto L_0x03dc
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                com.cauly.android.ad.AdData r4 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = r4.getRetCode()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.error_code = r4     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x03dc:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getImg()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 != 0) goto L_0x01b5
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.getId()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "0"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x042d
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.error_code     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = com.cauly.android.ad.AdCommon.nullChk(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "0"
                boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 != 0) goto L_0x0424
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.error_code     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = com.cauly.android.ad.AdCommon.nullChk(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = ""
                boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x042d
            L_0x0424:
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = "100"
                r3.error_code = r4     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x042d:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r31 = r3.getImg()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = "/"
                r0 = r31
                int r3 = r0.lastIndexOf(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                int r3 = r3 + 1
                r0 = r31
                java.lang.String r27 = r0.substring(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.io.File r26 = new java.io.File     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = com.cauly.android.ad.AdView.SAVE_PATH     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r3.<init>(r4)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r0 = r27
                java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r0 = r26
                r0.<init>(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.io.File r24 = new java.io.File     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                java.lang.String r3 = com.cauly.android.ad.AdView.SAVE_PATH     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r0 = r24
                r0.<init>(r3)     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                boolean r3 = r24.isDirectory()     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x0477
                r24.mkdir()     // Catch:{ Exception -> 0x05b7 }
            L_0x0477:
                boolean r3 = r26.exists()     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x051b
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x04cd
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY-3DTEST"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x04cd
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY-RICHADTEST"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x04cd
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.adtype     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "cpm"
                boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 == 0) goto L_0x04cd
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.getId()     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "0"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x04d8
            L_0x04cd:
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r4 = com.cauly.android.ad.AdView.downloadBitmap(r31)     // Catch:{ Exception -> 0x05b7 }
                r3.adImage = r4     // Catch:{ Exception -> 0x05b7 }
            L_0x04d8:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x05b7 }
                r0 = r32
                com.cauly.android.ad.AdView r4 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r4 = r4.adImage     // Catch:{ Exception -> 0x05b7 }
                r3.setAdImage(r4)     // Catch:{ Exception -> 0x05b7 }
            L_0x04e7:
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                android.graphics.Bitmap r3 = r3.adImage     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x01b5
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r4 = 0
                r3.adImage = r4     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                goto L_0x01b5
            L_0x04fb:
                r25 = move-exception
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "-100"
                r2.error_code = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r0 = r32
                com.cauly.android.ad.AdView r2 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.String r3 = "SDK error ( Data Parsing Error )"
                r2.error_msg = r3     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                com.cauly.android.ad.AdData r2 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.init()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                r2.<init>()     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
                throw r2     // Catch:{ Exception -> 0x01dc, all -> 0x021c }
            L_0x051b:
                java.io.FileInputStream r28 = new java.io.FileInputStream     // Catch:{ Exception -> 0x05b7 }
                r0 = r28
                r1 = r26
                r0.<init>(r1)     // Catch:{ Exception -> 0x05b7 }
                java.io.BufferedInputStream r23 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x05b7 }
                r3 = 1024(0x400, float:1.435E-42)
                r0 = r23
                r1 = r28
                r0.<init>(r1, r3)     // Catch:{ Exception -> 0x05b7 }
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                com.cauly.android.ad.AdView$FlushedInputStream r4 = new com.cauly.android.ad.AdView$FlushedInputStream     // Catch:{ Exception -> 0x05b7 }
                r0 = r23
                r4.<init>(r0)     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ Exception -> 0x05b7 }
                r3.adImage = r4     // Catch:{ Exception -> 0x05b7 }
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r3 = r3.adImage     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x05a6
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x059b
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY-3DTEST"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x059b
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.appcode     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "CAULY-RICHADTEST"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x059b
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.adtype     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "cpm"
                boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 == 0) goto L_0x059b
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r3 = r3.getId()     // Catch:{ Exception -> 0x05b7 }
                java.lang.String r4 = "0"
                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x05b7 }
                if (r3 != 0) goto L_0x05a6
            L_0x059b:
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r4 = com.cauly.android.ad.AdView.downloadBitmap(r31)     // Catch:{ Exception -> 0x05b7 }
                r3.adImage = r4     // Catch:{ Exception -> 0x05b7 }
            L_0x05a6:
                com.cauly.android.ad.AdData r3 = com.cauly.android.ad.AdView.adData     // Catch:{ Exception -> 0x05b7 }
                r0 = r32
                com.cauly.android.ad.AdView r4 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x05b7 }
                android.graphics.Bitmap r4 = r4.adImage     // Catch:{ Exception -> 0x05b7 }
                r3.setAdImage(r4)     // Catch:{ Exception -> 0x05b7 }
                goto L_0x04e7
            L_0x05b7:
                r25 = move-exception
                java.lang.String r3 = "Cauly Ads"
                java.lang.String r4 = "File Save/Load failed"
                android.util.Log.i(r3, r4)     // Catch:{ all -> 0x05d3 }
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                android.graphics.Bitmap r3 = r3.adImage     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x01b5
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r4 = 0
                r3.adImage = r4     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                goto L_0x01b5
            L_0x05d3:
                r2 = move-exception
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                android.graphics.Bitmap r3 = r3.adImage     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                if (r3 == 0) goto L_0x05e6
                r0 = r32
                com.cauly.android.ad.AdView r3 = com.cauly.android.ad.AdView.this     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
                r4 = 0
                r3.adImage = r4     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            L_0x05e6:
                throw r2     // Catch:{ Exception -> 0x04fb, all -> 0x021c }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cauly.android.ad.AdView.CaulyAsyncTask.doInBackground(com.cauly.android.ad.AdView, java.lang.Void[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(AdView target, Void result) {
            try {
                int display_width = AdView.this.display.getWidth();
                int display_height = AdView.this.display.getHeight();
                AdView.this.layout_height = 0;
                if (display_height > display_width) {
                    AdView.this.layout_height = display_height / 10;
                } else {
                    AdView.this.layout_height = display_width / 10;
                }
                if (AdView.adData.getHandler().equals("inmobi")) {
                    new Thread(new adNetworkCheck("composite", "0", AdView.this.version, "1.4.9", "Android", AdView.this.appcode, AdView.this.model, AdView.scode, AdView.adData.getIserial(), AdView.adData.getAdShape(), AdView.adData.getPayType(), AdView.adData.getHandler())).start();
                    try {
                        if (!(AdView.adLayout == null || AdView.adLayout.adWebView == null)) {
                            AdView.adLayout.adWebView.getSettings().setDefaultZoom(ZoomDensity.MEDIUM);
                        }
                    } catch (Exception e) {
                    }
                    AdView.this.setPrevAdsAnimation(AdView.adLayout);
                    AdCommon.recursiveRecycle(AdView.adLayout);
                    AdView.adLayout = new AdLayout(AdView.this.getContext().getApplicationContext());
                    AdView.adLayout.setVisibility(0);
                    AdView.adLayout.setGravity(17);
                    AdView.adLayout.setBackgroundColor(0);
                    AdView.adLayout.setAnimationCacheEnabled(false);
                    LayoutParams layoutParams = new LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    AdView.adLayout.setLayoutParams(layoutParams);
                    float scale = AdView.this.getContext().getApplicationContext().getResources().getDisplayMetrics().density;
                    int width = (int) ((320.0f * scale) + 0.5f);
                    int height = (int) ((48.0f * scale) + 0.5f);
                    if (AdView.this.mAdRequest == null) {
                        AdView.this.mAdRequest = new IMAdRequest();
                        AdView.this.mAdRequest.setTestMode(false);
                    }
                    if (AdView.this.imAdView == null) {
                        AdView.this.imAdView = new IMAdView((Activity) AdView.this.getContext(), 9, AdView.adData.getHandlerAppCode());
                        AdView.this.imAdView.setAdSlot(9);
                        AdView.this.imAdView.setAnimationType(AnimationType.ANIMATION_OFF);
                        AdView.this.imAdView.setRefreshInterval(-1);
                        AdView.this.imAdView.setIMAdRequest(AdView.this.mAdRequest);
                        LayoutParams layoutParams2 = new LayoutParams(width, height);
                        layoutParams2.addRule(13);
                        AdView.this.imAdView.setLayoutParams(layoutParams2);
                        AdView.this.imAdView.setGravity(17);
                        AdView.this.imAdView.setBackgroundColor(0);
                    }
                    AdView.this.imAdView.setIMAdListener(AdView.this.mIMAdListener);
                    AdView.this.imAdView.loadNewAd();
                } else if (AdView.adData.getId().equals(Constants.QA_SERVER_URL) || AdView.adData.getAdShape().equals(Constants.QA_SERVER_URL) || AdView.adData.getAdType().equals(Constants.QA_SERVER_URL)) {
                    throw new RuntimeException();
                } else {
                    AdView.this.setPrevAdsAnimation(AdView.adLayout);
                    AdCommon.recursiveRecycle(AdView.adLayout);
                    AdView.adLayout = new AdLayout(AdView.this.getContext().getApplicationContext());
                    AdView.adLayout.setVisibility(0);
                    AdView.adLayout.setGravity(17);
                    AdView.adLayout.setBackgroundColor(0);
                    if (AdView.line_page_ad.contains(AdView.adData.getAdShape().toString())) {
                        LayoutParams layoutParams3 = new LayoutParams(-1, AdView.this.layout_height);
                        layoutParams3.addRule(13);
                        AdView.adLayout.setLayoutParams(layoutParams3);
                        AdView.this.setCurrentAdsAnimation(AdView.adLayout);
                    } else {
                        LayoutParams layoutParams4 = new LayoutParams(-1, -1);
                        layoutParams4.addRule(13);
                        AdView.adLayout.setLayoutParams(layoutParams4);
                    }
                    AdView.adLayout.setAdData(AdView.adData, AdView.adCommon, AdView.this.layout_height, AdView.this.adListener);
                    AdView.this.removeAllViews();
                    AdView.this.addView(AdView.adLayout);
                    AdView.adData.setAdImage(null);
                    if (AdView.this.adListener != null) {
                        AdView.this.adListener.onReceiveAd();
                    }
                    if (AdView.adData.getSendInForm().equals("Y")) {
                        new Thread(new impressCheck(Integer.parseInt(AdView.adData.getCycle()), "composite", AdView.adData.getId(), AdView.this.version, "1.4.9", "Android", AdView.this.appcode, AdView.this.model, AdView.scode, AdView.adData.getIserial(), AdView.adData.getRetry(), AdView.adData.getRetryReason())).start();
                    }
                }
            } catch (Exception e2) {
                if (!AdView.this.adtype.equalsIgnoreCase("cpm") || !AdView.adData.getId().equals("0")) {
                    AdView.this.error_code = "-100";
                    AdView.this.error_msg = "SDK error ( Failed to Layout )";
                    AdView.this.defaultAds();
                } else {
                    AdView.this.error_code = "100";
                    throw new RuntimeException();
                }
            } catch (Exception e3) {
                AdView.this.defaultAds();
                AdView.this.isFirst = false;
                AdView.this.isLoading = false;
                AdView.this.clearDisappearingChildren();
                AdView.this.clearAnimation();
                return;
            } catch (Throwable th) {
                AdView.this.isFirst = false;
                AdView.this.isLoading = false;
                AdView.this.clearDisappearingChildren();
                AdView.this.clearAnimation();
                throw th;
            }
            if (AdView.adData.getReportAck().equalsIgnoreCase("Y")) {
                AdCommon.Ad_Log_Info("Android", AdCommon.nullChk(AdView.adData.getIserial()), Constants.QA_SERVER_URL, AdView.this.XconfFail);
            }
            AdView.this.isFirst = false;
            AdView.this.isLoading = false;
            AdView.this.clearDisappearingChildren();
            AdView.this.clearAnimation();
        }
    }

    class CaulyLocationListener implements LocationListener {
        CaulyLocationListener() {
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                AdView.lat = location.getLatitude();
                AdView.lng = location.getLongitude();
                AdView.this.gps = AdView.lat + "," + AdView.lng;
            }
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

    private final class DisplayRolling implements AnimationListener {
        private DisplayRolling() {
        }

        /* synthetic */ DisplayRolling(AdView adView, DisplayRolling displayRolling) {
            this();
        }

        public void onAnimationEnd(Animation animation) {
            try {
                if (AdView.adLayout != null) {
                    Rotate3dAnimation rotation = new Rotate3dAnimation(180.0f, 360.0f, ((float) AdView.this.total_layout_width) / 2.0f, 0.0f, 0.0f, false);
                    rotation.setDuration(500);
                    rotation.setFillAfter(true);
                    rotation.setInterpolator(new AccelerateInterpolator());
                    AdView.adLayout.startAnimation(rotation);
                }
            } catch (Exception e) {
                Log.i("Cauly Ads", "Animation Error!");
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public long skip(long n) throws IOException {
            long totalBytesSkipped = 0;
            while (totalBytesSkipped < n) {
                long bytesSkipped = this.in.skip(n - totalBytesSkipped);
                if (bytesSkipped == 0) {
                    if (read() < 0) {
                        break;
                    }
                    bytesSkipped = 1;
                }
                totalBytesSkipped += bytesSkipped;
            }
            return totalBytesSkipped;
        }
    }

    private class adNetworkCheck implements Runnable {
        private final String adShape;
        private final String adsCd;
        private final String code;
        private final String iserial;
        private final String model;
        private final String partner;
        private final String payType;
        private final String platform;
        private final String scode;
        private final String sdkType;
        private final String sdkVersion;
        private final String version;

        public adNetworkCheck(String sdkType2, String adsCd2, String version2, String sdkVersion2, String platform2, String code2, String model2, String scode2, String iserial2, String adShape2, String payType2, String partner2) {
            this.sdkType = sdkType2;
            this.adsCd = adsCd2;
            this.version = version2;
            this.sdkVersion = sdkVersion2;
            this.platform = platform2;
            this.code = code2;
            this.model = model2;
            this.scode = scode2;
            this.iserial = iserial2;
            this.adShape = adShape2;
            this.payType = payType2;
            this.partner = partner2;
        }

        public void run() {
            AdCommon.AdNetwork_Info(this.sdkType, this.adsCd, this.version, this.sdkVersion, this.platform, this.code, this.model, this.scode, this.iserial, this.adShape, this.payType, this.partner);
        }
    }

    private class impressCheck implements Runnable {
        private final String adsCd;
        private final String code;
        private final String iserial;
        private final int limit;
        private final String model;
        private final String platform;
        private final String retry;
        private final String retry_reason;
        private final String scode;
        private final String sdkType;
        private final String sdkVersion;
        private final String version;

        public impressCheck(int limit2, String sdkType2, String adsCd2, String version2, String sdkVersion2, String platform2, String code2, String model2, String scode2, String iserial2, String retry2, String retry_reason2) {
            this.limit = limit2;
            this.sdkType = sdkType2;
            this.adsCd = adsCd2;
            this.version = version2;
            this.sdkVersion = sdkVersion2;
            this.platform = platform2;
            this.code = code2;
            this.model = model2;
            this.scode = scode2;
            this.iserial = iserial2;
            this.retry = retry2;
            this.retry_reason = retry_reason2;
        }

        public void run() {
            int count = 0;
            int result = 0;
            while (count < this.limit) {
                try {
                    if (AdView.this.getWindowVisibility() != 0 || AdView.this.getVisibility() != 0) {
                        break;
                    }
                    result++;
                    Thread.sleep(500);
                    count++;
                } catch (InterruptedException e) {
                    Log.i("Cauly Ads", "impressCheck failed");
                }
            }
            if (result == this.limit) {
                AdCommon.Impress_Info(this.sdkType, this.adsCd, this.version, this.sdkVersion, this.platform, this.code, this.model, this.scode, this.iserial, this.retry, this.retry_reason);
            }
        }
    }

    public AdView(Context context) {
        this(context, null, 0);
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.isReload = false;
        this.isLoading = false;
        this.ConnectedFail = false;
        this.XconfFail = false;
        this.isFirst = true;
        this.min_refresh = true;
        this.background_default = null;
        this.background_drawable = null;
        this.adImage = null;
        this.imAdView = null;
        this.mAdRequest = null;
        this.mIMAdListener = new IMAdListener() {
            public void onShowAdScreen(IMAdView adView) {
            }

            public void onDismissAdScreen(IMAdView adView) {
            }

            public void onAdRequestFailed(IMAdView adView, ErrorCode errorCode) {
                AdView.this.retry = "Y";
                AdView.this.retry_reason = errorCode;
                AdView.this.reloadAD();
            }

            public void onAdRequestCompleted(IMAdView adView) {
                try {
                    AdCommon.unbindViewReferences(AdView.this.imAdView);
                    AdView.this.imAdView.destroyDrawingCache();
                    AdView.this.imAdView = null;
                    AdView.adLayout.addView(adView);
                    AdView.this.setCurrentAdsAnimation(AdView.adLayout);
                    AdView.this.addView(AdView.adLayout);
                    if (AdView.this.adListener != null) {
                        AdView.this.adListener.onReceiveAd();
                    }
                } catch (Exception e) {
                    AdView.this.retry = "Y";
                    AdView.this.retry_reason = "Not_completed_the_process";
                    AdView.this.reloadAD();
                }
            }

            public void onLeaveApplication(IMAdView adView) {
            }
        };
        setFocusable(true);
        if (attrs != null) {
            setAtrribute(attrs);
        } else {
            setAdRequestData();
        }
        getDeviceinfo();
        init();
    }

    private void setAtrribute(AttributeSet attrs) {
        String caulyNameSpace = "http://schemas.android.com/apk/res/" + getContext().getApplicationContext().getPackageName();
        this.appcode = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "appcode"));
        this.adtype = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "adtype")).toLowerCase();
        this.gender = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "gender")).toLowerCase();
        this.age = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "age")).toLowerCase();
        this.gps = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "gps")).toLowerCase();
        this.effect = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "effect")).toLowerCase();
        this.allowcall = AdCommon.nullChk(attrs.getAttributeValue(caulyNameSpace, "allowcall")).toLowerCase();
        this.reloadInterval = attrs.getAttributeIntValue(caulyNameSpace, "reloadInterval", 0);
        this.dynamicReloadInterval = attrs.getAttributeBooleanValue(caulyNameSpace, "dynamicReloadInterval", true);
    }

    private void setAdRequestData() {
        this.appcode = AdCommon.nullChk(AdInfo.appcode);
        this.adtype = AdCommon.nullChk(AdInfo.adtype).toLowerCase();
        this.gender = AdCommon.nullChk(AdInfo.gender).toLowerCase();
        this.age = AdCommon.nullChk(AdInfo.age).toLowerCase();
        this.gps = AdCommon.nullChk(AdInfo.gps).toLowerCase();
        this.effect = AdCommon.nullChk(AdInfo.effect).toLowerCase();
        this.allowcall = AdCommon.nullChk(AdInfo.allowcall).toLowerCase();
        this.reloadInterval = AdInfo.reloadInterval;
        this.dynamicReloadInterval = AdInfo.dynamicReloadInterval;
    }

    private void getDeviceinfo() {
        this.version = VERSION.RELEASE;
        this.lang = Locale.getDefault().getLanguage();
        this.manufacturer = Build.MANUFACTURER.replace(" ", "_");
        this.model = Build.MODEL.replace(" ", "_");
        this.reloadInterval = getreloadInterval(this.reloadInterval);
    }

    private void init() {
        Log.i("Cauly Ads", "SDK_VERSION = 1.4.9, SDK_TYPE = composite, AD_TYPE = " + this.adtype);
        Retrytheinitialization();
        adLayout = null;
        SAVE_PATH = "/data/data/" + getContext().getApplicationContext().getPackageName() + "/cauly_ad_img/";
        SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.SCODE_FILE = new File(String.valueOf(SDCARD_PATH) + "/Cauly/code.txt");
        this.NOMEDIA_FILE = new File(String.valueOf(SDCARD_PATH) + "/Cauly/.nomedia");
        this.CONFIG_FILE = new File("/data/data/" + getContext().getApplicationContext().getPackageName() + "/cauly/config.txt");
        this.CONFIG_DIR = new File("/data/data/" + getContext().getApplicationContext().getPackageName() + "/cauly/");
        this.FILE_DIR = new File(String.valueOf(SDCARD_PATH) + "/Cauly");
        this.display = ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay();
        scode = getcodeCheck();
        getNetworkState();
        int width = this.display.getWidth();
        if (checkAttrs()) {
            getGpsInfo();
            DownLoadCheck();
            noMediaCheck();
            adCommon = new AdCommon();
            adData = new AdData();
            this.adListener = null;
            threadHandler = new Handler();
            if (super.getVisibility() != 0) {
                return;
            }
            if (!this.adtype.equalsIgnoreCase("cpc")) {
                reloadAD();
                this.reloadInterval = 0;
            } else if (width >= 320) {
                reloadAD();
            } else {
                this.reloadInterval = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    public void Retrytheinitialization() {
        this.retry = "N";
        this.retry_reason = Constants.QA_SERVER_URL;
    }

    /* access modifiers changed from: private */
    public void setRetryData() {
        adData.setRetry(this.retry);
        adData.setRetryReason(this.retry_reason);
    }

    private boolean checkAttrs() {
        if (Build.BRAND.equals("generic")) {
            Log.i("Cauly Ads", "Emulator!");
        }
        if (this.network.equals("permission")) {
            Log.i("Cauly Ads", "Need ACCESS_NETWORK_STATE permission");
        }
        if (this.appcode == Constants.QA_SERVER_URL) {
            Log.i("Cauly Ads", "Input your appCode in AdView Layout parameter");
        }
        if (this.appcode.equals("CAULY") || this.appcode.equals("CAULY-3DTEST") || this.appcode.equals("CAULY-RICHADTEST")) {
            Log.i("Cauly Ads", "default app_code!");
        }
        if (this.reloadInterval == 0) {
            this.isReload = false;
        } else if (this.reloadInterval < 30) {
            Log.i("Cauly Ads", "Reload Inteval must be lager than 30 sec");
        } else if (this.reloadInterval > 120) {
            Log.i("Cauly Ads", "Reload Inteval must be smaller than 120 sec");
        } else {
            this.reloadInterval *= 1000;
            this.isReload = true;
        }
        if (!this.gender.equalsIgnoreCase("male") && !this.gender.equalsIgnoreCase("female")) {
            this.gender = "all";
        }
        if (!this.age.equals("10") && !this.age.equals("20") && !this.age.equals("30") && !this.age.equals("40") && !this.age.equals("50")) {
            this.age = "all";
        }
        if (!this.effect.equalsIgnoreCase("circle") && !this.effect.equalsIgnoreCase("half") && !this.effect.equalsIgnoreCase("bottom_slide") && !this.effect.equalsIgnoreCase("left_slide") && !this.effect.equalsIgnoreCase("top_slide")) {
            this.effect = "default";
        }
        if (!this.allowcall.equalsIgnoreCase("yes") && !this.allowcall.equalsIgnoreCase("no")) {
            this.allowcall = "yes";
        }
        if (!this.gps.equalsIgnoreCase("auto") && !this.gps.equalsIgnoreCase("off")) {
            this.gps = "off";
        }
        return true;
    }

    private void DefaultConifgInfo() {
        adData.setSsl("N");
        adData.setReportAck("N");
        adData.setAltCpcAd(Constants.QA_SERVER_URL);
        adData.setAltCpmAd(Constants.QA_SERVER_URL);
        adData.setGender("N");
        adData.setAge("N");
        adData.setModel("N");
        adData.setLang("N");
        adData.setReuseSeq("N");
        adData.setRequestSeq("N");
        adData.setGpsInfo("N");
        adData.setManufacturer("N");
        adData.setNetwork("N");
        adData.setRefreshPeriod("30");
        adData.setUniqCode("Y");
        adData.setCheckNetOnloadModule("Y");
        adData.setLoad3dModule("N");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[Catch:{ Exception -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ Exception -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x02b8 A[Catch:{ Exception -> 0x03c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x03bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setConifgInfo() {
        /*
            r13 = this;
            r12 = 0
            r9 = 0
            com.cauly.android.ad.AdConfig r0 = new com.cauly.android.ad.AdConfig     // Catch:{ Exception -> 0x03a5 }
            android.content.Context r1 = r13.getContext()     // Catch:{ Exception -> 0x03a5 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r13.appcode     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r3 = r13.model     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r4 = scode     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r5 = r13.version     // Catch:{ Exception -> 0x03a5 }
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a5 }
            adConfig = r0     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdConfig r0 = adConfig     // Catch:{ Exception -> 0x03a5 }
            java.util.List r0 = r0.parse()     // Catch:{ Exception -> 0x03a5 }
            r13.msg_config = r0     // Catch:{ Exception -> 0x03a5 }
            java.util.List<com.cauly.android.ad.Message_Config> r0 = r13.msg_config     // Catch:{ Exception -> 0x03a5 }
            int r10 = r0.size()     // Catch:{ Exception -> 0x03a5 }
            if (r10 <= 0) goto L_0x03b4
            java.util.List<com.cauly.android.ad.Message_Config> r0 = r13.msg_config     // Catch:{ Exception -> 0x03a5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x03a5 }
        L_0x002f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x03a5 }
            if (r1 != 0) goto L_0x02c0
            r0 = 1
            r13.XconfFail = r0     // Catch:{ Exception -> 0x03a5 }
        L_0x0038:
            java.io.File r0 = r13.CONFIG_DIR     // Catch:{ Exception -> 0x03c5 }
            boolean r0 = r0.isDirectory()     // Catch:{ Exception -> 0x03c5 }
            if (r0 != 0) goto L_0x0045
            java.io.File r0 = r13.CONFIG_DIR     // Catch:{ Exception -> 0x03c5 }
            r0.mkdir()     // Catch:{ Exception -> 0x03c5 }
        L_0x0045:
            java.io.File r0 = r13.CONFIG_FILE     // Catch:{ Exception -> 0x03c5 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x03c5 }
            if (r0 == 0) goto L_0x0053
            java.io.File r0 = r13.CONFIG_FILE     // Catch:{ Exception -> 0x03c5 }
            r0.delete()     // Catch:{ Exception -> 0x03c5 }
            r9 = 1
        L_0x0053:
            java.io.File r0 = r13.CONFIG_FILE     // Catch:{ Exception -> 0x03c5 }
            r0.createNewFile()     // Catch:{ Exception -> 0x03c5 }
            java.io.FileWriter r8 = new java.io.FileWriter     // Catch:{ Exception -> 0x03c5 }
            java.io.File r0 = r13.CONFIG_FILE     // Catch:{ Exception -> 0x03c5 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x03c5 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x03c5 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "ssl\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getSsl()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "report_ack\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getReportAck()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "gender\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getGender()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "age\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getAge()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "model\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getModel()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "lang\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getLang()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "reuse_seq\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getReuseSeq()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "request_seq\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getRequestSeq()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "gps_info\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getGpsInfo()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "manufacturer\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getManufacturer()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "network\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getNetwork()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "alt_cpc_ad\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getAltCpcAd()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "alt_cpm_ad\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getAltCpmAd()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "refresh_period\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getRefreshPeriod()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "unique_app_id\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getUniqCode()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "check_net_onload_module\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getCheckNetOnloadModule()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " \n"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = "load_3d_module\t"
            r0.<init>(r1)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = r1.getLoad3dModule()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = com.cauly.android.ad.AdCommon.nullChk(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r1 = " "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c5 }
            r6.write(r0)     // Catch:{ Exception -> 0x03c5 }
            r6.close()     // Catch:{ Exception -> 0x03c5 }
            r8.close()     // Catch:{ Exception -> 0x03c5 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03c5 }
            java.lang.String r0 = java.lang.Long.toString(r0)     // Catch:{ Exception -> 0x03c5 }
            com.cauly.android.ad.AdCommon.LIMIT_XCONF = r0     // Catch:{ Exception -> 0x03c5 }
            if (r9 == 0) goto L_0x03bc
            java.lang.String r0 = "Cauly Ads"
            java.lang.String r1 = "Update Config File Success"
            android.util.Log.i(r0, r1)     // Catch:{ Exception -> 0x03c5 }
        L_0x02bf:
            return
        L_0x02c0:
            java.lang.Object r11 = r0.next()     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.Message_Config r11 = (com.cauly.android.ad.Message_Config) r11     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_SSL()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setSsl(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_REPORT_ACK()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setReportAck(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_ALT_CPC_AD()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setAltCpcAd(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_ALT_CPM_AD()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setAltCpmAd(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_GENDER()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setGender(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_AGE()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setAge(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_MODEL()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setModel(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_LANG()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setLang(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_REUSE_SEQ()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setReuseSeq(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_REQUEST_SEQ()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setRequestSeq(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_GPS_INFO()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setGpsInfo(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_MANUFACTURER()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setManufacturer(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_NETWORK()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setNetwork(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_REFRESH_PERIOD()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setRefreshPeriod(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_UNIQUE_APPD_ID()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setUniqCode(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_CHECK_NET_ONLOAD_MODULE()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setCheckNetOnloadModule(r2)     // Catch:{ Exception -> 0x03a5 }
            com.cauly.android.ad.AdData r1 = adData     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = r11.getC_LOAD_3D_MODULE()     // Catch:{ Exception -> 0x03a5 }
            java.lang.String r2 = com.cauly.android.ad.AdCommon.nullChk(r2)     // Catch:{ Exception -> 0x03a5 }
            r1.setLoad3dModule(r2)     // Catch:{ Exception -> 0x03a5 }
            goto L_0x002f
        L_0x03a5:
            r7 = move-exception
            r13.XconfFail = r12
            java.lang.String r0 = "Config"
            java.lang.String r1 = "Default!"
            android.util.Log.i(r0, r1)
            r13.DefaultConifgInfo()
            goto L_0x0038
        L_0x03b4:
            r13.DefaultConifgInfo()     // Catch:{ Exception -> 0x03a5 }
            r0 = 0
            r13.XconfFail = r0     // Catch:{ Exception -> 0x03a5 }
            goto L_0x0038
        L_0x03bc:
            java.lang.String r0 = "Cauly Ads"
            java.lang.String r1 = "Create Config File Success"
            android.util.Log.i(r0, r1)     // Catch:{ Exception -> 0x03c5 }
            goto L_0x02bf
        L_0x03c5:
            r7 = move-exception
            java.lang.String r0 = "Cauly Ads"
            java.lang.String r1 = "Create Config File Fail"
            android.util.Log.i(r0, r1)
            goto L_0x02bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cauly.android.ad.AdView.setConifgInfo():void");
    }

    private synchronized void getConifgInfoRead(boolean isfirst) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.CONFIG_FILE), 1024);
            int line = 0;
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    line++;
                    if (isfirst) {
                        String[] strArr = new String[2];
                        String[] conf = str.split("\\t");
                        if (conf[0].toString().equals("ssl")) {
                            adData.setSsl(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("report_ack")) {
                            adData.setReportAck(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("gender")) {
                            adData.setGender(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("age")) {
                            adData.setAge(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("model")) {
                            adData.setModel(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("lang")) {
                            adData.setLang(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("reuse_seq")) {
                            adData.setReuseSeq(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("request_seq")) {
                            adData.setRequestSeq(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("gps_info")) {
                            adData.setGpsInfo(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("manufacturer")) {
                            adData.setManufacturer(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("network")) {
                            adData.setNetwork(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("alt_cpc_ad")) {
                            adData.setAltCpcAd(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("alt_cpm_ad")) {
                            adData.setAltCpmAd(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("refresh_period")) {
                            adData.setRefreshPeriod(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("unique_app_id")) {
                            adData.setUniqCode(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("check_net_onload_module")) {
                            adData.setCheckNetOnloadModule(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else if (conf[0].toString().equals("load_3d_module")) {
                            adData.setLoad3dModule(AdCommon.nullChk(conf[1].toString()));
                            continue;
                        } else {
                            continue;
                        }
                    }
                    if (str == null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (line != 17) {
                try {
                    if (this.CONFIG_FILE.exists()) {
                        this.CONFIG_FILE.delete();
                    }
                    this.CONFIG_FILE.createNewFile();
                    FileWriter fw = new FileWriter(this.CONFIG_FILE);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("ssl\t" + AdCommon.nullChk(adData.getSsl()) + " \n");
                    bw.write("report_ack\t" + AdCommon.nullChk(adData.getReportAck()) + " \n");
                    bw.write("gender\t" + AdCommon.nullChk(adData.getGender()) + " \n");
                    bw.write("age\t" + AdCommon.nullChk(adData.getAge()) + " \n");
                    bw.write("model\t" + AdCommon.nullChk(adData.getModel()) + " \n");
                    bw.write("lang\t" + AdCommon.nullChk(adData.getLang()) + " \n");
                    bw.write("reuse_seq\t" + AdCommon.nullChk(adData.getReuseSeq()) + " \n");
                    bw.write("request_seq\t" + AdCommon.nullChk(adData.getRequestSeq()) + " \n");
                    bw.write("gps_info\t" + AdCommon.nullChk(adData.getGpsInfo()) + " \n");
                    bw.write("manufacturer\t" + AdCommon.nullChk(adData.getManufacturer()) + " \n");
                    bw.write("network\t" + AdCommon.nullChk(adData.getNetwork()) + " \n");
                    bw.write("alt_cpc_ad\t" + AdCommon.nullChk(adData.getAltCpcAd()) + " \n");
                    bw.write("alt_cpm_ad\t" + AdCommon.nullChk(adData.getAltCpmAd()) + " \n");
                    bw.write("refresh_period\t" + AdCommon.nullChk(adData.getRefreshPeriod()) + " \n");
                    bw.write("unique_app_id\t" + AdCommon.nullChk(adData.getUniqCode()) + " \n");
                    bw.write("check_net_onload_module\t" + AdCommon.nullChk(adData.getCheckNetOnloadModule()) + " \n");
                    bw.write("load_3d_module\t" + AdCommon.nullChk(adData.getLoad3dModule()) + " ");
                    bw.close();
                    fw.close();
                    Log.i("Cauly Ads", "Write Config File Success");
                } catch (Exception e) {
                    Log.i("Cauly Ads", "Create Config File Fail");
                }
            }
        } catch (Exception e2) {
            Log.i("Cauly Ads", "Read Config File Fail");
        }
        return;
    }

    /* access modifiers changed from: private */
    public void CheckConifgInfo() {
        try {
            if (!this.CONFIG_DIR.isDirectory()) {
                this.CONFIG_DIR.mkdir();
            }
            if (System.currentTimeMillis() - Long.parseLong(AdCommon.LIMIT_XCONF) >= 1800000) {
                setConifgInfo();
            } else if (this.CONFIG_FILE.exists()) {
                getConifgInfoRead(this.isFirst);
            } else {
                setConifgInfo();
            }
        } catch (Exception e) {
            Log.i("Cauly Ads", "Conifg setting Error!");
            Log.i("Cauly Ads", "Default Config!");
            this.XconfFail = false;
            DefaultConifgInfo();
        }
    }

    private boolean cpmLimitCheck() {
        if (!this.adtype.equalsIgnoreCase("cpm")) {
            this.min_refresh = true;
        } else if (System.currentTimeMillis() - Long.parseLong(AdCommon.LIMIT_CPM) < 60000) {
            this.min_refresh = false;
            Log.i("Cauly Ads", "Request Failed( You are not allowed to send requests under miniumum interval )");
            this.error_msg = "Request Failed( You are not allowed to send requests under miniumum interval )";
            this.error_code = "-200";
        } else {
            AdCommon.LIMIT_CPM = Long.toString(System.currentTimeMillis());
            this.min_refresh = true;
        }
        return this.min_refresh;
    }

    /* access modifiers changed from: private */
    public int isVisibilityCheck() {
        if (getWindowVisibility() == 0 && getVisibility() == 0) {
            this.isVisible = "Y";
        } else {
            this.isVisible = "N";
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void reloadAD() {
        synchronized (this) {
            this.error_code = "0";
            this.error_msg = Constants.QA_SERVER_URL;
            if (super.getVisibility() != 0 || this.reloadInterval < 0 || !this.isReload) {
                if (reloadTimer != null) {
                    reloadTimer.cancel();
                    reloadTimer = null;
                }
            } else if (cpmLimitCheck()) {
                new CaulyAsyncTask(this).execute(new Void[0]);
            } else {
                threadHandler.post(new Runnable() {
                    public void run() {
                        if (AdView.this.adListener != null) {
                            AdView.this.adListener.onFailedToReceiveAd(false);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPrevAdsAnimation(View view) {
        if (view != null) {
            try {
                if (!this.effect.equalsIgnoreCase("left_slide")) {
                    return;
                }
                if ((line_page_ad.contains(adData.getAdShape().toString()) || adData.getHandler().equals("inmobi")) && this.isReload) {
                    TranslateAnimation anim = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    anim.setRepeatCount(0);
                    view.setAnimation(anim);
                    anim.start();
                }
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void setCurrentAdsAnimation(View view) {
        if (view != null) {
            try {
                AnimationSet set = new AnimationSet(true);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                set.addAnimation(animation);
                if (this.effect.equalsIgnoreCase("bottom_slide")) {
                    Animation animation2 = new TranslateAnimation(0.0f, 0.0f, (float) this.layout_height, 0.0f);
                    animation2.setDuration(500);
                    set.addAnimation(animation2);
                    view.startAnimation(set);
                } else if (this.effect.equalsIgnoreCase("top_slide")) {
                    Animation animation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
                    animation3.setDuration(500);
                    set.addAnimation(animation3);
                    view.startAnimation(set);
                } else if (this.effect.equalsIgnoreCase("left_slide")) {
                    TranslateAnimation anim = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    view.setAnimation(anim);
                    anim.start();
                } else if (this.effect.equalsIgnoreCase("circle") || this.effect.equalsIgnoreCase("half")) {
                    if (this.total_layout_width == 0) {
                        this.total_layout_width = this.display.getWidth();
                    }
                    float centerX = ((float) this.total_layout_width) / 2.0f;
                    if (this.effect.equalsIgnoreCase("circle")) {
                        this.rotation = new Rotate3dAnimation(0.0f, 180.0f, centerX, 0.0f, 0.0f, false);
                    } else if (this.effect.equalsIgnoreCase("half")) {
                        this.rotation = new Rotate3dAnimation(180.0f, 360.0f, centerX, 0.0f, 0.0f, false);
                    }
                    this.rotation.setDuration(500);
                    this.rotation.setFillAfter(true);
                    this.rotation.setInterpolator(new AccelerateInterpolator());
                    if (this.effect.equalsIgnoreCase("circle")) {
                        this.rotation.setAnimationListener(new DisplayRolling(this, null));
                    }
                    view.startAnimation(this.rotation);
                }
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void defaultAds() {
        try {
            if (AdCommon.nullChk(adData.getReportAck()).equalsIgnoreCase("Y")) {
                if (this.ConnectedFail) {
                    AdCommon.Ad_Log_Info("Android", AdCommon.nullChk(adData.getIserial()), "connection", this.XconfFail);
                } else {
                    AdCommon.Ad_Log_Info("Android", AdCommon.nullChk(adData.getIserial()), "parsing", this.XconfFail);
                }
            }
            if (AdCommon.nullChk(adData.getPayType()).equals("cpm") && AdCommon.nullChk(adData.getId()).equals("0")) {
                Log.i("Cauly Ads", "No filled AD");
                this.error_msg = "No filled AD";
                this.error_code = "200";
            }
            AdCommon.recursiveRecycle(adLayout);
            if (this.imAdView != null) {
                this.imAdView.destroyDrawingCache();
                this.imAdView = null;
            }
            synchronized (this) {
                int height = this.display.getHeight();
                int width = this.display.getWidth();
                this.layout_height = 0;
                if (height > width) {
                    this.layout_height = height / 10;
                } else {
                    this.layout_height = width / 10;
                }
                adLayout = new AdLayout(getContext().getApplicationContext());
                adLayout.setVisibility(0);
                if (AdCommon.nullChk(this.adtype).equalsIgnoreCase("cpc")) {
                    adLayout.setLayoutParams(new LayoutParams(-1, this.layout_height));
                    try {
                        this.background_default = BitmapFactory.decodeStream(new FlushedInputStream(getContext().getApplicationContext().getAssets().open("cauly_default_banner.png")));
                    } catch (IOException e) {
                        Log.i("Cauly Ads", "CPC Default ads");
                    }
                    this.background_drawable = new BitmapDrawable(this.background_default);
                    this.background_drawable.setCallback(null);
                    adLayout.setBackgroundDrawable(this.background_drawable);
                    if (this.background_default != null) {
                        this.background_default = null;
                    }
                    if (this.background_drawable != null) {
                        this.background_drawable = null;
                    }
                }
                threadHandler.post(new Runnable() {
                    public void run() {
                        try {
                            AdView.this.removeAllViews();
                            AdView.this.addView(AdView.adLayout);
                            if (AdView.this.adListener != null) {
                                AdView.this.adListener.onFailedToReceiveAd(false);
                            }
                        } catch (Exception e) {
                            Log.e("Cauly Ads", "Failed to Layout");
                            AdView.this.error_code = "-100";
                            AdView.this.error_msg = "SDK error ( Failed to Layout )";
                        } finally {
                            AdView.this.isFirst = false;
                            AdView.this.clearDisappearingChildren();
                            AdView.this.clearAnimation();
                        }
                    }
                });
            }
            return;
        } catch (Exception e2) {
        }
    }

    public void setAdListener(AdListener listener) {
        if (listener != this.adListener) {
            this.adListener = listener;
        }
    }

    public void startLoading() {
        if (!this.isLoading) {
            this.isReload = true;
            reloadAD();
        }
    }

    public void stopLoading() {
        this.isReload = false;
    }

    /* access modifiers changed from: private */
    public void startReloadTimer() {
        if (this.isReload && this.reloadInterval > 0) {
            if (reloadTimer != null) {
                reloadTimer.cancel();
                reloadTimer = null;
            }
            if (reloadTimer == null) {
                reloadTimer = new Timer();
                reloadTimer.schedule(new TimerTask() {
                    public void run() {
                        try {
                            AdView.this.reloadAD();
                        } catch (Exception e) {
                            Log.i("Cauly Ads", "Timer Error!");
                        }
                    }
                }, (long) this.reloadInterval, (long) this.reloadInterval);
            }
        } else if ((!this.isReload || this.reloadInterval == 0) && reloadTimer != null) {
            reloadTimer.cancel();
            reloadTimer = null;
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (this.reloadInterval > 0) {
            this.isReload = hasWindowFocus;
        }
        this.total_layout_width = getWidth();
        if (this.total_layout_width == 0) {
            this.total_layout_width = this.display.getWidth();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap downloadBitmap(java.lang.String r20) {
        /*
            java.lang.String r17 = ""
            r0 = r20
            r1 = r17
            boolean r17 = r0.equals(r1)
            if (r17 != 0) goto L_0x00f2
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            java.lang.String r18 = "?reg_time="
            r17.<init>(r18)
            java.lang.String r18 = time_stamp
            java.lang.StringBuilder r17 = r17.append(r18)
            java.lang.String r18 = "&scode="
            java.lang.StringBuilder r17 = r17.append(r18)
            java.lang.String r18 = scode
            java.lang.StringBuilder r17 = r17.append(r18)
            java.lang.String r18 = "&iserial="
            java.lang.StringBuilder r17 = r17.append(r18)
            com.cauly.android.ad.AdData r18 = adData
            java.lang.String r18 = r18.getIserial()
            java.lang.StringBuilder r17 = r17.append(r18)
            java.lang.String r12 = r17.toString()
            org.apache.http.params.BasicHttpParams r9 = new org.apache.http.params.BasicHttpParams
            r9.<init>()
            r15 = 10000(0x2710, float:1.4013E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r9, r15)
            r16 = 10000(0x2710, float:1.4013E-41)
            r0 = r16
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r9, r0)
            org.apache.http.impl.client.DefaultHttpClient r4 = new org.apache.http.impl.client.DefaultHttpClient
            r4.<init>(r9)
            org.apache.http.client.methods.HttpGet r8 = new org.apache.http.client.methods.HttpGet
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            java.lang.String r18 = java.lang.String.valueOf(r20)
            r17.<init>(r18)
            r0 = r17
            java.lang.StringBuilder r17 = r0.append(r12)
            java.lang.String r17 = r17.toString()
            r0 = r17
            r8.<init>(r0)
            org.apache.http.HttpResponse r13 = r4.execute(r8)     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            org.apache.http.StatusLine r17 = r13.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            int r14 = r17.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            r17 = 200(0xc8, float:2.8E-43)
            r0 = r17
            if (r14 == r0) goto L_0x007d
            r2 = 0
        L_0x007c:
            return r2
        L_0x007d:
            org.apache.http.HttpEntity r6 = r13.getEntity()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            if (r6 == 0) goto L_0x00f2
            r10 = 0
            r2 = 0
            java.io.InputStream r10 = r6.getContent()     // Catch:{ all -> 0x00f4 }
            java.lang.String r17 = "/"
            r0 = r20
            r1 = r17
            int r17 = r0.lastIndexOf(r1)     // Catch:{ all -> 0x00f4 }
            int r17 = r17 + 1
            r0 = r20
            r1 = r17
            java.lang.String r7 = r0.substring(r1)     // Catch:{ all -> 0x00f4 }
            com.cauly.android.ad.AdView$FlushedInputStream r17 = new com.cauly.android.ad.AdView$FlushedInputStream     // Catch:{ all -> 0x00f4 }
            r0 = r17
            r0.<init>(r10)     // Catch:{ all -> 0x00f4 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r17)     // Catch:{ all -> 0x00f4 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ all -> 0x00f4 }
            java.lang.StringBuilder r17 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            java.lang.String r18 = SAVE_PATH     // Catch:{ all -> 0x00f4 }
            java.lang.String r18 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x00f4 }
            r17.<init>(r18)     // Catch:{ all -> 0x00f4 }
            r0 = r17
            java.lang.StringBuilder r17 = r0.append(r7)     // Catch:{ all -> 0x00f4 }
            java.lang.String r17 = r17.toString()     // Catch:{ all -> 0x00f4 }
            r0 = r17
            r11.<init>(r0)     // Catch:{ all -> 0x00f4 }
            android.graphics.Bitmap$CompressFormat r17 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x00f4 }
            r18 = 100
            r0 = r17
            r1 = r18
            r2.compress(r0, r1, r11)     // Catch:{ all -> 0x00f4 }
            r11.flush()     // Catch:{ all -> 0x00f4 }
            r11.close()     // Catch:{ all -> 0x00f4 }
            if (r10 == 0) goto L_0x00da
            r10.close()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
        L_0x00da:
            if (r2 == 0) goto L_0x0148
            boolean r17 = r2.isRecycled()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            if (r17 != 0) goto L_0x0148
            r3 = 0
        L_0x00e3:
            r6.consumeContent()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            goto L_0x007c
        L_0x00e7:
            r5 = move-exception
            r8.abort()
            java.lang.String r17 = "Cauly Ads"
            java.lang.String r18 = "SocketTimeout error while retrieving bitmap from Cauly"
            android.util.Log.w(r17, r18)
        L_0x00f2:
            r2 = 0
            goto L_0x007c
        L_0x00f4:
            r17 = move-exception
            if (r10 == 0) goto L_0x00fa
            r10.close()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
        L_0x00fa:
            if (r2 == 0) goto L_0x0103
            boolean r18 = r2.isRecycled()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            if (r18 != 0) goto L_0x0103
            r2 = 0
        L_0x0103:
            r6.consumeContent()     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
            throw r17     // Catch:{ SocketTimeoutException -> 0x00e7, IOException -> 0x0107, OutOfMemoryError -> 0x0113, IllegalStateException -> 0x011f, Exception -> 0x013c }
        L_0x0107:
            r5 = move-exception
            r8.abort()
            java.lang.String r17 = "Cauly Ads"
            java.lang.String r18 = "I/O error while retrieving bitmap from Cauly"
            android.util.Log.w(r17, r18)
            goto L_0x00f2
        L_0x0113:
            r5 = move-exception
            r8.abort()
            java.lang.String r17 = "Cauly Ads"
            java.lang.String r18 = "OutOfMemory error while retrieving bitmap from Cauly"
            android.util.Log.w(r17, r18)
            goto L_0x00f2
        L_0x011f:
            r5 = move-exception
            r8.abort()
            java.lang.String r17 = "Cauly Ads"
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            java.lang.String r19 = "Incorrect URL: "
            r18.<init>(r19)
            r0 = r18
            r1 = r20
            java.lang.StringBuilder r18 = r0.append(r1)
            java.lang.String r18 = r18.toString()
            android.util.Log.w(r17, r18)
            goto L_0x00f2
        L_0x013c:
            r5 = move-exception
            r8.abort()
            java.lang.String r17 = "Cauly Ads"
            java.lang.String r18 = "Error while retrieving bitmap from Cauly"
            android.util.Log.w(r17, r18)
            goto L_0x00f2
        L_0x0148:
            r3 = r2
            goto L_0x00e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cauly.android.ad.AdView.downloadBitmap(java.lang.String):android.graphics.Bitmap");
    }

    private synchronized void noMediaCheck() {
        new Thread() {
            public void run() {
                try {
                    if (!AdView.this.FILE_DIR.isDirectory()) {
                        AdView.this.FILE_DIR.mkdirs();
                    }
                    if (!AdView.this.NOMEDIA_FILE.exists()) {
                        AdView.this.NOMEDIA_FILE.createNewFile();
                    }
                } catch (Exception e) {
                    Log.e("Cauly Ads", "Media File error");
                }
            }
        }.start();
    }

    private String getcodeCheck() {
        String str;
        code = Constants.QA_SERVER_URL;
        try {
            if (!this.FILE_DIR.isDirectory()) {
                this.FILE_DIR.mkdirs();
            }
            if (!this.SCODE_FILE.exists()) {
                code = String.valueOf(Long.toString(System.currentTimeMillis() * 10)) + AdCommon.generateRandomCODE(26);
                this.SCODE_FILE.createNewFile();
                FileWriter fw = new FileWriter(this.SCODE_FILE);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(code);
                bw.close();
                fw.close();
            } else {
                FileReader fr = new FileReader(this.SCODE_FILE);
                BufferedReader br = new BufferedReader(fr, 1024);
                do {
                    str = br.readLine();
                    if (str == null) {
                        break;
                    }
                    code = str.trim();
                } while (str != null);
                br.close();
                fr.close();
            }
        } catch (Exception e) {
            Log.e("Cauly Ads", "Code File error");
            code = Constants.QA_SERVER_URL;
        }
        return code;
    }

    private synchronized void DownLoadCheck() {
        new Thread() {
            public void run() {
                String str;
                File file = new File("/data/data/" + AdView.this.getContext().getApplicationContext().getPackageName() + "/cauly/DownloadCheck.txt");
                File dir = new File("/data/data/" + AdView.this.getContext().getApplicationContext().getPackageName() + "/cauly/");
                if (!AdView.this.appcode.equalsIgnoreCase("CAULY") && !AdView.this.appcode.equalsIgnoreCase("CAULY-3DTEST") && !AdView.this.appcode.equalsIgnoreCase("CAULY-RICHADTEST")) {
                    try {
                        if (!dir.isDirectory()) {
                            dir.mkdir();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write("True");
                            bw.close();
                            fw.close();
                            AdCommon.Download_Info(AdView.scode, AdView.this.appcode);
                            Log.i("Cauly Ads", "Download Check success");
                            return;
                        }
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr, 1024);
                        do {
                            str = br.readLine();
                            if (str == null) {
                                break;
                            } else if (str.equals("False")) {
                                FileWriter fw2 = new FileWriter(file);
                                BufferedWriter bw2 = new BufferedWriter(fw2);
                                bw2.write("True");
                                bw2.close();
                                fw2.close();
                                AdCommon.Download_Info(AdView.scode, AdView.this.appcode);
                                Log.i("Cauly Ads", "Download Check success");
                                continue;
                            }
                        } while (str != null);
                        br.close();
                        fr.close();
                    } catch (Exception e) {
                        Log.i("Cauly Ads", "Check failed to download");
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void getGpsInfo() {
        if (this.gps.equalsIgnoreCase("auto")) {
            try {
                this.lm = (LocationManager) getContext().getApplicationContext().getSystemService("location");
                String provider2 = this.lm.getBestProvider(new Criteria(), true);
                if (provider2 == null) {
                    provider2 = "network";
                }
                this.locationListener = new CaulyLocationListener();
                this.lm.requestLocationUpdates(provider2, 1000, 500.0f, this.locationListener);
                Location location = this.lm.getLastKnownLocation("network");
                lat = location.getLatitude();
                lng = location.getLongitude();
                this.lat_lng = String.valueOf(lat) + "," + lng;
            } catch (Exception e) {
                Log.i("Cauly Ads", "Disable Gps!");
                this.lat_lng = Constants.QA_SERVER_URL;
            }
        } else if (this.gps.equalsIgnoreCase("off")) {
            this.lat_lng = Constants.QA_SERVER_URL;
        }
    }

    /* access modifiers changed from: private */
    public void getNetworkState() {
        try {
            ConnectivityManager connect = (ConnectivityManager) getContext().getApplicationContext().getSystemService("connectivity");
            NetworkInfo ni = connect.getNetworkInfo(1);
            boolean isWifiAvail = ni.isAvailable();
            boolean isWifiConn = ni.isConnected();
            NetworkInfo ni2 = connect.getNetworkInfo(0);
            boolean isMobileAvail = ni2.isAvailable();
            boolean isMobileConn = ni2.isConnected();
            if (isWifiAvail && isWifiConn) {
                this.network = "WIFI";
            } else if (!isMobileAvail || !isMobileConn) {
                this.network = "-";
            } else {
                this.network = "3G";
            }
        } catch (Exception e) {
            if (this.isFirst) {
                this.network = "permission";
            }
        }
    }

    private int getreloadInterval(int sec) {
        if (sec == 0) {
            return 120;
        }
        if (sec < 0) {
            return 0;
        }
        if (sec > 0 && sec <= 30) {
            return 30;
        }
        if (sec > 30 && sec <= 90) {
            return 90;
        }
        if (sec <= 90 || sec > 120) {
            return 120;
        }
        return 120;
    }

    public boolean isChargeableAd() {
        if (adData != null && AdCommon.nullChk(adData.getHandler()).equals("inmobi")) {
            return true;
        }
        if (adData == null || !AdCommon.nullChk(adData.getRetCode()).equalsIgnoreCase("0")) {
            return false;
        }
        return true;
    }

    public int getErrorCode() {
        try {
            return Integer.parseInt(this.error_code);
        } catch (NumberFormatException e) {
            return AdException.SANDBOX_BADIP;
        }
    }

    public String getErrorMessage() {
        String msg = this.error_msg;
        if (adData == null || AdCommon.nullChk(adData.getRetMsg()).equals(Constants.QA_SERVER_URL)) {
            return msg;
        }
        return String.valueOf(msg) + "(" + adData.getRetMsg() + ")";
    }

    public void destroy() {
        stopLoading();
        if (reloadTimer != null) {
            reloadTimer.cancel();
            reloadTimer = null;
        }
        if (this.adListener != null) {
            this.adListener = null;
        }
        if (this.background_default != null) {
            this.background_default = null;
        }
        if (this.background_drawable != null) {
            this.background_drawable = null;
        }
        if (this.adImage != null) {
            this.adImage = null;
        }
        AdCommon.recursiveRecycle(this);
        clearDisappearingChildren();
        clearAnimation();
        removeAllViews();
    }
}
