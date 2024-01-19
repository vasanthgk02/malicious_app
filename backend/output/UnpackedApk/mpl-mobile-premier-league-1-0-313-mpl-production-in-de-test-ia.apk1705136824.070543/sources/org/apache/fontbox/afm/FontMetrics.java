package org.apache.fontbox.afm;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.util.BoundingBox;

public class FontMetrics {
    public float afmVersion;
    public float ascender;
    public float capHeight;
    public List<CharMetric> charMetrics = new ArrayList();
    public final Map<String, CharMetric> charMetricsMap = new HashMap();
    public float[] charWidth;
    public String characterSet;
    public int characters;
    public final List<String> comments = new ArrayList();
    public List<Composite> composites = new ArrayList();
    public float descender;
    public String encodingScheme;
    public int escChar;
    public String familyName;
    public BoundingBox fontBBox;
    public String fontName;
    public String fontVersion;
    public String fullName;
    public boolean isBaseFont;
    public boolean isFixedPitch;
    public boolean isFixedV;
    public float italicAngle;
    public List<KernPair> kernPairs = new ArrayList();
    public List<KernPair> kernPairs0 = new ArrayList();
    public List<KernPair> kernPairs1 = new ArrayList();
    public int mappingScheme;
    public int metricSets = 0;
    public String notice;
    public float standardHorizontalWidth;
    public float standardVerticalWidth;
    public List<TrackKern> trackKern = new ArrayList();
    public float underlinePosition;
    public float underlineThickness;
    public float[] vVector;
    public String weight;
    public float xHeight;

    public void addCharMetric(CharMetric charMetric) {
        this.charMetrics.add(charMetric);
        this.charMetricsMap.put(charMetric.getName(), charMetric);
    }

    public void addComment(String str) {
        this.comments.add(str);
    }

    public void addComposite(Composite composite) {
        this.composites.add(composite);
    }

    public void addKernPair(KernPair kernPair) {
        this.kernPairs.add(kernPair);
    }

    public void addKernPair0(KernPair kernPair) {
        this.kernPairs0.add(kernPair);
    }

    public void addKernPair1(KernPair kernPair) {
        this.kernPairs1.add(kernPair);
    }

    public void addTrackKern(TrackKern trackKern2) {
        this.trackKern.add(trackKern2);
    }

    public float getAFMVersion() {
        return this.afmVersion;
    }

    public float getAscender() {
        return this.ascender;
    }

    public float getAverageCharacterWidth() {
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (CharMetric next : this.charMetricsMap.values()) {
            if (next.getWx() > 0.0f) {
                f2 += next.getWx();
                f3 += 1.0f;
            }
        }
        if (f2 > 0.0f) {
            return f2 / f3;
        }
        return 0.0f;
    }

    public float getCapHeight() {
        return this.capHeight;
    }

    public List<CharMetric> getCharMetrics() {
        return this.charMetrics;
    }

    public float[] getCharWidth() {
        return this.charWidth;
    }

    public float getCharacterHeight(String str) {
        CharMetric charMetric = this.charMetricsMap.get(str);
        if (charMetric == null) {
            return 0.0f;
        }
        if (charMetric.getWy() == 0.0f) {
            return charMetric.getBoundingBox().getHeight();
        }
        return charMetric.getWy();
    }

    public String getCharacterSet() {
        return this.characterSet;
    }

    public float getCharacterWidth(String str) {
        CharMetric charMetric = this.charMetricsMap.get(str);
        if (charMetric == null) {
            return 0.0f;
        }
        return charMetric.getWx();
    }

    public int getCharacters() {
        return this.characters;
    }

    public List<String> getComments() {
        return this.comments;
    }

    public List<Composite> getComposites() {
        return this.composites;
    }

    public float getDescender() {
        return this.descender;
    }

    public String getEncodingScheme() {
        return this.encodingScheme;
    }

    public int getEscChar() {
        return this.escChar;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public BoundingBox getFontBBox() {
        return this.fontBBox;
    }

    public String getFontName() {
        return this.fontName;
    }

    public String getFontVersion() {
        return this.fontVersion;
    }

    public String getFullName() {
        return this.fullName;
    }

    public float getItalicAngle() {
        return this.italicAngle;
    }

    public List<KernPair> getKernPairs() {
        return this.kernPairs;
    }

    public List<KernPair> getKernPairs0() {
        return this.kernPairs0;
    }

    public List<KernPair> getKernPairs1() {
        return this.kernPairs1;
    }

    public int getMappingScheme() {
        return this.mappingScheme;
    }

    public int getMetricSets() {
        return this.metricSets;
    }

    public String getNotice() {
        return this.notice;
    }

    public float getStandardHorizontalWidth() {
        return this.standardHorizontalWidth;
    }

    public float getStandardVerticalWidth() {
        return this.standardVerticalWidth;
    }

    public List<TrackKern> getTrackKern() {
        return this.trackKern;
    }

    public float getUnderlinePosition() {
        return this.underlinePosition;
    }

    public float getUnderlineThickness() {
        return this.underlineThickness;
    }

    public float[] getVVector() {
        return this.vVector;
    }

    public String getWeight() {
        return this.weight;
    }

    public float getXHeight() {
        return this.xHeight;
    }

    public boolean isBaseFont() {
        return this.isBaseFont;
    }

    public boolean isFixedPitch() {
        return this.isFixedPitch;
    }

    public boolean isFixedV() {
        return this.isFixedV;
    }

    public void setAFMVersion(float f2) {
        this.afmVersion = f2;
    }

    public void setAscender(float f2) {
        this.ascender = f2;
    }

    public void setCapHeight(float f2) {
        this.capHeight = f2;
    }

    public void setCharMetrics(List<CharMetric> list) {
        this.charMetrics = list;
    }

    public void setCharWidth(float[] fArr) {
        this.charWidth = fArr;
    }

    public void setCharacterSet(String str) {
        this.characterSet = str;
    }

    public void setCharacters(int i) {
        this.characters = i;
    }

    public void setComposites(List<Composite> list) {
        this.composites = list;
    }

    public void setDescender(float f2) {
        this.descender = f2;
    }

    public void setEncodingScheme(String str) {
        this.encodingScheme = str;
    }

    public void setEscChar(int i) {
        this.escChar = i;
    }

    public void setFamilyName(String str) {
        this.familyName = str;
    }

    public void setFixedPitch(boolean z) {
        this.isFixedPitch = z;
    }

    public void setFontBBox(BoundingBox boundingBox) {
        this.fontBBox = boundingBox;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }

    public void setFontVersion(String str) {
        this.fontVersion = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setIsBaseFont(boolean z) {
        this.isBaseFont = z;
    }

    public void setIsFixedV(boolean z) {
        this.isFixedV = z;
    }

    public void setItalicAngle(float f2) {
        this.italicAngle = f2;
    }

    public void setKernPairs(List<KernPair> list) {
        this.kernPairs = list;
    }

    public void setKernPairs0(List<KernPair> list) {
        this.kernPairs0 = list;
    }

    public void setKernPairs1(List<KernPair> list) {
        this.kernPairs1 = list;
    }

    public void setMappingScheme(int i) {
        this.mappingScheme = i;
    }

    public void setMetricSets(int i) {
        if (i < 0 || i > 2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline42("The metricSets attribute must be in the set {0,1,2} and not '", i, "'"));
        }
        this.metricSets = i;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setStandardHorizontalWidth(float f2) {
        this.standardHorizontalWidth = f2;
    }

    public void setStandardVerticalWidth(float f2) {
        this.standardVerticalWidth = f2;
    }

    public void setTrackKern(List<TrackKern> list) {
        this.trackKern = list;
    }

    public void setUnderlinePosition(float f2) {
        this.underlinePosition = f2;
    }

    public void setUnderlineThickness(float f2) {
        this.underlineThickness = f2;
    }

    public void setVVector(float[] fArr) {
        this.vVector = fArr;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public void setXHeight(float f2) {
        this.xHeight = f2;
    }
}
