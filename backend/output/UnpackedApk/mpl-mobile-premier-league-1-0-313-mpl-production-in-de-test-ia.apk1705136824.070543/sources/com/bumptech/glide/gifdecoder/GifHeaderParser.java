package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import org.apache.fontbox.ttf.GlyfDescript;

public class GifHeaderParser {
    public final byte[] block = new byte[256];
    public int blockSize = 0;
    public GifHeader header;
    public ByteBuffer rawData;

    public final boolean err() {
        return this.header.status != 0;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (err()) {
            return this.header;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((char) read());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.header.status = 1;
            } else {
                this.header.width = readShort();
                this.header.height = readShort();
                int read = read();
                this.header.gctFlag = (read & 128) != 0;
                this.header.gctSize = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
                this.header.bgIndex = read();
                this.header.pixelAspect = read();
                if (this.header.gctFlag && !err()) {
                    GifHeader gifHeader = this.header;
                    gifHeader.gct = readColorTable(gifHeader.gctSize);
                    GifHeader gifHeader2 = this.header;
                    gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
                }
            }
            if (!err()) {
                boolean z = false;
                while (!z && !err() && this.header.frameCount <= Integer.MAX_VALUE) {
                    int read2 = read();
                    if (read2 == 33) {
                        int read3 = read();
                        if (read3 == 1) {
                            skip();
                        } else if (read3 == 249) {
                            this.header.currentFrame = new GifFrame();
                            read();
                            int read4 = read();
                            GifFrame gifFrame = this.header.currentFrame;
                            int i2 = (read4 & 28) >> 2;
                            gifFrame.dispose = i2;
                            if (i2 == 0) {
                                gifFrame.dispose = 1;
                            }
                            this.header.currentFrame.transparency = (read4 & 1) != 0;
                            int readShort = readShort();
                            if (readShort < 2) {
                                readShort = 10;
                            }
                            GifFrame gifFrame2 = this.header.currentFrame;
                            gifFrame2.delay = readShort * 10;
                            gifFrame2.transIndex = read();
                            read();
                        } else if (read3 == 254) {
                            skip();
                        } else if (read3 != 255) {
                            skip();
                        } else {
                            readBlock();
                            StringBuilder sb2 = new StringBuilder();
                            for (int i3 = 0; i3 < 11; i3++) {
                                sb2.append((char) this.block[i3]);
                            }
                            if (sb2.toString().equals("NETSCAPE2.0")) {
                                do {
                                    readBlock();
                                    byte[] bArr = this.block;
                                    if (bArr[0] == 1) {
                                        this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                                    }
                                    if (this.blockSize <= 0) {
                                        break;
                                    }
                                } while (!err());
                            } else {
                                skip();
                            }
                        }
                    } else if (read2 == 44) {
                        GifHeader gifHeader3 = this.header;
                        if (gifHeader3.currentFrame == null) {
                            gifHeader3.currentFrame = new GifFrame();
                        }
                        this.header.currentFrame.ix = readShort();
                        this.header.currentFrame.iy = readShort();
                        this.header.currentFrame.iw = readShort();
                        this.header.currentFrame.ih = readShort();
                        int read5 = read();
                        boolean z2 = (read5 & 128) != 0;
                        int pow = (int) Math.pow(2.0d, (double) ((read5 & 7) + 1));
                        this.header.currentFrame.interlace = (read5 & 64) != 0;
                        if (z2) {
                            this.header.currentFrame.lct = readColorTable(pow);
                        } else {
                            this.header.currentFrame.lct = null;
                        }
                        this.header.currentFrame.bufferFrameStart = this.rawData.position();
                        read();
                        skip();
                        if (!err()) {
                            GifHeader gifHeader4 = this.header;
                            gifHeader4.frameCount++;
                            gifHeader4.frames.add(gifHeader4.currentFrame);
                        }
                    } else if (read2 != 59) {
                        this.header.status = 1;
                    } else {
                        z = true;
                    }
                }
                GifHeader gifHeader5 = this.header;
                if (gifHeader5.frameCount < 0) {
                    gifHeader5.status = 1;
                }
            }
            return this.header;
        }
    }

    public final int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    public final void readBlock() {
        int read = read();
        this.blockSize = read;
        if (read > 0) {
            int i = 0;
            while (i < this.blockSize) {
                try {
                    int i2 = this.blockSize - i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    boolean isLoggable = Log.isLoggable("GifHeaderParser", 3);
                    this.header.status = 1;
                    return;
                }
            }
        }
    }

    public final int[] readColorTable(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << GlyfDescript.X_DUAL) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            boolean isLoggable = Log.isLoggable("GifHeaderParser", 3);
            this.header.status = 1;
        }
        return iArr;
    }

    public final int readShort() {
        return this.rawData.getShort();
    }

    public final void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }
}
