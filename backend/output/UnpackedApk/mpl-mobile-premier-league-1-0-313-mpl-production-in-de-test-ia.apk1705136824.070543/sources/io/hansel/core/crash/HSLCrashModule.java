package io.hansel.core.crash;

import io.hansel.core.c;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import java.lang.Thread.UncaughtExceptionHandler;

public class HSLCrashModule extends HSLModule {
    public String getCode() {
        return "crm";
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
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == null || !(defaultUncaughtExceptionHandler instanceof c)) {
            Thread.setDefaultUncaughtExceptionHandler(new c());
        }
    }
}
