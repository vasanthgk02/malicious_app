package org.eclipse.paho.client.mqttv3.internal;

import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubRec;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsReceiver implements Runnable {
    public static final String CLASS_NAME;
    public static final Logger log;
    public ClientComms clientComms = null;
    public ClientState clientState = null;

    /* renamed from: in  reason: collision with root package name */
    public MqttInputStream f6151in;
    public Object lifecycle = new Object();
    public Thread recThread = null;
    public Future receiverFuture;
    public volatile boolean receiving;
    public boolean running = false;
    public final Semaphore runningSemaphore = new Semaphore(1);
    public String threadName;
    public CommsTokenStore tokenStore = null;

    static {
        String name = CommsReceiver.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public CommsReceiver(ClientComms clientComms2, ClientState clientState2, CommsTokenStore commsTokenStore, InputStream inputStream) {
        this.f6151in = new MqttInputStream(clientState2, inputStream);
        this.clientComms = clientComms2;
        this.clientState = clientState2;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        this.recThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            MqttToken mqttToken = null;
            while (this.running && this.f6151in != null) {
                try {
                    log.fine(CLASS_NAME, "run", "852");
                    this.receiving = this.f6151in.available() > 0;
                    MqttWireMessage readMqttWireMessage = this.f6151in.readMqttWireMessage();
                    this.receiving = false;
                    if (readMqttWireMessage instanceof MqttAck) {
                        mqttToken = this.tokenStore.getToken(readMqttWireMessage);
                        if (mqttToken != null) {
                            synchronized (mqttToken) {
                                this.clientState.notifyReceivedAck((MqttAck) readMqttWireMessage);
                            }
                        } else {
                            if (!(readMqttWireMessage instanceof MqttPubRec) && !(readMqttWireMessage instanceof MqttPubComp)) {
                                if (!(readMqttWireMessage instanceof MqttPubAck)) {
                                    throw new MqttException(6);
                                }
                            }
                            log.fine(CLASS_NAME, "run", "857");
                        }
                    } else if (readMqttWireMessage != null) {
                        this.clientState.notifyReceivedMsg(readMqttWireMessage);
                    }
                } catch (MqttException e2) {
                    MqttException mqttException = e2;
                    log.fine(CLASS_NAME, "run", "856", null, mqttException);
                    this.running = false;
                    this.clientComms.shutdownConnection(mqttToken, mqttException);
                } catch (IOException e3) {
                    try {
                        log.fine(CLASS_NAME, "run", "853");
                        this.running = false;
                        if (!this.clientComms.isDisconnecting()) {
                            this.clientComms.shutdownConnection(mqttToken, new MqttException(32109, e3));
                        }
                    } catch (Throwable th) {
                        this.receiving = false;
                        this.runningSemaphore.release();
                        throw th;
                    }
                }
                this.receiving = false;
                this.runningSemaphore.release();
            }
            log.fine(CLASS_NAME, "run", "854");
        } catch (InterruptedException unused) {
            this.running = false;
        }
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        log.fine(CLASS_NAME, AnalyticsConstants.START, "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.receiverFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            if (this.receiverFuture != null) {
                this.receiverFuture.cancel(true);
            }
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                if (!Thread.currentThread().equals(this.recThread)) {
                    try {
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
        }
        this.recThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
