package in.juspay.hypersdk.utils.network;

import com.amazon.apay.hardened.external.model.APayConstants;
import com.mpl.androidapp.utils.Constant;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class JuspayHttpResponse {
    public static final String LOG_TAG = "JuspayHttpResponse";
    public final Map<String, List<String>> headers;
    public final int responseCode;
    public final byte[] responsePayload;

    public JuspayHttpResponse(int i, byte[] bArr, Map<String, List<String>> map) {
        this.responseCode = i;
        this.responsePayload = bArr;
        this.headers = map;
    }

    public JuspayHttpResponse(HttpURLConnection httpURLConnection) {
        GZIPInputStream gZIPInputStream;
        this.responseCode = httpURLConnection.getResponseCode();
        this.headers = httpURLConnection.getHeaderFields();
        int i = this.responseCode;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(((i < 200 || i >= 300) && this.responseCode != 302) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equals("gzip")) {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    this.responsePayload = byteArrayOutputStream.toByteArray();
                } else {
                    gZIPInputStream = new GZIPInputStream(bufferedInputStream);
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read2 = gZIPInputStream.read(bArr2);
                        if (read2 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read2);
                    }
                    this.responsePayload = byteArrayOutputStream.toByteArray();
                    gZIPInputStream.close();
                }
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bufferedInputStream.close();
                return;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(APayConstants.RESPONSE_CODE, this.responseCode);
            jSONObject.put("responsePayload", this.responsePayload);
            jSONObject.put(Constant.HEADER, this.headers);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
