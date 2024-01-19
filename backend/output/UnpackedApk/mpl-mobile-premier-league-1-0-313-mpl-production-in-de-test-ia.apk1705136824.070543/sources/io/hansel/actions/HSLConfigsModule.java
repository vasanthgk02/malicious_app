package io.hansel.actions;

import android.content.Context;
import io.hansel.actions.configs.b;
import io.hansel.actions.configs.h;
import io.hansel.actions.configs.i;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import io.hansel.core.utils.HSLUtils;

public class HSLConfigsModule extends HSLModule {
    public b mDefaultConfigsSource;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5048a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5048a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_CONFIG_VALUE_FOR_CONFIG_NAME     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 69
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5048a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.HANDLE_DEEP_CONFIGS     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 15
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.HSLConfigsModule.a.<clinit>():void");
        }
    }

    public String getCode() {
        return "actm";
    }

    public String[] getPublishingEvents() {
        return new String[]{EventsConstants.HANSEL_DATA_STORE_EVENT_INIT_MESSAGE.name()};
    }

    public String[] getSubscribingEvents() {
        return new String[]{EventsConstants.HANSEL_DATA_STORE_EVENT_APP_START.name(), EventsConstants.REGISTER_CONFIG_SOURCE.name(), EventsConstants.HANDLE_DEEP_CONFIGS.name(), EventsConstants.GET_CONFIG_VALUE_FOR_CONFIG_NAME.name()};
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            if (a.f5048a[EventsConstants.valueOf(str).ordinal()] != 2) {
                return h.a().a(str, obj);
            }
            b bVar = this.mDefaultConfigsSource;
            if (bVar != null && (obj instanceof CoreJSONObject)) {
                bVar.clear();
                io.hansel.actions.configs.a.b().a(i.a((CoreJSONObject) obj));
            }
            return true;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        Context applicationContext = hSLModuleInitializationData.app.getApplicationContext();
        h.a().a(hSLModuleInitializationData, iMessageBroker);
        io.hansel.actions.configs.a.b().a(applicationContext);
        this.mDefaultConfigsSource = new b(applicationContext, hSLModuleInitializationData.sdkIdentifiers.getAppVersion());
        getLinkedMessageBroker().publishEvent(EventsConstants.REGISTER_CONFIG_SOURCE.name(), this.mDefaultConfigsSource);
        io.hansel.actions.configs.a.b().a(getLinkedMessageBroker());
        try {
            if (!hSLModuleInitializationData.isDeviceIdLogEnabled) {
                String b2 = io.hansel.actions.configs.a.b("_hsl_enable_device_id_log");
                if (HSLUtils.isSet(b2)) {
                    Object config = this.mDefaultConfigsSource.getConfig(b2, HSLConfigDataType.bool);
                    if (config != null && Boolean.parseBoolean(String.valueOf(config))) {
                        HSLLogger.i("Your device id : " + hSLModuleInitializationData.sdkIdentifiers.deviceId);
                        HSLLogger.i("Your guid id : " + hSLModuleInitializationData.sdkIdentifiers.guid);
                    }
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public Object returnEventData(String str, Object obj) {
        if (str == null) {
            return null;
        }
        try {
            if (a.f5048a[EventsConstants.valueOf(str).ordinal()] == 1) {
                if (obj instanceof String) {
                    return h.a().a((String) obj, (String) null);
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return null;
    }
}
