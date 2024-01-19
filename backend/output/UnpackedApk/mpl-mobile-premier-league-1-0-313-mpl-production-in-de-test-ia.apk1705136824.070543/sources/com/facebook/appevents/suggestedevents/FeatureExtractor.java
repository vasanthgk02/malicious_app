package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import io.sentry.SentryClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.entities.variables.SFSBuddyVariable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u000fH\u0007J)\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010(J0\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J(\u00100\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0002J(\u00109\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010:\u001a\u00060;j\u0002`<2\n\u0010=\u001a\u00060;j\u0002`<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "()V", "NUM_OF_FEATURES", "", "REGEX_ADD_TO_CART_BUTTON_TEXT", "", "REGEX_ADD_TO_CART_PAGE_TITLE", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_CR_PASSWORD_FIELD", "eventInfo", "", "initialized", "", "languageInfo", "rules", "Lorg/json/JSONObject;", "textTypeInfo", "getDenseFeatures", "", "viewHierarchy", "appName", "getInteractedNode", "view", "getTextFeature", "buttonText", "activityName", "initialize", "", "file", "Ljava/io/File;", "isButton", "node", "isInitialized", "matchIndicators", "indicators", "", "values", "([Ljava/lang/String;[Ljava/lang/String;)Z", "nonparseFeatures", "siblings", "Lorg/json/JSONArray;", "screenName", "formFieldsJSON", "parseFeatures", "pruneTree", "regexMatched", "pattern", "matchText", "language", "event", "textType", "sum", "a", "b", "updateHintAndTextRecursively", "textSB", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "hintSB", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FeatureExtractor.kt */
public final class FeatureExtractor {
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    public static Map<String, String> eventInfo;
    public static boolean initialized;
    public static Map<String, String> languageInfo;
    public static JSONObject rules;
    public static Map<String, String> textTypeInfo;

    public static final float[] getDenseFeatures(JSONObject jSONObject, String str) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(jSONObject, "viewHierarchy");
            Intrinsics.checkNotNullParameter(str, "appName");
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            try {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
                String optString = jSONObject.optString("screenname");
                JSONArray jSONArray = new JSONArray();
                INSTANCE.pruneTree(jSONObject2, jSONArray);
                INSTANCE.sum(fArr, INSTANCE.parseFeatures(jSONObject2));
                JSONObject interactedNode = INSTANCE.getInteractedNode(jSONObject2);
                if (interactedNode == null) {
                    return null;
                }
                FeatureExtractor featureExtractor = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(optString, "screenName");
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "viewTree.toString()");
                INSTANCE.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, optString, jSONObject3, lowerCase));
                return fArr;
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getTextFeature(String str, String str2, String str3) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "buttonText");
            Intrinsics.checkNotNullParameter(str2, "activityName");
            Intrinsics.checkNotNullParameter(str3, "appName");
            String str4 = str3 + " | " + str2 + ", " + str;
            if (str4 != null) {
                String lowerCase = str4.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void initialize(File file) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                rules = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, Charsets.UTF_8));
                try {
                    languageInfo = ArraysKt___ArraysJvmKt.mapOf(new Pair("ENGLISH", "1"), new Pair("GERMAN", "2"), new Pair("SPANISH", "3"), new Pair("JAPANESE", "4"));
                    eventInfo = ArraysKt___ArraysJvmKt.mapOf(new Pair("VIEW_CONTENT", "0"), new Pair("SEARCH", "1"), new Pair("ADD_TO_CART", "2"), new Pair("ADD_TO_WISHLIST", "3"), new Pair("INITIATE_CHECKOUT", "4"), new Pair("ADD_PAYMENT_INFO", "5"), new Pair("PURCHASE", "6"), new Pair("LEAD", SentryClient.SENTRY_PROTOCOL_VERSION), new Pair("COMPLETE_REGISTRATION", "8"));
                    textTypeInfo = ArraysKt___ArraysJvmKt.mapOf(new Pair("BUTTON_TEXT", "1"), new Pair("PAGE_TITLE", "2"), new Pair("RESOLVED_DOCUMENT_LINK", "3"), new Pair("BUTTON_ID", "4"));
                    initialized = true;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final JSONObject getInteractedNode(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            if (optJSONArray == null) {
                return null;
            }
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "children.getJSONObject(i)");
                    JSONObject interactedNode = getInteractedNode(jSONObject2);
                    if (interactedNode != null) {
                        return interactedNode;
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return null;
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final boolean matchIndicators(String[] strArr, String[] strArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                int length2 = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String str2 = strArr2[i2];
                        i2++;
                        if (CharsKt__CharKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[Catch:{ JSONException -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[LOOP:1: B:18:0x003c->B:33:0x006e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0072 A[EDGE_INSN: B:95:0x0072->B:34:0x0072 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[] nonparseFeatures(org.json.JSONObject r17, org.json.JSONArray r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r16 = this;
            r1 = r16
            r2 = r20
            java.lang.String r3 = "LEAD"
            java.lang.String r4 = "PURCHASE"
            java.lang.String r5 = "PAGE_TITLE"
            java.lang.String r6 = "BUTTON_TEXT"
            java.lang.String r7 = "COMPLETE_REGISTRATION"
            java.lang.String r8 = "ENGLISH"
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r16)
            r9 = 0
            if (r0 == 0) goto L_0x0018
            return r9
        L_0x0018:
            r0 = 30
            float[] r10 = new float[r0]     // Catch:{ all -> 0x017c }
            r12 = 0
        L_0x001d:
            r13 = 0
            if (r12 >= r0) goto L_0x0025
            r10[r12] = r13     // Catch:{ all -> 0x017c }
            int r12 = r12 + 1
            goto L_0x001d
        L_0x0025:
            int r0 = r18.length()     // Catch:{ all -> 0x017c }
            r12 = 3
            r14 = 1
            r15 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= r14) goto L_0x0032
            float r0 = (float) r0     // Catch:{ all -> 0x017c }
            float r0 = r0 - r15
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            r10[r12] = r0     // Catch:{ all -> 0x017c }
            int r12 = r18.length()     // Catch:{ JSONException -> 0x0072 }
            if (r12 <= 0) goto L_0x0072
            r0 = 0
        L_0x003c:
            int r13 = r0 + 1
            r9 = r18
            org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ JSONException -> 0x0072 }
            java.lang.String r11 = "siblings.getJSONObject(i)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)     // Catch:{ JSONException -> 0x0072 }
            boolean r11 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r16)     // Catch:{ JSONException -> 0x0072 }
            if (r11 == 0) goto L_0x0050
            goto L_0x0061
        L_0x0050:
            java.lang.String r11 = "classtypebitmask"
            int r0 = r0.optInt(r11)     // Catch:{ all -> 0x005d }
            r0 = r0 & r14
            int r0 = r0 << 5
            if (r0 <= 0) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x005d:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1)     // Catch:{ JSONException -> 0x0072 }
        L_0x0061:
            r0 = 0
        L_0x0062:
            if (r0 == 0) goto L_0x006b
            r0 = 9
            r11 = r10[r0]     // Catch:{ JSONException -> 0x0072 }
            float r11 = r11 + r15
            r10[r0] = r11     // Catch:{ JSONException -> 0x0072 }
        L_0x006b:
            if (r13 < r12) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            r0 = r13
            r9 = 0
            r13 = 0
            goto L_0x003c
        L_0x0072:
            r0 = 13
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10[r0] = r9     // Catch:{ all -> 0x017c }
            r0 = 14
            r10[r0] = r9     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r0.<init>()     // Catch:{ all -> 0x017c }
            r9 = r19
            r0.append(r9)     // Catch:{ all -> 0x017c }
            r9 = 124(0x7c, float:1.74E-43)
            r0.append(r9)     // Catch:{ all -> 0x017c }
            r9 = r21
            r0.append(r9)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r9.<init>()     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r11.<init>()     // Catch:{ all -> 0x017c }
            r12 = r17
            r1.updateHintAndTextRecursively(r12, r11, r9)     // Catch:{ all -> 0x017c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x017c }
            java.lang.String r12 = "hintSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)     // Catch:{ all -> 0x017c }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x017c }
            java.lang.String r12 = "textSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ all -> 0x017c }
            r12 = 15
            boolean r13 = r1.regexMatched(r8, r7, r6, r11)     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00c0
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00c1
        L_0x00c0:
            r13 = 0
        L_0x00c1:
            r10[r12] = r13     // Catch:{ all -> 0x017c }
            r12 = 16
            boolean r13 = r1.regexMatched(r8, r7, r5, r0)     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00ce
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00cf
        L_0x00ce:
            r13 = 0
        L_0x00cf:
            r10[r12] = r13     // Catch:{ all -> 0x017c }
            r12 = 17
            java.lang.String r13 = "BUTTON_ID"
            boolean r7 = r1.regexMatched(r8, r7, r13, r9)     // Catch:{ all -> 0x017c }
            if (r7 == 0) goto L_0x00de
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00df
        L_0x00de:
            r7 = 0
        L_0x00df:
            r10[r12] = r7     // Catch:{ all -> 0x017c }
            r7 = 18
            java.lang.String r9 = "password"
            r12 = 2
            r13 = 0
            boolean r9 = kotlin.text.CharsKt__CharKt.contains$default(r2, r9, r13, r12)     // Catch:{ all -> 0x017c }
            if (r9 == 0) goto L_0x00f0
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00f1
        L_0x00f0:
            r9 = 0
        L_0x00f1:
            r10[r7] = r9     // Catch:{ all -> 0x017c }
            r7 = 19
            java.lang.String r9 = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)"
            boolean r9 = r1.regexMatched(r9, r2)     // Catch:{ all -> 0x017c }
            if (r9 == 0) goto L_0x0100
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0101
        L_0x0100:
            r9 = 0
        L_0x0101:
            r10[r7] = r9     // Catch:{ all -> 0x017c }
            r7 = 20
            java.lang.String r9 = "(?i)(sign in)|login|signIn"
            boolean r9 = r1.regexMatched(r9, r2)     // Catch:{ all -> 0x017c }
            if (r9 == 0) goto L_0x0110
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0111
        L_0x0110:
            r9 = 0
        L_0x0111:
            r10[r7] = r9     // Catch:{ all -> 0x017c }
            r7 = 21
            java.lang.String r9 = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)"
            boolean r2 = r1.regexMatched(r9, r2)     // Catch:{ all -> 0x017c }
            if (r2 == 0) goto L_0x0120
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0121
        L_0x0120:
            r2 = 0
        L_0x0121:
            r10[r7] = r2     // Catch:{ all -> 0x017c }
            r2 = 22
            boolean r7 = r1.regexMatched(r8, r4, r6, r11)     // Catch:{ all -> 0x017c }
            if (r7 == 0) goto L_0x012e
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x012f
        L_0x012e:
            r7 = 0
        L_0x012f:
            r10[r2] = r7     // Catch:{ all -> 0x017c }
            r2 = 24
            boolean r4 = r1.regexMatched(r8, r4, r5, r0)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x013c
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x013d
        L_0x013c:
            r4 = 0
        L_0x013d:
            r10[r2] = r4     // Catch:{ all -> 0x017c }
            r2 = 25
            java.lang.String r4 = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart"
            boolean r4 = r1.regexMatched(r4, r11)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x014c
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x014d
        L_0x014c:
            r4 = 0
        L_0x014d:
            r10[r2] = r4     // Catch:{ all -> 0x017c }
            r2 = 27
            java.lang.String r4 = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy"
            boolean r4 = r1.regexMatched(r4, r0)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x015c
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x015d
        L_0x015c:
            r4 = 0
        L_0x015d:
            r10[r2] = r4     // Catch:{ all -> 0x017c }
            r2 = 28
            boolean r4 = r1.regexMatched(r8, r3, r6, r11)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x016a
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x016b
        L_0x016a:
            r4 = 0
        L_0x016b:
            r10[r2] = r4     // Catch:{ all -> 0x017c }
            r2 = 29
            boolean r0 = r1.regexMatched(r8, r3, r5, r0)     // Catch:{ all -> 0x017c }
            if (r0 == 0) goto L_0x0178
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0179
        L_0x0178:
            r13 = 0
        L_0x0179:
            r10[r2] = r13     // Catch:{ all -> 0x017c }
            return r10
        L_0x017c:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.FeatureExtractor.nonparseFeatures(org.json.JSONObject, org.json.JSONArray, java.lang.String, java.lang.String, java.lang.String):float[]");
    }

    public final float[] parseFeatures(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i = 0;
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            String optString = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString, "node.optString(TEXT_KEY)");
            String lowerCase = optString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String optString2 = jSONObject.optString("hint");
            Intrinsics.checkNotNullExpressionValue(optString2, "node.optString(HINT_KEY)");
            String lowerCase2 = optString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String optString3 = jSONObject.optString("classname");
            Intrinsics.checkNotNullExpressionValue(optString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = optString3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int optInt = jSONObject.optInt("inputtype", -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{SFSBuddyVariable.OFFLINE_PREFIX, "amount", ECommerceParamNames.PRICE, ECommerceParamNames.TOTAL}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{"search"}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (optInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (CharsKt__CharKt.contains$default((CharSequence) lowerCase3, (CharSequence) "checkbox", false, 2)) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{AnalyticsConstants.COMPLETE, "confirm", "done", AnalyticsConstants.SUBMIT}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (CharsKt__CharKt.contains$default((CharSequence) lowerCase3, (CharSequence) SMTEventParamKeys.SMT_RADIO, false, 2) && CharsKt__CharKt.contains$default((CharSequence) lowerCase3, (CharSequence) "button", false, 2)) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i + 1;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(jSONObject2));
                        if (i3 >= length) {
                            break;
                        }
                        i = i3;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int length = optJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (optJSONArray.getJSONObject(i).optBoolean("is_interacted")) {
                        z2 = true;
                        z = true;
                        break;
                    } else if (i2 >= length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            z2 = false;
            z = false;
            JSONArray jSONArray2 = new JSONArray();
            if (z2) {
                int length2 = optJSONArray.length();
                if (length2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        jSONArray.put(optJSONArray.getJSONObject(i3));
                        if (i4 >= length2) {
                            break;
                        }
                        i3 = i4;
                    }
                }
            } else {
                int length3 = optJSONArray.length();
                if (length3 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "child");
                        if (pruneTree(jSONObject2, jSONArray)) {
                            jSONArray2.put(jSONObject2);
                            z = true;
                        }
                        if (i6 >= length3) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ all -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean regexMatched(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONObject r0 = rules     // Catch:{ all -> 0x007a }
            r2 = 0
            if (r0 == 0) goto L_0x0074
            java.lang.String r3 = "rulesForLanguage"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0017
            r5 = r2
            goto L_0x0025
        L_0x0017:
            java.util.Map<java.lang.String, java.lang.String> r3 = languageInfo     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x006e
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x007a }
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ all -> 0x007a }
        L_0x0025:
            if (r5 != 0) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            java.lang.String r0 = "rulesForEvent"
            org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x0032
        L_0x0030:
            r5 = r2
            goto L_0x0040
        L_0x0032:
            java.util.Map<java.lang.String, java.lang.String> r0 = eventInfo     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
        L_0x0040:
            if (r5 != 0) goto L_0x0043
            goto L_0x005a
        L_0x0043:
            java.lang.String r6 = "positiveRules"
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            java.util.Map<java.lang.String, java.lang.String> r6 = textTypeInfo     // Catch:{ all -> 0x007a }
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r5.optString(r6)     // Catch:{ all -> 0x007a }
        L_0x005a:
            if (r2 != 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            boolean r1 = r4.regexMatched(r2, r8)     // Catch:{ all -> 0x007a }
        L_0x0061:
            return r1
        L_0x0062:
            java.lang.String r5 = "textTypeInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2
        L_0x0068:
            java.lang.String r5 = "eventInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2
        L_0x006e:
            java.lang.String r5 = "languageInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2
        L_0x0074:
            java.lang.String r5 = "rules"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2
        L_0x007a:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.FeatureExtractor.regexMatched(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public final void sum(float[] fArr, float[] fArr2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            int i = 0;
            try {
                int length = fArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        fArr[i] = fArr[i] + fArr2[i];
                        if (i2 > length) {
                            break;
                        }
                        i = i2;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String optString = jSONObject.optString("text", "");
                Intrinsics.checkNotNullExpressionValue(optString, "view.optString(TEXT_KEY, \"\")");
                String lowerCase = optString.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                String optString2 = jSONObject.optString("hint", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "view.optString(HINT_KEY, \"\")");
                String lowerCase2 = optString2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                boolean z = true;
                int i = 0;
                if (lowerCase.length() > 0) {
                    sb.append(lowerCase);
                    sb.append(CMap.SPACE);
                }
                if (lowerCase2.length() <= 0) {
                    z = false;
                }
                if (z) {
                    sb2.append(lowerCase2);
                    sb2.append(CMap.SPACE);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            try {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                Intrinsics.checkNotNullExpressionValue(jSONObject2, "currentChildView");
                                updateHintAndTextRecursively(jSONObject2, sb, sb2);
                            } catch (JSONException unused) {
                            }
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final boolean regexMatched(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
