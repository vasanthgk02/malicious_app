package androidx.core.os;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.apache.fontbox.cmap.CMapParser;

public final class LocaleListCompatWrapper implements LocaleListInterface {
    public static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    public static final Locale[] sEmptyList = new Locale[0];
    public final Locale[] mList;

    static {
        new Locale(HyperVergeKycCapture.EN, "XA");
        new Locale("ar", "XB");
    }

    public LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < localeArr.length) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    locale2.getLanguage();
                    String country = locale2.getCountry();
                    if (country != null && !country.isEmpty()) {
                        locale2.getCountry();
                    }
                    int length = localeArr.length;
                    hashSet.add(locale2);
                }
                i++;
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline42("list[", i, "] is null"));
            }
        }
        this.mList = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                outline73.append(localeArr[i]);
                if (i < this.mList.length - 1) {
                    outline73.append(',');
                }
                i++;
            } else {
                outline73.append(CMapParser.MARK_END_OF_ARRAY);
                return outline73.toString();
            }
        }
    }
}
