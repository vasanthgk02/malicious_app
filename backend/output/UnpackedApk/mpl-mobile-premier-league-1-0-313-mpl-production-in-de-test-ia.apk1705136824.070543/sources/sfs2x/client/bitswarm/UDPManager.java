package sfs2x.client.bitswarm;

import com.crimzoncode.tqcontests.util.TQConstants;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.userexperior.e.h;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.DefaultPacketEncrypter;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.IPacketEncrypter;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.core.sockets.ISocketLayer;
import sfs2x.client.core.sockets.SocketEvent;
import sfs2x.client.core.sockets.UDPSocketLayer;
import sfs2x.client.util.ByteArray;

public class UDPManager implements IUDPManager {
    public final int MAX_RETRY = 3;
    public final int RESPONSE_TIMEOUT = 3000;
    public int currentAttempt = 1;
    public boolean initSuccess = false;
    public ScheduledThreadPoolExecutor initTimer;
    public volatile boolean locked = false;
    public Logger log = LoggerFactory.getLogger(UDPManager.class);
    public IPacketEncrypter packetEncrypter;
    public long packetId = 0;
    public SmartFox sfs;
    public ISocketLayer udpSocket;
    public ScheduledFuture<?> udpTimeout;

    /* access modifiers changed from: private */
    public void onTimeout() throws SFSException {
        int i = this.currentAttempt;
        if (i < 3) {
            this.currentAttempt = i + 1;
            if (this.log.isDebugEnabled()) {
                Logger logger = this.log;
                logger.debug("UDP Init Attempt: " + this.currentAttempt);
            }
            sendInitializationRequest();
            return;
        }
        stopTimer();
        this.currentAttempt = 0;
        this.locked = false;
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.FALSE);
        this.sfs.dispatchEvent(new SFSEvent(SFSEvent.UDP_INIT, hashMap));
    }

    /* access modifiers changed from: private */
    public void onUDPData(ByteArray byteArray) throws SFSException {
        if (byteArray.getBytesAvailable() < 4) {
            Logger logger = this.log;
            logger.warn("Too small UDP packet. Len: " + byteArray.getLength());
            return;
        }
        byte readByte = byteArray.readByte();
        boolean z = (readByte & 32) > 0;
        boolean z2 = (readByte & 64) > 0;
        short readShort = byteArray.readShort();
        if (readShort > byteArray.getBytesAvailable()) {
            Logger logger2 = this.log;
            logger2.warn("Insufficient UDP data. Expected: " + readShort + ", got: " + byteArray.getBytesAvailable());
            return;
        }
        byte[] readBytes = byteArray.readBytes(readShort);
        if (z2) {
            try {
                readBytes = this.packetEncrypter.decrypt(readBytes);
            } catch (Exception e2) {
                throw new SFSException((Throwable) e2);
            }
        }
        ByteArray byteArray2 = new ByteArray(readBytes);
        if (z) {
            byteArray2.uncompress();
        }
        SFSObject newFromBinaryData = SFSObject.newFromBinaryData(byteArray2.getBytes());
        if (newFromBinaryData.containsKey(h.f3998a)) {
            if (!this.initSuccess) {
                stopTimer();
                this.locked = false;
                this.initSuccess = true;
                HashMap hashMap = new HashMap();
                hashMap.put("success", Boolean.TRUE);
                this.sfs.dispatchEvent(new SFSEvent(SFSEvent.UDP_INIT, hashMap));
            }
            return;
        }
        this.sfs.getSocketEngine().getIoHandler().getCodec().onPacketRead((ISFSObject) newFromBinaryData);
    }

    /* access modifiers changed from: private */
    public void onUDPError(String str) {
        Logger logger = this.log;
        logger.warn("Unexpected UDP I/O Error. " + str);
    }

    private synchronized void startTimer() throws SFSException {
        if (this.initTimer == null) {
            this.initTimer = new ScheduledThreadPoolExecutor(1);
        }
        this.udpTimeout = this.initTimer.schedule(new Runnable() {
            public void run() {
                try {
                    UDPManager.this.onTimeout();
                } catch (SFSException e2) {
                    UDPManager.this.log.error(e2.toString());
                }
            }
        }, TQConstants.COUNTDOWN_DURATION, TimeUnit.MILLISECONDS);
    }

    private synchronized void stopTimer() {
        if (this.udpTimeout != null) {
            this.udpTimeout.cancel(true);
        }
        if (this.initTimer != null) {
            this.initTimer.shutdown();
            this.initTimer = null;
        }
    }

    public void disconnect() {
        this.udpSocket.disconnect();
    }

    public long getNextUdpPacketId() {
        long j = this.packetId;
        this.packetId = 1 + j;
        return j;
    }

    public void initialize(String str, int i) throws SFSException {
        if (this.initSuccess) {
            this.log.warn("UDP Channel already initialized!");
            return;
        }
        if (!this.locked) {
            this.locked = true;
            UDPSocketLayer uDPSocketLayer = new UDPSocketLayer();
            this.udpSocket = uDPSocketLayer;
            uDPSocketLayer.addEventListener(SocketEvent.OnData, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    UDPManager.this.onUDPData(new ByteArray((byte[]) baseEvent.getArguments().get("data")));
                }
            });
            this.udpSocket.addEventListener(SocketEvent.OnError, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    UDPManager.this.onUDPError((String) baseEvent.getArguments().get("message"));
                }
            });
            this.udpSocket.connect(str, i);
            sendInitializationRequest();
        } else {
            this.log.warn("UPD initialization is already in progress!");
        }
    }

    public boolean isInited() {
        return this.initSuccess;
    }

    public void reset() {
        stopTimer();
        this.currentAttempt = 1;
        this.initSuccess = false;
        this.locked = false;
        this.packetId = 0;
    }

    public void send(ByteArray byteArray) {
        if (this.initSuccess) {
            try {
                this.udpSocket.write(byteArray.getBytes());
                this.sfs.isDebug();
            } catch (Exception e2) {
                Logger logger = this.log;
                logger.warn("WriteUDP operation failed due to Error: " + e2.getMessage());
            }
        } else {
            this.log.warn("UDP protocol is not initialized yet. Pleas use the initUDP() method.");
        }
    }

    public void sendInitializationRequest() throws SFSException {
        SFSObject sFSObject = new SFSObject();
        sFSObject.putByte("c", 1);
        sFSObject.putByte(h.f3998a, 1);
        sFSObject.putLong("i", getNextUdpPacketId());
        sFSObject.putInt("u", this.sfs.getMySelf().getId());
        ByteArray byteArray = new ByteArray(sFSObject.toBinary());
        ByteArray byteArray2 = new ByteArray();
        byteArray2.writeByte(Byte.MIN_VALUE);
        byteArray2.writeShort((short) byteArray.getLength());
        byteArray2.writeBytes(byteArray.getBytes());
        this.udpSocket.write(byteArray2.getBytes());
        startTimer();
    }

    public void setSfs(SmartFox smartFox) {
        this.sfs = smartFox;
        this.packetEncrypter = new DefaultPacketEncrypter(smartFox.getSocketEngine());
    }
}
