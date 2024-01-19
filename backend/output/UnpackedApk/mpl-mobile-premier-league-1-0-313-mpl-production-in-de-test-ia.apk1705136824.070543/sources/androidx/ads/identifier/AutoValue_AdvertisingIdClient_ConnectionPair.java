package androidx.ads.identifier;

import androidx.ads.identifier.AdvertisingIdClient.ConnectionPair;
import androidx.ads.identifier.internal.HoldingConnectionClient;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_AdvertisingIdClient_ConnectionPair extends ConnectionPair {
    public final HoldingConnectionClient connectionClient;
    public final long connectionId;

    public AutoValue_AdvertisingIdClient_ConnectionPair(HoldingConnectionClient holdingConnectionClient, long j) {
        if (holdingConnectionClient != null) {
            this.connectionClient = holdingConnectionClient;
            this.connectionId = j;
            return;
        }
        throw new NullPointerException("Null connectionClient");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionPair)) {
            return false;
        }
        AutoValue_AdvertisingIdClient_ConnectionPair autoValue_AdvertisingIdClient_ConnectionPair = (AutoValue_AdvertisingIdClient_ConnectionPair) ((ConnectionPair) obj);
        if (!this.connectionClient.equals(autoValue_AdvertisingIdClient_ConnectionPair.connectionClient) || this.connectionId != autoValue_AdvertisingIdClient_ConnectionPair.connectionId) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.connectionId;
        return ((this.connectionClient.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConnectionPair{connectionClient=");
        outline73.append(this.connectionClient);
        outline73.append(", connectionId=");
        return GeneratedOutlineSupport.outline58(outline73, this.connectionId, "}");
    }
}
