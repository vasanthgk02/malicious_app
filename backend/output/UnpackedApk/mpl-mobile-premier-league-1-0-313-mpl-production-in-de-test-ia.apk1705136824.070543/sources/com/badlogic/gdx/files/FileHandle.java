package com.badlogic.gdx.files;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileHandle {
    public File file;
    public FileType type;

    public FileHandle() {
    }

    public FileHandle child(String str) {
        if (this.file.getPath().length() == 0) {
            return new FileHandle(new File(str), this.type);
        }
        return new FileHandle(new File(this.file, str), this.type);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof FileHandle)) {
            return false;
        }
        FileHandle fileHandle = (FileHandle) obj;
        if (this.type == fileHandle.type && path().equals(fileHandle.path())) {
            z = true;
        }
        return z;
    }

    public boolean exists() {
        int ordinal = this.type.ordinal();
        boolean z = true;
        if (ordinal != 0) {
            if (ordinal != 1) {
                return file().exists();
            }
            if (file().exists()) {
                return true;
            }
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("/");
        outline73.append(this.file.getPath().replace('\\', '/'));
        if (FileHandle.class.getResource(outline73.toString()) == null) {
            z = false;
        }
        return z;
    }

    public String extension() {
        String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public File file() {
        if (this.type == FileType.External) {
            return new File(k.files.getExternalStoragePath(), this.file.getPath());
        }
        return this.file;
    }

    public int hashCode() {
        return path().hashCode() + ((this.type.hashCode() + 37) * 67);
    }

    public long length() {
        FileType fileType = this.type;
        if (fileType != FileType.Classpath && (fileType != FileType.Internal || this.file.exists())) {
            return file().length();
        }
        InputStream read = read();
        try {
            long available = (long) read.available();
            try {
                read.close();
            } catch (Throwable unused) {
            }
            return available;
        } catch (Exception unused2) {
            if (read != null) {
                read.close();
            }
        } catch (Throwable unused3) {
        }
        return 0;
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[SYNTHETIC, Splitter:B:25:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.ByteBuffer map(java.nio.channels.FileChannel.MapMode r11) {
        /*
            r10 = this;
            com.badlogic.gdx.Files$FileType r0 = r10.type
            com.badlogic.gdx.Files$FileType r1 = com.badlogic.gdx.Files.FileType.Classpath
            if (r0 == r1) goto L_0x0068
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x003b }
            java.io.File r2 = r10.file     // Catch:{ Exception -> 0x003b }
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Exception -> 0x003b }
            if (r11 != r3) goto L_0x0012
            java.lang.String r3 = "r"
            goto L_0x0014
        L_0x0012:
            java.lang.String r3 = "rw"
        L_0x0014:
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x003b }
            java.nio.channels.FileChannel r4 = r1.getChannel()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r6 = 0
            java.io.File r0 = r10.file     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            long r8 = r0.length()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r5 = r11
            java.nio.MappedByteBuffer r11 = r4.map(r5, r6, r8)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r11.order(r0)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r1.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            return r11
        L_0x0033:
            r11 = move-exception
            r0 = r1
            goto L_0x0062
        L_0x0036:
            r11 = move-exception
            r0 = r1
            goto L_0x003c
        L_0x0039:
            r11 = move-exception
            goto L_0x0062
        L_0x003b:
            r11 = move-exception
        L_0x003c:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r2.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = "Error memory mapping file: "
            r2.append(r3)     // Catch:{ all -> 0x0039 }
            r2.append(r10)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = " ("
            r2.append(r3)     // Catch:{ all -> 0x0039 }
            com.badlogic.gdx.Files$FileType r3 = r10.type     // Catch:{ all -> 0x0039 }
            r2.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0039 }
            r1.<init>(r2, r11)     // Catch:{ all -> 0x0039 }
            throw r1     // Catch:{ all -> 0x0039 }
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ all -> 0x0067 }
        L_0x0067:
            throw r11
        L_0x0068:
            com.badlogic.gdx.utils.GdxRuntimeException r11 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot map a classpath file: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.files.FileHandle.map(java.nio.channels.FileChannel$MapMode):java.nio.ByteBuffer");
    }

    public void mkdirs() {
        FileType fileType = this.type;
        if (fileType == FileType.Classpath) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot mkdirs with a classpath file: ");
            outline73.append(this.file);
            throw new GdxRuntimeException(outline73.toString());
        } else if (fileType != FileType.Internal) {
            file().mkdirs();
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Cannot mkdirs with an internal file: ");
            outline732.append(this.file);
            throw new GdxRuntimeException(outline732.toString());
        }
    }

    public String name() {
        return this.file.getName();
    }

    public String nameWithoutExtension() {
        String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring(0, lastIndexOf);
    }

    public FileHandle parent() {
        File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            if (this.type == FileType.Absolute) {
                parentFile = new File("/");
            } else {
                parentFile = new File("");
            }
        }
        return new FileHandle(parentFile, this.type);
    }

    public String path() {
        return this.file.getPath().replace('\\', '/');
    }

    public InputStream read() {
        FileType fileType = this.type;
        if (fileType == FileType.Classpath || ((fileType == FileType.Internal && !file().exists()) || (this.type == FileType.Local && !file().exists()))) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("/");
            outline73.append(this.file.getPath().replace('\\', '/'));
            InputStream resourceAsStream = FileHandle.class.getResourceAsStream(outline73.toString());
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("File not found: ");
            outline732.append(this.file);
            outline732.append(" (");
            outline732.append(this.type);
            outline732.append(")");
            throw new GdxRuntimeException(outline732.toString());
        }
        try {
            return new FileInputStream(file());
        } catch (Exception e2) {
            if (file().isDirectory()) {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Cannot open a stream to a directory: ");
                outline733.append(this.file);
                outline733.append(" (");
                outline733.append(this.type);
                outline733.append(")");
                throw new GdxRuntimeException(outline733.toString(), e2);
            }
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Error reading file: ");
            outline734.append(this.file);
            outline734.append(" (");
            outline734.append(this.type);
            outline734.append(")");
            throw new GdxRuntimeException(outline734.toString(), e2);
        }
    }

    public byte[] readBytes() {
        InputStream read = read();
        try {
            int length = (int) length();
            if (length == 0) {
                length = 512;
            }
            byte[] copyStreamToByteArray = StreamUtils.copyStreamToByteArray(read, length);
            if (read != null) {
                try {
                    read.close();
                } catch (Throwable unused) {
                }
            }
            return copyStreamToByteArray;
        } catch (IOException e2) {
            throw new GdxRuntimeException("Error reading file: " + this, e2);
        } catch (Throwable unused2) {
        }
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053 A[SYNTHETIC, Splitter:B:30:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            long r1 = r5.length()
            int r2 = (int) r1
            if (r2 == 0) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            r2 = 512(0x200, float:7.17E-43)
        L_0x000c:
            r0.<init>(r2)
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039 }
            java.io.InputStream r3 = r5.read()     // Catch:{ IOException -> 0x0039 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0039 }
            r1 = 256(0x100, float:3.59E-43)
            char[] r1 = new char[r1]     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
        L_0x001d:
            int r3 = r2.read(r1)     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
            r4 = -1
            if (r3 != r4) goto L_0x002c
            r2.close()     // Catch:{ all -> 0x0027 }
        L_0x0027:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x002c:
            r4 = 0
            r0.append(r1, r4, r3)     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
            goto L_0x001d
        L_0x0031:
            r0 = move-exception
            r1 = r2
            goto L_0x0051
        L_0x0034:
            r0 = move-exception
            r1 = r2
            goto L_0x003a
        L_0x0037:
            r0 = move-exception
            goto L_0x0051
        L_0x0039:
            r0 = move-exception
        L_0x003a:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = "Error reading layout file: "
            r3.append(r4)     // Catch:{ all -> 0x0037 }
            r3.append(r5)     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0037 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0037 }
            throw r2     // Catch:{ all -> 0x0037 }
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ all -> 0x0056 }
        L_0x0056:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.files.FileHandle.readString():java.lang.String");
    }

    public FileHandle sibling(String str) {
        if (this.file.getPath().length() != 0) {
            return new FileHandle(new File(this.file.getParent(), str), this.type);
        }
        throw new GdxRuntimeException((String) "Cannot get the sibling of the root.");
    }

    public String toString() {
        return this.file.getPath().replace('\\', '/');
    }

    public OutputStream write(boolean z) {
        FileType fileType = this.type;
        if (fileType == FileType.Classpath) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot write to a classpath file: ");
            outline73.append(this.file);
            throw new GdxRuntimeException(outline73.toString());
        } else if (fileType != FileType.Internal) {
            parent().mkdirs();
            try {
                return new FileOutputStream(file(), z);
            } catch (Exception e2) {
                if (file().isDirectory()) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Cannot open a stream to a directory: ");
                    outline732.append(this.file);
                    outline732.append(" (");
                    outline732.append(this.type);
                    outline732.append(")");
                    throw new GdxRuntimeException(outline732.toString(), e2);
                }
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Error writing file: ");
                outline733.append(this.file);
                outline733.append(" (");
                outline733.append(this.type);
                outline733.append(")");
                throw new GdxRuntimeException(outline733.toString(), e2);
            }
        } else {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Cannot write to an internal file: ");
            outline734.append(this.file);
            throw new GdxRuntimeException(outline734.toString());
        }
    }

    public Writer writer(boolean z, String str) {
        FileType fileType = this.type;
        if (fileType == FileType.Classpath) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot write to a classpath file: ");
            outline73.append(this.file);
            throw new GdxRuntimeException(outline73.toString());
        } else if (fileType != FileType.Internal) {
            parent().mkdirs();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file(), z);
                if (str == null) {
                    return new OutputStreamWriter(fileOutputStream);
                }
                return new OutputStreamWriter(fileOutputStream, str);
            } catch (IOException e2) {
                if (file().isDirectory()) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Cannot open a stream to a directory: ");
                    outline732.append(this.file);
                    outline732.append(" (");
                    outline732.append(this.type);
                    outline732.append(")");
                    throw new GdxRuntimeException(outline732.toString(), e2);
                }
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Error writing file: ");
                outline733.append(this.file);
                outline733.append(" (");
                outline733.append(this.type);
                outline733.append(")");
                throw new GdxRuntimeException(outline733.toString(), e2);
            }
        } else {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Cannot write to an internal file: ");
            outline734.append(this.file);
            throw new GdxRuntimeException(outline734.toString());
        }
    }

    public FileHandle(String str, FileType fileType) {
        this.type = fileType;
        this.file = new File(str);
    }

    public FileHandle(File file2, FileType fileType) {
        this.file = file2;
        this.type = fileType;
    }
}
