package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public enum c {
    SIGN("sign"),
    VERIFY("verify"),
    ENCRYPT("encrypt"),
    DECRYPT("decrypt"),
    WRAP_KEY("wrapKey"),
    UNWRAP_KEY("unwrapKey"),
    DERIVE_KEY("deriveKey"),
    DERIVE_BITS("deriveBits");
    
    public final String identifier;

    /* access modifiers changed from: public */
    c(String str) {
        if (str != null) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException("The key operation identifier must not be null");
    }

    public static Set<c> a(List<String> list) {
        c cVar;
        if (list == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String next : list) {
            if (next != null) {
                c[] values = values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        cVar = null;
                        break;
                    }
                    cVar = values[i];
                    if (next.equals(cVar.a())) {
                        break;
                    }
                    i++;
                }
                if (cVar != null) {
                    linkedHashSet.add(cVar);
                } else {
                    throw new ParseException(GeneratedOutlineSupport.outline50("Invalid JWK operation: ", next), 0);
                }
            }
        }
        return linkedHashSet;
    }

    public String a() {
        return this.identifier;
    }

    public String toString() {
        return a();
    }
}
