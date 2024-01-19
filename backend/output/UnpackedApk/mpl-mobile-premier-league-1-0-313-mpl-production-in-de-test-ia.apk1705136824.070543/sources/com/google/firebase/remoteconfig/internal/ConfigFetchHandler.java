package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient.BackoffMetadata;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.net.ftp.FTPReply;

public class ConfigFetchHandler {
    public static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final Clock clock;
    public final Map<String, String> customHttpHeaders;
    public final Executor executor;
    public final ConfigCacheClient fetchedConfigsCache;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final ConfigFetchHttpClient frcBackendApiClient;
    public final ConfigMetadataClient frcMetadata;
    public final Random randomGenerator;

    public static class FetchResponse {
        public final Date fetchTime;
        public final ConfigContainer fetchedConfigs;
        public final String lastFetchETag;
        public final int status;

        public FetchResponse(Date date, int i, ConfigContainer configContainer, String str) {
            this.fetchTime = date;
            this.status = i;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider, Executor executor2, Clock clock2, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider;
        this.executor = executor2;
        this.clock = clock2;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = map;
    }

    public final FetchResponse fetchFromBackend(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        String str3;
        boolean z = false;
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcMetadata.frcMetadata.getString("last_fetch_etag", null), this.customHttpHeaders, date);
            if (fetch.lastFetchETag != null) {
                ConfigMetadataClient configMetadataClient = this.frcMetadata;
                String str4 = fetch.lastFetchETag;
                synchronized (configMetadataClient.frcInfoLock) {
                    configMetadataClient.frcMetadata.edit().putString("last_fetch_etag", str4).apply();
                }
            }
            this.frcMetadata.setBackoffMetadata(0, ConfigMetadataClient.NO_BACKOFF_TIME);
            return fetch;
        } catch (FirebaseRemoteConfigServerException e2) {
            int i = e2.httpStatusCode;
            if (i == 429 || i == 502 || i == 503 || i == 504) {
                int i2 = this.frcMetadata.getBackoffMetadata().numFailedFetches + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
                long millis = timeUnit.toMillis((long) iArr[Math.min(i2, iArr.length) - 1]);
                this.frcMetadata.setBackoffMetadata(i2, new Date(date.getTime() + (millis / 2) + ((long) this.randomGenerator.nextInt((int) millis))));
            }
            BackoffMetadata backoffMetadata = this.frcMetadata.getBackoffMetadata();
            int i3 = e2.httpStatusCode;
            if (backoffMetadata.numFailedFetches > 1 || i3 == 429) {
                z = true;
            }
            if (!z) {
                int i4 = e2.httpStatusCode;
                if (i4 == 401) {
                    str3 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
                } else if (i4 == 403) {
                    str3 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                } else if (i4 == 429) {
                    throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                } else if (i4 != 500) {
                    switch (i4) {
                        case FTPReply.COMMAND_NOT_IMPLEMENTED /*502*/:
                        case FTPReply.BAD_COMMAND_SEQUENCE /*503*/:
                        case FTPReply.COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER /*504*/:
                            str3 = "The server is unavailable. Please try again later.";
                            break;
                        default:
                            str3 = "The server returned an unexpected error.";
                            break;
                    }
                } else {
                    str3 = "There was an internal server error.";
                }
                throw new FirebaseRemoteConfigServerException(e2.httpStatusCode, GeneratedOutlineSupport.outline50("Fetch failed: ", str3), e2);
            }
            throw new FirebaseRemoteConfigFetchThrottledException(backoffMetadata.backoffEndTime.getTime());
        }
    }

    /* renamed from: fetchIfCacheExpiredAndNotThrottled */
    public final Task<FetchResponse> lambda$fetch$0$ConfigFetchHandler(Task<ConfigContainer> task, long j) {
        Task task2;
        boolean z;
        Date date = new Date(this.clock.currentTimeMillis());
        Date date2 = null;
        if (task.isSuccessful()) {
            ConfigMetadataClient configMetadataClient = this.frcMetadata;
            if (configMetadataClient != null) {
                Date date3 = new Date(configMetadataClient.frcMetadata.getLong("last_fetch_time_in_millis", -1));
                if (date3.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
                    z = false;
                } else {
                    z = date.before(new Date(TimeUnit.SECONDS.toMillis(j) + date3.getTime()));
                }
                if (z) {
                    return Tasks.forResult(new FetchResponse(date, 2, null, null));
                }
            } else {
                throw null;
            }
        }
        Date date4 = this.frcMetadata.getBackoffMetadata().backoffEndTime;
        if (date.before(date4)) {
            date2 = date4;
        }
        if (date2 != null) {
            task2 = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(String.format("Fetch is throttled. Please wait before calling fetch again: %s", new Object[]{DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(date2.getTime() - date.getTime()))}), date2.getTime()));
        } else {
            Task<String> id = this.firebaseInstallations.getId();
            Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            task2 = Tasks.whenAllComplete(id, token).continueWithTask(this.executor, new Continuation(id, token, date) {
                public final /* synthetic */ Task f$1;
                public final /* synthetic */ Task f$2;
                public final /* synthetic */ Date f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final Object then(Task task) {
                    return ConfigFetchHandler.this.lambda$fetchIfCacheExpiredAndNotThrottled$1$ConfigFetchHandler(this.f$1, this.f$2, this.f$3, task);
                }
            });
        }
        return task2.continueWithTask(this.executor, new Continuation(date) {
            public final /* synthetic */ Date f$1;

            {
                this.f$1 = r2;
            }

            public final Object then(Task task) {
                return ConfigFetchHandler.this.lambda$fetchIfCacheExpiredAndNotThrottled$2$ConfigFetchHandler(this.f$1, task);
            }
        });
    }

    public final Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector2 = (AnalyticsConnector) this.analyticsConnector.get();
        if (analyticsConnector2 == null) {
            return hashMap;
        }
        for (Entry next : analyticsConnector2.getUserProperties(false).entrySet()) {
            hashMap.put((String) next.getKey(), next.getValue().toString());
        }
        return hashMap;
    }

    public Task lambda$fetchIfCacheExpiredAndNotThrottled$1$ConfigFetchHandler(Task task, Task task2, Date date, Task task3) throws Exception {
        Task task4;
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));
        }
        try {
            FetchResponse fetchFromBackend = fetchFromBackend((String) task.getResult(), ((AutoValue_InstallationTokenResult) ((InstallationTokenResult) task2.getResult())).token, date);
            if (fetchFromBackend.status != 0) {
                task4 = Tasks.forResult(fetchFromBackend);
            } else {
                task4 = this.fetchedConfigsCache.put(fetchFromBackend.fetchedConfigs).onSuccessTask(this.executor, new SuccessContinuation() {
                    public final Task then(Object obj) {
                        return Tasks.forResult(FetchResponse.this);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e2) {
            task4 = Tasks.forException(e2);
        }
        return task4;
    }

    public Task lambda$fetchIfCacheExpiredAndNotThrottled$2$ConfigFetchHandler(Date date, Task task) throws Exception {
        if (task.isSuccessful()) {
            ConfigMetadataClient configMetadataClient = this.frcMetadata;
            synchronized (configMetadataClient.frcInfoLock) {
                configMetadataClient.frcMetadata.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
            }
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                    ConfigMetadataClient configMetadataClient2 = this.frcMetadata;
                    synchronized (configMetadataClient2.frcInfoLock) {
                        configMetadataClient2.frcMetadata.edit().putInt("last_fetch_status", 2).apply();
                    }
                } else {
                    ConfigMetadataClient configMetadataClient3 = this.frcMetadata;
                    synchronized (configMetadataClient3.frcInfoLock) {
                        configMetadataClient3.frcMetadata.edit().putInt("last_fetch_status", 1).apply();
                    }
                }
            }
        }
        return task;
    }
}
