package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.utils.ByteArray;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import sfs2x.client.entities.invitation.InvitationReply;

public class PixmapIO {

    public static class CIM {
        public static final int BUFFER_SIZE = 32000;
        public static final byte[] readBuffer = new byte[BUFFER_SIZE];
        public static final byte[] writeBuffer = new byte[BUFFER_SIZE];

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0083 A[SYNTHETIC, Splitter:B:32:0x0083] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.badlogic.gdx.graphics.Pixmap read(com.badlogic.gdx.files.FileHandle r8) {
            /*
                r0 = 0
                java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                java.util.zip.InflaterInputStream r2 = new java.util.zip.InflaterInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                java.io.InputStream r4 = r8.read()     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                r3.<init>(r4)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                r2.<init>(r3)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                r1.<init>(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
                int r0 = r1.readInt()     // Catch:{ Exception -> 0x005b }
                int r2 = r1.readInt()     // Catch:{ Exception -> 0x005b }
                int r3 = r1.readInt()     // Catch:{ Exception -> 0x005b }
                com.badlogic.gdx.graphics.Pixmap$Format r3 = com.badlogic.gdx.graphics.Pixmap.Format.fromGdx2DPixmapFormat(r3)     // Catch:{ Exception -> 0x005b }
                com.badlogic.gdx.graphics.Pixmap r4 = new com.badlogic.gdx.graphics.Pixmap     // Catch:{ Exception -> 0x005b }
                r4.<init>(r0, r2, r3)     // Catch:{ Exception -> 0x005b }
                java.nio.ByteBuffer r0 = r4.getPixels()     // Catch:{ Exception -> 0x005b }
                r2 = 0
                r0.position(r2)     // Catch:{ Exception -> 0x005b }
                int r3 = r0.capacity()     // Catch:{ Exception -> 0x005b }
                r0.limit(r3)     // Catch:{ Exception -> 0x005b }
                byte[] r3 = readBuffer     // Catch:{ Exception -> 0x005b }
                monitor-enter(r3)     // Catch:{ Exception -> 0x005b }
            L_0x003b:
                byte[] r5 = readBuffer     // Catch:{ all -> 0x0058 }
                int r5 = r1.read(r5)     // Catch:{ all -> 0x0058 }
                if (r5 <= 0) goto L_0x0049
                byte[] r6 = readBuffer     // Catch:{ all -> 0x0058 }
                r0.put(r6, r2, r5)     // Catch:{ all -> 0x0058 }
                goto L_0x003b
            L_0x0049:
                monitor-exit(r3)     // Catch:{ all -> 0x0058 }
                r0.position(r2)     // Catch:{ Exception -> 0x005b }
                int r2 = r0.capacity()     // Catch:{ Exception -> 0x005b }
                r0.limit(r2)     // Catch:{ Exception -> 0x005b }
                r1.close()     // Catch:{ all -> 0x0057 }
            L_0x0057:
                return r4
            L_0x0058:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0058 }
                throw r0     // Catch:{ Exception -> 0x005b }
            L_0x005b:
                r0 = move-exception
                goto L_0x0063
            L_0x005d:
                r8 = move-exception
                goto L_0x0081
            L_0x005f:
                r1 = move-exception
                r7 = r1
                r1 = r0
                r0 = r7
            L_0x0063:
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x007f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
                r3.<init>()     // Catch:{ all -> 0x007f }
                java.lang.String r4 = "Couldn't read Pixmap from file '"
                r3.append(r4)     // Catch:{ all -> 0x007f }
                r3.append(r8)     // Catch:{ all -> 0x007f }
                java.lang.String r8 = "'"
                r3.append(r8)     // Catch:{ all -> 0x007f }
                java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x007f }
                r2.<init>(r8, r0)     // Catch:{ all -> 0x007f }
                throw r2     // Catch:{ all -> 0x007f }
            L_0x007f:
                r8 = move-exception
                r0 = r1
            L_0x0081:
                if (r0 == 0) goto L_0x0086
                r0.close()     // Catch:{ all -> 0x0086 }
            L_0x0086:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.PixmapIO.CIM.read(com.badlogic.gdx.files.FileHandle):com.badlogic.gdx.graphics.Pixmap");
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A[SYNTHETIC, Splitter:B:32:0x0099] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void write(com.badlogic.gdx.files.FileHandle r7, com.badlogic.gdx.graphics.Pixmap r8) {
            /*
                r0 = 0
                java.util.zip.DeflaterOutputStream r1 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x007a }
                r2 = 0
                java.io.OutputStream r3 = r7.write(r2)     // Catch:{ Exception -> 0x007a }
                r1.<init>(r3)     // Catch:{ Exception -> 0x007a }
                java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x007a }
                r3.<init>(r1)     // Catch:{ Exception -> 0x007a }
                int r0 = r8.getWidth()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r3.writeInt(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = r8.getHeight()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r3.writeInt(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                com.badlogic.gdx.graphics.Pixmap$Format r0 = r8.getFormat()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = com.badlogic.gdx.graphics.Pixmap.Format.toGdx2DPixmapFormat(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r3.writeInt(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                java.nio.ByteBuffer r8 = r8.getPixels()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r8.position(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = r8.capacity()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r8.limit(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = r8.capacity()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = r0 % 32000
                int r1 = r8.capacity()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r1 = r1 / 32000
                byte[] r4 = writeBuffer     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                monitor-enter(r4)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r5 = 0
            L_0x0047:
                if (r5 >= r1) goto L_0x0056
                byte[] r6 = writeBuffer     // Catch:{ all -> 0x006f }
                r8.get(r6)     // Catch:{ all -> 0x006f }
                byte[] r6 = writeBuffer     // Catch:{ all -> 0x006f }
                r3.write(r6)     // Catch:{ all -> 0x006f }
                int r5 = r5 + 1
                goto L_0x0047
            L_0x0056:
                byte[] r1 = writeBuffer     // Catch:{ all -> 0x006f }
                r8.get(r1, r2, r0)     // Catch:{ all -> 0x006f }
                byte[] r1 = writeBuffer     // Catch:{ all -> 0x006f }
                r3.write(r1, r2, r0)     // Catch:{ all -> 0x006f }
                monitor-exit(r4)     // Catch:{ all -> 0x006f }
                r8.position(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                int r0 = r8.capacity()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r8.limit(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
                r3.close()     // Catch:{ all -> 0x006e }
            L_0x006e:
                return
            L_0x006f:
                r8 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x006f }
                throw r8     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            L_0x0072:
                r7 = move-exception
                r0 = r3
                goto L_0x0097
            L_0x0075:
                r8 = move-exception
                r0 = r3
                goto L_0x007b
            L_0x0078:
                r7 = move-exception
                goto L_0x0097
            L_0x007a:
                r8 = move-exception
            L_0x007b:
                com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0078 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
                r2.<init>()     // Catch:{ all -> 0x0078 }
                java.lang.String r3 = "Couldn't write Pixmap to file '"
                r2.append(r3)     // Catch:{ all -> 0x0078 }
                r2.append(r7)     // Catch:{ all -> 0x0078 }
                java.lang.String r7 = "'"
                r2.append(r7)     // Catch:{ all -> 0x0078 }
                java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0078 }
                r1.<init>(r7, r8)     // Catch:{ all -> 0x0078 }
                throw r1     // Catch:{ all -> 0x0078 }
            L_0x0097:
                if (r0 == 0) goto L_0x009c
                r0.close()     // Catch:{ all -> 0x009c }
            L_0x009c:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.PixmapIO.CIM.write(com.badlogic.gdx.files.FileHandle, com.badlogic.gdx.graphics.Pixmap):void");
        }
    }

    public static class PNG implements Disposable {
        public static final byte COLOR_ARGB = 6;
        public static final byte COMPRESSION_DEFLATE = 0;
        public static final byte FILTER_NONE = 0;
        public static final int IDAT = 1229209940;
        public static final int IEND = 1229278788;
        public static final int IHDR = 1229472850;
        public static final byte INTERLACE_NONE = 0;
        public static final byte PAETH = 4;
        public static final byte[] SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
        public final ChunkBuffer buffer;
        public ByteArray curLineBytes;
        public final Deflater deflater;
        public boolean flipY;
        public int lastLineLen;
        public ByteArray lineOutBytes;
        public ByteArray prevLineBytes;

        public static class ChunkBuffer extends DataOutputStream {
            public final ByteArrayOutputStream buffer;
            public final CRC32 crc;

            public ChunkBuffer(int i) {
                this(new ByteArrayOutputStream(i), new CRC32());
            }

            public void endChunk(DataOutputStream dataOutputStream) throws IOException {
                flush();
                dataOutputStream.writeInt(this.buffer.size() - 4);
                this.buffer.writeTo(dataOutputStream);
                dataOutputStream.writeInt((int) this.crc.getValue());
                this.buffer.reset();
                this.crc.reset();
            }

            public ChunkBuffer(ByteArrayOutputStream byteArrayOutputStream, CRC32 crc32) {
                super(new CheckedOutputStream(byteArrayOutputStream, crc32));
                this.buffer = byteArrayOutputStream;
                this.crc = crc32;
            }
        }

        public PNG() {
            this(16384);
        }

        public void dispose() {
            this.deflater.end();
        }

        public void setCompression(int i) {
            this.deflater.setLevel(i);
        }

        public void setFlipY(boolean z) {
            this.flipY = z;
        }

        public void write(FileHandle fileHandle, Pixmap pixmap) throws IOException {
            OutputStream write = fileHandle.write(false);
            try {
                write(write, pixmap);
                try {
                    ((FileOutputStream) write).close();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } catch (Throwable unused2) {
            }
            throw th;
        }

        public PNG(int i) {
            this.flipY = true;
            this.buffer = new ChunkBuffer(i);
            this.deflater = new Deflater();
        }

        public void write(OutputStream outputStream, Pixmap pixmap) throws IOException {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(this.buffer, this.deflater);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(SIGNATURE);
            this.buffer.writeInt(IHDR);
            this.buffer.writeInt(pixmap.getWidth());
            this.buffer.writeInt(pixmap.getHeight());
            this.buffer.writeByte(8);
            this.buffer.writeByte(6);
            int i = 0;
            this.buffer.writeByte(0);
            this.buffer.writeByte(0);
            this.buffer.writeByte(0);
            this.buffer.endChunk(dataOutputStream);
            this.buffer.writeInt(IDAT);
            this.deflater.reset();
            int width = pixmap.getWidth() * 4;
            ByteArray byteArray = this.lineOutBytes;
            if (byteArray == null) {
                ByteArray byteArray2 = new ByteArray(width);
                this.lineOutBytes = byteArray2;
                bArr3 = byteArray2.items;
                ByteArray byteArray3 = new ByteArray(width);
                this.curLineBytes = byteArray3;
                bArr2 = byteArray3.items;
                ByteArray byteArray4 = new ByteArray(width);
                this.prevLineBytes = byteArray4;
                bArr = byteArray4.items;
            } else {
                bArr3 = byteArray.ensureCapacity(width);
                bArr2 = this.curLineBytes.ensureCapacity(width);
                bArr = this.prevLineBytes.ensureCapacity(width);
                int i2 = this.lastLineLen;
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = 0;
                }
            }
            this.lastLineLen = width;
            ByteBuffer pixels = pixmap.getPixels();
            int position = pixels.position();
            int i4 = 1;
            boolean z = pixmap.getFormat() == Format.RGBA8888;
            int height = pixmap.getHeight();
            int i5 = 0;
            while (i5 < height) {
                int i6 = this.flipY ? (height - i5) - i4 : i5;
                if (z) {
                    pixels.position(i6 * width);
                    pixels.get(bArr2, i, width);
                } else {
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < pixmap.getWidth()) {
                        int pixel = pixmap.getPixel(i7, i6);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) ((pixel >> 24) & InvitationReply.EXPIRED);
                        int i10 = i9 + 1;
                        int i11 = i6;
                        bArr2[i9] = (byte) ((pixel >> 16) & InvitationReply.EXPIRED);
                        int i12 = i10 + 1;
                        bArr2[i10] = (byte) ((pixel >> 8) & InvitationReply.EXPIRED);
                        int i13 = i12 + 1;
                        bArr2[i12] = (byte) (pixel & InvitationReply.EXPIRED);
                        i7++;
                        OutputStream outputStream2 = outputStream;
                        i6 = i11;
                        z = z;
                        i8 = i13;
                    }
                }
                boolean z2 = z;
                bArr3[0] = (byte) (bArr2[0] - bArr[0]);
                bArr3[1] = (byte) (bArr2[1] - bArr[1]);
                bArr3[2] = (byte) (bArr2[2] - bArr[2]);
                bArr3[3] = (byte) (bArr2[3] - bArr[3]);
                int i14 = 4;
                while (i14 < width) {
                    int i15 = i14 - 4;
                    byte b2 = bArr2[i15] & 255;
                    byte b3 = bArr[i14] & 255;
                    byte b4 = bArr[i15] & 255;
                    int i16 = (b2 + b3) - b4;
                    int i17 = i16 - b2;
                    if (i17 < 0) {
                        i17 = -i17;
                    }
                    byte[] bArr4 = bArr;
                    int i18 = i16 - b3;
                    if (i18 < 0) {
                        i18 = -i18;
                    }
                    byte b5 = b2;
                    int i19 = i16 - b4;
                    if (i19 < 0) {
                        i19 = -i19;
                    }
                    bArr3[i14] = (byte) (bArr2[i14] - ((i17 > i18 || i17 > i19) ? i18 <= i19 ? b3 : b4 : b5));
                    i14++;
                    bArr = bArr4;
                }
                byte[] bArr5 = bArr;
                deflaterOutputStream.write(4);
                i = 0;
                deflaterOutputStream.write(bArr3, 0, width);
                i5++;
                OutputStream outputStream3 = outputStream;
                bArr = bArr2;
                z = z2;
                bArr2 = bArr5;
                i4 = 1;
            }
            pixels.position(position);
            deflaterOutputStream.finish();
            this.buffer.endChunk(dataOutputStream);
            this.buffer.writeInt(IEND);
            this.buffer.endChunk(dataOutputStream);
            outputStream.flush();
        }
    }

    public static Pixmap readCIM(FileHandle fileHandle) {
        return CIM.read(fileHandle);
    }

    public static void writeCIM(FileHandle fileHandle, Pixmap pixmap) {
        CIM.write(fileHandle, pixmap);
    }

    public static void writePNG(FileHandle fileHandle, Pixmap pixmap, int i, boolean z) {
        PNG png;
        try {
            png = new PNG((int) (((float) (pixmap.getWidth() * pixmap.getHeight())) * 1.5f));
            png.setFlipY(z);
            png.setCompression(i);
            png.write(fileHandle, pixmap);
            png.dispose();
        } catch (IOException e2) {
            throw new GdxRuntimeException("Error writing PNG: " + fileHandle, e2);
        } catch (Throwable th) {
            png.dispose();
            throw th;
        }
    }

    public static void writePNG(FileHandle fileHandle, Pixmap pixmap) {
        writePNG(fileHandle, pixmap, -1, false);
    }
}
