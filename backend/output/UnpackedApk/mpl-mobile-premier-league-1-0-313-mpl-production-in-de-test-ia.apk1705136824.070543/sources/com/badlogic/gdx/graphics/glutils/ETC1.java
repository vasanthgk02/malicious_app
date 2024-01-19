package com.badlogic.gdx.graphics.glutils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;

public class ETC1 {
    public static int ETC1_RGB8_OES = 36196;
    public static int PKM_HEADER_SIZE = 16;

    public static final class ETC1Data implements Disposable {
        public final ByteBuffer compressedData;
        public final int dataOffset;
        public final int height;
        public final int width;

        public ETC1Data(int i, int i2, ByteBuffer byteBuffer, int i3) {
            this.width = i;
            this.height = i2;
            this.compressedData = byteBuffer;
            this.dataOffset = i3;
            checkNPOT();
        }

        private void checkNPOT() {
            if (!MathUtils.isPowerOfTwo(this.width) || !MathUtils.isPowerOfTwo(this.height)) {
                System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
            }
        }

        public void dispose() {
            BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
        }

        public boolean hasPKMHeader() {
            return this.dataOffset == 16;
        }

        public String toString() {
            if (hasPKMHeader()) {
                StringBuilder sb = new StringBuilder();
                sb.append(ETC1.isValidPKM(this.compressedData, 0) ? "valid" : "invalid");
                sb.append(" pkm [");
                sb.append(ETC1.getWidthPKM(this.compressedData, 0));
                sb.append("x");
                sb.append(ETC1.getHeightPKM(this.compressedData, 0));
                sb.append("], compressed: ");
                sb.append(this.compressedData.capacity() - ETC1.PKM_HEADER_SIZE);
                return sb.toString();
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("raw [");
            outline73.append(this.width);
            outline73.append("x");
            outline73.append(this.height);
            outline73.append("], compressed: ");
            outline73.append(this.compressedData.capacity() - ETC1.PKM_HEADER_SIZE);
            return outline73.toString();
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A[SYNTHETIC, Splitter:B:24:0x0083] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void write(com.badlogic.gdx.files.FileHandle r8) {
            /*
                r7 = this;
                r0 = 10240(0x2800, float:1.4349E-41)
                byte[] r1 = new byte[r0]
                java.nio.ByteBuffer r2 = r7.compressedData
                r3 = 0
                r2.position(r3)
                java.nio.ByteBuffer r2 = r7.compressedData
                int r4 = r2.capacity()
                r2.limit(r4)
                r2 = 0
                java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0064 }
                java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0064 }
                java.io.OutputStream r6 = r8.write(r3)     // Catch:{ Exception -> 0x0064 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0064 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0064 }
                java.nio.ByteBuffer r2 = r7.compressedData     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r2 = r2.capacity()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r4.writeInt(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r2 = 0
            L_0x002c:
                java.nio.ByteBuffer r5 = r7.compressedData     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r5 = r5.capacity()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                if (r2 == r5) goto L_0x0048
                java.nio.ByteBuffer r5 = r7.compressedData     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r5 = r5.remaining()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r5 = java.lang.Math.min(r5, r0)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                java.nio.ByteBuffer r6 = r7.compressedData     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r6.get(r1, r3, r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                r4.write(r1, r3, r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
                int r2 = r2 + r5
                goto L_0x002c
            L_0x0048:
                r4.close()     // Catch:{ all -> 0x004b }
            L_0x004b:
                java.nio.ByteBuffer r8 = r7.compressedData
                int r0 = r7.dataOffset
                r8.position(r0)
                java.nio.ByteBuffer r8 = r7.compressedData
                int r0 = r8.capacity()
                r8.limit(r0)
                return
            L_0x005c:
                r8 = move-exception
                r2 = r4
                goto L_0x0081
            L_0x005f:
                r0 = move-exception
                r2 = r4
                goto L_0x0065
            L_0x0062:
                r8 = move-exception
                goto L_0x0081
            L_0x0064:
                r0 = move-exception
            L_0x0065:
                com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0062 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
                r3.<init>()     // Catch:{ all -> 0x0062 }
                java.lang.String r4 = "Couldn't write PKM file to '"
                r3.append(r4)     // Catch:{ all -> 0x0062 }
                r3.append(r8)     // Catch:{ all -> 0x0062 }
                java.lang.String r8 = "'"
                r3.append(r8)     // Catch:{ all -> 0x0062 }
                java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0062 }
                r1.<init>(r8, r0)     // Catch:{ all -> 0x0062 }
                throw r1     // Catch:{ all -> 0x0062 }
            L_0x0081:
                if (r2 == 0) goto L_0x0086
                r2.close()     // Catch:{ all -> 0x0086 }
            L_0x0086:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data.write(com.badlogic.gdx.files.FileHandle):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[SYNTHETIC, Splitter:B:24:0x008a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ETC1Data(com.badlogic.gdx.files.FileHandle r7) {
            /*
                r6 = this;
                r6.<init>()
                r0 = 10240(0x2800, float:1.4349E-41)
                byte[] r0 = new byte[r0]
                r1 = 0
                java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ Exception -> 0x006b }
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006b }
                java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x006b }
                java.io.InputStream r5 = r7.read()     // Catch:{ Exception -> 0x006b }
                r4.<init>(r5)     // Catch:{ Exception -> 0x006b }
                r3.<init>(r4)     // Catch:{ Exception -> 0x006b }
                r2.<init>(r3)     // Catch:{ Exception -> 0x006b }
                int r1 = r2.readInt()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                java.nio.ByteBuffer r1 = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(r1)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r6.compressedData = r1     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            L_0x0025:
                int r1 = r2.read(r0)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r3 = -1
                r4 = 0
                if (r1 == r3) goto L_0x0033
                java.nio.ByteBuffer r3 = r6.compressedData     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r3.put(r0, r4, r1)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                goto L_0x0025
            L_0x0033:
                java.nio.ByteBuffer r0 = r6.compressedData     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r0.position(r4)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                java.nio.ByteBuffer r0 = r6.compressedData     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                java.nio.ByteBuffer r1 = r6.compressedData     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                int r1 = r1.capacity()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r0.limit(r1)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
                r2.close()     // Catch:{ all -> 0x0046 }
            L_0x0046:
                java.nio.ByteBuffer r7 = r6.compressedData
                int r7 = com.badlogic.gdx.graphics.glutils.ETC1.getWidthPKM(r7, r4)
                r6.width = r7
                java.nio.ByteBuffer r7 = r6.compressedData
                int r7 = com.badlogic.gdx.graphics.glutils.ETC1.getHeightPKM(r7, r4)
                r6.height = r7
                int r7 = com.badlogic.gdx.graphics.glutils.ETC1.PKM_HEADER_SIZE
                r6.dataOffset = r7
                java.nio.ByteBuffer r0 = r6.compressedData
                r0.position(r7)
                r6.checkNPOT()
                return
            L_0x0063:
                r7 = move-exception
                r1 = r2
                goto L_0x0088
            L_0x0066:
                r0 = move-exception
                r1 = r2
                goto L_0x006c
            L_0x0069:
                r7 = move-exception
                goto L_0x0088
            L_0x006b:
                r0 = move-exception
            L_0x006c:
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0069 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
                r3.<init>()     // Catch:{ all -> 0x0069 }
                java.lang.String r4 = "Couldn't load pkm file '"
                r3.append(r4)     // Catch:{ all -> 0x0069 }
                r3.append(r7)     // Catch:{ all -> 0x0069 }
                java.lang.String r7 = "'"
                r3.append(r7)     // Catch:{ all -> 0x0069 }
                java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0069 }
                r2.<init>(r7, r0)     // Catch:{ all -> 0x0069 }
                throw r2     // Catch:{ all -> 0x0069 }
            L_0x0088:
                if (r1 == 0) goto L_0x008d
                r1.close()     // Catch:{ all -> 0x008d }
            L_0x008d:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data.<init>(com.badlogic.gdx.files.FileHandle):void");
        }
    }

    public static Pixmap decodeImage(ETC1Data eTC1Data, Format format) {
        int i;
        int i2;
        int i3;
        if (eTC1Data.hasPKMHeader()) {
            int widthPKM = getWidthPKM(eTC1Data.compressedData, 0);
            i = getHeightPKM(eTC1Data.compressedData, 0);
            i2 = widthPKM;
            i3 = 16;
        } else {
            int i4 = eTC1Data.width;
            i = eTC1Data.height;
            i2 = i4;
            i3 = 0;
        }
        int pixelSize = getPixelSize(format);
        Pixmap pixmap = new Pixmap(i2, i, format);
        decodeImage(eTC1Data.compressedData, i3, pixmap.getPixels(), 0, i2, i, pixelSize);
        return pixmap;
    }

    public static native void decodeImage(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5);

    public static ETC1Data encodeImage(Pixmap pixmap) {
        ByteBuffer encodeImage = encodeImage(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), getPixelSize(pixmap.getFormat()));
        BufferUtils.newUnsafeByteBuffer(encodeImage);
        return new ETC1Data(pixmap.getWidth(), pixmap.getHeight(), encodeImage, 0);
    }

    public static native ByteBuffer encodeImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static ETC1Data encodeImagePKM(Pixmap pixmap) {
        ByteBuffer encodeImagePKM = encodeImagePKM(pixmap.getPixels(), 0, pixmap.getWidth(), pixmap.getHeight(), getPixelSize(pixmap.getFormat()));
        BufferUtils.newUnsafeByteBuffer(encodeImagePKM);
        return new ETC1Data(pixmap.getWidth(), pixmap.getHeight(), encodeImagePKM, 16);
    }

    public static native ByteBuffer encodeImagePKM(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    public static native void formatHeader(ByteBuffer byteBuffer, int i, int i2, int i3);

    public static native int getCompressedDataSize(int i, int i2);

    public static native int getHeightPKM(ByteBuffer byteBuffer, int i);

    public static int getPixelSize(Format format) {
        if (format == Format.RGB565) {
            return 2;
        }
        if (format == Format.RGB888) {
            return 3;
        }
        throw new GdxRuntimeException((String) "Can only handle RGB565 or RGB888 images");
    }

    public static native int getWidthPKM(ByteBuffer byteBuffer, int i);

    public static native boolean isValidPKM(ByteBuffer byteBuffer, int i);
}
