package com.facebook;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\b\u0010!\u001a\u0004\u0018\u00010\fJ\b\u0010\"\u001a\u0004\u0018\u00010\tJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0007H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/facebook/GraphResponse;", "", "request", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "rawResponse", "", "graphObject", "Lorg/json/JSONObject;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V", "graphObjects", "Lorg/json/JSONArray;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONArray;)V", "error", "Lcom/facebook/FacebookRequestError;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "graphObjectArray", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lcom/facebook/FacebookRequestError;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonArray", "getJsonArray", "()Lorg/json/JSONArray;", "jsonObject", "getJsonObject", "()Lorg/json/JSONObject;", "getRawResponse", "()Ljava/lang/String;", "getRequest", "()Lcom/facebook/GraphRequest;", "getJSONArray", "getJSONObject", "getRequestForPagedResults", "direction", "Lcom/facebook/GraphResponse$PagingDirection;", "toString", "Companion", "PagingDirection", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphResponse.kt */
public final class GraphResponse {
    public final HttpURLConnection connection;
    public final FacebookRequestError error;
    public final JSONObject graphObject;
    public final JSONArray graphObjectArray;
    public final JSONObject jsonObject;

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        this.connection = httpURLConnection;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
    }

    public static final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(list, "requests");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
        for (GraphRequest graphResponse : list) {
            arrayList.add(new GraphResponse(graphResponse, httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r8v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0179, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, com.facebook.AccessToken.Companion.getCurrentAccessToken()) != false) goto L_0x017e;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v17
      assigns: []
      uses: []
      mth insns count: 254
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e8 A[Catch:{ JSONException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0160  */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.GraphResponse createResponseFromObject(com.facebook.GraphRequest r21, java.net.HttpURLConnection r22, java.lang.Object r23, java.lang.Object r24) throws org.json.JSONException {
        /*
            r1 = r21
            r0 = r22
            r2 = r23
            java.lang.String r15 = "body"
            java.lang.String r14 = "FACEBOOK_NON_JSON_RESULT"
            boolean r3 = r2 instanceof org.json.JSONObject
            r4 = 0
            if (r3 == 0) goto L_0x0237
            r13 = r2
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            java.lang.String r2 = "error_code"
            java.lang.String r3 = "error"
            java.lang.String r5 = "code"
            java.lang.String r6 = "singleResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r6)
            r16 = 1
            r6 = 0
            boolean r7 = r13.has(r5)     // Catch:{ JSONException -> 0x0156 }
            if (r7 == 0) goto L_0x0156
            int r7 = r13.getInt(r5)     // Catch:{ JSONException -> 0x0156 }
            java.lang.Object r8 = com.facebook.internal.Utility.getStringPropertyAsJSON(r13, r15, r14)     // Catch:{ JSONException -> 0x0156 }
            if (r8 == 0) goto L_0x010e
            boolean r9 = r8 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0109 }
            if (r9 == 0) goto L_0x010e
            r9 = r8
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ JSONException -> 0x0109 }
            boolean r9 = r9.has(r3)     // Catch:{ JSONException -> 0x0109 }
            java.lang.String r10 = "error_subcode"
            r11 = -1
            if (r9 == 0) goto L_0x008a
            r2 = r8
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ JSONException -> 0x0156 }
            java.lang.Object r2 = com.facebook.internal.Utility.getStringPropertyAsJSON(r2, r3, r4)     // Catch:{ JSONException -> 0x0156 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ JSONException -> 0x0156 }
            if (r2 != 0) goto L_0x004d
            r3 = r4
            goto L_0x0053
        L_0x004d:
            java.lang.String r3 = "type"
            java.lang.String r3 = r2.optString(r3, r4)     // Catch:{ JSONException -> 0x0156 }
        L_0x0053:
            if (r2 != 0) goto L_0x0057
            r9 = r4
            goto L_0x005d
        L_0x0057:
            java.lang.String r9 = "message"
            java.lang.String r9 = r2.optString(r9, r4)     // Catch:{ JSONException -> 0x0156 }
        L_0x005d:
            if (r2 != 0) goto L_0x0061
            r5 = -1
            goto L_0x0065
        L_0x0061:
            int r5 = r2.optInt(r5, r11)     // Catch:{ JSONException -> 0x0156 }
        L_0x0065:
            if (r2 != 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            int r11 = r2.optInt(r10, r11)     // Catch:{ JSONException -> 0x0156 }
        L_0x006c:
            if (r2 != 0) goto L_0x0070
            r10 = r4
            goto L_0x0076
        L_0x0070:
            java.lang.String r10 = "error_user_msg"
            java.lang.String r10 = r2.optString(r10, r4)     // Catch:{ JSONException -> 0x0156 }
        L_0x0076:
            if (r2 != 0) goto L_0x0079
            goto L_0x007f
        L_0x0079:
            java.lang.String r12 = "error_user_title"
            java.lang.String r4 = r2.optString(r12, r4)     // Catch:{ JSONException -> 0x0156 }
        L_0x007f:
            if (r2 != 0) goto L_0x0083
            r2 = 0
            goto L_0x00da
        L_0x0083:
            java.lang.String r12 = "is_transient"
            boolean r2 = r2.optBoolean(r12, r6)     // Catch:{ JSONException -> 0x0156 }
            goto L_0x00da
        L_0x008a:
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x0109 }
            boolean r3 = r3.has(r2)     // Catch:{ JSONException -> 0x0109 }
            java.lang.String r4 = "error_msg"
            java.lang.String r5 = "error_reason"
            if (r3 != 0) goto L_0x00ba
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x0156 }
            boolean r3 = r3.has(r4)     // Catch:{ JSONException -> 0x0156 }
            if (r3 != 0) goto L_0x00ba
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x0156 }
            boolean r3 = r3.has(r5)     // Catch:{ JSONException -> 0x0156 }
            if (r3 == 0) goto L_0x00aa
            goto L_0x00ba
        L_0x00aa:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r9 = -1
            r10 = 0
            r11 = -1
            r9 = r3
            r10 = r4
            r11 = r5
            r4 = -1
            r5 = -1
            r17 = 0
            goto L_0x00e6
        L_0x00ba:
            r3 = r8
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x0109 }
            r6 = 0
            java.lang.String r3 = r3.optString(r5, r6)     // Catch:{ JSONException -> 0x0109 }
            r5 = r8
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x0109 }
            java.lang.String r9 = r5.optString(r4, r6)     // Catch:{ JSONException -> 0x0109 }
            r4 = r8
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ JSONException -> 0x0109 }
            int r5 = r4.optInt(r2, r11)     // Catch:{ JSONException -> 0x0109 }
            r2 = r8
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ JSONException -> 0x0109 }
            int r11 = r2.optInt(r10, r11)     // Catch:{ JSONException -> 0x0109 }
            r2 = 0
            r4 = r6
            r10 = r4
        L_0x00da:
            r6 = 1
            r17 = r2
            r6 = r3
            r2 = 1
            r20 = r10
            r10 = r4
            r4 = r5
            r5 = r11
            r11 = r20
        L_0x00e6:
            if (r2 == 0) goto L_0x010e
            com.facebook.FacebookRequestError r18 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x0109 }
            r12 = r8
            org.json.JSONObject r12 = (org.json.JSONObject) r12     // Catch:{ JSONException -> 0x0109 }
            r19 = 0
            r2 = r18
            r3 = r7
            r7 = r9
            r8 = r10
            r9 = r11
            r10 = r12
            r11 = r13
            r12 = r24
            r0 = r13
            r13 = r22
            r1 = r14
            r14 = r19
            r19 = r1
            r1 = r15
            r15 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x015a }
            goto L_0x015c
        L_0x0109:
            r0 = r13
            r1 = r15
            r19 = r14
            goto L_0x015a
        L_0x010e:
            r0 = r13
            r19 = r14
            r1 = r15
            com.facebook.FacebookRequestError$Range r2 = com.facebook.FacebookRequestError.HTTP_RANGE_SUCCESS     // Catch:{ JSONException -> 0x015a }
            int r3 = r2.start     // Catch:{ JSONException -> 0x015a }
            int r2 = r2.end     // Catch:{ JSONException -> 0x015a }
            if (r7 > r2) goto L_0x011e
            if (r3 > r7) goto L_0x011e
            r2 = 1
            goto L_0x011f
        L_0x011e:
            r2 = 0
        L_0x011f:
            if (r2 != 0) goto L_0x015a
            com.facebook.FacebookRequestError r18 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x015a }
            r4 = -1
            r5 = -1
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x015a }
            if (r2 == 0) goto L_0x013b
            r15 = r19
            java.lang.Object r2 = com.facebook.internal.Utility.getStringPropertyAsJSON(r0, r1, r15)     // Catch:{ JSONException -> 0x0138 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ JSONException -> 0x0138 }
            goto L_0x013e
        L_0x0138:
            r19 = r15
            goto L_0x015a
        L_0x013b:
            r15 = r19
            r2 = 0
        L_0x013e:
            r11 = r2
            r14 = 0
            r17 = 0
            r2 = r18
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r0
            r12 = r24
            r13 = r22
            r19 = r15
            r15 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x015a }
            goto L_0x015c
        L_0x0156:
            r0 = r13
            r19 = r14
            r1 = r15
        L_0x015a:
            r18 = 0
        L_0x015c:
            r2 = r18
            if (r2 == 0) goto L_0x01e6
            r2.toString()
            int r0 = r2.errorCode
            r1 = 190(0xbe, float:2.66E-43)
            r3 = r21
            if (r0 != r1) goto L_0x01de
            com.facebook.AccessToken r0 = r3.accessToken
            if (r0 == 0) goto L_0x017c
            com.facebook.AccessToken$Companion r1 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r1 = com.facebook.AccessToken.Companion.getCurrentAccessToken()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x017c
            goto L_0x017e
        L_0x017c:
            r16 = 0
        L_0x017e:
            if (r16 == 0) goto L_0x01de
            int r0 = r2.subErrorCode
            r1 = 493(0x1ed, float:6.91E-43)
            if (r0 == r1) goto L_0x018d
            com.facebook.AccessToken$Companion r0 = com.facebook.AccessToken.Companion
            r0 = 0
            com.facebook.AccessToken.Companion.setCurrentAccessToken(r0)
            goto L_0x01de
        L_0x018d:
            r0 = 0
            com.facebook.AccessToken$Companion r1 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r1 = com.facebook.AccessToken.Companion.getCurrentAccessToken()
            if (r1 != 0) goto L_0x0197
            goto L_0x019f
        L_0x0197:
            boolean r0 = r1.isExpired()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x019f:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x01de
            com.facebook.AccessToken$Companion r0 = com.facebook.AccessToken.Companion
            com.facebook.AccessTokenManager$Companion r0 = com.facebook.AccessTokenManager.Companion
            com.facebook.AccessTokenManager r0 = r0.getInstance()
            com.facebook.AccessToken r0 = r0.currentAccessTokenField
            if (r0 == 0) goto L_0x01de
            java.lang.String r1 = "current"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.facebook.AccessToken r1 = new com.facebook.AccessToken
            java.lang.String r5 = r0.token
            java.lang.String r6 = r0.applicationId
            java.lang.String r7 = r0.userId
            java.util.Set<java.lang.String> r8 = r0.permissions
            java.util.Set<java.lang.String> r9 = r0.declinedPermissions
            java.util.Set<java.lang.String> r10 = r0.expiredPermissions
            com.facebook.AccessTokenSource r11 = r0.source
            java.util.Date r12 = new java.util.Date
            r12.<init>()
            java.util.Date r13 = new java.util.Date
            r13.<init>()
            java.util.Date r14 = r0.dataAccessExpirationTime
            r15 = 0
            r16 = 1024(0x400, float:1.435E-42)
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.facebook.AccessToken.Companion.setCurrentAccessToken(r1)
        L_0x01de:
            com.facebook.GraphResponse r0 = new com.facebook.GraphResponse
            r4 = r22
            r0.<init>(r3, r4, r2)
            return r0
        L_0x01e6:
            r3 = r21
            r4 = r22
            r2 = r0
            r0 = r19
            r5 = 0
            java.lang.Object r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r2, r1, r0)
            boolean r1 = r0 instanceof org.json.JSONObject
            if (r1 == 0) goto L_0x0202
            com.facebook.GraphResponse r1 = new com.facebook.GraphResponse
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = r0.toString()
            r1.<init>(r3, r4, r2, r0)
            return r1
        L_0x0202:
            boolean r1 = r0 instanceof org.json.JSONArray
            if (r1 == 0) goto L_0x022d
            com.facebook.GraphResponse r7 = new com.facebook.GraphResponse
            r5 = r0
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            java.lang.String r6 = r5.toString()
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "rawResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "graphObjects"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r8 = 0
            r9 = 0
            r10 = r4
            r0 = r7
            r1 = r21
            r2 = r22
            r3 = r6
            r4 = r8
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x022d:
            r10 = r4
            java.lang.Object r0 = org.json.JSONObject.NULL
            java.lang.String r1 = "NULL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r4 = r5
            goto L_0x023a
        L_0x0237:
            r10 = r0
            r3 = r1
            r0 = r2
        L_0x023a:
            java.lang.Object r1 = org.json.JSONObject.NULL
            if (r0 != r1) goto L_0x0248
            com.facebook.GraphResponse r1 = new com.facebook.GraphResponse
            java.lang.String r0 = r0.toString()
            r1.<init>(r3, r10, r0, r4)
            return r1
        L_0x0248:
            com.facebook.FacebookException r1 = new com.facebook.FacebookException
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r2 = "Got unexpected object type in response, class: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.createResponseFromObject(com.facebook.GraphRequest, java.net.HttpURLConnection, java.lang.Object, java.lang.Object):com.facebook.GraphResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.facebook.GraphResponse> createResponsesFromStream$facebook_core_release(java.io.InputStream r12, java.net.HttpURLConnection r13, com.facebook.GraphRequestBatch r14) throws com.facebook.FacebookException, org.json.JSONException, java.io.IOException {
        /*
            java.lang.String r0 = "requests"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r12 = com.facebook.internal.Utility.readStreamToString(r12)
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.INCLUDE_RAW_RESPONSES
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r12.length()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            r4 = 1
            r3[r4] = r12
            java.lang.String r6 = "Response"
            java.lang.String r7 = "Response (raw)\n  Size: %d\n  Response:\n%s\n"
            r1.log(r2, r6, r7, r3)
            java.lang.String r1 = "responseString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            org.json.JSONTokener r0 = new org.json.JSONTokener
            r0.<init>(r12)
            java.lang.Object r0 = r0.nextValue()
            java.lang.String r1 = "resultObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r14.size()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            if (r1 != r4) goto L_0x0085
            java.lang.Object r3 = r14.get(r5)
            com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            r7.<init>()     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            java.lang.String r8 = "body"
            r7.put(r8, r0)     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            int r8 = r13.getResponseCode()     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            java.lang.String r9 = "code"
            r7.put(r9, r8)     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            r8.<init>()     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            r8.put(r7)     // Catch:{ JSONException -> 0x0077, IOException -> 0x0068 }
            goto L_0x0086
        L_0x0068:
            r7 = move-exception
            com.facebook.GraphResponse r8 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r9 = new com.facebook.FacebookRequestError
            r9.<init>(r13, r7)
            r8.<init>(r3, r13, r9)
            r2.add(r8)
            goto L_0x0085
        L_0x0077:
            r7 = move-exception
            com.facebook.GraphResponse r8 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r9 = new com.facebook.FacebookRequestError
            r9.<init>(r13, r7)
            r8.<init>(r3, r13, r9)
            r2.add(r8)
        L_0x0085:
            r8 = r0
        L_0x0086:
            boolean r3 = r8 instanceof org.json.JSONArray
            if (r3 == 0) goto L_0x00f6
            r3 = r8
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            int r7 = r3.length()
            if (r7 != r1) goto L_0x00f6
            int r1 = r3.length()
            if (r1 <= 0) goto L_0x00d8
            r3 = 0
        L_0x009a:
            int r7 = r3 + 1
            java.lang.Object r9 = r14.get(r3)
            com.facebook.GraphRequest r9 = (com.facebook.GraphRequest) r9
            r10 = r8
            org.json.JSONArray r10 = (org.json.JSONArray) r10     // Catch:{ JSONException -> 0x00c5, FacebookException -> 0x00b6 }
            java.lang.Object r3 = r10.get(r3)     // Catch:{ JSONException -> 0x00c5, FacebookException -> 0x00b6 }
            java.lang.String r10 = "obj"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)     // Catch:{ JSONException -> 0x00c5, FacebookException -> 0x00b6 }
            com.facebook.GraphResponse r3 = createResponseFromObject(r9, r13, r3, r0)     // Catch:{ JSONException -> 0x00c5, FacebookException -> 0x00b6 }
            r2.add(r3)     // Catch:{ JSONException -> 0x00c5, FacebookException -> 0x00b6 }
            goto L_0x00d3
        L_0x00b6:
            r3 = move-exception
            com.facebook.GraphResponse r10 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r11 = new com.facebook.FacebookRequestError
            r11.<init>(r13, r3)
            r10.<init>(r9, r13, r11)
            r2.add(r10)
            goto L_0x00d3
        L_0x00c5:
            r3 = move-exception
            com.facebook.GraphResponse r10 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r11 = new com.facebook.FacebookRequestError
            r11.<init>(r13, r3)
            r10.<init>(r9, r13, r11)
            r2.add(r10)
        L_0x00d3:
            if (r7 < r1) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r3 = r7
            goto L_0x009a
        L_0x00d8:
            com.facebook.internal.Logger$Companion r13 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.REQUESTS
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r14 = r14.id
            r1[r5] = r14
            int r12 = r12.length()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r1[r4] = r12
            r12 = 2
            r1[r12] = r2
            java.lang.String r12 = "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n"
            r13.log(r0, r6, r12, r1)
            return r2
        L_0x00f6:
            com.facebook.FacebookException r12 = new com.facebook.FacebookException
            java.lang.String r13 = "Unexpected number of results"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.createResponsesFromStream$facebook_core_release(java.io.InputStream, java.net.HttpURLConnection, com.facebook.GraphRequestBatch):java.util.List");
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.connection;
            objArr[0] = Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode());
            str = String.format(locale, "%d", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        StringBuilder outline81 = GeneratedOutlineSupport.outline81("{Response: ", " responseCode: ", str, ", graphObject: ");
        outline81.append(this.graphObject);
        outline81.append(", error: ");
        outline81.append(this.error);
        outline81.append("}");
        String sb = outline81.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return sb;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        // Intrinsics.checkNotNullParameter(graphRequest, "request");
        // Intrinsics.checkNotNullParameter(str, "rawResponse");
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        // Intrinsics.checkNotNullParameter(graphRequest, "request");
        // Intrinsics.checkNotNullParameter(facebookRequestError, "error");
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }
}
