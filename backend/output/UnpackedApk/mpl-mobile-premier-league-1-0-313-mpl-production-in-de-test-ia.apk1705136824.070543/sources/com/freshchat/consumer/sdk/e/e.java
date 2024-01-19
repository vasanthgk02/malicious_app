package com.freshchat.consumer.sdk.e;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

public class e {
    public String charset;
    public final String eF;
    public HttpURLConnection eG;
    public OutputStream eH;
    public PrintWriter eI;

    public e(Context context, String str) throws IOException {
        this(context, str, RNCWebViewManager.HTTP_METHOD_POST);
    }

    public e(Context context, String str, String str2) throws IOException {
        this.charset = "UTF-8";
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("***");
        outline73.append(System.currentTimeMillis());
        outline73.append("***");
        this.eF = outline73.toString();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("multipart/form-data; boundary=");
        outline732.append(this.eF);
        HttpURLConnection a2 = new c(context).a(str, str2, c.ah(outline732.toString()));
        this.eG = a2;
        this.eH = a2.getOutputStream();
        this.eI = new PrintWriter(new OutputStreamWriter(this.eH, this.charset), true);
    }

    public void a(String str, File file) throws IOException {
        a(str, file.getName(), new FileInputStream(file), null);
    }

    public void a(String str, String str2, InputStream inputStream, String str3) throws IOException {
        if (inputStream != null) {
            PrintWriter printWriter = this.eI;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("--");
            outline73.append(this.eF);
            printWriter.append(outline73.toString()).append("\r\n");
            this.eI.append(GeneratedOutlineSupport.outline54("Content-Disposition: form-data; name=\"", str, "\"; filename=\"", str2, "\"")).append("\r\n");
            this.eI.append("Content-Transfer-Encoding: binary").append("\r\n");
            if (str3 != null) {
                PrintWriter printWriter2 = this.eI;
                printWriter2.append("Content-Type: " + str3).append("\r\n");
            }
            this.eI.append("\r\n");
            this.eI.flush();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    this.eH.write(bArr, 0, read);
                } else {
                    this.eH.flush();
                    inputStream.close();
                    this.eI.append("\r\n");
                    this.eI.flush();
                    return;
                }
            }
        }
    }

    public d dc() {
        try {
            this.eI.append("\r\n").flush();
            PrintWriter printWriter = this.eI;
            printWriter.append("--" + this.eF + "--").append("\r\n");
            this.eI.close();
            InputStream a2 = c.a(this.eG);
            d dVar = new d();
            dVar.setInputStream(a2);
            dVar.setStatusCode(this.eG.getResponseCode());
            return dVar;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public void f(String str, String str2) {
        PrintWriter printWriter = this.eI;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("--");
        outline73.append(this.eF);
        printWriter.append(outline73.toString()).append("\r\n");
        PrintWriter printWriter2 = this.eI;
        printWriter2.append("Content-Disposition: form-data; name=\"" + str + "\"").append("\r\n");
        PrintWriter printWriter3 = this.eI;
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Content-Type: text/plain; charset=");
        outline732.append(this.charset);
        printWriter3.append(outline732.toString()).append("\r\n");
        this.eI.append("\r\n");
        this.eI.append(str2).append("\r\n");
        this.eI.flush();
    }
}
