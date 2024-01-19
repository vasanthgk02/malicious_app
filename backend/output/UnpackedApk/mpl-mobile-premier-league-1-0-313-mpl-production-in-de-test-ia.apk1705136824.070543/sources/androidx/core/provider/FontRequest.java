package androidx.core.provider;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

public final class FontRequest {
    public final List<List<byte[]>> mCertificates;
    public final int mCertificatesArray;
    public final String mIdentifier;
    public final String mProviderAuthority;
    public final String mProviderPackage;
    public final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.mProviderAuthority = str;
        this.mProviderPackage = str2;
        this.mQuery = str3;
        if (list != null) {
            this.mCertificates = list;
            this.mCertificatesArray = 0;
            this.mIdentifier = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FontRequest {mProviderAuthority: ");
        outline73.append(this.mProviderAuthority);
        outline73.append(", mProviderPackage: ");
        outline73.append(this.mProviderPackage);
        outline73.append(", mQuery: ");
        outline73.append(this.mQuery);
        outline73.append(", mCertificates:");
        sb.append(outline73.toString());
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
