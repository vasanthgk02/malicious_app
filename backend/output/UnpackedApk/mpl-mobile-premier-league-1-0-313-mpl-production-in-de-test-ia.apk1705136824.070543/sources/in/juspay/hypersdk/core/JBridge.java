package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.provider.Settings.Secure;
import android.renderscript.RenderScript;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabColorSchemeParams$Builder;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.airbnb.lottie.LottieAnimationView;
import com.amazon.apay.hardened.external.AmazonPayManager;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.BuildConfig;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.zaq;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResponse;
import com.google.android.gms.safetynet.SafetyNetApi.zza;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.safetynet.zzl;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzn;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.simpl.android.fingerprint.SimplFingerprint;
import com.simpl.android.fingerprint.SimplFingerprintListener;
import com.visa.SensoryBrandingView;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.Labels.Network;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import in.juspay.hypersdk.mystique.SwypeLayout;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.security.SecurityHelper;
import in.juspay.hypersdk.utils.GPayUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.JuspayHttpResponse;
import in.juspay.hypersdk.utils.network.NetUtils;
import in.juspay.hyperupi.CLUtils;
import in.juspay.hyperupi.JsCallback;
import in.juspay.vies.VIESSocketFactory;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.BinaryBitmap;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.MultiFormatReader;
import in.juspay.widget.qrscanner.com.google.zxing.RGBLuminanceSource;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.common.HybridBinarizer;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.QRCodeWriter;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeResult;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.CaptureManager;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.DecoratedBarcodeView;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.HttpUrl;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JBridge extends DuiInterface {
    public static final float BEEP_VOLUME = 0.1f;
    public static final String LOG_TAG = "JBridge";
    public final int AMAZON_PROCESS_CHARGE_REQUEST_CODE = 112;
    public final int AMAZON_REQUEST_CODE = 111;
    public final int CUSTOMTAB_REQUEST_CODE = 115;
    public int GALLERY_KITKAT_INTENT_CALLED = 118;
    public final int JUSPAY_LOADER_ID = 898989;
    public final int PAYTM_REQUEST_CODE = 116;
    public final int PHONEPE_REQUEST_CODE = 113;
    public final int SELECT_PHOTO = 117;
    public Set<String> acceptedCerts;
    public Activity activity;
    public String amazonLinkCallback = "";
    public BeepManager beepManager;
    public BroadcastReceiver broadcastReceiver = null;
    public CaptureManager captureManager;
    public Object clInterface;
    public SafetyNetClient client = null;
    public TextWatcher expiryTextWatcher = null;
    public JuspayServices juspayServices;
    public NetUtils netUtils;
    public NetUtils netUtilsSsl;
    public String phonepeTxnCallback = "";
    public TextWatcher textWatcher = null;
    public UPIUtils upiInterface;
    public SensoryBrandingView viesSensoryBrandingView;

    public class MyGestureListener extends SimpleOnGestureListener {
        public final int MIN_DISTANCE = FTPReply.FILE_STATUS_OK;
        public String callback;
        public float x1;
        public float x2;
        public float y1;
        public float y2;

        public MyGestureListener(String str) {
            this.callback = str;
        }

        private void sendCallBack(String str, String str2) {
            JBridge.this.invokeCallbackInDUIWebview(this.callback, str2);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            sendCallBack("onScroll", f2 + "," + f3);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }
    }

    public class MyGestureObject {
        public MotionEvent event1;
        public MotionEvent event2;

        public MyGestureObject(MotionEvent motionEvent, MotionEvent motionEvent2) {
            this.event1 = motionEvent;
            this.event2 = motionEvent2;
        }

        public String toString() {
            this.event1.getX();
            return super.toString();
        }
    }

    public JBridge(JuspayServices juspayServices2, Activity activity2, HyperFragment hyperFragment) {
        super(juspayServices2, activity2, hyperFragment);
        this.juspayServices = juspayServices2;
        this.acceptedCerts = new HashSet();
        this.viesSensoryBrandingView = null;
        this.activity = activity2;
        try {
            this.netUtils = new NetUtils(0, 0, false);
            this.netUtilsSsl = new NetUtils(0, 0, true);
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", System.JBRIDGE, "Error while instantiating NetUtils", e2);
        }
        this.upiInterface = new UPIUtils() {
            public Activity getActivity() {
                return JBridge.this.activity;
            }

            public Context getContext() {
                return JBridge.this.activity.getApplicationContext();
            }

            public DynamicUI getDynamicUI() {
                return JBridge.this.juspayServices.getDynamicUI();
            }

            public HyperFragment getHyperFragment() {
                return JBridge.this.browserFragment;
            }
        };
    }

    public static float dpToPx(float f2, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2;
    }

    private void drawIcon(final Drawable drawable, final int i) {
        final SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (JBridge.this.activity != null) {
                        View findViewById = JBridge.this.activity.findViewById(i);
                        ImageView imageView = new ImageView(JBridge.this.activity);
                        imageView.setImageDrawable(drawable);
                        if (findViewById != null) {
                            ((ViewGroup) findViewById).addView(imageView);
                        } else {
                            sdkTracker.trackAction("system", "error", System.JBRIDGE, "draw_icon", GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("No view at "), i, " found to attach the image."));
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010d A[SYNTHETIC, Splitter:B:36:0x010d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable generateBackgroundWithShadow(int r29, android.view.View[] r30, org.json.JSONArray r31, org.json.JSONArray r32, org.json.JSONArray r33, org.json.JSONArray r34, org.json.JSONArray r35, org.json.JSONArray r36, org.json.JSONArray r37) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r3 = r36
            r0 = r37
            in.juspay.hypersdk.core.JuspayServices r4 = r1.juspayServices
            in.juspay.hypersdk.core.SdkTracker r4 = r4.getSdkTracker()
            r12 = 0
            r5 = r30[r12]
            android.view.ViewParent r5 = r5.getParent()
            r13 = r5
            android.view.View r13 = (android.view.View) r13
            r14 = 2
            if (r2 != r14) goto L_0x0023
            android.view.ViewParent r6 = r13.getParent()
            android.view.View r6 = (android.view.View) r6
            r15 = r6
            goto L_0x0024
        L_0x0023:
            r15 = 0
        L_0x0024:
            int r11 = r32.length()
            android.graphics.drawable.Drawable[] r10 = new android.graphics.drawable.Drawable[r11]
            r6 = 0
        L_0x002b:
            int r7 = r32.length()     // Catch:{ JSONException -> 0x00e7 }
            if (r6 >= r7) goto L_0x00de
            r7 = r32
            int r8 = r7.getInt(r6)     // Catch:{ JSONException -> 0x00e7 }
            float r8 = (float) r8
            r17 = r15
            double r14 = r0.getDouble(r6)     // Catch:{ JSONException -> 0x00d8 }
            float r9 = (float) r14     // Catch:{ JSONException -> 0x00d8 }
            float r8 = r8 * r9
            r9 = r33
            java.lang.String r14 = r9.getString(r6)     // Catch:{ JSONException -> 0x00d8 }
            int r14 = android.graphics.Color.parseColor(r14)     // Catch:{ JSONException -> 0x00d8 }
            r15 = r31
            java.lang.String r18 = r15.getString(r6)     // Catch:{ JSONException -> 0x00d8 }
            int r5 = android.graphics.Color.parseColor(r18)     // Catch:{ JSONException -> 0x00d8 }
            r12 = 8
            float[] r12 = new float[r12]     // Catch:{ JSONException -> 0x00d8 }
            r18 = 0
            r12[r18] = r8     // Catch:{ JSONException -> 0x00d2 }
            r7 = 1
            r12[r7] = r8     // Catch:{ JSONException -> 0x00d2 }
            r16 = 2
            r12[r16] = r8     // Catch:{ JSONException -> 0x00d2 }
            r19 = 3
            r12[r19] = r8     // Catch:{ JSONException -> 0x00d2 }
            r19 = 4
            r12[r19] = r8     // Catch:{ JSONException -> 0x00d2 }
            r19 = 5
            r12[r19] = r8     // Catch:{ JSONException -> 0x00d2 }
            r19 = 6
            r12[r19] = r8     // Catch:{ JSONException -> 0x00d2 }
            r19 = 7
            r12[r19] = r8     // Catch:{ JSONException -> 0x00d2 }
            android.graphics.drawable.ShapeDrawable r7 = new android.graphics.drawable.ShapeDrawable     // Catch:{ JSONException -> 0x00d2 }
            r7.<init>()     // Catch:{ JSONException -> 0x00d2 }
            android.graphics.Paint r9 = r7.getPaint()     // Catch:{ JSONException -> 0x00d2 }
            r9.setColor(r5)     // Catch:{ JSONException -> 0x00d2 }
            android.graphics.Paint r5 = r7.getPaint()     // Catch:{ JSONException -> 0x00d2 }
            r9 = r34
            r20 = r11
            int r11 = r9.getInt(r6)     // Catch:{ JSONException -> 0x00ce }
            float r11 = (float) r11     // Catch:{ JSONException -> 0x00ce }
            double r1 = r0.getDouble(r6)     // Catch:{ JSONException -> 0x00ce }
            float r1 = (float) r1     // Catch:{ JSONException -> 0x00ce }
            float r11 = r11 * r1
            r1 = r35
            int r2 = r1.getInt(r6)     // Catch:{ JSONException -> 0x00ce }
            float r2 = (float) r2
            r21 = r4
            double r3 = r0.getDouble(r6)     // Catch:{ JSONException -> 0x00cc }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x00cc }
            float r2 = r2 * r3
            r5.setShadowLayer(r8, r11, r2, r14)     // Catch:{ JSONException -> 0x00cc }
            r2 = 1
            r3 = 0
            r13.setLayerType(r2, r3)     // Catch:{ JSONException -> 0x00cc }
            android.graphics.drawable.shapes.RoundRectShape r2 = new android.graphics.drawable.shapes.RoundRectShape     // Catch:{ JSONException -> 0x00cc }
            r2.<init>(r12, r3, r3)     // Catch:{ JSONException -> 0x00cc }
            r7.setShape(r2)     // Catch:{ JSONException -> 0x00cc }
            r10[r6] = r7     // Catch:{ JSONException -> 0x00cc }
            int r6 = r6 + 1
            r1 = r28
            r2 = r29
            r3 = r36
            r15 = r17
            r11 = r20
            r4 = r21
            r12 = 0
            r14 = 2
            goto L_0x002b
        L_0x00cc:
            r0 = move-exception
            goto L_0x00f0
        L_0x00ce:
            r0 = move-exception
            r21 = r4
            goto L_0x00f0
        L_0x00d2:
            r0 = move-exception
            r21 = r4
            r20 = r11
            goto L_0x00f0
        L_0x00d8:
            r0 = move-exception
            r21 = r4
            r20 = r11
            goto L_0x00ee
        L_0x00de:
            r21 = r4
            r17 = r15
            r18 = 0
            r1 = r10
            r2 = r11
            goto L_0x0105
        L_0x00e7:
            r0 = move-exception
            r21 = r4
            r20 = r11
            r17 = r15
        L_0x00ee:
            r18 = 0
        L_0x00f0:
            r11 = r0
            java.lang.String r6 = "JBridge"
            java.lang.String r7 = "action"
            java.lang.String r8 = "system"
            java.lang.String r9 = "jbridge"
            java.lang.String r0 = "Error while generating background for shadow"
            r5 = r21
            r1 = r10
            r10 = r0
            r2 = r20
            r5.trackAndLogException(r6, r7, r8, r9, r10, r11)
        L_0x0105:
            android.graphics.drawable.LayerDrawable r3 = new android.graphics.drawable.LayerDrawable
            r3.<init>(r1)
            r12 = 0
        L_0x010b:
            if (r12 >= r2) goto L_0x01c8
            r0 = r30[r12]     // Catch:{ JSONException -> 0x01a8 }
            int r0 = r0.getLeft()     // Catch:{ JSONException -> 0x01a8 }
            r1 = r30[r12]     // Catch:{ JSONException -> 0x01a8 }
            int r1 = r1.getTop()     // Catch:{ JSONException -> 0x01a8 }
            int r4 = r13.getWidth()     // Catch:{ JSONException -> 0x01a8 }
            r5 = r30[r12]     // Catch:{ JSONException -> 0x01a8 }
            int r5 = r5.getRight()     // Catch:{ JSONException -> 0x01a8 }
            int r4 = r4 - r5
            int r5 = r13.getHeight()     // Catch:{ JSONException -> 0x01a8 }
            r6 = r30[r12]     // Catch:{ JSONException -> 0x01a8 }
            int r6 = r6.getBottom()     // Catch:{ JSONException -> 0x01a8 }
            int r5 = r5 - r6
            r6 = r29
            r7 = 2
            if (r6 != r7) goto L_0x0154
            if (r17 == 0) goto L_0x0154
            int r8 = r13.getLeft()     // Catch:{ JSONException -> 0x01a8 }
            int r0 = r0 + r8
            int r8 = r13.getTop()     // Catch:{ JSONException -> 0x01a8 }
            int r1 = r1 + r8
            int r8 = r17.getWidth()     // Catch:{ JSONException -> 0x01a8 }
            int r9 = r13.getRight()     // Catch:{ JSONException -> 0x01a8 }
            int r8 = r8 - r9
            int r4 = r4 + r8
            int r8 = r17.getHeight()     // Catch:{ JSONException -> 0x01a8 }
            int r9 = r13.getBottom()     // Catch:{ JSONException -> 0x01a8 }
            int r8 = r8 - r9
            int r5 = r5 + r8
        L_0x0154:
            r8 = r28
            android.app.Activity r9 = r8.activity     // Catch:{ JSONException -> 0x01a6 }
            if (r9 == 0) goto L_0x0191
            r9 = r36
            int r10 = r9.getInt(r12)     // Catch:{ JSONException -> 0x01a6 }
            float r10 = (float) r10     // Catch:{ JSONException -> 0x01a6 }
            android.app.Activity r11 = r8.activity     // Catch:{ JSONException -> 0x01a6 }
            float r10 = dpToPx(r10, r11)     // Catch:{ JSONException -> 0x01a6 }
            int r10 = (int) r10     // Catch:{ JSONException -> 0x01a6 }
            int r0 = r0 - r10
            int r10 = r9.getInt(r12)     // Catch:{ JSONException -> 0x01a6 }
            float r10 = (float) r10     // Catch:{ JSONException -> 0x01a6 }
            android.app.Activity r11 = r8.activity     // Catch:{ JSONException -> 0x01a6 }
            float r10 = dpToPx(r10, r11)     // Catch:{ JSONException -> 0x01a6 }
            int r10 = (int) r10     // Catch:{ JSONException -> 0x01a6 }
            int r1 = r1 - r10
            int r10 = r9.getInt(r12)     // Catch:{ JSONException -> 0x01a6 }
            float r10 = (float) r10     // Catch:{ JSONException -> 0x01a6 }
            android.app.Activity r11 = r8.activity     // Catch:{ JSONException -> 0x01a6 }
            float r10 = dpToPx(r10, r11)     // Catch:{ JSONException -> 0x01a6 }
            int r10 = (int) r10     // Catch:{ JSONException -> 0x01a6 }
            int r4 = r4 - r10
            int r10 = r9.getInt(r12)     // Catch:{ JSONException -> 0x01a6 }
            float r10 = (float) r10     // Catch:{ JSONException -> 0x01a6 }
            android.app.Activity r11 = r8.activity     // Catch:{ JSONException -> 0x01a6 }
            float r10 = dpToPx(r10, r11)     // Catch:{ JSONException -> 0x01a6 }
            int r10 = (int) r10     // Catch:{ JSONException -> 0x01a6 }
            int r5 = r5 - r10
            goto L_0x0193
        L_0x0191:
            r9 = r36
        L_0x0193:
            r24 = r0
            r25 = r1
            r26 = r4
            r27 = r5
            r22 = r3
            r23 = r12
            r22.setLayerInset(r23, r24, r25, r26, r27)     // Catch:{ JSONException -> 0x01a6 }
            int r12 = r12 + 1
            goto L_0x010b
        L_0x01a6:
            r0 = move-exception
            goto L_0x01ab
        L_0x01a8:
            r0 = move-exception
            r8 = r28
        L_0x01ab:
            java.lang.String r1 = "JBridge"
            java.lang.String r2 = "action"
            java.lang.String r4 = "system"
            java.lang.String r5 = "jbridge"
            java.lang.String r6 = "Error while generating background for shadow"
            r29 = r21
            r30 = r1
            r31 = r2
            r32 = r4
            r33 = r5
            r34 = r6
            r35 = r0
            r29.trackAndLogException(r30, r31, r32, r33, r34, r35)
            goto L_0x01ca
        L_0x01c8:
            r8 = r28
        L_0x01ca:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.generateBackgroundWithShadow(int, android.view.View[], org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray):android.graphics.drawable.Drawable");
    }

    private CLUtils getClUtils() {
        if (!(this.clInterface instanceof CLUtils)) {
            this.clInterface = new CLUtils() {
                public Activity getActivity() {
                    return JBridge.this.activity;
                }

                public JsCallback getJsCallback() {
                    return new JsCallback() {
                        public void addJsToWebView(String str) {
                            JBridge.this.juspayServices.getDynamicUI().addJsToWebView(str);
                        }
                    };
                }
            };
        }
        return (CLUtils) this.clInterface;
    }

    private CustomTabsIntent getCustomTabIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        CustomTabColorSchemeParams$Builder customTabColorSchemeParams$Builder = new CustomTabColorSchemeParams$Builder();
        customTabColorSchemeParams$Builder.mToolbarColor = Integer.valueOf(Color.parseColor(str) | -16777216);
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        Integer num = customTabColorSchemeParams$Builder.mToolbarColor;
        Bundle bundle2 = new Bundle();
        if (num != null) {
            bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        intent.putExtras(bundle2);
        return new CustomTabsIntent(intent, null);
    }

    private Map<String, String> getDecodedQueryParameters(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf(InflateView.SETTER_EQUALS);
            hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8").trim(), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8").trim());
        }
        return hashMap;
    }

    private void getImageFromGallery() {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null && this.browserFragment != null) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            this.browserFragment.startActivityForResult(intent, 117);
        }
    }

    @JavascriptInterface
    public static String hmacDigest(String str, String str2, String str3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), str3);
            Mac instance = Mac.getInstance(str3);
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(str.getBytes("ASCII"));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : doFinal) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.activity, "android.permission.CAMERA") == 0;
    }

    /* access modifiers changed from: private */
    public DatePickerDialog newDialogWithoutDateField(final String str) {
        Calendar instance = Calendar.getInstance();
        AnonymousClass10 r4 = new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                JBridge.this.invokeCallbackInDUIWebview(str, i + "/" + (i2 + 1) + "/" + i3);
            }
        };
        AnonymousClass11 r8 = new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                JBridge.this.invokeCallbackInDUIWebview(str, "NaN-NaN");
            }
        };
        AnonymousClass12 r9 = new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                JBridge.this.invokeCallbackInDUIWebview(str, "NaN-NaN");
            }
        };
        if (this.activity == null) {
            return null;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.activity, 2, r4, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.setOnCancelListener(r8);
        datePickerDialog.setOnDismissListener(r9);
        return datePickerDialog;
    }

    /* access modifiers changed from: private */
    public void openQRScanner(final String str, final String str2) {
        if (this.activity == null || TextUtils.isEmpty(str)) {
            JuspayLogger.e(LOG_TAG, "ERROR: Frame ID null!!");
            return;
        }
        final int parseInt = Integer.parseInt(str);
        JuspayLogger.d(LOG_TAG, "Opening QR Scanner inside Frame with ID :" + parseInt);
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                DecoratedBarcodeView decoratedBarcodeView = new DecoratedBarcodeView(JBridge.this.activity);
                decoratedBarcodeView.setLayoutParams(new LayoutParams(-1, -1));
                if (JBridge.this.activity != null) {
                    ViewGroup viewGroup = (ViewGroup) JBridge.this.activity.findViewById(parseInt);
                    if (viewGroup == null) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to find view with resID - ");
                        outline73.append(str);
                        outline73.append(" : ");
                        outline73.append(parseInt);
                        JuspayLogger.e(JBridge.LOG_TAG, outline73.toString());
                        return;
                    }
                    viewGroup.addView(decoratedBarcodeView);
                    JBridge.this.captureManager = new CaptureManager(JBridge.this.activity, decoratedBarcodeView);
                    JBridge.this.captureManager.setBarcodeCallBack(new BarcodeCallback() {
                        public void barcodeResult(BarcodeResult barcodeResult) {
                            try {
                                JuspayLogger.d(JBridge.LOG_TAG, "Scanned QR Result: " + barcodeResult.toString());
                                if (JBridge.this.beepManager == null) {
                                    JBridge.this.beepManager = new BeepManager(JBridge.this.activity);
                                }
                                JBridge.this.beepManager.setBeepEnabled(true);
                                JBridge.this.beepManager.playBeepSound();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("error", BaseParser.FALSE);
                                jSONObject.put("data", Base64.encodeToString(barcodeResult.toString().getBytes(), 2));
                                JBridge.this.invokeCallbackInDUIWebview(str2, jSONObject.toString());
                            } catch (Exception unused) {
                                AnonymousClass28 r6 = AnonymousClass28.this;
                                JBridge.this.invokeCallbackInDUIWebview(str2, String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{Base64.encodeToString("unknown_error".getBytes(), 2)}));
                            }
                        }

                        public void possibleResultPoints(List<ResultPoint> list) {
                        }
                    });
                    JBridge.this.captureManager.onResume();
                    JBridge.this.captureManager.decode();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void readQRFromBitmap(Bitmap bitmap, String str) {
        int[] iArr = new int[(bitmap.getHeight() * bitmap.getWidth())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr)));
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            String str2 = multiFormatReader.decode(binaryBitmap, hashtable).getText().toString();
            JuspayLogger.d(LOG_TAG, "Scanned QR Result: " + str2.toString());
            if (this.beepManager == null) {
                this.beepManager = new BeepManager(this.activity);
            }
            this.beepManager.setBeepEnabled(true);
            this.beepManager.playBeepSound();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", BaseParser.FALSE);
            jSONObject.put("data", URLEncoder.encode(str2, "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20"));
            invokeCallbackInDUIWebview(str, jSONObject.toString());
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unknown_error");
            outline73.append(e2.toString());
            invokeCallbackInDUIWebview(str, String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{Base64.encodeToString(outline73.toString().getBytes(), 2)}));
        }
    }

    /* access modifiers changed from: private */
    public void receiverCallback(Intent intent) {
        Intent intent2 = intent;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject();
            String action = intent.getAction();
            if (action != null) {
                char c2 = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -2034547226) {
                    if (hashCode == 1246126982) {
                        if (action.equals("customtab-result")) {
                            c2 = 1;
                        }
                    }
                } else if (action.equals("amazonpay-result")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        handleCustomTabResult(intent);
                    }
                    sdkTracker.trackApiCalls(ApiCall.SDK, "error", SDK.RECEIVER_CALLBACK, null, null, null, null, null, "unknown_intent", null);
                    return;
                }
                jSONObject.put("signature", intent2.getStringExtra("signature"));
                jSONObject.put("status", intent2.getStringExtra("status"));
                jSONObject.put("transactionId", intent2.getStringExtra("transactionId"));
                jSONObject.put("description", intent2.getStringExtra("description"));
                jSONObject.put("orderCurrency", intent2.getStringExtra("orderTotalAmount"));
                invokeCallbackInDUIWebview((String) this.listenerMap.get("amazonpay-result-cb"), jSONObject.toString());
                return;
            }
            throw new Exception("action is null");
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.RECEIVER_CALLBACK, "JSON Exception", e2);
        }
    }

    private Bitmap screenShot(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private int versionCompare(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equalsIgnoreCase(split2[i])) {
            i++;
        }
        return Integer.signum((i >= split.length || i >= split2.length) ? split.length - split2.length : Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i])));
    }

    @JavascriptInterface
    public void addCardListener(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int parseInt = Integer.parseInt(str);
            if (this.activity != null) {
                EditText editText = (EditText) this.activity.findViewById(parseInt);
                if (editText != null && !this.listenerMap.containsKey("card_listener")) {
                    this.listenerMap.put("card_listener", Boolean.TRUE);
                    if (this.textWatcher != null) {
                        editText.removeTextChangedListener(this.textWatcher);
                        this.textWatcher = null;
                    }
                    AnonymousClass15 r0 = new TextWatcher() {
                        public static final char DIVIDER = ' ';
                        public static final int DIVIDER_MODULO = 5;
                        public static final int DIVIDER_POSITION = 4;
                        public static final int TOTAL_DIGITS = 21;
                        public static final int TOTAL_SYMBOLS = 26;

                        private String buildCorrectString(char[] cArr, int i, char c2) {
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < cArr.length; i2++) {
                                if (cArr[i2] != 0) {
                                    sb.append(cArr[i2]);
                                    if (i2 > 0 && i2 < cArr.length - 1 && (i2 + 1) % i == 0) {
                                        sb.append(c2);
                                    }
                                }
                            }
                            return sb.toString();
                        }

                        private char[] getDigitArray(Editable editable, int i) {
                            char[] cArr = new char[i];
                            int i2 = 0;
                            for (int i3 = 0; i3 < editable.length() && i2 < i; i3++) {
                                char charAt = editable.charAt(i3);
                                if (Character.isDigit(charAt)) {
                                    cArr[i2] = charAt;
                                    i2++;
                                }
                            }
                            return cArr;
                        }

                        private boolean isInputCorrect(Editable editable, int i, int i2, char c2) {
                            boolean z = editable.length() <= i;
                            int i3 = 0;
                            while (i3 < editable.length()) {
                                z &= (i3 <= 0 || (i3 + 1) % i2 != 0) ? Character.isDigit(editable.charAt(i3)) : c2 == editable.charAt(i3);
                                i3++;
                            }
                            return z;
                        }

                        public void afterTextChanged(Editable editable) {
                            if (!isInputCorrect(editable, 26, 5, ' ')) {
                                editable.replace(0, editable.length(), buildCorrectString(getDigitArray(editable, 21), 4, ' '));
                            }
                            HyperFragment hyperFragment = JBridge.this.browserFragment;
                            if (hyperFragment != null && hyperFragment.getDuiInterface() != null) {
                                JBridge.this.browserFragment.getDuiInterface().invokeFnInDUIWebview("executeOnCardNumberChanged", String.valueOf(editable));
                            }
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }
                    };
                    this.textWatcher = r0;
                    editText.addTextChangedListener(r0);
                }
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while adding listener for card entry", e2);
        }
    }

    @JavascriptInterface
    public void addCertificates(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.acceptedCerts.add(jSONArray.getString(i));
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while manipulating JSON", e2);
        }
    }

    @JavascriptInterface
    public void addGestureListener(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int parseInt = Integer.parseInt(str);
            if (this.activity != null) {
                final View findViewById = this.activity.findViewById(parseInt);
                final GestureDetector gestureDetector = new GestureDetector(this.activity, new MyGestureListener(str2));
                if (findViewById != null) {
                    this.activity.runOnUiThread(new Runnable() {
                        public void run() {
                            findViewById.setOnTouchListener(new OnTouchListener() {
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    return gestureDetector.onTouchEvent(motionEvent);
                                }
                            });
                        }
                    });
                    return;
                }
                sdkTracker.trackAction("system", "error", System.JBRIDGE, "addGestureListener", "View with id " + str + " was not found.");
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "error while adding listener for gesture", e2);
        }
    }

    @JavascriptInterface
    public void addOnScrollChangeListener(String str, final String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int parseInt = Integer.parseInt(str);
            if (this.activity != null) {
                final View findViewById = this.activity.findViewById(parseInt);
                if (findViewById != null) {
                    this.activity.runOnUiThread(new Runnable() {
                        public void run() {
                            findViewById.getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener() {
                                public int oldScrollX = 0;
                                public int oldScrollY = 0;

                                public void onScrollChanged() {
                                    int round = Math.round((float) findViewById.getScrollX());
                                    int round2 = Math.round((float) findViewById.getScrollY());
                                    if (round != this.oldScrollX || round2 != this.oldScrollY) {
                                        this.oldScrollX = round;
                                        this.oldScrollY = round2;
                                        AnonymousClass17 r2 = AnonymousClass17.this;
                                        JBridge jBridge = JBridge.this;
                                        String str = str2;
                                        jBridge.invokeCallbackInDUIWebview(str, round + "," + round2);
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
                sdkTracker.trackAction("system", "error", System.JBRIDGE, "addonscrollchangelistener", "View with id " + str + " was not found.");
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "error while adding listener for scroll", e2);
        }
    }

    @JavascriptInterface
    @Deprecated
    public void amazonNonTokenPay(String str, String str2) {
        launchCustomTab(str, str2);
    }

    @JavascriptInterface
    public void amazonPayProcessCharge(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.browserFragment != null && this.browserFragment.getContext() != null) {
                registerReceiver("amazonpay-result");
                this.listenerMap.put("amazonpay-result-cb", str3);
                Intent intent = new Intent(this.activity, CompletionActivity.class);
                intent.putExtra("action", "COMPLETION");
                Intent intent2 = new Intent(this.activity, CompletionActivity.class);
                intent2.putExtra("action", "CANCEL");
                int i = VERSION.SDK_INT >= 23 ? 33554432 : 0;
                PendingIntent activity2 = PendingIntent.getActivity(this.browserFragment.getContext(), 0, intent, i);
                PendingIntent activity3 = PendingIntent.getActivity(this.browserFragment.getContext(), 0, intent2, i);
                Intent intent3 = new Intent("android.intent.action.VIEW");
                CustomTabColorSchemeParams$Builder customTabColorSchemeParams$Builder = new CustomTabColorSchemeParams$Builder();
                customTabColorSchemeParams$Builder.mToolbarColor = Integer.valueOf(-16777216 | -16777216);
                if (!intent3.hasExtra("android.support.customtabs.extra.SESSION")) {
                    Bundle bundle = new Bundle();
                    BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
                    intent3.putExtras(bundle);
                }
                intent3.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                Integer num = customTabColorSchemeParams$Builder.mToolbarColor;
                Bundle bundle2 = new Bundle();
                if (num != null) {
                    bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
                }
                intent3.putExtras(bundle2);
                AmazonPayManager.charge(APayRequestContext.create(this.browserFragment.getContext(), str2, activity2, activity3, new CustomTabsIntent(intent3, null)), str);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "Process Charge Exception", e2);
            unRegisterReceiver();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("signature", "");
                jSONObject.put("status", "");
                jSONObject.put("transactionId", "");
                jSONObject.put("verificationOperationName", "");
                jSONObject.put("verificationParameters", "");
                invokeCallbackInDUIWebview(str3, jSONObject.toString());
            } catch (Exception e3) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "JSON Exception", e3);
            }
        }
    }

    @JavascriptInterface
    public void blurBackground(String str, String str2, int i) {
        if (Utils.isUiFeatureEnabled(this.juspayServices, "blurBackground")) {
            final RenderScript create = RenderScript.create(this.activity);
            Activity activity2 = this.activity;
            if (activity2 != null) {
                final View findViewById = activity2.findViewById(Integer.parseInt(str));
                final View findViewById2 = this.activity.findViewById(Integer.parseInt(str2));
                try {
                    Activity activity3 = this.activity;
                    final int i2 = i;
                    AnonymousClass26 r1 = new Runnable() {
                        public void run() {
                            new BlurProcessor(create, i2, JBridge.this.activity).blurView(findViewById, findViewById2);
                        }
                    };
                    activity3.runOnUiThread(r1);
                } catch (Exception unused) {
                }
            }
        }
    }

    @JavascriptInterface
    public void callAPI(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        DynamicUI dynamicUI = this.juspayServices.getDynamicUI();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        sdkTracker.trackApiCalls("network", "info", Network.BEFORE_REQUEST, null, str2, valueOf, null, JSONObject.NULL, null, str);
        NetUtils netUtils2 = z2 ? this.netUtilsSsl : this.netUtils;
        if (z2) {
            try {
                netUtils2.setSslSocketFactory(new VIESSocketFactory(this.acceptedCerts).a());
            } catch (Exception e2) {
                JuspayLogger.e(LOG_TAG, "Exception: ", e2);
            }
        }
        final SdkTracker sdkTracker2 = sdkTracker;
        final String str6 = str2;
        final Long l = valueOf;
        final String str7 = str3;
        final String str8 = str;
        final String str9 = str5;
        final DynamicUI dynamicUI2 = dynamicUI;
        final String str10 = str4;
        final NetUtils netUtils3 = netUtils2;
        final boolean z3 = z;
        AnonymousClass8 r1 = new AsyncTask<Object, Object, Object>() {
            private HashMap<String, String> toMap(String str) {
                HashMap<String, String> hashMap = new HashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    return hashMap;
                } catch (JSONException unused) {
                    JBridge.this.juspayServices.sdkDebug(JBridge.LOG_TAG, "Not a json string. Passing as such");
                    return null;
                }
            }

            public JuspayHttpResponse doInBackground(Object[] objArr) {
                try {
                    HashMap<String, String> map = toMap(str10);
                    Map map2 = z3 ? toMap(str7) : null;
                    if (HttpGetRequest.METHOD_GET.equals(str8)) {
                        return new JuspayHttpResponse(netUtils3.doGet(str6, map, map2));
                    }
                    if (BuildConfig.SCM_BRANCH.equals(str8)) {
                        return new JuspayHttpResponse(netUtils3.doHead(str6, map, map2));
                    }
                    if (RNCWebViewManager.HTTP_METHOD_POST.equals(str8)) {
                        return map2 == null ? new JuspayHttpResponse(netUtils3.postUrl(new URL(str6), (Map<String, String>) map, str7)) : new JuspayHttpResponse(netUtils3.postUrl(new URL(str6), (Map<String, String>) map, map2));
                    }
                    if ("DELETE".equals(str8)) {
                        return map2 == null ? new JuspayHttpResponse(netUtils3.deleteUrl(new URL(str6), (Map<String, String>) map, str7)) : new JuspayHttpResponse(netUtils3.deleteUrl(new URL(str6), (Map<String, String>) map, map2));
                    }
                    if (!"PUT".equals(str8) || JBridge.this.activity == null) {
                        return null;
                    }
                    return new JuspayHttpResponse(NetUtils.doPut(JBridge.this.activity.getApplicationContext(), new URL(str6), str7.getBytes(), map, netUtils3));
                } catch (SSLHandshakeException unused) {
                    return new JuspayHttpResponse(-2, "SSL Handshake Failed".getBytes(), null);
                } catch (IOException e2) {
                    sdkTracker2.trackAndLogException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Network.NETWORK_CALL, "Exception while calling api", e2);
                    return new JuspayHttpResponse(-1, "Network Error".getBytes(), null);
                } catch (Exception e3) {
                    sdkTracker2.trackAndLogException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Network.NETWORK_CALL, "Exception while calling api", e3);
                    return new JuspayHttpResponse(-1, e3.getLocalizedMessage().getBytes(), null);
                }
            }

            public void onPostExecute(Object obj) {
                DynamicUI dynamicUI;
                String str;
                String str2;
                String str3;
                Integer valueOf = Integer.valueOf(-1);
                if (obj != null) {
                    JuspayHttpResponse juspayHttpResponse = (JuspayHttpResponse) obj;
                    if (juspayHttpResponse.responsePayload != null) {
                        sdkTracker2.trackApiCalls("network", "info", Network.NETWORK_CALL, Integer.valueOf(juspayHttpResponse.responseCode), str6, l, Long.valueOf(System.currentTimeMillis()), str7, new String(juspayHttpResponse.responsePayload), str8);
                    } else {
                        sdkTracker2.trackApiCalls("network", "info", Network.NETWORK_CALL, Integer.valueOf(juspayHttpResponse.responseCode), str6, l, Long.valueOf(System.currentTimeMillis()), str7, null, str8);
                    }
                    int i = juspayHttpResponse.responseCode;
                    String str4 = "";
                    if (i == -1 || i == -2) {
                        byte[] bytes = "{}".getBytes();
                        String encodeToString = Base64.encodeToString(bytes, 2);
                        try {
                            str = String.format("window.callUICallback('%s','%s','%s','%s','%s','%s', '%s');", new Object[]{str9, AnalyticsConstants.FAILURE, encodeToString, Integer.valueOf(juspayHttpResponse.responseCode), Base64.encodeToString(str6.getBytes(), 2), str4, URLEncoder.encode(bytes.toString(), "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20")});
                        } catch (UnsupportedEncodingException unused) {
                            str = String.format("window.callUICallback('%s','%s','%s','%s','%s');", new Object[]{str9, AnalyticsConstants.FAILURE, encodeToString, Integer.valueOf(juspayHttpResponse.responseCode), Base64.encodeToString(str6.getBytes(), 2)});
                        }
                        dynamicUI = dynamicUI2;
                        if (dynamicUI == null) {
                            return;
                        }
                    } else {
                        if (juspayHttpResponse.responsePayload == null) {
                            str3 = str4;
                            str2 = str3;
                        } else {
                            String str5 = new String(juspayHttpResponse.responsePayload);
                            try {
                                String jSONObject = new JSONObject(str5).toString();
                                JBridge.this.juspayServices.sdkDebug("message", jSONObject);
                                str2 = Base64.encodeToString(jSONObject.getBytes(), 2);
                                str3 = URLEncoder.encode(jSONObject, "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20");
                            } catch (Exception e2) {
                                str2 = Base64.encodeToString(str5.getBytes(), 2);
                                try {
                                    str3 = URLEncoder.encode(str5, "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20");
                                } catch (Exception unused2) {
                                    str3 = str4;
                                }
                                JuspayLogger.e(JBridge.LOG_TAG, "This happened: ", e2);
                            }
                        }
                        JuspayServices access$100 = JBridge.this.juspayServices;
                        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str2, CMap.SPACE);
                        outline78.append(juspayHttpResponse.responseCode);
                        access$100.sdkDebug("Response inserted: ", outline78.toString());
                        if (juspayHttpResponse.headers != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (Entry next : juspayHttpResponse.headers.entrySet()) {
                                try {
                                    jSONObject2.put((String) next.getKey(), new JSONArray((Collection) next.getValue()));
                                } catch (Exception unused3) {
                                }
                            }
                            try {
                                JBridge.this.juspayServices.sdkDebug(Constant.HEADER, jSONObject2.toString());
                                str4 = Base64.encodeToString(jSONObject2.toString().getBytes(), 2);
                            } catch (Exception e3) {
                                JuspayLogger.e(JBridge.LOG_TAG, "This happened: ", e3);
                            }
                        }
                        JuspayServices access$1002 = JBridge.this.juspayServices;
                        StringBuilder outline782 = GeneratedOutlineSupport.outline78(str4, CMap.SPACE);
                        outline782.append(juspayHttpResponse.responseCode);
                        access$1002.sdkDebug("Headers inserted: ", outline782.toString());
                        str = String.format("window.callUICallback('%s','%s','%s','%s','%s','%s', '%s');", new Object[]{str9, "success", str2, Integer.valueOf(juspayHttpResponse.responseCode), Base64.encodeToString(str6.getBytes(), 2), str4, str3});
                        JBridge.this.juspayServices.sdkDebug("Js inserted: ", str);
                        dynamicUI = dynamicUI2;
                        if (dynamicUI == null) {
                            return;
                        }
                    }
                } else {
                    sdkTracker2.trackApiCalls("network", "info", Network.NETWORK_CALL, valueOf, str6, l, Long.valueOf(System.currentTimeMillis()), str7, AnalyticsConstants.FAILURE, str8);
                    str = String.format("window.callUICallback('%s','%s','%s','%s','%s','%s');", new Object[]{str9, AnalyticsConstants.FAILURE, Base64.encodeToString("{}".getBytes(), 2), valueOf, Base64.encodeToString(str6.getBytes(), 2), "%7B%7D"});
                    dynamicUI = dynamicUI2;
                    if (dynamicUI == null) {
                        return;
                    }
                }
                dynamicUI.addJsToWebView(str);
            }
        };
        r1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    @JavascriptInterface
    public boolean checkAmazonApiKey() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return Arrays.asList(this.browserFragment != null ? this.browserFragment.getResources().getAssets().list("") : new String[0]).contains("api_key.txt");
        } catch (IOException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "Check Api Key Exception", e2);
            return false;
        }
    }

    @JavascriptInterface
    public void checkAmazonNonTokenSdk(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Class.forName("androidx.browser.customtabs.CustomTabsIntent");
            invokeCallbackInDUIWebview(str, BaseParser.TRUE);
        } catch (ClassNotFoundException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "Amazon Sdk Not found Exception", e2);
            invokeCallbackInDUIWebview(str, BaseParser.FALSE);
        }
    }

    @JavascriptInterface
    public void checkAmazonSdk(String str) {
        invokeCallbackInDUIWebview(str, String.valueOf(checkAmazonSdk()));
    }

    @JavascriptInterface
    public boolean checkAmazonSdk() {
        if (checkAmazonApiKey()) {
            try {
                Class.forName("com.amazon.apay.hardened.external.AmazonPayManager");
                Class.forName("androidx.browser.customtabs.CustomTabsIntent");
                Class.forName("com.amazon.identity.auth.device.AuthError");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @JavascriptInterface
    public boolean checkCLLibrary() {
        try {
            Class.forName("org.npci.upi.security.services.CLRemoteResultReceiver");
            Class.forName("org.npci.upi.security.services.CLServices");
            Class.forName("org.npci.upi.security.services.ServiceConnectionStatusNotifier");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean checkCustomTabs() {
        try {
            Class.forName("androidx.browser.customtabs.CustomTabsIntent");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    @Deprecated
    public void checkPaypalMagnesSdk(String str) {
        invokeCallbackInDUIWebview(str, String.valueOf(checkPaypalMagnesSdk()));
    }

    @JavascriptInterface
    public boolean checkPaypalMagnesSdk() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Class.forName("lib.android.paypal.com.magnessdk.MagnesResult");
            Class.forName("lib.android.paypal.com.magnessdk.MagnesSDK");
            return true;
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.PAYPAL_UTILS, "Paypal magnes sdk not found Exception", e2);
            return false;
        }
    }

    @JavascriptInterface
    @Deprecated
    public void checkPhonePeSdk(String str) {
        invokeCallbackInDUIWebview(str, String.valueOf(checkPhonePeSdk()));
    }

    @JavascriptInterface
    public boolean checkPhonePeSdk() {
        try {
            Class.forName("com.phonepe.android.sdk.api.PhonePe");
            Class.forName("com.phonepe.android.sdk.api.PhonePeInitException");
            Class.forName("com.phonepe.android.sdk.api.builders.TransactionRequestBuilder");
            Class.forName("com.phonepe.android.sdk.base.model.TransactionRequest");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean checkQRScannerLibrary() {
        try {
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat");
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType");
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.ResultPoint");
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager");
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix");
            Class.forName("in.juspay.widget.qrscanner.com.google.zxing.qrcode.QRCodeWriter");
            Class.forName("in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback");
            Class.forName("in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeResult");
            Class.forName("in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.CaptureManager");
            Class.forName("in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.DecoratedBarcodeView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void createKeyStoreEntry(String str, String str2, String str3, String str4) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            SecurityHelper.createKeys(this.activity, str, str2);
            invokeCallbackInDUIWebview(str3, "");
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to create keys", e2);
            invokeCallbackInDUIWebview(str4, e2.toString());
        }
    }

    @JavascriptInterface
    public int cursorPosition(int i) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.activity != null) {
                EditText editText = (EditText) this.activity.findViewById(i);
                if (editText != null) {
                    return editText.getSelectionStart();
                }
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Cursor Position Exception", e2);
        }
        return 0;
    }

    public long dateToMillisecond(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        } catch (ParseException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Error in date to millis", e2);
            return 0;
        }
    }

    @JavascriptInterface
    public String decodeNPCIXmlKeys(String str) {
        return getClUtils().decodeNPCIXmlKeys(str);
    }

    @JavascriptInterface
    public boolean doesPhonePeAppExist(String str) {
        long j;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        boolean z = true;
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.browserFragment.getContext().getPackageManager().getPackageInfo(str, 1);
            j = (long) packageInfo.versionCode;
        } catch (NameNotFoundException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.PHONEPE_UTILS, "Failed to get phonepe package name", e2);
            j = -1;
            packageInfo = packageInfo;
        }
        if (packageInfo == null) {
            return false;
        }
        if (j <= 94033) {
            z = false;
        }
        return z;
    }

    @JavascriptInterface
    public boolean doesSimplExist() {
        try {
            Class.forName("com.simpl.android.fingerprint.SimplFingerprint");
            Class.forName("com.simpl.android.fingerprint.SimplFingerprintListener");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void drawAppIcon(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.browserFragment != null) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    PackageManager packageManager = this.browserFragment.getAttachedActivity().getPackageManager();
                    drawIcon(packageManager.getApplicationInfo(jSONObject.getString("packageName"), 0).loadIcon(packageManager), Integer.parseInt(jSONObject.getString("id")));
                }
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Error happened while parsing json", e2);
        }
    }

    @JavascriptInterface
    public void duiAmazonLinkStatus(String str) {
        invokeCallbackInDUIWebview(this.amazonLinkCallback, str);
    }

    @JavascriptInterface
    public String encryptRSA(String str, String str2) {
        byte[] encryptRSAHelper = encryptRSAHelper(str, str2);
        return encryptRSAHelper == null ? "" : Base64.encodeToString(encryptRSAHelper, 2);
    }

    public byte[] encryptRSAHelper(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----", ""), 0)));
            Cipher instance = Cipher.getInstance(SecurityHelper.RSA_TRANSFORM);
            instance.init(1, generatePublic);
            return instance.doFinal(str2.getBytes());
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception when encrypting using RSA", e2);
            return null;
        }
    }

    @JavascriptInterface
    public void exitApp(int i, String str) {
        SwypeLayout.clear();
        super.exitApp(i, str);
    }

    @JavascriptInterface
    public void expiry(String str) {
        final SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int parseInt = Integer.parseInt(str);
            EditText editText = null;
            if (this.activity != null) {
                editText = (EditText) this.activity.findViewById(parseInt);
            }
            if (editText != null) {
                if (!this.listenerMap.containsKey("delta_expiry")) {
                    if (this.expiryTextWatcher != null) {
                        editText.removeTextChangedListener(this.expiryTextWatcher);
                    }
                    this.listenerMap.put("delta_expiry", Boolean.TRUE);
                    AnonymousClass14 r10 = new TextWatcher() {
                        public int initialLen;

                        public void afterTextChanged(Editable editable) {
                            try {
                                if (!match(editable.toString())) {
                                    if (editable.length() != 2 || this.initialLen != 3) {
                                        StringBuilder sb = new StringBuilder();
                                        int i = 0;
                                        while (true) {
                                            if (i >= editable.length()) {
                                                break;
                                            }
                                            char charAt = editable.charAt(i);
                                            if (Character.isDigit(charAt)) {
                                                sb.append(charAt);
                                                if (sb.length() == 4) {
                                                    break;
                                                }
                                            }
                                            i++;
                                        }
                                        if (sb.length() == 1 && sb.charAt(0) > '1') {
                                            sb.insert(0, '0');
                                        }
                                        if (sb.length() == 2 && ((sb.charAt(0) == '1' && sb.charAt(1) > '2') || (sb.charAt(0) == '0' && sb.charAt(1) == '0'))) {
                                            sb.replace(1, 2, "");
                                        }
                                        if (sb.length() >= 2) {
                                            sb.insert(2, '/');
                                        }
                                        editable.replace(0, editable.length(), sb.toString());
                                        if (!(JBridge.this.browserFragment == null || JBridge.this.browserFragment.getDuiInterface() == null)) {
                                            JBridge.this.browserFragment.getDuiInterface().invokeFnInDUIWebview("executeExpiry", sb.toString());
                                        }
                                        return;
                                    }
                                }
                                if (!(JBridge.this.browserFragment == null || JBridge.this.browserFragment.getDuiInterface() == null)) {
                                    JBridge.this.browserFragment.getDuiInterface().invokeFnInDUIWebview("executeExpiry", editable.toString());
                                }
                            } catch (Exception e2) {
                                sdkTracker.trackAndLogException(JBridge.LOG_TAG, "action", "system", System.JBRIDGE, "Exception happened in afterTextChanged", e2);
                            }
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            this.initialLen = charSequence.length();
                        }

                        public boolean match(String str) {
                            boolean z = false;
                            if (str == null) {
                                return false;
                            }
                            if (str.length() == 1 && Character.isDigit(str.charAt(0)) && str.charAt(0) > '1') {
                                return false;
                            }
                            for (int i = 0; i < str.length(); i++) {
                                if (i != 2 && !Character.isDigit(str.charAt(i))) {
                                    return false;
                                }
                                if (i == 2 && str.charAt(i) != '/') {
                                    return false;
                                }
                            }
                            if (str.length() != 2 && str.length() <= 5) {
                                z = true;
                            }
                            return z;
                        }

                        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }
                    };
                    this.expiryTextWatcher = r10;
                    editText.addTextChangedListener(r10);
                }
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while adding listener for expiry", e2);
        }
    }

    @JavascriptInterface
    public String findApps(String str) {
        Throwable th;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
        JSONArray jSONArray = new JSONArray();
        for (ResolveInfo next : queryIntentActivities) {
            JSONObject jSONObject = new JSONObject();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(next.activityInfo.packageName, 0);
                jSONObject.put("packageName", applicationInfo.packageName);
                jSONObject.put("appName", packageManager.getApplicationLabel(applicationInfo));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                th = e2;
                str6 = LOG_TAG;
                str5 = "action";
                str4 = "system";
                str3 = System.JBRIDGE;
                str2 = "Error While add to json";
            } catch (NameNotFoundException e3) {
                th = e3;
                str6 = LOG_TAG;
                str5 = "action";
                str4 = "system";
                str3 = System.JBRIDGE;
                str2 = "Error while searching for the app";
            }
        }
        return jSONArray.toString();
        sdkTracker.trackAndLogException(str6, str5, str4, str3, str2, th);
    }

    @JavascriptInterface
    public void generateQRCode(String str, String str2, int i, int i2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int parseInt = Integer.parseInt(str2);
            if (this.activity != null) {
                final ImageView imageView = (ImageView) this.activity.findViewById(parseInt);
                if (imageView == null) {
                    JuspayLogger.e(LOG_TAG, "Unable to find view with resID - " + str2 + " : " + parseInt);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(EncodeHintType.MARGIN, Integer.valueOf(i2));
                final BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashMap);
                final int width = encode.getWidth();
                final int height = encode.getHeight();
                Activity activity2 = this.activity;
                final String str4 = str3;
                AnonymousClass31 r3 = new Runnable() {
                    public void run() {
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
                        for (int i = 0; i < width; i++) {
                            for (int i2 = 0; i2 < height; i2++) {
                                createBitmap.setPixel(i, i2, encode.get(i, i2) ? -16777216 : -1);
                            }
                        }
                        imageView.setImageBitmap(createBitmap);
                        JBridge.this.invokeCallbackInDUIWebview(str4, "SUCCESS");
                    }
                };
                activity2.runOnUiThread(r3);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while generating QR Code", e2);
            invokeCallbackInDUIWebview(str3, "FAILURE");
        }
    }

    @JavascriptInterface
    public String generateTrustCred(String str, String str2) {
        return getClUtils().generateTrustCred(str, str2);
    }

    @JavascriptInterface
    public String getBuildInfo() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("BOARD", Build.BOARD);
            jSONObject.put("BRAND", Build.BRAND);
            jSONObject.put("CPU_ABI", Build.CPU_ABI);
            jSONObject.put("CPU_ABI2", Build.CPU_ABI2);
            jSONObject.put("DEVICE", Build.DEVICE);
            jSONObject.put("DISPLAY", Build.DISPLAY);
            jSONObject.put("FINGERPRINT", Build.FINGERPRINT);
            jSONObject.put("HARDWARE", Build.HARDWARE);
            jSONObject.put("HOST", Build.HOST);
            jSONObject.put("ID", Build.ID);
            jSONObject.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject.put("MODEL", Build.MODEL);
            jSONObject.put("PRODUCT", Build.PRODUCT);
            jSONObject.put("RADIO", Build.getRadioVersion());
            jSONObject.put("TAGS", Build.TAGS);
            jSONObject.put("TIME", Build.TIME);
            jSONObject.put("USER", Build.USER);
            jSONObject.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
            jSONObject.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            jSONObject.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
            JSONObject jSONObject2 = new JSONObject();
            if (VERSION.SDK_INT >= 23) {
                jSONObject2.put("BASE_OS", VERSION.BASE_OS);
                jSONObject2.put("INCREMENTAL", VERSION.INCREMENTAL);
                jSONObject2.put("PREVIEW_SDK_INT", VERSION.PREVIEW_SDK_INT);
                jSONObject2.put("SECURITY_PATCH", VERSION.SECURITY_PATCH);
            }
            jSONObject2.put("RELEASE", VERSION.RELEASE);
            jSONObject2.put("SDK_INT", VERSION.SDK_INT);
            jSONObject.put("VERSION", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception fetching build info", e2);
            return "";
        }
    }

    @JavascriptInterface
    public void getChallenge(String str, String str2, String str3) {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null) {
            getClUtils().getChallenge(str, str2, str3);
        }
    }

    @JavascriptInterface
    public void getCredentials(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null && (this.clInterface instanceof CLUtils)) {
            getClUtils().getCredentials(str, str2, str3, str4, str5, str6, str7, str8, str9);
        }
    }

    @JavascriptInterface
    public float getDensity() {
        return (float) (this.activity.getResources().getDisplayMetrics().densityDpi / 160);
    }

    @JavascriptInterface
    public String getDeviceDetails() {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() == null) {
            return null;
        }
        return Base64.encodeToString(this.upiInterface.getDeviceDetails().getBytes(), 2);
    }

    @JavascriptInterface
    @SuppressLint({"HardwareIds"})
    public String getDeviceInfo() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        JSONObject sessionData = this.juspayServices.getSessionInfo().getSessionData();
        try {
            sessionData.put("android_id_raw", Secure.getString(JuspayCoreLib.getApplicationContext().getContentResolver(), "android_id"));
            return sessionData.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while extracting android id", e2);
            return getSessionInfo();
        }
    }

    @JavascriptInterface
    public void getKeyStorePublicKey(String str, String str2, String str3) {
        try {
            invokeCallbackInDUIWebview(str2, Base64.encodeToString(SecurityHelper.getKeyPair(str).getPublic().getEncoded(), 2));
        } catch (Exception e2) {
            invokeCallbackInDUIWebview(str3, e2.toString());
        }
    }

    public NetUtils getNetUtils(boolean z) {
        return z ? this.netUtilsSsl : this.netUtils;
    }

    @JavascriptInterface
    @Deprecated
    public void getPackageName(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            invokeCallbackInDUIWebview(str, this.browserFragment.getContext().getPackageName());
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "NULL Pointer Exception while getting package name", e2);
            invokeCallbackInDUIWebview(str, "ERROR");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPayPalRiskId() {
        /*
            r8 = this;
            in.juspay.hypersdk.core.JuspayServices r0 = r8.juspayServices
            in.juspay.hypersdk.core.SdkTracker r1 = r0.getSdkTracker()
            lib.android.paypal.com.magnessdk.MagnesSettings$Builder r0 = new lib.android.paypal.com.magnessdk.MagnesSettings$Builder     // Catch:{ Exception -> 0x0029 }
            android.app.Activity r2 = r8.activity     // Catch:{ Exception -> 0x0029 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0029 }
            lib.android.paypal.com.magnessdk.MagnesSettings r0 = r0.build()     // Catch:{ Exception -> 0x0029 }
            lib.android.paypal.com.magnessdk.MagnesSDK r2 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x0029 }
            r2.setUp(r0)     // Catch:{ Exception -> 0x0029 }
            lib.android.paypal.com.magnessdk.MagnesSDK r0 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x0029 }
            android.app.Activity r2 = r8.activity     // Catch:{ Exception -> 0x0029 }
            r3 = 0
            if (r0 == 0) goto L_0x0028
            lib.android.paypal.com.magnessdk.MagnesResult r3 = r0.collectAndSubmit(r2, r3, r3)     // Catch:{ InvalidInputException -> 0x0025 }
        L_0x0025:
            java.lang.String r0 = r3.paypalclientmetadataid     // Catch:{ Exception -> 0x0029 }
            return r0
        L_0x0028:
            throw r3     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            r0 = move-exception
            r7 = r0
            java.lang.String r2 = "JBridge"
            java.lang.String r3 = "api_call"
            java.lang.String r4 = "external_sdk"
            java.lang.String r5 = "paypal_utils"
            java.lang.String r6 = "Exception at RiskId"
            r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
            java.lang.String r0 = "ERROR"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.getPayPalRiskId():java.lang.String");
    }

    @JavascriptInterface
    @Deprecated
    public void getPayPalRiskId(String str) {
        invokeCallbackInDUIWebview(str, getPayPalRiskId());
    }

    public HyperFragment getPaymentFragment() {
        return this.browserFragment;
    }

    @JavascriptInterface
    public long getPhonePeVersionCode(String str) {
        PackageManager packageManager = this.activity.getPackageManager();
        if (!doesPhonePeAppExist(str)) {
            return -1;
        }
        try {
            return (long) packageManager.getPackageInfo(str, 1).versionCode;
        } catch (NameNotFoundException e2) {
            String.format("failed to get package info for package name = {%s}, exception message = {%s}", new Object[]{str, e2.getMessage()});
            return -1;
        }
    }

    @JavascriptInterface
    public String getResourceByName(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int identifier = this.juspayServices.getContext().getResources().getIdentifier(str, str2, str3);
            return identifier > 0 ? super.getResourceById(identifier) : "0";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Get Resource Exception", e2);
            return "0";
        }
    }

    @JavascriptInterface
    public String getSHA256Hash(String str) {
        if (str == null) {
            return null;
        }
        SdkTracker sdkTracker = this.browserFragment.getJuspayServices().getSdkTracker();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            String bytesToHexString = EncryptionHelper.bytesToHexString(instance.digest());
            JuspayLogger.d(LOG_TAG, "result is " + bytesToHexString);
            return bytesToHexString;
        } catch (NoSuchAlgorithmException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception caught trying to SHA-256 hash", e2);
            return null;
        }
    }

    @JavascriptInterface
    public String getSIMOperators() {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() == null) {
            return null;
        }
        return Base64.encodeToString(this.upiInterface.getSIMOperators().getBytes(), 2);
    }

    @JavascriptInterface
    public void getSimplFingerPrint(String str, String str2, String str3, final String str4) {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            SimplFingerprint.init(applicationContext, str, str2);
            SimplFingerprint.getInstance().generateFingerprint(new SimplFingerprintListener() {
                public void fingerprintData(String str) {
                    JBridge.this.invokeCallbackInDUIWebview(str4, str);
                }
            });
            return;
        }
        invokeCallbackInDUIWebview(str4, "{\"error\":\"activity_not_present\"");
    }

    @JavascriptInterface
    public String getStatusBarHeight(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return "0";
        }
        try {
            int identifier = activity2.getResources().getIdentifier(str, str2, str3);
            if (identifier <= 0) {
                return "0";
            }
            return "" + this.activity.getResources().getDimensionPixelSize(identifier);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Get Resource Exception", e2);
            return "0";
        }
    }

    @JavascriptInterface
    public void gpay_isReadyToPay(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            final JSONObject jSONObject = new JSONObject();
            JuspayServices juspayServices2 = this.juspayServices;
            final String str4 = str2;
            final String str5 = str3;
            final SdkTracker sdkTracker2 = sdkTracker;
            AnonymousClass19 r1 = new Callback() {
                public boolean handleMessage(Message message) {
                    if (message.what == PaymentConstants.GPAY_CONSTANT) {
                        try {
                            Bundle data = message.getData();
                            if (!data.getBoolean("error")) {
                                jSONObject.put("inAppSdk", data.getBoolean("in_app_sdk"));
                                jSONObject.put("upiIntent", data.getBoolean("upi_intent"));
                                jSONObject.put("inAppSupported", data.getBoolean("in_app_supported"));
                                JBridge.this.invokeCallbackInDUIWebview(str4, jSONObject.toString());
                            } else {
                                jSONObject.put("inAppSdk", false);
                                JBridge.this.invokeCallbackInDUIWebview(str5, data.getString("error_msg"));
                            }
                        } catch (Exception e2) {
                            sdkTracker2.trackAndLogException(JBridge.LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.GPAY_UTILS, "Error while checking GPay isReadyToPay", e2);
                            JBridge.this.invokeCallbackInDUIWebview(str5, e2.toString());
                        }
                    }
                    return false;
                }
            };
            GPayUtils.isReady(juspayServices2, str, r1);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.GPAY_UTILS, "Error while checking GPay isReadyToPay", e2);
            invokeCallbackInDUIWebview(str3, e2.toString());
        }
    }

    @JavascriptInterface
    public void gpay_startInAppPayment(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.browserFragment != null) {
                GPayUtils.pay(this.browserFragment, str);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.GPAY_UTILS, "Error while making GPay payment", e2);
            invokeFnInDUIWebview(str2, e2.toString());
        }
    }

    public void handleCustomTabResult(Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        if (intent != null) {
            try {
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), Utils.toJSON(intent.getExtras()).toString());
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.CUSTOM_TAB, "JSON Exception", e2);
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
            }
        } else {
            invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
        }
    }

    @JavascriptInterface
    public void handlePhonepayActivityResult(String str) {
        String str2 = this.phonepeTxnCallback;
        if (str2 != null) {
            invokeCallbackInDUIWebview(str2, str);
        }
    }

    @JavascriptInterface
    public void hideJuspayLoader(final String str) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (JBridge.this.activity != null) {
                        View findViewById = JBridge.this.activity.findViewById(898989);
                        if (findViewById != null) {
                            int i = 1000;
                            float f2 = 1.0f;
                            float f3 = 0.0f;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                i = Integer.parseInt(jSONObject.optString("animationDuration", "1000"));
                                f2 = Float.parseFloat(jSONObject.optString("startAlpha", "1.0"));
                                f3 = Float.parseFloat(jSONObject.optString("endAlpha", IdManager.DEFAULT_VERSION_NAME));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration((long) i);
                            findViewById.setAnimation(alphaAnimation);
                            FrameLayout container = JBridge.this.juspayServices.getContainer();
                            if (container != null) {
                                container.removeView(findViewById);
                            }
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void hideSoftInput() {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    @JavascriptInterface
    public void initSafeBrowsing() {
        SafetyNetClient safetyNetClient = this.client;
        if (safetyNetClient == null) {
            return;
        }
        if (safetyNetClient != null) {
            safetyNetClient.doRead((TaskApiCall<A, TResult>) new zzl<A,TResult>());
            return;
        }
        throw null;
    }

    @JavascriptInterface
    public boolean isAirplaneModeOn() {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() == null) {
            return false;
        }
        return this.upiInterface.isAirplaneModeOn();
    }

    @JavascriptInterface
    public boolean isCCTSupportedChromeAvailable(String str) {
        try {
            return CustomtabActivity.isChromeInstalled(CustomtabActivity.getCustomTabsPackages(this.browserFragment.getContext(), str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @JavascriptInterface
    public boolean isDualSIM() {
        return PaymentUtils.isDualSim(this.activity);
    }

    @JavascriptInterface
    public boolean isNoLimitsActivity() {
        Activity activity2 = this.activity;
        boolean z = false;
        if (activity2 == null) {
            return false;
        }
        if ((activity2.getWindow().getAttributes().flags & 512) == 512) {
            z = true;
        }
        return z;
    }

    @JavascriptInterface
    public boolean isPlayStoreInstalled() {
        return GoogleApiAvailability.zab.isGooglePlayServicesAvailable(this.activity) == 0;
    }

    @JavascriptInterface
    public boolean isSafetyNetSDKPresent() {
        Class<SafetyNetApi> cls = SafetyNetApi.class;
        try {
            Class.forName(SafetyNet.class.getName());
            Class.forName(cls.getName());
            return true;
        } catch (ClassNotFoundException | Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean isShimmerPossible() {
        try {
            Class.forName("com.facebook.shimmer.ShimmerFrameLayout");
            Class.forName("com.facebook.shimmer.Shimmer");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean isSimActive(int i) {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() == null) {
            return false;
        }
        return this.upiInterface.isSimActive(i);
    }

    @JavascriptInterface
    public boolean isSimSupport() {
        return PaymentUtils.isSimSupport(this.activity);
    }

    @JavascriptInterface
    public String jweDecrypt(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            KeyPair keyPair = SecurityHelper.getKeyPair(str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payload", JOSEUtils.jweDecrypt(str, keyPair.getPrivate()));
            jSONObject.put("error", false);
            return jSONObject.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to decrypt JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e2.toString()});
        }
    }

    @JavascriptInterface
    public String jweEncrypt(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{JOSEUtils.jweEncrypt(str, str2, Base64.decode(str3, 2))});
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to encrypt JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e2.toString()});
        }
    }

    @JavascriptInterface
    public String jwsSign(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{JOSEUtils.jwsSign(str, str2, SecurityHelper.getKeyPair(str3).getPrivate())});
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to sign JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e2.toString()});
        }
    }

    @JavascriptInterface
    public boolean jwsVerify(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return JOSEUtils.jwsVerify(str, Base64.decode(str2, 2));
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to verify JSON Web Token", e2);
            return false;
        }
    }

    @JavascriptInterface
    public boolean keyStoreEntryPresent(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return SecurityHelper.keyExists(str);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while checking if a key exists in key store", e2);
            return false;
        }
    }

    @JavascriptInterface
    public void launchCustomTab(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        this.listenerMap.put("customtab-result-cb", str2);
        try {
            if (this.browserFragment.isOnPause()) {
                sdkTracker.trackAction(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.CUSTOM_TAB, "onPause called before launch customtab");
                unRegisterReceiver();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", "onPause");
                invokeCallbackInDUIWebview(str2, jSONObject.toString());
                return;
            }
            Intent intent = new Intent(this.browserFragment.getContext(), CustomtabActivity.class);
            intent.putExtra("url", str);
            registerReceiver("customtab-result");
            this.browserFragment.startActivity(intent);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.CUSTOM_TAB, "Exception at launch customtab", e2);
            unRegisterReceiver();
            invokeCallbackInDUIWebview(str2, e2.toString());
        }
    }

    @JavascriptInterface
    public void linkAmazonPay(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        this.amazonLinkCallback = str2;
        String codeVerifier = Utils.getCodeVerifier();
        Intent intent = new Intent("android.intent.action.VIEW");
        CustomTabColorSchemeParams$Builder customTabColorSchemeParams$Builder = new CustomTabColorSchemeParams$Builder();
        customTabColorSchemeParams$Builder.mToolbarColor = Integer.valueOf(-16777216 | -16777216);
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        Integer num = customTabColorSchemeParams$Builder.mToolbarColor;
        Bundle bundle2 = new Bundle();
        if (num != null) {
            bundle2.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        intent.putExtras(bundle2);
        Intent authorizationIntent = AmazonPayManager.getAuthorizationIntent(APayRequestContext.create(this.browserFragment.getContext(), str, new CustomTabsIntent(intent, null)), Utils.generateCodeChallenge(codeVerifier));
        try {
            if (this.browserFragment != null) {
                this.browserFragment.startActivityForResult(authorizationIntent, 111);
                invokeCallbackInDUIWebview(str3, codeVerifier);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "Error linking amazon pay", e2);
            invokeCallbackInDUIWebview(str2, e2.toString());
        }
    }

    @JavascriptInterface
    public void loadViesAnimationFor(final String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.activity != null) {
                this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (JBridge.this.viesSensoryBrandingView != null) {
                            JBridge.this.viesSensoryBrandingView.removeAllViews();
                            JBridge.this.viesSensoryBrandingView.destroyDrawingCache();
                        }
                        JBridge.this.viesSensoryBrandingView = new SensoryBrandingView(JBridge.this.activity);
                        JBridge.this.viesSensoryBrandingView.setBackdropColor(Color.parseColor("#ffffff"));
                        JBridge.this.viesSensoryBrandingView.setSoundEnabled(false);
                        JBridge.this.viesSensoryBrandingView.setHapticFeedbackEnabled(false);
                        if (JBridge.this.activity != null) {
                            ((ViewGroup) JBridge.this.activity.findViewById(Integer.parseInt(str))).addView(JBridge.this.viesSensoryBrandingView, 0, new LayoutParams(-1, -1));
                        }
                    }
                });
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while loading VIES animation", e2);
        }
    }

    @JavascriptInterface
    public void loadViesAnimationToRemoveTick(final String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (this.activity != null) {
                this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (JBridge.this.viesSensoryBrandingView != null) {
                            JBridge.this.viesSensoryBrandingView.removeAllViews();
                            JBridge.this.viesSensoryBrandingView.destroyDrawingCache();
                        }
                        JBridge.this.viesSensoryBrandingView = new SensoryBrandingView(JBridge.this.activity);
                        JBridge.this.viesSensoryBrandingView.setBackdropColor(Color.parseColor("#ffffff"));
                        JBridge.this.viesSensoryBrandingView.setSoundEnabled(false);
                        JBridge.this.viesSensoryBrandingView.setHapticFeedbackEnabled(false);
                        JBridge.this.viesSensoryBrandingView.setCheckMarkShown(false);
                        if (JBridge.this.activity != null) {
                            ((ViewGroup) JBridge.this.activity.findViewById(Integer.parseInt(str))).addView(JBridge.this.viesSensoryBrandingView, 0, new LayoutParams(-1, -1));
                        }
                    }
                });
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while loading VIES animation", e2);
        }
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3, int i, int i2) {
        if (this.browserFragment != null) {
            Intent intent = new Intent();
            intent.setPackage(str);
            intent.setAction(str3);
            intent.setData(Uri.parse(str2));
            intent.setFlags(i);
            this.browserFragment.startActivityForResult(intent, i2);
        }
    }

    @JavascriptInterface
    public void playSound(String str, String str2) {
        AssetFileDescriptor openFd;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
        mediaPlayer.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                mediaPlayer.stop();
                mediaPlayer.release();
                return true;
            }
        });
        try {
            openFd = this.activity.getResources().getAssets().openFd(str);
            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception unused) {
            mediaPlayer.release();
        } catch (Throwable th) {
            openFd.close();
            throw th;
        }
    }

    @JavascriptInterface
    public void populateHMAC(String str, String str2, String str3, String str4) {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null) {
            getClUtils().populateHMAC(str, str2, str3, str4);
        }
    }

    @JavascriptInterface
    public void registerApp(String str, String str2, String str3, String str4, String str5) {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null) {
            getClUtils().registerApp(str, str2, str3, str4, str5);
        }
    }

    @JavascriptInterface
    public void registerReceiver(String str) {
        if (this.activity != null && this.broadcastReceiver == null) {
            this.broadcastReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    JBridge.this.receiverCallback(intent);
                }
            };
            LocalBroadcastManager.getInstance(this.activity).registerReceiver(this.broadcastReceiver, new IntentFilter(str));
        }
    }

    @JavascriptInterface
    public void removeKeyFromKeyStore(String str) {
        try {
            SecurityHelper.deleteKey(str);
        } catch (Exception unused) {
        }
    }

    public void reset() {
        super.reset();
        unRegisterReceiver();
    }

    @JavascriptInterface
    @Deprecated
    public String rsaEncryption(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Cipher instance = Cipher.getInstance(str2);
            instance.init(1, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 2))));
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{Base64.encodeToString(instance.doFinal(str.getBytes()), 2)});
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while trying to encrypt using RSA", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e2.toString()});
        }
    }

    @JavascriptInterface
    public String saveImage(int i) {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() == null || this.browserFragment == null) {
            return "";
        }
        return Media.insertImage(this.activity.getApplicationContext().getContentResolver(), screenShot(this.activity.findViewById(i)), "qr", null);
    }

    @JavascriptInterface
    public void scanQRFromGallery(final String str) {
        this.listenerMap.put(PaymentConstants.GALLERY, new ResultAwaitingDuiHook() {
            public void attach(Activity activity) {
            }

            public void detach(Activity activity) {
            }

            public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
                return null;
            }

            public boolean onActivityResult(int i, int i2, Intent intent) {
                if (JBridge.this.GALLERY_KITKAT_INTENT_CALLED != i && 117 != i) {
                    return false;
                }
                InputStream inputStream = null;
                try {
                    inputStream = JuspayCoreLib.getApplicationContext().getContentResolver().openInputStream(intent.getData());
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
                JBridge.this.readQRFromBitmap(BitmapFactory.decodeStream(new BufferedInputStream(inputStream)), str);
                JBridge.this.listenerMap.remove(PaymentConstants.GALLERY);
                return true;
            }
        });
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.browserFragment.startActivityForResult(intent, this.GALLERY_KITKAT_INTENT_CALLED);
    }

    @JavascriptInterface
    public String scrollVisibleTop(String str) {
        Activity activity2 = this.activity;
        ScrollView scrollView = activity2 != null ? (ScrollView) activity2.findViewById(Integer.parseInt(str)) : null;
        if (scrollView == null) {
            return "";
        }
        Rect rect = new Rect();
        scrollView.getDrawingRect(rect);
        return GeneratedOutlineSupport.outline57(new StringBuilder(), (int) (((float) rect.top) / this.activity.getResources().getDisplayMetrics().density), "");
    }

    @JavascriptInterface
    public void sendSMS(String str, String str2, String str3, String str4) {
        sendSMS(str, new String[]{str}, str3, "1", str4);
    }

    @JavascriptInterface
    public void sendSMS(String str, String[] strArr, String str2, String str3, String str4) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.getApplicationContext() != null) {
            this.upiInterface.sendSms(str, strArr, str2, str3, str4);
        } else {
            sdkTracker.trackAction("system", "error", System.JBRIDGE, "sendsms", "Browser fragment is null. Can't send SMS.");
        }
    }

    @JavascriptInterface
    public boolean sendSafetyNetRequest(String str, String str2, final String str3, final String str4) {
        byte[] requestNonce = SecurityHelper.getRequestNonce(str);
        if (requestNonce != null && GoogleApiAvailability.zab.isGooglePlayServicesAvailable(this.juspayServices.getContext()) == 0) {
            SafetyNetClient client2 = SafetyNet.getClient(this.juspayServices.getContext());
            this.client = client2;
            Task task = PendingResultUtil.toTask(zzk.zza(client2.asGoogleApiClient(), requestNonce, str2), new zaq(new AttestationResponse()));
            AnonymousClass21 r5 = new Executor() {
                public void execute(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            };
            zzw zzw = (zzw) task;
            zzw.zzb.zza(new zzn(r5, new OnSuccessListener<AttestationResponse>() {
                public void onSuccess(AttestationResponse attestationResponse) {
                    JBridge.this.invokeCallbackInDUIWebview(str3, ((zza) attestationResponse.zza).getJwsResult());
                }
            }));
            zzw.zzi();
            zzw.zzb.zza(new com.google.android.gms.tasks.zzl(r5, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    String str;
                    String str2;
                    JBridge jBridge;
                    if (exc instanceof ApiException) {
                        ApiException apiException = (ApiException) exc;
                        jBridge = JBridge.this;
                        str2 = str4;
                        str = CommonStatusCodes.getStatusCodeString(apiException.mStatus.zzc) + ": " + apiException.getMessage();
                    } else {
                        jBridge = JBridge.this;
                        str2 = str4;
                        str = exc.getMessage();
                    }
                    jBridge.invokeCallbackInDUIWebview(str2, str);
                }
            }));
            zzw.zzi();
            return true;
        } else if (GoogleApiAvailability.zab.isGooglePlayServicesAvailable(this.activity) == 0) {
            return false;
        } else {
            invokeCallbackInDUIWebview(str4, "UPDATE_GOOGLE_SERVICE");
            return true;
        }
    }

    public void setActivity(Activity activity2) {
        super.setActivity(activity2);
        this.activity = activity2;
    }

    @JavascriptInterface
    public void setCLAlgorithm(String str, String str2) {
        getClUtils().setAlgorithm(str, str2);
    }

    @JavascriptInterface
    public void setShadow(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            final JSONArray jSONArray = new JSONArray(str);
            final JSONArray jSONArray2 = new JSONArray(str3);
            final JSONArray jSONArray3 = new JSONArray(str5);
            final JSONArray jSONArray4 = new JSONArray(str6);
            final JSONArray jSONArray5 = new JSONArray(str7);
            final JSONArray jSONArray6 = new JSONArray(str2);
            final JSONArray jSONArray7 = new JSONArray(str4);
            final JSONArray jSONArray8 = new JSONArray(str8);
            if (this.activity != null) {
                Activity activity2 = this.activity;
                final int i2 = i;
                final SdkTracker sdkTracker2 = sdkTracker;
                AnonymousClass18 r1 = new Runnable() {
                    public void run() {
                        View[] viewArr = new View[jSONArray2.length()];
                        int i = 0;
                        while (i < jSONArray2.length()) {
                            try {
                                viewArr[i] = JBridge.this.activity.findViewById(jSONArray.getInt(i));
                                i++;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (viewArr[0] != null) {
                            View view = (View) viewArr[0].getParent();
                            View view2 = (View) view.getParent();
                            if (i2 == 2) {
                                view = view2;
                            }
                            try {
                                view.setBackground(JBridge.this.generateBackgroundWithShadow(i2, viewArr, jSONArray6, jSONArray2, jSONArray7, jSONArray3, jSONArray4, jSONArray5, jSONArray8));
                            } catch (Exception e3) {
                                sdkTracker2.trackAndLogException(JBridge.LOG_TAG, "action", "system", System.JBRIDGE, "Error while setting background for shadow", e3);
                            }
                        }
                    }
                };
                activity2.runOnUiThread(r1);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Error while setting background for shadow", e2);
        }
    }

    @JavascriptInterface
    public void shareImage(int i, String str, String str2, String str3) {
        Activity activity2 = this.activity;
        if (activity2 != null && activity2.getApplicationContext() != null && this.browserFragment != null) {
            try {
                Uri parse = Uri.parse(Media.insertImage(this.activity.getApplicationContext().getContentResolver(), screenShot(this.activity.findViewById(i)), "qr", null));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.SUBJECT", str);
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra("android.intent.extra.STREAM", parse);
                this.browserFragment.startActivity(Intent.createChooser(intent, str3));
            } catch (Exception e2) {
                JuspayLogger.d(LOG_TAG, "Exception in share qr :" + e2);
            }
        }
    }

    @JavascriptInterface
    public void showJuspayLoader(final String str) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (JBridge.this.activity != null && JBridge.this.activity.findViewById(898989) == null) {
                        int i = 2100;
                        int i2 = 1000;
                        float f2 = 0.0f;
                        float f3 = 1.0f;
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            i = Integer.parseInt(jSONObject.optString("rotationDuration", "2100"));
                            i2 = Integer.parseInt(jSONObject.optString("animationDuration", "1000"));
                            f2 = Float.parseFloat(jSONObject.optString("startAlpha", IdManager.DEFAULT_VERSION_NAME));
                            f3 = Float.parseFloat(jSONObject.optString("endAlpha", "1.0"));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        LinearLayout linearLayout = new LinearLayout(JBridge.this.activity);
                        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                        linearLayout.setGravity(17);
                        linearLayout.setId(898989);
                        linearLayout.setClickable(true);
                        LinearLayout linearLayout2 = new LinearLayout(JBridge.this.activity);
                        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        linearLayout2.setOrientation(1);
                        linearLayout2.setGravity(1);
                        ImageView imageView = new ImageView(JBridge.this.activity);
                        imageView.setBackgroundResource(R.drawable.juspay_icon);
                        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) JBridge.dpToPx(48.0f, JBridge.this.activity), (int) JBridge.dpToPx(48.0f, JBridge.this.activity)));
                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 350.0f, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setInterpolator(new LinearInterpolator());
                        rotateAnimation.setRepeatCount(-1);
                        rotateAnimation.setDuration((long) i);
                        imageView.startAnimation(rotateAnimation);
                        TextView textView = new TextView(JBridge.this.activity);
                        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        textView.setPadding(0, (int) JBridge.dpToPx(10.0f, JBridge.this.activity), 0, (int) JBridge.dpToPx(20.0f, JBridge.this.activity));
                        textView.setTextSize(16.0f);
                        textView.setTextColor(Color.parseColor("#000000"));
                        textView.setText("Processing your payment");
                        ImageView imageView2 = new ImageView(JBridge.this.activity);
                        imageView2.setBackgroundResource(R.drawable.juspay_safe);
                        imageView2.setLayoutParams(new LinearLayout.LayoutParams((int) JBridge.dpToPx(90.0f, JBridge.this.activity), (int) JBridge.dpToPx(12.0f, JBridge.this.activity)));
                        ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, (int) JBridge.dpToPx(24.0f, JBridge.this.activity), 0, 0);
                        linearLayout2.addView(imageView);
                        linearLayout2.addView(imageView2);
                        linearLayout2.addView(textView);
                        linearLayout.addView(linearLayout2);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
                        alphaAnimation.setInterpolator(new DecelerateInterpolator());
                        alphaAnimation.setDuration((long) i2);
                        linearLayout.setAnimation(alphaAnimation);
                        FrameLayout container = JBridge.this.juspayServices.getContainer();
                        if (container != null) {
                            container.addView(linearLayout);
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void shutdownSafeBrowsing() {
        SafetyNetClient safetyNetClient = this.client;
        if (safetyNetClient == null) {
            return;
        }
        if (safetyNetClient != null) {
            safetyNetClient.doRead((TaskApiCall<A, TResult>) new com.google.android.gms.safetynet.zzn<A,TResult>());
            return;
        }
        throw null;
    }

    @JavascriptInterface
    @TargetApi(11)
    public void startDatePicker(final String str, final String str2, final String str3) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    DatePickerDialog access$500 = JBridge.this.newDialogWithoutDateField(str);
                    if (access$500 != null) {
                        String str = str2;
                        if (str != null && !str.isEmpty() && !str2.equals("undefined")) {
                            access$500.getDatePicker().setMinDate(JBridge.this.dateToMillisecond(str2));
                        }
                        String str2 = str3;
                        if (str2 != null && !str2.isEmpty() && !str3.equals("undefined")) {
                            access$500.getDatePicker().setMaxDate(JBridge.this.dateToMillisecond(str3));
                        }
                        View findViewById = access$500.getDatePicker().findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                        access$500.show();
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void startLottieAnimation(int i, String str, boolean z, float f2, float f3) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            final SdkTracker sdkTracker = hyperFragment.getJuspayServices().getSdkTracker();
            Activity activity2 = this.activity;
            if (activity2 != null) {
                final int i2 = i;
                final String str2 = str;
                final boolean z2 = z;
                final float f4 = f2;
                final float f5 = f3;
                AnonymousClass20 r1 = new Runnable() {
                    public void run() {
                        try {
                            if (JBridge.this.activity != null) {
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) JBridge.this.activity.findViewById(i2);
                                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                                lottieAnimationView.setAnimation(str2);
                                lottieAnimationView.setRepeatCount(z2 ? -1 : 0);
                                lottieAnimationView.lottieDrawable.setMinAndMaxProgress(f4, f5);
                                lottieAnimationView.playAnimation();
                            }
                        } catch (Exception e2) {
                            sdkTracker.trackAndLogException(JBridge.LOG_TAG, "action", "system", System.JBRIDGE, "Exception while playing Lottie animation", e2);
                        }
                    }
                };
                activity2.runOnUiThread(r1);
            }
        }
    }

    @JavascriptInterface
    public void startPaytmRequest(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (versionCompare(str2, "8.6.0") < 0) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nativeSdkForMerchantAmount", jSONObject.optString("nativeSdkForMerchantAmount"));
                bundle.putString("orderid", jSONObject.optString("orderid"));
                bundle.putString(SMTEventParamKeys.SMT_MID, jSONObject.optString(SMTEventParamKeys.SMT_MID));
                bundle.putString("txnToken", jSONObject.optString("txnToken"));
                intent.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
                intent.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
                intent.putExtra("bill", bundle);
                this.browserFragment.startActivityForResult(intent, 116);
                this.juspayServices.sdkDebug("paytmSDkParams1", intent.toString());
                return;
            }
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
            intent2.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
            intent2.putExtra("enable_paytm_invoke", jSONObject.optBoolean("enable_paytm_invoke"));
            intent2.putExtra("paytm_invoke", jSONObject.optBoolean("paytm_invoke"));
            intent2.putExtra(ECommerceParamNames.PRICE, jSONObject.optString(ECommerceParamNames.PRICE));
            intent2.putExtra("nativeSdkEnabled", jSONObject.optBoolean("nativeSdkEnabled"));
            intent2.putExtra("orderid", jSONObject.optString("orderid"));
            intent2.putExtra("txnToken", jSONObject.optString("txnToken"));
            intent2.putExtra(SMTEventParamKeys.SMT_MID, jSONObject.optString(SMTEventParamKeys.SMT_MID));
            this.browserFragment.startActivityForResult(intent2, 116);
            this.juspayServices.sdkDebug("paytmSDkParams2", intent2.toString());
        } catch (JSONException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.PAYTM_UTILS, "Paytm Init Exception", e2);
            invokeCallbackInDUIWebview(str3, e2.toString());
        }
    }

    @JavascriptInterface
    public void startPhonepeRequest(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setPackage(str2);
        this.browserFragment.startActivityForResult(intent, 113);
    }

    @JavascriptInterface
    @Deprecated
    public void startPhonepeRequest(String str, String str2, String str3, String str4) {
        invokeCallbackInDUIWebview(str4, "Function deprecated");
    }

    @JavascriptInterface
    public void startQRScanner(final String str, final String str2) {
        if (isPermissionGranted()) {
            openQRScanner(str, str2);
        } else {
            requestPermission(new String[]{"android.permission.CAMERA"}, (String) "101", (Callback) new Callback() {
                public boolean handleMessage(Message message) {
                    if (JBridge.this.isPermissionGranted()) {
                        JBridge.this.openQRScanner(str, str2);
                    } else {
                        JBridge.this.invokeCallbackInDUIWebview(str2, String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{Base64.encodeToString("permission_denied".getBytes(), 2)}));
                    }
                    return false;
                }
            });
        }
    }

    @JavascriptInterface
    public void startViesAnimationFor() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (JBridge.this.viesSensoryBrandingView != null) {
                        JBridge.this.viesSensoryBrandingView.animate();
                    }
                }
            });
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while starting VIES animation", e2);
        }
    }

    @JavascriptInterface
    public void stopScanning() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (JBridge.this.captureManager != null) {
                        JBridge.this.captureManager.onPause();
                        JBridge.this.captureManager.onDestroy();
                        JBridge.this.captureManager = null;
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void unRegisterReceiver() {
        Activity activity2 = this.activity;
        if (activity2 != null && this.broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(activity2).unregisterReceiver(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
    }
}
