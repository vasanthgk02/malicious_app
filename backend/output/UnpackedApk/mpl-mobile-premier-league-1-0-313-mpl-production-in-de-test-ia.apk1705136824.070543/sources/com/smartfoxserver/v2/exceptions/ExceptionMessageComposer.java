package com.smartfoxserver.v2.exceptions;

import com.smartfoxserver.bitswarm.util.Logging;
import java.util.ArrayList;
import java.util.List;
import org.python.core.PyException;

public class ExceptionMessageComposer {
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static volatile boolean globalPrintStackTrace = true;
    public static volatile boolean useExtendedMessages = true;
    public List<String> additionalInfos;
    public StringBuilder buf;
    public String description;
    public String exceptionType;
    public String mainErrorMessage;
    public String possibleCauses;
    public String stackTrace;

    public ExceptionMessageComposer(Throwable th) {
        this(th, globalPrintStackTrace);
    }

    private void setStackTrace(Throwable th) {
        this.stackTrace = Logging.formatStackTrace(th.getStackTrace());
    }

    public void addInfo(String str) {
        if (this.additionalInfos == null) {
            this.additionalInfos = new ArrayList();
        }
        this.additionalInfos.add(str);
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setPossibleCauses(String str) {
        this.possibleCauses = str;
    }

    public String toString() {
        if (!useExtendedMessages) {
            StringBuilder sb = this.buf;
            sb.append(this.exceptionType);
            sb.append(": ");
            sb.append(this.mainErrorMessage);
            return this.buf.toString();
        }
        StringBuilder sb2 = this.buf;
        sb2.append(this.exceptionType);
        sb2.append(":");
        sb2.append(NEW_LINE);
        StringBuilder sb3 = this.buf;
        sb3.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        sb3.append(NEW_LINE);
        StringBuilder sb4 = this.buf;
        sb4.append("Exception: ");
        sb4.append(this.exceptionType);
        sb4.append(NEW_LINE);
        StringBuilder sb5 = this.buf;
        sb5.append("Message: ");
        sb5.append(this.mainErrorMessage);
        sb5.append(NEW_LINE);
        if (this.description != null) {
            StringBuilder sb6 = this.buf;
            sb6.append("Description: ");
            sb6.append(this.description);
            sb6.append(NEW_LINE);
        }
        if (this.possibleCauses != null) {
            StringBuilder sb7 = this.buf;
            sb7.append("Possible Causes: ");
            sb7.append(this.possibleCauses);
            sb7.append(NEW_LINE);
        }
        List<String> list = this.additionalInfos;
        if (list != null) {
            for (String append : list) {
                StringBuilder sb8 = this.buf;
                sb8.append(append);
                sb8.append(NEW_LINE);
            }
        }
        if (this.stackTrace != null) {
            StringBuilder sb9 = this.buf;
            sb9.append("+--- --- ---+");
            sb9.append(NEW_LINE);
            StringBuilder sb10 = this.buf;
            sb10.append("Stack Trace:");
            sb10.append(NEW_LINE);
            StringBuilder sb11 = this.buf;
            sb11.append("+--- --- ---+");
            sb11.append(NEW_LINE);
            this.buf.append(this.stackTrace);
            StringBuilder sb12 = this.buf;
            sb12.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            sb12.append(NEW_LINE);
        } else {
            StringBuilder sb13 = this.buf;
            sb13.append("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            sb13.append(NEW_LINE);
        }
        return this.buf.toString();
    }

    public ExceptionMessageComposer(Throwable th, boolean z) {
        String message = th.getMessage();
        this.mainErrorMessage = message;
        if (message == null) {
            this.mainErrorMessage = "*** Null ***";
        }
        this.exceptionType = th.getClass().getName();
        this.buf = new StringBuilder();
        if (z) {
            setStackTrace(th);
        }
        if (th instanceof PyException) {
            PyException pyException = (PyException) th;
            addInfo("Python type: " + pyException.type);
            addInfo("Python value: " + pyException.value);
            addInfo("Python stack: " + pyException.traceback.dumpStack());
        }
    }
}
