package com.facebook.internal.security;

import android.util.Base64;
import com.facebook.FacebookSdk;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.squareup.picasso.NetworkRequestHandler;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.security.SecurityHelper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", "", "()V", "OPENID_KEYS_PATH", "", "getOPENID_KEYS_PATH", "()Ljava/lang/String;", "SIGNATURE_ALGORITHM_SHA256", "TIMEOUT_IN_MILLISECONDS", "", "getPublicKeyFromString", "Ljava/security/PublicKey;", "key", "getRawKeyFromEndPoint", "kid", "verify", "", "publicKey", "data", "signature", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OidcSecurityUtil.kt */
public final class OidcSecurityUtil {
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();

    public static final PublicKey getPublicKeyFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        byte[] decode = Base64.decode(CharsKt__CharKt.replace$default(CharsKt__CharKt.replace$default(CharsKt__CharKt.replace$default(str, (String) "\n", (String) "", false, 4), (String) "-----BEGIN PUBLIC KEY-----", (String) "", false, 4), (String) "-----END PUBLIC KEY-----", (String) "", false, 4), 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        Intrinsics.checkNotNullExpressionValue(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX INFO: finally extract failed */
    public static final String getRawKeyFromEndPoint(String str) {
        Intrinsics.checkNotNullParameter(str, "kid");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        URL url = new URL(NetworkRequestHandler.SCHEME_HTTPS, Intrinsics.stringPlus("www.", FacebookSdk.facebookDomain), "/.well-known/oauth/openid/keys/");
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Executor executor = FacebookSdk.getExecutor();
        $$Lambda$1HTM35dyOhHNZ_OIQoY2VU90i3g r1 = new Runnable(url, ref$ObjectRef, str, reentrantLock, newCondition) {
            public final /* synthetic */ URL f$0;
            public final /* synthetic */ Ref$ObjectRef f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ ReentrantLock f$3;
            public final /* synthetic */ Condition f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                OidcSecurityUtil.m227getRawKeyFromEndPoint$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
            }
        };
        executor.execute(r1);
        reentrantLock.lock();
        try {
            newCondition.await(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) ref$ObjectRef.element;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: getRawKeyFromEndPoint$lambda-1  reason: not valid java name */
    public static final void m227getRawKeyFromEndPoint$lambda1(URL url, Ref$ObjectRef ref$ObjectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        Intrinsics.checkNotNullParameter(url, "$openIdKeyUrl");
        Intrinsics.checkNotNullParameter(ref$ObjectRef, "$result");
        Intrinsics.checkNotNullParameter(str, "$kid");
        Intrinsics.checkNotNullParameter(reentrantLock, "$lock");
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
        if (uRLConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                String readText = TweetUtils.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                httpURLConnection.getInputStream().close();
                ref$ObjectRef.element = new JSONObject(readText).optString(str);
                httpURLConnection.disconnect();
                reentrantLock.lock();
                try {
                    condition.signal();
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (Exception e2) {
                try {
                    INSTANCE.getClass().getName();
                    String message = e2.getMessage();
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                } catch (Throwable th2) {
                    httpURLConnection.disconnect();
                    reentrantLock.lock();
                    condition.signal();
                    throw th2;
                } finally {
                    reentrantLock.unlock();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
    }

    public static final boolean verify(PublicKey publicKey, String str, String str2) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, "signature");
        try {
            Signature instance = Signature.getInstance(SecurityHelper.SHA_256_RSA);
            instance.initVerify(publicKey);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] decode = Base64.decode(str2, 8);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(signature, Base64.URL_SAFE)");
            return instance.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }
}
