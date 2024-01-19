package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.Selector;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public final class SelectorUtil {
    public static final int DEFAULT_IO_THREADS = (Runtime.getRuntime().availableProcessors() * 2);
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(SelectorUtil.class);

    public static void select(Selector selector) throws IOException {
        try {
            selector.select(500);
        } catch (CancelledKeyException e2) {
            InternalLogger internalLogger = logger;
            internalLogger.debug(CancelledKeyException.class.getSimpleName() + " raised by a Selector - JDK bug?", e2);
        }
    }
}
