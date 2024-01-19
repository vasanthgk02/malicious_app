package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.Charsets;

public class AppearancePrimitivesComposer {
    public final NumberFormat formatDecimal = NumberFormat.getNumberInstance(Locale.US);
    public boolean inTextMode = false;
    public final OutputStream outputstream;

    public AppearancePrimitivesComposer(OutputStream outputStream) {
        this.outputstream = outputStream;
    }

    private void write(String str) throws IOException {
        this.outputstream.write(str.getBytes(Charsets.US_ASCII));
    }

    private void writeOperand(float f2) throws IOException {
        write(this.formatDecimal.format((double) f2));
        this.outputstream.write(32);
    }

    private void writeOperator(String str) throws IOException {
        this.outputstream.write(str.getBytes(Charsets.US_ASCII));
        this.outputstream.write(10);
    }

    public void addRect(PDRectangle pDRectangle) throws IOException {
        addRect(pDRectangle.getLowerLeftX(), pDRectangle.getLowerLeftY(), pDRectangle.getWidth(), pDRectangle.getHeight());
    }

    public void beginText() throws IOException {
        if (!this.inTextMode) {
            writeOperator("BT");
            this.inTextMode = true;
            return;
        }
        throw new IOException("Error: Nested beginText() calls are not allowed.");
    }

    public void clip() throws IOException {
        if (!this.inTextMode) {
            writeOperator("W");
            writeOperator("n");
            return;
        }
        throw new IOException("Error: clip is not allowed within a text block.");
    }

    public void endText() throws IOException {
        if (this.inTextMode) {
            writeOperator("ET");
            this.inTextMode = false;
            return;
        }
        throw new IOException("Error: You must call beginText() before calling endText.");
    }

    public void newLineAtOffset(float f2, float f3) throws IOException {
        writeOperand(f2);
        writeOperand(f3);
        writeOperator("Td");
    }

    public void showText(String str, PDFont pDFont) throws IOException {
        COSWriter.writeString(pDFont.encode(str), this.outputstream);
        write(CMap.SPACE);
        writeOperator("Tj");
    }

    public void addRect(float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator("re");
            return;
        }
        throw new IOException("Error: addRect is not allowed within a text block.");
    }
}
