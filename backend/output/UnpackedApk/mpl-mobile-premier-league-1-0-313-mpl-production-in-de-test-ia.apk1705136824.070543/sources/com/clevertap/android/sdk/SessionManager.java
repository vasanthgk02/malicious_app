package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.validation.Validator;

public class SessionManager extends BaseSessionManager {
    public long appLastSeen = 0;
    public final CoreMetaData cleverTapMetaData;
    public final CleverTapInstanceConfig config;
    public final LocalDataStore localDataStore;
    public final Validator validator;

    public SessionManager(CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, Validator validator2, LocalDataStore localDataStore2) {
        this.config = cleverTapInstanceConfig;
        this.cleverTapMetaData = coreMetaData;
        this.validator = validator2;
        this.localDataStore = localDataStore2;
    }

    public void destroySession() {
        CoreMetaData coreMetaData = this.cleverTapMetaData;
        coreMetaData.currentSessionId = 0;
        coreMetaData.setAppLaunchPushed(false);
        CoreMetaData coreMetaData2 = this.cleverTapMetaData;
        if (coreMetaData2.firstSession) {
            coreMetaData2.firstSession = false;
        }
        this.config.getLogger().verbose(this.config.accountId, (String) "Session destroyed; Session ID is now 0");
        CoreMetaData coreMetaData3 = this.cleverTapMetaData;
        synchronized (coreMetaData3) {
            coreMetaData3.source = null;
        }
        CoreMetaData coreMetaData4 = this.cleverTapMetaData;
        synchronized (coreMetaData4) {
            coreMetaData4.medium = null;
        }
        CoreMetaData coreMetaData5 = this.cleverTapMetaData;
        synchronized (coreMetaData5) {
            coreMetaData5.campaign = null;
        }
        CoreMetaData coreMetaData6 = this.cleverTapMetaData;
        synchronized (coreMetaData6) {
            coreMetaData6.wzrkParams = null;
        }
    }

    public void lazyCreateSession(Context context) {
        if (!this.cleverTapMetaData.inCurrentSession()) {
            this.cleverTapMetaData.firstRequestInSession = true;
            Validator validator2 = this.validator;
            if (validator2 != null) {
                validator2.discardedEvents = null;
            }
            this.cleverTapMetaData.currentSessionId = (int) (System.currentTimeMillis() / 1000);
            Logger logger = this.config.getLogger();
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Session created with ID: ");
            outline73.append(this.cleverTapMetaData.currentSessionId);
            logger.verbose(str, outline73.toString());
            SharedPreferences preferences = k.getPreferences(context);
            int intFromPrefs = k.getIntFromPrefs(context, this.config, "lastSessionId", 0);
            int intFromPrefs2 = k.getIntFromPrefs(context, this.config, "sexe", 0);
            if (intFromPrefs2 > 0) {
                this.cleverTapMetaData.lastSessionLength = intFromPrefs2 - intFromPrefs;
            }
            Logger logger2 = this.config.getLogger();
            String str2 = this.config.accountId;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Last session length: ");
            outline732.append(this.cleverTapMetaData.lastSessionLength);
            outline732.append(" seconds");
            logger2.verbose(str2, outline732.toString());
            if (intFromPrefs == 0) {
                this.cleverTapMetaData.firstSession = true;
            }
            k.persist(preferences.edit().putInt(k.storageKeyWithSuffix(this.config, "lastSessionId"), this.cleverTapMetaData.currentSessionId));
        }
    }
}
