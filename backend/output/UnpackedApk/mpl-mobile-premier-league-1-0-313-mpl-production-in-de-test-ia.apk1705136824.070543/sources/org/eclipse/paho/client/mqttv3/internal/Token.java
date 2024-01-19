package org.eclipse.paho.client.mqttv3.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.PixmapIO.CIM;
import com.razorpay.AnalyticsConstants;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSuback;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class Token {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.Token";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, Token.class.getName());
    public IMqttActionListener callback = null;
    public IMqttAsyncClient client = null;
    public volatile boolean completed = false;
    public MqttException exception = null;
    public String key;
    public MqttMessage message = null;
    public int messageID = 0;
    public boolean notified = false;
    public boolean pendingComplete = false;
    public MqttWireMessage response = null;
    public Object responseLock = new Object();
    public boolean sent = false;
    public Object sentLock = new Object();
    public String[] topics = null;
    public Object userContext = null;

    public Token(String str) {
        log.setResourceName(str);
    }

    public boolean checkResult() throws MqttException {
        if (getException() == null) {
            return true;
        }
        throw getException();
    }

    public IMqttActionListener getActionCallback() {
        return this.callback;
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public MqttException getException() {
        return this.exception;
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        MqttWireMessage mqttWireMessage = this.response;
        return mqttWireMessage instanceof MqttSuback ? ((MqttSuback) mqttWireMessage).getGrantedQos() : iArr;
    }

    public String getKey() {
        return this.key;
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public MqttWireMessage getResponse() {
        return this.response;
    }

    public boolean getSessionPresent() {
        MqttWireMessage mqttWireMessage = this.response;
        if (mqttWireMessage instanceof MqttConnack) {
            return ((MqttConnack) mqttWireMessage).getSessionPresent();
        }
        return false;
    }

    public String[] getTopics() {
        return this.topics;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public MqttWireMessage getWireMessage() {
        return this.response;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public boolean isCompletePending() {
        return this.pendingComplete;
    }

    public boolean isInUse() {
        return getClient() != null && !isComplete();
    }

    public boolean isNotified() {
        return this.notified;
    }

    public void markComplete(MqttWireMessage mqttWireMessage, MqttException mqttException) {
        log.fine(CLASS_NAME, "markComplete", "404", new Object[]{getKey(), mqttWireMessage, mqttException});
        synchronized (this.responseLock) {
            if (mqttWireMessage instanceof MqttAck) {
                this.message = null;
            }
            this.pendingComplete = true;
            this.response = mqttWireMessage;
            this.exception = mqttException;
        }
    }

    public void notifyComplete() {
        log.fine(CLASS_NAME, "notifyComplete", "404", new Object[]{getKey(), this.response, this.exception});
        synchronized (this.responseLock) {
            if (this.exception != null || !this.pendingComplete) {
                this.pendingComplete = false;
            } else {
                this.completed = true;
                this.pendingComplete = false;
            }
            this.responseLock.notifyAll();
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void notifySent() {
        log.fine(CLASS_NAME, "notifySent", "403", new Object[]{getKey()});
        synchronized (this.responseLock) {
            this.response = null;
            this.completed = false;
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void reset() throws MqttException {
        if (!isInUse()) {
            log.fine(CLASS_NAME, AnalyticsConstants.RESET, "410", new Object[]{getKey()});
            this.client = null;
            this.completed = false;
            this.response = null;
            this.sent = false;
            this.exception = null;
            this.userContext = null;
            return;
        }
        throw new MqttException(32201);
    }

    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.callback = iMqttActionListener;
    }

    public void setClient(IMqttAsyncClient iMqttAsyncClient) {
        this.client = iMqttAsyncClient;
    }

    public void setException(MqttException mqttException) {
        synchronized (this.responseLock) {
            this.exception = mqttException;
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }

    public void setMessageID(int i) {
        this.messageID = i;
    }

    public void setNotified(boolean z) {
        this.notified = z;
    }

    public void setTopics(String[] strArr) {
        this.topics = strArr;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("key=");
        outline71.append(getKey());
        outline71.append(" ,topics=");
        if (getTopics() != null) {
            for (String append : getTopics()) {
                outline71.append(append);
                outline71.append(", ");
            }
        }
        outline71.append(" ,usercontext=");
        outline71.append(getUserContext());
        outline71.append(" ,isComplete=");
        outline71.append(isComplete());
        outline71.append(" ,isNotified=");
        outline71.append(isNotified());
        outline71.append(" ,exception=");
        outline71.append(getException());
        outline71.append(" ,actioncallback=");
        outline71.append(getActionCallback());
        return outline71.toString();
    }

    public void waitForCompletion() throws MqttException {
        waitForCompletion(-1);
    }

    public MqttWireMessage waitForResponse() throws MqttException {
        return waitForResponse(-1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:22|23|36|34|10|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0022 A[SYNTHETIC, Splitter:B:22:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitUntilSent() throws org.eclipse.paho.client.mqttv3.MqttException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.sentLock
            monitor-enter(r0)
            java.lang.Object r1 = r8.responseLock     // Catch:{ all -> 0x0044 }
            monitor-enter(r1)     // Catch:{ all -> 0x0044 }
            org.eclipse.paho.client.mqttv3.MqttException r2 = r8.exception     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x003e
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
        L_0x000b:
            boolean r1 = r8.sent     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0022
            boolean r1 = r8.sent     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0020
            org.eclipse.paho.client.mqttv3.MqttException r1 = r8.exception     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x001d
            r1 = 6
            org.eclipse.paho.client.mqttv3.MqttException r1 = org.eclipse.paho.client.mqttv3.internal.ExceptionHelper.createMqttException(r1)     // Catch:{ all -> 0x0044 }
            throw r1     // Catch:{ all -> 0x0044 }
        L_0x001d:
            org.eclipse.paho.client.mqttv3.MqttException r1 = r8.exception     // Catch:{ all -> 0x0044 }
            throw r1     // Catch:{ all -> 0x0044 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0022:
            org.eclipse.paho.client.mqttv3.logging.Logger r1 = log     // Catch:{ InterruptedException -> 0x000b }
            java.lang.String r2 = CLASS_NAME     // Catch:{ InterruptedException -> 0x000b }
            java.lang.String r3 = "waitUntilSent"
            java.lang.String r4 = "409"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ InterruptedException -> 0x000b }
            r6 = 0
            java.lang.String r7 = r8.getKey()     // Catch:{ InterruptedException -> 0x000b }
            r5[r6] = r7     // Catch:{ InterruptedException -> 0x000b }
            r1.fine(r2, r3, r4, r5)     // Catch:{ InterruptedException -> 0x000b }
            java.lang.Object r1 = r8.sentLock     // Catch:{ InterruptedException -> 0x000b }
            r1.wait()     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x000b
        L_0x003e:
            org.eclipse.paho.client.mqttv3.MqttException r2 = r8.exception     // Catch:{ all -> 0x0041 }
            throw r2     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            throw r2     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.Token.waitUntilSent():void");
    }

    public void waitForCompletion(long j) throws MqttException {
        log.fine(CLASS_NAME, "waitForCompletion", "407", new Object[]{getKey(), new Long(j), this});
        if (waitForResponse(j) != null || this.completed) {
            checkResult();
            return;
        }
        log.fine(CLASS_NAME, "waitForCompletion", "406", new Object[]{getKey(), this});
        MqttException mqttException = new MqttException((int) CIM.BUFFER_SIZE);
        this.exception = mqttException;
        throw mqttException;
    }

    public MqttWireMessage waitForResponse(long j) throws MqttException {
        synchronized (this.responseLock) {
            Logger logger = log;
            String str = CLASS_NAME;
            Object[] objArr = new Object[7];
            objArr[0] = getKey();
            objArr[1] = new Long(j);
            objArr[2] = new Boolean(this.sent);
            objArr[3] = new Boolean(this.completed);
            objArr[4] = this.exception == null ? BaseParser.FALSE : BaseParser.TRUE;
            objArr[5] = this.response;
            objArr[6] = this;
            logger.fine(str, "waitForResponse", "400", objArr, this.exception);
            while (true) {
                if (this.completed) {
                    break;
                }
                if (this.exception == null) {
                    try {
                        log.fine(CLASS_NAME, "waitForResponse", "408", new Object[]{getKey(), new Long(j)});
                        if (j <= 0) {
                            this.responseLock.wait();
                        } else {
                            this.responseLock.wait(j);
                        }
                    } catch (InterruptedException e2) {
                        this.exception = new MqttException((Throwable) e2);
                    }
                }
                if (!this.completed) {
                    if (this.exception != null) {
                        log.fine(CLASS_NAME, "waitForResponse", "401", null, this.exception);
                        throw this.exception;
                    } else if (j > 0) {
                        break;
                    }
                }
            }
        }
        log.fine(CLASS_NAME, "waitForResponse", "402", new Object[]{getKey(), this.response});
        return this.response;
    }
}
