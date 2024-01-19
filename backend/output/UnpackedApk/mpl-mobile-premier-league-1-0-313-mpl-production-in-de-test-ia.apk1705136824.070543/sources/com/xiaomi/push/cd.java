package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

public class cd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public cm f4537a = null;

    /* renamed from: a  reason: collision with other field name */
    public cn f410a = null;

    /* renamed from: a  reason: collision with other field name */
    public Throwable f411a = null;

    public cd() {
    }

    public cd(cm cmVar) {
        this.f4537a = cmVar;
    }

    public cd(String str) {
        super(str);
    }

    public cd(String str, Throwable th) {
        super(str);
        this.f411a = th;
    }

    public cd(Throwable th) {
        this.f411a = th;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            cn cnVar = this.f410a;
            if (cnVar != null) {
                return cnVar.toString();
            }
        }
        if (message == null) {
            cm cmVar = this.f4537a;
            if (cmVar != null) {
                message = cmVar.toString();
            }
        }
        return message;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f411a != null) {
            printStream.println("Nested Exception: ");
            this.f411a.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f411a != null) {
            printWriter.println("Nested Exception: ");
            this.f411a.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        cn cnVar = this.f410a;
        if (cnVar != null) {
            sb.append(cnVar);
        }
        cm cmVar = this.f4537a;
        if (cmVar != null) {
            sb.append(cmVar);
        }
        if (this.f411a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f411a);
        }
        return sb.toString();
    }
}
