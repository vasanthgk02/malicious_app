package com.clevertap.android.sdk.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.clevertap.android.sdk.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class GifDecoder {
    public int[] act;
    public final BitmapProvider bitmapProvider;
    public byte[] block;
    public int downsampledHeight;
    public int downsampledWidth;
    public int framePointer;
    public GifHeader header;
    public boolean isFirstFrameTransparent;
    public int loopIndex;
    public byte[] mainPixels;
    public int[] mainScratch;
    public GifHeaderParser parser;
    public final int[] pct = new int[256];
    public byte[] pixelStack;
    public short[] prefix;
    public Bitmap previousImage;
    public ByteBuffer rawData;
    public int sampleSize;
    public boolean savePrevious;
    public int status;
    public byte[] suffix;
    public byte[] workBuffer;
    public int workBufferPosition = 0;
    public int workBufferSize = 0;

    public interface BitmapProvider {
    }

    public GifDecoder() {
        SimpleBitmapProvider simpleBitmapProvider = new SimpleBitmapProvider();
        this.bitmapProvider = simpleBitmapProvider;
        this.header = new GifHeader();
    }

    public final void fillRect(int[] iArr, GifFrame gifFrame, int i) {
        int i2 = gifFrame.ih;
        int i3 = this.sampleSize;
        int i4 = i2 / i3;
        int i5 = gifFrame.iy / i3;
        int i6 = gifFrame.iw / i3;
        int i7 = gifFrame.ix / i3;
        int i8 = this.downsampledWidth;
        int i9 = (i5 * i8) + i7;
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.downsampledWidth;
        }
    }

    public final Bitmap getNextBitmap() {
        Config config = this.isFirstFrameTransparent ? Config.ARGB_8888 : Config.RGB_565;
        BitmapProvider bitmapProvider2 = this.bitmapProvider;
        int i = this.downsampledWidth;
        int i2 = this.downsampledHeight;
        if (((SimpleBitmapProvider) bitmapProvider2) != null) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
            createBitmap.setHasAlpha(true);
            return createBitmap;
        }
        throw null;
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            Logger.d("GifDecoder", "unable to decode frame, frameCount=" + this.header.frameCount + " framePointer=" + this.framePointer);
            this.status = 1;
        }
        if (this.status != 1) {
            if (this.status != 2) {
                this.status = 0;
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i = this.framePointer - 1;
                GifFrame gifFrame2 = i >= 0 ? this.header.frames.get(i) : null;
                int[] iArr = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
                this.act = iArr;
                if (iArr == null) {
                    Logger.d("GifDecoder", "No Valid Color Table for frame #" + this.framePointer);
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[gifFrame.transIndex] = 0;
                }
                return setPixels(gifFrame, gifFrame2);
            }
        }
        Logger.d("GifDecoder", "Unable to decode frame, status=" + this.status);
        return null;
    }

    public synchronized int read(byte[] bArr) {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        GifHeaderParser gifHeaderParser = this.parser;
        gifHeaderParser.setData(bArr);
        GifHeader parseHeader = gifHeaderParser.parseHeader();
        this.header = parseHeader;
        if (bArr != null) {
            synchronized (this) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                synchronized (this) {
                    setData(parseHeader, wrap, 1);
                }
            }
        }
        return this.status;
    }

    public final int readByte() {
        try {
            readChunkIfNeeded();
            byte[] bArr = this.workBuffer;
            int i = this.workBufferPosition;
            this.workBufferPosition = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    public final void readChunkIfNeeded() {
        if (this.workBufferSize <= this.workBufferPosition) {
            if (this.workBuffer == null) {
                if (((SimpleBitmapProvider) this.bitmapProvider) != null) {
                    this.workBuffer = new byte[16384];
                } else {
                    throw null;
                }
            }
            this.workBufferPosition = 0;
            int min = Math.min(this.rawData.remaining(), 16384);
            this.workBufferSize = min;
            this.rawData.get(this.workBuffer, 0, min);
        }
    }

    public synchronized void setData(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            try {
                int highestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.isFirstFrameTransparent = false;
                this.framePointer = -1;
                this.loopIndex = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().dispose == 3) {
                            this.savePrevious = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.sampleSize = highestOneBit;
                int i2 = gifHeader.width / highestOneBit;
                this.downsampledWidth = i2;
                int i3 = gifHeader.height / highestOneBit;
                this.downsampledHeight = i3;
                BitmapProvider bitmapProvider2 = this.bitmapProvider;
                int i4 = gifHeader.width * gifHeader.height;
                if (((SimpleBitmapProvider) bitmapProvider2) != null) {
                    this.mainPixels = new byte[i4];
                    int i5 = i2 * i3;
                    if (((SimpleBitmapProvider) this.bitmapProvider) != null) {
                        this.mainScratch = new int[i5];
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3.bgIndex == r2.transIndex) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f2 A[LOOP:4: B:95:0x01f0->B:96:0x01f2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap setPixels(com.clevertap.android.sdk.gif.GifFrame r29, com.clevertap.android.sdk.gif.GifFrame r30) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r0 = r30
            int[] r11 = r1.mainScratch
            r12 = 0
            if (r0 != 0) goto L_0x000e
            java.util.Arrays.fill(r11, r12)
        L_0x000e:
            r13 = 3
            r14 = 2
            r15 = 1
            if (r0 == 0) goto L_0x005d
            int r3 = r0.dispose
            if (r3 <= 0) goto L_0x005d
            if (r3 != r14) goto L_0x0037
            boolean r3 = r2.transparency
            if (r3 != 0) goto L_0x002c
            com.clevertap.android.sdk.gif.GifHeader r3 = r1.header
            int r4 = r3.bgColor
            int[] r5 = r2.lct
            if (r5 == 0) goto L_0x0033
            int r3 = r3.bgIndex
            int r5 = r2.transIndex
            if (r3 != r5) goto L_0x0033
            goto L_0x0032
        L_0x002c:
            int r3 = r1.framePointer
            if (r3 != 0) goto L_0x0032
            r1.isFirstFrameTransparent = r15
        L_0x0032:
            r4 = 0
        L_0x0033:
            r1.fillRect(r11, r0, r4)
            goto L_0x005d
        L_0x0037:
            if (r3 != r13) goto L_0x005d
            android.graphics.Bitmap r3 = r1.previousImage
            if (r3 != 0) goto L_0x0041
            r1.fillRect(r11, r0, r12)
            goto L_0x005d
        L_0x0041:
            int r4 = r0.ih
            int r5 = r1.sampleSize
            int r10 = r4 / r5
            int r4 = r0.iy
            int r8 = r4 / r5
            int r4 = r0.iw
            int r9 = r4 / r5
            int r0 = r0.ix
            int r7 = r0 / r5
            int r6 = r1.downsampledWidth
            int r0 = r8 * r6
            int r5 = r0 + r7
            r4 = r11
            r3.getPixels(r4, r5, r6, r7, r8, r9, r10)
        L_0x005d:
            r1.workBufferSize = r12
            r1.workBufferPosition = r12
            java.nio.ByteBuffer r0 = r1.rawData
            int r3 = r2.bufferFrameStart
            r0.position(r3)
            int r0 = r2.iw
            int r3 = r2.ih
            int r3 = r3 * r0
            byte[] r0 = r1.mainPixels
            r4 = 0
            if (r0 == 0) goto L_0x0076
            int r0 = r0.length
            if (r0 >= r3) goto L_0x0080
        L_0x0076:
            com.clevertap.android.sdk.gif.GifDecoder$BitmapProvider r0 = r1.bitmapProvider
            com.clevertap.android.sdk.gif.SimpleBitmapProvider r0 = (com.clevertap.android.sdk.gif.SimpleBitmapProvider) r0
            if (r0 == 0) goto L_0x03c0
            byte[] r0 = new byte[r3]
            r1.mainPixels = r0
        L_0x0080:
            short[] r0 = r1.prefix
            r5 = 4096(0x1000, float:5.74E-42)
            if (r0 != 0) goto L_0x008a
            short[] r0 = new short[r5]
            r1.prefix = r0
        L_0x008a:
            byte[] r0 = r1.suffix
            if (r0 != 0) goto L_0x0092
            byte[] r0 = new byte[r5]
            r1.suffix = r0
        L_0x0092:
            byte[] r0 = r1.pixelStack
            if (r0 != 0) goto L_0x009c
            r0 = 4097(0x1001, float:5.741E-42)
            byte[] r0 = new byte[r0]
            r1.pixelStack = r0
        L_0x009c:
            int r0 = r28.readByte()
            int r6 = r15 << r0
            int r7 = r6 + 1
            int r8 = r6 + 2
            int r9 = r0 + 1
            int r0 = r15 << r9
            r10 = -1
            int r16 = r0 + -1
            r0 = 0
        L_0x00ae:
            if (r0 >= r6) goto L_0x00bf
            short[] r14 = r1.prefix
            r14[r0] = r12
            byte[] r14 = r1.suffix
            byte r5 = (byte) r0
            r14[r0] = r5
            int r0 = r0 + 1
            r5 = 4096(0x1000, float:5.74E-42)
            r14 = 2
            goto L_0x00ae
        L_0x00bf:
            r14 = r8
            r18 = r9
            r24 = r16
            r0 = 0
            r5 = 0
            r17 = -1
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
        L_0x00d4:
            r26 = 8
            r10 = 255(0xff, float:3.57E-43)
            if (r5 >= r3) goto L_0x022c
            if (r0 != 0) goto L_0x0149
            int r13 = r28.readByte()
            if (r13 <= 0) goto L_0x013f
            byte[] r0 = r1.block     // Catch:{ Exception -> 0x0134 }
            if (r0 != 0) goto L_0x00f2
            com.clevertap.android.sdk.gif.GifDecoder$BitmapProvider r0 = r1.bitmapProvider     // Catch:{ Exception -> 0x0134 }
            com.clevertap.android.sdk.gif.SimpleBitmapProvider r0 = (com.clevertap.android.sdk.gif.SimpleBitmapProvider) r0     // Catch:{ Exception -> 0x0134 }
            if (r0 == 0) goto L_0x00f1
            byte[] r0 = new byte[r10]     // Catch:{ Exception -> 0x0134 }
            r1.block = r0     // Catch:{ Exception -> 0x0134 }
            goto L_0x00f2
        L_0x00f1:
            throw r4     // Catch:{ Exception -> 0x0134 }
        L_0x00f2:
            int r0 = r1.workBufferSize     // Catch:{ Exception -> 0x0134 }
            int r4 = r1.workBufferPosition     // Catch:{ Exception -> 0x0134 }
            int r0 = r0 - r4
            if (r0 < r13) goto L_0x0108
            byte[] r0 = r1.workBuffer     // Catch:{ Exception -> 0x0134 }
            int r4 = r1.workBufferPosition     // Catch:{ Exception -> 0x0134 }
            byte[] r10 = r1.block     // Catch:{ Exception -> 0x0134 }
            java.lang.System.arraycopy(r0, r4, r10, r12, r13)     // Catch:{ Exception -> 0x0134 }
            int r0 = r1.workBufferPosition     // Catch:{ Exception -> 0x0134 }
            int r0 = r0 + r13
            r1.workBufferPosition = r0     // Catch:{ Exception -> 0x0134 }
            goto L_0x013f
        L_0x0108:
            java.nio.ByteBuffer r4 = r1.rawData     // Catch:{ Exception -> 0x0134 }
            int r4 = r4.remaining()     // Catch:{ Exception -> 0x0134 }
            int r4 = r4 + r0
            if (r4 < r13) goto L_0x0130
            byte[] r4 = r1.workBuffer     // Catch:{ Exception -> 0x0134 }
            int r10 = r1.workBufferPosition     // Catch:{ Exception -> 0x0134 }
            byte[] r15 = r1.block     // Catch:{ Exception -> 0x0134 }
            java.lang.System.arraycopy(r4, r10, r15, r12, r0)     // Catch:{ Exception -> 0x0134 }
            int r4 = r1.workBufferSize     // Catch:{ Exception -> 0x0134 }
            r1.workBufferPosition = r4     // Catch:{ Exception -> 0x0134 }
            r28.readChunkIfNeeded()     // Catch:{ Exception -> 0x0134 }
            int r4 = r13 - r0
            byte[] r10 = r1.workBuffer     // Catch:{ Exception -> 0x0134 }
            byte[] r15 = r1.block     // Catch:{ Exception -> 0x0134 }
            java.lang.System.arraycopy(r10, r12, r15, r0, r4)     // Catch:{ Exception -> 0x0134 }
            int r0 = r1.workBufferPosition     // Catch:{ Exception -> 0x0134 }
            int r0 = r0 + r4
            r1.workBufferPosition = r0     // Catch:{ Exception -> 0x0134 }
            goto L_0x013f
        L_0x0130:
            r4 = 1
            r1.status = r4     // Catch:{ Exception -> 0x0134 }
            goto L_0x013f
        L_0x0134:
            r0 = move-exception
            java.lang.String r4 = "GifDecoder"
            java.lang.String r10 = "Error Reading Block"
            com.clevertap.android.sdk.Logger.d(r4, r10, r0)
            r4 = 1
            r1.status = r4
        L_0x013f:
            if (r13 > 0) goto L_0x0146
            r4 = 3
            r1.status = r4
            goto L_0x022c
        L_0x0146:
            r0 = r13
            r22 = 0
        L_0x0149:
            byte[] r4 = r1.block
            byte r4 = r4[r22]
            r10 = 255(0xff, float:3.57E-43)
            r4 = r4 & r10
            int r4 = r4 << r20
            int r21 = r21 + r4
            int r20 = r20 + 8
            r4 = 1
            int r22 = r22 + 1
            r4 = -1
            int r0 = r0 + r4
            r4 = r17
            r10 = r18
            r13 = r19
            r15 = r20
        L_0x0163:
            if (r15 < r10) goto L_0x020f
            r12 = r21 & r24
            int r21 = r21 >> r10
            int r15 = r15 - r10
            if (r12 != r6) goto L_0x0173
            r14 = r8
            r10 = r9
            r24 = r16
            r4 = -1
        L_0x0171:
            r12 = 0
            goto L_0x0163
        L_0x0173:
            if (r12 <= r14) goto L_0x017b
            r18 = r5
            r5 = 3
            r1.status = r5
            goto L_0x017f
        L_0x017b:
            r18 = r5
            if (r12 != r7) goto L_0x0183
        L_0x017f:
            r20 = r0
            goto L_0x0213
        L_0x0183:
            r5 = -1
            if (r4 != r5) goto L_0x019d
            byte[] r4 = r1.pixelStack
            int r13 = r25 + 1
            byte[] r5 = r1.suffix
            byte r5 = r5[r12]
            r4[r25] = r5
            r20 = r0
            r27 = r6
            r25 = r13
            r5 = r18
            r4 = 4096(0x1000, float:5.74E-42)
            r13 = r12
            goto L_0x0208
        L_0x019d:
            if (r12 < r14) goto L_0x01aa
            byte[] r5 = r1.pixelStack
            int r19 = r25 + 1
            byte r13 = (byte) r13
            r5[r25] = r13
            r5 = r4
            r25 = r19
            goto L_0x01ab
        L_0x01aa:
            r5 = r12
        L_0x01ab:
            if (r5 < r6) goto L_0x01c2
            byte[] r13 = r1.pixelStack
            int r19 = r25 + 1
            r20 = r0
            byte[] r0 = r1.suffix
            byte r0 = r0[r5]
            r13[r25] = r0
            short[] r0 = r1.prefix
            short r5 = r0[r5]
            r25 = r19
            r0 = r20
            goto L_0x01ab
        L_0x01c2:
            r20 = r0
            byte[] r0 = r1.suffix
            byte r5 = r0[r5]
            r13 = 255(0xff, float:3.57E-43)
            r5 = r5 & r13
            byte[] r13 = r1.pixelStack
            int r19 = r25 + 1
            r27 = r6
            byte r6 = (byte) r5
            r13[r25] = r6
            r13 = 4096(0x1000, float:5.74E-42)
            if (r14 >= r13) goto L_0x01ee
            short[] r13 = r1.prefix
            short r4 = (short) r4
            r13[r14] = r4
            r0[r14] = r6
            int r14 = r14 + 1
            r0 = r14 & r24
            if (r0 != 0) goto L_0x01ee
            r4 = 4096(0x1000, float:5.74E-42)
            if (r14 >= r4) goto L_0x01f0
            int r10 = r10 + 1
            int r24 = r24 + r14
            goto L_0x01f0
        L_0x01ee:
            r4 = 4096(0x1000, float:5.74E-42)
        L_0x01f0:
            if (r19 <= 0) goto L_0x0203
            byte[] r0 = r1.mainPixels
            int r6 = r23 + 1
            byte[] r13 = r1.pixelStack
            int r19 = r19 + -1
            byte r13 = r13[r19]
            r0[r23] = r13
            int r18 = r18 + 1
            r23 = r6
            goto L_0x01f0
        L_0x0203:
            r13 = r5
            r5 = r18
            r25 = r19
        L_0x0208:
            r4 = r12
            r0 = r20
            r6 = r27
            goto L_0x0171
        L_0x020f:
            r20 = r0
            r18 = r5
        L_0x0213:
            r27 = r6
            r5 = 4096(0x1000, float:5.74E-42)
            r17 = r4
            r19 = r13
            r5 = r18
            r0 = r20
            r6 = r27
            r4 = 0
            r12 = 0
            r13 = 3
            r18 = r10
            r20 = r15
            r10 = -1
            r15 = 1
            goto L_0x00d4
        L_0x022c:
            r0 = r23
        L_0x022e:
            if (r0 >= r3) goto L_0x0238
            byte[] r4 = r1.mainPixels
            r5 = 0
            r4[r0] = r5
            int r0 = r0 + 1
            goto L_0x022e
        L_0x0238:
            r5 = 0
            int r0 = r2.ih
            int r3 = r1.sampleSize
            int r0 = r0 / r3
            int r4 = r2.iy
            int r4 = r4 / r3
            int r6 = r2.iw
            int r6 = r6 / r3
            int r7 = r2.ix
            int r7 = r7 / r3
            int r3 = r1.framePointer
            if (r3 != 0) goto L_0x024d
            r3 = 1
            goto L_0x024e
        L_0x024d:
            r3 = 0
        L_0x024e:
            r8 = 0
            r9 = 1
            r10 = 0
            r12 = 8
        L_0x0253:
            if (r10 >= r0) goto L_0x038b
            boolean r13 = r2.interlace
            if (r13 == 0) goto L_0x0274
            r13 = 4
            if (r8 < r0) goto L_0x026f
            int r9 = r9 + 1
            r14 = 2
            r15 = 3
            if (r9 == r14) goto L_0x026d
            if (r9 == r15) goto L_0x026a
            if (r9 == r13) goto L_0x0267
            goto L_0x0271
        L_0x0267:
            r8 = 1
            r12 = 2
            goto L_0x0271
        L_0x026a:
            r8 = 2
            r12 = 4
            goto L_0x0271
        L_0x026d:
            r8 = 4
            goto L_0x0271
        L_0x026f:
            r14 = 2
            r15 = 3
        L_0x0271:
            int r13 = r8 + r12
            goto L_0x0278
        L_0x0274:
            r14 = 2
            r15 = 3
            r13 = r8
            r8 = r10
        L_0x0278:
            int r8 = r8 + r4
            int r5 = r1.downsampledHeight
            if (r8 >= r5) goto L_0x036f
            int r5 = r1.downsampledWidth
            int r8 = r8 * r5
            int r16 = r8 + r7
            int r14 = r16 + r6
            int r8 = r8 + r5
            if (r8 >= r14) goto L_0x0289
            r14 = r8
        L_0x0289:
            int r5 = r1.sampleSize
            int r8 = r10 * r5
            int r15 = r2.iw
            int r8 = r8 * r15
            int r15 = r14 - r16
            int r15 = r15 * r5
            int r15 = r15 + r8
            r5 = r16
        L_0x0298:
            if (r5 >= r14) goto L_0x036f
            r30 = r0
            int r0 = r1.sampleSize
            r16 = r4
            r4 = 1
            if (r0 != r4) goto L_0x02b8
            byte[] r0 = r1.mainPixels
            byte r0 = r0[r8]
            r4 = 255(0xff, float:3.57E-43)
            r0 = r0 & r4
            int[] r4 = r1.act
            r0 = r4[r0]
            r23 = r6
            r24 = r7
            r25 = r9
            r7 = 255(0xff, float:3.57E-43)
            goto L_0x0350
        L_0x02b8:
            int r0 = r2.iw
            r23 = r6
            r4 = r8
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
        L_0x02c7:
            int r6 = r1.sampleSize
            int r6 = r6 + r8
            if (r4 >= r6) goto L_0x0303
            byte[] r6 = r1.mainPixels
            r24 = r7
            int r7 = r6.length
            if (r4 >= r7) goto L_0x0305
            if (r4 >= r15) goto L_0x0305
            byte r6 = r6[r4]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            int[] r7 = r1.act
            r6 = r7[r6]
            if (r6 == 0) goto L_0x02fa
            int r7 = r6 >> 24
            r25 = r9
            r9 = 255(0xff, float:3.57E-43)
            r7 = r7 & r9
            int r18 = r18 + r7
            int r7 = r6 >> 16
            r7 = r7 & r9
            int r19 = r19 + r7
            int r7 = r6 >> 8
            r7 = r7 & r9
            int r20 = r20 + r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r6
            int r22 = r22 + 1
            goto L_0x02fc
        L_0x02fa:
            r25 = r9
        L_0x02fc:
            int r4 = r4 + 1
            r7 = r24
            r9 = r25
            goto L_0x02c7
        L_0x0303:
            r24 = r7
        L_0x0305:
            r25 = r9
            int r0 = r0 + r8
            r4 = r0
        L_0x0309:
            int r6 = r1.sampleSize
            int r6 = r6 + r0
            if (r4 >= r6) goto L_0x0338
            byte[] r6 = r1.mainPixels
            int r7 = r6.length
            if (r4 >= r7) goto L_0x0338
            if (r4 >= r15) goto L_0x0338
            byte r6 = r6[r4]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            int[] r9 = r1.act
            r6 = r9[r6]
            if (r6 == 0) goto L_0x0335
            int r9 = r6 >> 24
            r9 = r9 & r7
            int r18 = r18 + r9
            int r9 = r6 >> 16
            r9 = r9 & r7
            int r19 = r19 + r9
            int r9 = r6 >> 8
            r9 = r9 & r7
            int r20 = r20 + r9
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r6
            int r22 = r22 + 1
        L_0x0335:
            int r4 = r4 + 1
            goto L_0x0309
        L_0x0338:
            r7 = 255(0xff, float:3.57E-43)
            if (r22 != 0) goto L_0x033e
            r0 = 0
            goto L_0x0350
        L_0x033e:
            int r18 = r18 / r22
            int r0 = r18 << 24
            int r19 = r19 / r22
            int r4 = r19 << 16
            r0 = r0 | r4
            int r20 = r20 / r22
            int r4 = r20 << 8
            r0 = r0 | r4
            int r21 = r21 / r22
            r0 = r0 | r21
        L_0x0350:
            if (r0 == 0) goto L_0x0355
            r11[r5] = r0
            goto L_0x035e
        L_0x0355:
            boolean r0 = r1.isFirstFrameTransparent
            if (r0 != 0) goto L_0x035e
            if (r3 == 0) goto L_0x035e
            r4 = 1
            r1.isFirstFrameTransparent = r4
        L_0x035e:
            int r0 = r1.sampleSize
            int r8 = r8 + r0
            int r5 = r5 + 1
            r0 = r30
            r4 = r16
            r6 = r23
            r7 = r24
            r9 = r25
            goto L_0x0298
        L_0x036f:
            r30 = r0
            r16 = r4
            r23 = r6
            r24 = r7
            r25 = r9
            r7 = 255(0xff, float:3.57E-43)
            int r10 = r10 + 1
            r0 = r30
            r8 = r13
            r4 = r16
            r6 = r23
            r7 = r24
            r9 = r25
            r5 = 0
            goto L_0x0253
        L_0x038b:
            boolean r0 = r1.savePrevious
            if (r0 == 0) goto L_0x03ae
            int r0 = r2.dispose
            if (r0 == 0) goto L_0x0396
            r2 = 1
            if (r0 != r2) goto L_0x03ae
        L_0x0396:
            android.graphics.Bitmap r0 = r1.previousImage
            if (r0 != 0) goto L_0x03a0
            android.graphics.Bitmap r0 = r28.getNextBitmap()
            r1.previousImage = r0
        L_0x03a0:
            android.graphics.Bitmap r2 = r1.previousImage
            r4 = 0
            int r8 = r1.downsampledWidth
            r6 = 0
            r7 = 0
            int r9 = r1.downsampledHeight
            r3 = r11
            r5 = r8
            r2.setPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x03ae:
            android.graphics.Bitmap r0 = r28.getNextBitmap()
            r4 = 0
            int r8 = r1.downsampledWidth
            r6 = 0
            r7 = 0
            int r9 = r1.downsampledHeight
            r2 = r0
            r3 = r11
            r5 = r8
            r2.setPixels(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x03c0:
            r2 = r4
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.GifDecoder.setPixels(com.clevertap.android.sdk.gif.GifFrame, com.clevertap.android.sdk.gif.GifFrame):android.graphics.Bitmap");
    }
}
