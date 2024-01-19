package org.jboss.netty.channel.socket.nio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class NioProviderMetadata {
    public static final int CONSTRAINT_LEVEL;
    public static final String CONSTRAINT_LEVEL_PROPERTY = "org.jboss.netty.channel.socket.nio.constraintLevel";
    public static final String OLD_CONSTRAINT_LEVEL_PROPERTY = "java.nio.channels.spi.constraintLevel";
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioProviderMetadata.class);

    public static final class ConstraintLevelAutodetector {
        /* JADX WARNING: Can't wrap try/catch for region: R(4:127|128|129|130) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:65|66|67|68) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:85|86|87|88) */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x0164 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x0171 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ca */
        /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x00d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0100 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x010d */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0150 A[SYNTHETIC, Splitter:B:119:0x0150] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0049 A[EDGE_INSN: B:140:0x0049->B:21:0x0049 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x003a A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x0086 A[EDGE_INSN: B:146:0x0086->B:38:0x0086 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x0077 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00ca A[LOOP:5: B:65:0x00ca->B:69:0x00d5, LOOP_START, SYNTHETIC, Splitter:B:65:0x00ca] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int autodetect() {
            /*
                r20 = this;
                java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newCachedThreadPool()
                r2 = 0
                r3 = 1
                r5 = -1
                r6 = 1
                java.nio.channels.ServerSocketChannel r7 = java.nio.channels.ServerSocketChannel.open()     // Catch:{ all -> 0x014d }
                java.net.ServerSocket r0 = r7.socket()     // Catch:{ all -> 0x0132 }
                java.net.InetSocketAddress r8 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0132 }
                r9 = 0
                r8.<init>(r9)     // Catch:{ all -> 0x0132 }
                r0.bind(r8)     // Catch:{ all -> 0x0132 }
                r7.configureBlocking(r9)     // Catch:{ all -> 0x0132 }
                org.jboss.netty.channel.socket.nio.NioProviderMetadata$SelectorLoop r8 = new org.jboss.netty.channel.socket.nio.NioProviderMetadata$SelectorLoop     // Catch:{ all -> 0x011c }
                r8.<init>()     // Catch:{ all -> 0x011c }
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x00e6 }
                r7.register(r0, r9)     // Catch:{ all -> 0x00e6 }
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x014b }
                java.nio.channels.SelectionKey r0 = r7.keyFor(r0)     // Catch:{ all -> 0x014b }
                r1.execute(r8)     // Catch:{ all -> 0x014b }
                r2 = 0
            L_0x0031:
                r10 = 500000000(0x1dcd6500, double:2.47032823E-315)
                r12 = 50
                r14 = 10
                if (r2 >= r14) goto L_0x006f
            L_0x003a:
                boolean r15 = r8.selecting     // Catch:{ all -> 0x014b }
                if (r15 != 0) goto L_0x0042
                java.lang.Thread.yield()     // Catch:{ all -> 0x014b }
                goto L_0x003a
            L_0x0042:
                java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x0045 }
            L_0x0045:
                boolean r15 = r8.selecting     // Catch:{ all -> 0x014b }
                if (r15 == 0) goto L_0x003a
                long r15 = java.lang.System.nanoTime()     // Catch:{ all -> 0x014b }
                int r17 = r0.interestOps()     // Catch:{ all -> 0x014b }
                r9 = r17 | 16
                r0.interestOps(r9)     // Catch:{ all -> 0x014b }
                int r9 = r0.interestOps()     // Catch:{ all -> 0x014b }
                r9 = r9 & -17
                r0.interestOps(r9)     // Catch:{ all -> 0x014b }
                long r18 = java.lang.System.nanoTime()     // Catch:{ all -> 0x014b }
                long r18 = r18 - r15
                int r9 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
                if (r9 < 0) goto L_0x006b
                r2 = 0
                goto L_0x0070
            L_0x006b:
                int r2 = r2 + 1
                r9 = 0
                goto L_0x0031
            L_0x006f:
                r2 = 1
            L_0x0070:
                if (r2 == 0) goto L_0x0074
                r9 = 0
                goto L_0x00b8
            L_0x0074:
                r2 = 0
            L_0x0075:
                if (r2 >= r14) goto L_0x00b2
            L_0x0077:
                boolean r9 = r8.selecting     // Catch:{ all -> 0x014b }
                if (r9 != 0) goto L_0x007f
                java.lang.Thread.yield()     // Catch:{ all -> 0x014b }
                goto L_0x0077
            L_0x007f:
                java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x0082 }
            L_0x0082:
                boolean r9 = r8.selecting     // Catch:{ all -> 0x014b }
                if (r9 == 0) goto L_0x0077
                long r15 = java.lang.System.nanoTime()     // Catch:{ all -> 0x014b }
                int r9 = r0.interestOps()     // Catch:{ all -> 0x014b }
                monitor-enter(r8)     // Catch:{ all -> 0x014b }
                java.nio.channels.Selector r12 = r8.selector     // Catch:{ all -> 0x00af }
                r12.wakeup()     // Catch:{ all -> 0x00af }
                r12 = r9 | 16
                r0.interestOps(r12)     // Catch:{ all -> 0x00af }
                r9 = r9 & -17
                r0.interestOps(r9)     // Catch:{ all -> 0x00af }
                monitor-exit(r8)     // Catch:{ all -> 0x00af }
                long r12 = java.lang.System.nanoTime()     // Catch:{ all -> 0x014b }
                long r12 = r12 - r15
                int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r9 < 0) goto L_0x00aa
                r9 = 0
                goto L_0x00b3
            L_0x00aa:
                int r2 = r2 + 1
                r12 = 50
                goto L_0x0075
            L_0x00af:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x00af }
                throw r0     // Catch:{ all -> 0x014b }
            L_0x00b2:
                r9 = 1
            L_0x00b3:
                if (r9 == 0) goto L_0x00b7
                r9 = 1
                goto L_0x00b8
            L_0x00b7:
                r9 = 2
            L_0x00b8:
                r7.close()     // Catch:{ all -> 0x00bc }
                goto L_0x00c5
            L_0x00bc:
                r0 = move-exception
                r2 = r0
                org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r5 = "Failed to close a temporary socket."
                r0.warn(r5, r2)
            L_0x00c5:
                r8.done = r6
                r1.shutdownNow()     // Catch:{ NullPointerException -> 0x00ca }
            L_0x00ca:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x00d7 }
                r0.wakeup()     // Catch:{ all -> 0x00d7 }
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
                boolean r0 = r1.awaitTermination(r3, r0)     // Catch:{  }
                if (r0 == 0) goto L_0x00ca
            L_0x00d7:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x00dd }
                r0.close()     // Catch:{ all -> 0x00dd }
                goto L_0x00e5
            L_0x00dd:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r1 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r2 = "Failed to close a temporary selector."
                r1.warn(r2, r0)
            L_0x00e5:
                return r9
            L_0x00e6:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r2 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger     // Catch:{ all -> 0x014b }
                java.lang.String r9 = "Failed to register a temporary selector."
                r2.warn(r9, r0)     // Catch:{ all -> 0x014b }
                r7.close()     // Catch:{ all -> 0x00f2 }
                goto L_0x00fb
            L_0x00f2:
                r0 = move-exception
                r2 = r0
                org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r7 = "Failed to close a temporary socket."
                r0.warn(r7, r2)
            L_0x00fb:
                r8.done = r6
                r1.shutdownNow()     // Catch:{ NullPointerException -> 0x0100 }
            L_0x0100:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x010d }
                r0.wakeup()     // Catch:{ all -> 0x010d }
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
                boolean r0 = r1.awaitTermination(r3, r0)     // Catch:{  }
                if (r0 == 0) goto L_0x0100
            L_0x010d:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x0113 }
                r0.close()     // Catch:{ all -> 0x0113 }
                goto L_0x011b
            L_0x0113:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r1 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r2 = "Failed to close a temporary selector."
                r1.warn(r2, r0)
            L_0x011b:
                return r5
            L_0x011c:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r8 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger     // Catch:{ all -> 0x014a }
                java.lang.String r9 = "Failed to open a temporary selector."
                r8.warn(r9, r0)     // Catch:{ all -> 0x014a }
                r7.close()     // Catch:{ all -> 0x0128 }
                goto L_0x0131
            L_0x0128:
                r0 = move-exception
                r1 = r0
                org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r2 = "Failed to close a temporary socket."
                r0.warn(r2, r1)
            L_0x0131:
                return r5
            L_0x0132:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r8 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger     // Catch:{ all -> 0x014a }
                java.lang.String r9 = "Failed to configure a temporary socket."
                r8.warn(r9, r0)     // Catch:{ all -> 0x014a }
                if (r7 == 0) goto L_0x0149
                r7.close()     // Catch:{ all -> 0x0140 }
                goto L_0x0149
            L_0x0140:
                r0 = move-exception
                r1 = r0
                org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r2 = "Failed to close a temporary socket."
                r0.warn(r2, r1)
            L_0x0149:
                return r5
            L_0x014a:
                r8 = r2
            L_0x014b:
                r2 = r7
                goto L_0x014e
            L_0x014d:
                r8 = r2
            L_0x014e:
                if (r2 == 0) goto L_0x015d
                r2.close()     // Catch:{ all -> 0x0154 }
                goto L_0x015d
            L_0x0154:
                r0 = move-exception
                r2 = r0
                org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r7 = "Failed to close a temporary socket."
                r0.warn(r7, r2)
            L_0x015d:
                if (r8 == 0) goto L_0x017f
                r8.done = r6
                r1.shutdownNow()     // Catch:{ NullPointerException -> 0x0164 }
            L_0x0164:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x0171 }
                r0.wakeup()     // Catch:{ all -> 0x0171 }
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{  }
                boolean r0 = r1.awaitTermination(r3, r0)     // Catch:{  }
                if (r0 == 0) goto L_0x0164
            L_0x0171:
                java.nio.channels.Selector r0 = r8.selector     // Catch:{ all -> 0x0177 }
                r0.close()     // Catch:{ all -> 0x0177 }
                goto L_0x017f
            L_0x0177:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r1 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.logger
                java.lang.String r2 = "Failed to close a temporary selector."
                r1.warn(r2, r0)
            L_0x017f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioProviderMetadata.ConstraintLevelAutodetector.autodetect():int");
        }
    }

    public static final class SelectorLoop implements Runnable {
        public volatile boolean done;
        public volatile boolean selecting;
        public final Selector selector = Selector.open();

        public void run() {
            while (!this.done) {
                synchronized (this) {
                }
                try {
                    this.selecting = true;
                    this.selector.select(1000);
                    this.selecting = false;
                    Set<SelectionKey> selectedKeys = this.selector.selectedKeys();
                    for (SelectionKey interestOps : selectedKeys) {
                        interestOps.interestOps(0);
                    }
                    selectedKeys.clear();
                } catch (IOException e2) {
                    NioProviderMetadata.logger.warn("Failed to wait for a temporary selector.", e2);
                } catch (Throwable th) {
                    this.selecting = false;
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    static {
        /*
            java.lang.Class<org.jboss.netty.channel.socket.nio.NioProviderMetadata> r0 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.class
            org.jboss.netty.logging.InternalLogger r0 = org.jboss.netty.logging.InternalLoggerFactory.getInstance(r0)
            logger = r0
            java.lang.String r0 = "org.jboss.netty.channel.socket.nio.constraintLevel"
            r1 = -1
            int r0 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r0, r1)
            r2 = 2
            if (r0 < 0) goto L_0x0017
            if (r0 <= r2) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = r0
            goto L_0x002a
        L_0x0017:
            java.lang.String r0 = "java.nio.channels.spi.constraintLevel"
            int r0 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r0, r1)
            if (r0 < 0) goto L_0x002a
            if (r0 <= r2) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            org.jboss.netty.logging.InternalLogger r1 = logger
            java.lang.String r3 = "System property 'java.nio.channels.spi.constraintLevel' has been deprecated.  Use 'org.jboss.netty.channel.socket.nio.constraintLevel' instead."
            r1.warn(r3)
            goto L_0x0015
        L_0x002a:
            if (r1 < 0) goto L_0x0042
            org.jboss.netty.logging.InternalLogger r0 = logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Setting the NIO constraint level to: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r0.debug(r3)
        L_0x0042:
            if (r1 >= 0) goto L_0x0085
            int r1 = detectConstraintLevelFromSystemProperties()
            if (r1 >= 0) goto L_0x0053
            org.jboss.netty.logging.InternalLogger r0 = logger
            java.lang.String r1 = "Couldn't determine the NIO constraint level from the system properties; using the safest level (2)"
            r0.debug(r1)
            r1 = 2
            goto L_0x0085
        L_0x0053:
            java.lang.String r0 = "Using the autodetected NIO constraint level: "
            if (r1 == 0) goto L_0x0071
            org.jboss.netty.logging.InternalLogger r3 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " (Use better NIO provider for better performance)"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.info(r0)
            goto L_0x0085
        L_0x0071:
            org.jboss.netty.logging.InternalLogger r3 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            r3.debug(r0)
        L_0x0085:
            CONSTRAINT_LEVEL = r1
            if (r1 < 0) goto L_0x008c
            if (r1 > r2) goto L_0x008c
            return
        L_0x008c:
            java.lang.Error r0 = new java.lang.Error
            java.lang.String r1 = "Unexpected NIO constraint level: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            int r2 = CONSTRAINT_LEVEL
            java.lang.String r3 = ", please report this error."
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline57(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioProviderMetadata.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x015e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int detectConstraintLevelFromSystemProperties() {
        /*
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r0)
            java.lang.String r1 = "java.vm.info"
            java.lang.String r2 = ""
            java.lang.String r1 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r1, r2)
            java.lang.String r2 = "os.name"
            java.lang.String r2 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r2)
            java.lang.String r3 = "java.vm.vendor"
            java.lang.String r3 = org.jboss.netty.util.internal.SystemPropertyUtil.get(r3)
            java.nio.channels.spi.SelectorProvider r4 = java.nio.channels.spi.SelectorProvider.provider()     // Catch:{ Exception -> 0x0027 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0028
        L_0x0027:
            r4 = 0
        L_0x0028:
            r5 = -1
            if (r0 == 0) goto L_0x015e
            if (r2 == 0) goto L_0x015e
            if (r3 == 0) goto L_0x015e
            if (r4 != 0) goto L_0x0033
            goto L_0x015e
        L_0x0033:
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r6 = "sun"
            int r7 = r3.indexOf(r6)
            java.lang.String r8 = "sun.nio.ch.WindowsSelectorProvider"
            java.lang.String r9 = "windows"
            java.lang.String r10 = "sun.nio.ch.EPollSelectorProvider"
            java.lang.String r11 = "linux"
            java.lang.String r12 = "sun.nio.ch.PollSelectorProvider"
            r13 = 0
            if (r7 < 0) goto L_0x008c
            int r0 = r2.indexOf(r11)
            if (r0 < 0) goto L_0x0066
            boolean r0 = r4.equals(r10)
            if (r0 != 0) goto L_0x0065
            boolean r0 = r4.equals(r12)
            if (r0 == 0) goto L_0x015e
        L_0x0065:
            return r13
        L_0x0066:
            int r0 = r2.indexOf(r9)
            if (r0 < 0) goto L_0x0073
            boolean r0 = r4.equals(r8)
            if (r0 == 0) goto L_0x015e
            return r13
        L_0x0073:
            int r0 = r2.indexOf(r6)
            if (r0 >= 0) goto L_0x0082
            java.lang.String r0 = "solaris"
            int r0 = r2.indexOf(r0)
            if (r0 < 0) goto L_0x015e
        L_0x0082:
            java.lang.String r0 = "sun.nio.ch.DevPollSelectorProvider"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x015e
            return r13
        L_0x008c:
            java.lang.String r6 = "apple"
            int r6 = r3.indexOf(r6)
            if (r6 < 0) goto L_0x00ae
            java.lang.String r0 = "mac"
            int r0 = r2.indexOf(r0)
            if (r0 < 0) goto L_0x015e
            java.lang.String r0 = "os"
            int r0 = r2.indexOf(r0)
            if (r0 < 0) goto L_0x015e
            java.lang.String r0 = "sun.nio.ch.KQueueSelectorProvider"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x015e
            return r13
        L_0x00ae:
            java.lang.String r6 = "ibm"
            int r6 = r3.indexOf(r6)
            r7 = 1
            if (r6 < 0) goto L_0x011c
            int r3 = r2.indexOf(r11)
            if (r3 >= 0) goto L_0x00c5
            java.lang.String r3 = "aix"
            int r2 = r2.indexOf(r3)
            if (r2 < 0) goto L_0x015e
        L_0x00c5:
            java.lang.String r2 = "1.5"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0115
            java.lang.String r2 = "^1\\.5\\D.*$"
            boolean r2 = r0.matches(r2)
            if (r2 == 0) goto L_0x00d6
            goto L_0x0115
        L_0x00d6:
            java.lang.String r2 = "1.6"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x00e6
            java.lang.String r2 = "^1\\.6\\D.*$"
            boolean r0 = r0.matches(r2)
            if (r0 == 0) goto L_0x015e
        L_0x00e6:
            java.lang.String r0 = "(?:^|[^0-9])([2-9][0-9]{3}(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01]))(?:$|[^0-9])"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x015e
            java.lang.String r0 = r0.group(r7)
            long r0 = java.lang.Long.parseLong(r0)
            r2 = 20081105(0x13269d1, double:9.921384E-317)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0107
            r0 = 2
            return r0
        L_0x0107:
            boolean r0 = r4.equals(r10)
            if (r0 == 0) goto L_0x010e
            return r13
        L_0x010e:
            boolean r0 = r4.equals(r12)
            if (r0 == 0) goto L_0x015e
            return r7
        L_0x0115:
            boolean r0 = r4.equals(r12)
            if (r0 == 0) goto L_0x015e
            return r7
        L_0x011c:
            java.lang.String r0 = "bea"
            int r0 = r3.indexOf(r0)
            if (r0 >= 0) goto L_0x013e
            java.lang.String r0 = "oracle"
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L_0x012d
            goto L_0x013e
        L_0x012d:
            java.lang.String r0 = "apache"
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L_0x015e
            java.lang.String r0 = "org.apache.harmony.nio.internal.SelectorProviderImpl"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x015e
            return r7
        L_0x013e:
            int r0 = r2.indexOf(r11)
            if (r0 < 0) goto L_0x0151
            boolean r0 = r4.equals(r10)
            if (r0 != 0) goto L_0x0150
            boolean r0 = r4.equals(r12)
            if (r0 == 0) goto L_0x015e
        L_0x0150:
            return r13
        L_0x0151:
            int r0 = r2.indexOf(r9)
            if (r0 < 0) goto L_0x015e
            boolean r0 = r4.equals(r8)
            if (r0 == 0) goto L_0x015e
            return r13
        L_0x015e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioProviderMetadata.detectConstraintLevelFromSystemProperties():int");
    }

    public static void main(String[] strArr) throws Exception {
        for (Entry entry : System.getProperties().entrySet()) {
            PrintStream printStream = System.out;
            printStream.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        PrintStream printStream2 = System.out;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hard-coded Constraint Level: ");
        outline73.append(CONSTRAINT_LEVEL);
        printStream2.println(outline73.toString());
        PrintStream printStream3 = System.out;
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Auto-detected Constraint Level: ");
        outline732.append(new ConstraintLevelAutodetector().autodetect());
        printStream3.println(outline732.toString());
    }
}
