package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AndroidFileHandle extends FileHandle {
    public final AssetManager assets;

    public AndroidFileHandle(AssetManager assetManager, String str, FileType fileType) {
        super(str.replace('\\', '/'), fileType);
        this.assets = assetManager;
    }

    public FileHandle child(String str) {
        String replace = str.replace('\\', '/');
        if (this.file.getPath().length() == 0) {
            return new AndroidFileHandle(this.assets, new File(replace), this.type);
        }
        return new AndroidFileHandle(this.assets, new File(this.file, replace), this.type);
    }

    public boolean exists() {
        if (this.type != FileType.Internal) {
            return super.exists();
        }
        String path = this.file.getPath();
        boolean z = true;
        try {
            this.assets.open(path).close();
            return true;
        } catch (Exception unused) {
            try {
                if (this.assets.list(path).length <= 0) {
                    z = false;
                }
                return z;
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    public File file() {
        if (this.type == FileType.Local) {
            return new File(k.files.getLocalStoragePath(), this.file.getPath());
        }
        return super.file();
    }

    public AssetFileDescriptor getAssetFileDescriptor() throws IOException {
        AssetManager assetManager = this.assets;
        if (assetManager != null) {
            return assetManager.openFd(path());
        }
        return null;
    }

    public long length() {
        if (this.type == FileType.Internal) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openFd = this.assets.openFd(this.file.getPath());
                long length = openFd.getLength();
                try {
                    openFd.close();
                } catch (IOException unused) {
                }
                return length;
            } catch (IOException unused2) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return super.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[SYNTHETIC, Splitter:B:21:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.ByteBuffer map(java.nio.channels.FileChannel.MapMode r10) {
        /*
            r9 = this;
            com.badlogic.gdx.Files$FileType r0 = r9.type
            com.badlogic.gdx.Files$FileType r1 = com.badlogic.gdx.Files.FileType.Internal
            if (r0 != r1) goto L_0x0065
            r0 = 0
            android.content.res.AssetFileDescriptor r1 = r9.getAssetFileDescriptor()     // Catch:{ Exception -> 0x0038 }
            long r4 = r1.getStartOffset()     // Catch:{ Exception -> 0x0038 }
            long r6 = r1.getDeclaredLength()     // Catch:{ Exception -> 0x0038 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038 }
            java.io.FileDescriptor r1 = r1.getFileDescriptor()     // Catch:{ Exception -> 0x0038 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0038 }
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r3 = r10
            java.nio.MappedByteBuffer r10 = r2.map(r3, r4, r6)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r10.order(r0)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r8.close()     // Catch:{ all -> 0x002f }
        L_0x002f:
            return r10
        L_0x0030:
            r10 = move-exception
            r0 = r8
            goto L_0x005f
        L_0x0033:
            r10 = move-exception
            r0 = r8
            goto L_0x0039
        L_0x0036:
            r10 = move-exception
            goto L_0x005f
        L_0x0038:
            r10 = move-exception
        L_0x0039:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0036 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r2.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "Error memory mapping file: "
            r2.append(r3)     // Catch:{ all -> 0x0036 }
            r2.append(r9)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = " ("
            r2.append(r3)     // Catch:{ all -> 0x0036 }
            com.badlogic.gdx.Files$FileType r3 = r9.type     // Catch:{ all -> 0x0036 }
            r2.append(r3)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0036 }
            r1.<init>(r2, r10)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch:{ all -> 0x0064 }
        L_0x0064:
            throw r10
        L_0x0065:
            java.nio.ByteBuffer r10 = super.map(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.AndroidFileHandle.map(java.nio.channels.FileChannel$MapMode):java.nio.ByteBuffer");
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
        return new AndroidFileHandle(this.assets, parentFile, this.type);
    }

    public InputStream read() {
        if (this.type != FileType.Internal) {
            return super.read();
        }
        try {
            return this.assets.open(this.file.getPath());
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error reading file: ");
            outline73.append(this.file);
            outline73.append(" (");
            outline73.append(this.type);
            outline73.append(")");
            throw new GdxRuntimeException(outline73.toString(), e2);
        }
    }

    public FileHandle sibling(String str) {
        String replace = str.replace('\\', '/');
        if (this.file.getPath().length() != 0) {
            return k.files.getFileHandle(new File(this.file.getParent(), replace).getPath(), this.type);
        }
        throw new GdxRuntimeException((String) "Cannot get the sibling of the root.");
    }

    public AndroidFileHandle(AssetManager assetManager, File file, FileType fileType) {
        super(file, fileType);
        this.assets = assetManager;
    }
}
