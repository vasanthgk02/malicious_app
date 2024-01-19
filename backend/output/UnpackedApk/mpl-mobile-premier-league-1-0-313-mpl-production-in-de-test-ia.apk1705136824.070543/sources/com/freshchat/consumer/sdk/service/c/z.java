package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.beans.reqres.ValidateJwtIdTokenResponse;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.d;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.ab;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;

public class z extends a<ab, k> {
    public boolean a(ab abVar) {
        return w.ay(getContext()) && ap.bD(getContext()).getUserAuthConfig().isJwtAuthEnabled();
    }

    public k b(ab abVar) {
        JwtTokenStatus bz = o.bz(getContext());
        if (a(abVar) && as.a(abVar.getJwtIdToken()) && bz == JwtTokenStatus.TOKEN_NOT_PROCESSED) {
            ValidateJwtIdTokenResponse aZ = new a(getContext()).aZ(abVar.getJwtIdToken());
            if (aZ.isUserAliasExists()) {
                d.bG(getContext());
            } else if (aZ.isValidToken()) {
                o.a(getContext(), JwtTokenStatus.TOKEN_VALID, abVar.getJwtIdToken());
            }
            o.a(getContext(), JwtTokenStatus.TOKEN_INVALID);
        }
        return new h(true);
    }
}
