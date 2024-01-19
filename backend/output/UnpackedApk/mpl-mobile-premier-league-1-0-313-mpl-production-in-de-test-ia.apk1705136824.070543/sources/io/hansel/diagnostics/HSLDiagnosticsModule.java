package io.hansel.diagnostics;

import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.core.security.ICrypto;

public class HSLDiagnosticsModule extends HSLModule {
    public String getCode() {
        return "dm";
    }

    public String[] getPublishingEvents() {
        return new String[0];
    }

    public String[] getSubscribingEvents() {
        return new String[0];
    }

    public boolean handleEventData(String str, Object obj) {
        return false;
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        a a2 = a.a();
        HSLSDKIdentifiers hSLSDKIdentifiers = hSLModuleInitializationData.sdkIdentifiers;
        a2.a(hSLSDKIdentifiers.appId, hSLSDKIdentifiers.secret);
    }
}
