package com.mpl.androidapp.unity.ct;

import com.mpl.androidapp.cleverTap.MplCtEventInitiate.CtEventConstants;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MLogger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/unity/ct/UnityCt;", "", "()V", "TAG", "", "sendUnityCrashToCt", "", "gameConfigInput", "message", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCt.kt */
public final class UnityCt {
    public static final UnityCt INSTANCE = new UnityCt();
    public static final String TAG = "Unity Crash";

    public final void sendUnityCrashToCt(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "gameConfigInput");
        Intrinsics.checkNotNullParameter(str2, "message");
        try {
            MLogger.d("Unity Crash", str2);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("GameId");
            String string = jSONObject.getString("GameName");
            String str3 = "";
            if (string == null) {
                string = str3;
            }
            int i2 = jSONObject.getInt("TournamentId");
            String string2 = jSONObject.getString(CtEventConstants.TOURNAMENT_NAME);
            if (string2 == null) {
                string2 = str3;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("Profile");
            int i3 = jSONObject2 == null ? 0 : jSONObject2.getInt("id");
            String string3 = jSONObject.getString(GameConstant.GAME_COUNTRY_CODE);
            if (string3 != null) {
                str3 = string3;
            }
            int i4 = jSONObject.getInt(CtEventConstants.ENTRY_FEE);
            HashMap hashMap = new HashMap();
            hashMap.put("Game Name", string);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("Tournament ID", Integer.valueOf(i2));
            hashMap.put("Tournament Name", string2);
            hashMap.put("User ID", Integer.valueOf(i3));
            hashMap.put("Entry Free", Integer.valueOf(i4));
            hashMap.put("Country Code", str3);
            hashMap.put("Crash Details", str2);
            CleverTapAnalyticsUtils.sendEvent((String) "Unity Crash", hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (str2.length() > 0) {
                MLogger.d("Unity Crash", str2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Crash Details", str2);
                CleverTapAnalyticsUtils.sendEvent((String) "Unity Crash", hashMap2);
            }
        }
    }
}
