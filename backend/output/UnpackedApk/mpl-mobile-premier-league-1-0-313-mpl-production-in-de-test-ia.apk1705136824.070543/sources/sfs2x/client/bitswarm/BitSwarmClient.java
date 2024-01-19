package sfs2x.client.bitswarm;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.SmartFox;
import sfs2x.client.bitswarm.bbox.BBClient;
import sfs2x.client.bitswarm.bbox.BBEvent;
import sfs2x.client.controllers.ExtensionController;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.IDispatchable;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.sockets.ISocketLayer;
import sfs2x.client.core.sockets.SocketEvent;
import sfs2x.client.core.sockets.TCPSocketLayer;
import sfs2x.client.util.ByteArray;
import sfs2x.client.util.CryptoKey;

public class BitSwarmClient implements IDispatchable {
    public boolean attemptingReconnection;
    public BBClient bbClient;
    public boolean bbConnected;
    public int compressionThreshold;
    public ConnectionMode connectionMode;
    public Map<Integer, IController> controllers;
    public boolean controllersInited;
    public CryptoKey cryptoKey;
    public String disconnectionReason;
    public EventDispatcher dispatcher;
    public ExtensionController extController;
    public long firstReconnAttempt;
    public IOHandler ioHandler;
    public String lastIpAddress;
    public int lastTcpPort;
    public Logger log;
    public int maxMessageSize;
    public int reconnCounter;
    public int reconnectionDelayMillis;
    public int reconnectionSeconds;
    public SmartFox sfs;
    public ISocketLayer socket;
    public SystemController sysController;
    public IUDPManager udpManager;
    public boolean useBlueBox;

    public BitSwarmClient() {
        this(null);
    }

    private void addController(int i, IController iController) {
        if (iController == null) {
            throw new IllegalArgumentException("Controller is null, it can't be added.");
        } else if (!this.controllers.containsKey(Integer.valueOf(i))) {
            this.controllers.put(Integer.valueOf(i), iController);
        } else {
            throw new IllegalArgumentException("A controller with id: " + i + " already exists! Controller can't be added: " + iController);
        }
    }

    private void executeDisconnection() {
        BitSwarmEvent bitSwarmEvent = new BitSwarmEvent("disconnect");
        HashMap hashMap = new HashMap();
        String str = this.disconnectionReason;
        if (str == null) {
            str = "unknown";
        }
        hashMap.put("reason", str);
        bitSwarmEvent.setArguments(hashMap);
        dispatchEvent(bitSwarmEvent);
        this.disconnectionReason = null;
    }

    private void initControllers() {
        this.sysController = new SystemController(this);
        this.extController = new ExtensionController(this);
        addController(0, this.sysController);
        addController(1, this.extController);
    }

    /* access modifiers changed from: private */
    public void onBBConnect(BaseEvent baseEvent) {
        this.bbConnected = true;
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.TRUE);
        hashMap.put("isReconnection", Boolean.FALSE);
        BitSwarmEvent bitSwarmEvent = new BitSwarmEvent("connect");
        bitSwarmEvent.setArguments(hashMap);
        dispatchEvent(bitSwarmEvent);
    }

    /* access modifiers changed from: private */
    public void onBBData(BaseEvent baseEvent) throws SFSException {
        this.ioHandler.onDataRead((ByteArray) ((BBEvent) baseEvent).getArguments().get("data"));
    }

    /* access modifiers changed from: private */
    public void onBBDisconnect(BaseEvent baseEvent) {
        this.bbConnected = false;
        this.useBlueBox = false;
        if (this.disconnectionReason != null) {
            this.disconnectionReason = null;
        }
        dispatchEvent(new BitSwarmEvent("disconnect", baseEvent.getArguments()));
    }

    /* access modifiers changed from: private */
    public void onBBError(BaseEvent baseEvent) {
        BBEvent bBEvent = (BBEvent) baseEvent;
        Logger logger = this.log;
        logger.error("## BlueBox Error: " + ((String) bBEvent.getArguments().get("message")));
        BitSwarmEvent bitSwarmEvent = new BitSwarmEvent(BitSwarmEvent.IO_ERROR);
        HashMap hashMap = new HashMap();
        hashMap.put("message", bBEvent.getArguments().get("message"));
        bitSwarmEvent.setArguments(hashMap);
        dispatchEvent(bitSwarmEvent);
    }

    /* access modifiers changed from: private */
    public synchronized void onSocketClose() {
        boolean z = this.sfs.getReconnectionSeconds() == 0;
        if (this.disconnectionReason == null) {
            if (!z) {
                if (this.attemptingReconnection) {
                    reconnect();
                } else {
                    this.attemptingReconnection = true;
                    this.firstReconnAttempt = System.currentTimeMillis();
                    this.reconnCounter = 1;
                    dispatchEvent(new BitSwarmEvent(BitSwarmEvent.RECONNECTION_TRY));
                    reconnect();
                }
            }
        }
        this.firstReconnAttempt = -1;
        executeDisconnection();
    }

    /* access modifiers changed from: private */
    public void onSocketConnect() {
        BitSwarmEvent bitSwarmEvent = new BitSwarmEvent("connect");
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.TRUE);
        hashMap.put("isReconnection", Boolean.valueOf(this.attemptingReconnection));
        bitSwarmEvent.setArguments(hashMap);
        dispatchEvent(bitSwarmEvent);
    }

    /* access modifiers changed from: private */
    public void onSocketData(ByteArray byteArray) throws SFSException {
        try {
            this.ioHandler.onDataRead(byteArray);
        } catch (Exception e2) {
            Logger logger = this.log;
            logger.error("## SocketDataError: " + e2.getMessage());
            BitSwarmEvent bitSwarmEvent = new BitSwarmEvent(BitSwarmEvent.DATA_ERROR);
            HashMap hashMap = new HashMap();
            hashMap.put("message", e2.toString());
            bitSwarmEvent.setArguments(hashMap);
            dispatchEvent(bitSwarmEvent);
        }
    }

    /* access modifiers changed from: private */
    public void onSocketError(String str) {
        if (this.attemptingReconnection) {
            reconnect();
            return;
        }
        HashMap outline87 = GeneratedOutlineSupport.outline87("message", str);
        BitSwarmEvent bitSwarmEvent = new BitSwarmEvent(BitSwarmEvent.IO_ERROR);
        bitSwarmEvent.setArguments(outline87);
        this.disconnectionReason = null;
        dispatchEvent(bitSwarmEvent);
    }

    private void reconnect() {
        if (this.attemptingReconnection) {
            if ((this.firstReconnAttempt + ((long) (this.sfs.getReconnectionSeconds() * 1000))) - System.currentTimeMillis() > 0) {
                this.log.info("Reconnection attempt:" + this.reconnCounter + " - time left:" + (r4 / 1000), (Object) " sec.");
                try {
                    Thread.sleep((long) this.reconnectionDelayMillis);
                } catch (InterruptedException unused) {
                }
                connect(this.lastIpAddress, this.lastTcpPort);
                this.reconnCounter++;
            } else {
                BitSwarmEvent bitSwarmEvent = new BitSwarmEvent("disconnect");
                HashMap hashMap = new HashMap();
                hashMap.put("reason", "unknown");
                bitSwarmEvent.setArguments(hashMap);
                dispatchEvent(bitSwarmEvent);
            }
        }
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.addEventListener(str, iEventListener);
    }

    public void connect() {
        connect("127.0.0.1", 9339);
    }

    public void destroy() {
        this.socket.getDispatcher().removeAll();
        if (this.socket.isConnected()) {
            this.socket.disconnect();
        }
        this.socket = null;
    }

    public void disconnect() {
        disconnect(null);
    }

    public void dispatchEvent(BitSwarmEvent bitSwarmEvent) {
        this.dispatcher.dispatchEvent(bitSwarmEvent);
    }

    public void enableBlueBoxDebug(boolean z) {
        this.bbClient.setDebug(z);
    }

    public void forceBlueBox(boolean z) throws SFSException {
        if (!this.bbConnected) {
            this.useBlueBox = z;
            return;
        }
        throw new SFSException((String) "You can't change the BlueBox mode while the connection is running");
    }

    public int getCompressionThreshold() {
        return this.compressionThreshold;
    }

    public String getConnectionIp() {
        if (!isConnected()) {
            return "Not Connected";
        }
        return this.lastIpAddress;
    }

    public ConnectionMode getConnectionMode() {
        return this.connectionMode;
    }

    public int getConnectionPort() {
        if (!isConnected()) {
            return -1;
        }
        return this.lastTcpPort;
    }

    public IController getController(int i) {
        return this.controllers.get(Integer.valueOf(i));
    }

    public CryptoKey getCryptoKey() {
        return this.cryptoKey;
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public ExtensionController getExtController() {
        return this.extController;
    }

    public BBClient getHttpClient() {
        return this.bbClient;
    }

    public IOHandler getIoHandler() {
        return this.ioHandler;
    }

    public int getMaxMessageSize() {
        return this.maxMessageSize;
    }

    public long getNextUdpPacketId() {
        return this.udpManager.getNextUdpPacketId();
    }

    public int getReconnectionDelayMillis() {
        return this.reconnectionDelayMillis;
    }

    public int getReconnectionSeconds() {
        int i = this.reconnectionSeconds;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public SmartFox getSfs() {
        return this.sfs;
    }

    public ISocketLayer getSocket() {
        return this.socket;
    }

    public SystemController getSysController() {
        return this.sysController;
    }

    public IUDPManager getUdpManager() {
        return this.udpManager;
    }

    public boolean getUseBlueBox() {
        return this.useBlueBox;
    }

    public void init() {
        if (!this.controllersInited) {
            initControllers();
            this.controllersInited = true;
        }
        if (this.socket == null) {
            TCPSocketLayer tCPSocketLayer = new TCPSocketLayer();
            this.socket = tCPSocketLayer;
            tCPSocketLayer.addEventListener(SocketEvent.OnConnect, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    BitSwarmClient.this.onSocketConnect();
                }
            });
            this.socket.addEventListener(SocketEvent.OnDisconnect, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    BitSwarmClient.this.onSocketClose();
                }
            });
            this.socket.addEventListener(SocketEvent.OnData, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onSocketData(new ByteArray((byte[]) baseEvent.getArguments().get("data")));
                }
            });
            this.socket.addEventListener(SocketEvent.OnError, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    BitSwarmClient.this.onSocketError((String) baseEvent.getArguments().get("message"));
                }
            });
            BBClient bBClient = new BBClient(this);
            this.bbClient = bBClient;
            bBClient.addEventListener(BBEvent.CONNECT, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onBBConnect(baseEvent);
                }
            });
            this.bbClient.addEventListener(BBEvent.DATA, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onBBData(baseEvent);
                }
            });
            this.bbClient.addEventListener(BBEvent.DISCONNECT, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onBBDisconnect(baseEvent);
                }
            });
            this.bbClient.addEventListener(BBEvent.IO_ERROR, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onBBError(baseEvent);
                }
            });
            this.bbClient.addEventListener(BBEvent.SECURITY_ERROR, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) throws SFSException {
                    BitSwarmClient.this.onBBError(baseEvent);
                }
            });
        }
    }

    public boolean isConnected() {
        if (this.useBlueBox) {
            return this.bbConnected;
        }
        ISocketLayer iSocketLayer = this.socket;
        if (iSocketLayer == null) {
            return false;
        }
        return iSocketLayer.isConnected();
    }

    public boolean isDebug() {
        SmartFox smartFox = this.sfs;
        return smartFox == null || smartFox.isDebug();
    }

    public boolean isReconnecting() {
        return this.attemptingReconnection;
    }

    public void killConnection() {
        if (!this.useBlueBox) {
            this.socket.kill();
        }
    }

    public void retryConnection(int i) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                BitSwarmClient.this.socket.connect(BitSwarmClient.this.lastIpAddress, BitSwarmClient.this.lastTcpPort);
                timer.cancel();
            }
        }, 100);
    }

    public void send(IMessage iMessage) throws SFSException {
        this.ioHandler.getCodec().onPacketWrite(iMessage);
    }

    public void setAttemptingReconnection(boolean z) {
        this.attemptingReconnection = z;
    }

    public void setCompressionThreshold(int i) {
        if (i > 100) {
            this.compressionThreshold = i;
            return;
        }
        throw new IllegalArgumentException("Compression threshold cannot be < 100 bytes.");
    }

    public void setCryptoKey(CryptoKey cryptoKey2) {
        this.cryptoKey = cryptoKey2;
    }

    public void setIoHandler(IOHandler iOHandler) {
        if (this.ioHandler == null) {
            this.ioHandler = iOHandler;
            return;
        }
        throw new IllegalStateException("IOHandler is already set!");
    }

    public void setMaxMessageSize(int i) {
        this.maxMessageSize = i;
    }

    public void setReconnecting(boolean z) {
        this.attemptingReconnection = z;
    }

    public void setReconnectionDelayMillis(int i) {
        this.reconnectionDelayMillis = i;
    }

    public void setReconnectionSeconds(int i) {
        this.reconnectionSeconds = i;
    }

    public void setUdpManager(IUDPManager iUDPManager) {
        this.udpManager = iUDPManager;
    }

    public void stopReconnection() {
        this.attemptingReconnection = false;
        this.firstReconnAttempt = -1;
        if (this.socket.isConnected()) {
            this.socket.disconnect();
        }
    }

    public BitSwarmClient(SmartFox smartFox) {
        this.socket = null;
        this.controllers = new HashMap();
        this.compressionThreshold = 2000000;
        this.maxMessageSize = 10000;
        this.reconnectionDelayMillis = 1000;
        this.reconnectionSeconds = 0;
        this.controllersInited = false;
        this.useBlueBox = false;
        this.firstReconnAttempt = -1;
        this.reconnCounter = 1;
        this.sfs = smartFox;
        this.log = LoggerFactory.getLogger(BitSwarmClient.class);
        this.dispatcher = new EventDispatcher(this);
    }

    public void connect(String str, int i) {
        this.lastIpAddress = str;
        this.lastTcpPort = i;
        if (this.useBlueBox) {
            this.bbClient.setPollSpeed(this.sfs.getConfig() != null ? this.sfs.getConfig().getBboxPollingRate() : 750);
            BBClient bBClient = this.bbClient;
            if (this.sfs.getConfig() != null) {
                i = this.sfs.getConfig().getHttpPort();
            }
            bBClient.connect(str, i);
            this.connectionMode = ConnectionMode.HTTP;
            return;
        }
        this.socket.connect(str, i);
        this.connectionMode = ConnectionMode.SOCKET;
    }

    public void disconnect(String str) {
        this.disconnectionReason = str;
        if (this.useBlueBox) {
            this.bbClient.close(str);
            return;
        }
        this.socket.disconnect(str);
        IUDPManager iUDPManager = this.udpManager;
        if (iUDPManager != null) {
            iUDPManager.disconnect();
        }
    }
}
