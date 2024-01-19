package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.core.widget.CompoundButtonCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MultiDexExtractor implements Closeable {
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r3 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[ExcHandler: Error | RuntimeException (e java.lang.Throwable), Splitter:B:1:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiDexExtractor(java.io.File r3, java.io.File r4) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r3.getPath()
            r4.getPath()
            r2.sourceApk = r3
            r2.dexDir = r4
            long r0 = getZipCrc(r3)
            r2.sourceCrc = r0
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "MultiDex.lock"
            r3.<init>(r4, r0)
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile
            java.lang.String r0 = "rw"
            r4.<init>(r3, r0)
            r2.lockRaf = r4
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x0047, RuntimeException -> 0x0045, Error -> 0x0043 }
            r2.lockChannel = r4     // Catch:{ IOException -> 0x0047, RuntimeException -> 0x0045, Error -> 0x0043 }
            r3.getPath()     // Catch:{ IOException -> 0x003c, RuntimeException -> 0x003a, Error -> 0x0038 }
            java.nio.channels.FileChannel r4 = r2.lockChannel     // Catch:{ IOException -> 0x003c, RuntimeException -> 0x003a, Error -> 0x0038 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ IOException -> 0x003c, RuntimeException -> 0x003a, Error -> 0x0038 }
            r2.cacheLock = r4     // Catch:{ IOException -> 0x003c, RuntimeException -> 0x003a, Error -> 0x0038 }
            r3.getPath()     // Catch:{ IOException -> 0x0047, RuntimeException -> 0x0045, Error -> 0x0043 }
            return
        L_0x0038:
            r3 = move-exception
            goto L_0x003d
        L_0x003a:
            r3 = move-exception
            goto L_0x003d
        L_0x003c:
            r3 = move-exception
        L_0x003d:
            java.nio.channels.FileChannel r4 = r2.lockChannel     // Catch:{ IOException -> 0x0047, RuntimeException -> 0x0045, Error -> 0x0043 }
            r4.close()     // Catch:{ IOException -> 0x0042, RuntimeException -> 0x0045, Error -> 0x0043 }
        L_0x0042:
            throw r3     // Catch:{ IOException -> 0x0047, RuntimeException -> 0x0045, Error -> 0x0043 }
        L_0x0043:
            r3 = move-exception
            goto L_0x0048
        L_0x0045:
            r3 = move-exception
            goto L_0x0048
        L_0x0047:
            r3 = move-exception
        L_0x0048:
            java.io.RandomAccessFile r4 = r2.lockRaf
            r4.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.<init>(java.io.File, java.io.File):void");
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(GeneratedOutlineSupport.outline50("tmp-", str), ".zip", file.getParentFile());
        createTempFile.getPath();
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                file.getPath();
                if (createTempFile.renameTo(file)) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            createTempFile.delete();
            throw th;
        }
    }

    public static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* JADX INFO: finally extract failed */
    public static long getZipCrc(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            ZipUtil$CentralDirectory findCentralDirectory = CompoundButtonCompat.findCentralDirectory(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j = findCentralDirectory.size;
            randomAccessFile.seek(findCentralDirectory.offset);
            byte[] bArr = new byte[16384];
            int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
            while (true) {
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j -= (long) read;
                if (j == 0) {
                    break;
                }
                read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        Editor edit = context.getSharedPreferences("multidex.version", 4).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(GeneratedOutlineSupport.outline62(new StringBuilder(), str, "crc"), j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + "dex.crc." + i, next.crc);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            edit.putLong(GeneratedOutlineSupport.outline61(sb, "dex.time.", i), next.lastModified());
            i++;
        }
        edit.commit();
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005c A[SYNTHETIC, Splitter:B:10:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<? extends java.io.File> load(android.content.Context r15, java.lang.String r16, boolean r17) throws java.io.IOException {
        /*
            r14 = this;
            r0 = r14
            r2 = r16
            java.io.File r1 = r0.sourceApk
            r1.getPath()
            java.nio.channels.FileLock r1 = r0.cacheLock
            boolean r1 = r1.isValid()
            if (r1 == 0) goto L_0x008e
            if (r17 != 0) goto L_0x0075
            java.io.File r1 = r0.sourceApk
            long r3 = r0.sourceCrc
            r5 = 4
            java.lang.String r6 = "multidex.version"
            r7 = r15
            android.content.SharedPreferences r5 = r15.getSharedPreferences(r6, r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r8 = "timestamp"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r8 = -1
            long r10 = r5.getLong(r6, r8)
            long r12 = getTimeStamp(r1)
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r6 = "crc"
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            long r5 = r5.getLong(r1, r8)
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r1 = 0
            goto L_0x005a
        L_0x0059:
            r1 = 1
        L_0x005a:
            if (r1 != 0) goto L_0x0076
            java.util.List r1 = r14.loadExistingExtractions(r15, r16)     // Catch:{ IOException -> 0x0061 }
            goto L_0x008a
        L_0x0061:
            java.util.List r8 = r14.performExtractions()
            java.io.File r1 = r0.sourceApk
            long r3 = getTimeStamp(r1)
            long r5 = r0.sourceCrc
            r1 = r15
            r2 = r16
            r7 = r8
            putStoredApkInfo(r1, r2, r3, r5, r7)
            goto L_0x0089
        L_0x0075:
            r7 = r15
        L_0x0076:
            java.util.List r8 = r14.performExtractions()
            java.io.File r1 = r0.sourceApk
            long r3 = getTimeStamp(r1)
            long r5 = r0.sourceCrc
            r1 = r15
            r2 = r16
            r7 = r8
            putStoredApkInfo(r1, r2, r3, r5, r7)
        L_0x0089:
            r1 = r8
        L_0x008a:
            r1.size()
            return r1
        L_0x008e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "MultiDexExtractor was closed"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.load(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    public final List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        String str3 = this.sourceApk.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i = sharedPreferences.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, GeneratedOutlineSupport.outline42(str3, i2, ".zip"));
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = sharedPreferences.getLong(str2 + "dex.crc." + i2, -1);
                if (sharedPreferences.getLong(str2 + "dex.time." + i2, -1) == extractedDex.lastModified()) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences2 = sharedPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        sharedPreferences = sharedPreferences2;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + r9 + ", modification time: " + r13 + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Missing extracted secondary dex file '");
            outline73.append(extractedDex.getPath());
            outline73.append("'");
            throw new IOException(outline73.toString());
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r7.getAbsolutePath();
        r8 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.multidex.MultiDexExtractor.ExtractedDex> performExtractions() throws java.io.IOException {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r10.sourceApk
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ".classes"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = r10.dexDir
            androidx.multidex.MultiDexExtractor$1 r2 = new androidx.multidex.MultiDexExtractor$1
            r2.<init>()
            java.io.File[] r1 = r1.listFiles(r2)
            r2 = 0
            if (r1 != 0) goto L_0x002b
            java.io.File r1 = r10.dexDir
            r1.getPath()
            goto L_0x0047
        L_0x002b:
            int r3 = r1.length
            r4 = 0
        L_0x002d:
            if (r4 >= r3) goto L_0x0047
            r5 = r1[r4]
            r5.getPath()
            r5.length()
            boolean r6 = r5.delete()
            if (r6 != 0) goto L_0x0041
            r5.getPath()
            goto L_0x0044
        L_0x0041:
            r5.getPath()
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0047:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile
            java.io.File r4 = r10.sourceApk
            r3.<init>(r4)
            r4 = 2
            java.lang.String r5 = "classes2.dex"
            java.util.zip.ZipEntry r5 = r3.getEntry(r5)     // Catch:{ all -> 0x0102 }
        L_0x005a:
            if (r5 == 0) goto L_0x00fe
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r6.<init>()     // Catch:{ all -> 0x0102 }
            r6.append(r0)     // Catch:{ all -> 0x0102 }
            r6.append(r4)     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = ".zip"
            r6.append(r7)     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0102 }
            androidx.multidex.MultiDexExtractor$ExtractedDex r7 = new androidx.multidex.MultiDexExtractor$ExtractedDex     // Catch:{ all -> 0x0102 }
            java.io.File r8 = r10.dexDir     // Catch:{ all -> 0x0102 }
            r7.<init>(r8, r6)     // Catch:{ all -> 0x0102 }
            r1.add(r7)     // Catch:{ all -> 0x0102 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r6.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = "Extraction is needed for file "
            r6.append(r8)     // Catch:{ all -> 0x0102 }
            r6.append(r7)     // Catch:{ all -> 0x0102 }
            r6.toString()     // Catch:{ all -> 0x0102 }
            r6 = 0
            r8 = 0
        L_0x008c:
            r9 = 3
            if (r6 >= r9) goto L_0x00b7
            if (r8 != 0) goto L_0x00b7
            int r6 = r6 + 1
            extract(r3, r5, r7, r0)     // Catch:{ all -> 0x0102 }
            long r8 = getZipCrc(r7)     // Catch:{ IOException -> 0x009e }
            r7.crc = r8     // Catch:{ IOException -> 0x009e }
            r8 = 1
            goto L_0x00a2
        L_0x009e:
            r7.getAbsolutePath()     // Catch:{ all -> 0x0102 }
            r8 = 0
        L_0x00a2:
            r7.getAbsolutePath()     // Catch:{ all -> 0x0102 }
            r7.length()     // Catch:{ all -> 0x0102 }
            if (r8 != 0) goto L_0x008c
            r7.delete()     // Catch:{ all -> 0x0102 }
            boolean r9 = r7.exists()     // Catch:{ all -> 0x0102 }
            if (r9 == 0) goto L_0x008c
            r7.getPath()     // Catch:{ all -> 0x0102 }
            goto L_0x008c
        L_0x00b7:
            if (r8 == 0) goto L_0x00d6
            int r4 = r4 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r5.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = "classes"
            r5.append(r6)     // Catch:{ all -> 0x0102 }
            r5.append(r4)     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = ".dex"
            r5.append(r6)     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0102 }
            java.util.zip.ZipEntry r5 = r3.getEntry(r5)     // Catch:{ all -> 0x0102 }
            goto L_0x005a
        L_0x00d6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0102 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r1.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = "Could not create zip file "
            r1.append(r2)     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = r7.getAbsolutePath()     // Catch:{ all -> 0x0102 }
            r1.append(r2)     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = " for secondary dex ("
            r1.append(r2)     // Catch:{ all -> 0x0102 }
            r1.append(r4)     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0102 }
            r0.<init>(r1)     // Catch:{ all -> 0x0102 }
            throw r0     // Catch:{ all -> 0x0102 }
        L_0x00fe:
            r3.close()     // Catch:{ IOException -> 0x0101 }
        L_0x0101:
            return r1
        L_0x0102:
            r0 = move-exception
            r3.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0106:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.performExtractions():java.util.List");
    }
}
