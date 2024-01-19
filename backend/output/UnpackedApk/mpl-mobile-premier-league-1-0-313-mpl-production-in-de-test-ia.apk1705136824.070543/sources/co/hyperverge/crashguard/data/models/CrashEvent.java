package co.hyperverge.crashguard.data.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import io.sentry.SentryBaseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 B2\u00020\u0001:\u0005ABCDEB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B{\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0019J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J%\u00101\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0013HÆ\u0003J\t\u00102\u001a\u00020\u0015HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÇ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR-\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006F"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent;", "", "t", "", "(Ljava/lang/Throwable;)V", "seen1", "", "culprit", "", "platform", "timestamp", "", "message", "contexts", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;", "exception", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;", "tags", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "user", "Lco/hyperverge/crashguard/data/models/CrashEvent$User;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;Ljava/util/HashMap;Lco/hyperverge/crashguard/data/models/CrashEvent$User;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;Ljava/util/HashMap;Lco/hyperverge/crashguard/data/models/CrashEvent$User;)V", "getContexts", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;", "getCulprit", "()Ljava/lang/String;", "getException", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;", "getMessage", "getPlatform", "getTags", "()Ljava/util/HashMap;", "getTimestamp", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getUser", "()Lco/hyperverge/crashguard/data/models/CrashEvent$User;", "setUser", "(Lco/hyperverge/crashguard/data/models/CrashEvent$User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;Ljava/util/HashMap;Lco/hyperverge/crashguard/data/models/CrashEvent$User;)Lco/hyperverge/crashguard/data/models/CrashEvent;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Contexts", "Exception", "User", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
/* compiled from: CrashEvent.kt */
public final class CrashEvent {
    public static final Companion Companion = new Companion(null);
    public final Contexts contexts;
    public final String culprit;
    public final Exception exception;
    public final String message;
    public final String platform;
    public final HashMap<String, String> tags;
    public final Double timestamp;
    public User user;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashEvent.kt */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<CrashEvent> serializer() {
            return CrashEvent$$serializer.INSTANCE;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 '2\u00020\u0001:\u0005%&'()B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;", "", "seen1", "", "app", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;", "device", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "os", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;)V", "getApp", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;", "getDevice", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "getOs", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "App", "Companion", "Device", "OS", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    /* compiled from: CrashEvent.kt */
    public static final class Contexts {
        public static final Companion Companion = new Companion(null);
        public final App app;
        public final Device device;
        public final OS os;

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 72\u00020\u0001:\u000267B_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBK\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J!\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205HÇ\u0001R&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R&\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u00068"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;", "", "seen1", "", "type", "", "startTime", "Ljava/util/Date;", "packageName", "name", "version", "build", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild$annotations", "()V", "getBuild", "()Ljava/lang/String;", "setBuild", "(Ljava/lang/String;)V", "getName$annotations", "getName", "setName", "getPackageName$annotations", "getPackageName", "setPackageName", "getStartTime$annotations", "getStartTime", "()Ljava/util/Date;", "getType", "getVersion$annotations", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        /* compiled from: CrashEvent.kt */
        public static final class App {
            public static final Companion Companion = new Companion(null);
            public String build;
            public String name;
            public String packageName;
            public final Date startTime;
            public final String type;
            public String version;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$App;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* compiled from: CrashEvent.kt */
            public static final class Companion {
                public Companion() {
                }

                public final KSerializer<App> serializer() {
                    return CrashEvent$Contexts$App$$serializer.INSTANCE;
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }

            public App() {
                this((String) null, (Date) null, (String) null, (String) null, (String) null, (String) null, 63);
            }

            public App(String str, Date date, String str2, String str3, String str4, String str5, int i) {
                String str6 = (i & 1) != 0 ? "app" : null;
                int i2 = i & 2;
                int i3 = i & 4;
                int i4 = i & 8;
                int i5 = i & 16;
                int i6 = i & 32;
                Intrinsics.checkNotNullParameter(str6, "type");
                this.type = str6;
                this.startTime = null;
                this.packageName = null;
                this.name = null;
                this.version = null;
                this.build = null;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof App)) {
                    return false;
                }
                App app = (App) obj;
                return Intrinsics.areEqual(this.type, app.type) && Intrinsics.areEqual(this.startTime, app.startTime) && Intrinsics.areEqual(this.packageName, app.packageName) && Intrinsics.areEqual(this.name, app.name) && Intrinsics.areEqual(this.version, app.version) && Intrinsics.areEqual(this.build, app.build);
            }

            public int hashCode() {
                int hashCode = this.type.hashCode() * 31;
                Date date = this.startTime;
                int i = 0;
                int hashCode2 = (hashCode + (date == null ? 0 : date.hashCode())) * 31;
                String str = this.packageName;
                int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.name;
                int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.version;
                int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.build;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode5 + i;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("App(type=");
                outline73.append(this.type);
                outline73.append(", startTime=");
                outline73.append(this.startTime);
                outline73.append(", packageName=");
                outline73.append(this.packageName);
                outline73.append(", name=");
                outline73.append(this.name);
                outline73.append(", version=");
                outline73.append(this.version);
                outline73.append(", build=");
                outline73.append(this.build);
                outline73.append(')');
                return outline73.toString();
            }

            public /* synthetic */ App(int i, String str, @Serializable(with = DateSerializer.class) Date date, String str2, String str3, String str4, String str5) {
                if ((i & 0) == 0) {
                    this.type = (i & 1) == 0 ? "app" : str;
                    if ((i & 2) == 0) {
                        this.startTime = null;
                    } else {
                        this.startTime = date;
                    }
                    if ((i & 4) == 0) {
                        this.packageName = null;
                    } else {
                        this.packageName = str2;
                    }
                    if ((i & 8) == 0) {
                        this.name = null;
                    } else {
                        this.name = str3;
                    }
                    if ((i & 16) == 0) {
                        this.version = null;
                    } else {
                        this.version = str4;
                    }
                    if ((i & 32) == 0) {
                        this.build = null;
                    } else {
                        this.build = str5;
                    }
                } else {
                    TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Contexts$App$$serializer.INSTANCE.getDescriptor());
                    throw null;
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: CrashEvent.kt */
        public static final class Companion {
            public Companion() {
            }

            public final KSerializer<Contexts> serializer() {
                return CrashEvent$Contexts$$serializer.INSTANCE;
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        @Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 µ\u00012\u00020\u0001:\u0004´\u0001µ\u0001Bé\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*Bñ\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010+J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00107J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00107J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010tJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010QJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010QJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010QJ\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010QJ\f\u0010\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00107J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010FJü\u0002\u0010§\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010¨\u0001J\u0015\u0010©\u0001\u001a\u00020\u000e2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¬\u0001\u001a\u00020\u0005HÖ\u0001J(\u0010­\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u00002\b\u0010°\u0001\u001a\u00030±\u00012\b\u0010²\u0001\u001a\u00030³\u0001HÇ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010:\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010$\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010:\u0012\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R&\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u00105\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010-\"\u0004\bD\u0010/R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR&\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u00105\u001a\u0004\bK\u0010-\"\u0004\bL\u0010/R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010-\"\u0004\bN\u0010/R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010T\u0012\u0004\bO\u00105\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR(\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010T\u0012\u0004\bU\u00105\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010-\"\u0004\b[\u0010/R(\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010I\u0012\u0004\b\\\u00105\u001a\u0004\b]\u0010F\"\u0004\b^\u0010HR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010-\"\u0004\b`\u0010/R(\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010T\u0012\u0004\ba\u00105\u001a\u0004\bb\u0010Q\"\u0004\bc\u0010SR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010-\"\u0004\be\u0010/R&\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bf\u00105\u001a\u0004\bg\u0010-\"\u0004\bh\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010-\"\u0004\bj\u0010/R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bk\u0010F\"\u0004\bl\u0010HR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010-\"\u0004\bn\u0010/R(\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010:\u0012\u0004\bo\u00105\u001a\u0004\bp\u00107\"\u0004\bq\u00109R(\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010w\u0012\u0004\br\u00105\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR(\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010w\u0012\u0004\bx\u00105\u001a\u0004\by\u0010t\"\u0004\bz\u0010vR&\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b{\u00105\u001a\u0004\b|\u0010-\"\u0004\b}\u0010/R)\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0017\n\u0002\u0010w\u0012\u0004\b~\u00105\u001a\u0004\b\u0010t\"\u0005\b\u0001\u0010vR \u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0012\n\u0002\u0010I\u001a\u0005\b\u0001\u0010F\"\u0005\b\u0001\u0010HR+\u0010 \u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0019\n\u0002\u0010T\u0012\u0005\b\u0001\u00105\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u0012\u0010\u0004\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010-¨\u0006¶\u0001"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "", "seen1", "", "type", "", "name", "family", "model", "arch", "orientation", "manufacturer", "brand", "online", "", "charging", "simulator", "timezone", "id", "language", "archs", "", "modelId", "batteryLevel", "", "screenResolution", "screenDensity", "screenDpi", "lowMemory", "memorySizeBytes", "", "freeMemoryBytes", "storageSizeBytes", "freeStorageBytes", "bootTime", "Ljava/util/Date;", "batteryTemperature", "connectionType", "screenHeightPx", "screenWidthPx", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getArch", "()Ljava/lang/String;", "setArch", "(Ljava/lang/String;)V", "getArchs", "()Ljava/util/List;", "setArchs", "(Ljava/util/List;)V", "getBatteryLevel$annotations", "()V", "getBatteryLevel", "()Ljava/lang/Float;", "setBatteryLevel", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBatteryTemperature$annotations", "getBatteryTemperature", "setBatteryTemperature", "getBootTime$annotations", "getBootTime", "()Ljava/util/Date;", "setBootTime", "(Ljava/util/Date;)V", "getBrand", "setBrand", "getCharging", "()Ljava/lang/Boolean;", "setCharging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getConnectionType$annotations", "getConnectionType", "setConnectionType", "getFamily", "setFamily", "getFreeMemoryBytes$annotations", "getFreeMemoryBytes", "()Ljava/lang/Long;", "setFreeMemoryBytes", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFreeStorageBytes$annotations", "getFreeStorageBytes", "setFreeStorageBytes", "getId", "setId", "getLanguage", "setLanguage", "getLowMemory$annotations", "getLowMemory", "setLowMemory", "getManufacturer", "setManufacturer", "getMemorySizeBytes$annotations", "getMemorySizeBytes", "setMemorySizeBytes", "getModel", "setModel", "getModelId$annotations", "getModelId", "setModelId", "getName", "setName", "getOnline", "setOnline", "getOrientation", "setOrientation", "getScreenDensity$annotations", "getScreenDensity", "setScreenDensity", "getScreenDpi$annotations", "getScreenDpi", "()Ljava/lang/Integer;", "setScreenDpi", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScreenHeightPx$annotations", "getScreenHeightPx", "setScreenHeightPx", "getScreenResolution$annotations", "getScreenResolution", "setScreenResolution", "getScreenWidthPx$annotations", "getScreenWidthPx", "setScreenWidthPx", "getSimulator", "setSimulator", "getStorageSizeBytes$annotations", "getStorageSizeBytes", "setStorageSizeBytes", "getTimezone", "setTimezone", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        /* compiled from: CrashEvent.kt */
        public static final class Device {
            public static final Companion Companion = new Companion(null);
            public String arch;
            public List<String> archs;
            public Float batteryLevel;
            public Float batteryTemperature;
            public Date bootTime;
            public String brand;
            public Boolean charging;
            public String connectionType;
            public String family;
            public Long freeMemoryBytes;
            public Long freeStorageBytes;
            public String id;
            public String language;
            public Boolean lowMemory;
            public String manufacturer;
            public Long memorySizeBytes;
            public String model;
            public String modelId;
            public String name;
            public Boolean online;
            public String orientation;
            public Float screenDensity;
            public Integer screenDpi;
            public Integer screenHeightPx;
            public String screenResolution;
            public Integer screenWidthPx;
            public Boolean simulator;
            public Long storageSizeBytes;
            public String timezone;
            public final String type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* compiled from: CrashEvent.kt */
            public static final class Companion {
                public Companion() {
                }

                public final KSerializer<Device> serializer() {
                    return CrashEvent$Contexts$Device$$serializer.INSTANCE;
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }

            public Device() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Float) null, (String) null, (Float) null, (Integer) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Long) null, (Date) null, (Float) null, (String) null, (Integer) null, (Integer) null, 1073741823);
            }

            public Device(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, Boolean bool2, Boolean bool3, String str9, String str10, String str11, List list, String str12, Float f2, String str13, Float f3, Integer num, Boolean bool4, Long l, Long l2, Long l3, Long l4, Date date, Float f4, String str14, Integer num2, Integer num3, int i) {
                int i2 = i;
                String str15 = (i2 & 1) != 0 ? "device" : null;
                int i3 = i2 & 2;
                int i4 = i2 & 4;
                int i5 = i2 & 8;
                int i6 = i2 & 16;
                int i7 = i2 & 32;
                int i8 = i2 & 64;
                int i9 = i2 & 128;
                int i10 = i2 & 256;
                int i11 = i2 & 512;
                int i12 = i2 & 1024;
                int i13 = i2 & 2048;
                int i14 = i2 & 4096;
                int i15 = i2 & 8192;
                int i16 = i2 & 16384;
                int i17 = 32768 & i2;
                int i18 = 65536 & i2;
                int i19 = 131072 & i2;
                int i20 = 262144 & i2;
                int i21 = 524288 & i2;
                int i22 = 1048576 & i2;
                int i23 = 2097152 & i2;
                int i24 = 4194304 & i2;
                int i25 = 8388608 & i2;
                int i26 = 16777216 & i2;
                int i27 = 33554432 & i2;
                int i28 = 67108864 & i2;
                int i29 = 134217728 & i2;
                int i30 = 268435456 & i2;
                int i31 = i2 & 536870912;
                Intrinsics.checkNotNullParameter(str15, "type");
                this.type = str15;
                this.name = null;
                this.family = null;
                this.model = null;
                this.arch = null;
                this.orientation = null;
                this.manufacturer = null;
                this.brand = null;
                this.online = null;
                this.charging = null;
                this.simulator = null;
                this.timezone = null;
                this.id = null;
                this.language = null;
                this.archs = null;
                this.modelId = null;
                this.batteryLevel = null;
                this.screenResolution = null;
                this.screenDensity = null;
                this.screenDpi = null;
                this.lowMemory = null;
                this.memorySizeBytes = null;
                this.freeMemoryBytes = null;
                this.storageSizeBytes = null;
                this.freeStorageBytes = null;
                this.bootTime = null;
                this.batteryTemperature = null;
                this.connectionType = null;
                this.screenHeightPx = null;
                this.screenWidthPx = null;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Device)) {
                    return false;
                }
                Device device = (Device) obj;
                return Intrinsics.areEqual(this.type, device.type) && Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.family, device.family) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.arch, device.arch) && Intrinsics.areEqual(this.orientation, device.orientation) && Intrinsics.areEqual(this.manufacturer, device.manufacturer) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.online, device.online) && Intrinsics.areEqual(this.charging, device.charging) && Intrinsics.areEqual(this.simulator, device.simulator) && Intrinsics.areEqual(this.timezone, device.timezone) && Intrinsics.areEqual(this.id, device.id) && Intrinsics.areEqual(this.language, device.language) && Intrinsics.areEqual(this.archs, device.archs) && Intrinsics.areEqual(this.modelId, device.modelId) && Intrinsics.areEqual(this.batteryLevel, device.batteryLevel) && Intrinsics.areEqual(this.screenResolution, device.screenResolution) && Intrinsics.areEqual(this.screenDensity, device.screenDensity) && Intrinsics.areEqual(this.screenDpi, device.screenDpi) && Intrinsics.areEqual(this.lowMemory, device.lowMemory) && Intrinsics.areEqual(this.memorySizeBytes, device.memorySizeBytes) && Intrinsics.areEqual(this.freeMemoryBytes, device.freeMemoryBytes) && Intrinsics.areEqual(this.storageSizeBytes, device.storageSizeBytes) && Intrinsics.areEqual(this.freeStorageBytes, device.freeStorageBytes) && Intrinsics.areEqual(this.bootTime, device.bootTime) && Intrinsics.areEqual(this.batteryTemperature, device.batteryTemperature) && Intrinsics.areEqual(this.connectionType, device.connectionType) && Intrinsics.areEqual(this.screenHeightPx, device.screenHeightPx) && Intrinsics.areEqual(this.screenWidthPx, device.screenWidthPx);
            }

            public int hashCode() {
                int hashCode = this.type.hashCode() * 31;
                String str = this.name;
                int i = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.family;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.model;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.arch;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.orientation;
                int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.manufacturer;
                int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.brand;
                int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
                Boolean bool = this.online;
                int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.charging;
                int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                Boolean bool3 = this.simulator;
                int hashCode11 = (hashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
                String str8 = this.timezone;
                int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
                String str9 = this.id;
                int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
                String str10 = this.language;
                int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
                List<String> list = this.archs;
                int hashCode15 = (hashCode14 + (list == null ? 0 : list.hashCode())) * 31;
                String str11 = this.modelId;
                int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
                Float f2 = this.batteryLevel;
                int hashCode17 = (hashCode16 + (f2 == null ? 0 : f2.hashCode())) * 31;
                String str12 = this.screenResolution;
                int hashCode18 = (hashCode17 + (str12 == null ? 0 : str12.hashCode())) * 31;
                Float f3 = this.screenDensity;
                int hashCode19 = (hashCode18 + (f3 == null ? 0 : f3.hashCode())) * 31;
                Integer num = this.screenDpi;
                int hashCode20 = (hashCode19 + (num == null ? 0 : num.hashCode())) * 31;
                Boolean bool4 = this.lowMemory;
                int hashCode21 = (hashCode20 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
                Long l = this.memorySizeBytes;
                int hashCode22 = (hashCode21 + (l == null ? 0 : l.hashCode())) * 31;
                Long l2 = this.freeMemoryBytes;
                int hashCode23 = (hashCode22 + (l2 == null ? 0 : l2.hashCode())) * 31;
                Long l3 = this.storageSizeBytes;
                int hashCode24 = (hashCode23 + (l3 == null ? 0 : l3.hashCode())) * 31;
                Long l4 = this.freeStorageBytes;
                int hashCode25 = (hashCode24 + (l4 == null ? 0 : l4.hashCode())) * 31;
                Date date = this.bootTime;
                int hashCode26 = (hashCode25 + (date == null ? 0 : date.hashCode())) * 31;
                Float f4 = this.batteryTemperature;
                int hashCode27 = (hashCode26 + (f4 == null ? 0 : f4.hashCode())) * 31;
                String str13 = this.connectionType;
                int hashCode28 = (hashCode27 + (str13 == null ? 0 : str13.hashCode())) * 31;
                Integer num2 = this.screenHeightPx;
                int hashCode29 = (hashCode28 + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.screenWidthPx;
                if (num3 != null) {
                    i = num3.hashCode();
                }
                return hashCode29 + i;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Device(type=");
                outline73.append(this.type);
                outline73.append(", name=");
                outline73.append(this.name);
                outline73.append(", family=");
                outline73.append(this.family);
                outline73.append(", model=");
                outline73.append(this.model);
                outline73.append(", arch=");
                outline73.append(this.arch);
                outline73.append(", orientation=");
                outline73.append(this.orientation);
                outline73.append(", manufacturer=");
                outline73.append(this.manufacturer);
                outline73.append(", brand=");
                outline73.append(this.brand);
                outline73.append(", online=");
                outline73.append(this.online);
                outline73.append(", charging=");
                outline73.append(this.charging);
                outline73.append(", simulator=");
                outline73.append(this.simulator);
                outline73.append(", timezone=");
                outline73.append(this.timezone);
                outline73.append(", id=");
                outline73.append(this.id);
                outline73.append(", language=");
                outline73.append(this.language);
                outline73.append(", archs=");
                outline73.append(this.archs);
                outline73.append(", modelId=");
                outline73.append(this.modelId);
                outline73.append(", batteryLevel=");
                outline73.append(this.batteryLevel);
                outline73.append(", screenResolution=");
                outline73.append(this.screenResolution);
                outline73.append(", screenDensity=");
                outline73.append(this.screenDensity);
                outline73.append(", screenDpi=");
                outline73.append(this.screenDpi);
                outline73.append(", lowMemory=");
                outline73.append(this.lowMemory);
                outline73.append(", memorySizeBytes=");
                outline73.append(this.memorySizeBytes);
                outline73.append(", freeMemoryBytes=");
                outline73.append(this.freeMemoryBytes);
                outline73.append(", storageSizeBytes=");
                outline73.append(this.storageSizeBytes);
                outline73.append(", freeStorageBytes=");
                outline73.append(this.freeStorageBytes);
                outline73.append(", bootTime=");
                outline73.append(this.bootTime);
                outline73.append(", batteryTemperature=");
                outline73.append(this.batteryTemperature);
                outline73.append(", connectionType=");
                outline73.append(this.connectionType);
                outline73.append(", screenHeightPx=");
                outline73.append(this.screenHeightPx);
                outline73.append(", screenWidthPx=");
                outline73.append(this.screenWidthPx);
                outline73.append(')');
                return outline73.toString();
            }

            public /* synthetic */ Device(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, Boolean bool2, Boolean bool3, String str9, String str10, String str11, List list, String str12, Float f2, String str13, Float f3, Integer num, Boolean bool4, Long l, Long l2, Long l3, Long l4, @Serializable(with = DateSerializer.class) Date date, Float f4, String str14, Integer num2, Integer num3) {
                int i2 = i;
                if ((i2 & 0) == 0) {
                    this.type = (i2 & 1) == 0 ? "device" : str;
                    if ((i2 & 2) == 0) {
                        this.name = null;
                    } else {
                        this.name = str2;
                    }
                    if ((i2 & 4) == 0) {
                        this.family = null;
                    } else {
                        this.family = str3;
                    }
                    if ((i2 & 8) == 0) {
                        this.model = null;
                    } else {
                        this.model = str4;
                    }
                    if ((i2 & 16) == 0) {
                        this.arch = null;
                    } else {
                        this.arch = str5;
                    }
                    if ((i2 & 32) == 0) {
                        this.orientation = null;
                    } else {
                        this.orientation = str6;
                    }
                    if ((i2 & 64) == 0) {
                        this.manufacturer = null;
                    } else {
                        this.manufacturer = str7;
                    }
                    if ((i2 & 128) == 0) {
                        this.brand = null;
                    } else {
                        this.brand = str8;
                    }
                    if ((i2 & 256) == 0) {
                        this.online = null;
                    } else {
                        this.online = bool;
                    }
                    if ((i2 & 512) == 0) {
                        this.charging = null;
                    } else {
                        this.charging = bool2;
                    }
                    if ((i2 & 1024) == 0) {
                        this.simulator = null;
                    } else {
                        this.simulator = bool3;
                    }
                    if ((i2 & 2048) == 0) {
                        this.timezone = null;
                    } else {
                        this.timezone = str9;
                    }
                    if ((i2 & 4096) == 0) {
                        this.id = null;
                    } else {
                        this.id = str10;
                    }
                    if ((i2 & 8192) == 0) {
                        this.language = null;
                    } else {
                        this.language = str11;
                    }
                    if ((i2 & 16384) == 0) {
                        this.archs = null;
                    } else {
                        this.archs = list;
                    }
                    if ((32768 & i2) == 0) {
                        this.modelId = null;
                    } else {
                        this.modelId = str12;
                    }
                    if ((65536 & i2) == 0) {
                        this.batteryLevel = null;
                    } else {
                        this.batteryLevel = f2;
                    }
                    if ((131072 & i2) == 0) {
                        this.screenResolution = null;
                    } else {
                        this.screenResolution = str13;
                    }
                    if ((262144 & i2) == 0) {
                        this.screenDensity = null;
                    } else {
                        this.screenDensity = f3;
                    }
                    if ((524288 & i2) == 0) {
                        this.screenDpi = null;
                    } else {
                        this.screenDpi = num;
                    }
                    if ((1048576 & i2) == 0) {
                        this.lowMemory = null;
                    } else {
                        this.lowMemory = bool4;
                    }
                    if ((2097152 & i2) == 0) {
                        this.memorySizeBytes = null;
                    } else {
                        this.memorySizeBytes = l;
                    }
                    if ((4194304 & i2) == 0) {
                        this.freeMemoryBytes = null;
                    } else {
                        this.freeMemoryBytes = l2;
                    }
                    if ((8388608 & i2) == 0) {
                        this.storageSizeBytes = null;
                    } else {
                        this.storageSizeBytes = l3;
                    }
                    if ((16777216 & i2) == 0) {
                        this.freeStorageBytes = null;
                    } else {
                        this.freeStorageBytes = l4;
                    }
                    if ((33554432 & i2) == 0) {
                        this.bootTime = null;
                    } else {
                        this.bootTime = date;
                    }
                    if ((67108864 & i2) == 0) {
                        this.batteryTemperature = null;
                    } else {
                        this.batteryTemperature = f4;
                    }
                    if ((134217728 & i2) == 0) {
                        this.connectionType = null;
                    } else {
                        this.connectionType = str14;
                    }
                    if ((268435456 & i2) == 0) {
                        this.screenHeightPx = null;
                    } else {
                        this.screenHeightPx = num2;
                    }
                    if ((i2 & 536870912) == 0) {
                        this.screenWidthPx = null;
                    } else {
                        this.screenWidthPx = num3;
                    }
                } else {
                    TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Contexts$Device$$serializer.INSTANCE.getDescriptor());
                    throw null;
                }
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 62\u00020\u0001:\u000256BW\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBK\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJT\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001J!\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204HÇ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013¨\u00067"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;", "", "seen1", "", "type", "", "name", "version", "build", "kernelVersion", "rooted", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBuild", "()Ljava/lang/String;", "setBuild", "(Ljava/lang/String;)V", "getKernelVersion$annotations", "()V", "getKernelVersion", "setKernelVersion", "getName", "setName", "getRooted", "()Ljava/lang/Boolean;", "setRooted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getType", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        /* compiled from: CrashEvent.kt */
        public static final class OS {
            public static final Companion Companion = new Companion(null);
            public String build;
            public String kernelVersion;
            public String name;
            public Boolean rooted;
            public final String type;
            public String version;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$OS;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* compiled from: CrashEvent.kt */
            public static final class Companion {
                public Companion() {
                }

                public final KSerializer<OS> serializer() {
                    return CrashEvent$Contexts$OS$$serializer.INSTANCE;
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }

            public OS() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63);
            }

            public OS(String str, String str2, String str3, String str4, String str5, Boolean bool, int i) {
                String str6 = (i & 1) != 0 ? "os" : null;
                int i2 = i & 2;
                int i3 = i & 4;
                int i4 = i & 8;
                int i5 = i & 16;
                int i6 = i & 32;
                Intrinsics.checkNotNullParameter(str6, "type");
                this.type = str6;
                this.name = null;
                this.version = null;
                this.build = null;
                this.kernelVersion = null;
                this.rooted = null;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OS)) {
                    return false;
                }
                OS os = (OS) obj;
                return Intrinsics.areEqual(this.type, os.type) && Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version) && Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.kernelVersion, os.kernelVersion) && Intrinsics.areEqual(this.rooted, os.rooted);
            }

            public int hashCode() {
                int hashCode = this.type.hashCode() * 31;
                String str = this.name;
                int i = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.version;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.build;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.kernelVersion;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Boolean bool = this.rooted;
                if (bool != null) {
                    i = bool.hashCode();
                }
                return hashCode5 + i;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("OS(type=");
                outline73.append(this.type);
                outline73.append(", name=");
                outline73.append(this.name);
                outline73.append(", version=");
                outline73.append(this.version);
                outline73.append(", build=");
                outline73.append(this.build);
                outline73.append(", kernelVersion=");
                outline73.append(this.kernelVersion);
                outline73.append(", rooted=");
                outline73.append(this.rooted);
                outline73.append(')');
                return outline73.toString();
            }

            public /* synthetic */ OS(int i, String str, String str2, String str3, String str4, String str5, Boolean bool) {
                if ((i & 0) == 0) {
                    this.type = (i & 1) == 0 ? "os" : str;
                    if ((i & 2) == 0) {
                        this.name = null;
                    } else {
                        this.name = str2;
                    }
                    if ((i & 4) == 0) {
                        this.version = null;
                    } else {
                        this.version = str3;
                    }
                    if ((i & 8) == 0) {
                        this.build = null;
                    } else {
                        this.build = str4;
                    }
                    if ((i & 16) == 0) {
                        this.kernelVersion = null;
                    } else {
                        this.kernelVersion = str5;
                    }
                    if ((i & 32) == 0) {
                        this.rooted = null;
                    } else {
                        this.rooted = bool;
                    }
                } else {
                    TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Contexts$OS$$serializer.INSTANCE.getDescriptor());
                    throw null;
                }
            }
        }

        public Contexts() {
            this((App) null, (Device) null, (OS) null, 7);
        }

        public /* synthetic */ Contexts(int i, App app2, Device device2, OS os2) {
            int i2 = i;
            if ((i2 & 0) == 0) {
                this.app = (i2 & 1) == 0 ? new App((String) null, (Date) null, (String) null, (String) null, (String) null, (String) null, 63) : app2;
                this.device = (i2 & 2) == 0 ? new Device((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Float) null, (String) null, (Float) null, (Integer) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Long) null, (Date) null, (Float) null, (String) null, (Integer) null, (Integer) null, 1073741823) : device2;
                this.os = (i2 & 4) == 0 ? new OS((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63) : os2;
                return;
            }
            TypeUtilsKt.throwMissingFieldException(i2, 0, CrashEvent$Contexts$$serializer.INSTANCE.getDescriptor());
            throw null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Contexts)) {
                return false;
            }
            Contexts contexts = (Contexts) obj;
            return Intrinsics.areEqual(this.app, contexts.app) && Intrinsics.areEqual(this.device, contexts.device) && Intrinsics.areEqual(this.os, contexts.os);
        }

        public int hashCode() {
            int hashCode = this.device.hashCode();
            return this.os.hashCode() + ((hashCode + (this.app.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Contexts(app=");
            outline73.append(this.app);
            outline73.append(", device=");
            outline73.append(this.device);
            outline73.append(", os=");
            outline73.append(this.os);
            outline73.append(')');
            return outline73.toString();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x005b, code lost:
            r5 = new co.hyperverge.crashguard.data.models.CrashEvent.Contexts.OS((java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.Boolean) null, 63);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Contexts(co.hyperverge.crashguard.data.models.CrashEvent.Contexts.App r37, co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device r38, co.hyperverge.crashguard.data.models.CrashEvent.Contexts.OS r39, int r40) {
            /*
                r36 = this;
                r0 = r36
                r1 = r40 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0016
                co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App r1 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 63
                r3 = r1
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                goto L_0x0017
            L_0x0016:
                r1 = r2
            L_0x0017:
                r3 = r40 & 2
                if (r3 == 0) goto L_0x0056
                co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r3 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device
                r4 = r3
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                r31 = 0
                r32 = 0
                r33 = 0
                r34 = 0
                r35 = 1073741823(0x3fffffff, float:1.9999999)
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
                goto L_0x0057
            L_0x0056:
                r3 = r2
            L_0x0057:
                r4 = r40 & 4
                if (r4 == 0) goto L_0x0069
                co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS r2 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 63
                r5 = r2
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            L_0x0069:
                java.lang.String r4 = "app"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
                java.lang.String r4 = "device"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                java.lang.String r4 = "os"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
                r36.<init>()
                r0.app = r1
                r0.device = r3
                r0.os = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.data.models.CrashEvent.Contexts.<init>(co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App, co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device, co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS, int):void");
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u001b\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;", "", "seen1", "", "values", "", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "getValues", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    /* compiled from: CrashEvent.kt */
    public static final class Exception {
        public static final Companion Companion = new Companion(null);
        public final List<Value> values;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Companion;", "", "()V", "from", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception;", "t", "", "serializer", "Lkotlinx/serialization/KSerializer;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: CrashEvent.kt */
        public static final class Companion {
            public Companion() {
            }

            public final KSerializer<Exception> serializer() {
                return CrashEvent$Exception$$serializer.INSTANCE;
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ,2\u00020\u0001:\u0003+,-BA\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J!\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÇ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006."}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value;", "", "seen1", "", "type", "", "value", "module", "stacktrace", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;)V", "getModule", "()Ljava/lang/String;", "setModule", "(Ljava/lang/String;)V", "getStacktrace", "()Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;", "setStacktrace", "(Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;)V", "getType", "setType", "getValue", "setValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "StackTrace", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        /* compiled from: CrashEvent.kt */
        public static final class Value {
            public static final Companion Companion = new Companion(null);
            public String module;
            public StackTrace stacktrace;
            public String type;
            public String value;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* compiled from: CrashEvent.kt */
            public static final class Companion {
                public Companion() {
                }

                public final KSerializer<Value> serializer() {
                    return CrashEvent$Exception$Value$$serializer.INSTANCE;
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }

            @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u001b\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;", "", "seen1", "", "frames", "", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "getFrames", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Frame", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            @Serializable
            /* compiled from: CrashEvent.kt */
            public static final class StackTrace {
                public static final Companion Companion = new Companion(null);
                public final List<Frame> frames;

                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¨\u0006\u000b"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Companion;", "", "()V", "from", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;", "elements", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace;", "serializer", "Lkotlinx/serialization/KSerializer;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                /* compiled from: CrashEvent.kt */
                public static final class Companion {
                    public Companion() {
                    }

                    public final KSerializer<StackTrace> serializer() {
                        return CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE;
                    }

                    public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    }
                }

                @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 32\u00020\u0001:\u000223B[\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018JT\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J!\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201HÇ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00064"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame;", "", "seen1", "", "function", "", "module", "lineNo", "filename", "absPath", "inApp", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAbsPath$annotations", "()V", "getAbsPath", "()Ljava/lang/String;", "getFilename", "getFunction", "getInApp$annotations", "getInApp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLineNo$annotations", "getLineNo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModule", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                @Serializable
                /* compiled from: CrashEvent.kt */
                public static final class Frame {
                    public static final Companion Companion = new Companion(null);
                    public final String absPath;
                    public final String filename;
                    public final String function;
                    public final Boolean inApp;
                    public final Integer lineNo;
                    public final String module;

                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                    /* compiled from: CrashEvent.kt */
                    public static final class Companion {
                        public Companion() {
                        }

                        public final KSerializer<Frame> serializer() {
                            return CrashEvent$Exception$Value$StackTrace$Frame$$serializer.INSTANCE;
                        }

                        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        }
                    }

                    public Frame(String str, String str2, Integer num, String str3, String str4, Boolean bool, int i) {
                        str2 = (i & 2) != 0 ? null : str2;
                        num = (i & 4) != 0 ? null : num;
                        str3 = (i & 8) != 0 ? null : str3;
                        int i2 = i & 16;
                        int i3 = i & 32;
                        Intrinsics.checkNotNullParameter(str, "function");
                        this.function = str;
                        this.module = str2;
                        this.lineNo = num;
                        this.filename = str3;
                        this.absPath = null;
                        this.inApp = null;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Frame)) {
                            return false;
                        }
                        Frame frame = (Frame) obj;
                        return Intrinsics.areEqual(this.function, frame.function) && Intrinsics.areEqual(this.module, frame.module) && Intrinsics.areEqual(this.lineNo, frame.lineNo) && Intrinsics.areEqual(this.filename, frame.filename) && Intrinsics.areEqual(this.absPath, frame.absPath) && Intrinsics.areEqual(this.inApp, frame.inApp);
                    }

                    public int hashCode() {
                        int hashCode = this.function.hashCode() * 31;
                        String str = this.module;
                        int i = 0;
                        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                        Integer num = this.lineNo;
                        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
                        String str2 = this.filename;
                        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.absPath;
                        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        Boolean bool = this.inApp;
                        if (bool != null) {
                            i = bool.hashCode();
                        }
                        return hashCode5 + i;
                    }

                    public String toString() {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Frame(function=");
                        outline73.append(this.function);
                        outline73.append(", module=");
                        outline73.append(this.module);
                        outline73.append(", lineNo=");
                        outline73.append(this.lineNo);
                        outline73.append(", filename=");
                        outline73.append(this.filename);
                        outline73.append(", absPath=");
                        outline73.append(this.absPath);
                        outline73.append(", inApp=");
                        outline73.append(this.inApp);
                        outline73.append(')');
                        return outline73.toString();
                    }

                    public /* synthetic */ Frame(int i, String str, String str2, Integer num, String str3, String str4, Boolean bool) {
                        if (1 == (i & 1)) {
                            this.function = str;
                            if ((i & 2) == 0) {
                                this.module = null;
                            } else {
                                this.module = str2;
                            }
                            if ((i & 4) == 0) {
                                this.lineNo = null;
                            } else {
                                this.lineNo = num;
                            }
                            if ((i & 8) == 0) {
                                this.filename = null;
                            } else {
                                this.filename = str3;
                            }
                            if ((i & 16) == 0) {
                                this.absPath = null;
                            } else {
                                this.absPath = str4;
                            }
                            if ((i & 32) == 0) {
                                this.inApp = null;
                            } else {
                                this.inApp = bool;
                            }
                        } else {
                            TypeUtilsKt.throwMissingFieldException(i, 1, CrashEvent$Exception$Value$StackTrace$Frame$$serializer.INSTANCE.getDescriptor());
                            throw null;
                        }
                    }
                }

                public StackTrace() {
                    this.frames = null;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof StackTrace) && Intrinsics.areEqual(this.frames, ((StackTrace) obj).frames);
                }

                public int hashCode() {
                    List<Frame> list = this.frames;
                    if (list == null) {
                        return 0;
                    }
                    return list.hashCode();
                }

                public String toString() {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("StackTrace(frames=");
                    outline73.append(this.frames);
                    outline73.append(')');
                    return outline73.toString();
                }

                public /* synthetic */ StackTrace(int i, List list) {
                    if ((i & 0) != 0) {
                        TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE.getDescriptor());
                        throw null;
                    } else if ((i & 1) == 0) {
                        this.frames = null;
                    } else {
                        this.frames = list;
                    }
                }

                public StackTrace(List<Frame> list) {
                    this.frames = list;
                }
            }

            public Value() {
                this.type = null;
                this.value = null;
                this.module = null;
                this.stacktrace = null;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Value)) {
                    return false;
                }
                Value value2 = (Value) obj;
                return Intrinsics.areEqual(this.type, value2.type) && Intrinsics.areEqual(this.value, value2.value) && Intrinsics.areEqual(this.module, value2.module) && Intrinsics.areEqual(this.stacktrace, value2.stacktrace);
            }

            public int hashCode() {
                String str = this.type;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.value;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.module;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                StackTrace stackTrace = this.stacktrace;
                if (stackTrace != null) {
                    i = stackTrace.hashCode();
                }
                return hashCode3 + i;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Value(type=");
                outline73.append(this.type);
                outline73.append(", value=");
                outline73.append(this.value);
                outline73.append(", module=");
                outline73.append(this.module);
                outline73.append(", stacktrace=");
                outline73.append(this.stacktrace);
                outline73.append(')');
                return outline73.toString();
            }

            public /* synthetic */ Value(int i, String str, String str2, String str3, StackTrace stackTrace) {
                if ((i & 0) == 0) {
                    if ((i & 1) == 0) {
                        this.type = null;
                    } else {
                        this.type = str;
                    }
                    if ((i & 2) == 0) {
                        this.value = null;
                    } else {
                        this.value = str2;
                    }
                    if ((i & 4) == 0) {
                        this.module = null;
                    } else {
                        this.module = str3;
                    }
                    if ((i & 8) == 0) {
                        this.stacktrace = null;
                    } else {
                        this.stacktrace = stackTrace;
                    }
                } else {
                    TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Exception$Value$$serializer.INSTANCE.getDescriptor());
                    throw null;
                }
            }

            public Value(String str, String str2, String str3, StackTrace stackTrace) {
                this.type = str;
                this.value = str2;
                this.module = str3;
                this.stacktrace = stackTrace;
            }
        }

        public Exception() {
            this.values = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Exception) && Intrinsics.areEqual(this.values, ((Exception) obj).values);
        }

        public int hashCode() {
            List<Value> list = this.values;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception(values=");
            outline73.append(this.values);
            outline73.append(')');
            return outline73.toString();
        }

        public /* synthetic */ Exception(int i, List list) {
            if ((i & 0) != 0) {
                TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$Exception$$serializer.INSTANCE.getDescriptor());
                throw null;
            } else if ((i & 1) == 0) {
                this.values = null;
            } else {
                this.values = list;
            }
        }

        public Exception(List<Value> list) {
            this.values = list;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u001d"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$User;", "", "seen1", "", "id", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    /* compiled from: CrashEvent.kt */
    public static final class User {
        public static final Companion Companion = new Companion(null);
        public String id;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/models/CrashEvent$User$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$User;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: CrashEvent.kt */
        public static final class Companion {
            public Companion() {
            }

            public final KSerializer<User> serializer() {
                return CrashEvent$User$$serializer.INSTANCE;
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public User() {
            this((String) null, 1);
        }

        public /* synthetic */ User(int i, String str) {
            if ((i & 0) != 0) {
                TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$User$$serializer.INSTANCE.getDescriptor());
                throw null;
            } else if ((i & 1) == 0) {
                this.id = null;
            } else {
                this.id = str;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof User) && Intrinsics.areEqual(this.id, ((User) obj).id);
        }

        public int hashCode() {
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("User(id=");
            outline73.append(this.id);
            outline73.append(')');
            return outline73.toString();
        }

        public User(String str, int i) {
            int i2 = i & 1;
            this.id = null;
        }
    }

    public CrashEvent() {
        this((String) null, (String) null, (Double) null, (String) null, (Contexts) null, (Exception) null, (HashMap) null, (User) null, (int) InvitationReply.EXPIRED);
    }

    public /* synthetic */ CrashEvent(int i, String str, String str2, Double d2, String str3, Contexts contexts2, Exception exception2, HashMap hashMap, User user2) {
        if ((i & 0) == 0) {
            if ((i & 1) == 0) {
                this.culprit = null;
            } else {
                this.culprit = str;
            }
            if ((i & 2) == 0) {
                this.platform = SentryBaseEvent.DEFAULT_PLATFORM;
            } else {
                this.platform = str2;
            }
            if ((i & 4) == 0) {
                this.timestamp = null;
            } else {
                this.timestamp = d2;
            }
            if ((i & 8) == 0) {
                this.message = null;
            } else {
                this.message = str3;
            }
            if ((i & 16) == 0) {
                this.contexts = new Contexts((App) null, (Device) null, (OS) null, 7);
            } else {
                this.contexts = contexts2;
            }
            if ((i & 32) == 0) {
                this.exception = null;
            } else {
                this.exception = exception2;
            }
            if ((i & 64) == 0) {
                this.tags = new HashMap<>();
            } else {
                this.tags = hashMap;
            }
            if ((i & 128) == 0) {
                this.user = new User((String) null, 1);
            } else {
                this.user = user2;
            }
        } else {
            TypeUtilsKt.throwMissingFieldException(i, 0, CrashEvent$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrashEvent)) {
            return false;
        }
        CrashEvent crashEvent = (CrashEvent) obj;
        return Intrinsics.areEqual(this.culprit, crashEvent.culprit) && Intrinsics.areEqual(this.platform, crashEvent.platform) && Intrinsics.areEqual(this.timestamp, crashEvent.timestamp) && Intrinsics.areEqual(this.message, crashEvent.message) && Intrinsics.areEqual(this.contexts, crashEvent.contexts) && Intrinsics.areEqual(this.exception, crashEvent.exception) && Intrinsics.areEqual(this.tags, crashEvent.tags) && Intrinsics.areEqual(this.user, crashEvent.user);
    }

    public int hashCode() {
        String str = this.culprit;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.platform;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d2 = this.timestamp;
        int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str3 = this.message;
        int hashCode4 = (this.contexts.hashCode() + ((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        Exception exception2 = this.exception;
        if (exception2 != null) {
            i = exception2.hashCode();
        }
        return this.user.hashCode() + ((this.tags.hashCode() + ((hashCode4 + i) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CrashEvent(culprit=");
        outline73.append(this.culprit);
        outline73.append(", platform=");
        outline73.append(this.platform);
        outline73.append(", timestamp=");
        outline73.append(this.timestamp);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", contexts=");
        outline73.append(this.contexts);
        outline73.append(", exception=");
        outline73.append(this.exception);
        outline73.append(", tags=");
        outline73.append(this.tags);
        outline73.append(", user=");
        outline73.append(this.user);
        outline73.append(')');
        return outline73.toString();
    }

    public CrashEvent(String str, String str2, Double d2, String str3, Contexts contexts2, Exception exception2, HashMap hashMap, User user2, int i) {
        User user3 = null;
        str = (i & 1) != 0 ? null : str;
        String str4 = (i & 2) != 0 ? SentryBaseEvent.DEFAULT_PLATFORM : null;
        d2 = (i & 4) != 0 ? null : d2;
        str3 = (i & 8) != 0 ? null : str3;
        Contexts contexts3 = (i & 16) != 0 ? new Contexts((App) null, (Device) null, (OS) null, 7) : null;
        exception2 = (i & 32) != 0 ? null : exception2;
        HashMap<String, String> hashMap2 = (i & 64) != 0 ? new HashMap<>() : null;
        user3 = (i & 128) != 0 ? new User((String) null, 1) : user3;
        Intrinsics.checkNotNullParameter(contexts3, "contexts");
        Intrinsics.checkNotNullParameter(hashMap2, "tags");
        Intrinsics.checkNotNullParameter(user3, Action.USER);
        this.culprit = str;
        this.platform = str4;
        this.timestamp = d2;
        this.message = str3;
        this.contexts = contexts3;
        this.exception = exception2;
        this.tags = hashMap2;
        this.user = user3;
    }
}
