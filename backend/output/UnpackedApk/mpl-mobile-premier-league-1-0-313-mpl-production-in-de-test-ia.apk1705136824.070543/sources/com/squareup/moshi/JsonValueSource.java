package com.squareup.moshi;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class JsonValueSource implements Source {
    public static final ByteString STATE_C_STYLE_COMMENT = ByteString.encodeUtf8("*");
    public static final ByteString STATE_DOUBLE_QUOTED = ByteString.encodeUtf8("\"\\");
    public static final ByteString STATE_END_OF_JSON = ByteString.EMPTY;
    public static final ByteString STATE_END_OF_LINE_COMMENT = ByteString.encodeUtf8("\r\n");
    public static final ByteString STATE_JSON = ByteString.encodeUtf8("[]{}\"'/#");
    public static final ByteString STATE_SINGLE_QUOTED = ByteString.encodeUtf8("'\\");
    public final Buffer buffer;
    public boolean closed;
    public long limit;
    public final Buffer prefix;
    public final BufferedSource source;
    public int stackSize;
    public ByteString state;

    public JsonValueSource(BufferedSource bufferedSource) {
        this(bufferedSource, new Buffer(), STATE_JSON, 0);
    }

    private void advanceLimit(long j) throws IOException {
        while (true) {
            long j2 = this.limit;
            if (j2 < j && this.state != STATE_END_OF_JSON) {
                if (j2 == this.buffer.size()) {
                    if (this.limit <= 0) {
                        this.source.require(1);
                    } else {
                        return;
                    }
                }
                long indexOfElement = this.buffer.indexOfElement(this.state, this.limit);
                if (indexOfElement == -1) {
                    this.limit = this.buffer.size();
                } else {
                    byte b2 = this.buffer.getByte(indexOfElement);
                    ByteString byteString = this.state;
                    ByteString byteString2 = STATE_JSON;
                    if (byteString == byteString2) {
                        if (b2 == 34) {
                            this.state = STATE_DOUBLE_QUOTED;
                            this.limit = indexOfElement + 1;
                        } else if (b2 == 35) {
                            this.state = STATE_END_OF_LINE_COMMENT;
                            this.limit = indexOfElement + 1;
                        } else if (b2 == 39) {
                            this.state = STATE_SINGLE_QUOTED;
                            this.limit = indexOfElement + 1;
                        } else if (b2 != 47) {
                            if (b2 != 91) {
                                if (b2 != 93) {
                                    if (b2 != 123) {
                                        if (b2 != 125) {
                                        }
                                    }
                                }
                                int i = this.stackSize - 1;
                                this.stackSize = i;
                                if (i == 0) {
                                    this.state = STATE_END_OF_JSON;
                                }
                                this.limit = indexOfElement + 1;
                            }
                            this.stackSize++;
                            this.limit = indexOfElement + 1;
                        } else {
                            long j3 = 2 + indexOfElement;
                            this.source.require(j3);
                            long j4 = indexOfElement + 1;
                            byte b3 = this.buffer.getByte(j4);
                            if (b3 == 47) {
                                this.state = STATE_END_OF_LINE_COMMENT;
                                this.limit = j3;
                            } else if (b3 == 42) {
                                this.state = STATE_C_STYLE_COMMENT;
                                this.limit = j3;
                            } else {
                                this.limit = j4;
                            }
                        }
                    } else if (byteString == STATE_SINGLE_QUOTED || byteString == STATE_DOUBLE_QUOTED) {
                        if (b2 == 92) {
                            long j5 = indexOfElement + 2;
                            this.source.require(j5);
                            this.limit = j5;
                        } else {
                            this.state = this.stackSize > 0 ? STATE_JSON : STATE_END_OF_JSON;
                            this.limit = indexOfElement + 1;
                        }
                    } else if (byteString == STATE_C_STYLE_COMMENT) {
                        long j6 = 2 + indexOfElement;
                        this.source.require(j6);
                        long j7 = indexOfElement + 1;
                        if (this.buffer.getByte(j7) == 47) {
                            this.limit = j6;
                            this.state = STATE_JSON;
                        } else {
                            this.limit = j7;
                        }
                    } else if (byteString == STATE_END_OF_LINE_COMMENT) {
                        this.limit = indexOfElement + 1;
                        this.state = byteString2;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        this.closed = true;
    }

    public void discard() throws IOException {
        this.closed = true;
        while (this.state != STATE_END_OF_JSON) {
            advanceLimit(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            this.source.skip(this.limit);
        }
    }

    public long read(Buffer buffer2, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            if (!this.prefix.exhausted()) {
                long read = this.prefix.read(buffer2, j);
                long j2 = j - read;
                if (this.buffer.exhausted()) {
                    return read;
                }
                long read2 = read(buffer2, j2);
                if (read2 != -1) {
                    read += read2;
                }
                return read;
            }
            advanceLimit(j);
            long j3 = this.limit;
            if (j3 != 0) {
                long min = Math.min(j, j3);
                buffer2.write(this.buffer, min);
                this.limit -= min;
                return min;
            } else if (this.state == STATE_END_OF_JSON) {
                return -1;
            } else {
                throw new AssertionError();
            }
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public JsonValueSource(BufferedSource bufferedSource, Buffer buffer2, ByteString byteString, int i) {
        this.limit = 0;
        this.closed = false;
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        this.prefix = buffer2;
        this.state = byteString;
        this.stackSize = i;
    }
}
