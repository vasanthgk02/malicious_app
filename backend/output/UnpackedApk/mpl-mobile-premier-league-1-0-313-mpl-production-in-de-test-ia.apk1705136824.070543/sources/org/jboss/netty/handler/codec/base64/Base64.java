package org.jboss.netty.handler.codec.base64;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.brentvatne.react.ReactVideoViewManager;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.HeapChannelBufferFactory;

public class Base64 {
    public static final byte EQUALS_SIGN = 61;
    public static final byte EQUALS_SIGN_ENC = -1;
    public static final int MAX_LINE_LENGTH = 76;
    public static final byte NEW_LINE = 10;
    public static final byte WHITE_SPACE_ENC = -5;

    public static final byte[] alphabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.alphabet;
        }
        throw new NullPointerException("dialect");
    }

    public static final boolean breakLines(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.breakLinesByDefault;
        }
        throw new NullPointerException("dialect");
    }

    public static final byte[] decodabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.decodabet;
        }
        throw new NullPointerException("dialect");
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer) {
        return decode(channelBuffer, Base64Dialect.STANDARD);
    }

    public static int decode4to3(byte[] bArr, int i, ChannelBuffer channelBuffer, int i2, Base64Dialect base64Dialect) {
        byte[] decodabet = decodabet(base64Dialect);
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            channelBuffer.setByte(i2, (byte) ((((decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16));
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            int i5 = (decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ;
            int i6 = ((decodabet[bArr[i3]] & 255) << 6) | i5 | ((decodabet[bArr[i]] & 255) << 18);
            channelBuffer.setByte(i2, (byte) (i6 >>> 16));
            channelBuffer.setByte(i2 + 1, (byte) (i6 >>> 8));
            return 2;
        }
        try {
            byte b2 = (decodabet[bArr[i4]] & 255) | ((decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i3]] & 255) << 6);
            channelBuffer.setByte(i2, (byte) (b2 >> GlyfDescript.X_DUAL));
            channelBuffer.setByte(i2 + 1, (byte) (b2 >> 8));
            channelBuffer.setByte(i2 + 2, (byte) b2);
            return 3;
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("not encoded in Base64");
        }
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer) {
        return encode(channelBuffer, Base64Dialect.STANDARD);
    }

    public static void encode3to4(ChannelBuffer channelBuffer, int i, int i2, ChannelBuffer channelBuffer2, int i3, Base64Dialect base64Dialect) {
        byte[] alphabet = alphabet(base64Dialect);
        int i4 = 0;
        int i5 = (i2 > 0 ? (channelBuffer.getByte(i) << 24) >>> 8 : 0) | (i2 > 1 ? (channelBuffer.getByte(i + 1) << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (channelBuffer.getByte(i + 2) << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            channelBuffer2.setByte(i3, alphabet[i6 >>> 18]);
            channelBuffer2.setByte(i3 + 1, alphabet[(i6 >>> 12) & 63]);
            channelBuffer2.setByte(i3 + 2, 61);
            channelBuffer2.setByte(i3 + 3, 61);
        } else if (i2 == 2) {
            channelBuffer2.setByte(i3, alphabet[i6 >>> 18]);
            channelBuffer2.setByte(i3 + 1, alphabet[(i6 >>> 12) & 63]);
            channelBuffer2.setByte(i3 + 2, alphabet[(i6 >>> 6) & 63]);
            channelBuffer2.setByte(i3 + 3, 61);
        } else if (i2 == 3) {
            channelBuffer2.setByte(i3, alphabet[i6 >>> 18]);
            channelBuffer2.setByte(i3 + 1, alphabet[(i6 >>> 12) & 63]);
            channelBuffer2.setByte(i3 + 2, alphabet[(i6 >>> 6) & 63]);
            channelBuffer2.setByte(i3 + 3, alphabet[i6 & 63]);
        }
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect) {
        return decode(channelBuffer, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect) {
        return encode(channelBuffer, breakLines(base64Dialect), base64Dialect);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, ChannelBufferFactory channelBufferFactory) {
        return decode(channelBuffer, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        if (channelBuffer != null) {
            ChannelBuffer decode = decode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), base64Dialect, channelBufferFactory);
            channelBuffer.readerIndex(channelBuffer.writerIndex());
            return decode;
        }
        throw new NullPointerException(ReactVideoViewManager.PROP_SRC);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, breakLines(base64Dialect), base64Dialect, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z) {
        return encode(channelBuffer, z, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, Base64Dialect base64Dialect) {
        return encode(channelBuffer, z, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2) {
        return decode(channelBuffer, i, i2, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, z, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect) {
        return decode(channelBuffer, i, i2, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        if (channelBuffer != null) {
            ChannelBuffer encode = encode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), z, base64Dialect, channelBufferFactory);
            channelBuffer.readerIndex(channelBuffer.writerIndex());
            return encode;
        }
        throw new NullPointerException(ReactVideoViewManager.PROP_SRC);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferFactory channelBufferFactory) {
        return decode(channelBuffer, i, i2, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        if (channelBuffer == null) {
            throw new NullPointerException(ReactVideoViewManager.PROP_SRC);
        } else if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        } else if (channelBufferFactory != null) {
            byte[] decodabet = decodabet(base64Dialect);
            ChannelBuffer buffer = channelBufferFactory.getBuffer(channelBuffer.order(), (i2 * 3) / 4);
            byte[] bArr = new byte[4];
            int i3 = 0;
            int i4 = 0;
            int i5 = i;
            while (i5 < i + i2) {
                byte b2 = (byte) (channelBuffer.getByte(i5) & Byte.MAX_VALUE);
                byte b3 = decodabet[b2];
                if (b3 >= -5) {
                    if (b3 >= -1) {
                        int i6 = i3 + 1;
                        bArr[i3] = b2;
                        if (i6 > 3) {
                            i4 += decode4to3(bArr, 0, buffer, i4, base64Dialect);
                            if (b2 == 61) {
                                break;
                            }
                            i3 = 0;
                        } else {
                            i3 = i6;
                        }
                    }
                    i5++;
                } else {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("bad Base64 input character at ", i5, ": ");
                    outline74.append(channelBuffer.getUnsignedByte(i5));
                    outline74.append(" (decimal)");
                    throw new IllegalArgumentException(outline74.toString());
                }
            }
            return buffer.slice(0, i4);
        } else {
            throw new NullPointerException("bufferFactory");
        }
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2) {
        return encode(channelBuffer, i, i2, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect) {
        return encode(channelBuffer, i, i2, breakLines(base64Dialect), base64Dialect);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, breakLines(base64Dialect), base64Dialect, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z) {
        return encode(channelBuffer, i, i2, z, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, Base64Dialect base64Dialect) {
        return encode(channelBuffer, i, i2, z, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, z, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        int i3 = i2;
        ChannelBufferFactory channelBufferFactory2 = channelBufferFactory;
        if (channelBuffer == null) {
            throw new NullPointerException(ReactVideoViewManager.PROP_SRC);
        } else if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        } else if (channelBufferFactory2 != null) {
            int i4 = (i3 * 4) / 3;
            ChannelBuffer buffer = channelBufferFactory2.getBuffer(channelBuffer.order(), (i3 % 3 > 0 ? 4 : 0) + i4 + (z ? i4 / 76 : 0));
            int i5 = i3 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i5) {
                encode3to4(channelBuffer, i6 + i, 3, buffer, i7, base64Dialect);
                i8 += 4;
                if (z && i8 == 76) {
                    buffer.setByte(i7 + 4, 10);
                    i7++;
                    i8 = 0;
                }
                i6 += 3;
                i7 += 4;
            }
            if (i6 < i3) {
                encode3to4(channelBuffer, i6 + i, i3 - i6, buffer, i7, base64Dialect);
                i7 += 4;
            }
            return buffer.slice(0, i7);
        } else {
            throw new NullPointerException("bufferFactory");
        }
    }
}
