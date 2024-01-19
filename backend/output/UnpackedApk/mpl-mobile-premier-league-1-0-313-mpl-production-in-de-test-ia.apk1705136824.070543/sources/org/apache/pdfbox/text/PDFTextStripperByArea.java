package org.apache.pdfbox.text;

import android.graphics.RectF;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFTextStripperByArea extends PDFTextStripper {
    public final Map<String, RectF> regionArea = new HashMap();
    public final Map<String, Vector<List<TextPosition>>> regionCharacterList = new HashMap();
    public final Map<String, StringWriter> regionText = new HashMap();
    public final List<String> regions = new ArrayList();

    public void addRegion(String str, RectF rectF) {
        this.regions.add(str);
        this.regionArea.put(str, rectF);
    }

    public void extractRegions(PDPage pDPage) throws IOException {
        for (String next : this.regions) {
            setStartPage(getCurrentPageNo());
            setEndPage(getCurrentPageNo());
            Vector vector = new Vector();
            vector.add(new ArrayList());
            this.regionCharacterList.put(next, vector);
            this.regionText.put(next, new StringWriter());
        }
        if (pDPage.getStream() != null) {
            processPage(pDPage);
        }
    }

    public List<String> getRegions() {
        return this.regions;
    }

    public String getTextForRegion(String str) {
        return this.regionText.get(str).toString();
    }

    public void processTextPosition(TextPosition textPosition) {
        for (String next : this.regionArea.keySet()) {
            if (this.regionArea.get(next).contains(textPosition.getX(), textPosition.getY())) {
                this.charactersByArticle = this.regionCharacterList.get(next);
                super.processTextPosition(textPosition);
            }
        }
    }

    public void writePage() throws IOException {
        for (String next : this.regionArea.keySet()) {
            this.charactersByArticle = this.regionCharacterList.get(next);
            this.output = this.regionText.get(next);
            super.writePage();
        }
    }
}
