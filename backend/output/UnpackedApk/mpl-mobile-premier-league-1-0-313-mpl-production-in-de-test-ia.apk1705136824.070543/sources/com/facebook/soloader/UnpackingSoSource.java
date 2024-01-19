package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode.ThreadPolicy;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.io.Closeable;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public abstract class UnpackingSoSource extends DirectorySoSource {
    public final Context mContext;
    public String mCorruptedLib;
    public final Map<String, Object> mLibsBeingLoaded = new HashMap();

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }
    }

    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    public static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    public static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public UnpackingSoSource(Context context, String str) {
        super(new File(GeneratedOutlineSupport.outline63(new StringBuilder(), context.getApplicationInfo().dataDir, "/", str)), 1);
        this.mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeState(java.io.File r3, byte r4) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r0.seek(r1)     // Catch:{ all -> 0x0021 }
            r0.write(r4)     // Catch:{ all -> 0x0021 }
            long r3 = r0.getFilePointer()     // Catch:{ all -> 0x0021 }
            r0.setLength(r3)     // Catch:{ all -> 0x0021 }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ all -> 0x0021 }
            r3.sync()     // Catch:{ all -> 0x0021 }
            r0.close()
            return
        L_0x0021:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.writeState(java.io.File, byte):void");
    }

    public final void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        "deleting unaccounted-for file " + r3;
                        ImageOriginUtils.dumbDeleteRecursive(new File(this.soDirectory, str));
                    }
                }
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unable to list directory ");
        outline73.append(this.soDirectory);
        throw new IOException(outline73.toString());
    }

    public final void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        String str = inputDso.dso.name;
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException unused) {
                "error overwriting " + file + " trying to delete and start over";
                ImageOriginUtils.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                InputStream inputStream = inputDso.content;
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    int read = inputStream.read(bArr, 0, Math.min(bArr.length, Integer.MAX_VALUE - i));
                    if (read == -1) {
                        break;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    i += read;
                }
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    randomAccessFile.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e2) {
                ImageOriginUtils.dumbDeleteRecursive(file);
                throw e2;
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("cannot make directory writable for us: ");
            outline73.append(this.soDirectory);
            throw new IOException(outline73.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getDepsBlock() throws java.io.IOException {
        /*
            r5 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            com.facebook.soloader.UnpackingSoSource$Unpacker r1 = r5.makeUnpacker()
            com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r1.getDsoManifest()     // Catch:{ all -> 0x0036 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r2 = r2.dsos     // Catch:{ all -> 0x0036 }
            r3 = 1
            r0.writeByte(r3)     // Catch:{ all -> 0x0036 }
            int r3 = r2.length     // Catch:{ all -> 0x0036 }
            r0.writeInt(r3)     // Catch:{ all -> 0x0036 }
            r3 = 0
        L_0x0017:
            int r4 = r2.length     // Catch:{ all -> 0x0036 }
            if (r3 >= r4) goto L_0x002b
            r4 = r2[r3]     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x0036 }
            r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            r4 = r2[r3]     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.hash     // Catch:{ all -> 0x0036 }
            r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x002b:
            r1.close()
            byte[] r1 = r0.marshall()
            r0.recycle()
            return r1
        L_0x0036:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r2 = move-exception
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0043:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.getDepsBlock():byte[]");
    }

    public final Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            try {
                obj = this.mLibsBeingLoaded.get(str);
                if (obj == null) {
                    obj = new Object();
                    this.mLibsBeingLoaded.put(str, obj);
                }
            }
        }
        return obj;
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            try {
                loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
            }
        }
        return loadLibraryFrom;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    public void prepare(int i) throws IOException {
        File file = this.soDirectory;
        if (file.mkdirs() || file.isDirectory()) {
            FileLocker fileLocker = new FileLocker(new File(this.soDirectory, "dso_lock"));
            try {
                "locked dso store " + this.soDirectory;
                if (refreshLocked(fileLocker, i, getDepsBlock())) {
                    fileLocker = null;
                } else {
                    "dso store is up-to-date: " + this.soDirectory;
                }
                if (fileLocker == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("not releasing dso store lock for ");
                    outline73.append(this.soDirectory);
                    outline73.append(" (syncer thread started)");
                    outline73.toString();
                }
            } finally {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("releasing dso store lock for ");
                outline732.append(this.soDirectory);
                outline732.toString();
                fileLocker.close();
            }
        } else {
            throw new IOException("cannot mkdir: " + file);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00be, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bf, code lost:
        if (r0 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c5, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c9, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cc, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d2, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d5, code lost:
        throw r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean refreshLocked(com.facebook.soloader.FileLocker r11, int r12, byte[] r13) throws java.io.IOException {
        /*
            r10 = this;
            java.io.File r5 = new java.io.File
            java.io.File r0 = r10.soDirectory
            java.lang.String r1 = "dso_state"
            r5.<init>(r0, r1)
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r5, r1)
            r7 = 1
            r2 = 0
            byte r3 = r0.readByte()     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            if (r3 == r7) goto L_0x003d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            r3.<init>()     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            java.lang.String r4 = "dso store "
            r3.append(r4)     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            java.io.File r4 = r10.soDirectory     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            r3.append(r4)     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            java.lang.String r4 = " regeneration interrupted: wiping clean"
            r3.append(r4)     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            r3.toString()     // Catch:{ EOFException -> 0x003c, all -> 0x0030 }
            goto L_0x003c
        L_0x0030:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r12 = move-exception
            r0.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r13 = move-exception
            r11.addSuppressed(r13)
        L_0x003b:
            throw r12
        L_0x003c:
            r3 = 0
        L_0x003d:
            r0.close()
            java.io.File r4 = new java.io.File
            java.io.File r0 = r10.soDirectory
            java.lang.String r6 = "dso_deps"
            r4.<init>(r0, r6)
            r0 = 0
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile
            r6.<init>(r4, r1)
            long r8 = r6.length()     // Catch:{ all -> 0x00ca }
            int r1 = (int) r8     // Catch:{ all -> 0x00ca }
            byte[] r8 = new byte[r1]     // Catch:{ all -> 0x00ca }
            int r9 = r6.read(r8)     // Catch:{ all -> 0x00ca }
            if (r9 == r1) goto L_0x005d
            r3 = 0
        L_0x005d:
            boolean r1 = java.util.Arrays.equals(r8, r13)     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x0064
            r3 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x006d
            r1 = r12 & 2
            if (r1 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r8 = r0
            goto L_0x0083
        L_0x006d:
            writeState(r5, r2)     // Catch:{ all -> 0x00ca }
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r10.makeUnpacker()     // Catch:{ all -> 0x00ca }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r1 = r0.getDsoManifest()     // Catch:{ all -> 0x00bc }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r8 = r0.openDsoIterator()     // Catch:{ all -> 0x00bc }
            r10.regenerate(r3, r1, r8)     // Catch:{ all -> 0x00b8 }
            r0.close()     // Catch:{ all -> 0x00ca }
            r8 = r1
        L_0x0083:
            r6.close()
            if (r8 != 0) goto L_0x0089
            return r2
        L_0x0089:
            com.facebook.soloader.UnpackingSoSource$1 r9 = new com.facebook.soloader.UnpackingSoSource$1
            r0 = r9
            r1 = r10
            r2 = r4
            r3 = r13
            r4 = r8
            r6 = r11
            r0.<init>(r2, r3, r4, r5, r6)
            r11 = r12 & 1
            if (r11 == 0) goto L_0x00b4
            java.lang.Thread r11 = new java.lang.Thread
            java.lang.String r12 = "SoSync:"
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r12)
            java.io.File r13 = r10.soDirectory
            java.lang.String r13 = r13.getName()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r9, r12)
            r11.start()
            goto L_0x00b7
        L_0x00b4:
            r9.run()
        L_0x00b7:
            return r7
        L_0x00b8:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00be }
        L_0x00be:
            r12 = move-exception
            if (r0 == 0) goto L_0x00c9
            r0.close()     // Catch:{ all -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r13 = move-exception
            r11.addSuppressed(r13)     // Catch:{ all -> 0x00ca }
        L_0x00c9:
            throw r12     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r12 = move-exception
            r6.close()     // Catch:{ all -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r13 = move-exception
            r11.addSuppressed(r13)
        L_0x00d5:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ all -> 0x0080, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void regenerate(byte r9, com.facebook.soloader.UnpackingSoSource.DsoManifest r10, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r11) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.Class r0 = r8.getClass()
            r0.getName()
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.soDirectory
            java.lang.String r2 = "dso_manifest"
            r0.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)
            r0 = 1
            if (r9 != r0) goto L_0x0022
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r1)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0023
        L_0x001f:
            r9 = move-exception
            goto L_0x0098
        L_0x0022:
            r9 = 0
        L_0x0023:
            r2 = 0
            if (r9 != 0) goto L_0x002d
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x001f }
            com.facebook.soloader.UnpackingSoSource$Dso[] r3 = new com.facebook.soloader.UnpackingSoSource.Dso[r2]     // Catch:{ all -> 0x001f }
            r9.<init>(r3)     // Catch:{ all -> 0x001f }
        L_0x002d:
            com.facebook.soloader.UnpackingSoSource$Dso[] r10 = r10.dsos     // Catch:{ all -> 0x001f }
            r8.deleteUnmentionedFiles(r10)     // Catch:{ all -> 0x001f }
            r10 = 32768(0x8000, float:4.5918E-41)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x001f }
        L_0x0037:
            boolean r3 = r11.hasNext()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x008d
            com.facebook.soloader.UnpackingSoSource$InputDso r3 = r11.next()     // Catch:{ all -> 0x001f }
            r4 = 1
            r5 = 0
        L_0x0043:
            if (r4 == 0) goto L_0x0070
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x006e }
            int r6 = r6.length     // Catch:{ all -> 0x006e }
            if (r5 >= r6) goto L_0x0070
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x006e }
            r6 = r6[r5]     // Catch:{ all -> 0x006e }
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x006e }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x006e }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x006e }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x006b
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x006e }
            r6 = r6[r5]     // Catch:{ all -> 0x006e }
            java.lang.String r6 = r6.hash     // Catch:{ all -> 0x006e }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x006e }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x006e }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x006b
            r4 = 0
        L_0x006b:
            int r5 = r5 + 1
            goto L_0x0043
        L_0x006e:
            r9 = move-exception
            goto L_0x0076
        L_0x0070:
            if (r4 == 0) goto L_0x0085
            r8.extractDso(r3, r10)     // Catch:{ all -> 0x006e }
            goto L_0x0085
        L_0x0076:
            throw r9     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r10 = move-exception
            if (r3 == 0) goto L_0x0084
            java.io.InputStream r11 = r3.content     // Catch:{ all -> 0x0080 }
            r11.close()     // Catch:{ all -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r11 = move-exception
            r9.addSuppressed(r11)     // Catch:{ all -> 0x001f }
        L_0x0084:
            throw r10     // Catch:{ all -> 0x001f }
        L_0x0085:
            if (r3 == 0) goto L_0x0037
            java.io.InputStream r3 = r3.content     // Catch:{ all -> 0x001f }
            r3.close()     // Catch:{ all -> 0x001f }
            goto L_0x0037
        L_0x008d:
            r1.close()
            java.lang.Class r9 = r8.getClass()
            r9.getName()
            return
        L_0x0098:
            throw r9     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r10 = move-exception
            r1.close()     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r11 = move-exception
            r9.addSuppressed(r11)
        L_0x00a2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }
}
