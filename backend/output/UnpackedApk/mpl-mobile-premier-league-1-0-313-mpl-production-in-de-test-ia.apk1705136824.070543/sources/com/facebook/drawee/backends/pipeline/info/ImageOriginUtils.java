package com.facebook.drawee.backends.pipeline.info;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.AccessToken;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.Validate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEventType;
import com.facebook.react.views.image.ScaleTypeStartInside;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToCommandData;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToEndCommandData;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.react.views.text.ReactFontManager.FontFamily;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.soloader.MinElf$ElfError;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import com.facebook.soloader.SysUtil$MarshmallowSysdeps;
import com.facebook.yoga.YogaConfigJNIBase;
import com.facebook.yoga.YogaMeasureMode;
import com.google.android.gms.common.R;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealEvaluator;
import com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealProperty;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;
import com.google.android.material.internal.ViewOverlayApi18;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils$3;
import com.google.android.material.internal.ViewUtils$4;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.resources.TextAppearance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.paynimo.android.payment.UPIFragment;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.squareup.picasso.NetworkRequestHandler;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.ByteString;
import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.entities.invitation.InvitationReply;

public class ImageOriginUtils {
    public static YogaConfigJNIBase YOGA_CONFIG;
    public static OkHttpClient sClient;
    public static DisplayMetrics sScreenDisplayMetrics;
    public static DisplayMetrics sWindowDisplayMetrics;
    public static zzaa zza;

    public static WritableMap accessTokenToReactMap(AccessToken accessToken) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("accessToken", accessToken.token);
        createMap.putString("applicationID", accessToken.applicationId);
        createMap.putString("userID", accessToken.userId);
        createMap.putArray("permissions", Arguments.fromJavaArgs(setToStringArray(accessToken.permissions)));
        createMap.putArray("declinedPermissions", Arguments.fromJavaArgs(setToStringArray(accessToken.declinedPermissions)));
        createMap.putArray("expiredPermissions", Arguments.fromJavaArgs(setToStringArray(accessToken.expiredPermissions)));
        createMap.putString("accessTokenSource", accessToken.source.name());
        createMap.putDouble("expirationTime", (double) accessToken.expires.getTime());
        createMap.putDouble("lastRefreshTime", (double) accessToken.lastRefresh.getTime());
        createMap.putDouble("dataAccessExpirationTime", (double) accessToken.dataAccessExpirationTime.getTime());
        return createMap;
    }

    public static void appendGenericContent(Builder builder, ReadableMap readableMap) {
        if (readableMap.hasKey("commonParameters")) {
            ReadableMap map = readableMap.getMap("commonParameters");
            List<String> list = null;
            List reactArrayToStringList = map.hasKey("peopleIds") ? reactArrayToStringList(map.getArray("peopleIds")) : null;
            if (reactArrayToStringList != null) {
                list = Collections.unmodifiableList(reactArrayToStringList);
            }
            builder.peopleIds = list;
            builder.placeId = getValueOrNull(map, "placeId");
            builder.ref = getValueOrNull(map, "ref");
            if (map.hasKey("hashtag")) {
                ShareHashtag.Builder builder2 = new ShareHashtag.Builder();
                builder2.hashtag = map.getString("hashtag");
                builder.hashtag = builder2.build();
            }
        }
    }

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        boolean z = 0;
        int style = typeface == null ? 0 : typeface.getStyle();
        int i3 = (i2 == 1 || ((style & 1) != 0 && i2 == -1)) ? 1 : 0;
        if (i == 2 || ((style & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            if (ReactFontManager.sReactFontManagerInstance == null) {
                ReactFontManager.sReactFontManagerInstance = new ReactFontManager();
            }
            ReactFontManager reactFontManager = ReactFontManager.sReactFontManagerInstance;
            if (reactFontManager.mCustomTypefaceCache.containsKey(str)) {
                Typeface typeface2 = reactFontManager.mCustomTypefaceCache.get(str);
                if (VERSION.SDK_INT < 28 || i2 < 100 || i2 > 1000) {
                    typeface = Typeface.create(typeface2, i3);
                } else {
                    if ((i3 & 2) != 0) {
                        z = 1;
                    }
                    typeface = Typeface.create(typeface2, i2, z);
                }
            } else {
                FontFamily fontFamily = reactFontManager.mFontCache.get(str);
                if (fontFamily == null) {
                    fontFamily = new FontFamily(null);
                    reactFontManager.mFontCache.put(str, fontFamily);
                }
                typeface = fontFamily.mTypefaceSparseArray.get(i3);
                if (typeface == null) {
                    String str2 = ReactFontManager.EXTENSIONS[i3];
                    String[] strArr = ReactFontManager.FILE_EXTENSIONS;
                    int i4 = z;
                    while (true) {
                        if (i4 >= strArr.length) {
                            typeface = Typeface.create(str, i3);
                            break;
                        }
                        try {
                            typeface = Typeface.createFromAsset(assetManager, GeneratedOutlineSupport.outline53("fonts/", str, str2, strArr[i4]));
                            break;
                        } catch (RuntimeException unused) {
                            i4++;
                        }
                    }
                    if (typeface != null) {
                        fontFamily.mTypefaceSparseArray.put(i3, typeface);
                    }
                }
            }
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i3);
        }
        if (typeface != null) {
            return typeface;
        }
        return Typeface.defaultFromStyle(i3);
    }

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static void assertCondition(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static final void assertExplicitMeasureSpec(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
        }
    }

    public static <T> T assertNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new AssertionError();
    }

    public static String buildKeySelection(int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, ColorPropConverter.PREFIX_ATTR);
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("key IN ("), TextUtils.join(", ", strArr), ")");
    }

    public static ShareContent buildShareContent(ReadableMap readableMap) {
        ShareContent shareVideoContent;
        if (readableMap == null) {
            return null;
        }
        String string = readableMap.getString("contentType");
        if (string.equals("link")) {
            return buildShareLinkContent(readableMap);
        }
        if (string.equals("photo")) {
            SharePhotoContent.Builder builder = new SharePhotoContent.Builder();
            ReadableArray array = readableMap.getArray("photos");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(buildSharePhoto(array.getMap(i)));
            }
            builder.photos.clear();
            builder.addPhotos(arrayList);
            String valueOrNull = getValueOrNull(readableMap, "contentUrl");
            builder.contentUrl = valueOrNull != null ? Uri.parse(valueOrNull) : null;
            appendGenericContent(builder, readableMap);
            shareVideoContent = new SharePhotoContent(builder, null);
        } else if (string.equals("video")) {
            ShareVideoContent.Builder builder2 = new ShareVideoContent.Builder();
            String valueOrNull2 = getValueOrNull(readableMap, "contentUrl");
            builder2.contentUrl = valueOrNull2 != null ? Uri.parse(valueOrNull2) : null;
            builder2.contentDescription = getValueOrNull(readableMap, "contentDescription");
            builder2.contentTitle = getValueOrNull(readableMap, "contentTitle");
            if (readableMap.hasKey("previewPhoto")) {
                builder2.previewPhoto = new SharePhoto.Builder().readFrom(buildSharePhoto(readableMap.getMap("previewPhoto"))).build();
            }
            if (readableMap.hasKey("video")) {
                ReadableMap map = readableMap.getMap("video");
                ShareVideo.Builder builder3 = new ShareVideo.Builder();
                if (map.hasKey("localUrl")) {
                    builder3.localUrl = Uri.parse(map.getString("localUrl"));
                }
                ShareVideo build = builder3.build();
                ShareVideo.Builder builder4 = new ShareVideo.Builder();
                builder4.localUrl = build.localUrl;
                builder2.video = builder4.build();
            }
            appendGenericContent(builder2, readableMap);
            shareVideoContent = new ShareVideoContent(builder2, null);
        } else if (string.equals("open-graph")) {
            return buildShareOpenGraphContent(readableMap);
        } else {
            return null;
        }
        return shareVideoContent;
    }

    public static ShareLinkContent buildShareLinkContent(ReadableMap readableMap) {
        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
        builder.contentUrl = Uri.parse(readableMap.getString("contentUrl"));
        String valueOrNull = getValueOrNull(readableMap, "imageUrl");
        builder.setImageUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setContentDescription(getValueOrNull(readableMap, "contentDescription"));
        builder.setContentTitle(getValueOrNull(readableMap, "contentTitle"));
        builder.quote = getValueOrNull(readableMap, "quote");
        appendGenericContent(builder, readableMap);
        return new ShareLinkContent(builder, null);
    }

    public static ShareOpenGraphAction buildShareOpenGraphAction(ReadableMap readableMap) {
        ShareOpenGraphAction.Builder builder = new ShareOpenGraphAction.Builder();
        builder.setActionType(readableMap.getString(OneSingnalConstant.PARAM_ACTION_TYPE));
        ReadableMap map = readableMap.getMap("_properties");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            builder.putObject(nextKey, buildShareOpenGraphObject(map.getMap(nextKey).getMap(HSLCriteriaBuilder.VALUE)));
        }
        return builder.build();
    }

    public static ShareContent buildShareOpenGraphContent(ReadableMap readableMap) {
        ShareOpenGraphContent.Builder builder = new ShareOpenGraphContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setAction(buildShareOpenGraphAction(readableMap.getMap("action")));
        builder.setPreviewPropertyName(readableMap.getString("previewPropertyName"));
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static ShareOpenGraphObject buildShareOpenGraphObject(ReadableMap readableMap) {
        ShareOpenGraphObject.Builder builder = new ShareOpenGraphObject.Builder();
        ReadableMap map = readableMap.getMap("_properties");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map2 = map.getMap(nextKey);
            String string = map2.getString("type");
            char c2 = 65535;
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals(UPIFragment.CONFIG_TYPE_NUMBER)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -891985903:
                    if (string.equals(NetworkingModule.REQUEST_BODY_KEY_STRING)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 106642994:
                    if (string.equals("photo")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 778493761:
                    if (string.equals("open-graph-object")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.putDouble(nextKey, map2.getDouble(HSLCriteriaBuilder.VALUE));
            } else if (c2 == 1) {
                builder.putObject(nextKey, buildShareOpenGraphObject(map2.getMap(HSLCriteriaBuilder.VALUE)));
            } else if (c2 == 2) {
                builder.putPhoto(nextKey, buildSharePhoto(map2.getMap(HSLCriteriaBuilder.VALUE)));
            } else if (c2 == 3) {
                builder.putString(nextKey, map2.getString(HSLCriteriaBuilder.VALUE));
            }
        }
        return builder.build();
    }

    public static SharePhoto buildSharePhoto(ReadableMap readableMap) {
        SharePhoto.Builder builder = new SharePhoto.Builder();
        builder.imageUrl = Uri.parse(readableMap.getString("imageUrl"));
        builder.caption = getValueOrNull(readableMap, "caption");
        if (readableMap.hasKey("userGenerated")) {
            builder.userGenerated = readableMap.getBoolean("userGenerated");
        }
        return builder.build();
    }

    public static <K, V> MapBuilder$Builder<K, V> builder() {
        return new MapBuilder$Builder<>(null);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean compare(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int compositeARGBWithAlpha(int i, int i2) {
        return ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i2) / InvitationReply.EXPIRED);
    }

    public static void copyProperties(Drawable drawable, Drawable drawable2) {
        if (drawable != null && drawable != drawable2) {
            drawable.setBounds(drawable2.getBounds());
            drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
            drawable.setLevel(drawable2.getLevel());
            drawable.setVisible(drawable2.isVisible(), false);
            drawable.setState(drawable2.getState());
        }
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealEvaluator.CIRCULAR_REVEAL, new RevealInfo[]{new RevealInfo(f2, f3, f4)});
        RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f2, (int) f3, revealInfo.radius, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static OkHttpClient createClient(Context context) {
        return createClientBuilder().cache(new Cache(new File(context.getCacheDir(), "http-cache"), (long) 10485760)).build();
    }

    public static OkHttpClient.Builder createClientBuilder() {
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().connectTimeout(0, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());
        try {
            Security.insertProviderAt((Provider) Class.forName("org.conscrypt.OpenSSLProvider").newInstance(), 1);
        } catch (Exception unused) {
        }
        return cookieJar;
    }

    public static void d(String str, String str2, Object obj) {
        getTag(str);
        String.format(str2, new Object[]{obj});
    }

    public static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(next);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(next, jSONObject2.get(next));
            } else {
                deepMergeInto(optJSONObject2, optJSONObject);
                jSONObject.put(next, optJSONObject2);
            }
        }
    }

    public static double determinant(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        double d5 = dArr[3];
        double d6 = dArr[4];
        double d7 = dArr[5];
        double d8 = dArr[6];
        double d9 = dArr[7];
        double d10 = dArr[8];
        double d11 = dArr[9];
        double d12 = dArr[10];
        double d13 = dArr[11];
        double d14 = dArr[12];
        double d15 = dArr[13];
        double d16 = dArr[14];
        double d17 = dArr[15];
        double d18 = d5 * d8;
        double d19 = d4 * d9;
        double d20 = d5 * d7;
        double d21 = d3 * d9;
        double d22 = d14;
        double outline2 = GeneratedOutlineSupport.outline2(d21, d12, d22, (((d18 * d11) * d14) - ((d19 * d11) * d14)) - ((d20 * d12) * d14));
        double d23 = d4 * d7;
        double d24 = d3 * d8;
        double d25 = d15;
        double outline22 = GeneratedOutlineSupport.outline2(d19, d10, d25, (GeneratedOutlineSupport.outline2(d23, d13, d22, outline2) - ((d24 * d13) * d14)) - ((d18 * d10) * d15));
        double d26 = d5 * d6;
        double d27 = d9 * d2;
        double d28 = d4 * d6;
        double d29 = d8 * d2;
        double outline23 = GeneratedOutlineSupport.outline2(d29, d13, d25, (GeneratedOutlineSupport.outline2(d26, d12, d25, outline22) - ((d27 * d12) * d15)) - ((d28 * d13) * d15));
        double d30 = d16;
        double outline24 = GeneratedOutlineSupport.outline2(d27, d11, d30, (GeneratedOutlineSupport.outline2(d20, d10, d30, outline23) - ((d21 * d10) * d16)) - ((d26 * d11) * d16));
        double d31 = d3 * d6;
        double d32 = d2 * d7;
        double d33 = d17;
        return GeneratedOutlineSupport.outline2(d32, d12, d33, (GeneratedOutlineSupport.outline2(d28, d11, d33, GeneratedOutlineSupport.outline2(d24, d10, d33, (GeneratedOutlineSupport.outline2(d31, d13, d30, outline24) - ((d13 * d32) * d16)) - ((d23 * d10) * d17))) - ((d29 * d11) * d17)) - ((d31 * d12) * d17));
    }

    public static float dist(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static float distanceToFurthestCorner(float f2, float f3, float f4, float f5, float f6, float f7) {
        float dist = dist(f2, f3, f4, f5);
        float dist2 = dist(f2, f3, f6, f5);
        float dist3 = dist(f2, f3, f6, f7);
        float dist4 = dist(f2, f3, f4, f7);
        if (dist > dist2 && dist > dist3 && dist > dist4) {
            return dist;
        }
        if (dist2 <= dist3 || dist2 <= dist4) {
            return dist3 > dist4 ? dist3 : dist4;
        }
        return dist2;
    }

    public static void doOnApplyWindowInsets(View view, ViewUtils$OnApplyWindowInsetsListener viewUtils$OnApplyWindowInsetsListener) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new ViewUtils$3(viewUtils$OnApplyWindowInsetsListener, new ViewUtils$RelativePadding(ViewCompat.getPaddingStart(view), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom())));
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new ViewUtils$4());
        }
    }

    public static float dpToPx(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File dumbDeleteRecursive : listFiles) {
                    dumbDeleteRecursive(dumbDeleteRecursive);
                }
            } else {
                return;
            }
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("could not delete: " + file);
        }
    }

    public static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType, float f2, float f3) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            getEventDispatcherForReactTag((ReactContext) viewGroup.getContext(), viewGroup.getId()).dispatchEvent(ScrollEvent.obtain(viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f2, f3, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
        }
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        FileChannel fileChannel2 = fileChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel2, allocate, 0) == 1179403647) {
            boolean z = true;
            if (getu8(fileChannel2, allocate, 4) != 1) {
                z = false;
            }
            if (getu8(fileChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long r15 = z ? getu32(fileChannel2, allocate, 28) : get64(fileChannel2, allocate, 32);
            long j11 = z ? (long) getu16(fileChannel2, allocate, 44) : (long) getu16(fileChannel2, allocate, 56);
            int i = getu16(fileChannel2, allocate, z ? 42 : 54);
            if (j11 == 65535) {
                long r3 = z ? getu32(fileChannel2, allocate, 32) : get64(fileChannel2, allocate, 40);
                if (z) {
                    j10 = getu32(fileChannel2, allocate, r3 + 28);
                } else {
                    j10 = getu32(fileChannel2, allocate, r3 + 44);
                }
                j11 = j10;
            }
            long j12 = r15;
            long j13 = 0;
            while (true) {
                if (j13 >= j11) {
                    j = 0;
                    break;
                }
                if (z) {
                    j9 = getu32(fileChannel2, allocate, j12 + 0);
                } else {
                    j9 = getu32(fileChannel2, allocate, j12 + 0);
                }
                if (j9 == 2) {
                    j = z ? getu32(fileChannel2, allocate, j12 + 4) : get64(fileChannel2, allocate, j12 + 8);
                } else {
                    j12 += (long) i;
                    j13++;
                }
            }
            long j14 = 0;
            if (j != 0) {
                long j15 = j;
                long j16 = 0;
                int i2 = 0;
                while (true) {
                    boolean z2 = z;
                    long r7 = z ? getu32(fileChannel2, allocate, j15 + j14) : get64(fileChannel2, allocate, j15 + j14);
                    if (r7 == 1) {
                        j2 = j;
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                        } else {
                            throw new MinElf$ElfError("malformed DT_NEEDED section");
                        }
                    } else {
                        j2 = j;
                        if (r7 == 5) {
                            j16 = z2 ? getu32(fileChannel2, allocate, j15 + 4) : get64(fileChannel2, allocate, j15 + 8);
                        }
                    }
                    long j17 = 16;
                    j15 += z2 ? 8 : 16;
                    j14 = 0;
                    if (r7 != 0) {
                        z = z2;
                        j = j2;
                    } else if (j16 != 0) {
                        int i3 = 0;
                        while (true) {
                            if (((long) i3) >= j11) {
                                j3 = 0;
                                break;
                            }
                            if (z2) {
                                j4 = getu32(fileChannel2, allocate, r15 + j14);
                            } else {
                                j4 = getu32(fileChannel2, allocate, r15 + j14);
                            }
                            if (j4 == 1) {
                                if (z2) {
                                    j6 = getu32(fileChannel2, allocate, r15 + 8);
                                } else {
                                    j6 = get64(fileChannel2, allocate, r15 + j17);
                                }
                                if (z2) {
                                    j5 = j11;
                                    j7 = getu32(fileChannel2, allocate, r15 + 20);
                                } else {
                                    j5 = j11;
                                    j7 = get64(fileChannel2, allocate, r15 + 40);
                                }
                                if (j6 <= j16 && j16 < j7 + j6) {
                                    if (z2) {
                                        j8 = getu32(fileChannel2, allocate, r15 + 4);
                                    } else {
                                        j8 = get64(fileChannel2, allocate, r15 + 8);
                                    }
                                    j3 = j8 + (j16 - j6);
                                }
                            } else {
                                j5 = j11;
                            }
                            r15 += (long) i;
                            i3++;
                            j11 = j5;
                            j17 = 16;
                            j14 = 0;
                        }
                        long j18 = 0;
                        if (j3 != 0) {
                            String[] strArr = new String[i2];
                            int i4 = 0;
                            while (true) {
                                long j19 = j2 + j18;
                                long r10 = z2 ? getu32(fileChannel2, allocate, j19) : get64(fileChannel2, allocate, j19);
                                if (r10 == 1) {
                                    long r72 = (z2 ? getu32(fileChannel2, allocate, j2 + 4) : get64(fileChannel2, allocate, j2 + 8)) + j3;
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        long j20 = r72 + 1;
                                        short u8Var = getu8(fileChannel2, allocate, r72);
                                        if (u8Var == 0) {
                                            break;
                                        }
                                        sb.append((char) u8Var);
                                        r72 = j20;
                                    }
                                    strArr[i4] = sb.toString();
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4++;
                                    } else {
                                        throw new MinElf$ElfError("malformed DT_NEEDED section");
                                    }
                                }
                                j2 += z2 ? 8 : 16;
                                if (r10 != 0) {
                                    j18 = 0;
                                } else if (i4 == i2) {
                                    return strArr;
                                } else {
                                    throw new MinElf$ElfError("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new MinElf$ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new MinElf$ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new MinElf$ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new MinElf$ElfError("file is not ELF");
        }
    }

    public static boolean floatsEqual(float f2, float f3) {
        boolean z = true;
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (!Float.isNaN(f2) || !Float.isNaN(f3)) {
                z = false;
            }
            return z;
        }
        if (Math.abs(f3 - f2) >= 1.0E-5f) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fsyncRecursive(java.io.File r3) throws java.io.IOException {
        /*
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L_0x002f
            java.io.File[] r0 = r3.listFiles()
            if (r0 == 0) goto L_0x0018
            r3 = 0
        L_0x000d:
            int r1 = r0.length
            if (r3 >= r1) goto L_0x004d
            r1 = r0[r3]
            fsyncRecursive(r1)
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0018:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot list directory "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x002f:
            java.lang.String r0 = r3.getPath()
            java.lang.String r1 = "_lock"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x003c
            goto L_0x004d
        L_0x003c:
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "r"
            r0.<init>(r3, r1)
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ all -> 0x004e }
            r3.sync()     // Catch:{ all -> 0x004e }
            r0.close()
        L_0x004d:
            return
        L_0x004e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x0059:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.fsyncRecursive(java.io.File):void");
    }

    public static int get2BytesAsInt(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    public static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int length = arrayDrawable.mLayers.length;
            for (int i = 0; i < length; i++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static Map getBubblingEventTypeConstants() {
        MapBuilder$Builder builder = builder();
        builder.put("topChange", of("phasedRegistrationNames", of("bubbled", "onChange", "captured", "onChangeCapture")));
        builder.put("topSelect", of("phasedRegistrationNames", of("bubbled", "onSelect", "captured", "onSelectCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.START), of("phasedRegistrationNames", of("bubbled", "onTouchStart", "captured", "onTouchStartCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.MOVE), of("phasedRegistrationNames", of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.END), of("phasedRegistrationNames", of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.CANCEL), of("phasedRegistrationNames", of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture")));
        return builder.build();
    }

    public static int getColor(View view, int i) {
        return resolveOrThrow(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, resourceId);
                if (colorStateList != null) {
                    return colorStateList;
                }
            }
        }
        return typedArray.getColorStateList(i);
    }

    public static Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("UIView", of("ContentMode", of("ScaleAspectFit", Integer.valueOf(ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ScaleType.CENTER_INSIDE.ordinal()))));
        PointerEvents pointerEvents = PointerEvents.NONE;
        Integer valueOf = Integer.valueOf(0);
        PointerEvents pointerEvents2 = PointerEvents.BOX_NONE;
        Integer valueOf2 = Integer.valueOf(1);
        PointerEvents pointerEvents3 = PointerEvents.BOX_ONLY;
        Integer valueOf3 = Integer.valueOf(2);
        PointerEvents pointerEvents4 = PointerEvents.AUTO;
        hashMap.put("StyleConstants", of("PointerEventsValues", of("none", valueOf, "boxNone", valueOf2, "boxOnly", valueOf3, "unspecified", Integer.valueOf(3))));
        hashMap.put("PopupMenu", of(DialogModule.ACTION_DISMISSED, DialogModule.ACTION_DISMISSED, "itemSelected", "itemSelected"));
        hashMap.put("AccessibilityEventTypes", of("typeWindowStateChanged", Integer.valueOf(32), "typeViewFocused", Integer.valueOf(8), "typeViewClicked", Integer.valueOf(1)));
        return hashMap;
    }

    public static ViewGroup getContentView(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl getContentViewOverlay(View view) {
        ViewGroup contentView = getContentView(view);
        if (contentView == null) {
            return null;
        }
        return new ViewOverlayApi18(contentView);
    }

    public static WritableMap getDBError(String str) {
        return getError(null, "Database Error");
    }

    public static Pair<View, Integer> getDeepestLeaf(View view) {
        LinkedList linkedList = new LinkedList();
        Pair<View, Integer> pair = new Pair<>(view, Integer.valueOf(1));
        linkedList.add(pair);
        while (!linkedList.isEmpty()) {
            Pair<View, Integer> pair2 = (Pair) linkedList.poll();
            if (((Integer) pair2.second).intValue() > ((Integer) pair.second).intValue()) {
                pair = pair2;
            }
            Object obj = pair2.first;
            if (obj instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) obj;
                Integer valueOf = Integer.valueOf(((Integer) pair2.second).intValue() + 1);
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    linkedList.add(new Pair(viewGroup.getChildAt(i), valueOf));
                }
            }
        }
        return pair;
    }

    public static ColorStateList getDefaultTextAttribute(Context context, int i) {
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
            return colorStateList;
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Map getDirectEventTypeConstants() {
        MapBuilder$Builder builder = builder();
        builder.put("topContentSizeChange", of("registrationName", "onContentSizeChange"));
        builder.put("topLayout", of("registrationName", "onLayout"));
        builder.put("topLoadingError", of("registrationName", "onLoadingError"));
        builder.put("topLoadingFinish", of("registrationName", "onLoadingFinish"));
        builder.put("topLoadingStart", of("registrationName", "onLoadingStart"));
        builder.put("topSelectionChange", of("registrationName", "onSelectionChange"));
        builder.put("topMessage", of("registrationName", "onMessage"));
        builder.put("topClick", of("registrationName", "onClick"));
        builder.put("topScrollBeginDrag", of("registrationName", "onScrollBeginDrag"));
        builder.put("topScrollEndDrag", of("registrationName", "onScrollEndDrag"));
        builder.put("topScroll", of("registrationName", "onScroll"));
        builder.put("topMomentumScrollBegin", of("registrationName", "onMomentumScrollBegin"));
        builder.put("topMomentumScrollEnd", of("registrationName", "onMomentumScrollEnd"));
        return builder.build();
    }

    public static InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        File createTempFile = File.createTempFile("RequestBodyUtil", "temp", context.getApplicationContext().getCacheDir());
        createTempFile.deleteOnExit();
        InputStream openStream = FirebasePerfUrlConnection.openStream(new URL(uri.toString()));
        try {
            ReadableByteChannel newChannel = Channels.newChannel(openStream);
            try {
                fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.getChannel().transferFrom(newChannel, 0, Long.MAX_VALUE);
                FileInputStream fileInputStream = new FileInputStream(createTempFile);
                fileOutputStream.close();
                newChannel.close();
                return fileInputStream;
            } catch (Throwable th) {
                newChannel.close();
                throw th;
            }
        } finally {
            openStream.close();
        }
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    public static Drawable getDrawable1(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, resourceId);
                if (drawable != null) {
                    return drawable;
                }
            }
        }
        return typedArray.getDrawable(i);
    }

    public static RequestBody getEmptyBody(String str) {
        if (str.equals(RNCWebViewManager.HTTP_METHOD_POST) || str.equals("PUT") || str.equals("PATCH")) {
            return RequestBody.create((MediaType) null, ByteString.EMPTY);
        }
        return null;
    }

    public static WritableMap getError(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", str2);
        if (str != null) {
            createMap.putString("key", str);
        }
        return createMap;
    }

    public static EventDispatcher getEventDispatcherForReactTag(ReactContext reactContext, int i) {
        UIManager uIManager = getUIManager(reactContext, getUIManagerType(i), false);
        if (uIManager == null) {
            return null;
        }
        return (EventDispatcher) uIManager.getEventDispatcher();
    }

    public static InputStream getFileInputStream(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
                return getDownloadFileInputStream(context, parse);
            }
            return context.getContentResolver().openInputStream(parse);
        } catch (Exception e2) {
            FLog.e((String) "ReactNative", "Could not retrieve file for contentUri " + str, (Throwable) e2);
            return null;
        }
    }

    public static int getInt(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 24) & -16777216) | ((((byte) inputStream.read()) << GlyfDescript.X_DUAL) & 16711680) | ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    public static WritableMap getInvalidKeyError(String str) {
        return getError(null, "Invalid key");
    }

    public static WritableMap getInvalidValueError(String str) {
        return getError(null, "Invalid Value");
    }

    public static int getMeasureSpec(float f2, YogaMeasureMode yogaMeasureMode) {
        if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
            return MeasureSpec.makeMeasureSpec((int) f2, 1073741824);
        }
        if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
            return MeasureSpec.makeMeasureSpec((int) f2, LinearLayoutManager.INVALID_OFFSET);
        }
        return MeasureSpec.makeMeasureSpec(0, 0);
    }

    public static float getParentAbsoluteElevation(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ViewCompat.getElevation((View) parent);
        }
        return f2;
    }

    public static Map<String, Object> getPhysicalPixelsMap(DisplayMetrics displayMetrics, double d2) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
        hashMap.put("scale", Float.valueOf(displayMetrics.density));
        hashMap.put("fontScale", Double.valueOf(d2));
        hashMap.put("densityDpi", Integer.valueOf(displayMetrics.densityDpi));
        return hashMap;
    }

    public static WritableNativeMap getPhysicalPixelsNativeMap(DisplayMetrics displayMetrics, double d2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", displayMetrics.widthPixels);
        writableNativeMap.putInt("height", displayMetrics.heightPixels);
        writableNativeMap.putDouble("scale", (double) displayMetrics.density);
        writableNativeMap.putDouble("fontScale", d2);
        writableNativeMap.putDouble("densityDpi", (double) displayMetrics.densityDpi);
        return writableNativeMap;
    }

    public static ReactContext getReactContext(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static RootView getRootView(View view) {
        while (!(view instanceof RootView)) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return null;
            }
            assertCondition(parent instanceof View);
            view = (View) parent;
        }
        return (RootView) view;
    }

    public static ScalingUtils$ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils$ScaleType.FIT_XY;
            case 1:
                return ScalingUtils$ScaleType.FIT_START;
            case 2:
                return ScalingUtils$ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils$ScaleType.FIT_END;
            case 4:
                return ScalingUtils$ScaleType.CENTER;
            case 5:
                return ScalingUtils$ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils$ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils$ScaleType.FOCUS_CROP;
            case 8:
                return ScalingUtils$ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static String[] getSupportedAbis() {
        if (VERSION.SDK_INT >= 23) {
            return SysUtil$MarshmallowSysdeps.getSupportedAbis();
        }
        return SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    public static String getTag(String str) {
        return GeneratedOutlineSupport.outline50("TransportRuntime.", str);
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                return new TextAppearance(context, resourceId);
            }
        }
        return null;
    }

    public static TextView getTextView(Toolbar toolbar, CharSequence charSequence) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    public static UIManager getUIManager(ReactContext reactContext, int i) {
        return getUIManager(reactContext, i, true);
    }

    public static int getUIManagerType(int i) {
        return i % 2 == 0 ? 2 : 1;
    }

    public static Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) throws IOException {
        inputStream.skip(7);
        short read = (short) (inputStream.read() & InvitationReply.EXPIRED);
        short read2 = (short) (inputStream.read() & InvitationReply.EXPIRED);
        short read3 = (short) (inputStream.read() & InvitationReply.EXPIRED);
        if (read == 157 && read2 == 1 && read3 == 42) {
            return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
        }
        return null;
    }

    public static Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) throws IOException {
        getInt(inputStream);
        if (((byte) (inputStream.read() & InvitationReply.EXPIRED)) != 47) {
            return null;
        }
        byte read = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & Utf8.REPLACEMENT_BYTE) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    public static String getValueOrNull(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    public static YogaMeasureMode getYogaMeasureMode(float f2, float f3) {
        if (f2 == f3) {
            return YogaMeasureMode.EXACTLY;
        }
        if (Float.isInfinite(f3)) {
            return YogaMeasureMode.UNDEFINED;
        }
        return YogaMeasureMode.AT_MOST;
    }

    public static float getYogaSize(float f2, float f3) {
        if (f2 == f3) {
            return toPixelFromDIP(f3);
        }
        if (Float.isInfinite(f3)) {
            return Float.POSITIVE_INFINITY;
        }
        return toPixelFromDIP(f3);
    }

    public static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & 65535;
    }

    public static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    public static boolean hasPatternAt(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null) {
            throw null;
        } else if (bArr2 == null) {
            throw null;
        } else if (bArr2.length + i > bArr.length) {
            return false;
        } else {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i + i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void initDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        sWindowDisplayMetrics = displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        assertNotNull(windowManager, "WindowManager is null!");
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics2);
        sScreenDisplayMetrics = displayMetrics2;
    }

    public static void initDisplayMetricsIfNotInitialized(Context context) {
        if (sScreenDisplayMetrics == null) {
            initDisplayMetrics(context);
        }
    }

    public static void invokeJniOnload(String str) {
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Unknown library: ", str));
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean isFontScaleAtLeast2_0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static boolean isUndefined(float f2) {
        return Float.compare(f2, Float.NaN) == 0;
    }

    public static boolean isZero(double d2) {
        boolean z = false;
        if (Double.isNaN(d2)) {
            return false;
        }
        if (Math.abs(d2) < 1.0E-5d) {
            z = true;
        }
        return z;
    }

    public static int layer(int i, int i2, float f2) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(((float) Color.alpha(i2)) * f2)), i);
    }

    public static float lerp(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static long make(float f2, float f3) {
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        return ((long) Float.floatToRawIntBits(f3)) | (((long) floatToRawIntBits) << 32);
    }

    /* JADX INFO: finally extract failed */
    public static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) throws JSONException {
        String str3;
        Cursor query = sQLiteDatabase.query("catalystLocalStorage", new String[]{HSLCriteriaBuilder.VALUE}, "key=?", new String[]{str}, null, null, null);
        try {
            if (!query.moveToFirst()) {
                query.close();
                str3 = null;
            } else {
                str3 = query.getString(0);
                query.close();
            }
            if (str3 != null) {
                JSONObject jSONObject = new JSONObject(str3);
                deepMergeInto(jSONObject, new JSONObject(str2));
                str2 = jSONObject.toString();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put(HSLCriteriaBuilder.VALUE, str2);
            if (-1 != sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, contentValues, 5)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int multiplyColorAlpha1(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static void notifyNativeGestureStarted(View view, MotionEvent motionEvent) {
        getRootView(view).onChildStartedNativeGesture(motionEvent);
    }

    public static <K, V> Map<K, V> of(K k, V v) {
        HashMap hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    public static void onRequestError(RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, String str, Throwable th) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i);
        createArray.pushString(str);
        if (th != null && th.getClass() == SocketTimeoutException.class) {
            createArray.pushBoolean(true);
        }
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
        }
    }

    public static void onRequestSuccess(RCTDeviceEventEmitter rCTDeviceEventEmitter, int i) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i);
        createArray.pushNull();
        if (rCTDeviceEventEmitter != null) {
            rCTDeviceEventEmitter.emit("didCompleteNetworkResponse", createArray);
        }
    }

    public static int parseFontStyle(String str) {
        if ("italic".equals(str)) {
            return 2;
        }
        return ConfigZkFeatures.CONFIG_TYPE_NORMAL.equals(str) ? 0 : -1;
    }

    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                char c2 = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    arrayList.add("'smcp'");
                } else if (c2 == 1) {
                    arrayList.add("'onum'");
                } else if (c2 == 2) {
                    arrayList.add("'lnum'");
                } else if (c2 == 3) {
                    arrayList.add("'tnum'");
                } else if (c2 == 4) {
                    arrayList.add("'pnum'");
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static int parseFontWeight(String str) {
        int charAt = (str == null || str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - '0') * 100;
        if (charAt == -1) {
            charAt = 0;
        }
        if (charAt == 700 || "bold".equals(str)) {
            return 1;
        }
        if (charAt == 400 || ConfigZkFeatures.CONFIG_TYPE_NORMAL.equals(str)) {
            return 0;
        }
        return charAt;
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals("always")) {
            return 0;
        }
        if (str.equals("never")) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("wrong overScrollMode: ", str));
    }

    public static Mode parseTintMode(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static List<String> reactArrayToStringList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(readableArray.getString(i));
        }
        return arrayList;
    }

    public static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0) {
            int read = fileChannel.read(byteBuffer, j);
            if (read == -1) {
                break;
            }
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new MinElf$ElfError("ELF file truncated");
    }

    public static int read3Bytes(InputStream inputStream) throws IOException {
        return ((((byte) (inputStream.read() & InvitationReply.EXPIRED)) << GlyfDescript.X_DUAL) & 16711680) | ((((byte) (inputStream.read() & InvitationReply.EXPIRED)) << 8) & 65280) | (((byte) (inputStream.read() & InvitationReply.EXPIRED)) & 255);
    }

    public static int readPackedInt(InputStream inputStream, int i, boolean z) throws IOException {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int read = inputStream.read();
            if (read != -1) {
                if (z) {
                    i2 = (read & InvitationReply.EXPIRED) << (i3 * 8);
                } else {
                    i4 <<= 8;
                    i2 = read & InvitationReply.EXPIRED;
                }
                i4 |= i2;
                i3++;
            } else {
                throw new IOException("no more bytes");
            }
        }
        return i4;
    }

    public static <T> void receiveCommand(ReactScrollViewCommandHelper$ScrollCommandHandler<T> reactScrollViewCommandHelper$ScrollCommandHandler, T t, int i, ReadableArray readableArray) {
        assertNotNull(reactScrollViewCommandHelper$ScrollCommandHandler);
        assertNotNull(t);
        assertNotNull(readableArray);
        if (i == 1) {
            scrollTo(reactScrollViewCommandHelper$ScrollCommandHandler, t, readableArray);
        } else if (i == 2) {
            reactScrollViewCommandHelper$ScrollCommandHandler.scrollToEnd(t, new ReactScrollViewCommandHelper$ScrollToEndCommandData(readableArray.getBoolean(0)));
        } else if (i == 3) {
            reactScrollViewCommandHelper$ScrollCommandHandler.flashScrollIndicators(t);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), reactScrollViewCommandHelper$ScrollCommandHandler.getClass().getSimpleName()}));
        }
    }

    public static void resetIdentityMatrix(double[] dArr) {
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[11] = 0.0d;
        dArr[9] = 0.0d;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[15] = 1.0d;
        dArr[10] = 1.0d;
        dArr[5] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static TypedValue resolve(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        TypedValue resolve = resolve(context, i);
        if (resolve == null || resolve.type != 18) {
            return z;
        }
        return resolve.data != 0;
    }

    public static int resolveOrThrow(Context context, int i, String str) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i)}));
    }

    public static double roundTo3Places(double d2) {
        return ((double) Math.round(d2 * 1000.0d)) * 0.001d;
    }

    public static <T> void scrollTo(ReactScrollViewCommandHelper$ScrollCommandHandler<T> reactScrollViewCommandHelper$ScrollCommandHandler, T t, ReadableArray readableArray) {
        reactScrollViewCommandHelper$ScrollCommandHandler.scrollTo(t, new ReactScrollViewCommandHelper$ScrollToCommandData(Math.round(toPixelFromDIP(readableArray.getDouble(0))), Math.round(toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    public static void setCallbacks(Drawable drawable, Callback callback, TransformCallback transformCallback) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof TransformAwareDrawable) {
                ((TransformAwareDrawable) drawable).setTransformCallback(transformCallback);
            }
        }
    }

    public static void setDrawableProperties(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable != null && drawableProperties != null) {
            int i = drawableProperties.mAlpha;
            if (i != -1) {
                drawable.setAlpha(i);
            }
            if (drawableProperties.mIsSetColorFilter) {
                drawable.setColorFilter(drawableProperties.mColorFilter);
            }
            int i2 = drawableProperties.mDither;
            boolean z = false;
            if (i2 != -1) {
                drawable.setDither(i2 != 0);
            }
            int i3 = drawableProperties.mFilterBitmap;
            if (i3 != -1) {
                if (i3 != 0) {
                    z = true;
                }
                drawable.setFilterBitmap(z);
            }
        }
    }

    public static String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        int i = 0;
        for (String str : set) {
            strArr[i] = str;
            i++;
        }
        return strArr;
    }

    public static boolean startsWithPattern(byte[] bArr, byte[] bArr2) {
        return hasPatternAt(bArr, bArr2, 0);
    }

    public static float toDIPFromPixel(float f2) {
        return f2 / sWindowDisplayMetrics.density;
    }

    public static float[] toFloatArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        float[] fArr = new float[readableArray.size()];
        toFloatArray(readableArray, fArr);
        return fArr;
    }

    public static float toPixelFromDIP(double d2) {
        return toPixelFromDIP((float) d2);
    }

    public static float toPixelFromSP(float f2) {
        return toPixelFromSP(f2, Float.NaN);
    }

    public static float toSPFromPixel(float f2) {
        return f2 / sScreenDisplayMetrics.scaledDensity;
    }

    public static ScalingUtils$ScaleType toScaleType(String str) {
        if ("contain".equals(str)) {
            return ScalingUtils$ScaleType.FIT_CENTER;
        }
        if ("cover".equals(str)) {
            return ScalingUtils$ScaleType.CENTER_CROP;
        }
        if ("stretch".equals(str)) {
            return ScalingUtils$ScaleType.FIT_XY;
        }
        if ("center".equals(str)) {
            return ScalingUtils$ScaleType.CENTER_INSIDE;
        }
        if (ReactVideoViewManager.PROP_REPEAT.equals(str)) {
            return ScaleTypeStartInside.INSTANCE;
        }
        if (str == null) {
            return ScalingUtils$ScaleType.CENTER_CROP;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline52("Invalid resize mode: '", str, "'"));
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static double[] v3Combine(double[] dArr, double[] dArr2, double d2, double d3) {
        return new double[]{(dArr2[0] * d3) + (dArr[0] * d2), (dArr2[1] * d3) + (dArr[1] * d2), (d3 * dArr2[2]) + (d2 * dArr[2])};
    }

    public static double v3Dot(double[] dArr, double[] dArr2) {
        return (dArr[2] * dArr2[2]) + (dArr[1] * dArr2[1]) + (dArr[0] * dArr2[0]);
    }

    public static double v3Length(double[] dArr) {
        return Math.sqrt((dArr[2] * dArr[2]) + (dArr[1] * dArr[1]) + (dArr[0] * dArr[0]));
    }

    public static double[] v3Normalize(double[] dArr, double d2) {
        if (isZero(d2)) {
            d2 = v3Length(dArr);
        }
        double d3 = 1.0d / d2;
        return new double[]{dArr[0] * d3, dArr[1] * d3, dArr[2] * d3};
    }

    public static void validate(GameRequestContent gameRequestContent) {
        Validate.notNull(gameRequestContent.message, "message");
        int i = 0;
        boolean z = gameRequestContent.objectId != null;
        ActionType actionType = gameRequestContent.actionType;
        if (!(z ^ (actionType == ActionType.ASKFOR || actionType == ActionType.SEND))) {
            if (gameRequestContent.recipients != null) {
                i = 1;
            }
            if (gameRequestContent.suggestions != null) {
                i++;
            }
            if (gameRequestContent.filters != null) {
                i++;
            }
            if (i > 1) {
                throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
            }
            return;
        }
        throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
    }

    public static Object zza(Bundle bundle, String str, Class cls, Object obj) {
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return obj2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[]{str, cls.getCanonicalName(), obj2.getClass().getCanonicalName()}));
    }

    public static int zza1(int i) {
        int[] iArr = {1, 2, 3};
        int i2 = 0;
        while (i2 < 3) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            } else if (i4 == i) {
                return i3;
            } else {
                i2++;
            }
        }
        return 1;
    }

    public static int zza2(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i2 = 0;
        while (i2 < 6) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            } else if (i4 == i) {
                return i3;
            } else {
                i2++;
            }
        }
        return 1;
    }

    public static void zzb(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(HSLCriteriaBuilder.VALUE, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(HSLCriteriaBuilder.VALUE, ((Long) obj).longValue());
        } else {
            bundle.putString(HSLCriteriaBuilder.VALUE, obj.toString());
        }
    }

    public static void assertCondition(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static <T> T assertNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new AssertionError(str);
    }

    public static UIManager getUIManager(ReactContext reactContext, int i, boolean z) {
        UIManager uIManager;
        if (reactContext.isBridgeless()) {
            return (UIManager) reactContext.getJSIModule(JSIModuleType.UIManager);
        }
        if (!reactContext.hasCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException((String) "Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        }
        if (!reactContext.hasActiveCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException((String) "Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
            if (z) {
                return null;
            }
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (i == 2) {
            uIManager = (UIManager) catalystInstance.getJSIModule(JSIModuleType.UIManager);
        } else {
            uIManager = (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
        }
        return uIManager;
    }

    public static float toPixelFromDIP(float f2) {
        return TypedValue.applyDimension(1, f2, sWindowDisplayMetrics);
    }

    public static float toPixelFromSP(float f2, float f3) {
        DisplayMetrics displayMetrics = sWindowDisplayMetrics;
        float f4 = displayMetrics.scaledDensity;
        float f5 = displayMetrics.density;
        float f6 = f4 / f5;
        if (f3 >= 1.0f && f3 < f6) {
            f4 = f5 * f3;
        }
        return f2 * f4;
    }

    public static int getColor(Context context, int i, int i2) {
        TypedValue resolve = resolve(context, i);
        return resolve != null ? resolve.data : i2;
    }

    public static long make(int i, int i2) {
        return make((float) i, (float) i2);
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2) {
        HashMap hashMap = new HashMap();
        hashMap.put(k, v);
        hashMap.put(k2, v2);
        return hashMap;
    }

    public static int toFloatArray(ReadableArray readableArray, float[] fArr) {
        int length = readableArray.size() > fArr.length ? fArr.length : readableArray.size();
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        return readableArray.size();
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray tintTypedArray, int i) {
        if (tintTypedArray.mWrapped.hasValue(i)) {
            int resourceId = tintTypedArray.mWrapped.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, resourceId);
                if (colorStateList != null) {
                    return colorStateList;
                }
            }
        }
        return tintTypedArray.getColorStateList(i);
    }

    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        HashMap hashMap = new HashMap();
        hashMap.put(k, v);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        return hashMap;
    }

    public static void zzb(zzey zzey, SQLiteDatabase sQLiteDatabase) {
        if (zzey != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzey.zzg.zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzey.zzg.zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzey.zzg.zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzey.zzg.zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (r0 == false) goto L_0x0040;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a A[Catch:{ all -> 0x00cf, SQLiteException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6 A[Catch:{ all -> 0x00cf, SQLiteException -> 0x00d4 }, LOOP:1: B:31:0x00a6->B:36:0x00b8, LOOP_START, PHI: r14 
      PHI: (r14v1 int) = (r14v0 int), (r14v2 int) binds: [B:30:0x00a4, B:36:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1 A[Catch:{ all -> 0x00cf, SQLiteException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.measurement.internal.zzey r15, android.database.sqlite.SQLiteDatabase r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String[] r20) throws android.database.sqlite.SQLiteException {
        /*
            r1 = r15
            r10 = r16
            r11 = r17
            r12 = r20
            if (r1 == 0) goto L_0x00e5
            r13 = 0
            r14 = 0
            java.lang.String r0 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r6[r14] = r11     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r5 = "name=?"
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r16
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x002d }
            r2.close()
            if (r0 != 0) goto L_0x0045
            goto L_0x0040
        L_0x002d:
            r0 = move-exception
            goto L_0x0034
        L_0x002f:
            r0 = move-exception
            goto L_0x00df
        L_0x0032:
            r0 = move-exception
            r2 = r13
        L_0x0034:
            com.google.android.gms.measurement.internal.zzew r3 = r1.zzg     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = "Error querying for table"
            r3.zzc(r4, r11, r0)     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            r2 = r18
            r10.execSQL(r2)
        L_0x0045:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00d4 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d4 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00d4 }
            r2.append(r11)     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r3 = " LIMIT 0"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x00d4 }
            android.database.Cursor r2 = r10.rawQuery(r2, r13)     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String[] r3 = r2.getColumnNames()     // Catch:{ all -> 0x00cf }
            java.util.Collections.addAll(r0, r3)     // Catch:{ all -> 0x00cf }
            r2.close()     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r2 = ","
            r3 = r19
            java.lang.String[] r2 = r3.split(r2)     // Catch:{ SQLiteException -> 0x00d4 }
            int r3 = r2.length     // Catch:{ SQLiteException -> 0x00d4 }
            r4 = 0
        L_0x0078:
            if (r4 >= r3) goto L_0x00a4
            r5 = r2[r4]     // Catch:{ SQLiteException -> 0x00d4 }
            boolean r6 = r0.remove(r5)     // Catch:{ SQLiteException -> 0x00d4 }
            if (r6 == 0) goto L_0x0085
            int r4 = r4 + 1
            goto L_0x0078
        L_0x0085:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d4 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r3 = "Table "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00d4 }
            r2.append(r11)     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r3 = " is missing required column: "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00d4 }
            r2.append(r5)     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x00d4 }
            r0.<init>(r2)     // Catch:{ SQLiteException -> 0x00d4 }
            throw r0     // Catch:{ SQLiteException -> 0x00d4 }
        L_0x00a4:
            if (r12 == 0) goto L_0x00bb
        L_0x00a6:
            int r2 = r12.length     // Catch:{ SQLiteException -> 0x00d4 }
            if (r14 >= r2) goto L_0x00bb
            r2 = r12[r14]     // Catch:{ SQLiteException -> 0x00d4 }
            boolean r2 = r0.remove(r2)     // Catch:{ SQLiteException -> 0x00d4 }
            if (r2 != 0) goto L_0x00b8
            int r2 = r14 + 1
            r2 = r12[r2]     // Catch:{ SQLiteException -> 0x00d4 }
            r10.execSQL(r2)     // Catch:{ SQLiteException -> 0x00d4 }
        L_0x00b8:
            int r14 = r14 + 2
            goto L_0x00a6
        L_0x00bb:
            boolean r2 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzew r2 = r1.zzg     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r3 = "Table has extra columns. table, columns"
            java.lang.String r4 = ", "
            java.lang.String r0 = android.text.TextUtils.join(r4, r0)     // Catch:{ SQLiteException -> 0x00d4 }
            r2.zzc(r3, r11, r0)     // Catch:{ SQLiteException -> 0x00d4 }
        L_0x00ce:
            return
        L_0x00cf:
            r0 = move-exception
            r2.close()     // Catch:{ SQLiteException -> 0x00d4 }
            throw r0     // Catch:{ SQLiteException -> 0x00d4 }
        L_0x00d4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "Failed to verify columns on table that was just created"
            r1.zzb(r2, r11)
            throw r0
        L_0x00dd:
            r0 = move-exception
            r13 = r2
        L_0x00df:
            if (r13 == 0) goto L_0x00e4
            r13.close()
        L_0x00e4:
            throw r0
        L_0x00e5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Monitor must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza(com.google.android.gms.measurement.internal.zzey, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap hashMap = new HashMap();
        hashMap.put(k, v);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        hashMap.put(k4, v4);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void receiveCommand(com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollCommandHandler<T> r5, T r6, java.lang.String r7, com.facebook.react.bridge.ReadableArray r8) {
        /*
            assertNotNull(r5)
            assertNotNull(r6)
            assertNotNull(r8)
            int r0 = r7.hashCode()
            r1 = 1
            r2 = 2
            r3 = 0
            r4 = -402165208(0xffffffffe8077228, float:-2.5585011E24)
            if (r0 == r4) goto L_0x0034
            r4 = 28425985(0x1b1bf01, float:6.529361E-38)
            if (r0 == r4) goto L_0x002a
            r4 = 2055114131(0x7a7e8d93, float:3.3042872E35)
            if (r0 == r4) goto L_0x0020
            goto L_0x003e
        L_0x0020:
            java.lang.String r0 = "scrollToEnd"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "flashScrollIndicators"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "scrollTo"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x0070
            if (r0 == r1) goto L_0x0063
            if (r0 != r2) goto L_0x0049
            r5.flashScrollIndicators(r6)
            return
        L_0x0049:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r3] = r7
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r8[r1] = r5
            java.lang.String r5 = "Unsupported command %s received by %s."
            java.lang.String r5 = java.lang.String.format(r5, r8)
            r6.<init>(r5)
            throw r6
        L_0x0063:
            boolean r7 = r8.getBoolean(r3)
            com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToEndCommandData r8 = new com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToEndCommandData
            r8.<init>(r7)
            r5.scrollToEnd(r6, r8)
            return
        L_0x0070:
            scrollTo(r5, r6, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.receiveCommand(com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollCommandHandler, java.lang.Object, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
