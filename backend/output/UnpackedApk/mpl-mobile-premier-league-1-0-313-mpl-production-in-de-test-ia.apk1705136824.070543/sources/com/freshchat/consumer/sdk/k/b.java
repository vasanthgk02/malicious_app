package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.c.a;
import com.freshchat.consumer.sdk.j.o;

public class b extends h {
    public JwtTokenStatus lt;
    public a lu;

    public b(Context context) {
        super(context);
    }

    public a gq() {
        a aVar;
        if (!ap.aZ(getContext())) {
            if (al.aS(getContext())) {
                com.freshchat.consumer.sdk.j.b.L(getContext());
                aVar = a.SHOW_PROGRESS;
            } else {
                aVar = a.EXIT_WITH_MESSAGE;
            }
            this.lu = aVar;
            return this.lu;
        } else if (!o.bB(getContext())) {
            a aVar2 = a.SHOW_CONTENT;
            this.lu = aVar2;
            return aVar2;
        } else {
            JwtTokenStatus bz = o.bz(getContext());
            o.b(getContext(), bz);
            o.by(getContext());
            JwtTokenStatus jwtTokenStatus = this.lt;
            a b2 = jwtTokenStatus == null ? o.b(bz) : (jwtTokenStatus == bz || bz == JwtTokenStatus.TOKEN_EXPIRED || bz == JwtTokenStatus.TOKEN_NOT_PROCESSED) ? this.lu : o.a(jwtTokenStatus, bz);
            this.lt = bz;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Token state - ");
            outline73.append(bz.name());
            ai.d("FRESHCHAT_JWT", outline73.toString());
            ai.d("FRESHCHAT_JWT", "Updated action - " + b2.name());
            this.lu = b2;
            return b2;
        }
    }

    public boolean ha() {
        return this.lu == a.SHOW_CONTENT;
    }
}
