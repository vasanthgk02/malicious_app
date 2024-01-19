package com.freshchat.consumer.sdk;

public enum JwtTokenStatus {
    TOKEN_NOT_SET(1),
    TOKEN_NOT_PROCESSED(2),
    TOKEN_VALID(3),
    TOKEN_INVALID(4),
    TOKEN_EXPIRED(5);
    
    public final int intValue;

    /* access modifiers changed from: public */
    JwtTokenStatus(int i) {
        this.intValue = i;
    }

    public static JwtTokenStatus fromInt(int i) {
        for (JwtTokenStatus jwtTokenStatus : values()) {
            if (jwtTokenStatus.asInt() == i) {
                return jwtTokenStatus;
            }
        }
        return TOKEN_NOT_SET;
    }

    public int asInt() {
        return this.intValue;
    }
}
