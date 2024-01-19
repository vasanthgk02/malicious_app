package org.apache.pdfbox.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.javax.imageio.stream.MemoryCacheImageInputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import sfs2x.client.entities.invitation.InvitationReply;

public class LZWFilter extends Filter {
    public static final long CLEAR_TABLE = 256;
    public static final long EOD = 257;

    public static int calculateChunk(int i, int i2) {
        if (i >= 2048 - i2) {
            return 12;
        }
        if (i >= 1024 - i2) {
            return 11;
        }
        return i >= 512 - i2 ? 10 : 9;
    }

    public static List<byte[]> createCodeTable() {
        ArrayList arrayList = new ArrayList(4096);
        for (int i = 0; i < 256; i++) {
            arrayList.add(new byte[]{(byte) (i & InvitationReply.EXPIRED)});
        }
        arrayList.add(null);
        arrayList.add(null);
        return arrayList;
    }

    public static void doLZWDecode(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        List arrayList = new ArrayList();
        MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(inputStream);
        loop0:
        while (true) {
            long j = -1;
            int i2 = 9;
            while (true) {
                try {
                    long readBits = memoryCacheImageInputStream.readBits(i2);
                    if (readBits == 257) {
                        break loop0;
                    } else if (readBits == 256) {
                        break;
                    } else {
                        if (readBits < ((long) arrayList.size())) {
                            byte[] bArr = (byte[]) arrayList.get((int) readBits);
                            byte b2 = bArr[0];
                            outputStream.write(bArr);
                            if (j != -1) {
                                byte[] bArr2 = (byte[]) arrayList.get((int) j);
                                byte[] copyOf = Arrays.copyOf(bArr2, bArr2.length + 1);
                                copyOf[bArr2.length] = b2;
                                arrayList.add(copyOf);
                            }
                        } else {
                            byte[] bArr3 = (byte[]) arrayList.get((int) j);
                            byte[] copyOf2 = Arrays.copyOf(bArr3, bArr3.length + 1);
                            copyOf2[bArr3.length] = bArr3[0];
                            outputStream.write(copyOf2);
                            arrayList.add(copyOf2);
                        }
                        i2 = calculateChunk(arrayList.size(), i);
                        j = readBits;
                    }
                } catch (EOFException unused) {
                }
            }
            arrayList = createCodeTable();
        }
        outputStream.flush();
    }

    public static int findPatternCode(List<byte[]> list, byte[] bArr) {
        int i = 0;
        int i2 = -1;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((long) size) <= 257) {
                if (i2 != -1) {
                    return i2;
                }
                if (bArr.length > 1) {
                    return -1;
                }
            }
            byte[] bArr2 = list.get(size);
            if ((i2 != -1 || bArr2.length > i) && Arrays.equals(bArr2, bArr)) {
                i = bArr2.length;
                i2 = size;
            }
        }
        return i2;
    }

    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        int i2;
        int i3;
        COSDictionary decodeParams = Filter.getDecodeParams(cOSDictionary, i);
        if (decodeParams != null) {
            int i4 = decodeParams.getInt(COSName.PREDICTOR);
            int i5 = decodeParams.getInt(COSName.EARLY_CHANGE, 1);
            if (i5 == 0 || i5 == 1) {
                int i6 = i5;
                i2 = i4;
                i3 = i6;
            } else {
                i2 = i4;
                i3 = 1;
            }
        } else {
            i3 = 1;
            i2 = -1;
        }
        if (i2 > 1) {
            int min = Math.min(decodeParams.getInt(COSName.COLORS, 1), 32);
            int i7 = decodeParams.getInt(COSName.BITS_PER_COMPONENT, 8);
            int i8 = decodeParams.getInt(COSName.COLUMNS, 1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doLZWDecode(inputStream, byteArrayOutputStream, i3);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            Predictor.decodePredictor(i2, min, i7, i8, byteArrayInputStream, outputStream);
            outputStream.flush();
            byteArrayOutputStream.reset();
            byteArrayInputStream.reset();
        } else {
            doLZWDecode(inputStream, outputStream, i3);
        }
        return new DecodeResult(cOSDictionary);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [int] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r8v4, types: [int] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v2
      assigns: []
      uses: []
      mth insns count: 47
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(java.io.InputStream r12, java.io.OutputStream r13, org.apache.pdfbox.cos.COSDictionary r14) throws java.io.IOException {
        /*
            r11 = this;
            java.util.List r14 = createCodeTable()
            org.apache.javax.imageio.stream.MemoryCacheImageOutputStream r0 = new org.apache.javax.imageio.stream.MemoryCacheImageOutputStream
            r0.<init>(r13)
            r1 = 256(0x100, double:1.265E-321)
            r13 = 9
            r0.writeBits(r1, r13)
            r13 = -1
            r3 = 0
            r4 = -1
        L_0x0013:
            int r5 = r12.read()
            r6 = 1
            if (r5 == r13) goto L_0x005b
            byte r5 = (byte) r5
            r7 = 0
            if (r3 != 0) goto L_0x0025
            byte[] r3 = new byte[r6]
            r3[r7] = r5
        L_0x0022:
            r4 = r5 & 255(0xff, float:3.57E-43)
            goto L_0x0013
        L_0x0025:
            int r8 = r3.length
            int r8 = r8 + r6
            byte[] r3 = java.util.Arrays.copyOf(r3, r8)
            int r8 = r3.length
            int r8 = r8 - r6
            r3[r8] = r5
            int r8 = findPatternCode(r14, r3)
            if (r8 != r13) goto L_0x0059
            int r8 = r14.size()
            int r8 = r8 - r6
            int r8 = calculateChunk(r8, r6)
            long r9 = (long) r4
            r0.writeBits(r9, r8)
            r14.add(r3)
            int r3 = r14.size()
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != r4) goto L_0x0054
            r0.writeBits(r1, r8)
            java.util.List r14 = createCodeTable()
        L_0x0054:
            byte[] r3 = new byte[r6]
            r3[r7] = r5
            goto L_0x0022
        L_0x0059:
            r4 = r8
            goto L_0x0013
        L_0x005b:
            if (r4 == r13) goto L_0x006a
            int r12 = r14.size()
            int r12 = r12 - r6
            int r12 = calculateChunk(r12, r6)
            long r1 = (long) r4
            r0.writeBits(r1, r12)
        L_0x006a:
            int r12 = r14.size()
            int r12 = calculateChunk(r12, r6)
            r13 = 257(0x101, double:1.27E-321)
            r0.writeBits(r13, r12)
            r12 = 0
            r14 = 7
            r0.writeBits(r12, r14)
            r0.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.filter.LZWFilter.encode(java.io.InputStream, java.io.OutputStream, org.apache.pdfbox.cos.COSDictionary):void");
    }
}
