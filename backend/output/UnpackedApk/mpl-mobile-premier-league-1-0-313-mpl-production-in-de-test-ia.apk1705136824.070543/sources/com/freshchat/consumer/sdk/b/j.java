package com.freshchat.consumer.sdk.b;

import android.content.Context;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.service.e.n.a;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    public final e cL;

    public j(Context context) {
        this.cL = e.i(context.getApplicationContext());
    }

    public boolean P(String str) {
        return this.cL.iK().has(str);
    }

    public void a(String str, a aVar) {
        JSONObject iK = this.cL.iK();
        try {
            iK.put(str, aVar.toString());
        } catch (JSONException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
        this.cL.a(iK);
    }

    public boolean bj(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        try {
            if (as.o(a.Downvote.toString(), this.cL.iK().getString(str))) {
                return true;
            }
        } catch (JSONException e2) {
            ai.e("FRESHCHAT", "Exception occured", e2);
        }
        return false;
    }
}
