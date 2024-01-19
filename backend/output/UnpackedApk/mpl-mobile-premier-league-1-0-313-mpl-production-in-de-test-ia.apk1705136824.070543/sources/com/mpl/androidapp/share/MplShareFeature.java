package com.mpl.androidapp.share;

import android.content.Context;
import android.content.Intent;
import com.mpl.androidapp.miniprofile.utils.InternetConnectionInfo;
import com.mpl.androidapp.share.ct.CtShareEvents;
import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.share.repositories.MplShareRepository;
import com.mpl.androidapp.share.services.GenerateDeepLinkServiceImpl;
import com.mpl.androidapp.share.states.ShareModuleStates;
import com.mpl.androidapp.share.states.ShareModuleStates.ErrorState;
import com.mpl.androidapp.share.states.ShareModuleStates.InitialState;
import com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent;
import com.mpl.androidapp.share.usecases.PrepareShareIntent;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.MLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u00014B3\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0011\u0010\"\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010#\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020&H\u0002J\u0011\u0010-\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0006\u0010.\u001a\u00020 J\u000e\u0010/\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017J\u0019\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00103R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/mpl/androidapp/share/MplShareFeature;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/mpl/androidapp/share/services/GenerateDeepLinkServiceImpl;", "context", "Landroid/content/Context;", "mplShareRepository", "Lcom/mpl/androidapp/share/repositories/MplShareRepository;", "checkSharePlatformIsPresent", "Lcom/mpl/androidapp/share/usecases/CheckSharePlatformIsPresent;", "prepareShareIntent", "Lcom/mpl/androidapp/share/usecases/PrepareShareIntent;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/mpl/androidapp/share/repositories/MplShareRepository;Lcom/mpl/androidapp/share/usecases/CheckSharePlatformIsPresent;Lcom/mpl/androidapp/share/usecases/PrepareShareIntent;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "shareData", "Lcom/mpl/androidapp/share/models/ShareData;", "getShareData", "()Lcom/mpl/androidapp/share/models/ShareData;", "setShareData", "(Lcom/mpl/androidapp/share/models/ShareData;)V", "shareModuleStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/share/states/ShareModuleStates;", "buildShareIntent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkSharePlatform", "cleanUp", "deepLinkApiFailure", "message", "", "deepLinkApiSuccess", "initiateShareEvent", "intent", "Landroid/content/Intent;", "preparePayload", "deepLinkPayload", "retrieveDeepLink", "runFeature", "setShareConditions", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ShareFeatureImpl", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplShareFeature.kt */
public final class MplShareFeature implements CoroutineScope, GenerateDeepLinkServiceImpl {
    public final CheckSharePlatformIsPresent checkSharePlatformIsPresent;
    public Context context;
    public final CoroutineDispatcher ioDispatcher;
    public final MplShareRepository mplShareRepository;
    public final PrepareShareIntent prepareShareIntent;
    public ShareData shareData;
    public MutableStateFlow<ShareModuleStates> shareModuleStates = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/share/MplShareFeature$ShareFeatureImpl;", "", "shareLoading", "", "message", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MplShareFeature.kt */
    public interface ShareFeatureImpl {
        void shareLoading(String str);
    }

    public MplShareFeature(Context context2, MplShareRepository mplShareRepository2, CheckSharePlatformIsPresent checkSharePlatformIsPresent2, PrepareShareIntent prepareShareIntent2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(mplShareRepository2, "mplShareRepository");
        Intrinsics.checkNotNullParameter(checkSharePlatformIsPresent2, "checkSharePlatformIsPresent");
        Intrinsics.checkNotNullParameter(prepareShareIntent2, "prepareShareIntent");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.context = context2;
        this.mplShareRepository = mplShareRepository2;
        this.checkSharePlatformIsPresent = checkSharePlatformIsPresent2;
        this.prepareShareIntent = prepareShareIntent2;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildShareIntent(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mpl.androidapp.share.MplShareFeature$buildShareIntent$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.mpl.androidapp.share.MplShareFeature$buildShareIntent$1 r0 = (com.mpl.androidapp.share.MplShareFeature$buildShareIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.share.MplShareFeature$buildShareIntent$1 r0 = new com.mpl.androidapp.share.MplShareFeature$buildShareIntent$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0087
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.share.MplShareFeature r2 = (com.mpl.androidapp.share.MplShareFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x004f
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            com.mpl.androidapp.share.usecases.PrepareShareIntent r6 = r5.prepareShareIntent
            com.mpl.androidapp.share.models.ShareData r2 = r5.getShareData()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.invoke(r2, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r2 = r5
        L_0x004f:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            boolean r4 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r4 == 0) goto L_0x0075
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r6
            java.lang.Object r6 = r6.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            com.mpl.androidapp.share.states.ShareModuleStates r6 = (com.mpl.androidapp.share.states.ShareModuleStates) r6
            if (r6 != 0) goto L_0x0066
            goto L_0x008a
        L_0x0066:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.share.states.ShareModuleStates> r0 = r2.shareModuleStates
            r0.setValue(r6)
            com.mpl.androidapp.share.states.ShareModuleStates$ShareIntent r6 = (com.mpl.androidapp.share.states.ShareModuleStates.ShareIntent) r6
            android.content.Intent r6 = r6.getIntent()
            r2.initiateShareEvent(r6)
            goto L_0x008a
        L_0x0075:
            boolean r4 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x008a
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r6
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.useCaseError(r6, r0)
            if (r6 != r1) goto L_0x0087
            return r1
        L_0x0087:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.share.MplShareFeature.buildShareIntent(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkSharePlatform(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.share.MplShareFeature$checkSharePlatform$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.share.MplShareFeature$checkSharePlatform$1 r0 = (com.mpl.androidapp.share.MplShareFeature$checkSharePlatform$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.share.MplShareFeature$checkSharePlatform$1 r0 = new com.mpl.androidapp.share.MplShareFeature$checkSharePlatform$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0098
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x009b
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.share.MplShareFeature r2 = (com.mpl.androidapp.share.MplShareFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0056
        L_0x0041:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r8 = r7.checkSharePlatformIsPresent
            com.mpl.androidapp.share.models.ShareData r2 = r7.getShareData()
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.invoke(r2, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r7
        L_0x0056:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r5 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r6 = 0
            if (r5 == 0) goto L_0x0087
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            com.mpl.androidapp.share.states.ShareModuleStates r8 = (com.mpl.androidapp.share.states.ShareModuleStates) r8
            if (r8 != 0) goto L_0x006e
            goto L_0x009b
        L_0x006e:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.share.states.ShareModuleStates> r3 = r2.shareModuleStates
            r3.setValue(r8)
            com.mpl.androidapp.share.states.ShareModuleStates$SharePlatformValidation r8 = (com.mpl.androidapp.share.states.ShareModuleStates.SharePlatformValidation) r8
            com.mpl.androidapp.share.models.ShareData r8 = r8.getShareData()
            r2.setShareData(r8)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r2.buildShareIntent(r0)
            if (r8 != r1) goto L_0x009b
            return r1
        L_0x0087:
            boolean r4 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x009b
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r2.useCaseError(r8, r0)
            if (r8 != r1) goto L_0x0098
            return r1
        L_0x0098:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x009b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.share.MplShareFeature.checkSharePlatform(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    private final void initiateShareEvent(Intent intent) {
        if (getShareData().isSharePlatformPresent()) {
            Intent.createChooser(intent, null);
            Intent createChooser = Intent.createChooser(intent, null);
            createChooser.setFlags(ClientDefaults.MAX_MSG_SIZE);
            getContext().startActivity(createChooser);
            CtShareEvents.INSTANCE.shareEvent(getShareData());
        } else {
            MLogger.e("GenericShare", "Share platform is not present");
        }
        cleanUp();
    }

    private final String preparePayload(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "OPEN_DEEP_LINK");
        jSONObject2.put("actionParams", new JSONObject(str));
        String jSONObject3 = jSONObject.put("notification_data", jSONObject2.toString()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().put(\"notifi… }.toString()).toString()");
        return jSONObject3;
    }

    /* access modifiers changed from: private */
    public final Object retrieveDeepLink(Continuation<? super Unit> continuation) {
        if (InternetConnectionInfo.INSTANCE.isNetworkAvailable(getContext())) {
            Object deepLinkService = this.mplShareRepository.deepLinkService(this, preparePayload(getShareData().getDeepLinkPayload()), continuation);
            if (deepLinkService == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return deepLinkService;
            }
            return Unit.INSTANCE;
        }
        MLogger.i("GenericShare", "Connectivity is not available to share");
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        this.shareModuleStates.setValue(new ErrorState(valueOf));
        MLogger.e("GenericShare", Intrinsics.stringPlus("Error in share module:->", valueOf));
        cleanUp();
        return Unit.INSTANCE;
    }

    public void deepLinkApiFailure(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        MLogger.e("GenericShare", Intrinsics.stringPlus("Deeplink generation is successful:->", str));
    }

    public void deepLinkApiSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        MLogger.i("GenericShare", Intrinsics.stringPlus("Deeplink generation is successful:->", str));
        getShareData().setAppFlyersLink(str);
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.getMain()), null, null, new MplShareFeature$deepLinkApiSuccess$1(this, null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final ShareData getShareData() {
        ShareData shareData2 = this.shareData;
        if (shareData2 != null) {
            return shareData2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareData");
        throw null;
    }

    public final void runFeature() {
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplShareFeature$runFeature$1(this, null), 3, null);
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setShareConditions(ShareData shareData2) {
        Intrinsics.checkNotNullParameter(shareData2, "shareData");
        setShareData(shareData2);
    }

    public final void setShareData(ShareData shareData2) {
        Intrinsics.checkNotNullParameter(shareData2, "<set-?>");
        this.shareData = shareData2;
    }
}
