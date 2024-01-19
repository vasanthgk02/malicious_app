package co.hyperverge.crashguard;

import android.content.Context;
import android.webkit.URLUtil;
import co.hyperverge.crashguard.data.repo.PrefsRepo;
import co.hyperverge.crashguard.services.CrashIntentService;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u0014\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 J\f\u0010!\u001a\u00020\f*\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lco/hyperverge/crashguard/CrashGuard;", "", "ctxRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;)V", "config", "Lco/hyperverge/crashguard/CrashGuard$Config;", "ctx", "getCtx", "()Landroid/content/Context;", "isInitialized", "", "prefsRepo", "Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "getPrefsRepo", "()Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "prefsRepo$delegate", "Lkotlin/Lazy;", "createCrashEvent", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "t", "", "init", "", "endpoint", "", "sentryKey", "post", "crashEvent", "updateFilters", "filters", "", "shouldReportCrash", "Companion", "Config", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashGuard.kt */
public final class CrashGuard {
    public static final Companion Companion = new Companion(null);
    public static CrashGuard INSTANCE;
    public static final String TAG = Reflection.getOrCreateKotlinClass(CrashGuard.class).getQualifiedName();
    public Config config;
    public final WeakReference<Context> ctxRef;
    public boolean isInitialized;
    public final Lazy prefsRepo$delegate = TweetUtils.lazy((Function0<? extends T>) new CrashGuard$prefsRepo$2<Object>(this));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lco/hyperverge/crashguard/CrashGuard$Companion;", "", "()V", "INSTANCE", "Lco/hyperverge/crashguard/CrashGuard;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashGuard.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lco/hyperverge/crashguard/CrashGuard$Config;", "", "filters", "", "", "tags", "", "(Ljava/util/List;Ljava/util/Map;)V", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "getTags", "()Ljava/util/Map;", "setTags", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashGuard.kt */
    public static final class Config {
        public List<String> filters;
        public Map<String, String> tags;

        public Config(List<String> list, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(list, ECommerceParamNames.FILTERS);
            Intrinsics.checkNotNullParameter(map, "tags");
            this.filters = list;
            this.tags = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.filters, config.filters) && Intrinsics.areEqual(this.tags, config.tags);
        }

        public int hashCode() {
            return this.tags.hashCode() + (this.filters.hashCode() * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Config(filters=");
            outline73.append(this.filters);
            outline73.append(", tags=");
            outline73.append(this.tags);
            outline73.append(')');
            return outline73.toString();
        }

        public Config() {
            EmptyList emptyList = EmptyList.INSTANCE;
            HashMap hashMap = new HashMap();
            Intrinsics.checkNotNullParameter(emptyList, ECommerceParamNames.FILTERS);
            Intrinsics.checkNotNullParameter(hashMap, "tags");
            this.filters = emptyList;
            this.tags = hashMap;
        }
    }

    public CrashGuard(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this.ctxRef = weakReference;
    }

    public static final CrashGuard getInstance(Context context) {
        if (Companion != null) {
            Intrinsics.checkNotNullParameter(context, "context");
            CrashGuard crashGuard = INSTANCE;
            if (crashGuard != null) {
                return crashGuard;
            }
            CrashGuard crashGuard2 = new CrashGuard(new WeakReference(context), null);
            INSTANCE = crashGuard2;
            return crashGuard2;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0317 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x036a A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0391 A[Catch:{ all -> 0x03b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0393 A[Catch:{ all -> 0x03b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x039b A[Catch:{ all -> 0x03b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x039d A[Catch:{ all -> 0x03b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03a5 A[Catch:{ all -> 0x03b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03e1 A[Catch:{ all -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03e3 A[Catch:{ all -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03eb A[Catch:{ all -> 0x03f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0400 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0418 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0447 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0449 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0479 A[Catch:{ all -> 0x0484 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x047c A[Catch:{ all -> 0x0484 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x047f A[Catch:{ all -> 0x0484 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0480 A[Catch:{ all -> 0x0484 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x048d A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0492 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0494 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x049e A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04a0 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04aa A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04ac A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04c4 A[Catch:{ all -> 0x04dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04c6 A[Catch:{ all -> 0x04dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x04e5 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x04fa A[Catch:{ all -> 0x0512 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04fc A[Catch:{ all -> 0x0512 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053d A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x055a A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x055c A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0566 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0568 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0572 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0574 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x057e A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0580 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x05d6 A[Catch:{ all -> 0x0361, all -> 0x05e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x064c  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x00a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3 A[Catch:{ all -> 0x00bf }, LOOP:1: B:17:0x006c->B:29:0x00a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3  */
    /* renamed from: init$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m280init$lambda0(co.hyperverge.crashguard.CrashGuard r33, java.lang.Thread.UncaughtExceptionHandler r34, java.lang.Thread r35, java.lang.Throwable r36) {
        /*
            r1 = r33
            r2 = r36
            java.lang.String r3 = "it.methodName"
            java.lang.String r4 = "config"
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "setDefaultUncaughtExceptionHandler called with: t = ["
            r0.append(r5)
            r5 = r35
            r0.append(r5)
            java.lang.String r6 = "], e = ["
            r0.append(r6)
            r0.append(r2)
            r6 = 93
            r0.append(r6)
            r0.toString()
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r0 = 2
            r6 = 0
            r7 = 0
            co.hyperverge.crashguard.CrashGuard$Config r8 = r1.config     // Catch:{ all -> 0x00bf }
            if (r8 == 0) goto L_0x00bb
            java.util.List<java.lang.String> r8 = r8.filters     // Catch:{ all -> 0x00bf }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00bf }
            if (r8 != 0) goto L_0x00b5
            co.hyperverge.crashguard.CrashGuard$Config r8 = r1.config     // Catch:{ all -> 0x00bf }
            if (r8 == 0) goto L_0x00b1
            java.util.List<java.lang.String> r8 = r8.filters     // Catch:{ all -> 0x00bf }
            boolean r9 = r8 instanceof java.util.Collection     // Catch:{ all -> 0x00bf }
            if (r9 == 0) goto L_0x0051
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x00bf }
            if (r9 == 0) goto L_0x0051
            goto L_0x00ab
        L_0x0051:
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bf }
        L_0x0055:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x00bf }
            if (r9 == 0) goto L_0x00ab
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x00bf }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00bf }
            java.lang.StackTraceElement[] r10 = r36.getStackTrace()     // Catch:{ all -> 0x00bf }
            java.lang.String r11 = "stackTrace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ all -> 0x00bf }
            int r11 = r10.length     // Catch:{ all -> 0x00bf }
            r12 = 0
        L_0x006c:
            if (r12 >= r11) goto L_0x00a6
            r13 = r10[r12]     // Catch:{ all -> 0x00bf }
            java.lang.String r14 = r13.getFileName()     // Catch:{ all -> 0x00bf }
            java.lang.String r15 = "it.fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)     // Catch:{ all -> 0x00bf }
            boolean r14 = kotlin.text.CharsKt__CharKt.contains$default(r14, r9, r6, r0)     // Catch:{ all -> 0x00bf }
            if (r14 != 0) goto L_0x009e
            java.lang.String r14 = r13.getClassName()     // Catch:{ all -> 0x00bf }
            java.lang.String r15 = "it.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)     // Catch:{ all -> 0x00bf }
            boolean r14 = kotlin.text.CharsKt__CharKt.contains$default(r14, r9, r6, r0)     // Catch:{ all -> 0x00bf }
            if (r14 != 0) goto L_0x009e
            java.lang.String r13 = r13.getMethodName()     // Catch:{ all -> 0x00bf }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch:{ all -> 0x00bf }
            boolean r13 = kotlin.text.CharsKt__CharKt.contains$default(r13, r9, r6, r0)     // Catch:{ all -> 0x00bf }
            if (r13 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r13 = 0
            goto L_0x009f
        L_0x009e:
            r13 = 1
        L_0x009f:
            if (r13 == 0) goto L_0x00a3
            r9 = 1
            goto L_0x00a7
        L_0x00a3:
            int r12 = r12 + 1
            goto L_0x006c
        L_0x00a6:
            r9 = 0
        L_0x00a7:
            if (r9 == 0) goto L_0x0055
            r0 = 1
            goto L_0x00ac
        L_0x00ab:
            r0 = 0
        L_0x00ac:
            if (r0 == 0) goto L_0x00af
            goto L_0x00b5
        L_0x00af:
            r0 = 0
            goto L_0x00b6
        L_0x00b1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x00bf }
            throw r7
        L_0x00b5:
            r0 = 1
        L_0x00b6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x00bf }
            goto L_0x00c4
        L_0x00bb:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x00bf }
            throw r7
        L_0x00bf:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)
        L_0x00c4:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            boolean r9 = r0 instanceof kotlin.Result.Failure
            if (r9 == 0) goto L_0x00cb
            r0 = r8
        L_0x00cb:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x064c
            co.hyperverge.crashguard.services.CrashIntentService$Companion r8 = co.hyperverge.crashguard.services.CrashIntentService.Companion
            android.content.Context r13 = r33.getCtx()
            java.lang.String r9 = "android.intent.action.BATTERY_CHANGED"
            co.hyperverge.crashguard.data.models.CrashEvent r11 = new co.hyperverge.crashguard.data.models.CrashEvent
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.StackTraceElement[] r10 = r36.getStackTrace()
            java.lang.String r12 = "t.stackTrace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            java.lang.String r15 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r15)
            int r14 = com.twitter.sdk.android.tweetui.TweetUtils.getLastIndex((T[]) r10)
            if (r14 < 0) goto L_0x00f9
            r6 = r10[r6]
            goto L_0x00fa
        L_0x00f9:
            r6 = r7
        L_0x00fa:
            if (r6 != 0) goto L_0x00fd
            goto L_0x0126
        L_0x00fd:
            java.lang.String r7 = "at "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.String r10 = r6.getMethodName()
            r7.append(r10)
            java.lang.String r10 = "() in "
            r7.append(r10)
            java.lang.String r10 = r6.getClassName()
            r7.append(r10)
            java.lang.String r10 = " from "
            r7.append(r10)
            java.lang.String r6 = r6.getFileName()
            r7.append(r6)
            java.lang.String r7 = r7.toString()
        L_0x0126:
            long r5 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
            double r5 = (double) r5
            r16 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = r5 / r16
            java.lang.Double r17 = java.lang.Double.valueOf(r5)
            java.lang.String r18 = r36.getMessage()
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$Companion r5 = co.hyperverge.crashguard.data.models.CrashEvent.Exception.Companion
            if (r5 == 0) goto L_0x064a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = r2
        L_0x0147:
            if (r5 == 0) goto L_0x0203
            java.lang.Class r6 = r36.getClass()
            java.lang.Package r6 = r6.getPackage()
            java.lang.Class r10 = r36.getClass()
            java.lang.String r10 = r10.getName()
            if (r6 == 0) goto L_0x0177
            java.lang.String r14 = "fullClassName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r14)
            java.lang.String r14 = r6.getName()
            r16 = r15
            java.lang.String r15 = "."
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r15)
            r15 = 4
            java.lang.String r2 = ""
            r24 = r13
            r13 = 0
            java.lang.String r10 = kotlin.text.CharsKt__CharKt.replace$default(r10, r14, r2, r13, r15)
            goto L_0x017b
        L_0x0177:
            r24 = r13
            r16 = r15
        L_0x017b:
            if (r6 != 0) goto L_0x017f
            r2 = 0
            goto L_0x0183
        L_0x017f:
            java.lang.String r2 = r6.getName()
        L_0x0183:
            java.lang.String r6 = r36.getMessage()
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value$StackTrace$Companion r13 = co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value.StackTrace.Companion
            java.lang.StackTraceElement[] r14 = r36.getStackTrace()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            if (r13 == 0) goto L_0x0201
            java.lang.String r13 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r15 = r14.length
            r19 = 0
            r20 = r12
            r12 = 0
        L_0x01a2:
            if (r12 >= r15) goto L_0x01e6
            r19 = r14[r12]
            int r21 = r19.getLineNumber()
            if (r21 <= 0) goto L_0x01db
            r21 = r14
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value$StackTrace$Frame r14 = new co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value$StackTrace$Frame
            r22 = r15
            java.lang.String r15 = r19.getMethodName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)
            java.lang.String r27 = r19.getClassName()
            int r23 = r19.getLineNumber()
            java.lang.Integer r28 = java.lang.Integer.valueOf(r23)
            java.lang.String r29 = r19.getFileName()
            r30 = 0
            r31 = 0
            r32 = 48
            r25 = r14
            r26 = r15
            r25.<init>(r26, r27, r28, r29, r30, r31, r32)
            r15 = 0
            r13.add(r15, r14)
            goto L_0x01df
        L_0x01db:
            r21 = r14
            r22 = r15
        L_0x01df:
            int r12 = r12 + 1
            r14 = r21
            r15 = r22
            goto L_0x01a2
        L_0x01e6:
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value$StackTrace r12 = new co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value$StackTrace
            r12.<init>(r13)
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value r13 = new co.hyperverge.crashguard.data.models.CrashEvent$Exception$Value
            r13.<init>(r10, r6, r2, r12)
            r0.add(r13)
            java.lang.Throwable r5 = r5.getCause()
            r2 = r36
            r15 = r16
            r12 = r20
            r13 = r24
            goto L_0x0147
        L_0x0201:
            r0 = 0
            throw r0
        L_0x0203:
            r24 = r13
            r16 = r15
            co.hyperverge.crashguard.data.models.CrashEvent$Exception r2 = new co.hyperverge.crashguard.data.models.CrashEvent$Exception
            r2.<init>(r0)
            r21 = 0
            r22 = 0
            r23 = 210(0xd2, float:2.94E-43)
            r0 = 0
            r19 = 0
            r14 = r11
            r3 = r16
            r15 = r7
            r16 = r0
            r20 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r11.tags     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.CrashGuard$Config r2 = r1.config     // Catch:{ all -> 0x05e3 }
            if (r2 == 0) goto L_0x05de
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.tags     // Catch:{ all -> 0x05e3 }
            r0.putAll(r2)     // Catch:{ all -> 0x05e3 }
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r11.tags     // Catch:{ all -> 0x05e3 }
            java.lang.String r2 = "crashguard_sdk_version"
            java.lang.String r4 = "1.0.5"
            r0.put(r2, r4)     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts r2 = r11.contexts     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App r0 = r2.app     // Catch:{ all -> 0x05e3 }
            android.content.Context r4 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)     // Catch:{ all -> 0x05e3 }
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch:{ all -> 0x05e3 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x05e3 }
            r6 = 0
            android.content.pm.PackageInfo r4 = r5.getPackageInfo(r4, r6)     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = "packageManager.getPackageInfo(packageName, 0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = r4.packageName     // Catch:{ all -> 0x05e3 }
            r0.packageName = r5     // Catch:{ all -> 0x05e3 }
            android.content.Context r5 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)     // Catch:{ all -> 0x05e3 }
            android.content.pm.ApplicationInfo r6 = r5.getApplicationInfo()     // Catch:{ Exception -> 0x0286 }
            java.lang.String r7 = "applicationInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x0286 }
            int r7 = r6.labelRes     // Catch:{ Exception -> 0x0286 }
            if (r7 != 0) goto L_0x0281
            java.lang.CharSequence r7 = r6.nonLocalizedLabel     // Catch:{ Exception -> 0x0286 }
            if (r7 == 0) goto L_0x0274
            java.lang.CharSequence r5 = r6.nonLocalizedLabel     // Catch:{ Exception -> 0x0286 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0286 }
            goto L_0x0287
        L_0x0274:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Exception -> 0x0286 }
            java.lang.CharSequence r5 = r5.getApplicationLabel(r6)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0286 }
            goto L_0x0287
        L_0x0281:
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x0286 }
            goto L_0x0287
        L_0x0286:
            r5 = 0
        L_0x0287:
            r0.name = r5     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = r4.versionName     // Catch:{ all -> 0x05e3 }
            r0.version = r5     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)     // Catch:{ all -> 0x05e3 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x05e3 }
            r6 = 28
            if (r5 < r6) goto L_0x029f
            long r4 = r4.getLongVersionCode()     // Catch:{ all -> 0x05e3 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x05e3 }
            goto L_0x02b4
        L_0x029f:
            if (r5 < r6) goto L_0x02aa
            long r4 = r4.getLongVersionCode()     // Catch:{ all -> 0x05e3 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x05e3 }
            goto L_0x02b0
        L_0x02aa:
            int r4 = r4.versionCode     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x05e3 }
        L_0x02b0:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x05e3 }
        L_0x02b4:
            r0.build = r4     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r4 = r2.device     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = "device_name"
            java.lang.String r0 = android.provider.Settings.Global.getString(r0, r5)     // Catch:{ all -> 0x05e3 }
            r4.name = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = android.os.Build.MODEL     // Catch:{ all -> 0x05e3 }
            r4.model = r0     // Catch:{ all -> 0x05e3 }
            if (r0 != 0) goto L_0x02d0
            r0 = 0
            goto L_0x031b
        L_0x02d0:
            java.lang.String r5 = " "
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x05e3 }
            r6 = 6
            r7 = 0
            java.util.List r0 = kotlin.text.CharsKt__CharKt.split$default(r0, r5, r7, r7, r6)     // Catch:{ all -> 0x05e3 }
            boolean r5 = r0.isEmpty()     // Catch:{ all -> 0x05e3 }
            if (r5 != 0) goto L_0x030c
            int r5 = r0.size()     // Catch:{ all -> 0x05e3 }
            java.util.ListIterator r5 = r0.listIterator(r5)     // Catch:{ all -> 0x05e3 }
        L_0x02ea:
            boolean r6 = r5.hasPrevious()     // Catch:{ all -> 0x05e3 }
            if (r6 == 0) goto L_0x030c
            java.lang.Object r6 = r5.previous()     // Catch:{ all -> 0x05e3 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x05e3 }
            int r6 = r6.length()     // Catch:{ all -> 0x05e3 }
            if (r6 != 0) goto L_0x02fe
            r6 = 1
            goto L_0x02ff
        L_0x02fe:
            r6 = 0
        L_0x02ff:
            if (r6 != 0) goto L_0x02ea
            int r5 = r5.nextIndex()     // Catch:{ all -> 0x05e3 }
            int r5 = r5 + 1
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.take(r0, r5)     // Catch:{ all -> 0x05e3 }
            goto L_0x030e
        L_0x030c:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE     // Catch:{ all -> 0x05e3 }
        L_0x030e:
            r5 = 0
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ all -> 0x05e3 }
            java.lang.Object[] r0 = r0.toArray(r6)     // Catch:{ all -> 0x05e3 }
            if (r0 == 0) goto L_0x05d6
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x05e3 }
            r0 = r0[r5]     // Catch:{ all -> 0x05e3 }
        L_0x031b:
            r4.family = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String[] r0 = android.os.Build.SUPPORTED_ABIS     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = "SUPPORTED_ABIS"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x05e3 }
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.toMutableList(r0)     // Catch:{ all -> 0x05e3 }
            r4.archs = r0     // Catch:{ all -> 0x05e3 }
            r5 = 0
            java.lang.Object r0 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r0, r5)     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x05e3 }
            r4.arch = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x05e3 }
            r4.manufacturer = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = android.os.Build.BRAND     // Catch:{ all -> 0x05e3 }
            r4.brand = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = android.os.Build.ID     // Catch:{ all -> 0x05e3 }
            r4.modelId = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0361 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ all -> 0x0361 }
            int r0 = r0.orientation     // Catch:{ all -> 0x0361 }
            if (r0 == 0) goto L_0x035f
            r5 = 1
            if (r0 == r5) goto L_0x035c
            r5 = 2
            if (r0 == r5) goto L_0x0359
            goto L_0x035f
        L_0x0359:
            java.lang.String r0 = "landscape"
            goto L_0x0366
        L_0x035c:
            java.lang.String r0 = "portrait"
            goto L_0x0366
        L_0x035f:
            r0 = 0
            goto L_0x0366
        L_0x0361:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x0366:
            boolean r5 = r0 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r5 == 0) goto L_0x036b
            r0 = 0
        L_0x036b:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x05e3 }
            r4.orientation = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            boolean r0 = androidx.core.widget.CompoundButtonCompat.isNetworkAvailable(r0)     // Catch:{ all -> 0x05e3 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x05e3 }
            r4.online = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            r5 = -1
            android.content.IntentFilter r6 = new android.content.IntentFilter     // Catch:{ all -> 0x03b6 }
            r6.<init>(r9)     // Catch:{ all -> 0x03b6 }
            r7 = 0
            android.content.Intent r0 = r0.registerReceiver(r7, r6)     // Catch:{ all -> 0x03b6 }
            if (r0 != 0) goto L_0x0393
            r6 = -1
            goto L_0x0399
        L_0x0393:
            java.lang.String r6 = "level"
            int r6 = r0.getIntExtra(r6, r5)     // Catch:{ all -> 0x03b6 }
        L_0x0399:
            if (r0 != 0) goto L_0x039d
            r0 = -1
            goto L_0x03a3
        L_0x039d:
            java.lang.String r7 = "scale"
            int r0 = r0.getIntExtra(r7, r5)     // Catch:{ all -> 0x03b6 }
        L_0x03a3:
            if (r6 == r5) goto L_0x03b4
            if (r0 != r5) goto L_0x03a8
            goto L_0x03b4
        L_0x03a8:
            r7 = 1120403456(0x42c80000, float:100.0)
            float r6 = (float) r6     // Catch:{ all -> 0x03b6 }
            float r0 = (float) r0     // Catch:{ all -> 0x03b6 }
            float r6 = r6 / r0
            float r6 = r6 * r7
            java.lang.Float r0 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x03b6 }
            goto L_0x03bb
        L_0x03b4:
            r0 = 0
            goto L_0x03c2
        L_0x03b6:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x03bb:
            boolean r6 = r0 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r6 == 0) goto L_0x03c0
            r0 = 0
        L_0x03c0:
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ all -> 0x05e3 }
        L_0x03c2:
            r4.batteryLevel = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            java.lang.Boolean r0 = androidx.core.widget.CompoundButtonCompat.isCharging(r0)     // Catch:{ all -> 0x05e3 }
            r4.charging = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            android.content.IntentFilter r6 = new android.content.IntentFilter     // Catch:{ all -> 0x03f7 }
            r6.<init>(r9)     // Catch:{ all -> 0x03f7 }
            r7 = 0
            android.content.Intent r0 = r0.registerReceiver(r7, r6)     // Catch:{ all -> 0x03f7 }
            if (r0 != 0) goto L_0x03e3
            r0 = -1
            goto L_0x03e9
        L_0x03e3:
            java.lang.String r6 = "temperature"
            int r0 = r0.getIntExtra(r6, r5)     // Catch:{ all -> 0x03f7 }
        L_0x03e9:
            if (r0 == r5) goto L_0x03f5
            float r0 = (float) r0     // Catch:{ all -> 0x03f7 }
            r5 = 10
            float r5 = (float) r5     // Catch:{ all -> 0x03f7 }
            float r0 = r0 / r5
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x03f7 }
            goto L_0x03fc
        L_0x03f5:
            r0 = 0
            goto L_0x03fc
        L_0x03f7:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x03fc:
            boolean r5 = r0 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r5 == 0) goto L_0x0401
            r0 = 0
        L_0x0401:
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ all -> 0x05e3 }
            r4.batteryTemperature = r0     // Catch:{ all -> 0x05e3 }
            java.lang.Boolean r0 = androidx.core.widget.CompoundButtonCompat.isEmulator()     // Catch:{ all -> 0x05e3 }
            r4.simulator = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x05e3 }
            r6 = 24
            if (r5 < r6) goto L_0x043d
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x05e3 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ all -> 0x05e3 }
            android.os.LocaleList r0 = r0.getLocales()     // Catch:{ all -> 0x05e3 }
            java.lang.String r5 = "resources.configuration.locales"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x05e3 }
            boolean r5 = r0.isEmpty()     // Catch:{ all -> 0x05e3 }
            if (r5 != 0) goto L_0x043d
            r5 = 0
            java.util.Locale r0 = r0.get(r5)     // Catch:{ all -> 0x05e3 }
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)     // Catch:{ all -> 0x05e3 }
            java.util.TimeZone r0 = r0.getTimeZone()     // Catch:{ all -> 0x05e3 }
            goto L_0x0445
        L_0x043d:
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x05e3 }
            java.util.TimeZone r0 = r0.getTimeZone()     // Catch:{ all -> 0x05e3 }
        L_0x0445:
            if (r0 != 0) goto L_0x0449
            r0 = 0
            goto L_0x044d
        L_0x0449:
            java.lang.String r0 = r0.getID()     // Catch:{ all -> 0x05e3 }
        L_0x044d:
            r4.timezone = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = androidx.core.widget.CompoundButtonCompat.getDeviceId(r0)     // Catch:{ all -> 0x05e3 }
            r4.id = r0     // Catch:{ all -> 0x05e3 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = r0.getDisplayName()     // Catch:{ all -> 0x05e3 }
            r4.language = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            android.app.ActivityManager$MemoryInfo r5 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x0484 }
            r5.<init>()     // Catch:{ all -> 0x0484 }
            java.lang.String r6 = "activity"
            java.lang.Object r0 = r0.getSystemService(r6)     // Catch:{ all -> 0x0484 }
            boolean r6 = r0 instanceof android.app.ActivityManager     // Catch:{ all -> 0x0484 }
            if (r6 == 0) goto L_0x047c
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ all -> 0x0484 }
            goto L_0x047d
        L_0x047c:
            r0 = 0
        L_0x047d:
            if (r0 != 0) goto L_0x0480
            goto L_0x0489
        L_0x0480:
            r0.getMemoryInfo(r5)     // Catch:{ all -> 0x0484 }
            goto L_0x0489
        L_0x0484:
            r0 = move-exception
            java.lang.Object r5 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x0489:
            boolean r0 = r5 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r0 == 0) goto L_0x048e
            r5 = 0
        L_0x048e:
            android.app.ActivityManager$MemoryInfo r5 = (android.app.ActivityManager.MemoryInfo) r5     // Catch:{ all -> 0x05e3 }
            if (r5 != 0) goto L_0x0494
            r0 = 0
            goto L_0x049a
        L_0x0494:
            boolean r0 = r5.lowMemory     // Catch:{ all -> 0x05e3 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x05e3 }
        L_0x049a:
            r4.lowMemory = r0     // Catch:{ all -> 0x05e3 }
            if (r5 != 0) goto L_0x04a0
            r0 = 0
            goto L_0x04a6
        L_0x04a0:
            long r6 = r5.totalMem     // Catch:{ all -> 0x05e3 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x05e3 }
        L_0x04a6:
            r4.memorySizeBytes = r0     // Catch:{ all -> 0x05e3 }
            if (r5 != 0) goto L_0x04ac
            r0 = 0
            goto L_0x04b2
        L_0x04ac:
            long r5 = r5.availMem     // Catch:{ all -> 0x05e3 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x05e3 }
        L_0x04b2:
            r4.freeMemoryBytes = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            android.os.StatFs r5 = new android.os.StatFs     // Catch:{ all -> 0x04dc }
            r6 = 0
            java.io.File r0 = r0.getExternalFilesDir(r6)     // Catch:{ all -> 0x04dc }
            if (r0 != 0) goto L_0x04c6
            r0 = 0
            goto L_0x04ca
        L_0x04c6:
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x04dc }
        L_0x04ca:
            r5.<init>(r0)     // Catch:{ all -> 0x04dc }
            long r6 = r5.getBlockSizeLong()     // Catch:{ all -> 0x04dc }
            long r9 = r5.getBlockCountLong()     // Catch:{ all -> 0x04dc }
            long r9 = r9 * r6
            java.lang.Long r0 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x04dc }
            goto L_0x04e1
        L_0x04dc:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x04e1:
            boolean r5 = r0 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r5 == 0) goto L_0x04e6
            r0 = 0
        L_0x04e6:
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x05e3 }
            r4.storageSizeBytes = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x05e3 }
            android.os.StatFs r3 = new android.os.StatFs     // Catch:{ all -> 0x0512 }
            r5 = 0
            java.io.File r0 = r0.getExternalFilesDir(r5)     // Catch:{ all -> 0x0512 }
            if (r0 != 0) goto L_0x04fc
            r0 = 0
            goto L_0x0500
        L_0x04fc:
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0512 }
        L_0x0500:
            r3.<init>(r0)     // Catch:{ all -> 0x0512 }
            long r5 = r3.getBlockSizeLong()     // Catch:{ all -> 0x0512 }
            long r9 = r3.getAvailableBlocksLong()     // Catch:{ all -> 0x0512 }
            long r9 = r9 * r5
            java.lang.Long r0 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0512 }
            goto L_0x0517
        L_0x0512:
            r0 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
            r0 = 0
        L_0x0517:
            r4.freeStorageBytes = r0     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)     // Catch:{ all -> 0x0534 }
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)     // Catch:{ all -> 0x0534 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0534 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0534 }
            long r5 = r5 - r9
            r0.setTimeInMillis(r5)     // Catch:{ all -> 0x0534 }
            java.util.Date r0 = r0.getTime()     // Catch:{ all -> 0x0534 }
            goto L_0x0539
        L_0x0534:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)     // Catch:{ all -> 0x05e3 }
        L_0x0539:
            boolean r3 = r0 instanceof kotlin.Result.Failure     // Catch:{ all -> 0x05e3 }
            if (r3 == 0) goto L_0x053e
            r0 = 0
        L_0x053e:
            java.util.Date r0 = (java.util.Date) r0     // Catch:{ all -> 0x05e3 }
            r4.bootTime = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = androidx.core.widget.CompoundButtonCompat.getNetworkType(r0)     // Catch:{ all -> 0x05e3 }
            r4.connectionType = r0     // Catch:{ all -> 0x05e3 }
            android.content.Context r0 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x05e3 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x05e3 }
            if (r0 != 0) goto L_0x055c
            r3 = 0
            goto L_0x0562
        L_0x055c:
            float r3 = r0.density     // Catch:{ all -> 0x05e3 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ all -> 0x05e3 }
        L_0x0562:
            r4.screenDensity = r3     // Catch:{ all -> 0x05e3 }
            if (r0 != 0) goto L_0x0568
            r3 = 0
            goto L_0x056e
        L_0x0568:
            int r3 = r0.densityDpi     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x05e3 }
        L_0x056e:
            r4.screenDpi = r3     // Catch:{ all -> 0x05e3 }
            if (r0 != 0) goto L_0x0574
            r3 = 0
            goto L_0x057a
        L_0x0574:
            int r3 = r0.heightPixels     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x05e3 }
        L_0x057a:
            r4.screenHeightPx = r3     // Catch:{ all -> 0x05e3 }
            if (r0 != 0) goto L_0x0580
            r0 = 0
            goto L_0x0586
        L_0x0580:
            int r0 = r0.widthPixels     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x05e3 }
        L_0x0586:
            r4.screenWidthPx = r0     // Catch:{ all -> 0x05e3 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x05e3 }
            r0.<init>()     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r3 = r4.screenHeightPx     // Catch:{ all -> 0x05e3 }
            r0.append(r3)     // Catch:{ all -> 0x05e3 }
            r3 = 120(0x78, float:1.68E-43)
            r0.append(r3)     // Catch:{ all -> 0x05e3 }
            java.lang.Integer r3 = r4.screenWidthPx     // Catch:{ all -> 0x05e3 }
            r0.append(r3)     // Catch:{ all -> 0x05e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x05e3 }
            r4.screenResolution = r0     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS r0 = r2.os     // Catch:{ all -> 0x05e3 }
            java.lang.String r2 = "Android"
            r0.name = r2     // Catch:{ all -> 0x05e3 }
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x05e3 }
            r0.version = r2     // Catch:{ all -> 0x05e3 }
            java.lang.String r2 = android.os.Build.DISPLAY     // Catch:{ all -> 0x05e3 }
            r0.build = r2     // Catch:{ all -> 0x05e3 }
            java.lang.String r2 = androidx.core.widget.CompoundButtonCompat.getKernelVersion()     // Catch:{ all -> 0x05e3 }
            r0.kernelVersion = r2     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.utils.RootChecker r2 = new co.hyperverge.crashguard.utils.RootChecker     // Catch:{ all -> 0x05e3 }
            android.content.Context r1 = r33.getCtx()     // Catch:{ all -> 0x05e3 }
            r2.<init>(r1)     // Catch:{ all -> 0x05e3 }
            boolean r1 = r2.isDeviceRooted$crashguard_release()     // Catch:{ all -> 0x05e3 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x05e3 }
            r0.rooted = r1     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$User r0 = r11.user     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts r1 = r11.contexts     // Catch:{ all -> 0x05e3 }
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r1 = r1.device     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r1.id     // Catch:{ all -> 0x05e3 }
            r0.id = r1     // Catch:{ all -> 0x05e3 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x05e3 }
            goto L_0x05e8
        L_0x05d6:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)     // Catch:{ all -> 0x05e3 }
            throw r0     // Catch:{ all -> 0x05e3 }
        L_0x05de:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x05e3 }
            r0 = 0
            throw r0
        L_0x05e3:
            r0 = move-exception
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r0)
        L_0x05e8:
            java.lang.Throwable r0 = kotlin.Result.m884exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x05f7
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "Failed to create crash event "
            kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
        L_0x05f7:
            if (r8 == 0) goto L_0x0648
            java.lang.String r0 = "context"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "crashEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = co.hyperverge.crashguard.services.CrashIntentService.TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "addWork() called with: context = ["
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "], crashEvent = ["
            r0.append(r2)
            r0.append(r11)
            java.lang.String r2 = "], enqueue = ["
            r0.append(r2)
            r2 = 0
            r0.append(r2)
            r2 = 93
            r0.append(r2)
            r0.toString()
            co.hyperverge.crashguard.data.repo.CrashEventsRepo$Companion r0 = co.hyperverge.crashguard.data.repo.CrashEventsRepo.Companion
            co.hyperverge.crashguard.data.repo.CrashEventsRepo r10 = r0.getInstance(r1)
            co.hyperverge.crashguard.services.CrashIntentService$Companion$addWork$1 r0 = new co.hyperverge.crashguard.services.CrashIntentService$Companion$addWork$1
            r14 = 0
            r12 = 0
            r9 = r0
            r13 = r1
            r9.<init>(r10, r11, r12, r13, r14)
            r1 = 1
            r2 = 0
            kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.runBlocking$default(r2, r0, r1, r2)
            if (r34 != 0) goto L_0x0644
            goto L_0x0647
        L_0x0644:
            r34.uncaughtException(r35, r36)
        L_0x0647:
            return
        L_0x0648:
            r0 = 0
            throw r0
        L_0x064a:
            r0 = 0
            throw r0
        L_0x064c:
            java.lang.String r0 = "init: Skipping crash as no provided filters matched for e: "
            r1 = r36
            kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
            if (r34 != 0) goto L_0x0656
            goto L_0x0659
        L_0x0656:
            r34.uncaughtException(r35, r36)
        L_0x0659:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.CrashGuard.m280init$lambda0(co.hyperverge.crashguard.CrashGuard, java.lang.Thread$UncaughtExceptionHandler, java.lang.Thread, java.lang.Throwable):void");
    }

    public final Context getCtx() {
        Object obj = this.ctxRef.get();
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "ctxRef.get()!!");
        return (Context) obj;
    }

    public final void init(String str, String str2, Config config2) {
        Intrinsics.checkNotNullParameter(str, HttpTunnelingServlet.ENDPOINT);
        Intrinsics.checkNotNullParameter(str2, "sentryKey");
        Intrinsics.checkNotNullParameter(config2, "config");
        "init() called with: config = [" + config2 + ']';
        if (!this.isInitialized) {
            if (URLUtil.isValidUrl(str)) {
                if (str2.length() > 0) {
                    PrefsRepo prefsRepo = (PrefsRepo) this.prefsRepo$delegate.getValue();
                    if (prefsRepo != null) {
                        Intrinsics.checkNotNullParameter(str, "<set-?>");
                        prefsRepo.sentryEndpointUrl$delegate.setValue(prefsRepo, PrefsRepo.$$delegatedProperties[0], str);
                        PrefsRepo prefsRepo2 = (PrefsRepo) this.prefsRepo$delegate.getValue();
                        if (prefsRepo2 != null) {
                            Intrinsics.checkNotNullParameter(str2, "<set-?>");
                            prefsRepo2.sentryKey$delegate.setValue(prefsRepo2, PrefsRepo.$$delegatedProperties[1], str2);
                            this.config = config2;
                            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()) {
                                public final /* synthetic */ UncaughtExceptionHandler f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void uncaughtException(Thread thread, Throwable th) {
                                    CrashGuard.m280init$lambda0(CrashGuard.this, this.f$1, thread, th);
                                }
                            });
                            this.isInitialized = true;
                            CrashIntentService.Companion.enqueuePending(getCtx());
                            return;
                        }
                        throw null;
                    }
                    throw null;
                }
            }
            throw new IllegalArgumentException("Invalid sentry endpoint url or key.");
        }
    }
}
