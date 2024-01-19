package com.facebook.imagepipeline.decoder;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser {
    public static final int BUFFER_SIZE = 16384;
    public static final int NOT_A_JPEG = 6;
    public static final int READ_FIRST_JPEG_BYTE = 0;
    public static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    public static final int READ_MARKER_SECOND_BYTE = 3;
    public static final int READ_SECOND_JPEG_BYTE = 1;
    public static final int READ_SIZE_FIRST_BYTE = 4;
    public static final int READ_SIZE_SECOND_BYTE = 5;
    public int mBestScanEndOffset;
    public int mBestScanNumber;
    public final ByteArrayPool mByteArrayPool;
    public int mBytesParsed;
    public boolean mEndMarkerRead;
    public int mLastByteRead;
    public int mNextFullScanNumber;
    public int mParserState;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        if (byteArrayPool != null) {
            this.mByteArrayPool = byteArrayPool;
            this.mBytesParsed = 0;
            this.mLastByteRead = 0;
            this.mNextFullScanNumber = 0;
            this.mBestScanEndOffset = 0;
            this.mBestScanNumber = 0;
            this.mParserState = 0;
            return;
        }
        throw null;
    }

    private boolean doParseMoreData(InputStream inputStream) {
        boolean z;
        int i = this.mBestScanNumber;
        while (true) {
            try {
                z = false;
                if (this.mParserState == 6) {
                    break;
                }
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                this.mBytesParsed = this.mBytesParsed + 1;
                if (this.mEndMarkerRead) {
                    this.mParserState = 6;
                    this.mEndMarkerRead = false;
                    return false;
                }
                int i2 = this.mParserState;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    this.mParserState = 5;
                                } else if (i2 != 5) {
                                    k.checkState(false);
                                } else {
                                    int i3 = ((this.mLastByteRead << 8) + read) - 2;
                                    k.skip(inputStream, (long) i3);
                                    this.mBytesParsed += i3;
                                    this.mParserState = 2;
                                }
                            } else if (read == 255) {
                                this.mParserState = 3;
                            } else if (read == 0) {
                                this.mParserState = 2;
                            } else if (read == 217) {
                                this.mEndMarkerRead = true;
                                newScanOrImageEndFound(r5 - 2);
                                this.mParserState = 2;
                            } else {
                                if (read == 218) {
                                    newScanOrImageEndFound(r5 - 2);
                                }
                                if (doesMarkerStartSegment(read)) {
                                    this.mParserState = 4;
                                } else {
                                    this.mParserState = 2;
                                }
                            }
                        } else if (read == 255) {
                            this.mParserState = 3;
                        }
                    } else if (read == 216) {
                        this.mParserState = 2;
                    } else {
                        this.mParserState = 6;
                    }
                } else if (read == 255) {
                    this.mParserState = 1;
                } else {
                    this.mParserState = 6;
                }
                this.mLastByteRead = read;
            } catch (IOException e2) {
                k.propagateIfPossible(e2);
                throw new RuntimeException(e2);
            }
        }
        if (!(this.mParserState == 6 || this.mBestScanNumber == i)) {
            z = true;
        }
        return z;
    }

    public static boolean doesMarkerStartSegment(int i) {
        boolean z = true;
        if (i == 1) {
            return false;
        }
        if (i >= 208 && i <= 215) {
            return false;
        }
        if (i == 217 || i == 216) {
            z = false;
        }
        return z;
    }

    private void newScanOrImageEndFound(int i) {
        if (this.mNextFullScanNumber > 0) {
            this.mBestScanEndOffset = i;
        }
        int i2 = this.mNextFullScanNumber;
        this.mNextFullScanNumber = i2 + 1;
        this.mBestScanNumber = i2;
    }

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public boolean isEndMarkerRead() {
        return this.mEndMarkerRead;
    }

    public boolean isJpeg() {
        return this.mBytesParsed > 1 && this.mParserState != 6;
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.mParserState == 6 || encodedImage.getSize() <= this.mBytesParsed) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), (byte[]) this.mByteArrayPool.get(16384), this.mByteArrayPool);
        try {
            k.skip(pooledByteArrayBufferedInputStream, (long) this.mBytesParsed);
            boolean doParseMoreData = doParseMoreData(pooledByteArrayBufferedInputStream);
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
            return doParseMoreData;
        } catch (IOException e2) {
            k.propagateIfPossible(e2);
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
            throw th;
        }
    }
}
