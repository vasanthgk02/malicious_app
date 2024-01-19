package org.eclipse.paho.client.mqttv3.internal.websocket;

import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class WebSocketReceiver implements Runnable {
    public static final String CLASS_NAME;
    public static final Logger log;
    public InputStream input;
    public Object lifecycle = new Object();
    public PipedOutputStream pipedOutputStream;
    public Thread receiverThread = null;
    public volatile boolean receiving;
    public boolean running = false;
    public boolean stopping = false;

    static {
        String name = WebSocketReceiver.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public WebSocketReceiver(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.input = inputStream;
        PipedOutputStream pipedOutputStream2 = new PipedOutputStream();
        this.pipedOutputStream = pipedOutputStream2;
        pipedInputStream.connect(pipedOutputStream2);
    }

    private void closeOutputStream() {
        try {
            this.pipedOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void run() {
        while (this.running && this.input != null) {
            try {
                log.fine(CLASS_NAME, "run", "852");
                this.receiving = this.input.available() > 0;
                WebSocketFrame webSocketFrame = new WebSocketFrame(this.input);
                if (!webSocketFrame.isCloseFlag()) {
                    for (byte write : webSocketFrame.getPayload()) {
                        this.pipedOutputStream.write(write);
                    }
                    this.pipedOutputStream.flush();
                } else if (!this.stopping) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                }
                this.receiving = false;
            } catch (IOException unused) {
                stop();
            }
        }
    }

    public void start(String str) {
        log.fine(CLASS_NAME, AnalyticsConstants.START, "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                Thread thread = new Thread(this, str);
                this.receiverThread = thread;
                thread.start();
            }
        }
    }

    public void stop() {
        boolean z = true;
        this.stopping = true;
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                closeOutputStream();
            } else {
                z = false;
            }
        }
        if (z && !Thread.currentThread().equals(this.receiverThread)) {
            try {
                this.receiverThread.join();
            } catch (InterruptedException unused) {
            }
        }
        this.receiverThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
