package com.google.firebase.installations.local;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus;

public final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {
    public final String authToken;
    public final long expiresInSecs;
    public final String firebaseInstallationId;
    public final String fisError;
    public final String refreshToken;
    public final RegistrationStatus registrationStatus;
    public final long tokenCreationEpochInSecs;

    public static final class Builder extends com.google.firebase.installations.local.PersistedInstallationEntry.Builder {
        public String authToken;
        public Long expiresInSecs;
        public String firebaseInstallationId;
        public String fisError;
        public String refreshToken;
        public RegistrationStatus registrationStatus;
        public Long tokenCreationEpochInSecs;

        public Builder() {
        }

        public PersistedInstallationEntry build() {
            String str = this.registrationStatus == null ? " registrationStatus" : "";
            if (this.expiresInSecs == null) {
                str = GeneratedOutlineSupport.outline50(str, " expiresInSecs");
            }
            if (this.tokenCreationEpochInSecs == null) {
                str = GeneratedOutlineSupport.outline50(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError, null);
                return autoValue_PersistedInstallationEntry;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setExpiresInSecs(long j) {
            this.expiresInSecs = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setRegistrationStatus(RegistrationStatus registrationStatus2) {
            if (registrationStatus2 != null) {
                this.registrationStatus = registrationStatus2;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public com.google.firebase.installations.local.PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j) {
            this.tokenCreationEpochInSecs = Long.valueOf(j);
            return this;
        }

        public Builder(PersistedInstallationEntry persistedInstallationEntry, AnonymousClass1 r4) {
            AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
            this.firebaseInstallationId = autoValue_PersistedInstallationEntry.firebaseInstallationId;
            this.registrationStatus = autoValue_PersistedInstallationEntry.registrationStatus;
            this.authToken = autoValue_PersistedInstallationEntry.authToken;
            this.refreshToken = autoValue_PersistedInstallationEntry.refreshToken;
            this.expiresInSecs = Long.valueOf(autoValue_PersistedInstallationEntry.expiresInSecs);
            this.tokenCreationEpochInSecs = Long.valueOf(autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            this.fisError = autoValue_PersistedInstallationEntry.fisError;
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, RegistrationStatus registrationStatus2, String str2, String str3, long j, long j2, String str4, AnonymousClass1 r10) {
        this.firebaseInstallationId = str;
        this.registrationStatus = registrationStatus2;
        this.authToken = str2;
        this.refreshToken = str3;
        this.expiresInSecs = j;
        this.tokenCreationEpochInSecs = j2;
        this.fisError = str4;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str = this.firebaseInstallationId;
        if (str != null ? str.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId == null) {
            if (this.registrationStatus.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).registrationStatus)) {
                String str2 = this.authToken;
                if (str2 != null ? str2.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).authToken) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).authToken == null) {
                    String str3 = this.refreshToken;
                    if (str3 != null ? str3.equals(((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).refreshToken) : ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).refreshToken == null) {
                        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
                        if (this.expiresInSecs == autoValue_PersistedInstallationEntry.expiresInSecs && this.tokenCreationEpochInSecs == autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs) {
                            String str4 = this.fisError;
                            if (str4 != null) {
                            }
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        String str = this.firebaseInstallationId;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.registrationStatus.hashCode()) * 1000003;
        String str2 = this.authToken;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.expiresInSecs;
        long j2 = this.tokenCreationEpochInSecs;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.fisError;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    public com.google.firebase.installations.local.PersistedInstallationEntry.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PersistedInstallationEntry{firebaseInstallationId=");
        outline73.append(this.firebaseInstallationId);
        outline73.append(", registrationStatus=");
        outline73.append(this.registrationStatus);
        outline73.append(", authToken=");
        outline73.append(this.authToken);
        outline73.append(", refreshToken=");
        outline73.append(this.refreshToken);
        outline73.append(", expiresInSecs=");
        outline73.append(this.expiresInSecs);
        outline73.append(", tokenCreationEpochInSecs=");
        outline73.append(this.tokenCreationEpochInSecs);
        outline73.append(", fisError=");
        return GeneratedOutlineSupport.outline62(outline73, this.fisError, "}");
    }
}
