package com.mpl.androidapp.smartfox;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.gson.Gson;
import com.mpl.androidapp.R;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.databinding.ActivityMplSmfxConnectorBinding;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.AnonymousClass3;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import com.netcore.android.SMTEventParamKeys;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.LoginRequest;
import sfs2x.client.util.ConfigData;

public class MPLSFS2XConnectorActivity extends Activity implements IEventListener, OnClickListener {
    public static final int COLOR_BLUE = Color.parseColor("#99CCFF");
    public static final int COLOR_GRAY = Color.parseColor("#cccccc");
    public static final int COLOR_GREEN = Color.parseColor("#99FF99");
    public static final int COLOR_ORANGE = Color.parseColor("#f4aa0b");
    public static final int COLOR_RED = Color.parseColor("#FF0000");
    public static final int REQUEST_SUBMIT_SCORE = 1223;
    public static final String TAG = "SFS2XConnector:";
    public static final SimpleDateFormat logDateFormater = new SimpleDateFormat("h:mm:ss", Locale.US);
    public final String APP_VERSION = SMTEventParamKeys.SMT_APP_VERSION;
    public final String AUTH_TOKEN = "authToken";
    public final String AVATAR = "avatar";
    public final String BATTLE_AGAIN = "fightAgain";
    public final String BATTLE_FINISHED = "BATTLE_FINISHED";
    public final String CANCEL_CHALLENGE = "cancelChallenge";
    public final String CHALLENGE_ID = "challengeId";
    public final String CLIENT_BROADCAST = "CLIENT_BROADCAST";
    public final String DATA = "data";
    public final String FIGHT_AGAIN = "fightAgain";
    public final String FIGHT_AGAIN_REQUESTED = "FIGHT_AGAIN_REQUESTED";
    public final String FIGHT_AGAIN_STATE_CHANGED = "FIGHT_AGAIN_STATE_CHANGED";
    public final String FINAL_SCORE = "finalScore";
    public final String FIND_MATCH = "findMatch";
    public final String FIND_MATCH_FAILED = "FAILED_TO_FIND_MATCH";
    public final String FRAUD_DETECTED = "fraudDetected";
    public final String FRAUD_PROOF = "fraudProof";
    public final String FRAUD_TYPE = "fraudType";
    public final String GAME_DATA = "gameData";
    public final String GAME_END = "END_GAME";
    public final String GAME_LOADED = "GAME_LOADED";
    public final String GET_ACCOUNT_BALANCE = "getAccountBalance";
    public final String IS_IN_DEBUG_MODE = "isInDebugMode";
    public final String IS_PRO = "isPro";
    public final String KNOCKOUT_MATCH_USER_IN = "KNOCKOUT_MATCH_USER_IN";
    public final String LOBBY_ID = "lobbyId";
    public final String MATCH_FOUND = "MATCH_FOUND";
    public final String MATCH_USER_IN = "MATCH_USER_IN";
    public final String MATCH_USER_OUT = "MATCH_USER_OUT";
    public final String MOBILE_NUMBER = "mobileNumber";
    public final String MPL_USER_ID = "mplUserId";
    public final String NAME = "displayName";
    public final String ON_GAME_LOADED = "onGameLoaded";
    public final String ON_READY = "onReady";
    public final String OPPONENTS_DID_NOT_JOIN = "OPPONENTS_DID_NOT_JOIN";
    public final String OPPONENT_DID_NOT_JOIN = "OPPONENT_DID_NOT_JOIN";
    public final String OPPONENT_DID_NOT_JOIN_KNOCKOUT = "OPPONENT_DID_NOT_JOIN_KNOCKOUT";
    public final String OPPONENT_FINISHED = "OPPONENT_FINISHED";
    public final String OPPONENT_MISSED_PING = "OPPONENT_MISSED_PING";
    public final String PING = "PING";
    public final String PONG = "PONG";
    public final String PROTOCOL = "protocol";
    public final String SCORE = VideoRecordingConstants.SCORE;
    public final String SEND_BROADCAST = "SendBroadcast";
    public final String SERVER_ERROR = "SERVER_ERROR";
    public final String START_BATTLE = "START_BATTLE";
    public final String SUBMIT_SCORE = "submitScore";
    public final String TIER = "tier";
    public final String TOTAL_PLAYERS = "totalPlayers";
    public final String WINNERS = "winners";
    public boolean battleFinished;
    public boolean connectionLostCalled;
    public Status currentStatus = null;
    public SmartFoxManagerReasons disconnectionReason;
    public boolean is1VN;
    public boolean isKnockoutTournament;
    public boolean isUserPopulated = false;
    public String mBattleId;
    public ActivityMplSmfxConnectorBinding mBinding;
    public Profile mCurrentProfile;
    public GameConfig mGameConfig;
    public AllGame mGameInfo;
    public LayoutInflater mLayoutInflater;
    public JSONArray mMatchedUsersArray;
    public Timer mMatchingTimer;
    public TimerTask mMatchingTimerTask;
    public AlertDialog mOverLayAlertDialog;
    public Timer mPingServerTimer;
    public TimerTask mPingServerTimerTask;
    public PlayerListAdapter mPlayerListAdapter;
    public HashMap<Integer, List<Double>> mRewardsMap;
    public boolean manuallyDisconnected;
    public SmartFoxManagerMonitor monitorType;
    public ArrayList<PlayerItem> playerList;
    public PrizeBreakUpListAdapter prizeBreakUpListAdapter;
    public String redirectActivity;
    public String redirectPackage;
    public SmartFox sfsClient;
    public int thirdPartyGameIntentFlags = 402718720;
    public int thirdPartyGameIntentFlagsNew = 471957504;

    /* renamed from: com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|(2:3|4)|5|(2:7|8)|9|(2:11|12)|13|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status[] r0 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status = r0
                r1 = 1
                r2 = 8
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r3 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.CRYPTO_ERROR     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r3 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0017 }
                r3 = 2
                r0[r3] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r0 = 3
                int[] r3 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x001f }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r4 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                r4 = 0
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r3 = 4
                int[] r4 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x0026 }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r5 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.CONNECTION_ERROR     // Catch:{ NoSuchFieldError -> 0x0026 }
                r4[r0] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                r0 = 5
                int[] r4 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x002d }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r5 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x002d }
                r4[r1] = r0     // Catch:{ NoSuchFieldError -> 0x002d }
            L_0x002d:
                r1 = 6
                int[] r4 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x0034 }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r5 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.CONNECTION_LOST     // Catch:{ NoSuchFieldError -> 0x0034 }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                int[] r3 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x003b }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r4 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.LOGGED     // Catch:{ NoSuchFieldError -> 0x003b }
                r4 = 7
                r3[r0] = r4     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                int[] r0 = $SwitchMap$com$mpl$androidapp$smartfox$MPLSFS2XConnectorActivity$Status     // Catch:{ NoSuchFieldError -> 0x0041 }
                com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r3 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.IN_A_ROOM     // Catch:{ NoSuchFieldError -> 0x0041 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.AnonymousClass4.<clinit>():void");
        }
    }

    public enum SmartFoxManagerMonitor {
        None,
        Matchmaking,
        Gameplay,
        ScoreSubmission
    }

    public enum SmartFoxManagerReasons {
        FailedToFindMatch,
        OpponentDidNotJoin,
        RoomJoinError,
        MonitorTimeout,
        WentInBackgroundMM,
        ConnectionError,
        Hacked,
        MatchFoundTimedOut,
        PingPongTimeout,
        WentInBackgroundTransition,
        AppQuit,
        ManuallyDisconnected,
        ConnectionTimeout,
        EncryptionInitializationFailed,
        OpponentsDidNotJoin
    }

    public enum Status {
        DISCONNECTED,
        CONNECTED,
        CONNECTING,
        CONNECTION_ERROR,
        CONNECTION_LOST,
        LOGGED,
        IN_A_ROOM,
        LOGGING_ERROR,
        CRYPTO_ERROR
    }

    private void CleanUp() {
        SmartFox smartFox = this.sfsClient;
        if (smartFox == null) {
            MLogger.d(TAG, "MPL: SFS2X smartFox already null");
            return;
        }
        smartFox.removeAllEventListeners();
        this.sfsClient = null;
    }

    private void OpponentFinished() {
    }

    private void UserDisconnected() {
        runOnUiThread($$Lambda$MPLSFS2XConnectorActivity$3igjcRD3cbzZfYBF6cdDobsyok.INSTANCE);
    }

    private void connect() {
        if (TextUtils.isEmpty(this.mGameConfig.getHost())) {
            setStatusMessage("Host is null", COLOR_RED);
            return;
        }
        int parseInt = Integer.parseInt("9933");
        MLogger.d(TAG, "connect:Host ", this.mGameConfig.getHost(), "Post: ", Integer.valueOf(parseInt), "Zone: ", this.mGameConfig.getZone());
        ConfigData configData = new ConfigData();
        configData.setDebug(MBuildConfigUtils.isLogEnabled());
        configData.setHost(this.mGameConfig.getHost());
        configData.setPort(parseInt);
        configData.setZone(this.mGameConfig.getZone());
        MLogger.d(TAG, "run: ", configData.getHost(), Integer.valueOf(configData.getPort()), configData.getZone(), configData.getBboxHost(), configData.getUdpHost());
        this.sfsClient.connect(configData);
    }

    private void disconnect() {
        MLogger.d(TAG, "Disconnecting");
        SmartFox smartFox = this.sfsClient;
        if (smartFox != null && smartFox.isConnected()) {
            MLogger.d(TAG, "Disconnect: Disconnecting client");
            this.sfsClient.disconnect();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Disconnect: Disconnected ? ");
            outline73.append(true ^ this.sfsClient.isConnected());
            MLogger.d(TAG, outline73.toString());
        }
    }

    private void getAllUsers(ISFSObject iSFSObject) {
        runOnUiThread(new Runnable(iSFSObject) {
            public final /* synthetic */ ISFSObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$getAllUsers$5$MPLSFS2XConnectorActivity(this.f$1);
            }
        });
    }

    private void initSmartFox() {
        SmartFox smartFox = new SmartFox(MBuildConfigUtils.isLogEnabled());
        this.sfsClient = smartFox;
        smartFox.addEventListener(SFSEvent.HANDSHAKE, this);
        this.sfsClient.addEventListener(SFSEvent.CRYPTO_INIT, this);
        this.sfsClient.addEventListener(SFSEvent.UDP_INIT, this);
        this.sfsClient.addEventListener("connection", this);
        this.sfsClient.addEventListener(SFSEvent.PING_PONG, this);
        this.sfsClient.addEventListener(SFSEvent.SOCKET_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.CONNECTION_LOST, this);
        this.sfsClient.addEventListener(SFSEvent.CONNECTION_RETRY, this);
        this.sfsClient.addEventListener(SFSEvent.CONNECTION_RESUME, this);
        this.sfsClient.addEventListener(SFSEvent.CONNECTION_ATTEMPT_HTTP, this);
        this.sfsClient.addEventListener(SFSEvent.CONFIG_LOAD_SUCCESS, this);
        this.sfsClient.addEventListener(SFSEvent.CONFIG_LOAD_FAILURE, this);
        this.sfsClient.addEventListener(SFSEvent.LOGIN, this);
        this.sfsClient.addEventListener(SFSEvent.LOGIN_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.LOGOUT, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_ADD, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_REMOVE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_CREATION_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_JOIN, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_JOIN_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.USER_ENTER_ROOM, this);
        this.sfsClient.addEventListener(SFSEvent.USER_EXIT_ROOM, this);
        this.sfsClient.addEventListener(SFSEvent.USER_COUNT_CHANGE, this);
        this.sfsClient.addEventListener(SFSEvent.PUBLIC_MESSAGE, this);
        this.sfsClient.addEventListener(SFSEvent.PRIVATE_MESSAGE, this);
        this.sfsClient.addEventListener(SFSEvent.MODERATOR_MESSAGE, this);
        this.sfsClient.addEventListener(SFSEvent.ADMIN_MESSAGE, this);
        this.sfsClient.addEventListener(SFSEvent.OBJECT_MESSAGE, this);
        this.sfsClient.addEventListener(SFSEvent.EXTENSION_RESPONSE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_VARIABLES_UPDATE, this);
        this.sfsClient.addEventListener(SFSEvent.USER_VARIABLES_UPDATE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_GROUP_SUBSCRIBE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_GROUP_UNSUBSCRIBE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_GROUP_SUBSCRIBE_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_GROUP_UNSUBSCRIBE_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.SPECTATOR_TO_PLAYER, this);
        this.sfsClient.addEventListener(SFSEvent.PLAYER_TO_SPECTATOR, this);
        this.sfsClient.addEventListener(SFSEvent.SPECTATOR_TO_PLAYER_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.PLAYER_TO_SPECTATOR_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_NAME_CHANGE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_NAME_CHANGE_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_PASSWORD_STATE_CHANGE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_PASSWORD_STATE_CHANGE_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_CAPACITY_CHANGE, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_CAPACITY_CHANGE_ERROR, this);
        this.sfsClient.addEventListener(SFSEvent.ROOM_FIND_RESULT, this);
        this.sfsClient.addEventListener(SFSEvent.USER_FIND_RESULT, this);
        this.sfsClient.addEventListener(SFSEvent.INVITATION, this);
        this.sfsClient.addEventListener(SFSEvent.INVITATION_REPLY, this);
        this.sfsClient.addEventListener(SFSEvent.INVITATION_REPLY_ERROR, this);
        this.sfsClient.addEventListener("findMatch", this);
        this.sfsClient.addEventListener("SendBroadcast", this);
        this.sfsClient.addEventListener("onReady", this);
        this.sfsClient.addEventListener("onGameLoaded", this);
        this.sfsClient.addEventListener("START_BATTLE", this);
        this.sfsClient.addEventListener("submitScore", this);
        this.sfsClient.addEventListener("BATTLE_FINISHED", this);
        this.sfsClient.addEventListener("FAILED_TO_FIND_MATCH", this);
        this.sfsClient.addEventListener("OPPONENT_DID_NOT_JOIN", this);
        this.sfsClient.addEventListener("OPPONENTS_DID_NOT_JOIN", this);
        this.sfsClient.addEventListener("fightAgain", this);
        this.sfsClient.addEventListener("getAccountBalance", this);
        this.sfsClient.addEventListener("END_GAME", this);
        this.sfsClient.addEventListener("fraudDetected", this);
        this.sfsClient.addEventListener("FIGHT_AGAIN_REQUESTED", this);
        this.sfsClient.addEventListener("OPPONENT_FINISHED", this);
        this.sfsClient.addEventListener("FIGHT_AGAIN_STATE_CHANGED", this);
        this.sfsClient.addEventListener("MATCH_FOUND", this);
        this.sfsClient.addEventListener("MATCH_USER_IN", this);
        this.sfsClient.addEventListener("MATCH_USER_OUT", this);
        this.sfsClient.addEventListener("SERVER_ERROR", this);
        this.sfsClient.addEventListener("GAME_LOADED", this);
        this.sfsClient.addEventListener("PING", this);
        this.sfsClient.addEventListener("PONG", this);
        this.sfsClient.addEventListener("challengeId", this);
        this.sfsClient.addEventListener("CLIENT_BROADCAST", this);
        this.sfsClient.addEventListener("OPPONENT_MISSED_PING", this);
        this.sfsClient.setDebug(MBuildConfigUtils.isLogEnabled());
        MLogger.d(TAG, "SmartFox created:", "isConnected: ", Boolean.valueOf(this.sfsClient.isConnected()), " ,BlueBox enabled =", Boolean.valueOf(this.sfsClient.useBlueBox()), " ,isUdpInited =", Boolean.valueOf(this.sfsClient.isUdpInited()), " ,isConnecting =", Boolean.valueOf(this.sfsClient.isConnecting()));
        setStatus(Status.CONNECTING, new String[0]);
        connect();
        resetTimer();
    }

    private void initUI() {
        MLogger.d(TAG, "initUI: ", Boolean.valueOf(this.is1VN), Boolean.valueOf(this.isKnockoutTournament));
        this.playerList = new ArrayList<>();
        AllGame gameInfo = CommonUtils.getGameInfo(this.mGameConfig.getGameId());
        this.mGameInfo = gameInfo;
        if (gameInfo != null) {
            this.mBinding.gameName.setText(gameInfo.getName());
            showFindMatchSuccessScreen();
            if (this.mGameInfo.getIcons() == null || TextUtils.isEmpty(this.mGameInfo.getIcons().getMmScreen())) {
                this.mBinding.gameBackground.setVisibility(8);
            } else {
                this.mBinding.gameBackground.setVisibility(0);
                this.mBinding.gameBackground.setImageURI(Uri.parse(this.mGameInfo.getIcons().getMmScreen()));
            }
            if (this.mGameConfig.getTotalPlayers() != null && this.mGameConfig.getTotalPlayers().doubleValue() > 2.0d) {
                this.is1VN = this.mGameConfig.getTotalPlayers().doubleValue() > 2.0d;
            }
            if (this.isKnockoutTournament) {
                this.mBinding.knockoutStatusContainer.setVisibility(0);
                this.mBinding.didNotJoinContainer.setVisibility(0);
                this.mBinding.playerStatusDesc.setVisibility(8);
                this.mBinding.didNotJoinOkButton.setVisibility(8);
                this.mBinding.battleDescTxt.setVisibility(0);
                this.mBinding.prizeBreakUp.setVisibility(8);
                this.mBinding.multiPlayerDesc.setVisibility(8);
                this.mBinding.firstRankContainer.setVisibility(8);
                this.mBinding.prizeBreakUpList.setVisibility(8);
                this.mBinding.headerLayoutNormal.setVisibility(8);
                this.mBinding.headerLayoutKO.setVisibility(0);
                this.mBinding.battlePlayerStatusImgContainer.setVisibility(8);
                this.mBinding.progressContainer.setVisibility(0);
                this.mBinding.statusContainer.setVisibility(8);
            } else {
                this.mBinding.knockoutStatusContainer.setVisibility(8);
                this.mBinding.didNotJoinContainer.setVisibility(8);
                this.mBinding.progressContainer.setVisibility(8);
                this.mBinding.headerLayoutKO.setVisibility(8);
                if (this.is1VN) {
                    this.mBinding.prizeBreakUp.setVisibility(0);
                    this.mBinding.multiPlayerDesc.setVisibility(0);
                    this.mBinding.firstRankContainer.setVisibility(8);
                    this.mBinding.prizeBreakUpList.setVisibility(8);
                    prePareRewards();
                } else if (this.mGameConfig.getWinningAmount() != null) {
                    this.mBinding.prizeBreakUpList.setVisibility(8);
                    this.mBinding.multiPlayerDesc.setVisibility(8);
                    this.mBinding.firstRankPositionText.setText(R.string.winner);
                    this.mBinding.firstRankAmountText.setText(String.valueOf(this.mGameConfig.getWinningAmount()));
                }
            }
        }
        if (this.mCurrentProfile != null) {
            PlayerItem playerItem = new PlayerItem();
            if (!TextUtils.isEmpty(this.mCurrentProfile.getAvatar())) {
                playerItem.setPlayerAvatar(this.mCurrentProfile.getAvatar());
            } else {
                playerItem.setPlayerAvatar("");
            }
            if (!TextUtils.isEmpty(this.mCurrentProfile.getDisplayName())) {
                playerItem.setPlayerName(this.mCurrentProfile.getDisplayName());
            } else {
                playerItem.setPlayerName("");
            }
            playerItem.setUserId(this.mCurrentProfile.getId().intValue());
            playerItem.setCurrentUser(true);
            playerItem.setJoined(true);
            this.playerList.add(playerItem);
            this.mBinding.matchedPlayerList.setLayoutManager(new GridLayoutManager(this, 2));
            PlayerListAdapter playerListAdapter = new PlayerListAdapter(this, this.playerList, this.isKnockoutTournament);
            this.mPlayerListAdapter = playerListAdapter;
            this.mBinding.matchedPlayerList.setAdapter(playerListAdapter);
            return;
        }
        CommonUtils.showToast(this, false, "Profile is null");
    }

    private void joinRoom() {
        SFSObject newInstance = SFSObject.newInstance();
        newInstance.putUtfString("authToken", this.mGameConfig.getAuthToken());
        newInstance.putUtfString("displayName", this.mCurrentProfile.getDisplayName());
        newInstance.putUtfString("avatar", this.mCurrentProfile.getAvatar());
        newInstance.putUtfString("tier", this.mCurrentProfile.getAvatar());
        newInstance.putBool("isPro", this.mCurrentProfile.getPro().booleanValue());
        newInstance.putBool("isInDebugMode", MBuildConfigUtils.isLogEnabled());
        this.sfsClient.send(new LoginRequest(UUID.randomUUID().toString(), "", this.mGameConfig.getZone(), newInstance));
    }

    public static /* synthetic */ void lambda$UserDisconnected$2() {
    }

    public static /* synthetic */ void lambda$showOverlayDialog$13(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private void log(String str) {
        MLogger.d(TAG, "log: ", logDateFormater.format(new Date()) + ": " + str);
    }

    private void onOpponentDidNotJoinKnockOut() {
        runOnUiThread(new Runnable() {
            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$onOpponentDidNotJoinKnockOut$0$MPLSFS2XConnectorActivity();
            }
        });
    }

    private void onUserJoinKOMatch(BaseEvent baseEvent) {
        runOnUiThread(new Runnable(baseEvent) {
            public final /* synthetic */ BaseEvent f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$onUserJoinKOMatch$1$MPLSFS2XConnectorActivity(this.f$1);
            }
        });
    }

    private void onUserJoinMatch(BaseEvent baseEvent) {
        MLogger.d(TAG, "onUserJoinMatch: ");
        SFSObject sFSObject = (SFSObject) baseEvent.getArguments().get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (sFSObject != null) {
            SFSArray sFSArray = (SFSArray) sFSObject.get("currentUsers").getObject();
            for (int i = 0; i < sFSArray.size(); i++) {
                addPlayer((SFSObject) sFSArray.get(i).getObject());
            }
            startMatchingTimer(((Integer) sFSObject.get("timeLeft").getObject()).intValue());
        }
    }

    private void onUserLeaveMatch(BaseEvent baseEvent) {
        MLogger.d(TAG, "onUserLeaveMatch: ");
        SFSObject sFSObject = (SFSObject) baseEvent.getArguments().get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (sFSObject != null) {
            SFSArray sFSArray = (SFSArray) sFSObject.get("currentUsers").getObject();
            for (int i = 0; i < sFSArray.size(); i++) {
                removePlayer((SFSObject) sFSArray.get(i).getObject());
            }
        }
    }

    /* access modifiers changed from: private */
    public void pingServer() {
        this.sfsClient.send(new ExtensionRequest("PING", SFSObject.newInstance()));
    }

    private void prePareRewards() {
        GameConfig gameConfig = this.mGameConfig;
        if (gameConfig != null && gameConfig.getDynamicRewards() != null) {
            this.mRewardsMap = new HashMap<>();
            for (int i = 0; i < this.mGameConfig.getDynamicRewards().size(); i++) {
                DynamicReward dynamicReward = this.mGameConfig.getDynamicRewards().get(i);
                this.mRewardsMap.put(dynamicReward.getPlayerCount(), dynamicReward.getRankWiseWinning());
            }
        }
    }

    private void resetOpponentData() {
    }

    private void setStatus(Status status, String... strArr) {
        String str;
        if (status != this.currentStatus) {
            int i = 0;
            MLogger.d(TAG, "New status= " + status);
            this.currentStatus = status;
            switch (status.ordinal()) {
                case 0:
                    str = getString(R.string.disconnected);
                    i = COLOR_GRAY;
                    break;
                case 1:
                    str = getString(R.string.connected) + ": " + strArr[0];
                    i = COLOR_GREEN;
                    break;
                case 2:
                    str = getString(R.string.connecting);
                    i = COLOR_BLUE;
                    break;
                case 3:
                    str = getString(R.string.connection_error);
                    i = COLOR_RED;
                    break;
                case 4:
                    str = getString(R.string.connection_lost);
                    i = COLOR_ORANGE;
                    break;
                case 5:
                    str = getString(R.string.logged_into) + "'" + strArr[0];
                    i = COLOR_GREEN;
                    break;
                case 6:
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(R.string.joined_to_room));
                    str = GeneratedOutlineSupport.outline62(sb, strArr[0], "'");
                    i = COLOR_GREEN;
                    break;
                case 8:
                    str = getString(R.string.crypto_error);
                    i = COLOR_RED;
                    break;
                default:
                    str = "DEFAULT";
                    break;
            }
            setStatusMessage(str, i);
            log(str);
        }
    }

    private void setStatusMessage(String str, int i) {
        MLogger.d(TAG, "setStatusMessage: ", str);
    }

    /* access modifiers changed from: private */
    /* renamed from: showErrorDialog */
    public void lambda$CallConnectionLost$8$MPLSFS2XConnectorActivity() {
        try {
            if (this.mOverLayAlertDialog == null || !this.mOverLayAlertDialog.isShowing()) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
                if (this.mOverLayAlertDialog == null && layoutInflater != null) {
                    View inflate = layoutInflater.inflate(R.layout.network_failed_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                    Builder builder = new Builder(this);
                    Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                    Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                    TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                    textView.setTypeface(createFromAsset);
                    textView.setText(R.string.connection_lost_titlle);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                    textView2.setTypeface(createFromAsset2);
                    textView2.setText(R.string.connection_lost_msg);
                    Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                    button.setTypeface(createFromAsset);
                    button.setText("GO TO BATTLE ROOM");
                    button.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            MPLSFS2XConnectorActivity.this.lambda$showErrorDialog$7$MPLSFS2XConnectorActivity(view);
                        }
                    });
                    builder.setView(inflate);
                    builder.setCancelable(false);
                    this.mOverLayAlertDialog = builder.create();
                }
                if (!isFinishing() && this.mOverLayAlertDialog != null && !this.mOverLayAlertDialog.isShowing()) {
                    this.mOverLayAlertDialog.show();
                    return;
                }
                return;
            }
            MLogger.d(TAG, "showOverlayDialog: Already showing Dialog");
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    private void showFindMatchFailedScreen() {
        MLogger.d(TAG, "showFindMatchFailedScreen: ");
        runOnUiThread(new Runnable() {
            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$showFindMatchFailedScreen$3$MPLSFS2XConnectorActivity();
            }
        });
    }

    private void showFindMatchSuccessScreen() {
        MLogger.d(TAG, "showFindMatchSuccessScreen: ");
        runOnUiThread(new Runnable() {
            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$showFindMatchSuccessScreen$4$MPLSFS2XConnectorActivity();
            }
        });
    }

    private void showOverlayDialog(String str, String str2, String str3, String str4) {
        try {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            if (layoutInflater != null) {
                View inflate = layoutInflater.inflate(R.layout.ok_cancel_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                Builder builder = new Builder(this);
                Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                textView.setTypeface(createFromAsset);
                textView.setText(str);
                TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                textView2.setTypeface(createFromAsset2);
                textView2.setText(str2);
                Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel);
                button.setTypeface(createFromAsset);
                button2.setTypeface(createFromAsset);
                button.setText(str3);
                button2.setText(str4);
                builder.setView(inflate);
                builder.setCancelable(false);
                AlertDialog create = builder.create();
                button.setOnClickListener(new OnClickListener(create) {
                    public final /* synthetic */ AlertDialog f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        MPLSFS2XConnectorActivity.this.lambda$showOverlayDialog$12$MPLSFS2XConnectorActivity(this.f$1, view);
                    }
                });
                button2.setOnClickListener(new OnClickListener(create) {
                    public final /* synthetic */ AlertDialog f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(View view) {
                        MPLSFS2XConnectorActivity.lambda$showOverlayDialog$13(this.f$0, view);
                    }
                });
                if (!isFinishing() && create != null && !create.isShowing()) {
                    create.show();
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    public void BattleFinished() {
        if (this.battleFinished) {
            MLogger.d(TAG, "MPL: SFS2X battle already finished, can't finish again");
            return;
        }
        this.battleFinished = true;
    }

    public void CallConnectionLost(SmartFoxManagerReasons smartFoxManagerReasons) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("connectionLostCalled = ");
        outline73.append(this.connectionLostCalled);
        MLogger.d(TAG, outline73.toString());
        if (!this.connectionLostCalled) {
            this.connectionLostCalled = true;
            runOnUiThread(new Runnable() {
                public final void run() {
                    MPLSFS2XConnectorActivity.this.lambda$CallConnectionLost$8$MPLSFS2XConnectorActivity();
                }
            });
        }
    }

    public void FindRoom() {
        MLogger.d(TAG, "MPL: SFS2X finding room");
        if (this.sfsClient != null && this.mGameConfig != null) {
            SFSObject newInstance = SFSObject.newInstance();
            int parseDouble = (int) Double.parseDouble(String.valueOf(this.mGameConfig.getLobbyId()));
            MLogger.d(TAG, "FindRoom: ", Integer.valueOf(parseDouble));
            newInstance.putInt("lobbyId", parseDouble);
            this.sfsClient.send(new ExtensionRequest("findMatch", newInstance));
        }
    }

    public Room GetJoinedRoom() {
        return this.sfsClient.getLastJoinedRoom();
    }

    public SmartFoxManagerMonitor GetMonitorType() {
        return this.monitorType;
    }

    public void OnConnection(BaseEvent baseEvent) {
        if (((Boolean) baseEvent.getArguments().get("success")).booleanValue()) {
            MLogger.d(TAG, "MPL: SFS2X Connection established successfully");
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("MPL: SFS2X API version: ");
            outline73.append(this.sfsClient.getVersion());
            MLogger.d(TAG, outline73.toString());
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("MPL: SFS2X Connection mode is: ");
            outline732.append(this.sfsClient.getConnectionMode());
            MLogger.d(TAG, outline732.toString());
            if (baseEvent.getArguments().get("success") == null || !((Boolean) baseEvent.getArguments().get("success")).booleanValue()) {
                setStatus(Status.CONNECTION_ERROR, new String[0]);
            } else {
                this.sfsClient.initCrypto();
            }
        } else {
            MLogger.d(TAG, "MPL: SFS2X Connection failed: is the server running at all?");
        }
    }

    public void OnConnectionLost(BaseEvent baseEvent) {
        Object[] objArr = new Object[2];
        objArr[0] = "MPL: SFS2X Connection was lost; reason is: ";
        boolean containsKey = baseEvent.getArguments().containsKey("reason");
        String str = Constants.DOWNLOAD_STATUS_UNKNOWN;
        objArr[1] = containsKey ? (String) baseEvent.getArguments().get("reason") : str;
        MLogger.d(TAG, objArr);
        Status status = Status.CONNECTION_LOST;
        String[] strArr = new String[1];
        if (baseEvent.getArguments().containsKey("reason")) {
            str = (String) baseEvent.getArguments().get("reason");
        }
        strArr[0] = str;
        setStatus(status, strArr);
        CallConnectionLost(this.disconnectionReason);
        StopPinger();
        CleanUp();
    }

    public void OnEncryptionInitialized(BaseEvent baseEvent) {
        if (!baseEvent.getArguments().containsKey("success") || baseEvent.getArguments().get("success") == null || !((Boolean) baseEvent.getArguments().get("success")).booleanValue()) {
            setStatus(Status.CRYPTO_ERROR, new String[0]);
            return;
        }
        MLogger.d(TAG, "MPL: SFS2X OnEncryptionInitialized successful, loggin in");
        login(this.mCurrentProfile.getDisplayName(), "");
    }

    public void OnErrorMessage(BaseEvent baseEvent) {
        MLogger.d(TAG, (String) baseEvent.getArguments().get("message"));
    }

    public void OnInfoMessage(BaseEvent baseEvent) {
        MLogger.d(TAG, (String) baseEvent.getArguments().get("message"));
    }

    public void OnLogin(BaseEvent baseEvent) {
        User user = (User) baseEvent.getArguments().get(Action.USER);
        Object[] objArr = new Object[2];
        objArr[0] = "MPL: SFS2X login successful = ";
        objArr[1] = user != null ? user.getName() : "";
        MLogger.d(TAG, objArr);
        this.sfsClient.initUdp(this.mGameConfig.getHost(), 9933);
        scheduleTimer(((int) (this.mGameConfig.getPingInterval() != null ? this.mGameConfig.getPingInterval().doubleValue() : 5.0d)) * 1000);
    }

    public void OnRoomJoin(BaseEvent baseEvent) {
        Room room = (Room) baseEvent.getArguments().get("room");
        if (room != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("MPL: SFS2X joined room = ");
            outline73.append(room.getName());
            MLogger.d(TAG, outline73.toString());
            return;
        }
        MLogger.d(TAG, "OnRoomJoin: Room is null");
    }

    public void OnUdpInit(BaseEvent baseEvent) {
        if (!baseEvent.getArguments().containsKey("success") || !((Boolean) baseEvent.getArguments().get("success")).booleanValue()) {
            MLogger.d(TAG, "UDP init failed!");
        } else {
            MLogger.d(TAG, "UDP init successful!");
        }
        FindRoom();
    }

    public void OnUserExitRoom(BaseEvent baseEvent) {
        if (!this.battleFinished) {
            if (!baseEvent.getArguments().containsKey(Action.USER) || ((User) baseEvent.getArguments().get(Action.USER)) != this.sfsClient.getMySelf()) {
                MLogger.d(TAG, "MPL: SFS2X - User disconnected");
                UserDisconnected();
            }
        }
    }

    public void OnWarnMessage(BaseEvent baseEvent) {
        MLogger.d(TAG, (String) baseEvent.getArguments().get("message"));
    }

    public void ReadyToPlay() {
        MLogger.d(TAG, "MPL: SFS2X Telling server we're ready to play");
        this.sfsClient.send(new ExtensionRequest("onReady", SFSObject.newInstance(), GetJoinedRoom()));
    }

    public void SetMonitoringType(SmartFoxManagerMonitor smartFoxManagerMonitor) {
        MLogger.d(TAG, "MPL: SFS2X, monitoring " + smartFoxManagerMonitor);
        this.monitorType = smartFoxManagerMonitor;
    }

    public void StopPinger() {
        if (this.mPingServerTimer != null) {
            MLogger.d(TAG, "MPL: SFS2X stopping ping timer");
            this.mPingServerTimer.cancel();
        }
    }

    public void addPlayer(SFSObject sFSObject) {
        runOnUiThread(new Runnable(sFSObject) {
            public final /* synthetic */ SFSObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$addPlayer$11$MPLSFS2XConnectorActivity(this.f$1);
            }
        });
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatch(sfs2x.client.core.BaseEvent r14) {
        /*
            r13 = this;
            sfs2x.client.SmartFox r0 = r13.sfsClient
            if (r0 == 0) goto L_0x02e9
            if (r14 == 0) goto L_0x02e9
            java.lang.String r0 = r14.getType()
            if (r0 == 0) goto L_0x02e9
            java.util.Map r0 = r14.getArguments()
            if (r0 == 0) goto L_0x02e9
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Dispatching "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r14.getType()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "SFS2XConnector:"
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            java.lang.String r1 = r14.getType()
            int r4 = r1.hashCode()
            java.lang.String r5 = "userExitRoom"
            r6 = 2
            switch(r4) {
                case -1992720015: goto L_0x0098;
                case -1771688929: goto L_0x008e;
                case -775651618: goto L_0x0084;
                case -567618447: goto L_0x007a;
                case -173609819: goto L_0x006f;
                case -150346336: goto L_0x0065;
                case 70679543: goto L_0x005b;
                case 103149417: goto L_0x0051;
                case 1269963554: goto L_0x0047;
                case 1404257284: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x00a2
        L_0x003e:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00a2
            r1 = 9
            goto L_0x00a3
        L_0x0047:
            java.lang.String r4 = "connectionLost"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 5
            goto L_0x00a3
        L_0x0051:
            java.lang.String r4 = "login"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 6
            goto L_0x00a3
        L_0x005b:
            java.lang.String r4 = "handshake"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 0
            goto L_0x00a3
        L_0x0065:
            java.lang.String r4 = "extensionResponse"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 4
            goto L_0x00a3
        L_0x006f:
            java.lang.String r4 = "roomJoin"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 8
            goto L_0x00a3
        L_0x007a:
            java.lang.String r4 = "udpInit"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 3
            goto L_0x00a3
        L_0x0084:
            java.lang.String r4 = "connection"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 2
            goto L_0x00a3
        L_0x008e:
            java.lang.String r4 = "loginError"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 7
            goto L_0x00a3
        L_0x0098:
            java.lang.String r4 = "cryptoInit"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00a2
            r1 = 1
            goto L_0x00a3
        L_0x00a2:
            r1 = -1
        L_0x00a3:
            java.lang.String r4 = "dispatch: "
            switch(r1) {
                case 0: goto L_0x02d9;
                case 1: goto L_0x02c6;
                case 2: goto L_0x02b3;
                case 3: goto L_0x02a6;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00ed;
                case 6: goto L_0x00ce;
                case 7: goto L_0x00c1;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00b7;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r3] = r4
            java.lang.String r14 = r14.getType()
            r1[r0] = r14
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            goto L_0x02f5
        L_0x00b7:
            r13.OnUserExitRoom(r14)
            goto L_0x02f5
        L_0x00bc:
            r13.OnRoomJoin(r14)
            goto L_0x02f5
        L_0x00c1:
            com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r14 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.LOGGING_ERROR
            java.lang.String r0 = "Login Error"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r13.setStatus(r14, r0)
            goto L_0x02f5
        L_0x00ce:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r3] = r4
            java.lang.String r4 = "Login Success"
            r1[r0] = r4
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity$Status r1 = com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.Status.LOGGED
            java.lang.String[] r0 = new java.lang.String[r0]
            sfs2x.client.SmartFox r2 = r13.sfsClient
            java.lang.String r2 = r2.getCurrentZone()
            r0[r3] = r2
            r13.setStatus(r1, r0)
            r13.OnLogin(r14)
            goto L_0x02f5
        L_0x00ed:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r3] = r4
            java.lang.String r3 = "Connection Lost"
            r1[r0] = r3
            com.mpl.androidapp.utils.MLogger.e(r2, r1)
            r13.OnConnectionLost(r14)
            goto L_0x02f5
        L_0x00fd:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "dispatch: Inside extensionResponse Init"
            r1[r3] = r4
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            java.util.Map r1 = r14.getArguments()
            r4 = 0
            java.util.Set r7 = r1.entrySet()
            java.util.Iterator r7 = r7.iterator()
            java.lang.String r8 = ""
        L_0x0115:
            boolean r9 = r7.hasNext()
            java.lang.String r10 = "params"
            if (r9 == 0) goto L_0x0152
            java.lang.Object r9 = r7.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r11 = r9.getKey()
            if (r11 != 0) goto L_0x012a
            goto L_0x0115
        L_0x012a:
            java.lang.Object r11 = r9.getKey()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "cmd"
            boolean r11 = r11.equalsIgnoreCase(r12)
            if (r11 == 0) goto L_0x013f
            java.lang.Object r8 = r9.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0115
        L_0x013f:
            java.lang.Object r11 = r9.getKey()
            java.lang.String r11 = (java.lang.String) r11
            boolean r10 = r11.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0115
            java.lang.Object r4 = r9.getValue()
            com.smartfoxserver.v2.entities.data.SFSObject r4 = (com.smartfoxserver.v2.entities.data.SFSObject) r4
            goto L_0x0115
        L_0x0152:
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r9 = "dispatch: cmd: "
            r7[r3] = r9
            r7[r0] = r8
            com.mpl.androidapp.utils.MLogger.d(r2, r7)
            int r7 = r8.hashCode()
            switch(r7) {
                case -704396780: goto L_0x01cb;
                case -576912001: goto L_0x01c1;
                case 165840725: goto L_0x01b7;
                case 367004577: goto L_0x01ac;
                case 412917644: goto L_0x01a2;
                case 433215482: goto L_0x0197;
                case 749687880: goto L_0x018d;
                case 1404257284: goto L_0x0185;
                case 1542745953: goto L_0x017b;
                case 1690201113: goto L_0x0171;
                case 2054965524: goto L_0x0166;
                default: goto L_0x0164;
            }
        L_0x0164:
            goto L_0x01d6
        L_0x0166:
            java.lang.String r5 = "OPPONENT_FINISHED"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 5
            goto L_0x01d7
        L_0x0171:
            java.lang.String r5 = "BATTLE_FINISHED"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 3
            goto L_0x01d7
        L_0x017b:
            java.lang.String r5 = "FAILED_TO_FIND_MATCH"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 4
            goto L_0x01d7
        L_0x0185:
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 6
            goto L_0x01d7
        L_0x018d:
            java.lang.String r5 = "MATCH_FOUND"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 1
            goto L_0x01d7
        L_0x0197:
            java.lang.String r5 = "KNOCKOUT_MATCH_USER_IN"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 9
            goto L_0x01d7
        L_0x01a2:
            java.lang.String r5 = "findMatch"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 0
            goto L_0x01d7
        L_0x01ac:
            java.lang.String r5 = "OPPONENT_DID_NOT_JOIN_KNOCKOUT"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 10
            goto L_0x01d7
        L_0x01b7:
            java.lang.String r5 = "START_BATTLE"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 2
            goto L_0x01d7
        L_0x01c1:
            java.lang.String r5 = "MATCH_USER_IN"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 7
            goto L_0x01d7
        L_0x01cb:
            java.lang.String r5 = "MATCH_USER_OUT"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x01d6
            r5 = 8
            goto L_0x01d7
        L_0x01d6:
            r5 = -1
        L_0x01d7:
            switch(r5) {
                case 0: goto L_0x029c;
                case 1: goto L_0x0251;
                case 2: goto L_0x0226;
                case 3: goto L_0x01ff;
                case 4: goto L_0x01fa;
                case 5: goto L_0x01f5;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01eb;
                case 8: goto L_0x01e6;
                case 9: goto L_0x01e1;
                case 10: goto L_0x01dc;
                default: goto L_0x01da;
            }
        L_0x01da:
            goto L_0x02f5
        L_0x01dc:
            r13.onOpponentDidNotJoinKnockOut()
            goto L_0x02f5
        L_0x01e1:
            r13.onUserJoinKOMatch(r14)
            goto L_0x02f5
        L_0x01e6:
            r13.onUserLeaveMatch(r14)
            goto L_0x02f5
        L_0x01eb:
            r13.onUserJoinMatch(r14)
            goto L_0x02f5
        L_0x01f0:
            r13.OnUserExitRoom(r14)
            goto L_0x02f5
        L_0x01f5:
            r13.OpponentFinished()
            goto L_0x02f5
        L_0x01fa:
            r13.showFindMatchFailedScreen()
            goto L_0x02f5
        L_0x01ff:
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r1 = "battle finished processed"
            r14[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            java.lang.Object[] r14 = new java.lang.Object[r0]
            if (r4 == 0) goto L_0x0211
            java.util.Set r1 = r4.getKeys()
            goto L_0x0213
        L_0x0211:
            java.lang.String r1 = "Response is Null"
        L_0x0213:
            r14[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r0 = "***********************************finding new match"
            r14[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            r13.FindRoom()
            goto L_0x02f5
        L_0x0226:
            if (r4 == 0) goto L_0x0246
            java.lang.String r14 = "id"
            boolean r1 = r4.containsKey(r14)
            if (r1 == 0) goto L_0x0246
            java.lang.String r14 = r4.getUtfString(r14)
            r13.mBattleId = r14
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r4 = "start battle received with "
            r1[r3] = r4
            r1[r0] = r14
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            r13.startGame()
            goto L_0x02f5
        L_0x0246:
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r0 = "start battle received without battle id "
            r14[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            goto L_0x02f5
        L_0x0251:
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r0 = "dispatch: Match found"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            if (r4 == 0) goto L_0x0260
            java.util.Set r5 = r4.getKeys()
            goto L_0x0262
        L_0x0260:
            java.lang.String r5 = "Response Params is Null"
        L_0x0262:
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r14[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            java.util.Set r14 = r1.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x0276:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0296
            java.lang.Object r0 = r14.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r1.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0276
            java.lang.Object r0 = r0.getValue()
            r4 = r0
            com.smartfoxserver.v2.entities.data.SFSObject r4 = (com.smartfoxserver.v2.entities.data.SFSObject) r4
            goto L_0x0276
        L_0x0296:
            if (r4 == 0) goto L_0x02f5
            r13.getAllUsers(r4)
            goto L_0x02f5
        L_0x029c:
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r0 = "dispatch: find match call back came"
            r14[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r2, r14)
            goto L_0x02f5
        L_0x02a6:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "dispatch: Inside UDP Init"
            r0[r3] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r0)
            r13.OnUdpInit(r14)
            goto L_0x02f5
        L_0x02b3:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r4 = "dispatch:inside connection event "
            r1[r3] = r4
            java.lang.String r3 = r14.getType()
            r1[r0] = r3
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            r13.OnConnection(r14)
            goto L_0x02f5
        L_0x02c6:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r4 = "dispatch:inside crypto init event "
            r1[r3] = r4
            java.lang.String r3 = r14.getType()
            r1[r0] = r3
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            r13.OnEncryptionInitialized(r14)
            goto L_0x02f5
        L_0x02d9:
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r4 = "dispatch:inside handshake event "
            r1[r3] = r4
            java.lang.String r14 = r14.getType()
            r1[r0] = r14
            com.mpl.androidapp.utils.MLogger.d(r2, r1)
            goto L_0x02f5
        L_0x02e9:
            r14 = 2131952763(0x7f13047b, float:1.9541978E38)
            java.lang.String r14 = r13.getString(r14)
            int r0 = COLOR_RED
            r13.setStatusMessage(r14, r0)
        L_0x02f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity.dispatch(sfs2x.client.core.BaseEvent):void");
    }

    public List<Double> getRewards(int i) {
        HashMap<Integer, List<Double>> hashMap = this.mRewardsMap;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        return this.mRewardsMap.get(Integer.valueOf(i));
    }

    public /* synthetic */ void lambda$addPlayer$11$MPLSFS2XConnectorActivity(SFSObject sFSObject) {
        MLogger.d(TAG, "addPlayer: ");
        PlayerItem playerItem = new PlayerItem();
        playerItem.setPlayerAvatar((String) sFSObject.get("avatar").getObject());
        playerItem.setPlayerName((String) sFSObject.get("displayName").getObject());
        playerItem.setUserId(((Integer) sFSObject.get("mplUserId").getObject()).intValue());
        PlayerListAdapter playerListAdapter = this.mPlayerListAdapter;
        if (playerListAdapter != null && !playerListAdapter.containsItem(playerItem)) {
            this.mPlayerListAdapter.addPlayer(playerItem);
            this.mBinding.matchingStatus.setText(String.format("%d Match Found", new Object[]{Integer.valueOf(this.mPlayerListAdapter.getItemCount())}));
            populateRewardsViews(this.mPlayerListAdapter.getItemCount());
        }
    }

    public /* synthetic */ void lambda$getAllUsers$5$MPLSFS2XConnectorActivity(ISFSObject iSFSObject) {
        char c2;
        this.mMatchedUsersArray = new JSONArray();
        char c3 = 1;
        try {
            ISFSArray sFSArray = iSFSObject.getSFSArray("users");
            this.battleFinished = false;
            ArrayList<PlayerItem> arrayList = new ArrayList<>();
            int i = 0;
            int i2 = 1;
            while (i < sFSArray.size()) {
                SFSObject sFSObject = (SFSObject) sFSArray.get(i).getObject();
                JSONObject jSONObject = new JSONObject();
                for (String next : sFSObject.getKeys()) {
                    jSONObject.put(next, sFSObject.get(next).getObject());
                }
                Object[] objArr = new Object[3];
                objArr[0] = "getAllUsers: ";
                objArr[c3] = Integer.valueOf(jSONObject.optInt("mplUserId"));
                objArr[2] = this.mCurrentProfile.getId();
                MLogger.d(TAG, objArr);
                boolean z = jSONObject.optInt("mplUserId") != 0 && jSONObject.optInt("mplUserId") == this.mCurrentProfile.getId().intValue();
                if (z) {
                    PlayerItem playerItem = new PlayerItem(jSONObject.optString("avatar", ""), jSONObject.optString("displayName", ""), jSONObject.optInt("mplUserId"), true, true);
                    arrayList.add(0, playerItem);
                } else {
                    PlayerItem playerItem2 = new PlayerItem(jSONObject.optString("avatar", ""), jSONObject.optString("displayName", ""), jSONObject.optInt("mplUserId"), false, true);
                    arrayList.add(playerItem2);
                }
                jSONObject.remove("TokenBalance");
                jSONObject.remove("TotalBalance");
                jSONObject.remove("WithdrawableBalance");
                jSONObject.remove("DepositBalance");
                jSONObject.remove("BonusBalance");
                jSONObject.remove("mobileNumber");
                jSONObject.remove("mplUserId");
                jSONObject.remove("isPro");
                jSONObject.remove("tier");
                if (z) {
                    this.mMatchedUsersArray.put(0, jSONObject);
                } else {
                    this.mMatchedUsersArray.put(i2, jSONObject);
                    i2++;
                }
                i++;
                c3 = 1;
            }
            this.playerList = arrayList;
            if (this.isKnockoutTournament) {
                this.mBinding.battlePlayerStatusImgContainer.setVisibility(0);
                this.mBinding.battlePlayerStatusImgContainer.setBackground(ContextCompat.getDrawable(this, R.drawable.loader_path_blue));
                this.mBinding.battlePlayerStatusImg.setImageResource(R.drawable.ic_battle_24);
                this.mBinding.progressContainer.setVisibility(8);
                this.mPlayerListAdapter.updatePlayersStatus(this.playerList);
            } else {
                this.mBinding.battlePlayerStatusImgContainer.setVisibility(8);
                this.mBinding.progressContainer.setVisibility(0);
                this.mPlayerListAdapter.swapItems(this.playerList);
            }
            ReadyToPlay();
            c2 = 1;
        } catch (Exception e2) {
            c2 = 1;
            MLogger.e(TAG, "getAllUsers: ", e2);
            ReadyToPlay();
        } catch (Throwable th) {
            ReadyToPlay();
            throw th;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "getAllUsers: ";
        objArr2[c2] = this.mMatchedUsersArray;
        MLogger.d(TAG, objArr2);
    }

    public /* synthetic */ void lambda$onOpponentDidNotJoinKnockOut$0$MPLSFS2XConnectorActivity() {
        this.mBinding.playerStatus.setText(getString(R.string.opponents_did_not_join));
        this.mBinding.didNotJoinContainer.setVisibility(0);
        this.mBinding.battleDescTxt.setVisibility(8);
        this.mBinding.didNotJoinOkButton.setVisibility(0);
        this.mBinding.battlePlayerStatusImgContainer.setVisibility(0);
        this.mBinding.battlePlayerStatusImgContainer.setBackground(ContextCompat.getDrawable(this, R.drawable.loader_path_green));
        this.mBinding.battlePlayerStatusImg.setImageResource(R.drawable.ic_error_circular_filled_24);
        this.mBinding.progressContainer.setVisibility(8);
        this.mBinding.didNotJoinOkButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MPLSFS2XConnectorActivity.this.finish();
            }
        });
    }

    public /* synthetic */ void lambda$onUserJoinKOMatch$1$MPLSFS2XConnectorActivity(BaseEvent baseEvent) {
        boolean z = false;
        MLogger.d(TAG, "onUserJoinKOMatch: ", Boolean.valueOf(this.isUserPopulated));
        SFSObject sFSObject = (SFSObject) baseEvent.getArguments().get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (!this.isUserPopulated) {
            if (!(sFSObject == null || sFSObject.isNull("timeLeft") || sFSObject.get("timeLeft") == null)) {
                startMatchingTimer(((Integer) sFSObject.get("timeLeft").getObject()).intValue());
            }
            if (!(sFSObject == null || sFSObject.isNull("minPlayers") || sFSObject.get("minPlayers") == null)) {
                int intValue = ((Integer) sFSObject.get("minPlayers").getObject()).intValue();
                this.mBinding.playerStatusDesc.setVisibility(0);
                this.mBinding.playerStatusDesc.setText(String.format(getString(R.string.min_2_players_needed_to_start_match), new Object[]{Integer.valueOf(intValue)}));
            }
            if (!(sFSObject == null || sFSObject.isNull("currentUsers") || sFSObject.get("currentUsers") == null)) {
                MLogger.d(TAG, "onUserJoinKOMatch:Updating Current User ");
                ArrayList arrayList = new ArrayList();
                SFSArray sFSArray = (SFSArray) sFSObject.get("currentUsers").getObject();
                int i = 0;
                while (sFSArray != null && i < sFSArray.size()) {
                    MLogger.d(TAG, "onUserJoinKOMatch:Current Users", Integer.valueOf(sFSArray.size()));
                    PlayerItem playerItem = new PlayerItem();
                    SFSObject sFSObject2 = (SFSObject) sFSArray.get(i).getObject();
                    playerItem.setPlayerAvatar((String) sFSObject2.get("avatar").getObject());
                    playerItem.setPlayerName((String) sFSObject2.get("displayName").getObject());
                    playerItem.setUserId(((Integer) sFSObject2.get("mplUserId").getObject()).intValue());
                    playerItem.setCurrentUser(this.mCurrentProfile.getId().intValue() == ((Integer) sFSObject2.get("mplUserId").getObject()).intValue());
                    playerItem.setJoined(this.mCurrentProfile.getId().intValue() == ((Integer) sFSObject2.get("mplUserId").getObject()).intValue());
                    arrayList.add(playerItem);
                    i++;
                }
                this.mPlayerListAdapter.swapItems(arrayList);
            }
            if (!(sFSObject == null || sFSObject.isNull("joinedUsers") || sFSObject.get("joinedUsers") == null)) {
                MLogger.d(TAG, "onUserJoinKOMatch:Updating Joined Users ");
                ArrayList arrayList2 = new ArrayList();
                SFSArray sFSArray2 = (SFSArray) sFSObject.get("joinedUsers").getObject();
                int i2 = 0;
                while (sFSArray2 != null && i2 < sFSArray2.size()) {
                    MLogger.d(TAG, "onUserJoinKOMatch:Total Joined Users", Integer.valueOf(sFSArray2.size()));
                    PlayerItem playerItem2 = new PlayerItem();
                    SFSObject sFSObject3 = (SFSObject) sFSArray2.get(i2).getObject();
                    playerItem2.setPlayerAvatar((String) sFSObject3.get("avatar").getObject());
                    playerItem2.setPlayerName((String) sFSObject3.get("displayName").getObject());
                    playerItem2.setUserId(((Integer) sFSObject3.get("mplUserId").getObject()).intValue());
                    playerItem2.setCurrentUser(this.mCurrentProfile.getId().intValue() == ((Integer) sFSObject3.get("mplUserId").getObject()).intValue());
                    playerItem2.setJoined(true);
                    MLogger.d(TAG, "onUserJoinKOMatch:Joined User ", Integer.valueOf(i2), playerItem2.toString());
                    arrayList2.add(playerItem2);
                    i2++;
                }
                this.mPlayerListAdapter.updatePlayersStatus(arrayList2);
            }
            this.isUserPopulated = true;
        }
        if (sFSObject != null && !sFSObject.isNull("joinedUser") && sFSObject.get("joinedUser") != null) {
            SFSObject sFSObject4 = (SFSObject) sFSObject.get("joinedUser").getObject();
            PlayerItem playerItem3 = new PlayerItem();
            playerItem3.setPlayerAvatar((String) sFSObject4.get("avatar").getObject());
            playerItem3.setPlayerName((String) sFSObject4.get("displayName").getObject());
            playerItem3.setUserId(((Integer) sFSObject4.get("mplUserId").getObject()).intValue());
            if (this.mCurrentProfile.getId().intValue() == ((Integer) sFSObject4.get("mplUserId").getObject()).intValue()) {
                z = true;
            }
            playerItem3.setCurrentUser(z);
            playerItem3.setJoined(true);
            this.mPlayerListAdapter.updatePlayerStatus(playerItem3);
        }
    }

    public /* synthetic */ void lambda$showErrorDialog$7$MPLSFS2XConnectorActivity(View view) {
        AlertDialog alertDialog = this.mOverLayAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            finish();
        }
    }

    public /* synthetic */ void lambda$showFindMatchFailedScreen$3$MPLSFS2XConnectorActivity() {
        this.mBinding.matchFailedScreen.setVisibility(0);
        this.mBinding.matchSuccessScreen.setVisibility(8);
        this.mBinding.matchingTimer.setVisibility(8);
        stopMatchingTime();
    }

    public /* synthetic */ void lambda$showFindMatchSuccessScreen$4$MPLSFS2XConnectorActivity() {
        this.mBinding.matchingTimer.setVisibility(8);
        this.mBinding.matchFailedScreen.setVisibility(8);
        this.mBinding.matchSuccessScreen.setVisibility(0);
    }

    public /* synthetic */ void lambda$showOverlayDialog$12$MPLSFS2XConnectorActivity(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
            finish();
        }
    }

    public /* synthetic */ void lambda$startGame$10$MPLSFS2XConnectorActivity() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$startGame$9$MPLSFS2XConnectorActivity();
            }
        }, 500);
    }

    public /* synthetic */ void lambda$startGame$9$MPLSFS2XConnectorActivity() {
        try {
            this.mBinding.matchingStatus.setText(getString(R.string.starting_match));
            Intent intent = new Intent();
            intent.setClassName(this.redirectPackage, this.redirectActivity);
            if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean("game.thirdparty.new.launch", false)) {
                intent.addFlags(this.thirdPartyGameIntentFlags);
            } else {
                intent.addFlags(this.thirdPartyGameIntentFlagsNew);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SMTEventParamKeys.SMT_EVENT_ID, this.mBattleId);
            jSONObject.put("isMpl", true);
            jSONObject.put("packageName", MBuildConfigUtils.getApplicationId());
            jSONObject.put("eventType", "battle");
            jSONObject.put("lobbyId", this.mGameConfig.getLobbyId());
            jSONObject.put("fee", this.mGameConfig.getEntryFee());
            jSONObject.put("oAuthToken", this.mGameConfig.getAuthToken());
            jSONObject.put("users", this.mMatchedUsersArray);
            if (!TextUtils.isEmpty(this.mGameConfig.getThirdPartyExtra())) {
                JSONObject jSONObject2 = new JSONObject(this.mGameConfig.getThirdPartyExtra());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            intent.putExtra("playersData", jSONObject.toString());
            startActivityForResult(intent, REQUEST_SUBMIT_SCORE);
        } catch (Exception e2) {
            MLogger.e(TAG, "startGame: ", e2);
        }
    }

    public /* synthetic */ void lambda$startMatchingTimer$6$MPLSFS2XConnectorActivity() {
        if (this.isKnockoutTournament) {
            this.mBinding.matchingTimer.setVisibility(8);
            this.mBinding.battleTimeProgresstxt.setVisibility(0);
            return;
        }
        this.mBinding.matchingTimer.setVisibility(0);
        this.mBinding.battleTimeProgresstxt.setVisibility(8);
    }

    public void login(String str, String str2) {
        MLogger.d(TAG, "MPL: SFS2X Logging in");
        SFSObject newInstance = SFSObject.newInstance();
        newInstance.putUtfString("authToken", this.mGameConfig.getAuthToken());
        newInstance.putUtfString("displayName", this.mCurrentProfile.getDisplayName());
        newInstance.putUtfString("mobileNumber", this.mGameConfig.getMobileNumber());
        newInstance.putUtfString("avatar", this.mCurrentProfile.getAvatar());
        newInstance.putUtfString("tier", this.mCurrentProfile.getTier());
        newInstance.putBool("isPro", this.mCurrentProfile.getPro().booleanValue());
        newInstance.putBool("isInDebugMode", false);
        newInstance.putInt(SMTEventParamKeys.SMT_APP_VERSION, Integer.parseInt(this.mGameConfig.getAppVersionCode()));
        newInstance.putInt(GameConstant.INSTALLED_APK_VERSION_CODE, this.mGameConfig.getInstalledApkVersionCode());
        newInstance.putUtfString("serverConnectionParams", "");
        this.sfsClient.send(new LoginRequest(UUID.randomUUID().toString(), str2, this.mGameConfig.getZone(), newInstance));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setRequestedOrientation(1);
        finish();
    }

    public void onBackPressed() {
        showCloseDialog();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.battle_try_again /*2131361924*/:
                initUI();
                FindRoom();
                return;
            case R.id.close_btn /*2131362095*/:
            case R.id.koClose /*2131362692*/:
            case R.id.webview_back /*2131363668*/:
                showCloseDialog();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        ActivityMplSmfxConnectorBinding inflate = ActivityMplSmfxConnectorBinding.inflate(LayoutInflater.from(this));
        this.mBinding = inflate;
        setContentView(inflate.getRoot());
        if (getIntent() == null || !getIntent().hasExtra("json_extra")) {
            setStatusMessage(getString(R.string.game_data_corrupted), COLOR_RED);
        } else {
            String stringExtra = getIntent().getStringExtra("json_extra");
            if (getIntent().hasExtra("redirectPackage")) {
                this.redirectPackage = getIntent().getStringExtra("redirectPackage");
            }
            if (getIntent().hasExtra("redirectActivity")) {
                this.redirectActivity = getIntent().getStringExtra("redirectActivity");
            }
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                setStatusMessage(getString(R.string.game_data_corrupted), COLOR_RED);
            } else {
                try {
                    GameConfig gameConfig = (GameConfig) new Gson().fromJson(stringExtra, GameConfig.class);
                    this.mGameConfig = gameConfig;
                    if (gameConfig.getKnockoutLobby() != null) {
                        this.isKnockoutTournament = this.mGameConfig.getKnockoutLobby().booleanValue();
                    }
                    this.mLayoutInflater = LayoutInflater.from(this);
                    if (this.mGameConfig != null) {
                        this.mCurrentProfile = this.mGameConfig.getProfile();
                        if (TextUtils.isEmpty(this.redirectPackage)) {
                            this.redirectPackage = Util.getPackageNameBasedOnGameId(Integer.parseInt(String.valueOf(this.mGameConfig.getGameId())));
                        }
                        if (TextUtils.isEmpty(this.redirectActivity)) {
                            this.redirectActivity = Util.getMainActivityNameBasedOnGameId(Integer.parseInt(String.valueOf(this.mGameConfig.getGameId())));
                        }
                        initUI();
                        initSmartFox();
                    } else {
                        MLogger.e(TAG, "onCreate: ", "Config Server is null");
                        setStatusMessage("Config Server is null", COLOR_RED);
                        lambda$CallConnectionLost$8$MPLSFS2XConnectorActivity();
                    }
                } catch (Exception e2) {
                    MLogger.e(TAG, "onCreate: ", e2);
                    setStatusMessage(e2.getMessage(), COLOR_RED);
                }
            }
        }
        this.mBinding.closeBtn.setOnClickListener(this);
        this.mBinding.battleTryAgain.setOnClickListener(this);
        this.mBinding.webviewBack.setOnClickListener(this);
        this.mBinding.koClose.setOnClickListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
        disconnect();
        MLogger.d(TAG, "Removing Listeners");
        SmartFox smartFox = this.sfsClient;
        if (smartFox != null) {
            smartFox.removeAllEventListeners();
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        MLogger.d(TAG, "onPause: ");
    }

    public void onResume() {
        super.onResume();
        Object[] objArr = new Object[2];
        objArr[0] = "onResume: ";
        SmartFox smartFox = this.sfsClient;
        objArr[1] = smartFox != null ? Boolean.valueOf(smartFox.isConnecting()) : "Not connecting";
        MLogger.d(TAG, objArr);
    }

    public void onStart() {
        super.onStart();
        Object[] objArr = new Object[2];
        objArr[0] = "onStart: ";
        SmartFox smartFox = this.sfsClient;
        objArr[1] = smartFox != null ? Boolean.valueOf(smartFox.isConnecting()) : "Not connecting";
        MLogger.d(TAG, objArr);
    }

    public void populateRewardsViews(int i) {
        List<Double> rewards = getRewards(i);
        Object[] objArr = new Object[2];
        objArr[0] = "populateRewardsViews: ";
        objArr[1] = Integer.valueOf(rewards != null ? rewards.size() : 0);
        MLogger.d(TAG, objArr);
        if (this.mBinding.prizeBreakUpList != null && rewards != null && rewards.size() > 0) {
            this.mBinding.prizeBreakUpList.setLayoutManager(new GridLayoutManager(this, 3));
            this.mBinding.firstRankPositionText.setText(String.format(getString(R.string.rank_position), new Object[]{String.valueOf(1)}));
            this.mBinding.firstRankAmountText.setText(String.format("%s", new Object[]{rewards.get(0)}));
            rewards.remove(0);
            this.mBinding.prizeBreakUpList.setAdapter(new PrizeBreakUpListAdapter(this, rewards));
            this.mBinding.prizeBreakUpList.setVisibility(rewards.size() > 0 ? 0 : 8);
            this.mBinding.firstRankContainer.setVisibility(0);
        }
    }

    public void removePlayer(SFSObject sFSObject) {
        MLogger.d(TAG, "removePlayer: ");
        PlayerItem playerItem = new PlayerItem();
        playerItem.setPlayerAvatar((String) sFSObject.get("avatar").getObject());
        playerItem.setPlayerName((String) sFSObject.get("displayName").getObject());
        playerItem.setUserId(((Integer) sFSObject.get("mplUserId").getObject()).intValue());
        PlayerListAdapter playerListAdapter = this.mPlayerListAdapter;
        if (playerListAdapter != null) {
            playerListAdapter.removePlayer(playerItem);
            this.mBinding.matchingStatus.setText(String.format("%d Match Found", new Object[]{Integer.valueOf(this.mPlayerListAdapter.getItemCount())}));
            populateRewardsViews(this.mPlayerListAdapter.getItemCount());
        }
    }

    public void resetTimer() {
        Timer timer = this.mPingServerTimer;
        if (timer != null) {
            timer.cancel();
            this.mPingServerTimer = null;
        }
        TimerTask timerTask = this.mPingServerTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mPingServerTimerTask = null;
        }
    }

    public void scheduleTimer(int i) {
        if (this.mPingServerTimer == null) {
            this.mPingServerTimer = new Timer();
        }
        if (this.mPingServerTimerTask == null) {
            AnonymousClass1 r2 = new TimerTask() {
                public void run() {
                    MPLSFS2XConnectorActivity.this.pingServer();
                }
            };
            this.mPingServerTimerTask = r2;
            this.mPingServerTimer.scheduleAtFixedRate(r2, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, (long) i);
        }
    }

    public void showCloseDialog() {
        showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
    }

    public void startGame() {
        runOnUiThread(new Runnable() {
            public final void run() {
                MPLSFS2XConnectorActivity.this.lambda$startGame$10$MPLSFS2XConnectorActivity();
            }
        });
    }

    public void startMatchingTimer(int i) {
        final int[] iArr = {i};
        if (this.mMatchingTimer == null) {
            this.mMatchingTimer = new Timer();
        }
        if (this.mMatchingTimerTask == null) {
            this.mMatchingTimerTask = new TimerTask() {
                public /* synthetic */ void lambda$run$0$MPLSFS2XConnectorActivity$3(int[] iArr) {
                    if (iArr[0] > 0) {
                        iArr[0] = iArr[0] - 1;
                        MPLSFS2XConnectorActivity mPLSFS2XConnectorActivity = MPLSFS2XConnectorActivity.this;
                        if (mPLSFS2XConnectorActivity.isKnockoutTournament) {
                            TextView textView = mPLSFS2XConnectorActivity.mBinding.battleTimeProgresstxt;
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
                            outline73.append(iArr[0]);
                            textView.setText(outline73.toString());
                            return;
                        }
                        TextView textView2 = mPLSFS2XConnectorActivity.mBinding.matchingTimer;
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("( ");
                        outline732.append(iArr[0]);
                        outline732.append(" s)");
                        textView2.setText(outline732.toString());
                    }
                }

                public void run() {
                    MPLSFS2XConnectorActivity.this.runOnUiThread(new Runnable(iArr) {
                        public final /* synthetic */ int[] f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AnonymousClass3.this.lambda$run$0$MPLSFS2XConnectorActivity$3(this.f$1);
                        }
                    });
                }
            };
            runOnUiThread(new Runnable() {
                public final void run() {
                    MPLSFS2XConnectorActivity.this.lambda$startMatchingTimer$6$MPLSFS2XConnectorActivity();
                }
            });
            this.mMatchingTimer.scheduleAtFixedRate(this.mMatchingTimerTask, 0, 1000);
        }
    }

    public void stopMatchingTime() {
        Timer timer = this.mMatchingTimer;
        if (timer != null) {
            timer.cancel();
            this.mMatchingTimer = null;
        }
        TimerTask timerTask = this.mMatchingTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mMatchingTimerTask = null;
        }
    }
}
