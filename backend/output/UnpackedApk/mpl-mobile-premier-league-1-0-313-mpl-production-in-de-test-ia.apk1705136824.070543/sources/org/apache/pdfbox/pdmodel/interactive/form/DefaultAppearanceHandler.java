package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdfparser.PDFStreamParser;

public class DefaultAppearanceHandler {
    public List<Object> appearanceTokens;

    public DefaultAppearanceHandler(String str) throws IOException {
        this.appearanceTokens = getStreamTokens(str);
    }

    private List<Object> getStreamTokens(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            return arrayList;
        }
        PDFStreamParser pDFStreamParser = new PDFStreamParser((InputStream) new ByteArrayInputStream(str.getBytes()));
        pDFStreamParser.parse();
        List<Object> tokens = pDFStreamParser.getTokens();
        pDFStreamParser.close();
        return tokens;
    }

    public COSName getFontName() {
        return (COSName) this.appearanceTokens.get(this.appearanceTokens.indexOf(Operator.getOperator("Tf")) - 2);
    }

    public float getFontSize() {
        if (!this.appearanceTokens.isEmpty()) {
            int indexOf = this.appearanceTokens.indexOf(Operator.getOperator("Tf"));
            if (indexOf != -1) {
                return ((COSNumber) this.appearanceTokens.get(indexOf - 1)).floatValue();
            }
        }
        return 0.0f;
    }

    public List<Object> getTokens() {
        return this.appearanceTokens;
    }

    public void setFontSize(float f2) {
        int indexOf = this.appearanceTokens.indexOf(Operator.getOperator("Tf"));
        if (indexOf != -1) {
            this.appearanceTokens.set(indexOf - 1, new COSFloat(f2));
        }
    }
}
