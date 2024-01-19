package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.security.InvalidParameterException;

/* renamed from: cr  reason: default package */
public final class cr implements Parcelable {
    public static final Creator<cr> CREATOR = new Creator<cr>() {
        public Object createFromParcel(Parcel parcel) {
            return new cr(parcel);
        }

        public Object[] newArray(int i) {
            return new cr[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final cr f3314a = new cr((String) "0.0.0");

    /* renamed from: a  reason: collision with other field name */
    public static final String f125a = cr.class.getName();

    /* renamed from: a  reason: collision with other field name */
    public final int[] f126a;

    public cr(Parcel parcel) {
        int[] iArr = new int[parcel.readInt()];
        this.f126a = iArr;
        parcel.readIntArray(iArr);
        toString();
    }

    public cr(String str) {
        cp.c(f125a, "MAPVersion from String : " + str);
        if (str != null) {
            String[] split = TextUtils.split(str, "\\.");
            this.f126a = new int[split.length];
            int i = 0;
            for (String parseInt : split) {
                try {
                    this.f126a[i] = Integer.parseInt(parseInt);
                } catch (NumberFormatException unused) {
                    this.f126a[i] = 0;
                }
                i++;
            }
            return;
        }
        throw new InvalidParameterException("version must not be null");
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        int[] iArr = this.f126a;
        StringBuffer stringBuffer = new StringBuffer();
        for (int append : iArr) {
            stringBuffer.append(append);
            stringBuffer.append('.');
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int length = this.f126a.length;
        parcel.writeInt(this.f126a.length);
        parcel.writeIntArray(this.f126a);
    }
}
