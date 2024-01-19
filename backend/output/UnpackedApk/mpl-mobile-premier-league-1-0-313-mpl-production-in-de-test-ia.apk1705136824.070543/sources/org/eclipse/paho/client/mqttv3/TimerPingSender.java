package org.eclipse.paho.client.mqttv3;

import com.razorpay.AnalyticsConstants;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class TimerPingSender implements MqttPingSender {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.TimerPingSender";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, TimerPingSender.class.getName());
    public ClientComms comms;
    public Timer timer;

    public class PingTask extends TimerTask {
        public static final String methodName = "PingTask.run";

        public PingTask() {
        }

        public void run() {
            TimerPingSender.log.fine(TimerPingSender.CLASS_NAME, "PingTask.run", "660", new Object[]{new Long(System.currentTimeMillis())});
            TimerPingSender.this.comms.checkForActivity();
        }

        public /* synthetic */ PingTask(TimerPingSender timerPingSender, PingTask pingTask) {
            this();
        }
    }

    public void init(ClientComms clientComms) {
        if (clientComms != null) {
            this.comms = clientComms;
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    public void schedule(long j) {
        this.timer.schedule(new PingTask(this, null), j);
    }

    public void start() {
        String clientId = this.comms.getClient().getClientId();
        log.fine(CLASS_NAME, AnalyticsConstants.START, "659", new Object[]{clientId});
        Timer timer2 = new Timer("MQTT Ping: " + clientId);
        this.timer = timer2;
        timer2.schedule(new PingTask(this, null), this.comms.getKeepAlive());
    }

    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", null);
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
    }
}
