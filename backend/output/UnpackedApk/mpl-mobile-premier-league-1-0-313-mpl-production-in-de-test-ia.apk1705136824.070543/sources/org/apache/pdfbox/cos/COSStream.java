package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.filter.DecodeResult;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.FilterFactory;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccess;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessFileInputStream;
import org.apache.pdfbox.io.RandomAccessFileOutputStream;

public class COSStream extends COSDictionary implements Closeable {
    public static final int BUFFER_SIZE = 16384;
    public final RandomAccess buffer;
    public DecodeResult decodeResult;
    public RandomAccessFileOutputStream filteredStream;
    public File scratchFile;
    public RandomAccessFileOutputStream unFilteredStream;

    public COSStream() {
        this(false, null);
    }

    private void attemptDecode(long j, long j2, Filter filter, int i) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            RandomAccessFileInputStream randomAccessFileInputStream = new RandomAccessFileInputStream(this.buffer, j, j2);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(randomAccessFileInputStream, 16384);
            try {
                IOUtils.closeQuietly(this.unFilteredStream);
                RandomAccessFileOutputStream randomAccessFileOutputStream = new RandomAccessFileOutputStream(this.buffer);
                this.unFilteredStream = randomAccessFileOutputStream;
                this.decodeResult = filter.decode(bufferedInputStream2, randomAccessFileOutputStream, this, i);
                IOUtils.closeQuietly(bufferedInputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                IOUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    private RandomAccess createScratchFile(File file) {
        try {
            File createTempFile = File.createTempFile("PDFBox", null, file);
            this.scratchFile = createTempFile;
            return new RandomAccessFile(createTempFile, "rw");
        } catch (IOException unused) {
            return new RandomAccessBuffer();
        }
    }

    private void doDecode() throws IOException {
        this.unFilteredStream = this.filteredStream;
        COSBase filters = getFilters();
        if (filters == null) {
            this.decodeResult = DecodeResult.DEFAULT;
            return;
        }
        if (filters instanceof COSName) {
            doDecode((COSName) filters, 0);
        } else if (filters instanceof COSArray) {
            COSArray cOSArray = (COSArray) filters;
            for (int i = 0; i < cOSArray.size(); i++) {
                doDecode((COSName) cOSArray.get(i), i);
            }
        } else {
            throw new IOException("Error: Unknown filter type:" + filters);
        }
    }

    private void doEncode() throws IOException {
        this.filteredStream = this.unFilteredStream;
        COSBase filters = getFilters();
        if (filters != null) {
            if (filters instanceof COSName) {
                doEncode((COSName) filters, 0);
            } else if (filters instanceof COSArray) {
                COSArray cOSArray = (COSArray) filters;
                for (int size = cOSArray.size() - 1; size >= 0; size--) {
                    doEncode((COSName) cOSArray.get(size), size);
                }
            }
        }
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromStream(this);
    }

    public void close() throws IOException {
        RandomAccess randomAccess = this.buffer;
        if (randomAccess != null) {
            randomAccess.close();
        }
        RandomAccessFileOutputStream randomAccessFileOutputStream = this.filteredStream;
        if (randomAccessFileOutputStream != null) {
            randomAccessFileOutputStream.close();
        }
        RandomAccessFileOutputStream randomAccessFileOutputStream2 = this.unFilteredStream;
        if (randomAccessFileOutputStream2 != null) {
            randomAccessFileOutputStream2.close();
        }
        File file = this.scratchFile;
        if (file != null && file.exists() && !this.scratchFile.delete()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't delete the temporary scratch file ");
            outline73.append(this.scratchFile.getAbsolutePath());
            throw new IOException(outline73.toString());
        }
    }

    public OutputStream createFilteredStream() throws IOException {
        IOUtils.closeQuietly(this.unFilteredStream);
        this.unFilteredStream = null;
        IOUtils.closeQuietly(this.filteredStream);
        this.filteredStream = new RandomAccessFileOutputStream(this.buffer);
        return new BufferedOutputStream(this.filteredStream, 16384);
    }

    public OutputStream createUnfilteredStream() throws IOException {
        IOUtils.closeQuietly(this.filteredStream);
        this.filteredStream = null;
        IOUtils.closeQuietly(this.unFilteredStream);
        this.unFilteredStream = new RandomAccessFileOutputStream(this.buffer);
        return new BufferedOutputStream(this.unFilteredStream, 16384);
    }

    public DecodeResult getDecodeResult() throws IOException {
        if (this.unFilteredStream == null) {
            doDecode();
        }
        if (this.unFilteredStream != null) {
            DecodeResult decodeResult2 = this.decodeResult;
            if (decodeResult2 != null) {
                return decodeResult2;
            }
        }
        StringBuilder sb = new StringBuilder();
        COSBase filters = getFilters();
        if (filters != null) {
            sb.append(" - filter: ");
            if (filters instanceof COSName) {
                sb.append(((COSName) filters).getName());
            } else if (filters instanceof COSArray) {
                COSArray cOSArray = (COSArray) filters;
                for (int i = 0; i < cOSArray.size(); i++) {
                    if (cOSArray.size() > 1) {
                        sb.append(", ");
                    }
                    sb.append(((COSName) cOSArray.get(i)).getName());
                }
            }
        }
        String nameAsString = getNameAsString(COSName.SUBTYPE);
        throw new IOException(nameAsString + " stream was not read" + sb);
    }

    public long getFilteredLength() throws IOException {
        if (this.filteredStream == null) {
            doEncode();
        }
        return this.filteredStream.getLength();
    }

    public InputStream getFilteredStream() throws IOException {
        if (!this.buffer.isClosed()) {
            if (this.filteredStream == null) {
                doEncode();
            }
            RandomAccessFileInputStream randomAccessFileInputStream = new RandomAccessFileInputStream(this.buffer, this.filteredStream.getPosition(), this.filteredStream.getLengthWritten());
            return new BufferedInputStream(randomAccessFileInputStream, 16384);
        }
        throw new IOException("COSStream has been closed and cannot be read. Perhaps its enclosing PDDocument has been closed?");
    }

    public COSBase getFilters() {
        return getDictionaryObject(COSName.FILTER);
    }

    public InputStream getUnfilteredStream() throws IOException {
        if (!this.buffer.isClosed()) {
            if (this.unFilteredStream == null) {
                doDecode();
            }
            RandomAccessFileOutputStream randomAccessFileOutputStream = this.unFilteredStream;
            if (randomAccessFileOutputStream == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            RandomAccessFileInputStream randomAccessFileInputStream = new RandomAccessFileInputStream(this.buffer, randomAccessFileOutputStream.getPosition(), this.unFilteredStream.getLengthWritten());
            return new BufferedInputStream(randomAccessFileInputStream, 16384);
        }
        throw new IOException("COSStream has been closed and cannot be read. Perhaps its enclosing PDDocument has been closed?");
    }

    public void setFilters(COSBase cOSBase) throws IOException {
        if (this.unFilteredStream == null) {
            doDecode();
        }
        setItem(COSName.FILTER, cOSBase);
        IOUtils.closeQuietly(this.filteredStream);
        this.filteredStream = null;
    }

    public COSStream(COSDictionary cOSDictionary) {
        this(cOSDictionary, false, null);
    }

    public COSStream(boolean z, File file) {
        if (z) {
            this.buffer = createScratchFile(file);
        } else {
            this.buffer = new RandomAccessBuffer();
        }
    }

    public COSStream(COSDictionary cOSDictionary, boolean z, File file) {
        super(cOSDictionary);
        if (z) {
            this.buffer = createScratchFile(file);
        } else {
            this.buffer = new RandomAccessBuffer();
        }
    }

    public OutputStream createFilteredStream(COSBase cOSBase) throws IOException {
        OutputStream createFilteredStream = createFilteredStream();
        this.filteredStream.setExpectedLength(cOSBase);
        return createFilteredStream;
    }

    private void doEncode(COSName cOSName, int i) throws IOException {
        Filter filter = FilterFactory.INSTANCE.getFilter(cOSName);
        RandomAccessFileInputStream randomAccessFileInputStream = new RandomAccessFileInputStream(this.buffer, this.filteredStream.getPosition(), this.filteredStream.getLength());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(randomAccessFileInputStream, 16384);
        IOUtils.closeQuietly(this.filteredStream);
        RandomAccessFileOutputStream randomAccessFileOutputStream = new RandomAccessFileOutputStream(this.buffer);
        this.filteredStream = randomAccessFileOutputStream;
        filter.encode(bufferedInputStream, randomAccessFileOutputStream, this, i);
        IOUtils.closeQuietly(bufferedInputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doDecode(org.apache.pdfbox.cos.COSName r25, int r26) throws java.io.IOException {
        /*
            r24 = this;
            r8 = r24
            org.apache.pdfbox.filter.FilterFactory r0 = org.apache.pdfbox.filter.FilterFactory.INSTANCE
            r1 = r25
            org.apache.pdfbox.filter.Filter r9 = r0.getFilter(r1)
            org.apache.pdfbox.io.RandomAccessFileOutputStream r0 = r8.unFilteredStream
            long r10 = r0.getPosition()
            org.apache.pdfbox.io.RandomAccessFileOutputStream r0 = r8.unFilteredStream
            long r0 = r0.getLength()
            org.apache.pdfbox.io.RandomAccessFileOutputStream r2 = r8.unFilteredStream
            long r12 = r2.getLengthWritten()
            r14 = 0
            r16 = 1
            r2 = 0
            int r3 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x0038
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x0038
            org.apache.pdfbox.io.RandomAccessFileOutputStream r0 = r8.unFilteredStream
            org.apache.pdfbox.io.IOUtils.closeQuietly(r0)
            org.apache.pdfbox.io.RandomAccessFileOutputStream r0 = new org.apache.pdfbox.io.RandomAccessFileOutputStream
            org.apache.pdfbox.io.RandomAccess r1 = r8.buffer
            r0.<init>(r1)
            r8.unFilteredStream = r0
            goto L_0x0080
        L_0x0038:
            r17 = 0
            r18 = r0
            r0 = r2
            r7 = 0
            r20 = 0
        L_0x0040:
            r21 = 1
            r6 = 5
            int r1 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x0061
            if (r20 != 0) goto L_0x0061
            if (r7 >= r6) goto L_0x0061
            r1 = r24
            r2 = r10
            r4 = r18
            r6 = r9
            r23 = r7
            r7 = r26
            r1.attemptDecode(r2, r4, r6, r7)     // Catch:{ IOException -> 0x005b }
            r20 = 1
            goto L_0x005e
        L_0x005b:
            r0 = move-exception
            long r18 = r18 - r21
        L_0x005e:
            int r7 = r23 + 1
            goto L_0x0040
        L_0x0061:
            if (r20 != 0) goto L_0x007d
            r14 = 0
        L_0x0064:
            if (r20 != 0) goto L_0x007d
            if (r14 >= r6) goto L_0x007d
            r1 = r24
            r2 = r10
            r4 = r12
            r15 = 5
            r6 = r9
            r7 = r26
            r1.attemptDecode(r2, r4, r6, r7)     // Catch:{ IOException -> 0x0076 }
            r20 = 1
            goto L_0x0079
        L_0x0076:
            r0 = move-exception
            long r12 = r12 - r21
        L_0x0079:
            int r14 = r14 + 1
            r6 = 5
            goto L_0x0064
        L_0x007d:
            r2 = r0
            r16 = r20
        L_0x0080:
            if (r16 != 0) goto L_0x0086
            if (r2 != 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            throw r2
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.cos.COSStream.doDecode(org.apache.pdfbox.cos.COSName, int):void");
    }
}
