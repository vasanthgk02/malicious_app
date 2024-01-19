package org.jboss.netty.channel.local;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.SocketAddress;

public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final String EPHEMERAL = "ephemeral";
    public static final long serialVersionUID = -3601961747680808645L;
    public final boolean ephemeral;
    public final String id;

    public LocalAddress(int i) {
        this(String.valueOf(i));
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof LocalAddress)) {
            return false;
        }
        if (!this.ephemeral) {
            return getId().equals(((LocalAddress) obj).getId());
        }
        if (this == obj) {
            z = true;
        }
        return z;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        if (this.ephemeral) {
            return System.identityHashCode(this);
        }
        return this.id.hashCode();
    }

    public boolean isEphemeral() {
        return this.ephemeral;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("local:");
        outline73.append(getId());
        return outline73.toString();
    }

    public LocalAddress(String str) {
        if (str != null) {
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() != 0) {
                this.id = lowerCase;
                this.ephemeral = lowerCase.equals(EPHEMERAL);
                return;
            }
            throw new IllegalArgumentException("empty id");
        }
        throw new NullPointerException("id");
    }

    public int compareTo(LocalAddress localAddress) {
        if (this.ephemeral) {
            if (!localAddress.ephemeral) {
                return 1;
            }
            if (this == localAddress) {
                return 0;
            }
            int identityHashCode = System.identityHashCode(this);
            int identityHashCode2 = System.identityHashCode(this);
            if (identityHashCode < identityHashCode2) {
                return -1;
            }
            if (identityHashCode > identityHashCode2) {
                return 1;
            }
            throw new Error("Two different ephemeral addresses have same identityHashCode.");
        } else if (localAddress.ephemeral) {
            return -1;
        } else {
            return getId().compareTo(localAddress.getId());
        }
    }
}
