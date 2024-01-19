package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public final class MultiDex {
    public static final boolean IS_VM_MULTIDEX_CAPABLE;
    public static final Set<File> installedApk = new HashSet();

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            String str = null;
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreTokens()) {
                str = stringTokenizer.nextToken();
            }
            if (!(nextToken == null || str == null)) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(str);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        IS_VM_MULTIDEX_CAPABLE = z;
    }

    public static void access$100(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    public static Method access$200(Object obj, String str, Class[] clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("Method ", str, " with parameters ");
        outline80.append(Arrays.asList(clsArr));
        outline80.append(" not found in ");
        outline80.append(obj.getClass());
        throw new NoSuchMethodException(outline80.toString());
    }

    public static void clearOldDexDir(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            file.getPath();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.getPath();
                return;
            }
            for (File file2 : listFiles) {
                file2.getPath();
                file2.length();
                if (!file2.delete()) {
                    file2.getPath();
                } else {
                    file2.getPath();
                }
            }
            if (!file.delete()) {
                file.getPath();
            } else {
                file.getPath();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0024 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0026 A[SYNTHETIC, Splitter:B:20:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0068 A[SYNTHETIC, Splitter:B:43:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doInstallation(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = installedApk
            monitor-enter(r0)
            java.util.Set<java.io.File> r1 = installedApk     // Catch:{ all -> 0x0071 }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x000d:
            java.util.Set<java.io.File> r1 = installedApk     // Catch:{ all -> 0x0071 }
            r1.add(r6)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "java.vm.version"
            java.lang.System.getProperty(r1)     // Catch:{ all -> 0x0071 }
            r1 = 0
            java.lang.ClassLoader r2 = r5.getClassLoader()     // Catch:{ RuntimeException -> 0x0021 }
            boolean r3 = r2 instanceof dalvik.system.BaseDexClassLoader     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r2 = r1
        L_0x0022:
            if (r2 != 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x0026:
            clearOldDexDir(r5)     // Catch:{ all -> 0x0029 }
        L_0x0029:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = "code_cache"
            r3.<init>(r7, r4)     // Catch:{ all -> 0x0071 }
            mkdirChecked(r3)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0040
        L_0x0034:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0071 }
            java.io.File r7 = r5.getFilesDir()     // Catch:{ all -> 0x0071 }
            r3.<init>(r7, r4)     // Catch:{ all -> 0x0071 }
            mkdirChecked(r3)     // Catch:{ all -> 0x0071 }
        L_0x0040:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0071 }
            r7.<init>(r3, r8)     // Catch:{ all -> 0x0071 }
            mkdirChecked(r7)     // Catch:{ all -> 0x0071 }
            androidx.multidex.MultiDexExtractor r8 = new androidx.multidex.MultiDexExtractor     // Catch:{ all -> 0x0071 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0071 }
            r6 = 0
            java.util.List r6 = r8.load(r5, r9, r6)     // Catch:{ all -> 0x006c }
            installSecondaryDexes(r2, r7, r6)     // Catch:{ IOException -> 0x0056 }
            goto L_0x0061
        L_0x0056:
            r6 = move-exception
            if (r10 == 0) goto L_0x006b
            r6 = 1
            java.util.List r5 = r8.load(r5, r9, r6)     // Catch:{ all -> 0x006c }
            installSecondaryDexes(r2, r7, r5)     // Catch:{ all -> 0x006c }
        L_0x0061:
            r8.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0066
        L_0x0065:
            r1 = move-exception
        L_0x0066:
            if (r1 != 0) goto L_0x006a
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x006a:
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x006b:
            throw r6     // Catch:{ all -> 0x006c }
        L_0x006c:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            throw r5     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.doInstallation(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("Field ", str, " not found in ");
        outline80.append(obj.getClass());
        throw new NoSuchFieldException(outline80.toString());
    }

    public static void install(Context context) {
        ApplicationInfo applicationInfo;
        if (!IS_VM_MULTIDEX_CAPABLE) {
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                } catch (Exception e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("MultiDex installation failed (");
                    outline73.append(e2.getMessage());
                    outline73.append(").");
                    throw new RuntimeException(outline73.toString());
                }
            }
        }
    }

    public static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        IOException[] iOExceptionArr;
        if (!list.isEmpty()) {
            Object obj = findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(list);
            access$100(obj, "dexElements", (Object[]) access$200(obj, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, new Object[]{arrayList2, file, arrayList}));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field findField = findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(obj, iOExceptionArr);
                IOException iOException2 = new IOException("I/O exception during makeDexElement");
                iOException2.initCause((Throwable) arrayList.get(0));
                throw iOException2;
            }
        }
    }

    public static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                file.getPath();
            } else {
                file.getPath();
                parentFile.isDirectory();
                parentFile.isFile();
                parentFile.exists();
                parentFile.canRead();
                parentFile.canWrite();
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to create directory ");
            outline73.append(file.getPath());
            throw new IOException(outline73.toString());
        }
    }
}
