package com.google.firebase.installations.local;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus;

public abstract class PersistedInstallationEntry {

    public static abstract class Builder {
        public abstract PersistedInstallationEntry build();

        public abstract Builder setExpiresInSecs(long j);

        public abstract Builder setRegistrationStatus(RegistrationStatus registrationStatus);

        public abstract Builder setTokenCreationEpochInSecs(long j);
    }

    static {
        Long valueOf = Long.valueOf(0);
        if (RegistrationStatus.ATTEMPT_MIGRATION != null) {
            String str = "";
            if (valueOf == null) {
                str = GeneratedOutlineSupport.outline50(str, " expiresInSecs");
            }
            if (valueOf == null) {
                str = GeneratedOutlineSupport.outline50(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                valueOf.longValue();
                valueOf.longValue();
                return;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }
        throw new NullPointerException("Null registrationStatus");
    }

    public static Builder builder() {
        com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder builder = new com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder();
        builder.setTokenCreationEpochInSecs(0);
        builder.setRegistrationStatus(RegistrationStatus.ATTEMPT_MIGRATION);
        builder.setExpiresInSecs(0);
        return builder;
    }

    public boolean isErrored() {
        return ((AutoValue_PersistedInstallationEntry) this).registrationStatus == RegistrationStatus.REGISTER_ERROR;
    }

    public boolean isNotGenerated() {
        RegistrationStatus registrationStatus = ((AutoValue_PersistedInstallationEntry) this).registrationStatus;
        return registrationStatus == RegistrationStatus.NOT_GENERATED || registrationStatus == RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean isRegistered() {
        return ((AutoValue_PersistedInstallationEntry) this).registrationStatus == RegistrationStatus.REGISTERED;
    }

    public abstract Builder toBuilder();
}
