package org.jboss.netty.channel.socket.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.Attachment;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.handler.codec.http.DefaultHttpChunk;
import org.jboss.netty.handler.codec.http.DefaultHttpRequest;
import org.jboss.netty.handler.codec.http.HttpChunk;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.http.HttpHeaders.Values;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequestEncoder;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.handler.ssl.SslHandler;

public class HttpTunnelingClientSocketChannel extends AbstractChannel implements SocketChannel {
    public final HttpTunnelingSocketChannelConfig config = new HttpTunnelingSocketChannelConfig(this);
    public final ServletChannelHandler handler = new ServletChannelHandler();
    public final Object interestOpsLock = new Object();
    public final SocketChannel realChannel;
    public volatile boolean requestHeaderWritten;

    public final class ServletChannelHandler extends SimpleChannelUpstreamHandler {
        public volatile boolean readingChunks;
        public final SocketChannel virtualChannel = HttpTunnelingClientSocketChannel.this;

        public ServletChannelHandler() {
        }

        public void channelBound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
            Channels.fireChannelBound((Channel) this.virtualChannel, (SocketAddress) channelStateEvent.getValue());
        }

        public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
            Channels.fireChannelClosed((Channel) this.virtualChannel);
        }

        public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
            Channels.fireChannelDisconnected((Channel) this.virtualChannel);
        }

        public void channelInterestChanged(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
            Channels.fireChannelInterestChanged((Channel) this.virtualChannel);
        }

        public void channelUnbound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
            Channels.fireChannelUnbound((Channel) this.virtualChannel);
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
            Channels.fireExceptionCaught((Channel) this.virtualChannel, exceptionEvent.getCause());
            HttpTunnelingClientSocketChannel.this.realChannel.close();
        }

        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
            if (!this.readingChunks) {
                HttpResponse httpResponse = (HttpResponse) messageEvent.getMessage();
                if (httpResponse.getStatus().getCode() != HttpResponseStatus.OK.getCode()) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected HTTP response status: ");
                    outline73.append(httpResponse.getStatus());
                    throw new ChannelException(outline73.toString());
                } else if (httpResponse.isChunked()) {
                    this.readingChunks = true;
                } else {
                    ChannelBuffer content = httpResponse.getContent();
                    if (content.readable()) {
                        Channels.fireMessageReceived((Channel) HttpTunnelingClientSocketChannel.this, (Object) content);
                    }
                    HttpTunnelingClientSocketChannel.this.closeReal(Channels.succeededFuture(this.virtualChannel));
                }
            } else {
                HttpChunk httpChunk = (HttpChunk) messageEvent.getMessage();
                if (!httpChunk.isLast()) {
                    Channels.fireMessageReceived((Channel) HttpTunnelingClientSocketChannel.this, (Object) httpChunk.getContent());
                    return;
                }
                this.readingChunks = false;
                HttpTunnelingClientSocketChannel.this.closeReal(Channels.succeededFuture(this.virtualChannel));
            }
        }
    }

    public HttpTunnelingClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, ClientSocketChannelFactory clientSocketChannelFactory) {
        super(null, channelFactory, channelPipeline, channelSink);
        DefaultChannelPipeline defaultChannelPipeline = new DefaultChannelPipeline();
        defaultChannelPipeline.addLast("decoder", new HttpResponseDecoder());
        defaultChannelPipeline.addLast("encoder", new HttpRequestEncoder());
        defaultChannelPipeline.addLast("handler", this.handler);
        this.realChannel = clientSocketChannelFactory.newChannel(defaultChannelPipeline);
        Channels.fireChannelOpen((Channel) this);
    }

    private ChannelFuture writeLastChunk() {
        if (this.requestHeaderWritten) {
            return this.realChannel.write(HttpChunk.LAST_CHUNK);
        }
        throw new NotYetConnectedException();
    }

    public void bindReal(SocketAddress socketAddress, final ChannelFuture channelFuture) {
        this.realChannel.bind(socketAddress).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    channelFuture.setSuccess();
                } else {
                    channelFuture.setFailure(channelFuture.getCause());
                }
            }
        });
    }

    public void closeReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                HttpTunnelingClientSocketChannel.this.realChannel.close().addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture.getCause());
                        }
                        HttpTunnelingClientSocketChannel.this.setClosed();
                    }
                });
            }
        });
    }

    public void connectReal(final SocketAddress socketAddress, final ChannelFuture channelFuture) {
        this.realChannel.connect(socketAddress).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                SSLEngine sSLEngine;
                String serverName = HttpTunnelingClientSocketChannel.this.config.getServerName();
                int port = ((InetSocketAddress) socketAddress).getPort();
                String serverPath = HttpTunnelingClientSocketChannel.this.config.getServerPath();
                if (channelFuture.isSuccess()) {
                    SSLContext sslContext = HttpTunnelingClientSocketChannel.this.config.getSslContext();
                    ChannelFuture channelFuture2 = null;
                    if (sslContext != null) {
                        if (serverName != null) {
                            sSLEngine = sslContext.createSSLEngine(serverName, port);
                        } else {
                            sSLEngine = sslContext.createSSLEngine();
                        }
                        sSLEngine.setUseClientMode(true);
                        sSLEngine.setEnableSessionCreation(HttpTunnelingClientSocketChannel.this.config.isEnableSslSessionCreation());
                        String[] enabledSslCipherSuites = HttpTunnelingClientSocketChannel.this.config.getEnabledSslCipherSuites();
                        if (enabledSslCipherSuites != null) {
                            sSLEngine.setEnabledCipherSuites(enabledSslCipherSuites);
                        }
                        String[] enabledSslProtocols = HttpTunnelingClientSocketChannel.this.config.getEnabledSslProtocols();
                        if (enabledSslProtocols != null) {
                            sSLEngine.setEnabledProtocols(enabledSslProtocols);
                        }
                        SslHandler sslHandler = new SslHandler(sSLEngine);
                        HttpTunnelingClientSocketChannel.this.realChannel.getPipeline().addFirst("ssl", sslHandler);
                        channelFuture2 = sslHandler.handshake();
                    }
                    final DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, serverPath);
                    if (serverName != null) {
                        defaultHttpRequest.setHeader((String) "Host", (Object) serverName);
                    }
                    defaultHttpRequest.setHeader((String) "Content-Type", (Object) Attachment.DEFAULT_CONTENT_TYPE);
                    defaultHttpRequest.setHeader((String) Names.TRANSFER_ENCODING, (Object) Values.CHUNKED);
                    defaultHttpRequest.setHeader((String) Names.CONTENT_TRANSFER_ENCODING, (Object) Values.BINARY);
                    defaultHttpRequest.setHeader((String) "User-Agent", (Object) HttpTunnelingClientSocketChannel.class.getName());
                    if (channelFuture2 == null) {
                        HttpTunnelingClientSocketChannel.this.realChannel.write(defaultHttpRequest);
                        HttpTunnelingClientSocketChannel.this.requestHeaderWritten = true;
                        channelFuture.setSuccess();
                        Channels.fireChannelConnected((Channel) this, socketAddress);
                        return;
                    }
                    channelFuture2.addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                HttpTunnelingClientSocketChannel.this.realChannel.write(defaultHttpRequest);
                                HttpTunnelingClientSocketChannel.this.requestHeaderWritten = true;
                                channelFuture.setSuccess();
                                AnonymousClass2 r3 = AnonymousClass2.this;
                                Channels.fireChannelConnected((Channel) this, socketAddress);
                                return;
                            }
                            channelFuture.setFailure(channelFuture.getCause());
                            Channels.fireExceptionCaught((Channel) this, channelFuture.getCause());
                        }
                    });
                    return;
                }
                channelFuture.setFailure(channelFuture.getCause());
                Channels.fireExceptionCaught((Channel) this, channelFuture.getCause());
            }
        });
    }

    public void disconnectReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                HttpTunnelingClientSocketChannel.this.realChannel.disconnect().addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture.getCause());
                        }
                    }
                });
            }
        });
    }

    public int getInterestOps() {
        return this.realChannel.getInterestOps();
    }

    public boolean isBound() {
        return this.realChannel.isBound();
    }

    public boolean isConnected() {
        return this.realChannel.isConnected();
    }

    public boolean isWritable() {
        return this.realChannel.isWritable();
    }

    public boolean setClosed() {
        return super.setClosed();
    }

    public void setInterestOpsReal(int i, final ChannelFuture channelFuture) {
        this.realChannel.setInterestOps(i).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    channelFuture.setSuccess();
                } else {
                    channelFuture.setFailure(channelFuture.getCause());
                }
            }
        });
    }

    public void unbindReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) {
                HttpTunnelingClientSocketChannel.this.realChannel.unbind().addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture.getCause());
                        }
                    }
                });
            }
        });
    }

    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        if (socketAddress == null || socketAddress.equals(getRemoteAddress())) {
            return super.write(obj, null);
        }
        return getUnsupportedOperationFuture();
    }

    public void writeReal(ChannelBuffer channelBuffer, final ChannelFuture channelFuture) {
        ChannelFuture channelFuture2;
        if (this.requestHeaderWritten) {
            final int readableBytes = channelBuffer.readableBytes();
            if (readableBytes == 0) {
                channelFuture2 = this.realChannel.write(ChannelBuffers.EMPTY_BUFFER);
            } else {
                channelFuture2 = this.realChannel.write(new DefaultHttpChunk(channelBuffer));
            }
            channelFuture2.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        channelFuture.setSuccess();
                        int i = readableBytes;
                        if (i != 0) {
                            Channels.fireWriteComplete((Channel) HttpTunnelingClientSocketChannel.this, (long) i);
                            return;
                        }
                        return;
                    }
                    channelFuture.setFailure(channelFuture.getCause());
                }
            });
            return;
        }
        throw new NotYetConnectedException();
    }

    public InetSocketAddress getLocalAddress() {
        return this.realChannel.getLocalAddress();
    }

    public InetSocketAddress getRemoteAddress() {
        return this.realChannel.getRemoteAddress();
    }

    public HttpTunnelingSocketChannelConfig getConfig() {
        return this.config;
    }
}