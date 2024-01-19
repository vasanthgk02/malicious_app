package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import sfs2x.client.entities.invitation.InvitationReply;

public class StandardGifDecoder implements GifDecoder {
    public int[] act;
    public Config bitmapConfig = Config.ARGB_8888;
    public final BitmapProvider bitmapProvider;
    public byte[] block;
    public int downsampledHeight;
    public int downsampledWidth;
    public int framePointer;
    public GifHeader header;
    public Boolean isFirstFrameTransparent;
    public byte[] mainPixels;
    public int[] mainScratch;
    public final int[] pct = new int[256];
    public byte[] pixelStack;
    public short[] prefix;
    public Bitmap previousImage;
    public ByteBuffer rawData;
    public int sampleSize;
    public boolean savePrevious;
    public int status;
    public byte[] suffix;

    public StandardGifDecoder(BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        int[] iArr;
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
        synchronized (this) {
            if (i > 0) {
                int highestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.framePointer = -1;
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
                this.downsampledWidth = gifHeader.width / highestOneBit;
                this.downsampledHeight = gifHeader.height / highestOneBit;
                this.mainPixels = ((GifBitmapProvider) this.bitmapProvider).obtainByteArray(gifHeader.width * gifHeader.height);
                BitmapProvider bitmapProvider3 = this.bitmapProvider;
                int i2 = this.downsampledWidth * this.downsampledHeight;
                ArrayPool arrayPool = ((GifBitmapProvider) bitmapProvider3).arrayPool;
                if (arrayPool == null) {
                    iArr = new int[i2];
                } else {
                    iArr = (int[]) arrayPool.get(i2, int[].class);
                }
                this.mainScratch = iArr;
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        }
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            ArrayPool arrayPool = ((GifBitmapProvider) this.bitmapProvider).arrayPool;
            if (arrayPool != null) {
                arrayPool.put(bArr);
            }
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            ArrayPool arrayPool2 = ((GifBitmapProvider) this.bitmapProvider).arrayPool;
            if (arrayPool2 != null) {
                arrayPool2.put(iArr);
            }
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            ((GifBitmapProvider) this.bitmapProvider).bitmapPool.put(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            ArrayPool arrayPool3 = ((GifBitmapProvider) this.bitmapProvider).arrayPool;
            if (arrayPool3 != null) {
                arrayPool3.put(bArr2);
            }
        }
    }

    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public final Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Config config = (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.bitmapConfig;
        Bitmap dirty = ((GifBitmapProvider) this.bitmapProvider).bitmapPool.getDirty(this.downsampledWidth, this.downsampledHeight, config);
        dirty.setHasAlpha(true);
        return dirty;
    }

    public int getNextDelay() {
        GifHeader gifHeader = this.header;
        int i = gifHeader.frameCount;
        if (i > 0) {
            int i2 = this.framePointer;
            if (i2 >= 0) {
                return (i2 < 0 || i2 >= i) ? -1 : gifHeader.frames.get(i2).delay;
            }
        }
        return 0;
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (Log.isLoggable("StandardGifDecoder", 3)) {
                int i = this.header.frameCount;
            }
            this.status = 1;
        }
        if (this.status != 1) {
            if (this.status != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = ((GifBitmapProvider) this.bitmapProvider).obtainByteArray(InvitationReply.EXPIRED);
                }
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i2 = this.framePointer - 1;
                GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
                int[] iArr = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
                this.act = iArr;
                if (iArr == null) {
                    boolean isLoggable = Log.isLoggable("StandardGifDecoder", 3);
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[gifFrame.transIndex] = 0;
                    if (gifFrame.dispose == 2 && this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return setPixels(gifFrame, gifFrame2);
            }
        }
        boolean isLoggable2 = Log.isLoggable("StandardGifDecoder", 3);
        return null;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setDefaultBitmapConfig(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Config.ARGB_8888 + " or " + Config.RGB_565);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r3.bgIndex == r1.transIndex) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap setPixels(com.bumptech.glide.gifdecoder.GifFrame r36, com.bumptech.glide.gifdecoder.GifFrame r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            int[] r10 = r0.mainScratch
            r11 = 0
            if (r2 != 0) goto L_0x001e
            android.graphics.Bitmap r3 = r0.previousImage
            if (r3 == 0) goto L_0x0018
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r4 = r0.bitmapProvider
            com.bumptech.glide.load.resource.gif.GifBitmapProvider r4 = (com.bumptech.glide.load.resource.gif.GifBitmapProvider) r4
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r4 = r4.bitmapPool
            r4.put(r3)
        L_0x0018:
            r3 = 0
            r0.previousImage = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001e:
            r12 = 3
            if (r2 == 0) goto L_0x002c
            int r3 = r2.dispose
            if (r3 != r12) goto L_0x002c
            android.graphics.Bitmap r3 = r0.previousImage
            if (r3 != 0) goto L_0x002c
            java.util.Arrays.fill(r10, r11)
        L_0x002c:
            r13 = 2
            if (r2 == 0) goto L_0x0080
            int r3 = r2.dispose
            if (r3 <= 0) goto L_0x0080
            if (r3 != r13) goto L_0x006e
            boolean r3 = r1.transparency
            if (r3 != 0) goto L_0x0047
            com.bumptech.glide.gifdecoder.GifHeader r3 = r0.header
            int r4 = r3.bgColor
            int[] r5 = r1.lct
            if (r5 == 0) goto L_0x0048
            int r3 = r3.bgIndex
            int r5 = r1.transIndex
            if (r3 != r5) goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            int r3 = r2.ih
            int r5 = r0.sampleSize
            int r3 = r3 / r5
            int r6 = r2.iy
            int r6 = r6 / r5
            int r7 = r2.iw
            int r7 = r7 / r5
            int r2 = r2.ix
            int r2 = r2 / r5
            int r5 = r0.downsampledWidth
            int r6 = r6 * r5
            int r6 = r6 + r2
            int r3 = r3 * r5
            int r3 = r3 + r6
        L_0x005e:
            if (r6 >= r3) goto L_0x0080
            int r2 = r6 + r7
            r5 = r6
        L_0x0063:
            if (r5 >= r2) goto L_0x006a
            r10[r5] = r4
            int r5 = r5 + 1
            goto L_0x0063
        L_0x006a:
            int r2 = r0.downsampledWidth
            int r6 = r6 + r2
            goto L_0x005e
        L_0x006e:
            if (r3 != r12) goto L_0x0080
            android.graphics.Bitmap r2 = r0.previousImage
            if (r2 == 0) goto L_0x0080
            r4 = 0
            int r8 = r0.downsampledWidth
            r6 = 0
            r7 = 0
            int r9 = r0.downsampledHeight
            r3 = r10
            r5 = r8
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x0080:
            java.nio.ByteBuffer r2 = r0.rawData
            int r3 = r1.bufferFrameStart
            r2.position(r3)
            int r2 = r1.iw
            int r3 = r1.ih
            int r2 = r2 * r3
            byte[] r3 = r0.mainPixels
            if (r3 == 0) goto L_0x0094
            int r3 = r3.length
            if (r3 >= r2) goto L_0x009e
        L_0x0094:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r3 = r0.bitmapProvider
            com.bumptech.glide.load.resource.gif.GifBitmapProvider r3 = (com.bumptech.glide.load.resource.gif.GifBitmapProvider) r3
            byte[] r3 = r3.obtainByteArray(r2)
            r0.mainPixels = r3
        L_0x009e:
            byte[] r3 = r0.mainPixels
            short[] r4 = r0.prefix
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x00aa
            short[] r4 = new short[r5]
            r0.prefix = r4
        L_0x00aa:
            short[] r4 = r0.prefix
            byte[] r6 = r0.suffix
            if (r6 != 0) goto L_0x00b4
            byte[] r6 = new byte[r5]
            r0.suffix = r6
        L_0x00b4:
            byte[] r6 = r0.suffix
            byte[] r7 = r0.pixelStack
            if (r7 != 0) goto L_0x00c0
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.pixelStack = r7
        L_0x00c0:
            byte[] r7 = r0.pixelStack
            java.nio.ByteBuffer r8 = r0.rawData
            byte r8 = r8.get()
            r8 = r8 & 255(0xff, float:3.57E-43)
            r9 = 1
            int r14 = r9 << r8
            int r15 = r14 + 1
            int r16 = r14 + 2
            int r8 = r8 + r9
            int r17 = r9 << r8
            r13 = -1
            int r17 = r17 + -1
            r5 = 0
        L_0x00d8:
            if (r5 >= r14) goto L_0x00e3
            r4[r5] = r11
            byte r13 = (byte) r5
            r6[r5] = r13
            int r5 = r5 + 1
            r13 = -1
            goto L_0x00d8
        L_0x00e3:
            byte[] r5 = r0.block
            r12 = r0
            r25 = r8
            r24 = r16
            r28 = r17
            r9 = 0
            r13 = -1
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r29 = 0
        L_0x00fc:
            r30 = 8
            if (r9 >= r2) goto L_0x01ef
            if (r20 != 0) goto L_0x0139
            java.nio.ByteBuffer r11 = r12.rawData
            byte r11 = r11.get()
            r11 = r11 & 255(0xff, float:3.57E-43)
            if (r11 > 0) goto L_0x0115
            r31 = r8
            r32 = r9
            r34 = r10
            r33 = r13
            goto L_0x012d
        L_0x0115:
            r31 = r8
            java.nio.ByteBuffer r8 = r12.rawData
            r32 = r9
            byte[] r9 = r12.block
            r33 = r13
            int r13 = r8.remaining()
            int r13 = java.lang.Math.min(r11, r13)
            r34 = r10
            r10 = 0
            r8.get(r9, r10, r13)
        L_0x012d:
            if (r11 > 0) goto L_0x0134
            r8 = 3
            r12.status = r8
            goto L_0x01f1
        L_0x0134:
            r20 = r11
            r21 = 0
            goto L_0x0141
        L_0x0139:
            r31 = r8
            r32 = r9
            r34 = r10
            r33 = r13
        L_0x0141:
            byte r8 = r5[r21]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r22
            int r23 = r23 + r8
            int r22 = r22 + 8
            r8 = 1
            int r21 = r21 + 1
            r8 = -1
            int r20 = r20 + -1
            r10 = r22
            r11 = r24
            r8 = r25
            r9 = r32
            r13 = r33
            r22 = r5
            r5 = r26
        L_0x015f:
            if (r10 < r8) goto L_0x01d9
            r24 = r12
            r12 = r23 & r28
            int r23 = r23 >> r8
            int r10 = r10 - r8
            if (r12 != r14) goto L_0x0174
            r11 = r16
            r28 = r17
            r12 = r24
            r8 = r31
            r13 = -1
            goto L_0x015f
        L_0x0174:
            if (r12 != r15) goto L_0x017e
            r12 = r24
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01de
        L_0x017e:
            r25 = r10
            r10 = -1
            if (r13 != r10) goto L_0x0190
            byte r5 = r6[r12]
            r3[r27] = r5
            int r27 = r27 + 1
            int r9 = r9 + 1
            r24 = r12
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01d2
        L_0x0190:
            if (r12 < r11) goto L_0x0199
            byte r5 = (byte) r5
            r7[r29] = r5
            int r29 = r29 + 1
            r5 = r13
            goto L_0x019a
        L_0x0199:
            r5 = r12
        L_0x019a:
            if (r5 < r14) goto L_0x01a5
            byte r10 = r6[r5]
            r7[r29] = r10
            int r29 = r29 + 1
            short r5 = r4[r5]
            goto L_0x019a
        L_0x01a5:
            byte r5 = r6[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r5
            r3[r27] = r10
        L_0x01ac:
            r19 = 1
            int r27 = r27 + 1
            int r9 = r9 + 1
            if (r29 <= 0) goto L_0x01bb
            int r29 = r29 + -1
            byte r24 = r7[r29]
            r3[r27] = r24
            goto L_0x01ac
        L_0x01bb:
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            if (r11 >= r5) goto L_0x01d2
            short r13 = (short) r13
            r4[r11] = r13
            r6[r11] = r10
            int r11 = r11 + 1
            r10 = r11 & r28
            if (r10 != 0) goto L_0x01d2
            if (r11 >= r5) goto L_0x01d2
            int r8 = r8 + 1
            int r28 = r28 + r11
        L_0x01d2:
            r13 = r12
            r5 = r24
            r10 = r25
            r12 = r0
            goto L_0x015f
        L_0x01d9:
            r24 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            r12 = r0
        L_0x01de:
            r25 = r8
            r5 = r22
            r26 = r24
            r8 = r31
            r22 = r10
            r24 = r11
            r10 = r34
            r11 = 0
            goto L_0x00fc
        L_0x01ef:
            r34 = r10
        L_0x01f1:
            r11 = r27
            r10 = 0
            java.util.Arrays.fill(r3, r11, r2, r10)
            boolean r2 = r1.interlace
            if (r2 != 0) goto L_0x0270
            int r2 = r0.sampleSize
            r3 = 1
            if (r2 == r3) goto L_0x0202
            goto L_0x0270
        L_0x0202:
            int[] r2 = r0.mainScratch
            int r3 = r1.ih
            int r4 = r1.iy
            int r5 = r1.iw
            int r6 = r1.ix
            int r7 = r0.framePointer
            if (r7 != 0) goto L_0x0212
            r7 = 1
            goto L_0x0213
        L_0x0212:
            r7 = 0
        L_0x0213:
            int r8 = r0.downsampledWidth
            byte[] r9 = r0.mainPixels
            int[] r11 = r0.act
            r12 = -1
            r13 = 0
        L_0x021b:
            if (r13 >= r3) goto L_0x0252
            int r14 = r13 + r4
            int r14 = r14 * r8
            int r15 = r14 + r6
            int r10 = r15 + r5
            int r14 = r14 + r8
            if (r14 >= r10) goto L_0x0229
            r10 = r14
        L_0x0229:
            int r14 = r1.iw
            int r14 = r14 * r13
        L_0x022d:
            if (r15 >= r10) goto L_0x024a
            r16 = r3
            byte r3 = r9[r14]
            r17 = r4
            r4 = r3 & 255(0xff, float:3.57E-43)
            if (r4 == r12) goto L_0x0241
            r4 = r11[r4]
            if (r4 == 0) goto L_0x0240
            r2[r15] = r4
            goto L_0x0241
        L_0x0240:
            r12 = r3
        L_0x0241:
            int r14 = r14 + 1
            int r15 = r15 + 1
            r3 = r16
            r4 = r17
            goto L_0x022d
        L_0x024a:
            r16 = r3
            r17 = r4
            int r13 = r13 + 1
            r10 = 0
            goto L_0x021b
        L_0x0252:
            java.lang.Boolean r2 = r0.isFirstFrameTransparent
            if (r2 == 0) goto L_0x025c
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0265
        L_0x025c:
            java.lang.Boolean r2 = r0.isFirstFrameTransparent
            if (r2 != 0) goto L_0x0267
            if (r7 == 0) goto L_0x0267
            r2 = -1
            if (r12 == r2) goto L_0x0267
        L_0x0265:
            r11 = 1
            goto L_0x0268
        L_0x0267:
            r11 = 0
        L_0x0268:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
            r0.isFirstFrameTransparent = r2
            goto L_0x0400
        L_0x0270:
            int[] r2 = r0.mainScratch
            int r3 = r1.ih
            int r4 = r0.sampleSize
            int r3 = r3 / r4
            int r5 = r1.iy
            int r5 = r5 / r4
            int r6 = r1.iw
            int r6 = r6 / r4
            int r7 = r1.ix
            int r7 = r7 / r4
            int r4 = r0.framePointer
            if (r4 != 0) goto L_0x0286
            r10 = 1
            goto L_0x0287
        L_0x0286:
            r10 = 0
        L_0x0287:
            int r4 = r0.sampleSize
            int r8 = r0.downsampledWidth
            int r9 = r0.downsampledHeight
            byte[] r11 = r0.mainPixels
            int[] r12 = r0.act
            java.lang.Boolean r13 = r0.isFirstFrameTransparent
            r14 = r13
            r13 = 0
            r15 = 0
            r16 = 1
            r17 = 8
        L_0x029a:
            if (r13 >= r3) goto L_0x03ec
            r37 = r14
            boolean r14 = r1.interlace
            if (r14 == 0) goto L_0x02c9
            if (r15 < r3) goto L_0x02c4
            int r14 = r16 + 1
            r20 = r3
            r3 = 2
            if (r14 == r3) goto L_0x02bf
            r3 = 3
            if (r14 == r3) goto L_0x02b8
            r3 = 4
            r16 = r14
            if (r14 == r3) goto L_0x02b4
            goto L_0x02c6
        L_0x02b4:
            r15 = 1
            r17 = 2
            goto L_0x02c6
        L_0x02b8:
            r3 = 4
            r16 = r14
            r15 = 2
            r17 = 4
            goto L_0x02c6
        L_0x02bf:
            r3 = 4
            r16 = r14
            r15 = 4
            goto L_0x02c6
        L_0x02c4:
            r20 = r3
        L_0x02c6:
            int r3 = r15 + r17
            goto L_0x02cd
        L_0x02c9:
            r20 = r3
            r3 = r15
            r15 = r13
        L_0x02cd:
            int r15 = r15 + r5
            r14 = 1
            if (r4 != r14) goto L_0x02d3
            r14 = 1
            goto L_0x02d4
        L_0x02d3:
            r14 = 0
        L_0x02d4:
            if (r15 >= r9) goto L_0x03cc
            int r15 = r15 * r8
            int r18 = r15 + r7
            r21 = r3
            int r3 = r18 + r6
            int r15 = r15 + r8
            if (r15 >= r3) goto L_0x02e2
            r3 = r15
        L_0x02e2:
            int r15 = r13 * r4
            r22 = r5
            int r5 = r1.iw
            int r15 = r15 * r5
            if (r14 == 0) goto L_0x030c
            r14 = r37
            r5 = r18
        L_0x02f0:
            r23 = r6
            if (r5 >= r3) goto L_0x03c5
            byte r6 = r11[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r12[r6]
            if (r6 == 0) goto L_0x02ff
            r2[r5] = r6
            goto L_0x0306
        L_0x02ff:
            if (r10 == 0) goto L_0x0306
            if (r14 != 0) goto L_0x0306
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r14 = r6
        L_0x0306:
            int r15 = r15 + r4
            int r5 = r5 + 1
            r6 = r23
            goto L_0x02f0
        L_0x030c:
            r23 = r6
            int r5 = r3 - r18
            int r5 = r5 * r4
            int r5 = r5 + r15
            r14 = r37
            r6 = r18
        L_0x0317:
            if (r6 >= r3) goto L_0x03c5
            r18 = r3
            int r3 = r1.iw
            r29 = r7
            r31 = r8
            r7 = r15
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x032c:
            int r8 = r0.sampleSize
            int r8 = r8 + r15
            if (r7 >= r8) goto L_0x0361
            byte[] r8 = r0.mainPixels
            r32 = r9
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0363
            if (r7 >= r5) goto L_0x0363
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r9 = r0.act
            r8 = r9[r8]
            if (r8 == 0) goto L_0x035c
            int r9 = r8 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r24 = r24 + r9
            int r9 = r8 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r9
            int r9 = r8 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x035c:
            int r7 = r7 + 1
            r9 = r32
            goto L_0x032c
        L_0x0361:
            r32 = r9
        L_0x0363:
            int r3 = r3 + r15
            r7 = r3
        L_0x0365:
            int r8 = r0.sampleSize
            int r8 = r8 + r3
            if (r7 >= r8) goto L_0x0396
            byte[] r8 = r0.mainPixels
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0396
            if (r7 >= r5) goto L_0x0396
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r9 = r0.act
            r8 = r9[r8]
            if (r8 == 0) goto L_0x0393
            int r9 = r8 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r24 = r24 + r9
            int r9 = r8 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r9
            int r9 = r8 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x0393:
            int r7 = r7 + 1
            goto L_0x0365
        L_0x0396:
            if (r28 != 0) goto L_0x039a
            r3 = 0
            goto L_0x03ac
        L_0x039a:
            int r24 = r24 / r28
            int r3 = r24 << 24
            int r25 = r25 / r28
            int r7 = r25 << 16
            r3 = r3 | r7
            int r26 = r26 / r28
            int r7 = r26 << 8
            r3 = r3 | r7
            int r27 = r27 / r28
            r3 = r3 | r27
        L_0x03ac:
            if (r3 == 0) goto L_0x03b1
            r2[r6] = r3
            goto L_0x03b8
        L_0x03b1:
            if (r10 == 0) goto L_0x03b8
            if (r14 != 0) goto L_0x03b8
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r14 = r3
        L_0x03b8:
            int r15 = r15 + r4
            int r6 = r6 + 1
            r3 = r18
            r7 = r29
            r8 = r31
            r9 = r32
            goto L_0x0317
        L_0x03c5:
            r29 = r7
            r31 = r8
            r32 = r9
            goto L_0x03da
        L_0x03cc:
            r21 = r3
            r22 = r5
            r23 = r6
            r29 = r7
            r31 = r8
            r32 = r9
            r14 = r37
        L_0x03da:
            int r13 = r13 + 1
            r3 = r20
            r15 = r21
            r5 = r22
            r6 = r23
            r7 = r29
            r8 = r31
            r9 = r32
            goto L_0x029a
        L_0x03ec:
            r37 = r14
            java.lang.Boolean r2 = r0.isFirstFrameTransparent
            if (r2 != 0) goto L_0x0400
            if (r37 != 0) goto L_0x03f6
            r11 = 0
            goto L_0x03fa
        L_0x03f6:
            boolean r11 = r37.booleanValue()
        L_0x03fa:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
            r0.isFirstFrameTransparent = r2
        L_0x0400:
            boolean r2 = r0.savePrevious
            if (r2 == 0) goto L_0x0424
            int r1 = r1.dispose
            if (r1 == 0) goto L_0x040b
            r2 = 1
            if (r1 != r2) goto L_0x0424
        L_0x040b:
            android.graphics.Bitmap r1 = r0.previousImage
            if (r1 != 0) goto L_0x0415
            android.graphics.Bitmap r1 = r35.getNextBitmap()
            r0.previousImage = r1
        L_0x0415:
            android.graphics.Bitmap r1 = r0.previousImage
            r3 = 0
            int r7 = r0.downsampledWidth
            r5 = 0
            r6 = 0
            int r8 = r0.downsampledHeight
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0424:
            android.graphics.Bitmap r9 = r35.getNextBitmap()
            r3 = 0
            int r7 = r0.downsampledWidth
            r5 = 0
            r6 = 0
            int r8 = r0.downsampledHeight
            r1 = r9
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.setPixels(com.bumptech.glide.gifdecoder.GifFrame, com.bumptech.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }
}
