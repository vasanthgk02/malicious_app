package com.facebook.reactnative.androidsdk;

import android.os.Bundle;
import android.util.SparseArray;
import com.amazon.apay.hardened.external.model.APayConstants.Error;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.mpl.androidapp.login.LoginReactModule;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "FBGraphRequest")
public class FBGraphRequestModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBGraphRequest";
    public SparseArray<WritableMap> mResponses = new SparseArray<>();

    public class GraphRequestBatchCallback implements Callback {
        public int mBatchID;
        public com.facebook.react.bridge.Callback mCallback;

        public GraphRequestBatchCallback(int i, com.facebook.react.bridge.Callback callback) {
            this.mBatchID = i;
            this.mCallback = callback;
        }

        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString(LoginReactModule.RESULT, "batch finished executing or timed out");
            this.mCallback.invoke(null, createMap, FBGraphRequestModule.this.mResponses.get(this.mBatchID));
            FBGraphRequestModule.this.mResponses.remove(this.mBatchID);
        }
    }

    public class GraphRequestCallback implements GraphRequest.Callback {
        public int mBatchID;
        public String mIndex;

        public GraphRequestCallback(int i, int i2) {
            this.mIndex = String.valueOf(i);
            this.mBatchID = i2;
        }

        public void onCompleted(GraphResponse graphResponse) {
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(FBGraphRequestModule.this.buildFacebookRequestError(graphResponse.error));
            createArray.pushMap(FBGraphRequestModule.this.buildGraphResponse(graphResponse));
            ((WritableMap) FBGraphRequestModule.this.mResponses.get(this.mBatchID)).putArray(this.mIndex, createArray);
        }
    }

    public FBGraphRequestModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public WritableMap buildFacebookRequestError(FacebookRequestError facebookRequestError) {
        if (facebookRequestError == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("requestStatusCode", facebookRequestError.requestStatusCode);
        createMap.putInt("errorCode", facebookRequestError.errorCode);
        createMap.putInt("subErrorCode", facebookRequestError.subErrorCode);
        String str = facebookRequestError.errorType;
        if (str != null) {
            createMap.putString(Error.ERROR_TYPE, str);
        }
        if (facebookRequestError.getErrorMessage() != null) {
            createMap.putString("errorMessage", facebookRequestError.getErrorMessage());
        }
        String str2 = facebookRequestError.errorUserTitle;
        if (str2 != null) {
            createMap.putString("errorUserTitle", str2);
        }
        String str3 = facebookRequestError.errorUserMessage;
        if (str3 != null) {
            createMap.putString("errorUserMessage", str3);
        }
        JSONObject jSONObject = facebookRequestError.requestResultBody;
        if (jSONObject != null) {
            createMap.putString("requestResultBody", jSONObject.toString());
        }
        JSONObject jSONObject2 = facebookRequestError.requestResult;
        if (jSONObject2 != null) {
            createMap.putString("requestResult", jSONObject2.toString());
        }
        Object obj = facebookRequestError.batchRequestResult;
        if (obj != null) {
            createMap.putString("batchRequestResult", obj.toString());
        }
        FacebookException facebookException = facebookRequestError.exception;
        if (facebookException != null) {
            createMap.putString(MqttServiceConstants.TRACE_EXCEPTION, facebookException.toString());
        }
        return createMap;
    }

    /* access modifiers changed from: private */
    public WritableMap buildGraphResponse(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.graphObject;
        if (jSONObject != null) {
            return convertJSONObject(jSONObject);
        }
        return Arguments.createMap();
    }

    private Bundle buildParameters(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            if (map.hasKey(NetworkingModule.REQUEST_BODY_KEY_STRING)) {
                bundle.putString(nextKey, map.getString(NetworkingModule.REQUEST_BODY_KEY_STRING));
            }
        }
        return bundle;
    }

    private GraphRequest buildRequest(ReadableMap readableMap) {
        GraphRequest graphRequest = new GraphRequest(null, null, null, null, null, null, 63);
        graphRequest.graphPath = readableMap.getString("graphPath");
        setConfig(graphRequest, readableMap.getMap("config"));
        return graphRequest;
    }

    private WritableArray convertJSONArray(JSONArray jSONArray) {
        WritableArray createArray = Arguments.createArray();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    createArray.pushMap(convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    createArray.pushArray(convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    createArray.pushString((String) obj);
                } else if (obj instanceof Integer) {
                    createArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    createArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    createArray.pushDouble(((Double) obj).doubleValue());
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return createArray;
    }

    private WritableMap convertJSONObject(JSONObject jSONObject) {
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    createMap.putMap(next, convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    createMap.putArray(next, convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    createMap.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    createMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    createMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    createMap.putDouble(next, ((Double) obj).doubleValue());
                }
            } catch (JSONException unused) {
            }
        }
        return createMap;
    }

    private void setConfig(GraphRequest graphRequest, ReadableMap readableMap) {
        if (readableMap == null) {
            graphRequest.accessToken = AccessToken.getCurrentAccessToken();
            return;
        }
        if (readableMap.hasKey(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY)) {
            graphRequest.setParameters(buildParameters(readableMap.getMap(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY)));
        }
        if (readableMap.hasKey("httpMethod")) {
            graphRequest.setHttpMethod(HttpMethod.valueOf(readableMap.getString("httpMethod")));
        }
        if (readableMap.hasKey("version")) {
            graphRequest.version = readableMap.getString("version");
        }
        if (readableMap.hasKey("accessToken")) {
            AccessToken accessToken = new AccessToken(readableMap.getString("accessToken"), AccessToken.getCurrentAccessToken().applicationId, AccessToken.getCurrentAccessToken().userId, null, null, null, null, null, null, null);
            graphRequest.accessToken = accessToken;
        } else {
            graphRequest.accessToken = AccessToken.getCurrentAccessToken();
        }
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void start(ReadableArray readableArray, int i, com.facebook.react.bridge.Callback callback) {
        boolean z;
        int i2;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        synchronized (this) {
            z = false;
            i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (this.mResponses.get(i2) == null) {
                    this.mResponses.put(i2, Arguments.createMap());
                } else {
                    i2 = i3;
                }
            }
            while (true) {
            }
        }
        for (int i4 = 0; i4 < readableArray.size(); i4++) {
            GraphRequest buildRequest = buildRequest(readableArray.getMap(i4));
            buildRequest.setCallback(new GraphRequestCallback(i4, i2));
            Intrinsics.checkNotNullParameter(buildRequest, "element");
            graphRequestBatch.requests.add(buildRequest);
        }
        if (i >= 0) {
            z = true;
        }
        if (z) {
            graphRequestBatch.timeoutInMilliseconds = i;
            GraphRequestBatchCallback graphRequestBatchCallback = new GraphRequestBatchCallback(i2, callback);
            Intrinsics.checkNotNullParameter(graphRequestBatchCallback, "callback");
            if (!graphRequestBatch.callbacks.contains(graphRequestBatchCallback)) {
                graphRequestBatch.callbacks.add(graphRequestBatchCallback);
            }
            graphRequestBatch.executeAsync();
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.".toString());
    }
}
