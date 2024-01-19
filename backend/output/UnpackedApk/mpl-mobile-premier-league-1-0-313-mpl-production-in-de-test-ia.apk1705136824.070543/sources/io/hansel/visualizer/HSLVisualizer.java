package io.hansel.visualizer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.HSLModule;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;
import java.util.HashMap;
import java.util.Map;

public class HSLVisualizer extends HSLModule {
    public int skipTag;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5745a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5745a = r0
                r1 = 1
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.DEVICE_IN_TESTGROUP     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 16
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5745a     // Catch:{ NoSuchFieldError -> 0x0018 }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0018 }
                r2 = 0
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r0 = f5745a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.hansel.core.module.EventsConstants r2 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5745a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.GET_EID_VIEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                r1 = 61
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5745a     // Catch:{ NoSuchFieldError -> 0x0031 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.ANCHOR_POINT_VISIBLE     // Catch:{ NoSuchFieldError -> 0x0031 }
                r1 = 62
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.HSLVisualizer.a.<clinit>():void");
        }
    }

    private void initialize(Context context) {
        try {
            io.hansel.visualizer.c.a.a(this).a(context, this.moduleInitializationData.sdkIdentifiers);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public String getCode() {
        return "vmo";
    }

    public String getCurrentScreenName() {
        return (String) getLinkedMessageBroker().returnEventData(EventsConstants.GET_CURRENT_SCREEN_NAME.name(), null);
    }

    public String[] getPublishingEvents() {
        return new String[0];
    }

    public String[] getSubscribingEvents() {
        return new String[]{EventsConstants.DEVICE_IN_TESTGROUP.name(), EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND.name(), EventsConstants.APPLICATION_DID_MOVE_TO_BACKGROUND.name(), EventsConstants.GET_EID_VIEW.name(), EventsConstants.ANCHOR_POINT_VISIBLE.name()};
    }

    public boolean handleEventData(String str, Object obj) {
        if (str == null) {
            return false;
        }
        try {
            EventsConstants valueOf = EventsConstants.valueOf(str);
            io.hansel.visualizer.c.a a2 = io.hansel.visualizer.c.a.a(this);
            int i = a.f5745a[valueOf.ordinal()];
            if (i == 1) {
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() && this.moduleInitializationData != null) {
                    a2.f();
                }
                return true;
            } else if (i == 2) {
                a2.e();
                return true;
            } else if (i != 3) {
                return false;
            } else {
                a2.d();
                return true;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        super.init(hSLModuleInitializationData, iMessageBroker, iCrypto);
        Application application = hSLModuleInitializationData.app;
        this.skipTag = application.getResources().getIdentifier("hansel_ignore_view", "id", application.getPackageName());
        initialize(application);
    }

    public Object returnEventData(String str, Object obj) {
        if (str == null) {
            return null;
        }
        try {
            int i = a.f5745a[EventsConstants.valueOf(str).ordinal()];
            if (i != 4) {
                if (i == 5) {
                    if (obj instanceof HashMap) {
                        View view = (View) ((HashMap) obj).get("decorView");
                        int intValue = ((Integer) ((HashMap) obj).get("anchorPointOnScreenX")).intValue();
                        int intValue2 = ((Integer) ((HashMap) obj).get("anchorPointOnScreenY")).intValue();
                        return Boolean.valueOf(io.hansel.visualizer.c.a.a(this).a(view, (View) ((HashMap) obj).get("anchorView"), intValue, intValue2, this.skipTag));
                    }
                }
            } else if (obj instanceof Map) {
                View a2 = io.hansel.visualizer.c.a.a(this).a((Map) obj, (View) ((Activity) getLinkedMessageBroker().returnEventData(EventsConstants.GET_TOP_ACTIVITY.name(), null)).findViewById(16908290).getParent(), true);
                HSLLogger.d("HierarchyDown: AnchorView is " + a2);
                return a2;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return null;
    }
}
