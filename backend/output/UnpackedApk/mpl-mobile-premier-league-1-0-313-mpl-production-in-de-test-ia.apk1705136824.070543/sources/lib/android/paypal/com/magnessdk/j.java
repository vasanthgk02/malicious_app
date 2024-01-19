package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.os.Handler;
import lib.android.paypal.com.magnessdk.b.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends g {
    public static j bx;
    public e bA;
    public JSONArray bB;
    public Handler bC;
    public MagnesSettings bD;
    public m bE;
    public m bF;
    public m bG;
    public String by = "";
    public JSONObject bz;

    public JSONObject a() {
        return null;
    }

    public void a(int i, MagnesSettings magnesSettings) {
        m mVar;
        try {
            Context context = magnesSettings.context;
            if (i != 96) {
                if (i != 97) {
                    if (i == 102) {
                        if (this.bA.a(i)) {
                            this.bG = new m(context, this.bC, 2);
                            if (this.bz.optBoolean(c$l.MG.toString(), false)) {
                                mVar = this.bG;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (this.bA.a(i)) {
                    this.bF = new m(context, this.bC, 4);
                    if (this.bz.optBoolean(c$l.GY.toString(), false)) {
                        mVar = this.bF;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (this.bA.a(i)) {
                this.bE = new m(context, this.bC, 1);
                if (this.bz.optBoolean(c$l.AC.toString(), false)) {
                    mVar = this.bE;
                } else {
                    return;
                }
            } else {
                return;
            }
            mVar.a();
        } catch (Exception e2) {
            a.a(j.class, 3, (Throwable) e2);
        }
    }
}
