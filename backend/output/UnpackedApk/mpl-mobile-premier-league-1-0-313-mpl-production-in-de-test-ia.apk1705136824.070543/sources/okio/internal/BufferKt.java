package okio.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\b\u001a\r\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\b\u001a\r\u0010\u0016\u001a\u00020\u0005*\u00020\u0013H\b\u001a\r\u0010\u0017\u001a\u00020\u0013*\u00020\u0013H\b\u001a%\u0010\u0018\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\u0017\u0010\u001c\u001a\u00020\n*\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\b\u001a\u0015\u0010\u001f\u001a\u00020\u0005*\u00020\u00152\u0006\u0010 \u001a\u00020\bH\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00132\u0006\u0010#\u001a\u00020\u0005H\b\u001a\r\u0010$\u001a\u00020\b*\u00020\u0013H\b\u001a%\u0010%\u001a\u00020\u0005*\u00020\u00132\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005H\b\u001a\u001d\u0010*\u001a\u00020\u0005*\u00020\u00132\u0006\u0010+\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005H\b\u001a\r\u0010,\u001a\u00020\b*\u00020\u0015H\b\u001a-\u0010-\u001a\u00020\n*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\b\u001a\u0015\u0010.\u001a\u00020\b*\u00020\u00132\u0006\u0010/\u001a\u00020\u0001H\b\u001a%\u0010.\u001a\u00020\b*\u00020\u00132\u0006\u0010/\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\b\u001a\u001d\u0010.\u001a\u00020\u0005*\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\u0015\u00100\u001a\u00020\u0005*\u00020\u00132\u0006\u0010/\u001a\u000201H\b\u001a\u0014\u00102\u001a\u00020\u0015*\u00020\u00132\u0006\u00103\u001a\u00020\u0015H\u0000\u001a\r\u00104\u001a\u00020\"*\u00020\u0013H\b\u001a\r\u00105\u001a\u00020\u0001*\u00020\u0013H\b\u001a\u0015\u00105\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\r\u00106\u001a\u00020)*\u00020\u0013H\b\u001a\u0015\u00106\u001a\u00020)*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\r\u00107\u001a\u00020\u0005*\u00020\u0013H\b\u001a\u0015\u00108\u001a\u00020\u0012*\u00020\u00132\u0006\u0010/\u001a\u00020\u0001H\b\u001a\u001d\u00108\u001a\u00020\u0012*\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\r\u00109\u001a\u00020\u0005*\u00020\u0013H\b\u001a\r\u0010:\u001a\u00020\b*\u00020\u0013H\b\u001a\r\u0010;\u001a\u00020\u0005*\u00020\u0013H\b\u001a\r\u0010<\u001a\u00020=*\u00020\u0013H\b\u001a\u0014\u0010>\u001a\u00020\u0015*\u00020\u00132\u0006\u00103\u001a\u00020\u0015H\u0000\u001a\u0015\u0010?\u001a\u00020@*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\r\u0010A\u001a\u00020\b*\u00020\u0013H\b\u001a\u000f\u0010B\u001a\u0004\u0018\u00010@*\u00020\u0013H\b\u001a\u0015\u0010C\u001a\u00020@*\u00020\u00132\u0006\u0010D\u001a\u00020\u0005H\b\u001a\u0015\u0010E\u001a\u00020\u0005*\u00020\u00152\u0006\u0010F\u001a\u00020\u0005H\b\u001a\u0015\u0010G\u001a\u00020\b*\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0005H\b\u001a\u0015\u0010H\u001a\u00020\b*\u00020\u00132\u0006\u0010I\u001a\u00020JH\b\u001a\u0015\u0010K\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\r\u0010L\u001a\u00020)*\u00020\u0013H\b\u001a\u0015\u0010L\u001a\u00020)*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\bH\b\u001a\u0015\u0010M\u001a\u00020\f*\u00020\u00132\u0006\u0010N\u001a\u00020\bH\b\u001a\u0015\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020\u0001H\b\u001a%\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\b\u001a\u001d\u0010O\u001a\u00020\u0012*\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a)\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010Q\u001a\u00020)2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\b\u001a\u001d\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010P\u001a\u00020R2\u0006\u0010\u001b\u001a\u00020\u0005H\b\u001a\u0015\u0010S\u001a\u00020\u0005*\u00020\u00132\u0006\u0010P\u001a\u00020RH\b\u001a\u0015\u0010T\u001a\u00020\u0013*\u00020\u00132\u0006\u0010&\u001a\u00020\bH\b\u001a\u0015\u0010U\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\b\u001a\u0015\u0010W\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\b\u001a\u0015\u0010X\u001a\u00020\u0013*\u00020\u00132\u0006\u0010Y\u001a\u00020\bH\b\u001a\u0015\u0010Z\u001a\u00020\u0013*\u00020\u00132\u0006\u0010V\u001a\u00020\u0005H\b\u001a\u0015\u0010[\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\\\u001a\u00020\bH\b\u001a%\u0010]\u001a\u00020\u0013*\u00020\u00132\u0006\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\b\u001a\u0015\u0010a\u001a\u00020\u0013*\u00020\u00132\u0006\u0010b\u001a\u00020\bH\b\u001a\u0014\u0010c\u001a\u00020@*\u00020\u00132\u0006\u0010d\u001a\u00020\u0005H\u0000\u001a?\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f*\u00020\u00132\u0006\u0010'\u001a\u00020\u00052\u001a\u0010g\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002Hf0hH\bø\u0001\u0000¢\u0006\u0002\u0010i\u001a\u001e\u0010j\u001a\u00020\b*\u00020\u00132\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010k\u001a\u00020\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006l"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: Buffer.kt */
public final class BufferKt {
    public static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "$this$commonClose");
        if (unsafeCursor.buffer != null) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = -1;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i = segment2.limit;
        if (i < 8192 && segment2.owner) {
            size -= (long) (i - segment2.pos);
        }
        return size;
    }

    public static final Buffer commonCopy(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCopyTo");
        Intrinsics.checkNotNullParameter(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i3 = sharedCopy.pos + ((int) j);
            sharedCopy.pos = i3;
            sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(sharedCopy);
            }
            j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        Buffer buffer2 = buffer;
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(buffer2, "$this$commonEquals");
        if (buffer2 == obj2) {
            return true;
        }
        if (!(obj2 instanceof Buffer)) {
            return false;
        }
        Buffer buffer3 = (Buffer) obj2;
        if (buffer.size() != buffer3.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer2.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = buffer3.head;
        Intrinsics.checkNotNull(segment2);
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < buffer.size()) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
                i2 = segment2.pos;
            }
            j += min;
        }
        return true;
    }

    public static final long commonExpandBuffer(UnsafeCursor unsafeCursor, int i) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "$this$commonExpandBuffer");
        boolean z = true;
        if (i > 0) {
            if (i > 8192) {
                z = false;
            }
            if (z) {
                Buffer buffer = unsafeCursor.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                } else if (unsafeCursor.readWrite) {
                    long size = buffer.size();
                    Segment writableSegment$okio = buffer.writableSegment$okio(i);
                    int i2 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = 8192;
                    long j = (long) i2;
                    buffer.setSize$okio(size + j);
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = 8192 - i2;
                    unsafeCursor.end = 8192;
                    return j;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("minByteCount > Segment.SIZE: ", i).toString());
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("minByteCount <= 0: ", i).toString());
        }
    }

    public static final byte commonGet(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            return null.data[(int) ((((long) null.pos) + j) - -1)];
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
        }
    }

    public static final int commonHashCode(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i;
    }

    public static final long commonIndexOf(Buffer buffer, byte b2, long j, long j2) {
        int i;
        long j3;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonIndexOf");
        long j4 = 0;
        if (0 <= j && j2 >= j) {
            if (j2 > buffer.size()) {
                j2 = buffer.size();
            }
            if (j == j2) {
                return -1;
            }
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j3 = buffer.size();
                while (j3 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j3 -= (long) (segment.limit - segment.pos);
                }
                while (j3 < j2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min) {
                        if (bArr[i] != b2) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
                return -1;
            }
            while (true) {
                long j5 = ((long) (segment.limit - segment.pos)) + j4;
                if (j5 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j4 = j5;
            }
            while (j3 < j2) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                int i2 = (int) ((((long) segment.pos) + j) - j3);
                while (i < min2) {
                    if (bArr2[i] != b2) {
                        i2 = i + 1;
                    }
                }
                j4 = j3 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j4;
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("size=");
        outline73.append(buffer.size());
        outline73.append(" fromIndex=");
        outline73.append(j);
        outline73.append(" toIndex=");
        outline73.append(j2);
        throw new IllegalArgumentException(outline73.toString().toString());
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j) {
        int i;
        int i2;
        long j2;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j2 = buffer.size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b2 = byteString.getByte(0);
                    byte b3 = byteString.getByte(1);
                    while (j2 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i4 = segment.limit;
                        while (i < i4) {
                            byte b4 = bArr[i];
                            if (!(b4 == b2 || b4 == b3)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j2 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i3 = (int) ((((long) segment.pos) + j) - j2);
                        int i5 = segment.limit;
                        while (i3 < i5) {
                            byte b5 = bArr2[i3];
                            for (byte b6 : internalArray$okio) {
                                if (b5 == b6) {
                                    i2 = segment.pos;
                                    return ((long) (i - i2)) + j2;
                                }
                            }
                            i3++;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j4;
            }
            if (byteString.size() == 2) {
                byte b7 = byteString.getByte(0);
                byte b8 = byteString.getByte(1);
                while (j2 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    int i6 = (int) ((((long) segment.pos) + j) - j2);
                    int i7 = segment.limit;
                    while (i < i7) {
                        byte b9 = bArr3[i];
                        if (!(b9 == b7 || b9 == b8)) {
                            i6 = i + 1;
                        }
                    }
                    j3 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j2 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    int i8 = (int) ((((long) segment.pos) + j) - j2);
                    int i9 = segment.limit;
                    while (i3 < i9) {
                        byte b10 = bArr4[i3];
                        for (byte b11 : internalArray$okio2) {
                            if (b10 == b11) {
                                i2 = segment.pos;
                                return ((long) (i - i2)) + j2;
                            }
                        }
                        i8 = i3 + 1;
                    }
                    j3 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
            }
            return -1;
            i2 = segment.pos;
            return ((long) (i - i2)) + j2;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("fromIndex < 0: ", j).toString());
    }

    public static final int commonNext(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "$this$commonNext");
        long j = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j != buffer.size()) {
            long j2 = unsafeCursor.offset;
            return unsafeCursor.seek(j2 == -1 ? 0 : j2 + ((long) (unsafeCursor.end - unsafeCursor.start)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final UnsafeCursor commonReadAndWriteUnsafe(Buffer buffer, UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadAndWriteUnsafe");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = buffer;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByte");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b2 = segment.data[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b2;
        }
        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        if (r10 != r11) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009e, code lost:
        r0.head = r8.pop();
        okio.SegmentPool.recycle(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r8.pos = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        if (r7 != false) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(okio.Buffer r17) {
        /*
            r0 = r17
            java.lang.String r1 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00be
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0016:
            okio.Segment r8 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0021:
            if (r10 >= r11) goto L_0x009c
            byte r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L_0x0071
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L_0x0071
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0048
            if (r16 != 0) goto L_0x0041
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L_0x0041
            goto L_0x0048
        L_0x0041:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L_0x007c
        L_0x0048:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong(r3)
            okio.Buffer r0 = r0.writeByte(r12)
            if (r6 != 0) goto L_0x005a
            r0.readByte()
        L_0x005a:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0071:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L_0x0081
            if (r5 != 0) goto L_0x0081
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L_0x007c:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L_0x0021
        L_0x0081:
            if (r5 == 0) goto L_0x0085
            r7 = 1
            goto L_0x009c
        L_0x0085:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = okio.Util.toHexString(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009c:
            if (r10 != r11) goto L_0x00a8
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto L_0x00aa
        L_0x00a8:
            r8.pos = r10
        L_0x00aa:
            if (r7 != 0) goto L_0x00b0
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0016
        L_0x00b0:
            long r1 = r17.size()
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.setSize$okio(r1)
            if (r6 == 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            long r3 = -r3
        L_0x00bd:
            return r3
        L_0x00be:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = buffer.read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer buffer) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadHexadecimalUnsignedLong");
        if (buffer.size() != 0) {
            int i2 = 0;
            boolean z = false;
            long j = 0;
            do {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    byte b2 = bArr[i3];
                    byte b3 = (byte) 48;
                    if (b2 < b3 || b2 > ((byte) 57)) {
                        byte b4 = (byte) 97;
                        if (b2 < b4 || b2 > ((byte) 102)) {
                            b4 = (byte) 65;
                            if (b2 < b4 || b2 > ((byte) 70)) {
                                if (i2 != 0) {
                                    z = true;
                                } else {
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected leading [0-9a-fA-F] character but was 0x");
                                    outline73.append(Util.toHexString(b2));
                                    throw new NumberFormatException(outline73.toString());
                                }
                            }
                        }
                        i = (b2 - b4) + 10;
                    } else {
                        i = b2 - b3;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i3++;
                        i2++;
                    } else {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b2);
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Number too large: ");
                        outline732.append(writeByte.readUtf8());
                        throw new NumberFormatException(outline732.toString());
                    }
                }
                if (i3 == i4) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i3;
                }
                if (z) {
                    break;
                }
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - ((long) i2));
            return j;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadInt");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << GlyfDescript.X_DUAL) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << GlyfDescript.X_DUAL);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i6 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return b4;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadLong");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i10 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadShort");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) b2;
        }
        throw new EOFException();
    }

    public static final UnsafeCursor commonReadUnsafe(Buffer buffer, UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUnsafe");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = buffer;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final String commonReadUtf8(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("byteCount: ", j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i2 = segment.pos;
            if (((long) i2) + j > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
            }
            int i3 = (int) j;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i2, i2 + i3);
            segment.pos += i3;
            buffer.setSize$okio(buffer.size() - j);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        byte b2;
        int i;
        byte b3;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() != 0) {
            byte b4 = buffer.getByte(0);
            int i2 = 1;
            byte b5 = 65533;
            if ((b4 & 128) == 0) {
                b3 = b4 & Byte.MAX_VALUE;
                i = 1;
                b2 = 0;
            } else if ((b4 & 224) == 192) {
                b3 = b4 & 31;
                i = 2;
                b2 = 128;
            } else if ((b4 & 240) == 224) {
                b3 = b4 & 15;
                i = 3;
                b2 = 2048;
            } else if ((b4 & 248) == 240) {
                b3 = b4 & 7;
                i = 4;
                b2 = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i;
            if (buffer.size() >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b6 = buffer.getByte(j2);
                    if ((b6 & 192) == 128) {
                        b3 = (b3 << 6) | (b6 & Utf8.REPLACEMENT_BYTE);
                        i2++;
                    } else {
                        buffer.skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j);
                if (b3 <= 1114111 && ((55296 > b3 || 57343 < b3) && b3 >= b2)) {
                    b5 = b3;
                }
                return b5;
            }
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("size < ", i, ": ");
            outline74.append(buffer.size());
            outline74.append(" (to read code point prefixed 0x");
            outline74.append(Util.toHexString(b4));
            outline74.append(')');
            throw new EOFException(outline74.toString());
        }
        throw new EOFException();
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8Line");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8LineStrict");
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b2 = (byte) 10;
            long indexOf = buffer.indexOf(b2, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b2) {
                return readUtf8Line(buffer, j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("\\n not found: limit=");
            outline73.append(Math.min(buffer.size(), j));
            outline73.append(" content=");
            outline73.append(buffer2.readByteString().hex());
            outline73.append(8230);
            throw new EOFException(outline73.toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("limit < 0: ", j).toString());
    }

    public static final long commonResizeBuffer(UnsafeCursor unsafeCursor, long j) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "$this$commonResizeBuffer");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (unsafeCursor.readWrite) {
            long size = buffer.size();
            int i = 1;
            int i2 = (j > size ? 1 : (j == size ? 0 : -1));
            if (i2 <= 0) {
                if (j >= 0) {
                    long j2 = size - j;
                    while (true) {
                        if (j2 <= 0) {
                            break;
                        }
                        Segment segment = buffer.head;
                        Intrinsics.checkNotNull(segment);
                        Segment segment2 = segment.prev;
                        Intrinsics.checkNotNull(segment2);
                        int i3 = segment2.limit;
                        long j3 = (long) (i3 - segment2.pos);
                        if (j3 > j2) {
                            segment2.limit = i3 - ((int) j2);
                            break;
                        }
                        buffer.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                        j2 -= j3;
                    }
                    unsafeCursor.setSegment$okio(null);
                    unsafeCursor.offset = j;
                    unsafeCursor.data = null;
                    unsafeCursor.start = -1;
                    unsafeCursor.end = -1;
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("newSize < 0: ", j).toString());
                }
            } else if (i2 > 0) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(i);
                    int min = (int) Math.min(j4, (long) (8192 - writableSegment$okio.limit));
                    writableSegment$okio.limit += min;
                    j4 -= (long) min;
                    if (z) {
                        unsafeCursor.setSegment$okio(writableSegment$okio);
                        unsafeCursor.offset = size;
                        unsafeCursor.data = writableSegment$okio.data;
                        int i4 = writableSegment$okio.limit;
                        unsafeCursor.start = i4 - min;
                        unsafeCursor.end = i4;
                        z = false;
                    }
                    i = 1;
                }
            }
            buffer.setSize$okio(j);
            return size;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public static final int commonSeek(UnsafeCursor unsafeCursor, long j) {
        Segment segment;
        UnsafeCursor unsafeCursor2 = unsafeCursor;
        long j2 = j;
        Intrinsics.checkNotNullParameter(unsafeCursor2, "$this$commonSeek");
        Buffer buffer = unsafeCursor2.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (j2 < ((long) -1) || j2 > buffer.size()) {
            StringBuilder outline76 = GeneratedOutlineSupport.outline76("offset=", j2, " > size=");
            outline76.append(buffer.size());
            throw new ArrayIndexOutOfBoundsException(outline76.toString());
        } else if (j2 == -1 || j2 == buffer.size()) {
            unsafeCursor2.setSegment$okio(null);
            unsafeCursor2.offset = j2;
            unsafeCursor2.data = null;
            unsafeCursor2.start = -1;
            unsafeCursor2.end = -1;
            return -1;
        } else {
            long j3 = 0;
            long size = buffer.size();
            Segment segment2 = buffer.head;
            if (unsafeCursor.getSegment$okio() != null) {
                long j4 = unsafeCursor2.offset;
                int i = unsafeCursor2.start;
                Segment segment$okio = unsafeCursor.getSegment$okio();
                Intrinsics.checkNotNull(segment$okio);
                long j5 = j4 - ((long) (i - segment$okio.pos));
                if (j5 > j2) {
                    long j6 = j5;
                    segment = unsafeCursor.getSegment$okio();
                    size = j6;
                } else {
                    Segment segment3 = segment2;
                    segment2 = unsafeCursor.getSegment$okio();
                    j3 = j5;
                    segment = segment3;
                }
            } else {
                segment = segment2;
            }
            if (size - j2 > j2 - j3) {
                while (true) {
                    Intrinsics.checkNotNull(segment2);
                    int i2 = segment2.limit;
                    int i3 = segment2.pos;
                    if (j2 < ((long) (i2 - i3)) + j3) {
                        break;
                    }
                    j3 += (long) (i2 - i3);
                    segment2 = segment2.next;
                }
            } else {
                while (size > j2) {
                    Intrinsics.checkNotNull(segment);
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    size -= (long) (segment.limit - segment.pos);
                }
                j3 = size;
                segment2 = segment;
            }
            if (unsafeCursor2.readWrite) {
                Intrinsics.checkNotNull(segment2);
                if (segment2.shared) {
                    Segment unsharedCopy = segment2.unsharedCopy();
                    if (buffer.head == segment2) {
                        buffer.head = unsharedCopy;
                    }
                    segment2 = segment2.push(unsharedCopy);
                    Segment segment4 = segment2.prev;
                    Intrinsics.checkNotNull(segment4);
                    segment4.pop();
                }
            }
            unsafeCursor2.setSegment$okio(segment2);
            unsafeCursor2.offset = j2;
            Intrinsics.checkNotNull(segment2);
            unsafeCursor2.data = segment2.data;
            int i4 = segment2.pos + ((int) (j2 - j3));
            unsafeCursor2.start = i4;
            int i5 = segment2.limit;
            unsafeCursor2.end = i5;
            return i5 - i4;
        }
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSkip");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                buffer.setSize$okio(buffer.size() - j2);
                j -= j2;
                int i = segment.pos + min;
                segment.pos = i;
                if (i == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("size > Int.MAX_VALUE: ");
        outline73.append(buffer.size());
        throw new IllegalStateException(outline73.toString().toString());
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWritableSegment");
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            if (segment2.limit + i > 8192 || !segment2.owner) {
                segment2 = segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, DefaultSettingsSpiCall.SOURCE_PARAM);
        long j = 0;
        while (true) {
            long read = source.read(buffer, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteByte");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteDecimalLong");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8((String) "-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= MqttAsyncClient.DISCONNECT_TIMEOUT) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + ((long) i2));
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteInt");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & InvitationReply.EXPIRED);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & InvitationReply.EXPIRED);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & InvitationReply.EXPIRED);
        bArr[i5] = (byte) (i & InvitationReply.EXPIRED);
        writableSegment$okio.limit = i5 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteLong");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteShort");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & InvitationReply.EXPIRED);
        bArr[i3] = (byte) (i & InvitationReply.EXPIRED);
        writableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                            while (true) {
                                i = i4;
                                if (i >= min) {
                                    break;
                                }
                                char charAt2 = str.charAt(i);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                i4 = i + 1;
                                bArr[i + i3] = (byte) charAt2;
                            }
                            int i5 = writableSegment$okio.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment$okio.limit = i5 + i6;
                            buffer.setSize$okio(buffer.size() + ((long) i6));
                        } else {
                            if (charAt < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i7 = writableSegment$okio2.limit;
                                bArr2[i7] = (byte) ((charAt >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio2.limit = i7 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i8 = writableSegment$okio3.limit;
                                bArr3[i8] = (byte) ((charAt >> Tokenizer.FF) | 224);
                                bArr3[i8 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                bArr3[i8 + 2] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio3.limit = i8 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i9 = i + 1;
                                char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                                if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    buffer.writeByte(63);
                                    i = i9;
                                } else {
                                    int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 0;
                                    Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                    byte[] bArr4 = writableSegment$okio4.data;
                                    int i11 = writableSegment$okio4.limit;
                                    bArr4[i11] = (byte) ((i10 >> 18) | 240);
                                    bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                                    bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                                    bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                                    writableSegment$okio4.limit = i11 + 4;
                                    buffer.setSize$okio(buffer.size() + 4);
                                    i += 2;
                                }
                            }
                            i++;
                        }
                    }
                    return buffer;
                }
                StringBuilder outline74 = GeneratedOutlineSupport.outline74("endIndex > string.length: ", i2, " > ");
                outline74.append(str.length());
                throw new IllegalArgumentException(outline74.toString().toString());
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline43("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("beginIndex < 0: ", i).toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit = i2 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i3 = writableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit = i3 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i4 = writableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit = i4 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected code point: 0x");
            outline73.append(Util.toHexString(i));
            throw new IllegalArgumentException(outline73.toString());
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr3 = segment.data;
                int i5 = segment.pos;
                bArr2 = bArr3;
                i = i5;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j, Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$seek");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return function2.invoke(null, Long.valueOf(-1));
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return function2.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return function2.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "$this$selectPrefix");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer2.head;
        int i5 = -2;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i6 = segment2.pos;
            int i7 = segment2.limit;
            int[] trie$okio = options.getTrie$okio();
            Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = trie$okio[i8];
                int i12 = i10 + 1;
                int i13 = trie$okio[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = (i11 * -1) + i12;
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != trie$okio[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            Intrinsics.checkNotNull(segment3);
                            Segment segment4 = segment3.next;
                            Intrinsics.checkNotNull(segment4);
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 != segment2) {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i3 = i7;
                            i4 = i15;
                            segment = segment5;
                        }
                        if (z2) {
                            i2 = trie$okio[i16];
                            i = i4;
                            i7 = i3;
                            segment3 = segment;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        segment3 = segment;
                    }
                } else {
                    i = i6 + 1;
                    byte b2 = bArr[i6] & 255;
                    int i17 = i12 + i11;
                    while (i12 != i17) {
                        if (b2 == trie$okio[i12]) {
                            i2 = trie$okio[i12 + i11];
                            if (i == i7) {
                                segment3 = segment3.next;
                                Intrinsics.checkNotNull(segment3);
                                i = segment3.pos;
                                bArr = segment3.data;
                                i7 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i8 = -i2;
                i6 = i;
            }
            if (z) {
                return -2;
            }
            return i9;
        }
        if (!z) {
            i5 = -1;
        }
        return i5;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i, i3, i3 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("byteCount: ", j).toString());
        } else if (buffer.size() >= j) {
            byte[] bArr = new byte[((int) j)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("byteCount: ", j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new ByteString(buffer.readByteArray(j));
        } else {
            ByteString snapshot = buffer.snapshot((int) j);
            buffer.skip(j);
            return snapshot;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, DefaultSettingsSpiCall.SOURCE_PARAM);
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, DefaultSettingsSpiCall.SOURCE_PARAM);
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt___ArraysJvmKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0, (long) i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, DefaultSettingsSpiCall.SOURCE_PARAM);
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("byteCount < 0: ", j).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j > buffer.size()) {
                j = buffer.size();
            }
            buffer2.write(buffer, j);
            return j;
        }
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer2, DefaultSettingsSpiCall.SOURCE_PARAM);
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer2.head;
                Intrinsics.checkNotNull(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    Segment segment4 = buffer.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer2.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer2.setSize$okio(buffer2.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer2.head = segment6.split((int) j);
                }
                Segment segment7 = buffer2.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                Segment segment8 = buffer.head;
                if (segment8 == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j) {
        long j2;
        int i;
        Buffer buffer2 = buffer;
        long j3 = j;
        Intrinsics.checkNotNullParameter(buffer2, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                Segment segment = buffer2.head;
                if (segment == null) {
                    return -1;
                }
                if (buffer.size() - j3 < j3) {
                    long size = buffer.size();
                    while (size > j3) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b2 = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (buffer.size() - ((long) size2)) + 1;
                    j2 = size;
                    while (j2 < size3) {
                        byte[] bArr = segment.data;
                        long j5 = size3;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - j2);
                        i = (int) ((((long) segment.pos) + j3) - j2);
                        while (i < min) {
                            if (bArr[i] == b2) {
                                if (rangeEquals(segment, i + 1, internalArray$okio, 1, size2)) {
                                }
                            }
                            i++;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        size3 = j5;
                        j3 = j2;
                    }
                    return -1;
                }
                while (true) {
                    long j6 = ((long) (segment.limit - segment.pos)) + j4;
                    if (j6 > j3) {
                        break;
                    }
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j4 = j6;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b3 = internalArray$okio2[0];
                int size4 = byteString.size();
                long size5 = (buffer.size() - ((long) size4)) + 1;
                while (j2 < size5) {
                    byte[] bArr2 = segment.data;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size5) - j2);
                    int i2 = (int) ((((long) segment.pos) + j3) - j2);
                    while (i < min2) {
                        if (bArr2[i] != b3 || !rangeEquals(segment, i + 1, internalArray$okio2, 1, size4)) {
                            i2 = i + 1;
                        }
                    }
                    j4 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j4;
                }
                return -1;
                return ((long) (i - segment.pos)) + j2;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("fromIndex < 0: ", j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
