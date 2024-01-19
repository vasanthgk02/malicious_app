package org.jboss.netty.channel.socket.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.reactnativecommunity.webview.RNCWebViewManager;
import io.sentry.Attachment;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.SocketAddress;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.FTPReply;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.local.DefaultLocalClientChannelFactory;
import org.jboss.netty.channel.local.LocalAddress;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.http.HttpHeaders.Values;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class HttpTunnelingServlet extends HttpServlet {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ENDPOINT = "endpoint";
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(HttpTunnelingServlet.class);
    public static final long serialVersionUID = 4259910275899756070L;
    public volatile ChannelFactory channelFactory;
    public volatile SocketAddress remoteAddress;

    public static final class OutboundConnectionHandler extends SimpleChannelUpstreamHandler {
        public final ServletOutputStream out;

        public OutboundConnectionHandler(ServletOutputStream servletOutputStream) {
            this.out = servletOutputStream;
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
            HttpTunnelingServlet.logger.warn("Unexpected exception while HTTP tunneling", exceptionEvent.getCause());
            exceptionEvent.getChannel().close();
        }

        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
            ChannelBuffer channelBuffer = (ChannelBuffer) messageEvent.getMessage();
            synchronized (this) {
                channelBuffer.readBytes((OutputStream) this.out, channelBuffer.readableBytes());
                this.out.flush();
            }
        }
    }

    static {
        Class<HttpTunnelingServlet> cls = HttpTunnelingServlet.class;
    }

    public static ChannelBuffer read(PushbackInputStream pushbackInputStream) throws IOException {
        int i;
        byte[] bArr;
        ChannelBuffer channelBuffer;
        int available = pushbackInputStream.available();
        if (available > 0) {
            bArr = new byte[available];
            i = pushbackInputStream.read(bArr);
        } else {
            if (available == 0) {
                int read = pushbackInputStream.read();
                if (read >= 0 && pushbackInputStream.available() >= 0) {
                    pushbackInputStream.unread(read);
                    bArr = new byte[pushbackInputStream.available()];
                    i = pushbackInputStream.read(bArr);
                }
            }
            return null;
        }
        if (i == bArr.length) {
            channelBuffer = ChannelBuffers.wrappedBuffer(bArr);
        } else {
            channelBuffer = ChannelBuffers.wrappedBuffer(bArr, 0, i);
        }
        return channelBuffer;
    }

    public ChannelFactory createChannelFactory(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof LocalAddress) {
            return new DefaultLocalClientChannelFactory();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported remote address type: ");
        outline73.append(socketAddress.getClass().getName());
        throw new ServletException(outline73.toString());
    }

    public void destroy() {
        try {
            destroyChannelFactory(this.channelFactory);
        } catch (Exception e2) {
            logger.warn("Failed to destroy a channel factory.", e2);
        }
    }

    public void destroyChannelFactory(ChannelFactory channelFactory2) throws Exception {
        channelFactory2.releaseExternalResources();
    }

    public void init() throws ServletException {
        String initParameter = getServletConfig().getInitParameter(ENDPOINT);
        if (initParameter != null) {
            try {
                this.remoteAddress = parseEndpoint(initParameter.trim());
                try {
                    this.channelFactory = createChannelFactory(this.remoteAddress);
                } catch (ServletException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new ServletException("Failed to create a channel factory.", e3);
                }
            } catch (ServletException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new ServletException("Failed to parse an endpoint.", e5);
            }
        } else {
            throw new ServletException("init-param 'endpoint' must be specified.");
        }
    }

    public SocketAddress parseEndpoint(String str) throws Exception {
        if (str.startsWith("local:")) {
            return new LocalAddress(str.substring(6).trim());
        }
        throw new ServletException(GeneratedOutlineSupport.outline50("Invalid or unknown endpoint: ", str));
    }

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!RNCWebViewManager.HTTP_METHOD_POST.equalsIgnoreCase(httpServletRequest.getMethod())) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unallowed method: ");
            outline73.append(httpServletRequest.getMethod());
            internalLogger.warn(outline73.toString());
            httpServletResponse.sendError(405);
            return;
        }
        ChannelPipeline pipeline = Channels.pipeline();
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        pipeline.addLast("handler", new OutboundConnectionHandler(outputStream));
        Channel newChannel = this.channelFactory.newChannel(pipeline);
        ChannelFuture awaitUninterruptibly = newChannel.connect(this.remoteAddress).awaitUninterruptibly();
        if (!awaitUninterruptibly.isSuccess()) {
            Throwable cause = awaitUninterruptibly.getCause();
            InternalLogger internalLogger2 = logger;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Endpoint unavailable: ");
            outline732.append(cause.getMessage());
            internalLogger2.warn(outline732.toString(), cause);
            httpServletResponse.sendError(FTPReply.BAD_COMMAND_SEQUENCE);
            return;
        }
        ChannelFuture channelFuture = null;
        try {
            httpServletResponse.setStatus(200);
            httpServletResponse.setHeader("Content-Type", Attachment.DEFAULT_CONTENT_TYPE);
            httpServletResponse.setHeader(Names.CONTENT_TRANSFER_ENCODING, Values.BINARY);
            outputStream.flush();
            PushbackInputStream pushbackInputStream = new PushbackInputStream(httpServletRequest.getInputStream());
            while (newChannel.isConnected()) {
                try {
                    ChannelBuffer read = read(pushbackInputStream);
                    if (read == null) {
                        break;
                    }
                    channelFuture = newChannel.write(read);
                } catch (EOFException unused) {
                }
            }
            if (channelFuture != null) {
                channelFuture.addListener(ChannelFutureListener.CLOSE);
            }
        } finally {
            if (channelFuture == null) {
                newChannel.close();
            } else {
                channelFuture.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }
}
