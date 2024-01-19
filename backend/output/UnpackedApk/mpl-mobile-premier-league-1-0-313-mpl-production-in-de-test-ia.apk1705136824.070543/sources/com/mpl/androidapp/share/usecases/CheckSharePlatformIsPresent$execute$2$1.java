package com.mpl.androidapp.share.usecases;

import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.share.states.ShareModuleStates;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent$execute$2$1", f = "CheckSharePlatformIsPresent.kt", l = {}, m = "invokeSuspend")
/* compiled from: CheckSharePlatformIsPresent.kt */
public final class CheckSharePlatformIsPresent$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends ShareModuleStates>> $coroutine;
    public final /* synthetic */ ShareData $parameters;
    public int label;
    public final /* synthetic */ CheckSharePlatformIsPresent this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CheckSharePlatformIsPresent$execute$2$1(ShareData shareData, CheckSharePlatformIsPresent checkSharePlatformIsPresent, CancellableContinuation<? super UseCaseResult<? extends ShareModuleStates>> cancellableContinuation, Continuation<? super CheckSharePlatformIsPresent$execute$2$1> continuation) {
        // this.$parameters = shareData;
        // this.this$0 = checkSharePlatformIsPresent;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckSharePlatformIsPresent$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckSharePlatformIsPresent$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0111, code lost:
        r8.$coroutine.resumeWith(new com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success(new com.mpl.androidapp.share.states.ShareModuleStates.SharePlatformValidation(r8.$parameters)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.String r0 = "org.telegram.messenger"
            java.lang.String r1 = "com.instagram.android"
            java.lang.String r2 = "com.whatsapp"
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r8.label
            if (r3 != 0) goto L_0x0131
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            java.lang.String r9 = r9.getSharePlatform()     // Catch:{ Exception -> 0x0123 }
            int r3 = r9.hashCode()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r4 = "com.google.android.gm"
            java.lang.String r5 = "default"
            java.lang.String r6 = "ALL"
            r7 = 1
            switch(r3) {
                case -1577559662: goto L_0x00c6;
                case -1479469166: goto L_0x0099;
                case -577840895: goto L_0x006a;
                case 82233: goto L_0x0054;
                case 66081660: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x00f3
        L_0x0025:
            java.lang.String r0 = "EMAIL"
            boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x002f
            goto L_0x00f3
        L_0x002f:
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r9 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r0 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0123 }
            boolean r9 = r9.appInstalledOrNot(r0, r4)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x0048
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatform(r6)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r5)     // Catch:{ Exception -> 0x0123 }
            goto L_0x004d
        L_0x0048:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r4)     // Catch:{ Exception -> 0x0123 }
        L_0x004d:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0111
        L_0x0054:
            java.lang.String r0 = "SMS"
            boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x005e
            goto L_0x00f3
        L_0x005e:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r4)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0111
        L_0x006a:
            java.lang.String r1 = "TELEGRAM"
            boolean r9 = r9.equals(r1)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x0074
            goto L_0x00f3
        L_0x0074:
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r9 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r1 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x0123 }
            boolean r9 = r9.appInstalledOrNot(r1, r0)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x008d
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatform(r6)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r5)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0092
        L_0x008d:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r0)     // Catch:{ Exception -> 0x0123 }
        L_0x0092:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0111
        L_0x0099:
            java.lang.String r0 = "INSTAGRAM"
            boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x00a2
            goto L_0x00f3
        L_0x00a2:
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r9 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r0 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0123 }
            boolean r9 = r9.appInstalledOrNot(r0, r1)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x00bb
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatform(r6)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r5)     // Catch:{ Exception -> 0x0123 }
            goto L_0x00c0
        L_0x00bb:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r1)     // Catch:{ Exception -> 0x0123 }
        L_0x00c0:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0111
        L_0x00c6:
            java.lang.String r0 = "WHATSAPP"
            boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x00cf
            goto L_0x00f3
        L_0x00cf:
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r9 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r0 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0123 }
            boolean r9 = r9.appInstalledOrNot(r0, r2)     // Catch:{ Exception -> 0x0123 }
            if (r9 != 0) goto L_0x00e8
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatform(r6)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r5)     // Catch:{ Exception -> 0x0123 }
            goto L_0x00ed
        L_0x00e8:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r2)     // Catch:{ Exception -> 0x0123 }
        L_0x00ed:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            goto L_0x0111
        L_0x00f3:
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatformPresent(r7)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r9.setSharePlatform(r6)     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r9 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent r0 = r8.this$0     // Catch:{ Exception -> 0x0123 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r0 = android.provider.Telephony.Sms.getDefaultSmsPackage(r0)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r1 = "getDefaultSmsPackage(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0123 }
            r9.setPackageName(r0)     // Catch:{ Exception -> 0x0123 }
        L_0x0111:
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.share.states.ShareModuleStates>> r9 = r8.$coroutine     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r0 = new com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.states.ShareModuleStates$SharePlatformValidation r1 = new com.mpl.androidapp.share.states.ShareModuleStates$SharePlatformValidation     // Catch:{ Exception -> 0x0123 }
            com.mpl.androidapp.share.models.ShareData r2 = r8.$parameters     // Catch:{ Exception -> 0x0123 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0123 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0123 }
            r9.resumeWith(r0)     // Catch:{ Exception -> 0x0123 }
            goto L_0x012e
        L_0x0123:
            r9 = move-exception
            kotlinx.coroutines.CancellableContinuation<com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult<? extends com.mpl.androidapp.share.states.ShareModuleStates>> r0 = r8.$coroutine
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r1 = new com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error
            r1.<init>(r9)
            r0.resumeWith(r1)
        L_0x012e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0131:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent$execute$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
