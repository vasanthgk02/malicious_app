package org.apache.fontbox.ttf;

import android.graphics.Path;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.encoding.Encoding;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.util.awt.AffineTransform;

public class TrueTypeFont implements Type1Equivalent {
    public TTFDataStream data;
    public int numberOfGlyphs = -1;
    public Map<String, Integer> postScriptNames;
    public Map<String, TTFTable> tables = new HashMap();
    public int unitsPerEm = -1;
    public float version;

    public TrueTypeFont(TTFDataStream tTFDataStream) {
        this.data = tTFDataStream;
    }

    private int parseUniName(String str) throws IOException {
        if (str.startsWith("uni") && str.length() == 7) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i = 3;
            while (true) {
                int i2 = i + 4;
                if (i2 > length) {
                    break;
                }
                try {
                    int parseInt = Integer.parseInt(str.substring(i, i2), 16);
                    if (parseInt <= 55295 || parseInt >= 57344) {
                        sb.append((char) parseInt);
                    }
                    i = i2;
                } catch (NumberFormatException unused) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                return -1;
            }
            return sb2.codePointAt(0);
        }
        return -1;
    }

    private synchronized void readPostScriptNames() throws IOException {
        if (this.postScriptNames == null) {
            this.postScriptNames = new HashMap();
            if (getPostScript() != null) {
                String[] glyphNames = getPostScript().getGlyphNames();
                if (glyphNames != null) {
                    for (int i = 0; i < glyphNames.length; i++) {
                        this.postScriptNames.put(glyphNames[i], Integer.valueOf(i));
                    }
                }
            }
        }
    }

    public void addTable(TTFTable tTFTable) {
        this.tables.put(tTFTable.getTag(), tTFTable);
    }

    public void close() throws IOException {
        this.data.close();
    }

    public int getAdvanceWidth(int i) throws IOException {
        HorizontalMetricsTable horizontalMetrics = getHorizontalMetrics();
        if (horizontalMetrics != null) {
            return horizontalMetrics.getAdvanceWidth(i);
        }
        return 250;
    }

    public synchronized CmapTable getCmap() throws IOException {
        CmapTable cmapTable;
        cmapTable = (CmapTable) this.tables.get(CmapTable.TAG);
        if (cmapTable != null && !cmapTable.getInitialized()) {
            readTable(cmapTable);
        }
        return cmapTable;
    }

    public Encoding getEncoding() {
        return null;
    }

    public BoundingBox getFontBBox() throws IOException {
        short xMin = getHeader().getXMin();
        short xMax = getHeader().getXMax();
        short yMin = getHeader().getYMin();
        short yMax = getHeader().getYMax();
        float unitsPerEm2 = 1000.0f / ((float) getUnitsPerEm());
        return new BoundingBox(((float) xMin) * unitsPerEm2, ((float) yMin) * unitsPerEm2, ((float) xMax) * unitsPerEm2, ((float) yMax) * unitsPerEm2);
    }

    public synchronized GlyphTable getGlyph() throws IOException {
        GlyphTable glyphTable;
        glyphTable = (GlyphTable) this.tables.get(GlyphTable.TAG);
        if (glyphTable != null && !glyphTable.getInitialized()) {
            readTable(glyphTable);
        }
        return glyphTable;
    }

    public synchronized HeaderTable getHeader() throws IOException {
        HeaderTable headerTable;
        headerTable = (HeaderTable) this.tables.get(HeaderTable.TAG);
        if (headerTable != null && !headerTable.getInitialized()) {
            readTable(headerTable);
        }
        return headerTable;
    }

    public synchronized HorizontalHeaderTable getHorizontalHeader() throws IOException {
        HorizontalHeaderTable horizontalHeaderTable;
        horizontalHeaderTable = (HorizontalHeaderTable) this.tables.get(HorizontalHeaderTable.TAG);
        if (horizontalHeaderTable != null && !horizontalHeaderTable.getInitialized()) {
            readTable(horizontalHeaderTable);
        }
        return horizontalHeaderTable;
    }

    public synchronized HorizontalMetricsTable getHorizontalMetrics() throws IOException {
        HorizontalMetricsTable horizontalMetricsTable;
        horizontalMetricsTable = (HorizontalMetricsTable) this.tables.get(HorizontalMetricsTable.TAG);
        if (horizontalMetricsTable != null && !horizontalMetricsTable.getInitialized()) {
            readTable(horizontalMetricsTable);
        }
        return horizontalMetricsTable;
    }

    public synchronized IndexToLocationTable getIndexToLocation() throws IOException {
        IndexToLocationTable indexToLocationTable;
        indexToLocationTable = (IndexToLocationTable) this.tables.get(IndexToLocationTable.TAG);
        if (indexToLocationTable != null && !indexToLocationTable.getInitialized()) {
            readTable(indexToLocationTable);
        }
        return indexToLocationTable;
    }

    public synchronized MaximumProfileTable getMaximumProfile() throws IOException {
        MaximumProfileTable maximumProfileTable;
        maximumProfileTable = (MaximumProfileTable) this.tables.get(MaximumProfileTable.TAG);
        if (maximumProfileTable != null && !maximumProfileTable.getInitialized()) {
            readTable(maximumProfileTable);
        }
        return maximumProfileTable;
    }

    public String getName() throws IOException {
        if (getNaming() != null) {
            return getNaming().getPostScriptName();
        }
        return null;
    }

    public synchronized NamingTable getNaming() throws IOException {
        NamingTable namingTable;
        namingTable = (NamingTable) this.tables.get("name");
        if (namingTable != null && !namingTable.getInitialized()) {
            readTable(namingTable);
        }
        return namingTable;
    }

    public int getNumberOfGlyphs() throws IOException {
        if (this.numberOfGlyphs == -1) {
            MaximumProfileTable maximumProfile = getMaximumProfile();
            if (maximumProfile != null) {
                this.numberOfGlyphs = maximumProfile.getNumGlyphs();
            } else {
                this.numberOfGlyphs = 0;
            }
        }
        return this.numberOfGlyphs;
    }

    public synchronized OS2WindowsMetricsTable getOS2Windows() throws IOException {
        OS2WindowsMetricsTable oS2WindowsMetricsTable;
        oS2WindowsMetricsTable = (OS2WindowsMetricsTable) this.tables.get("OS/2");
        if (oS2WindowsMetricsTable != null && !oS2WindowsMetricsTable.getInitialized()) {
            readTable(oS2WindowsMetricsTable);
        }
        return oS2WindowsMetricsTable;
    }

    public InputStream getOriginalData() throws IOException {
        return this.data.getOriginalData();
    }

    public Path getPath(String str) throws IOException {
        readPostScriptNames();
        int nameToGID = nameToGID(str);
        if (nameToGID < 0 || nameToGID >= getMaximumProfile().getNumGlyphs()) {
            nameToGID = 0;
        }
        GlyphData glyph = getGlyph().getGlyph(nameToGID);
        if (glyph == null) {
            return new Path();
        }
        Path path = glyph.getPath();
        double unitsPerEm2 = (double) (1000.0f / ((float) getUnitsPerEm()));
        path.transform(AffineTransform.getScaleInstance(unitsPerEm2, unitsPerEm2).toMatrix());
        return path;
    }

    public synchronized PostScriptTable getPostScript() throws IOException {
        PostScriptTable postScriptTable;
        postScriptTable = (PostScriptTable) this.tables.get("post");
        if (postScriptTable != null && !postScriptTable.getInitialized()) {
            readTable(postScriptTable);
        }
        return postScriptTable;
    }

    public synchronized byte[] getTableBytes(TTFTable tTFTable) throws IOException {
        byte[] read;
        long currentPosition = this.data.getCurrentPosition();
        this.data.seek(tTFTable.getOffset());
        read = this.data.read((int) tTFTable.getLength());
        this.data.seek(currentPosition);
        return read;
    }

    public Map<String, TTFTable> getTableMap() {
        return this.tables;
    }

    public Collection<TTFTable> getTables() {
        return this.tables.values();
    }

    public CmapSubtable getUnicodeCmap() throws IOException {
        return getUnicodeCmap(true);
    }

    public int getUnitsPerEm() throws IOException {
        if (this.unitsPerEm == -1) {
            HeaderTable header = getHeader();
            if (header != null) {
                this.unitsPerEm = header.getUnitsPerEm();
            } else {
                this.unitsPerEm = 0;
            }
        }
        return this.unitsPerEm;
    }

    public float getVersion() {
        return this.version;
    }

    public float getWidth(String str) throws IOException {
        int advanceWidth = getAdvanceWidth(Integer.valueOf(nameToGID(str)).intValue());
        int unitsPerEm2 = getUnitsPerEm();
        if (unitsPerEm2 != 1000) {
            advanceWidth = (int) ((1000.0f / ((float) unitsPerEm2)) * ((float) advanceWidth));
        }
        return (float) advanceWidth;
    }

    public boolean hasGlyph(String str) throws IOException {
        return nameToGID(str) != 0;
    }

    public int nameToGID(String str) throws IOException {
        readPostScriptNames();
        Integer num = this.postScriptNames.get(str);
        if (num != null && num.intValue() > 0 && num.intValue() < getMaximumProfile().getNumGlyphs()) {
            return num.intValue();
        }
        int parseUniName = parseUniName(str);
        if (parseUniName > -1) {
            return getUnicodeCmap(false).getGlyphId(parseUniName);
        }
        return 0;
    }

    public void readTable(TTFTable tTFTable) throws IOException {
        long currentPosition = this.data.getCurrentPosition();
        this.data.seek(tTFTable.getOffset());
        tTFTable.read(this, this.data);
        this.data.seek(currentPosition);
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public String toString() {
        try {
            return getNaming() != null ? getNaming().getPostScriptName() : "(null)";
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("(null - ");
            outline73.append(e2.getMessage());
            outline73.append(")");
            return outline73.toString();
        }
    }

    public CmapSubtable getUnicodeCmap(boolean z) throws IOException {
        CmapTable cmap = getCmap();
        if (cmap == null) {
            return null;
        }
        CmapSubtable subtable = cmap.getSubtable(0, 4);
        if (subtable == null) {
            subtable = cmap.getSubtable(0, 3);
        }
        if (subtable == null) {
            subtable = cmap.getSubtable(3, 1);
        }
        if (subtable == null) {
            subtable = cmap.getSubtable(3, 0);
        }
        if (subtable == null) {
            if (!z) {
                subtable = cmap.getCmaps()[0];
            } else {
                throw new IOException("The TrueType font does not contain a Unicode cmap");
            }
        }
        return subtable;
    }
}
