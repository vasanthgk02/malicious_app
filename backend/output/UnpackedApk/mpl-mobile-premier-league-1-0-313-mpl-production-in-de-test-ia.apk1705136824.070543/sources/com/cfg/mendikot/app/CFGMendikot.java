package com.cfg.mendikot.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.c.k;
import com.cfg.mendikot.game.AndroidLauncher;
import com.cfg.mendikot.lobby.model.CashLobbyModel;
import com.cfg.utilities.Handle;
import com.paynimo.android.payment.util.Constant;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class CFGMendikot {
    public static final String TAG = "CFGMendikot";
    public SDKConfig mConfig;
    public Context mContext;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2341a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.cfg.mendikot.app.SDKMode[] r0 = com.cfg.mendikot.app.SDKMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2341a = r0
                com.cfg.mendikot.app.SDKMode r1 = com.cfg.mendikot.app.SDKMode.STAGE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f2341a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.cfg.mendikot.app.SDKMode r2 = com.cfg.mendikot.app.SDKMode.PROD     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2341a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cfg.mendikot.app.SDKMode r2 = com.cfg.mendikot.app.SDKMode.LOCAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.app.CFGMendikot.a.<clinit>():void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final CFGMendikot f2342a = new CFGMendikot();
    }

    public static CFGMendikot get() {
        return b.f2342a;
    }

    private void initFileHandle(Handle handle) {
        if (k.b((Object) handle)) {
            throw new CFGMendiSDKException((String) "Invalid File Handle!");
        }
    }

    private void initMode(SDKMode sDKMode) {
        Editor editor;
        String str;
        if (!k.b((Object) sDKMode)) {
            int i = a.f2341a[sDKMode.ordinal()];
            if (i == 1) {
                editor = com.cfg.mendikot.c.c.b.f2363a.f2362c;
                str = "STAGE";
            } else if (i != 2) {
                if (i == 3) {
                    editor = com.cfg.mendikot.c.c.b.f2363a.f2362c;
                    str = "LOCAL";
                }
                com.cfg.mendikot.c.c.b.f2363a.a();
                com.cfg.mendikot.api.a.a(sDKMode);
                return;
            } else {
                editor = com.cfg.mendikot.c.c.b.f2363a.f2362c;
                str = Constant.NSDL_ENV;
            }
            editor.putString("PREF_KEY_MODE", str);
            com.cfg.mendikot.c.c.b.f2363a.a();
            com.cfg.mendikot.api.a.a(sDKMode);
            return;
        }
        throw new CFGMendiSDKException((String) "Invalid Environment Mode!");
    }

    private void initToken(String str) {
        if (!k.a2(str)) {
            com.cfg.mendikot.c.c.b.f2363a.f2362c.putString("PREF_KEY_EXTERNAL_TOKEN", str);
            com.cfg.mendikot.c.c.b.f2363a.a();
            return;
        }
        throw new CFGMendiSDKException((String) "Empty User Auth Token!");
    }

    private boolean invalidate() {
        return validateContext() && validateMode() && validateToken() && validateFileHandle();
    }

    private Boolean isActivityRunning(Class cls) {
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(Integer.MAX_VALUE)) {
            if (cls.getCanonicalName().equalsIgnoreCase(runningTaskInfo.baseActivity.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private void kill() {
        try {
            a.a();
            throw null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void openGame(CashLobbyModel cashLobbyModel, String str) {
        if (this.mConfig != null) {
            try {
                "startGameActivitySingle, lobby: " + cashLobbyModel;
                Intent intent = new Intent(this.mContext, AndroidLauncher.class);
                intent.putExtra("ACTIVITY_EXTRA_GAME_ID", str);
                intent.putExtra("ACTIVITY_EXTRA_LOBBY_NAME", cashLobbyModel.getRoomName());
                intent.putExtra("ACTIVITY_EXTRA_ENTRY_FEE", cashLobbyModel.getFee());
                intent.putExtra("ACTIVITY_EXTRA_MAX_PLAYERS", cashLobbyModel.getMaxPlayers());
                intent.putExtra("ACTIVITY_EXTRA_WINNERS", cashLobbyModel.getWinners());
                intent.putExtra("ACTIVITY_EXTRA_ROUNDS", cashLobbyModel.getRounds());
                intent.putExtra("ACTIVITY_EXTRA_TURN_TIME", cashLobbyModel.getTurnTime());
                intent.putExtra("ACTIVITY_EXTRA_PRIZE_POOL", cashLobbyModel.getPrize());
                intent.putExtra("ACTIVITY_EXTRA_RAKE", cashLobbyModel.getRake());
                intent.putExtra("ACTIVITY_EXTRA_SPEED", cashLobbyModel.getSpeed());
                double d2 = 0.0d;
                double d3 = -1.0d;
                if (cashLobbyModel.getPrizeBreakdown().length == 2) {
                    d2 = cashLobbyModel.getPrizeBreakdown()[0];
                    d3 = cashLobbyModel.getPrizeBreakdown()[1];
                } else if (cashLobbyModel.getPrizeBreakdown().length == 1) {
                    d2 = cashLobbyModel.getPrizeBreakdown()[0];
                }
                intent.putExtra("ACTIVITY_EXTRA_PRIZE_1", d2);
                intent.putExtra("ACTIVITY_EXTRA_PRIZE_2", d3);
                intent.putExtra("openTableMode", "openTableModeSingle");
                intent.addFlags(276824064);
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            throw new CFGMendiSDKException((String) "SDK not initialized!");
        }
    }

    private boolean validateContext() {
        if (!k.b((Object) this.mConfig.getContext())) {
            this.mContext = this.mConfig.getContext();
            return true;
        } else if (this.mConfig.getSDKListener() != null) {
            this.mConfig.getSDKListener().onEvent(SDKEvent.INVALID_APPLICATION_CONTEXT, null);
            return false;
        } else {
            throw new CFGMendiSDKException((String) "Invalid Application Context!");
        }
    }

    private boolean validateFileHandle() {
        if (!k.b((Object) this.mConfig.getFileHandle())) {
            initFileHandle(this.mConfig.getFileHandle());
            return true;
        } else if (this.mConfig.getSDKListener() != null) {
            this.mConfig.getSDKListener().onEvent(SDKEvent.INVALID_FILE_HANDLE, null);
            return false;
        } else {
            throw new CFGMendiSDKException((String) "Invalid File Handle!");
        }
    }

    private boolean validateMode() {
        if (!k.b((Object) this.mConfig.getMode())) {
            initMode(this.mConfig.getMode());
            return true;
        } else if (this.mConfig.getSDKListener() != null) {
            this.mConfig.getSDKListener().onEvent(SDKEvent.INVALID_MODE, null);
            return false;
        } else {
            throw new CFGMendiSDKException((String) "Invalid Environment Mode!");
        }
    }

    private boolean validateToken() {
        if (!k.a2(this.mConfig.getExternalAuthToken())) {
            initToken(this.mConfig.getExternalAuthToken());
            return true;
        } else if (this.mConfig.getSDKListener() != null) {
            this.mConfig.getSDKListener().onEvent(SDKEvent.INVALID_TOKEN, null);
            return false;
        } else {
            throw new CFGMendiSDKException((String) "Empty User Auth Token!");
        }
    }

    public void closeGame() {
        try {
            this.mContext.sendBroadcast(new Intent("finish"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Context getAppContext() {
        return this.mContext;
    }

    public SDKConfig getSDKConfig() {
        return this.mConfig;
    }

    public boolean init(SDKConfig sDKConfig) {
        this.mConfig = sDKConfig;
        return invalidate();
    }

    public void openGame(String str) {
        if (this.mConfig != null) {
            try {
                Intent intent = new Intent(this.mContext, AndroidLauncher.class);
                intent.putExtra("ACTIVITY_EXTRA_GAME_ID", str);
                intent.putExtra("openTableMode", "openTableModeSingle");
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            throw new CFGMendiSDKException((String) "SDK not initialized!");
        }
    }
}
