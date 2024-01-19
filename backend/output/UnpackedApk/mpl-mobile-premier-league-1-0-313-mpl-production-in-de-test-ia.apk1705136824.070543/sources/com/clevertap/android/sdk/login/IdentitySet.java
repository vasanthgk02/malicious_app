package com.clevertap.android.sdk.login;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Utils;
import java.util.HashSet;
import java.util.Iterator;

public class IdentitySet {
    public final HashSet<String> identities;

    public IdentitySet(String[] strArr) {
        this.identities = new HashSet<>();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (Utils.containsIgnoreCase(Constants.ALL_IDENTITY_KEYS, str)) {
                    HashSet<String> hashSet = this.identities;
                    if (str != null && !str.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        boolean z = true;
                        for (char c2 : str.toCharArray()) {
                            if (Character.isSpaceChar(c2)) {
                                z = true;
                            } else if (z) {
                                c2 = Character.toTitleCase(c2);
                                z = false;
                            } else {
                                c2 = Character.toLowerCase(c2);
                            }
                            sb.append(c2);
                        }
                        str = sb.toString();
                    }
                    hashSet.add(str);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IdentitySet.class != obj.getClass()) {
            return false;
        }
        return this.identities.equals(((IdentitySet) obj).identities);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isValid() {
        return !this.identities.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.identities.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (Constants.ALL_IDENTITY_KEYS.contains(next)) {
                sb.append(next);
                sb.append(it.hasNext() ? "," : "");
            }
        }
        return sb.toString();
    }

    public IdentitySet(HashSet<String> hashSet) {
        HashSet<String> hashSet2 = new HashSet<>();
        this.identities = hashSet2;
        hashSet2.addAll(hashSet);
    }
}
