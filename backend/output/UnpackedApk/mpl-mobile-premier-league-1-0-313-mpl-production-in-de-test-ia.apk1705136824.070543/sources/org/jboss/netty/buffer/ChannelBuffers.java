package org.jboss.netty.buffer;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;
import org.jboss.netty.util.CharsetUtil;
import sfs2x.client.entities.invitation.InvitationReply;

public class ChannelBuffers {
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ChannelBuffer EMPTY_BUFFER = new BigEndianHeapChannelBuffer(0);
    public static final char[] HEXDUMP_TABLE = new char[1024];
    public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        for (int i = 0; i < 256; i++) {
            char[] cArr = HEXDUMP_TABLE;
            int i2 = i << 1;
            cArr[i2 + 0] = charArray[(i >>> 4) & 15];
            cArr[i2 + 1] = charArray[(i >>> 0) & 15];
        }
    }

    public static ChannelBuffer buffer(int i) {
        return buffer(BIG_ENDIAN, i);
    }

    public static int compare(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int readableBytes = channelBuffer.readableBytes();
        int readableBytes2 = channelBuffer2.readableBytes();
        int min = Math.min(readableBytes, readableBytes2);
        int i = min >>> 2;
        int readerIndex = channelBuffer.readerIndex();
        int readerIndex2 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            while (i > 0) {
                int i2 = (channelBuffer.getUnsignedInt(readerIndex) > channelBuffer2.getUnsignedInt(readerIndex2) ? 1 : (channelBuffer.getUnsignedInt(readerIndex) == channelBuffer2.getUnsignedInt(readerIndex2) ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                if (i2 < 0) {
                    return -1;
                }
                readerIndex += 4;
                readerIndex2 += 4;
                i--;
            }
        } else {
            while (i > 0) {
                int i3 = (channelBuffer.getUnsignedInt(readerIndex) > (((long) swapInt(channelBuffer2.getInt(readerIndex2))) & 4294967295L) ? 1 : (channelBuffer.getUnsignedInt(readerIndex) == (((long) swapInt(channelBuffer2.getInt(readerIndex2))) & 4294967295L) ? 0 : -1));
                if (i3 > 0) {
                    return 1;
                }
                if (i3 < 0) {
                    return -1;
                }
                readerIndex += 4;
                readerIndex2 += 4;
                i--;
            }
        }
        for (int i4 = min & 3; i4 > 0; i4--) {
            byte b2 = channelBuffer.getByte(readerIndex);
            byte b3 = channelBuffer2.getByte(readerIndex2);
            if (b2 > b3) {
                return 1;
            }
            if (b2 < b3) {
                return -1;
            }
            readerIndex++;
            readerIndex2++;
        }
        return readableBytes - readableBytes2;
    }

    public static ChannelBuffer compositeBuffer(ByteOrder byteOrder, List<ChannelBuffer> list) {
        int size = list.size();
        if (size == 0) {
            return EMPTY_BUFFER;
        }
        if (size != 1) {
            return new CompositeChannelBuffer(byteOrder, list);
        }
        return list.get(0);
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
    }

    public static String decodeString(ByteBuffer byteBuffer, Charset charset) {
        CharsetDecoder decoder = CharsetUtil.getDecoder(charset);
        CharBuffer allocate = CharBuffer.allocate((int) (((double) byteBuffer.remaining()) * ((double) decoder.maxCharsPerByte())));
        try {
            CoderResult decode = decoder.decode(byteBuffer, allocate, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = decoder.flush(allocate);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
            return allocate.flip().toString();
        } catch (CharacterCodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static ChannelBuffer directBuffer(int i) {
        return directBuffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer dynamicBuffer() {
        return dynamicBuffer(BIG_ENDIAN, 256);
    }

    public static ByteBuffer encodeString(CharBuffer charBuffer, Charset charset) {
        CharsetEncoder encoder = CharsetUtil.getEncoder(charset);
        ByteBuffer allocate = ByteBuffer.allocate((int) (((double) charBuffer.remaining()) * ((double) encoder.maxBytesPerChar())));
        try {
            CoderResult encode = encoder.encode(charBuffer, allocate, true);
            if (!encode.isUnderflow()) {
                encode.throwException();
            }
            CoderResult flush = encoder.flush(allocate);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
            allocate.flip();
            return allocate;
        } catch (CharacterCodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static boolean equals(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int readableBytes = channelBuffer.readableBytes();
        if (readableBytes != channelBuffer2.readableBytes()) {
            return false;
        }
        int i = readableBytes >>> 3;
        int readerIndex = channelBuffer.readerIndex();
        int readerIndex2 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            while (i > 0) {
                if (channelBuffer.getLong(readerIndex) != channelBuffer2.getLong(readerIndex2)) {
                    return false;
                }
                readerIndex += 8;
                readerIndex2 += 8;
                i--;
            }
        } else {
            while (i > 0) {
                if (channelBuffer.getLong(readerIndex) != swapLong(channelBuffer2.getLong(readerIndex2))) {
                    return false;
                }
                readerIndex += 8;
                readerIndex2 += 8;
                i--;
            }
        }
        for (int i2 = readableBytes & 7; i2 > 0; i2--) {
            if (channelBuffer.getByte(readerIndex) != channelBuffer2.getByte(readerIndex2)) {
                return false;
            }
            readerIndex++;
            readerIndex2++;
        }
        return true;
    }

    public static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, byte b2) {
        int max = Math.max(i, 0);
        if (max < i2 && channelBuffer.capacity() != 0) {
            while (max < i2) {
                if (channelBuffer.getByte(max) == b2) {
                    return max;
                }
                max++;
            }
        }
        return -1;
    }

    public static int hashCode(ChannelBuffer channelBuffer) {
        int i;
        int readableBytes = channelBuffer.readableBytes();
        int i2 = readableBytes >>> 2;
        int i3 = readableBytes & 3;
        int readerIndex = channelBuffer.readerIndex();
        if (channelBuffer.order() == BIG_ENDIAN) {
            i = 1;
            while (i2 > 0) {
                i = (i * 31) + channelBuffer.getInt(readerIndex);
                readerIndex += 4;
                i2--;
            }
        } else {
            int i4 = 1;
            while (i2 > 0) {
                i4 = (i * 31) + swapInt(channelBuffer.getInt(readerIndex));
                readerIndex += 4;
                i2--;
            }
        }
        while (i3 > 0) {
            i = (i * 31) + channelBuffer.getByte(readerIndex);
            i3--;
            readerIndex++;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static String hexDump(ChannelBuffer channelBuffer) {
        return hexDump(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes());
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, byte b2) {
        if (i <= i2) {
            return firstIndexOf(channelBuffer, i, i2, b2);
        }
        return lastIndexOf(channelBuffer, i, i2, b2);
    }

    public static int lastIndexOf(ChannelBuffer channelBuffer, int i, int i2, byte b2) {
        int min = Math.min(i, channelBuffer.capacity());
        if (min >= 0 && channelBuffer.capacity() != 0) {
            for (int i3 = min - 1; i3 >= i2; i3--) {
                if (channelBuffer.getByte(i3) == b2) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static int swapInt(int i) {
        return (swapShort((short) (i >>> 16)) & 65535) | (swapShort((short) i) << 16);
    }

    public static long swapLong(long j) {
        return (((long) swapInt((int) (j >>> 32))) & 4294967295L) | (((long) swapInt((int) j)) << 32);
    }

    public static int swapMedium(int i) {
        return ((i >>> 16) & InvitationReply.EXPIRED) | ((i << 16) & 16711680) | (65280 & i);
    }

    public static short swapShort(short s) {
        return (short) (((s >>> 8) & InvitationReply.EXPIRED) | (s << 8));
    }

    public static ChannelBuffer unmodifiableBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer instanceof ReadOnlyChannelBuffer) {
            channelBuffer = ((ReadOnlyChannelBuffer) channelBuffer).unwrap();
        }
        return new ReadOnlyChannelBuffer(channelBuffer);
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer buffer(ByteOrder byteOrder, int i) {
        if (byteOrder == BIG_ENDIAN) {
            if (i == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer(i);
        } else if (byteOrder != LITTLE_ENDIAN) {
            throw new NullPointerException("endianness");
        } else if (i == 0) {
            return EMPTY_BUFFER;
        } else {
            return new LittleEndianHeapChannelBuffer(i);
        }
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer((byte[]) bArr.clone());
        } else if (byteOrder != LITTLE_ENDIAN) {
            throw new NullPointerException("endianness");
        } else if (bArr.length == 0) {
            return EMPTY_BUFFER;
        } else {
            return new LittleEndianHeapChannelBuffer((byte[]) bArr.clone());
        }
    }

    public static ChannelBuffer directBuffer(ByteOrder byteOrder, int i) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        } else if (i == 0) {
            return EMPTY_BUFFER;
        } else {
            ByteBufferBackedChannelBuffer byteBufferBackedChannelBuffer = new ByteBufferBackedChannelBuffer(ByteBuffer.allocateDirect(i).order(byteOrder));
            byteBufferBackedChannelBuffer.clear();
            return byteBufferBackedChannelBuffer;
        }
    }

    public static ChannelBuffer dynamicBuffer(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory != null) {
            return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), 256, channelBufferFactory);
        }
        throw new NullPointerException("factory");
    }

    public static String hexDump(ChannelBuffer channelBuffer, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length: ", i2));
        } else if (i2 == 0) {
            return "";
        } else {
            int i3 = i + i2;
            char[] cArr = new char[(i2 << 1)];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(HEXDUMP_TABLE, channelBuffer.getUnsignedByte(i) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer(bArr);
        } else if (byteOrder != LITTLE_ENDIAN) {
            throw new NullPointerException("endianness");
        } else if (bArr.length == 0) {
            return EMPTY_BUFFER;
        } else {
            return new LittleEndianHeapChannelBuffer(bArr);
        }
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        if (i <= i2) {
            return firstIndexOf(channelBuffer, i, i2, channelBufferIndexFinder);
        }
        return lastIndexOf(channelBuffer, i, i2, channelBufferIndexFinder);
    }

    public static ChannelBuffer dynamicBuffer(int i) {
        return dynamicBuffer(BIG_ENDIAN, i);
    }

    public static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int max = Math.max(i, 0);
        if (max < i2 && channelBuffer.capacity() != 0) {
            while (max < i2) {
                if (channelBufferIndexFinder.find(channelBuffer, max)) {
                    return max;
                }
                max++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int min = Math.min(i, channelBuffer.capacity());
        if (min >= 0 && channelBuffer.capacity() != 0) {
            for (int i3 = min - 1; i3 >= i2; i3--) {
                if (channelBufferIndexFinder.find(channelBuffer, i3)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i) {
        return new DynamicChannelBuffer(byteOrder, i);
    }

    public static ChannelBuffer dynamicBuffer(int i, ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory != null) {
            return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), i, channelBufferFactory);
        }
        throw new NullPointerException("factory");
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i, ChannelBufferFactory channelBufferFactory) {
        return new DynamicChannelBuffer(byteOrder, i, channelBufferFactory);
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr, int i, int i2) {
        return copiedBuffer(BIG_ENDIAN, bArr, i, i2);
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr, int i, int i2) {
        return wrappedBuffer(BIG_ENDIAN, bArr, i, i2);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        } else if (i2 == 0) {
            return EMPTY_BUFFER;
        } else {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return wrappedBuffer(byteOrder, bArr2);
        }
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        } else if (i == 0) {
            if (i2 == bArr.length) {
                return wrappedBuffer(byteOrder, bArr);
            }
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            return new TruncatedChannelBuffer(wrappedBuffer(byteOrder, bArr), i2);
        } else if (i2 == 0) {
            return EMPTY_BUFFER;
        } else {
            return new SlicedChannelBuffer(wrappedBuffer(byteOrder, bArr), i, i2);
        }
    }

    /* JADX INFO: finally extract failed */
    public static ChannelBuffer copiedBuffer(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[remaining];
        int position = byteBuffer.position();
        try {
            byteBuffer.get(bArr);
            byteBuffer.position(position);
            return wrappedBuffer(byteBuffer.order(), bArr);
        } catch (Throwable th) {
            byteBuffer.position(position);
            throw th;
        }
    }

    public static ChannelBuffer wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.order(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining());
        }
        return new ByteBufferBackedChannelBuffer(byteBuffer);
    }

    public static ChannelBuffer wrappedBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer.readable()) {
            return channelBuffer.slice();
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer.readable()) {
            return channelBuffer.copy();
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer copiedBuffer(byte[]... bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[]... bArr) {
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    if (bArr2 == null) {
                        break;
                    }
                    if (bArr2.length > 0) {
                        arrayList.add(wrappedBuffer(byteOrder, bArr2));
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
            } else if (bArr[0].length != 0) {
                return wrappedBuffer(byteOrder, bArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[]... bArr) {
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            int length2 = bArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length2) {
                byte[] bArr2 = bArr[i];
                if (Integer.MAX_VALUE - i2 >= bArr2.length) {
                    i2 += bArr2.length;
                    i++;
                } else {
                    throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                }
            }
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] bArr3 = new byte[i2];
            int i3 = 0;
            for (byte[] bArr4 : bArr) {
                System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
                i3 += bArr4.length;
            }
            return wrappedBuffer(byteOrder, bArr3);
        } else if (bArr[0].length == 0) {
            return EMPTY_BUFFER;
        } else {
            return copiedBuffer(byteOrder, bArr[0]);
        }
    }

    public static ChannelBuffer wrappedBuffer(ChannelBuffer... channelBufferArr) {
        int length = channelBufferArr.length;
        if (length != 0) {
            if (length != 1) {
                ByteOrder byteOrder = null;
                ArrayList arrayList = new ArrayList(channelBufferArr.length);
                for (ChannelBuffer channelBuffer : channelBufferArr) {
                    if (channelBuffer == null) {
                        break;
                    }
                    if (channelBuffer.readable()) {
                        if (byteOrder == null) {
                            byteOrder = channelBuffer.order();
                        } else if (!byteOrder.equals(channelBuffer.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                        if (channelBuffer instanceof CompositeChannelBuffer) {
                            arrayList.addAll(((CompositeChannelBuffer) channelBuffer).decompose(channelBuffer.readerIndex(), channelBuffer.readableBytes()));
                        } else {
                            arrayList.add(channelBuffer.slice());
                        }
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
            } else if (channelBufferArr[0].readable()) {
                return wrappedBuffer(channelBufferArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(ChannelBuffer... channelBufferArr) {
        int length = channelBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(channelBufferArr[0]);
        }
        ChannelBuffer[] channelBufferArr2 = new ChannelBuffer[channelBufferArr.length];
        for (int i = 0; i < channelBufferArr.length; i++) {
            channelBufferArr2[i] = copiedBuffer(channelBufferArr[i]);
        }
        return wrappedBuffer(channelBufferArr2);
    }

    public static ChannelBuffer wrappedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length != 0) {
            if (length != 1) {
                ByteOrder byteOrder = null;
                ArrayList arrayList = new ArrayList(byteBufferArr.length);
                for (ByteBuffer byteBuffer : byteBufferArr) {
                    if (byteBuffer == null) {
                        break;
                    }
                    if (byteBuffer.hasRemaining()) {
                        if (byteOrder == null) {
                            byteOrder = byteBuffer.order();
                        } else if (!byteOrder.equals(byteBuffer.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                        arrayList.add(wrappedBuffer(byteBuffer));
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
            } else if (byteBufferArr[0].hasRemaining()) {
                return wrappedBuffer(byteBufferArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(byteBufferArr[0]);
        }
        ChannelBuffer[] channelBufferArr = new ChannelBuffer[byteBufferArr.length];
        for (int i = 0; i < byteBufferArr.length; i++) {
            channelBufferArr[i] = copiedBuffer(byteBufferArr[i]);
        }
        return wrappedBuffer(channelBufferArr);
    }

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, charset);
    }

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException(NetworkingModule.REQUEST_BODY_KEY_STRING);
        } else if (charSequence instanceof CharBuffer) {
            return copiedBuffer(byteOrder, (CharBuffer) charSequence, charset);
        } else {
            return copiedBuffer(byteOrder, CharBuffer.wrap(charSequence), charset);
        }
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, int i, int i2, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException(NetworkingModule.REQUEST_BODY_KEY_STRING);
        } else if (i2 == 0) {
            return EMPTY_BUFFER;
        } else {
            if (!(charSequence instanceof CharBuffer)) {
                return copiedBuffer(byteOrder, CharBuffer.wrap(charSequence, i, i2 + i), charset);
            }
            CharBuffer charBuffer = (CharBuffer) charSequence;
            if (charBuffer.hasArray()) {
                return copiedBuffer(byteOrder, charBuffer.array(), charBuffer.position() + charBuffer.arrayOffset() + i, i2, charset);
            }
            CharBuffer slice = charBuffer.slice();
            slice.limit(i2);
            slice.position(i);
            return copiedBuffer(byteOrder, slice, charset);
        }
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, 0, cArr.length, charset);
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, Charset charset) {
        return copiedBuffer(byteOrder, cArr, 0, cArr.length, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, int i, int i2, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        } else if (i2 == 0) {
            return EMPTY_BUFFER;
        } else {
            return copiedBuffer(byteOrder, CharBuffer.wrap(cArr, i, i2), charset);
        }
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharBuffer charBuffer, Charset charset) {
        ByteBuffer encodeString = encodeString(charBuffer, charset);
        ChannelBuffer wrappedBuffer = wrappedBuffer(byteOrder, encodeString.array());
        wrappedBuffer.writerIndex(encodeString.remaining());
        return wrappedBuffer;
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(String str, String str2) {
        return copiedBuffer((CharSequence) str, Charset.forName(str2));
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, String str, String str2) {
        return copiedBuffer(byteOrder, (CharSequence) str, Charset.forName(str2));
    }
}
