package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

public abstract class HttpMessageDecoder extends ReplayingDecoder<State> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long chunkSize;
    public ChannelBuffer content;
    public int headerSize;
    public final int maxChunkSize;
    public final int maxHeaderSize;
    public final int maxInitialLineLength;
    public HttpMessage message;

    /* renamed from: org.jboss.netty.handler.codec.http.HttpMessageDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|8|9|11|12|13|14|15|17|18|19|(2:21|22)|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        static {
            /*
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State[] r0 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State = r0
                r1 = 1
                r2 = 5
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_FIXED_LENGTH_CONTENT     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 3
                int[] r4 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0017 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r5 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_VARIABLE_LENGTH_CONTENT     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x001e }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r5 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.SKIP_CONTROL_CHARS     // Catch:{ NoSuchFieldError -> 0x001e }
                r5 = 0
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r3 = 4
                int[] r4 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0025 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r5 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_INITIAL     // Catch:{ NoSuchFieldError -> 0x0025 }
                r4[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r1 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x002b }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r4 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_HEADER     // Catch:{ NoSuchFieldError -> 0x002b }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r1 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0032 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r2 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS     // Catch:{ NoSuchFieldError -> 0x0032 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0039 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_FIXED_LENGTH_CONTENT_AS_CHUNKS     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 8
                int[] r2 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0041 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r1 = 9
                int[] r2 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNKED_CONTENT     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0051 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNKED_CONTENT_AS_CHUNKS     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r1 = 11
                int[] r2 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0059 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r3 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_DELIMITER     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$org$jboss$netty$handler$codec$http$HttpMessageDecoder$State     // Catch:{ NoSuchFieldError -> 0x0061 }
                org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r2 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_FOOTER     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.http.HttpMessageDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS,
        READ_FIXED_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT_AS_CHUNKS,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNKED_CONTENT_AS_CHUNKS,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER
    }

    public HttpMessageDecoder() {
        this(4096, 8192, 8192);
    }

    private int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    private int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int findWhitespace(String str, int i) {
        while (i < str.length() && !Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int getChunkSize(String str) {
        String trim = str.trim();
        int i = 0;
        while (true) {
            if (i >= trim.length()) {
                break;
            }
            char charAt = trim.charAt(i);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i);
            } else {
                i++;
            }
        }
        trim = trim.substring(0, i);
        return Integer.parseInt(trim, 16);
    }

    private void readFixedLengthContent(ChannelBuffer channelBuffer) {
        long contentLength = HttpHeaders.getContentLength(this.message, -1);
        ChannelBuffer channelBuffer2 = this.content;
        if (channelBuffer2 == null) {
            this.content = channelBuffer.readBytes((int) contentLength);
        } else {
            channelBuffer2.writeBytes(channelBuffer.readBytes((int) contentLength));
        }
    }

    private String readHeader(ChannelBuffer channelBuffer) throws TooLongFrameException {
        StringBuilder sb = new StringBuilder(64);
        int i = this.headerSize;
        while (true) {
            char readByte = (char) channelBuffer.readByte();
            i++;
            if (readByte == 10) {
                break;
            }
            if (readByte == 13) {
                readByte = (char) channelBuffer.readByte();
                i++;
                if (readByte == 10) {
                    break;
                }
            }
            if (i < this.maxHeaderSize) {
                sb.append(readByte);
            } else {
                throw new TooLongFrameException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("HTTP header is larger than "), this.maxHeaderSize, " bytes."));
            }
        }
        this.headerSize = i;
        return sb.toString();
    }

    private State readHeaders(ChannelBuffer channelBuffer) throws TooLongFrameException {
        String str;
        this.headerSize = 0;
        HttpMessage httpMessage = this.message;
        String readHeader = readHeader(channelBuffer);
        if (readHeader.length() != 0) {
            httpMessage.clearHeaders();
            String str2 = null;
            String str3 = null;
            do {
                char charAt = readHeader.charAt(0);
                if (str2 == null || !(charAt == ' ' || charAt == 9)) {
                    if (str2 != null) {
                        httpMessage.addHeader(str2, str3);
                    }
                    String[] splitHeader = splitHeader(readHeader);
                    str2 = splitHeader[0];
                    str = splitHeader[1];
                } else {
                    str = str3 + ' ' + readHeader.trim();
                }
                str3 = str;
                readHeader = readHeader(channelBuffer);
            } while (readHeader.length() != 0);
            if (str2 != null) {
                httpMessage.addHeader(str2, str3);
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            return State.SKIP_CONTROL_CHARS;
        }
        if (httpMessage.isChunked()) {
            return State.READ_CHUNK_SIZE;
        }
        if (HttpHeaders.getContentLength(httpMessage, -1) >= 0) {
            return State.READ_FIXED_LENGTH_CONTENT;
        }
        return State.READ_VARIABLE_LENGTH_CONTENT;
    }

    private String readLine(ChannelBuffer channelBuffer, int i) throws TooLongFrameException {
        StringBuilder sb = new StringBuilder(64);
        int i2 = 0;
        while (true) {
            byte readByte = channelBuffer.readByte();
            if (readByte == 13) {
                if (channelBuffer.readByte() == 10) {
                    return sb.toString();
                }
            } else if (readByte == 10) {
                return sb.toString();
            } else {
                if (i2 < i) {
                    i2++;
                    sb.append((char) readByte);
                } else {
                    throw new TooLongFrameException(GeneratedOutlineSupport.outline42("An HTTP line is larger than ", i, " bytes."));
                }
            }
        }
    }

    private HttpChunkTrailer readTrailingHeaders(ChannelBuffer channelBuffer) throws TooLongFrameException {
        this.headerSize = 0;
        String readHeader = readHeader(channelBuffer);
        if (readHeader.length() == 0) {
            return HttpChunk.LAST_CHUNK;
        }
        DefaultHttpChunkTrailer defaultHttpChunkTrailer = new DefaultHttpChunkTrailer();
        String str = null;
        do {
            char charAt = readHeader.charAt(0);
            if (str == null || !(charAt == ' ' || charAt == 9)) {
                String[] splitHeader = splitHeader(readHeader);
                str = splitHeader[0];
                if (!str.equalsIgnoreCase("Content-Length") && !str.equalsIgnoreCase(Names.TRANSFER_ENCODING) && !str.equalsIgnoreCase(Names.TRAILER)) {
                    defaultHttpChunkTrailer.addHeader(str, splitHeader[1]);
                }
            } else {
                List<String> headers = defaultHttpChunkTrailer.getHeaders(str);
                if (headers.size() != 0) {
                    int size = headers.size() - 1;
                    headers.set(size, headers.get(size) + readHeader.trim());
                }
            }
            readHeader = readHeader(channelBuffer);
        } while (readHeader.length() != 0);
        return defaultHttpChunkTrailer;
    }

    private Object reset() {
        HttpMessage httpMessage = this.message;
        ChannelBuffer channelBuffer = this.content;
        if (channelBuffer != null) {
            httpMessage.setContent(channelBuffer);
            this.content = null;
        }
        this.message = null;
        checkpoint(State.SKIP_CONTROL_CHARS);
        return httpMessage;
    }

    private void skipControlCharacters(ChannelBuffer channelBuffer) {
        while (true) {
            char readUnsignedByte = (char) channelBuffer.readUnsignedByte();
            if (!Character.isISOControl(readUnsignedByte) && !Character.isWhitespace(readUnsignedByte)) {
                channelBuffer.readerIndex(channelBuffer.readerIndex() - 1);
                return;
            }
        }
    }

    private String[] splitHeader(String str) {
        int length = str.length();
        int findNonWhitespace = findNonWhitespace(str, 0);
        int i = findNonWhitespace;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == ':' || Character.isWhitespace(charAt)) {
                break;
            }
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (str.charAt(i2) == ':') {
                i2++;
                break;
            } else {
                i2++;
            }
        }
        int findNonWhitespace2 = findNonWhitespace(str, i2);
        if (findNonWhitespace2 == length) {
            return new String[]{str.substring(findNonWhitespace, i), ""};
        }
        return new String[]{str.substring(findNonWhitespace, i), str.substring(findNonWhitespace2, findEndOfString(str))};
    }

    private String[] splitInitialLine(String str) {
        int findNonWhitespace = findNonWhitespace(str, 0);
        int findWhitespace = findWhitespace(str, findNonWhitespace);
        int findNonWhitespace2 = findNonWhitespace(str, findWhitespace);
        int findWhitespace2 = findWhitespace(str, findNonWhitespace2);
        int findNonWhitespace3 = findNonWhitespace(str, findWhitespace2);
        int findEndOfString = findEndOfString(str);
        String[] strArr = new String[3];
        strArr[0] = str.substring(findNonWhitespace, findWhitespace);
        strArr[1] = str.substring(findNonWhitespace2, findWhitespace2);
        strArr[2] = findNonWhitespace3 < findEndOfString ? str.substring(findNonWhitespace3, findEndOfString) : "";
        return strArr;
    }

    public abstract HttpMessage createMessage(String[] strArr) throws Exception;

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            int code = ((HttpResponse) httpMessage).getStatus().getCode();
            if (code < 200 || code == 204 || code == 205 || code == 304) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean isDecodingRequest();

    public HttpMessageDecoder(int i, int i2, int i3) {
        super(State.SKIP_CONTROL_CHARS, true);
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxInitialLineLength must be a positive integer: ", i));
        } else if (i2 <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxHeaderSize must be a positive integer: ", i2));
        } else if (i3 >= 0) {
            this.maxInitialLineLength = i;
            this.maxHeaderSize = i2;
            this.maxChunkSize = i3;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxChunkSize must be a positive integer: ", i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r11 = r13.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r11 != 13) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r13.readByte() != 10) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r11 != 10) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        r11 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk(r13.readBytes((int) r10.chunkSize));
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_DELIMITER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b0, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0125, code lost:
        r11 = splitInitialLine(readLine(r13, r10.maxInitialLineLength));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0130, code lost:
        if (r11.length >= 3) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0132, code lost:
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.SKIP_CONTROL_CHARS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0137, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0138, code lost:
        r10.message = createMessage(r11);
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_HEADER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0143, code lost:
        r11 = readHeaders(r13);
        checkpoint(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        if (r11 != org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014e, code lost:
        r10.message.setChunked(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0155, code lost:
        return r10.message;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0158, code lost:
        if (r11 != org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.SKIP_CONTROL_CHARS) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015a, code lost:
        r10.message.removeHeader(org.jboss.netty.handler.codec.http.HttpHeaders.Names.TRANSFER_ENCODING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0163, code lost:
        return r10.message;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0164, code lost:
        r8 = org.jboss.netty.handler.codec.http.HttpHeaders.getContentLength(r10.message, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016e, code lost:
        if (r8 == 0) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0172, code lost:
        if (r8 != -1) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0178, code lost:
        if (isDecodingRequest() == false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017b, code lost:
        r11 = r11.ordinal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017f, code lost:
        if (r11 == 3) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0182, code lost:
        if (r11 == 5) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018a, code lost:
        if (r8 <= ((long) r10.maxChunkSize)) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x018c, code lost:
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_FIXED_LENGTH_CONTENT_AS_CHUNKS);
        r10.message.setChunked(true);
        r10.chunkSize = org.jboss.netty.handler.codec.http.HttpHeaders.getContentLength(r10.message, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a0, code lost:
        return r10.message;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a7, code lost:
        if (r13.readableBytes() <= r10.maxChunkSize) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a9, code lost:
        checkpoint(org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS);
        r10.message.setChunked(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b5, code lost:
        return r10.message;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b6, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b7, code lost:
        r10.content = org.jboss.netty.buffer.ChannelBuffers.EMPTY_BUFFER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01bf, code lost:
        return reset();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(org.jboss.netty.channel.ChannelHandlerContext r11, org.jboss.netty.channel.Channel r12, org.jboss.netty.buffer.ChannelBuffer r13, org.jboss.netty.handler.codec.http.HttpMessageDecoder.State r14) throws java.lang.Exception {
        /*
            r10 = this;
            int r11 = r14.ordinal()
            r14 = 0
            r0 = 2
            r1 = 3
            r2 = 0
            r4 = 1
            r5 = 0
            switch(r11) {
                case 0: goto L_0x011a;
                case 1: goto L_0x0125;
                case 2: goto L_0x0143;
                case 3: goto L_0x01c5;
                case 4: goto L_0x00ee;
                case 5: goto L_0x01e9;
                case 6: goto L_0x00b1;
                case 7: goto L_0x007b;
                case 8: goto L_0x009f;
                case 9: goto L_0x0027;
                case 10: goto L_0x005d;
                case 11: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.Error r11 = new java.lang.Error
            java.lang.String r12 = "Shouldn't reach here."
            r11.<init>(r12)
            throw r11
        L_0x0016:
            org.jboss.netty.handler.codec.http.HttpChunkTrailer r11 = r10.readTrailingHeaders(r13)
            int r12 = r10.maxChunkSize
            if (r12 != 0) goto L_0x0023
            java.lang.Object r11 = r10.reset()
            return r11
        L_0x0023:
            r10.reset()
            return r11
        L_0x0027:
            long r11 = r10.chunkSize
            int r14 = r10.maxChunkSize
            long r0 = (long) r14
            int r14 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x0040
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r14 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            int r0 = r10.maxChunkSize
            org.jboss.netty.buffer.ChannelBuffer r0 = r13.readBytes(r0)
            r14.<init>(r0)
            int r0 = r10.maxChunkSize
            long r0 = (long) r0
            long r11 = r11 - r0
            goto L_0x004b
        L_0x0040:
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r14 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            int r12 = (int) r11
            org.jboss.netty.buffer.ChannelBuffer r11 = r13.readBytes(r12)
            r14.<init>(r11)
            r11 = r2
        L_0x004b:
            r10.chunkSize = r11
            int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0056
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_DELIMITER
            r10.checkpoint(r11)
        L_0x0056:
            boolean r11 = r14.isLast()
            if (r11 != 0) goto L_0x005d
            return r14
        L_0x005d:
            byte r11 = r13.readByte()
            r12 = 13
            r14 = 10
            if (r11 != r12) goto L_0x0073
            byte r11 = r13.readByte()
            if (r11 != r14) goto L_0x005d
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE
            r10.checkpoint(r11)
            return r5
        L_0x0073:
            if (r11 != r14) goto L_0x005d
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE
            r10.checkpoint(r11)
            return r5
        L_0x007b:
            int r11 = r10.maxInitialLineLength
            java.lang.String r11 = r10.readLine(r13, r11)
            int r11 = r10.getChunkSize(r11)
            long r0 = (long) r11
            r10.chunkSize = r0
            if (r11 != 0) goto L_0x0090
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_FOOTER
            r10.checkpoint(r11)
            return r5
        L_0x0090:
            int r12 = r10.maxChunkSize
            if (r11 <= r12) goto L_0x009a
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNKED_CONTENT_AS_CHUNKS
            r10.checkpoint(r11)
            goto L_0x009f
        L_0x009a:
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNKED_CONTENT
            r10.checkpoint(r11)
        L_0x009f:
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r11 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            long r0 = r10.chunkSize
            int r12 = (int) r0
            org.jboss.netty.buffer.ChannelBuffer r12 = r13.readBytes(r12)
            r11.<init>(r12)
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r12 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_DELIMITER
            r10.checkpoint(r12)
            return r11
        L_0x00b1:
            long r11 = r10.chunkSize
            int r1 = r10.maxChunkSize
            long r5 = (long) r1
            int r1 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ca
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r1 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            int r5 = r10.maxChunkSize
            org.jboss.netty.buffer.ChannelBuffer r13 = r13.readBytes(r5)
            r1.<init>(r13)
            int r13 = r10.maxChunkSize
            long r5 = (long) r13
            long r11 = r11 - r5
            goto L_0x00d5
        L_0x00ca:
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r1 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            int r12 = (int) r11
            org.jboss.netty.buffer.ChannelBuffer r11 = r13.readBytes(r12)
            r1.<init>(r11)
            r11 = r2
        L_0x00d5:
            r10.chunkSize = r11
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x00ed
            r10.reset()
            boolean r11 = r1.isLast()
            if (r11 != 0) goto L_0x00ed
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r11[r14] = r1
            org.jboss.netty.handler.codec.http.HttpChunkTrailer r12 = org.jboss.netty.handler.codec.http.HttpChunk.LAST_CHUNK
            r11[r4] = r12
            return r11
        L_0x00ed:
            return r1
        L_0x00ee:
            int r11 = r10.maxChunkSize
            int r12 = r13.readableBytes()
            int r11 = java.lang.Math.min(r11, r12)
            org.jboss.netty.handler.codec.http.DefaultHttpChunk r12 = new org.jboss.netty.handler.codec.http.DefaultHttpChunk
            org.jboss.netty.buffer.ChannelBuffer r11 = r13.readBytes(r11)
            r12.<init>(r11)
            boolean r11 = r13.readable()
            if (r11 != 0) goto L_0x0119
            r10.reset()
            boolean r11 = r12.isLast()
            if (r11 != 0) goto L_0x0119
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r11[r14] = r12
            org.jboss.netty.handler.codec.http.HttpChunkTrailer r12 = org.jboss.netty.handler.codec.http.HttpChunk.LAST_CHUNK
            r11[r4] = r12
            return r11
        L_0x0119:
            return r12
        L_0x011a:
            r10.skipControlCharacters(r13)     // Catch:{ all -> 0x01c0 }
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_INITIAL     // Catch:{ all -> 0x01c0 }
            r10.checkpoint(r11)     // Catch:{ all -> 0x01c0 }
            r10.checkpoint()
        L_0x0125:
            int r11 = r10.maxInitialLineLength
            java.lang.String r11 = r10.readLine(r13, r11)
            java.lang.String[] r11 = r10.splitInitialLine(r11)
            int r12 = r11.length
            if (r12 >= r1) goto L_0x0138
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.SKIP_CONTROL_CHARS
            r10.checkpoint(r11)
            return r5
        L_0x0138:
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.createMessage(r11)
            r10.message = r11
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_HEADER
            r10.checkpoint(r11)
        L_0x0143:
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = r10.readHeaders(r13)
            r10.checkpoint(r11)
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r12 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_CHUNK_SIZE
            if (r11 != r12) goto L_0x0156
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            r11.setChunked(r4)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            return r11
        L_0x0156:
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r12 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.SKIP_CONTROL_CHARS
            if (r11 != r12) goto L_0x0164
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            java.lang.String r12 = "Transfer-Encoding"
            r11.removeHeader(r12)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            return r11
        L_0x0164:
            org.jboss.netty.handler.codec.http.HttpMessage r12 = r10.message
            r6 = -1
            long r8 = org.jboss.netty.handler.codec.http.HttpHeaders.getContentLength(r12, r6)
            int r12 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x01b7
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x017b
            boolean r12 = r10.isDecodingRequest()
            if (r12 == 0) goto L_0x017b
            goto L_0x01b7
        L_0x017b:
            int r11 = r11.ordinal()
            if (r11 == r1) goto L_0x01a1
            r12 = 5
            if (r11 == r12) goto L_0x0185
            goto L_0x01b6
        L_0x0185:
            int r11 = r10.maxChunkSize
            long r11 = (long) r11
            int r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x01b6
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_FIXED_LENGTH_CONTENT_AS_CHUNKS
            r10.checkpoint(r11)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            r11.setChunked(r4)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            long r11 = org.jboss.netty.handler.codec.http.HttpHeaders.getContentLength(r11, r6)
            r10.chunkSize = r11
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            return r11
        L_0x01a1:
            int r11 = r13.readableBytes()
            int r12 = r10.maxChunkSize
            if (r11 <= r12) goto L_0x01b6
            org.jboss.netty.handler.codec.http.HttpMessageDecoder$State r11 = org.jboss.netty.handler.codec.http.HttpMessageDecoder.State.READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS
            r10.checkpoint(r11)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            r11.setChunked(r4)
            org.jboss.netty.handler.codec.http.HttpMessage r11 = r10.message
            return r11
        L_0x01b6:
            return r5
        L_0x01b7:
            org.jboss.netty.buffer.ChannelBuffer r11 = org.jboss.netty.buffer.ChannelBuffers.EMPTY_BUFFER
            r10.content = r11
            java.lang.Object r11 = r10.reset()
            return r11
        L_0x01c0:
            r11 = move-exception
            r10.checkpoint()
            throw r11
        L_0x01c5:
            org.jboss.netty.buffer.ChannelBuffer r11 = r10.content
            if (r11 != 0) goto L_0x01d7
            org.jboss.netty.channel.ChannelConfig r11 = r12.getConfig()
            org.jboss.netty.buffer.ChannelBufferFactory r11 = r11.getBufferFactory()
            org.jboss.netty.buffer.ChannelBuffer r11 = org.jboss.netty.buffer.ChannelBuffers.dynamicBuffer(r11)
            r10.content = r11
        L_0x01d7:
            org.jboss.netty.buffer.ChannelBuffer r11 = r10.content
            int r12 = r13.readableBytes()
            org.jboss.netty.buffer.ChannelBuffer r12 = r13.readBytes(r12)
            r11.writeBytes(r12)
            java.lang.Object r11 = r10.reset()
            return r11
        L_0x01e9:
            r10.readFixedLengthContent(r13)
            java.lang.Object r11 = r10.reset()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.http.HttpMessageDecoder.decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer, org.jboss.netty.handler.codec.http.HttpMessageDecoder$State):java.lang.Object");
    }
}
