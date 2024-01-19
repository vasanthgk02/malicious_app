package com.clevertap.android.sdk.login;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import org.apache.fontbox.cmap.CMapParser;

public class ConfigurableIdentityRepo implements IdentityRepo {
    public final CleverTapInstanceConfig config;
    public IdentitySet identitySet;
    public final LoginInfoProvider infoProvider;
    public final ValidationResultStack validationResultStack;

    public ConfigurableIdentityRepo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, ValidationResultStack validationResultStack2) {
        this.config = cleverTapInstanceConfig;
        LoginInfoProvider loginInfoProvider = new LoginInfoProvider(context, cleverTapInstanceConfig, deviceInfo);
        this.infoProvider = loginInfoProvider;
        this.validationResultStack = validationResultStack2;
        IdentitySet identitySet2 = new IdentitySet(loginInfoProvider.getCachedIdentityKeysForAccount().split(","));
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.config;
        cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("ON_USER_LOGIN"), "ConfigurableIdentityRepoPrefIdentitySet [" + identitySet2 + CMapParser.MARK_END_OF_ARRAY);
        IdentitySet identitySet3 = new IdentitySet(this.config.identityKeys);
        CleverTapInstanceConfig cleverTapInstanceConfig3 = this.config;
        cleverTapInstanceConfig3.logger.verbose(cleverTapInstanceConfig3.getDefaultSuffix("ON_USER_LOGIN"), "ConfigurableIdentityRepoConfigIdentitySet [" + identitySet3 + CMapParser.MARK_END_OF_ARRAY);
        if (!identitySet2.isValid() || !identitySet3.isValid() || identitySet2.equals(identitySet3)) {
            CleverTapInstanceConfig cleverTapInstanceConfig4 = this.config;
            cleverTapInstanceConfig4.logger.verbose(cleverTapInstanceConfig4.getDefaultSuffix("ON_USER_LOGIN"), "ConfigurableIdentityRepoNo error found while comparing [Pref:" + identitySet2 + "], [Config:" + identitySet3 + CMapParser.MARK_END_OF_ARRAY);
        } else {
            this.validationResultStack.pushValidationResult(k.create(531, -1, new String[0]));
            CleverTapInstanceConfig cleverTapInstanceConfig5 = this.config;
            cleverTapInstanceConfig5.logger.verbose(cleverTapInstanceConfig5.getDefaultSuffix("ON_USER_LOGIN"), "ConfigurableIdentityRepopushing error due to mismatch [Pref:" + identitySet2 + "], [Config:" + identitySet3 + CMapParser.MARK_END_OF_ARRAY);
        }
        if (identitySet2.isValid()) {
            this.identitySet = identitySet2;
            CleverTapInstanceConfig cleverTapInstanceConfig6 = this.config;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConfigurableIdentityRepoIdentity Set activated from Pref[");
            outline73.append(this.identitySet);
            outline73.append(CMapParser.MARK_END_OF_ARRAY);
            cleverTapInstanceConfig6.logger.verbose(cleverTapInstanceConfig6.getDefaultSuffix("ON_USER_LOGIN"), outline73.toString());
        } else if (identitySet3.isValid()) {
            this.identitySet = identitySet3;
            CleverTapInstanceConfig cleverTapInstanceConfig7 = this.config;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("ConfigurableIdentityRepoIdentity Set activated from Config[");
            outline732.append(this.identitySet);
            outline732.append(CMapParser.MARK_END_OF_ARRAY);
            cleverTapInstanceConfig7.logger.verbose(cleverTapInstanceConfig7.getDefaultSuffix("ON_USER_LOGIN"), outline732.toString());
        } else {
            this.identitySet = new IdentitySet(Constants.LEGACY_IDENTITY_KEYS);
            CleverTapInstanceConfig cleverTapInstanceConfig8 = this.config;
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("ConfigurableIdentityRepoIdentity Set activated from Default[");
            outline733.append(this.identitySet);
            outline733.append(CMapParser.MARK_END_OF_ARRAY);
            cleverTapInstanceConfig8.logger.verbose(cleverTapInstanceConfig8.getDefaultSuffix("ON_USER_LOGIN"), outline733.toString());
        }
        if (!identitySet2.isValid()) {
            String identitySet4 = this.identitySet.toString();
            LoginInfoProvider loginInfoProvider2 = this.infoProvider;
            k.persist(k.getPreferences(loginInfoProvider2.context).edit().putString(k.storageKeyWithSuffix(loginInfoProvider2.config, "SP_KEY_PROFILE_IDENTITIES"), identitySet4));
            CleverTapInstanceConfig cleverTapInstanceConfig9 = loginInfoProvider2.config;
            cleverTapInstanceConfig9.logger.verbose(cleverTapInstanceConfig9.getDefaultSuffix("ON_USER_LOGIN"), GeneratedOutlineSupport.outline50("saveIdentityKeysForAccount:", identitySet4));
            CleverTapInstanceConfig cleverTapInstanceConfig10 = this.config;
            cleverTapInstanceConfig10.logger.verbose(cleverTapInstanceConfig10.getDefaultSuffix("ON_USER_LOGIN"), GeneratedOutlineSupport.outline52("ConfigurableIdentityRepoSaving Identity Keys in Pref[", identitySet4, CMapParser.MARK_END_OF_ARRAY));
        }
    }

    public IdentitySet getIdentitySet() {
        return this.identitySet;
    }

    public boolean hasIdentity(String str) {
        boolean containsIgnoreCase = Utils.containsIgnoreCase(this.identitySet.identities, str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "ConfigurableIdentityRepoisIdentity [Key: " + str + " , Value: " + containsIgnoreCase + CMapParser.MARK_END_OF_ARRAY);
        return containsIgnoreCase;
    }
}
