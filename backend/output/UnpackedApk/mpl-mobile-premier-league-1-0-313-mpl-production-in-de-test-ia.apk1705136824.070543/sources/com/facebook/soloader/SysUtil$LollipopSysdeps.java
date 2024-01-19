package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

@DoNotOptimize
@TargetApi(21)
public final class SysUtil$LollipopSysdeps {
    @DoNotOptimize
    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
        try {
            Os.posix_fallocate(fileDescriptor, 0, j);
        } catch (ErrnoException e2) {
            int i = e2.errno;
            if (i != OsConstants.EOPNOTSUPP && i != OsConstants.ENOSYS && i != OsConstants.EINVAL) {
                throw new IOException(e2.toString(), e2);
            }
        }
    }

    @DoNotOptimize
    public static String[] getSupportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        TreeSet treeSet = new TreeSet();
        try {
            if (is64Bit()) {
                treeSet.add(MinElf$ISA.AARCH64.toString());
                treeSet.add(MinElf$ISA.X86_64.toString());
            } else {
                treeSet.add(MinElf$ISA.ARM.toString());
                treeSet.add(MinElf$ISA.X86.toString());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (ErrnoException e2) {
            String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[]{Arrays.toString(strArr), Integer.valueOf(e2.errno), e2.getMessage()});
            return Build.SUPPORTED_ABIS;
        }
    }

    @DoNotOptimize
    public static boolean is64Bit() throws ErrnoException {
        return Os.readlink("/proc/self/exe").contains("64");
    }
}
