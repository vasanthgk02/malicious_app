package androidx.core.widget;

import a.a.a.a.d.b;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.icu.text.DecimalFormatSymbols;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Trace;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.util.Size;
import android.util.TypedValue;
import android.view.ActionMode.Callback;
import android.view.InflateException;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.datastore.preferences.core.Preferences.Key;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.lifecycle.CloseableCoroutineScope;
import androidx.lifecycle.ViewModel;
import androidx.multidex.ZipUtil$CentralDirectory;
import androidx.navigation.NavController;
import androidx.navigation.R$id;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.room.RoomDatabase;
import androidx.room.util.TableInfo.ForeignKeyWithSequence;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator$LAZY_COMPAT_CONVERTER_HOLDER;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkInfo$State;
import androidx.work.WorkManager;
import c.c;
import co.hyperverge.hvcamera.magicfilter.utils.c$a;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.razorpay.AnalyticsConstants;
import com.squareup.picasso.NetworkRequestHandler;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipException;
import kotlin.Result.Failure;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import okio.Utf8;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import timber.log.Timber;

public final class CompoundButtonCompat {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f956a;

    /* renamed from: b  reason: collision with root package name */
    public static c f957b;

    /* renamed from: c  reason: collision with root package name */
    public static WorkManager f958c;
    public static Field sButtonDrawableField;
    public static boolean sButtonDrawableFieldFetched;
    public static Method sInorderBarrierMethod;
    public static Method sIsTagEnabledMethod;
    public static boolean sOrderMethodsFetched;
    public static Field sOverlapAnchorField;
    public static boolean sOverlapAnchorFieldAttempted;
    public static Method sReorderBarrierMethod;
    public static Method sSetWindowLayoutTypeMethod;
    public static boolean sSetWindowLayoutTypeMethodAttempted;
    public static long sTraceTagApp;

    public static int a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        byte b2 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return b2;
            }
            b2 = (bArr[i] & 255) | (b2 << 8);
            i += i3;
            i2 = i4;
        }
    }

    public static void access$1000(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (!isNotTrailingByte(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !isNotTrailingByte(b4) && !isNotTrailingByte(b5)) {
                byte b6 = ((b2 & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((b4 & Utf8.REPLACEMENT_BYTE) << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((b6 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((b6 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public static boolean access$400(byte b2) {
        return b2 >= 0;
    }

    public static void access$700(byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (b2 < -62 || isNotTrailingByte(b3)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    public static void access$900(byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (isNotTrailingByte(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || isNotTrailingByte(b4)))) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        cArr[i] = (char) (((b2 & 15) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE));
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        boolean z = true;
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (!(bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1)) {
                z = false;
            }
            return z;
        } else if (bundle2 == null) {
            if (!(bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1)) {
                z = false;
            }
            return z;
        } else {
            if (!(bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1))) {
                z = false;
            }
            return z;
        }
    }

    public static String b(String str) {
        return f957b.a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r10.right <= r12.left) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r10.left >= r12.right) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean beamBeats(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = beamsOverlap(r9, r10, r11)
            boolean r1 = beamsOverlap(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L_0x007d
            if (r0 != 0) goto L_0x000f
            goto L_0x007d
        L_0x000f:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L_0x003d
            if (r9 == r3) goto L_0x0036
            if (r9 == r4) goto L_0x002f
            if (r9 != r1) goto L_0x0029
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L_0x0045
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L_0x002f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L_0x0045
            goto L_0x0043
        L_0x0036:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L_0x0045
            goto L_0x0043
        L_0x003d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L_0x0045
        L_0x0043:
            r7 = 1
            goto L_0x0046
        L_0x0045:
            r7 = 0
        L_0x0046:
            if (r7 != 0) goto L_0x0049
            return r6
        L_0x0049:
            if (r9 == r5) goto L_0x007c
            if (r9 != r4) goto L_0x004e
            goto L_0x007c
        L_0x004e:
            int r11 = majorAxisDistance(r9, r10, r11)
            if (r9 == r5) goto L_0x006f
            if (r9 == r3) goto L_0x006a
            if (r9 == r4) goto L_0x0065
            if (r9 != r1) goto L_0x005f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L_0x0073
        L_0x005f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L_0x0065:
            int r9 = r12.right
            int r10 = r10.right
            goto L_0x0073
        L_0x006a:
            int r9 = r10.top
            int r10 = r12.top
            goto L_0x0073
        L_0x006f:
            int r9 = r10.left
            int r10 = r12.left
        L_0x0073:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L_0x007b
            r2 = 1
        L_0x007b:
            return r2
        L_0x007c:
            return r6
        L_0x007d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.beamBeats(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean beamsOverlap(int i, Rect rect, Rect rect2) {
        boolean z = true;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                z = false;
            }
            return z;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A[SYNTHETIC, Splitter:B:36:0x0061] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0055=Splitter:B:29:0x0055, B:15:0x003a=Splitter:B:15:0x003a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.ContentUriTriggers byteArrayToContentUriTriggers(byte[] r7) {
        /*
            androidx.work.ContentUriTriggers r0 = new androidx.work.ContentUriTriggers
            r0.<init>()
            if (r7 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            int r7 = r2.readInt()     // Catch:{ IOException -> 0x003e }
        L_0x0017:
            if (r7 <= 0) goto L_0x0032
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x003e }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x003e }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x003e }
            androidx.work.ContentUriTriggers$Trigger r5 = new androidx.work.ContentUriTriggers$Trigger     // Catch:{ IOException -> 0x003e }
            r5.<init>(r3, r4)     // Catch:{ IOException -> 0x003e }
            java.util.Set<androidx.work.ContentUriTriggers$Trigger> r3 = r0.mTriggers     // Catch:{ IOException -> 0x003e }
            r3.add(r5)     // Catch:{ IOException -> 0x003e }
            int r7 = r7 + -1
            goto L_0x0017
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r7 = move-exception
            r7.printStackTrace()
        L_0x003a:
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x003e:
            r7 = move-exception
            goto L_0x0048
        L_0x0040:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x005f
        L_0x0044:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L_0x0048:
            r7.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0055:
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005d:
            return r0
        L_0x005e:
            r7 = move-exception
        L_0x005f:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            r1.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.byteArrayToContentUriTriggers(byte[]):androidx.work.ContentUriTriggers");
    }

    public static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static int computeScrollExtent(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
    }

    public static int computeScrollOffset(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        int i;
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            i = Math.max(0, (state.getItemCount() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view))));
    }

    public static int computeScrollRange(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.getItemCount();
        }
        return (int) ((((float) (orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.getItemCount()));
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r15v16, types: [android.animation.AnimatorSet] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0300  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator createAnimatorFromXml(android.content.Context r22, android.content.res.Resources r23, android.content.res.Resources.Theme r24, org.xmlpull.v1.XmlPullParser r25, android.util.AttributeSet r26, android.animation.AnimatorSet r27, int r28, float r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r27
            int r12 = r25.getDepth()
            r0 = 0
            r1 = 0
            r13 = r1
        L_0x000f:
            int r1 = r25.next()
            r2 = 3
            r14 = 0
            if (r1 != r2) goto L_0x001d
            int r3 = r25.getDepth()
            if (r3 <= r12) goto L_0x0327
        L_0x001d:
            r3 = 1
            if (r1 == r3) goto L_0x0327
            r4 = 2
            if (r1 == r4) goto L_0x0024
            goto L_0x000f
        L_0x0024:
            java.lang.String r1 = r25.getName()
            java.lang.String r5 = "objectAnimator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0046
            android.animation.ObjectAnimator r7 = new android.animation.ObjectAnimator
            r7.<init>()
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            r4 = r7
            r5 = r29
            r6 = r25
            loadAnimator(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x005f
        L_0x0046:
            java.lang.String r5 = "animator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0064
            r4 = 0
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            r5 = r29
            r6 = r25
            android.animation.ValueAnimator r7 = loadAnimator(r0, r1, r2, r3, r4, r5, r6)
        L_0x005f:
            r0 = r7
            r19 = r12
            goto L_0x02fa
        L_0x0064:
            java.lang.String r5 = "set"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x009b
            android.animation.AnimatorSet r15 = new android.animation.AnimatorSet
            r15.<init>()
            int[] r0 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR_SET
            r7 = r26
            android.content.res.TypedArray r6 = a.a.a.a.d.b.obtainAttributes(r8, r9, r7, r0)
            java.lang.String r0 = "ordering"
            int r16 = a.a.a.a.d.b.getNamedInt(r6, r10, r0, r14, r14)
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r15
            r17 = r6
            r6 = r16
            r7 = r29
            createAnimatorFromXml(r0, r1, r2, r3, r4, r5, r6, r7)
            r17.recycle()
            r19 = r12
            r0 = r15
            goto L_0x02fa
        L_0x009b:
            java.lang.String r5 = "propertyValuesHolder"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0310
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r25)
            r6 = 0
        L_0x00a8:
            int r7 = r25.getEventType()
            if (r7 == r2) goto L_0x02d4
            if (r7 == r3) goto L_0x02d4
            if (r7 == r4) goto L_0x00b6
            r25.next()
            goto L_0x00a8
        L_0x00b6:
            java.lang.String r3 = r25.getName()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x02bd
            int[] r3 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER
            android.content.res.TypedArray r3 = a.a.a.a.d.b.obtainAttributes(r8, r9, r1, r3)
            java.lang.String r7 = "propertyName"
            java.lang.String r7 = a.a.a.a.d.b.getNamedString(r3, r10, r7, r2)
            java.lang.String r14 = "valueType"
            r15 = 4
            int r4 = a.a.a.a.d.b.getNamedInt(r3, r10, r14, r4, r15)
            r14 = 0
            r16 = r1
            r15 = r4
        L_0x00d7:
            int r1 = r25.next()
            if (r1 == r2) goto L_0x01c4
            r17 = r2
            r2 = 1
            if (r1 == r2) goto L_0x01c4
            java.lang.String r1 = r25.getName()
            java.lang.String r2 = "keyframe"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01ba
            java.lang.String r1 = "value"
            r2 = 4
            if (r15 != r2) goto L_0x0121
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r25)
            int[] r15 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME
            android.content.res.TypedArray r2 = a.a.a.a.d.b.obtainAttributes(r8, r9, r2, r15)
            boolean r15 = a.a.a.a.d.b.hasAttribute(r10, r1)
            if (r15 != 0) goto L_0x0105
            r15 = 0
            goto L_0x010a
        L_0x0105:
            r15 = 0
            android.util.TypedValue r15 = r2.peekValue(r15)
        L_0x010a:
            if (r15 == 0) goto L_0x010f
            r17 = 1
            goto L_0x0111
        L_0x010f:
            r17 = 0
        L_0x0111:
            if (r17 == 0) goto L_0x011d
            int r15 = r15.type
            boolean r15 = isColorType(r15)
            if (r15 == 0) goto L_0x011d
            r15 = 3
            goto L_0x011e
        L_0x011d:
            r15 = 0
        L_0x011e:
            r2.recycle()
        L_0x0121:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r25)
            r18 = r5
            int[] r5 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_KEYFRAME
            android.content.res.TypedArray r2 = a.a.a.a.d.b.obtainAttributes(r8, r9, r2, r5)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.String r8 = "fraction"
            r9 = 3
            float r5 = a.a.a.a.d.b.getNamedFloat(r2, r10, r8, r9, r5)
            boolean r8 = a.a.a.a.d.b.hasAttribute(r10, r1)
            if (r8 != 0) goto L_0x013e
            r8 = 0
            goto L_0x0143
        L_0x013e:
            r8 = 0
            android.util.TypedValue r8 = r2.peekValue(r8)
        L_0x0143:
            if (r8 == 0) goto L_0x0147
            r9 = 1
            goto L_0x0148
        L_0x0147:
            r9 = 0
        L_0x0148:
            r19 = r12
            r12 = 4
            if (r15 != r12) goto L_0x015b
            if (r9 == 0) goto L_0x0159
            int r8 = r8.type
            boolean r8 = isColorType(r8)
            if (r8 == 0) goto L_0x0159
            r8 = 3
            goto L_0x015c
        L_0x0159:
            r8 = 0
            goto L_0x015c
        L_0x015b:
            r8 = r15
        L_0x015c:
            if (r9 == 0) goto L_0x017d
            if (r8 == 0) goto L_0x0172
            r9 = 1
            if (r8 == r9) goto L_0x0168
            r9 = 3
            if (r8 == r9) goto L_0x0168
            r1 = 0
            goto L_0x018a
        L_0x0168:
            r8 = 0
            int r1 = a.a.a.a.d.b.getNamedInt(r2, r10, r1, r8, r8)
            android.animation.Keyframe r1 = android.animation.Keyframe.ofInt(r5, r1)
            goto L_0x018a
        L_0x0172:
            r8 = 0
            r9 = 0
            float r1 = a.a.a.a.d.b.getNamedFloat(r2, r10, r1, r8, r9)
            android.animation.Keyframe r1 = android.animation.Keyframe.ofFloat(r5, r1)
            goto L_0x018a
        L_0x017d:
            r1 = 0
            if (r8 != 0) goto L_0x0185
            android.animation.Keyframe r5 = android.animation.Keyframe.ofFloat(r5)
            goto L_0x0189
        L_0x0185:
            android.animation.Keyframe r5 = android.animation.Keyframe.ofInt(r5)
        L_0x0189:
            r1 = r5
        L_0x018a:
            r5 = 0
            java.lang.String r8 = "interpolator"
            r9 = 1
            int r5 = a.a.a.a.d.b.getNamedResourceId(r2, r10, r8, r9, r5)
            r8 = r22
            if (r5 <= 0) goto L_0x019d
            android.view.animation.Interpolator r5 = android.view.animation.AnimationUtils.loadInterpolator(r8, r5)
            r1.setInterpolator(r5)
        L_0x019d:
            r2.recycle()
            if (r1 == 0) goto L_0x01ac
            if (r14 != 0) goto L_0x01a9
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x01a9:
            r14.add(r1)
        L_0x01ac:
            r25.next()
            r2 = 3
            r8 = r23
            r9 = r24
            r5 = r18
            r12 = r19
            goto L_0x00d7
        L_0x01ba:
            r8 = r22
            r8 = r23
            r9 = r24
            r2 = r17
            goto L_0x00d7
        L_0x01c4:
            r8 = r22
            r18 = r5
            r19 = r12
            if (r14 == 0) goto L_0x02a2
            int r1 = r14.size()
            if (r1 <= 0) goto L_0x02a2
            r2 = 0
            java.lang.Object r2 = r14.get(r2)
            android.animation.Keyframe r2 = (android.animation.Keyframe) r2
            int r5 = r1 + -1
            java.lang.Object r5 = r14.get(r5)
            android.animation.Keyframe r5 = (android.animation.Keyframe) r5
            float r9 = r5.getFraction()
            r12 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r17 >= 0) goto L_0x0202
            r17 = 0
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 >= 0) goto L_0x01f5
            r5.setFraction(r12)
            goto L_0x0202
        L_0x01f5:
            int r9 = r14.size()
            android.animation.Keyframe r5 = createNewKeyframe(r5, r12)
            r14.add(r9, r5)
            int r1 = r1 + 1
        L_0x0202:
            float r5 = r2.getFraction()
            r9 = 0
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x021d
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x0213
            r2.setFraction(r9)
            goto L_0x021d
        L_0x0213:
            android.animation.Keyframe r2 = createNewKeyframe(r2, r9)
            r5 = 0
            r14.add(r5, r2)
            int r1 = r1 + 1
        L_0x021d:
            android.animation.Keyframe[] r2 = new android.animation.Keyframe[r1]
            r14.toArray(r2)
            r5 = 0
        L_0x0223:
            if (r5 >= r1) goto L_0x0295
            r9 = r2[r5]
            float r12 = r9.getFraction()
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x028c
            if (r5 != 0) goto L_0x0236
            r9.setFraction(r14)
            goto L_0x028c
        L_0x0236:
            int r12 = r1 + -1
            if (r5 != r12) goto L_0x0240
            r12 = 1065353216(0x3f800000, float:1.0)
            r9.setFraction(r12)
            goto L_0x028c
        L_0x0240:
            int r9 = r5 + 1
            r14 = r5
        L_0x0243:
            if (r9 >= r12) goto L_0x025a
            r17 = r2[r9]
            float r17 = r17.getFraction()
            r20 = 0
            int r17 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1))
            if (r17 < 0) goto L_0x0252
            goto L_0x025a
        L_0x0252:
            int r14 = r9 + 1
            r21 = r14
            r14 = r9
            r9 = r21
            goto L_0x0243
        L_0x025a:
            int r9 = r14 + 1
            r9 = r2[r9]
            float r9 = r9.getFraction()
            int r12 = r5 + -1
            r12 = r2[r12]
            float r12 = r12.getFraction()
            float r9 = r9 - r12
            int r12 = r14 - r5
            int r12 = r12 + 2
            float r12 = (float) r12
            float r9 = r9 / r12
            r12 = r5
        L_0x0272:
            if (r12 > r14) goto L_0x028c
            r17 = r1
            r1 = r2[r12]
            int r20 = r12 + -1
            r20 = r2[r20]
            float r20 = r20.getFraction()
            float r8 = r20 + r9
            r1.setFraction(r8)
            int r12 = r12 + 1
            r8 = r22
            r1 = r17
            goto L_0x0272
        L_0x028c:
            r17 = r1
            int r5 = r5 + 1
            r8 = r22
            r1 = r17
            goto L_0x0223
        L_0x0295:
            android.animation.PropertyValuesHolder r1 = android.animation.PropertyValuesHolder.ofKeyframe(r7, r2)
            r2 = 3
            if (r15 != r2) goto L_0x02a4
            androidx.vectordrawable.graphics.drawable.ArgbEvaluator r5 = androidx.vectordrawable.graphics.drawable.ArgbEvaluator.sInstance
            r1.setEvaluator(r5)
            goto L_0x02a4
        L_0x02a2:
            r2 = 3
            r1 = 0
        L_0x02a4:
            r5 = 0
            r8 = 1
            if (r1 != 0) goto L_0x02ac
            android.animation.PropertyValuesHolder r1 = getPVH(r3, r4, r5, r8, r7)
        L_0x02ac:
            if (r1 == 0) goto L_0x02b9
            if (r6 != 0) goto L_0x02b6
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = r4
        L_0x02b6:
            r6.add(r1)
        L_0x02b9:
            r3.recycle()
            goto L_0x02c3
        L_0x02bd:
            r16 = r1
            r18 = r5
            r19 = r12
        L_0x02c3:
            r25.next()
            r3 = 1
            r4 = 2
            r8 = r23
            r9 = r24
            r1 = r16
            r5 = r18
            r12 = r19
            goto L_0x00a8
        L_0x02d4:
            r19 = r12
            if (r6 == 0) goto L_0x02ec
            int r1 = r6.size()
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r1]
            r3 = 0
        L_0x02df:
            if (r3 >= r1) goto L_0x02ed
            java.lang.Object r4 = r6.get(r3)
            android.animation.PropertyValuesHolder r4 = (android.animation.PropertyValuesHolder) r4
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x02df
        L_0x02ec:
            r2 = 0
        L_0x02ed:
            if (r2 == 0) goto L_0x02f9
            boolean r1 = r0 instanceof android.animation.ValueAnimator
            if (r1 == 0) goto L_0x02f9
            r1 = r0
            android.animation.ValueAnimator r1 = (android.animation.ValueAnimator) r1
            r1.setValues(r2)
        L_0x02f9:
            r14 = 1
        L_0x02fa:
            if (r11 == 0) goto L_0x0308
            if (r14 != 0) goto L_0x0308
            if (r13 != 0) goto L_0x0305
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x0305:
            r13.add(r0)
        L_0x0308:
            r8 = r23
            r9 = r24
            r12 = r19
            goto L_0x000f
        L_0x0310:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Unknown animator name: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r25.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0327:
            if (r11 == 0) goto L_0x0351
            if (r13 == 0) goto L_0x0351
            int r1 = r13.size()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            java.util.Iterator r2 = r13.iterator()
            r3 = 0
        L_0x0336:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0348
            java.lang.Object r4 = r2.next()
            android.animation.Animator r4 = (android.animation.Animator) r4
            int r5 = r3 + 1
            r1[r3] = r4
            r3 = r5
            goto L_0x0336
        L_0x0348:
            if (r28 != 0) goto L_0x034e
            r11.playTogether(r1)
            goto L_0x0351
        L_0x034e:
            r11.playSequentially(r1)
        L_0x0351:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.createAnimatorFromXml(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Keyframe createNewKeyframe(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void dropFtsSyncTriggers(androidx.sqlite.db.SupportSQLiteDatabase r5) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.createListBuilder()
            java.lang.String r1 = "SELECT name FROM sqlite_master WHERE type = 'trigger'"
            android.database.Cursor r1 = r5.query(r1)
            r2 = 0
        L_0x0010:
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x005d }
            r4 = 0
            if (r3 == 0) goto L_0x0022
            java.lang.String r3 = r1.getString(r4)     // Catch:{ all -> 0x005d }
            r4 = r0
            kotlin.collections.builders.ListBuilder r4 = (kotlin.collections.builders.ListBuilder) r4
            r4.add(r3)     // Catch:{ all -> 0x005d }
            goto L_0x0010
        L_0x0022:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r2)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.build(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x002d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "triggerName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 2
            java.lang.String r3 = "room_fts_content_sync_"
            boolean r2 = kotlin.text.CharsKt__CharKt.startsWith$default(r1, r3, r4, r2)
            if (r2 == 0) goto L_0x002d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "DROP TRIGGER IF EXISTS "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r5.execSQL(r1)
            goto L_0x002d
        L_0x005c:
            return
        L_0x005d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.dropFtsSyncTriggers(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void enableZ(Canvas canvas, boolean z) {
        int i = VERSION.SDK_INT;
        if (i >= 29) {
            if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i != 28) {
            if (!sOrderMethodsFetched) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    sReorderBarrierMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    sInorderBarrierMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sOrderMethodsFetched = true;
            }
            if (z) {
                try {
                    if (sReorderBarrierMethod != null) {
                        sReorderBarrierMethod.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
            if (!z && sInorderBarrierMethod != null) {
                sInorderBarrierMethod.invoke(canvas, new Object[0]);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }

    public static String escapeBytes(ByteString byteString) {
        StringBuilder sb = new StringBuilder(byteString.size());
        for (int i = 0; i < byteString.size(); i++) {
            byte byteAt = byteString.byteAt(i);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb.append((char) byteAt);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + BaseParser.ASCII_ZERO));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static InvocationHandler fetchGlueProviderFactoryImpl() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        ClassLoader classLoader;
        if (VERSION.SDK_INT >= 28) {
            classLoader = WebView.getWebViewClassLoader();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, new Object[0]).getClass().getClassLoader();
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }

    public static ZipUtil$CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length >= 0) {
            long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            if (j2 >= 0) {
                j = j2;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    ZipUtil$CentralDirectory zipUtil$CentralDirectory = new ZipUtil$CentralDirectory();
                    zipUtil$CentralDirectory.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    zipUtil$CentralDirectory.offset = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return zipUtil$CentralDirectory;
                }
                length--;
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("File too short to be a zip file: ");
        outline73.append(randomAccessFile.length());
        throw new ZipException(outline73.toString());
    }

    public static NavController findNavController(View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static NavController findViewNavController(View view) {
        NavController navController;
        while (view != null) {
            Object tag = view.getTag(R$id.nav_controller_view_tag);
            if (tag instanceof WeakReference) {
                navController = (NavController) ((WeakReference) tag).get();
            } else {
                navController = tag instanceof NavController ? (NavController) tag : null;
            }
            if (navController != null) {
                return navController;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) {
        if (VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!sButtonDrawableFieldFetched) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sButtonDrawableFieldFetched = true;
        }
        Field field = sButtonDrawableField;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        r0 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getColumnIndexOrThrow(android.database.Cursor r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            int r0 = r13.getColumnIndex(r14)
            if (r0 < 0) goto L_0x0018
            goto L_0x00aa
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 96
            r0.append(r2)
            r0.append(r14)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            int r0 = r13.getColumnIndex(r0)
            if (r0 < 0) goto L_0x0034
            goto L_0x00aa
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 25
            if (r0 <= r3) goto L_0x003c
            goto L_0x00a9
        L_0x003c:
            int r0 = r14.length()
            r3 = 0
            if (r0 != 0) goto L_0x0045
            r0 = 1
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            if (r0 == 0) goto L_0x0049
            goto L_0x00a9
        L_0x0049:
            java.lang.String[] r0 = r13.getColumnNames()
            java.lang.String r4 = "columnNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = 46
            r1.append(r4)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r14)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            int r5 = r0.length
            r6 = 0
            r7 = 0
        L_0x007e:
            if (r6 >= r5) goto L_0x00a9
            r8 = r0[r6]
            int r9 = r7 + 1
            int r10 = r8.length()
            int r11 = r14.length()
            r12 = 2
            int r11 = r11 + r12
            if (r10 < r11) goto L_0x00a5
            boolean r10 = kotlin.text.CharsKt__CharKt.endsWith$default(r8, r1, r3, r12)
            if (r10 == 0) goto L_0x0097
            goto L_0x00a3
        L_0x0097:
            char r10 = r8.charAt(r3)
            if (r10 != r2) goto L_0x00a5
            boolean r8 = kotlin.text.CharsKt__CharKt.endsWith$default(r8, r4, r3, r12)
            if (r8 == 0) goto L_0x00a5
        L_0x00a3:
            r0 = r7
            goto L_0x00aa
        L_0x00a5:
            int r6 = r6 + 1
            r7 = r9
            goto L_0x007e
        L_0x00a9:
            r0 = -1
        L_0x00aa:
            if (r0 < 0) goto L_0x00ad
            return r0
        L_0x00ad:
            java.lang.String[] r1 = r13.getColumnNames()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r13 = "c.columnNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)     // Catch:{ Exception -> 0x00c3 }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 63
            java.lang.String r13 = com.twitter.sdk.android.tweetui.TweetUtils.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00c5
        L_0x00c3:
            java.lang.String r13 = "unknown"
        L_0x00c5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "column '"
            java.lang.String r2 = "' does not exist. Available columns: "
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r1, r14, r2, r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.getColumnIndexOrThrow(android.database.Cursor, java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getDeviceId(android.content.Context r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ all -> 0x0072 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0072 }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "deviceId"
            r2.<init>(r6, r3)     // Catch:{ all -> 0x0072 }
            boolean r6 = r2.exists()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "charset"
            if (r6 != 0) goto L_0x004e
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0072 }
            r6.<init>(r2)     // Catch:{ all -> 0x0072 }
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x0047 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x0047 }
            byte[] r1 = r2.getBytes(r1)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x0047 }
            r6.write(r1)     // Catch:{ all -> 0x0047 }
            r6.flush()     // Catch:{ all -> 0x0047 }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r0)     // Catch:{ all -> 0x0072 }
            return r2
        L_0x0047:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r1)     // Catch:{ all -> 0x0072 }
            throw r2     // Catch:{ all -> 0x0072 }
        L_0x004e:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = "r"
            r6.<init>(r2, r4)     // Catch:{ all -> 0x0072 }
            long r4 = r6.length()     // Catch:{ all -> 0x006b }
            int r2 = (int) r4     // Catch:{ all -> 0x006b }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x006b }
            r6.readFully(r2)     // Catch:{ all -> 0x006b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x006b }
            r3.<init>(r2, r1)     // Catch:{ all -> 0x006b }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r0)     // Catch:{ all -> 0x0072 }
            return r3
        L_0x006b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006d }
        L_0x006d:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r6, r1)     // Catch:{ all -> 0x0072 }
            throw r2     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r6 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.getDeviceId(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getKernelVersion() {
        /*
            java.lang.String r0 = "os.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/proc/version"
            r1.<init>(r2)
            boolean r2 = r1.canRead()
            if (r2 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002e }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x002e }
            r3.<init>(r1)     // Catch:{ all -> 0x002e }
            r2.<init>(r3)     // Catch:{ all -> 0x002e }
            r1 = 0
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0027 }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ all -> 0x002e }
            return r3
        L_0x0027:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r3 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ all -> 0x002e }
            throw r3     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.getKernelVersion():java.lang.String");
    }

    public static final String getNetworkType(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object obj2 = null;
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                Intrinsics.checkNotNull(networkCapabilities);
                Intrinsics.checkNotNullExpressionValue(networkCapabilities, "connectivityManager.getNetworkCapabilities(nw)!!");
                if (networkCapabilities.hasTransport(1)) {
                    obj = AnalyticsConstants.WIFI;
                } else if (networkCapabilities.hasTransport(0)) {
                    obj = AnalyticsConstants.CELLULAR;
                } else {
                    obj = networkCapabilities.hasTransport(3) ? "ethernet" : null;
                }
                if (!(obj instanceof Failure)) {
                    obj2 = obj;
                }
                return (String) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } catch (Throwable th) {
            obj = TweetUtils.createFailure(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r3 <= 8) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        r2 = a(r10, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r2 == 1229531648) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
        if (r2 == 1296891946) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0071, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r2 != 1229531648) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0074, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0076, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0077, code lost:
        r4 = a(r10, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0080, code lost:
        if (r4 < 10) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0082, code lost:
        if (r4 <= r3) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0085, code lost:
        r1 = r1 + r4;
        r3 = r3 - r4;
        r4 = a(r10, r1 - 2, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
        r8 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008f, code lost:
        if (r4 <= 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0093, code lost:
        if (r3 < 12) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
        if (a(r10, r1, 2, r2) != 274) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        r10 = a(r10, r1 + 8, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a2, code lost:
        if (r10 == 1) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a4, code lost:
        r1 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a5, code lost:
        if (r10 == 3) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a7, code lost:
        r1 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a8, code lost:
        if (r10 == 6) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00aa, code lost:
        if (r10 == 8) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ac, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ad, code lost:
        return 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ae, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00af, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b0, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b6, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getOrientation(byte[] r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r10.length
            r4 = 4
            r5 = 1
            r6 = 8
            r7 = 2
            if (r2 >= r3) goto L_0x0060
            int r2 = r1 + 1
            byte r1 = r10[r1]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x005f
            byte r1 = r10[r2]
            r1 = r1 & r3
            if (r1 != r3) goto L_0x001e
            goto L_0x005d
        L_0x001e:
            int r2 = r2 + 1
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L_0x005d
            if (r1 != r5) goto L_0x0027
            goto L_0x005d
        L_0x0027:
            r3 = 217(0xd9, float:3.04E-43)
            if (r1 == r3) goto L_0x005f
            r3 = 218(0xda, float:3.05E-43)
            if (r1 != r3) goto L_0x0030
            goto L_0x005f
        L_0x0030:
            int r3 = a(r10, r2, r7, r0)
            if (r3 < r7) goto L_0x005c
            int r8 = r2 + r3
            int r9 = r10.length
            if (r8 <= r9) goto L_0x003c
            goto L_0x005c
        L_0x003c:
            r9 = 225(0xe1, float:3.15E-43)
            if (r1 != r9) goto L_0x005a
            if (r3 < r6) goto L_0x005a
            int r1 = r2 + 2
            int r1 = a(r10, r1, r4, r0)
            r9 = 1165519206(0x45786966, float:3974.5874)
            if (r1 != r9) goto L_0x005a
            int r1 = r2 + 6
            int r1 = a(r10, r1, r7, r0)
            if (r1 != 0) goto L_0x005a
            int r1 = r2 + 8
            int r3 = r3 + -8
            goto L_0x0061
        L_0x005a:
            r1 = r8
            goto L_0x0005
        L_0x005c:
            return r0
        L_0x005d:
            r1 = r2
            goto L_0x0005
        L_0x005f:
            r1 = r2
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 <= r6) goto L_0x00b6
            int r2 = a(r10, r1, r4, r0)
            r8 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r8) goto L_0x0072
            r9 = 1296891946(0x4d4d002a, float:2.1495875E8)
            if (r2 == r9) goto L_0x0072
            return r0
        L_0x0072:
            if (r2 != r8) goto L_0x0076
            r2 = 1
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            int r8 = r1 + 4
            int r4 = a(r10, r8, r4, r2)
            int r4 = r4 + r7
            r8 = 10
            if (r4 < r8) goto L_0x00b6
            if (r4 <= r3) goto L_0x0085
            goto L_0x00b6
        L_0x0085:
            int r1 = r1 + r4
            int r3 = r3 - r4
            int r4 = r1 + -2
            int r4 = a(r10, r4, r7, r2)
        L_0x008d:
            int r8 = r4 + -1
            if (r4 <= 0) goto L_0x00b6
            r4 = 12
            if (r3 < r4) goto L_0x00b6
            int r4 = a(r10, r1, r7, r2)
            r9 = 274(0x112, float:3.84E-43)
            if (r4 != r9) goto L_0x00b0
            int r1 = r1 + r6
            int r10 = a(r10, r1, r7, r2)
            if (r10 == r5) goto L_0x00af
            r1 = 3
            if (r10 == r1) goto L_0x00ae
            r1 = 6
            if (r10 == r1) goto L_0x00ae
            if (r10 == r6) goto L_0x00ad
            return r0
        L_0x00ad:
            return r6
        L_0x00ae:
            return r1
        L_0x00af:
            return r5
        L_0x00b0:
            int r1 = r1 + 12
            int r3 = r3 + -12
            r4 = r8
            goto L_0x008d
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.getOrientation(byte[]):int");
    }

    public static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        int i4;
        int i5;
        int i6;
        float f2;
        float f3;
        float f4;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !isColorType(i7)) && (!z2 || !isColorType(i8))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser$PathDataNode[] createNodesFromPathData = b.createNodesFromPathData(string);
            PathParser$PathDataNode[] createNodesFromPathData2 = b.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                return null;
            }
            if (createNodesFromPathData != null) {
                AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
                if (createNodesFromPathData2 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, new Object[]{createNodesFromPathData});
                } else if (b.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, new Object[]{createNodesFromPathData, createNodesFromPathData2});
                } else {
                    throw new InflateException(GeneratedOutlineSupport.outline53(" Can't morph from ", string, " to ", string2));
                }
                return propertyValuesHolder2;
            } else if (createNodesFromPathData2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new AnimatorInflaterCompat$PathDataEvaluator(), new Object[]{createNodesFromPathData2});
            }
        } else {
            TypeEvaluator typeEvaluator = i == 3 ? ArgbEvaluator.sInstance : null;
            if (z3) {
                if (z) {
                    if (i7 == 5) {
                        f3 = typedArray.getDimension(i2, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i2, 0.0f);
                    }
                    if (z2) {
                        if (i8 == 5) {
                            f4 = typedArray.getDimension(i3, 0.0f);
                        } else {
                            f4 = typedArray.getFloat(i3, 0.0f);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f3, f4});
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f3});
                    }
                } else {
                    if (i8 == 5) {
                        f2 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f2 = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f2});
                }
            } else if (z) {
                if (i7 == 5) {
                    i5 = (int) typedArray.getDimension(i2, 0.0f);
                } else if (isColorType(i7)) {
                    i5 = typedArray.getColor(i2, 0);
                } else {
                    i5 = typedArray.getInt(i2, 0);
                }
                if (z2) {
                    if (i8 == 5) {
                        i6 = (int) typedArray.getDimension(i3, 0.0f);
                    } else if (isColorType(i8)) {
                        i6 = typedArray.getColor(i3, 0);
                    } else {
                        i6 = typedArray.getInt(i3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i5, i6});
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i5});
                }
            } else {
                if (z2) {
                    if (i8 == 5) {
                        i4 = (int) typedArray.getDimension(i3, 0.0f);
                    } else if (isColorType(i8)) {
                        i4 = typedArray.getColor(i3, 0);
                    } else {
                        i4 = typedArray.getInt(i3, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i4});
                }
                if (propertyValuesHolder3 == null && typeEvaluator != null) {
                    propertyValuesHolder3.setEvaluator(typeEvaluator);
                    return propertyValuesHolder3;
                }
            }
            propertyValuesHolder3 = propertyValuesHolder;
            return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
        }
    }

    public static final CoroutineDispatcher getQueryDispatcher(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            obj = TypeUtilsKt.from(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }

    public static Params getTextMetricsParams(TextView textView) {
        int i;
        int i2;
        TextDirectionHeuristic textDirectionHeuristic;
        if (VERSION.SDK_INT >= 28) {
            return new Params(textView.getTextMetricsParams());
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        boolean z = false;
        if (VERSION.SDK_INT >= 23) {
            i2 = 1;
            i = 1;
        } else {
            i2 = 0;
            i = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (VERSION.SDK_INT >= 23) {
            i2 = textView.getBreakStrategy();
            i = textView.getHyphenationFrequency();
        }
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (!z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    } else {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    }
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
        }
        return new Params(textPaint, textDirectionHeuristic, i2, i);
    }

    public static final CoroutineDispatcher getTransactionDispatcher(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            obj = TypeUtilsKt.from(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }

    public static WritableMap getUserProperties(GoogleSignInAccount googleSignInAccount) {
        Uri uri = googleSignInAccount.zah;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", googleSignInAccount.zad);
        createMap.putString("name", googleSignInAccount.zag);
        createMap.putString("givenName", googleSignInAccount.zal);
        createMap.putString("familyName", googleSignInAccount.zam);
        createMap.putString("email", googleSignInAccount.zaf);
        createMap.putString("photo", uri != null ? uri.toString() : null);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap(Action.USER, createMap);
        createMap2.putString("idToken", googleSignInAccount.zae);
        createMap2.putString("serverAuthCode", googleSignInAccount.zai);
        WritableArray createArray = Arguments.createArray();
        Iterator it = new HashSet(googleSignInAccount.zac).iterator();
        while (it.hasNext()) {
            String str = ((Scope) it.next()).zzb;
            if (str.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
                createArray.pushString(str);
            }
        }
        createMap2.putArray("scopes", createArray);
        return createMap2;
    }

    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), Dispatchers.getMain().getImmediate())));
        Intrinsics.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }

    public static BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Could not convert ", i, " to BackoffPolicy"));
    }

    public static NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Could not convert ", i, " to NetworkType"));
    }

    public static WorkInfo$State intToState(int i) {
        if (i == 0) {
            return WorkInfo$State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo$State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo$State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo$State.FAILED;
        }
        if (i == 4) {
            return WorkInfo$State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo$State.CANCELLED;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Could not convert ", i, " to State"));
    }

    public static boolean isCandidate(Rect rect, Rect rect2, int i) {
        boolean z = true;
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            if ((i2 <= i3 && rect.left < i3) || rect.left <= rect2.left) {
                z = false;
            }
            return z;
        } else if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            if ((i4 <= i5 && rect.top < i5) || rect.top <= rect2.top) {
                z = false;
            }
            return z;
        } else if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            if ((i6 >= i7 && rect.right > i7) || rect.right >= rect2.right) {
                z = false;
            }
            return z;
        } else if (i == 130) {
            int i8 = rect.top;
            int i9 = rect2.top;
            if ((i8 >= i9 && rect.bottom > i9) || rect.bottom >= rect2.bottom) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r3.intValue() != 1) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Boolean isCharging(android.content.Context r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "android.intent.action.BATTERY_CHANGED"
            r1.<init>(r2)     // Catch:{ all -> 0x003b }
            android.content.Intent r3 = r3.registerReceiver(r0, r1)     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0015
            r3 = r0
            goto L_0x0020
        L_0x0015:
            java.lang.String r1 = "plugged"
            r2 = -1
            int r3 = r3.getIntExtra(r1, r2)     // Catch:{ all -> 0x003b }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003b }
        L_0x0020:
            r1 = 1
            if (r3 != 0) goto L_0x0024
            goto L_0x002a
        L_0x0024:
            int r2 = r3.intValue()     // Catch:{ all -> 0x003b }
            if (r2 == r1) goto L_0x0036
        L_0x002a:
            r2 = 2
            if (r3 != 0) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            int r3 = r3.intValue()     // Catch:{ all -> 0x003b }
            if (r3 != r2) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x003b }
            goto L_0x0040
        L_0x003b:
            r3 = move-exception
            java.lang.Object r3 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r3)
        L_0x0040:
            boolean r1 = r3 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r0 = r3
        L_0x0046:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.isCharging(android.content.Context):java.lang.Boolean");
    }

    public static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e5, code lost:
        if (kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) "simulator", false, 2) != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (kotlin.text.CharsKt__CharKt.startsWith$default(r6, (java.lang.String) "generic", false, 2) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Boolean isEmulator() {
        /*
            java.lang.String r0 = "google_sdk"
            java.lang.String r1 = "HARDWARE"
            java.lang.String r2 = "FINGERPRINT"
            java.lang.String r3 = "MODEL"
            java.lang.String r4 = "generic"
            java.lang.String r5 = "PRODUCT"
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ all -> 0x00ed }
            java.lang.String r7 = "BRAND"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x00ed }
            r7 = 2
            r8 = 0
            boolean r6 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r4, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x0028
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ all -> 0x00ed }
            java.lang.String r9 = "DEVICE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)     // Catch:{ all -> 0x00ed }
            boolean r6 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r4, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r6 != 0) goto L_0x00e7
        L_0x0028:
            java.lang.String r6 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch:{ all -> 0x00ed }
            boolean r4 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r4, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r4 != 0) goto L_0x00e7
            java.lang.String r4 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "unknown"
            boolean r2 = kotlin.text.CharsKt__CharKt.startsWith$default(r4, r2, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r2 != 0) goto L_0x00e7
            java.lang.String r2 = android.os.Build.HARDWARE     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ all -> 0x00ed }
            java.lang.String r4 = "goldfish"
            boolean r2 = kotlin.text.CharsKt__CharKt.contains$default(r2, r4, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r2 != 0) goto L_0x00e7
            java.lang.String r2 = android.os.Build.HARDWARE     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "ranchu"
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r2, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x00ed }
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r1, r0, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "Emulator"
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r1, r2, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "Android SDK built for x86"
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r1, r2, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "MANUFACTURER"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "Genymotion"
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r1, r2, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "sdk_google"
            boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r1, r2, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ all -> 0x00ed }
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r1, r0, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "sdk"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "sdk_x86"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "vbox86p"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "emulator"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = android.os.Build.PRODUCT     // Catch:{ all -> 0x00ed }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = "simulator"
            boolean r0 = kotlin.text.CharsKt__CharKt.contains$default(r0, r1, r8, r7)     // Catch:{ all -> 0x00ed }
            if (r0 == 0) goto L_0x00e8
        L_0x00e7:
            r8 = 1
        L_0x00e8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x00ed }
            goto L_0x00f2
        L_0x00ed:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)
        L_0x00f2:
            boolean r1 = r0 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L_0x00f7
            r0 = 0
        L_0x00f7:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.isEmulator():java.lang.Boolean");
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        boolean z = false;
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            z = ((Boolean) sIsTagEnabledMethod.invoke(null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
        } catch (Exception e2) {
            if (e2 instanceof InvocationTargetException) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
        }
        return z;
    }

    public static boolean isFeatureSupported(String str) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature(str);
        return feature.isSupportedByFramework() || feature.isSupportedByWebView();
    }

    public static final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        boolean z = false;
        if (connectivityManager == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 29) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return false;
            }
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2)) {
                z = true;
            }
            return z;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z = true;
        }
        return z;
    }

    public static boolean isNotTrailingByte(byte b2) {
        return b2 > -65;
    }

    public static ValueAnimator loadAnimator(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws NotFoundException {
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        Resources resources2 = resources;
        Theme theme2 = theme;
        AttributeSet attributeSet2 = attributeSet;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TypedArray obtainAttributes = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long namedInt = (long) b.getNamedInt(obtainAttributes, xmlPullParser2, InlineAnimation.DURATION, 1, 300);
        int i = 0;
        long namedInt2 = (long) b.getNamedInt(obtainAttributes, xmlPullParser2, "startOffset", 2, 0);
        int namedInt3 = b.getNamedInt(obtainAttributes, xmlPullParser2, "valueType", 7, 4);
        if (b.hasAttribute(xmlPullParser2, "valueFrom") && b.hasAttribute(xmlPullParser2, "valueTo")) {
            if (namedInt3 == 4) {
                TypedValue peekValue = obtainAttributes.peekValue(5);
                boolean z = peekValue != null;
                int i2 = z ? peekValue.type : 0;
                TypedValue peekValue2 = obtainAttributes.peekValue(6);
                boolean z2 = peekValue2 != null;
                namedInt3 = ((!z || !isColorType(i2)) && (!z2 || !isColorType(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder pvh = getPVH(obtainAttributes, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator4.setValues(new PropertyValuesHolder[]{pvh});
            }
        }
        valueAnimator4.setDuration(namedInt);
        valueAnimator4.setStartDelay(namedInt2);
        valueAnimator4.setRepeatCount(b.getNamedInt(obtainAttributes, xmlPullParser2, InlineAnimation.REPEAT_COUNT, 3, 0));
        valueAnimator4.setRepeatMode(b.getNamedInt(obtainAttributes, xmlPullParser2, InlineAnimation.REPEAT_MODE, 4, 1));
        if (obtainAttributes2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String namedString = b.getNamedString(obtainAttributes2, xmlPullParser2, "pathData", 1);
            if (namedString != null) {
                String namedString2 = b.getNamedString(obtainAttributes2, xmlPullParser2, "propertyXName", 2);
                String namedString3 = b.getNamedString(obtainAttributes2, xmlPullParser2, "propertyYName", 3);
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(obtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path createPathFromPathData = b.createPathFromPathData(namedString);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(createPathFromPathData, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                do {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(createPathFromPathData, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = obtainAttributes;
                int i3 = 0;
                float f6 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i >= min) {
                        break;
                    }
                    int i4 = min;
                    pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
                    fArr[i] = fArr3[0];
                    fArr2[i] = fArr3[1];
                    f6 += f5;
                    int i5 = i3 + 1;
                    if (i5 < arrayList.size() && f6 > ((Float) arrayList.get(i5)).floatValue()) {
                        pathMeasure2.nextContour();
                        i3 = i5;
                    }
                    i++;
                    min = i4;
                }
                PropertyValuesHolder ofFloat = namedString2 != null ? PropertyValuesHolder.ofFloat(namedString2, fArr) : null;
                if (namedString3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(namedString3, fArr2);
                }
                if (ofFloat == null) {
                    i = 0;
                    objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
                } else {
                    i = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat});
                    } else {
                        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, propertyValuesHolder});
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = obtainAttributes;
                objectAnimator.setPropertyName(b.getNamedString(obtainAttributes2, xmlPullParser2, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = obtainAttributes;
        }
        TypedArray typedArray2 = typedArray;
        int namedResourceId = b.getNamedResourceId(typedArray2, xmlPullParser2, InlineAnimation.INTERPOLATOR, i, i);
        if (namedResourceId > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator3;
    }

    public static int majorAxisDistance(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i3 = rect.left;
            i2 = rect2.right;
        } else if (i == 33) {
            i3 = rect.top;
            i2 = rect2.bottom;
        } else if (i == 66) {
            i3 = rect2.left;
            i2 = rect.right;
        } else if (i == 130) {
            i3 = rect2.top;
            i2 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return Math.max(0, i3 - i2);
    }

    public static int minorAxisDistance(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, null, path);
    }

    public static final void printField(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object printField : (List) obj) {
                printField(sb, i, str, printField);
            }
        } else if (obj instanceof Map) {
            for (Entry printField2 : ((Map) obj).entrySet()) {
                printField(sb, i, str, printField2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(escapeBytes(ByteString.copyFromUtf8((String) obj)));
                sb.append(StringEscapeUtils.CSV_QUOTE);
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(escapeBytes((ByteString) obj));
                sb.append(StringEscapeUtils.CSV_QUOTE);
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Entry) {
                sb.append(" {");
                Entry entry = (Entry) obj;
                int i4 = i + 2;
                printField(sb, i4, "key", entry.getKey());
                printField(sb, i4, HSLCriteriaBuilder.VALUE, entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.database.Cursor query(androidx.room.RoomDatabase r4, androidx.sqlite.db.SupportSQLiteQuery r5, boolean r6, android.os.CancellationSignal r7) {
        /*
            java.lang.String r7 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.lang.String r7 = "sqLiteQuery"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            r7 = 0
            android.database.Cursor r4 = r4.query(r5, r7)
            if (r6 == 0) goto L_0x00a9
            boolean r5 = r4 instanceof android.database.AbstractWindowedCursor
            if (r5 == 0) goto L_0x00a9
            r5 = r4
            android.database.AbstractWindowedCursor r5 = (android.database.AbstractWindowedCursor) r5
            int r6 = r5.getCount()
            boolean r0 = r5.hasWindow()
            if (r0 == 0) goto L_0x002b
            android.database.CursorWindow r5 = r5.getWindow()
            int r5 = r5.getNumRows()
            goto L_0x002c
        L_0x002b:
            r5 = r6
        L_0x002c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x0034
            if (r5 >= r6) goto L_0x00a9
        L_0x0034:
            java.lang.String r5 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            android.database.MatrixCursor r5 = new android.database.MatrixCursor     // Catch:{ all -> 0x00a2 }
            java.lang.String[] r6 = r4.getColumnNames()     // Catch:{ all -> 0x00a2 }
            int r0 = r4.getCount()     // Catch:{ all -> 0x00a2 }
            r5.<init>(r6, r0)     // Catch:{ all -> 0x00a2 }
        L_0x0046:
            boolean r6 = r4.moveToNext()     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x009e
            int r6 = r4.getColumnCount()     // Catch:{ all -> 0x00a2 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a2 }
            r0 = 0
            int r1 = r4.getColumnCount()     // Catch:{ all -> 0x00a2 }
        L_0x0057:
            if (r0 >= r1) goto L_0x009a
            int r2 = r4.getType(r0)     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0095
            r3 = 1
            if (r2 == r3) goto L_0x008a
            r3 = 2
            if (r2 == r3) goto L_0x007f
            r3 = 3
            if (r2 == r3) goto L_0x0078
            r3 = 4
            if (r2 != r3) goto L_0x0072
            byte[] r2 = r4.getBlob(r0)     // Catch:{ all -> 0x00a2 }
            r6[r0] = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x0097
        L_0x0072:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a2 }
            r5.<init>()     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x0078:
            java.lang.String r2 = r4.getString(r0)     // Catch:{ all -> 0x00a2 }
            r6[r0] = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x0097
        L_0x007f:
            double r2 = r4.getDouble(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00a2 }
            r6[r0] = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x0097
        L_0x008a:
            long r2 = r4.getLong(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00a2 }
            r6[r0] = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x0097
        L_0x0095:
            r6[r0] = r7     // Catch:{ all -> 0x00a2 }
        L_0x0097:
            int r0 = r0 + 1
            goto L_0x0057
        L_0x009a:
            r5.addRow(r6)     // Catch:{ all -> 0x00a2 }
            goto L_0x0046
        L_0x009e:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r7)
            return r5
        L_0x00a2:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r6 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r4, r5)
            throw r6
        L_0x00a9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.query(androidx.room.RoomDatabase, androidx.sqlite.db.SupportSQLiteQuery, boolean, android.os.CancellationSignal):android.database.Cursor");
    }

    public static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(Values.SEQ);
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List createListBuilder = TweetUtils.createListBuilder();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            ForeignKeyWithSequence foreignKeyWithSequence = new ForeignKeyWithSequence(i, i2, string, string2);
            ListBuilder listBuilder = (ListBuilder) createListBuilder;
            listBuilder.checkIsMutable();
            listBuilder.addAtInternal(listBuilder.offset + listBuilder.length, foreignKeyWithSequence);
        }
        return ArraysKt___ArraysJvmKt.sorted(TweetUtils.build(createListBuilder));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a5, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.room.util.TableInfo.Index readIndex(androidx.sqlite.db.SupportSQLiteDatabase r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA index_xinfo(`"
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = "`)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.database.Cursor r12 = r12.query(r0)
            java.lang.String r0 = "seqno"
            int r0 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "cid"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "name"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "desc"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x00a2 }
            r4 = 0
            r5 = -1
            if (r0 == r5) goto L_0x009e
            if (r1 == r5) goto L_0x009e
            if (r2 == r5) goto L_0x009e
            if (r3 != r5) goto L_0x003d
            goto L_0x009e
        L_0x003d:
            java.util.TreeMap r5 = new java.util.TreeMap     // Catch:{ all -> 0x00a2 }
            r5.<init>()     // Catch:{ all -> 0x00a2 }
            java.util.TreeMap r6 = new java.util.TreeMap     // Catch:{ all -> 0x00a2 }
            r6.<init>()     // Catch:{ all -> 0x00a2 }
        L_0x0047:
            boolean r7 = r12.moveToNext()     // Catch:{ all -> 0x00a2 }
            if (r7 == 0) goto L_0x007b
            int r7 = r12.getInt(r1)     // Catch:{ all -> 0x00a2 }
            if (r7 >= 0) goto L_0x0054
            goto L_0x0047
        L_0x0054:
            int r7 = r12.getInt(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r8 = r12.getString(r2)     // Catch:{ all -> 0x00a2 }
            int r9 = r12.getInt(r3)     // Catch:{ all -> 0x00a2 }
            if (r9 <= 0) goto L_0x0065
            java.lang.String r9 = "DESC"
            goto L_0x0067
        L_0x0065:
            java.lang.String r9 = "ASC"
        L_0x0067:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r11 = "columnName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)     // Catch:{ all -> 0x00a2 }
            r5.put(r10, r8)     // Catch:{ all -> 0x00a2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00a2 }
            r6.put(r7, r9)     // Catch:{ all -> 0x00a2 }
            goto L_0x0047
        L_0x007b:
            java.util.Collection r0 = r5.values()     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "columnsMap.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x00a2 }
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r0)     // Catch:{ all -> 0x00a2 }
            java.util.Collection r1 = r6.values()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "ordersMap.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x00a2 }
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r1)     // Catch:{ all -> 0x00a2 }
            androidx.room.util.TableInfo$Index r2 = new androidx.room.util.TableInfo$Index     // Catch:{ all -> 0x00a2 }
            r2.<init>(r13, r14, r0, r1)     // Catch:{ all -> 0x00a2 }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r4)
            return r2
        L_0x009e:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r4)
            return r4
        L_0x00a2:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r14 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r12, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.readIndex(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String, boolean):androidx.room.util.TableInfo$Index");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readVersion(java.io.File r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "databaseFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r8)
            java.nio.channels.FileChannel r8 = r0.getChannel()
            r0 = 4
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x003b }
            r2 = 60
            r4 = 4
            r6 = 1
            r1 = r8
            r1.tryLock(r2, r4, r6)     // Catch:{ all -> 0x003b }
            r1 = 60
            r8.position(r1)     // Catch:{ all -> 0x003b }
            int r1 = r8.read(r7)     // Catch:{ all -> 0x003b }
            if (r1 != r0) goto L_0x0033
            r7.rewind()     // Catch:{ all -> 0x003b }
            int r0 = r7.getInt()     // Catch:{ all -> 0x003b }
            r1 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r8, r1)
            return r0
        L_0x0033:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003b }
            java.lang.String r1 = "Bad database header, unable to read 4 bytes at offset 60"
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r8, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.readVersion(java.io.File):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01cd, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01de, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01f0, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L_0x0222;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reflectivePrintWithIndent(androidx.datastore.preferences.protobuf.MessageLite r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeSet r5 = new java.util.TreeSet
            r5.<init>()
            java.lang.Class r6 = r18.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = 0
        L_0x0020:
            java.lang.String r10 = "get"
            if (r9 >= r7) goto L_0x004f
            r11 = r6[r9]
            java.lang.String r12 = r11.getName()
            r4.put(r12, r11)
            java.lang.Class[] r12 = r11.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = r11.getName()
            r3.put(r12, r11)
            java.lang.String r12 = r11.getName()
            boolean r10 = r12.startsWith(r10)
            if (r10 == 0) goto L_0x004c
            java.lang.String r10 = r11.getName()
            r5.add(r10)
        L_0x004c:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x004f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0053:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0241
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = ""
            java.lang.String r9 = r6.replaceFirst(r10, r7)
            java.lang.String r11 = "List"
            boolean r12 = r9.endsWith(r11)
            r13 = 1
            if (r12 == 0) goto L_0x00bf
            java.lang.String r12 = "OrBuilderList"
            boolean r12 = r9.endsWith(r12)
            if (r12 != 0) goto L_0x00bf
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x00bf
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r9.substring(r8, r13)
            java.lang.String r12 = r12.toLowerCase()
            r11.append(r12)
            int r12 = r9.length()
            int r12 = r12 + -4
            java.lang.String r12 = r9.substring(r13, r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Object r12 = r3.get(r6)
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            if (r12 == 0) goto L_0x00bf
            java.lang.Class r14 = r12.getReturnType()
            java.lang.Class<java.util.List> r15 = java.util.List.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00bf
            java.lang.String r6 = camelCaseToSnakeCase(r11)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r12, r0, r7)
            printField(r1, r2, r6, r7)
            goto L_0x0053
        L_0x00bf:
            java.lang.String r11 = "Map"
            boolean r12 = r9.endsWith(r11)
            if (r12 == 0) goto L_0x0123
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x0123
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r9.substring(r8, r13)
            java.lang.String r12 = r12.toLowerCase()
            r11.append(r12)
            int r12 = r9.length()
            int r12 = r12 + -3
            java.lang.String r12 = r9.substring(r13, r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.Object r6 = r3.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 == 0) goto L_0x0123
            java.lang.Class r12 = r6.getReturnType()
            java.lang.Class<java.util.Map> r14 = java.util.Map.class
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0123
            java.lang.Class<java.lang.Deprecated> r12 = java.lang.Deprecated.class
            boolean r12 = r6.isAnnotationPresent(r12)
            if (r12 != 0) goto L_0x0123
            int r12 = r6.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0123
            java.lang.String r7 = camelCaseToSnakeCase(r11)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r6, r0, r9)
            printField(r1, r2, r7, r6)
            goto L_0x0053
        L_0x0123:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "set"
            r6.append(r11)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            java.lang.Object r6 = r4.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x013e
            goto L_0x0053
        L_0x013e:
            java.lang.String r6 = "Bytes"
            boolean r6 = r9.endsWith(r6)
            if (r6 == 0) goto L_0x0163
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r10)
            int r11 = r9.length()
            int r11 = r11 + -5
            java.lang.String r11 = r9.substring(r8, r11)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            boolean r6 = r3.containsKey(r6)
            if (r6 == 0) goto L_0x0163
            goto L_0x0053
        L_0x0163:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = r9.substring(r8, r13)
            java.lang.String r11 = r11.toLowerCase()
            r6.append(r11)
            java.lang.String r11 = r9.substring(r13)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            java.lang.Object r11 = r3.get(r11)
            java.lang.reflect.Method r11 = (java.lang.reflect.Method) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "has"
            r12.append(r14)
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            java.lang.Object r9 = r3.get(r9)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r11 == 0) goto L_0x0053
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Object r11 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r11, r0, r12)
            if (r9 != 0) goto L_0x022a
            boolean r9 = r11 instanceof java.lang.Boolean
            if (r9 == 0) goto L_0x01c2
            r7 = r11
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r7 = r7 ^ r13
            goto L_0x0225
        L_0x01c2:
            boolean r9 = r11 instanceof java.lang.Integer
            if (r9 == 0) goto L_0x01d0
            r7 = r11
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x0224
            goto L_0x0222
        L_0x01d0:
            boolean r9 = r11 instanceof java.lang.Float
            if (r9 == 0) goto L_0x01e1
            r7 = r11
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0224
            goto L_0x0222
        L_0x01e1:
            boolean r9 = r11 instanceof java.lang.Double
            if (r9 == 0) goto L_0x01f3
            r7 = r11
            java.lang.Double r7 = (java.lang.Double) r7
            double r14 = r7.doubleValue()
            r16 = 0
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x0224
            goto L_0x0222
        L_0x01f3:
            boolean r9 = r11 instanceof java.lang.String
            if (r9 == 0) goto L_0x01fc
            boolean r7 = r11.equals(r7)
            goto L_0x0225
        L_0x01fc:
            boolean r7 = r11 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x0207
            androidx.datastore.preferences.protobuf.ByteString r7 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            boolean r7 = r11.equals(r7)
            goto L_0x0225
        L_0x0207:
            boolean r7 = r11 instanceof androidx.datastore.preferences.protobuf.MessageLite
            if (r7 == 0) goto L_0x0215
            r7 = r11
            androidx.datastore.preferences.protobuf.MessageLite r7 = (androidx.datastore.preferences.protobuf.MessageLite) r7
            androidx.datastore.preferences.protobuf.MessageLite r7 = r7.getDefaultInstanceForType()
            if (r11 != r7) goto L_0x0224
            goto L_0x0222
        L_0x0215:
            boolean r7 = r11 instanceof java.lang.Enum
            if (r7 == 0) goto L_0x0224
            r7 = r11
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
            if (r7 != 0) goto L_0x0224
        L_0x0222:
            r7 = 1
            goto L_0x0225
        L_0x0224:
            r7 = 0
        L_0x0225:
            if (r7 != 0) goto L_0x0228
            goto L_0x0236
        L_0x0228:
            r13 = 0
            goto L_0x0236
        L_0x022a:
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.invokeOrDie(r9, r0, r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r13 = r7.booleanValue()
        L_0x0236:
            if (r13 == 0) goto L_0x0053
            java.lang.String r6 = camelCaseToSnakeCase(r6)
            printField(r1, r2, r6, r11)
            goto L_0x0053
        L_0x0241:
            boolean r3 = r0 instanceof androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage
            if (r3 == 0) goto L_0x026e
            r3 = r0
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r3 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r3
            androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r3 = r3.extensions
            java.util.Iterator r3 = r3.iterator()
        L_0x024e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x026e
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor) r5
            if (r5 == 0) goto L_0x026c
            java.lang.Object r4 = r4.getValue()
            java.lang.String r5 = "[0]"
            printField(r1, r2, r5, r4)
            goto L_0x024e
        L_0x026c:
            r0 = 0
            throw r0
        L_0x026e:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r0 = r0.unknownFields
            if (r0 == 0) goto L_0x028c
        L_0x0274:
            int r3 = r0.count
            if (r8 >= r3) goto L_0x028c
            int[] r3 = r0.tags
            r3 = r3[r8]
            int r3 = r3 >>> 3
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object[] r4 = r0.objects
            r4 = r4[r8]
            printField(r1, r2, r3, r4)
            int r8 = r8 + 1
            goto L_0x0274
        L_0x028c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.reflectivePrintWithIndent(androidx.datastore.preferences.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        int i2;
        b.checkArgumentNonnegative(i);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    @SuppressLint({"NewApi"})
    public static void setForceDark(WebSettings webSettings, int i) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("FORCE_DARK");
        if (feature.isSupportedByFramework()) {
            webSettings.setForceDark(i);
        } else if (feature.isSupportedByWebView()) {
            ((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebSettingsBoundaryInterface.class, WebViewGlueCommunicator$LAZY_COMPAT_CONVERTER_HOLDER.INSTANCE.mImpl.convertSettings(webSettings))).setForceDark(i);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int i) {
        int i2;
        b.checkArgumentNonnegative(i);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(TextView textView, int i) {
        b.checkArgumentNonnegative(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (!sOverlapAnchorFieldAttempted) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                sOverlapAnchorField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sOverlapAnchorFieldAttempted = true;
        }
        Field field = sOverlapAnchorField;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void setPrecomputedText(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (VERSION.SDK_INT < 29) {
            Params textMetricsParams = getTextMetricsParams(textView);
            if (precomputedTextCompat == null) {
                throw null;
            } else if (textMetricsParams.equalsWithoutTextDirection(null)) {
                textView.setText(precomputedTextCompat);
            } else {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        } else if (precomputedTextCompat != null) {
            textView.setText(null);
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setText(android.widget.TextView r7, java.lang.CharSequence r8) {
        /*
            java.lang.CharSequence r0 = r7.getText()
            if (r8 == r0) goto L_0x004f
            if (r8 != 0) goto L_0x000f
            int r1 = r0.length()
            if (r1 != 0) goto L_0x000f
            goto L_0x004f
        L_0x000f:
            boolean r1 = r8 instanceof android.text.Spanned
            if (r1 == 0) goto L_0x001a
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004c
            return
        L_0x001a:
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r0 != 0) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r3 == r4) goto L_0x0029
            goto L_0x0044
        L_0x0029:
            if (r8 != 0) goto L_0x002c
            goto L_0x0049
        L_0x002c:
            int r3 = r8.length()
            int r4 = r0.length()
            if (r3 == r4) goto L_0x0037
            goto L_0x0044
        L_0x0037:
            r4 = 0
        L_0x0038:
            if (r4 >= r3) goto L_0x0049
            char r5 = r8.charAt(r4)
            char r6 = r0.charAt(r4)
            if (r5 == r6) goto L_0x0046
        L_0x0044:
            r1 = 1
            goto L_0x0049
        L_0x0046:
            int r4 = r4 + 1
            goto L_0x0038
        L_0x0049:
            if (r1 != 0) goto L_0x004c
            return
        L_0x004c:
            r7.setText(r8)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.CompoundButtonCompat.setText(android.widget.TextView, java.lang.CharSequence):void");
    }

    public static void setTextAppearance(TextView textView, int i) {
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!sSetWindowLayoutTypeMethodAttempted) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                sSetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sSetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }

    public static int stateToInt(WorkInfo$State workInfo$State) {
        int ordinal = workInfo$State.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    i = 4;
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + workInfo$State + " to int");
                    }
                }
            }
        }
        return i;
    }

    public static final Key<String> stringKey(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new Key<>(str);
    }

    public static Callback wrapCustomSelectionActionModeCallback(TextView textView, Callback callback) {
        int i = VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof TextViewCompat$OreoCallback) || callback == null) ? callback : new TextViewCompat$OreoCallback(callback, textView);
    }

    public static Size a(StreamConfigurationMap streamConfigurationMap, int i, int i2, float f2) {
        ArrayList arrayList = new ArrayList(Arrays.asList(streamConfigurationMap.getOutputSizes(SurfaceTexture.class)));
        Collections.sort(arrayList, new c$a((int) (f2 * 1000000.0f)));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.getWidth() * i == size.getHeight() * i2) {
                return size;
            }
        }
        return null;
    }

    public static void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(f957b.a("events"));
            jSONArray.put(str);
            f957b.a("events", jSONArray.toString());
        } catch (JSONException e2) {
            Timber.TREE_OF_SOULS.e(e2, "RecordManager:addEvent failed for event: %s", str);
            c cVar = f957b;
            synchronized (cVar) {
                Editor edit = cVar.f2811a.edit();
                edit.remove("events");
                edit.apply();
            }
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!(i3 == 90 || i3 == 270)) {
            int i4 = i2;
            i2 = i;
            i = i4;
        }
        int i5 = i;
        int i6 = i2;
        YuvImage yuvImage = new YuvImage(bArr, 17, i5, i6, null);
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i3);
        Bitmap.createBitmap(decodeByteArray, 0, 0, i5, i6, matrix, false).compress(CompressFormat.JPEG, 90, byteArrayOutputStream2);
        return byteArrayOutputStream2.toByteArray();
    }

    public static Size a(StreamConfigurationMap streamConfigurationMap, int i, int i2, float f2, boolean z) {
        ArrayList arrayList = new ArrayList(Arrays.asList(streamConfigurationMap.getOutputSizes(35)));
        Collections.sort(arrayList, new c$a((int) (f2 * 1000000.0f)));
        if (z && !arrayList.isEmpty()) {
            return (Size) arrayList.get(0);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.getWidth() * i == size.getHeight() * i2) {
                size + "";
                return size;
            }
        }
        return null;
    }
}
