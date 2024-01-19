package com.bumptech.glide.load.engine;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GlideException extends Exception {
    public static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    public static final long serialVersionUID = 1;
    public final List<Throwable> causes;
    public Class<?> dataClass;
    public DataSource dataSource;
    public String detailMessage;
    public Key key;

    public static final class IndentedAppendable implements Appendable {
        public final Appendable appendable;
        public boolean printedNewLine = true;

        public IndentedAppendable(Appendable appendable2) {
            this.appendable = appendable2;
        }

        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(charSequence, i, i2);
            return this;
        }
    }

    public GlideException(String str) {
        List<Throwable> emptyList = Collections.emptyList();
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = emptyList;
    }

    public static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    public static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable addRootCauses : ((GlideException) th).causes) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th);
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(", ");
            outline73.append(this.dataClass);
            str = outline73.toString();
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.dataSource != null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73(", ");
            outline732.append(this.dataSource);
            str2 = outline732.toString();
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.key != null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73(", ");
            outline733.append(this.key);
            str3 = outline733.toString();
        }
        sb.append(str3);
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append(10);
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void printStackTrace() {
        printStackTrace((Appendable) System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    public final void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(this.causes, new IndentedAppendable(appendable));
    }

    public GlideException(String str, Throwable th) {
        List<Throwable> singletonList = Collections.singletonList(th);
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = singletonList;
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }
}
