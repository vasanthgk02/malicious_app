package com.clevertap.android.sdk.login;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Utils;
import org.apache.fontbox.cmap.CMapParser;

public class LegacyIdentityRepo implements IdentityRepo {
    public final CleverTapInstanceConfig config;
    public IdentitySet identities = new IdentitySet(Constants.LEGACY_IDENTITY_KEYS);

    public LegacyIdentityRepo(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.config = cleverTapInstanceConfig;
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.config;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LegacyIdentityRepo Setting the default IdentitySet[");
        outline73.append(this.identities);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("ON_USER_LOGIN"), outline73.toString());
    }

    public IdentitySet getIdentitySet() {
        return this.identities;
    }

    public boolean hasIdentity(String str) {
        boolean containsIgnoreCase = Utils.containsIgnoreCase(this.identities.identities, str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "isIdentity [Key: " + str + " , Value: " + containsIgnoreCase + CMapParser.MARK_END_OF_ARRAY);
        return containsIgnoreCase;
    }
}
