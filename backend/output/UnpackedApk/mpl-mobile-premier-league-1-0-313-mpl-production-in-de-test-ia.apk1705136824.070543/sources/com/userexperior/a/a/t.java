package com.userexperior.a.a;

public enum t {
    DEFAULT {
        public final l serialize(Long l) {
            return new q((Number) l);
        }
    },
    STRING {
        public final l serialize(Long l) {
            return new q(String.valueOf(l));
        }
    };

    public abstract l serialize(Long l);
}
