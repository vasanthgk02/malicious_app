package com.google.firebase.installations.local;

import com.google.firebase.FirebaseApp;
import com.mpl.androidapp.utils.GameConstant;
import io.sentry.cache.EnvelopeCache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistedInstallation {
    public File dataFile;
    public final FirebaseApp firebaseApp;

    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(FirebaseApp firebaseApp2) {
        this.firebaseApp = firebaseApp2;
    }

    public final File getDataFile() {
        if (this.dataFile == null) {
            synchronized (this) {
                if (this.dataFile == null) {
                    FirebaseApp firebaseApp2 = this.firebaseApp;
                    firebaseApp2.checkNotDeleted();
                    File filesDir = firebaseApp2.applicationContext.getFilesDir();
                    this.dataFile = new File(filesDir, "PersistedInstallation." + this.firebaseApp.getPersistenceKey() + EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE);
                }
            }
        }
        return this.dataFile;
    }

    public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).firebaseInstallationId);
            jSONObject.put("Status", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).registrationStatus.ordinal());
            jSONObject.put(GameConstant.AUTH_TOKEN, ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).authToken);
            jSONObject.put("RefreshToken", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).refreshToken);
            jSONObject.put("TokenCreationEpochInSecs", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).tokenCreationEpochInSecs);
            jSONObject.put("ExpiresInSecs", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).expiresInSecs);
            jSONObject.put("FisError", ((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).fisError);
            FirebaseApp firebaseApp2 = this.firebaseApp;
            firebaseApp2.checkNotDeleted();
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", firebaseApp2.applicationContext.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (createTempFile.renameTo(getDataFile())) {
                return persistedInstallationEntry;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r1 = new org.json.JSONObject();
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[ExcHandler: IOException | JSONException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.installations.local.PersistedInstallationEntry readPersistedInstallationEntryValue() {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException | JSONException -> 0x0034 }
            java.io.File r5 = r11.getDataFile()     // Catch:{ IOException | JSONException -> 0x0034 }
            r4.<init>(r5)     // Catch:{ IOException | JSONException -> 0x0034 }
        L_0x0013:
            int r5 = r4.read(r2, r3, r1)     // Catch:{ all -> 0x002a }
            if (r5 >= 0) goto L_0x0026
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002a }
            r1.<init>(r0)     // Catch:{ all -> 0x002a }
            r4.close()     // Catch:{ IOException | JSONException -> 0x0034 }
            goto L_0x0039
        L_0x0026:
            r0.write(r2, r3, r5)     // Catch:{ all -> 0x002a }
            goto L_0x0013
        L_0x002a:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r1 = move-exception
            r0.addSuppressed(r1)     // Catch:{ IOException | JSONException -> 0x0034 }
        L_0x0033:
            throw r0     // Catch:{ IOException | JSONException -> 0x0034 }
        L_0x0034:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
        L_0x0039:
            r0 = 0
            java.lang.String r2 = "Fid"
            java.lang.String r2 = r1.optString(r2, r0)
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r4 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION
            java.lang.String r4 = "Status"
            int r3 = r1.optInt(r4, r3)
            java.lang.String r4 = "AuthToken"
            java.lang.String r4 = r1.optString(r4, r0)
            java.lang.String r5 = "RefreshToken"
            java.lang.String r5 = r1.optString(r5, r0)
            r6 = 0
            java.lang.String r8 = "TokenCreationEpochInSecs"
            long r8 = r1.optLong(r8, r6)
            java.lang.String r10 = "ExpiresInSecs"
            long r6 = r1.optLong(r10, r6)
            java.lang.String r10 = "FisError"
            java.lang.String r0 = r1.optString(r10, r0)
            com.google.firebase.installations.local.PersistedInstallationEntry$Builder r1 = com.google.firebase.installations.local.PersistedInstallationEntry.builder()
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r1 = (com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry.Builder) r1
            r1.firebaseInstallationId = r2
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus[] r2 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.values()
            r2 = r2[r3]
            r1.setRegistrationStatus(r2)
            r1.authToken = r4
            r1.refreshToken = r5
            r1.setTokenCreationEpochInSecs(r8)
            r1.setExpiresInSecs(r6)
            r1.fisError = r0
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r1.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.PersistedInstallation.readPersistedInstallationEntryValue():com.google.firebase.installations.local.PersistedInstallationEntry");
    }
}
