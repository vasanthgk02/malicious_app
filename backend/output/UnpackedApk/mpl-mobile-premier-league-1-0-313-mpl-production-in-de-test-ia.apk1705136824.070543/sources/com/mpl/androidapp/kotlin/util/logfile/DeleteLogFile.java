package com.mpl.androidapp.kotlin.util.logfile;

import com.mpl.androidapp.MPLApplication;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/kotlin/util/logfile/DeleteLogFile;", "", "()V", "deleteFiles", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeleteLogFile.kt */
public final class DeleteLogFile {
    public static final DeleteLogFile INSTANCE = new DeleteLogFile();

    public static final void deleteFiles() {
        File file = new File(MPLApplication.getInstance().getFilesDir(), "MPL_log");
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            try {
                Intrinsics.checkNotNullExpressionValue(listFiles, "files");
                int i = 0;
                if ((!(listFiles.length == 0)) && listFiles.length > 10) {
                    Arrays.sort(listFiles, $$Lambda$tShvCNqUxozl7UMOve_uTXhXebY.INSTANCE);
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        int i3 = i2 + 1;
                        if (i2 >= 10) {
                            file2.delete();
                        }
                        i++;
                        i2 = i3;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: deleteFiles$lambda-1$lambda-0  reason: not valid java name */
    public static final int m12deleteFiles$lambda1$lambda0(File file, File file2) {
        String name = file2.getName();
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "f1.name");
        return name.compareTo(name2);
    }
}
