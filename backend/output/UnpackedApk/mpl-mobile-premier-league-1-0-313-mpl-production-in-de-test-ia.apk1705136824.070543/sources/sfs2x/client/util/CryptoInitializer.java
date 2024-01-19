package sfs2x.client.util;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.netcore.android.SMTEventParamKeys;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.core.SFSEvent;

public class CryptoInitializer {
    public static final String KEY_SESSION_TOKEN = "SessToken";
    public static final String TARGET_SERVLET = "/BlueBox/CryptoManager";
    public final ISmartFox sfs;
    public ICryptoStorage storage;
    public final Thread thread;

    public final class CryptoInitRunner implements Runnable {
        public CryptoInitRunner() {
        }

        public void run() {
            try {
                String str = "SessToken=" + URLEncoder.encode(CryptoInitializer.this.sfs.getSessionToken(), "UTF-8");
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://" + CryptoInitializer.this.storage.getHttpHost() + ":" + CryptoInitializer.this.storage.getHttpPort() + CryptoInitializer.TARGET_SERVLET).openConnection()));
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.length()));
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(str);
                dataOutputStream.close();
                DataInputStream dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = dataInputStream.read();
                    if (read == -1) {
                        dataInputStream.close();
                        CryptoInitializer.this.onHttpResponse(sb.toString());
                        return;
                    }
                    sb.append((char) read);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                CryptoInitializer.this.onHttpError(e2.getMessage());
            }
        }

        public /* synthetic */ CryptoInitRunner(CryptoInitializer cryptoInitializer, CryptoInitRunner cryptoInitRunner) {
            this();
        }
    }

    public final class DefaultCryptoKeyStorage implements ICryptoStorage {
        public DefaultCryptoKeyStorage() {
        }

        public String getHttpHost() {
            return CryptoInitializer.this.sfs.getConfig().getHost();
        }

        public int getHttpPort() {
            return CryptoInitializer.this.sfs.getConfig().getHttpsPort();
        }

        public CryptoKey getKey() {
            return CryptoInitializer.this.sfs.getSocketEngine().getCryptoKey();
        }

        public void setKey(CryptoKey cryptoKey) {
            CryptoInitializer.this.sfs.getSocketEngine().setCryptoKey(cryptoKey);
        }

        public /* synthetic */ DefaultCryptoKeyStorage(CryptoInitializer cryptoInitializer, DefaultCryptoKeyStorage defaultCryptoKeyStorage) {
            this();
        }
    }

    public CryptoInitializer(ISmartFox iSmartFox) {
        this(iSmartFox, null);
    }

    /* access modifiers changed from: private */
    public void onHttpError(String str) {
        Logger logger = this.sfs.getLogger();
        logger.warn("Cryptography Init Error: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.FALSE);
        hashMap.put(SMTEventParamKeys.SMT_EVENT_CRASH_MESSAGE, str);
        this.sfs.getDispatcher().dispatchEvent(new SFSEvent(SFSEvent.CRYPTO_INIT, hashMap));
    }

    /* access modifiers changed from: private */
    public void onHttpResponse(String str) {
        try {
            this.storage.setKey(new CryptoKey(Base64.decode(str)));
            HashMap hashMap = new HashMap();
            hashMap.put("success", Boolean.TRUE);
            this.sfs.getDispatcher().dispatchEvent(new SFSEvent(SFSEvent.CRYPTO_INIT, hashMap));
        } catch (IOException e2) {
            onHttpError(e2.getMessage());
        }
    }

    public void setCryptoStorageWrapper(ICryptoStorage iCryptoStorage) {
        this.storage = iCryptoStorage;
    }

    public CryptoInitializer(ISmartFox iSmartFox, ICryptoStorage iCryptoStorage) {
        this.storage = new DefaultCryptoKeyStorage(this, null);
        this.sfs = iSmartFox;
        if (iSmartFox.isConnected()) {
            if (iCryptoStorage != null) {
                this.storage = iCryptoStorage;
            }
            if (this.storage.getKey() == null) {
                Thread thread2 = new Thread(new CryptoInitRunner(this, null), "CryptoInitThread");
                this.thread = thread2;
                thread2.start();
                return;
            }
            throw new IllegalStateException("Cryptography is already initialized!");
        }
        throw new IllegalStateException("Cryptography cannot be initialized before connecting to SmartFoxServer!");
    }
}
