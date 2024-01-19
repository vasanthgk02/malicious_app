package org.apache.pdfbox.pdfwriter;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map.Entry;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;

public class ContentStreamWriter {
    public static final byte[] EOL = {10};
    public static final byte[] SPACE = {32};
    public OutputStream output;

    public ContentStreamWriter(OutputStream outputStream) {
        this.output = outputStream;
    }

    private void writeObject(Object obj) throws IOException {
        if (obj instanceof COSString) {
            COSWriter.writeString((COSString) obj, this.output);
        } else if (obj instanceof COSFloat) {
            ((COSFloat) obj).writePDF(this.output);
        } else if (obj instanceof COSInteger) {
            ((COSInteger) obj).writePDF(this.output);
        } else if (obj instanceof COSBoolean) {
            ((COSBoolean) obj).writePDF(this.output);
        } else if (obj instanceof COSName) {
            ((COSName) obj).writePDF(this.output);
        } else if (obj instanceof COSArray) {
            COSArray cOSArray = (COSArray) obj;
            this.output.write(COSWriter.ARRAY_OPEN);
            for (int i = 0; i < cOSArray.size(); i++) {
                writeObject(cOSArray.get(i));
                this.output.write(SPACE);
            }
            this.output.write(COSWriter.ARRAY_CLOSE);
        } else if (obj instanceof COSDictionary) {
            this.output.write(COSWriter.DICT_OPEN);
            for (Entry next : ((COSDictionary) obj).entrySet()) {
                if (next.getValue() != null) {
                    writeObject(next.getKey());
                    this.output.write(SPACE);
                    writeObject(next.getValue());
                    this.output.write(SPACE);
                }
            }
            this.output.write(COSWriter.DICT_CLOSE);
            this.output.write(SPACE);
        } else if (obj instanceof Operator) {
            Operator operator = (Operator) obj;
            if (operator.getName().equals("BI")) {
                this.output.write("BI".getBytes("ISO-8859-1"));
                COSDictionary imageParameters = operator.getImageParameters();
                for (COSName next2 : imageParameters.keySet()) {
                    COSBase dictionaryObject = imageParameters.getDictionaryObject(next2);
                    next2.writePDF(this.output);
                    this.output.write(SPACE);
                    writeObject(dictionaryObject);
                    this.output.write(EOL);
                }
                this.output.write("ID".getBytes("ISO-8859-1"));
                this.output.write(EOL);
                this.output.write(operator.getImageData());
                return;
            }
            this.output.write(operator.getName().getBytes("ISO-8859-1"));
            this.output.write(EOL);
        } else {
            throw new IOException(GeneratedOutlineSupport.outline48("Error:Unknown type in content stream:", obj));
        }
    }

    public void writeTokens(List list, int i, int i2) throws IOException {
        while (i < i2) {
            writeObject(list.get(i));
            this.output.write(32);
            i++;
        }
        this.output.flush();
    }

    public void writeTokens(List list) throws IOException {
        writeTokens(list, 0, list.size());
    }
}
