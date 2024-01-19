package org.jboss.netty.buffer;

public interface ChannelBufferIndexFinder {
    public static final ChannelBufferIndexFinder CR = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) == 13;
        }
    };
    public static final ChannelBufferIndexFinder CRLF = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            byte b2 = channelBuffer.getByte(i);
            return b2 == 13 || b2 == 10;
        }
    };
    public static final ChannelBufferIndexFinder LF = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) == 10;
        }
    };
    public static final ChannelBufferIndexFinder LINEAR_WHITESPACE = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            byte b2 = channelBuffer.getByte(i);
            return b2 == 32 || b2 == 9;
        }
    };
    public static final ChannelBufferIndexFinder NOT_CR = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) != 13;
        }
    };
    public static final ChannelBufferIndexFinder NOT_CRLF = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            byte b2 = channelBuffer.getByte(i);
            return (b2 == 13 || b2 == 10) ? false : true;
        }
    };
    public static final ChannelBufferIndexFinder NOT_LF = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) != 10;
        }
    };
    public static final ChannelBufferIndexFinder NOT_LINEAR_WHITESPACE = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            byte b2 = channelBuffer.getByte(i);
            return (b2 == 32 || b2 == 9) ? false : true;
        }
    };
    public static final ChannelBufferIndexFinder NOT_NUL = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) != 0;
        }
    };
    public static final ChannelBufferIndexFinder NUL = new ChannelBufferIndexFinder() {
        public boolean find(ChannelBuffer channelBuffer, int i) {
            return channelBuffer.getByte(i) == 0;
        }
    };

    boolean find(ChannelBuffer channelBuffer, int i);
}
