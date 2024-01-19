package org.eclipse.paho.android.service;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.core.app.NotificationCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;

public class AlarmPingSender implements MqttPingSender {
    public static final String TAG = "AlarmPingSender";
    public BroadcastReceiver alarmReceiver;
    public ClientComms comms;
    public volatile boolean hasStarted = false;
    public PendingIntent pendingIntent;
    public MqttService service;
    public AlarmPingSender that;

    public class AlarmReceiver extends BroadcastReceiver {
        public final String wakeLockTag;
        public WakeLock wakelock;

        public AlarmReceiver() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(MqttServiceConstants.PING_WAKELOCK);
            outline73.append(AlarmPingSender.this.that.comms.getClient().getClientId());
            this.wakeLockTag = outline73.toString();
        }

        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            System.currentTimeMillis();
            WakeLock newWakeLock = ((PowerManager) AlarmPingSender.this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
            this.wakelock = newWakeLock;
            newWakeLock.acquire();
            if (AlarmPingSender.this.comms.checkForActivity(new IMqttActionListener() {
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    AlarmReceiver.this.wakeLockTag;
                    System.currentTimeMillis();
                    AlarmReceiver.this.wakelock.release();
                }

                public void onSuccess(IMqttToken iMqttToken) {
                    AlarmReceiver.this.wakeLockTag;
                    System.currentTimeMillis();
                    AlarmReceiver.this.wakelock.release();
                }
            }) == null && this.wakelock.isHeld()) {
                this.wakelock.release();
            }
        }
    }

    public AlarmPingSender(MqttService mqttService) {
        if (mqttService != null) {
            this.service = mqttService;
            this.that = this;
            return;
        }
        throw new IllegalArgumentException("Neither service nor client can be null.");
    }

    public void init(ClientComms clientComms) {
        this.comms = clientComms;
        this.alarmReceiver = new AlarmReceiver();
    }

    public void schedule(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        AlarmManager alarmManager = (AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, this.pendingIntent);
        } else {
            alarmManager.setExact(0, currentTimeMillis, this.pendingIntent);
        }
    }

    public void start() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(MqttServiceConstants.PING_SENDER);
        outline73.append(this.comms.getClient().getClientId());
        String sb = outline73.toString();
        this.service.registerReceiver(this.alarmReceiver, new IntentFilter(sb));
        this.pendingIntent = PendingIntent.getBroadcast(this.service, 0, new Intent(sb), 134217728);
        schedule(this.comms.getKeepAlive());
        this.hasStarted = true;
    }

    public void stop() {
        this.comms.getClient().getClientId();
        if (this.hasStarted) {
            if (this.pendingIntent != null) {
                ((AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.pendingIntent);
            }
            this.hasStarted = false;
            try {
                this.service.unregisterReceiver(this.alarmReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
