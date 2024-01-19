package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import android.os.Trace;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.soloader.SoLoader.AnonymousClass1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMapParser;

public class DirectorySoSource extends SoSource {
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    public int loadLibraryFrom(String str, int i, File file, ThreadPolicy threadPolicy) throws IOException {
        FileInputStream fileInputStream;
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file.getCanonicalPath();
            return 0;
        }
        file.getCanonicalPath();
        if ((i & 1) != 0 && (this.flags & 2) != 0) {
            return 2;
        }
        if ((this.flags & 1) != 0) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", file2.getName(), CMapParser.MARK_END_OF_ARRAY);
            }
            try {
                fileInputStream = new FileInputStream(file2);
                String[] extract_DT_NEEDED = ImageOriginUtils.extract_DT_NEEDED(fileInputStream.getChannel());
                fileInputStream.close();
                if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    Trace.endSection();
                }
                Arrays.toString(extract_DT_NEEDED);
                for (String str2 : extract_DT_NEEDED) {
                    if (!str2.startsWith("/")) {
                        SoLoader.loadLibraryBySoNameImpl(str2, null, null, i | 1, threadPolicy);
                    }
                }
            } catch (Throwable th) {
                if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    Trace.endSection();
                }
                throw th;
            }
        }
        try {
            ((AnonymousClass1) SoLoader.sSoFileLoader).load(file2.getAbsolutePath(), i);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (e2.getMessage().contains("bad ELF magic")) {
                return 3;
            }
            throw e2;
        }
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[root = ");
        sb.append(str);
        sb.append(" flags = ");
        return GeneratedOutlineSupport.outline56(sb, this.flags, ']');
    }

    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
