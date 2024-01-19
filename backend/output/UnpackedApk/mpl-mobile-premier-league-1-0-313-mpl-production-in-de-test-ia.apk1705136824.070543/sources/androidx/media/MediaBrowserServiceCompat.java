package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.core.widget.CompoundButtonCompat;
import androidx.media.MediaBrowserServiceCompatApi26.ResultWrapper;
import androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    public static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    public final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    public ConnectionRecord mCurConnection;
    public final ServiceHandler mHandler = new ServiceHandler();
    public MediaBrowserServiceImpl mImpl;
    public Token mSession;

    public static final class BrowserRoot {
    }

    public class ConnectionRecord implements DeathRecipient {
        public final ServiceCallbacks callbacks;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            new androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(r3, r4, r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ConnectionRecord(java.lang.String r3, int r4, int r5, android.os.Bundle r6, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks r7) {
            /*
                r1 = this;
                androidx.media.MediaBrowserServiceCompat.this = r2
                r1.<init>()
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                r1.subscriptions = r2
                r1.pkg = r3
                int r2 = android.os.Build.VERSION.SDK_INT
                r0 = 28
                if (r2 < r0) goto L_0x0019
                androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28 r2 = new androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28
                r2.<init>(r3, r4, r5)
            L_0x0019:
                r1.rootHints = r6
                r1.callbacks = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.<init>(androidx.media.MediaBrowserServiceCompat, java.lang.String, int, int, android.os.Bundle, androidx.media.MediaBrowserServiceCompat$ServiceCallbacks):void");
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.mConnections.remove(((ServiceCallbacksCompat) connectionRecord.callbacks).asBinder());
                }
            });
        }
    }

    public interface MediaBrowserServiceImpl {
        IBinder onBind(Intent intent);

        void onCreate();
    }

    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21$ServiceCompatProxy {
        public Messenger mMessenger;
        public final List<Bundle> mRootExtrasList = new ArrayList();
        public Object mServiceObj;

        public MediaBrowserServiceImplApi21() {
        }

        public IBinder onBind(Intent intent) {
            return ((MediaBrowserService) this.mServiceObj).onBind(intent);
        }

        public void onCreate() {
            MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor mediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor = new MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = mediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor;
            mediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor.onCreate();
        }

        public MediaBrowserServiceCompatApi21$BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            IBinder iBinder;
            if (!(bundle == null || bundle.getInt("extra_client_version", 0) == 0)) {
                bundle.remove("extra_client_version");
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                BundleCompat.putBinder(bundle2, "extra_messenger", this.mMessenger.getBinder());
                Token token = MediaBrowserServiceCompat.this.mSession;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, "extra_session_binder", iBinder);
                } else {
                    this.mRootExtrasList.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            ConnectionRecord connectionRecord = new ConnectionRecord(str, -1, i, bundle, null);
            mediaBrowserServiceCompat.mCurConnection = connectionRecord;
            MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            return null;
        }

        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi21$ResultWrapper<List<Parcel>> mediaBrowserServiceCompatApi21$ResultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaItem>>(this, str) {
                public void onResultSent(Object obj) {
                    ArrayList arrayList;
                    List<MediaItem> list = (List) obj;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    mediaBrowserServiceCompatApi21$ResultWrapper.sendResult(arrayList);
                }
            });
        }
    }

    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23$ServiceCompatProxy {
        public MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor mediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor = new MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = mediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor;
            mediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor.onCreate();
        }

        public void onLoadItem(String str, final MediaBrowserServiceCompatApi21$ResultWrapper<Parcel> mediaBrowserServiceCompatApi21$ResultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(new Result<MediaItem>(this, str) {
                public void onResultSent(Object obj) {
                    MediaItem mediaItem = (MediaItem) obj;
                    if (mediaItem == null) {
                        mediaBrowserServiceCompatApi21$ResultWrapper.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    mediaBrowserServiceCompatApi21$ResultWrapper.sendResult(obtain);
                }
            });
        }
    }

    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements ServiceCompatProxy {
        public MediaBrowserServiceImplApi26() {
            super();
        }

        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = createService;
            ((MediaBrowserService) createService).onCreate();
        }

        public void onLoadChildren(String str, final ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren1(str, new Result<List<MediaItem>>(this, str) {
                public void onResultSent(Object obj) {
                    ArrayList<Parcel> arrayList;
                    List<MediaItem> list = (List) obj;
                    ArrayList arrayList2 = null;
                    if (list != null) {
                        arrayList = new ArrayList<>();
                        for (MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    ResultWrapper resultWrapper = resultWrapper;
                    int i = this.mFlags;
                    if (resultWrapper != null) {
                        try {
                            MediaBrowserServiceCompatApi26.sResultFlags.setInt(resultWrapper.mResultObj, i);
                        } catch (IllegalAccessException unused) {
                        }
                        android.service.media.MediaBrowserService.Result result = resultWrapper.mResultObj;
                        if (arrayList != null) {
                            arrayList2 = new ArrayList();
                            for (Parcel parcel : arrayList) {
                                parcel.setDataPosition(0);
                                arrayList2.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                                parcel.recycle();
                            }
                        }
                        result.sendResult(arrayList2);
                        return;
                    }
                    throw null;
                }
            });
        }
    }

    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        public MediaBrowserServiceImplApi28() {
            super();
        }
    }

    public static class Result<T> {
        public final Object mDebug;
        public int mFlags;
        public boolean mSendErrorCalled;
        public boolean mSendResultCalled;

        public Result(Object obj) {
            this.mDebug = obj;
        }

        public boolean isDone() {
            return this.mSendResultCalled || this.mSendErrorCalled;
        }

        public void onErrorSent(Bundle bundle) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("It is not supported to send an error for ");
            outline73.append(this.mDebug);
            throw new UnsupportedOperationException(outline73.toString());
        }

        public abstract void onResultSent(T t);

        public void sendResult(T t) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("sendResult() called when either sendResult() or sendError() had already been called for: ");
                outline73.append(this.mDebug);
                throw new IllegalStateException(outline73.toString());
            }
            this.mSendResultCalled = true;
            onResultSent(null);
        }
    }

    public class ServiceBinderImpl {
        public ServiceBinderImpl() {
        }
    }

    public interface ServiceCallbacks {
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {
        public final Messenger mCallbacks;

        public ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onLoadChildren(String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            sendRequest(3, bundle3);
        }

        public final void sendRequest(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.mCallbacks.send(obtain);
        }
    }

    public final class ServiceHandler extends Handler {
        public final ServiceBinderImpl mServiceBinderImpl = new ServiceBinderImpl();

        public ServiceHandler() {
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            Bundle data = message.getData();
            switch (message2.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    ServiceBinderImpl serviceBinderImpl = this.mServiceBinderImpl;
                    String string = data.getString("data_package_name");
                    int i = data.getInt(MediaSessionCompat.DATA_CALLING_PID);
                    int i2 = data.getInt(MediaSessionCompat.DATA_CALLING_UID);
                    ServiceCallbacksCompat serviceCallbacksCompat = new ServiceCallbacksCompat(message2.replyTo);
                    if (MediaBrowserServiceCompat.this.isValidPackage(string, i2)) {
                        ServiceHandler serviceHandler = MediaBrowserServiceCompat.this.mHandler;
                        AnonymousClass1 r5 = new Runnable(serviceCallbacksCompat, string, i, i2, bundle) {
                            public final /* synthetic */ ServiceCallbacks val$callbacks;
                            public final /* synthetic */ int val$pid;
                            public final /* synthetic */ String val$pkg;
                            public final /* synthetic */ Bundle val$rootHints;
                            public final /* synthetic */ int val$uid;

                            {
                                this.val$callbacks = r2;
                                this.val$pkg = r3;
                                this.val$pid = r4;
                                this.val$uid = r5;
                                this.val$rootHints = r6;
                            }

                            public void run() {
                                MediaBrowserServiceCompat.this.mConnections.remove(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                                ConnectionRecord connectionRecord = new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                                mediaBrowserServiceCompat.mCurConnection = connectionRecord;
                                mediaBrowserServiceCompat.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                                connectionRecord.root = null;
                                MediaBrowserServiceCompat.this.mCurConnection = null;
                                Class<AnonymousClass1> cls = AnonymousClass1.class;
                                try {
                                    ((ServiceCallbacksCompat) this.val$callbacks).sendRequest(2, null);
                                } catch (RemoteException unused) {
                                }
                            }
                        };
                        serviceHandler.postOrRun(r5);
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + string);
                case 2:
                    ServiceBinderImpl serviceBinderImpl2 = this.mServiceBinderImpl;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(new ServiceCallbacksCompat(message2.replyTo)) {
                        public final /* synthetic */ ServiceCallbacks val$callbacks;

                        {
                            this.val$callbacks = r2;
                        }

                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                            if (connectionRecord != null) {
                                ((ServiceCallbacksCompat) connectionRecord.callbacks).asBinder().unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    ServiceBinderImpl serviceBinderImpl3 = this.mServiceBinderImpl;
                    String string2 = data.getString("data_media_item_id");
                    IBinder binder = BundleCompat.getBinder(data, "data_callback_token");
                    ServiceCallbacksCompat serviceCallbacksCompat2 = new ServiceCallbacksCompat(message2.replyTo);
                    ServiceHandler serviceHandler2 = MediaBrowserServiceCompat.this.mHandler;
                    AnonymousClass3 r52 = new Runnable(serviceCallbacksCompat2, string2, binder, bundle2) {
                        public final /* synthetic */ ServiceCallbacks val$callbacks;
                        public final /* synthetic */ String val$id;
                        public final /* synthetic */ Bundle val$options;
                        public final /* synthetic */ IBinder val$token;

                        {
                            this.val$callbacks = r2;
                            this.val$id = r3;
                            this.val$token = r4;
                            this.val$options = r5;
                        }

                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                            if (connectionRecord != null) {
                                MediaBrowserServiceCompat.this.addSubscription(this.val$id, connectionRecord, this.val$token, this.val$options);
                            }
                        }
                    };
                    serviceHandler2.postOrRun(r52);
                    return;
                case 4:
                    ServiceBinderImpl serviceBinderImpl4 = this.mServiceBinderImpl;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(new ServiceCallbacksCompat(message2.replyTo), data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token")) {
                        public final /* synthetic */ ServiceCallbacks val$callbacks;
                        public final /* synthetic */ String val$id;
                        public final /* synthetic */ IBinder val$token;

                        {
                            this.val$callbacks = r2;
                            this.val$id = r3;
                            this.val$token = r4;
                        }

                        public void run() {
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                            if (connectionRecord != null) {
                                boolean removeSubscription = MediaBrowserServiceCompat.this.removeSubscription(this.val$id, connectionRecord, this.val$token);
                            }
                        }
                    });
                    return;
                case 5:
                    ServiceBinderImpl serviceBinderImpl5 = this.mServiceBinderImpl;
                    String string3 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat serviceCallbacksCompat3 = new ServiceCallbacksCompat(message2.replyTo);
                    if (serviceBinderImpl5 == null) {
                        throw null;
                    } else if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(serviceCallbacksCompat3, string3, resultReceiver) {
                            public final /* synthetic */ ServiceCallbacks val$callbacks;
                            public final /* synthetic */ String val$mediaId;
                            public final /* synthetic */ ResultReceiver val$receiver;

                            {
                                this.val$callbacks = r2;
                                this.val$mediaId = r3;
                                this.val$receiver = r4;
                            }

                            public void run() {
                                ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                                if (connectionRecord != null) {
                                    MediaBrowserServiceCompat.this.performLoadItem(this.val$mediaId, connectionRecord, this.val$receiver);
                                }
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    ServiceBinderImpl serviceBinderImpl6 = this.mServiceBinderImpl;
                    ServiceCallbacksCompat serviceCallbacksCompat4 = new ServiceCallbacksCompat(message2.replyTo);
                    String string4 = data.getString("data_package_name");
                    int i3 = data.getInt(MediaSessionCompat.DATA_CALLING_PID);
                    int i4 = data.getInt(MediaSessionCompat.DATA_CALLING_UID);
                    ServiceHandler serviceHandler3 = MediaBrowserServiceCompat.this.mHandler;
                    AnonymousClass6 r53 = new Runnable(serviceCallbacksCompat4, string4, i3, i4, bundle3) {
                        public final /* synthetic */ ServiceCallbacks val$callbacks;
                        public final /* synthetic */ int val$pid;
                        public final /* synthetic */ String val$pkg;
                        public final /* synthetic */ Bundle val$rootHints;
                        public final /* synthetic */ int val$uid;

                        {
                            this.val$callbacks = r2;
                            this.val$pkg = r3;
                            this.val$pid = r4;
                            this.val$uid = r5;
                            this.val$rootHints = r6;
                        }

                        public void run() {
                            IBinder asBinder = ((ServiceCallbacksCompat) this.val$callbacks).asBinder();
                            MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                            ConnectionRecord connectionRecord = new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                            MediaBrowserServiceCompat.this.mConnections.put(asBinder, connectionRecord);
                            try {
                                asBinder.linkToDeath(connectionRecord, 0);
                            } catch (RemoteException unused) {
                            }
                        }
                    };
                    serviceHandler3.postOrRun(r53);
                    return;
                case 7:
                    ServiceBinderImpl serviceBinderImpl7 = this.mServiceBinderImpl;
                    MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable(new ServiceCallbacksCompat(message2.replyTo)) {
                        public final /* synthetic */ ServiceCallbacks val$callbacks;

                        {
                            this.val$callbacks = r2;
                        }

                        public void run() {
                            IBinder asBinder = ((ServiceCallbacksCompat) this.val$callbacks).asBinder();
                            ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                            if (connectionRecord != null) {
                                asBinder.unlinkToDeath(connectionRecord, 0);
                            }
                        }
                    });
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    ServiceBinderImpl serviceBinderImpl8 = this.mServiceBinderImpl;
                    String string5 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat serviceCallbacksCompat5 = new ServiceCallbacksCompat(message2.replyTo);
                    if (serviceBinderImpl8 == null) {
                        throw null;
                    } else if (!TextUtils.isEmpty(string5) && resultReceiver2 != null) {
                        ServiceHandler serviceHandler4 = MediaBrowserServiceCompat.this.mHandler;
                        AnonymousClass8 r11 = new Runnable(serviceCallbacksCompat5, string5, bundle4, resultReceiver2) {
                            public final /* synthetic */ ServiceCallbacks val$callbacks;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ String val$query;
                            public final /* synthetic */ ResultReceiver val$receiver;

                            {
                                this.val$callbacks = r2;
                                this.val$query = r3;
                                this.val$extras = r4;
                                this.val$receiver = r5;
                            }

                            public void run() {
                                ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                                if (connectionRecord != null) {
                                    MediaBrowserServiceCompat.this.performSearch(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
                                }
                            }
                        };
                        serviceHandler4.postOrRun(r11);
                        return;
                    } else {
                        return;
                    }
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    ServiceBinderImpl serviceBinderImpl9 = this.mServiceBinderImpl;
                    String string6 = data.getString("data_custom_action");
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat serviceCallbacksCompat6 = new ServiceCallbacksCompat(message2.replyTo);
                    if (serviceBinderImpl9 == null) {
                        throw null;
                    } else if (!TextUtils.isEmpty(string6) && resultReceiver3 != null) {
                        ServiceHandler serviceHandler5 = MediaBrowserServiceCompat.this.mHandler;
                        AnonymousClass9 r112 = new Runnable(serviceCallbacksCompat6, string6, bundle5, resultReceiver3) {
                            public final /* synthetic */ String val$action;
                            public final /* synthetic */ ServiceCallbacks val$callbacks;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ ResultReceiver val$receiver;

                            {
                                this.val$callbacks = r2;
                                this.val$action = r3;
                                this.val$extras = r4;
                                this.val$receiver = r5;
                            }

                            public void run() {
                                ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) this.val$callbacks).asBinder());
                                if (connectionRecord == null) {
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("sendCustomAction for callback that isn't registered action=");
                                    outline73.append(this.val$action);
                                    outline73.append(", extras=");
                                    outline73.append(this.val$extras);
                                    outline73.toString();
                                    return;
                                }
                                MediaBrowserServiceCompat.this.performCustomAction(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
                            }
                        };
                        serviceHandler5.postOrRun(r112);
                        return;
                    } else {
                        return;
                    }
                default:
                    "Unhandled message: " + message2 + "\n  Service version: " + 2 + "\n  Client version: " + message2.arg1;
                    return;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaSessionCompat.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaSessionCompat.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    public void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.first && CompoundButtonCompat.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        connectionRecord.subscriptions.put(str, list);
        performLoadChildren(str, connectionRecord, bundle, null);
        onSubscribe();
    }

    public List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i = VERSION.SDK_INT;
        if (i >= 28) {
            this.mImpl = new MediaBrowserServiceImplApi28();
        } else if (i >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi26();
        } else if (i >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23();
        } else {
            this.mImpl = new MediaBrowserServiceImplApi21();
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(Result result) {
        if (result.mSendResultCalled || result.mSendErrorCalled) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("sendError() called when either sendResult() or sendError() had already been called for: ");
            outline73.append(result.mDebug);
            throw new IllegalStateException(outline73.toString());
        }
        result.mSendErrorCalled = true;
        result.onErrorSent(null);
    }

    public abstract void onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaItem>> result);

    public void onLoadChildren1(String str, Result result) {
        result.mFlags = 1;
        onLoadChildren(str, result);
    }

    public void onLoadItem(Result result) {
        result.mFlags = 2;
        result.sendResult(null);
    }

    public void onSearch(Result result) {
        result.mFlags = 4;
        result.sendResult(null);
    }

    public void onSubscribe() {
    }

    public void onUnsubscribe() {
    }

    public void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass4 r4 = new Result<Bundle>(str) {
            public void onErrorSent(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }

            public void onResultSent(Object obj) {
                resultReceiver.send(0, (Bundle) obj);
            }
        };
        onCustomAction(r4);
        if (!r4.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        AnonymousClass1 r0 = new Result<List<MediaItem>>(str, null) {
            public void onResultSent(Object obj) {
                List<MediaItem> list = (List) obj;
                Object obj2 = MediaBrowserServiceCompat.this.mConnections.get(((ServiceCallbacksCompat) connectionRecord2.callbacks).asBinder());
                ConnectionRecord connectionRecord = connectionRecord2;
                if (obj2 == connectionRecord) {
                    if ((this.mFlags & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.applyOptions(list, bundle3);
                    }
                    try {
                        ((ServiceCallbacksCompat) connectionRecord2.callbacks).onLoadChildren(str2, list, bundle3, null);
                    } catch (RemoteException unused) {
                        String str = connectionRecord2.pkg;
                    }
                } else if (MediaBrowserServiceCompat.DEBUG) {
                    String str2 = connectionRecord.pkg;
                }
            }
        };
        if (bundle == null) {
            onLoadChildren(str, r0);
        } else {
            onLoadChildren1(str, r0);
        }
        if (!r0.isDone()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline63(GeneratedOutlineSupport.outline73("onLoadChildren must call detach() or sendResult() before returning for package="), connectionRecord.pkg, " id=", str));
        }
    }

    public void performLoadItem(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass2 r2 = new Result<MediaItem>(str) {
            public void onResultSent(Object obj) {
                MediaItem mediaItem = (MediaItem) obj;
                if ((this.mFlags & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        onLoadItem(r2);
        if (!r2.isDone()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("onLoadItem must call detach() or sendResult() before returning for id=", str));
        }
    }

    public void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass3 r2 = new Result<List<MediaItem>>(str) {
            public void onResultSent(Object obj) {
                List list = (List) obj;
                if ((this.mFlags & 4) != 0 || list == null) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaItem[0]));
                resultReceiver.send(0, bundle);
            }
        };
        onSearch(r2);
        if (!r2.isDone()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("onSearch must call detach() or sendResult() before returning for query=", str));
        }
    }

    public boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        if (iBinder == null) {
            try {
                if (connectionRecord.subscriptions.remove(str) != null) {
                    z = true;
                }
                return z;
            } finally {
                onUnsubscribe();
            }
        } else {
            List list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            onUnsubscribe();
            return z;
        }
    }
}
