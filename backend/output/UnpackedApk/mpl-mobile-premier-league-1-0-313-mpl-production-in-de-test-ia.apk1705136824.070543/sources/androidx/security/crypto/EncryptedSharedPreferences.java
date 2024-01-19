package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeysetManager.Builder;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EncryptedSharedPreferences implements SharedPreferences {
    public final String mFileName;
    public final DeterministicAead mKeyDeterministicAead;
    public final List<OnSharedPreferenceChangeListener> mListeners = new ArrayList();
    public final SharedPreferences mSharedPreferences;
    public final Aead mValueAead;

    public static final class Editor implements android.content.SharedPreferences.Editor {
        public AtomicBoolean mClearRequested = new AtomicBoolean(false);
        public final android.content.SharedPreferences.Editor mEditor;
        public final EncryptedSharedPreferences mEncryptedSharedPreferences;
        public final List<String> mKeysChanged;

        public Editor(EncryptedSharedPreferences encryptedSharedPreferences, android.content.SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
            this.mKeysChanged = new CopyOnWriteArrayList();
        }

        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        public android.content.SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        public final void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String str : ((HashMap) this.mEncryptedSharedPreferences.getAll()).keySet()) {
                    if (!this.mKeysChanged.contains(str) && !this.mEncryptedSharedPreferences.isReservedKey(str)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                    }
                }
            }
        }

        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        public final void notifyListeners() {
            for (OnSharedPreferenceChangeListener next : this.mEncryptedSharedPreferences.mListeners) {
                for (String onSharedPreferenceChanged : this.mKeysChanged) {
                    next.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, onSharedPreferenceChanged);
                }
            }
        }

        public android.content.SharedPreferences.Editor putBoolean(String str, boolean z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put(z ? (byte) 1 : 0);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public final void putEncryptedObject(String str, byte[] bArr) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mKeysChanged.add(str);
                if (str == null) {
                    str = "__NULL__";
                }
                try {
                    EncryptedSharedPreferences encryptedSharedPreferences = this.mEncryptedSharedPreferences;
                    String encryptKey = encryptedSharedPreferences.encryptKey(str);
                    Pair pair = new Pair(encryptKey, Base64.encode(encryptedSharedPreferences.mValueAead.encrypt(bArr, encryptKey.getBytes(StandardCharsets.UTF_8))));
                    this.mEditor.putString((String) pair.first, (String) pair.second);
                } catch (GeneralSecurityException e2) {
                    throw new SecurityException(GeneratedOutlineSupport.outline67(e2, GeneratedOutlineSupport.outline73("Could not encrypt data: ")), e2);
                }
            } else {
                throw new SecurityException(GeneratedOutlineSupport.outline50(str, " is a reserved key for the encryption keyset."));
            }
        }

        public android.content.SharedPreferences.Editor putFloat(String str, float f2) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(f2);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String str, int i) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(i);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String str, long j) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(j);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        public android.content.SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        /* JADX WARNING: type inference failed for: r6v1, types: [java.util.Set] */
        /* JADX WARNING: type inference failed for: r6v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.content.SharedPreferences.Editor putStringSet(java.lang.String r5, java.util.Set<java.lang.String> r6) {
            /*
                r4 = this;
                if (r6 != 0) goto L_0x000d
                androidx.collection.ArraySet r6 = new androidx.collection.ArraySet
                r0 = 0
                r6.<init>(r0)
                java.lang.String r0 = "__NULL__"
                r6.add(r0)
            L_0x000d:
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = r6.size()
                r0.<init>(r1)
                int r1 = r6.size()
                int r1 = r1 * 4
                java.util.Iterator r6 = r6.iterator()
            L_0x0020:
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L_0x0038
                java.lang.Object r2 = r6.next()
                java.lang.String r2 = (java.lang.String) r2
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
                byte[] r2 = r2.getBytes(r3)
                r0.add(r2)
                int r2 = r2.length
                int r1 = r1 + r2
                goto L_0x0020
            L_0x0038:
                int r1 = r1 + 4
                java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r1)
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET
                int r1 = r1.getId()
                r6.putInt(r1)
                java.util.Iterator r0 = r0.iterator()
            L_0x004b:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x005f
                java.lang.Object r1 = r0.next()
                byte[] r1 = (byte[]) r1
                int r2 = r1.length
                r6.putInt(r2)
                r6.put(r1)
                goto L_0x004b
            L_0x005f:
                byte[] r6 = r6.array()
                r4.putEncryptedObject(r5, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.security.crypto.EncryptedSharedPreferences.Editor.putStringSet(java.lang.String, java.util.Set):android.content.SharedPreferences$Editor");
        }

        public android.content.SharedPreferences.Editor remove(String str) {
            if (!this.mEncryptedSharedPreferences.isReservedKey(str)) {
                this.mEditor.remove(this.mEncryptedSharedPreferences.encryptKey(str));
                this.mKeysChanged.remove(str);
                return this;
            }
            throw new SecurityException(GeneratedOutlineSupport.outline50(str, " is a reserved key for the encryption keyset."));
        }
    }

    public enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        public final int mId;

        /* access modifiers changed from: public */
        EncryptedType(int i) {
            this.mId = i;
        }

        public static EncryptedType fromId(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return STRING_SET;
            }
            if (i == 2) {
                return INT;
            }
            if (i == 3) {
                return LONG;
            }
            if (i == 4) {
                return FLOAT;
            }
            if (i != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV(KeyTemplate.create("type.googleapis.com/google.crypto.tink.AesSivKey", ((AesSivKeyFormat) r2.build()).toByteArray(), r1));
        
        public final KeyTemplate mDeterministicAeadKeyTemplate;

        /* access modifiers changed from: public */
        PrefKeyEncryptionScheme(KeyTemplate keyTemplate) {
            this.mDeterministicAeadKeyTemplate = keyTemplate;
        }

        public KeyTemplate getKeyTemplate() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM(KeyTemplate.create("type.googleapis.com/google.crypto.tink.AesGcmKey", ((AesGcmKeyFormat) r2.build()).toByteArray(), r1));
        
        public final KeyTemplate mAeadKeyTemplate;

        /* access modifiers changed from: public */
        PrefValueEncryptionScheme(KeyTemplate keyTemplate) {
            this.mAeadKeyTemplate = keyTemplate;
        }

        public KeyTemplate getKeyTemplate() {
            return this.mAeadKeyTemplate;
        }
    }

    public EncryptedSharedPreferences(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.mFileName = str;
        this.mSharedPreferences = sharedPreferences;
        this.mValueAead = aead;
        this.mKeyDeterministicAead = deterministicAead;
    }

    public static SharedPreferences create(Context context, String str, MasterKey masterKey, PrefKeyEncryptionScheme prefKeyEncryptionScheme, PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        KeysetHandle keysetHandle;
        KeysetHandle keysetHandle2;
        String str2 = masterKey.mKeyAlias;
        DeterministicAeadConfig.register();
        AeadConfig.register();
        Context applicationContext = context.getApplicationContext();
        Builder builder = new Builder();
        builder.keyTemplate = prefKeyEncryptionScheme.getKeyTemplate();
        builder.withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        builder.withMasterKeyUri("android-keystore://" + str2);
        AndroidKeysetManager build = builder.build();
        synchronized (build) {
            keysetHandle = build.keysetManager.getKeysetHandle();
        }
        Builder builder2 = new Builder();
        builder2.keyTemplate = prefValueEncryptionScheme.getKeyTemplate();
        builder2.withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        builder2.withMasterKeyUri("android-keystore://" + str2);
        AndroidKeysetManager build2 = builder2.build();
        synchronized (build2) {
            keysetHandle2 = build2.keysetManager.getKeysetHandle();
        }
        Aead aead = (Aead) keysetHandle2.getPrimitive(Aead.class);
        String str3 = str;
        EncryptedSharedPreferences encryptedSharedPreferences = new EncryptedSharedPreferences(str3, str2, applicationContext.getSharedPreferences(str, 0), aead, (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
        return encryptedSharedPreferences;
    }

    public boolean contains(String str) {
        if (!isReservedKey(str)) {
            return this.mSharedPreferences.contains(encryptKey(str));
        }
        throw new SecurityException(GeneratedOutlineSupport.outline50(str, " is a reserved key for the encryption keyset."));
    }

    public android.content.SharedPreferences.Editor edit() {
        return new Editor(this, this.mSharedPreferences.edit());
    }

    public String encryptKey(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return Base64.encode(this.mKeyDeterministicAead.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.mFileName.getBytes()));
        } catch (GeneralSecurityException e2) {
            throw new SecurityException(GeneratedOutlineSupport.outline67(e2, GeneratedOutlineSupport.outline73("Could not encrypt key. ")), e2);
        }
    }

    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Entry next : this.mSharedPreferences.getAll().entrySet()) {
            if (!isReservedKey((String) next.getKey())) {
                try {
                    String str = new String(this.mKeyDeterministicAead.decryptDeterministically(Base64.decode((String) next.getKey(), 0), this.mFileName.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    hashMap.put(str, getDecryptedObject(str));
                } catch (GeneralSecurityException e2) {
                    throw new SecurityException(GeneratedOutlineSupport.outline67(e2, GeneratedOutlineSupport.outline73("Could not decrypt key. ")), e2);
                }
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Boolean)) ? z : ((Boolean) decryptedObject).booleanValue();
    }

    public final Object getDecryptedObject(String str) {
        if (!isReservedKey(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String encryptKey = encryptKey(str);
                String string = this.mSharedPreferences.getString(encryptKey, null);
                if (string == null) {
                    return null;
                }
                boolean z = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.mValueAead.decrypt(Base64.decode(string, 0), encryptKey.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                int ordinal = EncryptedType.fromId(wrap.getInt()).ordinal();
                if (ordinal == 0) {
                    int i = wrap.getInt();
                    ByteBuffer slice = wrap.slice();
                    wrap.limit(i);
                    String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                    if (charBuffer.equals("__NULL__")) {
                        return null;
                    }
                    return charBuffer;
                } else if (ordinal == 1) {
                    ArraySet arraySet = new ArraySet(0);
                    while (wrap.hasRemaining()) {
                        int i2 = wrap.getInt();
                        ByteBuffer slice2 = wrap.slice();
                        slice2.limit(i2);
                        wrap.position(wrap.position() + i2);
                        arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                    }
                    if (arraySet.mSize != 1 || !"__NULL__".equals(arraySet.mArray[0])) {
                        return arraySet;
                    }
                    return null;
                } else if (ordinal == 2) {
                    return Integer.valueOf(wrap.getInt());
                } else {
                    if (ordinal == 3) {
                        return Long.valueOf(wrap.getLong());
                    }
                    if (ordinal == 4) {
                        return Float.valueOf(wrap.getFloat());
                    }
                    if (ordinal != 5) {
                        return null;
                    }
                    if (wrap.get() != 0) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } catch (GeneralSecurityException e2) {
                throw new SecurityException(GeneratedOutlineSupport.outline67(e2, GeneratedOutlineSupport.outline73("Could not decrypt value. ")), e2);
            }
        } else {
            throw new SecurityException(GeneratedOutlineSupport.outline50(str, " is a reserved key for the encryption keyset."));
        }
    }

    public float getFloat(String str, float f2) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Float)) ? f2 : ((Float) decryptedObject).floatValue();
    }

    public int getInt(String str, int i) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Integer)) ? i : ((Integer) decryptedObject).intValue();
    }

    public long getLong(String str, long j) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof Long)) ? j : ((Long) decryptedObject).longValue();
    }

    public String getString(String str, String str2) {
        Object decryptedObject = getDecryptedObject(str);
        return (decryptedObject == null || !(decryptedObject instanceof String)) ? str2 : (String) decryptedObject;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set set2;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            set2 = (Set) decryptedObject;
        } else {
            set2 = new ArraySet(0);
        }
        return set2.size() > 0 ? set2 : set;
    }

    public boolean isReservedKey(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mListeners.remove(onSharedPreferenceChangeListener);
    }
}
