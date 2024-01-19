package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.EngineWrapper.TCipher;
import com.google.crypto.tink.subtle.EngineWrapper.TMac;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {
    public static final EngineFactory<TCipher, Cipher> CIPHER = new EngineFactory<>(new TCipher());
    public static final EngineFactory<TMac, Mac> MAC = new EngineFactory<>(new TMac());
    public static final List<Provider> defaultPolicy;
    public static final Logger logger = Logger.getLogger(EngineFactory.class.getName());
    public T_WRAPPER instanceBuilder;
    public boolean letFallback = true;
    public List<Provider> policy = defaultPolicy;

    static {
        if (TextAppearanceConfig.isAndroid()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.info(String.format("Provider %s not available", new Object[]{str}));
                }
            }
            defaultPolicy = arrayList;
        } else {
            defaultPolicy = new ArrayList();
        }
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        this.instanceBuilder = t_wrapper;
    }

    public T_ENGINE getInstance(String str) throws GeneralSecurityException {
        Throwable th = null;
        for (Provider instance : this.policy) {
            try {
                return this.instanceBuilder.getInstance(str, instance);
            } catch (Exception e2) {
                if (th == null) {
                    th = e2;
                }
            }
        }
        if (this.letFallback) {
            return this.instanceBuilder.getInstance(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", th);
    }
}
