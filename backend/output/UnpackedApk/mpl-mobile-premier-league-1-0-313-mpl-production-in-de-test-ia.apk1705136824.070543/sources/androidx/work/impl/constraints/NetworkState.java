package androidx.work.impl.constraints;

public class NetworkState {
    public boolean mIsConnected;
    public boolean mIsMetered;
    public boolean mIsNotRoaming;
    public boolean mIsValidated;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.mIsConnected = z;
        this.mIsValidated = z2;
        this.mIsMetered = z3;
        this.mIsNotRoaming = z4;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (!(this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.mIsConnected ? 1 : 0;
        if (this.mIsValidated) {
            i += 16;
        }
        if (this.mIsMetered) {
            i += 256;
        }
        return this.mIsNotRoaming ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming)});
    }
}
