package com.mpl.androidapp.game.androidgames.cardGame.implementations;

import android.content.Context;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.app.CFGMendikot;
import com.cfg.mendikot.app.ISDKListener;
import com.cfg.mendikot.app.SDKConfig;
import com.cfg.mendikot.app.SDKEvent;
import com.cfg.mendikot.app.SDKMode;
import com.cfg.utilities.Handle;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import com.mpl.androidapp.game.androidgames.cardGame.models.GameConfigInput;
import com.mpl.androidapp.game.androidgames.data.GameData;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J<\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020#2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u000202H\u0002J\u0006\u00104\u001a\u00020!J\u000e\u00105\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u00106\u001a\u0002022\u0006\u0010,\u001a\u00020#H\u0002J\b\u00107\u001a\u000202H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J4\u00109\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020.0:j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020.`;2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001e¨\u0006="}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameConfigImpl;", "", "input", "Lcom/mpl/androidapp/game/androidgames/cardGame/models/GameConfigInput;", "(Lcom/mpl/androidapp/game/androidgames/cardGame/models/GameConfigInput;)V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "applicationContext$delegate", "Lkotlin/Lazy;", "cardGameInstance", "Lcom/cfg/mendikot/app/CFGMendikot;", "getCardGameInstance", "()Lcom/cfg/mendikot/app/CFGMendikot;", "cardGameInstance$delegate", "gameDataResource", "Lcom/mpl/androidapp/game/androidgames/data/GameData;", "getGameDataResource", "()Lcom/mpl/androidapp/game/androidgames/data/GameData;", "gameDataResource$delegate", "listener", "Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/InitilizeMindiConfig;", "getListener", "()Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/InitilizeMindiConfig;", "setListener", "(Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/InitilizeMindiConfig;)V", "sdkConfig", "Lcom/cfg/mendikot/app/SDKConfig;", "getSdkConfig", "()Lcom/cfg/mendikot/app/SDKConfig;", "sdkConfig$delegate", "exceptionLog", "", "messageLog", "", "getSdkMode", "Lcom/cfg/mendikot/app/SDKMode;", "handleEvent", "sdkEvent", "Lcom/cfg/mendikot/app/SDKEvent;", "mindiBundle", "Landroid/os/Bundle;", "initMindiKotSdkConfig", "tolken", "connectTimeout", "", "automaticReconnection", "downloadPath", "isScreenSecure", "", "emojiEnabled", "initMindikotSdk", "initOnClickInterface", "isConfigAndInitCardGame", "isScreenSecureEnabled", "normalLog", "setWebSocketClient", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardGameConfigImpl.kt */
public final class CardGameConfigImpl {
    public static final Companion Companion = new Companion(null);
    public static final String MESSAGE_AUTH_EMPTY = "Auth token is empty";
    public static final String MESSAGE_AUTH_TOLKEN_IS_NULL = "Auth token is null so cannot launch the game";
    public static final String MESSAGE_CONFIG_AFTER_INIT = "Config Values after Initializing";
    public static final String MESSAGE_ERROR_INITILIZING_SDK = "Error in Initializing sdk";
    public static final String MESSAGE_GAME_INITILIZED = "Game is Initialized";
    public static final String MESSAGE_GAME_NOT_INITILIZED = "Game is not Initialized from SDK";
    public static final String MESSAGE_INIT_SDK = "Initialize sdk";
    public final Lazy applicationContext$delegate = TweetUtils.lazy((Function0<? extends T>) new CardGameConfigImpl$applicationContext$2<Object>(this));
    public final Lazy cardGameInstance$delegate = TweetUtils.lazy((Function0<? extends T>) new CardGameConfigImpl$cardGameInstance$2<Object>(this));
    public final Lazy gameDataResource$delegate = TweetUtils.lazy((Function0<? extends T>) new CardGameConfigImpl$gameDataResource$2<Object>(this));
    public final GameConfigInput input;
    public InitilizeMindiConfig listener;
    public final Lazy sdkConfig$delegate = TweetUtils.lazy((Function0<? extends T>) new CardGameConfigImpl$sdkConfig$2<Object>(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/implementations/CardGameConfigImpl$Companion;", "", "()V", "MESSAGE_AUTH_EMPTY", "", "MESSAGE_AUTH_TOLKEN_IS_NULL", "MESSAGE_CONFIG_AFTER_INIT", "MESSAGE_ERROR_INITILIZING_SDK", "MESSAGE_GAME_INITILIZED", "MESSAGE_GAME_NOT_INITILIZED", "MESSAGE_INIT_SDK", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameConfigImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardGameConfigImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SDKEvent.values().length];
            SDKEvent sDKEvent = SDKEvent.INSUFFICIENT_BALANCE;
            iArr[0] = 1;
            SDKEvent sDKEvent2 = SDKEvent.INVALID_TOKEN;
            iArr[1] = 2;
            SDKEvent sDKEvent3 = SDKEvent.INVALID_APPLICATION_CONTEXT;
            iArr[2] = 3;
            SDKEvent sDKEvent4 = SDKEvent.INVALID_MODE;
            iArr[3] = 4;
            SDKEvent sDKEvent5 = SDKEvent.INVALID_FILE_HANDLE;
            iArr[4] = 5;
            SDKEvent sDKEvent6 = SDKEvent.BACK_PRESSED;
            iArr[5] = 6;
            SDKEvent sDKEvent7 = SDKEvent.ASSETS_LOADED;
            iArr[8] = 7;
            SDKEvent sDKEvent8 = SDKEvent.GAME_CREATED;
            iArr[9] = 8;
            SDKEvent sDKEvent9 = SDKEvent.GAME_PAUSED;
            iArr[10] = 9;
            SDKEvent sDKEvent10 = SDKEvent.GAME_DISPOSED;
            iArr[11] = 10;
            SDKEvent sDKEvent11 = SDKEvent.GAME_RESUMED;
            iArr[12] = 11;
            SDKEvent sDKEvent12 = SDKEvent.GAME_CONNECTION_LOST;
            iArr[14] = 12;
            SDKEvent sDKEvent13 = SDKEvent.GAME_RECONNECTION_STARTED;
            iArr[15] = 13;
            SDKEvent sDKEvent14 = SDKEvent.GAME_RECONNECTED;
            iArr[16] = 14;
            SDKEvent sDKEvent15 = SDKEvent.GAME_FATAL;
            iArr[13] = 15;
            SDKEvent sDKEvent16 = SDKEvent.GAME_LEAVE;
            iArr[6] = 16;
            SDKEvent sDKEvent17 = SDKEvent.GAME_END;
            iArr[7] = 17;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CardGameConfigImpl(GameConfigInput gameConfigInput) {
        Intrinsics.checkNotNullParameter(gameConfigInput, "input");
        this.input = gameConfigInput;
    }

    private final void exceptionLog(String str) {
        InitilizeMindiConfig initilizeMindiConfig = this.listener;
        if (initilizeMindiConfig != null) {
            initilizeMindiConfig.messageEventInitilizeMindiConfig(true, false, str);
        }
    }

    private final Context getApplicationContext() {
        return (Context) this.applicationContext$delegate.getValue();
    }

    private final CFGMendikot getCardGameInstance() {
        return (CFGMendikot) this.cardGameInstance$delegate.getValue();
    }

    private final GameData getGameDataResource() {
        return (GameData) this.gameDataResource$delegate.getValue();
    }

    private final SDKConfig getSdkConfig() {
        return (SDKConfig) this.sdkConfig$delegate.getValue();
    }

    private final SDKMode getSdkMode() {
        String buildFlavor = MBuildConfigUtils.getBuildFlavor();
        Intrinsics.checkNotNullExpressionValue(buildFlavor, "getBuildFlavor()");
        if (CharsKt__CharKt.contains$default((CharSequence) buildFlavor, (CharSequence) "production", false, 2)) {
            return SDKMode.PROD;
        }
        return SDKMode.STAGE;
    }

    private final SDKConfig initMindiKotSdkConfig(String str, int i, int i2, String str2, boolean z, boolean z2) {
        SDKConfig sdkConfig = getSdkConfig();
        sdkConfig.setExternalAuthToken(str);
        sdkConfig.setContext(getApplicationContext());
        sdkConfig.setMode(getSdkMode());
        sdkConfig.setFileHandle(Handle.EXTERNAL);
        sdkConfig.setAssetsDirectoryName(str2);
        sdkConfig.setSecure(z);
        sdkConfig.setEmojiEnabled(z2);
        sdkConfig.setSocketConfigMap(setWebSocketClient(i, i2));
        sdkConfig.setSDKListener(new ISDKListener() {
            public final void onEvent(SDKEvent sDKEvent, Bundle bundle) {
                CardGameConfigImpl.m11initMindiKotSdkConfig$lambda3$lambda2(CardGameConfigImpl.this, sDKEvent, bundle);
            }
        });
        return sdkConfig;
    }

    public static /* synthetic */ SDKConfig initMindiKotSdkConfig$default(CardGameConfigImpl cardGameConfigImpl, String str, int i, int i2, String str2, boolean z, boolean z2, int i3, Object obj) {
        return cardGameConfigImpl.initMindiKotSdkConfig(str, i, i2, str2, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? true : z2);
    }

    /* renamed from: initMindiKotSdkConfig$lambda-3$lambda-2  reason: not valid java name */
    public static final void m11initMindiKotSdkConfig$lambda3$lambda2(CardGameConfigImpl cardGameConfigImpl, SDKEvent sDKEvent, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cardGameConfigImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(sDKEvent, "sdkEvent");
        cardGameConfigImpl.handleEvent(sDKEvent, bundle);
    }

    private final boolean isConfigAndInitCardGame(String str) {
        if (str.length() > 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(CardGameFeature.GAME_DOWNLOAD_PATH);
            outline73.append(this.input.getGameDataResource().getGameId());
            outline73.append('/');
            String sb = outline73.toString();
            Integer valueOf = Integer.valueOf(this.input.getGameDataResource().getConnectTimeout());
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(input.gameDataResource.connectTimeout)");
            int intValue = valueOf.intValue();
            Integer valueOf2 = Integer.valueOf(this.input.getGameDataResource().getAutomaticReconnection());
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(input.gameDataRe…ce.automaticReconnection)");
            SDKConfig initMindiKotSdkConfig = initMindiKotSdkConfig(str, intValue, valueOf2.intValue(), sb, isScreenSecureEnabled(), this.input.getGameDataResource().getEmojiEnabled());
            getCardGameInstance().init(initMindiKotSdkConfig);
            if (getCardGameInstance().init(initMindiKotSdkConfig)) {
                normalLog(MESSAGE_GAME_INITILIZED);
                normalLog(Intrinsics.stringPlus("Config Values after Initializing ", getCardGameInstance().getSDKConfig()));
                return true;
            }
            normalLog(MESSAGE_GAME_NOT_INITILIZED);
        } else {
            normalLog(MESSAGE_AUTH_EMPTY);
        }
        return false;
    }

    private final boolean isScreenSecureEnabled() {
        String buildFlavor = MBuildConfigUtils.getBuildFlavor();
        Intrinsics.checkNotNullExpressionValue(buildFlavor, "getBuildFlavor()");
        return CharsKt__CharKt.contains$default((CharSequence) buildFlavor, (CharSequence) "production", false, 2);
    }

    private final void normalLog(String str) {
        InitilizeMindiConfig initilizeMindiConfig = this.listener;
        if (initilizeMindiConfig != null) {
            initilizeMindiConfig.messageEventInitilizeMindiConfig(false, false, str);
        }
    }

    private final HashMap<String, Integer> setWebSocketClient(int i, int i2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(CardGameFeature.KEY_CONNECT_TIMEOUT, Integer.valueOf(i));
        hashMap.put(CardGameFeature.KEY_RECONNECTION_INTERVAL, Integer.valueOf(i2));
        return hashMap;
    }

    public final InitilizeMindiConfig getListener() {
        return this.listener;
    }

    public final void handleEvent(SDKEvent sDKEvent, Bundle bundle) {
        Intrinsics.checkNotNullParameter(sDKEvent, "sdkEvent");
        switch (sDKEvent.ordinal()) {
            case 0:
                InitilizeMindiConfig initilizeMindiConfig = this.listener;
                if (initilizeMindiConfig != null) {
                    initilizeMindiConfig.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 1:
                InitilizeMindiConfig initilizeMindiConfig2 = this.listener;
                if (initilizeMindiConfig2 != null) {
                    initilizeMindiConfig2.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 2:
                InitilizeMindiConfig initilizeMindiConfig3 = this.listener;
                if (initilizeMindiConfig3 != null) {
                    initilizeMindiConfig3.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 3:
                InitilizeMindiConfig initilizeMindiConfig4 = this.listener;
                if (initilizeMindiConfig4 != null) {
                    initilizeMindiConfig4.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 4:
                InitilizeMindiConfig initilizeMindiConfig5 = this.listener;
                if (initilizeMindiConfig5 != null) {
                    initilizeMindiConfig5.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 5:
                InitilizeMindiConfig initilizeMindiConfig6 = this.listener;
                if (initilizeMindiConfig6 != null) {
                    initilizeMindiConfig6.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 6:
                if (bundle != null) {
                    InitilizeMindiConfig listener2 = getListener();
                    if (listener2 != null) {
                        listener2.leftTheCardGame(bundle, sDKEvent.name());
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (bundle != null) {
                    InitilizeMindiConfig listener3 = getListener();
                    if (listener3 != null) {
                        listener3.endedTheCardGame(bundle, sDKEvent.name());
                        return;
                    }
                    return;
                }
                return;
            case 8:
                InitilizeMindiConfig initilizeMindiConfig7 = this.listener;
                if (initilizeMindiConfig7 != null) {
                    initilizeMindiConfig7.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 9:
                InitilizeMindiConfig initilizeMindiConfig8 = this.listener;
                if (initilizeMindiConfig8 != null) {
                    initilizeMindiConfig8.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 10:
                InitilizeMindiConfig initilizeMindiConfig9 = this.listener;
                if (initilizeMindiConfig9 != null) {
                    initilizeMindiConfig9.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 11:
                InitilizeMindiConfig initilizeMindiConfig10 = this.listener;
                if (initilizeMindiConfig10 != null) {
                    initilizeMindiConfig10.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 12:
                InitilizeMindiConfig initilizeMindiConfig11 = this.listener;
                if (initilizeMindiConfig11 != null) {
                    initilizeMindiConfig11.mindiGameCallback(sDKEvent.name());
                    return;
                }
                return;
            case 13:
                InitilizeMindiConfig initilizeMindiConfig12 = this.listener;
                if (initilizeMindiConfig12 != null) {
                    initilizeMindiConfig12.gameFatalCallback(sDKEvent.name());
                    return;
                }
                return;
            case 14:
                InitilizeMindiConfig initilizeMindiConfig13 = this.listener;
                if (initilizeMindiConfig13 != null) {
                    initilizeMindiConfig13.gameConnectionLost(sDKEvent.name());
                    return;
                }
                return;
            case 15:
                InitilizeMindiConfig initilizeMindiConfig14 = this.listener;
                if (initilizeMindiConfig14 != null) {
                    initilizeMindiConfig14.gameReConnectionStarted(sDKEvent.name());
                    return;
                }
                return;
            case 16:
                InitilizeMindiConfig initilizeMindiConfig15 = this.listener;
                if (initilizeMindiConfig15 != null) {
                    initilizeMindiConfig15.gameReConnected(sDKEvent.name());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void initMindikotSdk() {
        Unit unit;
        normalLog(MESSAGE_INIT_SDK);
        try {
            String authToken = getGameDataResource().getAuthToken();
            if (authToken == null) {
                unit = null;
            } else {
                if (isConfigAndInitCardGame(authToken)) {
                    InitilizeMindiConfig listener2 = getListener();
                    if (listener2 != null) {
                        listener2.cardGameSdkInitialized(getGameDataResource());
                    }
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                normalLog(MESSAGE_AUTH_TOLKEN_IS_NULL);
            }
        } catch (Exception e2) {
            exceptionLog(MESSAGE_ERROR_INITILIZING_SDK);
            e2.printStackTrace();
        }
    }

    public final void initOnClickInterface(InitilizeMindiConfig initilizeMindiConfig) {
        Intrinsics.checkNotNullParameter(initilizeMindiConfig, "listener");
        this.listener = initilizeMindiConfig;
    }

    public final void setListener(InitilizeMindiConfig initilizeMindiConfig) {
        this.listener = initilizeMindiConfig;
    }
}
