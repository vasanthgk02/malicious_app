package sfs2x.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import sfs2x.client.SmartFox;
import sfs2x.client.requests.PingPongRequest;

public class LagMonitor {
    public int interval;
    public volatile boolean isPollRunning;
    public long lastReqTime;
    public Timer pollTimer;
    public int queueSize;
    public SmartFox sfs;
    public List<Integer> valueQueue;

    public class PollTimerTask extends TimerTask {
        public PollTimerTask() {
        }

        public void run() {
            LagMonitor.this.lastReqTime = System.currentTimeMillis();
            LagMonitor.this.sfs.send(new PingPongRequest());
        }
    }

    public LagMonitor(SmartFox smartFox) {
        this(smartFox, 4, 10);
    }

    public synchronized int getAveragePingTime() {
        int i = 0;
        if (this.valueQueue.size() == 0) {
            return 0;
        }
        for (Integer intValue : this.valueQueue) {
            i += intValue.intValue();
        }
        return i / this.valueQueue.size();
    }

    public synchronized int getLastPingTime() {
        if (this.valueQueue.size() <= 0) {
            return 0;
        }
        return this.valueQueue.get(this.valueQueue.size() - 1).intValue();
    }

    public Boolean isRunning() {
        return Boolean.valueOf(this.isPollRunning);
    }

    public synchronized int onPingPong() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.lastReqTime);
        if (this.valueQueue.size() >= this.queueSize) {
            this.valueQueue.remove(0);
        }
        this.valueQueue.add(Integer.valueOf(currentTimeMillis));
        return getAveragePingTime();
    }

    public void start() {
        if (!isRunning().booleanValue()) {
            Timer timer = new Timer();
            this.pollTimer = timer;
            timer.scheduleAtFixedRate(new PollTimerTask(), 0, (long) this.interval);
            this.isPollRunning = true;
        }
    }

    public void stop() {
        if (isRunning().booleanValue()) {
            Timer timer = this.pollTimer;
            if (timer != null) {
                timer.cancel();
                this.pollTimer = null;
            }
        }
    }

    public LagMonitor(SmartFox smartFox, int i) {
        this(smartFox, i, 10);
    }

    public LagMonitor(SmartFox smartFox, int i, int i2) {
        this.isPollRunning = false;
        i = i < 1 ? 1 : i;
        this.sfs = smartFox;
        this.valueQueue = new ArrayList(i2);
        this.interval = i * 1000;
        this.queueSize = i2;
    }
}
