package com.mpl.network.modules.utils;

import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

@Keep
public class MException extends RuntimeException {
    public static final int DEFAULT_ERROR_CODE = 1000;
    public static final int NULL_POINTER_ERROR_CODE = 1001;
    public static final int RUNTIME_ERROR_CODE = 1002;
    public static final String TAG = "NetworkLib: MException";
    public Throwable cause;
    public String detailMessage;
    public int errorCode;
    public ArrayList<MHeader> mHeaders;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f964a;

        /* renamed from: b  reason: collision with root package name */
        public Throwable f965b;

        /* renamed from: c  reason: collision with root package name */
        public int f966c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<MHeader> f967d;

        public b a(String str, String str2) {
            if (this.f967d == null) {
                this.f967d = new ArrayList<>();
            }
            this.f967d.add(new MHeader(str, str2));
            return this;
        }

        public MException a() {
            return new MException(this);
        }
    }

    public MException() {
        this.cause = this;
        MLog.i(TAG, "MException() called");
    }

    public MException(int i, String str) {
        super(str);
        this.cause = this;
        MLog.i(TAG, "MException() called with: code = [" + i + "], message = [" + str + CMapParser.MARK_END_OF_ARRAY);
        this.errorCode = i;
        this.detailMessage = str;
    }

    public MException(b bVar) {
        this.cause = this;
        setDetailMessage(bVar.f964a);
        setCause(bVar.f965b);
        setErrorCode(bVar.f966c);
    }

    public MException(String str) {
        super(str);
        this.cause = this;
        MLog.i(TAG, GeneratedOutlineSupport.outline52("MException() called with: message = [", str, CMapParser.MARK_END_OF_ARRAY));
        this.detailMessage = str;
    }

    public MException(String str, Throwable th) {
        super(str, th);
        this.cause = this;
        MLog.i(TAG, "MException() called with: message = [" + str + "], cause = [" + th + CMapParser.MARK_END_OF_ARRAY);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\n");
        sb.append(th.getMessage());
        this.detailMessage = sb.toString();
    }

    public MException(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
        this.cause = this;
        MLog.i(TAG, "MException() called with: message = [" + str + "], cause = [" + th + "], enableSuppression = [" + z + "], writableStackTrace = [" + z2 + CMapParser.MARK_END_OF_ARRAY);
        this.detailMessage = str;
        this.cause = th;
    }

    public MException(Throwable th) {
        super(th);
        this.cause = this;
        MLog.i(TAG, "MException() called with: cause = [" + th + CMapParser.MARK_END_OF_ARRAY);
        this.detailMessage = th == null ? null : th.toString();
        this.cause = th;
    }

    public MException(List<String> list) {
        this.cause = this;
        MLog.i(TAG, "MException() called");
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append("\n");
        }
        this.detailMessage = sb.toString();
    }

    private String getDetailMessage() {
        if (getCause() == null) {
            return this.detailMessage;
        }
        return this.detailMessage + getCause().getMessage();
    }

    private void setCause(Throwable th) {
        this.cause = th;
    }

    private void setDetailMessage(String str) {
        this.detailMessage = str;
    }

    private void setErrorCode(int i) {
        this.errorCode = i;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ArrayList<MHeader> getHeaders() {
        return this.mHeaders;
    }

    public String getMessage() {
        return getDetailMessage();
    }

    public void setHeaders(ArrayList<MHeader> arrayList) {
        this.mHeaders = arrayList;
    }
}
