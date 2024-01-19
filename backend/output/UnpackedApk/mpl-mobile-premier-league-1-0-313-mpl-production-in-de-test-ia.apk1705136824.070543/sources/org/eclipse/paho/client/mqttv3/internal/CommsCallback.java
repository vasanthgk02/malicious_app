package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import sfs2x.client.core.SFSEvent;

public class CommsCallback implements Runnable {
    public static final String CLASS_NAME;
    public static final int INBOUND_QUEUE_SIZE = 10;
    public static final Logger log;
    public Future callbackFuture;
    public Thread callbackThread;
    public Hashtable callbacks;
    public ClientComms clientComms;
    public ClientState clientState;
    public Vector completeQueue;
    public Object lifecycle = new Object();
    public boolean manualAcks = false;
    public Vector messageQueue;
    public MqttCallback mqttCallback;
    public boolean quiescing = false;
    public MqttCallbackExtended reconnectInternalCallback;
    public boolean running = false;
    public final Semaphore runningSemaphore = new Semaphore(1);
    public Object spaceAvailable = new Object();
    public String threadName;
    public Object workAvailable = new Object();

    static {
        String name = CommsCallback.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public CommsCallback(ClientComms clientComms2) {
        this.clientComms = clientComms2;
        this.messageQueue = new Vector(10);
        this.completeQueue = new Vector(10);
        this.callbacks = new Hashtable();
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    private void handleActionComplete(MqttToken mqttToken) throws MqttException {
        synchronized (mqttToken) {
            log.fine(CLASS_NAME, "handleActionComplete", "705", new Object[]{mqttToken.internalTok.getKey()});
            if (mqttToken.isComplete()) {
                this.clientState.notifyComplete(mqttToken);
            }
            mqttToken.internalTok.notifyComplete();
            if (!mqttToken.internalTok.isNotified()) {
                if (this.mqttCallback != null && (mqttToken instanceof MqttDeliveryToken) && mqttToken.isComplete()) {
                    this.mqttCallback.deliveryComplete((MqttDeliveryToken) mqttToken);
                }
                fireActionEvent(mqttToken);
            }
            if (mqttToken.isComplete() && ((mqttToken instanceof MqttDeliveryToken) || (mqttToken.getActionCallback() instanceof IMqttActionListener))) {
                mqttToken.internalTok.setNotified(true);
            }
        }
    }

    private void handleMessage(MqttPublish mqttPublish) throws MqttException, Exception {
        String topicName = mqttPublish.getTopicName();
        log.fine(CLASS_NAME, "handleMessage", "713", new Object[]{new Integer(mqttPublish.getMessageId()), topicName});
        deliverMessage(topicName, mqttPublish.getMessageId(), mqttPublish.getMessage());
        if (this.manualAcks) {
            return;
        }
        if (mqttPublish.getMessage().getQos() == 1) {
            this.clientComms.internalSend(new MqttPubAck(mqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (mqttPublish.getMessage().getQos() == 2) {
            this.clientComms.deliveryComplete(mqttPublish);
            MqttPubComp mqttPubComp = new MqttPubComp(mqttPublish);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
    }

    public void asyncOperationComplete(MqttToken mqttToken) {
        if (this.running) {
            this.completeQueue.addElement(mqttToken);
            synchronized (this.workAvailable) {
                log.fine(CLASS_NAME, "asyncOperationComplete", "715", new Object[]{mqttToken.internalTok.getKey()});
                this.workAvailable.notifyAll();
            }
            return;
        }
        try {
            handleActionComplete(mqttToken);
        } catch (Throwable th) {
            log.fine(CLASS_NAME, "asyncOperationComplete", "719", null, th);
            this.clientComms.shutdownConnection(null, new MqttException(th));
        }
    }

    public void connectionLost(MqttException mqttException) {
        try {
            if (!(this.mqttCallback == null || mqttException == null)) {
                log.fine(CLASS_NAME, SFSEvent.CONNECTION_LOST, "708", new Object[]{mqttException});
                this.mqttCallback.connectionLost(mqttException);
            }
            if (this.reconnectInternalCallback != null && mqttException != null) {
                this.reconnectInternalCallback.connectionLost(mqttException);
            }
        } catch (Throwable th) {
            log.fine(CLASS_NAME, SFSEvent.CONNECTION_LOST, "720", new Object[]{th});
        }
    }

    public boolean deliverMessage(String str, int i, MqttMessage mqttMessage) throws Exception {
        Enumeration keys = this.callbacks.keys();
        boolean z = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (MqttTopic.isMatched(str2, str)) {
                mqttMessage.setId(i);
                ((IMqttMessageListener) this.callbacks.get(str2)).messageArrived(str, mqttMessage);
                z = true;
            }
        }
        if (this.mqttCallback == null || z) {
            return z;
        }
        mqttMessage.setId(i);
        this.mqttCallback.messageArrived(str, mqttMessage);
        return true;
    }

    public void fireActionEvent(MqttToken mqttToken) {
        if (mqttToken != null) {
            IMqttActionListener actionCallback = mqttToken.getActionCallback();
            if (actionCallback == null) {
                return;
            }
            if (mqttToken.getException() == null) {
                log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
                actionCallback.onSuccess(mqttToken);
                return;
            }
            log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
            actionCallback.onFailure(mqttToken, mqttToken.getException());
        }
    }

    public Thread getThread() {
        return this.callbackThread;
    }

    public boolean isQuiesced() {
        return this.quiescing && this.completeQueue.size() == 0 && this.messageQueue.size() == 0;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000f A[LOOP:0: B:6:0x000f->B:33:0x000f, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void messageArrived(org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish r6) {
        /*
            r5 = this;
            org.eclipse.paho.client.mqttv3.MqttCallback r0 = r5.mqttCallback
            if (r0 != 0) goto L_0x000c
            java.util.Hashtable r0 = r5.callbacks
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0057
        L_0x000c:
            java.lang.Object r0 = r5.spaceAvailable
            monitor-enter(r0)
        L_0x000f:
            boolean r1 = r5.running     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0035
            boolean r1 = r5.quiescing     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0035
            java.util.Vector r1 = r5.messageQueue     // Catch:{ all -> 0x0058 }
            int r1 = r1.size()     // Catch:{ all -> 0x0058 }
            r2 = 10
            if (r1 >= r2) goto L_0x0022
            goto L_0x0035
        L_0x0022:
            org.eclipse.paho.client.mqttv3.logging.Logger r1 = log     // Catch:{ InterruptedException -> 0x000f }
            java.lang.String r2 = CLASS_NAME     // Catch:{ InterruptedException -> 0x000f }
            java.lang.String r3 = "messageArrived"
            java.lang.String r4 = "709"
            r1.fine(r2, r3, r4)     // Catch:{ InterruptedException -> 0x000f }
            java.lang.Object r1 = r5.spaceAvailable     // Catch:{ InterruptedException -> 0x000f }
            r2 = 200(0xc8, double:9.9E-322)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x000f
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            boolean r0 = r5.quiescing
            if (r0 != 0) goto L_0x0057
            java.util.Vector r0 = r5.messageQueue
            r0.addElement(r6)
            java.lang.Object r6 = r5.workAvailable
            monitor-enter(r6)
            org.eclipse.paho.client.mqttv3.logging.Logger r0 = log     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = CLASS_NAME     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "messageArrived"
            java.lang.String r3 = "710"
            r0.fine(r1, r2, r3)     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r5.workAvailable     // Catch:{ all -> 0x0054 }
            r0.notifyAll()     // Catch:{ all -> 0x0054 }
            monitor-exit(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            return
        L_0x0058:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.CommsCallback.messageArrived(org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish):void");
    }

    public void messageArrivedComplete(int i, int i2) throws MqttException {
        if (i2 == 1) {
            this.clientComms.internalSend(new MqttPubAck(i), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (i2 == 2) {
            this.clientComms.deliveryComplete(i);
            MqttPubComp mqttPubComp = new MqttPubComp(i);
            ClientComms clientComms2 = this.clientComms;
            clientComms2.internalSend(mqttPubComp, new MqttToken(clientComms2.getClient().getClientId()));
        }
    }

    public void quiesce() {
        this.quiescing = true;
        synchronized (this.spaceAvailable) {
            log.fine(CLASS_NAME, "quiesce", "711");
            this.spaceAvailable.notifyAll();
        }
    }

    public void removeMessageListener(String str) {
        this.callbacks.remove(str);
    }

    public void removeMessageListeners() {
        this.callbacks.clear();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r9.callbackThread = r0
            java.lang.String r1 = r9.threadName
            r0.setName(r1)
            r0 = 0
            java.util.concurrent.Semaphore r1 = r9.runningSemaphore     // Catch:{ InterruptedException -> 0x010d }
            r1.acquire()     // Catch:{ InterruptedException -> 0x010d }
        L_0x0011:
            boolean r1 = r9.running
            if (r1 != 0) goto L_0x0016
            return
        L_0x0016:
            r1 = 0
            java.lang.Object r2 = r9.workAvailable     // Catch:{ InterruptedException -> 0x0046 }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0046 }
            boolean r3 = r9.running     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            java.util.Vector r3 = r9.messageQueue     // Catch:{ all -> 0x0040 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            java.util.Vector r3 = r9.completeQueue     // Catch:{ all -> 0x0040 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x003e
            org.eclipse.paho.client.mqttv3.logging.Logger r3 = log     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = CLASS_NAME     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "run"
            java.lang.String r6 = "704"
            r3.fine(r4, r5, r6)     // Catch:{ all -> 0x0040 }
            java.lang.Object r3 = r9.workAvailable     // Catch:{ all -> 0x0040 }
            r3.wait()     // Catch:{ all -> 0x0040 }
        L_0x003e:
            monitor-exit(r2)     // Catch:{ all -> 0x0040 }
            goto L_0x0046
        L_0x0040:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0040 }
            throw r3     // Catch:{ InterruptedException -> 0x0046 }
        L_0x0043:
            r2 = move-exception
            goto L_0x00b8
        L_0x0046:
            boolean r2 = r9.running     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0091
            java.util.Vector r2 = r9.completeQueue     // Catch:{ all -> 0x0043 }
            monitor-enter(r2)     // Catch:{ all -> 0x0043 }
            java.util.Vector r3 = r9.completeQueue     // Catch:{ all -> 0x008e }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x008e }
            if (r3 != 0) goto L_0x0063
            java.util.Vector r3 = r9.completeQueue     // Catch:{ all -> 0x008e }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x008e }
            org.eclipse.paho.client.mqttv3.MqttToken r3 = (org.eclipse.paho.client.mqttv3.MqttToken) r3     // Catch:{ all -> 0x008e }
            java.util.Vector r4 = r9.completeQueue     // Catch:{ all -> 0x008e }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x008e }
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            monitor-exit(r2)     // Catch:{ all -> 0x008e }
            if (r3 == 0) goto L_0x006a
            r9.handleActionComplete(r3)     // Catch:{ all -> 0x0043 }
        L_0x006a:
            java.util.Vector r2 = r9.messageQueue     // Catch:{ all -> 0x0043 }
            monitor-enter(r2)     // Catch:{ all -> 0x0043 }
            java.util.Vector r3 = r9.messageQueue     // Catch:{ all -> 0x008b }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x008b }
            if (r3 != 0) goto L_0x0083
            java.util.Vector r3 = r9.messageQueue     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r3.elementAt(r0)     // Catch:{ all -> 0x008b }
            org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish r3 = (org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish) r3     // Catch:{ all -> 0x008b }
            java.util.Vector r4 = r9.messageQueue     // Catch:{ all -> 0x008b }
            r4.removeElementAt(r0)     // Catch:{ all -> 0x008b }
            goto L_0x0084
        L_0x0083:
            r3 = r1
        L_0x0084:
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0091
            r9.handleMessage(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0091
        L_0x008b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x008e:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x0091:
            boolean r2 = r9.quiescing     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x009a
            org.eclipse.paho.client.mqttv3.internal.ClientState r2 = r9.clientState     // Catch:{ all -> 0x0043 }
            r2.checkQuiesceLock()     // Catch:{ all -> 0x0043 }
        L_0x009a:
            java.util.concurrent.Semaphore r1 = r9.runningSemaphore
            r1.release()
            java.lang.Object r2 = r9.spaceAvailable
            monitor-enter(r2)
            org.eclipse.paho.client.mqttv3.logging.Logger r1 = log     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = CLASS_NAME     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r1.fine(r3, r4, r5)     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = r9.spaceAvailable     // Catch:{ all -> 0x00b5 }
            r1.notifyAll()     // Catch:{ all -> 0x00b5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            goto L_0x0011
        L_0x00b5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            throw r0
        L_0x00b8:
            org.eclipse.paho.client.mqttv3.logging.Logger r3 = log     // Catch:{ all -> 0x00ef }
            java.lang.String r4 = CLASS_NAME     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = "run"
            java.lang.String r6 = "714"
            r7 = 0
            r8 = r2
            r3.fine(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ef }
            r9.running = r0     // Catch:{ all -> 0x00ef }
            org.eclipse.paho.client.mqttv3.internal.ClientComms r3 = r9.clientComms     // Catch:{ all -> 0x00ef }
            org.eclipse.paho.client.mqttv3.MqttException r4 = new org.eclipse.paho.client.mqttv3.MqttException     // Catch:{ all -> 0x00ef }
            r4.<init>(r2)     // Catch:{ all -> 0x00ef }
            r3.shutdownConnection(r1, r4)     // Catch:{ all -> 0x00ef }
            java.util.concurrent.Semaphore r1 = r9.runningSemaphore
            r1.release()
            java.lang.Object r1 = r9.spaceAvailable
            monitor-enter(r1)
            org.eclipse.paho.client.mqttv3.logging.Logger r2 = log     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = CLASS_NAME     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x00ec }
            java.lang.Object r2 = r9.spaceAvailable     // Catch:{ all -> 0x00ec }
            r2.notifyAll()     // Catch:{ all -> 0x00ec }
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
            goto L_0x0011
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
            throw r0
        L_0x00ef:
            r0 = move-exception
            java.util.concurrent.Semaphore r1 = r9.runningSemaphore
            r1.release()
            java.lang.Object r1 = r9.spaceAvailable
            monitor-enter(r1)
            org.eclipse.paho.client.mqttv3.logging.Logger r2 = log     // Catch:{ all -> 0x010a }
            java.lang.String r3 = CLASS_NAME     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "run"
            java.lang.String r5 = "706"
            r2.fine(r3, r4, r5)     // Catch:{ all -> 0x010a }
            java.lang.Object r2 = r9.spaceAvailable     // Catch:{ all -> 0x010a }
            r2.notifyAll()     // Catch:{ all -> 0x010a }
            monitor-exit(r1)     // Catch:{ all -> 0x010a }
            throw r0
        L_0x010a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010a }
            throw r0
        L_0x010d:
            r9.running = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.internal.CommsCallback.run():void");
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
    }

    public void setClientState(ClientState clientState2) {
        this.clientState = clientState2;
    }

    public void setManualAcks(boolean z) {
        this.manualAcks = z;
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callbacks.put(str, iMqttMessageListener);
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.reconnectInternalCallback = mqttCallbackExtended;
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.messageQueue.clear();
                this.completeQueue.clear();
                this.running = true;
                this.quiescing = false;
                this.callbackFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            if (this.callbackFuture != null) {
                this.callbackFuture.cancel(true);
            }
            if (this.running) {
                log.fine(CLASS_NAME, "stop", "700");
                this.running = false;
                if (!Thread.currentThread().equals(this.callbackThread)) {
                    try {
                        synchronized (this.workAvailable) {
                            log.fine(CLASS_NAME, "stop", "701");
                            this.workAvailable.notifyAll();
                        }
                        this.runningSemaphore.acquire();
                        semaphore = this.runningSemaphore;
                    } catch (InterruptedException unused) {
                        semaphore = this.runningSemaphore;
                    } catch (Throwable th) {
                        this.runningSemaphore.release();
                        throw th;
                    }
                    semaphore.release();
                }
            }
            this.callbackThread = null;
            log.fine(CLASS_NAME, "stop", "703");
        }
    }
}
