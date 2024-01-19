package com.google.firebase.installations;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.badlogic.gdx.graphics.GL20;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException.Status;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult.ResponseCode;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {
    public static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.mCount.getAndIncrement())}));
        }
    };
    public static final Object lockGenerateFid = new Object();
    public final ExecutorService backgroundExecutor;
    public String cachedFid;
    public final RandomFidGenerator fidGenerator;
    public Set<FidListener> fidListeners = new HashSet();
    public final FirebaseApp firebaseApp;
    public final IidStore iidStore;
    public final List<StateListener> listeners = new ArrayList();
    public final Object lock = new Object();
    public final ExecutorService networkExecutor;
    public final PersistedInstallation persistedInstallation;
    public final FirebaseInstallationServiceClient serviceClient;
    public final Utils utils;

    public FirebaseInstallations(FirebaseApp firebaseApp2, Provider<HeartBeatController> provider) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        firebaseApp2.checkNotDeleted();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp3.applicationContext, provider);
        PersistedInstallation persistedInstallation2 = new PersistedInstallation(firebaseApp3);
        Utils instance = Utils.getInstance();
        IidStore iidStore2 = new IidStore(firebaseApp3);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.firebaseApp = firebaseApp3;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = persistedInstallation2;
        this.utils = instance;
        this.iidStore = iidStore2;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        this.networkExecutor = threadPoolExecutor2;
    }

    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0062 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b9  */
    /* renamed from: doNetworkCallIfNecessary */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lambda$doRegistrationOrRefresh$2$FirebaseInstallations(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = lockGenerateFid
            monitor-enter(r0)
            com.google.firebase.FirebaseApp r1 = r4.firebaseApp     // Catch:{ all -> 0x00e7 }
            r1.checkNotDeleted()     // Catch:{ all -> 0x00e7 }
            android.content.Context r1 = r1.applicationContext     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = "generatefid.lock"
            com.google.firebase.installations.CrossProcessLock r1 = com.google.firebase.installations.CrossProcessLock.acquire(r1, r2)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.installations.local.PersistedInstallation r2 = r4.persistedInstallation     // Catch:{ all -> 0x00e0 }
            com.google.firebase.installations.local.PersistedInstallationEntry r2 = r2.readPersistedInstallationEntryValue()     // Catch:{ all -> 0x00e0 }
            if (r1 == 0) goto L_0x001b
            r1.releaseAndClose()     // Catch:{ all -> 0x00e7 }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x00e7 }
            boolean r0 = r2.isErrored()     // Catch:{ FirebaseInstallationsException -> 0x00db }
            if (r0 != 0) goto L_0x0042
            r0 = r2
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r0 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r0     // Catch:{ FirebaseInstallationsException -> 0x00db }
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = r0.registrationStatus     // Catch:{ FirebaseInstallationsException -> 0x00db }
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r1 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.UNREGISTERED     // Catch:{ FirebaseInstallationsException -> 0x00db }
            if (r0 != r1) goto L_0x002d
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 == 0) goto L_0x0031
            goto L_0x0042
        L_0x0031:
            if (r5 != 0) goto L_0x003d
            com.google.firebase.installations.Utils r5 = r4.utils     // Catch:{ FirebaseInstallationsException -> 0x00db }
            boolean r5 = r5.isAuthTokenExpired(r2)     // Catch:{ FirebaseInstallationsException -> 0x00db }
            if (r5 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            return
        L_0x003d:
            com.google.firebase.installations.local.PersistedInstallationEntry r5 = r4.fetchAuthTokenFromServer(r2)     // Catch:{ FirebaseInstallationsException -> 0x00db }
            goto L_0x0046
        L_0x0042:
            com.google.firebase.installations.local.PersistedInstallationEntry r5 = r4.registerFidWithServer(r2)     // Catch:{ FirebaseInstallationsException -> 0x00db }
        L_0x0046:
            java.lang.Object r0 = lockGenerateFid
            monitor-enter(r0)
            com.google.firebase.FirebaseApp r1 = r4.firebaseApp     // Catch:{ all -> 0x00d8 }
            r1.checkNotDeleted()     // Catch:{ all -> 0x00d8 }
            android.content.Context r1 = r1.applicationContext     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "generatefid.lock"
            com.google.firebase.installations.CrossProcessLock r1 = com.google.firebase.installations.CrossProcessLock.acquire(r1, r3)     // Catch:{ all -> 0x00d8 }
            com.google.firebase.installations.local.PersistedInstallation r3 = r4.persistedInstallation     // Catch:{ all -> 0x00d1 }
            r3.insertOrUpdatePersistedInstallationEntry(r5)     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0060
            r1.releaseAndClose()     // Catch:{ all -> 0x00d8 }
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x00d8 }
            monitor-enter(r4)
            java.util.Set<com.google.firebase.installations.internal.FidListener> r0 = r4.fidListeners     // Catch:{ all -> 0x00ce }
            int r0 = r0.size()     // Catch:{ all -> 0x00ce }
            if (r0 == 0) goto L_0x0094
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r2     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = r2.firebaseInstallationId     // Catch:{ all -> 0x00ce }
            r1 = r5
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r1 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r1     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = r1.firebaseInstallationId     // Catch:{ all -> 0x00ce }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00ce }
            if (r0 != 0) goto L_0x0094
            java.util.Set<com.google.firebase.installations.internal.FidListener> r0 = r4.fidListeners     // Catch:{ all -> 0x00ce }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ce }
        L_0x007f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00ce }
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00ce }
            com.google.firebase.installations.internal.FidListener r1 = (com.google.firebase.installations.internal.FidListener) r1     // Catch:{ all -> 0x00ce }
            r2 = r5
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r2     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = r2.firebaseInstallationId     // Catch:{ all -> 0x00ce }
            r1.onFidChanged(r2)     // Catch:{ all -> 0x00ce }
            goto L_0x007f
        L_0x0094:
            monitor-exit(r4)
            boolean r0 = r5.isRegistered()
            if (r0 == 0) goto L_0x00a8
            r0 = r5
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r0 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r0
            java.lang.String r0 = r0.firebaseInstallationId
            monitor-enter(r4)
            r4.cachedFid = r0     // Catch:{ all -> 0x00a5 }
            monitor-exit(r4)
            goto L_0x00a8
        L_0x00a5:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x00a8:
            boolean r0 = r5.isErrored()
            if (r0 == 0) goto L_0x00b9
            com.google.firebase.installations.FirebaseInstallationsException r5 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r5.<init>(r0)
            r4.triggerOnException(r5)
            goto L_0x00cd
        L_0x00b9:
            boolean r0 = r5.isNotGenerated()
            if (r0 == 0) goto L_0x00ca
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r5.<init>(r0)
            r4.triggerOnException(r5)
            goto L_0x00cd
        L_0x00ca:
            r4.triggerOnStateReached(r5)
        L_0x00cd:
            return
        L_0x00ce:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x00d1:
            r5 = move-exception
            if (r1 == 0) goto L_0x00d7
            r1.releaseAndClose()     // Catch:{ all -> 0x00d8 }
        L_0x00d7:
            throw r5     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d8 }
            throw r5
        L_0x00db:
            r5 = move-exception
            r4.triggerOnException(r5)
            return
        L_0x00e0:
            r5 = move-exception
            if (r1 == 0) goto L_0x00e6
            r1.releaseAndClose()     // Catch:{ all -> 0x00e7 }
        L_0x00e6:
            throw r5     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e7 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.lambda$doRegistrationOrRefresh$2$FirebaseInstallations(boolean):void");
    }

    /* renamed from: doRegistrationOrRefresh */
    public final void lambda$getToken$1$FirebaseInstallations(boolean z) {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            FirebaseApp firebaseApp2 = this.firebaseApp;
            firebaseApp2.checkNotDeleted();
            CrossProcessLock acquire = CrossProcessLock.acquire(firebaseApp2.applicationContext, "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    String readExistingIidOrCreateFid = readExistingIidOrCreateFid(readPersistedInstallationEntryValue);
                    PersistedInstallation persistedInstallation2 = this.persistedInstallation;
                    Builder builder = (Builder) readPersistedInstallationEntryValue.toBuilder();
                    builder.firebaseInstallationId = readExistingIidOrCreateFid;
                    builder.setRegistrationStatus(RegistrationStatus.UNREGISTERED);
                    readPersistedInstallationEntryValue = builder.build();
                    persistedInstallation2.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue);
                }
            } finally {
                if (acquire != null) {
                    acquire.releaseAndClose();
                }
            }
        }
        if (z) {
            Builder builder2 = (Builder) readPersistedInstallationEntryValue.toBuilder();
            builder2.authToken = null;
            readPersistedInstallationEntryValue = builder2.build();
        }
        triggerOnStateReached(readPersistedInstallationEntryValue);
        this.networkExecutor.execute(new Runnable(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FirebaseInstallations.this.lambda$doRegistrationOrRefresh$2$FirebaseInstallations(this.f$1);
            }
        });
    }

    public final PersistedInstallationEntry fetchAuthTokenFromServer(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult readGenerateAuthTokenResponse;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        String apiKey = getApiKey();
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        String projectIdentifier = getProjectIdentifier();
        String str2 = autoValue_PersistedInstallationEntry.refreshToken;
        if (firebaseInstallationServiceClient.requestLimiter.isRequestAllowed()) {
            URL fullyQualifiedRequestUri = firebaseInstallationServiceClient.getFullyQualifiedRequestUri(String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{projectIdentifier, str}));
            int i = 0;
            while (i <= 1) {
                TrafficStats.setThreadStatsTag(GL20.GL_CONSTANT_ALPHA);
                HttpURLConnection openHttpURLConnection = firebaseInstallationServiceClient.openHttpURLConnection(fullyQualifiedRequestUri, apiKey);
                try {
                    openHttpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
                    openHttpURLConnection.addRequestProperty("Authorization", "FIS_v2 " + str2);
                    openHttpURLConnection.setDoOutput(true);
                    firebaseInstallationServiceClient.writeGenerateAuthTokenRequestBodyToOutputStream(openHttpURLConnection);
                    int responseCode = openHttpURLConnection.getResponseCode();
                    firebaseInstallationServiceClient.requestLimiter.setNextRequestTime(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        readGenerateAuthTokenResponse = firebaseInstallationServiceClient.readGenerateAuthTokenResponse(openHttpURLConnection);
                    } else {
                        FirebaseInstallationServiceClient.logFisCommunicationError(openHttpURLConnection, null, apiKey, projectIdentifier);
                        if (responseCode != 401) {
                            if (responseCode != 404) {
                                if (responseCode == 429) {
                                    throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", Status.TOO_MANY_REQUESTS);
                                } else if (responseCode < 500 || responseCode >= 600) {
                                    AutoValue_TokenResult.Builder builder = (AutoValue_TokenResult.Builder) TokenResult.builder();
                                    builder.responseCode = ResponseCode.BAD_CONFIG;
                                    readGenerateAuthTokenResponse = builder.build();
                                } else {
                                    openHttpURLConnection.disconnect();
                                    TrafficStats.clearThreadStatsTag();
                                    i++;
                                }
                            }
                        }
                        AutoValue_TokenResult.Builder builder2 = (AutoValue_TokenResult.Builder) TokenResult.builder();
                        builder2.responseCode = ResponseCode.AUTH_ERROR;
                        readGenerateAuthTokenResponse = builder2.build();
                    }
                    openHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    AutoValue_TokenResult autoValue_TokenResult = (AutoValue_TokenResult) readGenerateAuthTokenResponse;
                    int ordinal = autoValue_TokenResult.responseCode.ordinal();
                    if (ordinal == 0) {
                        String str3 = autoValue_TokenResult.token;
                        long j = autoValue_TokenResult.tokenExpirationTimestamp;
                        long currentTimeInSecs = this.utils.currentTimeInSecs();
                        Builder builder3 = (Builder) persistedInstallationEntry.toBuilder();
                        builder3.authToken = str3;
                        builder3.expiresInSecs = Long.valueOf(j);
                        builder3.tokenCreationEpochInSecs = Long.valueOf(currentTimeInSecs);
                        return builder3.build();
                    } else if (ordinal == 1) {
                        Builder builder4 = (Builder) persistedInstallationEntry.toBuilder();
                        builder4.fisError = "BAD CONFIG";
                        builder4.setRegistrationStatus(RegistrationStatus.REGISTER_ERROR);
                        return builder4.build();
                    } else if (ordinal == 2) {
                        synchronized (this) {
                            this.cachedFid = null;
                        }
                        PersistedInstallationEntry.Builder builder5 = persistedInstallationEntry.toBuilder();
                        builder5.setRegistrationStatus(RegistrationStatus.NOT_GENERATED);
                        return builder5.build();
                    } else {
                        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", Status.UNAVAILABLE);
                    }
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    openHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", Status.UNAVAILABLE);
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", Status.UNAVAILABLE);
    }

    public String getApiKey() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.apiKey;
    }

    public String getApplicationId() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.applicationId;
    }

    public Task<String> getId() {
        String str;
        preConditionChecks();
        synchronized (this) {
            try {
                str = this.cachedFid;
            }
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.lock) {
            try {
                this.listeners.add(getIdListener);
            }
        }
        zzw zzw = taskCompletionSource.zza;
        this.backgroundExecutor.execute(new Runnable() {
            public final void run() {
                FirebaseInstallations.this.lambda$getId$0$FirebaseInstallations();
            }
        });
        return zzw;
    }

    public String getProjectIdentifier() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.options.projectId;
    }

    public Task<InstallationTokenResult> getToken(boolean z) {
        preConditionChecks();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getAuthTokenListener);
        }
        zzw zzw = taskCompletionSource.zza;
        this.backgroundExecutor.execute(new Runnable(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FirebaseInstallations.this.lambda$getToken$1$FirebaseInstallations(this.f$1);
            }
        });
        return zzw;
    }

    public /* synthetic */ void lambda$getId$0$FirebaseInstallations() {
        lambda$getToken$1$FirebaseInstallations(false);
    }

    public final void preConditionChecks() {
        Preconditions.checkNotEmpty(getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(getProjectIdentifier(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.isValidAppIdFormat(getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.API_KEY_FORMAT.matcher(getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String readExistingIidOrCreateFid(PersistedInstallationEntry persistedInstallationEntry) {
        String string;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        if (firebaseApp2.name.equals("CHIME_ANDROID_SDK") || this.firebaseApp.isDefaultApp()) {
            if (((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).registrationStatus == RegistrationStatus.ATTEMPT_MIGRATION) {
                IidStore iidStore2 = this.iidStore;
                synchronized (iidStore2.iidPrefs) {
                    synchronized (iidStore2.iidPrefs) {
                        string = iidStore2.iidPrefs.getString("|S|id", null);
                    }
                    if (string == null) {
                        string = iidStore2.readPublicKeyFromLocalStorageAndCalculateInstanceId();
                    }
                }
                if (TextUtils.isEmpty(string)) {
                    string = this.fidGenerator.createRandomFid();
                }
                return string;
            }
        }
        return this.fidGenerator.createRandomFid();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        if (r9.startsWith("{") == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4 = new org.json.JSONObject(r9).getString("token");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r4 = r9;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.installations.local.PersistedInstallationEntry registerFidWithServer(com.google.firebase.installations.local.PersistedInstallationEntry r23) throws com.google.firebase.installations.FirebaseInstallationsException {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r0 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry) r0
            java.lang.String r2 = r0.firebaseInstallationId
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0069
            int r2 = r2.length()
            r5 = 11
            if (r2 != r5) goto L_0x0069
            com.google.firebase.installations.local.IidStore r2 = r1.iidStore
            android.content.SharedPreferences r5 = r2.iidPrefs
            monitor-enter(r5)
            java.lang.String[] r6 = com.google.firebase.installations.local.IidStore.ALLOWABLE_SCOPES     // Catch:{ all -> 0x0066 }
            int r7 = r6.length     // Catch:{ all -> 0x0066 }
            r8 = 0
        L_0x001d:
            if (r8 >= r7) goto L_0x0064
            r9 = r6[r8]     // Catch:{ all -> 0x0066 }
            java.lang.String r10 = r2.defaultSenderId     // Catch:{ all -> 0x0066 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r11.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r12 = "|T|"
            r11.append(r12)     // Catch:{ all -> 0x0066 }
            r11.append(r10)     // Catch:{ all -> 0x0066 }
            java.lang.String r10 = "|"
            r11.append(r10)     // Catch:{ all -> 0x0066 }
            r11.append(r9)     // Catch:{ all -> 0x0066 }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x0066 }
            android.content.SharedPreferences r10 = r2.iidPrefs     // Catch:{ all -> 0x0066 }
            java.lang.String r9 = r10.getString(r9, r4)     // Catch:{ all -> 0x0066 }
            if (r9 == 0) goto L_0x0061
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r10 != 0) goto L_0x0061
            java.lang.String r2 = "{"
            boolean r2 = r9.startsWith(r2)     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x005e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005f }
            r2.<init>(r9)     // Catch:{ JSONException -> 0x005f }
            java.lang.String r6 = "token"
            java.lang.String r4 = r2.getString(r6)     // Catch:{ JSONException -> 0x005f }
            goto L_0x005f
        L_0x005e:
            r4 = r9
        L_0x005f:
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            goto L_0x0069
        L_0x0061:
            int r8 = r8 + 1
            goto L_0x001d
        L_0x0064:
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            goto L_0x0069
        L_0x0066:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            throw r0
        L_0x0069:
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient r2 = r1.serviceClient
            java.lang.String r5 = r22.getApiKey()
            java.lang.String r0 = r0.firebaseInstallationId
            java.lang.String r6 = r22.getProjectIdentifier()
            java.lang.String r7 = r22.getApplicationId()
            com.google.firebase.installations.remote.RequestLimiter r8 = r2.requestLimiter
            boolean r8 = r8.isRequestAllowed()
            java.lang.String r9 = "Firebase Installations Service is unavailable. Please try again later."
            if (r8 == 0) goto L_0x017e
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r10[r3] = r6
            java.lang.String r11 = "projects/%s/installations"
            java.lang.String r10 = java.lang.String.format(r11, r10)
            java.net.URL r10 = r2.getFullyQualifiedRequestUri(r10)
            r11 = 0
        L_0x0093:
            if (r11 > r8) goto L_0x0176
            r12 = 32769(0x8001, float:4.5919E-41)
            android.net.TrafficStats.setThreadStatsTag(r12)
            java.net.HttpURLConnection r12 = r2.openHttpURLConnection(r10, r5)
            java.lang.String r13 = "POST"
            r12.setRequestMethod(r13)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r12.setDoOutput(r8)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            if (r4 == 0) goto L_0x00ae
            java.lang.String r13 = "x-goog-fis-android-iid-migration-auth"
            r12.addRequestProperty(r13, r4)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
        L_0x00ae:
            r2.writeFIDCreateRequestBodyToOutputStream(r12, r0, r7)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            int r13 = r12.getResponseCode()     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            com.google.firebase.installations.remote.RequestLimiter r14 = r2.requestLimiter     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r14.setNextRequestTime(r13)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 < r14) goto L_0x00c4
            r14 = 300(0x12c, float:4.2E-43)
            if (r13 >= r14) goto L_0x00c4
            r14 = 1
            goto L_0x00c5
        L_0x00c4:
            r14 = 0
        L_0x00c5:
            if (r14 == 0) goto L_0x00d2
            com.google.firebase.installations.remote.InstallationResponse r0 = r2.readCreateResponse(r12)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r12.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            goto L_0x00fc
        L_0x00d2:
            com.google.firebase.installations.remote.FirebaseInstallationServiceClient.logFisCommunicationError(r12, r7, r5, r6)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r14 = 429(0x1ad, float:6.01E-43)
            if (r13 == r14) goto L_0x015a
            r14 = 500(0x1f4, float:7.0E-43)
            if (r13 < r14) goto L_0x00e3
            r14 = 600(0x258, float:8.41E-43)
            if (r13 >= r14) goto L_0x00e3
            goto L_0x016c
        L_0x00e3:
            r19 = 0
            r18 = 0
            r17 = 0
            r16 = 0
            com.google.firebase.installations.remote.InstallationResponse$ResponseCode r20 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            com.google.firebase.installations.remote.AutoValue_InstallationResponse r13 = new com.google.firebase.installations.remote.AutoValue_InstallationResponse     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r21 = 0
            r15 = r13
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r12.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            r0 = r13
        L_0x00fc:
            com.google.firebase.installations.remote.AutoValue_InstallationResponse r0 = (com.google.firebase.installations.remote.AutoValue_InstallationResponse) r0
            com.google.firebase.installations.remote.InstallationResponse$ResponseCode r2 = r0.responseCode
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x0126
            if (r2 != r8) goto L_0x011c
            java.lang.String r0 = "BAD CONFIG"
            com.google.firebase.installations.local.PersistedInstallationEntry$Builder r2 = r23.toBuilder()
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r2 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder) r2
            r2.fisError = r0
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.REGISTER_ERROR
            r2.setRegistrationStatus(r0)
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.build()
            return r0
        L_0x011c:
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            java.lang.String r2 = "Firebase Installations Service is unavailable. Please try again later."
            com.google.firebase.installations.FirebaseInstallationsException$Status r3 = com.google.firebase.installations.FirebaseInstallationsException.Status.UNAVAILABLE
            r0.<init>(r2, r3)
            throw r0
        L_0x0126:
            java.lang.String r2 = r0.fid
            java.lang.String r3 = r0.refreshToken
            com.google.firebase.installations.Utils r4 = r1.utils
            long r4 = r4.currentTimeInSecs()
            com.google.firebase.installations.remote.TokenResult r0 = r0.authToken
            com.google.firebase.installations.remote.AutoValue_TokenResult r0 = (com.google.firebase.installations.remote.AutoValue_TokenResult) r0
            java.lang.String r6 = r0.token
            long r7 = r0.tokenExpirationTimestamp
            com.google.firebase.installations.local.PersistedInstallationEntry$Builder r0 = r23.toBuilder()
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r0 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder) r0
            r0.firebaseInstallationId = r2
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r2 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.REGISTERED
            r0.setRegistrationStatus(r2)
            r0.authToken = r6
            r0.refreshToken = r3
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r0.expiresInSecs = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.tokenCreationEpochInSecs = r2
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r0.build()
            return r0
        L_0x015a:
            com.google.firebase.installations.FirebaseInstallationsException r13 = new com.google.firebase.installations.FirebaseInstallationsException     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            java.lang.String r14 = "Firebase servers have received too many requests from this client in a short period of time. Please try again later."
            com.google.firebase.installations.FirebaseInstallationsException$Status r15 = com.google.firebase.installations.FirebaseInstallationsException.Status.TOO_MANY_REQUESTS     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            r13.<init>(r14, r15)     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
            throw r13     // Catch:{ IOException | AssertionError -> 0x016c, all -> 0x0164 }
        L_0x0164:
            r0 = move-exception
            r12.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            throw r0
        L_0x016c:
            r12.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            int r11 = r11 + 1
            goto L_0x0093
        L_0x0176:
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r2 = com.google.firebase.installations.FirebaseInstallationsException.Status.UNAVAILABLE
            r0.<init>(r9, r2)
            throw r0
        L_0x017e:
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r2 = com.google.firebase.installations.FirebaseInstallationsException.Status.UNAVAILABLE
            r0.<init>(r9, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.registerFidWithServer(com.google.firebase.installations.local.PersistedInstallationEntry):com.google.firebase.installations.local.PersistedInstallationEntry");
    }

    public final void triggerOnException(Exception exc) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onException(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void triggerOnStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.lock) {
            Iterator<StateListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (it.next().onStateReached(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    public static FirebaseInstallations getInstance(FirebaseApp firebaseApp2) {
        Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
        firebaseApp2.checkNotDeleted();
        return (FirebaseInstallations) firebaseApp2.componentRuntime.get(FirebaseInstallationsApi.class);
    }
}
