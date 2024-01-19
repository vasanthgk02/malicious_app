package org.jboss.netty.util.internal.jzlib;

public final class JZlib {
    public static final int BL_CODES = 19;
    public static final int DEF_MEM_LEVEL = 8;
    public static final int DEF_WBITS = 15;
    public static final int D_CODES = 30;
    public static final int HEAP_SIZE = 573;
    public static final int LENGTH_CODES = 29;
    public static final int LITERALS = 256;
    public static final int L_CODES = 286;
    public static final int MANY = 1440;
    public static final int MAX_BITS = 15;
    public static final int MAX_BL_BITS = 7;
    public static final int MAX_MEM_LEVEL = 9;
    public static final int MAX_WBITS = 15;
    public static final int PRESET_DICT = 32;
    public static final Enum<?> W_GZIP = WrapperType.GZIP;
    public static final Enum<?> W_NONE = WrapperType.NONE;
    public static final Enum<?> W_ZLIB = WrapperType.ZLIB;
    public static final int Z_BEST_COMPRESSION = 9;
    public static final int Z_BEST_SPEED = 1;
    public static final int Z_BUF_ERROR = -5;
    public static final int Z_DATA_ERROR = -3;
    public static final int Z_DEFAULT_COMPRESSION = -1;
    public static final int Z_DEFAULT_STRATEGY = 0;
    public static final int Z_DEFLATED = 8;
    public static final int Z_ERRNO = -1;
    public static final int Z_FILTERED = 1;
    public static final int Z_FINISH = 4;
    public static final int Z_FULL_FLUSH = 3;
    public static final int Z_HUFFMAN_ONLY = 2;
    public static final int Z_MEM_ERROR = -4;
    public static final int Z_NEED_DICT = 2;
    public static final int Z_NO_COMPRESSION = 0;
    public static final int Z_NO_FLUSH = 0;
    public static final int Z_OK = 0;
    public static final int Z_PARTIAL_FLUSH = 1;
    public static final int Z_STREAM_END = 1;
    public static final int Z_STREAM_ERROR = -2;
    public static final int Z_SYNC_FLUSH = 2;
    public static final int Z_VERSION_ERROR = -6;

    public enum WrapperType {
        NONE,
        ZLIB,
        GZIP
    }
}
