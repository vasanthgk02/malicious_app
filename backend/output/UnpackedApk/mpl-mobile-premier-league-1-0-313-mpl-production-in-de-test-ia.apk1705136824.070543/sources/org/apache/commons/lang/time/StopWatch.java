package org.apache.commons.lang.time;

public class StopWatch {
    public static final int STATE_RUNNING = 1;
    public static final int STATE_SPLIT = 11;
    public static final int STATE_STOPPED = 2;
    public static final int STATE_SUSPENDED = 3;
    public static final int STATE_UNSPLIT = 10;
    public static final int STATE_UNSTARTED = 0;
    public int runningState = 0;
    public int splitState = 10;
    public long startTime = -1;
    public long stopTime = -1;

    public long getSplitTime() {
        if (this.splitState == 11) {
            return this.stopTime - this.startTime;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getStartTime() {
        if (this.runningState != 0) {
            return this.startTime;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public long getTime() {
        long j;
        long j2;
        int i = this.runningState;
        if (i == 2 || i == 3) {
            j = this.stopTime;
            j2 = this.startTime;
        } else if (i == 0) {
            return 0;
        } else {
            if (i == 1) {
                j = System.currentTimeMillis();
                j2 = this.startTime;
            } else {
                throw new RuntimeException("Illegal running state has occured. ");
            }
        }
        return j - j2;
    }

    public void reset() {
        this.runningState = 0;
        this.splitState = 10;
        this.startTime = -1;
        this.stopTime = -1;
    }

    public void resume() {
        if (this.runningState == 3) {
            this.startTime = (System.currentTimeMillis() - this.stopTime) + this.startTime;
            this.stopTime = -1;
            this.runningState = 1;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public void split() {
        if (this.runningState == 1) {
            this.stopTime = System.currentTimeMillis();
            this.splitState = 11;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void start() {
        int i = this.runningState;
        if (i == 2) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (i == 0) {
            this.stopTime = -1;
            this.startTime = System.currentTimeMillis();
            this.runningState = 1;
        } else {
            throw new IllegalStateException("Stopwatch already started. ");
        }
    }

    public void stop() {
        int i = this.runningState;
        if (i == 1 || i == 3) {
            if (this.runningState == 1) {
                this.stopTime = System.currentTimeMillis();
            }
            this.runningState = 2;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void suspend() {
        if (this.runningState == 1) {
            this.stopTime = System.currentTimeMillis();
            this.runningState = 3;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public void unsplit() {
        if (this.splitState == 11) {
            this.stopTime = -1;
            this.splitState = 10;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }
}
