package org.apache.pdfbox.pdmodel.font;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.cff.CFFParser;
import org.apache.fontbox.cff.CFFType1Font;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.Type1Equivalent;
import org.apache.fontbox.type1.Type1Font;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.util.PDFBoxResourceLoader;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public final class ExternalFonts {
    public static final CFFCIDFont cidFallbackFont;
    public static FontProvider fontProvider;
    public static final Map<String, List<String>> substitutes;
    public static final TrueTypeFont ttfFallbackFont;

    public static class DefaultFontProvider {
        public static final FontProvider INSTANCE = new FileSystemFontProvider();
    }

    static {
        InputStream inputStream;
        InputStream inputStream2;
        Class<ExternalFonts> cls = ExternalFonts.class;
        try {
            if (PDFBoxResourceLoader.isReady()) {
                inputStream = PDFBoxResourceLoader.getStream("org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                if (inputStream == null) {
                    throw new IOException("Error loading resource: " + inputStream);
                }
            } else {
                URL resource = cls.getClassLoader().getResource("org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                if (resource != null) {
                    inputStream = FirebasePerfUrlConnection.openStream(resource);
                } else {
                    throw new IOException("Error loading resource: " + "org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                }
            }
            ttfFallbackFont = new TTFParser().parse(inputStream);
            if (PDFBoxResourceLoader.isReady()) {
                inputStream2 = PDFBoxResourceLoader.getStream("org/apache/pdfbox/resources/otf/AdobeBlank.otf");
                if (inputStream2 == null) {
                    throw new IOException("Error loading resource: " + "org/apache/pdfbox/resources/otf/AdobeBlank.otf");
                }
            } else {
                URL resource2 = cls.getClassLoader().getResource("org/apache/pdfbox/resources/otf/AdobeBlank.otf");
                if (resource2 != null) {
                    inputStream2 = FirebasePerfUrlConnection.openStream(resource2);
                } else {
                    throw new IOException("Error loading resource: " + "org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                }
            }
            cidFallbackFont = (CFFCIDFont) new CFFParser().parse(IOUtils.toByteArray(inputStream2)).get(0);
            HashMap hashMap = new HashMap();
            substitutes = hashMap;
            hashMap.put("Courier", Arrays.asList(new String[]{"CourierNew", "CourierNewPSMT", "LiberationMono", "NimbusMonL-Regu", "DroidSansMono"}));
            substitutes.put("Courier-Bold", Arrays.asList(new String[]{"CourierNewPS-BoldMT", "CourierNew-Bold", "LiberationMono-Bold", "NimbusMonL-Bold", "DroidSansMono"}));
            substitutes.put("Courier-Oblique", Arrays.asList(new String[]{"CourierNewPS-ItalicMT", "CourierNew-Italic", "LiberationMono-Italic", "NimbusMonL-ReguObli", "DroidSansMono"}));
            substitutes.put("Courier-BoldOblique", Arrays.asList(new String[]{"CourierNewPS-BoldItalicMT", "CourierNew-BoldItalic", "LiberationMono-BoldItalic", "NimbusMonL-BoldObli", "DroidSansMono"}));
            substitutes.put("Helvetica", Arrays.asList(new String[]{"ArialMT", "Arial", "LiberationSans", "NimbusSanL-Regu", "Roboto-Regular"}));
            substitutes.put("Helvetica-Bold", Arrays.asList(new String[]{"Arial-BoldMT", "Arial-Bold", "LiberationSans-Bold", "NimbusSanL-Bold", "Roboto-Bold"}));
            substitutes.put("Helvetica-Oblique", Arrays.asList(new String[]{"Arial-ItalicMT", "Arial-Italic", "Helvetica-Italic", "LiberationSans-Italic", "NimbusSanL-ReguItal", "Roboto-Italic"}));
            substitutes.put("Helvetica-BoldOblique", Arrays.asList(new String[]{"Arial-BoldItalicMT", "Helvetica-BoldItalic", "LiberationSans-BoldItalic", "NimbusSanL-BoldItal", "Roboto-BoldItalic"}));
            substitutes.put("Times-Roman", Arrays.asList(new String[]{"TimesNewRomanPSMT", "TimesNewRoman", "TimesNewRomanPS", "LiberationSerif", "NimbusRomNo9L-Regu", "DroidSerif-Regular"}));
            substitutes.put("Times-Bold", Arrays.asList(new String[]{"TimesNewRomanPS-BoldMT", "TimesNewRomanPS-Bold", "TimesNewRoman-Bold", "LiberationSerif-Bold", "NimbusRomNo9L-Medi", "DroidSerif-Bold"}));
            substitutes.put("Times-Italic", Arrays.asList(new String[]{"TimesNewRomanPS-ItalicMT", "TimesNewRomanPS-Italic", "TimesNewRoman-Italic", "LiberationSerif-Italic", "NimbusRomNo9L-ReguItal", "DroidSerif-Italic"}));
            substitutes.put("Times-BoldItalic", Arrays.asList(new String[]{"TimesNewRomanPS-BoldItalicMT", "TimesNewRomanPS-BoldItalic", "TimesNewRoman-BoldItalic", "LiberationSerif-BoldItalic", "NimbusRomNo9L-MediItal", "DroidSerif-BoldItalic"}));
            substitutes.put("Symbol", Arrays.asList(new String[]{"SymbolMT", "StandardSymL"}));
            substitutes.put("ZapfDingbats", Arrays.asList(new String[]{"ZapfDingbatsITC", "Dingbats"}));
            substitutes.put("$Adobe-CNS1", Arrays.asList(new String[]{"AdobeMingStd-Light"}));
            substitutes.put("$Adobe-Japan1", Arrays.asList(new String[]{"KozMinPr6N-Regular"}));
            substitutes.put("$Adobe-Korea1", Arrays.asList(new String[]{"AdobeGothicStd-Bold"}));
            substitutes.put("$Adobe-GB1", Arrays.asList(new String[]{"AdobeHeitiStd-Regular"}));
            for (String next : Standard14Fonts.getNames()) {
                if (!substitutes.containsKey(next)) {
                    substitutes.put(next, copySubstitutes(Standard14Fonts.getMappedFontName(next)));
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void addSubstitute(String str, String str2) {
        if (!substitutes.containsKey(str)) {
            substitutes.put(str, new ArrayList());
        }
        substitutes.get(str).add(str2);
    }

    public static List<String> copySubstitutes(String str) {
        return new ArrayList(substitutes.get(str));
    }

    public static CFFCIDFont getCFFCIDFont(String str) {
        CFFFont cFFFont = getCFFFont(str);
        if (cFFFont instanceof CFFCIDFont) {
            return (CFFCIDFont) cFFFont;
        }
        return null;
    }

    public static CFFCIDFont getCFFCIDFontFallback(String str, PDFontDescriptor pDFontDescriptor) {
        if (str != null) {
            for (String cFFFont : getSubstitutes(SFSBuddyVariable.OFFLINE_PREFIX + str)) {
                CFFFont cFFFont2 = getProvider().getCFFFont(cFFFont);
                if (cFFFont2 instanceof CFFCIDFont) {
                    return (CFFCIDFont) cFFFont2;
                }
            }
        }
        return cidFallbackFont;
    }

    public static CFFFont getCFFFont(String str) {
        CFFFont cFFFont = getProvider().getCFFFont(str);
        if (cFFFont == null) {
            for (String cFFFont2 : getSubstitutes(str)) {
                CFFFont cFFFont3 = getProvider().getCFFFont(cFFFont2);
                if (cFFFont3 != null) {
                    return cFFFont3;
                }
            }
            cFFFont = getProvider().getCFFFont(windowsToPs(str));
        }
        return cFFFont;
    }

    public static CFFType1Font getCFFType1Font(String str) {
        CFFFont cFFFont = getCFFFont(str);
        if (cFFFont instanceof CFFType1Font) {
            return (CFFType1Font) cFFFont;
        }
        return null;
    }

    public static String getFallbackFontName(PDFontDescriptor pDFontDescriptor) {
        String str;
        if (pDFontDescriptor == null) {
            return "Times-Roman";
        }
        boolean z = false;
        if (pDFontDescriptor.getFontName() != null) {
            String lowerCase = pDFontDescriptor.getFontName().toLowerCase();
            if (lowerCase.contains("bold") || lowerCase.contains("black") || lowerCase.contains("heavy")) {
                z = true;
            }
        }
        if (pDFontDescriptor.isFixedPitch()) {
            str = (!z || !pDFontDescriptor.isItalic()) ? z ? "Courier-Bold" : pDFontDescriptor.isItalic() ? "Courier-Oblique" : "Courier" : "Courier-BoldOblique";
        } else if (!pDFontDescriptor.isSerif()) {
            str = (!z || !pDFontDescriptor.isItalic()) ? z ? "Helvetica-Bold" : pDFontDescriptor.isItalic() ? "Helvetica-Oblique" : "Helvetica" : "Helvetica-BoldOblique";
        } else if (z && pDFontDescriptor.isItalic()) {
            str = "Times-BoldItalic";
        } else if (z) {
            str = "Times-Bold";
        } else if (!pDFontDescriptor.isItalic()) {
            return "Times-Roman";
        } else {
            str = "Times-Italic";
        }
        return str;
    }

    public static FontProvider getProvider() {
        if (fontProvider == null) {
            fontProvider = DefaultFontProvider.INSTANCE;
        }
        return fontProvider;
    }

    public static List<String> getSubstitutes(String str) {
        List<String> list = substitutes.get(str.replaceAll(CMap.SPACE, ""));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public static TrueTypeFont getTrueTypeFallbackFont(PDFontDescriptor pDFontDescriptor) {
        TrueTypeFont trueTypeFont = getTrueTypeFont(getFallbackFontName(pDFontDescriptor));
        return trueTypeFont == null ? ttfFallbackFont : trueTypeFont;
    }

    public static TrueTypeFont getTrueTypeFont(String str) {
        TrueTypeFont trueTypeFont = getProvider().getTrueTypeFont(str);
        if (trueTypeFont == null) {
            for (String trueTypeFont2 : getSubstitutes(str)) {
                TrueTypeFont trueTypeFont3 = getProvider().getTrueTypeFont(trueTypeFont2);
                if (trueTypeFont3 != null) {
                    return trueTypeFont3;
                }
            }
            trueTypeFont = getProvider().getTrueTypeFont(windowsToPs(str));
        }
        return trueTypeFont;
    }

    public static Type1Equivalent getType1EquivalentFont(String str) {
        Type1Font type1Font = getType1Font(str);
        if (type1Font != null) {
            return type1Font;
        }
        CFFType1Font cFFType1Font = getCFFType1Font(str);
        if (cFFType1Font != null) {
            return cFFType1Font;
        }
        TrueTypeFont trueTypeFont = getTrueTypeFont(str);
        if (trueTypeFont != null) {
            return trueTypeFont;
        }
        return null;
    }

    public static Type1Equivalent getType1FallbackFont(PDFontDescriptor pDFontDescriptor) {
        Type1Equivalent type1EquivalentFont = getType1EquivalentFont(getFallbackFontName(pDFontDescriptor));
        return type1EquivalentFont == null ? ttfFallbackFont : type1EquivalentFont;
    }

    public static Type1Font getType1Font(String str) {
        Type1Font type1Font = getProvider().getType1Font(str);
        if (type1Font == null) {
            for (String type1Font2 : getSubstitutes(str)) {
                Type1Font type1Font3 = getProvider().getType1Font(type1Font2);
                if (type1Font3 != null) {
                    return type1Font3;
                }
            }
            type1Font = getProvider().getType1Font(windowsToPs(str));
        }
        return type1Font;
    }

    public static void setProvider(FontProvider fontProvider2) {
        fontProvider = fontProvider2;
    }

    public static String windowsToPs(String str) {
        return str.replaceAll(",", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }
}
