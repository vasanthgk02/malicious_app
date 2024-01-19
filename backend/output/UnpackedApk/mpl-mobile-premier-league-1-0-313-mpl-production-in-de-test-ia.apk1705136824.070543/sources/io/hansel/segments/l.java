package io.hansel.segments;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.userjourney.prompts.s;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public String f5268a = "";

    /* renamed from: b  reason: collision with root package name */
    public i f5269b;

    public l(i iVar) {
        this.f5269b = iVar;
        iVar.a(this);
    }

    public String a() {
        return this.f5268a;
    }

    public void a(String str, IMessageBroker iMessageBroker, HSLSDKIdentifiers hSLSDKIdentifiers) {
        HSLLogger.d("HanselScreenLoggingHere: setScreenName started " + str);
        this.f5268a = str;
        iMessageBroker.publishBlockingEvent(EventsConstants.LOG_EVENT_INTERNAL.name(), new s(str, hSLSDKIdentifiers.appVersion.versionName).a());
        this.f5269b.f();
    }

    public void b() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HanselScreenLoggingHere: unsetScreenName started ");
        outline73.append(this.f5268a);
        HSLLogger.d(outline73.toString());
        this.f5268a = "";
        this.f5269b.c();
    }
}
