package sfs2x.client.core.sockets;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.jboss.netty.bootstrap.ConnectionlessBootstrap;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.buffer.TruncatedChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.FixedReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelFactory;
import org.jboss.netty.channel.socket.nio.NioDatagramChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.IDispatchable;
import sfs2x.client.core.IEventListener;

public class UDPSocketLayer implements ISocketLayer, IDispatchable {
    public DatagramChannel channel;
    public EventDispatcher dispatcher = new EventDispatcher(this);
    public DatagramChannelFactory factory;
    public String ipAddress;
    public boolean isDisconnecting = false;
    public Logger log = LoggerFactory.getLogger(UDPSocketLayer.class);
    public int socketNumber;

    public class UDPClientHandler extends SimpleChannelUpstreamHandler {
        public UDPClientHandler() {
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
            UDPSocketLayer.this.channel.close();
            UDPSocketLayer uDPSocketLayer = UDPSocketLayer.this;
            uDPSocketLayer.handleError("Socket error: " + exceptionEvent.getCause().getMessage());
        }

        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
            try {
                UDPSocketLayer.this.handleBinaryData(((TruncatedChannelBuffer) messageEvent.getMessage()).array());
            } catch (Exception e2) {
                UDPSocketLayer uDPSocketLayer = UDPSocketLayer.this;
                uDPSocketLayer.handleError("General error reading data from socket: " + e2.getMessage());
            }
        }

        public /* synthetic */ UDPClientHandler(UDPSocketLayer uDPSocketLayer, UDPClientHandler uDPClientHandler) {
            this();
        }
    }

    private void callOnData(byte[] bArr) {
        SocketEvent socketEvent = new SocketEvent(SocketEvent.OnData);
        socketEvent.getArguments().put("data", bArr);
        this.dispatcher.dispatchEvent(socketEvent);
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
    public void handleError(final String str) {
        new Thread(new Runnable() {
            public void run() {
                UDPSocketLayer.this.handleErrorThread(str);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void handleErrorThread(String str) {
        releaseResources();
        if (!this.isDisconnecting) {
            logError(str);
            callOnError(str);
        }
    }

    private void logError(String str) {
        Logger logger = this.log;
        logger.error("UDPSocketLayer: " + str);
    }

    private void releaseResources() {
        DatagramChannel datagramChannel = this.channel;
        if (datagramChannel != null) {
            datagramChannel.close();
        }
        DatagramChannelFactory datagramChannelFactory = this.factory;
        if (datagramChannelFactory != null) {
            datagramChannelFactory.releaseExternalResources();
        }
        this.factory = null;
        this.channel = null;
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.addEventListener(str, iEventListener);
    }

    public void connect(String str, int i) {
        this.ipAddress = str;
        this.socketNumber = i;
        this.factory = new NioDatagramChannelFactory(Executors.newCachedThreadPool());
        ConnectionlessBootstrap connectionlessBootstrap = new ConnectionlessBootstrap(this.factory);
        connectionlessBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new UDPClientHandler(UDPSocketLayer.this, null));
            }
        });
        connectionlessBootstrap.setOption("broadcast", BaseParser.TRUE);
        connectionlessBootstrap.setOption("receiveBufferSizePredictorFactory", new FixedReceiveBufferSizePredictorFactory(1024));
        this.channel = (DatagramChannel) connectionlessBootstrap.bind(new InetSocketAddress(0));
    }

    public void disconnect() {
        this.isDisconnecting = true;
        releaseResources();
        this.isDisconnecting = false;
    }

    public void disconnect(String str) {
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public boolean isConnected() {
        return false;
    }

    public void kill() {
    }

    public boolean requiresConnection() {
        return false;
    }

    public void write(byte[] bArr) {
        try {
            if (this.channel != null) {
                this.channel.write(ChannelBuffers.wrappedBuffer(bArr), new InetSocketAddress(this.ipAddress, this.socketNumber));
            }
        } catch (Exception e2) {
            logError(GeneratedOutlineSupport.outline38(e2, new StringBuilder("Error writing UDP data: ")));
            handleError(e2.getLocalizedMessage());
        }
    }
}
