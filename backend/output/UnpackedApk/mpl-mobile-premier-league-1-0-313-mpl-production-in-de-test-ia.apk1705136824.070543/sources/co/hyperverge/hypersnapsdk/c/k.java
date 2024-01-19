package co.hyperverge.hypersnapsdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import co.hyperverge.hypersnapsdk.R$string;
import com.RNFetchBlob.RNFetchBlob;
import com.RNFetchBlob.RNFetchBlobUtils$1;
import com.RNFetchBlob.RNFetchBlobUtils$2;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.parser.ColorParser;
import com.airbnb.lottie.parser.FloatParser;
import com.airbnb.lottie.parser.IntegerParser;
import com.airbnb.lottie.parser.KeyframesParser;
import com.airbnb.lottie.parser.PointFParser;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.backends.android.AndroidAudio;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.DataCollector$2;
import com.braintreepayments.api.GooglePayment$1;
import com.braintreepayments.api.PayPal$1;
import com.braintreepayments.api.PayPal$2;
import com.braintreepayments.api.ThreeDSecure$4;
import com.braintreepayments.api.ThreeDSecure$7;
import com.braintreepayments.api.ThreeDSecureActivity;
import com.braintreepayments.api.TokenizationClient$1;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.GooglePaymentException;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.internal.BraintreeHttpClient;
import com.braintreepayments.api.internal.SignatureVerification;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.GooglePaymentCardNonce;
import com.braintreepayments.api.models.PayPalAccountNonce;
import com.braintreepayments.api.models.PayPalProductAttributes;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.PaymentMethodBuilder;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.PostalAddress;
import com.braintreepayments.api.models.ReadyForGooglePaymentRequest;
import com.braintreepayments.api.models.ThreeDSecureAdditionalInformation;
import com.braintreepayments.api.models.ThreeDSecureInfo;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecurePostalAddress;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.braintreepayments.api.models.ThreeDSecureV1UiCustomization;
import com.braintreepayments.browserswitch.BrowserSwitchOptions;
import com.braintreepayments.browserswitch.ChromeCustomTabs$1;
import com.braintreepayments.cardform.R$color;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils$1;
import com.bumptech.glide.load.ImageHeaderParserUtils$4;
import com.bumptech.glide.load.ImageHeaderParserUtils$OrientationReader;
import com.bumptech.glide.load.ImageHeaderParserUtils$TypeReader;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.cardinalcommerce.cardinalmobilesdk.a.a.e;
import com.cardinalcommerce.cardinalmobilesdk.a.a.f;
import com.cardinalcommerce.cardinalmobilesdk.a.d.c$1;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.models.Payload;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.c;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.d;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.shared.cs.e.b;
import com.cardinalcommerce.shared.cs.e.i;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.clevertap.android.pushtemplates.PTConstants;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.TemplateRenderer.LogLevel;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.login.ConfigurableIdentityRepo;
import com.clevertap.android.sdk.login.IdentityRepo;
import com.clevertap.android.sdk.login.LegacyIdentityRepo;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationReceiver;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$FileDeleteException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.kount.api.DataCollector;
import com.mpl.androidapp.MPLApplicationLifeCycleCallback;
import com.mpl.androidapp.utils.Constant;
import com.mpl.payment.routing.RoutingConstants;
import com.paynimo.android.payment.PaymentActivity;
import com.paypal.android.sdk.onetouch.core.CheckoutRequest;
import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.squareup.picasso.NetworkRequestHandler;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.OkHttpClient;
import org.apache.fontbox.ttf.GlyfDescript;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.entities.invitation.InvitationReply;

/* compiled from: LanguageHelper */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f3106a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f93a;
    public static Application app;
    public static AndroidAudio audio;

    /* renamed from: b  reason: collision with root package name */
    public static Context f3107b;

    /* renamed from: b  reason: collision with other field name */
    public static String f94b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3108c;

    /* renamed from: e  reason: collision with root package name */
    public static String f3109e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3110f;
    public static Files files;
    public static String g;
    public static GL20 gl;
    public static GL20 gl20;
    public static GL30 gl30;
    public static Graphics graphics;
    public static String h;
    public static Input input;

    /* renamed from: net  reason: collision with root package name */
    public static Net f3111net;
    public static String sDFReferenceId;

    public static float EOCF_sRGB(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static float OECF_sRGB(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow((double) f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " may not be negative"));
    }

    public static int a(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length * 8;
    }

    public static int a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << GlyfDescript.X_DUAL) | ((bArr[i3] & 255) << 8);
    }

    public static f a(String str) {
        String str2;
        f fVar = new f();
        JSONObject jSONObject = new JSONObject(str);
        fVar.f1861b = jSONObject.optInt("ErrorNumber", 0);
        fVar.f1862c = jSONObject.optString("Message", "");
        if (fVar.f1861b == 0) {
            String optString = jSONObject.optString("CardinalJWT", "");
            if (optString != null) {
                String a2 = a(optString);
                if (a2 != null) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    jSONObject2.optString("iss", "");
                    jSONObject2.optString("iat", "");
                    jSONObject2.optString("exp", "");
                    jSONObject2.optString("jti", "");
                    fVar.h = jSONObject2.optString("ConsumerSessionId", "");
                    jSONObject2.optString("ReferenceId", "");
                    jSONObject2.optString("aud", "");
                    jSONObject2.optString("jti", "");
                    jSONObject2.optString("jti", "");
                    String optString2 = jSONObject2.optString("Payload", "");
                    Payload payload = new Payload();
                    if (!optString2.equals("")) {
                        JSONObject jSONObject3 = new JSONObject(optString2);
                        String optString3 = jSONObject3.optString("DeviceFingerprintingURL", "");
                        e eVar = new e();
                        if (!optString3.equals("")) {
                            Uri parse = Uri.parse(optString3);
                            String scheme = parse.getScheme();
                            String authority = parse.getAuthority();
                            String[] split = ((String) Objects.requireNonNull(parse.getPath())).split("/");
                            StringBuilder outline81 = GeneratedOutlineSupport.outline81(scheme, "://", authority, "/");
                            outline81.append(split[1]);
                            String sb = outline81.toString();
                            String queryParameter = parse.getQueryParameter("orgUnitId");
                            if (queryParameter != null) {
                                eVar.f1855a = queryParameter;
                            }
                            String queryParameter2 = parse.getQueryParameter("referenceId");
                            if (queryParameter2 != null) {
                                eVar.f1856b = queryParameter2;
                            }
                            String queryParameter3 = parse.getQueryParameter("threatmetrix");
                            if (queryParameter3 != null) {
                                boolean booleanValue = Boolean.valueOf(queryParameter3).booleanValue();
                                eVar.f1857c = Boolean.valueOf(booleanValue);
                                if (booleanValue) {
                                    String queryParameter4 = parse.getQueryParameter("tmEventType");
                                    if (queryParameter4 != null && !queryParameter4.isEmpty()) {
                                        eVar.f1858d = queryParameter4;
                                    }
                                }
                            }
                            String queryParameter5 = parse.getQueryParameter("geolocation");
                            if (queryParameter5 != null) {
                                Boolean.valueOf(queryParameter5);
                            }
                            eVar.f1859f = sb;
                        }
                        payload.deviceFingerprint = eVar;
                        payload.deviceFingerprintUrl = optString3;
                        jSONObject3.optBoolean("EnabledCCA", false);
                        jSONObject3.optBoolean("EnabledDiscover", false);
                        jSONObject3.optBoolean("EnabledPaypal", false);
                        payload.f1898c = jSONObject3.optInt("ErrorNumber", 0);
                        str2 = jSONObject3.optString("ErrorDescription", "");
                    } else {
                        payload.f1898c = 10214;
                        str2 = "Cardinal Init Response Error. Missing field :Payload";
                    }
                    payload.f1899d = str2;
                    fVar.f1860a = payload;
                }
            }
        }
        return fVar;
    }

    public static d a(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        try {
            return d.a(d(jSONObject, (String) "kty"));
        } catch (IllegalArgumentException e2) {
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    public static <T> T a(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str, Class<T> cls) {
        if (jSONObject.get(str) == null) {
            return null;
        }
        T t = jSONObject.get(str);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        throw new ParseException(GeneratedOutlineSupport.outline52("Unexpected type of JSON object member with key \"", str, "\""), 0);
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " may not be null"));
    }

    public static String a(EncryptionMethod encryptionMethod, Collection<EncryptionMethod> collection) {
        return "Unsupported JWE encryption method " + encryptionMethod + ", must be " + a((Collection) collection);
    }

    public static String a(Collection collection) {
        String str;
        StringBuilder sb = new StringBuilder();
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                if (i < array.length - 1) {
                    str = ", ";
                } else if (i == array.length - 1) {
                    str = " or ";
                }
                sb.append(str);
            }
            sb.append(array[i].toString());
        }
        return sb.toString();
    }

    public static List<Base64> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (i < jSONArray.size()) {
            Object obj = jSONArray.get(i);
            if (obj == null) {
                throw new ParseException(GeneratedOutlineSupport.outline42("The X.509 certificate at position ", i, " must not be null"), 0);
            } else if (obj instanceof String) {
                linkedList.add(new Base64((String) obj));
                i++;
            } else {
                throw new ParseException(GeneratedOutlineSupport.outline42("The X.509 certificate at position ", i, " must be encoded as a Base64 string"), 0);
            }
        }
        return linkedList;
    }

    public static void a() {
        if (f3107b != null) {
            Intent intent = new Intent("finish_activity");
            f93a = true;
            f3107b.sendBroadcast(intent);
        }
    }

    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void a(long j, byte[] bArr, int i) {
        a((int) (j >>> 32), bArr, i);
        a((int) (j & 4294967295L), bArr, i + 4);
    }

    public static void a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 >= 0) {
                int i4 = i + i3;
                bArr[i4] = (byte) (bArr[i4] ^ bArr2[i2 + i3]);
            } else {
                return;
            }
        }
    }

    public static void a(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        do {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
            int i3 = i2 + 1;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
            int i4 = i3 + 1;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i + i4]);
            int i5 = i4 + 1;
            bArr[i5] = (byte) (bArr[i5] ^ bArr2[i + i5]);
            i2 = i5 + 1;
        } while (i2 < 16);
    }

    public static boolean a(String str, int i) {
        return !str.equals("") && str.length() == i;
    }

    public static boolean a(String str, int i, boolean z) {
        if (!z) {
            return d(str, i);
        }
        return str.length() == i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i != bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) ((i >>> 16) & InvitationReply.EXPIRED), (byte) ((i >>> 8) & InvitationReply.EXPIRED), (byte) (i & InvitationReply.EXPIRED)};
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m291a(byte[] bArr) {
        return ByteBuffer.allocate(8).putLong((long) b(bArr)).array();
    }

    public static byte[] a(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                if (bArr2 != null) {
                    byteArrayOutputStream.write(bArr2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static long[] m292a(byte[] bArr) {
        long[] jArr = new long[2];
        a(bArr, 0, jArr);
        return jArr;
    }

    public static int a1(byte[] bArr) {
        return (bArr[3] & 255) | (bArr[0] << 24) | ((bArr[1] & 255) << GlyfDescript.X_DUAL) | ((bArr[2] & 255) << 8);
    }

    public static boolean a1(String str) {
        return !str.equals("");
    }

    public static boolean a1(byte[] bArr, byte[] bArr2) {
        boolean z = false;
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            b2 |= bArr[i] ^ bArr2[i];
        }
        if (b2 == 0) {
            z = true;
        }
        return z;
    }

    public static boolean a2(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean a3(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static void access$000(BraintreeFragment braintreeFragment, ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookupListener threeDSecureLookupListener) {
        JSONObject jSONObject;
        BraintreeHttpClient braintreeHttpClient = braintreeFragment.mHttpClient;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("payment_methods/");
        outline73.append(threeDSecureRequest.mNonce);
        outline73.append("/three_d_secure/lookup");
        String versionedPath = versionedPath(outline73.toString());
        String str = sDFReferenceId;
        JSONObject jSONObject2 = new JSONObject();
        ThreeDSecurePostalAddress threeDSecurePostalAddress = threeDSecureRequest.mBillingAddress;
        ThreeDSecureAdditionalInformation threeDSecureAdditionalInformation = threeDSecureRequest.mAdditionalInformation;
        if (threeDSecureAdditionalInformation == null) {
            jSONObject = new JSONObject();
        } else {
            JSONObject jSONObject3 = new JSONObject();
            try {
                if (threeDSecureAdditionalInformation.mShippingAddress != null) {
                    jSONObject3.putOpt("shipping_given_name", threeDSecureAdditionalInformation.mShippingAddress.mGivenName);
                    jSONObject3.putOpt("shipping_surname", threeDSecureAdditionalInformation.mShippingAddress.mSurname);
                    jSONObject3.putOpt("shipping_phone", threeDSecureAdditionalInformation.mShippingAddress.mPhoneNumber);
                    jSONObject3.putOpt("shipping_line1", threeDSecureAdditionalInformation.mShippingAddress.mStreetAddress);
                    jSONObject3.putOpt("shipping_line2", threeDSecureAdditionalInformation.mShippingAddress.mExtendedAddress);
                    jSONObject3.putOpt("shipping_line3", threeDSecureAdditionalInformation.mShippingAddress.mLine3);
                    jSONObject3.putOpt("shipping_city", threeDSecureAdditionalInformation.mShippingAddress.mLocality);
                    jSONObject3.putOpt("shipping_state", threeDSecureAdditionalInformation.mShippingAddress.mRegion);
                    jSONObject3.putOpt("shipping_postal_code", threeDSecureAdditionalInformation.mShippingAddress.mPostalCode);
                    jSONObject3.putOpt("shipping_country_code", threeDSecureAdditionalInformation.mShippingAddress.mCountryCodeAlpha2);
                }
                jSONObject3.putOpt("shipping_method_indicator", threeDSecureAdditionalInformation.mShippingMethodIndicator);
                jSONObject3.putOpt("product_code", threeDSecureAdditionalInformation.mProductCode);
                jSONObject3.putOpt("delivery_timeframe", threeDSecureAdditionalInformation.mDeliveryTimeframe);
                jSONObject3.putOpt("delivery_email", threeDSecureAdditionalInformation.mDeliveryEmail);
                jSONObject3.putOpt("reorder_indicator", threeDSecureAdditionalInformation.mReorderIndicator);
                jSONObject3.putOpt("preorder_indicator", threeDSecureAdditionalInformation.mPreorderIndicator);
                jSONObject3.putOpt("preorder_date", threeDSecureAdditionalInformation.mPreorderDate);
                jSONObject3.putOpt("gift_card_amount", threeDSecureAdditionalInformation.mGiftCardAmount);
                jSONObject3.putOpt("gift_card_currency_code", threeDSecureAdditionalInformation.mGiftCardCurrencyCode);
                jSONObject3.putOpt("gift_card_count", threeDSecureAdditionalInformation.mGiftCardCount);
                jSONObject3.putOpt("account_age_indicator", threeDSecureAdditionalInformation.mAccountAgeIndicator);
                jSONObject3.putOpt("account_create_date", threeDSecureAdditionalInformation.mAccountCreateDate);
                jSONObject3.putOpt("account_change_indicator", threeDSecureAdditionalInformation.mAccountChangeIndicator);
                jSONObject3.putOpt("account_change_date", threeDSecureAdditionalInformation.mAccountChangeDate);
                jSONObject3.putOpt("account_pwd_change_indicator", threeDSecureAdditionalInformation.mAccountPwdChangeIndicator);
                jSONObject3.putOpt("account_pwd_change_date", threeDSecureAdditionalInformation.mAccountPwdChangeDate);
                jSONObject3.putOpt("shipping_address_usage_indicator", threeDSecureAdditionalInformation.mShippingAddressUsageIndicator);
                jSONObject3.putOpt("shipping_address_usage_date", threeDSecureAdditionalInformation.mShippingAddressUsageDate);
                jSONObject3.putOpt("transaction_count_day", threeDSecureAdditionalInformation.mTransactionCountDay);
                jSONObject3.putOpt("transaction_count_year", threeDSecureAdditionalInformation.mTransactionCountYear);
                jSONObject3.putOpt("add_card_attempts", threeDSecureAdditionalInformation.mAddCardAttempts);
                jSONObject3.putOpt("account_purchases", threeDSecureAdditionalInformation.mAccountPurchases);
                jSONObject3.putOpt("fraud_activity", threeDSecureAdditionalInformation.mFraudActivity);
                jSONObject3.putOpt("shipping_name_indicator", threeDSecureAdditionalInformation.mShippingNameIndicator);
                jSONObject3.putOpt("payment_account_indicator", threeDSecureAdditionalInformation.mPaymentAccountIndicator);
                jSONObject3.putOpt("payment_account_age", threeDSecureAdditionalInformation.mPaymentAccountAge);
                jSONObject3.putOpt("address_match", threeDSecureAdditionalInformation.mAddressMatch);
                jSONObject3.putOpt("account_id", threeDSecureAdditionalInformation.mAccountId);
                jSONObject3.putOpt("ip_address", threeDSecureAdditionalInformation.mIpAddress);
                jSONObject3.putOpt("order_description", threeDSecureAdditionalInformation.mOrderDescription);
                jSONObject3.putOpt("tax_amount", threeDSecureAdditionalInformation.mTaxAmount);
                jSONObject3.putOpt(AnalyticsConstants.USER_AGENT, threeDSecureAdditionalInformation.mUserAgent);
                jSONObject3.putOpt("authentication_indicator", threeDSecureAdditionalInformation.mAuthenticationIndicator);
                jSONObject3.putOpt("installment", threeDSecureAdditionalInformation.mInstallment);
                jSONObject3.putOpt("purchase_date", threeDSecureAdditionalInformation.mPurchaseDate);
                jSONObject3.putOpt("recurring_end", threeDSecureAdditionalInformation.mRecurringEnd);
                jSONObject3.putOpt("recurring_frequency", threeDSecureAdditionalInformation.mRecurringFrequency);
                jSONObject3.putOpt("sdk_max_timeout", threeDSecureAdditionalInformation.mSdkMaxTimeout);
                jSONObject3.putOpt("work_phone_number", threeDSecureAdditionalInformation.mWorkPhoneNumber);
            } catch (JSONException unused) {
            }
            jSONObject = jSONObject3;
        }
        try {
            jSONObject2.put("amount", threeDSecureRequest.mAmount);
            jSONObject2.put("additional_info", jSONObject);
            jSONObject2.putOpt("account_type", threeDSecureRequest.mAccountType);
            jSONObject.putOpt("mobile_phone_number", threeDSecureRequest.mMobilePhoneNumber);
            jSONObject.putOpt("shipping_method", threeDSecureRequest.mShippingMethod);
            jSONObject.putOpt("email", threeDSecureRequest.mEmail);
            if (threeDSecurePostalAddress != null) {
                jSONObject.putOpt("billing_given_name", threeDSecurePostalAddress.mGivenName);
                jSONObject.putOpt("billing_surname", threeDSecurePostalAddress.mSurname);
                jSONObject.putOpt("billing_line1", threeDSecurePostalAddress.mStreetAddress);
                jSONObject.putOpt("billing_line2", threeDSecurePostalAddress.mExtendedAddress);
                jSONObject.putOpt("billing_line3", threeDSecurePostalAddress.mLine3);
                jSONObject.putOpt("billing_city", threeDSecurePostalAddress.mLocality);
                jSONObject.putOpt("billing_state", threeDSecurePostalAddress.mRegion);
                jSONObject.putOpt("billing_postal_code", threeDSecurePostalAddress.mPostalCode);
                jSONObject.putOpt("billing_country_code", threeDSecurePostalAddress.mCountryCodeAlpha2);
                jSONObject.putOpt("billing_phone_number", threeDSecurePostalAddress.mPhoneNumber);
            }
            if ("2".equals(threeDSecureRequest.mVersionRequested)) {
                jSONObject2.putOpt("df_reference_id", str);
            }
            jSONObject2.put("challenge_requested", threeDSecureRequest.mChallengeRequested);
            jSONObject2.put("data_only_requested", threeDSecureRequest.mDataOnlyRequested);
            jSONObject2.put("exemption_requested", threeDSecureRequest.mExemptionRequested);
        } catch (JSONException unused2) {
        }
        braintreeHttpClient.post(versionedPath, jSONObject2.toString(), new ThreeDSecure$7(threeDSecureLookupListener, threeDSecureRequest, braintreeFragment));
    }

    public static void access$200(BraintreeFragment braintreeFragment, PayPalRequest payPalRequest, boolean z, HttpResponseCallback httpResponseCallback) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str = payPalRequest.mCurrencyCode;
        if (str == null) {
            str = braintreeFragment.mConfiguration.mPayPalConfiguration.mCurrencyIsoCode;
        }
        CheckoutRequest checkoutRequest = getCheckoutRequest(braintreeFragment, null);
        JSONObject put = new JSONObject().put("return_url", checkoutRequest.mSuccessUrl).put("cancel_url", checkoutRequest.mCancelUrl).put("offer_paypal_credit", payPalRequest.mOfferCredit).put("offer_pay_later", payPalRequest.mOfferPayLater);
        Authorization authorization = braintreeFragment.mAuthorization;
        if (authorization instanceof ClientToken) {
            put.put("authorization_fingerprint", authorization.getBearer());
        } else {
            put.put(RoutingConstants.KILLBILL_UPOINT_CLIENT_KEY, authorization.getBearer());
        }
        if (!z) {
            put.put("amount", payPalRequest.mAmount).put("currency_iso_code", str).put(AnalyticsConstants.INTENT, payPalRequest.mIntent);
            if (!payPalRequest.mLineItems.isEmpty()) {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                Iterator<PayPalLineItem> it = payPalRequest.mLineItems.iterator();
                while (it.hasNext()) {
                    PayPalLineItem next = it.next();
                    if (next != null) {
                        try {
                            jSONObject2 = new JSONObject().putOpt("description", next.mDescription).putOpt("kind", next.mKind).putOpt("name", next.mName).putOpt("product_code", next.mProductCode).putOpt(ECommerceParamNames.QUANTITY, next.mQuantity).putOpt("unit_amount", next.mUnitAmount).putOpt("unit_tax_amount", next.mUnitTaxAmount).putOpt("url", next.mUrl);
                        } catch (JSONException unused) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONArray.put(jSONObject2);
                    } else {
                        throw null;
                    }
                }
                put.put("line_items", jSONArray);
            }
        } else {
            if (!TextUtils.isEmpty(payPalRequest.mBillingAgreementDescription)) {
                put.put("description", payPalRequest.mBillingAgreementDescription);
            }
            PayPalProductAttributes payPalProductAttributes = payPalRequest.mProductAttributes;
            if (payPalProductAttributes != null) {
                put.put("product_attributes", new JSONObject().put("charge_pattern", payPalProductAttributes.mChargePattern).put("name", payPalProductAttributes.mName).put("product_code", payPalProductAttributes.mProductCode));
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("no_shipping", !payPalRequest.mShippingAddressRequired);
        jSONObject3.put("landing_page_type", payPalRequest.mLandingPageType);
        String str2 = payPalRequest.mDisplayName;
        if (TextUtils.isEmpty(str2)) {
            str2 = braintreeFragment.mConfiguration.mPayPalConfiguration.mDisplayName;
        }
        jSONObject3.put("brand_name", str2);
        String str3 = payPalRequest.mLocaleCode;
        if (str3 != null) {
            jSONObject3.put("locale_code", str3);
        }
        if (payPalRequest.mShippingAddressOverride != null) {
            jSONObject3.put("address_override", !payPalRequest.mShippingAddressEditable);
            if (z) {
                jSONObject = new JSONObject();
                put.put("shipping_address", jSONObject);
            } else {
                jSONObject = put;
            }
            PostalAddress postalAddress = payPalRequest.mShippingAddressOverride;
            jSONObject.put("line1", postalAddress.mStreetAddress);
            jSONObject.put("line2", postalAddress.mExtendedAddress);
            jSONObject.put("city", postalAddress.mLocality);
            jSONObject.put("state", postalAddress.mRegion);
            jSONObject.put("postal_code", postalAddress.mPostalCode);
            jSONObject.put("country_code", postalAddress.mCountryCodeAlpha2);
            jSONObject.put("recipient_name", postalAddress.mRecipientName);
        } else {
            jSONObject3.put("address_override", false);
        }
        String str4 = payPalRequest.mMerchantAccountId;
        if (str4 != null) {
            put.put("merchant_account_id", str4);
        }
        put.put("experience_profile", jSONObject3);
        braintreeFragment.mHttpClient.post(GeneratedOutlineSupport.outline50("/v1/", z ? "paypal_hermes/setup_billing_agreement" : "paypal_hermes/create_payment_resource"), put.toString(), httpResponseCallback);
    }

    public static <T extends Action> T action(Class<T> cls) {
        Pool<T> pool = Pools.get(cls);
        T t = (Action) pool.obtain();
        t.pool = pool;
        return t;
    }

    public static Intent addChromeCustomTabsExtras(Context context, Intent intent) {
        if (isAvailable(context)) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
            intent.addFlags(134250496);
        }
        return intent;
    }

    public static int b(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        long length = ((long) bArr.length) * 8;
        int i = (int) length;
        if (((long) i) == length) {
            return i;
        }
        throw new com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.e();
    }

    public static com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.e b(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.e.a(d(jSONObject, (String) "use"));
    }

    /* renamed from: b  reason: collision with other method in class */
    public static X509Certificate m293b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        if (generateCertificate instanceof X509Certificate) {
            return (X509Certificate) generateCertificate;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not a X.509 certificate: ");
        outline73.append(generateCertificate.getType());
        throw new CertificateException(outline73.toString());
    }

    public static void b(long j, long[] jArr, int i) {
        long j2 = ((j >>> 16) ^ j) & 4294901760L;
        long j3 = j ^ (j2 ^ (j2 << 16));
        long j4 = ((j3 >>> 8) ^ j3) & 280375465148160L;
        long j5 = j3 ^ (j4 ^ (j4 << 8));
        long j6 = ((j5 >>> 4) ^ j5) & 67555025218437360L;
        long j7 = j5 ^ (j6 ^ (j6 << 4));
        long j8 = ((j7 >>> 2) ^ j7) & 868082074056920076L;
        long j9 = j7 ^ (j8 ^ (j8 << 2));
        long j10 = ((j9 >>> 1) ^ j9) & 2459565876494606882L;
        long j11 = j9 ^ (j10 ^ (j10 << 1));
        jArr[i] = j11 & -6148914691236517206L;
        jArr[i + 1] = (j11 << 1) & -6148914691236517206L;
    }

    public static void b(byte[] bArr, byte[] bArr2) {
        int i = 0;
        do {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i2 + 1;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i3 + 1;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i = i4 + 1;
        } while (i < 16);
    }

    public static void b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr2[0];
        long j4 = jArr2[1];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        for (int i = 0; i < 64; i++) {
            long j8 = j >> 63;
            j <<= 1;
            j6 ^= j3 & j8;
            long j9 = j7 ^ (j4 & j8);
            long j10 = j2 >> 63;
            j2 <<= 1;
            j7 = j9 ^ (j3 & j10);
            j5 ^= j4 & j10;
            j4 = (j4 >>> 1) | (j3 << 63);
            j3 = (j3 >>> 1) ^ (((j4 << 63) >> 8) & -2233785415175766016L);
        }
        jArr[0] = ((((j5 >>> 1) ^ j5) ^ (j5 >>> 2)) ^ (j5 >>> 7)) ^ j6;
        jArr[1] = (((j5 << 63) ^ (j5 << 62)) ^ (j5 << 57)) ^ j7;
    }

    public static boolean b(Object obj) {
        return obj == null;
    }

    public static boolean b(String str) {
        if (str.equals("")) {
            return false;
        }
        return !str.equals("");
    }

    public static boolean b(String str, int i) {
        return str.equals("") || str.length() <= i;
    }

    public static byte[] b(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) {
        try {
            return a(secretKey, false, bArr, provider).doFinal(bArr2);
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static byte[] m294b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b1(byte[] r5) {
        /*
            r0 = 0
            java.util.zip.Inflater r1 = new java.util.zip.Inflater     // Catch:{ all -> 0x0035 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0035 }
            java.util.zip.InflaterInputStream r2 = new java.util.zip.InflaterInputStream     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0033 }
            r3.<init>(r5)     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0030 }
            r5.<init>()     // Catch:{ all -> 0x0030 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0030 }
        L_0x001a:
            int r3 = r2.read(r0)     // Catch:{ all -> 0x0030 }
            if (r3 <= 0) goto L_0x0025
            r4 = 0
            r5.write(r0, r4, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x0025:
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x0030 }
            r2.close()
            r1.end()
            return r5
        L_0x0030:
            r5 = move-exception
            r0 = r2
            goto L_0x0037
        L_0x0033:
            r5 = move-exception
            goto L_0x0037
        L_0x0035:
            r5 = move-exception
            r1 = r0
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.end()
        L_0x0041:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.b1(byte[]):byte[]");
    }

    public static org.json.JSONArray buildCardNetworks(BraintreeFragment braintreeFragment) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        ArrayList arrayList = new ArrayList();
        for (String str : braintreeFragment.mConfiguration.mGooglePaymentConfiguration.mSupportedNetworks) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2038717326:
                    if (str.equals("mastercard")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2997727:
                    if (str.equals("amex")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3619905:
                    if (str.equals("visa")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 273184745:
                    if (str.equals("discover")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                arrayList.add(Integer.valueOf(5));
            } else if (c2 == 1) {
                arrayList.add(Integer.valueOf(4));
            } else if (c2 == 2) {
                arrayList.add(Integer.valueOf(1));
            } else if (c2 == 3) {
                arrayList.add(Integer.valueOf(2));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue == 1) {
                jSONArray.put(PaymentActivity.CARD_I_AUTHORITY_AMEX);
            } else if (intValue == 2) {
                jSONArray.put(PaymentActivity.CARD_I_AUTHORITY_DISCOVER);
            } else if (intValue == 3) {
                jSONArray.put(PaymentActivity.CARD_I_AUTHORITY_JCB);
            } else if (intValue == 4) {
                jSONArray.put("MASTERCARD");
            } else if (intValue == 5) {
                jSONArray.put(PaymentActivity.CARD_I_AUTHORITY_VISA);
            }
        }
        return jSONArray;
    }

    public static Set<c> c(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return c.a(h(jSONObject, "key_ops"));
    }

    public static boolean c(String str, int i) {
        boolean z = true;
        if (str.equals("")) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        if (str.length() > i) {
            z = false;
        }
        return z;
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static int checkElementIndex(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = format("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 >= 0) {
            str = format("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("negative size: ", i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNull1(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void completeVerificationFlowWithNoncePayload(BraintreeFragment braintreeFragment, CardNonce cardNonce) {
        ThreeDSecureInfo threeDSecureInfo = cardNonce.mThreeDSecureInfo;
        braintreeFragment.sendAnalyticsEvent(String.format("three-d-secure.verification-flow.liability-shifted.%b", new Object[]{Boolean.valueOf(threeDSecureInfo.mLiabilityShifted)}));
        braintreeFragment.sendAnalyticsEvent(String.format("three-d-secure.verification-flow.liability-shift-possible.%b", new Object[]{Boolean.valueOf(threeDSecureInfo.mLiabilityShiftPossible)}));
        braintreeFragment.mCachedPaymentMethodNonces.add(0, cardNonce);
        braintreeFragment.postOrQueueCallback(new QueuedCallback(cardNonce) {
            public void run() {
                BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
            }
        });
    }

    public static void continuePerformVerification(BraintreeFragment braintreeFragment, ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookup threeDSecureLookup) {
        boolean z = threeDSecureLookup.mAcsUrl != null;
        String str = threeDSecureLookup.mThreeDSecureVersion;
        braintreeFragment.sendAnalyticsEvent(String.format("three-d-secure.verification-flow.challenge-presented.%b", new Object[]{Boolean.valueOf(z)}));
        braintreeFragment.sendAnalyticsEvent(String.format("three-d-secure.verification-flow.3ds-version.%s", new Object[]{str}));
        if (!z) {
            completeVerificationFlowWithNoncePayload(braintreeFragment, threeDSecureLookup.mCardNonce);
        } else if (!str.startsWith("2.")) {
            String str2 = braintreeFragment.mReturnUrlScheme;
            String str3 = braintreeFragment.mConfiguration.mAssetsUrl;
            Uri build = new Builder().scheme(str2).authority("x-callback-url").appendEncodedPath("braintree/threedsecure?").build();
            Uri build2 = Uri.parse(str3).buildUpon().appendEncodedPath("mobile/three-d-secure-redirect/0.2.0").appendEncodedPath("redirect.html").build();
            if (threeDSecureRequest != null) {
                ThreeDSecureV1UiCustomization threeDSecureV1UiCustomization = threeDSecureRequest.mV1UiCustomization;
                if (!(threeDSecureV1UiCustomization == null || threeDSecureV1UiCustomization.mRedirectButtonText == null)) {
                    build2 = build2.buildUpon().appendQueryParameter("b", threeDSecureV1UiCustomization.mRedirectButtonText).build();
                }
                if (!(threeDSecureV1UiCustomization == null || threeDSecureV1UiCustomization.mRedirectDescription == null)) {
                    build2 = build2.buildUpon().appendQueryParameter("d", threeDSecureV1UiCustomization.mRedirectDescription).build();
                }
            }
            Uri build3 = build2.buildUpon().appendQueryParameter("redirect_url", build.toString()).build();
            String uri = Uri.parse(str3).buildUpon().appendEncodedPath("mobile/three-d-secure-redirect/0.2.0").appendEncodedPath("index.html").appendQueryParameter("AcsUrl", threeDSecureLookup.mAcsUrl).appendQueryParameter("PaReq", threeDSecureLookup.mPareq).appendQueryParameter("MD", threeDSecureLookup.mMd).appendQueryParameter("TermUrl", threeDSecureLookup.mTermUrl).appendQueryParameter("ReturnUrl", build3.buildUpon().query(build3.getEncodedQuery()).build().toString()).build().toString();
            BrowserSwitchOptions browserSwitchOptions = new BrowserSwitchOptions();
            browserSwitchOptions.requestCode = 13487;
            browserSwitchOptions.url = Uri.parse(uri);
            braintreeFragment.browserSwitchClient.start(browserSwitchOptions, braintreeFragment);
        } else {
            braintreeFragment.sendAnalyticsEvent("three-d-secure.verification-flow.started");
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.braintreepayments.api.ThreeDSecureActivity.EXTRA_THREE_D_SECURE_LOOKUP", threeDSecureLookup);
            Intent intent = new Intent(braintreeFragment.mContext, ThreeDSecureActivity.class);
            intent.putExtras(bundle);
            braintreeFragment.startActivityForResult(intent, 13487);
        }
    }

    public static HashMap<String, Object> convertRatingBundleObjectToHashMap(Bundle bundle) {
        bundle.remove("config");
        HashMap<String, Object> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            if (str.contains("wzrk_") || str.equals("pt_id")) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    hashMap.putAll(convertRatingBundleObjectToHashMap((Bundle) obj));
                } else {
                    hashMap.put(str, bundle.get(str));
                }
            }
        }
        return hashMap;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.clevertap.android.sdk.validation.ValidationResult create(int r9, int r10, java.lang.String... r11) {
        /*
            com.clevertap.android.sdk.validation.ValidationResult r0 = new com.clevertap.android.sdk.validation.ValidationResult
            r0.<init>()
            r0.errorCode = r9
            r1 = 531(0x213, float:7.44E-43)
            java.lang.String r2 = ""
            if (r9 == r1) goto L_0x02a1
            r1 = 2
            java.lang.String r3 = " characters. Trimmed"
            java.lang.String r4 = "... exceeds the limit of "
            java.lang.String r5 = ")"
            java.lang.String r6 = " wasn't a primitive ("
            r7 = 1
            r8 = 0
            switch(r9) {
                case 510: goto L_0x0279;
                case 511: goto L_0x0227;
                case 512: goto L_0x0137;
                case 513: goto L_0x0103;
                case 514: goto L_0x00b8;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r9) {
                case 520: goto L_0x0279;
                case 521: goto L_0x0058;
                case 522: goto L_0x0054;
                case 523: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x02a3
        L_0x0020:
            r9 = 23
            if (r10 == r9) goto L_0x003e
            r9 = 24
            if (r10 == r9) goto L_0x002a
            goto L_0x02a3
        L_0x002a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "... is a restricted key for multi-value properties. Operation aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x003e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Invalid multi-value property key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
        L_0x0051:
            r2 = r9
            goto L_0x02a3
        L_0x0054:
            java.lang.String r2 = "Charged event contained more than 50 items."
            goto L_0x02a3
        L_0x0058:
            switch(r10) {
                case 11: goto L_0x009e;
                case 12: goto L_0x007b;
                case 13: goto L_0x005d;
                default: goto L_0x005b;
            }     // Catch:{ Exception -> 0x02a3 }
        L_0x005b:
            goto L_0x02a3
        L_0x005d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Invalid user profile property array count - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " max is - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x007b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Multi value property for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " exceeds the limit of "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " items. Trimmed"
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x009e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r4)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r3)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x00b8:
            switch(r10) {
                case 18: goto L_0x00ff;
                case 19: goto L_0x00fb;
                case 20: goto L_0x00dc;
                case 21: goto L_0x00bd;
                default: goto L_0x00bb;
            }     // Catch:{ Exception -> 0x02a3 }
        L_0x00bb:
            goto L_0x02a3
        L_0x00bd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Attempted to set invalid custom CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = ", falling back to default error CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x00dc:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " already exists. Unable to set custom CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x00fb:
            java.lang.String r9 = "CLEVERTAP_USE_CUSTOM_ID has not been specified in the AndroidManifest.xml. Custom CleverTap ID passed will not be used."
            goto L_0x0051
        L_0x00ff:
            java.lang.String r9 = "CLEVERTAP_USE_CUSTOM_ID has been specified in the AndroidManifest.xml/Instance Configuration. CleverTap SDK will create a fallback device ID"
            goto L_0x0051
        L_0x0103:
            r9 = 16
            if (r10 == r9) goto L_0x0122
            r9 = 17
            if (r10 == r9) goto L_0x010d
            goto L_0x02a3
        L_0x010d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " is a discarded event name. Last event aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0122:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " is a restricted event name. Last event aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0137:
            r9 = 25
            if (r10 == r9) goto L_0x020d
            switch(r10) {
                case 1: goto L_0x01f3;
                case 2: goto L_0x01ef;
                case 3: goto L_0x01d0;
                case 4: goto L_0x01b6;
                case 5: goto L_0x01b2;
                case 6: goto L_0x01ae;
                case 7: goto L_0x0184;
                case 8: goto L_0x016f;
                case 9: goto L_0x0155;
                case 10: goto L_0x0140;
                default: goto L_0x013e;
            }     // Catch:{ Exception -> 0x02a3 }
        L_0x013e:
            goto L_0x02a3
        L_0x0140:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Recording of Notification Viewed is disabled in the CleverTap Dashboard for notification payload: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0155:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Unable to render notification, channelId: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " not registered by the app."
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x016f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Unable to render notification, channelId is required but not provided in the notification payload: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0184:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "For event \""
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "\": Property value for property "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r1]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x01ae:
            java.lang.String r9 = "Key is empty, profile removeValueForKey aborted."
            goto L_0x0051
        L_0x01b2:
            java.lang.String r9 = "Invalid phone number"
            goto L_0x0051
        L_0x01b6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Device country code not available and profile phone: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = " does not appear to start with country code"
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x01d0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Object value wasn't a primitive ("
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = ") for profile field "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x01ef:
            java.lang.String r9 = "Profile push key is empty"
            goto L_0x0051
        L_0x01f3:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Invalid multi value for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = ", profile multi value operation aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x020d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "Increment/Decrement value for profile key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = ", cannot be zero or negative"
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0227:
            r9 = 7
            if (r10 == r9) goto L_0x024f
            r9 = 15
            if (r10 == r9) goto L_0x022f
            goto L_0x02a3
        L_0x022f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "An item's object value for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x024f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = "For event "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r10 = ": Property value for property "
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r1]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x0279:
            r9 = 11
            if (r10 == r9) goto L_0x0286
            r9 = 14
            if (r10 == r9) goto L_0x0282
            goto L_0x02a3
        L_0x0282:
            java.lang.String r9 = "Event Name is null"
            goto L_0x0051
        L_0x0286:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a3 }
            r9.<init>()     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r4)     // Catch:{ Exception -> 0x02a3 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a3 }
            r9.append(r3)     // Catch:{ Exception -> 0x02a3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x0051
        L_0x02a1:
            java.lang.String r2 = "Profile Identifiers mismatch with the previously saved ones"
        L_0x02a3:
            r0.errorDesc = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.create(int, int, java.lang.String[]):com.clevertap.android.sdk.validation.ValidationResult");
    }

    public static int d(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << GlyfDescript.X_DUAL);
    }

    public static a d(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return a.a(d(jSONObject, (String) "alg"));
    }

    public static String d(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str) {
        return (String) a(jSONObject, str, String.class);
    }

    public static boolean d(String str, int i) {
        return str.equals("") || str.length() == i;
    }

    public static void debug(String str) {
        int i = TemplateRenderer.debugLevel;
        int intValue = LogLevel.DEBUG.intValue();
    }

    public static DelayAction delay(float f2, Action action) {
        DelayAction delayAction = (DelayAction) action(DelayAction.class);
        delayAction.duration = f2;
        delayAction.action = action;
        return delayAction;
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File deleteRecursively : listFiles) {
                z &= deleteRecursively(deleteRecursively);
            }
        }
        return z;
    }

    public static void deleteImageFromStorage(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("wzrk_pid");
        File dir = new ContextWrapper(context.getApplicationContext()).getDir("pt_dir", 0);
        String absolutePath = dir.getAbsolutePath();
        String[] list = dir.list();
        if (list != null) {
            for (String str : list) {
                if (stringExtra == null || !str.contains(stringExtra)) {
                    if (stringExtra == null && str.contains("null") && !new File(GeneratedOutlineSupport.outline52(absolutePath, "/", str)).delete()) {
                        debug("Failed to clean up the following file: " + str);
                    }
                } else if (!new File(GeneratedOutlineSupport.outline52(absolutePath, "/", str)).delete()) {
                    debug("Failed to clean up the following file: " + str);
                }
            }
        }
    }

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }

    public static void deleteSilentNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (!(notificationManager == null || VERSION.SDK_INT < 26 || notificationManager.getNotificationChannel("pt_silent_sound_channel") == null)) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("pt_silent_sound_channel");
            boolean z = false;
            if (!(VERSION.SDK_INT < 26 || notificationChannel == null || notificationChannel.getImportance() == 0)) {
                z = true;
            }
            if (z) {
                notificationManager.deleteNotificationChannel("pt_silent_sound_channel");
            }
        }
    }

    public static JSONObject displayUnitFromExtras(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String string = bundle.getString("wzrk_adunit");
        Logger.v("Received Display Unit via push payload: " + string);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        jSONObject.put("adUnit_notifs", jSONArray);
        jSONArray.put(new JSONObject(string));
        return jSONObject;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) throws NullPointerException {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static String e(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return d(jSONObject, (String) "kid");
    }

    public static URI e(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str) {
        String d2 = d(jSONObject, str);
        if (d2 == null) {
            return null;
        }
        try {
            return new URI(d2);
        } catch (URISyntaxException e2) {
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    public static void emitWarningEvent(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", "warn");
        createMap.putString("detail", str);
        ((RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobMessage", createMap);
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int evaluate(float f2, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f3 = ((float) ((i >> 24) & InvitationReply.EXPIRED)) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(((float) ((i >> 16) & InvitationReply.EXPIRED)) / 255.0f);
        float EOCF_sRGB2 = EOCF_sRGB(((float) ((i >> 8) & InvitationReply.EXPIRED)) / 255.0f);
        float EOCF_sRGB3 = EOCF_sRGB(((float) (i & InvitationReply.EXPIRED)) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(((float) ((i2 >> 16) & InvitationReply.EXPIRED)) / 255.0f);
        float EOCF_sRGB5 = EOCF_sRGB(((float) ((i2 >> 8) & InvitationReply.EXPIRED)) / 255.0f);
        float EOCF_sRGB6 = EOCF_sRGB(((float) (i2 & InvitationReply.EXPIRED)) / 255.0f);
        float outline3 = GeneratedOutlineSupport.outline3(((float) ((i2 >> 24) & InvitationReply.EXPIRED)) / 255.0f, f3, f2, f3);
        float outline32 = GeneratedOutlineSupport.outline3(EOCF_sRGB4, EOCF_sRGB, f2, EOCF_sRGB);
        float outline33 = GeneratedOutlineSupport.outline3(EOCF_sRGB5, EOCF_sRGB2, f2, EOCF_sRGB2);
        float outline34 = GeneratedOutlineSupport.outline3(EOCF_sRGB6, EOCF_sRGB3, f2, EOCF_sRGB3);
        int round = Math.round(OECF_sRGB(outline32) * 255.0f) << 16;
        return Math.round(OECF_sRGB(outline34) * 255.0f) | round | (Math.round(outline3 * 255.0f) << 24) | (Math.round(OECF_sRGB(outline33) * 255.0f) << 8);
    }

    public static JSONObject extractPaymentMethodToken(String str) throws JSONException {
        return new JSONObject(new JSONObject(str).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString("token"));
    }

    public static JSONArray f(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str) {
        return (JSONArray) a(jSONObject, str, JSONArray.class);
    }

    public static URI f(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return e(jSONObject, "x5u");
    }

    public static AlphaAction fadeOut(float f2) {
        AlphaAction alphaAction = (AlphaAction) action(AlphaAction.class);
        alphaAction.end = 0.0f;
        alphaAction.duration = f2;
        alphaAction.interpolation = null;
        return alphaAction;
    }

    public static int floatToIntColor(float f2) {
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        return floatToRawIntBits | (((int) (((float) (floatToRawIntBits >>> 24)) * 1.003937f)) << 24);
    }

    public static Class forName(String str) throws ReflectionException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new ReflectionException(GeneratedOutlineSupport.outline50("Class not found: ", str), e2);
        }
    }

    public static String format(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i = 0;
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            sb.append(valueOf.substring(i2, indexOf));
            sb.append(objArr[i]);
            int i3 = i + 1;
            i2 = indexOf + 2;
            i = i3;
        }
        sb.append(valueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x015e A[Catch:{ all -> 0x01ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0177 A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0196 A[Catch:{ all -> 0x01ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a3 A[Catch:{ all -> 0x01ab }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject from(com.clevertap.android.sdk.DeviceInfo r4, android.location.Location r5, boolean r6, boolean r7) throws org.json.JSONException {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "Build"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r3 = r4.getDeviceCachedInfo()
            int r3 = r3.build
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.put(r1, r2)
            java.lang.String r1 = "Version"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r2 = r4.getDeviceCachedInfo()
            java.lang.String r2 = r2.versionName
            r0.put(r1, r2)
            java.lang.String r1 = "OS Version"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r2 = r4.getDeviceCachedInfo()
            java.lang.String r2 = r2.osVersion
            r0.put(r1, r2)
            java.lang.String r1 = "SDK Version"
            int r2 = r4.getSdkVersion()
            r0.put(r1, r2)
            if (r5 == 0) goto L_0x0054
            java.lang.String r1 = "Latitude"
            double r2 = r5.getLatitude()
            r0.put(r1, r2)
            java.lang.String r1 = "Longitude"
            double r2 = r5.getLongitude()
            r0.put(r1, r2)
        L_0x0054:
            java.lang.String r5 = r4.getGoogleAdID()
            if (r5 == 0) goto L_0x0076
            java.lang.String r5 = "GoogleAdID"
            if (r7 == 0) goto L_0x0060
            java.lang.String r5 = "mt_GoogleAdID"
        L_0x0060:
            java.lang.String r7 = r4.getGoogleAdID()
            r0.put(r5, r7)
            java.lang.String r5 = "GoogleAdIDLimit"
            java.lang.Object r7 = r4.adIDLock
            monitor-enter(r7)
            boolean r1 = r4.limitAdTracking     // Catch:{ all -> 0x0073 }
            monitor-exit(r7)     // Catch:{ all -> 0x0073 }
            r0.put(r5, r1)
            goto L_0x0076
        L_0x0073:
            r4 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0073 }
            throw r4
        L_0x0076:
            java.lang.String r5 = "Make"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r7 = r7.manufacturer     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "Model"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r7 = r7.model     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "Carrier"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r7 = r7.carrier     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "useIP"
            r0.put(r5, r6)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "OS"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r7 = r7.osName     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "wdt"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            double r1 = r7.width     // Catch:{ all -> 0x01ab }
            r0.put(r5, r1)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "hgt"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            double r1 = r7.height     // Catch:{ all -> 0x01ab }
            r0.put(r5, r1)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "dpi"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            int r7 = r7.dpi     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = "dt"
            android.content.Context r7 = r4.context     // Catch:{ all -> 0x01ab }
            int r7 = com.clevertap.android.sdk.DeviceInfo.getDeviceType(r7)     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01ab }
            r7 = 28
            if (r5 < r7) goto L_0x00e4
            java.lang.String r5 = "abckt"
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r7 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r7 = r7.appBucket     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
        L_0x00e4:
            java.lang.String r5 = r4.library     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x00ef
            java.lang.String r5 = "lib"
            java.lang.String r7 = r4.library     // Catch:{ all -> 0x01ab }
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
        L_0x00ef:
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x01ab }
            com.clevertap.android.sdk.ManifestInfo r5 = com.clevertap.android.sdk.ManifestInfo.getInstance(r5)     // Catch:{ all -> 0x01ab }
            r7 = 0
            if (r5 == 0) goto L_0x01aa
            boolean r5 = com.clevertap.android.sdk.ManifestInfo.sslPinning     // Catch:{ all -> 0x01ab }
            r1 = 1
            if (r5 == 0) goto L_0x0102
            java.lang.String r5 = "sslpin"
            r0.put(r5, r1)     // Catch:{ all -> 0x01ab }
        L_0x0102:
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x01ab }
            com.clevertap.android.sdk.ManifestInfo r5 = com.clevertap.android.sdk.ManifestInfo.getInstance(r5)     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x01a9
            java.lang.String r5 = com.clevertap.android.sdk.ManifestInfo.fcmSenderId     // Catch:{ all -> 0x01ab }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01ab }
            if (r5 != 0) goto L_0x0117
            java.lang.String r5 = "fcmsid"
            r0.put(r5, r1)     // Catch:{ all -> 0x01ab }
        L_0x0117:
            java.lang.String r5 = r4.getCountryCode()     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x012a
            java.lang.String r2 = ""
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x01ab }
            if (r2 != 0) goto L_0x012a
            java.lang.String r2 = "cc"
            r0.put(r2, r5)     // Catch:{ all -> 0x01ab }
        L_0x012a:
            if (r6 == 0) goto L_0x01ab
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x01ab }
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            int r5 = r5.checkCallingOrSelfPermission(r6)     // Catch:{ all -> 0x01ab }
            if (r5 != 0) goto L_0x015b
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x01ab }
            java.lang.String r6 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ all -> 0x01ab }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x015b
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x0155
            int r6 = r5.getType()     // Catch:{ all -> 0x01ab }
            if (r6 != r1) goto L_0x0155
            boolean r5 = r5.isConnected()     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r1 = 0
        L_0x0156:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01ab }
            goto L_0x015c
        L_0x015b:
            r5 = r7
        L_0x015c:
            if (r5 == 0) goto L_0x0163
            java.lang.String r6 = "wifi"
            r0.put(r6, r5)     // Catch:{ all -> 0x01ab }
        L_0x0163:
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x0186 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x0186 }
            java.lang.String r6 = "android.permission.BLUETOOTH"
            android.content.Context r1 = r4.context     // Catch:{ all -> 0x0186 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0186 }
            int r5 = r5.checkPermission(r6, r1)     // Catch:{ all -> 0x0186 }
            if (r5 != 0) goto L_0x0187
            android.bluetooth.BluetoothAdapter r5 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ all -> 0x0186 }
            if (r5 == 0) goto L_0x0187
            boolean r5 = r5.isEnabled()     // Catch:{ all -> 0x0186 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0186 }
            goto L_0x0187
        L_0x0186:
        L_0x0187:
            if (r7 == 0) goto L_0x018e
            java.lang.String r5 = "BluetoothEnabled"
            r0.put(r5, r7)     // Catch:{ all -> 0x01ab }
        L_0x018e:
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r5 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r5 = r5.bluetoothVersion     // Catch:{ all -> 0x01ab }
            if (r5 == 0) goto L_0x019b
            java.lang.String r6 = "BluetoothVersion"
            r0.put(r6, r5)     // Catch:{ all -> 0x01ab }
        L_0x019b:
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r4 = r4.getDeviceCachedInfo()     // Catch:{ all -> 0x01ab }
            java.lang.String r4 = r4.networkType     // Catch:{ all -> 0x01ab }
            if (r4 == 0) goto L_0x01ab
            java.lang.String r5 = "Radio"
            r0.put(r5, r4)     // Catch:{ all -> 0x01ab }
            goto L_0x01ab
        L_0x01a9:
            throw r7     // Catch:{ all -> 0x01ab }
        L_0x01aa:
            throw r7     // Catch:{ all -> 0x01ab }
        L_0x01ab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.from(com.clevertap.android.sdk.DeviceInfo, android.location.Location, boolean, boolean):org.json.JSONObject");
    }

    /* renamed from: fromJson  reason: collision with other method in class */
    public static PostalAddress m295fromJson(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        if (jSONObject == null) {
            return new PostalAddress();
        }
        String str19 = null;
        if (jSONObject.isNull("street1")) {
            str = null;
        } else {
            str = jSONObject.optString("street1", null);
        }
        if (jSONObject.isNull("street2")) {
            str2 = null;
        } else {
            str2 = jSONObject.optString("street2", null);
        }
        if (jSONObject.isNull("country")) {
            str3 = null;
        } else {
            str3 = jSONObject.optString("country", null);
        }
        if (str == null) {
            if (jSONObject.isNull("line1")) {
                str = null;
            } else {
                str = jSONObject.optString("line1", null);
            }
        }
        if (str2 == null) {
            if (jSONObject.isNull("line2")) {
                str2 = null;
            } else {
                str2 = jSONObject.optString("line2", null);
            }
        }
        if (str3 == null) {
            if (jSONObject.isNull("countryCode")) {
                str3 = null;
            } else {
                str3 = jSONObject.optString("countryCode", null);
            }
        }
        if (str == null) {
            if (jSONObject.isNull("name")) {
                str7 = null;
            } else {
                str7 = jSONObject.optString("name", null);
            }
            if (str7 != null) {
                PostalAddress postalAddress = new PostalAddress();
                String str20 = "";
                if (jSONObject.isNull("name")) {
                    str8 = str20;
                } else {
                    str8 = jSONObject.optString("name", str20);
                }
                postalAddress.mRecipientName = str8;
                if (jSONObject.isNull(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
                    str9 = str20;
                } else {
                    str9 = jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, str20);
                }
                postalAddress.mPhoneNumber = str9;
                if (jSONObject.isNull("address1")) {
                    str10 = str20;
                } else {
                    str10 = jSONObject.optString("address1", str20);
                }
                postalAddress.mStreetAddress = str10;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(str20);
                if (jSONObject.isNull("address2")) {
                    str11 = str20;
                } else {
                    str11 = jSONObject.optString("address2", str20);
                }
                outline73.append(str11);
                outline73.append("\n");
                if (jSONObject.isNull("address3")) {
                    str12 = str20;
                } else {
                    str12 = jSONObject.optString("address3", str20);
                }
                outline73.append(str12);
                outline73.append("\n");
                if (jSONObject.isNull("address4")) {
                    str13 = str20;
                } else {
                    str13 = jSONObject.optString("address4", str20);
                }
                outline73.append(str13);
                outline73.append("\n");
                if (jSONObject.isNull("address5")) {
                    str14 = str20;
                } else {
                    str14 = jSONObject.optString("address5", str20);
                }
                outline73.append(str14);
                postalAddress.mExtendedAddress = outline73.toString().trim();
                if (jSONObject.isNull("locality")) {
                    str15 = str20;
                } else {
                    str15 = jSONObject.optString("locality", str20);
                }
                postalAddress.mLocality = str15;
                if (jSONObject.isNull("administrativeArea")) {
                    str16 = str20;
                } else {
                    str16 = jSONObject.optString("administrativeArea", str20);
                }
                postalAddress.mRegion = str16;
                if (jSONObject.isNull("countryCode")) {
                    str17 = str20;
                } else {
                    str17 = jSONObject.optString("countryCode", str20);
                }
                postalAddress.mCountryCodeAlpha2 = str17;
                if (jSONObject.isNull(RoutingConstants.MI_REACT_POSTAL_CODE)) {
                    str18 = str20;
                } else {
                    str18 = jSONObject.optString(RoutingConstants.MI_REACT_POSTAL_CODE, str20);
                }
                postalAddress.mPostalCode = str18;
                if (!jSONObject.isNull("sortingCode")) {
                    str20 = jSONObject.optString("sortingCode", str20);
                }
                postalAddress.mSortingCode = str20;
                return postalAddress;
            }
        }
        PostalAddress postalAddress2 = new PostalAddress();
        if (jSONObject.isNull("recipientName")) {
            str4 = null;
        } else {
            str4 = jSONObject.optString("recipientName", null);
        }
        postalAddress2.mRecipientName = str4;
        postalAddress2.mStreetAddress = str;
        postalAddress2.mExtendedAddress = str2;
        if (jSONObject.isNull("city")) {
            str5 = null;
        } else {
            str5 = jSONObject.optString("city", null);
        }
        postalAddress2.mLocality = str5;
        if (jSONObject.isNull("state")) {
            str6 = null;
        } else {
            str6 = jSONObject.optString("state", null);
        }
        postalAddress2.mRegion = str6;
        if (!jSONObject.isNull(RoutingConstants.MI_REACT_POSTAL_CODE)) {
            str19 = jSONObject.optString(RoutingConstants.MI_REACT_POSTAL_CODE, null);
        }
        postalAddress2.mPostalCode = str19;
        postalAddress2.mCountryCodeAlpha2 = str3;
        return postalAddress2;
    }

    public static PaymentMethodNonce fromString(String str) throws JSONException {
        Iterator<String> keys = extractPaymentMethodToken(str).keys();
        while (keys.hasNext()) {
            String next = keys.next();
            char c2 = 65535;
            int hashCode = next.hashCode();
            if (hashCode != -1730290695) {
                if (hashCode == -1313789142 && next.equals("androidPayCards")) {
                    c2 = 0;
                }
            } else if (next.equals("paypalAccounts")) {
                c2 = 1;
            }
            if (c2 == 0) {
                return GooglePaymentCardNonce.fromJson(str);
            }
            if (c2 == 1) {
                return PayPalAccountNonce.fromJson(str);
            }
        }
        throw new JSONException("Could not parse JSON for a payment method nonce");
    }

    public static Base64URL g(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return j(jSONObject, "x5t");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.shared.cs.e.i g(com.cardinalcommerce.shared.cs.e.b r4) {
        /*
            com.cardinalcommerce.shared.cs.e.i r0 = new com.cardinalcommerce.shared.cs.e.i
            r0.<init>()
            java.lang.String r1 = r4.f2088d
            boolean r1 = a1(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "ThreeDSServerTransID"
            r0.a(r2, r1)
        L_0x0013:
            java.lang.String r1 = r4.E
            boolean r1 = a1(r1)
            if (r1 != 0) goto L_0x0020
            java.lang.String r1 = "AcsCounterAtoS"
            r0.a(r2, r1)
        L_0x0020:
            java.lang.String r1 = r4.f2089e
            boolean r1 = a1(r1)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "AcsTransID"
            r0.a(r2, r1)
        L_0x002d:
            java.lang.String r1 = r4.i
            boolean r1 = a1(r1)
            if (r1 != 0) goto L_0x0038
            java.lang.String r1 = "ChallengeCompletionInd"
            goto L_0x004d
        L_0x0038:
            java.lang.String r1 = r4.i
            java.lang.String r3 = "Y"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r4.B
            r3 = 1
            boolean r1 = a(r1, r3)
            if (r1 != 0) goto L_0x0050
            java.lang.String r1 = "TransStatus"
        L_0x004d:
            r0.a(r2, r1)
        L_0x0050:
            java.lang.String r1 = r4.t
            boolean r1 = a1(r1)
            if (r1 != 0) goto L_0x005d
            java.lang.String r1 = "MessageVersion"
            r0.a(r2, r1)
        L_0x005d:
            java.lang.String r4 = r4.z
            boolean r4 = a1(r4)
            if (r4 != 0) goto L_0x006a
            java.lang.String r4 = "SdkTransID"
            r0.a(r2, r4)
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.g(com.cardinalcommerce.shared.cs.e.b):com.cardinalcommerce.shared.cs.e.i");
    }

    public static ZipResourceFile getAPKExpansionZipFile(Context context, int i, int i2) throws IOException {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(file);
                    sb.append(File.separator);
                    sb.append("main.");
                    sb.append(i);
                    sb.append(".");
                    String outline62 = GeneratedOutlineSupport.outline62(sb, packageName, ".obb");
                    if (new File(outline62).isFile()) {
                        vector.add(outline62);
                    }
                }
                if (i2 > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(file);
                    sb2.append(File.separator);
                    sb2.append("patch.");
                    sb2.append(i2);
                    sb2.append(".");
                    String outline622 = GeneratedOutlineSupport.outline62(sb2, packageName, ".obb");
                    if (new File(outline622).isFile()) {
                        vector.add(outline622);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return getResourceZipFile(strArr);
    }

    public static String getAccountIdFromNotificationBundle(Bundle bundle) {
        return bundle != null ? bundle.getString(MPLApplicationLifeCycleCallback.WZRK_ACCT_ID_KEY, "") : "";
    }

    public static PendingIntent getActivityIntent(Bundle bundle, Context context) {
        Intent intent;
        if (!bundle.containsKey("wzrk_dl") || bundle.getString("wzrk_dl") == null) {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent == null) {
                return null;
            }
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("wzrk_dl")));
            Utils.setPackageNameFromResolveInfoList(context, intent);
        }
        intent.setFlags(872415232);
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        int i = 134217728;
        if (VERSION.SDK_INT >= 23) {
            i = 201326592;
        }
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, i);
    }

    public static ArrayList<String> getAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (PushType name : PushType.values()) {
            arrayList.add(name.name());
        }
        return arrayList;
    }

    public static Bundle getAllKeyValuePairs(String str, boolean z) {
        if (str == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(str);
            for (String next : urlQuerySanitizer.getParameterSet()) {
                String valueForKey = getValueForKey(next, urlQuerySanitizer, false);
                if (valueForKey != null) {
                    if (!z) {
                        if (!next.equals("wzrk_c2a")) {
                            bundle.putString(next, URLDecoder.decode(valueForKey, "UTF-8"));
                        }
                    }
                    bundle.putString(next, valueForKey);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static Bitmap getAppIcon(Context context) throws NullPointerException {
        try {
            Drawable applicationLogo = context.getPackageManager().getApplicationLogo(context.getApplicationInfo());
            if (applicationLogo != null) {
                return drawableToBitmap(applicationLogo);
            }
            throw new Exception("Logo is null");
        } catch (Exception unused) {
            return drawableToBitmap(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));
        }
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        if (i == 0) {
            return applicationInfo.nonLocalizedLabel.toString();
        }
        return context.getString(i);
    }

    public static ArrayList<String> getBigTextFromExtras(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle.keySet()) {
            if (str.contains("pt_bt")) {
                arrayList.add(bundle.getString(str));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x017c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x017d, code lost:
        r2 = r1;
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0181, code lost:
        r2 = r1;
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        if (r3.getContentEncoding().contains("gzip") != false) goto L_0x0094;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x017c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01a1 A[SYNTHETIC, Splitter:B:116:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01b1 A[SYNTHETIC, Splitter:B:125:0x01b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmapFromURL(java.lang.String r17) {
        /*
            java.lang.String r1 = "Couldn't close connection!"
            java.lang.String r0 = "///"
            java.lang.String r2 = "/"
            r3 = r17
            java.lang.String r0 = r3.replace(r0, r2)
            java.lang.String r3 = "//"
            java.lang.String r0 = r0.replace(r3, r2)
            java.lang.String r2 = "http:/"
            java.lang.String r3 = "http://"
            java.lang.String r0 = r0.replace(r2, r3)
            java.lang.String r2 = "https:/"
            java.lang.String r3 = "https://"
            java.lang.String r0 = r0.replace(r2, r3)
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0189, all -> 0x0184 }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r3.setUseCaches(r4)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            java.lang.String r5 = "Accept-Encoding"
            java.lang.String r6 = "gzip, deflate"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r5 = 10000(0x2710, float:1.4013E-41)
            r3.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r3.connect()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            int r5 = r3.getResponseCode()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r6 = 200(0xc8, float:2.8E-43)
            java.lang.String r7 = "File not loaded completely not going forward. URL was: "
            if (r5 == r6) goto L_0x007a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            r4.<init>()     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            r4.append(r7)     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            r4.append(r0)     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            debug(r4)     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            r3.disconnect()     // Catch:{ all -> 0x0071 }
            goto L_0x0076
        L_0x0071:
            r0 = move-exception
            r3 = r0
            verbose(r1, r3)
        L_0x0076:
            return r2
        L_0x0077:
            r2 = r1
            goto L_0x018b
        L_0x007a:
            int r5 = r3.getContentLength()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            long r5 = (long) r5     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            java.lang.String r8 = r3.getContentEncoding()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r9 = 0
            if (r8 == 0) goto L_0x0093
            java.lang.String r8 = r3.getContentEncoding()     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            java.lang.String r10 = "gzip"
            boolean r8 = r8.contains(r10)     // Catch:{ IOException -> 0x0077, all -> 0x017c }
            if (r8 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r4 = 0
        L_0x0094:
            java.io.InputStream r8 = r3.getInputStream()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r10 = 16384(0x4000, float:2.2959E-41)
            byte[] r11 = new byte[r10]     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r12.<init>()     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r13 = 0
        L_0x00a3:
            int r15 = r8.read(r11)     // Catch:{ IOException -> 0x0181, all -> 0x017c }
            r2 = -1
            if (r15 == r2) goto L_0x00bc
            r16 = r1
            long r1 = (long) r15
            long r13 = r13 + r1
            r12.write(r11, r9, r15)     // Catch:{ IOException -> 0x0179, all -> 0x00b5 }
            r1 = r16
            r2 = 0
            goto L_0x00a3
        L_0x00b5:
            r0 = move-exception
            r1 = r0
            r15 = r3
        L_0x00b8:
            r2 = r16
            goto L_0x01af
        L_0x00bc:
            r16 = r1
            byte[] r1 = new byte[r10]     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            if (r4 == 0) goto L_0x0131
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            byte[] r8 = r12.toByteArray()     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            r4.<init>(r8)     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            r8.<init>()     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            java.util.zip.GZIPInputStream r12 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            r12.<init>(r4)     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            r10 = 0
        L_0x00d7:
            int r4 = r12.read(r1)     // Catch:{ IOException -> 0x0178, all -> 0x0173 }
            if (r4 == r2) goto L_0x00ec
            r15 = r3
            long r2 = (long) r4
            long r10 = r10 + r2
            r8.write(r1, r9, r4)     // Catch:{ IOException -> 0x00e9, all -> 0x00e6 }
            r3 = r15
            r2 = -1
            goto L_0x00d7
        L_0x00e6:
            r0 = move-exception
            r1 = r0
            goto L_0x00b8
        L_0x00e9:
            r3 = r15
            goto L_0x0179
        L_0x00ec:
            r15 = r3
            r1 = -1
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x011c
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x011c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            r1.<init>()     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            r1.append(r7)     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            r1.append(r0)     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            debug(r1)     // Catch:{ IOException -> 0x0119, all -> 0x0117 }
            r15.disconnect()     // Catch:{ all -> 0x010e }
        L_0x010c:
            r1 = 0
            goto L_0x0116
        L_0x010e:
            r0 = move-exception
            r1 = r0
            r2 = r16
            verbose(r2, r1)
            goto L_0x010c
        L_0x0116:
            return r1
        L_0x0117:
            r0 = move-exception
            goto L_0x0175
        L_0x0119:
            r2 = r16
            goto L_0x0171
        L_0x011c:
            r2 = r16
            byte[] r1 = r8.toByteArray()     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            int r3 = (int) r10     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r9, r3)     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r15.disconnect()     // Catch:{ all -> 0x012b }
            goto L_0x0130
        L_0x012b:
            r0 = move-exception
            r3 = r0
            verbose(r2, r3)
        L_0x0130:
            return r1
        L_0x0131:
            r15 = r3
            r2 = r16
            r3 = -1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x015c
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x015c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r1.<init>()     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r1.append(r7)     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r1.append(r0)     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            debug(r1)     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r15.disconnect()     // Catch:{ all -> 0x0155 }
        L_0x0153:
            r1 = 0
            goto L_0x015b
        L_0x0155:
            r0 = move-exception
            r1 = r0
            verbose(r2, r1)
            goto L_0x0153
        L_0x015b:
            return r1
        L_0x015c:
            byte[] r1 = r12.toByteArray()     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            int r3 = (int) r13     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r9, r3)     // Catch:{ IOException -> 0x0171, all -> 0x016f }
            r15.disconnect()     // Catch:{ all -> 0x0169 }
            goto L_0x016e
        L_0x0169:
            r0 = move-exception
            r3 = r0
            verbose(r2, r3)
        L_0x016e:
            return r1
        L_0x016f:
            r0 = move-exception
            goto L_0x017f
        L_0x0171:
            r3 = r15
            goto L_0x018b
        L_0x0173:
            r0 = move-exception
            r15 = r3
        L_0x0175:
            r2 = r16
            goto L_0x017f
        L_0x0178:
            r15 = r3
        L_0x0179:
            r2 = r16
            goto L_0x018b
        L_0x017c:
            r0 = move-exception
            r2 = r1
            r15 = r3
        L_0x017f:
            r1 = r0
            goto L_0x01af
        L_0x0181:
            r2 = r1
            r15 = r3
            goto L_0x018b
        L_0x0184:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r15 = 0
            goto L_0x01af
        L_0x0189:
            r2 = r1
            r3 = 0
        L_0x018b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ac }
            r1.<init>()     // Catch:{ all -> 0x01ac }
            java.lang.String r4 = "Couldn't download the file. URL was: "
            r1.append(r4)     // Catch:{ all -> 0x01ac }
            r1.append(r0)     // Catch:{ all -> 0x01ac }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01ac }
            verbose(r0)     // Catch:{ all -> 0x01ac }
            if (r3 == 0) goto L_0x01aa
            r3.disconnect()     // Catch:{ all -> 0x01a5 }
            goto L_0x01aa
        L_0x01a5:
            r0 = move-exception
            r1 = r0
            verbose(r2, r1)
        L_0x01aa:
            r1 = 0
            return r1
        L_0x01ac:
            r0 = move-exception
            r1 = r0
            r15 = r3
        L_0x01af:
            if (r15 == 0) goto L_0x01ba
            r15.disconnect()     // Catch:{ all -> 0x01b5 }
            goto L_0x01ba
        L_0x01b5:
            r0 = move-exception
            r3 = r0
            verbose(r2, r3)
        L_0x01ba:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.getBitmapFromURL(java.lang.String):android.graphics.Bitmap");
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getPreferences(context).getBoolean(str, z);
    }

    public static boolean getBooleanFromPrefs(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (!cleverTapInstanceConfig.isDefaultInstance) {
            return getBoolean(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), false);
        }
        boolean z = getBoolean(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), false);
        if (!z) {
            z = getBoolean(context, str, false);
        }
        return z;
    }

    public static CheckoutRequest getCheckoutRequest(BraintreeFragment braintreeFragment, String str) {
        CheckoutRequest checkoutRequest = new CheckoutRequest();
        populateRequestData(braintreeFragment, checkoutRequest);
        checkoutRequest.approvalURL(str);
        if (str != null) {
            String queryParameter = Uri.parse(str).getQueryParameter("token");
            if (queryParameter != null) {
                checkoutRequest.pairingId(braintreeFragment.mContext, queryParameter);
            }
        }
        return checkoutRequest;
    }

    public static int getColor(Activity activity, String str, int i) {
        TypedValue typedValue = new TypedValue();
        try {
            if (activity.getTheme().resolveAttribute(activity.getResources().getIdentifier(str, ColorPropConverter.ATTR, activity.getPackageName()), typedValue, true)) {
                return typedValue.data;
            }
        } catch (Exception unused) {
        }
        return activity.getResources().getColor(i);
    }

    public static int getColour(String str, String str2) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            debug("Can not parse colour value: " + str + " Switching to default colour: " + str2);
            return Color.parseColor(str2);
        }
    }

    public static Constructor getConstructor(Class cls, Class... clsArr) throws ReflectionException {
        try {
            return new Constructor(cls.getConstructor(null));
        } catch (SecurityException e2) {
            throw new ReflectionException(GeneratedOutlineSupport.outline36(cls, GeneratedOutlineSupport.outline73("Security violation occurred while getting constructor for class: '"), "'."), e2);
        } catch (NoSuchMethodException e3) {
            throw new ReflectionException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Constructor not found for class: ")), e3);
        }
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r8 == 0) goto L_0x0026
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0024 }
            if (r9 == 0) goto L_0x0026
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r7 = r8.getString(r9)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            r9 = move-exception
            goto L_0x0030
        L_0x0026:
            if (r8 == 0) goto L_0x002b
            r8.close()
        L_0x002b:
            return r7
        L_0x002c:
            r9 = move-exception
            goto L_0x003b
        L_0x002e:
            r9 = move-exception
            r8 = r7
        L_0x0030:
            r9.printStackTrace()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0038
            r8.close()
        L_0x0038:
            return r7
        L_0x0039:
            r9 = move-exception
            r7 = r8
        L_0x003b:
            if (r7 == 0) goto L_0x0040
            r7.close()
        L_0x0040:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static Constructor getDeclaredConstructor(Class cls, Class... clsArr) throws ReflectionException {
        try {
            return new Constructor(cls.getDeclaredConstructor(clsArr));
        } catch (SecurityException e2) {
            throw new ReflectionException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Security violation while getting constructor for class: ")), e2);
        } catch (NoSuchMethodException e3) {
            throw new ReflectionException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Constructor not found for class: ")), e3);
        }
    }

    public static ArrayList<String> getDeepLinkListFromExtras(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle.keySet()) {
            if (str.contains("pt_dl")) {
                arrayList.add(bundle.getString(str));
            }
        }
        return arrayList;
    }

    public static JSONObject getErrorObject(ValidationResult validationResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c", validationResult.errorCode);
            jSONObject.put("d", validationResult.errorDesc);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static String getEventNameFromExtras(Bundle bundle) {
        String str = null;
        for (String str2 : bundle.keySet()) {
            if (str2.contains("pt_event_name")) {
                str = bundle.getString(str2);
            }
        }
        return str;
    }

    public static ArrayList<String> getImageListFromExtras(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle.keySet()) {
            if (str.contains("pt_img")) {
                arrayList.add(bundle.getString(str));
            }
        }
        return arrayList;
    }

    public static int getInt(Context context, String str, int i) {
        return getPreferences(context).getInt(str, i);
    }

    public static int getIntFromPrefs(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i) {
        if (!cleverTapInstanceConfig.isDefaultInstance) {
            return getInt(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), i);
        }
        int i2 = getInt(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        if (i2 == -1000) {
            i2 = getInt(context, str, i);
        }
        return i2;
    }

    public static PendingIntent getLaunchPendingIntent(Bundle bundle, Context context) {
        if (VERSION.SDK_INT >= 31) {
            return getActivityIntent(bundle, context);
        }
        Intent intent = new Intent(context, CTPushNotificationReceiver.class);
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        int i = 134217728;
        if (VERSION.SDK_INT >= 23) {
            i = 201326592;
        }
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, i);
    }

    public static String getLogTag(CleverTapInstanceConfig cleverTapInstanceConfig) {
        return GeneratedOutlineSupport.outline62(new StringBuilder(), cleverTapInstanceConfig != null ? cleverTapInstanceConfig.accountId : "", "[Product Config]");
    }

    public static long getLong(Context context, String str, String str2, long j) {
        return getPreferences(context, str).getLong(str2, j);
    }

    public static long getLongFromPrefs(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i, String str2) {
        if (!cleverTapInstanceConfig.isDefaultInstance) {
            return getLong(context, str2, storageKeyWithSuffix(cleverTapInstanceConfig, str), (long) i);
        }
        long j = getLong(context, str2, storageKeyWithSuffix(cleverTapInstanceConfig, str), -1000);
        if (j == -1000) {
            j = getLong(context, str2, str, (long) i);
        }
        return j;
    }

    public static Bitmap getNotificationBitmap(String str, boolean z, Context context) throws NullPointerException {
        Bitmap bitmap = null;
        if (str.equals("")) {
            if (z) {
                bitmap = getAppIcon(context);
            }
            return bitmap;
        }
        if (!str.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
            str = GeneratedOutlineSupport.outline50("http://static.wizrocket.com/android/ico//", str);
        }
        Bitmap bitmapFromURL = getBitmapFromURL(str);
        if (bitmapFromURL != null) {
            bitmap = bitmapFromURL;
        } else if (z) {
            bitmap = getAppIcon(context);
        }
        return bitmap;
    }

    public static Notification getNotificationById(Context context, int i) {
        for (StatusBarNotification statusBarNotification : ((NotificationManager) context.getSystemService("notification")).getActiveNotifications()) {
            if (statusBarNotification.getId() == i) {
                return statusBarNotification.getNotification();
            }
        }
        return null;
    }

    public static int getOrientation(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(com.squareup.picasso.Utils.MIN_DISK_CACHE_SIZE);
        return getOrientationInternal(list, new ImageHeaderParserUtils$4(inputStream, arrayPool));
    }

    public static int getOrientationInternal(List<ImageHeaderParser> list, ImageHeaderParserUtils$OrientationReader imageHeaderParserUtils$OrientationReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientation = imageHeaderParserUtils$OrientationReader.getOrientation(list.get(i));
            if (orientation != -1) {
                return orientation;
            }
        }
        return -1;
    }

    public static SharedPreferences getPreferences(Context context, String str) {
        String str2 = "WizRocket";
        if (str != null) {
            str2 = GeneratedOutlineSupport.outline52(str2, "_", str);
        }
        return context.getSharedPreferences(str2, 0);
    }

    public static ArrayList<String> getPriceFromExtras(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle.keySet()) {
            if (str.contains("pt_price") && !str.contains("pt_price_list")) {
                arrayList.add(bundle.getString(str));
            }
        }
        return arrayList;
    }

    public static String getQuery(Context context, int i) throws NotFoundException, IOException {
        BufferedReader bufferedReader;
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(i);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            bufferedReader.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return sb2;
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
        if (r10 != null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
        r0 = (java.lang.String[]) r11.toArray(new java.lang.String[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray getRenderedTargetList(com.clevertap.android.sdk.db.DBAdapter r12) {
        /*
            monitor-enter(r12)
            boolean r0 = r12.rtlDirtyFlag     // Catch:{ all -> 0x00d0 }
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x00d0 }
            monitor-exit(r12)
            goto L_0x00a0
        L_0x000b:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x00d0 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00d0 }
            r10 = 0
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x00d0 }
            r11.<init>()     // Catch:{ all -> 0x00d0 }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r2 = r12.dbHelper     // Catch:{ SQLiteException -> 0x006f }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x006f }
            r4 = 0
            java.lang.String r5 = "isRead =?"
            java.lang.String r3 = "0"
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x006f }
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x006f }
            if (r10 == 0) goto L_0x0065
        L_0x0030:
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x006f }
            if (r2 == 0) goto L_0x0062
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006f }
            r2.<init>()     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r3 = "Fetching PID - "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r3 = "data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x006f }
            r2.append(r3)     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x006f }
            com.clevertap.android.sdk.Logger.v(r2)     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r2 = "data"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ SQLiteException -> 0x006f }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x006f }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x006f }
            goto L_0x0030
        L_0x0062:
            r10.close()     // Catch:{ SQLiteException -> 0x006f }
        L_0x0065:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r12.dbHelper     // Catch:{ all -> 0x00d0 }
            r0.close()     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x0097
            goto L_0x0094
        L_0x006d:
            r0 = move-exception
            goto L_0x00c5
        L_0x006f:
            r2 = move-exception
            com.clevertap.android.sdk.Logger r3 = r12.getConfigLogger()     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r4.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch:{ all -> 0x006d }
            r4.append(r0)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "."
            r4.append(r0)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x006d }
            r3.verbose(r0, r2)     // Catch:{ all -> 0x006d }
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r0 = r12.dbHelper     // Catch:{ all -> 0x00d0 }
            r0.close()     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x0097
        L_0x0094:
            r10.close()     // Catch:{ all -> 0x00d0 }
        L_0x0097:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x00d0 }
            java.lang.Object[] r0 = r11.toArray(r0)     // Catch:{ all -> 0x00d0 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x00d0 }
            monitor-exit(r12)
        L_0x00a0:
            org.json.JSONArray r12 = new org.json.JSONArray
            r12.<init>()
            int r2 = r0.length
        L_0x00a6:
            if (r1 >= r2) goto L_0x00c4
            r3 = r0[r1]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "RTL IDs -"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.clevertap.android.sdk.Logger.v(r4)
            r12.put(r3)
            int r1 = r1 + 1
            goto L_0x00a6
        L_0x00c4:
            return r12
        L_0x00c5:
            com.clevertap.android.sdk.db.DBAdapter$DatabaseHelper r1 = r12.dbHelper     // Catch:{ all -> 0x00d0 }
            r1.close()     // Catch:{ all -> 0x00d0 }
            if (r10 == 0) goto L_0x00cf
            r10.close()     // Catch:{ all -> 0x00d0 }
        L_0x00cf:
            throw r0     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.getRenderedTargetList(com.clevertap.android.sdk.db.DBAdapter):org.json.JSONArray");
    }

    public static IdentityRepo getRepo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, ValidationResultStack validationResultStack) {
        IdentityRepo identityRepo;
        LoginInfoProvider loginInfoProvider = new LoginInfoProvider(context, cleverTapInstanceConfig, deviceInfo);
        boolean z = loginInfoProvider.getCachedGUIDs().length() > 0 && TextUtils.isEmpty(loginInfoProvider.getCachedIdentityKeysForAccount());
        CleverTapInstanceConfig cleverTapInstanceConfig2 = loginInfoProvider.config;
        cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("ON_USER_LOGIN"), "isLegacyProfileLoggedIn:" + z);
        if (z) {
            identityRepo = new LegacyIdentityRepo(cleverTapInstanceConfig);
        } else {
            identityRepo = new ConfigurableIdentityRepo(context, cleverTapInstanceConfig, deviceInfo, validationResultStack);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Repo provider: ");
        outline73.append(identityRepo.getClass().getSimpleName());
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), outline73.toString());
        return identityRepo;
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        ArrayList arrayList;
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List<CacheKey> list = ((MultiCacheKey) cacheKey).mCacheKeys;
                arrayList = new ArrayList(list.size());
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(secureHashKey(list.get(i)));
                }
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(cacheKey.isResourceIdForDebugging() ? cacheKey.getUriString() : secureHashKey(cacheKey));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static ZipResourceFile getResourceZipFile(String[] strArr) throws IOException {
        ZipResourceFile zipResourceFile = null;
        for (String str : strArr) {
            if (zipResourceFile == null) {
                zipResourceFile = new ZipResourceFile(str);
            } else {
                zipResourceFile.addPatchFile(str);
            }
        }
        return zipResourceFile;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("BraintreeApi", 0);
    }

    public static ArrayList<String> getSmallTextFromExtras(Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle.keySet()) {
            if (str.contains("pt_st")) {
                arrayList.add(bundle.getString(str));
            }
        }
        return arrayList;
    }

    public static String getString(Context context, String str, String str2) {
        return getPreferences(context).getString(str, str2);
    }

    public static String getStringFromPrefs(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, String str2) {
        if (!cleverTapInstanceConfig.isDefaultInstance) {
            return getString(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), str2);
        }
        String string = getString(context, storageKeyWithSuffix(cleverTapInstanceConfig, str), str2);
        if (string == null) {
            string = getString(context, str, str2);
        }
        return string;
    }

    public static ImageType getType(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(com.squareup.picasso.Utils.MIN_DISK_CACHE_SIZE);
        return getTypeInternal(list, new ImageHeaderParserUtils$1(inputStream));
    }

    public static ImageType getTypeInternal(List<ImageHeaderParser> list, ImageHeaderParserUtils$TypeReader imageHeaderParserUtils$TypeReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageType type = imageHeaderParserUtils$TypeReader.getType(list.get(i));
            if (type != ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageType.UNKNOWN;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient(OkHttpClient okHttpClient) {
        try {
            RNFetchBlobUtils$1 rNFetchBlobUtils$1 = new RNFetchBlobUtils$1();
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, new TrustManager[]{rNFetchBlobUtils$1}, new SecureRandom());
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            newBuilder.sslSocketFactory(socketFactory, rNFetchBlobUtils$1);
            newBuilder.hostnameVerifier(new RNFetchBlobUtils$2());
            return newBuilder;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static JSONObject getUrchinFromUri(Uri uri) {
        JSONObject jSONObject = new JSONObject();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.parseUrl(uri.toString());
            String utmOrWzrkValue = getUtmOrWzrkValue(DefaultSettingsSpiCall.SOURCE_PARAM, urlQuerySanitizer);
            String utmOrWzrkValue2 = getUtmOrWzrkValue("medium", urlQuerySanitizer);
            String utmOrWzrkValue3 = getUtmOrWzrkValue("campaign", urlQuerySanitizer);
            jSONObject.put("us", utmOrWzrkValue);
            jSONObject.put("um", utmOrWzrkValue2);
            jSONObject.put("uc", utmOrWzrkValue3);
            String wzrkValueForKey = getWzrkValueForKey("medium", urlQuerySanitizer);
            if (wzrkValueForKey != null && wzrkValueForKey.matches("^email$|^social$|^search$")) {
                jSONObject.put("wm", wzrkValueForKey);
            }
            Logger.d("Referrer data: " + jSONObject.toString(4));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String getUtmOrWzrkValue(String str, UrlQuerySanitizer urlQuerySanitizer) {
        String valueForKey = getValueForKey("utm_" + str, urlQuerySanitizer, true);
        if (valueForKey == null) {
            valueForKey = getWzrkValueForKey(str, urlQuerySanitizer);
            if (valueForKey == null) {
                return null;
            }
        }
        return valueForKey;
    }

    public static String getValueForKey(String str, UrlQuerySanitizer urlQuerySanitizer, boolean z) {
        if (!(str == null || urlQuerySanitizer == null)) {
            try {
                String value = urlQuerySanitizer.getValue(str);
                if (value == null) {
                    return null;
                }
                if (z && value.length() > 120) {
                    value = value.substring(0, 120);
                }
                return value;
            } catch (Throwable th) {
                Logger.v((String) "Couldn't parse the URI", th);
            }
        }
        return null;
    }

    public static JSONObject getWzrkFields(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                JSONObject wzrkFields = getWzrkFields((Bundle) obj);
                Iterator<String> keys = wzrkFields.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, wzrkFields.get(next));
                }
            } else if (str.startsWith("wzrk_")) {
                jSONObject.put(str, bundle.get(str));
            }
        }
        return jSONObject;
    }

    public static String getWzrkValueForKey(String str, UrlQuerySanitizer urlQuerySanitizer) {
        return getValueForKey("wzrk_" + str, urlQuerySanitizer, true);
    }

    public static Base64URL h(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        return j(jSONObject, "x5t#S256");
    }

    public static List<String> h(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str) {
        Object[] objArr;
        JSONArray f2 = f(jSONObject, str);
        if (f2 == null) {
            objArr = null;
        } else {
            try {
                objArr = (String[]) f2.toArray(new String[0]);
            } catch (ArrayStoreException unused) {
                throw new ParseException(GeneratedOutlineSupport.outline52("JSON object member with key \"", str, "\" is not an array of strings"), 0);
            }
        }
        if (objArr == null) {
            return null;
        }
        return Arrays.asList(objArr);
    }

    public static int hashCode(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    public static List<Base64> i(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject) {
        List<Base64> a2 = a(f(jSONObject, "x5c"));
        if (a2 == null || !a2.isEmpty()) {
            return a2;
        }
        return null;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource simpleDataSource = new SimpleDataSource();
        simpleDataSource.setFailure(th);
        return simpleDataSource;
    }

    public static float intToFloatColor(int i) {
        return Float.intBitsToFloat(i & -16777217);
    }

    public static boolean isAvailable(Context context) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService").setPackage("com.android.chrome");
        ChromeCustomTabs$1 chromeCustomTabs$1 = new ChromeCustomTabs$1();
        boolean bindService = context.bindService(intent, chromeCustomTabs$1, 33);
        context.unbindService(chromeCustomTabs$1);
        return bindService;
    }

    public static boolean isDarkBackground(Activity activity) {
        int color = activity.getResources().getColor(R$color.bt_white);
        try {
            Drawable background = activity.getWindow().getDecorView().getRootView().getBackground();
            if (background instanceof ColorDrawable) {
                color = ((ColorDrawable) background).getColor();
            }
        } catch (Exception unused) {
        }
        return (((double) Color.blue(color)) * 0.0722d) + ((((double) Color.green(color)) * 0.7152d) + (((double) Color.red(color)) * 0.2126d)) < 128.0d;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isIntentResolved(Context context, Intent intent) {
        return (intent == null || context.getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static void isReadyToPay(BraintreeFragment braintreeFragment, ReadyForGooglePaymentRequest readyForGooglePaymentRequest, BraintreeResponseListener<Boolean> braintreeResponseListener) {
        try {
            Class.forName(PaymentsClient.class.getName());
            GooglePayment$1 googlePayment$1 = new GooglePayment$1(braintreeFragment, braintreeResponseListener);
            braintreeFragment.fetchConfiguration();
            braintreeFragment.postOrQueueCallback(new QueuedCallback(googlePayment$1) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            braintreeResponseListener.onResponse(Boolean.FALSE);
        }
    }

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean isVenmoInstalled(Context context) {
        return isIntentAvailable(context, new Intent().setComponent(new ComponentName("com.venmo", "com.venmo.controller.SetupMerchantActivity"))) && SignatureVerification.isSignatureValid(context, "com.venmo", "CN=Andrew Kortina,OU=Engineering,O=Venmo,L=Philadelphia,ST=PA,C=US", "CN=Andrew Kortina,OU=Engineering,O=Venmo,L=Philadelphia,ST=PA,C=US", -129711843);
    }

    public static boolean isXiaomiDeviceRunningMiui(Context context) {
        boolean z = false;
        try {
            if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(Constant.GET, new Class[]{String.class}).invoke(cls, new Object[]{"ro.miui.ui.version.code"});
            if (str != null && !TextUtils.isEmpty(str.trim())) {
                return true;
            }
            if (isIntentResolved(context, new Intent("miui.intent.action.OP_AUTO_START").addCategory("android.intent.category.DEFAULT")) || isIntentResolved(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"))) || isIntentResolved(context, new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory("android.intent.category.DEFAULT")) || isIntentResolved(context, new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings")))) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Base64URL j(com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject jSONObject, String str) {
        String d2 = d(jSONObject, str);
        if (d2 == null) {
            return null;
        }
        return new Base64URL(d2);
    }

    public static void loadImageURLIntoRemoteView(int i, String str, RemoteViews remoteViews) {
        Bitmap bitmapFromURL = getBitmapFromURL(str);
        setFallback(Boolean.FALSE);
        if (bitmapFromURL != null) {
            remoteViews.setImageViewBitmap(i, bitmapFromURL);
            return;
        }
        debug("Image was not perfect. URL:" + str + " hiding image view");
        setFallback(Boolean.TRUE);
    }

    public static void mkdirs(File file) throws FileUtils$CreateDirectoryException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.delete()) {
                    throw new FileUtils$CreateDirectoryException(file.getAbsolutePath(), new FileUtils$FileDeleteException(file.getAbsolutePath()));
                }
            } else {
                return;
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new FileUtils$CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static MoveByAction moveBy(float f2, float f3, float f4, Interpolation interpolation) {
        MoveByAction moveByAction = (MoveByAction) action(MoveByAction.class);
        moveByAction.amountX = f2;
        moveByAction.amountY = f3;
        moveByAction.duration = f4;
        moveByAction.interpolation = interpolation;
        return moveByAction;
    }

    public static MoveToAction moveTo(float f2, float f3, float f4) {
        MoveToAction moveToAction = (MoveToAction) action(MoveToAction.class);
        moveToAction.endX = f2;
        moveToAction.endY = f3;
        moveToAction.duration = f4;
        moveToAction.interpolation = null;
        return moveToAction;
    }

    public static <T> T newInstance(Class<T> cls) throws ReflectionException {
        try {
            return cls.newInstance();
        } catch (InstantiationException e2) {
            throw new ReflectionException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Could not instantiate instance of class: ")), e2);
        } catch (IllegalAccessException e3) {
            throw new ReflectionException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Could not instantiate instance of class: ")), e3);
        }
    }

    public static void onActivityResult(BraintreeFragment braintreeFragment, int i, Intent intent) {
        if (i == -1) {
            braintreeFragment.sendAnalyticsEvent("google-payment.authorized");
            tokenize(braintreeFragment, PaymentData.getFromIntent(intent));
        } else if (i == 1) {
            braintreeFragment.sendAnalyticsEvent("google-payment.failed");
            braintreeFragment.postOrQueueCallback(new QueuedCallback(new GooglePaymentException("An error was encountered during the Google Payments flow. See the status object in this exception for more details.", AutoResolveHelper.getStatusFromIntent(intent))) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(exc);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
        } else if (i == 0) {
            braintreeFragment.sendAnalyticsEvent("google-payment.canceled");
        }
    }

    public static String optString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return str2;
        }
        return jSONObject.optString(str, str2);
    }

    public static ParallelAction parallel(Action action, Action action2) {
        ParallelAction parallelAction = (ParallelAction) action(ParallelAction.class);
        parallelAction.actions.add(action);
        Actor actor = parallelAction.actor;
        if (actor != null) {
            action.setActor(actor);
        }
        parallelAction.actions.add(action2);
        Actor actor2 = parallelAction.actor;
        if (actor2 != null) {
            action2.setActor(actor2);
        }
        return parallelAction;
    }

    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(jsonReader, lottieComposition, 1.0f, valueParser, false);
    }

    public static AnimatableColorValue parseColor(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(parse(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableIntegerValue parseInteger(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(parse(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    public static AnimatablePointValue parsePoint(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.parse(jsonReader, lottieComposition, com.airbnb.lottie.utils.Utils.dpScale(), PointFParser.INSTANCE, true));
    }

    public static void performVerification(BraintreeFragment braintreeFragment, ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookupListener threeDSecureLookupListener) {
        if (threeDSecureRequest.mAmount == null || threeDSecureRequest.mNonce == null) {
            braintreeFragment.postOrQueueCallback(new QueuedCallback(new InvalidArgumentException("The ThreeDSecureRequest nonce and amount cannot be null")) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(exc);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
            return;
        }
        ThreeDSecure$4 threeDSecure$4 = new ThreeDSecure$4(braintreeFragment, threeDSecureRequest, threeDSecureLookupListener);
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(threeDSecure$4) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    public static void persist(Editor editor) {
        try {
            editor.apply();
        } catch (Throwable th) {
            Logger.v((String) "CRITICAL: Failed to persist shared preferences!", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends com.paypal.android.sdk.onetouch.core.Request> T populateRequestData(com.braintreepayments.api.BraintreeFragment r6, T r7) {
        /*
            com.braintreepayments.api.models.Configuration r0 = r6.mConfiguration
            com.braintreepayments.api.models.PayPalConfiguration r0 = r0.mPayPalConfiguration
            java.lang.String r1 = r0.mEnvironment
            int r2 = r1.hashCode()
            r3 = 1
            r4 = -1548612125(0xffffffffa3b20de3, float:-1.930468E-17)
            java.lang.String r5 = "live"
            if (r2 == r4) goto L_0x0020
            r4 = 3322092(0x32b0ec, float:4.655242E-39)
            if (r2 == r4) goto L_0x0018
            goto L_0x002a
        L_0x0018:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x002a
            r1 = 0
            goto L_0x002b
        L_0x0020:
            java.lang.String r2 = "offline"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002a
            r1 = 1
            goto L_0x002b
        L_0x002a:
            r1 = -1
        L_0x002b:
            java.lang.String r2 = "mock"
            if (r1 == 0) goto L_0x0035
            if (r1 == r3) goto L_0x0034
            java.lang.String r5 = r0.mEnvironment
            goto L_0x0035
        L_0x0034:
            r5 = r2
        L_0x0035:
            java.lang.String r0 = r0.mClientId
            if (r0 != 0) goto L_0x0041
            boolean r1 = r2.equals(r5)
            if (r1 == 0) goto L_0x0041
            java.lang.String r0 = "FAKE-PAYPAL-CLIENT-ID"
        L_0x0041:
            r7.mEnvironment = r5
            r7.mClientId = r0
            java.lang.String r0 = r6.mReturnUrlScheme
            java.lang.String r1 = "://"
            java.lang.String r2 = "onetouch/v1/"
            java.lang.String r3 = "cancel"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r0, r1, r2, r3)
            r7.mCancelUrl = r0
            java.lang.String r6 = r6.mReturnUrlScheme
            java.lang.String r0 = "success"
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r6, r1, r2, r0)
            r7.mSuccessUrl = r6
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.populateRequestData(com.braintreepayments.api.BraintreeFragment, com.paypal.android.sdk.onetouch.core.Request):com.paypal.android.sdk.onetouch.core.Request");
    }

    public static void propagateIfPossible(Throwable th) {
        Class<Error> cls = Error.class;
        if (!cls.isInstance(th)) {
            Class<RuntimeException> cls2 = RuntimeException.class;
            if (cls2.isInstance(th)) {
                throw cls2.cast(th);
            }
            return;
        }
        throw cls.cast(th);
    }

    public static void putInt(Context context, String str, int i) {
        persist(getPreferences(context).edit().putInt(str, i));
    }

    public static void putString(Context context, String str, String str2) {
        persist(getPreferences(context).edit().putString(str, str2));
    }

    public static void raiseCleverTapEvent(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, HashMap<String, Object> hashMap) {
        CleverTapAPI cleverTapAPI;
        if (cleverTapInstanceConfig != null) {
            cleverTapAPI = CleverTapAPI.instanceWithConfig(context, cleverTapInstanceConfig);
        } else {
            cleverTapAPI = CleverTapAPI.getDefaultInstance(context);
        }
        if (str.isEmpty()) {
            return;
        }
        if (cleverTapAPI != null) {
            cleverTapAPI.pushEvent(str, hashMap);
        } else {
            debug("CleverTap instance is NULL, not raising the event");
        }
    }

    public static void raiseNotificationClicked(Context context, Bundle bundle, CleverTapInstanceConfig cleverTapInstanceConfig) {
        CleverTapAPI cleverTapAPI;
        if (cleverTapInstanceConfig != null) {
            cleverTapAPI = CleverTapAPI.instanceWithConfig(context, cleverTapInstanceConfig);
        } else {
            cleverTapAPI = CleverTapAPI.getDefaultInstance(context);
        }
        if (cleverTapAPI != null) {
            cleverTapAPI.coreState.analyticsManager.pushNotificationClickedEvent(bundle);
        }
    }

    public static int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i + i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            return i3;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    public static void rename(File file, File file2) throws FileUtils$RenameException {
        Throwable th = null;
        if (file != null) {
            file2.delete();
            if (!file.renameTo(file2)) {
                if (file2.exists()) {
                    th = new FileUtils$FileDeleteException(file2.getAbsolutePath());
                } else if (!file.getParentFile().exists()) {
                    th = new FileUtils$ParentDirNotFoundException(file.getAbsolutePath());
                } else if (!file.exists()) {
                    th = new FileNotFoundException(file.getAbsolutePath());
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown error renaming ");
                outline73.append(file.getAbsolutePath());
                outline73.append(" to ");
                outline73.append(file2.getAbsolutePath());
                throw new FileUtils$RenameException(outline73.toString(), th);
            }
            return;
        }
        throw null;
    }

    public static RepeatAction repeat(int i, Action action) {
        RepeatAction repeatAction = (RepeatAction) action(RepeatAction.class);
        repeatAction.repeatCount = i;
        repeatAction.action = action;
        return repeatAction;
    }

    public static void requestBillingAgreement(BraintreeFragment braintreeFragment, PayPalRequest payPalRequest) {
        if (payPalRequest.mAmount == null) {
            braintreeFragment.sendAnalyticsEvent("paypal.billing-agreement.selected");
            if (payPalRequest.mOfferCredit) {
                braintreeFragment.sendAnalyticsEvent("paypal.billing-agreement.credit.offered");
            }
            PayPal$2 payPal$2 = new PayPal$2(braintreeFragment, payPalRequest, true, new PayPal$1(braintreeFragment, payPalRequest, true, null));
            braintreeFragment.fetchConfiguration();
            braintreeFragment.postOrQueueCallback(new QueuedCallback(payPal$2) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
            return;
        }
        braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("There must be no amount specified for the Billing Agreement flow")) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    public static void requestOneTimePayment(BraintreeFragment braintreeFragment, PayPalRequest payPalRequest) {
        if (payPalRequest.mAmount != null) {
            braintreeFragment.sendAnalyticsEvent("paypal.single-payment.selected");
            if (payPalRequest.mOfferCredit) {
                braintreeFragment.sendAnalyticsEvent("paypal.single-payment.credit.offered");
            }
            if (payPalRequest.mOfferPayLater) {
                braintreeFragment.sendAnalyticsEvent("paypal.single-payment.paylater.offered");
            }
            PayPal$2 payPal$2 = new PayPal$2(braintreeFragment, payPalRequest, false, new PayPal$1(braintreeFragment, payPalRequest, false, null));
            braintreeFragment.fetchConfiguration();
            braintreeFragment.postOrQueueCallback(new QueuedCallback(payPal$2) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
            return;
        }
        braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("An amount must be specified for the Single Payment flow.")) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    public static RotateByAction rotateBy(float f2, float f3, Interpolation interpolation) {
        RotateByAction rotateByAction = (RotateByAction) action(RotateByAction.class);
        rotateByAction.amount = f2;
        rotateByAction.duration = f3;
        rotateByAction.interpolation = interpolation;
        return rotateByAction;
    }

    public static RunnableAction run(Runnable runnable) {
        RunnableAction runnableAction = (RunnableAction) action(RunnableAction.class);
        runnableAction.runnable = runnable;
        return runnableAction;
    }

    public static ScaleToAction scaleTo(float f2, float f3, float f4, Interpolation interpolation) {
        ScaleToAction scaleToAction = (ScaleToAction) action(ScaleToAction.class);
        scaleToAction.endX = f2;
        scaleToAction.endY = f3;
        scaleToAction.duration = f4;
        scaleToAction.interpolation = interpolation;
        return scaleToAction;
    }

    public static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        byte[] bytes = cacheKey.getUriString().getBytes("UTF-8");
        try {
            MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
            instance.update(bytes, 0, bytes.length);
            return android.util.Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
        if (r4 == null) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void send(android.content.Context r18, com.braintreepayments.api.models.Authorization r19, com.braintreepayments.api.internal.BraintreeHttpClient r20, java.lang.String r21, boolean r22) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            com.braintreepayments.api.internal.AnalyticsDatabase r3 = new com.braintreepayments.api.internal.AnalyticsDatabase
            r4 = 0
            r3.<init>(r0, r4)
            java.lang.String r5 = "meta_json"
            java.lang.String r6 = ","
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.database.sqlite.SQLiteDatabase r4 = r3.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            java.lang.String r8 = "group_concat(_id)"
            java.lang.String r9 = "group_concat(event)"
            java.lang.String r10 = "group_concat(timestamp)"
            java.lang.String[] r11 = new java.lang.String[]{r8, r9, r10, r5}     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            r9 = 0
            java.lang.String r10 = "analytics"
            r12 = 0
            r13 = 0
            java.lang.String r14 = "meta_json"
            r15 = 0
            java.lang.String r16 = "_id asc"
            r17 = 0
            r8 = r4
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
        L_0x0034:
            boolean r9 = r8.moveToNext()     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            if (r9 == 0) goto L_0x00a4
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            r9.<init>()     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            r10 = 0
            java.lang.String r11 = r8.getString(r10)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            java.lang.String[] r11 = r11.split(r6)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            r12 = 1
            java.lang.String r12 = r8.getString(r12)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            java.lang.String[] r12 = r12.split(r6)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            r13 = 2
            java.lang.String r13 = r8.getString(r13)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            java.lang.String[] r13 = r13.split(r6)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
        L_0x005a:
            int r14 = r12.length     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            if (r10 >= r14) goto L_0x00a0
            com.braintreepayments.api.internal.AnalyticsEvent r14 = new com.braintreepayments.api.internal.AnalyticsEvent     // Catch:{ JSONException -> 0x0095 }
            r14.<init>()     // Catch:{ JSONException -> 0x0095 }
            r15 = r11[r10]     // Catch:{ JSONException -> 0x0095 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ JSONException -> 0x0095 }
            int r15 = r15.intValue()     // Catch:{ JSONException -> 0x0095 }
            r14.id = r15     // Catch:{ JSONException -> 0x0095 }
            r15 = r12[r10]     // Catch:{ JSONException -> 0x0095 }
            r14.event = r15     // Catch:{ JSONException -> 0x0095 }
            r15 = r13[r10]     // Catch:{ JSONException -> 0x0095 }
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ JSONException -> 0x0095 }
            r16 = r11
            r17 = r12
            long r11 = r15.longValue()     // Catch:{ JSONException -> 0x0099 }
            r14.timestamp = r11     // Catch:{ JSONException -> 0x0099 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0099 }
            int r12 = r8.getColumnIndex(r5)     // Catch:{ JSONException -> 0x0099 }
            java.lang.String r12 = r8.getString(r12)     // Catch:{ JSONException -> 0x0099 }
            r11.<init>(r12)     // Catch:{ JSONException -> 0x0099 }
            r14.metadata = r11     // Catch:{ JSONException -> 0x0099 }
            r9.add(r14)     // Catch:{ JSONException -> 0x0099 }
            goto L_0x0099
        L_0x0095:
            r16 = r11
            r17 = r12
        L_0x0099:
            int r10 = r10 + 1
            r11 = r16
            r12 = r17
            goto L_0x005a
        L_0x00a0:
            r7.add(r9)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            goto L_0x0034
        L_0x00a4:
            r8.close()     // Catch:{ SQLiteException -> 0x00af, all -> 0x00a8 }
            goto L_0x00b2
        L_0x00a8:
            r0 = move-exception
            if (r4 == 0) goto L_0x00ae
            r4.close()
        L_0x00ae:
            throw r0
        L_0x00af:
            if (r4 == 0) goto L_0x00b5
        L_0x00b2:
            r4.close()
        L_0x00b5:
            java.util.Iterator r4 = r7.iterator()     // Catch:{ JSONException -> 0x00e5 }
        L_0x00b9:
            boolean r5 = r4.hasNext()     // Catch:{ JSONException -> 0x00e5 }
            if (r5 == 0) goto L_0x00e5
            java.lang.Object r5 = r4.next()     // Catch:{ JSONException -> 0x00e5 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ JSONException -> 0x00e5 }
            r6 = r19
            org.json.JSONObject r7 = serializeEvents(r0, r6, r5)     // Catch:{ JSONException -> 0x00e5 }
            if (r22 == 0) goto L_0x00d8
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00b9 }
            r1.post(r2, r7)     // Catch:{ Exception -> 0x00b9 }
            r3.removeEvents(r5)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00b9
        L_0x00d8:
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00b9 }
            com.braintreepayments.api.internal.AnalyticsSender$1 r8 = new com.braintreepayments.api.internal.AnalyticsSender$1     // Catch:{ Exception -> 0x00b9 }
            r8.<init>(r3, r5)     // Catch:{ Exception -> 0x00b9 }
            r1.post(r2, r7, r8)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00b9
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.send(android.content.Context, com.braintreepayments.api.models.Authorization, com.braintreepayments.api.internal.BraintreeHttpClient, java.lang.String, boolean):void");
    }

    public static SequenceAction sequence(Action action, Action action2) {
        SequenceAction sequenceAction = (SequenceAction) action(SequenceAction.class);
        sequenceAction.actions.add(action);
        Actor actor = sequenceAction.actor;
        if (actor != null) {
            action.setActor(actor);
        }
        sequenceAction.actions.add(action2);
        Actor actor2 = sequenceAction.actor;
        if (actor2 != null) {
            action2.setActor(actor2);
        }
        return sequenceAction;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0143 A[LOOP:0: B:48:0x013d->B:50:0x0143, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject serializeEvents(android.content.Context r9, com.braintreepayments.api.models.Authorization r10, java.util.List<com.braintreepayments.api.internal.AnalyticsEvent> r11) throws org.json.JSONException {
        /*
            r0 = 0
            java.lang.Object r1 = r11.get(r0)
            com.braintreepayments.api.internal.AnalyticsEvent r1 = (com.braintreepayments.api.internal.AnalyticsEvent) r1
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            boolean r3 = r10 instanceof com.braintreepayments.api.models.ClientToken
            if (r3 == 0) goto L_0x001a
            java.lang.String r10 = r10.getBearer()
            java.lang.String r3 = "authorization_fingerprint"
            r2.put(r3, r10)
            goto L_0x0023
        L_0x001a:
            java.lang.String r10 = r10.getBearer()
            java.lang.String r3 = "tokenization_key"
            r2.put(r3, r10)
        L_0x0023:
            org.json.JSONObject r10 = r1.metadata
            java.lang.String r1 = "platform"
            java.lang.String r3 = "Android"
            org.json.JSONObject r10 = r10.put(r1, r3)
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r3 = "platformVersion"
            org.json.JSONObject r10 = r10.put(r3, r1)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r3 = "3.17.4"
            org.json.JSONObject r10 = r10.put(r1, r3)
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r3 = "merchantAppId"
            org.json.JSONObject r10 = r10.put(r3, r1)
            java.lang.String r1 = r9.getPackageName()
            android.content.pm.PackageManager r3 = r9.getPackageManager()
            r4 = 0
            android.content.pm.ApplicationInfo r1 = r3.getApplicationInfo(r1, r0)     // Catch:{ NameNotFoundException -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r1 = r4
        L_0x005a:
            if (r1 == 0) goto L_0x0063
            java.lang.CharSequence r1 = r3.getApplicationLabel(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0064
        L_0x0063:
            r1 = r4
        L_0x0064:
            if (r1 != 0) goto L_0x0068
            java.lang.String r1 = "ApplicationNameUnknown"
        L_0x0068:
            java.lang.String r3 = "merchantAppName"
            org.json.JSONObject r10 = r10.put(r3, r1)
            java.lang.String r1 = android.os.Build.TAGS
            r3 = 1
            if (r1 == 0) goto L_0x007d
            java.lang.String r5 = "test-keys"
            boolean r1 = r1.contains(r5)
            if (r1 == 0) goto L_0x007d
            r1 = 1
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x008a }
            java.lang.String r6 = "/system/app/Superuser.apk"
            r5.<init>(r6)     // Catch:{ Exception -> 0x008a }
            boolean r5 = r5.exists()     // Catch:{ Exception -> 0x008a }
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r7 = "/system/xbin/which"
            java.lang.String r8 = "su"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8}     // Catch:{ Exception -> 0x00b1 }
            java.lang.Process r6 = r6.exec(r7)     // Catch:{ Exception -> 0x00b1 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b1 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b1 }
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Exception -> 0x00b1 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00b1 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r6 = r7.readLine()     // Catch:{ Exception -> 0x00b1 }
            if (r6 == 0) goto L_0x00b1
            r6 = 1
            goto L_0x00b2
        L_0x00b1:
            r6 = 0
        L_0x00b2:
            if (r1 != 0) goto L_0x00ba
            if (r5 != 0) goto L_0x00ba
            if (r6 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r3 = 0
        L_0x00ba:
            java.lang.String r1 = java.lang.Boolean.toString(r3)
            java.lang.String r3 = "deviceRooted"
            org.json.JSONObject r10 = r10.put(r3, r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r3 = "deviceManufacturer"
            org.json.JSONObject r10 = r10.put(r3, r1)
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.String r3 = "deviceModel"
            org.json.JSONObject r10 = r10.put(r3, r1)
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = "BraintreeApi"
            android.content.SharedPreferences r9 = r9.getSharedPreferences(r1, r0)
            java.lang.String r0 = "braintreeUUID"
            java.lang.String r1 = r9.getString(r0, r4)
            if (r1 != 0) goto L_0x00f5
            java.lang.String r1 = com.braintreepayments.api.internal.ManifestValidator.getFormattedUUID()
            android.content.SharedPreferences$Editor r9 = r9.edit()
            android.content.SharedPreferences$Editor r9 = r9.putString(r0, r1)
            r9.apply()
        L_0x00f5:
            java.lang.String r9 = "deviceAppGeneratedPersistentUuid"
            org.json.JSONObject r9 = r10.put(r9, r1)
            java.lang.String r10 = android.os.Build.PRODUCT
            java.lang.String r0 = "google_sdk"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 != 0) goto L_0x0127
            java.lang.String r10 = android.os.Build.PRODUCT
            java.lang.String r0 = "sdk"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 != 0) goto L_0x0127
            java.lang.String r10 = android.os.Build.MANUFACTURER
            java.lang.String r0 = "Genymotion"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 != 0) goto L_0x0127
            java.lang.String r10 = android.os.Build.FINGERPRINT
            java.lang.String r0 = "generic"
            boolean r10 = r10.contains(r0)
            if (r10 == 0) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            java.lang.String r10 = "false"
            goto L_0x0129
        L_0x0127:
            java.lang.String r10 = "true"
        L_0x0129:
            java.lang.String r0 = "isSimulator"
            org.json.JSONObject r9 = r9.put(r0, r10)
            java.lang.String r10 = "_meta"
            r2.put(r10, r9)
            org.json.JSONArray r9 = new org.json.JSONArray
            r9.<init>()
            java.util.Iterator r10 = r11.iterator()
        L_0x013d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0162
            java.lang.Object r11 = r10.next()
            com.braintreepayments.api.internal.AnalyticsEvent r11 = (com.braintreepayments.api.internal.AnalyticsEvent) r11
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r11.event
            java.lang.String r3 = "kind"
            org.json.JSONObject r0 = r0.put(r3, r1)
            long r3 = r11.timestamp
            java.lang.String r11 = "timestamp"
            org.json.JSONObject r11 = r0.put(r11, r3)
            r9.put(r11)
            goto L_0x013d
        L_0x0162:
            java.lang.String r10 = "analytics"
            r2.put(r10, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.serializeEvents(android.content.Context, com.braintreepayments.api.models.Authorization, java.util.List):org.json.JSONObject");
    }

    public static Bitmap setBitMapColour(Context context, int i, String str) throws NullPointerException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int colour = getColour(str, "#A6A6A6");
        Drawable mutate = ((Drawable) Objects.requireNonNull(ContextCompat.getDrawable(context, i))).mutate();
        mutate.setColorFilter(new PorterDuffColorFilter(colour, Mode.SRC_IN));
        return drawableToBitmap(mutate);
    }

    public static void setFallback(Boolean bool) {
        PTConstants.PT_FALLBACK = bool.booleanValue();
    }

    public static void setPackageNameFromResolveInfoList(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        String packageName = context.getPackageName();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                intent.setPackage(packageName);
                return;
            }
        }
    }

    public static long skip(InputStream inputStream, long j) throws IOException {
        checkArgument(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                skip = 1;
            }
            j2 -= skip;
        }
        return j;
    }

    public static void startDeviceCollector(BraintreeFragment braintreeFragment, String str, String str2, BraintreeResponseListener<String> braintreeResponseListener) throws ClassNotFoundException, NumberFormatException {
        braintreeFragment.sendAnalyticsEvent("data-collector.kount.started");
        Class.forName(DataCollector.class.getName());
        DataCollector$2 dataCollector$2 = new DataCollector$2(braintreeFragment, str, str2, braintreeResponseListener);
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(dataCollector$2) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    public static String storageKeyWithSuffix(CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, ":");
        outline78.append(cleverTapInstanceConfig.accountId);
        return outline78.toString();
    }

    public static Objects$ToStringHelper toStringHelper(Object obj) {
        String replaceAll = obj.getClass().getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return new Objects$ToStringHelper(replaceAll.substring(lastIndexOf + 1), null);
    }

    public static void tokenize(BraintreeFragment braintreeFragment, PaymentData paymentData) {
        try {
            PaymentMethodNonce fromString = fromString(paymentData.toJson());
            braintreeFragment.mCachedPaymentMethodNonces.add(0, fromString);
            braintreeFragment.postOrQueueCallback(new QueuedCallback(fromString) {
                public void run() {
                    BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
                }
            });
            braintreeFragment.sendAnalyticsEvent("google-payment.nonce-received");
        } catch (NullPointerException | JSONException unused) {
            braintreeFragment.sendAnalyticsEvent("google-payment.failed");
            try {
                String string = new JSONObject(paymentData.toJson()).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString("token");
                ErrorWithResponse errorWithResponse = new ErrorWithResponse();
                errorWithResponse.mOriginalResponse = string;
                errorWithResponse.parseJson(string);
                braintreeFragment.postOrQueueCallback(new QueuedCallback(errorWithResponse) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
            } catch (NullPointerException | JSONException e2) {
                braintreeFragment.postOrQueueCallback(new QueuedCallback(e2) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
            }
        }
    }

    public static void validateActivityInManifest(android.app.Application application, Class cls) throws NameNotFoundException {
        ActivityInfo[] activityInfoArr = application.getPackageManager().getPackageInfo(application.getPackageName(), 1).activities;
        String name = cls.getName();
        for (ActivityInfo activityInfo : activityInfoArr) {
            if (activityInfo.name.equals(name)) {
                Logger.i(name.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        Logger.i(name.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    public static void validateReceiverInManifest(android.app.Application application, String str) throws NameNotFoundException {
        for (ActivityInfo activityInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 2).receivers) {
            if (activityInfo.name.equals(str)) {
                Logger.i(str.replaceFirst("com.clevertap.android.", "") + " is present");
                return;
            }
        }
        Logger.i(str.replaceFirst("com.clevertap.android.", "") + " not present");
    }

    public static void validateServiceInManifest(android.app.Application application, String str) throws NameNotFoundException {
        for (ServiceInfo serviceInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 4).services) {
            if (serviceInfo.name.equals(str)) {
                Logger.i(str.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        Logger.i(str.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    public static void verbose(String str) {
        int i = TemplateRenderer.debugLevel;
        int intValue = LogLevel.VERBOSE.intValue();
    }

    public static String versionedPath(String str) {
        return GeneratedOutlineSupport.outline50("/v1/", str);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, int i) {
        if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate((long) i);
        }
    }

    public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.preVisitDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    walkFileTree(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.visitFile(file2);
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static String getString(Context context, String str, String str2, String str3) {
        return getPreferences(context, str).getString(str2, str3);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(KeyframesParser.parse(jsonReader, lottieComposition, z ? com.airbnb.lottie.utils.Utils.dpScale() : 1.0f, FloatParser.INSTANCE, false));
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static SharedPreferences getPreferences(Context context) {
        return getPreferences(context, null);
    }

    public static void verbose(String str, Throwable th) {
        int i = TemplateRenderer.debugLevel;
        int intValue = LogLevel.VERBOSE.intValue();
    }

    public static ParallelAction parallel(Action action, Action action2, Action action3) {
        ParallelAction parallelAction = (ParallelAction) action(ParallelAction.class);
        parallelAction.actions.add(action);
        Actor actor = parallelAction.actor;
        if (actor != null) {
            action.setActor(actor);
        }
        parallelAction.actions.add(action2);
        Actor actor2 = parallelAction.actor;
        if (actor2 != null) {
            action2.setActor(actor2);
        }
        parallelAction.actions.add(action3);
        Actor actor3 = parallelAction.actor;
        if (actor3 != null) {
            action3.setActor(actor3);
        }
        return parallelAction;
    }

    public static SequenceAction sequence(Action action, Action action2, Action action3, Action action4) {
        SequenceAction sequenceAction = (SequenceAction) action(SequenceAction.class);
        sequenceAction.actions.add(action);
        Actor actor = sequenceAction.actor;
        if (actor != null) {
            action.setActor(actor);
        }
        sequenceAction.actions.add(action2);
        Actor actor2 = sequenceAction.actor;
        if (actor2 != null) {
            action2.setActor(actor2);
        }
        sequenceAction.actions.add(action3);
        Actor actor3 = sequenceAction.actor;
        if (actor3 != null) {
            action3.setActor(actor3);
        }
        sequenceAction.actions.add(action4);
        Actor actor4 = sequenceAction.actor;
        if (actor4 != null) {
            action4.setActor(actor4);
        }
        return sequenceAction;
    }

    public static void tokenize(BraintreeFragment braintreeFragment, PaymentMethodBuilder paymentMethodBuilder, PaymentMethodNonceCallback paymentMethodNonceCallback) {
        paymentMethodBuilder.mSessionId = braintreeFragment.mSessionId;
        TokenizationClient$1 tokenizationClient$1 = new TokenizationClient$1(paymentMethodBuilder, braintreeFragment, paymentMethodNonceCallback);
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(tokenizationClient$1) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
        if (a(r0.f1909a, r1) != false) goto L_0x011e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b a(javax.crypto.SecretKey r20, boolean r21, byte[] r22, byte[] r23) {
        /*
            r0 = r21
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a
            r1.<init>()
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.j.ay r2 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.j.ay
            byte[] r3 = r20.getEncoded()
            r2.<init>(r3)
            r1.a(r0, r2)
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b r2 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b
            r2.<init>(r1)
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.j.ay r1 = new com.cardinalcommerce.dependencies.internal.bouncycastle.a.j.ay
            byte[] r3 = r20.getEncoded()
            r1.<init>(r3)
            byte[] r3 = b(r22)
            byte[] r4 = b(r23)
            r2.f1914d = r0
            r5 = 0
            r2.m = r5
            r6 = 1
            r2.f1915e = r6
            byte[] r3 = b(r3)
            byte[] r4 = b(r4)
            r2.i = r4
            r4 = 16
            r2.f1916f = r4
            if (r0 == 0) goto L_0x0044
            r7 = 16
            goto L_0x0046
        L_0x0044:
            r7 = 32
        L_0x0046:
            byte[] r7 = new byte[r7]
            r2.l = r7
            if (r3 == 0) goto L_0x018a
            int r7 = r3.length
            if (r7 < r6) goto L_0x018a
            if (r0 == 0) goto L_0x0070
            byte[] r0 = r2.h
            if (r0 == 0) goto L_0x0070
            boolean r0 = a(r0, r3)
            if (r0 == 0) goto L_0x0070
            byte[] r0 = r2.g
            if (r0 == 0) goto L_0x0070
            byte[] r7 = r1.f1917a
            boolean r0 = a(r0, r7)
            if (r0 != 0) goto L_0x0068
            goto L_0x0070
        L_0x0068:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "cannot reuse nonce for GCM encryption"
            r0.<init>(r1)
            throw r0
        L_0x0070:
            r2.h = r3
            byte[] r0 = r1.f1917a
            r2.g = r0
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e r0 = r2.f1911a
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a r0 = (com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) r0
            r0.a(r6, r1)
            byte[] r0 = new byte[r4]
            r2.j = r0
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e r1 = r2.f1911a
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a r1 = (com.cardinalcommerce.dependencies.internal.bouncycastle.a.e.a) r1
            r3 = 0
            r1.a(r0, r3, r0, r3)
            com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a.e r0 = r2.f1912b
            byte[] r1 = r2.j
            long[][] r7 = r0.f1910b
            r8 = 2
            if (r7 != 0) goto L_0x00a2
            int[] r7 = new int[r8]
            r7 = {256, 2} // fill-array
            java.lang.Class<long> r9 = long.class
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r9, r7)
            long[][] r7 = (long[][]) r7
            r0.f1910b = r7
            goto L_0x00ab
        L_0x00a2:
            byte[] r7 = r0.f1909a
            boolean r7 = a(r7, r1)
            if (r7 == 0) goto L_0x00ab
            goto L_0x011e
        L_0x00ab:
            byte[] r1 = b(r1)
            r0.f1909a = r1
            long[][] r7 = r0.f1910b
            r7 = r7[r6]
            a(r1, r3, r7)
            long[][] r1 = r0.f1910b
            r7 = r1[r6]
            r1 = r1[r6]
            r9 = r7[r3]
            r11 = r7[r6]
            r7 = 57
            long r13 = r11 << r7
            r15 = 7
            long r16 = r9 >>> r15
            long r16 = r16 ^ r13
            long r18 = r13 >>> r6
            long r16 = r16 ^ r18
            long r18 = r13 >>> r8
            long r16 = r16 ^ r18
            long r13 = r13 >>> r15
            long r13 = r13 ^ r16
            r1[r3] = r13
            long r11 = r11 >>> r15
            long r9 = r9 << r7
            long r9 = r9 | r11
            r1[r6] = r9
        L_0x00dd:
            r1 = 256(0x100, float:3.59E-43)
            if (r8 >= r1) goto L_0x011e
            long[][] r1 = r0.f1910b
            int r7 = r8 >> 1
            r7 = r1[r7]
            r9 = r1[r8]
            r10 = r7[r3]
            r12 = r7[r6]
            r7 = 63
            long r14 = r10 >> r7
            r16 = -2233785415175766016(0xe100000000000000, double:-1.757388200993436E159)
            long r16 = r14 & r16
            long r10 = r10 ^ r16
            long r10 = r10 << r6
            long r16 = r12 >>> r7
            long r10 = r10 | r16
            r9[r3] = r10
            long r10 = r12 << r6
            long r12 = -r14
            long r10 = r10 | r12
            r9[r6] = r10
            r7 = r1[r8]
            r9 = r1[r6]
            int r10 = r8 + 1
            r1 = r1[r10]
            r10 = r7[r3]
            r12 = r9[r3]
            long r10 = r10 ^ r12
            r1[r3] = r10
            r10 = r7[r6]
            r12 = r9[r6]
            long r9 = r12 ^ r10
            r1[r6] = r9
            int r8 = r8 + 2
            goto L_0x00dd
        L_0x011e:
            r2.f1913c = r5
            byte[] r0 = new byte[r4]
            r2.k = r0
            byte[] r1 = r2.h
            int r5 = r1.length
            r7 = 12
            if (r5 != r7) goto L_0x0136
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r3, r0, r3, r5)
            byte[] r0 = r2.k
            r1 = 15
            r0[r1] = r6
            goto L_0x015a
        L_0x0136:
            int r5 = r1.length
            r6 = 0
        L_0x0138:
            if (r6 >= r5) goto L_0x0146
            int r7 = r5 - r6
            int r7 = java.lang.Math.min(r7, r4)
            r2.a(r0, r1, r6, r7)
            int r6 = r6 + 16
            goto L_0x0138
        L_0x0146:
            byte[] r0 = new byte[r4]
            byte[] r1 = r2.h
            int r1 = r1.length
            long r5 = (long) r1
            r7 = 8
            long r5 = r5 * r7
            r1 = 8
            a(r5, r0, r1)
            byte[] r1 = r2.k
            r2.a(r1, r0)
        L_0x015a:
            byte[] r0 = new byte[r4]
            r2.n = r0
            byte[] r0 = new byte[r4]
            r2.o = r0
            byte[] r0 = new byte[r4]
            r2.p = r0
            byte[] r0 = new byte[r4]
            r2.u = r0
            r2.v = r3
            r0 = 0
            r2.w = r0
            r2.x = r0
            byte[] r4 = r2.k
            byte[] r4 = b(r4)
            r2.q = r4
            r4 = -2
            r2.r = r4
            r2.s = r3
            r2.t = r0
            byte[] r0 = r2.i
            if (r0 == 0) goto L_0x0189
            int r1 = r0.length
            r2.a(r0, r3, r1)
        L_0x0189:
            return r2
        L_0x018a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "IV must be at least 1 byte"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.a(javax.crypto.SecretKey, boolean, byte[], byte[]):com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b");
    }

    public static i a(b bVar) {
        String str = bVar.g;
        i iVar = new i();
        if (!a1(bVar.i)) {
            iVar.a(false, "ChallengeCompletionInd");
        }
        if (!iVar.f2109a) {
            return iVar;
        }
        if (!bVar.i.equalsIgnoreCase("N")) {
            return g(bVar);
        }
        iVar.a(a(str, 2));
        if (iVar.f2109a) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 1537:
                    if (str.equals("01")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1538:
                    if (str.equals("02")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1539:
                    if (str.equals("03")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1540:
                    if (str.equals("04")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1541:
                    if (str.equals("05")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                i g2 = g(bVar);
                if (!a1(bVar.f2090f)) {
                    g2.a(false);
                    g2.a((String) "AcsHTML");
                }
                return g2;
            } else if (c2 == 1) {
                i g3 = g(bVar);
                if (!b(bVar.A)) {
                    g3.a(false, "SubmitAuthenticationLabel");
                }
                if (!b(bVar.l)) {
                    g3.a(false, "ChallengeInfoText");
                }
                return g3;
            } else if (c2 == 2) {
                i g4 = g(bVar);
                if (!b(bVar.l)) {
                    g4.a(false, "ChallengeInfoText");
                }
                if (!b(bVar.A)) {
                    g4.a(false, "SubmitAuthenticationLabel");
                }
                if (bVar.n.size() <= 0) {
                    g4.a(false, "ChallengeSelectInfo");
                }
                return g4;
            } else if (c2 == 3) {
                i g5 = g(bVar);
                if (!b(bVar.l)) {
                    g5.a(false, "ChallengeInfoText");
                }
                if (!a1(bVar.w)) {
                    g5.a(false, "OobContinueLabel");
                }
                return g5;
            } else if (c2 != 4) {
                return g(bVar);
            } else {
                i g6 = g(bVar);
                if (!b(bVar.l)) {
                    g6.a(false, "ChallengeInfoText");
                }
                if (!b(bVar.A)) {
                    g6.a(false, "SubmitAuthenticationLabel");
                }
                if (bVar.n.size() <= 0) {
                    g6.a(false, "ChallengeSelectInfo");
                }
                return g6;
            }
        } else {
            iVar.a((String) "AcsUiType");
            return iVar;
        }
    }

    public static Bundle fromJson(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(next);
            String optString = jSONObject.optString(next);
            if (optJSONArray != null && optJSONArray.length() <= 0) {
                bundle.putStringArray(next, new String[0]);
            } else if (optJSONArray != null && optJSONArray.optString(0) != null) {
                String[] strArr = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    strArr[i] = optJSONArray.optString(i);
                }
                bundle.putStringArray(next, strArr);
            } else if (optString != null) {
                bundle.putString(next, optString);
            } else {
                PrintStream printStream = System.err;
                printStream.println("unable to transform json to bundle " + next);
            }
        }
        return bundle;
    }

    public static String a(CardinalConfigurationParameters cardinalConfigurationParameters) {
        return c$1.f1891a[cardinalConfigurationParameters.g.ordinal()] != 1 ? "https://centinelapi.cardinalcommerce.com/V1/" : "https://centinelapistag.cardinalcommerce.com/V1/";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m289a(String str) {
        String[] split = str.split("\\.");
        if (split.length <= 1) {
            return null;
        }
        byte[] decode = android.util.Base64.decode(split[1], 8);
        if (decode != null) {
            return new String(decode, StandardCharsets.UTF_8);
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Null decodedBytes"));
    }

    public static List<X509Certificate> a(List<Base64> list) {
        Object obj;
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                try {
                    obj = b(list.get(i).a());
                } catch (CertificateException unused) {
                    obj = null;
                }
                if (obj != null) {
                    linkedList.add(obj);
                } else {
                    throw new ParseException(GeneratedOutlineSupport.outline41("Invalid X.509 certificate at position ", i), 0);
                }
            }
        }
        return linkedList;
    }

    public static Cipher a(SecretKey secretKey, boolean z, byte[] bArr, Provider provider) {
        Cipher cipher;
        if (provider == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } else {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), EncryptionHelper.algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        if (z) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        return cipher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, com.cardinalcommerce.shared.cs.e.b r7, com.cardinalcommerce.shared.userinterfaces.UiCustomization r8) {
        /*
            f3107b = r6
            java.lang.String r0 = r7.g
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 2
            r4 = 3
            r5 = 4
            switch(r1) {
                case 1537: goto L_0x0038;
                case 1538: goto L_0x002e;
                case 1539: goto L_0x0024;
                case 1540: goto L_0x001a;
                case 1541: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0042
        L_0x0010:
            java.lang.String r1 = "05"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x001a:
            java.lang.String r1 = "04"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 4
            goto L_0x0043
        L_0x0024:
            java.lang.String r1 = "03"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 2
            goto L_0x0043
        L_0x002e:
            java.lang.String r1 = "02"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 3
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            if (r0 == 0) goto L_0x005b
            if (r0 == r2) goto L_0x004f
            if (r0 == r3) goto L_0x004f
            if (r0 == r4) goto L_0x004f
            if (r0 == r5) goto L_0x004f
            r6 = 0
            goto L_0x0067
        L_0x004f:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.Class<com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView> r1 = com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView.class
            r0.<init>(r6, r1)
            goto L_0x0066
        L_0x005b:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.Class<com.cardinalcommerce.shared.cs.userinterfaces.ChallengeHTMLView> r1 = com.cardinalcommerce.shared.cs.userinterfaces.ChallengeHTMLView.class
            r0.<init>(r6, r1)
        L_0x0066:
            r6 = r0
        L_0x0067:
            if (r6 == 0) goto L_0x0083
            java.lang.String r0 = "StepUpData"
            r6.putExtra(r0, r7)
            java.lang.String r7 = "UiCustomization"
            r6.putExtra(r7, r8)
            r7 = 268435456(0x10000000, float:2.524355E-29)
            android.content.Intent r7 = r6.addFlags(r7)
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            r7.addFlags(r8)
            android.content.Context r7 = f3107b
            r7.startActivity(r6)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.c.k.a(android.content.Context, com.cardinalcommerce.shared.cs.e.b, com.cardinalcommerce.shared.userinterfaces.UiCustomization):void");
    }

    public static void a(b bVar, Context context, UiCustomization uiCustomization) {
        if (f93a) {
            return;
        }
        if (bVar.B.equalsIgnoreCase("Y") || bVar.B.equalsIgnoreCase("N")) {
            a();
            com.cardinalcommerce.emvco.a.f.b.a().b();
            throw null;
        } else if (bVar.i.equalsIgnoreCase("N")) {
            a(context, bVar, uiCustomization);
        } else {
            throw null;
        }
    }

    public static void a(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            int a2 = a(bArr, i);
            jArr[i2] = (((long) a(bArr, i + 4)) & 4294967295L) | ((((long) a2) & 4294967295L) << 32);
            i += 8;
        }
    }

    public static byte[] a(SecretKey secretKey, byte[] bArr, Provider provider) {
        Mac mac;
        if (provider != null) {
            try {
                mac = Mac.getInstance(secretKey.getAlgorithm(), provider);
            } catch (NoSuchAlgorithmException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported HMAC algorithm: ");
                outline73.append(e2.getMessage());
                throw new JOSEException(outline73.toString(), e2);
            } catch (InvalidKeyException e3) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Invalid HMAC key: ");
                outline732.append(e3.getMessage());
                throw new JOSEException(outline732.toString(), e3);
            }
        } else {
            mac = Mac.getInstance(secretKey.getAlgorithm());
        }
        mac.init(secretKey);
        mac.update(bArr);
        return mac.doFinal();
    }

    public static void a(Context context) {
        f3106a = context.getResources().getString(R$string.faceCaptureFaceNotFound);
        f94b = context.getResources().getString(R$string.faceCaptureFaceFound);
        f3108c = context.getResources().getString(R$string.faceCaptureActivity);
        context.getResources().getString(R$string.moveCloser);
        f3109e = context.getResources().getString(R$string.faceCaptureMoveAway);
        f3110f = context.getResources().getString(R$string.faceCaptureLookStraight);
        g = context.getResources().getString(R$string.faceCaptureAutoCaptureWait);
        h = context.getResources().getString(R$string.faceCaptureAutoCaptureAction);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m290a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
