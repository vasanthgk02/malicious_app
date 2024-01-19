package org.jdom;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.xml.sax.SAXException;

public class JDOMException extends Exception {
    public Throwable cause;

    public JDOMException() {
        super("Error occurred in JDOM application.");
    }

    public static Throwable getNestedException(Throwable th) {
        if (th instanceof JDOMException) {
            return ((JDOMException) th).getCause();
        }
        if (th instanceof SAXException) {
            return ((SAXException) th).getException();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        if (th instanceof ExceptionInInitializerError) {
            return ((ExceptionInInitializerError) th).getException();
        }
        if (th instanceof RemoteException) {
            return ((RemoteException) th).detail;
        }
        Throwable nestedException = getNestedException(th, "javax.naming.NamingException", "getRootCause");
        if (nestedException != null) {
            return nestedException;
        }
        Throwable nestedException2 = getNestedException(th, "javax.servlet.ServletException", "getRootCause");
        if (nestedException2 != null) {
            return nestedException2;
        }
        return null;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        String message = super.getMessage();
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th == 0) {
                break;
            }
            String message2 = th.getMessage();
            if (th instanceof SAXException) {
                Exception exception = ((SAXException) th).getException();
                if (!(exception == null || message2 == null || !message2.equals(exception.getMessage()))) {
                    message2 = null;
                }
            }
            if (message2 != null) {
                if (message != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(message);
                    stringBuffer.append(": ");
                    stringBuffer.append(message2);
                    message = stringBuffer.toString();
                } else {
                    message = message2;
                }
            }
        } while (!(th instanceof JDOMException));
        return message;
    }

    public Throwable initCause(Throwable th) {
        this.cause = th;
        return this;
    }

    public void printStackTrace() {
        super.printStackTrace();
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th != 0) {
                System.err.print("Caused by: ");
                th.printStackTrace();
            } else {
                return;
            }
        } while (!(th instanceof JDOMException));
    }

    public JDOMException(String str) {
        super(str);
    }

    public JDOMException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th != 0) {
                printStream.print("Caused by: ");
                th.printStackTrace(printStream);
            } else {
                return;
            }
        } while (!(th instanceof JDOMException));
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th != 0) {
                printWriter.print("Caused by: ");
                th.printStackTrace(printWriter);
            } else {
                return;
            }
        } while (!(th instanceof JDOMException));
    }

    public static Throwable getNestedException(Throwable th, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls.isAssignableFrom(th.getClass())) {
                return (Throwable) cls.getMethod(str2, new Class[0]).invoke(th, new Object[0]);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
