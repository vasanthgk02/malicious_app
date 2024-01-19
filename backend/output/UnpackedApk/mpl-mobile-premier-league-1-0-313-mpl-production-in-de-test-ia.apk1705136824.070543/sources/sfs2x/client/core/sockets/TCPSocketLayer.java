package sfs2x.client.core.sockets;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.InetSocketAddress;
import java.util.Properties;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.BigEndianHeapChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.IDispatchable;
import sfs2x.client.core.IEventListener;
import sfs2x.fsm.FiniteStateMachine;

public class TCPSocketLayer implements ISocketLayer, IDispatchable {
    public static final String BOSS_THREADS_NUM_KEY = "com.smartfoxserver.bossThreadsNum";
    public static final int StateConnected = 2;
    public static final int StateConnecting = 1;
    public static final int StateDisconnected = 0;
    public static final int StateDisconnecting = 3;
    public static final int TransConnectionFailure = 2;
    public static final int TransConnectionSuccess = 1;
    public static final int TransDisconnect = 3;
    public static final int TransStartConnect = 0;
    public static final String WORKER_THREADS_NUM_KEY = "com.smartfoxserver.workerThreadsNum";
    public ClientBootstrap bootstrap;
    public Channel channel;
    public ChannelFactory channelFactory;
    public EventDispatcher dispatcher = new EventDispatcher(this);
    public FiniteStateMachine fsm;
    public String ipAddress;
    public Logger log = LoggerFactory.getLogger(TCPSocketLayer.class);
    public int socketNumber;
    public int socketPollSleep;

    public class NettyIOHandler extends SimpleChannelHandler {
        public NettyIOHandler() {
        }

        public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            TCPSocketLayer.this.channel = channelStateEvent.getFuture().getChannel();
            TCPSocketLayer.this.fsm.applyTransition(1);
            TCPSocketLayer.this.callOnConnect();
        }

        public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            TCPSocketLayer.this.releaseResources();
            TCPSocketLayer.this.handleDisconnection();
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
            TCPSocketLayer tCPSocketLayer = TCPSocketLayer.this;
            tCPSocketLayer.handleError("Socket error: " + exceptionEvent.getCause().getMessage());
        }

        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
            try {
                Object message = messageEvent.getMessage();
                if (!(message instanceof BigEndianHeapChannelBuffer)) {
                    Logger access$5 = TCPSocketLayer.this.log;
                    access$5.warn("Not BigEndianHeapChannelBuffer " + message.getClass());
                    channelHandlerContext.sendUpstream(messageEvent);
                    return;
                }
                byte[] array = ((BigEndianHeapChannelBuffer) message).array();
                if (array.length < 1) {
                    TCPSocketLayer.this.handleError("Connection closed by the remote side");
                    return;
                }
                TCPSocketLayer.this.handleBinaryData(array);
                super.messageReceived(channelHandlerContext, messageEvent);
            } catch (Exception e2) {
                TCPSocketLayer tCPSocketLayer = TCPSocketLayer.this;
                tCPSocketLayer.handleError("General error reading data from socket: " + e2.getMessage());
            }
        }

        public /* synthetic */ NettyIOHandler(TCPSocketLayer tCPSocketLayer, NettyIOHandler nettyIOHandler) {
            this();
        }
    }

    public TCPSocketLayer() {
        initStates();
    }

    /* access modifiers changed from: private */
    public void callOnConnect() {
        this.dispatcher.dispatchEvent(new SocketEvent(SocketEvent.OnConnect));
    }

    private void callOnData(byte[] bArr) {
        SocketEvent socketEvent = new SocketEvent(SocketEvent.OnData);
        socketEvent.getArguments().put("data", bArr);
        this.dispatcher.dispatchEvent(socketEvent);
    }

    private void callOnDisconnect() {
        this.dispatcher.dispatchEvent(new SocketEvent(SocketEvent.OnDisconnect));
    }

    private void callOnError(String str) {
        SocketEvent socketEvent = new SocketEvent(SocketEvent.OnError);
        socketEvent.getArguments().put("message", str);
        this.dispatcher.dispatchEvent(socketEvent);
    }

    /* access modifiers changed from: private */
    public void handleBinaryData(byte[] bArr) {
        callOnData(bArr);
    }

    /* access modifiers changed from: private */
    public void handleDisconnection() {
        handleDisconnection(null);
    }

    /* access modifiers changed from: private */
    public void handleError(final String str) {
        new Thread(new Runnable() {
            public void run() {
                TCPSocketLayer.this.handleErrorThread(str);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void handleErrorThread(String str) {
        this.fsm.applyTransition(2);
        releaseResources();
        if (getState() != 3) {
            logError(str);
            callOnError(str);
            return;
        }
        handleDisconnection();
    }

    private void initNetty() {
        int i;
        Properties properties = System.getProperties();
        int i2 = 1;
        try {
            i = Integer.parseInt(properties.getProperty(BOSS_THREADS_NUM_KEY, "1"));
        } catch (NumberFormatException unused) {
            i = 1;
        }
        try {
            i2 = Integer.parseInt(properties.getProperty(WORKER_THREADS_NUM_KEY, "1"));
        } catch (NumberFormatException unused2) {
        }
        this.channelFactory = new NioClientSocketChannelFactory(Executors.newFixedThreadPool(i), Executors.newFixedThreadPool(i2));
    }

    private void initStates() {
        FiniteStateMachine finiteStateMachine = new FiniteStateMachine();
        this.fsm = finiteStateMachine;
        finiteStateMachine.addAllStates(4);
        this.fsm.addStateTransition(0, 1, 0);
        this.fsm.addStateTransition(1, 2, 1);
        this.fsm.addStateTransition(1, 0, 2);
        this.fsm.addStateTransition(2, 0, 3);
        this.fsm.setCurrentState(0);
    }

    private void logError(String str) {
        Logger logger = this.log;
        logger.error("TCPSocketLayer: " + str);
    }

    private void logWarn(String str) {
        Logger logger = this.log;
        logger.warn("TCPSocketLayer: " + str);
    }

    /* access modifiers changed from: private */
    public void releaseResources() {
        Channel channel2 = this.channel;
        if (channel2 != null) {
            channel2.close();
        }
        this.channel = null;
        this.channelFactory = null;
        new NettyTerminator(this.bootstrap);
    }

    private void writeSocket(byte[] bArr) {
        if (getState() != 2) {
            logError("Trying to write to disconnected socket");
            return;
        }
        Channel channel2 = this.channel;
        if (channel2 != null) {
            try {
                channel2.write(ChannelBuffers.wrappedBuffer(bArr));
            } catch (Exception e2) {
                Logger logger = this.log;
                logger.warn("Unexpected error during socket write: " + e2.getMessage(), e2);
            }
        }
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.addEventListener(str, iEventListener);
    }

    public void connect(String str, int i) {
        if (getState() != 0) {
            logWarn("Calling connect when the socket is not disconnected");
            return;
        }
        initNetty();
        this.socketNumber = i;
        this.ipAddress = str;
        this.fsm.applyTransition(0);
        ClientBootstrap clientBootstrap = new ClientBootstrap(this.channelFactory);
        this.bootstrap = clientBootstrap;
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new NettyIOHandler(TCPSocketLayer.this, null));
            }
        });
        this.bootstrap.connect(new InetSocketAddress(this.ipAddress, this.socketNumber));
    }

    public void disconnect() {
        disconnect(null);
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public int getSocketPollSleep() {
        return this.socketPollSleep;
    }

    public int getState() {
        return this.fsm.getCurrentState();
    }

    public boolean isConnected() {
        return getState() == 2;
    }

    public void kill() {
        this.channel.disconnect();
    }

    public boolean requiresConnection() {
        return true;
    }

    public void setSocketPollSleep(int i) {
        this.socketPollSleep = i;
    }

    public void write(byte[] bArr) {
        writeSocket(bArr);
    }

    private void handleDisconnection(String str) {
        if (getState() != 0) {
            this.fsm.applyTransition(3);
            if (str == null) {
                callOnDisconnect();
            }
        }
    }

    public void disconnect(String str) {
        if (getState() != 2) {
            logWarn("Calling disconnect when the socket is not connected");
            return;
        }
        try {
            this.channel.disconnect();
        } catch (Exception e2) {
            logWarn(GeneratedOutlineSupport.outline39(e2, new StringBuilder("Disconnection error: ")));
        }
        handleDisconnection(str);
    }
}
