package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelParcel;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = versionedParcel.readInt(iconCompat.mType, 1);
        byte[] bArr = iconCompat.mData;
        if (versionedParcel.readField(2)) {
            VersionedParcelParcel versionedParcelParcel = (VersionedParcelParcel) versionedParcel;
            int readInt = versionedParcelParcel.mParcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                versionedParcelParcel.mParcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.mData = bArr;
        iconCompat.mParcelable = versionedParcel.readParcelable(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = versionedParcel.readInt(iconCompat.mInt1, 4);
        iconCompat.mInt2 = versionedParcel.readInt(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList) versionedParcel.readParcelable(iconCompat.mTintList, 6);
        String str = iconCompat.mTintModeStr;
        if (versionedParcel.readField(7)) {
            str = ((VersionedParcelParcel) versionedParcel).mParcel.readString();
        }
        iconCompat.mTintModeStr = str;
        String str2 = iconCompat.mString1;
        if (versionedParcel.readField(8)) {
            str2 = ((VersionedParcelParcel) versionedParcel).mParcel.readString();
        }
        iconCompat.mString1 = str2;
        iconCompat.mTintMode = Mode.valueOf(iconCompat.mTintModeStr);
        switch (iconCompat.mType) {
            case -1:
                Parcelable parcelable = iconCompat.mParcelable;
                if (parcelable != null) {
                    iconCompat.mObj1 = parcelable;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.mParcelable;
                if (parcelable2 == null) {
                    byte[] bArr3 = iconCompat.mData;
                    iconCompat.mObj1 = bArr3;
                    iconCompat.mType = 3;
                    iconCompat.mInt1 = 0;
                    iconCompat.mInt2 = bArr3.length;
                    break;
                } else {
                    iconCompat.mObj1 = parcelable2;
                    break;
                }
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.mData, Charset.forName("UTF-16"));
                iconCompat.mObj1 = str3;
                if (iconCompat.mType == 2 && iconCompat.mString1 == null) {
                    iconCompat.mString1 = str3.split(":", -1)[0];
                    break;
                }
            case 3:
                iconCompat.mObj1 = iconCompat.mData;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        if (versionedParcel != null) {
            iconCompat.mTintModeStr = iconCompat.mTintMode.name();
            switch (iconCompat.mType) {
                case -1:
                    iconCompat.mParcelable = (Parcelable) iconCompat.mObj1;
                    break;
                case 1:
                case 5:
                    iconCompat.mParcelable = (Parcelable) iconCompat.mObj1;
                    break;
                case 2:
                    iconCompat.mData = ((String) iconCompat.mObj1).getBytes(Charset.forName("UTF-16"));
                    break;
                case 3:
                    iconCompat.mData = (byte[]) iconCompat.mObj1;
                    break;
                case 4:
                case 6:
                    iconCompat.mData = iconCompat.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                    break;
            }
            int i = iconCompat.mType;
            if (-1 != i) {
                versionedParcel.writeInt(i, 1);
            }
            byte[] bArr = iconCompat.mData;
            if (bArr != null) {
                versionedParcel.setOutputField(2);
                VersionedParcelParcel versionedParcelParcel = (VersionedParcelParcel) versionedParcel;
                versionedParcelParcel.mParcel.writeInt(bArr.length);
                versionedParcelParcel.mParcel.writeByteArray(bArr);
            }
            Parcelable parcelable = iconCompat.mParcelable;
            if (parcelable != null) {
                versionedParcel.setOutputField(3);
                ((VersionedParcelParcel) versionedParcel).mParcel.writeParcelable(parcelable, 0);
            }
            int i2 = iconCompat.mInt1;
            if (i2 != 0) {
                versionedParcel.writeInt(i2, 4);
            }
            int i3 = iconCompat.mInt2;
            if (i3 != 0) {
                versionedParcel.writeInt(i3, 5);
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                versionedParcel.setOutputField(6);
                ((VersionedParcelParcel) versionedParcel).mParcel.writeParcelable(colorStateList, 0);
            }
            String str = iconCompat.mTintModeStr;
            if (str != null) {
                versionedParcel.setOutputField(7);
                ((VersionedParcelParcel) versionedParcel).mParcel.writeString(str);
            }
            String str2 = iconCompat.mString1;
            if (str2 != null) {
                versionedParcel.setOutputField(8);
                ((VersionedParcelParcel) versionedParcel).mParcel.writeString(str2);
                return;
            }
            return;
        }
        throw null;
    }
}
