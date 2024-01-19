package com.cfg.mendikot.api;

import a.a.j.f;
import a.a.l.e;
import com.cfg.mendikot.app.CFGMendikot;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public String f2250a;

    /* renamed from: b  reason: collision with root package name */
    public String f2251b;

    /* renamed from: c  reason: collision with root package name */
    public e f2252c;

    /* renamed from: d  reason: collision with root package name */
    public com.cfg.mendikot.api.d.a.a.b.a f2253d;

    /* renamed from: e  reason: collision with root package name */
    public int f2254e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2255f = 60000;
    public int g = 3000;

    public class a extends com.cfg.mendikot.api.d.a.a.b.a {
        public final /* synthetic */ e m;
        public final /* synthetic */ String n;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public a(URI uri, e eVar, String str) {
            // this.m = eVar;
            // this.n = str;
            super(uri);
        }

        public void a(Exception exc) {
            exc.toString();
            if (exc instanceof UnknownHostException) {
                e eVar = this.m;
                if (eVar != null) {
                    b.this.f2254e++;
                    eVar.e(this.n);
                    b bVar = b.this;
                    if (bVar.f2254e >= bVar.f2255f / bVar.g) {
                        com.cfg.mendikot.api.d.a.a.b.a aVar = bVar.f2253d;
                        if (aVar != null) {
                            new Thread(new com.cfg.mendikot.api.d.a.a.b.a.e()).start();
                            this.m.c(this.n);
                            return;
                        }
                        throw null;
                    }
                }
            }
        }
    }

    public b(String str, e eVar) {
        boolean z = false;
        try {
            this.f2250a = str;
            this.f2252c = eVar;
            URI uri = new URI(a.f2248c + str);
            if (CFGMendikot.get().getSDKConfig() != null) {
                HashMap<String, Integer> socketConfigMap = CFGMendikot.get().getSDKConfig().getSocketConfigMap();
                if (socketConfigMap != null ? true : z) {
                    if (socketConfigMap.get(CardGameFeature.KEY_CONNECT_TIMEOUT) != null) {
                        this.f2255f = socketConfigMap.get(CardGameFeature.KEY_CONNECT_TIMEOUT).intValue();
                    }
                    if (socketConfigMap.get(CardGameFeature.KEY_RECONNECTION_INTERVAL) != null) {
                        this.g = socketConfigMap.get(CardGameFeature.KEY_RECONNECTION_INTERVAL).intValue();
                    }
                }
            }
            a aVar = new a(uri, eVar, str);
            this.f2253d = aVar;
            String string = com.cfg.mendikot.c.c.b.f2363a.f2361b.getString("PREF_KEY_EXTERNAL_TOKEN", "");
            synchronized (aVar.f2319a) {
                if (!aVar.h) {
                    aVar.i.put("externalToken", string);
                } else {
                    throw new IllegalStateException("Cannot add header while WebSocketClient is running");
                }
            }
            this.f2253d.a(this.f2255f);
            this.f2253d.b(this.f2255f);
            this.f2253d.a((long) this.g);
            this.f2253d.b();
        } catch (Exception e2) {
            e2.toString();
            e2.printStackTrace();
        }
    }

    public final char a(int i) {
        switch (i) {
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'T';
            case 11:
                return 'J';
            case 12:
                return 'Q';
            case 13:
                return 'K';
            case 14:
                return 'A';
            default:
                return 'e';
        }
    }

    public void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_COMMAND, "refresh");
            jSONObject.put("token", com.cfg.mendikot.c.c.b.f2363a.b());
            this.f2253d.b(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final char b(int i) {
        if (i == 1) {
            return 'S';
        }
        if (i == 2) {
            return 'H';
        }
        if (i != 3) {
            return i != 4 ? 'e' : 'D';
        }
        return 'C';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:195:0x068f, code lost:
        r0 = r1.f2251b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0784, code lost:
        r4.contentEquals(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r56) {
        /*
            r55 = this;
            r1 = r55
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2 = r56
            r0.<init>(r2)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r2 = "command"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x07f0 }
            r3 = -1
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r5 = "token"
            java.lang.String r6 = "error"
            java.lang.String r7 = "gameStarted"
            switch(r4) {
                case -2030725073: goto L_0x00bf;
                case -1311104296: goto L_0x00b4;
                case -1189717419: goto L_0x00aa;
                case -934426595: goto L_0x009f;
                case -195631223: goto L_0x0094;
                case -157029516: goto L_0x008a;
                case -177043: goto L_0x007f;
                case 3357649: goto L_0x0075;
                case 96632902: goto L_0x006a;
                case 96784904: goto L_0x0062;
                case 97203460: goto L_0x0057;
                case 110541305: goto L_0x004e;
                case 692783527: goto L_0x0042;
                case 1057379089: goto L_0x0037;
                case 1085444827: goto L_0x002b;
                case 1243543370: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00c6
        L_0x001f:
            java.lang.String r4 = "moveEnd"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 9
            goto L_0x00c6
        L_0x002b:
            java.lang.String r4 = "refresh"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 15
            goto L_0x00c6
        L_0x0037:
            java.lang.String r4 = "moveStart"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 6
            goto L_0x00c6
        L_0x0042:
            java.lang.String r4 = "handWon"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 8
            goto L_0x00c6
        L_0x004e:
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 3
            goto L_0x00c6
        L_0x0057:
            java.lang.String r4 = "fatal"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 1
            goto L_0x00c6
        L_0x0062:
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 0
            goto L_0x00c6
        L_0x006a:
            java.lang.String r4 = "emoji"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 12
            goto L_0x00c6
        L_0x0075:
            java.lang.String r4 = "move"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 7
            goto L_0x00c6
        L_0x007f:
            java.lang.String r4 = "roundEnd"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 10
            goto L_0x00c6
        L_0x008a:
            java.lang.String r4 = "roundStart"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 4
            goto L_0x00c6
        L_0x0094:
            java.lang.String r4 = "gameEnd"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 14
            goto L_0x00c6
        L_0x009f:
            java.lang.String r4 = "result"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 13
            goto L_0x00c6
        L_0x00aa:
            java.lang.String r4 = "trumpSelected"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 5
            goto L_0x00c6
        L_0x00b4:
            java.lang.String r4 = "systemMessage"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 11
            goto L_0x00c6
        L_0x00bf:
            boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x00c6
            r3 = 2
        L_0x00c6:
            java.lang.String r2 = "users"
            java.lang.String r4 = "userTeamMap"
            java.lang.String r13 = "hand"
            java.lang.String r14 = "cards"
            java.lang.String r15 = "scores"
            java.lang.String r9 = "trump"
            java.lang.String r10 = "validSuits"
            java.lang.String r8 = "timeout"
            java.lang.String r11 = "rank"
            java.lang.String r12 = "delay"
            r20 = r6
            java.lang.String r6 = "user"
            r21 = r5
            java.lang.String r5 = "turn"
            r22 = r15
            java.lang.String r15 = "suit"
            r23 = r14
            java.lang.String r14 = "data"
            r24 = r10
            java.lang.String r10 = "roundsWon"
            r25 = r8
            java.lang.String r8 = "vendorID"
            r26 = r12
            java.lang.String r12 = "userName"
            r27 = r5
            java.lang.String r5 = "playerPublic"
            r28 = r6
            java.lang.String r6 = "round"
            r29 = r11
            java.lang.String r11 = "next"
            r30 = r11
            java.lang.String r11 = ""
            r31 = r11
            java.lang.String r11 = "capturedTens"
            switch(r3) {
                case 0: goto L_0x07bb;
                case 1: goto L_0x07ab;
                case 2: goto L_0x010d;
                case 3: goto L_0x0788;
                case 4: goto L_0x06b1;
                case 5: goto L_0x0693;
                case 6: goto L_0x0639;
                case 7: goto L_0x05b7;
                case 8: goto L_0x0570;
                case 9: goto L_0x0554;
                case 10: goto L_0x0506;
                case 11: goto L_0x04e2;
                case 12: goto L_0x04ba;
                case 13: goto L_0x0466;
                case 14: goto L_0x0444;
                case 15: goto L_0x010f;
                default: goto L_0x010d;
            }
        L_0x010d:
            goto L_0x07f4
        L_0x010f:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x0430 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0430 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0430 }
            boolean r36 = r3.getBoolean(r7)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r0 = "lobbyDetails"
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ Exception -> 0x0430 }
            a.a.l.i r7 = new a.a.l.i     // Catch:{ Exception -> 0x0430 }
            r7.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x01bd
            java.lang.String r14 = "lobbyName"
            java.lang.String r14 = r0.optString(r14)     // Catch:{ Exception -> 0x0430 }
            r7.b(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "buyInAmount"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.a(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "maxPlayers"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.b(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "winners"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.f(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "rounds"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.d(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "prizePool"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.c(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "turnTimeout"
            int r14 = r0.optInt(r14)     // Catch:{ Exception -> 0x0430 }
            r7.e(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "commission"
            r32 = r15
            double r14 = r0.optDouble(r14)     // Catch:{ Exception -> 0x0430 }
            r7.c(r14)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = "breakdown"
            org.json.JSONArray r0 = r0.optJSONArray(r14)     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x01b8
            int r14 = r0.length()     // Catch:{ Exception -> 0x0430 }
            double[] r14 = new double[r14]     // Catch:{ Exception -> 0x0430 }
            r33 = r4
            r15 = 0
        L_0x0184:
            int r4 = r0.length()     // Catch:{ Exception -> 0x0430 }
            if (r15 >= r4) goto L_0x01a9
            java.lang.Object r4 = r0.get(r15)     // Catch:{ Exception -> 0x0430 }
            boolean r4 = r4 instanceof java.lang.Double     // Catch:{ Exception -> 0x0430 }
            if (r4 == 0) goto L_0x019b
            double r20 = r0.getDouble(r15)     // Catch:{ Exception -> 0x0430 }
            r14[r15] = r20     // Catch:{ Exception -> 0x0430 }
            r34 = r5
            goto L_0x01a4
        L_0x019b:
            int r4 = r0.getInt(r15)     // Catch:{ Exception -> 0x0430 }
            r34 = r5
            double r4 = (double) r4     // Catch:{ Exception -> 0x0430 }
            r14[r15] = r4     // Catch:{ Exception -> 0x0430 }
        L_0x01a4:
            int r15 = r15 + 1
            r5 = r34
            goto L_0x0184
        L_0x01a9:
            r34 = r5
            r0 = 0
            r4 = r14[r0]     // Catch:{ Exception -> 0x0430 }
            r7.a(r4)     // Catch:{ Exception -> 0x0430 }
            r0 = 1
            r4 = r14[r0]     // Catch:{ Exception -> 0x0430 }
            r7.b(r4)     // Catch:{ Exception -> 0x0430 }
            goto L_0x01c3
        L_0x01b8:
            r33 = r4
            r34 = r5
            goto L_0x01c3
        L_0x01bd:
            r33 = r4
            r34 = r5
            r32 = r15
        L_0x01c3:
            r7.toString()     // Catch:{ Exception -> 0x0430 }
            org.json.JSONArray r0 = r3.getJSONArray(r2)     // Catch:{ Exception -> 0x0430 }
            int r2 = r0.length()     // Catch:{ Exception -> 0x0430 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0430 }
            r4 = 0
        L_0x01d1:
            int r5 = r0.length()     // Catch:{ Exception -> 0x0430 }
            if (r4 >= r5) goto L_0x01e0
            java.lang.String r5 = r0.getString(r4)     // Catch:{ Exception -> 0x0430 }
            r2[r4] = r5     // Catch:{ Exception -> 0x0430 }
            int r4 = r4 + 1
            goto L_0x01d1
        L_0x01e0:
            int r38 = r3.optInt(r6)     // Catch:{ Exception -> 0x0430 }
            int r54 = r3.getInt(r13)     // Catch:{ Exception -> 0x0430 }
            int r0 = r3.getInt(r9)     // Catch:{ Exception -> 0x0430 }
            char r39 = r1.b(r0)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r0 = "playerCommon"
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x0430 }
            java.util.concurrent.ConcurrentHashMap r4 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0430 }
            r4.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x025e
            java.util.Iterator r5 = r0.keys()     // Catch:{ Exception -> 0x0430 }
        L_0x0201:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0430 }
            if (r6 == 0) goto L_0x025e
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0430 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0430 }
            org.json.JSONObject r9 = r0.getJSONObject(r6)     // Catch:{ Exception -> 0x0430 }
            a.a.k.d r13 = new a.a.k.d     // Catch:{ Exception -> 0x0430 }
            r13.<init>()     // Catch:{ Exception -> 0x0430 }
            r13.a(r6)     // Catch:{ Exception -> 0x0430 }
            r13.b(r6)     // Catch:{ Exception -> 0x0430 }
            r14 = 4
            char[] r15 = new char[r14]     // Catch:{ Exception -> 0x0430 }
            r14 = 0
            r15[r14] = r14     // Catch:{ Exception -> 0x0430 }
            r18 = 1
            r15[r18] = r14     // Catch:{ Exception -> 0x0430 }
            r16 = 2
            r15[r16] = r14     // Catch:{ Exception -> 0x0430 }
            r19 = 3
            r15[r19] = r14     // Catch:{ Exception -> 0x0430 }
            org.json.JSONArray r14 = r9.getJSONArray(r11)     // Catch:{ Exception -> 0x0430 }
            r20 = r0
            r21 = r5
            r0 = 0
        L_0x0237:
            int r5 = r14.length()     // Catch:{ Exception -> 0x0430 }
            if (r0 >= r5) goto L_0x024a
            int r5 = r14.getInt(r0)     // Catch:{ Exception -> 0x0430 }
            char r5 = r1.b(r5)     // Catch:{ Exception -> 0x0430 }
            r15[r0] = r5     // Catch:{ Exception -> 0x0430 }
            int r0 = r0 + 1
            goto L_0x0237
        L_0x024a:
            r13.a(r15)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r0 = "captured"
            int r0 = r9.getInt(r0)     // Catch:{ Exception -> 0x0430 }
            r13.a(r0)     // Catch:{ Exception -> 0x0430 }
            r4.put(r6, r13)     // Catch:{ Exception -> 0x0430 }
            r0 = r20
            r5 = r21
            goto L_0x0201
        L_0x025e:
            r5 = r34
            org.json.JSONObject r0 = r3.optJSONObject(r5)     // Catch:{ Exception -> 0x0430 }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0430 }
            r5.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x029c
            java.util.Iterator r6 = r0.keys()     // Catch:{ Exception -> 0x0430 }
        L_0x026f:
            boolean r9 = r6.hasNext()     // Catch:{ Exception -> 0x0430 }
            if (r9 == 0) goto L_0x029c
            java.lang.Object r9 = r6.next()     // Catch:{ Exception -> 0x0430 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0430 }
            org.json.JSONObject r11 = r0.getJSONObject(r9)     // Catch:{ Exception -> 0x0430 }
            a.a.k.d r13 = new a.a.k.d     // Catch:{ Exception -> 0x0430 }
            r13.<init>()     // Catch:{ Exception -> 0x0430 }
            r13.a(r9)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r14 = r11.getString(r12)     // Catch:{ Exception -> 0x0430 }
            r13.b(r14)     // Catch:{ Exception -> 0x0430 }
            r11.getString(r8)     // Catch:{ Exception -> 0x0430 }
            int r11 = r11.getInt(r10)     // Catch:{ Exception -> 0x0430 }
            r13.c(r11)     // Catch:{ Exception -> 0x0430 }
            r5.put(r9, r13)     // Catch:{ Exception -> 0x0430 }
            goto L_0x026f
        L_0x029c:
            r6 = r33
            org.json.JSONObject r0 = r3.optJSONObject(r6)     // Catch:{ Exception -> 0x0430 }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0430 }
            r6.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x02c1
            java.util.Iterator r8 = r0.keys()     // Catch:{ Exception -> 0x0430 }
        L_0x02ad:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0430 }
            if (r9 == 0) goto L_0x02c1
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0430 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0430 }
            java.lang.String r10 = r0.getString(r9)     // Catch:{ Exception -> 0x0430 }
            r6.put(r9, r10)     // Catch:{ Exception -> 0x0430 }
            goto L_0x02ad
        L_0x02c1:
            java.lang.String r0 = "currentHand"
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x0430 }
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0430 }
            r8.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x0345
            r9 = r32
            int r10 = r0.getInt(r9)     // Catch:{ Exception -> 0x0430 }
            char r10 = r1.b(r10)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r11 = "moves"
            org.json.JSONArray r11 = r0.optJSONArray(r11)     // Catch:{ Exception -> 0x0430 }
            if (r11 == 0) goto L_0x0334
            r12 = 0
        L_0x02e1:
            int r13 = r11.length()     // Catch:{ Exception -> 0x0430 }
            if (r12 >= r13) goto L_0x0334
            org.json.JSONObject r13 = r11.getJSONObject(r12)     // Catch:{ Exception -> 0x0430 }
            if (r13 == 0) goto L_0x0321
            a.a.d.a r14 = new a.a.d.a     // Catch:{ Exception -> 0x0430 }
            r14.<init>()     // Catch:{ Exception -> 0x0430 }
            java.lang.String r15 = "card"
            org.json.JSONObject r15 = r13.getJSONObject(r15)     // Catch:{ Exception -> 0x0430 }
            r16 = r10
            r56 = r11
            r11 = r29
            int r10 = r15.getInt(r11)     // Catch:{ Exception -> 0x0430 }
            char r10 = r1.a(r10)     // Catch:{ Exception -> 0x0430 }
            int r15 = r15.getInt(r9)     // Catch:{ Exception -> 0x0430 }
            char r15 = r1.b(r15)     // Catch:{ Exception -> 0x0430 }
            r14.a(r10)     // Catch:{ Exception -> 0x0430 }
            r14.b(r15)     // Catch:{ Exception -> 0x0430 }
            r10 = r28
            java.lang.String r13 = r13.getString(r10)     // Catch:{ Exception -> 0x0430 }
            r14.a(r13)     // Catch:{ Exception -> 0x0430 }
            r8.put(r13, r14)     // Catch:{ Exception -> 0x0430 }
            goto L_0x0329
        L_0x0321:
            r16 = r10
            r56 = r11
            r10 = r28
            r11 = r29
        L_0x0329:
            int r12 = r12 + 1
            r28 = r10
            r29 = r11
            r10 = r16
            r11 = r56
            goto L_0x02e1
        L_0x0334:
            r16 = r10
            r10 = r28
            r11 = r29
            java.lang.String r12 = "moveNumber"
            int r0 = r0.getInt(r12)     // Catch:{ Exception -> 0x0430 }
            r45 = r0
            r43 = r16
            goto L_0x0351
        L_0x0345:
            r10 = r28
            r11 = r29
            r9 = r32
            r0 = 101(0x65, float:1.42E-43)
            r43 = 101(0x65, float:1.42E-43)
            r45 = 0
        L_0x0351:
            java.lang.String r0 = "type"
            java.lang.String r46 = r3.getString(r0)     // Catch:{ Exception -> 0x0430 }
            r13 = r27
            java.lang.String r47 = r3.getString(r13)     // Catch:{ Exception -> 0x0430 }
            r12 = r30
            java.lang.String r48 = r3.getString(r12)     // Catch:{ Exception -> 0x0430 }
            java.lang.String r0 = "self"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0430 }
            r1.f2251b = r0     // Catch:{ Exception -> 0x0430 }
            r15 = r26
            int r50 = r3.getInt(r15)     // Catch:{ Exception -> 0x0430 }
            r13 = r25
            int r49 = r3.getInt(r13)     // Catch:{ Exception -> 0x0430 }
            r12 = r24
            org.json.JSONArray r12 = r3.optJSONArray(r12)     // Catch:{ Exception -> 0x0430 }
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ Exception -> 0x0430 }
            r13.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r12 == 0) goto L_0x039d
            r14 = 0
        L_0x0385:
            int r15 = r12.length()     // Catch:{ Exception -> 0x0430 }
            if (r14 >= r15) goto L_0x039d
            int r15 = r12.getInt(r14)     // Catch:{ Exception -> 0x0430 }
            char r15 = r1.b(r15)     // Catch:{ Exception -> 0x0430 }
            java.lang.Character r15 = java.lang.Character.valueOf(r15)     // Catch:{ Exception -> 0x0430 }
            r13.add(r15)     // Catch:{ Exception -> 0x0430 }
            int r14 = r14 + 1
            goto L_0x0385
        L_0x039d:
            java.lang.String r12 = "player"
            org.json.JSONObject r12 = r3.optJSONObject(r12)     // Catch:{ Exception -> 0x0430 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0430 }
            r14.<init>()     // Catch:{ Exception -> 0x0430 }
            if (r12 == 0) goto L_0x03ef
            java.lang.String r10 = r12.getString(r10)     // Catch:{ Exception -> 0x0430 }
            r15 = r23
            org.json.JSONArray r12 = r12.getJSONArray(r15)     // Catch:{ Exception -> 0x0430 }
            r56 = r10
            r15 = 0
        L_0x03b7:
            int r10 = r12.length()     // Catch:{ Exception -> 0x0430 }
            if (r15 >= r10) goto L_0x03ea
            a.a.d.a r10 = new a.a.d.a     // Catch:{ Exception -> 0x0430 }
            r10.<init>()     // Catch:{ Exception -> 0x0430 }
            r20 = r3
            org.json.JSONObject r3 = r12.getJSONObject(r15)     // Catch:{ Exception -> 0x0430 }
            r16 = r12
            int r12 = r3.getInt(r9)     // Catch:{ Exception -> 0x0430 }
            char r12 = r1.b(r12)     // Catch:{ Exception -> 0x0430 }
            r10.b(r12)     // Catch:{ Exception -> 0x0430 }
            int r3 = r3.getInt(r11)     // Catch:{ Exception -> 0x0430 }
            char r3 = r1.a(r3)     // Catch:{ Exception -> 0x0430 }
            r10.a(r3)     // Catch:{ Exception -> 0x0430 }
            r14.add(r10)     // Catch:{ Exception -> 0x0430 }
            int r15 = r15 + 1
            r12 = r16
            r3 = r20
            goto L_0x03b7
        L_0x03ea:
            r20 = r3
            r52 = r56
            goto L_0x03f3
        L_0x03ef:
            r20 = r3
            r52 = r31
        L_0x03f3:
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x0430 }
            if (r3 == 0) goto L_0x0414
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x0430 }
            java.lang.String r9 = r1.f2250a     // Catch:{ Exception -> 0x0430 }
            r32 = r3
            r33 = r9
            r34 = r7
            r35 = r0
            r37 = r2
            r40 = r4
            r41 = r5
            r42 = r6
            r44 = r8
            r51 = r13
            r53 = r14
            r32.a(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)     // Catch:{ Exception -> 0x0430 }
        L_0x0414:
            r0 = r20
            r2 = r22
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch:{ Exception -> 0x0430 }
            if (r0 == 0) goto L_0x07f4
            java.util.HashMap[] r0 = r1.a(r0)     // Catch:{ Exception -> 0x0430 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x0430 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x0430 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x0430 }
            r4 = 0
            r2.a(r3, (java.util.HashMap<java.lang.String, a.a.j.f>[]) r0, r6, r4)     // Catch:{ Exception -> 0x0430 }
            goto L_0x07f4
        L_0x0430:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x07f0 }
            r55.a()     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r0 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r0 == 0) goto L_0x07f4
            a.a.l.e r0 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r2 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r0.d(r2)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0444:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = "gameID"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = r2.getJSONObject(r14)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r3 == 0) goto L_0x07f4
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x07f0 }
            r3.a(r0, r2)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0466:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x07f0 }
            r0.<init>()     // Catch:{ Exception -> 0x07f0 }
            java.util.Iterator r3 = r2.keys()     // Catch:{ Exception -> 0x07f0 }
        L_0x0478:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x07f0 }
            if (r4 == 0) goto L_0x04ad
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r5 = r2.getJSONObject(r4)     // Catch:{ Exception -> 0x07f0 }
            a.a.j.b r6 = new a.a.j.b     // Catch:{ Exception -> 0x07f0 }
            r6.<init>()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r7 = "score"
            double r7 = r5.getDouble(r7)     // Catch:{ Exception -> 0x07f0 }
            float r7 = (float) r7     // Catch:{ Exception -> 0x07f0 }
            r6.a(r7)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r7 = "total"
            double r7 = r5.getDouble(r7)     // Catch:{ Exception -> 0x07f0 }
            r6.a(r7)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r7 = "winner"
            boolean r5 = r5.getBoolean(r7)     // Catch:{ Exception -> 0x07f0 }
            r6.a(r5)     // Catch:{ Exception -> 0x07f0 }
            r0.put(r4, r6)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x0478
        L_0x04ad:
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r2.a(r3, r0)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x04ba:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = "fromId"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = "toId"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = "emojiIndex"
            int r2 = r2.getInt(r4)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r4 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r4 == 0) goto L_0x07f4
            a.a.l.e r4 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r5 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r4.b(r5, r0, r3, r2)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x04e2:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = "message"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = "duration"
            int r2 = r2.getInt(r3)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r3 == 0) goto L_0x07f4
            a.a.l.e r3 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r5 = r31
            r3.c(r4, r0, r5, r2)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0506:
            r6 = r4
            r2 = r22
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONArray r0 = r3.optJSONArray(r2)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = r3.optJSONObject(r6)     // Catch:{ Exception -> 0x07f0 }
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x07f0 }
            r3.<init>()     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x0539
            java.util.Iterator r4 = r2.keys()     // Catch:{ Exception -> 0x07f0 }
        L_0x0525:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x07f0 }
            if (r5 == 0) goto L_0x0539
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r6 = r2.getString(r5)     // Catch:{ Exception -> 0x07f0 }
            r3.put(r5, r6)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x0525
        L_0x0539:
            if (r0 == 0) goto L_0x07f4
            java.util.HashMap[] r0 = r1.a(r0)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r2.a(r4, (java.util.HashMap<java.lang.String, a.a.j.f>[]) r0)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r5 = 1
            r2.a(r4, (java.util.HashMap<java.lang.String, a.a.j.f>[]) r0, r3, r5)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0554:
            r13 = r27
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = r2.getString(r13)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r2.b(r3, r0)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0570:
            r10 = r28
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = r2.getString(r10)     // Catch:{ Exception -> 0x07f0 }
            int r3 = r2.getInt(r13)     // Catch:{ Exception -> 0x07f0 }
            r4 = 4
            char[] r4 = new char[r4]     // Catch:{ Exception -> 0x07f0 }
            r7 = 0
            r4[r7] = r7     // Catch:{ Exception -> 0x07f0 }
            r5 = 1
            r4[r5] = r7     // Catch:{ Exception -> 0x07f0 }
            r5 = 2
            r4[r5] = r7     // Catch:{ Exception -> 0x07f0 }
            r5 = 3
            r4[r5] = r7     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONArray r2 = r2.getJSONArray(r11)     // Catch:{ Exception -> 0x07f0 }
            r12 = 0
        L_0x0597:
            int r5 = r2.length()     // Catch:{ Exception -> 0x07f0 }
            if (r12 >= r5) goto L_0x05aa
            int r5 = r2.getInt(r12)     // Catch:{ Exception -> 0x07f0 }
            char r5 = r1.b(r5)     // Catch:{ Exception -> 0x07f0 }
            r4[r12] = r5     // Catch:{ Exception -> 0x07f0 }
            int r12 = r12 + 1
            goto L_0x0597
        L_0x05aa:
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r5 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r2.a(r5, r0, r3, r4)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x05b7:
            r9 = r15
            r2 = r24
            r13 = r25
            r15 = r26
            r10 = r28
            r11 = r29
            r12 = r30
            r7 = 0
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            a.a.d.a r0 = new a.a.d.a     // Catch:{ Exception -> 0x07f0 }
            r0.<init>()     // Catch:{ Exception -> 0x07f0 }
            int r4 = r3.getInt(r9)     // Catch:{ Exception -> 0x07f0 }
            char r4 = r1.b(r4)     // Catch:{ Exception -> 0x07f0 }
            r0.b(r4)     // Catch:{ Exception -> 0x07f0 }
            int r4 = r3.getInt(r11)     // Catch:{ Exception -> 0x07f0 }
            char r4 = r1.a(r4)     // Catch:{ Exception -> 0x07f0 }
            r0.a(r4)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r19 = r3.getString(r10)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = r3.getString(r12)     // Catch:{ Exception -> 0x07f0 }
            int r21 = r3.getInt(r13)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r5 = "end"
            boolean r24 = r3.getBoolean(r5)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONArray r2 = r3.getJSONArray(r2)     // Catch:{ Exception -> 0x07f0 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ Exception -> 0x07f0 }
            r5.<init>()     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x061f
            r12 = 0
        L_0x0607:
            int r6 = r2.length()     // Catch:{ Exception -> 0x07f0 }
            if (r12 >= r6) goto L_0x061f
            int r6 = r2.getInt(r12)     // Catch:{ Exception -> 0x07f0 }
            char r6 = r1.b(r6)     // Catch:{ Exception -> 0x07f0 }
            java.lang.Character r6 = java.lang.Character.valueOf(r6)     // Catch:{ Exception -> 0x07f0 }
            r5.add(r6)     // Catch:{ Exception -> 0x07f0 }
            int r12 = r12 + 1
            goto L_0x0607
        L_0x061f:
            int r23 = r3.getInt(r15)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x068f
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r16 = r2
            r17 = r3
            r18 = r0
            r20 = r4
            r22 = r5
            r16.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x068f
        L_0x0639:
            r2 = r24
            r3 = r25
            r15 = r26
            r13 = r27
            r7 = 0
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r0 = r4.getString(r13)     // Catch:{ Exception -> 0x07f0 }
            int r19 = r4.getInt(r3)     // Catch:{ Exception -> 0x07f0 }
            int r21 = r4.getInt(r15)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONArray r2 = r4.getJSONArray(r2)     // Catch:{ Exception -> 0x07f0 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ Exception -> 0x07f0 }
            r3.<init>()     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x067b
            r12 = 0
        L_0x0663:
            int r4 = r2.length()     // Catch:{ Exception -> 0x07f0 }
            if (r12 >= r4) goto L_0x067b
            int r4 = r2.getInt(r12)     // Catch:{ Exception -> 0x07f0 }
            char r4 = r1.b(r4)     // Catch:{ Exception -> 0x07f0 }
            java.lang.Character r4 = java.lang.Character.valueOf(r4)     // Catch:{ Exception -> 0x07f0 }
            r3.add(r4)     // Catch:{ Exception -> 0x07f0 }
            int r12 = r12 + 1
            goto L_0x0663
        L_0x067b:
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x068e
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r4 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r16 = r2
            r17 = r4
            r18 = r0
            r20 = r3
            r16.a(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x07f0 }
        L_0x068e:
            r4 = r0
        L_0x068f:
            java.lang.String r0 = r1.f2251b     // Catch:{ Exception -> 0x07f0 }
            goto L_0x0784
        L_0x0693:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            int r0 = r2.getInt(r9)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07f4
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            char r0 = r1.b(r0)     // Catch:{ Exception -> 0x07f0 }
            r2.a(r3, r0)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x06b1:
            r9 = r15
            r3 = r23
            r15 = r26
            r13 = r27
            r11 = r29
            r7 = 0
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x07f0 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONArray r0 = r4.getJSONArray(r3)     // Catch:{ Exception -> 0x07f0 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x07f0 }
            r3.<init>()     // Catch:{ Exception -> 0x07f0 }
            r14 = 0
        L_0x06ce:
            int r7 = r0.length()     // Catch:{ Exception -> 0x07f0 }
            if (r14 >= r7) goto L_0x0701
            a.a.d.a r7 = new a.a.d.a     // Catch:{ Exception -> 0x07f0 }
            r7.<init>()     // Catch:{ Exception -> 0x07f0 }
            r56 = r10
            org.json.JSONObject r10 = r0.getJSONObject(r14)     // Catch:{ Exception -> 0x07f0 }
            r16 = r0
            int r0 = r10.getInt(r11)     // Catch:{ Exception -> 0x07f0 }
            char r0 = r1.a(r0)     // Catch:{ Exception -> 0x07f0 }
            r7.a(r0)     // Catch:{ Exception -> 0x07f0 }
            int r0 = r10.getInt(r9)     // Catch:{ Exception -> 0x07f0 }
            char r0 = r1.b(r0)     // Catch:{ Exception -> 0x07f0 }
            r7.b(r0)     // Catch:{ Exception -> 0x07f0 }
            r3.add(r7)     // Catch:{ Exception -> 0x07f0 }
            int r14 = r14 + 1
            r10 = r56
            r0 = r16
            goto L_0x06ce
        L_0x0701:
            r56 = r10
            org.json.JSONArray r0 = r4.getJSONArray(r2)     // Catch:{ Exception -> 0x07f0 }
            int r2 = r0.length()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x07f0 }
            r7 = 0
        L_0x070e:
            int r9 = r0.length()     // Catch:{ Exception -> 0x07f0 }
            if (r7 >= r9) goto L_0x071d
            java.lang.String r9 = r0.getString(r7)     // Catch:{ Exception -> 0x07f0 }
            r2[r7] = r9     // Catch:{ Exception -> 0x07f0 }
            int r7 = r7 + 1
            goto L_0x070e
        L_0x071d:
            java.lang.String r0 = r4.getString(r13)     // Catch:{ Exception -> 0x07f0 }
            int r22 = r4.getInt(r6)     // Catch:{ Exception -> 0x07f0 }
            int r23 = r4.getInt(r15)     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ Exception -> 0x07f0 }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x07f0 }
            r5.<init>()     // Catch:{ Exception -> 0x07f0 }
            if (r4 == 0) goto L_0x0769
            java.util.Iterator r6 = r4.keys()     // Catch:{ Exception -> 0x07f0 }
        L_0x0738:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x07f0 }
            if (r7 == 0) goto L_0x0769
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x07f0 }
            org.json.JSONObject r9 = r4.getJSONObject(r7)     // Catch:{ Exception -> 0x07f0 }
            a.a.k.d r10 = new a.a.k.d     // Catch:{ Exception -> 0x07f0 }
            r10.<init>()     // Catch:{ Exception -> 0x07f0 }
            r10.a(r7)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r11 = r9.getString(r12)     // Catch:{ Exception -> 0x07f0 }
            r10.b(r11)     // Catch:{ Exception -> 0x07f0 }
            r9.getString(r8)     // Catch:{ Exception -> 0x07f0 }
            r11 = r56
            int r9 = r9.getInt(r11)     // Catch:{ Exception -> 0x07f0 }
            r10.c(r9)     // Catch:{ Exception -> 0x07f0 }
            r5.put(r7, r10)     // Catch:{ Exception -> 0x07f0 }
            r56 = r11
            goto L_0x0738
        L_0x0769:
            a.a.l.e r4 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r4 == 0) goto L_0x0780
            a.a.l.e r4 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r6 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r16 = r4
            r17 = r6
            r18 = r3
            r19 = r0
            r20 = r5
            r21 = r2
            r16.a(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x07f0 }
        L_0x0780:
            java.lang.String r2 = r1.f2251b     // Catch:{ Exception -> 0x07f0 }
            r4 = r0
            r0 = r2
        L_0x0784:
            r4.contentEquals(r0)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x0788:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07a6 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x07a6 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x07a6 }
            com.cfg.mendikot.c.c r0 = com.cfg.mendikot.c.c.e()     // Catch:{ Exception -> 0x07a6 }
            r3 = r21
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x07a6 }
            r0.a(r2)     // Catch:{ Exception -> 0x07a6 }
            com.cfg.mendikot.c.c r0 = com.cfg.mendikot.c.c.e()     // Catch:{ Exception -> 0x07a6 }
            r0.a()     // Catch:{ Exception -> 0x07a6 }
            goto L_0x07f4
        L_0x07a6:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07f4
        L_0x07ab:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07ec
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r2.c(r3, r0)     // Catch:{ Exception -> 0x07f0 }
            goto L_0x07ec
        L_0x07bb:
            java.lang.String r0 = r0.getString(r14)     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r2 = "invalid game id"
            boolean r2 = r0.contentEquals(r2)     // Catch:{ Exception -> 0x07f0 }
            if (r2 != 0) goto L_0x07df
            java.lang.String r2 = "websocket: close 1006 (abnormal closure): unexpected EOF"
            boolean r2 = r0.contentEquals(r2)     // Catch:{ Exception -> 0x07f0 }
            if (r2 != 0) goto L_0x07df
            java.lang.String r2 = "rpc error: code = Unknown desc = redis: nil"
            boolean r2 = r0.contentEquals(r2)     // Catch:{ Exception -> 0x07f0 }
            if (r2 != 0) goto L_0x07df
            java.lang.String r2 = "received status code: 500"
            boolean r2 = r0.contentEquals(r2)     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07ec
        L_0x07df:
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            if (r2 == 0) goto L_0x07ec
            a.a.l.e r2 = r1.f2252c     // Catch:{ Exception -> 0x07f0 }
            java.lang.String r3 = r1.f2250a     // Catch:{ Exception -> 0x07f0 }
            r4 = r20
            r2.a(r3, r4)     // Catch:{ Exception -> 0x07f0 }
        L_0x07ec:
            r1.a(r0)     // Catch:{ Exception -> 0x07f4 }
            goto L_0x07f4
        L_0x07f0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x07f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.b.b(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12) {
        /*
            r11 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r12)
            java.lang.String r12 = "error"
            java.lang.String r12 = r0.getString(r12)
            int r1 = r12.hashCode()
            r2 = 0
            r3 = 1
            r4 = 469019542(0x1bf4ab96, float:4.0477299E-22)
            if (r1 == r4) goto L_0x0026
            r4 = 469049606(0x1bf52106, float:4.055319E-22)
            if (r1 == r4) goto L_0x001c
            goto L_0x0030
        L_0x001c:
            java.lang.String r1 = "invalid turn"
            boolean r12 = r12.equals(r1)
            if (r12 == 0) goto L_0x0030
            r12 = 1
            goto L_0x0031
        L_0x0026:
            java.lang.String r1 = "invalid suit"
            boolean r12 = r12.equals(r1)
            if (r12 == 0) goto L_0x0030
            r12 = 0
            goto L_0x0031
        L_0x0030:
            r12 = -1
        L_0x0031:
            if (r12 == 0) goto L_0x0037
            if (r12 == r3) goto L_0x0037
            goto L_0x00f7
        L_0x0037:
            java.lang.String r12 = "validSuits"
            org.json.JSONArray r12 = r0.optJSONArray(r12)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            if (r12 == 0) goto L_0x005d
            r3 = 0
        L_0x0045:
            int r4 = r12.length()
            if (r3 >= r4) goto L_0x005d
            int r4 = r12.getInt(r3)
            char r4 = r11.b(r4)
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r1.add(r4)
            int r3 = r3 + 1
            goto L_0x0045
        L_0x005d:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r3 = "cards"
            org.json.JSONArray r3 = r0.optJSONArray(r3)
            java.lang.String r4 = "rank"
            java.lang.String r5 = "suit"
            if (r3 == 0) goto L_0x0098
            r6 = 0
        L_0x006f:
            int r7 = r3.length()
            if (r6 >= r7) goto L_0x0098
            a.a.d.a r7 = new a.a.d.a
            r7.<init>()
            org.json.JSONObject r8 = r3.getJSONObject(r6)
            int r9 = r8.getInt(r5)
            char r9 = r11.b(r9)
            r7.f2460b = r9
            int r8 = r8.getInt(r4)
            char r8 = r11.a(r8)
            r7.f2459a = r8
            r12.add(r7)
            int r6 = r6 + 1
            goto L_0x006f
        L_0x0098:
            java.lang.String r3 = "currentHand"
            org.json.JSONObject r0 = r0.optJSONObject(r3)
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r3.<init>()
            if (r0 == 0) goto L_0x00ee
            r0.getInt(r5)
            java.lang.String r6 = "moves"
            org.json.JSONArray r6 = r0.optJSONArray(r6)
            if (r6 == 0) goto L_0x00e9
        L_0x00b0:
            int r7 = r6.length()
            if (r2 >= r7) goto L_0x00e9
            org.json.JSONObject r7 = r6.getJSONObject(r2)
            if (r7 == 0) goto L_0x00e6
            a.a.d.a r8 = new a.a.d.a
            r8.<init>()
            java.lang.String r9 = "card"
            org.json.JSONObject r9 = r7.getJSONObject(r9)
            int r10 = r9.getInt(r4)
            char r10 = r11.a(r10)
            int r9 = r9.getInt(r5)
            char r9 = r11.b(r9)
            r8.f2459a = r10
            r8.f2460b = r9
            java.lang.String r9 = "user"
            java.lang.String r7 = r7.getString(r9)
            r8.j = r7
            r3.put(r7, r8)
        L_0x00e6:
            int r2 = r2 + 1
            goto L_0x00b0
        L_0x00e9:
            java.lang.String r2 = "moveNumber"
            r0.getInt(r2)
        L_0x00ee:
            a.a.l.e r0 = r11.f2252c
            if (r0 == 0) goto L_0x00f7
            java.lang.String r2 = r11.f2250a
            r0.a(r2, r1, r12, r3)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.b.a(java.lang.String):void");
    }

    public void a(String str, char c2, char c3) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_COMMAND, "move");
            jSONObject.put("token", com.cfg.mendikot.c.c.b.f2363a.b());
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 0;
            if (c2 == 'A') {
                i = 14;
            } else if (c2 == 'Q') {
                i = 12;
            } else if (c2 == 'T') {
                i = 10;
            } else if (c2 == 'J') {
                i = 11;
            } else if (c2 != 'K') {
                switch (c2) {
                    case '2':
                        i = 2;
                        break;
                    case '3':
                        i = 3;
                        break;
                    case '4':
                        i = 4;
                        break;
                    case '5':
                        i = 5;
                        break;
                    case '6':
                        i = 6;
                        break;
                    case '7':
                        i = 7;
                        break;
                    case '8':
                        i = 8;
                        break;
                    case '9':
                        i = 9;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 13;
            }
            jSONObject2.put("rank", i);
            if (c3 == 'C') {
                i2 = 3;
            } else if (c3 == 'D') {
                i2 = 4;
            } else if (c3 == 'H') {
                i2 = 2;
            } else if (c3 == 'S') {
                i2 = 1;
            }
            jSONObject2.put("suit", i2);
            jSONObject.put("data", jSONObject2.toString());
            this.f2253d.b(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_COMMAND, "sendEmoji");
            jSONObject.put("token", com.cfg.mendikot.c.c.b.f2363a.b());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fromId", str2);
            jSONObject2.put("toId", str3);
            jSONObject2.put("emojiIndex", i);
            jSONObject.put("data", jSONObject2.toString());
            jSONObject.toString();
            this.f2253d.b(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final HashMap<String, f>[] a(JSONArray jSONArray) {
        HashMap<String, f>[] hashMapArr = new HashMap[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            HashMap<String, f> hashMap = new HashMap<>();
            JSONObject jSONObject2 = jSONObject.getJSONObject("scores");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                f fVar = new f();
                fVar.f2547b = jSONObject3.getInt("captured");
                fVar.f2548c = jSONObject3.getInt("capturedTens");
                fVar.f2546a = jSONObject3.getInt(ECommerceParamNames.TOTAL);
                hashMap.put(next, fVar);
            }
            hashMapArr[i] = hashMap;
        }
        return hashMapArr;
    }
}
