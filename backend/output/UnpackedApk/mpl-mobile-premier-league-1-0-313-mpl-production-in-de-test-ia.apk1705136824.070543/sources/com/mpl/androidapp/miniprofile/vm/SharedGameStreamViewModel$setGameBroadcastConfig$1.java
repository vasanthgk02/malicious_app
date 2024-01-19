package com.mpl.androidapp.miniprofile.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$setGameBroadcastConfig$1", f = "SharedGameStreamViewModel.kt", l = {}, m = "invokeSuspend")
/* compiled from: SharedGameStreamViewModel.kt */
public final class SharedGameStreamViewModel$setGameBroadcastConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SharedGameStreamViewModel this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SharedGameStreamViewModel$setGameBroadcastConfig$1(SharedGameStreamViewModel sharedGameStreamViewModel, Continuation<? super SharedGameStreamViewModel$setGameBroadcastConfig$1> continuation) {
        // this.this$0 = sharedGameStreamViewModel;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SharedGameStreamViewModel$setGameBroadcastConfig$1 sharedGameStreamViewModel$setGameBroadcastConfig$1 = new SharedGameStreamViewModel$setGameBroadcastConfig$1(this.this$0, continuation);
        sharedGameStreamViewModel$setGameBroadcastConfig$1.L$0 = obj;
        return sharedGameStreamViewModel$setGameBroadcastConfig$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SharedGameStreamViewModel$setGameBroadcastConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r1.label
            if (r0 != 0) goto L_0x020e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r19)
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            boolean r0 = r0.isFeatureEnabled()
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r2 = r1.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.isFeatureEnabled()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            r2.setValue(r3)
            org.json.JSONObject r2 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            org.json.JSONObject r3 = com.mpl.androidapp.config.ConfigManager.getHanselConfig()
            java.lang.String r4 = "SharedGameStreamViewModel"
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L_0x01bf
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r0.getGameBroadcastConfig()
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            r8 = 0
            if (r0 != 0) goto L_0x003f
            r0 = r8
            goto L_0x0082
        L_0x003f:
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$setGameBroadcastConfig$1$1$type$1 r9 = new com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$setGameBroadcastConfig$1$1$type$1     // Catch:{ Exception -> 0x005f }
            r9.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.reflect.Type r9 = r9.getType()     // Catch:{ Exception -> 0x005f }
            com.google.gson.Gson r10 = new com.google.gson.Gson     // Catch:{ Exception -> 0x005f }
            r10.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r11 = "gameBroadcast.configs"
            java.lang.String r0 = r0.getString(r11)     // Catch:{ Exception -> 0x005f }
            java.lang.Object r0 = r10.fromJson(r0, r9)     // Catch:{ Exception -> 0x005f }
            java.lang.String r9 = "{\n                      …  )\n                    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)     // Catch:{ Exception -> 0x005f }
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r0 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r0     // Catch:{ Exception -> 0x005f }
            goto L_0x0082
        L_0x005f:
            r0 = move-exception
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r10 = r0.getMessage()
            java.lang.String r11 = "Error in config : "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r10)
            r9[r6] = r10
            com.mpl.androidapp.utils.MLogger.e(r4, r9)
            r0.printStackTrace()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r0 = new com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 15
            r17 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)
        L_0x0082:
            if (r0 != 0) goto L_0x009b
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r9 = "Config Manager is null"
            r0[r6] = r9
            com.mpl.androidapp.utils.MLogger.e(r4, r0)
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r0 = new com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 15
            r16 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x009b:
            r7.setValue(r0)
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGameBroadcastConfig()
            java.lang.Object r7 = r7.getValue()
            java.lang.String r9 = "ZK Config : "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r7)
            r0[r6] = r7
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getShareText()
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGameBroadcastConfig()
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r7 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r7
            if (r7 != 0) goto L_0x00cb
        L_0x00c9:
            r7 = r8
            goto L_0x00d6
        L_0x00cb:
            com.mpl.androidapp.miniprofile.models.BroadcastChatConfig r7 = r7.getBroadcastChat()
            if (r7 != 0) goto L_0x00d2
            goto L_0x00c9
        L_0x00d2:
            java.lang.String r7 = r7.getShareText()
        L_0x00d6:
            r0.setValue(r7)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getShareVisibility()
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGameBroadcastConfig()
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r7 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r7
            if (r7 != 0) goto L_0x00ef
        L_0x00ed:
            r7 = r8
            goto L_0x00fe
        L_0x00ef:
            com.mpl.androidapp.miniprofile.models.BroadcastChatConfig r7 = r7.getBroadcastChat()
            if (r7 != 0) goto L_0x00f6
            goto L_0x00ed
        L_0x00f6:
            boolean r7 = r7.getShareEnabled()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x00fe:
            r0.setValue(r7)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getExternalShareVisibility()
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGameBroadcastConfig()
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r7 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r7
            if (r7 != 0) goto L_0x0117
        L_0x0115:
            r7 = r8
            goto L_0x0126
        L_0x0117:
            com.mpl.androidapp.miniprofile.models.BroadcastChatConfig r7 = r7.getBroadcastChat()
            if (r7 != 0) goto L_0x011e
            goto L_0x0115
        L_0x011e:
            boolean r7 = r7.getExternalShareEnabled()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x0126:
            r0.setValue(r7)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getInternalShareVisibility()
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGameBroadcastConfig()
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r7 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r7
            if (r7 != 0) goto L_0x013e
            goto L_0x014d
        L_0x013e:
            com.mpl.androidapp.miniprofile.models.BroadcastChatConfig r7 = r7.getBroadcastChat()
            if (r7 != 0) goto L_0x0145
            goto L_0x014d
        L_0x0145:
            boolean r7 = r7.getInternalShareEnabled()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r7)
        L_0x014d:
            r0.setValue(r8)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getGameBroadcastConfig()
            java.lang.Object r0 = r0.getValue()
            com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig r0 = (com.mpl.androidapp.miniprofile.kotlin.model.GameBroadcastConfig) r0
            if (r0 != 0) goto L_0x015f
            goto L_0x01a5
        L_0x015f:
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r8 = r7.getShowChatButton()
            com.mpl.androidapp.miniprofile.models.TournamentDetailsConfig r9 = r0.getTournamentDetails()
            boolean r9 = r9.getShowChatButton()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.setValue(r9)
            androidx.lifecycle.MutableLiveData r8 = r7.getShowPlayers()
            com.mpl.androidapp.miniprofile.models.TournamentDetailsConfig r9 = r0.getTournamentDetails()
            boolean r9 = r9.getShowPlayers()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.setValue(r9)
            androidx.lifecycle.MutableLiveData r8 = r7.getShowRecommendedVideos()
            com.mpl.androidapp.miniprofile.models.TournamentDetailsConfig r9 = r0.getTournamentDetails()
            boolean r9 = r9.getShowRecommendedBroadcasts()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.setValue(r9)
            com.mpl.androidapp.miniprofile.models.BroadcastChatConfig r0 = r0.getBroadcastChat()
            long r8 = r0.getHeartThrottle()
            r7.setConfigHeartThrottle(r8)
        L_0x01a5:
            org.json.JSONObject r0 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()
            if (r0 != 0) goto L_0x01ac
            goto L_0x01bf
        L_0x01ac:
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r7 = r1.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.getGlobalChatEnabledV2Config()
            java.lang.String r8 = "chat.directmessage.enabledV2"
            boolean r0 = r0.optBoolean(r8, r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.setValue(r0)
        L_0x01bf:
            if (r2 == 0) goto L_0x0200
            if (r3 == 0) goto L_0x0200
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            com.mpl.androidapp.miniprofile.kotlin.model.ProfileConfig r0 = r0.getProfileConfig()
            boolean r0 = r0.getUsernameEnabled()
            java.lang.String r2 = "profile_username_surface_enabled"
            boolean r2 = r3.optBoolean(r2, r6)
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)
            java.lang.String r9 = "IS USER NAME ENABLED IN ZK-> "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            r7[r6] = r8
            com.mpl.androidapp.utils.MLogger.d(r4, r7)
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            java.lang.String r9 = "IS USER NAME ENABLED IN HANSEL-> "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            r7[r6] = r8
            com.mpl.androidapp.utils.MLogger.d(r4, r7)
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r4 = r1.this$0
            if (r0 == 0) goto L_0x01fc
            if (r2 == 0) goto L_0x01fc
            goto L_0x01fd
        L_0x01fc:
            r5 = 0
        L_0x01fd:
            r4.setUserNameEnabledInConfig(r5)
        L_0x0200:
            com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel r0 = r1.this$0
            java.lang.String r2 = "profile_show_win_rate"
            boolean r2 = r3.optBoolean(r2, r6)
            r0.setGameStatsEnabled(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x020e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel$setGameBroadcastConfig$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
