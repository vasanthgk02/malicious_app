package org.apache.pdfbox.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFHighlighter extends PDFTextStripper {
    public static final String ENCODING = "UTF-16";
    public Writer highlighterOutput = null;
    public String[] searchedWords;
    public ByteArrayOutputStream textOS = null;
    public Writer textWriter = null;

    public PDFHighlighter() throws IOException {
        super.setLineSeparator("");
        super.setWordSeparator("");
        super.setShouldSeparateByBeads(false);
        super.setSuppressDuplicateOverlappingText(false);
    }

    public static void main(String[] strArr) throws IOException {
        PDFHighlighter pDFHighlighter = new PDFHighlighter();
        PDDocument pDDocument = null;
        try {
            if (strArr.length < 2) {
                usage();
            }
            int length = strArr.length - 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 1, strArr2, 0, length);
            pDDocument = PDDocument.load(new File(strArr[0]));
            pDFHighlighter.generateXMLHighlight(pDDocument, strArr2, (Writer) new OutputStreamWriter(System.out));
        } finally {
            if (pDDocument != null) {
                pDDocument.close();
            }
        }
    }

    public static void usage() {
        PrintStream printStream = System.err;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("usage: java ");
        outline73.append(PDFHighlighter.class.getName());
        outline73.append(" <pdf file> word1 word2 word3 ...");
        printStream.println(outline73.toString());
        System.exit(1);
    }

    public void endPage(PDPage pDPage) throws IOException {
        this.textWriter.flush();
        String str = new String(this.textOS.toByteArray(), "UTF-16");
        this.textOS.reset();
        if (str.indexOf(97) != -1) {
            str = str.replaceAll("a[0-9]{1,3}", ".");
        }
        for (String compile : this.searchedWords) {
            Matcher matcher = Pattern.compile(compile, 2).matcher(str);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                Writer writer = this.highlighterOutput;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("    <loc pg=");
                outline73.append(getCurrentPageNo() - 1);
                outline73.append(" pos=");
                outline73.append(start);
                outline73.append(" len=");
                outline73.append(end - start);
                outline73.append(">\n");
                writer.write(outline73.toString());
            }
        }
    }

    public void generateXMLHighlight(PDDocument pDDocument, String str, Writer writer) throws IOException {
        generateXMLHighlight(pDDocument, new String[]{str}, writer);
    }

    public void generateXMLHighlight(PDDocument pDDocument, String[] strArr, Writer writer) throws IOException {
        this.highlighterOutput = writer;
        this.searchedWords = strArr;
        writer.write("<XML>\n<Body units=characters  version=2>\n<Highlight>\n");
        this.textOS = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.textOS, "UTF-16");
        this.textWriter = outputStreamWriter;
        writeText(pDDocument, outputStreamWriter);
        this.highlighterOutput.write("</Highlight>\n</Body>\n</XML>");
        this.highlighterOutput.flush();
    }
}
