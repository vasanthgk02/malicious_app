package io.antmedia.android.broadcaster.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster.StreamingStatusListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.butterflytv.rtmp_client.RTMPMuxer;
import org.json.JSONObject;

public class RTMPStreamer extends Handler implements IMediaMuxer {
    public static final boolean DEBUG = true;
    public static final String TAG = RTMPStreamer.class.getSimpleName();
    public byte[] audioConfig;
    public boolean audioEnabled;
    public List<Frame> audioFrameList;
    public volatile boolean closed;
    public AtomicInteger frameCount;
    public Object frameSynchronized;
    public long initialTimestamp;
    public boolean isConnected;
    public byte[] keyFrameData;
    public volatile int lastAudioFrameTimeStamp;
    public volatile int lastSentFrameTimeStamp;
    public volatile int lastVideoFrameTimeStamp;
    public volatile int mLastReceivedAudioFrameTimeStamp;
    public volatile int mLastReceivedVideoFrameTimeStamp;
    public int result;
    public RTMPMuxer rtmpMuxer;
    public long rtmpPtr;
    public String rtmpURL;
    public AtomicInteger sendFrameCount;
    public final StreamingStatusListener streamingStatusListener;
    public byte[] videoConfig;
    public List<Frame> videoFrameList;

    public class Frame {
        public byte[] data;
        public int length;
        public int timestamp;

        public Frame(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.length = i;
            this.timestamp = i2;
        }
    }

    public RTMPStreamer(Looper looper, StreamingStatusListener streamingStatusListener2) {
        super(looper);
        this.rtmpMuxer = new RTMPMuxer();
        this.frameCount = new AtomicInteger(0);
        this.sendFrameCount = new AtomicInteger(0);
        this.result = 0;
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.lastSentFrameTimeStamp = -1;
        this.frameSynchronized = new Object();
        this.isConnected = false;
        this.audioConfig = null;
        this.videoConfig = null;
        this.audioEnabled = true;
        this.initialTimestamp = -1;
        this.audioFrameList = Collections.synchronizedList(new LinkedList());
        this.videoFrameList = Collections.synchronizedList(new LinkedList());
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.lastSentFrameTimeStamp = -1;
        this.streamingStatusListener = streamingStatusListener2;
    }

    private void close() {
        this.closed = true;
        this.isConnected = false;
        this.rtmpMuxer.close(this.rtmpPtr);
        this.rtmpPtr = 0;
    }

    private void sendAudioFrames(int i) {
        Iterator<Frame> it = this.audioFrameList.iterator();
        while (it.hasNext()) {
            Frame next = it.next();
            int i2 = next.timestamp;
            if (i2 <= i && i2 >= this.lastSentFrameTimeStamp) {
                if (next.timestamp == this.lastSentFrameTimeStamp) {
                    next.timestamp++;
                }
                if (this.isConnected) {
                    if (this.rtmpMuxer.writeAudio(next.data, 0, next.length, (long) next.timestamp, this.rtmpPtr) >= 0) {
                        this.sendFrameCount.incrementAndGet();
                        this.lastAudioFrameTimeStamp = next.timestamp;
                        this.lastSentFrameTimeStamp = next.timestamp;
                        this.frameCount.decrementAndGet();
                        it.remove();
                    } else {
                        close();
                    }
                }
            } else {
                return;
            }
        }
    }

    private void sendFrames() {
        if (this.audioEnabled) {
            if (this.videoFrameList.size() > 0) {
                sendAudioFrames(this.videoFrameList.get(0).timestamp);
            }
            if (this.audioFrameList.size() > 0) {
                sendVideoFrames(this.audioFrameList.get(0).timestamp);
                return;
            }
            return;
        }
        int size = this.videoFrameList.size();
        if (size > 0) {
            sendVideoFrames(this.videoFrameList.get(size - 1).timestamp);
        }
    }

    private void sendVideoFrames(int i) {
        Iterator<Frame> it = this.videoFrameList.iterator();
        while (it.hasNext()) {
            Frame next = it.next();
            int i2 = next.timestamp;
            if (i2 <= i && i2 >= this.lastSentFrameTimeStamp) {
                if (next.timestamp == this.lastSentFrameTimeStamp) {
                    next.timestamp++;
                }
                if (this.isConnected) {
                    if (this.rtmpMuxer.writeVideo(next.data, 0, next.length, (long) next.timestamp, this.rtmpPtr) >= 0) {
                        this.sendFrameCount.incrementAndGet();
                        this.lastVideoFrameTimeStamp = next.timestamp;
                        this.lastSentFrameTimeStamp = next.timestamp;
                        it.remove();
                        this.frameCount.decrementAndGet();
                    } else {
                        close();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void file_close() {
        this.rtmpMuxer.file_close();
    }

    public void file_open(String str) {
        this.rtmpMuxer.file_open(str);
    }

    public void finishframes() {
        int size;
        this.videoFrameList.size();
        this.audioFrameList.size();
        if (this.audioEnabled) {
            do {
                sendFrames();
                int size2 = this.videoFrameList.size();
                size = this.audioFrameList.size();
                if (size2 <= 0) {
                    break;
                }
            } while (size > 0);
        }
        int size3 = this.videoFrameList.size();
        if (size3 > 0) {
            sendVideoFrames(this.videoFrameList.get(size3 - 1).timestamp);
        }
        if (this.audioEnabled) {
            int size4 = this.audioFrameList.size();
            if (size4 > 0) {
                sendAudioFrames(this.audioFrameList.get(size4 - 1).timestamp);
            }
        }
    }

    public int getAudioFrameCountInQueue() {
        int size;
        synchronized (this.frameSynchronized) {
            size = this.audioFrameList.size();
        }
        return size;
    }

    public int getFrameCountInQueue() {
        return this.frameCount.get();
    }

    public int getLastAudioFrameTimeStamp() {
        return this.lastAudioFrameTimeStamp;
    }

    public int getLastReceivedAudioFrameTimeStamp() {
        return this.mLastReceivedAudioFrameTimeStamp;
    }

    public int getLastReceivedVideoFrameTimeStamp() {
        return this.mLastReceivedVideoFrameTimeStamp;
    }

    public int getLastSentFrameTimeStamp() {
        return this.lastSentFrameTimeStamp;
    }

    public int getLastVideoFrameTimeStamp() {
        return this.lastVideoFrameTimeStamp;
    }

    public String getRtmpURL() {
        return this.rtmpURL;
    }

    public int getSendFrameCount() {
        return this.sendFrameCount.get();
    }

    public int getVideoFrameCountInQueue() {
        int size;
        synchronized (this.frameSynchronized) {
            size = this.videoFrameList.size();
        }
        return size;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                if (message.arg2 >= this.mLastReceivedVideoFrameTimeStamp) {
                    int i2 = message.arg1;
                    if (i2 > 0) {
                        byte[] bArr = (byte[]) message.obj;
                        int i3 = message.arg2;
                        if ((bArr[0] & 31) == 5) {
                            byte[] bArr2 = new byte[i2];
                            this.keyFrameData = bArr2;
                            System.arraycopy(bArr, 0, bArr2, 0, i2);
                        } else {
                            byte b2 = bArr[0] & 31;
                        }
                        this.mLastReceivedVideoFrameTimeStamp = message.arg2;
                        this.videoFrameList.add(new Frame(bArr, i2, i3));
                    }
                }
                sendFrames();
            } else if (i == 2) {
                this.videoConfig = null;
                this.audioConfig = null;
                finishframes();
                close();
                this.closed = false;
                this.mLastReceivedVideoFrameTimeStamp = 0;
                this.mLastReceivedVideoFrameTimeStamp = 0;
                if (this.streamingStatusListener != null) {
                    long j = ((long) this.lastSentFrameTimeStamp) - this.initialTimestamp;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(LiveVideoBroadcaster.VIDEO_LENGTH_MS, j);
                        jSONObject.put("Timestamp", System.currentTimeMillis());
                        jSONObject.put(LiveVideoBroadcaster.URL, this.rtmpURL);
                        this.streamingStatusListener.streamingStopped(jSONObject);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (i == 3) {
                long alloc = this.rtmpMuxer.alloc();
                this.rtmpPtr = alloc;
                if (this.rtmpMuxer.open(this.rtmpURL, 0, 0, alloc) > 0) {
                    if (this.closed) {
                        if (this.audioEnabled) {
                            RTMPMuxer rTMPMuxer = this.rtmpMuxer;
                            byte[] bArr3 = this.audioConfig;
                            rTMPMuxer.writeAudio(bArr3, 0, bArr3.length, 0, this.rtmpPtr);
                            int length = this.audioConfig.length;
                        }
                        RTMPMuxer rTMPMuxer2 = this.rtmpMuxer;
                        byte[] bArr4 = this.videoConfig;
                        rTMPMuxer2.writeVideo(bArr4, 0, bArr4.length, 1, this.rtmpPtr);
                        int length2 = this.videoConfig.length;
                        byte[] bArr5 = this.keyFrameData;
                        if (bArr5 != null) {
                            this.rtmpMuxer.writeVideo(bArr5, 0, bArr5.length, 2, this.rtmpPtr);
                            int length3 = this.keyFrameData.length;
                        }
                    }
                    this.isConnected = true;
                }
                StreamingStatusListener streamingStatusListener2 = this.streamingStatusListener;
                if (streamingStatusListener2 != null) {
                    streamingStatusListener2.streamingStartStatus(this.isConnected, this.rtmpURL);
                }
            }
        } else if (this.audioEnabled) {
            if (message.arg2 >= this.mLastReceivedAudioFrameTimeStamp && message.arg1 > 0) {
                this.mLastReceivedAudioFrameTimeStamp = message.arg2;
                this.audioFrameList.add(new Frame((byte[]) message.obj, message.arg1, message.arg2));
            }
            sendFrames();
        }
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void open(String str) {
        this.rtmpURL = str;
        this.frameCount.set(0);
        this.lastVideoFrameTimeStamp = 0;
        this.lastAudioFrameTimeStamp = 0;
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.lastSentFrameTimeStamp = -1;
        this.isConnected = false;
        sendEmptyMessage(3);
    }

    public void setAudioEnable(boolean z) {
        this.audioEnabled = z;
    }

    public void stopMuxer() {
        sendEmptyMessage(2);
    }

    public void writeAudio(byte[] bArr, int i, int i2) {
        if (this.audioConfig == null) {
            byte[] bArr2 = new byte[i];
            this.audioConfig = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int length = this.audioConfig.length;
        }
        Message obtainMessage = obtainMessage(0, bArr);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        sendMessage(obtainMessage);
        this.frameCount.incrementAndGet();
        if (this.initialTimestamp == -1) {
            this.initialTimestamp = (long) i2;
        }
    }

    public void writeFLVHeader(boolean z, boolean z2) {
        this.rtmpMuxer.write_flv_header(z, z2);
    }

    public void writeVideo(byte[] bArr, int i, int i2) {
        if (this.videoConfig == null) {
            byte[] bArr2 = new byte[i];
            this.videoConfig = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int length = this.videoConfig.length;
        }
        Message obtainMessage = obtainMessage(1, bArr);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        sendMessage(obtainMessage);
        this.frameCount.incrementAndGet();
        if (this.initialTimestamp == -1) {
            this.initialTimestamp = (long) i2;
        }
    }
}
