package org.apache.pdfbox.pdmodel.font;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.pdfbox.util.Charsets;

public final class ToUnicodeWriter {
    public final Map<Integer, String> cidToUnicode = new TreeMap();
    public int wMode = 0;

    private String stringToHex(String str) {
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : str.getBytes(Charsets.UTF_16BE)) {
            sb.append(String.format("%02X", new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }

    private String toHex(int i) {
        return String.format("%04X", new Object[]{Integer.valueOf(i)});
    }

    private void writeLine(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.write(10);
    }

    public void add(int i, String str) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("CID is not valid");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        } else {
            this.cidToUnicode.put(Integer.valueOf(i), str);
        }
    }

    public void setWMode(int i) {
        this.wMode = i;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charsets.US_ASCII));
        writeLine(bufferedWriter, "/CIDInit /ProcSet findresource begin");
        writeLine(bufferedWriter, "12 dict begin\n");
        writeLine(bufferedWriter, "begincmap");
        writeLine(bufferedWriter, "/CIDSystemInfo");
        writeLine(bufferedWriter, "<< /Registry ()");
        writeLine(bufferedWriter, "/Ordering ()");
        writeLine(bufferedWriter, "/Supplement ");
        writeLine(bufferedWriter, ">> def\n");
        writeLine(bufferedWriter, "/CMapName /Adobe-Identity-UCS def");
        writeLine(bufferedWriter, "/CMapType 2 def\n");
        if (this.wMode != 0) {
            writeLine(bufferedWriter, GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("/WMode /"), this.wMode, " def"));
        }
        writeLine(bufferedWriter, "1 begincodespacerange");
        writeLine(bufferedWriter, "<0000> <FFFF>");
        writeLine(bufferedWriter, "endcodespacerange\n");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String str = null;
        int i = -1;
        int i2 = -1;
        for (Entry next : this.cidToUnicode.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            String str2 = (String) next.getValue();
            if (intValue == i + 1 && str.codePointCount(0, str.length()) == 1 && str2.codePointAt(0) == str.codePointAt(0) + 1 && str.codePointAt(0) + 1 <= 255 - (intValue - i2)) {
                arrayList2.set(arrayList2.size() - 1, Integer.valueOf(intValue));
            } else {
                arrayList.add(Integer.valueOf(intValue));
                arrayList2.add(Integer.valueOf(intValue));
                arrayList3.add(str2);
                i2 = intValue;
            }
            str = str2;
            i = intValue;
        }
        int ceil = (int) Math.ceil(((double) arrayList.size()) / 100.0d);
        for (int i3 = 0; i3 < ceil; i3++) {
            int i4 = 100;
            if (i3 == ceil - 1) {
                i4 = arrayList.size() % 100;
            }
            bufferedWriter.write(i4 + " beginbfrange\n");
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i3 * 100) + i5;
                bufferedWriter.write(60);
                bufferedWriter.write(toHex(((Integer) arrayList.get(i6)).intValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write(60);
                bufferedWriter.write(toHex(((Integer) arrayList2.get(i6)).intValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write("<");
                bufferedWriter.write(stringToHex((String) arrayList3.get(i6)));
                bufferedWriter.write(">\n");
            }
            writeLine(bufferedWriter, "endbfrange\n");
        }
        writeLine(bufferedWriter, "endcmap");
        writeLine(bufferedWriter, "CMapName currentdict /CMap defineresource pop");
        writeLine(bufferedWriter, AnalyticsConstants.END);
        writeLine(bufferedWriter, AnalyticsConstants.END);
        bufferedWriter.flush();
    }
}
