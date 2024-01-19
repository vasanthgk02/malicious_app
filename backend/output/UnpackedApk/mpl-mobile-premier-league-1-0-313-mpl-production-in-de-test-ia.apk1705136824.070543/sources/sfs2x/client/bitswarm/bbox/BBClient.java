package sfs2x.client.bitswarm.bbox;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.models.ExoPlayerConfig;
import com.squareup.picasso.NetworkRequestHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.http.DefaultHttpRequest;
import org.jboss.netty.handler.codec.http.HttpChunk;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpClientCodec;
import org.jboss.netty.handler.codec.http.HttpContentDecompressor;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.SmartFox;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.core.IDispatchable;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.sockets.NettyTerminator;
import sfs2x.client.util.Base64;
import sfs2x.client.util.ByteArray;

public class BBClient implements IDispatchable {
    public final String BB_DEFAULT_HOST;
    public final int BB_DEFAULT_PORT;
    public final String BB_NULL;
    public final String BB_SERVLET;
    public final String CMD_CONNECT;
    public final String CMD_DATA;
    public final String CMD_POLL;
    public final int DEFAULT_POLL_SPEED;
    public final String ERR_INVALID_SESSION;
    public final int MAX_POLL_SPEED;
    public final int MIN_POLL_SPEED;
    public final int POLLING_TIMEOUT;
    public final String SEP;
    public final String SFS_HTTP;
    public String bbUrl;
    public BitSwarmClient bitswarm;
    public ClientBootstrap bootstrap;
    public Channel channel;
    public boolean debug;
    public EventDispatcher dispatcher;
    public String host;
    public boolean isConnected;
    public long lastPollingTime;
    public final Logger log;
    public final Runnable pollRunner;
    public final ScheduledExecutorService pollScheduler;
    public int pollSpeed;
    public int port;
    public String sessId;
    public URI uri;

    public final class BBChannelFutureListener implements ChannelFutureListener {
        public final HttpRequest request;

        public BBChannelFutureListener(HttpRequest httpRequest) {
            this.request = httpRequest;
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            BBClient.this.channel = channelFuture.getChannel();
            BBClient.this.channel.write(this.request);
        }
    }

    public class HttpClientPipelineFactory implements ChannelPipelineFactory {
        public final boolean ssl;

        public HttpClientPipelineFactory(boolean z) {
            this.ssl = z;
        }

        public ChannelPipeline getPipeline() throws Exception {
            DefaultChannelPipeline defaultChannelPipeline = new DefaultChannelPipeline();
            defaultChannelPipeline.addLast("codec", new HttpClientCodec());
            defaultChannelPipeline.addLast("inflater", new HttpContentDecompressor());
            defaultChannelPipeline.addLast("aggregator", new HttpChunkAggregator(1048576));
            defaultChannelPipeline.addLast("handler", new HttpResponseHandler(BBClient.this, null));
            return defaultChannelPipeline;
        }
    }

    public class HttpResponseHandler extends SimpleChannelUpstreamHandler {
        public boolean readingChunks;

        public HttpResponseHandler() {
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
            if (!(exceptionEvent.getCause() instanceof ConnectException)) {
                return;
            }
            if (BBClient.this.bitswarm == null || BBClient.this.bitswarm.getSfs().isConnecting()) {
                BBClient.this.onHttpError(exceptionEvent.getCause(), true);
            } else {
                BBClient.this.onHttpError(exceptionEvent.getCause(), false);
            }
        }

        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
            if (!this.readingChunks) {
                HttpResponse httpResponse = (HttpResponse) messageEvent.getMessage();
                if (httpResponse.getStatus().getCode() != 200 || !httpResponse.isChunked()) {
                    BBClient.this.onHttpResponse(httpResponse.getContent().toString(CharsetUtil.UTF_8));
                    return;
                }
                this.readingChunks = true;
            } else if (((HttpChunk) messageEvent.getMessage()).isLast()) {
                this.readingChunks = false;
            }
        }

        public /* synthetic */ HttpResponseHandler(BBClient bBClient, HttpResponseHandler httpResponseHandler) {
            this();
        }
    }

    public final class PollRunner implements Runnable {
        public PollRunner() {
        }

        public void run() {
            BBClient.this.poll();
        }

        public /* synthetic */ PollRunner(BBClient bBClient, PollRunner pollRunner) {
            this();
        }
    }

    public final class PollTimeOutMonitor implements Runnable {
        public PollTimeOutMonitor() {
            BBClient.this.lastPollingTime = System.currentTimeMillis();
        }

        public void run() {
            if (System.currentTimeMillis() > BBClient.this.lastPollingTime + ExoPlayerConfig.DEFAULT_LIVE_OFFSET_MS) {
                BBClient.this.dispatchEvent(new BBEvent(BBEvent.DISCONNECT, GeneratedOutlineSupport.outline87("reason", "unknown")));
                BBClient.this.pollScheduler.shutdownNow();
            }
        }
    }

    public BBClient() {
        this.BB_DEFAULT_HOST = "localhost";
        this.BB_DEFAULT_PORT = SmartFox.DEFAULT_HTTP_PORT;
        this.BB_SERVLET = "BlueBox/BlueBox.do";
        this.BB_NULL = "null";
        this.CMD_CONNECT = "connect";
        this.CMD_POLL = "poll";
        this.CMD_DATA = "data";
        this.ERR_INVALID_SESSION = "err01";
        this.SFS_HTTP = "sfsHttp";
        this.SEP = "|";
        this.MIN_POLL_SPEED = 50;
        this.MAX_POLL_SPEED = 5000;
        this.DEFAULT_POLL_SPEED = 300;
        this.POLLING_TIMEOUT = 45000;
        this.isConnected = false;
        this.host = "localhost";
        this.port = SmartFox.DEFAULT_HTTP_PORT;
        this.sessId = null;
        this.pollSpeed = 300;
        this.lastPollingTime = 0;
        this.log = LoggerFactory.getLogger(BBClient.class);
        this.pollScheduler = new ScheduledThreadPoolExecutor(3);
        this.pollRunner = new PollRunner(this, null);
    }

    /* access modifiers changed from: private */
    public HttpRequest createRequest(String str, Object obj) {
        String encodeRequest = encodeRequest(str, obj);
        DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, this.uri.toASCIIString());
        defaultHttpRequest.setHeader((String) "Host", (Object) this.host);
        defaultHttpRequest.setHeader((String) "Connection", (Object) "close");
        defaultHttpRequest.setHeader((String) "Content-Type", (Object) "application/x-www-form-urlencoded");
        defaultHttpRequest.setHeader((String) "Accept-Encoding", (Object) "gzip");
        byte[] bArr = new byte[0];
        try {
            bArr = ("sfsHttp=" + encodeRequest).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            this.log.warn("Unsupported encoding: " + e2.getLocalizedMessage());
        }
        defaultHttpRequest.setContent(ChannelBuffers.copiedBuffer(bArr));
        defaultHttpRequest.setHeader((String) "Content-Length", (Object) Integer.valueOf(bArr.length));
        return defaultHttpRequest;
    }

    private ByteArray decodeResponse(String str) throws IOException {
        return new ByteArray(fromBase64String(str));
    }

    /* access modifiers changed from: private */
    public void dispatchEvent(BaseEvent baseEvent) {
        this.dispatcher.dispatchEvent(baseEvent);
    }

    private String encodeRequest(String str, Object obj) {
        String str2 = "null";
        if (str == 0) {
            str = str2;
        }
        if (obj == 0) {
            obj = str2;
        } else if (obj instanceof ByteArray) {
            obj = toBase64String(((ByteArray) obj).getBytes());
        }
        StringBuilder sb = new StringBuilder("");
        String str3 = this.sessId;
        if (str3 != 0) {
            str2 = str3;
        }
        GeneratedOutlineSupport.outline103(sb, str2, "|", str, "|");
        sb.append(obj);
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Unable to encode BlueBox Message. Missing UTF-8 support!");
        }
    }

    private byte[] fromBase64String(String str) throws IOException {
        return Base64.decode(str);
    }

    private void handleConnectionLost(boolean z) {
        handleConnectionLost(z, null);
    }

    private void init(BitSwarmClient bitSwarmClient, String str, int i, boolean z) {
        this.bitswarm = bitSwarmClient;
        this.host = str;
        this.port = i;
        setDebug(z);
        if (this.dispatcher == null) {
            this.dispatcher = new EventDispatcher(this);
        }
    }

    /* access modifiers changed from: private */
    public void onHttpError(Throwable th, boolean z) {
        handleConnectionLost(z);
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.getMessage());
        dispatchEvent(new BBEvent(BBEvent.IO_ERROR, hashMap));
    }

    /* access modifiers changed from: private */
    public void onHttpResponse(String str) {
        try {
            if (isDebug()) {
                Logger logger = this.log;
                logger.info("[ BB-Receive ]: " + str);
            }
            String[] split = str.split("\\|");
            if (split.length >= 2) {
                String str2 = split[0];
                String str3 = split[1];
                if (str2.equals("connect")) {
                    this.sessId = str3;
                    this.isConnected = true;
                    dispatchEvent(new BBEvent(BBEvent.CONNECT));
                    this.pollScheduler.scheduleAtFixedRate(new PollTimeOutMonitor(), 0, ExoPlayerConfig.DEFAULT_LIVE_OFFSET_MS, TimeUnit.MILLISECONDS);
                    pollNext();
                } else if (str2.equals("poll")) {
                    ByteArray byteArray = null;
                    if (!str3.equals("null")) {
                        byteArray = decodeResponse(str3);
                    }
                    pollNext();
                    if (byteArray != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("data", byteArray);
                        dispatchEvent(new BBEvent(BBEvent.DATA, hashMap));
                    }
                } else if (str2.equals("err01")) {
                    onHttpError(new Exception("Invalid BB session !"), false);
                }
            }
        } catch (Exception e2) {
            onHttpError(e2, false);
        }
    }

    /* access modifiers changed from: private */
    public void poll() {
        if (this.isConnected) {
            this.lastPollingTime = System.currentTimeMillis();
            sendRequest("poll");
        }
    }

    private void pollNext() {
        if (this.isConnected) {
            this.pollScheduler.schedule(this.pollRunner, (long) getPollSpeed(), TimeUnit.MILLISECONDS);
        }
    }

    private void sendRequest(String str) {
        sendRequest(str, null);
    }

    private String toBase64String(byte[] bArr) {
        return Base64.encodeBytes(bArr);
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        this.dispatcher.addEventListener(str, iEventListener);
    }

    public void close(String str) {
        handleConnectionLost(true, str);
    }

    public void connect() {
        connect("127.0.0.1", SmartFox.DEFAULT_HTTP_PORT);
    }

    public EventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public String getHost() {
        return this.host;
    }

    public int getPollSpeed() {
        return this.pollSpeed;
    }

    public int getPort() {
        return this.port;
    }

    public String getSessionId() {
        return this.sessId;
    }

    public boolean isConnected() {
        return this.sessId != null;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void send(ByteArray byteArray) {
        if (!this.isConnected) {
            this.log.warn("BB sending error: can't send data, BlueBox connection is not active");
        }
        try {
            sendRequest("data", byteArray);
        } catch (Exception e2) {
            Logger logger = this.log;
            logger.warn("BB sending error: " + e2.getMessage());
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setPollSpeed(int i) {
        if (i < 50 || i > 5000) {
            i = 300;
        }
        this.pollSpeed = i;
    }

    private void handleConnectionLost(boolean z, String str) {
        try {
            if (this.isConnected) {
                this.isConnected = false;
                this.sessId = null;
                this.pollScheduler.shutdownNow();
                this.channel.close();
                this.channel = null;
                if (z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reason", str);
                    dispatchEvent(new BBEvent(BBEvent.DISCONNECT, hashMap));
                }
            }
        } finally {
            new NettyTerminator(this.bootstrap);
        }
    }

    private void sendRequest(final String str, final Object obj) {
        this.pollScheduler.submit(new Runnable() {
            public void run() {
                BBClient.this.bootstrap.connect(new InetSocketAddress(BBClient.this.host, BBClient.this.port)).addListener(new BBChannelFutureListener(BBClient.this.createRequest(str, obj)));
            }
        });
    }

    public void connect(String str) {
        connect(str, SmartFox.DEFAULT_HTTP_PORT);
    }

    public void connect(String str, int i) {
        if (this.isConnected) {
            this.log.warn("BB is already connected!");
            return;
        }
        this.host = str;
        this.port = i;
        this.bbUrl = "https://" + str + ":" + i + "/" + "BlueBox/BlueBox.do";
        try {
            this.uri = new URI(this.bbUrl);
            this.bootstrap = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
            this.bootstrap.setPipelineFactory(new HttpClientPipelineFactory((this.uri.getScheme() == null ? NetworkRequestHandler.SCHEME_HTTP : this.uri.getScheme()).equalsIgnoreCase(NetworkRequestHandler.SCHEME_HTTPS)));
            sendRequest("connect");
        } catch (URISyntaxException unused) {
            Logger logger = this.log;
            logger.warn("Wrong uri: " + this.bbUrl);
        }
    }

    public BBClient(BitSwarmClient bitSwarmClient) {
        this();
        init(bitSwarmClient, "localhost", SmartFox.DEFAULT_HTTP_PORT, false);
    }

    public BBClient(String str, BitSwarmClient bitSwarmClient) {
        this();
        init(bitSwarmClient, str, SmartFox.DEFAULT_HTTP_PORT, false);
    }

    public BBClient(String str, int i, BitSwarmClient bitSwarmClient) {
        this();
        init(bitSwarmClient, str, i, false);
    }

    public BBClient(String str, int i, boolean z, BitSwarmClient bitSwarmClient) {
        this();
        init(bitSwarmClient, str, i, z);
    }
}
