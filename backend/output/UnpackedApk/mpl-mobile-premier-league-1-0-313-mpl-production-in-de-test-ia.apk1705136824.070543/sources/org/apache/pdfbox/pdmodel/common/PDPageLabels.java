package org.apache.pdfbox.pdmodel.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.game.InviteUsersRequest;

public class PDPageLabels implements COSObjectable {
    public PDDocument doc;
    public Map<Integer, PDPageLabelRange> labels;

    public static class LabelGenerator implements Iterator<String> {
        public static final String[][] ROMANS = {new String[]{"", "i", InviteUsersRequest.KEY_INVITATION_ID, "iii", "iv", "v", "vi", "vii", "viii", "ix"}, new String[]{"", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", CreateRoomRequest.KEY_EXTCLASS}, new String[]{"", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm"}};
        public int currentPage = 0;
        public final PDPageLabelRange labelInfo;
        public final int numPages;

        public LabelGenerator(PDPageLabelRange pDPageLabelRange, int i) {
            this.labelInfo = pDPageLabelRange;
            this.numPages = i;
        }

        private String getNumber(int i, String str) {
            if ("D".equals(str)) {
                return Integer.toString(i);
            }
            if ("a".equals(str)) {
                return makeLetterLabel(i);
            }
            if ("A".equals(str)) {
                return makeLetterLabel(i).toUpperCase();
            }
            if ("r".equals(str)) {
                return makeRomanLabel(i);
            }
            if ("R".equals(str)) {
                return makeRomanLabel(i).toUpperCase();
            }
            return Integer.toString(i);
        }

        public static String makeLetterLabel(int i) {
            StringBuilder sb = new StringBuilder();
            int i2 = i / 26;
            int i3 = i % 26;
            int signum = Integer.signum(i3) + i2;
            int signum2 = ((1 - Integer.signum(i3)) * 26) + i3 + 64;
            for (int i4 = 0; i4 < signum; i4++) {
                sb.appendCodePoint(signum2);
            }
            return sb.toString();
        }

        public static String makeRomanLabel(int i) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 3 && i > 0; i2++) {
                sb.insert(0, ROMANS[i2][i % 10]);
                i /= 10;
            }
            for (int i3 = 0; i3 < i; i3++) {
                sb.insert(0, 'm');
            }
            return sb.toString();
        }

        public boolean hasNext() {
            return this.currentPage < this.numPages;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public String next() {
            if (hasNext()) {
                StringBuilder sb = new StringBuilder();
                if (this.labelInfo.getPrefix() != null) {
                    String prefix = this.labelInfo.getPrefix();
                    while (prefix.lastIndexOf(0) != -1) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                    }
                    sb.append(prefix);
                }
                if (this.labelInfo.getStyle() != null) {
                    sb.append(getNumber(this.labelInfo.getStart() + this.currentPage, this.labelInfo.getStyle()));
                }
                this.currentPage++;
                return sb.toString();
            }
            throw new NoSuchElementException();
        }
    }

    public interface LabelHandler {
        void newLabel(int i, String str);
    }

    public PDPageLabels(PDDocument pDDocument) {
        this.labels = new TreeMap();
        this.doc = pDDocument;
        PDPageLabelRange pDPageLabelRange = new PDPageLabelRange();
        pDPageLabelRange.setStyle("D");
        this.labels.put(Integer.valueOf(0), pDPageLabelRange);
    }

    private void computeLabels(LabelHandler labelHandler) {
        Iterator<Entry<Integer, PDPageLabelRange>> it = this.labels.entrySet().iterator();
        if (it.hasNext()) {
            int i = 0;
            Entry next = it.next();
            while (it.hasNext()) {
                Entry next2 = it.next();
                LabelGenerator labelGenerator = new LabelGenerator((PDPageLabelRange) next.getValue(), ((Integer) next2.getKey()).intValue() - ((Integer) next.getKey()).intValue());
                while (labelGenerator.hasNext()) {
                    labelHandler.newLabel(i, labelGenerator.next());
                    i++;
                }
                next = next2;
            }
            LabelGenerator labelGenerator2 = new LabelGenerator((PDPageLabelRange) next.getValue(), this.doc.getNumberOfPages() - ((Integer) next.getKey()).intValue());
            while (labelGenerator2.hasNext()) {
                labelHandler.newLabel(i, labelGenerator2.next());
                i++;
            }
        }
    }

    private void findLabels(PDNumberTreeNode pDNumberTreeNode) throws IOException {
        if (pDNumberTreeNode.getKids() != null) {
            for (PDNumberTreeNode findLabels : pDNumberTreeNode.getKids()) {
                findLabels(findLabels);
            }
        } else if (pDNumberTreeNode.getNumbers() != null) {
            for (Entry next : pDNumberTreeNode.getNumbers().entrySet()) {
                if (((Integer) next.getKey()).intValue() >= 0) {
                    this.labels.put(next.getKey(), new PDPageLabelRange((COSDictionary) next.getValue()));
                }
            }
        }
    }

    public COSBase getCOSObject() {
        COSDictionary cOSDictionary = new COSDictionary();
        COSArray cOSArray = new COSArray();
        for (Entry next : this.labels.entrySet()) {
            cOSArray.add((COSBase) COSInteger.get((long) ((Integer) next.getKey()).intValue()));
            cOSArray.add((COSObjectable) next.getValue());
        }
        cOSDictionary.setItem(COSName.NUMS, (COSBase) cOSArray);
        return cOSDictionary;
    }

    public String[] getLabelsByPageIndices() {
        final String[] strArr = new String[this.doc.getNumberOfPages()];
        computeLabels(new LabelHandler() {
            public void newLabel(int i, String str) {
                if (i < PDPageLabels.this.doc.getNumberOfPages()) {
                    strArr[i] = str;
                }
            }
        });
        return strArr;
    }

    public Map<String, Integer> getPageIndicesByLabels() {
        final HashMap hashMap = new HashMap(this.doc.getNumberOfPages());
        computeLabels(new LabelHandler() {
            public void newLabel(int i, String str) {
                hashMap.put(str, Integer.valueOf(i));
            }
        });
        return hashMap;
    }

    public PDPageLabelRange getPageLabelRange(int i) {
        return this.labels.get(Integer.valueOf(i));
    }

    public int getPageRangeCount() {
        return this.labels.size();
    }

    public void setLabelItem(int i, PDPageLabelRange pDPageLabelRange) {
        if (i >= 0) {
            this.labels.put(Integer.valueOf(i), pDPageLabelRange);
            return;
        }
        throw new IllegalArgumentException("startPage parameter of setLabelItem may not be < 0");
    }

    public PDPageLabels(PDDocument pDDocument, COSDictionary cOSDictionary) throws IOException {
        this(pDDocument);
        if (cOSDictionary != null) {
            findLabels(new PDNumberTreeNode(cOSDictionary, COSDictionary.class));
        }
    }
}
