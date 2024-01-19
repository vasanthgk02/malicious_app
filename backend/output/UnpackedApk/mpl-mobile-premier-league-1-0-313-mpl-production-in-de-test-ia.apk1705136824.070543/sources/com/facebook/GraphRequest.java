package com.facebook;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat.CarExtender;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.Companion;
import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.netcore.android.notification.SMTNotificationConstants;
import com.paynimo.android.payment.util.Constant;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.game.QuickGameJoinRequest;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 `2\u00020\u0001:\t^_`abcdefBO\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rB\u0019\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010F\u001a\u00020GH\u0002J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020NJ\n\u0010O\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010P\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0002J\b\u0010R\u001a\u00020\u001eH\u0002J\b\u0010S\u001a\u00020\u001eH\u0002J$\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020V2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Y0XH\u0002J\u000e\u0010Z\u001a\u00020G2\u0006\u0010[\u001a\u00020\u001eJ\b\u0010\\\u001a\u00020\u001eH\u0002J\b\u0010]\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u0016\u00100\u001a\u0004\u0018\u00010\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0017R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u001c\u0010=\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bC\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0017\"\u0004\bE\u0010\u0019¨\u0006g"}, d2 = {"Lcom/facebook/GraphRequest;", "", "accessToken", "Lcom/facebook/AccessToken;", "graphPath", "", "parameters", "Landroid/os/Bundle;", "httpMethod", "Lcom/facebook/HttpMethod;", "callback", "Lcom/facebook/GraphRequest$Callback;", "version", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "overriddenURL", "Ljava/net/URL;", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "batchEntryDependsOn", "getBatchEntryDependsOn", "()Ljava/lang/String;", "setBatchEntryDependsOn", "(Ljava/lang/String;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryOmitResultOnSuccess", "", "getBatchEntryOmitResultOnSuccess", "()Z", "setBatchEntryOmitResultOnSuccess", "(Z)V", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "forceApplicationRequest", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "getGraphPath", "setGraphPath", "graphPathWithVersion", "getGraphPathWithVersion", "value", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "relativeUrlForBatchedRequest", "getRelativeUrlForBatchedRequest", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "urlForSingleRequest", "getUrlForSingleRequest", "getVersion", "setVersion", "addCommonParameters", "", "appendParametersToBaseUrl", "baseUrl", "isBatch", "executeAndWait", "Lcom/facebook/GraphResponse;", "executeAsync", "Lcom/facebook/GraphRequestAsyncTask;", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "getUrlWithGraphPath", "isApplicationRequest", "isValidGraphRequestForDomain", "serializeToBatch", "batch", "Lorg/json/JSONArray;", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "setForceApplicationRequest", "forceOverride", "shouldForceClientTokenForRequest", "toString", "Attachment", "Callback", "Companion", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest {
    public static final Companion Companion = new Companion(null);
    public static final String MIME_BOUNDARY;
    public static final String TAG = "GraphRequest";
    public static volatile String userAgent;
    public static final Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    public AccessToken accessToken;
    public boolean batchEntryOmitResultOnSuccess;
    public Callback callback;
    public boolean forceApplicationRequest;
    public JSONObject graphObject;
    public String graphPath;
    public HttpMethod httpMethod;
    public Bundle parameters;
    public Object tag;
    public String version;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class Attachment {
        public final GraphRequest request;
        public final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            Intrinsics.checkNotNullParameter(graphRequest, "request");
            this.request = graphRequest;
            this.value = obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0007J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010A\u001a\u00020BH\u0007J'\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0002\u0010DJ\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010A\u001a\u00020BH\u0007J!\u0010F\u001a\u00020G2\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0002\u0010HJ\u0016\u0010F\u001a\u00020G2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J$\u0010I\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010J\u001a\u0002082\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\"\u0010K\u001a\u00020G2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010K\u001a\u00020G2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020BH\u0002J\n\u0010P\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010Q\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010U\u001a\u00020T2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020\u0004H\u0002J\u0012\u0010X\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010Z\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J.\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020_2\b\u0010b\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J&\u0010c\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J&\u0010e\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\u001c\u0010f\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010gH\u0007J\u001c\u0010h\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010iH\u0007J@\u0010j\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020 2\u0006\u0010n\u001a\u00020 2\b\u0010o\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010iH\u0007J0\u0010p\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010q\u001a\u0004\u0018\u00010r2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J0\u0010s\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010t\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010{\u001a\u00020|2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010}\u001a\u00020~2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\u0012\u0010\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u0001\u001a\u00030\u00012\u0006\u0010q\u001a\u00020r2\u0006\u0010W\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0002J.\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020TH\u0002JB\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020 2\u0006\u00109\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020TH\u0002J'\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020<0@H\u0001¢\u0006\u0003\b\u0001J+\u0010\u0001\u001a\u00030\u00012\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J%\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020>H\u0002J9\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0E2\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u00010\u0001H\u0002J \u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u000208H\u0001¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010J\u001a\u0002082\u0007\u0010\u0001\u001a\u00020TH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0011\u0010\u0001\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J#\u0010\u0001\u001a\u0002082\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u0002082\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u0018\u0010 \u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0003\b¡\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\n **\u0004\u0018\u00010\u00040\u00048\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u0002R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0016\u00105\u001a\n **\u0004\u0018\u00010606X\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "()V", "ACCEPT_LANGUAGE_HEADER", "", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "TAG", "kotlin.jvm.PlatformType", "getTAG$facebook_core_release$annotations", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "mimeContentType", "getMimeContentType", "()Ljava/lang/String;", "userAgent", "getUserAgent", "versionPattern", "Ljava/util/regex/Pattern;", "createConnection", "Ljava/net/HttpURLConnection;", "url", "Ljava/net/URL;", "executeAndWait", "Lcom/facebook/GraphResponse;", "request", "Lcom/facebook/GraphRequest;", "executeBatchAndWait", "", "requests", "Lcom/facebook/GraphRequestBatch;", "", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "", "executeBatchAsync", "Lcom/facebook/GraphRequestAsyncTask;", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "connection", "executeConnectionAsync", "callbackHandler", "Landroid/os/Handler;", "getBatchAppId", "batch", "getDefaultBatchApplicationId", "getDefaultPhotoPathIfNull", "graphPath", "hasOnProgressCallbacks", "", "isGzipCompressible", "isMeRequest", "path", "isSupportedAttachmentType", "value", "isSupportedParameterType", "newCustomAudienceThirdPartyIdRequest", "accessToken", "Lcom/facebook/AccessToken;", "context", "Landroid/content/Context;", "callback", "Lcom/facebook/GraphRequest$Callback;", "applicationId", "newDeleteObjectRequest", "id", "newGraphPathRequest", "newMeRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMyFriendsRequest", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newPlacesSearchRequest", "location", "Landroid/location/Location;", "radiusInMeters", "resultsLimit", "searchText", "newPostRequest", "graphObject", "Lorg/json/JSONObject;", "newPostRequestWithBundle", "parameters", "Landroid/os/Bundle;", "newUploadPhotoRequest", "image", "Landroid/graphics/Bitmap;", "caption", "params", "photoUri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "parameterToString", "processGraphObject", "", "serializer", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "processGraphObjectProperty", "key", "passByValue", "processRequest", "logger", "Lcom/facebook/internal/Logger;", "numRequests", "outputStream", "Ljava/io/OutputStream;", "shouldUseGzip", "runCallbacks", "responses", "runCallbacks$facebook_core_release", "serializeAttachments", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "Lcom/facebook/GraphRequest$Serializer;", "serializeParameters", "bundle", "serializeRequestsAsJSON", "", "serializeToUrlConnection", "serializeToUrlConnection$facebook_core_release", "setConnectionContentType", "setDefaultBatchApplicationId", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "validateFieldsParamForGetRequests", "validateFieldsParamForGetRequests$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final String access$parameterToString(Companion companion, Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (obj instanceof Date) {
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                Intrinsics.checkNotNullExpressionValue(format, "iso8601DateFormat.format(value)");
                return format;
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }

        /* renamed from: newMeRequest$lambda-0  reason: not valid java name */
        public static final void m132newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(graphResponse.graphObject, graphResponse);
            }
        }

        /* renamed from: runCallbacks$lambda-2  reason: not valid java name */
        public static final void m133runCallbacks$lambda2(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(arrayList, "$callbacks");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "$requests");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
                ((Callback) pair.first).onCompleted((GraphResponse) obj);
            }
            for (com.facebook.GraphRequestBatch.Callback onBatchCompleted : graphRequestBatch.callbacks) {
                onBatchCompleted.onBatchCompleted(graphRequestBatch);
            }
        }

        public final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
            if (uRLConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                if (GraphRequest.userAgent == null) {
                    GraphRequest.userAgent = GeneratedOutlineSupport.outline70(new Object[]{"FBAndroidSDK", "16.0.1"}, 2, "%s.%s", "java.lang.String.format(format, *args)");
                    if (!Utility.isNullOrEmpty((String) null)) {
                        String format = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, null}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                        GraphRequest.userAgent = format;
                    }
                }
                httpURLConnection.setRequestProperty("User-Agent", GraphRequest.userAgent);
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
                httpURLConnection.setChunkedStreamingMode(0);
                return httpURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        public final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
            Throwable th;
            HttpURLConnection httpURLConnection;
            List<GraphResponse> list;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = toHttpConnection(graphRequestBatch);
                th = null;
            } catch (Exception e2) {
                th = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
            if (httpURLConnection != null) {
                try {
                    list = executeConnectionAndWait(httpURLConnection, graphRequestBatch);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    Utility.disconnectQuietly(httpURLConnection2);
                    throw th;
                }
            } else {
                List<GraphRequest> list2 = graphRequestBatch.requests;
                FacebookException facebookException = new FacebookException(th);
                Intrinsics.checkNotNullParameter(list2, "requests");
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list2, 10));
                for (GraphRequest graphResponse : list2) {
                    arrayList.add(new GraphResponse(graphResponse, null, new FacebookRequestError(null, facebookException)));
                }
                runCallbacks$facebook_core_release(graphRequestBatch, arrayList);
                list = arrayList;
            }
            Utility.disconnectQuietly(httpURLConnection);
            return list;
        }

        public final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b3, code lost:
            if ((r3 - r12.lastRefresh.getTime()) > 86400000) goto L_0x00b7;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.facebook.GraphResponse> executeConnectionAndWait(java.net.HttpURLConnection r11, com.facebook.GraphRequestBatch r12) {
            /*
                r10 = this;
                java.lang.String r0 = "connection"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r1 = "requests"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                java.lang.String r2 = "Response <Error>: %s"
                java.lang.String r3 = "Response"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                r0 = 0
                r1 = 1
                r4 = 0
                com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                boolean r5 = com.facebook.FacebookSdk.isFullyInitialized()     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                if (r5 == 0) goto L_0x0039
                int r5 = r11.getResponseCode()     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                r6 = 400(0x190, float:5.6E-43)
                if (r5 < r6) goto L_0x002c
                java.io.InputStream r5 = r11.getErrorStream()     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                goto L_0x0030
            L_0x002c:
                java.io.InputStream r5 = r11.getInputStream()     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
            L_0x0030:
                java.util.List r2 = com.facebook.GraphResponse.createResponsesFromStream$facebook_core_release(r5, r11, r12)     // Catch:{ FacebookException -> 0x0037, Exception -> 0x0035 }
                goto L_0x006e
            L_0x0035:
                r6 = move-exception
                goto L_0x0047
            L_0x0037:
                r6 = move-exception
                goto L_0x005f
            L_0x0039:
                java.lang.String r5 = "GraphRequest can't be used when Facebook SDK isn't fully initialized"
                com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                r6.<init>(r5)     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
                throw r6     // Catch:{ FacebookException -> 0x005c, Exception -> 0x0044, all -> 0x0041 }
            L_0x0041:
                r11 = move-exception
                goto L_0x00ea
            L_0x0044:
                r5 = move-exception
                r6 = r5
                r5 = r0
            L_0x0047:
                com.facebook.internal.Logger$Companion r7 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x00e8 }
                com.facebook.LoggingBehavior r8 = com.facebook.LoggingBehavior.REQUESTS     // Catch:{ all -> 0x00e8 }
                java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e8 }
                r9[r4] = r6     // Catch:{ all -> 0x00e8 }
                r7.log(r8, r3, r2, r9)     // Catch:{ all -> 0x00e8 }
                com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch:{ all -> 0x00e8 }
                r2.<init>(r6)     // Catch:{ all -> 0x00e8 }
                java.util.List r2 = com.facebook.GraphResponse.constructErrorResponses(r12, r11, r2)     // Catch:{ all -> 0x00e8 }
                goto L_0x006e
            L_0x005c:
                r5 = move-exception
                r6 = r5
                r5 = r0
            L_0x005f:
                com.facebook.internal.Logger$Companion r7 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x00e8 }
                com.facebook.LoggingBehavior r8 = com.facebook.LoggingBehavior.REQUESTS     // Catch:{ all -> 0x00e8 }
                java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e8 }
                r9[r4] = r6     // Catch:{ all -> 0x00e8 }
                r7.log(r8, r3, r2, r9)     // Catch:{ all -> 0x00e8 }
                java.util.List r2 = com.facebook.GraphResponse.constructErrorResponses(r12, r11, r6)     // Catch:{ all -> 0x00e8 }
            L_0x006e:
                com.facebook.internal.Utility.closeQuietly(r5)
                com.facebook.internal.Utility.disconnectQuietly(r11)
                int r11 = r12.size()
                int r3 = r2.size()
                if (r11 != r3) goto L_0x00be
                r10.runCallbacks$facebook_core_release(r12, r2)
                com.facebook.AccessTokenManager$Companion r11 = com.facebook.AccessTokenManager.Companion
                com.facebook.AccessTokenManager r11 = r11.getInstance()
                com.facebook.AccessToken r12 = r11.currentAccessTokenField
                if (r12 != 0) goto L_0x008c
                goto L_0x00b6
            L_0x008c:
                long r3 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
                com.facebook.AccessTokenSource r5 = r12.source
                boolean r5 = r5.canExtendToken()
                if (r5 == 0) goto L_0x00b6
                java.util.Date r5 = r11.lastAttemptedTokenExtendDate
                long r5 = r5.getTime()
                long r5 = r3 - r5
                r7 = 3600000(0x36ee80, double:1.7786363E-317)
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 <= 0) goto L_0x00b6
                java.util.Date r12 = r12.lastRefresh
                long r5 = r12.getTime()
                long r3 = r3 - r5
                r5 = 86400000(0x5265c00, double:4.2687272E-316)
                int r12 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r12 <= 0) goto L_0x00b6
                goto L_0x00b7
            L_0x00b6:
                r1 = 0
            L_0x00b7:
                if (r1 != 0) goto L_0x00ba
                goto L_0x00bd
            L_0x00ba:
                r11.refreshCurrentAccessToken(r0)
            L_0x00bd:
                return r2
            L_0x00be:
                com.facebook.FacebookException r12 = new com.facebook.FacebookException
                java.util.Locale r0 = java.util.Locale.US
                r3 = 2
                java.lang.Object[] r5 = new java.lang.Object[r3]
                int r2 = r2.size()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r5[r4] = r2
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                r5[r1] = r11
                java.lang.Object[] r11 = java.util.Arrays.copyOf(r5, r3)
                java.lang.String r1 = "Received %d responses while expecting %d"
                java.lang.String r11 = java.lang.String.format(r0, r1, r11)
                java.lang.String r0 = "java.lang.String.format(locale, format, *args)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
                r12.<init>(r11)
                throw r12
            L_0x00e8:
                r11 = move-exception
                r0 = r5
            L_0x00ea:
                com.facebook.internal.Utility.closeQuietly(r0)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.executeConnectionAndWait(java.net.HttpURLConnection, com.facebook.GraphRequestBatch):java.util.List");
        }

        public final boolean isSupportedAttachmentType(Object obj) {
            return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
        }

        public final boolean isSupportedParameterType(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        public final GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, null, callback, null, 32);
            return graphRequest;
        }

        public final GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
            GraphRequest graphRequest = new GraphRequest(null, QuickGameJoinRequest.KEY_MATCH_EXPRESSION, null, null, new Callback() {
                public final void onCompleted(GraphResponse graphResponse) {
                    Companion.m132newMeRequest$lambda0(GraphJSONObjectCallback.this, graphResponse);
                }
            }, null, 32);
            return graphRequest;
        }

        public final GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback, null, 32);
            graphRequest.graphObject = jSONObject;
            return graphRequest;
        }

        public final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String str, Bundle bundle, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(null, str, bundle, HttpMethod.POST, callback, null, 32);
            return graphRequest;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void processGraphObject(org.json.JSONObject r8, java.lang.String r9, com.facebook.GraphRequest.KeyValueSerializer r10) {
            /*
                r7 = this;
                java.util.regex.Pattern r0 = com.facebook.GraphRequest.versionPattern
                java.util.regex.Matcher r0 = r0.matcher(r9)
                boolean r1 = r0.matches()
                r2 = 1
                if (r1 == 0) goto L_0x0017
                java.lang.String r0 = r0.group(r2)
                java.lang.String r1 = "matcher.group(1)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                goto L_0x0018
            L_0x0017:
                r0 = r9
            L_0x0018:
                r1 = 2
                java.lang.String r3 = "me/"
                r4 = 0
                boolean r3 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r3, r4, r1)
                if (r3 != 0) goto L_0x002d
                java.lang.String r3 = "/me/"
                boolean r0 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r3, r4, r1)
                if (r0 == 0) goto L_0x002b
                goto L_0x002d
            L_0x002b:
                r0 = 0
                goto L_0x002e
            L_0x002d:
                r0 = 1
            L_0x002e:
                if (r0 == 0) goto L_0x0047
                java.lang.String r0 = ":"
                r1 = 6
                int r0 = kotlin.text.CharsKt__CharKt.indexOf$default(r9, r0, r4, r4, r1)
                java.lang.String r3 = "?"
                int r9 = kotlin.text.CharsKt__CharKt.indexOf$default(r9, r3, r4, r4, r1)
                r1 = 3
                if (r0 <= r1) goto L_0x0047
                r1 = -1
                if (r9 == r1) goto L_0x0045
                if (r0 >= r9) goto L_0x0047
            L_0x0045:
                r9 = 1
                goto L_0x0048
            L_0x0047:
                r9 = 0
            L_0x0048:
                java.util.Iterator r0 = r8.keys()
            L_0x004c:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0077
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r8.opt(r1)
                if (r9 == 0) goto L_0x0068
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.CharsKt__CharKt.equals(r1, r5, r2)
                if (r5 == 0) goto L_0x0068
                r5 = 1
                goto L_0x0069
            L_0x0068:
                r5 = 0
            L_0x0069:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
                r7.processGraphObjectProperty(r1, r3, r10, r5)
                goto L_0x004c
            L_0x0077:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        public final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String outline70 = GeneratedOutlineSupport.outline70(new Object[]{str, next}, 2, "%s[%s]", "java.lang.String.format(format, *args)");
                        Object opt = jSONObject.opt(next);
                        Intrinsics.checkNotNullExpressionValue(opt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(outline70, opt, keyValueSerializer, z);
                    }
                } else if (jSONObject.has("id")) {
                    String optString = jSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, optString, keyValueSerializer, z);
                } else if (jSONObject.has("url")) {
                    String optString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, optString2, keyValueSerializer, z);
                } else if (jSONObject.has("fbsdk:create_object")) {
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    processGraphObjectProperty(str, jSONObject2, keyValueSerializer, z);
                }
            } else if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        String format = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                        Object opt2 = jSONArray.opt(i);
                        Intrinsics.checkNotNullExpressionValue(opt2, "jsonArray.opt(i)");
                        processGraphObjectProperty(format, opt2, keyValueSerializer, z);
                        if (i2 < length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, obj.toString());
            } else if (Date.class.isAssignableFrom(cls)) {
                String format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                Intrinsics.checkNotNullExpressionValue(format2, "iso8601DateFormat.format(date)");
                keyValueSerializer.writeString(str, format2);
            } else {
                String str2 = GraphRequest.TAG;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                boolean z2 = FacebookSdk.isDebugEnabledField;
            }
        }

        public final void processRequest(GraphRequestBatch<GraphRequest> graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
            String applicationId;
            Serializer serializer = new Serializer(outputStream, logger, z);
            if (i == 1) {
                GraphRequest graphRequest = graphRequestBatch.get(0);
                HashMap hashMap = new HashMap();
                for (String str : graphRequest.parameters.keySet()) {
                    Object obj = graphRequest.parameters.get(str);
                    if (isSupportedAttachmentType(obj)) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        hashMap.put(str, new Attachment(graphRequest, obj));
                    }
                }
                if (logger != null) {
                    logger.append("  Parameters:\n");
                }
                Bundle bundle = graphRequest.parameters;
                for (String str2 : bundle.keySet()) {
                    Object obj2 = bundle.get(str2);
                    if (isSupportedParameterType(obj2)) {
                        Intrinsics.checkNotNullExpressionValue(str2, "key");
                        serializer.writeObject(str2, obj2, graphRequest);
                    }
                }
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap, serializer);
                JSONObject jSONObject = graphRequest.graphObject;
                if (jSONObject != null) {
                    String path = url.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "url.path");
                    processGraphObject(jSONObject, path, serializer);
                    return;
                }
                return;
            }
            Iterator it = graphRequestBatch.iterator();
            while (true) {
                if (!it.hasNext()) {
                    GraphRequest.access$getDefaultBatchApplicationId$cp();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    applicationId = FacebookSdk.getApplicationId();
                    break;
                }
                AccessToken accessToken = ((GraphRequest) it.next()).accessToken;
                if (accessToken != null) {
                    applicationId = accessToken.applicationId;
                    break;
                }
            }
            if (!(applicationId.length() == 0)) {
                serializer.writeString("batch_app_id", applicationId);
                HashMap hashMap2 = new HashMap();
                JSONArray jSONArray = new JSONArray();
                for (GraphRequest access$serializeToBatch : graphRequestBatch) {
                    GraphRequest.access$serializeToBatch(access$serializeToBatch, jSONArray, hashMap2);
                }
                Intrinsics.checkNotNullParameter("batch", "key");
                Intrinsics.checkNotNullParameter(jSONArray, "requestJsonArray");
                Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
                OutputStream outputStream2 = serializer.outputStream;
                if (!(outputStream2 instanceof RequestOutputStream)) {
                    String jSONArray2 = jSONArray.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray2, "requestJsonArray.toString()");
                    serializer.writeString("batch", jSONArray2);
                } else {
                    RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream2;
                    serializer.writeContentDisposition("batch", null, null);
                    serializer.write("[", new Object[0]);
                    int i2 = 0;
                    for (GraphRequest currentRequest : graphRequestBatch) {
                        int i3 = i2 + 1;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        requestOutputStream.setCurrentRequest(currentRequest);
                        if (i2 > 0) {
                            serializer.write(",%s", jSONObject2.toString());
                        } else {
                            serializer.write("%s", jSONObject2.toString());
                        }
                        i2 = i3;
                    }
                    serializer.write(CMapParser.MARK_END_OF_ARRAY, new Object[0]);
                    Logger logger2 = serializer.logger;
                    if (logger2 != null) {
                        String stringPlus = Intrinsics.stringPlus("    ", "batch");
                        String jSONArray3 = jSONArray.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONArray3, "requestJsonArray.toString()");
                        logger2.appendKeyValue(stringPlus, jSONArray3);
                    }
                }
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap2, serializer);
                return;
            }
            throw new FacebookException((String) "App ID was not specified at the request or Settings.");
        }

        public final void runCallbacks$facebook_core_release(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Intrinsics.checkNotNullParameter(list, "responses");
            int size = graphRequestBatch.size();
            ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    GraphRequest graphRequest = graphRequestBatch.get(i);
                    if (graphRequest.callback != null) {
                        arrayList.add(new Pair(graphRequest.callback, list.get(i)));
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            if (arrayList.size() > 0) {
                $$Lambda$Y9ClkEO2jB3Ez79N0KyBCeVTII r8 = new Runnable(arrayList, graphRequestBatch) {
                    public final /* synthetic */ ArrayList f$0;
                    public final /* synthetic */ GraphRequestBatch f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Companion.m133runCallbacks$lambda2(this.f$0, this.f$1);
                    }
                };
                Handler handler = graphRequestBatch.callbackHandler;
                if (handler == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(handler.post(r8));
                }
                if (bool == null) {
                    r8.run();
                }
            }
        }

        public final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
            for (Entry next : map.entrySet()) {
                if (GraphRequest.Companion.isSupportedAttachmentType(((Attachment) next.getValue()).value)) {
                    serializer.writeObject((String) next.getKey(), ((Attachment) next.getValue()).value, ((Attachment) next.getValue()).request);
                }
            }
        }

        /* JADX WARNING: type inference failed for: r1v2 */
        /* JADX WARNING: type inference failed for: r2v5, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r1v3 */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v7, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
        /* JADX WARNING: type inference failed for: r1v4 */
        /* JADX WARNING: type inference failed for: r15v5, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r6v7, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r2v15 */
        /* JADX WARNING: type inference failed for: r4v3, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: type inference failed for: r15v9, types: [java.util.zip.GZIPOutputStream] */
        /* JADX WARNING: type inference failed for: r1v7 */
        /* JADX WARNING: type inference failed for: r1v8 */
        /* JADX WARNING: type inference failed for: r1v9 */
        /* JADX WARNING: type inference failed for: r2v29 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x012c, code lost:
            r3 = true;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0168  */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch r14, java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
            /*
                r13 = this;
                java.lang.String r0 = "requests"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "connection"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                com.facebook.internal.Logger r0 = new com.facebook.internal.Logger
                com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.REQUESTS
                java.lang.String r2 = "Request"
                r0.<init>(r1, r2)
                int r10 = r14.size()
                java.util.Iterator r1 = r14.iterator()
            L_0x001b:
                boolean r2 = r1.hasNext()
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x004d
                java.lang.Object r2 = r1.next()
                com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2
                android.os.Bundle r5 = r2.parameters
                java.util.Set r5 = r5.keySet()
                java.util.Iterator r5 = r5.iterator()
            L_0x0033:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x001b
                java.lang.Object r6 = r5.next()
                java.lang.String r6 = (java.lang.String) r6
                android.os.Bundle r7 = r2.parameters
                java.lang.Object r6 = r7.get(r6)
                boolean r6 = r13.isSupportedAttachmentType(r6)
                if (r6 == 0) goto L_0x0033
                r11 = 0
                goto L_0x004e
            L_0x004d:
                r11 = 1
            L_0x004e:
                r1 = 0
                if (r10 != r4) goto L_0x0058
                com.facebook.GraphRequest r2 = r14.get(r3)
                com.facebook.HttpMethod r2 = r2.httpMethod
                goto L_0x0059
            L_0x0058:
                r2 = r1
            L_0x0059:
                if (r2 != 0) goto L_0x005d
                com.facebook.HttpMethod r2 = com.facebook.HttpMethod.POST
            L_0x005d:
                java.lang.String r5 = r2.name()
                r15.setRequestMethod(r5)
                java.lang.String r5 = "Content-Type"
                if (r11 == 0) goto L_0x0075
                java.lang.String r6 = "application/x-www-form-urlencoded"
                r15.setRequestProperty(r5, r6)
                java.lang.String r6 = "Content-Encoding"
                java.lang.String r7 = "gzip"
                r15.setRequestProperty(r6, r7)
                goto L_0x008d
            L_0x0075:
                java.lang.Object[] r6 = new java.lang.Object[r4]
                java.lang.String r7 = com.facebook.GraphRequest.MIME_BOUNDARY
                r6[r3] = r7
                java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r4)
                java.lang.String r7 = "multipart/form-data; boundary=%s"
                java.lang.String r6 = java.lang.String.format(r7, r6)
                java.lang.String r7 = "java.lang.String.format(format, *args)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                r15.setRequestProperty(r5, r6)
            L_0x008d:
                java.net.URL r12 = r15.getURL()
                java.lang.String r6 = "Request:\n"
                r0.append(r6)
                java.lang.String r6 = r14.id
                java.lang.String r7 = "Id"
                r0.appendKeyValue(r7, r6)
                java.lang.String r6 = "url"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
                java.lang.String r6 = "URL"
                r0.appendKeyValue(r6, r12)
                java.lang.String r6 = r15.getRequestMethod()
                java.lang.String r7 = "connection.requestMethod"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                java.lang.String r7 = "Method"
                r0.appendKeyValue(r7, r6)
                java.lang.String r6 = "User-Agent"
                java.lang.String r7 = r15.getRequestProperty(r6)
                java.lang.String r8 = "connection.getRequestProperty(\"User-Agent\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                r0.appendKeyValue(r6, r7)
                java.lang.String r6 = r15.getRequestProperty(r5)
                java.lang.String r7 = "connection.getRequestProperty(\"Content-Type\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                r0.appendKeyValue(r5, r6)
                int r5 = r14.timeoutInMilliseconds
                r15.setConnectTimeout(r5)
                int r5 = r14.timeoutInMilliseconds
                r15.setReadTimeout(r5)
                com.facebook.HttpMethod r5 = com.facebook.HttpMethod.POST
                if (r2 != r5) goto L_0x00df
                r2 = 1
                goto L_0x00e0
            L_0x00df:
                r2 = 0
            L_0x00e0:
                if (r2 != 0) goto L_0x00e6
                r0.log()
                return
            L_0x00e6:
                r15.setDoOutput(r4)
                java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0163 }
                java.io.OutputStream r15 = r15.getOutputStream()     // Catch:{ all -> 0x0163 }
                r2.<init>(r15)     // Catch:{ all -> 0x0163 }
                if (r11 == 0) goto L_0x00fe
                java.util.zip.GZIPOutputStream r15 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x00fb }
                r15.<init>(r2)     // Catch:{ all -> 0x00fb }
                r1 = r15
                goto L_0x00ff
            L_0x00fb:
                r14 = move-exception
                goto L_0x0165
            L_0x00fe:
                r1 = r2
            L_0x00ff:
                java.util.List<com.facebook.GraphRequestBatch$Callback> r15 = r14.callbacks     // Catch:{ all -> 0x0163 }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x0163 }
            L_0x0105:
                boolean r2 = r15.hasNext()     // Catch:{ all -> 0x0163 }
                if (r2 == 0) goto L_0x0116
                java.lang.Object r2 = r15.next()     // Catch:{ all -> 0x0163 }
                com.facebook.GraphRequestBatch$Callback r2 = (com.facebook.GraphRequestBatch.Callback) r2     // Catch:{ all -> 0x0163 }
                boolean r2 = r2 instanceof com.facebook.GraphRequestBatch.OnProgressCallback     // Catch:{ all -> 0x0163 }
                if (r2 == 0) goto L_0x0105
                goto L_0x012c
            L_0x0116:
                java.util.Iterator r15 = r14.iterator()     // Catch:{ all -> 0x0163 }
            L_0x011a:
                boolean r2 = r15.hasNext()     // Catch:{ all -> 0x0163 }
                if (r2 == 0) goto L_0x012d
                java.lang.Object r2 = r15.next()     // Catch:{ all -> 0x0163 }
                com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2     // Catch:{ all -> 0x0163 }
                com.facebook.GraphRequest$Callback r2 = r2.callback     // Catch:{ all -> 0x0163 }
                boolean r2 = r2 instanceof com.facebook.GraphRequest.OnProgressCallback     // Catch:{ all -> 0x0163 }
                if (r2 == 0) goto L_0x011a
            L_0x012c:
                r3 = 1
            L_0x012d:
                if (r3 == 0) goto L_0x014e
                com.facebook.ProgressNoopOutputStream r15 = new com.facebook.ProgressNoopOutputStream     // Catch:{ all -> 0x0163 }
                android.os.Handler r2 = r14.callbackHandler     // Catch:{ all -> 0x0163 }
                r15.<init>(r2)     // Catch:{ all -> 0x0163 }
                r5 = 0
                r3 = r13
                r4 = r14
                r6 = r10
                r7 = r12
                r8 = r15
                r9 = r11
                r3.processRequest(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0163 }
                int r2 = r15.maxProgress     // Catch:{ all -> 0x0163 }
                java.util.Map<com.facebook.GraphRequest, com.facebook.RequestProgress> r6 = r15.progressMap     // Catch:{ all -> 0x0163 }
                com.facebook.ProgressOutputStream r15 = new com.facebook.ProgressOutputStream     // Catch:{ all -> 0x0163 }
                long r7 = (long) r2     // Catch:{ all -> 0x0163 }
                r3 = r15
                r4 = r1
                r5 = r14
                r3.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x0163 }
                goto L_0x014f
            L_0x014e:
                r15 = r1
            L_0x014f:
                r1 = r13
                r2 = r14
                r3 = r0
                r4 = r10
                r5 = r12
                r6 = r15
                r7 = r11
                r1.processRequest(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0160 }
                r15.close()
                r0.log()
                return
            L_0x0160:
                r14 = move-exception
                r2 = r15
                goto L_0x0165
            L_0x0163:
                r14 = move-exception
                r2 = r1
            L_0x0165:
                if (r2 != 0) goto L_0x0168
                goto L_0x016b
            L_0x0168:
                r2.close()
            L_0x016b:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        public final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
            URL url;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                if (HttpMethod.GET == graphRequest.httpMethod && Utility.isNullOrEmpty(graphRequest.parameters.getString("fields"))) {
                    com.facebook.internal.Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("GET requests for /");
                    String str = graphRequest.graphPath;
                    if (str == null) {
                        str = "";
                    }
                    companion.log(loggingBehavior, 5, (String) "Request", GeneratedOutlineSupport.outline62(outline73, str, " should contain an explicit \"fields\" parameter."));
                }
            }
            try {
                if (graphRequestBatch.size() == 1) {
                    url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
                } else {
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e2) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e2);
                } catch (JSONException e3) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e3);
                }
            } catch (MalformedURLException e4) {
                throw new FacebookException("could not construct URL for request", e4);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "onCompleted", "", "obj", "Lorg/json/JSONObject;", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bâ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "onProgress", "", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u0015*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", "", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType<?>> CREATOR = new GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1();
        public final String mimeType;
        public final RESOURCE resource;

        public ParcelableResourceWithMimeType(RESOURCE resource2, String str) {
            this.mimeType = str;
            this.resource = resource2;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this.mimeType = parcel.readString();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0012J \u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0012J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u0012J+\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0010J$\u0010/\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020-03J\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u00060\u000bj\u0002`\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "outputStream", "Ljava/io/OutputStream;", "logger", "Lcom/facebook/internal/Logger;", "useUrlEncode", "", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "firstWrite", "invalidTypeError", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "write", "", "format", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeBitmap", "key", "bitmap", "Landroid/graphics/Bitmap;", "writeBytes", "bytes", "", "writeContentDisposition", "name", "filename", "contentType", "writeContentUri", "contentUri", "Landroid/net/Uri;", "mimeType", "writeFile", "descriptor", "Landroid/os/ParcelFileDescriptor;", "writeLine", "writeObject", "value", "request", "Lcom/facebook/GraphRequest;", "writeRecordBoundary", "writeRequestsAsJson", "requestJsonArray", "Lorg/json/JSONArray;", "requests", "", "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class Serializer implements KeyValueSerializer {
        public boolean firstWrite = true;
        public final Logger logger;
        public final OutputStream outputStream;
        public final boolean useUrlEncode;

        public Serializer(OutputStream outputStream2, Logger logger2, boolean z) {
            Intrinsics.checkNotNullParameter(outputStream2, "outputStream");
            this.outputStream = outputStream2;
            this.logger = logger2;
            this.useUrlEncode = z;
        }

        public final void write(String str, Object... objArr) {
            Intrinsics.checkNotNullParameter(str, "format");
            Intrinsics.checkNotNullParameter(objArr, "args");
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    OutputStream outputStream2 = this.outputStream;
                    byte[] bytes = "--".getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream2.write(bytes);
                    OutputStream outputStream3 = this.outputStream;
                    String str2 = GraphRequest.MIME_BOUNDARY;
                    Charset charset = Charsets.UTF_8;
                    if (str2 != null) {
                        byte[] bytes2 = str2.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream3.write(bytes2);
                        OutputStream outputStream4 = this.outputStream;
                        byte[] bytes3 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                        outputStream4.write(bytes3);
                        this.firstWrite = false;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                OutputStream outputStream5 = this.outputStream;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                byte[] bytes4 = GeneratedOutlineSupport.outline70(copyOf, copyOf.length, str, "java.lang.String.format(format, *args)").getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream5.write(bytes4);
                return;
            }
            OutputStream outputStream6 = this.outputStream;
            Locale locale = Locale.US;
            Object[] copyOf2 = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(locale, str, Arrays.copyOf(copyOf2, copyOf2.length));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            String encode = URLEncoder.encode(format, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
            byte[] bytes5 = encode.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream6.write(bytes5);
        }

        public final void writeContentDisposition(String str, String str2, String str3) {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", "Content-Type", str3);
                }
                writeLine("", new Object[0]);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            byte[] bytes = GeneratedOutlineSupport.outline70(new Object[]{str}, 1, "%s=", "java.lang.String.format(format, *args)").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream2.write(bytes);
        }

        public final void writeContentUri(String str, Uri uri, String str2) {
            int i;
            long j;
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(uri, "contentUri");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                Intrinsics.checkNotNullParameter(uri, "contentUri");
                Cursor cursor = null;
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    Cursor query = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
                    if (query == null) {
                        j = 0;
                    } else {
                        int columnIndex = query.getColumnIndex("_size");
                        query.moveToFirst();
                        long j2 = query.getLong(columnIndex);
                        query.close();
                        j = j2;
                    }
                    ((ProgressNoopOutputStream) this.outputStream).addProgress(j);
                    i = 0;
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(stringPlus, format);
            }
        }

        public final void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(parcelFileDescriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream2).addProgress(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(new AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(stringPlus, format);
            }
        }

        public final void writeLine(String str, Object... objArr) {
            Intrinsics.checkNotNullParameter(str, "format");
            Intrinsics.checkNotNullParameter(objArr, "args");
            write(str, Arrays.copyOf(objArr, objArr.length));
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }

        public final void writeObject(String str, Object obj, GraphRequest graphRequest) {
            Intrinsics.checkNotNullParameter(str, "key");
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof RequestOutputStream) {
                ((RequestOutputStream) outputStream2).setCurrentRequest(graphRequest);
            }
            if (GraphRequest.Companion.isSupportedParameterType(obj)) {
                writeString(str, Companion.access$parameterToString(GraphRequest.Companion, obj));
            } else if (obj instanceof Bitmap) {
                Bitmap bitmap = (Bitmap) obj;
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                writeContentDisposition(str, str, "image/png");
                bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
                writeLine("", new Object[0]);
                writeRecordBoundary();
                Logger logger2 = this.logger;
                if (logger2 != null) {
                    logger2.appendKeyValue(Intrinsics.stringPlus("    ", str), "<Image>");
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(bArr, "bytes");
                writeContentDisposition(str, str, "content/unknown");
                this.outputStream.write(bArr);
                writeLine("", new Object[0]);
                writeRecordBoundary();
                Logger logger3 = this.logger;
                if (logger3 != null) {
                    String stringPlus = Intrinsics.stringPlus("    ", str);
                    String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                    logger3.appendKeyValue(stringPlus, format);
                }
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                RESOURCE resource = parcelableResourceWithMimeType.resource;
                String str2 = parcelableResourceWithMimeType.mimeType;
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, str2);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, str2);
                } else {
                    throw new IllegalArgumentException("value is not a supported type.");
                }
            } else {
                throw new IllegalArgumentException("value is not a supported type.");
            }
        }

        public final void writeRecordBoundary() {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            byte[] bytes = "&".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream2.write(bytes);
        }

        public void writeString(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, HSLCriteriaBuilder.VALUE);
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.appendKeyValue(Intrinsics.stringPlus("    ", str), str2);
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        if (nextInt > 0) {
            int i = 0;
            do {
                i++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i < nextInt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "buffer.toString()");
        MIME_BOUNDARY = sb2;
    }

    public GraphRequest() {
        this(null, null, null, null, null, null, 63);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2, String str2, int i) {
        accessToken2 = (i & 1) != 0 ? null : accessToken2;
        str = (i & 2) != 0 ? null : str;
        bundle = (i & 4) != 0 ? null : bundle;
        httpMethod2 = (i & 8) != 0 ? null : httpMethod2;
        callback2 = (i & 16) != 0 ? null : callback2;
        int i2 = i & 32;
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken2;
        this.graphPath = str;
        this.version = null;
        setCallback(callback2);
        setHttpMethod(httpMethod2);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    /* renamed from: _set_callback_$lambda-0  reason: not valid java name */
    public static final void m131_set_callback_$lambda0(Callback callback2, GraphResponse graphResponse) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str;
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        JSONObject jSONObject2 = graphResponse.graphObject;
        if (jSONObject2 == null) {
            jSONObject = null;
        } else {
            jSONObject = jSONObject2.optJSONObject("__debug__");
        }
        if (jSONObject == null) {
            jSONArray = null;
        } else {
            jSONArray = jSONObject.optJSONArray(CarExtender.KEY_MESSAGES);
        }
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject == null) {
                        str = null;
                    } else {
                        str = optJSONObject.optString("message");
                    }
                    if (optJSONObject == null) {
                        obj = null;
                    } else {
                        obj = optJSONObject.optString("type");
                    }
                    if (optJSONObject == null) {
                        str2 = null;
                    } else {
                        str2 = optJSONObject.optString("link");
                    }
                    if (!(str == null || obj == null)) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (Intrinsics.areEqual(obj, "warning")) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!Utility.isNullOrEmpty(str2)) {
                            str = str + " Link: " + str2;
                        }
                        com.facebook.internal.Logger.Companion companion = Logger.Companion;
                        Intrinsics.checkNotNullExpressionValue(TAG, UeCustomType.TAG);
                        companion.log(loggingBehavior, TAG, str);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        if (callback2 != null) {
            callback2.onCompleted(graphResponse);
        }
    }

    public static final /* synthetic */ String access$getDefaultBatchApplicationId$cp() {
        return null;
    }

    public static final void access$serializeToBatch(GraphRequest graphRequest, JSONArray jSONArray, Map map) {
        if (graphRequest != null) {
            JSONObject jSONObject = new JSONObject();
            String urlWithGraphPath = graphRequest.getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
            graphRequest.addCommonParameters();
            Uri parse = Uri.parse(graphRequest.appendParametersToBaseUrl(urlWithGraphPath, true));
            String format = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            jSONObject.put("relative_url", format);
            jSONObject.put(AnalyticsConstants.METHOD, graphRequest.httpMethod);
            AccessToken accessToken2 = graphRequest.accessToken;
            if (accessToken2 != null) {
                Logger.Companion.registerAccessToken(accessToken2.token);
            }
            ArrayList arrayList = new ArrayList();
            for (String str : graphRequest.parameters.keySet()) {
                Object obj = graphRequest.parameters.get(str);
                if ((obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType)) {
                    String format2 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                    arrayList.add(format2);
                    map.put(format2, new Attachment(graphRequest, obj));
                }
            }
            if (!arrayList.isEmpty()) {
                jSONObject.put("attached_files", TextUtils.join(",", arrayList));
            }
            JSONObject jSONObject2 = graphRequest.graphObject;
            if (jSONObject2 != null) {
                ArrayList arrayList2 = new ArrayList();
                Companion.processGraphObject(jSONObject2, format, new GraphRequest$serializeToBatch$1(arrayList2));
                jSONObject.put(SMTNotificationConstants.NOTIF_BODY_KEY, TextUtils.join("&", arrayList2));
            }
            jSONArray.put(jSONObject);
            return;
        }
        throw null;
    }

    public final void addCommonParameters() {
        boolean z;
        Bundle bundle = this.parameters;
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        boolean z2 = false;
        if (accessTokenToUseForRequest == null) {
            z = false;
        } else {
            z = CharsKt__CharKt.contains$default((CharSequence) accessTokenToUseForRequest, (CharSequence) "|", false, 2);
        }
        if (((accessTokenToUseForRequest != null && CharsKt__CharKt.startsWith$default(accessTokenToUseForRequest, (String) "IG", false, 2) && !z) && isApplicationRequest()) || (!isValidGraphRequestForDomain() && !z)) {
            z2 = true;
        }
        if (z2) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest2 = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest2 != null) {
                bundle.putString("access_token", accessTokenToUseForRequest2);
            }
        }
        if (!bundle.containsKey("access_token")) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            boolean isNullOrEmpty = Utility.isNullOrEmpty(FacebookSdk.getClientToken());
        }
        bundle.putString("sdk", "android");
        bundle.putString("format", "json");
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString("debug", "info");
            return;
        }
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString("debug", "warning");
        }
    }

    public final String appendParametersToBaseUrl(String str, boolean z) {
        String str2;
        if (!z && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str3 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str3);
            if (obj == null) {
                obj = "";
            }
            boolean z2 = obj instanceof String;
            if (z2 || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date)) {
                if (z2) {
                    str2 = (String) obj;
                } else if ((obj instanceof Boolean) || (obj instanceof Number)) {
                    str2 = obj.toString();
                } else if (obj instanceof Date) {
                    str2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                    Intrinsics.checkNotNullExpressionValue(str2, "iso8601DateFormat.format(value)");
                } else {
                    throw new IllegalArgumentException("Unsupported parameter type.");
                }
                buildUpon.appendQueryParameter(str3, str2.toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                String format = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format);
            }
        }
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "uriBuilder.toString()");
        return builder;
    }

    public final GraphResponse executeAndWait() {
        Companion companion = Companion;
        Intrinsics.checkNotNullParameter(this, "request");
        GraphRequest[] graphRequestArr = {this};
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
        List list = TweetUtils.toList(graphRequestArr);
        Intrinsics.checkNotNullParameter(list, "requests");
        List<GraphResponse> executeBatchAndWait = companion.executeBatchAndWait(new GraphRequestBatch((Collection<GraphRequest>) list));
        if (executeBatchAndWait.size() == 1) {
            return executeBatchAndWait.get(0);
        }
        throw new FacebookException((String) "invalid state: expected a single response");
    }

    public final GraphRequestAsyncTask executeAsync() {
        GraphRequest[] graphRequestArr = {this};
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
        List list = TweetUtils.toList(graphRequestArr);
        Intrinsics.checkNotNullParameter(list, "requests");
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch((Collection<GraphRequest>) list);
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    public final String getAccessTokenToUseForRequest() {
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            if (!this.parameters.containsKey("access_token")) {
                String str = accessToken2.token;
                Logger.Companion.registerAccessToken(str);
                return str;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    public final String getClientTokenForRequest() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String clientToken = FacebookSdk.getClientToken();
        boolean z = true;
        if (applicationId.length() > 0) {
            if (clientToken.length() <= 0) {
                z = false;
            }
            if (z) {
                return applicationId + '|' + clientToken;
            }
        }
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        boolean z2 = FacebookSdk.isDebugEnabledField;
        return null;
    }

    public final String getUrlForSingleRequest() {
        String str;
        String str2 = this.graphPath;
        if (this.httpMethod != HttpMethod.POST || str2 == null || !CharsKt__CharKt.endsWith$default(str2, (String) "/videos", false, 2)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String graphDomain = FacebookSdk.getGraphDomain();
            Intrinsics.checkNotNullParameter(graphDomain, "subdomain");
            str = GeneratedOutlineSupport.outline70(new Object[]{graphDomain}, 1, "https://graph.%s", "java.lang.String.format(format, *args)");
        } else {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            str = GeneratedOutlineSupport.outline70(new Object[]{FacebookSdk.getGraphDomain()}, 1, "https://graph-video.%s", "java.lang.String.format(format, *args)");
        }
        String urlWithGraphPath = getUrlWithGraphPath(str);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    public final String getUrlWithGraphPath(String str) {
        String str2;
        if (!isValidGraphRequestForDomain()) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = GeneratedOutlineSupport.outline70(new Object[]{FacebookSdk.facebookDomain}, 1, "https://graph.%s", "java.lang.String.format(format, *args)");
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (versionPattern.matcher(this.graphPath).matches()) {
            str2 = this.graphPath;
        } else {
            str2 = GeneratedOutlineSupport.outline70(new Object[]{this.version, this.graphPath}, 2, "%s/%s", "java.lang.String.format(format, *args)");
        }
        objArr[1] = str2;
        return GeneratedOutlineSupport.outline70(objArr, 2, "%s/%s", "java.lang.String.format(format, *args)");
    }

    public final boolean isApplicationRequest() {
        boolean z = false;
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("^/?");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        outline73.append(FacebookSdk.getApplicationId());
        outline73.append("/?.*");
        String sb = outline73.toString();
        if (this.forceApplicationRequest || Pattern.matches(sb, this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath)) {
            z = true;
        }
        return z;
    }

    public final boolean isValidGraphRequestForDomain() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!Intrinsics.areEqual(FacebookSdk.getGraphDomain(), "instagram.com")) {
            return true;
        }
        return !isApplicationRequest();
    }

    public final void setCallback(Callback callback2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
                this.callback = callback2;
                return;
            }
        }
        this.callback = new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                GraphRequest.m131_set_callback_$lambda0(Callback.this, graphResponse);
            }
        };
    }

    public final void setHttpMethod(HttpMethod httpMethod2) {
        if (httpMethod2 == null) {
            httpMethod2 = HttpMethod.GET;
        }
        this.httpMethod = httpMethod2;
    }

    public final void setParameters(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public String toString() {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("{Request: ", " accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        outline78.append(obj);
        outline78.append(", graphPath: ");
        outline78.append(this.graphPath);
        outline78.append(", graphObject: ");
        outline78.append(this.graphObject);
        outline78.append(", httpMethod: ");
        outline78.append(this.httpMethod);
        outline78.append(", parameters: ");
        outline78.append(this.parameters);
        outline78.append("}");
        String sb = outline78.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return sb;
    }
}
