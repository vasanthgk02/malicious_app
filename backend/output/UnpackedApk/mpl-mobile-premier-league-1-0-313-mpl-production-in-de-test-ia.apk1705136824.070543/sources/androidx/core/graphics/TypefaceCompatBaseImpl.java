package androidx.core.graphics;

import a.a.a.a.d.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;

public class TypefaceCompatBaseImpl {
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, FontResourcesParserCompat$FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    public interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    public static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : OS2WindowsMetricsTable.WEIGHT_CLASS_BOLD;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t2) - i2) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i);

    public abstract Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i);

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = b.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!b.copyToFile(tempFile, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = b.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!b.copyToFile(tempFile, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public FontsContractCompat$FontInfo findBestInfo(FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        return (FontsContractCompat$FontInfo) findBestFont(fontsContractCompat$FontInfoArr, i, new StyleExtractor<FontsContractCompat$FontInfo>(this) {
            public int getWeight(Object obj) {
                return ((FontsContractCompat$FontInfo) obj).mWeight;
            }

            public boolean isItalic(Object obj) {
                return ((FontsContractCompat$FontInfo) obj).mItalic;
            }
        });
    }
}
