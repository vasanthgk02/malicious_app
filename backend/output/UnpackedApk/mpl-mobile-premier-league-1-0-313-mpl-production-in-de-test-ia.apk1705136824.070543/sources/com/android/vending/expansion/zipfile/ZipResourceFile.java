package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import sfs2x.client.entities.invitation.InvitationReply;

public class ZipResourceFile {
    public HashMap<String, ZipEntryRO> mHashMap = new HashMap<>();

    public static final class ZipEntryRO {
        public long mCRC32;
        public long mCompressedLength;
        public final File mFile;
        public final String mFileName;
        public long mLocalHdrOffset;
        public int mMethod;
        public long mOffset = -1;
        public long mUncompressedLength;
        public long mWhenModified;
        public final String mZipFileName;

        public ZipEntryRO(String str, File file, String str2) {
            this.mFileName = str2;
            this.mZipFileName = str;
            this.mFile = file;
        }
    }

    public ZipResourceFile(String str) throws IOException {
        new HashMap();
        ByteBuffer.allocate(4);
        addPatchFile(str);
    }

    public void addPatchFile(String str) throws IOException {
        int i;
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j = 65557;
            if (65557 > length) {
                j = length;
            }
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int i2 = ((readInt & InvitationReply.EXPIRED) << 24) + ((65280 & readInt) << 8) + ((16711680 & readInt) >>> 8) + ((readInt >>> 24) & InvitationReply.EXPIRED);
            if (i2 == 101010256) {
                throw new IOException();
            } else if (i2 == 67324752) {
                randomAccessFile.seek(length - j);
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                }
                short s = allocate.getShort(length2 + 8);
                long j2 = 4294967295L;
                long j3 = ((long) allocate.getInt(length2 + 12)) & 4294967295L;
                long j4 = ((long) allocate.getInt(length2 + 16)) & 4294967295L;
                if (j4 + j3 > length) {
                    throw new IOException();
                } else if (s != 0) {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(MapMode.READ_ONLY, j4, j3);
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    short s2 = 65535;
                    byte[] bArr = new byte[65535];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < s) {
                        if (map.getInt(i5) == 33639248) {
                            short s3 = map.getShort(i5 + 28) & s2;
                            short s4 = map.getShort(i5 + 30) & s2;
                            short s5 = map.getShort(i5 + 32) & s2;
                            map.position(i5 + 46);
                            map.get(bArr, i3, s3);
                            map.position(i3);
                            String str3 = new String(bArr, i3, s3);
                            ZipEntryRO zipEntryRO = new ZipEntryRO(str2, file, str3);
                            zipEntryRO.mMethod = map.getShort(i5 + 10) & s2;
                            byte[] bArr2 = bArr;
                            zipEntryRO.mWhenModified = ((long) map.getInt(i5 + 12)) & j2;
                            zipEntryRO.mCRC32 = map.getLong(i5 + 16) & j2;
                            zipEntryRO.mCompressedLength = map.getLong(i5 + 20) & j2;
                            zipEntryRO.mUncompressedLength = map.getLong(i5 + 24) & j2;
                            zipEntryRO.mLocalHdrOffset = ((long) map.getInt(i5 + 42)) & j2;
                            allocate2.clear();
                            long j5 = zipEntryRO.mLocalHdrOffset;
                            try {
                                randomAccessFile.seek(j5);
                                randomAccessFile.readFully(allocate2.array());
                                if (allocate2.getInt(0) == 67324752) {
                                    try {
                                        i = i5;
                                        try {
                                            zipEntryRO.mOffset = j5 + 30 + ((long) (allocate2.getShort(26) & 65535)) + ((long) (allocate2.getShort(28) & 65535));
                                        } catch (FileNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            this.mHashMap.put(str3, zipEntryRO);
                                            i5 = s3 + 46 + s4 + s5 + i;
                                            i4++;
                                            bArr = bArr2;
                                            s2 = 65535;
                                            i3 = 0;
                                            j2 = 4294967295L;
                                        } catch (IOException e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            this.mHashMap.put(str3, zipEntryRO);
                                            i5 = s3 + 46 + s4 + s5 + i;
                                            i4++;
                                            bArr = bArr2;
                                            s2 = 65535;
                                            i3 = 0;
                                            j2 = 4294967295L;
                                        }
                                    } catch (FileNotFoundException e4) {
                                        e = e4;
                                        i = i5;
                                        e.printStackTrace();
                                        this.mHashMap.put(str3, zipEntryRO);
                                        i5 = s3 + 46 + s4 + s5 + i;
                                        i4++;
                                        bArr = bArr2;
                                        s2 = 65535;
                                        i3 = 0;
                                        j2 = 4294967295L;
                                    } catch (IOException e5) {
                                        e = e5;
                                        i = i5;
                                        e.printStackTrace();
                                        this.mHashMap.put(str3, zipEntryRO);
                                        i5 = s3 + 46 + s4 + s5 + i;
                                        i4++;
                                        bArr = bArr2;
                                        s2 = 65535;
                                        i3 = 0;
                                        j2 = 4294967295L;
                                    }
                                    this.mHashMap.put(str3, zipEntryRO);
                                    i5 = s3 + 46 + s4 + s5 + i;
                                    i4++;
                                    bArr = bArr2;
                                    s2 = 65535;
                                    i3 = 0;
                                    j2 = 4294967295L;
                                } else {
                                    int i6 = i5;
                                    throw new IOException();
                                }
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                i = i5;
                                e.printStackTrace();
                                this.mHashMap.put(str3, zipEntryRO);
                                i5 = s3 + 46 + s4 + s5 + i;
                                i4++;
                                bArr = bArr2;
                                s2 = 65535;
                                i3 = 0;
                                j2 = 4294967295L;
                            } catch (IOException e7) {
                                e = e7;
                                i = i5;
                                e.printStackTrace();
                                this.mHashMap.put(str3, zipEntryRO);
                                i5 = s3 + 46 + s4 + s5 + i;
                                i4++;
                                bArr = bArr2;
                                s2 = 65535;
                                i3 = 0;
                                j2 = 4294967295L;
                            }
                        } else {
                            throw new IOException();
                        }
                    }
                } else {
                    throw new IOException();
                }
            } else {
                throw new IOException();
            }
        } else {
            throw new IOException();
        }
    }

    public AssetFileDescriptor getAssetFileDescriptor(String str) {
        ZipEntryRO zipEntryRO = this.mHashMap.get(str);
        if (zipEntryRO == null || zipEntryRO.mMethod != 0) {
            return null;
        }
        try {
            AssetFileDescriptor assetFileDescriptor = new AssetFileDescriptor(ParcelFileDescriptor.open(zipEntryRO.mFile, ClientDefaults.MAX_MSG_SIZE), zipEntryRO.mOffset, zipEntryRO.mUncompressedLength);
            return assetFileDescriptor;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
