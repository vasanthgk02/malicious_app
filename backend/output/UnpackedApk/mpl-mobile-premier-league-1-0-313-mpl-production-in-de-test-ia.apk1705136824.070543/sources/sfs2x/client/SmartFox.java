package sfs2x.client;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.bitswarm.util.Logging;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.bitswarm.BitSwarmEvent;
import sfs2x.client.bitswarm.UDPManager;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.IDispatchable;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.core.SFSIOHandler;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.entities.managers.IBuddyManager;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.entities.managers.IUserManager;
import sfs2x.client.entities.managers.SFSBuddyManager;
import sfs2x.client.entities.managers.SFSGlobalUserManager;
import sfs2x.client.entities.managers.SFSRoomManager;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.HandshakeRequest;
import sfs2x.client.requests.IRequest;
import sfs2x.client.requests.JoinRoomRequest;
import sfs2x.client.requests.ManualDisconnectionRequest;
import sfs2x.client.util.ClientDisconnectionReason;
import sfs2x.client.util.ConfigData;
import sfs2x.client.util.ConfigLoader;
import sfs2x.client.util.CryptoInitializer;
import sfs2x.client.util.LagMonitor;
import sfs2x.client.util.SFSErrorCodes;

public class SmartFox implements IDispatchable, ISmartFox {
    public static final int DEFAULT_HTTP_PORT = 8080;
    public static final int MAX_BB_CONNECT_ATTEMPTS = 3;
    public final char CLIENT_TYPE_SEPARATOR;
    public boolean autoConnectOnConfig;
    public int bbConnectionAttempt;
    public BitSwarmClient bitSwarm;
    public IBuddyManager buddyManager;
    public String clientDetails;
    public ConfigData config;
    public String currentZone;
    public boolean debug;
    public EventDispatcher dispatcher;
    public boolean inited;
    public boolean isConnecting;
    public boolean isJoining;
    public LagMonitor lagMonitor;
    public String lastIpAddress;
    public Room lastJoinedRoom;
    public Logger log;
    public int majVersion;
    public int minVersion;
    public User mySelf;
    public IRoomManager roomManager;
    public String sessionToken;
    public int subVersion;
    public boolean useBlueBox;
    public IUserManager userManager;

    public SmartFox(boolean z) {
        this.CLIENT_TYPE_SEPARATOR = ':';
        this.majVersion = 1;
        this.minVersion = 7;
        this.subVersion = 6;
        this.clientDetails = "Android";
        this.useBlueBox = true;
        this.isJoining = false;
        this.inited = false;
        this.debug = false;
        this.isConnecting = false;
        this.autoConnectOnConfig = false;
        this.bbConnectionAttempt = 0;
        this.log = LoggerFactory.getLogger(SmartFox.class);
        this.debug = z;
        initialize();
    }

    private void assignLocalConfig(ConfigData configData) {
        if (configData.getHost() == null || configData.getHost().length() == 0) {
            throw new IllegalArgumentException("Invalid Host/IpAddress provided in the configuration");
        } else if (configData.getPort() < 0 || configData.getPort() > 65535) {
            throw new IllegalArgumentException("Invalid TCP port provided in the configuration");
        } else if (configData.getZone() == null || configData.getZone().length() == 0) {
            throw new IllegalArgumentException("Invalid Zone name provided in the configuration");
        } else {
            this.config = configData;
            this.debug = configData.isDebug();
            this.useBlueBox = configData.isUseBBox();
        }
    }

    private void handleConnectionProblem(BaseEvent baseEvent) {
        if (!isConnecting() || !this.useBlueBox || this.bbConnectionAttempt >= 3) {
            try {
                this.bitSwarm.forceBlueBox(false);
                this.bbConnectionAttempt = 0;
                HashMap hashMap = new HashMap();
                hashMap.put("success", Boolean.FALSE);
                hashMap.put("errorMessage", ((BitSwarmEvent) baseEvent).getArguments().get("message"));
                dispatchEvent(new SFSEvent("connection", hashMap));
                this.isConnecting = false;
            } catch (SFSException e2) {
                this.log.error("Error using bluebox: " + e2.getLocalizedMessage());
                e2.printStackTrace();
            }
        } else {
            try {
                this.bitSwarm.forceBlueBox(true);
                this.bbConnectionAttempt++;
                ConfigData configData = this.config;
                this.bitSwarm.connect(this.lastIpAddress, configData != null ? configData.getHttpPort() : DEFAULT_HTTP_PORT);
                dispatchEvent(new SFSEvent(SFSEvent.CONNECTION_ATTEMPT_HTTP, new HashMap()));
            } catch (SFSException e3) {
                this.log.error("Error using bluebox: " + e3.getLocalizedMessage());
                e3.printStackTrace();
            }
        }
    }

    private void initialize() {
        if (!this.inited) {
            if (this.dispatcher == null) {
                this.dispatcher = new EventDispatcher(this);
            }
            BitSwarmClient bitSwarmClient = new BitSwarmClient(this);
            this.bitSwarm = bitSwarmClient;
            bitSwarmClient.setIoHandler(new SFSIOHandler(bitSwarmClient));
            this.bitSwarm.init();
            this.bitSwarm.addEventListener("connect", new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketConnect((BitSwarmEvent) baseEvent);
                }
            });
            this.bitSwarm.addEventListener("disconnect", new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketClose((BitSwarmEvent) baseEvent);
                }
            });
            this.bitSwarm.addEventListener(BitSwarmEvent.RECONNECTION_TRY, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketReconnectionTry((BitSwarmEvent) baseEvent);
                }
            });
            this.bitSwarm.addEventListener(BitSwarmEvent.IO_ERROR, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketIOError((BitSwarmEvent) baseEvent);
                }
            });
            this.bitSwarm.addEventListener(BitSwarmEvent.SECURITY_ERROR, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketSecurityError((BitSwarmEvent) baseEvent);
                }
            });
            this.bitSwarm.addEventListener(BitSwarmEvent.DATA_ERROR, new IEventListener() {
                public void dispatch(BaseEvent baseEvent) {
                    SmartFox.this.onSocketDataError((BitSwarmEvent) baseEvent);
                }
            });
            this.inited = true;
            reset();
        }
    }

    /* access modifiers changed from: private */
    public void onConfigLoadFailure(BaseEvent baseEvent) {
        Logger logger = this.log;
        logger.error("Failed to load config: " + ((String) baseEvent.getArguments().get("message")));
        ((ConfigLoader) baseEvent.getTarget()).getDispatcher().removeAll();
        dispatchEvent(new SFSEvent(SFSEvent.CONFIG_LOAD_FAILURE));
    }

    /* access modifiers changed from: private */
    public void onConfigLoadSuccess(BaseEvent baseEvent) {
        ConfigData configData = (ConfigData) baseEvent.getArguments().get("cfg");
        ((ConfigLoader) baseEvent.getTarget()).getDispatcher().removeAll();
        assignLocalConfig(configData);
        HashMap hashMap = new HashMap();
        hashMap.put("config", configData);
        dispatchEvent(new SFSEvent(SFSEvent.CONFIG_LOAD_SUCCESS, hashMap));
        if (this.autoConnectOnConfig) {
            connect(this.config.getHost(), this.config.getPort());
        }
    }

    /* access modifiers changed from: private */
    public void onSocketClose(BitSwarmEvent bitSwarmEvent) {
        reset();
        HashMap hashMap = new HashMap();
        hashMap.put("reason", bitSwarmEvent.getArguments().get("reason"));
        dispatchEvent(new SFSEvent(SFSEvent.CONNECTION_LOST, hashMap));
    }

    /* access modifiers changed from: private */
    public void onSocketConnect(BitSwarmEvent bitSwarmEvent) {
        if (((Boolean) bitSwarmEvent.getArguments().get("success")).booleanValue()) {
            sendHandshakeRequest(((Boolean) bitSwarmEvent.getArguments().get("isReconnection")).booleanValue());
            return;
        }
        this.log.warn("Connection attempt failed");
        handleConnectionProblem(bitSwarmEvent);
    }

    /* access modifiers changed from: private */
    public void onSocketDataError(BitSwarmEvent bitSwarmEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", bitSwarmEvent.getArguments().get("message"));
        dispatchEvent(new SFSEvent(SFSEvent.SOCKET_ERROR, hashMap));
    }

    /* access modifiers changed from: private */
    public void onSocketIOError(BitSwarmEvent bitSwarmEvent) {
        if (this.isConnecting) {
            handleConnectionProblem(bitSwarmEvent);
        }
    }

    /* access modifiers changed from: private */
    public void onSocketReconnectionTry(BitSwarmEvent bitSwarmEvent) {
        dispatchEvent(new SFSEvent(SFSEvent.CONNECTION_RETRY));
    }

    /* access modifiers changed from: private */
    public void onSocketSecurityError(BitSwarmEvent bitSwarmEvent) {
        if (this.isConnecting) {
            handleConnectionProblem(bitSwarmEvent);
        }
    }

    private void reset() {
        this.bbConnectionAttempt = 0;
        this.userManager = new SFSGlobalUserManager(this);
        this.roomManager = new SFSRoomManager(this);
        this.buddyManager = new SFSBuddyManager(this);
        LagMonitor lagMonitor2 = this.lagMonitor;
        if (lagMonitor2 != null) {
            lagMonitor2.stop();
        }
        this.isJoining = false;
        this.currentZone = null;
        this.lastJoinedRoom = null;
        this.sessionToken = null;
        this.mySelf = null;
    }

    private void sendHandshakeRequest(boolean z) {
        send(new HandshakeRequest(getVersion(), z ? this.sessionToken : null, this.clientDetails));
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.addEventListener(str, iEventListener);
    }

    public void addJoinedRoom(Room room) throws SFSException {
        if (!this.roomManager.containsRoom(room.getId())) {
            this.roomManager.addRoom(room, true);
            this.lastJoinedRoom = room;
            return;
        }
        throw new SFSException("Unexpected: joined room already exists for this User: " + this.mySelf.getName() + ", Room: " + room);
    }

    public void connect(final String str, final int i) {
        if (isConnected()) {
            this.log.warn("Already Connected");
        } else if (this.isConnecting) {
            this.log.warn("A connection attempt is already running");
        } else {
            ConfigData configData = this.config;
            if (configData != null) {
                if (str == null) {
                    str = configData.getHost();
                }
                if (i == -1) {
                    i = this.config.getPort();
                }
            }
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("Invalid connection host/address");
            } else if (i < 0 || i > 65535) {
                throw new IllegalArgumentException("Invalid connection port");
            } else {
                this.lastIpAddress = str;
                this.isConnecting = true;
                new Thread(new Runnable() {
                    public void run() {
                        SmartFox.this.bitSwarm.connect(str, i);
                    }
                }).start();
            }
        }
    }

    public void disconnect() {
        if (isConnected()) {
            if (this.bitSwarm.getReconnectionSeconds() > 0) {
                send(new ManualDisconnectionRequest());
            }
            final Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                public void run() {
                    SmartFox.this.handleClientDisconnection(ClientDisconnectionReason.MANUAL);
                    timer.cancel();
                }
            }, 120);
            return;
        }
        this.log.info("You are not connected");
    }

    public void dispatchEvent(BaseEvent baseEvent) {
        this.dispatcher.dispatchEvent(baseEvent);
    }

    public void enableLagMonitor(boolean z, int i, int i2) {
        if (this.mySelf == null) {
            this.log.warn("Lag Monitoring requires that you are logged in a Zone!");
            return;
        }
        if (z) {
            LagMonitor lagMonitor2 = new LagMonitor(this, i, i2);
            this.lagMonitor = lagMonitor2;
            lagMonitor2.start();
        } else {
            LagMonitor lagMonitor3 = this.lagMonitor;
            if (lagMonitor3 != null) {
                lagMonitor3.stop();
            }
        }
    }

    public IBuddyManager getBuddyManager() {
        return this.buddyManager;
    }

    public int getCompressionThreshold() {
        return this.bitSwarm.getCompressionThreshold();
    }

    public ConfigData getConfig() {
        return this.config;
    }

    public String getConnectionMode() {
        return this.bitSwarm.getConnectionMode().name();
    }

    public String getCurrentIp() {
        return this.bitSwarm.getConnectionIp();
    }

    public int getCurrentPort() {
        return this.bitSwarm.getConnectionPort();
    }

    public String getCurrentZone() {
        return this.currentZone;
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public String getHttpUploadURI() {
        if (this.config == null || this.mySelf == null) {
            return null;
        }
        return "http://" + this.config.getHost() + ":" + this.config.getHttpPort() + "/BlueBox/SFS2XFileUpload?sessHashId=" + this.sessionToken;
    }

    public List<Room> getJoinedRooms() {
        return this.roomManager.getJoinedRooms();
    }

    public LagMonitor getLagMonitor() {
        return this.lagMonitor;
    }

    public Room getLastJoinedRoom() {
        return this.lastJoinedRoom;
    }

    public Logger getLogger() {
        return this.log;
    }

    public int getMaxMessageSize() {
        return this.bitSwarm.getMaxMessageSize();
    }

    public User getMySelf() {
        return this.mySelf;
    }

    public int getReconnectionSeconds() {
        return this.bitSwarm.getReconnectionSeconds();
    }

    public Room getRoomById(int i) {
        return this.roomManager.getRoomById(i);
    }

    public Room getRoomByName(String str) {
        return this.roomManager.getRoomByName(str);
    }

    public List<Room> getRoomList() {
        return this.roomManager.getRoomList();
    }

    public List<Room> getRoomListFromGroup(String str) {
        return this.roomManager.getRoomListFromGroup(str);
    }

    public IRoomManager getRoomManager() {
        return this.roomManager;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public BitSwarmClient getSocketEngine() {
        return this.bitSwarm;
    }

    public IUserManager getUserManager() {
        return this.userManager;
    }

    public String getVersion() {
        return this.majVersion + "." + this.minVersion + "." + this.subVersion;
    }

    public void handleClientDisconnection(String str) {
        this.bitSwarm.setReconnectionSeconds(0);
        this.bitSwarm.disconnect(str);
        reset();
    }

    public void handleHandShake(BaseEvent baseEvent) {
        SFSObject sFSObject = (SFSObject) baseEvent.getArguments().get("message");
        if (!sFSObject.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            this.sessionToken = sFSObject.getUtfString(HandshakeRequest.KEY_SESSION_TOKEN);
            this.bitSwarm.setCompressionThreshold(sFSObject.getInt("ct").intValue());
            this.bitSwarm.setMaxMessageSize(sFSObject.getInt("ms").intValue());
            if (this.debug) {
                this.log.info(String.format("Handshake response: tk => %s, ct => %d", new Object[]{this.sessionToken, Integer.valueOf(this.bitSwarm.getCompressionThreshold())}));
            }
            if (this.bitSwarm.isReconnecting()) {
                this.bitSwarm.setReconnecting(false);
                dispatchEvent(new SFSEvent(SFSEvent.CONNECTION_RESUME));
                return;
            }
            this.isConnecting = false;
            HashMap hashMap = new HashMap();
            hashMap.put("success", Boolean.TRUE);
            dispatchEvent(new SFSEvent("connection", hashMap));
            return;
        }
        short shortValue = sFSObject.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        String errorMessage = SFSErrorCodes.getErrorMessage(shortValue, sFSObject.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("success", Boolean.FALSE);
        hashMap2.put("errorMessage", errorMessage);
        hashMap2.put("errorCode", Short.valueOf(shortValue));
        dispatchEvent(new SFSEvent("connection", hashMap2));
    }

    public void handleLogin(BaseEvent baseEvent) {
        this.currentZone = (String) baseEvent.getArguments().get("zone");
    }

    public void handleLogout() {
        LagMonitor lagMonitor2 = this.lagMonitor;
        if (lagMonitor2 != null && lagMonitor2.isRunning().booleanValue()) {
            this.lagMonitor.stop();
        }
        this.userManager = new SFSGlobalUserManager(this);
        this.roomManager = new SFSRoomManager(this);
        this.isJoining = false;
        this.lastJoinedRoom = null;
        this.currentZone = null;
        this.mySelf = null;
    }

    public void initCrypto() {
        new CryptoInitializer(this);
    }

    public void initUdp() {
        initUdp(null, -1);
    }

    public boolean isConnected() {
        BitSwarmClient bitSwarmClient = this.bitSwarm;
        if (bitSwarmClient != null) {
            return bitSwarmClient.isConnected();
        }
        return false;
    }

    public boolean isConnecting() {
        return this.isConnecting;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isJoining() {
        return this.isJoining;
    }

    public boolean isUdpInited() {
        if (this.bitSwarm.getUdpManager() != null) {
            return this.bitSwarm.getUdpManager().isInited();
        }
        return false;
    }

    public void killConnection() {
        this.bitSwarm.killConnection();
    }

    public void loadConfig(String str, boolean z) {
        ConfigLoader configLoader = new ConfigLoader();
        configLoader.getDispatcher().addEventListener(SFSEvent.CONFIG_LOAD_SUCCESS, new IEventListener() {
            public void dispatch(BaseEvent baseEvent) {
                SmartFox.this.onConfigLoadSuccess(baseEvent);
            }
        });
        configLoader.getDispatcher().addEventListener(SFSEvent.CONFIG_LOAD_FAILURE, new IEventListener() {
            public void dispatch(BaseEvent baseEvent) {
                SmartFox.this.onConfigLoadFailure(baseEvent);
            }
        });
        this.autoConnectOnConfig = z;
        configLoader.loadConfig(str);
    }

    public void removeAllEventListeners() {
        this.dispatcher.removeAll();
    }

    public void removeEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.removeEventListener(str, iEventListener);
    }

    public void removeJoinedRoom(Room room) {
        this.roomManager.removeRoom(room);
        if (getJoinedRooms().size() > 0) {
            this.lastJoinedRoom = getJoinedRooms().get(getJoinedRooms().size() - 1);
        }
    }

    public void send(IRequest iRequest) {
        if (!isConnected()) {
            Logger logger = this.log;
            logger.warn("You are not connected. Request cannot be sent: " + iRequest);
            return;
        }
        try {
            if (iRequest instanceof JoinRoomRequest) {
                if (!this.isJoining) {
                    this.isJoining = true;
                } else {
                    return;
                }
            }
            iRequest.validate(this);
            iRequest.execute(this);
            this.bitSwarm.send(iRequest.getMessage());
        } catch (SFSValidationException e2) {
            String message = e2.getMessage();
            for (String outline63 : e2.getErrors()) {
                message = GeneratedOutlineSupport.outline63(new StringBuilder(String.valueOf(message)), Logging.TAB, outline63, "\n");
            }
            this.log.warn(message);
        } catch (SFSException e3) {
            this.log.warn(e3.getMessage());
        }
    }

    public void setClientDetails(String str, String str2) {
        if (isConnected()) {
            this.log.warn("setClientDetails() must be called before the connection is started");
            return;
        }
        String str3 = "";
        this.clientDetails = str != null ? str.replace(':', ' ') : str3;
        String str4 = String.valueOf(r5) + ':';
        this.clientDetails = str4;
        StringBuilder sb = new StringBuilder(String.valueOf(str4));
        if (str2 != null) {
            str3 = str2.replace(':', ' ');
        }
        sb.append(str3);
        this.clientDetails = sb.toString();
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setJoining(boolean z) {
        this.isJoining = z;
    }

    public void setLastJoinedRoom(Room room) {
        this.lastJoinedRoom = room;
    }

    public void setMySelf(User user) {
        this.mySelf = user;
    }

    public void setReconnectionSeconds(int i) {
        this.bitSwarm.setReconnectionSeconds(i);
    }

    public void setUseBlueBox(boolean z) {
        this.useBlueBox = z;
    }

    public boolean useBlueBox() {
        return this.useBlueBox;
    }

    public void initUdp(String str) {
        initUdp(str, -1);
    }

    public void initUdp(String str, int i) {
        if (!isConnected()) {
            this.log.warn("Cannot initialize UDP protocol until the client is connected to SFS2X.");
            return;
        }
        ConfigData configData = this.config;
        if (configData != null) {
            if (str == null) {
                str = configData.getUdpHost();
            }
            if (i == -1) {
                i = this.config.getUdpPort();
            }
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid UDP host/address");
        } else if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Invalid UDP port range");
        } else {
            if (this.bitSwarm.getUdpManager() == null || !this.bitSwarm.getUdpManager().isInited()) {
                UDPManager uDPManager = new UDPManager();
                uDPManager.setSfs(this);
                this.bitSwarm.setUdpManager(uDPManager);
            }
            try {
                this.bitSwarm.getUdpManager().initialize(str, i);
            } catch (SFSException e2) {
                Logger logger = this.log;
                logger.error("Exception initializing UDP: " + e2.getLocalizedMessage());
            }
        }
    }

    public void loadConfig(String str) {
        loadConfig(str, true);
    }

    public void enableLagMonitor(boolean z) {
        enableLagMonitor(z, 4, 10);
    }

    public void loadConfig(boolean z) {
        loadConfig("sfs-config.xml", z);
    }

    public void enableLagMonitor(boolean z, int i) {
        enableLagMonitor(z, i, 10);
    }

    public void loadConfig() {
        loadConfig("sfs-config.xml", true);
    }

    public void connect(String str) {
        connect(str, -1);
    }

    public void connect() {
        connect(null, -1);
    }

    public SmartFox() {
        this(false);
    }

    public void connect(ConfigData configData) {
        assignLocalConfig(configData);
        connect();
    }
}
