package com.netcore.android;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.event.SMTEventRecorderModel;
import com.netcore.android.event.e;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.module.IDataSubscriber;
import com.netcore.android.module.IMessageBroker;
import com.netcore.android.module.SMTModule;
import com.netcore.android.module.SMTModuleConstant;
import com.netcore.android.module.SMTModuleConstant.Companion;
import com.netcore.android.module.SMTModuleInitializationData;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartechInternal.kt */
public final class d implements IDataSubscriber {

    /* renamed from: e  reason: collision with root package name */
    public static d f1021e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1022f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1023a;

    /* renamed from: b  reason: collision with root package name */
    public IMessageBroker f1024b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f1025c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f1026d;

    /* compiled from: SmartechInternal.kt */
    public static final class a {
        public a() {
        }

        private final d a(Context context) {
            return new d(context, null);
        }

        public final d b(Context context) {
            d dVar;
            Intrinsics.checkNotNullParameter(context, "context");
            d a2 = d.f1021e;
            if (a2 != null) {
                return a2;
            }
            synchronized (d.class) {
                try {
                    d a3 = d.f1021e;
                    if (a3 != null) {
                        dVar = a3;
                    } else {
                        dVar = d.f1022f.a(context);
                        d.f1021e = dVar;
                    }
                }
            }
            return dVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(Context context) {
        this.f1026d = context;
        this.f1023a = d.class.getSimpleName();
        this.f1025c = new String[]{SMTModuleEventConstants.SMTMODULE_RECORD_EVENT.name()};
    }

    private final ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        Companion companion = SMTModuleConstant.Companion;
        arrayList.add(companion.getSMARTECH_PUSH_MODULE());
        arrayList.add(companion.getSMARTECH_APP_INBOX_MODULE());
        return arrayList;
    }

    public final void b() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.BOOT_COMPLETE.name(), "");
        }
    }

    public final void c() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.CANCEL_PUSHAMP_WORKER.name(), "");
        }
    }

    public final void d() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.CHECK_AND_PROCESS_SAVED_TOKEN_EVENT.name(), "");
        }
    }

    public final void e() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.RECORD_NOTIFICATION_PERMISSION_EVENT.name(), "");
        }
    }

    public final void g() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.PN_TOKEN_GENERATION_EVENT.name(), "");
        }
    }

    public String[] getSubscribingEvents() {
        return this.f1025c;
    }

    public final void h() {
        b bVar = new b();
        this.f1024b = bVar;
        subscribe(bVar);
        ArrayList<String> f2 = f();
        SMTModuleInitializationData sMTModuleInitializationData = new SMTModuleInitializationData();
        sMTModuleInitializationData.setContext(this.f1026d);
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1023a;
        StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "modulelist size ");
        outline79.append(f2 != null ? Integer.valueOf(f2.size()) : null);
        outline79.append(' ');
        sMTLogger.internal(str, outline79.toString());
        if (f2 != null) {
            for (String str2 : f2) {
                try {
                    Object newInstance = Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance != null) {
                        ((SMTModule) newInstance).init(sMTModuleInitializationData, this.f1024b);
                        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                        String str3 = this.f1023a;
                        Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                        sMTLogger2.internal(str3, "Module name " + str2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.module.SMTModule");
                    }
                } catch (Exception e2) {
                    SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                    String str4 = this.f1023a;
                    StringBuilder outline792 = GeneratedOutlineSupport.outline79(str4, UeCustomType.TAG, "Module ");
                    outline792.append(e2.getLocalizedMessage());
                    outline792.append(" not found.");
                    sMTLogger3.i(str4, outline792.toString());
                }
            }
        }
    }

    public boolean handleEventData(String str, Object obj) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        sMTLogger.internal("SmartechInternal", "Event name " + str + ' ');
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            if (Intrinsics.areEqual(str, SMTModuleEventConstants.SMTMODULE_RECORD_EVENT.name()) && obj != null) {
                a((SMTEventRecorderModel) obj);
            }
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public final void i() {
        IMessageBroker iMessageBroker = this.f1024b;
        if (iMessageBroker != null) {
            iMessageBroker.publishEvent(SMTModuleEventConstants.SCHEDULE_PUSHAMP_WORKER.name(), "");
        }
    }

    public Object returnEventData(String str, Object obj) {
        return new Object();
    }

    public void subscribe(IMessageBroker iMessageBroker) {
        if (iMessageBroker != null) {
            for (String subscriber : getSubscribingEvents()) {
                iMessageBroker.setSubscriber(subscriber, this);
            }
        }
    }

    public final void a(SMTEventRecorderModel sMTEventRecorderModel) {
        Intrinsics.checkNotNullParameter(sMTEventRecorderModel, "smtEventRecorderModel");
        e.a(e.f1081f.b(this.f1026d), sMTEventRecorderModel.getEventId(), sMTEventRecorderModel.getEventName(), sMTEventRecorderModel.getPayload(), sMTEventRecorderModel.getEventType(), false, 16, null);
    }

    public /* synthetic */ d(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}
