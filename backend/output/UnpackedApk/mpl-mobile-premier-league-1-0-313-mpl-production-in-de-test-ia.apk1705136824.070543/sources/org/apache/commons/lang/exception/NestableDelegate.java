package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate implements Serializable {
    public static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
    public static /* synthetic */ Class class$org$apache$commons$lang$exception$Nestable = null;
    public static boolean matchSubclasses = true;
    public static final long serialVersionUID = 1;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    public Throwable nestable = null;

    public NestableDelegate(Nestable nestable2) {
        if (nestable2 instanceof Throwable) {
            this.nestable = (Throwable) nestable2;
            return;
        }
        throw new IllegalArgumentException(MUST_BE_THROWABLE);
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public String getMessage(int i) {
        Throwable throwable = getThrowable(i);
        Class cls = class$org$apache$commons$lang$exception$Nestable;
        if (cls == null) {
            cls = class$("org.apache.commons.lang.exception.Nestable");
            class$org$apache$commons$lang$exception$Nestable = cls;
        }
        if (cls.isInstance(throwable)) {
            return ((Nestable) throwable).getMessage(0);
        }
        return throwable.getMessage();
    }

    public String[] getMessages() {
        Throwable[] throwables = getThrowables();
        String[] strArr = new String[throwables.length];
        for (int i = 0; i < throwables.length; i++) {
            Class cls = class$org$apache$commons$lang$exception$Nestable;
            if (cls == null) {
                cls = class$("org.apache.commons.lang.exception.Nestable");
                class$org$apache$commons$lang$exception$Nestable = cls;
            }
            strArr[i] = cls.isInstance(throwables[i]) ? ((Nestable) throwables[i]).getMessage(0) : throwables[i].getMessage();
        }
        return strArr;
    }

    public String[] getStackFrames(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        if (th instanceof Nestable) {
            ((Nestable) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
        return ExceptionUtils.getStackFrames(stringWriter.getBuffer().toString());
    }

    public Throwable getThrowable(int i) {
        if (i == 0) {
            return this.nestable;
        }
        return getThrowables()[i];
    }

    public int getThrowableCount() {
        return ExceptionUtils.getThrowableCount(this.nestable);
    }

    public Throwable[] getThrowables() {
        return ExceptionUtils.getThrowables(this.nestable);
    }

    public int indexOfThrowable(Class cls, int i) {
        if (cls == null) {
            return -1;
        }
        if (i >= 0) {
            Throwable[] throwables = ExceptionUtils.getThrowables(this.nestable);
            if (i < throwables.length) {
                if (matchSubclasses) {
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
                return -1;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The start index was out of bounds: ");
            stringBuffer.append(i);
            stringBuffer.append(" >= ");
            stringBuffer.append(throwables.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("The start index was out of bounds: ");
        stringBuffer2.append(i);
        throw new IndexOutOfBoundsException(stringBuffer2.toString());
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void trimStackFrames(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            ExceptionUtils.removeCommonFrames(arrayList, new ArrayList(Arrays.asList((String[]) list.get(size - 1))));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\t... ");
                stringBuffer.append(length);
                stringBuffer.append(" more");
                arrayList.add(stringBuffer.toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter(printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public String getMessage(String str) {
        String str2;
        Throwable cause = ExceptionUtils.getCause(this.nestable);
        if (cause == null) {
            str2 = null;
        } else {
            str2 = cause.getMessage();
        }
        if (!(cause == null || str2 == null)) {
            if (str == null) {
                return str2;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(str2);
            str = stringBuffer.toString();
        }
        return str;
    }

    public void printStackTrace(PrintWriter printWriter) {
        Throwable th = this.nestable;
        if (ExceptionUtils.isThrowableNested()) {
            if (th instanceof Nestable) {
                ((Nestable) th).printPartialStackTrace(printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (th != null) {
            arrayList.add(getStackFrames(th));
            th = ExceptionUtils.getCause(th);
        }
        String str = "Caused by: ";
        if (!topDown) {
            str = "Rethrown as: ";
            Collections.reverse(arrayList);
        }
        if (trimStackFrames) {
            trimStackFrames(arrayList);
        }
        synchronized (printWriter) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (String println : (String[]) it.next()) {
                    printWriter.println(println);
                }
                if (it.hasNext()) {
                    printWriter.print(str);
                }
            }
        }
    }
}
