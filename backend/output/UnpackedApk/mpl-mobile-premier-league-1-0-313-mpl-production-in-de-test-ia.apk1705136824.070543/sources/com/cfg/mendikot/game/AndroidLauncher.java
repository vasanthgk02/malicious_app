package com.cfg.mendikot.game;

import a.a.j.f;
import a.a.k.d;
import a.a.l.e;
import a.a.l.i;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.cfg.mendikot.api.SocketManager;
import com.cfg.mendikot.app.SDKConfig;
import com.cfg.mendikot.app.SDKEvent;
import com.cfg.mendikot.lobby.model.CashLobbyModel;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class AndroidLauncher extends AndroidApplication implements a.a.l.b, e {
    public static Activity j;

    /* renamed from: a  reason: collision with root package name */
    public final String f2364a = AndroidLauncher.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public boolean f2365b = false;

    /* renamed from: c  reason: collision with root package name */
    public SDKConfig f2366c;

    /* renamed from: d  reason: collision with root package name */
    public com.cfg.mendikot.b f2367d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, i> f2368e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, e> f2369f = new ConcurrentHashMap<>();
    public SocketManager g;
    public ServiceConnection h = new a();
    public BroadcastReceiver i = new b();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                String str = AndroidLauncher.this.f2364a;
                AndroidLauncher.this.g = ((com.cfg.mendikot.api.SocketManager.a) iBinder).f2245a;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AndroidLauncher androidLauncher = AndroidLauncher.this;
            String str = androidLauncher.f2364a;
            androidLauncher.g = null;
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            String str = AndroidLauncher.this.f2364a;
            "mGameBroadcastReceiver: " + this;
            if (intent.getAction().equals("finish")) {
                AndroidLauncher.this.finishAndRemoveTask();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            AndroidLauncher.b(AndroidLauncher.this);
        }
    }

    public static void b(AndroidLauncher androidLauncher) {
        if (androidLauncher != null) {
            try {
                androidLauncher.getWindow().getDecorView().setSystemUiVisibility(5894);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            throw null;
        }
    }

    public void a() {
        try {
            for (com.cfg.mendikot.api.b a2 : this.g.f2243a.values()) {
                a2.a();
            }
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_RESUMED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, char c2) {
        try {
            this.f2369f.get(str).a(str, c2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, a.a.d.a aVar, String str2, String str3, int i2, HashSet<Character> hashSet, int i3, boolean z) {
        try {
            String str4 = str;
            this.f2369f.get(str).a(str, aVar, str2, str3, i2, hashSet, i3, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, i iVar, String str2, boolean z, String[] strArr, int i2, char c2, ConcurrentHashMap<String, d> concurrentHashMap, ConcurrentHashMap<String, d> concurrentHashMap2, ConcurrentHashMap<String, String> concurrentHashMap3, char c3, ConcurrentHashMap<String, a.a.d.a> concurrentHashMap4, int i3, String str3, String str4, String str5, int i4, int i5, HashSet<Character> hashSet, String str6, ArrayList<a.a.d.a> arrayList, int i6) {
        try {
            this.f2369f.get(str).a(str, iVar, str2, z, strArr, i2, c2, concurrentHashMap, concurrentHashMap2, concurrentHashMap3, c3, concurrentHashMap4, i3, str3, str4, str5, i4, i5, hashSet, str6, arrayList, i6);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, int i2, HashSet<Character> hashSet, int i3) {
        try {
            this.f2369f.get(str).a(str, str2, i2, hashSet, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, int i2, char[] cArr) {
        try {
            this.f2369f.get(str).a(str, str2, i2, cArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, ArrayList<a.a.d.a> arrayList, String str2, ConcurrentHashMap<String, d> concurrentHashMap, String[] strArr, int i2, int i3) {
        try {
            String str3 = str;
            this.f2369f.get(str).a(str, arrayList, str2, concurrentHashMap, strArr, i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, a.a.j.b> hashMap) {
        try {
            this.f2369f.get(str).a(str, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, HashSet<Character> hashSet, ArrayList<a.a.d.a> arrayList, ConcurrentHashMap<String, a.a.d.a> concurrentHashMap) {
        try {
            this.f2369f.get(str).a(str, hashSet, arrayList, concurrentHashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, f>[] hashMapArr) {
        try {
            this.f2369f.get(str).a(str, hashMapArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, f>[] hashMapArr, ConcurrentHashMap<String, String> concurrentHashMap, boolean z) {
        try {
            this.f2369f.get(str).a(str, hashMapArr, concurrentHashMap, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_DISPOSED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, String str2) {
        try {
            this.f2369f.get(str).b(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, String str2, String str3, int i2) {
        try {
            this.f2369f.get(str).b(str, str2, str3, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        try {
            this.f2369f.get(str).c(str);
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_CONNECTION_LOST, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, String str2) {
        try {
            this.f2369f.get(str).c(str, str2);
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_FATAL, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, String str2, String str3, int i2) {
        try {
            this.f2369f.get(str).c(str, str2, str3, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(String str) {
        try {
            this.f2369f.get(str).d(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str) {
        try {
            this.f2369f.get(str).e(str);
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_RECONNECTION_STARTED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        try {
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_PAUSED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(String str) {
        try {
            this.f2369f.get(str).f(str);
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_RECONNECTED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g() {
        double d2;
        double d3;
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("openTableMode");
            if (stringExtra.contentEquals("openTableModeSingle")) {
                i iVar = new i();
                iVar.f2678a = intent.getStringExtra("ACTIVITY_EXTRA_GAME_ID");
                iVar.f2680c = intent.getStringExtra("ACTIVITY_EXTRA_LOBBY_NAME");
                iVar.f2681d = intent.getIntExtra("ACTIVITY_EXTRA_ENTRY_FEE", 0);
                iVar.f2682e = intent.getIntExtra("ACTIVITY_EXTRA_MAX_PLAYERS", 4);
                iVar.f2683f = intent.getIntExtra("ACTIVITY_EXTRA_WINNERS", 2);
                iVar.g = intent.getIntExtra("ACTIVITY_EXTRA_ROUNDS", 2);
                iVar.l = intent.getIntExtra("ACTIVITY_EXTRA_TURN_TIME", 15);
                iVar.i = intent.getIntExtra("ACTIVITY_EXTRA_PRIZE_POOL", 0);
                iVar.m = intent.getDoubleExtra("ACTIVITY_EXTRA_RAKE", 0.0d);
                iVar.k = intent.getStringExtra("ACTIVITY_EXTRA_SPEED");
                iVar.n = intent.getDoubleExtra("ACTIVITY_EXTRA_PRIZE_1", 0.0d);
                iVar.o = intent.getDoubleExtra("ACTIVITY_EXTRA_PRIZE_2", -1.0d);
                iVar.p = this.f2365b;
                a(iVar);
            } else if (stringExtra.contentEquals("openTableModeMulti")) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("intentCashLobbyList");
                for (int i2 = 0; i2 < parcelableArrayListExtra.size(); i2++) {
                    i iVar2 = new i();
                    CashLobbyModel cashLobbyModel = (CashLobbyModel) parcelableArrayListExtra.get(i2);
                    iVar2.f2678a = cashLobbyModel.getGameID();
                    iVar2.f2680c = cashLobbyModel.getRoomName();
                    iVar2.f2681d = cashLobbyModel.getFee();
                    iVar2.f2682e = cashLobbyModel.getMaxPlayers();
                    iVar2.f2683f = cashLobbyModel.getWinners();
                    iVar2.g = cashLobbyModel.getRounds();
                    iVar2.l = cashLobbyModel.getTurnTime();
                    iVar2.i = cashLobbyModel.getPrize();
                    iVar2.m = cashLobbyModel.getRake();
                    iVar2.k = cashLobbyModel.getSpeed();
                    if (cashLobbyModel.getPrizeBreakdown().length == 2) {
                        d2 = cashLobbyModel.getPrizeBreakdown()[0];
                        d3 = cashLobbyModel.getPrizeBreakdown()[1];
                    } else if (cashLobbyModel.getPrizeBreakdown().length == 1) {
                        d2 = cashLobbyModel.getPrizeBreakdown()[0];
                        d3 = -1.0d;
                    } else {
                        d3 = -1.0d;
                        d2 = 0.0d;
                    }
                    iVar2.n = d2;
                    iVar2.o = d3;
                    iVar2.p = this.f2365b;
                    a(iVar2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void j() {
        startService(new Intent(this, SocketManager.class));
        if (this.g == null) {
            bindService(new Intent(this, SocketManager.class), this.h, 1);
        }
        registerReceiver(this.i, new IntentFilter("finish"));
    }

    public void onBackPressed() {
        try {
            if (this.f2366c.getSDKListener() != null) {
                this.f2366c.getSDKListener().onEvent(SDKEvent.BACK_PRESSED, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1682786801, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 917394034, new Object[0]);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 1157194212, new Object[0]);
    }

    public final void a(i iVar) {
        iVar.f2679b = com.cfg.mendikot.c.c.b.f2363a.f2361b.getString("PREF_KEY_USER_ID", "");
        this.f2368e.put(iVar.f2678a, iVar);
        if (this.f2369f.get(iVar.f2678a) != null) {
            com.cfg.mendikot.b bVar = this.f2367d;
            String str = iVar.f2678a;
            ArrayIterator it = bVar.j.buttons.iterator();
            while (it.hasNext()) {
                TextButton textButton = (TextButton) it.next();
                if (textButton.name.equals(str)) {
                    textButton.setChecked(true, textButton.programmaticChangeEvents);
                }
            }
            return;
        }
        com.cfg.mendikot.b bVar2 = this.f2367d;
        String str2 = iVar.f2678a;
        if (bVar2 != null) {
            k.app.postRunnable(new com.cfg.mendikot.b.d(str2, iVar));
            return;
        }
        throw null;
    }

    public void a(String str, String str2) {
        try {
            if (this.g != null) {
                SocketManager socketManager = this.g;
                if (socketManager != null) {
                    try {
                        com.cfg.mendikot.api.d.a.a.b.a aVar = socketManager.f2243a.get(str).f2253d;
                        if (aVar != null) {
                            new Thread(new com.cfg.mendikot.api.d.a.a.b.a.e()).start();
                        }
                        socketManager.f2243a.remove(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw null;
                }
            }
            this.f2367d.e(str);
            this.f2369f.remove(str);
            this.f2368e.remove(str);
            if (this.f2369f.size() == 0) {
                try {
                    if (this.f2366c.getSDKListener() != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(CardGameFeature.KEY_GAME_ID, str);
                        bundle.putString("data", str2);
                        this.f2366c.getSDKListener().onEvent(SDKEvent.GAME_END, bundle);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
