package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.bridge.PromiseImpl;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.paynimo.android.payment.util.Constant;
import com.razorpay.AnalyticsConstants;
import com.squareup.picasso.NetworkRequestHandler;
import in.juspay.hypersdk.core.InflateView;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Î\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J'\u00102\u001a\u00020 \"\u0004\b\u0000\u001032\b\u00104\u001a\u0004\u0018\u0001H32\b\u00105\u001a\u0004\u0018\u0001H3H\u0007¢\u0006\u0002\u00106J\u0012\u00107\u001a\u0004\u0018\u00010\u001a2\u0006\u00108\u001a\u00020\u0004H\u0007J&\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u0018\u0010?\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0007J\u0012\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001e\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040L2\u0006\u0010M\u001a\u00020NH\u0007J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010P2\u0006\u0010Q\u001a\u00020\u001aH\u0007J\u001c\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040P2\u0006\u0010Q\u001a\u00020\u001aH\u0007J\u001a\u0010S\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020WH\u0007J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0007J\b\u0010[\u001a\u00020 H\u0002J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0006H\u0007J\u0012\u0010^\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0007J\u0010\u0010_\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0007J\n\u0010`\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020bH\u0007J\u0010\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020:H\u0007J\n\u0010h\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010i\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010k\u001a\u00020l2\u0006\u00108\u001a\u00020\u0004H\u0002J\u0018\u0010m\u001a\u00020*2\u0006\u00108\u001a\u00020\u00042\u0006\u0010n\u001a\u00020oH\u0007J\u0012\u0010p\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0007JC\u0010q\u001a\u0004\u0018\u00010r2\n\u0010s\u001a\u0006\u0012\u0002\b\u00030t2\u0006\u0010u\u001a\u00020\u00042\u001e\u0010v\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010t0w\"\b\u0012\u0002\b\u0003\u0018\u00010tH\u0007¢\u0006\u0002\u0010xJ?\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010y\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u00042\u001e\u0010v\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010t0w\"\b\u0012\u0002\b\u0003\u0018\u00010tH\u0007¢\u0006\u0002\u0010zJ\u0012\u0010{\u001a\u00020\u00042\b\u0010|\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010}\u001a\u0004\u0018\u00010\u00012\u0006\u0010Q\u001a\u00020\u001a2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010~\u001a\u0004\u0018\u00010\u0004H\u0007J\u0015\u0010\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010I\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010I\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0004H\u0002J>\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020r2\u0017\u0010\u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010w\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0015\u0010\u0001\u001a\u00020 2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0011\u0010\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0002J\u0013\u0010\u0001\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010\u0001\u001a\u00020 2\u000e\u0010\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0007J\u0014\u0010\u0001\u001a\u00020 2\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J\u0018\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010M\u001a\u00020NH\u0007J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040L2\u0006\u0010M\u001a\u00020NH\u0007J\u001e\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040P2\u0007\u0010\u0001\u001a\u00020\u0004H\u0007J'\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010\u0001\u001a\f\u0018\u00010 \u0001j\u0005\u0018\u0001`¡\u0001H\u0007J\u001f\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0007J\"\u0010¥\u0001\u001a\u00020\u00042\u0017\u0010¦\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040PH\u0007J\u0013\u0010§\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010d\u001a\u00020\u0004H\u0007J\u0011\u0010¨\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0014\u0010©\u0001\u001a\u00020>2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010«\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\u0011\u0010¬\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010LH\u0007J&\u0010­\u0001\u001a\u00020 2\u0006\u0010c\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010¯\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010°\u0001\u001a\u00020*2\u0006\u00105\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010:H\u0007J!\u0010±\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010P2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\u0013\u0010´\u0001\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010UH\u0007J%\u0010µ\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010P2\b\u0010²\u0001\u001a\u00030³\u0001H\u0007J\t\u0010¶\u0001\u001a\u00020*H\u0002J\t\u0010·\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010¸\u0001\u001a\u00020*2\u0007\u0010¹\u0001\u001a\u000200H\u0002J\u0012\u0010º\u0001\u001a\u00020*2\u0007\u0010¹\u0001\u001a\u000200H\u0002J\t\u0010»\u0001\u001a\u00020*H\u0002J\t\u0010¼\u0001\u001a\u00020*H\u0002J\u0015\u0010½\u0001\u001a\u00020*2\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0007J\u001f\u0010À\u0001\u001a\u00020\u00042\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010Ã\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0007\u0010Ä\u0001\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u001a\u0010Å\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001a2\u0007\u0010¹\u0001\u001a\u000200H\u0007J\u0014\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010I\u001a\u00030\u0001H\u0007J\u0013\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010d\u001a\u00020\u0004H\u0007J\u0016\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010I\u001a\u0005\u0018\u00010\u0001H\u0007J\u0015\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010d\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010È\u0001\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010É\u0001\u001a\u0004\u0018\u00010N2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J*\u0010Ì\u0001\u001a\u00020*2\b\u0010²\u0001\u001a\u00030³\u00012\u0015\u0010¦\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010PH\u0007J.\u0010Í\u0001\u001a\u00020*2\b\u0010²\u0001\u001a\u00030³\u00012\u0019\u0010¦\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010PH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 8FX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\u001f\u0010\"R\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u00168G¢\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006Ï\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "appendAnonIdUnderCompliance", "", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "context", "Landroid/content/Context;", "appendAttributionIdUnderCompliance", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCookiesForDomain", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", "key", "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", "graphDomain", "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", "uri", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashWithAlgorithm", "algorithm", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isGooglePlayServicesAvailable", "isNullOrEmpty", "c", "", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "mapToJsonStr", "map", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readNonnullStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "readStreamToString", "readStringMapFromParcel", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "writeNonnullStringMapToParcel", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Utility.kt */
public final class Utility {
    public static long availableExternalStorageGB = -1;
    public static String carrierName = "NoCarrier";
    public static String deviceTimeZoneName = "";
    public static String deviceTimezoneAbbreviation = "";
    public static int numCPUCores = 0;
    public static long timestampOfLastCheck = -1;
    public static long totalExternalStorageGB = -1;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Utility.kt */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public static final <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return Intrinsics.areEqual(t, t2);
    }

    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme(NetworkRequestHandler.SCHEME_HTTPS);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array = CharsKt__CharKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str2 = strArr[i];
                    i++;
                    Object[] array2 = CharsKt__CharKt.split$default((CharSequence) str2, new String[]{InflateView.SETTER_EQUALS}, false, 0, 6).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length > 0) {
                            String str3 = strArr2[0];
                            int length2 = str3.length() - 1;
                            int i2 = 0;
                            boolean z = false;
                            while (i2 <= length2) {
                                boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i2 : length2), 32) <= 0;
                                if (!z) {
                                    if (!z2) {
                                        z = true;
                                    } else {
                                        i2++;
                                    }
                                } else if (!z2) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            instance.setCookie(str, Intrinsics.stringPlus(str3.subSequence(i2, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            clearCookiesForDomain(context, "facebook.com");
            clearCookiesForDomain(context, ".facebook.com");
            clearCookiesForDomain(context, "https://facebook.com");
            clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public static final List<String> convertJSONArrayToList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            while (true) {
                int i2 = i + 1;
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i2 >= length) {
                    return arrayList;
                }
                i = i2;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        if (names == null) {
            return hashMap;
        }
        int i = 0;
        int length = names.length();
        if (length > 0) {
            while (true) {
                int i2 = i + 1;
                try {
                    String string = names.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, HSLCriteriaBuilder.VALUE);
                    hashMap.put(string, obj);
                } catch (JSONException unused) {
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashMap;
    }

    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002a }
            r1.<init>(r6)     // Catch:{ all -> 0x002a }
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0027 }
            r2 = 0
            r3 = 0
        L_0x0011:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0027 }
            r5 = -1
            if (r4 == r5) goto L_0x001d
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0027 }
            int r3 = r3 + r4
            goto L_0x0011
        L_0x001d:
            r1.close()
            if (r6 != 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r6.close()
        L_0x0026:
            return r3
        L_0x0027:
            r7 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r7 = move-exception
        L_0x002b:
            if (r0 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r0.close()
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r6.close()
        L_0x0037:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    public static final String getAppName(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Validate.sdkInitialized();
            String str2 = FacebookSdk.applicationName;
            if (str2 != null) {
                return str2;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                str = applicationInfo.nonLocalizedLabel.toString();
            } else {
                str = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(stringId)");
            }
            return str;
        } catch (Exception unused) {
            str = "";
        }
    }

    public static final String getAppVersion() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j;
        Date date2;
        Intrinsics.checkNotNullParameter(date, "dateBase");
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j == 0) {
            date2 = new Date(Long.MAX_VALUE);
        } else {
            date2 = new Date((j * 1000) + date.getTime());
        }
        return date2;
    }

    public static final JSONObject getDataProcessingOptions() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String string = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void getGraphMeRequestWithCacheAsync(java.lang.String r3, com.facebook.internal.Utility.GraphMeRequestWithCacheCallback r4) {
        /*
            java.lang.String r0 = "accessToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r1 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            com.facebook.internal.ProfileInformationCache r1 = com.facebook.internal.ProfileInformationCache.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.json.JSONObject> r0 = com.facebook.internal.ProfileInformationCache.infoCache
            java.lang.Object r0 = r0.get(r3)
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            if (r0 == 0) goto L_0x001d
            r4.onSuccess(r0)
            return
        L_0x001d:
            com.facebook.internal.-$$Lambda$SiJuQsWBfR6TkJ4AVljhxBXsqfM r0 = new com.facebook.internal.-$$Lambda$SiJuQsWBfR6TkJ4AVljhxBXsqfM
            r0.<init>(r3)
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            com.facebook.AccessToken$Companion r1 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r1 = com.facebook.AccessToken.Companion.getCurrentAccessToken()
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r1.graphDomain
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            java.lang.String r1 = "facebook"
        L_0x0036:
            java.lang.String r2 = "instagram"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = "id,name,profile_picture"
            goto L_0x0043
        L_0x0041:
            java.lang.String r1 = "id,name,first_name,middle_name,last_name"
        L_0x0043:
            java.lang.String r2 = "fields"
            r4.putString(r2, r1)
            java.lang.String r1 = "access_token"
            r4.putString(r1, r3)
            com.facebook.GraphRequest$Companion r3 = com.facebook.GraphRequest.Companion
            r1 = 0
            com.facebook.GraphRequest r3 = r3.newMeRequest(r1, r1)
            r3.setParameters(r4)
            com.facebook.HttpMethod r4 = com.facebook.HttpMethod.GET
            r3.setHttpMethod(r4)
            r3.setCallback(r0)
            r3.executeAsync()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.getGraphMeRequestWithCacheAsync(java.lang.String, com.facebook.internal.Utility$GraphMeRequestWithCacheCallback):void");
    }

    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3  reason: not valid java name */
    public static final void m205getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "$callback");
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        FacebookRequestError facebookRequestError = graphResponse.error;
        if (facebookRequestError != null) {
            graphMeRequestWithCacheCallback.onFailure(facebookRequestError.exception);
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jSONObject = graphResponse.jsonObject;
        if (jSONObject != null) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(jSONObject, HSLCriteriaBuilder.VALUE);
            ProfileInformationCache.infoCache.put(str, jSONObject);
            graphMeRequestWithCacheCallback.onSuccess(graphResponse.jsonObject);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationId();
    }

    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, PromiseImpl.STACK_FRAME_KEY_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Locale getResourceLocale() {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException((String) "Got an unexpected non-JSON object.");
    }

    public static final String hashWithAlgorithm(String str, String str2) {
        byte[] bytes = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(str, bytes);
    }

    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Intrinsics.checkNotNullParameter(method, AnalyticsConstants.METHOD);
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (Intrinsics.areEqual(packageName, resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
            if (new Regex((String) ".+_cheets|cheets_.+").matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isContentUri(Uri uri) {
        return CharsKt__CharKt.equals((String) "content", uri.getScheme(), true);
    }

    public static final boolean isDataProcessingRestricted() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray("data_processing_options");
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (Intrinsics.areEqual(lowerCase, "ldu")) {
                            return true;
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean isFileUri(Uri uri) {
        return CharsKt__CharKt.equals((String) "file", uri.getScheme(), true);
    }

    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final boolean isWebUri(Uri uri) {
        if (uri == null || (!CharsKt__CharKt.equals((String) NetworkRequestHandler.SCHEME_HTTP, uri.getScheme(), true) && !CharsKt__CharKt.equals((String) NetworkRequestHandler.SCHEME_HTTPS, uri.getScheme(), true) && !CharsKt__CharKt.equals((String) "fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    public static final List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayList.add(jSONArray.getString(i));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public static final Map<String, String> jsonStrToMap(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void logd(String str, Exception exc) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isDebugEnabledField && str != null) {
            exc.getClass().getSimpleName();
            exc.getMessage();
        }
    }

    public static final String mapToJsonStr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), (String) next.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    public static final String md5hash(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return hashWithAlgorithm((String) "MD5", str);
    }

    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = CharsKt__CharKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArr[i];
                        i++;
                        Object[] array2 = CharsKt__CharKt.split$default((CharSequence) str2, new String[]{InflateView.SETTER_EQUALS}, false, 0, 6).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e2) {
                                logd("FacebookSDK", e2);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bundle, com.mpl.androidapp.utils.Constant.BUNDLE_DIR_NAME);
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else {
            bundle.putString(str, ((JSONArray) obj).toString());
        }
        return true;
    }

    public static final void putNonEmptyString(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static final void putUri(Bundle bundle, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static final Map<String, String> readNonnullStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        if (readInt > 0) {
            do {
                i++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (!(readString == null || readString2 == null)) {
                    hashMap.put(readString, readString2);
                    continue;
                }
            } while (i < readInt);
        }
        return hashMap;
    }

    public static final String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4  reason: not valid java name */
    public static final boolean m206refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00b1 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0188 A[SYNTHETIC, Splitter:B:62:0x0188] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setAppEventExtendedDeviceInfoParameters(org.json.JSONObject r10, android.content.Context r11) throws org.json.JSONException {
        /*
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "appContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String r1 = "a2"
            r0.put(r1)
            java.lang.String r1 = "mounted"
            long r2 = timestampOfLastCheck
            r4 = 0
            r5 = -1
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x002d
            long r2 = java.lang.System.currentTimeMillis()
            long r5 = timestampOfLastCheck
            long r2 = r2 - r5
            r5 = 1800000(0x1b7740, double:8.89318E-318)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x00e0
        L_0x002d:
            long r2 = java.lang.System.currentTimeMillis()
            timestampOfLastCheck = r2
            java.util.TimeZone r2 = java.util.TimeZone.getDefault()     // Catch:{ AssertionError | Exception -> 0x0057 }
            java.util.Date r3 = new java.util.Date     // Catch:{ AssertionError | Exception -> 0x0057 }
            r3.<init>()     // Catch:{ AssertionError | Exception -> 0x0057 }
            boolean r3 = r2.inDaylightTime(r3)     // Catch:{ AssertionError | Exception -> 0x0057 }
            java.lang.String r3 = r2.getDisplayName(r3, r4)     // Catch:{ AssertionError | Exception -> 0x0057 }
            java.lang.String r5 = "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ AssertionError | Exception -> 0x0057 }
            deviceTimezoneAbbreviation = r3     // Catch:{ AssertionError | Exception -> 0x0057 }
            java.lang.String r2 = r2.getID()     // Catch:{ AssertionError | Exception -> 0x0057 }
            java.lang.String r3 = "tz.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ AssertionError | Exception -> 0x0057 }
            deviceTimeZoneName = r2     // Catch:{ AssertionError | Exception -> 0x0057 }
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            java.lang.String r2 = carrierName
            java.lang.String r3 = "NoCarrier"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L_0x0080
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r11.getSystemService(r2)     // Catch:{ Exception -> 0x0080 }
            if (r2 == 0) goto L_0x0078
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x0080 }
            java.lang.String r2 = r2.getNetworkOperatorName()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = "telephonyManager.networkOperatorName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0080 }
            carrierName = r2     // Catch:{ Exception -> 0x0080 }
            goto L_0x0080
        L_0x0078:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0080 }
            throw r2     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            r2 = 4742290407621132288(0x41d0000000000000, double:1.073741824E9)
            java.lang.String r5 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00b1 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)     // Catch:{ Exception -> 0x00b1 }
            if (r5 == 0) goto L_0x00a7
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00b1 }
            android.os.StatFs r6 = new android.os.StatFs     // Catch:{ Exception -> 0x00b1 }
            java.lang.String r5 = r5.getPath()     // Catch:{ Exception -> 0x00b1 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00b1 }
            int r5 = r6.getBlockCount()     // Catch:{ Exception -> 0x00b1 }
            long r7 = (long) r5     // Catch:{ Exception -> 0x00b1 }
            int r5 = r6.getBlockSize()     // Catch:{ Exception -> 0x00b1 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x00b1 }
            long r7 = r7 * r5
            totalExternalStorageGB = r7     // Catch:{ Exception -> 0x00b1 }
        L_0x00a7:
            long r5 = totalExternalStorageGB     // Catch:{ Exception -> 0x00b1 }
            double r5 = (double) r5     // Catch:{ Exception -> 0x00b1 }
            double r5 = r5 / r2
            long r5 = java.lang.Math.round(r5)     // Catch:{ Exception -> 0x00b1 }
            totalExternalStorageGB = r5     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            java.lang.String r5 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00e0 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)     // Catch:{ Exception -> 0x00e0 }
            if (r1 == 0) goto L_0x00d6
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00e0 }
            android.os.StatFs r5 = new android.os.StatFs     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x00e0 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x00e0 }
            int r1 = r5.getAvailableBlocks()     // Catch:{ Exception -> 0x00e0 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x00e0 }
            int r1 = r5.getBlockSize()     // Catch:{ Exception -> 0x00e0 }
            long r8 = (long) r1     // Catch:{ Exception -> 0x00e0 }
            long r6 = r6 * r8
            availableExternalStorageGB = r6     // Catch:{ Exception -> 0x00e0 }
        L_0x00d6:
            long r5 = availableExternalStorageGB     // Catch:{ Exception -> 0x00e0 }
            double r5 = (double) r5     // Catch:{ Exception -> 0x00e0 }
            double r5 = r5 / r2
            long r1 = java.lang.Math.round(r5)     // Catch:{ Exception -> 0x00e0 }
            availableExternalStorageGB = r1     // Catch:{ Exception -> 0x00e0 }
        L_0x00e0:
            java.lang.String r1 = r11.getPackageName()
            r2 = -1
            android.content.pm.PackageManager r3 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00f5 }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r1, r4)     // Catch:{ NameNotFoundException -> 0x00f5 }
            if (r3 != 0) goto L_0x00f0
            return
        L_0x00f0:
            int r2 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x00f5 }
            java.lang.String r3 = r3.versionName     // Catch:{ NameNotFoundException -> 0x00f5 }
            goto L_0x00f7
        L_0x00f5:
            java.lang.String r3 = ""
        L_0x00f7:
            r0.put(r1)
            r0.put(r2)
            r0.put(r3)
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            r0.put(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r0.put(r1)
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ Exception -> 0x0115 }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ Exception -> 0x0115 }
            java.util.Locale r1 = r1.locale     // Catch:{ Exception -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            java.util.Locale r1 = java.util.Locale.getDefault()
        L_0x0119:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.getLanguage()
            r2.append(r3)
            r3 = 95
            r2.append(r3)
            java.lang.String r1 = r1.getCountry()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.put(r1)
            java.lang.String r1 = deviceTimezoneAbbreviation
            r0.put(r1)
            java.lang.String r1 = carrierName
            r0.put(r1)
            r1 = 0
            java.lang.String r3 = "display"
            java.lang.Object r11 = r11.getSystemService(r3)     // Catch:{ Exception -> 0x016e }
            boolean r3 = r11 instanceof android.hardware.display.DisplayManager     // Catch:{ Exception -> 0x016e }
            r5 = 0
            if (r3 == 0) goto L_0x0152
            android.hardware.display.DisplayManager r11 = (android.hardware.display.DisplayManager) r11     // Catch:{ Exception -> 0x016e }
            goto L_0x0153
        L_0x0152:
            r11 = r5
        L_0x0153:
            if (r11 != 0) goto L_0x0156
            goto L_0x015a
        L_0x0156:
            android.view.Display r5 = r11.getDisplay(r4)     // Catch:{ Exception -> 0x016e }
        L_0x015a:
            if (r5 == 0) goto L_0x016e
            android.util.DisplayMetrics r11 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x016e }
            r11.<init>()     // Catch:{ Exception -> 0x016e }
            r5.getMetrics(r11)     // Catch:{ Exception -> 0x016e }
            int r3 = r11.widthPixels     // Catch:{ Exception -> 0x016e }
            int r4 = r11.heightPixels     // Catch:{ Exception -> 0x016c }
            float r11 = r11.density     // Catch:{ Exception -> 0x016c }
            double r1 = (double) r11
            goto L_0x016f
        L_0x016c:
            goto L_0x016f
        L_0x016e:
            r3 = 0
        L_0x016f:
            r0.put(r3)
            r0.put(r4)
            java.text.DecimalFormat r11 = new java.text.DecimalFormat
            java.lang.String r3 = "#.##"
            r11.<init>(r3)
            java.lang.String r11 = r11.format(r1)
            r0.put(r11)
            int r11 = numCPUCores
            if (r11 <= 0) goto L_0x0188
            goto L_0x01b1
        L_0x0188:
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x019b }
            java.lang.String r1 = "/sys/devices/system/cpu/"
            r11.<init>(r1)     // Catch:{ Exception -> 0x019b }
            com.facebook.internal.-$$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I r1 = com.facebook.internal.$$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I.INSTANCE     // Catch:{ Exception -> 0x019b }
            java.io.File[] r11 = r11.listFiles(r1)     // Catch:{ Exception -> 0x019b }
            if (r11 == 0) goto L_0x019c
            int r11 = r11.length     // Catch:{ Exception -> 0x019b }
            numCPUCores = r11     // Catch:{ Exception -> 0x019b }
            goto L_0x019c
        L_0x019b:
        L_0x019c:
            int r11 = numCPUCores
            if (r11 > 0) goto L_0x01af
            java.lang.Runtime r11 = java.lang.Runtime.getRuntime()
            int r11 = r11.availableProcessors()
            r1 = 1
            int r11 = java.lang.Math.max(r11, r1)
            numCPUCores = r11
        L_0x01af:
            int r11 = numCPUCores
        L_0x01b1:
            r0.put(r11)
            long r1 = totalExternalStorageGB
            r0.put(r1)
            long r1 = availableExternalStorageGB
            r0.put(r1)
            java.lang.String r11 = deviceTimeZoneName
            r0.put(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r0 = "extinfo"
            r10.put(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.setAppEventExtendedDeviceInfoParameters(org.json.JSONObject, android.content.Context):void");
    }

    public static final String sha1hash(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        try {
            MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
            Intrinsics.checkNotNullExpressionValue(instance, Response.HASH);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(digest, "digest");
            int length = digest.length;
            int i = 0;
            while (i < length) {
                byte b2 = digest[i];
                i++;
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString((b2 >> 0) & 15));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return hashWithAlgorithm((String) "SHA-256", str);
    }

    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, PromiseImpl.STACK_FRAME_KEY_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(instance, Response.HASH);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(digest, "digest");
            int length = digest.length;
            int i = 0;
            while (i < length) {
                byte b2 = digest[i];
                i++;
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString((b2 >> 0) & 15));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
            return sb2;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final boolean isNullOrEmpty(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    public static final void logd(String str, String str2, Throwable th) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isDebugEnabledField) {
            boolean isNullOrEmpty = isNullOrEmpty(str);
        }
    }
}
