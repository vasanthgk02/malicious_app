package org.apache.commons.lang.exception;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

public class ExceptionUtils {
    public static String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    public static final Method THROWABLE_CAUSE_METHOD;
    public static final Method THROWABLE_INITCAUSE_METHOD;
    public static final String WRAPPED_MARKER = " [wrapped] ";
    public static /* synthetic */ Class class$java$lang$Throwable;

    static {
        Method method;
        Class cls;
        Class cls2;
        Class cls3;
        Method method2 = null;
        try {
            if (class$java$lang$Throwable == null) {
                cls3 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls3;
            } else {
                cls3 = class$java$lang$Throwable;
            }
            method = cls3.getMethod("getCause", null);
        } catch (Exception unused) {
            method = null;
        }
        THROWABLE_CAUSE_METHOD = method;
        try {
            if (class$java$lang$Throwable == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            } else {
                cls = class$java$lang$Throwable;
            }
            Class[] clsArr = new Class[1];
            if (class$java$lang$Throwable == null) {
                cls2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls2;
            } else {
                cls2 = class$java$lang$Throwable;
            }
            clsArr[0] = cls2;
            method2 = cls.getMethod("initCause", clsArr);
        } catch (Exception unused2) {
        }
        THROWABLE_INITCAUSE_METHOD = method2;
    }

    public static void addCauseMethodName(String str) {
        if (StringUtils.isNotEmpty(str) && !isCauseMethodName(str)) {
            ArrayList causeMethodNameList = getCauseMethodNameList();
            if (causeMethodNameList.add(str)) {
                synchronized (CAUSE_METHOD_NAMES) {
                    CAUSE_METHOD_NAMES = toArray(causeMethodNameList);
                }
            }
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Throwable getCause(Throwable th) {
        Throwable cause;
        synchronized (CAUSE_METHOD_NAMES) {
            try {
                cause = getCause(th, CAUSE_METHOD_NAMES);
            }
        }
        return cause;
    }

    public static ArrayList getCauseMethodNameList() {
        ArrayList arrayList;
        synchronized (CAUSE_METHOD_NAMES) {
            arrayList = new ArrayList(Arrays.asList(CAUSE_METHOD_NAMES));
        }
        return arrayList;
    }

    public static Throwable getCauseUsingFieldName(Throwable th, String str) {
        Field field;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException | SecurityException unused) {
            field = null;
        }
        if (field != null) {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException | IllegalArgumentException unused2) {
                }
            }
        }
        return null;
    }

    public static Throwable getCauseUsingMethodName(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null) {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, ArrayUtils.EMPTY_OBJECT_ARRAY);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                }
            }
        }
        return null;
    }

    public static Throwable getCauseUsingWellKnownTypes(Throwable th) {
        if (th instanceof Nestable) {
            return ((Nestable) th).getCause();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        return null;
    }

    public static String getFullStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        Throwable[] throwables = getThrowables(th);
        for (int i = 0; i < throwables.length; i++) {
            throwables[i].printStackTrace(printWriter);
            if (isNestedThrowable(throwables[i])) {
                break;
            }
        }
        return stringWriter.getBuffer().toString();
    }

    public static String getMessage(Throwable th) {
        if (th == null) {
            return "";
        }
        String shortClassName = ClassUtils.getShortClassName(th, null);
        String message = th.getMessage();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(shortClassName);
        stringBuffer.append(": ");
        stringBuffer.append(StringUtils.defaultString(message));
        return stringBuffer.toString();
    }

    public static Throwable getRootCause(Throwable th) {
        List throwableList = getThrowableList(th);
        if (throwableList.size() < 2) {
            return null;
        }
        return (Throwable) GeneratedOutlineSupport.outline29(throwableList, -1);
    }

    public static String getRootCauseMessage(Throwable th) {
        Throwable rootCause = getRootCause(th);
        if (rootCause != null) {
            th = rootCause;
        }
        return getMessage(th);
    }

    public static String[] getRootCauseStackTrace(Throwable th) {
        List list;
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i = length - 1;
        List stackFrameList = getStackFrameList(throwables[i]);
        while (true) {
            length--;
            if (length < 0) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            if (length != 0) {
                list = getStackFrameList(throwables[length - 1]);
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (length == i) {
                arrayList.add(throwables[length].toString());
            } else {
                StringBuffer outline71 = GeneratedOutlineSupport.outline71(WRAPPED_MARKER);
                outline71.append(throwables[length].toString());
                arrayList.add(outline71.toString());
            }
            for (int i2 = 0; i2 < stackFrameList.size(); i2++) {
                arrayList.add(stackFrameList.get(i2));
            }
            stackFrameList = list;
        }
    }

    public static List getStackFrameList(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().length() == 0) {
                z = true;
                arrayList.add(nextToken);
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    public static String[] getStackFrames(Throwable th) {
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th));
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable th) {
        return getThrowableList(th).size();
    }

    public static List getThrowableList(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = getCause(th);
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th) {
        List throwableList = getThrowableList(th);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    public static int indexOf(Throwable th, Class cls, int i, boolean z) {
        if (!(th == null || cls == null)) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] throwables = getThrowables(th);
            if (i >= throwables.length) {
                return -1;
            }
            if (z) {
                while (i < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < throwables.length) {
                    if (cls.equals(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th, Class cls) {
        return indexOf(th, cls, 0, false);
    }

    public static int indexOfType(Throwable th, Class cls) {
        return indexOf(th, cls, 0, true);
    }

    public static boolean isCauseMethodName(String str) {
        boolean z;
        synchronized (CAUSE_METHOD_NAMES) {
            z = ArrayUtils.indexOf((Object[]) CAUSE_METHOD_NAMES, (Object) str) >= 0;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0058, code lost:
        if (r7.getField("detail") == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005a, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNestedThrowable(java.lang.Throwable r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof org.apache.commons.lang.exception.Nestable
            r2 = 1
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = r7 instanceof java.sql.SQLException
            if (r1 == 0) goto L_0x000f
            return r2
        L_0x000f:
            boolean r1 = r7 instanceof java.lang.reflect.InvocationTargetException
            if (r1 == 0) goto L_0x0014
            return r2
        L_0x0014:
            boolean r1 = isThrowableNested()
            if (r1 == 0) goto L_0x001b
            return r2
        L_0x001b:
            java.lang.Class r7 = r7.getClass()
            java.lang.String[] r1 = CAUSE_METHOD_NAMES
            monitor-enter(r1)
            java.lang.String[] r3 = CAUSE_METHOD_NAMES     // Catch:{ all -> 0x005c }
            int r3 = r3.length     // Catch:{ all -> 0x005c }
            r4 = 0
        L_0x0026:
            if (r4 >= r3) goto L_0x0051
            java.lang.String[] r5 = CAUSE_METHOD_NAMES     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            r5 = r5[r4]     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            r6 = 0
            java.lang.reflect.Method r5 = r7.getMethod(r5, r6)     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            if (r5 == 0) goto L_0x004e
            java.lang.Class r6 = class$java$lang$Throwable     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            if (r6 != 0) goto L_0x0040
            java.lang.String r6 = "java.lang.Throwable"
            java.lang.Class r6 = class$(r6)     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            class$java$lang$Throwable = r6     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            goto L_0x0042
        L_0x0040:
            java.lang.Class r6 = class$java$lang$Throwable     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
        L_0x0042:
            java.lang.Class r5 = r5.getReturnType()     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            boolean r5 = r6.isAssignableFrom(r5)     // Catch:{ NoSuchMethodException | SecurityException -> 0x004e }
            if (r5 == 0) goto L_0x004e
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            return r2
        L_0x004e:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0051:
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "detail"
            java.lang.reflect.Field r7 = r7.getField(r1)     // Catch:{ NoSuchFieldException | SecurityException -> 0x005b }
            if (r7 == 0) goto L_0x005b
            return r2
        L_0x005b:
            return r0
        L_0x005c:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.exception.ExceptionUtils.isNestedThrowable(java.lang.Throwable):boolean");
    }

    public static boolean isThrowableNested() {
        return THROWABLE_CAUSE_METHOD != null;
    }

    public static void printRootCauseStackTrace(Throwable th) {
        printRootCauseStackTrace(th, System.err);
    }

    public static void removeCauseMethodName(String str) {
        if (StringUtils.isNotEmpty(str)) {
            ArrayList causeMethodNameList = getCauseMethodNameList();
            if (causeMethodNameList.remove(str)) {
                synchronized (CAUSE_METHOD_NAMES) {
                    CAUSE_METHOD_NAMES = toArray(causeMethodNameList);
                }
            }
        }
    }

    public static void removeCommonFrames(List list, List list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (((String) list.get(size)).equals((String) list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e A[Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean setCause(java.lang.Throwable r7, java.lang.Throwable r8) {
        /*
            if (r7 == 0) goto L_0x0035
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            java.lang.reflect.Method r8 = THROWABLE_INITCAUSE_METHOD
            if (r8 == 0) goto L_0x0011
            r8.invoke(r7, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0011 }
            r8 = 1
            goto L_0x0012
        L_0x0011:
            r8 = 0
        L_0x0012:
            java.lang.Class r3 = r7.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            java.lang.String r4 = "setCause"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            java.lang.Class r6 = class$java$lang$Throwable     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            if (r6 != 0) goto L_0x0027
            java.lang.String r6 = "java.lang.Throwable"
            java.lang.Class r6 = class$(r6)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            class$java$lang$Throwable = r6     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            goto L_0x0029
        L_0x0027:
            java.lang.Class r6 = class$java$lang$Throwable     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
        L_0x0029:
            r5[r2] = r6     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            java.lang.reflect.Method r2 = r3.getMethod(r4, r5)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            r2.invoke(r7, r1)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r0 = r8
        L_0x0034:
            return r0
        L_0x0035:
            org.apache.commons.lang.NullArgumentException r7 = new org.apache.commons.lang.NullArgumentException
            java.lang.String r8 = "target"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.exception.ExceptionUtils.setCause(java.lang.Throwable, java.lang.Throwable):boolean");
    }

    public static String[] toArray(List list) {
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static int indexOfThrowable(Throwable th, Class cls, int i) {
        return indexOf(th, cls, i, false);
    }

    public static int indexOfType(Throwable th, Class cls, int i) {
        return indexOf(th, cls, i, true);
    }

    public static void printRootCauseStackTrace(Throwable th, PrintStream printStream) {
        if (th != null) {
            if (printStream != null) {
                String[] rootCauseStackTrace = getRootCauseStackTrace(th);
                for (String println : rootCauseStackTrace) {
                    printStream.println(println);
                }
                printStream.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintStream must not be null");
        }
    }

    public static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return toArray(arrayList);
    }

    public static Throwable getCause(Throwable th, String[] strArr) {
        if (th == null) {
            return null;
        }
        Throwable causeUsingWellKnownTypes = getCauseUsingWellKnownTypes(th);
        if (causeUsingWellKnownTypes == null) {
            if (strArr == null) {
                synchronized (CAUSE_METHOD_NAMES) {
                    strArr = CAUSE_METHOD_NAMES;
                }
            }
            for (String str : strArr) {
                if (str != null) {
                    causeUsingWellKnownTypes = getCauseUsingMethodName(th, str);
                    if (causeUsingWellKnownTypes != null) {
                        break;
                    }
                }
            }
            if (causeUsingWellKnownTypes == null) {
                causeUsingWellKnownTypes = getCauseUsingFieldName(th, "detail");
            }
        }
        return causeUsingWellKnownTypes;
    }

    public static void printRootCauseStackTrace(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            if (printWriter != null) {
                String[] rootCauseStackTrace = getRootCauseStackTrace(th);
                for (String println : rootCauseStackTrace) {
                    printWriter.println(println);
                }
                printWriter.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintWriter must not be null");
        }
    }
}
