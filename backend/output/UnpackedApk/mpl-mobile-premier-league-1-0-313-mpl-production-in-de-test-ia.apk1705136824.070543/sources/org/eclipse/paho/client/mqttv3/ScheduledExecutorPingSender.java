package org.eclipse.paho.client.mqttv3;

import com.razorpay.AnalyticsConstants;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class ScheduledExecutorPingSender implements MqttPingSender {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.ScheduledExecutorPingSender";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, ScheduledExecutorPingSender.class.getName());
    public String clientid;
    public ClientComms comms;
    public ScheduledExecutorService executorService;
    public ScheduledFuture scheduledFuture;

    public class PingRunnable implements Runnable {
        public static final String methodName = "PingTask.run";

        public PingRunnable() {
        }

        public void run() {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
            ScheduledExecutorPingSender.log.fine(ScheduledExecutorPingSender.CLASS_NAME, "PingTask.run", "660", new Object[]{new Long(System.currentTimeMillis())});
            ScheduledExecutorPingSender.this.comms.checkForActivity();
            Thread.currentThread().setName(name);
        }

        public /* synthetic */ PingRunnable(ScheduledExecutorPingSender scheduledExecutorPingSender, PingRunnable pingRunnable) {
            this();
        }
    }

    public ScheduledExecutorPingSender(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            return;
        }
        throw new IllegalArgumentException("ExecutorService cannot be null.");
    }

    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            this.clientid = clientComms.getClient().getClientId();
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    public void schedule(long j) {
        this.scheduledFuture = this.executorService.schedule(new PingRunnable(this, null), j, TimeUnit.MILLISECONDS);
    }

    public void start() {
        log.fine(CLASS_NAME, AnalyticsConstants.START, "659", new Object[]{this.clientid});
        schedule(this.comms.getKeepAlive());
    }

    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", null);
        ScheduledFuture scheduledFuture2 = this.scheduledFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }
}
