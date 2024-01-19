package com.facebook.react.modules.blob;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler;
import com.facebook.react.modules.network.NetworkingModule.ResponseHandler;
import com.facebook.react.modules.network.NetworkingModule.UriHandler;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.modules.websocket.WebSocketModule.ContentHandler;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.squareup.picasso.NetworkRequestHandler;
import io.sentry.Attachment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.ByteString;

@ReactModule(name = "BlobModule")
public class BlobModule extends NativeBlobModuleSpec {
    public static final String NAME = "BlobModule";
    public final Map<String, byte[]> mBlobs = new HashMap();
    public final RequestBodyHandler mNetworkingRequestBodyHandler = new RequestBodyHandler() {
        public boolean supports(ReadableMap readableMap) {
            return readableMap.hasKey("blob");
        }

        public RequestBody toRequestBody(ReadableMap readableMap, String str) {
            if (readableMap.hasKey("type") && !readableMap.getString("type").isEmpty()) {
                str = readableMap.getString("type");
            }
            if (str == null) {
                str = Attachment.DEFAULT_CONTENT_TYPE;
            }
            ReadableMap map = readableMap.getMap("blob");
            return RequestBody.create(MediaType.parse(str), BlobModule.this.resolve(map.getString("blobId"), map.getInt("offset"), map.getInt(Response.SIZE)));
        }
    };
    public final ResponseHandler mNetworkingResponseHandler = new ResponseHandler() {
        public boolean supports(String str) {
            return "blob".equals(str);
        }

        public WritableMap toResponseData(ResponseBody responseBody) throws IOException {
            byte[] bytes = responseBody.bytes();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(bytes));
            createMap.putInt("offset", 0);
            createMap.putInt(Response.SIZE, bytes.length);
            return createMap;
        }
    };
    public final UriHandler mNetworkingUriHandler = new UriHandler() {
        public WritableMap fetch(Uri uri) throws IOException {
            byte[] access$000 = BlobModule.this.getBytesFromUri(uri);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(access$000));
            createMap.putInt("offset", 0);
            createMap.putInt(Response.SIZE, access$000.length);
            createMap.putString("type", BlobModule.this.getMimeTypeFromUri(uri));
            createMap.putString("name", BlobModule.this.getNameFromUri(uri));
            createMap.putDouble("lastModified", (double) BlobModule.this.getLastModifiedFromUri(uri));
            return createMap;
        }

        public boolean supports(Uri uri, String str) {
            String scheme = uri.getScheme();
            if ((NetworkRequestHandler.SCHEME_HTTP.equals(scheme) || NetworkRequestHandler.SCHEME_HTTPS.equals(scheme)) || !"blob".equals(str)) {
                return false;
            }
            return true;
        }
    };
    public final ContentHandler mWebSocketContentHandler = new ContentHandler() {
        public void onMessage(String str, WritableMap writableMap) {
            writableMap.putString("data", str);
        }

        public void onMessage(ByteString byteString, WritableMap writableMap) {
            byte[] byteArray = byteString.toByteArray();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(byteArray));
            createMap.putInt("offset", 0);
            createMap.putInt(Response.SIZE, byteArray.length);
            writableMap.putMap("data", createMap);
            writableMap.putString("type", "blob");
        }
    };

    public BlobModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public byte[] getBytesFromUri(Uri uri) throws IOException {
        InputStream openInputStream = getReactApplicationContext().getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } else {
            throw new FileNotFoundException(GeneratedOutlineSupport.outline46("File not found for ", uri));
        }
    }

    /* access modifiers changed from: private */
    public long getLastModifiedFromUri(Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return new File(uri.toString()).lastModified();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public String getMimeTypeFromUri(Uri uri) {
        String type = getReactApplicationContext().getContentResolver().getType(uri);
        if (type == null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.getPath());
            if (fileExtensionFromUrl != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            }
        }
        return type == null ? "" : type;
    }

    /* access modifiers changed from: private */
    public String getNameFromUri(Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return uri.getLastPathSegment();
        }
        Cursor query = getReactApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getString(0);
                }
                query.close();
            } finally {
                query.close();
            }
        }
        return uri.getLastPathSegment();
    }

    private WebSocketModule getWebSocketModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (WebSocketModule) reactApplicationContextIfActiveOrWarn.getNativeModule(WebSocketModule.class);
        }
        return null;
    }

    public void addNetworkingHandler() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            NetworkingModule networkingModule = (NetworkingModule) reactApplicationContextIfActiveOrWarn.getNativeModule(NetworkingModule.class);
            networkingModule.addUriHandler(this.mNetworkingUriHandler);
            networkingModule.addRequestBodyHandler(this.mNetworkingRequestBodyHandler);
            networkingModule.addResponseHandler(this.mNetworkingResponseHandler);
        }
    }

    public void addWebSocketHandler(double d2) {
        int i = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("addWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i, this.mWebSocketContentHandler);
        }
    }

    public void createFromParts(ReadableArray readableArray, String str) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        int i = 0;
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            String string = map.getString("type");
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -891985903) {
                if (hashCode == 3026845 && string.equals("blob")) {
                    c2 = 0;
                }
            } else if (string.equals(NetworkingModule.REQUEST_BODY_KEY_STRING)) {
                c2 = 1;
            }
            if (c2 == 0) {
                ReadableMap map2 = map.getMap("data");
                int i3 = map2.getInt(Response.SIZE) + i;
                arrayList.add(i2, resolve(map2));
                i = i3;
            } else if (c2 == 1) {
                byte[] bytes = map.getString("data").getBytes(Charset.forName("UTF-8"));
                i += bytes.length;
                arrayList.add(i2, bytes);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid type for blob: ");
                outline73.append(map.getString("type"));
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            allocate.put((byte[]) it.next());
        }
        store(allocate.array(), str);
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        Resources resources = getReactApplicationContext().getResources();
        int identifier = resources.getIdentifier("blob_provider_authority", NetworkingModule.REQUEST_BODY_KEY_STRING, getReactApplicationContext().getPackageName());
        if (identifier == 0) {
            return new HashMap();
        }
        return ImageOriginUtils.of("BLOB_URI_SCHEME", "content", "BLOB_URI_HOST", resources.getString(identifier));
    }

    public void initialize() {
        BlobCollector.install(getReactApplicationContext(), this);
    }

    public void release(String str) {
        remove(str);
    }

    @DoNotStrip
    public void remove(String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.remove(str);
        }
    }

    public void removeWebSocketHandler(double d2) {
        int i = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("removeWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i, null);
        }
    }

    public byte[] resolve(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        String queryParameter = uri.getQueryParameter("offset");
        int parseInt = queryParameter != null ? Integer.parseInt(queryParameter, 10) : 0;
        String queryParameter2 = uri.getQueryParameter(Response.SIZE);
        return resolve(lastPathSegment, parseInt, queryParameter2 != null ? Integer.parseInt(queryParameter2, 10) : -1);
    }

    public void sendOverSocket(ReadableMap readableMap, double d2) {
        int i = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("sendOverSocket");
        if (webSocketModule != null) {
            byte[] resolve = resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(Response.SIZE));
            if (resolve != null) {
                webSocketModule.sendBinary(ByteString.of(resolve), i);
            } else {
                webSocketModule.sendBinary((ByteString) null, i);
            }
        }
    }

    public String store(byte[] bArr) {
        String uuid = UUID.randomUUID().toString();
        store(bArr, uuid);
        return uuid;
    }

    public void store(byte[] bArr, String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.put(str, bArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] resolve(java.lang.String r3, int r4, int r5) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, byte[]> r0 = r2.mBlobs
            monitor-enter(r0)
            java.util.Map<java.lang.String, byte[]> r1 = r2.mBlobs     // Catch:{ all -> 0x0021 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0021 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0021 }
            if (r3 != 0) goto L_0x0010
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x0010:
            r1 = -1
            if (r5 != r1) goto L_0x0015
            int r5 = r3.length     // Catch:{ all -> 0x0021 }
            int r5 = r5 - r4
        L_0x0015:
            if (r4 > 0) goto L_0x001a
            int r1 = r3.length     // Catch:{ all -> 0x0021 }
            if (r5 == r1) goto L_0x001f
        L_0x001a:
            int r5 = r5 + r4
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r4, r5)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.blob.BlobModule.resolve(java.lang.String, int, int):byte[]");
    }

    public byte[] resolve(ReadableMap readableMap) {
        return resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(Response.SIZE));
    }
}
